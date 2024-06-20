// * --- Area Manuale = BO - Header
// * --- arrt_exec_sid
import java.io.*;
// * --- Fine Area Manuale
public class arrt_exec_sidR implements CallerWithObjs {
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
  public String m_cPhName_cpwarn;
  public String m_cServer_cpwarn;
  public String m_cPhName_tberrorisid;
  public String m_cServer_tberrorisid;
  public String m_cPhName_tberrsiddgn;
  public String m_cServer_tberrsiddgn;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
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
  public String w_fileprodotto;
  public double w_anno;
  public String w_flg555;
  public double w_numcicli;
  public String gAzienda;
  public String gPathApp;
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
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_exec_sidR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_exec_sid",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_cpwarn = p_ContextObject.GetPhName("cpwarn");
    if (m_cPhName_cpwarn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpwarn = m_cPhName_cpwarn+" "+m_Ctx.GetWritePhName("cpwarn");
    }
    m_cServer_cpwarn = p_ContextObject.GetServer("cpwarn");
    m_cPhName_tberrorisid = p_ContextObject.GetPhName("tberrorisid");
    if (m_cPhName_tberrorisid.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tberrorisid = m_cPhName_tberrorisid+" "+m_Ctx.GetWritePhName("tberrorisid");
    }
    m_cServer_tberrorisid = p_ContextObject.GetServer("tberrorisid");
    m_cPhName_tberrsiddgn = p_ContextObject.GetPhName("tberrsiddgn");
    if (m_cPhName_tberrsiddgn.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tberrsiddgn = m_cPhName_tberrsiddgn+" "+m_Ctx.GetWritePhName("tberrsiddgn");
    }
    m_cServer_tberrsiddgn = p_ContextObject.GetServer("tberrsiddgn");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
      m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
      if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
      }
      m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("numcicli",p_cVarName)) {
      return w_numcicli;
    }
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
      return "arrt_exec_sid";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("fileprodotto",p_cVarName)) {
      return w_fileprodotto;
    }
    if (CPLib.eqr("flg555",p_cVarName)) {
      return w_flg555;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("numcicli",p_cVarName)) {
      w_numcicli = value;
      return;
    }
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
    if (CPLib.eqr("fileprodotto",p_cVarName)) {
      w_fileprodotto = value;
      return;
    }
    if (CPLib.eqr("flg555",p_cVarName)) {
      w_flg555 = value;
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
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_listafile=null;
    try {
      /* w_fileprodotto Char(128) */
      /* w_anno Numeric(4, 0) */
      /* w_flg555 Char(1) */
      /* w_numcicli Numeric(10, 0) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
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
          Error l_oErrorFault = new Error("Read on cpwarn into routine arrt_exec_sid returns two or more records. This item should return only a record.");
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
        // * --- Insert into cpwarn from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"0000002A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000002A(m_Ctx,m_oWrInfo);
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
        /* gMsgProc := gMsgProc + 'Cancellazione file esiti precedenti' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"Cancellazione file esiti precedenti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Cancella vecchi file esiti
        File di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda)+"/");
        File fl[] = di.listFiles();
        int _i;
        int count=0;
        for (_i=0; _i < fl.length; _i++)  {
        //  System.out.println(""+fl[_i]);
          fl[_i].delete();
        }
        // Cancella vecchi file generati
        di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda)+"/");
        File fl2[] = di.listFiles();
        count=0;
        for (_i=0; _i < fl2.length; _i++)  {
        //  System.out.println(""+fl2[_i]);
          fl2[_i].delete();
        }
        /* If _tipo='W' */
        if (CPLib.eqr(_tipo,"W")) {
          /* _dirsid := gPathApp+"/SID/WINDOWS" */
          _dirsid = gPathApp+"/SID/WINDOWS";
          /* ElseIf _tipo='L' */
        } else if (CPLib.eqr(_tipo,"L")) {
          /* _dirsid := gPathApp+"/SID/LINUX" */
          _dirsid = gPathApp+"/SID/LINUX";
        } // End If
        /* _conta := 1 */
        _conta = CPLib.Round(1,0);
        /* If w_flg555='S' */
        if (CPLib.eqr(w_flg555,"S")) {
          /* While _conta <= w_numcicli */
          while (CPLib.le(_conta,w_numcicli)) {
            /* gMsgProc := gMsgProc + 'Lettura File per annullamento' + NL // Log Messaggi */
            gMsgProc = gMsgProc+"Lettura File per annullamento"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // Legge il file nella cartella
            di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/555/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"/");
            File fl555[] = di.listFiles();
            count=0;
            for (_i=0; _i < fl555.length; _i++)  {
            //  System.out.println(""+fl555[_i]);
              _fileann=CPLib.LRTrim(fl555[_i].getName());
              System.out.println(_fileann);
            }
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
            /* _idsog := LRTrim("ARG1 "+LRTrim(_idsog)) */
            _idsog = CPLib.LRTrim("ARG1 "+CPLib.LRTrim(_idsog));
            /* _dir1 := LRTrim("ARG2 " + LRTrim(gPathApp)+"/SID/INVII/555/"+LRTrim(gAzienda)+"/"+LRTrim(Str(_conta,10,0))+"/") */
            _dir1 = CPLib.LRTrim("ARG2 "+CPLib.LRTrim(gPathApp)+"/SID/INVII/555/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"/");
            /* _dir2 := LRTrim("ARG3 " + LRTrim(gPathApp)+"/SID/INVII/ESI/"+LRTrim(gAzienda)) */
            _dir2 = CPLib.LRTrim("ARG3 "+CPLib.LRTrim(gPathApp)+"/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda));
            /* _dir3 := LRTrim("ARG4 " + LRTrim(gPathApp)+"/SID/INVII/PRE/"+LRTrim(gAzienda)) */
            _dir3 = CPLib.LRTrim("ARG4 "+CPLib.LRTrim(gPathApp)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda));
            /* _dir4 := LRTrim("ARG5 " + LRTrim(gPathApp)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)) */
            _dir4 = CPLib.LRTrim("ARG5 "+CPLib.LRTrim(gPathApp)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda));
            /* _fcfg := '/SID/'+iif(_tipo='W','WINDOWS/config/predisposizione.cfg',iif(_tipo='L','LINUX/config/predisposizione.cfg','')) */
            _fcfg = "/SID/"+(CPLib.eqr(_tipo,"W")?"WINDOWS/config/predisposizione.cfg":(CPLib.eqr(_tipo,"L")?"LINUX/config/predisposizione.cfg":""));
            /* fhand := FileLibMit.OpenWrite(LRTrim(_fcfg)) // Handle File */
            fhand = FileLibMit.OpenWrite(CPLib.LRTrim(_fcfg));
            // Scrive il file Predisposizione CFG
            FileLibMit.WriteLine(fhand,"###############################################################################");
            FileLibMit.WriteLine(fhand,"### Commenti:");
            FileLibMit.WriteLine(fhand,"### l'identificativo di ogni parametro (ARG1, ARG2, etc.)non deve essere modificato; ");
            FileLibMit.WriteLine(fhand,"### lasciare uno spazio tra l'dentificativo del parametro (ARG1, ARG2, etc.)ed il ");
            FileLibMit.WriteLine(fhand,"### parametro stesso. ");
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare l'identificativo di registrazione al SID ");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
            FileLibMit.WriteLine(fhand,_idsog);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file da predisporre per la trasmissione");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
            FileLibMit.WriteLine(fhand,_dir1);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file degli esiti derivanti dalle operazioni di predisposizione  ");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
            FileLibMit.WriteLine(fhand,_dir2);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella che conterrà i file predisposti per la trasmissione ");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
            FileLibMit.WriteLine(fhand,_dir3);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare la cartella contenente i certificati di firma e di cifra ('A:' per floppy)");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio ");
            FileLibMit.WriteLine(fhand,_dir4);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"##");
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
            /* _idsog := "ARG1" */
            _idsog = "ARG1";
            /* _dir1 := "ARG2" */
            _dir1 = "ARG2";
            /* _dir2 := "ARG3" */
            _dir2 = "ARG3";
            /* _dir3 := "ARG4" */
            _dir3 = "ARG4";
            /* _dir4 := "ARG5" */
            _dir4 = "ARG5";
            /* _fcfg := '/SID/'+iif(_tipo='W','WINDOWS/config/predisposizione.cfg',iif(_tipo='L','LINUX/config/predisposizione.cfg','')) */
            _fcfg = "/SID/"+(CPLib.eqr(_tipo,"W")?"WINDOWS/config/predisposizione.cfg":(CPLib.eqr(_tipo,"L")?"LINUX/config/predisposizione.cfg":""));
            /* fhand := FileLibMit.OpenWrite(LRTrim(_fcfg)) // Handle File */
            fhand = FileLibMit.OpenWrite(CPLib.LRTrim(_fcfg));
            // Scrive il file Predisposizione CFG Originale
            FileLibMit.WriteLine(fhand,"###############################################################################");
            FileLibMit.WriteLine(fhand,"### Commenti:");
            FileLibMit.WriteLine(fhand,"### l'identificativo di ogni parametro (ARG1, ARG2, etc.)non deve essere modificato; ");
            FileLibMit.WriteLine(fhand,"### lasciare uno spazio tra l'dentificativo del parametro (ARG1, ARG2, etc.)ed il ");
            FileLibMit.WriteLine(fhand,"### parametro stesso. ");
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare l'identificativo di registrazione al SID ");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
            FileLibMit.WriteLine(fhand,_idsog);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file da predisporre per la trasmissione");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
            FileLibMit.WriteLine(fhand,_dir1);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file degli esiti derivanti dalle operazioni di predisposizione  ");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
            FileLibMit.WriteLine(fhand,_dir2);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella che conterrà i file predisposti per la trasmissione ");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
            FileLibMit.WriteLine(fhand,_dir3);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"## Indicare la cartella contenente i certificati di firma e di cifra ('A:' per floppy)");
            FileLibMit.WriteLine(fhand,"## Dato obbligatorio ");
            FileLibMit.WriteLine(fhand,_dir4);
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.WriteLine(fhand,"##");
            FileLibMit.Close(fhand);
            // Legge i file degli esiti
            di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda)+"/");
            File fl3[] =di.listFiles();
            count=0;
            for (_i=0; _i < fl3.length; _i++)  {
            /* If At('.esi',fl3[_i].getName()) <> 0 */
            if (CPLib.ne(CPLib.At(".esi",fl3[_i].getName()),0)) {
              /* _fileesi := fl3[_i].getName() */
              _fileesi = fl3[_i].getName();
              /* ElseIf At('.dgn',fl3[_i].getName()) <> 0 */
            } else if (CPLib.ne(CPLib.At(".dgn",fl3[_i].getName()),0)) {
              /* _filedgn := fl3[_i].getName() */
              _filedgn = fl3[_i].getName();
            } // End If
            //Chiude il ciclo
            }
            /* fhand := FileLibMit.OpenRead("/SID/INVII/ESI/"+LRTrim(gAzienda)+"/"+LRTrim(_fileesi)) // Handle File */
            fhand = FileLibMit.OpenRead("/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_fileesi));
            /* While not(FileLibMit.Eof(fhand)) */
            while ( ! (FileLibMit.Eof(fhand))) {
              /* _riga := FileLibMit.ReadLine(fhand) */
              _riga = FileLibMit.ReadLine(fhand);
              /* If Len(LRTrim(_riga)) > 0 */
              if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_riga)),0)) {
                /* _tipoelab := Substr(_riga,48,6) */
                _tipoelab = CPLib.Substr(_riga,48,6);
                /* _risultato := Substr(_riga,54,3) */
                _risultato = CPLib.Substr(_riga,54,3);
              } // End If
            } // End While
            /* FileLibMit.Close(fhand) */
            FileLibMit.Close(fhand);
            /* _categsid := '' */
            _categsid = "";
            /* _descrsid := '' */
            _descrsid = "";
            // * --- Read from tberrorisid
            m_cServer = m_Ctx.GetServer("tberrorisid");
            m_cPhName = m_Ctx.GetPhName("tberrorisid");
            m_cSql = "";
            m_cSql = m_cSql+"SIDCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_risultato,"C",3,0,m_cServer),m_cServer,_risultato);
            if (m_Ctx.IsSharedTemp("tberrorisid")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIDTIPOELAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SIDDESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _categsid = Read_Cursor.GetString("SIDTIPOELAB");
              _descrsid = Read_Cursor.GetString("SIDDESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tberrorisid into routine arrt_exec_sid returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _categsid = "";
              _descrsid = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* gMsgProc := gMsgProc + 'PROCEDURA COMPLETATA.' + NL // Log Messaggi */
            gMsgProc = gMsgProc+"PROCEDURA COMPLETATA."+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc + 'ESITO:'+_risultato + " - "+_categsid + " - " +_descrsid + NL // Log Messaggi */
            gMsgProc = gMsgProc+"ESITO:"+_risultato+" - "+_categsid+" - "+_descrsid+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* If _risultato='000' */
            if (CPLib.eqr(_risultato,"000")) {
              // Legge i file degli esiti
              di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda)+"/");
              File fl4[] =di.listFiles();
              count=0;
              for (_i=0; _i < fl4.length; _i++)  {
              /* _found := 0 */
              _found = CPLib.Round(0,0);
              // * --- Select from tmp_listafile
              m_cServer = m_Ctx.GetServer("tmp_listafile");
              m_cPhName = m_Ctx.GetPhName("tmp_listafile");
              if (Cursor_tmp_listafile!=null)
                Cursor_tmp_listafile.Close();
              Cursor_tmp_listafile = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_listafile")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_tmp_listafile.Eof())) {
                /* If LRTrim(fl4[_i].getName())=LRTrim(tmp_listafile->nomefile) */
                if (CPLib.eqr(CPLib.LRTrim(fl4[_i].getName()),CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile")))) {
                  /* _found := 1 */
                  _found = CPLib.Round(1,0);
                } // End If
                Cursor_tmp_listafile.Next();
              }
              m_cConnectivityError = Cursor_tmp_listafile.ErrorMessage();
              Cursor_tmp_listafile.Close();
              // * --- End Select
              /* If _found=0 */
              if (CPLib.eqr(_found,0)) {
                // * --- Insert into tmp_listafile from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_listafile");
                m_cPhName = m_Ctx.GetPhName("tmp_listafile");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"00000073")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000073(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(fl4[_i].getName(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"SID/INVII/PRE/"+CPLib.LRTrim(gAzienda)+"/"+fl4[_i].getName(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_conta,"?",0,0)+", ";
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
              } // End If
              //Chiude il ciclo
              }
              // * --- Select from tmp_listafile
              m_cServer = m_Ctx.GetServer("tmp_listafile");
              m_cPhName = m_Ctx.GetPhName("tmp_listafile");
              if (Cursor_tmp_listafile!=null)
                Cursor_tmp_listafile.Close();
              Cursor_tmp_listafile = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"priorita="+CPSql.SQLValueAdapter(CPLib.ToSQL(_conta,"?",0,0,m_cServer, m_oParameters),m_cServer,_conta)+" "+")"+(m_Ctx.IsSharedTemp("tmp_listafile")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_tmp_listafile.Eof())) {
                /* If At('ATB1',LRTrim(tmp_listafile->nomefile)) <> 0 */
                if (CPLib.ne(CPLib.At("ATB1",CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile"))),0)) {
                  // * --- Write into aesaldi from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aesaldi");
                  m_cPhName = m_Ctx.GetPhName("aesaldi");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"00000077")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"FILEINV1 = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile")),50),"C",50,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aesaldi",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"NOMEFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_fileann),50),"?",0,0,m_cServer),m_cServer,CPLib.Left(CPLib.LRTrim(_fileann),50))+"";
                  m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_anno,4,0))+"";
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
                /* If At('ATB2',LRTrim(tmp_listafile->nomefile)) <> 0 */
                if (CPLib.ne(CPLib.At("ATB2",CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile"))),0)) {
                  // * --- Write into aesaldi from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aesaldi");
                  m_cPhName = m_Ctx.GetPhName("aesaldi");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"00000079")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"FILEINV2 = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile")),50),"C",50,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aesaldi",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"NOMEFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(_fileann),50),"?",0,0,m_cServer),m_cServer,CPLib.Left(CPLib.LRTrim(_fileann),50))+"";
                  m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_anno,4,0))+"";
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
                Cursor_tmp_listafile.Next();
              }
              m_cConnectivityError = Cursor_tmp_listafile.ErrorMessage();
              Cursor_tmp_listafile.Close();
              // * --- End Select
              /* gMsgProc := gMsgProc + 'Terminata Elaborazione File Annullamento !'+NL // Log Messaggi */
              gMsgProc = gMsgProc+"Terminata Elaborazione File Annullamento !"+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* ElseIf _risultato <> '000' and LRTrim(_categsid)='CONTROLLO' */
            } else if (CPLib.ne(_risultato,"000") && CPLib.eqr(CPLib.LRTrim(_categsid),"CONTROLLO")) {
              /* fhand := FileLibMit.OpenRead("/SID/INVII/ESI/"+LRTrim(gAzienda)+"/"+LRTrim(_filedgn)) // Handle File */
              fhand = FileLibMit.OpenRead("/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filedgn));
              /* While not(FileLibMit.Eof(fhand)) */
              while ( ! (FileLibMit.Eof(fhand))) {
                /* _riga := FileLibMit.ReadLine(fhand) */
                _riga = FileLibMit.ReadLine(fhand);
                /* If Len(LRTrim(_riga)) > 0 and (Left(_riga,1)='A' or Left(_riga,1)='B') */
                if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_riga)),0) && (CPLib.eqr(CPLib.Left(_riga,1),"A") || CPLib.eqr(CPLib.Left(_riga,1),"B"))) {
                  /* _risultato := Substr(_riga,2,3) */
                  _risultato = CPLib.Substr(_riga,2,3);
                  /* _categsid := '' */
                  _categsid = "";
                  /* _descrsid := '' */
                  _descrsid = "";
                  // * --- Read from tberrsiddgn
                  m_cServer = m_Ctx.GetServer("tberrsiddgn");
                  m_cPhName = m_Ctx.GetPhName("tberrsiddgn");
                  m_cSql = "";
                  m_cSql = m_cSql+"DGNTIPO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(_riga,1),"C",1,0,m_cServer),m_cServer,CPLib.Left(_riga,1));
                  m_cSql = m_cSql+" and DGNCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,2,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(_riga,2,3));
                  if (m_Ctx.IsSharedTemp("tberrsiddgn")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DGNTIPOERR",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DGNDESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _categsid = Read_Cursor.GetString("DGNTIPOERR");
                    _descrsid = Read_Cursor.GetString("DGNDESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tberrsiddgn into routine arrt_exec_sid returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _categsid = "";
                    _descrsid = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* gMsgProc := gMsgProc + iif(Left(_riga,1)='A','ESITO:','ERRORE: ')+_risultato + " - "+_categsid + " - " +_descrsid + NL // Log Messaggi */
                  gMsgProc = gMsgProc+(CPLib.eqr(CPLib.Left(_riga,1),"A")?"ESITO:":"ERRORE: ")+_risultato+" - "+_categsid+" - "+_descrsid+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  /* gMsgProc := gMsgProc + 'Tipo Riga: '+Substr(_riga,5,1)+' - N. Record: '+Substr(_riga,6,9) +' - Campo Riferimento:'+Substr(_riga,30,3) + NL // Log Messaggi */
                  gMsgProc = gMsgProc+"Tipo Riga: "+CPLib.Substr(_riga,5,1)+" - N. Record: "+CPLib.Substr(_riga,6,9)+" - Campo Riferimento:"+CPLib.Substr(_riga,30,3)+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                } // End If
              } // End While
              /* FileLibMit.Close(fhand) */
              FileLibMit.Close(fhand);
              // * --- Write into aeannora from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aeannora");
              m_cPhName = m_Ctx.GetPhName("aeannora");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"00000086")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"PROG1 = "+CPLib.ToSQL("","C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROG2 = "+CPLib.ToSQL("","C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROGREC = "+CPLib.ToSQL("","C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"FILEANNO = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeannora",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"FILEANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(w_fileprodotto,50),"?",0,0,m_cServer),m_cServer,CPLib.Left(w_fileprodotto,50))+"";
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
            /* CriptoLibrary.AEScryptFile(LRTrim(gPathApp)+"/SID/INVII/555/"+LRTrim(gAzienda)+"/"+LRTrim(Str(_conta,10,0))+"/"+LRTrim(_fileann),LRTrim(gPathApp)+'/SID/INVII/STO/'+LRTrim(gAzienda)+"/"+LRTrim(_fileann)+".crypted",_pwdsog) */
            CriptoLibrary.AEScryptFile(CPLib.LRTrim(gPathApp)+"/SID/INVII/555/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"/"+CPLib.LRTrim(_fileann),CPLib.LRTrim(gPathApp)+"/SID/INVII/STO/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_fileann)+".crypted",_pwdsog);
            // Cancella i file e la cartella
            FileLibMit.DeleteFile("/SID/INVII/555/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"/"+CPLib.LRTrim(_fileann));
            FileLibMit.DeleteDirectory("SID/INVII/555/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(CPLib.Str(_conta,2,0)));
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
          } // End While
          /* gMsgProc := gMsgProc + 'Cancellazione file esiti precedenti' + NL // Log Messaggi */
          gMsgProc = gMsgProc+"Cancellazione file esiti precedenti"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Cancella vecchi file esiti
          di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda)+"/");
          File fl5[] = di.listFiles();
          count=0;
          for (_i=0; _i < fl5.length; _i++)  {
          //  System.out.println(""+fl[_i]);
            fl5[_i].delete();
          }
        } // End If
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
        /* _idsog := LRTrim("ARG1 "+LRTrim(_idsog)) */
        _idsog = CPLib.LRTrim("ARG1 "+CPLib.LRTrim(_idsog));
        /* _dir1 := LRTrim("ARG2 " + LRTrim(gPathApp)+"/SID/INVII/DAP/"+LRTrim(gAzienda)) */
        _dir1 = CPLib.LRTrim("ARG2 "+CPLib.LRTrim(gPathApp)+"/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda));
        /* _dir2 := LRTrim("ARG3 " + LRTrim(gPathApp)+"/SID/INVII/ESI/"+LRTrim(gAzienda)) */
        _dir2 = CPLib.LRTrim("ARG3 "+CPLib.LRTrim(gPathApp)+"/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda));
        /* _dir3 := LRTrim("ARG4 " + LRTrim(gPathApp)+"/SID/INVII/PRE/"+LRTrim(gAzienda)) */
        _dir3 = CPLib.LRTrim("ARG4 "+CPLib.LRTrim(gPathApp)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda));
        /* _dir4 := LRTrim("ARG5 " + LRTrim(gPathApp)+"/SID/CERTIFICATI/"+LRTrim(gAzienda)) */
        _dir4 = CPLib.LRTrim("ARG5 "+CPLib.LRTrim(gPathApp)+"/SID/CERTIFICATI/"+CPLib.LRTrim(gAzienda));
        /* _fcfg := '/SID/'+iif(_tipo='W','WINDOWS/config/predisposizione.cfg',iif(_tipo='L','LINUX/config/predisposizione.cfg','')) */
        _fcfg = "/SID/"+(CPLib.eqr(_tipo,"W")?"WINDOWS/config/predisposizione.cfg":(CPLib.eqr(_tipo,"L")?"LINUX/config/predisposizione.cfg":""));
        /* fhand := FileLibMit.OpenWrite(LRTrim(_fcfg)) // Handle File */
        fhand = FileLibMit.OpenWrite(CPLib.LRTrim(_fcfg));
        // Scrive il file Predisposizione CFG
        FileLibMit.WriteLine(fhand,"###############################################################################");
        FileLibMit.WriteLine(fhand,"### Commenti:");
        FileLibMit.WriteLine(fhand,"### l'identificativo di ogni parametro (ARG1, ARG2, etc.)non deve essere modificato; ");
        FileLibMit.WriteLine(fhand,"### lasciare uno spazio tra l'dentificativo del parametro (ARG1, ARG2, etc.)ed il ");
        FileLibMit.WriteLine(fhand,"### parametro stesso. ");
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare l'identificativo di registrazione al SID ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_idsog);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file da predisporre per la trasmissione");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir1);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file degli esiti derivanti dalle operazioni di predisposizione  ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir2);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella che conterrà i file predisposti per la trasmissione ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir3);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare la cartella contenente i certificati di firma e di cifra ('A:' per floppy)");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio ");
        FileLibMit.WriteLine(fhand,_dir4);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"##");
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
        /* _idsog := "ARG1" */
        _idsog = "ARG1";
        /* _dir1 := "ARG2" */
        _dir1 = "ARG2";
        /* _dir2 := "ARG3" */
        _dir2 = "ARG3";
        /* _dir3 := "ARG4" */
        _dir3 = "ARG4";
        /* _dir4 := "ARG5" */
        _dir4 = "ARG5";
        /* _fcfg := '/SID/'+iif(_tipo='W','WINDOWS/config/predisposizione.cfg',iif(_tipo='L','LINUX/config/predisposizione.cfg','')) */
        _fcfg = "/SID/"+(CPLib.eqr(_tipo,"W")?"WINDOWS/config/predisposizione.cfg":(CPLib.eqr(_tipo,"L")?"LINUX/config/predisposizione.cfg":""));
        /* fhand := FileLibMit.OpenWrite(LRTrim(_fcfg)) // Handle File */
        fhand = FileLibMit.OpenWrite(CPLib.LRTrim(_fcfg));
        // Scrive il file Predisposizione CFG Originale
        FileLibMit.WriteLine(fhand,"###############################################################################");
        FileLibMit.WriteLine(fhand,"### Commenti:");
        FileLibMit.WriteLine(fhand,"### l'identificativo di ogni parametro (ARG1, ARG2, etc.)non deve essere modificato; ");
        FileLibMit.WriteLine(fhand,"### lasciare uno spazio tra l'dentificativo del parametro (ARG1, ARG2, etc.)ed il ");
        FileLibMit.WriteLine(fhand,"### parametro stesso. ");
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare l'identificativo di registrazione al SID ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_idsog);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file da predisporre per la trasmissione");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir1);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella contenente i file degli esiti derivanti dalle operazioni di predisposizione  ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir2);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare il nome della cartella che conterrà i file predisposti per la trasmissione ");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio");
        FileLibMit.WriteLine(fhand,_dir3);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"## Indicare la cartella contenente i certificati di firma e di cifra ('A:' per floppy)");
        FileLibMit.WriteLine(fhand,"## Dato obbligatorio ");
        FileLibMit.WriteLine(fhand,_dir4);
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.WriteLine(fhand,"##");
        FileLibMit.Close(fhand);
        // Legge i file degli esiti
        di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda)+"/");
        File fl3[] =di.listFiles();
        count=0;
        for (_i=0; _i < fl3.length; _i++)  {
        /* If At('.esi',fl3[_i].getName()) <> 0 */
        if (CPLib.ne(CPLib.At(".esi",fl3[_i].getName()),0)) {
          /* _fileesi := fl3[_i].getName() */
          _fileesi = fl3[_i].getName();
          /* ElseIf At('.dgn',fl3[_i].getName()) <> 0 */
        } else if (CPLib.ne(CPLib.At(".dgn",fl3[_i].getName()),0)) {
          /* _filedgn := fl3[_i].getName() */
          _filedgn = fl3[_i].getName();
        } // End If
        //Chiude il ciclo
        }
        /* fhand := FileLibMit.OpenRead("/SID/INVII/ESI/"+LRTrim(gAzienda)+"/"+LRTrim(_fileesi)) // Handle File */
        fhand = FileLibMit.OpenRead("/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_fileesi));
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* _riga := FileLibMit.ReadLine(fhand) */
          _riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(_riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_riga)),0)) {
            /* _tipoelab := Substr(_riga,48,6) */
            _tipoelab = CPLib.Substr(_riga,48,6);
            /* _risultato := Substr(_riga,54,3) */
            _risultato = CPLib.Substr(_riga,54,3);
          } // End If
        } // End While
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* _categsid := '' */
        _categsid = "";
        /* _descrsid := '' */
        _descrsid = "";
        // * --- Read from tberrorisid
        m_cServer = m_Ctx.GetServer("tberrorisid");
        m_cPhName = m_Ctx.GetPhName("tberrorisid");
        m_cSql = "";
        m_cSql = m_cSql+"SIDCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_risultato,"C",3,0,m_cServer),m_cServer,_risultato);
        if (m_Ctx.IsSharedTemp("tberrorisid")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIDTIPOELAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SIDDESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _categsid = Read_Cursor.GetString("SIDTIPOELAB");
          _descrsid = Read_Cursor.GetString("SIDDESCRI");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on tberrorisid into routine arrt_exec_sid returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _categsid = "";
          _descrsid = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* gMsgProc := gMsgProc + 'PROCEDURA COMPLETATA.' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"PROCEDURA COMPLETATA."+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'ESITO:'+_risultato + " - "+_categsid + " - " +_descrsid + NL // Log Messaggi */
        gMsgProc = gMsgProc+"ESITO:"+_risultato+" - "+_categsid+" - "+_descrsid+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If _risultato='000' */
        if (CPLib.eqr(_risultato,"000")) {
          // Legge i file degli esiti
          di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda)+"/");
          File fl4[] =di.listFiles();
          count=0;
          for (_i=0; _i < fl4.length; _i++)  {
          /* _found := 0 */
          _found = CPLib.Round(0,0);
          // * --- Select from tmp_listafile
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          if (Cursor_tmp_listafile!=null)
            Cursor_tmp_listafile.Close();
          Cursor_tmp_listafile = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_listafile")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_listafile.Eof())) {
            /* If LRTrim(fl4[_i].getName())=LRTrim(tmp_listafile->nomefile) */
            if (CPLib.eqr(CPLib.LRTrim(fl4[_i].getName()),CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile")))) {
              /* _found := 1 */
              _found = CPLib.Round(1,0);
            } // End If
            Cursor_tmp_listafile.Next();
          }
          m_cConnectivityError = Cursor_tmp_listafile.ErrorMessage();
          Cursor_tmp_listafile.Close();
          // * --- End Select
          /* If _found=0 */
          if (CPLib.eqr(_found,0)) {
            // * --- Insert into tmp_listafile from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_listafile");
            m_cPhName = m_Ctx.GetPhName("tmp_listafile");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"000000C2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000C2(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(fl4[_i].getName(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"SID/INVII/PRE/"+CPLib.LRTrim(gAzienda)+"/"+fl4[_i].getName(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_conta,"?",0,0)+", ";
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
          } // End If
          //Chiude il ciclo
          }
          // * --- Select from tmp_listafile
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          if (Cursor_tmp_listafile!=null)
            Cursor_tmp_listafile.Close();
          Cursor_tmp_listafile = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"priorita="+CPSql.SQLValueAdapter(CPLib.ToSQL(_conta,"?",0,0,m_cServer, m_oParameters),m_cServer,_conta)+" "+")"+(m_Ctx.IsSharedTemp("tmp_listafile")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_listafile.Eof())) {
            /* If At('ATB1',LRTrim(tmp_listafile->nomefile)) <> 0 */
            if (CPLib.ne(CPLib.At("ATB1",CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile"))),0)) {
              // * --- Write into aesaldi from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aesaldi");
              m_cPhName = m_Ctx.GetPhName("aesaldi");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"000000C6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"FILEINV1 = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile")),50),"C",50,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aesaldi",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NOMEFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(w_fileprodotto,50),"?",0,0,m_cServer),m_cServer,CPLib.Left(w_fileprodotto,50))+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_anno,4,0))+"";
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
            /* If At('ATB2',LRTrim(tmp_listafile->nomefile)) <> 0 */
            if (CPLib.ne(CPLib.At("ATB2",CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile"))),0)) {
              // * --- Write into aesaldi from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aesaldi");
              m_cPhName = m_Ctx.GetPhName("aesaldi");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"000000C8")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"FILEINV2 = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile")),50),"C",50,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aesaldi",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"NOMEFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(w_fileprodotto,50),"?",0,0,m_cServer),m_cServer,CPLib.Left(w_fileprodotto,50))+"";
              m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_anno,4,0))+"";
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
            Cursor_tmp_listafile.Next();
          }
          m_cConnectivityError = Cursor_tmp_listafile.ErrorMessage();
          Cursor_tmp_listafile.Close();
          // * --- End Select
          /* gMsgProc := gMsgProc + 'Terminata Elaborazione File Saldi !'+NL // Log Messaggi */
          gMsgProc = gMsgProc+"Terminata Elaborazione File Saldi !"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'PREMERE IL BOTTONE CON LA LENTE PER PRELEVARE I FILE DA INVIARE' // Log Messaggi */
          gMsgProc = gMsgProc+"PREMERE IL BOTTONE CON LA LENTE PER PRELEVARE I FILE DA INVIARE";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* ElseIf _risultato <> '000' and LRTrim(_categsid)='CONTROLLO' */
        } else if (CPLib.ne(_risultato,"000") && CPLib.eqr(CPLib.LRTrim(_categsid),"CONTROLLO")) {
          /* fhand := FileLibMit.OpenRead("/SID/INVII/ESI/"+LRTrim(gAzienda)+"/"+LRTrim(_filedgn)) // Handle File */
          fhand = FileLibMit.OpenRead("/SID/INVII/ESI/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filedgn));
          /* While not(FileLibMit.Eof(fhand)) */
          while ( ! (FileLibMit.Eof(fhand))) {
            /* _riga := FileLibMit.ReadLine(fhand) */
            _riga = FileLibMit.ReadLine(fhand);
            /* If Len(LRTrim(_riga)) > 0 and (Left(_riga,1)='A' or Left(_riga,1)='B') */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_riga)),0) && (CPLib.eqr(CPLib.Left(_riga,1),"A") || CPLib.eqr(CPLib.Left(_riga,1),"B"))) {
              /* _risultato := Substr(_riga,2,3) */
              _risultato = CPLib.Substr(_riga,2,3);
              /* _categsid := '' */
              _categsid = "";
              /* _descrsid := '' */
              _descrsid = "";
              // * --- Read from tberrsiddgn
              m_cServer = m_Ctx.GetServer("tberrsiddgn");
              m_cPhName = m_Ctx.GetPhName("tberrsiddgn");
              m_cSql = "";
              m_cSql = m_cSql+"DGNTIPO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(_riga,1),"C",1,0,m_cServer),m_cServer,CPLib.Left(_riga,1));
              m_cSql = m_cSql+" and DGNCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_riga,2,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(_riga,2,3));
              if (m_Ctx.IsSharedTemp("tberrsiddgn")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DGNTIPOERR",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DGNDESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _categsid = Read_Cursor.GetString("DGNTIPOERR");
                _descrsid = Read_Cursor.GetString("DGNDESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tberrsiddgn into routine arrt_exec_sid returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _categsid = "";
                _descrsid = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* gMsgProc := gMsgProc + iif(Left(_riga,1)='A','ESITO:','ERRORE: ')+_risultato + " - "+_categsid + " - " +_descrsid + NL // Log Messaggi */
              gMsgProc = gMsgProc+(CPLib.eqr(CPLib.Left(_riga,1),"A")?"ESITO:":"ERRORE: ")+_risultato+" - "+_categsid+" - "+_descrsid+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              /* gMsgProc := gMsgProc + 'Tipo Riga: '+Substr(_riga,5,1)+' - N. Record: '+Substr(_riga,6,9) +' - Campo Riferimento:'+Substr(_riga,30,3) + NL // Log Messaggi */
              gMsgProc = gMsgProc+"Tipo Riga: "+CPLib.Substr(_riga,5,1)+" - N. Record: "+CPLib.Substr(_riga,6,9)+" - Campo Riferimento:"+CPLib.Substr(_riga,30,3)+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
          } // End While
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          // * --- Write into aeannora from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeannora");
          m_cPhName = m_Ctx.GetPhName("aeannora");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"000000D6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"PROG1 = "+CPLib.ToSQL("","C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROG2 = "+CPLib.ToSQL("","C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROGREC = "+CPLib.ToSQL("","C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"FILEANNO = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeannora",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"FILEANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(w_fileprodotto,50),"?",0,0,m_cServer),m_cServer,CPLib.Left(w_fileprodotto,50))+"";
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
        /* CriptoLibrary.AEScryptFile(LRTrim(gPathApp)+'/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(w_fileprodotto),LRTrim(gPathApp)+'/SID/INVII/STO/'+LRTrim(gAzienda)+"/"+LRTrim(w_fileprodotto)+".crypted",_pwdsog) */
        CriptoLibrary.AEScryptFile(CPLib.LRTrim(gPathApp)+"/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_fileprodotto),CPLib.LRTrim(gPathApp)+"/SID/INVII/STO/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_fileprodotto)+".crypted",_pwdsog);
        /* FileLibMit.DeleteFile('SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(w_fileprodotto)) */
        FileLibMit.DeleteFile("SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_fileprodotto));
        // * --- Delete from cpwarn
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cpwarn");
        m_cPhName = m_Ctx.GetPhName("cpwarn");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cpwarn",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_exec_sid",249,"000000D9")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_listafile!=null)
          Cursor_tmp_listafile.Close();
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
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runFlussiMIT.bat",CPLib.LRTrim(_dir1),CPLib.Upper(_pwdsog)};
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
  void Page_3() throws Exception {
    /* Esegue SID Linux */
    // Provo a lanciare il batch
    try
    {
      File _mydir = new File(CPLib.LRTrim(_dirsid)+"/prog");
      // String[] cmd = {"sh", "-c",CPLib.LRTrim(_dirsid)+"/prog/runFlussiMIT.sh",CPLib.LRTrim(_dirjava)+"/bin/java",CPLib.Upper(_pwdsog)};
      String[] cmd = {CPLib.LRTrim(_dirsid)+"/prog/runFlussiMIT.sh",CPLib.LRTrim(_dirjava)+"/bin/java",CPLib.Upper(_pwdsog)};
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
      m_Caller.SetString("fileprodotto","C",128,0,w_fileprodotto);
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.SetString("flg555","C",1,0,w_flg555);
      m_Caller.SetNumber("numcicli","N",10,0,w_numcicli);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_exec_sidR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_exec_sidR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_fileprodotto = m_Caller.GetString("fileprodotto","C",128,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    w_flg555 = m_Caller.GetString("flg555","C",1,0);
    w_numcicli = m_Caller.GetNumber("numcicli","N",10,0);
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
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000002A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"tablecode,";
    p_cSql = p_cSql+"warncode,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cpwarn",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000073(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+"priorita,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
}
