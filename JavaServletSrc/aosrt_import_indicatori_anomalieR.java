// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class aosrt_import_indicatori_anomalieR implements CallerWithObjs {
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
  public String gPathApp;
  public MemoryCursor_mccellaexcel_mcrdef mcCella;
  public aosmt_mod_ind_mitBO objmt;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public aosrt_import_indicatori_anomalieR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("aosrt_import_indicatori_anomalie",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "aosrt_import_indicatori_anomalie";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("mcCella",p_cVarName)) {
      return mcCella;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    if (CPLib.eqr("mcCella",p_cVarName)) {
      mcCella = (MemoryCursor_mccellaexcel_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_tab_mmc=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gPathApp Char(80) // Path Applicazione */
      /* path_file_import Char(0) := gPathApp+'/appo/anomalie.xlsx' // path del file da importare */
      String path_file_import;
      path_file_import = gPathApp+"/appo/anomalie.xlsx";
      /* n_foglio Numeric(3, 0) := 1 // n foglio corrente letto */
      double n_foglio;
      n_foglio = CPLib.Round(1,0);
      /* mcCella MemoryCursor(mcCellaExcel.MCRDef) // mc Cella excel */
      /* objExcel Object(ExcelMit) // obj per leggere il file excel */
      ExcelMit objExcel;
      objExcel = null;
      /* objmt Object(aosmt_mod_ind_mitBO) // Modello indici di anomlia mit */
      /* objmt := new aosmt_mod_ind_mitBO() // Modello indici di anomlia mit */
      objmt = new aosmt_mod_ind_mitBO(m_Ctx);
      /* objmt.Initialize() // Modello indici di anomlia mit */
      objmt.Initialize();
      // * --- Select from qbe_tab_mmc
      SPBridge.HMCaller _h0000000A;
      _h0000000A = new SPBridge.HMCaller();
      _h0000000A.Set("m_cVQRList",m_cVQRList);
      _h0000000A.Set("tbname","mod_ind_mit");
      _h0000000A.Set("fldname","IDMOD");
      _h0000000A.Set("flgmax",true);
      if (Cursor_qbe_tab_mmc!=null)
        Cursor_qbe_tab_mmc.Close();
      Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000000A,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tab_mmc.Eof())) {
        /* objmt.Set_IDMOD(Right('0000000000'+LRTrim(Str(qbe_tab_mmc->max+1,10,0)),10)) // Modello indici di anomlia mit */
        objmt.Set_IDMOD(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_tab_mmc.GetDouble("max")+1,10,0)),10));
        Cursor_qbe_tab_mmc.Next();
      }
      m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
      Cursor_qbe_tab_mmc.Close();
      // * --- End Select
      /* objmt.Set_DESCRI('Modello standard '+LRTrim(Str(Year(Date()),4,0))) // Modello indici di anomlia mit */
      objmt.Set_DESCRI("Modello standard "+CPLib.LRTrim(CPLib.Str(CPLib.Year(CPLib.Date()),4,0)));
      /* objmt.Calculate() // Modello indici di anomlia mit */
      objmt.Calculate();
      /* objmt.Check() // Modello indici di anomlia mit */
      objmt.Check();
      /* If IsNull(objmt.LastErrorMessage()) */
      if (CPLib.IsNull(objmt.LastErrorMessage())) {
        /* objmt.Save() // Modello indici di anomlia mit */
        objmt.Save();
        /* If not(Empty(path_file_import)) and IsNull(objmt.LastErrorMessage()) */
        if ( ! (CPLib.Empty(path_file_import)) && CPLib.IsNull(objmt.LastErrorMessage())) {
          /* objExcel := new ExcelMit() // obj per leggere il file excel */
          objExcel = new ExcelMit();
          /* objExcel.openWb(LRTrim(path_file_import)) */
          objExcel.openWb(CPLib.LRTrim(path_file_import));
          /* While n_foglio<objExcel.nSheets */
          while (CPLib.lt(n_foglio,objExcel.nSheets)) {
            /* objExcel.setSheet((int) n_foglio) */
            objExcel.setSheet((int) n_foglio);
            /* objExcel.readall() */
            objExcel.readall();
            /* mcCella := objExcel.getMcCelle() // mc Cella excel */
            mcCella = objExcel.getMcCelle();
            /* Exec "inserimento record" Page 2:Page_2 */
            Page_2();
            /* n_foglio := n_foglio+1 // n foglio corrente letto */
            n_foglio = CPLib.Round(n_foglio+1,0);
          } // End While
          /* objExcel.closeWb() */
          objExcel.closeWb();
        } // End If
      } // End If
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
  void Page_2() throws Exception {
    /* If not(mcCella.IsEmpty()) */
    if ( ! (mcCella.IsEmpty())) {
      /* mcCella.GoTop() // mc Cella excel */
      mcCella.GoTop();
      /* objmt.CtxLoad_aosdt_ind_mit() // Modello indici di anomlia mit */
      objmt.CtxLoad_aosdt_ind_mit();
      /* objmt.aosdt_ind_mit.Initialize() // Modello indici di anomlia mit */
      objmt.aosdt_ind_mit.Initialize();
      /* objmt.aosdt_ind_mit.AddRow() // Modello indici di anomlia mit */
      objmt.aosdt_ind_mit.AddRow();
      /* objmt.aosdt_ind_mit.Set_IDMOD(objmt.w_IDMOD) // Modello indici di anomlia mit */
      objmt.aosdt_ind_mit.Set_IDMOD(objmt.w_IDMOD);
      /* objmt.aosdt_ind_mit.Set_IDIND(LibreriaMit.UniqueId()) // Modello indici di anomlia mit */
      objmt.aosdt_ind_mit.Set_IDIND(LibreriaMit.UniqueId());
      /* objmt.aosdt_ind_mit.Set_PROGIND(Right('0000000000'+LRTrim(Left(mcCella.stringa,At('.',mcCella.stringa)-1)),10)) // Modello indici di anomlia mit */
      objmt.aosdt_ind_mit.Set_PROGIND(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Left(mcCella.row.stringa,CPLib.At(".",mcCella.row.stringa)-1)),10));
      /* objmt.aosdt_ind_mit.Set_DESCRI(LRTrim(Substr(mcCella.stringa,At('.',mcCella.stringa)+1))) // Modello indici di anomlia mit */
      objmt.aosdt_ind_mit.Set_DESCRI(CPLib.LRTrim(CPLib.Substr(mcCella.row.stringa,CPLib.At(".",mcCella.row.stringa)+1)));
      /* objmt.aosdt_ind_mit.SaveRow() // Modello indici di anomlia mit */
      objmt.aosdt_ind_mit.SaveRow();
      /* objmt.aosdt_ind_mit.Calculate() // Modello indici di anomlia mit */
      objmt.aosdt_ind_mit.Calculate();
      /* objmt.aosdt_ind_mit.Check() // Modello indici di anomlia mit */
      objmt.aosdt_ind_mit.Check();
      /* If IsNull(objmt.aosdt_ind_mit.LastErrorMessage()) */
      if (CPLib.IsNull(objmt.aosdt_ind_mit.LastErrorMessage())) {
        /* objmt.aosdt_ind_mit.Save() // Modello indici di anomlia mit */
        objmt.aosdt_ind_mit.Save();
        /* If IsNull(objmt.aosdt_ind_mit.LastErrorMessage()) */
        if (CPLib.IsNull(objmt.aosdt_ind_mit.LastErrorMessage())) {
          /* objmt.aosdt_ind_mit.CtxLoad_aosdt_sub_ind_mit() // Modello indici di anomlia mit */
          objmt.aosdt_ind_mit.CtxLoad_aosdt_sub_ind_mit();
          /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Initialize() // Modello indici di anomlia mit */
          objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Initialize();
          /* mcCella.Next() // mc Cella excel */
          mcCella.Next();
          /* While mcCella.RecNo()+1<>mcCella.RecCount() */
          while (CPLib.ne(mcCella.RecNo()+1,mcCella.RecCount())) {
            /* If mcCella.colonna=0 */
            if (CPLib.eqr(mcCella.row.colonna,0)) {
              /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.AddRow() // Modello indici di anomlia mit */
              objmt.aosdt_ind_mit.aosdt_sub_ind_mit.AddRow();
              /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_IDMOD(objmt.w_IDMOD) // Modello indici di anomlia mit */
              objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_IDMOD(objmt.w_IDMOD);
              /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_IDIND(objmt.aosdt_ind_mit.w_IDIND) // Modello indici di anomlia mit */
              objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_IDIND(objmt.aosdt_ind_mit.w_IDIND);
              /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_IDSUBIND(LibreriaMit.UniqueId()) // Modello indici di anomlia mit */
              objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_IDSUBIND(LibreriaMit.UniqueId());
              /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_PROGSUBIND(Right('0000000000'+LRTrim(Substr(mcCella.stringa,At('.',mcCella.stringa)+1,At('.',mcCella.stringa,2)-(At('.',mcCella.stringa)+1))),10)) // Modello indici di anomlia mit */
              objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_PROGSUBIND(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Substr(mcCella.row.stringa,CPLib.At(".",mcCella.row.stringa)+1,CPLib.At(".",mcCella.row.stringa,2)-(CPLib.At(".",mcCella.row.stringa)+1))),10));
              /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_DESCRI(LRTrim(Substr(mcCella.stringa,At('.',mcCella.stringa,2)+1))) // Modello indici di anomlia mit */
              objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Set_DESCRI(CPLib.LRTrim(CPLib.Substr(mcCella.row.stringa,CPLib.At(".",mcCella.row.stringa,2)+1)));
              /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.SaveRow() // Modello indici di anomlia mit */
              objmt.aosdt_ind_mit.aosdt_sub_ind_mit.SaveRow();
            } // End If
            /* mcCella.Next() // mc Cella excel */
            mcCella.Next();
          } // End While
          /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Calculate() // Modello indici di anomlia mit */
          objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Calculate();
          /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Check() // Modello indici di anomlia mit */
          objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Check();
          /* If IsNull(objmt.aosdt_ind_mit.aosdt_sub_ind_mit.LastErrorMessage()) */
          if (CPLib.IsNull(objmt.aosdt_ind_mit.aosdt_sub_ind_mit.LastErrorMessage())) {
            /* objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Save() // Modello indici di anomlia mit */
            objmt.aosdt_ind_mit.aosdt_sub_ind_mit.Save();
          } // End If
        } // End If
      } // End If
    } // End If
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static aosrt_import_indicatori_anomalieR Make(CPContext p_Ctx, Caller p_Caller) {
    return new aosrt_import_indicatori_anomalieR(p_Ctx, p_Caller);
  }
  public void Blank() {
    mcCella = new MemoryCursor_mccellaexcel_mcrdef();
    objmt = null;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc,
  public static final String m_cVQRList = ",qbe_tab_mmc,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
}
