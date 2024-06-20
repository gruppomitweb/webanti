// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_wu_correggi_cliR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_tbluonas;
  public String m_cServer_tbluonas;
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
  public String pNomeFile;
  public String gAzienda;
  public String gPathApp;
  public String gMsgImp;
  public String gMsgProc;
  public String fhand;
  public String _trxdate;
  public String _codstanas;
  public String _nascitta;
  public String _nasstato;
  public String _nasprov;
  public String _luonas;
  public String riga;
  public double conta;
  public String cRitorno;
  public String w_CODFISC;
  public java.sql.Date w_DATANASC;
  public String w_NASCOMUN;
  public String w_NASSTATO;
  public String w_COGNOME;
  public String w_NOME;
  public String w_RAGSOC;
  public String w_SESSO;
  public String xConnes;
  public MemoryCursor_mcerratedef_mcrdef mcNuove;
  public MemoryCursor_tbluonas mcStatiN;
  public MemoryCursor_decodenascita mcDecodeNascita;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_wu_correggi_cliR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wu_correggi_cli",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_tbluonas = p_ContextObject.GetPhName("tbluonas");
    if (m_cPhName_tbluonas.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbluonas = m_cPhName_tbluonas+" "+m_Ctx.GetWritePhName("tbluonas");
    }
    m_cServer_tbluonas = p_ContextObject.GetServer("tbluonas");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wu_correggi_cli";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNomeFile",p_cVarName)) {
      return pNomeFile;
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
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_trxdate",p_cVarName)) {
      return _trxdate;
    }
    if (CPLib.eqr("_codstanas",p_cVarName)) {
      return _codstanas;
    }
    if (CPLib.eqr("_nascitta",p_cVarName)) {
      return _nascitta;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      return _nasstato;
    }
    if (CPLib.eqr("_nasprov",p_cVarName)) {
      return _nasprov;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
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
    if (CPLib.eqr("NOME",p_cVarName)) {
      return w_NOME;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      return w_RAGSOC;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      return w_SESSO;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      return w_DATANASC;
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
    if (CPLib.eqr("mcNuove",p_cVarName)) {
      return mcNuove;
    }
    if (CPLib.eqr("mcStatiN",p_cVarName)) {
      return mcStatiN;
    }
    if (CPLib.eqr("mcDecodeNascita",p_cVarName)) {
      return mcDecodeNascita;
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
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pNomeFile",p_cVarName)) {
      pNomeFile = value;
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
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_trxdate",p_cVarName)) {
      _trxdate = value;
      return;
    }
    if (CPLib.eqr("_codstanas",p_cVarName)) {
      _codstanas = value;
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
    if (CPLib.eqr("_nasprov",p_cVarName)) {
      _nasprov = value;
      return;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
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
    if (CPLib.eqr("NOME",p_cVarName)) {
      w_NOME = value;
      return;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      w_RAGSOC = value;
      return;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      w_SESSO = value;
      return;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      w_DATANASC = value;
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
    if (CPLib.eqr("mcNuove",p_cVarName)) {
      mcNuove = (MemoryCursor_mcerratedef_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcStatiN",p_cVarName)) {
      mcStatiN = (MemoryCursor_tbluonas)value;
      return;
    }
    if (CPLib.eqr("mcDecodeNascita",p_cVarName)) {
      mcDecodeNascita = (MemoryCursor_decodenascita)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbluonas=null;
    CPResultSet Cursor_qbe_decodenascita_full=null;
    CPResultSet Cursor_qbe_wu_correggi_cli=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pNomeFile Char(80) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* fhand Char(10) */
      /* _trxdate Char(8) */
      /* _codstanas Char(3) */
      /* _nascitta Char(30) */
      /* _nasstato Char(30) */
      /* _nasprov Char(2) */
      /* _luonas Char(50) */
      /* riga Memo */
      /* conta Numeric(10, 0) */
      /* cRitorno Char(2) */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_DATANASC Date // Data Nascita */
      /* w_NASCOMUN Char(30) // Luogo di Nascita */
      /* w_NASSTATO Char(30) // Stato di nascita */
      /* w_COGNOME Char(26) // Cognome */
      /* w_NOME Char(25) // Nome */
      /* w_RAGSOC Char(70) // Ragione Sociale */
      /* w_SESSO Char(1) // Sesso */
      /* xConnes Char(16) */
      /* mcNuove MemoryCursor(mcErrateDef.MCRDef) // Nuove transazioni */
      /* mcStatiN MemoryCursor(tbluonas) // Luoghi di nascita */
      /* mcDecodeNascita MemoryCursor(DecodeNascita) // Trascodifica luoghi di nascita */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + LRTrim(pNomeFile) + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+CPLib.LRTrim(pNomeFile)+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(pNomeFile)) */
      fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pNomeFile));
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 and Left(riga,1) <> '#' */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0) && CPLib.ne(CPLib.Left(riga,1),"#")) {
          /* If Substr(riga,849,1)='I' */
          if (CPLib.eqr(CPLib.Substr(riga,849,1),"I")) {
            /* mcNuove.AppendWithKey(Substr(riga,826,10)) */
            mcNuove.AppendWithKey(CPLib.Substr(riga,826,10));
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
          } // End If
        } // End If
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
      } // End While
      // Chiude il file
      FileLibMit.Close(fhand);
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
                info.log("Routine arrt_wu_correggi_cli: query on tbluonas returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
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
                info.log("Routine arrt_wu_correggi_cli: query on qbe_decodenascita_full returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 50000");
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
      /* _trxdate := Substr(pNomeFile,8,8) */
      _trxdate = CPLib.Substr(pNomeFile,8,8);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000057status;
      nTry00000057status = m_Sql.GetTransactionStatus();
      String cTry00000057msg;
      cTry00000057msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from qbe_wu_correggi_cli
        SPBridge.HMCaller _h00000058;
        _h00000058 = new SPBridge.HMCaller();
        _h00000058.Set("m_cVQRList",m_cVQRList);
        _h00000058.Set("pDATAOPE",_trxdate);
        if (Cursor_qbe_wu_correggi_cli!=null)
          Cursor_qbe_wu_correggi_cli.Close();
        Cursor_qbe_wu_correggi_cli = new VQRHolder("qbe_wu_correggi_cli",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000058,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_wu_correggi_cli.Eof())) {
          /* w_CODFISC := '' // Codice Fiscale */
          w_CODFISC = "";
          /* w_DATANASC := NullDate() // Data Nascita */
          w_DATANASC = CPLib.NullDate();
          /* w_NASCOMUN := '' // Luogo di Nascita */
          w_NASCOMUN = "";
          /* w_NASSTATO := '' // Stato di nascita */
          w_NASSTATO = "";
          /* w_COGNOME := '' // Cognome */
          w_COGNOME = "";
          /* w_NOME := '' // Nome */
          w_NOME = "";
          /* w_RAGSOC := '' // Ragione Sociale */
          w_RAGSOC = "";
          /* w_SESSO := '' // Sesso */
          w_SESSO = "";
          /* If mcNuove.GoToKey(qbe_wu_correggi_cli->MTCN) */
          if (mcNuove.GoToKey(Cursor_qbe_wu_correggi_cli.GetString("MTCN"))) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* _nasprov := '' */
            _nasprov = "";
            /* _nasstato := '' */
            _nasstato = "";
            /* _nascitta := '' */
            _nascitta = "";
            /* If not(Empty(Left(LRTrim(mcNuove.colonna06),50))) */
            if ( ! (CPLib.Empty(CPLib.Left(CPLib.LRTrim(mcNuove.row.colonna06),50)))) {
              /* _codstanas := '' */
              _codstanas = "";
              /* _luonas := LRTrim(Left(LRTrim(mcNuove.colonna06),50)) */
              _luonas = CPLib.LRTrim(CPLib.Left(CPLib.LRTrim(mcNuove.row.colonna06),50));
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
              } else { // Else
                /* _luonas := iif(Empty(_nasstato),LRTrim(_nascitta),LRTrim(_nasstato)) */
                _luonas = (CPLib.Empty(_nasstato)?CPLib.LRTrim(_nascitta):CPLib.LRTrim(_nasstato));
              } // End If
            } // End If
            /* w_CODFISC := '' // Codice Fiscale */
            w_CODFISC = "";
            /* w_DATANASC := CharToDate(Left(LRTrim(mcNuove.colonna25),8)) // Data Nascita */
            w_DATANASC = CPLib.CharToDate(CPLib.Left(CPLib.LRTrim(mcNuove.row.colonna25),8));
            /* w_NASCOMUN := _nascitta // Luogo di Nascita */
            w_NASCOMUN = _nascitta;
            /* w_NASSTATO := _nasstato // Stato di nascita */
            w_NASSTATO = _nasstato;
            /* w_COGNOME := LRTrim(mcNuove.colonna01) // Cognome */
            w_COGNOME = CPLib.LRTrim(mcNuove.row.colonna01);
            /* w_NOME := LRTrim(mcNuove.colonna02) // Nome */
            w_NOME = CPLib.LRTrim(mcNuove.row.colonna02);
            /* w_RAGSOC := LRTrim(w_COGNOME)+" "+LRTrim(w_NOME) // Ragione Sociale */
            w_RAGSOC = CPLib.LRTrim(w_COGNOME)+" "+CPLib.LRTrim(w_NOME);
            /* w_SESSO := iif(Left(LRTrim(mcNuove.colonna26),1)='M','1',iif(Left(LRTrim(mcNuove.colonna26),1)='F','2','')) // Sesso */
            w_SESSO = (CPLib.eqr(CPLib.Left(CPLib.LRTrim(mcNuove.row.colonna26),1),"M")?"1":(CPLib.eqr(CPLib.Left(CPLib.LRTrim(mcNuove.row.colonna26),1),"F")?"2":""));
            /* Exec Routine arrt_calccodfis_wu */
            arrt_calccodfis_wuR.Make(m_Ctx,this).Run();
            /* xConnes := w_CODFISC */
            xConnes = w_CODFISC;
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_correggi_cli",6,"00000088")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(xConnes,"C",16,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_wu_correggi_cli.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_wu_correggi_cli.GetString("IDBASE"))+"";
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
            /* gMsgImp := "Sto aggiornando l'operazione con MTCN: "+qbe_wu_correggi_cli->MTCN */
            gMsgImp = "Sto aggiornando l'operazione con MTCN: "+Cursor_qbe_wu_correggi_cli.GetString("MTCN");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          Cursor_qbe_wu_correggi_cli.Next();
        }
        m_cConnectivityError = Cursor_qbe_wu_correggi_cli.ErrorMessage();
        Cursor_qbe_wu_correggi_cli.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* cRitorno := 'OK' */
        cRitorno = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* cRitorno := 'KO' */
        cRitorno = "KO";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000057status,0)) {
          m_Sql.SetTransactionStatus(nTry00000057status,cTry00000057msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Sono state aggiornate '+LRTrim(Str(conta,10,0))+' operazioni.' + NL */
      gMsgProc = gMsgProc+"Sono state aggiornate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" operazioni."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + LRTrim(pNomeFile) */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+CPLib.LRTrim(pNomeFile);
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_tbluonas!=null)
          Cursor_tbluonas.Close();
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
        if (Cursor_qbe_wu_correggi_cli!=null)
          Cursor_qbe_wu_correggi_cli.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pNomeFile) {
    pNomeFile = p_pNomeFile;
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
  public String Run(String p_pNomeFile) {
    pNomeFile = p_pNomeFile;
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
  public static arrt_wu_correggi_cliR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wu_correggi_cliR(p_Ctx, p_Caller);
  }
  public static arrt_wu_correggi_cliR Make(CPContext p_Ctx) {
    return new arrt_wu_correggi_cliR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pNomeFile = CPLib.Space(80);
    fhand = CPLib.Space(10);
    _trxdate = CPLib.Space(8);
    _codstanas = CPLib.Space(3);
    _nascitta = CPLib.Space(30);
    _nasstato = CPLib.Space(30);
    _nasprov = CPLib.Space(2);
    _luonas = CPLib.Space(50);
    riga = "";
    conta = 0;
    cRitorno = CPLib.Space(2);
    w_CODFISC = CPLib.Space(16);
    w_DATANASC = CPLib.NullDate();
    w_NASCOMUN = CPLib.Space(30);
    w_NASSTATO = CPLib.Space(30);
    w_COGNOME = CPLib.Space(26);
    w_NOME = CPLib.Space(25);
    w_RAGSOC = CPLib.Space(70);
    w_SESSO = CPLib.Space(1);
    xConnes = CPLib.Space(16);
    mcNuove = new MemoryCursor_mcerratedef_mcrdef();
    mcStatiN = new MemoryCursor_tbluonas();
    mcDecodeNascita = new MemoryCursor_decodenascita();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_decodenascita_full,qbe_wu_correggi_cli,
  public static final String m_cVQRList = ",qbe_decodenascita_full,qbe_wu_correggi_cli,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_calccodfis_wu,arrt_wu_correggi_cli,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_calccodfis_wu,arrt_wu_correggi_cli,";
  public static String[] m_cRunParameterNames={"pNomeFile"};
}
