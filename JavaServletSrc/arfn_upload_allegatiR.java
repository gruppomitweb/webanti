// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_upload_allegatiR implements CallerWithObjs {
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
  public String pDirDest;
  public String pFileTmp;
  public String gPathApp;
  public String gAzienda;
  public String gCodDip;
  public String ritorno;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_upload_allegatiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_upload_allegati",m_Caller);
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
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
      return "arfn_upload_allegati";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNomeFile",p_cVarName)) {
      return pNomeFile;
    }
    if (CPLib.eqr("pDirDest",p_cVarName)) {
      return pDirDest;
    }
    if (CPLib.eqr("pFileTmp",p_cVarName)) {
      return pFileTmp;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    if (CPLib.eqr("ritorno",p_cVarName)) {
      return ritorno;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pNomeFile",p_cVarName)) {
      pNomeFile = value;
      return;
    }
    if (CPLib.eqr("pDirDest",p_cVarName)) {
      pDirDest = value;
      return;
    }
    if (CPLib.eqr("pFileTmp",p_cVarName)) {
      pFileTmp = value;
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
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
    if (CPLib.eqr("ritorno",p_cVarName)) {
      ritorno = value;
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
    /* pNomeFile Char(80) // Nome file da copiare */
    /* pDirDest Char(80) // Directory Destinazione */
    /* pFileTmp Char(1) // Inserire in tabella temporanea lista */
    /* gPathApp Char(80) // Path Applicazione */
    /* gAzienda Char(10) // Azienda */
    /* gCodDip Char(6) // Dipendenza */
    /* ritorno Memo */
    /* If FileLibMit.ExistFile(gPathApp+'/WEB-INF/Tmp/'+LRTrim(pNomeFile)) */
    if (FileLibMit.ExistFile(gPathApp+"/WEB-INF/Tmp/"+CPLib.LRTrim(pNomeFile))) {
      /* If FileLibMit.FileCopy(gPathApp+'/WEB-INF/Tmp/'+LRTrim(pNomeFile), gPathApp+'/'+LRTrim(pDirDest)+'/'+LRTrim(gCodDip)+'/'+LRTrim(pNomeFile)) */
      if (FileLibMit.FileCopy(gPathApp+"/WEB-INF/Tmp/"+CPLib.LRTrim(pNomeFile),gPathApp+"/"+CPLib.LRTrim(pDirDest)+"/"+CPLib.LRTrim(gCodDip)+"/"+CPLib.LRTrim(pNomeFile))) {
        /* If FileLibMit.ExistFile(gPathApp+'/'+LRTrim(pDirDest)+'/'+LRTrim(gCodDip)+'/'+LRTrim(pNomeFile)) */
        if (FileLibMit.ExistFile(gPathApp+"/"+CPLib.LRTrim(pDirDest)+"/"+CPLib.LRTrim(gCodDip)+"/"+CPLib.LRTrim(pNomeFile))) {
          /* If FileLibMit.DeleteFile('/WEB-INF/Tmp/'+LRTrim(pNomeFile)) */
          if (FileLibMit.DeleteFile("/WEB-INF/Tmp/"+CPLib.LRTrim(pNomeFile))) {
            /* ritorno := 'OK' // ritorno della funzione */
            ritorno = "OK";
            /* If pFileTmp='S' */
            if (CPLib.eqr(pFileTmp,"S")) {
              // * --- Insert into tmp_list_imprich from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_list_imprich");
              m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_upload_allegati",6,"00000011")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000011(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(pNomeFile),"?",0,0,m_cServer)+", ";
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
          } else { // Else
            /* ritorno := 'File non cancellato nella cartella temporanea in : '+Chr(10)+Chr(13)+gPathApp+'/WEB-INF/Tmp/'+LRTrim(pNomeFile) // ritorno della funzione */
            ritorno = "File non cancellato nella cartella temporanea in : "+CPLib.Chr(10)+CPLib.Chr(13)+gPathApp+"/WEB-INF/Tmp/"+CPLib.LRTrim(pNomeFile);
          } // End If
        } else { // Else
          /* ritorno := 'File non trovato nella cartella definitiva in : '+Chr(10)+Chr(13)+gPathApp+'/'+LRTrim(pDirDest)+'/'+LRTrim(gCodDip)+'/'+LRTrim(pNomeFile) // ritorno della funzione */
          ritorno = "File non trovato nella cartella definitiva in : "+CPLib.Chr(10)+CPLib.Chr(13)+gPathApp+"/"+CPLib.LRTrim(pDirDest)+"/"+CPLib.LRTrim(gCodDip)+"/"+CPLib.LRTrim(pNomeFile);
        } // End If
      } else { // Else
        /* ritorno := 'Impossibile effettuare il trasferimento nella cartella definitiva da: '+Chr(10)+Chr(13)+gPathApp+'/WEB-INF/Tmp/'+LRTrim(pNomeFile) // ritorno della funzione */
        ritorno = "Impossibile effettuare il trasferimento nella cartella definitiva da: "+CPLib.Chr(10)+CPLib.Chr(13)+gPathApp+"/WEB-INF/Tmp/"+CPLib.LRTrim(pNomeFile);
      } // End If
    } else { // Else
      /* ritorno := 'File non trovato nella cartella temporanea in : '+Chr(10)+Chr(13)+gPathApp+'/WEB-INF/Tmp/'+LRTrim(pNomeFile) // ritorno della funzione */
      ritorno = "File non trovato nella cartella temporanea in : "+CPLib.Chr(10)+CPLib.Chr(13)+gPathApp+"/WEB-INF/Tmp/"+CPLib.LRTrim(pNomeFile);
    } // End If
    /* Return ritorno */
    throw new Stop(ritorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pNomeFile,String p_pDirDest,String p_pFileTmp) {
    pNomeFile = p_pNomeFile;
    pDirDest = p_pDirDest;
    pFileTmp = p_pFileTmp;
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
  public String Run(String p_pNomeFile,String p_pDirDest,String p_pFileTmp) {
    pNomeFile = p_pNomeFile;
    pDirDest = p_pDirDest;
    pFileTmp = p_pFileTmp;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_upload_allegatiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_upload_allegatiR(p_Ctx, p_Caller);
  }
  public static arfn_upload_allegatiR Make(CPContext p_Ctx) {
    return new arfn_upload_allegatiR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pNomeFile = CPLib.Space(80);
    pDirDest = CPLib.Space(80);
    pFileTmp = CPLib.Space(1);
    ritorno = "";
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_upload_allegati,
  public static final String i_InvokedRoutines = ",arfn_upload_allegati,";
  public static String[] m_cRunParameterNames={"pNomeFile","pDirDest","pFileTmp"};
  protected static String GetFieldsName_00000011(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
}
