// * --- Area Manuale = BO - Header
// * --- arrt_cgo_chkdiana
import java.io.*;
import java.time.LocalDate;
// * --- Fine Area Manuale
public class arrt_cgo_chkdianaR implements CallerWithObjs {
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
  public String m_cPhName_cgo_cf_scarico380;
  public String m_cServer_cgo_cf_scarico380;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_destwarn;
  public String m_cServer_destwarn;
  public String m_cPhName_fiduciabo;
  public String m_cServer_fiduciabo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
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
  public String m_cPhName_tipo1;
  public String m_cServer_tipo1;
  public String m_cPhName_tipo2_3;
  public String m_cServer_tipo2_3;
  public String m_cPhName_tipo4;
  public String m_cServer_tipo4;
  public String m_cPhName_tipo5;
  public String m_cServer_tipo5;
  public String m_cPhName_tipo6;
  public String m_cServer_tipo6;
  public String m_cPhName_tipo7;
  public String m_cServer_tipo7;
  public String m_cPhName_tipo8;
  public String m_cServer_tipo8;
  public String m_cPhName_tipo9;
  public String m_cServer_tipo9;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xiduciabo;
  public String m_cServer_xiduciabo;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
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
  public String gPathApp;
  public String gPathDoc;
  public String gUrlApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String _gPathApp;
  public String _gPathDoc;
  public String _gUrlApp;
  public String _gAzienda;
  public String _gMsgProc;
  public Process _process;
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
  public double _sonummesi;
  public double _somesiback;
  public double _meseora;
  public double _mesestart;
  public double _meseend;
  public double _yearora;
  public double _yearini;
  public double _yearend;
  public java.sql.Date _datfine;
  public java.sql.Date _datiniz;
  public java.sql.Date _data;
  public String w_codage;
  public String w_codcli;
  public String w_stoper;
  public String w_flgrae;
  public String w_flgrap;
  public String w_tiprap;
  public String w_flgint;
  public String w_codinter;
  public String w_tipinter;
  public String w_ragben;
  public String w_flgdel;
  public String cRitorno;
  public String _oldazi;
  public String cProg;
  public double o_tot;
  public double f_tot;
  public double i_tot;
  public String command;
  public String _soambiente;
  public String _soshellcmd;
  public String _mesecalc;
  public String _yearcalc;
  public MemoryCursor_mcconnes_mcrdef mcConnes;
  public MemoryCursor_personbo mcPersonbo;
  public MemoryCursor_wersonbo mcWersonbo;
  public MemoryCursor_anadip mcANADIP;
  public MemoryCursor_qbe_rapd_chkdiana_cgo_vqr mcRapporti;
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
  public boolean _xlientiope;
  public boolean _xogopebo;
  public boolean _xeneficope;
  public boolean _xerzistiope;
  public boolean _xlientifrz;
  public boolean _xogopefbo;
  public boolean _xeneficfrz;
  public boolean _xerzistifrz;
  public String pCodDip;
  public String pCodCab;
  public String pDesCit;
  public String pProv;
  public double _diff;
  public double _diff1;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_cgo_chkdiana
  String[] cmdArray = new String[4];
  // * --- Fine Area Manuale
  public arrt_cgo_chkdianaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_chkdiana",m_Caller);
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
    m_cPhName_cgo_cf_scarico380 = p_ContextObject.GetPhName("cgo_cf_scarico380");
    if (m_cPhName_cgo_cf_scarico380.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_cf_scarico380 = m_cPhName_cgo_cf_scarico380+" "+m_Ctx.GetWritePhName("cgo_cf_scarico380");
    }
    m_cServer_cgo_cf_scarico380 = p_ContextObject.GetServer("cgo_cf_scarico380");
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
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_destwarn = p_ContextObject.GetPhName("destwarn");
    if (m_cPhName_destwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_destwarn = m_cPhName_destwarn+" "+m_Ctx.GetWritePhName("destwarn");
    }
    m_cServer_destwarn = p_ContextObject.GetServer("destwarn");
    m_cPhName_fiduciabo = p_ContextObject.GetPhName("fiduciabo");
    if (m_cPhName_fiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fiduciabo = m_cPhName_fiduciabo+" "+m_Ctx.GetWritePhName("fiduciabo");
    }
    m_cServer_fiduciabo = p_ContextObject.GetServer("fiduciabo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
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
    m_cPhName_kersonbo = p_ContextObject.GetPhName("kersonbo");
    if (m_cPhName_kersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kersonbo = m_cPhName_kersonbo+" "+m_Ctx.GetWritePhName("kersonbo");
    }
    m_cServer_kersonbo = p_ContextObject.GetServer("kersonbo");
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
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
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
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
    m_cPhName_tipo1 = p_ContextObject.GetPhName("tipo1");
    if (m_cPhName_tipo1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo1 = m_cPhName_tipo1+" "+m_Ctx.GetWritePhName("tipo1");
    }
    m_cServer_tipo1 = p_ContextObject.GetServer("tipo1");
    m_cPhName_tipo2_3 = p_ContextObject.GetPhName("tipo2_3");
    if (m_cPhName_tipo2_3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo2_3 = m_cPhName_tipo2_3+" "+m_Ctx.GetWritePhName("tipo2_3");
    }
    m_cServer_tipo2_3 = p_ContextObject.GetServer("tipo2_3");
    m_cPhName_tipo4 = p_ContextObject.GetPhName("tipo4");
    if (m_cPhName_tipo4.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo4 = m_cPhName_tipo4+" "+m_Ctx.GetWritePhName("tipo4");
    }
    m_cServer_tipo4 = p_ContextObject.GetServer("tipo4");
    m_cPhName_tipo5 = p_ContextObject.GetPhName("tipo5");
    if (m_cPhName_tipo5.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo5 = m_cPhName_tipo5+" "+m_Ctx.GetWritePhName("tipo5");
    }
    m_cServer_tipo5 = p_ContextObject.GetServer("tipo5");
    m_cPhName_tipo6 = p_ContextObject.GetPhName("tipo6");
    if (m_cPhName_tipo6.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo6 = m_cPhName_tipo6+" "+m_Ctx.GetWritePhName("tipo6");
    }
    m_cServer_tipo6 = p_ContextObject.GetServer("tipo6");
    m_cPhName_tipo7 = p_ContextObject.GetPhName("tipo7");
    if (m_cPhName_tipo7.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo7 = m_cPhName_tipo7+" "+m_Ctx.GetWritePhName("tipo7");
    }
    m_cServer_tipo7 = p_ContextObject.GetServer("tipo7");
    m_cPhName_tipo8 = p_ContextObject.GetPhName("tipo8");
    if (m_cPhName_tipo8.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo8 = m_cPhName_tipo8+" "+m_Ctx.GetWritePhName("tipo8");
    }
    m_cServer_tipo8 = p_ContextObject.GetServer("tipo8");
    m_cPhName_tipo9 = p_ContextObject.GetPhName("tipo9");
    if (m_cPhName_tipo9.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tipo9 = m_cPhName_tipo9+" "+m_Ctx.GetWritePhName("tipo9");
    }
    m_cServer_tipo9 = p_ContextObject.GetServer("tipo9");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
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
    m_cPhName_xiduciabo = p_ContextObject.GetPhName("xiduciabo");
    if (m_cPhName_xiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xiduciabo = m_cPhName_xiduciabo+" "+m_Ctx.GetWritePhName("xiduciabo");
    }
    m_cServer_xiduciabo = p_ContextObject.GetServer("xiduciabo");
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
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
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
    if (CPLib.eqr("agente",p_cVarName)) {
      return w_agente;
    }
    if (CPLib.eqr("_rownum",p_cVarName)) {
      return _rownum;
    }
    if (CPLib.eqr("nTotRec",p_cVarName)) {
      return nTotRec;
    }
    if (CPLib.eqr("nTotReg",p_cVarName)) {
      return nTotReg;
    }
    if (CPLib.eqr("nNumRec",p_cVarName)) {
      return nNumRec;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      return _avanza;
    }
    if (CPLib.eqr("_ctotale",p_cVarName)) {
      return _ctotale;
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
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_ciclo",p_cVarName)) {
      return _ciclo;
    }
    if (CPLib.eqr("_oldrighe",p_cVarName)) {
      return _oldrighe;
    }
    if (CPLib.eqr("_continua",p_cVarName)) {
      return _continua;
    }
    if (CPLib.eqr("_conta1",p_cVarName)) {
      return _conta1;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      return _conta2;
    }
    if (CPLib.eqr("_conta4",p_cVarName)) {
      return _conta4;
    }
    if (CPLib.eqr("_conta5",p_cVarName)) {
      return _conta5;
    }
    if (CPLib.eqr("_conta6",p_cVarName)) {
      return _conta6;
    }
    if (CPLib.eqr("_conta7",p_cVarName)) {
      return _conta7;
    }
    if (CPLib.eqr("_conta8",p_cVarName)) {
      return _conta8;
    }
    if (CPLib.eqr("_conta9",p_cVarName)) {
      return _conta9;
    }
    if (CPLib.eqr("_sonummesi",p_cVarName)) {
      return _sonummesi;
    }
    if (CPLib.eqr("_somesiback",p_cVarName)) {
      return _somesiback;
    }
    if (CPLib.eqr("_meseora",p_cVarName)) {
      return _meseora;
    }
    if (CPLib.eqr("_mesestart",p_cVarName)) {
      return _mesestart;
    }
    if (CPLib.eqr("_meseend",p_cVarName)) {
      return _meseend;
    }
    if (CPLib.eqr("_yearora",p_cVarName)) {
      return _yearora;
    }
    if (CPLib.eqr("_yearini",p_cVarName)) {
      return _yearini;
    }
    if (CPLib.eqr("_yearend",p_cVarName)) {
      return _yearend;
    }
    if (CPLib.eqr("o_tot",p_cVarName)) {
      return o_tot;
    }
    if (CPLib.eqr("f_tot",p_cVarName)) {
      return f_tot;
    }
    if (CPLib.eqr("i_tot",p_cVarName)) {
      return i_tot;
    }
    if (CPLib.eqr("_diff",p_cVarName)) {
      return _diff;
    }
    if (CPLib.eqr("_diff1",p_cVarName)) {
      return _diff1;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_chkdiana";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("_gPathApp",p_cVarName)) {
      return _gPathApp;
    }
    if (CPLib.eqr("_gPathDoc",p_cVarName)) {
      return _gPathDoc;
    }
    if (CPLib.eqr("_gUrlApp",p_cVarName)) {
      return _gUrlApp;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      return _gMsgProc;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      return w_codcab;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      return w_cabcod;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      return w_desccit;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      return w_citdesc;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      return w_provin;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      return w_provind;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      return w_coddipe;
    }
    if (CPLib.eqr("_note",p_cVarName)) {
      return _note;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
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
    if (CPLib.eqr("_codrif",p_cVarName)) {
      return _codrif;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      return w_cdadata;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      return w_c_adata;
    }
    if (CPLib.eqr("cdadata_rap",p_cVarName)) {
      return w_cdadata_rap;
    }
    if (CPLib.eqr("c_adata_rap",p_cVarName)) {
      return w_c_adata_rap;
    }
    if (CPLib.eqr("cdareg_rap",p_cVarName)) {
      return w_cdareg_rap;
    }
    if (CPLib.eqr("c_areg_rap",p_cVarName)) {
      return w_c_areg_rap;
    }
    if (CPLib.eqr("_flagrap",p_cVarName)) {
      return _flagrap;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      return _ramate;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_oldrap",p_cVarName)) {
      return _oldrap;
    }
    if (CPLib.eqr("_idereg",p_cVarName)) {
      return _idereg;
    }
    if (CPLib.eqr("xStato",p_cVarName)) {
      return xStato;
    }
    if (CPLib.eqr("_tiprec",p_cVarName)) {
      return _tiprec;
    }
    if (CPLib.eqr("_raeatc",p_cVarName)) {
      return _raeatc;
    }
    if (CPLib.eqr("oldfolder",p_cVarName)) {
      return oldfolder;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      return _tipoag;
    }
    if (CPLib.eqr("_datage",p_cVarName)) {
      return _datage;
    }
    if (CPLib.eqr("_numticket",p_cVarName)) {
      return _numticket;
    }
    if (CPLib.eqr("cdareg",p_cVarName)) {
      return w_cdareg;
    }
    if (CPLib.eqr("c_areg",p_cVarName)) {
      return w_c_areg;
    }
    if (CPLib.eqr("z_codcab",p_cVarName)) {
      return z_codcab;
    }
    if (CPLib.eqr("z_desccit",p_cVarName)) {
      return z_desccit;
    }
    if (CPLib.eqr("z_provin",p_cVarName)) {
      return z_provin;
    }
    if (CPLib.eqr("z_coddipe",p_cVarName)) {
      return z_coddipe;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      return w_codage;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      return w_codcli;
    }
    if (CPLib.eqr("stoper",p_cVarName)) {
      return w_stoper;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      return w_flgrae;
    }
    if (CPLib.eqr("flgrap",p_cVarName)) {
      return w_flgrap;
    }
    if (CPLib.eqr("tiprap",p_cVarName)) {
      return w_tiprap;
    }
    if (CPLib.eqr("flgint",p_cVarName)) {
      return w_flgint;
    }
    if (CPLib.eqr("codinter",p_cVarName)) {
      return w_codinter;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      return w_tipinter;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      return w_ragben;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      return w_flgdel;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("command",p_cVarName)) {
      return command;
    }
    if (CPLib.eqr("_soambiente",p_cVarName)) {
      return _soambiente;
    }
    if (CPLib.eqr("_soshellcmd",p_cVarName)) {
      return _soshellcmd;
    }
    if (CPLib.eqr("_mesecalc",p_cVarName)) {
      return _mesecalc;
    }
    if (CPLib.eqr("_yearcalc",p_cVarName)) {
      return _yearcalc;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      return pCodDip;
    }
    if (CPLib.eqr("pCodCab",p_cVarName)) {
      return pCodCab;
    }
    if (CPLib.eqr("pDesCit",p_cVarName)) {
      return pDesCit;
    }
    if (CPLib.eqr("pProv",p_cVarName)) {
      return pProv;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datfine",p_cVarName)) {
      return _datfine;
    }
    if (CPLib.eqr("_datiniz",p_cVarName)) {
      return _datiniz;
    }
    if (CPLib.eqr("_data",p_cVarName)) {
      return _data;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
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
    if (CPLib.eqr("_xlientiope",p_cVarName)) {
      return _xlientiope;
    }
    if (CPLib.eqr("_xogopebo",p_cVarName)) {
      return _xogopebo;
    }
    if (CPLib.eqr("_xeneficope",p_cVarName)) {
      return _xeneficope;
    }
    if (CPLib.eqr("_xerzistiope",p_cVarName)) {
      return _xerzistiope;
    }
    if (CPLib.eqr("_xlientifrz",p_cVarName)) {
      return _xlientifrz;
    }
    if (CPLib.eqr("_xogopefbo",p_cVarName)) {
      return _xogopefbo;
    }
    if (CPLib.eqr("_xeneficfrz",p_cVarName)) {
      return _xeneficfrz;
    }
    if (CPLib.eqr("_xerzistifrz",p_cVarName)) {
      return _xerzistifrz;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcConnes",p_cVarName)) {
      return mcConnes;
    }
    if (CPLib.eqr("mcPersonbo",p_cVarName)) {
      return mcPersonbo;
    }
    if (CPLib.eqr("mcWersonbo",p_cVarName)) {
      return mcWersonbo;
    }
    if (CPLib.eqr("mcANADIP",p_cVarName)) {
      return mcANADIP;
    }
    if (CPLib.eqr("mcRapporti",p_cVarName)) {
      return mcRapporti;
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
    if (CPLib.eqr("agente",p_cVarName)) {
      w_agente = value;
      return;
    }
    if (CPLib.eqr("_rownum",p_cVarName)) {
      _rownum = value;
      return;
    }
    if (CPLib.eqr("nTotRec",p_cVarName)) {
      nTotRec = value;
      return;
    }
    if (CPLib.eqr("nTotReg",p_cVarName)) {
      nTotReg = value;
      return;
    }
    if (CPLib.eqr("nNumRec",p_cVarName)) {
      nNumRec = value;
      return;
    }
    if (CPLib.eqr("_avanza",p_cVarName)) {
      _avanza = value;
      return;
    }
    if (CPLib.eqr("_ctotale",p_cVarName)) {
      _ctotale = value;
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
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
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
    if (CPLib.eqr("_ciclo",p_cVarName)) {
      _ciclo = value;
      return;
    }
    if (CPLib.eqr("_oldrighe",p_cVarName)) {
      _oldrighe = value;
      return;
    }
    if (CPLib.eqr("_continua",p_cVarName)) {
      _continua = value;
      return;
    }
    if (CPLib.eqr("_conta1",p_cVarName)) {
      _conta1 = value;
      return;
    }
    if (CPLib.eqr("_conta2",p_cVarName)) {
      _conta2 = value;
      return;
    }
    if (CPLib.eqr("_conta4",p_cVarName)) {
      _conta4 = value;
      return;
    }
    if (CPLib.eqr("_conta5",p_cVarName)) {
      _conta5 = value;
      return;
    }
    if (CPLib.eqr("_conta6",p_cVarName)) {
      _conta6 = value;
      return;
    }
    if (CPLib.eqr("_conta7",p_cVarName)) {
      _conta7 = value;
      return;
    }
    if (CPLib.eqr("_conta8",p_cVarName)) {
      _conta8 = value;
      return;
    }
    if (CPLib.eqr("_conta9",p_cVarName)) {
      _conta9 = value;
      return;
    }
    if (CPLib.eqr("_sonummesi",p_cVarName)) {
      _sonummesi = value;
      return;
    }
    if (CPLib.eqr("_somesiback",p_cVarName)) {
      _somesiback = value;
      return;
    }
    if (CPLib.eqr("_meseora",p_cVarName)) {
      _meseora = value;
      return;
    }
    if (CPLib.eqr("_mesestart",p_cVarName)) {
      _mesestart = value;
      return;
    }
    if (CPLib.eqr("_meseend",p_cVarName)) {
      _meseend = value;
      return;
    }
    if (CPLib.eqr("_yearora",p_cVarName)) {
      _yearora = value;
      return;
    }
    if (CPLib.eqr("_yearini",p_cVarName)) {
      _yearini = value;
      return;
    }
    if (CPLib.eqr("_yearend",p_cVarName)) {
      _yearend = value;
      return;
    }
    if (CPLib.eqr("o_tot",p_cVarName)) {
      o_tot = value;
      return;
    }
    if (CPLib.eqr("f_tot",p_cVarName)) {
      f_tot = value;
      return;
    }
    if (CPLib.eqr("i_tot",p_cVarName)) {
      i_tot = value;
      return;
    }
    if (CPLib.eqr("_diff",p_cVarName)) {
      _diff = value;
      return;
    }
    if (CPLib.eqr("_diff1",p_cVarName)) {
      _diff1 = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("_gPathApp",p_cVarName)) {
      _gPathApp = value;
      return;
    }
    if (CPLib.eqr("_gPathDoc",p_cVarName)) {
      _gPathDoc = value;
      return;
    }
    if (CPLib.eqr("_gUrlApp",p_cVarName)) {
      _gUrlApp = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      _gMsgProc = value;
      return;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      w_codcab = value;
      return;
    }
    if (CPLib.eqr("cabcod",p_cVarName)) {
      w_cabcod = value;
      return;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      w_desccit = value;
      return;
    }
    if (CPLib.eqr("citdesc",p_cVarName)) {
      w_citdesc = value;
      return;
    }
    if (CPLib.eqr("provin",p_cVarName)) {
      w_provin = value;
      return;
    }
    if (CPLib.eqr("provind",p_cVarName)) {
      w_provind = value;
      return;
    }
    if (CPLib.eqr("coddipe",p_cVarName)) {
      w_coddipe = value;
      return;
    }
    if (CPLib.eqr("_note",p_cVarName)) {
      _note = value;
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
    if (CPLib.eqr("_codrif",p_cVarName)) {
      _codrif = value;
      return;
    }
    if (CPLib.eqr("cdadata",p_cVarName)) {
      w_cdadata = value;
      return;
    }
    if (CPLib.eqr("c_adata",p_cVarName)) {
      w_c_adata = value;
      return;
    }
    if (CPLib.eqr("cdadata_rap",p_cVarName)) {
      w_cdadata_rap = value;
      return;
    }
    if (CPLib.eqr("c_adata_rap",p_cVarName)) {
      w_c_adata_rap = value;
      return;
    }
    if (CPLib.eqr("cdareg_rap",p_cVarName)) {
      w_cdareg_rap = value;
      return;
    }
    if (CPLib.eqr("c_areg_rap",p_cVarName)) {
      w_c_areg_rap = value;
      return;
    }
    if (CPLib.eqr("_flagrap",p_cVarName)) {
      _flagrap = value;
      return;
    }
    if (CPLib.eqr("_ramate",p_cVarName)) {
      _ramate = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_oldrap",p_cVarName)) {
      _oldrap = value;
      return;
    }
    if (CPLib.eqr("_idereg",p_cVarName)) {
      _idereg = value;
      return;
    }
    if (CPLib.eqr("xStato",p_cVarName)) {
      xStato = value;
      return;
    }
    if (CPLib.eqr("_tiprec",p_cVarName)) {
      _tiprec = value;
      return;
    }
    if (CPLib.eqr("_raeatc",p_cVarName)) {
      _raeatc = value;
      return;
    }
    if (CPLib.eqr("oldfolder",p_cVarName)) {
      oldfolder = value;
      return;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      _tipoag = value;
      return;
    }
    if (CPLib.eqr("_datage",p_cVarName)) {
      _datage = value;
      return;
    }
    if (CPLib.eqr("_numticket",p_cVarName)) {
      _numticket = value;
      return;
    }
    if (CPLib.eqr("cdareg",p_cVarName)) {
      w_cdareg = value;
      return;
    }
    if (CPLib.eqr("c_areg",p_cVarName)) {
      w_c_areg = value;
      return;
    }
    if (CPLib.eqr("z_codcab",p_cVarName)) {
      z_codcab = value;
      return;
    }
    if (CPLib.eqr("z_desccit",p_cVarName)) {
      z_desccit = value;
      return;
    }
    if (CPLib.eqr("z_provin",p_cVarName)) {
      z_provin = value;
      return;
    }
    if (CPLib.eqr("z_coddipe",p_cVarName)) {
      z_coddipe = value;
      return;
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      w_codage = value;
      return;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      w_codcli = value;
      return;
    }
    if (CPLib.eqr("stoper",p_cVarName)) {
      w_stoper = value;
      return;
    }
    if (CPLib.eqr("flgrae",p_cVarName)) {
      w_flgrae = value;
      return;
    }
    if (CPLib.eqr("flgrap",p_cVarName)) {
      w_flgrap = value;
      return;
    }
    if (CPLib.eqr("tiprap",p_cVarName)) {
      w_tiprap = value;
      return;
    }
    if (CPLib.eqr("flgint",p_cVarName)) {
      w_flgint = value;
      return;
    }
    if (CPLib.eqr("codinter",p_cVarName)) {
      w_codinter = value;
      return;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      w_tipinter = value;
      return;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      w_ragben = value;
      return;
    }
    if (CPLib.eqr("flgdel",p_cVarName)) {
      w_flgdel = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("command",p_cVarName)) {
      command = value;
      return;
    }
    if (CPLib.eqr("_soambiente",p_cVarName)) {
      _soambiente = value;
      return;
    }
    if (CPLib.eqr("_soshellcmd",p_cVarName)) {
      _soshellcmd = value;
      return;
    }
    if (CPLib.eqr("_mesecalc",p_cVarName)) {
      _mesecalc = value;
      return;
    }
    if (CPLib.eqr("_yearcalc",p_cVarName)) {
      _yearcalc = value;
      return;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      pCodDip = value;
      return;
    }
    if (CPLib.eqr("pCodCab",p_cVarName)) {
      pCodCab = value;
      return;
    }
    if (CPLib.eqr("pDesCit",p_cVarName)) {
      pDesCit = value;
      return;
    }
    if (CPLib.eqr("pProv",p_cVarName)) {
      pProv = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datfine",p_cVarName)) {
      _datfine = value;
      return;
    }
    if (CPLib.eqr("_datiniz",p_cVarName)) {
      _datiniz = value;
      return;
    }
    if (CPLib.eqr("_data",p_cVarName)) {
      _data = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
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
    if (CPLib.eqr("_xlientiope",p_cVarName)) {
      _xlientiope = value;
      return;
    }
    if (CPLib.eqr("_xogopebo",p_cVarName)) {
      _xogopebo = value;
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
    if (CPLib.eqr("_xlientifrz",p_cVarName)) {
      _xlientifrz = value;
      return;
    }
    if (CPLib.eqr("_xogopefbo",p_cVarName)) {
      _xogopefbo = value;
      return;
    }
    if (CPLib.eqr("_xeneficfrz",p_cVarName)) {
      _xeneficfrz = value;
      return;
    }
    if (CPLib.eqr("_xerzistifrz",p_cVarName)) {
      _xerzistifrz = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcConnes",p_cVarName)) {
      mcConnes = (MemoryCursor_mcconnes_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcPersonbo",p_cVarName)) {
      mcPersonbo = (MemoryCursor_personbo)value;
      return;
    }
    if (CPLib.eqr("mcWersonbo",p_cVarName)) {
      mcWersonbo = (MemoryCursor_wersonbo)value;
      return;
    }
    if (CPLib.eqr("mcANADIP",p_cVarName)) {
      mcANADIP = (MemoryCursor_anadip)value;
      return;
    }
    if (CPLib.eqr("mcRapporti",p_cVarName)) {
      mcRapporti = (MemoryCursor_qbe_rapd_chkdiana_cgo_vqr)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_qbe_rapd_chkdiana_cgo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pTipo Char(1) // Tipo (Batch - Diretto)  */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* _gPathApp Char(80) // Path Applicazione */
      /* _gPathDoc Char(80) // Path Applicazione */
      /* _gUrlApp Char(80) // URL Applicazione */
      /* _gAzienda Char(10) // Azienda */
      /* _gMsgProc Memo // Messaggio */
      /* _process Object(Process) */
      /* w_codcab Char(6) */
      /* w_cabcod Char(6) */
      /* w_desccit Char(30) */
      /* w_citdesc Char(30) */
      /* w_provin Char(2) */
      /* w_provind Char(2) */
      /* w_coddipe Char(6) */
      /* w_agente Numeric(1, 0) */
      /* _note Memo */
      /* _rownum Numeric(10, 0) */
      /* fhand Char(10) */
      /* _nomefile Char(15) */
      /* cNomeFile Char(30) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* nTotRec Numeric(10, 0) */
      /* nTotReg Numeric(10, 0) */
      /* nNumRec Numeric(10, 0) */
      /* _avanza Numeric(1, 0) */
      /* _codrif Char(16) */
      /* w_cdadata Char(8) // Da Data Operazione */
      /* w_c_adata Char(8) // A Data Operazione */
      /* w_cdadata_rap Char(8) */
      /* w_c_adata_rap Char(8) */
      /* w_cdareg_rap Char(8) */
      /* w_c_areg_rap Char(8) */
      /* _ctotale Numeric(10, 0) */
      /* _conta Numeric(10, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _ctotale Numeric(15, 0) */
      /* _flagrap Char(1) */
      /* _ciclo Numeric(1, 0) */
      /* _ramate Char(3) */
      /* _numsto Char(15) */
      /* _oldrighe Numeric(1, 0) */
      /* _continua Numeric(1, 0) */
      /* _oldrap Char(25) */
      /* _idereg Char(20) */
      /* xStato Char(1) */
      /* _conta1 Numeric(10, 0) */
      /* _conta2 Numeric(10, 0) */
      /* _conta4 Numeric(10, 0) */
      /* _conta5 Numeric(10, 0) */
      /* _conta6 Numeric(10, 0) */
      /* _conta7 Numeric(10, 0) */
      /* _conta8 Numeric(10, 0) */
      /* _conta9 Numeric(10, 0) */
      /* _tiprec Char(1) */
      /* _raeatc Char(1) */
      /* oldfolder Char(120) */
      /* _tipoag Char(10) */
      /* _datage Char(44) */
      /* _numticket Char(30) */
      /* w_cdareg Char(8) // Da Data Registrazione */
      /* w_c_areg Char(8) // A Data Registrazione */
      /* z_codcab Char(6) */
      /* z_desccit Char(30) */
      /* z_provin Char(2) */
      /* z_coddipe Char(6) */
      /* _sonummesi Numeric(2, 0) */
      /* _somesiback Numeric(2, 0) */
      /* _meseora Numeric(2, 0) */
      /* _mesestart Numeric(2, 0) */
      /* _meseend Numeric(2, 0) */
      /* _yearora Numeric(4, 0) */
      /* _yearini Numeric(4, 0) */
      /* _yearend Numeric(4, 0) */
      /* _datfine Date */
      /* _datiniz Date */
      /* _data Date */
      /* w_codage Char(6) */
      /* w_codcli Char(10) */
      /* w_stoper Char(1) */
      /* w_flgrae Char(1) */
      /* w_flgrap Char(1) */
      /* w_tiprap Char(1) */
      /* w_flgint Char(1) */
      /* w_codinter Char(11) */
      /* w_tipinter Char(2) */
      /* w_ragben Char(70) */
      /* w_flgdel Char(1) */
      /* cRitorno Char(2) */
      /* _oldazi Char(10) */
      /* cProg Char(20) */
      /* o_tot Numeric(5, 0) // contatore operazioni inserite */
      /* f_tot Numeric(5, 0) // contatore delle operazioni frazionate inserite */
      /* i_tot Numeric(5, 0) // contatore informazioni inserite */
      /* command Char(500) */
      /* _soambiente Char(0) */
      /* _soshellcmd Char(0) */
      /* _mesecalc Char(2) */
      /* _yearcalc Char(4) */
      /* mcConnes MemoryCursor(mcConnes.MCRDef) */
      /* mcPersonbo MemoryCursor(personbo) */
      /* mcWersonbo MemoryCursor(wersonbo) */
      /* mcANADIP MemoryCursor(anadip) */
      /* mcRapporti MemoryCursor(qbe_rapd_chkdiana_cgo.vqr) */
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
      /* _xlientiope Bool */
      /* _xogopebo Bool */
      /* _xeneficope Bool */
      /* _xerzistiope Bool */
      /* _xlientifrz Bool */
      /* _xogopefbo Bool */
      /* _xeneficfrz Bool */
      /* _xerzistifrz Bool */
      /* pCodDip Char(6) // Codice Dipendenza */
      /* pCodCab Char(6) // CAB Dipendenza */
      /* pDesCit Char(30) // Città Dipendenza */
      /* pProv Char(2) // Provincia Dipendenza */
      /* o_tot := 0 // contatore operazioni inserite */
      o_tot = CPLib.Round(0,0);
      /* f_tot := 0 // contatore delle operazioni frazionate inserite */
      f_tot = CPLib.Round(0,0);
      /* i_tot := 0 // contatore informazioni inserite */
      i_tot = CPLib.Round(0,0);
      /* If pTipo='B' */
      if (CPLib.eqr(pTipo,"B")) {
        /* Utilities.SetUserCode(1) */
        Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
        /* _oldazi := Utilities.GetCompany() */
        _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
        // * --- Select from cpazi
        m_cServer = m_Ctx.GetServer("cpazi");
        m_cPhName = m_Ctx.GetPhName("cpazi");
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
        Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cpazi.Eof())) {
          /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
          Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
          /* _gAzienda := LRTrim(cpazi->codazi) // Azienda */
          _gAzienda = CPLib.LRTrim(Cursor_cpazi.GetString("codazi"));
          Cursor_cpazi.Next();
        }
        m_cConnectivityError = Cursor_cpazi.ErrorMessage();
        Cursor_cpazi.Close();
        // * --- End Select
        /* _gPathApp := gPathApp */
        _gPathApp = gPathApp;
      } else { // Else
        /* _oldazi := gAzienda */
        _oldazi = gAzienda;
        /* _gAzienda := gAzienda // Azienda */
        _gAzienda = gAzienda;
        /* _gPathApp := gPathApp */
        _gPathApp = gPathApp;
      } // End If
      /* Exec "Crea variabili per lettura tabelle accessorie" Page 5:Page_5 */
      Page_5();
      /* z_codcab := '' */
      z_codcab = "";
      /* z_desccit := '' */
      z_desccit = "";
      /* z_provin := '' */
      z_provin = "";
      /* z_coddipe := '' */
      z_coddipe = "";
      /* _sonummesi := 0 */
      _sonummesi = CPLib.Round(0,0);
      /* _somesiback := 0 */
      _somesiback = CPLib.Round(0,0);
      /* w_codinter := '' */
      w_codinter = "";
      /* w_tipinter := '' */
      w_tipinter = "";
      /* _gPathDoc := '' // Path Applicazione */
      _gPathDoc = "";
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* z_codcab := intermbo->CODCAB */
        z_codcab = Cursor_intermbo.GetString("CODCAB");
        /* z_desccit := intermbo->DESCCIT */
        z_desccit = Cursor_intermbo.GetString("DESCCIT");
        /* z_provin := intermbo->PROVINCIA */
        z_provin = Cursor_intermbo.GetString("PROVINCIA");
        /* z_coddipe := intermbo->CODDIPE */
        z_coddipe = Cursor_intermbo.GetString("CODDIPE");
        /* w_codinter := intermbo->CODINTER */
        w_codinter = Cursor_intermbo.GetString("CODINTER");
        /* w_tipinter := intermbo->TIPINTER */
        w_tipinter = Cursor_intermbo.GetString("TIPINTER");
        /* _gPathDoc := intermbo->RICEVUTE // Path Applicazione */
        _gPathDoc = Cursor_intermbo.GetString("RICEVUTE");
        /* _sonummesi := intermbo->SONUMMESI */
        _sonummesi = CPLib.Round(Cursor_intermbo.GetDouble("SONUMMESI"),0);
        /* _somesiback := intermbo->SOMESIBACK */
        _somesiback = CPLib.Round(Cursor_intermbo.GetDouble("SOMESIBACK"),0);
        /* _soambiente := intermbo->SOAMBIENTE */
        _soambiente = Cursor_intermbo.GetString("SOAMBIENTE");
        /* _soshellcmd := intermbo->SOSHELLCMD */
        _soshellcmd = Cursor_intermbo.GetString("SOSHELLCMD");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Fill memory cursor mcANADIP on anadip
      mcANADIP.Zap();
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
                info.log("Routine arrt_cgo_chkdiana: query on anadip returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_anadip.Eof())) {
        mcANADIP.AppendWithTrimmedKey(Cursor_anadip.GetString("CODDIP"));
        mcANADIP.row.CODDIP = Cursor_anadip.GetString("CODDIP");
        mcANADIP.row.DESCRIZ = Cursor_anadip.GetString("DESCRIZ");
        mcANADIP.row.IDCITTA = Cursor_anadip.GetString("IDCITTA");
        mcANADIP.row.DESCCIT = Cursor_anadip.GetString("DESCCIT");
        mcANADIP.row.PROVINCIA = Cursor_anadip.GetString("PROVINCIA");
        mcANADIP.row.CAB = Cursor_anadip.GetString("CAB");
        mcANADIP.row.IDBASE = Cursor_anadip.GetString("IDBASE");
        mcANADIP.row.AGENTE = Cursor_anadip.GetString("AGENTE");
        mcANADIP.row.MACROAGENTE = Cursor_anadip.GetString("MACROAGENTE");
        mcANADIP.row.TERMINALID = Cursor_anadip.GetString("TERMINALID");
        mcANADIP.row.DOMICILIO = Cursor_anadip.GetString("DOMICILIO");
        mcANADIP.row.TELEFONO = Cursor_anadip.GetString("TELEFONO");
        mcANADIP.row.CODLOC = Cursor_anadip.GetString("CODLOC");
        mcANADIP.row.ABICABSARA = Cursor_anadip.GetString("ABICABSARA");
        mcANADIP.row.NUOVO = Cursor_anadip.GetString("NUOVO");
        mcANADIP.row.CAP = Cursor_anadip.GetString("CAP");
        mcANADIP.row.AGACCODE = Cursor_anadip.GetString("AGACCODE");
        mcANADIP.row.NAZAGENTE = Cursor_anadip.GetString("NAZAGENTE");
        mcANADIP.row.OPXSOSCLI = Cursor_anadip.GetDouble("OPXSOSCLI");
        mcANADIP.row.OPXSOSAGE = Cursor_anadip.GetDouble("OPXSOSAGE");
        mcANADIP.row.VALCOMPL = Cursor_anadip.GetString("VALCOMPL");
        mcANADIP.row.ANOMOPER = Cursor_anadip.GetString("ANOMOPER");
        mcANADIP.row.AGEREGIO = Cursor_anadip.GetString("AGEREGIO");
        mcANADIP.row.FLGATT = Cursor_anadip.GetString("FLGATT");
        mcANADIP.row.CODAGE = Cursor_anadip.GetString("CODAGE");
        mcANADIP.row.TIPOSV = Cursor_anadip.GetString("TIPOSV");
        mcANADIP.row.FLGNOAUA = Cursor_anadip.GetString("FLGNOAUA");
        mcANADIP.row.FLGWUPOS = Cursor_anadip.GetString("FLGWUPOS");
        mcANADIP.row.CATEG01 = Cursor_anadip.GetString("CATEG01");
        mcANADIP.row.CATEG02 = Cursor_anadip.GetString("CATEG02");
        mcANADIP.row.CATEG03 = Cursor_anadip.GetString("CATEG03");
        mcANADIP.row.CATEG04 = Cursor_anadip.GetString("CATEG04");
        mcANADIP.row.CATEG05 = Cursor_anadip.GetString("CATEG05");
        mcANADIP.row.CATEGORIA = Cursor_anadip.GetString("CATEGORIA");
        mcANADIP.row.CAB2 = Cursor_anadip.GetString("CAB2");
        mcANADIP.row.RISGLOB = Cursor_anadip.GetString("RISGLOB");
        mcANADIP.row.DATAPROF = Cursor_anadip.GetDate("DATAPROF");
        mcANADIP.row.CODICEAAMS = Cursor_anadip.GetString("CODICEAAMS");
        mcANADIP.row.CONCESSIONE = Cursor_anadip.GetString("CONCESSIONE");
        mcANADIP.row.CODFISC = Cursor_anadip.GetString("CODFISC");
        mcANADIP.row.PARTIVA = Cursor_anadip.GetString("PARTIVA");
        mcANADIP.row.TIPOAGENTE = Cursor_anadip.GetString("TIPOAGENTE");
        mcANADIP.row.NUMCIVICO = Cursor_anadip.GetString("NUMCIVICO");
        mcANADIP.row.DATAINI = Cursor_anadip.GetDate("DATAINI");
        mcANADIP.row.DATAFINE = Cursor_anadip.GetDate("DATAFINE");
        mcANADIP.row.SERRIMDEN = Cursor_anadip.GetString("SERRIMDEN");
        mcANADIP.row.FLGCOMPL = Cursor_anadip.GetDouble("FLGCOMPL");
        Cursor_anadip.Next();
      }
      m_cConnectivityError = Cursor_anadip.ErrorMessage();
      Cursor_anadip.Close();
      mcANADIP.GoTop();
      /* _gMsgProc := _gMsgProc + 'Ora Inizio Procedura: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = _gMsgProc+"Ora Inizio Procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      /* Exec "Trova i connes in base al codice fiscale" Page 8:Page_8 */
      Page_8();
      /* If pTipo='D' */
      if (CPLib.eqr(pTipo,"D")) {
        /* gMsgProc := _gMsgProc */
        gMsgProc = _gMsgProc;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* xStato := '' */
      xStato = "";
      /* _codrif := '' */
      _codrif = "";
      /* _ctotale := 0 */
      _ctotale = CPLib.Round(0,0);
      // Calcola Data Inizio
      LocalDate today =  LocalDate.now().minusMonths((long) _somesiback);
      _data = java.sql.Date.valueOf(today);
      /* _datiniz := arfn_mese_inifin(Year(_data),iif(Month(_data)>=10,Str(Month(_data),2,0),'0'+Str(Month(_data),1,0)),'I') */
      _datiniz = arfn_mese_inifinR.Make(m_Ctx,this).Run(CPLib.Year(_data),(CPLib.ge(CPLib.Month(_data),10)?CPLib.Str(CPLib.Month(_data),2,0):"0"+CPLib.Str(CPLib.Month(_data),1,0)),"I");
      /* w_cdadata := DateToChar(_datiniz) */
      w_cdadata = CPLib.DateToChar(_datiniz);
      // Calcola data fine
      today =  LocalDate.now().minusMonths((long) (_somesiback - (_sonummesi-1)));
      _data = java.sql.Date.valueOf(today);
      /* _datfine := arfn_finemese(_data) */
      _datfine = arfn_finemeseR.Make(m_Ctx,this).Run(_data);
      /* w_c_adata := DateToChar(_datfine) */
      w_c_adata = CPLib.DateToChar(_datfine);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* cOnlyNomeFile := "campione.txt" */
      cOnlyNomeFile = "campione.txt";
      /* cNomeFile := LRTrim(_gPathDoc)+'/flussi/'+LRTrim(_gAzienda)+"/campione.txt" */
      cNomeFile = CPLib.LRTrim(_gPathDoc)+"/flussi/"+CPLib.LRTrim(_gAzienda)+"/campione.txt";
      /* cNomeFileZip := LRTrim(_gPathDoc)+'/flussi/'+LRTrim(_gAzienda)+"/campione.zip" */
      cNomeFileZip = CPLib.LRTrim(_gPathDoc)+"/flussi/"+CPLib.LRTrim(_gAzienda)+"/campione.zip";
      /* fhand := FileLibMit.OpenWritePath(LRTrim(_gPathDoc)+'/flussi/'+LRTrim(_gAzienda)+"/"+LRTrim(cOnlyNomeFile)) */
      fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(_gPathDoc)+"/flussi/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile));
      double nTry000000D1status;
      nTry000000D1status = m_Sql.GetTransactionStatus();
      String cTry000000D1msg;
      cTry000000D1msg = m_Sql.TransactionErrorMessage();
      try {
        /* w_stoper := 'R' */
        w_stoper = "R";
        /* w_flgrae := 'A' */
        w_flgrae = "A";
        /* w_flgrap := 'S' */
        w_flgrap = "S";
        /* w_tiprap := '3' */
        w_tiprap = "3";
        /* w_flgint := 'S' */
        w_flgint = "S";
        /* w_flgdel := 'S' */
        w_flgdel = "S";
        /* _gMsgProc := _gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
        _gMsgProc = _gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
        /* w_cdadata_rap := w_cdadata */
        w_cdadata_rap = w_cdadata;
        /* w_c_adata_rap := w_c_adata */
        w_c_adata_rap = w_c_adata;
        /* w_cdareg_rap := w_cdareg */
        w_cdareg_rap = w_cdareg;
        /* w_c_areg_rap := w_c_areg */
        w_c_areg_rap = w_c_areg;
        // * --- Fill memory cursor mcRapporti on qbe_rapd_chkdiana_cgo
        mcRapporti.Zap();
        SPBridge.HMCaller _h000000DE;
        _h000000DE = new SPBridge.HMCaller();
        _h000000DE.Set("m_cVQRList",m_cVQRList);
        _h000000DE.Set("cdadata_rap",w_cdadata_rap);
        _h000000DE.Set("c_adata_rap",w_c_adata_rap);
        if (Cursor_qbe_rapd_chkdiana_cgo!=null)
          Cursor_qbe_rapd_chkdiana_cgo.Close();
        Cursor_qbe_rapd_chkdiana_cgo = new VQRHolder("qbe_rapd_chkdiana_cgo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000DE,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rapd_chkdiana_cgo;
          Cursor_qbe_rapd_chkdiana_cgo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_cgo_chkdiana: query on qbe_rapd_chkdiana_cgo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rapd_chkdiana_cgo.Eof())) {
          mcRapporti.AppendWithTrimmedKey(Cursor_qbe_rapd_chkdiana_cgo.GetString("CODINTER"));
          mcRapporti.row.CODINTER = Cursor_qbe_rapd_chkdiana_cgo.GetString("CODINTER");
          Cursor_qbe_rapd_chkdiana_cgo.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapd_chkdiana_cgo.ErrorMessage();
        Cursor_qbe_rapd_chkdiana_cgo.Close();
        mcRapporti.GoTop();
        /* If pTipo='D' */
        if (CPLib.eqr(pTipo,"D")) {
          /* gMsgProc := _gMsgProc */
          gMsgProc = _gMsgProc;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        for (MemoryCursorRow_mcconnes_mcrdef rowConnes : mcConnes._iterable_()) {
          /* w_codcli := rowConnes.connes */
          w_codcli = rowConnes.connes;
          /* mcPersonbo.Zap() */
          mcPersonbo.Zap();
          /* mcWersonbo.Zap() */
          mcWersonbo.Zap();
          // * --- Fill memory cursor mcPersonbo on personbo
          mcPersonbo.Zap();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codcli,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codcli)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_personbo;
            Cursor_personbo.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_cgo_chkdiana: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_personbo.Eof())) {
            mcPersonbo.AppendBlank();
            mcPersonbo.row.CONNES = Cursor_personbo.GetString("CONNES");
            mcPersonbo.row.CODCAB = Cursor_personbo.GetString("CODCAB");
            mcPersonbo.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
            mcPersonbo.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
            mcPersonbo.row.CODFISC = Cursor_personbo.GetString("CODFISC");
            mcPersonbo.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
            mcPersonbo.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
            mcPersonbo.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
            mcPersonbo.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
            mcPersonbo.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
            mcPersonbo.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
            mcPersonbo.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
            mcPersonbo.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
            mcPersonbo.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
            mcPersonbo.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
            mcPersonbo.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
            mcPersonbo.row.PAESE = Cursor_personbo.GetString("PAESE");
            mcPersonbo.row.CAP = Cursor_personbo.GetString("CAP");
            mcPersonbo.row.CODINTER = Cursor_personbo.GetString("CODINTER");
            mcPersonbo.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
            mcPersonbo.row.TIPOPERS = Cursor_personbo.GetString("TIPOPERS");
            mcPersonbo.row.CODDIPE = Cursor_personbo.GetString("CODDIPE");
            mcPersonbo.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
            mcPersonbo.row.NOTE = Cursor_personbo.GetString("NOTE");
            mcPersonbo.row.SESSO = Cursor_personbo.GetString("SESSO");
            mcPersonbo.row.SOSPMAF = Cursor_personbo.GetString("SOSPMAF");
            mcPersonbo.row.idcitta = Cursor_personbo.GetString("idcitta");
            mcPersonbo.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
            mcPersonbo.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
            mcPersonbo.row.DOCFILE = Cursor_personbo.GetString("DOCFILE");
            mcPersonbo.row.NOME = Cursor_personbo.GetString("NOME");
            mcPersonbo.row.COGNOME = Cursor_personbo.GetString("COGNOME");
            mcPersonbo.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
            mcPersonbo.row.OLDCONNES = Cursor_personbo.GetString("OLDCONNES");
            mcPersonbo.row.DATEXTRA = Cursor_personbo.GetDate("DATEXTRA");
            mcPersonbo.row.PKTBSPECIE = Cursor_personbo.GetString("PKTBSPECIE");
            mcPersonbo.row.COMPORT = Cursor_personbo.GetString("COMPORT");
            mcPersonbo.row.ATTIV = Cursor_personbo.GetString("ATTIV");
            mcPersonbo.row.RNATGIU = Cursor_personbo.GetDouble("RNATGIU");
            mcPersonbo.row.RATTIV = Cursor_personbo.GetDouble("RATTIV");
            mcPersonbo.row.RCOMP = Cursor_personbo.GetDouble("RCOMP");
            mcPersonbo.row.RAREA = Cursor_personbo.GetDouble("RAREA");
            mcPersonbo.row.ALLINEATO = Cursor_personbo.GetDouble("ALLINEATO");
            mcPersonbo.row.ALLINEATONOMECNOME = Cursor_personbo.GetDouble("ALLINEATONOMECNOME");
            mcPersonbo.row.RAGSOCOLD = Cursor_personbo.GetString("RAGSOCOLD");
            mcPersonbo.row.PROGIMPORT = Cursor_personbo.GetDouble("PROGIMPORT");
            mcPersonbo.row.PROGIMP_C = Cursor_personbo.GetString("PROGIMP_C");
            mcPersonbo.row.AREAGEO = Cursor_personbo.GetString("AREAGEO");
            mcPersonbo.row.PEP = Cursor_personbo.GetString("PEP");
            mcPersonbo.row.IDFILE = Cursor_personbo.GetString("IDFILE");
            mcPersonbo.row.OLDCODFISC = Cursor_personbo.GetString("OLDCODFISC");
            mcPersonbo.row.MACROAGENTE = Cursor_personbo.GetString("MACROAGENTE");
            mcPersonbo.row.SPOTID = Cursor_personbo.GetString("SPOTID");
            mcPersonbo.row.DATASEGN = Cursor_personbo.GetDate("DATASEGN");
            mcPersonbo.row.OLDSETSIN = Cursor_personbo.GetString("OLDSETSIN");
            mcPersonbo.row.DATAVARAGE = Cursor_personbo.GetDate("DATAVARAGE");
            mcPersonbo.row.SETTSINT2 = Cursor_personbo.GetString("SETTSINT2");
            mcPersonbo.row.FATCA = Cursor_personbo.GetString("FATCA");
            mcPersonbo.row.BANCABEN = Cursor_personbo.GetString("BANCABEN");
            mcPersonbo.row.TIN = Cursor_personbo.GetString("TIN");
            mcPersonbo.row.ODB = Cursor_personbo.GetDouble("ODB");
            mcPersonbo.row.TELEF = Cursor_personbo.GetString("TELEF");
            mcPersonbo.row.TIPOORO = Cursor_personbo.GetString("TIPOORO");
            mcPersonbo.row.CODORO = Cursor_personbo.GetString("CODORO");
            mcPersonbo.row.IDNASCOMUN = Cursor_personbo.GetString("IDNASCOMUN");
            mcPersonbo.row.IDNASSTATO = Cursor_personbo.GetString("IDNASSTATO");
            mcPersonbo.row.NOTIT = Cursor_personbo.GetDouble("NOTIT");
            mcPersonbo.row.IDBASE = Cursor_personbo.GetString("IDBASE");
            mcPersonbo.row.FLGVALIDO = Cursor_personbo.GetString("FLGVALIDO");
            mcPersonbo.row.CITTADIN1 = Cursor_personbo.GetString("CITTADIN1");
            mcPersonbo.row.CITTADIN2 = Cursor_personbo.GetString("CITTADIN2");
            mcPersonbo.row.RESFISC = Cursor_personbo.GetString("RESFISC");
            mcPersonbo.row.MITIG = Cursor_personbo.GetDouble("MITIG");
            mcPersonbo.row.MITIGDOC = Cursor_personbo.GetString("MITIGDOC");
            mcPersonbo.row.NOSARA = Cursor_personbo.GetString("NOSARA");
            mcPersonbo.row.RISGLOB = Cursor_personbo.GetString("RISGLOB");
            mcPersonbo.row.DATAPROF = Cursor_personbo.GetDate("DATAPROF");
            mcPersonbo.row.DATAREVPROF = Cursor_personbo.GetDate("DATAREVPROF");
            mcPersonbo.row.IDENT = Cursor_personbo.GetString("IDENT");
            mcPersonbo.row.PEPDATE = Cursor_personbo.GetDate("PEPDATE");
            mcPersonbo.row.DAC6 = Cursor_personbo.GetString("DAC6");
            mcPersonbo.row.FLAGDAC6 = Cursor_personbo.GetDouble("FLAGDAC6");
            mcPersonbo.row.CRIME = Cursor_personbo.GetString("CRIME");
            mcPersonbo.row.CRIMEDATE = Cursor_personbo.GetDate("CRIMEDATE");
            mcPersonbo.row.ALTRODOM = Cursor_personbo.GetString("ALTRODOM");
            mcPersonbo.row.ALTROCAP = Cursor_personbo.GetString("ALTROCAP");
            mcPersonbo.row.CONTO = Cursor_personbo.GetString("CONTO");
            mcPersonbo.row.NUMIMP = Cursor_personbo.GetDateTime("NUMIMP");
            mcPersonbo.row.RAPSEGNA = Cursor_personbo.GetString("RAPSEGNA");
            mcPersonbo.row.CODLEGRAP = Cursor_personbo.GetString("CODLEGRAP");
            mcPersonbo.row.TIPOSOGGETTO = Cursor_personbo.GetString("TIPOSOGGETTO");
            mcPersonbo.row.CAUSALE = Cursor_personbo.GetDouble("CAUSALE");
            mcPersonbo.row.IMPORTOMAX = Cursor_personbo.GetDouble("IMPORTOMAX");
            mcPersonbo.row.FATTURATO = Cursor_personbo.GetDouble("FATTURATO");
            mcPersonbo.row.FREQUENZA = Cursor_personbo.GetString("FREQUENZA");
            mcPersonbo.row.NUMOPERAZ = Cursor_personbo.GetDouble("NUMOPERAZ");
            mcPersonbo.row.SOGAFFIDATARIO = Cursor_personbo.GetString("SOGAFFIDATARIO");
            mcPersonbo.row.FLGNOTRIM = Cursor_personbo.GetString("FLGNOTRIM");
            mcPersonbo.row.DISATTIVO = Cursor_personbo.GetDate("DISATTIVO");
            mcPersonbo.row.DATAFINE = Cursor_personbo.GetDate("DATAFINE");
            mcPersonbo.row.DATAINI = Cursor_personbo.GetDate("DATAINI");
            mcPersonbo.row.DATAIDENT = Cursor_personbo.GetDate("DATAIDENT");
            mcPersonbo.row.DATASIGN = Cursor_personbo.GetDate("DATASIGN");
            mcPersonbo.row.DATARAUT = Cursor_personbo.GetDate("DATARAUT");
            mcPersonbo.row.VERIFICA = Cursor_personbo.GetString("VERIFICA");
            mcPersonbo.row.NOTERIS = Cursor_personbo.GetString("NOTERIS");
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          mcPersonbo.GoTop();
          // * --- Fill memory cursor mcWersonbo on wersonbo
          mcWersonbo.Zap();
          m_cServer = m_Ctx.GetServer("wersonbo");
          m_cPhName = m_Ctx.GetPhName("wersonbo");
          if (Cursor_wersonbo!=null)
            Cursor_wersonbo.Close();
          Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_codcli,"?",0,0,m_cServer, m_oParameters),m_cServer,w_codcli)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_wersonbo;
            Cursor_wersonbo.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_cgo_chkdiana: query on wersonbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_wersonbo.Eof())) {
            mcWersonbo.AppendWithTrimmedKey(Cursor_wersonbo.GetString("sanumpro"));
            mcWersonbo.row.sanumpro = Cursor_wersonbo.GetString("sanumpro");
            mcWersonbo.row.CONNES = Cursor_wersonbo.GetString("CONNES");
            mcWersonbo.row.CODCAB = Cursor_wersonbo.GetString("CODCAB");
            mcWersonbo.row.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
            mcWersonbo.row.DOMICILIO = Cursor_wersonbo.GetString("DOMICILIO");
            mcWersonbo.row.CODFISC = Cursor_wersonbo.GetString("CODFISC");
            mcWersonbo.row.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
            mcWersonbo.row.NASCOMUN = Cursor_wersonbo.GetString("NASCOMUN");
            mcWersonbo.row.SOTGRUP = Cursor_wersonbo.GetString("SOTGRUP");
            mcWersonbo.row.RAMOGRUP = Cursor_wersonbo.GetString("RAMOGRUP");
            mcWersonbo.row.SETTSINT = Cursor_wersonbo.GetString("SETTSINT");
            mcWersonbo.row.TIPODOC = Cursor_wersonbo.GetString("TIPODOC");
            mcWersonbo.row.NUMDOCUM = Cursor_wersonbo.GetString("NUMDOCUM");
            mcWersonbo.row.DATARILASC = Cursor_wersonbo.GetDate("DATARILASC");
            mcWersonbo.row.AUTRILASC = Cursor_wersonbo.GetString("AUTRILASC");
            mcWersonbo.row.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
            mcWersonbo.row.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
            mcWersonbo.row.PAESE = Cursor_wersonbo.GetString("PAESE");
            mcWersonbo.row.CAP = Cursor_wersonbo.GetString("CAP");
            mcWersonbo.row.CODINTER = Cursor_wersonbo.GetString("CODINTER");
            mcWersonbo.row.TIPINTER = Cursor_wersonbo.GetString("TIPINTER");
            mcWersonbo.row.TIPOPERS = Cursor_wersonbo.GetString("TIPOPERS");
            mcWersonbo.row.CODDIPE = Cursor_wersonbo.GetString("CODDIPE");
            mcWersonbo.row.PARTIVA = Cursor_wersonbo.GetString("PARTIVA");
            mcWersonbo.row.NOTE = Cursor_wersonbo.GetString("NOTE");
            mcWersonbo.row.SESSO = Cursor_wersonbo.GetString("SESSO");
            mcWersonbo.row.SOSPMAF = Cursor_wersonbo.GetString("SOSPMAF");
            mcWersonbo.row.idcitta = Cursor_wersonbo.GetString("idcitta");
            mcWersonbo.row.DATAVALI = Cursor_wersonbo.GetDate("DATAVALI");
            mcWersonbo.row.NASSTATO = Cursor_wersonbo.GetString("NASSTATO");
            mcWersonbo.row.DOCFILE = Cursor_wersonbo.GetString("DOCFILE");
            mcWersonbo.row.NOME = Cursor_wersonbo.GetString("NOME");
            mcWersonbo.row.COGNOME = Cursor_wersonbo.GetString("COGNOME");
            mcWersonbo.row.CFESTERO = Cursor_wersonbo.GetDouble("CFESTERO");
            mcWersonbo.row.OLDCONNES = Cursor_wersonbo.GetString("OLDCONNES");
            mcWersonbo.row.DATEXTRA = Cursor_wersonbo.GetDate("DATEXTRA");
            mcWersonbo.row.PKTBSPECIE = Cursor_wersonbo.GetString("PKTBSPECIE");
            mcWersonbo.row.COMPORT = Cursor_wersonbo.GetString("COMPORT");
            mcWersonbo.row.ATTIV = Cursor_wersonbo.GetString("ATTIV");
            mcWersonbo.row.RNATGIU = Cursor_wersonbo.GetDouble("RNATGIU");
            mcWersonbo.row.RATTIV = Cursor_wersonbo.GetDouble("RATTIV");
            mcWersonbo.row.RCOMP = Cursor_wersonbo.GetDouble("RCOMP");
            mcWersonbo.row.RAREA = Cursor_wersonbo.GetDouble("RAREA");
            mcWersonbo.row.ALLINEATO = Cursor_wersonbo.GetDouble("ALLINEATO");
            mcWersonbo.row.ALLINEATONOMECNOME = Cursor_wersonbo.GetDouble("ALLINEATONOMECNOME");
            mcWersonbo.row.RAGSOCOLD = Cursor_wersonbo.GetString("RAGSOCOLD");
            mcWersonbo.row.PROGIMPORT = Cursor_wersonbo.GetDouble("PROGIMPORT");
            mcWersonbo.row.PROGIMP_C = Cursor_wersonbo.GetString("PROGIMP_C");
            mcWersonbo.row.AREAGEO = Cursor_wersonbo.GetString("AREAGEO");
            mcWersonbo.row.datamodi = Cursor_wersonbo.GetDate("datamodi");
            mcWersonbo.row.PEP = Cursor_wersonbo.GetString("PEP");
            mcWersonbo.row.IDFILE = Cursor_wersonbo.GetString("IDFILE");
            mcWersonbo.row.OLDCODFISC = Cursor_wersonbo.GetString("OLDCODFISC");
            mcWersonbo.row.MACROAGENTE = Cursor_wersonbo.GetString("MACROAGENTE");
            mcWersonbo.row.SPOTID = Cursor_wersonbo.GetString("SPOTID");
            mcWersonbo.row.DATASEGN = Cursor_wersonbo.GetDate("DATASEGN");
            mcWersonbo.row.OLDSETSIN = Cursor_wersonbo.GetString("OLDSETSIN");
            mcWersonbo.row.DATAVARAGE = Cursor_wersonbo.GetDate("DATAVARAGE");
            mcWersonbo.row.SETTSINT2 = Cursor_wersonbo.GetString("SETTSINT2");
            mcWersonbo.row.FATCA = Cursor_wersonbo.GetString("FATCA");
            mcWersonbo.row.BANCABEN = Cursor_wersonbo.GetString("BANCABEN");
            mcWersonbo.row.TIN = Cursor_wersonbo.GetString("TIN");
            mcWersonbo.row.ODB = Cursor_wersonbo.GetDouble("ODB");
            mcWersonbo.row.TELEF = Cursor_wersonbo.GetString("TELEF");
            mcWersonbo.row.TIPOORO = Cursor_wersonbo.GetString("TIPOORO");
            mcWersonbo.row.CODORO = Cursor_wersonbo.GetString("CODORO");
            mcWersonbo.row.IDNASCOMUN = Cursor_wersonbo.GetString("IDNASCOMUN");
            mcWersonbo.row.IDNASSTATO = Cursor_wersonbo.GetString("IDNASSTATO");
            mcWersonbo.row.NOTIT = Cursor_wersonbo.GetDouble("NOTIT");
            mcWersonbo.row.IDBASE = Cursor_wersonbo.GetString("IDBASE");
            mcWersonbo.row.FLGVALIDO = Cursor_wersonbo.GetString("FLGVALIDO");
            mcWersonbo.row.CITTADIN1 = Cursor_wersonbo.GetString("CITTADIN1");
            mcWersonbo.row.CITTADIN2 = Cursor_wersonbo.GetString("CITTADIN2");
            mcWersonbo.row.RESFISC = Cursor_wersonbo.GetString("RESFISC");
            mcWersonbo.row.MITIG = Cursor_wersonbo.GetDouble("MITIG");
            mcWersonbo.row.MITGDOC = Cursor_wersonbo.GetString("MITGDOC");
            mcWersonbo.row.NOSARA = Cursor_wersonbo.GetString("NOSARA");
            mcWersonbo.row.RISGLOB = Cursor_wersonbo.GetString("RISGLOB");
            mcWersonbo.row.DATAPROF = Cursor_wersonbo.GetDate("DATAPROF");
            mcWersonbo.row.DATAREVPROF = Cursor_wersonbo.GetDate("DATAREVPROF");
            mcWersonbo.row.IDENT = Cursor_wersonbo.GetString("IDENT");
            mcWersonbo.row.PEPDATE = Cursor_wersonbo.GetDate("PEPDATE");
            mcWersonbo.row.DAC6 = Cursor_wersonbo.GetString("DAC6");
            mcWersonbo.row.FLAGDAC6 = Cursor_wersonbo.GetDouble("FLAGDAC6");
            mcWersonbo.row.CRIME = Cursor_wersonbo.GetString("CRIME");
            mcWersonbo.row.CRIMEDATE = Cursor_wersonbo.GetDate("CRIMEDATE");
            mcWersonbo.row.ALTRODOM = Cursor_wersonbo.GetString("ALTRODOM");
            mcWersonbo.row.ALTROCAP = Cursor_wersonbo.GetString("ALTROCAP");
            mcWersonbo.row.CONTO = Cursor_wersonbo.GetString("CONTO");
            mcWersonbo.row.NUMIMP = Cursor_wersonbo.GetDateTime("NUMIMP");
            mcWersonbo.row.RAPSEGNA = Cursor_wersonbo.GetString("RAPSEGNA");
            mcWersonbo.row.CODLEGRAP = Cursor_wersonbo.GetString("CODLEGRAP");
            mcWersonbo.row.TIPOSOGGETTO = Cursor_wersonbo.GetString("TIPOSOGGETTO");
            mcWersonbo.row.CAUSALE = Cursor_wersonbo.GetDouble("CAUSALE");
            mcWersonbo.row.IMPORTOMAX = Cursor_wersonbo.GetDouble("IMPORTOMAX");
            mcWersonbo.row.FATTURATO = Cursor_wersonbo.GetDouble("FATTURATO");
            mcWersonbo.row.FREQUENZA = Cursor_wersonbo.GetString("FREQUENZA");
            mcWersonbo.row.NUMOPERAZ = Cursor_wersonbo.GetDouble("NUMOPERAZ");
            mcWersonbo.row.SOGAFFIDATARIO = Cursor_wersonbo.GetString("SOGAFFIDATARIO");
            mcWersonbo.row.FLGNOTRIM = Cursor_wersonbo.GetString("FLGNOTRIM");
            mcWersonbo.row.DISATTIVO = Cursor_wersonbo.GetDate("DISATTIVO");
            mcWersonbo.row.DATAFINE = Cursor_wersonbo.GetDate("DATAFINE");
            mcWersonbo.row.DATAINI = Cursor_wersonbo.GetDate("DATAINI");
            mcWersonbo.row.DATAIDENT = Cursor_wersonbo.GetDate("DATAIDENT");
            mcWersonbo.row.DATASIGN = Cursor_wersonbo.GetDate("DATASIGN");
            mcWersonbo.row.DATARAUT = Cursor_wersonbo.GetDate("DATARAUT");
            mcWersonbo.row.VERIFICA = Cursor_wersonbo.GetString("VERIFICA");
            mcWersonbo.row.NOTERIS = Cursor_wersonbo.GetString("NOTERIS");
            Cursor_wersonbo.Next();
          }
          m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
          Cursor_wersonbo.Close();
          mcWersonbo.GoTop();
          /* If mcRapporti.HasKey(w_codcli) */
          if (mcRapporti.HasKey(w_codcli)) {
            /* Exec "Informazioni" Page 3:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } // End If
          /* Exec "Operazioni" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
        }
        //
        FileLibMit.Close(fhand);
        /* Exec "Crea file zip" Page 7:Page_7 */
        Page_7();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
        _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
        /* If pTipo='D' */
        if (CPLib.eqr(pTipo,"D")) {
          /* gMsgImp := 'Elaborazione terminata. Premere il bottone per prelevare il file' // Messaggio Import */
          gMsgImp = "Elaborazione terminata. Premere il bottone per prelevare il file";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := _gMsgProc */
          gMsgProc = _gMsgProc;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* cRitorno := 'OK' */
        cRitorno = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* _gMsgProc := _gMsgProc + "Rilevati errori nell'elaborazione dei dati !" + NL */
        _gMsgProc = _gMsgProc+"Rilevati errori nell'elaborazione dei dati !"+"\n";
        /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
        _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
        /* cRitorno := 'KO' */
        cRitorno = "KO";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000D1status,0)) {
          m_Sql.SetTransactionStatus(nTry000000D1status,cTry000000D1msg);
        }
      }
      /* If pTipo='B' */
      if (CPLib.eqr(pTipo,"B")) {
        /* _gMsgProc := _gMsgProc + 'Ora Invio Email Risultato Procedura: '+ arfn_fdatetime(DateTime()) + NL */
        _gMsgProc = _gMsgProc+"Ora Invio Email Risultato Procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        /* If pTipo='D' */
        if (CPLib.eqr(pTipo,"D")) {
          /* gMsgProc := _gMsgProc */
          gMsgProc = _gMsgProc;
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* Exec "Gestione Mail" Page 10:invioEMail */
        invioEMail();
      } // End If
      /* _gMsgProc := _gMsgProc + 'Ora Fine Procedura: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = _gMsgProc+"Ora Fine Procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      /* If pTipo='D' */
      if (CPLib.eqr(pTipo,"D")) {
        /* gMsgProc := _gMsgProc */
        gMsgProc = _gMsgProc;
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* Utilities.SetCompany(_gAzienda) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(_gAzienda);
      /* Exec Routine arrt_writelog('CREA380','SCHEDULER',"RESULTS",_gMsgProc,"S") */
      arrt_writelogR.Make(m_Ctx,this).Run("CREA380","SCHEDULER","RESULTS",_gMsgProc,"S");
      /* If not(Empty(_soshellcmd)) */
      if ( ! (CPLib.Empty(_soshellcmd))) {
        /* _process := Runtime.getRuntime().exec(_soshellcmd) */
        _process = Runtime.getRuntime().exec(_soshellcmd);
        // Stampa valori
        int exitVal = _process.waitFor();
        /* Utilities.SetCompany(_gAzienda) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(_gAzienda);
        /* Exec Routine arrt_writelog('CREA380','SCHEDULER',"RESULTS",iif(exitVal=0,'Esecuzione comando shell avvenuta con successo','Esecuzione comando shell fallita'),"S") */
        arrt_writelogR.Make(m_Ctx,this).Run("CREA380","SCHEDULER","RESULTS",(CPLib.eqr(exitVal,0)?"Esecuzione comando shell avvenuta con successo":"Esecuzione comando shell fallita"),"S");
      } // End If
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
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
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rapd_chkdiana_cgo!=null)
          Cursor_qbe_rapd_chkdiana_cgo.Close();
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
    CPResultSet Cursor_qbe_oped_chkdiana_cli_cgo=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_mlientiope=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_mogopebo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_meneficope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_merzistiope=null;
    CPResultSet Cursor_terzistiope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle operazioni di uno specifico cliente */
      /* If pTipo='D' */
      if (CPLib.eqr(pTipo,"D")) {
        /* gMsgImp := 'Verifica Operazioni del cliente da elaborare ...' // Messaggio Import */
        gMsgImp = "Verifica Operazioni del cliente da elaborare ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      // * --- Select from qbe_oped_chkdiana_cli_cgo
      SPBridge.HMCaller _h00000109;
      _h00000109 = new SPBridge.HMCaller();
      _h00000109.Set("m_cVQRList",m_cVQRList);
      _h00000109.Set("cdadata",w_cdadata);
      _h00000109.Set("c_adata",w_c_adata);
      _h00000109.Set("codage",w_codage);
      _h00000109.Set("codcli",w_codcli);
      _h00000109.Set("ragben",w_ragben);
      _h00000109.Set("cdareg",w_cdareg);
      _h00000109.Set("c_areg",w_c_areg);
      if (Cursor_qbe_oped_chkdiana_cli_cgo!=null)
        Cursor_qbe_oped_chkdiana_cli_cgo.Close();
      Cursor_qbe_oped_chkdiana_cli_cgo = new VQRHolder("qbe_oped_chkdiana_cli_cgo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000109,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_oped_chkdiana_cli_cgo.Eof())) {
        /* o_tot := o_tot+1 // contatore operazioni inserite */
        o_tot = CPLib.Round(o_tot+1,0);
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* If pTipo='D' */
        if (CPLib.eqr(pTipo,"D")) {
          /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _idereg := qbe_oped_chkdiana_cli_cgo->IDEREG */
        _idereg = Cursor_qbe_oped_chkdiana_cli_cgo.GetString("IDEREG");
        /* If qbe_oped_chkdiana_cli_cgo->DATAOPE <  CharToDate('20100601') */
        if (CPLib.lt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20100601"))) {
          /* _raeatc := 'R' */
          _raeatc = "R";
          /* ElseIf qbe_oped_chkdiana_cli_cgo->DATAOPE >  CharToDate('20131231') */
        } else if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
          /* _raeatc := 'A' */
          _raeatc = "A";
        } else { // Else
          /* _raeatc := w_flgrae */
          _raeatc = w_flgrae;
        } // End If
        /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '1' + _idereg */
        _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"1"+_idereg;
        /* _flagrap := ' ' */
        _flagrap = " ";
        /* If not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->RAPPORTO))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"))))) {
          // * --- Select from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          if (Cursor_knarapbo!=null)
            Cursor_knarapbo.Close();
          Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select FLAGRAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_knarapbo.Eof())) {
            /* _flagrap := knarapbo->FLAGRAP */
            _flagrap = Cursor_knarapbo.GetString("FLAGRAP");
            Cursor_knarapbo.Next();
          }
          m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
          Cursor_knarapbo.Close();
          // * --- End Select
        } // End If
        /* pCodDip := qbe_oped_chkdiana_cli_cgo->CODDIPE // Codice Dipendenza */
        pCodDip = Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CODDIPE");
        /* pCodCab := qbe_oped_chkdiana_cli_cgo->CODCAB // CAB Dipendenza */
        pCodCab = Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CODCAB");
        /* pDesCit := qbe_oped_chkdiana_cli_cgo->DESCCIT // Città Dipendenza */
        pDesCit = Cursor_qbe_oped_chkdiana_cli_cgo.GetString("DESCCIT");
        /* pProv := qbe_oped_chkdiana_cli_cgo->PROVINCIA // Provincia Dipendenza */
        pProv = Cursor_qbe_oped_chkdiana_cli_cgo.GetString("PROVINCIA");
        /* Exec "Dati Agenzia" Page 6:DatiAge */
        DatiAge();
        /* _tipoag := Right(_datage,10) */
        _tipoag = CPLib.Right(_datage,10);
        /* _note := _note + Left(_datage,44) */
        _note = _note+CPLib.Left(_datage,44);
        /* _numticket := iif(LRTrim(qbe_oped_chkdiana_cli_cgo->RIFIMP)='XXXXXXXXX',LibreriaMit.SpacePad(LRTrim(qbe_oped_chkdiana_cli_cgo->INFORM),30),LibreriaMit.SpacePad(LRTrim(qbe_oped_chkdiana_cli_cgo->RIFIMP),30)) */
        _numticket = (CPLib.eqr(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RIFIMP")),"XXXXXXXXX")?LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("INFORM")),30):LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RIFIMP")),30));
        /* _note := _note + Left(DateToChar(qbe_oped_chkdiana_cli_cgo->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->FLAGCONT)+" ",1) */
        _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGCONT"))+" ",1);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->CODANA)+Space(4),4) + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->CODVOC)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->TIPOINT2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("TIPOINT2"))+CPLib.Space(2),2);
        /* _note := _note + iif(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->CODFISCICP)),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->CODINT2)+Space(11),11),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->CODFISCICP)+Space(11),11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CODFISCICP"))+CPLib.Space(11),11));
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->PAESE)+Space(3),3) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("PAESE"))+CPLib.Space(3),3);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->PROV2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("PROV2"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_oped_chkdiana_cli_cgo->DATAREG))+Space(8),8) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG")))+CPLib.Space(8),8);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->COLLEG)+Space(12),12) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("COLLEG"))+CPLib.Space(12),12);
        /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->STATOREG)+" ",1)  */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"))+" ",1);
        /* If Empty(qbe_oped_chkdiana_cli_cgo->DATARETT) or DateToChar(qbe_oped_chkdiana_cli_cgo->DATARETT)='01000101' */
        if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")),"01000101")) {
          /* _note := _note + Space(8) */
          _note = _note+CPLib.Space(8);
        } else { // Else
          /* _note := _note + Left(LRTrim(DateToChar(qbe_oped_chkdiana_cli_cgo->DATARETT))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")))+CPLib.Space(8),8);
        } // End If
        /* If Left(qbe_oped_chkdiana_cli_cgo->OPERAZMOD,1)='O' */
        if (CPLib.eqr(CPLib.Left(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("OPERAZMOD"),1),"O")) {
          /* _note := _note + iif(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->OPERAZMOD)),Space(20),qbe_oped_chkdiana_cli_cgo->OPERAZMOD) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("OPERAZMOD")))?CPLib.Space(20):Cursor_qbe_oped_chkdiana_cli_cgo.GetString("OPERAZMOD"));
        } else { // Else
          /* _note := _note + iif(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->OPERAZMOD)),Space(20),Left(qbe_oped_chkdiana_cli_cgo->OPERAZMOD,8)+"O"+Right(qbe_oped_chkdiana_cli_cgo->OPERAZMOD,11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("OPERAZMOD"),8)+"O"+CPLib.Right(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("OPERAZMOD"),11));
        } // End If
        /* _note := _note+ arfn_flaglire(qbe_oped_chkdiana_cli_cgo->FLAGLIRE,qbe_oped_chkdiana_cli_cgo->DATAOPE)  + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->VALUTA)+Space(3),3) + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->SEGNO)+" ",1) */
        _note = _note+arfn_flaglireR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGLIRE"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"))+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("SEGNO"))+" ",1);
        /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana_cli_cgo->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_oped_chkdiana_cli_cgo->TOTCONT,15,0)),15) + _numticket + Space(17)+"O"+qbe_oped_chkdiana_cli_cgo->NUMPROG+Left(LRTrim(_tipoag)+Space(10),10) */
        _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana_cli_cgo.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_oped_chkdiana_cli_cgo.GetDouble("TOTCONT"),15,0)),15)+_numticket+CPLib.Space(17)+"O"+Cursor_qbe_oped_chkdiana_cli_cgo.GetString("NUMPROG")+CPLib.Left(CPLib.LRTrim(_tipoag)+CPLib.Space(10),10);
        /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
        FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
        /* nTotRec := nTotRec + 1 */
        nTotRec = CPLib.Round(nTotRec+1,0);
        /* nTotReg := nTotReg + 1 */
        nTotReg = CPLib.Round(nTotReg+1,0);
        /* nNumRec := nNumRec + 1 */
        nNumRec = CPLib.Round(nNumRec+1,0);
        /* If not(Empty(qbe_oped_chkdiana_cli_cgo->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESCLI")))) {
          /* _oldrap := '' */
          _oldrap = "";
          /* _codrif := qbe_oped_chkdiana_cli_cgo->CONNESCLI */
          _codrif = Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESCLI");
          /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
          if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
          } else { // Else
            /* If Empty(qbe_oped_chkdiana_cli_cgo->CONNESOPER) or (qbe_oped_chkdiana_cli_cgo->CONNESOPER=qbe_oped_chkdiana_cli_cgo->CONNESCLI) */
            if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESCLI")))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
            } // End If
          } // End If
          /* _note := _note + LRTrim(arfn_datisog_sol_mc(qbe_oped_chkdiana_cli_cgo->CONNESCLI,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'2',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT,mcPersonbo,mcWersonbo)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_sol_mcR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESCLI"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT"),mcPersonbo,mcWersonbo));
          /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
          FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* If not(Empty(qbe_oped_chkdiana_cli_cgo->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO")))) {
          /* _oldrap := '' */
          _oldrap = "";
          // * --- Read from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("knarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _oldrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_cgo_chkdiana returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _oldrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_oldrap)) */
          if ( ! (CPLib.Empty(_oldrap))) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If qbe_oped_chkdiana_cli_cgo->RAPPORTO = intestbo->RAPPORTO */
              if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If intestbo->DATAINI > qbe_oped_chkdiana_cli_cgo->DATAOPE */
                if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_oped_chkdiana_cli_cgo->DATAOPE */
                if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If intestbo->CODINTER=qbe_oped_chkdiana_cli_cgo->CONNESCLI */
                if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESCLI"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza = 0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _codrif := intestbo->CODINTER */
                  _codrif = Cursor_intestbo.GetString("CODINTER");
                  /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
                  if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
                  } else { // Else
                    /* If Empty(qbe_oped_chkdiana_cli_cgo->CONNESOPER) or (qbe_oped_chkdiana_cli_cgo->CONNESOPER=intestbo->CODINTER) */
                    if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER"),Cursor_intestbo.GetString("CODINTER")))) {
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                    } else { // Else
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                    } // End If
                  } // End If
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'2',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* If Empty(LRTrim(_oldrap)) */
        if (CPLib.Empty(CPLib.LRTrim(_oldrap))) {
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_oped_chkdiana_cli_cgo->STATOREG='3' and _mlientiope */
          if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),"3") && _mlientiope) {
            /* _oldrighe := 0 */
            _oldrighe = CPLib.Round(0,0);
            // * --- Select from mlientiope
            m_cServer = m_Ctx.GetServer("mlientiope");
            m_cPhName = m_Ctx.GetPhName("mlientiope");
            if (Cursor_mlientiope!=null)
              Cursor_mlientiope.Close();
            Cursor_mlientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mlientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_mlientiope.Eof())) {
              /* _oldrighe := 1 */
              _oldrighe = CPLib.Round(1,0);
              /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
              if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
              } else { // Else
                /* If Empty(qbe_oped_chkdiana_cli_cgo->CONNESOPER) or (qbe_oped_chkdiana_cli_cgo->CONNESOPER=mlientiope->CODSOG) */
                if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER"),Cursor_mlientiope.GetString("CODSOG")))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                } else { // Else
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                } // End If
              } // End If
              /* _note := _note + LRTrim(arfn_datisog_sol(mlientiope->CODSOG,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'2',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mlientiope.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_mlientiope.Next();
            }
            m_cConnectivityError = Cursor_mlientiope.ErrorMessage();
            Cursor_mlientiope.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 and _clientiope */
          if (CPLib.eqr(_oldrighe,0) && _clientiope) {
            // * --- Select from clientiope
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            if (Cursor_clientiope!=null)
              Cursor_clientiope.Close();
            Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientiope.Eof())) {
              /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
              if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
              } else { // Else
                /* If Empty(qbe_oped_chkdiana_cli_cgo->CONNESOPER) or (qbe_oped_chkdiana_cli_cgo->CONNESOPER=clientiope->CODSOG) */
                if (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER"),Cursor_clientiope.GetString("CODSOG")))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                } else { // Else
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                } // End If
              } // End If
              /* _note := _note + LRTrim(arfn_datisog_sol(clientiope->CODSOG,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'2',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_clientiope.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_clientiope.Next();
            }
            m_cConnectivityError = Cursor_clientiope.ErrorMessage();
            Cursor_clientiope.Close();
            // * --- End Select
          } // End If
        } // End If
        /* If not(Empty(qbe_oped_chkdiana_cli_cgo->CONNESOPER)) and qbe_oped_chkdiana_cli_cgo->CONNESOPER <> _codrif */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER"),_codrif)) {
          /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
          if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '8' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
          } else { // Else
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '4' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"4"+_idereg;
          } // End If
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana_cli_cgo->CONNESOPER,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'4',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"4",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
          /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
          FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_oped_chkdiana_cli_cgo->STATOREG='3' and _mogopebo */
        if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),"3") && _mogopebo) {
          // * --- Select from mogopebo
          m_cServer = m_Ctx.GetServer("mogopebo");
          m_cPhName = m_Ctx.GetPhName("mogopebo");
          if (Cursor_mogopebo!=null)
            Cursor_mogopebo.Close();
          Cursor_mogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_mogopebo.Eof())) {
            /* _oldrighe := 1 */
            _oldrighe = CPLib.Round(1,0);
            /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '8' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '4' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"4"+_idereg;
            } // End If
            /* _note := _note + LRTrim(arfn_datisog_sol(mogopebo->CODSOG,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'4',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mogopebo.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"4",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_mogopebo.Next();
          }
          m_cConnectivityError = Cursor_mogopebo.ErrorMessage();
          Cursor_mogopebo.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 and _sogopebo */
        if (CPLib.eqr(_oldrighe,0) && _sogopebo) {
          // * --- Select from sogopebo
          m_cServer = m_Ctx.GetServer("sogopebo");
          m_cPhName = m_Ctx.GetPhName("sogopebo");
          if (Cursor_sogopebo!=null)
            Cursor_sogopebo.Close();
          Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopebo.Eof())) {
            /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '8' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '4' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"4"+_idereg;
            } // End If
            /* _note := _note + LRTrim(arfn_datisog_sol(sogopebo->CODSOG,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'4',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_sogopebo.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"4",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_sogopebo.Next();
          }
          m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
          Cursor_sogopebo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_oped_chkdiana_cli_cgo->CONNESBEN)) or not(Empty(qbe_oped_chkdiana_cli_cgo->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAG")))) {
          /* If not(Empty(qbe_oped_chkdiana_cli_cgo->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAG")))) {
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->CONNESBEN)+Space(16),16) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESBEN"))+CPLib.Space(16),16);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->C_RAG,' '))+Space(70),70) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAG")," "))+CPLib.Space(70),70);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_STA)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_STA"))+CPLib.Space(3),3);
            /* _note := _note +Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAB)+Space(6),6) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAB"))+CPLib.Space(6),6);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->C_CTA,' '))+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CTA")," "))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_PRV)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_PRV"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->C_IND,' '))+Space(35),35) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_IND")," "))+CPLib.Space(35),35);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAP)+Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAP"))+CPLib.Space(5),5);
            /* _note := _note + Space(63) */
            _note = _note+CPLib.Space(63);
            /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Space(91) */
            _note = _note+CPLib.Space(91);
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* ElseIf not(Empty(qbe_oped_chkdiana_cli_cgo->CONNESBEN)) */
          } else if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESBEN")))) {
            /* _numsto := arfn_chkspers(qbe_oped_chkdiana_cli_cgo->CONNESBEN,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE)) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESBEN"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_RAG))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_STA))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAB))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CTA))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_PRV))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_IND))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAP))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_RAPPORTO))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
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
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_oped_chkdiana_cli_cgo->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_RAG))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_STA))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAB))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CTA))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_PRV))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_IND))),Left(LRTrim(arfn_agechar(qbe_oped_chkdiana_cli_cgo->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAP))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_oped_chkdiana_cli_cgo->C_RAPPORTO))),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_oped_chkdiana_cli_cgo->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_oped_chkdiana_cli_cgo->STATOREG='3' and _meneficope */
        if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),"3") && _meneficope) {
          // * --- Select from meneficope
          m_cServer = m_Ctx.GetServer("meneficope");
          m_cPhName = m_Ctx.GetPhName("meneficope");
          if (Cursor_meneficope!=null)
            Cursor_meneficope.Close();
          Cursor_meneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("meneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_meneficope.Eof())) {
            /* _oldrighe := 1 */
            _oldrighe = CPLib.Round(1,0);
            /* If Empty(LRTrim(meneficope->CODSOG)) and not(Empty(LRTrim(meneficope->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
              /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(meneficope->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(meneficope->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(meneficope->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(meneficope->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* If meneficope->CODSOG <> qbe_oped_chkdiana_cli_cgo->CONNESBEN */
              if (CPLib.ne(Cursor_meneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESBEN"))) {
                /* _numsto := arfn_chkspers(meneficope->CODSOG,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE)) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_meneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_RAG))),Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_STA))),Left(LRTrim(meneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAB))),Left(LRTrim(meneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CTA))),Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_PRV))),Left(LRTrim(meneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_IND))),Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAP))),Left(LRTrim(meneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
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
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(meneficope->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_RAG))),Left(LRTrim(arfn_agechar(meneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_STA))),Left(LRTrim(meneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAB))),Left(LRTrim(meneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CTA))),Left(LRTrim(arfn_agechar(meneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_PRV))),Left(LRTrim(meneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_IND))),Left(LRTrim(arfn_agechar(meneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficope->C_CAP))),Left(LRTrim(meneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(meneficope->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
            } // End If
            Cursor_meneficope.Next();
          }
          m_cConnectivityError = Cursor_meneficope.ErrorMessage();
          Cursor_meneficope.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 and _beneficope */
        if (CPLib.eqr(_oldrighe,0) && _beneficope) {
          // * --- Select from beneficope
          m_cServer = m_Ctx.GetServer("beneficope");
          m_cPhName = m_Ctx.GetPhName("beneficope");
          if (Cursor_beneficope!=null)
            Cursor_beneficope.Close();
          Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficope.Eof())) {
            /* If Empty(LRTrim(beneficope->CODSOG)) and not(Empty(LRTrim(beneficope->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
              /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(beneficope->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(beneficope->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(beneficope->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(beneficope->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* If beneficope->CODSOG <> qbe_oped_chkdiana_cli_cgo->CONNESBEN */
              if (CPLib.ne(Cursor_beneficope.GetString("CODSOG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESBEN"))) {
                /* _numsto := arfn_chkspers(beneficope->CODSOG,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE)) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_RAG))),Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_STA))),Left(LRTrim(beneficope->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAB))),Left(LRTrim(beneficope->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CTA))),Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_PRV))),Left(LRTrim(beneficope->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_IND))),Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAP))),Left(LRTrim(beneficope->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
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
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(beneficope->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_RAG))),Left(LRTrim(arfn_agechar(beneficope->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_STA))),Left(LRTrim(beneficope->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAB))),Left(LRTrim(beneficope->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CTA))),Left(LRTrim(arfn_agechar(beneficope->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_PRV))),Left(LRTrim(beneficope->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_IND))),Left(LRTrim(arfn_agechar(beneficope->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficope.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficope->C_CAP))),Left(LRTrim(beneficope->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(beneficope->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficope.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
            } // End If
            Cursor_beneficope.Next();
          }
          m_cConnectivityError = Cursor_beneficope.ErrorMessage();
          Cursor_beneficope.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_oped_chkdiana_cli_cgo->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNALTRO")))) {
          /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
          if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '9' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana_cli_cgo->CONNALTRO,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'9',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNALTRO"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
          } else { // Else
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '6' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_oped_chkdiana_cli_cgo->CONNALTRO,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'6',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNALTRO"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
          } // End If
          /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
          FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_oped_chkdiana_cli_cgo->STATOREG='3' and _merzistiope */
        if (CPLib.eqr(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),"3") && _merzistiope) {
          // * --- Select from merzistiope
          m_cServer = m_Ctx.GetServer("merzistiope");
          m_cPhName = m_Ctx.GetPhName("merzistiope");
          if (Cursor_merzistiope!=null)
            Cursor_merzistiope.Close();
          Cursor_merzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("merzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_merzistiope.Eof())) {
            /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '9' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '6' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
            } // End If
            /* _note := _note + LRTrim(arfn_datisog_sol(merzistiope->CODSOG,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'6',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_merzistiope.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_merzistiope.Next();
          }
          m_cConnectivityError = Cursor_merzistiope.ErrorMessage();
          Cursor_merzistiope.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 and _terzistiope */
        if (CPLib.eqr(_oldrighe,0) && _terzistiope) {
          // * --- Select from terzistiope
          m_cServer = m_Ctx.GetServer("terzistiope");
          m_cPhName = m_Ctx.GetPhName("terzistiope");
          if (Cursor_terzistiope!=null)
            Cursor_terzistiope.Close();
          Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_oped_chkdiana_cli_cgo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistiope.Eof())) {
            /* If qbe_oped_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '9' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(terzistiope->CODSOG,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'9',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistiope.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '6' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(terzistiope->CODSOG,iif(w_stoper='R',qbe_oped_chkdiana_cli_cgo->DATAREG,qbe_oped_chkdiana_cli_cgo->DATAOPE),qbe_oped_chkdiana_cli_cgo->RAPPORTO,qbe_oped_chkdiana_cli_cgo->FLAGRAP,'6',_raeatc,qbe_oped_chkdiana_cli_cgo->STATOREG,qbe_oped_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistiope.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_oped_chkdiana_cli_cgo.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_oped_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_oped_chkdiana_cli_cgo.GetDate("DATARETT")));
            } // End If
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_terzistiope.Next();
          }
          m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
          Cursor_terzistiope.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_oped_chkdiana_cli_cgo.Next();
      }
      m_cConnectivityError = Cursor_qbe_oped_chkdiana_cli_cgo.ErrorMessage();
      Cursor_qbe_oped_chkdiana_cli_cgo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_oped_chkdiana_cli_cgo!=null)
          Cursor_qbe_oped_chkdiana_cli_cgo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_knarapbo!=null)
          Cursor_knarapbo.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
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
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
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
        if (Cursor_meneficope!=null)
          Cursor_meneficope.Close();
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
        if (Cursor_merzistiope!=null)
          Cursor_merzistiope.Close();
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
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_rapd_chkdiana_cli=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_fiduciabo=null;
    CPResultSet Cursor_delegabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle informazioni sui rapporti */
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      // * --- Select from qbe_rapd_chkdiana_cli
      SPBridge.HMCaller _h00000257;
      _h00000257 = new SPBridge.HMCaller();
      _h00000257.Set("m_cVQRList",m_cVQRList);
      _h00000257.Set("cdadata_rap",w_cdadata_rap);
      _h00000257.Set("c_adata_rap",w_c_adata_rap);
      _h00000257.Set("cdareg",w_cdareg_rap);
      _h00000257.Set("c_areg",w_c_areg_rap);
      _h00000257.Set("codcli",w_codcli);
      if (Cursor_qbe_rapd_chkdiana_cli!=null)
        Cursor_qbe_rapd_chkdiana_cli.Close();
      Cursor_qbe_rapd_chkdiana_cli = new VQRHolder("qbe_rapd_chkdiana_cli",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000257,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_rapd_chkdiana_cli.Eof())) {
        /* f_tot := f_tot+1 // contatore delle operazioni frazionate inserite */
        f_tot = CPLib.Round(f_tot+1,0);
        /* _continua := 0 */
        _continua = CPLib.Round(0,0);
        /* If qbe_rapd_chkdiana_cli->DATAOPE <  CharToDate('20100601') */
        if (CPLib.lt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20100601"))) {
          /* _raeatc := 'R' */
          _raeatc = "R";
          /* ElseIf qbe_rapd_chkdiana_cli->DATAOPE >  CharToDate('20131231') */
        } else if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
          /* _raeatc := 'A' */
          _raeatc = "A";
        } else { // Else
          /* _raeatc := w_flgrae */
          _raeatc = w_flgrae;
        } // End If
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* gMsgImp := 'Elaborazione Informazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
        gMsgImp = "Elaborazione Informazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _idereg := arfn_calc_idereg("I",qbe_rapd_chkdiana_cli->NUMPROG,qbe_rapd_chkdiana_cli->IDEREG) */
        _idereg = arfn_calc_ideregR.Make(m_Ctx,this).Run("I",Cursor_qbe_rapd_chkdiana_cli.GetString("NUMPROG"),Cursor_qbe_rapd_chkdiana_cli.GetString("IDEREG"));
        /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '1' + _idereg */
        _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"1"+_idereg;
        /* _flagrap := '' */
        _flagrap = "";
        /* If not(Empty(LRTrim(qbe_rapd_chkdiana_cli->RAPPORTO))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"))))) {
          // * --- Select from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          if (Cursor_knarapbo!=null)
            Cursor_knarapbo.Close();
          Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select FLAGRAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_knarapbo.Eof())) {
            /* _flagrap := knarapbo->FLAGRAP */
            _flagrap = Cursor_knarapbo.GetString("FLAGRAP");
            Cursor_knarapbo.Next();
          }
          m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
          Cursor_knarapbo.Close();
          // * --- End Select
        } // End If
        /* pCodDip := qbe_rapd_chkdiana_cli->CODDIPE // Codice Dipendenza */
        pCodDip = Cursor_qbe_rapd_chkdiana_cli.GetString("CODDIPE");
        /* pCodCab := qbe_rapd_chkdiana_cli->CODCAB // CAB Dipendenza */
        pCodCab = Cursor_qbe_rapd_chkdiana_cli.GetString("CODCAB");
        /* pDesCit := qbe_rapd_chkdiana_cli->DESCCIT // Città Dipendenza */
        pDesCit = Cursor_qbe_rapd_chkdiana_cli.GetString("DESCCIT");
        /* pProv := qbe_rapd_chkdiana_cli->PROVINCIA // Provincia Dipendenza */
        pProv = Cursor_qbe_rapd_chkdiana_cli.GetString("PROVINCIA");
        /* Exec "Dati Agenzia" Page 6:DatiAge */
        DatiAge();
        /* _tipoag := Right(_datage,10) */
        _tipoag = CPLib.Right(_datage,10);
        /* _note := _note + Left(_datage,44) */
        _note = _note+CPLib.Left(_datage,44);
        /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana_cli->DATAOPE))+Space(8),8) + Left(LRTrim(qbe_rapd_chkdiana_cli->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_rapd_chkdiana_cli->FLAGCONT)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGCONT"))+" ",1);
        /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana_cli->CODANA)+Space(4),4) + Left(LRTrim(qbe_rapd_chkdiana_cli->CODVOC)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana_cli->TIPOINT2)+Space(2),2) + Left(LRTrim(qbe_rapd_chkdiana_cli->CODINT2)+Space(11),11) + Left(LRTrim(qbe_rapd_chkdiana_cli->PAESE)+Space(3),3) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOINT2"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("CODINT2"))+CPLib.Space(11),11)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("PAESE"))+CPLib.Space(3),3);
        /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana_cli->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_rapd_chkdiana_cli->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_rapd_chkdiana_cli->PROV2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana_cli.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("PROV2"))+CPLib.Space(2),2);
        /* _note := _note + Space(50) + Left(LRTrim(arfn_agechar(qbe_rapd_chkdiana_cli->RAPPORTO," "))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
        _note = _note+CPLib.Space(50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
        /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana_cli->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_rapd_chkdiana_cli->DATAREG))+Space(8),8) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG")))+CPLib.Space(8),8);
        /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana_cli->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_rapd_chkdiana_cli->COLLEG)+Space(12),12) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("COLLEG"))+CPLib.Space(12),12);
        /* _note := _note + Left(LRTrim(qbe_rapd_chkdiana_cli->STATOREG)+" ",1)  */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"))+" ",1);
        /* If Empty(qbe_rapd_chkdiana_cli->DATARETT) or DateToChar(qbe_rapd_chkdiana_cli->DATARETT)='01000101' */
        if (CPLib.Empty(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")),"01000101")) {
          /* _note := _note + Space(8) */
          _note = _note+CPLib.Space(8);
        } else { // Else
          /* _note := _note + Left(LRTrim(DateToChar(qbe_rapd_chkdiana_cli->DATARETT))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")))+CPLib.Space(8),8);
        } // End If
        /* If Left(qbe_rapd_chkdiana_cli->OPERAZMOD,1)='I' */
        if (CPLib.eqr(CPLib.Left(Cursor_qbe_rapd_chkdiana_cli.GetString("OPERAZMOD"),1),"I")) {
          /* _note := _note + iif(Empty(LRTrim(qbe_rapd_chkdiana_cli->OPERAZMOD)),Space(20),qbe_rapd_chkdiana_cli->OPERAZMOD) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("OPERAZMOD")))?CPLib.Space(20):Cursor_qbe_rapd_chkdiana_cli.GetString("OPERAZMOD"));
        } else { // Else
          /* _note := _note + iif(Empty(LRTrim(qbe_rapd_chkdiana_cli->OPERAZMOD)),Space(20),Left(qbe_rapd_chkdiana_cli->OPERAZMOD,8)+"I"+Right(qbe_rapd_chkdiana_cli->OPERAZMOD,11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_rapd_chkdiana_cli.GetString("OPERAZMOD"),8)+"I"+CPLib.Right(Cursor_qbe_rapd_chkdiana_cli.GetString("OPERAZMOD"),11));
        } // End If
        /* _note := _note + arfn_flaglire(qbe_rapd_chkdiana_cli->RAPLIRE,qbe_rapd_chkdiana_cli->DATAOPE) + Left(LRTrim(qbe_rapd_chkdiana_cli->RAPVALUTA)+Space(3),3) + Left(LRTrim(qbe_rapd_chkdiana_cli->SEGNO)+" ",1) */
        _note = _note+arfn_flaglireR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPLIRE"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"))+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPVALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_rapd_chkdiana_cli.GetString("SEGNO"))+" ",1);
        /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_rapd_chkdiana_cli->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_rapd_chkdiana_cli->TOTCONT,15,0)),15) + Space(47)+"I"+qbe_rapd_chkdiana_cli->NUMPROG+Left(LRTrim(_tipoag)+Space(10),10) */
        _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapd_chkdiana_cli.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_rapd_chkdiana_cli.GetDouble("TOTCONT"),15,0)),15)+CPLib.Space(47)+"I"+Cursor_qbe_rapd_chkdiana_cli.GetString("NUMPROG")+CPLib.Left(CPLib.LRTrim(_tipoag)+CPLib.Space(10),10);
        /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
        FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
        /* nTotRec := nTotRec + 1 */
        nTotRec = CPLib.Round(nTotRec+1,0);
        /* nTotReg := nTotReg + 1 */
        nTotReg = CPLib.Round(nTotReg+1,0);
        /* nNumRec := nNumRec + 1 */
        nNumRec = CPLib.Round(nNumRec+1,0);
        /* Case Right(qbe_rapd_chkdiana_cli->TIPOOPRAP,1)='6' or qbe_rapd_chkdiana_cli->TIPOOPRAP='38' */
        if (CPLib.eqr(CPLib.Right(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),1),"6") || CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),"38")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG2="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(intestbo->CODINTER) */
            if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20131231') */
              if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                /* _tiprec := '7' */
                _tiprec = "7";
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'7'+_idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
              } else { // Else
                /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20100531') and qbe_rapd_chkdiana_cli->DATAOPE < CharToDate('20140101') */
                if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20100531")) && CPLib.lt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
                  /* _tiprec := '2' */
                  _tiprec = "2";
                } else { // Else
                  /* If Empty(qbe_rapd_chkdiana_cli->CONNESOPER) or (qbe_rapd_chkdiana_cli->CONNESOPER=intestbo->CODINTER) */
                  if (CPLib.Empty(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER"),Cursor_intestbo.GetString("CODINTER")))) {
                    /* _tiprec := '2' */
                    _tiprec = "2";
                  } else { // Else
                    /* _tiprec := '3' */
                    _tiprec = "3";
                  } // End If
                } // End If
              } // End If
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + _tiprec + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol_mc(intestbo->CODINTER,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT,mcPersonbo,mcWersonbo)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_sol_mcR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT"),mcPersonbo,mcWersonbo));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          /* If not(Empty(qbe_rapd_chkdiana_cli->CONNESOPER)) */
          if ( ! (CPLib.Empty(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER")))) {
            /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _tiprec := '8' */
              _tiprec = "8";
            } else { // Else
              /* _tiprec := '4' */
              _tiprec = "4";
            } // End If
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_rapd_chkdiana_cli->CONNESOPER,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")));
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          // * --- Select from fiduciabo
          m_cServer = m_Ctx.GetServer("fiduciabo");
          m_cPhName = m_Ctx.GetPhName("fiduciabo");
          if (Cursor_fiduciabo!=null)
            Cursor_fiduciabo.Close();
          Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_fiduciabo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(fiduciabo->CODSOG) */
            if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'9'+_idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(fiduciabo->CODSOG,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,'9',_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
            Cursor_fiduciabo.Next();
          }
          m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
          Cursor_fiduciabo.Close();
          // * --- End Select
          /* Case qbe_rapd_chkdiana_cli->TIPOOPRAP='31' or qbe_rapd_chkdiana_cli->TIPOOPRAP='32' */
        } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),"31") || CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),"32")) {
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(intestbo->CODINTER) */
            if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20131231') */
              if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                /* _tiprec := '7' */
                _tiprec = "7";
              } else { // Else
                /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20100531') and qbe_rapd_chkdiana_cli->DATAOPE < CharToDate('20140101') */
                if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20100531")) && CPLib.lt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
                  /* _tiprec := '2' */
                  _tiprec = "2";
                } else { // Else
                  /* If Empty(qbe_rapd_chkdiana_cli->CONNESOPER) or (qbe_rapd_chkdiana_cli->CONNESOPER=intestbo->CODINTER) */
                  if (CPLib.Empty(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER"),Cursor_intestbo.GetString("CODINTER")))) {
                    /* _tiprec := '2' */
                    _tiprec = "2";
                  } else { // Else
                    /* _tiprec := '3' */
                    _tiprec = "3";
                  } // End If
                } // End If
              } // End If
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
              /* If qbe_rapd_chkdiana_cli->TIPOOPRAP='31' */
              if (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),"31")) {
                /* _note := _note + LRTrim(arfn_datisog_sol_mc(intestbo->CODINTER,arfn_dateminus(iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),1),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT,mcPersonbo,mcWersonbo)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_sol_mcR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run((CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),1),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT"),mcPersonbo,mcWersonbo));
                /* ElseIf qbe_rapd_chkdiana_cli->TIPOOPRAP='32' */
              } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),"32")) {
                /* _note := _note + LRTrim(arfn_datisog_sol_mc(intestbo->CODINTER,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT,mcPersonbo,mcWersonbo)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_sol_mcR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT"),mcPersonbo,mcWersonbo));
              } // End If
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          /* If w_flgdel='S' */
          if (CPLib.eqr(w_flgdel,"S")) {
            // * --- Select from delegabo
            m_cServer = m_Ctx.GetServer("delegabo");
            m_cPhName = m_Ctx.GetPhName("delegabo");
            if (Cursor_delegabo!=null)
              Cursor_delegabo.Close();
            Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+"  and  DATAINI <= "+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_delegabo.Eof())) {
              /* If Empty(delegabo->DATAFINE) or delegabo->DATAFINE >= qbe_rapd_chkdiana_cli->DATAOPE */
              if (CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE")) || CPLib.ge(Cursor_delegabo.GetDate("DATAFINE"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"))) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(delegabo->CODINTER) */
                if (CPLib.Empty(Cursor_delegabo.GetString("CODINTER"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza=0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20131231') */
                  if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                    /* _tiprec := '8' */
                    _tiprec = "8";
                  } else { // Else
                    /* _tiprec := '4' */
                    _tiprec = "4";
                  } // End If
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
                  /* If qbe_rapd_chkdiana_cli->TIPOOPRAP='31' */
                  if (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),"31")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,arfn_dateminus(iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),1),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),arfn_dateminusR.Make(m_Ctx,this).Run((CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),1),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")));
                    /* ElseIf qbe_rapd_chkdiana_cli->TIPOOPRAP='32' */
                  } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),"32")) {
                    /* _note := _note + LRTrim(arfn_datisog_sol(delegabo->CODINTER,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT)) */
                    _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")));
                  } // End If
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
              } // End If
              Cursor_delegabo.Next();
            }
            m_cConnectivityError = Cursor_delegabo.ErrorMessage();
            Cursor_delegabo.Close();
            // * --- End Select
          } // End If
          /* If not(Empty(qbe_rapd_chkdiana_cli->CONNESOPER)) */
          if ( ! (CPLib.Empty(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER")))) {
            /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _tiprec := '8' */
              _tiprec = "8";
            } else { // Else
              /* _tiprec := '4' */
              _tiprec = "4";
            } // End If
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_rapd_chkdiana_cli->CONNESOPER,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")));
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          // * --- Select from fiduciabo
          m_cServer = m_Ctx.GetServer("fiduciabo");
          m_cPhName = m_Ctx.GetPhName("fiduciabo");
          if (Cursor_fiduciabo!=null)
            Cursor_fiduciabo.Close();
          Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_fiduciabo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(fiduciabo->CODSOG) */
            if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'9'+_idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
              /* If qbe_rapd_chkdiana_cli->TIPOOPRAP='31' */
              if (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),"31")) {
                /* _note := _note + LRTrim(arfn_datisog_sol(fiduciabo->CODSOG,arfn_dateminus(iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),1),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,'9',_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),arfn_dateminusR.Make(m_Ctx,this).Run((CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),1),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")));
                /* ElseIf qbe_rapd_chkdiana_cli->TIPOOPRAP='32' */
              } else if (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("TIPOOPRAP"),"32")) {
                /* _note := _note + LRTrim(arfn_datisog_sol(fiduciabo->CODSOG,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,'9',_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT)) */
                _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")));
              } // End If
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
            Cursor_fiduciabo.Next();
          }
          m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
          Cursor_fiduciabo.Close();
          // * --- End Select
        } else { // Otherwise
          // * --- Select from intestbo
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          if (Cursor_intestbo!=null)
            Cursor_intestbo.Close();
          Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+"  and  NUMPROG1="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("NUMPROG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestbo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(intestbo->CODINTER) */
            if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20131231') */
              if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                /* _tiprec := '7' */
                _tiprec = "7";
              } else { // Else
                /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20100531') and qbe_rapd_chkdiana_cli->DATAOPE < CharToDate('20140101') */
                if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20100531")) && CPLib.lt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20140101"))) {
                  /* _tiprec := '2' */
                  _tiprec = "2";
                } else { // Else
                  /* If Empty(qbe_rapd_chkdiana_cli->CONNESOPER) or (qbe_rapd_chkdiana_cli->CONNESOPER=intestbo->CODINTER) */
                  if (CPLib.Empty(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER"),Cursor_intestbo.GetString("CODINTER")))) {
                    /* _tiprec := '2' */
                    _tiprec = "2";
                  } else { // Else
                    /* _tiprec := '3' */
                    _tiprec = "3";
                  } // End If
                } // End If
              } // End If
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol_mc(intestbo->CODINTER,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT,mcPersonbo,mcWersonbo)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_sol_mcR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT"),mcPersonbo,mcWersonbo));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
            Cursor_intestbo.Next();
          }
          m_cConnectivityError = Cursor_intestbo.ErrorMessage();
          Cursor_intestbo.Close();
          // * --- End Select
          /* If not(Empty(qbe_rapd_chkdiana_cli->CONNESOPER)) */
          if ( ! (CPLib.Empty(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER")))) {
            /* If qbe_rapd_chkdiana_cli->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _tiprec := '8' */
              _tiprec = "8";
            } else { // Else
              /* _tiprec := '4' */
              _tiprec = "4";
            } // End If
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+_tiprec+_idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+_tiprec+_idereg;
            /* _note := _note + LRTrim(arfn_datisog_sol(qbe_rapd_chkdiana_cli->CONNESOPER,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,_tiprec,_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_rapd_chkdiana_cli.GetString("CONNESOPER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),_tiprec,_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")));
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
          } // End If
          // * --- Select from fiduciabo
          m_cServer = m_Ctx.GetServer("fiduciabo");
          m_cPhName = m_Ctx.GetPhName("fiduciabo");
          if (Cursor_fiduciabo!=null)
            Cursor_fiduciabo.Close();
          Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPLib.ToSQL(Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_fiduciabo.Eof())) {
            /* _avanza := 0 */
            _avanza = CPLib.Round(0,0);
            /* If Empty(fiduciabo->CODSOG) */
            if (CPLib.Empty(Cursor_fiduciabo.GetString("CODSOG"))) {
              /* _avanza := 1 */
              _avanza = CPLib.Round(1,0);
            } // End If
            /* If _avanza=0 */
            if (CPLib.eqr(_avanza,0)) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'9'+_idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(fiduciabo->CODSOG,iif(w_stoper='R',qbe_rapd_chkdiana_cli->DATAREG,qbe_rapd_chkdiana_cli->DATAOPE),qbe_rapd_chkdiana_cli->RAPPORTO,qbe_rapd_chkdiana_cli->FLAGRAP,'9',_raeatc,qbe_rapd_chkdiana_cli->STATOREG,qbe_rapd_chkdiana_cli->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_fiduciabo.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_rapd_chkdiana_cli.GetDate("DATAOPE")),Cursor_qbe_rapd_chkdiana_cli.GetString("RAPPORTO"),Cursor_qbe_rapd_chkdiana_cli.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_rapd_chkdiana_cli.GetString("STATOREG"),Cursor_qbe_rapd_chkdiana_cli.GetDate("DATARETT")));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } // End If
            Cursor_fiduciabo.Next();
          }
          m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
          Cursor_fiduciabo.Close();
          // * --- End Select
        } // End Case
        Cursor_qbe_rapd_chkdiana_cli.Next();
      }
      m_cConnectivityError = Cursor_qbe_rapd_chkdiana_cli.ErrorMessage();
      Cursor_qbe_rapd_chkdiana_cli.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_rapd_chkdiana_cli!=null)
          Cursor_qbe_rapd_chkdiana_cli.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_knarapbo!=null)
          Cursor_knarapbo.Close();
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
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_frad_chkdiana_cli_cgo=null;
    CPResultSet Cursor_knarapbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_mlientifrz=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_mogopefbo=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_meneficfrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_merzistifrz=null;
    CPResultSet Cursor_terzistifrz=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle frazionate di uno specifico cliente */
      /* If pTipo='D' */
      if (CPLib.eqr(pTipo,"D")) {
        /* gMsgImp := 'Verifica Frazionate del cliente da elaborare ...' // Messaggio Import */
        gMsgImp = "Verifica Frazionate del cliente da elaborare ...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      // * --- Select from qbe_frad_chkdiana_cli_cgo
      SPBridge.HMCaller _h00000309;
      _h00000309 = new SPBridge.HMCaller();
      _h00000309.Set("m_cVQRList",m_cVQRList);
      _h00000309.Set("cdadata",w_cdadata);
      _h00000309.Set("c_adata",w_c_adata);
      _h00000309.Set("codage",w_codage);
      _h00000309.Set("codcli",w_codcli);
      _h00000309.Set("ragben",w_ragben);
      _h00000309.Set("cdareg",w_cdareg);
      _h00000309.Set("c_areg",w_c_areg);
      if (Cursor_qbe_frad_chkdiana_cli_cgo!=null)
        Cursor_qbe_frad_chkdiana_cli_cgo.Close();
      Cursor_qbe_frad_chkdiana_cli_cgo = new VQRHolder("qbe_frad_chkdiana_cli_cgo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000309,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_frad_chkdiana_cli_cgo.Eof())) {
        /* i_tot := i_tot+1 // contatore informazioni inserite */
        i_tot = CPLib.Round(i_tot+1,0);
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* If pTipo='D' */
        if (CPLib.eqr(pTipo,"D")) {
          /* gMsgImp := 'Elaborazione Frazionata N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Frazionata N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _idereg := arfn_calc_idereg("F",qbe_frad_chkdiana_cli_cgo->NUMPROG,qbe_frad_chkdiana_cli_cgo->IDEREG) */
        _idereg = arfn_calc_ideregR.Make(m_Ctx,this).Run("F",Cursor_qbe_frad_chkdiana_cli_cgo.GetString("NUMPROG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDEREG"));
        /* If qbe_frad_chkdiana_cli_cgo->DATAOPE <  CharToDate('20100601') */
        if (CPLib.lt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20100601"))) {
          /* _raeatc := 'R' */
          _raeatc = "R";
          /* ElseIf qbe_frad_chkdiana_cli_cgo->DATAOPE >  CharToDate('20131231') */
        } else if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
          /* _raeatc := 'A' */
          _raeatc = "A";
        } else { // Else
          /* _raeatc := w_flgrae */
          _raeatc = w_flgrae;
        } // End If
        /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '1' + _idereg */
        _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"1"+_idereg;
        /* _flagrap := '' */
        _flagrap = "";
        /* If not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->RAPPORTO))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"))))) {
          // * --- Select from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          if (Cursor_knarapbo!=null)
            Cursor_knarapbo.Close();
          Cursor_knarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select FLAGRAP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("knarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_knarapbo.Eof())) {
            /* _flagrap := knarapbo->FLAGRAP */
            _flagrap = Cursor_knarapbo.GetString("FLAGRAP");
            Cursor_knarapbo.Next();
          }
          m_cConnectivityError = Cursor_knarapbo.ErrorMessage();
          Cursor_knarapbo.Close();
          // * --- End Select
        } // End If
        /* _datage := arfn_datidip_sol(qbe_frad_chkdiana_cli_cgo->CODDIPE,qbe_frad_chkdiana_cli_cgo->CODCAB,qbe_frad_chkdiana_cli_cgo->DESCCIT,qbe_frad_chkdiana_cli_cgo->PROVINCIA) */
        _datage = arfn_datidip_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CODDIPE"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CODCAB"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("DESCCIT"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("PROVINCIA"));
        /* _tipoag := Right(_datage,10) */
        _tipoag = CPLib.Right(_datage,10);
        /* _note := _note + Left(_datage,44) */
        _note = _note+CPLib.Left(_datage,44);
        /* _numticket := iif(LRTrim(qbe_frad_chkdiana_cli_cgo->RIFIMP)='XXXXXXXXX',LibreriaMit.SpacePad(LRTrim(qbe_frad_chkdiana_cli_cgo->INFORM),30),LibreriaMit.SpacePad(LRTrim(qbe_frad_chkdiana_cli_cgo->RIFIMP),30)) */
        _numticket = (CPLib.eqr(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RIFIMP")),"XXXXXXXXX")?LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("INFORM")),30):LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RIFIMP")),30));
        /* _note := _note + Left(DateToChar(qbe_frad_chkdiana_cli_cgo->DATAOPE)+Space(8),8) + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->FLAGFRAZ)+" ",1) + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->FLAGCONT)+" ",1) */
        _note = _note+CPLib.Left(CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"))+CPLib.Space(8),8)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGFRAZ"))+" ",1)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGCONT"))+" ",1);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->CODANA)+Space(4),4) + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->CODVOC)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CODANA"))+CPLib.Space(4),4)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CODVOC"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->TIPOINT2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("TIPOINT2"))+CPLib.Space(2),2);
        /* _note := _note + iif(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->CODFISCICP)),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->CODINT2)+Space(11),11),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->CODFISCICP)+Space(11),11)) */
        _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CODFISCICP")))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CODINT2"))+CPLib.Space(11),11):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CODFISCICP"))+CPLib.Space(11),11));
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->PAESE)+Space(3),3) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("PAESE"))+CPLib.Space(3),3);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->CODCAB2)+Space(6),6) + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->DESC2,' '))+Space(30),30) + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->PROV2)+Space(2),2) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CODCAB2"))+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("DESC2")," "))+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("PROV2"))+CPLib.Space(2),2);
        /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->DESCINTER,' '))+Space(50),50) + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->RAPPORTO,' '))+Space(25),25) + Left(LRTrim(_flagrap)+" ",1) */
        _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("DESCINTER")," "))+CPLib.Space(50),50)+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO")," "))+CPLib.Space(25),25)+CPLib.Left(CPLib.LRTrim(_flagrap)+" ",1);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->TIPOLEG)+" ",1) + Left(LRTrim(DateToChar(qbe_frad_chkdiana_cli_cgo->DATAREG))+Space(8),8) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("TIPOLEG"))+" ",1)+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG")))+CPLib.Space(8),8);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->TIPOOPRAP)+Space(2),2) + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->COLLEG)+Space(12),12) */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("TIPOOPRAP"))+CPLib.Space(2),2)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("COLLEG"))+CPLib.Space(12),12);
        /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->STATOREG)+" ",1)  */
        _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"))+" ",1);
        /* If Empty(qbe_frad_chkdiana_cli_cgo->DATARETT) or DateToChar(qbe_frad_chkdiana_cli_cgo->DATARETT)='01000101' */
        if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")) || CPLib.eqr(CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")),"01000101")) {
          /* _note := _note + Space(8) */
          _note = _note+CPLib.Space(8);
        } else { // Else
          /* _note := _note + Left(LRTrim(DateToChar(qbe_frad_chkdiana_cli_cgo->DATARETT))+Space(8),8) */
          _note = _note+CPLib.Left(CPLib.LRTrim(CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")))+CPLib.Space(8),8);
        } // End If
        /* If Left(qbe_frad_chkdiana_cli_cgo->OPERAZMOD,1)='F' */
        if (CPLib.eqr(CPLib.Left(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("OPERAZMOD"),1),"F")) {
          /* _note := _note + iif(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->OPERAZMOD)),Space(20),qbe_frad_chkdiana_cli_cgo->OPERAZMOD) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("OPERAZMOD")))?CPLib.Space(20):Cursor_qbe_frad_chkdiana_cli_cgo.GetString("OPERAZMOD"));
        } else { // Else
          /* _note := _note + iif(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->OPERAZMOD)),Space(20),Left(qbe_frad_chkdiana_cli_cgo->OPERAZMOD,8)+"F"+Right(qbe_frad_chkdiana_cli_cgo->OPERAZMOD,11)) */
          _note = _note+(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("OPERAZMOD")))?CPLib.Space(20):CPLib.Left(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("OPERAZMOD"),8)+"F"+CPLib.Right(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("OPERAZMOD"),11));
        } // End If
        /* _note := _note + arfn_flaglire(qbe_frad_chkdiana_cli_cgo->FLAGLIRE,qbe_frad_chkdiana_cli_cgo->DATAOPE) + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->VALUTA)+Space(3),3) + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->SEGNO)+" ",1) */
        _note = _note+arfn_flaglireR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGLIRE"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"))+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("VALUTA"))+CPLib.Space(3),3)+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("SEGNO"))+" ",1);
        /* _note := _note +  Right('000000000000000'+LRTrim(Str(qbe_frad_chkdiana_cli_cgo->TOTLIRE,15,0)),15) + Right('000000000000000'+LRTrim(Str(qbe_frad_chkdiana_cli_cgo->TOTCONT,15,0)),15) + _numticket + Space(17)+"F"+qbe_frad_chkdiana_cli_cgo->NUMPROG+Left(LRTrim(_tipoag)+Space(10),10) */
        _note = _note+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frad_chkdiana_cli_cgo.GetDouble("TOTLIRE"),15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_frad_chkdiana_cli_cgo.GetDouble("TOTCONT"),15,0)),15)+_numticket+CPLib.Space(17)+"F"+Cursor_qbe_frad_chkdiana_cli_cgo.GetString("NUMPROG")+CPLib.Left(CPLib.LRTrim(_tipoag)+CPLib.Space(10),10);
        /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
        FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
        /* nTotRec := nTotRec + 1 */
        nTotRec = CPLib.Round(nTotRec+1,0);
        /* nTotReg := nTotReg + 1 */
        nTotReg = CPLib.Round(nTotReg+1,0);
        /* nNumRec := nNumRec + 1 */
        nNumRec = CPLib.Round(nNumRec+1,0);
        /* If not(Empty(qbe_frad_chkdiana_cli_cgo->CONNESCLI)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESCLI")))) {
          /* _oldrap := '' */
          _oldrap = "";
          /* _codrif := qbe_frad_chkdiana_cli_cgo->CONNESCLI */
          _codrif = Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESCLI");
          /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
          if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
          } else { // Else
            /* If Empty(qbe_frad_chkdiana_cli_cgo->CONNESOPER) or (qbe_frad_chkdiana_cli_cgo->CONNESOPER=qbe_frad_chkdiana_cli_cgo->CONNESCLI) */
            if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESCLI")))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
            } // End If
          } // End If
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana_cli_cgo->CONNESCLI,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'2',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESCLI"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
          /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
          FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* If not(Empty(qbe_frad_chkdiana_cli_cgo->RAPPORTO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO")))) {
          /* _oldrap := '' */
          _oldrap = "";
          // * --- Read from knarapbo
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"));
          if (m_Ctx.IsSharedTemp("knarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _oldrap = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_cgo_chkdiana returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _oldrap = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_oldrap)) */
          if ( ! (CPLib.Empty(_oldrap))) {
            // * --- Select from intestbo
            m_cServer = m_Ctx.GetServer("intestbo");
            m_cPhName = m_Ctx.GetPhName("intestbo");
            if (Cursor_intestbo!=null)
              Cursor_intestbo.Close();
            Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestbo.Eof())) {
              /* If qbe_frad_chkdiana_cli_cgo->RAPPORTO = intestbo->RAPPORTO */
              if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_intestbo.GetString("RAPPORTO"))) {
                /* _avanza := 0 */
                _avanza = CPLib.Round(0,0);
                /* If Empty(intestbo->CODINTER) or intestbo->STATOREG='2' or intestbo->STATOREG='3' */
                if (CPLib.Empty(Cursor_intestbo.GetString("CODINTER")) || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"2") || CPLib.eqr(Cursor_intestbo.GetString("STATOREG"),"3")) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If intestbo->DATAINI > qbe_frad_chkdiana_cli_cgo->DATAOPE */
                if (CPLib.gt(Cursor_intestbo.GetDate("DATAINI"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < qbe_frad_chkdiana_cli_cgo->DATAOPE */
                if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If intestbo->CODINTER=qbe_frad_chkdiana_cli_cgo->CONNESCLI */
                if (CPLib.eqr(Cursor_intestbo.GetString("CODINTER"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESCLI"))) {
                  /* _avanza := 1 */
                  _avanza = CPLib.Round(1,0);
                } // End If
                /* If _avanza = 0 */
                if (CPLib.eqr(_avanza,0)) {
                  /* _codrif := intestbo->CODINTER */
                  _codrif = Cursor_intestbo.GetString("CODINTER");
                  /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
                  if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
                  } else { // Else
                    /* If Empty(qbe_frad_chkdiana_cli_cgo->CONNESOPER) or (qbe_frad_chkdiana_cli_cgo->CONNESOPER=intestbo->CODINTER) */
                    if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER"),Cursor_intestbo.GetString("CODINTER")))) {
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                    } else { // Else
                      /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                      _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                    } // End If
                  } // End If
                  /* _note := _note + LRTrim(arfn_datisog_sol(intestbo->CODINTER,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'2',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
                  _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
                  /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                  FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                  /* nTotRec := nTotRec + 1 */
                  nTotRec = CPLib.Round(nTotRec+1,0);
                  /* nNumRec := nNumRec + 1 */
                  nNumRec = CPLib.Round(nNumRec+1,0);
                } // End If
              } // End If
              Cursor_intestbo.Next();
            }
            m_cConnectivityError = Cursor_intestbo.ErrorMessage();
            Cursor_intestbo.Close();
            // * --- End Select
          } // End If
        } // End If
        /* If not(Empty(LRTrim(_oldrap))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(_oldrap)))) {
          /* _oldrighe := 0 */
          _oldrighe = CPLib.Round(0,0);
          /* If qbe_frad_chkdiana_cli_cgo->STATOREG='3' and _mlientifrz */
          if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),"3") && _mlientifrz) {
            /* _oldrighe := 0 */
            _oldrighe = CPLib.Round(0,0);
            // * --- Select from mlientifrz
            m_cServer = m_Ctx.GetServer("mlientifrz");
            m_cPhName = m_Ctx.GetPhName("mlientifrz");
            if (Cursor_mlientifrz!=null)
              Cursor_mlientifrz.Close();
            Cursor_mlientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mlientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_mlientifrz.Eof())) {
              /* _oldrighe := 1 */
              _oldrighe = CPLib.Round(1,0);
              /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
              if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
              } else { // Else
                /* If Empty(qbe_frad_chkdiana_cli_cgo->CONNESOPER) or (qbe_frad_chkdiana_cli_cgo->CONNESOPER=mlientifrz->CODSOG) */
                if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER"),Cursor_mlientifrz.GetString("CODSOG")))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                } else { // Else
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                } // End If
              } // End If
              /* _note := _note + LRTrim(arfn_datisog_sol(mlientifrz->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'2',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mlientifrz.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_mlientifrz.Next();
            }
            m_cConnectivityError = Cursor_mlientifrz.ErrorMessage();
            Cursor_mlientifrz.Close();
            // * --- End Select
          } // End If
          /* If _oldrighe=0 and _clientifrz */
          if (CPLib.eqr(_oldrighe,0) && _clientifrz) {
            // * --- Select from clientifrz
            m_cServer = m_Ctx.GetServer("clientifrz");
            m_cPhName = m_Ctx.GetPhName("clientifrz");
            if (Cursor_clientifrz!=null)
              Cursor_clientifrz.Close();
            Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientifrz.Eof())) {
              /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
              if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '7' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"7"+_idereg;
              } else { // Else
                /* If Empty(qbe_frad_chkdiana_cli_cgo->CONNESOPER) or (qbe_frad_chkdiana_cli_cgo->CONNESOPER=clientifrz->CODSOG) */
                if (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER")) || (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER"),Cursor_clientifrz.GetString("CODSOG")))) {
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '2' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"2"+_idereg;
                } else { // Else
                  /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '3' + _idereg */
                  _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"3"+_idereg;
                } // End If
              } // End If
              /* _note := _note + LRTrim(arfn_datisog_sol(clientifrz->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'2',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_clientifrz.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"2",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
              Cursor_clientifrz.Next();
            }
            m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
            Cursor_clientifrz.Close();
            // * --- End Select
          } // End If
        } // End If
        /* If not(Empty(qbe_frad_chkdiana_cli_cgo->CONNESOPER)) and qbe_frad_chkdiana_cli_cgo->CONNESOPER <> _codrif */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER"))) && CPLib.ne(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER"),_codrif)) {
          /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
          if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '8' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
          } else { // Else
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '4' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"4"+_idereg;
          } // End If
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana_cli_cgo->CONNESOPER,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'4',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"4",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
          /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
          FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_frad_chkdiana_cli_cgo->STATOREG='3' and _mogopefbo */
        if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),"3") && _mogopefbo) {
          // * --- Select from mogopefbo
          m_cServer = m_Ctx.GetServer("mogopefbo");
          m_cPhName = m_Ctx.GetPhName("mogopefbo");
          if (Cursor_mogopefbo!=null)
            Cursor_mogopefbo.Close();
          Cursor_mogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("mogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_mogopefbo.Eof())) {
            /* _oldrighe := 1 */
            _oldrighe = CPLib.Round(1,0);
            /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '8' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '4' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"4"+_idereg;
            } // End If
            /* _note := _note + LRTrim(arfn_datisog_sol(mogopefbo->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'4',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_mogopefbo.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"4",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_mogopefbo.Next();
          }
          m_cConnectivityError = Cursor_mogopefbo.ErrorMessage();
          Cursor_mogopefbo.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 and _sogopefbo */
        if (CPLib.eqr(_oldrighe,0) && _sogopefbo) {
          // * --- Select from sogopefbo
          m_cServer = m_Ctx.GetServer("sogopefbo");
          m_cPhName = m_Ctx.GetPhName("sogopefbo");
          if (Cursor_sogopefbo!=null)
            Cursor_sogopefbo.Close();
          Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopefbo.Eof())) {
            /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '8' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '4' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"4"+_idereg;
            } // End If
            /* _note := _note + LRTrim(arfn_datisog_sol(sogopefbo->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'4',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
            _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_sogopefbo.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"4",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_sogopefbo.Next();
          }
          m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
          Cursor_sogopefbo.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_frad_chkdiana_cli_cgo->CONNESBEN)) or not(Empty(qbe_frad_chkdiana_cli_cgo->C_RAG)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESBEN"))) ||  ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAG")))) {
          /* If not(Empty(qbe_frad_chkdiana_cli_cgo->C_RAG)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAG")))) {
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->CONNESBEN)+Space(16),16) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESBEN"))+CPLib.Space(16),16);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->C_RAG,' '))+Space(70),70) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAG")," "))+CPLib.Space(70),70);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_STA)+Space(3),3) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_STA"))+CPLib.Space(3),3);
            /* _note := _note +Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAB)+Space(6),6) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAB"))+CPLib.Space(6),6);
            /* _note := _note +Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->C_CTA,' '))+Space(30),30) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CTA")," "))+CPLib.Space(30),30);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_PRV)+Space(2),2) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_PRV"))+CPLib.Space(2),2);
            /* _note := _note + Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->C_IND,' '))+Space(35),35) */
            _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_IND")," "))+CPLib.Space(35),35);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAP)+Space(5),5) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAP"))+CPLib.Space(5),5);
            /* _note := _note + Space(63) */
            _note = _note+CPLib.Space(63);
            /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_RAPPORTO)+Space(25),25) */
            _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
            /* _note := _note + Space(91) */
            _note = _note+CPLib.Space(91);
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            /* ElseIf not(Empty(qbe_frad_chkdiana_cli_cgo->CONNESBEN)) */
          } else if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESBEN")))) {
            /* _numsto := arfn_chkspers(qbe_frad_chkdiana_cli_cgo->CONNESBEN,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE)) */
            _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESBEN"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")));
            /* If Empty(LRTrim(_numsto)) */
            if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESBEN"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_STA))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAB))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_PRV))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_IND))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAP))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_RAPPORTO))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
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
              Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_wersonbo.Eof())) {
                /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' */
                _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5";
                /* If Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->FLAGRAP2)) */
                if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP2")))) {
                  /* _note := _note + DateToChar(qbe_frad_chkdiana_cli_cgo->DATAOPE) + qbe_frad_chkdiana_cli_cgo->NUMPROG + 'S' */
                  _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana_cli_cgo.GetString("NUMPROG")+"S";
                } else { // Else
                  /* _note := _note + qbe_frad_chkdiana_cli_cgo->IDEREG */
                  _note = _note+Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDEREG");
                } // End If
                /* _note := _note + Left(LRTrim(qbe_frad_chkdiana_cli_cgo->CONNESBEN)+Space(16),16) */
                _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESBEN"))+CPLib.Space(16),16);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_RAG))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_STA))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAB))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CTA))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_PRV))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_IND))),Left(LRTrim(arfn_agechar(qbe_frad_chkdiana_cli_cgo->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAP))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                /* _note := _note + Space(63) */
                _note = _note+CPLib.Space(63);
                /* _note := _note + iif(not(Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->C_RAPPORTO))),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->C_RAPPORTO)+Space(25),25),Left(LRTrim(qbe_frad_chkdiana_cli_cgo->RAPPORTBEN)+Space(25),25)) */
                _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAPPORTO"))))?CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("C_RAPPORTO"))+CPLib.Space(25),25):CPLib.Left(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTBEN"))+CPLib.Space(25),25));
                /* _note := _note + Space(91) */
                _note = _note+CPLib.Space(91);
                /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                /* nTotRec := nTotRec + 1 */
                nTotRec = CPLib.Round(nTotRec+1,0);
                /* nNumRec := nNumRec + 1 */
                nNumRec = CPLib.Round(nNumRec+1,0);
                Cursor_wersonbo.Next();
              }
              m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
              Cursor_wersonbo.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_frad_chkdiana_cli_cgo->STATOREG='3' and _meneficfrz */
        if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),"3") && _meneficfrz) {
          // * --- Select from meneficfrz
          m_cServer = m_Ctx.GetServer("meneficfrz");
          m_cPhName = m_Ctx.GetPhName("meneficfrz");
          if (Cursor_meneficfrz!=null)
            Cursor_meneficfrz.Close();
          Cursor_meneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("meneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_meneficfrz.Eof())) {
            /* _oldrighe := 1 */
            _oldrighe = CPLib.Round(1,0);
            /* If Empty(LRTrim(meneficfrz->CODSOG)) and not(Empty(LRTrim(meneficfrz->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG"))))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
              /* _note := _note + Left(LRTrim(meneficfrz->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(meneficfrz->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(meneficfrz->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(meneficfrz->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(meneficfrz->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(meneficfrz->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(meneficfrz->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(meneficfrz->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(meneficfrz->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* If meneficfrz->CODSOG <> qbe_frad_chkdiana_cli_cgo->CONNESBEN */
              if (CPLib.ne(Cursor_meneficfrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESBEN"))) {
                /* _numsto := arfn_chkspers(meneficfrz->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE)) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_meneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(meneficfrz->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(meneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_STA))),Left(LRTrim(meneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAB))),Left(LRTrim(meneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(meneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_PRV))),Left(LRTrim(meneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_IND))),Left(LRTrim(arfn_agechar(meneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAP))),Left(LRTrim(meneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(meneficfrz->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
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
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5";
                    /* If Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->FLAGRAP2)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP2")))) {
                      /* _note := _note + DateToChar(qbe_frad_chkdiana_cli_cgo->DATAOPE) + qbe_frad_chkdiana_cli_cgo->NUMPROG + 'S' */
                      _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana_cli_cgo.GetString("NUMPROG")+"S";
                    } else { // Else
                      /* _note := _note + qbe_frad_chkdiana_cli_cgo->IDEREG */
                      _note = _note+Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDEREG");
                    } // End If
                    /* _note := _note + Left(LRTrim(meneficfrz->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(meneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_STA))),Left(LRTrim(meneficfrz->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAB))),Left(LRTrim(meneficfrz->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(meneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_PRV))),Left(LRTrim(meneficfrz->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_IND))),Left(LRTrim(arfn_agechar(meneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_meneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(meneficfrz->C_CAP))),Left(LRTrim(meneficfrz->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(meneficfrz->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_meneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
            } // End If
            Cursor_meneficfrz.Next();
          }
          m_cConnectivityError = Cursor_meneficfrz.ErrorMessage();
          Cursor_meneficfrz.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 and _beneficfrz */
        if (CPLib.eqr(_oldrighe,0) && _beneficfrz) {
          // * --- Select from beneficfrz
          m_cServer = m_Ctx.GetServer("beneficfrz");
          m_cPhName = m_Ctx.GetPhName("beneficfrz");
          if (Cursor_beneficfrz!=null)
            Cursor_beneficfrz.Close();
          Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficfrz.Eof())) {
            /* If Empty(LRTrim(beneficfrz->CODSOG)) and not(Empty(LRTrim(beneficfrz->C_RAG))) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
              /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
              /* _note := _note +Left(LRTrim(arfn_agechar(beneficfrz->C_RAG,' '))+Space(70),70) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70);
              /* _note := _note + Left(LRTrim(beneficfrz->C_STA)+Space(3),3) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3);
              /* _note := _note +Left(LRTrim(beneficfrz->C_CAB)+Space(6),6) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6);
              /* _note := _note +Left(LRTrim(arfn_agechar(beneficfrz->C_CTA,' '))+Space(30),30) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30);
              /* _note := _note + Left(LRTrim(beneficfrz->C_PRV)+Space(2),2) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2);
              /* _note := _note + Left(LRTrim(arfn_agechar(beneficfrz->C_IND,' '))+Space(35),35) */
              _note = _note+CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35);
              /* _note := _note + Left(LRTrim(beneficfrz->C_CAP)+Space(5),5) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5);
              /* _note := _note + Space(63) */
              _note = _note+CPLib.Space(63);
              /* _note := _note + Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
              _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
              /* _note := _note + Space(91) */
              _note = _note+CPLib.Space(91);
              /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
              FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
              /* nTotRec := nTotRec + 1 */
              nTotRec = CPLib.Round(nTotRec+1,0);
              /* nNumRec := nNumRec + 1 */
              nNumRec = CPLib.Round(nNumRec+1,0);
            } else { // Else
              /* If beneficfrz->CODSOG <> qbe_frad_chkdiana_cli_cgo->CONNESBEN */
              if (CPLib.ne(Cursor_beneficfrz.GetString("CODSOG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNESBEN"))) {
                /* _numsto := arfn_chkspers(beneficfrz->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE)) */
                _numsto = arfn_chkspersR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")));
                /* If Empty(LRTrim(_numsto)) */
                if (CPLib.Empty(CPLib.LRTrim(_numsto))) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' + _idereg */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5"+_idereg;
                    /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(beneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(personbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_STA))),Left(LRTrim(beneficfrz->C_STA)+Space(3),3),Left(LRTrim(personbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAB))),Left(LRTrim(beneficfrz->C_CAB)+Space(6),6),Left(LRTrim(personbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(beneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(personbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_PRV))),Left(LRTrim(beneficfrz->C_PRV)+Space(2),2),Left(LRTrim(personbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_IND))),Left(LRTrim(arfn_agechar(beneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(personbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAP))),Left(LRTrim(beneficfrz->C_CAP)+Space(5),5),Left(LRTrim(personbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_personbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
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
                  Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numsto,"?",0,0,m_cServer, m_oParameters),m_cServer,_numsto)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_wersonbo.Eof())) {
                    /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11)+'5' */
                    _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"5";
                    /* If Empty(LRTrim(qbe_frad_chkdiana_cli_cgo->FLAGRAP2)) */
                    if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP2")))) {
                      /* _note := _note + DateToChar(qbe_frad_chkdiana_cli_cgo->DATAOPE) + qbe_frad_chkdiana_cli_cgo->NUMPROG + 'S' */
                      _note = _note+CPLib.DateToChar(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"))+Cursor_qbe_frad_chkdiana_cli_cgo.GetString("NUMPROG")+"S";
                    } else { // Else
                      /* _note := _note + qbe_frad_chkdiana_cli_cgo->IDEREG */
                      _note = _note+Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDEREG");
                    } // End If
                    /* _note := _note + Left(LRTrim(beneficfrz->CODSOG)+Space(16),16) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("CODSOG"))+CPLib.Space(16),16);
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_RAG))),Left(LRTrim(arfn_agechar(beneficfrz->C_RAG,' '))+Space(70),70),Left(LRTrim(arfn_agechar(wersonbo->RAGSOC,' '))+Space(70),70)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAG"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_RAG")," "))+CPLib.Space(70),70):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("RAGSOC")," "))+CPLib.Space(70),70));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_STA))),Left(LRTrim(beneficfrz->C_STA)+Space(3),3),Left(LRTrim(wersonbo->PAESE)+Space(3),3)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_STA"))+CPLib.Space(3),3):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PAESE"))+CPLib.Space(3),3));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAB))),Left(LRTrim(beneficfrz->C_CAB)+Space(6),6),Left(LRTrim(wersonbo->CODCAB)+Space(6),6)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAB"))+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CODCAB"))+CPLib.Space(6),6));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CTA))),Left(LRTrim(arfn_agechar(beneficfrz->C_CTA,' '))+Space(30),30),Left(LRTrim(arfn_agechar(wersonbo->DESCCIT,' '))+Space(30),30)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CTA"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_CTA")," "))+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DESCCIT")," "))+CPLib.Space(30),30));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_PRV))),Left(LRTrim(beneficfrz->C_PRV)+Space(2),2),Left(LRTrim(wersonbo->PROVINCIA)+Space(2),2)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_PRV"))+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("PROVINCIA"))+CPLib.Space(2),2));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_IND))),Left(LRTrim(arfn_agechar(beneficfrz->C_IND,' '))+Space(35),35),Left(LRTrim(arfn_agechar(wersonbo->DOMICILIO,' '))+Space(35),35)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_IND"))))?CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_beneficfrz.GetString("C_IND")," "))+CPLib.Space(35),35):CPLib.Left(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_wersonbo.GetString("DOMICILIO")," "))+CPLib.Space(35),35));
                    /* _note := _note + iif(not(Empty(LRTrim(beneficfrz->C_CAP))),Left(LRTrim(beneficfrz->C_CAP)+Space(5),5),Left(LRTrim(wersonbo->CAP)+Space(5),5)) */
                    _note = _note+( ! (CPLib.Empty(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))))?CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_CAP"))+CPLib.Space(5),5):CPLib.Left(CPLib.LRTrim(Cursor_wersonbo.GetString("CAP"))+CPLib.Space(5),5));
                    /* _note := _note + Space(63) */
                    _note = _note+CPLib.Space(63);
                    /* _note := _note +Left(LRTrim(beneficfrz->C_RAPPORTO)+Space(25),25) */
                    _note = _note+CPLib.Left(CPLib.LRTrim(Cursor_beneficfrz.GetString("C_RAPPORTO"))+CPLib.Space(25),25);
                    /* _note := _note + Space(91) */
                    _note = _note+CPLib.Space(91);
                    /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
                    FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
                    /* nTotRec := nTotRec + 1 */
                    nTotRec = CPLib.Round(nTotRec+1,0);
                    /* nNumRec := nNumRec + 1 */
                    nNumRec = CPLib.Round(nNumRec+1,0);
                    Cursor_wersonbo.Next();
                  }
                  m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                  Cursor_wersonbo.Close();
                  // * --- End Select
                } // End If
              } // End If
            } // End If
            Cursor_beneficfrz.Next();
          }
          m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
          Cursor_beneficfrz.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(qbe_frad_chkdiana_cli_cgo->CONNALTRO)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNALTRO")))) {
          /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
          if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '8' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"8"+_idereg;
          } else { // Else
            /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '6' + _idereg */
            _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
          } // End If
          /* _note := _note + LRTrim(arfn_datisog_sol(qbe_frad_chkdiana_cli_cgo->CONNALTRO,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'6',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
          _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNALTRO"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
          /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
          FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
          /* nTotRec := nTotRec + 1 */
          nTotRec = CPLib.Round(nTotRec+1,0);
          /* nNumRec := nNumRec + 1 */
          nNumRec = CPLib.Round(nNumRec+1,0);
        } // End If
        /* _oldrighe := 0 */
        _oldrighe = CPLib.Round(0,0);
        /* If qbe_frad_chkdiana_cli_cgo->STATOREG='3' and _merzistifrz */
        if (CPLib.eqr(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),"3") && _merzistifrz) {
          // * --- Select from merzistifrz
          m_cServer = m_Ctx.GetServer("merzistifrz");
          m_cPhName = m_Ctx.GetPhName("merzistifrz");
          if (Cursor_merzistifrz!=null)
            Cursor_merzistifrz.Close();
          Cursor_merzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("merzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_merzistifrz.Eof())) {
            /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '9' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(merzistifrz->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'9',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_merzistifrz.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '6' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(merzistifrz->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'6',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_merzistifrz.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
            } // End If
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_merzistifrz.Next();
          }
          m_cConnectivityError = Cursor_merzistifrz.ErrorMessage();
          Cursor_merzistifrz.Close();
          // * --- End Select
        } // End If
        /* If _oldrighe=0 and _terzistifrz */
        if (CPLib.eqr(_oldrighe,0) && _terzistifrz) {
          // * --- Select from terzistifrz
          m_cServer = m_Ctx.GetServer("terzistifrz");
          m_cPhName = m_Ctx.GetPhName("terzistifrz");
          if (Cursor_terzistifrz!=null)
            Cursor_terzistifrz.Close();
          Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("IDBASE"),"?",0,0)+"  and  CODSOG <> "+CPLib.ToSQL(Cursor_qbe_frad_chkdiana_cli_cgo.GetString("CONNALTRO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistifrz.Eof())) {
            /* If qbe_frad_chkdiana_cli_cgo->DATAOPE > CharToDate('20131231') */
            if (CPLib.gt(Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE"),CPLib.CharToDate("20131231"))) {
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '9' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"9"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(terzistifrz->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'9',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistifrz.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"9",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
            } else { // Else
              /* _note := w_tipinter + Left(LRTrim(w_codinter)+Space(11),11) + '6' + _idereg */
              _note = w_tipinter+CPLib.Left(CPLib.LRTrim(w_codinter)+CPLib.Space(11),11)+"6"+_idereg;
              /* _note := _note + LRTrim(arfn_datisog_sol(terzistifrz->CODSOG,iif(w_stoper='R',qbe_frad_chkdiana_cli_cgo->DATAREG,qbe_frad_chkdiana_cli_cgo->DATAOPE),qbe_frad_chkdiana_cli_cgo->RAPPORTO,qbe_frad_chkdiana_cli_cgo->FLAGRAP,'6',_raeatc,qbe_frad_chkdiana_cli_cgo->STATOREG,qbe_frad_chkdiana_cli_cgo->DATARETT)) */
              _note = _note+CPLib.LRTrim(arfn_datisog_solR.Make(m_Ctx,this).Run(Cursor_terzistifrz.GetString("CODSOG"),(CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATAOPE")),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("RAPPORTO"),Cursor_qbe_frad_chkdiana_cli_cgo.GetString("FLAGRAP"),"6",_raeatc,Cursor_qbe_frad_chkdiana_cli_cgo.GetString("STATOREG"),Cursor_qbe_frad_chkdiana_cli_cgo.GetDate("DATARETT")));
            } // End If
            /* FileLibMit.Write(fhand,Left(LRTrim(_note)+Space(380),380)+NL) */
            FileLibMit.Write(fhand,CPLib.Left(CPLib.LRTrim(_note)+CPLib.Space(380),380)+"\n");
            /* nTotRec := nTotRec + 1 */
            nTotRec = CPLib.Round(nTotRec+1,0);
            /* nNumRec := nNumRec + 1 */
            nNumRec = CPLib.Round(nNumRec+1,0);
            Cursor_terzistifrz.Next();
          }
          m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
          Cursor_terzistifrz.Close();
          // * --- End Select
        } // End If
        Cursor_qbe_frad_chkdiana_cli_cgo.Next();
      }
      m_cConnectivityError = Cursor_qbe_frad_chkdiana_cli_cgo.ErrorMessage();
      Cursor_qbe_frad_chkdiana_cli_cgo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_frad_chkdiana_cli_cgo!=null)
          Cursor_qbe_frad_chkdiana_cli_cgo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_knarapbo!=null)
          Cursor_knarapbo.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
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
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
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
        if (Cursor_meneficfrz!=null)
          Cursor_meneficfrz.Close();
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
        if (Cursor_merzistifrz!=null)
          Cursor_merzistifrz.Close();
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
  void Page_5() throws Exception {
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
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000046C;
      _h0000046C = new SPBridge.HMCaller();
      _h0000046C.Set("m_cVQRList",m_cVQRList);
      _h0000046C.Set("tbname","mlientiope");
      _h0000046C.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000046C,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _mlientiope := qbe_tab_mmc->tot > 0 */
        _mlientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000046E;
      _h0000046E = new SPBridge.HMCaller();
      _h0000046E.Set("m_cVQRList",m_cVQRList);
      _h0000046E.Set("tbname","clientiope");
      _h0000046E.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000046E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientiope := qbe_tab_mmc->tot > 0 */
        _clientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000470;
      _h00000470 = new SPBridge.HMCaller();
      _h00000470.Set("m_cVQRList",m_cVQRList);
      _h00000470.Set("tbname","mogopebo");
      _h00000470.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000470,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _mogopebo := qbe_tab_mmc->tot > 0 */
        _mogopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000472;
      _h00000472 = new SPBridge.HMCaller();
      _h00000472.Set("m_cVQRList",m_cVQRList);
      _h00000472.Set("tbname","sogopebo");
      _h00000472.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000472,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _sogopebo := qbe_tab_mmc->tot > 0 */
        _sogopebo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000474;
      _h00000474 = new SPBridge.HMCaller();
      _h00000474.Set("m_cVQRList",m_cVQRList);
      _h00000474.Set("tbname","meneficope");
      _h00000474.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000474,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _meneficope := qbe_tab_mmc->tot > 0 */
        _meneficope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000476;
      _h00000476 = new SPBridge.HMCaller();
      _h00000476.Set("m_cVQRList",m_cVQRList);
      _h00000476.Set("tbname","beneficope");
      _h00000476.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000476,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _beneficope := qbe_tab_mmc->tot > 0 */
        _beneficope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000478;
      _h00000478 = new SPBridge.HMCaller();
      _h00000478.Set("m_cVQRList",m_cVQRList);
      _h00000478.Set("tbname","merzistiope");
      _h00000478.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000478,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _merzistiope := qbe_tab_mmc->tot > 0 */
        _merzistiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000047A;
      _h0000047A = new SPBridge.HMCaller();
      _h0000047A.Set("m_cVQRList",m_cVQRList);
      _h0000047A.Set("tbname","terzistiope");
      _h0000047A.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000047A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _terzistiope := qbe_tab_mmc->tot > 0 */
        _terzistiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000047C;
      _h0000047C = new SPBridge.HMCaller();
      _h0000047C.Set("m_cVQRList",m_cVQRList);
      _h0000047C.Set("tbname","mlientifrz");
      _h0000047C.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000047C,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _mlientifrz := qbe_tab_mmc->tot > 0 */
        _mlientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000047E;
      _h0000047E = new SPBridge.HMCaller();
      _h0000047E.Set("m_cVQRList",m_cVQRList);
      _h0000047E.Set("tbname","clientifrz");
      _h0000047E.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000047E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientifrz := qbe_tab_mmc->tot > 0 */
        _clientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000480;
      _h00000480 = new SPBridge.HMCaller();
      _h00000480.Set("m_cVQRList",m_cVQRList);
      _h00000480.Set("tbname","mogopefbo");
      _h00000480.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000480,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _mogopefbo := qbe_tab_mmc->tot > 0 */
        _mogopefbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000482;
      _h00000482 = new SPBridge.HMCaller();
      _h00000482.Set("m_cVQRList",m_cVQRList);
      _h00000482.Set("tbname","sogopefbo");
      _h00000482.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000482,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _sogopefbo := qbe_tab_mmc->tot > 0 */
        _sogopefbo = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000484;
      _h00000484 = new SPBridge.HMCaller();
      _h00000484.Set("m_cVQRList",m_cVQRList);
      _h00000484.Set("tbname","meneficfrz");
      _h00000484.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000484,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _meneficfrz := qbe_tab_mmc->tot > 0 */
        _meneficfrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000486;
      _h00000486 = new SPBridge.HMCaller();
      _h00000486.Set("m_cVQRList",m_cVQRList);
      _h00000486.Set("tbname","beneficfrz");
      _h00000486.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000486,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _beneficfrz := qbe_tab_mmc->tot > 0 */
        _beneficfrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000488;
      _h00000488 = new SPBridge.HMCaller();
      _h00000488.Set("m_cVQRList",m_cVQRList);
      _h00000488.Set("tbname","merzistifrz");
      _h00000488.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000488,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _merzistifrz := qbe_tab_mmc->tot > 0 */
        _merzistifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000048A;
      _h0000048A = new SPBridge.HMCaller();
      _h0000048A.Set("m_cVQRList",m_cVQRList);
      _h0000048A.Set("tbname","terzistifrz");
      _h0000048A.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000048A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _terzistifrz := qbe_tab_mmc->tot > 0 */
        _terzistifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000048C;
      _h0000048C = new SPBridge.HMCaller();
      _h0000048C.Set("m_cVQRList",m_cVQRList);
      _h0000048C.Set("tbname","rapcoll");
      _h0000048C.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000048C,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _rapcolleg := qbe_tab_mmc->tot > 0 */
        _rapcolleg = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
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
  void DatiAge() throws Exception {
    /* _numsto Char(15) */
    /* _ramate Char(3) */
    /* _cabcod Char(6) */
    String _cabcod;
    _cabcod = CPLib.Space(6);
    /* _citdesc Char(30) */
    String _citdesc;
    _citdesc = CPLib.Space(30);
    /* _provind Char(2) */
    String _provind;
    _provind = CPLib.Space(2);
    /* _agente Char(1) */
    String _agente;
    _agente = CPLib.Space(1);
    /* _datage_ Char(0) */
    String _datage_;
    _datage_ = CPLib.Space(0);
    /* Verifica il tipo riga */
    /* _datage := '' // Stringa di ritorno */
    _datage = "";
    /* If Empty(pCodDip) */
    if (CPLib.Empty(pCodDip)) {
      /* If Empty(z_coddipe) */
      if (CPLib.Empty(z_coddipe)) {
        /* _datage := _datage + "000000" + Left(LRTrim(z_codcab)+Space(6),6) + Left(LRTrim(z_desccit)+Space(30),30) + Left(LRTrim(z_provin)+Space(2),2) */
        _datage = _datage+"000000"+CPLib.Left(CPLib.LRTrim(z_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(z_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(z_provin)+CPLib.Space(2),2);
        /* _tipoag := Space(10) */
        _tipoag = CPLib.Space(10);
      } else { // Else
        /* _datage := _datage + Left(LRTrim(z_coddipe)+Space(6),6) */
        _datage = _datage+CPLib.Left(CPLib.LRTrim(z_coddipe)+CPLib.Space(6),6);
        /* If mcANADIP.GoToKey(z_coddipe) */
        if (mcANADIP.GoToKey(z_coddipe)) {
          /* _datage := _datage + Left(LRTrim(mcANADIP.CAB)+Space(6),6) + Left(LRTrim(mcANADIP.DESCCIT)+Space(30),30) + Left(LRTrim(mcANADIP.PROVINCIA)+Space(2),2) */
          _datage = _datage+CPLib.Left(CPLib.LRTrim(mcANADIP.row.CAB)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(mcANADIP.row.DESCCIT)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(mcANADIP.row.PROVINCIA)+CPLib.Space(2),2);
          /* _tipoag := iif((mcANADIP.AGENTE='S' or mcANADIP.AGENTE='1'),'AGENZIA   ',Space(10)) */
          _tipoag = ((CPLib.eqr(mcANADIP.row.AGENTE,"S") || CPLib.eqr(mcANADIP.row.AGENTE,"1"))?"AGENZIA   ":CPLib.Space(10));
        } else { // Else
          /* _datage := _datage + Left(LRTrim(z_codcab)+Space(6),6) + Left(LRTrim(z_desccit)+Space(30),30) + Left(LRTrim(z_provin)+Space(2),2) */
          _datage = _datage+CPLib.Left(CPLib.LRTrim(z_codcab)+CPLib.Space(6),6)+CPLib.Left(CPLib.LRTrim(z_desccit)+CPLib.Space(30),30)+CPLib.Left(CPLib.LRTrim(z_provin)+CPLib.Space(2),2);
          /* _tipoag := Space(10) */
          _tipoag = CPLib.Space(10);
        } // End If
      } // End If
    } else { // Else
      /* If mcANADIP.GoToKey(pCodDip) */
      if (mcANADIP.GoToKey(pCodDip)) {
        /* _datage := _datage + Left(LRTrim(pCodDip)+Space(6),6) */
        _datage = _datage+CPLib.Left(CPLib.LRTrim(pCodDip)+CPLib.Space(6),6);
        /* _datage := _datage + iif(Empty(LRTrim(pCodCab)),Left(LRTrim(mcANADIP.CAB)+Space(6),6),Left(LRTrim(pCodCab)+Space(6),6)) */
        _datage = _datage+(CPLib.Empty(CPLib.LRTrim(pCodCab))?CPLib.Left(CPLib.LRTrim(mcANADIP.row.CAB)+CPLib.Space(6),6):CPLib.Left(CPLib.LRTrim(pCodCab)+CPLib.Space(6),6));
        /* _datage := _datage + iif(Empty(LRTrim(pDesCit)),Left(LRTrim(mcANADIP.DESCCIT)+Space(30),30),Left(LRTrim(pDesCit)+Space(30),30)) */
        _datage = _datage+(CPLib.Empty(CPLib.LRTrim(pDesCit))?CPLib.Left(CPLib.LRTrim(mcANADIP.row.DESCCIT)+CPLib.Space(30),30):CPLib.Left(CPLib.LRTrim(pDesCit)+CPLib.Space(30),30));
        /* _datage := _datage + iif(Empty(LRTrim(pProv)),Left(LRTrim(mcANADIP.PROVINCIA)+Space(2),2),Left(LRTrim(pProv)+Space(2),2)) */
        _datage = _datage+(CPLib.Empty(CPLib.LRTrim(pProv))?CPLib.Left(CPLib.LRTrim(mcANADIP.row.PROVINCIA)+CPLib.Space(2),2):CPLib.Left(CPLib.LRTrim(pProv)+CPLib.Space(2),2));
        /* _tipoag := iif((mcANADIP.AGENTE='S' or mcANADIP.AGENTE='1'),'AGENZIA   ',Space(10)) */
        _tipoag = ((CPLib.eqr(mcANADIP.row.AGENTE,"S") || CPLib.eqr(mcANADIP.row.AGENTE,"1"))?"AGENZIA   ":CPLib.Space(10));
      } else { // Else
        /* _datage := _datage + Left(LRTrim(pCodDip)+Space(6),6) */
        _datage = _datage+CPLib.Left(CPLib.LRTrim(pCodDip)+CPLib.Space(6),6);
        /* _datage := _datage + Left(LRTrim(pCodCab)+Space(6),6) */
        _datage = _datage+CPLib.Left(CPLib.LRTrim(pCodCab)+CPLib.Space(6),6);
        /* _datage := _datage +Left(LRTrim(pDesCit)+Space(30),30) */
        _datage = _datage+CPLib.Left(CPLib.LRTrim(pDesCit)+CPLib.Space(30),30);
        /* _datage := _datage + Left(LRTrim(pProv)+Space(2),2) */
        _datage = _datage+CPLib.Left(CPLib.LRTrim(pProv)+CPLib.Space(2),2);
        /* _tipoag := Space(10) */
        _tipoag = CPLib.Space(10);
      } // End If
    } // End If
  }
  void Page_7() throws Exception {
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
  void Page_8() throws Exception {
    CPResultSet Cursor_qbe_cgo_cf_scarico380=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* mcConnes.Zap() */
      mcConnes.Zap();
      // * --- Select from qbe_cgo_cf_scarico380
      if (Cursor_qbe_cgo_cf_scarico380!=null)
        Cursor_qbe_cgo_cf_scarico380.Close();
      Cursor_qbe_cgo_cf_scarico380 = new VQRHolder("qbe_cgo_cf_scarico380",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_cf_scarico380.Eof())) {
        /* If not(Empty(qbe_cgo_cf_scarico380->CONNES)) */
        if ( ! (CPLib.Empty(Cursor_qbe_cgo_cf_scarico380.GetString("CONNES")))) {
          /* mcConnes.AppendWithKey(qbe_cgo_cf_scarico380->CONNES) */
          mcConnes.AppendWithKey(Cursor_qbe_cgo_cf_scarico380.GetString("CONNES"));
          /* mcConnes.connes := qbe_cgo_cf_scarico380->CONNES */
          mcConnes.row.connes = Cursor_qbe_cgo_cf_scarico380.GetString("CONNES");
          /* mcConnes.SaveRow() */
          mcConnes.SaveRow();
        } // End If
        Cursor_qbe_cgo_cf_scarico380.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_cf_scarico380.ErrorMessage();
      Cursor_qbe_cgo_cf_scarico380.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_cgo_cf_scarico380!=null)
          Cursor_qbe_cgo_cf_scarico380.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  double calcola_mese(double pMeseIni,double pMeseFin) throws Exception {
    /* pMeseIni Numeric(2, 0) */
    /* pMeseFin Numeric(2, 0) */
    /* nRitorno Numeric(2, 0) */
    double nRitorno;
    nRitorno = 0;
    /* _diff Numeric(3, 0) */
    /* _diff1 Numeric(3, 0) */
    /* _diff := pMeseIni - pMeseFin */
    _diff = CPLib.Round(pMeseIni-pMeseFin,0);
    /* Case _diff > 0 */
    if (CPLib.gt(_diff,0)) {
      /* nRitorno := _diff */
      nRitorno = CPLib.Round(_diff,0);
      /* Case _diff = 0 */
    } else if (CPLib.eqr(_diff,0)) {
      /* nRitorno := 12 */
      nRitorno = CPLib.Round(12,0);
      /* Case _diff < 0 */
    } else if (CPLib.lt(_diff,0)) {
      /* nRitorno := 12 + _diff */
      nRitorno = CPLib.Round(12+_diff,0);
    } // End Case
    /* Page Return nRitorno */
    return nRitorno;
  }
  void invioEMail() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_destwarn=null;
    try {
      /* _srvmail Char(50) */
      String _srvmail;
      _srvmail = CPLib.Space(50);
      /* _prtmail Numeric(5, 0) */
      double _prtmail;
      _prtmail = 0;
      /* _emlmail Char(50) */
      String _emlmail;
      _emlmail = CPLib.Space(50);
      /* _usrmail Char(50) */
      String _usrmail;
      _usrmail = CPLib.Space(50);
      /* _pwdmail Char(30) */
      String _pwdmail;
      _pwdmail = CPLib.Space(30);
      /* _testo Memo */
      String _testo;
      _testo = "";
      /* _desdip Char(30) */
      String _desdip;
      _desdip = CPLib.Space(30);
      /* _esito Memo */
      String _esito;
      _esito = "";
      /* cProg Char(20) */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ALTSRVMAIL,ALTPRTMAIL,ALTEMLMAIL,ALTUSRMAIL,ALTPWDMAIL,PRGAEPATH  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _srvmail := intermbo->ALTSRVMAIL */
        _srvmail = Cursor_intermbo.GetString("ALTSRVMAIL");
        /* _prtmail := iif(Empty(LRTrim(intermbo->ALTPRTMAIL)),25,Val(LRTrim(intermbo->ALTPRTMAIL))) */
        _prtmail = CPLib.Round((CPLib.Empty(CPLib.LRTrim(Cursor_intermbo.GetString("ALTPRTMAIL")))?25:CPLib.Val(CPLib.LRTrim(Cursor_intermbo.GetString("ALTPRTMAIL")))),0);
        /* _emlmail := intermbo->ALTEMLMAIL */
        _emlmail = Cursor_intermbo.GetString("ALTEMLMAIL");
        /* _usrmail := intermbo->ALTUSRMAIL */
        _usrmail = Cursor_intermbo.GetString("ALTUSRMAIL");
        /* _pwdmail := intermbo->ALTPWDMAIL */
        _pwdmail = Cursor_intermbo.GetString("ALTPWDMAIL");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* If cRitorno='OK' */
      if (CPLib.eqr(cRitorno,"OK")) {
        /* _testo := 'Creazione automatica file 380 avvenuto in maniera corretta '+NL+_gMsgProc+NL+' '+NL+"Numero di operazioni estratte: "+LRTrim(Str(o_tot))+NL+"Numero di frazionate estratte: "+LRTrim(Str(f_tot))+NL+"Numero di informazioni estratte: "+LRTrim(Str(i_tot))+NL */
        _testo = "Creazione automatica file 380 avvenuto in maniera corretta "+"\n"+_gMsgProc+"\n"+" "+"\n"+"Numero di operazioni estratte: "+CPLib.LRTrim(CPLib.Str(o_tot))+"\n"+"Numero di frazionate estratte: "+CPLib.LRTrim(CPLib.Str(f_tot))+"\n"+"Numero di informazioni estratte: "+CPLib.LRTrim(CPLib.Str(i_tot))+"\n";
      } else { // Else
        /* _testo := 'Creazione automatica file 380 avvenuto in maniera NON corretta '+NL+_gMsgProc */
        _testo = "Creazione automatica file 380 avvenuto in maniera NON corretta "+"\n"+_gMsgProc;
      } // End If
      // * --- Select from destwarn
      m_cServer = m_Ctx.GetServer("destwarn");
      m_cPhName = m_Ctx.GetPhName("destwarn");
      if (Cursor_destwarn!=null)
        Cursor_destwarn.Close();
      Cursor_destwarn = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DWFLG380='S' "+")"+(m_Ctx.IsSharedTemp("destwarn")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_destwarn.Eof())) {
        /* _esito := MailLibrary.sendMail(_testo,'TXT','Creazione automatica file 380',LRTrim(_srvmail),LRTrim(destwarn->DWEMAIL),'','',LRTrim(_emlmail),'',LRTrim(_usrmail),LRTrim(_pwdmail),False,_prtmail,False,0,255,'','',False) */
        _esito = MailLibrary.sendMail(_testo,"TXT","Creazione automatica file 380",CPLib.LRTrim(_srvmail),CPLib.LRTrim(Cursor_destwarn.GetString("DWEMAIL")),"","",CPLib.LRTrim(_emlmail),"",CPLib.LRTrim(_usrmail),CPLib.LRTrim(_pwdmail),false,_prtmail,false,0,255,"","",false);
        Cursor_destwarn.Next();
      }
      m_cConnectivityError = Cursor_destwarn.ErrorMessage();
      Cursor_destwarn.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_destwarn!=null)
          Cursor_destwarn.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo) {
    pTipo = p_pTipo;
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
  public Forward Run(String p_pTipo) {
    pTipo = p_pTipo;
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
  public static arrt_cgo_chkdianaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_chkdianaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    _gPathApp = CPLib.Space(80);
    _gPathDoc = CPLib.Space(80);
    _gUrlApp = CPLib.Space(80);
    _gAzienda = CPLib.Space(10);
    _gMsgProc = "";
    _process = null;
    w_codcab = CPLib.Space(6);
    w_cabcod = CPLib.Space(6);
    w_desccit = CPLib.Space(30);
    w_citdesc = CPLib.Space(30);
    w_provin = CPLib.Space(2);
    w_provind = CPLib.Space(2);
    w_coddipe = CPLib.Space(6);
    w_agente = 0;
    _note = "";
    _rownum = 0;
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(15);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    nTotRec = 0;
    nTotReg = 0;
    nNumRec = 0;
    _avanza = 0;
    _codrif = CPLib.Space(16);
    w_cdadata = CPLib.Space(8);
    w_c_adata = CPLib.Space(8);
    w_cdadata_rap = CPLib.Space(8);
    w_c_adata_rap = CPLib.Space(8);
    w_cdareg_rap = CPLib.Space(8);
    w_c_areg_rap = CPLib.Space(8);
    _ctotale = 0;
    _conta = 0;
    _max = 0;
    _min = 0;
    _top = 0;
    _bottom = 0;
    _cicli = 0;
    _contacilci = 0;
    _flagrap = CPLib.Space(1);
    _ciclo = 0;
    _ramate = CPLib.Space(3);
    _numsto = CPLib.Space(15);
    _oldrighe = 0;
    _continua = 0;
    _oldrap = CPLib.Space(25);
    _idereg = CPLib.Space(20);
    xStato = CPLib.Space(1);
    _conta1 = 0;
    _conta2 = 0;
    _conta4 = 0;
    _conta5 = 0;
    _conta6 = 0;
    _conta7 = 0;
    _conta8 = 0;
    _conta9 = 0;
    _tiprec = CPLib.Space(1);
    _raeatc = CPLib.Space(1);
    oldfolder = CPLib.Space(120);
    _tipoag = CPLib.Space(10);
    _datage = CPLib.Space(44);
    _numticket = CPLib.Space(30);
    w_cdareg = CPLib.Space(8);
    w_c_areg = CPLib.Space(8);
    z_codcab = CPLib.Space(6);
    z_desccit = CPLib.Space(30);
    z_provin = CPLib.Space(2);
    z_coddipe = CPLib.Space(6);
    _sonummesi = 0;
    _somesiback = 0;
    _meseora = 0;
    _mesestart = 0;
    _meseend = 0;
    _yearora = 0;
    _yearini = 0;
    _yearend = 0;
    _datfine = CPLib.NullDate();
    _datiniz = CPLib.NullDate();
    _data = CPLib.NullDate();
    w_codage = CPLib.Space(6);
    w_codcli = CPLib.Space(10);
    w_stoper = CPLib.Space(1);
    w_flgrae = CPLib.Space(1);
    w_flgrap = CPLib.Space(1);
    w_tiprap = CPLib.Space(1);
    w_flgint = CPLib.Space(1);
    w_codinter = CPLib.Space(11);
    w_tipinter = CPLib.Space(2);
    w_ragben = CPLib.Space(70);
    w_flgdel = CPLib.Space(1);
    cRitorno = CPLib.Space(2);
    _oldazi = CPLib.Space(10);
    cProg = CPLib.Space(20);
    o_tot = 0;
    f_tot = 0;
    i_tot = 0;
    command = CPLib.Space(500);
    _soambiente = CPLib.Space(0);
    _soshellcmd = CPLib.Space(0);
    _mesecalc = CPLib.Space(2);
    _yearcalc = CPLib.Space(4);
    mcConnes = new MemoryCursor_mcconnes_mcrdef();
    mcPersonbo = new MemoryCursor_personbo();
    mcWersonbo = new MemoryCursor_wersonbo();
    mcANADIP = new MemoryCursor_anadip();
    mcRapporti = new MemoryCursor_qbe_rapd_chkdiana_cgo_vqr();
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
    _xlientiope = false;
    _xogopebo = false;
    _xeneficope = false;
    _xerzistiope = false;
    _xlientifrz = false;
    _xogopefbo = false;
    _xeneficfrz = false;
    _xerzistifrz = false;
    pCodDip = CPLib.Space(6);
    pCodCab = CPLib.Space(6);
    pDesCit = CPLib.Space(30);
    pProv = CPLib.Space(2);
    _diff = 0;
    _diff1 = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_rapd_chkdiana_cgo,qbe_oped_chkdiana_cli_cgo,qbe_rapd_chkdiana_cli,qbe_frad_chkdiana_cli_cgo,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_cgo_cf_scarico380,
  public static final String m_cVQRList = ",qbe_rapd_chkdiana_cgo,qbe_oped_chkdiana_cli_cgo,qbe_rapd_chkdiana_cli,qbe_frad_chkdiana_cli_cgo,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_cgo_cf_scarico380,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_calc_idereg,arfn_chkspers,arfn_dateminus,arfn_datidip_sol,arfn_datisog_sol,arfn_datisog_sol_mc,arfn_fdatetime,arfn_finemese,arfn_flaglire,arfn_mese_inifin,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_calc_idereg,arfn_chkspers,arfn_dateminus,arfn_datidip_sol,arfn_datisog_sol,arfn_datisog_sol_mc,arfn_fdatetime,arfn_finemese,arfn_flaglire,arfn_mese_inifin,arrt_writelog,";
  public static String[] m_cRunParameterNames={"pTipo"};
}
