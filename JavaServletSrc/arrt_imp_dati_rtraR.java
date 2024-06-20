// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_rtra
import java.util.*;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
// * --- Fine Area Manuale
public class arrt_imp_dati_rtraR implements CallerWithObjs {
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
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
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
  public String m_cPhName_decodecitta;
  public String m_cServer_decodecitta;
  public String m_cPhName_decodenascita;
  public String m_cServer_decodenascita;
  public String m_cPhName_decodestati;
  public String m_cServer_decodestati;
  public String m_cPhName_dersonbo;
  public String m_cServer_dersonbo;
  public String m_cPhName_docfrabo;
  public String m_cServer_docfrabo;
  public String m_cPhName_docopebo;
  public String m_cServer_docopebo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_fraziobo_agg;
  public String m_cServer_fraziobo_agg;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_kersonbo;
  public String m_cServer_kersonbo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_log_app;
  public String m_cServer_log_app;
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
  public String m_cPhName_mtimperr;
  public String m_cServer_mtimperr;
  public String m_cPhName_mtimport;
  public String m_cServer_mtimport;
  public String m_cPhName_mtstati;
  public String m_cServer_mtstati;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_operazbo_agg;
  public String m_cServer_operazbo_agg;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbcittna;
  public String m_cServer_tbcittna;
  public String m_cPhName_tbluonas;
  public String m_cServer_tbluonas;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbstatna;
  public String m_cServer_tbstatna;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_wuautocorrect;
  public String m_cServer_wuautocorrect;
  public String m_cPhName_wuchkimp;
  public String m_cServer_wuchkimp;
  public String m_cPhName_wuchkimp_sf;
  public String m_cServer_wuchkimp_sf;
  public String m_cPhName_wucodes;
  public String m_cServer_wucodes;
  public String m_cPhName_wurapporti;
  public String m_cServer_wurapporti;
  public String m_cPhName_wutrxchk;
  public String m_cServer_wutrxchk;
  public String m_cPhName_wutrxchk_cases;
  public String m_cServer_wutrxchk_cases;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xocfrabo;
  public String m_cServer_xocfrabo;
  public String m_cPhName_xocopebo;
  public String m_cServer_xocopebo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_wuautocorrect_mtcn;
  public String m_cServer_wuautocorrect_mtcn;
  public String m_cPhName_wutrxchk_checked;
  public String m_cServer_wutrxchk_checked;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
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
  public String w_delprec;
  public String pAUA;
  public String pModo;
  public String pTipo;
  public String pErrAUI;
  public String pImpAna;
  public String pNoDG;
  public String _azienda;
  public String cProg;
  public String w_destfin;
  public String _trxdate;
  public String fhand;
  public String ihand;
  public String dhand;
  public String xhand;
  public String iNomeFile;
  public String riga;
  public String _codrap;
  public String _luonas;
  public double nProg;
  public String nomefileimport;
  public String xConnes;
  public String _tdest;
  public double _pos;
  public double _npos;
  public String _tipoop;
  public String _coddip;
  public String _uniquecode;
  public java.sql.Date _datope;
  public java.sql.Date _datmod;
  public java.sql.Date _datreal;
  public java.sql.Date _datreg;
  public String _impstr;
  public double _importo;
  public double _contanti;
  public String _flgcash;
  public String _statodest;
  public String _isodest;
  public String _cognome;
  public String _nome;
  public String _citta;
  public String _cap;
  public String _via;
  public String _paese;
  public String _prov;
  public String _cab;
  public String _cognomecp;
  public String _nomecp;
  public String _pep;
  public String _sesso;
  public String _nascitta;
  public String _nasstato;
  public String _resstato;
  public String _nasprov;
  public java.sql.Date _nasdata;
  public String _tipodoc;
  public String _numdoc;
  public java.sql.Date _docril;
  public String _autril;
  public java.sql.Date _docsca;
  public String _codfis;
  public String _connes;
  public String cOpeProg1;
  public String cOpeProg2;
  public double nProgImp;
  public String xSesso;
  public String xCAB;
  public String xDIP;
  public String xDIPx;
  public String cCli1;
  public String xIDB;
  public String xData;
  public String xDatF;
  public String _flgbanca;
  public double cNumNew;
  public double cNumMod;
  public double cNumInv;
  public double _esito;
  public String _idbase;
  public String _intercod;
  public String _intercit;
  public String _intercab;
  public String _interprv;
  public String _doctype;
  public String _codana;
  public String _codsin;
  public String _segno;
  public String _uifdest;
  public String cProgSto;
  public String _prog;
  public double _nocf;
  public double _nocfap;
  public String _condoc;
  public String _idfile;
  public String _mage;
  public String _oldcodfis;
  public String _ocodfis;
  public java.sql.Timestamp _dtimport;
  public String _txtope;
  public double _errore;
  public double _nerrori;
  public double _nerraua;
  public double eProg;
  public String _codstanas;
  public String _codstares;
  public String _siglacit;
  public String _siglasta;
  public String _codcit;
  public String _merr;
  public String _oldmac;
  public double _aggcli;
  public String _tiperr;
  public String _intertip;
  public String _listerr;
  public String _tipope;
  public String _rapporto;
  public String _priga;
  public String w_codmage;
  public String stringaflagrap2;
  public String _oldidb;
  public String _flagrap2;
  public String _idreg;
  public String _idb2;
  public String _citdip;
  public String _cabdip;
  public String _provdip;
  public double _id;
  public String _filename;
  public String _dipid;
  public String _nfile;
  public String _filen;
  public double _nerrage;
  public double _errage;
  public MemoryCursor_mcerratedef_mcrdef mcErrate;
  public MemoryCursorRow_mcerratedef_mcrdef rowErrate;
  public MemoryCursor_mcerratedef_mcrdef mcErrAge;
  public MemoryCursor_mcerratedef_mcrdef mcAgeDuo;
  public MemoryCursor_mcerratedef_mcrdef mcAgenzie;
  public MemoryCursorRow_mcerratedef_mcrdef rowAgenzie;
  public double _contage;
  public String _anno;
  public double _errorig;
  public String _ageerr01;
  public String _ageerr02;
  public String _ageerr03;
  public String _ageerr04;
  public String _ageerr05;
  public String _ageerr06;
  public String _ageerr07;
  public String _ageerr08;
  public String _ageerr09;
  public String _colonna1;
  public String _colonna2;
  public String _colonna3;
  public String _colonna4;
  public String _colonna5;
  public String _colonna6;
  public String _flgact;
  public String w_xMARESSDEF;
  public MemoryCursor_wutrxchk_cases mcCases;
  public MemoryCursorRow_wutrxchk_cases rowCases;
  public String _flgaua;
  public String _datamin;
  public java.sql.Date _datadmin;
  public String _connesdoc;
  public java.sql.Date _lastdate;
  public String _campo1;
  public String _campo2;
  public String _wupos;
  public double _omaxid;
  public double _omaxpg;
  public double _omaxim;
  public double _pmaxim;
  public double _wmaxpg;
  public double _opxmax;
  public double _contarig;
  public String _wuposonly;
  public double _tottrans;
  public double _totmovi;
  public double _erraua;
  public double _ggscad;
  public double _scarti;
  public double _cpers;
  public double _coper;
  public double _idau;
  public String _gMsgProc;
  public String _pathfile;
  public String _pathdoc;
  public String _filescarti;
  public String xFLGSAE;
  public String gID;
  public String _nazrildoc;
  public String _dipcod;
  public java.sql.Date _limite20;
  public String w_idmage;
  public String w_xMAFLGRAP;
  public String w_xMAFLGBON;
  public String w_xMAFLGCKR;
  public String w_xMAFLGASR;
  public String w_xMADIPSTD;
  public String w_xMAFLGCHKDAT;
  public String w_xMANAIDWU;
  public String czipfile;
  public String cpercorsozip;
  public String cdirectoryfile;
  public String buffernomefile;
  public String nomefileorg;
  public double _priorita;
  public MemoryCursor_tbmacage mcMacAge;
  public String w_CODFISC;
  public java.sql.Date w_DATANASC;
  public String w_NASCOMUN;
  public String w_NASSTATO;
  public String w_COGNOME;
  public String w_RAGSOC;
  public String w_NOME;
  public String w_SESSO;
  public double riga_letta;
  public double foglio;
  public MemoryCursor_decodecitta mcDecodeCitta;
  public MemoryCursor_decodestati mcDecodeStati;
  public MemoryCursor_decodenascita mcDecodeNascita;
  public MemoryCursor_tbcitta mcTbcitta;
  public MemoryCursor_tbcitta mcTbcittaS;
  public MemoryCursor_tbstati mcTbstati;
  public MemoryCursor_tbstati mcTbstatiD;
  public MemoryCursor_anadip mcAnadip;
  public MemoryCursor_tbluonas mcStatiN;
  public MemoryCursor_decodestati mcNewStati;
  public MemoryCursor_decodecitta mcNewCitta;
  public MemoryCursor_decodenascita mcNewNascita;
  public MemoryCursor_mcerratedef_mcrdef mcNuove;
  public MemoryCursor_mcerratedef_mcrdef mcModDel;
  public MemoryCursor_personbo mcPersonbo;
  public MemoryCursor_personbo mcPersonboOld;
  public MemoryCursor_tmp_import_rtra mcOperazbo;
  public MemoryCursor_personbo_agg mcPersonboAgg;
  public MemoryCursor_tmp_newpers mcWersonbo;
  public MemoryCursorRow_mcerratedef_mcrdef rowLettura;
  public MemoryCursor_mclistafile_mcrdef mcFiles;
  public MemoryCursor_mclistafile_mcrdef mcZips;
  public MemoryCursor_operazbo mcOperazioni;
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
  public String _err12;
  public String _err13;
  public String _err14;
  public String _err15;
  public String _err16;
  public String _err17;
  public String _err18;
  public String _err19;
  public String _err20;
  public String _err21;
  public String _err22;
  public String _err23;
  public String _err24;
  public String _err25;
  public String _err26;
  public String _err27;
  public String _err28;
  public String _err29;
  public String _err30;
  public String _err31;
  public String _err32;
  public String _err33;
  public String _err34;
  public String _err35;
  public String _err36;
  public String _err37;
  public String _err38;
  public String _err39;
  public String _err40;
  public String _err41;
  public String _aua01;
  public String _aua02;
  public String _aua03;
  public String _aua04;
  public String _aua05;
  public String _aua06;
  public String _aua07;
  public String _aua08;
  public String _aua09;
  public String _aua10;
  public String _faua1;
  public String _faua2;
  public String _faua3;
  public String _faua4;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gUrlApp;
  public MemoryCursorRow_qbe_rtra_aua_1_vqr rowAUA1;
  public MemoryCursorRow_qbe_rtra_aua_2_vqr rowAUA2;
  public MemoryCursorRow_qbe_rtra_aua_3_vqr rowAUA3;
  public MemoryCursorRow_qbe_rtra_aua_4_vqr rowAUA4;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_rtra
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int _conta;
  public int r;
  public int cell_count;
  String sheetName = "Foglio1";
  public String[] lista;
  public String[] campi;
  public int conteggio;
  public int i;
  public int contanome;
  public int nfogli;
  public int ncampi;
  public SXSSFWorkbook wb;
  public SXSSFSheet sheet;
  public Row row; 
  public Cell cell;
  public CellStyle cs;
  public Font f;
  public String[] colonna=new String[77];
  // * --- Fine Area Manuale
  public arrt_imp_dati_rtraR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_rtra",m_Caller);
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
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
    m_cPhName_decodecitta = p_ContextObject.GetPhName("decodecitta");
    if (m_cPhName_decodecitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodecitta = m_cPhName_decodecitta+" "+m_Ctx.GetWritePhName("decodecitta");
    }
    m_cServer_decodecitta = p_ContextObject.GetServer("decodecitta");
    m_cPhName_decodenascita = p_ContextObject.GetPhName("decodenascita");
    if (m_cPhName_decodenascita.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodenascita = m_cPhName_decodenascita+" "+m_Ctx.GetWritePhName("decodenascita");
    }
    m_cServer_decodenascita = p_ContextObject.GetServer("decodenascita");
    m_cPhName_decodestati = p_ContextObject.GetPhName("decodestati");
    if (m_cPhName_decodestati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_decodestati = m_cPhName_decodestati+" "+m_Ctx.GetWritePhName("decodestati");
    }
    m_cServer_decodestati = p_ContextObject.GetServer("decodestati");
    m_cPhName_dersonbo = p_ContextObject.GetPhName("dersonbo");
    if (m_cPhName_dersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dersonbo = m_cPhName_dersonbo+" "+m_Ctx.GetWritePhName("dersonbo");
    }
    m_cServer_dersonbo = p_ContextObject.GetServer("dersonbo");
    m_cPhName_docfrabo = p_ContextObject.GetPhName("docfrabo");
    if (m_cPhName_docfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docfrabo = m_cPhName_docfrabo+" "+m_Ctx.GetWritePhName("docfrabo");
    }
    m_cServer_docfrabo = p_ContextObject.GetServer("docfrabo");
    m_cPhName_docopebo = p_ContextObject.GetPhName("docopebo");
    if (m_cPhName_docopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_docopebo = m_cPhName_docopebo+" "+m_Ctx.GetWritePhName("docopebo");
    }
    m_cServer_docopebo = p_ContextObject.GetServer("docopebo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_fraziobo_agg = p_ContextObject.GetPhName("fraziobo_agg");
    if (m_cPhName_fraziobo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo_agg = m_cPhName_fraziobo_agg+" "+m_Ctx.GetWritePhName("fraziobo_agg");
    }
    m_cServer_fraziobo_agg = p_ContextObject.GetServer("fraziobo_agg");
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
    m_cPhName_log_app = p_ContextObject.GetPhName("log_app");
    if (m_cPhName_log_app.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_log_app = m_cPhName_log_app+" "+m_Ctx.GetWritePhName("log_app");
    }
    m_cServer_log_app = p_ContextObject.GetServer("log_app");
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
    m_cPhName_mtimperr = p_ContextObject.GetPhName("mtimperr");
    if (m_cPhName_mtimperr.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimperr = m_cPhName_mtimperr+" "+m_Ctx.GetWritePhName("mtimperr");
    }
    m_cServer_mtimperr = p_ContextObject.GetServer("mtimperr");
    m_cPhName_mtimport = p_ContextObject.GetPhName("mtimport");
    if (m_cPhName_mtimport.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtimport = m_cPhName_mtimport+" "+m_Ctx.GetWritePhName("mtimport");
    }
    m_cServer_mtimport = p_ContextObject.GetServer("mtimport");
    m_cPhName_mtstati = p_ContextObject.GetPhName("mtstati");
    if (m_cPhName_mtstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mtstati = m_cPhName_mtstati+" "+m_Ctx.GetWritePhName("mtstati");
    }
    m_cServer_mtstati = p_ContextObject.GetServer("mtstati");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_operazbo_agg = p_ContextObject.GetPhName("operazbo_agg");
    if (m_cPhName_operazbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo_agg = m_cPhName_operazbo_agg+" "+m_Ctx.GetWritePhName("operazbo_agg");
    }
    m_cServer_operazbo_agg = p_ContextObject.GetServer("operazbo_agg");
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
    m_cPhName_tbcittna = p_ContextObject.GetPhName("tbcittna");
    if (m_cPhName_tbcittna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcittna = m_cPhName_tbcittna+" "+m_Ctx.GetWritePhName("tbcittna");
    }
    m_cServer_tbcittna = p_ContextObject.GetServer("tbcittna");
    m_cPhName_tbluonas = p_ContextObject.GetPhName("tbluonas");
    if (m_cPhName_tbluonas.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbluonas = m_cPhName_tbluonas+" "+m_Ctx.GetWritePhName("tbluonas");
    }
    m_cServer_tbluonas = p_ContextObject.GetServer("tbluonas");
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    if (m_cPhName_tbmacage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbmacage = m_cPhName_tbmacage+" "+m_Ctx.GetWritePhName("tbmacage");
    }
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbstatna = p_ContextObject.GetPhName("tbstatna");
    if (m_cPhName_tbstatna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstatna = m_cPhName_tbstatna+" "+m_Ctx.GetWritePhName("tbstatna");
    }
    m_cServer_tbstatna = p_ContextObject.GetServer("tbstatna");
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
    m_cPhName_wuautocorrect = p_ContextObject.GetPhName("wuautocorrect");
    if (m_cPhName_wuautocorrect.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuautocorrect = m_cPhName_wuautocorrect+" "+m_Ctx.GetWritePhName("wuautocorrect");
    }
    m_cServer_wuautocorrect = p_ContextObject.GetServer("wuautocorrect");
    m_cPhName_wuchkimp = p_ContextObject.GetPhName("wuchkimp");
    if (m_cPhName_wuchkimp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkimp = m_cPhName_wuchkimp+" "+m_Ctx.GetWritePhName("wuchkimp");
    }
    m_cServer_wuchkimp = p_ContextObject.GetServer("wuchkimp");
    m_cPhName_wuchkimp_sf = p_ContextObject.GetPhName("wuchkimp_sf");
    if (m_cPhName_wuchkimp_sf.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuchkimp_sf = m_cPhName_wuchkimp_sf+" "+m_Ctx.GetWritePhName("wuchkimp_sf");
    }
    m_cServer_wuchkimp_sf = p_ContextObject.GetServer("wuchkimp_sf");
    m_cPhName_wucodes = p_ContextObject.GetPhName("wucodes");
    if (m_cPhName_wucodes.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wucodes = m_cPhName_wucodes+" "+m_Ctx.GetWritePhName("wucodes");
    }
    m_cServer_wucodes = p_ContextObject.GetServer("wucodes");
    m_cPhName_wurapporti = p_ContextObject.GetPhName("wurapporti");
    if (m_cPhName_wurapporti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wurapporti = m_cPhName_wurapporti+" "+m_Ctx.GetWritePhName("wurapporti");
    }
    m_cServer_wurapporti = p_ContextObject.GetServer("wurapporti");
    m_cPhName_wutrxchk = p_ContextObject.GetPhName("wutrxchk");
    if (m_cPhName_wutrxchk.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk = m_cPhName_wutrxchk+" "+m_Ctx.GetWritePhName("wutrxchk");
    }
    m_cServer_wutrxchk = p_ContextObject.GetServer("wutrxchk");
    m_cPhName_wutrxchk_cases = p_ContextObject.GetPhName("wutrxchk_cases");
    if (m_cPhName_wutrxchk_cases.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk_cases = m_cPhName_wutrxchk_cases+" "+m_Ctx.GetWritePhName("wutrxchk_cases");
    }
    m_cServer_wutrxchk_cases = p_ContextObject.GetServer("wutrxchk_cases");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
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
    m_cPhName_xocfrabo = p_ContextObject.GetPhName("xocfrabo");
    if (m_cPhName_xocfrabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocfrabo = m_cPhName_xocfrabo+" "+m_Ctx.GetWritePhName("xocfrabo");
    }
    m_cServer_xocfrabo = p_ContextObject.GetServer("xocfrabo");
    m_cPhName_xocopebo = p_ContextObject.GetPhName("xocopebo");
    if (m_cPhName_xocopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xocopebo = m_cPhName_xocopebo+" "+m_Ctx.GetWritePhName("xocopebo");
    }
    m_cServer_xocopebo = p_ContextObject.GetServer("xocopebo");
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
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_wuautocorrect_mtcn = p_ContextObject.GetPhName("wuautocorrect_mtcn");
    if (m_cPhName_wuautocorrect_mtcn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuautocorrect_mtcn = m_cPhName_wuautocorrect_mtcn+" "+m_Ctx.GetWritePhName("wuautocorrect_mtcn");
    }
    m_cServer_wuautocorrect_mtcn = p_ContextObject.GetServer("wuautocorrect_mtcn");
    m_cPhName_wutrxchk_checked = p_ContextObject.GetPhName("wutrxchk_checked");
    if (m_cPhName_wutrxchk_checked.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk_checked = m_cPhName_wutrxchk_checked+" "+m_Ctx.GetWritePhName("wutrxchk_checked");
    }
    m_cServer_wutrxchk_checked = p_ContextObject.GetServer("wutrxchk_checked");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("nProg",p_cVarName)) {
      return nProg;
    }
    if (CPLib.eqr("_pos",p_cVarName)) {
      return _pos;
    }
    if (CPLib.eqr("_npos",p_cVarName)) {
      return _npos;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      return _importo;
    }
    if (CPLib.eqr("_contanti",p_cVarName)) {
      return _contanti;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
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
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_nocf",p_cVarName)) {
      return _nocf;
    }
    if (CPLib.eqr("_nocfap",p_cVarName)) {
      return _nocfap;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_nerrori",p_cVarName)) {
      return _nerrori;
    }
    if (CPLib.eqr("_nerraua",p_cVarName)) {
      return _nerraua;
    }
    if (CPLib.eqr("eProg",p_cVarName)) {
      return eProg;
    }
    if (CPLib.eqr("_aggcli",p_cVarName)) {
      return _aggcli;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      return _id;
    }
    if (CPLib.eqr("_nerrage",p_cVarName)) {
      return _nerrage;
    }
    if (CPLib.eqr("_errage",p_cVarName)) {
      return _errage;
    }
    if (CPLib.eqr("_contage",p_cVarName)) {
      return _contage;
    }
    if (CPLib.eqr("_errorig",p_cVarName)) {
      return _errorig;
    }
    if (CPLib.eqr("_omaxid",p_cVarName)) {
      return _omaxid;
    }
    if (CPLib.eqr("_omaxpg",p_cVarName)) {
      return _omaxpg;
    }
    if (CPLib.eqr("_omaxim",p_cVarName)) {
      return _omaxim;
    }
    if (CPLib.eqr("_pmaxim",p_cVarName)) {
      return _pmaxim;
    }
    if (CPLib.eqr("_wmaxpg",p_cVarName)) {
      return _wmaxpg;
    }
    if (CPLib.eqr("_opxmax",p_cVarName)) {
      return _opxmax;
    }
    if (CPLib.eqr("_contarig",p_cVarName)) {
      return _contarig;
    }
    if (CPLib.eqr("_tottrans",p_cVarName)) {
      return _tottrans;
    }
    if (CPLib.eqr("_totmovi",p_cVarName)) {
      return _totmovi;
    }
    if (CPLib.eqr("_erraua",p_cVarName)) {
      return _erraua;
    }
    if (CPLib.eqr("_ggscad",p_cVarName)) {
      return _ggscad;
    }
    if (CPLib.eqr("_scarti",p_cVarName)) {
      return _scarti;
    }
    if (CPLib.eqr("_cpers",p_cVarName)) {
      return _cpers;
    }
    if (CPLib.eqr("_coper",p_cVarName)) {
      return _coper;
    }
    if (CPLib.eqr("_idau",p_cVarName)) {
      return _idau;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      return _priorita;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      return riga_letta;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_rtra";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("delprec",p_cVarName)) {
      return w_delprec;
    }
    if (CPLib.eqr("pAUA",p_cVarName)) {
      return pAUA;
    }
    if (CPLib.eqr("pModo",p_cVarName)) {
      return pModo;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pErrAUI",p_cVarName)) {
      return pErrAUI;
    }
    if (CPLib.eqr("pImpAna",p_cVarName)) {
      return pImpAna;
    }
    if (CPLib.eqr("pNoDG",p_cVarName)) {
      return pNoDG;
    }
    if (CPLib.eqr("_azienda",p_cVarName)) {
      return _azienda;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      return w_destfin;
    }
    if (CPLib.eqr("_trxdate",p_cVarName)) {
      return _trxdate;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("ihand",p_cVarName)) {
      return ihand;
    }
    if (CPLib.eqr("dhand",p_cVarName)) {
      return dhand;
    }
    if (CPLib.eqr("xhand",p_cVarName)) {
      return xhand;
    }
    if (CPLib.eqr("iNomeFile",p_cVarName)) {
      return iNomeFile;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      return _codrap;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("_tdest",p_cVarName)) {
      return _tdest;
    }
    if (CPLib.eqr("_tipoop",p_cVarName)) {
      return _tipoop;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_uniquecode",p_cVarName)) {
      return _uniquecode;
    }
    if (CPLib.eqr("_impstr",p_cVarName)) {
      return _impstr;
    }
    if (CPLib.eqr("_flgcash",p_cVarName)) {
      return _flgcash;
    }
    if (CPLib.eqr("_statodest",p_cVarName)) {
      return _statodest;
    }
    if (CPLib.eqr("_isodest",p_cVarName)) {
      return _isodest;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      return _cognome;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      return _nome;
    }
    if (CPLib.eqr("_citta",p_cVarName)) {
      return _citta;
    }
    if (CPLib.eqr("_cap",p_cVarName)) {
      return _cap;
    }
    if (CPLib.eqr("_via",p_cVarName)) {
      return _via;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      return _paese;
    }
    if (CPLib.eqr("_prov",p_cVarName)) {
      return _prov;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      return _cab;
    }
    if (CPLib.eqr("_cognomecp",p_cVarName)) {
      return _cognomecp;
    }
    if (CPLib.eqr("_nomecp",p_cVarName)) {
      return _nomecp;
    }
    if (CPLib.eqr("_pep",p_cVarName)) {
      return _pep;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      return _sesso;
    }
    if (CPLib.eqr("_nascitta",p_cVarName)) {
      return _nascitta;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      return _nasstato;
    }
    if (CPLib.eqr("_resstato",p_cVarName)) {
      return _resstato;
    }
    if (CPLib.eqr("_nasprov",p_cVarName)) {
      return _nasprov;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      return _tipodoc;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      return _numdoc;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      return _autril;
    }
    if (CPLib.eqr("_codfis",p_cVarName)) {
      return _codfis;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
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
    if (CPLib.eqr("xCAB",p_cVarName)) {
      return xCAB;
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
    if (CPLib.eqr("_flgbanca",p_cVarName)) {
      return _flgbanca;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      return _idbase;
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
    if (CPLib.eqr("_doctype",p_cVarName)) {
      return _doctype;
    }
    if (CPLib.eqr("_codana",p_cVarName)) {
      return _codana;
    }
    if (CPLib.eqr("_codsin",p_cVarName)) {
      return _codsin;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      return _segno;
    }
    if (CPLib.eqr("_uifdest",p_cVarName)) {
      return _uifdest;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      return _prog;
    }
    if (CPLib.eqr("_condoc",p_cVarName)) {
      return _condoc;
    }
    if (CPLib.eqr("_idfile",p_cVarName)) {
      return _idfile;
    }
    if (CPLib.eqr("_mage",p_cVarName)) {
      return _mage;
    }
    if (CPLib.eqr("_oldcodfis",p_cVarName)) {
      return _oldcodfis;
    }
    if (CPLib.eqr("_ocodfis",p_cVarName)) {
      return _ocodfis;
    }
    if (CPLib.eqr("_txtope",p_cVarName)) {
      return _txtope;
    }
    if (CPLib.eqr("_codstanas",p_cVarName)) {
      return _codstanas;
    }
    if (CPLib.eqr("_codstares",p_cVarName)) {
      return _codstares;
    }
    if (CPLib.eqr("_siglacit",p_cVarName)) {
      return _siglacit;
    }
    if (CPLib.eqr("_siglasta",p_cVarName)) {
      return _siglasta;
    }
    if (CPLib.eqr("_codcit",p_cVarName)) {
      return _codcit;
    }
    if (CPLib.eqr("_merr",p_cVarName)) {
      return _merr;
    }
    if (CPLib.eqr("_oldmac",p_cVarName)) {
      return _oldmac;
    }
    if (CPLib.eqr("_tiperr",p_cVarName)) {
      return _tiperr;
    }
    if (CPLib.eqr("_intertip",p_cVarName)) {
      return _intertip;
    }
    if (CPLib.eqr("_listerr",p_cVarName)) {
      return _listerr;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      return _tipope;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_priga",p_cVarName)) {
      return _priga;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      return w_codmage;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      return stringaflagrap2;
    }
    if (CPLib.eqr("_oldidb",p_cVarName)) {
      return _oldidb;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("_citdip",p_cVarName)) {
      return _citdip;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      return _cabdip;
    }
    if (CPLib.eqr("_provdip",p_cVarName)) {
      return _provdip;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      return _filename;
    }
    if (CPLib.eqr("_dipid",p_cVarName)) {
      return _dipid;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("_filen",p_cVarName)) {
      return _filen;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_ageerr01",p_cVarName)) {
      return _ageerr01;
    }
    if (CPLib.eqr("_ageerr02",p_cVarName)) {
      return _ageerr02;
    }
    if (CPLib.eqr("_ageerr03",p_cVarName)) {
      return _ageerr03;
    }
    if (CPLib.eqr("_ageerr04",p_cVarName)) {
      return _ageerr04;
    }
    if (CPLib.eqr("_ageerr05",p_cVarName)) {
      return _ageerr05;
    }
    if (CPLib.eqr("_ageerr06",p_cVarName)) {
      return _ageerr06;
    }
    if (CPLib.eqr("_ageerr07",p_cVarName)) {
      return _ageerr07;
    }
    if (CPLib.eqr("_ageerr08",p_cVarName)) {
      return _ageerr08;
    }
    if (CPLib.eqr("_ageerr09",p_cVarName)) {
      return _ageerr09;
    }
    if (CPLib.eqr("_colonna1",p_cVarName)) {
      return _colonna1;
    }
    if (CPLib.eqr("_colonna2",p_cVarName)) {
      return _colonna2;
    }
    if (CPLib.eqr("_colonna3",p_cVarName)) {
      return _colonna3;
    }
    if (CPLib.eqr("_colonna4",p_cVarName)) {
      return _colonna4;
    }
    if (CPLib.eqr("_colonna5",p_cVarName)) {
      return _colonna5;
    }
    if (CPLib.eqr("_colonna6",p_cVarName)) {
      return _colonna6;
    }
    if (CPLib.eqr("_flgact",p_cVarName)) {
      return _flgact;
    }
    if (CPLib.eqr("xMARESSDEF",p_cVarName)) {
      return w_xMARESSDEF;
    }
    if (CPLib.eqr("_flgaua",p_cVarName)) {
      return _flgaua;
    }
    if (CPLib.eqr("_datamin",p_cVarName)) {
      return _datamin;
    }
    if (CPLib.eqr("_connesdoc",p_cVarName)) {
      return _connesdoc;
    }
    if (CPLib.eqr("_campo1",p_cVarName)) {
      return _campo1;
    }
    if (CPLib.eqr("_campo2",p_cVarName)) {
      return _campo2;
    }
    if (CPLib.eqr("_wupos",p_cVarName)) {
      return _wupos;
    }
    if (CPLib.eqr("_wuposonly",p_cVarName)) {
      return _wuposonly;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      return _gMsgProc;
    }
    if (CPLib.eqr("_pathfile",p_cVarName)) {
      return _pathfile;
    }
    if (CPLib.eqr("_pathdoc",p_cVarName)) {
      return _pathdoc;
    }
    if (CPLib.eqr("_filescarti",p_cVarName)) {
      return _filescarti;
    }
    if (CPLib.eqr("xFLGSAE",p_cVarName)) {
      return xFLGSAE;
    }
    if (CPLib.eqr("gID",p_cVarName)) {
      return gID;
    }
    if (CPLib.eqr("_nazrildoc",p_cVarName)) {
      return _nazrildoc;
    }
    if (CPLib.eqr("_dipcod",p_cVarName)) {
      return _dipcod;
    }
    if (CPLib.eqr("idmage",p_cVarName)) {
      return w_idmage;
    }
    if (CPLib.eqr("xMAFLGRAP",p_cVarName)) {
      return w_xMAFLGRAP;
    }
    if (CPLib.eqr("xMAFLGBON",p_cVarName)) {
      return w_xMAFLGBON;
    }
    if (CPLib.eqr("xMAFLGCKR",p_cVarName)) {
      return w_xMAFLGCKR;
    }
    if (CPLib.eqr("xMAFLGASR",p_cVarName)) {
      return w_xMAFLGASR;
    }
    if (CPLib.eqr("xMADIPSTD",p_cVarName)) {
      return w_xMADIPSTD;
    }
    if (CPLib.eqr("xMAFLGCHKDAT",p_cVarName)) {
      return w_xMAFLGCHKDAT;
    }
    if (CPLib.eqr("xMANAIDWU",p_cVarName)) {
      return w_xMANAIDWU;
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
    if (CPLib.eqr("nomefileorg",p_cVarName)) {
      return nomefileorg;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      return w_CODFISC;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      return w_NASCOMUN;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      return w_NASSTATO;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      return w_COGNOME;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      return w_RAGSOC;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      return w_NOME;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      return w_SESSO;
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
    if (CPLib.eqr("_err12",p_cVarName)) {
      return _err12;
    }
    if (CPLib.eqr("_err13",p_cVarName)) {
      return _err13;
    }
    if (CPLib.eqr("_err14",p_cVarName)) {
      return _err14;
    }
    if (CPLib.eqr("_err15",p_cVarName)) {
      return _err15;
    }
    if (CPLib.eqr("_err16",p_cVarName)) {
      return _err16;
    }
    if (CPLib.eqr("_err17",p_cVarName)) {
      return _err17;
    }
    if (CPLib.eqr("_err18",p_cVarName)) {
      return _err18;
    }
    if (CPLib.eqr("_err19",p_cVarName)) {
      return _err19;
    }
    if (CPLib.eqr("_err20",p_cVarName)) {
      return _err20;
    }
    if (CPLib.eqr("_err21",p_cVarName)) {
      return _err21;
    }
    if (CPLib.eqr("_err22",p_cVarName)) {
      return _err22;
    }
    if (CPLib.eqr("_err23",p_cVarName)) {
      return _err23;
    }
    if (CPLib.eqr("_err24",p_cVarName)) {
      return _err24;
    }
    if (CPLib.eqr("_err25",p_cVarName)) {
      return _err25;
    }
    if (CPLib.eqr("_err26",p_cVarName)) {
      return _err26;
    }
    if (CPLib.eqr("_err27",p_cVarName)) {
      return _err27;
    }
    if (CPLib.eqr("_err28",p_cVarName)) {
      return _err28;
    }
    if (CPLib.eqr("_err29",p_cVarName)) {
      return _err29;
    }
    if (CPLib.eqr("_err30",p_cVarName)) {
      return _err30;
    }
    if (CPLib.eqr("_err31",p_cVarName)) {
      return _err31;
    }
    if (CPLib.eqr("_err32",p_cVarName)) {
      return _err32;
    }
    if (CPLib.eqr("_err33",p_cVarName)) {
      return _err33;
    }
    if (CPLib.eqr("_err34",p_cVarName)) {
      return _err34;
    }
    if (CPLib.eqr("_err35",p_cVarName)) {
      return _err35;
    }
    if (CPLib.eqr("_err36",p_cVarName)) {
      return _err36;
    }
    if (CPLib.eqr("_err37",p_cVarName)) {
      return _err37;
    }
    if (CPLib.eqr("_err38",p_cVarName)) {
      return _err38;
    }
    if (CPLib.eqr("_err39",p_cVarName)) {
      return _err39;
    }
    if (CPLib.eqr("_err40",p_cVarName)) {
      return _err40;
    }
    if (CPLib.eqr("_err41",p_cVarName)) {
      return _err41;
    }
    if (CPLib.eqr("_aua01",p_cVarName)) {
      return _aua01;
    }
    if (CPLib.eqr("_aua02",p_cVarName)) {
      return _aua02;
    }
    if (CPLib.eqr("_aua03",p_cVarName)) {
      return _aua03;
    }
    if (CPLib.eqr("_aua04",p_cVarName)) {
      return _aua04;
    }
    if (CPLib.eqr("_aua05",p_cVarName)) {
      return _aua05;
    }
    if (CPLib.eqr("_aua06",p_cVarName)) {
      return _aua06;
    }
    if (CPLib.eqr("_aua07",p_cVarName)) {
      return _aua07;
    }
    if (CPLib.eqr("_aua08",p_cVarName)) {
      return _aua08;
    }
    if (CPLib.eqr("_aua09",p_cVarName)) {
      return _aua09;
    }
    if (CPLib.eqr("_aua10",p_cVarName)) {
      return _aua10;
    }
    if (CPLib.eqr("_faua1",p_cVarName)) {
      return _faua1;
    }
    if (CPLib.eqr("_faua2",p_cVarName)) {
      return _faua2;
    }
    if (CPLib.eqr("_faua3",p_cVarName)) {
      return _faua3;
    }
    if (CPLib.eqr("_faua4",p_cVarName)) {
      return _faua4;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
    }
    if (CPLib.eqr("_datmod",p_cVarName)) {
      return _datmod;
    }
    if (CPLib.eqr("_datreal",p_cVarName)) {
      return _datreal;
    }
    if (CPLib.eqr("_datreg",p_cVarName)) {
      return _datreg;
    }
    if (CPLib.eqr("_nasdata",p_cVarName)) {
      return _nasdata;
    }
    if (CPLib.eqr("_docril",p_cVarName)) {
      return _docril;
    }
    if (CPLib.eqr("_docsca",p_cVarName)) {
      return _docsca;
    }
    if (CPLib.eqr("_datadmin",p_cVarName)) {
      return _datadmin;
    }
    if (CPLib.eqr("_lastdate",p_cVarName)) {
      return _lastdate;
    }
    if (CPLib.eqr("_limite20",p_cVarName)) {
      return _limite20;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      return w_DATANASC;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dtimport",p_cVarName)) {
      return _dtimport;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcErrate",p_cVarName)) {
      return mcErrate;
    }
    if (CPLib.eqr("mcErrAge",p_cVarName)) {
      return mcErrAge;
    }
    if (CPLib.eqr("mcAgeDuo",p_cVarName)) {
      return mcAgeDuo;
    }
    if (CPLib.eqr("mcAgenzie",p_cVarName)) {
      return mcAgenzie;
    }
    if (CPLib.eqr("mcCases",p_cVarName)) {
      return mcCases;
    }
    if (CPLib.eqr("mcMacAge",p_cVarName)) {
      return mcMacAge;
    }
    if (CPLib.eqr("mcDecodeCitta",p_cVarName)) {
      return mcDecodeCitta;
    }
    if (CPLib.eqr("mcDecodeStati",p_cVarName)) {
      return mcDecodeStati;
    }
    if (CPLib.eqr("mcDecodeNascita",p_cVarName)) {
      return mcDecodeNascita;
    }
    if (CPLib.eqr("mcTbcitta",p_cVarName)) {
      return mcTbcitta;
    }
    if (CPLib.eqr("mcTbcittaS",p_cVarName)) {
      return mcTbcittaS;
    }
    if (CPLib.eqr("mcTbstati",p_cVarName)) {
      return mcTbstati;
    }
    if (CPLib.eqr("mcTbstatiD",p_cVarName)) {
      return mcTbstatiD;
    }
    if (CPLib.eqr("mcAnadip",p_cVarName)) {
      return mcAnadip;
    }
    if (CPLib.eqr("mcStatiN",p_cVarName)) {
      return mcStatiN;
    }
    if (CPLib.eqr("mcNewStati",p_cVarName)) {
      return mcNewStati;
    }
    if (CPLib.eqr("mcNewCitta",p_cVarName)) {
      return mcNewCitta;
    }
    if (CPLib.eqr("mcNewNascita",p_cVarName)) {
      return mcNewNascita;
    }
    if (CPLib.eqr("mcNuove",p_cVarName)) {
      return mcNuove;
    }
    if (CPLib.eqr("mcModDel",p_cVarName)) {
      return mcModDel;
    }
    if (CPLib.eqr("mcPersonbo",p_cVarName)) {
      return mcPersonbo;
    }
    if (CPLib.eqr("mcPersonboOld",p_cVarName)) {
      return mcPersonboOld;
    }
    if (CPLib.eqr("mcOperazbo",p_cVarName)) {
      return mcOperazbo;
    }
    if (CPLib.eqr("mcPersonboAgg",p_cVarName)) {
      return mcPersonboAgg;
    }
    if (CPLib.eqr("mcWersonbo",p_cVarName)) {
      return mcWersonbo;
    }
    if (CPLib.eqr("mcFiles",p_cVarName)) {
      return mcFiles;
    }
    if (CPLib.eqr("mcZips",p_cVarName)) {
      return mcZips;
    }
    if (CPLib.eqr("mcOperazioni",p_cVarName)) {
      return mcOperazioni;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowErrate",p_cVarName)) {
      return rowErrate;
    }
    if (CPLib.eqr("rowAgenzie",p_cVarName)) {
      return rowAgenzie;
    }
    if (CPLib.eqr("rowCases",p_cVarName)) {
      return rowCases;
    }
    if (CPLib.eqr("rowLettura",p_cVarName)) {
      return rowLettura;
    }
    if (CPLib.eqr("rowAUA1",p_cVarName)) {
      return rowAUA1;
    }
    if (CPLib.eqr("rowAUA2",p_cVarName)) {
      return rowAUA2;
    }
    if (CPLib.eqr("rowAUA3",p_cVarName)) {
      return rowAUA3;
    }
    if (CPLib.eqr("rowAUA4",p_cVarName)) {
      return rowAUA4;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("nProg",p_cVarName)) {
      nProg = value;
      return;
    }
    if (CPLib.eqr("_pos",p_cVarName)) {
      _pos = value;
      return;
    }
    if (CPLib.eqr("_npos",p_cVarName)) {
      _npos = value;
      return;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
      return;
    }
    if (CPLib.eqr("_contanti",p_cVarName)) {
      _contanti = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
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
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_nocf",p_cVarName)) {
      _nocf = value;
      return;
    }
    if (CPLib.eqr("_nocfap",p_cVarName)) {
      _nocfap = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_nerrori",p_cVarName)) {
      _nerrori = value;
      return;
    }
    if (CPLib.eqr("_nerraua",p_cVarName)) {
      _nerraua = value;
      return;
    }
    if (CPLib.eqr("eProg",p_cVarName)) {
      eProg = value;
      return;
    }
    if (CPLib.eqr("_aggcli",p_cVarName)) {
      _aggcli = value;
      return;
    }
    if (CPLib.eqr("_id",p_cVarName)) {
      _id = value;
      return;
    }
    if (CPLib.eqr("_nerrage",p_cVarName)) {
      _nerrage = value;
      return;
    }
    if (CPLib.eqr("_errage",p_cVarName)) {
      _errage = value;
      return;
    }
    if (CPLib.eqr("_contage",p_cVarName)) {
      _contage = value;
      return;
    }
    if (CPLib.eqr("_errorig",p_cVarName)) {
      _errorig = value;
      return;
    }
    if (CPLib.eqr("_omaxid",p_cVarName)) {
      _omaxid = value;
      return;
    }
    if (CPLib.eqr("_omaxpg",p_cVarName)) {
      _omaxpg = value;
      return;
    }
    if (CPLib.eqr("_omaxim",p_cVarName)) {
      _omaxim = value;
      return;
    }
    if (CPLib.eqr("_pmaxim",p_cVarName)) {
      _pmaxim = value;
      return;
    }
    if (CPLib.eqr("_wmaxpg",p_cVarName)) {
      _wmaxpg = value;
      return;
    }
    if (CPLib.eqr("_opxmax",p_cVarName)) {
      _opxmax = value;
      return;
    }
    if (CPLib.eqr("_contarig",p_cVarName)) {
      _contarig = value;
      return;
    }
    if (CPLib.eqr("_tottrans",p_cVarName)) {
      _tottrans = value;
      return;
    }
    if (CPLib.eqr("_totmovi",p_cVarName)) {
      _totmovi = value;
      return;
    }
    if (CPLib.eqr("_erraua",p_cVarName)) {
      _erraua = value;
      return;
    }
    if (CPLib.eqr("_ggscad",p_cVarName)) {
      _ggscad = value;
      return;
    }
    if (CPLib.eqr("_scarti",p_cVarName)) {
      _scarti = value;
      return;
    }
    if (CPLib.eqr("_cpers",p_cVarName)) {
      _cpers = value;
      return;
    }
    if (CPLib.eqr("_coper",p_cVarName)) {
      _coper = value;
      return;
    }
    if (CPLib.eqr("_idau",p_cVarName)) {
      _idau = value;
      return;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
    if (CPLib.eqr("riga_letta",p_cVarName)) {
      riga_letta = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("delprec",p_cVarName)) {
      w_delprec = value;
      return;
    }
    if (CPLib.eqr("pAUA",p_cVarName)) {
      pAUA = value;
      return;
    }
    if (CPLib.eqr("pModo",p_cVarName)) {
      pModo = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pErrAUI",p_cVarName)) {
      pErrAUI = value;
      return;
    }
    if (CPLib.eqr("pImpAna",p_cVarName)) {
      pImpAna = value;
      return;
    }
    if (CPLib.eqr("pNoDG",p_cVarName)) {
      pNoDG = value;
      return;
    }
    if (CPLib.eqr("_azienda",p_cVarName)) {
      _azienda = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("destfin",p_cVarName)) {
      w_destfin = value;
      return;
    }
    if (CPLib.eqr("_trxdate",p_cVarName)) {
      _trxdate = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("ihand",p_cVarName)) {
      ihand = value;
      return;
    }
    if (CPLib.eqr("dhand",p_cVarName)) {
      dhand = value;
      return;
    }
    if (CPLib.eqr("xhand",p_cVarName)) {
      xhand = value;
      return;
    }
    if (CPLib.eqr("iNomeFile",p_cVarName)) {
      iNomeFile = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("_codrap",p_cVarName)) {
      _codrap = value;
      return;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
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
    if (CPLib.eqr("_tipoop",p_cVarName)) {
      _tipoop = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_uniquecode",p_cVarName)) {
      _uniquecode = value;
      return;
    }
    if (CPLib.eqr("_impstr",p_cVarName)) {
      _impstr = value;
      return;
    }
    if (CPLib.eqr("_flgcash",p_cVarName)) {
      _flgcash = value;
      return;
    }
    if (CPLib.eqr("_statodest",p_cVarName)) {
      _statodest = value;
      return;
    }
    if (CPLib.eqr("_isodest",p_cVarName)) {
      _isodest = value;
      return;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      _cognome = value;
      return;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      _nome = value;
      return;
    }
    if (CPLib.eqr("_citta",p_cVarName)) {
      _citta = value;
      return;
    }
    if (CPLib.eqr("_cap",p_cVarName)) {
      _cap = value;
      return;
    }
    if (CPLib.eqr("_via",p_cVarName)) {
      _via = value;
      return;
    }
    if (CPLib.eqr("_paese",p_cVarName)) {
      _paese = value;
      return;
    }
    if (CPLib.eqr("_prov",p_cVarName)) {
      _prov = value;
      return;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      _cab = value;
      return;
    }
    if (CPLib.eqr("_cognomecp",p_cVarName)) {
      _cognomecp = value;
      return;
    }
    if (CPLib.eqr("_nomecp",p_cVarName)) {
      _nomecp = value;
      return;
    }
    if (CPLib.eqr("_pep",p_cVarName)) {
      _pep = value;
      return;
    }
    if (CPLib.eqr("_sesso",p_cVarName)) {
      _sesso = value;
      return;
    }
    if (CPLib.eqr("_nascitta",p_cVarName)) {
      _nascitta = value;
      return;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      _nasstato = value;
      return;
    }
    if (CPLib.eqr("_resstato",p_cVarName)) {
      _resstato = value;
      return;
    }
    if (CPLib.eqr("_nasprov",p_cVarName)) {
      _nasprov = value;
      return;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      _tipodoc = value;
      return;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      _numdoc = value;
      return;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      _autril = value;
      return;
    }
    if (CPLib.eqr("_codfis",p_cVarName)) {
      _codfis = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
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
    if (CPLib.eqr("xCAB",p_cVarName)) {
      xCAB = value;
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
    if (CPLib.eqr("_flgbanca",p_cVarName)) {
      _flgbanca = value;
      return;
    }
    if (CPLib.eqr("_idbase",p_cVarName)) {
      _idbase = value;
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
    if (CPLib.eqr("_doctype",p_cVarName)) {
      _doctype = value;
      return;
    }
    if (CPLib.eqr("_codana",p_cVarName)) {
      _codana = value;
      return;
    }
    if (CPLib.eqr("_codsin",p_cVarName)) {
      _codsin = value;
      return;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      _segno = value;
      return;
    }
    if (CPLib.eqr("_uifdest",p_cVarName)) {
      _uifdest = value;
      return;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("_prog",p_cVarName)) {
      _prog = value;
      return;
    }
    if (CPLib.eqr("_condoc",p_cVarName)) {
      _condoc = value;
      return;
    }
    if (CPLib.eqr("_idfile",p_cVarName)) {
      _idfile = value;
      return;
    }
    if (CPLib.eqr("_mage",p_cVarName)) {
      _mage = value;
      return;
    }
    if (CPLib.eqr("_oldcodfis",p_cVarName)) {
      _oldcodfis = value;
      return;
    }
    if (CPLib.eqr("_ocodfis",p_cVarName)) {
      _ocodfis = value;
      return;
    }
    if (CPLib.eqr("_txtope",p_cVarName)) {
      _txtope = value;
      return;
    }
    if (CPLib.eqr("_codstanas",p_cVarName)) {
      _codstanas = value;
      return;
    }
    if (CPLib.eqr("_codstares",p_cVarName)) {
      _codstares = value;
      return;
    }
    if (CPLib.eqr("_siglacit",p_cVarName)) {
      _siglacit = value;
      return;
    }
    if (CPLib.eqr("_siglasta",p_cVarName)) {
      _siglasta = value;
      return;
    }
    if (CPLib.eqr("_codcit",p_cVarName)) {
      _codcit = value;
      return;
    }
    if (CPLib.eqr("_merr",p_cVarName)) {
      _merr = value;
      return;
    }
    if (CPLib.eqr("_oldmac",p_cVarName)) {
      _oldmac = value;
      return;
    }
    if (CPLib.eqr("_tiperr",p_cVarName)) {
      _tiperr = value;
      return;
    }
    if (CPLib.eqr("_intertip",p_cVarName)) {
      _intertip = value;
      return;
    }
    if (CPLib.eqr("_listerr",p_cVarName)) {
      _listerr = value;
      return;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      _tipope = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_priga",p_cVarName)) {
      _priga = value;
      return;
    }
    if (CPLib.eqr("codmage",p_cVarName)) {
      w_codmage = value;
      return;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      stringaflagrap2 = value;
      return;
    }
    if (CPLib.eqr("_oldidb",p_cVarName)) {
      _oldidb = value;
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
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("_citdip",p_cVarName)) {
      _citdip = value;
      return;
    }
    if (CPLib.eqr("_cabdip",p_cVarName)) {
      _cabdip = value;
      return;
    }
    if (CPLib.eqr("_provdip",p_cVarName)) {
      _provdip = value;
      return;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      _filename = value;
      return;
    }
    if (CPLib.eqr("_dipid",p_cVarName)) {
      _dipid = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("_filen",p_cVarName)) {
      _filen = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("_ageerr01",p_cVarName)) {
      _ageerr01 = value;
      return;
    }
    if (CPLib.eqr("_ageerr02",p_cVarName)) {
      _ageerr02 = value;
      return;
    }
    if (CPLib.eqr("_ageerr03",p_cVarName)) {
      _ageerr03 = value;
      return;
    }
    if (CPLib.eqr("_ageerr04",p_cVarName)) {
      _ageerr04 = value;
      return;
    }
    if (CPLib.eqr("_ageerr05",p_cVarName)) {
      _ageerr05 = value;
      return;
    }
    if (CPLib.eqr("_ageerr06",p_cVarName)) {
      _ageerr06 = value;
      return;
    }
    if (CPLib.eqr("_ageerr07",p_cVarName)) {
      _ageerr07 = value;
      return;
    }
    if (CPLib.eqr("_ageerr08",p_cVarName)) {
      _ageerr08 = value;
      return;
    }
    if (CPLib.eqr("_ageerr09",p_cVarName)) {
      _ageerr09 = value;
      return;
    }
    if (CPLib.eqr("_colonna1",p_cVarName)) {
      _colonna1 = value;
      return;
    }
    if (CPLib.eqr("_colonna2",p_cVarName)) {
      _colonna2 = value;
      return;
    }
    if (CPLib.eqr("_colonna3",p_cVarName)) {
      _colonna3 = value;
      return;
    }
    if (CPLib.eqr("_colonna4",p_cVarName)) {
      _colonna4 = value;
      return;
    }
    if (CPLib.eqr("_colonna5",p_cVarName)) {
      _colonna5 = value;
      return;
    }
    if (CPLib.eqr("_colonna6",p_cVarName)) {
      _colonna6 = value;
      return;
    }
    if (CPLib.eqr("_flgact",p_cVarName)) {
      _flgact = value;
      return;
    }
    if (CPLib.eqr("xMARESSDEF",p_cVarName)) {
      w_xMARESSDEF = value;
      return;
    }
    if (CPLib.eqr("_flgaua",p_cVarName)) {
      _flgaua = value;
      return;
    }
    if (CPLib.eqr("_datamin",p_cVarName)) {
      _datamin = value;
      return;
    }
    if (CPLib.eqr("_connesdoc",p_cVarName)) {
      _connesdoc = value;
      return;
    }
    if (CPLib.eqr("_campo1",p_cVarName)) {
      _campo1 = value;
      return;
    }
    if (CPLib.eqr("_campo2",p_cVarName)) {
      _campo2 = value;
      return;
    }
    if (CPLib.eqr("_wupos",p_cVarName)) {
      _wupos = value;
      return;
    }
    if (CPLib.eqr("_wuposonly",p_cVarName)) {
      _wuposonly = value;
      return;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      _gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_pathfile",p_cVarName)) {
      _pathfile = value;
      return;
    }
    if (CPLib.eqr("_pathdoc",p_cVarName)) {
      _pathdoc = value;
      return;
    }
    if (CPLib.eqr("_filescarti",p_cVarName)) {
      _filescarti = value;
      return;
    }
    if (CPLib.eqr("xFLGSAE",p_cVarName)) {
      xFLGSAE = value;
      return;
    }
    if (CPLib.eqr("gID",p_cVarName)) {
      gID = value;
      return;
    }
    if (CPLib.eqr("_nazrildoc",p_cVarName)) {
      _nazrildoc = value;
      return;
    }
    if (CPLib.eqr("_dipcod",p_cVarName)) {
      _dipcod = value;
      return;
    }
    if (CPLib.eqr("idmage",p_cVarName)) {
      w_idmage = value;
      return;
    }
    if (CPLib.eqr("xMAFLGRAP",p_cVarName)) {
      w_xMAFLGRAP = value;
      return;
    }
    if (CPLib.eqr("xMAFLGBON",p_cVarName)) {
      w_xMAFLGBON = value;
      return;
    }
    if (CPLib.eqr("xMAFLGCKR",p_cVarName)) {
      w_xMAFLGCKR = value;
      return;
    }
    if (CPLib.eqr("xMAFLGASR",p_cVarName)) {
      w_xMAFLGASR = value;
      return;
    }
    if (CPLib.eqr("xMADIPSTD",p_cVarName)) {
      w_xMADIPSTD = value;
      return;
    }
    if (CPLib.eqr("xMAFLGCHKDAT",p_cVarName)) {
      w_xMAFLGCHKDAT = value;
      return;
    }
    if (CPLib.eqr("xMANAIDWU",p_cVarName)) {
      w_xMANAIDWU = value;
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
    if (CPLib.eqr("nomefileorg",p_cVarName)) {
      nomefileorg = value;
      return;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      w_CODFISC = value;
      return;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      w_NASCOMUN = value;
      return;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      w_NASSTATO = value;
      return;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      w_COGNOME = value;
      return;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      w_RAGSOC = value;
      return;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      w_NOME = value;
      return;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      w_SESSO = value;
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
    if (CPLib.eqr("_err12",p_cVarName)) {
      _err12 = value;
      return;
    }
    if (CPLib.eqr("_err13",p_cVarName)) {
      _err13 = value;
      return;
    }
    if (CPLib.eqr("_err14",p_cVarName)) {
      _err14 = value;
      return;
    }
    if (CPLib.eqr("_err15",p_cVarName)) {
      _err15 = value;
      return;
    }
    if (CPLib.eqr("_err16",p_cVarName)) {
      _err16 = value;
      return;
    }
    if (CPLib.eqr("_err17",p_cVarName)) {
      _err17 = value;
      return;
    }
    if (CPLib.eqr("_err18",p_cVarName)) {
      _err18 = value;
      return;
    }
    if (CPLib.eqr("_err19",p_cVarName)) {
      _err19 = value;
      return;
    }
    if (CPLib.eqr("_err20",p_cVarName)) {
      _err20 = value;
      return;
    }
    if (CPLib.eqr("_err21",p_cVarName)) {
      _err21 = value;
      return;
    }
    if (CPLib.eqr("_err22",p_cVarName)) {
      _err22 = value;
      return;
    }
    if (CPLib.eqr("_err23",p_cVarName)) {
      _err23 = value;
      return;
    }
    if (CPLib.eqr("_err24",p_cVarName)) {
      _err24 = value;
      return;
    }
    if (CPLib.eqr("_err25",p_cVarName)) {
      _err25 = value;
      return;
    }
    if (CPLib.eqr("_err26",p_cVarName)) {
      _err26 = value;
      return;
    }
    if (CPLib.eqr("_err27",p_cVarName)) {
      _err27 = value;
      return;
    }
    if (CPLib.eqr("_err28",p_cVarName)) {
      _err28 = value;
      return;
    }
    if (CPLib.eqr("_err29",p_cVarName)) {
      _err29 = value;
      return;
    }
    if (CPLib.eqr("_err30",p_cVarName)) {
      _err30 = value;
      return;
    }
    if (CPLib.eqr("_err31",p_cVarName)) {
      _err31 = value;
      return;
    }
    if (CPLib.eqr("_err32",p_cVarName)) {
      _err32 = value;
      return;
    }
    if (CPLib.eqr("_err33",p_cVarName)) {
      _err33 = value;
      return;
    }
    if (CPLib.eqr("_err34",p_cVarName)) {
      _err34 = value;
      return;
    }
    if (CPLib.eqr("_err35",p_cVarName)) {
      _err35 = value;
      return;
    }
    if (CPLib.eqr("_err36",p_cVarName)) {
      _err36 = value;
      return;
    }
    if (CPLib.eqr("_err37",p_cVarName)) {
      _err37 = value;
      return;
    }
    if (CPLib.eqr("_err38",p_cVarName)) {
      _err38 = value;
      return;
    }
    if (CPLib.eqr("_err39",p_cVarName)) {
      _err39 = value;
      return;
    }
    if (CPLib.eqr("_err40",p_cVarName)) {
      _err40 = value;
      return;
    }
    if (CPLib.eqr("_err41",p_cVarName)) {
      _err41 = value;
      return;
    }
    if (CPLib.eqr("_aua01",p_cVarName)) {
      _aua01 = value;
      return;
    }
    if (CPLib.eqr("_aua02",p_cVarName)) {
      _aua02 = value;
      return;
    }
    if (CPLib.eqr("_aua03",p_cVarName)) {
      _aua03 = value;
      return;
    }
    if (CPLib.eqr("_aua04",p_cVarName)) {
      _aua04 = value;
      return;
    }
    if (CPLib.eqr("_aua05",p_cVarName)) {
      _aua05 = value;
      return;
    }
    if (CPLib.eqr("_aua06",p_cVarName)) {
      _aua06 = value;
      return;
    }
    if (CPLib.eqr("_aua07",p_cVarName)) {
      _aua07 = value;
      return;
    }
    if (CPLib.eqr("_aua08",p_cVarName)) {
      _aua08 = value;
      return;
    }
    if (CPLib.eqr("_aua09",p_cVarName)) {
      _aua09 = value;
      return;
    }
    if (CPLib.eqr("_aua10",p_cVarName)) {
      _aua10 = value;
      return;
    }
    if (CPLib.eqr("_faua1",p_cVarName)) {
      _faua1 = value;
      return;
    }
    if (CPLib.eqr("_faua2",p_cVarName)) {
      _faua2 = value;
      return;
    }
    if (CPLib.eqr("_faua3",p_cVarName)) {
      _faua3 = value;
      return;
    }
    if (CPLib.eqr("_faua4",p_cVarName)) {
      _faua4 = value;
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
      return;
    }
    if (CPLib.eqr("_datmod",p_cVarName)) {
      _datmod = value;
      return;
    }
    if (CPLib.eqr("_datreal",p_cVarName)) {
      _datreal = value;
      return;
    }
    if (CPLib.eqr("_datreg",p_cVarName)) {
      _datreg = value;
      return;
    }
    if (CPLib.eqr("_nasdata",p_cVarName)) {
      _nasdata = value;
      return;
    }
    if (CPLib.eqr("_docril",p_cVarName)) {
      _docril = value;
      return;
    }
    if (CPLib.eqr("_docsca",p_cVarName)) {
      _docsca = value;
      return;
    }
    if (CPLib.eqr("_datadmin",p_cVarName)) {
      _datadmin = value;
      return;
    }
    if (CPLib.eqr("_lastdate",p_cVarName)) {
      _lastdate = value;
      return;
    }
    if (CPLib.eqr("_limite20",p_cVarName)) {
      _limite20 = value;
      return;
    }
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      w_DATANASC = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("_dtimport",p_cVarName)) {
      _dtimport = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowErrate",p_cVarName)) {
      rowErrate = (MemoryCursorRow_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rowAgenzie",p_cVarName)) {
      rowAgenzie = (MemoryCursorRow_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rowCases",p_cVarName)) {
      rowCases = (MemoryCursorRow_wutrxchk_cases)value;
      return;
    }
    if (CPLib.eqr("rowLettura",p_cVarName)) {
      rowLettura = (MemoryCursorRow_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rowAUA1",p_cVarName)) {
      rowAUA1 = (MemoryCursorRow_qbe_rtra_aua_1_vqr)value;
      return;
    }
    if (CPLib.eqr("rowAUA2",p_cVarName)) {
      rowAUA2 = (MemoryCursorRow_qbe_rtra_aua_2_vqr)value;
      return;
    }
    if (CPLib.eqr("rowAUA3",p_cVarName)) {
      rowAUA3 = (MemoryCursorRow_qbe_rtra_aua_3_vqr)value;
      return;
    }
    if (CPLib.eqr("rowAUA4",p_cVarName)) {
      rowAUA4 = (MemoryCursorRow_qbe_rtra_aua_4_vqr)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcErrate",p_cVarName)) {
      mcErrate = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcErrAge",p_cVarName)) {
      mcErrAge = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcAgeDuo",p_cVarName)) {
      mcAgeDuo = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcAgenzie",p_cVarName)) {
      mcAgenzie = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcCases",p_cVarName)) {
      mcCases = (MemoryCursor_wutrxchk_cases)value;
      return;
    }
    if (CPLib.eqr("mcMacAge",p_cVarName)) {
      mcMacAge = (MemoryCursor_tbmacage)value;
      return;
    }
    if (CPLib.eqr("mcDecodeCitta",p_cVarName)) {
      mcDecodeCitta = (MemoryCursor_decodecitta)value;
      return;
    }
    if (CPLib.eqr("mcDecodeStati",p_cVarName)) {
      mcDecodeStati = (MemoryCursor_decodestati)value;
      return;
    }
    if (CPLib.eqr("mcDecodeNascita",p_cVarName)) {
      mcDecodeNascita = (MemoryCursor_decodenascita)value;
      return;
    }
    if (CPLib.eqr("mcTbcitta",p_cVarName)) {
      mcTbcitta = (MemoryCursor_tbcitta)value;
      return;
    }
    if (CPLib.eqr("mcTbcittaS",p_cVarName)) {
      mcTbcittaS = (MemoryCursor_tbcitta)value;
      return;
    }
    if (CPLib.eqr("mcTbstati",p_cVarName)) {
      mcTbstati = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcTbstatiD",p_cVarName)) {
      mcTbstatiD = (MemoryCursor_tbstati)value;
      return;
    }
    if (CPLib.eqr("mcAnadip",p_cVarName)) {
      mcAnadip = (MemoryCursor_anadip)value;
      return;
    }
    if (CPLib.eqr("mcStatiN",p_cVarName)) {
      mcStatiN = (MemoryCursor_tbluonas)value;
      return;
    }
    if (CPLib.eqr("mcNewStati",p_cVarName)) {
      mcNewStati = (MemoryCursor_decodestati)value;
      return;
    }
    if (CPLib.eqr("mcNewCitta",p_cVarName)) {
      mcNewCitta = (MemoryCursor_decodecitta)value;
      return;
    }
    if (CPLib.eqr("mcNewNascita",p_cVarName)) {
      mcNewNascita = (MemoryCursor_decodenascita)value;
      return;
    }
    if (CPLib.eqr("mcNuove",p_cVarName)) {
      mcNuove = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcModDel",p_cVarName)) {
      mcModDel = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcPersonbo",p_cVarName)) {
      mcPersonbo = (MemoryCursor_personbo)value;
      return;
    }
    if (CPLib.eqr("mcPersonboOld",p_cVarName)) {
      mcPersonboOld = (MemoryCursor_personbo)value;
      return;
    }
    if (CPLib.eqr("mcOperazbo",p_cVarName)) {
      mcOperazbo = (MemoryCursor_tmp_import_rtra)value;
      return;
    }
    if (CPLib.eqr("mcPersonboAgg",p_cVarName)) {
      mcPersonboAgg = (MemoryCursor_personbo_agg)value;
      return;
    }
    if (CPLib.eqr("mcWersonbo",p_cVarName)) {
      mcWersonbo = (MemoryCursor_tmp_newpers)value;
      return;
    }
    if (CPLib.eqr("mcFiles",p_cVarName)) {
      mcFiles = (MemoryCursor_mclistafile_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcZips",p_cVarName)) {
      mcZips = (MemoryCursor_mclistafile_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcOperazioni",p_cVarName)) {
      mcOperazioni = (MemoryCursor_operazbo)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_tbmacage=null;
    CPResultSet Cursor_qbe_decodestati_full=null;
    CPResultSet Cursor_qbe_decodecomuni_full=null;
    CPResultSet Cursor_qbe_decodenascita_full=null;
    CPResultSet Cursor_tbcitta=null;
    CPResultSet Cursor_tbstati=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_tbluonas=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_cpwarn=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_tipodest Char(1) */
      /* w_delprec Char(1) */
      /* pAUA Char(1) // Esegui controlli AUA */
      /* pModo Char(1) // Modalita (Real time-Batch) */
      /* pTipo Char(1) // Import-G Controlli */
      /* pErrAUI Char(1) // Solo errori AUI */
      /* pImpAna Char(1) // Importa solo dati anagrafici */
      /* pNoDG Char(1) // Salta controllo data su controlli di tipo G */
      /* _azienda Char(10) */
      /* cProg Char(20) */
      /* w_destfin Char(1) // Destinazione finale */
      /* _trxdate Char(8) */
      /* fhand Char(1) */
      /* ihand Char(1) */
      /* dhand Char(1) */
      /* xhand Char(1) */
      /* iNomeFile Char(100) */
      /* riga Memo */
      /* _codrap Char(16) */
      /* _luonas Char(50) */
      /* nProg Numeric(10, 0) */
      /* nomefileimport Char(50) */
      /* xConnes Char(16) */
      /* _tdest Char(1) */
      /* _pos Numeric(3, 0) */
      /* _npos Numeric(1, 0) */
      /* _tipoop Char(1) */
      /* _coddip Char(6) */
      /* _uniquecode Char(10) */
      /* _datope Date */
      /* _datmod Date */
      /* _datreal Date */
      /* _datreg Date */
      /* _impstr Char(20) */
      /* _importo Numeric(15, 2) */
      /* _contanti Numeric(15, 2) */
      /* _flgcash Char(1) */
      /* _statodest Char(3) */
      /* _isodest Char(3) */
      /* _cognome Char(50) */
      /* _nome Char(50) */
      /* _citta Char(40) */
      /* _cap Char(5) */
      /* _via Char(35) */
      /* _paese Char(50) */
      /* _prov Char(2) */
      /* _cab Char(6) */
      /* _cognomecp Char(26) */
      /* _nomecp Char(25) */
      /* _pep Char(1) */
      /* _sesso Char(1) */
      /* _nascitta Char(30) */
      /* _nasstato Char(30) */
      /* _resstato Char(3) */
      /* _nasprov Char(2) */
      /* _nasdata Date */
      /* _tipodoc Char(20) */
      /* _numdoc Char(20) */
      /* _docril Date */
      /* _autril Char(30) */
      /* _docsca Date */
      /* _codfis Char(16) */
      /* _connes Char(16) */
      /* cOpeProg1 Char(10) */
      /* cOpeProg2 Char(11) */
      /* nProgImp Numeric(15, 0) */
      /* xSesso Char(1) */
      /* xCAB Char(6) */
      /* xDIP Char(6) */
      /* xDIPx Char(6) */
      /* cCli1 Char(16) */
      /* xIDB Char(10) */
      /* xData Char(8) */
      /* xDatF Char(8) */
      /* _flgbanca Char(1) */
      /* cNumNew Numeric(10, 0) // Contatore record nuovi */
      /* cNumMod Numeric(10, 0) // Contatore record aggiornati */
      /* cNumInv Numeric(10, 0) // Contatore record invariati */
      /* _esito Numeric(1, 0) */
      /* _idbase Char(10) */
      /* _intercod Char(11) */
      /* _intercit Char(30) */
      /* _intercab Char(6) */
      /* _interprv Char(2) */
      /* _doctype Char(2) */
      /* _codana Char(4) */
      /* _codsin Char(2) */
      /* _segno Char(1) */
      /* _uifdest Char(3) */
      /* cProgSto Char(15) */
      /* _prog Char(10) */
      /* _nocf Numeric(1, 0) */
      /* _nocfap Numeric(1, 0) */
      /* _condoc Char(50) */
      /* _idfile Char(60) */
      /* _mage Char(5) */
      /* _oldcodfis Char(20) */
      /* _ocodfis Char(16) */
      /* _dtimport DateTime */
      /* _txtope Memo */
      /* _errore Numeric(1, 0) */
      /* _nerrori Numeric(10, 0) */
      /* _nerraua Numeric(10, 0) */
      /* eProg Numeric(10, 0) */
      /* _codstanas Char(3) */
      /* _codstares Char(3) */
      /* _siglacit Char(4) */
      /* _siglasta Char(4) */
      /* _codcit Char(10) */
      /* _merr Char(100) */
      /* _oldmac Char(5) */
      /* _aggcli Numeric(1, 0) */
      /* _tiperr Char(2) */
      /* _intertip Char(2) */
      /* _listerr Memo */
      /* _tipope Char(2) */
      /* _rapporto Char(25) */
      /* _priga Char(100) */
      /* w_codmage Char(5) // Codice Macroagente */
      /* stringaflagrap2 Char(9) // stringa di valori di flagrap2 */
      /* _oldidb Char(10) */
      /* _flagrap2 Char(1) */
      /* _idreg Char(20) */
      /* _idb2 Char(10) */
      /* _citdip Char(30) */
      /* _cabdip Char(6) */
      /* _provdip Char(2) */
      /* _id Numeric(10, 0) */
      /* _filename Char(128) // Nome file con path */
      /* _dipid Char(6) */
      /* _nfile Char(50) */
      /* _filen Char(50) */
      /* _nerrage Numeric(10, 0) */
      /* _errage Numeric(1, 0) */
      /* mcErrate MemoryCursor(mcErrateDef.MCRDef) */
      /* rowErrate Row(mcErrateDef.MCRDef) */
      /* mcErrAge MemoryCursor(mcErrateDef.MCRDef) */
      /* mcAgeDuo MemoryCursor(mcErrateDef.MCRDef) */
      /* mcAgenzie MemoryCursor(mcErrateDef.MCRDef) */
      /* rowAgenzie Row(mcErrateDef.MCRDef) */
      /* _contage Numeric(10, 0) */
      /* _anno Char(4) */
      /* _errorig Numeric(10, 0) */
      /* _ageerr01 Char(80) */
      /* _ageerr02 Char(80) */
      /* _ageerr03 Char(80) */
      /* _ageerr04 Char(80) */
      /* _ageerr05 Char(80) */
      /* _ageerr06 Char(80) */
      /* _ageerr07 Char(80) */
      /* _ageerr08 Char(80) */
      /* _ageerr09 Char(80) */
      /* _colonna1 Char(5) */
      /* _colonna2 Char(10) */
      /* _colonna3 Char(30) */
      /* _colonna4 Char(40) */
      /* _colonna5 Char(30) */
      /* _colonna6 Char(1) */
      /* _flgact Char(1) */
      /* w_xMARESSDEF Char(3) */
      /* mcCases MemoryCursor(wutrxchk_cases) */
      /* rowCases Row(wutrxchk_cases) */
      /* _flgaua Char(1) */
      /* _datamin Char(8) */
      /* _datadmin Date */
      /* _connesdoc Char(50) */
      /* _lastdate Date */
      /* _campo1 Char(100) */
      /* _campo2 Char(4) */
      /* _wupos Char(1) */
      /* _omaxid Numeric(10, 0) */
      /* _omaxpg Numeric(11, 0) */
      /* _omaxim Numeric(15, 0) */
      /* _pmaxim Numeric(15, 0) */
      /* _wmaxpg Numeric(15, 0) */
      /* _opxmax Numeric(15, 0) */
      /* _contarig Numeric(10, 0) */
      /* _wuposonly Char(1) */
      /* _tottrans Numeric(10, 0) */
      /* _totmovi Numeric(10, 0) */
      /* _erraua Numeric(10, 0) */
      /* _ggscad Numeric(3, 0) */
      /* _scarti Numeric(4, 0) */
      /* _cpers Numeric(10, 0) */
      /* _coper Numeric(10, 0) */
      /* _idau Numeric(10, 0) */
      /* _gMsgProc Char(0) */
      /* _pathfile Char(120) */
      /* _pathdoc Char(120) */
      /* _filescarti Char(30) */
      /* xFLGSAE Char(3) */
      /* gID Char(20) // Galactic ID */
      /* _nazrildoc Char(20) // Nazione Rilascio Documento */
      /* _dipcod Char(6) */
      /* _limite20 Date */
      /* w_idmage Char(5) // Destinazione finale */
      /* w_xMAFLGRAP Char(1) */
      /* w_xMAFLGBON Char(1) */
      /* w_xMAFLGCKR Char(1) */
      /* w_xMAFLGASR Char(1) */
      /* w_xMADIPSTD Char(6) */
      /* w_xMAFLGCHKDAT Char(1) */
      /* w_xMANAIDWU Char(5) */
      /* czipfile Char(100) */
      /* cpercorsozip Char(200) */
      /* cdirectoryfile Char(200) */
      /* buffernomefile Char(100) */
      /* nomefileorg Char(50) */
      /* _priorita Numeric(3, 0) */
      /* mcMacAge MemoryCursor(tbmacage) */
      /* _nocf Numeric(1, 0) */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_DATANASC Date // Data Nascita */
      /* w_NASCOMUN Char(30) // Luogo di Nascita */
      /* w_NASSTATO Char(30) // Stato di nascita */
      /* w_COGNOME Char(26) // Ragione Sociale */
      /* w_RAGSOC Char(70) // Ragione Sociale */
      /* w_NOME Char(25) // Ragione Sociale */
      /* w_SESSO Char(1) // Sesso */
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      /* foglio Numeric(2, 0) // foglio letto */
      /* mcDecodeCitta MemoryCursor(DecodeCitta) // Trascodifica Città residenza */
      /* mcDecodeStati MemoryCursor(DecodeStati) // Trascodifica stati residenza */
      /* mcDecodeNascita MemoryCursor(DecodeNascita) // Trascodifica luoghi di nascita */
      /* mcTbcitta MemoryCursor(tbcitta) // Tabella città residenza */
      /* mcTbcittaS MemoryCursor(tbcitta) // Città residenza per sigla */
      /* mcTbstati MemoryCursor(tbstati) // Stati residenza */
      /* mcTbstatiD MemoryCursor(tbstati) // Stati redidenza per denominazione */
      /* mcAnadip MemoryCursor(anadip) // Agenzie */
      /* mcStatiN MemoryCursor(tbluonas) // Luoghi di nascita */
      /* mcNewStati MemoryCursor(DecodeStati) // Nuovi stati residenza per decodifica */
      /* mcNewCitta MemoryCursor(DecodeCitta) // Nuove città residenza per decodifica */
      /* mcNewNascita MemoryCursor(DecodeNascita) // Nuovi luohi di nascita per decodifica */
      /* mcNuove MemoryCursor(mcErrateDef.MCRDef) // Nuove transazioni */
      /* mcModDel MemoryCursor(mcErrateDef.MCRDef) // Modifiche o Cancellazioni */
      /* mcPersonbo MemoryCursor(personbo) // Soggetti */
      /* mcPersonboOld MemoryCursor(personbo) // Soggetti */
      /* mcOperazbo MemoryCursor(tmp_import_rtra) // Operazioni Soggetti */
      /* mcPersonboAgg MemoryCursor(personbo_agg) // Dati Aggiuntivi Soggetti */
      /* mcWersonbo MemoryCursor(tmp_newpers) // Soggetti che hanno già scritto wersonbo */
      /* rowLettura Row(mcErrateDef.MCRDef) // Legge le righe per l'elaborazione */
      /* mcFiles MemoryCursor(mcListaFile.MCRDef) */
      /* mcZips MemoryCursor(mcListaFile.MCRDef) */
      /* mcOperazioni MemoryCursor(operazbo) // Per le modifiche delle operazioni */
      /* _err01 Char(80) */
      /* _err02 Char(80) */
      /* _err03 Char(80) */
      /* _err04 Char(80) */
      /* _err05 Char(80) */
      /* _err06 Char(80) */
      /* _err07 Char(80) */
      /* _err08 Char(80) */
      /* _err09 Char(80) */
      /* _err10 Char(80) */
      /* _err11 Char(80) */
      /* _err12 Char(80) */
      /* _err13 Char(80) */
      /* _err14 Char(80) */
      /* _err15 Char(80) */
      /* _err16 Char(80) */
      /* _err17 Char(80) */
      /* _err18 Char(80) */
      /* _err19 Char(80) */
      /* _err20 Char(80) */
      /* _err21 Char(80) */
      /* _err22 Char(80) */
      /* _err23 Char(80) */
      /* _err24 Char(80) */
      /* _err25 Char(80) */
      /* _err26 Char(80) */
      /* _err27 Char(80) */
      /* _err28 Char(80) */
      /* _err29 Char(80) */
      /* _err30 Char(80) */
      /* _err31 Char(80) */
      /* _err32 Char(80) */
      /* _err33 Char(80) */
      /* _err34 Char(80) */
      /* _err35 Char(80) */
      /* _err36 Char(80) */
      /* _err37 Char(80) */
      /* _err38 Char(80) */
      /* _err39 Char(80) */
      /* _err40 Char(80) */
      /* _err41 Char(80) */
      /* _aua01 Char(80) */
      /* _aua02 Char(80) */
      /* _aua03 Char(80) */
      /* _aua04 Char(80) */
      /* _aua05 Char(80) */
      /* _aua06 Char(80) */
      /* _aua07 Char(80) */
      /* _aua08 Char(80) */
      /* _aua09 Char(80) */
      /* _aua10 Char(80) */
      /* _faua1 Char(1) */
      /* _faua2 Char(1) */
      /* _faua3 Char(1) */
      /* _faua4 Char(1) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo */
      /* gUrlApp Char(80) // URL Applicazione */
      /* If At(pModo,'|R|M|Y') <> 0 */
      if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
        /* _azienda := gAzienda */
        _azienda = gAzienda;
      } else { // Else
        // * --- Select from cpazi
        m_cServer = m_Ctx.GetServer("cpazi");
        m_cPhName = m_Ctx.GetPhName("cpazi");
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
        Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select codazi  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cpazi.Eof())) {
          /* _azienda := cpazi->codazi */
          _azienda = Cursor_cpazi.GetString("codazi");
          Cursor_cpazi.Next();
        }
        m_cConnectivityError = Cursor_cpazi.ErrorMessage();
        Cursor_cpazi.Close();
        // * --- End Select
        /* Utilities.SetCompany(_azienda) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(_azienda);
      } // End If
      // * --- Fill memory cursor mcMacAge on tbmacage
      mcMacAge.Zap();
      m_cServer = m_Ctx.GetServer("tbmacage");
      m_cPhName = m_Ctx.GetPhName("tbmacage");
      if (Cursor_tbmacage!=null)
        Cursor_tbmacage.Close();
      Cursor_tbmacage = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbmacage")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbmacage;
        Cursor_tbmacage.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on tbmacage returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbmacage.Eof())) {
        mcMacAge.AppendWithTrimmedKey(Cursor_tbmacage.GetString("MANAIDWU"));
        mcMacAge.row.MACODICE = Cursor_tbmacage.GetString("MACODICE");
        mcMacAge.row.MADESCRI = Cursor_tbmacage.GetString("MADESCRI");
        mcMacAge.row.MAFLGRAP = Cursor_tbmacage.GetString("MAFLGRAP");
        mcMacAge.row.MAFLGOPE = Cursor_tbmacage.GetString("MAFLGOPE");
        mcMacAge.row.MAFLGBON = Cursor_tbmacage.GetString("MAFLGBON");
        mcMacAge.row.MAFLGCKR = Cursor_tbmacage.GetString("MAFLGCKR");
        mcMacAge.row.MAFLGASR = Cursor_tbmacage.GetString("MAFLGASR");
        mcMacAge.row.MAFLGNOX = Cursor_tbmacage.GetString("MAFLGNOX");
        mcMacAge.row.MADIPSTD = Cursor_tbmacage.GetString("MADIPSTD");
        mcMacAge.row.MANAIDWU = Cursor_tbmacage.GetString("MANAIDWU");
        mcMacAge.row.MAFLGCHKDAT = Cursor_tbmacage.GetString("MAFLGCHKDAT");
        mcMacAge.row.MAFLGACT = Cursor_tbmacage.GetString("MAFLGACT");
        mcMacAge.row.MARESSDEF = Cursor_tbmacage.GetString("MARESSDEF");
        mcMacAge.row.MAFLGAUA = Cursor_tbmacage.GetString("MAFLGAUA");
        mcMacAge.row.MADATINI = Cursor_tbmacage.GetDate("MADATINI");
        mcMacAge.row.MADATFIN = Cursor_tbmacage.GetDate("MADATFIN");
        mcMacAge.row.MAFISGIU = Cursor_tbmacage.GetString("MAFISGIU");
        mcMacAge.row.MADATMOD = Cursor_tbmacage.GetDate("MADATMOD");
        mcMacAge.row.MATIPAGE = Cursor_tbmacage.GetString("MATIPAGE");
        mcMacAge.row.MACODFIS = Cursor_tbmacage.GetString("MACODFIS");
        mcMacAge.row.MACOGNOME = Cursor_tbmacage.GetString("MACOGNOME");
        mcMacAge.row.MANOME = Cursor_tbmacage.GetString("MANOME");
        mcMacAge.row.MARESPAESE = Cursor_tbmacage.GetString("MARESPAESE");
        mcMacAge.row.MARESIND = Cursor_tbmacage.GetString("MARESIND");
        mcMacAge.row.MARESNCIV = Cursor_tbmacage.GetString("MARESNCIV");
        mcMacAge.row.MARESCITTA = Cursor_tbmacage.GetString("MARESCITTA");
        mcMacAge.row.MARESPRV = Cursor_tbmacage.GetString("MARESPRV");
        mcMacAge.row.MARESCAP = Cursor_tbmacage.GetString("MARESCAP");
        mcMacAge.row.MADOMPAESE = Cursor_tbmacage.GetString("MADOMPAESE");
        mcMacAge.row.MADOMIND = Cursor_tbmacage.GetString("MADOMIND");
        mcMacAge.row.MADOMNCIV = Cursor_tbmacage.GetString("MADOMNCIV");
        mcMacAge.row.MADOMCITTA = Cursor_tbmacage.GetString("MADOMCITTA");
        mcMacAge.row.MADOMPRV = Cursor_tbmacage.GetString("MADOMPRV");
        mcMacAge.row.MADOMCAP = Cursor_tbmacage.GetString("MADOMCAP");
        mcMacAge.row.MAFLGCOMPL = Cursor_tbmacage.GetDouble("MAFLGCOMPL");
        Cursor_tbmacage.Next();
      }
      m_cConnectivityError = Cursor_tbmacage.ErrorMessage();
      Cursor_tbmacage.Close();
      mcMacAge.GoTop();
      // * --- Fill memory cursor mcDecodeStati on qbe_decodestati_full
      mcDecodeStati.Zap();
      if (Cursor_qbe_decodestati_full!=null)
        Cursor_qbe_decodestati_full.Close();
      Cursor_qbe_decodestati_full = new VQRHolder("qbe_decodestati_full",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_decodestati_full;
        Cursor_qbe_decodestati_full.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on qbe_decodestati_full returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_decodestati_full.Eof())) {
        mcDecodeStati.AppendWithTrimmedKey(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_decodestati_full.GetString("account"))));
        mcDecodeStati.row.account = Cursor_qbe_decodestati_full.GetString("account");
        mcDecodeStati.row.CODSTA = Cursor_qbe_decodestati_full.GetString("CODSTA");
        mcDecodeStati.row.DESCRI = Cursor_qbe_decodestati_full.GetString("DESCRI");
        mcDecodeStati.row.SIGLA = Cursor_qbe_decodestati_full.GetString("SIGLA");
        mcDecodeStati.row.ISO = Cursor_qbe_decodestati_full.GetString("ISO");
        mcDecodeStati.row.ISO2 = Cursor_qbe_decodestati_full.GetString("ISO2");
        mcDecodeStati.row.IDTBLS = Cursor_qbe_decodestati_full.GetString("IDTBLS");
        mcDecodeStati.row.IDBASE = Cursor_qbe_decodestati_full.GetString("IDBASE");
        mcDecodeStati.row.id = Cursor_qbe_decodestati_full.GetDouble("id");
        Cursor_qbe_decodestati_full.Next();
      }
      m_cConnectivityError = Cursor_qbe_decodestati_full.ErrorMessage();
      Cursor_qbe_decodestati_full.Close();
      mcDecodeStati.GoTop();
      // * --- Fill memory cursor mcDecodeCitta on qbe_decodecomuni_full
      mcDecodeCitta.Zap();
      if (Cursor_qbe_decodecomuni_full!=null)
        Cursor_qbe_decodecomuni_full.Close();
      Cursor_qbe_decodecomuni_full = new VQRHolder("qbe_decodecomuni_full",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_decodecomuni_full;
        Cursor_qbe_decodecomuni_full.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on qbe_decodecomuni_full returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_decodecomuni_full.Eof())) {
        mcDecodeCitta.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_qbe_decodecomuni_full.GetString("CITTA")));
        mcDecodeCitta.row.ID = Cursor_qbe_decodecomuni_full.GetDouble("ID");
        mcDecodeCitta.row.IDBASE = Cursor_qbe_decodecomuni_full.GetString("IDBASE");
        mcDecodeCitta.row.CITTAMIT = Cursor_qbe_decodecomuni_full.GetString("CITTAMIT");
        mcDecodeCitta.row.CAB = Cursor_qbe_decodecomuni_full.GetString("CAB");
        mcDecodeCitta.row.PROV = Cursor_qbe_decodecomuni_full.GetString("PROV");
        mcDecodeCitta.row.CAPMIT = Cursor_qbe_decodecomuni_full.GetString("CAPMIT");
        mcDecodeCitta.row.PKTBSTATI = Cursor_qbe_decodecomuni_full.GetString("PKTBSTATI");
        mcDecodeCitta.row.SIGLA = Cursor_qbe_decodecomuni_full.GetString("SIGLA");
        mcDecodeCitta.row.PREF = Cursor_qbe_decodecomuni_full.GetString("PREF");
        mcDecodeCitta.row.IDTBLS = Cursor_qbe_decodecomuni_full.GetString("IDTBLS");
        mcDecodeCitta.row.CITTA = Cursor_qbe_decodecomuni_full.GetString("CITTA");
        mcDecodeCitta.row.PR = Cursor_qbe_decodecomuni_full.GetString("PR");
        mcDecodeCitta.row.CATASTALE = Cursor_qbe_decodecomuni_full.GetString("CATASTALE");
        mcDecodeCitta.row.CAP = Cursor_qbe_decodecomuni_full.GetString("CAP");
        mcDecodeCitta.row.REGIONE = Cursor_qbe_decodecomuni_full.GetString("REGIONE");
        Cursor_qbe_decodecomuni_full.Next();
      }
      m_cConnectivityError = Cursor_qbe_decodecomuni_full.ErrorMessage();
      Cursor_qbe_decodecomuni_full.Close();
      mcDecodeCitta.GoTop();
      // * --- Fill memory cursor mcDecodeNascita on qbe_decodenascita_full
      mcDecodeNascita.Zap();
      if (Cursor_qbe_decodenascita_full!=null)
        Cursor_qbe_decodenascita_full.Close();
      Cursor_qbe_decodenascita_full = new VQRHolder("qbe_decodenascita_full",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_decodenascita_full;
        Cursor_qbe_decodenascita_full.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on qbe_decodenascita_full returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_decodenascita_full.Eof())) {
        mcDecodeNascita.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_qbe_decodenascita_full.GetString("DESCRI")));
        mcDecodeNascita.row.id = Cursor_qbe_decodenascita_full.GetDouble("id");
        mcDecodeNascita.row.account = Cursor_qbe_decodenascita_full.GetString("account");
        mcDecodeNascita.row.SIGLA = Cursor_qbe_decodenascita_full.GetString("SIGLA");
        mcDecodeNascita.row.DESCRI = Cursor_qbe_decodenascita_full.GetString("DESCRI");
        mcDecodeNascita.row.DATINI = Cursor_qbe_decodenascita_full.GetDate("DATINI");
        mcDecodeNascita.row.DATFIN = Cursor_qbe_decodenascita_full.GetDate("DATFIN");
        mcDecodeNascita.row.PROVINCIA = Cursor_qbe_decodenascita_full.GetString("PROVINCIA");
        Cursor_qbe_decodenascita_full.Next();
      }
      m_cConnectivityError = Cursor_qbe_decodenascita_full.ErrorMessage();
      Cursor_qbe_decodenascita_full.Close();
      mcDecodeNascita.GoTop();
      // * --- Fill memory cursor mcTbcitta on tbcitta
      mcTbcitta.Zap();
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      if (Cursor_tbcitta!=null)
        Cursor_tbcitta.Close();
      Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcitta;
        Cursor_tbcitta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on tbcitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcitta.Eof())) {
        mcTbcitta.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_tbcitta.GetString("CITTA")));
        mcTbcitta.row.IDBASE = Cursor_tbcitta.GetString("IDBASE");
        mcTbcitta.row.CITTA = Cursor_tbcitta.GetString("CITTA");
        mcTbcitta.row.CAB = Cursor_tbcitta.GetString("CAB");
        mcTbcitta.row.PROV = Cursor_tbcitta.GetString("PROV");
        mcTbcitta.row.CAP = Cursor_tbcitta.GetString("CAP");
        mcTbcitta.row.PKTBSTATI = Cursor_tbcitta.GetString("PKTBSTATI");
        mcTbcitta.row.SIGLA = Cursor_tbcitta.GetString("SIGLA");
        mcTbcitta.row.PREF = Cursor_tbcitta.GetString("PREF");
        mcTbcitta.row.IDTBLS = Cursor_tbcitta.GetString("IDTBLS");
        mcTbcitta.row.IDCITTA = Cursor_tbcitta.GetString("IDCITTA");
        mcTbcitta.row.IDISTAT = Cursor_tbcitta.GetString("IDISTAT");
        mcTbcitta.row.IDREGIO = Cursor_tbcitta.GetString("IDREGIO");
        mcTbcitta.row.DATAINI = Cursor_tbcitta.GetDate("DATAINI");
        mcTbcitta.row.DATAFIN = Cursor_tbcitta.GetDate("DATAFIN");
        Cursor_tbcitta.Next();
      }
      m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
      Cursor_tbcitta.Close();
      mcTbcitta.GoTop();
      // * --- Fill memory cursor mcTbcittaS on tbcitta
      mcTbcittaS.Zap();
      m_cServer = m_Ctx.GetServer("tbcitta");
      m_cPhName = m_Ctx.GetPhName("tbcitta");
      if (Cursor_tbcitta!=null)
        Cursor_tbcitta.Close();
      Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbcitta")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbcitta;
        Cursor_tbcitta.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on tbcitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbcitta.Eof())) {
        mcTbcittaS.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_tbcitta.GetString("SIGLA")));
        mcTbcittaS.row.IDBASE = Cursor_tbcitta.GetString("IDBASE");
        mcTbcittaS.row.CITTA = Cursor_tbcitta.GetString("CITTA");
        mcTbcittaS.row.CAB = Cursor_tbcitta.GetString("CAB");
        mcTbcittaS.row.PROV = Cursor_tbcitta.GetString("PROV");
        mcTbcittaS.row.CAP = Cursor_tbcitta.GetString("CAP");
        mcTbcittaS.row.PKTBSTATI = Cursor_tbcitta.GetString("PKTBSTATI");
        mcTbcittaS.row.SIGLA = Cursor_tbcitta.GetString("SIGLA");
        mcTbcittaS.row.PREF = Cursor_tbcitta.GetString("PREF");
        mcTbcittaS.row.IDTBLS = Cursor_tbcitta.GetString("IDTBLS");
        mcTbcittaS.row.IDCITTA = Cursor_tbcitta.GetString("IDCITTA");
        mcTbcittaS.row.IDISTAT = Cursor_tbcitta.GetString("IDISTAT");
        mcTbcittaS.row.IDREGIO = Cursor_tbcitta.GetString("IDREGIO");
        mcTbcittaS.row.DATAINI = Cursor_tbcitta.GetDate("DATAINI");
        mcTbcittaS.row.DATAFIN = Cursor_tbcitta.GetDate("DATAFIN");
        Cursor_tbcitta.Next();
      }
      m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
      Cursor_tbcitta.Close();
      mcTbcittaS.GoTop();
      // * --- Fill memory cursor mcTbstati on tbstati
      mcTbstati.Zap();
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      if (Cursor_tbstati!=null)
        Cursor_tbstati.Close();
      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstati;
        Cursor_tbstati.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcTbstati.AppendWithTrimmedKey(Cursor_tbstati.GetString("CODSTA"));
        mcTbstati.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcTbstati.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcTbstati.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcTbstati.row.ISO = Cursor_tbstati.GetString("ISO");
        mcTbstati.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcTbstati.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcTbstati.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcTbstati.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcTbstati.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcTbstati.GoTop();
      // * --- Fill memory cursor mcTbstatiD on tbstati
      mcTbstatiD.Zap();
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      if (Cursor_tbstati!=null)
        Cursor_tbstati.Close();
      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstati;
        Cursor_tbstati.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcTbstatiD.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_tbstati.GetString("DESCRI")));
        mcTbstatiD.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcTbstatiD.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcTbstatiD.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcTbstatiD.row.ISO = Cursor_tbstati.GetString("ISO");
        mcTbstatiD.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcTbstatiD.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcTbstatiD.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcTbstatiD.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcTbstatiD.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcTbstatiD.GoTop();
      // * --- Fill memory cursor mcAnadip on anadip
      mcAnadip.Zap();
      m_cServer = m_Ctx.GetServer("anadip");
      m_cPhName = m_Ctx.GetPhName("anadip");
      if (Cursor_anadip!=null)
        Cursor_anadip.Close();
      Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_anadip;
        Cursor_anadip.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on anadip returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_anadip.Eof())) {
        mcAnadip.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_anadip.GetString("CODDIP")));
        mcAnadip.row.CODDIP = Cursor_anadip.GetString("CODDIP");
        mcAnadip.row.DESCRIZ = Cursor_anadip.GetString("DESCRIZ");
        mcAnadip.row.IDCITTA = Cursor_anadip.GetString("IDCITTA");
        mcAnadip.row.DESCCIT = Cursor_anadip.GetString("DESCCIT");
        mcAnadip.row.PROVINCIA = Cursor_anadip.GetString("PROVINCIA");
        mcAnadip.row.CAB = Cursor_anadip.GetString("CAB");
        mcAnadip.row.IDBASE = Cursor_anadip.GetString("IDBASE");
        mcAnadip.row.AGENTE = Cursor_anadip.GetString("AGENTE");
        mcAnadip.row.MACROAGENTE = Cursor_anadip.GetString("MACROAGENTE");
        mcAnadip.row.TERMINALID = Cursor_anadip.GetString("TERMINALID");
        mcAnadip.row.DOMICILIO = Cursor_anadip.GetString("DOMICILIO");
        mcAnadip.row.TELEFONO = Cursor_anadip.GetString("TELEFONO");
        mcAnadip.row.CODLOC = Cursor_anadip.GetString("CODLOC");
        mcAnadip.row.ABICABSARA = Cursor_anadip.GetString("ABICABSARA");
        mcAnadip.row.NUOVO = Cursor_anadip.GetString("NUOVO");
        mcAnadip.row.CAP = Cursor_anadip.GetString("CAP");
        mcAnadip.row.AGACCODE = Cursor_anadip.GetString("AGACCODE");
        mcAnadip.row.NAZAGENTE = Cursor_anadip.GetString("NAZAGENTE");
        mcAnadip.row.OPXSOSCLI = Cursor_anadip.GetDouble("OPXSOSCLI");
        mcAnadip.row.OPXSOSAGE = Cursor_anadip.GetDouble("OPXSOSAGE");
        mcAnadip.row.VALCOMPL = Cursor_anadip.GetString("VALCOMPL");
        mcAnadip.row.ANOMOPER = Cursor_anadip.GetString("ANOMOPER");
        mcAnadip.row.AGEREGIO = Cursor_anadip.GetString("AGEREGIO");
        mcAnadip.row.FLGATT = Cursor_anadip.GetString("FLGATT");
        mcAnadip.row.CODAGE = Cursor_anadip.GetString("CODAGE");
        mcAnadip.row.TIPOSV = Cursor_anadip.GetString("TIPOSV");
        mcAnadip.row.FLGNOAUA = Cursor_anadip.GetString("FLGNOAUA");
        mcAnadip.row.FLGWUPOS = Cursor_anadip.GetString("FLGWUPOS");
        mcAnadip.row.CATEG01 = Cursor_anadip.GetString("CATEG01");
        mcAnadip.row.CATEG02 = Cursor_anadip.GetString("CATEG02");
        mcAnadip.row.CATEG03 = Cursor_anadip.GetString("CATEG03");
        mcAnadip.row.CATEG04 = Cursor_anadip.GetString("CATEG04");
        mcAnadip.row.CATEG05 = Cursor_anadip.GetString("CATEG05");
        mcAnadip.row.CATEGORIA = Cursor_anadip.GetString("CATEGORIA");
        mcAnadip.row.CAB2 = Cursor_anadip.GetString("CAB2");
        mcAnadip.row.RISGLOB = Cursor_anadip.GetString("RISGLOB");
        mcAnadip.row.DATAPROF = Cursor_anadip.GetDate("DATAPROF");
        mcAnadip.row.CODICEAAMS = Cursor_anadip.GetString("CODICEAAMS");
        mcAnadip.row.CONCESSIONE = Cursor_anadip.GetString("CONCESSIONE");
        mcAnadip.row.CODFISC = Cursor_anadip.GetString("CODFISC");
        mcAnadip.row.PARTIVA = Cursor_anadip.GetString("PARTIVA");
        mcAnadip.row.TIPOAGENTE = Cursor_anadip.GetString("TIPOAGENTE");
        mcAnadip.row.NUMCIVICO = Cursor_anadip.GetString("NUMCIVICO");
        mcAnadip.row.DATAINI = Cursor_anadip.GetDate("DATAINI");
        mcAnadip.row.DATAFINE = Cursor_anadip.GetDate("DATAFINE");
        mcAnadip.row.SERRIMDEN = Cursor_anadip.GetString("SERRIMDEN");
        mcAnadip.row.FLGCOMPL = Cursor_anadip.GetDouble("FLGCOMPL");
        Cursor_anadip.Next();
      }
      m_cConnectivityError = Cursor_anadip.ErrorMessage();
      Cursor_anadip.Close();
      mcAnadip.GoTop();
      // * --- Fill memory cursor mcStatiN on tbluonas
      mcStatiN.Zap();
      m_cServer = m_Ctx.GetServer("tbluonas");
      m_cPhName = m_Ctx.GetPhName("tbluonas");
      if (Cursor_tbluonas!=null)
        Cursor_tbluonas.Close();
      Cursor_tbluonas = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbluonas")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbluonas;
        Cursor_tbluonas.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on tbluonas returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbluonas.Eof())) {
        mcStatiN.AppendWithTrimmedKey(CPLib.LRTrim(Cursor_tbluonas.GetString("SIGLA")));
        mcStatiN.row.SIGLA = Cursor_tbluonas.GetString("SIGLA");
        mcStatiN.row.DESCRI = Cursor_tbluonas.GetString("DESCRI");
        mcStatiN.row.DATINI = Cursor_tbluonas.GetDate("DATINI");
        mcStatiN.row.DATFIN = Cursor_tbluonas.GetDate("DATFIN");
        mcStatiN.row.PROVINCIA = Cursor_tbluonas.GetString("PROVINCIA");
        Cursor_tbluonas.Next();
      }
      m_cConnectivityError = Cursor_tbluonas.ErrorMessage();
      Cursor_tbluonas.Close();
      mcStatiN.GoTop();
      /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
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
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _intercod := intermbo->CODINTER */
        _intercod = Cursor_intermbo.GetString("CODINTER");
        /* _intercit := intermbo->DESCCIT */
        _intercit = Cursor_intermbo.GetString("DESCCIT");
        /* _intercab := intermbo->CODCAB */
        _intercab = Cursor_intermbo.GetString("CODCAB");
        /* _interprv := intermbo->PROVINCIA */
        _interprv = Cursor_intermbo.GetString("PROVINCIA");
        /* _intertip := intermbo->TIPINTER */
        _intertip = Cursor_intermbo.GetString("TIPINTER");
        /* _wuposonly := intermbo->FLGAWUPOS */
        _wuposonly = Cursor_intermbo.GetString("FLGAWUPOS");
        /* _ggscad := intermbo->WUGIOSCA */
        _ggscad = CPLib.Round(Cursor_intermbo.GetDouble("WUGIOSCA"),0);
        /* _limite20 := iif(Empty(intermbo->LIMITE20),CharToDate('20210101'),intermbo->LIMITE20) */
        _limite20 = (CPLib.Empty(Cursor_intermbo.GetDate("LIMITE20"))?CPLib.CharToDate("20210101"):Cursor_intermbo.GetDate("LIMITE20"));
        /* _pathdoc := intermbo->RICEVUTE */
        _pathdoc = Cursor_intermbo.GetString("RICEVUTE");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* If pModo='B' or pModo='X' */
      if (CPLib.eqr(pModo,"B") || CPLib.eqr(pModo,"X")) {
        /* _pathfile := Strtran(FileLibMit.GetLocation(),'\','/') */
        _pathfile = CPLib.Strtran(FileLibMit.GetLocation(),"\\","/");
        /* _pathfile := Strtran(_pathfile,'/servlet/','') */
        _pathfile = CPLib.Strtran(_pathfile,"/servlet/","");
      } else { // Else
        /* _pathfile := gPathApp */
        _pathfile = gPathApp;
      } // End If
      // Legge i file
      File di = new File(CPLib.LRTrim(_pathdoc+"/appo/"+CPLib.LRTrim(_azienda)));
      File fl[] = di.listFiles();
      int _i;
      int count=0;
      for (_i=0; _i < fl.length; _i++)  {
      /* If At('.ZIP',Upper(fl[_i].getName())) >0 */
      if (CPLib.gt(CPLib.At(".ZIP",CPLib.Upper(fl[_i].getName())),0)) {
        /* Exec Routine arrt_writelog_imp('IMPORT','','Trovato File '+ LRTrim(fl[_i].getName())) */
        arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Trovato File "+CPLib.LRTrim(fl[_i].getName()));
        /* mcZips.AppendBlank() */
        mcZips.AppendBlank();
        /* mcZips.nomefile :=  LRTrim(fl[_i].getName()) */
        mcZips.row.nomefile = CPLib.LRTrim(fl[_i].getName());
        /* mcFiles.priorita := 1 */
        mcFiles.row.priorita = 1;
        /* mcFiles.SaveRow() */
        mcFiles.SaveRow();
      } else { // Else
        /* If At('POS',fl[_i].getName()) > 0 or At('TRX',fl[_i].getName()) > 0  */
        if (CPLib.gt(CPLib.At("POS",fl[_i].getName()),0) || CPLib.gt(CPLib.At("TRX",fl[_i].getName()),0)) {
          /* Exec Routine arrt_writelog_imp('IMPORT','','Trovato File '+ LRTrim(fl[_i].getName())) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Trovato File "+CPLib.LRTrim(fl[_i].getName()));
          /* mcFiles.AppendBlank() */
          mcFiles.AppendBlank();
          /* mcFiles.nomefile :=  LRTrim(fl[_i].getName()) */
          mcFiles.row.nomefile = CPLib.LRTrim(fl[_i].getName());
          /* mcFiles.priorita := iif(At('AUIPOS',fl[_i].getName()) > 0,1,2) */
          mcFiles.row.priorita = (CPLib.gt(CPLib.At("AUIPOS",fl[_i].getName()),0)?1:2);
          /* mcFiles.SaveRow() */
          mcFiles.SaveRow();
        } // End If
      } // End If
      /* } */
      };
      /* w_destfin := 'O' // Destinazione finale */
      w_destfin = "O";
      /* Import Soggetti */
      /* _datadmin := arfn_dateminus(Date(),365) */
      _datadmin = arfn_dateminusR.Make(m_Ctx,this).Run(CPLib.Date(),365);
      /* _datamin := DateToChar(_datadmin) */
      _datamin = CPLib.DateToChar(_datadmin);
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      for (MemoryCursorRow_mclistafile_mcrdef rowZips : mcZips._iterable_()) {
        /* czipfile := LRTrim(rowZips.nomefile) */
        czipfile = CPLib.LRTrim(rowZips.nomefile);
        /* Exec "Estrazione ZIP" Page 3:Page_3 */
        Page_3();
      }
      MemoryCursor_mclistafile_mcrdef cpmc_00000174;
      cpmc_00000174 = new MemoryCursor_mclistafile_mcrdef();
      for (MemoryCursorRow_mclistafile_mcrdef rowFiles : mcFiles._iterable_()) {
        cpmc_00000174.Append(rowFiles);
      }
      for (MemoryCursorRow_mclistafile_mcrdef rowFiles : cpmc_00000174._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_mclistafile_mcrdef>(){  public int compare(MemoryCursorRow_mclistafile_mcrdef r1,MemoryCursorRow_mclistafile_mcrdef r2){    if (CPLib.gt(r1.priorita,r2.priorita)) return 1;    if (CPLib.lt(r1.priorita,r2.priorita)) return -1;    return 0;  }})) {
        /* If pModo='R' */
        if (CPLib.eqr(pModo,"R")) {
          /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* ElseIf At(pModo,'|Y|M') <> 0 */
        } else if (CPLib.ne(CPLib.At(pModo,"|Y|M"),0)) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime())) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
          /* _gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
          _gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        } // End If
        /* mcErrate.Zap() */
        mcErrate.Zap();
        /* mcErrAge.Zap() */
        mcErrAge.Zap();
        /* _nerrori := 0 */
        _nerrori = CPLib.Round(0,0);
        /* _nerraua := 0 */
        _nerraua = CPLib.Round(0,0);
        /* _nerrage := 0 */
        _nerrage = CPLib.Round(0,0);
        /* _totmovi := 0 */
        _totmovi = CPLib.Round(0,0);
        /* nomefileimport := LRTrim(rowFiles.nomefile) */
        nomefileimport = CPLib.LRTrim(rowFiles.nomefile);
        /* nomefileorg := LRTrim(rowFiles.nomefile) */
        nomefileorg = CPLib.LRTrim(rowFiles.nomefile);
        /* _trxdate := Substr(nomefileimport,8,8) */
        _trxdate = CPLib.Substr(nomefileimport,8,8);
        /* _dtimport := NullDateTime() */
        _dtimport = CPLib.NullDateTime();
        /* _filename := _pathdoc+"/appo/"+LRTrim(_azienda)+"/"+LRTrim(nomefileimport) // Nome file con path */
        _filename = _pathdoc+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport);
        /* If At('POS',Upper(nomefileimport)) <> 0 */
        if (CPLib.ne(CPLib.At("POS",CPLib.Upper(nomefileimport)),0)) {
          /* mcAgeDuo.Zap() */
          mcAgeDuo.Zap();
          /* mcAgenzie.Zap() */
          mcAgenzie.Zap();
          /* _nerrage := 0 */
          _nerrage = CPLib.Round(0,0);
          /* Exec "Agenzie" Page 6:Page_6 */
          Page_6();
          /* If _nerrage > 0 */
          if (CPLib.gt(_nerrage,0)) {
            /* Exec "File Excel Errori Agenzie" Page 10:Page_10 */
            Page_10();
          } // End If
        } else { // Else
          // * --- Fill memory cursor mcAnadip on anadip
          mcAnadip.Zap();
          m_cServer = m_Ctx.GetServer("anadip");
          m_cPhName = m_Ctx.GetPhName("anadip");
          if (Cursor_anadip!=null)
            Cursor_anadip.Close();
          Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          {
            final CPResultSet m_TheCursor = Cursor_anadip;
            Cursor_anadip.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,50000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_imp_dati_rtra: query on anadip returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_anadip.Eof())) {
            mcAnadip.AppendWithTrimmedKey(Cursor_anadip.GetString("CODDIP"));
            mcAnadip.row.CODDIP = Cursor_anadip.GetString("CODDIP");
            mcAnadip.row.DESCRIZ = Cursor_anadip.GetString("DESCRIZ");
            mcAnadip.row.IDCITTA = Cursor_anadip.GetString("IDCITTA");
            mcAnadip.row.DESCCIT = Cursor_anadip.GetString("DESCCIT");
            mcAnadip.row.PROVINCIA = Cursor_anadip.GetString("PROVINCIA");
            mcAnadip.row.CAB = Cursor_anadip.GetString("CAB");
            mcAnadip.row.IDBASE = Cursor_anadip.GetString("IDBASE");
            mcAnadip.row.AGENTE = Cursor_anadip.GetString("AGENTE");
            mcAnadip.row.MACROAGENTE = Cursor_anadip.GetString("MACROAGENTE");
            mcAnadip.row.TERMINALID = Cursor_anadip.GetString("TERMINALID");
            mcAnadip.row.DOMICILIO = Cursor_anadip.GetString("DOMICILIO");
            mcAnadip.row.TELEFONO = Cursor_anadip.GetString("TELEFONO");
            mcAnadip.row.CODLOC = Cursor_anadip.GetString("CODLOC");
            mcAnadip.row.ABICABSARA = Cursor_anadip.GetString("ABICABSARA");
            mcAnadip.row.NUOVO = Cursor_anadip.GetString("NUOVO");
            mcAnadip.row.CAP = Cursor_anadip.GetString("CAP");
            mcAnadip.row.AGACCODE = Cursor_anadip.GetString("AGACCODE");
            mcAnadip.row.NAZAGENTE = Cursor_anadip.GetString("NAZAGENTE");
            mcAnadip.row.OPXSOSCLI = Cursor_anadip.GetDouble("OPXSOSCLI");
            mcAnadip.row.OPXSOSAGE = Cursor_anadip.GetDouble("OPXSOSAGE");
            mcAnadip.row.VALCOMPL = Cursor_anadip.GetString("VALCOMPL");
            mcAnadip.row.ANOMOPER = Cursor_anadip.GetString("ANOMOPER");
            mcAnadip.row.AGEREGIO = Cursor_anadip.GetString("AGEREGIO");
            mcAnadip.row.FLGATT = Cursor_anadip.GetString("FLGATT");
            mcAnadip.row.CODAGE = Cursor_anadip.GetString("CODAGE");
            mcAnadip.row.TIPOSV = Cursor_anadip.GetString("TIPOSV");
            mcAnadip.row.FLGNOAUA = Cursor_anadip.GetString("FLGNOAUA");
            mcAnadip.row.FLGWUPOS = Cursor_anadip.GetString("FLGWUPOS");
            mcAnadip.row.CATEG01 = Cursor_anadip.GetString("CATEG01");
            mcAnadip.row.CATEG02 = Cursor_anadip.GetString("CATEG02");
            mcAnadip.row.CATEG03 = Cursor_anadip.GetString("CATEG03");
            mcAnadip.row.CATEG04 = Cursor_anadip.GetString("CATEG04");
            mcAnadip.row.CATEG05 = Cursor_anadip.GetString("CATEG05");
            mcAnadip.row.CATEGORIA = Cursor_anadip.GetString("CATEGORIA");
            mcAnadip.row.CAB2 = Cursor_anadip.GetString("CAB2");
            mcAnadip.row.RISGLOB = Cursor_anadip.GetString("RISGLOB");
            mcAnadip.row.DATAPROF = Cursor_anadip.GetDate("DATAPROF");
            mcAnadip.row.CODICEAAMS = Cursor_anadip.GetString("CODICEAAMS");
            mcAnadip.row.CONCESSIONE = Cursor_anadip.GetString("CONCESSIONE");
            mcAnadip.row.CODFISC = Cursor_anadip.GetString("CODFISC");
            mcAnadip.row.PARTIVA = Cursor_anadip.GetString("PARTIVA");
            mcAnadip.row.TIPOAGENTE = Cursor_anadip.GetString("TIPOAGENTE");
            mcAnadip.row.NUMCIVICO = Cursor_anadip.GetString("NUMCIVICO");
            mcAnadip.row.DATAINI = Cursor_anadip.GetDate("DATAINI");
            mcAnadip.row.DATAFINE = Cursor_anadip.GetDate("DATAFINE");
            mcAnadip.row.SERRIMDEN = Cursor_anadip.GetString("SERRIMDEN");
            mcAnadip.row.FLGCOMPL = Cursor_anadip.GetDouble("FLGCOMPL");
            Cursor_anadip.Next();
          }
          m_cConnectivityError = Cursor_anadip.ErrorMessage();
          Cursor_anadip.Close();
          mcAnadip.GoTop();
          /* If pErrAUI='N' */
          if (CPLib.eqr(pErrAUI,"N")) {
            // * --- Read from mtimport
            m_cServer = m_Ctx.GetServer("mtimport");
            m_cPhName = m_Ctx.GetPhName("mtimport");
            m_cSql = "";
            m_cSql = m_cSql+"MTCODMAGE="+CPSql.SQLValueAdapter(CPLib.ToSQL("XXXXX","C",5,0,m_cServer),m_cServer,"XXXXX");
            m_cSql = m_cSql+" and MTNOMFIL="+CPSql.SQLValueAdapter(CPLib.ToSQL(nomefileimport,"C",60,0,m_cServer),m_cServer,nomefileimport);
            if (m_Ctx.IsSharedTemp("mtimport")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("MTDATIMP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _dtimport = Read_Cursor.GetDateTime("MTDATIMP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on mtimport into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _dtimport = CPLib.NullDateTime();
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If Empty(_dtimport) */
          if (CPLib.Empty(_dtimport)) {
            /* _errorig := 0 */
            _errorig = CPLib.Round(0,0);
            /* If At('.TXT',Upper(nomefileimport)) > 0 */
            if (CPLib.gt(CPLib.At(".TXT",CPLib.Upper(nomefileimport)),0)) {
              /* Exec "Controlli Preliminari File (Tipo G)" Page 11:Page_11 */
              Page_11();
            } // End If
            /* If _errorig = 0 and pTipo='I' */
            if (CPLib.eqr(_errorig,0) && CPLib.eqr(pTipo,"I")) {
              /* If pErrAUI='N' */
              if (CPLib.eqr(pErrAUI,"N")) {
                /* _omaxid := 0 */
                _omaxid = CPLib.Round(0,0);
                /* _omaxpg := 0 */
                _omaxpg = CPLib.Round(0,0);
                /* _omaxim := 0 */
                _omaxim = CPLib.Round(0,0);
                /* _pmaxim := 0 */
                _pmaxim = CPLib.Round(0,0);
                /* _wmaxpg := 0 */
                _wmaxpg = CPLib.Round(0,0);
                /* _opxmax := 0 */
                _opxmax = CPLib.Round(0,0);
                // * --- Select from cpwarn
                m_cServer = m_Ctx.GetServer("cpwarn");
                m_cPhName = m_Ctx.GetPhName("cpwarn");
                if (Cursor_cpwarn!=null)
                  Cursor_cpwarn.Close();
                Cursor_cpwarn = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpwarn")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_cpwarn.Eof())) {
                  /* If w_tipodest='P' */
                  if (CPLib.eqr(w_tipodest,"P")) {
                    /* Case At('PPOPER1',cpwarn->tablecode) <> 0 */
                    if (CPLib.ne(CPLib.At("PPOPER1",Cursor_cpwarn.GetString("tablecode")),0)) {
                      /* _omaxid := cpwarn->autonum */
                      _omaxid = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                      /* Case At('PPOPER2',cpwarn->tablecode) <> 0 */
                    } else if (CPLib.ne(CPLib.At("PPOPER2",Cursor_cpwarn.GetString("tablecode")),0)) {
                      /* _omaxpg := cpwarn->autonum */
                      _omaxpg = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                    } // End Case
                  } else { // Else
                    /* Case At('POPERAZ1',cpwarn->tablecode) <> 0 */
                    if (CPLib.ne(CPLib.At("POPERAZ1",Cursor_cpwarn.GetString("tablecode")),0)) {
                      /* _omaxid := cpwarn->autonum */
                      _omaxid = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                      /* Case At('POPERAZ2',cpwarn->tablecode) <> 0 */
                    } else if (CPLib.ne(CPLib.At("POPERAZ2",Cursor_cpwarn.GetString("tablecode")),0)) {
                      /* _omaxpg := cpwarn->autonum */
                      _omaxpg = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                    } // End Case
                  } // End If
                  /* Case At('PRGIMPOPE',cpwarn->tablecode) <> 0 */
                  if (CPLib.ne(CPLib.At("PRGIMPOPE",Cursor_cpwarn.GetString("tablecode")),0)) {
                    /* _omaxim := cpwarn->autonum */
                    _omaxim = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                    /* Case At('PRGIMPOCLI',cpwarn->tablecode) <> 0 */
                  } else if (CPLib.ne(CPLib.At("PRGIMPOCLI",Cursor_cpwarn.GetString("tablecode")),0)) {
                    /* _pmaxim := cpwarn->autonum */
                    _pmaxim = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                    /* Case At('PSTOPERS',cpwarn->tablecode) <> 0 */
                  } else if (CPLib.ne(CPLib.At("PSTOPERS",Cursor_cpwarn.GetString("tablecode")),0)) {
                    /* _wmaxpg := cpwarn->autonum */
                    _wmaxpg = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                    /* Case At('PROGOPEX',cpwarn->tablecode) <> 0 */
                  } else if (CPLib.ne(CPLib.At("PROGOPEX",Cursor_cpwarn.GetString("tablecode")),0)) {
                    /* _opxmax := cpwarn->autonum */
                    _opxmax = CPLib.Round(Cursor_cpwarn.GetDouble("autonum"),0);
                  } // End Case
                  Cursor_cpwarn.Next();
                }
                m_cConnectivityError = Cursor_cpwarn.ErrorMessage();
                Cursor_cpwarn.Close();
                // * --- End Select
              } // End If
              /* _cpers := 0 */
              _cpers = CPLib.Round(0,0);
              /* _coper := 0 */
              _coper = CPLib.Round(0,0);
              /* Exec "Lettura file import" Page 15:Page_15 */
              Page_15();
              /* Exec "Elabora il file" Page 2:Page_2 */
              Page_2();
              /* ElseIf _errorig = 0 and pTipo='G' */
            } else if (CPLib.eqr(_errorig,0) && CPLib.eqr(pTipo,"G")) {
              /* If At(pModo,'|R|M|Y') <> 0 */
              if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
                /* gMsgProc := gMsgProc +"Sono stati rilevati "+LRTrim(Str(_errorig,10,0))+" errori di tipo G."+ NL */
                gMsgProc = gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_errorig,10,0))+" errori di tipo G."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Il file "+LRTrim(nomefileimport) + " è pronto per l'import schedulato"+ NL */
                gMsgProc = gMsgProc+"Il file "+CPLib.LRTrim(nomefileimport)+" è pronto per l'import schedulato"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                /* Exec Routine arrt_writelog_imp('IMPORT','',"Sono stati rilevati "+LRTrim(Str(_errorig,10,0))+" errori di tipo G.") */
                arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_errorig,10,0))+" errori di tipo G.");
                /* _gMsgProc := _gMsgProc +"Sono stati rilevati "+LRTrim(Str(_errorig,10,0))+" errori di tipo G."+ NL */
                _gMsgProc = _gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_errorig,10,0))+" errori di tipo G."+"\n";
                /* _gMsgProc := _gMsgProc +"Il file "+LRTrim(nomefileimport) + " è pronto per l'import schedulato"+ NL */
                _gMsgProc = _gMsgProc+"Il file "+CPLib.LRTrim(nomefileimport)+" è pronto per l'import schedulato"+"\n";
              } // End If
            } else { // Else
              /* If At(pModo,'|R|M|Y') <> 0 */
              if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
                /* gMsgProc := gMsgProc +"Sono stati rilevati "+LRTrim(Str(_errorig,10,0))+" errori di tipo G."+ NL */
                gMsgProc = gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_errorig,10,0))+" errori di tipo G."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                /* Exec Routine arrt_writelog_imp('IMPORT','',"Sono stati rilevati "+LRTrim(Str(_errorig,10,0))+" errori di tipo G.") */
                arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_errorig,10,0))+" errori di tipo G.");
                /* _gMsgProc := _gMsgProc +"Sono stati rilevati "+LRTrim(Str(_errorig,10,0))+" errori di tipo G."+ NL */
                _gMsgProc = _gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_errorig,10,0))+" errori di tipo G."+"\n";
              } // End If
            } // End If
          } else { // Else
            /* If At(pModo,'|R|M|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
              /* gMsgProc := gMsgProc +"Il file "+LRTrim(nomefileimport)+" è già stato importato."+ NL */
              gMsgProc = gMsgProc+"Il file "+CPLib.LRTrim(nomefileimport)+" è già stato importato."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* Exec Routine arrt_writelog_imp('IMPORT','',"Il file "+LRTrim(nomefileimport)+" è già stato importato.") */
              arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Il file "+CPLib.LRTrim(nomefileimport)+" è già stato importato.");
              /* _gMsgProc := _gMsgProc +"Il file "+LRTrim(nomefileimport)+" è già stato importato"+ NL */
              _gMsgProc = _gMsgProc+"Il file "+CPLib.LRTrim(nomefileimport)+" è già stato importato"+"\n";
            } // End If
            /* FileLibMit.DeleteFilePath(_pathdoc+"/appo/"+LRTrim(_azienda)+"/"+LRTrim(nomefileimport)) */
            FileLibMit.DeleteFilePath(_pathdoc+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
          } // End If
        } // End If
        /* If _nerrori > 0 */
        if (CPLib.gt(_nerrori,0)) {
          /* _filen := "ERRTRX_"+_trxdate+".xlsx" */
          _filen = "ERRTRX_"+_trxdate+".xlsx";
          /* Exec "File Excel Errori Transazioni" Page 9:Page_9 */
          Page_9();
        } // End If
        /* If At(pModo,'|R|M|Y') <> 0 */
        if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
          /* If _errorig > 0 */
          if (CPLib.gt(_errorig,0)) {
            /* gMsgImp := 'Importazione dati scartata. Premere il bottone con la lente per prelevare i file degli errori' // Messaggio Import */
            gMsgImp = "Importazione dati scartata. Premere il bottone con la lente per prelevare i file degli errori";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } else { // Else
            /* If (_nerrori + _nerrage) > 0 */
            if (CPLib.gt((_nerrori+_nerrage),0)) {
              /* gMsgImp := 'Importazione dati terminata. Premere il bottone con la lente per prelevare i file degli scarti' // Messaggio Import */
              gMsgImp = "Importazione dati terminata. Premere il bottone con la lente per prelevare i file degli scarti";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* ElseIf (_nerrori + _nerrage) < 0 */
            } else if (CPLib.lt((_nerrori+_nerrage),0)) {
              /* gMsgImp := 'Importazione dati terminata per errori. Il file di import è stato scartato' // Messaggio Import */
              gMsgImp = "Importazione dati terminata per errori. Il file di import è stato scartato";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } else { // Else
              /* gMsgImp := 'Importazione dati terminata. Non sono stati rilevati errori' // Messaggio Import */
              gMsgImp = "Importazione dati terminata. Non sono stati rilevati errori";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End If
          } // End If
          /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime())) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
          /* _gMsgProc := _gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
          _gMsgProc = _gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          /* If _errorig > 0 */
          if (CPLib.gt(_errorig,0)) {
            /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_azienda)+"'",'',20) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_azienda)+"'","",20);
            // * --- Insert into log_app from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("log_app");
            m_cPhName = m_Ctx.GetPhName("log_app");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000001CD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001CD(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("IMPORT DATI RTRA","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_filescarti,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("export/"+CPLib.LRTrim(_azienda),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
          /* If _nerrori > 0 */
          if (CPLib.gt(_nerrori,0)) {
            /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_azienda)+"'",'',20) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_azienda)+"'","",20);
            // * --- Insert into log_app from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("log_app");
            m_cPhName = m_Ctx.GetPhName("log_app");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000001D0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001D0(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("IMPORT DATI RTRA","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_filen,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("export/"+CPLib.LRTrim(_azienda),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
          /* If _nerrage > 0 */
          if (CPLib.gt(_nerrage,0)) {
            /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_azienda)+"'",'',20) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_azienda)+"'","",20);
            // * --- Insert into log_app from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("log_app");
            m_cPhName = m_Ctx.GetPhName("log_app");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000001D3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001D3(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("IMPORT DATI RTRA","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_filen,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("export/"+CPLib.LRTrim(_azienda),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
          /* If (_errorig + _nerrori + _nerrage) = 0 */
          if (CPLib.eqr((_errorig+_nerrori+_nerrage),0)) {
            /* cProg := Utilities.GetAutonumber("PRGLOG\'"+LRTrim(_azienda)+"'",'',20) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGLOG\\'"+CPLib.LRTrim(_azienda)+"'","",20);
            // * --- Insert into log_app from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("log_app");
            m_cPhName = m_Ctx.GetPhName("log_app");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"log_app",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000001D6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001D6(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Import Dati","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_gMsgProc,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Scheduler","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("IMPORT DATI RTRA","?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"log_app",true);
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
      }
      /* LibreriaMit.FreeMem() */
      LibreriaMit.FreeMem();
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbmacage!=null)
          Cursor_tbmacage.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_decodestati_full!=null)
          Cursor_qbe_decodestati_full.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_decodecomuni_full!=null)
          Cursor_qbe_decodecomuni_full.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_decodenascita_full!=null)
          Cursor_qbe_decodenascita_full.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbluonas!=null)
          Cursor_tbluonas.Close();
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cpwarn!=null)
          Cursor_cpwarn.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* cNumInv := 0 */
      cNumInv = CPLib.Round(0,0);
      /* conta := 0 */
      conta = 0;
      /* _contarig := 0 */
      _contarig = CPLib.Round(0,0);
      /* Legge il file */
      /* If w_delprec='S' */
      if (CPLib.eqr(w_delprec,"S")) {
      } // End If
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000001E1status;
      nTry000001E1status = m_Sql.GetTransactionStatus();
      String cTry000001E1msg;
      cTry000001E1msg = m_Sql.TransactionErrorMessage();
      try {
        for (MemoryCursorRow_mcerratedef_mcrdef rowNuove : mcNuove._iterable_()) {
          /* rowLettura.Copy(rowNuove) // Legge le righe per l'elaborazione */
          rowLettura.Copy(rowNuove);
          /* conta := conta + 1 */
          conta = conta+1;
          /* Exec "Elaborazione Riga" Page 16:Page_16 */
          Page_16();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* If _esito=-1 */
          if (CPLib.eqr(_esito,-1)) {
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        }
        /* If pErrAUI='N' */
        if (CPLib.eqr(pErrAUI,"N")) {
          /* If At(pModo,'|R|M|Y') <> 0 */
          if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
            /* gMsgProc := gMsgProc + 'Ora Inizio Scrittura Soggetti: '+ arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Inizio Scrittura Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* _gMsgProc := _gMsgProc + 'Ora Inizio Scrittura Soggetti: '+ arfn_fdatetime(DateTime()) + NL */
            _gMsgProc = _gMsgProc+"Ora Inizio Scrittura Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Inizio Scrittura Soggetti: '+ arfn_fdatetime(DateTime())) */
            arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Inizio Scrittura Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
          } // End If
          /* mcNuove.Zap() */
          mcNuove.Zap();
          /* Exec "Scrive dati soggetti" Page 17:Page_17 */
          Page_17();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* If At(pModo,'|R|M|Y') <> 0 */
          if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
            /* gMsgProc := gMsgProc + 'Ora Fine Scrittura Soggetti: '+ arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Fine Scrittura Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc + 'Ora Inizio Scrittura Operazioni: '+ arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Inizio Scrittura Operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* _gMsgProc := _gMsgProc + 'Ora Fine Scrittura Soggetti: '+ arfn_fdatetime(DateTime()) + NL */
            _gMsgProc = _gMsgProc+"Ora Fine Scrittura Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Fine Scrittura Soggetti: '+ arfn_fdatetime(DateTime())) */
            arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Fine Scrittura Soggetti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
          } // End If
          /* mcPersonbo.Zap() */
          mcPersonbo.Zap();
          /* If pImpAna='N' */
          if (CPLib.eqr(pImpAna,"N")) {
            /* _gMsgProc := _gMsgProc + 'Ora Inizio Scrittura Operazioni: '+ arfn_fdatetime(DateTime()) + NL */
            _gMsgProc = _gMsgProc+"Ora Inizio Scrittura Operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Inizio Scrittura Operazioni: '+ arfn_fdatetime(DateTime())) */
            arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Inizio Scrittura Operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
            /* Exec "Inserimento Transazione" Page 8:Page_8 */
            Page_8();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* mcOperazbo.Zap() // Operazioni */
            mcOperazbo.Zap();
            /* If At(pModo,'|R|M|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
              /* gMsgProc := gMsgProc + 'Ora Fine Scrittura Operazioni: '+ arfn_fdatetime(DateTime()) + NL */
              gMsgProc = gMsgProc+"Ora Fine Scrittura Operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* _gMsgProc := _gMsgProc + 'Ora Fine Scrittura Operazioni: '+ arfn_fdatetime(DateTime()) + NL */
              _gMsgProc = _gMsgProc+"Ora Fine Scrittura Operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
              /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Fine Scrittura Operazioni: '+ arfn_fdatetime(DateTime())) */
              arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Fine Scrittura Operazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
            } // End If
          } // End If
        } // End If
        /* If pImpAna='N' */
        if (CPLib.eqr(pImpAna,"N")) {
          /* If At(pModo,'|R|M|Y') <> 0 */
          if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
            /* gMsgProc := gMsgProc + 'Ora Inizio Scrittura Modifiche/Cancellazioni: '+ arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Inizio Scrittura Modifiche/Cancellazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* _gMsgProc := _gMsgProc + 'Ora Inizio Scrittura Modifiche/Cancellazioni: '+ arfn_fdatetime(DateTime()) + NL */
            _gMsgProc = _gMsgProc+"Ora Inizio Scrittura Modifiche/Cancellazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Inizio Scrittura Modifiche/Cancellazioni: '+ arfn_fdatetime(DateTime())) */
            arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Inizio Scrittura Modifiche/Cancellazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
          } // End If
          for (MemoryCursorRow_mcerratedef_mcrdef rowModDel : mcModDel._iterable_()) {
            /* conta := conta + 1 */
            conta = conta+1;
            /* rowLettura.Copy(rowModDel) // Legge le righe per l'elaborazione */
            rowLettura.Copy(rowModDel);
            /* Exec "Elaborazione Riga" Page 16:Page_16 */
            Page_16();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* If _esito=-1 */
            if (CPLib.eqr(_esito,-1)) {
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          }
          /* mcModDel.Zap() // Soggetti */
          mcModDel.Zap();
          /* If At(pModo,'|R|M|Y') <> 0 */
          if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
            /* gMsgProc := gMsgProc + 'Ora Fine Scrittura Modifiche/Cancellazioni: '+ arfn_fdatetime(DateTime()) + NL */
            gMsgProc = gMsgProc+"Ora Fine Scrittura Modifiche/Cancellazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* _gMsgProc := _gMsgProc + 'Ora Fine Scrittura Modifiche/Cancellazioni: '+ arfn_fdatetime(DateTime()) + NL */
            _gMsgProc = _gMsgProc+"Ora Fine Scrittura Modifiche/Cancellazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Fine Scrittura Modifiche/Cancellazioni: '+ arfn_fdatetime(DateTime())) */
            arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Fine Scrittura Modifiche/Cancellazioni: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
          } // End If
        } // End If
        /* If At(pModo,'|R|M|Y') <> 0 */
        if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazioni Finali: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Inizio Elaborazioni Finali: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* _gMsgProc := _gMsgProc + 'Ora Inizio Elaborazioni Finali: '+ arfn_fdatetime(DateTime()) + NL */
          _gMsgProc = _gMsgProc+"Ora Inizio Elaborazioni Finali: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Inizio Elaborazioni Finali: '+ arfn_fdatetime(DateTime())) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Inizio Elaborazioni Finali: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
        } // End If
        for (MemoryCursorRow_decodecitta rowDecodeCitta : mcNewCitta._iterable_()) {
          /* _id := 0 */
          _id = CPLib.Round(0,0);
          // * --- Read from DecodeCitta
          m_cServer = m_Ctx.GetServer("DecodeCitta");
          m_cPhName = m_Ctx.GetPhName("DecodeCitta");
          m_cSql = "";
          m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowDecodeCitta.CITTA,"C",80,0,m_cServer),m_cServer,rowDecodeCitta.CITTA);
          if (m_Ctx.IsSharedTemp("DecodeCitta")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ID",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _id = CPLib.Round(Read_Cursor.GetDouble("ID"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on DecodeCitta into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _id = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _id=0 */
          if (CPLib.eqr(_id,0)) {
            // * --- Insert into DecodeCitta from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("DecodeCitta");
            m_cPhName = m_Ctx.GetPhName("DecodeCitta");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeCitta",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000216")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000216(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDecodeCitta.CITTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"DecodeCitta",true);
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
        }
        for (MemoryCursorRow_decodestati rowDecodeStati : mcNewStati._iterable_()) {
          /* _id := 0 */
          _id = CPLib.Round(0,0);
          // * --- Read from DecodeStati
          m_cServer = m_Ctx.GetServer("DecodeStati");
          m_cPhName = m_Ctx.GetPhName("DecodeStati");
          m_cSql = "";
          m_cSql = m_cSql+"account="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowDecodeStati.account,"C",100,0,m_cServer),m_cServer,rowDecodeStati.account);
          if (m_Ctx.IsSharedTemp("DecodeStati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ID",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _id = CPLib.Round(Read_Cursor.GetDouble("ID"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on DecodeStati into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _id = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _id=0 */
          if (CPLib.eqr(_id,0)) {
            // * --- Insert into DecodeStati from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("DecodeStati");
            m_cPhName = m_Ctx.GetPhName("DecodeStati");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeStati",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000021B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000021B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDecodeStati.account,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"DecodeStati",true);
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
        }
        for (MemoryCursorRow_decodenascita rowDecodeNascita : mcNewNascita._iterable_()) {
          /* _id := 0 */
          _id = CPLib.Round(0,0);
          // * --- Read from DecodeNascita
          m_cServer = m_Ctx.GetServer("DecodeNascita");
          m_cPhName = m_Ctx.GetPhName("DecodeNascita");
          m_cSql = "";
          m_cSql = m_cSql+"account="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowDecodeNascita.account,"C",100,0,m_cServer),m_cServer,rowDecodeNascita.account);
          if (m_Ctx.IsSharedTemp("DecodeNascita")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("id",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _id = CPLib.Round(Read_Cursor.GetDouble("id"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on DecodeNascita into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _id = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _id=0 */
          if (CPLib.eqr(_id,0)) {
            // * --- Insert into DecodeNascita from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("DecodeNascita");
            m_cPhName = m_Ctx.GetPhName("DecodeNascita");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeNascita",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000220")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000220(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDecodeNascita.account,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"DecodeNascita",true);
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
        }
        /* If pErrAUI='N' */
        if (CPLib.eqr(pErrAUI,"N")) {
          /* If pImpAna='N' */
          if (CPLib.eqr(pImpAna,"N")) {
            /* If w_tipodest='P' */
            if (CPLib.eqr(w_tipodest,"P")) {
              // * --- Write into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000225")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_omaxid,"N",10,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PPOPER1\\'"+CPLib.LRTrim(_azienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PPOPER1\\'"+CPLib.LRTrim(_azienda)+"'")+"";
              m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_azienda,"?",0,0,m_cServer),m_cServer,_azienda)+"";
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
              // * --- Write into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000226")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_omaxpg,"N",10,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PPOPER2\\'"+CPLib.LRTrim(_azienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PPOPER2\\'"+CPLib.LRTrim(_azienda)+"'")+"";
              m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_azienda,"?",0,0,m_cServer),m_cServer,_azienda)+"";
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
            } else { // Else
              // * --- Write into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000227")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_omaxid,"N",10,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ1\\'"+CPLib.LRTrim(_azienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ1\\'"+CPLib.LRTrim(_azienda)+"'")+"";
              m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_azienda,"?",0,0,m_cServer),m_cServer,_azienda)+"";
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
              // * --- Write into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000228")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_omaxpg,"N",10,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\POPERAZ2\\'"+CPLib.LRTrim(_azienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\POPERAZ2\\'"+CPLib.LRTrim(_azienda)+"'")+"";
              m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_azienda,"?",0,0,m_cServer),m_cServer,_azienda)+"";
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
              // * --- Write into cpwarn from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cpwarn");
              m_cPhName = m_Ctx.GetPhName("cpwarn");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000229")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_opxmax,"N",10,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PROGOPEX\\'"+CPLib.LRTrim(_azienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PROGOPEX\\'"+CPLib.LRTrim(_azienda)+"'")+"";
              m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_azienda,"?",0,0,m_cServer),m_cServer,_azienda)+"";
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
            // * --- Write into cpwarn from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cpwarn");
            m_cPhName = m_Ctx.GetPhName("cpwarn");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000022A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_omaxim,"N",10,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOPE\\'"+CPLib.LRTrim(_azienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOPE\\'"+CPLib.LRTrim(_azienda)+"'")+"";
            m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_azienda,"?",0,0,m_cServer),m_cServer,_azienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000022B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_pmaxim,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PRGIMPOCLI\\'"+CPLib.LRTrim(_azienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PRGIMPOCLI\\'"+CPLib.LRTrim(_azienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_azienda,"?",0,0,m_cServer),m_cServer,_azienda)+"";
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
          // * --- Write into cpwarn from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cpwarn");
          m_cPhName = m_Ctx.GetPhName("cpwarn");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000022C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"autonum = "+CPLib.ToSQL(_wmaxpg,"N",10,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cpwarn",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("prog\\PSTOPERS\\'"+CPLib.LRTrim(_azienda)+"'","?",0,0,m_cServer),m_cServer,"prog\\PSTOPERS\\'"+CPLib.LRTrim(_azienda)+"'")+"";
          m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_azienda,"?",0,0,m_cServer),m_cServer,_azienda)+"";
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
        /* If At(pModo,'|R|M|Y') <> 0 */
        if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
          /* gMsgProc := gMsgProc + 'Ora Fine Elaborazioni Finali: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Elaborazioni Finali: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* _gMsgProc := _gMsgProc + 'Ora Fine Elaborazioni Finali: '+ arfn_fdatetime(DateTime()) + NL */
          _gMsgProc = _gMsgProc+"Ora Fine Elaborazioni Finali: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Fine Elaborazioni Finali: '+ arfn_fdatetime(DateTime())) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Fine Elaborazioni Finali: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime()));
        } // End If
        /* If pErrAUI='N' */
        if (CPLib.eqr(pErrAUI,"N")) {
          // * --- Insert into mtimport from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("mtimport");
          m_cPhName = m_Ctx.GetPhName("mtimport");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mtimport",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000232")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000232(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nomefileimport),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mtimport",true);
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
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* If At(pModo,'|R|M|Y') <> 0 */
        if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
          /* If _nerrori > 0 */
          if (CPLib.gt(_nerrori,0)) {
            /* gMsgProc := gMsgProc + 'Sono stati rilevati '+LRTrim(Str(_nerrori,10,0)) + ' errori AUI dal file '+nomefileorg+NL */
            gMsgProc = gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_nerrori,10,0))+" errori AUI dal file "+nomefileorg+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* If _nerraua > 0 */
          if (CPLib.gt(_nerraua,0)) {
            /* gMsgProc := gMsgProc + 'Sono stati rilevati '+LRTrim(Str(_nerraua,10,0)) + ' errori AUA dal file '+nomefileorg+NL */
            gMsgProc = gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_nerraua,10,0))+" errori AUA dal file "+nomefileorg+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* ElseIf pModo='B' */
        } else if (CPLib.eqr(pModo,"B")) {
          /* If _nerrori > 0 */
          if (CPLib.gt(_nerrori,0)) {
            /* _gMsgProc := _gMsgProc + 'Sono stati rilevati '+LRTrim(Str(_nerrori,10,0)) + ' errori AUI dal file '+nomefileorg+NL */
            _gMsgProc = _gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_nerrori,10,0))+" errori AUI dal file "+nomefileorg+"\n";
            /* Exec Routine arrt_writelog_imp('IMPORT','', 'Sono stati rilevati '+LRTrim(Str(_nerrori,10,0)) + ' errori AUI dal file '+nomefileorg) */
            arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_nerrori,10,0))+" errori AUI dal file "+nomefileorg);
          } // End If
          /* If _nerraua > 0 */
          if (CPLib.gt(_nerraua,0)) {
            /* _gMsgProc := _gMsgProc + 'Sono stati rilevati '+LRTrim(Str(_nerraua,10,0)) + ' errori AUA dal file '+nomefileorg+NL */
            _gMsgProc = _gMsgProc+"Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_nerraua,10,0))+" errori AUA dal file "+nomefileorg+"\n";
            /* Exec Routine arrt_writelog_imp('IMPORT','', 'Sono stati rilevati '+LRTrim(Str(_nerraua,10,0)) + ' errori AUA dal file '+nomefileorg) */
            arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Sono stati rilevati "+CPLib.LRTrim(CPLib.Str(_nerraua,10,0))+" errori AUA dal file "+nomefileorg);
          } // End If
        } // End If
        /* If TransactionLibrary.CurrentTransactionStatus()<>'OK' and w_delprec='S' */
        if (CPLib.ne(TransactionLibrary.Make(m_Ctx).CurrentTransactionStatus(),"OK") && CPLib.eqr(w_delprec,"S")) {
        } // End If
        /* If At(pModo,'|R|M|Y') <> 0 */
        if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
          /* gMsgProc := gMsgProc + "Transazioni trasferite nell'archivio "+iif(w_tipodest='P','Provvisorio: ','Definitivo: ')+LRTrim(Str(_totmovi,10,0)) + ' dal file '+nomefileimport+NL */
          gMsgProc = gMsgProc+"Transazioni trasferite nell'archivio "+(CPLib.eqr(w_tipodest,"P")?"Provvisorio: ":"Definitivo: ")+CPLib.LRTrim(CPLib.Str(_totmovi,10,0))+" dal file "+nomefileimport+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Informazioni Elaborate: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
          gMsgProc = gMsgProc+"Informazioni Elaborate: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Informazioni Non Elaborate: '+LRTrim(Str(_scarti,10,0)) + ' dal file '+nomefileimport+NL */
          gMsgProc = gMsgProc+"Informazioni Non Elaborate: "+CPLib.LRTrim(CPLib.Str(_scarti,10,0))+" dal file "+nomefileimport+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileorg + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileorg+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
          gMsgImp = "Fine importazione del file "+nomefileimport;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* ElseIf pModo='B' */
        } else if (CPLib.eqr(pModo,"B")) {
          /* _gMsgProc := _gMsgProc + "Transazioni trasferite nell'archivio "+iif(w_tipodest='P','Provvisorio: ','Definitivo: ')+LRTrim(Str(_totmovi,10,0)) + ' dal file '+nomefileimport+NL */
          _gMsgProc = _gMsgProc+"Transazioni trasferite nell'archivio "+(CPLib.eqr(w_tipodest,"P")?"Provvisorio: ":"Definitivo: ")+CPLib.LRTrim(CPLib.Str(_totmovi,10,0))+" dal file "+nomefileimport+"\n";
          /* _gMsgProc := _gMsgProc + 'Informazioni Elaborate: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
          _gMsgProc = _gMsgProc+"Informazioni Elaborate: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
          /* _gMsgProc := _gMsgProc + 'Informazioni Non Elaborate: '+LRTrim(Str(_scarti,10,0)) + ' dal file '+nomefileimport+NL */
          _gMsgProc = _gMsgProc+"Informazioni Non Elaborate: "+CPLib.LRTrim(CPLib.Str(_scarti,10,0))+" dal file "+nomefileimport+"\n";
          /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileorg + NL */
          _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileorg+"\n";
          /* Exec Routine arrt_writelog_imp('IMPORT','',"Transazioni trasferite nell'archivio "+iif(w_tipodest='P','Provvisorio: ','Definitivo: ')+LRTrim(Str(_totmovi,10,0)) + ' dal file '+nomefileimport) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Transazioni trasferite nell'archivio "+(CPLib.eqr(w_tipodest,"P")?"Provvisorio: ":"Definitivo: ")+CPLib.LRTrim(CPLib.Str(_totmovi,10,0))+" dal file "+nomefileimport);
          /* Exec Routine arrt_writelog_imp('IMPORT','','Informazioni Elaborate: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Informazioni Elaborate: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport);
          /* Exec Routine arrt_writelog_imp('IMPORT','','Informazioni Non Elaborate: '+LRTrim(Str(_scarti,10,0)) + ' dal file '+nomefileimport) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Informazioni Non Elaborate: "+CPLib.LRTrim(CPLib.Str(_scarti,10,0))+" dal file "+nomefileimport);
          /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileorg) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileorg);
        } // End If
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* If At(pModo,'|R|M|Y') <> 0 */
        if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
          /* gMsgProc := gMsgProc + 'File '+ LRTrim(nomefileorg)+ " scartato per presenza di errori. Verificare i contatori!"+NL */
          gMsgProc = gMsgProc+"File "+CPLib.LRTrim(nomefileorg)+" scartato per presenza di errori. Verificare i contatori!"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* _gMsgProc := _gMsgProc + 'File '+ LRTrim(nomefileorg)+ " scartato per presenza di errori. Verificare i contatori!"+NL */
          _gMsgProc = _gMsgProc+"File "+CPLib.LRTrim(nomefileorg)+" scartato per presenza di errori. Verificare i contatori!"+"\n";
          /* Exec Routine arrt_writelog_imp('IMPORT','','File '+ LRTrim(nomefileorg)+ " scartato per presenza di errori. Verificare i contatori!") */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","File "+CPLib.LRTrim(nomefileorg)+" scartato per presenza di errori. Verificare i contatori!");
        } // End If
        /* gMsgImp := 'Abortita importazione del file '+nomefileimport+" per presenza di errori" // Messaggio Import */
        gMsgImp = "Abortita importazione del file "+nomefileimport+" per presenza di errori";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _nerrori := -1 */
        _nerrori = CPLib.Round(-1,0);
        /* _nerraua := -1 */
        _nerraua = CPLib.Round(-1,0);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000001E1status,0)) {
          m_Sql.SetTransactionStatus(nTry000001E1status,cTry000001E1msg);
        }
      }
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
  void Page_3() throws Exception {
    /* If At(pModo,'|R|M|Y') <> 0 */
    if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + czipfile + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Inizio estrazione del file '+ czipfile // Messaggio Import */
      gMsgImp = "Inizio estrazione del file "+czipfile;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } else { // Else
      /* _gMsgProc := _gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + czipfile + NL */
      _gMsgProc = _gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    } // End If
    /* cpercorsozip := LRTrim(_pathdoc)+"/appo/"+LRTrim(_azienda)+"/"+czipfile */
    cpercorsozip = CPLib.LRTrim(_pathdoc)+"/appo/"+CPLib.LRTrim(_azienda)+"/"+czipfile;
    /* cdirectoryfile := LRTrim(_pathdoc)+"/appo/"+LRTrim(_azienda)+"/" */
    cdirectoryfile = CPLib.LRTrim(_pathdoc)+"/appo/"+CPLib.LRTrim(_azienda)+"/";
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
    
            System.err.println("Extracting file: " + entry.getName());
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
    /* contanome := 0 */
    contanome = 0;
    /* _priorita := 0 */
    _priorita = CPLib.Round(0,0);
    /* While contanome<conteggio */
    while (CPLib.lt(contanome,conteggio)) {
      buffernomefile=lista[contanome];
      /* _priorita := iif(At('LOCATION',Upper(buffernomefile)) >0 or At('POS',Upper(buffernomefile)) >0,1,2) */
      _priorita = CPLib.Round((CPLib.gt(CPLib.At("LOCATION",CPLib.Upper(buffernomefile)),0) || CPLib.gt(CPLib.At("POS",CPLib.Upper(buffernomefile)),0)?1:2),0);
      /* Exec Routine arrt_writelog_imp('IMPORT','','Trovato File '+ LRTrim(buffernomefile)) */
      arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Trovato File "+CPLib.LRTrim(buffernomefile));
      /* mcFiles.AppendBlank() */
      mcFiles.AppendBlank();
      /* mcFiles.nomefile :=  LRTrim(buffernomefile) */
      mcFiles.row.nomefile = CPLib.LRTrim(buffernomefile);
      /* mcFiles.priorita := _priorita */
      mcFiles.row.priorita = _priorita;
      /* mcFiles.SaveRow() */
      mcFiles.SaveRow();
      /* contanome := contanome+1 */
      contanome = contanome+1;
    } // End While
    /* FileLibMit.DeleteFile('./appo/'+czipfile) */
    FileLibMit.DeleteFile("./appo/"+czipfile);
    /* If At(pModo,'|R|M|Y') <> 0 */
    if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
      /* gMsgImp := 'Fine estrazione del file '+ czipfile // Messaggio Import */
      gMsgImp = "Fine estrazione del file "+czipfile;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +czipfile + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } else { // Else
      /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +czipfile + NL */
      _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    } // End If
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_wurapporti=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_xapopebo=null;
    CPResultSet Cursor_rapopebo=null;
    try {
      /* Variabili loclai */
      /* _rap Numeric(1, 0) */
      double _rap;
      _rap = 0;
      /* nProgImp Numeric(15, 0) */
      double nProgImp;
      nProgImp = 0;
      /* nProgImp2 Numeric(15, 0) */
      double nProgImp2;
      nProgImp2 = 0;
      /* cInfProg1 Char(10) */
      String cInfProg1;
      cInfProg1 = CPLib.Space(10);
      /* cInfProg2 Char(11) */
      String cInfProg2;
      cInfProg2 = CPLib.Space(11);
      /* cProgRap Char(10) */
      String cProgRap;
      cProgRap = CPLib.Space(10);
      /* Verifica se il rapporto continuativo esiste già */
      /* _codrap := '' */
      _codrap = "";
      /* _rap := 0 */
      _rap = CPLib.Round(0,0);
      // * --- Select from wurapporti
      m_cServer = m_Ctx.GetServer("wurapporti");
      m_cPhName = m_Ctx.GetPhName("wurapporti");
      if (Cursor_wurapporti!=null)
        Cursor_wurapporti.Close();
      Cursor_wurapporti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RWCODFIS="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("wurapporti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wurapporti.Eof())) {
        /* _rap := 1 */
        _rap = CPLib.Round(1,0);
        /* _codrap := LRTrim(wurapporti->RWMACAGE)+wurapporti->RWCODRAP */
        _codrap = CPLib.LRTrim(Cursor_wurapporti.GetString("RWMACAGE"))+Cursor_wurapporti.GetString("RWCODRAP");
        Cursor_wurapporti.Next();
      }
      m_cConnectivityError = Cursor_wurapporti.ErrorMessage();
      Cursor_wurapporti.Close();
      // * --- End Select
      /* If _rap=0 */
      if (CPLib.eqr(_rap,0)) {
        // * --- Read from knarapbo
        m_cServer = m_Ctx.GetServer("knarapbo");
        m_cPhName = m_Ctx.GetPhName("knarapbo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codfis,"C",25,0,m_cServer),m_cServer,_codfis);
        if (m_Ctx.IsSharedTemp("knarapbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _codrap = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on knarapbo into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _codrap = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_codrap)) */
        if ( ! (CPLib.Empty(_codrap))) {
          /* _rap := 1 */
          _rap = CPLib.Round(1,0);
        } // End If
      } // End If
      /* If w_tipodest='P' */
      if (CPLib.eqr(w_tipodest,"P")) {
        /* If _rap = 0 */
        if (CPLib.eqr(_rap,0)) {
          /* cProgRap := Utilities.GetAutonumber("PRG"+LRTrim(w_codmage)+"\'"+LRTrim(_azienda)+"'",'',10) */
          cProgRap = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRG"+CPLib.LRTrim(w_codmage)+"\\'"+CPLib.LRTrim(_azienda)+"'","",10);
          /* _codrap := LRTrim(w_codmage)+cProgRap */
          _codrap = CPLib.LRTrim(w_codmage)+cProgRap;
          // * --- Insert into wurapporti from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wurapporti");
          m_cPhName = m_Ctx.GetPhName("wurapporti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wurapporti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000282")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000282(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProgRap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wurapporti",true);
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
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(_azienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(_azienda)+"'",0,15),0);
          // * --- Insert into xnarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xnarapbo");
          m_cPhName = m_Ctx.GetPhName("xnarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000284")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000284(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("99","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xnarapbo",true);
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
          // * --- Insert into knarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000285")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000285(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"knarapbo",true);
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
          /* cInfProg1 := Utilities.GetAutonumber("PRGPINFO1\'"+LRTrim(_azienda)+"'",'',10) */
          cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO1\\'"+CPLib.LRTrim(_azienda)+"'","",10);
          /* cInfProg2 := Utilities.GetAutonumber("PRGPINFO2\'"+LRTrim(_azienda)+"'",'',11) */
          cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGPINFO2\\'"+CPLib.LRTrim(_azienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(_azienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(_azienda)+"'",0,15),0);
          // * --- Insert into xapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xapopebo");
          m_cPhName = m_Ctx.GetPhName("xapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000289")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000289(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cInfProg1+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xapopebo",true);
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
          /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(_azienda)+"'",0,15) */
          nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(_azienda)+"'",0,15),0);
          // * --- Insert into xntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000028B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000028B(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cInfProg2+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xntestbo",true);
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
      } else { // Else
        /* If _rap = 0 */
        if (CPLib.eqr(_rap,0)) {
          /* cProgRap := Utilities.GetAutonumber("PRG"+LRTrim(w_codmage)+"\'"+LRTrim(_azienda)+"'",'',10) */
          cProgRap = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRG"+CPLib.LRTrim(w_codmage)+"\\'"+CPLib.LRTrim(_azienda)+"'","",10);
          /* _codrap := LRTrim(w_codmage)+cProgRap */
          _codrap = CPLib.LRTrim(w_codmage)+cProgRap;
          // * --- Insert into wurapporti from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wurapporti");
          m_cPhName = m_Ctx.GetPhName("wurapporti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wurapporti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000028F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000028F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProgRap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wurapporti",true);
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
          /* nProgImp := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(_azienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(_azienda)+"'",0,15),0);
          // * --- Insert into anarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000291")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000291(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("99","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_codmage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anarapbo",true);
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
          // * --- Insert into knarapbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("knarapbo");
          m_cPhName = m_Ctx.GetPhName("knarapbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"knarapbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000292")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000292(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"knarapbo",true);
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
          /* cInfProg1 := Utilities.GetAutonumber("PRGINFO1\'"+LRTrim(_azienda)+"'",'',10) */
          cInfProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO1\\'"+CPLib.LRTrim(_azienda)+"'","",10);
          /* cInfProg2 := Utilities.GetAutonumber("PRGINFO2\'"+LRTrim(_azienda)+"'",'',11) */
          cInfProg2 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGINFO2\\'"+CPLib.LRTrim(_azienda)+"'","",11);
          /* nProgImp := Utilities.GetAutonumber("PRGIMPINF\'"+LRTrim(_azienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPINF\\'"+CPLib.LRTrim(_azienda)+"'",0,15),0);
          // * --- Insert into rapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000296")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000296(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercit,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cInfProg1+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intertip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull("23","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"rapopebo",true);
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
          /* nProgImp2 := Utilities.GetAutonumber("PRGIMPSOG\'"+LRTrim(_azienda)+"'",0,15) */
          nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOG\\'"+CPLib.LRTrim(_azienda)+"'",0,15),0);
          // * --- Insert into intestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000298")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000298(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQLNull(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cInfProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codrap,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datope)+cInfProg2+"0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestbo",true);
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
      // * --- Select from xapopebo
      m_cServer = m_Ctx.GetServer("xapopebo");
      m_cPhName = m_Ctx.GetPhName("xapopebo");
      if (Cursor_xapopebo!=null)
        Cursor_xapopebo.Close();
      Cursor_xapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,_codrap)+" "+")"+(m_Ctx.IsSharedTemp("xapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_xapopebo.Eof())) {
        /* If xapopebo->DATAOPE > _datope */
        if (CPLib.gt(Cursor_xapopebo.GetDate("DATAOPE"),_datope)) {
          // * --- Write into xapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xapopebo");
          m_cPhName = m_Ctx.GetPhName("xapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000029B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapopebo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
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
          // * --- Write into xntestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xntestbo");
          m_cPhName = m_Ctx.GetPhName("xntestbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000029C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
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
        } // End If
        Cursor_xapopebo.Next();
      }
      m_cConnectivityError = Cursor_xapopebo.ErrorMessage();
      Cursor_xapopebo.Close();
      // * --- End Select
      // * --- Select from rapopebo
      m_cServer = m_Ctx.GetServer("rapopebo");
      m_cPhName = m_Ctx.GetPhName("rapopebo");
      if (Cursor_rapopebo!=null)
        Cursor_rapopebo.Close();
      Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer, m_oParameters),m_cServer,_codrap)+" "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapopebo.Eof())) {
        /* If rapopebo->DATAOPE > _datope */
        if (CPLib.gt(Cursor_rapopebo.GetDate("DATAOPE"),_datope)) {
          // * --- Write into rapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000029F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
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
          // * --- Write into intestbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("intestbo");
          m_cPhName = m_Ctx.GetPhName("intestbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000002A0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"DATAINI = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_codrap,"?",0,0,m_cServer),m_cServer,_codrap)+"";
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
        } // End If
        Cursor_rapopebo.Next();
      }
      m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
      Cursor_rapopebo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_wurapporti!=null)
          Cursor_wurapporti.Close();
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
        if (Cursor_xapopebo!=null)
          Cursor_xapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_xperazbo=null;
    CPResultSet Cursor_operazbo=null;
    try {
      /* If Left(LRTrim(rowLettura.colonna28),1)='I' */
      if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(rowLettura.colonna28),1),"I")) {
        /* _esito := 0 */
        _esito = CPLib.Round(0,0);
        /* If Empty(LRTrim(Left(rowLettura.colonna20,10))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Left(rowLettura.colonna20,10)))) {
          /* _err01 := "Account Agenzia non compilato" */
          _err01 = "Account Agenzia non compilato";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Empty(LRTrim(_prog)) */
          if (CPLib.Empty(CPLib.LRTrim(_prog))) {
            /* _err02 := "Agenzia non ancora censita"  */
            _err02 = "Agenzia non ancora censita";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* ElseIf LRTrim(_mage) <> LRTrim(w_codmage) */
          } else if (CPLib.ne(CPLib.LRTrim(_mage),CPLib.LRTrim(w_codmage))) {
            /* _err03 := "Agenzia collegata ad un altro MacroAgente" */
            _err03 = "Agenzia collegata ad un altro MacroAgente";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* ElseIf Empty(w_codmage) */
          } else if (CPLib.Empty(w_codmage)) {
            /* _err04 := "Agenzia non collegata a nessun MacroAgente"  */
            _err04 = "Agenzia non collegata a nessun MacroAgente";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If _esito=0 */
          if (CPLib.eqr(_esito,0)) {
            /* If Empty(_cabdip) */
            if (CPLib.Empty(_cabdip)) {
              /* _err05 := "Agenzia priva di codice CAB" */
              _err05 = "Agenzia priva di codice CAB";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } // End If
            /* If Empty(_provdip) */
            if (CPLib.Empty(_provdip)) {
              /* _err06 := "Agenzia priva di provincia" */
              _err06 = "Agenzia priva di provincia";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } // End If
            /* If Empty(_citdip) */
            if (CPLib.Empty(_citdip)) {
              /* _err07 := "Agenzia priva di città" */
              _err07 = "Agenzia priva di città";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } // End If
          } // End If
        } // End If
        /* If Empty(LRTrim(_cognome)) */
        if (CPLib.Empty(CPLib.LRTrim(_cognome))) {
          /* _err08 := "Cognome Cliente assente" */
          _err08 = "Cognome Cliente assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(LRTrim(_nome)) */
        if (CPLib.Empty(CPLib.LRTrim(_nome))) {
          /* _err09 := "Nome Cliente assente" */
          _err09 = "Nome Cliente assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If (Empty(LRTrim(_via)) or Empty(LRTrim(_cap))) and _codstares='086' */
        if ((CPLib.Empty(CPLib.LRTrim(_via)) || CPLib.Empty(CPLib.LRTrim(_cap))) && CPLib.eqr(_codstares,"086")) {
          /* _err10 := "Dati Residenza non completi" */
          _err10 = "Dati Residenza non completi";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Year(_datope) < 1900 */
        if (CPLib.lt(CPLib.Year(_datope),1900)) {
          /* _err11 := "Data operazione non valida" */
          _err11 = "Data operazione non valida";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_nasdata) */
        if (CPLib.Empty(_nasdata)) {
          /* _err12 := "Data di nascita non presente" */
          _err12 = "Data di nascita non presente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_nasdata) < 1900 */
          if (CPLib.lt(CPLib.Year(_nasdata),1900)) {
            /* _err13 := "Data di nascita errata" */
            _err13 = "Data di nascita errata";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(_doctype) */
        if (CPLib.Empty(_doctype)) {
          /* _err14 := "Tipo del documento non valido" */
          _err14 = "Tipo del documento non valido";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_docril) */
        if (CPLib.Empty(_docril)) {
          /* _err15 := "Data di rilascio del documento assente" */
          _err15 = "Data di rilascio del documento assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_docril) < 1900 */
          if (CPLib.lt(CPLib.Year(_docril),1900)) {
            /* _err16 := "Data di rilascio del documento errata" */
            _err16 = "Data di rilascio del documento errata";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If _docril > _datope */
          if (CPLib.gt(_docril,_datope)) {
            /* _err17 := "Data di rilascio del documento superiore alla data operazione" */
            _err17 = "Data di rilascio del documento superiore alla data operazione";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If _docril = _nasdata */
          if (CPLib.eqr(_docril,_nasdata)) {
            /* _err18 := "Data di rilascio del documento coincide con la data di nascita" */
            _err18 = "Data di rilascio del documento coincide con la data di nascita";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(_docsca) */
        if (CPLib.Empty(_docsca)) {
          /* _err19 := "Data di scadenza del documento assente" */
          _err19 = "Data di scadenza del documento assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Year(_docsca) < 1900 */
          if (CPLib.lt(CPLib.Year(_docsca),1900)) {
            /* _err20 := "Data di scadenza del documento errata" */
            _err20 = "Data di scadenza del documento errata";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If At(w_codmage,"|IT112|IT118") <> 0 */
          if (CPLib.ne(CPLib.At(w_codmage,"|IT112|IT118"),0)) {
            /* If _datope > _docsca */
            if (CPLib.gt(_datope,_docsca)) {
              /* _err21 := "Data di scadenza del documento inferiore alla data dell'operazione" */
              _err21 = "Data di scadenza del documento inferiore alla data dell'operazione";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } // End If
          } // End If
          /* If _docril > _docsca */
          if (CPLib.gt(_docril,_docsca)) {
            /* _err22 := "Data di scadenza del documento inferiore alla data di rilascio" */
            _err22 = "Data di scadenza del documento inferiore alla data di rilascio";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(LRTrim(Left(rowLettura.colonna13,2))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Left(rowLettura.colonna13,2)))) {
          /* _err23 := "Tipo Documento Assente" */
          _err23 = "Tipo Documento Assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_numdoc) and not(Empty(LRTrim(Left(rowLettura.colonna13,2)))) */
        if (CPLib.Empty(_numdoc) &&  ! (CPLib.Empty(CPLib.LRTrim(CPLib.Left(rowLettura.colonna13,2))))) {
          /* _err24 := "ID (Numero) del documento assente" */
          _err24 = "ID (Numero) del documento assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_autril) */
        if (CPLib.Empty(_autril)) {
          /* _err25 := "Autorità di rilascio del documento assente" */
          _err25 = "Autorità di rilascio del documento assente";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_sesso) */
        if (CPLib.Empty(_sesso)) {
          /* _err26 := "Manca il genere della persona" */
          _err26 = "Manca il genere della persona";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(_nasstato) and Empty(_nascitta) */
        if (CPLib.Empty(_nasstato) && CPLib.Empty(_nascitta)) {
          /* _err27 := "Manca il luogo di nascita" */
          _err27 = "Manca il luogo di nascita";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          /* If not(Empty(_luonas)) */
          if ( ! (CPLib.Empty(_luonas))) {
            /* _id := 0 */
            _id = CPLib.Round(0,0);
            for (MemoryCursorRow_decodenascita rowDecodeNascita : mcDecodeNascita._iterable_()) {
              /* If LRTrim(rowDecodeNascita.DESCRI)=LRTrim(_luonas) */
              if (CPLib.eqr(CPLib.LRTrim(rowDecodeNascita.DESCRI),CPLib.LRTrim(_luonas))) {
                /* _id := mcDecodeNascita.id */
                _id = CPLib.Round(mcDecodeNascita.row.id,0);
                // Exit Loop
                if (true) {
                  break;
                }
              } // End If
            }
            /* If _id=0 */
            if (CPLib.eqr(_id,0)) {
              /* If not(mcNewNascita.GoToKey(LRTrim(_luonas))) */
              if ( ! (mcNewNascita.GoToKey(CPLib.LRTrim(_luonas)))) {
                /* mcNewNascita.AppendWithKey(LRTrim(_luonas)) */
                mcNewNascita.AppendWithKey(CPLib.LRTrim(_luonas));
                /* mcNewNascita.account := LRTrim(_luonas) */
                mcNewNascita.row.account = CPLib.LRTrim(_luonas);
                /* mcNewNascita.SaveRow() */
                mcNewNascita.SaveRow();
              } // End If
            } // End If
          } // End If
        } // End If
        /* If Empty(_codstares) */
        if (CPLib.Empty(_codstares)) {
          /* If At(w_codmage,"|IT112|IT118") <> 0 */
          if (CPLib.ne(CPLib.At(w_codmage,"|IT112|IT118"),0)) {
            /* _err28 := "Manca lo stato di residenza" */
            _err28 = "Manca lo stato di residenza";
            /* _id := 0 */
            _id = CPLib.Round(0,0);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If not(Empty(_paese)) */
          if ( ! (CPLib.Empty(_paese))) {
            /* If mcDecodeStati.GoToKey(LRTrim(_paese)) */
            if (mcDecodeStati.GoToKey(CPLib.LRTrim(_paese))) {
              /* _id := mcDecodeStati.id */
              _id = CPLib.Round(mcDecodeStati.row.id,0);
            } // End If
            /* If _id=0 */
            if (CPLib.eqr(_id,0)) {
              /* If not(mcNewStati.GoToKey(LRTrim(_paese))) */
              if ( ! (mcNewStati.GoToKey(CPLib.LRTrim(_paese)))) {
                /* mcNewStati.AppendWithKey(LRTrim(_paese)) */
                mcNewStati.AppendWithKey(CPLib.LRTrim(_paese));
                /* mcNewStati.account := LRTrim(_paese) */
                mcNewStati.row.account = CPLib.LRTrim(_paese);
                /* mcNewStati.SaveRow() */
                mcNewStati.SaveRow();
              } // End If
            } // End If
          } // End If
        } // End If
        /* If Empty(_codcit) and _codstares='086' */
        if (CPLib.Empty(_codcit) && CPLib.eqr(_codstares,"086")) {
          /* If False */
          if (false) {
            /* _err29 := "Manca la città di residenza" */
            _err29 = "Manca la città di residenza";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
          /* If not(Empty(_citta)) */
          if ( ! (CPLib.Empty(_citta))) {
            /* _id := 0 */
            _id = CPLib.Round(0,0);
            /* If mcDecodeCitta.GoToKey(LRTrim(_citta)) */
            if (mcDecodeCitta.GoToKey(CPLib.LRTrim(_citta))) {
              /* _id := mcDecodeCitta.ID */
              _id = CPLib.Round(mcDecodeCitta.row.ID,0);
            } // End If
            /* If _id=0 */
            if (CPLib.eqr(_id,0)) {
              /* If not(mcNewCitta.GoToKey(LRTrim(_citta))) */
              if ( ! (mcNewCitta.GoToKey(CPLib.LRTrim(_citta)))) {
                /* mcNewCitta.AppendWithKey(LRTrim(_citta)) */
                mcNewCitta.AppendWithKey(CPLib.LRTrim(_citta));
                /* mcNewCitta.CITTA := LRTrim(_citta) */
                mcNewCitta.row.CITTA = CPLib.LRTrim(_citta);
                /* mcNewCitta.SaveRow() */
                mcNewCitta.SaveRow();
              } // End If
            } // End If
          } // End If
        } // End If
        /* If w_xMAFLGCKR='S' and w_xMAFLGRAP<>'S' */
        if (CPLib.eqr(w_xMAFLGCKR,"S") && CPLib.ne(w_xMAFLGRAP,"S")) {
          /* If Len(LRTrim(_codfis))=16 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(_codfis)),16)) {
            /* _rapporto := '' */
            _rapporto = "";
            // * --- Read from anarapbo
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(_codfis),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(_codfis));
            if (m_Ctx.IsSharedTemp("anarapbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _rapporto = Read_Cursor.GetString("RAPPORTO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _rapporto = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_rapporto)) */
            if (CPLib.Empty(CPLib.LRTrim(_rapporto))) {
              /* _err30 := "Rapporto non esistente" */
              _err30 = "Rapporto non esistente";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } // End If
          } // End If
        } // End If
        /* If Empty(LRTrim(Left(rowLettura.colonna16,1))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Left(rowLettura.colonna16,1)))) {
          /* _err31 := "Manca il segno dell'operazione" */
          _err31 = "Manca il segno dell'operazione";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Left(LRTrim(rowLettura.colonna16),1) <> 'D' and Left(LRTrim(rowLettura.colonna16),1) <> 'A' */
          if (CPLib.ne(CPLib.Left(CPLib.LRTrim(rowLettura.colonna16),1),"D") && CPLib.ne(CPLib.Left(CPLib.LRTrim(rowLettura.colonna16),1),"A")) {
            /* _err32 := "Segno dell'operazione non valido" */
            _err32 = "Segno dell'operazione non valido";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } // End If
        /* If Empty(LRTrim(_cognomecp)) and Empty(LRTrim(_nomecp)) */
        if (CPLib.Empty(CPLib.LRTrim(_cognomecp)) && CPLib.Empty(CPLib.LRTrim(_nomecp))) {
          /* _err33 := "Manca il nominativo della controparte" */
          _err33 = "Manca il nominativo della controparte";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
        /* If Empty(LRTrim(_statodest)) */
        if (CPLib.Empty(CPLib.LRTrim(_statodest))) {
          /* _err34 := "Manca lo stato della controparte" */
          _err34 = "Manca lo stato della controparte";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } else { // Else
          /* If Empty(LRTrim(_uifdest)) */
          if (CPLib.Empty(CPLib.LRTrim(_uifdest))) {
            /* _err35 := "Stato della controparte non presente in tabelle UIF" */
            _err35 = "Stato della controparte non presente in tabelle UIF";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _id := 0 */
            _id = CPLib.Round(0,0);
            /* If not(mcNewStati.GoToKey(LRTrim(_statodest))) */
            if ( ! (mcNewStati.GoToKey(CPLib.LRTrim(_statodest)))) {
              /* mcNewStati.AppendWithKey(LRTrim(_statodest)) */
              mcNewStati.AppendWithKey(CPLib.LRTrim(_statodest));
              /* mcNewStati.account := LRTrim(_statodest) */
              mcNewStati.row.account = CPLib.LRTrim(_statodest);
              /* mcNewStati.SaveRow() */
              mcNewStati.SaveRow();
            } // End If
          } // End If
        } // End If
        /* _errore := 0 */
        _errore = CPLib.Round(0,0);
        /* _merr := '' */
        _merr = "";
        /* If _nocf=1 and Empty(_codfis) */
        if (CPLib.eqr(_nocf,1) && CPLib.Empty(_codfis)) {
          /* _oldcodfis := _codfis */
          _oldcodfis = _codfis;
          /* If (Empty(_nasstato) and Empty(_nascitta)) or Empty(_nasdata) or Empty(_cognome) or Empty(_nome) or Empty(_sesso) */
          if ((CPLib.Empty(_nasstato) && CPLib.Empty(_nascitta)) || CPLib.Empty(_nasdata) || CPLib.Empty(_cognome) || CPLib.Empty(_nome) || CPLib.Empty(_sesso)) {
            /* _err36 := "Mancanza dati per calcolo NDG" */
            _err36 = "Mancanza dati per calcolo NDG";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } else { // Else
            /* w_CODFISC := '' // Codice Fiscale */
            w_CODFISC = "";
            /* w_DATANASC := _nasdata // Data Nascita */
            w_DATANASC = _nasdata;
            /* w_NASCOMUN := _nascitta // Luogo di Nascita */
            w_NASCOMUN = _nascitta;
            /* w_NASSTATO := _nasstato // Stato di nascita */
            w_NASSTATO = _nasstato;
            /* w_COGNOME := _cognome // Ragione Sociale */
            w_COGNOME = _cognome;
            /* w_RAGSOC := LRTrim(_cognome)+" "+LRTrim(_nome) // Ragione Sociale */
            w_RAGSOC = CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome);
            /* w_NOME := _nome // Ragione Sociale */
            w_NOME = _nome;
            /* w_SESSO := iif(_sesso='M','1',iif(_sesso='F','2','')) // Sesso */
            w_SESSO = (CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":""));
            /* Exec Routine arrt_calccodfis_wu */
            arrt_calccodfis_wuR.Make(m_Ctx,this).Run();
            /* xConnes := w_CODFISC */
            xConnes = w_CODFISC;
            /* If Len(LRTrim(xConnes)) < 16 */
            if (CPLib.lt(CPLib.Len(CPLib.LRTrim(xConnes)),16)) {
              /* _err38 := "NDG Calcolato - Lunghezza non corretta" */
              _err38 = "NDG Calcolato - Lunghezza non corretta";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } // End If
          } // End If
          /* ElseIf _nocf=0 */
        } else if (CPLib.eqr(_nocf,0)) {
          /* If Empty(LRTrim(_codfis)) */
          if (CPLib.Empty(CPLib.LRTrim(_codfis))) {
            /* _err37 := "Codice Fiscale Originale assente" */
            _err37 = "Codice Fiscale Originale assente";
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } else { // Else
            /* If Len(LRTrim(_codfis)) < 16 */
            if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_codfis)),16)) {
              /* _err38 := "Codice Fiscale Originale - Lunghezza non corretta" */
              _err38 = "Codice Fiscale Originale - Lunghezza non corretta";
              /* _esito := 1 */
              _esito = CPLib.Round(1,0);
            } // End If
          } // End If
        } // End If
        /* If Empty(LRTrim(Left(rowLettura.colonna24,10))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Left(rowLettura.colonna24,10)))) {
          /* _err39 := "MTCN non compilato" */
          _err39 = "MTCN non compilato";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
      /* If Left(LRTrim(rowLettura.colonna28),1)='D' */
      if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(rowLettura.colonna28),1),"D")) {
        /* _idbase := '' */
        _idbase = "";
        /* _datmod := arfn_dateminus(_datope,180) */
        _datmod = arfn_dateminusR.Make(m_Ctx,this).Run(_datope,180);
        // * --- Select from xperazbo
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
        Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_uniquecode),10),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(_uniquecode),10))+"  and  SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer, m_oParameters),m_cServer,_segno)+"  and  CDATOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.DateToChar(_datmod),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.DateToChar(_datmod))+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xperazbo.Eof())) {
          /* _idbase := xperazbo->IDBASE */
          _idbase = Cursor_xperazbo.GetString("IDBASE");
          Cursor_xperazbo.Next();
        }
        m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
        Cursor_xperazbo.Close();
        // * --- End Select
        /* If Empty(_idbase) */
        if (CPLib.Empty(_idbase)) {
          // * --- Select from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          if (Cursor_operazbo!=null)
            Cursor_operazbo.Close();
          Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_uniquecode),10),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(_uniquecode),10))+"  and  (STATOREG='0'  or  STATOREG='1')  and  SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer, m_oParameters),m_cServer,_segno)+"  and  CDATOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.DateToChar(_datmod),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.DateToChar(_datmod))+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_operazbo.Eof())) {
            /* _idbase := operazbo->IDBASE */
            _idbase = Cursor_operazbo.GetString("IDBASE");
            Cursor_operazbo.Next();
          }
          m_cConnectivityError = Cursor_operazbo.ErrorMessage();
          Cursor_operazbo.Close();
          // * --- End Select
        } // End If
        /* If Empty(_idbase) */
        if (CPLib.Empty(_idbase)) {
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          /* _err41 := "Operazione da cancellare non presente in AUI" */
          _err41 = "Operazione da cancellare non presente in AUI";
        } // End If
      } // End If
      /* If Left(LRTrim(rowLettura.colonna28),1)='M' */
      if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(rowLettura.colonna28),1),"M")) {
        /* _idbase := '' */
        _idbase = "";
        /* _datmod := arfn_dateminus(_datope,180) */
        _datmod = arfn_dateminusR.Make(m_Ctx,this).Run(_datope,180);
        // * --- Select from xperazbo
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
        Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,DATAOPE,DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_uniquecode),10),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(_uniquecode),10))+"  and  SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer, m_oParameters),m_cServer,_segno)+"  and  CDATOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.DateToChar(_datmod),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.DateToChar(_datmod))+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xperazbo.Eof())) {
          /* _idbase := xperazbo->IDBASE */
          _idbase = Cursor_xperazbo.GetString("IDBASE");
          Cursor_xperazbo.Next();
        }
        m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
        Cursor_xperazbo.Close();
        // * --- End Select
        /* If Empty(_idbase) */
        if (CPLib.Empty(_idbase)) {
          // * --- Select from operazbo
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          if (Cursor_operazbo!=null)
            Cursor_operazbo.Close();
          Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,DATAOPE,DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_uniquecode),10),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(_uniquecode),10))+"  and  (STATOREG='0'  or  STATOREG='1')  and  SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer, m_oParameters),m_cServer,_segno)+"  and  CDATOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.DateToChar(_datmod),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.DateToChar(_datmod))+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_operazbo.Eof())) {
            /* _idbase := operazbo->IDBASE */
            _idbase = Cursor_operazbo.GetString("IDBASE");
            Cursor_operazbo.Next();
          }
          m_cConnectivityError = Cursor_operazbo.ErrorMessage();
          Cursor_operazbo.Close();
          // * --- End Select
        } // End If
        /* If Empty(_idbase) */
        if (CPLib.Empty(_idbase)) {
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
          /* _err40 := "Operazione da modificare non presente in AUI" */
          _err40 = "Operazione da modificare non presente in AUI";
        } // End If
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
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
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
    }
  }
  void Page_6() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* cNumMod := 0 */
      cNumMod = CPLib.Round(0,0);
      /* cNumInv := 0 */
      cNumInv = CPLib.Round(0,0);
      /* conta := 0 */
      conta = 0;
      /* _nerrori := 0 */
      _nerrori = CPLib.Round(0,0);
      /* If At(pModo,'|R|M|Y') <> 0 */
      if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* _gMsgProc := _gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
        _gMsgProc = _gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      } // End If
      /* Salta la prima riga in quanti dice solo cose di trasmissione */
      /* _idfile := LRTrim(nomefileorg) */
      _idfile = CPLib.LRTrim(nomefileorg);
      /* Legge il file */
      /* If At(".TXT",Upper(nomefileimport)) > 0 */
      if (CPLib.gt(CPLib.At(".TXT",CPLib.Upper(nomefileimport)),0)) {
        /* fhand := FileLibMit.OpenReadPath(_pathdoc+"/appo/"+LRTrim(_azienda)+"/"+LRTrim(nomefileimport)) */
        fhand = FileLibMit.OpenReadPath(_pathdoc+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 and Left(riga,1) <> '#' */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0) && CPLib.ne(CPLib.Left(riga,1),"#")) {
            /* w_codmage := '' */
            w_codmage = "";
            /* If mcMacAge.GoToKey(Left(riga,5)) */
            if (mcMacAge.GoToKey(CPLib.Left(riga,5))) {
              /* w_codmage := mcMacAge.MACODICE */
              w_codmage = mcMacAge.row.MACODICE;
            } // End If
            /* If not(Empty(w_codmage)) or Empty(Left(riga,5)) */
            if ( ! (CPLib.Empty(w_codmage)) || CPLib.Empty(CPLib.Left(riga,5))) {
              /* mcAgeDuo.AppendWithKey(Substr(riga,6,10)) */
              mcAgeDuo.AppendWithKey(CPLib.Substr(riga,6,10));
              /* mcAgeDuo.colonna01 := Left(riga,5) */
              mcAgeDuo.row.colonna01 = CPLib.Left(riga,5);
              /* mcAgeDuo.colonna02 := Substr(riga,6,10) */
              mcAgeDuo.row.colonna02 = CPLib.Substr(riga,6,10);
              /* mcAgeDuo.colonna03 := LRTrim(Substr(riga,16,30)) */
              mcAgeDuo.row.colonna03 = CPLib.LRTrim(CPLib.Substr(riga,16,30));
              /* mcAgeDuo.colonna04 := LRTrim(Substr(riga,116,40)) */
              mcAgeDuo.row.colonna04 = CPLib.LRTrim(CPLib.Substr(riga,116,40));
              /* mcAgeDuo.colonna05 := LRTrim(Substr(riga,216,30)) */
              mcAgeDuo.row.colonna05 = CPLib.LRTrim(CPLib.Substr(riga,216,30));
              /* mcAgeDuo.colonna06 := LRTrim(Substr(riga,266,1)) */
              mcAgeDuo.row.colonna06 = CPLib.LRTrim(CPLib.Substr(riga,266,1));
              /* mcAgeDuo.colonna16 := 'S' */
              mcAgeDuo.row.colonna16 = "S";
              /* mcAgeDuo.SaveRow() */
              mcAgeDuo.SaveRow();
              /* mcAgenzie.AppendWithKey(Substr(riga,6,10)) */
              mcAgenzie.AppendWithKey(CPLib.Substr(riga,6,10));
              /* mcAgenzie.colonna01 := Left(riga,5) // MacroAgente */
              mcAgenzie.row.colonna01 = CPLib.Left(riga,5);
              /* mcAgenzie.colonna02 := Substr(riga,6,10) // Codice AJW */
              mcAgenzie.row.colonna02 = CPLib.Substr(riga,6,10);
              /* mcAgenzie.colonna03 := LRTrim(Substr(riga,16,30)) // Ragione Sociale */
              mcAgenzie.row.colonna03 = CPLib.LRTrim(CPLib.Substr(riga,16,30));
              /* mcAgenzie.colonna04 := LRTrim(Substr(riga,116,40)) // Domicilio */
              mcAgenzie.row.colonna04 = CPLib.LRTrim(CPLib.Substr(riga,116,40));
              /* mcAgenzie.colonna05 := LRTrim(Substr(riga,216,30)) // Città */
              mcAgenzie.row.colonna05 = CPLib.LRTrim(CPLib.Substr(riga,216,30));
              /* mcAgenzie.colonna06 := LRTrim(Substr(riga,266,1)) // Città */
              mcAgenzie.row.colonna06 = CPLib.LRTrim(CPLib.Substr(riga,266,1));
              /* mcAgenzie.colonna16 := 'S' // Città */
              mcAgenzie.row.colonna16 = "S";
              /* mcAgenzie.SaveRow() */
              mcAgenzie.SaveRow();
            } // End If
          } // End If
        } // End While
        // Chiude il file e lo cancella
        FileLibMit.Close(fhand);
      } else { // Else
        //base
        InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(_pathdoc)+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        _conta = wb.getNumberOfSheets();
        Row row; 
        Cell cell;
        int cellType;
        /* While _i < _conta */
        while (CPLib.lt(_i,_conta)) {
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          for (int rowNumber = sheet.getFirstRowNum(); rowNumber <= sheet.getLastRowNum(); rowNumber++) {
            row = sheet.getRow(rowNumber);
            if (row == null) {
                   // This row is completely empty
              } else {
          /* riga_letta := riga_letta+1 // riga letta del file Excel */
          riga_letta = CPLib.Round(riga_letta+1,0);
          /* If riga_letta > 1 */
          if (CPLib.gt(riga_letta,1)) {
            //scorro le colonne
            cell_count=0;
            /* While cell_count < 16 */
            while (CPLib.lt(cell_count,16)) {
              //scorro le celle della riga
              cell = row.getCell(cell_count);
              if (cell != null) {
              //  _tipocol = cell.getCellType();
                cellType = cell.getCellType().ordinal();
                switch (cellType) {
                  case 1:
                    colonna[cell_count]=String.valueOf((int)cell.getNumericCellValue());
                    break;
                  case 2:
                    colonna[cell_count]=cell.getStringCellValue();       
                    break;
                  default:
                    colonna[cell_count]=cell.getStringCellValue();       
                 }
              } else {
                colonna[cell_count]="";
              }
              ++cell_count;
            } // End While
            /* w_codmage := '' */
            w_codmage = "";
            /* If mcMacAge.GoToKey(Left(colonna[0],5)) */
            if (mcMacAge.GoToKey(CPLib.Left(colonna[0],5))) {
              /* w_codmage := mcMacAge.MACODICE */
              w_codmage = mcMacAge.row.MACODICE;
            } // End If
            /* If not(Empty(w_codmage)) or Empty(LRTrim(Left(colonna[0],5))) */
            if ( ! (CPLib.Empty(w_codmage)) || CPLib.Empty(CPLib.LRTrim(CPLib.Left(colonna[0],5)))) {
              /* mcAgeDuo.AppendWithKey(LRTrim(Left(colonna[1],10))) */
              mcAgeDuo.AppendWithKey(CPLib.LRTrim(CPLib.Left(colonna[1],10)));
              /* mcAgeDuo.colonna01 := LRTrim(Left(colonna[0],5)) */
              mcAgeDuo.row.colonna01 = CPLib.LRTrim(CPLib.Left(colonna[0],5));
              /* mcAgeDuo.colonna02 := LRTrim(Left(colonna[1],10)) */
              mcAgeDuo.row.colonna02 = CPLib.LRTrim(CPLib.Left(colonna[1],10));
              /* mcAgeDuo.colonna03 := LRTrim(Left(colonna[2],30)) */
              mcAgeDuo.row.colonna03 = CPLib.LRTrim(CPLib.Left(colonna[2],30));
              /* mcAgeDuo.colonna04 := LRTrim(Left(colonna[3],40)) */
              mcAgeDuo.row.colonna04 = CPLib.LRTrim(CPLib.Left(colonna[3],40));
              /* mcAgeDuo.colonna05 := LRTrim(Left(colonna[4],30)) */
              mcAgeDuo.row.colonna05 = CPLib.LRTrim(CPLib.Left(colonna[4],30));
              /* mcAgeDuo.colonna06 := LRTrim(Left(colonna[5],1)) */
              mcAgeDuo.row.colonna06 = CPLib.LRTrim(CPLib.Left(colonna[5],1));
              /* mcAgeDuo.colonna07 := LRTrim(Left(colonna[6],80)) */
              mcAgeDuo.row.colonna07 = CPLib.LRTrim(CPLib.Left(colonna[6],80));
              /* mcAgeDuo.colonna08 := LRTrim(Left(colonna[7],80)) */
              mcAgeDuo.row.colonna08 = CPLib.LRTrim(CPLib.Left(colonna[7],80));
              /* mcAgeDuo.colonna09 := LRTrim(Left(colonna[8],80)) */
              mcAgeDuo.row.colonna09 = CPLib.LRTrim(CPLib.Left(colonna[8],80));
              /* mcAgeDuo.colonna10 := LRTrim(Left(colonna[9],80)) */
              mcAgeDuo.row.colonna10 = CPLib.LRTrim(CPLib.Left(colonna[9],80));
              /* mcAgeDuo.colonna11 := LRTrim(Left(colonna[10],80)) */
              mcAgeDuo.row.colonna11 = CPLib.LRTrim(CPLib.Left(colonna[10],80));
              /* mcAgeDuo.colonna12 := LRTrim(Left(colonna[11],80)) */
              mcAgeDuo.row.colonna12 = CPLib.LRTrim(CPLib.Left(colonna[11],80));
              /* mcAgeDuo.colonna13 := LRTrim(Left(colonna[12],80)) */
              mcAgeDuo.row.colonna13 = CPLib.LRTrim(CPLib.Left(colonna[12],80));
              /* mcAgeDuo.colonna14 := LRTrim(Left(colonna[13],80)) */
              mcAgeDuo.row.colonna14 = CPLib.LRTrim(CPLib.Left(colonna[13],80));
              /* mcAgeDuo.colonna15 := LRTrim(Left(colonna[14],80)) */
              mcAgeDuo.row.colonna15 = CPLib.LRTrim(CPLib.Left(colonna[14],80));
              /* mcAgeDuo.colonna16 := LRTrim(Left(colonna[15],1)) */
              mcAgeDuo.row.colonna16 = CPLib.LRTrim(CPLib.Left(colonna[15],1));
              /* mcAgeDuo.SaveRow() */
              mcAgeDuo.SaveRow();
              /* mcAgenzie.AppendWithKey(LRTrim(Left(colonna[1],10))) */
              mcAgenzie.AppendWithKey(CPLib.LRTrim(CPLib.Left(colonna[1],10)));
              /* mcAgenzie.colonna01 := LRTrim(Left(colonna[0],5)) */
              mcAgenzie.row.colonna01 = CPLib.LRTrim(CPLib.Left(colonna[0],5));
              /* mcAgenzie.colonna02 := LRTrim(Left(colonna[1],10)) */
              mcAgenzie.row.colonna02 = CPLib.LRTrim(CPLib.Left(colonna[1],10));
              /* mcAgenzie.colonna03 := LRTrim(Left(colonna[2],30)) */
              mcAgenzie.row.colonna03 = CPLib.LRTrim(CPLib.Left(colonna[2],30));
              /* mcAgenzie.colonna04 := LRTrim(Left(colonna[3],40)) */
              mcAgenzie.row.colonna04 = CPLib.LRTrim(CPLib.Left(colonna[3],40));
              /* mcAgenzie.colonna05 := LRTrim(Left(colonna[4],30)) */
              mcAgenzie.row.colonna05 = CPLib.LRTrim(CPLib.Left(colonna[4],30));
              /* mcAgenzie.colonna06 := LRTrim(Left(colonna[5],1)) */
              mcAgenzie.row.colonna06 = CPLib.LRTrim(CPLib.Left(colonna[5],1));
              /* mcAgenzie.colonna07 := LRTrim(Left(colonna[6],80)) */
              mcAgenzie.row.colonna07 = CPLib.LRTrim(CPLib.Left(colonna[6],80));
              /* mcAgenzie.colonna08 := LRTrim(Left(colonna[7],80)) */
              mcAgenzie.row.colonna08 = CPLib.LRTrim(CPLib.Left(colonna[7],80));
              /* mcAgenzie.colonna09 := LRTrim(Left(colonna[8],80)) */
              mcAgenzie.row.colonna09 = CPLib.LRTrim(CPLib.Left(colonna[8],80));
              /* mcAgenzie.colonna10 := LRTrim(Left(colonna[9],80)) */
              mcAgenzie.row.colonna10 = CPLib.LRTrim(CPLib.Left(colonna[9],80));
              /* mcAgenzie.colonna11 := LRTrim(Left(colonna[10],80)) */
              mcAgenzie.row.colonna11 = CPLib.LRTrim(CPLib.Left(colonna[10],80));
              /* mcAgenzie.colonna12 := LRTrim(Left(colonna[11],80)) */
              mcAgenzie.row.colonna12 = CPLib.LRTrim(CPLib.Left(colonna[11],80));
              /* mcAgenzie.colonna13 := LRTrim(Left(colonna[12],80)) */
              mcAgenzie.row.colonna13 = CPLib.LRTrim(CPLib.Left(colonna[12],80));
              /* mcAgenzie.colonna14 := LRTrim(Left(colonna[13],80)) */
              mcAgenzie.row.colonna14 = CPLib.LRTrim(CPLib.Left(colonna[13],80));
              /* mcAgenzie.colonna15 := LRTrim(Left(colonna[14],80)) */
              mcAgenzie.row.colonna15 = CPLib.LRTrim(CPLib.Left(colonna[14],80));
              /* mcAgenzie.colonna16 := LRTrim(Left(colonna[15],1)) */
              mcAgenzie.row.colonna16 = CPLib.LRTrim(CPLib.Left(colonna[15],1));
              /* mcAgenzie.SaveRow() */
              mcAgenzie.SaveRow();
            } // End If
            /* conta := conta + 1 */
            conta = conta+1;
          } // End If
          // Chiude i cicli
            }
          }
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          _i++;
        } // End While
        // Chiude il file
        ExcelFileToRead.close();
      } // End If
      // Cancella il file di import
      FileLibMit.DeleteFilePath(_pathdoc+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
      // Begin Transaction
      m_Sql.RequireTransaction();
      /* conta := 0 */
      conta = 0;
      double nTry000003D1status;
      nTry000003D1status = m_Sql.GetTransactionStatus();
      String cTry000003D1msg;
      cTry000003D1msg = m_Sql.TransactionErrorMessage();
      try {
        for (MemoryCursorRow_mcerratedef_mcrdef rowAgenzie : mcAgenzie._iterable_()) {
          /* _coddip := '' */
          _coddip = "";
          /* _prov := '' */
          _prov = "";
          /* _cap := '' */
          _cap = "";
          /* _cab := '' */
          _cab = "";
          /* _idbase := '' */
          _idbase = "";
          /* _citta := '' */
          _citta = "";
          /* _id := 0 */
          _id = CPLib.Round(0,0);
          /* w_codmage := '' */
          w_codmage = "";
          for (MemoryCursorRow_anadip rowAnadip : mcAnadip._iterable_()) {
            /* If LRTrim(rowAnadip.AGACCODE)=LRTrim(rowAgenzie.colonna02) */
            if (CPLib.eqr(CPLib.LRTrim(rowAnadip.AGACCODE),CPLib.LRTrim(rowAgenzie.colonna02))) {
              /* _coddip := rowAnadip.CODDIP */
              _coddip = rowAnadip.CODDIP;
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          }
          /* If Empty(_coddip) */
          if (CPLib.Empty(_coddip)) {
            /* If Left(rowAgenzie.colonna02,3)='AS6' */
            if (CPLib.eqr(CPLib.Left(rowAgenzie.colonna02,3),"AS6")) {
              /* Case Substr(rowAgenzie.colonna02,4,1)='0' */
              if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"0")) {
                /* _dipcod := "A"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "A"+CPLib.Substr(rowAgenzie.colonna02,5,5);
                /* Case Substr(rowAgenzie.colonna02,4,1)='1' */
              } else if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"1")) {
                /* _dipcod := "B"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "B"+CPLib.Substr(rowAgenzie.colonna02,5,5);
                /* Case Substr(rowAgenzie.colonna02,4,1)='2' */
              } else if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"2")) {
                /* _dipcod := "C"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "C"+CPLib.Substr(rowAgenzie.colonna02,5,5);
                /* Case Substr(rowAgenzie.colonna02,4,1)='3' */
              } else if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"3")) {
                /* _dipcod := "D"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "D"+CPLib.Substr(rowAgenzie.colonna02,5,5);
                /* Case Substr(rowAgenzie.colonna02,4,1)='4' */
              } else if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"4")) {
                /* _dipcod := "E"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "E"+CPLib.Substr(rowAgenzie.colonna02,5,5);
                /* Case Substr(rowAgenzie.colonna02,4,1)='5' */
              } else if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"5")) {
                /* _dipcod := "F"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "F"+CPLib.Substr(rowAgenzie.colonna02,5,5);
                /* Case Substr(rowAgenzie.colonna02,4,1)='6' */
              } else if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"6")) {
                /* _dipcod := "G"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "G"+CPLib.Substr(rowAgenzie.colonna02,5,5);
                /* Case Substr(rowAgenzie.colonna02,4,1)='7' */
              } else if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"7")) {
                /* _dipcod := "H"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "H"+CPLib.Substr(rowAgenzie.colonna02,5,5);
                /* Case Substr(rowAgenzie.colonna02,4,1)='8' */
              } else if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"8")) {
                /* _dipcod := "I"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "I"+CPLib.Substr(rowAgenzie.colonna02,5,5);
                /* Case Substr(rowAgenzie.colonna02,4,1)='9' */
              } else if (CPLib.eqr(CPLib.Substr(rowAgenzie.colonna02,4,1),"9")) {
                /* _dipcod := "J"+Substr(rowAgenzie.colonna02,5,5) */
                _dipcod = "J"+CPLib.Substr(rowAgenzie.colonna02,5,5);
              } // End Case
              /* ElseIf Left(rowAgenzie.colonna02,3)='AJW' */
            } else if (CPLib.eqr(CPLib.Left(rowAgenzie.colonna02,3),"AJW")) {
              /* _dipcod := Substr(rowAgenzie.colonna02,4,6) */
              _dipcod = CPLib.Substr(rowAgenzie.colonna02,4,6);
            } // End If
            /* If mcAnadip.GoToKey(LRTrim(_dipcod)) */
            if (mcAnadip.GoToKey(CPLib.LRTrim(_dipcod))) {
              /* _coddip := mcAnadip.CODDIP */
              _coddip = mcAnadip.row.CODDIP;
            } // End If
          } // End If
          /* If mcDecodeCitta.GoToKey(LRTrim(rowAgenzie.colonna05)) */
          if (mcDecodeCitta.GoToKey(CPLib.LRTrim(rowAgenzie.colonna05))) {
            /* _citta := mcDecodeCitta.CITTAMIT */
            _citta = mcDecodeCitta.row.CITTAMIT;
            /* _id := mcDecodeCitta.ID */
            _id = CPLib.Round(mcDecodeCitta.row.ID,0);
          } // End If
          /* _citta := iif(Empty(_citta),rowAgenzie.colonna05,_citta) */
          _citta = (CPLib.Empty(_citta)?rowAgenzie.colonna05:_citta);
          /* If mcTbcitta.GoToKey(LRTrim(_citta)) */
          if (mcTbcitta.GoToKey(CPLib.LRTrim(_citta))) {
            /* _idbase := mcTbcitta.IDBASE */
            _idbase = mcTbcitta.row.IDBASE;
            /* _prov := mcTbcitta.PROV */
            _prov = mcTbcitta.row.PROV;
            /* _cab := mcTbcitta.CAB */
            _cab = mcTbcitta.row.CAB;
            /* _cap := LRTrim(mcTbcitta.CAP) */
            _cap = CPLib.LRTrim(mcTbcitta.row.CAP);
          } // End If
          /* If Empty(_idbase) and _id=0 */
          if (CPLib.Empty(_idbase) && CPLib.eqr(_id,0)) {
            /* If not(mcNewCitta.GoToKey(LRTrim(rowAgenzie.colonna05))) */
            if ( ! (mcNewCitta.GoToKey(CPLib.LRTrim(rowAgenzie.colonna05)))) {
              /* mcNewCitta.AppendWithKey(LRTrim(rowAgenzie.colonna05)) */
              mcNewCitta.AppendWithKey(CPLib.LRTrim(rowAgenzie.colonna05));
              /* mcNewCitta.CITTA := LRTrim(rowAgenzie.colonna05) */
              mcNewCitta.row.CITTA = CPLib.LRTrim(rowAgenzie.colonna05);
              /* mcNewCitta.SaveRow() */
              mcNewCitta.SaveRow();
            } // End If
          } // End If
          /* _errage := 0 */
          _errage = CPLib.Round(0,0);
          /* _ageerr01 := '' */
          _ageerr01 = "";
          /* _ageerr02 := '' */
          _ageerr02 = "";
          /* _ageerr03 := '' */
          _ageerr03 = "";
          /* _ageerr04 := '' */
          _ageerr04 = "";
          /* _ageerr05 := '' */
          _ageerr05 = "";
          /* _ageerr06 := '' */
          _ageerr06 = "";
          /* _ageerr07 := '' */
          _ageerr07 = "";
          /* _ageerr08 := '' */
          _ageerr08 = "";
          /* _ageerr09 := '' */
          _ageerr09 = "";
          /* _colonna1 := rowAgenzie.colonna01 */
          _colonna1 = rowAgenzie.colonna01;
          /* _colonna2 := rowAgenzie.colonna02 */
          _colonna2 = rowAgenzie.colonna02;
          /* _colonna3 := rowAgenzie.colonna03 */
          _colonna3 = rowAgenzie.colonna03;
          /* _colonna4 := rowAgenzie.colonna04 */
          _colonna4 = rowAgenzie.colonna04;
          /* _colonna5 := rowAgenzie.colonna05 */
          _colonna5 = rowAgenzie.colonna05;
          /* _colonna6 := rowAgenzie.colonna06 */
          _colonna6 = rowAgenzie.colonna06;
          /* If rowAgenzie.colonna16='S' */
          if (CPLib.eqr(rowAgenzie.colonna16,"S")) {
            /* Exec "Controlli File Agenzie" Page 12:Page_12 */
            Page_12();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* If _errage > 0 */
            if (CPLib.gt(_errage,0)) {
              /* _nerrage := _nerrage + 1 */
              _nerrage = CPLib.Round(_nerrage+1,0);
              /* mcErrAge.AppendWithKey(rowAgenzie.colonna02) */
              mcErrAge.AppendWithKey(rowAgenzie.colonna02);
              /* mcErrAge.colonna01 := rowAgenzie.colonna01 */
              mcErrAge.row.colonna01 = rowAgenzie.colonna01;
              /* mcErrAge.colonna02 := rowAgenzie.colonna02 */
              mcErrAge.row.colonna02 = rowAgenzie.colonna02;
              /* mcErrAge.colonna03 := rowAgenzie.colonna03 */
              mcErrAge.row.colonna03 = rowAgenzie.colonna03;
              /* mcErrAge.colonna04 := rowAgenzie.colonna04 */
              mcErrAge.row.colonna04 = rowAgenzie.colonna04;
              /* mcErrAge.colonna05 := rowAgenzie.colonna05 */
              mcErrAge.row.colonna05 = rowAgenzie.colonna05;
              /* mcErrAge.colonna06 := rowAgenzie.colonna06 */
              mcErrAge.row.colonna06 = rowAgenzie.colonna06;
              /* mcErrAge.colonna07 := _ageerr01 */
              mcErrAge.row.colonna07 = _ageerr01;
              /* mcErrAge.colonna08 := _ageerr02 */
              mcErrAge.row.colonna08 = _ageerr02;
              /* mcErrAge.colonna09 := _ageerr03 */
              mcErrAge.row.colonna09 = _ageerr03;
              /* mcErrAge.colonna10 := _ageerr04 */
              mcErrAge.row.colonna10 = _ageerr04;
              /* mcErrAge.colonna11 := _ageerr05 */
              mcErrAge.row.colonna11 = _ageerr05;
              /* mcErrAge.colonna12 := _ageerr06 */
              mcErrAge.row.colonna12 = _ageerr06;
              /* mcErrAge.colonna13 := _ageerr07 */
              mcErrAge.row.colonna13 = _ageerr07;
              /* mcErrAge.colonna14 := _ageerr08 */
              mcErrAge.row.colonna14 = _ageerr08;
              /* mcErrAge.colonna15 := _ageerr09 */
              mcErrAge.row.colonna15 = _ageerr09;
              /* mcErrAge.SaveRow() */
              mcErrAge.SaveRow();
            } else { // Else
              /* If mcMacAge.GoToKey(rowAgenzie.colonna01) */
              if (mcMacAge.GoToKey(rowAgenzie.colonna01)) {
                /* w_codmage := mcMacAge.MACODICE */
                w_codmage = mcMacAge.row.MACODICE;
              } // End If
              /* If Empty(_coddip) */
              if (CPLib.Empty(_coddip)) {
                /* cNumNew := cNumNew + 1 */
                cNumNew = CPLib.Round(cNumNew+1,0);
                // * --- Insert into anadip from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000428")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000428(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(_dipcod,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowAgenzie.colonna03),30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_citta),30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_prov),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull(w_codmage,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna02),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cab),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_cap),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idbase,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowAgenzie.colonna04),40),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("92","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"anadip",true);
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
                /* cNumMod := cNumMod + 1 */
                cNumMod = CPLib.Round(cNumMod+1,0);
                // * --- Write into anadip from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anadip");
                m_cPhName = m_Ctx.GetPhName("anadip");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000042A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DESCRIZ = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowAgenzie.colonna03),30),"C",30,0,m_cServer)+", ";
                m_cSql = m_cSql+"IDCITTA = "+CPLib.ToSQL(_idbase,"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_citta),30),"C",60,0,m_cServer)+", ";
                m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.LRTrim(_prov),"C",2,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(CPLib.LRTrim(_cab),"C",6,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGENTE = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"MACROAGENTE = "+CPLib.ToSQLNull(w_codmage,"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowAgenzie.colonna04),40),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(CPLib.LRTrim(_cap),"C",5,0,m_cServer)+", ";
                m_cSql = m_cSql+"AGACCODE = "+CPLib.ToSQL(CPLib.LRTrim(rowAgenzie.colonna02),"C",10,0,m_cServer)+", ";
                m_cSql = m_cSql+"TIPOSV = "+CPLib.ToSQL("92","C",3,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anadip",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"CODDIP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_coddip,"?",0,0,m_cServer),m_cServer,_coddip)+"";
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
          } else { // Else
            /* _nerrage := _nerrage + 1 */
            _nerrage = CPLib.Round(_nerrage+1,0);
            /* mcErrAge.AppendWithKey(rowAgenzie.colonna02) */
            mcErrAge.AppendWithKey(rowAgenzie.colonna02);
            /* mcErrAge.colonna01 := rowAgenzie.colonna01 */
            mcErrAge.row.colonna01 = rowAgenzie.colonna01;
            /* mcErrAge.colonna02 := rowAgenzie.colonna02 */
            mcErrAge.row.colonna02 = rowAgenzie.colonna02;
            /* mcErrAge.colonna03 := rowAgenzie.colonna03 */
            mcErrAge.row.colonna03 = rowAgenzie.colonna03;
            /* mcErrAge.colonna04 := rowAgenzie.colonna04 */
            mcErrAge.row.colonna04 = rowAgenzie.colonna04;
            /* mcErrAge.colonna05 := rowAgenzie.colonna05 */
            mcErrAge.row.colonna05 = rowAgenzie.colonna05;
            /* mcErrAge.colonna06 := rowAgenzie.colonna06 */
            mcErrAge.row.colonna06 = rowAgenzie.colonna06;
            /* mcErrAge.colonna07 := rowAgenzie.colonna07 */
            mcErrAge.row.colonna07 = rowAgenzie.colonna07;
            /* mcErrAge.colonna08 := rowAgenzie.colonna08 */
            mcErrAge.row.colonna08 = rowAgenzie.colonna08;
            /* mcErrAge.colonna09 := rowAgenzie.colonna09 */
            mcErrAge.row.colonna09 = rowAgenzie.colonna09;
            /* mcErrAge.colonna10 := rowAgenzie.colonna10 */
            mcErrAge.row.colonna10 = rowAgenzie.colonna10;
            /* mcErrAge.colonna11 := rowAgenzie.colonna11 */
            mcErrAge.row.colonna11 = rowAgenzie.colonna11;
            /* mcErrAge.colonna12 := rowAgenzie.colonna12 */
            mcErrAge.row.colonna12 = rowAgenzie.colonna12;
            /* mcErrAge.colonna13 := rowAgenzie.colonna13 */
            mcErrAge.row.colonna13 = rowAgenzie.colonna13;
            /* mcErrAge.colonna14 := rowAgenzie.colonna14 */
            mcErrAge.row.colonna14 = rowAgenzie.colonna14;
            /* mcErrAge.colonna15 := rowAgenzie.colonna15 */
            mcErrAge.row.colonna15 = rowAgenzie.colonna15;
            /* mcErrAge.SaveRow() */
            mcErrAge.SaveRow();
          } // End If
          /* conta := conta + 1 */
          conta = conta+1;
          /* If At(pModo,'|R|M|Y') <> 0 */
          if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
            /* gMsgImp := 'Sono state elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+nomefileimport // Messaggio Import */
            gMsgImp = "Sono state elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+nomefileimport;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* If pModo='B' */
          if (CPLib.eqr(pModo,"B")) {
            /* Exec Routine arrt_writelog_imp('IMPORT','','Sono state elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+nomefileimport) */
            arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Sono state elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+nomefileimport);
          } // End If
        }
        for (MemoryCursorRow_decodecitta rowDecodeCitta : mcNewCitta._iterable_()) {
          /* _id := 0 */
          _id = CPLib.Round(0,0);
          // * --- Read from DecodeCitta
          m_cServer = m_Ctx.GetServer("DecodeCitta");
          m_cPhName = m_Ctx.GetPhName("DecodeCitta");
          m_cSql = "";
          m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowDecodeCitta.CITTA,"C",80,0,m_cServer),m_cServer,rowDecodeCitta.CITTA);
          if (m_Ctx.IsSharedTemp("DecodeCitta")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ID",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _id = CPLib.Round(Read_Cursor.GetDouble("ID"),0);
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on DecodeCitta into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _id = 0;
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If _id=0 */
          if (CPLib.eqr(_id,0)) {
            // * --- Insert into DecodeCitta from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("DecodeCitta");
            m_cPhName = m_Ctx.GetPhName("DecodeCitta");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"DecodeCitta",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000446")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000446(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowDecodeCitta.CITTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"DecodeCitta",true);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000003D1status,0)) {
          m_Sql.SetTransactionStatus(nTry000003D1status,cTry000003D1msg);
        }
      }
      /* If TransactionLibrary.CurrentTransactionStatus()<>'OK' and w_delprec='S' */
      if (CPLib.ne(TransactionLibrary.Make(m_Ctx).CurrentTransactionStatus(),"OK") && CPLib.eqr(w_delprec,"S")) {
      } // End If
      /* If At(pModo,'|R|M|Y') <> 0 */
      if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
        /* gMsgProc := gMsgProc + 'Informazioni Elaborate: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Informazioni Elaborate: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Nuove Agenzie '+LRTrim(Str(cNumNew,10,0)) + ' dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Nuove Agenzie "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" dal file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Agenzie Aggiornate '+LRTrim(Str(cNumMod,10,0)) + ' dal file '+nomefileimport+NL */
        gMsgProc = gMsgProc+"Agenzie Aggiornate "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" dal file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If _nerrage > 0 */
        if (CPLib.gt(_nerrage,0)) {
          /* gMsgProc := gMsgProc + 'Agenzie Scartate '+LRTrim(Str(_nerrage,10,0)) + ' dal file '+nomefileimport+NL */
          gMsgProc = gMsgProc+"Agenzie Scartate "+CPLib.LRTrim(CPLib.Str(_nerrage,10,0))+" dal file "+nomefileimport+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Fine importazione del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } else { // Else
        /* _gMsgProc := _gMsgProc + 'Informazioni Elaborate: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
        _gMsgProc = _gMsgProc+"Informazioni Elaborate: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
        /* _gMsgProc := _gMsgProc + 'Nuove Agenzie '+LRTrim(Str(cNumNew,10,0)) + ' dal file '+nomefileimport+NL */
        _gMsgProc = _gMsgProc+"Nuove Agenzie "+CPLib.LRTrim(CPLib.Str(cNumNew,10,0))+" dal file "+nomefileimport+"\n";
        /* _gMsgProc := _gMsgProc + 'Agenzie Aggiornate '+LRTrim(Str(cNumMod,10,0)) + ' dal file '+nomefileimport+NL */
        _gMsgProc = _gMsgProc+"Agenzie Aggiornate "+CPLib.LRTrim(CPLib.Str(cNumMod,10,0))+" dal file "+nomefileimport+"\n";
        /* If _nerrage > 0 */
        if (CPLib.gt(_nerrage,0)) {
          /* _gMsgProc := _gMsgProc + 'Agenzie Scartate '+LRTrim(Str(_nerrage,10,0)) + ' dal file '+nomefileimport+NL */
          _gMsgProc = _gMsgProc+"Agenzie Scartate "+CPLib.LRTrim(CPLib.Str(_nerrage,10,0))+" dal file "+nomefileimport+"\n";
        } // End If
        /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
        _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
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
  void Page_7() throws Exception {
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_operazbo_agg=null;
    CPResultSet Cursor_xperazbo=null;
    try {
      /* _datmod := arfn_dateminus(_datope,180) */
      _datmod = arfn_dateminusR.Make(m_Ctx,this).Run(_datope,180);
      /* _idbase := '' */
      _idbase = "";
      /* mcOperazioni.Zap() // Per le modifiche delle operazioni */
      mcOperazioni.Zap();
      // * --- Fill memory cursor mcOperazioni on operazbo
      mcOperazioni.Zap();
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      if (Cursor_operazbo!=null)
        Cursor_operazbo.Close();
      Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_uniquecode),10),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(_uniquecode),10))+"  and  (STATOREG='0'  or  STATOREG='1')  and  SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer, m_oParameters),m_cServer,_segno)+"  and  CDATOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.DateToChar(_datmod),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.DateToChar(_datmod))+" "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_operazbo;
        Cursor_operazbo.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on operazbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_operazbo.Eof())) {
        mcOperazioni.AppendBlank();
        mcOperazioni.row.IDBASE = Cursor_operazbo.GetString("IDBASE");
        mcOperazioni.row.NUMPROG = Cursor_operazbo.GetString("NUMPROG");
        mcOperazioni.row.DATAOPE = Cursor_operazbo.GetDate("DATAOPE");
        mcOperazioni.row.TIPOINTER = Cursor_operazbo.GetString("TIPOINTER");
        mcOperazioni.row.CODINTER = Cursor_operazbo.GetString("CODINTER");
        mcOperazioni.row.TIPOINF = Cursor_operazbo.GetString("TIPOINF");
        mcOperazioni.row.IDEREG = Cursor_operazbo.GetString("IDEREG");
        mcOperazioni.row.CODDIPE = Cursor_operazbo.GetString("CODDIPE");
        mcOperazioni.row.DESCCIT = Cursor_operazbo.GetString("DESCCIT");
        mcOperazioni.row.PROVINCIA = Cursor_operazbo.GetString("PROVINCIA");
        mcOperazioni.row.CODCAB = Cursor_operazbo.GetString("CODCAB");
        mcOperazioni.row.FLAGFRAZ = Cursor_operazbo.GetString("FLAGFRAZ");
        mcOperazioni.row.FLAGCONT = Cursor_operazbo.GetString("FLAGCONT");
        mcOperazioni.row.CODANA = Cursor_operazbo.GetString("CODANA");
        mcOperazioni.row.CODVOC = Cursor_operazbo.GetString("CODVOC");
        mcOperazioni.row.TIPOINT2 = Cursor_operazbo.GetString("TIPOINT2");
        mcOperazioni.row.CODINT2 = Cursor_operazbo.GetString("CODINT2");
        mcOperazioni.row.PAESE = Cursor_operazbo.GetString("PAESE");
        mcOperazioni.row.DESC2 = Cursor_operazbo.GetString("DESC2");
        mcOperazioni.row.PROV2 = Cursor_operazbo.GetString("PROV2");
        mcOperazioni.row.CODCAB2 = Cursor_operazbo.GetString("CODCAB2");
        mcOperazioni.row.DESCINTER = Cursor_operazbo.GetString("DESCINTER");
        mcOperazioni.row.RAPPORTO = Cursor_operazbo.GetString("RAPPORTO");
        mcOperazioni.row.FLAGRAP = Cursor_operazbo.GetString("FLAGRAP");
        mcOperazioni.row.TIPOLEG = Cursor_operazbo.GetString("TIPOLEG");
        mcOperazioni.row.DATAREG = Cursor_operazbo.GetDate("DATAREG");
        mcOperazioni.row.OPRAP = Cursor_operazbo.GetString("OPRAP");
        mcOperazioni.row.TIPOOPRAP = Cursor_operazbo.GetString("TIPOOPRAP");
        mcOperazioni.row.FLAGLIRE = Cursor_operazbo.GetString("FLAGLIRE");
        mcOperazioni.row.VALUTA = Cursor_operazbo.GetString("VALUTA");
        mcOperazioni.row.SEGNO = Cursor_operazbo.GetString("SEGNO");
        mcOperazioni.row.TOTLIRE = Cursor_operazbo.GetDouble("TOTLIRE");
        mcOperazioni.row.TOTCONT = Cursor_operazbo.GetDouble("TOTCONT");
        mcOperazioni.row.STATOREG = Cursor_operazbo.GetString("STATOREG");
        mcOperazioni.row.OPERAZMOD = Cursor_operazbo.GetString("OPERAZMOD");
        mcOperazioni.row.DATARETT = Cursor_operazbo.GetDate("DATARETT");
        mcOperazioni.row.CONNESCLI = Cursor_operazbo.GetString("CONNESCLI");
        mcOperazioni.row.CONNESOPER = Cursor_operazbo.GetString("CONNESOPER");
        mcOperazioni.row.CONNESBEN = Cursor_operazbo.GetString("CONNESBEN");
        mcOperazioni.row.COLLEG = Cursor_operazbo.GetString("COLLEG");
        mcOperazioni.row.CAMBIO = Cursor_operazbo.GetDouble("CAMBIO");
        mcOperazioni.row.RAPPORTBEN = Cursor_operazbo.GetString("RAPPORTBEN");
        mcOperazioni.row.FLAGRAP2 = Cursor_operazbo.GetString("FLAGRAP2");
        mcOperazioni.row.OPERATORE = Cursor_operazbo.GetString("OPERATORE");
        mcOperazioni.row.AUTOM = Cursor_operazbo.GetString("AUTOM");
        mcOperazioni.row.idcauana = Cursor_operazbo.GetString("idcauana");
        mcOperazioni.row.OPERAG = Cursor_operazbo.GetString("OPERAG");
        mcOperazioni.row.DOCFILE = Cursor_operazbo.GetString("DOCFILE");
        mcOperazioni.row.RESPINS = Cursor_operazbo.GetString("RESPINS");
        mcOperazioni.row.INFORM = Cursor_operazbo.GetString("INFORM");
        mcOperazioni.row.CDATOPE = Cursor_operazbo.GetString("CDATOPE");
        mcOperazioni.row.NOPROT = Cursor_operazbo.GetDouble("NOPROT");
        mcOperazioni.row.UCODE = Cursor_operazbo.GetString("UCODE");
        mcOperazioni.row.CDATAOPE = Cursor_operazbo.GetString("CDATAOPE");
        mcOperazioni.row.ZCPARTE = Cursor_operazbo.GetString("ZCPARTE");
        mcOperazioni.row.RAGIO = Cursor_operazbo.GetString("RAGIO");
        mcOperazioni.row.MODSVOL = Cursor_operazbo.GetString("MODSVOL");
        mcOperazioni.row.AREAGEO = Cursor_operazbo.GetString("AREAGEO");
        mcOperazioni.row.RIFIMP = Cursor_operazbo.GetString("RIFIMP");
        mcOperazioni.row.SCOPO = Cursor_operazbo.GetString("SCOPO");
        mcOperazioni.row.NATURA = Cursor_operazbo.GetString("NATURA");
        mcOperazioni.row.RTIPO = Cursor_operazbo.GetDouble("RTIPO");
        mcOperazioni.row.RCOMP = Cursor_operazbo.GetDouble("RCOMP");
        mcOperazioni.row.RIMP = Cursor_operazbo.GetDouble("RIMP");
        mcOperazioni.row.RFREQ = Cursor_operazbo.GetDouble("RFREQ");
        mcOperazioni.row.RRAGIO = Cursor_operazbo.GetDouble("RRAGIO");
        mcOperazioni.row.RAREA = Cursor_operazbo.GetDouble("RAREA");
        mcOperazioni.row.TIPO = Cursor_operazbo.GetString("TIPO");
        mcOperazioni.row.PRGIMPOPE = Cursor_operazbo.GetDouble("PRGIMPOPE");
        mcOperazioni.row.UNIQUECODE = Cursor_operazbo.GetString("UNIQUECODE");
        mcOperazioni.row.AMMONT = Cursor_operazbo.GetString("AMMONT");
        mcOperazioni.row.DURAT = Cursor_operazbo.GetString("DURAT");
        mcOperazioni.row.CONNALTRO = Cursor_operazbo.GetString("CONNALTRO");
        mcOperazioni.row.CONNESDOC = Cursor_operazbo.GetString("CONNESDOC");
        mcOperazioni.row.C_RAG = Cursor_operazbo.GetString("C_RAG");
        mcOperazioni.row.C_STA = Cursor_operazbo.GetString("C_STA");
        mcOperazioni.row.C_CTA = Cursor_operazbo.GetString("C_CTA");
        mcOperazioni.row.C_CAB = Cursor_operazbo.GetString("C_CAB");
        mcOperazioni.row.C_PRV = Cursor_operazbo.GetString("C_PRV");
        mcOperazioni.row.C_IND = Cursor_operazbo.GetString("C_IND");
        mcOperazioni.row.C_CAP = Cursor_operazbo.GetString("C_CAP");
        mcOperazioni.row.DATAIMP = Cursor_operazbo.GetDate("DATAIMP");
        mcOperazioni.row.C_RAPPORTO = Cursor_operazbo.GetString("C_RAPPORTO");
        mcOperazioni.row.PAGASOGOP = Cursor_operazbo.GetString("PAGASOGOP");
        mcOperazioni.row.MTCN = Cursor_operazbo.GetString("MTCN");
        mcOperazioni.row.IDFILE = Cursor_operazbo.GetString("IDFILE");
        mcOperazioni.row.CDATREG = Cursor_operazbo.GetString("CDATREG");
        mcOperazioni.row.IPCOLLEG = Cursor_operazbo.GetString("IPCOLLEG");
        mcOperazioni.row.ORACOLLEG = Cursor_operazbo.GetDateTime("ORACOLLEG");
        mcOperazioni.row.DUCOLLEG = Cursor_operazbo.GetDouble("DUCOLLEG");
        mcOperazioni.row.ANNOOPE = Cursor_operazbo.GetDouble("ANNOOPE");
        mcOperazioni.row.IDBASE2 = Cursor_operazbo.GetString("IDBASE2");
        mcOperazioni.row.IMPIN = Cursor_operazbo.GetDouble("IMPIN");
        mcOperazioni.row.IMPOUT = Cursor_operazbo.GetDouble("IMPOUT");
        mcOperazioni.row.MITIG = Cursor_operazbo.GetDouble("MITIG");
        mcOperazioni.row.MITIGDOC = Cursor_operazbo.GetString("MITIGDOC");
        mcOperazioni.row.RISGLOB = Cursor_operazbo.GetString("RISGLOB");
        mcOperazioni.row.SV58550 = Cursor_operazbo.GetString("SV58550");
        mcOperazioni.row.PROQUOTA = Cursor_operazbo.GetDouble("PROQUOTA");
        mcOperazioni.row.TIPOORO = Cursor_operazbo.GetString("TIPOORO");
        mcOperazioni.row.DAC6 = Cursor_operazbo.GetString("DAC6");
        mcOperazioni.row.FLAGDAC6 = Cursor_operazbo.GetDouble("FLAGDAC6");
        mcOperazioni.row.IMPSARA = Cursor_operazbo.GetDouble("IMPSARA");
        mcOperazioni.row.SV58550MA = Cursor_operazbo.GetString("SV58550MA");
        mcOperazioni.row.NOSARA = Cursor_operazbo.GetString("NOSARA");
        mcOperazioni.row.MEZPAG = Cursor_operazbo.GetString("MEZPAG");
        mcOperazioni.row.PRESTAZ = Cursor_operazbo.GetString("PRESTAZ");
        mcOperazioni.row.CAUSALE = Cursor_operazbo.GetDouble("CAUSALE");
        mcOperazioni.row.NUMIMP = Cursor_operazbo.GetDateTime("NUMIMP");
        mcOperazioni.row.DESPUNTO = Cursor_operazbo.GetString("DESPUNTO");
        mcOperazioni.row.CODCLICON = Cursor_operazbo.GetString("CODCLICON");
        mcOperazioni.row.TIPATT = Cursor_operazbo.GetString("TIPATT");
        mcOperazioni.row.IMPPROG = Cursor_operazbo.GetString("IMPPROG");
        mcOperazioni.row.NOTE = Cursor_operazbo.GetString("NOTE");
        mcOperazioni.row.VASP = Cursor_operazbo.GetString("VASP");
        Cursor_operazbo.Next();
      }
      m_cConnectivityError = Cursor_operazbo.ErrorMessage();
      Cursor_operazbo.Close();
      mcOperazioni.GoTop();
      /* If mcOperazioni.RecCount() > 0 */
      if (CPLib.gt(mcOperazioni.RecCount(),0)) {
        for (MemoryCursorRow_operazbo rowOperazioni : mcOperazioni._iterable_()) {
          /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
          stringaflagrap2 = "ABCDEFGHI";
          /* _idbase := rowOperazioni.IDBASE */
          _idbase = rowOperazioni.IDBASE;
          /* _datreal := rowOperazioni.DATAOPE */
          _datreal = rowOperazioni.DATAOPE;
          /* _datreg := rowOperazioni.DATAREG */
          _datreg = rowOperazioni.DATAREG;
          /* _oldidb := rowOperazioni.IDBASE */
          _oldidb = rowOperazioni.IDBASE;
          /* _tdest := 'O' */
          _tdest = "O";
          /* _flagrap2 := iif(Empty(rowOperazioni.FLAGRAP2) or rowOperazioni.FLAGRAP2='S',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(rowOperazioni.FLAGRAP2,stringaflagrap2)+1),1)) */
          _flagrap2 = (CPLib.Empty(rowOperazioni.FLAGRAP2) || CPLib.eqr(rowOperazioni.FLAGRAP2,"S")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(rowOperazioni.FLAGRAP2,stringaflagrap2)+1),1));
          /* _idreg := rowOperazioni.IDEREG */
          _idreg = rowOperazioni.IDEREG;
          /* _idb2 := LibreriaMit.UniqueId() */
          _idb2 = LibreriaMit.UniqueId();
          /* cOpeProg2 := rowOperazioni.NUMPROG */
          cOpeProg2 = rowOperazioni.NUMPROG;
          // * --- Write into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000469")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowOperazioni.IDBASE,"?",0,0,m_cServer),m_cServer,rowOperazioni.IDBASE)+"";
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
          /* If w_tipodest='D' */
          if (CPLib.eqr(w_tipodest,"D")) {
            /* _omaxid := _omaxid + 1 */
            _omaxid = CPLib.Round(_omaxid+1,0);
            /* cOpeProg1 := Right('0000000000'+LRTrim(Str(_omaxid,10,0)),10) */
            cOpeProg1 = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_omaxid,10,0)),10);
          } else { // Else
            /* cOpeProg1 := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(_azienda)+"'",'',10) */
            cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(_azienda)+"'","",10);
          } // End If
          // * --- Merge into operazbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo_agg");
          m_cPhName = m_Ctx.GetPhName("operazbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo_agg",m_Ctx.GetCompany());
          m_cQuery = "select ";
          m_cQuery =  m_cQuery+""+CPLib.ToSQL(_oldidb,"?",0,0)+" as IDBASE";
          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
            m_cQuery = m_cQuery+" from dual";
          }
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cWhere = "operazbo_agg.IDBASE = cptmp_1xab23.IDBASE";
          m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
          if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000046E")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" operazbo_agg USING ";
            m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
            m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
            m_cSql = m_cSql+"WUDATRET = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo_agg",true,true);
            m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
            m_cSql = m_cSql+GetFieldsName_0000046E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo_agg",true);
            m_cSql = m_cSql+")";
            if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
              m_cSql = m_cSql+";";
            }
          } else {
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000046E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"WUDATRET = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo_agg",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer),m_cServer,_oldidb)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.eqr(m_nUpdatedRows,0)) {
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000046E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000046E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(_oldidb,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo_agg",true);
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
          }
          // * --- Insert into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000046F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000046F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(_datreal),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uifdest,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datreal),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datreal),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datreg),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codana,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_intercod,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_codsin,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNESCLI,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.CONNESDOC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datreal,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_datreg,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_intercit,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?"0":"1"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("O"+CPLib.Right(cOpeProg2,9)+_idb2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idfile,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.PRGIMPOPE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_interprv,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazioni.RAPPORTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(CPLib.Year(_datreal),4,0)+"-"+CPLib.LRTrim(_uniquecode)+"-"+_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_segno,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipope,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_tipope,"10")?_importo*100:0),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_importo*100,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nomefileimport),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* If At(pModo,'|R|M|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
              /* gMsgProc := gMsgProc +"OPERAZBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
              gMsgProc = gMsgProc+"OPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* _gMsgProc := _gMsgProc +"OPERAZBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
              _gMsgProc = _gMsgProc+"OPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
              /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            } // End If
            // Transaction Error
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"OPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
            throw new RoutineException(CPLib.FormatMsg(m_Ctx,"OPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Select from operazbo_agg
          m_cServer = m_Ctx.GetServer("operazbo_agg");
          m_cPhName = m_Ctx.GetPhName("operazbo_agg");
          if (Cursor_operazbo_agg!=null)
            Cursor_operazbo_agg.Close();
          Cursor_operazbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_oldidb,"?",0,0,m_cServer, m_oParameters),m_cServer,_oldidb)+" "+")"+(m_Ctx.IsSharedTemp("operazbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_operazbo_agg.Eof())) {
            // * --- Insert into operazbo_agg from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo_agg");
            m_cPhName = m_Ctx.GetPhName("operazbo_agg");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo_agg",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000477")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000477(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("CODLOB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("TIPOGIOCO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetDouble("CACODICE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("IDBIGLIETTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetDateTime("CADATAORA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetDouble("CATIPGIO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetDouble("CATIPCON"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetDouble("CAPV_COD"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("IDDOCALL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("VPCODICE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("CATEG01"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("CATEG02"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("CATEG03"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("CATEG04"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("CATEG05"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo_agg.GetString("CATEGORIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo_agg",true);
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
            Cursor_operazbo_agg.Next();
          }
          m_cConnectivityError = Cursor_operazbo_agg.ErrorMessage();
          Cursor_operazbo_agg.Close();
          // * --- End Select
        }
      } else { // Else
        // * --- Select from xperazbo
        m_cServer = m_Ctx.GetServer("xperazbo");
        m_cPhName = m_Ctx.GetPhName("xperazbo");
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
        Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,DATAOPE,DATAREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MTCN="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_uniquecode),10),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(CPLib.LRTrim(_uniquecode),10))+"  and  SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_segno,"?",0,0,m_cServer, m_oParameters),m_cServer,_segno)+"  and  CDATOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.DateToChar(_datmod),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.DateToChar(_datmod))+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_xperazbo.Eof())) {
          /* _idbase := xperazbo->IDBASE */
          _idbase = Cursor_xperazbo.GetString("IDBASE");
          /* _datreal := xperazbo->DATAOPE */
          _datreal = Cursor_xperazbo.GetDate("DATAOPE");
          /* _datreg := xperazbo->DATAREG */
          _datreg = Cursor_xperazbo.GetDate("DATAREG");
          /* _tdest := 'O' */
          _tdest = "O";
          Cursor_xperazbo.Next();
        }
        m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
        Cursor_xperazbo.Close();
        // * --- End Select
        /* If not(Empty(_idbase)) */
        if ( ! (CPLib.Empty(_idbase))) {
          // * --- Select from xperazbo
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          if (Cursor_xperazbo!=null)
            Cursor_xperazbo.Close();
          Cursor_xperazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,NUMPROG,CONNESCLI,CONNESDOC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("xperazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_xperazbo.Eof())) {
            // * --- Write into xperazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000047F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ANNOOPE = "+CPLib.ToSQL(CPLib.Year(_datreal),"N",4,0)+", ";
            m_cSql = m_cSql+"C_RAG = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_STA = "+CPLib.ToSQL(_uifdest,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAMBIO = "+CPLib.ToSQL(1,"N",9,4)+", ";
            m_cSql = m_cSql+"CDATAOPE = "+CPLib.ToSQL(CPLib.DateToChar(_datreal),"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"CDATOPE = "+CPLib.ToSQL(CPLib.DateToChar(_datreal),"C",8,0,m_cServer)+", ";
            m_cSql = m_cSql+"CDATREG = "+CPLib.ToSQL(CPLib.DateToChar(_datreg),"C",8,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODANA = "+CPLib.ToSQL(_codana,"C",4,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(_intercab,"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(_coddip,"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(_intercod,"C",11,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODVOC = "+CPLib.ToSQL(_codsin,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESCLI"),"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"CONNESDOC = "+CPLib.ToSQL(Cursor_xperazbo.GetString("CONNESDOC"),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(_datreal,"D",8,0)+", ";
            m_cSql = m_cSql+"DATAREG = "+CPLib.ToSQL(_datreg,"D",8,0)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(_intercit,30),"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGCONT = "+CPLib.ToSQL((CPLib.eqr(w_xMAFLGBON,"S")?"0":"1"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGFRAZ = "+CPLib.ToSQL("0","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(_idfile,"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"IMPOUT = "+CPLib.ToSQL(_importo,"N",15,2)+", ";
            m_cSql = m_cSql+"MTCN = "+CPLib.ToSQL(_uniquecode,"C",10,0,m_cServer)+", ";
            m_cSql = m_cSql+"OPRAP = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(_interprv,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAPPORTO = "+CPLib.ToSQL(_codrap,"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"RIFIMP = "+CPLib.ToSQL("XXXXXXXXX","C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"INFORM = "+CPLib.ToSQL(CPLib.Str(CPLib.Year(_datope),4,0)+"-"+CPLib.LRTrim(_uniquecode)+"-"+_segno,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SEGNO = "+CPLib.ToSQL(_segno,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOINF = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOLEG = "+CPLib.ToSQL("0","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPOOPRAP = "+CPLib.ToSQL(_tipope,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"TOTCONT = "+CPLib.ToSQL((CPLib.eqr(_tipope,"10")?_importo*100:0),"N",15,0)+", ";
            m_cSql = m_cSql+"TOTLIRE = "+CPLib.ToSQL(_importo*100,"N",15,0)+", ";
            m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(_uniquecode,"C",7,0,m_cServer)+", ";
            m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL("242","C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.LRTrim(nomefileimport),"C",100,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer),m_cServer,_idbase)+"";
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
            Cursor_xperazbo.Next();
          }
          m_cConnectivityError = Cursor_xperazbo.ErrorMessage();
          Cursor_xperazbo.Close();
          // * --- End Select
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_operazbo_agg!=null)
          Cursor_operazbo_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xperazbo!=null)
          Cursor_xperazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* _contao Numeric(10, 0) */
      double _contao;
      _contao = 0;
      /* _contao := 0 */
      _contao = CPLib.Round(0,0);
      for (MemoryCursorRow_tmp_import_rtra rowOperazbo : mcOperazbo._iterable_()) {
        /* _contao := _contao + 1 */
        _contao = CPLib.Round(_contao+1,0);
        /* If At(pModo,'|R|M|Y') <> 0 */
        if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
          /* gMsgImp := 'Elaboro operazione n. '+LRTrim(Str(_contao,10,0))+" su "+LRTrim(Str(_coper,10,0)) */
          gMsgImp = "Elaboro operazione n. "+CPLib.LRTrim(CPLib.Str(_contao,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_coper,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* If pModo='B' */
        if (CPLib.eqr(pModo,"B")) {
          /* Exec Routine arrt_writelog_imp('IMPORT','','Elaboro operazione n. '+LRTrim(Str(_contao,10,0))+" su "+LRTrim(Str(_coper,10,0))) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Elaboro operazione n. "+CPLib.LRTrim(CPLib.Str(_contao,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_coper,10,0)));
        } // End If
        /* _omaxim := _omaxim + 1 */
        _omaxim = CPLib.Round(_omaxim+1,0);
        /* _omaxid := _omaxid + 1 */
        _omaxid = CPLib.Round(_omaxid+1,0);
        /* _omaxpg := _omaxpg + 1 */
        _omaxpg = CPLib.Round(_omaxpg+1,0);
        /* nProgImp := _omaxim */
        nProgImp = CPLib.Round(_omaxim,0);
        /* If w_tipodest='P' */
        if (CPLib.eqr(w_tipodest,"P")) {
          /* cOpeProg1 := Right('0000000000'+LRTrim(Str(_omaxid,10,0)),10) */
          cOpeProg1 = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_omaxid,10,0)),10);
          /* cOpeProg2 := Right('00000000000'+LRTrim(Str(_omaxpg,11,0)),11) */
          cOpeProg2 = CPLib.Right("00000000000"+CPLib.LRTrim(CPLib.Str(_omaxpg,11,0)),11);
          // * --- Insert into xperazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xperazbo");
          m_cPhName = m_Ctx.GetPhName("xperazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000491")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000491(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.ANNOOPE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.C_RAG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.C_STA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CDATAOPE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CDATOPE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CDATREG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODANA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODCAB,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODDIPE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODINTER,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODVOC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CONNESCLI,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CONNESDOC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.DATAOPE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.DESCCIT,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.FLAGCONT,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.FLAGRAP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(rowOperazbo.DATAOPE)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.IDFILE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.IMPOUT,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.MTCN,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.OPRAP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.PROVINCIA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.RAPPORTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.RIFIMP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.INFORM,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.SEGNO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.TOTCONT,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.TOTLIRE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.UNIQUECODE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nomefileimport),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.C_STA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("81","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xperazbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* If At(pModo,'|R|M|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
              /* gMsgProc := gMsgProc +"XPERAZBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+NL */
              gMsgProc = gMsgProc+"XPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* _gMsgProc := _gMsgProc +"XPERAZBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+NL */
              _gMsgProc = _gMsgProc+"XPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+"\n";
              /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            } // End If
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Insert into xocopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("xocopebo");
          m_cPhName = m_Ctx.GetPhName("xocopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xocopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000499")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000499(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.CONNESCLI,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.TIPODOC,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.NUMDOCUM,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.DATARILASC,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.AUTRILASC,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.DATAVALI,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.DOMICILIO,35),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.CLIDESCCIT,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.CLIPROVINCIA,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.CLICAP,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowOperazbo.CLIPAESE),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowOperazbo.IDFILE),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"xocopebo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* If At(pModo,'|R|M|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
              /* gMsgProc := gMsgProc +"XOCOPEBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN " + rowOperazbo.MTCN + NL */
              gMsgProc = gMsgProc+"XOCOPEBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* _gMsgProc := _gMsgProc +"XOCOPEBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN " + rowOperazbo.MTCN + NL */
              _gMsgProc = _gMsgProc+"XOCOPEBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+"\n";
              /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            } // End If
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } else { // Else
          /* cOpeProg1 := Right('0000000000'+LRTrim(Str(_omaxid,10,0)),10) */
          cOpeProg1 = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_omaxid,10,0)),10);
          /* cOpeProg2 := Right('00000000000'+LRTrim(Str(_omaxpg,11,0)),11) */
          cOpeProg2 = CPLib.Right("00000000000"+CPLib.LRTrim(CPLib.Str(_omaxpg,11,0)),11);
          // * --- Insert into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000004A3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000004A3(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.ANNOOPE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.C_RAG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.C_STA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CDATAOPE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CDATOPE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CDATREG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODANA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODCAB,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODDIPE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODINTER,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CODVOC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CONNESCLI,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CONNESDOC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.DATAOPE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.DESCCIT,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.FLAGCONT,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.FLAGRAP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(rowOperazbo.DATAOPE)+cOpeProg2+"X","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.IDFILE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.IMPOUT,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.MTCN,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.OPRAP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.PROVINCIA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.RAPPORTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.RIFIMP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.INFORM,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.INFORM,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.SEGNO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.TIPOOPRAP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.TOTCONT,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.TOTLIRE,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.UNIQUECODE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("242","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nomefileimport),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.C_STA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("81","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* If At(pModo,'|R|M|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
              /* gMsgProc := gMsgProc +"OPERAZBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+NL */
              gMsgProc = gMsgProc+"OPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* _gMsgProc := _gMsgProc +"OPERAZBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+NL */
              _gMsgProc = _gMsgProc+"OPERAZBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+"\n";
              /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            } // End If
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          // * --- Insert into docopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("docopebo");
          m_cPhName = m_Ctx.GetPhName("docopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"docopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000004AB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000004AB(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.CONNESCLI,16),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.TIPODOC,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.NUMDOCUM,15),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.DATARILASC,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.AUTRILASC,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.DATAVALI,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.DOMICILIO,35),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.CLIDESCCIT,30),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.CLIPROVINCIA,2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowOperazbo.CLICAP,5),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowOperazbo.CLIPAESE),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowOperazbo.IDFILE),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"docopebo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* If At(pModo,'|R|M|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
              /* gMsgProc := gMsgProc +"DOCOPEBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN " + rowOperazbo.MTCN + NL */
              gMsgProc = gMsgProc+"DOCOPEBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* _gMsgProc := _gMsgProc +"DOCOPEBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN " + rowOperazbo.MTCN + NL */
              _gMsgProc = _gMsgProc+"DOCOPEBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+rowOperazbo.MTCN+"\n";
              /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
              _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            } // End If
            m_cLastMsgError = "";
            /* _esito := -1 */
            _esito = CPLib.Round(-1,0);
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } // End If
        /* If w_tipodest='D' */
        if (CPLib.eqr(w_tipodest,"D")) {
          /* _anno := Str(Year(_datope),4,0) */
          _anno = CPLib.Str(CPLib.Year(_datope),4,0);
          /* _idbase := '' */
          _idbase = "";
          // * --- Read from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_cSql = "";
          m_cSql = m_cSql+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowOperazbo.CONNESCLI,"C",16,0,m_cServer),m_cServer,rowOperazbo.CONNESCLI);
          m_cSql = m_cSql+" and ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_anno,"C",4,0,m_cServer),m_cServer,_anno);
          if (m_Ctx.IsSharedTemp("opextrbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _idbase = Read_Cursor.GetString("IDBASE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _idbase = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_idbase) */
          if (CPLib.Empty(_idbase)) {
            /* _opxmax := _opxmax+1 */
            _opxmax = CPLib.Round(_opxmax+1,0);
            // * --- Insert into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000004BA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000004BA(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowOperazbo.CONNESCLI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_anno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Generato da  MTCN: "+rowOperazbo.MTCN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_opxmax,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_anno+"_"+CPLib.LRTrim(rowOperazbo.CONNESCLI),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"opextrbo",true);
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
      }
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
  void Page_9() throws Exception {
    /* Formato Excel */
    /* _nfile := LRTrim(_pathdoc)+"/export/"+LRTrim(_azienda)+"/"+LRTrim(_filen) */
    _nfile = CPLib.LRTrim(_pathdoc)+"/export/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(_filen);
    /* Seleziona i record */
    // creo il contenitore dei fogli
    wb = new SXSSFWorkbook();
    sheet = (SXSSFSheet) wb.createSheet("Foglio1") ;
    CellStyle cs = wb.createCellStyle();
    cs.setFillForegroundColor(IndexedColors.LIME.getIndex());
    cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    Font f = wb.createFont();
    f.setBold(true);
    f.setFontHeightInPoints((short) 11);
    cs.setFont(f);
    //Azzero i contatori di fogli letti e righe scritte
    _i = 0;
    r=0;
    //Creo il record da scrivere
    row = sheet.createRow(r);
    cell =  row.createCell(0);
    cell.setCellValue("COGNOME");
    cell.setCellStyle(cs);
    cell = row.createCell(1);
    cell.setCellValue("NOME");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("INDIRIZZO");
    cell.setCellStyle(cs);
    cell =  row.createCell(3);
    cell.setCellValue("FLAG CODICE FISCALE");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("CODICE FISCALE");
    cell.setCellStyle(cs);
    cell =  row.createCell(5);
    cell.setCellValue("LUOGO DI NASCITA");
    cell.setCellStyle(cs);
    cell =  row.createCell(6);
    cell.setCellValue("NUM. DOCUMENTO");
    cell.setCellStyle(cs);
    cell =  row.createCell(7);
    cell.setCellValue("DATA SCADENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(8);
    cell.setCellValue("DATA RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(9);
    cell.setCellValue("AUTORITA' RILASCIO");
    cell.setCellStyle(cs);
    cell = row.createCell(10);
    cell.setCellValue("PAESE RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(11);
    cell.setCellValue("CITTA' DI RESIDENZA");
    cell.setCellStyle(cs);
    cell = row.createCell(12);
    cell.setCellValue("TIPO DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(13);
    cell.setCellValue("DATA OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(14);
    cell.setCellValue("FLAG CONTANTI");
    cell.setCellStyle(cs);
    cell = row.createCell(15);
    cell.setCellValue("TIPO TRANSAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(16);
    cell.setCellValue("IMPORTO TRX");
    cell.setCellStyle(cs);
    cell = row.createCell(17);
    cell.setCellValue("CONTANTI TRX");
    cell.setCellStyle(cs);
    cell = row.createCell(18);
    cell.setCellValue("UNIQUE ID TRX");
    cell.setCellStyle(cs);
    cell = row.createCell(19);
    cell.setCellValue("CODICE AGENZIA");
    cell.setCellStyle(cs);
    cell = row.createCell(20);
    cell.setCellValue("COGNOME CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(21);
    cell.setCellValue("NOME CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(22);
    cell.setCellValue("STATO CONTROPARTE");
    cell.setCellStyle(cs);
    cell = row.createCell(23);
    cell.setCellValue("MTCN");
    cell.setCellStyle(cs);
    cell = row.createCell(24);
    cell.setCellValue("DATA DI NASCITA");
    cell.setCellStyle(cs);
    cell = row.createCell(25);
    cell.setCellValue("SESSO");
    cell.setCellStyle(cs);
    cell = row.createCell(26);
    cell.setCellValue("CODICE CATASTALE");
    cell.setCellStyle(cs);
    cell = row.createCell(27);
    cell.setCellValue("TIPO OPERAZIONE");
    cell.setCellStyle(cs);
    cell = row.createCell(28);
    cell.setCellValue("MACROAGENTE");
    cell.setCellStyle(cs);
    cell = row.createCell(29);
    cell.setCellValue("CODICE UNIVOCO");
    cell.setCellStyle(cs);
    cell = row.createCell(30);
    cell.setCellValue("NAZIONE RILASCIO DOCUMENTO");
    cell.setCellStyle(cs);
    cell = row.createCell(31);
    cell.setCellValue("GALACTIC ID");
    cell.setCellStyle(cs);
    cell = row.createCell(32);
    cell.setCellValue("ERRORE 1");
    cell.setCellStyle(cs);
    cell = row.createCell(33);
    cell.setCellValue("ERRORE 2");
    cell.setCellStyle(cs);
    cell = row.createCell(34);
    cell.setCellValue("ERRORE 3");
    cell.setCellStyle(cs);
    cell = row.createCell(35);
    cell.setCellValue("ERRORE 4");
    cell.setCellStyle(cs);
    cell = row.createCell(36);
    cell.setCellValue("ERRORE 5");
    cell.setCellStyle(cs);
    cell = row.createCell(37);
    cell.setCellValue("ERRORE 6");
    cell.setCellStyle(cs);
    cell = row.createCell(38);
    cell.setCellValue("ERRORE 7");
    cell.setCellStyle(cs);
    cell = row.createCell(39);
    cell.setCellValue("ERRORE 8");
    cell.setCellStyle(cs);
    cell = row.createCell(40);
    cell.setCellValue("ERRORE 9");
    cell.setCellStyle(cs);
    cell = row.createCell(41);
    cell.setCellValue("ERRORE 10");
    cell.setCellStyle(cs);
    cell = row.createCell(42);
    cell.setCellValue("ERRORE 11");
    cell.setCellStyle(cs);
    cell = row.createCell(43);
    cell.setCellValue("ERRORE 12");
    cell.setCellStyle(cs);
    cell = row.createCell(44);
    cell.setCellValue("ERRORE 13");
    cell.setCellStyle(cs);
    cell = row.createCell(45);
    cell.setCellValue("ERRORE 14");
    cell.setCellStyle(cs);
    cell = row.createCell(46);
    cell.setCellValue("ERRORE 15");
    cell.setCellStyle(cs);
    cell = row.createCell(47);
    cell.setCellValue("ERRORE 16");
    cell.setCellStyle(cs);
    cell = row.createCell(48);
    cell.setCellValue("ERRORE 17");
    cell.setCellStyle(cs);
    cell = row.createCell(49);
    cell.setCellValue("ERRORE 18");
    cell.setCellStyle(cs);
    cell = row.createCell(50);
    cell.setCellValue("ERRORE 19");
    cell.setCellStyle(cs);
    cell = row.createCell(51);
    cell.setCellValue("ERRORE 20");
    cell.setCellStyle(cs);
    cell = row.createCell(52);
    cell.setCellValue("ERRORE 21");
    cell.setCellStyle(cs);
    cell = row.createCell(53);
    cell.setCellValue("ERRORE 22");
    cell.setCellStyle(cs);
    cell = row.createCell(54);
    cell.setCellValue("ERRORE 23");
    cell.setCellStyle(cs);
    cell = row.createCell(55);
    cell.setCellValue("ERRORE 24");
    cell.setCellStyle(cs);
    cell = row.createCell(56);
    cell.setCellValue("ERRORE 25");
    cell.setCellStyle(cs);
    cell = row.createCell(57);
    cell.setCellValue("ERRORE 26");
    cell.setCellStyle(cs);
    cell = row.createCell(58);
    cell.setCellValue("ERRORE 27");
    cell.setCellStyle(cs);
    cell = row.createCell(59);
    cell.setCellValue("ERRORE 28");
    cell.setCellStyle(cs);
    cell = row.createCell(60);
    cell.setCellValue("ERRORE 29");
    cell.setCellStyle(cs);
    cell = row.createCell(61);
    cell.setCellValue("ERRORE 30");
    cell.setCellStyle(cs);
    cell = row.createCell(62);
    cell.setCellValue("ERRORE 31");
    cell.setCellStyle(cs);
    cell = row.createCell(63);
    cell.setCellValue("ERRORE 32");
    cell.setCellStyle(cs);
    cell = row.createCell(64);
    cell.setCellValue("ERRORE 33");
    cell.setCellStyle(cs);
    cell = row.createCell(65);
    cell.setCellValue("ERRORE 34");
    cell.setCellStyle(cs);
    cell = row.createCell(66);
    cell.setCellValue("ERRORE 35");
    cell.setCellStyle(cs);
    cell = row.createCell(67);
    cell.setCellValue("ERRORE 36");
    cell.setCellStyle(cs);
    cell = row.createCell(68);
    cell.setCellValue("ERRORE 37");
    cell.setCellStyle(cs);
    cell = row.createCell(69);
    cell.setCellValue("ERRORE 38");
    cell.setCellStyle(cs);
    cell = row.createCell(70);
    cell.setCellValue("ERRORE 39");
    cell.setCellStyle(cs);
    cell = row.createCell(71);
    cell.setCellValue("ERRORE 40");
    cell.setCellStyle(cs);
    cell = row.createCell(72);
    cell.setCellValue("ERRORE 41");
    cell.setCellStyle(cs);
    cell = row.createCell(73);
    cell.setCellValue("RIF. AUA");
    cell.setCellStyle(cs);
    cell = row.createCell(74);
    cell.setCellValue("OPERAZIONE CORRETTA");
    cell.setCellStyle(cs);
    cell = row.createCell(75);
    cell.setCellValue("FORZA SCRITTURA");
    cell.setCellStyle(cs);
    cell = row.createCell(76);
    cell.setCellValue("ESITO AUA");
    cell.setCellStyle(cs);
    r++;
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcErrate._iterable_()) {
      // Scrive la riga
      row = sheet.createRow(r);
      cell = row.createCell(0);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna01));
      cell = row.createCell(1);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna02));
      cell = row.createCell(2);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna03));
      cell = row.createCell(3);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna04));
      cell = row.createCell(4);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna05));
      cell = row.createCell(5);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna06));
      cell = row.createCell(6);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna07));
      cell = row.createCell(7);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna08));
      cell = row.createCell(8);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna09));
      cell = row.createCell(9);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna10));
      cell = row.createCell(10);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna11));
      cell = row.createCell(11);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna12));
      cell = row.createCell(12);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna13));
      cell = row.createCell(13);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna14));
      cell = row.createCell(14);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna15));
      cell = row.createCell(15);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna16));
      cell = row.createCell(16);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna17));
      cell = row.createCell(17);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna18));
      cell = row.createCell(18);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna19));
      cell = row.createCell(19);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna20));
      cell = row.createCell(20);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna21));
      cell = row.createCell(21);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna22));
      cell = row.createCell(22);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna23));
      cell = row.createCell(23);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna24));
      cell = row.createCell(24);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna25));
      cell = row.createCell(25);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna26));
      cell = row.createCell(26);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna27));
      cell = row.createCell(27);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna28));
      cell = row.createCell(28);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna29));
      cell = row.createCell(29);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna30));
      cell = row.createCell(30);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna31));
      cell = row.createCell(31);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna32));
      cell = row.createCell(32);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna33));
      cell = row.createCell(33);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna34));
      cell = row.createCell(34);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna35));
      cell = row.createCell(35);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna36));
      cell = row.createCell(36);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna37));
      cell = row.createCell(37);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna38));
      cell = row.createCell(38);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna39));
      cell = row.createCell(39);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna40));
      cell = row.createCell(40);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna41));
      cell = row.createCell(41);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna42));
      cell = row.createCell(42);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna43));
      cell = row.createCell(43);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna44));
      cell = row.createCell(44);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna45));
      cell = row.createCell(45);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna46));
      cell = row.createCell(46);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna47));
      cell = row.createCell(47);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna48));
      cell = row.createCell(48);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna49));
      cell = row.createCell(49);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna50));
      cell = row.createCell(50);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna51));
      cell = row.createCell(51);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna52));
      cell = row.createCell(52);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna53));
      cell = row.createCell(53);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna54));
      cell = row.createCell(54);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna55));
      cell = row.createCell(55);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna56));
      cell = row.createCell(56);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna57));
      cell = row.createCell(57);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna58));
      cell = row.createCell(58);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna59));
      cell = row.createCell(59);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna60));
      cell = row.createCell(60);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna61));
      cell = row.createCell(61);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna62));
      cell = row.createCell(62);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna63));
      cell = row.createCell(63);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna64));
      cell = row.createCell(64);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna65));
      cell = row.createCell(65);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna66));
      cell = row.createCell(66);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna67));
      cell = row.createCell(67);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna68));
      cell = row.createCell(68);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna69));
      cell = row.createCell(69);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna70));
      cell = row.createCell(70);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna71));
      cell = row.createCell(71);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna72));
      cell = row.createCell(72);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna73));
      cell = row.createCell(73);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna74));
      cell = row.createCell(74);
      cell.setCellValue(CPLib.LRTrim("N"));
      cell = row.createCell(75);
      cell.setCellValue(CPLib.LRTrim("N"));
      cell = row.createCell(76);
      cell.setCellValue(CPLib.LRTrim("O"));
      r++;
    }
    /* gMsgImp := 'Attendere. Creazione del file excel ...' // Messaggio Import */
    gMsgImp = "Attendere. Creazione del file excel ...";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    //Ridimensiono le colonne in base al contenuto
    sheet.trackAllColumnsForAutoSizing() ;
    sheet.autoSizeColumn(0);
    sheet.autoSizeColumn(1);
    sheet.autoSizeColumn(2);
    sheet.autoSizeColumn(3);
    sheet.autoSizeColumn(4);
    sheet.autoSizeColumn(5);
    sheet.autoSizeColumn(6);
    sheet.autoSizeColumn(7);
    sheet.autoSizeColumn(8);
    sheet.autoSizeColumn(9);
    sheet.autoSizeColumn(10);
    sheet.autoSizeColumn(11);
    sheet.autoSizeColumn(12);
    sheet.autoSizeColumn(13);
    sheet.autoSizeColumn(14);
    sheet.autoSizeColumn(15);
    sheet.autoSizeColumn(16);
    sheet.autoSizeColumn(17);
    sheet.autoSizeColumn(18);
    sheet.autoSizeColumn(19);
    sheet.autoSizeColumn(20);
    sheet.autoSizeColumn(21);
    sheet.autoSizeColumn(22);
    sheet.autoSizeColumn(23);
    sheet.autoSizeColumn(24);
    sheet.autoSizeColumn(25);
    sheet.autoSizeColumn(26);
    sheet.autoSizeColumn(27);
    sheet.autoSizeColumn(28);
    sheet.autoSizeColumn(29);
    sheet.autoSizeColumn(30);
    sheet.autoSizeColumn(31);
    sheet.autoSizeColumn(32);
    sheet.autoSizeColumn(33);
    sheet.autoSizeColumn(34);
    sheet.autoSizeColumn(35);
    sheet.autoSizeColumn(36);
    sheet.autoSizeColumn(37);
    sheet.autoSizeColumn(38);
    sheet.autoSizeColumn(39);
    sheet.autoSizeColumn(40);
    sheet.autoSizeColumn(41);
    sheet.autoSizeColumn(42);
    sheet.autoSizeColumn(43);
    sheet.autoSizeColumn(44);
    sheet.autoSizeColumn(45);
    sheet.autoSizeColumn(46);
    sheet.autoSizeColumn(47);
    sheet.autoSizeColumn(48);
    sheet.autoSizeColumn(49);
    sheet.autoSizeColumn(50);
    sheet.autoSizeColumn(51);
    sheet.autoSizeColumn(52);
    sheet.autoSizeColumn(53);
    sheet.autoSizeColumn(54);
    sheet.autoSizeColumn(55);
    sheet.autoSizeColumn(56);
    sheet.autoSizeColumn(57);
    sheet.autoSizeColumn(58);
    sheet.autoSizeColumn(59);
    sheet.autoSizeColumn(60);
    sheet.autoSizeColumn(61);
    sheet.autoSizeColumn(62);
    sheet.autoSizeColumn(63);
    sheet.autoSizeColumn(64);
    sheet.autoSizeColumn(65);
    sheet.autoSizeColumn(66);
    sheet.autoSizeColumn(67);
    sheet.autoSizeColumn(68);
    sheet.autoSizeColumn(69);
    sheet.autoSizeColumn(70);
    sheet.autoSizeColumn(71);
    sheet.autoSizeColumn(72);
    sheet.autoSizeColumn(73);
    sheet.autoSizeColumn(74);
    sheet.autoSizeColumn(75);
    sheet.autoSizeColumn(76);
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
    // * --- Insert into tmp_listafile from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_listafile");
    m_cPhName = m_Ctx.GetPhName("tmp_listafile");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000004C9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
    m_cSql = m_cSql+GetFieldsName_000004C9(m_Ctx,m_oWrInfo);
    m_cSql = m_cSql+") values (";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"export/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+m_oWrInfo.InsertValues();
    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listafile",true);
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
  void Page_10() throws Exception {
    /* Formato Excel */
    /* _filen := "ERRPOS_"+_trxdate+".xlsx" */
    _filen = "ERRPOS_"+_trxdate+".xlsx";
    /* _nfile := LRTrim(_pathdoc)+"/export/"+LRTrim(_azienda)+"/"+LRTrim(_filen) */
    _nfile = CPLib.LRTrim(_pathdoc)+"/export/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(_filen);
    /* Seleziona i record */
    // creo il contenitore dei fogli
    wb = new SXSSFWorkbook();
    sheet = (SXSSFSheet) wb.createSheet("Foglio1") ;
    CellStyle cs = wb.createCellStyle();
    cs.setFillForegroundColor(IndexedColors.LIME.getIndex());
    cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    Font f = wb.createFont();
    f.setBold(true);
    f.setFontHeightInPoints((short) 11);
    cs.setFont(f);
    //Azzero i contatori di fogli letti e righe scritte
    _i = 0;
    r=0;
    //Creo il record da scrivere
    row = sheet.createRow(r);
    cell =  row.createCell(0);
    cell.setCellValue("MacroAgente");
    cell.setCellStyle(cs);
    cell =  row.createCell(1);
    cell.setCellValue("Codice AJW");
    cell.setCellStyle(cs);
    cell = row.createCell(2);
    cell.setCellValue("Ragione Sociale");
    cell.setCellStyle(cs);
    cell = row.createCell(3);
    cell.setCellValue("Domicilio");
    cell.setCellStyle(cs);
    cell =  row.createCell(4);
    cell.setCellValue("Città");
    cell.setCellStyle(cs);
    cell =  row.createCell(5);
    cell.setCellValue("Tipo Riga");
    cell.setCellStyle(cs);
    cell =  row.createCell(6);
    cell.setCellValue("Errore 1");
    cell.setCellStyle(cs);
    cell =  row.createCell(7);
    cell.setCellValue("Errore 2");
    cell.setCellStyle(cs);
    cell =  row.createCell(8);
    cell.setCellValue("Errore 3");
    cell.setCellStyle(cs);
    cell =  row.createCell(9);
    cell.setCellValue("Errore 4");
    cell.setCellStyle(cs);
    cell =  row.createCell(10);
    cell.setCellValue("Errore 5");
    cell.setCellStyle(cs);
    cell =  row.createCell(11);
    cell.setCellValue("Errore 6");
    cell.setCellStyle(cs);
    cell =  row.createCell(12);
    cell.setCellValue("Errore 7");
    cell.setCellStyle(cs);
    cell =  row.createCell(13);
    cell.setCellValue("Errore 8");
    cell.setCellStyle(cs);
    cell =  row.createCell(14);
    cell.setCellValue("Errore 9");
    cell.setCellStyle(cs);
    cell =  row.createCell(15);
    cell.setCellValue("AGENZIA CORRETTA");
    cell.setCellStyle(cs);
    r++;
    MemoryCursor_mcerratedef_mcrdef cpmc_000004D3;
    cpmc_000004D3 = new MemoryCursor_mcerratedef_mcrdef();
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcErrAge._iterable_()) {
      cpmc_000004D3.Append(rowErrate);
    }
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : cpmc_000004D3._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_mcerratedef_mcrdef>(){  public int compare(MemoryCursorRow_mcerratedef_mcrdef r1,MemoryCursorRow_mcerratedef_mcrdef r2){    if (CPLib.gt(r1.colonna01,r2.colonna01)) return 1;    if (CPLib.lt(r1.colonna01,r2.colonna01)) return -1;    return 0;  }})) {
      // Scrive la riga
      row = sheet.createRow(r);
      cell = row.createCell(0);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna01));
      cell = row.createCell(1);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna02));
      cell = row.createCell(2);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna03));
      cell = row.createCell(3);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna04));
      cell = row.createCell(4);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna05));
      cell = row.createCell(5);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna06));
      cell = row.createCell(6);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna07));
      cell = row.createCell(7);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna08));
      cell = row.createCell(8);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna09));
      cell = row.createCell(9);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna10));
      cell = row.createCell(10);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna11));
      cell = row.createCell(11);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna12));
      cell = row.createCell(12);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna13));
      cell = row.createCell(13);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna14));
      cell = row.createCell(14);
      cell.setCellValue(CPLib.LRTrim(rowErrate.colonna15));
      cell = row.createCell(15);
      cell.setCellValue("N");
      r++;
    }
    /* gMsgImp := 'Attendere. Creazione del file excel ...' // Messaggio Import */
    gMsgImp = "Attendere. Creazione del file excel ...";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    //Ridimensiono le colonne in base al contenuto
    sheet.trackAllColumnsForAutoSizing() ;
    sheet.autoSizeColumn(0);
    sheet.autoSizeColumn(1);
    sheet.autoSizeColumn(2);
    sheet.autoSizeColumn(3);
    sheet.autoSizeColumn(4);
    sheet.autoSizeColumn(5);
    sheet.autoSizeColumn(6);
    sheet.autoSizeColumn(7);
    sheet.autoSizeColumn(8);
    sheet.autoSizeColumn(9);
    sheet.autoSizeColumn(10);
    sheet.autoSizeColumn(11);
    sheet.autoSizeColumn(12);
    sheet.autoSizeColumn(13);
    sheet.autoSizeColumn(14);
    sheet.autoSizeColumn(15);
    // scrivo il file di esito
    FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(_nfile));
    //write this workbook to an Outputstream.
    wb.write(fileOut);
    fileOut.flush();
    fileOut.close();
    // * --- Insert into tmp_listafile from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_listafile");
    m_cPhName = m_Ctx.GetPhName("tmp_listafile");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000004D8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
    m_cSql = m_cSql+GetFieldsName_000004D8(m_Ctx,m_oWrInfo);
    m_cSql = m_cSql+") values (";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(2,"?",0,0)+", ";
    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"export/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(_filen),"?",0,0,m_cServer)+", ";
    m_cSql = m_cSql+m_oWrInfo.InsertValues();
    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listafile",true);
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
  void Page_11() throws Exception {
    /* _totale Numeric(10, 0) */
    double _totale;
    _totale = 0;
    /* _totnaid Numeric(10, 0) */
    double _totnaid;
    _totnaid = 0;
    /* _lista Char(80) */
    String _lista;
    _lista = CPLib.Space(80);
    /* _lista2 Char(120) */
    String _lista2;
    _lista2 = CPLib.Space(120);
    /* mcTransazioni MemoryCursor(mcRTRANAID.MCRDef) */
    MemoryCursor_mcrtranaid_mcrdef mcTransazioni;
    mcTransazioni = new MemoryCursor_mcrtranaid_mcrdef();
    /* mcDoppie MemoryCursor(mcRTRADOPPIE.MCRDef) */
    MemoryCursor_mcrtradoppie_mcrdef mcDoppie;
    mcDoppie = new MemoryCursor_mcrtradoppie_mcrdef();
    /* sHand Char(1) */
    String sHand;
    sHand = CPLib.Space(1);
    /* _errorimsg Memo */
    String _errorimsg;
    _errorimsg = "";
    /* _erroritrx Numeric(2, 0) */
    double _erroritrx;
    _erroritrx = 0;
    /* _nriga Char(10) */
    String _nriga;
    _nriga = CPLib.Space(10);
    /* _lista := '' */
    _lista = "";
    /* _lista2 := '' */
    _lista2 = "";
    for (MemoryCursorRow_tbmacage rowMacAge : mcMacAge._iterable_()) {
      /* If rowMacAge.MAFLGBON='N' */
      if (CPLib.eqr(rowMacAge.MAFLGBON,"N")) {
        /* _lista := _lista + '|'+LRTrim(rowMacAge.MANAIDWU) */
        _lista = _lista+"|"+CPLib.LRTrim(rowMacAge.MANAIDWU);
      } // End If
      /* If not(Empty(LRTrim(rowMacAge.MANAIDWU))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(rowMacAge.MANAIDWU)))) {
        /* _lista2 := _lista2 + '|'+LRTrim(rowMacAge.MANAIDWU) */
        _lista2 = _lista2+"|"+CPLib.LRTrim(rowMacAge.MANAIDWU);
      } // End If
    }
    /* If At(pModo,'|R|M|Y') <> 0 */
    if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
      /* gMsgProc := gMsgProc + 'Ora Inizio Controlli Tipo G: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Controlli Tipo G: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } else { // Else
      /* _gMsgProc := _gMsgProc + 'Ora Inizio Controlli Tipo G: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      _gMsgProc = _gMsgProc+"Ora Inizio Controlli Tipo G: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Inizio Controlli Tipo G: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport) */
      arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Inizio Controlli Tipo G: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport);
    } // End If
    /* _tottrans := 0 */
    _tottrans = CPLib.Round(0,0);
    /* _totale := 0 */
    _totale = CPLib.Round(0,0);
    /* _totnaid := 0 */
    _totnaid = CPLib.Round(0,0);
    /* _filescarti := 'scarti_'+LRTrim(nomefileimport) */
    _filescarti = "scarti_"+CPLib.LRTrim(nomefileimport);
    /* sHand := FileLibMit.OpenWritePath(_pathdoc+"/export/"+LRTrim(_azienda)+"/"+LRTrim(_filescarti)) */
    sHand = FileLibMit.OpenWritePath(_pathdoc+"/export/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(_filescarti));
    /* fhand := FileLibMit.OpenReadPath(_pathdoc+"/appo/"+LRTrim(_azienda)+"/"+LRTrim(nomefileimport)) */
    fhand = FileLibMit.OpenReadPath(_pathdoc+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
    /* mcTransazioni.Zap() */
    mcTransazioni.Zap();
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If Len(LRTrim(riga)) > 0 and Left(riga,1) <> '#' */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0) && CPLib.ne(CPLib.Left(riga,1),"#")) {
        /* _tottrans := _tottrans + 1 */
        _tottrans = CPLib.Round(_tottrans+1,0);
        /* _nriga := ' ('+LRTrim(Str(_tottrans,10,0))+')' */
        _nriga = " ("+CPLib.LRTrim(CPLib.Str(_tottrans,10,0))+")";
        /* _errorimsg := '' */
        _errorimsg = "";
        /* If Len(riga) < 854  */
        if (CPLib.lt(CPLib.Len(riga),854)) {
          /* _errorig := _errorig + 1 */
          _errorig = CPLib.Round(_errorig+1,0);
          /* _erroritrx := _erroritrx + 1 */
          _erroritrx = CPLib.Round(_erroritrx+1,0);
          /* _errorimsg := _errorimsg + '- Riga non conforme agli standard '  */
          _errorimsg = _errorimsg+"- Riga non conforme agli standard ";
        } else { // Else
          /* If Empty(LRTrim(Substr(riga,849,1))) or (At(Substr(riga,849,1),'|I|M|D') = 0) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,849,1))) || (CPLib.eqr(CPLib.At(CPLib.Substr(riga,849,1),"|I|M|D"),0))) {
            /* _errorig := _errorig + 1 */
            _errorig = CPLib.Round(_errorig+1,0);
            /* _erroritrx := _erroritrx + 1 */
            _erroritrx = CPLib.Round(_erroritrx+1,0);
            /* _errorimsg := _errorimsg + '- Tipo riga assente o non valido '  */
            _errorimsg = _errorimsg+"- Tipo riga assente o non valido ";
          } else { // Else
            /* w_codmage := '' */
            w_codmage = "";
            /* _flgact := '' */
            _flgact = "";
            /* If mcMacAge.GoToKey(Substr(riga,850,5)) */
            if (mcMacAge.GoToKey(CPLib.Substr(riga,850,5))) {
              /* w_codmage := mcMacAge.MACODICE */
              w_codmage = mcMacAge.row.MACODICE;
              /* _flgact := mcMacAge.MAFLGACT */
              _flgact = mcMacAge.row.MAFLGACT;
            } // End If
            /* _errorimsg := '' */
            _errorimsg = "";
            /* _erroritrx := 0 */
            _erroritrx = CPLib.Round(0,0);
            /* If mcTransazioni.GoToKey(Substr(riga,850,5)) */
            if (mcTransazioni.GoToKey(CPLib.Substr(riga,850,5))) {
              /* mcTransazioni.TOTALE := mcTransazioni.TOTALE + 1 */
              mcTransazioni.row.TOTALE = mcTransazioni.row.TOTALE+1;
              /* mcTransazioni.SaveRow() */
              mcTransazioni.SaveRow();
            } else { // Else
              /* mcTransazioni.AppendWithKey(Substr(riga,850,5)) */
              mcTransazioni.AppendWithKey(CPLib.Substr(riga,850,5));
              /* mcTransazioni.NAID := Substr(riga,850,5) */
              mcTransazioni.row.NAID = CPLib.Substr(riga,850,5);
              /* mcTransazioni.TOTALE := 1 */
              mcTransazioni.row.TOTALE = 1;
              /* mcTransazioni.SaveRow() */
              mcTransazioni.SaveRow();
            } // End If
            /* _totale := _totale + 1 */
            _totale = CPLib.Round(_totale+1,0);
            /* If Empty(LRTrim(Substr(riga,850,5))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,850,5)))) {
              /* _errorig := _errorig + 1 */
              _errorig = CPLib.Round(_errorig+1,0);
              /* _erroritrx := _erroritrx + 1 */
              _erroritrx = CPLib.Round(_erroritrx+1,0);
              /* _errorimsg := _errorimsg + '- Riga senza NAID macroagente '  */
              _errorimsg = _errorimsg+"- Riga senza NAID macroagente ";
            } // End If
            /* If At(Substr(riga,850,5),_lista2) > 0 */
            if (CPLib.gt(CPLib.At(CPLib.Substr(riga,850,5),_lista2),0)) {
              /* If pNoDG='N' */
              if (CPLib.eqr(pNoDG,"N")) {
                /* If Substr(riga,466,8) <> _trxdate */
                if (CPLib.ne(CPLib.Substr(riga,466,8),_trxdate)) {
                  /* _errorig := _errorig + 1 */
                  _errorig = CPLib.Round(_errorig+1,0);
                  /* _erroritrx := _erroritrx + 1 */
                  _erroritrx = CPLib.Round(_erroritrx+1,0);
                  /* _errorimsg := _errorimsg + '- Riga con data operazione diversa da data del file '  */
                  _errorimsg = _errorimsg+"- Riga con data operazione diversa da data del file ";
                } // End If
              } // End If
              /* If (not(Empty(LRTrim(Substr(riga,298,8)))) and Val(Substr(riga,298,4)) < 1900) */
              if (( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,298,8)))) && CPLib.lt(CPLib.Val(CPLib.Substr(riga,298,4)),1900))) {
                /* _errorig := _errorig + 1 */
                _errorig = CPLib.Round(_errorig+1,0);
                /* _erroritrx := _erroritrx + 1 */
                _erroritrx = CPLib.Round(_erroritrx+1,0);
                /* _errorimsg := _errorimsg + '- Sono presenti date inferiori al 1900 (Data Scadenza Documento) -  Posizione 298' */
                _errorimsg = _errorimsg+"- Sono presenti date inferiori al 1900 (Data Scadenza Documento) -  Posizione 298";
              } // End If
              /* If not(Empty(LRTrim(Substr(riga,306,8)))) and Val(Substr(riga,306,4)) < 1900 */
              if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,306,8)))) && CPLib.lt(CPLib.Val(CPLib.Substr(riga,306,4)),1900)) {
                /* _errorig := _errorig + 1 */
                _errorig = CPLib.Round(_errorig+1,0);
                /* _erroritrx := _erroritrx + 1 */
                _erroritrx = CPLib.Round(_erroritrx+1,0);
                /* _errorimsg := _errorimsg + '- Sono presenti date inferiori al 1900 (Data Rilascio Documento) -  Posizione 306' */
                _errorimsg = _errorimsg+"- Sono presenti date inferiori al 1900 (Data Rilascio Documento) -  Posizione 306";
              } // End If
              /* If not(Empty(LRTrim(Substr(riga,836,8)))) and Val(Substr(riga,836,4)) < 1900 */
              if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,836,8)))) && CPLib.lt(CPLib.Val(CPLib.Substr(riga,836,4)),1900)) {
                /* _errorig := _errorig + 1 */
                _errorig = CPLib.Round(_errorig+1,0);
                /* _erroritrx := _erroritrx + 1 */
                _erroritrx = CPLib.Round(_erroritrx+1,0);
                /* _errorimsg := _errorimsg + '- Sono presenti date inferiori al 1900 (Data Nascita) -  Posizione 836' */
                _errorimsg = _errorimsg+"- Sono presenti date inferiori al 1900 (Data Nascita) -  Posizione 836";
              } // End If
              /* If Val(Substr(riga,476,15)) >= 100000 and At(LRTrim(Substr(riga,850,5)),_lista) > 0 */
              if (CPLib.ge(CPLib.Val(CPLib.Substr(riga,476,15)),100000) && CPLib.gt(CPLib.At(CPLib.LRTrim(CPLib.Substr(riga,850,5)),_lista),0)) {
                /* _errorig := _errorig + 1 */
                _errorig = CPLib.Round(_errorig+1,0);
                /* _erroritrx := _erroritrx + 1 */
                _erroritrx = CPLib.Round(_erroritrx+1,0);
                /* _errorimsg := _errorimsg + '- Transazione con importo > 1000 '  */
                _errorimsg = _errorimsg+"- Transazione con importo > 1000 ";
              } // End If
            } // End If
            /* If (not(Empty(w_codmage)) and _flgact='S') or Empty(Substr(riga,850,5)) */
            if (( ! (CPLib.Empty(w_codmage)) && CPLib.eqr(_flgact,"S")) || CPLib.Empty(CPLib.Substr(riga,850,5))) {
              /* If mcDoppie.GoToKey(Substr(riga,826,10)+Substr(riga,466,8)+Substr(riga,475,1)+Substr(riga,849,1)) */
              if (mcDoppie.GoToKey(CPLib.Substr(riga,826,10)+CPLib.Substr(riga,466,8)+CPLib.Substr(riga,475,1)+CPLib.Substr(riga,849,1))) {
                /* _errorig := _errorig + 1 */
                _errorig = CPLib.Round(_errorig+1,0);
                /* _erroritrx := _erroritrx + 1 */
                _erroritrx = CPLib.Round(_erroritrx+1,0);
                /* _errorimsg := _errorimsg + '- Transazione doppia '  */
                _errorimsg = _errorimsg+"- Transazione doppia ";
              } // End If
              /* mcDoppie.AppendWithKey(Substr(riga,826,10)+Substr(riga,466,8)+Substr(riga,475,1)+Substr(riga,849,1)) */
              mcDoppie.AppendWithKey(CPLib.Substr(riga,826,10)+CPLib.Substr(riga,466,8)+CPLib.Substr(riga,475,1)+CPLib.Substr(riga,849,1));
              /* mcDoppie.MTCN := Substr(riga,826,10) */
              mcDoppie.row.MTCN = CPLib.Substr(riga,826,10);
              /* mcDoppie.DATAOPE := Substr(riga,466,8) */
              mcDoppie.row.DATAOPE = CPLib.Substr(riga,466,8);
              /* mcDoppie.SEGNO := Substr(riga,475,1) */
              mcDoppie.row.SEGNO = CPLib.Substr(riga,475,1);
              /* mcDoppie.CAUSALE := Substr(riga,849,1) */
              mcDoppie.row.CAUSALE = CPLib.Substr(riga,849,1);
              /* mcDoppie.SaveRow() */
              mcDoppie.SaveRow();
            } // End If
          } // End If
        } // End If
        /* If not(Empty(_errorimsg)) */
        if ( ! (CPLib.Empty(_errorimsg))) {
          /* If At(pModo,'|R|M|Y') <> 0 */
          if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
            /* gMsgProc := gMsgProc + _errorimsg + _nriga+ NL */
            gMsgProc = gMsgProc+_errorimsg+_nriga+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* _gMsgProc := _gMsgProc + _errorimsg + _nriga + NL */
            _gMsgProc = _gMsgProc+_errorimsg+_nriga+"\n";
          } // End If
        } // End If
        /* If _erroritrx > 0 */
        if (CPLib.gt(_erroritrx,0)) {
          /* FileLibMit.WriteLine(sHand,riga+" - Riga N. "+LRTrim(Str(_tottrans,10,0))+_errorimsg) */
          FileLibMit.WriteLine(sHand,riga+" - Riga N. "+CPLib.LRTrim(CPLib.Str(_tottrans,10,0))+_errorimsg);
        } // End If
      } // End If
      /* If Len(LRTrim(riga)) > 0 and Left(riga,1) = '#' and Left(riga,6) <> '######' */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0) && CPLib.eqr(CPLib.Left(riga,1),"#") && CPLib.ne(CPLib.Left(riga,6),"######")) {
        /* _totnaid := _totnaid + Val(LRTrim(Substr(riga,8,7))) */
        _totnaid = CPLib.Round(_totnaid+CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,8,7))),0);
        /* If mcTransazioni.GoToKey(Substr(riga,2,5)) */
        if (mcTransazioni.GoToKey(CPLib.Substr(riga,2,5))) {
          /* If Val(LRTrim(Substr(riga,8,7))) <> mcTransazioni.TOTALE */
          if (CPLib.ne(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,8,7))),mcTransazioni.row.TOTALE)) {
            /* If At(pModo,'|R|M|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
              /* gMsgProc := gMsgProc + 'Errore G: Transazioni non coincidono per NAID: '+mcTransazioni.NAID + " Trovate: " + LRTrim(Str(mcTransazioni.TOTALE,10,0)) + " - Previste: "+LRTrim(Substr(riga,8,7))+ NL */
              gMsgProc = gMsgProc+"Errore G: Transazioni non coincidono per NAID: "+mcTransazioni.row.NAID+" Trovate: "+CPLib.LRTrim(CPLib.Str(mcTransazioni.row.TOTALE,10,0))+" - Previste: "+CPLib.LRTrim(CPLib.Substr(riga,8,7))+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* _gMsgProc := _gMsgProc + 'Errore G: Transazioni non coincidono per NAID: '+mcTransazioni.NAID + " Trovate: " + LRTrim(Str(mcTransazioni.TOTALE,10,0)) + " - Previste: "+LRTrim(Substr(riga,8,7)) + NL */
              _gMsgProc = _gMsgProc+"Errore G: Transazioni non coincidono per NAID: "+mcTransazioni.row.NAID+" Trovate: "+CPLib.LRTrim(CPLib.Str(mcTransazioni.row.TOTALE,10,0))+" - Previste: "+CPLib.LRTrim(CPLib.Substr(riga,8,7))+"\n";
              /* Exec Routine arrt_writelog_imp('IMPORT','','Errore G: Transazioni non coincidono per NAID: '+mcTransazioni.NAID + " Trovate: " + LRTrim(Str(mcTransazioni.TOTALE,10,0)) + " - Previste: "+LRTrim(Substr(riga,8,7))) */
              arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Errore G: Transazioni non coincidono per NAID: "+mcTransazioni.row.NAID+" Trovate: "+CPLib.LRTrim(CPLib.Str(mcTransazioni.row.TOTALE,10,0))+" - Previste: "+CPLib.LRTrim(CPLib.Substr(riga,8,7)));
            } // End If
            /* _errorig := _errorig + 1 */
            _errorig = CPLib.Round(_errorig+1,0);
          } // End If
        } else { // Else
          /* If At(pModo,'|R|M|Y') <> 0 */
          if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
            /* gMsgProc := gMsgProc + 'Errore G: Transazioni inesistenti per NAID: '+Substr(riga,2,5) + NL */
            gMsgProc = gMsgProc+"Errore G: Transazioni inesistenti per NAID: "+CPLib.Substr(riga,2,5)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* _gMsgProc := _gMsgProc + 'Errore G: Transazioni inesistenti per NAID: '+Substr(riga,2,5) + NL */
            _gMsgProc = _gMsgProc+"Errore G: Transazioni inesistenti per NAID: "+CPLib.Substr(riga,2,5)+"\n";
            /* Exec Routine arrt_writelog_imp('IMPORT','','Errore G: Transazioni inesistenti per NAID: '+Substr(riga,2,5)) */
            arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Errore G: Transazioni inesistenti per NAID: "+CPLib.Substr(riga,2,5));
          } // End If
          /* _errorig := _errorig + 1 */
          _errorig = CPLib.Round(_errorig+1,0);
        } // End If
      } // End If
      /* conta := conta + 1 */
      conta = conta+1;
    } // End While
    /* If _totale = 0 */
    if (CPLib.eqr(_totale,0)) {
      /* If At(pModo,'|R|M|Y') <> 0 */
      if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
        /* gMsgProc := gMsgProc + 'Errore G: Il file non contiene transazioni' + NL */
        gMsgProc = gMsgProc+"Errore G: Il file non contiene transazioni"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* _gMsgProc := _gMsgProc + 'Errore G: Il file non contiene transazioni' + NL */
        _gMsgProc = _gMsgProc+"Errore G: Il file non contiene transazioni"+"\n";
        /* Exec Routine arrt_writelog_imp('IMPORT','','Errore G: Il file non contiene transazioni') */
        arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Errore G: Il file non contiene transazioni");
      } // End If
      /* _errorig := _errorig + 1 */
      _errorig = CPLib.Round(_errorig+1,0);
    } // End If
    /* If _totnaid <> _totale */
    if (CPLib.ne(_totnaid,_totale)) {
      /* If At(pModo,'|R|M|Y') <> 0 */
      if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
        /* gMsgProc := gMsgProc + 'Errore G: Numero Transazioni Previste diverso da Transazioni Elaborate' + NL */
        gMsgProc = gMsgProc+"Errore G: Numero Transazioni Previste diverso da Transazioni Elaborate"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* _gMsgProc := _gMsgProc + 'Errore G: Numero Transazioni Previste diverso da Transazioni Elaborate' + NL */
        _gMsgProc = _gMsgProc+"Errore G: Numero Transazioni Previste diverso da Transazioni Elaborate"+"\n";
        /* Exec Routine arrt_writelog_imp('IMPORT','','Errore G: Numero Transazioni Previste diverso da Transazioni Elaborate') */
        arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Errore G: Numero Transazioni Previste diverso da Transazioni Elaborate");
      } // End If
      /* _errorig := _errorig + 1 */
      _errorig = CPLib.Round(_errorig+1,0);
    } // End If
    // Chiude il file e lo cancella
    FileLibMit.Close(fhand);
    FileLibMit.Close(sHand);
    /* If _errorig = 0 */
    if (CPLib.eqr(_errorig,0)) {
      // Chiude il file e lo cancella
      FileLibMit.DeleteFilePath(_pathdoc+"/export/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(_filescarti));
    } else { // Else
      // * --- Insert into tmp_listafile from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_listafile");
      m_cPhName = m_Ctx.GetPhName("tmp_listafile");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"00000560")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000560(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_filescarti),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(3,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"export/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(_filescarti),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listafile",true);
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
      // Cancella file di import
      FileLibMit.DeleteFilePath(_pathdoc+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
    } // End If
    /* If At(pModo,'|R|M|Y') <> 0 */
    if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
      /* gMsgProc := gMsgProc + 'Ora Fine Controlli Tipo G: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Controlli Tipo G: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } else { // Else
      /* _gMsgProc := _gMsgProc + 'Ora Fine Controlli Tipo G: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      _gMsgProc = _gMsgProc+"Ora Fine Controlli Tipo G: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Fine Controlli Tipo G: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport) */
      arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Fine Controlli Tipo G: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport);
    } // End If
  }
  void Page_12() throws Exception {
    /* _contage := 0 */
    _contage = CPLib.Round(0,0);
    for (MemoryCursorRow_mcerratedef_mcrdef rowErrate : mcAgeDuo._iterable_()) {
      /* If LRTrim(rowErrate.colonna02)=LRTrim(_colonna2) */
      if (CPLib.eqr(CPLib.LRTrim(rowErrate.colonna02),CPLib.LRTrim(_colonna2))) {
        /* _contage := _contage + 1 */
        _contage = CPLib.Round(_contage+1,0);
      } // End If
    }
    /* If _contage > 1 */
    if (CPLib.gt(_contage,1)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr01 := 'Duplicazione Agenzia' */
      _ageerr01 = "Duplicazione Agenzia";
    } // End If
    /* If Empty(_colonna1) */
    if (CPLib.Empty(_colonna1)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr02 := 'Agenzia non associata ad un macroagente' */
      _ageerr02 = "Agenzia non associata ad un macroagente";
    } // End If
    /* If not(Empty(_colonna1)) */
    if ( ! (CPLib.Empty(_colonna1))) {
      /* w_codmage := '' */
      w_codmage = "";
      /* If mcMacAge.GoToKey(_colonna1) */
      if (mcMacAge.GoToKey(_colonna1)) {
        /* w_codmage := mcMacAge.MACODICE */
        w_codmage = mcMacAge.row.MACODICE;
      } // End If
      /* If Empty(w_codmage) */
      if (CPLib.Empty(w_codmage)) {
        /* _errage := _errage + 1 */
        _errage = CPLib.Round(_errage+1,0);
        /* _ageerr03 := 'Agenzia associata ad un macroagente non esistente' */
        _ageerr03 = "Agenzia associata ad un macroagente non esistente";
      } // End If
    } // End If
    /* If Empty(LRTrim(_colonna5)) */
    if (CPLib.Empty(CPLib.LRTrim(_colonna5))) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr04 := "Manca la località della sede dell'agenzia" */
      _ageerr04 = "Manca la località della sede dell'agenzia";
    } // End If
    /* If Empty(_idbase) and not(Empty(LRTrim(_colonna5))) */
    if (CPLib.Empty(_idbase) &&  ! (CPLib.Empty(CPLib.LRTrim(_colonna5)))) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr05 := 'Località non congruente con tabelle AUI' */
      _ageerr05 = "Località non congruente con tabelle AUI";
    } // End If
    /* If Empty(_colonna3) */
    if (CPLib.Empty(_colonna3)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr06 := "Manca la ragione sociale dell'agenzia" */
      _ageerr06 = "Manca la ragione sociale dell'agenzia";
    } // End If
    /* If Empty(_colonna4) */
    if (CPLib.Empty(_colonna4)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr07 := "Manca l'indirizzo dell'agenzia" */
      _ageerr07 = "Manca l'indirizzo dell'agenzia";
    } // End If
    /* If Empty(_colonna2) */
    if (CPLib.Empty(_colonna2)) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr08 := 'Agenzia priva di account' */
      _ageerr08 = "Agenzia priva di account";
    } // End If
    /* If not(Empty(_colonna2)) and Left(Upper(LRTrim(_colonna2)),3) <> 'AJW'  and Left(Upper(LRTrim(_colonna2)),3) <> 'AS6' */
    if ( ! (CPLib.Empty(_colonna2)) && CPLib.ne(CPLib.Left(CPLib.Upper(CPLib.LRTrim(_colonna2)),3),"AJW") && CPLib.ne(CPLib.Left(CPLib.Upper(CPLib.LRTrim(_colonna2)),3),"AS6")) {
      /* _errage := _errage + 1 */
      _errage = CPLib.Round(_errage+1,0);
      /* _ageerr09 := 'Account Agenzia non scritto correttamente' */
      _ageerr09 = "Account Agenzia non scritto correttamente";
    } // End If
  }
  void Page_13() throws Exception {
    /* _connesdoc := '' */
    _connesdoc = "";
  }
  void Page_14() throws Exception {
    CPResultSet Cursor_qbe_rtra_aua_1c=null;
    CPResultSet Cursor_qbe_rtra_aua_2c=null;
    CPResultSet Cursor_qbe_rtra_aua_3c=null;
    CPResultSet Cursor_qbe_rtra_aua_4c=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _auisex Char(1) */
      String _auisex;
      _auisex = CPLib.Space(1);
      /* _errmul Numeric(3, 0) */
      double _errmul;
      _errmul = 0;
      /* mcAUA1 MemoryCursor(qbe_rtra_aua_1.vqr) */
      MemoryCursor_qbe_rtra_aua_1_vqr mcAUA1;
      mcAUA1 = new MemoryCursor_qbe_rtra_aua_1_vqr();
      /* mcAUA2 MemoryCursor(qbe_rtra_aua_2.vqr) */
      MemoryCursor_qbe_rtra_aua_2_vqr mcAUA2;
      mcAUA2 = new MemoryCursor_qbe_rtra_aua_2_vqr();
      /* mcAUA3 MemoryCursor(qbe_rtra_aua_3.vqr) */
      MemoryCursor_qbe_rtra_aua_3_vqr mcAUA3;
      mcAUA3 = new MemoryCursor_qbe_rtra_aua_3_vqr();
      /* mcAUA4 MemoryCursor(qbe_rtra_aua_4.vqr) */
      MemoryCursor_qbe_rtra_aua_4_vqr mcAUA4;
      mcAUA4 = new MemoryCursor_qbe_rtra_aua_4_vqr();
      /* rowAUA1 Row(qbe_rtra_aua_1.vqr) */
      /* rowAUA2 Row(qbe_rtra_aua_2.vqr) */
      /* rowAUA3 Row(qbe_rtra_aua_3.vqr) */
      /* rowAUA4 Row(qbe_rtra_aua_4.vqr) */
      /* mcCases.Zap() */
      mcCases.Zap();
      /* mcAUA1.Zap() */
      mcAUA1.Zap();
      /* mcAUA2.Zap() */
      mcAUA2.Zap();
      /* mcAUA3.Zap() */
      mcAUA3.Zap();
      /* mcAUA4.Zap() */
      mcAUA4.Zap();
      /* _faua1 := '' */
      _faua1 = "";
      /* _faua2 := '' */
      _faua2 = "";
      /* _faua3 := '' */
      _faua3 = "";
      /* _faua4 := '' */
      _faua4 = "";
      /* _auisex := iif(_sesso='M','1',iif(_sesso='F','2','')) */
      _auisex = (CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":""));
      /* _erraua := 0 */
      _erraua = CPLib.Round(0,0);
      /* _errmul := 0 */
      _errmul = CPLib.Round(0,0);
      /* mcAUA1.Zap() */
      mcAUA1.Zap();
      // * --- Fill memory cursor mcAUA1 on qbe_rtra_aua_1c
      mcAUA1.Zap();
      SPBridge.HMCaller _h000005A7;
      _h000005A7 = new SPBridge.HMCaller();
      _h000005A7.Set("m_cVQRList",m_cVQRList);
      _h000005A7.Set("pTIPODOC",_doctype);
      _h000005A7.Set("pNUMDOCUM",_numdoc);
      _h000005A7.Set("pDATAOPE",_datope);
      if (Cursor_qbe_rtra_aua_1c!=null)
        Cursor_qbe_rtra_aua_1c.Close();
      Cursor_qbe_rtra_aua_1c = new VQRHolder("qbe_rtra_aua_1c",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000005A7,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_1c;
        Cursor_qbe_rtra_aua_1c.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on qbe_rtra_aua_1c returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_rtra_aua_1c.Eof())) {
        mcAUA1.AppendBlank();
        mcAUA1.row.COGNOME = Cursor_qbe_rtra_aua_1c.GetString("COGNOME");
        mcAUA1.row.NOME = Cursor_qbe_rtra_aua_1c.GetString("NOME");
        mcAUA1.row.NASSTATO = Cursor_qbe_rtra_aua_1c.GetString("NASSTATO");
        mcAUA1.row.NASCOMUN = Cursor_qbe_rtra_aua_1c.GetString("NASCOMUN");
        mcAUA1.row.DATANASC = Cursor_qbe_rtra_aua_1c.GetDate("DATANASC");
        mcAUA1.row.SESSO = Cursor_qbe_rtra_aua_1c.GetString("SESSO");
        mcAUA1.row.RAGSOC = Cursor_qbe_rtra_aua_1c.GetString("RAGSOC");
        mcAUA1.row.LUOGONAS = Cursor_qbe_rtra_aua_1c.GetString("LUOGONAS");
        Cursor_qbe_rtra_aua_1c.Next();
      }
      m_cConnectivityError = Cursor_qbe_rtra_aua_1c.ErrorMessage();
      Cursor_qbe_rtra_aua_1c.Close();
      mcAUA1.GoTop();
      /* If mcAUA1.RecCount() > 0 */
      if (CPLib.gt(mcAUA1.RecCount(),0)) {
        for (MemoryCursorRow_qbe_rtra_aua_1_vqr rowAUA1 : mcAUA1._iterable_()) {
          /* If arfn_agechar(Upper(Strtran(LRTrim(rowAUA1.RAGSOC),' ','')),"")+LRTrim(DateToChar(rowAUA1.DATANASC))+Upper(LRTrim(rowAUA1.SESSO))+arfn_agechar(Upper(LRTrim(Left(rowAUA1.LUOGONAS,30))),"")<>arfn_agechar(Upper(Strtran(LRTrim(_cognome),' ','')+Strtran(LRTrim(_nome),' ','')),"")+LRTrim(DateToChar(_nasdata))+Upper(LRTrim(_auisex))+arfn_agechar(Upper(LRTrim(Left(_luonas,30))),"") */
          if (CPLib.ne(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(rowAUA1.RAGSOC)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(rowAUA1.DATANASC))+CPLib.Upper(CPLib.LRTrim(rowAUA1.SESSO))+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.LRTrim(CPLib.Left(rowAUA1.LUOGONAS,30))),""),arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(_cognome)," ","")+CPLib.Strtran(CPLib.LRTrim(_nome)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(_nasdata))+CPLib.Upper(CPLib.LRTrim(_auisex))+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.LRTrim(CPLib.Left(_luonas,30))),""))) {
            /* _errmul := _errmul + 1 */
            _errmul = CPLib.Round(_errmul+1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        }
        /* If _errmul > 0 */
        if (CPLib.gt(_errmul,0)) {
          /* _erraua := _erraua + 1 */
          _erraua = CPLib.Round(_erraua+1,0);
          /* _faua1 := 'X' */
          _faua1 = "X";
          /* _aua01 := 'S' */
          _aua01 = "S";
          /* mcCases.AppendBlank() */
          mcCases.AppendBlank();
          /* mcCases.TRXCODCASE := 1 */
          mcCases.row.TRXCODCASE = 1;
          /* mcCases.TRXNQUERY := '1' */
          mcCases.row.TRXNQUERY = "1";
          /* mcCases.SaveRow() */
          mcCases.SaveRow();
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
      /* _errmul := 0 */
      _errmul = CPLib.Round(0,0);
      /* mcAUA2.Zap() */
      mcAUA2.Zap();
      // * --- Fill memory cursor mcAUA2 on qbe_rtra_aua_2c
      mcAUA2.Zap();
      SPBridge.HMCaller _h000005B9;
      _h000005B9 = new SPBridge.HMCaller();
      _h000005B9.Set("m_cVQRList",m_cVQRList);
      _h000005B9.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(_cognome)," ","")+CPLib.Strtran(CPLib.LRTrim(_nome)," ",""));
      _h000005B9.Set("pDATANASC",_nasdata);
      _h000005B9.Set("pSESSO",_auisex);
      _h000005B9.Set("pTIPODOC",_doctype);
      _h000005B9.Set("pDATAOPE",_datope);
      _h000005B9.Set("pLUOGONAS",_luonas);
      if (Cursor_qbe_rtra_aua_2c!=null)
        Cursor_qbe_rtra_aua_2c.Close();
      Cursor_qbe_rtra_aua_2c = new VQRHolder("qbe_rtra_aua_2c",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000005B9,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_2c;
        Cursor_qbe_rtra_aua_2c.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on qbe_rtra_aua_2c returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_rtra_aua_2c.Eof())) {
        mcAUA2.AppendBlank();
        mcAUA2.row.TIPODOC = Cursor_qbe_rtra_aua_2c.GetString("TIPODOC");
        mcAUA2.row.NUMDOCUM = Cursor_qbe_rtra_aua_2c.GetString("NUMDOCUM");
        mcAUA2.row.DATARILASC = Cursor_qbe_rtra_aua_2c.GetDate("DATARILASC");
        Cursor_qbe_rtra_aua_2c.Next();
      }
      m_cConnectivityError = Cursor_qbe_rtra_aua_2c.ErrorMessage();
      Cursor_qbe_rtra_aua_2c.Close();
      mcAUA2.GoTop();
      /* If mcAUA2.RecCount() > 0 */
      if (CPLib.gt(mcAUA2.RecCount(),0)) {
        for (MemoryCursorRow_qbe_rtra_aua_2_vqr rowAUA2 : mcAUA2._iterable_()) {
          /* If rowAUA2.TIPODOC <> '01' */
          if (CPLib.ne(rowAUA2.TIPODOC,"01")) {
            /* If Upper(LRTrim(Strtran(rowAUA2.NUMDOCUM,' ',''))) <> Upper(LRTrim(Strtran(_numdoc,' ',''))) and rowAUA2.DATARILASC >= _docril */
            if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(CPLib.Strtran(rowAUA2.NUMDOCUM," ",""))),CPLib.Upper(CPLib.LRTrim(CPLib.Strtran(_numdoc," ","")))) && CPLib.ge(rowAUA2.DATARILASC,_docril)) {
              /* _errmul := _errmul + 1 */
              _errmul = CPLib.Round(_errmul+1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          } // End If
        }
        /* If _errmul > 0 */
        if (CPLib.gt(_errmul,0)) {
          /* _erraua := _erraua + 1 */
          _erraua = CPLib.Round(_erraua+1,0);
          /* _faua2 := 'X' */
          _faua2 = "X";
          /* mcCases.AppendBlank() */
          mcCases.AppendBlank();
          /* mcCases.TRXCODCASE := 2 */
          mcCases.row.TRXCODCASE = 2;
          /* mcCases.TRXNQUERY := '2' */
          mcCases.row.TRXNQUERY = "2";
          /* mcCases.SaveRow() */
          mcCases.SaveRow();
          /* _aua03 := 'Presenza di documenti dello stesso tipo rilasciati in data successiva' */
          _aua03 = "Presenza di documenti dello stesso tipo rilasciati in data successiva";
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
      /* mcAUA2.Zap() */
      mcAUA2.Zap();
      /* _errmul := 0 */
      _errmul = CPLib.Round(0,0);
      // * --- Fill memory cursor mcAUA2 on qbe_rtra_aua_2c
      mcAUA2.Zap();
      SPBridge.HMCaller _h000005CB;
      _h000005CB = new SPBridge.HMCaller();
      _h000005CB.Set("m_cVQRList",m_cVQRList);
      _h000005CB.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(_cognome)," ","")+CPLib.Strtran(CPLib.LRTrim(_nome)," ",""));
      _h000005CB.Set("pDATANASC",_nasdata);
      _h000005CB.Set("pSESSO",_auisex);
      _h000005CB.Set("pNUMDOCUM",_numdoc);
      _h000005CB.Set("pDATAOPE",_datope);
      _h000005CB.Set("pLUOGONAS",_luonas);
      if (Cursor_qbe_rtra_aua_2c!=null)
        Cursor_qbe_rtra_aua_2c.Close();
      Cursor_qbe_rtra_aua_2c = new VQRHolder("qbe_rtra_aua_2c",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000005CB,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_2c;
        Cursor_qbe_rtra_aua_2c.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on qbe_rtra_aua_2c returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_rtra_aua_2c.Eof())) {
        mcAUA2.AppendBlank();
        mcAUA2.row.TIPODOC = Cursor_qbe_rtra_aua_2c.GetString("TIPODOC");
        mcAUA2.row.NUMDOCUM = Cursor_qbe_rtra_aua_2c.GetString("NUMDOCUM");
        mcAUA2.row.DATARILASC = Cursor_qbe_rtra_aua_2c.GetDate("DATARILASC");
        Cursor_qbe_rtra_aua_2c.Next();
      }
      m_cConnectivityError = Cursor_qbe_rtra_aua_2c.ErrorMessage();
      Cursor_qbe_rtra_aua_2c.Close();
      mcAUA2.GoTop();
      /* If mcAUA2.RecCount() > 0 */
      if (CPLib.gt(mcAUA2.RecCount(),0)) {
        for (MemoryCursorRow_qbe_rtra_aua_2_vqr rowAUA2 : mcAUA2._iterable_()) {
          /* If rowAUA2.TIPODOC <> _doctype and Upper(LRTrim(rowAUA2.NUMDOCUM))=Upper(LRTrim(_numdoc)) */
          if (CPLib.ne(rowAUA2.TIPODOC,_doctype) && CPLib.eqr(CPLib.Upper(CPLib.LRTrim(rowAUA2.NUMDOCUM)),CPLib.Upper(CPLib.LRTrim(_numdoc)))) {
            /* _errmul := _errmul + 1 */
            _errmul = CPLib.Round(_errmul+1,0);
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        }
        /* If _errmul > 0 */
        if (CPLib.gt(_errmul,0)) {
          /* _erraua := _erraua + 1 */
          _erraua = CPLib.Round(_erraua+1,0);
          /* _faua2 := 'X' */
          _faua2 = "X";
          /* _aua04 := 'Presenza di documenti con lo stesso numero ma di tipo diverso' */
          _aua04 = "Presenza di documenti con lo stesso numero ma di tipo diverso";
          /* mcCases.AppendBlank() */
          mcCases.AppendBlank();
          /* mcCases.TRXCODCASE := 3 */
          mcCases.row.TRXCODCASE = 3;
          /* mcCases.TRXNQUERY := '6' */
          mcCases.row.TRXNQUERY = "6";
          /* mcCases.SaveRow() */
          mcCases.SaveRow();
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
      /* _errmul := 0 */
      _errmul = CPLib.Round(0,0);
      /* mcAUA3.Zap() */
      mcAUA3.Zap();
      // * --- Fill memory cursor mcAUA3 on qbe_rtra_aua_3c
      mcAUA3.Zap();
      SPBridge.HMCaller _h000005DD;
      _h000005DD = new SPBridge.HMCaller();
      _h000005DD.Set("m_cVQRList",m_cVQRList);
      _h000005DD.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(_cognome)," ","")+CPLib.Strtran(CPLib.LRTrim(_nome)," ",""));
      _h000005DD.Set("pDATANASC",_nasdata);
      _h000005DD.Set("pSESSO",_auisex);
      _h000005DD.Set("pLUOGONAS",_luonas);
      if (Cursor_qbe_rtra_aua_3c!=null)
        Cursor_qbe_rtra_aua_3c.Close();
      Cursor_qbe_rtra_aua_3c = new VQRHolder("qbe_rtra_aua_3c",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000005DD,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_3c;
        Cursor_qbe_rtra_aua_3c.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_rtra: query on qbe_rtra_aua_3c returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_rtra_aua_3c.Eof())) {
        mcAUA3.AppendBlank();
        mcAUA3.row.CODFISC = Cursor_qbe_rtra_aua_3c.GetString("CODFISC");
        Cursor_qbe_rtra_aua_3c.Next();
      }
      m_cConnectivityError = Cursor_qbe_rtra_aua_3c.ErrorMessage();
      Cursor_qbe_rtra_aua_3c.Close();
      mcAUA3.GoTop();
      /* If mcAUA3.RecCount() > 0 */
      if (CPLib.gt(mcAUA3.RecCount(),0)) {
        for (MemoryCursorRow_qbe_rtra_aua_3_vqr rowAUA3 : mcAUA3._iterable_()) {
          /* If _nocf=0 */
          if (CPLib.eqr(_nocf,0)) {
            /* If Upper(rowAUA3.CODFISC) <> Upper(_codfis) and not(Empty(rowAUA3.CODFISC)) */
            if (CPLib.ne(CPLib.Upper(rowAUA3.CODFISC),CPLib.Upper(_codfis)) &&  ! (CPLib.Empty(rowAUA3.CODFISC))) {
              /* _errmul := _errmul + 1 */
              _errmul = CPLib.Round(_errmul+1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          } else { // Else
            /* If not(Empty(rowAUA3.CODFISC)) */
            if ( ! (CPLib.Empty(rowAUA3.CODFISC))) {
              /* _errmul := _errmul + 1 */
              _errmul = CPLib.Round(_errmul+1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          } // End If
        }
        /* If _errmul > 0 */
        if (CPLib.gt(_errmul,0)) {
          /* _erraua := _erraua + 1 */
          _erraua = CPLib.Round(_erraua+1,0);
          /* _faua3 := 'X' */
          _faua3 = "X";
          /* _aua07 := 'Esistono Soggetti con stesso Customer ID e diverso Codice Fiscale' */
          _aua07 = "Esistono Soggetti con stesso Customer ID e diverso Codice Fiscale";
          /* mcCases.AppendBlank() */
          mcCases.AppendBlank();
          /* mcCases.TRXCODCASE := 4 */
          mcCases.row.TRXCODCASE = 4;
          /* mcCases.TRXNQUERY := '3' */
          mcCases.row.TRXNQUERY = "3";
          /* mcCases.SaveRow() */
          mcCases.SaveRow();
          /* _esito := 1 */
          _esito = CPLib.Round(1,0);
        } // End If
      } // End If
      /* If _nocf=0 */
      if (CPLib.eqr(_nocf,0)) {
        /* _errmul := 0 */
        _errmul = CPLib.Round(0,0);
        /* mcAUA4.Zap() */
        mcAUA4.Zap();
        // * --- Fill memory cursor mcAUA4 on qbe_rtra_aua_4c
        mcAUA4.Zap();
        SPBridge.HMCaller _h000005F4;
        _h000005F4 = new SPBridge.HMCaller();
        _h000005F4.Set("m_cVQRList",m_cVQRList);
        _h000005F4.Set("pCODFISC",_codfis);
        if (Cursor_qbe_rtra_aua_4c!=null)
          Cursor_qbe_rtra_aua_4c.Close();
        Cursor_qbe_rtra_aua_4c = new VQRHolder("qbe_rtra_aua_4c",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000005F4,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_4c;
          Cursor_qbe_rtra_aua_4c.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_imp_dati_rtra: query on qbe_rtra_aua_4c returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rtra_aua_4c.Eof())) {
          mcAUA4.AppendBlank();
          mcAUA4.row.COGNOME = Cursor_qbe_rtra_aua_4c.GetString("COGNOME");
          mcAUA4.row.NOME = Cursor_qbe_rtra_aua_4c.GetString("NOME");
          mcAUA4.row.NASSTATO = Cursor_qbe_rtra_aua_4c.GetString("NASSTATO");
          mcAUA4.row.NASCOMUN = Cursor_qbe_rtra_aua_4c.GetString("NASCOMUN");
          mcAUA4.row.DATANASC = Cursor_qbe_rtra_aua_4c.GetDate("DATANASC");
          mcAUA4.row.SESSO = Cursor_qbe_rtra_aua_4c.GetString("SESSO");
          mcAUA4.row.RAGSOC = Cursor_qbe_rtra_aua_4c.GetString("RAGSOC");
          mcAUA4.row.LUOGONAS = Cursor_qbe_rtra_aua_4c.GetString("LUOGONAS");
          Cursor_qbe_rtra_aua_4c.Next();
        }
        m_cConnectivityError = Cursor_qbe_rtra_aua_4c.ErrorMessage();
        Cursor_qbe_rtra_aua_4c.Close();
        mcAUA4.GoTop();
        /* If mcAUA4.RecCount() > 0 */
        if (CPLib.gt(mcAUA4.RecCount(),0)) {
          for (MemoryCursorRow_qbe_rtra_aua_4_vqr rowAUA4 : mcAUA4._iterable_()) {
            /* If arfn_agechar(Upper(Strtran(LRTrim(rowAUA4.RAGSOC),' ','')),"")+LRTrim(DateToChar(rowAUA4.DATANASC))+Upper(LRTrim(rowAUA4.SESSO))+arfn_agechar(Upper(LRTrim(Left(rowAUA4.LUOGONAS,30))),"")<>arfn_agechar(Upper(Strtran(LRTrim(_cognome),' ','')+Strtran(LRTrim(_nome),' ','')),"")+LRTrim(DateToChar(_nasdata))+Upper(LRTrim(_auisex))+arfn_agechar(Upper(LRTrim(Left(_luonas,30))),"") */
            if (CPLib.ne(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(rowAUA4.RAGSOC)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(rowAUA4.DATANASC))+CPLib.Upper(CPLib.LRTrim(rowAUA4.SESSO))+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.LRTrim(CPLib.Left(rowAUA4.LUOGONAS,30))),""),arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(_cognome)," ","")+CPLib.Strtran(CPLib.LRTrim(_nome)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(_nasdata))+CPLib.Upper(CPLib.LRTrim(_auisex))+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.LRTrim(CPLib.Left(_luonas,30))),""))) {
              /* _errmul := _errmul + 1 */
              _errmul = CPLib.Round(_errmul+1,0);
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          }
          /* If _errmul > 0 */
          if (CPLib.gt(_errmul,0)) {
            /* _erraua := _erraua + 1 */
            _erraua = CPLib.Round(_erraua+1,0);
            /* _faua4 := 'X' */
            _faua4 = "X";
            /* _aua09 := 'Customer ID del soggetto non coincide con quello del codice fiscale presentato' */
            _aua09 = "Customer ID del soggetto non coincide con quello del codice fiscale presentato";
            /* mcCases.AppendBlank() */
            mcCases.AppendBlank();
            /* mcCases.TRXCODCASE := 5 */
            mcCases.row.TRXCODCASE = 5;
            /* mcCases.TRXNQUERY := '4' */
            mcCases.row.TRXNQUERY = "4";
            /* mcCases.SaveRow() */
            mcCases.SaveRow();
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
          } // End If
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_qbe_rtra_aua_1c!=null)
          Cursor_qbe_rtra_aua_1c.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_2c!=null)
          Cursor_qbe_rtra_aua_2c.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_3c!=null)
          Cursor_qbe_rtra_aua_3c.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_4c!=null)
          Cursor_qbe_rtra_aua_4c.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_15() throws Exception {
    /* ExcelFileToRead Object(InputStream) */
    InputStream ExcelFileToRead;
    ExcelFileToRead = null;
    double nTry00000605status;
    nTry00000605status = m_Sql.GetTransactionStatus();
    String cTry00000605msg;
    cTry00000605msg = m_Sql.TransactionErrorMessage();
    try {
      /* If At(pModo,'|R|M|Y') <> 0 */
      if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* Exec Routine arrt_writelog_imp('IMPORT','','Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport) */
        arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport);
        /* _gMsgProc := _gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
        _gMsgProc = _gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      } // End If
      /* mcNuove.Zap() // Nuove transazioni */
      mcNuove.Zap();
      /* mcModDel.Zap() // Modifiche o Cancellazioni */
      mcModDel.Zap();
      /* _scarti := 0 */
      _scarti = CPLib.Round(0,0);
      /* If At(".TXT",Upper(nomefileimport)) > 0 */
      if (CPLib.gt(CPLib.At(".TXT",CPLib.Upper(nomefileimport)),0)) {
        /* fhand := FileLibMit.OpenReadPath(_pathdoc+"/appo/"+LRTrim(_azienda)+"/"+LRTrim(nomefileimport)) */
        fhand = FileLibMit.OpenReadPath(_pathdoc+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* riga := FileLibMit.ReadLine(fhand) */
          riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(riga)) > 0 and Left(riga,1) <> '#' */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0) && CPLib.ne(CPLib.Left(riga,1),"#")) {
            /* If mcMacAge.GoToKey(Substr(riga,850,5)) */
            if (mcMacAge.GoToKey(CPLib.Substr(riga,850,5))) {
              /* If Substr(riga,849,1)='I' */
              if (CPLib.eqr(CPLib.Substr(riga,849,1),"I")) {
                /* mcNuove.AppendBlank() */
                mcNuove.AppendBlank();
                /* mcNuove.colonna01 := LRTrim(Left(riga,50)) */
                mcNuove.row.colonna01 = CPLib.LRTrim(CPLib.Left(riga,50));
                /* mcNuove.colonna02 := LRTrim(Substr(riga,51,50)) */
                mcNuove.row.colonna02 = CPLib.LRTrim(CPLib.Substr(riga,51,50));
                /* mcNuove.colonna03 := Substr(riga,101,100) */
                mcNuove.row.colonna03 = CPLib.Substr(riga,101,100);
                /* mcNuove.colonna04 := Substr(riga,201,1) */
                mcNuove.row.colonna04 = CPLib.Substr(riga,201,1);
                /* mcNuove.colonna05 := Substr(riga,202,16) */
                mcNuove.row.colonna05 = CPLib.Substr(riga,202,16);
                /* mcNuove.colonna06 := Substr(riga,218,50) */
                mcNuove.row.colonna06 = CPLib.Substr(riga,218,50);
                /* mcNuove.colonna07 := Substr(riga,268,30) */
                mcNuove.row.colonna07 = CPLib.Substr(riga,268,30);
                /* mcNuove.colonna08 := Substr(riga,298,8) */
                mcNuove.row.colonna08 = CPLib.Substr(riga,298,8);
                /* mcNuove.colonna09 := Substr(riga,306,8) */
                mcNuove.row.colonna09 = CPLib.Substr(riga,306,8);
                /* mcNuove.colonna10 := Substr(riga,314,50) */
                mcNuove.row.colonna10 = CPLib.Substr(riga,314,50);
                /* mcNuove.colonna11 := Substr(riga,364,50) */
                mcNuove.row.colonna11 = CPLib.Substr(riga,364,50);
                /* mcNuove.colonna12 := Substr(riga,414,50) */
                mcNuove.row.colonna12 = CPLib.Substr(riga,414,50);
                /* mcNuove.colonna13 := Substr(riga,464,2) */
                mcNuove.row.colonna13 = CPLib.Substr(riga,464,2);
                /* mcNuove.colonna14 := Substr(riga,466,8) */
                mcNuove.row.colonna14 = CPLib.Substr(riga,466,8);
                /* mcNuove.colonna15 := Substr(riga,474,1) */
                mcNuove.row.colonna15 = CPLib.Substr(riga,474,1);
                /* mcNuove.colonna16 := Substr(riga,475,1) */
                mcNuove.row.colonna16 = CPLib.Substr(riga,475,1);
                /* mcNuove.colonna17 := Substr(riga,476,15) */
                mcNuove.row.colonna17 = CPLib.Substr(riga,476,15);
                /* mcNuove.colonna18 := Substr(riga,491,15) */
                mcNuove.row.colonna18 = CPLib.Substr(riga,491,15);
                /* mcNuove.colonna19 := Substr(riga,506,10) */
                mcNuove.row.colonna19 = CPLib.Substr(riga,506,10);
                /* mcNuove.colonna20 := Substr(riga,516,10) */
                mcNuove.row.colonna20 = CPLib.Substr(riga,516,10);
                /* mcNuove.colonna21 := Substr(riga,526,100) */
                mcNuove.row.colonna21 = CPLib.Substr(riga,526,100);
                /* mcNuove.colonna22 := Substr(riga,626,100) */
                mcNuove.row.colonna22 = CPLib.Substr(riga,626,100);
                /* mcNuove.colonna23 := Substr(riga,726,100) */
                mcNuove.row.colonna23 = CPLib.Substr(riga,726,100);
                /* mcNuove.colonna24 := Substr(riga,826,10) */
                mcNuove.row.colonna24 = CPLib.Substr(riga,826,10);
                /* mcNuove.colonna25 := Substr(riga,836,8) */
                mcNuove.row.colonna25 = CPLib.Substr(riga,836,8);
                /* mcNuove.colonna26 := Substr(riga,844,1) */
                mcNuove.row.colonna26 = CPLib.Substr(riga,844,1);
                /* mcNuove.colonna27 := Substr(riga,845,4) */
                mcNuove.row.colonna27 = CPLib.Substr(riga,845,4);
                /* mcNuove.colonna28 := Substr(riga,849,1) */
                mcNuove.row.colonna28 = CPLib.Substr(riga,849,1);
                /* mcNuove.colonna29 := Substr(riga,850,5) */
                mcNuove.row.colonna29 = CPLib.Substr(riga,850,5);
                /* mcNuove.colonna30 := Substr(riga,826,10) */
                mcNuove.row.colonna30 = CPLib.Substr(riga,826,10);
                /* mcNuove.colonna31 := Substr(riga,873,20) */
                mcNuove.row.colonna31 = CPLib.Substr(riga,873,20);
                /* mcNuove.colonna32 := Substr(riga,893,20) */
                mcNuove.row.colonna32 = CPLib.Substr(riga,893,20);
                /* mcNuove.colonna75 := 'S' */
                mcNuove.row.colonna75 = "S";
                /* mcNuove.colonna76 := 'N' */
                mcNuove.row.colonna76 = "N";
                /* mcNuove.colonna77 := 'O' */
                mcNuove.row.colonna77 = "O";
                /* mcNuove.SaveRow() */
                mcNuove.SaveRow();
              } else { // Else
                /* mcModDel.AppendBlank() */
                mcModDel.AppendBlank();
                /* mcModDel.colonna01 := LRTrim(Left(riga,50)) */
                mcModDel.row.colonna01 = CPLib.LRTrim(CPLib.Left(riga,50));
                /* mcModDel.colonna02 := LRTrim(Substr(riga,51,50)) */
                mcModDel.row.colonna02 = CPLib.LRTrim(CPLib.Substr(riga,51,50));
                /* mcModDel.colonna03 := Substr(riga,101,100) */
                mcModDel.row.colonna03 = CPLib.Substr(riga,101,100);
                /* mcModDel.colonna04 := Substr(riga,201,1) */
                mcModDel.row.colonna04 = CPLib.Substr(riga,201,1);
                /* mcModDel.colonna05 := Substr(riga,202,16) */
                mcModDel.row.colonna05 = CPLib.Substr(riga,202,16);
                /* mcModDel.colonna06 := Substr(riga,218,50) */
                mcModDel.row.colonna06 = CPLib.Substr(riga,218,50);
                /* mcModDel.colonna07 := Substr(riga,268,30) */
                mcModDel.row.colonna07 = CPLib.Substr(riga,268,30);
                /* mcModDel.colonna08 := Substr(riga,298,8) */
                mcModDel.row.colonna08 = CPLib.Substr(riga,298,8);
                /* mcModDel.colonna09 := Substr(riga,306,8) */
                mcModDel.row.colonna09 = CPLib.Substr(riga,306,8);
                /* mcModDel.colonna10 := Substr(riga,314,50) */
                mcModDel.row.colonna10 = CPLib.Substr(riga,314,50);
                /* mcModDel.colonna11 := Substr(riga,364,50) */
                mcModDel.row.colonna11 = CPLib.Substr(riga,364,50);
                /* mcModDel.colonna12 := Substr(riga,414,50) */
                mcModDel.row.colonna12 = CPLib.Substr(riga,414,50);
                /* mcModDel.colonna13 := Substr(riga,464,2) */
                mcModDel.row.colonna13 = CPLib.Substr(riga,464,2);
                /* mcModDel.colonna14 := Substr(riga,466,8) */
                mcModDel.row.colonna14 = CPLib.Substr(riga,466,8);
                /* mcModDel.colonna15 := Substr(riga,474,1) */
                mcModDel.row.colonna15 = CPLib.Substr(riga,474,1);
                /* mcModDel.colonna16 := Substr(riga,475,1) */
                mcModDel.row.colonna16 = CPLib.Substr(riga,475,1);
                /* mcModDel.colonna17 := Substr(riga,476,15) */
                mcModDel.row.colonna17 = CPLib.Substr(riga,476,15);
                /* mcModDel.colonna18 := Substr(riga,491,15) */
                mcModDel.row.colonna18 = CPLib.Substr(riga,491,15);
                /* mcModDel.colonna19 := Substr(riga,506,10) */
                mcModDel.row.colonna19 = CPLib.Substr(riga,506,10);
                /* mcModDel.colonna20 := Substr(riga,516,10) */
                mcModDel.row.colonna20 = CPLib.Substr(riga,516,10);
                /* mcModDel.colonna21 := Substr(riga,526,100) */
                mcModDel.row.colonna21 = CPLib.Substr(riga,526,100);
                /* mcModDel.colonna22 := Substr(riga,626,100) */
                mcModDel.row.colonna22 = CPLib.Substr(riga,626,100);
                /* mcModDel.colonna23 := Substr(riga,726,100) */
                mcModDel.row.colonna23 = CPLib.Substr(riga,726,100);
                /* mcModDel.colonna24 := Substr(riga,826,10) */
                mcModDel.row.colonna24 = CPLib.Substr(riga,826,10);
                /* mcModDel.colonna25 := Substr(riga,836,8) */
                mcModDel.row.colonna25 = CPLib.Substr(riga,836,8);
                /* mcModDel.colonna26 := Substr(riga,844,1) */
                mcModDel.row.colonna26 = CPLib.Substr(riga,844,1);
                /* mcModDel.colonna27 := Substr(riga,845,4) */
                mcModDel.row.colonna27 = CPLib.Substr(riga,845,4);
                /* mcModDel.colonna28 := Substr(riga,849,1) */
                mcModDel.row.colonna28 = CPLib.Substr(riga,849,1);
                /* mcModDel.colonna29 := Substr(riga,850,5) */
                mcModDel.row.colonna29 = CPLib.Substr(riga,850,5);
                /* mcModDel.colonna30 := Substr(riga,826,10) */
                mcModDel.row.colonna30 = CPLib.Substr(riga,826,10);
                /* mcNuove.colonna31 := Substr(riga,873,20) */
                mcNuove.row.colonna31 = CPLib.Substr(riga,873,20);
                /* mcNuove.colonna32 := Substr(riga,893,20) */
                mcNuove.row.colonna32 = CPLib.Substr(riga,893,20);
                /* mcModDel.colonna75 := 'S' */
                mcModDel.row.colonna75 = "S";
                /* mcModDel.colonna76 := 'N' */
                mcModDel.row.colonna76 = "N";
                /* mcModDel.colonna77 := 'O' */
                mcModDel.row.colonna77 = "O";
                /* mcModDel.SaveRow() */
                mcModDel.SaveRow();
              } // End If
            } // End If
          } // End If
          /* conta := conta + 1 */
          conta = conta+1;
        } // End While
        // Chiude il file
        FileLibMit.Close(fhand);
      } else { // Else
        /* _tottrans := 0 */
        _tottrans = CPLib.Round(0,0);
        //base
        ExcelFileToRead = new FileInputStream(CPLib.LRTrim(_pathdoc)+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
        _conta = wb.getNumberOfSheets();
        Row row; 
        Cell cell;
        int cellType;
        /* While _i < _conta */
        while (CPLib.lt(_i,_conta)) {
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          for (int rowNumber = sheet.getFirstRowNum(); rowNumber <= sheet.getLastRowNum(); rowNumber++) {
            row = sheet.getRow(rowNumber);
            if (row == null) {
                   // This row is completely empty
              } else {
          /* riga_letta := riga_letta+1 // riga letta del file Excel */
          riga_letta = CPLib.Round(riga_letta+1,0);
          /* If riga_letta > 1 */
          if (CPLib.gt(riga_letta,1)) {
            //scorro le colonne
            cell_count=0;
            /* While cell_count < 77 */
            while (CPLib.lt(cell_count,77)) {
              //scorro le celle della riga
              cell = row.getCell(cell_count);
              if (cell != null) {
              //  _tipocol = cell.getCellType();
                cellType = cell.getCellType().ordinal();
                switch (cellType) {
                  case 1:
                    colonna[cell_count]=String.valueOf((int)cell.getNumericCellValue());
                    break;
                  case 2:
                    colonna[cell_count]=cell.getStringCellValue();       
                    break;
                  default:
                    colonna[cell_count]=cell.getStringCellValue();       
                 }
              } else {
                colonna[cell_count]="";
              }
              ++cell_count;
            } // End While
            /* _tottrans := _tottrans + 1 */
            _tottrans = CPLib.Round(_tottrans+1,0);
            /* conta := conta + 1 */
            conta = conta+1;
            /* If mcMacAge.GoToKey(LRTrim(colonna[28])) */
            if (mcMacAge.GoToKey(CPLib.LRTrim(colonna[28]))) {
              /* If colonna[27]='I' */
              if (CPLib.eqr(colonna[27],"I")) {
                /* mcNuove.AppendBlank() */
                mcNuove.AppendBlank();
                /* mcNuove.colonna01 := colonna[0] */
                mcNuove.row.colonna01 = colonna[0];
                /* mcNuove.colonna02 := colonna[1] */
                mcNuove.row.colonna02 = colonna[1];
                /* mcNuove.colonna03 := colonna[2] */
                mcNuove.row.colonna03 = colonna[2];
                /* mcNuove.colonna04 := colonna[3] */
                mcNuove.row.colonna04 = colonna[3];
                /* mcNuove.colonna05 := colonna[4] */
                mcNuove.row.colonna05 = colonna[4];
                /* mcNuove.colonna06 := colonna[5] */
                mcNuove.row.colonna06 = colonna[5];
                /* mcNuove.colonna07 := colonna[6] */
                mcNuove.row.colonna07 = colonna[6];
                /* mcNuove.colonna08 := colonna[7] */
                mcNuove.row.colonna08 = colonna[7];
                /* mcNuove.colonna09 := colonna[8] */
                mcNuove.row.colonna09 = colonna[8];
                /* mcNuove.colonna10 := colonna[9] */
                mcNuove.row.colonna10 = colonna[9];
                /* mcNuove.colonna11 := colonna[10] */
                mcNuove.row.colonna11 = colonna[10];
                /* mcNuove.colonna12 := colonna[11] */
                mcNuove.row.colonna12 = colonna[11];
                /* mcNuove.colonna13 := colonna[12] */
                mcNuove.row.colonna13 = colonna[12];
                /* mcNuove.colonna14 := colonna[13] */
                mcNuove.row.colonna14 = colonna[13];
                /* mcNuove.colonna15 := colonna[14] */
                mcNuove.row.colonna15 = colonna[14];
                /* mcNuove.colonna16 := colonna[15] */
                mcNuove.row.colonna16 = colonna[15];
                /* mcNuove.colonna17 := colonna[16] */
                mcNuove.row.colonna17 = colonna[16];
                /* mcNuove.colonna18 := colonna[17] */
                mcNuove.row.colonna18 = colonna[17];
                /* mcNuove.colonna19 := colonna[18] */
                mcNuove.row.colonna19 = colonna[18];
                /* mcNuove.colonna20 := colonna[19] */
                mcNuove.row.colonna20 = colonna[19];
                /* mcNuove.colonna21 := colonna[20] */
                mcNuove.row.colonna21 = colonna[20];
                /* mcNuove.colonna22 := colonna[21] */
                mcNuove.row.colonna22 = colonna[21];
                /* mcNuove.colonna23 := colonna[22] */
                mcNuove.row.colonna23 = colonna[22];
                /* mcNuove.colonna24 := colonna[23] */
                mcNuove.row.colonna24 = colonna[23];
                /* mcNuove.colonna25 := colonna[24] */
                mcNuove.row.colonna25 = colonna[24];
                /* mcNuove.colonna26 := colonna[25] */
                mcNuove.row.colonna26 = colonna[25];
                /* mcNuove.colonna27 := colonna[26] */
                mcNuove.row.colonna27 = colonna[26];
                /* mcNuove.colonna28 := colonna[27] */
                mcNuove.row.colonna28 = colonna[27];
                /* mcNuove.colonna29 := colonna[28] */
                mcNuove.row.colonna29 = colonna[28];
                /* mcNuove.colonna30 := colonna[29] */
                mcNuove.row.colonna30 = colonna[29];
                /* mcNuove.colonna31 := colonna[30] */
                mcNuove.row.colonna31 = colonna[30];
                /* mcNuove.colonna32 := colonna[31] */
                mcNuove.row.colonna32 = colonna[31];
                /* mcNuove.colonna33 := colonna[32] */
                mcNuove.row.colonna33 = colonna[32];
                /* mcNuove.colonna34 := colonna[33] */
                mcNuove.row.colonna34 = colonna[33];
                /* mcNuove.colonna35 := colonna[34] */
                mcNuove.row.colonna35 = colonna[34];
                /* mcNuove.colonna36 := colonna[35] */
                mcNuove.row.colonna36 = colonna[35];
                /* mcNuove.colonna37 := colonna[36] */
                mcNuove.row.colonna37 = colonna[36];
                /* mcNuove.colonna38 := colonna[37] */
                mcNuove.row.colonna38 = colonna[37];
                /* mcNuove.colonna39 := colonna[38] */
                mcNuove.row.colonna39 = colonna[38];
                /* mcNuove.colonna40 := colonna[39] */
                mcNuove.row.colonna40 = colonna[39];
                /* mcNuove.colonna41 := colonna[40] */
                mcNuove.row.colonna41 = colonna[40];
                /* mcNuove.colonna42 := colonna[41] */
                mcNuove.row.colonna42 = colonna[41];
                /* mcNuove.colonna43 := colonna[42] */
                mcNuove.row.colonna43 = colonna[42];
                /* mcNuove.colonna44 := colonna[43] */
                mcNuove.row.colonna44 = colonna[43];
                /* mcNuove.colonna45 := colonna[44] */
                mcNuove.row.colonna45 = colonna[44];
                /* mcNuove.colonna46 := colonna[45] */
                mcNuove.row.colonna46 = colonna[45];
                /* mcNuove.colonna47 := colonna[46] */
                mcNuove.row.colonna47 = colonna[46];
                /* mcNuove.colonna48 := colonna[47] */
                mcNuove.row.colonna48 = colonna[47];
                /* mcNuove.colonna49 := colonna[48] */
                mcNuove.row.colonna49 = colonna[48];
                /* mcNuove.colonna50 := colonna[49] */
                mcNuove.row.colonna50 = colonna[49];
                /* mcNuove.colonna51 := colonna[50] */
                mcNuove.row.colonna51 = colonna[50];
                /* mcNuove.colonna52 := colonna[51] */
                mcNuove.row.colonna52 = colonna[51];
                /* mcNuove.colonna53 := colonna[52] */
                mcNuove.row.colonna53 = colonna[52];
                /* mcNuove.colonna54 := colonna[53] */
                mcNuove.row.colonna54 = colonna[53];
                /* mcNuove.colonna55 := colonna[54] */
                mcNuove.row.colonna55 = colonna[54];
                /* mcNuove.colonna56 := colonna[55] */
                mcNuove.row.colonna56 = colonna[55];
                /* mcNuove.colonna57 := colonna[56] */
                mcNuove.row.colonna57 = colonna[56];
                /* mcNuove.colonna58 := colonna[57] */
                mcNuove.row.colonna58 = colonna[57];
                /* mcNuove.colonna59 := colonna[58] */
                mcNuove.row.colonna59 = colonna[58];
                /* mcNuove.colonna60 := colonna[59] */
                mcNuove.row.colonna60 = colonna[59];
                /* mcNuove.colonna61 := colonna[60] */
                mcNuove.row.colonna61 = colonna[60];
                /* mcNuove.colonna62 := colonna[61] */
                mcNuove.row.colonna62 = colonna[61];
                /* mcNuove.colonna63 := colonna[62] */
                mcNuove.row.colonna63 = colonna[62];
                /* mcNuove.colonna64 := colonna[63] */
                mcNuove.row.colonna64 = colonna[63];
                /* mcNuove.colonna65 := colonna[64] */
                mcNuove.row.colonna65 = colonna[64];
                /* mcNuove.colonna66 := colonna[65] */
                mcNuove.row.colonna66 = colonna[65];
                /* mcNuove.colonna67 := colonna[66] */
                mcNuove.row.colonna67 = colonna[66];
                /* mcNuove.colonna68 := colonna[67] */
                mcNuove.row.colonna68 = colonna[67];
                /* mcNuove.colonna69 := colonna[68] */
                mcNuove.row.colonna69 = colonna[68];
                /* mcNuove.colonna70 := colonna[69] */
                mcNuove.row.colonna70 = colonna[69];
                /* mcNuove.colonna71 := colonna[70] */
                mcNuove.row.colonna71 = colonna[70];
                /* mcNuove.colonna72 := colonna[71] */
                mcNuove.row.colonna72 = colonna[71];
                /* mcNuove.colonna73 := colonna[72] */
                mcNuove.row.colonna73 = colonna[72];
                /* mcNuove.colonna74 := colonna[73] */
                mcNuove.row.colonna74 = colonna[73];
                /* mcNuove.colonna75 := colonna[74] */
                mcNuove.row.colonna75 = colonna[74];
                /* mcNuove.colonna76 := colonna[75] */
                mcNuove.row.colonna76 = colonna[75];
                /* mcNuove.colonna77 := colonna[76] */
                mcNuove.row.colonna77 = colonna[76];
                /* mcNuove.SaveRow() */
                mcNuove.SaveRow();
              } else { // Else
                /* mcModDel.AppendBlank() */
                mcModDel.AppendBlank();
                /* mcModDel.colonna01 := colonna[0] */
                mcModDel.row.colonna01 = colonna[0];
                /* mcModDel.colonna02 := colonna[1] */
                mcModDel.row.colonna02 = colonna[1];
                /* mcModDel.colonna03 := colonna[2] */
                mcModDel.row.colonna03 = colonna[2];
                /* mcModDel.colonna04 := colonna[3] */
                mcModDel.row.colonna04 = colonna[3];
                /* mcModDel.colonna05 := colonna[4] */
                mcModDel.row.colonna05 = colonna[4];
                /* mcModDel.colonna06 := colonna[5] */
                mcModDel.row.colonna06 = colonna[5];
                /* mcModDel.colonna07 := colonna[6] */
                mcModDel.row.colonna07 = colonna[6];
                /* mcModDel.colonna08 := colonna[7] */
                mcModDel.row.colonna08 = colonna[7];
                /* mcModDel.colonna09 := colonna[8] */
                mcModDel.row.colonna09 = colonna[8];
                /* mcModDel.colonna10 := colonna[9] */
                mcModDel.row.colonna10 = colonna[9];
                /* mcModDel.colonna11 := colonna[10] */
                mcModDel.row.colonna11 = colonna[10];
                /* mcModDel.colonna12 := colonna[11] */
                mcModDel.row.colonna12 = colonna[11];
                /* mcModDel.colonna13 := colonna[12] */
                mcModDel.row.colonna13 = colonna[12];
                /* mcModDel.colonna14 := colonna[13] */
                mcModDel.row.colonna14 = colonna[13];
                /* mcModDel.colonna15 := colonna[14] */
                mcModDel.row.colonna15 = colonna[14];
                /* mcModDel.colonna16 := colonna[15] */
                mcModDel.row.colonna16 = colonna[15];
                /* mcModDel.colonna17 := colonna[16] */
                mcModDel.row.colonna17 = colonna[16];
                /* mcModDel.colonna18 := colonna[17] */
                mcModDel.row.colonna18 = colonna[17];
                /* mcModDel.colonna19 := colonna[18] */
                mcModDel.row.colonna19 = colonna[18];
                /* mcModDel.colonna20 := colonna[19] */
                mcModDel.row.colonna20 = colonna[19];
                /* mcModDel.colonna21 := colonna[20] */
                mcModDel.row.colonna21 = colonna[20];
                /* mcModDel.colonna22 := colonna[21] */
                mcModDel.row.colonna22 = colonna[21];
                /* mcModDel.colonna23 := colonna[22] */
                mcModDel.row.colonna23 = colonna[22];
                /* mcModDel.colonna24 := colonna[23] */
                mcModDel.row.colonna24 = colonna[23];
                /* mcModDel.colonna25 := colonna[24] */
                mcModDel.row.colonna25 = colonna[24];
                /* mcModDel.colonna26 := colonna[25] */
                mcModDel.row.colonna26 = colonna[25];
                /* mcModDel.colonna27 := colonna[26] */
                mcModDel.row.colonna27 = colonna[26];
                /* mcModDel.colonna28 := colonna[27] */
                mcModDel.row.colonna28 = colonna[27];
                /* mcModDel.colonna29 := colonna[28] */
                mcModDel.row.colonna29 = colonna[28];
                /* mcModDel.colonna30 := colonna[29] */
                mcModDel.row.colonna30 = colonna[29];
                /* mcModDel.colonna31 := colonna[30] */
                mcModDel.row.colonna31 = colonna[30];
                /* mcModDel.colonna32 := colonna[31] */
                mcModDel.row.colonna32 = colonna[31];
                /* mcModDel.colonna33 := colonna[32] */
                mcModDel.row.colonna33 = colonna[32];
                /* mcModDel.colonna34 := colonna[33] */
                mcModDel.row.colonna34 = colonna[33];
                /* mcModDel.colonna35 := colonna[34] */
                mcModDel.row.colonna35 = colonna[34];
                /* mcModDel.colonna36 := colonna[35] */
                mcModDel.row.colonna36 = colonna[35];
                /* mcModDel.colonna37 := colonna[36] */
                mcModDel.row.colonna37 = colonna[36];
                /* mcModDel.colonna38 := colonna[37] */
                mcModDel.row.colonna38 = colonna[37];
                /* mcModDel.colonna39 := colonna[38] */
                mcModDel.row.colonna39 = colonna[38];
                /* mcModDel.colonna40 := colonna[39] */
                mcModDel.row.colonna40 = colonna[39];
                /* mcModDel.colonna41 := colonna[40] */
                mcModDel.row.colonna41 = colonna[40];
                /* mcModDel.colonna42 := colonna[41] */
                mcModDel.row.colonna42 = colonna[41];
                /* mcModDel.colonna43 := colonna[42] */
                mcModDel.row.colonna43 = colonna[42];
                /* mcModDel.colonna44 := colonna[43] */
                mcModDel.row.colonna44 = colonna[43];
                /* mcModDel.colonna45 := colonna[44] */
                mcModDel.row.colonna45 = colonna[44];
                /* mcModDel.colonna46 := colonna[45] */
                mcModDel.row.colonna46 = colonna[45];
                /* mcModDel.colonna47 := colonna[46] */
                mcModDel.row.colonna47 = colonna[46];
                /* mcModDel.colonna48 := colonna[47] */
                mcModDel.row.colonna48 = colonna[47];
                /* mcModDel.colonna49 := colonna[48] */
                mcModDel.row.colonna49 = colonna[48];
                /* mcModDel.colonna50 := colonna[49] */
                mcModDel.row.colonna50 = colonna[49];
                /* mcModDel.colonna51 := colonna[50] */
                mcModDel.row.colonna51 = colonna[50];
                /* mcModDel.colonna52 := colonna[51] */
                mcModDel.row.colonna52 = colonna[51];
                /* mcModDel.colonna53 := colonna[52] */
                mcModDel.row.colonna53 = colonna[52];
                /* mcModDel.colonna54 := colonna[53] */
                mcModDel.row.colonna54 = colonna[53];
                /* mcModDel.colonna55 := colonna[54] */
                mcModDel.row.colonna55 = colonna[54];
                /* mcModDel.colonna56 := colonna[55] */
                mcModDel.row.colonna56 = colonna[55];
                /* mcModDel.colonna57 := colonna[56] */
                mcModDel.row.colonna57 = colonna[56];
                /* mcModDel.colonna58 := colonna[57] */
                mcModDel.row.colonna58 = colonna[57];
                /* mcModDel.colonna59 := colonna[58] */
                mcModDel.row.colonna59 = colonna[58];
                /* mcModDel.colonna60 := colonna[59] */
                mcModDel.row.colonna60 = colonna[59];
                /* mcModDel.colonna61 := colonna[60] */
                mcModDel.row.colonna61 = colonna[60];
                /* mcModDel.colonna62 := colonna[61] */
                mcModDel.row.colonna62 = colonna[61];
                /* mcModDel.colonna63 := colonna[62] */
                mcModDel.row.colonna63 = colonna[62];
                /* mcModDel.colonna64 := colonna[63] */
                mcModDel.row.colonna64 = colonna[63];
                /* mcModDel.colonna65 := colonna[64] */
                mcModDel.row.colonna65 = colonna[64];
                /* mcModDel.colonna66 := colonna[65] */
                mcModDel.row.colonna66 = colonna[65];
                /* mcModDel.colonna67 := colonna[66] */
                mcModDel.row.colonna67 = colonna[66];
                /* mcModDel.colonna68 := colonna[67] */
                mcModDel.row.colonna68 = colonna[67];
                /* mcModDel.colonna69 := colonna[68] */
                mcModDel.row.colonna69 = colonna[68];
                /* mcModDel.colonna70 := colonna[69] */
                mcModDel.row.colonna70 = colonna[69];
                /* mcModDel.colonna71 := colonna[70] */
                mcModDel.row.colonna71 = colonna[70];
                /* mcModDel.colonna72 := colonna[71] */
                mcModDel.row.colonna72 = colonna[71];
                /* mcModDel.colonna73 := colonna[72] */
                mcModDel.row.colonna73 = colonna[72];
                /* mcModDel.colonna74 := colonna[73] */
                mcModDel.row.colonna74 = colonna[73];
                /* mcModDel.colonna75 := colonna[74] */
                mcModDel.row.colonna75 = colonna[74];
                /* mcModDel.colonna76 := colonna[75] */
                mcModDel.row.colonna76 = colonna[75];
                /* mcModDel.colonna77 := colonna[76] */
                mcModDel.row.colonna77 = colonna[76];
                /* mcModDel.SaveRow() */
                mcModDel.SaveRow();
              } // End If
            } // End If
          } // End If
          // Chiude i cicli
            }
          }
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          _i++;
        } // End While
        // Chiude il file
        ExcelFileToRead.close();
      } // End If
      // Cancella il file di import
      FileLibMit.DeleteFilePath(_pathdoc+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      /* If At(".TXT",Upper(nomefileimport)) > 0 */
      if (CPLib.gt(CPLib.At(".TXT",CPLib.Upper(nomefileimport)),0)) {
        // Chiude il file
        FileLibMit.Close(fhand);
      } else { // Else
        // Chiude il file
        ExcelFileToRead.close();
      } // End If
      // Cancella il file di import
      FileLibMit.DeleteFilePath(_pathdoc+"/appo/"+CPLib.LRTrim(_azienda)+"/"+CPLib.LRTrim(nomefileimport));
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000605status,0)) {
        m_Sql.SetTransactionStatus(nTry00000605status,cTry00000605msg);
      }
    }
  }
  void Page_16() throws Exception {
    CPResultSet Cursor_qbe_wuautocorrect=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* If rowLettura.colonna75='S' or rowLettura.colonna76='S'  */
      if (CPLib.eqr(rowLettura.colonna75,"S") || CPLib.eqr(rowLettura.colonna76,"S")) {
        /* If Empty(w_idmage) or (LRTrim(rowLettura.colonna29)=w_xMANAIDWU) */
        if (CPLib.Empty(w_idmage) || (CPLib.eqr(CPLib.LRTrim(rowLettura.colonna29),w_xMANAIDWU))) {
          /* w_codmage := '' */
          w_codmage = "";
          /* _flgact := '' */
          _flgact = "";
          /* _flgaua := "" */
          _flgaua = "";
          /* w_xMAFLGRAP := '' */
          w_xMAFLGRAP = "";
          /* w_xMAFLGBON := '' */
          w_xMAFLGBON = "";
          /* w_xMAFLGCKR := '' */
          w_xMAFLGCKR = "";
          /* w_xMAFLGASR := '' */
          w_xMAFLGASR = "";
          /* w_xMADIPSTD := '' */
          w_xMADIPSTD = "";
          /* w_xMAFLGCHKDAT := '' */
          w_xMAFLGCHKDAT = "";
          /* w_xMARESSDEF := '' */
          w_xMARESSDEF = "";
          /* If mcMacAge.GoToKey(LRTrim(rowLettura.colonna29)) */
          if (mcMacAge.GoToKey(CPLib.LRTrim(rowLettura.colonna29))) {
            /* w_codmage := mcMacAge.MACODICE */
            w_codmage = mcMacAge.row.MACODICE;
            /* _flgact := mcMacAge.MAFLGACT */
            _flgact = mcMacAge.row.MAFLGACT;
            /* _flgaua := mcMacAge.MAFLGAUA */
            _flgaua = mcMacAge.row.MAFLGAUA;
            /* w_xMAFLGRAP := mcMacAge.MAFLGRAP */
            w_xMAFLGRAP = mcMacAge.row.MAFLGRAP;
            /* w_xMAFLGBON := mcMacAge.MAFLGBON */
            w_xMAFLGBON = mcMacAge.row.MAFLGBON;
            /* w_xMAFLGCKR := mcMacAge.MAFLGCKR */
            w_xMAFLGCKR = mcMacAge.row.MAFLGCKR;
            /* w_xMAFLGASR := mcMacAge.MAFLGASR */
            w_xMAFLGASR = mcMacAge.row.MAFLGASR;
            /* w_xMADIPSTD := mcMacAge.MADIPSTD */
            w_xMADIPSTD = mcMacAge.row.MADIPSTD;
            /* w_xMAFLGCHKDAT := mcMacAge.MAFLGCHKDAT */
            w_xMAFLGCHKDAT = mcMacAge.row.MAFLGCHKDAT;
            /* w_xMARESSDEF := mcMacAge.MARESSDEF */
            w_xMARESSDEF = mcMacAge.row.MARESSDEF;
          } // End If
          /* If (not(Empty(w_codmage)) and _flgact='S') or Empty(LRTrim(rowLettura.colonna29)) */
          if (( ! (CPLib.Empty(w_codmage)) && CPLib.eqr(_flgact,"S")) || CPLib.Empty(CPLib.LRTrim(rowLettura.colonna29))) {
            /* _i := 1 */
            _i = 1;
            /* _tiperr := '' */
            _tiperr = "";
            /* _listerr := '' */
            _listerr = "";
            /* _esito := 0 */
            _esito = CPLib.Round(0,0);
            /* xConnes := '' */
            xConnes = "";
            /* _tipoop := '' */
            _tipoop = "";
            /* _coddip := '' */
            _coddip = "";
            /* _uniquecode := '' */
            _uniquecode = "";
            /* _datope := NullDate() */
            _datope = CPLib.NullDate();
            /* _impstr := '' */
            _impstr = "";
            /* _importo := 0 */
            _importo = CPLib.Round(0,2);
            /* _statodest := '' */
            _statodest = "";
            /* _isodest := '' */
            _isodest = "";
            /* _cognome := '' */
            _cognome = "";
            /* _nome := '' */
            _nome = "";
            /* _citta := '' */
            _citta = "";
            /* _cap := '' */
            _cap = "";
            /* _via := '' */
            _via = "";
            /* _prov := '' */
            _prov = "";
            /* _cab := '' */
            _cab = "";
            /* _resstato := '' */
            _resstato = "";
            /* _cognomecp := '' */
            _cognomecp = "";
            /* _nomecp := '' */
            _nomecp = "";
            /* _sesso := '' */
            _sesso = "";
            /* _nascitta := '' */
            _nascitta = "";
            /* _nasstato := '' */
            _nasstato = "";
            /* _nasprov := '' */
            _nasprov = "";
            /* _nasdata := NullDate() */
            _nasdata = CPLib.NullDate();
            /* _tipodoc := '' */
            _tipodoc = "";
            /* _numdoc := '' */
            _numdoc = "";
            /* _docril := NullDate() */
            _docril = CPLib.NullDate();
            /* _autril := '' */
            _autril = "";
            /* _docsca := NullDate() */
            _docsca = CPLib.NullDate();
            /* _codfis := '' */
            _codfis = "";
            /* _ocodfis := '' */
            _ocodfis = "";
            /* _connes := '' */
            _connes = "";
            /* _doctype := '' */
            _doctype = "";
            /* _codana := '' */
            _codana = "";
            /* _codsin := '' */
            _codsin = "";
            /* _segno := '' */
            _segno = "";
            /* _nocf := 0 */
            _nocf = CPLib.Round(0,0);
            /* _nocfap := 0 */
            _nocfap = CPLib.Round(0,0);
            /* _txtope := '' */
            _txtope = "";
            /* _oldcodfis := '' */
            _oldcodfis = "";
            /* _oldmac := '' */
            _oldmac = "";
            /* _wupos := '' */
            _wupos = "";
            /* gID := "" // Galactic ID */
            gID = "";
            /* _nazrildoc := "" // Nazione Rilascio Documento */
            _nazrildoc = "";
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
            /* _err12 := '' */
            _err12 = "";
            /* _err13 := '' */
            _err13 = "";
            /* _err14 := '' */
            _err14 = "";
            /* _err15 := '' */
            _err15 = "";
            /* _err16 := '' */
            _err16 = "";
            /* _err17 := '' */
            _err17 = "";
            /* _err18 := '' */
            _err18 = "";
            /* _err19 := '' */
            _err19 = "";
            /* _err20 := '' */
            _err20 = "";
            /* _err21 := '' */
            _err21 = "";
            /* _err22 := '' */
            _err22 = "";
            /* _err23 := '' */
            _err23 = "";
            /* _err24 := '' */
            _err24 = "";
            /* _err25 := '' */
            _err25 = "";
            /* _err26 := '' */
            _err26 = "";
            /* _err27 := '' */
            _err27 = "";
            /* _err28 := '' */
            _err28 = "";
            /* _err29 := '' */
            _err29 = "";
            /* _err30 := '' */
            _err30 = "";
            /* _err31 := '' */
            _err31 = "";
            /* _err32 := '' */
            _err32 = "";
            /* _err33 := '' */
            _err33 = "";
            /* _err34 := '' */
            _err34 = "";
            /* _err35 := '' */
            _err35 = "";
            /* _err36 := '' */
            _err36 = "";
            /* _err37 := '' */
            _err37 = "";
            /* _err38 := '' */
            _err38 = "";
            /* _err39 := '' */
            _err39 = "";
            /* _err40 := '' */
            _err40 = "";
            /* _err41 := '' */
            _err41 = "";
            /* _aua01 := '' */
            _aua01 = "";
            /* _aua02 := '' */
            _aua02 = "";
            /* _aua03 := '' */
            _aua03 = "";
            /* _aua04 := '' */
            _aua04 = "";
            /* _aua05 := '' */
            _aua05 = "";
            /* _aua06 := '' */
            _aua06 = "";
            /* _aua07 := '' */
            _aua07 = "";
            /* _aua08 := '' */
            _aua08 = "";
            /* _aua09 := '' */
            _aua09 = "";
            /* _aua10 := '' */
            _aua10 = "";
            /* _mage := '' */
            _mage = "";
            /* _prog := '' */
            _prog = "";
            /* _citdip := '' */
            _citdip = "";
            /* _cabdip := '' */
            _cabdip = "";
            /* _provdip := '' */
            _provdip = "";
            /* _wupos := '' */
            _wupos = "";
            for (MemoryCursorRow_anadip rowAnadip : mcAnadip._iterable_()) {
              /* If LRTrim(rowAnadip.AGACCODE)=LRTrim(rowLettura.colonna20) and rowAnadip.MACROAGENTE=w_codmage */
              if (CPLib.eqr(CPLib.LRTrim(rowAnadip.AGACCODE),CPLib.LRTrim(rowLettura.colonna20)) && CPLib.eqr(rowAnadip.MACROAGENTE,w_codmage)) {
                /* _coddip := rowAnadip.CODDIP */
                _coddip = rowAnadip.CODDIP;
                /* _mage := rowAnadip.MACROAGENTE */
                _mage = rowAnadip.MACROAGENTE;
                /* _prog := rowAnadip.CODDIP */
                _prog = rowAnadip.CODDIP;
                /* _citdip := rowAnadip.DESCCIT */
                _citdip = rowAnadip.DESCCIT;
                /* _cabdip := rowAnadip.CAB */
                _cabdip = rowAnadip.CAB;
                /* _provdip := rowAnadip.PROVINCIA */
                _provdip = rowAnadip.PROVINCIA;
                /* _wupos := rowAnadip.FLGWUPOS */
                _wupos = rowAnadip.FLGWUPOS;
                // Exit Loop
                if (true) {
                  break;
                }
              } // End If
            }
            /* _idfile := w_codmage */
            _idfile = w_codmage;
            /* If (_wupos='S' and _wuposonly='S') or _wuposonly='N' */
            if ((CPLib.eqr(_wupos,"S") && CPLib.eqr(_wuposonly,"S")) || CPLib.eqr(_wuposonly,"N")) {
              /* If Left(rowLettura.colonna28,1)='I' */
              if (CPLib.eqr(CPLib.Left(rowLettura.colonna28,1),"I")) {
                /* w_CODFISC := '' // Codice Fiscale */
                w_CODFISC = "";
                /* w_DATANASC := NullDate() // Data Nascita */
                w_DATANASC = CPLib.NullDate();
                /* w_NASCOMUN := '' // Luogo di Nascita */
                w_NASCOMUN = "";
                /* w_NASSTATO := '' // Stato di nascita */
                w_NASSTATO = "";
                /* w_COGNOME := '' // Ragione Sociale */
                w_COGNOME = "";
                /* w_RAGSOC := '' // Ragione Sociale */
                w_RAGSOC = "";
                /* w_NOME := '' // Ragione Sociale */
                w_NOME = "";
                /* w_SESSO := '' // Sesso */
                w_SESSO = "";
                /* _cognome := LRTrim(rowLettura.colonna01) */
                _cognome = CPLib.LRTrim(rowLettura.colonna01);
                /* _nome := LRTrim(rowLettura.colonna02) */
                _nome = CPLib.LRTrim(rowLettura.colonna02);
                /* _codfis := Upper(Left(LRTrim(rowLettura.colonna05),16)) */
                _codfis = CPLib.Upper(CPLib.Left(CPLib.LRTrim(rowLettura.colonna05),16));
                /* _nocfap := iif(LRTrim(rowLettura.colonna04)='S',0,iif(LRTrim(rowLettura.colonna04)='N',1,-1)) */
                _nocfap = CPLib.Round((CPLib.eqr(CPLib.LRTrim(rowLettura.colonna04),"S")?0:(CPLib.eqr(CPLib.LRTrim(rowLettura.colonna04),"N")?1:-1)),0);
                /* _nocf := iif(Empty(_codfis),1,iif(arfn_chkcodfis(_codfis,'',_nocfap),0,1)) */
                _nocf = CPLib.Round((CPLib.Empty(_codfis)?1:(arfn_chkcodfisR.Make(m_Ctx,this).Run(_codfis,"",_nocfap)?0:1)),0);
                /* _nasdata := CharToDate(Left(LRTrim(rowLettura.colonna25),8)) */
                _nasdata = CPLib.CharToDate(CPLib.Left(CPLib.LRTrim(rowLettura.colonna25),8));
                /* _sesso := Left(LRTrim(rowLettura.colonna26),1) */
                _sesso = CPLib.Left(CPLib.LRTrim(rowLettura.colonna26),1);
                /* gID := Left(LRTrim(rowLettura.colonna32),20) // Galactic ID */
                gID = CPLib.Left(CPLib.LRTrim(rowLettura.colonna32),20);
                /* _nazrildoc := Left(LRTrim(rowLettura.colonna31),20) // Nazione Rilascio Documento */
                _nazrildoc = CPLib.Left(CPLib.LRTrim(rowLettura.colonna31),20);
                /* _numdoc := LRTrim(Left(LRTrim(rowLettura.colonna07),30)) */
                _numdoc = CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna07),30));
                /* _docril := CharToDate(Left(LRTrim(rowLettura.colonna09),8)) */
                _docril = CPLib.CharToDate(CPLib.Left(CPLib.LRTrim(rowLettura.colonna09),8));
                /* _docsca := CharToDate(Left(LRTrim(rowLettura.colonna08),50)) */
                _docsca = CPLib.CharToDate(CPLib.Left(CPLib.LRTrim(rowLettura.colonna08),50));
                /* _autril := LRTrim(Left(LRTrim(rowLettura.colonna10),50)) */
                _autril = CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna10),50));
                /* _doctype := arfn_wu_doctype(LRTrim(Left(LRTrim(rowLettura.colonna13),2))) */
                _doctype = arfn_wu_doctypeR.Make(m_Ctx,this).Run(CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna13),2)));
                /* _idau := 0 */
                _idau = CPLib.Round(0,0);
                /* If pAUA='S' */
                if (CPLib.eqr(pAUA,"S")) {
                  // * --- Select from qbe_wuautocorrect
                  SPBridge.HMCaller _h000007CB;
                  _h000007CB = new SPBridge.HMCaller();
                  _h000007CB.Set("m_cVQRList",m_cVQRList);
                  _h000007CB.Set("pAUOCOGNOM",CPLib.LRTrim(_cognome));
                  _h000007CB.Set("pAUONOME",CPLib.LRTrim(_nome));
                  _h000007CB.Set("pAUOLUONAS",CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna06),50)));
                  _h000007CB.Set("pAUODATNAS",_nasdata);
                  _h000007CB.Set("pAUOSESSO",_sesso);
                  _h000007CB.Set("pAUOTIPDOC",CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna13),2)));
                  _h000007CB.Set("pAUONUMDOC",CPLib.LRTrim(_numdoc));
                  _h000007CB.Set("pAUOCODFISC",CPLib.LRTrim(_codfis));
                  if (Cursor_qbe_wuautocorrect!=null)
                    Cursor_qbe_wuautocorrect.Close();
                  Cursor_qbe_wuautocorrect = new VQRHolder("qbe_wuautocorrect",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000007CB,true).GetResultSet(m_Ctx);
                  while ( ! (Cursor_qbe_wuautocorrect.Eof())) {
                    /* _cognome := qbe_wuautocorrect->AUCOGNOM */
                    _cognome = Cursor_qbe_wuautocorrect.GetString("AUCOGNOM");
                    /* _nome := qbe_wuautocorrect->AUNOME */
                    _nome = Cursor_qbe_wuautocorrect.GetString("AUNOME");
                    /* _nasdata := qbe_wuautocorrect->AUDATNAS */
                    _nasdata = Cursor_qbe_wuautocorrect.GetDate("AUDATNAS");
                    /* _sesso := qbe_wuautocorrect->AUSESSO */
                    _sesso = Cursor_qbe_wuautocorrect.GetString("AUSESSO");
                    /* _luonas := qbe_wuautocorrect->AULUONAS */
                    _luonas = Cursor_qbe_wuautocorrect.GetString("AULUONAS");
                    /* _codfis := qbe_wuautocorrect->AUCODFISC */
                    _codfis = Cursor_qbe_wuautocorrect.GetString("AUCODFISC");
                    /* _nocf := iif(not(Empty(_codfis)),0,1) */
                    _nocf = CPLib.Round(( ! (CPLib.Empty(_codfis))?0:1),0);
                    /* If pErrAUI='N' */
                    if (CPLib.eqr(pErrAUI,"N")) {
                      // * --- Insert into wuautocorrect_mtcn from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wuautocorrect_mtcn");
                      m_cPhName = m_Ctx.GetPhName("wuautocorrect_mtcn");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wuautocorrect_mtcn",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000007D4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000007D4(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowLettura.colonna30),10),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(CPLib.LRTrim(rowLettura.colonna14),8)),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUCOGNOM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUNOME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AULUONAS"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetDate("AUDATNAS"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUSESSO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUTIPDOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUNUMDOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOCOGNOM"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUONOME"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOLUONAS"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetDate("AUODATNAS"),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOSESSO"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOTIPDOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUONUMDOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUCODFISC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOCODFISC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wuautocorrect_mtcn",true);
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
                    /* _idau := 1 */
                    _idau = CPLib.Round(1,0);
                    Cursor_qbe_wuautocorrect.Next();
                  }
                  m_cConnectivityError = Cursor_qbe_wuautocorrect.ErrorMessage();
                  Cursor_qbe_wuautocorrect.Close();
                  // * --- End Select
                } // End If
                /* _nasprov := '' */
                _nasprov = "";
                /* _nasstato := '' */
                _nasstato = "";
                /* _nascitta := '' */
                _nascitta = "";
                /* If not(Empty(Left(LRTrim(rowLettura.colonna06),50))) */
                if ( ! (CPLib.Empty(CPLib.Left(CPLib.LRTrim(rowLettura.colonna06),50)))) {
                  /* _codstanas := '' */
                  _codstanas = "";
                  /* _luonas := iif(_idau=0,LRTrim(Left(LRTrim(rowLettura.colonna06),50)),_luonas) */
                  _luonas = (CPLib.eqr(_idau,0)?CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna06),50)):_luonas);
                  for (MemoryCursorRow_tbluonas rowStatiN : mcStatiN._iterable_()) {
                    /* If LRTrim(rowStatiN.DESCRI)=LRTrim(_luonas) */
                    if (CPLib.eqr(CPLib.LRTrim(rowStatiN.DESCRI),CPLib.LRTrim(_luonas))) {
                      /* _codstanas := LRTrim(rowStatiN.SIGLA) */
                      _codstanas = CPLib.LRTrim(rowStatiN.SIGLA);
                      /* If Left(rowStatiN.SIGLA,1)='Z' */
                      if (CPLib.eqr(CPLib.Left(rowStatiN.SIGLA,1),"Z")) {
                        /* _nasstato := LRTrim(rowStatiN.DESCRI) */
                        _nasstato = CPLib.LRTrim(rowStatiN.DESCRI);
                      } else { // Else
                        /* _nascitta := LRTrim(rowStatiN.DESCRI) */
                        _nascitta = CPLib.LRTrim(rowStatiN.DESCRI);
                      } // End If
                      /* _nasprov := LRTrim(rowStatiN.PROVINCIA) */
                      _nasprov = CPLib.LRTrim(rowStatiN.PROVINCIA);
                      // Exit Loop
                      if (true) {
                        break;
                      }
                    } // End If
                  }
                  /* If Empty(LRTrim(_nasstato)) and Empty(LRTrim(_nascitta)) */
                  if (CPLib.Empty(CPLib.LRTrim(_nasstato)) && CPLib.Empty(CPLib.LRTrim(_nascitta))) {
                    for (MemoryCursorRow_decodenascita rowDecodeNascita : mcDecodeNascita._iterable_()) {
                      /* If Upper(LRTrim(rowDecodeNascita.account))=Upper(LRTrim(_luonas)) */
                      if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(rowDecodeNascita.account)),CPLib.Upper(CPLib.LRTrim(_luonas)))) {
                        /* _codstanas := LRTrim(rowDecodeNascita.SIGLA) */
                        _codstanas = CPLib.LRTrim(rowDecodeNascita.SIGLA);
                        /* If Left(rowDecodeNascita.SIGLA,1)='Z' */
                        if (CPLib.eqr(CPLib.Left(rowDecodeNascita.SIGLA,1),"Z")) {
                          /* _nasstato := LRTrim(rowDecodeNascita.DESCRI) */
                          _nasstato = CPLib.LRTrim(rowDecodeNascita.DESCRI);
                        } else { // Else
                          /* _nascitta := LRTrim(rowDecodeNascita.DESCRI) */
                          _nascitta = CPLib.LRTrim(rowDecodeNascita.DESCRI);
                        } // End If
                        /* _nasprov := LRTrim(rowDecodeNascita.PROVINCIA) */
                        _nasprov = CPLib.LRTrim(rowDecodeNascita.PROVINCIA);
                        // Exit Loop
                        if (true) {
                          break;
                        }
                      } // End If
                    }
                    /* If Empty(LRTrim(_nasstato)) and Empty(LRTrim(_nascitta)) */
                    if (CPLib.Empty(CPLib.LRTrim(_nasstato)) && CPLib.Empty(CPLib.LRTrim(_nascitta))) {
                      /* If _nocf=0 and not(arfn_omocode(_codfis,_nocf)) */
                      if (CPLib.eqr(_nocf,0) &&  ! (arfn_omocodeR.Make(m_Ctx,this).Run(_codfis,_nocf))) {
                        /* _ocodfis := _codfis */
                        _ocodfis = _codfis;
                        /* If Substr(_codfis,12,1)='Z' */
                        if (CPLib.eqr(CPLib.Substr(_codfis,12,1),"Z")) {
                          /* _nasprov := 'EE' */
                          _nasprov = "EE";
                          /* _nasstato := '' */
                          _nasstato = "";
                          for (MemoryCursorRow_tbluonas rowStatiN : mcStatiN._iterable_()) {
                            /* If rowStatiN.SIGLA=Substr(_codfis,12,4) */
                            if (CPLib.eqr(rowStatiN.SIGLA,CPLib.Substr(_codfis,12,4))) {
                              /* _nasstato := LRTrim(rowStatiN.DESCRI) */
                              _nasstato = CPLib.LRTrim(rowStatiN.DESCRI);
                              // Exit Loop
                              if (true) {
                                break;
                              }
                            } // End If
                          }
                        } else { // Else
                          /* _nascitta := '' */
                          _nascitta = "";
                          /* _nasprov := '' */
                          _nasprov = "";
                          for (MemoryCursorRow_tbluonas rowStatiN : mcStatiN._iterable_()) {
                            /* If rowStatiN.SIGLA=Substr(_codfis,12,4) */
                            if (CPLib.eqr(rowStatiN.SIGLA,CPLib.Substr(_codfis,12,4))) {
                              /* _nascitta := LRTrim(rowStatiN.DESCRI) */
                              _nascitta = CPLib.LRTrim(rowStatiN.DESCRI);
                              /* _nasprov := LRTrim(rowStatiN.PROVINCIA) */
                              _nasprov = CPLib.LRTrim(rowStatiN.PROVINCIA);
                              // Exit Loop
                              if (true) {
                                break;
                              }
                            } // End If
                          }
                        } // End If
                        /* If not(Empty(LRTrim(_nasstato)) and Empty(LRTrim(_nascitta))) */
                        if ( ! (CPLib.Empty(CPLib.LRTrim(_nasstato)) && CPLib.Empty(CPLib.LRTrim(_nascitta)))) {
                          /* _luonas := iif(Empty(_nasstato),LRTrim(_nascitta),LRTrim(_nasstato)) */
                          _luonas = (CPLib.Empty(_nasstato)?CPLib.LRTrim(_nascitta):CPLib.LRTrim(_nasstato));
                        } // End If
                      } // End If
                    } else { // Else
                      /* _luonas := iif(Empty(_nasstato),LRTrim(_nascitta),LRTrim(_nasstato)) */
                      _luonas = (CPLib.Empty(_nasstato)?CPLib.LRTrim(_nascitta):CPLib.LRTrim(_nasstato));
                    } // End If
                  } else { // Else
                    /* _luonas := iif(Empty(_nasstato),LRTrim(_nascitta),LRTrim(_nasstato)) */
                    _luonas = (CPLib.Empty(_nasstato)?CPLib.LRTrim(_nascitta):CPLib.LRTrim(_nasstato));
                  } // End If
                  /* If pAUA='S' and _idau=0 */
                  if (CPLib.eqr(pAUA,"S") && CPLib.eqr(_idau,0)) {
                    // * --- Select from qbe_wuautocorrect
                    SPBridge.HMCaller _h00000804;
                    _h00000804 = new SPBridge.HMCaller();
                    _h00000804.Set("m_cVQRList",m_cVQRList);
                    _h00000804.Set("pAUOCOGNOM",CPLib.LRTrim(_cognome));
                    _h00000804.Set("pAUONOME",CPLib.LRTrim(_nome));
                    _h00000804.Set("pAUOLUONAS",CPLib.Left(CPLib.LRTrim(_luonas),50));
                    _h00000804.Set("pAUODATNAS",_nasdata);
                    _h00000804.Set("pAUOSESSO",_sesso);
                    _h00000804.Set("pAUOTIPDOC",CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna13),2)));
                    _h00000804.Set("pAUONUMDOC",CPLib.LRTrim(_numdoc));
                    _h00000804.Set("pAUOCODFISC",CPLib.LRTrim(_codfis));
                    if (Cursor_qbe_wuautocorrect!=null)
                      Cursor_qbe_wuautocorrect.Close();
                    Cursor_qbe_wuautocorrect = new VQRHolder("qbe_wuautocorrect",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000804,true).GetResultSet(m_Ctx);
                    while ( ! (Cursor_qbe_wuautocorrect.Eof())) {
                      /* _cognome := qbe_wuautocorrect->AUCOGNOM */
                      _cognome = Cursor_qbe_wuautocorrect.GetString("AUCOGNOM");
                      /* _nome := qbe_wuautocorrect->AUNOME */
                      _nome = Cursor_qbe_wuautocorrect.GetString("AUNOME");
                      /* _nasdata := qbe_wuautocorrect->AUDATNAS */
                      _nasdata = Cursor_qbe_wuautocorrect.GetDate("AUDATNAS");
                      /* _sesso := qbe_wuautocorrect->AUSESSO */
                      _sesso = Cursor_qbe_wuautocorrect.GetString("AUSESSO");
                      /* _luonas := qbe_wuautocorrect->AULUONAS */
                      _luonas = Cursor_qbe_wuautocorrect.GetString("AULUONAS");
                      /* _codfis := qbe_wuautocorrect->AUCODFISC */
                      _codfis = Cursor_qbe_wuautocorrect.GetString("AUCODFISC");
                      /* _nocf := iif(not(Empty(_codfis)),0,1) */
                      _nocf = CPLib.Round(( ! (CPLib.Empty(_codfis))?0:1),0);
                      /* If pErrAUI='N' */
                      if (CPLib.eqr(pErrAUI,"N")) {
                        // * --- Insert into wuautocorrect_mtcn from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("wuautocorrect_mtcn");
                        m_cPhName = m_Ctx.GetPhName("wuautocorrect_mtcn");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wuautocorrect_mtcn",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000080D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                        m_cSql = m_cSql+GetFieldsName_0000080D(m_Ctx,m_oWrInfo);
                        m_cSql = m_cSql+") values (";
                        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowLettura.colonna30),10),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(CPLib.LRTrim(rowLettura.colonna14),8)),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUCOGNOM"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUNOME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AULUONAS"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetDate("AUDATNAS"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUSESSO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUTIPDOC"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUNUMDOC"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOCOGNOM"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUONOME"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOLUONAS"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetDate("AUODATNAS"),"?",0,0)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOSESSO"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOTIPDOC"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUONUMDOC"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUCODFISC"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_wuautocorrect.GetString("AUOCODFISC"),"?",0,0,m_cServer)+", ";
                        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                        m_cSql = m_cSql+m_oWrInfo.InsertValues();
                        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wuautocorrect_mtcn",true);
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
                      /* _idau := 1 */
                      _idau = CPLib.Round(1,0);
                      Cursor_qbe_wuautocorrect.Next();
                    }
                    m_cConnectivityError = Cursor_qbe_wuautocorrect.ErrorMessage();
                    Cursor_qbe_wuautocorrect.Close();
                    // * --- End Select
                  } // End If
                } // End If
                /* _priga := LRTrim(Left(LRTrim(rowLettura.colonna03),100)) */
                _priga = CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna03),100));
                /* _i := 0 */
                _i = 0;
                /* While _i < 4 */
                while (CPLib.lt(_i,4)) {
                  /* If _i=0 */
                  if (CPLib.eqr(_i,0)) {
                    /* _via := Left(_priga,At('|',_priga)-1) */
                    _via = CPLib.Left(_priga,CPLib.At("|",_priga)-1);
                    /* ElseIf _i=1 */
                  } else if (CPLib.eqr(_i,1)) {
                    /* ElseIf _i=2 */
                  } else if (CPLib.eqr(_i,2)) {
                    /* _cap := Left(_priga,At('|',_priga)-1) */
                    _cap = CPLib.Left(_priga,CPLib.At("|",_priga)-1);
                  } else { // Else
                  } // End If
                  /* _i := _i + 1 */
                  _i = _i+1;
                  /* _priga := Substr(_priga,At('|',_priga)+2) */
                  _priga = CPLib.Substr(_priga,CPLib.At("|",_priga)+2);
                } // End While
                /* _citta := Upper(Left(LRTrim(rowLettura.colonna12),50)) */
                _citta = CPLib.Upper(CPLib.Left(CPLib.LRTrim(rowLettura.colonna12),50));
                /* _codcit := '' */
                _codcit = "";
                /* If mcTbcitta.GoToKey(LRTrim(_citta)) */
                if (mcTbcitta.GoToKey(CPLib.LRTrim(_citta))) {
                  /* _codcit := mcTbcitta.IDBASE */
                  _codcit = mcTbcitta.row.IDBASE;
                } // End If
                /* If not(Empty(LRTrim(_citta))) and Empty(LRTrim(_codcit)) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_citta))) && CPLib.Empty(CPLib.LRTrim(_codcit))) {
                  /* If mcDecodeCitta.GoToKey(LRTrim(_citta)) */
                  if (mcDecodeCitta.GoToKey(CPLib.LRTrim(_citta))) {
                    /* _codcit := mcDecodeCitta.IDBASE */
                    _codcit = mcDecodeCitta.row.IDBASE;
                  } // End If
                } // End If
                /* _paese := Upper(Left(LRTrim(rowLettura.colonna11),50)) */
                _paese = CPLib.Upper(CPLib.Left(CPLib.LRTrim(rowLettura.colonna11),50));
                /* _codstares := '' */
                _codstares = "";
                /* If mcTbstatiD.GoToKey(Left(LRTrim(_paese),40)) */
                if (mcTbstatiD.GoToKey(CPLib.Left(CPLib.LRTrim(_paese),40))) {
                  /* _codstares := mcTbstatiD.CODSTA */
                  _codstares = mcTbstatiD.row.CODSTA;
                  /* xFLGSAE := LRTrim(mcTbstatiD.FLGSAE) */
                  xFLGSAE = CPLib.LRTrim(mcTbstatiD.row.FLGSAE);
                } // End If
                /* If not(Empty(LRTrim(_paese))) and Empty(LRTrim(_codstares)) */
                if ( ! (CPLib.Empty(CPLib.LRTrim(_paese))) && CPLib.Empty(CPLib.LRTrim(_codstares))) {
                  /* If mcDecodeStati.GoToKey(Upper(LRTrim(_paese))) */
                  if (mcDecodeStati.GoToKey(CPLib.Upper(CPLib.LRTrim(_paese)))) {
                    /* _codstares := mcDecodeStati.CODSTA */
                    _codstares = mcDecodeStati.row.CODSTA;
                  } // End If
                } // End If
                /* If Empty(_codstares) and not(Empty(w_xMARESSDEF)) */
                if (CPLib.Empty(_codstares) &&  ! (CPLib.Empty(w_xMARESSDEF))) {
                  /* _codstares := w_xMARESSDEF */
                  _codstares = w_xMARESSDEF;
                } // End If
                /* If not(Empty(_codstares)) and mcTbstati.GoToKey(LRTrim(_codstares)) */
                if ( ! (CPLib.Empty(_codstares)) && mcTbstati.GoToKey(CPLib.LRTrim(_codstares))) {
                  /* xFLGSAE := LRTrim(mcTbstati.FLGSAE) */
                  xFLGSAE = CPLib.LRTrim(mcTbstati.row.FLGSAE);
                } // End If
              } // End If
              /* _cognomecp := LRTrim(Left(LRTrim(rowLettura.colonna21),100)) */
              _cognomecp = CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna21),100));
              /* _nomecp := LRTrim(Left(LRTrim(rowLettura.colonna22),100)) */
              _nomecp = CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna22),100));
              /* _statodest := Left(LRTrim(rowLettura.colonna23),3) */
              _statodest = CPLib.Left(CPLib.LRTrim(rowLettura.colonna23),3);
              /* _uifdest := '' */
              _uifdest = "";
              for (MemoryCursorRow_tbstati rowStati : mcTbstati._iterable_()) {
                /* If rowStati.ISO=_statodest */
                if (CPLib.eqr(rowStati.ISO,_statodest)) {
                  /* _uifdest := rowStati.CODSTA */
                  _uifdest = rowStati.CODSTA;
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } // End If
              }
              /* If Empty(_uifdest) */
              if (CPLib.Empty(_uifdest)) {
                for (MemoryCursorRow_decodestati rowDecodeStati : mcDecodeStati._iterable_()) {
                  /* If LRTrim(rowDecodeStati.account)=_statodest */
                  if (CPLib.eqr(CPLib.LRTrim(rowDecodeStati.account),_statodest)) {
                    /* _uifdest := rowDecodeStati.CODSTA */
                    _uifdest = rowDecodeStati.CODSTA;
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                }
              } // End If
              /* _datope := CharToDate(Left(LRTrim(rowLettura.colonna14),8)) */
              _datope = CPLib.CharToDate(CPLib.Left(CPLib.LRTrim(rowLettura.colonna14),8));
              /* _impstr := LRTrim(Left(LRTrim(rowLettura.colonna17),15)) */
              _impstr = CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna17),15));
              /* _importo := Val(_impstr) */
              _importo = CPLib.Round(CPLib.Val(_impstr),2);
              /* _impstr := LRTrim(Left(LRTrim(rowLettura.colonna18),15)) */
              _impstr = CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(rowLettura.colonna18),15));
              /* _contanti := Val(_impstr) */
              _contanti = CPLib.Round(CPLib.Val(_impstr),2);
              /* _flgcash := iif(w_xMAFLGBON='S','S','N') */
              _flgcash = (CPLib.eqr(w_xMAFLGBON,"S")?"S":"N");
              /* _tipope := '10' */
              _tipope = "10";
              /* If _datope >= _limite20 */
              if (CPLib.ge(_datope,_limite20)) {
                /* If Left(LRTrim(rowLettura.colonna16),1)='D' */
                if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(rowLettura.colonna16),1),"D")) {
                  /* _codana := 'I9' */
                  _codana = "I9";
                  /* _codsin := '1R' */
                  _codsin = "1R";
                  /* _segno := 'D' */
                  _segno = "D";
                  /* ElseIf Left(LRTrim(rowLettura.colonna16),1)='A' */
                } else if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(rowLettura.colonna16),1),"A")) {
                  /* _codana := 'I8' */
                  _codana = "I8";
                  /* _codsin := '2R' */
                  _codsin = "2R";
                  /* _segno := 'A' */
                  _segno = "A";
                } // End If
              } else { // Else
                /* If Left(LRTrim(rowLettura.colonna16),1)='D' */
                if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(rowLettura.colonna16),1),"D")) {
                  /* _codana := 'I9' */
                  _codana = "I9";
                  /* _codsin := '1M' */
                  _codsin = "1M";
                  /* _segno := 'D' */
                  _segno = "D";
                  /* ElseIf Left(LRTrim(rowLettura.colonna16),1)='A' */
                } else if (CPLib.eqr(CPLib.Left(CPLib.LRTrim(rowLettura.colonna16),1),"A")) {
                  /* _codana := 'I8' */
                  _codana = "I8";
                  /* _codsin := '2M' */
                  _codsin = "2M";
                  /* _segno := 'A' */
                  _segno = "A";
                } // End If
              } // End If
              /* _uniquecode := Left(LRTrim(rowLettura.colonna30),10) */
              _uniquecode = CPLib.Left(CPLib.LRTrim(rowLettura.colonna30),10);
              /* If rowLettura.colonna76='N' */
              if (CPLib.eqr(rowLettura.colonna76,"N")) {
                /* Exec "Controllo dati" Page 5:Page_5 */
                Page_5();
              } else { // Else
                /* _errore := 0 */
                _errore = CPLib.Round(0,0);
                /* _merr := '' */
                _merr = "";
                /* If _nocf=1 and Empty(_codfis) */
                if (CPLib.eqr(_nocf,1) && CPLib.Empty(_codfis)) {
                  /* _oldcodfis := _codfis */
                  _oldcodfis = _codfis;
                  /* If (Empty(_nasstato) and Empty(_nascitta)) or Empty(_nasdata) or Empty(_cognome) or Empty(_nome) or Empty(_sesso) */
                  if ((CPLib.Empty(_nasstato) && CPLib.Empty(_nascitta)) || CPLib.Empty(_nasdata) || CPLib.Empty(_cognome) || CPLib.Empty(_nome) || CPLib.Empty(_sesso)) {
                    /* _err36 := "Mancanza dati per calcolo NDG" */
                    _err36 = "Mancanza dati per calcolo NDG";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                  } else { // Else
                    /* w_CODFISC := '' // Codice Fiscale */
                    w_CODFISC = "";
                    /* w_DATANASC := _nasdata // Data Nascita */
                    w_DATANASC = _nasdata;
                    /* w_NASCOMUN := _nascitta // Luogo di Nascita */
                    w_NASCOMUN = _nascitta;
                    /* w_NASSTATO := _nasstato // Stato di nascita */
                    w_NASSTATO = _nasstato;
                    /* w_COGNOME := _cognome // Ragione Sociale */
                    w_COGNOME = _cognome;
                    /* w_RAGSOC := LRTrim(_cognome)+" "+LRTrim(_nome) // Ragione Sociale */
                    w_RAGSOC = CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome);
                    /* w_NOME := _nome // Ragione Sociale */
                    w_NOME = _nome;
                    /* w_SESSO := iif(_sesso='M','1',iif(_sesso='F','2','')) // Sesso */
                    w_SESSO = (CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":""));
                    /* Exec Routine arrt_calccodfis_wu */
                    arrt_calccodfis_wuR.Make(m_Ctx,this).Run();
                    /* xConnes := w_CODFISC */
                    xConnes = w_CODFISC;
                    /* If Len(LRTrim(xConnes)) < 16 */
                    if (CPLib.lt(CPLib.Len(CPLib.LRTrim(xConnes)),16)) {
                      /* _err38 := "NDG Calcolato - Lunghezza non corretta" */
                      _err38 = "NDG Calcolato - Lunghezza non corretta";
                      /* _esito := 1 */
                      _esito = CPLib.Round(1,0);
                    } // End If
                  } // End If
                  /* ElseIf _nocf=0 */
                } else if (CPLib.eqr(_nocf,0)) {
                  /* If Empty(LRTrim(_codfis)) */
                  if (CPLib.Empty(CPLib.LRTrim(_codfis))) {
                    /* _err37 := "Codice Fiscale Originale assente" */
                    _err37 = "Codice Fiscale Originale assente";
                    /* _esito := 1 */
                    _esito = CPLib.Round(1,0);
                  } else { // Else
                    /* If Len(LRTrim(_codfis)) < 16 */
                    if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_codfis)),16)) {
                      /* _err38 := "Codice Fiscale Originale - Lunghezza non corretta" */
                      _err38 = "Codice Fiscale Originale - Lunghezza non corretta";
                      /* _esito := 1 */
                      _esito = CPLib.Round(1,0);
                    } // End If
                  } // End If
                } // End If
              } // End If
              /* If _esito=1 */
              if (CPLib.eqr(_esito,1)) {
                /* _nerrori := _nerrori + 1 */
                _nerrori = CPLib.Round(_nerrori+1,0);
                /* mcErrate.AppendBlank() */
                mcErrate.AppendBlank();
                /* mcErrate.colonna01 := rowLettura.colonna01 */
                mcErrate.row.colonna01 = rowLettura.colonna01;
                /* mcErrate.colonna02 := rowLettura.colonna02 */
                mcErrate.row.colonna02 = rowLettura.colonna02;
                /* mcErrate.colonna03 := rowLettura.colonna03 */
                mcErrate.row.colonna03 = rowLettura.colonna03;
                /* mcErrate.colonna04 := rowLettura.colonna04 */
                mcErrate.row.colonna04 = rowLettura.colonna04;
                /* mcErrate.colonna05 := rowLettura.colonna05 */
                mcErrate.row.colonna05 = rowLettura.colonna05;
                /* mcErrate.colonna06 := rowLettura.colonna06 */
                mcErrate.row.colonna06 = rowLettura.colonna06;
                /* mcErrate.colonna07 := rowLettura.colonna07 */
                mcErrate.row.colonna07 = rowLettura.colonna07;
                /* mcErrate.colonna08 := rowLettura.colonna08 */
                mcErrate.row.colonna08 = rowLettura.colonna08;
                /* mcErrate.colonna09 := rowLettura.colonna09 */
                mcErrate.row.colonna09 = rowLettura.colonna09;
                /* mcErrate.colonna10 := rowLettura.colonna10 */
                mcErrate.row.colonna10 = rowLettura.colonna10;
                /* mcErrate.colonna11 := rowLettura.colonna11 */
                mcErrate.row.colonna11 = rowLettura.colonna11;
                /* mcErrate.colonna12 := rowLettura.colonna12 */
                mcErrate.row.colonna12 = rowLettura.colonna12;
                /* mcErrate.colonna13 := rowLettura.colonna13 */
                mcErrate.row.colonna13 = rowLettura.colonna13;
                /* mcErrate.colonna14 := rowLettura.colonna14 */
                mcErrate.row.colonna14 = rowLettura.colonna14;
                /* mcErrate.colonna15 := rowLettura.colonna15 */
                mcErrate.row.colonna15 = rowLettura.colonna15;
                /* mcErrate.colonna16 := rowLettura.colonna16 */
                mcErrate.row.colonna16 = rowLettura.colonna16;
                /* mcErrate.colonna17 := rowLettura.colonna17 */
                mcErrate.row.colonna17 = rowLettura.colonna17;
                /* mcErrate.colonna18 := rowLettura.colonna18 */
                mcErrate.row.colonna18 = rowLettura.colonna18;
                /* mcErrate.colonna19 := rowLettura.colonna19 */
                mcErrate.row.colonna19 = rowLettura.colonna19;
                /* mcErrate.colonna20 := rowLettura.colonna20 */
                mcErrate.row.colonna20 = rowLettura.colonna20;
                /* mcErrate.colonna21 := rowLettura.colonna21 */
                mcErrate.row.colonna21 = rowLettura.colonna21;
                /* mcErrate.colonna22 := rowLettura.colonna22 */
                mcErrate.row.colonna22 = rowLettura.colonna22;
                /* mcErrate.colonna23 := rowLettura.colonna23 */
                mcErrate.row.colonna23 = rowLettura.colonna23;
                /* mcErrate.colonna24 := rowLettura.colonna24 */
                mcErrate.row.colonna24 = rowLettura.colonna24;
                /* mcErrate.colonna25 := rowLettura.colonna25 */
                mcErrate.row.colonna25 = rowLettura.colonna25;
                /* mcErrate.colonna26 := rowLettura.colonna26 */
                mcErrate.row.colonna26 = rowLettura.colonna26;
                /* mcErrate.colonna27 := rowLettura.colonna27 */
                mcErrate.row.colonna27 = rowLettura.colonna27;
                /* mcErrate.colonna28 := rowLettura.colonna28 */
                mcErrate.row.colonna28 = rowLettura.colonna28;
                /* mcErrate.colonna29 := rowLettura.colonna29 */
                mcErrate.row.colonna29 = rowLettura.colonna29;
                /* mcErrate.colonna30 := rowLettura.colonna30 */
                mcErrate.row.colonna30 = rowLettura.colonna30;
                /* mcErrate.colonna31 := rowLettura.colonna31 */
                mcErrate.row.colonna31 = rowLettura.colonna31;
                /* mcErrate.colonna32 := rowLettura.colonna32 */
                mcErrate.row.colonna32 = rowLettura.colonna32;
                /* mcErrate.colonna33 := _err01 */
                mcErrate.row.colonna33 = _err01;
                /* mcErrate.colonna34 := _err02 */
                mcErrate.row.colonna34 = _err02;
                /* mcErrate.colonna35 := _err03 */
                mcErrate.row.colonna35 = _err03;
                /* mcErrate.colonna36 := _err04 */
                mcErrate.row.colonna36 = _err04;
                /* mcErrate.colonna37 := _err05 */
                mcErrate.row.colonna37 = _err05;
                /* mcErrate.colonna38 := _err06 */
                mcErrate.row.colonna38 = _err06;
                /* mcErrate.colonna39 := _err07 */
                mcErrate.row.colonna39 = _err07;
                /* mcErrate.colonna40 := _err08 */
                mcErrate.row.colonna40 = _err08;
                /* mcErrate.colonna41 := _err09 */
                mcErrate.row.colonna41 = _err09;
                /* mcErrate.colonna42 := _err10 */
                mcErrate.row.colonna42 = _err10;
                /* mcErrate.colonna43 := _err11 */
                mcErrate.row.colonna43 = _err11;
                /* mcErrate.colonna44 := _err12 */
                mcErrate.row.colonna44 = _err12;
                /* mcErrate.colonna45 := _err13 */
                mcErrate.row.colonna45 = _err13;
                /* mcErrate.colonna46 := _err14 */
                mcErrate.row.colonna46 = _err14;
                /* mcErrate.colonna47 := _err15 */
                mcErrate.row.colonna47 = _err15;
                /* mcErrate.colonna48 := _err16 */
                mcErrate.row.colonna48 = _err16;
                /* mcErrate.colonna49 := _err17 */
                mcErrate.row.colonna49 = _err17;
                /* mcErrate.colonna50 := _err18 */
                mcErrate.row.colonna50 = _err18;
                /* mcErrate.colonna51 := _err19 */
                mcErrate.row.colonna51 = _err19;
                /* mcErrate.colonna52 := _err20 */
                mcErrate.row.colonna52 = _err20;
                /* mcErrate.colonna53 := _err21 */
                mcErrate.row.colonna53 = _err21;
                /* mcErrate.colonna54 := _err22 */
                mcErrate.row.colonna54 = _err22;
                /* mcErrate.colonna55 := _err23 */
                mcErrate.row.colonna55 = _err23;
                /* mcErrate.colonna56 := _err24 */
                mcErrate.row.colonna56 = _err24;
                /* mcErrate.colonna57 := _err25 */
                mcErrate.row.colonna57 = _err25;
                /* mcErrate.colonna58 := _err26 */
                mcErrate.row.colonna58 = _err26;
                /* mcErrate.colonna59 := _err27 */
                mcErrate.row.colonna59 = _err27;
                /* mcErrate.colonna60 := _err28 */
                mcErrate.row.colonna60 = _err28;
                /* mcErrate.colonna61 := _err29 */
                mcErrate.row.colonna61 = _err29;
                /* mcErrate.colonna62 := _err30 */
                mcErrate.row.colonna62 = _err30;
                /* mcErrate.colonna63 := _err31 */
                mcErrate.row.colonna63 = _err31;
                /* mcErrate.colonna64 := _err32 */
                mcErrate.row.colonna64 = _err32;
                /* mcErrate.colonna65 := _err33 */
                mcErrate.row.colonna65 = _err33;
                /* mcErrate.colonna66 := _err34 */
                mcErrate.row.colonna66 = _err34;
                /* mcErrate.colonna67 := _err35 */
                mcErrate.row.colonna67 = _err35;
                /* mcErrate.colonna68 := _err36 */
                mcErrate.row.colonna68 = _err36;
                /* mcErrate.colonna69 := _err37 */
                mcErrate.row.colonna69 = _err37;
                /* mcErrate.colonna70 := _err38 */
                mcErrate.row.colonna70 = _err38;
                /* mcErrate.colonna71 := _err39 */
                mcErrate.row.colonna71 = _err39;
                /* mcErrate.colonna72 := _err40 */
                mcErrate.row.colonna72 = _err40;
                /* mcErrate.colonna73 := _err41 */
                mcErrate.row.colonna73 = _err41;
                /* mcErrate.colonna74 := '' */
                mcErrate.row.colonna74 = "";
                /* mcErrate.SaveRow() */
                mcErrate.SaveRow();
              } else { // Else
                /* If _flgaua = 'N' and _wupos='S' and pAUA='S' and pErrAUI='N' and Left(rowLettura.colonna28,1)='I' */
                if (CPLib.eqr(_flgaua,"N") && CPLib.eqr(_wupos,"S") && CPLib.eqr(pAUA,"S") && CPLib.eqr(pErrAUI,"N") && CPLib.eqr(CPLib.Left(rowLettura.colonna28,1),"I")) {
                  /* _erraua := 0 */
                  _erraua = CPLib.Round(0,0);
                  /* Exec "Controlli AUA" Page 14:Page_14 */
                  Page_14();
                  /* If _esito=1 */
                  if (CPLib.eqr(_esito,1)) {
                    /* _nerraua := _nerraua + 1 */
                    _nerraua = CPLib.Round(_nerraua+1,0);
                    /* _contarig := Utilities.GetAutonumber("PRGRTRA\'"+LRTrim(_azienda)+"'",0,10) */
                    _contarig = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGRTRA\\'"+CPLib.LRTrim(_azienda)+"'",0,10),0);
                    // * --- Insert into wutrxchk from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("wutrxchk");
                    m_cPhName = m_Ctx.GetPhName("wutrxchk");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000008C5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_000008C5(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_contarig,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_cognome,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_nome,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna03,100),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna04,1),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_codfis,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_luonas,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna07,30),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(rowLettura.colonna08,8)),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(rowLettura.colonna09,8)),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna10,50),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna11,50),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna12,50),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna13,2),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Left(rowLettura.colonna14,8)),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna15,1),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna16,1),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Left(rowLettura.colonna17,15)),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Left(rowLettura.colonna18,15)),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna19,10),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna20,10),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna21,100),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna22,100),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna23,100),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna24,10),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_nasdata,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_sesso,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna27,4),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna28,1),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna29,5),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowLettura.colonna30,10),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err01,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err02,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err03,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err04,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err05,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err06,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err07,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err08,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err09,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err10,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err11,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err12,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err13,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err14,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err15,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err16,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err17,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err18,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err19,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err20,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err21,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err22,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err23,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err24,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err25,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err26,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err27,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err28,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err29,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err30,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err31,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err32,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err33,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err34,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err35,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err36,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err37,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err38,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err39,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err40,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_err41,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua01,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua02,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua03,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua04,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua05,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua06,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua07,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua08,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua09,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_aua10,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_nasstato,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_nascitta,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_faua1,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_faua2,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_faua3,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_faua4,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_datamin,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_erraua,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(arfn_datesumR.Make(m_Ctx,this).Run(CPLib.CharToDate(CPLib.Left(rowLettura.colonna14,8)),_ggscad),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(0,"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("O","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(gID,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(_nazrildoc,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wutrxchk",true);
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
                    for (MemoryCursorRow_wutrxchk_cases rowCases : mcCases._iterable_()) {
                      // * --- Insert into wutrxchk_cases from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wutrxchk_cases");
                      m_cPhName = m_Ctx.GetPhName("wutrxchk_cases");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk_cases",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000008C7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_000008C7(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_contarig,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rowCases.TRXCODCASE,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(rowCases.TRXNQUERY,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wutrxchk_cases",true);
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
                  } // End If
                } // End If
              } // End If
              /* If _esito = 0 and pErrAUI='N' */
              if (CPLib.eqr(_esito,0) && CPLib.eqr(pErrAUI,"N")) {
                /* If Left(rowLettura.colonna28,1)='D' */
                if (CPLib.eqr(CPLib.Left(rowLettura.colonna28,1),"D")) {
                  /* If pImpAna='N' */
                  if (CPLib.eqr(pImpAna,"N")) {
                    /* Exec "Cancellazione Transazione" Page 13:Page_13 */
                    Page_13();
                  } // End If
                  /* ElseIf Left(rowLettura.colonna28,1)='M' */
                } else if (CPLib.eqr(CPLib.Left(rowLettura.colonna28,1),"M")) {
                  /* If pImpAna='N' */
                  if (CPLib.eqr(pImpAna,"N")) {
                    /* Exec "Modifica Transazione" Page 7:Page_7 */
                    Page_7();
                  } // End If
                } else { // Else
                  /* _totmovi := _totmovi + 1 */
                  _totmovi = CPLib.Round(_totmovi+1,0);
                  /* _idb2 := LibreriaMit.UniqueId() */
                  _idb2 = LibreriaMit.UniqueId();
                  /* _connes := '' */
                  _connes = "";
                  /* _prov := '' */
                  _prov = "";
                  /* _cab := '' */
                  _cab = "";
                  /* _idb2 := '' */
                  _idb2 = "";
                  /* If mcTbcitta.GoToKey(LRTrim(_citta)) */
                  if (mcTbcitta.GoToKey(CPLib.LRTrim(_citta))) {
                    /* _idb2 := mcTbcitta.IDBASE */
                    _idb2 = mcTbcitta.row.IDBASE;
                    /* _prov := mcTbcitta.PROV */
                    _prov = mcTbcitta.row.PROV;
                    /* _cab := mcTbcitta.CAB */
                    _cab = mcTbcitta.row.CAB;
                  } // End If
                  /* If Empty(LRTrim(_codfis)) and Empty(LRTrim(xConnes))  */
                  if (CPLib.Empty(CPLib.LRTrim(_codfis)) && CPLib.Empty(CPLib.LRTrim(xConnes))) {
                    /* w_CODFISC := '' // Codice Fiscale */
                    w_CODFISC = "";
                    /* w_DATANASC := _nasdata // Data Nascita */
                    w_DATANASC = _nasdata;
                    /* w_NASCOMUN := _nascitta // Luogo di Nascita */
                    w_NASCOMUN = _nascitta;
                    /* w_NASSTATO := _nasstato // Stato di nascita */
                    w_NASSTATO = _nasstato;
                    /* w_COGNOME := _cognome // Ragione Sociale */
                    w_COGNOME = _cognome;
                    /* w_RAGSOC := LRTrim(_cognome)+" "+LRTrim(_nome) // Ragione Sociale */
                    w_RAGSOC = CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome);
                    /* w_NOME := _nome // Ragione Sociale */
                    w_NOME = _nome;
                    /* w_SESSO := iif(_sesso='M','1',iif(_sesso='F','2','')) // Sesso */
                    w_SESSO = (CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":""));
                    /* Exec Routine arrt_calccodfis_wu */
                    arrt_calccodfis_wuR.Make(m_Ctx,this).Run();
                    /* xConnes := w_CODFISC */
                    xConnes = w_CODFISC;
                  } // End If
                  /* mcPersonbo.AppendBlank() // Soggetti */
                  mcPersonbo.AppendBlank();
                  /* mcPersonbo.CONNES := iif(not(Empty(LRTrim(xConnes))),xConnes,_codfis) // Soggetti */
                  mcPersonbo.row.CONNES = ( ! (CPLib.Empty(CPLib.LRTrim(xConnes)))?xConnes:_codfis);
                  /* mcPersonbo.RAGSOC := Left(LRTrim(_cognome)+" "+LRTrim(_nome),70) // Soggetti */
                  mcPersonbo.row.RAGSOC = CPLib.Left(CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome),70);
                  /* mcPersonbo.DOMICILIO := Left(_via,35) // Soggetti */
                  mcPersonbo.row.DOMICILIO = CPLib.Left(_via,35);
                  /* mcPersonbo.CODFISC := iif(_nocf=0,_codfis,'') // Soggetti */
                  mcPersonbo.row.CODFISC = (CPLib.eqr(_nocf,0)?_codfis:"");
                  /* mcPersonbo.DATANASC := _nasdata // Soggetti */
                  mcPersonbo.row.DATANASC = _nasdata;
                  /* mcPersonbo.NASCOMUN := Left(_nascitta,30) // Soggetti */
                  mcPersonbo.row.NASCOMUN = CPLib.Left(_nascitta,30);
                  /* mcPersonbo.SOTGRUP := iif(_codstares='086','600',xFLGSAE) // Soggetti */
                  mcPersonbo.row.SOTGRUP = (CPLib.eqr(_codstares,"086")?"600":xFLGSAE);
                  /* mcPersonbo.RAMOGRUP := '' // Soggetti */
                  mcPersonbo.row.RAMOGRUP = "";
                  /* mcPersonbo.SETTSINT := iif(_codstares='086','600','711') // Soggetti */
                  mcPersonbo.row.SETTSINT = (CPLib.eqr(_codstares,"086")?"600":"711");
                  /* mcPersonbo.TIPODOC := _doctype // Soggetti */
                  mcPersonbo.row.TIPODOC = _doctype;
                  /* mcPersonbo.NUMDOCUM := Left(_numdoc,15) // Soggetti */
                  mcPersonbo.row.NUMDOCUM = CPLib.Left(_numdoc,15);
                  /* mcPersonbo.DATARILASC := _docril // Soggetti */
                  mcPersonbo.row.DATARILASC = _docril;
                  /* mcPersonbo.AUTRILASC := Left(_autril,30) // Soggetti */
                  mcPersonbo.row.AUTRILASC = CPLib.Left(_autril,30);
                  /* mcPersonbo.DESCCIT := Left(_citta,30) // Soggetti */
                  mcPersonbo.row.DESCCIT = CPLib.Left(_citta,30);
                  /* mcPersonbo.PROVINCIA := iif(_codstares='086',Left(_prov,2),'EE') // Soggetti */
                  mcPersonbo.row.PROVINCIA = (CPLib.eqr(_codstares,"086")?CPLib.Left(_prov,2):"EE");
                  /* mcPersonbo.CAP := Left(_cap,5) // Soggetti */
                  mcPersonbo.row.CAP = CPLib.Left(_cap,5);
                  /* mcPersonbo.CODCAB := Left(_cab,6) // Soggetti */
                  mcPersonbo.row.CODCAB = CPLib.Left(_cab,6);
                  /* mcPersonbo.SESSO := iif(_sesso='M','1',iif(_sesso='F','2','')) // Soggetti */
                  mcPersonbo.row.SESSO = (CPLib.eqr(_sesso,"M")?"1":(CPLib.eqr(_sesso,"F")?"2":""));
                  /* mcPersonbo.TIPINTER := Left(_nasprov,2) // Soggetti */
                  mcPersonbo.row.TIPINTER = CPLib.Left(_nasprov,2);
                  /* mcPersonbo.COGNOME := _cognome // Soggetti */
                  mcPersonbo.row.COGNOME = _cognome;
                  /* mcPersonbo.NOME := _nome // Soggetti */
                  mcPersonbo.row.NOME = _nome;
                  /* mcPersonbo.DATAVALI := _docsca // Soggetti */
                  mcPersonbo.row.DATAVALI = _docsca;
                  /* mcPersonbo.NASSTATO := Left(_nasstato,30) // Soggetti */
                  mcPersonbo.row.NASSTATO = CPLib.Left(_nasstato,30);
                  /* mcPersonbo.CFESTERO := _nocf // Soggetti */
                  mcPersonbo.row.CFESTERO = _nocf;
                  /* mcPersonbo.IDFILE := _idfile // Soggetti */
                  mcPersonbo.row.IDFILE = _idfile;
                  /* mcPersonbo.OLDCODFISC := _oldcodfis // Soggetti */
                  mcPersonbo.row.OLDCODFISC = _oldcodfis;
                  /* mcPersonbo.MACROAGENTE := w_codmage // Soggetti */
                  mcPersonbo.row.MACROAGENTE = w_codmage;
                  /* mcPersonbo.PAESE := _codstares // Soggetti */
                  mcPersonbo.row.PAESE = _codstares;
                  /* mcPersonbo.TIPOORO := rowLettura.colonna75 // Soggetti */
                  mcPersonbo.row.TIPOORO = rowLettura.colonna75;
                  /* mcPersonbo.DATASEGN := _datope */
                  mcPersonbo.row.DATASEGN = _datope;
                  /* mcPersonbo.SaveRow() // Soggetti */
                  mcPersonbo.SaveRow();
                  /* mcPersonboAgg.AppendBlank() // Soggetti */
                  mcPersonboAgg.AppendBlank();
                  /* mcPersonboAgg.CONNES := iif(not(Empty(LRTrim(xConnes))),xConnes,_codfis) // Soggetti */
                  mcPersonboAgg.row.CONNES = ( ! (CPLib.Empty(CPLib.LRTrim(xConnes)))?xConnes:_codfis);
                  /* mcPersonboAgg.WUGID := gID // Soggetti */
                  mcPersonboAgg.row.WUGID = gID;
                  /* mcPersonboAgg.WUNAZRILDOC := _nazrildoc // Soggetti */
                  mcPersonboAgg.row.WUNAZRILDOC = _nazrildoc;
                  /* mcPersonboAgg.WUCOGNOME := _cognome // Soggetti */
                  mcPersonboAgg.row.WUCOGNOME = _cognome;
                  /* mcPersonboAgg.WUNOME := _nome // Soggetti */
                  mcPersonboAgg.row.WUNOME = _nome;
                  /* mcPersonboAgg.WULUONAS := _luonas // Soggetti */
                  mcPersonboAgg.row.WULUONAS = _luonas;
                  /* mcPersonboAgg.SaveRow() // Soggetti */
                  mcPersonboAgg.SaveRow();
                  /* _cpers := _cpers + 1 */
                  _cpers = CPLib.Round(_cpers+1,0);
                  /* If pImpAna='N' */
                  if (CPLib.eqr(pImpAna,"N")) {
                    /* _codrap := '' */
                    _codrap = "";
                    /* If w_xMAFLGRAP='S' */
                    if (CPLib.eqr(w_xMAFLGRAP,"S")) {
                      /* Exec "Crea Rapporti" Page 4:Page_4 */
                      Page_4();
                    } // End If
                    /* If w_xMAFLGASR='S' */
                    if (CPLib.eqr(w_xMAFLGASR,"S")) {
                      /* _codrap := _codfis */
                      _codrap = _codfis;
                    } // End If
                    /* _condoc := '' */
                    _condoc = "";
                    // * --- Read from kersonbo
                    m_cServer = m_Ctx.GetServer("kersonbo");
                    m_cPhName = m_Ctx.GetPhName("kersonbo");
                    m_cSql = "";
                    m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(_codfis))?CPLib.LRTrim(xConnes):CPLib.LRTrim(_codfis))+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(CPLib.LRTrim(_numdoc),15),"C",50,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(_codfis))?CPLib.LRTrim(xConnes):CPLib.LRTrim(_codfis))+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(CPLib.LRTrim(_numdoc),15));
                    if (m_Ctx.IsSharedTemp("kersonbo")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      _condoc = Read_Cursor.GetString("CONNES");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on kersonbo into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      _condoc = "";
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(LRTrim(_condoc)) */
                    if (CPLib.Empty(CPLib.LRTrim(_condoc))) {
                      /* _condoc := LRTrim(w_codmage)+"_"+LRTrim(_codfis)+"_"+LRTrim(_doctype)+"_"+Left(LRTrim(_numdoc),15) */
                      _condoc = CPLib.LRTrim(w_codmage)+"_"+CPLib.LRTrim(_codfis)+"_"+CPLib.LRTrim(_doctype)+"_"+CPLib.Left(CPLib.LRTrim(_numdoc),15);
                    } // End If
                    /* mcOperazbo.AppendBlank() */
                    mcOperazbo.AppendBlank();
                    /* mcOperazbo.TIPOINTER := _intertip */
                    mcOperazbo.row.TIPOINTER = _intertip;
                    /* mcOperazbo.ANNOOPE := Year(_datope) */
                    mcOperazbo.row.ANNOOPE = CPLib.Year(_datope);
                    /* mcOperazbo.C_RAG := Left(LRTrim(_cognomecp)+" "+LRTrim(_nomecp),70) */
                    mcOperazbo.row.C_RAG = CPLib.Left(CPLib.LRTrim(_cognomecp)+" "+CPLib.LRTrim(_nomecp),70);
                    /* mcOperazbo.C_STA := _uifdest */
                    mcOperazbo.row.C_STA = _uifdest;
                    /* mcOperazbo.CDATAOPE := DateToChar(_datope) */
                    mcOperazbo.row.CDATAOPE = CPLib.DateToChar(_datope);
                    /* mcOperazbo.CDATOPE := DateToChar(_datope) */
                    mcOperazbo.row.CDATOPE = CPLib.DateToChar(_datope);
                    /* mcOperazbo.CDATREG := DateToChar(Date()) */
                    mcOperazbo.row.CDATREG = CPLib.DateToChar(CPLib.Date());
                    /* mcOperazbo.CODANA := _codana */
                    mcOperazbo.row.CODANA = _codana;
                    /* mcOperazbo.CODCAB := iif(Empty(_cabdip),_intercab,_cabdip) */
                    mcOperazbo.row.CODCAB = (CPLib.Empty(_cabdip)?_intercab:_cabdip);
                    /* mcOperazbo.CODDIPE := _coddip */
                    mcOperazbo.row.CODDIPE = _coddip;
                    /* mcOperazbo.CODINTER := _intercod */
                    mcOperazbo.row.CODINTER = _intercod;
                    /* mcOperazbo.CODVOC := _codsin */
                    mcOperazbo.row.CODVOC = _codsin;
                    /* mcOperazbo.CONNESCLI := iif(not(Empty(LRTrim(xConnes))),xConnes,_codfis) */
                    mcOperazbo.row.CONNESCLI = ( ! (CPLib.Empty(CPLib.LRTrim(xConnes)))?xConnes:_codfis);
                    /* mcOperazbo.CONNESDOC := _condoc */
                    mcOperazbo.row.CONNESDOC = _condoc;
                    /* mcOperazbo.DATAOPE := _datope */
                    mcOperazbo.row.DATAOPE = _datope;
                    /* mcOperazbo.DATAREG := Date() */
                    mcOperazbo.row.DATAREG = CPLib.Date();
                    /* mcOperazbo.DESCCIT := iif(Empty(_citdip),Left(_intercit,30),Left(_citdip,30)) */
                    mcOperazbo.row.DESCCIT = (CPLib.Empty(_citdip)?CPLib.Left(_intercit,30):CPLib.Left(_citdip,30));
                    /* mcOperazbo.FLAGCONT := iif(w_xMAFLGBON='S','0','1') */
                    mcOperazbo.row.FLAGCONT = (CPLib.eqr(w_xMAFLGBON,"S")?"0":"1");
                    /* mcOperazbo.FLAGRAP := iif(Empty(_codrap),'','0') */
                    mcOperazbo.row.FLAGRAP = (CPLib.Empty(_codrap)?"":"0");
                    /* mcOperazbo.IDFILE := _idfile */
                    mcOperazbo.row.IDFILE = _idfile;
                    /* mcOperazbo.IMPOUT := _importo */
                    mcOperazbo.row.IMPOUT = _importo;
                    /* mcOperazbo.MTCN := _uniquecode */
                    mcOperazbo.row.MTCN = _uniquecode;
                    /* mcOperazbo.PROVINCIA := iif(Empty(_provdip),_interprv,_provdip) */
                    mcOperazbo.row.PROVINCIA = (CPLib.Empty(_provdip)?_interprv:_provdip);
                    /* mcOperazbo.RAPPORTO := _codrap */
                    mcOperazbo.row.RAPPORTO = _codrap;
                    /* mcOperazbo.RIFIMP := 'XXXXXXXXX' */
                    mcOperazbo.row.RIFIMP = "XXXXXXXXX";
                    /* mcOperazbo.INFORM := Str(Year(_datope),4,0)+"-"+LRTrim(_uniquecode)+"-"+_segno */
                    mcOperazbo.row.INFORM = CPLib.Str(CPLib.Year(_datope),4,0)+"-"+CPLib.LRTrim(_uniquecode)+"-"+_segno;
                    /* mcOperazbo.SEGNO := _segno */
                    mcOperazbo.row.SEGNO = _segno;
                    /* mcOperazbo.TIPOOPRAP := _tipope */
                    mcOperazbo.row.TIPOOPRAP = _tipope;
                    /* mcOperazbo.TOTCONT := iif(w_xMAFLGBON='S',0,_importo*100) */
                    mcOperazbo.row.TOTCONT = (CPLib.eqr(w_xMAFLGBON,"S")?0:_importo*100);
                    /* mcOperazbo.TOTLIRE := _importo*100 */
                    mcOperazbo.row.TOTLIRE = _importo*100;
                    /* mcOperazbo.UNIQUECODE := _uniquecode */
                    mcOperazbo.row.UNIQUECODE = _uniquecode;
                    /* mcOperazbo.RAGSOC := LRTrim(_cognome)+" "+LRTrim(_nome) // Soggetti */
                    mcOperazbo.row.RAGSOC = CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome);
                    /* mcOperazbo.DOMICILIO := Left(_via,35) // Soggetti */
                    mcOperazbo.row.DOMICILIO = CPLib.Left(_via,35);
                    /* mcOperazbo.TIPODOC := _doctype // Soggetti */
                    mcOperazbo.row.TIPODOC = _doctype;
                    /* mcOperazbo.NUMDOCUM := Left(_numdoc,15) // Soggetti */
                    mcOperazbo.row.NUMDOCUM = CPLib.Left(_numdoc,15);
                    /* mcOperazbo.DATARILASC := _docril // Soggetti */
                    mcOperazbo.row.DATARILASC = _docril;
                    /* mcOperazbo.AUTRILASC := Left(_autril,30) // Soggetti */
                    mcOperazbo.row.AUTRILASC = CPLib.Left(_autril,30);
                    /* mcOperazbo.CLIDESCCIT := Left(_citta,30) // Soggetti */
                    mcOperazbo.row.CLIDESCCIT = CPLib.Left(_citta,30);
                    /* mcOperazbo.CLIPROVINCIA := Left(_prov,2) // Soggetti */
                    mcOperazbo.row.CLIPROVINCIA = CPLib.Left(_prov,2);
                    /* mcOperazbo.CLICAP := Left(_cap,5) // Soggetti */
                    mcOperazbo.row.CLICAP = CPLib.Left(_cap,5);
                    /* mcOperazbo.DATAVALI := _docsca // Soggetti */
                    mcOperazbo.row.DATAVALI = _docsca;
                    /* mcOperazbo.CLIPAESE := _codstares // Soggetti */
                    mcOperazbo.row.CLIPAESE = _codstares;
                    /* mcOperazbo.SaveRow() */
                    mcOperazbo.SaveRow();
                    /* _coper := _coper + 1 */
                    _coper = CPLib.Round(_coper+1,0);
                  } // End If
                } // End If
              } // End If
            } // End If
            /* If At(pModo,'|R|M|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
              /* gMsgImp := 'Sono state elaborate '+LRTrim(Str(conta,10,0))+' su '+ LRTrim(Str(_tottrans,10,0)) + ' transazioni del file '+nomefileimport // Messaggio Import */
              gMsgImp = "Sono state elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_tottrans,10,0))+" transazioni del file "+nomefileimport;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } // End If
            /* If pModo='B' */
            if (CPLib.eqr(pModo,"B")) {
              /* Exec Routine arrt_writelog_imp('IMPORT','','Sono state elaborate '+LRTrim(Str(conta,10,0))+' su '+ LRTrim(Str(_tottrans,10,0)) + ' transazioni del file '+nomefileimport) */
              arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Sono state elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_tottrans,10,0))+" transazioni del file "+nomefileimport);
            } // End If
            /* If At(pModo,'|X|Y') <> 0 */
            if (CPLib.ne(CPLib.At(pModo,"|X|Y"),0)) {
              // * --- Delete from wutrxchk_checked
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wutrxchk_checked");
              m_cPhName = m_Ctx.GetPhName("wutrxchk_checked");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wutrxchk_checked",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"0000094E")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"TRXCODPRG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(rowLettura.colonna74),"?",0,0,m_cServer),m_cServer,CPLib.Val(rowLettura.colonna74))+"";
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
            } // End If
          } // End If
        } else { // Else
          /* _scarti := _scarti + 1 */
          _scarti = CPLib.Round(_scarti+1,0);
        } // End If
      } else { // Else
        /* _nerrori := _nerrori + 1 */
        _nerrori = CPLib.Round(_nerrori+1,0);
        /* mcErrate.AppendBlank() */
        mcErrate.AppendBlank();
        /* mcErrate.colonna01 := rowLettura.colonna01 */
        mcErrate.row.colonna01 = rowLettura.colonna01;
        /* mcErrate.colonna02 := rowLettura.colonna02 */
        mcErrate.row.colonna02 = rowLettura.colonna02;
        /* mcErrate.colonna03 := rowLettura.colonna03 */
        mcErrate.row.colonna03 = rowLettura.colonna03;
        /* mcErrate.colonna04 := rowLettura.colonna04 */
        mcErrate.row.colonna04 = rowLettura.colonna04;
        /* mcErrate.colonna05 := rowLettura.colonna05 */
        mcErrate.row.colonna05 = rowLettura.colonna05;
        /* mcErrate.colonna06 := rowLettura.colonna06 */
        mcErrate.row.colonna06 = rowLettura.colonna06;
        /* mcErrate.colonna07 := rowLettura.colonna07 */
        mcErrate.row.colonna07 = rowLettura.colonna07;
        /* mcErrate.colonna08 := rowLettura.colonna08 */
        mcErrate.row.colonna08 = rowLettura.colonna08;
        /* mcErrate.colonna09 := rowLettura.colonna09 */
        mcErrate.row.colonna09 = rowLettura.colonna09;
        /* mcErrate.colonna10 := rowLettura.colonna10 */
        mcErrate.row.colonna10 = rowLettura.colonna10;
        /* mcErrate.colonna11 := rowLettura.colonna11 */
        mcErrate.row.colonna11 = rowLettura.colonna11;
        /* mcErrate.colonna12 := rowLettura.colonna12 */
        mcErrate.row.colonna12 = rowLettura.colonna12;
        /* mcErrate.colonna13 := rowLettura.colonna13 */
        mcErrate.row.colonna13 = rowLettura.colonna13;
        /* mcErrate.colonna14 := rowLettura.colonna14 */
        mcErrate.row.colonna14 = rowLettura.colonna14;
        /* mcErrate.colonna15 := rowLettura.colonna15 */
        mcErrate.row.colonna15 = rowLettura.colonna15;
        /* mcErrate.colonna16 := rowLettura.colonna16 */
        mcErrate.row.colonna16 = rowLettura.colonna16;
        /* mcErrate.colonna17 := rowLettura.colonna17 */
        mcErrate.row.colonna17 = rowLettura.colonna17;
        /* mcErrate.colonna18 := rowLettura.colonna18 */
        mcErrate.row.colonna18 = rowLettura.colonna18;
        /* mcErrate.colonna19 := rowLettura.colonna19 */
        mcErrate.row.colonna19 = rowLettura.colonna19;
        /* mcErrate.colonna20 := rowLettura.colonna20 */
        mcErrate.row.colonna20 = rowLettura.colonna20;
        /* mcErrate.colonna21 := rowLettura.colonna21 */
        mcErrate.row.colonna21 = rowLettura.colonna21;
        /* mcErrate.colonna22 := rowLettura.colonna22 */
        mcErrate.row.colonna22 = rowLettura.colonna22;
        /* mcErrate.colonna23 := rowLettura.colonna23 */
        mcErrate.row.colonna23 = rowLettura.colonna23;
        /* mcErrate.colonna24 := rowLettura.colonna24 */
        mcErrate.row.colonna24 = rowLettura.colonna24;
        /* mcErrate.colonna25 := rowLettura.colonna25 */
        mcErrate.row.colonna25 = rowLettura.colonna25;
        /* mcErrate.colonna26 := rowLettura.colonna26 */
        mcErrate.row.colonna26 = rowLettura.colonna26;
        /* mcErrate.colonna27 := rowLettura.colonna27 */
        mcErrate.row.colonna27 = rowLettura.colonna27;
        /* mcErrate.colonna28 := rowLettura.colonna28 */
        mcErrate.row.colonna28 = rowLettura.colonna28;
        /* mcErrate.colonna29 := rowLettura.colonna29 */
        mcErrate.row.colonna29 = rowLettura.colonna29;
        /* mcErrate.colonna30 := rowLettura.colonna30 */
        mcErrate.row.colonna30 = rowLettura.colonna30;
        /* mcErrate.colonna31 := rowLettura.colonna31 */
        mcErrate.row.colonna31 = rowLettura.colonna31;
        /* mcErrate.colonna32 := rowLettura.colonna32 */
        mcErrate.row.colonna32 = rowLettura.colonna32;
        /* mcErrate.colonna33 := rowLettura.colonna33 */
        mcErrate.row.colonna33 = rowLettura.colonna33;
        /* mcErrate.colonna34 := rowLettura.colonna34 */
        mcErrate.row.colonna34 = rowLettura.colonna34;
        /* mcErrate.colonna35 := rowLettura.colonna35 */
        mcErrate.row.colonna35 = rowLettura.colonna35;
        /* mcErrate.colonna36 := rowLettura.colonna36 */
        mcErrate.row.colonna36 = rowLettura.colonna36;
        /* mcErrate.colonna37 := rowLettura.colonna37 */
        mcErrate.row.colonna37 = rowLettura.colonna37;
        /* mcErrate.colonna38 := rowLettura.colonna38 */
        mcErrate.row.colonna38 = rowLettura.colonna38;
        /* mcErrate.colonna39 := rowLettura.colonna39 */
        mcErrate.row.colonna39 = rowLettura.colonna39;
        /* mcErrate.colonna40 := rowLettura.colonna40 */
        mcErrate.row.colonna40 = rowLettura.colonna40;
        /* mcErrate.colonna41 := rowLettura.colonna41 */
        mcErrate.row.colonna41 = rowLettura.colonna41;
        /* mcErrate.colonna42 := rowLettura.colonna42 */
        mcErrate.row.colonna42 = rowLettura.colonna42;
        /* mcErrate.colonna43 := rowLettura.colonna43 */
        mcErrate.row.colonna43 = rowLettura.colonna43;
        /* mcErrate.colonna44 := rowLettura.colonna44 */
        mcErrate.row.colonna44 = rowLettura.colonna44;
        /* mcErrate.colonna45 := rowLettura.colonna45 */
        mcErrate.row.colonna45 = rowLettura.colonna45;
        /* mcErrate.colonna46 := rowLettura.colonna46 */
        mcErrate.row.colonna46 = rowLettura.colonna46;
        /* mcErrate.colonna47 := rowLettura.colonna47 */
        mcErrate.row.colonna47 = rowLettura.colonna47;
        /* mcErrate.colonna48 := rowLettura.colonna48 */
        mcErrate.row.colonna48 = rowLettura.colonna48;
        /* mcErrate.colonna49 := rowLettura.colonna49 */
        mcErrate.row.colonna49 = rowLettura.colonna49;
        /* mcErrate.colonna50 := rowLettura.colonna50 */
        mcErrate.row.colonna50 = rowLettura.colonna50;
        /* mcErrate.colonna51 := rowLettura.colonna51 */
        mcErrate.row.colonna51 = rowLettura.colonna51;
        /* mcErrate.colonna52 := rowLettura.colonna52 */
        mcErrate.row.colonna52 = rowLettura.colonna52;
        /* mcErrate.colonna53 := rowLettura.colonna53 */
        mcErrate.row.colonna53 = rowLettura.colonna53;
        /* mcErrate.colonna54 := rowLettura.colonna54 */
        mcErrate.row.colonna54 = rowLettura.colonna54;
        /* mcErrate.colonna55 := rowLettura.colonna55 */
        mcErrate.row.colonna55 = rowLettura.colonna55;
        /* mcErrate.colonna56 := rowLettura.colonna56 */
        mcErrate.row.colonna56 = rowLettura.colonna56;
        /* mcErrate.colonna57 := rowLettura.colonna57 */
        mcErrate.row.colonna57 = rowLettura.colonna57;
        /* mcErrate.colonna58 := rowLettura.colonna58 */
        mcErrate.row.colonna58 = rowLettura.colonna58;
        /* mcErrate.colonna59 := rowLettura.colonna59 */
        mcErrate.row.colonna59 = rowLettura.colonna59;
        /* mcErrate.colonna60 := rowLettura.colonna60 */
        mcErrate.row.colonna60 = rowLettura.colonna60;
        /* mcErrate.colonna61 := rowLettura.colonna61 */
        mcErrate.row.colonna61 = rowLettura.colonna61;
        /* mcErrate.colonna62 := rowLettura.colonna62 */
        mcErrate.row.colonna62 = rowLettura.colonna62;
        /* mcErrate.colonna63 := rowLettura.colonna63 */
        mcErrate.row.colonna63 = rowLettura.colonna63;
        /* mcErrate.colonna64 := rowLettura.colonna64 */
        mcErrate.row.colonna64 = rowLettura.colonna64;
        /* mcErrate.colonna65 := rowLettura.colonna65 */
        mcErrate.row.colonna65 = rowLettura.colonna65;
        /* mcErrate.colonna66 := rowLettura.colonna66 */
        mcErrate.row.colonna66 = rowLettura.colonna66;
        /* mcErrate.colonna67 := rowLettura.colonna67 */
        mcErrate.row.colonna67 = rowLettura.colonna67;
        /* mcErrate.colonna68 := rowLettura.colonna68 */
        mcErrate.row.colonna68 = rowLettura.colonna68;
        /* mcErrate.colonna69 := rowLettura.colonna69 */
        mcErrate.row.colonna69 = rowLettura.colonna69;
        /* mcErrate.colonna70 := rowLettura.colonna70 */
        mcErrate.row.colonna70 = rowLettura.colonna70;
        /* mcErrate.colonna71 := rowLettura.colonna71 */
        mcErrate.row.colonna71 = rowLettura.colonna71;
        /* mcErrate.colonna72 := rowLettura.colonna72 */
        mcErrate.row.colonna72 = rowLettura.colonna72;
        /* mcErrate.SaveRow() */
        mcErrate.SaveRow();
      } // End If
    } finally {
      try {
        if (Cursor_qbe_wuautocorrect!=null)
          Cursor_qbe_wuautocorrect.Close();
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
  void Page_17() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_dersonbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* _contap Numeric(10, 0) */
      double _contap;
      _contap = 0;
      /* _lconnes Char(16) */
      String _lconnes;
      _lconnes = CPLib.Space(16);
      /* _contap := 0 */
      _contap = CPLib.Round(0,0);
      for (MemoryCursorRow_personbo rowPersonbo : mcPersonbo._iterable_()) {
        /* _contap := _contap + 1 */
        _contap = CPLib.Round(_contap+1,0);
        /* If At(pModo,'|R|M|Y') <> 0 */
        if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
          /* gMsgImp := 'Elaboro il soggetto con codice: '+LRTrim(rowPersonbo.CONNES) + " ("+LRTrim(Str(_contap,10,0))+" su "+LRTrim(Str(_cpers,10,0))+")" */
          gMsgImp = "Elaboro il soggetto con codice: "+CPLib.LRTrim(rowPersonbo.CONNES)+" ("+CPLib.LRTrim(CPLib.Str(_contap,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cpers,10,0))+")";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* If pModo='B' */
        if (CPLib.eqr(pModo,"B")) {
          /* Exec Routine arrt_writelog_imp('IMPORT','','Elaboro il soggetto con codice: '+LRTrim(rowPersonbo.CONNES) + " ("+LRTrim(Str(_contap,10,0))+" su "+LRTrim(Str(_cpers,10,0))+")") */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Elaboro il soggetto con codice: "+CPLib.LRTrim(rowPersonbo.CONNES)+" ("+CPLib.LRTrim(CPLib.Str(_contap,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cpers,10,0))+")");
        } // End If
        // * --- Fill memory cursor mcPersonboOld on personbo
        mcPersonboOld.Zap();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowPersonbo.CONNES,"?",0,0,m_cServer, m_oParameters),m_cServer,rowPersonbo.CONNES)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_personbo;
          Cursor_personbo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_imp_dati_rtra: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_personbo.Eof())) {
          mcPersonboOld.AppendBlank();
          mcPersonboOld.row.CONNES = Cursor_personbo.GetString("CONNES");
          mcPersonboOld.row.CODCAB = Cursor_personbo.GetString("CODCAB");
          mcPersonboOld.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
          mcPersonboOld.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
          mcPersonboOld.row.CODFISC = Cursor_personbo.GetString("CODFISC");
          mcPersonboOld.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
          mcPersonboOld.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
          mcPersonboOld.row.SOTGRUP = Cursor_personbo.GetString("SOTGRUP");
          mcPersonboOld.row.RAMOGRUP = Cursor_personbo.GetString("RAMOGRUP");
          mcPersonboOld.row.SETTSINT = Cursor_personbo.GetString("SETTSINT");
          mcPersonboOld.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
          mcPersonboOld.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
          mcPersonboOld.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
          mcPersonboOld.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
          mcPersonboOld.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
          mcPersonboOld.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
          mcPersonboOld.row.PAESE = Cursor_personbo.GetString("PAESE");
          mcPersonboOld.row.CAP = Cursor_personbo.GetString("CAP");
          mcPersonboOld.row.CODINTER = Cursor_personbo.GetString("CODINTER");
          mcPersonboOld.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
          mcPersonboOld.row.TIPOPERS = Cursor_personbo.GetString("TIPOPERS");
          mcPersonboOld.row.CODDIPE = Cursor_personbo.GetString("CODDIPE");
          mcPersonboOld.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
          mcPersonboOld.row.NOTE = Cursor_personbo.GetString("NOTE");
          mcPersonboOld.row.SESSO = Cursor_personbo.GetString("SESSO");
          mcPersonboOld.row.SOSPMAF = Cursor_personbo.GetString("SOSPMAF");
          mcPersonboOld.row.idcitta = Cursor_personbo.GetString("idcitta");
          mcPersonboOld.row.DATAVALI = Cursor_personbo.GetDate("DATAVALI");
          mcPersonboOld.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
          mcPersonboOld.row.DOCFILE = Cursor_personbo.GetString("DOCFILE");
          mcPersonboOld.row.NOME = Cursor_personbo.GetString("NOME");
          mcPersonboOld.row.COGNOME = Cursor_personbo.GetString("COGNOME");
          mcPersonboOld.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
          mcPersonboOld.row.OLDCONNES = Cursor_personbo.GetString("OLDCONNES");
          mcPersonboOld.row.DATEXTRA = Cursor_personbo.GetDate("DATEXTRA");
          mcPersonboOld.row.PKTBSPECIE = Cursor_personbo.GetString("PKTBSPECIE");
          mcPersonboOld.row.COMPORT = Cursor_personbo.GetString("COMPORT");
          mcPersonboOld.row.ATTIV = Cursor_personbo.GetString("ATTIV");
          mcPersonboOld.row.RNATGIU = Cursor_personbo.GetDouble("RNATGIU");
          mcPersonboOld.row.RATTIV = Cursor_personbo.GetDouble("RATTIV");
          mcPersonboOld.row.RCOMP = Cursor_personbo.GetDouble("RCOMP");
          mcPersonboOld.row.RAREA = Cursor_personbo.GetDouble("RAREA");
          mcPersonboOld.row.ALLINEATO = Cursor_personbo.GetDouble("ALLINEATO");
          mcPersonboOld.row.ALLINEATONOMECNOME = Cursor_personbo.GetDouble("ALLINEATONOMECNOME");
          mcPersonboOld.row.RAGSOCOLD = Cursor_personbo.GetString("RAGSOCOLD");
          mcPersonboOld.row.PROGIMPORT = Cursor_personbo.GetDouble("PROGIMPORT");
          mcPersonboOld.row.PROGIMP_C = Cursor_personbo.GetString("PROGIMP_C");
          mcPersonboOld.row.AREAGEO = Cursor_personbo.GetString("AREAGEO");
          mcPersonboOld.row.PEP = Cursor_personbo.GetString("PEP");
          mcPersonboOld.row.IDFILE = Cursor_personbo.GetString("IDFILE");
          mcPersonboOld.row.OLDCODFISC = Cursor_personbo.GetString("OLDCODFISC");
          mcPersonboOld.row.MACROAGENTE = Cursor_personbo.GetString("MACROAGENTE");
          mcPersonboOld.row.SPOTID = Cursor_personbo.GetString("SPOTID");
          mcPersonboOld.row.DATASEGN = Cursor_personbo.GetDate("DATASEGN");
          mcPersonboOld.row.OLDSETSIN = Cursor_personbo.GetString("OLDSETSIN");
          mcPersonboOld.row.DATAVARAGE = Cursor_personbo.GetDate("DATAVARAGE");
          mcPersonboOld.row.SETTSINT2 = Cursor_personbo.GetString("SETTSINT2");
          mcPersonboOld.row.FATCA = Cursor_personbo.GetString("FATCA");
          mcPersonboOld.row.BANCABEN = Cursor_personbo.GetString("BANCABEN");
          mcPersonboOld.row.TIN = Cursor_personbo.GetString("TIN");
          mcPersonboOld.row.ODB = Cursor_personbo.GetDouble("ODB");
          mcPersonboOld.row.TELEF = Cursor_personbo.GetString("TELEF");
          mcPersonboOld.row.TIPOORO = Cursor_personbo.GetString("TIPOORO");
          mcPersonboOld.row.CODORO = Cursor_personbo.GetString("CODORO");
          mcPersonboOld.row.IDNASCOMUN = Cursor_personbo.GetString("IDNASCOMUN");
          mcPersonboOld.row.IDNASSTATO = Cursor_personbo.GetString("IDNASSTATO");
          mcPersonboOld.row.NOTIT = Cursor_personbo.GetDouble("NOTIT");
          mcPersonboOld.row.IDBASE = Cursor_personbo.GetString("IDBASE");
          mcPersonboOld.row.FLGVALIDO = Cursor_personbo.GetString("FLGVALIDO");
          mcPersonboOld.row.CITTADIN1 = Cursor_personbo.GetString("CITTADIN1");
          mcPersonboOld.row.CITTADIN2 = Cursor_personbo.GetString("CITTADIN2");
          mcPersonboOld.row.RESFISC = Cursor_personbo.GetString("RESFISC");
          mcPersonboOld.row.MITIG = Cursor_personbo.GetDouble("MITIG");
          mcPersonboOld.row.MITIGDOC = Cursor_personbo.GetString("MITIGDOC");
          mcPersonboOld.row.NOSARA = Cursor_personbo.GetString("NOSARA");
          mcPersonboOld.row.RISGLOB = Cursor_personbo.GetString("RISGLOB");
          mcPersonboOld.row.DATAPROF = Cursor_personbo.GetDate("DATAPROF");
          mcPersonboOld.row.DATAREVPROF = Cursor_personbo.GetDate("DATAREVPROF");
          mcPersonboOld.row.IDENT = Cursor_personbo.GetString("IDENT");
          mcPersonboOld.row.PEPDATE = Cursor_personbo.GetDate("PEPDATE");
          mcPersonboOld.row.DAC6 = Cursor_personbo.GetString("DAC6");
          mcPersonboOld.row.FLAGDAC6 = Cursor_personbo.GetDouble("FLAGDAC6");
          mcPersonboOld.row.CRIME = Cursor_personbo.GetString("CRIME");
          mcPersonboOld.row.CRIMEDATE = Cursor_personbo.GetDate("CRIMEDATE");
          mcPersonboOld.row.ALTRODOM = Cursor_personbo.GetString("ALTRODOM");
          mcPersonboOld.row.ALTROCAP = Cursor_personbo.GetString("ALTROCAP");
          mcPersonboOld.row.CONTO = Cursor_personbo.GetString("CONTO");
          mcPersonboOld.row.NUMIMP = Cursor_personbo.GetDateTime("NUMIMP");
          mcPersonboOld.row.RAPSEGNA = Cursor_personbo.GetString("RAPSEGNA");
          mcPersonboOld.row.CODLEGRAP = Cursor_personbo.GetString("CODLEGRAP");
          mcPersonboOld.row.TIPOSOGGETTO = Cursor_personbo.GetString("TIPOSOGGETTO");
          mcPersonboOld.row.CAUSALE = Cursor_personbo.GetDouble("CAUSALE");
          mcPersonboOld.row.IMPORTOMAX = Cursor_personbo.GetDouble("IMPORTOMAX");
          mcPersonboOld.row.FATTURATO = Cursor_personbo.GetDouble("FATTURATO");
          mcPersonboOld.row.FREQUENZA = Cursor_personbo.GetString("FREQUENZA");
          mcPersonboOld.row.NUMOPERAZ = Cursor_personbo.GetDouble("NUMOPERAZ");
          mcPersonboOld.row.SOGAFFIDATARIO = Cursor_personbo.GetString("SOGAFFIDATARIO");
          mcPersonboOld.row.FLGNOTRIM = Cursor_personbo.GetString("FLGNOTRIM");
          mcPersonboOld.row.DISATTIVO = Cursor_personbo.GetDate("DISATTIVO");
          mcPersonboOld.row.DATAFINE = Cursor_personbo.GetDate("DATAFINE");
          mcPersonboOld.row.DATAINI = Cursor_personbo.GetDate("DATAINI");
          mcPersonboOld.row.DATAIDENT = Cursor_personbo.GetDate("DATAIDENT");
          mcPersonboOld.row.DATASIGN = Cursor_personbo.GetDate("DATASIGN");
          mcPersonboOld.row.DATARAUT = Cursor_personbo.GetDate("DATARAUT");
          mcPersonboOld.row.VERIFICA = Cursor_personbo.GetString("VERIFICA");
          mcPersonboOld.row.NOTERIS = Cursor_personbo.GetString("NOTERIS");
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        mcPersonboOld.GoTop();
        /* If mcPersonboOld.RecCount() = 0 */
        if (CPLib.eqr(mcPersonboOld.RecCount(),0)) {
          /* _pmaxim := _pmaxim + 1 */
          _pmaxim = CPLib.Round(_pmaxim+1,0);
          /* nProgImp := _pmaxim */
          nProgImp = CPLib.Round(_pmaxim,0);
          /* _connes := rowPersonbo.CONNES */
          _connes = rowPersonbo.CONNES;
          // * --- Insert into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000009AC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000009AC(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CONNES,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.RAGSOC),70),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DOMICILIO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CODFISC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATANASC,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.NASCOMUN,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.SOTGRUP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.RAMOGRUP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.SETTSINT,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.TIPODOC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.NUMDOCUM,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATARILASC,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.AUTRILASC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DESCCIT,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CAP,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.SESSO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATAVALI,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowPersonbo.COGNOME,26),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(rowPersonbo.NOME,25),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.TIPINTER,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CFESTERO,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.NASSTATO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.PROVINCIA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CODCAB,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.IDFILE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.OLDCODFISC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.MACROAGENTE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.PAESE,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nomefileimport),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
          m_cSql = m_cSql+")";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_nUpdatedRows = 0;
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.lt(m_nUpdatedRows,1)) {
            // No rows inserted
            /* gMsgProc := gMsgProc +"PERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+NL */
            gMsgProc = gMsgProc+"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
            gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // Transaction Error
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
            throw new RoutineException(CPLib.FormatMsg(m_Ctx,"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
          } else if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } else { // Else
          for (MemoryCursorRow_personbo rowPersonboOld : mcPersonboOld._iterable_()) {
            /* _connes := rowPersonboOld.CONNES */
            _connes = rowPersonboOld.CONNES;
            /* If not(mcWersonbo.GoToKey(_connes)) */
            if ( ! (mcWersonbo.GoToKey(_connes))) {
              /* _wmaxpg := _wmaxpg + 1 */
              _wmaxpg = CPLib.Round(_wmaxpg+1,0);
              /* cProgSto := Right('000000000000000'+LRTrim(Str(_wmaxpg,15,0)),15) */
              cProgSto = CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(_wmaxpg,15,0)),15);
              // * --- Insert into wersonbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("wersonbo");
              m_cPhName = m_Ctx.GetPhName("wersonbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000009B5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000009B5(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.ALLINEATO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.ALLINEATONOMECNOME,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.AREAGEO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.ATTIV,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.AUTRILASC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.BANCABEN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CAP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CFESTERO,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CITTADIN1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CITTADIN2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CODCAB,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CODDIPE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CODINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CODORO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.COGNOME,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.COMPORT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.CONNES,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.DATANASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.DATARILASC,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.DATASEGN,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.DATAVALI,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.DATAVARAGE,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.DATEXTRA,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.DESCCIT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.DOCFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.DOMICILIO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.FATCA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.FLGVALIDO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.IDBASE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.idcitta,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.IDFILE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.IDNASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.IDNASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.MACROAGENTE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.MITIGDOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.MITIG,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.NASCOMUN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.NASSTATO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.NOME,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.NOTE,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.NOTIT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.NUMDOCUM,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.ODB,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.OLDCODFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.OLDCONNES,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.OLDSETSIN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.PAESE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.PARTIVA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.PKTBSPECIE,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.PROGIMP_C,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.PROGIMPORT,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.PROVINCIA,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.RAGSOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.RAGSOCOLD,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.RAMOGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.RAREA,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.RATTIV,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.RCOMP,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.RESFISC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.RNATGIU,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.SESSO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.SETTSINT,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.SETTSINT2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.SOSPMAF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.SOTGRUP,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.SPOTID,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.TELEF,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.TIN,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.TIPINTER,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.TIPODOC,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.TIPOORO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboOld.TIPOPERS,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_nUpdatedRows = 0;
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.lt(m_nUpdatedRows,1)) {
                // No rows inserted
                /* If At(pModo,'|R|M|Y') <> 0 */
                if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
                  /* gMsgProc := gMsgProc +"WERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                  gMsgProc = gMsgProc+"WERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                } else { // Else
                  /* _gMsgProc := _gMsgProc +"WERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+NL */
                  _gMsgProc = _gMsgProc+"WERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+"\n";
                  /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                  _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                } // End If
                // Transaction Error
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"WERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
                throw new RoutineException(CPLib.FormatMsg(m_Ctx,"WERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
              } else if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
              /* mcWersonbo.AppendWithKey(_connes) // Soggetti che hanno già scritto wersonbo */
              mcWersonbo.AppendWithKey(_connes);
              /* mcWersonbo.CONNES := _connes // Soggetti che hanno già scritto wersonbo */
              mcWersonbo.row.CONNES = _connes;
              /* mcWersonbo.SaveRow() // Soggetti che hanno già scritto wersonbo */
              mcWersonbo.SaveRow();
            } // End If
            // * --- Write into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000009BF")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.RAGSOC),70),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(rowPersonbo.DOMICILIO,"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(rowPersonbo.CODFISC,"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(rowPersonbo.DATANASC,"D",8,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(rowPersonbo.NASCOMUN,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(rowPersonbo.SOTGRUP,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(rowPersonbo.RAMOGRUP,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(rowPersonbo.SETTSINT,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(rowPersonbo.TIPODOC,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(rowPersonbo.NUMDOCUM,"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(rowPersonbo.DATARILASC,"D",8,0)+", ";
            m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(rowPersonbo.AUTRILASC,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(rowPersonbo.DESCCIT,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(rowPersonbo.CAP,"C",9,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(rowPersonbo.SESSO,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(rowPersonbo.DATAVALI,"D",8,0)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL("P","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(rowPersonbo.COGNOME,26),"C",26,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(rowPersonbo.NOME,25),"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(rowPersonbo.TIPINTER,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(rowPersonbo.CFESTERO,"N",1,0)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(rowPersonbo.NASSTATO,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROGIMPORT = "+CPLib.ToSQL(nProgImp,"N",15,0)+", ";
            m_cSql = m_cSql+"PEP = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(rowPersonbo.PROVINCIA,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(rowPersonbo.CODCAB,"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(rowPersonbo.IDFILE,"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"OLDCODFISC = "+CPLib.ToSQL(rowPersonbo.OLDCODFISC,"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"MACROAGENTE = "+CPLib.ToSQL(rowPersonbo.MACROAGENTE,"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(rowPersonbo.PAESE,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(CPLib.LRTrim(nomefileimport),"C",100,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* If At(pModo,'|R|M|Y') <> 0 */
              if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
                /* gMsgProc := gMsgProc +"PERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+NL */
                gMsgProc = gMsgProc+"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                /* _gMsgProc := _gMsgProc +"PERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+NL */
                _gMsgProc = _gMsgProc+"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+"\n";
                /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              } // End If
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"PERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
            }
          }
        } // End If
        /* If rowPersonbo.TIPOORO<>'F' and pImpAna='N' */
        if (CPLib.ne(rowPersonbo.TIPOORO,"F") && CPLib.eqr(pImpAna,"N")) {
          /* _condoc := '' */
          _condoc = "";
          // * --- Select from dersonbo
          m_cServer = m_Ctx.GetServer("dersonbo");
          m_cPhName = m_Ctx.GetPhName("dersonbo");
          if (Cursor_dersonbo!=null)
            Cursor_dersonbo.Close();
          Cursor_dersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNES,TIPODOC,NUMDOCUM  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"TIPODOC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowPersonbo.TIPODOC),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(rowPersonbo.TIPODOC))+"  and  NUMDOCUM="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(CPLib.Left(rowPersonbo.NUMDOCUM,15)),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(CPLib.Left(rowPersonbo.NUMDOCUM,15)))+" "+")"+(m_Ctx.IsSharedTemp("dersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_dersonbo.Eof())) {
            /* If not(Empty(dersonbo->CONNES)) */
            if ( ! (CPLib.Empty(Cursor_dersonbo.GetString("CONNES")))) {
              /* _condoc := dersonbo->CONNES */
              _condoc = Cursor_dersonbo.GetString("CONNES");
              /* ElseIf not(Empty(LRTrim(dersonbo->TIPODOC)+LRTrim(dersonbo->NUMDOCUM))) */
            } else if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_dersonbo.GetString("TIPODOC"))+CPLib.LRTrim(Cursor_dersonbo.GetString("NUMDOCUM"))))) {
              /* _condoc := LRTrim(dersonbo->TIPODOC)+LRTrim(dersonbo->NUMDOCUM) */
              _condoc = CPLib.LRTrim(Cursor_dersonbo.GetString("TIPODOC"))+CPLib.LRTrim(Cursor_dersonbo.GetString("NUMDOCUM"));
            } // End If
            Cursor_dersonbo.Next();
          }
          m_cConnectivityError = Cursor_dersonbo.ErrorMessage();
          Cursor_dersonbo.Close();
          // * --- End Select
          /* If Empty(LRTrim(_condoc)) */
          if (CPLib.Empty(CPLib.LRTrim(_condoc))) {
            // * --- Insert into dersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("dersonbo");
            m_cPhName = m_Ctx.GetPhName("dersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000009CE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000009CE(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rowPersonbo.TIPODOC),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.NUMDOCUM),15),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.Left(rowPersonbo.TIPINTER,2),"EE")?CPLib.Left(rowPersonbo.NASSTATO,50):CPLib.Left(rowPersonbo.NASCOMUN,50)),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((arfn_chkcodfisR.Make(m_Ctx,this).Run(_codfis,"",0)?"S":"N"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATASEGN,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"dersonbo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows inserted
              /* If At(pModo,'|R|M|Y') <> 0 */
              if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
                /* gMsgProc := gMsgProc +"DERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+NL */
                gMsgProc = gMsgProc+"DERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                /* _gMsgProc := _gMsgProc +"DERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+NL */
                _gMsgProc = _gMsgProc+"DERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+"\n";
                /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              } // End If
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"DERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"DERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } else { // Else
            // * --- Write into dersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("dersonbo");
            m_cPhName = m_Ctx.GetPhName("dersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000009D5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CONNES = "+CPLib.ToSQL(_connes,"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(rowPersonbo.RAGSOC,"C",100,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(rowPersonbo.CODFISC,"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(rowPersonbo.SESSO,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(rowPersonbo.DATANASC,"D",8,0)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(rowPersonbo.NASSTATO,"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(rowPersonbo.NASCOMUN,"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(rowPersonbo.TIPINTER,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(rowPersonbo.DATARILASC,"D",8,0)+", ";
            m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(rowPersonbo.DATAVALI,"D",8,0)+", ";
            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(rowPersonbo.NOME,"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(rowPersonbo.COGNOME,"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"LUOGONAS = "+CPLib.ToSQL((CPLib.eqr(CPLib.Left(rowPersonbo.TIPINTER,2),"EE")?CPLib.Left(rowPersonbo.NASSTATO,50):CPLib.Left(rowPersonbo.NASCOMUN,50)),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGCFVALIDO = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"FLGCGFORMAT = "+CPLib.ToSQL((arfn_chkcodfisR.Make(m_Ctx,this).Run(rowPersonbo.CODFISC,"",0)?"S":"N"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATULTOPE = "+CPLib.ToSQL(rowPersonbo.DATASEGN,"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowPersonbo.TIPODOC),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(rowPersonbo.TIPODOC))+"";
            m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.NUMDOCUM),15),"?",0,0,m_cServer),m_cServer,CPLib.Left(CPLib.LRTrim(rowPersonbo.NUMDOCUM),15))+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* If At(pModo,'|R|M|Y') <> 0 */
              if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
                /* gMsgProc := gMsgProc +"DERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+ " (Modifica Dati)" + NL */
                gMsgProc = gMsgProc+"DERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+" (Modifica Dati)"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                /* _gMsgProc := _gMsgProc +"DERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+ " (Modifica Dati)" + NL */
                _gMsgProc = _gMsgProc+"DERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+" (Modifica Dati)"+"\n";
                /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura _di importazione verrà annulata automaticamente."+ NL */
                _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura _di importazione verrà annulata automaticamente."+"\n";
              } // End If
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"DERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"DERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } // End If
          /* _condoc := '' */
          _condoc = "";
          // * --- Read from kersonbo
          m_cServer = m_Ctx.GetServer("kersonbo");
          m_cPhName = m_Ctx.GetPhName("kersonbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowPersonbo.MACROAGENTE)+"_"+rowPersonbo.CONNES+"_"+CPLib.LRTrim(rowPersonbo.TIPODOC)+"_"+CPLib.Left(rowPersonbo.NUMDOCUM,15),"C",50,0,m_cServer),m_cServer,CPLib.LRTrim(rowPersonbo.MACROAGENTE)+"_"+rowPersonbo.CONNES+"_"+CPLib.LRTrim(rowPersonbo.TIPODOC)+"_"+CPLib.Left(rowPersonbo.NUMDOCUM,15));
          if (m_Ctx.IsSharedTemp("kersonbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _condoc = Read_Cursor.GetString("CONNES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on kersonbo into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _condoc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_condoc)) */
          if (CPLib.Empty(CPLib.LRTrim(_condoc))) {
            // * --- Read from kersonbo
            m_cServer = m_Ctx.GetServer("kersonbo");
            m_cPhName = m_Ctx.GetPhName("kersonbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rowPersonbo.CONNES)+"_"+CPLib.LRTrim(rowPersonbo.TIPODOC)+"_"+CPLib.Left(rowPersonbo.NUMDOCUM,15),"C",50,0,m_cServer),m_cServer,CPLib.LRTrim(rowPersonbo.CONNES)+"_"+CPLib.LRTrim(rowPersonbo.TIPODOC)+"_"+CPLib.Left(rowPersonbo.NUMDOCUM,15));
            if (m_Ctx.IsSharedTemp("kersonbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _condoc = Read_Cursor.GetString("CONNES");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on kersonbo into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _condoc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* If Empty(LRTrim(_condoc)) */
          if (CPLib.Empty(CPLib.LRTrim(_condoc))) {
            /* _condoc := LRTrim(rowPersonbo.MACROAGENTE)+"_"+LRTrim(rowPersonbo.CONNES)+"_"+LRTrim(rowPersonbo.TIPODOC)+"_"+Left(LRTrim(rowPersonbo.NUMDOCUM),15) */
            _condoc = CPLib.LRTrim(rowPersonbo.MACROAGENTE)+"_"+CPLib.LRTrim(rowPersonbo.CONNES)+"_"+CPLib.LRTrim(rowPersonbo.TIPODOC)+"_"+CPLib.Left(CPLib.LRTrim(rowPersonbo.NUMDOCUM),15);
            // * --- Insert into kersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("kersonbo");
            m_cPhName = m_Ctx.GetPhName("kersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000009E2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000009E2(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_condoc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.RAGSOC),70),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DOMICILIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATANASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.NASCOMUN,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.SOTGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.RAMOGRUP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.SETTSINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.TIPODOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.NUMDOCUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATARILASC,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.AUTRILASC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DESCCIT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.SESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.DATAVALI,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("P","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.COGNOME),26),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.NOME),25),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.TIPINTER,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CFESTERO,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.NASSTATO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("N","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.PROVINCIA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.CODCAB,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.IDFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.OLDCODFISC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.MACROAGENTE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonbo.PAESE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_datope,"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"kersonbo",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows inserted
              /* If At(pModo,'|R|M|Y') <> 0 */
              if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
                /* gMsgProc := gMsgProc +"KERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+ " (Nuovi Dati)" + NL */
                gMsgProc = gMsgProc+"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+" (Nuovi Dati)"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                /* _gMsgProc := _gMsgProc +"KERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+ " (Nuovi Dati)" + NL */
                _gMsgProc = _gMsgProc+"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+" (Nuovi Dati)"+"\n";
                /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              } // End If
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
          } else { // Else
            // * --- Write into kersonbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("kersonbo");
            m_cPhName = m_Ctx.GetPhName("kersonbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kersonbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000009E9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.RAGSOC),70),"C",70,0,m_cServer)+", ";
            m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(rowPersonbo.DOMICILIO,"C",35,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(rowPersonbo.CODFISC,"C",16,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(rowPersonbo.DATANASC,"D",8,0)+", ";
            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(rowPersonbo.NASCOMUN,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(rowPersonbo.SOTGRUP,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(rowPersonbo.RAMOGRUP,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(rowPersonbo.SETTSINT,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(rowPersonbo.TIPODOC,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(rowPersonbo.NUMDOCUM,"C",15,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(rowPersonbo.DATARILASC,"D",8,0)+", ";
            m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(rowPersonbo.AUTRILASC,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(rowPersonbo.DESCCIT,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(rowPersonbo.CAP,"C",9,0,m_cServer)+", ";
            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(rowPersonbo.SESSO,"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(rowPersonbo.DATAVALI,"D",8,0)+", ";
            m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL("P","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.COGNOME),26),"C",26,0,m_cServer)+", ";
            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(rowPersonbo.NOME),25),"C",25,0,m_cServer)+", ";
            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(rowPersonbo.TIPINTER,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(rowPersonbo.CFESTERO,"N",1,0)+", ";
            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(rowPersonbo.NASSTATO,"C",30,0,m_cServer)+", ";
            m_cSql = m_cSql+"PEP = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(rowPersonbo.PROVINCIA,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(rowPersonbo.CODCAB,"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(rowPersonbo.IDFILE,"C",60,0,m_cServer)+", ";
            m_cSql = m_cSql+"OLDCODFISC = "+CPLib.ToSQL(rowPersonbo.OLDCODFISC,"C",20,0,m_cServer)+", ";
            m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(rowPersonbo.MACROAGENTE,"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(rowPersonbo.PAESE,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"DATULTOPE = "+CPLib.ToSQL(_datope,"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kersonbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_condoc,"?",0,0,m_cServer),m_cServer,_condoc)+"";
            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_nUpdatedRows = 0;
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.lt(m_nUpdatedRows,1)) {
              // No rows updated
              /* If At(pModo,'|R|M|Y') <> 0 */
              if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
                /* gMsgProc := gMsgProc +"KERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+ " (Modifica Dati)" + NL */
                gMsgProc = gMsgProc+"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+" (Modifica Dati)"+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* gMsgProc := gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                gMsgProc = gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              } else { // Else
                /* _gMsgProc := _gMsgProc +"KERSONBO - Rilevati errori nel file "+LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+ " (Modifica Dati)" + NL */
                _gMsgProc = _gMsgProc+"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per il soggetto con NDG: "+rowPersonbo.CONNES+" (Modifica Dati)"+"\n";
                /* _gMsgProc := _gMsgProc +"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+ NL */
                _gMsgProc = _gMsgProc+"Ricreare il file e rieseguire l'import dei dati. L'attuale procedura di importazione verrà annulata automaticamente."+"\n";
              } // End If
              // Transaction Error
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"KERSONBO - Rilevati errori nel file "+CPLib.LRTrim(nomefileimport)+" per l'operazione MTCN "+_uniquecode+""));
            } else if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
              m_cLastMsgError = "Errore in aggiornamento ARCHPERS";
            }
          } // End If
        } // End If
      }
      for (MemoryCursorRow_personbo_agg rowPersonboAgg : mcPersonboAgg._iterable_()) {
        /* _contap := _contap + 1 */
        _contap = CPLib.Round(_contap+1,0);
        /* If At(pModo,'|R|M|Y') <> 0 */
        if (CPLib.ne(CPLib.At(pModo,"|R|M|Y"),0)) {
          /* gMsgImp := 'Elaboro il soggetto con codice: '+LRTrim(rowPersonboAgg.CONNES) */
          gMsgImp = "Elaboro il soggetto con codice: "+CPLib.LRTrim(rowPersonboAgg.CONNES);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* If pModo='B' */
        if (CPLib.eqr(pModo,"B")) {
          /* Exec Routine arrt_writelog_imp('IMPORT','','Elaboro il soggetto con codice: '+LRTrim(rowPersonboAgg.CONNES)) */
          arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","","Elaboro il soggetto con codice: "+CPLib.LRTrim(rowPersonboAgg.CONNES));
        } // End If
        /* _lconnes := '' */
        _lconnes = "";
        // * --- Read from personbo_agg
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowPersonboAgg.CONNES,"C",16,0,m_cServer),m_cServer,rowPersonboAgg.CONNES);
        if (m_Ctx.IsSharedTemp("personbo_agg")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _lconnes = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_imp_dati_rtra returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _lconnes = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(_lconnes) */
        if (CPLib.Empty(_lconnes)) {
          // * --- Insert into personbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000009FA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000009FA(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboAgg.CONNES,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboAgg.WUGID,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboAgg.WUNAZRILDOC,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboAgg.WUCOGNOME,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboAgg.WUNOME,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowPersonboAgg.WULUONAS,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
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
          // * --- Write into personbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_rtra",1671,"000009FB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"WUGID = "+CPLib.ToSQL(rowPersonboAgg.WUGID,"C",20,0,m_cServer)+", ";
          m_cSql = m_cSql+"WUNAZRILDOC = "+CPLib.ToSQL(rowPersonboAgg.WUNAZRILDOC,"C",20,0,m_cServer)+", ";
          m_cSql = m_cSql+"WUCOGNOME = "+CPLib.ToSQL(rowPersonboAgg.WUCOGNOME,"C",50,0,m_cServer)+", ";
          m_cSql = m_cSql+"WUNOME = "+CPLib.ToSQL(rowPersonboAgg.WUNOME,"C",50,0,m_cServer)+", ";
          m_cSql = m_cSql+"WULUONAS = "+CPLib.ToSQL(rowPersonboAgg.WULUONAS,"C",50,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowPersonboAgg.CONNES,"?",0,0,m_cServer),m_cServer,rowPersonboAgg.CONNES)+"";
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
        } // End If
      }
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_dersonbo!=null)
          Cursor_dersonbo.Close();
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
  public String RunAsync(String p_w_tipodest,String p_w_delprec,String p_pAUA,String p_pModo,String p_pTipo,String p_pErrAUI,String p_pImpAna,String p_pNoDG) {
    w_tipodest = p_w_tipodest;
    w_delprec = p_w_delprec;
    pAUA = p_pAUA;
    pModo = p_pModo;
    pTipo = p_pTipo;
    pErrAUI = p_pErrAUI;
    pImpAna = p_pImpAna;
    pNoDG = p_pNoDG;
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
  public String Run(String p_w_tipodest,String p_w_delprec,String p_pAUA,String p_pModo,String p_pTipo,String p_pErrAUI,String p_pImpAna,String p_pNoDG) {
    w_tipodest = p_w_tipodest;
    w_delprec = p_w_delprec;
    pAUA = p_pAUA;
    pModo = p_pModo;
    pTipo = p_pTipo;
    pErrAUI = p_pErrAUI;
    pImpAna = p_pImpAna;
    pNoDG = p_pNoDG;
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
  public static arrt_imp_dati_rtraR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_rtraR(p_Ctx, p_Caller);
  }
  public static arrt_imp_dati_rtraR Make(CPContext p_Ctx) {
    return new arrt_imp_dati_rtraR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_tipodest = CPLib.Space(1);
    w_delprec = CPLib.Space(1);
    pAUA = CPLib.Space(1);
    pModo = CPLib.Space(1);
    pTipo = CPLib.Space(1);
    pErrAUI = CPLib.Space(1);
    pImpAna = CPLib.Space(1);
    pNoDG = CPLib.Space(1);
    _azienda = CPLib.Space(10);
    cProg = CPLib.Space(20);
    w_destfin = CPLib.Space(1);
    _trxdate = CPLib.Space(8);
    fhand = CPLib.Space(1);
    ihand = CPLib.Space(1);
    dhand = CPLib.Space(1);
    xhand = CPLib.Space(1);
    iNomeFile = CPLib.Space(100);
    riga = "";
    _codrap = CPLib.Space(16);
    _luonas = CPLib.Space(50);
    nProg = 0;
    nomefileimport = CPLib.Space(50);
    xConnes = CPLib.Space(16);
    _tdest = CPLib.Space(1);
    _pos = 0;
    _npos = 0;
    _tipoop = CPLib.Space(1);
    _coddip = CPLib.Space(6);
    _uniquecode = CPLib.Space(10);
    _datope = CPLib.NullDate();
    _datmod = CPLib.NullDate();
    _datreal = CPLib.NullDate();
    _datreg = CPLib.NullDate();
    _impstr = CPLib.Space(20);
    _importo = 0;
    _contanti = 0;
    _flgcash = CPLib.Space(1);
    _statodest = CPLib.Space(3);
    _isodest = CPLib.Space(3);
    _cognome = CPLib.Space(50);
    _nome = CPLib.Space(50);
    _citta = CPLib.Space(40);
    _cap = CPLib.Space(5);
    _via = CPLib.Space(35);
    _paese = CPLib.Space(50);
    _prov = CPLib.Space(2);
    _cab = CPLib.Space(6);
    _cognomecp = CPLib.Space(26);
    _nomecp = CPLib.Space(25);
    _pep = CPLib.Space(1);
    _sesso = CPLib.Space(1);
    _nascitta = CPLib.Space(30);
    _nasstato = CPLib.Space(30);
    _resstato = CPLib.Space(3);
    _nasprov = CPLib.Space(2);
    _nasdata = CPLib.NullDate();
    _tipodoc = CPLib.Space(20);
    _numdoc = CPLib.Space(20);
    _docril = CPLib.NullDate();
    _autril = CPLib.Space(30);
    _docsca = CPLib.NullDate();
    _codfis = CPLib.Space(16);
    _connes = CPLib.Space(16);
    cOpeProg1 = CPLib.Space(10);
    cOpeProg2 = CPLib.Space(11);
    nProgImp = 0;
    xSesso = CPLib.Space(1);
    xCAB = CPLib.Space(6);
    xDIP = CPLib.Space(6);
    xDIPx = CPLib.Space(6);
    cCli1 = CPLib.Space(16);
    xIDB = CPLib.Space(10);
    xData = CPLib.Space(8);
    xDatF = CPLib.Space(8);
    _flgbanca = CPLib.Space(1);
    cNumNew = 0;
    cNumMod = 0;
    cNumInv = 0;
    _esito = 0;
    _idbase = CPLib.Space(10);
    _intercod = CPLib.Space(11);
    _intercit = CPLib.Space(30);
    _intercab = CPLib.Space(6);
    _interprv = CPLib.Space(2);
    _doctype = CPLib.Space(2);
    _codana = CPLib.Space(4);
    _codsin = CPLib.Space(2);
    _segno = CPLib.Space(1);
    _uifdest = CPLib.Space(3);
    cProgSto = CPLib.Space(15);
    _prog = CPLib.Space(10);
    _nocf = 0;
    _nocfap = 0;
    _condoc = CPLib.Space(50);
    _idfile = CPLib.Space(60);
    _mage = CPLib.Space(5);
    _oldcodfis = CPLib.Space(20);
    _ocodfis = CPLib.Space(16);
    _dtimport = CPLib.NullDateTime();
    _txtope = "";
    _errore = 0;
    _nerrori = 0;
    _nerraua = 0;
    eProg = 0;
    _codstanas = CPLib.Space(3);
    _codstares = CPLib.Space(3);
    _siglacit = CPLib.Space(4);
    _siglasta = CPLib.Space(4);
    _codcit = CPLib.Space(10);
    _merr = CPLib.Space(100);
    _oldmac = CPLib.Space(5);
    _aggcli = 0;
    _tiperr = CPLib.Space(2);
    _intertip = CPLib.Space(2);
    _listerr = "";
    _tipope = CPLib.Space(2);
    _rapporto = CPLib.Space(25);
    _priga = CPLib.Space(100);
    w_codmage = CPLib.Space(5);
    stringaflagrap2 = CPLib.Space(9);
    _oldidb = CPLib.Space(10);
    _flagrap2 = CPLib.Space(1);
    _idreg = CPLib.Space(20);
    _idb2 = CPLib.Space(10);
    _citdip = CPLib.Space(30);
    _cabdip = CPLib.Space(6);
    _provdip = CPLib.Space(2);
    _id = 0;
    _filename = CPLib.Space(128);
    _dipid = CPLib.Space(6);
    _nfile = CPLib.Space(50);
    _filen = CPLib.Space(50);
    _nerrage = 0;
    _errage = 0;
    mcErrate = new MemoryCursor_mcerratedef_mcrdef();
    rowErrate = new MemoryCursorRow_mcerratedef_mcrdef();
    mcErrAge = new MemoryCursor_mcerratedef_mcrdef();
    mcAgeDuo = new MemoryCursor_mcerratedef_mcrdef();
    mcAgenzie = new MemoryCursor_mcerratedef_mcrdef();
    rowAgenzie = new MemoryCursorRow_mcerratedef_mcrdef();
    _contage = 0;
    _anno = CPLib.Space(4);
    _errorig = 0;
    _ageerr01 = CPLib.Space(80);
    _ageerr02 = CPLib.Space(80);
    _ageerr03 = CPLib.Space(80);
    _ageerr04 = CPLib.Space(80);
    _ageerr05 = CPLib.Space(80);
    _ageerr06 = CPLib.Space(80);
    _ageerr07 = CPLib.Space(80);
    _ageerr08 = CPLib.Space(80);
    _ageerr09 = CPLib.Space(80);
    _colonna1 = CPLib.Space(5);
    _colonna2 = CPLib.Space(10);
    _colonna3 = CPLib.Space(30);
    _colonna4 = CPLib.Space(40);
    _colonna5 = CPLib.Space(30);
    _colonna6 = CPLib.Space(1);
    _flgact = CPLib.Space(1);
    w_xMARESSDEF = CPLib.Space(3);
    mcCases = new MemoryCursor_wutrxchk_cases();
    rowCases = new MemoryCursorRow_wutrxchk_cases();
    _flgaua = CPLib.Space(1);
    _datamin = CPLib.Space(8);
    _datadmin = CPLib.NullDate();
    _connesdoc = CPLib.Space(50);
    _lastdate = CPLib.NullDate();
    _campo1 = CPLib.Space(100);
    _campo2 = CPLib.Space(4);
    _wupos = CPLib.Space(1);
    _omaxid = 0;
    _omaxpg = 0;
    _omaxim = 0;
    _pmaxim = 0;
    _wmaxpg = 0;
    _opxmax = 0;
    _contarig = 0;
    _wuposonly = CPLib.Space(1);
    _tottrans = 0;
    _totmovi = 0;
    _erraua = 0;
    _ggscad = 0;
    _scarti = 0;
    _cpers = 0;
    _coper = 0;
    _idau = 0;
    _gMsgProc = CPLib.Space(0);
    _pathfile = CPLib.Space(120);
    _pathdoc = CPLib.Space(120);
    _filescarti = CPLib.Space(30);
    xFLGSAE = CPLib.Space(3);
    gID = CPLib.Space(20);
    _nazrildoc = CPLib.Space(20);
    _dipcod = CPLib.Space(6);
    _limite20 = CPLib.NullDate();
    w_idmage = CPLib.Space(5);
    w_xMAFLGRAP = CPLib.Space(1);
    w_xMAFLGBON = CPLib.Space(1);
    w_xMAFLGCKR = CPLib.Space(1);
    w_xMAFLGASR = CPLib.Space(1);
    w_xMADIPSTD = CPLib.Space(6);
    w_xMAFLGCHKDAT = CPLib.Space(1);
    w_xMANAIDWU = CPLib.Space(5);
    czipfile = CPLib.Space(100);
    cpercorsozip = CPLib.Space(200);
    cdirectoryfile = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    nomefileorg = CPLib.Space(50);
    _priorita = 0;
    mcMacAge = new MemoryCursor_tbmacage();
    w_CODFISC = CPLib.Space(16);
    w_DATANASC = CPLib.NullDate();
    w_NASCOMUN = CPLib.Space(30);
    w_NASSTATO = CPLib.Space(30);
    w_COGNOME = CPLib.Space(26);
    w_RAGSOC = CPLib.Space(70);
    w_NOME = CPLib.Space(25);
    w_SESSO = CPLib.Space(1);
    riga_letta = 0;
    foglio = 0;
    mcDecodeCitta = new MemoryCursor_decodecitta();
    mcDecodeStati = new MemoryCursor_decodestati();
    mcDecodeNascita = new MemoryCursor_decodenascita();
    mcTbcitta = new MemoryCursor_tbcitta();
    mcTbcittaS = new MemoryCursor_tbcitta();
    mcTbstati = new MemoryCursor_tbstati();
    mcTbstatiD = new MemoryCursor_tbstati();
    mcAnadip = new MemoryCursor_anadip();
    mcStatiN = new MemoryCursor_tbluonas();
    mcNewStati = new MemoryCursor_decodestati();
    mcNewCitta = new MemoryCursor_decodecitta();
    mcNewNascita = new MemoryCursor_decodenascita();
    mcNuove = new MemoryCursor_mcerratedef_mcrdef();
    mcModDel = new MemoryCursor_mcerratedef_mcrdef();
    mcPersonbo = new MemoryCursor_personbo();
    mcPersonboOld = new MemoryCursor_personbo();
    mcOperazbo = new MemoryCursor_tmp_import_rtra();
    mcPersonboAgg = new MemoryCursor_personbo_agg();
    mcWersonbo = new MemoryCursor_tmp_newpers();
    rowLettura = new MemoryCursorRow_mcerratedef_mcrdef();
    mcFiles = new MemoryCursor_mclistafile_mcrdef();
    mcZips = new MemoryCursor_mclistafile_mcrdef();
    mcOperazioni = new MemoryCursor_operazbo();
    _err01 = CPLib.Space(80);
    _err02 = CPLib.Space(80);
    _err03 = CPLib.Space(80);
    _err04 = CPLib.Space(80);
    _err05 = CPLib.Space(80);
    _err06 = CPLib.Space(80);
    _err07 = CPLib.Space(80);
    _err08 = CPLib.Space(80);
    _err09 = CPLib.Space(80);
    _err10 = CPLib.Space(80);
    _err11 = CPLib.Space(80);
    _err12 = CPLib.Space(80);
    _err13 = CPLib.Space(80);
    _err14 = CPLib.Space(80);
    _err15 = CPLib.Space(80);
    _err16 = CPLib.Space(80);
    _err17 = CPLib.Space(80);
    _err18 = CPLib.Space(80);
    _err19 = CPLib.Space(80);
    _err20 = CPLib.Space(80);
    _err21 = CPLib.Space(80);
    _err22 = CPLib.Space(80);
    _err23 = CPLib.Space(80);
    _err24 = CPLib.Space(80);
    _err25 = CPLib.Space(80);
    _err26 = CPLib.Space(80);
    _err27 = CPLib.Space(80);
    _err28 = CPLib.Space(80);
    _err29 = CPLib.Space(80);
    _err30 = CPLib.Space(80);
    _err31 = CPLib.Space(80);
    _err32 = CPLib.Space(80);
    _err33 = CPLib.Space(80);
    _err34 = CPLib.Space(80);
    _err35 = CPLib.Space(80);
    _err36 = CPLib.Space(80);
    _err37 = CPLib.Space(80);
    _err38 = CPLib.Space(80);
    _err39 = CPLib.Space(80);
    _err40 = CPLib.Space(80);
    _err41 = CPLib.Space(80);
    _aua01 = CPLib.Space(80);
    _aua02 = CPLib.Space(80);
    _aua03 = CPLib.Space(80);
    _aua04 = CPLib.Space(80);
    _aua05 = CPLib.Space(80);
    _aua06 = CPLib.Space(80);
    _aua07 = CPLib.Space(80);
    _aua08 = CPLib.Space(80);
    _aua09 = CPLib.Space(80);
    _aua10 = CPLib.Space(80);
    _faua1 = CPLib.Space(1);
    _faua2 = CPLib.Space(1);
    _faua3 = CPLib.Space(1);
    _faua4 = CPLib.Space(1);
    rowAUA1 = new MemoryCursorRow_qbe_rtra_aua_1_vqr();
    rowAUA2 = new MemoryCursorRow_qbe_rtra_aua_2_vqr();
    rowAUA3 = new MemoryCursorRow_qbe_rtra_aua_3_vqr();
    rowAUA4 = new MemoryCursorRow_qbe_rtra_aua_4_vqr();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_decodestati_full,qbe_decodecomuni_full,qbe_decodenascita_full,qbe_rtra_aua_1c,qbe_rtra_aua_2c,qbe_rtra_aua_2c,qbe_rtra_aua_3c,qbe_rtra_aua_4c,qbe_wuautocorrect,qbe_wuautocorrect,
  public static final String m_cVQRList = ",qbe_decodestati_full,qbe_decodecomuni_full,qbe_decodenascita_full,qbe_rtra_aua_1c,qbe_rtra_aua_2c,qbe_rtra_aua_2c,qbe_rtra_aua_3c,qbe_rtra_aua_4c,qbe_wuautocorrect,qbe_wuautocorrect,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_chkcodfis,arfn_dateminus,arfn_datesum,arfn_fdatetime,arfn_omocode,arfn_wu_doctype,arrt_calccodfis_wu,arrt_imp_dati_rtra,arrt_writelog_imp,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_chkcodfis,arfn_dateminus,arfn_datesum,arfn_fdatetime,arfn_omocode,arfn_wu_doctype,arrt_calccodfis_wu,arrt_imp_dati_rtra,arrt_writelog_imp,";
  public static String[] m_cRunParameterNames={"w_tipodest","w_delprec","pAUA","pModo","pTipo","pErrAUI","pImpAna","pNoDG"};
  protected static String GetFieldsName_000001CD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+"LOGFILE,";
    p_cSql = p_cSql+"LOGPATH,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+"LOGFILE,";
    p_cSql = p_cSql+"LOGPATH,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+"LOGFILE,";
    p_cSql = p_cSql+"LOGPATH,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"LOGCODICE,";
    p_cSql = p_cSql+"LOGDATORA,";
    p_cSql = p_cSql+"LOGUTENTE,";
    p_cSql = p_cSql+"LOGTIPOPE,";
    p_cSql = p_cSql+"LOGTESTO,";
    p_cSql = p_cSql+"LOGTABELLA,";
    p_cSql = p_cSql+"LOGCHIAVE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"log_app",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000216(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CITTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"DecodeCitta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000021B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"account,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"DecodeStati",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000220(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"account,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"DecodeNascita",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000232(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MTCODMAGE,";
    p_cSql = p_cSql+"MTNOMFIL,";
    p_cSql = p_cSql+"MTDATIMP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mtimport",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000282(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RWMACAGE,";
    p_cSql = p_cSql+"RWCODRAP,";
    p_cSql = p_cSql+"RWCODFIS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wurapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000284(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000285(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000289(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000028B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000028F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RWMACAGE,";
    p_cSql = p_cSql+"RWCODRAP,";
    p_cSql = p_cSql+"RWCODFIS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wurapporti",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000291(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"MACODICE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000292(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000296(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPINF,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"rapopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000298(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"COLLEGAMEN,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000428(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODDIP,";
    p_cSql = p_cSql+"DESCRIZ,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"AGENTE,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"AGACCODE,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"IDCITTA,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"TIPOSV,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anadip",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000446(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CITTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"DecodeCitta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000046E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"WUDATRET,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000046F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000477(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODLOB,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"IDBIGLIETTO,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CATIPGIO,";
    p_cSql = p_cSql+"CATIPCON,";
    p_cSql = p_cSql+"CAPV_COD,";
    p_cSql = p_cSql+"IDDOCALL,";
    p_cSql = p_cSql+"VPCODICE,";
    p_cSql = p_cSql+"CATEG01,";
    p_cSql = p_cSql+"CATEG02,";
    p_cSql = p_cSql+"CATEG03,";
    p_cSql = p_cSql+"CATEG04,";
    p_cSql = p_cSql+"CATEG05,";
    p_cSql = p_cSql+"CATEGORIA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000491(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xperazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000499(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"xocopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004A3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004AB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"docopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004BA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004C9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000004D8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000560(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000007D4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"AUCOGNOM,";
    p_cSql = p_cSql+"AUNOME,";
    p_cSql = p_cSql+"AULUONAS,";
    p_cSql = p_cSql+"AUDATNAS,";
    p_cSql = p_cSql+"AUSESSO,";
    p_cSql = p_cSql+"AUTIPDOC,";
    p_cSql = p_cSql+"AUNUMDOC,";
    p_cSql = p_cSql+"AUOCOGNOM,";
    p_cSql = p_cSql+"AUONOME,";
    p_cSql = p_cSql+"AUOLUONAS,";
    p_cSql = p_cSql+"AUODATNAS,";
    p_cSql = p_cSql+"AUOSESSO,";
    p_cSql = p_cSql+"AUOTIPDOC,";
    p_cSql = p_cSql+"AUONUMDOC,";
    p_cSql = p_cSql+"AUCODFISC,";
    p_cSql = p_cSql+"AUOCODFISC,";
    p_cSql = p_cSql+"DCORRECTION,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wuautocorrect_mtcn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000080D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"AUCOGNOM,";
    p_cSql = p_cSql+"AUNOME,";
    p_cSql = p_cSql+"AULUONAS,";
    p_cSql = p_cSql+"AUDATNAS,";
    p_cSql = p_cSql+"AUSESSO,";
    p_cSql = p_cSql+"AUTIPDOC,";
    p_cSql = p_cSql+"AUNUMDOC,";
    p_cSql = p_cSql+"AUOCOGNOM,";
    p_cSql = p_cSql+"AUONOME,";
    p_cSql = p_cSql+"AUOLUONAS,";
    p_cSql = p_cSql+"AUODATNAS,";
    p_cSql = p_cSql+"AUOSESSO,";
    p_cSql = p_cSql+"AUOTIPDOC,";
    p_cSql = p_cSql+"AUONUMDOC,";
    p_cSql = p_cSql+"AUCODFISC,";
    p_cSql = p_cSql+"AUOCODFISC,";
    p_cSql = p_cSql+"DCORRECTION,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wuautocorrect_mtcn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000008C5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TRXCODPRG,";
    p_cSql = p_cSql+"TRXCOGNOM,";
    p_cSql = p_cSql+"TRXNOME,";
    p_cSql = p_cSql+"TRXDOMICI,";
    p_cSql = p_cSql+"TRXFLGCF,";
    p_cSql = p_cSql+"TRXCODFIS,";
    p_cSql = p_cSql+"TRXLUONAS,";
    p_cSql = p_cSql+"TRXNUMDOC,";
    p_cSql = p_cSql+"TRXDATSCA,";
    p_cSql = p_cSql+"TRXDATRIL,";
    p_cSql = p_cSql+"TRXAUTRIL,";
    p_cSql = p_cSql+"TRXNAZRES,";
    p_cSql = p_cSql+"TRXCITRES,";
    p_cSql = p_cSql+"TRXTIPDOC,";
    p_cSql = p_cSql+"TRXDATOPE,";
    p_cSql = p_cSql+"TRXFLGCON,";
    p_cSql = p_cSql+"TRSSEGNO,";
    p_cSql = p_cSql+"TRXIMPORTO,";
    p_cSql = p_cSql+"TRXCONTAN,";
    p_cSql = p_cSql+"TRXUNIQUE,";
    p_cSql = p_cSql+"TRXCODDIP,";
    p_cSql = p_cSql+"TRXCOGCON,";
    p_cSql = p_cSql+"TRXNOMCON,";
    p_cSql = p_cSql+"TRXDESTIN,";
    p_cSql = p_cSql+"TRXMTCN,";
    p_cSql = p_cSql+"TRXDATNAS,";
    p_cSql = p_cSql+"TRXSESSO,";
    p_cSql = p_cSql+"TRXCODCAS,";
    p_cSql = p_cSql+"TRXRECTYPE,";
    p_cSql = p_cSql+"TRXCODMAG,";
    p_cSql = p_cSql+"TRXCODUNI,";
    p_cSql = p_cSql+"TRXERROR01,";
    p_cSql = p_cSql+"TRXERROR02,";
    p_cSql = p_cSql+"TRXERROR03,";
    p_cSql = p_cSql+"TRXERROR04,";
    p_cSql = p_cSql+"TRXERROR05,";
    p_cSql = p_cSql+"TRXERROR06,";
    p_cSql = p_cSql+"TRXERROR07,";
    p_cSql = p_cSql+"TRXERROR08,";
    p_cSql = p_cSql+"TRXERROR09,";
    p_cSql = p_cSql+"TRXERROR10,";
    p_cSql = p_cSql+"TRXERROR11,";
    p_cSql = p_cSql+"TRXERROR12,";
    p_cSql = p_cSql+"TRXERROR13,";
    p_cSql = p_cSql+"TRXERROR14,";
    p_cSql = p_cSql+"TRXERROR15,";
    p_cSql = p_cSql+"TRXERROR16,";
    p_cSql = p_cSql+"TRXERROR17,";
    p_cSql = p_cSql+"TRXERROR18,";
    p_cSql = p_cSql+"TRXERROR19,";
    p_cSql = p_cSql+"TRXERROR20,";
    p_cSql = p_cSql+"TRXERROR21,";
    p_cSql = p_cSql+"TRXERROR22,";
    p_cSql = p_cSql+"TRXERROR23,";
    p_cSql = p_cSql+"TRXERROR24,";
    p_cSql = p_cSql+"TRXERROR25,";
    p_cSql = p_cSql+"TRXERROR26,";
    p_cSql = p_cSql+"TRXERROR27,";
    p_cSql = p_cSql+"TRXERROR28,";
    p_cSql = p_cSql+"TRXERROR29,";
    p_cSql = p_cSql+"TRXERROR30,";
    p_cSql = p_cSql+"TRXERROR31,";
    p_cSql = p_cSql+"TRXERROR32,";
    p_cSql = p_cSql+"TRXERROR33,";
    p_cSql = p_cSql+"TRXERROR34,";
    p_cSql = p_cSql+"TRXERROR35,";
    p_cSql = p_cSql+"TRXERROR36,";
    p_cSql = p_cSql+"TRXERROR37,";
    p_cSql = p_cSql+"TRXERROR38,";
    p_cSql = p_cSql+"TRXERROR39,";
    p_cSql = p_cSql+"TRXERROR40,";
    p_cSql = p_cSql+"TRXERROR41,";
    p_cSql = p_cSql+"TRXFLGAUI,";
    p_cSql = p_cSql+"TRXFLGAUA,";
    p_cSql = p_cSql+"TRXFLGFOR,";
    p_cSql = p_cSql+"TRXAUICHK,";
    p_cSql = p_cSql+"TRXAUACHK,";
    p_cSql = p_cSql+"TRXERRAUA01,";
    p_cSql = p_cSql+"TRXERRAUA02,";
    p_cSql = p_cSql+"TRXERRAUA03,";
    p_cSql = p_cSql+"TRXERRAUA04,";
    p_cSql = p_cSql+"TRXERRAUA05,";
    p_cSql = p_cSql+"TRXERRAUA06,";
    p_cSql = p_cSql+"TRXERRAUA07,";
    p_cSql = p_cSql+"TRXERRAUA08,";
    p_cSql = p_cSql+"TRXERRAUA09,";
    p_cSql = p_cSql+"TRXERRAUA10,";
    p_cSql = p_cSql+"TRXNASSTATO,";
    p_cSql = p_cSql+"TRXNASCOMUN,";
    p_cSql = p_cSql+"TRXFLGAUAQ1,";
    p_cSql = p_cSql+"TRXFLGAUAQ2,";
    p_cSql = p_cSql+"TRXFLGAUAQ3,";
    p_cSql = p_cSql+"TRXFLGAUAQ4,";
    p_cSql = p_cSql+"TRXDATRICERCA,";
    p_cSql = p_cSql+"TRXNUMRIL,";
    p_cSql = p_cSql+"TRXSCAEDT,";
    p_cSql = p_cSql+"TRFLGINLAV,";
    p_cSql = p_cSql+"TRXUTENTE,";
    p_cSql = p_cSql+"TRXESITO,";
    p_cSql = p_cSql+"TRXDERIVATA,";
    p_cSql = p_cSql+"TRXGALACTIC,";
    p_cSql = p_cSql+"TRXNAZRIL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wutrxchk",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000008C7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TRXCODICE,";
    p_cSql = p_cSql+"TRXCODCASE,";
    p_cSql = p_cSql+"TRXNQUERY,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wutrxchk_cases",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000009AC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000009B5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
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
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DATAVARAGE,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FATCA,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IDNASCOMUN,";
    p_cSql = p_cSql+"IDNASSTATO,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NOTIT,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"ODB,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PARTIVA,";
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
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"sanumpro,";
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000009CE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"LUOGONAS,";
    p_cSql = p_cSql+"FLGCFVALIDO,";
    p_cSql = p_cSql+"FLGCGFORMAT,";
    p_cSql = p_cSql+"FLGCIEUROPA,";
    p_cSql = p_cSql+"FLGDISABLED,";
    p_cSql = p_cSql+"DATULTOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"dersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000009E2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DATULTOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"kersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000009FA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"WUGID,";
    p_cSql = p_cSql+"WUNAZRILDOC,";
    p_cSql = p_cSql+"WUCOGNOME,";
    p_cSql = p_cSql+"WUNOME,";
    p_cSql = p_cSql+"WULUONAS,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
}
