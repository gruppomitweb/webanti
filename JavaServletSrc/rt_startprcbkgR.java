// * --- Area Manuale = BO - Header
// * --- rt_startprcbkg
import it.sauronsoftware.cron4j.SchedulingPattern;
import java.lang.reflect.*;
// * --- Fine Area Manuale
public class rt_startprcbkgR implements CallerWithObjs {
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
  public String m_cPhName_tbprcbck;
  public String m_cServer_tbprcbck;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_cpazi_add;
  public String m_cServer_cpazi_add;
  public String m_cPhName_tbprcbck_param;
  public String m_cServer_tbprcbck_param;
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
  public String gAzienda;
  public String gAppName;
  public String gTipInter;
  public String gTipDB;
  public String gNAzienda;
  public String gDBCli;
  public String gPathDoc;
  public boolean gAOS;
  public boolean gTER;
  public boolean gSOS;
  public double PBCODICE;
  public String routine;
  public String _valore;
  public MemoryCursor_tbprcbck_param mcParam;
  // * --- Area Manuale = BO - Properties
  // * --- rt_startprcbkg
  public int _i,_j;
  public Class[] cArg;
  public Object[] cValue;
  // * --- Fine Area Manuale
  public rt_startprcbkgR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("rt_startprcbkg",m_Caller);
    m_cPhName_tbprcbck = p_ContextObject.GetPhName("tbprcbck");
    if (m_cPhName_tbprcbck.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbprcbck = m_cPhName_tbprcbck+" "+m_Ctx.GetWritePhName("tbprcbck");
    }
    m_cServer_tbprcbck = p_ContextObject.GetServer("tbprcbck");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_cpazi_add = p_ContextObject.GetPhName("cpazi_add");
    if (m_cPhName_cpazi_add.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi_add = m_cPhName_cpazi_add+" "+m_Ctx.GetWritePhName("cpazi_add");
    }
    m_cServer_cpazi_add = p_ContextObject.GetServer("cpazi_add");
    m_cPhName_tbprcbck_param = p_ContextObject.GetPhName("tbprcbck_param");
    if (m_cPhName_tbprcbck_param.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbprcbck_param = m_cPhName_tbprcbck_param+" "+m_Ctx.GetWritePhName("tbprcbck_param");
    }
    m_cServer_tbprcbck_param = p_ContextObject.GetServer("tbprcbck_param");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("PBCODICE",p_cVarName)) {
      return PBCODICE;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "rt_startprcbkg";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gAppName",p_cVarName)) {
      return gAppName;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gTipDB",p_cVarName)) {
      return gTipDB;
    }
    if (CPLib.eqr("gNAzienda",p_cVarName)) {
      return gNAzienda;
    }
    if (CPLib.eqr("gDBCli",p_cVarName)) {
      return gDBCli;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("routine",p_cVarName)) {
      return routine;
    }
    if (CPLib.eqr("_valore",p_cVarName)) {
      return _valore;
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
    if (CPLib.eqr("gAOS",p_cVarName)) {
      return gAOS;
    }
    if (CPLib.eqr("gTER",p_cVarName)) {
      return gTER;
    }
    if (CPLib.eqr("gSOS",p_cVarName)) {
      return gSOS;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcParam",p_cVarName)) {
      return mcParam;
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
    if (CPLib.eqr("PBCODICE",p_cVarName)) {
      PBCODICE = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gAppName",p_cVarName)) {
      gAppName = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("gTipDB",p_cVarName)) {
      gTipDB = value;
      return;
    }
    if (CPLib.eqr("gNAzienda",p_cVarName)) {
      gNAzienda = value;
      return;
    }
    if (CPLib.eqr("gDBCli",p_cVarName)) {
      gDBCli = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("routine",p_cVarName)) {
      routine = value;
      return;
    }
    if (CPLib.eqr("_valore",p_cVarName)) {
      _valore = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("gAOS",p_cVarName)) {
      gAOS = value;
      return;
    }
    if (CPLib.eqr("gTER",p_cVarName)) {
      gTER = value;
      return;
    }
    if (CPLib.eqr("gSOS",p_cVarName)) {
      gSOS = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcParam",p_cVarName)) {
      mcParam = (MemoryCursor_tbprcbck_param)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_tbprcbck=null;
    CPResultSet Cursor_tbprcbck_param=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gAzienda Char(60) // Codice Azienda */
      /* gAppName Char(4) // Applicazione Riferimento */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gTipDB Char(1) // DBFOX */
      /* gNAzienda Char(3) // Numero dell azienda da verificare */
      /* gDBCli Char(10) // DB presso il cliente */
      /* gPathDoc Char(200) // Path dei doc esterni */
      /* gAOS Bool // AOS Attivo */
      /* gTER Bool // TER Attivo */
      /* gSOS Bool // SOS Attivo */
      /* now DateTime := DateTime() // ora */
      java.sql.Timestamp now;
      now = CPLib.DateTime();
      /* _find Bool := False // verifica se ci sono processi da lanciare (conteggio>0) */
      boolean _find;
      _find = false;
      /* _primo Bool := True // verifica se ci sono processi da lanciare (conteggio>0) */
      boolean _primo;
      _primo = true;
      /* PBCODICE Numeric(0, 0) // id funzione asincrona */
      /* pattern Char(0) := NullString() // pattern di esecuzione */
      String pattern;
      pattern = CPLib.NullString();
      /* mypattern Object(SchedulingPattern) // Oggetto per verifica del pattern */
      SchedulingPattern mypattern;
      mypattern = null;
      /* routine Char(0) := NullString() // id funzione asincrona */
      routine = CPLib.NullString();
      /* _valore Char(0) := NullString() */
      _valore = CPLib.NullString();
      /* mcParam MemoryCursor(tbprcbck_param) */
      double nTry00000017status;
      nTry00000017status = m_Sql.GetTransactionStatus();
      String cTry00000017msg;
      cTry00000017msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from cpazi
        m_cServer = m_Ctx.GetServer("cpazi");
        m_cPhName = m_Ctx.GetPhName("cpazi");
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
        Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select codazi  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cpazi.Eof())) {
          /* Utilities.SetCompany(cpazi->codazi) */
          Utilities.Make(m_Ctx,m_Caller).SetCompany(Cursor_cpazi.GetString("codazi"));
          /* _primo := True // verifica se ci sono processi da lanciare (conteggio>0) */
          _primo = true;
          // * --- Select from qbe_tab_mmc
          SPBridge.HMCaller _h0000001B;
          _h0000001B = new SPBridge.HMCaller();
          _h0000001B.Set("m_cVQRList",m_cVQRList);
          _h0000001B.Set("tbname","tbprcbck");
          _h0000001B.Set("fldname","PBCODICE");
          _h0000001B.Set("flgmin",false);
          _h0000001B.Set("flgmax",false);
          _h0000001B.Set("flgcount",true);
          if (Cursor_qbe_tab_mmc!=null)
            Cursor_qbe_tab_mmc.Close();
          Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001B,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_tab_mmc.Eof())) {
            /* _find := qbe_tab_mmc->tot>0 // verifica se ci sono processi da lanciare (conteggio>0) */
            _find = CPLib.gt(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
            Cursor_qbe_tab_mmc.Next();
          }
          m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
          Cursor_qbe_tab_mmc.Close();
          // * --- End Select
          /* If _find */
          if (_find) {
            // * --- Select from tbprcbck
            m_cServer = m_Ctx.GetServer("tbprcbck");
            m_cPhName = m_Ctx.GetPhName("tbprcbck");
            if (Cursor_tbprcbck!=null)
              Cursor_tbprcbck.Close();
            Cursor_tbprcbck = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PBATTIVO='S' "+")"+(m_Ctx.IsSharedTemp("tbprcbck")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tbprcbck.Eof())) {
              /* PBCODICE := tbprcbck->PBCODICE // id funzione asincrona */
              PBCODICE = CPLib.Round(Cursor_tbprcbck.GetDouble("PBCODICE"),0);
              /* pattern := tbprcbck->PBTIMEXP // pattern di esecuzione */
              pattern = Cursor_tbprcbck.GetString("PBTIMEXP");
              /* routine := tbprcbck->PBROUTINE // id funzione asincrona */
              routine = Cursor_tbprcbck.GetString("PBROUTINE");
              /* mypattern := new SchedulingPattern(pattern) // Oggetto per verifica del pattern */
              mypattern = new SchedulingPattern(pattern);
              // * --- Fill memory cursor mcParam on tbprcbck_param
              mcParam.Zap();
              m_cServer = m_Ctx.GetServer("tbprcbck_param");
              m_cPhName = m_Ctx.GetPhName("tbprcbck_param");
              if (Cursor_tbprcbck_param!=null)
                Cursor_tbprcbck_param.Close();
              Cursor_tbprcbck_param = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PPCODICE="+CPLib.ToSQL(Cursor_tbprcbck.GetDouble("PBCODICE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tbprcbck_param")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              {
                final CPResultSet m_TheCursor = Cursor_tbprcbck_param;
                Cursor_tbprcbck_param.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine rt_startprcbkg: query on tbprcbck_param returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_tbprcbck_param.Eof())) {
                mcParam.AppendBlank();
                mcParam.row.PPCODICE = Cursor_tbprcbck_param.GetDouble("PPCODICE");
                mcParam.row.CPROWNUM = Cursor_tbprcbck_param.GetDouble("CPROWNUM");
                mcParam.row.PPDESCRI = Cursor_tbprcbck_param.GetString("PPDESCRI");
                mcParam.row.PPTIPPAR = Cursor_tbprcbck_param.GetString("PPTIPPAR");
                mcParam.row.PPVALPAR = Cursor_tbprcbck_param.GetString("PPVALPAR");
                Cursor_tbprcbck_param.Next();
              }
              m_cConnectivityError = Cursor_tbprcbck_param.ErrorMessage();
              Cursor_tbprcbck_param.Close();
              mcParam.GoTop();
              /* If not(mcParam.IsEmpty()) */
              if ( ! (mcParam.IsEmpty())) {
                // Inizializza il vettore
                _i=(int)mcParam.RecCount();
                cArg = new Class[(int)mcParam.RecCount()];
                cValue = new Object[(int)mcParam.RecCount()];
                _j=0;
                for (MemoryCursorRow_tbprcbck_param rwParam : mcParam._iterable_()) {
                  /* Case rwParam.PPTIPPAR='S' */
                  if (CPLib.eqr(rwParam.PPTIPPAR,"S")) {
                    //Tipo Stringa
                    cArg[_j] = String.class;
                    cValue[_j] = CPLib.LRTrim(rwParam.PPVALPAR);
                    /* Case tbprcbck_param->PPTIPPAR='D' */
                  } else if (CPLib.eqr(Cursor_tbprcbck_param.GetString("PPTIPPAR"),"D")) {
                    //Tipo Double
                    cArg[_j] = Double.class;
                    cValue[_j] = CPLib.Val(CPLib.LRTrim(rwParam.PPVALPAR));
                    /* Case tbprcbck_param->PPTIPPAR='I' */
                  } else if (CPLib.eqr(Cursor_tbprcbck_param.GetString("PPTIPPAR"),"I")) {
                    //Tipo Integer
                    cArg[_j] = Integer.class;
                    cValue[_j] = (int)CPLib.Val(CPLib.LRTrim(rwParam.PPVALPAR));
                  } // End Case
                  _j++;
                }
              } else { // Else
                // Inizializza il vettore
                cArg = null;
                cValue = null;
                _j=0;
              } // End If
              /* Verifico la possibilità il match del pattern letto dalla tabella con l'orario espresso in millisecondi da 01/01/1970 00:00:00 */
              /* If tbprcbck->PBFORZAESEC or mypattern.match(now.getTime()) */
              if (Cursor_tbprcbck.GetBoolean("PBFORZAESEC") || mypattern.match(now.getTime())) {
                /* If _primo */
                if (_primo) {
                  /* gAzienda := cpazi->codazi // Codice Azienda */
                  gAzienda = Cursor_cpazi.GetString("codazi");
                  m_Ctx.SetGlobalString("gAzienda",gAzienda);
                  /* Utilities.SetUserCode(1) */
                  Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
                  /* Exec Routine afterlogin */
                  afterloginR.Make(m_Ctx,this).Run();
                  /* _primo := False // verifica se ci sono processi da lanciare (conteggio>0) */
                  _primo = false;
                } // End If
                /* If Empty(tbprcbck->PBNOMPRC) or not(IsAliveAsync(tbprcbck->PBNOMPRC)) */
                if (CPLib.Empty(Cursor_tbprcbck.GetString("PBNOMPRC")) ||  ! (CPAsyncRoutine.IsAliveAsync(Cursor_tbprcbck.GetString("PBNOMPRC")))) {
                  /* Exec "Lancia" Page 2:Page_2 */
                  Page_2();
                  if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                    throw new RoutineException();
                  }
                } // End If
              } else { // Else
                /* If not(IsAliveAsync(tbprcbck->PBNOMPRC)) and Empty(tbprcbck->PBLASTEND) */
                if ( ! (CPAsyncRoutine.IsAliveAsync(Cursor_tbprcbck.GetString("PBNOMPRC"))) && CPLib.Empty(Cursor_tbprcbck.GetDateTime("PBLASTEND"))) {
                  // * --- Merge into tbprcbck from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("tbprcbck");
                  m_cPhName = m_Ctx.GetPhName("tbprcbck");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck",m_Ctx.GetCompany());
                  m_cQuery = "select ";
                  m_cQuery =  m_cQuery+""+CPLib.ToSQL(PBCODICE,"?",0,0)+" as PBCODICE";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                    m_cQuery = m_cQuery+" from dual";
                  }
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cWhere = "tbprcbck.PBCODICE = cptmp_1xab23.PBCODICE";
                  m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = CPLib.GetSQLPrefixComment("rt_startprcbkg",124,"00000038")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" tbprcbck USING ";
                    m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                    m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                    m_cSql = m_cSql+"PBLASTEND = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
                    m_cSql = m_cSql+"PBNOMPRC = "+CPLib.ToSQL(CPLib.NullString(),"C",30,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbprcbck",true,true);
                    m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                    m_cSql = m_cSql+GetFieldsName_00000038(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+"cptmp_1xab23.PBCODICE, ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullString(),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck",true);
                    m_cSql = m_cSql+")";
                    if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                      m_cSql = m_cSql+";";
                    }
                  } else {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("rt_startprcbkg",124,"00000038")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"PBLASTEND = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
                    m_cSql = m_cSql+"PBNOMPRC = "+CPLib.ToSQL(CPLib.NullString(),"C",30,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbprcbck",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"PBCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(PBCODICE,"?",0,0,m_cServer),m_cServer,PBCODICE)+"";
                    m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                    if (CPLib.eqr(m_nUpdatedRows,0)) {
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("rt_startprcbkg",124,"00000038")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                      m_cSql = m_cSql+GetFieldsName_00000038(m_Ctx,m_oWrInfo);
                      m_cSql = m_cSql+") values (";
                      m_cSql =  m_cSql+""+CPLib.ToSQL(PBCODICE,"?",0,0)+", ";
                      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullString(),"?",0,0,m_cServer)+", ";
                      m_cSql = m_cSql+m_oWrInfo.InsertValues();
                      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tbprcbck",true);
                      m_cSql = m_cSql+")";
                    } else {
                      m_cSql = "";
                    }
                  }
                  if ( ! (CPLib.Empty(m_cSql))) {
                    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
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
                } // End If
              } // End If
              /* LibreriaMit.FreeMem() */
              LibreriaMit.FreeMem();
              Cursor_tbprcbck.Next();
            }
            m_cConnectivityError = Cursor_tbprcbck.ErrorMessage();
            Cursor_tbprcbck.Close();
            // * --- End Select
          } // End If
          Cursor_cpazi.Next();
        }
        m_cConnectivityError = Cursor_cpazi.ErrorMessage();
        Cursor_cpazi.Close();
        // * --- End Select
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000017status,0)) {
          m_Sql.SetTransactionStatus(nTry00000017status,cTry00000017msg);
        }
      }
      /* Utilities.SetTimeout(0) */
      Utilities.Make(m_Ctx,m_Caller).SetTimeout(0);
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbprcbck!=null)
          Cursor_tbprcbck.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbprcbck_param!=null)
          Cursor_tbprcbck_param.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* id Char(0) := NullString() // id funzione asincrona */
    String id;
    id = CPLib.NullString();
    Method startMethod;
    Class clazz = Class.forName(routine);
    Object r = clazz.getMethod("Make",new Class[]{CPContext.class,Caller.class}).invoke(null,new Object[]{m_Ctx,CPSecurity.EXECUTE_ALL_ROUTINES});
    /* If _i <> 0 */
    if (CPLib.ne(_i,0)) {
      startMethod=clazz.getMethod("RunAsync",cArg);
      id=(String) startMethod.invoke(r,cValue);
    } else { // Else
      startMethod=clazz.getMethod("RunAsync",(Class[])null);
      id=(String) startMethod.invoke(r,(Object[])null);
    } // End If
    // * --- Write into tbprcbck from values
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tbprcbck");
    m_cPhName = m_Ctx.GetPhName("tbprcbck");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tbprcbck",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("rt_startprcbkg",124,"00000042")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
    m_cSql = m_cSql+"PBNOMPRC = "+CPLib.ToSQL(id,"C",30,0,m_cServer)+", ";
    m_cSql = m_cSql+"PBLASTSTART = "+CPLib.ToSQL(CPLib.DateTime(),"T",14,0)+", ";
    m_cSql = m_cSql+"PBLASTEND = "+CPLib.ToSQL(CPLib.NullDateTime(),"T",14,0)+", ";
    m_cSql = m_cSql+"PBFORZAESEC = "+CPLib.ToSQL(false,"L",1,0)+", ";
    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tbprcbck",false,true);
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+"PBCODICE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(PBCODICE,"?",0,0,m_cServer),m_cServer,PBCODICE)+"";
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static rt_startprcbkgR Make(CPContext p_Ctx, Caller p_Caller) {
    return new rt_startprcbkgR(p_Ctx, p_Caller);
  }
  public void Blank() {
    PBCODICE = 0;
    routine = CPLib.NullString();
    _valore = CPLib.NullString();
    mcParam = new MemoryCursor_tbprcbck_param();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gAppName=m_Ctx.GetGlobalString("gAppName");
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gTipDB=m_Ctx.GetGlobalString("gTipDB");
    gNAzienda=m_Ctx.GetGlobalString("gNAzienda");
    gDBCli=m_Ctx.GetGlobalString("gDBCli");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gAOS=m_Ctx.GetGlobalLogic("gAOS");
    gTER=m_Ctx.GetGlobalLogic("gTER");
    gSOS=m_Ctx.GetGlobalLogic("gSOS");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tab_mmc,
  public static final String m_cVQRList = ",qbe_tab_mmc,";
  // ENTITY_BATCHES: ,afterlogin,
  public static final String i_InvokedRoutines = ",afterlogin,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000038(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"PBCODICE,";
    p_cSql = p_cSql+"PBNOMPRC,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tbprcbck",true);
    return p_cSql;
  }
}
