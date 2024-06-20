// * --- Area Manuale = BO - Header
// * --- arfn_exec_sid_sm_ric
import java.io.*;
import java.util.*;

import org.json.*;
// * --- Fine Area Manuale
public class arfn_exec_sid_sm_ricR implements CallerWithObjs {
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
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public String pFile;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String gUrlApp;
  public String gMsgProc;
  public String fhand;
  public String _dir1;
  public String _dir2;
  public String _dir3;
  public String _dir4;
  public String _dirsid;
  public String _dirjava;
  public String _idsog;
  public String _pwdsog;
  public String _tipo;
  public String _riga;
  public String _fcfg;
  public String _semaforo;
  public String _risultato;
  public String _tiporis;
  public String _tipoelab;
  public String _categsid;
  public String _descrsid;
  public String _fileesi;
  public String _filedgn;
  public double _conta;
  public double _found;
  public String _fileann;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String _file1;
  public String _file2;
  public String _uscita;
  public String _nomefile;
  public MemoryCursor_mcmessaggi_mcrdef mcRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_exec_sid_sm_ric
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arfn_exec_sid_sm_ricR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_exec_sid_sm_ric",m_Caller);
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_found",p_cVarName)) {
      return _found;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_exec_sid_sm_ric";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pFile",p_cVarName)) {
      return pFile;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_dir1",p_cVarName)) {
      return _dir1;
    }
    if (CPLib.eqr("_dir2",p_cVarName)) {
      return _dir2;
    }
    if (CPLib.eqr("_dir3",p_cVarName)) {
      return _dir3;
    }
    if (CPLib.eqr("_dir4",p_cVarName)) {
      return _dir4;
    }
    if (CPLib.eqr("_dirsid",p_cVarName)) {
      return _dirsid;
    }
    if (CPLib.eqr("_dirjava",p_cVarName)) {
      return _dirjava;
    }
    if (CPLib.eqr("_idsog",p_cVarName)) {
      return _idsog;
    }
    if (CPLib.eqr("_pwdsog",p_cVarName)) {
      return _pwdsog;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      return _tipo;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_fcfg",p_cVarName)) {
      return _fcfg;
    }
    if (CPLib.eqr("_semaforo",p_cVarName)) {
      return _semaforo;
    }
    if (CPLib.eqr("_risultato",p_cVarName)) {
      return _risultato;
    }
    if (CPLib.eqr("_tiporis",p_cVarName)) {
      return _tiporis;
    }
    if (CPLib.eqr("_tipoelab",p_cVarName)) {
      return _tipoelab;
    }
    if (CPLib.eqr("_categsid",p_cVarName)) {
      return _categsid;
    }
    if (CPLib.eqr("_descrsid",p_cVarName)) {
      return _descrsid;
    }
    if (CPLib.eqr("_fileesi",p_cVarName)) {
      return _fileesi;
    }
    if (CPLib.eqr("_filedgn",p_cVarName)) {
      return _filedgn;
    }
    if (CPLib.eqr("_fileann",p_cVarName)) {
      return _fileann;
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
    if (CPLib.eqr("_file1",p_cVarName)) {
      return _file1;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
    }
    if (CPLib.eqr("_uscita",p_cVarName)) {
      return _uscita;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
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
    if (CPLib.eqr("mcRitorno",p_cVarName)) {
      return mcRitorno;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_found",p_cVarName)) {
      _found = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pFile",p_cVarName)) {
      pFile = value;
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
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_dir1",p_cVarName)) {
      _dir1 = value;
      return;
    }
    if (CPLib.eqr("_dir2",p_cVarName)) {
      _dir2 = value;
      return;
    }
    if (CPLib.eqr("_dir3",p_cVarName)) {
      _dir3 = value;
      return;
    }
    if (CPLib.eqr("_dir4",p_cVarName)) {
      _dir4 = value;
      return;
    }
    if (CPLib.eqr("_dirsid",p_cVarName)) {
      _dirsid = value;
      return;
    }
    if (CPLib.eqr("_dirjava",p_cVarName)) {
      _dirjava = value;
      return;
    }
    if (CPLib.eqr("_idsog",p_cVarName)) {
      _idsog = value;
      return;
    }
    if (CPLib.eqr("_pwdsog",p_cVarName)) {
      _pwdsog = value;
      return;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      _tipo = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_fcfg",p_cVarName)) {
      _fcfg = value;
      return;
    }
    if (CPLib.eqr("_semaforo",p_cVarName)) {
      _semaforo = value;
      return;
    }
    if (CPLib.eqr("_risultato",p_cVarName)) {
      _risultato = value;
      return;
    }
    if (CPLib.eqr("_tiporis",p_cVarName)) {
      _tiporis = value;
      return;
    }
    if (CPLib.eqr("_tipoelab",p_cVarName)) {
      _tipoelab = value;
      return;
    }
    if (CPLib.eqr("_categsid",p_cVarName)) {
      _categsid = value;
      return;
    }
    if (CPLib.eqr("_descrsid",p_cVarName)) {
      _descrsid = value;
      return;
    }
    if (CPLib.eqr("_fileesi",p_cVarName)) {
      _fileesi = value;
      return;
    }
    if (CPLib.eqr("_filedgn",p_cVarName)) {
      _filedgn = value;
      return;
    }
    if (CPLib.eqr("_fileann",p_cVarName)) {
      _fileann = value;
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
    if (CPLib.eqr("_file1",p_cVarName)) {
      _file1 = value;
      return;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      _file2 = value;
      return;
    }
    if (CPLib.eqr("_uscita",p_cVarName)) {
      _uscita = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
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
    if (CPLib.eqr("mcRitorno",p_cVarName)) {
      mcRitorno = (MemoryCursor_mcmessaggi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intermbo=null;
    try {
      /* pFile Char(128) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gMsgProc Memo // Log Messaggi */
      /* fhand Char(1) // Handle File */
      /* _dir1 Char(180) */
      /* _dir2 Char(180) */
      /* _dir3 Char(180) */
      /* _dir4 Char(180) */
      /* _dirsid Char(250) */
      /* _dirjava Char(250) */
      /* _idsog Char(50) */
      /* _pwdsog Char(50) */
      /* _tipo Char(1) */
      /* _riga Memo */
      /* _fcfg Char(120) */
      /* _semaforo Char(8) // Veridica semaforo SID */
      /* _risultato Char(3) */
      /* _tiporis Char(20) */
      /* _tipoelab Char(20) */
      /* _categsid Char(15) */
      /* _descrsid Char(100) */
      /* _fileesi Char(80) */
      /* _filedgn Char(80) */
      /* _conta Numeric(10, 0) */
      /* _found Numeric(1, 0) */
      /* _fileann Char(128) */
      /* cNomeFile Char(30) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* _file1 Char(30) */
      /* _file2 Char(30) */
      /* _uscita Char(1) */
      /* _nomefile Char(50) */
      /* mcRitorno MemoryCursor(mcMessaggi.MCRDef) */
      /* jsonUtente Object(JSONObject) */
      JSONObject jsonUtente;
      jsonUtente = null;
      /* gMsgProc := gMsgProc + 'Inizio Elaborazione SID'+ NL // Log Messaggi */
      gMsgProc = gMsgProc+"Inizio Elaborazione SID"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _semaforo := '' // Veridica semaforo SID */
      _semaforo = "";
      // * --- Read from cpwarn
      m_cServer = m_Ctx.GetServer("cpwarn");
      m_cPhName = m_Ctx.GetPhName("cpwarn");
      m_cSql = "";
      m_cSql = m_cSql+"tablecode="+CPSql.SQLValueAdapter(CPLib.ToSQL("SEMAFORO","C",100,0,m_cServer),m_cServer,"SEMAFORO");
      if (m_Ctx.IsSharedTemp("cpwarn")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("tablecode",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _semaforo = Read_Cursor.GetString("tablecode");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on cpwarn into routine arfn_exec_sid_sm_ric returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _semaforo = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Empty(LRTrim(_semaforo)) */
      if (CPLib.Empty(CPLib.LRTrim(_semaforo))) {
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arfn_exec_sid_sm_ric",332,"0000002E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002E(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL("SEMAFORO","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("xxx","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cpwarn",true);
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
        /* gMsgProc := gMsgProc + 'Cancellazione file esiti precedenti' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"Cancellazione file esiti precedenti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Legge i file degli esiti
        File di = new File(CPLib.LRTrim(gPathDoc)+"/SID/MASSCFR/ESI/"+CPLib.LRTrim(gAzienda)+"/");
        File fl[] = di.listFiles();
        int _i;
        int count=0;
        for (_i=0; _i < fl.length; _i++)  {
          fl[_i].delete();
        }
        // Legge i file degli esiti
        di = new File(CPLib.LRTrim(gPathDoc)+"/SID/MASSCFR/RIC/"+CPLib.LRTrim(gAzienda)+"/");
        File fl2[] = di.listFiles();
        count=0;
        for (_i=0; _i < fl2.length; _i++)  {
          fl2[_i].delete();
        }
        // Legge i file degli esiti
        di = new File(CPLib.LRTrim(gPathDoc)+"/SID/MASSCFR/ELB/"+CPLib.LRTrim(gAzienda)+"/");
        File fl3[] = di.listFiles();
        count=0;
        for (_i=0; _i < fl3.length; _i++)  {
        /* If At(LRTrim(pFile),fl3[_i].getName()) = 0 */
        if (CPLib.eqr(CPLib.At(CPLib.LRTrim(pFile),fl3[_i].getName()),0)) {
          /* fl3[_i].delete() */
          fl3[_i].delete();
        } // End If
        /* } */
        };
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDSID,SIDPASS,PATHSID,PATHJAVA,TIPOINST  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _idsog := intermbo->IDSID */
          _idsog = Cursor_intermbo.GetString("IDSID");
          /* _pwdsog := intermbo->SIDPASS */
          _pwdsog = Cursor_intermbo.GetString("SIDPASS");
          /* _dirjava := intermbo->PATHJAVA */
          _dirjava = Cursor_intermbo.GetString("PATHJAVA");
          /* _tipo := intermbo->TIPOINST */
          _tipo = Cursor_intermbo.GetString("TIPOINST");
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + 'Costruzione File di configurazione' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"Costruzione File di configurazione"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _dirsid := gPathApp+"/SID" */
        _dirsid = gPathApp+"/SID";
        /* _conta := 1 */
        _conta = CPLib.Round(1,0);
        /* If _tipo='W' */
        if (CPLib.eqr(_tipo,"W")) {
          /* _dir1 := Strtran(LRTrim(gPathDoc),'/','\')+"\SID\MASSCFR\ELB\"+LRTrim(gAzienda) */
          _dir1 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"/","\\")+"\\SID\\MASSCFR\\ELB\\"+CPLib.LRTrim(gAzienda);
          /* _dir2 := Strtran(LRTrim(gPathDoc),'/','\')+"\SID\MASSCFR\ESI\"+LRTrim(gAzienda) */
          _dir2 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"/","\\")+"\\SID\\MASSCFR\\ESI\\"+CPLib.LRTrim(gAzienda);
          /* _dir3 := Strtran(LRTrim(gPathDoc),'/','\')+"\SID\MASSCFR\RIC\"+LRTrim(gAzienda) */
          _dir3 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"/","\\")+"\\SID\\MASSCFR\\RIC\\"+CPLib.LRTrim(gAzienda);
          /* _dir4 := Strtran(LRTrim(gPathDoc),'/','\')+"\SID\CERTIFICATI\"+LRTrim(gAzienda) */
          _dir4 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"/","\\")+"\\SID\\CERTIFICATI\\"+CPLib.LRTrim(gAzienda);
          /* ElseIf _tipo='L' */
        } else if (CPLib.eqr(_tipo,"L")) {
          /* _dir1 := Strtran(LRTrim(gPathDoc),'\','/')+"/SID/MASSCFR/ELB/"+LRTrim(gAzienda)+"/" */
          _dir1 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"\\","/")+"/SID/MASSCFR/ELB/"+CPLib.LRTrim(gAzienda)+"/";
          /* _dir2 := Strtran(LRTrim(gPathDoc),'\','/')+"/SID/MASSCFR/ESI/"+LRTrim(gAzienda)+"/" */
          _dir2 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"\\","/")+"/SID/MASSCFR/ESI/"+CPLib.LRTrim(gAzienda)+"/";
          /* _dir3 := Strtran(LRTrim(gPathDoc),'\','/')+"/SID/MASSCFR/RIC/"+LRTrim(gAzienda)+"/" */
          _dir3 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"\\","/")+"/SID/MASSCFR/RIC/"+CPLib.LRTrim(gAzienda)+"/";
          /* _dir4 := Strtran(LRTrim(gPathDoc),'\','/')+"/SID/CERTIFICATI/"+LRTrim(gAzienda)+"/" */
          _dir4 = CPLib.Strtran(CPLib.LRTrim(gPathDoc),"\\","/")+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda)+"/";
        } // End If
        /* _fcfg := '/SID/config/utente.json' */
        _fcfg = "/SID/config/utente.json";
        /* fhand := FileLibMit.OpenWrite(LRTrim(_fcfg)) // Handle File */
        fhand = FileLibMit.OpenWrite(CPLib.LRTrim(_fcfg));
        /* Prepara il file di configurazione */
        /* jsonUtente := new JSONObject() */
        jsonUtente = new JSONObject();
        /* jsonUtente.put("idSid",LRTrim(_idsog)) */
        jsonUtente.put("idSid",CPLib.LRTrim(_idsog));
        /* jsonUtente.put("denominazione","utente2") */
        jsonUtente.put("denominazione","utente2");
        /* jsonUtente.put("ambienteSicurezzaPath",LibreriaMit.UTFtoISO(_dir4)) */
        jsonUtente.put("ambienteSicurezzaPath",LibreriaMit.UTFtoISO(_dir4));
        /* jsonUtente.put("ricevute_da_elaborare",LibreriaMit.UTFtoISO(_dir1)) */
        jsonUtente.put("ricevute_da_elaborare",LibreriaMit.UTFtoISO(_dir1));
        /* jsonUtente.put("ricevute_elaborate",LibreriaMit.UTFtoISO(_dir3)) */
        jsonUtente.put("ricevute_elaborate",LibreriaMit.UTFtoISO(_dir3));
        /* jsonUtente.put("file_esiti",LibreriaMit.UTFtoISO(_dir2)) */
        jsonUtente.put("file_esiti",LibreriaMit.UTFtoISO(_dir2));
        // Scrive il file di configurazione
        FileLibMit.Write(fhand,jsonUtente.toString());
        FileLibMit.Close(fhand);
        /* If _tipo='W' */
        if (CPLib.eqr(_tipo,"W")) {
          /* Exec "Windows" Page 2:Page_2 */
          Page_2();
          /* ElseIf _tipo='L' */
        } else if (CPLib.eqr(_tipo,"L")) {
          /* Exec "Linux" Page 3:Page_3 */
          Page_3();
        } // End If
        // Legge i file degli esiti
        di = new File(CPLib.LRTrim(gPathDoc)+"/SID/MASSCFR/RIC/"+CPLib.LRTrim(gAzienda)+"/");
        File fl4[] =di.listFiles();
        count=0;
        for (_i=0; _i < fl4.length; _i++)  {
        /* If At('.run',fl4[_i].getName()) <> 0 */
        if (CPLib.ne(CPLib.At(".run",fl4[_i].getName()),0)) {
          /* _fileesi := fl4[_i].getName() */
          _fileesi = fl4[_i].getName();
          /* ElseIf At('.dgn',fl4[_i].getName()) <> 0 */
        } else if (CPLib.ne(CPLib.At(".dgn",fl4[_i].getName()),0)) {
          /* _filedgn := fl4[_i].getName() */
          _filedgn = fl4[_i].getName();
        } // End If
        //Chiude il ciclo
        }
        /* gMsgProc := gMsgProc + 'PROCEDURA COMPLETATA.' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"PROCEDURA COMPLETATA."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Delete from cpwarn
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arfn_exec_sid_sm_ric",332,"00000060")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"tablecode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("SEMAFORO","?",0,0,m_cServer),m_cServer,"SEMAFORO")+"";
        m_cSql = m_cSql+" and warncode = "+CPSql.SQLValueAdapter(CPLib.ToSQL("xxx","?",0,0,m_cServer),m_cServer,"xxx")+"";
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
        /* gMsgProc := gMsgProc + 'Impossibile Procedere' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"Impossibile Procedere"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Procedura SID già in utilizzo da altro utente' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"Procedura SID già in utilizzo da altro utente"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'PROCEDURA ABORTITA' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"PROCEDURA ABORTITA"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* mcRitorno.AppendBlank() */
        mcRitorno.AppendBlank();
        /* mcRitorno.testata := "Procedura SID già in utilizzo da altro utente" */
        mcRitorno.row.testata = "Procedura SID già in utilizzo da altro utente";
        /* mcRitorno.SaveRow() */
        mcRitorno.SaveRow();
      } // End If
      /* Return _fileesi */
      throw new Stop(_fileesi);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
    }
  }
  void Page_2() throws Exception {
    /* Esegue SID Windows */
    /* _dir1 := '"'+LRTrim(_dirjava)+'"'  */
    _dir1 = "\""+CPLib.LRTrim(_dirjava)+"\"";
    // Provo a lanciare il batch
    try
    {
      File _mydir = new File(CPLib.LRTrim(_dirsid)+"/prog");
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runRicevuteMIT.bat",CPLib.LRTrim(_dir1),"CF100",CPLib.LRTrim(_pwdsog)};
      Runtime rt = Runtime.getRuntime();
      Process proc = rt.exec(cmd,null,_mydir);
      // any error message?
      StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERRORE", m_Ctx);            
      // any output?
      StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT", m_Ctx);
      // kick them off
      errorGobbler.start();
      outputGobbler.start();
      // any error???
      int exitVal = proc.waitFor();
      //System.out.println("ExitValue: " + exitVal);     
    } catch (IOException ex) { 
      ex.printStackTrace();   
    }
  }
  void Page_3() throws Exception {
    /* Esegue SID Linux */
    // Provo a lanciare il batch
    try
    {
      File _mydir = new File(CPLib.LRTrim(_dirsid)+"/prog");
      // String[] cmd = {"sh", "-c",CPLib.LRTrim(_dirsid)+"/prog/runRicevuteMIT.sh",CPLib.LRTrim(_dirjava)+"/bin/java",CPLib.LRTrim(CPLib.Upper(_pwdsog))};
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runRicevuteMIT.sh",CPLib.LRTrim(_dirjava)+"/bin/java","CF100",CPLib.LRTrim(_pwdsog)};
      Runtime rt = Runtime.getRuntime();
      Process proc = rt.exec(cmd,null,_mydir);
      // any error message?
      StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERRORE", m_Ctx);            
      // any output?
      StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT", m_Ctx);
      // kick them off
      errorGobbler.start();
      outputGobbler.start();
      // any error???
      int exitVal = proc.waitFor();
      System.out.println("ExitValue: " + exitVal);     
    } catch (IOException ex) { 
      ex.printStackTrace();   
    }
  }
  void Page_4() throws Exception {
    // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.size(); i++) {
                _file1=(String)filenames.elementAt(i);
                _file2=(String)fileonames.elementAt(i);
                java.io.FileInputStream in = new java.io.FileInputStream(_file1);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(_file2));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
            }
        
            // Complete the ZIP file
            out.close();
            filenames.removeAllElements();
            fileonames.removeAllElements();
        } catch (java.io.IOException e) {
        }
    
  }
  void _init_() {
  }
  public String RunAsync(String p_pFile) {
    pFile = p_pFile;
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
  public String Run(String p_pFile) {
    pFile = p_pFile;
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
  public static arfn_exec_sid_sm_ricR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_exec_sid_sm_ricR(p_Ctx, p_Caller);
  }
  public static arfn_exec_sid_sm_ricR Make(CPContext p_Ctx) {
    return new arfn_exec_sid_sm_ricR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pFile = CPLib.Space(128);
    fhand = CPLib.Space(1);
    _dir1 = CPLib.Space(180);
    _dir2 = CPLib.Space(180);
    _dir3 = CPLib.Space(180);
    _dir4 = CPLib.Space(180);
    _dirsid = CPLib.Space(250);
    _dirjava = CPLib.Space(250);
    _idsog = CPLib.Space(50);
    _pwdsog = CPLib.Space(50);
    _tipo = CPLib.Space(1);
    _riga = "";
    _fcfg = CPLib.Space(120);
    _semaforo = CPLib.Space(8);
    _risultato = CPLib.Space(3);
    _tiporis = CPLib.Space(20);
    _tipoelab = CPLib.Space(20);
    _categsid = CPLib.Space(15);
    _descrsid = CPLib.Space(100);
    _fileesi = CPLib.Space(80);
    _filedgn = CPLib.Space(80);
    _conta = 0;
    _found = 0;
    _fileann = CPLib.Space(128);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    _file1 = CPLib.Space(30);
    _file2 = CPLib.Space(30);
    _uscita = CPLib.Space(1);
    _nomefile = CPLib.Space(50);
    mcRitorno = new MemoryCursor_mcmessaggi_mcrdef();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_exec_sid_sm_ric,
  public static final String i_InvokedRoutines = ",arfn_exec_sid_sm_ric,";
  public static String[] m_cRunParameterNames={"pFile"};
  protected static String GetFieldsName_0000002E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
}
