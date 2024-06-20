// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_esito_rap_cfR implements CallerWithObjs {
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
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_esiti_age;
  public String m_cServer_tmp_esiti_age;
  public String m_cPhName_tbesitoae;
  public String m_cServer_tbesitoae;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aefiles_esiti;
  public String m_cServer_aefiles_esiti;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public String w_tipodoc;
  public String fhand;
  public String riga;
  public String nomefileimport;
  public String _intercf;
  public String _intercg;
  public String _internm;
  public String _interrs;
  public String _interpr;
  public String _interid;
  public String _interinfo;
  public double _i;
  public double _j;
  public String _esito;
  public double _start;
  public String _cdescri;
  public String _sdescri;
  public double conta;
  public double _totale;
  public String _numprog;
  public String _rapporto;
  public String _idfileimp;
  public java.sql.Date _datesito;
  public String _connes;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_esito_rap_cfR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_esito_rap_cf",m_Caller);
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_tmp_esiti_age = p_ContextObject.GetPhName("tmp_esiti_age");
    if (m_cPhName_tmp_esiti_age.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_esiti_age = m_cPhName_tmp_esiti_age+" "+m_Ctx.GetWritePhName("tmp_esiti_age");
    }
    m_cServer_tmp_esiti_age = p_ContextObject.GetServer("tmp_esiti_age");
    m_cPhName_tbesitoae = p_ContextObject.GetPhName("tbesitoae");
    if (m_cPhName_tbesitoae.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbesitoae = m_cPhName_tbesitoae+" "+m_Ctx.GetWritePhName("tbesitoae");
    }
    m_cServer_tbesitoae = p_ContextObject.GetServer("tbesitoae");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aefiles_esiti = p_ContextObject.GetPhName("aefiles_esiti");
    if (m_cPhName_aefiles_esiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles_esiti = m_cPhName_aefiles_esiti+" "+m_Ctx.GetWritePhName("aefiles_esiti");
    }
    m_cServer_aefiles_esiti = p_ContextObject.GetServer("aefiles_esiti");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_j",p_cVarName)) {
      return _j;
    }
    if (CPLib.eqr("_start",p_cVarName)) {
      return _start;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_esito_rap_cf";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipodoc",p_cVarName)) {
      return w_tipodoc;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("_intercf",p_cVarName)) {
      return _intercf;
    }
    if (CPLib.eqr("_intercg",p_cVarName)) {
      return _intercg;
    }
    if (CPLib.eqr("_internm",p_cVarName)) {
      return _internm;
    }
    if (CPLib.eqr("_interrs",p_cVarName)) {
      return _interrs;
    }
    if (CPLib.eqr("_interpr",p_cVarName)) {
      return _interpr;
    }
    if (CPLib.eqr("_interid",p_cVarName)) {
      return _interid;
    }
    if (CPLib.eqr("_interinfo",p_cVarName)) {
      return _interinfo;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_cdescri",p_cVarName)) {
      return _cdescri;
    }
    if (CPLib.eqr("_sdescri",p_cVarName)) {
      return _sdescri;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_idfileimp",p_cVarName)) {
      return _idfileimp;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datesito",p_cVarName)) {
      return _datesito;
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
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_j",p_cVarName)) {
      _j = value;
      return;
    }
    if (CPLib.eqr("_start",p_cVarName)) {
      _start = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodoc",p_cVarName)) {
      w_tipodoc = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
      return;
    }
    if (CPLib.eqr("_intercf",p_cVarName)) {
      _intercf = value;
      return;
    }
    if (CPLib.eqr("_intercg",p_cVarName)) {
      _intercg = value;
      return;
    }
    if (CPLib.eqr("_internm",p_cVarName)) {
      _internm = value;
      return;
    }
    if (CPLib.eqr("_interrs",p_cVarName)) {
      _interrs = value;
      return;
    }
    if (CPLib.eqr("_interpr",p_cVarName)) {
      _interpr = value;
      return;
    }
    if (CPLib.eqr("_interid",p_cVarName)) {
      _interid = value;
      return;
    }
    if (CPLib.eqr("_interinfo",p_cVarName)) {
      _interinfo = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_cdescri",p_cVarName)) {
      _cdescri = value;
      return;
    }
    if (CPLib.eqr("_sdescri",p_cVarName)) {
      _sdescri = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_idfileimp",p_cVarName)) {
      _idfileimp = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datesito",p_cVarName)) {
      _datesito = value;
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
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* w_tipodoc Char(2) */
      /* Definizione variabili locali */
      /* fhand Char(1) */
      /* riga Memo */
      /* nomefileimport Char(50) */
      /* _intercf Char(16) */
      /* _intercg Char(26) */
      /* _internm Char(25) */
      /* _interrs Char(70) */
      /* _interpr Char(17) */
      /* _interid Char(15) */
      /* _interinfo Char(240) */
      /* _i Numeric(2, 0) */
      /* _j Numeric(2, 0) */
      /* _esito Char(40) */
      /* _start Numeric(4, 0) */
      /* _cdescri Memo */
      /* _sdescri Memo */
      /* conta Numeric(10, 0) */
      /* _totale Numeric(10, 0) */
      /* _numprog Char(25) */
      /* _rapporto Char(25) */
      /* _idfileimp Char(10) */
      /* _datesito Date */
      /* _connes Char(16) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla sul file della lista e lancia la pagina appropriata */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000024status;
      nTry00000024status = m_Sql.GetTransactionStatus();
      String cTry00000024msg;
      cTry00000024msg = m_Sql.TransactionErrorMessage();
      try {
        /* _totale := 0 */
        _totale = CPLib.Round(0,0);
        // * --- Select from tmp_list_imprich
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
        Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_list_imprich.Eof())) {
          /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
          nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
          /* _idfileimp := '' */
          _idfileimp = "";
          /* Exec "File Esito" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          // * --- Delete from tmp_list_imprich
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"0000002A")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        /* gMsgImp := 'Importazione dati terminata. Premere il bottone di stampa per il risultato' // Messaggio Import */
        gMsgImp = "Importazione dati terminata. Premere il bottone di stampa per il risultato";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Totale Record Elaborati: '+LRTrim(Str(_totale,10,0)) + NL */
        gMsgProc = gMsgProc+"Totale Record Elaborati: "+CPLib.LRTrim(CPLib.Str(_totale,10,0))+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000024status,0)) {
          m_Sql.SetTransactionStatus(nTry00000024status,cTry00000024msg);
        }
      }
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
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
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
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* Case Left(riga,1)='0' */
          if (CPLib.eqr(CPLib.Left(riga,1),"0")) {
            /* _intercf := Substr(riga,9,16) */
            _intercf = CPLib.Substr(riga,9,16);
            /* _intercg := Substr(riga,26,26) */
            _intercg = CPLib.Substr(riga,26,26);
            /* _internm := Substr(riga,51,25) */
            _internm = CPLib.Substr(riga,51,25);
            /* _interrs := Substr(riga,76,70) */
            _interrs = CPLib.Substr(riga,76,70);
            /* _interpr := Substr(riga,146,17) */
            _interpr = CPLib.Substr(riga,146,17);
            /* _interid := Substr(riga,163,15) */
            _interid = CPLib.Substr(riga,163,15);
            /* If not(Empty(LRTrim(_intercg))) and not(Empty(LRTrim(_internm))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(_intercg))) &&  ! (CPLib.Empty(CPLib.LRTrim(_internm)))) {
              /* _interinfo := LRTrim(_intercg)+" "+ LRTrim(_internm) + " - " + _intercf */
              _interinfo = CPLib.LRTrim(_intercg)+" "+CPLib.LRTrim(_internm)+" - "+_intercf;
            } else { // Else
              /* _interinfo := LRTrim(_interrs)+ " - " + _intercf */
              _interinfo = CPLib.LRTrim(_interrs)+" - "+_intercf;
            } // End If
            /* Case Left(riga,1)='9' */
          } else if (CPLib.eqr(CPLib.Left(riga,1),"9")) {
            /* _datesito := CharToDate(Substr(riga,47,8)) */
            _datesito = CPLib.CharToDate(CPLib.Substr(riga,47,8));
          } // End Case
        } // End If
      } // End While
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* fhand := FileLibMit.OpenRead('./appo/'+nomefileimport) */
      fhand = FileLibMit.OpenRead("./appo/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 and Left(riga,1)='B' */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0) && CPLib.eqr(CPLib.Left(riga,1),"B")) {
          /* _i := 1 */
          _i = CPLib.Round(1,0);
          /* _j := 0 */
          _j = CPLib.Round(0,0);
          /* While _i <= 50 */
          while (CPLib.le(_i,50)) {
            /* _esito := Substr(riga,2+(39*_j),39) */
            _esito = CPLib.Substr(riga,2+(39*_j),39);
            /* _cdescri := '' */
            _cdescri = "";
            /* _sdescri := '' */
            _sdescri = "";
            /* If Len(LRTrim(_esito)) > 0 */
            if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_esito)),0)) {
              /* _rapporto := '' */
              _rapporto = "";
              // * --- Read from tbesitoae
              m_cServer = m_Ctx.GetServer("tbesitoae");
              m_cPhName = m_Ctx.GetPhName("tbesitoae");
              m_cSql = "";
              m_cSql = m_cSql+"TIPO="+CPSql.SQLValueAdapter(CPLib.ToSQL("C","C",1,0,m_cServer),m_cServer,"C");
              m_cSql = m_cSql+" and CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_esito,26,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(_esito,26,3));
              if (m_Ctx.IsSharedTemp("tbesitoae")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _cdescri = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbesitoae into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _cdescri = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              // * --- Read from tbesitoae
              m_cServer = m_Ctx.GetServer("tbesitoae");
              m_cPhName = m_Ctx.GetPhName("tbesitoae");
              m_cSql = "";
              m_cSql = m_cSql+"TIPO="+CPSql.SQLValueAdapter(CPLib.ToSQL("S","C",1,0,m_cServer),m_cServer,"S");
              m_cSql = m_cSql+" and CODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(_esito,29,1),"C",3,0,m_cServer),m_cServer,CPLib.Substr(_esito,29,1));
              if (m_Ctx.IsSharedTemp("tbesitoae")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _sdescri = Read_Cursor.GetString("DESCRI");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbesitoae into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _sdescri = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* _connes := '' */
              _connes = "";
              /* Exec "Legge il codice del cliente" Page 4:Page_4 */
              Page_4();
              /* If Len(LRTrim(_connes)) <> 0 */
              if (CPLib.ne(CPLib.Len(CPLib.LRTrim(_connes)),0)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* If personbo->TIPODOC=w_tipodoc */
                  if (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),w_tipodoc)) {
                    // * --- Write into personbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo");
                    m_cPhName = m_Ctx.GetPhName("personbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"00000059")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                    m_cSql = m_cSql+"ALLINEATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                    // * --- Delete from tmp_esiti_age
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("tmp_esiti_age");
                    m_cPhName = m_Ctx.GetPhName("tmp_esiti_age");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esiti_age",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"0000005A")+"delete from "+m_oWrInfo.GetTableWriteName();
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
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
                    /* Exec "Scrittura Rettifica" Page 3:Page_3 */
                    Page_3();
                  } else { // Else
                    /* If personbo->ALLINEATO=0 */
                    if (CPLib.eqr(Cursor_personbo.GetDouble("ALLINEATO"),0)) {
                      // * --- Insert into tmp_esiti_age from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("tmp_esiti_age");
                      m_cPhName = m_Ctx.GetPhName("tmp_esiti_age");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esiti_age",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"0000005D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_0000005D(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_interpr,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_interinfo,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_interid,"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_esito,1,25),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(_esito,1,25)),"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_esito,26,3),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_esito,29,1),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_esito,30,8),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_cdescri,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(_sdescri,"?",0,0,m_cServer, m_oParameters)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esiti_age",true);
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
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Insert into tmp_esiti_age from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_esiti_age");
                m_cPhName = m_Ctx.GetPhName("tmp_esiti_age");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esiti_age",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"0000005E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000005E(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_connes,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_interpr,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_interinfo,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_interid,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_esito,1,25),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.Substr(_esito,1,25)),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_esito,26,3),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_esito,29,1),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Substr(_esito,30,8),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_cdescri,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_sdescri,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_esiti_age",true);
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
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* _totale := _totale + 1 */
              _totale = CPLib.Round(_totale+1,0);
              /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' record del file '+nomefileimport // Messaggio Import */
              gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record del file "+nomefileimport;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } else { // Else
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
            /* _i := _i + 1 */
            _i = CPLib.Round(_i+1,0);
            /* _j := _j + 1 */
            _j = CPLib.Round(_j+1,0);
          } // End While
        } // End If
      } // End While
      /* gMsgProc := gMsgProc + 'Record Elaborati: '+LRTrim(Str(conta,10,0)) + ' dal file '+nomefileimport+NL */
      gMsgProc = gMsgProc+"Record Elaborati: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" dal file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* FileLibMit.DeleteFile('./appo/'+nomefileimport) */
      FileLibMit.DeleteFile("./appo/"+nomefileimport);
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
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Aggiorna il file corretto */
      /* _rapporto := '' */
      _rapporto = "";
      /* _numprog := LRTrim(Str(Val(Substr(_esito,1,25)),25,0)) */
      _numprog = CPLib.LRTrim(CPLib.Str(CPLib.Val(CPLib.Substr(_esito,1,25)),25,0));
      // * --- Read from aerighe
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      m_cSql = "";
      m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
      m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
      if (m_Ctx.IsSharedTemp("aerighe")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _rapporto = Read_Cursor.GetString("RAPPORTO");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on aerighe into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _rapporto = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If not(Empty(_rapporto)) */
      if ( ! (CPLib.Empty(_rapporto))) {
        // * --- Write into aerighe from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"0000006F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
        m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
        m_cSql = m_cSql+" and AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"?",0,0,m_cServer),m_cServer,_interid)+"";
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
        /* _rapporto := '' */
        _rapporto = "";
        // * --- Read from aerighe
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_cSql = "";
        m_cSql = m_cSql+"CPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
        m_cSql = m_cSql+" and CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
        if (m_Ctx.IsSharedTemp("aerighe")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _rapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aerighe into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_rapporto)) */
        if ( ! (CPLib.Empty(_rapporto))) {
          // * --- Write into aerighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"00000073")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
          m_cSql = m_cSql+" and CFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"?",0,0,m_cServer),m_cServer,_interid)+"";
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
      /* If Empty(_rapporto) */
      if (CPLib.Empty(_rapporto)) {
        // * --- Read from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_cSql = "";
        m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
        m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
        if (m_Ctx.IsSharedTemp("aederig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _rapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aederig into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_rapporto)) */
        if ( ! (CPLib.Empty(_rapporto))) {
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"00000077")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
          m_cSql = m_cSql+" and AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"?",0,0,m_cServer),m_cServer,_interid)+"";
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
          /* _rapporto := '' */
          _rapporto = "";
          // * --- Read from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_cSql = "";
          m_cSql = m_cSql+"CPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
          m_cSql = m_cSql+" and CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
          if (m_Ctx.IsSharedTemp("aederig")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _rapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aederig into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _rapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_rapporto)) */
          if ( ! (CPLib.Empty(_rapporto))) {
            // * --- Write into aederig from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aederig");
            m_cPhName = m_Ctx.GetPhName("aederig");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"0000007B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
            m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
            m_cSql = m_cSql+" and CFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"?",0,0,m_cServer),m_cServer,_interid)+"";
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
      } // End If
      /* If Empty(_rapporto) */
      if (CPLib.Empty(_rapporto)) {
        // * --- Read from aeoprig
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        m_cSql = "";
        m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
        m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
        if (m_Ctx.IsSharedTemp("aeoprig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _rapporto = Read_Cursor.GetString("CONNESINT");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aeoprig into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_rapporto)) */
        if ( ! (CPLib.Empty(_rapporto))) {
          // * --- Write into aeoprig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"0000007F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
          m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
          m_cSql = m_cSql+" and AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"?",0,0,m_cServer),m_cServer,_interid)+"";
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
          // * --- Write into tmp_esiti_age from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_esiti_age");
          m_cPhName = m_Ctx.GetPhName("tmp_esiti_age");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esiti_age",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_cf",525,"00000080")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOESITO = "+CPLib.ToSQL("O","C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_esiti_age",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"?",0,0,m_cServer),m_cServer,_numprog)+"";
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
  void Page_4() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Aggiorna il file corretto */
      /* _rapporto := '' */
      _rapporto = "";
      /* _numprog := LRTrim(Str(Val(Substr(_esito,1,25)),25,0)) */
      _numprog = CPLib.LRTrim(CPLib.Str(CPLib.Val(CPLib.Substr(_esito,1,25)),25,0));
      // * --- Read from aerighe
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      m_cSql = "";
      m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
      m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
      if (m_Ctx.IsSharedTemp("aerighe")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _rapporto = Read_Cursor.GetString("RAPPORTO");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on aerighe into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _rapporto = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If not(Empty(_rapporto)) */
      if ( ! (CPLib.Empty(_rapporto))) {
        // * --- Read from aerighe
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_cSql = "";
        m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
        m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
        if (m_Ctx.IsSharedTemp("aerighe")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _connes = Read_Cursor.GetString("CONNESINT");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aerighe into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _connes = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
      } else { // Else
        /* _rapporto := '' */
        _rapporto = "";
        // * --- Read from aerighe
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_cSql = "";
        m_cSql = m_cSql+"CPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
        m_cSql = m_cSql+" and CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
        if (m_Ctx.IsSharedTemp("aerighe")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _rapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aerighe into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_rapporto)) */
        if ( ! (CPLib.Empty(_rapporto))) {
          // * --- Read from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_cSql = "";
          m_cSql = m_cSql+"CPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
          m_cSql = m_cSql+" and CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
          if (m_Ctx.IsSharedTemp("aerighe")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _connes = Read_Cursor.GetString("CONNESINT");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aerighe into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _connes = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
      } // End If
      /* If Empty(_rapporto) */
      if (CPLib.Empty(_rapporto)) {
        // * --- Read from aederig
        m_cServer = m_Ctx.GetServer("aederig");
        m_cPhName = m_Ctx.GetPhName("aederig");
        m_cSql = "";
        m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
        m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
        if (m_Ctx.IsSharedTemp("aederig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _rapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aederig into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_rapporto)) */
        if ( ! (CPLib.Empty(_rapporto))) {
          // * --- Read from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_cSql = "";
          m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
          m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
          if (m_Ctx.IsSharedTemp("aederig")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _connes = Read_Cursor.GetString("CONNESINT");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aederig into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _connes = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } else { // Else
          /* _rapporto := '' */
          _rapporto = "";
          // * --- Read from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_cSql = "";
          m_cSql = m_cSql+"CPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
          m_cSql = m_cSql+" and CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
          if (m_Ctx.IsSharedTemp("aederig")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _rapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aederig into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _rapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If not(Empty(_rapporto)) */
          if ( ! (CPLib.Empty(_rapporto))) {
            // * --- Read from aederig
            m_cServer = m_Ctx.GetServer("aederig");
            m_cPhName = m_Ctx.GetPhName("aederig");
            m_cSql = "";
            m_cSql = m_cSql+"CPROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
            m_cSql = m_cSql+" and CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
            if (m_Ctx.IsSharedTemp("aederig")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _connes = Read_Cursor.GetString("CONNESINT");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aederig into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _connes = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
        } // End If
      } // End If
      /* If Empty(_rapporto) */
      if (CPLib.Empty(_rapporto)) {
        // * --- Read from aeoprig
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        m_cSql = "";
        m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
        m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
        if (m_Ctx.IsSharedTemp("aeoprig")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _rapporto = Read_Cursor.GetString("CONNESINT");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aeoprig into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(_rapporto)) */
        if ( ! (CPLib.Empty(_rapporto))) {
          // * --- Read from aeoprig
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          m_cSql = "";
          m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(_numprog,"C",25,0,m_cServer),m_cServer,_numprog);
          m_cSql = m_cSql+" and AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_interid,"C",15,0,m_cServer),m_cServer,_interid);
          if (m_Ctx.IsSharedTemp("aeoprig")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNESINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _connes = Read_Cursor.GetString("CONNESINT");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aeoprig into routine arrt_esito_rap_cf returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _connes = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
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
      m_Caller.SetString("tipodoc","C",2,0,w_tipodoc);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_esito_rap_cfR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_esito_rap_cfR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_tipodoc = m_Caller.GetString("tipodoc","C",2,0);
    fhand = CPLib.Space(1);
    riga = "";
    nomefileimport = CPLib.Space(50);
    _intercf = CPLib.Space(16);
    _intercg = CPLib.Space(26);
    _internm = CPLib.Space(25);
    _interrs = CPLib.Space(70);
    _interpr = CPLib.Space(17);
    _interid = CPLib.Space(15);
    _interinfo = CPLib.Space(240);
    _i = 0;
    _j = 0;
    _esito = CPLib.Space(40);
    _start = 0;
    _cdescri = "";
    _sdescri = "";
    conta = 0;
    _totale = 0;
    _numprog = CPLib.Space(25);
    _rapporto = CPLib.Space(25);
    _idfileimp = CPLib.Space(10);
    _datesito = CPLib.NullDate();
    _connes = CPLib.Space(16);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000005D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"PROT,";
    p_cSql = p_cSql+"INFO,";
    p_cSql = p_cSql+"NFILE,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"COD,";
    p_cSql = p_cSql+"SOTTCOD,";
    p_cSql = p_cSql+"IDESITO,";
    p_cSql = p_cSql+"DESCRICOD,";
    p_cSql = p_cSql+"DESCRISCOD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esiti_age",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"PROT,";
    p_cSql = p_cSql+"INFO,";
    p_cSql = p_cSql+"NFILE,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"COD,";
    p_cSql = p_cSql+"SOTTCOD,";
    p_cSql = p_cSql+"IDESITO,";
    p_cSql = p_cSql+"DESCRICOD,";
    p_cSql = p_cSql+"DESCRISCOD,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_esiti_age",true);
    return p_cSql;
  }
}
