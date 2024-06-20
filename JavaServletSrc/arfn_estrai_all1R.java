// * --- Area Manuale = BO - Header
// * --- arfn_estrai_all1
import java.io.InputStream;
import java.io.File; 
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.text.SimpleDateFormat;

import java.util.Iterator;

import java.lang.Double;
import java.util.ArrayList;

//Per la lettura di un csv
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
//import java.io.File;

import org.apache.poi.xssf.streaming.SXSSFRow;
// XLSX

//import org.apache.poi.xssf.streaming.SXSSFCell;
//import org.apache.poi.xssf.streaming.SXSSFSheet;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;

// XLSX con flush ciclato
//import junit.framework.Assert;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

// * --- Fine Area Manuale
public class arfn_estrai_all1R implements CallerWithObjs {
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
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  public String m_cPhName_dersonbo;
  public String m_cServer_dersonbo;
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
  public java.sql.Date w_DaData;
  public java.sql.Date w_AData;
  public String w_codage;
  public String w_codcli;
  public String w_rapporto;
  public String w_flgope;
  public String w_flgrap;
  public String w_flgfrz;
  public String w_flgordine;
  public String w_stoper;
  public String w_tipout;
  public String w_rappAttivSel;
  public String gPathApp;
  public String gPathDoc;
  public String gIntemediario;
  public String gTipInter;
  public String gUrlApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
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
  public String nomefoglio;
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
  public String _tiprec;
  public String _raeatc;
  public String oldfolder;
  public String _tipoag;
  public String _datage;
  public String _numticket;
  public String w_cdareg;
  public String w_c_areg;
  public String z_desccit;
  public String z_codcab;
  public String z_provin;
  public String z_coddipe;
  public String _idb;
  public String _connescli;
  public String _connaltro;
  public java.sql.Date _datastorico;
  public String _statooperazione;
  public java.sql.Date _datarettifica;
  public String _tipoperazione;
  public String _rapporto_check;
  public String _codcli_check;
  public String _testo;
  public java.sql.Timestamp _dateTimeNow;
  public String _data_ora;
  public MemoryCursor_anadip mcANADIP;
  public MemoryCursor_mcoperazioniall1_mcrdef mcOPERAZIONI;
  public MemoryCursorRow_mcoperazioniall1_mcrdef rwOPE;
  public MemoryCursor_mcsoggettiall1_mcrdef mcSOGGETTI;
  public MemoryCursorRow_mcsoggettiall1_mcrdef rwSOG;
  public MemoryCursor_mcrapportoall1_mcrdef mcRAPPORTO;
  public MemoryCursorRow_mcrapportoall1_mcrdef rwRAP;
  public MemoryCursor_mcanarap_mcrdef mcANARAP;
  public MemoryCursor_mcanarap_mcrdef mcANARAP_APP;
  public MemoryCursorRow_mcanarap_mcrdef rwANARAP;
  public MemoryCursor_rapopebo mcRAPOPEBO;
  public String w_ragben;
  public MemoryCursor_intestbo mcINTESTBO;
  public MemoryCursor_intestit mcINTESTIT;
  public MemoryCursor_fiduciabo mcFIDUCIABO;
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
  public String pCodDip;
  public String pCodCabFil;
  public String pCodCab;
  public String pDesCit;
  public String pProv;
  public String _dataOpe;
  public String _dataNascita;
  public String _dataNascitaEse;
  public String _dataApert;
  public String _dataChiu;
  public String _dataIniSogg;
  public String _dataFinSogg;
  public String _dataNascSogg;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_estrai_all1
  public int _cnt;
  Row row; 
  Cell cell;
  public List<String> filename_path= new ArrayList<String>();
  public List<String> filename = new ArrayList<String>();
  // * --- Fine Area Manuale
  public arfn_estrai_all1R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_estrai_all1",m_Caller);
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
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    if (m_cPhName_soginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_soginfo = m_cPhName_soginfo+" "+m_Ctx.GetWritePhName("soginfo");
    }
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    m_cPhName_dersonbo = p_ContextObject.GetPhName("dersonbo");
    if (m_cPhName_dersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dersonbo = m_cPhName_dersonbo+" "+m_Ctx.GetWritePhName("dersonbo");
    }
    m_cServer_dersonbo = p_ContextObject.GetServer("dersonbo");
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_estrai_all1";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("codage",p_cVarName)) {
      return w_codage;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      return w_codcli;
    }
    if (CPLib.eqr("rapporto",p_cVarName)) {
      return w_rapporto;
    }
    if (CPLib.eqr("flgope",p_cVarName)) {
      return w_flgope;
    }
    if (CPLib.eqr("flgrap",p_cVarName)) {
      return w_flgrap;
    }
    if (CPLib.eqr("flgfrz",p_cVarName)) {
      return w_flgfrz;
    }
    if (CPLib.eqr("flgordine",p_cVarName)) {
      return w_flgordine;
    }
    if (CPLib.eqr("stoper",p_cVarName)) {
      return w_stoper;
    }
    if (CPLib.eqr("tipout",p_cVarName)) {
      return w_tipout;
    }
    if (CPLib.eqr("rappAttivSel",p_cVarName)) {
      return w_rappAttivSel;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
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
    if (CPLib.eqr("nomefoglio",p_cVarName)) {
      return nomefoglio;
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
    if (CPLib.eqr("z_desccit",p_cVarName)) {
      return z_desccit;
    }
    if (CPLib.eqr("z_codcab",p_cVarName)) {
      return z_codcab;
    }
    if (CPLib.eqr("z_provin",p_cVarName)) {
      return z_provin;
    }
    if (CPLib.eqr("z_coddipe",p_cVarName)) {
      return z_coddipe;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
    }
    if (CPLib.eqr("_connescli",p_cVarName)) {
      return _connescli;
    }
    if (CPLib.eqr("_connaltro",p_cVarName)) {
      return _connaltro;
    }
    if (CPLib.eqr("_statooperazione",p_cVarName)) {
      return _statooperazione;
    }
    if (CPLib.eqr("_tipoperazione",p_cVarName)) {
      return _tipoperazione;
    }
    if (CPLib.eqr("_rapporto_check",p_cVarName)) {
      return _rapporto_check;
    }
    if (CPLib.eqr("_codcli_check",p_cVarName)) {
      return _codcli_check;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      return _testo;
    }
    if (CPLib.eqr("_data_ora",p_cVarName)) {
      return _data_ora;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      return w_ragben;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      return pCodDip;
    }
    if (CPLib.eqr("pCodCabFil",p_cVarName)) {
      return pCodCabFil;
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
    if (CPLib.eqr("_dataOpe",p_cVarName)) {
      return _dataOpe;
    }
    if (CPLib.eqr("_dataNascita",p_cVarName)) {
      return _dataNascita;
    }
    if (CPLib.eqr("_dataNascitaEse",p_cVarName)) {
      return _dataNascitaEse;
    }
    if (CPLib.eqr("_dataApert",p_cVarName)) {
      return _dataApert;
    }
    if (CPLib.eqr("_dataChiu",p_cVarName)) {
      return _dataChiu;
    }
    if (CPLib.eqr("_dataIniSogg",p_cVarName)) {
      return _dataIniSogg;
    }
    if (CPLib.eqr("_dataFinSogg",p_cVarName)) {
      return _dataFinSogg;
    }
    if (CPLib.eqr("_dataNascSogg",p_cVarName)) {
      return _dataNascSogg;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      return w_DaData;
    }
    if (CPLib.eqr("AData",p_cVarName)) {
      return w_AData;
    }
    if (CPLib.eqr("_datastorico",p_cVarName)) {
      return _datastorico;
    }
    if (CPLib.eqr("_datarettifica",p_cVarName)) {
      return _datarettifica;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dateTimeNow",p_cVarName)) {
      return _dateTimeNow;
    }
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
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcANADIP",p_cVarName)) {
      return mcANADIP;
    }
    if (CPLib.eqr("mcOPERAZIONI",p_cVarName)) {
      return mcOPERAZIONI;
    }
    if (CPLib.eqr("mcSOGGETTI",p_cVarName)) {
      return mcSOGGETTI;
    }
    if (CPLib.eqr("mcRAPPORTO",p_cVarName)) {
      return mcRAPPORTO;
    }
    if (CPLib.eqr("mcANARAP",p_cVarName)) {
      return mcANARAP;
    }
    if (CPLib.eqr("mcANARAP_APP",p_cVarName)) {
      return mcANARAP_APP;
    }
    if (CPLib.eqr("mcRAPOPEBO",p_cVarName)) {
      return mcRAPOPEBO;
    }
    if (CPLib.eqr("mcINTESTBO",p_cVarName)) {
      return mcINTESTBO;
    }
    if (CPLib.eqr("mcINTESTIT",p_cVarName)) {
      return mcINTESTIT;
    }
    if (CPLib.eqr("mcFIDUCIABO",p_cVarName)) {
      return mcFIDUCIABO;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rwOPE",p_cVarName)) {
      return rwOPE;
    }
    if (CPLib.eqr("rwSOG",p_cVarName)) {
      return rwSOG;
    }
    if (CPLib.eqr("rwRAP",p_cVarName)) {
      return rwRAP;
    }
    if (CPLib.eqr("rwANARAP",p_cVarName)) {
      return rwANARAP;
    }
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("codage",p_cVarName)) {
      w_codage = value;
      return;
    }
    if (CPLib.eqr("codcli",p_cVarName)) {
      w_codcli = value;
      return;
    }
    if (CPLib.eqr("rapporto",p_cVarName)) {
      w_rapporto = value;
      return;
    }
    if (CPLib.eqr("flgope",p_cVarName)) {
      w_flgope = value;
      return;
    }
    if (CPLib.eqr("flgrap",p_cVarName)) {
      w_flgrap = value;
      return;
    }
    if (CPLib.eqr("flgfrz",p_cVarName)) {
      w_flgfrz = value;
      return;
    }
    if (CPLib.eqr("flgordine",p_cVarName)) {
      w_flgordine = value;
      return;
    }
    if (CPLib.eqr("stoper",p_cVarName)) {
      w_stoper = value;
      return;
    }
    if (CPLib.eqr("tipout",p_cVarName)) {
      w_tipout = value;
      return;
    }
    if (CPLib.eqr("rappAttivSel",p_cVarName)) {
      w_rappAttivSel = value;
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
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
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
    if (CPLib.eqr("nomefoglio",p_cVarName)) {
      nomefoglio = value;
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
    if (CPLib.eqr("z_desccit",p_cVarName)) {
      z_desccit = value;
      return;
    }
    if (CPLib.eqr("z_codcab",p_cVarName)) {
      z_codcab = value;
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
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
      return;
    }
    if (CPLib.eqr("_connescli",p_cVarName)) {
      _connescli = value;
      return;
    }
    if (CPLib.eqr("_connaltro",p_cVarName)) {
      _connaltro = value;
      return;
    }
    if (CPLib.eqr("_statooperazione",p_cVarName)) {
      _statooperazione = value;
      return;
    }
    if (CPLib.eqr("_tipoperazione",p_cVarName)) {
      _tipoperazione = value;
      return;
    }
    if (CPLib.eqr("_rapporto_check",p_cVarName)) {
      _rapporto_check = value;
      return;
    }
    if (CPLib.eqr("_codcli_check",p_cVarName)) {
      _codcli_check = value;
      return;
    }
    if (CPLib.eqr("_testo",p_cVarName)) {
      _testo = value;
      return;
    }
    if (CPLib.eqr("_data_ora",p_cVarName)) {
      _data_ora = value;
      return;
    }
    if (CPLib.eqr("ragben",p_cVarName)) {
      w_ragben = value;
      return;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      pCodDip = value;
      return;
    }
    if (CPLib.eqr("pCodCabFil",p_cVarName)) {
      pCodCabFil = value;
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
    if (CPLib.eqr("_dataOpe",p_cVarName)) {
      _dataOpe = value;
      return;
    }
    if (CPLib.eqr("_dataNascita",p_cVarName)) {
      _dataNascita = value;
      return;
    }
    if (CPLib.eqr("_dataNascitaEse",p_cVarName)) {
      _dataNascitaEse = value;
      return;
    }
    if (CPLib.eqr("_dataApert",p_cVarName)) {
      _dataApert = value;
      return;
    }
    if (CPLib.eqr("_dataChiu",p_cVarName)) {
      _dataChiu = value;
      return;
    }
    if (CPLib.eqr("_dataIniSogg",p_cVarName)) {
      _dataIniSogg = value;
      return;
    }
    if (CPLib.eqr("_dataFinSogg",p_cVarName)) {
      _dataFinSogg = value;
      return;
    }
    if (CPLib.eqr("_dataNascSogg",p_cVarName)) {
      _dataNascSogg = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaData",p_cVarName)) {
      w_DaData = value;
      return;
    }
    if (CPLib.eqr("AData",p_cVarName)) {
      w_AData = value;
      return;
    }
    if (CPLib.eqr("_datastorico",p_cVarName)) {
      _datastorico = value;
      return;
    }
    if (CPLib.eqr("_datarettifica",p_cVarName)) {
      _datarettifica = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("_dateTimeNow",p_cVarName)) {
      _dateTimeNow = value;
      return;
    }
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
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rwOPE",p_cVarName)) {
      rwOPE = (MemoryCursorRow_mcoperazioniall1_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rwSOG",p_cVarName)) {
      rwSOG = (MemoryCursorRow_mcsoggettiall1_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rwRAP",p_cVarName)) {
      rwRAP = (MemoryCursorRow_mcrapportoall1_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rwANARAP",p_cVarName)) {
      rwANARAP = (MemoryCursorRow_mcanarap_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcANADIP",p_cVarName)) {
      mcANADIP = (MemoryCursor_anadip)value;
      return;
    }
    if (CPLib.eqr("mcOPERAZIONI",p_cVarName)) {
      mcOPERAZIONI = (MemoryCursor_mcoperazioniall1_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcSOGGETTI",p_cVarName)) {
      mcSOGGETTI = (MemoryCursor_mcsoggettiall1_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcRAPPORTO",p_cVarName)) {
      mcRAPPORTO = (MemoryCursor_mcrapportoall1_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcANARAP",p_cVarName)) {
      mcANARAP = (MemoryCursor_mcanarap_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcANARAP_APP",p_cVarName)) {
      mcANARAP_APP = (MemoryCursor_mcanarap_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcRAPOPEBO",p_cVarName)) {
      mcRAPOPEBO = (MemoryCursor_rapopebo)value;
      return;
    }
    if (CPLib.eqr("mcINTESTBO",p_cVarName)) {
      mcINTESTBO = (MemoryCursor_intestbo)value;
      return;
    }
    if (CPLib.eqr("mcINTESTIT",p_cVarName)) {
      mcINTESTIT = (MemoryCursor_intestit)value;
      return;
    }
    if (CPLib.eqr("mcFIDUCIABO",p_cVarName)) {
      mcFIDUCIABO = (MemoryCursor_fiduciabo)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anadip=null;
    try {
      /* w_DaData Date // Data Inizio */
      /* w_AData Date // Data Fine */
      /* w_codage Char(6) // Agenzia/Punto Operativo/Dipendenza */
      /* w_codcli Char(16) // NDG Cliente */
      /* w_rapporto Char(25) // Rapporto */
      /* w_flgope Char(1) // Operazioni */
      /* w_flgrap Char(1) // Rapporti */
      /* w_flgfrz Char(1) // Frazionate */
      /* w_flgordine Char(1) // Ordinamento */
      /* w_stoper Char(1) // Storico Dati Soggetto */
      /* w_tipout Char(1) // Tipo Output */
      /* w_rappAttivSel Char(0) // Rapporti attivi nel periodo (Chkrapp in FOX) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gIntemediario Char(11) // Intermediario */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
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
      /* nomefoglio Char(50) */
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
      /* _tiprec Char(1) */
      /* _raeatc Char(1) */
      /* oldfolder Char(120) */
      /* _tipoag Char(10) */
      /* _datage Char(44) */
      /* _numticket Char(30) */
      /* w_cdareg Char(8) // Da Data Registrazione */
      /* w_c_areg Char(8) // A Data Registrazione */
      /* z_desccit Char(30) */
      /* z_codcab Char(6) */
      /* z_provin Char(2) */
      /* z_coddipe Char(6) */
      /* _idb Char(10) */
      /* _connescli Char(16) */
      /* _connaltro Char(16) */
      /* _datastorico Date */
      /* _statooperazione Char(1) */
      /* _datarettifica Date */
      /* _tipoperazione Char(1) */
      /* _rapporto_check Char(25) // Page_14 */
      /* _codcli_check Char(16) // Page_14 */
      /* _testo Char(0) */
      /* _dateTimeNow DateTime */
      /* _data_ora Char(0) */
      /* mcANADIP MemoryCursor(anadip) */
      /* mcOPERAZIONI MemoryCursor(mcOperazioniAll1.MCRDef) */
      /* rwOPE Row(mcOperazioniAll1.MCRDef) */
      /* mcSOGGETTI MemoryCursor(mcSoggettiAll1.MCRDef) */
      /* rwSOG Row(mcSoggettiAll1.MCRDef) */
      /* mcRAPPORTO MemoryCursor(mcRapportoAll1.MCRDef) */
      /* rwRAP Row(mcRapportoAll1.MCRDef) */
      /* mcANARAP MemoryCursor(mcANARAP.MCRDef) */
      /* mcANARAP_APP MemoryCursor(mcANARAP.MCRDef) */
      /* rwANARAP Row(mcANARAP.MCRDef) */
      /* mcRAPOPEBO MemoryCursor(rapopebo) */
      /* w_ragben Char(0) */
      /* mcINTESTBO MemoryCursor(intestbo) */
      /* mcINTESTIT MemoryCursor(intestit) */
      /* mcFIDUCIABO MemoryCursor(fiduciabo) */
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
      /* pCodDip Char(12) // Codice Dipendenza */
      /* pCodCabFil Char(12) // CAB Filiale  */
      /* pCodCab Char(12) // CAB Comune Dipendenza */
      /* pDesCit Char(30) // Città Dipendenza */
      /* pProv Char(2) // Provincia Dipendenza */
      /* If w_flgope='S' or w_flgfrz='S' */
      if (CPLib.eqr(w_flgope,"S") || CPLib.eqr(w_flgfrz,"S")) {
        /* Exec "Crea variabili per lettura tabelle accessorie" Page 10:Page_16 */
        Page_16();
      } // End If
      /* z_codcab := '' */
      z_codcab = "";
      /* z_desccit := '' */
      z_desccit = "";
      /* z_provin := '' */
      z_provin = "";
      /* z_coddipe := '' */
      z_coddipe = "";
      // * --- Read from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      m_cSql = "";
      m_cSql = m_cSql+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(gIntemediario,"C",11,0,m_cServer),m_cServer,gIntemediario);
      if (m_Ctx.IsSharedTemp("intermbo")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("PROVINCIA",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        z_codcab = Read_Cursor.GetString("CODCAB");
        z_desccit = Read_Cursor.GetString("DESCCIT");
        z_provin = Read_Cursor.GetString("PROVINCIA");
        z_coddipe = Read_Cursor.GetString("CODDIPE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on intermbo into routine arfn_estrai_all1 returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        z_codcab = "";
        z_desccit = "";
        z_provin = "";
        z_coddipe = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
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
                info.log("Routine arfn_estrai_all1: query on anadip returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := '' // Messaggio Import */
      gMsgImp = "";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Inizio Procedura: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inizio Procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* xStato := '' */
      xStato = "";
      /* _codrif := '' */
      _codrif = "";
      /* _ctotale := 0 */
      _ctotale = CPLib.Round(0,0);
      /* w_cdadata := iif(Empty(w_DaData) or DateToChar(w_DaData)='01000101','',DateToChar(w_DaData)) */
      w_cdadata = (CPLib.Empty(w_DaData) || CPLib.eqr(CPLib.DateToChar(w_DaData),"01000101")?"":CPLib.DateToChar(w_DaData));
      /* w_c_adata := iif(Empty(w_AData) or DateToChar(w_AData)='01000101','',DateToChar(w_AData)) */
      w_c_adata = (CPLib.Empty(w_AData) || CPLib.eqr(CPLib.DateToChar(w_AData),"01000101")?"":CPLib.DateToChar(w_AData));
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* _testo := '' */
      _testo = "";
      /* _dateTimeNow := DateTime() */
      _dateTimeNow = CPLib.DateTime();
      /* _data_ora := Left(DateTimeToChar(_dateTimeNow),4) + '-' + Substr(DateTimeToChar(_dateTimeNow),5,2) + '-' + Substr(DateTimeToChar(_dateTimeNow),7,2) + "T" +Substr(DateTimeToChar(_dateTimeNow),9,2) + "-" + Substr(DateTimeToChar(_dateTimeNow),11,2) + "-" + Substr(DateTimeToChar(_dateTimeNow),13,2) */
      _data_ora = CPLib.Left(CPLib.DateTimeToChar(_dateTimeNow),4)+"-"+CPLib.Substr(CPLib.DateTimeToChar(_dateTimeNow),5,2)+"-"+CPLib.Substr(CPLib.DateTimeToChar(_dateTimeNow),7,2)+"T"+CPLib.Substr(CPLib.DateTimeToChar(_dateTimeNow),9,2)+"-"+CPLib.Substr(CPLib.DateTimeToChar(_dateTimeNow),11,2)+"-"+CPLib.Substr(CPLib.DateTimeToChar(_dateTimeNow),13,2);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000099status;
      nTry00000099status = m_Sql.GetTransactionStatus();
      String cTry00000099msg;
      cTry00000099msg = m_Sql.TransactionErrorMessage();
      try {
        /* If w_flgope = 'S' */
        if (CPLib.eqr(w_flgope,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' Operazioni' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Operazioni"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Exec "Operazioni" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' Operazioni' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Operazioni"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_flgfrz = 'S' */
        if (CPLib.eqr(w_flgfrz,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' Frazionate' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Frazionate"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Exec "Frazionate" Page 4:Page_4 */
          Page_4();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' Frazionate' + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Frazionate"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* If w_flgrap='S' */
        if (CPLib.eqr(w_flgrap,"S")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' Rapporti' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Rapporti"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Exec "Rapporti" Page 13:Page_18 */
          Page_18();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' Rapporti' + NL */
          gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Rapporti"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' Creazione file' + NL */
        gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Creazione file"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If w_flgope='S' or w_flgfrz='S' */
        if (CPLib.eqr(w_flgope,"S") || CPLib.eqr(w_flgfrz,"S")) {
          /* -- genera file per le Operazioni */
          /* _conta := mcOPERAZIONI.RecCount() */
          _conta = CPLib.Round(mcOPERAZIONI.RecCount(),0);
          /* Exec "Generazione file oper-fraz" Page 15:file_Ope_Frz */
          file_Ope_Frz();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
        } // End If
        /* If w_flgrap='S' */
        if (CPLib.eqr(w_flgrap,"S")) {
          /* -- genera file per i Rapporti */
          /* _conta := mcSOGGETTI.RecCount() */
          _conta = CPLib.Round(mcSOGGETTI.RecCount(),0);
          /* Exec "Generazione file rapporti" Page 16:file_Rapporti */
          file_Rapporti();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
        } // End If
        /* Exec "Crea file zip" Page 5:Page_6 */
        Page_6();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' Creazione file' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" Creazione file"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione terminata.' // Messaggio Import */
        gMsgImp = "Elaborazione terminata.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgProc := gMsgProc + "Rilevati errori nell'elaborazione dei dati !" + NL */
        gMsgProc = gMsgProc+"Rilevati errori nell'elaborazione dei dati !"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' dei dati' + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" dei dati"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000099status,0)) {
          m_Sql.SetTransactionStatus(nTry00000099status,cTry00000099msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Procedura: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Procedura: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return cOnlyNomeFile */
      throw new Stop(cOnlyNomeFile);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
    }
  }
  void Page_2() throws Exception {
    /* Cicla sulle operazioni */
    /* If Empty(LRTrim(w_codcli)) */
    if (CPLib.Empty(CPLib.LRTrim(w_codcli))) {
      /* Exec "Operazioni Definitive" Page 6:Page_7 */
      Page_7();
    } else { // Else
      /* Exec "Operazioni Definitive Cliente" Page 8:Page_11 */
      Page_11();
    } // End If
  }
  void Page_3() throws Exception {
    /* -- */
  }
  void Page_4() throws Exception {
    /* Cicla sulle frazionate */
    /* If Empty(LRTrim(w_codcli)) */
    if (CPLib.Empty(CPLib.LRTrim(w_codcli))) {
      /* Exec "Frazionate Definitive" Page 7:Page_9 */
      Page_9();
    } else { // Else
      /* Exec "Frazionate Definitive Cliente" Page 9:Page_13 */
      Page_13();
    } // End If
  }
  void Page_6() throws Exception {
    /* cOnlyNomeFile := 'Allegato1_'+_data_ora+'.zip' */
    cOnlyNomeFile = "Allegato1_"+_data_ora+".zip";
    /* cNomeFileZip := LRTrim(gPathApp)+'/appo/'+LRTrim(gAzienda)+'/'+cOnlyNomeFile */
    cNomeFileZip = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+cOnlyNomeFile;
    // Qui vengono scritti i file da inserire nello zip
        // public List<String> filename_path = new ArrayList<String>(); path+filename
        // public List<String> filename= new ArrayList<String>(); filename
        
        // Crea un buffer per la lettura dei file
        byte[] buf = new byte[1024];
        
        try {
            // Creail file ZIP
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Comprime i file
           for(int i=0; i<filename_path.size(); i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filename_path.get(i));
        
                // Apre il file da aggiungere allo ZIP
                out.putNextEntry(new java.util.zip.ZipEntry(filename.get(i)));
        
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
  void Page_7() throws Exception {
    CPResultSet Cursor_qbe_oped_chkdiana_limits=null;
    CPResultSet Cursor_qbe_oped_chkdiana=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle operazioni */
      /* gMsgImp := 'Verifica Operazioni da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _ciclo := 0 */
      _ciclo = CPLib.Round(0,0);
      /* Prima gli italiani */
      /* _tipoperazione := 'O' */
      _tipoperazione = "O";
      // * --- Select from qbe_oped_chkdiana_limits
      SPBridge.HMCaller _h000000CC;
      _h000000CC = new SPBridge.HMCaller();
      _h000000CC.Set("m_cVQRList",m_cVQRList);
      _h000000CC.Set("cdadata",w_cdadata);
      _h000000CC.Set("c_adata",w_c_adata);
      _h000000CC.Set("codage",w_codage);
      _h000000CC.Set("ragben",w_ragben);
      _h000000CC.Set("cdareg",w_cdareg);
      _h000000CC.Set("c_areg",w_c_areg);
      if (Cursor_qbe_oped_chkdiana_limits!=null)
        Cursor_qbe_oped_chkdiana_limits.Close();
      Cursor_qbe_oped_chkdiana_limits = new VQRHolder("qbe_oped_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000CC,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_oped_chkdiana_limits.Eof())) {
        /* _max := qbe_oped_chkdiana_limits->MAXOPE */
        _max = CPLib.Round(Cursor_qbe_oped_chkdiana_limits.GetDouble("MAXOPE"),0);
        /* _min := qbe_oped_chkdiana_limits->MINOPE */
        _min = CPLib.Round(Cursor_qbe_oped_chkdiana_limits.GetDouble("MINOPE"),0);
        Cursor_qbe_oped_chkdiana_limits.Next();
      }
      m_cConnectivityError = Cursor_qbe_oped_chkdiana_limits.ErrorMessage();
      Cursor_qbe_oped_chkdiana_limits.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _bottom := _min */
      _bottom = CPLib.Round(_min,0);
      /* If _min > 5000 */
      if (CPLib.gt(_min,5000)) {
        /* _contacilci := Int(_min/5000) + 1 */
        _contacilci = CPLib.Round(CPLib.Int(_min/5000)+1,0);
      } else { // Else
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
      } // End If
      /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := iif(_ciclo=0,_bottom,((_contacilci -1 ) * 5000) + 1) */
        _bottom = CPLib.Round((CPLib.eqr(_ciclo,0)?_bottom:((_contacilci-1)*5000)+1),0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* _ciclo := 1 */
        _ciclo = CPLib.Round(1,0);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgImp := 'Lettura operazioni in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_oped_chkdiana
        SPBridge.HMCaller _h000000DC;
        _h000000DC = new SPBridge.HMCaller();
        _h000000DC.Set("m_cVQRList",m_cVQRList);
        _h000000DC.Set("cdadata",w_cdadata);
        _h000000DC.Set("c_adata",w_c_adata);
        _h000000DC.Set("codage",w_codage);
        _h000000DC.Set("_bottom",_bottom);
        _h000000DC.Set("_top",_top);
        _h000000DC.Set("cdareg",w_cdareg);
        _h000000DC.Set("c_areg",w_c_areg);
        if (Cursor_qbe_oped_chkdiana!=null)
          Cursor_qbe_oped_chkdiana.Close();
        Cursor_qbe_oped_chkdiana = new VQRHolder("qbe_oped_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000DC,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_oped_chkdiana.Eof())) {
          /* _idb := qbe_oped_chkdiana->IDBASE */
          _idb = Cursor_qbe_oped_chkdiana.GetString("IDBASE");
          /* _connescli := qbe_oped_chkdiana->CONNESCLI */
          _connescli = Cursor_qbe_oped_chkdiana.GetString("CONNESCLI");
          /* _datastorico := iif(w_stoper='R',qbe_oped_chkdiana->DATAREG,qbe_oped_chkdiana->DATAOPE) */
          _datastorico = (CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana.GetDate("DATAOPE"));
          /* _statooperazione := qbe_oped_chkdiana->STATOREG */
          _statooperazione = Cursor_qbe_oped_chkdiana.GetString("STATOREG");
          /* _datarettifica := qbe_oped_chkdiana->DATARETT */
          _datarettifica = Cursor_qbe_oped_chkdiana.GetDate("DATARETT");
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* rwOPE.TIPOINTER := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->TIPOINTER,2)) // Tipo Intermediario */
          rwOPE.TIPOINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("TIPOINTER"),2));
          /* rwOPE.CODINTER := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->CODINTER,11)) // Codice Intermediario */
          rwOPE.CODINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("CODINTER"),11));
          /* _idereg := arfn_calc_idereg("O",qbe_oped_chkdiana->NUMPROG,qbe_oped_chkdiana->IDEREG) */
          _idereg = arfn_calc_ideregR.Make(m_Ctx,this).Run("O",Cursor_qbe_oped_chkdiana.GetString("NUMPROG"),Cursor_qbe_oped_chkdiana.GetString("IDEREG"));
          /* rwOPE.IDEREG := Upper(LibreriaMit.SpacePad(_idereg,20)) // Identificativo Operazione */
          rwOPE.IDEREG = CPLib.Upper(LibreriaMit.SpacePad(_idereg,20));
          /* pCodDip := qbe_oped_chkdiana->CODDIPE // Codice Dipendenza */
          pCodDip = Cursor_qbe_oped_chkdiana.GetString("CODDIPE");
          /* pCodCabFil := Space(12) // CAB Filiale  */
          pCodCabFil = CPLib.Space(12);
          /* pCodCab := qbe_oped_chkdiana->CODCAB // CAB Dipendenza */
          pCodCab = Cursor_qbe_oped_chkdiana.GetString("CODCAB");
          /* pDesCit := qbe_oped_chkdiana->DESCCIT // Città Dipendenza */
          pDesCit = Cursor_qbe_oped_chkdiana.GetString("DESCCIT");
          /* pProv := qbe_oped_chkdiana->PROVINCIA // Provincia Dipendenza */
          pProv = Cursor_qbe_oped_chkdiana.GetString("PROVINCIA");
          /* Exec "Dati Agenzia" Page 11:Page_17 */
          Page_17();
          /* rwOPE.CODDIPE := Upper(LibreriaMit.SpacePad(pCodDip,12)) // Codice Intermediario */
          rwOPE.CODDIPE = CPLib.Upper(LibreriaMit.SpacePad(pCodDip,12));
          /* rwOPE.CABFIL := Upper(LibreriaMit.SpacePad(pCodCabFil,12)) // CAB Filiale  */
          rwOPE.CABFIL = CPLib.Upper(LibreriaMit.SpacePad(pCodCabFil,12));
          /* rwOPE.CABCOMU := Upper(LibreriaMit.SpacePad(pCodCab,6)) // CAB Dipendenza */
          rwOPE.CABCOMU = CPLib.Upper(LibreriaMit.SpacePad(pCodCab,6));
          /* rwOPE.DESCCIT := Upper(LibreriaMit.SpacePad(pDesCit,30)) // Città Dipendenza */
          rwOPE.DESCCIT = CPLib.Upper(LibreriaMit.SpacePad(pDesCit,30));
          /* rwOPE.PROVINCIA := Upper(LibreriaMit.SpacePad(pProv,2)) // Provincia Dipendenza */
          rwOPE.PROVINCIA = CPLib.Upper(LibreriaMit.SpacePad(pProv,2));
          /* rwOPE.DATAOPE := qbe_oped_chkdiana->DATAOPE // Data Operazione */
          rwOPE.DATAOPE = Cursor_qbe_oped_chkdiana.GetDate("DATAOPE");
          /* rwOPE.CODANA := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->CODANA,4)) // Causale Analitica */
          rwOPE.CODANA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("CODANA"),4));
          /* rwOPE.SEGNO := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->SEGNO,1)) // Segno */
          rwOPE.SEGNO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("SEGNO"),1));
          /* rwOPE.VALUTA := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->VALUTA,3)) // Valuta */
          rwOPE.VALUTA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("VALUTA"),3));
          /* rwOPE.TOTLIRE := qbe_oped_chkdiana->TOTLIRE // Importo euro */
          rwOPE.TOTLIRE = Cursor_qbe_oped_chkdiana.GetDouble("TOTLIRE");
          /* rwOPE.TOTCONT := qbe_oped_chkdiana->TOTCONT // Importo parte contanti */
          rwOPE.TOTCONT = Cursor_qbe_oped_chkdiana.GetDouble("TOTCONT");
          /* rwOPE.RAPPORTO := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->RAPPORTO,34)) // Identificativo Rapporto */
          rwOPE.RAPPORTO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("RAPPORTO"),34));
          /* If not(Empty(qbe_oped_chkdiana->CONNESOPER)) */
          if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER")))) {
            /* rwSOG := arfn_datisog_sol_row(qbe_oped_chkdiana->CONNESOPER,_datastorico,_statooperazione,_datarettifica) */
            rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana.GetString("CONNESOPER"),_datastorico,_statooperazione,_datarettifica);
            /* rwOPE.CONNESESE := Upper(LibreriaMit.SpacePad(rwSOG.NDG,16)) // NDG */
            rwOPE.CONNESESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.NDG,16));
            /* rwOPE.RAGSOGESE := Upper(LibreriaMit.SpacePad(rwSOG.RAGSOC,70)) // Cognome Nome */
            rwOPE.RAGSOGESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.RAGSOC,70));
            /* rwOPE.CODFISCESE := Upper(LibreriaMit.SpacePad(rwSOG.CODFISC,16)) // Codice Fiscale */
            rwOPE.CODFISCESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.CODFISC,16));
            /* rwOPE.DATANASCESE := rwSOG.DATANASC // Data di Nascita */
            rwOPE.DATANASCESE = rwSOG.DATANASC;
            /* rwOPE.NASCCOMUNESE := Upper(LibreriaMit.SpacePad(rwSOG.NASCOMU,30)) // Comune/Stato di Nascita */
            rwOPE.NASCCOMUNESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.NASCOMU,30));
          } else { // Else
            /* rwOPE.CONNESESE := Space(16) // NDG */
            rwOPE.CONNESESE = CPLib.Space(16);
            /* rwOPE.RAGSOGESE := Space(70) // Cognome Nome */
            rwOPE.RAGSOGESE = CPLib.Space(70);
            /* rwOPE.CODFISCESE := Space(16) // Codice Fiscale */
            rwOPE.CODFISCESE = CPLib.Space(16);
            /* rwOPE.DATANASCESE := NullDate() // Data di Nascita */
            rwOPE.DATANASCESE = CPLib.NullDate();
            /* rwOPE.NASCCOMUNESE := Space(30) // Comune/Stato di Nascita */
            rwOPE.NASCCOMUNESE = CPLib.Space(30);
          } // End If
          /* rwOPE.C_RAG := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->C_RAG,70)) // Cognome Nome/Ragione Sociale */
          rwOPE.C_RAG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("C_RAG"),70));
          /* rwOPE.C_STA := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->C_STA,3)) // Paese */
          rwOPE.C_STA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("C_STA"),3));
          /* rwOPE.C_CAB := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->C_CAB,6)) // CAB */
          rwOPE.C_CAB = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("C_CAB"),6));
          /* rwOPE.C_CTA := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->C_CTA,40)) // Comune */
          rwOPE.C_CTA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("C_CTA"),40));
          /* rwOPE.CODINT2 := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->CODINT2,11)) // Codice Intermediario */
          rwOPE.CODINT2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("CODINT2"),11));
          /* rwOPE.DESCINTER := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->DESCINTER,70)) // Denominazione Intermediario */
          rwOPE.DESCINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("DESCINTER"),70));
          /* rwOPE.PAESE := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->PAESE,3)) // Paese Intermediario */
          rwOPE.PAESE = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("PAESE"),3));
          /* rwOPE.CODCAB2 := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->CODCAB2,6)) // CAB Intermediario */
          rwOPE.CODCAB2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("CODCAB2"),6));
          /* rwOPE.C_RAPPORTO := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->C_RAPPORTO,34)) // IBAN / Rapporto */
          rwOPE.C_RAPPORTO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("C_RAPPORTO"),34));
          /* rwOPE.CODCAB2 := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana->CODCAB2,6)) // CAB Intermediario */
          rwOPE.CODCAB2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana.GetString("CODCAB2"),6));
          /* rwOPE.FILLER := Space(69) // A Disposizione */
          rwOPE.FILLER = CPLib.Space(69);
          /* Exec "Soggetti" Page 12:Page_12 */
          Page_12();
          for (MemoryCursorRow_mcsoggettiall1_mcrdef rw_soggetto : mcSOGGETTI._iterable_()) {
            /* mcOPERAZIONI.AppendRow(rwOPE) */
            mcOPERAZIONI.AppendRow(rwOPE);
            /* mcOPERAZIONI.CODTIPSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODTIPSOG,2)) // Codice Tipo Soggetto */
            mcOPERAZIONI.row.CODTIPSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODTIPSOG,2));
            /* mcOPERAZIONI.CONNESSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.NDG,16)) // NDG Soggetto */
            mcOPERAZIONI.row.CONNESSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.NDG,16));
            /* mcOPERAZIONI.RAGSOGSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.RAGSOC,70)) // Cognome Nome/Ragione Sociale Soggetto */
            mcOPERAZIONI.row.RAGSOGSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.RAGSOC,70));
            /* mcOPERAZIONI.SESSOSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.SESSO,1)) // Sesso */
            mcOPERAZIONI.row.SESSOSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.SESSO,1));
            /* mcOPERAZIONI.CODFISCSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODFISC,16)) // Codice Fiscale Soggetto */
            mcOPERAZIONI.row.CODFISCSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODFISC,16));
            /* mcOPERAZIONI.DATANASCSOGG := rw_soggetto.DATANASC // Data di Nascita del Soggetto */
            mcOPERAZIONI.row.DATANASCSOGG = rw_soggetto.DATANASC;
            /* mcOPERAZIONI.NASCOMUNSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.NASCOMU,30)) // Comune/Paese di Nascita */
            mcOPERAZIONI.row.NASCOMUNSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.NASCOMU,30));
            /* mcOPERAZIONI.COMUNRESSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.DESCCIT,40)) // Comune di Residenza */
            mcOPERAZIONI.row.COMUNRESSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.DESCCIT,40));
            /* mcOPERAZIONI.CABRESISOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODCAB,6)) // CAB comune di Residenza */
            mcOPERAZIONI.row.CABRESISOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODCAB,6));
            /* mcOPERAZIONI.PAESESOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.STATO,3)) // Paese di Residenza */
            mcOPERAZIONI.row.PAESESOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.STATO,3));
            /* mcOPERAZIONI.SAESOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.SAE,3)) // SAE */
            mcOPERAZIONI.row.SAESOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.SAE,3));
            /* mcOPERAZIONI.ATECOSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.ATECO,3)) // ATECO */
            mcOPERAZIONI.row.ATECOSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.ATECO,3));
          }
          Cursor_qbe_oped_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_oped_chkdiana.ErrorMessage();
        Cursor_qbe_oped_chkdiana.Close();
        // * --- End Select
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_oped_chkdiana_limits!=null)
          Cursor_qbe_oped_chkdiana_limits.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_oped_chkdiana!=null)
          Cursor_qbe_oped_chkdiana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    CPResultSet Cursor_qbe_frad_chkdiana_limits=null;
    CPResultSet Cursor_qbe_frad_chkdiana=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle frazionate */
      /* gMsgImp := 'Verifica Frazionate da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Frazionate da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _ciclo := 0 */
      _ciclo = CPLib.Round(0,0);
      /* Prima gli italiani */
      /* _tipoperazione := 'F' */
      _tipoperazione = "F";
      // * --- Select from qbe_frad_chkdiana_limits
      SPBridge.HMCaller _h0000012D;
      _h0000012D = new SPBridge.HMCaller();
      _h0000012D.Set("m_cVQRList",m_cVQRList);
      _h0000012D.Set("cdadata",w_cdadata);
      _h0000012D.Set("c_adata",w_c_adata);
      _h0000012D.Set("codage",w_codage);
      _h0000012D.Set("ragben",w_ragben);
      _h0000012D.Set("cdareg",w_cdareg);
      _h0000012D.Set("c_areg",w_c_areg);
      if (Cursor_qbe_frad_chkdiana_limits!=null)
        Cursor_qbe_frad_chkdiana_limits.Close();
      Cursor_qbe_frad_chkdiana_limits = new VQRHolder("qbe_frad_chkdiana_limits",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000012D,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_frad_chkdiana_limits.Eof())) {
        /* _max := qbe_frad_chkdiana_limits->MAXFRZ */
        _max = CPLib.Round(Cursor_qbe_frad_chkdiana_limits.GetDouble("MAXFRZ"),0);
        /* _min := qbe_frad_chkdiana_limits->MINFRZ */
        _min = CPLib.Round(Cursor_qbe_frad_chkdiana_limits.GetDouble("MINFRZ"),0);
        Cursor_qbe_frad_chkdiana_limits.Next();
      }
      m_cConnectivityError = Cursor_qbe_frad_chkdiana_limits.ErrorMessage();
      Cursor_qbe_frad_chkdiana_limits.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      /* _bottom := _min */
      _bottom = CPLib.Round(_min,0);
      /* If _min > 5000 */
      if (CPLib.gt(_min,5000)) {
        /* _contacilci := Int(_min/5000) + 1 */
        _contacilci = CPLib.Round(CPLib.Int(_min/5000)+1,0);
      } else { // Else
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
      } // End If
      /* gMsgImp := 'Lettura operazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* While _contacilci<=_cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := iif(_ciclo=0,_bottom,((_contacilci -1 ) * 5000) + 1) */
        _bottom = CPLib.Round((CPLib.eqr(_ciclo,0)?_bottom:((_contacilci-1)*5000)+1),0);
        /* _top := _contacilci * 5000 */
        _top = CPLib.Round(_contacilci*5000,0);
        /* _ciclo := 1 */
        _ciclo = CPLib.Round(1,0);
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* gMsgImp := 'Lettura frazionate in corso ... Ciclo N. '+LRTrim(Str(_contacilci,10,0)) // Messaggio Import */
        gMsgImp = "Lettura frazionate in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacilci,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* Cicla sulle operazioni */
        // * --- Select from qbe_frad_chkdiana
        SPBridge.HMCaller _h0000013D;
        _h0000013D = new SPBridge.HMCaller();
        _h0000013D.Set("m_cVQRList",m_cVQRList);
        _h0000013D.Set("cdadata",w_cdadata);
        _h0000013D.Set("c_adata",w_c_adata);
        _h0000013D.Set("codage",w_codage);
        _h0000013D.Set("_bottom",_bottom);
        _h0000013D.Set("_top",_top);
        _h0000013D.Set("ragben",w_ragben);
        _h0000013D.Set("cdareg",w_cdareg);
        _h0000013D.Set("c_areg",w_c_areg);
        if (Cursor_qbe_frad_chkdiana!=null)
          Cursor_qbe_frad_chkdiana.Close();
        Cursor_qbe_frad_chkdiana = new VQRHolder("qbe_frad_chkdiana",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000013D,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_frad_chkdiana.Eof())) {
          /* _idb := qbe_frad_chkdiana->IDBASE */
          _idb = Cursor_qbe_frad_chkdiana.GetString("IDBASE");
          /* _connescli := qbe_frad_chkdiana->CONNESCLI */
          _connescli = Cursor_qbe_frad_chkdiana.GetString("CONNESCLI");
          /* _datastorico := iif(w_stoper='R',qbe_frad_chkdiana->DATAREG,qbe_frad_chkdiana->DATAOPE) */
          _datastorico = (CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana.GetDate("DATAOPE"));
          /* _statooperazione := qbe_frad_chkdiana->STATOREG */
          _statooperazione = Cursor_qbe_frad_chkdiana.GetString("STATOREG");
          /* _datarettifica := qbe_frad_chkdiana->DATARETT */
          _datarettifica = Cursor_qbe_frad_chkdiana.GetDate("DATARETT");
          /* _ctotale := _ctotale + 1 */
          _ctotale = CPLib.Round(_ctotale+1,0);
          /* gMsgImp := 'Elaborazione Frazionata N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
          gMsgImp = "Elaborazione Frazionata N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* rwOPE.TIPOINTER := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->TIPOINTER,2)) // Tipo Intermediario */
          rwOPE.TIPOINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("TIPOINTER"),2));
          /* rwOPE.CODINTER := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->CODINTER,11)) // Codice Intermediario */
          rwOPE.CODINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("CODINTER"),11));
          /* _idereg := arfn_calc_idereg("F",qbe_frad_chkdiana->NUMPROG,qbe_frad_chkdiana->IDEREG) */
          _idereg = arfn_calc_ideregR.Make(m_Ctx,this).Run("F",Cursor_qbe_frad_chkdiana.GetString("NUMPROG"),Cursor_qbe_frad_chkdiana.GetString("IDEREG"));
          /* rwOPE.IDEREG := Upper(LibreriaMit.SpacePad(_idereg,20)) // Identificativo Operazione */
          rwOPE.IDEREG = CPLib.Upper(LibreriaMit.SpacePad(_idereg,20));
          /* pCodDip := qbe_frad_chkdiana->CODDIPE // Codice Dipendenza */
          pCodDip = Cursor_qbe_frad_chkdiana.GetString("CODDIPE");
          /* pCodCabFil := Space(12) // CAB Filiale  */
          pCodCabFil = CPLib.Space(12);
          /* pCodCab := qbe_frad_chkdiana->CODCAB // CAB Dipendenza */
          pCodCab = Cursor_qbe_frad_chkdiana.GetString("CODCAB");
          /* pDesCit := qbe_frad_chkdiana->DESCCIT // Città Dipendenza */
          pDesCit = Cursor_qbe_frad_chkdiana.GetString("DESCCIT");
          /* pProv := qbe_frad_chkdiana->PROVINCIA // Provincia Dipendenza */
          pProv = Cursor_qbe_frad_chkdiana.GetString("PROVINCIA");
          /* Exec "Dati Agenzia" Page 11:Page_17 */
          Page_17();
          /* rwOPE.CODDIPE := Upper(LibreriaMit.SpacePad(pCodDip,12)) // Codice Intermediario */
          rwOPE.CODDIPE = CPLib.Upper(LibreriaMit.SpacePad(pCodDip,12));
          /* rwOPE.CABFIL := Upper(LibreriaMit.SpacePad(pCodCabFil,12)) // CAB Filiale  */
          rwOPE.CABFIL = CPLib.Upper(LibreriaMit.SpacePad(pCodCabFil,12));
          /* rwOPE.CABCOMU := Upper(LibreriaMit.SpacePad(pCodCab,6)) // CAB Dipendenza */
          rwOPE.CABCOMU = CPLib.Upper(LibreriaMit.SpacePad(pCodCab,6));
          /* rwOPE.DESCCIT := Upper(LibreriaMit.SpacePad(pDesCit,30)) // Città Dipendenza */
          rwOPE.DESCCIT = CPLib.Upper(LibreriaMit.SpacePad(pDesCit,30));
          /* rwOPE.PROVINCIA := Upper(LibreriaMit.SpacePad(pProv,2)) // Provincia Dipendenza */
          rwOPE.PROVINCIA = CPLib.Upper(LibreriaMit.SpacePad(pProv,2));
          /* rwOPE.DATAOPE := qbe_frad_chkdiana->DATAOPE // Data Operazione */
          rwOPE.DATAOPE = Cursor_qbe_frad_chkdiana.GetDate("DATAOPE");
          /* rwOPE.CODANA := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->CODANA,4)) // Causale Analitica */
          rwOPE.CODANA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("CODANA"),4));
          /* rwOPE.SEGNO := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->SEGNO,1)) // Segno */
          rwOPE.SEGNO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("SEGNO"),1));
          /* rwOPE.VALUTA := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->VALUTA,3)) // Valuta */
          rwOPE.VALUTA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("VALUTA"),3));
          /* rwOPE.TOTLIRE := qbe_frad_chkdiana->TOTLIRE // Importo euro */
          rwOPE.TOTLIRE = Cursor_qbe_frad_chkdiana.GetDouble("TOTLIRE");
          /* rwOPE.TOTCONT := qbe_frad_chkdiana->TOTCONT // Importo parte contanti */
          rwOPE.TOTCONT = Cursor_qbe_frad_chkdiana.GetDouble("TOTCONT");
          /* rwOPE.RAPPORTO := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->RAPPORTO,34)) // Identificativo Rapporto */
          rwOPE.RAPPORTO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("RAPPORTO"),34));
          /* If not(Empty(qbe_frad_chkdiana->CONNESOPER)) */
          if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER")))) {
            /* rwSOG := arfn_datisog_sol_row(qbe_frad_chkdiana->CONNESOPER,_datastorico,_statooperazione,_datarettifica) */
            rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana.GetString("CONNESOPER"),_datastorico,_statooperazione,_datarettifica);
            /* rwOPE.CONNESESE := Upper(LibreriaMit.SpacePad(rwSOG.NDG,16)) // NDG */
            rwOPE.CONNESESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.NDG,16));
            /* rwOPE.RAGSOGESE := Upper(LibreriaMit.SpacePad(rwSOG.RAGSOC,70)) // Cognome Nome */
            rwOPE.RAGSOGESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.RAGSOC,70));
            /* rwOPE.CODFISCESE := Upper(LibreriaMit.SpacePad(rwSOG.CODFISC,16)) // Codice Fiscale */
            rwOPE.CODFISCESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.CODFISC,16));
            /* rwOPE.DATANASCESE := rwSOG.DATANASC // Data di Nascita */
            rwOPE.DATANASCESE = rwSOG.DATANASC;
            /* rwOPE.NASCCOMUNESE := Upper(LibreriaMit.SpacePad(rwSOG.NASCOMU,30)) // Comune/Stato di Nascita */
            rwOPE.NASCCOMUNESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.NASCOMU,30));
          } else { // Else
            /* rwOPE.CONNESESE := Space(16) // NDG */
            rwOPE.CONNESESE = CPLib.Space(16);
            /* rwOPE.RAGSOGESE := Space(70) // Cognome Nome */
            rwOPE.RAGSOGESE = CPLib.Space(70);
            /* rwOPE.CODFISCESE := Space(16) // Codice Fiscale */
            rwOPE.CODFISCESE = CPLib.Space(16);
            /* rwOPE.DATANASCESE := NullDate() // Data di Nascita */
            rwOPE.DATANASCESE = CPLib.NullDate();
            /* rwOPE.NASCCOMUNESE := Space(30) // Comune/Stato di Nascita */
            rwOPE.NASCCOMUNESE = CPLib.Space(30);
          } // End If
          /* rwOPE.C_RAG := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->C_RAG,70)) // Cognome Nome/Ragione Sociale */
          rwOPE.C_RAG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("C_RAG"),70));
          /* rwOPE.C_STA := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->C_STA,3)) // Paese */
          rwOPE.C_STA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("C_STA"),3));
          /* rwOPE.C_CAB := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->C_CAB,6)) // CAB */
          rwOPE.C_CAB = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("C_CAB"),6));
          /* rwOPE.C_CTA := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->C_CTA,40)) // Comune */
          rwOPE.C_CTA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("C_CTA"),40));
          /* rwOPE.CODINT2 := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->CODINT2,11)) // Codice Intermediario */
          rwOPE.CODINT2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("CODINT2"),11));
          /* rwOPE.DESCINTER := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->DESCINTER,70)) // Denominazione Intermediario */
          rwOPE.DESCINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("DESCINTER"),70));
          /* rwOPE.PAESE := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->PAESE,3)) // Paese Intermediario */
          rwOPE.PAESE = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("PAESE"),3));
          /* rwOPE.CODCAB2 := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->CODCAB2,6)) // CAB Intermediario */
          rwOPE.CODCAB2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("CODCAB2"),6));
          /* rwOPE.C_RAPPORTO := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->C_RAPPORTO,34)) // IBAN / Rapporto */
          rwOPE.C_RAPPORTO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("C_RAPPORTO"),34));
          /* rwOPE.CODCAB2 := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana->CODCAB2,6)) // CAB Intermediario */
          rwOPE.CODCAB2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana.GetString("CODCAB2"),6));
          /* rwOPE.FILLER := Space(69) // A Disposizione */
          rwOPE.FILLER = CPLib.Space(69);
          /* Exec "Soggetti" Page 12:Page_12 */
          Page_12();
          for (MemoryCursorRow_mcsoggettiall1_mcrdef rw_soggetto : mcSOGGETTI._iterable_()) {
            /* mcOPERAZIONI.AppendRow(rwOPE) */
            mcOPERAZIONI.AppendRow(rwOPE);
            /* mcOPERAZIONI.CODTIPSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODTIPSOG,2)) // Codice Tipo Soggetto */
            mcOPERAZIONI.row.CODTIPSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODTIPSOG,2));
            /* mcOPERAZIONI.CONNESSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.NDG,16)) // NDG Soggetto */
            mcOPERAZIONI.row.CONNESSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.NDG,16));
            /* mcOPERAZIONI.RAGSOGSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.RAGSOC,70)) // Cognome Nome/Ragione Sociale Soggetto */
            mcOPERAZIONI.row.RAGSOGSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.RAGSOC,70));
            /* mcOPERAZIONI.SESSOSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.SESSO,1)) // Sesso */
            mcOPERAZIONI.row.SESSOSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.SESSO,1));
            /* mcOPERAZIONI.CODFISCSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODFISC,16)) // Codice Fiscale Soggetto */
            mcOPERAZIONI.row.CODFISCSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODFISC,16));
            /* mcOPERAZIONI.DATANASCSOGG := rw_soggetto.DATANASC // Data di Nascita del Soggetto */
            mcOPERAZIONI.row.DATANASCSOGG = rw_soggetto.DATANASC;
            /* mcOPERAZIONI.NASCOMUNSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.NASCOMU,30)) // Comune/Paese di Nascita */
            mcOPERAZIONI.row.NASCOMUNSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.NASCOMU,30));
            /* mcOPERAZIONI.COMUNRESSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.DESCCIT,40)) // Comune di Residenza */
            mcOPERAZIONI.row.COMUNRESSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.DESCCIT,40));
            /* mcOPERAZIONI.CABRESISOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODCAB,6)) // CAB comune di Residenza */
            mcOPERAZIONI.row.CABRESISOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODCAB,6));
            /* mcOPERAZIONI.PAESESOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.STATO,3)) // Paese di Residenza */
            mcOPERAZIONI.row.PAESESOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.STATO,3));
            /* mcOPERAZIONI.SAESOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.SAE,3)) // SAE */
            mcOPERAZIONI.row.SAESOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.SAE,3));
            /* mcOPERAZIONI.ATECOSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.ATECO,3)) // ATECO */
            mcOPERAZIONI.row.ATECOSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.ATECO,3));
          }
          Cursor_qbe_frad_chkdiana.Next();
        }
        m_cConnectivityError = Cursor_qbe_frad_chkdiana.ErrorMessage();
        Cursor_qbe_frad_chkdiana.Close();
        // * --- End Select
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_frad_chkdiana_limits!=null)
          Cursor_qbe_frad_chkdiana_limits.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_frad_chkdiana!=null)
          Cursor_qbe_frad_chkdiana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_11() throws Exception {
    CPResultSet Cursor_qbe_oped_chkdiana_cli=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle operazioni di uno specifico cliente */
      /* gMsgImp := 'Verifica Operazioni del cliente da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Operazioni del cliente da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _tipoperazione := 'O' */
      _tipoperazione = "O";
      // * --- Select from qbe_oped_chkdiana_cli
      SPBridge.HMCaller _h0000018A;
      _h0000018A = new SPBridge.HMCaller();
      _h0000018A.Set("m_cVQRList",m_cVQRList);
      _h0000018A.Set("cdadata",w_cdadata);
      _h0000018A.Set("c_adata",w_c_adata);
      _h0000018A.Set("codage",w_codage);
      _h0000018A.Set("codcli",w_codcli);
      _h0000018A.Set("ragben",w_ragben);
      _h0000018A.Set("cdareg",w_cdareg);
      _h0000018A.Set("c_areg",w_c_areg);
      if (Cursor_qbe_oped_chkdiana_cli!=null)
        Cursor_qbe_oped_chkdiana_cli.Close();
      Cursor_qbe_oped_chkdiana_cli = new VQRHolder("qbe_oped_chkdiana_cli",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000018A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_oped_chkdiana_cli.Eof())) {
        /* _idb := qbe_oped_chkdiana_cli->IDBASE */
        _idb = Cursor_qbe_oped_chkdiana_cli.GetString("IDBASE");
        /* _connescli := qbe_oped_chkdiana_cli->CONNESCLI */
        _connescli = Cursor_qbe_oped_chkdiana_cli.GetString("CONNESCLI");
        /* _datastorico := iif(w_stoper='R',qbe_oped_chkdiana_cli->DATAREG,qbe_oped_chkdiana_cli->DATAOPE) */
        _datastorico = (CPLib.eqr(w_stoper,"R")?Cursor_qbe_oped_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_oped_chkdiana_cli.GetDate("DATAOPE"));
        /* _statooperazione := qbe_oped_chkdiana_cli->STATOREG */
        _statooperazione = Cursor_qbe_oped_chkdiana_cli.GetString("STATOREG");
        /* _datarettifica := qbe_oped_chkdiana_cli->DATARETT */
        _datarettifica = Cursor_qbe_oped_chkdiana_cli.GetDate("DATARETT");
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* gMsgImp := 'Elaborazione Operazione N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
        gMsgImp = "Elaborazione Operazione N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* rwOPE.TIPOINTER := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->TIPOINTER,2)) // Tipo Intermediario */
        rwOPE.TIPOINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("TIPOINTER"),2));
        /* rwOPE.CODINTER := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->CODINTER,11)) // Codice Intermediario */
        rwOPE.CODINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("CODINTER"),11));
        /* _idereg := arfn_calc_idereg("O",qbe_oped_chkdiana_cli->NUMPROG,qbe_oped_chkdiana_cli->IDEREG) */
        _idereg = arfn_calc_ideregR.Make(m_Ctx,this).Run("O",Cursor_qbe_oped_chkdiana_cli.GetString("NUMPROG"),Cursor_qbe_oped_chkdiana_cli.GetString("IDEREG"));
        /* rwOPE.IDEREG := Upper(LibreriaMit.SpacePad(_idereg,20)) // Identificativo Operazione */
        rwOPE.IDEREG = CPLib.Upper(LibreriaMit.SpacePad(_idereg,20));
        /* pCodDip := qbe_oped_chkdiana_cli->CODDIPE // Codice Dipendenza */
        pCodDip = Cursor_qbe_oped_chkdiana_cli.GetString("CODDIPE");
        /* pCodCabFil := Space(12) // CAB Filiale  */
        pCodCabFil = CPLib.Space(12);
        /* pCodCab := qbe_oped_chkdiana_cli->CODCAB // CAB Dipendenza */
        pCodCab = Cursor_qbe_oped_chkdiana_cli.GetString("CODCAB");
        /* pDesCit := qbe_oped_chkdiana_cli->DESCCIT // Città Dipendenza */
        pDesCit = Cursor_qbe_oped_chkdiana_cli.GetString("DESCCIT");
        /* pProv := qbe_oped_chkdiana_cli->PROVINCIA // Provincia Dipendenza */
        pProv = Cursor_qbe_oped_chkdiana_cli.GetString("PROVINCIA");
        /* Exec "Dati Agenzia" Page 11:Page_17 */
        Page_17();
        /* rwOPE.CODDIPE := Upper(LibreriaMit.SpacePad(pCodDip,12)) // Codice Intermediario */
        rwOPE.CODDIPE = CPLib.Upper(LibreriaMit.SpacePad(pCodDip,12));
        /* rwOPE.CABFIL := Upper(LibreriaMit.SpacePad(pCodCabFil,12)) // CAB Filiale  */
        rwOPE.CABFIL = CPLib.Upper(LibreriaMit.SpacePad(pCodCabFil,12));
        /* rwOPE.CABCOMU := Upper(LibreriaMit.SpacePad(pCodCab,6)) // CAB Dipendenza */
        rwOPE.CABCOMU = CPLib.Upper(LibreriaMit.SpacePad(pCodCab,6));
        /* rwOPE.DESCCIT := Upper(LibreriaMit.SpacePad(pDesCit,30)) // Città Dipendenza */
        rwOPE.DESCCIT = CPLib.Upper(LibreriaMit.SpacePad(pDesCit,30));
        /* rwOPE.PROVINCIA := Upper(LibreriaMit.SpacePad(pProv,2)) // Provincia Dipendenza */
        rwOPE.PROVINCIA = CPLib.Upper(LibreriaMit.SpacePad(pProv,2));
        /* rwOPE.DATAOPE := qbe_oped_chkdiana_cli->DATAOPE // Data Operazione */
        rwOPE.DATAOPE = Cursor_qbe_oped_chkdiana_cli.GetDate("DATAOPE");
        /* rwOPE.CODANA := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->CODANA,4)) // Causale Analitica */
        rwOPE.CODANA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("CODANA"),4));
        /* rwOPE.SEGNO := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->SEGNO,1)) // Segno */
        rwOPE.SEGNO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("SEGNO"),1));
        /* rwOPE.VALUTA := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->VALUTA,3)) // Valuta */
        rwOPE.VALUTA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("VALUTA"),3));
        /* rwOPE.TOTLIRE :=  qbe_oped_chkdiana_cli->TOTLIRE // Importo euro */
        rwOPE.TOTLIRE = Cursor_qbe_oped_chkdiana_cli.GetDouble("TOTLIRE");
        /* rwOPE.TOTCONT := qbe_oped_chkdiana_cli->TOTCONT // Importo parte contanti */
        rwOPE.TOTCONT = Cursor_qbe_oped_chkdiana_cli.GetDouble("TOTCONT");
        /* rwOPE.RAPPORTO := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->RAPPORTO,34)) // Identificativo Rapporto */
        rwOPE.RAPPORTO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("RAPPORTO"),34));
        /* If not(Empty(qbe_oped_chkdiana_cli->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER")))) {
          /* rwSOG := arfn_datisog_sol_row(qbe_oped_chkdiana_cli->CONNESOPER,_datastorico,_statooperazione,_datarettifica) */
          rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_qbe_oped_chkdiana_cli.GetString("CONNESOPER"),_datastorico,_statooperazione,_datarettifica);
          /* rwOPE.CONNESESE := Upper(LibreriaMit.SpacePad(rwSOG.NDG,16)) // NDG */
          rwOPE.CONNESESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.NDG,16));
          /* rwOPE.RAGSOGESE := Upper(LibreriaMit.SpacePad(rwSOG.RAGSOC,70)) // Cognome Nome */
          rwOPE.RAGSOGESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.RAGSOC,70));
          /* rwOPE.CODFISCESE := Upper(LibreriaMit.SpacePad(rwSOG.CODFISC,16)) // Codice Fiscale */
          rwOPE.CODFISCESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.CODFISC,16));
          /* rwOPE.DATANASCESE := rwSOG.DATANASC // Data di Nascita */
          rwOPE.DATANASCESE = rwSOG.DATANASC;
          /* rwOPE.NASCCOMUNESE := Upper(LibreriaMit.SpacePad(rwSOG.NASCOMU,30)) // Comune/Stato di Nascita */
          rwOPE.NASCCOMUNESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.NASCOMU,30));
        } else { // Else
          /* rwOPE.CONNESESE := Space(16) // NDG */
          rwOPE.CONNESESE = CPLib.Space(16);
          /* rwOPE.RAGSOGESE := Space(70) // Cognome Nome */
          rwOPE.RAGSOGESE = CPLib.Space(70);
          /* rwOPE.CODFISCESE := Space(16) // Codice Fiscale */
          rwOPE.CODFISCESE = CPLib.Space(16);
          /* rwOPE.DATANASCESE := NullDate() // Data di Nascita */
          rwOPE.DATANASCESE = CPLib.NullDate();
          /* rwOPE.NASCCOMUNESE := Space(30) // Comune/Stato di Nascita */
          rwOPE.NASCCOMUNESE = CPLib.Space(30);
        } // End If
        /* rwOPE.C_RAG := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->C_RAG,70)) // Cognome Nome/Ragione Sociale */
        rwOPE.C_RAG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAG"),70));
        /* rwOPE.C_STA := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->C_STA,3)) // Paese */
        rwOPE.C_STA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("C_STA"),3));
        /* rwOPE.C_CAB := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->C_CAB,6)) // CAB */
        rwOPE.C_CAB = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("C_CAB"),6));
        /* rwOPE.C_CTA := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->C_CTA,40)) // Comune */
        rwOPE.C_CTA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("C_CTA"),40));
        /* rwOPE.CODINT2 := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->CODINT2,11)) // Codice Intermediario */
        rwOPE.CODINT2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("CODINT2"),11));
        /* rwOPE.DESCINTER := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->DESCINTER,70)) // Denominazione Intermediario */
        rwOPE.DESCINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("DESCINTER"),70));
        /* rwOPE.PAESE := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->PAESE,3)) // Paese Intermediario */
        rwOPE.PAESE = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("PAESE"),3));
        /* rwOPE.CODCAB2 := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->CODCAB2,6)) // CAB Intermediario */
        rwOPE.CODCAB2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("CODCAB2"),6));
        /* rwOPE.C_RAPPORTO := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->C_RAPPORTO,34)) // IBAN / Rapporto */
        rwOPE.C_RAPPORTO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("C_RAPPORTO"),34));
        /* rwOPE.CODCAB2 := Upper(LibreriaMit.SpacePad(qbe_oped_chkdiana_cli->CODCAB2,6)) // CAB Intermediario */
        rwOPE.CODCAB2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_oped_chkdiana_cli.GetString("CODCAB2"),6));
        /* rwOPE.FILLER := Space(69) // A Disposizione */
        rwOPE.FILLER = CPLib.Space(69);
        /* Exec "Soggetti" Page 12:Page_12 */
        Page_12();
        for (MemoryCursorRow_mcsoggettiall1_mcrdef rw_soggetto : mcSOGGETTI._iterable_()) {
          /* mcOPERAZIONI.AppendRow(rwOPE) */
          mcOPERAZIONI.AppendRow(rwOPE);
          /* mcOPERAZIONI.CODTIPSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODTIPSOG,2)) // Codice Tipo Soggetto */
          mcOPERAZIONI.row.CODTIPSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODTIPSOG,2));
          /* mcOPERAZIONI.CONNESSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.NDG,16)) // NDG Soggetto */
          mcOPERAZIONI.row.CONNESSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.NDG,16));
          /* mcOPERAZIONI.RAGSOGSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.RAGSOC,70)) // Cognome Nome/Ragione Sociale Soggetto */
          mcOPERAZIONI.row.RAGSOGSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.RAGSOC,70));
          /* mcOPERAZIONI.SESSOSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.SESSO,1)) // Sesso */
          mcOPERAZIONI.row.SESSOSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.SESSO,1));
          /* mcOPERAZIONI.CODFISCSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODFISC,16)) // Codice Fiscale Soggetto */
          mcOPERAZIONI.row.CODFISCSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODFISC,16));
          /* mcOPERAZIONI.DATANASCSOGG := rw_soggetto.DATANASC // Data di Nascita del Soggetto */
          mcOPERAZIONI.row.DATANASCSOGG = rw_soggetto.DATANASC;
          /* mcOPERAZIONI.NASCOMUNSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.NASCOMU,30)) // Comune/Paese di Nascita */
          mcOPERAZIONI.row.NASCOMUNSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.NASCOMU,30));
          /* mcOPERAZIONI.COMUNRESSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.DESCCIT,40)) // Comune di Residenza */
          mcOPERAZIONI.row.COMUNRESSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.DESCCIT,40));
          /* mcOPERAZIONI.CABRESISOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODCAB,6)) // CAB comune di Residenza */
          mcOPERAZIONI.row.CABRESISOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODCAB,6));
          /* mcOPERAZIONI.PAESESOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.STATO,3)) // Paese di Residenza */
          mcOPERAZIONI.row.PAESESOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.STATO,3));
          /* mcOPERAZIONI.SAESOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.SAE,3)) // SAE */
          mcOPERAZIONI.row.SAESOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.SAE,3));
          /* mcOPERAZIONI.ATECOSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.ATECO,3)) // ATECO */
          mcOPERAZIONI.row.ATECOSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.ATECO,3));
        }
        Cursor_qbe_oped_chkdiana_cli.Next();
      }
      m_cConnectivityError = Cursor_qbe_oped_chkdiana_cli.ErrorMessage();
      Cursor_qbe_oped_chkdiana_cli.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_oped_chkdiana_cli!=null)
          Cursor_qbe_oped_chkdiana_cli.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_13() throws Exception {
    CPResultSet Cursor_qbe_frad_chkdiana_cli=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Cicla sulle frazionate di uno specifico cliente */
      /* gMsgImp := 'Verifica Frazionate del cliente da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica Frazionate del cliente da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _tipoperazione := 'F' */
      _tipoperazione = "F";
      /* _conta := _conta + 1 */
      _conta = CPLib.Round(_conta+1,0);
      // * --- Select from qbe_frad_chkdiana_cli
      SPBridge.HMCaller _h000001D7;
      _h000001D7 = new SPBridge.HMCaller();
      _h000001D7.Set("m_cVQRList",m_cVQRList);
      _h000001D7.Set("cdadata",w_cdadata);
      _h000001D7.Set("c_adata",w_c_adata);
      _h000001D7.Set("codage",w_codage);
      _h000001D7.Set("codcli",w_codcli);
      _h000001D7.Set("ragben",w_ragben);
      _h000001D7.Set("cdareg",w_cdareg);
      _h000001D7.Set("c_areg",w_c_areg);
      if (Cursor_qbe_frad_chkdiana_cli!=null)
        Cursor_qbe_frad_chkdiana_cli.Close();
      Cursor_qbe_frad_chkdiana_cli = new VQRHolder("qbe_frad_chkdiana_cli",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001D7,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_frad_chkdiana_cli.Eof())) {
        /* _idb := qbe_frad_chkdiana_cli->IDBASE */
        _idb = Cursor_qbe_frad_chkdiana_cli.GetString("IDBASE");
        /* _connescli := qbe_frad_chkdiana_cli->CONNESCLI */
        _connescli = Cursor_qbe_frad_chkdiana_cli.GetString("CONNESCLI");
        /* _datastorico := iif(w_stoper='R',qbe_frad_chkdiana_cli->DATAREG,qbe_frad_chkdiana_cli->DATAOPE) */
        _datastorico = (CPLib.eqr(w_stoper,"R")?Cursor_qbe_frad_chkdiana_cli.GetDate("DATAREG"):Cursor_qbe_frad_chkdiana_cli.GetDate("DATAOPE"));
        /* _statooperazione := qbe_frad_chkdiana_cli->STATOREG */
        _statooperazione = Cursor_qbe_frad_chkdiana_cli.GetString("STATOREG");
        /* _datarettifica := qbe_frad_chkdiana_cli->DATARETT */
        _datarettifica = Cursor_qbe_frad_chkdiana_cli.GetDate("DATARETT");
        /* _ctotale := _ctotale + 1 */
        _ctotale = CPLib.Round(_ctotale+1,0);
        /* gMsgImp := 'Elaborazione Frazionata N.: '+LRTrim(Str(_ctotale,15,0)) // Messaggio Import */
        gMsgImp = "Elaborazione Frazionata N.: "+CPLib.LRTrim(CPLib.Str(_ctotale,15,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* rwOPE.TIPOINTER := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->TIPOINTER,2)) // Tipo Intermediario */
        rwOPE.TIPOINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("TIPOINTER"),2));
        /* rwOPE.CODINTER := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->CODINTER,11)) // Codice Intermediario */
        rwOPE.CODINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("CODINTER"),11));
        /* _idereg := arfn_calc_idereg("F",qbe_frad_chkdiana_cli->NUMPROG,qbe_frad_chkdiana_cli->IDEREG) */
        _idereg = arfn_calc_ideregR.Make(m_Ctx,this).Run("F",Cursor_qbe_frad_chkdiana_cli.GetString("NUMPROG"),Cursor_qbe_frad_chkdiana_cli.GetString("IDEREG"));
        /* rwOPE.IDEREG := Upper(LibreriaMit.SpacePad(_idereg,20)) // Identificativo Operazione */
        rwOPE.IDEREG = CPLib.Upper(LibreriaMit.SpacePad(_idereg,20));
        /* pCodDip := qbe_frad_chkdiana_cli->CODDIPE // Codice Dipendenza */
        pCodDip = Cursor_qbe_frad_chkdiana_cli.GetString("CODDIPE");
        /* pCodCabFil := Space(12) // CAB Filiale  */
        pCodCabFil = CPLib.Space(12);
        /* pCodCab := qbe_frad_chkdiana_cli->CODCAB // CAB Dipendenza */
        pCodCab = Cursor_qbe_frad_chkdiana_cli.GetString("CODCAB");
        /* pDesCit := qbe_frad_chkdiana_cli->DESCCIT // Città Dipendenza */
        pDesCit = Cursor_qbe_frad_chkdiana_cli.GetString("DESCCIT");
        /* pProv := qbe_frad_chkdiana_cli->PROVINCIA // Provincia Dipendenza */
        pProv = Cursor_qbe_frad_chkdiana_cli.GetString("PROVINCIA");
        /* Exec "Dati Agenzia" Page 11:Page_17 */
        Page_17();
        /* rwOPE.CODDIPE := Upper(LibreriaMit.SpacePad(pCodDip,12)) // Codice Intermediario */
        rwOPE.CODDIPE = CPLib.Upper(LibreriaMit.SpacePad(pCodDip,12));
        /* rwOPE.CABFIL := Upper(LibreriaMit.SpacePad(pCodCabFil,12)) // CAB Filiale  */
        rwOPE.CABFIL = CPLib.Upper(LibreriaMit.SpacePad(pCodCabFil,12));
        /* rwOPE.CABCOMU := Upper(LibreriaMit.SpacePad(pCodCab,6)) // CAB Dipendenza */
        rwOPE.CABCOMU = CPLib.Upper(LibreriaMit.SpacePad(pCodCab,6));
        /* rwOPE.DESCCIT := Upper(LibreriaMit.SpacePad(pDesCit,30)) // Città Dipendenza */
        rwOPE.DESCCIT = CPLib.Upper(LibreriaMit.SpacePad(pDesCit,30));
        /* rwOPE.PROVINCIA := Upper(LibreriaMit.SpacePad(pProv,2)) // Provincia Dipendenza */
        rwOPE.PROVINCIA = CPLib.Upper(LibreriaMit.SpacePad(pProv,2));
        /* rwOPE.DATAOPE := qbe_frad_chkdiana_cli->DATAOPE // Data Operazione */
        rwOPE.DATAOPE = Cursor_qbe_frad_chkdiana_cli.GetDate("DATAOPE");
        /* rwOPE.CODANA := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->CODANA,4)) // Causale Analitica */
        rwOPE.CODANA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("CODANA"),4));
        /* rwOPE.SEGNO := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->SEGNO,1)) // Segno */
        rwOPE.SEGNO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("SEGNO"),1));
        /* rwOPE.VALUTA := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->VALUTA,3)) // Valuta */
        rwOPE.VALUTA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("VALUTA"),3));
        /* rwOPE.TOTLIRE := qbe_frad_chkdiana_cli->TOTLIRE // Importo euro */
        rwOPE.TOTLIRE = Cursor_qbe_frad_chkdiana_cli.GetDouble("TOTLIRE");
        /* rwOPE.TOTCONT := qbe_frad_chkdiana_cli->TOTCONT // Importo parte contanti */
        rwOPE.TOTCONT = Cursor_qbe_frad_chkdiana_cli.GetDouble("TOTCONT");
        /* rwOPE.RAPPORTO := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->RAPPORTO,34)) // Identificativo Rapporto */
        rwOPE.RAPPORTO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("RAPPORTO"),34));
        /* If not(Empty(qbe_frad_chkdiana_cli->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER")))) {
          /* rwSOG := arfn_datisog_sol_row(qbe_frad_chkdiana_cli->CONNESOPER,_datastorico,_statooperazione,_datarettifica) */
          rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_qbe_frad_chkdiana_cli.GetString("CONNESOPER"),_datastorico,_statooperazione,_datarettifica);
          /* rwOPE.CONNESESE := Upper(LibreriaMit.SpacePad(rwSOG.NDG,16)) // NDG */
          rwOPE.CONNESESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.NDG,16));
          /* rwOPE.RAGSOGESE := Upper(LibreriaMit.SpacePad(rwSOG.RAGSOC,70)) // Cognome Nome */
          rwOPE.RAGSOGESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.RAGSOC,70));
          /* rwOPE.CODFISCESE := Upper(LibreriaMit.SpacePad(rwSOG.CODFISC,16)) // Codice Fiscale */
          rwOPE.CODFISCESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.CODFISC,16));
          /* rwOPE.DATANASCESE := rwSOG.DATANASC // Data di Nascita */
          rwOPE.DATANASCESE = rwSOG.DATANASC;
          /* rwOPE.NASCCOMUNESE := Upper(LibreriaMit.SpacePad(rwSOG.NASCOMU,30)) // Comune/Stato di Nascita */
          rwOPE.NASCCOMUNESE = CPLib.Upper(LibreriaMit.SpacePad(rwSOG.NASCOMU,30));
        } else { // Else
          /* rwOPE.CONNESESE := Space(16) // NDG */
          rwOPE.CONNESESE = CPLib.Space(16);
          /* rwOPE.RAGSOGESE := Space(70) // Cognome Nome */
          rwOPE.RAGSOGESE = CPLib.Space(70);
          /* rwOPE.CODFISCESE := Space(16) // Codice Fiscale */
          rwOPE.CODFISCESE = CPLib.Space(16);
          /* rwOPE.DATANASCESE := NullDate() // Data di Nascita */
          rwOPE.DATANASCESE = CPLib.NullDate();
          /* rwOPE.NASCCOMUNESE := Space(30) // Comune/Stato di Nascita */
          rwOPE.NASCCOMUNESE = CPLib.Space(30);
        } // End If
        /* rwOPE.C_RAG := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->C_RAG,70)) // Cognome Nome/Ragione Sociale */
        rwOPE.C_RAG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAG"),70));
        /* rwOPE.C_STA := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->C_STA,3)) // Paese */
        rwOPE.C_STA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("C_STA"),3));
        /* rwOPE.C_CAB := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->C_CAB,6)) // CAB */
        rwOPE.C_CAB = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("C_CAB"),6));
        /* rwOPE.C_CTA := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->C_CTA,40)) // Comune */
        rwOPE.C_CTA = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("C_CTA"),40));
        /* rwOPE.CODINT2 := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->CODINT2,11)) // Codice Intermediario */
        rwOPE.CODINT2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("CODINT2"),11));
        /* rwOPE.DESCINTER := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->DESCINTER,70)) // Denominazione Intermediario */
        rwOPE.DESCINTER = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("DESCINTER"),70));
        /* rwOPE.PAESE := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->PAESE,3)) // Paese Intermediario */
        rwOPE.PAESE = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("PAESE"),3));
        /* rwOPE.CODCAB2 := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->CODCAB2,6)) // CAB Intermediario */
        rwOPE.CODCAB2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("CODCAB2"),6));
        /* rwOPE.C_RAPPORTO := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->C_RAPPORTO,34)) // IBAN / Rapporto */
        rwOPE.C_RAPPORTO = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("C_RAPPORTO"),34));
        /* rwOPE.CODCAB2 := Upper(LibreriaMit.SpacePad(qbe_frad_chkdiana_cli->CODCAB2,6)) // CAB Intermediario */
        rwOPE.CODCAB2 = CPLib.Upper(LibreriaMit.SpacePad(Cursor_qbe_frad_chkdiana_cli.GetString("CODCAB2"),6));
        /* rwOPE.FILLER := Space(69) // A Disposizione */
        rwOPE.FILLER = CPLib.Space(69);
        /* Exec "Soggetti" Page 12:Page_12 */
        Page_12();
        for (MemoryCursorRow_mcsoggettiall1_mcrdef rw_soggetto : mcSOGGETTI._iterable_()) {
          /* mcOPERAZIONI.AppendRow(rwOPE) */
          mcOPERAZIONI.AppendRow(rwOPE);
          /* mcOPERAZIONI.CODTIPSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODTIPSOG,2)) // Codice Tipo Soggetto */
          mcOPERAZIONI.row.CODTIPSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODTIPSOG,2));
          /* mcOPERAZIONI.CONNESSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.NDG,16)) // NDG Soggetto */
          mcOPERAZIONI.row.CONNESSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.NDG,16));
          /* mcOPERAZIONI.RAGSOGSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.RAGSOC,70)) // Cognome Nome/Ragione Sociale Soggetto */
          mcOPERAZIONI.row.RAGSOGSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.RAGSOC,70));
          /* mcOPERAZIONI.SESSOSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.SESSO,1)) // Sesso */
          mcOPERAZIONI.row.SESSOSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.SESSO,1));
          /* mcOPERAZIONI.CODFISCSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODFISC,16)) // Codice Fiscale Soggetto */
          mcOPERAZIONI.row.CODFISCSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODFISC,16));
          /* mcOPERAZIONI.DATANASCSOGG := rw_soggetto.DATANASC // Data di Nascita del Soggetto */
          mcOPERAZIONI.row.DATANASCSOGG = rw_soggetto.DATANASC;
          /* mcOPERAZIONI.NASCOMUNSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.NASCOMU,30)) // Comune/Paese di Nascita */
          mcOPERAZIONI.row.NASCOMUNSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.NASCOMU,30));
          /* mcOPERAZIONI.COMUNRESSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.DESCCIT,40)) // Comune di Residenza */
          mcOPERAZIONI.row.COMUNRESSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.DESCCIT,40));
          /* mcOPERAZIONI.CABRESISOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.CODCAB,6)) // CAB comune di Residenza */
          mcOPERAZIONI.row.CABRESISOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.CODCAB,6));
          /* mcOPERAZIONI.PAESESOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.STATO,3)) // Paese di Residenza */
          mcOPERAZIONI.row.PAESESOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.STATO,3));
          /* mcOPERAZIONI.SAESOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.SAE,3)) // SAE */
          mcOPERAZIONI.row.SAESOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.SAE,3));
          /* mcOPERAZIONI.ATECOSOGG := Upper(LibreriaMit.SpacePad(rw_soggetto.ATECO,3)) // ATECO */
          mcOPERAZIONI.row.ATECOSOGG = CPLib.Upper(LibreriaMit.SpacePad(rw_soggetto.ATECO,3));
        }
        Cursor_qbe_frad_chkdiana_cli.Next();
      }
      m_cConnectivityError = Cursor_qbe_frad_chkdiana_cli.ErrorMessage();
      Cursor_qbe_frad_chkdiana_cli.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_frad_chkdiana_cli!=null)
          Cursor_qbe_frad_chkdiana_cli.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_16() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _clientiope := False */
      _clientiope = false;
      /* _terzistiope := False */
      _terzistiope = false;
      /* _clientifrz := False */
      _clientifrz = false;
      /* _terzistifrz := False */
      _terzistifrz = false;
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000226;
      _h00000226 = new SPBridge.HMCaller();
      _h00000226.Set("m_cVQRList",m_cVQRList);
      _h00000226.Set("tbname","clientiope");
      _h00000226.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000226,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientiope := qbe_tab_mmc->tot > 0 */
        _clientiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h00000228;
      _h00000228 = new SPBridge.HMCaller();
      _h00000228.Set("m_cVQRList",m_cVQRList);
      _h00000228.Set("tbname","terzistiope");
      _h00000228.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000228,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _terzistiope := qbe_tab_mmc->tot > 0 */
        _terzistiope = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000022A;
      _h0000022A = new SPBridge.HMCaller();
      _h0000022A.Set("m_cVQRList",m_cVQRList);
      _h0000022A.Set("tbname","clientifrz");
      _h0000022A.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000022A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _clientifrz := qbe_tab_mmc->tot > 0 */
        _clientifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000022C;
      _h0000022C = new SPBridge.HMCaller();
      _h0000022C.Set("m_cVQRList",m_cVQRList);
      _h0000022C.Set("tbname","terzistifrz");
      _h0000022C.Set("fldname","IDFILEBO");
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000022C,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* _terzistifrz := qbe_tab_mmc->tot > 0 */
        _terzistifrz = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
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
  void Page_17() throws Exception {
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
    /* Verifica il tipo riga */
    /* If Empty(pCodDip) */
    if (CPLib.Empty(pCodDip)) {
      /* If Empty(z_coddipe) */
      if (CPLib.Empty(z_coddipe)) {
        /* pCodDip := Space(12) // Codice Dipendenza */
        pCodDip = CPLib.Space(12);
        /* pCodCabFil := Space(12) // CAB Filiale  */
        pCodCabFil = CPLib.Space(12);
        /* pCodCab := LibreriaMit.SpacePad(z_codcab,12) // CAB Dipendenza */
        pCodCab = LibreriaMit.SpacePad(z_codcab,12);
        /* pDesCit := LibreriaMit.SpacePad(z_desccit,30) // Città Dipendenza */
        pDesCit = LibreriaMit.SpacePad(z_desccit,30);
        /* pProv :=  LibreriaMit.SpacePad(z_provin,2) // Provincia Dipendenza */
        pProv = LibreriaMit.SpacePad(z_provin,2);
      } else { // Else
        /* pCodDip := LibreriaMit.SpacePad(z_coddipe,12) // Codice Dipendenza */
        pCodDip = LibreriaMit.SpacePad(z_coddipe,12);
        /* If mcANADIP.GoToKey(z_coddipe) */
        if (mcANADIP.GoToKey(z_coddipe)) {
          /* pCodCabFil := LibreriaMit.SpacePad(mcANADIP.ABICABSARA,12) // CAB Filiale  */
          pCodCabFil = LibreriaMit.SpacePad(mcANADIP.row.ABICABSARA,12);
          /* pCodCab := LibreriaMit.SpacePad(mcANADIP.CAB,12) // CAB Dipendenza */
          pCodCab = LibreriaMit.SpacePad(mcANADIP.row.CAB,12);
          /* pDesCit := LibreriaMit.SpacePad(mcANADIP.DESCCIT,30) // Città Dipendenza */
          pDesCit = LibreriaMit.SpacePad(mcANADIP.row.DESCCIT,30);
          /* pProv :=  LibreriaMit.SpacePad(mcANADIP.PROVINCIA,2) // Provincia Dipendenza */
          pProv = LibreriaMit.SpacePad(mcANADIP.row.PROVINCIA,2);
        } else { // Else
          /* pCodCabFil := Space(12) // CAB Filiale  */
          pCodCabFil = CPLib.Space(12);
          /* pCodCab := LibreriaMit.SpacePad(z_codcab,12) // CAB Dipendenza */
          pCodCab = LibreriaMit.SpacePad(z_codcab,12);
          /* pDesCit := LibreriaMit.SpacePad(z_desccit,30) // Città Dipendenza */
          pDesCit = LibreriaMit.SpacePad(z_desccit,30);
          /* pProv :=  LibreriaMit.SpacePad(z_provin,2) // Provincia Dipendenza */
          pProv = LibreriaMit.SpacePad(z_provin,2);
        } // End If
      } // End If
    } else { // Else
      /* pCodDip := LibreriaMit.SpacePad(pCodDip,12) // Codice Dipendenza */
      pCodDip = LibreriaMit.SpacePad(pCodDip,12);
      /* If mcANADIP.GoToKey(pCodDip) */
      if (mcANADIP.GoToKey(pCodDip)) {
        /* pCodCabFil := iif(Empty(LRTrim(pCodCabFil)),LibreriaMit.SpacePad(mcANADIP.ABICABSARA,12),Space(12)) // CAB Filiale  */
        pCodCabFil = (CPLib.Empty(CPLib.LRTrim(pCodCabFil))?LibreriaMit.SpacePad(mcANADIP.row.ABICABSARA,12):CPLib.Space(12));
        /* pCodCab := iif(Empty(LRTrim(pCodCab)),LibreriaMit.SpacePad(mcANADIP.CAB,12),LibreriaMit.SpacePad(pCodCab,12)) // CAB Dipendenza */
        pCodCab = (CPLib.Empty(CPLib.LRTrim(pCodCab))?LibreriaMit.SpacePad(mcANADIP.row.CAB,12):LibreriaMit.SpacePad(pCodCab,12));
        /* pDesCit := iif(Empty(LRTrim(pDesCit)),LibreriaMit.SpacePad(mcANADIP.DESCCIT,30),LibreriaMit.SpacePad(pDesCit,30)) // Città Dipendenza */
        pDesCit = (CPLib.Empty(CPLib.LRTrim(pDesCit))?LibreriaMit.SpacePad(mcANADIP.row.DESCCIT,30):LibreriaMit.SpacePad(pDesCit,30));
        /* pProv := iif(Empty(LRTrim(pProv)),LibreriaMit.SpacePad(mcANADIP.PROVINCIA,2),LibreriaMit.SpacePad(pProv,2)) // Provincia Dipendenza */
        pProv = (CPLib.Empty(CPLib.LRTrim(pProv))?LibreriaMit.SpacePad(mcANADIP.row.PROVINCIA,2):LibreriaMit.SpacePad(pProv,2));
      } else { // Else
        /* pCodCabFil := LibreriaMit.SpacePad(pCodCabFil,12) // CAB Filiale  */
        pCodCabFil = LibreriaMit.SpacePad(pCodCabFil,12);
        /* pCodCab := LibreriaMit.SpacePad(pCodCab,12) // CAB Dipendenza */
        pCodCab = LibreriaMit.SpacePad(pCodCab,12);
        /* pDesCit := LibreriaMit.SpacePad(pDesCit,30) // Città Dipendenza */
        pDesCit = LibreriaMit.SpacePad(pDesCit,30);
        /* pProv :=  LibreriaMit.SpacePad(pProv,2) // Provincia Dipendenza */
        pProv = LibreriaMit.SpacePad(pProv,2);
      } // End If
    } // End If
  }
  void Page_12() throws Exception {
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_terzistifrz=null;
    try {
      /* _coint Bool */
      boolean _coint;
      _coint = false;
      /* -- Popolo il MC soggetti per i record */
      /* mcSOGGETTI.Zap() */
      mcSOGGETTI.Zap();
      /* _coint := False */
      _coint = false;
      /* If _clientiope  or _clientifrz */
      if (_clientiope || _clientifrz) {
        /* If _tipoperazione='O' */
        if (CPLib.eqr(_tipoperazione,"O")) {
          // * --- Select from clientiope
          m_cServer = m_Ctx.GetServer("clientiope");
          m_cPhName = m_Ctx.GetPhName("clientiope");
          if (Cursor_clientiope!=null)
            Cursor_clientiope.Close();
          Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer, m_oParameters),m_cServer,_idb)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientiope.Eof())) {
            /* If clientiope->CODSOG<>_connescli */
            if (CPLib.ne(Cursor_clientiope.GetString("CODSOG"),_connescli)) {
              /* _coint := True */
              _coint = true;
              /* rwSOG := arfn_datisog_sol_row(clientiope->CODSOG,_datastorico,_statooperazione,_datarettifica) */
              rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_clientiope.GetString("CODSOG"),_datastorico,_statooperazione,_datarettifica);
              /* rwSOG.CODTIPSOG := '02' */
              rwSOG.CODTIPSOG = "02";
              /* mcSOGGETTI.AppendRow(rwSOG) */
              mcSOGGETTI.AppendRow(rwSOG);
            } // End If
            Cursor_clientiope.Next();
          }
          m_cConnectivityError = Cursor_clientiope.ErrorMessage();
          Cursor_clientiope.Close();
          // * --- End Select
        } else { // Else
          // * --- Select from clientifrz
          m_cServer = m_Ctx.GetServer("clientifrz");
          m_cPhName = m_Ctx.GetPhName("clientifrz");
          if (Cursor_clientifrz!=null)
            Cursor_clientifrz.Close();
          Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer, m_oParameters),m_cServer,_idb)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientifrz.Eof())) {
            /* If clientifrz->CODSOG<>_connescli */
            if (CPLib.ne(Cursor_clientifrz.GetString("CODSOG"),_connescli)) {
              /* _coint := True */
              _coint = true;
              /* rwSOG := arfn_datisog_sol_row(clientifrz->CODSOG,_datastorico,_statooperazione,_datarettifica) */
              rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_clientifrz.GetString("CODSOG"),_datastorico,_statooperazione,_datarettifica);
              /* rwSOG.CODTIPSOG := '02' */
              rwSOG.CODTIPSOG = "02";
              /* mcSOGGETTI.AppendRow(rwSOG) */
              mcSOGGETTI.AppendRow(rwSOG);
            } // End If
            Cursor_clientifrz.Next();
          }
          m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
          Cursor_clientifrz.Close();
          // * --- End Select
        } // End If
      } // End If
      /* If not(Empty(_connescli)) */
      if ( ! (CPLib.Empty(_connescli))) {
        /* rwSOG := arfn_datisog_sol_row(_connescli,_datastorico,_statooperazione,_datarettifica) */
        rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(_connescli,_datastorico,_statooperazione,_datarettifica);
        /* rwSOG.CODTIPSOG := iif(_coint,'02','01') */
        rwSOG.CODTIPSOG = (_coint?"02":"01");
        /* mcSOGGETTI.AppendRow(rwSOG) */
        mcSOGGETTI.AppendRow(rwSOG);
      } // End If
      /* If not(Empty(_connaltro)) */
      if ( ! (CPLib.Empty(_connaltro))) {
        /* rwSOG := arfn_datisog_sol_row(_connaltro,_datastorico,_statooperazione,_datarettifica) */
        rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(_connaltro,_datastorico,_statooperazione,_datarettifica);
        /* rwSOG.CODTIPSOG := '03' */
        rwSOG.CODTIPSOG = "03";
        /* mcSOGGETTI.AppendRow(rwSOG) */
        mcSOGGETTI.AppendRow(rwSOG);
        /* If _terzistiope or _terzistifrz */
        if (_terzistiope || _terzistifrz) {
          /* If _tipoperazione='O' */
          if (CPLib.eqr(_tipoperazione,"O")) {
            // * --- Select from terzistiope
            m_cServer = m_Ctx.GetServer("terzistiope");
            m_cPhName = m_Ctx.GetPhName("terzistiope");
            if (Cursor_terzistiope!=null)
              Cursor_terzistiope.Close();
            Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer, m_oParameters),m_cServer,_idb)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistiope.Eof())) {
              /* If terzistiope->CODSOG<>_connaltro */
              if (CPLib.ne(Cursor_terzistiope.GetString("CODSOG"),_connaltro)) {
                /* rwSOG := arfn_datisog_sol_row(terzistiope->CODSOG,_datastorico,_statooperazione,_datarettifica) */
                rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_terzistiope.GetString("CODSOG"),_datastorico,_statooperazione,_datarettifica);
                /* rwSOG.CODTIPSOG := '03' */
                rwSOG.CODTIPSOG = "03";
                /* mcSOGGETTI.AppendRow(rwSOG) */
                mcSOGGETTI.AppendRow(rwSOG);
              } // End If
              Cursor_terzistiope.Next();
            }
            m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
            Cursor_terzistiope.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from terzistifrz
            m_cServer = m_Ctx.GetServer("terzistifrz");
            m_cPhName = m_Ctx.GetPhName("terzistifrz");
            if (Cursor_terzistifrz!=null)
              Cursor_terzistifrz.Close();
            Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODSOG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idb,"?",0,0,m_cServer, m_oParameters),m_cServer,_idb)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_terzistifrz.Eof())) {
              /* If terzistifrz->CODSOG<>_connaltro */
              if (CPLib.ne(Cursor_terzistifrz.GetString("CODSOG"),_connaltro)) {
                /* rwSOG := arfn_datisog_sol_row(terzistifrz->CODSOG,_datastorico,_statooperazione,_datarettifica) */
                rwSOG = arfn_datisog_sol_rowR.Make(m_Ctx,this).Run(Cursor_terzistifrz.GetString("CODSOG"),_datastorico,_statooperazione,_datarettifica);
                /* rwSOG.CODTIPSOG := '03' */
                rwSOG.CODTIPSOG = "03";
                /* mcSOGGETTI.AppendRow(rwSOG) */
                mcSOGGETTI.AppendRow(rwSOG);
              } // End If
              Cursor_terzistifrz.Next();
            }
            m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
            Cursor_terzistifrz.Close();
            // * --- End Select
          } // End If
        } // End If
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
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
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
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_18() throws Exception {
    CPResultSet Cursor_qbe_anarapbo_all1=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_qbe_rapporti_all1_agg1=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_fiduciabo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* -- Rapporti */
      /* gMsgImp := 'Verifica dei Rapporti da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica dei Rapporti da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* mcANARAP.Zap() */
      mcANARAP.Zap();
      /* mcANARAP_APP.Zap() */
      mcANARAP_APP.Zap();
      /* mcRAPPORTO.Zap() */
      mcRAPPORTO.Zap();
      /* -- Prendo tutti i Rapporti da Anarapbo (eventualmente filtrati sul codice rapporto passato in maschera) */
      // * --- Fill memory cursor mcANARAP on qbe_anarapbo_all1
      mcANARAP.Zap();
      SPBridge.HMCaller _h0000027E;
      _h0000027E = new SPBridge.HMCaller();
      _h0000027E.Set("m_cVQRList",m_cVQRList);
      _h0000027E.Set("pRAPPORTO",w_rapporto);
      if (Cursor_qbe_anarapbo_all1!=null)
        Cursor_qbe_anarapbo_all1.Close();
      Cursor_qbe_anarapbo_all1 = new VQRHolder("qbe_anarapbo_all1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000027E,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_anarapbo_all1;
        Cursor_qbe_anarapbo_all1.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arfn_estrai_all1: query on qbe_anarapbo_all1 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_anarapbo_all1.Eof())) {
        mcANARAP.AppendBlank();
        mcANARAP.row.RAPPORTO = Cursor_qbe_anarapbo_all1.GetString("RAPPORTO");
        mcANARAP.row.TIPOAG = "";
        mcANARAP.row.VALUTA = Cursor_qbe_anarapbo_all1.GetString("VALUTA");
        mcANARAP.row.DATAINI = Cursor_qbe_anarapbo_all1.GetDate("DATAINI");
        mcANARAP.row.DATAFINE = Cursor_qbe_anarapbo_all1.GetDate("DATAFINE");
        mcANARAP.row.CODDIPE = Cursor_qbe_anarapbo_all1.GetString("CODDIPE");
        Cursor_qbe_anarapbo_all1.Next();
      }
      m_cConnectivityError = Cursor_qbe_anarapbo_all1.ErrorMessage();
      Cursor_qbe_anarapbo_all1.Close();
      mcANARAP.GoTop();
      /* mcANARAP.GoTop() */
      mcANARAP.GoTop();
      /* While not(mcANARAP.Eof()) */
      while ( ! (mcANARAP.Eof())) {
        /* rwANARAP := new Row(mcANARAP.MCRDef) */
        rwANARAP = new MemoryCursorRow_mcanarap_mcrdef();
        /* rwANARAP.RAPPORTO := mcANARAP.RAPPORTO */
        rwANARAP.RAPPORTO = mcANARAP.row.RAPPORTO;
        /* rwANARAP.TIPOAG := mcANARAP.TIPOAG */
        rwANARAP.TIPOAG = mcANARAP.row.TIPOAG;
        /* rwANARAP.VALUTA := mcANARAP.VALUTA */
        rwANARAP.VALUTA = mcANARAP.row.VALUTA;
        /* -- Recupero le date di Apertura rapporto e (eventualmente) data chiusura */
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAINI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwANARAP.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwANARAP.RAPPORTO)+"  and  [NOTEMPTYDATE(DATAINI)] <> 0  and  STATOREG<>'2'  and  STATOREG<>'3' "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAINI ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* rwANARAP.DATAINI := intestbo->DATAINI */
          rwANARAP.DATAINI = Cursor_intestbo.GetDate("DATAINI");
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(mcANARAP.row.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,mcANARAP.row.RAPPORTO)+"  and  [NOTEMPTYDATE(DATAFINE)] <> 0  and  STATOREG<>'2'  and  STATOREG<>'3' "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAINI DESC ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* rwANARAP.DATAFINE := intestbo->DATAFINE */
          rwANARAP.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        /* -- FILTRO SUI RAPPORTI IN ESSERE NEL PERIODO SELEZIONATO */
        /* If w_rappAttivSel='S' */
        if (CPLib.eqr(w_rappAttivSel,"S")) {
          /* -- Ho recuperato le date di apertura e di chiusura (se chiuso) di ciascun rapporto. Filtro via tutti i rapporti che non sono attivi nel periodo */
          /* If not(Empty(rwANARAP.DATAINI)) and Empty(rwANARAP.DATAFINE) */
          if ( ! (CPLib.Empty(rwANARAP.DATAINI)) && CPLib.Empty(rwANARAP.DATAFINE)) {
            /* -- Rapporto in essere nel periodo selezionato (non cessato) */
            /* If rwANARAP.DATAINI<=w_AData */
            if (CPLib.le(rwANARAP.DATAINI,w_AData)) {
              /* mcANARAP_APP.AppendRow(rwANARAP) */
              mcANARAP_APP.AppendRow(rwANARAP);
            } // End If
            /* ElseIf not(Empty(rwANARAP.DATAINI)) and not(Empty(rwANARAP.DATAFINE)) */
          } else if ( ! (CPLib.Empty(rwANARAP.DATAINI)) &&  ! (CPLib.Empty(rwANARAP.DATAFINE))) {
            /* -- Rapporto in essere nel periodo selezionato (cessato) */
            /* If rwANARAP.DATAINI<=w_AData and rwANARAP.DATAFINE>=w_DaData */
            if (CPLib.le(rwANARAP.DATAINI,w_AData) && CPLib.ge(rwANARAP.DATAFINE,w_DaData)) {
              /* mcANARAP_APP.AppendRow(rwANARAP) */
              mcANARAP_APP.AppendRow(rwANARAP);
            } // End If
          } // End If
        } else { // Else
          /* -- Non ho filtri sulla data => prendo tutto */
          /* If not(Empty(rwANARAP.DATAINI)) */
          if ( ! (CPLib.Empty(rwANARAP.DATAINI))) {
            /* mcANARAP_APP.AppendRow(rwANARAP) */
            mcANARAP_APP.AppendRow(rwANARAP);
          } // End If
        } // End If
        /* mcANARAP.Next() */
        mcANARAP.Next();
      } // End While
      /* -- Arrivato qui ho: in mcANARAP_APP tutti e i soli rapporti che mi interessano filtrati per:
         
         ---> Data inizio & e Data fine (opzionale)
         ---> Codice Rapporto (opzionale)
         
         Con già popolati i campi: 
         -> RAPPORTO  (campo KEY)
         -> DATAINI    (campo che dovrebbe essere sempre popolato)
         -> DATAFINE (campo che può essere vuoto se il rapporto è in essere) */
      /* mcANARAP := mcANARAP_APP */
      mcANARAP = mcANARAP_APP;
      /* If not(Empty(w_codcli)) */
      if ( ! (CPLib.Empty(w_codcli))) {
        /* mcANARAP.Zap() */
        mcANARAP.Zap();
        /* mcANARAP_APP.GoTop() */
        mcANARAP_APP.GoTop();
        /* -- Filtro sul Codice Cliente attivo (devo cercare tra i rapporti selezionati quelli che coinvolgono il soggetto specificato) */
        for (MemoryCursorRow_mcanarap_mcrdef rwRAPAPP : mcANARAP_APP._iterable_()) {
          /* If Check_Sogg(w_codcli,rwRAPAPP.RAPPORTO) */
          if (Check_Sogg(w_codcli,rwRAPAPP.RAPPORTO)) {
            /* mcANARAP.AppendRow(rwRAPAPP) */
            mcANARAP.AppendRow(rwRAPAPP);
          } // End If
        }
      } // End If
      /* -- Arrivato qui ho: in mcANARAP tutti e i soli rapporti che mi interessano filtrati per:
         
         ---> Data inizio & e Data fine (opzionale)
         ---> Codice Rapporto (opzionale)
         ---> Codice Cliente (opzionale) 
         
         NOTA: le righe con il codice rapporto vuoto devono essere ignorate */
      /* gMsgImp := 'Estrazione dei dati dei Rapporti da elaborare ...' // Messaggio Import */
      gMsgImp = "Estrazione dei dati dei Rapporti da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* mcANARAP_APP.GoTop() */
      mcANARAP_APP.GoTop();
      /* While not(mcANARAP.Eof()) */
      while ( ! (mcANARAP.Eof())) {
        /* rwRAP := new Row(mcRapportoAll1.MCRDef) */
        rwRAP = new MemoryCursorRow_mcrapportoall1_mcrdef();
        /* rwRAP.TIPOINTER := Upper(LibreriaMit.SpacePad(gTipInter,2)) */
        rwRAP.TIPOINTER = CPLib.Upper(LibreriaMit.SpacePad(gTipInter,2));
        /* rwRAP.CODINTER := Upper(LibreriaMit.SpacePad(gIntemediario,11)) */
        rwRAP.CODINTER = CPLib.Upper(LibreriaMit.SpacePad(gIntemediario,11));
        /* rwRAP.RAPPORTO := Upper(LibreriaMit.SpacePad(mcANARAP.RAPPORTO,34)) */
        rwRAP.RAPPORTO = CPLib.Upper(LibreriaMit.SpacePad(mcANARAP.row.RAPPORTO,34));
        /* rwRAP.DATAPERT := mcANARAP.DATAINI */
        rwRAP.DATAPERT = mcANARAP.row.DATAINI;
        /* rwRAP.DATACHIU := mcANARAP.DATAFINE */
        rwRAP.DATACHIU = mcANARAP.row.DATAFINE;
        /* rwRAP.NDG := Upper(LibreriaMit.SpacePad('XXXXXXXXXXXXXXXX',16)) */
        rwRAP.NDG = CPLib.Upper(LibreriaMit.SpacePad("XXXXXXXXXXXXXXXX",16));
        /* rwRAP.VALUTA := Upper(LibreriaMit.SpacePad(mcANARAP.VALUTA,3)) */
        rwRAP.VALUTA = CPLib.Upper(LibreriaMit.SpacePad(mcANARAP.row.VALUTA,3));
        /* rwRAP.FILLER := Space(69) */
        rwRAP.FILLER = CPLib.Space(69);
        // * --- Select from qbe_rapporti_all1_agg1
        SPBridge.HMCaller _h000002B0;
        _h000002B0 = new SPBridge.HMCaller();
        _h000002B0.Set("m_cVQRList",m_cVQRList);
        _h000002B0.Set("pRAPPORTO",rwRAP.RAPPORTO);
        _h000002B0.Set("pINS_TIPOOPRAP","'21','22','23','24','27','33','34','35','43','44','45'");
        if (Cursor_qbe_rapporti_all1_agg1!=null)
          Cursor_qbe_rapporti_all1_agg1.Close();
        Cursor_qbe_rapporti_all1_agg1 = new VQRHolder("qbe_rapporti_all1_agg1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000002B0,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_rapporti_all1_agg1.Eof())) {
          /* Case qbe_rapporti_all1_agg1->TIPOOPRAP='22' or qbe_rapporti_all1_agg1->TIPOOPRAP='34' or qbe_rapporti_all1_agg1->TIPOOPRAP='44' */
          if (CPLib.eqr(Cursor_qbe_rapporti_all1_agg1.GetString("TIPOOPRAP"),"22") || CPLib.eqr(Cursor_qbe_rapporti_all1_agg1.GetString("TIPOOPRAP"),"34") || CPLib.eqr(Cursor_qbe_rapporti_all1_agg1.GetString("TIPOOPRAP"),"44")) {
            /* rwRAP.TIPORAPP := '01' // Conto Corrente */
            rwRAP.TIPORAPP = "01";
            /* Case qbe_rapporti_all1_agg1->TIPOOPRAP='24' */
          } else if (CPLib.eqr(Cursor_qbe_rapporti_all1_agg1.GetString("TIPOOPRAP"),"24")) {
            /* rwRAP.TIPORAPP := '02' // Dossier Titoli */
            rwRAP.TIPORAPP = "02";
            /* Case qbe_rapporti_all1_agg1->TIPOOPRAP='21' or qbe_rapporti_all1_agg1->TIPOOPRAP='23' or qbe_rapporti_all1_agg1->TIPOOPRAP='27' or qbe_rapporti_all1_agg1->TIPOOPRAP='33' */
          } else if (CPLib.eqr(Cursor_qbe_rapporti_all1_agg1.GetString("TIPOOPRAP"),"21") || CPLib.eqr(Cursor_qbe_rapporti_all1_agg1.GetString("TIPOOPRAP"),"23") || CPLib.eqr(Cursor_qbe_rapporti_all1_agg1.GetString("TIPOOPRAP"),"27") || CPLib.eqr(Cursor_qbe_rapporti_all1_agg1.GetString("TIPOOPRAP"),"33")) {
            /* rwRAP.TIPORAPP := '03' // Altro */
            rwRAP.TIPORAPP = "03";
          } // End Case
          Cursor_qbe_rapporti_all1_agg1.Next();
        }
        m_cConnectivityError = Cursor_qbe_rapporti_all1_agg1.ErrorMessage();
        Cursor_qbe_rapporti_all1_agg1.Close();
        // * --- End Select
        /* rwRAP.CODFIL := Space(12) */
        rwRAP.CODFIL = CPLib.Space(12);
        /* rwRAP.CABFIL := Space(12) */
        rwRAP.CABFIL = CPLib.Space(12);
        // * --- Select from rapopebo
        m_cServer = m_Ctx.GetServer("rapopebo");
        m_cPhName = m_Ctx.GetPhName("rapopebo");
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
        Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwRAP.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwRAP.RAPPORTO)+"  and  STATOREG<>'2'  and  STATOREG<>'3' "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_rapopebo.Eof())) {
          /* If not(Empty(rapopebo->CODDIPE)) */
          if ( ! (CPLib.Empty(Cursor_rapopebo.GetString("CODDIPE")))) {
            /* rwRAP.CODFIL := Upper(LibreriaMit.SpacePad(rapopebo->CODDIPE,12)) */
            rwRAP.CODFIL = CPLib.Upper(LibreriaMit.SpacePad(Cursor_rapopebo.GetString("CODDIPE"),12));
            /* If mcANADIP.GoToKey(rapopebo->CODDIPE) */
            if (mcANADIP.GoToKey(Cursor_rapopebo.GetString("CODDIPE"))) {
              /* rwRAP.CABFIL := Upper(LibreriaMit.SpacePad(mcANADIP.ABICABSARA,12)) */
              rwRAP.CABFIL = CPLib.Upper(LibreriaMit.SpacePad(mcANADIP.row.ABICABSARA,12));
            } // End If
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
          Cursor_rapopebo.Next();
        }
        m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
        Cursor_rapopebo.Close();
        // * --- End Select
        /* -- Gestione dei soggetti */
        /* mcINTESTBO.Zap() */
        mcINTESTBO.Zap();
        // * --- Fill memory cursor mcINTESTBO on intestbo
        mcINTESTBO.Zap();
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwRAP.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwRAP.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_intestbo;
          Cursor_intestbo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_estrai_all1: query on intestbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_intestbo.Eof())) {
          mcINTESTBO.AppendBlank();
          mcINTESTBO.row.IDBASE = Cursor_intestbo.GetString("IDBASE");
          mcINTESTBO.row.CPROWNUM = Cursor_intestbo.GetDouble("CPROWNUM");
          mcINTESTBO.row.DATAINI = Cursor_intestbo.GetDate("DATAINI");
          mcINTESTBO.row.TIPOPERS = Cursor_intestbo.GetString("TIPOPERS");
          mcINTESTBO.row.CODINTER = Cursor_intestbo.GetString("CODINTER");
          mcINTESTBO.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
          mcINTESTBO.row.NUMPROG1 = Cursor_intestbo.GetString("NUMPROG1");
          mcINTESTBO.row.NUMPROG2 = Cursor_intestbo.GetString("NUMPROG2");
          mcINTESTBO.row.RAPPORTO = Cursor_intestbo.GetString("RAPPORTO");
          mcINTESTBO.row.TIPORAP = Cursor_intestbo.GetString("TIPORAP");
          mcINTESTBO.row.STATOREG = Cursor_intestbo.GetString("STATOREG");
          mcINTESTBO.row.DESCINTER = Cursor_intestbo.GetString("DESCINTER");
          mcINTESTBO.row.OPERAZMOD = Cursor_intestbo.GetString("OPERAZMOD");
          mcINTESTBO.row.DATARETT = Cursor_intestbo.GetDate("DATARETT");
          mcINTESTBO.row.IDEREG = Cursor_intestbo.GetString("IDEREG");
          mcINTESTBO.row.COLLEGAMEN = Cursor_intestbo.GetString("COLLEGAMEN");
          mcINTESTBO.row.UCODE = Cursor_intestbo.GetString("UCODE");
          mcINTESTBO.row.ABBINATO = Cursor_intestbo.GetDouble("ABBINATO");
          mcINTESTBO.row.PRGIMPSOG = Cursor_intestbo.GetDouble("PRGIMPSOG");
          mcINTESTBO.row.PROQUOTA = Cursor_intestbo.GetDouble("PROQUOTA");
          mcINTESTBO.row.NUMIMP = Cursor_intestbo.GetDateTime("NUMIMP");
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        mcINTESTBO.GoTop();
        /* If mcINTESTBO.RecCount()>0 */
        if (CPLib.gt(mcINTESTBO.RecCount(),0)) {
          for (MemoryCursorRow_intestbo rwINTEST : mcINTESTBO._iterable_()) {
            /* mcRAPPORTO.AppendRow(rwRAP) // inserisco la ROW prepopolata (la testata) */
            mcRAPPORTO.AppendRow(rwRAP);
            /* If mcINTESTBO.RecCount()=1 */
            if (CPLib.eqr(mcINTESTBO.RecCount(),1)) {
              /* mcRAPPORTO.TIPOSOGG := '01' // Intestatario unico */
              mcRAPPORTO.row.TIPOSOGG = "01";
            } else { // Else
              /* mcRAPPORTO.TIPOSOGG := '02' // Cointestatario */
              mcRAPPORTO.row.TIPOSOGG = "02";
            } // End If
            /* mcRAPPORTO.DATAINISOGG := rwINTEST.DATAINI */
            mcRAPPORTO.row.DATAINISOGG = rwINTEST.DATAINI;
            /* mcRAPPORTO.DATAFINSOGG := rwINTEST.DATAFINE */
            mcRAPPORTO.row.DATAFINSOGG = rwINTEST.DATAFINE;
            /* mcRAPPORTO.NDGSOGG := Upper(LibreriaMit.SpacePad(rwINTEST.CODINTER,16)) */
            mcRAPPORTO.row.NDGSOGG = CPLib.Upper(LibreriaMit.SpacePad(rwINTEST.CODINTER,16));
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwINTEST.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwINTEST.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* mcRAPPORTO.RAGSOG := Upper(LibreriaMit.SpacePad(personbo->RAGSOC,70)) */
              mcRAPPORTO.row.RAGSOG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70));
              /* mcRAPPORTO.SESSOSOGG := Upper(LibreriaMit.SpacePad(personbo->SESSO,1)) */
              mcRAPPORTO.row.SESSOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SESSO"),1));
              /* mcRAPPORTO.CODFISCSOGG := Upper(LibreriaMit.SpacePad(personbo->CODFISC,16)) */
              mcRAPPORTO.row.CODFISCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16));
              /* mcRAPPORTO.DATANASCSOGG := personbo->DATANASC */
              mcRAPPORTO.row.DATANASCSOGG = Cursor_personbo.GetDate("DATANASC");
              /* If personbo->TIPINTER='EE' */
              if (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")) {
                /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASSTATO,30)) */
                mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASSTATO"),30));
              } else { // Else
                /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASCOMUN,30)) */
                mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASCOMUN"),30));
              } // End If
              /* mcRAPPORTO.DENOMSOGG := Upper(LibreriaMit.SpacePad(personbo->DOMICILIO,35)) */
              mcRAPPORTO.row.DENOMSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DOMICILIO"),35));
              /* mcRAPPORTO.COMUNRESSOGG := Upper(LibreriaMit.SpacePad(personbo->DESCCIT,40)) */
              mcRAPPORTO.row.COMUNRESSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),40));
              /* mcRAPPORTO.STATOSOGG := Upper(LibreriaMit.SpacePad(personbo->PAESE,3)) */
              mcRAPPORTO.row.STATOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("PAESE"),3));
              /* mcRAPPORTO.SAESOGG := Upper(LibreriaMit.SpacePad(personbo->SOTGRUP,3)) */
              mcRAPPORTO.row.SAESOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SOTGRUP"),3));
              /* mcRAPPORTO.ATECOSOGG := Upper(LibreriaMit.SpacePad(personbo->ATTIV,3)) */
              mcRAPPORTO.row.ATECOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("ATTIV"),3));
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* mcRAPPORTO.SaveRow() */
            mcRAPPORTO.SaveRow();
            /* mcINTESTIT.Zap() */
            mcINTESTIT.Zap();
            // * --- Fill memory cursor mcINTESTIT on intestit
            mcINTESTIT.Zap();
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwINTEST.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwINTEST.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_intestit;
              Cursor_intestit.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arfn_estrai_all1: query on intestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_intestit.Eof())) {
              mcINTESTIT.AppendBlank();
              mcINTESTIT.row.CODCLI = Cursor_intestit.GetString("CODCLI");
              mcINTESTIT.row.RAPPORTO = Cursor_intestit.GetString("RAPPORTO");
              mcINTESTIT.row.CODINTER = Cursor_intestit.GetString("CODINTER");
              mcINTESTIT.row.DESCINTER = Cursor_intestit.GetString("DESCINTER");
              mcINTESTIT.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
              mcINTESTIT.row.TIPORAP = Cursor_intestit.GetString("TIPORAP");
              mcINTESTIT.row.TIPOPERS = Cursor_intestit.GetString("TIPOPERS");
              mcINTESTIT.row.STATOREG = Cursor_intestit.GetString("STATOREG");
              mcINTESTIT.row.OPERAZMOD = Cursor_intestit.GetString("OPERAZMOD");
              mcINTESTIT.row.DATARETT = Cursor_intestit.GetDate("DATARETT");
              mcINTESTIT.row.IDEREG = Cursor_intestit.GetString("IDEREG");
              mcINTESTIT.row.COLLEGAMEN = Cursor_intestit.GetString("COLLEGAMEN");
              mcINTESTIT.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
              mcINTESTIT.row.NUMPROG1 = Cursor_intestit.GetString("NUMPROG1");
              mcINTESTIT.row.NUMPROG2 = Cursor_intestit.GetString("NUMPROG2");
              mcINTESTIT.row.IDBASE = Cursor_intestit.GetString("IDBASE");
              mcINTESTIT.row.UCODE = Cursor_intestit.GetString("UCODE");
              mcINTESTIT.row.ABBINATO = Cursor_intestit.GetDouble("ABBINATO");
              mcINTESTIT.row.PRGIMPTITE = Cursor_intestit.GetDouble("PRGIMPTITE");
              mcINTESTIT.row.NUMIMP = Cursor_intestit.GetDateTime("NUMIMP");
              mcINTESTIT.row.NOAGE = Cursor_intestit.GetString("NOAGE");
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            mcINTESTIT.GoTop();
            /* If mcINTESTIT.RecCount() > 0 */
            if (CPLib.gt(mcINTESTIT.RecCount(),0)) {
              for (MemoryCursorRow_intestit rwINT : mcINTESTIT._iterable_()) {
                /* mcRAPPORTO.AppendRow(rwRAP) // inserisco la ROW prepopolata (la testata) */
                mcRAPPORTO.AppendRow(rwRAP);
                /* mcRAPPORTO.TIPOSOGG := '03' // Titolare Effettivo */
                mcRAPPORTO.row.TIPOSOGG = "03";
                /* mcRAPPORTO.DATAINISOGG := rwINT.DATAINI */
                mcRAPPORTO.row.DATAINISOGG = rwINT.DATAINI;
                /* mcRAPPORTO.DATAFINSOGG := rwINT.DATAFINE */
                mcRAPPORTO.row.DATAFINSOGG = rwINT.DATAFINE;
                /* mcRAPPORTO.NDGSOGG := Upper(LibreriaMit.SpacePad(rwINT.CODINTER,16)) */
                mcRAPPORTO.row.NDGSOGG = CPLib.Upper(LibreriaMit.SpacePad(rwINT.CODINTER,16));
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwINT.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwINT.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* mcRAPPORTO.RAGSOG := Upper(LibreriaMit.SpacePad(personbo->RAGSOC,70)) */
                  mcRAPPORTO.row.RAGSOG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70));
                  /* mcRAPPORTO.SESSOSOGG := Upper(LibreriaMit.SpacePad(personbo->SESSO,1)) */
                  mcRAPPORTO.row.SESSOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SESSO"),1));
                  /* mcRAPPORTO.CODFISCSOGG := Upper(LibreriaMit.SpacePad(personbo->CODFISC,16)) */
                  mcRAPPORTO.row.CODFISCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16));
                  /* mcRAPPORTO.DATANASCSOGG := personbo->DATANASC */
                  mcRAPPORTO.row.DATANASCSOGG = Cursor_personbo.GetDate("DATANASC");
                  /* If personbo->TIPINTER='EE' */
                  if (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")) {
                    /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASSTATO,30)) */
                    mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASSTATO"),30));
                  } else { // Else
                    /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASCOMUN,30)) */
                    mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASCOMUN"),30));
                  } // End If
                  /* mcRAPPORTO.DENOMSOGG := Upper(LibreriaMit.SpacePad(personbo->DOMICILIO,35)) */
                  mcRAPPORTO.row.DENOMSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DOMICILIO"),35));
                  /* mcRAPPORTO.COMUNRESSOGG := Upper(LibreriaMit.SpacePad(personbo->DESCCIT,40)) */
                  mcRAPPORTO.row.COMUNRESSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),40));
                  /* mcRAPPORTO.STATOSOGG := Upper(LibreriaMit.SpacePad(personbo->PAESE,3)) */
                  mcRAPPORTO.row.STATOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("PAESE"),3));
                  /* mcRAPPORTO.SAESOGG := Upper(LibreriaMit.SpacePad(personbo->SOTGRUP,3)) */
                  mcRAPPORTO.row.SAESOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SOTGRUP"),3));
                  /* mcRAPPORTO.ATECOSOGG := Upper(LibreriaMit.SpacePad(personbo->ATTIV,3)) */
                  mcRAPPORTO.row.ATECOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("ATTIV"),3));
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* mcRAPPORTO.SaveRow() */
                mcRAPPORTO.SaveRow();
              }
            } // End If
          }
        } // End If
        // * --- Select from delegabo
        m_cServer = m_Ctx.GetServer("delegabo");
        m_cPhName = m_Ctx.GetPhName("delegabo");
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
        Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwRAP.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwRAP.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_delegabo.Eof())) {
          /* mcRAPPORTO.AppendRow(rwRAP) // inserisco la ROW prepopolata (la testata) */
          mcRAPPORTO.AppendRow(rwRAP);
          /* mcRAPPORTO.TIPOSOGG := '04' // Altro */
          mcRAPPORTO.row.TIPOSOGG = "04";
          /* mcRAPPORTO.DATAINISOGG := delegabo->DATAINI */
          mcRAPPORTO.row.DATAINISOGG = Cursor_delegabo.GetDate("DATAINI");
          /* mcRAPPORTO.DATAFINSOGG := delegabo->DATAFINE */
          mcRAPPORTO.row.DATAFINSOGG = Cursor_delegabo.GetDate("DATAFINE");
          /* mcRAPPORTO.NDGSOGG := Upper(LibreriaMit.SpacePad(delegabo->CODINTER,16)) */
          mcRAPPORTO.row.NDGSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_delegabo.GetString("CODINTER"),16));
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* mcRAPPORTO.RAGSOG := Upper(LibreriaMit.SpacePad(personbo->RAGSOC,70)) */
            mcRAPPORTO.row.RAGSOG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70));
            /* mcRAPPORTO.SESSOSOGG := Upper(LibreriaMit.SpacePad(personbo->SESSO,1)) */
            mcRAPPORTO.row.SESSOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SESSO"),1));
            /* mcRAPPORTO.CODFISCSOGG := Upper(LibreriaMit.SpacePad(personbo->CODFISC,16)) */
            mcRAPPORTO.row.CODFISCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16));
            /* mcRAPPORTO.DATANASCSOGG := personbo->DATANASC */
            mcRAPPORTO.row.DATANASCSOGG = Cursor_personbo.GetDate("DATANASC");
            /* If personbo->TIPINTER='EE' */
            if (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")) {
              /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASSTATO,30)) */
              mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASSTATO"),30));
            } else { // Else
              /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASCOMUN,30)) */
              mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASCOMUN"),30));
            } // End If
            /* mcRAPPORTO.DENOMSOGG := Upper(LibreriaMit.SpacePad(personbo->DOMICILIO,35)) */
            mcRAPPORTO.row.DENOMSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DOMICILIO"),35));
            /* mcRAPPORTO.COMUNRESSOGG := Upper(LibreriaMit.SpacePad(personbo->DESCCIT,40)) */
            mcRAPPORTO.row.COMUNRESSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),40));
            /* mcRAPPORTO.STATOSOGG := Upper(LibreriaMit.SpacePad(personbo->PAESE,3)) */
            mcRAPPORTO.row.STATOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("PAESE"),3));
            /* mcRAPPORTO.SAESOGG := Upper(LibreriaMit.SpacePad(personbo->SOTGRUP,3)) */
            mcRAPPORTO.row.SAESOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SOTGRUP"),3));
            /* mcRAPPORTO.ATECOSOGG := Upper(LibreriaMit.SpacePad(personbo->ATTIV,3)) */
            mcRAPPORTO.row.ATECOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("ATTIV"),3));
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* mcRAPPORTO.SaveRow() */
          mcRAPPORTO.SaveRow();
          Cursor_delegabo.Next();
        }
        m_cConnectivityError = Cursor_delegabo.ErrorMessage();
        Cursor_delegabo.Close();
        // * --- End Select
        /* mcFIDUCIABO.Zap() */
        mcFIDUCIABO.Zap();
        // * --- Fill memory cursor mcFIDUCIABO on fiduciabo
        mcFIDUCIABO.Zap();
        m_cServer = m_Ctx.GetServer("fiduciabo");
        m_cPhName = m_Ctx.GetPhName("fiduciabo");
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
        Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwRAP.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rwRAP.RAPPORTO)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_fiduciabo;
          Cursor_fiduciabo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_estrai_all1: query on fiduciabo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_fiduciabo.Eof())) {
          mcFIDUCIABO.AppendBlank();
          mcFIDUCIABO.row.IDFILEBO = Cursor_fiduciabo.GetString("IDFILEBO");
          mcFIDUCIABO.row.CODSOG = Cursor_fiduciabo.GetString("CODSOG");
          mcFIDUCIABO.row.TIPOFILE = Cursor_fiduciabo.GetString("TIPOFILE");
          mcFIDUCIABO.row.NUMCOL = Cursor_fiduciabo.GetString("NUMCOL");
          mcFIDUCIABO.row.LEGAME = Cursor_fiduciabo.GetString("LEGAME");
          mcFIDUCIABO.row.RAPCOL = Cursor_fiduciabo.GetString("RAPCOL");
          mcFIDUCIABO.row.UCODE = Cursor_fiduciabo.GetString("UCODE");
          mcFIDUCIABO.row.IDBASE = Cursor_fiduciabo.GetString("IDBASE");
          mcFIDUCIABO.row.NUMIMP = Cursor_fiduciabo.GetDateTime("NUMIMP");
          Cursor_fiduciabo.Next();
        }
        m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
        Cursor_fiduciabo.Close();
        mcFIDUCIABO.GoTop();
        /* If not(Empty(mcFIDUCIABO.RecCount())) */
        if ( ! (CPLib.Empty(mcFIDUCIABO.RecCount()))) {
          for (MemoryCursorRow_fiduciabo rwFIDUCIA : mcFIDUCIABO._iterable_()) {
            /* mcRAPPORTO.AppendRow(rwRAP) // inserisco la ROW prepopolata (la testata) */
            mcRAPPORTO.AppendRow(rwRAP);
            /* mcRAPPORTO.TIPOSOGG := '05' // Altro */
            mcRAPPORTO.row.TIPOSOGG = "05";
            /* mcRAPPORTO.DATAINISOGG := rwRAP.DATAPERT */
            mcRAPPORTO.row.DATAINISOGG = rwRAP.DATAPERT;
            /* mcRAPPORTO.DATAFINSOGG := rwRAP.DATACHIU */
            mcRAPPORTO.row.DATAFINSOGG = rwRAP.DATACHIU;
            /* mcRAPPORTO.NDGSOGG := Upper(LibreriaMit.SpacePad(rwFIDUCIA.CODSOG,16)) */
            mcRAPPORTO.row.NDGSOGG = CPLib.Upper(LibreriaMit.SpacePad(rwFIDUCIA.CODSOG,16));
            // * --- Select from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            if (Cursor_personbo!=null)
              Cursor_personbo.Close();
            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFIDUCIA.CODSOG,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFIDUCIA.CODSOG)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo.Eof())) {
              /* mcRAPPORTO.RAGSOG := Upper(LibreriaMit.SpacePad(personbo->RAGSOC,70)) */
              mcRAPPORTO.row.RAGSOG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70));
              /* mcRAPPORTO.SESSOSOGG := Upper(LibreriaMit.SpacePad(personbo->SESSO,1)) */
              mcRAPPORTO.row.SESSOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SESSO"),1));
              /* mcRAPPORTO.CODFISCSOGG := Upper(LibreriaMit.SpacePad(personbo->CODFISC,16)) */
              mcRAPPORTO.row.CODFISCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16));
              /* mcRAPPORTO.DATANASCSOGG := personbo->DATANASC */
              mcRAPPORTO.row.DATANASCSOGG = Cursor_personbo.GetDate("DATANASC");
              /* If personbo->TIPINTER='EE' */
              if (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")) {
                /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASSTATO,30)) */
                mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASSTATO"),30));
              } else { // Else
                /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASCOMUN,30)) */
                mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASCOMUN"),30));
              } // End If
              /* mcRAPPORTO.DENOMSOGG := Upper(LibreriaMit.SpacePad(personbo->DOMICILIO,35)) */
              mcRAPPORTO.row.DENOMSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DOMICILIO"),35));
              /* mcRAPPORTO.COMUNRESSOGG := Upper(LibreriaMit.SpacePad(personbo->DESCCIT,40)) */
              mcRAPPORTO.row.COMUNRESSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),40));
              /* mcRAPPORTO.STATOSOGG := Upper(LibreriaMit.SpacePad(personbo->PAESE,3)) */
              mcRAPPORTO.row.STATOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("PAESE"),3));
              /* mcRAPPORTO.SAESOGG := Upper(LibreriaMit.SpacePad(personbo->SOTGRUP,3)) */
              mcRAPPORTO.row.SAESOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SOTGRUP"),3));
              /* mcRAPPORTO.ATECOSOGG := Upper(LibreriaMit.SpacePad(personbo->ATTIV,3)) */
              mcRAPPORTO.row.ATECOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("ATTIV"),3));
              Cursor_personbo.Next();
            }
            m_cConnectivityError = Cursor_personbo.ErrorMessage();
            Cursor_personbo.Close();
            // * --- End Select
            /* mcRAPPORTO.SaveRow() */
            mcRAPPORTO.SaveRow();
            /* mcINTESTIT.Zap() */
            mcINTESTIT.Zap();
            // * --- Fill memory cursor mcINTESTIT on intestit
            mcINTESTIT.Zap();
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFIDUCIA.CODSOG,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFIDUCIA.CODSOG)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            {
              final CPResultSet m_TheCursor = Cursor_intestit;
              Cursor_intestit.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arfn_estrai_all1: query on intestit returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_intestit.Eof())) {
              mcINTESTIT.AppendBlank();
              mcINTESTIT.row.CODCLI = Cursor_intestit.GetString("CODCLI");
              mcINTESTIT.row.RAPPORTO = Cursor_intestit.GetString("RAPPORTO");
              mcINTESTIT.row.CODINTER = Cursor_intestit.GetString("CODINTER");
              mcINTESTIT.row.DESCINTER = Cursor_intestit.GetString("DESCINTER");
              mcINTESTIT.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
              mcINTESTIT.row.TIPORAP = Cursor_intestit.GetString("TIPORAP");
              mcINTESTIT.row.TIPOPERS = Cursor_intestit.GetString("TIPOPERS");
              mcINTESTIT.row.STATOREG = Cursor_intestit.GetString("STATOREG");
              mcINTESTIT.row.OPERAZMOD = Cursor_intestit.GetString("OPERAZMOD");
              mcINTESTIT.row.DATARETT = Cursor_intestit.GetDate("DATARETT");
              mcINTESTIT.row.IDEREG = Cursor_intestit.GetString("IDEREG");
              mcINTESTIT.row.COLLEGAMEN = Cursor_intestit.GetString("COLLEGAMEN");
              mcINTESTIT.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
              mcINTESTIT.row.NUMPROG1 = Cursor_intestit.GetString("NUMPROG1");
              mcINTESTIT.row.NUMPROG2 = Cursor_intestit.GetString("NUMPROG2");
              mcINTESTIT.row.IDBASE = Cursor_intestit.GetString("IDBASE");
              mcINTESTIT.row.UCODE = Cursor_intestit.GetString("UCODE");
              mcINTESTIT.row.ABBINATO = Cursor_intestit.GetDouble("ABBINATO");
              mcINTESTIT.row.PRGIMPTITE = Cursor_intestit.GetDouble("PRGIMPTITE");
              mcINTESTIT.row.NUMIMP = Cursor_intestit.GetDateTime("NUMIMP");
              mcINTESTIT.row.NOAGE = Cursor_intestit.GetString("NOAGE");
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            mcINTESTIT.GoTop();
            /* If mcINTESTIT.RecCount() > 0 */
            if (CPLib.gt(mcINTESTIT.RecCount(),0)) {
              for (MemoryCursorRow_intestit rwINT : mcINTESTIT._iterable_()) {
                /* mcRAPPORTO.AppendRow(rwRAP) // inserisco la ROW prepopolata (la testata) */
                mcRAPPORTO.AppendRow(rwRAP);
                /* mcRAPPORTO.TIPOSOGG := '03' // Titolare Effettivo */
                mcRAPPORTO.row.TIPOSOGG = "03";
                /* mcRAPPORTO.DATAINISOGG := rwINT.DATAINI */
                mcRAPPORTO.row.DATAINISOGG = rwINT.DATAINI;
                /* mcRAPPORTO.DATAFINSOGG := rwINT.DATAFINE */
                mcRAPPORTO.row.DATAFINSOGG = rwINT.DATAFINE;
                /* mcRAPPORTO.NDGSOGG := Upper(LibreriaMit.SpacePad(rwINT.CODINTER,16)) */
                mcRAPPORTO.row.NDGSOGG = CPLib.Upper(LibreriaMit.SpacePad(rwINT.CODINTER,16));
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwINT.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rwINT.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* mcRAPPORTO.RAGSOG := Upper(LibreriaMit.SpacePad(personbo->RAGSOC,70)) */
                  mcRAPPORTO.row.RAGSOG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("RAGSOC"),70));
                  /* mcRAPPORTO.SESSOSOGG := Upper(LibreriaMit.SpacePad(personbo->SESSO,1)) */
                  mcRAPPORTO.row.SESSOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SESSO"),1));
                  /* mcRAPPORTO.CODFISCSOGG := Upper(LibreriaMit.SpacePad(personbo->CODFISC,16)) */
                  mcRAPPORTO.row.CODFISCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("CODFISC"),16));
                  /* mcRAPPORTO.DATANASCSOGG := personbo->DATANASC */
                  mcRAPPORTO.row.DATANASCSOGG = Cursor_personbo.GetDate("DATANASC");
                  /* If personbo->TIPINTER='EE' */
                  if (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")) {
                    /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASSTATO,30)) */
                    mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASSTATO"),30));
                  } else { // Else
                    /* mcRAPPORTO.COMUNASCSOGG := Upper(LibreriaMit.SpacePad(personbo->NASCOMUN,30)) */
                    mcRAPPORTO.row.COMUNASCSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("NASCOMUN"),30));
                  } // End If
                  /* mcRAPPORTO.DENOMSOGG := Upper(LibreriaMit.SpacePad(personbo->DOMICILIO,35)) */
                  mcRAPPORTO.row.DENOMSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DOMICILIO"),35));
                  /* mcRAPPORTO.COMUNRESSOGG := Upper(LibreriaMit.SpacePad(personbo->DESCCIT,40)) */
                  mcRAPPORTO.row.COMUNRESSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("DESCCIT"),40));
                  /* mcRAPPORTO.STATOSOGG := Upper(LibreriaMit.SpacePad(personbo->PAESE,3)) */
                  mcRAPPORTO.row.STATOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("PAESE"),3));
                  /* mcRAPPORTO.SAESOGG := Upper(LibreriaMit.SpacePad(personbo->SOTGRUP,3)) */
                  mcRAPPORTO.row.SAESOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("SOTGRUP"),3));
                  /* mcRAPPORTO.ATECOSOGG := Upper(LibreriaMit.SpacePad(personbo->ATTIV,3)) */
                  mcRAPPORTO.row.ATECOSOGG = CPLib.Upper(LibreriaMit.SpacePad(Cursor_personbo.GetString("ATTIV"),3));
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
                /* mcRAPPORTO.SaveRow() */
                mcRAPPORTO.SaveRow();
              }
            } // End If
          }
        } // End If
        /* mcANARAP.Next() */
        mcANARAP.Next();
      } // End While
      /* gMsgImp := 'Fine elaborazione dei rapporti' // Messaggio Import */
      gMsgImp = "Fine elaborazione dei rapporti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_anarapbo_all1!=null)
          Cursor_qbe_anarapbo_all1.Close();
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
        if (Cursor_qbe_rapporti_all1_agg1!=null)
          Cursor_qbe_rapporti_all1_agg1.Close();
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
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
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
    }
  }
  boolean Check_Sogg(String pCodCli,String pRapporto) throws Exception {
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_fiduciabo=null;
    CPResultSet Cursor_soginfo=null;
    try {
      /* pCodCli Char(15) // Codice Cliente */
      /* pRapporto Char(25) // Codice Cliente */
      /* bRitorno Bool */
      boolean bRitorno;
      bRitorno = false;
      /* _trovato Char(1) */
      String _trovato;
      _trovato = CPLib.Space(1);
      /* bRitorno := False */
      bRitorno = false;
      /* _trovato := 'N' */
      _trovato = "N";
      // * --- Select from rapopebo
      m_cServer = m_Ctx.GetServer("rapopebo");
      m_cPhName = m_Ctx.GetPhName("rapopebo");
      if (Cursor_rapopebo!=null)
        Cursor_rapopebo.Close();
      Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CONNESOPER,CONNESBEN  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(_rapporto_check,"?",0,0,m_cServer, m_oParameters),m_cServer,_rapporto_check)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_rapopebo.Eof())) {
        /* If rapopebo->CONNESBEN = pCodCli */
        if (CPLib.eqr(Cursor_rapopebo.GetString("CONNESBEN"),pCodCli)) {
          /* bRitorno := True */
          bRitorno = true;
          /* _trovato := 'S' */
          _trovato = "S";
        } // End If
        /* If rapopebo->CONNESOPER = pCodCli and _trovato='N' */
        if (CPLib.eqr(Cursor_rapopebo.GetString("CONNESOPER"),pCodCli) && CPLib.eqr(_trovato,"N")) {
          /* bRitorno := True */
          bRitorno = true;
          /* _trovato := 'S' */
          _trovato = "S";
        } // End If
        Cursor_rapopebo.Next();
      }
      m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
      Cursor_rapopebo.Close();
      // * --- End Select
      /* If _trovato='N' */
      if (CPLib.eqr(_trovato,"N")) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+"  and  CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodCli)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* bRitorno := True */
          bRitorno = true;
          /* _trovato := 'S' */
          _trovato = "S";
          /* If _trovato='N' */
          if (CPLib.eqr(_trovato,"N")) {
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+"  and  CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodCli)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* bRitorno := True */
              bRitorno = true;
              /* _trovato := 'S' */
              _trovato = "S";
              // Exit Loop
              if (true) {
                break;
              }
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } // End If
          /* If _trovato='S' */
          if (CPLib.eqr(_trovato,"S")) {
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
      } // End If
      /* If _trovato='N' */
      if (CPLib.eqr(_trovato,"N")) {
        // * --- Select from delegabo
        m_cServer = m_Ctx.GetServer("delegabo");
        m_cPhName = m_Ctx.GetPhName("delegabo");
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
        Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+"  and  CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodCli)+" "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_delegabo.Eof())) {
          /* bRitorno := True */
          bRitorno = true;
          /* _trovato := 'S' */
          _trovato = "S";
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_delegabo.Next();
        }
        m_cConnectivityError = Cursor_delegabo.ErrorMessage();
        Cursor_delegabo.Close();
        // * --- End Select
      } // End If
      /* If _trovato='N' */
      if (CPLib.eqr(_trovato,"N")) {
        // * --- Select from fiduciabo
        m_cServer = m_Ctx.GetServer("fiduciabo");
        m_cPhName = m_Ctx.GetPhName("fiduciabo");
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
        Cursor_fiduciabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+"  and  CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodCli)+" "+")"+(m_Ctx.IsSharedTemp("fiduciabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_fiduciabo.Eof())) {
          /* bRitorno := True */
          bRitorno = true;
          /* _trovato := 'S' */
          _trovato = "S";
          /* If _trovato='N' */
          if (CPLib.eqr(_trovato,"N")) {
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_fiduciabo.GetString("CODSOG"),"?",0,0)+"  and  CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodCli)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* bRitorno := True */
              bRitorno = true;
              /* _trovato := 'S' */
              _trovato = "S";
              // Exit Loop
              if (true) {
                break;
              }
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
          } // End If
          /* If _trovato='S' */
          if (CPLib.eqr(_trovato,"S")) {
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
          Cursor_fiduciabo.Next();
        }
        m_cConnectivityError = Cursor_fiduciabo.ErrorMessage();
        Cursor_fiduciabo.Close();
        // * --- End Select
      } // End If
      /* If _trovato='N' */
      if (CPLib.eqr(_trovato,"N")) {
        // * --- Select from soginfo
        m_cServer = m_Ctx.GetServer("soginfo");
        m_cPhName = m_Ctx.GetPhName("soginfo");
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
        Cursor_soginfo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+"  and  CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL(pCodCli,"?",0,0,m_cServer, m_oParameters),m_cServer,pCodCli)+" "+")"+(m_Ctx.IsSharedTemp("soginfo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_soginfo.Eof())) {
          /* bRitorno := True */
          bRitorno = true;
          /* _trovato := 'S' */
          _trovato = "S";
          // Exit Loop
          if (true) {
            break;
          }
          Cursor_soginfo.Next();
        }
        m_cConnectivityError = Cursor_soginfo.ErrorMessage();
        Cursor_soginfo.Close();
        // * --- End Select
      } // End If
      /* Page Return bRitorno */
      return bRitorno;
    } finally {
      try {
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
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
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
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
      try {
        if (Cursor_fiduciabo!=null)
          Cursor_fiduciabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_soginfo!=null)
          Cursor_soginfo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void file_Ope_Frz() throws Exception {
    /* -- generazione del file per Operazioni/Frazionate */
    /* _dataOpe Char(8) */
    /* _dataNascita Char(8) */
    /* _dataNascitaEse Char(8) */
    /* _nomefile := "Operazioni_"+_data_ora */
    _nomefile = "Operazioni_"+_data_ora;
    /* cNomeFile := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+'/'+LRTrim(_nomefile) */
    cNomeFile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile);
    /* If w_tipout='E' */
    if (CPLib.eqr(w_tipout,"E")) {
      /* cNomeFile := cNomeFile+".xlsx" */
      cNomeFile = cNomeFile+".xlsx";
      filename_path.add(cNomeFile);
      filename.add(_nomefile+".xlsx");
      // creo il contenitore dei fogli
      SXSSFWorkbook wb = new SXSSFWorkbook(100);
      SXSSFSheet sheet = wb.createSheet("Operazioni") ;
      
      //sheet.trackAllColumnsForAutoSizing();
      //Creo il record da scrivere
      row = sheet.createRow(0);
      
      //DATI GENERALI
      cell = row.createCell(0); cell.setCellValue("TIPO_INTERMEDIARIO");
      cell = row.createCell(1); cell.setCellValue("CODICE_INTERMEDIARIO");
      cell = row.createCell(2); cell.setCellValue("IDENTIFICATIVO_OPERAZIONE");
      //FILIALE-PUNTO OPERATIVO
      cell = row.createCell(3); cell.setCellValue("CODICE_FILIALE");
      cell = row.createCell(4); cell.setCellValue("CAB_FILIALE");
      cell = row.createCell(5); cell.setCellValue("CAB_COMUNE_FILIALE");
      cell = row.createCell(6); cell.setCellValue("COMUNE_FILIALE");
      cell = row.createCell(7); cell.setCellValue("PROVINCIA_FILIALE");
      //OPERAZIONE
      cell = row.createCell(8); cell.setCellValue("DATA_OPERAZIONE");
      cell = row.createCell(9); cell.setCellValue("CAUSALE_ANALITICA");
      cell = row.createCell(10); cell.setCellValue("SEGNO");
      cell = row.createCell(11); cell.setCellValue("CODICE_VALUTA");
      cell = row.createCell(12); cell.setCellValue("IMPORTO_EURO");
      cell = row.createCell(13); cell.setCellValue("IMPORTO_CONTANTI");
      cell = row.createCell(14); cell.setCellValue("IDENTIFICATIVO_RAPPORTO");
      //SOGGETTO
      cell = row.createCell(15); cell.setCellValue("CODICE_TIPO_SOGGETTO");
      cell = row.createCell(16); cell.setCellValue("NDG_SOGGETTO");
      cell = row.createCell(17); cell.setCellValue("RAGIONE_SOCIALE");
      cell = row.createCell(18); cell.setCellValue("SESSO");
      cell = row.createCell(19); cell.setCellValue("CODICE_FISCALE");
      cell = row.createCell(20); cell.setCellValue("DATA_NASCITA");
      cell = row.createCell(21); cell.setCellValue("COMUNE_PAESE_NASCITA");
      cell = row.createCell(22); cell.setCellValue("COMUNE_RESIDENZA");
      cell = row.createCell(23); cell.setCellValue("CAB_RESIDENZA");
      cell = row.createCell(24); cell.setCellValue("PAESE_RESIDENZA");
      cell = row.createCell(25); cell.setCellValue("SAE");
      cell = row.createCell(26); cell.setCellValue("ATECO");
      //ESECUTORE
      cell = row.createCell(27); cell.setCellValue("NDG_ESECUTORE");
      cell = row.createCell(28); cell.setCellValue("COGNOME_NOME");
      cell = row.createCell(29); cell.setCellValue("CODICE_FISCALE_ESECUTORE");
      cell = row.createCell(30); cell.setCellValue("DATA_NASCITA_ESECUTORE");
      cell = row.createCell(31); cell.setCellValue("COMUNE_NASCITA");
      //CONTROPARTE
      cell = row.createCell(32); cell.setCellValue("RAGIONE_SOCIALE");
      cell = row.createCell(33); cell.setCellValue("PAESE_ORDINANTE");
      cell = row.createCell(34); cell.setCellValue("CAB_ORDINANTE");
      cell = row.createCell(35); cell.setCellValue("COMUNE_ORDINANTE");
      cell = row.createCell(36); cell.setCellValue("CODICE_INTERMEDIARIO");
      cell = row.createCell(37); cell.setCellValue("DENOMIAZIONE_INTERMEDIARIO");
      cell = row.createCell(38); cell.setCellValue("PAESE_INTEMDIARIO");
      cell = row.createCell(39); cell.setCellValue("CAB_INTERMEDIARIO");
      cell = row.createCell(40); cell.setCellValue("IBAN_RAPPORTO");
      sheet.setColumnWidth(0, (19+3)*256 );
      sheet.setColumnWidth(1, (21+3)*256 );
      sheet.setColumnWidth(2, (26+3)*256 );
      sheet.setColumnWidth(3, (15+3)*256 );
      sheet.setColumnWidth(4, (12+3)*256 );
      sheet.setColumnWidth(5, (19+3)*256 );
      sheet.setColumnWidth(6, (15+3)*256 );
      sheet.setColumnWidth(7, (18+3)*256 );
      sheet.setColumnWidth(8, (16+3)*256 );
      sheet.setColumnWidth(9, (18+3)*256 );
      sheet.setColumnWidth(10, (6+3)*256 );
      sheet.setColumnWidth(11, (14+3)*256 );
      sheet.setColumnWidth(12, (13+3)*256 );
      sheet.setColumnWidth(13, (17+3)*256 );
      sheet.setColumnWidth(14, (24+3)*256 );
      sheet.setColumnWidth(15, (21+3)*256 );
      sheet.setColumnWidth(16, (13+3)*256 );
      sheet.setColumnWidth(17, (16+3)*256 );
      sheet.setColumnWidth(18, (6+3)*256 );
      sheet.setColumnWidth(19, (15+3)*256 );
      sheet.setColumnWidth(20, (13+3)*256 );
      sheet.setColumnWidth(21, (21+3)*256 );
      sheet.setColumnWidth(22, (17+3)*256 );
      sheet.setColumnWidth(23, (14+3)*256 );
      sheet.setColumnWidth(24, (16+3)*256 );
      sheet.setColumnWidth(25, (4+3)*256 );
      sheet.setColumnWidth(26, (6+3)*256 );
      sheet.setColumnWidth(27, (14+3)*256 );
      sheet.setColumnWidth(28, (13+3)*256 );
      sheet.setColumnWidth(29, (25+3)*256 );
      sheet.setColumnWidth(30, (13+3)*256 );
      sheet.setColumnWidth(31, (15+3)*256 );
      sheet.setColumnWidth(32, (16+3)*256 );
      sheet.setColumnWidth(33, (16+3)*256 );
      sheet.setColumnWidth(34, (14+3)*256 );
      sheet.setColumnWidth(35, (17+3)*256 );
      sheet.setColumnWidth(36, (21+3)*256 );
      sheet.setColumnWidth(37, (27+3)*256 );
      sheet.setColumnWidth(38, (18+3)*256 );
      sheet.setColumnWidth(39, (18+3)*256 );
      sheet.setColumnWidth(40, (14+3)*256 );
      /* _cnt := 1 */
      _cnt = 1;
      for (MemoryCursorRow_mcoperazioniall1_mcrdef riga : mcOPERAZIONI._iterable_()) {
        /* _dataOpe := iif(Empty(riga.DATAOPE) or DateToChar(riga.DATAOPE)='01000101',Space(8),DateToChar(riga.DATAOPE)) */
        _dataOpe = (CPLib.Empty(riga.DATAOPE) || CPLib.eqr(CPLib.DateToChar(riga.DATAOPE),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATAOPE));
        /* _dataNascita := iif(Empty(riga.DATANASCSOGG) or DateToChar(riga.DATANASCSOGG)='01000101',Space(8),DateToChar(riga.DATANASCSOGG)) */
        _dataNascita = (CPLib.Empty(riga.DATANASCSOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATANASCSOGG),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATANASCSOGG));
        /* _dataNascitaEse := iif(Empty(riga.DATANASCESE) or DateToChar(riga.DATANASCESE)='01000101',Space(8),DateToChar(riga.DATANASCESE)) */
        _dataNascitaEse = (CPLib.Empty(riga.DATANASCESE) || CPLib.eqr(CPLib.DateToChar(riga.DATANASCESE),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATANASCESE));
        row = sheet.createRow(_cnt);
        
        //DATI GENERALI
        cell = row.createCell(0); cell.setCellValue(riga.TIPOINTER);
        cell = row.createCell(1); cell.setCellValue(riga.CODINTER);
        cell = row.createCell(2); cell.setCellValue(riga.IDEREG);
        //FILIALE-PUNTO OPERATIVO
        cell = row.createCell(3); cell.setCellValue(riga.CODDIPE);
        cell = row.createCell(4); cell.setCellValue(riga.CABFIL);
        cell = row.createCell(5); cell.setCellValue(riga.CABCOMU);
        cell = row.createCell(6); cell.setCellValue(riga.DESCCIT);
        cell = row.createCell(7); cell.setCellValue(riga.PROVINCIA);
        //OPERAZIONE
        cell = row.createCell(8); cell.setCellValue(_dataOpe);
        cell = row.createCell(9); cell.setCellValue(riga.CODANA);
        cell = row.createCell(10); cell.setCellValue(riga.SEGNO);
        cell = row.createCell(11); cell.setCellValue(riga.VALUTA);
        cell = row.createCell(12); cell.setCellValue(CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(riga.TOTLIRE,15,0)),15));
        cell = row.createCell(13); cell.setCellValue(CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(riga.TOTCONT,15,0)),15));
        cell = row.createCell(14); cell.setCellValue(riga.RAPPORTO);
        //SOGGETTO
        cell = row.createCell(15); cell.setCellValue(riga.CODTIPSOGG);
        cell = row.createCell(16); cell.setCellValue(riga.CONNESSOGG);
        cell = row.createCell(17); cell.setCellValue(riga.RAGSOGSOGG);
        cell = row.createCell(18); cell.setCellValue(riga.SESSOSOGG);
        cell = row.createCell(19); cell.setCellValue(riga.CODFISCSOGG);
        cell = row.createCell(20); cell.setCellValue(_dataNascita);
        cell = row.createCell(21); cell.setCellValue(riga.NASCOMUNSOGG);
        cell = row.createCell(22); cell.setCellValue(riga.COMUNRESSOGG);
        cell = row.createCell(23); cell.setCellValue(riga.CABRESISOGG);
        cell = row.createCell(24); cell.setCellValue(riga.PAESESOGG);
        cell = row.createCell(25); cell.setCellValue(riga.SAESOGG);
        cell = row.createCell(26); cell.setCellValue(riga.ATECOSOGG);
        //ESECUTORE
        cell = row.createCell(27); cell.setCellValue(riga.CONNESESE);
        cell = row.createCell(28); cell.setCellValue(riga.RAGSOGESE);
        cell = row.createCell(29); cell.setCellValue(riga.CODFISCESE);
        cell = row.createCell(30); cell.setCellValue(_dataNascitaEse);
        cell = row.createCell(31); cell.setCellValue(riga.NASCCOMUNESE);
        //CONTROPARTE
        cell = row.createCell(32); cell.setCellValue(riga.C_RAG);
        cell = row.createCell(33); cell.setCellValue(riga.C_STA);
        cell = row.createCell(34); cell.setCellValue(riga.C_CAB);
        cell = row.createCell(35); cell.setCellValue(riga.C_CTA);
        cell = row.createCell(36); cell.setCellValue(riga.CODINT2);
        cell = row.createCell(37); cell.setCellValue(riga.DESCINTER);
        cell = row.createCell(38); cell.setCellValue(riga.PAESE);
        cell = row.createCell(39); cell.setCellValue(riga.CODCAB2);
        cell = row.createCell(40); cell.setCellValue(riga.C_RAPPORTO);
        /* _cnt := _cnt+1 */
        _cnt = _cnt+1;
      }
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(cNomeFile);
      
      //write this workbook to an Outputstream.
      wb.write(fileOut);
      //fileOut.flush();
      fileOut.close();
      wb.dispose();
      /* ElseIf w_tipout='T' */
    } else if (CPLib.eqr(w_tipout,"T")) {
      /* _testo := '' */
      _testo = "";
      /* cNomeFile := cNomeFile+".txt" */
      cNomeFile = cNomeFile+".txt";
      filename_path.add(cNomeFile);
      filename.add(_nomefile+".txt");
      /* fhand := FileLibMit.OpenWritePath(cNomeFile) */
      fhand = FileLibMit.OpenWritePath(cNomeFile);
      for (MemoryCursorRow_mcoperazioniall1_mcrdef riga : mcOPERAZIONI._iterable_()) {
        /* _testo := riga.TIPOINTER+
           riga.CODINTER+
           riga.IDEREG+
           riga.CODDIPE+
           riga.CABFIL+
           riga.CABCOMU+
           riga.DESCCIT+
           riga.PROVINCIA+ 
           iif(Empty(riga.DATAOPE) or DateToChar(riga.DATAOPE)='01000101',Space(8),DateToChar(riga.DATAOPE))+
           riga.CODANA+
           riga.SEGNO+
           riga.VALUTA+
           Right('000000000000000'+LRTrim(Str(riga.TOTLIRE,15,0)),15)+
           Right('000000000000000'+LRTrim(Str(riga.TOTCONT,15,0)),15)+
           riga.RAPPORTO+
           riga.CODTIPSOGG+
           riga.CONNESSOGG+
           riga.RAGSOGSOGG+
           riga.SESSOSOGG+
           riga.CODFISCSOGG+
           iif(Empty(riga.DATANASCSOGG) or DateToChar(riga.DATANASCSOGG)='01000101',Space(8),DateToChar(riga.DATANASCSOGG))+
           riga.NASCOMUNSOGG+
           riga.COMUNRESSOGG+
           riga.CABRESISOGG+
           riga.PAESESOGG+
           riga.SAESOGG+
           riga.ATECOSOGG+
           riga.CONNESESE+
           riga.RAGSOGESE+
           riga.CODFISCESE+
           iif(Empty(riga.DATANASCESE) or DateToChar(riga.DATANASCESE)='01000101',Space(8),DateToChar(riga.DATANASCESE))+
           riga.NASCCOMUNESE+
           riga.C_RAG+
           riga.C_STA+
           riga.C_CAB+
           riga.C_CTA+
           riga.CODINT2+
           riga.DESCINTER+
           riga.PAESE+
           riga.CODCAB2+
           riga.C_RAPPORTO+
           riga.FILLER+NL */
        _testo = riga.TIPOINTER+riga.CODINTER+riga.IDEREG+riga.CODDIPE+riga.CABFIL+riga.CABCOMU+riga.DESCCIT+riga.PROVINCIA+(CPLib.Empty(riga.DATAOPE) || CPLib.eqr(CPLib.DateToChar(riga.DATAOPE),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATAOPE))+riga.CODANA+riga.SEGNO+riga.VALUTA+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(riga.TOTLIRE,15,0)),15)+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(riga.TOTCONT,15,0)),15)+riga.RAPPORTO+riga.CODTIPSOGG+riga.CONNESSOGG+riga.RAGSOGSOGG+riga.SESSOSOGG+riga.CODFISCSOGG+(CPLib.Empty(riga.DATANASCSOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATANASCSOGG),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATANASCSOGG))+riga.NASCOMUNSOGG+riga.COMUNRESSOGG+riga.CABRESISOGG+riga.PAESESOGG+riga.SAESOGG+riga.ATECOSOGG+riga.CONNESESE+riga.RAGSOGESE+riga.CODFISCESE+(CPLib.Empty(riga.DATANASCESE) || CPLib.eqr(CPLib.DateToChar(riga.DATANASCESE),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATANASCESE))+riga.NASCCOMUNESE+riga.C_RAG+riga.C_STA+riga.C_CAB+riga.C_CTA+riga.CODINT2+riga.DESCINTER+riga.PAESE+riga.CODCAB2+riga.C_RAPPORTO+riga.FILLER+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
      }
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* ElseIf w_tipout='C' */
    } else if (CPLib.eqr(w_tipout,"C")) {
      /* _testo := '' */
      _testo = "";
      /* cNomeFile := cNomeFile+".csv" */
      cNomeFile = cNomeFile+".csv";
      filename_path.add(cNomeFile);
      filename.add(_nomefile+".csv");
      /* fhand := FileLibMit.OpenWritePath(cNomeFile) */
      fhand = FileLibMit.OpenWritePath(cNomeFile);
      /* _testo := 'TIPO_INTERMEDIARIO,CODICE_INTERMEDIARIO,IDENTIFICATIVO_OPERAZIONE,CODICE_FILIALE,CAB_FILIALE,CAB_COMUNE_FILIALE,COMUNE_FILIALE,PROVINCIA_FILIALE,DATA_OPERAZIONE,CAUSALE_ANALITICA,SEGNO,CODICE_VALUTA,IMPORTO_EURO,IMPORTO_CONTANTI,IDENTIFICATIVO_RAPPORTO,CODICE_TIPO_SOGGETTO,NDG_SOGGETTO,RAGIONE_SOCIALE,SESSO,CODICE_FISCALE,DATA_NASCITA,COMUNE_PAESE_NASCITA,COMUNE_RESIDENZA,CAB_RESIDENZA,PAESE_RESIDENZA,SAE,ATECO,NDG_ESECUTORE,COGNOME_NOME,CODICE_FISCALE_ESECUTORE,DATA_NASCITA_ESECUTORE,COMUNE_NASCITA,RAGIONE_SOCIALE,PAESE_ORDINANTE,CAB_ORDINANTE,COMUNE_ORDINANTE,CODICE_INTERMEDIARIO,DENOMIAZIONE_INTERMEDIARIO,PAESE_INTEMDIARIO,CAB_INTERMEDIARIO,IBAN_RAPPORTO'+NL */
      _testo = "TIPO_INTERMEDIARIO,CODICE_INTERMEDIARIO,IDENTIFICATIVO_OPERAZIONE,CODICE_FILIALE,CAB_FILIALE,CAB_COMUNE_FILIALE,COMUNE_FILIALE,PROVINCIA_FILIALE,DATA_OPERAZIONE,CAUSALE_ANALITICA,SEGNO,CODICE_VALUTA,IMPORTO_EURO,IMPORTO_CONTANTI,IDENTIFICATIVO_RAPPORTO,CODICE_TIPO_SOGGETTO,NDG_SOGGETTO,RAGIONE_SOCIALE,SESSO,CODICE_FISCALE,DATA_NASCITA,COMUNE_PAESE_NASCITA,COMUNE_RESIDENZA,CAB_RESIDENZA,PAESE_RESIDENZA,SAE,ATECO,NDG_ESECUTORE,COGNOME_NOME,CODICE_FISCALE_ESECUTORE,DATA_NASCITA_ESECUTORE,COMUNE_NASCITA,RAGIONE_SOCIALE,PAESE_ORDINANTE,CAB_ORDINANTE,COMUNE_ORDINANTE,CODICE_INTERMEDIARIO,DENOMIAZIONE_INTERMEDIARIO,PAESE_INTEMDIARIO,CAB_INTERMEDIARIO,IBAN_RAPPORTO"+"\n";
      for (MemoryCursorRow_mcoperazioniall1_mcrdef riga : mcOPERAZIONI._iterable_()) {
        /* _testo := LRTrim(riga.TIPOINTER)+','+
           LRTrim(riga.CODINTER)+','+
           LRTrim(riga.IDEREG)+','+
           LRTrim(riga.CODDIPE)+','+
           LRTrim(riga.CABFIL)+','+
           LRTrim(riga.CABCOMU)+','+
           LRTrim(riga.DESCCIT)+','+
           LRTrim(riga.PROVINCIA)+','+
           iif(Empty(riga.DATAOPE) or DateToChar(riga.DATAOPE)='01000101','',DateToChar(riga.DATAOPE))+','+
           LRTrim(riga.CODANA)+','+
           LRTrim(riga.SEGNO)+','+
           LRTrim(riga.VALUTA)+','+
           Right('000000000000000'+LRTrim(Str(riga.TOTLIRE,15,0)),15)+','+
           Right('000000000000000'+LRTrim(Str(riga.TOTCONT,15,0)),15)+','+
           LRTrim(riga.RAPPORTO)+','+
           LRTrim(riga.CODTIPSOGG)+','+
           LRTrim(riga.CONNESSOGG)+','+
           LRTrim(riga.RAGSOGSOGG)+','+
           LRTrim(riga.SESSOSOGG)+','+
           LRTrim(riga.CODFISCSOGG)+','+
           iif(Empty(riga.DATANASCSOGG) or DateToChar(riga.DATANASCSOGG)='01000101','',DateToChar(riga.DATANASCSOGG))+','+
           LRTrim(riga.NASCOMUNSOGG)+','+
           LRTrim(riga.COMUNRESSOGG)+','+
           LRTrim(riga.CABRESISOGG)+','+
           LRTrim(riga.PAESESOGG)+','+
           LRTrim(riga.SAESOGG)+','+
           LRTrim(riga.ATECOSOGG)+','+
           LRTrim(riga.CONNESESE)+','+
           LRTrim(riga.RAGSOGESE)+','+
           LRTrim(riga.CODFISCESE)+','+
           iif(Empty(riga.DATANASCESE) or DateToChar(riga.DATANASCESE)='01000101','',DateToChar(riga.DATANASCESE))+','+
           LRTrim(riga.NASCCOMUNESE)+','+
           LRTrim(riga.C_RAG)+','+
           LRTrim(riga.C_STA)+','+
           LRTrim(riga.C_CAB)+','+
           LRTrim(riga.C_CTA)+','+
           LRTrim(riga.CODINT2)+','+
           LRTrim(riga.DESCINTER)+','+
           LRTrim(riga.PAESE)+','+
           LRTrim(riga.CODCAB2)+','+
           LRTrim(riga.C_RAPPORTO)+NL */
        _testo = CPLib.LRTrim(riga.TIPOINTER)+","+CPLib.LRTrim(riga.CODINTER)+","+CPLib.LRTrim(riga.IDEREG)+","+CPLib.LRTrim(riga.CODDIPE)+","+CPLib.LRTrim(riga.CABFIL)+","+CPLib.LRTrim(riga.CABCOMU)+","+CPLib.LRTrim(riga.DESCCIT)+","+CPLib.LRTrim(riga.PROVINCIA)+","+(CPLib.Empty(riga.DATAOPE) || CPLib.eqr(CPLib.DateToChar(riga.DATAOPE),"01000101")?"":CPLib.DateToChar(riga.DATAOPE))+","+CPLib.LRTrim(riga.CODANA)+","+CPLib.LRTrim(riga.SEGNO)+","+CPLib.LRTrim(riga.VALUTA)+","+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(riga.TOTLIRE,15,0)),15)+","+CPLib.Right("000000000000000"+CPLib.LRTrim(CPLib.Str(riga.TOTCONT,15,0)),15)+","+CPLib.LRTrim(riga.RAPPORTO)+","+CPLib.LRTrim(riga.CODTIPSOGG)+","+CPLib.LRTrim(riga.CONNESSOGG)+","+CPLib.LRTrim(riga.RAGSOGSOGG)+","+CPLib.LRTrim(riga.SESSOSOGG)+","+CPLib.LRTrim(riga.CODFISCSOGG)+","+(CPLib.Empty(riga.DATANASCSOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATANASCSOGG),"01000101")?"":CPLib.DateToChar(riga.DATANASCSOGG))+","+CPLib.LRTrim(riga.NASCOMUNSOGG)+","+CPLib.LRTrim(riga.COMUNRESSOGG)+","+CPLib.LRTrim(riga.CABRESISOGG)+","+CPLib.LRTrim(riga.PAESESOGG)+","+CPLib.LRTrim(riga.SAESOGG)+","+CPLib.LRTrim(riga.ATECOSOGG)+","+CPLib.LRTrim(riga.CONNESESE)+","+CPLib.LRTrim(riga.RAGSOGESE)+","+CPLib.LRTrim(riga.CODFISCESE)+","+(CPLib.Empty(riga.DATANASCESE) || CPLib.eqr(CPLib.DateToChar(riga.DATANASCESE),"01000101")?"":CPLib.DateToChar(riga.DATANASCESE))+","+CPLib.LRTrim(riga.NASCCOMUNESE)+","+CPLib.LRTrim(riga.C_RAG)+","+CPLib.LRTrim(riga.C_STA)+","+CPLib.LRTrim(riga.C_CAB)+","+CPLib.LRTrim(riga.C_CTA)+","+CPLib.LRTrim(riga.CODINT2)+","+CPLib.LRTrim(riga.DESCINTER)+","+CPLib.LRTrim(riga.PAESE)+","+CPLib.LRTrim(riga.CODCAB2)+","+CPLib.LRTrim(riga.C_RAPPORTO)+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
      }
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
    } // End If
  }
  void file_Rapporti() throws Exception {
    /* -- generazione del file per i Rapporti */
    /* _dataApert Char(8) */
    /* _dataChiu Char(8) */
    /* _dataIniSogg Char(8) */
    /* _dataFinSogg Char(8) */
    /* _dataNascSogg Char(8) */
    /* gMsgImp := 'Caricamento dati per la stampa dei Rapporti' // Messaggio Import */
    gMsgImp = "Caricamento dati per la stampa dei Rapporti";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* _nomefile := "Rapporti_"+_data_ora */
    _nomefile = "Rapporti_"+_data_ora;
    /* cNomeFile := LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+'/'+LRTrim(_nomefile) */
    cNomeFile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile);
    /* If w_tipout='E' */
    if (CPLib.eqr(w_tipout,"E")) {
      /* cNomeFile := cNomeFile+".xlsx" */
      cNomeFile = cNomeFile+".xlsx";
      filename_path.add(cNomeFile);
      filename.add(_nomefile+".xlsx");
      // creo il contenitore dei fogli
      SXSSFWorkbook wb = new SXSSFWorkbook(100);
      SXSSFSheet sheet = wb.createSheet("Rapporti") ;
      //Creo il record da scrivere
      row = sheet.createRow(0);
      
      //DATI GENERALI
      cell = row.createCell(0); cell.setCellValue("TIPO_INTERMEDIARIO"); 
      cell = row.createCell(1); cell.setCellValue("CODICE_INTERMEDIARIO");
      cell = row.createCell(2); cell.setCellValue("IDENTIFICATIVO_RAPPORTO");
      //RAPPORTO
      cell = row.createCell(3); cell.setCellValue("CODICE_FILIALE");
      cell = row.createCell(4); cell.setCellValue("CAB_FILIALE");
      cell = row.createCell(5); cell.setCellValue("DATA_APERTURA");
      cell = row.createCell(6); cell.setCellValue("DATA_CHIUSURA");
      cell = row.createCell(7); cell.setCellValue("TIPO_RAPPORTO");
      cell = row.createCell(8); cell.setCellValue("CODICE_VALUTA");
      cell = row.createCell(9); cell.setCellValue("NDG");
      //SOGGETTO
      cell = row.createCell(10); cell.setCellValue("DATA_INIZIO");
      cell = row.createCell(11); cell.setCellValue("DATA_FINE");
      cell = row.createCell(12); cell.setCellValue("TIPO_SOGGETTO");
      cell = row.createCell(13); cell.setCellValue("NDG_SOGGETTO");
      cell = row.createCell(14); cell.setCellValue("RAGIONE_SOCIALE");
      cell = row.createCell(15); cell.setCellValue("SESSO");
      cell = row.createCell(16); cell.setCellValue("CODICE_FILIALE");
      cell = row.createCell(17); cell.setCellValue("DATA_NASCITA");
      cell = row.createCell(18); cell.setCellValue("COMUNE_NASCITA");
      cell = row.createCell(19); cell.setCellValue("INDIRIZZO_RESIDENZA");
      cell = row.createCell(20); cell.setCellValue("COMUNE_RESIDENZA");
      cell = row.createCell(21); cell.setCellValue("PAESE_RESIDENZA");
      cell = row.createCell(22); cell.setCellValue("SAE");
      cell = row.createCell(23); cell.setCellValue("ATECO");
      sheet.setColumnWidth(0, (19+3)*256 );
      sheet.setColumnWidth(1, (21+3)*256);
      sheet.setColumnWidth(2, (24+3)*256);
      sheet.setColumnWidth(3, (15+3)*256);
      sheet.setColumnWidth(4, (12+3)*256);
      sheet.setColumnWidth(5, (15+3)*256);
      sheet.setColumnWidth(6, (15+3)*256);
      sheet.setColumnWidth(7, (15+3)*256);
      sheet.setColumnWidth(8, (15+3)*256);
      sheet.setColumnWidth(9, (5+3)*256);
      sheet.setColumnWidth(10, (12+3)*256);
      sheet.setColumnWidth(11, (10+3)*256);
      sheet.setColumnWidth(12, (14+3)*256);
      sheet.setColumnWidth(13, (13+3)*256);
      sheet.setColumnWidth(14, (16+3)*256);
      sheet.setColumnWidth(15, (6+3)*256);
      sheet.setColumnWidth(16, (15+3)*256);
      sheet.setColumnWidth(17, (13+3)*256);
      sheet.setColumnWidth(18,(15+3)*256);
      sheet.setColumnWidth(19, (20+3)*256);
      sheet.setColumnWidth(20, (17+3)*256);
      sheet.setColumnWidth(21, (16+3)*256);
      sheet.setColumnWidth(22, (4+3)*256);
      sheet.setColumnWidth(23, (6+3)*256);
      
      /* _cnt := 1 */
      _cnt = 1;
      for (MemoryCursorRow_mcrapportoall1_mcrdef riga : mcRAPPORTO._iterable_()) {
        /* _dataApert := iif(Empty(riga.DATAPERT) or DateToChar(riga.DATAPERT)='01000101',Space(8),DateToChar(riga.DATAPERT)) */
        _dataApert = (CPLib.Empty(riga.DATAPERT) || CPLib.eqr(CPLib.DateToChar(riga.DATAPERT),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATAPERT));
        /* _dataChiu := iif(Empty(riga.DATACHIU) or DateToChar(riga.DATACHIU)='01000101',Space(8),DateToChar(riga.DATACHIU)) */
        _dataChiu = (CPLib.Empty(riga.DATACHIU) || CPLib.eqr(CPLib.DateToChar(riga.DATACHIU),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATACHIU));
        /* _dataIniSogg := iif(Empty(riga.DATAINISOGG) or DateToChar(riga.DATAINISOGG)='01000101',Space(8),DateToChar(riga.DATAINISOGG)) */
        _dataIniSogg = (CPLib.Empty(riga.DATAINISOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATAINISOGG),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATAINISOGG));
        /* _dataFinSogg := iif(Empty(riga.DATAFINSOGG) or DateToChar(riga.DATAFINSOGG)='01000101',Space(8),DateToChar(riga.DATAFINSOGG)) */
        _dataFinSogg = (CPLib.Empty(riga.DATAFINSOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATAFINSOGG),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATAFINSOGG));
        /* _dataNascSogg := iif(Empty(riga.DATANASCSOGG) or DateToChar(riga.DATANASCSOGG)='01000101',Space(8),DateToChar(riga.DATANASCSOGG)) */
        _dataNascSogg = (CPLib.Empty(riga.DATANASCSOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATANASCSOGG),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATANASCSOGG));
        //Creo il record da scrivere
        row = sheet.createRow(_cnt);
        //DATI GENERALI
        cell = row.createCell(0); cell.setCellValue(riga.TIPOINTER);
        cell = row.createCell(1); cell.setCellValue(riga.CODINTER);
        cell = row.createCell(2); cell.setCellValue(riga.RAPPORTO);
        //RAPPORTO
        cell = row.createCell(3); cell.setCellValue(riga.CODFIL);
        cell = row.createCell(4); cell.setCellValue(riga.CABFIL);
        cell = row.createCell(5); cell.setCellValue(_dataApert);
        cell = row.createCell(6); cell.setCellValue(_dataChiu);
        cell = row.createCell(7); cell.setCellValue(riga.TIPORAPP);
        cell = row.createCell(8); cell.setCellValue(riga.VALUTA);
        cell = row.createCell(9); cell.setCellValue(riga.NDG);
        //SOGGETTO
        cell = row.createCell(10); cell.setCellValue(_dataIniSogg);
        cell = row.createCell(11); cell.setCellValue(_dataFinSogg);
        cell = row.createCell(12); cell.setCellValue(riga.TIPOSOGG);
        cell = row.createCell(13); cell.setCellValue(riga.NDGSOGG);
        cell = row.createCell(14); cell.setCellValue(riga.RAGSOG);
        cell = row.createCell(15); cell.setCellValue(riga.SESSOSOGG);
        cell = row.createCell(16); cell.setCellValue(riga.CODFISCSOGG);
        cell = row.createCell(17); cell.setCellValue(_dataNascSogg);
        cell = row.createCell(18); cell.setCellValue(riga.COMUNASCSOGG);
        cell = row.createCell(19); cell.setCellValue(riga.DENOMSOGG);
        cell = row.createCell(20); cell.setCellValue(riga.COMUNRESSOGG);
        cell = row.createCell(21); cell.setCellValue(riga.STATOSOGG);
        cell = row.createCell(22); cell.setCellValue(riga.SAESOGG);
        cell = row.createCell(23); cell.setCellValue(riga.ATECOSOGG);
        /* _cnt := _cnt+1 */
        _cnt = _cnt+1;
      }
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(cNomeFile);
      
      //write this workbook to an Outputstream.
      wb.write(fileOut);
      //fileOut.flush(); 
      fileOut.close();
      wb.dispose();
      /* ElseIf w_tipout='T' */
    } else if (CPLib.eqr(w_tipout,"T")) {
      /* _testo := '' */
      _testo = "";
      /* cNomeFile := cNomeFile+".txt" */
      cNomeFile = cNomeFile+".txt";
      filename_path.add(cNomeFile);
      filename.add(_nomefile+".txt");
      /* fhand := FileLibMit.OpenWritePath(cNomeFile) */
      fhand = FileLibMit.OpenWritePath(cNomeFile);
      for (MemoryCursorRow_mcrapportoall1_mcrdef riga : mcRAPPORTO._iterable_()) {
        /* _testo := riga.TIPOINTER+
           riga.CODINTER+
           riga.RAPPORTO+
           riga.CODFIL+
           riga.CABFIL+
           iif(Empty(riga.DATAPERT) or DateToChar(riga.DATAPERT)='01000101',Space(8),DateToChar(riga.DATAPERT))+
           iif(Empty(riga.DATACHIU) or DateToChar(riga.DATACHIU)='01000101',Space(8),DateToChar(riga.DATACHIU))+
           riga.TIPORAPP+
           riga.VALUTA+
           riga.NDG+
           iif(Empty(riga.DATAINISOGG) or DateToChar(riga.DATAINISOGG)='01000101',Space(8),DateToChar(riga.DATAINISOGG))+
           iif(Empty(riga.DATAFINSOGG) or DateToChar(riga.DATAFINSOGG)='01000101',Space(8),DateToChar(riga.DATAFINSOGG))+
           riga.TIPOSOGG+
           riga.NDGSOGG+
           riga.RAGSOG+
           riga.SESSOSOGG+
           riga.CODFISCSOGG+
           iif(Empty(riga.DATANASCSOGG) or DateToChar(riga.DATANASCSOGG)='01000101',Space(8),DateToChar(riga.DATANASCSOGG))+
           riga.COMUNASCSOGG+
           riga.DENOMSOGG+
           riga.COMUNRESSOGG+
           riga.STATOSOGG+
           riga.SAESOGG+
           riga.ATECOSOGG+
           riga.FILLER+NL */
        _testo = riga.TIPOINTER+riga.CODINTER+riga.RAPPORTO+riga.CODFIL+riga.CABFIL+(CPLib.Empty(riga.DATAPERT) || CPLib.eqr(CPLib.DateToChar(riga.DATAPERT),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATAPERT))+(CPLib.Empty(riga.DATACHIU) || CPLib.eqr(CPLib.DateToChar(riga.DATACHIU),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATACHIU))+riga.TIPORAPP+riga.VALUTA+riga.NDG+(CPLib.Empty(riga.DATAINISOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATAINISOGG),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATAINISOGG))+(CPLib.Empty(riga.DATAFINSOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATAFINSOGG),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATAFINSOGG))+riga.TIPOSOGG+riga.NDGSOGG+riga.RAGSOG+riga.SESSOSOGG+riga.CODFISCSOGG+(CPLib.Empty(riga.DATANASCSOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATANASCSOGG),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATANASCSOGG))+riga.COMUNASCSOGG+riga.DENOMSOGG+riga.COMUNRESSOGG+riga.STATOSOGG+riga.SAESOGG+riga.ATECOSOGG+riga.FILLER+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
      }
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* ElseIf w_tipout='C' */
    } else if (CPLib.eqr(w_tipout,"C")) {
      /* _testo := '' */
      _testo = "";
      /* cNomeFile := cNomeFile+".csv" */
      cNomeFile = cNomeFile+".csv";
      filename_path.add(cNomeFile);
      filename.add(_nomefile+".csv");
      /* fhand := FileLibMit.OpenWritePath(cNomeFile) */
      fhand = FileLibMit.OpenWritePath(cNomeFile);
      /* _testo := 'CODICE_INTERMEDIARIO,IDENTIFICATIVO_RAPPORTO,CODICE_FILIALE,CAB_FILIALE,DATA_APERTURA,DATA_CHIUSURA,TIPO_RAPPORTO,CODICE_VALUTA,NDG,DATA_INIZIO,DATA_FINE,TIPO_SOGGETTO,NDG_SOGGETTO,RAGIONE_SOCIALE,SESSO,CODICE_FILIALE,DATA_NASCITA,COMUNE_NASCITA,INDIRIZZO_RESIDENZA,COMUNE_RESIDENZA,PAESE_RESIDENZA,SAE,ATECO'+NL */
      _testo = "CODICE_INTERMEDIARIO,IDENTIFICATIVO_RAPPORTO,CODICE_FILIALE,CAB_FILIALE,DATA_APERTURA,DATA_CHIUSURA,TIPO_RAPPORTO,CODICE_VALUTA,NDG,DATA_INIZIO,DATA_FINE,TIPO_SOGGETTO,NDG_SOGGETTO,RAGIONE_SOCIALE,SESSO,CODICE_FILIALE,DATA_NASCITA,COMUNE_NASCITA,INDIRIZZO_RESIDENZA,COMUNE_RESIDENZA,PAESE_RESIDENZA,SAE,ATECO"+"\n";
      for (MemoryCursorRow_mcrapportoall1_mcrdef riga : mcRAPPORTO._iterable_()) {
        /* _testo := LRTrim(riga.TIPOINTER)+','+
           LRTrim(riga.CODINTER)+','+
           LRTrim(riga.RAPPORTO)+','+
           LRTrim(riga.CODFIL)+','+
           LRTrim(riga.CABFIL)+','+
           iif(Empty(riga.DATAPERT) or DateToChar(riga.DATAPERT)='01000101','',DateToChar(riga.DATAPERT))+','+
           iif(Empty(riga.DATACHIU) or DateToChar(riga.DATACHIU)='01000101',Space(8),DateToChar(riga.DATACHIU))+','+
           LRTrim(riga.TIPORAPP)+','+
           LRTrim(riga.VALUTA)+','+
           LRTrim(riga.NDG)+','+
           iif(Empty(riga.DATAINISOGG) or DateToChar(riga.DATAINISOGG)='01000101','',DateToChar(riga.DATAINISOGG))+','+
           iif(Empty(riga.DATAFINSOGG) or DateToChar(riga.DATAFINSOGG)='01000101','',DateToChar(riga.DATAFINSOGG))+','+
           LRTrim(riga.TIPOSOGG)+','+
           LRTrim(riga.NDGSOGG)+','+
           LRTrim(riga.RAGSOG)+','+
           LRTrim(riga.SESSOSOGG)+','+
           LRTrim(riga.CODFISCSOGG)+','+
           iif(Empty(riga.DATANASCSOGG) or DateToChar(riga.DATANASCSOGG)='01000101','',DateToChar(riga.DATANASCSOGG))+','+
           LRTrim(riga.COMUNASCSOGG)+','+
           LRTrim(riga.DENOMSOGG)+','+
           LRTrim(riga.COMUNRESSOGG)+','+
           LRTrim(riga.STATOSOGG)+','+
           LRTrim(riga.SAESOGG)+','+
           LRTrim(riga.ATECOSOGG)+NL */
        _testo = CPLib.LRTrim(riga.TIPOINTER)+","+CPLib.LRTrim(riga.CODINTER)+","+CPLib.LRTrim(riga.RAPPORTO)+","+CPLib.LRTrim(riga.CODFIL)+","+CPLib.LRTrim(riga.CABFIL)+","+(CPLib.Empty(riga.DATAPERT) || CPLib.eqr(CPLib.DateToChar(riga.DATAPERT),"01000101")?"":CPLib.DateToChar(riga.DATAPERT))+","+(CPLib.Empty(riga.DATACHIU) || CPLib.eqr(CPLib.DateToChar(riga.DATACHIU),"01000101")?CPLib.Space(8):CPLib.DateToChar(riga.DATACHIU))+","+CPLib.LRTrim(riga.TIPORAPP)+","+CPLib.LRTrim(riga.VALUTA)+","+CPLib.LRTrim(riga.NDG)+","+(CPLib.Empty(riga.DATAINISOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATAINISOGG),"01000101")?"":CPLib.DateToChar(riga.DATAINISOGG))+","+(CPLib.Empty(riga.DATAFINSOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATAFINSOGG),"01000101")?"":CPLib.DateToChar(riga.DATAFINSOGG))+","+CPLib.LRTrim(riga.TIPOSOGG)+","+CPLib.LRTrim(riga.NDGSOGG)+","+CPLib.LRTrim(riga.RAGSOG)+","+CPLib.LRTrim(riga.SESSOSOGG)+","+CPLib.LRTrim(riga.CODFISCSOGG)+","+(CPLib.Empty(riga.DATANASCSOGG) || CPLib.eqr(CPLib.DateToChar(riga.DATANASCSOGG),"01000101")?"":CPLib.DateToChar(riga.DATANASCSOGG))+","+CPLib.LRTrim(riga.COMUNASCSOGG)+","+CPLib.LRTrim(riga.DENOMSOGG)+","+CPLib.LRTrim(riga.COMUNRESSOGG)+","+CPLib.LRTrim(riga.STATOSOGG)+","+CPLib.LRTrim(riga.SAESOGG)+","+CPLib.LRTrim(riga.ATECOSOGG)+"\n";
        /* FileLibMit.Write(fhand,_testo) */
        FileLibMit.Write(fhand,_testo);
      }
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_DaData,java.sql.Date p_w_AData,String p_w_codage,String p_w_codcli,String p_w_rapporto,String p_w_flgope,String p_w_flgrap,String p_w_flgfrz,String p_w_flgordine,String p_w_stoper,String p_w_tipout,String p_w_rappAttivSel) {
    w_DaData = p_w_DaData;
    w_AData = p_w_AData;
    w_codage = p_w_codage;
    w_codcli = p_w_codcli;
    w_rapporto = p_w_rapporto;
    w_flgope = p_w_flgope;
    w_flgrap = p_w_flgrap;
    w_flgfrz = p_w_flgfrz;
    w_flgordine = p_w_flgordine;
    w_stoper = p_w_stoper;
    w_tipout = p_w_tipout;
    w_rappAttivSel = p_w_rappAttivSel;
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
  public String Run(java.sql.Date p_w_DaData,java.sql.Date p_w_AData,String p_w_codage,String p_w_codcli,String p_w_rapporto,String p_w_flgope,String p_w_flgrap,String p_w_flgfrz,String p_w_flgordine,String p_w_stoper,String p_w_tipout,String p_w_rappAttivSel) {
    w_DaData = p_w_DaData;
    w_AData = p_w_AData;
    w_codage = p_w_codage;
    w_codcli = p_w_codcli;
    w_rapporto = p_w_rapporto;
    w_flgope = p_w_flgope;
    w_flgrap = p_w_flgrap;
    w_flgfrz = p_w_flgfrz;
    w_flgordine = p_w_flgordine;
    w_stoper = p_w_stoper;
    w_tipout = p_w_tipout;
    w_rappAttivSel = p_w_rappAttivSel;
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
  public static arfn_estrai_all1R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_estrai_all1R(p_Ctx, p_Caller);
  }
  public static arfn_estrai_all1R Make(CPContext p_Ctx) {
    return new arfn_estrai_all1R(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_DaData = CPLib.NullDate();
    w_AData = CPLib.NullDate();
    w_codage = CPLib.Space(6);
    w_codcli = CPLib.Space(16);
    w_rapporto = CPLib.Space(25);
    w_flgope = CPLib.Space(1);
    w_flgrap = CPLib.Space(1);
    w_flgfrz = CPLib.Space(1);
    w_flgordine = CPLib.Space(1);
    w_stoper = CPLib.Space(1);
    w_tipout = CPLib.Space(1);
    w_rappAttivSel = CPLib.Space(0);
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
    nomefoglio = CPLib.Space(50);
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
    _tiprec = CPLib.Space(1);
    _raeatc = CPLib.Space(1);
    oldfolder = CPLib.Space(120);
    _tipoag = CPLib.Space(10);
    _datage = CPLib.Space(44);
    _numticket = CPLib.Space(30);
    w_cdareg = CPLib.Space(8);
    w_c_areg = CPLib.Space(8);
    z_desccit = CPLib.Space(30);
    z_codcab = CPLib.Space(6);
    z_provin = CPLib.Space(2);
    z_coddipe = CPLib.Space(6);
    _idb = CPLib.Space(10);
    _connescli = CPLib.Space(16);
    _connaltro = CPLib.Space(16);
    _datastorico = CPLib.NullDate();
    _statooperazione = CPLib.Space(1);
    _datarettifica = CPLib.NullDate();
    _tipoperazione = CPLib.Space(1);
    _rapporto_check = CPLib.Space(25);
    _codcli_check = CPLib.Space(16);
    _testo = CPLib.Space(0);
    _dateTimeNow = CPLib.NullDateTime();
    _data_ora = CPLib.Space(0);
    mcANADIP = new MemoryCursor_anadip();
    mcOPERAZIONI = new MemoryCursor_mcoperazioniall1_mcrdef();
    rwOPE = new MemoryCursorRow_mcoperazioniall1_mcrdef();
    mcSOGGETTI = new MemoryCursor_mcsoggettiall1_mcrdef();
    rwSOG = new MemoryCursorRow_mcsoggettiall1_mcrdef();
    mcRAPPORTO = new MemoryCursor_mcrapportoall1_mcrdef();
    rwRAP = new MemoryCursorRow_mcrapportoall1_mcrdef();
    mcANARAP = new MemoryCursor_mcanarap_mcrdef();
    mcANARAP_APP = new MemoryCursor_mcanarap_mcrdef();
    rwANARAP = new MemoryCursorRow_mcanarap_mcrdef();
    mcRAPOPEBO = new MemoryCursor_rapopebo();
    w_ragben = CPLib.Space(0);
    mcINTESTBO = new MemoryCursor_intestbo();
    mcINTESTIT = new MemoryCursor_intestit();
    mcFIDUCIABO = new MemoryCursor_fiduciabo();
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
    pCodDip = CPLib.Space(12);
    pCodCabFil = CPLib.Space(12);
    pCodCab = CPLib.Space(12);
    pDesCit = CPLib.Space(30);
    pProv = CPLib.Space(2);
    _dataOpe = CPLib.Space(8);
    _dataNascita = CPLib.Space(8);
    _dataNascitaEse = CPLib.Space(8);
    _dataApert = CPLib.Space(8);
    _dataChiu = CPLib.Space(8);
    _dataIniSogg = CPLib.Space(8);
    _dataFinSogg = CPLib.Space(8);
    _dataNascSogg = CPLib.Space(8);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_oped_chkdiana_limits,qbe_oped_chkdiana,qbe_frad_chkdiana_limits,qbe_frad_chkdiana,qbe_oped_chkdiana_cli,qbe_frad_chkdiana_cli,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_anarapbo_all1,qbe_rapporti_all1_agg1,
  public static final String m_cVQRList = ",qbe_oped_chkdiana_limits,qbe_oped_chkdiana,qbe_frad_chkdiana_limits,qbe_frad_chkdiana,qbe_oped_chkdiana_cli,qbe_frad_chkdiana_cli,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_tab_mmc,qbe_anarapbo_all1,qbe_rapporti_all1_agg1,";
  // ENTITY_BATCHES: ,arfn_calc_idereg,arfn_datisog_sol_row,arfn_estrai_all1,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_calc_idereg,arfn_datisog_sol_row,arfn_estrai_all1,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"w_DaData","w_AData","w_codage","w_codcli","w_rapporto","w_flgope","w_flgrap","w_flgfrz","w_flgordine","w_stoper","w_tipout","w_rappAttivSel"};
}
