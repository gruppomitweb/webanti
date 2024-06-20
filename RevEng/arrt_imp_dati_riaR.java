// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_ria
import java.io.File; 
import java.lang.Double;
import java.util.*;
import jxl.*;
// * --- Fine Area Manuale
public class arrt_imp_dati_riaR implements CallerWithObjs {
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
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopstor;
  public String m_cServer_aeopstor;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
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
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_joginfo;
  public String m_cServer_joginfo;
  public String m_cPhName_jogopebo;
  public String m_cServer_jogopebo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
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
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_rapotit;
  public String m_cServer_rapotit;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_titolabo;
  public String m_cServer_titolabo;
  public String m_cPhName_titopers;
  public String m_cServer_titopers;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xapotit;
  public String m_cServer_xapotit;
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
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_xersonbo;
  public String m_cServer_xersonbo;
  public String m_cPhName_xnadip;
  public String m_cServer_xnadip;
  public String m_cPhName_xarchope;
  public String m_cServer_xarchope;
  public String m_cPhName_xarchfraz;
  public String m_cServer_xarchfraz;
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
  public String w_tipodest;
  public double w_impzip;
  public double w_annorif;
  public String w_chkaui;
  public String w_imperr;
  public String w_creamo;
  public double w_fscarti;
  public double _z;
  public String fhand;
  public String ohand;
  public String zhand;
  public String xhand;
  public String shand;
  public String riga;
  public String xConnes;
  public String _tdest;
  public String xCF;
  public String xSOCTCon;
  public String xSOCTCF;
  public String xCodCab;
  public String xCitta;
  public String cCliProg;
  public String cInfProg1;
  public String cInfProg2;
  public String cOpeProg1;
  public String cOpeProg2;
  public String xSesso;
  public String xRapporto;
  public String xCAB;
  public String xPrv;
  public String xDIP;
  public String xDIPx;
  public String cCli1;
  public String xIDB;
  public String xData;
  public String xDatF;
  public double cNumNew;
  public double cNumMod;
  public double cNumInv;
  public String cFlagLire;
  public String cFlagCont;
  public String cFlagFraz;
  public double cMaxRow;
  public String cIdCau;
  public double xCFE;
  public double conta;
  public double _esito;
  public String cSNAS;
  public String cCNAS;
  public String _unicode;
  public double _salta;
  public double nProgImp;
  public double nProgImp2;
  public double nProgSto;
  public String _idbase;
  public String _codinter;
  public String _citinter;
  public String _cabinter;
  public String _prvinter;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
  public String _tipper;
  public String _benrag;
  public String _bensta;
  public String _bencta;
  public String _bencab;
  public String _benprv;
  public String _benind;
  public String _bencap;
  public String _flgmodi;
  public String _conadd;
  public java.sql.Date _datareg;
  public java.sql.Date _dataope;
  public java.sql.Date _datvarage;
  public double _flgdataim;
  public double _chkerr;
  public String _rifimp;
  public String _oldidb;
  public String stringaflagrap2;
  public String _statoreg;
  public java.sql.Date _datarett;
  public String _flagrap2;
  public String _idreg;
  public double _findsub;
  public double _opeerr;
  public double _frzerr;
  public double _opxerr;
  public double _soxerr;
  public String _numprog;
  public String _colleg;
  public String _frapcli;
  public String _tiporap;
  public String _czip;
  public String cNomeFileZip;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String _file1;
  public String _file2;
  public String _descerr;
  public double _oldest;
  public double _newest;
  public String _idb2;
  public String ciidbase;
  public java.sql.Date cidataini;
  public java.sql.Date cidatafine;
  public String cicodinter;
  public String cinumprog;
  public String citiporap;
  public String czipfile;
  public String cpercorsozip;
  public String cdirectoryfile;
  public String buffernomefile;
  public String nomefileimport;
  public double _priorita;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public String column05;
  public String column06;
  public String column07;
  public String column08;
  public String column09;
  public String column10;
  public String column11;
  public String column12;
  public String column13;
  public String column14;
  public String column15;
  public String column16;
  public String column17;
  public String column18;
  public String column19;
  public String column20;
  public String column21;
  public String column22;
  public String column23;
  public String column24;
  public String column25;
  public String column26;
  public String column27;
  public String column28;
  public String column29;
  public String column30;
  public String column31;
  public String column32;
  public String column33;
  public String column34;
  public String column35;
  public String column36;
  public String column37;
  public String column38;
  public String column39;
  public String column40;
  public String column41;
  public String column42;
  public String column43;
  public String column44;
  public String column45;
  public String column46;
  public String column47;
  public String column48;
  public String column49;
  public String column50;
  public String column51;
  public String column52;
  public String column53;
  public String column54;
  public String column55;
  public String column56;
  public String column57;
  public String column58;
  public String column59;
  public String column60;
  public String column61;
  public String column62;
  public String column63;
  public String column64;
  public String column65;
  public String column66;
  public String column67;
  public String gPathApp;
  public String gAzienda;
  public String gUrlApp;
  public String gMsgImp;
  public String gMsgProc;
  public String gFlgRet;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_ria
  public String[] lista;
  public int conteggio;
  public int i;
  public int _i;
  public int _y;
  public int contanome;
  public int _righe;
  public int _conta;
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_imp_dati_riaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_ria",m_Caller);
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeopstor = p_ContextObject.GetPhName("aeopstor");
    if (m_cPhName_aeopstor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopstor = m_cPhName_aeopstor+" "+m_Ctx.GetWritePhName("aeopstor");
    }
    m_cServer_aeopstor = p_ContextObject.GetServer("aeopstor");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
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
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
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
    m_cPhName_japopebo = p_ContextObject.GetPhName("japopebo");
    if (m_cPhName_japopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_japopebo = m_cPhName_japopebo+" "+m_Ctx.GetWritePhName("japopebo");
    }
    m_cServer_japopebo = p_ContextObject.GetServer("japopebo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_joginfo = p_ContextObject.GetPhName("joginfo");
    if (m_cPhName_joginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_joginfo = m_cPhName_joginfo+" "+m_Ctx.GetWritePhName("joginfo");
    }
    m_cServer_joginfo = p_ContextObject.GetServer("joginfo");
    m_cPhName_jogopebo = p_ContextObject.GetPhName("jogopebo");
    if (m_cPhName_jogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jogopebo = m_cPhName_jogopebo+" "+m_Ctx.GetWritePhName("jogopebo");
    }
    m_cServer_jogopebo = p_ContextObject.GetServer("jogopebo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
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
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
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
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
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
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
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
    m_cPhName_titolabo = p_ContextObject.GetPhName("titolabo");
    if (m_cPhName_titolabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_titolabo = m_cPhName_titolabo+" "+m_Ctx.GetWritePhName("titolabo");
    }
    m_cServer_titolabo = p_ContextObject.GetServer("titolabo");
    m_cPhName_titopers = p_ContextObject.GetPhName("titopers");
    if (m_cPhName_titopers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_titopers = m_cPhName_titopers+" "+m_Ctx.GetWritePhName("titopers");
    }
    m_cServer_titopers = p_ContextObject.GetServer("titopers");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
      m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
      if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
      }
      m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    }
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
    m_cPhName_xapotit = p_ContextObject.GetPhName("xapotit");
    if (m_cPhName_xapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapotit = m_cPhName_xapotit+" "+m_Ctx.GetWritePhName("xapotit");
    }
    m_cServer_xapotit = p_ContextObject.GetServer("xapotit");
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
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
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
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_xersonbo = p_ContextObject.GetPhName("xersonbo");
    if (m_cPhName_xersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xersonbo = m_cPhName_xersonbo+" "+m_Ctx.GetWritePhName("xersonbo");
    }
    m_cServer_xersonbo = p_ContextObject.GetServer("xersonbo");
    m_cPhName_xnadip = p_ContextObject.GetPhName("xnadip");
    if (m_cPhName_xnadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnadip = m_cPhName_xnadip+" "+m_Ctx.GetWritePhName("xnadip");
    }
    m_cServer_xnadip = p_ContextObject.GetServer("xnadip");
    m_cPhName_xarchope = p_ContextObject.GetPhName("xarchope");
    if (m_cPhName_xarchope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xarchope = m_cPhName_xarchope+" "+m_Ctx.GetWritePhName("xarchope");
    }
    m_cServer_xarchope = p_ContextObject.GetServer("xarchope");
    m_cPhName_xarchfraz = p_ContextObject.GetPhName("xarchfraz");
    if (m_cPhName_xarchfraz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xarchfraz = m_cPhName_xarchfraz+" "+m_Ctx.GetWritePhName("xarchfraz");
    }
    m_cServer_xarchfraz = p_ContextObject.GetServer("xarchfraz");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
    if (CPLib.eqr("annorif",p_cVarName)) {
      return w_annorif;
    }
    if (CPLib.eqr("fscarti",p_cVarName)) {
      return w_fscarti;
    }
    if (CPLib.eqr("_z",p_cVarName)) {
      return _z;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      return cNumMod;
    }
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      return cNumInv;
    }
    if (CPLib.eqr("cMaxRow",p_cVarName)) {
      return cMaxRow;
    }
    if (CPLib.eqr("xCFE",p_cVarName)) {
      return xCFE;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_salta",p_cVarName)) {
      return _salta;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      return nProgImp2;
    }
    if (CPLib.eqr("nProgSto",p_cVarName)) {
      return nProgSto;
    }
    if (CPLib.eqr("_flgdataim",p_cVarName)) {
      return _flgdataim;
    }
    if (CPLib.eqr("_chkerr",p_cVarName)) {
      return _chkerr;
    }
    if (CPLib.eqr("_findsub",p_cVarName)) {
      return _findsub;
    }
    if (CPLib.eqr("_opeerr",p_cVarName)) {
      return _opeerr;
    }
    if (CPLib.eqr("_frzerr",p_cVarName)) {
      return _frzerr;
    }
    if (CPLib.eqr("_opxerr",p_cVarName)) {
      return _opxerr;
    }
    if (CPLib.eqr("_soxerr",p_cVarName)) {
      return _soxerr;
    }
    if (CPLib.eqr("_oldest",p_cVarName)) {
      return _oldest;
    }
    if (CPLib.eqr("_newest",p_cVarName)) {
      return _newest;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      return _priorita;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_ria";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("chkaui",p_cVarName)) {
      return w_chkaui;
    }
    if (CPLib.eqr("imperr",p_cVarName)) {
      return w_imperr;
    }
    if (CPLib.eqr("creamo",p_cVarName)) {
      return w_creamo;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("ohand",p_cVarName)) {
      return ohand;
    }
    if (CPLib.eqr("zhand",p_cVarName)) {
      return zhand;
    }
    if (CPLib.eqr("xhand",p_cVarName)) {
      return xhand;
    }
    if (CPLib.eqr("shand",p_cVarName)) {
      return shand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      return _tdest;
    }
    if (CPLib.eqr("xCF",p_cVarName)) {
      return xCF;
    }
    if (CPLib.eqr("xSOCTCon",p_cVarName)) {
      return xSOCTCon;
    }
    if (CPLib.eqr("xSOCTCF",p_cVarName)) {
      return xSOCTCF;
    }
    if (CPLib.eqr("xCodCab",p_cVarName)) {
      return xCodCab;
    }
    if (CPLib.eqr("xCitta",p_cVarName)) {
      return xCitta;
    }
    if (CPLib.eqr("cCliProg",p_cVarName)) {
      return cCliProg;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      return cInfProg1;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      return cInfProg2;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      return cOpeProg1;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      return cOpeProg2;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      return xSesso;
    }
    if (CPLib.eqr("xRapporto",p_cVarName)) {
      return xRapporto;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      return xCAB;
    }
    if (CPLib.eqr("xPrv",p_cVarName)) {
      return xPrv;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      return xDIP;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      return xDIPx;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      return cCli1;
    }
    if (CPLib.eqr("xIDB",p_cVarName)) {
      return xIDB;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      return xData;
    }
    if (CPLib.eqr("xDatF",p_cVarName)) {
      return xDatF;
    }
    if (CPLib.eqr("cFlagLire",p_cVarName)) {
      return cFlagLire;
    }
    if (CPLib.eqr("cFlagCont",p_cVarName)) {
      return cFlagCont;
    }
    if (CPLib.eqr("cFlagFraz",p_cVarName)) {
      return cFlagFraz;
    }
    if (CPLib.eqr("cIdCau",p_cVarName)) {
      return cIdCau;
    }
    if (CPLib.eqr("cSNAS",p_cVarName)) {
      return cSNAS;
    }
    if (CPLib.eqr("cCNAS",p_cVarName)) {
      return cCNAS;
    }
    if (CPLib.eqr("_unicode",p_cVarName)) {
      return _unicode;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      return _codinter;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      return _citinter;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      return _cabinter;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      return _prvinter;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      return _intercod;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      return _intercit;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      return _intercab;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      return _interprv;
    }
    if (CPLib.eqr("_tipper",p_cVarName)) {
      return _tipper;
    }
    if (CPLib.eqr("_benrag",p_cVarName)) {
      return _benrag;
    }
    if (CPLib.eqr("_bensta",p_cVarName)) {
      return _bensta;
    }
    if (CPLib.eqr("_bencta",p_cVarName)) {
      return _bencta;
    }
    if (CPLib.eqr("_bencab",p_cVarName)) {
      return _bencab;
    }
    if (CPLib.eqr("_benprv",p_cVarName)) {
      return _benprv;
    }
    if (CPLib.eqr("_benind",p_cVarName)) {
      return _benind;
    }
    if (CPLib.eqr("_bencap",p_cVarName)) {
      return _bencap;
    }
    if (CPLib.eqr("_flgmodi",p_cVarName)) {
      return _flgmodi;
    }
    if (CPLib.eqr("_conadd",p_cVarName)) {
      return _conadd;
    }
    if (CPLib.eqr("_rifimp",p_cVarName)) {
      return _rifimp;
    }
    if (CPLib.eqr("_oldidb",p_cVarName)) {
      return _oldidb;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      return stringaflagrap2;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      return _statoreg;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_colleg",p_cVarName)) {
      return _colleg;
    }
    if (CPLib.eqr("_frapcli",p_cVarName)) {
      return _frapcli;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      return _tiporap;
    }
    if (CPLib.eqr("_czip",p_cVarName)) {
      return _czip;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      return _file1;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
    }
    if (CPLib.eqr("_descerr",p_cVarName)) {
      return _descerr;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("ciidbase",p_cVarName)) {
      return ciidbase;
    }
    if (CPLib.eqr("cicodinter",p_cVarName)) {
      return cicodinter;
    }
    if (CPLib.eqr("cinumprog",p_cVarName)) {
      return cinumprog;
    }
    if (CPLib.eqr("citiporap",p_cVarName)) {
      return citiporap;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      return czipfile;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      return cpercorsozip;
    }
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      return cdirectoryfile;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      return buffernomefile;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      return column01;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      return column02;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      return column03;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      return column04;
    }
    if (CPLib.eqr("column05",p_cVarName)) {
      return column05;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      return column06;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      return column07;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      return column08;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      return column09;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      return column10;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      return column11;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      return column12;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      return column13;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      return column14;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      return column15;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      return column16;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      return column17;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      return column18;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      return column19;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      return column20;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      return column21;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      return column22;
    }
    if (CPLib.eqr("column23",p_cVarName)) {
      return column23;
    }
    if (CPLib.eqr("column24",p_cVarName)) {
      return column24;
    }
    if (CPLib.eqr("column25",p_cVarName)) {
      return column25;
    }
    if (CPLib.eqr("column26",p_cVarName)) {
      return column26;
    }
    if (CPLib.eqr("column27",p_cVarName)) {
      return column27;
    }
    if (CPLib.eqr("column28",p_cVarName)) {
      return column28;
    }
    if (CPLib.eqr("column29",p_cVarName)) {
      return column29;
    }
    if (CPLib.eqr("column30",p_cVarName)) {
      return column30;
    }
    if (CPLib.eqr("column31",p_cVarName)) {
      return column31;
    }
    if (CPLib.eqr("column32",p_cVarName)) {
      return column32;
    }
    if (CPLib.eqr("column33",p_cVarName)) {
      return column33;
    }
    if (CPLib.eqr("column34",p_cVarName)) {
      return column34;
    }
    if (CPLib.eqr("column35",p_cVarName)) {
      return column35;
    }
    if (CPLib.eqr("column36",p_cVarName)) {
      return column36;
    }
    if (CPLib.eqr("column37",p_cVarName)) {
      return column37;
    }
    if (CPLib.eqr("column38",p_cVarName)) {
      return column38;
    }
    if (CPLib.eqr("column39",p_cVarName)) {
      return column39;
    }
    if (CPLib.eqr("column40",p_cVarName)) {
      return column40;
    }
    if (CPLib.eqr("column41",p_cVarName)) {
      return column41;
    }
    if (CPLib.eqr("column42",p_cVarName)) {
      return column42;
    }
    if (CPLib.eqr("column43",p_cVarName)) {
      return column43;
    }
    if (CPLib.eqr("column44",p_cVarName)) {
      return column44;
    }
    if (CPLib.eqr("column45",p_cVarName)) {
      return column45;
    }
    if (CPLib.eqr("column46",p_cVarName)) {
      return column46;
    }
    if (CPLib.eqr("column47",p_cVarName)) {
      return column47;
    }
    if (CPLib.eqr("column48",p_cVarName)) {
      return column48;
    }
    if (CPLib.eqr("column49",p_cVarName)) {
      return column49;
    }
    if (CPLib.eqr("column50",p_cVarName)) {
      return column50;
    }
    if (CPLib.eqr("column51",p_cVarName)) {
      return column51;
    }
    if (CPLib.eqr("column52",p_cVarName)) {
      return column52;
    }
    if (CPLib.eqr("column53",p_cVarName)) {
      return column53;
    }
    if (CPLib.eqr("column54",p_cVarName)) {
      return column54;
    }
    if (CPLib.eqr("column55",p_cVarName)) {
      return column55;
    }
    if (CPLib.eqr("column56",p_cVarName)) {
      return column56;
    }
    if (CPLib.eqr("column57",p_cVarName)) {
      return column57;
    }
    if (CPLib.eqr("column58",p_cVarName)) {
      return column58;
    }
    if (CPLib.eqr("column59",p_cVarName)) {
      return column59;
    }
    if (CPLib.eqr("column60",p_cVarName)) {
      return column60;
    }
    if (CPLib.eqr("column61",p_cVarName)) {
      return column61;
    }
    if (CPLib.eqr("column62",p_cVarName)) {
      return column62;
    }
    if (CPLib.eqr("column63",p_cVarName)) {
      return column63;
    }
    if (CPLib.eqr("column64",p_cVarName)) {
      return column64;
    }
    if (CPLib.eqr("column65",p_cVarName)) {
      return column65;
    }
    if (CPLib.eqr("column66",p_cVarName)) {
      return column66;
    }
    if (CPLib.eqr("column67",p_cVarName)) {
      return column67;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("gFlgRet",p_cVarName)) {
      return gFlgRet;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datareg",p_cVarName)) {
      return _datareg;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
    }
    if (CPLib.eqr("_datvarage",p_cVarName)) {
      return _datvarage;
    }
    if (CPLib.eqr("_datarett",p_cVarName)) {
      return _datarett;
    }
    if (CPLib.eqr("cidataini",p_cVarName)) {
      return cidataini;
    }
    if (CPLib.eqr("cidatafine",p_cVarName)) {
      return cidatafine;
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
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
      return;
    }
    if (CPLib.eqr("annorif",p_cVarName)) {
      w_annorif = value;
      return;
    }
    if (CPLib.eqr("fscarti",p_cVarName)) {
      w_fscarti = value;
      return;
    }
    if (CPLib.eqr("_z",p_cVarName)) {
      _z = value;
      return;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("cNumMod",p_cVarName)) {
      cNumMod = value;
      return;
    }
    if (CPLib.eqr("cNumInv",p_cVarName)) {
      cNumInv = value;
      return;
    }
    if (CPLib.eqr("cMaxRow",p_cVarName)) {
      cMaxRow = value;
      return;
    }
    if (CPLib.eqr("xCFE",p_cVarName)) {
      xCFE = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_salta",p_cVarName)) {
      _salta = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      nProgImp2 = value;
      return;
    }
    if (CPLib.eqr("nProgSto",p_cVarName)) {
      nProgSto = value;
      return;
    }
    if (CPLib.eqr("_flgdataim",p_cVarName)) {
      _flgdataim = value;
      return;
    }
    if (CPLib.eqr("_chkerr",p_cVarName)) {
      _chkerr = value;
      return;
    }
    if (CPLib.eqr("_findsub",p_cVarName)) {
      _findsub = value;
      return;
    }
    if (CPLib.eqr("_opeerr",p_cVarName)) {
      _opeerr = value;
      return;
    }
    if (CPLib.eqr("_frzerr",p_cVarName)) {
      _frzerr = value;
      return;
    }
    if (CPLib.eqr("_opxerr",p_cVarName)) {
      _opxerr = value;
      return;
    }
    if (CPLib.eqr("_soxerr",p_cVarName)) {
      _soxerr = value;
      return;
    }
    if (CPLib.eqr("_oldest",p_cVarName)) {
      _oldest = value;
      return;
    }
    if (CPLib.eqr("_newest",p_cVarName)) {
      _newest = value;
      return;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("chkaui",p_cVarName)) {
      w_chkaui = value;
      return;
    }
    if (CPLib.eqr("imperr",p_cVarName)) {
      w_imperr = value;
      return;
    }
    if (CPLib.eqr("creamo",p_cVarName)) {
      w_creamo = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("ohand",p_cVarName)) {
      ohand = value;
      return;
    }
    if (CPLib.eqr("zhand",p_cVarName)) {
      zhand = value;
      return;
    }
    if (CPLib.eqr("xhand",p_cVarName)) {
      xhand = value;
      return;
    }
    if (CPLib.eqr("shand",p_cVarName)) {
      shand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
      return;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      _tdest = value;
      return;
    }
    if (CPLib.eqr("xCF",p_cVarName)) {
      xCF = value;
      return;
    }
    if (CPLib.eqr("xSOCTCon",p_cVarName)) {
      xSOCTCon = value;
      return;
    }
    if (CPLib.eqr("xSOCTCF",p_cVarName)) {
      xSOCTCF = value;
      return;
    }
    if (CPLib.eqr("xCodCab",p_cVarName)) {
      xCodCab = value;
      return;
    }
    if (CPLib.eqr("xCitta",p_cVarName)) {
      xCitta = value;
      return;
    }
    if (CPLib.eqr("cCliProg",p_cVarName)) {
      cCliProg = value;
      return;
    }
    if (CPLib.eqr("cInfProg1",p_cVarName)) {
      cInfProg1 = value;
      return;
    }
    if (CPLib.eqr("cInfProg2",p_cVarName)) {
      cInfProg2 = value;
      return;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      cOpeProg1 = value;
      return;
    }
    if (CPLib.eqr("cOpeProg2",p_cVarName)) {
      cOpeProg2 = value;
      return;
    }
    if (CPLib.eqr("xSesso",p_cVarName)) {
      xSesso = value;
      return;
    }
    if (CPLib.eqr("xRapporto",p_cVarName)) {
      xRapporto = value;
      return;
    }
    if (CPLib.eqr("xCAB",p_cVarName)) {
      xCAB = value;
      return;
    }
    if (CPLib.eqr("xPrv",p_cVarName)) {
      xPrv = value;
      return;
    }
    if (CPLib.eqr("xDIP",p_cVarName)) {
      xDIP = value;
      return;
    }
    if (CPLib.eqr("xDIPx",p_cVarName)) {
      xDIPx = value;
      return;
    }
    if (CPLib.eqr("cCli1",p_cVarName)) {
      cCli1 = value;
      return;
    }
    if (CPLib.eqr("xIDB",p_cVarName)) {
      xIDB = value;
      return;
    }
    if (CPLib.eqr("xData",p_cVarName)) {
      xData = value;
      return;
    }
    if (CPLib.eqr("xDatF",p_cVarName)) {
      xDatF = value;
      return;
    }
    if (CPLib.eqr("cFlagLire",p_cVarName)) {
      cFlagLire = value;
      return;
    }
    if (CPLib.eqr("cFlagCont",p_cVarName)) {
      cFlagCont = value;
      return;
    }
    if (CPLib.eqr("cFlagFraz",p_cVarName)) {
      cFlagFraz = value;
      return;
    }
    if (CPLib.eqr("cIdCau",p_cVarName)) {
      cIdCau = value;
      return;
    }
    if (CPLib.eqr("cSNAS",p_cVarName)) {
      cSNAS = value;
      return;
    }
    if (CPLib.eqr("cCNAS",p_cVarName)) {
      cCNAS = value;
      return;
    }
    if (CPLib.eqr("_unicode",p_cVarName)) {
      _unicode = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
      return;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      _codinter = value;
      return;
    }
    if (CPLib.eqr("_citinter",p_cVarName)) {
      _citinter = value;
      return;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      _cabinter = value;
      return;
    }
    if (CPLib.eqr("_prvinter",p_cVarName)) {
      _prvinter = value;
      return;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      _intercod = value;
      return;
    }
    if (CPLib.eqr("_intercit",p_cVarName)) {
      _intercit = value;
      return;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      _intercab = value;
      return;
    }
    if (CPLib.eqr("_interprv",p_cVarName)) {
      _interprv = value;
      return;
    }
    if (CPLib.eqr("_tipper",p_cVarName)) {
      _tipper = value;
      return;
    }
    if (CPLib.eqr("_benrag",p_cVarName)) {
      _benrag = value;
      return;
    }
    if (CPLib.eqr("_bensta",p_cVarName)) {
      _bensta = value;
      return;
    }
    if (CPLib.eqr("_bencta",p_cVarName)) {
      _bencta = value;
      return;
    }
    if (CPLib.eqr("_bencab",p_cVarName)) {
      _bencab = value;
      return;
    }
    if (CPLib.eqr("_benprv",p_cVarName)) {
      _benprv = value;
      return;
    }
    if (CPLib.eqr("_benind",p_cVarName)) {
      _benind = value;
      return;
    }
    if (CPLib.eqr("_bencap",p_cVarName)) {
      _bencap = value;
      return;
    }
    if (CPLib.eqr("_flgmodi",p_cVarName)) {
      _flgmodi = value;
      return;
    }
    if (CPLib.eqr("_conadd",p_cVarName)) {
      _conadd = value;
      return;
    }
    if (CPLib.eqr("_rifimp",p_cVarName)) {
      _rifimp = value;
      return;
    }
    if (CPLib.eqr("_oldidb",p_cVarName)) {
      _oldidb = value;
      return;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      stringaflagrap2 = value;
      return;
    }
    if (CPLib.eqr("_statoreg",p_cVarName)) {
      _statoreg = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_colleg",p_cVarName)) {
      _colleg = value;
      return;
    }
    if (CPLib.eqr("_frapcli",p_cVarName)) {
      _frapcli = value;
      return;
    }
    if (CPLib.eqr("_tiporap",p_cVarName)) {
      _tiporap = value;
      return;
    }
    if (CPLib.eqr("_czip",p_cVarName)) {
      _czip = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
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
    if (CPLib.eqr("_file1",p_cVarName)) {
      _file1 = value;
      return;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      _file2 = value;
      return;
    }
    if (CPLib.eqr("_descerr",p_cVarName)) {
      _descerr = value;
      return;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("ciidbase",p_cVarName)) {
      ciidbase = value;
      return;
    }
    if (CPLib.eqr("cicodinter",p_cVarName)) {
      cicodinter = value;
      return;
    }
    if (CPLib.eqr("cinumprog",p_cVarName)) {
      cinumprog = value;
      return;
    }
    if (CPLib.eqr("citiporap",p_cVarName)) {
      citiporap = value;
      return;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      czipfile = value;
      return;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      cpercorsozip = value;
      return;
    }
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      cdirectoryfile = value;
      return;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      buffernomefile = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
      return;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      column01 = value;
      return;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      column02 = value;
      return;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      column03 = value;
      return;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      column04 = value;
      return;
    }
    if (CPLib.eqr("column05",p_cVarName)) {
      column05 = value;
      return;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      column06 = value;
      return;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      column07 = value;
      return;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      column08 = value;
      return;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      column09 = value;
      return;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      column10 = value;
      return;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      column11 = value;
      return;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      column12 = value;
      return;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      column13 = value;
      return;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      column14 = value;
      return;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      column15 = value;
      return;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      column16 = value;
      return;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      column17 = value;
      return;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      column18 = value;
      return;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      column19 = value;
      return;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      column20 = value;
      return;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      column21 = value;
      return;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      column22 = value;
      return;
    }
    if (CPLib.eqr("column23",p_cVarName)) {
      column23 = value;
      return;
    }
    if (CPLib.eqr("column24",p_cVarName)) {
      column24 = value;
      return;
    }
    if (CPLib.eqr("column25",p_cVarName)) {
      column25 = value;
      return;
    }
    if (CPLib.eqr("column26",p_cVarName)) {
      column26 = value;
      return;
    }
    if (CPLib.eqr("column27",p_cVarName)) {
      column27 = value;
      return;
    }
    if (CPLib.eqr("column28",p_cVarName)) {
      column28 = value;
      return;
    }
    if (CPLib.eqr("column29",p_cVarName)) {
      column29 = value;
      return;
    }
    if (CPLib.eqr("column30",p_cVarName)) {
      column30 = value;
      return;
    }
    if (CPLib.eqr("column31",p_cVarName)) {
      column31 = value;
      return;
    }
    if (CPLib.eqr("column32",p_cVarName)) {
      column32 = value;
      return;
    }
    if (CPLib.eqr("column33",p_cVarName)) {
      column33 = value;
      return;
    }
    if (CPLib.eqr("column34",p_cVarName)) {
      column34 = value;
      return;
    }
    if (CPLib.eqr("column35",p_cVarName)) {
      column35 = value;
      return;
    }
    if (CPLib.eqr("column36",p_cVarName)) {
      column36 = value;
      return;
    }
    if (CPLib.eqr("column37",p_cVarName)) {
      column37 = value;
      return;
    }
    if (CPLib.eqr("column38",p_cVarName)) {
      column38 = value;
      return;
    }
    if (CPLib.eqr("column39",p_cVarName)) {
      column39 = value;
      return;
    }
    if (CPLib.eqr("column40",p_cVarName)) {
      column40 = value;
      return;
    }
    if (CPLib.eqr("column41",p_cVarName)) {
      column41 = value;
      return;
    }
    if (CPLib.eqr("column42",p_cVarName)) {
      column42 = value;
      return;
    }
    if (CPLib.eqr("column43",p_cVarName)) {
      column43 = value;
      return;
    }
    if (CPLib.eqr("column44",p_cVarName)) {
      column44 = value;
      return;
    }
    if (CPLib.eqr("column45",p_cVarName)) {
      column45 = value;
      return;
    }
    if (CPLib.eqr("column46",p_cVarName)) {
      column46 = value;
      return;
    }
    if (CPLib.eqr("column47",p_cVarName)) {
      column47 = value;
      return;
    }
    if (CPLib.eqr("column48",p_cVarName)) {
      column48 = value;
      return;
    }
    if (CPLib.eqr("column49",p_cVarName)) {
      column49 = value;
      return;
    }
    if (CPLib.eqr("column50",p_cVarName)) {
      column50 = value;
      return;
    }
    if (CPLib.eqr("column51",p_cVarName)) {
      column51 = value;
      return;
    }
    if (CPLib.eqr("column52",p_cVarName)) {
      column52 = value;
      return;
    }
    if (CPLib.eqr("column53",p_cVarName)) {
      column53 = value;
      return;
    }
    if (CPLib.eqr("column54",p_cVarName)) {
      column54 = value;
      return;
    }
    if (CPLib.eqr("column55",p_cVarName)) {
      column55 = value;
      return;
    }
    if (CPLib.eqr("column56",p_cVarName)) {
      column56 = value;
      return;
    }
    if (CPLib.eqr("column57",p_cVarName)) {
      column57 = value;
      return;
    }
    if (CPLib.eqr("column58",p_cVarName)) {
      column58 = value;
      return;
    }
    if (CPLib.eqr("column59",p_cVarName)) {
      column59 = value;
      return;
    }
    if (CPLib.eqr("column60",p_cVarName)) {
      column60 = value;
      return;
    }
    if (CPLib.eqr("column61",p_cVarName)) {
      column61 = value;
      return;
    }
    if (CPLib.eqr("column62",p_cVarName)) {
      column62 = value;
      return;
    }
    if (CPLib.eqr("column63",p_cVarName)) {
      column63 = value;
      return;
    }
    if (CPLib.eqr("column64",p_cVarName)) {
      column64 = value;
      return;
    }
    if (CPLib.eqr("column65",p_cVarName)) {
      column65 = value;
      return;
    }
    if (CPLib.eqr("column66",p_cVarName)) {
      column66 = value;
      return;
    }
    if (CPLib.eqr("column67",p_cVarName)) {
      column67 = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("gFlgRet",p_cVarName)) {
      gFlgRet = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datareg",p_cVarName)) {
      _datareg = value;
      return;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
      return;
    }
    if (CPLib.eqr("_datvarage",p_cVarName)) {
      _datvarage = value;
      return;
    }
    if (CPLib.eqr("_datarett",p_cVarName)) {
      _datarett = value;
      return;
    }
    if (CPLib.eqr("cidataini",p_cVarName)) {
      cidataini = value;
      return;
    }
    if (CPLib.eqr("cidatafine",p_cVarName)) {
      cidatafine = value;
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
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* w_tipodest Char(1) */
      /* w_impzip Numeric(1, 0) */
      /* w_annorif Numeric(4, 0) */
      /* w_chkaui Char(1) */
      /* w_imperr Char(1) */
      /* w_creamo Char(1) */
      /* w_fscarti Numeric(1, 0) */
      /* _z Numeric(10, 0) */
      /* fhand Char(1) */
      /* ohand Char(1) */
      /* zhand Char(1) */
      /* xhand Char(1) */
      /* shand Char(1) */
      /* riga Memo */
      /* xConnes Char(16) */
      /* _tdest Char(1) */
      /* xCF Char(16) */
      /* xSOCTCon Char(16) */
      /* xSOCTCF Char(16) */
      /* xCodCab Char(6) */
      /* xCitta Char(30) */
      /* cCliProg Char(6) */
      /* cInfProg1 Char(10) */
      /* cInfProg2 Char(11) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* xSesso Char(1) */
      /* xRapporto Char(25) */
      /* xCAB Char(6) */
      /* xPrv Char(2) */
      /* xDIP Char(6) */
      /* xDIPx Char(6) */
      /* cCli1 Char(16) */
      /* xIDB Char(10) */
      /* xData Char(8) */
      /* xDatF Char(8) */
      /* cNumNew Numeric(10, 0) // Contatore record nuovi */
      /* cNumMod Numeric(10, 0) // Contatore record aggiornati */
      /* cNumInv Numeric(10, 0) // Contatore record invariati */
      /* cFlagLire Char(1) */
      /* cFlagCont Char(1) */
      /* cFlagFraz Char(1) */
      /* cMaxRow Numeric(4, 0) */
      /* cIdCau Char(4) */
      /* xCFE Numeric(1, 0) */
      /* conta Numeric(10, 0) */
      /* _esito Numeric(1, 0) */
      /* cSNAS Char(30) */
      /* cCNAS Char(30) */
      /* _unicode Char(10) */
      /* _salta Numeric(1, 0) */
      /* nProgImp Numeric(15, 0) */
      /* nProgImp2 Numeric(15, 0) */
      /* nProgSto Numeric(10, 0) */
      /* _idbase Char(10) */
      /* _codinter Char(11) */
      /* _citinter Char(30) */
      /* _cabinter Char(6) */
      /* _prvinter Char(2) */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
      /* _tipper Char(1) */
      /* _benrag Char(70) */
      /* _bensta Char(3) */
      /* _bencta Char(30) */
      /* _bencab Char(6) */
      /* _benprv Char(2) */
      /* _benind Char(35) */
      /* _bencap Char(5) */
      /* _flgmodi Char(1) */
      /* _conadd Char(16) */
      /* _datareg Date */
      /* _dataope Date */
      /* _datvarage Date */
      /* _flgdataim Numeric(1, 0) */
      /* _chkerr Numeric(1, 0) */
      /* _rifimp Char(11) */
      /* _oldidb Char(10) */
      /* stringaflagrap2 Char(9) // stringa di valori di flagrap2 */
      /* _statoreg Char(1) */
      /* _datarett Date */
      /* _flagrap2 Char(1) */
      /* _idreg Char(20) */
      /* _findsub Numeric(1, 0) */
      /* _opeerr Numeric(1, 0) */
      /* _frzerr Numeric(1, 0) */
      /* _opxerr Numeric(1, 0) */
      /* _soxerr Numeric(1, 0) */
      /* _numprog Char(11) */
      /* _colleg Char(12) */
      /* _frapcli Char(1) */
      /* _tiporap Char(1) */
      /* _czip Char(20) */
      /* cNomeFileZip Char(30) */
      /* cNomeFile Char(30) */
      /* cOnlyNomeFile Char(30) */
      /* _file1 Char(30) */
      /* _file2 Char(30) */
      /* _descerr Char(50) */
      /* _oldest Numeric(1, 0) */
      /* _newest Numeric(1, 0) */
      /* _idb2 Char(10) */
      /* ciidbase Char(10) */
      /* cidataini Date */
      /* cidatafine Date */
      /* cicodinter Char(12) */
      /* cinumprog Char(11) */
      /* citiporap Char(1) */
      /* czipfile Char(100) */
      /* cpercorsozip Char(200) */
      /* cdirectoryfile Char(200) */
      /* buffernomefile Char(100) */
      /* nomefileimport Char(50) */
      /* _priorita Numeric(3, 0) */
      /* column01 Char(25) */
      /* column02 Char(25) */
      /* column03 Char(25) */
      /* column04 Char(25) */
      /* column05 Char(25) */
      /* column06 Char(25) */
      /* column07 Char(25) */
      /* column08 Char(25) */
      /* column09 Char(25) */
      /* column10 Char(25) */
      /* column11 Char(25) */
      /* column12 Char(25) */
      /* column13 Char(25) */
      /* column14 Char(25) */
      /* column15 Char(25) */
      /* column16 Char(25) */
      /* column17 Char(25) */
      /* column18 Char(25) */
      /* column19 Char(25) */
      /* column20 Char(25) */
      /* column21 Char(25) */
      /* column22 Char(25) */
      /* column23 Char(25) */
      /* column24 Char(25) */
      /* column25 Char(25) */
      /* column26 Char(25) */
      /* column27 Char(25) */
      /* column28 Char(25) */
      /* column29 Char(25) */
      /* column30 Char(25) */
      /* column31 Char(25) */
      /* column32 Char(25) */
      /* column33 Char(25) */
      /* column34 Char(25) */
      /* column35 Char(25) */
      /* column36 Char(25) */
      /* column37 Char(25) */
      /* column38 Char(25) */
      /* column39 Char(25) */
      /* column40 Char(25) */
      /* column41 Char(25) */
      /* column42 Char(25) */
      /* column43 Char(25) */
      /* column44 Char(25) */
      /* column45 Char(25) */
      /* column46 Char(25) */
      /* column47 Char(25) */
      /* column48 Char(25) */
      /* column49 Char(25) */
      /* column50 Char(25) */
      /* column51 Char(25) */
      /* column52 Char(25) */
      /* column53 Char(25) */
      /* column54 Char(25) */
      /* column55 Char(25) */
      /* column56 Char(25) */
      /* column57 Char(25) */
      /* column58 Char(25) */
      /* column59 Char(25) */
      /* column60 Char(25) */
      /* column61 Char(25) */
      /* column62 Char(25) */
      /* column63 Char(25) */
      /* column64 Char(25) */
      /* column65 Char(25) */
      /* column66 Char(25) */
      /* column67 Char(25) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gFlgRet Char(1) // Flag Creazione File di Ritorno */
      /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _codinter := intermbo->CODINTER */
        _codinter = Cursor_intermbo.GetString("CODINTER");
        /* _citinter := intermbo->DESCCIT */
        _citinter = Cursor_intermbo.GetString("DESCCIT");
        /* _cabinter := intermbo->CODCAB */
        _cabinter = Cursor_intermbo.GetString("CODCAB");
        /* _prvinter := intermbo->PROVINCIA */
        _prvinter = Cursor_intermbo.GetString("PROVINCIA");
        /* _flgmodi := intermbo->FLGOPEXTR */
        _flgmodi = Cursor_intermbo.GetString("FLGOPEXTR");
        /* _flgdataim := intermbo->FLGDATAIM */
        _flgdataim = CPLib.Round(Cursor_intermbo.GetDouble("FLGDATAIM"),0);
        /* _frapcli := intermbo->FLGRAPCLI */
        _frapcli = Cursor_intermbo.GetString("FLGRAPCLI");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Import Soggetti */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla sul file della lista e lancia la pagina appropriata */
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* If At('.zip',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        if (CPLib.ne(CPLib.At(".zip",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* czipfile := LRTrim(tmp_list_imprich->nomefile) */
          czipfile = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
          /* Exec "Estrai zip" Page 4:Page_4 */
          Page_4();
        } // End If
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      /* Exec "Inserisce priorità sui nomi file" Page 3:Page_3 */
      Page_3();
      /* _chkerr := 0 */
      _chkerr = CPLib.Round(0,0);
      /* _opeerr := 0 */
      _opeerr = CPLib.Round(0,0);
      /* _frzerr := 0 */
      _frzerr = CPLib.Round(0,0);
      // * --- Drop temporary table tmp_listafile
      if (m_Ctx.IsSharedTemp("tmp_listafile")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_listafile");
      }
      // * --- Create temporary table tmp_listafile
      if (m_Ctx.IsSharedTemp("tmp_listafile")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_listafile");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_listafile");
      if ( ! (m_Ctx.IsSharedTemp("tmp_listafile"))) {
        m_cServer = m_Ctx.GetServer("tmp_listafile");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_listafile",m_cServer,"proto")),m_cPhName,"tmp_listafile",m_Ctx);
      }
      m_cPhName_tmp_listafile = m_cPhName;
      /* ohand := FileLibMit.OpenWrite('./output/'+LRTrim(gAzienda)+'/archope_scarti') */
      ohand = FileLibMit.OpenWrite("./output/"+CPLib.LRTrim(gAzienda)+"/archope_scarti");
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000DDstatus;
      nTry000000DDstatus = m_Sql.GetTransactionStatus();
      String cTry000000DDmsg;
      cTry000000DDmsg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from tmp_list_imprich
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
        Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_list_imprich.Eof())) {
          /* If _esito = 0 */
          if (CPLib.eqr(_esito,0)) {
            /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
            nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
            /* Exec "Operazioni" Page 2:Page_2 */
            Page_2();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } // End If
          // * --- Delete from tmp_list_imprich
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"000000E2")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_list_imprich.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_list_imprich.GetString("nomefile"))+"";
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
          Cursor_tmp_list_imprich.Next();
        }
        m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
        Cursor_tmp_list_imprich.Close();
        // * --- End Select
        /* gMsgImp := 'Fine importazione dati. Inizio fase di commit. Attendere prego...' // Messaggio Import */
        gMsgImp = "Fine importazione dati. Inizio fase di commit. Attendere prego...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Importazione dati terminata.' // Messaggio Import */
        gMsgImp = "Importazione dati terminata.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* _esito := 1 */
        _esito = CPLib.Round(1,0);
        /* gMsgProc := gMsgProc + "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
        gMsgProc = gMsgProc+"Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000DDstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000000DDstatus,cTry000000DDmsg);
        }
      }
      /* FileLibMit.Close(ohand) */
      FileLibMit.Close(ohand);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_terzistiope=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* _coddip Char(6) */
      String _coddip;
      _coddip = CPLib.Space(6);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibMit.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If not(Empty(LRTrim(riga))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(riga)))) {
          /* _descerr := '' */
          _descerr = "";
          /* _findsub := 1 */
          _findsub = CPLib.Round(1,0);
          /* If not(Empty(LRTrim(Substr(riga,302,16)))) and _findsub=1 */
          if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,302,16)))) && CPLib.eqr(_findsub,1)) {
            /* _conadd := '' */
            _conadd = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Substr(riga,302,16)),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(CPLib.Substr(riga,302,16)));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _conadd = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_imp_dati_ria returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _conadd = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_conadd)) */
            if (CPLib.Empty(CPLib.LRTrim(_conadd))) {
              /* _descerr := 'Anagrafica Controparte Operazione assente' */
              _descerr = "Anagrafica Controparte Operazione assente";
              /* _findsub := 0 */
              _findsub = CPLib.Round(0,0);
            } // End If
          } // End If
          /* _intercod := iif(Empty(LRTrim(Substr(riga,246,11))),_codinter,Substr(riga,246,11)) */
          _intercod = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,246,11)))?_codinter:CPLib.Substr(riga,246,11));
          /* _intercit := iif(Empty(LRTrim(Substr(riga,263,30))),_citinter,Substr(riga,263,30)) */
          _intercit = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30)))?_citinter:CPLib.Substr(riga,263,30));
          /* _intercab := iif(Empty(LRTrim(Substr(riga,295,6))),_cabinter,Substr(riga,295,6)) */
          _intercab = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,295,6)))?_cabinter:CPLib.Substr(riga,295,6));
          /* _interprv := iif(Empty(LRTrim(Substr(riga,293,2))),_prvinter,Substr(riga,293,2)) */
          _interprv = (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,293,2)))?_prvinter:CPLib.Substr(riga,293,2));
          /* If not(Empty(LRTrim(Substr(riga,257,6)))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,257,6))))) {
            /* _coddip := '' */
            _coddip = "";
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,257,6),"C",6,0,m_cServer),m_cServer,CPLib.Substr(riga,257,6));
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _intercit = Read_Cursor.GetString("DESCCIT");
              _intercab = Read_Cursor.GetString("CAB");
              _interprv = Read_Cursor.GetString("PROVINCIA");
              _coddip = Read_Cursor.GetString("CODDIP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_imp_dati_ria returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _intercit = "";
              _intercab = "";
              _interprv = "";
              _coddip = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_coddip) */
            if (CPLib.Empty(_coddip)) {
              /* gMsgProc := gMsgProc +"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CharToDate(Right(Left(riga,8),4)+Substr(Left(riga,8),3,2)+Left(Left(riga,8),2))+" con importo "+Str((Val(Substr(riga,160,15)))/100,14,2)+" si è indicata la dipendenza con codice: " + LRTrim(Substr(riga,257,6))+" non è prensente  in anagrafica dipendenze." +" Ricreare il file ARCHDIP e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annullata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Rilevati errori nel file "+nomefileimport+" per l'operazione in data "+CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2))+" con importo "+CPLib.Str((CPLib.Val(CPLib.Substr(riga,160,15)))/100,14,2)+" si è indicata la dipendenza con codice: "+CPLib.LRTrim(CPLib.Substr(riga,257,6))+" non è prensente  in anagrafica dipendenze."+" Ricreare il file ARCHDIP e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annullata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
            /* If not(Empty(LRTrim(Substr(riga,263,30))+LRTrim(Substr(riga,295,6))+LRTrim(Substr(riga,293,2)))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,263,30))+CPLib.LRTrim(CPLib.Substr(riga,295,6))+CPLib.LRTrim(CPLib.Substr(riga,293,2))))) {
              /* _intercit := LRTrim(Substr(riga,263,30)) */
              _intercit = CPLib.LRTrim(CPLib.Substr(riga,263,30));
              /* _intercab := LRTrim(Substr(riga,295,6)) */
              _intercab = CPLib.LRTrim(CPLib.Substr(riga,295,6));
              /* _interprv := LRTrim(Substr(riga,293,2)) */
              _interprv = CPLib.LRTrim(CPLib.Substr(riga,293,2));
            } // End If
          } // End If
          /* _benrag := Upper(Substr(riga,511,70)) */
          _benrag = CPLib.Upper(CPLib.Substr(riga,511,70));
          /* _bensta := arfn_conv_stato_uic(Substr(riga,581,3)) */
          _bensta = arfn_conv_stato_uicR.Make(m_Ctx,this).Run(CPLib.Substr(riga,581,3));
          /* _bencta := Upper(Substr(riga,584,30)) */
          _bencta = CPLib.Upper(CPLib.Substr(riga,584,30));
          /* _bencab := Substr(riga,614,6) */
          _bencab = CPLib.Substr(riga,614,6);
          /* _benprv := Upper(Substr(riga,620,2)) */
          _benprv = CPLib.Upper(CPLib.Substr(riga,620,2));
          /* _benind := Upper(Substr(riga,622,35)) */
          _benind = CPLib.Upper(CPLib.Substr(riga,622,35));
          /* _bencap := Upper(Substr(riga,657,5)) */
          _bencap = CPLib.Upper(CPLib.Substr(riga,657,5));
          // * --- Read from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_cSql = "";
          m_cSql = m_cSql+"DATAOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)),"D",8,0,m_cServer),m_cServer,CPLib.CharToDate(CPLib.Right(CPLib.Left(riga,8),4)+CPLib.Substr(CPLib.Left(riga,8),3,2)+CPLib.Left(CPLib.Left(riga,8),2)));
          m_cSql = m_cSql+" and CODANA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,10,4),"C",4,0,m_cServer),m_cServer,CPLib.Substr(riga,10,4));
          m_cSql = m_cSql+" and CODVOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,14,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,14,2));
          m_cSql = m_cSql+" and TIPOOPRAP="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,242,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,242,2));
          m_cSql = m_cSql+" and VALUTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,156,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,156,3));
          m_cSql = m_cSql+" and SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,159,1),"C",1,0,m_cServer),m_cServer,CPLib.Substr(riga,159,1));
          m_cSql = m_cSql+" and TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,160,15)),"N",15,0,m_cServer),m_cServer,CPLib.Val(CPLib.Substr(riga,160,15)));
          m_cSql = m_cSql+" and TOTCONT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.Substr(riga,175,15)),"N",15,0,m_cServer),m_cServer,CPLib.Val(CPLib.Substr(riga,175,15)));
          m_cSql = m_cSql+" and CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,190,16),"C",16,0,m_cServer),m_cServer,CPLib.Substr(riga,190,16));
          m_cSql = m_cSql+" and C_RAG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_benrag,"C",70,0,m_cServer),m_cServer,_benrag);
          m_cSql = m_cSql+" and C_STA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bensta,"C",3,0,m_cServer),m_cServer,_bensta);
          m_cSql = m_cSql+" and C_CTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bencta,"C",30,0,m_cServer),m_cServer,_bencta);
          m_cSql = m_cSql+" and C_CAB="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bencab,"C",6,0,m_cServer),m_cServer,_bencab);
          m_cSql = m_cSql+" and C_PRV="+CPSql.SQLValueAdapter(CPLib.ToSQL(_benprv,"C",2,0,m_cServer),m_cServer,_benprv);
          m_cSql = m_cSql+" and C_IND="+CPSql.SQLValueAdapter(CPLib.ToSQL(_benind,"C",35,0,m_cServer),m_cServer,_benind);
          m_cSql = m_cSql+" and C_CAP="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bencap,"C",5,0,m_cServer),m_cServer,_bencap);
          if (m_Ctx.IsSharedTemp("operazbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _numprog = Read_Cursor.GetString("NUMPROG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on operazbo into routine arrt_imp_dati_ria returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _numprog = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(LRTrim(_numprog))) */
          if ( ! (CPLib.Empty(CPLib.LRTrim(_numprog)))) {
            /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
            stringaflagrap2 = "ABCDEFGHI";
            /* gMsgImp := "E' stata variata l'operazione con codice "+_numprog // Messaggio Import */
            gMsgImp = "E' stata variata l'operazione con codice "+_numprog;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Select from operazbo
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            if (Cursor_operazbo!=null)
              Cursor_operazbo.Close();
            Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer, m_oParameters),m_cServer,_numprog)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_operazbo.Eof())) {
              /* _oldidb := operazbo->IDBASE */
              _oldidb = Cursor_operazbo.GetString("IDBASE");
              /* _flagrap2 := iif(Empty(operazbo->FLAGRAP2) or operazbo->FLAGRAP2='S',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(operazbo->FLAGRAP2,stringaflagrap2)+1),1)) */
              _flagrap2 = (CPLib.Empty(Cursor_operazbo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_operazbo.GetString("FLAGRAP2"),"S")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_operazbo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
              /* _idreg := operazbo->IDEREG */
              _idreg = Cursor_operazbo.GetString("IDEREG");
              // * --- Write into operazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"0000011D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_operazbo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              // * --- Select from sogopebo
              m_cServer = m_Ctx.GetServer("sogopebo");
              m_cPhName = m_Ctx.GetPhName("sogopebo");
              if (Cursor_sogopebo!=null)
                Cursor_sogopebo.Close();
              Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_sogopebo.Eof())) {
                // * --- Insert into mogopebo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("mogopebo");
                m_cPhName = m_Ctx.GetPhName("mogopebo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mogopebo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"0000011F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000011F(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mogopebo",true);
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
                Cursor_sogopebo.Next();
              }
              m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
              Cursor_sogopebo.Close();
              // * --- End Select
              // * --- Select from clientiope
              m_cServer = m_Ctx.GetServer("clientiope");
              m_cPhName = m_Ctx.GetPhName("clientiope");
              if (Cursor_clientiope!=null)
                Cursor_clientiope.Close();
              Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_clientiope.Eof())) {
                // * --- Insert into mlientiope from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("mlientiope");
                m_cPhName = m_Ctx.GetPhName("mlientiope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mlientiope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"00000121")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000121(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mlientiope",true);
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
                Cursor_clientiope.Next();
              }
              m_cConnectivityError = Cursor_clientiope.ErrorMessage();
              Cursor_clientiope.Close();
              // * --- End Select
              // * --- Select from beneficope
              m_cServer = m_Ctx.GetServer("beneficope");
              m_cPhName = m_Ctx.GetPhName("beneficope");
              if (Cursor_beneficope!=null)
                Cursor_beneficope.Close();
              Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_beneficope.Eof())) {
                // * --- Insert into meneficope from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("meneficope");
                m_cPhName = m_Ctx.GetPhName("meneficope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"meneficope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"00000123")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000123(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetDouble("CPROWNUM"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"meneficope",true);
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
              // * --- Select from terzistiope
              m_cServer = m_Ctx.GetServer("terzistiope");
              m_cPhName = m_Ctx.GetPhName("terzistiope");
              if (Cursor_terzistiope!=null)
                Cursor_terzistiope.Close();
              Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_terzistiope.Eof())) {
                // * --- Insert into merzistiope from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("merzistiope");
                m_cPhName = m_Ctx.GetPhName("merzistiope");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"merzistiope",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"00000125")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000125(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"merzistiope",true);
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
                Cursor_terzistiope.Next();
              }
              m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
              Cursor_terzistiope.Close();
              // * --- End Select
              /* nProgImp := Utilities.GetAutonumber("PRGIMPOPE\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOPE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",'',10) */
              cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              /* _idb2 := LibreriaMit.UniqueId() */
              _idb2 = LibreriaMit.UniqueId();
              // * --- Insert into operazbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("operazbo");
              m_cPhName = m_Ctx.GetPhName("operazbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"00000129")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000129(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("ANNOOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(riga,257,6),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
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
              }
              Cursor_operazbo.Next();
            }
            m_cConnectivityError = Cursor_operazbo.ErrorMessage();
            Cursor_operazbo.Close();
            // * --- End Select
          } else { // Else
            /* FileLibMit.WriteLine(ohand,riga+" - "+_descerr) */
            FileLibMit.WriteLine(ohand,riga+" - "+_descerr);
          } // End If
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* FileLibMit.DeleteFile('./appo/'+nomefileimport) */
      FileLibMit.DeleteFile("./appo/"+nomefileimport);
      /* gMsgProc := gMsgProc + 'Operazioni Inserite o modificate: '+LRTrim(Str(cNumNew,10,0)) + NL */
      gMsgProc = gMsgProc+"Operazioni Inserite o modificate: "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine importazione del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
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
  void Page_3() throws Exception {
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* Inserisce priorità sui nomi file */
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* Case At('archdip.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        if (CPLib.ne(CPLib.At("archdip.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 1 */
          _priorita = CPLib.Round(1,0);
          /* Case At('archpers.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archpers.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 2 */
          _priorita = CPLib.Round(2,0);
          /* Case At('archrap.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archrap.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 5 */
          _priorita = CPLib.Round(5,0);
          /* Case At('archinf.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archinf.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 6 */
          _priorita = CPLib.Round(6,0);
          /* Case At('archope.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archope.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 7 */
          _priorita = CPLib.Round(7,0);
          /* Case At('archfraz.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archfraz.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 8 */
          _priorita = CPLib.Round(8,0);
          /* Case At('opex.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("opex.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 9 */
          _priorita = CPLib.Round(9,0);
          /* Case At('archtito.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archtito.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 10 */
          _priorita = CPLib.Round(10,0);
          /* Case At('procdel.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("procdel.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 11 */
          _priorita = CPLib.Round(11,0);
          /* Case At('sogope.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("sogope.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 12 */
          _priorita = CPLib.Round(12,0);
          /* Case At('intest.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("intest.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 13 */
          _priorita = CPLib.Round(13,0);
          /* Case At('stopers.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("stopers.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 3 */
          _priorita = CPLib.Round(3,0);
          /* Case At('persnew.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("persnew.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 4 */
          _priorita = CPLib.Round(4,0);
          /* Case At('rapage.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("rapage.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 14 */
          _priorita = CPLib.Round(14,0);
          /* Case At('infage.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("infage.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 15 */
          _priorita = CPLib.Round(15,0);
          /* Case At('intage.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("intage.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 16 */
          _priorita = CPLib.Round(16,0);
          /* Case At('opeage.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("opeage.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 17 */
          _priorita = CPLib.Round(17,0);
          /* Case At('procage.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("procage.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 18 */
          _priorita = CPLib.Round(18,0);
          /* Case At('sogcli.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("sogcli.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 19 */
          _priorita = CPLib.Round(19,0);
          /* Case At('sogben.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("sogben.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 20 */
          _priorita = CPLib.Round(20,0);
          /* Case At('sogaltro.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("sogaltro.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 21 */
          _priorita = CPLib.Round(21,0);
          /* Case At('saldopex.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 or At('saldopex.xls',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("saldopex.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0) || CPLib.ne(CPLib.At("saldopex.xls",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 22 */
          _priorita = CPLib.Round(22,0);
          /* Case At('saldrapp.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 or At('saldrapp.xls',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("saldrapp.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0) || CPLib.ne(CPLib.At("saldrapp.xls",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 23 */
          _priorita = CPLib.Round(23,0);
          /* Case At('titosupp.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("titosupp.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 24 */
          _priorita = CPLib.Round(24,0);
        } // End Case
        // * --- Write into tmp_list_imprich from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"0000014B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"priorita = "+CPLib.ToSQL(_priorita,"N",3,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_list_imprich",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_list_imprich.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_list_imprich.GetString("nomefile"))+"";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter();
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
        if (CPLib.lt(m_nUpdatedRows,0)) {
          m_Sql.AbortTransaction();
        }
        m_Sql.CompleteTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + czipfile + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Inizio estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Inizio estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* cpercorsozip := LRTrim(gPathApp)+"/appo/"+czipfile */
    cpercorsozip = CPLib.LRTrim(gPathApp)+"/appo/"+czipfile;
    /* cdirectoryfile := LRTrim(gPathApp)+"/appo/" */
    cdirectoryfile = CPLib.LRTrim(gPathApp)+"/appo/";
    try {
          // Apro il file zip
          java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
    
          //Conto il numero di file all interno del file zip e creo un array di stringhe per memorizzare i nomi file
          conteggio=zf.size();
          lista=new String[conteggio];
          
          // Enumerate each entry
          i=0;
          for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
              // Get the entry name
              lista[i] = ((java.util.zip.ZipEntry)entries.nextElement()).getName();
              i++;
          }
         zf.close();
         } catch (java.io.IOException e) {
         }
    try {
          // Apro il file zip
          java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
    
          byte[] buffer = new byte[1024]; 
          java.util.Enumeration entries = zf.entries();
          while(entries.hasMoreElements() ) {
            java.util.zip.ZipEntry entry = (java.util.zip.ZipEntry)entries.nextElement();
            java.io.InputStream in =zf.getInputStream(entry);
            java.io.OutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(cdirectoryfile+entry.getName()));
    
            int len;
    
            while((len = in.read(buffer)) >= 0){
              out.write(buffer, 0, len);
            }
    
              in.close();
              out.close();
          }
    
          zf.close();
    } catch (java.io.IOException ioe) {
          System.err.println("Unhandled exception:");
          ioe.printStackTrace();
          return;
    }
    // * --- Delete from tmp_list_imprich
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_list_imprich");
    m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"00000151")+"delete from "+m_oWrInfo.GetTableWriteName();
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(czipfile,"?",0,0,m_cServer),m_cServer,czipfile)+"";
    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
    if (CPLib.lt(m_nUpdatedRows,0)) {
      m_Sql.AbortTransaction();
    }
    m_Sql.CompleteTransaction();
    m_cLastMsgError = m_Sql.TransactionErrorMessage();
    if (CPLib.ne(m_cLastMsgError,"")) {
      m_bError = true;
    }
    /* contanome := 0 */
    contanome = 0;
    /* _priorita := 0 */
    _priorita = CPLib.Round(0,0);
    /* While contanome<conteggio */
    while (CPLib.lt(contanome,conteggio)) {
      buffernomefile=lista[contanome];
      // * --- Insert into tmp_list_imprich from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_ria",772,"00000156")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000156(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(buffernomefile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_list_imprich",true);
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
      /* contanome := contanome+1 */
      contanome = contanome+1;
    } // End While
    /* FileLibMit.DeleteFile('./appo/'+czipfile) */
    FileLibMit.DeleteFile("./appo/"+czipfile);
    /* gMsgImp := 'Fine estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Fine estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +czipfile + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void _init_() {
  }
  public String RunAsync() {
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
      m_Caller.SetString("tipodest","C",1,0,w_tipodest);
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.SetNumber("annorif","N",4,0,w_annorif);
      m_Caller.SetString("chkaui","C",1,0,w_chkaui);
      m_Caller.SetString("imperr","C",1,0,w_imperr);
      m_Caller.SetString("creamo","C",1,0,w_creamo);
      m_Caller.SetNumber("fscarti","N",1,0,w_fscarti);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_dati_riaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_riaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_tipodest = m_Caller.GetString("tipodest","C",1,0);
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    w_annorif = m_Caller.GetNumber("annorif","N",4,0);
    w_chkaui = m_Caller.GetString("chkaui","C",1,0);
    w_imperr = m_Caller.GetString("imperr","C",1,0);
    w_creamo = m_Caller.GetString("creamo","C",1,0);
    w_fscarti = m_Caller.GetNumber("fscarti","N",1,0);
    _z = 0;
    fhand = CPLib.Space(1);
    ohand = CPLib.Space(1);
    zhand = CPLib.Space(1);
    xhand = CPLib.Space(1);
    shand = CPLib.Space(1);
    riga = "";
    xConnes = CPLib.Space(16);
    _tdest = CPLib.Space(1);
    xCF = CPLib.Space(16);
    xSOCTCon = CPLib.Space(16);
    xSOCTCF = CPLib.Space(16);
    xCodCab = CPLib.Space(6);
    xCitta = CPLib.Space(30);
    cCliProg = CPLib.Space(6);
    cInfProg1 = CPLib.Space(10);
    cInfProg2 = CPLib.Space(11);
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    xSesso = CPLib.Space(1);
    xRapporto = CPLib.Space(25);
    xCAB = CPLib.Space(6);
    xPrv = CPLib.Space(2);
    xDIP = CPLib.Space(6);
    xDIPx = CPLib.Space(6);
    cCli1 = CPLib.Space(16);
    xIDB = CPLib.Space(10);
    xData = CPLib.Space(8);
    xDatF = CPLib.Space(8);
    cNumNew = 0;
    cNumMod = 0;
    cNumInv = 0;
    cFlagLire = CPLib.Space(1);
    cFlagCont = CPLib.Space(1);
    cFlagFraz = CPLib.Space(1);
    cMaxRow = 0;
    cIdCau = CPLib.Space(4);
    xCFE = 0;
    conta = 0;
    _esito = 0;
    cSNAS = CPLib.Space(30);
    cCNAS = CPLib.Space(30);
    _unicode = CPLib.Space(10);
    _salta = 0;
    nProgImp = 0;
    nProgImp2 = 0;
    nProgSto = 0;
    _idbase = CPLib.Space(10);
    _codinter = CPLib.Space(11);
    _citinter = CPLib.Space(30);
    _cabinter = CPLib.Space(6);
    _prvinter = CPLib.Space(2);
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
    _tipper = CPLib.Space(1);
    _benrag = CPLib.Space(70);
    _bensta = CPLib.Space(3);
    _bencta = CPLib.Space(30);
    _bencab = CPLib.Space(6);
    _benprv = CPLib.Space(2);
    _benind = CPLib.Space(35);
    _bencap = CPLib.Space(5);
    _flgmodi = CPLib.Space(1);
    _conadd = CPLib.Space(16);
    _datareg = CPLib.NullDate();
    _dataope = CPLib.NullDate();
    _datvarage = CPLib.NullDate();
    _flgdataim = 0;
    _chkerr = 0;
    _rifimp = CPLib.Space(11);
    _oldidb = CPLib.Space(10);
    stringaflagrap2 = CPLib.Space(9);
    _statoreg = CPLib.Space(1);
    _datarett = CPLib.NullDate();
    _flagrap2 = CPLib.Space(1);
    _idreg = CPLib.Space(20);
    _findsub = 0;
    _opeerr = 0;
    _frzerr = 0;
    _opxerr = 0;
    _soxerr = 0;
    _numprog = CPLib.Space(11);
    _colleg = CPLib.Space(12);
    _frapcli = CPLib.Space(1);
    _tiporap = CPLib.Space(1);
    _czip = CPLib.Space(20);
    cNomeFileZip = CPLib.Space(30);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    _file1 = CPLib.Space(30);
    _file2 = CPLib.Space(30);
    _descerr = CPLib.Space(50);
    _oldest = 0;
    _newest = 0;
    _idb2 = CPLib.Space(10);
    ciidbase = CPLib.Space(10);
    cidataini = CPLib.NullDate();
    cidatafine = CPLib.NullDate();
    cicodinter = CPLib.Space(12);
    cinumprog = CPLib.Space(11);
    citiporap = CPLib.Space(1);
    czipfile = CPLib.Space(100);
    cpercorsozip = CPLib.Space(200);
    cdirectoryfile = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    nomefileimport = CPLib.Space(50);
    _priorita = 0;
    column01 = CPLib.Space(25);
    column02 = CPLib.Space(25);
    column03 = CPLib.Space(25);
    column04 = CPLib.Space(25);
    column05 = CPLib.Space(25);
    column06 = CPLib.Space(25);
    column07 = CPLib.Space(25);
    column08 = CPLib.Space(25);
    column09 = CPLib.Space(25);
    column10 = CPLib.Space(25);
    column11 = CPLib.Space(25);
    column12 = CPLib.Space(25);
    column13 = CPLib.Space(25);
    column14 = CPLib.Space(25);
    column15 = CPLib.Space(25);
    column16 = CPLib.Space(25);
    column17 = CPLib.Space(25);
    column18 = CPLib.Space(25);
    column19 = CPLib.Space(25);
    column20 = CPLib.Space(25);
    column21 = CPLib.Space(25);
    column22 = CPLib.Space(25);
    column23 = CPLib.Space(25);
    column24 = CPLib.Space(25);
    column25 = CPLib.Space(25);
    column26 = CPLib.Space(25);
    column27 = CPLib.Space(25);
    column28 = CPLib.Space(25);
    column29 = CPLib.Space(25);
    column30 = CPLib.Space(25);
    column31 = CPLib.Space(25);
    column32 = CPLib.Space(25);
    column33 = CPLib.Space(25);
    column34 = CPLib.Space(25);
    column35 = CPLib.Space(25);
    column36 = CPLib.Space(25);
    column37 = CPLib.Space(25);
    column38 = CPLib.Space(25);
    column39 = CPLib.Space(25);
    column40 = CPLib.Space(25);
    column41 = CPLib.Space(25);
    column42 = CPLib.Space(25);
    column43 = CPLib.Space(25);
    column44 = CPLib.Space(25);
    column45 = CPLib.Space(25);
    column46 = CPLib.Space(25);
    column47 = CPLib.Space(25);
    column48 = CPLib.Space(25);
    column49 = CPLib.Space(25);
    column50 = CPLib.Space(25);
    column51 = CPLib.Space(25);
    column52 = CPLib.Space(25);
    column53 = CPLib.Space(25);
    column54 = CPLib.Space(25);
    column55 = CPLib.Space(25);
    column56 = CPLib.Space(25);
    column57 = CPLib.Space(25);
    column58 = CPLib.Space(25);
    column59 = CPLib.Space(25);
    column60 = CPLib.Space(25);
    column61 = CPLib.Space(25);
    column62 = CPLib.Space(25);
    column63 = CPLib.Space(25);
    column64 = CPLib.Space(25);
    column65 = CPLib.Space(25);
    column66 = CPLib.Space(25);
    column67 = CPLib.Space(25);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gFlgRet=m_Ctx.GetGlobalString("gFlgRet");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_conv_stato_uic,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_conv_stato_uic,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000011F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000121(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000123(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"meneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000125(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"merzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000129(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
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
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000156(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
}
