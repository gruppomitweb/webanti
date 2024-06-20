// * --- Area Manuale = BO - Header
// * --- arrt_import_file_xlsx_esterni
import java.io.InputStream;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.text.SimpleDateFormat;

import java.util.Iterator;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
//import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

//Per la lettura di un csv
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import com.opencsv.*;
import com.opencsv.CSVReader;
import java.io.File;
// * --- Fine Area Manuale
public class arrt_import_file_xlsx_esterniR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopstor;
  public String m_cServer_aeopstor;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
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
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_japopebo;
  public String m_cServer_japopebo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jperazbo;
  public String m_cServer_jperazbo;
  public String m_cPhName_kperazbo;
  public String m_cServer_kperazbo;
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
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
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
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xogopefbo;
  public String m_cServer_xogopefbo;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
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
  public java.sql.Date datamod;
  public boolean aggfam;
  public String pnomefile;
  public double pannorif;
  public String pselezione;
  public String nomefile;
  public String nomefileoutput;
  public String nota;
  public double cell_count;
  public boolean modifica;
  public String _connes;
  public String _cf;
  public String _FLGANAVAL;
  public double _min;
  public double _max;
  public double _cicli;
  public double _conta;
  public double _bottom;
  public double _top;
  public double _totale;
  public double _contarec;
  public double _mono;
  public String _annoc;
  public double _totsal;
  public double _numope;
  public double _reccount;
  public double _tot;
  public String _oldmsg;
  public MemoryCursor_tbcitta mcTbcitta;
  public MemoryCursor_anadip mcAnadip;
  public String gAzienda;
  public java.sql.Date gDataVaria;
  public String gPathApp;
  public String gMsgImp;
  public String gMsgProc;
  public java.sql.Date oggi;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_file_xlsx_esterni
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  public int r;
  public int cell_type;
  String sheetName = "Sheet1";
  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
  // * --- Fine Area Manuale
  public arrt_import_file_xlsx_esterniR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.SinkFromCaller(m_Caller);
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_import_file_xlsx_esterni",m_Caller);
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
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
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
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
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jperazbo = p_ContextObject.GetPhName("jperazbo");
    if (m_cPhName_jperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jperazbo = m_cPhName_jperazbo+" "+m_Ctx.GetWritePhName("jperazbo");
    }
    m_cServer_jperazbo = p_ContextObject.GetServer("jperazbo");
    m_cPhName_kperazbo = p_ContextObject.GetPhName("kperazbo");
    if (m_cPhName_kperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_kperazbo = m_cPhName_kperazbo+" "+m_Ctx.GetWritePhName("kperazbo");
    }
    m_cServer_kperazbo = p_ContextObject.GetServer("kperazbo");
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
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
      m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
      if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
      }
      m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    }
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pannorif",p_cVarName)) {
      return pannorif;
    }
    if (CPLib.eqr("cell_count",p_cVarName)) {
      return cell_count;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      return _contarec;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_totsal",p_cVarName)) {
      return _totsal;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      return _numope;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_file_xlsx_esterni";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pnomefile",p_cVarName)) {
      return pnomefile;
    }
    if (CPLib.eqr("pselezione",p_cVarName)) {
      return pselezione;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("nomefileoutput",p_cVarName)) {
      return nomefileoutput;
    }
    if (CPLib.eqr("nota",p_cVarName)) {
      return nota;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_cf",p_cVarName)) {
      return _cf;
    }
    if (CPLib.eqr("_FLGANAVAL",p_cVarName)) {
      return _FLGANAVAL;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      return _annoc;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("datamod",p_cVarName)) {
      return datamod;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      return gDataVaria;
    }
    if (CPLib.eqr("oggi",p_cVarName)) {
      return oggi;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("aggfam",p_cVarName)) {
      return aggfam;
    }
    if (CPLib.eqr("modifica",p_cVarName)) {
      return modifica;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcTbcitta",p_cVarName)) {
      return mcTbcitta;
    }
    if (CPLib.eqr("mcAnadip",p_cVarName)) {
      return mcAnadip;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("pannorif",p_cVarName)) {
      pannorif = value;
      return;
    }
    if (CPLib.eqr("cell_count",p_cVarName)) {
      cell_count = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
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
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      _contarec = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_totsal",p_cVarName)) {
      _totsal = value;
      return;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      _numope = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pnomefile",p_cVarName)) {
      pnomefile = value;
      return;
    }
    if (CPLib.eqr("pselezione",p_cVarName)) {
      pselezione = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("nomefileoutput",p_cVarName)) {
      nomefileoutput = value;
      return;
    }
    if (CPLib.eqr("nota",p_cVarName)) {
      nota = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_cf",p_cVarName)) {
      _cf = value;
      return;
    }
    if (CPLib.eqr("_FLGANAVAL",p_cVarName)) {
      _FLGANAVAL = value;
      return;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      _annoc = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
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
    if (CPLib.eqr("datamod",p_cVarName)) {
      datamod = value;
      return;
    }
    if (CPLib.eqr("gDataVaria",p_cVarName)) {
      gDataVaria = value;
      return;
    }
    if (CPLib.eqr("oggi",p_cVarName)) {
      oggi = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("aggfam",p_cVarName)) {
      aggfam = value;
      return;
    }
    if (CPLib.eqr("modifica",p_cVarName)) {
      modifica = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTbcitta",p_cVarName)) {
      mcTbcitta = (MemoryCursor_tbcitta)value;
      return;
    }
    if (CPLib.eqr("mcAnadip",p_cVarName)) {
      mcAnadip = (MemoryCursor_anadip)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_tbcitta=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* datamod Date // Parametro del portlet con la data a cui devono essere registrate le modifiche */
      /* aggfam Bool // Aggiorna le famiglie collegate (operazioni) */
      /* pnomefile Char(200) // nome del file per import */
      /* pannorif Numeric(4, 0) // Anno riferimento saldi */
      /* pselezione Char(1) // Tipo Operazione */
      /* nomefile Char(30) // nome file da importare */
      /* nomefileoutput Char(30) // nome file risultati */
      /* nota Char(100) // nota del eventuale problema */
      /* cell_count Numeric(9, 0) // Contatore delle celle lette */
      /* modifica Bool // ok alla modifica dei dati */
      /* _connes Char(16) // connes letto */
      /* _cf Char(16) // CF letto */
      /* _FLGANAVAL Char(1) // flag blocco anagrafica */
      /* _min Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _conta Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _totale Numeric(15, 0) */
      /* _contarec Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _annoc Char(4) */
      /* _totsal Numeric(12, 2) */
      /* _numope Numeric(10, 0) */
      /* _reccount Numeric(10, 0) */
      /* _tot Numeric(15, 0) */
      /* _oldmsg Char(100) */
      /* mcTbcitta MemoryCursor(tbcitta) */
      /* mcAnadip MemoryCursor(anadip) */
      /* gAzienda Char(10) // Azienda */
      /* gDataVaria Date // Data Variazione */
      /* gPathApp Char(80) // Path Applicazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* column01 Char(25) */
      String column01;
      column01 = CPLib.Space(25);
      /* column02 Char(25) */
      String column02;
      column02 = CPLib.Space(25);
      /* foglio Numeric(2, 0) // foglio letto */
      double foglio;
      foglio = 0;
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      double riga_letta;
      riga_letta = 0;
      /* riga_letta_c Char(9) // riga letta del file Excel Character */
      String riga_letta_c;
      riga_letta_c = CPLib.Space(9);
      /* w_DATARETT Date // data rettifica */
      java.sql.Date w_DATARETT;
      w_DATARETT = CPLib.NullDate();
      /* cProgSto Char(15) // progressivo wersonbo del giorno */
      String cProgSto;
      cProgSto = CPLib.Space(15);
      /* oggi Date // Data odierna per le modifiche */
      /* oggi := Date() // Data odierna per le modifiche */
      oggi = CPLib.Date();
      /* nomefile := 'realFC.xlsx' // nome file da importare */
      nomefile = "realFC.xlsx";
      /* nomefileoutput := 'realFC_out.xlsx' // nome file risultati */
      nomefileoutput = "realFC_out.xlsx";
      /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pselezione<>'S' and pselezione <> 'M' */
      if (CPLib.ne(pselezione,"S") && CPLib.ne(pselezione,"M")) {
        /* If FileLibMit.ExistFile(LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+'/'+LRTrim(nomefile)) */
        if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefile))) {
          /* Status Msg 'Apertura file Excel. '+Chr(13)+Chr(10)+"Elaborazione in corso..." */
          m_MessageSink.SendMessage("Apertura file Excel. "+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...");
          /* w_DATARETT := Date() // data rettifica */
          w_DATARETT = CPLib.Date();
          /* w_DATARETT := CharToDate('01/08/2016') // data rettifica */
          w_DATARETT = CPLib.CharToDate("01/08/2016");
          /* w_DATARETT := datamod // data rettifica */
          w_DATARETT = datamod;
          /* gDataVaria := w_DATARETT // Data Variazione */
          gDataVaria = w_DATARETT;
          m_Ctx.SetGlobalDate("gDataVaria",gDataVaria);
          /* riga_letta := 0 // riga letta del file Excel */
          riga_letta = CPLib.Round(0,0);
          //base
          InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefile));
          XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
          
          conta = wb.getNumberOfSheets();
          
          //XSSFWorkbook test = new XSSFWorkbook(); 
          
          //XSSFSheet sheet = wb.getSheetAt(0);
          XSSFRow row; 
          XSSFCell cell;
          
          XSSFRow row2; 
          XSSFCell cell2;
          
          //Iterator rows = sheet.rowIterator();
          // creo il contenitore dei fogli
          XSSFWorkbook wb2 = new XSSFWorkbook();
          XSSFSheet sheet2 = wb2.createSheet(sheetName) ;
          //Azzero i contatori di fogli letti e righe scritte
          _i = 0;
          r=0;
          //Creo il record da scrivere
          row2 = (XSSFRow) sheet2.createRow(r);
          //scrivo la riga di intestazione
          cell2 = (XSSFCell) row2.createCell(0);
          cell2.setCellValue("CF_old");
          cell2 = (XSSFCell) row2.createCell(1);
          cell2.setCellValue("CF_new");
          cell2 = (XSSFCell) row2.createCell(2);
          cell2.setCellValue("note");
          cell2 = (XSSFCell) row2.createCell(3);
          cell2.setCellValue("Riga");
          r++;
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry00000042status;
          nTry00000042status = m_Sql.GetTransactionStatus();
          String cTry00000042msg;
          cTry00000042msg = m_Sql.TransactionErrorMessage();
          try {
            /* While _i < conta */
            while (CPLib.lt(_i,conta)) {
              //Apro uno ad uno i fogli del file Excel
              XSSFSheet sheet = wb.getSheetAt(_i);
              //Mi definisco un oggetto che contiene tutte le righe
              Iterator rows = sheet.rowIterator();
              //_righe = sheet.getLastRowNum()+1;
              //_y = 1;
              /* foglio := _i // foglio letto */
              foglio = CPLib.Round(_i,0);
              /* While rows.hasNext() */
              while (rows.hasNext()) {
                //scorro le righe
                row=(XSSFRow) rows.next();
                //Mi definisco un oggetto che contiene tutte le celle della riga letta
                Iterator cells = row.cellIterator();
                /* cell_count := 0 */
                cell_count = CPLib.Round(0,0);
                /* riga_letta := riga_letta+1 // riga letta del file Excel */
                riga_letta = CPLib.Round(riga_letta+1,0);
                /* nota := '' // nota del eventuale problema */
                nota = "";
                /* modifica := True // ok alla modifica dei dati */
                modifica = true;
                /* While cells.hasNext() and riga_letta>1 */
                while (cells.hasNext() && CPLib.gt(riga_letta,1)) {
                  //scorro le celle della riga
                  cell=(XSSFCell) cells.next();
                  /* cell_count := cell_count+1 */
                  cell_count = CPLib.Round(cell_count+1,0);
                  /* cell_type := cell.getCellType().ordinal() */
                  cell_type = cell.getCellType().ordinal();
                  /* Case cell_type=1 */
                  if (CPLib.eqr(cell_type,1)) {
                    /* tipo numerico
                       da definire il comportamento */
                    /* Case cell_type=2 */
                  } else if (CPLib.eqr(cell_type,2)) {
                    /* If cell_count=1 */
                    if (CPLib.eqr(cell_count,1)) {
                      /* column01 := cell.getStringCellValue() */
                      column01 = cell.getStringCellValue();
                    } // End If
                    /* If cell_count=2 */
                    if (CPLib.eqr(cell_count,2)) {
                      /* column02 := cell.getStringCellValue() */
                      column02 = cell.getStringCellValue();
                      /* If not(Empty(LRTrim(column01))) */
                      if ( ! (CPLib.Empty(CPLib.LRTrim(column01)))) {
                        /* If Len(LRTrim(column01))<16 */
                        if (CPLib.lt(CPLib.Len(CPLib.LRTrim(column01)),16)) {
                          /* nota := iif(Empty(nota),'CF_old <16',nota+' CF_old <16') // nota del eventuale problema */
                          nota = (CPLib.Empty(nota)?"CF_old <16":nota+" CF_old <16");
                        } // End If
                        /* If Len(LRTrim(column02))<16 */
                        if (CPLib.lt(CPLib.Len(CPLib.LRTrim(column02)),16)) {
                          /* nota := iif(Empty(nota),'CF_new<16',nota+' CF_new <16') // nota del eventuale problema */
                          nota = (CPLib.Empty(nota)?"CF_new<16":nota+" CF_new <16");
                          /* modifica := False // ok alla modifica dei dati */
                          modifica = false;
                        } // End If
                        // * --- Read from personbo_agg
                        m_cServer = m_Ctx.GetServer("personbo_agg");
                        m_cPhName = m_Ctx.GetPhName("personbo_agg");
                        m_cSql = "";
                        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(column01,"C",16,0,m_cServer),m_cServer,column01);
                        if (m_Ctx.IsSharedTemp("personbo_agg")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("FLGANAVAL",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _FLGANAVAL = Read_Cursor.GetString("FLGANAVAL");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on personbo_agg into routine arrt_import_file_xlsx_esterni returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _FLGANAVAL = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If _FLGANAVAL='S' */
                        if (CPLib.eqr(_FLGANAVAL,"S")) {
                          /* nota := iif(Empty(nota),'Anagrafica bloccata da verifica massivo CF',nota+' Anagrafica bloccata da verifica massivo CF') // nota del eventuale problema */
                          nota = (CPLib.Empty(nota)?"Anagrafica bloccata da verifica massivo CF":nota+" Anagrafica bloccata da verifica massivo CF");
                          /* modifica := False // ok alla modifica dei dati */
                          modifica = false;
                        } // End If
                        /* If modifica */
                        if (modifica) {
                          /* cProgSto := '' */
                          cProgSto = "";
                          // * --- Select from wersonbo
                          m_cServer = m_Ctx.GetServer("wersonbo");
                          m_cPhName = m_Ctx.GetPhName("wersonbo");
                          if (Cursor_wersonbo!=null)
                            Cursor_wersonbo.Close();
                          Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column01),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column01))+"  and  datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DATARETT,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DATARETT)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                            // * --- Select from personbo
                            m_cServer = m_Ctx.GetServer("personbo");
                            m_cPhName = m_Ctx.GetPhName("personbo");
                            if (Cursor_personbo!=null)
                              Cursor_personbo.Close();
                            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column01),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column01))+"  and  CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column01),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column01))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                            {
                              final CPResultSet m_TheCursor = Cursor_personbo;
                              Cursor_personbo.ActionOnClose(new Runnable() {
                                public void run() {
                                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                                    if ( ! (CPLib.IsNull(info))) {
                                      info.log("Routine arrt_import_file_xlsx_esterni: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                                    }
                                  }
                                }
                                });
                            }
                            if ( ! (Cursor_personbo.Eof())) {
                              while ( ! (Cursor_personbo.Eof())) {
                                /* Se cambia il cf faccio la registrazione sullo storico */
                                /* If LRTrim(column02)<>personbo->CODFISC */
                                if (CPLib.ne(CPLib.LRTrim(column02),Cursor_personbo.GetString("CODFISC"))) {
                                  /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
                                  cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
                                  // * --- Insert into wersonbo from values
                                  m_Sql.RequireTransaction();
                                  m_cServer = m_Ctx.GetServer("wersonbo");
                                  m_cPhName = m_Ctx.GetPhName("wersonbo");
                                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000069")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                                  m_cSql = m_cSql+GetFieldsName_00000069(m_Ctx,m_oWrInfo);
                                  m_cSql = m_cSql+") values (";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column01),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(gDataVaria,"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
                                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
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
                                  // * --- Write into personbo from values
                                  m_Sql.RequireTransaction();
                                  m_cServer = m_Ctx.GetServer("personbo");
                                  m_cPhName = m_Ctx.GetPhName("personbo");
                                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000006A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.LRTrim(column02),"C",16,0,m_cServer)+", ";
                                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                  m_cSql = m_cSql+" where ";
                                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                                  m_cSql = m_cSql+" and CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CODFISC"))+"";
                                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                                  {
                                    if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                                      if ( ! (CPLib.IsNull(info))) {
                                        info.log("Routine arrt_import_file_xlsx_esterni: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                                      }
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
                                  /* nota := iif(Empty(nota),'soggetto trovato, storicizzato e modificato',nota+' soggetto trovato, storicizzato e modificato') // nota del eventuale problema */
                                  nota = (CPLib.Empty(nota)?"soggetto trovato, storicizzato e modificato":nota+" soggetto trovato, storicizzato e modificato");
                                  /* nota := nota+'. '+iif(LRTrim(column01)<>LRTrim(column02),'Codici fiscali diversi','Codici fiscali uguali') // nota del eventuale problema */
                                  nota = nota+". "+(CPLib.ne(CPLib.LRTrim(column01),CPLib.LRTrim(column02))?"Codici fiscali diversi":"Codici fiscali uguali");
                                } else { // Else
                                  // * --- Write into personbo from values
                                  m_Sql.RequireTransaction();
                                  m_cServer = m_Ctx.GetServer("personbo");
                                  m_cPhName = m_Ctx.GetPhName("personbo");
                                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000006D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.LRTrim(column02),"C",16,0,m_cServer)+", ";
                                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                  m_cSql = m_cSql+" where ";
                                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                                  m_cSql = m_cSql+" and CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CODFISC"))+"";
                                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                                  {
                                    if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                                      if ( ! (CPLib.IsNull(info))) {
                                        info.log("Routine arrt_import_file_xlsx_esterni: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                                      }
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
                                  /* nota := iif(Empty(nota),'soggetto trovato e modificato',nota+' soggetto trovato e modificato') // nota del eventuale problema */
                                  nota = (CPLib.Empty(nota)?"soggetto trovato e modificato":nota+" soggetto trovato e modificato");
                                  /* nota := nota+'. '+iif(LRTrim(column01)<>LRTrim(column02),'Codici fiscali diversi','Codici fiscali uguali') // nota del eventuale problema */
                                  nota = nota+". "+(CPLib.ne(CPLib.LRTrim(column01),CPLib.LRTrim(column02))?"Codici fiscali diversi":"Codici fiscali uguali");
                                } // End If
                                /* If aggfam */
                                if (aggfam) {
                                  // * --- Write into opextrbo from values
                                  m_Sql.RequireTransaction();
                                  m_cServer = m_Ctx.GetServer("opextrbo");
                                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000071")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                  m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(oggi,"D",8,0)+", ";
                                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                                  m_cSql = m_cSql+" where ";
                                  m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                                  m_cSql = m_cSql+" and ANNO > "+CPSql.SQLValueAdapter(CPLib.ToSQL("2010","?",0,0,m_cServer),m_cServer,"2010")+"";
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
                                Cursor_personbo.Next();
                              }
                              m_cConnectivityError = Cursor_personbo.ErrorMessage();
                            } else {
                              // No rows selected
                              /* _connes := '' // connes letto */
                              _connes = "";
                              /* _cf := '' // CF letto */
                              _cf = "";
                              // * --- Read from personbo
                              m_cServer = m_Ctx.GetServer("personbo");
                              m_cPhName = m_Ctx.GetPhName("personbo");
                              m_cSql = "";
                              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column01),"C",16,0,m_cServer),m_cServer,CPLib.LTrim(column01));
                              if (m_Ctx.IsSharedTemp("personbo")) {
                                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                              }
                              if (Read_Cursor!=null)
                                Read_Cursor.Close();
                              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                              if ( ! (Read_Cursor.Eof())) {
                                _connes = Read_Cursor.GetString("CONNES");
                                _cf = Read_Cursor.GetString("CODFISC");
                                Read_Cursor.Next();
                                if ( ! (Read_Cursor.Eof())) {
                                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_file_xlsx_esterni returns two or more records. This item should return only a record.");
                                  CPStdCounter.Error(l_oErrorFault);
                                }
                                Read_Cursor.Close();
                              } else {
                                // Error: no record found!
                                _connes = "";
                                _cf = "";
                                Read_Cursor.Close();
                                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                              }
                              /* If Empty(_connes) */
                              if (CPLib.Empty(_connes)) {
                                /* nota := iif(Empty(nota),'soggetto ricercato non trovato in anagrafica',nota+' soggetto ricercato non trovato in anagrafica') // nota del eventuale problema */
                                nota = (CPLib.Empty(nota)?"soggetto ricercato non trovato in anagrafica":nota+" soggetto ricercato non trovato in anagrafica");
                              } else { // Else
                                /* If _cf=LRTrim(column02) */
                                if (CPLib.eqr(_cf,CPLib.LRTrim(column02))) {
                                  /* nota := iif(Empty(nota),'soggetto ricercato trovato in anagrafica, con lo stesso CF',nota+' soggetto ricercato trovato in anagrafica, con lo stesso CF') // nota del eventuale problema */
                                  nota = (CPLib.Empty(nota)?"soggetto ricercato trovato in anagrafica, con lo stesso CF":nota+" soggetto ricercato trovato in anagrafica, con lo stesso CF");
                                } else { // Else
                                  /* nota := iif(Empty(nota),'soggetto ricercato trovato in anagrafica, con CF diverso '+_cf,nota+' soggetto ricercato trovato in anagrafica, con CF diverso '+_cf) // nota del eventuale problema */
                                  nota = (CPLib.Empty(nota)?"soggetto ricercato trovato in anagrafica, con CF diverso "+_cf:nota+" soggetto ricercato trovato in anagrafica, con CF diverso "+_cf);
                                } // End If
                              } // End If
                            }
                            Cursor_personbo.Close();
                            // * --- End Select
                          } else { // Else
                            // * --- Select from personbo
                            m_cServer = m_Ctx.GetServer("personbo");
                            m_cPhName = m_Ctx.GetPhName("personbo");
                            if (Cursor_personbo!=null)
                              Cursor_personbo.Close();
                            Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column01),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column01))+"  and  CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column01),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column01))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                            {
                              final CPResultSet m_TheCursor = Cursor_personbo;
                              Cursor_personbo.ActionOnClose(new Runnable() {
                                public void run() {
                                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                                    if ( ! (CPLib.IsNull(info))) {
                                      info.log("Routine arrt_import_file_xlsx_esterni: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                                    }
                                  }
                                }
                                });
                            }
                            if ( ! (Cursor_personbo.Eof())) {
                              while ( ! (Cursor_personbo.Eof())) {
                                // * --- Write into personbo from values
                                m_Sql.RequireTransaction();
                                m_cServer = m_Ctx.GetServer("personbo");
                                m_cPhName = m_Ctx.GetPhName("personbo");
                                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000007B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.LRTrim(column02),"C",16,0,m_cServer)+", ";
                                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                m_cSql = m_cSql+" where ";
                                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                                m_cSql = m_cSql+" and CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CODFISC"))+"";
                                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                                {
                                  if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                                    if ( ! (CPLib.IsNull(info))) {
                                      info.log("Routine arrt_import_file_xlsx_esterni: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                                    }
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
                                /* If aggfam */
                                if (aggfam) {
                                  // * --- Write into opextrbo from values
                                  m_Sql.RequireTransaction();
                                  m_cServer = m_Ctx.GetServer("opextrbo");
                                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000007D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                  m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(oggi,"D",8,0)+", ";
                                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                                  m_cSql = m_cSql+" where ";
                                  m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                                  m_cSql = m_cSql+" and ANNO > "+CPSql.SQLValueAdapter(CPLib.ToSQL("2010","?",0,0,m_cServer),m_cServer,"2010")+"";
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
                                /* nota := iif(Empty(nota),'soggetto trovato e modificato',nota+' soggetto trovato e modificato') // nota del eventuale problema */
                                nota = (CPLib.Empty(nota)?"soggetto trovato e modificato":nota+" soggetto trovato e modificato");
                                /* nota := nota+'. '+iif(LRTrim(column01)<>LRTrim(column02),'Codici fiscali diversi','Codici fiscali uguali') // nota del eventuale problema */
                                nota = nota+". "+(CPLib.ne(CPLib.LRTrim(column01),CPLib.LRTrim(column02))?"Codici fiscali diversi":"Codici fiscali uguali");
                                Cursor_personbo.Next();
                              }
                              m_cConnectivityError = Cursor_personbo.ErrorMessage();
                            } else {
                              // No rows selected
                              /* _connes := '' // connes letto */
                              _connes = "";
                              /* _cf := '' // CF letto */
                              _cf = "";
                              // * --- Read from personbo
                              m_cServer = m_Ctx.GetServer("personbo");
                              m_cPhName = m_Ctx.GetPhName("personbo");
                              m_cSql = "";
                              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column01),"C",16,0,m_cServer),m_cServer,CPLib.LTrim(column01));
                              if (m_Ctx.IsSharedTemp("personbo")) {
                                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                              }
                              if (Read_Cursor!=null)
                                Read_Cursor.Close();
                              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                              if ( ! (Read_Cursor.Eof())) {
                                _connes = Read_Cursor.GetString("CONNES");
                                _cf = Read_Cursor.GetString("CODFISC");
                                Read_Cursor.Next();
                                if ( ! (Read_Cursor.Eof())) {
                                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_file_xlsx_esterni returns two or more records. This item should return only a record.");
                                  CPStdCounter.Error(l_oErrorFault);
                                }
                                Read_Cursor.Close();
                              } else {
                                // Error: no record found!
                                _connes = "";
                                _cf = "";
                                Read_Cursor.Close();
                                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                              }
                              /* If Empty(_connes) */
                              if (CPLib.Empty(_connes)) {
                                /* nota := iif(Empty(nota),'soggetto ricercato non trovato in anagrafica',nota+' soggetto ricercato non trovato in anagrafica') // nota del eventuale problema */
                                nota = (CPLib.Empty(nota)?"soggetto ricercato non trovato in anagrafica":nota+" soggetto ricercato non trovato in anagrafica");
                              } else { // Else
                                /* If _cf=LRTrim(column02) */
                                if (CPLib.eqr(_cf,CPLib.LRTrim(column02))) {
                                  /* nota := iif(Empty(nota),'soggetto ricercato trovato in anagrafica, con lo stesso CF',nota+' soggetto ricercato trovato in anagrafica, con lo stesso CF') // nota del eventuale problema */
                                  nota = (CPLib.Empty(nota)?"soggetto ricercato trovato in anagrafica, con lo stesso CF":nota+" soggetto ricercato trovato in anagrafica, con lo stesso CF");
                                } else { // Else
                                  /* nota := iif(Empty(nota),'soggetto ricercato trovato in anagrafica, con CF diverso '+_cf,nota+' soggetto ricercato trovato in anagrafica, con CF diverso '+_cf) // nota del eventuale problema */
                                  nota = (CPLib.Empty(nota)?"soggetto ricercato trovato in anagrafica, con CF diverso "+_cf:nota+" soggetto ricercato trovato in anagrafica, con CF diverso "+_cf);
                                } // End If
                              } // End If
                            }
                            Cursor_personbo.Close();
                            // * --- End Select
                          } // End If
                        } // End If
                      } // End If
                    } // End If
                    /* Case cell_type=0 */
                  } else if (CPLib.eqr(cell_type,0)) {
                    /* tipo buleano
                       da definire il comportamento
                       non è booleanao è tipo formula da vedere */
                    /* Case cell_type=3 */
                  } else if (CPLib.eqr(cell_type,3)) {
                    /* If cell_count=1 */
                    if (CPLib.eqr(cell_count,1)) {
                      /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)') // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)");
                      // Transaction Error
                      cTry00000042msg = CPLib.FormatMsg(m_Ctx,"'old cf vuoto'");
                      m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'old cf vuoto'"));
                    } // End If
                    /* If cell_count=2 */
                    if (CPLib.eqr(cell_count,2)) {
                      /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)') // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)");
                      // Transaction Error
                      cTry00000042msg = CPLib.FormatMsg(m_Ctx,"'new cf vuoto'");
                      m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'new cf vuoto'"));
                    } // End If
                  } else { // Otherwise
                  } // End Case
                } // End While
                /* Status Msg 'Sto leggendo riga: %1 del foglio %2.'+Chr(13)+Chr(10)+"Elaborazione in corso..." */
                m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Sto leggendo riga: %1 del foglio %2."+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...",riga_letta,foglio));
                /* gMsgImp := 'Sto leggendo la riga n. '+LRTrim(Str(riga_letta,10,0))+". Elaborazione in corso...." // Messaggio Import */
                gMsgImp = "Sto leggendo la riga n. "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0))+". Elaborazione in corso....";
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* If riga_letta>1 */
                if (CPLib.gt(riga_letta,1)) {
                  /* riga_letta_c := Str(riga_letta,9,0) */
                  riga_letta_c = CPLib.Str(riga_letta,9,0);
                  //Creo il record da scrivere
                  row2 = (XSSFRow) sheet2.createRow(r);
                  cell2 = (XSSFCell) row2.createCell(0);
                  cell2.setCellValue(CPLib.LRTrim(column01));
                  cell2 = (XSSFCell) row2.createCell(1);
                  cell2.setCellValue(CPLib.LRTrim(column02));
                  cell2 = (XSSFCell) row2.createCell(2);
                  cell2.setCellValue(CPLib.LRTrim(nota));
                  cell2 = (XSSFCell) row2.createCell(3);
                  cell2.setCellValue(CPLib.LRTrim(riga_letta_c));
                  r++;
                } // End If
              } // End While
              _i++;
            } // End While
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* Error Msg 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
            m_cLastMsgError = "Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000042status,0)) {
              m_Sql.SetTransactionStatus(nTry00000042status,cTry00000042msg);
            }
          }
          //Ridimensiono le colonne in base al contenuto
          sheet2.autoSizeColumn(0);
          sheet2.autoSizeColumn(1);
          sheet2.autoSizeColumn(2);
          sheet2.autoSizeColumn(3);
          // scrivo il file di esito
          FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefileoutput));
          
          //write this workbook to an Outputstream.
          wb2.write(fileOut);
          fileOut.flush();
          fileOut.close();
        } else { // Else
          /* nomefile := 'correzioni.xlsx' */
          nomefile = "correzioni.xlsx";
          /* nomefileoutput := 'correzioni_out.xlsx' // nome file risultati */
          nomefileoutput = "correzioni_out.xlsx";
          /* If FileLibMit.ExistFile(LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+'/'+LRTrim(nomefile)) */
          if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefile))) {
            /* Exec "correzioni" Page 2:Page_2 */
            Page_2();
          } else { // Else
            /* nomefile := 'esiti.xlsx' */
            nomefile = "esiti.xlsx";
            /* nomefileoutput := 'esiti_out.xlsx' // nome file risultati */
            nomefileoutput = "esiti_out.xlsx";
            /* If FileLibMit.ExistFile(LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+'/'+LRTrim(nomefile)) */
            if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefile))) {
              /* Exec "esiti" Page 4:Page_4 */
              Page_4();
            } else { // Else
              /* nomefile := 'esiti2.xlsx' */
              nomefile = "esiti2.xlsx";
              /* nomefileoutput := 'esiti2_out.xlsx' // nome file risultati */
              nomefileoutput = "esiti2_out.xlsx";
              /* If FileLibMit.ExistFile(LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+'/'+LRTrim(nomefile)) */
              if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefile))) {
                /* Exec "esti2" Page 5:Page_5 */
                Page_5();
              } else { // Else
                /* nomefile := 'cancella.xlsx' */
                nomefile = "cancella.xlsx";
                /* nomefileoutput := 'cancella_out.xlsx' // nome file risultati */
                nomefileoutput = "cancella_out.xlsx";
                /* If FileLibMit.ExistFile(LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+'/'+LRTrim(nomefile)) */
                if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefile))) {
                  /* Exec "cancella" Page 6:Page_6 */
                  Page_6();
                } else { // Else
                  /* If At('correzioni.csv',Lower(pnomefile)) <> 0 */
                  if (CPLib.ne(CPLib.At("correzioni.csv",CPLib.Lower(pnomefile)),0)) {
                    /* nomefileoutput := Left(pnomefile,7)+'_correzioni_out.xlsx' // nome file risultati */
                    nomefileoutput = CPLib.Left(pnomefile,7)+"_correzioni_out.xlsx";
                    /* Exec "modificheCSV" Page 7:Page_7 */
                    Page_7();
                  } else { // Else
                    /* Error Msg 'Apertura file Excel non riuscita. ' */
                    m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Apertura file Excel non riuscita. ");
                    new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
                  } // End If
                } // End If
              } // End If
            } // End If
          } // End If
        } // End If
        /* ElseIf pselezione='M' */
      } else if (CPLib.eqr(pselezione,"M")) {
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
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_import_file_xlsx_esterni: query on anadip returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_import_file_xlsx_esterni: query on tbcitta returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
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
        // * --- Drop temporary table tmp_list_imprich
        if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
            m_cServer = m_Ctx.GetServer("tmp_list_imprich");
            m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_list_imprich");
        }
        // * --- Create temporary table tmp_list_imprich
        if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
            m_cServer = m_Ctx.GetServer("tmp_list_imprich");
            m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_list_imprich");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_list_imprich");
        if ( ! (m_Ctx.IsSharedTemp("tmp_list_imprich"))) {
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_list_imprich",m_cServer,"proto")),m_cPhName,"tmp_list_imprich",m_Ctx);
        }
        m_cPhName_tmp_list_imprich = m_cPhName;
        // Legge i file
        File di = new File(CPLib.LRTrim(gPathApp+"/appo/"+CPLib.LRTrim(gAzienda)));
        File fl[] = di.listFiles();
        int _i;
        int count=0;
        for (_i=0; _i < fl.length; _i++)  {
        /* If At('correzioni.csv',Lower(fl[_i].getName())) <> 0 */
        if (CPLib.ne(CPLib.At("correzioni.csv",CPLib.Lower(fl[_i].getName())),0)) {
          // * --- Insert into tmp_list_imprich from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000000B5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000B5(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(fl[_i].getName()),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
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
        } // End If
        /* } */
        };
        // * --- Select from tmp_list_imprich
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
        Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_list_imprich.Eof())) {
          /* nomefile := LRTrim(tmp_list_imprich->nomefile) */
          nomefile = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
          /* nomefileoutput := Left(nomefile,7)+'_correzioni_out.xlsx' // nome file risultati */
          nomefileoutput = CPLib.Left(nomefile,7)+"_correzioni_out.xlsx";
          /* Exec "modificheCSV" Page 7:Page_7 */
          Page_7();
          // * --- Delete from tmp_list_imprich
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000000BB")+"delete from "+m_oWrInfo.GetTableWriteName();
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
          /* FileLibMit.DeleteFile('appo/'+LRTrim(gAzienda)+'/'+LRTrim(nomefile)) */
          FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomefile));
          Cursor_tmp_list_imprich.Next();
        }
        m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
        Cursor_tmp_list_imprich.Close();
        // * --- End Select
      } else { // Else
        /* Exec "verifica saldi" Page 8:Page_8 */
        Page_8();
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
        if (Cursor_tbcitta!=null)
          Cursor_tbcitta.Close();
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
    CPResultSet Cursor_personbo=null;
    try {
      /* column01 Char(25) // ragsoc */
      String column01;
      column01 = CPLib.Space(25);
      /* column02 Char(25) // connes */
      String column02;
      column02 = CPLib.Space(25);
      /* column03 Char(25) // CF */
      String column03;
      column03 = CPLib.Space(25);
      /* column04 Char(25) // Cognome */
      String column04;
      column04 = CPLib.Space(25);
      /* column05 Char(25) // nome */
      String column05;
      column05 = CPLib.Space(25);
      /* column06 Char(25) // sesso */
      String column06;
      column06 = CPLib.Space(25);
      /* column06num Numeric(1, 0) // sesso numerico */
      double column06num;
      column06num = 0;
      /* column07 Char(25) // data di nascita */
      String column07;
      column07 = CPLib.Space(25);
      /* column07num Numeric(99, 0) // data di nascita numerico */
      double column07num;
      column07num = 0;
      /* column07date Date // data di nascita data */
      java.sql.Date column07date;
      column07date = CPLib.NullDate();
      /* column08 Char(30) // comune di nascita */
      String column08;
      column08 = CPLib.Space(30);
      /* column09 Char(30) // nazione di nascita */
      String column09;
      column09 = CPLib.Space(30);
      /* column10 Char(2) // provincia di nascita */
      String column10;
      column10 = CPLib.Space(2);
      /* column11 Char(2) // provincia di nascita */
      String column11;
      column11 = CPLib.Space(2);
      /* column12 Char(1) // cfestero */
      String column12;
      column12 = CPLib.Space(1);
      /* column12num Numeric(1, 0) // cfestero numerico */
      double column12num;
      column12num = 0;
      /* column13 Char(16) // new connes */
      String column13;
      column13 = CPLib.Space(16);
      /* _commit Bool // ok alla commit */
      boolean _commit;
      _commit = false;
      /* _falied Bool // fallimento scrittura dati */
      boolean _falied;
      _falied = false;
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      double riga_letta;
      riga_letta = 0;
      /* riga_letta_c Char(9) // riga letta del file Excel Character */
      String riga_letta_c;
      riga_letta_c = CPLib.Space(9);
      /* date_base_excel Date // data di base Excel */
      java.sql.Date date_base_excel;
      date_base_excel = CPLib.NullDate();
      /* riga_letta := 0 // riga letta del file Excel */
      riga_letta = CPLib.Round(0,0);
      /* date_base_excel := CharToDate('31/12/1899') // data di base Excel */
      date_base_excel = CPLib.CharToDate("31/12/1899");
      //base
      InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefile));
      XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
      
      conta = wb.getNumberOfSheets();
      
      //XSSFWorkbook test = new XSSFWorkbook(); 
      
      //XSSFSheet sheet = wb.getSheetAt(0);
      XSSFRow row; 
      XSSFCell cell;
      
      XSSFRow row2; 
      XSSFCell cell2;
      
      //Iterator rows = sheet.rowIterator();
      // creo il contenitore dei fogli
      XSSFWorkbook wb2 = new XSSFWorkbook();
      XSSFSheet sheet2 = wb2.createSheet(sheetName) ;
      //Azzero i contatori di fogli letti e righe scritte
      _i = 0;
      r=0;
      //Creo il record da scrivere
      row2 = (XSSFRow) sheet2.createRow(r);
      //scrivo la riga di intestazione
      cell2 = (XSSFCell) row2.createCell(0);
      cell2.setCellValue("Intestatario");
      cell2 = (XSSFCell) row2.createCell(1);
      cell2.setCellValue("Connes");
      cell2 = (XSSFCell) row2.createCell(2);
      cell2.setCellValue("cf reale");
      cell2 = (XSSFCell) row2.createCell(3);
      cell2.setCellValue("Cognome");
      cell2 = (XSSFCell) row2.createCell(4);
      cell2.setCellValue("Nome");
      cell2 = (XSSFCell) row2.createCell(5);
      cell2.setCellValue("Sesso");
      cell2 = (XSSFCell) row2.createCell(6);
      cell2.setCellValue("Data di nascita");
      cell2 = (XSSFCell) row2.createCell(7);
      cell2.setCellValue("Comune di nacita");
      cell2 = (XSSFCell) row2.createCell(8);
      cell2.setCellValue("stato di nascita");
      cell2 = (XSSFCell) row2.createCell(9);
      cell2.setCellValue("Provincia di nascita");
      cell2 = (XSSFCell) row2.createCell(10);
      cell2.setCellValue("Provincia di nascita bis");
      cell2 = (XSSFCell) row2.createCell(11);
      cell2.setCellValue("CF Estero");
      cell2 = (XSSFCell) row2.createCell(12);
      cell2.setCellValue("New connes");
      cell2 = (XSSFCell) row2.createCell(13);
      cell2.setCellValue("Note");
      cell2 = (XSSFCell) row2.createCell(14);
      cell2.setCellValue("Riga");
      r++;
      /* _commit := True // ok alla commit */
      _commit = true;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000DFstatus;
      nTry000000DFstatus = m_Sql.GetTransactionStatus();
      String cTry000000DFmsg;
      cTry000000DFmsg = m_Sql.TransactionErrorMessage();
      try {
        /* While _i < conta */
        while (CPLib.lt(_i,conta)) {
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          //Mi definisco un oggetto che contiene tutte le righe
          Iterator rows = sheet.rowIterator();
          //_righe = sheet.getLastRowNum()+1;
          //_y = 1;
          /* While rows.hasNext() and _commit */
          while (rows.hasNext() && _commit) {
            //scorro le righe
            row=(XSSFRow) rows.next();
            //Mi definisco un oggetto che contiene tutte le celle della riga letta
            Iterator cells = row.cellIterator();
            /* cell_count := 0 */
            cell_count = CPLib.Round(0,0);
            /* riga_letta := riga_letta+1 // riga letta del file Excel */
            riga_letta = CPLib.Round(riga_letta+1,0);
            /* nota := '' // nota del eventuale problema */
            nota = "";
            /* modifica := True // ok alla modifica dei dati */
            modifica = true;
            /* While cells.hasNext() and riga_letta>1 */
            while (cells.hasNext() && CPLib.gt(riga_letta,1)) {
              //scorro le celle della riga
              cell=(XSSFCell) cells.next();
              /* cell_count := cell_count+1 */
              cell_count = CPLib.Round(cell_count+1,0);
              /* cell_type := cell.getCellType().ordinal() */
              cell_type = cell.getCellType().ordinal();
              /* Case cell_type=1 */
              if (CPLib.eqr(cell_type,1)) {
                /* tipo numerico
                   da definire il comportamento */
                /* Case cell_count=6 */
                if (CPLib.eqr(cell_count,6)) {
                  /* column06num := cell.getNumericCellValue() */
                  column06num = CPLib.Round(cell.getNumericCellValue(),0);
                  /* column06 := Str(column06num,1,0) */
                  column06 = CPLib.Str(column06num,1,0);
                  /* Case cell_count=7 */
                } else if (CPLib.eqr(cell_count,7)) {
                  /* Quando la leggeva come numero */
                  /* column07num := cell.getNumericCellValue() */
                  column07num = CPLib.Round(cell.getNumericCellValue(),0);
                  /* column07 := sdf.format(cell.getDateCellValue()) // data di nascita */
                  column07 = sdf.format(cell.getDateCellValue());
                  /* Case cell_count=12 */
                } else if (CPLib.eqr(cell_count,12)) {
                  /* column12num := cell.getNumericCellValue() // cfestero numerico */
                  column12num = CPLib.Round(cell.getNumericCellValue(),0);
                  /* column12 := Str(column12num,1,0) // cfestero */
                  column12 = CPLib.Str(column12num,1,0);
                } else { // Otherwise
                  /* nota := iif(Empty(nota),'Valore numerico alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore numerico alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore numerico alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore numerico alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                  /* _commit := False // ok alla commit */
                  _commit = false;
                } // End Case
                /* Case cell_type=2 */
              } else if (CPLib.eqr(cell_type,2)) {
                /* Case cell_count=1 */
                if (CPLib.eqr(cell_count,1)) {
                  /* column01 := cell.getStringCellValue() // ragsoc */
                  column01 = cell.getStringCellValue();
                  /* Case cell_count=2 */
                } else if (CPLib.eqr(cell_count,2)) {
                  /* column02 := cell.getStringCellValue() // connes */
                  column02 = cell.getStringCellValue();
                  /* Case cell_count=3 */
                } else if (CPLib.eqr(cell_count,3)) {
                  /* column03 := cell.getStringCellValue() // CF */
                  column03 = cell.getStringCellValue();
                  /* Case cell_count=4 */
                } else if (CPLib.eqr(cell_count,4)) {
                  /* column04 := cell.getStringCellValue() // Cognome */
                  column04 = cell.getStringCellValue();
                  /* Case cell_count=5 */
                } else if (CPLib.eqr(cell_count,5)) {
                  /* column05 := cell.getStringCellValue() // nome */
                  column05 = cell.getStringCellValue();
                  /* Case cell_count=6 */
                } else if (CPLib.eqr(cell_count,6)) {
                  /* column06 := cell.getStringCellValue() // sesso */
                  column06 = cell.getStringCellValue();
                  /* Case cell_count=7 */
                } else if (CPLib.eqr(cell_count,7)) {
                  /* column07 := cell.getStringCellValue() // data di nascita */
                  column07 = cell.getStringCellValue();
                  /* Case cell_count=8 */
                } else if (CPLib.eqr(cell_count,8)) {
                  /* column08 := cell.getStringCellValue() // comune di nascita */
                  column08 = cell.getStringCellValue();
                  /* Case cell_count=9 */
                } else if (CPLib.eqr(cell_count,9)) {
                  /* column09 := cell.getStringCellValue() // nazione di nascita */
                  column09 = cell.getStringCellValue();
                  /* Case cell_count=10 */
                } else if (CPLib.eqr(cell_count,10)) {
                  /* column10 := cell.getStringCellValue() // provincia di nascita */
                  column10 = cell.getStringCellValue();
                  /* Case cell_count=11 */
                } else if (CPLib.eqr(cell_count,11)) {
                  /* column11 := cell.getStringCellValue() // provincia di nascita */
                  column11 = cell.getStringCellValue();
                  /* Case cell_count=12 */
                } else if (CPLib.eqr(cell_count,12)) {
                  /* column12 := cell.getStringCellValue() // cfestero */
                  column12 = cell.getStringCellValue();
                  /* Case cell_count=13 */
                } else if (CPLib.eqr(cell_count,13)) {
                  /* column13 := cell.getStringCellValue() // new connes */
                  column13 = cell.getStringCellValue();
                  /* If not(Empty(LRTrim(column02))) */
                  if ( ! (CPLib.Empty(CPLib.LRTrim(column02)))) {
                    /* If modifica */
                    if (modifica) {
                      /* If LRTrim(column02)=LRTrim(column13) */
                      if (CPLib.eqr(CPLib.LRTrim(column02),CPLib.LRTrim(column13))) {
                        // * --- Select from personbo
                        m_cServer = m_Ctx.GetServer("personbo");
                        m_cPhName = m_Ctx.GetPhName("personbo");
                        if (Cursor_personbo!=null)
                          Cursor_personbo.Close();
                        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LTrim(column02),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LTrim(column02))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                        {
                          final CPResultSet m_TheCursor = Cursor_personbo;
                          Cursor_personbo.ActionOnClose(new Runnable() {
                            public void run() {
                              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1*1.1)) {
                                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                                if ( ! (CPLib.IsNull(info))) {
                                  info.log("Routine arrt_import_file_xlsx_esterni: query on personbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1");
                                }
                              }
                            }
                            });
                        }
                        if ( ! (Cursor_personbo.Eof())) {
                          while ( ! (Cursor_personbo.Eof())) {
                            /* _falied := False // fallimento scrittura dati */
                            _falied = false;
                            /* Case Empty(column10) and Empty(column11) */
                            if (CPLib.Empty(column10) && CPLib.Empty(column11)) {
                              /* If Empty(column08) */
                              if (CPLib.Empty(column08)) {
                                /* column10 := 'EE' // provincia di nascita */
                                column10 = "EE";
                              } else { // Else
                                /* nota := iif(Empty(nota),'Provincia di nascita non valorizzata',nota+' provincia di nascita non valorizzata') // nota del eventuale problema */
                                nota = (CPLib.Empty(nota)?"Provincia di nascita non valorizzata":nota+" provincia di nascita non valorizzata");
                                /* _commit := False // ok alla commit */
                                _commit = false;
                              } // End If
                              /* Case Empty(column10) and not(Empty(column11)) */
                            } else if (CPLib.Empty(column10) &&  ! (CPLib.Empty(column11))) {
                              /* column10 := column11 // provincia di nascita */
                              column10 = column11;
                              /* column11 := '' // provincia di nascita */
                              column11 = "";
                              /* Case not(Empty(column10)) and not(Empty(column11)) */
                            } else if ( ! (CPLib.Empty(column10)) &&  ! (CPLib.Empty(column11))) {
                              /* nota := iif(Empty(nota),'Provincia di nascita valorizzata in entrambi i campi',nota+' provincia di nascita valorizzata in entrambi i campi') // nota del eventuale problema */
                              nota = (CPLib.Empty(nota)?"Provincia di nascita valorizzata in entrambi i campi":nota+" provincia di nascita valorizzata in entrambi i campi");
                              /* _commit := False // ok alla commit */
                              _commit = false;
                            } else { // Otherwise
                              /* If Empty(column10) */
                              if (CPLib.Empty(column10)) {
                                /* nota := iif(Empty(nota),'Provincia di nascita non regolare',nota+' provincia di nascita non regolare') // nota del eventuale problema */
                                nota = (CPLib.Empty(nota)?"Provincia di nascita non regolare":nota+" provincia di nascita non regolare");
                                /* _commit := False // ok alla commit */
                                _commit = false;
                              } // End If
                            } // End Case
                            // * --- Write into personbo from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("personbo");
                            m_cPhName = m_Ctx.GetPhName("personbo");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000117")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                            m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(column01,"C",70,0,m_cServer)+", ";
                            m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.eqr(column03,"CFESTERO")?Cursor_personbo.GetString("CODFISC"):CPLib.LRTrim(column03)),"C",16,0,m_cServer)+", ";
                            m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(column04),"C",26,0,m_cServer)+", ";
                            m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(column05),"C",25,0,m_cServer)+", ";
                            m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column06),"M")?"1":(CPLib.eqr(CPLib.LRTrim(column06),"F")?"2":CPLib.LRTrim(column06))),"C",1,0,m_cServer)+", ";
                            m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column08),"NOCOMU")?Cursor_personbo.GetString("NASCOMUN"):CPLib.LRTrim(column08)),"C",30,0,m_cServer)+", ";
                            m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column09),"NOSTATO")?Cursor_personbo.GetString("NASSTATO"):CPLib.LRTrim(column09)),"C",30,0,m_cServer)+", ";
                            m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.LRTrim(column10),"C",2,0,m_cServer)+", ";
                            m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.eqr(column12,"1")?1:0),"N",1,0)+", ";
                            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                            m_cSql = m_cSql+" where ";
                            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
                            m_cSql = m_cSql+" and CODFISC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CODFISC"))+"";
                            m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                            {
                              if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                                if ( ! (CPLib.IsNull(info))) {
                                  info.log("Routine arrt_import_file_xlsx_esterni: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                                }
                              }
                            }
                            if (CPLib.lt(m_nUpdatedRows,0)) {
                              m_nUpdatedRows = 0;
                            }
                            m_Sql.CompleteTransaction();
                            m_cLastMsgError = m_Sql.TransactionErrorMessage();
                            if (CPLib.lt(m_nUpdatedRows,1)) {
                              // No rows updated
                              /* _falied := True // fallimento scrittura dati */
                              _falied = true;
                            } else if (CPLib.ne(m_cLastMsgError,"")) {
                              m_bError = true;
                              throw new RoutineException();
                            }
                            /* If _falied */
                            if (_falied) {
                              /* nota := iif(Empty(nota),'Soggetto trovato. Errore nella modifica',nota+' soggetto trovato. Errore nella modifica') // nota del eventuale problema */
                              nota = (CPLib.Empty(nota)?"Soggetto trovato. Errore nella modifica":nota+" soggetto trovato. Errore nella modifica");
                            } else { // Else
                              /* nota := iif(Empty(nota),'Soggetto trovato e modificato',nota+' soggetto trovato e modificato') // nota del eventuale problema */
                              nota = (CPLib.Empty(nota)?"Soggetto trovato e modificato":nota+" soggetto trovato e modificato");
                              /* nota := nota+'. '+iif(LRTrim(column02)<>LRTrim(column03),'Codici fiscali diversi','Codici fiscali uguali') // nota del eventuale problema */
                              nota = nota+". "+(CPLib.ne(CPLib.LRTrim(column02),CPLib.LRTrim(column03))?"Codici fiscali diversi":"Codici fiscali uguali");
                            } // End If
                            Cursor_personbo.Next();
                          }
                          m_cConnectivityError = Cursor_personbo.ErrorMessage();
                        } else {
                          // No rows selected
                          /* nota := iif(Empty(nota),'Soggetto ricercato non trovato in anagrafica',nota+' soggetto ricercato non trovato in anagrafica') // nota del eventuale problema */
                          nota = (CPLib.Empty(nota)?"Soggetto ricercato non trovato in anagrafica":nota+" soggetto ricercato non trovato in anagrafica");
                        }
                        Cursor_personbo.Close();
                        // * --- End Select
                      } else { // Else
                        /* nota := iif(Empty(nota),'Soggetto Eliminato  per accorpamento.',nota+' Soggetto Eliminato per accorpamento.') // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Soggetto Eliminato  per accorpamento.":nota+" Soggetto Eliminato per accorpamento.");
                        /* If not(Page_3(LRTrim(column02),LRTrim(column13),False)) */
                        if ( ! (Page_3(CPLib.LRTrim(column02),CPLib.LRTrim(column13),false))) {
                          /* _commit := False // ok alla commit */
                          _commit = false;
                        } // End If
                      } // End If
                    } // End If
                  } else { // Else
                    /* nota := iif(Empty(nota),'Connes vuoto',nota+' Connes vuoto') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Connes vuoto":nota+" Connes vuoto");
                  } // End If
                } // End Case
                /* Case cell_type=0 */
              } else if (CPLib.eqr(cell_type,0)) {
                /* tipo buleano
                   da definire il comportamento
                   non è booleanao è tipo formula da vedere */
                /* nota := iif(Empty(nota),'Valore buleano alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore buleano alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                nota = (CPLib.Empty(nota)?"Valore buleano alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore buleano alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                /* _commit := False // ok alla commit */
                _commit = false;
                /* Case cell_type=3 */
              } else if (CPLib.eqr(cell_type,3)) {
                /* Case cell_count=3 */
                if (CPLib.eqr(cell_count,3)) {
                  /* column03 := 'CFESTERO' // CF */
                  column03 = "CFESTERO";
                  /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)') // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)");
                  /* Case cell_count=8 */
                } else if (CPLib.eqr(cell_count,8)) {
                  /* column08 := 'NOCOMU' // comune di nascita */
                  column08 = "NOCOMU";
                  /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (comune vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (comune vuoto)') // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (comune vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (comune vuoto)");
                  /* Case cell_count=9 */
                } else if (CPLib.eqr(cell_count,9)) {
                  /* column09 := 'NOSTATO' // nazione di nascita */
                  column09 = "NOSTATO";
                  /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (stato vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (stato vuoto)') // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (stato vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (stato vuoto)");
                  /* Case cell_count=10 */
                } else if (CPLib.eqr(cell_count,10)) {
                  /* column10 := '' // provincia di nascita */
                  column10 = "";
                  /* Case cell_count=11 */
                } else if (CPLib.eqr(cell_count,11)) {
                  /* column11 := '' // provincia di nascita */
                  column11 = "";
                } else { // Otherwise
                  /* nota := iif(Empty(nota),'Valore vuoto alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore vuoto alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore vuoto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore vuoto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                  /* If cell_count<14 */
                  if (CPLib.lt(cell_count,14)) {
                    /* _commit := False // ok alla commit */
                    _commit = false;
                  } // End If
                } // End Case
              } else { // Otherwise
                /* If cell_count=3 */
                if (CPLib.eqr(cell_count,3)) {
                  /* column03 := 'CFESTERO' */
                  column03 = "CFESTERO";
                  /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' Rimessa spunta cfestero',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' Rimessa spunta cfestero') // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" Rimessa spunta cfestero":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" Rimessa spunta cfestero");
                } else { // Else
                  /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                  /* _commit := False // ok alla commit */
                  _commit = false;
                } // End If
              } // End Case
            } // End While
            /* If riga_letta>1 */
            if (CPLib.gt(riga_letta,1)) {
              /* riga_letta_c := Str(riga_letta,9,0) */
              riga_letta_c = CPLib.Str(riga_letta,9,0);
              //Creo il record da scrivere
              row2 = (XSSFRow) sheet2.createRow(r);
              cell2 = (XSSFCell) row2.createCell(0);
              cell2.setCellValue(CPLib.LRTrim(column01));
              cell2 = (XSSFCell) row2.createCell(1);
              cell2.setCellValue(CPLib.LRTrim(column02));
              cell2 = (XSSFCell) row2.createCell(2);
              cell2.setCellValue(CPLib.LRTrim(column03));
              cell2 = (XSSFCell) row2.createCell(3);
              cell2.setCellValue(CPLib.LRTrim(column04));
              cell2 = (XSSFCell) row2.createCell(4);
              cell2.setCellValue(CPLib.LRTrim(column05));
              cell2 = (XSSFCell) row2.createCell(5);
              cell2.setCellValue(CPLib.LRTrim(column06));
              cell2 = (XSSFCell) row2.createCell(6);
              cell2.setCellValue(CPLib.LRTrim(column07));
              cell2 = (XSSFCell) row2.createCell(7);
              cell2.setCellValue(CPLib.LRTrim(column08));
              cell2 = (XSSFCell) row2.createCell(8);
              cell2.setCellValue(CPLib.LRTrim(column09));
              cell2 = (XSSFCell) row2.createCell(9);
              cell2.setCellValue(CPLib.LRTrim(column10));
              cell2 = (XSSFCell) row2.createCell(10);
              cell2.setCellValue(CPLib.LRTrim(column11));
              cell2 = (XSSFCell) row2.createCell(11);
              cell2.setCellValue(CPLib.LRTrim(column12));
              cell2 = (XSSFCell) row2.createCell(12);
              cell2.setCellValue(CPLib.LRTrim(column13));
              cell2 = (XSSFCell) row2.createCell(13);
              cell2.setCellValue(CPLib.LRTrim(nota));
              cell2 = (XSSFCell) row2.createCell(14);
              cell2.setCellValue(CPLib.LRTrim(riga_letta_c));
              r++;
            } // End If
          } // End While
          _i++;
        } // End While
        /* If _commit */
        if (_commit) {
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } else { // Else
          // Transaction Error
          cTry000000DFmsg = CPLib.FormatMsg(m_Ctx,"errore xlsx");
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore xlsx"));
        } // End If
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000DFstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000000DFstatus,cTry000000DFmsg);
        }
      }
      //Ridimensiono le colonne in base al contenuto
      sheet2.autoSizeColumn(0);
      sheet2.autoSizeColumn(1);
      sheet2.autoSizeColumn(2);
      sheet2.autoSizeColumn(3);
      sheet2.autoSizeColumn(4);
      sheet2.autoSizeColumn(5);
      sheet2.autoSizeColumn(6);
      sheet2.autoSizeColumn(7);
      sheet2.autoSizeColumn(8);
      sheet2.autoSizeColumn(9);
      sheet2.autoSizeColumn(10);
      sheet2.autoSizeColumn(11);
      sheet2.autoSizeColumn(12);
      sheet2.autoSizeColumn(13);
      sheet2.autoSizeColumn(14);
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefileoutput));
      
      //write this workbook to an Outputstream.
      wb2.write(fileOut);
      fileOut.flush();
      fileOut.close();
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  boolean Page_3(String w_oldcon,String w_newcon,boolean flag_modifica) throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_opextrbo=null;
    try {
      /* w_oldcon Char(16) // vecchio connes */
      /* w_newcon Char(16) // new connes */
      /* flag_modifica Bool // flag per sapere se è una modifica del connes o un accorpamento */
      /* opextrbo_new_connes MemoryCursor(opextrbo) // operazioni del nuovo connes */
      MemoryCursor_opextrbo opextrbo_new_connes;
      opextrbo_new_connes = new MemoryCursor_opextrbo();
      /* _connes Char(16) // connes del soggetto */
      String _connes;
      _connes = CPLib.Space(16);
      /* Dichiarazione variabili globali */
      /* Verifica se il nuovo codice esiste già */
      /* gMsgImp := 'Inizio Aggiornamento Soggetto e relativi collegamenti' // Messaggio Import */
      gMsgImp = "Inizio Aggiornamento Soggetto e relativi collegamenti";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _connes := '' // connes del soggetto */
      _connes = "";
      // * --- Read from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      m_cSql = "";
      m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_newcon,"C",16,0,m_cServer),m_cServer,w_newcon);
      if (m_Ctx.IsSharedTemp("personbo")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _connes = Read_Cursor.GetString("CONNES");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_file_xlsx_esterni returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _connes = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If flag_modifica */
      if (flag_modifica) {
        /* gMsgImp := 'Crea Nuovo record personbo' // Messaggio Import */
        gMsgImp = "Crea Nuovo record personbo";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(_connes) */
        if (CPLib.Empty(_connes)) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldcon)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            // * --- Insert into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000150")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000150(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_newcon,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
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
            }
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          // * --- Select from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          if (Cursor_opextrbo!=null)
            Cursor_opextrbo.Close();
          Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldcon)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_opextrbo.Eof())) {
            // * --- Insert into opextrbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000152")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000152(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_newcon,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("ANNO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("COINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("NOTE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("PROGOPEX"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("SALDO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("QUANTITA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
            Cursor_opextrbo.Next();
          }
          m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
          Cursor_opextrbo.Close();
          // * --- End Select
          /* gMsgImp := 'Aggiorna wersonbo' // Messaggio Import */
          gMsgImp = "Aggiorna wersonbo";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into wersonbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wersonbo");
          m_cPhName = m_Ctx.GetPhName("wersonbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000154")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CONNES = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wersonbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
        } else { // Else
          // Transaction Error
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'Soggetto con new connes: %1 trovato'",w_newcon));
          /* Page Return False */
          return false;
        } // End If
      } else { // Else
        /* If Empty(_connes) */
        if (CPLib.Empty(_connes)) {
          // Transaction Error
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'Soggetto con new connes: %1 non trovato'",w_newcon));
          /* Page Return False */
          return false;
        } // End If
        /* Prendo le operazioni del nuovo conne ordinate per anno e genero la key sulla base del ANNO */
        // * --- Fill memory cursor opextrbo_new_connes on opextrbo
        opextrbo_new_connes.Zap();
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
        Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select COLLEG,ANNO,IDBASE,DATAOPE,COINT,NOTE,NUMPROG1,RIFIMP,IDFILE,PROGOPEX,SALDO,QUANTITA,VALUTA  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_newcon,"?",0,0,m_cServer, m_oParameters),m_cServer,w_newcon)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"ANNO ",m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_opextrbo;
          Cursor_opextrbo.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_import_file_xlsx_esterni: query on opextrbo returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_opextrbo.Eof())) {
          opextrbo_new_connes.AppendWithTrimmedKey(Cursor_opextrbo.GetString("ANNO"));
          opextrbo_new_connes.row.COLLEG = Cursor_opextrbo.GetString("COLLEG");
          opextrbo_new_connes.row.ANNO = Cursor_opextrbo.GetString("ANNO");
          opextrbo_new_connes.row.IDBASE = Cursor_opextrbo.GetString("IDBASE");
          opextrbo_new_connes.row.DATAOPE = Cursor_opextrbo.GetDate("DATAOPE");
          opextrbo_new_connes.row.COINT = Cursor_opextrbo.GetString("COINT");
          opextrbo_new_connes.row.NOTE = Cursor_opextrbo.GetString("NOTE");
          opextrbo_new_connes.row.NUMPROG1 = Cursor_opextrbo.GetString("NUMPROG1");
          opextrbo_new_connes.row.RIFIMP = Cursor_opextrbo.GetString("RIFIMP");
          opextrbo_new_connes.row.IDFILE = Cursor_opextrbo.GetString("IDFILE");
          opextrbo_new_connes.row.PROGOPEX = Cursor_opextrbo.GetDouble("PROGOPEX");
          opextrbo_new_connes.row.SALDO = Cursor_opextrbo.GetDouble("SALDO");
          opextrbo_new_connes.row.QUANTITA = Cursor_opextrbo.GetDouble("QUANTITA");
          opextrbo_new_connes.row.VALUTA = Cursor_opextrbo.GetString("VALUTA");
          opextrbo_new_connes.row.UNIQUER = Cursor_opextrbo.GetString("UNIQUER");
          opextrbo_new_connes.row.CODINTER = Cursor_opextrbo.GetString("CODINTER");
          opextrbo_new_connes.row.OLDINTER = Cursor_opextrbo.GetString("OLDINTER");
          opextrbo_new_connes.row.DATAMODI = Cursor_opextrbo.GetDate("DATAMODI");
          opextrbo_new_connes.row.INVIATO = Cursor_opextrbo.GetDouble("INVIATO");
          opextrbo_new_connes.row.DATAINVIO = Cursor_opextrbo.GetDate("DATAINVIO");
          opextrbo_new_connes.row.ANNULLA = Cursor_opextrbo.GetDouble("ANNULLA");
          opextrbo_new_connes.row.DATAANNU = Cursor_opextrbo.GetDate("DATAANNU");
          opextrbo_new_connes.row.OLDUNIQUE = Cursor_opextrbo.GetString("OLDUNIQUE");
          opextrbo_new_connes.row.DATAOLDUNI = Cursor_opextrbo.GetDate("DATAOLDUNI");
          opextrbo_new_connes.row.IDESITO = Cursor_opextrbo.GetString("IDESITO");
          opextrbo_new_connes.row.CONNESOPER = Cursor_opextrbo.GetString("CONNESOPER");
          opextrbo_new_connes.row.RAPPORTO = Cursor_opextrbo.GetString("RAPPORTO");
          opextrbo_new_connes.row.INVSALDO = Cursor_opextrbo.GetDouble("INVSALDO");
          opextrbo_new_connes.row.DTSALDO = Cursor_opextrbo.GetDate("DTSALDO");
          opextrbo_new_connes.row.CFESTERO = Cursor_opextrbo.GetString("CFESTERO");
          opextrbo_new_connes.row.INFORM = Cursor_opextrbo.GetString("INFORM");
          opextrbo_new_connes.row.NATURA = Cursor_opextrbo.GetString("NATURA");
          opextrbo_new_connes.row.FLGNOE = Cursor_opextrbo.GetString("FLGNOE");
          Cursor_opextrbo.Next();
        }
        m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
        Cursor_opextrbo.Close();
        opextrbo_new_connes.GoTop();
        /* If opextrbo_new_connes.RecCount()>0 */
        if (CPLib.gt(opextrbo_new_connes.RecCount(),0)) {
          /* Giro le operazioni del vecchio connes per verificare se sono da sostituire a quelle già presenti sull'anagrafica */
          // * --- Select from opextrbo
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          if (Cursor_opextrbo!=null)
            Cursor_opextrbo.Close();
          Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldcon)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"ANNO ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_opextrbo.Eof())) {
            /* Se non la trovo con la key, vuol dire che non ho operazioni con il nuovo connes, quindi riporto quella pressa dal vecchio */
            /* If opextrbo_new_connes.GoToKey(opextrbo->ANNO) */
            if (opextrbo_new_connes.GoToKey(Cursor_opextrbo.GetString("ANNO"))) {
              /* Se l'operazione con il vecchio connes è più vecchia di quella con il nuovo la sostituisco */
              /* If opextrbo_new_connes.DATAOPE>opextrbo->DATAOPE */
              if (CPLib.gt(opextrbo_new_connes.row.DATAOPE,Cursor_opextrbo.GetDate("DATAOPE"))) {
                // * --- Delete from opextrbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000163")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(opextrbo_new_connes.row.COLLEG,"?",0,0,m_cServer),m_cServer,opextrbo_new_connes.row.COLLEG)+"";
                m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(opextrbo_new_connes.row.ANNO,"?",0,0,m_cServer),m_cServer,opextrbo_new_connes.row.ANNO)+"";
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
                // * --- Insert into opextrbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000164")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000164(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_newcon,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("ANNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("COINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("NOTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("PROGOPEX"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("SALDO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("QUANTITA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
            } else { // Else
              // * --- Insert into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000165")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000165(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_newcon,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("ANNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("NOTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("NUMPROG1"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("PROGOPEX"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("SALDO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetDouble("QUANTITA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_opextrbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
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
            Cursor_opextrbo.Next();
          }
          m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
          Cursor_opextrbo.Close();
          // * --- End Select
        } // End If
      } // End If
      /* gMsgImp := 'Aggiorna operazbo' // Messaggio Import */
      gMsgImp = "Aggiorna operazbo";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into operazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000167")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into operazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000168")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into operazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000169")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into operazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("operazbo");
      m_cPhName = m_Ctx.GetPhName("operazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000016A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNALTRO = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNALTRO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into clientiope from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("clientiope");
      m_cPhName = m_Ctx.GetPhName("clientiope");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientiope",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000016B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"clientiope",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into beneficope from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("beneficope");
      m_cPhName = m_Ctx.GetPhName("beneficope");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficope",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000016C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"beneficope",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into sogopebo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sogopebo");
      m_cPhName = m_Ctx.GetPhName("sogopebo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopebo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000016D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sogopebo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into terzistiope from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("terzistiope");
      m_cPhName = m_Ctx.GetPhName("terzistiope");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistiope",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000016E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"terzistiope",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna fraziobo' // Messaggio Import */
      gMsgImp = "Aggiorna fraziobo";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into fraziobo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("fraziobo");
      m_cPhName = m_Ctx.GetPhName("fraziobo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000170")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into fraziobo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("fraziobo");
      m_cPhName = m_Ctx.GetPhName("fraziobo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000171")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into fraziobo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("fraziobo");
      m_cPhName = m_Ctx.GetPhName("fraziobo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000172")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into fraziobo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("fraziobo");
      m_cPhName = m_Ctx.GetPhName("fraziobo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000173")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNALTRO = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNALTRO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into clientifrz from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("clientifrz");
      m_cPhName = m_Ctx.GetPhName("clientifrz");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"clientifrz",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000174")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"clientifrz",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into beneficfrz from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("beneficfrz");
      m_cPhName = m_Ctx.GetPhName("beneficfrz");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"beneficfrz",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000175")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"beneficfrz",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into sogopefbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sogopefbo");
      m_cPhName = m_Ctx.GetPhName("sogopefbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sogopefbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000176")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"sogopefbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into terzistifrz from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("terzistifrz");
      m_cPhName = m_Ctx.GetPhName("terzistifrz");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"terzistifrz",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000177")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"terzistifrz",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna xperazbo' // Messaggio Import */
      gMsgImp = "Aggiorna xperazbo";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into xperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xperazbo");
      m_cPhName = m_Ctx.GetPhName("xperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000179")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xperazbo");
      m_cPhName = m_Ctx.GetPhName("xperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000017A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xperazbo");
      m_cPhName = m_Ctx.GetPhName("xperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000017B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xperazbo");
      m_cPhName = m_Ctx.GetPhName("xperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000017C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNALTRO = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNALTRO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xlientiope from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xlientiope");
      m_cPhName = m_Ctx.GetPhName("xlientiope");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000017D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xlientiope",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xeneficope from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xeneficope");
      m_cPhName = m_Ctx.GetPhName("xeneficope");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficope",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000017E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xeneficope",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xogopebo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xogopebo");
      m_cPhName = m_Ctx.GetPhName("xogopebo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopebo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000017F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xogopebo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xerzistiope from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xerzistiope");
      m_cPhName = m_Ctx.GetPhName("xerzistiope");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistiope",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000180")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xerzistiope",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna xraziobo' // Messaggio Import */
      gMsgImp = "Aggiorna xraziobo";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into xraziobo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xraziobo");
      m_cPhName = m_Ctx.GetPhName("xraziobo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000182")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xraziobo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xraziobo");
      m_cPhName = m_Ctx.GetPhName("xraziobo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000183")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xraziobo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xraziobo");
      m_cPhName = m_Ctx.GetPhName("xraziobo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000184")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xraziobo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xraziobo");
      m_cPhName = m_Ctx.GetPhName("xraziobo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000185")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNALTRO = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xraziobo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNALTRO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xlientifrz from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xlientifrz");
      m_cPhName = m_Ctx.GetPhName("xlientifrz");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000186")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xlientifrz",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xeneficfrz from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xeneficfrz");
      m_cPhName = m_Ctx.GetPhName("xeneficfrz");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficfrz",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000187")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xeneficfrz",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xogopefbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xogopefbo");
      m_cPhName = m_Ctx.GetPhName("xogopefbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopefbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000188")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xogopefbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xerzistifrz from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xerzistifrz");
      m_cPhName = m_Ctx.GetPhName("xerzistifrz");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistifrz",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000189")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODSOG = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xerzistifrz",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODSOG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna rapporti AUI' // Messaggio Import */
      gMsgImp = "Aggiorna rapporti AUI";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into intestbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intestbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000018B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intestbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into delegabo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("delegabo");
      m_cPhName = m_Ctx.GetPhName("delegabo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"delegabo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000018C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"delegabo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into rapopebo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("rapopebo");
      m_cPhName = m_Ctx.GetPhName("rapopebo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000018D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna rapporti provvisori' // Messaggio Import */
      gMsgImp = "Aggiorna rapporti provvisori";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into xntestbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xntestbo");
      m_cPhName = m_Ctx.GetPhName("xntestbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000018F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xntestbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xelegabo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xelegabo");
      m_cPhName = m_Ctx.GetPhName("xelegabo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xelegabo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000190")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xelegabo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xapopebo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xapopebo");
      m_cPhName = m_Ctx.GetPhName("xapopebo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000191")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapopebo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna Titolari AUI' // Messaggio Import */
      gMsgImp = "Aggiorna Titolari AUI";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into rapotit from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("rapotit");
      m_cPhName = m_Ctx.GetPhName("rapotit");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000193")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapotit",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into rapotit from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("rapotit");
      m_cPhName = m_Ctx.GetPhName("rapotit");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapotit",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000194")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapotit",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna Titolari provvisori' // Messaggio Import */
      gMsgImp = "Aggiorna Titolari provvisori";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into xapotit from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xapotit");
      m_cPhName = m_Ctx.GetPhName("xapotit");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapotit",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000196")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapotit",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into xapotit from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("xapotit");
      m_cPhName = m_Ctx.GetPhName("xapotit");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapotit",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000197")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"xapotit",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna AGE' // Messaggio Import */
      gMsgImp = "Aggiorna AGE";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into jntestbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("jntestbo");
      m_cPhName = m_Ctx.GetPhName("jntestbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jntestbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000199")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jntestbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into jelegabo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("jelegabo");
      m_cPhName = m_Ctx.GetPhName("jelegabo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jelegabo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000019A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jelegabo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into japopebo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("japopebo");
      m_cPhName = m_Ctx.GetPhName("japopebo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"japopebo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000019B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"japopebo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into jperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("jperazbo");
      m_cPhName = m_Ctx.GetPhName("jperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000019C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into jperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("jperazbo");
      m_cPhName = m_Ctx.GetPhName("jperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000019D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into jperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("jperazbo");
      m_cPhName = m_Ctx.GetPhName("jperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"jperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000019E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna Operazioni Società Quotate' // Messaggio Import */
      gMsgImp = "Aggiorna Operazioni Società Quotate";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into kperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("kperazbo");
      m_cPhName = m_Ctx.GetPhName("kperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000001A0")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into kperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("kperazbo");
      m_cPhName = m_Ctx.GetPhName("kperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000001A1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESOPER = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESOPER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Write into kperazbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("kperazbo");
      m_cPhName = m_Ctx.GetPhName("kperazbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"kperazbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000001A2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESBEN = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"kperazbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESBEN = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna aerighe' // Messaggio Import */
      gMsgImp = "Aggiorna aerighe";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into aerighe from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000001A4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQLNull(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna aeoprig' // Messaggio Import */
      gMsgImp = "Aggiorna aeoprig";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into aeoprig from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000001A6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Aggiorna aederig' // Messaggio Import */
      gMsgImp = "Aggiorna aederig";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Write into aederig from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000001A8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(w_newcon,"C",16,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNESINT = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Cancella vecchia scheda' // Messaggio Import */
      gMsgImp = "Cancella vecchia scheda";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Delete from opextrbo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("opextrbo");
      m_cPhName = m_Ctx.GetPhName("opextrbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000001AA")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      // * --- Delete from personbo
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000001AB")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldcon,"?",0,0,m_cServer),m_cServer,w_oldcon)+"";
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
      /* gMsgImp := 'Elaborazione completata' // Messaggio Import */
      gMsgImp = "Elaborazione completata";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Page Return True  */
      return true;
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
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_aeoprig=null;
    CPResultSet Read_Cursor=null;
    try {
      /* column01 Char(25) // ragsoc */
      String column01;
      column01 = CPLib.Space(25);
      /* column02 Char(25) // connes */
      String column02;
      column02 = CPLib.Space(25);
      /* column03 Char(25) // CF */
      String column03;
      column03 = CPLib.Space(25);
      /* column04 Char(25) // Cognome */
      String column04;
      column04 = CPLib.Space(25);
      /* column05 Char(25) // nome */
      String column05;
      column05 = CPLib.Space(25);
      /* column06 Char(25) // sesso */
      String column06;
      column06 = CPLib.Space(25);
      /* column06num Numeric(1, 0) // sesso numerico */
      double column06num;
      column06num = 0;
      /* column07 Char(25) // data di nascita */
      String column07;
      column07 = CPLib.Space(25);
      /* column07num Numeric(99, 0) // data di nascita numerico */
      double column07num;
      column07num = 0;
      /* column07date Date // data di nascita data */
      java.sql.Date column07date;
      column07date = CPLib.NullDate();
      /* column08 Char(30) // comune di nascita */
      String column08;
      column08 = CPLib.Space(30);
      /* column09 Char(30) // nazione di nascita */
      String column09;
      column09 = CPLib.Space(30);
      /* column10 Char(2) // provincia di nascita */
      String column10;
      column10 = CPLib.Space(2);
      /* column11 Char(2) // provincia di nascita */
      String column11;
      column11 = CPLib.Space(2);
      /* column12 Char(1) // cfestero */
      String column12;
      column12 = CPLib.Space(1);
      /* column12num Numeric(1, 0) // cfestero numerico */
      double column12num;
      column12num = 0;
      /* column13 Char(16) // Descrizione */
      String column13;
      column13 = CPLib.Space(16);
      /* column14num Numeric(15, 0) // Afile */
      double column14num;
      column14num = 0;
      /* column14 Char(15) // Afile */
      String column14;
      column14 = CPLib.Space(15);
      /* column15num Numeric(25, 0) // Aprog */
      double column15num;
      column15num = 0;
      /* column15 Char(25) // Aprog */
      String column15;
      column15 = CPLib.Space(25);
      /* column16 Char(8) // Idesito */
      String column16;
      column16 = CPLib.Space(8);
      /* _commit Bool // ok alla commit */
      boolean _commit;
      _commit = false;
      /* _falied Bool // fallimento scrittura dati */
      boolean _falied;
      _falied = false;
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      double riga_letta;
      riga_letta = 0;
      /* riga_letta_c Char(9) // riga letta del file Excel Character */
      String riga_letta_c;
      riga_letta_c = CPLib.Space(9);
      /* date_base_excel Date // data di base Excel */
      java.sql.Date date_base_excel;
      date_base_excel = CPLib.NullDate();
      /* ncol Numeric(2, 0) // numero della colonna letta */
      double ncol;
      ncol = 0;
      /* foglio Numeric(2, 0) // foglio letto */
      double foglio;
      foglio = 0;
      /* foglio_c Char(9) // foglio letto Character */
      String foglio_c;
      foglio_c = CPLib.Space(9);
      /* cProgSto Char(15) // progressivo wersonbo del giorno */
      String cProgSto;
      cProgSto = CPLib.Space(15);
      /* w_DATARETT Date // data rettifica */
      java.sql.Date w_DATARETT;
      w_DATARETT = CPLib.NullDate();
      /* cCanc Char(10) */
      String cCanc;
      cCanc = CPLib.Space(10);
      /* cProg Char(10) */
      String cProg;
      cProg = CPLib.Space(10);
      /* _progrig Char(10) */
      String _progrig;
      _progrig = CPLib.Space(10);
      /* riga_letta := 0 // riga letta del file Excel */
      riga_letta = CPLib.Round(0,0);
      /* w_DATARETT := Date() // data rettifica */
      w_DATARETT = CPLib.Date();
      /* w_DATARETT := CharToDate('01/08/2016') // data rettifica */
      w_DATARETT = CPLib.CharToDate("01/08/2016");
      /* w_DATARETT := datamod // data rettifica */
      w_DATARETT = datamod;
      /* gDataVaria := w_DATARETT // Data Variazione */
      gDataVaria = w_DATARETT;
      m_Ctx.SetGlobalDate("gDataVaria",gDataVaria);
      /* Status Msg 'Apertura file Excel. '+Chr(13)+Chr(10)+"Elaborazione in corso..." */
      m_MessageSink.SendMessage("Apertura file Excel. "+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...");
      //base
      InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefile));
      XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
      //Modifica per evitare che carichi tutto il file in memoria
      //XSSFWorkbook  wbx = new XSSFWorkbook(ExcelFileToRead);
      //SXSSFWorkbook  wb = new SXSSFWorkbook(wbx,100);
      
      conta = wb.getNumberOfSheets();
      
      System.out.println("Sono presenti "+conta);
      
      //XSSFWorkbook test = new XSSFWorkbook(); 
      
      //XSSFSheet sheet = wb.getSheetAt(0);
      
      //Modifica per evitare che carichi tutto il file in memoria
      XSSFRow row; 
      XSSFCell cell;
      
      //XSSFRow row2; 
      //XSSFCell cell2;
      
      //SXSSFRow row; 
      //SXSSFCell cell;
      
      SXSSFRow row2; 
      SXSSFCell cell2;
      
      
      
      //Iterator rows = sheet.rowIterator();
      // creo il contenitore dei fogli
      //XSSFWorkbook wb2 = new XSSFWorkbook();
      //Modifica per evitare che carichi tutto il file in memoria
      SXSSFWorkbook  wb2 = new SXSSFWorkbook();
      
      //XSSFSheet sheet2 = wb2.createSheet(sheetName) ;
      SXSSFSheet sheet2 = (SXSSFSheet) wb2.createSheet(sheetName) ;
      //Azzero i contatori di fogli letti e righe scritte
      _i = 0;
      r=0;
      //Creo il record da scrivere
      //row2 = (XSSFRow) sheet2.createRow(r);
      row2 = (SXSSFRow) sheet2.createRow(r);
      //scrivo la riga di intestazione
      cell2 = (SXSSFCell) row2.createCell(0);
      cell2.setCellValue("IDfile");
      cell2 = (SXSSFCell) row2.createCell(1);
      cell2.setCellValue("Numprog");
      cell2 = (SXSSFCell) row2.createCell(2);
      cell2.setCellValue("Idesito");
      cell2 = (SXSSFCell) row2.createCell(3);
      cell2.setCellValue("Intestatario");
      cell2 = (SXSSFCell) row2.createCell(4);
      cell2.setCellValue("Connes");
      cell2 = (SXSSFCell) row2.createCell(5);
      cell2.setCellValue("cf reale");
      cell2 = (SXSSFCell) row2.createCell(6);
      cell2.setCellValue("Cognome");
      cell2 = (SXSSFCell) row2.createCell(7);
      cell2.setCellValue("Nome");
      cell2 = (SXSSFCell) row2.createCell(8);
      cell2.setCellValue("Sesso");
      cell2 = (SXSSFCell) row2.createCell(9);
      cell2.setCellValue("Data di nascita");
      cell2 = (SXSSFCell) row2.createCell(10);
      cell2.setCellValue("Comune di nacita");
      cell2 = (SXSSFCell) row2.createCell(11);
      cell2.setCellValue("stato di nascita");
      cell2 = (SXSSFCell) row2.createCell(12);
      cell2.setCellValue("Provincia di nascita");
      cell2 = (SXSSFCell) row2.createCell(13);
      cell2.setCellValue("Provincia di nascita bis");
      cell2 = (SXSSFCell) row2.createCell(14);
      cell2.setCellValue("CF Estero");
      cell2 = (SXSSFCell) row2.createCell(15);
      cell2.setCellValue("Descrizione");
      cell2 = (SXSSFCell) row2.createCell(16);
      cell2.setCellValue("Note");
      cell2 = (SXSSFCell) row2.createCell(17);
      cell2.setCellValue("Riga");
      cell2 = (SXSSFCell) row2.createCell(18);
      cell2.setCellValue("Foglio");
      r++;
      /* _commit := True // ok alla commit */
      _commit = true;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000001DFstatus;
      nTry000001DFstatus = m_Sql.GetTransactionStatus();
      String cTry000001DFmsg;
      cTry000001DFmsg = m_Sql.TransactionErrorMessage();
      try {
        /* While _i < conta */
        while (CPLib.lt(_i,conta)) {
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          //SXSSFSheet sheet = (SXSSFSheet) wb.getSheetAt(_i);
          //Sheet sheet = wb.getSheetAt(_i);
          //Mi definisco un oggetto che contiene tutte le righe
          Iterator rows = sheet.rowIterator();
          //_righe = sheet.getLastRowNum()+1;
          //_y = 1;
          System.out.println("Lettura foglio "+_i+" di "+conta);
          System.out.println("Ci sono record "+rows.hasNext());
          //System.out.println("Numero di record "+sheet.getRowNum());
          /* riga_letta := 0 // riga letta del file Excel */
          riga_letta = CPLib.Round(0,0);
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          /* While rows.hasNext() and _commit */
          while (rows.hasNext() && _commit) {
            //scorro le righe
            row=(XSSFRow) rows.next();
            //Mi definisco un oggetto che contiene tutte le celle della riga letta
            Iterator cells = row.cellIterator();
            /* cell_count := 0 */
            cell_count = CPLib.Round(0,0);
            /* riga_letta := riga_letta+1 // riga letta del file Excel */
            riga_letta = CPLib.Round(riga_letta+1,0);
            /* nota := '' // nota del eventuale problema */
            nota = "";
            /* modifica := True // ok alla modifica dei dati */
            modifica = true;
            System.out.println("Lettura foglio "+_i+" di "+conta+" riga letta "+riga_letta);
            /* column01 := '' // ragsoc */
            column01 = "";
            /* column02 := '' // connes */
            column02 = "";
            /* column03 := '' // CF */
            column03 = "";
            /* column04 := '' // Cognome */
            column04 = "";
            /* column05 := '' // nome */
            column05 = "";
            /* column06 := '' // sesso */
            column06 = "";
            /* column06num := 0 // sesso numerico */
            column06num = CPLib.Round(0,0);
            /* column07 := '' // data di nascita */
            column07 = "";
            /* column07num := 0 // data di nascita numerico */
            column07num = CPLib.Round(0,0);
            /* column07date := NullDate() // data di nascita data */
            column07date = CPLib.NullDate();
            /* column08 := '' // comune di nascita */
            column08 = "";
            /* column09 := '' // nazione di nascita */
            column09 = "";
            /* column10 := '' // provincia di nascita */
            column10 = "";
            /* column11 := '' // provincia di nascita */
            column11 = "";
            /* column12 := '' // cfestero */
            column12 = "";
            /* column12num := 0 // cfestero numerico */
            column12num = CPLib.Round(0,0);
            /* column13 := '' // Descrizione */
            column13 = "";
            /* column14 := '' // Afile */
            column14 = "";
            /* column14num := 0 // Afile */
            column14num = CPLib.Round(0,0);
            /* column15 := '' // Aprog */
            column15 = "";
            /* column15num := 0 // Aprog */
            column15num = CPLib.Round(0,0);
            /* column16 := '' // Idesito */
            column16 = "";
            /* While cells.hasNext() and riga_letta>1 */
            while (cells.hasNext() && CPLib.gt(riga_letta,1)) {
              /* Status Msg 'Sto leggendo riga: %1 del foglio %2.'+Chr(13)+Chr(10)+"Elaborazione in corso..." */
              m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Sto leggendo riga: %1 del foglio %2."+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...",riga_letta,foglio));
              //scorro le celle della riga
              cell=(XSSFCell) cells.next();
              /* cell_count := cell_count+1 */
              cell_count = CPLib.Round(cell_count+1,0);
              /* cell_type := cell.getCellType().ordinal() */
              cell_type = cell.getCellType().ordinal();
              /* cell.getColumnIndex() torna il valore della colonna letta partendo da 0 */
              /* ncol := cell.getColumnIndex() // numero della colonna letta */
              ncol = CPLib.Round(cell.getColumnIndex(),0);
              /* ncol := ncol+1 // numero della colonna letta */
              ncol = CPLib.Round(ncol+1,0);
              /* Salto le celle non tornate in modo che resti vuota la variabile relativa alla cella non tornata */
              /* While cell_count<ncol */
              while (CPLib.lt(cell_count,ncol)) {
                /* cell_count := cell_count+1 */
                cell_count = CPLib.Round(cell_count+1,0);
              } // End While
              /* If cell_count=4 or cell_count=6 or cell_count=11 or cell_count=17 or (cell_count>18 and cell_count<23) or cell_count=24 or cell_count=26 or cell_count=31 */
              if (CPLib.eqr(cell_count,4) || CPLib.eqr(cell_count,6) || CPLib.eqr(cell_count,11) || CPLib.eqr(cell_count,17) || (CPLib.gt(cell_count,18) && CPLib.lt(cell_count,23)) || CPLib.eqr(cell_count,24) || CPLib.eqr(cell_count,26) || CPLib.eqr(cell_count,31)) {
                /* Case cell_type=1 */
                if (CPLib.eqr(cell_type,1)) {
                  /* tipo numerico
                     da definire il comportamento */
                  /* Case cell_count=4 */
                  if (CPLib.eqr(cell_count,4)) {
                    /* column14num := cell.getNumericCellValue() // Afile */
                    column14num = CPLib.Round(cell.getNumericCellValue(),0);
                    /* column14 := LRTrim(Str(column14num,15,0)) // Afile */
                    column14 = CPLib.LRTrim(CPLib.Str(column14num,15,0));
                    /* Case cell_count=6 */
                  } else if (CPLib.eqr(cell_count,6)) {
                    /* column15num := cell.getNumericCellValue() // Aprog */
                    column15num = CPLib.Round(cell.getNumericCellValue(),0);
                    /* column15 := LRTrim(Str(column15num,25,0)) // Aprog */
                    column15 = CPLib.LRTrim(CPLib.Str(column15num,25,0));
                    /* Case cell_count=28 */
                  } else if (CPLib.eqr(cell_count,28)) {
                    /* Quando la leggeva come numero */
                    /* column07num := cell.getNumericCellValue() // data di nascita numerico */
                    column07num = CPLib.Round(cell.getNumericCellValue(),0);
                    /* column07 := LRTrim(sdf.format(cell.getDateCellValue())) // data di nascita */
                    column07 = CPLib.LRTrim(sdf.format(cell.getDateCellValue()));
                  } else { // Otherwise
                    /* nota := iif(Empty(nota),'Valore numerico alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore numerico alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore numerico alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore numerico alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                    /* _commit := False // ok alla commit */
                    _commit = false;
                  } // End Case
                  /* Case cell_type=2 */
                } else if (CPLib.eqr(cell_type,2)) {
                  /* Case cell_count=4 */
                  if (CPLib.eqr(cell_count,4)) {
                    /* column14 := LRTrim(cell.getStringCellValue()) // Afile */
                    column14 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=6 */
                  } else if (CPLib.eqr(cell_count,6)) {
                    /* column15 := LRTrim(cell.getStringCellValue()) // Aprog */
                    column15 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=11 */
                  } else if (CPLib.eqr(cell_count,11)) {
                    /* column16 := LRTrim(cell.getStringCellValue()) // Idesito */
                    column16 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=20 */
                  } else if (CPLib.eqr(cell_count,20)) {
                    /* column01 := LRTrim(cell.getStringCellValue()) // ragsoc */
                    column01 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=17 */
                  } else if (CPLib.eqr(cell_count,17)) {
                    /* column02 := LRTrim(cell.getStringCellValue()) // connes */
                    column02 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=19 */
                  } else if (CPLib.eqr(cell_count,19)) {
                    /* column03 := LRTrim(cell.getStringCellValue()) // CF */
                    column03 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=21 */
                  } else if (CPLib.eqr(cell_count,21)) {
                    /* column05 := LRTrim(cell.getStringCellValue()) // nome */
                    column05 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=22 */
                  } else if (CPLib.eqr(cell_count,22)) {
                    /* column04 := LRTrim(cell.getStringCellValue()) // Cognome */
                    column04 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=28 */
                  } else if (CPLib.eqr(cell_count,28)) {
                    /* column07 := LRTrim(cell.getStringCellValue()) // data di nascita */
                    column07 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=24 */
                  } else if (CPLib.eqr(cell_count,24)) {
                    /* column08 := LRTrim(cell.getStringCellValue()) // comune di nascita */
                    column08 = CPLib.LRTrim(cell.getStringCellValue());
                    /* column09 := LRTrim(cell.getStringCellValue()) // nazione di nascita */
                    column09 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=26 */
                  } else if (CPLib.eqr(cell_count,26)) {
                    /* column10 := LRTrim(cell.getStringCellValue()) // provincia di nascita */
                    column10 = CPLib.LRTrim(cell.getStringCellValue());
                    /* column11 := LRTrim(cell.getStringCellValue()) // provincia di nascita */
                    column11 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=31 */
                  } else if (CPLib.eqr(cell_count,31)) {
                    /* column13 := LRTrim(cell.getStringCellValue()) // Descrizione */
                    column13 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case Empty(column13) */
                    if (CPLib.Empty(column13)) {
                      /* nota := iif(Empty(nota),'Nessuna azione intrapresa per la fase 1 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Nessuna azione intrapresa per la fase 1 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"Nessuna azione intrapresa per la fase 1 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Nessuna azione intrapresa per la fase 1 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      /* Case column13='CANCELLARE E COMUNICARE NUOVA ANAGRAFICA CON CODICE FISCALE FITTIZIO' or column13='CANCELLARE MODIFICARE ANAGRAFICA E COMUNICARE COME FITTIZIO' or column13='CANCELLARE E RICOMUNICARE COME FITTIZIO' or column13='CANCELLARE IL CLIENTE NON ESISTE' */
                    } else if (CPLib.eqr(column13,"CANCELLARE E COMUNICARE NUOVA ANAGRAFICA CON CODICE FISCALE FITTIZIO") || CPLib.eqr(column13,"CANCELLARE MODIFICARE ANAGRAFICA E COMUNICARE COME FITTIZIO") || CPLib.eqr(column13,"CANCELLARE E RICOMUNICARE COME FITTIZIO") || CPLib.eqr(column13,"CANCELLARE IL CLIENTE NON ESISTE")) {
                      /* _progrig := '' */
                      _progrig = "";
                      // * --- Select from aeoprig
                      m_cServer = m_Ctx.GetServer("aeoprig");
                      m_cPhName = m_Ctx.GetPhName("aeoprig");
                      if (Cursor_aeoprig!=null)
                        Cursor_aeoprig.Close();
                      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+"  and  ASPEDITO=1  and  IDESITO="+CPSql.SQLValueAdapter(CPLib.ToSQL(column16,"?",0,0,m_cServer, m_oParameters),m_cServer,column16)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_aeoprig.Eof())) {
                        /* _progrig := '' */
                        _progrig = "";
                        // * --- Read from aeopcanc
                        m_cServer = m_Ctx.GetServer("aeopcanc");
                        m_cPhName = m_Ctx.GetPhName("aeopcanc");
                        m_cSql = "";
                        m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"C",15,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("AFILE"));
                        m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"C",25,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("APROG"));
                        if (m_Ctx.IsSharedTemp("aeopcanc")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _progrig = Read_Cursor.GetString("PROGRES");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_import_file_xlsx_esterni returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _progrig = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If Empty(_progrig) */
                        if (CPLib.Empty(_progrig)) {
                          /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
                          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                          // * --- Insert into aeopstor from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("aeopstor");
                          m_cPhName = m_Ctx.GetPhName("aeopstor");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopstor",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000231")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_00000231(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATARET"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COINT"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopstor",true);
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
                          /* cCanc := Utilities.GetAutonumber("PDELAGE\'"+LRTrim(gAzienda)+"'",'',10) */
                          cCanc = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PDELAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                          // * --- Insert into aeopcanc from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("aeopcanc");
                          m_cPhName = m_Ctx.GetPhName("aeopcanc");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopcanc",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000233")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_00000233(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(w_DATARETT,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COINT"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(w_DATARETT,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cCanc,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopcanc",true);
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
                        Cursor_aeoprig.Next();
                      }
                      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
                      Cursor_aeoprig.Close();
                      // * --- End Select
                      /* If Empty(_progrig) */
                      if (CPLib.Empty(_progrig)) {
                        /* nota := iif(Empty(nota),'Esito trovato per cancellazione alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Esito trovato per cancellazione alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Esito trovato per cancellazione alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Esito trovato per cancellazione alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      } else { // Else
                        /* nota := iif(Empty(nota),'Esito non trovato alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Esito non trovato alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Esito non trovato alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Esito non trovato alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                        /* _commit := False // ok alla commit */
                        _commit = false;
                      } // End If
                      /* Case column13='MODIFICARE E COMUNICARE CON CODICE FISCALE VERIFICATO' */
                    } else if (CPLib.eqr(column13,"MODIFICARE E COMUNICARE CON CODICE FISCALE VERIFICATO")) {
                      /* nota := iif(Empty(nota),'Nessuna azione intrapresa per la fase 1 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Nessuna azione intrapresa per la fase 1 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"Nessuna azione intrapresa per la fase 1 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Nessuna azione intrapresa per la fase 1 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                    } else { // Otherwise
                      /* nota := iif(Empty(nota),'Valore non previsto alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore non previsto alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"Valore non previsto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore non previsto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      /* If cell_count<32 */
                      if (CPLib.lt(cell_count,32)) {
                        /* _commit := False // ok alla commit */
                        _commit = false;
                      } // End If
                    } // End Case
                  } // End Case
                  /* Case cell_type=3 */
                } else if (CPLib.eqr(cell_type,3)) {
                  /* nota := iif(Empty(nota),'Formula alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Formula alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Formula alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Formula alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                  /* _commit := False // ok alla commit */
                  _commit = false;
                  /* Case cell_type=6 */
                } else if (CPLib.eqr(cell_type,6)) {
                  /* Case cell_count=19 */
                  if (CPLib.eqr(cell_count,19)) {
                    /* column03 := '' // CF */
                    column03 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)");
                    /* Case cell_count=21 */
                  } else if (CPLib.eqr(cell_count,21)) {
                    /* column05 := '' // nome */
                    column05 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (nome vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (nome vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (nome vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (nome vuoto)");
                    /* Case cell_count=22 */
                  } else if (CPLib.eqr(cell_count,22)) {
                    /* column04 := '' // Cognome */
                    column04 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (cognome vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (cognome vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (cognome vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (cognome vuoto)");
                    /* Case cell_count=24 */
                  } else if (CPLib.eqr(cell_count,24)) {
                    /* column08 := '' // comune di nascita */
                    column08 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (comune vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (comune vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (comune vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (comune vuoto)");
                    /* column09 := '' // nazione di nascita */
                    column09 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (stato vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (stato vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (stato vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (stato vuoto)");
                    /* Case cell_count=26 */
                  } else if (CPLib.eqr(cell_count,26)) {
                    /* column10 := '' // provincia di nascita */
                    column10 = "";
                    /* column11 := '' // provincia di nascita */
                    column11 = "";
                    /* Case cell_count=31 */
                  } else if (CPLib.eqr(cell_count,31)) {
                    /* column13 := '' // Descrizione */
                    column13 = "";
                  } else { // Otherwise
                    /* nota := iif(Empty(nota),'Valore vuoto alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore vuoto alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore vuoto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore vuoto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                    /* If cell_count<32 */
                    if (CPLib.lt(cell_count,32)) {
                      /* _commit := False // ok alla commit */
                      _commit = false;
                    } // End If
                  } // End Case
                  /* Case cell_type=0 */
                } else if (CPLib.eqr(cell_type,0)) {
                  /* tipo buleano
                     da definire il comportamento */
                  /* nota := iif(Empty(nota),'Valore buleano alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore buleano alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore buleano alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore buleano alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                  /* _commit := False // ok alla commit */
                  _commit = false;
                } else { // Otherwise
                  /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                  /* _commit := False // ok alla commit */
                  _commit = false;
                } // End Case
              } // End If
              /* Se l'interetor delle celle è più corto di quanto doveva essere ipotizzo che sia un rivio diretto cosi come è senza variazioni. Vedi casistica colonna 31 vuota. */
              /* If cell_count<30 and not(cells.hasNext()) */
              if (CPLib.lt(cell_count,30) &&  ! (cells.hasNext())) {
                /* nota := iif(Empty(nota),'Nessuna azione intrapresa per la fase 1 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Nessuna azione intrapresa per la fase 1 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                nota = (CPLib.Empty(nota)?"Nessuna azione intrapresa per la fase 1 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Nessuna azione intrapresa per la fase 1 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
              } // End If
            } // End While
            /* If riga_letta>1 */
            if (CPLib.gt(riga_letta,1)) {
              /* riga_letta_c := Str(riga_letta,9,0) // riga letta del file Excel Character */
              riga_letta_c = CPLib.Str(riga_letta,9,0);
              /* foglio_c := Str(foglio,2,0) // foglio letto Character */
              foglio_c = CPLib.Str(foglio,2,0);
              //Creo il record da scrivere
              row2 = (SXSSFRow) sheet2.createRow(r);
              cell2 = (SXSSFCell) row2.createCell(0);
              cell2.setCellValue(CPLib.LRTrim(column14));
              cell2 = (SXSSFCell) row2.createCell(1);
              cell2.setCellValue(CPLib.LRTrim(column15));
              cell2 = (SXSSFCell) row2.createCell(2);
              cell2.setCellValue(CPLib.LRTrim(column16));
              cell2 = (SXSSFCell) row2.createCell(3);
              cell2.setCellValue(CPLib.LRTrim(column01));
              cell2 = (SXSSFCell) row2.createCell(4);
              cell2.setCellValue(CPLib.LRTrim(column02));
              cell2 = (SXSSFCell) row2.createCell(5);
              cell2.setCellValue(CPLib.LRTrim(column03));
              cell2 = (SXSSFCell) row2.createCell(6);
              cell2.setCellValue(CPLib.LRTrim(column04));
              cell2 = (SXSSFCell) row2.createCell(7);
              cell2.setCellValue(CPLib.LRTrim(column05));
              cell2 = (SXSSFCell) row2.createCell(8);
              cell2.setCellValue(CPLib.LRTrim(column06));
              cell2 = (SXSSFCell) row2.createCell(9);
              cell2.setCellValue(CPLib.LRTrim(column07));
              cell2 = (SXSSFCell) row2.createCell(10);
              cell2.setCellValue(CPLib.LRTrim(column08));
              cell2 = (SXSSFCell) row2.createCell(11);
              cell2.setCellValue(CPLib.LRTrim(column09));
              cell2 = (SXSSFCell) row2.createCell(12);
              cell2.setCellValue(CPLib.LRTrim(column10));
              cell2 = (SXSSFCell) row2.createCell(13);
              cell2.setCellValue(CPLib.LRTrim(column11));
              cell2 = (SXSSFCell) row2.createCell(14);
              cell2.setCellValue(CPLib.LRTrim(column12));
              cell2 = (SXSSFCell) row2.createCell(15);
              cell2.setCellValue(CPLib.LRTrim(column13));
              cell2 = (SXSSFCell) row2.createCell(16);
              cell2.setCellValue(CPLib.LRTrim(nota));
              cell2 = (SXSSFCell) row2.createCell(17);
              cell2.setCellValue(CPLib.LRTrim(riga_letta_c));
              cell2 = (SXSSFCell) row2.createCell(18);
              cell2.setCellValue(CPLib.LRTrim(foglio_c));
              r++;
            } // End If
          } // End While
          _i++;
        } // End While
        /* If not(_commit) */
        if ( ! (_commit)) {
          // Transaction Error
          cTry000001DFmsg = CPLib.FormatMsg(m_Ctx,"errore xlsx");
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore xlsx"));
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000001DFstatus,0)) {
          m_Sql.SetTransactionStatus(nTry000001DFstatus,cTry000001DFmsg);
        }
      }
      /* Status Msg 'Ridimensionamento delle celle. '+Chr(13)+Chr(10)+"Elaborazione in corso..." */
      m_MessageSink.SendMessage("Ridimensionamento delle celle. "+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...");
      //Ridimensiono le colonne in base al contenuto
      sheet2.autoSizeColumn(0);
      sheet2.autoSizeColumn(1);
      sheet2.autoSizeColumn(2);
      sheet2.autoSizeColumn(3);
      sheet2.autoSizeColumn(4);
      sheet2.autoSizeColumn(5);
      sheet2.autoSizeColumn(6);
      sheet2.autoSizeColumn(7);
      sheet2.autoSizeColumn(8);
      sheet2.autoSizeColumn(9);
      sheet2.autoSizeColumn(10);
      sheet2.autoSizeColumn(11);
      sheet2.autoSizeColumn(12);
      sheet2.autoSizeColumn(13);
      sheet2.autoSizeColumn(14);
      sheet2.autoSizeColumn(15);
      sheet2.autoSizeColumn(16);
      sheet2.autoSizeColumn(17);
      sheet2.autoSizeColumn(18);
      /* Status Msg 'Scrittura file Excel. '+Chr(13)+Chr(10)+"Elaborazione in corso..." */
      m_MessageSink.SendMessage("Scrittura file Excel. "+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...");
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefileoutput));
      
      //write this workbook to an Outputstream.
      wb2.write(fileOut);
      fileOut.flush();
      fileOut.close();
    } finally {
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
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
  void Page_5() throws Exception {
    CPResultSet Cursor_aeoprig=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* column01 Char(25) // ragsoc */
      String column01;
      column01 = CPLib.Space(25);
      /* column02 Char(25) // connes */
      String column02;
      column02 = CPLib.Space(25);
      /* column03 Char(25) // CF */
      String column03;
      column03 = CPLib.Space(25);
      /* column04 Char(25) // Cognome */
      String column04;
      column04 = CPLib.Space(25);
      /* column05 Char(25) // nome */
      String column05;
      column05 = CPLib.Space(25);
      /* column06 Char(25) // sesso */
      String column06;
      column06 = CPLib.Space(25);
      /* column06num Numeric(1, 0) // sesso numerico */
      double column06num;
      column06num = 0;
      /* column07 Char(25) // data di nascita */
      String column07;
      column07 = CPLib.Space(25);
      /* column07num Numeric(99, 0) // data di nascita numerico */
      double column07num;
      column07num = 0;
      /* column07date Date // data di nascita data */
      java.sql.Date column07date;
      column07date = CPLib.NullDate();
      /* column08 Char(30) // comune di nascita */
      String column08;
      column08 = CPLib.Space(30);
      /* column09 Char(30) // nazione di nascita */
      String column09;
      column09 = CPLib.Space(30);
      /* column10 Char(2) // provincia di nascita */
      String column10;
      column10 = CPLib.Space(2);
      /* column11 Char(2) // provincia di nascita */
      String column11;
      column11 = CPLib.Space(2);
      /* column12 Char(1) // cfestero */
      String column12;
      column12 = CPLib.Space(1);
      /* column12num Numeric(1, 0) // cfestero numerico */
      double column12num;
      column12num = 0;
      /* column13 Char(16) // Descrizione */
      String column13;
      column13 = CPLib.Space(16);
      /* column14num Numeric(15, 0) // Afile */
      double column14num;
      column14num = 0;
      /* column14 Char(15) // Afile */
      String column14;
      column14 = CPLib.Space(15);
      /* column15num Numeric(25, 0) // Aprog */
      double column15num;
      column15num = 0;
      /* column15 Char(25) // Aprog */
      String column15;
      column15 = CPLib.Space(25);
      /* column16 Char(8) // Idesito */
      String column16;
      column16 = CPLib.Space(8);
      /* _commit Bool // ok alla commit */
      boolean _commit;
      _commit = false;
      /* _falied Bool // fallimento scrittura dati */
      boolean _falied;
      _falied = false;
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      double riga_letta;
      riga_letta = 0;
      /* riga_letta_c Char(9) // riga letta del file Excel Character */
      String riga_letta_c;
      riga_letta_c = CPLib.Space(9);
      /* date_base_excel Date // data di base Excel */
      java.sql.Date date_base_excel;
      date_base_excel = CPLib.NullDate();
      /* ncol Numeric(2, 0) // numero della colonna letta */
      double ncol;
      ncol = 0;
      /* foglio Numeric(2, 0) // foglio letto */
      double foglio;
      foglio = 0;
      /* foglio_c Char(9) // foglio letto Character */
      String foglio_c;
      foglio_c = CPLib.Space(9);
      /* cProgSto Char(15) // progressivo wersonbo del giorno */
      String cProgSto;
      cProgSto = CPLib.Space(15);
      /* w_DATARETT Date // data rettifica */
      java.sql.Date w_DATARETT;
      w_DATARETT = CPLib.NullDate();
      /* cCanc Char(10) */
      String cCanc;
      cCanc = CPLib.Space(10);
      /* cProg Char(10) */
      String cProg;
      cProg = CPLib.Space(10);
      /* _progrig Char(10) */
      String _progrig;
      _progrig = CPLib.Space(10);
      /* _prog Char(10) // progressivo opextrbo */
      String _prog;
      _prog = CPLib.Space(10);
      /* nProgImp Numeric(15, 0) // progressivo aeopig */
      double nProgImp;
      nProgImp = 0;
      /* riga_letta := 0 // riga letta del file Excel */
      riga_letta = CPLib.Round(0,0);
      /* w_DATARETT := Date() // data rettifica */
      w_DATARETT = CPLib.Date();
      /* w_DATARETT := CharToDate('01/08/2016') // data rettifica */
      w_DATARETT = CPLib.CharToDate("01/08/2016");
      /* w_DATARETT := datamod // data rettifica */
      w_DATARETT = datamod;
      /* gDataVaria := w_DATARETT // Data Variazione */
      gDataVaria = w_DATARETT;
      m_Ctx.SetGlobalDate("gDataVaria",gDataVaria);
      /* Status Msg 'Apertura file Excel. '+Chr(13)+Chr(10)+"Elaborazione in corso..." */
      m_MessageSink.SendMessage("Apertura file Excel. "+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...");
      //base
      InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefile));
      XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
      
      conta = wb.getNumberOfSheets();
      
      //XSSFWorkbook test = new XSSFWorkbook(); 
      
      //XSSFSheet sheet = wb.getSheetAt(0);
      XSSFRow row; 
      XSSFCell cell;
      
      XSSFRow row2; 
      XSSFCell cell2;
      
      //Iterator rows = sheet.rowIterator();
      // creo il contenitore dei fogli
      XSSFWorkbook wb2 = new XSSFWorkbook();
      XSSFSheet sheet2 = wb2.createSheet(sheetName) ;
      //Azzero i contatori di fogli letti e righe scritte
      _i = 0;
      r=0;
      //Creo il record da scrivere
      row2 = (XSSFRow) sheet2.createRow(r);
      //scrivo la riga di intestazione
      cell2 = (XSSFCell) row2.createCell(0);
      cell2.setCellValue("IDfile");
      cell2 = (XSSFCell) row2.createCell(1);
      cell2.setCellValue("Numprog");
      cell2 = (XSSFCell) row2.createCell(2);
      cell2.setCellValue("Idesito");
      cell2 = (XSSFCell) row2.createCell(3);
      cell2.setCellValue("Intestatario");
      cell2 = (XSSFCell) row2.createCell(4);
      cell2.setCellValue("Connes");
      cell2 = (XSSFCell) row2.createCell(5);
      cell2.setCellValue("cf reale");
      cell2 = (XSSFCell) row2.createCell(6);
      cell2.setCellValue("Cognome");
      cell2 = (XSSFCell) row2.createCell(7);
      cell2.setCellValue("Nome");
      cell2 = (XSSFCell) row2.createCell(8);
      cell2.setCellValue("Sesso");
      cell2 = (XSSFCell) row2.createCell(9);
      cell2.setCellValue("Data di nascita");
      cell2 = (XSSFCell) row2.createCell(10);
      cell2.setCellValue("Comune di nacita");
      cell2 = (XSSFCell) row2.createCell(11);
      cell2.setCellValue("stato di nascita");
      cell2 = (XSSFCell) row2.createCell(12);
      cell2.setCellValue("Provincia di nascita");
      cell2 = (XSSFCell) row2.createCell(13);
      cell2.setCellValue("Provincia di nascita bis");
      cell2 = (XSSFCell) row2.createCell(14);
      cell2.setCellValue("CF Estero");
      cell2 = (XSSFCell) row2.createCell(15);
      cell2.setCellValue("Descrizione");
      cell2 = (XSSFCell) row2.createCell(16);
      cell2.setCellValue("Note");
      cell2 = (XSSFCell) row2.createCell(17);
      cell2.setCellValue("Riga");
      cell2 = (XSSFCell) row2.createCell(18);
      cell2.setCellValue("Foglio");
      r++;
      /* _commit := True // ok alla commit */
      _commit = true;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000297status;
      nTry00000297status = m_Sql.GetTransactionStatus();
      String cTry00000297msg;
      cTry00000297msg = m_Sql.TransactionErrorMessage();
      try {
        /* While _i < conta */
        while (CPLib.lt(_i,conta)) {
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          //Mi definisco un oggetto che contiene tutte le righe
          Iterator rows = sheet.rowIterator();
          //_righe = sheet.getLastRowNum()+1;
          //_y = 1;
          /* riga_letta := 0 // riga letta del file Excel */
          riga_letta = CPLib.Round(0,0);
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          /* While rows.hasNext() and _commit */
          while (rows.hasNext() && _commit) {
            //scorro le righe
            row=(XSSFRow) rows.next();
            //Mi definisco un oggetto che contiene tutte le celle della riga letta
            Iterator cells = row.cellIterator();
            /* cell_count := 0 */
            cell_count = CPLib.Round(0,0);
            /* riga_letta := riga_letta+1 // riga letta del file Excel */
            riga_letta = CPLib.Round(riga_letta+1,0);
            /* nota := '' // nota del eventuale problema */
            nota = "";
            /* modifica := True // ok alla modifica dei dati */
            modifica = true;
            /* column01 := '' // ragsoc */
            column01 = "";
            /* column02 := '' // connes */
            column02 = "";
            /* column03 := '' // CF */
            column03 = "";
            /* column04 := '' // Cognome */
            column04 = "";
            /* column05 := '' // nome */
            column05 = "";
            /* column06 := '' // sesso */
            column06 = "";
            /* column06num := 0 // sesso numerico */
            column06num = CPLib.Round(0,0);
            /* column07 := '' // data di nascita */
            column07 = "";
            /* column07num := 0 // data di nascita numerico */
            column07num = CPLib.Round(0,0);
            /* column07date := NullDate() // data di nascita data */
            column07date = CPLib.NullDate();
            /* column08 := '' // comune di nascita */
            column08 = "";
            /* column09 := '' // nazione di nascita */
            column09 = "";
            /* column10 := '' // provincia di nascita */
            column10 = "";
            /* column11 := '' // provincia di nascita */
            column11 = "";
            /* column12 := '' // cfestero */
            column12 = "";
            /* column12num := 0 // cfestero numerico */
            column12num = CPLib.Round(0,0);
            /* column13 := '' // Descrizione */
            column13 = "";
            /* column14 := '' // Afile */
            column14 = "";
            /* column14num := 0 // Afile */
            column14num = CPLib.Round(0,0);
            /* column15 := '' // Aprog */
            column15 = "";
            /* column15num := 0 // Aprog */
            column15num = CPLib.Round(0,0);
            /* column16 := '' // Idesito */
            column16 = "";
            /* While cells.hasNext() and riga_letta>1 */
            while (cells.hasNext() && CPLib.gt(riga_letta,1)) {
              /* Status Msg 'Sto leggendo riga: %1 del foglio %2.'+Chr(13)+Chr(10)+"Elaborazione in corso..." */
              m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Sto leggendo riga: %1 del foglio %2."+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...",riga_letta,foglio));
              //scorro le celle della riga
              cell=(XSSFCell) cells.next();
              /* cell_count := cell_count+1 */
              cell_count = CPLib.Round(cell_count+1,0);
              /* cell_type := cell.getCellType().ordinal() */
              cell_type = cell.getCellType().ordinal();
              /* cell.getColumnIndex() torna il valore della colonna letta partendo da 0 */
              /* ncol := cell.getColumnIndex() // numero della colonna letta */
              ncol = CPLib.Round(cell.getColumnIndex(),0);
              /* ncol := ncol+1 // numero della colonna letta */
              ncol = CPLib.Round(ncol+1,0);
              /* Salto le celle non tornate in modo che resti vuota la variabile relativa alla cella non tornata */
              /* While cell_count<ncol */
              while (CPLib.lt(cell_count,ncol)) {
                /* cell_count := cell_count+1 */
                cell_count = CPLib.Round(cell_count+1,0);
              } // End While
              /* If cell_count=4 or cell_count=6 or cell_count=11 or cell_count=17 or (cell_count>18 and cell_count<23) or cell_count=24 or cell_count=26 or cell_count=31 */
              if (CPLib.eqr(cell_count,4) || CPLib.eqr(cell_count,6) || CPLib.eqr(cell_count,11) || CPLib.eqr(cell_count,17) || (CPLib.gt(cell_count,18) && CPLib.lt(cell_count,23)) || CPLib.eqr(cell_count,24) || CPLib.eqr(cell_count,26) || CPLib.eqr(cell_count,31)) {
                /* Case cell_type=1 */
                if (CPLib.eqr(cell_type,1)) {
                  /* tipo numerico
                     da definire il comportamento */
                  /* Case cell_count=4 */
                  if (CPLib.eqr(cell_count,4)) {
                    /* column14num := cell.getNumericCellValue() // Afile */
                    column14num = CPLib.Round(cell.getNumericCellValue(),0);
                    /* column14 := LRTrim(Str(column14num,15,0)) // Afile */
                    column14 = CPLib.LRTrim(CPLib.Str(column14num,15,0));
                    /* Case cell_count=6 */
                  } else if (CPLib.eqr(cell_count,6)) {
                    /* column15num := cell.getNumericCellValue() // Aprog */
                    column15num = CPLib.Round(cell.getNumericCellValue(),0);
                    /* column15 := LRTrim(Str(column15num,25,0)) // Aprog */
                    column15 = CPLib.LRTrim(CPLib.Str(column15num,25,0));
                    /* Case cell_count=28 */
                  } else if (CPLib.eqr(cell_count,28)) {
                    /* Quando la leggeva come numero */
                    /* column07num := cell.getNumericCellValue() // data di nascita numerico */
                    column07num = CPLib.Round(cell.getNumericCellValue(),0);
                    /* column07 := LRTrim(sdf.format(cell.getDateCellValue())) // data di nascita */
                    column07 = CPLib.LRTrim(sdf.format(cell.getDateCellValue()));
                  } else { // Otherwise
                    /* nota := iif(Empty(nota),'Valore numerico alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore numerico alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore numerico alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore numerico alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                    /* _commit := False // ok alla commit */
                    _commit = false;
                  } // End Case
                  /* Case cell_type=2 */
                } else if (CPLib.eqr(cell_type,2)) {
                  /* Case cell_count=4 */
                  if (CPLib.eqr(cell_count,4)) {
                    /* column14 := LRTrim(cell.getStringCellValue()) // Afile */
                    column14 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=6 */
                  } else if (CPLib.eqr(cell_count,6)) {
                    /* column15 := LRTrim(cell.getStringCellValue()) // Aprog */
                    column15 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=11 */
                  } else if (CPLib.eqr(cell_count,11)) {
                    /* column16 := LRTrim(cell.getStringCellValue()) // Idesito */
                    column16 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=20 */
                  } else if (CPLib.eqr(cell_count,20)) {
                    /* column01 := LRTrim(cell.getStringCellValue()) // ragsoc */
                    column01 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=17 */
                  } else if (CPLib.eqr(cell_count,17)) {
                    /* column02 := LRTrim(cell.getStringCellValue()) // connes */
                    column02 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=19 */
                  } else if (CPLib.eqr(cell_count,19)) {
                    /* column03 := LRTrim(cell.getStringCellValue()) // CF */
                    column03 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=21 */
                  } else if (CPLib.eqr(cell_count,21)) {
                    /* column05 := LRTrim(cell.getStringCellValue()) // nome */
                    column05 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=22 */
                  } else if (CPLib.eqr(cell_count,22)) {
                    /* column04 := LRTrim(cell.getStringCellValue()) // Cognome */
                    column04 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=28 */
                  } else if (CPLib.eqr(cell_count,28)) {
                    /* column07 := LRTrim(cell.getStringCellValue()) // data di nascita */
                    column07 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=24 */
                  } else if (CPLib.eqr(cell_count,24)) {
                    /* column08 := LRTrim(cell.getStringCellValue()) // comune di nascita */
                    column08 = CPLib.LRTrim(cell.getStringCellValue());
                    /* column09 := LRTrim(cell.getStringCellValue()) // nazione di nascita */
                    column09 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=26 */
                  } else if (CPLib.eqr(cell_count,26)) {
                    /* column10 := LRTrim(cell.getStringCellValue()) // provincia di nascita */
                    column10 = CPLib.LRTrim(cell.getStringCellValue());
                    /* column11 := LRTrim(cell.getStringCellValue()) // provincia di nascita */
                    column11 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Case cell_count=31 */
                  } else if (CPLib.eqr(cell_count,31)) {
                    /* column13 := LRTrim(cell.getStringCellValue()) // Descrizione */
                    column13 = CPLib.LRTrim(cell.getStringCellValue());
                    /* Status Msg 'Sto leggendo riga: %1 del foglio %2.'+Chr(13)+Chr(10)+"Elaborazione in corso..."+Chr(13)+Chr(10)+'Tipo cella: %3 valore letto: %4' */
                    m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Sto leggendo riga: %1 del foglio %2."+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso..."+CPLib.Chr(13)+CPLib.Chr(10)+"Tipo cella: %3 valore letto: %4",riga_letta,foglio,cell_type,column13));
                    /* Case Empty(column13) */
                    if (CPLib.Empty(column13)) {
                      /* Presa la variabile CProgSto a caso, solo per verificare se viene modificato un solo record altrimenti blocco la routine */
                      /* cProgSto := '' */
                      cProgSto = "";
                      // * --- Select from aeoprig
                      m_cServer = m_Ctx.GetServer("aeoprig");
                      m_cPhName = m_Ctx.GetPhName("aeoprig");
                      if (Cursor_aeoprig!=null)
                        Cursor_aeoprig.Close();
                      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+"  and  ASPEDITO=1  and  IDESITO="+CPSql.SQLValueAdapter(CPLib.ToSQL(column16,"?",0,0,m_cServer, m_oParameters),m_cServer,column16)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_aeoprig.Eof())) {
                        // * --- Write into aeoprig from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("aeoprig");
                        m_cPhName = m_Ctx.GetPhName("aeoprig");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000002E5")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
                        m_cSql = m_cSql+"RSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                        m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                        m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("IDBASE"))+"";
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
                        /* cProgSto := cProgSto+'A' */
                        cProgSto = cProgSto+"A";
                        Cursor_aeoprig.Next();
                      }
                      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
                      Cursor_aeoprig.Close();
                      // * --- End Select
                      /* If Empty(cProgSto) or Len(cProgSto)>1 */
                      if (CPLib.Empty(cProgSto) || CPLib.gt(CPLib.Len(cProgSto),1)) {
                        /* _commit := False // ok alla commit */
                        _commit = false;
                        /* nota := iif(Empty(nota),'Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      } else { // Else
                        /* nota := iif(Empty(nota),'Record trovato e preparata la rettifica per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Record trovato e preparata la rettifica per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Record trovato e preparata la rettifica per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Record trovato e preparata la rettifica per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      } // End If
                      /* Case column13='CANCELLARE E COMUNICARE NUOVA ANAGRAFICA CON CODICE FISCALE FITTIZIO' or column13='CANCELLARE MODIFICARE ANAGRAFICA E COMUNICARE COME FITTIZIO' */
                    } else if (CPLib.eqr(column13,"CANCELLARE E COMUNICARE NUOVA ANAGRAFICA CON CODICE FISCALE FITTIZIO") || CPLib.eqr(column13,"CANCELLARE MODIFICARE ANAGRAFICA E COMUNICARE COME FITTIZIO")) {
                      /* SE variato CF o luogo di nascita o provincia devo prima registrare a storico la vecchi anagrafica. Altrimenti vari solo i dati dell'anagrafica. */
                      /* If not(Empty(column03)) or not(Empty(column08)) or not(Empty(column10)) */
                      if ( ! (CPLib.Empty(column03)) ||  ! (CPLib.Empty(column08)) ||  ! (CPLib.Empty(column10))) {
                        /* cProgSto := '' */
                        cProgSto = "";
                        // * --- Select from wersonbo
                        m_cServer = m_Ctx.GetServer("wersonbo");
                        m_cPhName = m_Ctx.GetPhName("wersonbo");
                        if (Cursor_wersonbo!=null)
                          Cursor_wersonbo.Close();
                        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+"  and  datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DATARETT,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DATARETT)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                          /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
                          cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
                          // * --- Select from personbo
                          m_cServer = m_Ctx.GetServer("personbo");
                          m_cPhName = m_Ctx.GetPhName("personbo");
                          if (Cursor_personbo!=null)
                            Cursor_personbo.Close();
                          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                          while ( ! (Cursor_personbo.Eof())) {
                            // * --- Insert into wersonbo from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("wersonbo");
                            m_cPhName = m_Ctx.GetPhName("wersonbo");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000002F4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_000002F4(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(column02,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(gDataVaria,"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
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
                            /* Faccio la scrittura in base alle valorizzazioni iniziali e a seconda delle nuove. */
                            /* If personbo->TIPINTER='EE' */
                            if (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")) {
                              /* If LRTrim(column10)='EE' */
                              if (CPLib.eqr(CPLib.LRTrim(column10),"EE")) {
                                // * --- Write into personbo from values
                                m_Sql.RequireTransaction();
                                m_cServer = m_Ctx.GetServer("personbo");
                                m_cPhName = m_Ctx.GetPhName("personbo");
                                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000002F8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(column03)?Cursor_personbo.GetString("CODFISC"):CPLib.LRTrim(column03)),"C",16,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL((CPLib.Empty(column08)?Cursor_personbo.GetString("NASSTATO"):CPLib.LRTrim(column08)),"C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL("","C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                                m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(column04)?Cursor_personbo.GetString("COGNOME"):CPLib.LRTrim(column04)),"C",26,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(column05)?Cursor_personbo.GetString("NOME"):CPLib.LRTrim(column05)),"C",25,0,m_cServer)+", ";
                                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                m_cSql = m_cSql+" where ";
                                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
                                // * --- Write into personbo from values
                                m_Sql.RequireTransaction();
                                m_cServer = m_Ctx.GetServer("personbo");
                                m_cPhName = m_Ctx.GetPhName("personbo");
                                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000002F9")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(column03)?Cursor_personbo.GetString("CODFISC"):CPLib.LRTrim(column03)),"C",16,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL("","C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL((CPLib.Empty(column08)?Cursor_personbo.GetString("NASCOMUN"):CPLib.LRTrim(column08)),"C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL((CPLib.Empty(column10)?Cursor_personbo.GetString("TIPINTER"):column10),"C",2,0,m_cServer)+", ";
                                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                                m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(column04)?Cursor_personbo.GetString("COGNOME"):CPLib.LRTrim(column04)),"C",26,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(column05)?Cursor_personbo.GetString("NOME"):CPLib.LRTrim(column05)),"C",25,0,m_cServer)+", ";
                                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                m_cSql = m_cSql+" where ";
                                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
                              /* If LRTrim(column10)='EE' */
                              if (CPLib.eqr(CPLib.LRTrim(column10),"EE")) {
                                // * --- Write into personbo from values
                                m_Sql.RequireTransaction();
                                m_cServer = m_Ctx.GetServer("personbo");
                                m_cPhName = m_Ctx.GetPhName("personbo");
                                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000002FB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(column03)?Cursor_personbo.GetString("CODFISC"):CPLib.LRTrim(column03)),"C",16,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL((CPLib.Empty(column08)?Cursor_personbo.GetString("NASSTATO"):CPLib.LRTrim(column08)),"C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL("","C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL("EE","C",2,0,m_cServer)+", ";
                                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                                m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(column04)?Cursor_personbo.GetString("COGNOME"):CPLib.LRTrim(column04)),"C",26,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(column05)?Cursor_personbo.GetString("NOME"):CPLib.LRTrim(column05)),"C",25,0,m_cServer)+", ";
                                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                m_cSql = m_cSql+" where ";
                                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
                                // * --- Write into personbo from values
                                m_Sql.RequireTransaction();
                                m_cServer = m_Ctx.GetServer("personbo");
                                m_cPhName = m_Ctx.GetPhName("personbo");
                                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000002FC")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(column03)?Cursor_personbo.GetString("CODFISC"):CPLib.LRTrim(column03)),"C",16,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL("","C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL((CPLib.Empty(column08)?Cursor_personbo.GetString("NASCOMUN"):CPLib.LRTrim(column08)),"C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL((CPLib.Empty(column10)?Cursor_personbo.GetString("TIPINTER"):column10),"C",2,0,m_cServer)+", ";
                                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                                m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(column04)?Cursor_personbo.GetString("COGNOME"):CPLib.LRTrim(column04)),"C",26,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(column05)?Cursor_personbo.GetString("NOME"):CPLib.LRTrim(column05)),"C",25,0,m_cServer)+", ";
                                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                m_cSql = m_cSql+" where ";
                                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
                            Cursor_personbo.Next();
                          }
                          m_cConnectivityError = Cursor_personbo.ErrorMessage();
                          Cursor_personbo.Close();
                          // * --- End Select
                        } // End If
                      } else { // Else
                        /* If not(Empty(column04)) or not(Empty(column05)) */
                        if ( ! (CPLib.Empty(column04)) ||  ! (CPLib.Empty(column05))) {
                          // * --- Write into personbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("personbo");
                          m_cPhName = m_Ctx.GetPhName("personbo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000002FE")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                          m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(column04)?Cursor_personbo.GetString("COGNOME"):CPLib.LRTrim(column04)),"C",26,0,m_cServer)+", ";
                          m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(column05)?Cursor_personbo.GetString("NOME"):CPLib.LRTrim(column05)),"C",25,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
                      /* _progrig := '' */
                      _progrig = "";
                      /* Creo la nuova riga su aeoprig per rinviarlo come estero. */
                      // * --- Select from aeoprig
                      m_cServer = m_Ctx.GetServer("aeoprig");
                      m_cPhName = m_Ctx.GetPhName("aeoprig");
                      if (Cursor_aeoprig!=null)
                        Cursor_aeoprig.Close();
                      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+"  and  ASPEDITO=1  and  IDESITO="+CPSql.SQLValueAdapter(CPLib.ToSQL(column16,"?",0,0,m_cServer, m_oParameters),m_cServer,column16)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_aeoprig.Eof())) {
                        /* _progrig := '' */
                        _progrig = "";
                        // * --- Read from aeopcanc
                        m_cServer = m_Ctx.GetServer("aeopcanc");
                        m_cPhName = m_Ctx.GetPhName("aeopcanc");
                        m_cSql = "";
                        m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"C",15,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("AFILE"));
                        m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"C",25,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("APROG"));
                        if (m_Ctx.IsSharedTemp("aeopcanc")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _progrig = Read_Cursor.GetString("PROGRES");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_import_file_xlsx_esterni returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _progrig = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If not(Empty(_progrig)) */
                        if ( ! (CPLib.Empty(_progrig))) {
                          /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) // progressivo opextrbo */
                          _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                          /* nProgImp := Utilities.GetAutonumber("PROGAED\'"+LRTrim(gAzienda)+"'",0,15) // progressivo aeopig */
                          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAED\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                          // * --- Insert into aeoprig from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("aeoprig");
                          m_cPhName = m_Ctx.GetPhName("aeoprig");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000307")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_00000307(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COINT"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(Cursor_aeoprig.GetDate("ADATA")),"?",0,0)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeoprig",true);
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
                          // * --- Write into opextrbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("opextrbo");
                          m_cPhName = m_Ctx.GetPhName("opextrbo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000308")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(_prog,"C",10,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("CONNESINT"))+"";
                          m_cSql = m_cSql+" and DATAOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0,m_cServer),m_cServer,Cursor_aeoprig.GetDate("ADATA"))+"";
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
                        Cursor_aeoprig.Next();
                      }
                      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
                      Cursor_aeoprig.Close();
                      // * --- End Select
                      /* If Empty(_progrig) */
                      if (CPLib.Empty(_progrig)) {
                        /* nota := iif(Empty(nota),'Esito non trovato alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Esito non trovato alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Esito non trovato alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Esito non trovato alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                        /* _commit := False // ok alla commit */
                        _commit = false;
                      } else { // Else
                        /* nota := iif(Empty(nota),'Esito trovato per rinvio come estero alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Esito trovato per rinvio come estero alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Esito trovato per rinvio come estero alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Esito trovato per rinvio come estero alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      } // End If
                      /* Case column13='CANCELLARE E RICOMUNICARE COME FITTIZIO' */
                    } else if (CPLib.eqr(column13,"CANCELLARE E RICOMUNICARE COME FITTIZIO")) {
                      /* _progrig := '' */
                      _progrig = "";
                      // * --- Select from aeoprig
                      m_cServer = m_Ctx.GetServer("aeoprig");
                      m_cPhName = m_Ctx.GetPhName("aeoprig");
                      if (Cursor_aeoprig!=null)
                        Cursor_aeoprig.Close();
                      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+"  and  ASPEDITO=1  and  IDESITO="+CPSql.SQLValueAdapter(CPLib.ToSQL(column16,"?",0,0,m_cServer, m_oParameters),m_cServer,column16)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_aeoprig.Eof())) {
                        /* _progrig := '' */
                        _progrig = "";
                        // * --- Read from aeopcanc
                        m_cServer = m_Ctx.GetServer("aeopcanc");
                        m_cPhName = m_Ctx.GetPhName("aeopcanc");
                        m_cSql = "";
                        m_cSql = m_cSql+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"C",15,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("AFILE"));
                        m_cSql = m_cSql+" and APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"C",25,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("APROG"));
                        if (m_Ctx.IsSharedTemp("aeopcanc")) {
                          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                        }
                        if (Read_Cursor!=null)
                          Read_Cursor.Close();
                        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                        if ( ! (Read_Cursor.Eof())) {
                          _progrig = Read_Cursor.GetString("PROGRES");
                          Read_Cursor.Next();
                          if ( ! (Read_Cursor.Eof())) {
                            Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_import_file_xlsx_esterni returns two or more records. This item should return only a record.");
                            CPStdCounter.Error(l_oErrorFault);
                          }
                          Read_Cursor.Close();
                        } else {
                          // Error: no record found!
                          _progrig = "";
                          Read_Cursor.Close();
                          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                        }
                        /* If not(Empty(_progrig)) */
                        if ( ! (CPLib.Empty(_progrig))) {
                          /* _prog := Utilities.GetAutonumber("PRGAEOPEXTR\'"+LRTrim(gAzienda)+"'",'',10) // progressivo opextrbo */
                          _prog = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAEOPEXTR\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                          /* nProgImp := Utilities.GetAutonumber("PROGAED\'"+LRTrim(gAzienda)+"'",0,15) // progressivo aeopig */
                          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAED\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                          // * --- Insert into aeoprig from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("aeoprig");
                          m_cPhName = m_Ctx.GetPhName("aeoprig");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000314")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                          m_cSql = m_cSql+GetFieldsName_00000314(m_Ctx,m_oWrInfo);
                          m_cSql = m_cSql+") values (";
                          m_cSql = m_cSql+""+CPLib.ToSQL(_prog,"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COINT"),"?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Year(Cursor_aeoprig.GetDate("ADATA")),"?",0,0)+", ";
                          m_cSql = m_cSql+m_oWrInfo.InsertValues();
                          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeoprig",true);
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
                          // * --- Write into opextrbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("opextrbo");
                          m_cPhName = m_Ctx.GetPhName("opextrbo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000315")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL(_prog,"C",10,0,m_cServer)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("CONNESINT"))+"";
                          m_cSql = m_cSql+" and DATAOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0,m_cServer),m_cServer,Cursor_aeoprig.GetDate("ADATA"))+"";
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
                          // * --- Write into personbo from values
                          m_Sql.RequireTransaction();
                          m_cServer = m_Ctx.GetServer("personbo");
                          m_cPhName = m_Ctx.GetPhName("personbo");
                          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                          m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000316")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                          m_cSql = m_cSql+" where ";
                          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("CONNESINT"))+"";
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
                        Cursor_aeoprig.Next();
                      }
                      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
                      Cursor_aeoprig.Close();
                      // * --- End Select
                      /* If Empty(_progrig) */
                      if (CPLib.Empty(_progrig)) {
                        /* nota := iif(Empty(nota),'Esito non trovato alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Esito non trovato alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Esito non trovato alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Esito non trovato alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                        /* _commit := False // ok alla commit */
                        _commit = false;
                      } else { // Else
                        /* nota := iif(Empty(nota),'Esito trovato per rinvio come estero alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Esito trovato per rinvio come estero alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Esito trovato per rinvio come estero alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Esito trovato per rinvio come estero alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      } // End If
                      /* Case column13='CANCELLARE IL CLIENTE NON ESISTE' */
                    } else if (CPLib.eqr(column13,"CANCELLARE IL CLIENTE NON ESISTE")) {
                      /* nota := iif(Empty(nota),'Nessuna azione intrapresa per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Nessuna azione intrapresa per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"Nessuna azione intrapresa per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Nessuna azione intrapresa per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      /* Case column13='MODIFICARE E COMUNICARE CON CODICE FISCALE VERIFICATO' */
                    } else if (CPLib.eqr(column13,"MODIFICARE E COMUNICARE CON CODICE FISCALE VERIFICATO")) {
                      /* SE variato CF o luogo di nascita o provincia devo prima registrare a storico la vecchi anagrafica. Altrimenti vari solo i dati dell'anagrafica. */
                      /* If not(Empty(column03)) or not(Empty(column08)) or not(Empty(column10)) */
                      if ( ! (CPLib.Empty(column03)) ||  ! (CPLib.Empty(column08)) ||  ! (CPLib.Empty(column10))) {
                        /* cProgSto := '' */
                        cProgSto = "";
                        // * --- Select from wersonbo
                        m_cServer = m_Ctx.GetServer("wersonbo");
                        m_cPhName = m_Ctx.GetPhName("wersonbo");
                        if (Cursor_wersonbo!=null)
                          Cursor_wersonbo.Close();
                        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+"  and  datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DATARETT,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DATARETT)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
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
                          /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
                          cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
                          // * --- Select from personbo
                          m_cServer = m_Ctx.GetServer("personbo");
                          m_cPhName = m_Ctx.GetPhName("personbo");
                          if (Cursor_personbo!=null)
                            Cursor_personbo.Close();
                          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(column02),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(column02))+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                          while ( ! (Cursor_personbo.Eof())) {
                            // * --- Insert into wersonbo from values
                            m_Sql.RequireTransaction();
                            m_cServer = m_Ctx.GetServer("wersonbo");
                            m_cPhName = m_Ctx.GetPhName("wersonbo");
                            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000325")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                            m_cSql = m_cSql+GetFieldsName_00000325(m_Ctx,m_oWrInfo);
                            m_cSql = m_cSql+") values (";
                            m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(column02,"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(gDataVaria,"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
                            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
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
                            /* Faccio la scrittura in base alle valorizzazioni iniziali e a seconda delle nuove. */
                            /* If personbo->TIPINTER='EE' */
                            if (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")) {
                              /* If LRTrim(column10)='EE' */
                              if (CPLib.eqr(CPLib.LRTrim(column10),"EE")) {
                                // * --- Write into personbo from values
                                m_Sql.RequireTransaction();
                                m_cServer = m_Ctx.GetServer("personbo");
                                m_cPhName = m_Ctx.GetPhName("personbo");
                                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000329")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(column03)?Cursor_personbo.GetString("CODFISC"):CPLib.LRTrim(column03)),"C",16,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL((CPLib.Empty(column08)?Cursor_personbo.GetString("NASSTATO"):CPLib.LRTrim(column08)),"C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL("","C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                                m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(column04)?Cursor_personbo.GetString("COGNOME"):CPLib.LRTrim(column04)),"C",26,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(column05)?Cursor_personbo.GetString("NOME"):CPLib.LRTrim(column05)),"C",25,0,m_cServer)+", ";
                                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                m_cSql = m_cSql+" where ";
                                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
                                // * --- Write into personbo from values
                                m_Sql.RequireTransaction();
                                m_cServer = m_Ctx.GetServer("personbo");
                                m_cPhName = m_Ctx.GetPhName("personbo");
                                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000032A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(column03)?Cursor_personbo.GetString("CODFISC"):CPLib.LRTrim(column03)),"C",16,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL("","C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL((CPLib.Empty(column08)?Cursor_personbo.GetString("NASCOMUN"):CPLib.LRTrim(column08)),"C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL((CPLib.Empty(column10)?Cursor_personbo.GetString("TIPINTER"):column10),"C",2,0,m_cServer)+", ";
                                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                                m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(column04)?Cursor_personbo.GetString("COGNOME"):CPLib.LRTrim(column04)),"C",26,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(column05)?Cursor_personbo.GetString("NOME"):CPLib.LRTrim(column05)),"C",25,0,m_cServer)+", ";
                                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                m_cSql = m_cSql+" where ";
                                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
                              /* If LRTrim(column10)='EE' */
                              if (CPLib.eqr(CPLib.LRTrim(column10),"EE")) {
                                // * --- Write into personbo from values
                                m_Sql.RequireTransaction();
                                m_cServer = m_Ctx.GetServer("personbo");
                                m_cPhName = m_Ctx.GetPhName("personbo");
                                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000032C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(column03)?Cursor_personbo.GetString("CODFISC"):CPLib.LRTrim(column03)),"C",16,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL((CPLib.Empty(column08)?Cursor_personbo.GetString("NASSTATO"):CPLib.LRTrim(column08)),"C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL("","C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL("EE","C",2,0,m_cServer)+", ";
                                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                                m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(column04)?Cursor_personbo.GetString("COGNOME"):CPLib.LRTrim(column04)),"C",26,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(column05)?Cursor_personbo.GetString("NOME"):CPLib.LRTrim(column05)),"C",25,0,m_cServer)+", ";
                                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                m_cSql = m_cSql+" where ";
                                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
                                // * --- Write into personbo from values
                                m_Sql.RequireTransaction();
                                m_cServer = m_Ctx.GetServer("personbo");
                                m_cPhName = m_Ctx.GetPhName("personbo");
                                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000032D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                                m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL((CPLib.Empty(column03)?Cursor_personbo.GetString("CODFISC"):CPLib.LRTrim(column03)),"C",16,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL("","C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL((CPLib.Empty(column08)?Cursor_personbo.GetString("NASCOMUN"):CPLib.LRTrim(column08)),"C",30,0,m_cServer)+", ";
                                m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL((CPLib.Empty(column10)?Cursor_personbo.GetString("TIPINTER"):column10),"C",2,0,m_cServer)+", ";
                                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                                m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL((CPLib.Empty(column04)?Cursor_personbo.GetString("COGNOME"):CPLib.LRTrim(column04)),"C",26,0,m_cServer)+", ";
                                m_cSql = m_cSql+"NOME = "+CPLib.ToSQL((CPLib.Empty(column05)?Cursor_personbo.GetString("NOME"):CPLib.LRTrim(column05)),"C",25,0,m_cServer)+", ";
                                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                                m_cSql = m_cSql+" where ";
                                m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
                            Cursor_personbo.Next();
                          }
                          m_cConnectivityError = Cursor_personbo.ErrorMessage();
                          Cursor_personbo.Close();
                          // * --- End Select
                        } // End If
                      } else { // Else
                        /* _commit := False // ok alla commit */
                        _commit = false;
                        /* nota := iif(Empty(nota),'Nessuna variazione del soggetto per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Nessuna variazione del soggetto per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Nessuna variazione del soggetto per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Nessuna variazione del soggetto per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      } // End If
                      /* cProgSto := '' */
                      cProgSto = "";
                      // * --- Select from aeoprig
                      m_cServer = m_Ctx.GetServer("aeoprig");
                      m_cPhName = m_Ctx.GetPhName("aeoprig");
                      if (Cursor_aeoprig!=null)
                        Cursor_aeoprig.Close();
                      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+"  and  ASPEDITO=1  and  IDESITO="+CPSql.SQLValueAdapter(CPLib.ToSQL(column16,"?",0,0,m_cServer, m_oParameters),m_cServer,column16)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_aeoprig.Eof())) {
                        // * --- Write into aeoprig from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("aeoprig");
                        m_cPhName = m_Ctx.GetPhName("aeoprig");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000332")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
                        m_cSql = m_cSql+"RSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                        m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                        m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("IDBASE"))+"";
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
                        /* cProgSto := cProgSto+'A' */
                        cProgSto = cProgSto+"A";
                        Cursor_aeoprig.Next();
                      }
                      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
                      Cursor_aeoprig.Close();
                      // * --- End Select
                      /* If Empty(cProgSto) or Len(cProgSto)>1 */
                      if (CPLib.Empty(cProgSto) || CPLib.gt(CPLib.Len(cProgSto),1)) {
                        /* _commit := False // ok alla commit */
                        _commit = false;
                        /* nota := iif(Empty(nota),'Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      } else { // Else
                        /* nota := iif(Empty(nota),'Record trovato e preparata la rettifica per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Record trovato e preparata la rettifica per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                        nota = (CPLib.Empty(nota)?"Record trovato e preparata la rettifica per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Record trovato e preparata la rettifica per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      } // End If
                    } else { // Otherwise
                      /* nota := iif(Empty(nota),'Valore non previsto alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore non previsto alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"Valore non previsto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore non previsto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                      /* If cell_count<32 */
                      if (CPLib.lt(cell_count,32)) {
                        /* _commit := False // ok alla commit */
                        _commit = false;
                      } // End If
                    } // End Case
                  } // End Case
                  /* Case cell_type=3 */
                } else if (CPLib.eqr(cell_type,3)) {
                  /* nota := iif(Empty(nota),'Formula alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Formula alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Formula alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Formula alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                  /* _commit := False // ok alla commit */
                  _commit = false;
                  /* Case cell_type=4 */
                } else if (CPLib.eqr(cell_type,4)) {
                  /* Case cell_count=19 */
                  if (CPLib.eqr(cell_count,19)) {
                    /* column03 := '' // CF */
                    column03 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (CF vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (CF vuoto)");
                    /* Case cell_count=21 */
                  } else if (CPLib.eqr(cell_count,21)) {
                    /* column05 := '' // nome */
                    column05 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (nome vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (nome vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (nome vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (nome vuoto)");
                    /* Case cell_count=22 */
                  } else if (CPLib.eqr(cell_count,22)) {
                    /* column04 := '' // Cognome */
                    column04 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (cognome vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (cognome vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (cognome vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (cognome vuoto)");
                    /* Case cell_count=24 */
                  } else if (CPLib.eqr(cell_count,24)) {
                    /* column08 := '' // comune di nascita */
                    column08 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (comune vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (comune vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (comune vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (comune vuoto)");
                    /* column09 := '' // nazione di nascita */
                    column09 = "";
                    /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (stato vuoto)',nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))+' (stato vuoto)') // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (stato vuoto)":nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0))+" (stato vuoto)");
                    /* Case cell_count=26 */
                  } else if (CPLib.eqr(cell_count,26)) {
                    /* column10 := '' // provincia di nascita */
                    column10 = "";
                    /* column11 := '' // provincia di nascita */
                    column11 = "";
                    /* Case cell_count=31 */
                  } else if (CPLib.eqr(cell_count,31)) {
                    /* column13 := '' // Descrizione */
                    column13 = "";
                    /* Status Msg 'Sto leggendo riga: %1 del foglio %2.'+Chr(13)+Chr(10)+"Elaborazione in corso..."+Chr(13)+Chr(10)+'Tipo cella: %3 valore letto: %4' */
                    m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Sto leggendo riga: %1 del foglio %2."+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso..."+CPLib.Chr(13)+CPLib.Chr(10)+"Tipo cella: %3 valore letto: %4",riga_letta,foglio,cell_type,column13));
                    /* Presa la variabile CProgSto a caso, solo per verificare se viene modificato un solo record altrimenti blocco la routine */
                    /* cProgSto := '' */
                    cProgSto = "";
                    // * --- Select from aeoprig
                    m_cServer = m_Ctx.GetServer("aeoprig");
                    m_cPhName = m_Ctx.GetPhName("aeoprig");
                    if (Cursor_aeoprig!=null)
                      Cursor_aeoprig.Close();
                    Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+"  and  ASPEDITO=1  and  IDESITO="+CPSql.SQLValueAdapter(CPLib.ToSQL(column16,"?",0,0,m_cServer, m_oParameters),m_cServer,column16)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                    while ( ! (Cursor_aeoprig.Eof())) {
                      // * --- Write into aeoprig from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aeoprig");
                      m_cPhName = m_Ctx.GetPhName("aeoprig");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000034F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
                      m_cSql = m_cSql+"RSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                      m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                      m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("IDBASE"))+"";
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
                      /* cProgSto := cProgSto+'A' */
                      cProgSto = cProgSto+"A";
                      Cursor_aeoprig.Next();
                    }
                    m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
                    Cursor_aeoprig.Close();
                    // * --- End Select
                    /* If Empty(cProgSto) or Len(cProgSto)>1 */
                    if (CPLib.Empty(cProgSto) || CPLib.gt(CPLib.Len(cProgSto),1)) {
                      /* _commit := False // ok alla commit */
                      _commit = false;
                      /* nota := iif(Empty(nota),'Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                    } else { // Else
                      /* nota := iif(Empty(nota),'Record trovato e preparata la rettifica per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Record trovato e preparata la rettifica per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                      nota = (CPLib.Empty(nota)?"Record trovato e preparata la rettifica per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Record trovato e preparata la rettifica per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                    } // End If
                  } else { // Otherwise
                    /* nota := iif(Empty(nota),'Valore vuoto alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore vuoto alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                    nota = (CPLib.Empty(nota)?"Valore vuoto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore vuoto alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                    /* If cell_count<32 */
                    if (CPLib.lt(cell_count,32)) {
                      /* _commit := False // ok alla commit */
                      _commit = false;
                    } // End If
                  } // End Case
                  /* Case cell_type=0 */
                } else if (CPLib.eqr(cell_type,0)) {
                  /* tipo buleano
                     da definire il comportamento */
                  /* nota := iif(Empty(nota),'Valore buleano alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore buleano alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore buleano alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore buleano alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                  /* _commit := False // ok alla commit */
                  _commit = false;
                } else { // Otherwise
                  /* nota := iif(Empty(nota),'Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Valore non definito alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Valore non definito alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                  /* _commit := False // ok alla commit */
                  _commit = false;
                } // End Case
              } // End If
              /* Se l'interetor delle celle è più corto di quanto doveva essere ipotizzo che sia un rivio diretto cosi come è senza variazioni. Vedi casistica colonna 31 vuota. */
              /* If cell_count<30 and not(cells.hasNext()) */
              if (CPLib.lt(cell_count,30) &&  ! (cells.hasNext())) {
                /* column13 := '' // Descrizione */
                column13 = "";
                /* Status Msg 'Sto leggendo riga: %1 del foglio %2.'+Chr(13)+Chr(10)+"Elaborazione in corso..."+Chr(13)+Chr(10)+'Tipo cella: %3 valore letto: %4' */
                m_MessageSink.SendMessage(CPLib.FormatMsg(m_Ctx,"Sto leggendo riga: %1 del foglio %2."+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso..."+CPLib.Chr(13)+CPLib.Chr(10)+"Tipo cella: %3 valore letto: %4",riga_letta,foglio,cell_type,column13));
                /* Presa la variabile CProgSto a caso, solo per verificare se viene modificato un solo record altrimenti blocco la routine */
                /* cProgSto := '' */
                cProgSto = "";
                // * --- Select from aeoprig
                m_cServer = m_Ctx.GetServer("aeoprig");
                m_cPhName = m_Ctx.GetPhName("aeoprig");
                if (Cursor_aeoprig!=null)
                  Cursor_aeoprig.Close();
                Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(column02,"?",0,0,m_cServer, m_oParameters),m_cServer,column02)+"  and  ASPEDITO=1  and  IDESITO="+CPSql.SQLValueAdapter(CPLib.ToSQL(column16,"?",0,0,m_cServer, m_oParameters),m_cServer,column16)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_aeoprig.Eof())) {
                  // * --- Write into aeoprig from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aeoprig");
                  m_cPhName = m_Ctx.GetPhName("aeoprig");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000364")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(w_DATARETT,"D",8,0)+", ";
                  m_cSql = m_cSql+"RSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                  m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL("","C",25,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("IDBASE"))+"";
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
                  /* cProgSto := cProgSto+'A' */
                  cProgSto = cProgSto+"A";
                  Cursor_aeoprig.Next();
                }
                m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
                Cursor_aeoprig.Close();
                // * --- End Select
                /* If Empty(cProgSto) or Len(cProgSto)>1 */
                if (CPLib.Empty(cProgSto) || CPLib.gt(CPLib.Len(cProgSto),1)) {
                  /* _commit := False // ok alla commit */
                  _commit = false;
                  /* nota := iif(Empty(nota),'Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Nessun record trovato o più di uno riscontrato per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                } else { // Else
                  /* nota := iif(Empty(nota),'Record trovato e preparata la rettifica per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0)),nota+' Record trovato e preparata la rettifica per la fase 2 alla colonna '+LRTrim(Str(cell_count,2,0))) // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"Record trovato e preparata la rettifica per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)):nota+" Record trovato e preparata la rettifica per la fase 2 alla colonna "+CPLib.LRTrim(CPLib.Str(cell_count,2,0)));
                } // End If
                System.out.println("Lettura foglio "+_i+" di "+conta+" riga letta "+riga_letta+" tipo: "+cell_type+" descrizione: *"+column13+"*");
              } // End If
              /* If cell_count=31 */
              if (CPLib.eqr(cell_count,31)) {
                System.out.println("Lettura foglio "+_i+" di "+conta+" riga letta "+riga_letta+" tipo: "+cell_type+" descrizione: *"+column13+"*");
              } // End If
            } // End While
            /* If riga_letta>1 */
            if (CPLib.gt(riga_letta,1)) {
              /* riga_letta_c := Str(riga_letta,9,0) // riga letta del file Excel Character */
              riga_letta_c = CPLib.Str(riga_letta,9,0);
              /* foglio_c := Str(foglio,2,0) // foglio letto Character */
              foglio_c = CPLib.Str(foglio,2,0);
              //Creo il record da scrivere
              row2 = (XSSFRow) sheet2.createRow(r);
              cell2 = (XSSFCell) row2.createCell(0);
              cell2.setCellValue(CPLib.LRTrim(column14));
              cell2 = (XSSFCell) row2.createCell(1);
              cell2.setCellValue(CPLib.LRTrim(column15));
              cell2 = (XSSFCell) row2.createCell(2);
              cell2.setCellValue(CPLib.LRTrim(column16));
              cell2 = (XSSFCell) row2.createCell(3);
              cell2.setCellValue(CPLib.LRTrim(column01));
              cell2 = (XSSFCell) row2.createCell(4);
              cell2.setCellValue(CPLib.LRTrim(column02));
              cell2 = (XSSFCell) row2.createCell(5);
              cell2.setCellValue(CPLib.LRTrim(column03));
              cell2 = (XSSFCell) row2.createCell(6);
              cell2.setCellValue(CPLib.LRTrim(column04));
              cell2 = (XSSFCell) row2.createCell(7);
              cell2.setCellValue(CPLib.LRTrim(column05));
              cell2 = (XSSFCell) row2.createCell(8);
              cell2.setCellValue(CPLib.LRTrim(column06));
              cell2 = (XSSFCell) row2.createCell(9);
              cell2.setCellValue(CPLib.LRTrim(column07));
              cell2 = (XSSFCell) row2.createCell(10);
              cell2.setCellValue(CPLib.LRTrim(column08));
              cell2 = (XSSFCell) row2.createCell(11);
              cell2.setCellValue(CPLib.LRTrim(column09));
              cell2 = (XSSFCell) row2.createCell(12);
              cell2.setCellValue(CPLib.LRTrim(column10));
              cell2 = (XSSFCell) row2.createCell(13);
              cell2.setCellValue(CPLib.LRTrim(column11));
              cell2 = (XSSFCell) row2.createCell(14);
              cell2.setCellValue(CPLib.LRTrim(column12));
              cell2 = (XSSFCell) row2.createCell(15);
              cell2.setCellValue(CPLib.LRTrim(column13));
              cell2 = (XSSFCell) row2.createCell(16);
              cell2.setCellValue(CPLib.LRTrim(nota));
              cell2 = (XSSFCell) row2.createCell(17);
              cell2.setCellValue(CPLib.LRTrim(riga_letta_c));
              cell2 = (XSSFCell) row2.createCell(18);
              cell2.setCellValue(CPLib.LRTrim(foglio_c));
              r++;
            } // End If
          } // End While
          _i++;
        } // End While
        /* If not(_commit) */
        if ( ! (_commit)) {
          // Transaction Error
          cTry00000297msg = CPLib.FormatMsg(m_Ctx,"errore xlsx");
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"errore xlsx"));
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000297status,0)) {
          m_Sql.SetTransactionStatus(nTry00000297status,cTry00000297msg);
        }
      }
      /* Status Msg 'Ridimensionamento delle celle. '+Chr(13)+Chr(10)+"Elaborazione in corso..." */
      m_MessageSink.SendMessage("Ridimensionamento delle celle. "+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...");
      //Ridimensiono le colonne in base al contenuto
      sheet2.autoSizeColumn(0);
      sheet2.autoSizeColumn(1);
      sheet2.autoSizeColumn(2);
      sheet2.autoSizeColumn(3);
      sheet2.autoSizeColumn(4);
      sheet2.autoSizeColumn(5);
      sheet2.autoSizeColumn(6);
      sheet2.autoSizeColumn(7);
      sheet2.autoSizeColumn(8);
      sheet2.autoSizeColumn(9);
      sheet2.autoSizeColumn(10);
      sheet2.autoSizeColumn(11);
      sheet2.autoSizeColumn(12);
      sheet2.autoSizeColumn(13);
      sheet2.autoSizeColumn(14);
      sheet2.autoSizeColumn(15);
      sheet2.autoSizeColumn(16);
      sheet2.autoSizeColumn(17);
      sheet2.autoSizeColumn(18);
      /* Status Msg 'Scrittura file Excel. '+Chr(13)+Chr(10)+"Elaborazione in corso..." */
      m_MessageSink.SendMessage("Scrittura file Excel. "+CPLib.Chr(13)+CPLib.Chr(10)+"Elaborazione in corso...");
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefileoutput));
      
      //write this workbook to an Outputstream.
      wb2.write(fileOut);
      fileOut.flush();
      fileOut.close();
    } finally {
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
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
  void Page_6() throws Exception {
    CPResultSet Cursor_fraziobo=null;
    try {
      /* column01 Char(500) */
      String column01;
      column01 = CPLib.Space(500);
      /* column02 Char(500) */
      String column02;
      column02 = CPLib.Space(500);
      /* column03 Char(500) */
      String column03;
      column03 = CPLib.Space(500);
      /* column04 Char(500) */
      String column04;
      column04 = CPLib.Space(500);
      /* column05 Char(500) */
      String column05;
      column05 = CPLib.Space(500);
      /* column06 Char(500) */
      String column06;
      column06 = CPLib.Space(500);
      /* column07 Char(500) */
      String column07;
      column07 = CPLib.Space(500);
      /* column08 Char(500) */
      String column08;
      column08 = CPLib.Space(500);
      /* column01_num Numeric(15, 2) */
      double column01_num;
      column01_num = 0;
      /* column02_num Numeric(15, 2) */
      double column02_num;
      column02_num = 0;
      /* column03_num Numeric(15, 2) */
      double column03_num;
      column03_num = 0;
      /* column04_num Numeric(15, 2) */
      double column04_num;
      column04_num = 0;
      /* column05_num Numeric(15, 2) */
      double column05_num;
      column05_num = 0;
      /* column06_num Numeric(15, 2) */
      double column06_num;
      column06_num = 0;
      /* column07_num Numeric(15, 2) */
      double column07_num;
      column07_num = 0;
      /* column08_num Numeric(15, 2) */
      double column08_num;
      column08_num = 0;
      /* foglio Numeric(2, 0) // foglio letto */
      double foglio;
      foglio = 0;
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      double riga_letta;
      riga_letta = 0;
      /* riga_letta_c Char(9) // riga letta del file Excel Character */
      String riga_letta_c;
      riga_letta_c = CPLib.Space(9);
      /* w_DATARETT Date // data rettifica */
      java.sql.Date w_DATARETT;
      w_DATARETT = CPLib.NullDate();
      /* cProgSto Char(15) // progressivo wersonbo del giorno */
      String cProgSto;
      cProgSto = CPLib.Space(15);
      /* _idbase Char(10) // idbase letto */
      String _idbase;
      _idbase = CPLib.Space(10);
      /* _statoreg Char(1) // stato dell'operazione */
      String _statoreg;
      _statoreg = CPLib.Space(1);
      /* del_ope Bool // operazione già cancellata */
      boolean del_ope;
      del_ope = false;
      /* del_ope := False // operazione già cancellata */
      del_ope = false;
      /* riga_letta := 0 // riga letta del file Excel */
      riga_letta = CPLib.Round(0,0);
      //base
      InputStream ExcelFileToRead = new FileInputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefile));
      XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
      
      conta = wb.getNumberOfSheets();
      
      //XSSFWorkbook test = new XSSFWorkbook(); 
      
      //XSSFSheet sheet = wb.getSheetAt(0);
      XSSFRow row; 
      XSSFCell cell;
      
      XSSFRow row2; 
      XSSFCell cell2;
      
      //Iterator rows = sheet.rowIterator();
      // creo il contenitore dei fogli
      XSSFWorkbook wb2 = new XSSFWorkbook();
      XSSFSheet sheet2 = wb2.createSheet(sheetName) ;
      //Azzero i contatori di fogli letti e righe scritte
      _i = 0;
      r=0;
      //Creo il record da scrivere
      row2 = (XSSFRow) sheet2.createRow(r);
      //scrivo la riga di intestazione
      cell2 = (XSSFCell) row2.createCell(0);
      cell2.setCellValue("NOPERAZIONE");
      cell2 = (XSSFCell) row2.createCell(1);
      cell2.setCellValue("TIPO");
      cell2 = (XSSFCell) row2.createCell(2);
      cell2.setCellValue("DATA_OP");
      cell2 = (XSSFCell) row2.createCell(3);
      cell2.setCellValue("IMPORTO");
      cell2 = (XSSFCell) row2.createCell(4);
      cell2.setCellValue("NDG_CLIENTE");
      cell2 = (XSSFCell) row2.createCell(5);
      cell2.setCellValue("Note");
      cell2 = (XSSFCell) row2.createCell(6);
      cell2.setCellValue("Riga");
      r++;
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000039Fstatus;
      nTry0000039Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000039Fmsg;
      cTry0000039Fmsg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Lettura del file in corso. Elaborazione in corso...' */
        gMsgImp = "Lettura del file in corso. Elaborazione in corso...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* While _i < conta */
        while (CPLib.lt(_i,conta)) {
          //Apro uno ad uno i fogli del file Excel
          XSSFSheet sheet = wb.getSheetAt(_i);
          //Mi definisco un oggetto che contiene tutte le righe
          Iterator rows = sheet.rowIterator();
          //_righe = sheet.getLastRowNum()+1;
          //_y = 1;
          /* foglio := _i // foglio letto */
          foglio = CPLib.Round(_i,0);
          /* While rows.hasNext() */
          while (rows.hasNext()) {
            //scorro le righe
            row=(XSSFRow) rows.next();
            //Mi definisco un oggetto che contiene tutte le celle della riga letta
            Iterator cells = row.cellIterator();
            /* cell_count := 0 */
            cell_count = CPLib.Round(0,0);
            /* riga_letta := riga_letta+1 // riga letta del file Excel */
            riga_letta = CPLib.Round(riga_letta+1,0);
            /* nota := '' // nota del eventuale problema */
            nota = "";
            /* modifica := True // ok alla modifica dei dati */
            modifica = true;
            /* While cells.hasNext() and riga_letta>1 */
            while (cells.hasNext() && CPLib.gt(riga_letta,1)) {
              //scorro le celle della riga
              cell=(XSSFCell) cells.next();
              /* cell_count := cell_count+1 */
              cell_count = CPLib.Round(cell_count+1,0);
              /* cell_type := cell.getCellType().ordinal() */
              cell_type = cell.getCellType().ordinal();
              /* Case cell_type=1 */
              if (CPLib.eqr(cell_type,1)) {
                /* Case cell_count=1 */
                if (CPLib.eqr(cell_count,1)) {
                  /* column01_num := cell.getNumericCellValue() */
                  column01_num = CPLib.Round(cell.getNumericCellValue(),2);
                  /* column01 := Right(Replicate('0',11)+LRTrim(Str(column01_num,11,0)),11) */
                  column01 = CPLib.Right(CPLib.Replicate("0",11)+CPLib.LRTrim(CPLib.Str(column01_num,11,0)),11);
                  /* Case cell_count=2 */
                } else if (CPLib.eqr(cell_count,2)) {
                  /* column02_num := cell.getNumericCellValue() */
                  column02_num = CPLib.Round(cell.getNumericCellValue(),2);
                  /* column02 := Str(column02_num,15,2) */
                  column02 = CPLib.Str(column02_num,15,2);
                  /* Case cell_count=3 */
                } else if (CPLib.eqr(cell_count,3)) {
                  /* column03_num := cell.getNumericCellValue() */
                  column03_num = CPLib.Round(cell.getNumericCellValue(),2);
                  /* column03 := sdf.format(cell.getDateCellValue()) */
                  column03 = sdf.format(cell.getDateCellValue());
                  /* Case cell_count=4 */
                } else if (CPLib.eqr(cell_count,4)) {
                  /* column04_num := cell.getNumericCellValue() */
                  column04_num = CPLib.Round(cell.getNumericCellValue(),2);
                  /* column04 := Str(column04_num,15,2) */
                  column04 = CPLib.Str(column04_num,15,2);
                  /* Case cell_count=5 */
                } else if (CPLib.eqr(cell_count,5)) {
                  /* column05_num := cell.getNumericCellValue() */
                  column05_num = CPLib.Round(cell.getNumericCellValue(),2);
                  /* column05 := Str(column05_num,15,2) */
                  column05 = CPLib.Str(column05_num,15,2);
                } // End Case
                /* Case cell_type=2 */
              } else if (CPLib.eqr(cell_type,2)) {
                /* Case cell_count=1 */
                if (CPLib.eqr(cell_count,1)) {
                  /* column01 := cell.getStringCellValue() */
                  column01 = cell.getStringCellValue();
                  /* Case cell_count=2 */
                } else if (CPLib.eqr(cell_count,2)) {
                  /* column02 := cell.getStringCellValue() */
                  column02 = cell.getStringCellValue();
                  /* Case cell_count=3 */
                } else if (CPLib.eqr(cell_count,3)) {
                  /* column03 := cell.getStringCellValue() */
                  column03 = cell.getStringCellValue();
                  /* Case cell_count=4 */
                } else if (CPLib.eqr(cell_count,4)) {
                  /* column04 := cell.getStringCellValue() */
                  column04 = cell.getStringCellValue();
                  /* Case cell_count=5 */
                } else if (CPLib.eqr(cell_count,5)) {
                  /* column05 := cell.getStringCellValue() */
                  column05 = cell.getStringCellValue();
                } // End Case
                /* Case cell_type=3 */
              } else if (CPLib.eqr(cell_type,3)) {
              } else { // Otherwise
              } // End Case
              /* If cell_count=5 */
              if (CPLib.eqr(cell_count,5)) {
                /* _idbase := '' */
                _idbase = "";
                /* _statoreg := '' */
                _statoreg = "";
                // * --- Select from fraziobo
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                if (Cursor_fraziobo!=null)
                  Cursor_fraziobo.Close();
                Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDBASE,STATOREG  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(column01,"?",0,0,m_cServer, m_oParameters),m_cServer,column01)+"  and  DATAOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.CharToDate(column03),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.CharToDate(column03))+"  and  TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(column04_num,"?",0,0,m_cServer, m_oParameters),m_cServer,column04_num)+"*100  and  CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(column05,"?",0,0,m_cServer, m_oParameters),m_cServer,column05)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_fraziobo.Eof())) {
                  /* If fraziobo->STATOREG = '0' or fraziobo->STATOREG = '1' */
                  if (CPLib.eqr(Cursor_fraziobo.GetString("STATOREG"),"0") || CPLib.eqr(Cursor_fraziobo.GetString("STATOREG"),"1")) {
                    /* _idbase := fraziobo->IDBASE */
                    _idbase = Cursor_fraziobo.GetString("IDBASE");
                    /* _statoreg := fraziobo->STATOREG */
                    _statoreg = Cursor_fraziobo.GetString("STATOREG");
                  } // End If
                  Cursor_fraziobo.Next();
                }
                m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
                Cursor_fraziobo.Close();
                // * --- End Select
                /* nota := iif(Empty(nota),'',nota)+iif(Empty(_idbase),'Operazione non trovata','Operazione trovata') // nota del eventuale problema */
                nota = (CPLib.Empty(nota)?"":nota)+(CPLib.Empty(_idbase)?"Operazione non trovata":"Operazione trovata");
                /* If At(_statoreg,"|0|1") > 0 */
                if (CPLib.gt(CPLib.At(_statoreg,"|0|1"),0)) {
                  // * --- Write into fraziobo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("fraziobo");
                  m_cPhName = m_Ctx.GetPhName("fraziobo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"000003CA")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("2","C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(oggi,"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer),m_cServer,_idbase)+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  {
                    if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_import_file_xlsx_esterni: Write on fraziobo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                      }
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
                  /* nota := iif(Empty(nota),'',nota)+' - Operazione cancellata.' // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"":nota)+" - Operazione cancellata.";
                } else { // Else
                  /* nota := iif(Empty(nota),'',nota)+' - Operazione già cancellata.' // nota del eventuale problema */
                  nota = (CPLib.Empty(nota)?"":nota)+" - Operazione già cancellata.";
                  /* del_ope := True // operazione già cancellata */
                  del_ope = true;
                } // End If
              } // End If
            } // End While
            /* gMsgImp := 'Sto leggendo riga: '+LRTrim(Str(riga_letta,10,0))+". Elaborazione in corso ...." */
            gMsgImp = "Sto leggendo riga: "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0))+". Elaborazione in corso ....";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If riga_letta>1 */
            if (CPLib.gt(riga_letta,1)) {
              /* riga_letta_c := Str(riga_letta,9,0) */
              riga_letta_c = CPLib.Str(riga_letta,9,0);
              //Creo il record da scrivere
              row2 = (XSSFRow) sheet2.createRow(r);
              cell2 = (XSSFCell) row2.createCell(0);
              cell2.setCellValue(CPLib.LRTrim(column01));
              cell2 = (XSSFCell) row2.createCell(1);
              cell2.setCellValue(CPLib.LRTrim(column02));
              cell2 = (XSSFCell) row2.createCell(2);
              cell2.setCellValue(CPLib.LRTrim(column03));
              cell2 = (XSSFCell) row2.createCell(3);
              cell2.setCellValue(CPLib.LRTrim(column04));
              cell2 = (XSSFCell) row2.createCell(4);
              cell2.setCellValue(CPLib.LRTrim(column05));
              cell2 = (XSSFCell) row2.createCell(5);
              cell2.setCellValue(CPLib.LRTrim(nota));
              cell2 = (XSSFCell) row2.createCell(6);
              cell2.setCellValue(CPLib.LRTrim(riga_letta_c));
              r++;
            } // End If
          } // End While
          _i++;
        } // End While
        /* la rimetto a False cosi salvo la modifca tanto non me ne frega che siano già cancellate */
        /* del_ope := False // operazione già cancellata */
        del_ope = false;
        /* If del_ope */
        if (del_ope) {
          // Transaction Error
          cTry0000039Fmsg = CPLib.FormatMsg(m_Ctx,"Impossibile cancellare un'operazione frazionata già cancellata o copia di modifica!");
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Impossibile cancellare un'operazione frazionata già cancellata o copia di modifica!"));
          throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Impossibile cancellare un'operazione frazionata già cancellata o copia di modifica!"));
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* Error Msg 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        m_cLastMsgError = "Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000039Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000039Fstatus,cTry0000039Fmsg);
        }
      }
      // Ridimensiono le colonne
      _i=0;
      /* While _i<7 */
      while (CPLib.lt(_i,7)) {
        /* gMsgImp := 'Autodimensionamento delle celle della colonna '+Str(_i,1,0)+' in base al contenuto. Elaborazione in corso...' */
        gMsgImp = "Autodimensionamento delle celle della colonna "+CPLib.Str(_i,1,0)+" in base al contenuto. Elaborazione in corso...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        //Ridimensiono le colonne in base al contenuto
        _i++;
      } // End While
      /* gMsgImp := 'Scrittura del file di esito. Elaborazione in corso...' */
      gMsgImp = "Scrittura del file di esito. Elaborazione in corso...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefileoutput));
      
      //write this workbook to an Outputstream.
      wb2.write(fileOut);
      fileOut.flush();
      fileOut.close();
      /* gMsgImp := 'Elaborazione terminata!' */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_7() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_fraziobo=null;
    try {
      /* column01 Char(500) */
      String column01;
      column01 = CPLib.Space(500);
      /* column02 Char(500) */
      String column02;
      column02 = CPLib.Space(500);
      /* column03 Char(500) */
      String column03;
      column03 = CPLib.Space(500);
      /* column04 Char(500) */
      String column04;
      column04 = CPLib.Space(500);
      /* column05 Char(500) */
      String column05;
      column05 = CPLib.Space(500);
      /* column06 Char(500) */
      String column06;
      column06 = CPLib.Space(500);
      /* column07 Char(500) */
      String column07;
      column07 = CPLib.Space(500);
      /* column08 Char(500) */
      String column08;
      column08 = CPLib.Space(500);
      /* column01_num Numeric(15, 2) */
      double column01_num;
      column01_num = 0;
      /* column02_num Numeric(15, 2) */
      double column02_num;
      column02_num = 0;
      /* column03_num Numeric(15, 2) */
      double column03_num;
      column03_num = 0;
      /* column04_num Numeric(15, 2) */
      double column04_num;
      column04_num = 0;
      /* column05_num Numeric(15, 2) */
      double column05_num;
      column05_num = 0;
      /* column06_num Numeric(15, 2) */
      double column06_num;
      column06_num = 0;
      /* column07_num Numeric(15, 2) */
      double column07_num;
      column07_num = 0;
      /* column08_num Numeric(15, 2) */
      double column08_num;
      column08_num = 0;
      /* _idbase Char(10) // idbase letto */
      String _idbase;
      _idbase = CPLib.Space(10);
      /* _statoreg Char(1) // stato dell'operazione */
      String _statoreg;
      _statoreg = CPLib.Space(1);
      /* riga_letta Numeric(9, 0) // riga letta del file Excel */
      double riga_letta;
      riga_letta = 0;
      /* riga_letta_c Char(9) // riga letta del file Excel Character */
      String riga_letta_c;
      riga_letta_c = CPLib.Space(9);
      /* cNewProg Char(10) */
      String cNewProg;
      cNewProg = CPLib.Space(10);
      /* _idereg Char(20) */
      String _idereg;
      _idereg = CPLib.Space(20);
      /* _idbase2 Char(10) */
      String _idbase2;
      _idbase2 = CPLib.Space(10);
      /* _cab Char(6) */
      String _cab;
      _cab = CPLib.Space(6);
      /* stringaflagrap2 Char(10) */
      String stringaflagrap2;
      stringaflagrap2 = CPLib.Space(10);
      /* _flagrap2 Char(1) */
      String _flagrap2;
      _flagrap2 = CPLib.Space(1);
      /* _desccit Char(30) */
      String _desccit;
      _desccit = CPLib.Space(30);
      // creo il contenitore dei fogli
      XSSFWorkbook wb2 = new XSSFWorkbook();
      XSSFSheet sheet2 = wb2.createSheet(sheetName) ;
      XSSFRow row2; 
      XSSFCell cell2;
      //Azzero i contatori di fogli letti e righe scritte
      _i = 0;
      r=0;
      //Creo il record da scrivere
      row2 = (XSSFRow) sheet2.createRow(r);
      //scrivo la riga di intestazione
      cell2 = (XSSFCell) row2.createCell(0);
      cell2.setCellValue("NOPERAZIONE");
      cell2 = (XSSFCell) row2.createCell(1);
      cell2.setCellValue("CODICE AGENZIA");
      cell2 = (XSSFCell) row2.createCell(2);
      cell2.setCellValue("AGENZIA");
      cell2 = (XSSFCell) row2.createCell(3);
      cell2.setCellValue("INDIRIZZO");
      cell2 = (XSSFCell) row2.createCell(4);
      cell2.setCellValue("CITTA");
      cell2 = (XSSFCell) row2.createCell(5);
      cell2.setCellValue("PROVINCIA");
      cell2 = (XSSFCell) row2.createCell(6);
      cell2.setCellValue("MCTN");
      cell2 = (XSSFCell) row2.createCell(7);
      cell2.setCellValue("Note");
      cell2 = (XSSFCell) row2.createCell(8);
      cell2.setCellValue("Riga");
      r++;
      /* riga_letta := 0 // riga letta del file Excel */
      riga_letta = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000403status;
      nTry00000403status = m_Sql.GetTransactionStatus();
      String cTry00000403msg;
      cTry00000403msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgImp := 'Lettura del file in corso. Elaborazione in corso...' */
        gMsgImp = "Lettura del file in corso. Elaborazione in corso...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* stringaflagrap2 := 'JLMNOTUV?' // stringa di valori di flagrap2 */
        stringaflagrap2 = "JLMNOTUV?";
        // Apre il file CSV
        FileReader freader=new FileReader(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefile));
        CSVReader reader = new CSVReaderBuilder(freader).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
        String [] nextLine;
        // Legge il CSV
        while ((nextLine = reader.readNext()) != null) {
        /* _idbase := '' */
        _idbase = "";
        /* _statoreg := '' */
        _statoreg = "";
        /* nota := '' // nota del eventuale problema */
        nota = "";
        /* riga_letta := riga_letta+1 // riga letta del file Excel */
        riga_letta = CPLib.Round(riga_letta+1,0);
        /* column01 := nextLine[0] */
        column01 = nextLine[0];
        /* column01 := Right(Replicate('0',11)+LRTrim(column01),11) */
        column01 = CPLib.Right(CPLib.Replicate("0",11)+CPLib.LRTrim(column01),11);
        /* column02 := nextLine[1] */
        column02 = nextLine[1];
        /* column03 := nextLine[2] */
        column03 = nextLine[2];
        /* column04 := nextLine[3] */
        column04 = nextLine[3];
        /* column05 := nextLine[4] */
        column05 = nextLine[4];
        /* column06 := nextLine[5] */
        column06 = nextLine[5];
        /* column07 := nextLine[6] */
        column07 = nextLine[6];
        /* _statoreg := '' */
        _statoreg = "";
        // * --- Read from fraziobo
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        m_cSql = "";
        m_cSql = m_cSql+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(column01,"C",11,0,m_cServer),m_cServer,column01);
        m_cSql = m_cSql+" and STATOREG="+CPSql.SQLValueAdapter(CPLib.ToSQL("0","C",1,0,m_cServer),m_cServer,"0");
        if (m_Ctx.IsSharedTemp("fraziobo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("STATOREG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _idbase = Read_Cursor.GetString("IDBASE");
          _statoreg = Read_Cursor.GetString("STATOREG");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_import_file_xlsx_esterni returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _idbase = "";
          _statoreg = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(_idbase) */
        if (CPLib.Empty(_idbase)) {
          // * --- Read from fraziobo
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_cSql = "";
          m_cSql = m_cSql+"NUMPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(column01,"C",11,0,m_cServer),m_cServer,column01);
          m_cSql = m_cSql+" and STATOREG="+CPSql.SQLValueAdapter(CPLib.ToSQL("1","C",1,0,m_cServer),m_cServer,"1");
          if (m_Ctx.IsSharedTemp("fraziobo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("STATOREG",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _idbase = Read_Cursor.GetString("IDBASE");
            _statoreg = Read_Cursor.GetString("STATOREG");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_import_file_xlsx_esterni returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _idbase = "";
            _statoreg = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
        /* nota := iif(Empty(nota),'',nota)+iif(Empty(_idbase),'Operazione non trovata.','Operazione trovata.')+' Stato Registrazione: '+_statoreg // nota del eventuale problema */
        nota = (CPLib.Empty(nota)?"":nota)+(CPLib.Empty(_idbase)?"Operazione non trovata.":"Operazione trovata.")+" Stato Registrazione: "+_statoreg;
        /* If At(_statoreg,"|0|1") > 0 */
        if (CPLib.gt(CPLib.At(_statoreg,"|0|1"),0)) {
          /* If Empty(LRTrim(column02)) */
          if (CPLib.Empty(CPLib.LRTrim(column02))) {
            /* nota := iif(Empty(nota),'',nota)+" - Operazione senza dati dell'agenzia." // nota del eventuale problema */
            nota = (CPLib.Empty(nota)?"":nota)+" - Operazione senza dati dell'agenzia.";
          } else { // Else
            /* _cab := '' */
            _cab = "";
            /* _desccit := '' */
            _desccit = "";
            /* If mcTbcitta.GoToKey(LRTrim(column05)) */
            if (mcTbcitta.GoToKey(CPLib.LRTrim(column05))) {
              /* _cab := mcTbcitta.CAB */
              _cab = mcTbcitta.row.CAB;
            } else { // Else
              /* If mcAnadip.GoToKey(LRTrim(column02)) */
              if (mcAnadip.GoToKey(CPLib.LRTrim(column02))) {
                /* _cab := mcAnadip.CAB */
                _cab = mcAnadip.row.CAB;
                /* _desccit := mcAnadip.DESCCIT */
                _desccit = mcAnadip.row.DESCCIT;
                /* If Empty(_cab) */
                if (CPLib.Empty(_cab)) {
                  /* If mcTbcitta.GoToKey(LRTrim(_desccit)) */
                  if (mcTbcitta.GoToKey(CPLib.LRTrim(_desccit))) {
                    /* _cab := mcTbcitta.CAB */
                    _cab = mcTbcitta.row.CAB;
                  } // End If
                } // End If
              } else { // Else
                /* nota := iif(Empty(nota),'',nota)+" - Agenzia non presente nell'AUI." // nota del eventuale problema */
                nota = (CPLib.Empty(nota)?"":nota)+" - Agenzia non presente nell'AUI.";
              } // End If
            } // End If
            /* If Empty(LRTrim(_cab)) */
            if (CPLib.Empty(CPLib.LRTrim(_cab))) {
              /* nota := iif(Empty(nota),'',nota)+'Dipendenza senza CAB'+NL // nota del eventuale problema */
              nota = (CPLib.Empty(nota)?"":nota)+"Dipendenza senza CAB"+"\n";
              // * --- Write into fraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000429")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"INFORM = "+CPLib.ToSQL(CPLib.LRTrim(column07),"C",30,0,m_cServer)+", ";
              m_cSql = m_cSql+"RIFIMP = "+CPLib.ToSQL("XXXXXXXXX","C",28,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
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
                throw new RoutineException();
              }
            } else { // Else
              /* cNewProg := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
              cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
              // * --- Select from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              if (Cursor_fraziobo!=null)
                Cursor_fraziobo.Close();
              Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_idbase,"?",0,0,m_cServer, m_oParameters),m_cServer,_idbase)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_fraziobo.Eof())) {
                /* _flagrap2 := iif(Empty(fraziobo->FLAGRAP2) or fraziobo->FLAGRAP2='Z',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(fraziobo->FLAGRAP2,stringaflagrap2)+1),1)) */
                _flagrap2 = (CPLib.Empty(Cursor_fraziobo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_fraziobo.GetString("FLAGRAP2"),"Z")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_fraziobo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
                /* _idbase2 := LibreriaMit.UniqueId() // Idbase */
                _idbase2 = LibreriaMit.UniqueId();
                /* _idereg := 'F'+Right(fraziobo->NUMPROG,9)+_idbase2 // Stato Registrazione */
                _idereg = "F"+CPLib.Right(Cursor_fraziobo.GetString("NUMPROG"),9)+_idbase2;
                // * --- Insert into fraziobo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("fraziobo");
                m_cPhName = m_Ctx.GetPhName("fraziobo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000430")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000430(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cab,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column02),6),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column05),30),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idereg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column07),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column06),2),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RAREA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("XXXXXXXXX","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RIMP"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_idbase2,"?",0,0,m_cServer)+", ";
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
                Cursor_fraziobo.Next();
              }
              m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
              Cursor_fraziobo.Close();
              // * --- End Select
              // * --- Write into fraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"00000431")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
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
                throw new RoutineException();
              }
            } // End If
          } // End If
        } // End If
        /* gMsgImp := 'Sto leggendo riga: '+LRTrim(Str(riga_letta,10,0))+". Elaborazione in corso ...." */
        gMsgImp = "Sto leggendo riga: "+CPLib.LRTrim(CPLib.Str(riga_letta,10,0))+". Elaborazione in corso ....";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If riga_letta>1 */
        if (CPLib.gt(riga_letta,1)) {
          /* riga_letta_c := Str(riga_letta,9,0) */
          riga_letta_c = CPLib.Str(riga_letta,9,0);
          //Creo il record da scrivere
          row2 = (XSSFRow) sheet2.createRow(r);
          cell2 = (XSSFCell) row2.createCell(0);
          cell2.setCellValue(CPLib.LRTrim(column01));
          cell2 = (XSSFCell) row2.createCell(1);
          cell2.setCellValue(CPLib.LRTrim(column02));
          cell2 = (XSSFCell) row2.createCell(2);
          cell2.setCellValue(CPLib.LRTrim(column03));
          cell2 = (XSSFCell) row2.createCell(3);
          cell2.setCellValue(CPLib.LRTrim(column04));
          cell2 = (XSSFCell) row2.createCell(4);
          cell2.setCellValue(CPLib.LRTrim(column05));
          cell2 = (XSSFCell) row2.createCell(5);
          cell2.setCellValue(CPLib.LRTrim(column06));
          cell2 = (XSSFCell) row2.createCell(6);
          cell2.setCellValue(CPLib.LRTrim(column07));
          cell2 = (XSSFCell) row2.createCell(7);
          cell2.setCellValue(CPLib.LRTrim(nota));
          cell2 = (XSSFCell) row2.createCell(8);
          cell2.setCellValue(CPLib.LRTrim(riga_letta_c));
          r++;
        } // End If
        }
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* reader.close() */
        reader.close();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* Error Msg 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        m_cLastMsgError = "Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000403status,0)) {
          m_Sql.SetTransactionStatus(nTry00000403status,cTry00000403msg);
        }
      }
      // Prepara le colonne al ridimensionamento
      _i=0;
      /* While _i<9 */
      while (CPLib.lt(_i,9)) {
        /* gMsgImp := 'Autodimensionamento delle celle della colonna '+Str(_i,1,0)+' in base al contenuto. Elaborazione in corso...' */
        gMsgImp = "Autodimensionamento delle celle della colonna "+CPLib.Str(_i,1,0)+" in base al contenuto. Elaborazione in corso...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        //Ridimensiono le colonne in base al contenuto
        _i++;
      } // End While
      /* gMsgImp := 'Scrittura del file di esito. Elaborazione in corso...' */
      gMsgImp = "Scrittura del file di esito. Elaborazione in corso...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // scrivo il file di esito
      FileOutputStream fileOut = new FileOutputStream(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+'/'+CPLib.LRTrim(nomefileoutput));
      
      //write this workbook to an Outputstream.
      wb2.write(fileOut);
      fileOut.flush();
      fileOut.close();
      /* gMsgImp := 'Elaborazione terminata!' */
      gMsgImp = "Elaborazione terminata!";
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
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Cursor_qbe_minmax_opextrbo=null;
    CPResultSet Cursor_qbe_opextrbo_resaldi=null;
    CPResultSet Cursor_qbe_saldi_opex_o=null;
    VQRHolder l_VQRHolder = null;
    try {
      double nTry00000443status;
      nTry00000443status = m_Sql.GetTransactionStatus();
      String cTry00000443msg;
      cTry00000443msg = m_Sql.TransactionErrorMessage();
      try {
        /* _annoc := Str(pannorif,4,0) */
        _annoc = CPLib.Str(pannorif,4,0);
        // * --- Select from qbe_minmax_opextrbo
        SPBridge.HMCaller _h00000445;
        _h00000445 = new SPBridge.HMCaller();
        _h00000445.Set("m_cVQRList",m_cVQRList);
        _h00000445.Set("pANNO",_annoc);
        if (Cursor_qbe_minmax_opextrbo!=null)
          Cursor_qbe_minmax_opextrbo.Close();
        Cursor_qbe_minmax_opextrbo = new VQRHolder("qbe_minmax_opextrbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000445,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_minmax_opextrbo.Eof())) {
          /* _min := qbe_minmax_opextrbo->MINPRG */
          _min = CPLib.Round(Cursor_qbe_minmax_opextrbo.GetDouble("MINPRG"),0);
          /* _max := qbe_minmax_opextrbo->MAXPRG */
          _max = CPLib.Round(Cursor_qbe_minmax_opextrbo.GetDouble("MAXPRG"),0);
          /* _totale := qbe_minmax_opextrbo->TOTPRG */
          _totale = CPLib.Round(Cursor_qbe_minmax_opextrbo.GetDouble("TOTPRG"),0);
          Cursor_qbe_minmax_opextrbo.Next();
        }
        m_cConnectivityError = Cursor_qbe_minmax_opextrbo.ErrorMessage();
        Cursor_qbe_minmax_opextrbo.Close();
        // * --- End Select
        /* _mono := iif(_totale > 1000,0,1) */
        _mono = CPLib.Round((CPLib.gt(_totale,1000)?0:1),0);
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* If _totale = 0 */
          if (CPLib.eqr(_totale,0)) {
            /* _cicli := 0 */
            _cicli = CPLib.Round(0,0);
          } else { // Else
            /* _cicli := 1 */
            _cicli = CPLib.Round(1,0);
          } // End If
        } else { // Else
          /* _reccount := _max - _min */
          _reccount = CPLib.Round(_max-_min,0);
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
        } // End If
        /* _conta := 1 */
        _conta = CPLib.Round(1,0);
        /* While _conta <= _cicli */
        while (CPLib.le(_conta,_cicli)) {
          /* If _mono = 1 */
          if (CPLib.eqr(_mono,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* If _conta=1 */
            if (CPLib.eqr(_conta,1)) {
              /* _bottom := _min */
              _bottom = CPLib.Round(_min,0);
              /* _top := _min + 999 */
              _top = CPLib.Round(_min+999,0);
              /* ElseIf _conta = _cicli */
            } else if (CPLib.eqr(_conta,_cicli)) {
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
          /* gMsgImp := 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_conta,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
          gMsgImp = "Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_conta,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) + NL // Messaggio */
            gMsgProc = gMsgProc+"Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0))+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,LRTrim(gMsgImp)) // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,CPLib.LRTrim(gMsgImp));
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Lettura soggetti in corso ... Ciclo N. '+LRTrim(Str(_conta,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) */
          _oldmsg = "Lettura soggetti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          // * --- Select from qbe_opextrbo_resaldi
          SPBridge.HMCaller _h00000461;
          _h00000461 = new SPBridge.HMCaller();
          _h00000461.Set("m_cVQRList",m_cVQRList);
          _h00000461.Set("_bottom",_bottom);
          _h00000461.Set("_top",_top);
          _h00000461.Set("anno",_annoc);
          if (Cursor_qbe_opextrbo_resaldi!=null)
            Cursor_qbe_opextrbo_resaldi.Close();
          Cursor_qbe_opextrbo_resaldi = new VQRHolder("qbe_opextrbo_resaldi",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000461,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_opextrbo_resaldi.Eof())) {
            /* _contarec := _contarec + 1 */
            _contarec = CPLib.Round(_contarec+1,0);
            /* _totsal := 0 */
            _totsal = CPLib.Round(0,2);
            /* _numope := 0 */
            _numope = CPLib.Round(0,0);
            // * --- Select from qbe_saldi_opex_o
            SPBridge.HMCaller _h00000465;
            _h00000465 = new SPBridge.HMCaller();
            _h00000465.Set("m_cVQRList",m_cVQRList);
            _h00000465.Set("annosel",_annoc);
            _h00000465.Set("ndgcli",Cursor_qbe_opextrbo_resaldi.GetString("COLLEG"));
            if (Cursor_qbe_saldi_opex_o!=null)
              Cursor_qbe_saldi_opex_o.Close();
            Cursor_qbe_saldi_opex_o = new VQRHolder("qbe_saldi_opex_o",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000465,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_saldi_opex_o.Eof())) {
              /* _totsal := _totsal + qbe_saldi_opex_o->TOTLIRE */
              _totsal = CPLib.Round(_totsal+Cursor_qbe_saldi_opex_o.GetDouble("TOTLIRE"),2);
              /* _numope := _numope + qbe_saldi_opex_o->TOTOPER */
              _numope = CPLib.Round(_numope+Cursor_qbe_saldi_opex_o.GetDouble("TOTOPER"),0);
              Cursor_qbe_saldi_opex_o.Next();
            }
            m_cConnectivityError = Cursor_qbe_saldi_opex_o.ErrorMessage();
            Cursor_qbe_saldi_opex_o.Close();
            // * --- End Select
            /* If qbe_opextrbo_resaldi->SALDO <> _totsal or qbe_opextrbo_resaldi->QUANTITA <> _numope */
            if (CPLib.ne(Cursor_qbe_opextrbo_resaldi.GetDouble("SALDO"),_totsal) || CPLib.ne(Cursor_qbe_opextrbo_resaldi.GetDouble("QUANTITA"),_numope)) {
              /* gMsgImp := 'Aggiorno dati per il soggetto con NDG: '+ qbe_opextrbo_resaldi->COLLEG */
              gMsgImp = "Aggiorno dati per il soggetto con NDG: "+Cursor_qbe_opextrbo_resaldi.GetString("COLLEG");
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_import_file_xlsx_esterni",365,"0000046A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"SALDO = "+CPLib.ToSQL(_totsal,"N",17,0)+", ";
              m_cSql = m_cSql+"QUANTITA = "+CPLib.ToSQL(_numope,"N",6,0)+", ";
              m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_opextrbo_resaldi.GetString("COLLEG"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_opextrbo_resaldi.GetString("COLLEG"))+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_annoc,"?",0,0,m_cServer),m_cServer,_annoc)+"";
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
            Cursor_qbe_opextrbo_resaldi.Next();
          }
          m_cConnectivityError = Cursor_qbe_opextrbo_resaldi.ErrorMessage();
          Cursor_qbe_opextrbo_resaldi.Close();
          // * --- End Select
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
        } // End While
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000443status,0)) {
          m_Sql.SetTransactionStatus(nTry00000443status,cTry00000443msg);
        }
      }
      /* gMsgImp := 'Elaborazione terminata!' */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_qbe_minmax_opextrbo!=null)
          Cursor_qbe_minmax_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_opextrbo_resaldi!=null)
          Cursor_qbe_opextrbo_resaldi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_saldi_opex_o!=null)
          Cursor_qbe_saldi_opex_o.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_datamod,boolean p_aggfam,String p_pnomefile,double p_pannorif,String p_pselezione) {
    datamod = p_datamod;
    aggfam = p_aggfam;
    pnomefile = p_pnomefile;
    pannorif = p_pannorif;
    pselezione = p_pselezione;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public String Run(java.sql.Date p_datamod,boolean p_aggfam,String p_pnomefile,double p_pannorif,String p_pselezione) {
    datamod = p_datamod;
    aggfam = p_aggfam;
    pnomefile = p_pnomefile;
    pannorif = p_pannorif;
    pselezione = p_pselezione;
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
  public static arrt_import_file_xlsx_esterniR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_file_xlsx_esterniR(p_Ctx, p_Caller);
  }
  public static arrt_import_file_xlsx_esterniR Make(CPContext p_Ctx) {
    return new arrt_import_file_xlsx_esterniR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    datamod = CPLib.NullDate();
    aggfam = false;
    pnomefile = CPLib.Space(200);
    pannorif = 0;
    pselezione = CPLib.Space(1);
    nomefile = CPLib.Space(30);
    nomefileoutput = CPLib.Space(30);
    nota = CPLib.Space(100);
    cell_count = 0;
    modifica = false;
    _connes = CPLib.Space(16);
    _cf = CPLib.Space(16);
    _FLGANAVAL = CPLib.Space(1);
    _min = 0;
    _max = 0;
    _cicli = 0;
    _conta = 0;
    _bottom = 0;
    _top = 0;
    _totale = 0;
    _contarec = 0;
    _mono = 0;
    _annoc = CPLib.Space(4);
    _totsal = 0;
    _numope = 0;
    _reccount = 0;
    _tot = 0;
    _oldmsg = CPLib.Space(100);
    mcTbcitta = new MemoryCursor_tbcitta();
    mcAnadip = new MemoryCursor_anadip();
    oggi = CPLib.NullDate();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gDataVaria=m_Ctx.GetGlobalDate("gDataVaria");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_minmax_opextrbo,qbe_opextrbo_resaldi,qbe_saldi_opex_o,
  public static final String m_cVQRList = ",qbe_minmax_opextrbo,qbe_opextrbo_resaldi,qbe_saldi_opex_o,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_import_file_xlsx_esterni,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_import_file_xlsx_esterni,";
  public static String[] m_cRunParameterNames={"datamod","aggfam","pnomefile","pannorif","pselezione"};
  protected static String GetFieldsName_00000069(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODCAB,";
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
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000150(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODCAB,";
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
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000152(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+"SALDO,";
    p_cSql = p_cSql+"QUANTITA,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000164(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+"SALDO,";
    p_cSql = p_cSql+"QUANTITA,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000165(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"NUMPROG1,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGOPEX,";
    p_cSql = p_cSql+"SALDO,";
    p_cSql = p_cSql+"QUANTITA,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"opextrbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000231(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopstor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000233(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"DATARIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFSTOR,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPOCAN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopcanc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000002F4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODCAB,";
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
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000307(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"PROGOPX,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeoprig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000314(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"PROGOPX,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeoprig",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000325(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODCAB,";
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
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000430(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
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
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
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
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
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
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
}
