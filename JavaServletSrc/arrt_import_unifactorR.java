// * --- Area Manuale = BO - Header
// * --- arrt_import_unifactor
import java.io.File; 
import java.lang.Double;
import java.util.*;
import jxl.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
// * --- Fine Area Manuale
public class arrt_import_unifactorR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_knarapbo;
  public String m_cServer_knarapbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_xersonbo;
  public String m_cServer_xersonbo;
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
  public MemoryCursor_tmp_list_imprich pmcListaFile;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String gMsgImp;
  public String gMsgProc;
  public String gTipInter;
  public String gVerImp;
  public String fhand;
  public String czipfile;
  public String cpercorsozip;
  public String cdirectoryfile;
  public String buffernomefile;
  public String nomefileimport;
  public double _priorita;
  public String riga;
  public double _numana;
  public double _nummov;
  public MemoryCursor_tmp_list_imprich mcLista;
  public MemoryCursor_mcflusso_mcrdef mcFlussiRapporti;
  public MemoryCursor_mccollegamento_mcrdef mcCollegamentoRapporti;
  public MemoryCursor_mcanagrafiche_mcrdef mcAnagraficheRapporti;
  public MemoryCursor_mcflusso_mcrdef mcFlussiMovimenti;
  public MemoryCursor_mccollegamento_mcrdef mcCollegamentoMovimenti;
  public MemoryCursor_mcanagrafiche_mcrdef mcAnagraficheMovimenti;
  public MemoryCursor_mcflusso_mcrdef mcFlussi;
  public MemoryCursor_mccollegamento_mcrdef mcCollegamento;
  public MemoryCursor_mcanagrafiche_mcrdef mcAnagrafiche;
  public MemoryCursor_mccontroparte_mcrdef mcControparti;
  public MemoryCursor_mccategorizzazione_mcrdef mcCategoria;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_unifactor
  public String[] lista;
  public int conteggio;
  public int i;
  public int _i;
  public int _y;
  public int contanome;
  public int _righe;
  public int _conta;
  public Path path;
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_import_unifactorR (CPContext p_ContextObject, Caller caller) {
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
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_import_unifactor",m_Caller);
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
    m_cPhName_knarapbo = p_ContextObject.GetPhName("knarapbo");
    if (m_cPhName_knarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_knarapbo = m_cPhName_knarapbo+" "+m_Ctx.GetWritePhName("knarapbo");
    }
    m_cServer_knarapbo = p_ContextObject.GetServer("knarapbo");
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
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
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
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_xersonbo = p_ContextObject.GetPhName("xersonbo");
    if (m_cPhName_xersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xersonbo = m_cPhName_xersonbo+" "+m_Ctx.GetWritePhName("xersonbo");
    }
    m_cServer_xersonbo = p_ContextObject.GetServer("xersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_priorita",p_cVarName)) {
      return _priorita;
    }
    if (CPLib.eqr("_numana",p_cVarName)) {
      return _numana;
    }
    if (CPLib.eqr("_nummov",p_cVarName)) {
      return _nummov;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_unifactor";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gVerImp",p_cVarName)) {
      return gVerImp;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
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
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pmcListaFile",p_cVarName)) {
      return pmcListaFile;
    }
    if (CPLib.eqr("mcLista",p_cVarName)) {
      return mcLista;
    }
    if (CPLib.eqr("mcFlussiRapporti",p_cVarName)) {
      return mcFlussiRapporti;
    }
    if (CPLib.eqr("mcCollegamentoRapporti",p_cVarName)) {
      return mcCollegamentoRapporti;
    }
    if (CPLib.eqr("mcAnagraficheRapporti",p_cVarName)) {
      return mcAnagraficheRapporti;
    }
    if (CPLib.eqr("mcFlussiMovimenti",p_cVarName)) {
      return mcFlussiMovimenti;
    }
    if (CPLib.eqr("mcCollegamentoMovimenti",p_cVarName)) {
      return mcCollegamentoMovimenti;
    }
    if (CPLib.eqr("mcAnagraficheMovimenti",p_cVarName)) {
      return mcAnagraficheMovimenti;
    }
    if (CPLib.eqr("mcFlussi",p_cVarName)) {
      return mcFlussi;
    }
    if (CPLib.eqr("mcCollegamento",p_cVarName)) {
      return mcCollegamento;
    }
    if (CPLib.eqr("mcAnagrafiche",p_cVarName)) {
      return mcAnagrafiche;
    }
    if (CPLib.eqr("mcControparti",p_cVarName)) {
      return mcControparti;
    }
    if (CPLib.eqr("mcCategoria",p_cVarName)) {
      return mcCategoria;
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
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
    if (CPLib.eqr("_numana",p_cVarName)) {
      _numana = value;
      return;
    }
    if (CPLib.eqr("_nummov",p_cVarName)) {
      _nummov = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("gVerImp",p_cVarName)) {
      gVerImp = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
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
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("pmcListaFile",p_cVarName)) {
      pmcListaFile = (MemoryCursor_tmp_list_imprich)value;
      return;
    }
    if (CPLib.eqr("mcLista",p_cVarName)) {
      mcLista = (MemoryCursor_tmp_list_imprich)value;
      return;
    }
    if (CPLib.eqr("mcFlussiRapporti",p_cVarName)) {
      mcFlussiRapporti = (MemoryCursor_mcflusso_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcCollegamentoRapporti",p_cVarName)) {
      mcCollegamentoRapporti = (MemoryCursor_mccollegamento_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcAnagraficheRapporti",p_cVarName)) {
      mcAnagraficheRapporti = (MemoryCursor_mcanagrafiche_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFlussiMovimenti",p_cVarName)) {
      mcFlussiMovimenti = (MemoryCursor_mcflusso_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcCollegamentoMovimenti",p_cVarName)) {
      mcCollegamentoMovimenti = (MemoryCursor_mccollegamento_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcAnagraficheMovimenti",p_cVarName)) {
      mcAnagraficheMovimenti = (MemoryCursor_mcanagrafiche_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcFlussi",p_cVarName)) {
      mcFlussi = (MemoryCursor_mcflusso_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcCollegamento",p_cVarName)) {
      mcCollegamento = (MemoryCursor_mccollegamento_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcAnagrafiche",p_cVarName)) {
      mcAnagrafiche = (MemoryCursor_mcanagrafiche_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcControparti",p_cVarName)) {
      mcControparti = (MemoryCursor_mccontroparte_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcCategoria",p_cVarName)) {
      mcCategoria = (MemoryCursor_mccategorizzazione_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Principale() throws Exception {
    /* pmcListaFile MemoryCursor(tmp_list_imprich) */
    /* gAzienda Char(60) // Codice Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* gPathDoc Char(200) // Path dei doc esterni */
    /* gMsgImp Char(500) // Variabile per messaggi Elaborazione */
    /* gMsgProc Memo // Log Elaborazione */
    /* gTipInter Char(2) // Tipo Intermediario */
    /* gVerImp Char(1) // Verifica da import */
    /* fhand Char(0) */
    /* czipfile Char(100) */
    /* cpercorsozip Char(200) */
    /* cdirectoryfile Char(200) */
    /* buffernomefile Char(100) */
    /* nomefileimport Char(50) */
    /* _priorita Numeric(3, 0) */
    /* riga Memo */
    /* _numana Numeric(10, 0) */
    /* _nummov Numeric(10, 0) */
    /* mcLista MemoryCursor(tmp_list_imprich) */
    /* mcFlussiRapporti MemoryCursor(mcFlusso.MCRDef) */
    /* mcCollegamentoRapporti MemoryCursor(mcCollegamento.MCRDef) */
    /* mcAnagraficheRapporti MemoryCursor(mcAnagrafiche.MCRDef) */
    /* mcFlussiMovimenti MemoryCursor(mcFlusso.MCRDef) */
    /* mcCollegamentoMovimenti MemoryCursor(mcCollegamento.MCRDef) */
    /* mcAnagraficheMovimenti MemoryCursor(mcAnagrafiche.MCRDef) */
    /* mcFlussi MemoryCursor(mcFlusso.MCRDef) */
    /* mcCollegamento MemoryCursor(mcCollegamento.MCRDef) */
    /* mcAnagrafiche MemoryCursor(mcAnagrafiche.MCRDef) */
    /* mcControparti MemoryCursor(mcControparte.MCRDef) */
    /* mcCategoria MemoryCursor(mcCategorizzazione.MCRDef) */
    /* gMsgProc := 'Ora Inizio Import Dati: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = "Ora Inizio Import Dati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    for (MemoryCursorRow_tmp_list_imprich rwFile : pmcListaFile._iterable_()) {
      /* If At('.zip',Lower(LRTrim(rwFile.nomefile))) <> 0 */
      if (CPLib.ne(CPLib.At(".zip",CPLib.Lower(CPLib.LRTrim(rwFile.nomefile))),0)) {
        /* czipfile := LRTrim(rwFile.nomefile) */
        czipfile = CPLib.LRTrim(rwFile.nomefile);
        /* Exec "Estrazione Zip" Page 2:EstraeZip */
        EstraeZip();
      } // End If
    }
    /* If Empty(czipfile) */
    if (CPLib.Empty(czipfile)) {
      for (MemoryCursorRow_tmp_list_imprich rwFile : pmcListaFile._iterable_()) {
        /* mcLista.AppendRow(rwFile) */
        mcLista.AppendRow(rwFile);
      }
    } // End If
    /* mcFlussiRapporti.Zap() */
    mcFlussiRapporti.Zap();
    /* mcCollegamentoRapporti.Zap() */
    mcCollegamentoRapporti.Zap();
    /* mcAnagraficheRapporti.Zap() */
    mcAnagraficheRapporti.Zap();
    /* mcFlussiMovimenti.Zap() */
    mcFlussiMovimenti.Zap();
    /* mcCollegamentoMovimenti.Zap() */
    mcCollegamentoMovimenti.Zap();
    /* mcAnagraficheMovimenti.Zap() */
    mcAnagraficheMovimenti.Zap();
    /* mcControparti.Zap() */
    mcControparti.Zap();
    for (MemoryCursorRow_tmp_list_imprich rwFile : mcLista._iterable_()) {
      /* mcFlussi.Zap() */
      mcFlussi.Zap();
      /* mcCollegamento.Zap() */
      mcCollegamento.Zap();
      /* mcAnagrafiche.Zap() */
      mcAnagrafiche.Zap();
      /* nomefileimport := LRTrim(rwFile.nomefile) */
      nomefileimport = CPLib.LRTrim(rwFile.nomefile);
      /* Case At("RAPPTOT",Upper(nomefileimport)) > 0 or At("MOVIM",Upper(nomefileimport)) > 0 */
      if (CPLib.gt(CPLib.At("RAPPTOT",CPLib.Upper(nomefileimport)),0) || CPLib.gt(CPLib.At("MOVIM",CPLib.Upper(nomefileimport)),0)) {
        /* Exec "Import flussi" Page 3:ImportFlussi */
        ImportFlussi();
        /* _nummov := 0 */
        _nummov = CPLib.Round(0,0);
        for (MemoryCursorRow_mcflusso_mcrdef rwFlussi : mcFlussi._iterable_()) {
          /* _nummov := _nummov + 1 */
          _nummov = CPLib.Round(_nummov+1,0);
          /* If At("MOVIM",Upper(nomefileimport)) > 0 */
          if (CPLib.gt(CPLib.At("MOVIM",CPLib.Upper(nomefileimport)),0)) {
            /* mcFlussiMovimenti.AppendRowWithKey(rwFlussi.CodiceIstituto+rwFlussi.DataElaborazione+rwFlussi.ProceduraOrigine+rwFlussi.NumeroElettronicoOperante+rwFlussi.SottoNumeroOperazione,rwFlussi) */
            mcFlussiMovimenti.AppendRowWithKey(rwFlussi.CodiceIstituto+rwFlussi.DataElaborazione+rwFlussi.ProceduraOrigine+rwFlussi.NumeroElettronicoOperante+rwFlussi.SottoNumeroOperazione,rwFlussi);
          } else { // Else
            /* mcFlussiRapporti.AppendRowWithKey(rwFlussi.CodiceIstituto+rwFlussi.DataElaborazione+rwFlussi.ProceduraOrigine+rwFlussi.NumeroElettronicoOperante+rwFlussi.SottoNumeroOperazione,rwFlussi) */
            mcFlussiRapporti.AppendRowWithKey(rwFlussi.CodiceIstituto+rwFlussi.DataElaborazione+rwFlussi.ProceduraOrigine+rwFlussi.NumeroElettronicoOperante+rwFlussi.SottoNumeroOperazione,rwFlussi);
          } // End If
        }
        /* Case At("COLL",Upper(nomefileimport)) > 0 */
      } else if (CPLib.gt(CPLib.At("COLL",CPLib.Upper(nomefileimport)),0)) {
        /* Exec "Import Collegamenti" Page 5:ImportCollegamenti */
        ImportCollegamenti();
        for (MemoryCursorRow_mccollegamento_mcrdef rwCollegamento : mcCollegamento._iterable_()) {
          /* If At("COLLMOVI",Upper(nomefileimport)) > 0 */
          if (CPLib.gt(CPLib.At("COLLMOVI",CPLib.Upper(nomefileimport)),0)) {
            /* mcCollegamentoMovimenti.AppendRowWithKey(rwCollegamento.CodiceIstituto+rwCollegamento.DataElaborazione+rwCollegamento.ProceduraOrigine+rwCollegamento.NumeroElettronicoOperante+rwCollegamento.SottoNumeroOperazione+rwCollegamento.CodiceCliente,rwCollegamento) */
            mcCollegamentoMovimenti.AppendRowWithKey(rwCollegamento.CodiceIstituto+rwCollegamento.DataElaborazione+rwCollegamento.ProceduraOrigine+rwCollegamento.NumeroElettronicoOperante+rwCollegamento.SottoNumeroOperazione+rwCollegamento.CodiceCliente,rwCollegamento);
          } else { // Else
            /* mcCollegamentoRapporti.AppendRowWithKey(rwCollegamento.CodiceIstituto+rwCollegamento.DataElaborazione+rwCollegamento.ProceduraOrigine+rwCollegamento.NumeroElettronicoOperante+rwCollegamento.SottoNumeroOperazione+rwCollegamento.CodiceCliente,rwCollegamento) */
            mcCollegamentoRapporti.AppendRowWithKey(rwCollegamento.CodiceIstituto+rwCollegamento.DataElaborazione+rwCollegamento.ProceduraOrigine+rwCollegamento.NumeroElettronicoOperante+rwCollegamento.SottoNumeroOperazione+rwCollegamento.CodiceCliente,rwCollegamento);
          } // End If
        }
        /* Case At("ANASORT",Upper(nomefileimport)) > 0 or At("ANAMOVI",Upper(nomefileimport)) > 0 */
      } else if (CPLib.gt(CPLib.At("ANASORT",CPLib.Upper(nomefileimport)),0) || CPLib.gt(CPLib.At("ANAMOVI",CPLib.Upper(nomefileimport)),0)) {
        /* Exec "Import Anagrafiche" Page 4:ImportAnagrafiche */
        ImportAnagrafiche();
        /* _numana := 0 */
        _numana = CPLib.Round(0,0);
        for (MemoryCursorRow_mcanagrafiche_mcrdef rwAnagrafiche : mcAnagrafiche._iterable_()) {
          /* _numana := _numana + 1 */
          _numana = CPLib.Round(_numana+1,0);
          /* If At("ANAMOVI",Upper(nomefileimport)) > 0 */
          if (CPLib.gt(CPLib.At("ANAMOVI",CPLib.Upper(nomefileimport)),0)) {
            /* mcAnagraficheMovimenti.AppendRowWithKey(rwAnagrafiche.CodiceIstituto+rwAnagrafiche.DataElaborazione+rwAnagrafiche.CodiceCliente,rwAnagrafiche) */
            mcAnagraficheMovimenti.AppendRowWithKey(rwAnagrafiche.CodiceIstituto+rwAnagrafiche.DataElaborazione+rwAnagrafiche.CodiceCliente,rwAnagrafiche);
          } else { // Else
            /* mcAnagraficheRapporti.AppendRowWithKey(rwAnagrafiche.CodiceIstituto+rwAnagrafiche.DataElaborazione+rwAnagrafiche.CodiceCliente,rwAnagrafiche) */
            mcAnagraficheRapporti.AppendRowWithKey(rwAnagrafiche.CodiceIstituto+rwAnagrafiche.DataElaborazione+rwAnagrafiche.CodiceCliente,rwAnagrafiche);
          } // End If
        }
        /* Case At("BONIFICI",Upper(nomefileimport)) > 0 */
      } else if (CPLib.gt(CPLib.At("BONIFICI",CPLib.Upper(nomefileimport)),0)) {
        /* Exec "Import Beneficiari" Page 6:ImportBeneficiari */
        ImportBeneficiari();
        /* Case At("ANAGRAFE",Upper(nomefileimport)) > 0 */
      } else if (CPLib.gt(CPLib.At("ANAGRAFE",CPLib.Upper(nomefileimport)),0)) {
        /* Exec "Categorizzazione Anagrafiche" Page 9:Categorizzazione */
        Categorizzazione();
      } // End Case
      /* FileLibMit.DeleteFilePath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
      FileLibMit.DeleteFilePath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    }
    /* gVerImp := 'S' // Verifica da import */
    gVerImp = "S";
    m_Ctx.SetGlobalString("gVerImp",gVerImp);
    /* If _numana > 0 */
    if (CPLib.gt(_numana,0)) {
      /* Exec "Anagrafiche" Page 7:Anagrafiche */
      Anagrafiche();
    } // End If
    /* If _nummov > 0 */
    if (CPLib.gt(_nummov,0)) {
      /* Exec "Flussi" Page 8:Flussi */
      Flussi();
    } // End If
    /* gVerImp := 'N' // Verifica da import */
    gVerImp = "N";
    m_Ctx.SetGlobalString("gVerImp",gVerImp);
    /* gMsgImp := "Elaborazione Terminta!" */
    gMsgImp = "Elaborazione Terminta!";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* gMsgProc := gMsgProc + 'Ora Fine Import Dati: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Import Dati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* Return gMsgProc */
    throw new Stop(gMsgProc);
  }
  void EstraeZip() throws Exception {
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + czipfile + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Inizio estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Inizio estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* cpercorsozip := LRTrim(gPathDoc)+"/appo/"+LRTrim(gAzienda)+"/"+czipfile */
    cpercorsozip = CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+czipfile;
    /* cdirectoryfile := LRTrim(gPathDoc)+"/appo/"+LRTrim(gAzienda)+"/" */
    cdirectoryfile = CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/";
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
    /* contanome := 0 */
    contanome = 0;
    /* _priorita := 0 */
    _priorita = CPLib.Round(0,0);
    /* While contanome<conteggio */
    while (CPLib.lt(contanome,conteggio)) {
      buffernomefile=lista[contanome];
      /* mcLista.AppendBlank() */
      mcLista.AppendBlank();
      /* mcLista.nomefile := buffernomefile */
      mcLista.row.nomefile = buffernomefile;
      /* mcLista.SaveRow() */
      mcLista.SaveRow();
      /* contanome := contanome+1 */
      contanome = contanome+1;
    } // End While
    /* FileLibMit.MoveFile(LRTrim(gPathDoc)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(czipfile),LRTrim(gPathDoc)+"/Import/"+LRTrim(gAzienda)+"/"+DateToChar(Date())+"_"+LRTrim(czipfile)) */
    FileLibMit.MoveFile(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(czipfile),CPLib.LRTrim(gPathDoc)+"/Import/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.DateToChar(CPLib.Date())+"_"+CPLib.LRTrim(czipfile));
    /* gMsgImp := 'Fine estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Fine estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +czipfile + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void ImportFlussi() throws Exception {
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
    fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If Len(LRTrim(riga)) > 0 */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
        /* mcFlussi.AppendBlank() */
        mcFlussi.AppendBlank();
        /* mcFlussi.CodiceIstituto := LRTrim(Left(riga,11)) */
        mcFlussi.row.CodiceIstituto = CPLib.LRTrim(CPLib.Left(riga,11));
        /* mcFlussi.DataElaborazione := LRTrim(Substr(riga,12,8)) */
        mcFlussi.row.DataElaborazione = CPLib.LRTrim(CPLib.Substr(riga,12,8));
        /* mcFlussi.ProceduraOrigine := LRTrim(Substr(riga,20,3)) */
        mcFlussi.row.ProceduraOrigine = CPLib.LRTrim(CPLib.Substr(riga,20,3));
        /* mcFlussi.NumeroElettronicoOperante := LRTrim(Substr(riga,23,9)) */
        mcFlussi.row.NumeroElettronicoOperante = CPLib.LRTrim(CPLib.Substr(riga,23,9));
        /* mcFlussi.SottoNumeroOperazione := LRTrim(Substr(riga,32,9)) */
        mcFlussi.row.SottoNumeroOperazione = CPLib.LRTrim(CPLib.Substr(riga,32,9));
        /* mcFlussi.TipoRegistrazione := LRTrim(Substr(riga,41,2)) */
        mcFlussi.row.TipoRegistrazione = CPLib.LRTrim(CPLib.Substr(riga,41,2));
        /* mcFlussi.DataOperazione := LRTrim(Substr(riga,43,8)) */
        mcFlussi.row.DataOperazione = CPLib.LRTrim(CPLib.Substr(riga,43,8));
        /* mcFlussi.FilialeOperante := LRTrim(Substr(riga,51,6)) */
        mcFlussi.row.FilialeOperante = CPLib.LRTrim(CPLib.Substr(riga,51,6));
        /* mcFlussi.CodiceOperatore := LRTrim(Substr(riga,57,5)) */
        mcFlussi.row.CodiceOperatore = CPLib.LRTrim(CPLib.Substr(riga,57,5));
        /* mcFlussi.TerminaleOperante := LRTrim(Substr(riga,62,4)) */
        mcFlussi.row.TerminaleOperante = CPLib.LRTrim(CPLib.Substr(riga,62,4));
        /* mcFlussi.Transazione := LRTrim(Substr(riga,66,4)) */
        mcFlussi.row.Transazione = CPLib.LRTrim(CPLib.Substr(riga,66,4));
        /* mcFlussi.OperazioneCassa := LRTrim(Substr(riga,70,1)) */
        mcFlussi.row.OperazioneCassa = CPLib.LRTrim(CPLib.Substr(riga,70,1));
        /* mcFlussi.CausaleInterna := LRTrim(Substr(riga,71,4)) */
        mcFlussi.row.CausaleInterna = CPLib.LRTrim(CPLib.Substr(riga,71,4));
        /* mcFlussi.CodiceCausale := LRTrim(Substr(riga,75,4)) */
        mcFlussi.row.CodiceCausale = CPLib.LRTrim(CPLib.Substr(riga,75,4));
        /* mcFlussi.FlagContanti := LRTrim(Substr(riga,79,1)) */
        mcFlussi.row.FlagContanti = CPLib.LRTrim(CPLib.Substr(riga,79,1));
        /* mcFlussi.ImportoTotale := Val(LRTrim(Substr(riga,80,15))) / 100 */
        mcFlussi.row.ImportoTotale = CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,80,15)))/100;
        /* mcFlussi.ImportoContante := Val(LRTrim(Substr(riga,95,15))) / 100 */
        mcFlussi.row.ImportoContante = CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,95,15)))/100;
        /* mcFlussi.Segno := LRTrim(Substr(riga,110,1)) */
        mcFlussi.row.Segno = CPLib.LRTrim(CPLib.Substr(riga,110,1));
        /* mcFlussi.CodiceDivisa := LRTrim(Substr(riga,111,3)) */
        mcFlussi.row.CodiceDivisa = CPLib.LRTrim(CPLib.Substr(riga,111,3));
        /* mcFlussi.NumeroRapporto := LRTrim(Substr(riga,114,25)) */
        mcFlussi.row.NumeroRapporto = CPLib.LRTrim(CPLib.Substr(riga,114,25));
        /* mcFlussi.TipoRapportoAUI := LRTrim(Substr(riga,139,1)) */
        mcFlussi.row.TipoRapportoAUI = CPLib.LRTrim(CPLib.Substr(riga,139,1));
        /* mcFlussi.FormaTecnica := LRTrim(Substr(riga,140,5)) */
        mcFlussi.row.FormaTecnica = CPLib.LRTrim(CPLib.Substr(riga,140,5));
        /* mcFlussi.TipoRapportoIntermediario := LRTrim(Substr(riga,145,3)) */
        mcFlussi.row.TipoRapportoIntermediario = CPLib.LRTrim(CPLib.Substr(riga,145,3));
        /* mcFlussi.CABSportello := LRTrim(Substr(riga,148,5)) */
        mcFlussi.row.CABSportello = CPLib.LRTrim(CPLib.Substr(riga,148,5));
        /* mcFlussi.Note := LRTrim(Substr(riga,153,100)) */
        mcFlussi.row.Note = CPLib.LRTrim(CPLib.Substr(riga,153,100));
        /* mcFlussi.FlagSaggio := LRTrim(Substr(riga,253,1)) */
        mcFlussi.row.FlagSaggio = CPLib.LRTrim(CPLib.Substr(riga,253,1));
        /* mcFlussi.FlagPostRep := LRTrim(Substr(riga,254,1)) */
        mcFlussi.row.FlagPostRep = CPLib.LRTrim(CPLib.Substr(riga,254,1));
        /* mcFlussi.FILLER1 := LRTrim(Substr(riga,255,20)) */
        mcFlussi.row.FILLER1 = CPLib.LRTrim(CPLib.Substr(riga,255,20));
        /* mcFlussi.Ragionevolezza := LRTrim(Substr(riga,275,1)) */
        mcFlussi.row.Ragionevolezza = CPLib.LRTrim(CPLib.Substr(riga,275,1));
        /* mcFlussi.Tipologia := LRTrim(Substr(riga,276,3)) */
        mcFlussi.row.Tipologia = CPLib.LRTrim(CPLib.Substr(riga,276,3));
        /* mcFlussi.Motivazione := LRTrim(Substr(riga,279,3)) */
        mcFlussi.row.Motivazione = CPLib.LRTrim(CPLib.Substr(riga,279,3));
        /* mcFlussi.NaturaScopo := LRTrim(Substr(riga,282,1)) */
        mcFlussi.row.NaturaScopo = CPLib.LRTrim(CPLib.Substr(riga,282,1));
        /* mcFlussi.TipoVerifica := LRTrim(Substr(riga,283,1)) */
        mcFlussi.row.TipoVerifica = CPLib.LRTrim(CPLib.Substr(riga,283,1));
        /* mcFlussi.ObbTitolareEff := LRTrim(Substr(riga,284,1)) */
        mcFlussi.row.ObbTitolareEff = CPLib.LRTrim(CPLib.Substr(riga,284,1));
        /* mcFlussi.SocFiduciaria := LRTrim(Substr(riga,285,1)) */
        mcFlussi.row.SocFiduciaria = CPLib.LRTrim(CPLib.Substr(riga,285,1));
        /* mcFlussi.NumeroOperazione := LRTrim(Substr(riga,286,25)) */
        mcFlussi.row.NumeroOperazione = CPLib.LRTrim(CPLib.Substr(riga,286,25));
        /* mcFlussi.ImportoFineMese := Val(LRTrim(Substr(riga,311,15))) / 100 */
        mcFlussi.row.ImportoFineMese = CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,311,15)))/100;
        /* mcFlussi.FlagObbFiduciante := LRTrim(Substr(riga,326,1)) */
        mcFlussi.row.FlagObbFiduciante = CPLib.LRTrim(CPLib.Substr(riga,326,1));
        /* mcFlussi.FlagObbNumOpeLegame := LRTrim(Substr(riga,327,1)) */
        mcFlussi.row.FlagObbNumOpeLegame = CPLib.LRTrim(CPLib.Substr(riga,327,1));
        /* mcFlussi.NumOpeLegame := LRTrim(Substr(riga,328,25)) */
        mcFlussi.row.NumOpeLegame = CPLib.LRTrim(CPLib.Substr(riga,328,25));
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void ImportAnagrafiche() throws Exception {
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
    fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If Len(LRTrim(riga)) > 0 */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
        /* mcAnagrafiche.AppendBlank() */
        mcAnagrafiche.AppendBlank();
        /* mcAnagrafiche.CodiceIstituto := LRTrim(Left(riga,11)) */
        mcAnagrafiche.row.CodiceIstituto = CPLib.LRTrim(CPLib.Left(riga,11));
        /* mcAnagrafiche.DataElaborazione := LRTrim(Substr(riga,12,8)) */
        mcAnagrafiche.row.DataElaborazione = CPLib.LRTrim(CPLib.Substr(riga,12,8));
        /* mcAnagrafiche.CodiceCliente := LRTrim(Substr(riga,20,16)) */
        mcAnagrafiche.row.CodiceCliente = CPLib.LRTrim(CPLib.Substr(riga,20,16));
        /* mcAnagrafiche.CodiceFiscale := LRTrim(Substr(riga,36,16)) */
        mcAnagrafiche.row.CodiceFiscale = CPLib.LRTrim(CPLib.Substr(riga,36,16));
        /* mcAnagrafiche.Intestazione := iif(LRTrim(Substr(riga,321,1))='F',LRTrim(Substr(riga,323,45))+" "+LRTrim(Substr(riga,368,30)),LRTrim(Substr(riga,52,70))) */
        mcAnagrafiche.row.Intestazione = (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,321,1)),"F")?CPLib.LRTrim(CPLib.Substr(riga,323,45))+" "+CPLib.LRTrim(CPLib.Substr(riga,368,30)):CPLib.LRTrim(CPLib.Substr(riga,52,70)));
        /* mcAnagrafiche.NascitaOSede := LRTrim(Substr(riga,122,30)) */
        mcAnagrafiche.row.NascitaOSede = CPLib.LRTrim(CPLib.Substr(riga,122,30));
        /* mcAnagrafiche.DataDiNascita := iif(LRTrim(Substr(riga,152,8))='00000000','',LRTrim(Substr(riga,152,8))) */
        mcAnagrafiche.row.DataDiNascita = (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,152,8)),"00000000")?"":CPLib.LRTrim(CPLib.Substr(riga,152,8)));
        /* mcAnagrafiche.Indirizzo := LRTrim(Substr(riga,160,35)) */
        mcAnagrafiche.row.Indirizzo = CPLib.LRTrim(CPLib.Substr(riga,160,35));
        /* mcAnagrafiche.CAP := LRTrim(Substr(riga,195,5)) */
        mcAnagrafiche.row.CAP = CPLib.LRTrim(CPLib.Substr(riga,195,5));
        /* mcAnagrafiche.CAB := LRTrim(Substr(riga,200,6)) */
        mcAnagrafiche.row.CAB = CPLib.LRTrim(CPLib.Substr(riga,200,6));
        /* mcAnagrafiche.Localita := LRTrim(Substr(riga,206,30)) */
        mcAnagrafiche.row.Localita = CPLib.LRTrim(CPLib.Substr(riga,206,30));
        /* mcAnagrafiche.Provincia := LRTrim(Substr(riga,236,2)) */
        mcAnagrafiche.row.Provincia = CPLib.LRTrim(CPLib.Substr(riga,236,2));
        /* mcAnagrafiche.Stato := LRTrim(Substr(riga,238,3)) */
        mcAnagrafiche.row.Stato = CPLib.LRTrim(CPLib.Substr(riga,238,3));
        /* mcAnagrafiche.TipoDocumento := LRTrim(Substr(riga,241,2)) */
        mcAnagrafiche.row.TipoDocumento = CPLib.LRTrim(CPLib.Substr(riga,241,2));
        /* mcAnagrafiche.NumeroDocumento := LRTrim(Substr(riga,243,15)) */
        mcAnagrafiche.row.NumeroDocumento = CPLib.LRTrim(CPLib.Substr(riga,243,15));
        /* mcAnagrafiche.DataRilascio := iif(LRTrim(Substr(riga,258,8))='00000000','',LRTrim(Substr(riga,258,8))) */
        mcAnagrafiche.row.DataRilascio = (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,258,8)),"00000000")?"":CPLib.LRTrim(CPLib.Substr(riga,258,8)));
        /* mcAnagrafiche.AutoritaRilascio := LRTrim(Substr(riga,266,30)) */
        mcAnagrafiche.row.AutoritaRilascio = CPLib.LRTrim(CPLib.Substr(riga,266,30));
        /* mcAnagrafiche.SAE := iif(LRTrim(Substr(riga,296,3))='000','',LRTrim(Substr(riga,296,3))) */
        mcAnagrafiche.row.SAE = (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,296,3)),"000")?"":CPLib.LRTrim(CPLib.Substr(riga,296,3)));
        /* mcAnagrafiche.RAE := LRTrim(Substr(riga,299,3)) */
        mcAnagrafiche.row.RAE = CPLib.LRTrim(CPLib.Substr(riga,299,3));
        /* mcAnagrafiche.Sesso := LRTrim(Substr(riga,302,1)) */
        mcAnagrafiche.row.Sesso = CPLib.LRTrim(CPLib.Substr(riga,302,1));
        /* mcAnagrafiche.SportelloCapofila := LRTrim(Substr(riga,303,5)) */
        mcAnagrafiche.row.SportelloCapofila = CPLib.LRTrim(CPLib.Substr(riga,303,5));
        /* mcAnagrafiche.CabCapofila := LRTrim(Substr(riga,308,5)) */
        mcAnagrafiche.row.CabCapofila = CPLib.LRTrim(CPLib.Substr(riga,308,5));
        /* mcAnagrafiche.DataCensimento := LRTrim(Substr(riga,313,8)) */
        mcAnagrafiche.row.DataCensimento = CPLib.LRTrim(CPLib.Substr(riga,313,8));
        /* mcAnagrafiche.TipoSoggetto := LRTrim(Substr(riga,321,1)) */
        mcAnagrafiche.row.TipoSoggetto = CPLib.LRTrim(CPLib.Substr(riga,321,1));
        /* mcAnagrafiche.SoggettoOccasionale := LRTrim(Substr(riga,322,1)) */
        mcAnagrafiche.row.SoggettoOccasionale = CPLib.LRTrim(CPLib.Substr(riga,322,1));
        /* mcAnagrafiche.Cognome := LRTrim(Substr(riga,323,45)) */
        mcAnagrafiche.row.Cognome = CPLib.LRTrim(CPLib.Substr(riga,323,45));
        /* mcAnagrafiche.Nome := LRTrim(Substr(riga,368,30)) */
        mcAnagrafiche.row.Nome = CPLib.LRTrim(CPLib.Substr(riga,368,30));
        /* mcAnagrafiche.ProvinciaNascita := LRTrim(Substr(riga,398,2)) */
        mcAnagrafiche.row.ProvinciaNascita = CPLib.LRTrim(CPLib.Substr(riga,398,2));
        /* mcAnagrafiche.StatoNascita := LRTrim(Substr(riga,400,3)) */
        mcAnagrafiche.row.StatoNascita = CPLib.LRTrim(CPLib.Substr(riga,400,3));
        /* mcAnagrafiche.FormaGiuridica := LRTrim(Substr(riga,403,5)) */
        mcAnagrafiche.row.FormaGiuridica = CPLib.LRTrim(CPLib.Substr(riga,403,5));
        /* mcAnagrafiche.DataCostituzione := LRTrim(Substr(riga,408,8)) */
        mcAnagrafiche.row.DataCostituzione = CPLib.LRTrim(CPLib.Substr(riga,408,8));
        /* mcAnagrafiche.Note := LRTrim(Substr(riga,416,60)) */
        mcAnagrafiche.row.Note = CPLib.LRTrim(CPLib.Substr(riga,416,60));
        /* mcAnagrafiche.DataRiferimento := iif(LRTrim(Substr(riga,476,8))='00000000','',LRTrim(Substr(riga,476,8))) */
        mcAnagrafiche.row.DataRiferimento = (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,476,8)),"00000000")?"":CPLib.LRTrim(CPLib.Substr(riga,476,8)));
        /* mcAnagrafiche.FlagAsiloPolitico := LRTrim(Substr(riga,484,1)) */
        mcAnagrafiche.row.FlagAsiloPolitico = CPLib.LRTrim(CPLib.Substr(riga,484,1));
        /* mcAnagrafiche.PrevalenteAttivita := LRTrim(Substr(riga,485,3)) */
        mcAnagrafiche.row.PrevalenteAttivita = CPLib.LRTrim(CPLib.Substr(riga,485,3));
        /* mcAnagrafiche.ComportamentoTenuto := LRTrim(Substr(riga,488,1)) */
        mcAnagrafiche.row.ComportamentoTenuto = CPLib.LRTrim(CPLib.Substr(riga,488,1));
        /* mcAnagrafiche.ModalitaAcquisizione := LRTrim(Substr(riga,489,1)) */
        mcAnagrafiche.row.ModalitaAcquisizione = CPLib.LRTrim(CPLib.Substr(riga,489,1));
        /* mcAnagrafiche.PatrimonioIntermediario := LRTrim(Substr(riga,490,1)) */
        mcAnagrafiche.row.PatrimonioIntermediario = CPLib.LRTrim(CPLib.Substr(riga,490,1));
        /* mcAnagrafiche.CapacitaPatrimoniale := LRTrim(Substr(riga,491,1)) */
        mcAnagrafiche.row.CapacitaPatrimoniale = CPLib.LRTrim(CPLib.Substr(riga,491,1));
        /* mcAnagrafiche.Flag231 := LRTrim(Substr(riga,492,1)) */
        mcAnagrafiche.row.Flag231 = CPLib.LRTrim(CPLib.Substr(riga,492,1));
        /* mcAnagrafiche.NazionalitaISO := LRTrim(Substr(riga,493,3)) */
        mcAnagrafiche.row.NazionalitaISO = CPLib.LRTrim(CPLib.Substr(riga,493,3));
        /* mcAnagrafiche.SocietaNonQuotata := LRTrim(Substr(riga,496,1)) */
        mcAnagrafiche.row.SocietaNonQuotata = CPLib.LRTrim(CPLib.Substr(riga,496,1));
        /* mcAnagrafiche.PrecedentiPenali := LRTrim(Substr(riga,497,1)) */
        mcAnagrafiche.row.PrecedentiPenali = CPLib.LRTrim(CPLib.Substr(riga,497,1));
        /* mcAnagrafiche.AffidabilitaFinanziaria := LRTrim(Substr(riga,498,1)) */
        mcAnagrafiche.row.AffidabilitaFinanziaria = CPLib.LRTrim(CPLib.Substr(riga,498,1));
        /* mcAnagrafiche.ProcedureConcorsuali := LRTrim(Substr(riga,499,1)) */
        mcAnagrafiche.row.ProcedureConcorsuali = CPLib.LRTrim(CPLib.Substr(riga,499,1));
        /* mcAnagrafiche.ProfiloRischio := LRTrim(Substr(riga,500,5)) */
        mcAnagrafiche.row.ProfiloRischio = CPLib.LRTrim(CPLib.Substr(riga,500,5));
        /* mcAnagrafiche.ATECO := LRTrim(Substr(riga,505,6)) */
        mcAnagrafiche.row.ATECO = CPLib.LRTrim(CPLib.Substr(riga,505,6));
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void ImportCollegamenti() throws Exception {
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
    fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If Len(LRTrim(riga)) > 0 */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
        /* mcCollegamento.AppendBlank() */
        mcCollegamento.AppendBlank();
        /* mcCollegamento.CodiceIstituto := LRTrim(Left(riga,11)) */
        mcCollegamento.row.CodiceIstituto = CPLib.LRTrim(CPLib.Left(riga,11));
        /* mcCollegamento.DataElaborazione := LRTrim(Substr(riga,12,8)) */
        mcCollegamento.row.DataElaborazione = CPLib.LRTrim(CPLib.Substr(riga,12,8));
        /* mcCollegamento.ProceduraOrigine := LRTrim(Substr(riga,20,3)) */
        mcCollegamento.row.ProceduraOrigine = CPLib.LRTrim(CPLib.Substr(riga,20,3));
        /* mcCollegamento.NumeroElettronicoOperante := LRTrim(Substr(riga,23,9)) */
        mcCollegamento.row.NumeroElettronicoOperante = CPLib.LRTrim(CPLib.Substr(riga,23,9));
        /* mcCollegamento.SottoNumeroOperazione := LRTrim(Substr(riga,32,9)) */
        mcCollegamento.row.SottoNumeroOperazione = CPLib.LRTrim(CPLib.Substr(riga,32,9));
        /* mcCollegamento.CodiceCliente := LRTrim(Substr(riga,41,16)) */
        mcCollegamento.row.CodiceCliente = CPLib.LRTrim(CPLib.Substr(riga,41,16));
        /* mcCollegamento.RuoloCliente := LRTrim(Substr(riga,57,1)) */
        mcCollegamento.row.RuoloCliente = CPLib.LRTrim(CPLib.Substr(riga,57,1));
        /* mcCollegamento.EsecutoreOperazione := LRTrim(Substr(riga,58,1)) */
        mcCollegamento.row.EsecutoreOperazione = CPLib.LRTrim(CPLib.Substr(riga,58,1));
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void ImportBeneficiari() throws Exception {
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
    fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If Len(LRTrim(riga)) > 0 */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
        /* mcControparti.AppendWithKey(Left(riga,40)) */
        mcControparti.AppendWithKey(CPLib.Left(riga,40));
        /* mcControparti.CodiceIstituto := LRTrim(Left(riga,11)) */
        mcControparti.row.CodiceIstituto = CPLib.LRTrim(CPLib.Left(riga,11));
        /* mcControparti.DataElaborazione := LRTrim(Substr(riga,12,8)) */
        mcControparti.row.DataElaborazione = CPLib.LRTrim(CPLib.Substr(riga,12,8));
        /* mcControparti.ProceduraOrigine := LRTrim(Substr(riga,20,3)) */
        mcControparti.row.ProceduraOrigine = CPLib.LRTrim(CPLib.Substr(riga,20,3));
        /* mcControparti.NumeroElettronicoOperante := LRTrim(Substr(riga,23,9)) */
        mcControparti.row.NumeroElettronicoOperante = CPLib.LRTrim(CPLib.Substr(riga,23,9));
        /* mcControparti.SottoNumeroOperazione := LRTrim(Substr(riga,32,9)) */
        mcControparti.row.SottoNumeroOperazione = CPLib.LRTrim(CPLib.Substr(riga,32,9));
        /* mcControparti.TipoRapportoBeneficiario := LRTrim(Substr(riga,41,1)) */
        mcControparti.row.TipoRapportoBeneficiario = CPLib.LRTrim(CPLib.Substr(riga,41,1));
        /* mcControparti.CodiceBeneficiario := LRTrim(Substr(riga,42,16)) */
        mcControparti.row.CodiceBeneficiario = CPLib.LRTrim(CPLib.Substr(riga,42,16));
        /* mcControparti.CodiceRapporto := LRTrim(Substr(riga,58,25)) */
        mcControparti.row.CodiceRapporto = CPLib.LRTrim(CPLib.Substr(riga,58,25));
        /* mcControparti.NomeBeneficiario := LRTrim(Substr(riga,83,70)) */
        mcControparti.row.NomeBeneficiario = CPLib.LRTrim(CPLib.Substr(riga,83,70));
        /* mcControparti.IndirizzoBeneficiario := LRTrim(Substr(riga,153,35)) */
        mcControparti.row.IndirizzoBeneficiario = CPLib.LRTrim(CPLib.Substr(riga,153,35));
        /* mcControparti.CapBeneficiario := LRTrim(Substr(riga,188,5)) */
        mcControparti.row.CapBeneficiario = CPLib.LRTrim(CPLib.Substr(riga,188,5));
        /* mcControparti.CabBeneficiario := LRTrim(Substr(riga,193,6)) */
        mcControparti.row.CabBeneficiario = CPLib.LRTrim(CPLib.Substr(riga,193,6));
        /* mcControparti.LocalitaBeneficiario := LRTrim(Substr(riga,199,30)) */
        mcControparti.row.LocalitaBeneficiario = CPLib.LRTrim(CPLib.Substr(riga,199,30));
        /* mcControparti.ProvinciaBeneficiario := LRTrim(Substr(riga,229,2)) */
        mcControparti.row.ProvinciaBeneficiario = CPLib.LRTrim(CPLib.Substr(riga,229,2));
        /* mcControparti.StatoBeneficiario := LRTrim(Substr(riga,231,3)) */
        mcControparti.row.StatoBeneficiario = CPLib.LRTrim(CPLib.Substr(riga,231,3));
        /* mcControparti.TipoIntermediario := LRTrim(Substr(riga,234,2)) */
        mcControparti.row.TipoIntermediario = CPLib.LRTrim(CPLib.Substr(riga,234,2));
        /* mcControparti.CodiceIntermediario := LRTrim(Substr(riga,236,11)) */
        mcControparti.row.CodiceIntermediario = CPLib.LRTrim(CPLib.Substr(riga,236,11));
        /* mcControparti.CodiceStatoBanca := LRTrim(Substr(riga,247,3)) */
        mcControparti.row.CodiceStatoBanca = CPLib.LRTrim(CPLib.Substr(riga,247,3));
        /* mcControparti.CabBanca := LRTrim(Substr(riga,250,6)) */
        mcControparti.row.CabBanca = CPLib.LRTrim(CPLib.Substr(riga,250,6));
        /* mcControparti.ComuneBanca := LRTrim(Substr(riga,256,30)) */
        mcControparti.row.ComuneBanca = CPLib.LRTrim(CPLib.Substr(riga,256,30));
        /* mcControparti.ProvinciaBanca := LRTrim(Substr(riga,286,2)) */
        mcControparti.row.ProvinciaBanca = CPLib.LRTrim(CPLib.Substr(riga,286,2));
        /* mcControparti.DescrizioneIntermediario := LRTrim(Substr(riga,288,50)) */
        mcControparti.row.DescrizioneIntermediario = CPLib.LRTrim(CPLib.Substr(riga,288,50));
        /* mcControparti.SaveRow() */
        mcControparti.SaveRow();
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void Anagrafiche() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* oMaster Object(armt_personboBO) */
      armt_personboBO oMaster;
      oMaster = null;
      /* _connes Char(16) */
      String _connes;
      _connes = CPLib.Space(16);
      /* _stato Char(40) */
      String _stato;
      _stato = CPLib.Space(40);
      /* _modificato Bool */
      boolean _modificato;
      _modificato = false;
      /* _tiposog Char(1) */
      String _tiposog;
      _tiposog = CPLib.Space(1);
      /* gMsgProc := gMsgProc + 'Ora Inizio Caricamento Anagrafiche: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inizio Caricamento Anagrafiche: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      for (MemoryCursorRow_mcanagrafiche_mcrdef rwAnagrafiche : mcAnagraficheRapporti._iterable_()) {
        /* gMsgImp := 'Processo soggetto con codice: '+LRTrim(rwAnagrafiche.CodiceCliente) // Variabile per messaggi Elaborazione */
        gMsgImp = "Processo soggetto con codice: "+CPLib.LRTrim(rwAnagrafiche.CodiceCliente);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _modificato := False */
        _modificato = false;
        /* _connes := '' */
        _connes = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rwAnagrafiche.CodiceCliente),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(rwAnagrafiche.CodiceCliente));
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
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unifactor returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _connes = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* oMaster := new armt_personboBO() */
        oMaster = new armt_personboBO(m_Ctx);
        /* oMaster.Initialize() */
        oMaster.Initialize();
        /* oMaster.Set_COMPLETA(False) */
        oMaster.Set_COMPLETA(false);
        /* If not(Empty(_connes)) */
        if ( ! (CPLib.Empty(_connes))) {
          /* oMaster.Load(_connes) */
          oMaster.Load(_connes);
          /* _modificato := _modificato or (LRTrim(oMaster.w_RAGSOC)<>LRTrim(rwAnagrafiche.Intestazione)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_RAGSOC),CPLib.LRTrim(rwAnagrafiche.Intestazione)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_PAESE)<>LRTrim(rwAnagrafiche.Stato)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_PAESE),CPLib.LRTrim(rwAnagrafiche.Stato)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_DESCCIT)<>LRTrim(rwAnagrafiche.Localita)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_DESCCIT),CPLib.LRTrim(rwAnagrafiche.Localita)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_PROVINCIA)<>LRTrim(rwAnagrafiche.Provincia)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_PROVINCIA),CPLib.LRTrim(rwAnagrafiche.Provincia)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_CAP)<>LRTrim(rwAnagrafiche.CAP)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_CAP),CPLib.LRTrim(rwAnagrafiche.CAP)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_CODCAB)<>LRTrim(rwAnagrafiche.CAB)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_CODCAB),CPLib.LRTrim(rwAnagrafiche.CAB)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_DOMICILIO)<>LRTrim(rwAnagrafiche.Indirizzo)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_DOMICILIO),CPLib.LRTrim(rwAnagrafiche.Indirizzo)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_SOTGRUP)<>LRTrim(rwAnagrafiche.SAE)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_SOTGRUP),CPLib.LRTrim(rwAnagrafiche.SAE)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_ATTIV)<>LRTrim(rwAnagrafiche.ATECO)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_ATTIV),CPLib.LRTrim(rwAnagrafiche.ATECO)));
          /* _tiposog := iif(LRTrim(rwAnagrafiche.TipoSoggetto)='F','P','G') */
          _tiposog = (CPLib.eqr(CPLib.LRTrim(rwAnagrafiche.TipoSoggetto),"F")?"P":"G");
          /* _modificato := _modificato or (LRTrim(oMaster.w_TIPOPERS)<>_tiposog) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_TIPOPERS),_tiposog));
          /* If LRTrim(rwAnagrafiche.TipoSoggetto)='F' */
          if (CPLib.eqr(CPLib.LRTrim(rwAnagrafiche.TipoSoggetto),"F")) {
            /* _modificato := _modificato or (LRTrim(oMaster.w_COGNOME)<>LRTrim(rwAnagrafiche.Cognome)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_COGNOME),CPLib.LRTrim(rwAnagrafiche.Cognome)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_NOME)<>LRTrim(rwAnagrafiche.Nome)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_NOME),CPLib.LRTrim(rwAnagrafiche.Nome)));
            /* _modificato := _modificato or (oMaster.w_DATANASC<>CharToDate(LRTrim(rwAnagrafiche.DataDiNascita))) */
            _modificato = _modificato || (CPLib.ne(oMaster.w_DATANASC,CPLib.CharToDate(CPLib.LRTrim(rwAnagrafiche.DataDiNascita))));
            /* _modificato := _modificato or (LRTrim(oMaster.w_TIPINTER)<>LRTrim(rwAnagrafiche.ProvinciaNascita)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_TIPINTER),CPLib.LRTrim(rwAnagrafiche.ProvinciaNascita)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_SESSO)<>LRTrim(rwAnagrafiche.Sesso)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_SESSO),CPLib.LRTrim(rwAnagrafiche.Sesso)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_NASCOMUN)<>LRTrim(rwAnagrafiche.NascitaOSede)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_NASCOMUN),CPLib.LRTrim(rwAnagrafiche.NascitaOSede)));
            /* _stato := '' */
            _stato = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rwAnagrafiche.StatoNascita),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(rwAnagrafiche.StatoNascita));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _stato = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unifactor returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _stato = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _modificato := _modificato or (LRTrim(oMaster.w_NASSTATO)<>LRTrim(_stato)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_NASSTATO),CPLib.LRTrim(_stato)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_TIPODOC)<>LRTrim(rwAnagrafiche.TipoDocumento)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_TIPODOC),CPLib.LRTrim(rwAnagrafiche.TipoDocumento)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_NUMDOCUM)<>LRTrim(rwAnagrafiche.NumeroDocumento)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_NUMDOCUM),CPLib.LRTrim(rwAnagrafiche.NumeroDocumento)));
            /* _modificato := _modificato or (oMaster.w_DATARILASC<>CharToDate(LRTrim(rwAnagrafiche.DataRilascio))) */
            _modificato = _modificato || (CPLib.ne(oMaster.w_DATARILASC,CPLib.CharToDate(CPLib.LRTrim(rwAnagrafiche.DataRilascio))));
            /* _modificato := _modificato or (LRTrim(oMaster.w_AUTRILASC)<>LRTrim(rwAnagrafiche.AutoritaRilascio)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_AUTRILASC),CPLib.LRTrim(rwAnagrafiche.AutoritaRilascio)));
          } // End If
          /* _modificato := _modificato or (LRTrim(oMaster.w_CODFISC)<>LRTrim(rwAnagrafiche.CodiceFiscale)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_CODFISC),CPLib.LRTrim(rwAnagrafiche.CodiceFiscale)));
          /* If mcCategoria.HasKey(LRTrim(rwAnagrafiche.CodiceCliente)) */
          if (mcCategoria.HasKey(CPLib.LRTrim(rwAnagrafiche.CodiceCliente))) {
            /* mcCategoria.GoToKey(LRTrim(rwAnagrafiche.CodiceCliente)) */
            mcCategoria.GoToKey(CPLib.LRTrim(rwAnagrafiche.CodiceCliente));
            /* If LRTrim(mcCategoria.COD_TIPO_SOGG)='PG' */
            if (CPLib.eqr(CPLib.LRTrim(mcCategoria.row.COD_TIPO_SOGG),"PG")) {
              /* _modificato := _modificato or (LRTrim(oMaster.w_ATTIV)<>LRTrim(mcCategoria.COD_ATECO)) */
              _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_ATTIV),CPLib.LRTrim(mcCategoria.row.COD_ATECO)));
              /* _modificato := _modificato or (LRTrim(oMaster.w_PKTBSPECIE)<>LRTrim(mcCategoria.COD_SPEC_GIUR)) */
              _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_PKTBSPECIE),CPLib.LRTrim(mcCategoria.row.COD_SPEC_GIUR)));
            } // End If
          } // End If
        } else { // Else
          /* _modificato := True */
          _modificato = true;
        } // End If
        /* If _modificato */
        if (_modificato) {
          /* oMaster.Set_RAGSOC(LRTrim(rwAnagrafiche.Intestazione)) */
          oMaster.Set_RAGSOC(CPLib.LRTrim(rwAnagrafiche.Intestazione));
          /* oMaster.Set_PAESE(LRTrim(rwAnagrafiche.Stato)) */
          oMaster.Set_PAESE(CPLib.LRTrim(rwAnagrafiche.Stato));
          /* oMaster.Set_DESCCIT(LRTrim(rwAnagrafiche.Localita)) */
          oMaster.Set_DESCCIT(CPLib.LRTrim(rwAnagrafiche.Localita));
          /* oMaster.Set_PROVINCIA(LRTrim(rwAnagrafiche.Provincia)) */
          oMaster.Set_PROVINCIA(CPLib.LRTrim(rwAnagrafiche.Provincia));
          /* oMaster.Set_CAP(LRTrim(rwAnagrafiche.CAP)) */
          oMaster.Set_CAP(CPLib.LRTrim(rwAnagrafiche.CAP));
          /* oMaster.Set_CODCAB(LRTrim(rwAnagrafiche.CAB)) */
          oMaster.Set_CODCAB(CPLib.LRTrim(rwAnagrafiche.CAB));
          /* oMaster.Set_DOMICILIO(LRTrim(rwAnagrafiche.Indirizzo)) */
          oMaster.Set_DOMICILIO(CPLib.LRTrim(rwAnagrafiche.Indirizzo));
          /* oMaster.Set_SOTGRUP(LRTrim(rwAnagrafiche.SAE)) */
          oMaster.Set_SOTGRUP(CPLib.LRTrim(rwAnagrafiche.SAE));
          /* oMaster.Set_ATTIV(LRTrim(rwAnagrafiche.ATECO)) */
          oMaster.Set_ATTIV(CPLib.LRTrim(rwAnagrafiche.ATECO));
          /* oMaster.Set_TIPOPERS(iif(LRTrim(rwAnagrafiche.TipoSoggetto)='F','P','G')) */
          oMaster.Set_TIPOPERS((CPLib.eqr(CPLib.LRTrim(rwAnagrafiche.TipoSoggetto),"F")?"P":"G"));
          /* If LRTrim(rwAnagrafiche.TipoSoggetto)='F' */
          if (CPLib.eqr(CPLib.LRTrim(rwAnagrafiche.TipoSoggetto),"F")) {
            /* oMaster.Set_COGNOME(LRTrim(rwAnagrafiche.Cognome)) */
            oMaster.Set_COGNOME(CPLib.LRTrim(rwAnagrafiche.Cognome));
            /* oMaster.Set_NOME(LRTrim(rwAnagrafiche.Nome)) */
            oMaster.Set_NOME(CPLib.LRTrim(rwAnagrafiche.Nome));
            /* oMaster.Calculation_UEZIABOGNW() */
            oMaster.Calculation_UEZIABOGNW();
            /* oMaster.Set_DATANASC(CharToDate(LRTrim(rwAnagrafiche.DataDiNascita))) */
            oMaster.Set_DATANASC(CPLib.CharToDate(CPLib.LRTrim(rwAnagrafiche.DataDiNascita)));
            /* oMaster.Set_TIPINTER(LRTrim(rwAnagrafiche.ProvinciaNascita)) */
            oMaster.Set_TIPINTER(CPLib.LRTrim(rwAnagrafiche.ProvinciaNascita));
            /* oMaster.Set_SESSO(LRTrim(rwAnagrafiche.Sesso)) */
            oMaster.Set_SESSO(CPLib.LRTrim(rwAnagrafiche.Sesso));
            /* oMaster.Set_NASCOMUN(LRTrim(rwAnagrafiche.NascitaOSede)) */
            oMaster.Set_NASCOMUN(CPLib.LRTrim(rwAnagrafiche.NascitaOSede));
            /* _stato := '' */
            _stato = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rwAnagrafiche.StatoNascita),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(rwAnagrafiche.StatoNascita));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _stato = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unifactor returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _stato = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* oMaster.Set_NASSTATO(LRTrim(_stato)) */
            oMaster.Set_NASSTATO(CPLib.LRTrim(_stato));
            /* oMaster.Set_TIPODOC(LRTrim(rwAnagrafiche.TipoDocumento)) */
            oMaster.Set_TIPODOC(CPLib.LRTrim(rwAnagrafiche.TipoDocumento));
            /* oMaster.Set_NUMDOCUM(LRTrim(rwAnagrafiche.NumeroDocumento)) */
            oMaster.Set_NUMDOCUM(CPLib.LRTrim(rwAnagrafiche.NumeroDocumento));
            /* oMaster.Set_DATARILASC(CharToDate(LRTrim(rwAnagrafiche.DataRilascio))) */
            oMaster.Set_DATARILASC(CPLib.CharToDate(CPLib.LRTrim(rwAnagrafiche.DataRilascio)));
            /* oMaster.Set_AUTRILASC(LRTrim(rwAnagrafiche.AutoritaRilascio)) */
            oMaster.Set_AUTRILASC(CPLib.LRTrim(rwAnagrafiche.AutoritaRilascio));
          } // End If
          /* oMaster.Set_CODFISC(LRTrim(rwAnagrafiche.CodiceFiscale)) */
          oMaster.Set_CODFISC(CPLib.LRTrim(rwAnagrafiche.CodiceFiscale));
          /* oMaster.Set_CONNES(LRTrim(rwAnagrafiche.CodiceCliente)) */
          oMaster.Set_CONNES(CPLib.LRTrim(rwAnagrafiche.CodiceCliente));
          /* If mcCategoria.HasKey(LRTrim(rwAnagrafiche.CodiceCliente)) */
          if (mcCategoria.HasKey(CPLib.LRTrim(rwAnagrafiche.CodiceCliente))) {
            /* mcCategoria.GoToKey(LRTrim(rwAnagrafiche.CodiceCliente)) */
            mcCategoria.GoToKey(CPLib.LRTrim(rwAnagrafiche.CodiceCliente));
            /* If LRTrim(mcCategoria.COD_TIPO_SOGG)='PG' */
            if (CPLib.eqr(CPLib.LRTrim(mcCategoria.row.COD_TIPO_SOGG),"PG")) {
              /* oMaster.Set_ATTIV(LRTrim(mcCategoria.COD_ATECO)) */
              oMaster.Set_ATTIV(CPLib.LRTrim(mcCategoria.row.COD_ATECO));
              /* oMaster.Set_PKTBSPECIE(LRTrim(mcCategoria.COD_SPEC_GIUR)) */
              oMaster.Set_PKTBSPECIE(CPLib.LRTrim(mcCategoria.row.COD_SPEC_GIUR));
            } // End If
          } // End If
          /* oMaster.Calculate() */
          oMaster.Calculate();
          /* oMaster.Save() */
          oMaster.Save();
          /* If not(Empty(oMaster.m_cLastMsgError)) */
          if ( ! (CPLib.Empty(oMaster.m_cLastMsgError))) {
            /* gMsgProc := gMsgProc + "Errore nell'elaborazione del soggetto  "+ LRTrim(rwAnagrafiche.CodiceCliente) +": "+LRTrim(oMaster.m_cLastMsgError)+ NL */
            gMsgProc = gMsgProc+"Errore nell'elaborazione del soggetto  "+CPLib.LRTrim(rwAnagrafiche.CodiceCliente)+": "+CPLib.LRTrim(oMaster.m_cLastMsgError)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
        } // End If
      }
      for (MemoryCursorRow_mcanagrafiche_mcrdef rwAnagrafiche : mcAnagraficheMovimenti._iterable_()) {
        /* gMsgImp := 'Processo soggetto con codice: '+LRTrim(rwAnagrafiche.CodiceCliente) // Variabile per messaggi Elaborazione */
        gMsgImp = "Processo soggetto con codice: "+CPLib.LRTrim(rwAnagrafiche.CodiceCliente);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _modificato := False */
        _modificato = false;
        /* _connes := '' */
        _connes = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rwAnagrafiche.CodiceCliente),"C",16,0,m_cServer),m_cServer,CPLib.LRTrim(rwAnagrafiche.CodiceCliente));
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
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_unifactor returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _connes = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* oMaster := new armt_personboBO() */
        oMaster = new armt_personboBO(m_Ctx);
        /* oMaster.Initialize() */
        oMaster.Initialize();
        /* oMaster.Set_COMPLETA(False) */
        oMaster.Set_COMPLETA(false);
        /* If not(Empty(_connes)) */
        if ( ! (CPLib.Empty(_connes))) {
          /* oMaster.Load(_connes) */
          oMaster.Load(_connes);
          /* _modificato := _modificato or (LRTrim(oMaster.w_RAGSOC)<>LRTrim(rwAnagrafiche.Intestazione)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_RAGSOC),CPLib.LRTrim(rwAnagrafiche.Intestazione)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_PAESE)<>LRTrim(rwAnagrafiche.Stato)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_PAESE),CPLib.LRTrim(rwAnagrafiche.Stato)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_DESCCIT)<>LRTrim(rwAnagrafiche.Localita)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_DESCCIT),CPLib.LRTrim(rwAnagrafiche.Localita)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_PROVINCIA)<>LRTrim(rwAnagrafiche.Provincia)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_PROVINCIA),CPLib.LRTrim(rwAnagrafiche.Provincia)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_CAP)<>LRTrim(rwAnagrafiche.CAP)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_CAP),CPLib.LRTrim(rwAnagrafiche.CAP)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_CODCAB)<>LRTrim(rwAnagrafiche.CAB)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_CODCAB),CPLib.LRTrim(rwAnagrafiche.CAB)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_DOMICILIO)<>LRTrim(rwAnagrafiche.Indirizzo)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_DOMICILIO),CPLib.LRTrim(rwAnagrafiche.Indirizzo)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_SOTGRUP)<>LRTrim(rwAnagrafiche.SAE)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_SOTGRUP),CPLib.LRTrim(rwAnagrafiche.SAE)));
          /* _modificato := _modificato or (LRTrim(oMaster.w_ATTIV)<>LRTrim(rwAnagrafiche.ATECO)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_ATTIV),CPLib.LRTrim(rwAnagrafiche.ATECO)));
          /* _tiposog := iif(LRTrim(rwAnagrafiche.TipoSoggetto)='F','P','G') */
          _tiposog = (CPLib.eqr(CPLib.LRTrim(rwAnagrafiche.TipoSoggetto),"F")?"P":"G");
          /* _modificato := _modificato or (LRTrim(oMaster.w_TIPOPERS)<>_tiposog) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_TIPOPERS),_tiposog));
          /* If LRTrim(rwAnagrafiche.TipoSoggetto)='F' */
          if (CPLib.eqr(CPLib.LRTrim(rwAnagrafiche.TipoSoggetto),"F")) {
            /* _modificato := _modificato or (LRTrim(oMaster.w_COGNOME)<>LRTrim(rwAnagrafiche.Cognome)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_COGNOME),CPLib.LRTrim(rwAnagrafiche.Cognome)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_NOME)<>LRTrim(rwAnagrafiche.Nome)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_NOME),CPLib.LRTrim(rwAnagrafiche.Nome)));
            /* _modificato := _modificato or (oMaster.w_DATANASC<>CharToDate(LRTrim(rwAnagrafiche.DataDiNascita))) */
            _modificato = _modificato || (CPLib.ne(oMaster.w_DATANASC,CPLib.CharToDate(CPLib.LRTrim(rwAnagrafiche.DataDiNascita))));
            /* _modificato := _modificato or (LRTrim(oMaster.w_TIPINTER)<>LRTrim(rwAnagrafiche.ProvinciaNascita)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_TIPINTER),CPLib.LRTrim(rwAnagrafiche.ProvinciaNascita)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_SESSO)<>LRTrim(rwAnagrafiche.Sesso)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_SESSO),CPLib.LRTrim(rwAnagrafiche.Sesso)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_NASCOMUN)<>LRTrim(rwAnagrafiche.NascitaOSede)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_NASCOMUN),CPLib.LRTrim(rwAnagrafiche.NascitaOSede)));
            /* _stato := '' */
            _stato = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rwAnagrafiche.StatoNascita),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(rwAnagrafiche.StatoNascita));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _stato = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unifactor returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _stato = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _modificato := _modificato or (LRTrim(oMaster.w_NASSTATO)<>LRTrim(_stato)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_NASSTATO),CPLib.LRTrim(_stato)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_TIPODOC)<>LRTrim(rwAnagrafiche.TipoDocumento)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_TIPODOC),CPLib.LRTrim(rwAnagrafiche.TipoDocumento)));
            /* _modificato := _modificato or (LRTrim(oMaster.w_NUMDOCUM)<>LRTrim(rwAnagrafiche.NumeroDocumento)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_NUMDOCUM),CPLib.LRTrim(rwAnagrafiche.NumeroDocumento)));
            /* _modificato := _modificato or (oMaster.w_DATARILASC<>CharToDate(LRTrim(rwAnagrafiche.DataRilascio))) */
            _modificato = _modificato || (CPLib.ne(oMaster.w_DATARILASC,CPLib.CharToDate(CPLib.LRTrim(rwAnagrafiche.DataRilascio))));
            /* _modificato := _modificato or (LRTrim(oMaster.w_AUTRILASC)<>LRTrim(rwAnagrafiche.AutoritaRilascio)) */
            _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_AUTRILASC),CPLib.LRTrim(rwAnagrafiche.AutoritaRilascio)));
          } // End If
          /* _modificato := _modificato or (LRTrim(oMaster.w_CODFISC)<>LRTrim(rwAnagrafiche.CodiceFiscale)) */
          _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_CODFISC),CPLib.LRTrim(rwAnagrafiche.CodiceFiscale)));
          /* If mcCategoria.HasKey(LRTrim(rwAnagrafiche.CodiceCliente)) */
          if (mcCategoria.HasKey(CPLib.LRTrim(rwAnagrafiche.CodiceCliente))) {
            /* mcCategoria.GoToKey(LRTrim(rwAnagrafiche.CodiceCliente)) */
            mcCategoria.GoToKey(CPLib.LRTrim(rwAnagrafiche.CodiceCliente));
            /* If LRTrim(mcCategoria.COD_TIPO_SOGG)='PG' */
            if (CPLib.eqr(CPLib.LRTrim(mcCategoria.row.COD_TIPO_SOGG),"PG")) {
              /* _modificato := _modificato or (LRTrim(oMaster.w_ATTIV)<>LRTrim(mcCategoria.COD_ATECO)) */
              _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_ATTIV),CPLib.LRTrim(mcCategoria.row.COD_ATECO)));
              /* _modificato := _modificato or (LRTrim(oMaster.w_PKTBSPECIE)<>LRTrim(mcCategoria.COD_SPEC_GIUR)) */
              _modificato = _modificato || (CPLib.ne(CPLib.LRTrim(oMaster.w_PKTBSPECIE),CPLib.LRTrim(mcCategoria.row.COD_SPEC_GIUR)));
            } // End If
          } // End If
        } else { // Else
          /* _modificato := True */
          _modificato = true;
        } // End If
        /* If _modificato */
        if (_modificato) {
          /* oMaster.Set_RAGSOC(LRTrim(rwAnagrafiche.Intestazione)) */
          oMaster.Set_RAGSOC(CPLib.LRTrim(rwAnagrafiche.Intestazione));
          /* oMaster.Set_PAESE(LRTrim(rwAnagrafiche.Stato)) */
          oMaster.Set_PAESE(CPLib.LRTrim(rwAnagrafiche.Stato));
          /* oMaster.Set_DESCCIT(LRTrim(rwAnagrafiche.Localita)) */
          oMaster.Set_DESCCIT(CPLib.LRTrim(rwAnagrafiche.Localita));
          /* oMaster.Set_PROVINCIA(LRTrim(rwAnagrafiche.Provincia)) */
          oMaster.Set_PROVINCIA(CPLib.LRTrim(rwAnagrafiche.Provincia));
          /* oMaster.Set_CAP(LRTrim(rwAnagrafiche.CAP)) */
          oMaster.Set_CAP(CPLib.LRTrim(rwAnagrafiche.CAP));
          /* oMaster.Set_CODCAB(LRTrim(rwAnagrafiche.CAB)) */
          oMaster.Set_CODCAB(CPLib.LRTrim(rwAnagrafiche.CAB));
          /* oMaster.Set_DOMICILIO(LRTrim(rwAnagrafiche.Indirizzo)) */
          oMaster.Set_DOMICILIO(CPLib.LRTrim(rwAnagrafiche.Indirizzo));
          /* oMaster.Set_SOTGRUP(LRTrim(rwAnagrafiche.SAE)) */
          oMaster.Set_SOTGRUP(CPLib.LRTrim(rwAnagrafiche.SAE));
          /* oMaster.Set_ATTIV(LRTrim(rwAnagrafiche.ATECO)) */
          oMaster.Set_ATTIV(CPLib.LRTrim(rwAnagrafiche.ATECO));
          /* oMaster.Set_TIPOPERS(iif(LRTrim(rwAnagrafiche.TipoSoggetto)='F','P','G')) */
          oMaster.Set_TIPOPERS((CPLib.eqr(CPLib.LRTrim(rwAnagrafiche.TipoSoggetto),"F")?"P":"G"));
          /* If LRTrim(rwAnagrafiche.TipoSoggetto)='F' */
          if (CPLib.eqr(CPLib.LRTrim(rwAnagrafiche.TipoSoggetto),"F")) {
            /* oMaster.Set_COGNOME(LRTrim(rwAnagrafiche.Cognome)) */
            oMaster.Set_COGNOME(CPLib.LRTrim(rwAnagrafiche.Cognome));
            /* oMaster.Set_NOME(LRTrim(rwAnagrafiche.Nome)) */
            oMaster.Set_NOME(CPLib.LRTrim(rwAnagrafiche.Nome));
            /* oMaster.Calculation_UEZIABOGNW() */
            oMaster.Calculation_UEZIABOGNW();
            /* oMaster.Set_DATANASC(CharToDate(LRTrim(rwAnagrafiche.DataDiNascita))) */
            oMaster.Set_DATANASC(CPLib.CharToDate(CPLib.LRTrim(rwAnagrafiche.DataDiNascita)));
            /* oMaster.Set_TIPINTER(LRTrim(rwAnagrafiche.ProvinciaNascita)) */
            oMaster.Set_TIPINTER(CPLib.LRTrim(rwAnagrafiche.ProvinciaNascita));
            /* oMaster.Set_SESSO(LRTrim(rwAnagrafiche.Sesso)) */
            oMaster.Set_SESSO(CPLib.LRTrim(rwAnagrafiche.Sesso));
            /* oMaster.Set_NASCOMUN(LRTrim(rwAnagrafiche.NascitaOSede)) */
            oMaster.Set_NASCOMUN(CPLib.LRTrim(rwAnagrafiche.NascitaOSede));
            /* _stato := '' */
            _stato = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"ISO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rwAnagrafiche.StatoNascita),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(rwAnagrafiche.StatoNascita));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _stato = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arrt_import_unifactor returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _stato = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* oMaster.Set_NASSTATO(LRTrim(_stato)) */
            oMaster.Set_NASSTATO(CPLib.LRTrim(_stato));
            /* oMaster.Set_TIPODOC(LRTrim(rwAnagrafiche.TipoDocumento)) */
            oMaster.Set_TIPODOC(CPLib.LRTrim(rwAnagrafiche.TipoDocumento));
            /* oMaster.Set_NUMDOCUM(LRTrim(rwAnagrafiche.NumeroDocumento)) */
            oMaster.Set_NUMDOCUM(CPLib.LRTrim(rwAnagrafiche.NumeroDocumento));
            /* oMaster.Set_DATARILASC(CharToDate(LRTrim(rwAnagrafiche.DataRilascio))) */
            oMaster.Set_DATARILASC(CPLib.CharToDate(CPLib.LRTrim(rwAnagrafiche.DataRilascio)));
            /* oMaster.Set_AUTRILASC(LRTrim(rwAnagrafiche.AutoritaRilascio)) */
            oMaster.Set_AUTRILASC(CPLib.LRTrim(rwAnagrafiche.AutoritaRilascio));
          } // End If
          /* oMaster.Set_CODFISC(LRTrim(rwAnagrafiche.CodiceFiscale)) */
          oMaster.Set_CODFISC(CPLib.LRTrim(rwAnagrafiche.CodiceFiscale));
          /* oMaster.Set_CONNES(LRTrim(rwAnagrafiche.CodiceCliente)) */
          oMaster.Set_CONNES(CPLib.LRTrim(rwAnagrafiche.CodiceCliente));
          /* If mcCategoria.HasKey(LRTrim(rwAnagrafiche.CodiceCliente)) */
          if (mcCategoria.HasKey(CPLib.LRTrim(rwAnagrafiche.CodiceCliente))) {
            /* mcCategoria.GoToKey(LRTrim(rwAnagrafiche.CodiceCliente)) */
            mcCategoria.GoToKey(CPLib.LRTrim(rwAnagrafiche.CodiceCliente));
            /* If LRTrim(mcCategoria.COD_TIPO_SOGG)='PG' */
            if (CPLib.eqr(CPLib.LRTrim(mcCategoria.row.COD_TIPO_SOGG),"PG")) {
              /* oMaster.Set_ATTIV(LRTrim(mcCategoria.COD_ATECO)) */
              oMaster.Set_ATTIV(CPLib.LRTrim(mcCategoria.row.COD_ATECO));
              /* oMaster.Set_PKTBSPECIE(LRTrim(mcCategoria.COD_SPEC_GIUR)) */
              oMaster.Set_PKTBSPECIE(CPLib.LRTrim(mcCategoria.row.COD_SPEC_GIUR));
            } // End If
          } // End If
          /* oMaster.Calculate() */
          oMaster.Calculate();
          /* oMaster.Save() */
          oMaster.Save();
          /* If not(Empty(oMaster.m_cLastMsgError)) */
          if ( ! (CPLib.Empty(oMaster.m_cLastMsgError))) {
            /* gMsgProc := gMsgProc + "Errore nell'elaborazione del soggetto  "+ LRTrim(rwAnagrafiche.CodiceCliente) +": "+LRTrim(oMaster.m_cLastMsgError)+ NL */
            gMsgProc = gMsgProc+"Errore nell'elaborazione del soggetto  "+CPLib.LRTrim(rwAnagrafiche.CodiceCliente)+": "+CPLib.LRTrim(oMaster.m_cLastMsgError)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
        } // End If
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Caricamento Anagrafiche: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Caricamento Anagrafiche: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
  void Flussi() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tbcauana=null;
    try {
      /* oTitolari Object(armt_rapotitBO) */
      armt_rapotitBO oTitolari;
      oTitolari = null;
      /* oRapporti Object(armt_informazioniBO) */
      armt_informazioniBO oRapporti;
      oRapporti = null;
      /* oFrazionate Object(armt_ofrazionateBO) */
      armt_ofrazionateBO oFrazionate;
      oFrazionate = null;
      /* oOperazioni Object(armt_operazioniBO) */
      armt_operazioniBO oOperazioni;
      oOperazioni = null;
      /* _rapporto Char(25) */
      String _rapporto;
      _rapporto = CPLib.Space(25);
      /* _codvoc Char(2) */
      String _codvoc;
      _codvoc = CPLib.Space(2);
      /* _codcau Char(4) */
      String _codcau;
      _codcau = CPLib.Space(4);
      /* _righe Numeric(3, 0) */
      double _righe;
      _righe = 0;
      /* gMsgProc := gMsgProc + 'Ora Inizio Caricamento Dati Rapporti e Legami: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inizio Caricamento Dati Rapporti e Legami: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      for (MemoryCursorRow_mcflusso_mcrdef rwFlusso : mcFlussiRapporti._iterable_()) {
        /* gMsgImp := 'Processo Informazione con codice: '+LRTrim(rwFlusso.NumeroOperazione) // Variabile per messaggi Elaborazione */
        gMsgImp = "Processo Informazione con codice: "+CPLib.LRTrim(rwFlusso.NumeroOperazione);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Left(rwFlusso.TipoRegistrazione,1)='5' */
        if (CPLib.eqr(CPLib.Left(rwFlusso.TipoRegistrazione,1),"5")) {
          /* If rwFlusso.TipoRegistrazione='55' */
          if (CPLib.eqr(rwFlusso.TipoRegistrazione,"55")) {
            /* oTitolari := new armt_rapotitBO() */
            oTitolari = new armt_rapotitBO(m_Ctx);
            /* oTitolari.Initialize() */
            oTitolari.Initialize();
            /* oTitolari.Set_DATAOPE(CharToDate(rwFlusso.DataOperazione)) */
            oTitolari.Set_DATAOPE(CPLib.CharToDate(rwFlusso.DataOperazione));
            /* oTitolari.Set_DATAREG(Date()) */
            oTitolari.Set_DATAREG(CPLib.Date());
            /* oTitolari.Set_TIPOOPRAP('54') */
            oTitolari.Set_TIPOOPRAP("54");
            for (MemoryCursorRow_mccollegamento_mcrdef rwCollega : mcCollegamentoRapporti._iterable_()) {
              if (CPLib.eqr(rwCollega.CodiceIstituto+rwCollega.DataElaborazione+rwCollega.ProceduraOrigine+rwCollega.NumeroElettronicoOperante+rwCollega.SottoNumeroOperazione,rwFlusso.CodiceIstituto+rwFlusso.DataElaborazione+rwFlusso.ProceduraOrigine+rwFlusso.NumeroElettronicoOperante+rwFlusso.SottoNumeroOperazione)) {
                /* If rwCollega.RuoloCliente='T' or rwCollega.RuoloCliente='C' */
                if (CPLib.eqr(rwCollega.RuoloCliente,"T") || CPLib.eqr(rwCollega.RuoloCliente,"C")) {
                  /* oTitolari.Set_CONNESCLI(rwCollega.CodiceCliente) */
                  oTitolari.Set_CONNESCLI(rwCollega.CodiceCliente);
                } // End If
              }
            }
            /* oTitolari.Save() */
            oTitolari.Save();
            /* Exec Routine arrt_writelog('NUOVO RECORD','RAPOTIT',oTitolari.w_IDBASE) */
            arrt_writelogR.Make(m_Ctx,this).Run("NUOVO RECORD","RAPOTIT",oTitolari.w_IDBASE);
            /* Exec Routine arrt_crea_idereg('T',oTitolari.w_IDBASE,'D') */
            arrt_crea_ideregR.Make(m_Ctx,this).Run("T",oTitolari.w_IDBASE,"D");
            /* Exec Routine arrt_ae_agg_aetesta_tit(oTitolari.w_CONNESCLI) */
            arrt_ae_agg_aetesta_titR.Make(m_Ctx,this).Run(oTitolari.w_CONNESCLI);
          } // End If
          /* oTitolari := new armt_rapotitBO() */
          oTitolari = new armt_rapotitBO(m_Ctx);
          /* oTitolari.Initialize() */
          oTitolari.Initialize();
          /* oTitolari.CtxLoad_ardt_intestit() */
          oTitolari.CtxLoad_ardt_intestit();
          /* oTitolari.Set_DATAOPE(CharToDate(rwFlusso.DataOperazione)) */
          oTitolari.Set_DATAOPE(CPLib.CharToDate(rwFlusso.DataOperazione));
          /* oTitolari.Set_DATAREG(Date()) */
          oTitolari.Set_DATAREG(CPLib.Date());
          /* oTitolari.Set_TIPOOPRAP(rwFlusso.TipoRegistrazione) */
          oTitolari.Set_TIPOOPRAP(rwFlusso.TipoRegistrazione);
          for (MemoryCursorRow_mccollegamento_mcrdef rwCollega : mcCollegamentoRapporti._iterable_()) {
            if (CPLib.eqr(rwCollega.CodiceIstituto+rwCollega.DataElaborazione+rwCollega.ProceduraOrigine+rwCollega.NumeroElettronicoOperante+rwCollega.SottoNumeroOperazione,rwFlusso.CodiceIstituto+rwFlusso.DataElaborazione+rwFlusso.ProceduraOrigine+rwFlusso.NumeroElettronicoOperante+rwFlusso.SottoNumeroOperazione)) {
              /* If rwCollega.RuoloCliente='T' or rwCollega.RuoloCliente='C' */
              if (CPLib.eqr(rwCollega.RuoloCliente,"T") || CPLib.eqr(rwCollega.RuoloCliente,"C")) {
                /* oTitolari.Set_CONNESCLI(rwCollega.CodiceCliente) */
                oTitolari.Set_CONNESCLI(rwCollega.CodiceCliente);
              } // End If
              /* If rwCollega.RuoloCliente='E' and At(rwFlusso.TipoRegistrazione,'|50|58') >0 */
              if (CPLib.eqr(rwCollega.RuoloCliente,"E") && CPLib.gt(CPLib.At(rwFlusso.TipoRegistrazione,"|50|58"),0)) {
                /* oTitolari.ardt_intestit.AddRow() */
                oTitolari.ardt_intestit.AddRow();
                /* oTitolari.ardt_intestit.Set_CODINTER(rwCollega.CodiceCliente) */
                oTitolari.ardt_intestit.Set_CODINTER(rwCollega.CodiceCliente);
                /* oTitolari.ardt_intestit.Set_DATAINI(CharToDate(rwFlusso.DataOperazione)) */
                oTitolari.ardt_intestit.Set_DATAINI(CPLib.CharToDate(rwFlusso.DataOperazione));
                /* oTitolari.ardt_intestit.SaveRow() */
                oTitolari.ardt_intestit.SaveRow();
                /* ElseIf rwCollega.RuoloCliente='E' and rwFlusso.TipoRegistrazione='51' */
              } else if (CPLib.eqr(rwCollega.RuoloCliente,"E") && CPLib.eqr(rwFlusso.TipoRegistrazione,"51")) {
                /* _righe := 0 */
                _righe = CPLib.Round(0,0);
                /* While _righe < oTitolari.ardt_intestit.Rows() */
                while (CPLib.lt(_righe,oTitolari.ardt_intestit.Rows())) {
                  /* oTitolari.ardt_intestit.SetRow(_righe) */
                  oTitolari.ardt_intestit.SetRow(_righe);
                  /* If oTitolari.ardt_intestit.w_CODINTER=rwCollega.CodiceCliente */
                  if (CPLib.eqr(oTitolari.ardt_intestit.w_CODINTER,rwCollega.CodiceCliente)) {
                    /* oTitolari.ardt_intestit.Set_DATAFINE(CharToDate(rwFlusso.DataOperazione)) */
                    oTitolari.ardt_intestit.Set_DATAFINE(CPLib.CharToDate(rwFlusso.DataOperazione));
                    /* oTitolari.ardt_intestit.SaveRow() */
                    oTitolari.ardt_intestit.SaveRow();
                  } // End If
                  /* _righe := _righe + 1 */
                  _righe = CPLib.Round(_righe+1,0);
                } // End While
              } // End If
            }
          }
          /* oTitolari.Save() */
          oTitolari.Save();
          /* Exec Routine arrt_writelog('NUOVO RECORD','RAPOTIT',oTitolari.w_IDBASE) */
          arrt_writelogR.Make(m_Ctx,this).Run("NUOVO RECORD","RAPOTIT",oTitolari.w_IDBASE);
          /* Exec Routine arrt_crea_idereg('T',oTitolari.w_IDBASE,'D') */
          arrt_crea_ideregR.Make(m_Ctx,this).Run("T",oTitolari.w_IDBASE,"D");
          /* Exec Routine arrt_ae_agg_aetesta_tit(oTitolari.w_CONNESCLI) */
          arrt_ae_agg_aetesta_titR.Make(m_Ctx,this).Run(oTitolari.w_CONNESCLI);
        } else { // Else
          /* _rapporto := '' */
          _rapporto = "";
          // * --- Read from anarapbo
          m_cServer = m_Ctx.GetServer("anarapbo");
          m_cPhName = m_Ctx.GetPhName("anarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(rwFlusso.NumeroRapporto),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(rwFlusso.NumeroRapporto));
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
              Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_import_unifactor returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _rapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(_rapporto) */
          if (CPLib.Empty(_rapporto)) {
            // * --- Insert into anarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("anarapbo");
            m_cPhName = m_Ctx.GetPhName("anarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unifactor",137,"000001EE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001EE(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rwFlusso.NumeroRapporto),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQLNull(rwFlusso.TipoRapportoAUI,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rwFlusso.TipoRapportoIntermediario),"?",0,0,m_cServer)+", ";
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_import_unifactor",137,"000001EF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001EF(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(rwFlusso.NumeroRapporto),"?",0,0,m_cServer)+", ";
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
          } // End If
          /* If rwFlusso.TipoRegistrazione='32' */
          if (CPLib.eqr(rwFlusso.TipoRegistrazione,"32")) {
            /* oRapporti := new armt_informazioniBO() */
            oRapporti = new armt_informazioniBO(m_Ctx);
            /* oRapporti.Initialize() */
            oRapporti.Initialize();
            /* oRapporti.Set_RAPPORTO(LRTrim(rwFlusso.NumeroRapporto)) */
            oRapporti.Set_RAPPORTO(CPLib.LRTrim(rwFlusso.NumeroRapporto));
            /* oRapporti.Set_DATAOPE(CharToDate(rwFlusso.DataOperazione)) */
            oRapporti.Set_DATAOPE(CPLib.CharToDate(rwFlusso.DataOperazione));
            /* oRapporti.Set_DATAREG(Date()) */
            oRapporti.Set_DATAREG(CPLib.Date());
            /* oRapporti.Set_TIPOOPRAP('31') */
            oRapporti.Set_TIPOOPRAP("31");
            /* oRapporti.Set_STATOREG('0') */
            oRapporti.Set_STATOREG("0");
            /* oRapporti.Save() */
            oRapporti.Save();
            /* Exec Routine arrt_writelog('NUOVO RECORD','RAPOPEBO',oRapporti.w_IDBASE) */
            arrt_writelogR.Make(m_Ctx,this).Run("NUOVO RECORD","RAPOPEBO",oRapporti.w_IDBASE);
            /* Exec Routine arrt_crea_idereg('I',oRapporti.w_IDBASE,'D') */
            arrt_crea_ideregR.Make(m_Ctx,this).Run("I",oRapporti.w_IDBASE,"D");
          } // End If
          /* oRapporti := new armt_informazioniBO() */
          oRapporti = new armt_informazioniBO(m_Ctx);
          /* oRapporti.Initialize() */
          oRapporti.Initialize();
          /* oRapporti.CtxLoad_ardt_informazioni() */
          oRapporti.CtxLoad_ardt_informazioni();
          /* oRapporti.CtxLoad_ardt_delegabo() */
          oRapporti.CtxLoad_ardt_delegabo();
          /* oRapporti.Set_RAPPORTO(LRTrim(rwFlusso.NumeroRapporto)) */
          oRapporti.Set_RAPPORTO(CPLib.LRTrim(rwFlusso.NumeroRapporto));
          /* oRapporti.Set_DATAOPE(CharToDate(rwFlusso.DataOperazione)) */
          oRapporti.Set_DATAOPE(CPLib.CharToDate(rwFlusso.DataOperazione));
          /* oRapporti.Set_DATAREG(Date()) */
          oRapporti.Set_DATAREG(CPLib.Date());
          /* oRapporti.Set_TIPOOPRAP(rwFlusso.TipoRegistrazione) */
          oRapporti.Set_TIPOOPRAP(rwFlusso.TipoRegistrazione);
          for (MemoryCursorRow_mccollegamento_mcrdef rwCollega : mcCollegamentoRapporti._iterable_()) {
            if (CPLib.eqr(rwCollega.CodiceIstituto+rwCollega.DataElaborazione+rwCollega.ProceduraOrigine+rwCollega.NumeroElettronicoOperante+rwCollega.SottoNumeroOperazione,rwFlusso.CodiceIstituto+rwFlusso.DataElaborazione+rwFlusso.ProceduraOrigine+rwFlusso.NumeroElettronicoOperante+rwFlusso.SottoNumeroOperazione)) {
              /* If At(LRTrim(rwFlusso.TipoRegistrazione),"|25|28|39|40|41|47") >0 */
              if (CPLib.gt(CPLib.At(CPLib.LRTrim(rwFlusso.TipoRegistrazione),"|25|28|39|40|41|47"),0)) {
                /* If At(LRTrim(rwFlusso.Tipologia),"|28|41|47") >0 */
                if (CPLib.gt(CPLib.At(CPLib.LRTrim(rwFlusso.Tipologia),"|28|41|47"),0)) {
                  /* If rwCollega.RuoloCliente='D' */
                  if (CPLib.eqr(rwCollega.RuoloCliente,"D")) {
                    /* _righe := 0 */
                    _righe = CPLib.Round(0,0);
                    /* While _righe < oRapporti.ardt_delegabo.Rows() */
                    while (CPLib.lt(_righe,oRapporti.ardt_delegabo.Rows())) {
                      /* oRapporti.ardt_delegabo.SetRow(_righe) */
                      oRapporti.ardt_delegabo.SetRow(_righe);
                      /* If oRapporti.ardt_delegabo.w_CODINTER=rwCollega.CodiceCliente */
                      if (CPLib.eqr(oRapporti.ardt_delegabo.w_CODINTER,rwCollega.CodiceCliente)) {
                        /* oRapporti.ardt_delegabo.Set_DATAFINE(CharToDate(rwFlusso.DataOperazione)) */
                        oRapporti.ardt_delegabo.Set_DATAFINE(CPLib.CharToDate(rwFlusso.DataOperazione));
                        /* oRapporti.ardt_delegabo.w_NUMPROG2 := oRapporti.w_NUMPROG */
                        oRapporti.ardt_delegabo.w_NUMPROG2 = oRapporti.w_NUMPROG;
                        /* oRapporti.ardt_delegabo.SaveRow() */
                        oRapporti.ardt_delegabo.SaveRow();
                        /* oRapporti.ardt_delegabo.Calculate() */
                        oRapporti.ardt_delegabo.Calculate();
                      } // End If
                      /* _righe := _righe + 1 */
                      _righe = CPLib.Round(_righe+1,0);
                    } // End While
                    /* ElseIf rwCollega.RuoloCliente='S' */
                  } else if (CPLib.eqr(rwCollega.RuoloCliente,"S")) {
                    /* oRapporti.Set_CONNESOPER(rwCollega.CodiceCliente) */
                    oRapporti.Set_CONNESOPER(rwCollega.CodiceCliente);
                    /* oRapporti.Set_TIPOLEG('3') */
                    oRapporti.Set_TIPOLEG("3");
                  } // End If
                } else { // Else
                  /* If rwCollega.RuoloCliente='D' */
                  if (CPLib.eqr(rwCollega.RuoloCliente,"D")) {
                    /* oRapporti.ardt_delegabo.AddRow() */
                    oRapporti.ardt_delegabo.AddRow();
                    /* oRapporti.ardt_delegabo.Set_CODINTER(rwCollega.CodiceCliente) */
                    oRapporti.ardt_delegabo.Set_CODINTER(rwCollega.CodiceCliente);
                    /* oRapporti.ardt_delegabo.Set_DATAINI(CharToDate(rwFlusso.DataOperazione)) */
                    oRapporti.ardt_delegabo.Set_DATAINI(CPLib.CharToDate(rwFlusso.DataOperazione));
                    /* oRapporti.ardt_delegabo.w_NUMPROG1 := oRapporti.w_NUMPROG */
                    oRapporti.ardt_delegabo.w_NUMPROG1 = oRapporti.w_NUMPROG;
                    /* oRapporti.ardt_informazioni.SaveRow() */
                    oRapporti.ardt_informazioni.SaveRow();
                    /* oRapporti.ardt_delegabo.Calculate() */
                    oRapporti.ardt_delegabo.Calculate();
                    /* ElseIf rwCollega.RuoloCliente='S' */
                  } else if (CPLib.eqr(rwCollega.RuoloCliente,"S")) {
                    /* oRapporti.Set_CONNESOPER(rwCollega.CodiceCliente) */
                    oRapporti.Set_CONNESOPER(rwCollega.CodiceCliente);
                    /* oRapporti.Set_TIPOLEG('3') */
                    oRapporti.Set_TIPOLEG("3");
                  } // End If
                } // End If
                /* ElseIf At(LRTrim(rwFlusso.TipoRegistrazione),"|21|22|23|24|26|27|33|34|35|36|43|44|45|46") >0 */
              } else if (CPLib.gt(CPLib.At(CPLib.LRTrim(rwFlusso.TipoRegistrazione),"|21|22|23|24|26|27|33|34|35|36|43|44|45|46"),0)) {
                /* If At(LRTrim(rwFlusso.TipoRegistrazione),"|26|36|46") >0 */
                if (CPLib.gt(CPLib.At(CPLib.LRTrim(rwFlusso.TipoRegistrazione),"|26|36|46"),0)) {
                  /* If rwCollega.RuoloCliente='T' or rwCollega.RuoloCliente='C' */
                  if (CPLib.eqr(rwCollega.RuoloCliente,"T") || CPLib.eqr(rwCollega.RuoloCliente,"C")) {
                    /* _righe := 0 */
                    _righe = CPLib.Round(0,0);
                    /* While _righe < oRapporti.ardt_informazioni.Rows() */
                    while (CPLib.lt(_righe,oRapporti.ardt_informazioni.Rows())) {
                      /* oRapporti.ardt_informazioni.SetRow(_righe) */
                      oRapporti.ardt_informazioni.SetRow(_righe);
                      /* If oRapporti.ardt_informazioni.w_CODINTER=rwCollega.CodiceCliente */
                      if (CPLib.eqr(oRapporti.ardt_informazioni.w_CODINTER,rwCollega.CodiceCliente)) {
                        /* oRapporti.ardt_informazioni.Set_DATAFINE(CharToDate(rwFlusso.DataOperazione)) */
                        oRapporti.ardt_informazioni.Set_DATAFINE(CPLib.CharToDate(rwFlusso.DataOperazione));
                        /* oRapporti.ardt_informazioni.w_NUMPROG2 := oRapporti.w_NUMPROG */
                        oRapporti.ardt_informazioni.w_NUMPROG2 = oRapporti.w_NUMPROG;
                        /* oRapporti.ardt_informazioni.SaveRow() */
                        oRapporti.ardt_informazioni.SaveRow();
                      } // End If
                      /* _righe := _righe + 1 */
                      _righe = CPLib.Round(_righe+1,0);
                    } // End While
                    /* ElseIf rwCollega.RuoloCliente='S' */
                  } else if (CPLib.eqr(rwCollega.RuoloCliente,"S")) {
                    /* oRapporti.Set_CONNESOPER(rwCollega.CodiceCliente) */
                    oRapporti.Set_CONNESOPER(rwCollega.CodiceCliente);
                    /* oRapporti.Set_TIPOLEG('3') */
                    oRapporti.Set_TIPOLEG("3");
                  } // End If
                } else { // Else
                  /* If rwCollega.RuoloCliente='T' or rwCollega.RuoloCliente='C' */
                  if (CPLib.eqr(rwCollega.RuoloCliente,"T") || CPLib.eqr(rwCollega.RuoloCliente,"C")) {
                    /* oRapporti.ardt_informazioni.AddRow() */
                    oRapporti.ardt_informazioni.AddRow();
                    /* oRapporti.ardt_informazioni.Set_CODINTER(rwCollega.CodiceCliente) */
                    oRapporti.ardt_informazioni.Set_CODINTER(rwCollega.CodiceCliente);
                    /* oRapporti.ardt_informazioni.Set_DATAINI(CharToDate(rwFlusso.DataOperazione)) */
                    oRapporti.ardt_informazioni.Set_DATAINI(CPLib.CharToDate(rwFlusso.DataOperazione));
                    /* oRapporti.ardt_informazioni.w_NUMPROG1 := oRapporti.w_NUMPROG */
                    oRapporti.ardt_informazioni.w_NUMPROG1 = oRapporti.w_NUMPROG;
                    /* oRapporti.ardt_informazioni.SaveRow() */
                    oRapporti.ardt_informazioni.SaveRow();
                    /* oRapporti.ardt_informazioni.Calculate() */
                    oRapporti.ardt_informazioni.Calculate();
                    /* ElseIf rwCollega.RuoloCliente='S' */
                  } else if (CPLib.eqr(rwCollega.RuoloCliente,"S")) {
                    /* oRapporti.Set_CONNESOPER(rwCollega.CodiceCliente) */
                    oRapporti.Set_CONNESOPER(rwCollega.CodiceCliente);
                    /* oRapporti.Set_TIPOLEG('3') */
                    oRapporti.Set_TIPOLEG("3");
                  } // End If
                } // End If
              } // End If
            }
          }
          /* oRapporti.Save() */
          oRapporti.Save();
          /* Exec Routine arrt_writelog('NUOVO RECORD','RAPOPEBO',oRapporti.w_IDBASE) */
          arrt_writelogR.Make(m_Ctx,this).Run("NUOVO RECORD","RAPOPEBO",oRapporti.w_IDBASE);
          /* Exec Routine arrt_crea_idereg('I',oRapporti.w_IDBASE,'D') */
          arrt_crea_ideregR.Make(m_Ctx,this).Run("I",oRapporti.w_IDBASE,"D");
          /* Exec Routine arrt_ae_agg_aetesta(oRapporti.w_RAPPORTO,oRapporti.w_TIPOOPRAP,oRapporti.w_NUMPROG,oRapporti.w_DATAOPE,'N') */
          arrt_ae_agg_aetestaR.Make(m_Ctx,this).Run(oRapporti.w_RAPPORTO,oRapporti.w_TIPOOPRAP,oRapporti.w_NUMPROG,oRapporti.w_DATAOPE,"N");
        } // End If
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Caricamento Dati Rapporti e Legami: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Caricamento Dati Rapporti e Legami: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Inizio Caricamento Movimenti: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inizio Caricamento Movimenti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      for (MemoryCursorRow_mcflusso_mcrdef rwFlusso : mcFlussiMovimenti._iterable_()) {
        /* gMsgImp := 'Processo Informazione con codice: '+LRTrim(rwFlusso.NumeroOperazione) // Variabile per messaggi Elaborazione */
        gMsgImp = "Processo Informazione con codice: "+CPLib.LRTrim(rwFlusso.NumeroOperazione);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from tbcauana
        m_cServer = m_Ctx.GetServer("tbcauana");
        m_cPhName = m_Ctx.GetPhName("tbcauana");
        if (Cursor_tbcauana!=null)
          Cursor_tbcauana.Close();
        Cursor_tbcauana = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CAUSINT,DATAVALI,VALPERINT,DATINI,idbase  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCAU="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFlusso.CodiceCausale,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFlusso.CodiceCausale)+"  and  SEGNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwFlusso.Segno,"?",0,0,m_cServer, m_oParameters),m_cServer,rwFlusso.Segno)+" "+")"+(m_Ctx.IsSharedTemp("tbcauana")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tbcauana.Eof())) {
          /* If At(gTipInter,tbcauana->VALPERINT) > 0 and (Empty(tbcauana->DATAVALI) or Date() <= tbcauana->DATAVALI) and (Empty(tbcauana->DATINI) or Date() >= tbcauana->DATINI) */
          if (CPLib.gt(CPLib.At(gTipInter,Cursor_tbcauana.GetString("VALPERINT")),0) && (CPLib.Empty(Cursor_tbcauana.GetDate("DATAVALI")) || CPLib.le(CPLib.Date(),Cursor_tbcauana.GetDate("DATAVALI"))) && (CPLib.Empty(Cursor_tbcauana.GetDate("DATINI")) || CPLib.ge(CPLib.Date(),Cursor_tbcauana.GetDate("DATINI")))) {
            /* _codvoc := tbcauana->CAUSINT */
            _codvoc = Cursor_tbcauana.GetString("CAUSINT");
            /* _codcau := tbcauana->idbase */
            _codcau = Cursor_tbcauana.GetString("idbase");
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
          Cursor_tbcauana.Next();
        }
        m_cConnectivityError = Cursor_tbcauana.ErrorMessage();
        Cursor_tbcauana.Close();
        // * --- End Select
        /* If rwFlusso.ImportoTotale < 5000 */
        if (CPLib.lt(rwFlusso.ImportoTotale,5000)) {
          /* oFrazionate := new armt_ofrazionateBO() */
          oFrazionate = new armt_ofrazionateBO(m_Ctx);
          /* oFrazionate.Initialize() */
          oFrazionate.Initialize();
          /* oFrazionate.Set_CALCOLI(False) */
          oFrazionate.Set_CALCOLI(false);
          /* oFrazionate.Set_COMPLETA(False) */
          oFrazionate.Set_COMPLETA(false);
          /* oFrazionate.Set_DATAOPE(CharToDate(rwFlusso.DataOperazione)) */
          oFrazionate.Set_DATAOPE(CPLib.CharToDate(rwFlusso.DataOperazione));
          /* oFrazionate.Set_DATAREG(Date()) */
          oFrazionate.Set_DATAREG(CPLib.Date());
          /* oFrazionate.Set_FLAGFRAZ('0') */
          oFrazionate.Set_FLAGFRAZ("0");
          /* oFrazionate.Set_idcauana(_codcau) */
          oFrazionate.Set_idcauana(_codcau);
          /* oFrazionate.w_CODANA := LRTrim(rwFlusso.CodiceCausale) */
          oFrazionate.w_CODANA = CPLib.LRTrim(rwFlusso.CodiceCausale);
          /* oFrazionate.w_CODVOC := LRTrim(_codvoc) */
          oFrazionate.w_CODVOC = CPLib.LRTrim(_codvoc);
          /* oFrazionate.w_SEGNO := rwFlusso.Segno */
          oFrazionate.w_SEGNO = rwFlusso.Segno;
          /* oFrazionate.Set_appolire(iif(rwFlusso.CodiceDivisa='242','E','V')) */
          oFrazionate.Set_appolire((CPLib.eqr(rwFlusso.CodiceDivisa,"242")?"E":"V"));
          /* oFrazionate.Set_TIPOOPRAP(rwFlusso.TipoRegistrazione) */
          oFrazionate.Set_TIPOOPRAP(rwFlusso.TipoRegistrazione);
          /* oFrazionate.Set_VALUTA(rwFlusso.CodiceDivisa) */
          oFrazionate.Set_VALUTA(rwFlusso.CodiceDivisa);
          /* oFrazionate.Set_xTOTLIRE(rwFlusso.ImportoTotale) */
          oFrazionate.Set_xTOTLIRE(rwFlusso.ImportoTotale);
          /* oFrazionate.Set_FLAGCONT(rwFlusso.FlagContanti) */
          oFrazionate.Set_FLAGCONT(rwFlusso.FlagContanti);
          /* oFrazionate.Set_xTOTCONT(rwFlusso.ImportoContante) */
          oFrazionate.Set_xTOTCONT(rwFlusso.ImportoContante);
          /* oFrazionate.w_RAPPORTO := rwFlusso.NumeroRapporto */
          oFrazionate.w_RAPPORTO = rwFlusso.NumeroRapporto;
          for (MemoryCursorRow_mccollegamento_mcrdef rwCollega : mcCollegamentoMovimenti._iterable_()) {
            if (CPLib.eqr(rwCollega.CodiceIstituto+rwCollega.DataElaborazione+rwCollega.ProceduraOrigine+rwCollega.NumeroElettronicoOperante+rwCollega.SottoNumeroOperazione,rwFlusso.CodiceIstituto+rwFlusso.DataElaborazione+rwFlusso.ProceduraOrigine+rwFlusso.NumeroElettronicoOperante+rwFlusso.SottoNumeroOperazione)) {
              /* If rwCollega.RuoloCliente='T' or rwCollega.RuoloCliente='C' */
              if (CPLib.eqr(rwCollega.RuoloCliente,"T") || CPLib.eqr(rwCollega.RuoloCliente,"C")) {
                /* oFrazionate.Set_CONNESCLI(LRTrim(rwCollega.CodiceCliente)) */
                oFrazionate.Set_CONNESCLI(CPLib.LRTrim(rwCollega.CodiceCliente));
                /* ElseIf rwCollega.RuoloCliente='S' */
              } else if (CPLib.eqr(rwCollega.RuoloCliente,"S")) {
                /* oFrazionate.Set_CONNESOPER(LRTrim(rwCollega.CodiceCliente)) */
                oFrazionate.Set_CONNESOPER(CPLib.LRTrim(rwCollega.CodiceCliente));
                /* oFrazionate.Set_TIPOLEG('3') */
                oFrazionate.Set_TIPOLEG("3");
                /* ElseIf rwCollega.RuoloCliente='U' */
              } else if (CPLib.eqr(rwCollega.RuoloCliente,"U")) {
                /* oFrazionate.Set_CONNALTRO(LRTrim(rwCollega.CodiceCliente)) */
                oFrazionate.Set_CONNALTRO(CPLib.LRTrim(rwCollega.CodiceCliente));
              } // End If
            }
          }
          for (MemoryCursorRow_mccontroparte_mcrdef rwContro : mcControparti._iterable_()) {
            /* If rwContro.CodiceIstituto+rwContro.DataElaborazione+rwContro.ProceduraOrigine+rwContro.NumeroElettronicoOperante+rwContro.SottoNumeroOperazione=rwFlusso.CodiceIstituto+rwFlusso.DataElaborazione+rwFlusso.ProceduraOrigine+rwFlusso.NumeroElettronicoOperante+rwFlusso.SottoNumeroOperazione */
            if (CPLib.eqr(rwContro.CodiceIstituto+rwContro.DataElaborazione+rwContro.ProceduraOrigine+rwContro.NumeroElettronicoOperante+rwContro.SottoNumeroOperazione,rwFlusso.CodiceIstituto+rwFlusso.DataElaborazione+rwFlusso.ProceduraOrigine+rwFlusso.NumeroElettronicoOperante+rwFlusso.SottoNumeroOperazione)) {
              /* oFrazionate.Set_CONNESBEN(LRTrim(rwContro.CodiceBeneficiario)) */
              oFrazionate.Set_CONNESBEN(CPLib.LRTrim(rwContro.CodiceBeneficiario));
              /* If rwContro.CodiceStatoBanca='086' */
              if (CPLib.eqr(rwContro.CodiceStatoBanca,"086")) {
                /* oFrazionate.Set_CODINT2(Substr(rwContro.CodiceRapporto,4,5)+"-"+Substr(rwContro.CodiceRapporto,9,5)) */
                oFrazionate.Set_CODINT2(CPLib.Substr(rwContro.CodiceRapporto,4,5)+"-"+CPLib.Substr(rwContro.CodiceRapporto,9,5));
              } else { // Else
                /* oFrazionate.Set_CODINT2(LRTrim(rwContro.CodiceIntermediario)) */
                oFrazionate.Set_CODINT2(CPLib.LRTrim(rwContro.CodiceIntermediario));
              } // End If
              /* oFrazionate.Set_TIPOINT2(rwContro.TipoIntermediario) */
              oFrazionate.Set_TIPOINT2(rwContro.TipoIntermediario);
              /* oFrazionate.Set_DESCINTER(LRTrim(rwContro.DescrizioneIntermediario)) */
              oFrazionate.Set_DESCINTER(CPLib.LRTrim(rwContro.DescrizioneIntermediario));
              /* oFrazionate.Set_PAESE(LRTrim(rwContro.StatoBeneficiario)) */
              oFrazionate.Set_PAESE(CPLib.LRTrim(rwContro.StatoBeneficiario));
              /* oFrazionate.Set_CODCAB2(LRTrim(rwContro.CabBanca)) */
              oFrazionate.Set_CODCAB2(CPLib.LRTrim(rwContro.CabBanca));
              /* oFrazionate.Set_DESC2(LRTrim(rwContro.ComuneBanca)) */
              oFrazionate.Set_DESC2(CPLib.LRTrim(rwContro.ComuneBanca));
              /* oFrazionate.Set_PROV2(LRTrim(rwContro.ProvinciaBanca)) */
              oFrazionate.Set_PROV2(CPLib.LRTrim(rwContro.ProvinciaBanca));
            } // End If
          }
          /* oFrazionate.w_RIFIMP := "XXXXXXXXX" */
          oFrazionate.w_RIFIMP = "XXXXXXXXX";
          /* oFrazionate.w_INFORM := LRTrim(rwFlusso.NumeroOperazione) */
          oFrazionate.w_INFORM = CPLib.LRTrim(rwFlusso.NumeroOperazione);
          /* oFrazionate.Save() */
          oFrazionate.Save();
          /* If not(Empty(oFrazionate.m_cLastMsgError)) */
          if ( ! (CPLib.Empty(oFrazionate.m_cLastMsgError))) {
            /* gMsgProc := gMsgProc + "Errore nell'elaborazione della frazionata "+ LRTrim(rwFlusso.NumeroElettronicoOperante) +": "+LRTrim(oFrazionate.m_cLastMsgError)+ NL */
            gMsgProc = gMsgProc+"Errore nell'elaborazione della frazionata "+CPLib.LRTrim(rwFlusso.NumeroElettronicoOperante)+": "+CPLib.LRTrim(oFrazionate.m_cLastMsgError)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Warn Msg "Errore nell'elaborazione della frazionata "+ LRTrim(rwFlusso.NumeroElettronicoOperante) +": "+LRTrim(oFrazionate.m_cLastMsgError) */
            if ( ! (CPLib.IsNull(m_Warning))) {
              m_Warning.log("Errore nell'elaborazione della frazionata "+CPLib.LRTrim(rwFlusso.NumeroElettronicoOperante)+": "+CPLib.LRTrim(oFrazionate.m_cLastMsgError));
            }
          } else { // Else
            /* Exec Routine arrt_writelog('NUOVO RECORD','FRAZIOBO',oFrazionate.w_IDBASE) */
            arrt_writelogR.Make(m_Ctx,this).Run("NUOVO RECORD","FRAZIOBO",oFrazionate.w_IDBASE);
            /* Exec Routine arrt_crea_idereg('F',oFrazionate.w_IDBASE,'D') */
            arrt_crea_ideregR.Make(m_Ctx,this).Run("F",oFrazionate.w_IDBASE,"D");
          } // End If
        } else { // Else
          /* oOperazioni := new armt_operazioniBO() */
          oOperazioni = new armt_operazioniBO(m_Ctx);
          /* oOperazioni.Initialize() */
          oOperazioni.Initialize();
          /* oOperazioni.Set_CALCOLI(False) */
          oOperazioni.Set_CALCOLI(false);
          /* oOperazioni.Set_COMPLETA(False) */
          oOperazioni.Set_COMPLETA(false);
          /* oOperazioni.Set_DATAOPE(CharToDate(rwFlusso.DataOperazione)) */
          oOperazioni.Set_DATAOPE(CPLib.CharToDate(rwFlusso.DataOperazione));
          /* oOperazioni.Set_DATAREG(Date()) */
          oOperazioni.Set_DATAREG(CPLib.Date());
          /* oOperazioni.Set_FLAGFRAZ('0') */
          oOperazioni.Set_FLAGFRAZ("0");
          /* oOperazioni.Set_TIPOOPRAP(rwFlusso.TipoRegistrazione) */
          oOperazioni.Set_TIPOOPRAP(rwFlusso.TipoRegistrazione);
          /* oOperazioni.Set_idcauana(_codcau) */
          oOperazioni.Set_idcauana(_codcau);
          /* oOperazioni.w_CODANA := LRTrim(rwFlusso.CodiceCausale) */
          oOperazioni.w_CODANA = CPLib.LRTrim(rwFlusso.CodiceCausale);
          /* oOperazioni.w_CODVOC := LRTrim(_codvoc) */
          oOperazioni.w_CODVOC = CPLib.LRTrim(_codvoc);
          /* oOperazioni.w_SEGNO := rwFlusso.Segno */
          oOperazioni.w_SEGNO = rwFlusso.Segno;
          /* oOperazioni.Set_appolire(iif(rwFlusso.CodiceDivisa='242','E','V')) */
          oOperazioni.Set_appolire((CPLib.eqr(rwFlusso.CodiceDivisa,"242")?"E":"V"));
          /* oOperazioni.Set_VALUTA(rwFlusso.CodiceDivisa) */
          oOperazioni.Set_VALUTA(rwFlusso.CodiceDivisa);
          /* oOperazioni.Set_xTOTLIRE(rwFlusso.ImportoTotale) */
          oOperazioni.Set_xTOTLIRE(rwFlusso.ImportoTotale);
          /* oOperazioni.Set_FLAGCONT(rwFlusso.FlagContanti) */
          oOperazioni.Set_FLAGCONT(rwFlusso.FlagContanti);
          /* oOperazioni.Set_xTOTCONT(rwFlusso.ImportoContante) */
          oOperazioni.Set_xTOTCONT(rwFlusso.ImportoContante);
          /* oOperazioni.w_RAPPORTO := rwFlusso.NumeroRapporto */
          oOperazioni.w_RAPPORTO = rwFlusso.NumeroRapporto;
          for (MemoryCursorRow_mccollegamento_mcrdef rwCollega : mcCollegamentoMovimenti._iterable_()) {
            if (CPLib.eqr(rwCollega.CodiceIstituto+rwCollega.DataElaborazione+rwCollega.ProceduraOrigine+rwCollega.NumeroElettronicoOperante+rwCollega.SottoNumeroOperazione,rwFlusso.CodiceIstituto+rwFlusso.DataElaborazione+rwFlusso.ProceduraOrigine+rwFlusso.NumeroElettronicoOperante+rwFlusso.SottoNumeroOperazione)) {
              /* If rwCollega.RuoloCliente='T' or rwCollega.RuoloCliente='C' */
              if (CPLib.eqr(rwCollega.RuoloCliente,"T") || CPLib.eqr(rwCollega.RuoloCliente,"C")) {
                /* oOperazioni.Set_CONNESCLI(LRTrim(rwCollega.CodiceCliente)) */
                oOperazioni.Set_CONNESCLI(CPLib.LRTrim(rwCollega.CodiceCliente));
                /* ElseIf rwCollega.RuoloCliente='S' */
              } else if (CPLib.eqr(rwCollega.RuoloCliente,"S")) {
                /* oOperazioni.Set_CONNESOPER(LRTrim(rwCollega.CodiceCliente)) */
                oOperazioni.Set_CONNESOPER(CPLib.LRTrim(rwCollega.CodiceCliente));
                /* oOperazioni.Set_TIPOLEG('3') */
                oOperazioni.Set_TIPOLEG("3");
                /* ElseIf rwCollega.RuoloCliente='U' */
              } else if (CPLib.eqr(rwCollega.RuoloCliente,"U")) {
                /* oOperazioni.Set_CONNALTRO(LRTrim(rwCollega.CodiceCliente)) */
                oOperazioni.Set_CONNALTRO(CPLib.LRTrim(rwCollega.CodiceCliente));
              } // End If
            }
          }
          for (MemoryCursorRow_mccontroparte_mcrdef rwContro : mcControparti._iterable_()) {
            /* If rwContro.CodiceIstituto+rwContro.DataElaborazione+rwContro.ProceduraOrigine+rwContro.NumeroElettronicoOperante+rwContro.SottoNumeroOperazione=rwFlusso.CodiceIstituto+rwFlusso.DataElaborazione+rwFlusso.ProceduraOrigine+rwFlusso.NumeroElettronicoOperante+rwFlusso.SottoNumeroOperazione */
            if (CPLib.eqr(rwContro.CodiceIstituto+rwContro.DataElaborazione+rwContro.ProceduraOrigine+rwContro.NumeroElettronicoOperante+rwContro.SottoNumeroOperazione,rwFlusso.CodiceIstituto+rwFlusso.DataElaborazione+rwFlusso.ProceduraOrigine+rwFlusso.NumeroElettronicoOperante+rwFlusso.SottoNumeroOperazione)) {
              /* oOperazioni.Set_CONNESBEN(LRTrim(rwContro.CodiceBeneficiario)) */
              oOperazioni.Set_CONNESBEN(CPLib.LRTrim(rwContro.CodiceBeneficiario));
              /* If rwContro.CodiceStatoBanca='086' */
              if (CPLib.eqr(rwContro.CodiceStatoBanca,"086")) {
                /* oOperazioni.Set_CODINT2(Substr(rwContro.CodiceRapporto,4,5)+"-"+Substr(rwContro.CodiceRapporto,9,5)) */
                oOperazioni.Set_CODINT2(CPLib.Substr(rwContro.CodiceRapporto,4,5)+"-"+CPLib.Substr(rwContro.CodiceRapporto,9,5));
              } else { // Else
                /* oOperazioni.Set_CODINT2(LRTrim(rwContro.CodiceIntermediario)) */
                oOperazioni.Set_CODINT2(CPLib.LRTrim(rwContro.CodiceIntermediario));
              } // End If
              /* oOperazioni.Set_TIPOINT2(rwContro.TipoIntermediario) */
              oOperazioni.Set_TIPOINT2(rwContro.TipoIntermediario);
              /* oOperazioni.Set_DESCINTER(LRTrim(rwContro.DescrizioneIntermediario)) */
              oOperazioni.Set_DESCINTER(CPLib.LRTrim(rwContro.DescrizioneIntermediario));
              /* oOperazioni.Set_PAESE(LRTrim(rwContro.StatoBeneficiario)) */
              oOperazioni.Set_PAESE(CPLib.LRTrim(rwContro.StatoBeneficiario));
              /* oOperazioni.Set_CODCAB2(LRTrim(rwContro.CabBanca)) */
              oOperazioni.Set_CODCAB2(CPLib.LRTrim(rwContro.CabBanca));
              /* oOperazioni.Set_DESC2(LRTrim(rwContro.ComuneBanca)) */
              oOperazioni.Set_DESC2(CPLib.LRTrim(rwContro.ComuneBanca));
              /* oOperazioni.Set_PROV2(LRTrim(rwContro.ProvinciaBanca)) */
              oOperazioni.Set_PROV2(CPLib.LRTrim(rwContro.ProvinciaBanca));
            } // End If
          }
          /* oOperazioni.w_RIFIMP := "XXXXXXXXX" */
          oOperazioni.w_RIFIMP = "XXXXXXXXX";
          /* oOperazioni.w_INFORM := LRTrim(rwFlusso.NumeroOperazione) */
          oOperazioni.w_INFORM = CPLib.LRTrim(rwFlusso.NumeroOperazione);
          /* oOperazioni.Save() */
          oOperazioni.Save();
          /* If not(Empty(oOperazioni.m_cLastMsgError)) */
          if ( ! (CPLib.Empty(oOperazioni.m_cLastMsgError))) {
            /* gMsgProc := gMsgProc + "Errore nell'elaborazione dell'operazione "+ LRTrim(rwFlusso.NumeroElettronicoOperante) +": "+LRTrim(oOperazioni.m_cLastMsgError)+ NL */
            gMsgProc = gMsgProc+"Errore nell'elaborazione dell'operazione "+CPLib.LRTrim(rwFlusso.NumeroElettronicoOperante)+": "+CPLib.LRTrim(oOperazioni.m_cLastMsgError)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Warn Msg "Errore nell'elaborazione dell'operazione "+ LRTrim(rwFlusso.NumeroElettronicoOperante) +": "+LRTrim(oOperazioni.m_cLastMsgError) */
            if ( ! (CPLib.IsNull(m_Warning))) {
              m_Warning.log("Errore nell'elaborazione dell'operazione "+CPLib.LRTrim(rwFlusso.NumeroElettronicoOperante)+": "+CPLib.LRTrim(oOperazioni.m_cLastMsgError));
            }
          } else { // Else
            /* Exec Routine arrt_writelog('NUOVO RECORD','OPERAZBO',oOperazioni.w_IDBASE) */
            arrt_writelogR.Make(m_Ctx,this).Run("NUOVO RECORD","OPERAZBO",oOperazioni.w_IDBASE);
            /* Exec Routine arrt_crea_idereg('O',oOperazioni.w_IDBASE,'D') */
            arrt_crea_ideregR.Make(m_Ctx,this).Run("O",oOperazioni.w_IDBASE,"D");
          } // End If
        } // End If
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Caricamento Movimenti: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Caricamento Movimenti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
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
        if (Cursor_tbcauana!=null)
          Cursor_tbcauana.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Categorizzazione() throws Exception {
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
    fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If Len(LRTrim(riga)) > 0 */
      if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
        /* mcCategoria.AppendWithKey(LRTrim(Substr(riga,19,16))) */
        mcCategoria.AppendWithKey(CPLib.LRTrim(CPLib.Substr(riga,19,16)));
        /* mcCategoria.CODIST := Substr(riga,1,5) */
        mcCategoria.row.CODIST = CPLib.Substr(riga,1,5);
        /* mcCategoria.TIPOINT := Substr(riga,6,2) */
        mcCategoria.row.TIPOINT = CPLib.Substr(riga,6,2);
        /* mcCategoria.CODINT := Substr(riga,8,11) */
        mcCategoria.row.CODINT = CPLib.Substr(riga,8,11);
        /* mcCategoria.IDSOGG := LRTrim(Substr(riga,19,16)) */
        mcCategoria.row.IDSOGG = CPLib.LRTrim(CPLib.Substr(riga,19,16));
        /* mcCategoria.COD_TIPO_SOGG := LRTrim(Substr(riga,35,3)) */
        mcCategoria.row.COD_TIPO_SOGG = CPLib.LRTrim(CPLib.Substr(riga,35,3));
        /* mcCategoria.COD_STATO  := Substr(riga,38,3) */
        mcCategoria.row.COD_STATO = CPLib.Substr(riga,38,3);
        /* mcCategoria.COD_SPEC_GIUR := LRTrim(Substr(riga,41,5)) */
        mcCategoria.row.COD_SPEC_GIUR = CPLib.LRTrim(CPLib.Substr(riga,41,5));
        /* mcCategoria.COD_SETT := Substr(riga,46,3) */
        mcCategoria.row.COD_SETT = CPLib.Substr(riga,46,3);
        /* mcCategoria.COD_RAMO := Substr(riga,49,3) */
        mcCategoria.row.COD_RAMO = CPLib.Substr(riga,49,3);
        /* mcCategoria.COD_NDG_GRUP_ECON := Substr(riga,52,16) */
        mcCategoria.row.COD_NDG_GRUP_ECON = CPLib.Substr(riga,52,16);
        /* mcCategoria.COD_ATECO := LRTrim(Substr(riga,68,6)) */
        mcCategoria.row.COD_ATECO = CPLib.LRTrim(CPLib.Substr(riga,68,6));
        /* mcCategoria.SEG_CAN_TERZI := Substr(riga,74,3) */
        mcCategoria.row.SEG_CAN_TERZI = CPLib.Substr(riga,74,3);
        /* mcCategoria.COD_TIT_EFFETTIVO := Substr(riga,77,1) */
        mcCategoria.row.COD_TIT_EFFETTIVO = CPLib.Substr(riga,77,1);
        /* mcCategoria.COD_COMP_RILE := Substr(riga,78,5) */
        mcCategoria.row.COD_COMP_RILE = CPLib.Substr(riga,78,5);
        /* mcCategoria.COD_SCOPO_RAPP := Substr(riga,83,3) */
        mcCategoria.row.COD_SCOPO_RAPP = CPLib.Substr(riga,83,3);
        /* mcCategoria.NDG_SOGG_PRIMARIO := Substr(riga,86,16) */
        mcCategoria.row.NDG_SOGG_PRIMARIO = CPLib.Substr(riga,86,16);
        /* mcCategoria.TIPO_RELAZIONE := Substr(riga,102,3) */
        mcCategoria.row.TIPO_RELAZIONE = CPLib.Substr(riga,102,3);
        /* mcCategoria.NAT_GIURIDICA := Substr(riga,105,5) */
        mcCategoria.row.NAT_GIURIDICA = CPLib.Substr(riga,105,5);
        /* mcCategoria.CATENA_CTRL := Substr(riga,110,5) */
        mcCategoria.row.CATENA_CTRL = CPLib.Substr(riga,110,5);
        /* mcCategoria.AMMONTARE := Substr(riga,115,1) */
        mcCategoria.row.AMMONTARE = CPLib.Substr(riga,115,1);
        /* mcCategoria.COD_FILIALE := Substr(riga,116,10) */
        mcCategoria.row.COD_FILIALE = CPLib.Substr(riga,116,10);
        /* mcCategoria.DESC_FILIALE := Substr(riga,126,30) */
        mcCategoria.row.DESC_FILIALE = CPLib.Substr(riga,126,30);
        /* mcCategoria.OPERATIVITA := Substr(riga,156,3) */
        mcCategoria.row.OPERATIVITA = CPLib.Substr(riga,156,3);
        /* mcCategoria.COMPORTAMENTO := Substr(riga,159,3) */
        mcCategoria.row.COMPORTAMENTO = CPLib.Substr(riga,159,3);
        /* mcCategoria.SaveRow() */
        mcCategoria.SaveRow();
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void _init_() {
  }
  public String RunAsync(MemoryCursor_tmp_list_imprich p_pmcListaFile) {
    pmcListaFile = p_pmcListaFile;
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
  public String Run(MemoryCursor_tmp_list_imprich p_pmcListaFile) {
    pmcListaFile = p_pmcListaFile;
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
          Principale();
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
  public static arrt_import_unifactorR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_unifactorR(p_Ctx, p_Caller);
  }
  public static arrt_import_unifactorR Make(CPContext p_Ctx) {
    return new arrt_import_unifactorR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pmcListaFile = new MemoryCursor_tmp_list_imprich();
    fhand = CPLib.Space(0);
    czipfile = CPLib.Space(100);
    cpercorsozip = CPLib.Space(200);
    cdirectoryfile = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    nomefileimport = CPLib.Space(50);
    _priorita = 0;
    riga = "";
    _numana = 0;
    _nummov = 0;
    mcLista = new MemoryCursor_tmp_list_imprich();
    mcFlussiRapporti = new MemoryCursor_mcflusso_mcrdef();
    mcCollegamentoRapporti = new MemoryCursor_mccollegamento_mcrdef();
    mcAnagraficheRapporti = new MemoryCursor_mcanagrafiche_mcrdef();
    mcFlussiMovimenti = new MemoryCursor_mcflusso_mcrdef();
    mcCollegamentoMovimenti = new MemoryCursor_mccollegamento_mcrdef();
    mcAnagraficheMovimenti = new MemoryCursor_mcanagrafiche_mcrdef();
    mcFlussi = new MemoryCursor_mcflusso_mcrdef();
    mcCollegamento = new MemoryCursor_mccollegamento_mcrdef();
    mcAnagrafiche = new MemoryCursor_mcanagrafiche_mcrdef();
    mcControparti = new MemoryCursor_mccontroparte_mcrdef();
    mcCategoria = new MemoryCursor_mccategorizzazione_mcrdef();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gVerImp=m_Ctx.GetGlobalString("gVerImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_ae_agg_aetesta,arrt_ae_agg_aetesta_tit,arrt_crea_idereg,arrt_import_unifactor,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_ae_agg_aetesta,arrt_ae_agg_aetesta_tit,arrt_crea_idereg,arrt_import_unifactor,arrt_writelog,";
  public static String[] m_cRunParameterNames={"pmcListaFile"};
  protected static String GetFieldsName_000001EE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"anarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001EF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"knarapbo",true);
    return p_cSql;
  }
}
