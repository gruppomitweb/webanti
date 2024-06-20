// * --- Area Manuale = BO - Header
// * --- arrt_chg_connes_xls
import java.io.File; 
import java.lang.Double;
import jxl.*;
// * --- Fine Area Manuale
public class arrt_chg_connes_xlsR implements CallerWithObjs {
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
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public String w_nomefile;
  public String _codfisc;
  public String _connes_old;
  public String _connes_new;
  public double _inviato;
  public double _annullato;
  public String _esito;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public String column05;
  public String gAzienda;
  public String gPathApp;
  public String gMsgImp;
  public String gMsgProc;
  public String gFlgWU;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_chg_connes_xls
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_chg_connes_xlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_chg_connes_xls",m_Caller);
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
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_inviato",p_cVarName)) {
      return _inviato;
    }
    if (CPLib.eqr("_annullato",p_cVarName)) {
      return _annullato;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_chg_connes_xls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_connes_old",p_cVarName)) {
      return _connes_old;
    }
    if (CPLib.eqr("_connes_new",p_cVarName)) {
      return _connes_new;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
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
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_inviato",p_cVarName)) {
      _inviato = value;
      return;
    }
    if (CPLib.eqr("_annullato",p_cVarName)) {
      _annullato = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_connes_old",p_cVarName)) {
      _connes_old = value;
      return;
    }
    if (CPLib.eqr("_connes_new",p_cVarName)) {
      _connes_new = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
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
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
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
    CPResultSet Cursor_personbo=null;
    try {
      /* w_nomefile Char(80) // nome file da importare */
      /* _codfisc Char(16) */
      /* _connes_old Char(16) */
      /* _connes_new Char(16) */
      /* _inviato Numeric(1, 0) */
      /* _annullato Numeric(1, 0) */
      /* _esito Char(2) */
      /* column01 Char(25) */
      /* column02 Char(25) */
      /* column03 Char(25) // codice fiscale */
      /* column04 Char(25) // oldcon */
      /* column05 Char(25) //  newcon */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gFlgWU Char(1) // Gestione WU */
      /* gMsgProc := 'Ora Inizio Aggiornamento: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Aggiornamento: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If FileLibMit.ExistFile(LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile)) */
      if (FileLibMit.ExistFile(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile))) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000019status;
        nTry00000019status = m_Sql.GetTransactionStatus();
        String cTry00000019msg;
        cTry00000019msg = m_Sql.TransactionErrorMessage();
        try {
          //base
          Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile)));
          conta = workbook.getNumberOfSheets();
          /* _i = 0 */
          CPLib.eqr(_i,0);
          /* While _i < conta */
          while (CPLib.lt(_i,conta)) {
            _righe = 0;
            Sheet sheet = workbook.getSheet(_i);
            _righe = sheet.getRows();
            _y = 2;
            /* While _y <_righe */
            while (CPLib.lt(_y,_righe)) {
              // Leggo le celle
              Cell a01 = sheet.getCell(0,_y);
              Cell a02 = sheet.getCell(1,_y);
              Cell a03 = sheet.getCell(2,_y);
              Cell a04 = sheet.getCell(3,_y);
              Cell a05 = sheet.getCell(4,_y);
              /* column01 := Upper(a01.getContents()) */
              column01 = CPLib.Upper(a01.getContents());
              /* column02 := Upper(a02.getContents()) */
              column02 = CPLib.Upper(a02.getContents());
              /* column03 := Upper(a03.getContents()) */
              column03 = CPLib.Upper(a03.getContents());
              /* column04 := Upper(a04.getContents()) */
              column04 = CPLib.Upper(a04.getContents());
              /* column05 := Upper(a05.getContents()) */
              column05 = CPLib.Upper(a05.getContents());
              /* If not(Empty(LRTrim(column04))) and not(Empty(LRTrim(column05))) */
              if ( ! (CPLib.Empty(CPLib.LRTrim(column04))) &&  ! (CPLib.Empty(CPLib.LRTrim(column05)))) {
                /* _codfisc := Left(LRTrim(column03),16) */
                _codfisc = CPLib.Left(CPLib.LRTrim(column03),16);
                /* _connes_old := Left(LRTrim(column04),16) */
                _connes_old = CPLib.Left(CPLib.LRTrim(column04),16);
                /* _connes_new := Left(LRTrim(column05),16) */
                _connes_new = CPLib.Left(CPLib.LRTrim(column05),16);
                /* gMsgImp := 'Sto aggiornando i dati del soggetto con NDG: ' + LRTrim(_connes_old) // Messaggio Import */
                gMsgImp = "Sto aggiornando i dati del soggetto con NDG: "+CPLib.LRTrim(_connes_old);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* gMsgProc := gMsgProc + 'Sto aggiornando i dati del soggetto con NDG: ' + LRTrim(_connes_old) + NL // Messaggio */
                gMsgProc = gMsgProc+"Sto aggiornando i dati del soggetto con NDG: "+CPLib.LRTrim(_connes_old)+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes_old,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes_old)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* Se il CF indicato nel file excel differisce da quello indicato in personbo viene stampata la notica, l'aggiornamento del connes avviene comunque! */
                  /* If personbo->CODFISC<>_codfisc */
                  if (CPLib.ne(Cursor_personbo.GetString("CODFISC"),_codfisc)) {
                    /* gMsgProc := gMsgProc + ' NOTA: CF in anagrafica diverso dal CF nel file di aggiornamento - connes_new:' + LRTrim(_connes_new) + NL // Messaggio */
                    gMsgProc = gMsgProc+" NOTA: CF in anagrafica diverso dal CF nel file di aggiornamento - connes_new:"+CPLib.LRTrim(_connes_new)+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  } // End If
                  /* _esito := '' */
                  _esito = "";
                  /* _esito=arrt_chg_connes(_connes_old, _connes_new) */
                  CPLib.eqr(_esito,arrt_chg_connesR.Make(m_Ctx,this).Run(_connes_old,_connes_new));
                  /* If _esito='KO' */
                  if (CPLib.eqr(_esito,"KO")) {
                    /* gMsgProc := gMsgProc + ' NOTA: Aggiornamento FALLITO - connes_new:' + LRTrim(_connes_new) + NL // Messaggio */
                    gMsgProc = gMsgProc+" NOTA: Aggiornamento FALLITO - connes_new:"+CPLib.LRTrim(_connes_new)+"\n";
                    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                  } // End If
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              _y++;
            } // End While
            _i++;
          } // End While
          /* workbook.close() */
          workbook.close();
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* gMsgImp := 'Elaborazione Terminata con successo!' // Messaggio Import */
          gMsgImp = "Elaborazione Terminata con successo!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* Error Msg 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
          m_cLastMsgError = "Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
          new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
          /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL // Messaggio */
          gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* gMsgImp := 'Elaborazione Abortita per presenza di errori!' // Messaggio Import */
          gMsgImp = "Elaborazione Abortita per presenza di errori!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000019status,0)) {
            m_Sql.SetTransactionStatus(nTry00000019status,cTry00000019msg);
          }
        }
        // Chiude il file excel e lo cancella
        //workbook.close();
        FileLibMit.DeleteFilePath(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile));
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Import: '+ arfn_fdatetime(DateTime()) + ' del file ' + w_nomefile + NL */
      gMsgProc = gMsgProc+"Ora Fine Import: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+w_nomefile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
  void _init_() {
  }
  public String RunAsync(String p_w_nomefile) {
    w_nomefile = p_w_nomefile;
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
  public String Run(String p_w_nomefile) {
    w_nomefile = p_w_nomefile;
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
  public static arrt_chg_connes_xlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_chg_connes_xlsR(p_Ctx, p_Caller);
  }
  public static arrt_chg_connes_xlsR Make(CPContext p_Ctx) {
    return new arrt_chg_connes_xlsR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_nomefile = CPLib.Space(80);
    _codfisc = CPLib.Space(16);
    _connes_old = CPLib.Space(16);
    _connes_new = CPLib.Space(16);
    _inviato = 0;
    _annullato = 0;
    _esito = CPLib.Space(2);
    column01 = CPLib.Space(25);
    column02 = CPLib.Space(25);
    column03 = CPLib.Space(25);
    column04 = CPLib.Space(25);
    column05 = CPLib.Space(25);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_chg_connes,arrt_chg_connes_xls,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_chg_connes,arrt_chg_connes_xls,";
  public static String[] m_cRunParameterNames={"w_nomefile"};
}
