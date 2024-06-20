// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stp_ope_fraz_allR implements CallerWithObjs {
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
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
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
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_tmp_stpope_dett_anag;
  public String m_cServer_tmp_stpope_dett_anag;
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public java.sql.Date w_DaDatReg;
  public java.sql.Date w_ADatReg;
  public java.sql.Date w_DaDatRet;
  public java.sql.Date w_ADatRet;
  public String w_EstrazTitEffNelPeriodo;
  public String w_CONNES;
  public String w_TipoOpeStampa;
  public String w_TipoStampa;
  public String w_OrderBy;
  public boolean w_Stp_dist_lire_euro;
  public boolean w_Con_Contanti;
  public String w_Stato;
  public boolean w_Senza_dip;
  public String w_Dipendenza;
  public String w_Ambito;
  public String gFlgDoc;
  public String gDescAzi;
  public double onlyope;
  public double onlyrap;
  public String statoreg;
  public String _connes;
  public java.sql.Date _dataope;
  public java.sql.Date _datareg;
  public java.sql.Date _dataret;
  public String _numsto;
  public String _nomereport;
  public String _ftypes;
  public String _fmodels;
  public String _rotate;
  public String _reportname;
  public String _fonte_arch;
  public String _tipo_arch;
  public double _conta;
  public MemoryCursor_personbo mcSoggetti;
  public MemoryCursorRow_personbo rowSoggetti;
  public MemoryCursor_qbe_operazbo_union_fraziobo_vqr mcFraziobo;
  public MemoryCursorRow_qbe_operazbo_union_fraziobo_vqr rowFraziobo;
  public MemoryCursorRow_qbe_operazbo_union_fraziobo_vqr rwFraziobo;
  public java.sql.Date _datachk;
  public String w_c_dadataope;
  public String w_c_adataope;
  public String w_c_dadatareg;
  public String w_c_adatareg;
  public String w_c_dadataret;
  public String w_c_adataret;
  public double w_StatoLower;
  public double w_StatoUpper;
  public double progrIns;
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
  public boolean _rapcolleg;
  public boolean _xerzistifrz;
  public boolean _xeneficfrz;
  public boolean _xlientifrz;
  public boolean _xogopefbo;
  public boolean _xogopebo;
  public boolean _xlientiope;
  public boolean _xeneficope;
  public boolean _xerzistiope;
  public boolean bRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stp_ope_fraz_allR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stp_ope_fraz_all",m_Caller);
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
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
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
    m_cPhName_rapotit = p_ContextObject.GetPhName("rapotit");
    if (m_cPhName_rapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapotit = m_cPhName_rapotit+" "+m_Ctx.GetWritePhName("rapotit");
    }
    m_cServer_rapotit = p_ContextObject.GetServer("rapotit");
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
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpope_dett_anag")) {
      m_cPhName_tmp_stpope_dett_anag = p_ContextObject.GetPhName("tmp_stpope_dett_anag");
      if (m_cPhName_tmp_stpope_dett_anag.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpope_dett_anag = m_cPhName_tmp_stpope_dett_anag+" "+m_Ctx.GetWritePhName("tmp_stpope_dett_anag");
      }
      m_cServer_tmp_stpope_dett_anag = p_ContextObject.GetServer("tmp_stpope_dett_anag");
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
    if (CPLib.eqr("onlyope",p_cVarName)) {
      return onlyope;
    }
    if (CPLib.eqr("onlyrap",p_cVarName)) {
      return onlyrap;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("StatoLower",p_cVarName)) {
      return w_StatoLower;
    }
    if (CPLib.eqr("StatoUpper",p_cVarName)) {
      return w_StatoUpper;
    }
    if (CPLib.eqr("progrIns",p_cVarName)) {
      return progrIns;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_stp_ope_fraz_all";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("EstrazTitEffNelPeriodo",p_cVarName)) {
      return w_EstrazTitEffNelPeriodo;
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      return w_CONNES;
    }
    if (CPLib.eqr("TipoOpeStampa",p_cVarName)) {
      return w_TipoOpeStampa;
    }
    if (CPLib.eqr("TipoStampa",p_cVarName)) {
      return w_TipoStampa;
    }
    if (CPLib.eqr("OrderBy",p_cVarName)) {
      return w_OrderBy;
    }
    if (CPLib.eqr("Stato",p_cVarName)) {
      return w_Stato;
    }
    if (CPLib.eqr("Dipendenza",p_cVarName)) {
      return w_Dipendenza;
    }
    if (CPLib.eqr("Ambito",p_cVarName)) {
      return w_Ambito;
    }
    if (CPLib.eqr("gFlgDoc",p_cVarName)) {
      return gFlgDoc;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("statoreg",p_cVarName)) {
      return statoreg;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_nomereport",p_cVarName)) {
      return _nomereport;
    }
    if (CPLib.eqr("_ftypes",p_cVarName)) {
      return _ftypes;
    }
    if (CPLib.eqr("_fmodels",p_cVarName)) {
      return _fmodels;
    }
    if (CPLib.eqr("_rotate",p_cVarName)) {
      return _rotate;
    }
    if (CPLib.eqr("_reportname",p_cVarName)) {
      return _reportname;
    }
    if (CPLib.eqr("_fonte_arch",p_cVarName)) {
      return _fonte_arch;
    }
    if (CPLib.eqr("_tipo_arch",p_cVarName)) {
      return _tipo_arch;
    }
    if (CPLib.eqr("c_dadataope",p_cVarName)) {
      return w_c_dadataope;
    }
    if (CPLib.eqr("c_adataope",p_cVarName)) {
      return w_c_adataope;
    }
    if (CPLib.eqr("c_dadatareg",p_cVarName)) {
      return w_c_dadatareg;
    }
    if (CPLib.eqr("c_adatareg",p_cVarName)) {
      return w_c_adatareg;
    }
    if (CPLib.eqr("c_dadataret",p_cVarName)) {
      return w_c_dadataret;
    }
    if (CPLib.eqr("c_adataret",p_cVarName)) {
      return w_c_adataret;
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
    if (CPLib.eqr("DaDatRet",p_cVarName)) {
      return w_DaDatRet;
    }
    if (CPLib.eqr("ADatRet",p_cVarName)) {
      return w_ADatRet;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
    }
    if (CPLib.eqr("_dataret",p_cVarName)) {
      return _dataret;
    }
    if (CPLib.eqr("_datachk",p_cVarName)) {
      return _datachk;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("Stp_dist_lire_euro",p_cVarName)) {
      return w_Stp_dist_lire_euro;
    }
    if (CPLib.eqr("Con_Contanti",p_cVarName)) {
      return w_Con_Contanti;
    }
    if (CPLib.eqr("Senza_dip",p_cVarName)) {
      return w_Senza_dip;
    }
    if (CPLib.eqr("_mlientiope",p_cVarName)) {
      return _mlientiope;
    }
    if (CPLib.eqr("_clientiope",p_cVarName)) {
      return _clientiope;
    }
    if (CPLib.eqr("_mogopebo",p_cVarName)) {
      return _mogopebo;
    }
    if (CPLib.eqr("_sogopebo",p_cVarName)) {
      return _sogopebo;
    }
    if (CPLib.eqr("_meneficope",p_cVarName)) {
      return _meneficope;
    }
    if (CPLib.eqr("_beneficope",p_cVarName)) {
      return _beneficope;
    }
    if (CPLib.eqr("_merzistiope",p_cVarName)) {
      return _merzistiope;
    }
    if (CPLib.eqr("_terzistiope",p_cVarName)) {
      return _terzistiope;
    }
    if (CPLib.eqr("_mlientifrz",p_cVarName)) {
      return _mlientifrz;
    }
    if (CPLib.eqr("_clientifrz",p_cVarName)) {
      return _clientifrz;
    }
    if (CPLib.eqr("_mogopefbo",p_cVarName)) {
      return _mogopefbo;
    }
    if (CPLib.eqr("_sogopefbo",p_cVarName)) {
      return _sogopefbo;
    }
    if (CPLib.eqr("_meneficfrz",p_cVarName)) {
      return _meneficfrz;
    }
    if (CPLib.eqr("_beneficfrz",p_cVarName)) {
      return _beneficfrz;
    }
    if (CPLib.eqr("_merzistifrz",p_cVarName)) {
      return _merzistifrz;
    }
    if (CPLib.eqr("_terzistifrz",p_cVarName)) {
      return _terzistifrz;
    }
    if (CPLib.eqr("_rapcolleg",p_cVarName)) {
      return _rapcolleg;
    }
    if (CPLib.eqr("_xerzistifrz",p_cVarName)) {
      return _xerzistifrz;
    }
    if (CPLib.eqr("_xeneficfrz",p_cVarName)) {
      return _xeneficfrz;
    }
    if (CPLib.eqr("_xlientifrz",p_cVarName)) {
      return _xlientifrz;
    }
    if (CPLib.eqr("_xogopefbo",p_cVarName)) {
      return _xogopefbo;
    }
    if (CPLib.eqr("_xogopebo",p_cVarName)) {
      return _xogopebo;
    }
    if (CPLib.eqr("_xlientiope",p_cVarName)) {
      return _xlientiope;
    }
    if (CPLib.eqr("_xeneficope",p_cVarName)) {
      return _xeneficope;
    }
    if (CPLib.eqr("_xerzistiope",p_cVarName)) {
      return _xerzistiope;
    }
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcSoggetti",p_cVarName)) {
      return mcSoggetti;
    }
    if (CPLib.eqr("mcFraziobo",p_cVarName)) {
      return mcFraziobo;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowSoggetti",p_cVarName)) {
      return rowSoggetti;
    }
    if (CPLib.eqr("rowFraziobo",p_cVarName)) {
      return rowFraziobo;
    }
    if (CPLib.eqr("rwFraziobo",p_cVarName)) {
      return rwFraziobo;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("onlyope",p_cVarName)) {
      onlyope = value;
      return;
    }
    if (CPLib.eqr("onlyrap",p_cVarName)) {
      onlyrap = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("StatoLower",p_cVarName)) {
      w_StatoLower = value;
      return;
    }
    if (CPLib.eqr("StatoUpper",p_cVarName)) {
      w_StatoUpper = value;
      return;
    }
    if (CPLib.eqr("progrIns",p_cVarName)) {
      progrIns = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("EstrazTitEffNelPeriodo",p_cVarName)) {
      w_EstrazTitEffNelPeriodo = value;
      return;
    }
    if (CPLib.eqr("CONNES",p_cVarName)) {
      w_CONNES = value;
      return;
    }
    if (CPLib.eqr("TipoOpeStampa",p_cVarName)) {
      w_TipoOpeStampa = value;
      return;
    }
    if (CPLib.eqr("TipoStampa",p_cVarName)) {
      w_TipoStampa = value;
      return;
    }
    if (CPLib.eqr("OrderBy",p_cVarName)) {
      w_OrderBy = value;
      return;
    }
    if (CPLib.eqr("Stato",p_cVarName)) {
      w_Stato = value;
      return;
    }
    if (CPLib.eqr("Dipendenza",p_cVarName)) {
      w_Dipendenza = value;
      return;
    }
    if (CPLib.eqr("Ambito",p_cVarName)) {
      w_Ambito = value;
      return;
    }
    if (CPLib.eqr("gFlgDoc",p_cVarName)) {
      gFlgDoc = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("statoreg",p_cVarName)) {
      statoreg = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_nomereport",p_cVarName)) {
      _nomereport = value;
      return;
    }
    if (CPLib.eqr("_ftypes",p_cVarName)) {
      _ftypes = value;
      return;
    }
    if (CPLib.eqr("_fmodels",p_cVarName)) {
      _fmodels = value;
      return;
    }
    if (CPLib.eqr("_rotate",p_cVarName)) {
      _rotate = value;
      return;
    }
    if (CPLib.eqr("_reportname",p_cVarName)) {
      _reportname = value;
      return;
    }
    if (CPLib.eqr("_fonte_arch",p_cVarName)) {
      _fonte_arch = value;
      return;
    }
    if (CPLib.eqr("_tipo_arch",p_cVarName)) {
      _tipo_arch = value;
      return;
    }
    if (CPLib.eqr("c_dadataope",p_cVarName)) {
      w_c_dadataope = value;
      return;
    }
    if (CPLib.eqr("c_adataope",p_cVarName)) {
      w_c_adataope = value;
      return;
    }
    if (CPLib.eqr("c_dadatareg",p_cVarName)) {
      w_c_dadatareg = value;
      return;
    }
    if (CPLib.eqr("c_adatareg",p_cVarName)) {
      w_c_adatareg = value;
      return;
    }
    if (CPLib.eqr("c_dadataret",p_cVarName)) {
      w_c_dadataret = value;
      return;
    }
    if (CPLib.eqr("c_adataret",p_cVarName)) {
      w_c_adataret = value;
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
    if (CPLib.eqr("DaDatRet",p_cVarName)) {
      w_DaDatRet = value;
      return;
    }
    if (CPLib.eqr("ADatRet",p_cVarName)) {
      w_ADatRet = value;
      return;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
      return;
    }
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
      return;
    }
    if (CPLib.eqr("_dataret",p_cVarName)) {
      _dataret = value;
      return;
    }
    if (CPLib.eqr("_datachk",p_cVarName)) {
      _datachk = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("Stp_dist_lire_euro",p_cVarName)) {
      w_Stp_dist_lire_euro = value;
      return;
    }
    if (CPLib.eqr("Con_Contanti",p_cVarName)) {
      w_Con_Contanti = value;
      return;
    }
    if (CPLib.eqr("Senza_dip",p_cVarName)) {
      w_Senza_dip = value;
      return;
    }
    if (CPLib.eqr("_mlientiope",p_cVarName)) {
      _mlientiope = value;
      return;
    }
    if (CPLib.eqr("_clientiope",p_cVarName)) {
      _clientiope = value;
      return;
    }
    if (CPLib.eqr("_mogopebo",p_cVarName)) {
      _mogopebo = value;
      return;
    }
    if (CPLib.eqr("_sogopebo",p_cVarName)) {
      _sogopebo = value;
      return;
    }
    if (CPLib.eqr("_meneficope",p_cVarName)) {
      _meneficope = value;
      return;
    }
    if (CPLib.eqr("_beneficope",p_cVarName)) {
      _beneficope = value;
      return;
    }
    if (CPLib.eqr("_merzistiope",p_cVarName)) {
      _merzistiope = value;
      return;
    }
    if (CPLib.eqr("_terzistiope",p_cVarName)) {
      _terzistiope = value;
      return;
    }
    if (CPLib.eqr("_mlientifrz",p_cVarName)) {
      _mlientifrz = value;
      return;
    }
    if (CPLib.eqr("_clientifrz",p_cVarName)) {
      _clientifrz = value;
      return;
    }
    if (CPLib.eqr("_mogopefbo",p_cVarName)) {
      _mogopefbo = value;
      return;
    }
    if (CPLib.eqr("_sogopefbo",p_cVarName)) {
      _sogopefbo = value;
      return;
    }
    if (CPLib.eqr("_meneficfrz",p_cVarName)) {
      _meneficfrz = value;
      return;
    }
    if (CPLib.eqr("_beneficfrz",p_cVarName)) {
      _beneficfrz = value;
      return;
    }
    if (CPLib.eqr("_merzistifrz",p_cVarName)) {
      _merzistifrz = value;
      return;
    }
    if (CPLib.eqr("_terzistifrz",p_cVarName)) {
      _terzistifrz = value;
      return;
    }
    if (CPLib.eqr("_rapcolleg",p_cVarName)) {
      _rapcolleg = value;
      return;
    }
    if (CPLib.eqr("_xerzistifrz",p_cVarName)) {
      _xerzistifrz = value;
      return;
    }
    if (CPLib.eqr("_xeneficfrz",p_cVarName)) {
      _xeneficfrz = value;
      return;
    }
    if (CPLib.eqr("_xlientifrz",p_cVarName)) {
      _xlientifrz = value;
      return;
    }
    if (CPLib.eqr("_xogopefbo",p_cVarName)) {
      _xogopefbo = value;
      return;
    }
    if (CPLib.eqr("_xogopebo",p_cVarName)) {
      _xogopebo = value;
      return;
    }
    if (CPLib.eqr("_xlientiope",p_cVarName)) {
      _xlientiope = value;
      return;
    }
    if (CPLib.eqr("_xeneficope",p_cVarName)) {
      _xeneficope = value;
      return;
    }
    if (CPLib.eqr("_xerzistiope",p_cVarName)) {
      _xerzistiope = value;
      return;
    }
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      bRitorno = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowSoggetti",p_cVarName)) {
      rowSoggetti = (MemoryCursorRow_personbo)value;
      return;
    }
    if (CPLib.eqr("rowFraziobo",p_cVarName)) {
      rowFraziobo = (MemoryCursorRow_qbe_operazbo_union_fraziobo_vqr)value;
      return;
    }
    if (CPLib.eqr("rwFraziobo",p_cVarName)) {
      rwFraziobo = (MemoryCursorRow_qbe_operazbo_union_fraziobo_vqr)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcSoggetti",p_cVarName)) {
      mcSoggetti = (MemoryCursor_personbo)value;
      return;
    }
    if (CPLib.eqr("mcFraziobo",p_cVarName)) {
      mcFraziobo = (MemoryCursor_qbe_operazbo_union_fraziobo_vqr)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_tot_tmp_stpope_dett_anag=null;
    CPResultSet Cursor_qbe_alloperazbo=null;
    CPResultSet Cursor_qbe_alloperazbo_prv=null;
    CPResultSet Cursor_qbe_tot_tmp_operazioni=null;
    CPResultSet Cursor_tmp_stpoperazioni=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_DaDatOpe Date // Da Data Operazione */
      /* w_ADatOpe Date // A Data Operazione */
      /* w_DaDatReg Date // Da Data Registrazione */
      /* w_ADatReg Date // A Data Registrazione */
      /* w_DaDatRet Date // Da Data Rettifica */
      /* w_ADatRet Date // A Data Rettifica */
      /* w_EstrazTitEffNelPeriodo Char(1) // Estrazione solo dei Titolari Effettivi in essere nel periodo di date scelto ['S'.'N'] */
      /* w_CONNES Char(30) // CONNES dell'Intestatario */
      /* w_TipoOpeStampa Char(1) // Tipologia di Operazioni da stampare, Operazioni o Frazionate o Entrambe ['O','F','E'] */
      /* w_TipoStampa Char(1) // Tipo di stampa da effettuare, Dettaglio Anagrafico o Analitica o Sintetica ['D','A','S'] */
      /* w_OrderBy Char(30) //  OrderBy (stringa) */
      /* w_Stp_dist_lire_euro Bool // Stampa Distinta Lire/Euro (hidden in maschera) */
      /* w_Con_Contanti Bool // Solo con presenza di contanti */
      /* w_Stato Char(1) // stato definisce lo stato dell'operazione: Tutte, Solo Attive, Solo Annullate, Solo vecchia copia [ 'T','A','C','M' ] */
      /* w_Senza_dip Bool // Senza dipendenza (con Intermediario) */
      /* w_Dipendenza Char(6) // Dipendenza */
      /* w_Ambito Char(1) // D = AUI e P = Provvisorio */
      /* gFlgDoc Char(1) // Collegamento con storico documenti */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* onlyope Numeric(1, 0) */
      /* onlyrap Numeric(1, 0) */
      /* statoreg Char(1) */
      /* _connes Char(16) // _connes del soggetto */
      /* _dataope Date // data dell'operazione per la ricerca della datamodi del soggetto */
      /* _datareg Date // data dell'operazione per la ricerca della datamodi del soggetto */
      /* _dataret Date // data rettifica dell'operazione per la ricerca della datamodi del soggetto */
      /* _numsto Char(15) */
      /* _nomereport Char(50) // nome del report che viene lanciato */
      /* _ftypes Char(20) // tipi di file previsti per il report (pdf, xls, ... ) */
      /* _fmodels Char(20) // tipi di file previsti per il report (pdf, xls, ... ) */
      /* _rotate Char(20) // Orientamento della stampa su file (Portrait o Landscape) */
      /* _reportname Char(100) // Nome file del report salvato su disco */
      /* _fonte_arch Char(100) // Fonte archivio (Operazioni/Frazionate/Entrambe) */
      /* _tipo_arch Char(100) // Tipo di archivio (A.U.I. o Provvisorio) */
      /* _conta Numeric(10, 0) // Conteggio dei elementi da stampare (se zero -> stampa negativa) */
      /* mcSoggetti MemoryCursor(personbo) */
      /* rowSoggetti Row(personbo) */
      /* mcFraziobo MemoryCursor(qbe_operazbo_union_fraziobo.vqr) */
      /* rowFraziobo Row(qbe_operazbo_union_fraziobo.vqr) */
      /* rwFraziobo Row(qbe_operazbo_union_fraziobo.vqr) */
      /* _datachk Date */
      /* w_c_dadataope Char(8) // da data OPE in formato stringa */
      /* w_c_adataope Char(8) // a data OPE in formato stringa */
      /* w_c_dadatareg Char(8) // da data REG in formato stringa */
      /* w_c_adatareg Char(8) // a data REG in formato stringa */
      /* w_c_dadataret Char(8) // da data RET in formato stringa (non utilizzato in quanto nella tabella non è presente il campo CDATRET (data rettifica in stringa)) */
      /* w_c_adataret Char(8) // a data RET in formato stringa (non utilizzato in quanto nella tabella non è presente il campo CDATRET (data rettifica in stringa)) */
      /* w_StatoLower Numeric(1, 0) // // filtro su STATOREG nelle query */
      /* w_StatoUpper Numeric(1, 0) // // filtro su STATOREG nelle query */
      /* progrIns Numeric(5, 0) */
      /* _mlientiope Bool */
      /* _clientiope Bool */
      /* _mogopebo Bool */
      /* _sogopebo Bool */
      /* _meneficope Bool */
      /* _beneficope Bool */
      /* _merzistiope Bool */
      /* _terzistiope Bool */
      /* _mlientifrz Bool */
      /* _clientifrz Bool */
      /* _mogopefbo Bool */
      /* _sogopefbo Bool */
      /* _meneficfrz Bool */
      /* _beneficfrz Bool */
      /* _merzistifrz Bool */
      /* _terzistifrz Bool */
      /* _rapcolleg Bool */
      /* _xerzistifrz Bool */
      /* _xeneficfrz Bool */
      /* _xlientifrz Bool */
      /* _xogopefbo Bool */
      /* _xogopebo Bool */
      /* _xlientiope Bool */
      /* _xeneficope Bool */
      /* _xerzistiope Bool */
      /* Exec "Verifica presenza dati in tabelle aggiuntive" Page 12:Page_12 */
      Page_12();
      // * --- Drop temporary table tmp_stpope_dett_anag
      if (m_Ctx.IsSharedTemp("tmp_stpope_dett_anag")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpope_dett_anag")) {
          m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
          m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpope_dett_anag");
      }
      // * --- Create temporary table tmp_stpope_dett_anag
      if (m_Ctx.IsSharedTemp("tmp_stpope_dett_anag")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpope_dett_anag")) {
          m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
          m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpope_dett_anag");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpope_dett_anag");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpope_dett_anag"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpope_dett_anag",m_cServer,"proto")),m_cPhName,"tmp_stpope_dett_anag",m_Ctx);
      }
      m_cPhName_tmp_stpope_dett_anag = m_cPhName;
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
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpoperazioni",m_cServer,"proto")),m_cPhName,"tmp_stpoperazioni",m_Ctx,new String[]{"IDBASE","NUMPROG","RAPPORTO","CONNESCLI","DATAREG","DATAOPE","COLLEG","CDATOPE","UNIQUECODE","PRGIMPOPE","MTCN","CDATREG"});
      }
      m_cPhName_tmp_stpoperazioni = m_cPhName;
      /* w_c_dadataope := iif(Empty(w_DaDatOpe),'',DateToChar(w_DaDatOpe)) // trasformazione da tipo Date a String di DataOPE */
      w_c_dadataope = (CPLib.Empty(w_DaDatOpe)?"":CPLib.DateToChar(w_DaDatOpe));
      /* w_c_adataope := iif(Empty(w_ADatOpe),'',DateToChar(w_ADatOpe)) */
      w_c_adataope = (CPLib.Empty(w_ADatOpe)?"":CPLib.DateToChar(w_ADatOpe));
      /* w_c_dadatareg := iif(Empty(w_DaDatReg),'',DateToChar(w_DaDatReg)) // trasformazione da tipo Date a String di DataREG */
      w_c_dadatareg = (CPLib.Empty(w_DaDatReg)?"":CPLib.DateToChar(w_DaDatReg));
      /* w_c_adatareg := iif(Empty(w_ADatReg),'',DateToChar(w_ADatReg)) */
      w_c_adatareg = (CPLib.Empty(w_ADatReg)?"":CPLib.DateToChar(w_ADatReg));
      /* w_c_dadataret := iif(Empty(w_DaDatRet),'',DateToChar(w_DaDatRet)) // trasformazione da tipo Date a String di DataRET */
      w_c_dadataret = (CPLib.Empty(w_DaDatRet)?"":CPLib.DateToChar(w_DaDatRet));
      /* w_c_adataret := iif(Empty(w_ADatRet),'',DateToChar(w_ADatRet)) */
      w_c_adataret = (CPLib.Empty(w_ADatRet)?"":CPLib.DateToChar(w_ADatRet));
      /* Case w_Stato='T' */
      if (CPLib.eqr(w_Stato,"T")) {
        /* w_StatoLower := 0 // // filtro su STATOREG nelle query */
        w_StatoLower = CPLib.Round(0,0);
        /* w_StatoUpper := 3 // // filtro su STATOREG nelle query */
        w_StatoUpper = CPLib.Round(3,0);
        /* Case w_Stato='A' */
      } else if (CPLib.eqr(w_Stato,"A")) {
        /* w_StatoLower := 0 // // filtro su STATOREG nelle query */
        w_StatoLower = CPLib.Round(0,0);
        /* w_StatoUpper := 1 // // filtro su STATOREG nelle query */
        w_StatoUpper = CPLib.Round(1,0);
        /* Case w_Stato='C' */
      } else if (CPLib.eqr(w_Stato,"C")) {
        /* w_StatoLower := 2 // // filtro su STATOREG nelle query */
        w_StatoLower = CPLib.Round(2,0);
        /* w_StatoUpper := 2 // // filtro su STATOREG nelle query */
        w_StatoUpper = CPLib.Round(2,0);
        /* Case w_Stato='M' */
      } else if (CPLib.eqr(w_Stato,"M")) {
        /* w_StatoLower := 3 // // filtro su STATOREG nelle query */
        w_StatoLower = CPLib.Round(3,0);
        /* w_StatoUpper := 3 // // filtro su STATOREG nelle query */
        w_StatoUpper = CPLib.Round(3,0);
      } // End Case
      /* Lancio la query */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000067status;
      nTry00000067status = m_Sql.GetTransactionStatus();
      String cTry00000067msg;
      cTry00000067msg = m_Sql.TransactionErrorMessage();
      try {
        /* If w_TipoStampa='D' */
        if (CPLib.eqr(w_TipoStampa,"D")) {
          /* Faccio la query che preleva le operazioni (sia Operazioni/Frazionate/Entrambe) */
          /* Exec "Alimentazione cursori" Page 9:Page_9 */
          Page_9();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          for (MemoryCursorRow_qbe_operazbo_union_fraziobo_vqr rowFraziobo : mcFraziobo._iterable_()) {
            /* rwFraziobo.Copy(rowFraziobo) */
            rwFraziobo.Copy(rowFraziobo);
            /* progrIns := 0 */
            progrIns = CPLib.Round(0,0);
            /* If FiltroIntestatario(rowFraziobo,w_CONNES) */
            if (FiltroIntestatario(rowFraziobo,w_CONNES)) {
              /* _dataope := rowFraziobo.DATAOPE // data dell'operazione per la ricerca della datamodi del soggetto */
              _dataope = rowFraziobo.DATAOPE;
              /* _datareg := rowFraziobo.DATAREG // data di registrazione dell'operazione per la ricerca della datamodi del soggetto */
              _datareg = rowFraziobo.DATAREG;
              /* _dataret := rowFraziobo.DATARETT // data dell'operazione per la ricerca della datamodi del soggetto */
              _dataret = rowFraziobo.DATARETT;
              /* _connes := rowFraziobo.CONNESCLI // _connes del soggetto */
              _connes = rowFraziobo.CONNESCLI;
              /* _datachk := iif(rowFraziobo.STATOREG='1',_dataret,_dataope) */
              _datachk = (CPLib.eqr(rowFraziobo.STATOREG,"1")?_dataret:_dataope);
              /* Cerco se il cliente occasionale ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
              /* rowSoggetti := DatiSoggetto(_connes,_datachk) */
              rowSoggetti = DatiSoggetto(_connes,_datachk);
              /* progrIns := progrIns+1 */
              progrIns = CPLib.Round(progrIns+1,0);
              // * --- Insert into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000077")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000077(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CAMBIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODANA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAREG,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATARETT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESC2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.idcauana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.INFORM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NATURA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NOPROT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PRGIMPFRZ,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROV2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAREA,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RCOMP,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RFREQ,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIMP,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RRAGIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RTIPO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTCONT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTLIRE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UCODE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_STA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_IND,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
              /* Exec "Titolari Effettivi" Page 6:Page_6 */
              Page_6();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* Cerco se il soggetto operante ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
              /* If not(Empty(rowFraziobo.CONNESOPER)) */
              if ( ! (CPLib.Empty(rowFraziobo.CONNESOPER))) {
                /* _connes := rowFraziobo.CONNESOPER // _connes del soggetto */
                _connes = rowFraziobo.CONNESOPER;
                /* rowSoggetti := DatiSoggetto(_connes,_datachk) */
                rowSoggetti = DatiSoggetto(_connes,_datachk);
                /* progrIns := progrIns+1 */
                progrIns = CPLib.Round(progrIns+1,0);
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000007E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000007E(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CAMBIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODANA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAOPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAREG,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATARETT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESC2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.idcauana,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.INFORM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NATURA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NOPROT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PAESE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PRGIMPFRZ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROV2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAREA,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RCOMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RFREQ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RRAGIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RTIPO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTCONT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTLIRE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UCODE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_STA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_IND,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
                /* Exec "Titolari Effettivi" Page 6:Page_6 */
                Page_6();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } // End If
              /* Cerco se il soggetto controparte ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
              /* If not(Empty(rowFraziobo.CONNESBEN)) */
              if ( ! (CPLib.Empty(rowFraziobo.CONNESBEN))) {
                /* _connes := rowFraziobo.CONNESBEN // _connes del soggetto */
                _connes = rowFraziobo.CONNESBEN;
                /* rowSoggetti := DatiSoggetto(_connes,_datachk) */
                rowSoggetti = DatiSoggetto(_connes,_datachk);
                /* progrIns := progrIns+1 */
                progrIns = CPLib.Round(progrIns+1,0);
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000085")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000085(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CAMBIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODANA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAOPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAREG,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATARETT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESC2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.idcauana,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.INFORM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NATURA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NOPROT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PAESE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PRGIMPFRZ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROV2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAREA,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RCOMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RFREQ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RRAGIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RTIPO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTCONT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTLIRE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UCODE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_STA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_IND,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
                /* Exec "Titolari Effettivi" Page 6:Page_6 */
                Page_6();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } // End If
              /* If not(Empty(LRTrim(rowFraziobo.C_RAG))) and Empty(rowFraziobo.CONNESBEN) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(rowFraziobo.C_RAG))) && CPLib.Empty(rowFraziobo.CONNESBEN)) {
                /* progrIns := progrIns+1 */
                progrIns = CPLib.Round(progrIns+1,0);
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000089")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000089(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_IND,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_STA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODANA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAOPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAREG,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATARETT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESC2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.idcauana,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.INFORM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NATURA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NOPROT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PAESE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PRGIMPFRZ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROV2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAREA,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RCOMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RFREQ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RRAGIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RTIPO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTCONT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTLIRE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UCODE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
              /* Cerco se il soggetto titolare effettivo dell operazione ha delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
              /* If not(Empty(rowFraziobo.CONNALTRO)) */
              if ( ! (CPLib.Empty(rowFraziobo.CONNALTRO))) {
                /* _connes := rowFraziobo.CONNALTRO // _connes del soggetto */
                _connes = rowFraziobo.CONNALTRO;
                /* rowSoggetti := DatiSoggetto(_connes,_datachk) */
                rowSoggetti = DatiSoggetto(_connes,_datachk);
                /* progrIns := progrIns+1 */
                progrIns = CPLib.Round(progrIns+1,0);
                // * --- Insert into tmp_stpope_dett_anag from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
                m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000008F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000008F(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CAMBIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODANA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAOPE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATAREG,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DATARETT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESC2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.idcauana,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.INFORM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NATURA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NOPROT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PAESE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PRGIMPFRZ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROV2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RAREA,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RCOMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RFREQ,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RIMP,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RRAGIO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.RTIPO,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTCONT,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.TOTLIRE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UCODE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_STA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_IND,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
                /* Exec "Titolari Effettivi" Page 6:Page_6 */
                Page_6();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } // End If
              /* If rowFraziobo.MITGDOC='F' */
              if (CPLib.eqr(rowFraziobo.MITGDOC,"F")) {
                /* If rowFraziobo.STATOREG='3' */
                if (CPLib.eqr(rowFraziobo.STATOREG,"3")) {
                  /* Exec "Scrive dati tabelle aggiuntive (STATOREG=3) (F)" Page 2:Page_2 */
                  Page_2();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* If w_Ambito='D' */
                  if (CPLib.eqr(w_Ambito,"D")) {
                    /* Exec "Scrive dati tabelle aggiuntive (STATOREG<>3) (F) AUI" Page 3:Page_3 */
                    Page_3();
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    /* ElseIf w_Ambito='P' */
                  } else if (CPLib.eqr(w_Ambito,"P")) {
                    /* Exec "Scrive dati tabelle aggiuntive (F) Provv." Page 10:Page_10 */
                    Page_10();
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                  } // End If
                } // End If
                /* ElseIf rowFraziobo.MITGDOC='O' */
              } else if (CPLib.eqr(rowFraziobo.MITGDOC,"O")) {
                /* If rowFraziobo.STATOREG='3' */
                if (CPLib.eqr(rowFraziobo.STATOREG,"3")) {
                  /* Exec "Scrive dati tabelle aggiuntive (STATOREG=3) (O)" Page 4:Page_4 */
                  Page_4();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } else { // Else
                  /* If w_Ambito='D' */
                  if (CPLib.eqr(w_Ambito,"D")) {
                    /* Exec "Scrive dati tabelle aggiuntive (STATOREG<>3) (O) AUI" Page 5:Page_5 */
                    Page_5();
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                    /* ElseIf w_Ambito='P' */
                  } else if (CPLib.eqr(w_Ambito,"P")) {
                    /* Exec "Scrive dati tabelle aggiuntive (O) Provv." Page 11:Page_11 */
                    Page_11();
                    if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                      throw new RoutineException();
                    }
                  } // End If
                } // End If
              } // End If
            } // End If
          }
          /* _conta := 0 */
          _conta = CPLib.Round(0,0);
          // * --- Select from qbe_tot_tmp_stpope_dett_anag
          if (Cursor_qbe_tot_tmp_stpope_dett_anag!=null)
            Cursor_qbe_tot_tmp_stpope_dett_anag.Close();
          Cursor_qbe_tot_tmp_stpope_dett_anag = new VQRHolder("qbe_tot_tmp_stpope_dett_anag",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tot_tmp_stpope_dett_anag.Eof())) {
            /* _conta := qbe_tot_tmp_stpope_dett_anag->Totale */
            _conta = CPLib.Round(Cursor_qbe_tot_tmp_stpope_dett_anag.GetDouble("Totale"),0);
            Cursor_qbe_tot_tmp_stpope_dett_anag.Next();
          }
          m_cConnectivityError = Cursor_qbe_tot_tmp_stpope_dett_anag.ErrorMessage();
          Cursor_qbe_tot_tmp_stpope_dett_anag.Close();
          // * --- End Select
          /* If _conta=0 */
          if (CPLib.eqr(_conta,0)) {
            // * --- Insert into tmp_stpoperazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000A0(m_Ctx,m_oWrInfo);
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
              throw new RoutineException();
            }
          } // End If
          /* ElseIf w_TipoStampa='A' */
        } else if (CPLib.eqr(w_TipoStampa,"A")) {
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            // * --- Select from qbe_alloperazbo
            SPBridge.HMCaller _h000000A2;
            _h000000A2 = new SPBridge.HMCaller();
            _h000000A2.Set("m_cVQRList",m_cVQRList);
            _h000000A2.Set("c_dadataope",w_c_dadataope);
            _h000000A2.Set("c_adataope",w_c_adataope);
            _h000000A2.Set("c_dadatareg",w_c_dadatareg);
            _h000000A2.Set("c_adatareg",w_c_adatareg);
            _h000000A2.Set("CodCli",w_CONNES);
            _h000000A2.Set("CodDip",w_Dipendenza);
            _h000000A2.Set("Con_Contanti",w_Con_Contanti);
            _h000000A2.Set("tipoOperaz",w_TipoOpeStampa);
            _h000000A2.Set("dadataret",(CPLib.Empty(w_DaDatRet)?CPLib.NullDate():w_DaDatRet));
            _h000000A2.Set("adataret",(CPLib.Empty(w_ADatRet)?CPLib.NullDate():w_ADatRet));
            _h000000A2.Set("StatoLower",w_StatoLower);
            _h000000A2.Set("StatoUpper",w_StatoUpper);
            if (Cursor_qbe_alloperazbo!=null)
              Cursor_qbe_alloperazbo.Close();
            Cursor_qbe_alloperazbo = new VQRHolder("qbe_alloperazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A2,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_alloperazbo.Eof())) {
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000A3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000A3(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_alloperazbo.GetString("MITGDOC")),"?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              Cursor_qbe_alloperazbo.Next();
            }
            m_cConnectivityError = Cursor_qbe_alloperazbo.ErrorMessage();
            Cursor_qbe_alloperazbo.Close();
            // * --- End Select
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            // * --- Select from qbe_alloperazbo_prv
            SPBridge.HMCaller _h000000A4;
            _h000000A4 = new SPBridge.HMCaller();
            _h000000A4.Set("m_cVQRList",m_cVQRList);
            _h000000A4.Set("c_adataope",w_c_adataope);
            _h000000A4.Set("c_adatareg",w_c_adatareg);
            _h000000A4.Set("c_dadataope",w_c_dadataope);
            _h000000A4.Set("c_dadatareg",w_c_dadatareg);
            _h000000A4.Set("CodCli",w_CONNES);
            _h000000A4.Set("CodDip",w_Dipendenza);
            _h000000A4.Set("Con_Contanti",w_Con_Contanti);
            _h000000A4.Set("tipoOperaz",w_TipoOpeStampa);
            _h000000A4.Set("dadataret",(CPLib.Empty(w_DaDatRet)?CPLib.NullDate():w_DaDatRet));
            _h000000A4.Set("adataret",(CPLib.Empty(w_ADatRet)?CPLib.NullDate():w_ADatRet));
            _h000000A4.Set("StatoLower",w_StatoLower);
            _h000000A4.Set("StatoUpper",w_StatoUpper);
            if (Cursor_qbe_alloperazbo_prv!=null)
              Cursor_qbe_alloperazbo_prv.Close();
            Cursor_qbe_alloperazbo_prv = new VQRHolder("qbe_alloperazbo_prv",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A4,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_alloperazbo_prv.Eof())) {
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000A5(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_alloperazbo_prv.GetString("MITGDOC")),"?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              Cursor_qbe_alloperazbo_prv.Next();
            }
            m_cConnectivityError = Cursor_qbe_alloperazbo_prv.ErrorMessage();
            Cursor_qbe_alloperazbo_prv.Close();
            // * --- End Select
          } // End If
          /* _conta := 0 */
          _conta = CPLib.Round(0,0);
          // * --- Select from qbe_tot_tmp_operazioni
          if (Cursor_qbe_tot_tmp_operazioni!=null)
            Cursor_qbe_tot_tmp_operazioni.Close();
          Cursor_qbe_tot_tmp_operazioni = new VQRHolder("qbe_tot_tmp_operazioni",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tot_tmp_operazioni.Eof())) {
            /* _conta := qbe_tot_tmp_operazioni->Totale */
            _conta = CPLib.Round(Cursor_qbe_tot_tmp_operazioni.GetDouble("Totale"),0);
            Cursor_qbe_tot_tmp_operazioni.Next();
          }
          m_cConnectivityError = Cursor_qbe_tot_tmp_operazioni.ErrorMessage();
          Cursor_qbe_tot_tmp_operazioni.Close();
          // * --- End Select
          /* If _conta=0 */
          if (CPLib.eqr(_conta,0)) {
            // * --- Insert into tmp_stpoperazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000AA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000AA(m_Ctx,m_oWrInfo);
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
              throw new RoutineException();
            }
          } else { // Else
            // * --- Select from tmp_stpoperazioni
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            if (Cursor_tmp_stpoperazioni!=null)
              Cursor_tmp_stpoperazioni.Close();
            Cursor_tmp_stpoperazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_stpoperazioni")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_stpoperazioni.Eof())) {
              /* If not(Empty(LRTrim(tmp_stpoperazioni->CONNESCLI))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_stpoperazioni.GetString("CONNESCLI"))))) {
                /* _numsto := arfn_chkspers(tmp_stpoperazioni->CONNESCLI,tmp_stpoperazioni->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_tmp_stpoperazioni.GetString("CONNESCLI"),Cursor_tmp_stpoperazioni.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000B0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGCLI = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000B2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGCLI = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              /* If not(Empty(LRTrim(tmp_stpoperazioni->CONNESOPER))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_stpoperazioni.GetString("CONNESOPER"))))) {
                /* _numsto := arfn_chkspers(tmp_stpoperazioni->CONNESOPER,tmp_stpoperazioni->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_tmp_stpoperazioni.GetString("CONNESOPER"),Cursor_tmp_stpoperazioni.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000B7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGOPE = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000B9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGOPE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              /* If not(Empty(LRTrim(tmp_stpoperazioni->CONNESBEN))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_stpoperazioni.GetString("CONNESBEN"))))) {
                /* _numsto := arfn_chkspers(tmp_stpoperazioni->CONNESBEN,tmp_stpoperazioni->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_tmp_stpoperazioni.GetString("CONNESBEN"),Cursor_tmp_stpoperazioni.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000BE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000C0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_tmp_stpoperazioni.Next();
            }
            m_cConnectivityError = Cursor_tmp_stpoperazioni.ErrorMessage();
            Cursor_tmp_stpoperazioni.Close();
            // * --- End Select
          } // End If
          /* ElseIf w_TipoStampa='S' */
        } else if (CPLib.eqr(w_TipoStampa,"S")) {
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            // * --- Select from qbe_alloperazbo
            SPBridge.HMCaller _h000000C2;
            _h000000C2 = new SPBridge.HMCaller();
            _h000000C2.Set("m_cVQRList",m_cVQRList);
            _h000000C2.Set("c_adataope",w_c_adataope);
            _h000000C2.Set("c_adatareg",w_c_adatareg);
            _h000000C2.Set("c_dadataope",w_c_dadataope);
            _h000000C2.Set("c_dadatareg",w_c_dadatareg);
            _h000000C2.Set("CodCli",w_CONNES);
            _h000000C2.Set("CodDip",w_Dipendenza);
            _h000000C2.Set("Con_Contanti",w_Con_Contanti);
            _h000000C2.Set("tipoOperaz",w_TipoOpeStampa);
            _h000000C2.Set("dadataret",(CPLib.Empty(w_DaDatRet)?CPLib.NullDate():w_DaDatRet));
            _h000000C2.Set("adataret",(CPLib.Empty(w_ADatRet)?CPLib.NullDate():w_ADatRet));
            _h000000C2.Set("StatoLower",w_StatoLower);
            _h000000C2.Set("StatoUpper",w_StatoUpper);
            if (Cursor_qbe_alloperazbo!=null)
              Cursor_qbe_alloperazbo.Close();
            Cursor_qbe_alloperazbo = new VQRHolder("qbe_alloperazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000C2,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_alloperazbo.Eof())) {
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000C3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000C3(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_alloperazbo.GetString("MITGDOC")),"?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              Cursor_qbe_alloperazbo.Next();
            }
            m_cConnectivityError = Cursor_qbe_alloperazbo.ErrorMessage();
            Cursor_qbe_alloperazbo.Close();
            // * --- End Select
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            // * --- Select from qbe_alloperazbo_prv
            SPBridge.HMCaller _h000000C4;
            _h000000C4 = new SPBridge.HMCaller();
            _h000000C4.Set("m_cVQRList",m_cVQRList);
            _h000000C4.Set("c_adataope",w_c_adataope);
            _h000000C4.Set("c_adatareg",w_c_adatareg);
            _h000000C4.Set("c_dadataope",w_c_dadataope);
            _h000000C4.Set("c_dadatareg",w_c_dadatareg);
            _h000000C4.Set("CodCli",w_CONNES);
            _h000000C4.Set("CodDip",w_Dipendenza);
            _h000000C4.Set("Con_Contanti",w_Con_Contanti);
            _h000000C4.Set("tipoOperaz",w_TipoOpeStampa);
            _h000000C4.Set("dadataret",(CPLib.Empty(w_DaDatRet)?CPLib.NullDate():w_DaDatRet));
            _h000000C4.Set("adataret",(CPLib.Empty(w_ADatRet)?CPLib.NullDate():w_ADatRet));
            _h000000C4.Set("StatoLower",w_StatoLower);
            _h000000C4.Set("StatoUpper",w_StatoUpper);
            if (Cursor_qbe_alloperazbo_prv!=null)
              Cursor_qbe_alloperazbo_prv.Close();
            Cursor_qbe_alloperazbo_prv = new VQRHolder("qbe_alloperazbo_prv",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000C4,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_alloperazbo_prv.Eof())) {
              // * --- Insert into tmp_stpoperazioni from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
              m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000C5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000C5(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDate("DATARETT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("STATOREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_alloperazbo_prv.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_alloperazbo_prv.GetString("MITGDOC")),"?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              Cursor_qbe_alloperazbo_prv.Next();
            }
            m_cConnectivityError = Cursor_qbe_alloperazbo_prv.ErrorMessage();
            Cursor_qbe_alloperazbo_prv.Close();
            // * --- End Select
          } // End If
          /* _conta := 0 */
          _conta = CPLib.Round(0,0);
          // * --- Select from qbe_tot_tmp_operazioni
          if (Cursor_qbe_tot_tmp_operazioni!=null)
            Cursor_qbe_tot_tmp_operazioni.Close();
          Cursor_qbe_tot_tmp_operazioni = new VQRHolder("qbe_tot_tmp_operazioni",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tot_tmp_operazioni.Eof())) {
            /* _conta := qbe_tot_tmp_operazioni->Totale */
            _conta = CPLib.Round(Cursor_qbe_tot_tmp_operazioni.GetDouble("Totale"),0);
            Cursor_qbe_tot_tmp_operazioni.Next();
          }
          m_cConnectivityError = Cursor_qbe_tot_tmp_operazioni.ErrorMessage();
          Cursor_qbe_tot_tmp_operazioni.Close();
          // * --- End Select
          /* If _conta=0 */
          if (CPLib.eqr(_conta,0)) {
            // * --- Insert into tmp_stpoperazioni from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000CA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000CA(m_Ctx,m_oWrInfo);
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
              throw new RoutineException();
            }
          } else { // Else
            // * --- Select from tmp_stpoperazioni
            m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
            m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
            if (Cursor_tmp_stpoperazioni!=null)
              Cursor_tmp_stpoperazioni.Close();
            Cursor_tmp_stpoperazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_stpoperazioni")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_stpoperazioni.Eof())) {
              /* If not(Empty(LRTrim(tmp_stpoperazioni->CONNESCLI))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_stpoperazioni.GetString("CONNESCLI"))))) {
                /* _numsto := arfn_chkspers(tmp_stpoperazioni->CONNESCLI,tmp_stpoperazioni->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_tmp_stpoperazioni.GetString("CONNESCLI"),Cursor_tmp_stpoperazioni.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000D0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGCLI = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000D2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGCLI = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              /* If not(Empty(LRTrim(tmp_stpoperazioni->CONNESOPER))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_stpoperazioni.GetString("CONNESOPER"))))) {
                /* _numsto := arfn_chkspers(tmp_stpoperazioni->CONNESOPER,tmp_stpoperazioni->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_tmp_stpoperazioni.GetString("CONNESOPER"),Cursor_tmp_stpoperazioni.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000D7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGOPE = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000D9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGOPE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              /* If not(Empty(LRTrim(tmp_stpoperazioni->CONNESBEN))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_tmp_stpoperazioni.GetString("CONNESBEN"))))) {
                /* _numsto := arfn_chkspers(tmp_stpoperazioni->CONNESBEN,tmp_stpoperazioni->DATAREG) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_tmp_stpoperazioni.GetString("CONNESBEN"),Cursor_tmp_stpoperazioni.GetDate("DATAREG"));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000DE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } else { // Else
                  // * --- Select from wersonbo
                  m_cServer = m_Ctx.GetServer("wersonbo");
                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                  if (Cursor_wersonbo!=null)
                    Cursor_wersonbo.Close();
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    // * --- Write into tmp_stpoperazioni from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_stpoperazioni");
                    m_cPhName = m_Ctx.GetPhName("tmp_stpoperazioni");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpoperazioni",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000000E0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CTA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_IND = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
                    m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",5,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_stpoperazioni",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_stpoperazioni.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_stpoperazioni.GetString("IDBASE"))+"";
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
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
              Cursor_tmp_stpoperazioni.Next();
            }
            m_cConnectivityError = Cursor_tmp_stpoperazioni.ErrorMessage();
            Cursor_tmp_stpoperazioni.Close();
            // * --- End Select
          } // End If
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000067status,0)) {
          m_Sql.SetTransactionStatus(nTry00000067status,cTry00000067msg);
        }
      }
      /* Preparativi alla stampa nel report */
      /* If w_TipoStampa='D' */
      if (CPLib.eqr(w_TipoStampa,"D")) {
        /* If w_TipoOpeStampa='E' */
        if (CPLib.eqr(w_TipoOpeStampa,"E")) {
          /* _fonte_arch := 'Operazioni e Frazionate' */
          _fonte_arch = "Operazioni e Frazionate";
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            /* _reportname := 'Operazioni_e_Frazionate_dettaglio_AUI_'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_e_Frazionate_dettaglio_AUI_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            /* _reportname := 'Operazioni_e_Frazionate_dettaglio_PROVVISORIO'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_e_Frazionate_dettaglio_PROVVISORIO"+CPLib.DateTimeToChar(CPLib.DateTime());
          } // End If
          /* ElseIf w_TipoOpeStampa='O' */
        } else if (CPLib.eqr(w_TipoOpeStampa,"O")) {
          /* _fonte_arch := 'Operazioni' */
          _fonte_arch = "Operazioni";
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            /* _reportname := 'Operazioni_dettaglio_AUI_'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_dettaglio_AUI_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            /* _reportname := 'Operazioni_dettaglio_PROVVISORIO'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_dettaglio_PROVVISORIO"+CPLib.DateTimeToChar(CPLib.DateTime());
          } // End If
          /* ElseIf w_TipoOpeStampa='F' */
        } else if (CPLib.eqr(w_TipoOpeStampa,"F")) {
          /* _fonte_arch := 'Frazionate' */
          _fonte_arch = "Frazionate";
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            /* _reportname := 'Frazionate_dettaglio_AUI_'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Frazionate_dettaglio_AUI_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* _tipo_arch := 'A.U.I' */
            _tipo_arch = "A.U.I";
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            /* _reportname := 'Frazionate_dettaglio_PROVVISORIO'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Frazionate_dettaglio_PROVVISORIO"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* _tipo_arch := 'PROVVISORIO' */
            _tipo_arch = "PROVVISORIO";
          } // End If
        } // End If
        /* ElseIf w_TipoStampa='A' */
      } else if (CPLib.eqr(w_TipoStampa,"A")) {
        /* If w_TipoOpeStampa='E' */
        if (CPLib.eqr(w_TipoOpeStampa,"E")) {
          /* _fonte_arch := 'Operazioni e Frazionate' */
          _fonte_arch = "Operazioni e Frazionate";
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            /* _reportname := 'Operazioni_e_Frazionate_Analitica_AUI_'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_e_Frazionate_Analitica_AUI_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            /* _reportname := 'Operazioni_e_Frazionate_Analitica_PROVVISORIO'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_e_Frazionate_Analitica_PROVVISORIO"+CPLib.DateTimeToChar(CPLib.DateTime());
          } // End If
          /* ElseIf w_TipoOpeStampa='O' */
        } else if (CPLib.eqr(w_TipoOpeStampa,"O")) {
          /* _fonte_arch := 'Operazioni' */
          _fonte_arch = "Operazioni";
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            /* _reportname := 'Operazioni_Analitica_AUI_'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_Analitica_AUI_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            /* _reportname := 'Operazioni_Analitica_PROVVISORIO'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_Analitica_PROVVISORIO"+CPLib.DateTimeToChar(CPLib.DateTime());
          } // End If
          /* ElseIf w_TipoOpeStampa='F' */
        } else if (CPLib.eqr(w_TipoOpeStampa,"F")) {
          /* _fonte_arch := 'Frazionate' */
          _fonte_arch = "Frazionate";
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            /* _reportname := 'Frazionate_Analitica_AUI_'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Frazionate_Analitica_AUI_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            /* _reportname := 'Frazionate_Analitica_PROVVISORIO'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Frazionate_Analitica_PROVVISORIO"+CPLib.DateTimeToChar(CPLib.DateTime());
          } // End If
        } // End If
        /* ElseIf w_TipoStampa='S' */
      } else if (CPLib.eqr(w_TipoStampa,"S")) {
        /* If w_TipoOpeStampa='E' */
        if (CPLib.eqr(w_TipoOpeStampa,"E")) {
          /* _fonte_arch := 'Operazioni e Frazionate' */
          _fonte_arch = "Operazioni e Frazionate";
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            /* _reportname := 'Operazioni_e_Frazionate_Sintetica_AUI_'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_e_Frazionate_Sintetica_AUI_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            /* _reportname := 'Operazioni_e_Frazionate_Sintetica_PROVVISORIO'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_e_Frazionate_Sintetica_PROVVISORIO"+CPLib.DateTimeToChar(CPLib.DateTime());
          } // End If
          /* ElseIf w_TipoOpeStampa='O' */
        } else if (CPLib.eqr(w_TipoOpeStampa,"O")) {
          /* _fonte_arch := 'Operazioni' */
          _fonte_arch = "Operazioni";
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            /* _reportname := 'Operazioni_Sintetica_AUI_'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_Sintetica_AUI_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            /* _reportname := 'Operazioni_Sintetica_PROVVISORIO'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Operazioni_Sintetica_PROVVISORIO"+CPLib.DateTimeToChar(CPLib.DateTime());
          } // End If
          /* ElseIf w_TipoOpeStampa='F' */
        } else if (CPLib.eqr(w_TipoOpeStampa,"F")) {
          /* _fonte_arch := 'Frazionate' */
          _fonte_arch = "Frazionate";
          /* If w_Ambito='D' */
          if (CPLib.eqr(w_Ambito,"D")) {
            /* _reportname := 'Frazionate_Sintetica_AUI_'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Frazionate_Sintetica_AUI_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* ElseIf w_Ambito='P' */
          } else if (CPLib.eqr(w_Ambito,"P")) {
            /* _reportname := 'Frazionate_Sintetica_PROVVISORIO'+DateTimeToChar(DateTime()) // Nome del report */
            _reportname = "Frazionate_Sintetica_PROVVISORIO"+CPLib.DateTimeToChar(CPLib.DateTime());
          } // End If
        } // End If
      } // End If
      /* If w_Ambito='D' */
      if (CPLib.eqr(w_Ambito,"D")) {
        /* _tipo_arch := 'A.U.I' */
        _tipo_arch = "A.U.I";
        /* ElseIf w_Ambito='P' */
      } else if (CPLib.eqr(w_Ambito,"P")) {
        /* _tipo_arch := 'PROVVISORIO' */
        _tipo_arch = "PROVVISORIO";
      } // End If
      /* If gFlgDoc='S' */
      if (CPLib.eqr(gFlgDoc,"S")) {
        /* -- cosa è questa cosa???? */
        /* _ftypes := 'PDF' */
        _ftypes = "PDF";
        /* _nomereport := 'arrp_stpfraz_sa_doc.vrp' */
        _nomereport = "arrp_stpfraz_sa_doc.vrp";
        /* _fmodels := "" // tipi di file previsti per il report (pdf, xls, ... ) */
        _fmodels = "";
        /* Stop _nomereport */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("rotation",_rotate);
        f.SetParameter("c_dadata",w_c_dadataope);
        f.SetParameter("c_adata",w_c_adataope);
        f.SetParameter("daCodCli",w_CONNES);
        f.SetParameter("aCodCli",w_CONNES);
        f.SetParameter("OrderBy",w_OrderBy);
        f.SetParameter("ambito","P");
        f.SetParameter("formatTypes",_ftypes);
        f.SetParameter("formatModels",_fmodels);
        f.SetParameter("ReportName",_nomereport);
        f.SetParameter("m_cParameterSequence","rotation"+","+"c_dadata"+","+"c_adata"+","+"daCodCli"+","+"aCodCli"+","+"OrderBy"+","+"ambito"+","+"formatTypes"+","+"formatModels"+","+"ReportName");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* If _conta<>0 */
        if (CPLib.ne(_conta,0)) {
          /* _ftypes := 'PDF|XLS|XLSX|CSV' */
          _ftypes = "PDF|XLS|XLSX|CSV";
          /* _fmodels := "|||" // tipi di file previsti per il report (pdf, xls, ... ) */
          _fmodels = "|||";
          /* _rotate := 'PORTRAIT' */
          _rotate = "PORTRAIT";
          /* If w_TipoStampa='D' */
          if (CPLib.eqr(w_TipoStampa,"D")) {
            /* _nomereport := 'arrp_stpfraz_sa.vrp' // Dettaglio Anagrafico */
            _nomereport = "arrp_stpfraz_sa.vrp";
            /* ElseIf w_TipoStampa='A' */
          } else if (CPLib.eqr(w_TipoStampa,"A")) {
            /* _nomereport := 'arrp_stpoperana.vrp' // Analitica */
            _nomereport = "arrp_stpoperana.vrp";
            /* ElseIf w_TipoStampa='S' */
          } else if (CPLib.eqr(w_TipoStampa,"S")) {
            /* _rotate := 'LANDSCAPE' */
            _rotate = "LANDSCAPE";
            /* _nomereport := 'arrp_stpoper.vrp' // Sintetica */
            _nomereport = "arrp_stpoper.vrp";
          } // End If
          /* ElseIf _conta=0 */
        } else if (CPLib.eqr(_conta,0)) {
          /* _ftypes := 'PDF' */
          _ftypes = "PDF";
          /* _fmodels := "" // tipi di file previsti per il report (pdf, xls, ... ) */
          _fmodels = "";
          /* _rotate := 'PORTRAIT' */
          _rotate = "PORTRAIT";
          /* _nomereport := 'arrp_stpoper_neg.vrp' // stampa negativa (non ci sono elementi da mostrare) */
          _nomereport = "arrp_stpoper_neg.vrp";
        } // End If
      } // End If
      /* Stop _nomereport */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("rotation",_rotate);
      f.SetParameter("FileName",_reportname);
      f.SetParameter("w_c_dadataope",w_c_dadataope);
      f.SetParameter("w_c_adataope",w_c_adataope);
      f.SetParameter("w_c_dadatareg",w_c_dadatareg);
      f.SetParameter("w_c_adatareg",w_c_adatareg);
      f.SetParameter("w_c_dadataret",w_c_dadataret);
      f.SetParameter("w_c_adataret",w_c_adataret);
      f.SetParameter("w_CodCli",w_CONNES);
      f.SetParameter("w_CodDip",w_Dipendenza);
      f.SetParameter("w_OrderBy",w_OrderBy);
      f.SetParameter("tipo_arch",_tipo_arch);
      f.SetParameter("fonte_arch",_fonte_arch);
      f.SetParameter("showParameterMask",false);
      f.SetParameter("DescAzi",gDescAzi);
      f.SetParameter("stato",w_Stato);
      f.SetParameter("formatTypes",_ftypes);
      f.SetParameter("formatModels",_fmodels);
      f.SetParameter("ReportName",_nomereport);
      f.SetParameter("m_cParameterSequence","rotation"+","+"FileName"+","+"w_c_dadataope"+","+"w_c_adataope"+","+"w_c_dadatareg"+","+"w_c_adatareg"+","+"w_c_dadataret"+","+"w_c_adataret"+","+"w_CodCli"+","+"w_CodDip"+","+"w_OrderBy"+","+"tipo_arch"+","+"fonte_arch"+","+"showParameterMask"+","+"DescAzi"+","+"stato"+","+"formatTypes"+","+"formatModels"+","+"ReportName");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_tot_tmp_stpope_dett_anag!=null)
          Cursor_qbe_tot_tmp_stpope_dett_anag.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_alloperazbo!=null)
          Cursor_qbe_alloperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_alloperazbo_prv!=null)
          Cursor_qbe_alloperazbo_prv.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tot_tmp_operazioni!=null)
          Cursor_qbe_tot_tmp_operazioni.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_stpoperazioni!=null)
          Cursor_tmp_stpoperazioni.Close();
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
  void Page_2() throws Exception {
    CPResultSet Cursor_mlientifrz=null;
    CPResultSet Cursor_mogopefbo=null;
    CPResultSet Cursor_meneficfrz=null;
    CPResultSet Cursor_merzistifrz=null;
    try {
      /* If _mlientifrz */
      if (_mlientifrz) {
        // * --- Select from mlientifrz
        m_cServer = m_Ctx.GetServer("mlientifrz");
        m_cPhName = m_Ctx.GetPhName("mlientifrz");
        if (Cursor_mlientifrz!=null)
          Cursor_mlientifrz.Close();
        Cursor_mlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("mlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_mlientifrz.Eof())) {
          /* If mlientifrz->CODSOG <> rwFraziobo.CONNESCLI */
          if (CPLib.ne(Cursor_mlientifrz.GetString("CODSOG"),rwFraziobo.CONNESCLI)) {
            /* _connes := mlientifrz->CODSOG // _connes del soggetto */
            _connes = Cursor_mlientifrz.GetString("CODSOG");
            /* ----------> elia mette le sue manine qui <----------------------------------------------------------------------------------------------------------------------------------------- */
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000012D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000012D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_mlientifrz.Next();
        }
        m_cConnectivityError = Cursor_mlientifrz.ErrorMessage();
        Cursor_mlientifrz.Close();
        // * --- End Select
      } // End If
      /* If _mogopefbo */
      if (_mogopefbo) {
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from mogopefbo
        m_cServer = m_Ctx.GetServer("mogopefbo");
        m_cPhName = m_Ctx.GetPhName("mogopefbo");
        if (Cursor_mogopefbo!=null)
          Cursor_mogopefbo.Close();
        Cursor_mogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("mogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_mogopefbo.Eof())) {
          /* If mogopefbo->CODSOG <> rwFraziobo.CONNESOPER */
          if (CPLib.ne(Cursor_mogopefbo.GetString("CODSOG"),rwFraziobo.CONNESOPER)) {
            /* _connes := mogopefbo->CODSOG // _connes del soggetto */
            _connes = Cursor_mogopefbo.GetString("CODSOG");
            /* ----------> elia mette le sue manine qui <----------------------------------------------------------------------------------------------------------------------------------------- */
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000137")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000137(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_mogopefbo.Next();
        }
        m_cConnectivityError = Cursor_mogopefbo.ErrorMessage();
        Cursor_mogopefbo.Close();
        // * --- End Select
      } // End If
      /* If _meneficfrz */
      if (_meneficfrz) {
        /* Cerco se gli altri soggetti controparti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from meneficfrz
        m_cServer = m_Ctx.GetServer("meneficfrz");
        m_cPhName = m_Ctx.GetPhName("meneficfrz");
        if (Cursor_meneficfrz!=null)
          Cursor_meneficfrz.Close();
        Cursor_meneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("meneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_meneficfrz.Eof())) {
          /* If not(Empty(meneficfrz->CODSOG)) and meneficfrz->CODSOG <> rwFraziobo.CONNESBEN */
          if ( ! (CPLib.Empty(Cursor_meneficfrz.GetString("CODSOG"))) && CPLib.ne(Cursor_meneficfrz.GetString("CODSOG"),rwFraziobo.CONNESBEN)) {
            /* _connes := meneficfrz->CODSOG // _connes del soggetto */
            _connes = Cursor_meneficfrz.GetString("CODSOG");
            /* ----------> elia mette le sue manine qui <----------------------------------------------------------------------------------------------------------------------------------------- */
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000140")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000140(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          /* If not(Empty(LRTrim(meneficfrz->C_RAG))) and Empty(meneficfrz->CODSOG) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG")))) && CPLib.Empty(Cursor_meneficfrz.GetString("CODSOG"))) {
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000145")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000145(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
          Cursor_meneficfrz.Next();
        }
        m_cConnectivityError = Cursor_meneficfrz.ErrorMessage();
        Cursor_meneficfrz.Close();
        // * --- End Select
      } // End If
      /* If _merzistifrz */
      if (_merzistifrz) {
        /* Cerco se gli altri soggetti titolare effettivo dell operazione hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from merzistifrz
        m_cServer = m_Ctx.GetServer("merzistifrz");
        m_cPhName = m_Ctx.GetPhName("merzistifrz");
        if (Cursor_merzistifrz!=null)
          Cursor_merzistifrz.Close();
        Cursor_merzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("merzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_merzistifrz.Eof())) {
          /* If merzistifrz->CODSOG <> rwFraziobo.CONNALTRO */
          if (CPLib.ne(Cursor_merzistifrz.GetString("CODSOG"),rwFraziobo.CONNALTRO)) {
            /* _connes := merzistifrz->CODSOG // _connes del soggetto */
            _connes = Cursor_merzistifrz.GetString("CODSOG");
            /* ----------> elia mette le sue manine qui <----------------------------------------------------------------------------------------------------------------------------------------- */
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000014E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000014E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_merzistifrz.Next();
        }
        m_cConnectivityError = Cursor_merzistifrz.ErrorMessage();
        Cursor_merzistifrz.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_mlientifrz!=null)
          Cursor_mlientifrz.Close();
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
        if (Cursor_meneficfrz!=null)
          Cursor_meneficfrz.Close();
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    try {
      /* If _clientifrz */
      if (_clientifrz) {
        // * --- Select from clientifrz
        m_cServer = m_Ctx.GetServer("clientifrz");
        m_cPhName = m_Ctx.GetPhName("clientifrz");
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
        Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_clientifrz.Eof())) {
          /* If clientifrz->CODSOG <> rwFraziobo.CONNESCLI */
          if (CPLib.ne(Cursor_clientifrz.GetString("CODSOG"),rwFraziobo.CONNESCLI)) {
            /* _connes := clientifrz->CODSOG // _connes del soggetto */
            _connes = Cursor_clientifrz.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000156")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000156(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_clientifrz.Next();
        }
        m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
        Cursor_clientifrz.Close();
        // * --- End Select
      } // End If
      /* If _sogopefbo */
      if (_sogopefbo) {
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from sogopefbo
        m_cServer = m_Ctx.GetServer("sogopefbo");
        m_cPhName = m_Ctx.GetPhName("sogopefbo");
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
        Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopefbo.Eof())) {
          /* If sogopefbo->CODSOG <> rwFraziobo.CONNESOPER */
          if (CPLib.ne(Cursor_sogopefbo.GetString("CODSOG"),rwFraziobo.CONNESOPER)) {
            /* _connes := sogopefbo->CODSOG // _connes del soggetto */
            _connes = Cursor_sogopefbo.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000015F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000015F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_sogopefbo.Next();
        }
        m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
        Cursor_sogopefbo.Close();
        // * --- End Select
      } // End If
      /* If _beneficfrz */
      if (_beneficfrz) {
        /* Cerco se gli altri soggetti controparti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from beneficfrz
        m_cServer = m_Ctx.GetServer("beneficfrz");
        m_cPhName = m_Ctx.GetPhName("beneficfrz");
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
        Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_beneficfrz.Eof())) {
          /* If beneficfrz->CODSOG <> rwFraziobo.CONNESBEN and not(Empty(beneficfrz->CODSOG)) */
          if (CPLib.ne(Cursor_beneficfrz.GetString("CODSOG"),rwFraziobo.CONNESBEN) &&  ! (CPLib.Empty(Cursor_beneficfrz.GetString("CODSOG")))) {
            /* _connes := beneficfrz->CODSOG // _connes del soggetto */
            _connes = Cursor_beneficfrz.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000168")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000168(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          /* If not(Empty(LRTrim(beneficfrz->C_RAG))) and Empty(beneficfrz->CODSOG) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG")))) && CPLib.Empty(Cursor_beneficfrz.GetString("CODSOG"))) {
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000016C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000016C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
          Cursor_beneficfrz.Next();
        }
        m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
        Cursor_beneficfrz.Close();
        // * --- End Select
      } // End If
      /* If _terzistifrz */
      if (_terzistifrz) {
        /* Cerco se gli altri soggetti titolare effettivo dell operazione hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from terzistifrz
        m_cServer = m_Ctx.GetServer("terzistifrz");
        m_cPhName = m_Ctx.GetPhName("terzistifrz");
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
        Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_terzistifrz.Eof())) {
          /* If terzistifrz->CODSOG <> rwFraziobo.CONNALTRO */
          if (CPLib.ne(Cursor_terzistifrz.GetString("CODSOG"),rwFraziobo.CONNALTRO)) {
            /* _connes := terzistifrz->CODSOG // _connes del soggetto */
            _connes = Cursor_terzistifrz.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000174")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000174(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_terzistifrz.Next();
        }
        m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
        Cursor_terzistifrz.Close();
        // * --- End Select
      } // End If
    } finally {
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
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
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
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_mlientiope=null;
    CPResultSet Cursor_mogopebo=null;
    CPResultSet Cursor_meneficope=null;
    CPResultSet Cursor_merzistiope=null;
    try {
      /* If _mlientiope */
      if (_mlientiope) {
        // * --- Select from mlientiope
        m_cServer = m_Ctx.GetServer("mlientiope");
        m_cPhName = m_Ctx.GetPhName("mlientiope");
        if (Cursor_mlientiope!=null)
          Cursor_mlientiope.Close();
        Cursor_mlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("mlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_mlientiope.Eof())) {
          /* If mlientiope->CODSOG <> rwFraziobo.CONNESCLI */
          if (CPLib.ne(Cursor_mlientiope.GetString("CODSOG"),rwFraziobo.CONNESCLI)) {
            /* _connes := mlientiope->CODSOG // _connes del soggetto */
            _connes = Cursor_mlientiope.GetString("CODSOG");
            /* ----------> elia mette le sue manine qui <----------------------------------------------------------------------------------------------------------------------------------------- */
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000017D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000017D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_mlientiope.Next();
        }
        m_cConnectivityError = Cursor_mlientiope.ErrorMessage();
        Cursor_mlientiope.Close();
        // * --- End Select
      } // End If
      /* If _mogopebo */
      if (_mogopebo) {
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from mogopebo
        m_cServer = m_Ctx.GetServer("mogopebo");
        m_cPhName = m_Ctx.GetPhName("mogopebo");
        if (Cursor_mogopebo!=null)
          Cursor_mogopebo.Close();
        Cursor_mogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("mogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_mogopebo.Eof())) {
          /* If mogopebo->CODSOG <> rwFraziobo.CONNESOPER */
          if (CPLib.ne(Cursor_mogopebo.GetString("CODSOG"),rwFraziobo.CONNESOPER)) {
            /* _connes := mogopebo->CODSOG // _connes del soggetto */
            _connes = Cursor_mogopebo.GetString("CODSOG");
            /* ----------> elia mette le sue manine qui <----------------------------------------------------------------------------------------------------------------------------------------- */
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000187")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000187(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_mogopebo.Next();
        }
        m_cConnectivityError = Cursor_mogopebo.ErrorMessage();
        Cursor_mogopebo.Close();
        // * --- End Select
      } // End If
      /* If _meneficope */
      if (_meneficope) {
        /* Cerco se gli altri soggetti controparti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from meneficope
        m_cServer = m_Ctx.GetServer("meneficope");
        m_cPhName = m_Ctx.GetPhName("meneficope");
        if (Cursor_meneficope!=null)
          Cursor_meneficope.Close();
        Cursor_meneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("meneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_meneficope.Eof())) {
          /* If not(Empty(meneficope->CODSOG)) and meneficope->CODSOG <> rwFraziobo.CONNESBEN */
          if ( ! (CPLib.Empty(Cursor_meneficope.GetString("CODSOG"))) && CPLib.ne(Cursor_meneficope.GetString("CODSOG"),rwFraziobo.CONNESBEN)) {
            /* _connes := meneficope->CODSOG // _connes del soggetto */
            _connes = Cursor_meneficope.GetString("CODSOG");
            /* ----------> elia mette le sue manine qui <----------------------------------------------------------------------------------------------------------------------------------------- */
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000191")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000191(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          /* If not(Empty(LRTrim(meneficope->C_RAG))) and Empty(meneficope->CODSOG) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG")))) && CPLib.Empty(Cursor_meneficope.GetString("CODSOG"))) {
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000195")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000195(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_meneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
          Cursor_meneficope.Next();
        }
        m_cConnectivityError = Cursor_meneficope.ErrorMessage();
        Cursor_meneficope.Close();
        // * --- End Select
      } // End If
      /* If _merzistiope */
      if (_merzistiope) {
        /* Cerco se gli altri soggetti titolare effettivo dell operazione hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from merzistiope
        m_cServer = m_Ctx.GetServer("merzistiope");
        m_cPhName = m_Ctx.GetPhName("merzistiope");
        if (Cursor_merzistiope!=null)
          Cursor_merzistiope.Close();
        Cursor_merzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("merzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_merzistiope.Eof())) {
          /* If merzistiope->CODSOG <> rwFraziobo.CONNALTRO */
          if (CPLib.ne(Cursor_merzistiope.GetString("CODSOG"),rwFraziobo.CONNALTRO)) {
            /* _connes := merzistiope->CODSOG // _connes del soggetto */
            _connes = Cursor_merzistiope.GetString("CODSOG");
            /* ----------> elia mette le sue manine qui <----------------------------------------------------------------------------------------------------------------------------------------- */
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000019E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000019E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_merzistiope.Next();
        }
        m_cConnectivityError = Cursor_merzistiope.ErrorMessage();
        Cursor_merzistiope.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_mlientiope!=null)
          Cursor_mlientiope.Close();
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
        if (Cursor_meneficope!=null)
          Cursor_meneficope.Close();
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
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_terzistiope=null;
    try {
      /* If _clientiope */
      if (_clientiope) {
        // * --- Select from clientiope
        m_cServer = m_Ctx.GetServer("clientiope");
        m_cPhName = m_Ctx.GetPhName("clientiope");
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
        Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_clientiope.Eof())) {
          /* If clientiope->CODSOG <> rwFraziobo.CONNESCLI */
          if (CPLib.ne(Cursor_clientiope.GetString("CODSOG"),rwFraziobo.CONNESCLI)) {
            /* _connes := clientiope->CODSOG // _connes del soggetto */
            _connes = Cursor_clientiope.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000001A6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001A6(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_clientiope.Next();
        }
        m_cConnectivityError = Cursor_clientiope.ErrorMessage();
        Cursor_clientiope.Close();
        // * --- End Select
      } // End If
      /* If _sogopebo */
      if (_sogopebo) {
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from sogopebo
        m_cServer = m_Ctx.GetServer("sogopebo");
        m_cPhName = m_Ctx.GetPhName("sogopebo");
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
        Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_sogopebo.Eof())) {
          /* If sogopebo->CODSOG <> rwFraziobo.CONNESOPER */
          if (CPLib.ne(Cursor_sogopebo.GetString("CODSOG"),rwFraziobo.CONNESOPER)) {
            /* _connes := sogopebo->CODSOG // _connes del soggetto */
            _connes = Cursor_sogopebo.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000001AF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001AF(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_sogopebo.Next();
        }
        m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
        Cursor_sogopebo.Close();
        // * --- End Select
      } // End If
      /* If _beneficope */
      if (_beneficope) {
        /* Cerco se gli altri soggetti controparti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from beneficope
        m_cServer = m_Ctx.GetServer("beneficope");
        m_cPhName = m_Ctx.GetPhName("beneficope");
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
        Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_beneficope.Eof())) {
          /* If beneficope->CODSOG <> rwFraziobo.CONNESBEN and not(Empty(beneficope->CODSOG)) */
          if (CPLib.ne(Cursor_beneficope.GetString("CODSOG"),rwFraziobo.CONNESBEN) &&  ! (CPLib.Empty(Cursor_beneficope.GetString("CODSOG")))) {
            /* _connes := beneficope->CODSOG // _connes del soggetto */
            _connes = Cursor_beneficope.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000001B8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001B8(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          /* If not(Empty(LRTrim(beneficope->C_RAG))) and Empty(beneficope->CODSOG) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG")))) && CPLib.Empty(Cursor_beneficope.GetString("CODSOG"))) {
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000001BC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001BC(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
          Cursor_beneficope.Next();
        }
        m_cConnectivityError = Cursor_beneficope.ErrorMessage();
        Cursor_beneficope.Close();
        // * --- End Select
      } // End If
      /* If _terzistiope */
      if (_terzistiope) {
        /* Cerco se gli altri soggetti titolare effettivo dell operazione hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from terzistiope
        m_cServer = m_Ctx.GetServer("terzistiope");
        m_cPhName = m_Ctx.GetPhName("terzistiope");
        if (Cursor_terzistiope!=null)
          Cursor_terzistiope.Close();
        Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_terzistiope.Eof())) {
          /* If terzistiope->CODSOG <> rwFraziobo.CONNALTRO */
          if (CPLib.ne(Cursor_terzistiope.GetString("CODSOG"),rwFraziobo.CONNALTRO)) {
            /* _connes := terzistiope->CODSOG // _connes del soggetto */
            _connes = Cursor_terzistiope.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000001C4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001C4(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_terzistiope.Next();
        }
        m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
        Cursor_terzistiope.Close();
        // * --- End Select
      } // End If
    } finally {
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
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
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
    }
  }
  void Page_6() throws Exception {
    CPResultSet Cursor_rapotit=null;
    CPResultSet Cursor_intestit=null;
    try {
      /* If w_EstrazTitEffNelPeriodo <> 'X' */
      if (CPLib.ne(w_EstrazTitEffNelPeriodo,"X")) {
        // * --- Select from rapotit
        m_cServer = m_Ctx.GetServer("rapotit");
        m_cPhName = m_Ctx.GetPhName("rapotit");
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
        Cursor_rapotit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapotit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_rapotit.Eof())) {
          // * --- Select from intestit
          m_cServer = m_Ctx.GetServer("intestit");
          m_cPhName = m_Ctx.GetPhName("intestit");
          if (Cursor_intestit!=null)
            Cursor_intestit.Close();
          Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_rapotit.GetString("CONNESCLI"),"?",0,0)+"=CODCLI AND ("+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0)+"=NUMPROG1 OR "+CPLib.ToSQL(Cursor_rapotit.GetString("NUMPROG"),"?",0,0)+"=NUMPROG2) "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestit.Eof())) {
            /* If (w_EstrazTitEffNelPeriodo='S' and _dataope >= intestit->DATAINI and (_dataope <= intestit->DATAFINE or Empty(intestit->DATAFINE))) or (w_EstrazTitEffNelPeriodo='N') */
            if ((CPLib.eqr(w_EstrazTitEffNelPeriodo,"S") && CPLib.ge(_dataope,Cursor_intestit.GetDate("DATAINI")) && (CPLib.le(_dataope,Cursor_intestit.GetDate("DATAFINE")) || CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")))) || (CPLib.eqr(w_EstrazTitEffNelPeriodo,"N"))) {
              /* rowSoggetti := DatiSoggetto(intestit->CODINTER,iif(rapotit->STATOREG='1',rapotit->DATARETT,rapotit->DATAOPE)) */
              rowSoggetti = DatiSoggetto(Cursor_intestit.GetString("CODINTER"),(CPLib.eqr(Cursor_rapotit.GetString("STATOREG"),"1")?Cursor_rapotit.GetDate("DATARETT"):Cursor_rapotit.GetDate("DATAOPE")));
              /* progrIns := progrIns+1 */
              progrIns = CPLib.Round(progrIns+1,0);
              // * --- Insert into tmp_stpope_dett_anag from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
              m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"000001CC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000001CC(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            Cursor_intestit.Next();
          }
          m_cConnectivityError = Cursor_intestit.ErrorMessage();
          Cursor_intestit.Close();
          // * --- End Select
          Cursor_rapotit.Next();
        }
        m_cConnectivityError = Cursor_rapotit.ErrorMessage();
        Cursor_rapotit.Close();
        // * --- End Select
      } // End If
    } finally {
      try {
        if (Cursor_rapotit!=null)
          Cursor_rapotit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  MemoryCursorRow_personbo DatiSoggetto(String pCodCli,java.sql.Date pDatChk) throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_qbe_wersonbo_cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pCodCli Char(16) */
      /* pDatChk Date */
      /* _stonum Char(15) */
      String _stonum;
      _stonum = CPLib.Space(15);
      /* rwSoggetti Row(personbo) */
      MemoryCursorRow_personbo rwSoggetti;
      rwSoggetti = new MemoryCursorRow_personbo();
      /* memcSoggetti MemoryCursor(personbo) */
      MemoryCursor_personbo memcSoggetti;
      memcSoggetti = new MemoryCursor_personbo();
      /* memcSoggetti.Zap() */
      memcSoggetti.Zap();
      /* _stonum := arfn_chkspers(pCodCli,pDatChk) */
      _stonum = arfn_chkspersR.Make(m_Ctx,this).Run(pCodCli,pDatChk);
      /* If Empty(LRTrim(_stonum)) */
      if (CPLib.Empty(CPLib.LRTrim(_stonum))) {
        // * --- Fill memory cursor memcSoggetti on personbo
        memcSoggetti.Zap();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodCli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_personbo;
          Cursor_personbo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stp_ope_fraz_all: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_personbo.Eof())) {
          memcSoggetti.AppendBlank();
          memcSoggetti.row.CONNES = Cursor_personbo.GetString("CONNES");
          memcSoggetti.row.CODCAB = Cursor_personbo.GetString("CODCAB");
          memcSoggetti.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
          memcSoggetti.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
          memcSoggetti.row.CODFISC = Cursor_personbo.GetString("CODFISC");
          memcSoggetti.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
          memcSoggetti.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
          memcSoggetti.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
          memcSoggetti.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
          memcSoggetti.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
          memcSoggetti.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
          memcSoggetti.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
          memcSoggetti.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
          memcSoggetti.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
          memcSoggetti.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
          memcSoggetti.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
          memcSoggetti.row.PAESE = Cursor_personbo.GetString("PAESE");
          memcSoggetti.row.CAP = Cursor_personbo.GetString("CAP");
          memcSoggetti.row.CODINTER = Cursor_personbo.GetString("CODINTER");
          memcSoggetti.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
          memcSoggetti.row.TIPOPERS = Cursor_personbo.GetString("TIPOPERS");
          memcSoggetti.row.CODDIPE = Cursor_personbo.GetString("CODDIPE");
          memcSoggetti.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
          memcSoggetti.row.NOTE = Cursor_personbo.GetString("NOTE");
          memcSoggetti.row.SESSO = Cursor_personbo.GetString("SESSO");
          memcSoggetti.row.SOSPMAF = Cursor_personbo.GetString("SOSPMAF");
          memcSoggetti.row.idcitta = Cursor_personbo.GetString("idcitta");
          memcSoggetti.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
          memcSoggetti.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
          memcSoggetti.row.DOCFILE = Cursor_personbo.GetString("DOCFILE");
          memcSoggetti.row.NOME = Cursor_personbo.GetString("NOME");
          memcSoggetti.row.COGNOME = Cursor_personbo.GetString("COGNOME");
          memcSoggetti.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
          memcSoggetti.row.OLDCONNES = Cursor_personbo.GetString("OLDCONNES");
          memcSoggetti.row.DATEXTRA = Cursor_personbo.GetDate("DATEXTRA");
          memcSoggetti.row.PKTBSPECIE = Cursor_personbo.GetString("PKTBSPECIE");
          memcSoggetti.row.COMPORT = Cursor_personbo.GetString("COMPORT");
          memcSoggetti.row.ATTIV = Cursor_personbo.GetString("ATTIV");
          memcSoggetti.row.RNATGIU = Cursor_personbo.GetDouble("RNATGIU");
          memcSoggetti.row.RATTIV = Cursor_personbo.GetDouble("RATTIV");
          memcSoggetti.row.RCOMP = Cursor_personbo.GetDouble("RCOMP");
          memcSoggetti.row.RAREA = Cursor_personbo.GetDouble("RAREA");
          memcSoggetti.row.ALLINEATO = Cursor_personbo.GetDouble("ALLINEATO");
          memcSoggetti.row.ALLINEATONOMECNOME = Cursor_personbo.GetDouble("ALLINEATONOMECNOME");
          memcSoggetti.row.RAGSOCOLD = Cursor_personbo.GetString("RAGSOCOLD");
          memcSoggetti.row.PROGIMPORT = Cursor_personbo.GetDouble("PROGIMPORT");
          memcSoggetti.row.PROGIMP_C = Cursor_personbo.GetString("PROGIMP_C");
          memcSoggetti.row.AREAGEO = Cursor_personbo.GetString("AREAGEO");
          memcSoggetti.row.PEP = Cursor_personbo.GetString("PEP");
          memcSoggetti.row.IDFILE = Cursor_personbo.GetString("IDFILE");
          memcSoggetti.row.OLDCODFISC = Cursor_personbo.GetString("OLDCODFISC");
          memcSoggetti.row.MACROAGENTE = Cursor_personbo.GetString("MACROAGENTE");
          memcSoggetti.row.SPOTID = Cursor_personbo.GetString("SPOTID");
          memcSoggetti.row.DATASEGN = Cursor_personbo.GetDate("DATASEGN");
          memcSoggetti.row.OLDSETSIN = Cursor_personbo.GetString("OLDSETSIN");
          memcSoggetti.row.DATAVARAGE = Cursor_personbo.GetDate("DATAVARAGE");
          memcSoggetti.row.SETTSINT2 = Cursor_personbo.GetString("SETTSINT2");
          memcSoggetti.row.FATCA = Cursor_personbo.GetString("FATCA");
          memcSoggetti.row.BANCABEN = Cursor_personbo.GetString("BANCABEN");
          memcSoggetti.row.TIN = Cursor_personbo.GetString("TIN");
          memcSoggetti.row.ODB = Cursor_personbo.GetDouble("ODB");
          memcSoggetti.row.TELEF = Cursor_personbo.GetString("TELEF");
          memcSoggetti.row.TIPOORO = Cursor_personbo.GetString("TIPOORO");
          memcSoggetti.row.CODORO = Cursor_personbo.GetString("CODORO");
          memcSoggetti.row.IDNASCOMUN = Cursor_personbo.GetString("IDNASCOMUN");
          memcSoggetti.row.IDNASSTATO = Cursor_personbo.GetString("IDNASSTATO");
          memcSoggetti.row.NOTIT = Cursor_personbo.GetDouble("NOTIT");
          memcSoggetti.row.IDBASE = Cursor_personbo.GetString("IDBASE");
          memcSoggetti.row.FLGVALIDO = Cursor_personbo.GetString("FLGVALIDO");
          memcSoggetti.row.CITTADIN1 = Cursor_personbo.GetString("CITTADIN1");
          memcSoggetti.row.CITTADIN2 = Cursor_personbo.GetString("CITTADIN2");
          memcSoggetti.row.RESFISC = Cursor_personbo.GetString("RESFISC");
          memcSoggetti.row.MITIG = Cursor_personbo.GetDouble("MITIG");
          memcSoggetti.row.MITIGDOC = Cursor_personbo.GetString("MITIGDOC");
          memcSoggetti.row.NOSARA = Cursor_personbo.GetString("NOSARA");
          memcSoggetti.row.RISGLOB = Cursor_personbo.GetString("RISGLOB");
          memcSoggetti.row.DATAPROF = Cursor_personbo.GetDate("DATAPROF");
          memcSoggetti.row.DATAREVPROF = Cursor_personbo.GetDate("DATAREVPROF");
          memcSoggetti.row.IDENT = Cursor_personbo.GetString("IDENT");
          memcSoggetti.row.PEPDATE = Cursor_personbo.GetDate("PEPDATE");
          memcSoggetti.row.DAC6 = Cursor_personbo.GetString("DAC6");
          memcSoggetti.row.FLAGDAC6 = Cursor_personbo.GetDouble("FLAGDAC6");
          memcSoggetti.row.CRIME = Cursor_personbo.GetString("CRIME");
          memcSoggetti.row.CRIMEDATE = Cursor_personbo.GetDate("CRIMEDATE");
          memcSoggetti.row.ALTRODOM = Cursor_personbo.GetString("ALTRODOM");
          memcSoggetti.row.ALTROCAP = Cursor_personbo.GetString("ALTROCAP");
          memcSoggetti.row.CONTO = Cursor_personbo.GetString("CONTO");
          memcSoggetti.row.NUMIMP = Cursor_personbo.GetDateTime("NUMIMP");
          memcSoggetti.row.RAPSEGNA = Cursor_personbo.GetString("RAPSEGNA");
          memcSoggetti.row.CODLEGRAP = Cursor_personbo.GetString("CODLEGRAP");
          memcSoggetti.row.TIPOSOGGETTO = Cursor_personbo.GetString("TIPOSOGGETTO");
          memcSoggetti.row.CAUSALE = Cursor_personbo.GetDouble("CAUSALE");
          memcSoggetti.row.IMPORTOMAX = Cursor_personbo.GetDouble("IMPORTOMAX");
          memcSoggetti.row.FATTURATO = Cursor_personbo.GetDouble("FATTURATO");
          memcSoggetti.row.FREQUENZA = Cursor_personbo.GetString("FREQUENZA");
          memcSoggetti.row.NUMOPERAZ = Cursor_personbo.GetDouble("NUMOPERAZ");
          memcSoggetti.row.SOGAFFIDATARIO = Cursor_personbo.GetString("SOGAFFIDATARIO");
          memcSoggetti.row.FLGNOTRIM = Cursor_personbo.GetString("FLGNOTRIM");
          memcSoggetti.row.DISATTIVO = Cursor_personbo.GetDate("DISATTIVO");
          memcSoggetti.row.DATAFINE = Cursor_personbo.GetDate("DATAFINE");
          memcSoggetti.row.DATAINI = Cursor_personbo.GetDate("DATAINI");
          memcSoggetti.row.DATAIDENT = Cursor_personbo.GetDate("DATAIDENT");
          memcSoggetti.row.DATASIGN = Cursor_personbo.GetDate("DATASIGN");
          memcSoggetti.row.DATARAUT = Cursor_personbo.GetDate("DATARAUT");
          memcSoggetti.row.VERIFICA = Cursor_personbo.GetString("VERIFICA");
          memcSoggetti.row.NOTERIS = Cursor_personbo.GetString("NOTERIS");
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        memcSoggetti.GoTop();
      } else { // Else
        // * --- Fill memory cursor memcSoggetti on qbe_wersonbo_cursor
        memcSoggetti.Zap();
        SPBridge.HMCaller _h000001D9;
        _h000001D9 = new SPBridge.HMCaller();
        _h000001D9.Set("m_cVQRList",m_cVQRList);
        _h000001D9.Set("psanumpro",_stonum);
        if (Cursor_qbe_wersonbo_cursor!=null)
          Cursor_qbe_wersonbo_cursor.Close();
        Cursor_qbe_wersonbo_cursor = new VQRHolder("qbe_wersonbo_cursor",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001D9,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_wersonbo_cursor;
          Cursor_qbe_wersonbo_cursor.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stp_ope_fraz_all: query on qbe_wersonbo_cursor returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_wersonbo_cursor.Eof())) {
          memcSoggetti.AppendBlank();
          memcSoggetti.row.CONNES = Cursor_qbe_wersonbo_cursor.GetString("CONNES");
          memcSoggetti.row.CODCAB = Cursor_qbe_wersonbo_cursor.GetString("CODCAB");
          memcSoggetti.row.RAGSOC = Cursor_qbe_wersonbo_cursor.GetString("RAGSOC");
          memcSoggetti.row.DOMICILIO = Cursor_qbe_wersonbo_cursor.GetString("DOMICILIO");
          memcSoggetti.row.CODFISC = Cursor_qbe_wersonbo_cursor.GetString("CODFISC");
          memcSoggetti.row.DATANASC = Cursor_qbe_wersonbo_cursor.GetDate("DATANASC");
          memcSoggetti.row.NASCOMUN = Cursor_qbe_wersonbo_cursor.GetString("NASCOMUN");
          memcSoggetti.row.SOTGRUP = Cursor_qbe_wersonbo_cursor.GetString("SOTGRUP");
          memcSoggetti.row.RAMOGRUP = Cursor_qbe_wersonbo_cursor.GetString("RAMOGRUP");
          memcSoggetti.row.SETTSINT = Cursor_qbe_wersonbo_cursor.GetString("SETTSINT");
          memcSoggetti.row.TIPODOC = Cursor_qbe_wersonbo_cursor.GetString("TIPODOC");
          memcSoggetti.row.NUMDOCUM = Cursor_qbe_wersonbo_cursor.GetString("NUMDOCUM");
          memcSoggetti.row.DATARILASC = Cursor_qbe_wersonbo_cursor.GetDate("DATARILASC");
          memcSoggetti.row.AUTRILASC = Cursor_qbe_wersonbo_cursor.GetString("AUTRILASC");
          memcSoggetti.row.DESCCIT = Cursor_qbe_wersonbo_cursor.GetString("DESCCIT");
          memcSoggetti.row.PROVINCIA = Cursor_qbe_wersonbo_cursor.GetString("PROVINCIA");
          memcSoggetti.row.PAESE = Cursor_qbe_wersonbo_cursor.GetString("PAESE");
          memcSoggetti.row.CAP = Cursor_qbe_wersonbo_cursor.GetString("CAP");
          memcSoggetti.row.CODINTER = Cursor_qbe_wersonbo_cursor.GetString("CODINTER");
          memcSoggetti.row.TIPINTER = Cursor_qbe_wersonbo_cursor.GetString("TIPINTER");
          memcSoggetti.row.TIPOPERS = Cursor_qbe_wersonbo_cursor.GetString("TIPOPERS");
          memcSoggetti.row.CODDIPE = Cursor_qbe_wersonbo_cursor.GetString("CODDIPE");
          memcSoggetti.row.PARTIVA = Cursor_qbe_wersonbo_cursor.GetString("PARTIVA");
          memcSoggetti.row.NOTE = Cursor_qbe_wersonbo_cursor.GetString("NOTE");
          memcSoggetti.row.SESSO = Cursor_qbe_wersonbo_cursor.GetString("SESSO");
          memcSoggetti.row.SOSPMAF = Cursor_qbe_wersonbo_cursor.GetString("SOSPMAF");
          memcSoggetti.row.idcitta = Cursor_qbe_wersonbo_cursor.GetString("idcitta");
          memcSoggetti.row.DATAVALI = Cursor_qbe_wersonbo_cursor.GetDate("DATAVALI");
          memcSoggetti.row.NASSTATO = Cursor_qbe_wersonbo_cursor.GetString("NASSTATO");
          memcSoggetti.row.DOCFILE = Cursor_qbe_wersonbo_cursor.GetString("DOCFILE");
          memcSoggetti.row.NOME = Cursor_qbe_wersonbo_cursor.GetString("NOME");
          memcSoggetti.row.COGNOME = Cursor_qbe_wersonbo_cursor.GetString("COGNOME");
          memcSoggetti.row.CFESTERO = Cursor_qbe_wersonbo_cursor.GetDouble("CFESTERO");
          memcSoggetti.row.OLDCONNES = Cursor_qbe_wersonbo_cursor.GetString("OLDCONNES");
          memcSoggetti.row.DATEXTRA = Cursor_qbe_wersonbo_cursor.GetDate("DATEXTRA");
          memcSoggetti.row.PKTBSPECIE = Cursor_qbe_wersonbo_cursor.GetString("PKTBSPECIE");
          memcSoggetti.row.COMPORT = Cursor_qbe_wersonbo_cursor.GetString("COMPORT");
          memcSoggetti.row.ATTIV = Cursor_qbe_wersonbo_cursor.GetString("ATTIV");
          memcSoggetti.row.RNATGIU = Cursor_qbe_wersonbo_cursor.GetDouble("RNATGIU");
          memcSoggetti.row.RATTIV = Cursor_qbe_wersonbo_cursor.GetDouble("RATTIV");
          memcSoggetti.row.RCOMP = Cursor_qbe_wersonbo_cursor.GetDouble("RCOMP");
          memcSoggetti.row.RAREA = Cursor_qbe_wersonbo_cursor.GetDouble("RAREA");
          memcSoggetti.row.ALLINEATO = Cursor_qbe_wersonbo_cursor.GetDouble("ALLINEATO");
          memcSoggetti.row.ALLINEATONOMECNOME = Cursor_qbe_wersonbo_cursor.GetDouble("ALLINEATONOMECNOME");
          memcSoggetti.row.RAGSOCOLD = Cursor_qbe_wersonbo_cursor.GetString("RAGSOCOLD");
          memcSoggetti.row.PROGIMPORT = Cursor_qbe_wersonbo_cursor.GetDouble("PROGIMPORT");
          memcSoggetti.row.PROGIMP_C = Cursor_qbe_wersonbo_cursor.GetString("PROGIMP_C");
          memcSoggetti.row.AREAGEO = Cursor_qbe_wersonbo_cursor.GetString("AREAGEO");
          memcSoggetti.row.PEP = Cursor_qbe_wersonbo_cursor.GetString("PEP");
          memcSoggetti.row.IDFILE = Cursor_qbe_wersonbo_cursor.GetString("IDFILE");
          memcSoggetti.row.OLDCODFISC = Cursor_qbe_wersonbo_cursor.GetString("OLDCODFISC");
          memcSoggetti.row.MACROAGENTE = Cursor_qbe_wersonbo_cursor.GetString("MACROAGENTE");
          memcSoggetti.row.SPOTID = Cursor_qbe_wersonbo_cursor.GetString("SPOTID");
          memcSoggetti.row.DATASEGN = Cursor_qbe_wersonbo_cursor.GetDate("DATASEGN");
          memcSoggetti.row.OLDSETSIN = Cursor_qbe_wersonbo_cursor.GetString("OLDSETSIN");
          memcSoggetti.row.DATAVARAGE = Cursor_qbe_wersonbo_cursor.GetDate("DATAVARAGE");
          memcSoggetti.row.SETTSINT2 = Cursor_qbe_wersonbo_cursor.GetString("SETTSINT2");
          memcSoggetti.row.FATCA = Cursor_qbe_wersonbo_cursor.GetString("FATCA");
          memcSoggetti.row.BANCABEN = Cursor_qbe_wersonbo_cursor.GetString("BANCABEN");
          memcSoggetti.row.TIN = Cursor_qbe_wersonbo_cursor.GetString("TIN");
          memcSoggetti.row.ODB = Cursor_qbe_wersonbo_cursor.GetDouble("ODB");
          memcSoggetti.row.TELEF = Cursor_qbe_wersonbo_cursor.GetString("TELEF");
          memcSoggetti.row.TIPOORO = Cursor_qbe_wersonbo_cursor.GetString("TIPOORO");
          memcSoggetti.row.CODORO = Cursor_qbe_wersonbo_cursor.GetString("CODORO");
          memcSoggetti.row.IDNASCOMUN = Cursor_qbe_wersonbo_cursor.GetString("IDNASCOMUN");
          memcSoggetti.row.IDNASSTATO = Cursor_qbe_wersonbo_cursor.GetString("IDNASSTATO");
          memcSoggetti.row.NOTIT = Cursor_qbe_wersonbo_cursor.GetDouble("NOTIT");
          memcSoggetti.row.IDBASE = Cursor_qbe_wersonbo_cursor.GetString("IDBASE");
          memcSoggetti.row.FLGVALIDO = Cursor_qbe_wersonbo_cursor.GetString("FLGVALIDO");
          memcSoggetti.row.CITTADIN1 = Cursor_qbe_wersonbo_cursor.GetString("CITTADIN1");
          memcSoggetti.row.CITTADIN2 = Cursor_qbe_wersonbo_cursor.GetString("CITTADIN2");
          memcSoggetti.row.RESFISC = Cursor_qbe_wersonbo_cursor.GetString("RESFISC");
          memcSoggetti.row.MITIG = Cursor_qbe_wersonbo_cursor.GetDouble("MITIG");
          memcSoggetti.row.MITIGDOC = Cursor_qbe_wersonbo_cursor.GetString("MITIGDOC");
          memcSoggetti.row.NOSARA = Cursor_qbe_wersonbo_cursor.GetString("NOSARA");
          memcSoggetti.row.RISGLOB = Cursor_qbe_wersonbo_cursor.GetString("RISGLOB");
          memcSoggetti.row.DATAPROF = Cursor_qbe_wersonbo_cursor.GetDate("DATAPROF");
          memcSoggetti.row.DATAREVPROF = Cursor_qbe_wersonbo_cursor.GetDate("DATAREVPROF");
          memcSoggetti.row.IDENT = Cursor_qbe_wersonbo_cursor.GetString("IDENT");
          memcSoggetti.row.PEPDATE = Cursor_qbe_wersonbo_cursor.GetDate("PEPDATE");
          memcSoggetti.row.DAC6 = Cursor_qbe_wersonbo_cursor.GetString("DAC6");
          memcSoggetti.row.FLAGDAC6 = Cursor_qbe_wersonbo_cursor.GetDouble("FLAGDAC6");
          memcSoggetti.row.CRIME = Cursor_qbe_wersonbo_cursor.GetString("CRIME");
          memcSoggetti.row.CRIMEDATE = Cursor_qbe_wersonbo_cursor.GetDate("CRIMEDATE");
          memcSoggetti.row.ALTRODOM = Cursor_qbe_wersonbo_cursor.GetString("ALTRODOM");
          memcSoggetti.row.ALTROCAP = Cursor_qbe_wersonbo_cursor.GetString("ALTROCAP");
          memcSoggetti.row.CONTO = Cursor_qbe_wersonbo_cursor.GetString("CONTO");
          memcSoggetti.row.NUMIMP = Cursor_qbe_wersonbo_cursor.GetDateTime("NUMIMP");
          memcSoggetti.row.RAPSEGNA = Cursor_qbe_wersonbo_cursor.GetString("RAPSEGNA");
          memcSoggetti.row.CODLEGRAP = Cursor_qbe_wersonbo_cursor.GetString("CODLEGRAP");
          memcSoggetti.row.TIPOSOGGETTO = Cursor_qbe_wersonbo_cursor.GetString("TIPOSOGGETTO");
          memcSoggetti.row.CAUSALE = Cursor_qbe_wersonbo_cursor.GetDouble("CAUSALE");
          memcSoggetti.row.IMPORTOMAX = Cursor_qbe_wersonbo_cursor.GetDouble("IMPORTOMAX");
          memcSoggetti.row.FATTURATO = Cursor_qbe_wersonbo_cursor.GetDouble("FATTURATO");
          memcSoggetti.row.FREQUENZA = Cursor_qbe_wersonbo_cursor.GetString("FREQUENZA");
          memcSoggetti.row.NUMOPERAZ = Cursor_qbe_wersonbo_cursor.GetDouble("NUMOPERAZ");
          memcSoggetti.row.SOGAFFIDATARIO = Cursor_qbe_wersonbo_cursor.GetString("SOGAFFIDATARIO");
          memcSoggetti.row.FLGNOTRIM = Cursor_qbe_wersonbo_cursor.GetString("FLGNOTRIM");
          memcSoggetti.row.DISATTIVO = Cursor_qbe_wersonbo_cursor.GetDate("DISATTIVO");
          memcSoggetti.row.DATAFINE = Cursor_qbe_wersonbo_cursor.GetDate("DATAFINE");
          memcSoggetti.row.DATAINI = Cursor_qbe_wersonbo_cursor.GetDate("DATAINI");
          memcSoggetti.row.DATAIDENT = Cursor_qbe_wersonbo_cursor.GetDate("DATAIDENT");
          memcSoggetti.row.DATASIGN = Cursor_qbe_wersonbo_cursor.GetDate("DATASIGN");
          memcSoggetti.row.DATARAUT = Cursor_qbe_wersonbo_cursor.GetDate("DATARAUT");
          memcSoggetti.row.VERIFICA = Cursor_qbe_wersonbo_cursor.GetString("VERIFICA");
          memcSoggetti.row.NOTERIS = Cursor_qbe_wersonbo_cursor.GetString("NOTERIS");
          Cursor_qbe_wersonbo_cursor.Next();
        }
        m_cConnectivityError = Cursor_qbe_wersonbo_cursor.ErrorMessage();
        Cursor_qbe_wersonbo_cursor.Close();
        memcSoggetti.GoTop();
      } // End If
      for (MemoryCursorRow_personbo roPers : memcSoggetti._iterable_()) {
        /* rwSoggetti.Copy(roPers) */
        rwSoggetti.Copy(roPers);
      }
      /* Page Return rwSoggetti */
      return rwSoggetti;
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_wersonbo_cursor!=null)
          Cursor_qbe_wersonbo_cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  boolean FiltroIntestatario(MemoryCursorRow_qbe_operazbo_union_fraziobo_vqr rwFrz,String pNDG) throws Exception {
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_mlientiope=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_mlientifrz=null;
    CPResultSet Cursor_intestbo=null;
    try {
      /* rwFrz Row(qbe_operazbo_union_fraziobo.vqr) */
      /* pNDG Char(16) // CONNES dell'Intestatario */
      /* bRitorno Bool */
      /* bRitorno := False */
      bRitorno = false;
      /* If Empty(pNDG) */
      if (CPLib.Empty(pNDG)) {
        /* bRitorno := True */
        bRitorno = true;
      } else { // Else
        /* If not(Empty(rwFrz.CONNESCLI)) and rwFrz.CONNESCLI=pNDG */
        if ( ! (CPLib.Empty(rwFrz.CONNESCLI)) && CPLib.eqr(rwFrz.CONNESCLI,pNDG)) {
          /* bRitorno := True */
          bRitorno = true;
        } // End If
        /* If not(bRitorno) */
        if ( ! (bRitorno)) {
          /* If rwFrz.MITGDOC='O' */
          if (CPLib.eqr(rwFrz.MITGDOC,"O")) {
            /* If At(rwFrz.STATOREG,'|0|1') > 0 */
            if (CPLib.gt(CPLib.At(rwFrz.STATOREG,"|0|1"),0)) {
              // * --- Select from clientiope
              m_cServer = m_Ctx.GetServer("clientiope");
              m_cPhName = m_Ctx.GetPhName("clientiope");
              if (Cursor_clientiope!=null)
                Cursor_clientiope.Close();
              Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFrz.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFrz.IDBASE)+"  and  CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNDG,"?",0,0,m_cServer, m_oParameters),m_cServer,pNDG)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientiope.Eof())) {
                /* bRitorno := True */
                bRitorno = true;
                Cursor_clientiope.Next();
              }
              m_cConnectivityError = Cursor_clientiope.ErrorMessage();
              Cursor_clientiope.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from mlientiope
              m_cServer = m_Ctx.GetServer("mlientiope");
              m_cPhName = m_Ctx.GetPhName("mlientiope");
              if (Cursor_mlientiope!=null)
                Cursor_mlientiope.Close();
              Cursor_mlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFrz.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFrz.IDBASE)+"  and  CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNDG,"?",0,0,m_cServer, m_oParameters),m_cServer,pNDG)+" "+")"+(m_Ctx.IsSharedTemp("mlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_mlientiope.Eof())) {
                /* bRitorno := True */
                bRitorno = true;
                Cursor_mlientiope.Next();
              }
              m_cConnectivityError = Cursor_mlientiope.ErrorMessage();
              Cursor_mlientiope.Close();
              // * --- End Select
            } // End If
            /* ElseIf rwFrz.MITGDOC='F' */
          } else if (CPLib.eqr(rwFrz.MITGDOC,"F")) {
            /* If At(rwFrz.STATOREG,'|0|1') > 0 */
            if (CPLib.gt(CPLib.At(rwFrz.STATOREG,"|0|1"),0)) {
              // * --- Select from clientifrz
              m_cServer = m_Ctx.GetServer("clientifrz");
              m_cPhName = m_Ctx.GetPhName("clientifrz");
              if (Cursor_clientifrz!=null)
                Cursor_clientifrz.Close();
              Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFrz.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFrz.IDBASE)+"  and  CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNDG,"?",0,0,m_cServer, m_oParameters),m_cServer,pNDG)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientifrz.Eof())) {
                /* bRitorno := True */
                bRitorno = true;
                Cursor_clientifrz.Next();
              }
              m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
              Cursor_clientifrz.Close();
              // * --- End Select
            } else { // Else
              // * --- Select from mlientifrz
              m_cServer = m_Ctx.GetServer("mlientifrz");
              m_cPhName = m_Ctx.GetPhName("mlientifrz");
              if (Cursor_mlientifrz!=null)
                Cursor_mlientifrz.Close();
              Cursor_mlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFrz.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFrz.IDBASE)+"  and  CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNDG,"?",0,0,m_cServer, m_oParameters),m_cServer,pNDG)+" "+")"+(m_Ctx.IsSharedTemp("mlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_mlientifrz.Eof())) {
                /* bRitorno := True */
                bRitorno = true;
                Cursor_mlientifrz.Next();
              }
              m_cConnectivityError = Cursor_mlientifrz.ErrorMessage();
              Cursor_mlientifrz.Close();
              // * --- End Select
            } // End If
          } // End If
          /* If not(bRitorno) */
          if ( ! (bRitorno)) {
            /* If Empty(rwFrz.CONNESCLI) and not(Empty(rwFrz.RAPPORTO)) */
            if (CPLib.Empty(rwFrz.CONNESCLI) &&  ! (CPLib.Empty(rwFrz.RAPPORTO))) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFrz.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFrz.RAPPORTO)+"  and  CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNDG,"?",0,0,m_cServer, m_oParameters),m_cServer,pNDG)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* bRitorno := True */
                bRitorno = true;
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
      } // End If
      /* Page Return bRitorno */
      return bRitorno;
    } finally {
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Cursor_qbe_operazbo_union_fraziobo=null;
    CPResultSet Cursor_qbe_operazbo_union_fraziobo_prv=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* If w_Ambito='D' */
      if (CPLib.eqr(w_Ambito,"D")) {
        // * --- Fill memory cursor mcFraziobo on qbe_operazbo_union_fraziobo
        mcFraziobo.Zap();
        SPBridge.HMCaller _h000001F9;
        _h000001F9 = new SPBridge.HMCaller();
        _h000001F9.Set("m_cVQRList",m_cVQRList);
        _h000001F9.Set("c_dadataope",w_c_dadataope);
        _h000001F9.Set("c_adataope",w_c_adataope);
        _h000001F9.Set("c_dadatareg",w_c_dadatareg);
        _h000001F9.Set("c_adatareg",w_c_adatareg);
        _h000001F9.Set("dadataret",w_DaDatRet);
        _h000001F9.Set("adataret",w_ADatRet);
        _h000001F9.Set("tipoOperaz",w_TipoOpeStampa);
        _h000001F9.Set("Con_Contanti",w_Con_Contanti);
        _h000001F9.Set("CodCli",w_CONNES);
        _h000001F9.Set("CodDip",w_Dipendenza);
        _h000001F9.Set("Stato",w_Stato);
        if (Cursor_qbe_operazbo_union_fraziobo!=null)
          Cursor_qbe_operazbo_union_fraziobo.Close();
        Cursor_qbe_operazbo_union_fraziobo = new VQRHolder("qbe_operazbo_union_fraziobo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001F9,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_operazbo_union_fraziobo;
          Cursor_qbe_operazbo_union_fraziobo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stp_ope_fraz_all: query on qbe_operazbo_union_fraziobo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_operazbo_union_fraziobo.Eof())) {
          mcFraziobo.AppendBlank();
          mcFraziobo.row.IDBASE = Cursor_qbe_operazbo_union_fraziobo.GetString("IDBASE");
          mcFraziobo.row.NUMPROG = Cursor_qbe_operazbo_union_fraziobo.GetString("NUMPROG");
          mcFraziobo.row.DATAOPE = Cursor_qbe_operazbo_union_fraziobo.GetDate("DATAOPE");
          mcFraziobo.row.TIPOINTER = Cursor_qbe_operazbo_union_fraziobo.GetString("TIPOINTER");
          mcFraziobo.row.CODINTER = Cursor_qbe_operazbo_union_fraziobo.GetString("CODINTER");
          mcFraziobo.row.TIPOINF = Cursor_qbe_operazbo_union_fraziobo.GetString("TIPOINF");
          mcFraziobo.row.IDEREG = Cursor_qbe_operazbo_union_fraziobo.GetString("IDEREG");
          mcFraziobo.row.CODDIPE = Cursor_qbe_operazbo_union_fraziobo.GetString("CODDIPE");
          mcFraziobo.row.DESCCIT = Cursor_qbe_operazbo_union_fraziobo.GetString("DESCCIT");
          mcFraziobo.row.PROVINCIA = Cursor_qbe_operazbo_union_fraziobo.GetString("PROVINCIA");
          mcFraziobo.row.CODCAB = Cursor_qbe_operazbo_union_fraziobo.GetString("CODCAB");
          mcFraziobo.row.FLAGFRAZ = Cursor_qbe_operazbo_union_fraziobo.GetString("FLAGFRAZ");
          mcFraziobo.row.FLAGCONT = Cursor_qbe_operazbo_union_fraziobo.GetString("FLAGCONT");
          mcFraziobo.row.CODANA = Cursor_qbe_operazbo_union_fraziobo.GetString("CODANA");
          mcFraziobo.row.CODVOC = Cursor_qbe_operazbo_union_fraziobo.GetString("CODVOC");
          mcFraziobo.row.TIPOINT2 = Cursor_qbe_operazbo_union_fraziobo.GetString("TIPOINT2");
          mcFraziobo.row.CODINT2 = Cursor_qbe_operazbo_union_fraziobo.GetString("CODINT2");
          mcFraziobo.row.PAESE = Cursor_qbe_operazbo_union_fraziobo.GetString("PAESE");
          mcFraziobo.row.DESC2 = Cursor_qbe_operazbo_union_fraziobo.GetString("DESC2");
          mcFraziobo.row.PROV2 = Cursor_qbe_operazbo_union_fraziobo.GetString("PROV2");
          mcFraziobo.row.CODCAB2 = Cursor_qbe_operazbo_union_fraziobo.GetString("CODCAB2");
          mcFraziobo.row.DESCINTER = Cursor_qbe_operazbo_union_fraziobo.GetString("DESCINTER");
          mcFraziobo.row.RAPPORTO = Cursor_qbe_operazbo_union_fraziobo.GetString("RAPPORTO");
          mcFraziobo.row.FLAGRAP = Cursor_qbe_operazbo_union_fraziobo.GetString("FLAGRAP");
          mcFraziobo.row.TIPOLEG = Cursor_qbe_operazbo_union_fraziobo.GetString("TIPOLEG");
          mcFraziobo.row.DATAREG = Cursor_qbe_operazbo_union_fraziobo.GetDate("DATAREG");
          mcFraziobo.row.OPRAP = Cursor_qbe_operazbo_union_fraziobo.GetString("OPRAP");
          mcFraziobo.row.TIPOOPRAP = Cursor_qbe_operazbo_union_fraziobo.GetString("TIPOOPRAP");
          mcFraziobo.row.FLAGLIRE = Cursor_qbe_operazbo_union_fraziobo.GetString("FLAGLIRE");
          mcFraziobo.row.VALUTA = Cursor_qbe_operazbo_union_fraziobo.GetString("VALUTA");
          mcFraziobo.row.SEGNO = Cursor_qbe_operazbo_union_fraziobo.GetString("SEGNO");
          mcFraziobo.row.TOTLIRE = Cursor_qbe_operazbo_union_fraziobo.GetDouble("TOTLIRE");
          mcFraziobo.row.TOTCONT = Cursor_qbe_operazbo_union_fraziobo.GetDouble("TOTCONT");
          mcFraziobo.row.STATOREG = Cursor_qbe_operazbo_union_fraziobo.GetString("STATOREG");
          mcFraziobo.row.OPERAZMOD = Cursor_qbe_operazbo_union_fraziobo.GetString("OPERAZMOD");
          mcFraziobo.row.DATARETT = Cursor_qbe_operazbo_union_fraziobo.GetDate("DATARETT");
          mcFraziobo.row.CONNESCLI = Cursor_qbe_operazbo_union_fraziobo.GetString("CONNESCLI");
          mcFraziobo.row.CONNESOPER = Cursor_qbe_operazbo_union_fraziobo.GetString("CONNESOPER");
          mcFraziobo.row.CONNESBEN = Cursor_qbe_operazbo_union_fraziobo.GetString("CONNESBEN");
          mcFraziobo.row.COLLEG = Cursor_qbe_operazbo_union_fraziobo.GetString("COLLEG");
          mcFraziobo.row.CAMBIO = Cursor_qbe_operazbo_union_fraziobo.GetDouble("CAMBIO");
          mcFraziobo.row.RAPPORTBEN = Cursor_qbe_operazbo_union_fraziobo.GetString("RAPPORTBEN");
          mcFraziobo.row.FLAGRAP2 = Cursor_qbe_operazbo_union_fraziobo.GetString("FLAGRAP2");
          mcFraziobo.row.OPERATORE = Cursor_qbe_operazbo_union_fraziobo.GetString("OPERATORE");
          mcFraziobo.row.AUTOM = Cursor_qbe_operazbo_union_fraziobo.GetString("AUTOM");
          mcFraziobo.row.idcauana = Cursor_qbe_operazbo_union_fraziobo.GetString("idcauana");
          mcFraziobo.row.OPERAG = Cursor_qbe_operazbo_union_fraziobo.GetString("OPERAG");
          mcFraziobo.row.DOCFILE = Cursor_qbe_operazbo_union_fraziobo.GetString("DOCFILE");
          mcFraziobo.row.RESPINS = Cursor_qbe_operazbo_union_fraziobo.GetString("RESPINS");
          mcFraziobo.row.INFORM = Cursor_qbe_operazbo_union_fraziobo.GetString("INFORM");
          mcFraziobo.row.CDATOPE = Cursor_qbe_operazbo_union_fraziobo.GetString("CDATOPE");
          mcFraziobo.row.NOPROT = Cursor_qbe_operazbo_union_fraziobo.GetDouble("NOPROT");
          mcFraziobo.row.UCODE = Cursor_qbe_operazbo_union_fraziobo.GetString("UCODE");
          mcFraziobo.row.CDATAOPE = Cursor_qbe_operazbo_union_fraziobo.GetString("CDATAOPE");
          mcFraziobo.row.ZCPARTE = Cursor_qbe_operazbo_union_fraziobo.GetString("ZCPARTE");
          mcFraziobo.row.RAGIO = Cursor_qbe_operazbo_union_fraziobo.GetString("RAGIO");
          mcFraziobo.row.MODSVOL = Cursor_qbe_operazbo_union_fraziobo.GetString("MODSVOL");
          mcFraziobo.row.AREAGEO = Cursor_qbe_operazbo_union_fraziobo.GetString("AREAGEO");
          mcFraziobo.row.RIFIMP = Cursor_qbe_operazbo_union_fraziobo.GetString("RIFIMP");
          mcFraziobo.row.SCOPO = Cursor_qbe_operazbo_union_fraziobo.GetString("SCOPO");
          mcFraziobo.row.NATURA = Cursor_qbe_operazbo_union_fraziobo.GetString("NATURA");
          mcFraziobo.row.RTIPO = Cursor_qbe_operazbo_union_fraziobo.GetDouble("RTIPO");
          mcFraziobo.row.RCOMP = Cursor_qbe_operazbo_union_fraziobo.GetDouble("RCOMP");
          mcFraziobo.row.RIMP = Cursor_qbe_operazbo_union_fraziobo.GetDouble("RIMP");
          mcFraziobo.row.RFREQ = Cursor_qbe_operazbo_union_fraziobo.GetDouble("RFREQ");
          mcFraziobo.row.RRAGIO = Cursor_qbe_operazbo_union_fraziobo.GetDouble("RRAGIO");
          mcFraziobo.row.RAREA = Cursor_qbe_operazbo_union_fraziobo.GetDouble("RAREA");
          mcFraziobo.row.TIPO = Cursor_qbe_operazbo_union_fraziobo.GetString("TIPO");
          mcFraziobo.row.PRGIMPFRZ = Cursor_qbe_operazbo_union_fraziobo.GetDouble("PRGIMPFRZ");
          mcFraziobo.row.UNIQUECODE = Cursor_qbe_operazbo_union_fraziobo.GetString("UNIQUECODE");
          mcFraziobo.row.CONNESDOC = Cursor_qbe_operazbo_union_fraziobo.GetString("CONNESDOC");
          mcFraziobo.row.C_RAG = Cursor_qbe_operazbo_union_fraziobo.GetString("C_RAG");
          mcFraziobo.row.C_STA = Cursor_qbe_operazbo_union_fraziobo.GetString("C_STA");
          mcFraziobo.row.C_CTA = Cursor_qbe_operazbo_union_fraziobo.GetString("C_CTA");
          mcFraziobo.row.C_CAB = Cursor_qbe_operazbo_union_fraziobo.GetString("C_CAB");
          mcFraziobo.row.C_PRV = Cursor_qbe_operazbo_union_fraziobo.GetString("C_PRV");
          mcFraziobo.row.C_IND = Cursor_qbe_operazbo_union_fraziobo.GetString("C_IND");
          mcFraziobo.row.C_CAP = Cursor_qbe_operazbo_union_fraziobo.GetString("C_CAP");
          mcFraziobo.row.CONNALTRO = Cursor_qbe_operazbo_union_fraziobo.GetString("CONNALTRO");
          mcFraziobo.row.DATAIMP = Cursor_qbe_operazbo_union_fraziobo.GetDate("DATAIMP");
          mcFraziobo.row.C_RAPPORTO = Cursor_qbe_operazbo_union_fraziobo.GetString("C_RAPPORTO");
          mcFraziobo.row.PAGASOGOP = Cursor_qbe_operazbo_union_fraziobo.GetString("PAGASOGOP");
          mcFraziobo.row.MTCN = Cursor_qbe_operazbo_union_fraziobo.GetString("MTCN");
          mcFraziobo.row.IDFILE = Cursor_qbe_operazbo_union_fraziobo.GetString("IDFILE");
          mcFraziobo.row.CDATREG = Cursor_qbe_operazbo_union_fraziobo.GetString("CDATREG");
          mcFraziobo.row.IPCOLLEG = Cursor_qbe_operazbo_union_fraziobo.GetString("IPCOLLEG");
          mcFraziobo.row.ORACOLLEG = Cursor_qbe_operazbo_union_fraziobo.GetDateTime("ORACOLLEG");
          mcFraziobo.row.DUCOLLEG = Cursor_qbe_operazbo_union_fraziobo.GetDouble("DUCOLLEG");
          mcFraziobo.row.ANNOOPE = Cursor_qbe_operazbo_union_fraziobo.GetDouble("ANNOOPE");
          mcFraziobo.row.IDBASE2 = Cursor_qbe_operazbo_union_fraziobo.GetString("IDBASE2");
          mcFraziobo.row.IMPIN = Cursor_qbe_operazbo_union_fraziobo.GetDouble("IMPIN");
          mcFraziobo.row.IMPOUT = Cursor_qbe_operazbo_union_fraziobo.GetDouble("IMPOUT");
          mcFraziobo.row.MITIG = Cursor_qbe_operazbo_union_fraziobo.GetDouble("MITIG");
          mcFraziobo.row.MITGDOC = Cursor_qbe_operazbo_union_fraziobo.GetString("MITGDOC");
          mcFraziobo.row.RISGLOB = Cursor_qbe_operazbo_union_fraziobo.GetString("RISGLOB");
          Cursor_qbe_operazbo_union_fraziobo.Next();
        }
        m_cConnectivityError = Cursor_qbe_operazbo_union_fraziobo.ErrorMessage();
        Cursor_qbe_operazbo_union_fraziobo.Close();
        mcFraziobo.GoTop();
        /* ElseIf w_Ambito='P' */
      } else if (CPLib.eqr(w_Ambito,"P")) {
        // * --- Fill memory cursor mcFraziobo on qbe_operazbo_union_fraziobo_prv
        mcFraziobo.Zap();
        SPBridge.HMCaller _h000001FA;
        _h000001FA = new SPBridge.HMCaller();
        _h000001FA.Set("m_cVQRList",m_cVQRList);
        _h000001FA.Set("c_dadataope",w_c_dadataope);
        _h000001FA.Set("c_adataope",w_c_adataope);
        _h000001FA.Set("c_dadatareg",w_c_dadatareg);
        _h000001FA.Set("c_adatareg",w_c_adatareg);
        _h000001FA.Set("dadataret",w_DaDatRet);
        _h000001FA.Set("adataret",w_ADatRet);
        _h000001FA.Set("tipoOperaz",w_TipoOpeStampa);
        _h000001FA.Set("Con_Contanti",w_Con_Contanti);
        _h000001FA.Set("CodCli",w_CONNES);
        _h000001FA.Set("CodDip",w_Dipendenza);
        _h000001FA.Set("Stato",w_Stato);
        if (Cursor_qbe_operazbo_union_fraziobo_prv!=null)
          Cursor_qbe_operazbo_union_fraziobo_prv.Close();
        Cursor_qbe_operazbo_union_fraziobo_prv = new VQRHolder("qbe_operazbo_union_fraziobo_prv",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001FA,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_operazbo_union_fraziobo_prv;
          Cursor_qbe_operazbo_union_fraziobo_prv.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_stp_ope_fraz_all: query on qbe_operazbo_union_fraziobo_prv returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_operazbo_union_fraziobo_prv.Eof())) {
          mcFraziobo.AppendBlank();
          mcFraziobo.row.IDBASE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("IDBASE");
          mcFraziobo.row.NUMPROG = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("NUMPROG");
          mcFraziobo.row.DATAOPE = Cursor_qbe_operazbo_union_fraziobo_prv.GetDate("DATAOPE");
          mcFraziobo.row.TIPOINTER = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("TIPOINTER");
          mcFraziobo.row.CODINTER = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CODINTER");
          mcFraziobo.row.TIPOINF = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("TIPOINF");
          mcFraziobo.row.IDEREG = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("IDEREG");
          mcFraziobo.row.CODDIPE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CODDIPE");
          mcFraziobo.row.DESCCIT = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("DESCCIT");
          mcFraziobo.row.PROVINCIA = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("PROVINCIA");
          mcFraziobo.row.CODCAB = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CODCAB");
          mcFraziobo.row.FLAGFRAZ = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("FLAGFRAZ");
          mcFraziobo.row.FLAGCONT = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("FLAGCONT");
          mcFraziobo.row.CODANA = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CODANA");
          mcFraziobo.row.CODVOC = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CODVOC");
          mcFraziobo.row.TIPOINT2 = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("TIPOINT2");
          mcFraziobo.row.CODINT2 = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CODINT2");
          mcFraziobo.row.PAESE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("PAESE");
          mcFraziobo.row.DESC2 = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("DESC2");
          mcFraziobo.row.PROV2 = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("PROV2");
          mcFraziobo.row.CODCAB2 = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CODCAB2");
          mcFraziobo.row.DESCINTER = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("DESCINTER");
          mcFraziobo.row.RAPPORTO = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("RAPPORTO");
          mcFraziobo.row.FLAGRAP = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("FLAGRAP");
          mcFraziobo.row.TIPOLEG = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("TIPOLEG");
          mcFraziobo.row.DATAREG = Cursor_qbe_operazbo_union_fraziobo_prv.GetDate("DATAREG");
          mcFraziobo.row.OPRAP = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("OPRAP");
          mcFraziobo.row.TIPOOPRAP = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("TIPOOPRAP");
          mcFraziobo.row.FLAGLIRE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("FLAGLIRE");
          mcFraziobo.row.VALUTA = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("VALUTA");
          mcFraziobo.row.SEGNO = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("SEGNO");
          mcFraziobo.row.TOTLIRE = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("TOTLIRE");
          mcFraziobo.row.TOTCONT = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("TOTCONT");
          mcFraziobo.row.STATOREG = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("STATOREG");
          mcFraziobo.row.OPERAZMOD = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("OPERAZMOD");
          mcFraziobo.row.DATARETT = Cursor_qbe_operazbo_union_fraziobo_prv.GetDate("DATARETT");
          mcFraziobo.row.CONNESCLI = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CONNESCLI");
          mcFraziobo.row.CONNESOPER = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CONNESOPER");
          mcFraziobo.row.CONNESBEN = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CONNESBEN");
          mcFraziobo.row.COLLEG = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("COLLEG");
          mcFraziobo.row.CAMBIO = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("CAMBIO");
          mcFraziobo.row.RAPPORTBEN = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("RAPPORTBEN");
          mcFraziobo.row.FLAGRAP2 = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("FLAGRAP2");
          mcFraziobo.row.OPERATORE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("OPERATORE");
          mcFraziobo.row.AUTOM = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("AUTOM");
          mcFraziobo.row.idcauana = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("idcauana");
          mcFraziobo.row.OPERAG = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("OPERAG");
          mcFraziobo.row.DOCFILE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("DOCFILE");
          mcFraziobo.row.RESPINS = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("RESPINS");
          mcFraziobo.row.INFORM = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("INFORM");
          mcFraziobo.row.CDATOPE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CDATOPE");
          mcFraziobo.row.NOPROT = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("NOPROT");
          mcFraziobo.row.UCODE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("UCODE");
          mcFraziobo.row.CDATAOPE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CDATAOPE");
          mcFraziobo.row.ZCPARTE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("ZCPARTE");
          mcFraziobo.row.RAGIO = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("RAGIO");
          mcFraziobo.row.MODSVOL = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("MODSVOL");
          mcFraziobo.row.AREAGEO = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("AREAGEO");
          mcFraziobo.row.RIFIMP = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("RIFIMP");
          mcFraziobo.row.SCOPO = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("SCOPO");
          mcFraziobo.row.NATURA = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("NATURA");
          mcFraziobo.row.RTIPO = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("RTIPO");
          mcFraziobo.row.RCOMP = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("RCOMP");
          mcFraziobo.row.RIMP = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("RIMP");
          mcFraziobo.row.RFREQ = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("RFREQ");
          mcFraziobo.row.RRAGIO = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("RRAGIO");
          mcFraziobo.row.RAREA = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("RAREA");
          mcFraziobo.row.TIPO = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("TIPO");
          mcFraziobo.row.PRGIMPFRZ = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("PRGIMPFRZ");
          mcFraziobo.row.UNIQUECODE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("UNIQUECODE");
          mcFraziobo.row.CONNESDOC = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CONNESDOC");
          mcFraziobo.row.C_RAG = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("C_RAG");
          mcFraziobo.row.C_STA = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("C_STA");
          mcFraziobo.row.C_CTA = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("C_CTA");
          mcFraziobo.row.C_CAB = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("C_CAB");
          mcFraziobo.row.C_PRV = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("C_PRV");
          mcFraziobo.row.C_IND = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("C_IND");
          mcFraziobo.row.C_CAP = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("C_CAP");
          mcFraziobo.row.CONNALTRO = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CONNALTRO");
          mcFraziobo.row.DATAIMP = Cursor_qbe_operazbo_union_fraziobo_prv.GetDate("DATAIMP");
          mcFraziobo.row.C_RAPPORTO = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("C_RAPPORTO");
          mcFraziobo.row.PAGASOGOP = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("PAGASOGOP");
          mcFraziobo.row.MTCN = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("MTCN");
          mcFraziobo.row.IDFILE = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("IDFILE");
          mcFraziobo.row.CDATREG = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("CDATREG");
          mcFraziobo.row.IPCOLLEG = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("IPCOLLEG");
          mcFraziobo.row.ORACOLLEG = Cursor_qbe_operazbo_union_fraziobo_prv.GetDateTime("ORACOLLEG");
          mcFraziobo.row.DUCOLLEG = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("DUCOLLEG");
          mcFraziobo.row.ANNOOPE = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("ANNOOPE");
          mcFraziobo.row.IDBASE2 = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("IDBASE2");
          mcFraziobo.row.IMPIN = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("IMPIN");
          mcFraziobo.row.IMPOUT = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("IMPOUT");
          mcFraziobo.row.MITIG = Cursor_qbe_operazbo_union_fraziobo_prv.GetDouble("MITIG");
          mcFraziobo.row.MITGDOC = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("MITGDOC");
          mcFraziobo.row.RISGLOB = Cursor_qbe_operazbo_union_fraziobo_prv.GetString("RISGLOB");
          Cursor_qbe_operazbo_union_fraziobo_prv.Next();
        }
        m_cConnectivityError = Cursor_qbe_operazbo_union_fraziobo_prv.ErrorMessage();
        Cursor_qbe_operazbo_union_fraziobo_prv.Close();
        mcFraziobo.GoTop();
      } // End If
    } finally {
      try {
        if (Cursor_qbe_operazbo_union_fraziobo!=null)
          Cursor_qbe_operazbo_union_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_operazbo_union_fraziobo_prv!=null)
          Cursor_qbe_operazbo_union_fraziobo_prv.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_10() throws Exception {
    CPResultSet Cursor_xlientifrz=null;
    CPResultSet Cursor_xogopefbo=null;
    CPResultSet Cursor_xeneficfrz=null;
    CPResultSet Cursor_xerzistifrz=null;
    try {
      /* If _xlientifrz */
      if (_xlientifrz) {
        /* Cerco se gli altri clienti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from xlientifrz
        m_cServer = m_Ctx.GetServer("xlientifrz");
        m_cPhName = m_Ctx.GetPhName("xlientifrz");
        if (Cursor_xlientifrz!=null)
          Cursor_xlientifrz.Close();
        Cursor_xlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("xlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xlientifrz.Eof())) {
          /* If xlientifrz->CODSOG <> rwFraziobo.CONNESCLI */
          if (CPLib.ne(Cursor_xlientifrz.GetString("CODSOG"),rwFraziobo.CONNESCLI)) {
            /* _connes := xlientifrz->CODSOG // _connes del soggetto */
            _connes = Cursor_xlientifrz.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000202")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000202(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_xlientifrz.Next();
        }
        m_cConnectivityError = Cursor_xlientifrz.ErrorMessage();
        Cursor_xlientifrz.Close();
        // * --- End Select
      } // End If
      /* If _xogopefbo */
      if (_xogopefbo) {
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from xogopefbo
        m_cServer = m_Ctx.GetServer("xogopefbo");
        m_cPhName = m_Ctx.GetPhName("xogopefbo");
        if (Cursor_xogopefbo!=null)
          Cursor_xogopefbo.Close();
        Cursor_xogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("xogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xogopefbo.Eof())) {
          /* If xogopefbo->CODSOG <> rwFraziobo.CONNESOPER */
          if (CPLib.ne(Cursor_xogopefbo.GetString("CODSOG"),rwFraziobo.CONNESOPER)) {
            /* _connes := xogopefbo->CODSOG // _connes del soggetto */
            _connes = Cursor_xogopefbo.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000020B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000020B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_xogopefbo.Next();
        }
        m_cConnectivityError = Cursor_xogopefbo.ErrorMessage();
        Cursor_xogopefbo.Close();
        // * --- End Select
      } // End If
      /* If _xeneficfrz */
      if (_xeneficfrz) {
        /* Cerco se gli altri soggetti controparti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from xeneficfrz
        m_cServer = m_Ctx.GetServer("xeneficfrz");
        m_cPhName = m_Ctx.GetPhName("xeneficfrz");
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
        Cursor_xeneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("xeneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xeneficfrz.Eof())) {
          /* If xeneficfrz->CODSOG <> rwFraziobo.CONNESBEN and not(Empty(xeneficfrz->CODSOG)) */
          if (CPLib.ne(Cursor_xeneficfrz.GetString("CODSOG"),rwFraziobo.CONNESBEN) &&  ! (CPLib.Empty(Cursor_xeneficfrz.GetString("CODSOG")))) {
            /* _connes := xeneficfrz->CODSOG // _connes del soggetto */
            _connes = Cursor_xeneficfrz.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000214")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000214(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          /* If not(Empty(LRTrim(xeneficfrz->C_RAG))) and Empty(xeneficfrz->CODSOG) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficfrz.GetString("C_RAG")))) && CPLib.Empty(Cursor_xeneficfrz.GetString("CODSOG"))) {
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000218")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000218(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
          Cursor_xeneficfrz.Next();
        }
        m_cConnectivityError = Cursor_xeneficfrz.ErrorMessage();
        Cursor_xeneficfrz.Close();
        // * --- End Select
      } // End If
      /* If _xerzistifrz */
      if (_xerzistifrz) {
        /* Cerco se gli altri soggetti titolare effettivo dell operazione hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from xerzistifrz
        m_cServer = m_Ctx.GetServer("xerzistifrz");
        m_cPhName = m_Ctx.GetPhName("xerzistifrz");
        if (Cursor_xerzistifrz!=null)
          Cursor_xerzistifrz.Close();
        Cursor_xerzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("xerzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xerzistifrz.Eof())) {
          /* If xerzistifrz->CODSOG <> rwFraziobo.CONNALTRO */
          if (CPLib.ne(Cursor_xerzistifrz.GetString("CODSOG"),rwFraziobo.CONNALTRO)) {
            /* _connes := xerzistifrz->CODSOG // _connes del soggetto */
            _connes = Cursor_xerzistifrz.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000220")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000220(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_xerzistifrz.Next();
        }
        m_cConnectivityError = Cursor_xerzistifrz.ErrorMessage();
        Cursor_xerzistifrz.Close();
        // * --- End Select
      } // End If
    } finally {
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
        if (Cursor_xeneficfrz!=null)
          Cursor_xeneficfrz.Close();
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
    }
  }
  void Page_11() throws Exception {
    CPResultSet Cursor_xlientiope=null;
    CPResultSet Cursor_xogopebo=null;
    CPResultSet Cursor_xeneficope=null;
    CPResultSet Cursor_xerzistiope=null;
    try {
      /* If _xlientiope */
      if (_xlientiope) {
        // * --- Select from xlientiope
        m_cServer = m_Ctx.GetServer("xlientiope");
        m_cPhName = m_Ctx.GetPhName("xlientiope");
        if (Cursor_xlientiope!=null)
          Cursor_xlientiope.Close();
        Cursor_xlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("xlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xlientiope.Eof())) {
          /* If xlientiope->CODSOG <> rwFraziobo.CONNESCLI */
          if (CPLib.ne(Cursor_xlientiope.GetString("CODSOG"),rwFraziobo.CONNESCLI)) {
            /* _connes := xlientiope->CODSOG // _connes del soggetto */
            _connes = Cursor_xlientiope.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000228")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000228(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_xlientiope.Next();
        }
        m_cConnectivityError = Cursor_xlientiope.ErrorMessage();
        Cursor_xlientiope.Close();
        // * --- End Select
      } // End If
      /* If _xogopebo */
      if (_xogopebo) {
        /* Cerco se gli altri soggetti operanti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from xogopebo
        m_cServer = m_Ctx.GetServer("xogopebo");
        m_cPhName = m_Ctx.GetPhName("xogopebo");
        if (Cursor_xogopebo!=null)
          Cursor_xogopebo.Close();
        Cursor_xogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("xogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xogopebo.Eof())) {
          /* If xogopebo->CODSOG <> rwFraziobo.CONNESOPER */
          if (CPLib.ne(Cursor_xogopebo.GetString("CODSOG"),rwFraziobo.CONNESOPER)) {
            /* _connes := xogopebo->CODSOG // _connes del soggetto */
            _connes = Cursor_xogopebo.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000231")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000231(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_xogopebo.Next();
        }
        m_cConnectivityError = Cursor_xogopebo.ErrorMessage();
        Cursor_xogopebo.Close();
        // * --- End Select
      } // End If
      /* If _xeneficope */
      if (_xeneficope) {
        /* Cerco se gli altri soggetti controparti hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from xeneficope
        m_cServer = m_Ctx.GetServer("xeneficope");
        m_cPhName = m_Ctx.GetPhName("xeneficope");
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
        Cursor_xeneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("xeneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xeneficope.Eof())) {
          /* If xeneficope->CODSOG <> rwFraziobo.CONNESBEN and not(Empty(xeneficope->CODSOG)) */
          if (CPLib.ne(Cursor_xeneficope.GetString("CODSOG"),rwFraziobo.CONNESBEN) &&  ! (CPLib.Empty(Cursor_xeneficope.GetString("CODSOG")))) {
            /* _connes := xeneficope->CODSOG // _connes del soggetto */
            _connes = Cursor_xeneficope.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000023A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000023A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          /* If not(Empty(LRTrim(xeneficope->C_RAG))) and Empty(xeneficope->CODSOG) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_xeneficope.GetString("C_RAG")))) && CPLib.Empty(Cursor_xeneficope.GetString("CODSOG"))) {
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"0000023E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000023E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_xeneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
          Cursor_xeneficope.Next();
        }
        m_cConnectivityError = Cursor_xeneficope.ErrorMessage();
        Cursor_xeneficope.Close();
        // * --- End Select
      } // End If
      /* If _xerzistiope */
      if (_xerzistiope) {
        /* Cerco se gli altri soggetti titolare effettivo dell operazione hanno delle modifiche all'anagrafica altrimenti prendo l'anagrafica in personbo */
        // * --- Select from xerzistiope
        m_cServer = m_Ctx.GetServer("xerzistiope");
        m_cPhName = m_Ctx.GetPhName("xerzistiope");
        if (Cursor_xerzistiope!=null)
          Cursor_xerzistiope.Close();
        Cursor_xerzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFraziobo.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("xerzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xerzistiope.Eof())) {
          /* If xerzistiope->CODSOG <> rwFraziobo.CONNALTRO */
          if (CPLib.ne(Cursor_xerzistiope.GetString("CODSOG"),rwFraziobo.CONNALTRO)) {
            /* _connes := xerzistiope->CODSOG // _connes del soggetto */
            _connes = Cursor_xerzistiope.GetString("CODSOG");
            /* rowSoggetti := DatiSoggetto(_connes,iif(rwFraziobo.STATOREG='1',rwFraziobo.DATARETT,rwFraziobo.DATAOPE)) */
            rowSoggetti = DatiSoggetto(_connes,(CPLib.eqr(rwFraziobo.STATOREG,"1")?rwFraziobo.DATARETT:rwFraziobo.DATAOPE));
            /* progrIns := progrIns+1 */
            progrIns = CPLib.Round(progrIns+1,0);
            // * --- Insert into tmp_stpope_dett_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_stpope_dett_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_stpope_dett_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpope_dett_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_ope_fraz_all",336,"00000246")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000246(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.ATTIV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.CONNES,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.idcitta,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PARTIVA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOSPMAF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSoggetti.TIPOPERS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AREAGEO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.AUTOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CAMBIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATAOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CDATOPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODANA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODCAB2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODDIPE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CODVOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.COLLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.CONNESOPER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAOPE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATAREG,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DATARETT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESC2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DESCINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.DOCFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGCONT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGFRAZ,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGLIRE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.FLAGRAP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.idcauana,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.IDEREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.INFORM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.MODSVOL,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NATURA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NOPROT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERATORE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPERAZMOD,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.OPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PRGIMPFRZ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROV2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAGIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTBEN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RAREA,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RCOMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RESPINS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RFREQ,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIFIMP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RIMP,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RRAGIO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.RTIPO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SCOPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.SEGNO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.STATOREG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINF,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINT2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOLEG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTCONT,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.TOTLIRE,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UCODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.UNIQUECODE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.ZCPARTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_RAG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_STA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_PRV,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_IND,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rwFraziobo.C_CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(progrIns,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpope_dett_anag",true);
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
            /* Exec "Titolari Effettivi" Page 6:Page_6 */
            Page_6();
          } // End If
          Cursor_xerzistiope.Next();
        }
        m_cConnectivityError = Cursor_xerzistiope.ErrorMessage();
        Cursor_xerzistiope.Close();
        // * --- End Select
      } // End If
    } finally {
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
        if (Cursor_xeneficope!=null)
          Cursor_xeneficope.Close();
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
    }
  }
  void Page_12() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _mlientiope := False */
      _mlientiope = false;
      /* _clientiope := False */
      _clientiope = false;
      /* _mogopebo := False */
      _mogopebo = false;
      /* _sogopebo := False */
      _sogopebo = false;
      /* _meneficope := False */
      _meneficope = false;
      /* _beneficope := False */
      _beneficope = false;
      /* _merzistiope := False */
      _merzistiope = false;
      /* _terzistiope := False */
      _terzistiope = false;
      /* _mlientifrz := False */
      _mlientifrz = false;
      /* _clientifrz := False */
      _clientifrz = false;
      /* _mogopefbo := False */
      _mogopefbo = false;
      /* _sogopefbo := False */
      _sogopefbo = false;
      /* _meneficfrz := False */
      _meneficfrz = false;
      /* _beneficfrz := False */
      _beneficfrz = false;
      /* _merzistifrz := False */
      _merzistifrz = false;
      /* _terzistifrz := False */
      _terzistifrz = false;
      /* _rapcolleg := False */
      _rapcolleg = false;
      /* _xlientiope := False */
      _xlientiope = false;
      /* _xogopebo := False */
      _xogopebo = false;
      /* _xeneficope := False */
      _xeneficope = false;
      /* _xerzistiope := False */
      _xerzistiope = false;
      /* _xlientifrz := False */
      _xlientifrz = false;
      /* _xogopefbo := False */
      _xogopefbo = false;
      /* _xeneficfrz := False */
      _xeneficfrz = false;
      /* _xerzistifrz := False */
      _xerzistifrz = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000263;
      _h00000263 = new SPBridge.HMCaller();
      _h00000263.Set("m_cVQRList",m_cVQRList);
      _h00000263.Set("tbname","mlientiope");
      _h00000263.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000263,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _mlientiope := qbe_tab_mmc->tot > 0 */
        _mlientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000265;
      _h00000265 = new SPBridge.HMCaller();
      _h00000265.Set("m_cVQRList",m_cVQRList);
      _h00000265.Set("tbname","clientiope");
      _h00000265.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000265,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientiope := qbe_tab_mmc->tot > 0 */
        _clientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000267;
      _h00000267 = new SPBridge.HMCaller();
      _h00000267.Set("m_cVQRList",m_cVQRList);
      _h00000267.Set("tbname","mogopebo");
      _h00000267.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000267,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _mogopebo := qbe_tab_mmc->tot > 0 */
        _mogopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000269;
      _h00000269 = new SPBridge.HMCaller();
      _h00000269.Set("m_cVQRList",m_cVQRList);
      _h00000269.Set("tbname","sogopebo");
      _h00000269.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000269,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _sogopebo := qbe_tab_mmc->tot > 0 */
        _sogopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000026B;
      _h0000026B = new SPBridge.HMCaller();
      _h0000026B.Set("m_cVQRList",m_cVQRList);
      _h0000026B.Set("tbname","meneficope");
      _h0000026B.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000026B,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _meneficope := qbe_tab_mmc->tot > 0 */
        _meneficope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000026D;
      _h0000026D = new SPBridge.HMCaller();
      _h0000026D.Set("m_cVQRList",m_cVQRList);
      _h0000026D.Set("tbname","beneficope");
      _h0000026D.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000026D,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _beneficope := qbe_tab_mmc->tot > 0 */
        _beneficope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000026F;
      _h0000026F = new SPBridge.HMCaller();
      _h0000026F.Set("m_cVQRList",m_cVQRList);
      _h0000026F.Set("tbname","merzistiope");
      _h0000026F.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000026F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _merzistiope := qbe_tab_mmc->tot > 0 */
        _merzistiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000271;
      _h00000271 = new SPBridge.HMCaller();
      _h00000271.Set("m_cVQRList",m_cVQRList);
      _h00000271.Set("tbname","terzistiope");
      _h00000271.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000271,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _terzistiope := qbe_tab_mmc->tot > 0 */
        _terzistiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000273;
      _h00000273 = new SPBridge.HMCaller();
      _h00000273.Set("m_cVQRList",m_cVQRList);
      _h00000273.Set("tbname","mlientifrz");
      _h00000273.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000273,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _mlientifrz := qbe_tab_mmc->tot > 0 */
        _mlientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000275;
      _h00000275 = new SPBridge.HMCaller();
      _h00000275.Set("m_cVQRList",m_cVQRList);
      _h00000275.Set("tbname","clientifrz");
      _h00000275.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000275,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientifrz := qbe_tab_mmc->tot > 0 */
        _clientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000277;
      _h00000277 = new SPBridge.HMCaller();
      _h00000277.Set("m_cVQRList",m_cVQRList);
      _h00000277.Set("tbname","mogopefbo");
      _h00000277.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000277,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _mogopefbo := qbe_tab_mmc->tot > 0 */
        _mogopefbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000279;
      _h00000279 = new SPBridge.HMCaller();
      _h00000279.Set("m_cVQRList",m_cVQRList);
      _h00000279.Set("tbname","sogopefbo");
      _h00000279.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000279,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _sogopefbo := qbe_tab_mmc->tot > 0 */
        _sogopefbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000027B;
      _h0000027B = new SPBridge.HMCaller();
      _h0000027B.Set("m_cVQRList",m_cVQRList);
      _h0000027B.Set("tbname","meneficfrz");
      _h0000027B.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000027B,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _meneficfrz := qbe_tab_mmc->tot > 0 */
        _meneficfrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000027D;
      _h0000027D = new SPBridge.HMCaller();
      _h0000027D.Set("m_cVQRList",m_cVQRList);
      _h0000027D.Set("tbname","beneficfrz");
      _h0000027D.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000027D,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _beneficfrz := qbe_tab_mmc->tot > 0 */
        _beneficfrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000027F;
      _h0000027F = new SPBridge.HMCaller();
      _h0000027F.Set("m_cVQRList",m_cVQRList);
      _h0000027F.Set("tbname","merzistifrz");
      _h0000027F.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000027F,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _merzistifrz := qbe_tab_mmc->tot > 0 */
        _merzistifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000281;
      _h00000281 = new SPBridge.HMCaller();
      _h00000281.Set("m_cVQRList",m_cVQRList);
      _h00000281.Set("tbname","terzistifrz");
      _h00000281.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000281,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _terzistifrz := qbe_tab_mmc->tot > 0 */
        _terzistifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000283;
      _h00000283 = new SPBridge.HMCaller();
      _h00000283.Set("m_cVQRList",m_cVQRList);
      _h00000283.Set("tbname","rapcoll");
      _h00000283.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000283,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _rapcolleg := qbe_tab_mmc->tot > 0 */
        _rapcolleg = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000286;
      _h00000286 = new SPBridge.HMCaller();
      _h00000286.Set("m_cVQRList",m_cVQRList);
      _h00000286.Set("tbname","xlientiope");
      _h00000286.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000286,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _xlientiope := qbe_tab_mmc->tot > 0 */
        _xlientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000288;
      _h00000288 = new SPBridge.HMCaller();
      _h00000288.Set("m_cVQRList",m_cVQRList);
      _h00000288.Set("tbname","xogopebo");
      _h00000288.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000288,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _xogopebo := qbe_tab_mmc->tot > 0 */
        _xogopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000028A;
      _h0000028A = new SPBridge.HMCaller();
      _h0000028A.Set("m_cVQRList",m_cVQRList);
      _h0000028A.Set("tbname","xeneficope");
      _h0000028A.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000028A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _xeneficope := qbe_tab_mmc->tot > 0 */
        _xeneficope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000028C;
      _h0000028C = new SPBridge.HMCaller();
      _h0000028C.Set("m_cVQRList",m_cVQRList);
      _h0000028C.Set("tbname","xerzistiope");
      _h0000028C.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000028C,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _xerzistiope := qbe_tab_mmc->tot > 0 */
        _xerzistiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000028E;
      _h0000028E = new SPBridge.HMCaller();
      _h0000028E.Set("m_cVQRList",m_cVQRList);
      _h0000028E.Set("tbname","clientifrz");
      _h0000028E.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000028E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientifrz := qbe_tab_mmc->tot > 0 */
        _clientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000290;
      _h00000290 = new SPBridge.HMCaller();
      _h00000290.Set("m_cVQRList",m_cVQRList);
      _h00000290.Set("tbname","xogopefbo");
      _h00000290.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000290,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _xogopefbo := qbe_tab_mmc->tot > 0 */
        _xogopefbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000292;
      _h00000292 = new SPBridge.HMCaller();
      _h00000292.Set("m_cVQRList",m_cVQRList);
      _h00000292.Set("tbname","xeneficfrz");
      _h00000292.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000292,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _xeneficfrz := qbe_tab_mmc->tot > 0 */
        _xeneficfrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000294;
      _h00000294 = new SPBridge.HMCaller();
      _h00000294.Set("m_cVQRList",m_cVQRList);
      _h00000294.Set("tbname","xerzistifrz");
      _h00000294.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000294,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _xerzistifrz := qbe_tab_mmc->tot > 0 */
        _xerzistifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,java.sql.Date p_w_DaDatRet,java.sql.Date p_w_ADatRet,String p_w_EstrazTitEffNelPeriodo,String p_w_CONNES,String p_w_TipoOpeStampa,String p_w_TipoStampa,String p_w_OrderBy,boolean p_w_Stp_dist_lire_euro,boolean p_w_Con_Contanti,String p_w_Stato,boolean p_w_Senza_dip,String p_w_Dipendenza,String p_w_Ambito) {
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_DaDatReg = p_w_DaDatReg;
    w_ADatReg = p_w_ADatReg;
    w_DaDatRet = p_w_DaDatRet;
    w_ADatRet = p_w_ADatRet;
    w_EstrazTitEffNelPeriodo = p_w_EstrazTitEffNelPeriodo;
    w_CONNES = p_w_CONNES;
    w_TipoOpeStampa = p_w_TipoOpeStampa;
    w_TipoStampa = p_w_TipoStampa;
    w_OrderBy = p_w_OrderBy;
    w_Stp_dist_lire_euro = p_w_Stp_dist_lire_euro;
    w_Con_Contanti = p_w_Con_Contanti;
    w_Stato = p_w_Stato;
    w_Senza_dip = p_w_Senza_dip;
    w_Dipendenza = p_w_Dipendenza;
    w_Ambito = p_w_Ambito;
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
  public Forward Run(java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,java.sql.Date p_w_DaDatReg,java.sql.Date p_w_ADatReg,java.sql.Date p_w_DaDatRet,java.sql.Date p_w_ADatRet,String p_w_EstrazTitEffNelPeriodo,String p_w_CONNES,String p_w_TipoOpeStampa,String p_w_TipoStampa,String p_w_OrderBy,boolean p_w_Stp_dist_lire_euro,boolean p_w_Con_Contanti,String p_w_Stato,boolean p_w_Senza_dip,String p_w_Dipendenza,String p_w_Ambito) {
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_DaDatReg = p_w_DaDatReg;
    w_ADatReg = p_w_ADatReg;
    w_DaDatRet = p_w_DaDatRet;
    w_ADatRet = p_w_ADatRet;
    w_EstrazTitEffNelPeriodo = p_w_EstrazTitEffNelPeriodo;
    w_CONNES = p_w_CONNES;
    w_TipoOpeStampa = p_w_TipoOpeStampa;
    w_TipoStampa = p_w_TipoStampa;
    w_OrderBy = p_w_OrderBy;
    w_Stp_dist_lire_euro = p_w_Stp_dist_lire_euro;
    w_Con_Contanti = p_w_Con_Contanti;
    w_Stato = p_w_Stato;
    w_Senza_dip = p_w_Senza_dip;
    w_Dipendenza = p_w_Dipendenza;
    w_Ambito = p_w_Ambito;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stp_ope_fraz_allR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stp_ope_fraz_allR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_DaDatReg = CPLib.NullDate();
    w_ADatReg = CPLib.NullDate();
    w_DaDatRet = CPLib.NullDate();
    w_ADatRet = CPLib.NullDate();
    w_EstrazTitEffNelPeriodo = CPLib.Space(1);
    w_CONNES = CPLib.Space(30);
    w_TipoOpeStampa = CPLib.Space(1);
    w_TipoStampa = CPLib.Space(1);
    w_OrderBy = CPLib.Space(30);
    w_Stp_dist_lire_euro = false;
    w_Con_Contanti = false;
    w_Stato = CPLib.Space(1);
    w_Senza_dip = false;
    w_Dipendenza = CPLib.Space(6);
    w_Ambito = CPLib.Space(1);
    onlyope = 0;
    onlyrap = 0;
    statoreg = CPLib.Space(1);
    _connes = CPLib.Space(16);
    _dataope = CPLib.NullDate();
    _datareg = CPLib.NullDate();
    _dataret = CPLib.NullDate();
    _numsto = CPLib.Space(15);
    _nomereport = CPLib.Space(50);
    _ftypes = CPLib.Space(20);
    _fmodels = CPLib.Space(20);
    _rotate = CPLib.Space(20);
    _reportname = CPLib.Space(100);
    _fonte_arch = CPLib.Space(100);
    _tipo_arch = CPLib.Space(100);
    _conta = 0;
    mcSoggetti = new MemoryCursor_personbo();
    rowSoggetti = new MemoryCursorRow_personbo();
    mcFraziobo = new MemoryCursor_qbe_operazbo_union_fraziobo_vqr();
    rowFraziobo = new MemoryCursorRow_qbe_operazbo_union_fraziobo_vqr();
    rwFraziobo = new MemoryCursorRow_qbe_operazbo_union_fraziobo_vqr();
    _datachk = CPLib.NullDate();
    w_c_dadataope = CPLib.Space(8);
    w_c_adataope = CPLib.Space(8);
    w_c_dadatareg = CPLib.Space(8);
    w_c_adatareg = CPLib.Space(8);
    w_c_dadataret = CPLib.Space(8);
    w_c_adataret = CPLib.Space(8);
    w_StatoLower = 0;
    w_StatoUpper = 0;
    progrIns = 0;
    _mlientiope = false;
    _clientiope = false;
    _mogopebo = false;
    _sogopebo = false;
    _meneficope = false;
    _beneficope = false;
    _merzistiope = false;
    _terzistiope = false;
    _mlientifrz = false;
    _clientifrz = false;
    _mogopefbo = false;
    _sogopefbo = false;
    _meneficfrz = false;
    _beneficfrz = false;
    _merzistifrz = false;
    _terzistifrz = false;
    _rapcolleg = false;
    _xerzistifrz = false;
    _xeneficfrz = false;
    _xlientifrz = false;
    _xogopefbo = false;
    _xogopebo = false;
    _xlientiope = false;
    _xeneficope = false;
    _xerzistiope = false;
    bRitorno = false;
    gFlgDoc=m_Ctx.GetGlobalString("gFlgDoc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tot_tmp_stpope_dett_anag,qbe_alloperazbo,qbe_alloperazbo_prv,qbe_tot_tmp_operazioni,qbe_alloperazbo,qbe_alloperazbo_prv,qbe_tot_tmp_operazioni,qbe_wersonbo_cursor,qbe_operazbo_union_fraziobo,qbe_operazbo_union_fraziobo_prv,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,
  public static final String m_cVQRList = ",qbe_tot_tmp_stpope_dett_anag,qbe_alloperazbo,qbe_alloperazbo_prv,qbe_tot_tmp_operazioni,qbe_alloperazbo,qbe_alloperazbo_prv,qbe_tot_tmp_operazioni,qbe_wersonbo_cursor,qbe_operazbo_union_fraziobo,qbe_operazbo_union_fraziobo_prv,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,";
  // ENTITY_BATCHES: ,arfn_chkspers,
  public static final String i_InvokedRoutines = ",arfn_chkspers,";
  public static String[] m_cRunParameterNames={"w_DaDatOpe","w_ADatOpe","w_DaDatReg","w_ADatReg","w_DaDatRet","w_ADatRet","w_EstrazTitEffNelPeriodo","w_CONNES","w_TipoOpeStampa","w_TipoStampa","w_OrderBy","w_Stp_dist_lire_euro","w_Con_Contanti","w_Stato","w_Senza_dip","w_Dipendenza","w_Ambito"};
  protected static String GetFieldsName_00000077(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000085(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000089(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000AA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"ERR01,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpoperazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000012D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000137(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000140(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000145(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000014E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000156(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000015F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000168(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000016C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000174(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000017D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000187(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000191(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000195(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000019E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001AF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001B8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001BC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001C4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001CC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000202(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000020B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000214(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000218(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000220(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000228(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000231(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000023A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000023E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000246(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AAUTRILASC,";
    p_cSql = p_cSql+"AATTIV,";
    p_cSql = p_cSql+"ACAP,";
    p_cSql = p_cSql+"ACFESTERO,";
    p_cSql = p_cSql+"ACODCAB,";
    p_cSql = p_cSql+"ACODDIPE,";
    p_cSql = p_cSql+"ACODFISC,";
    p_cSql = p_cSql+"ACODINTER,";
    p_cSql = p_cSql+"ACOGNOME,";
    p_cSql = p_cSql+"ACONNES,";
    p_cSql = p_cSql+"ADATANASC,";
    p_cSql = p_cSql+"ADATARILASC,";
    p_cSql = p_cSql+"ADATAVALI,";
    p_cSql = p_cSql+"ADESCCIT,";
    p_cSql = p_cSql+"ADOCFILE,";
    p_cSql = p_cSql+"ADOMICILIO,";
    p_cSql = p_cSql+"Aidcitta,";
    p_cSql = p_cSql+"ANASCOMUN,";
    p_cSql = p_cSql+"ANASSTATO,";
    p_cSql = p_cSql+"ANOME,";
    p_cSql = p_cSql+"ANOTE,";
    p_cSql = p_cSql+"ANUMDOCUM,";
    p_cSql = p_cSql+"APAESE,";
    p_cSql = p_cSql+"APARTIVA,";
    p_cSql = p_cSql+"APROVINCIA,";
    p_cSql = p_cSql+"ARAGSOC,";
    p_cSql = p_cSql+"ARAMOGRUP,";
    p_cSql = p_cSql+"ASESSO,";
    p_cSql = p_cSql+"ASETTSINT,";
    p_cSql = p_cSql+"ASOSPMAF,";
    p_cSql = p_cSql+"ASOTGRUP,";
    p_cSql = p_cSql+"ATIPINTER,";
    p_cSql = p_cSql+"ATIPODOC,";
    p_cSql = p_cSql+"ATIPOPERS,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
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
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
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
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"TIPOSOG,";
    p_cSql = p_cSql+"PROGINS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpope_dett_anag",true);
    return p_cSql;
  }
}
