// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_ae_agg_aetesta_titR implements CallerWithObjs {
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
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
  public String pSoggetto;
  public double _noprot;
  public double _continua;
  public java.sql.Date gDataTito;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_ae_agg_aetesta_titR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_ae_agg_aetesta_tit",m_Caller);
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_garantbo = p_ContextObject.GetPhName("garantbo");
    if (m_cPhName_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_garantbo = m_cPhName_garantbo+" "+m_Ctx.GetWritePhName("garantbo");
    }
    m_cServer_garantbo = p_ContextObject.GetServer("garantbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_noprot",p_cVarName)) {
      return _noprot;
    }
    if (CPLib.eqr("_continua",p_cVarName)) {
      return _continua;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_ae_agg_aetesta_tit";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pSoggetto",p_cVarName)) {
      return pSoggetto;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      return gDataTito;
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
    if (CPLib.eqr("_noprot",p_cVarName)) {
      _noprot = value;
      return;
    }
    if (CPLib.eqr("_continua",p_cVarName)) {
      _continua = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pSoggetto",p_cVarName)) {
      pSoggetto = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      gDataTito = value;
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
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_famesiti_intestbo_minmax=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_qbe_famesiti_jntestbo_minmax=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pSoggetto Char(16) */
      /* _noprot Numeric(1, 0) */
      /* _continua Numeric(1, 0) */
      /* gDataTito Date // Data per Titolari Effettivi */
      // * --- Select from intestbo
      m_cServer = m_Ctx.GetServer("intestbo");
      m_cPhName = m_Ctx.GetPhName("intestbo");
      if (Cursor_intestbo!=null)
        Cursor_intestbo.Close();
      Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSoggetto,"?",0,0,m_cServer, m_oParameters),m_cServer,pSoggetto)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intestbo.Eof())) {
        /* _noprot := 0 */
        _noprot = CPLib.Round(0,0);
        // * --- Read from anarapbo
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_intestbo.GetString("RAPPORTO"));
        if (m_Ctx.IsSharedTemp("anarapbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOPROT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _noprot = CPLib.Round(Read_Cursor.GetDouble("NOPROT"),0);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on anarapbo into routine arrt_ae_agg_aetesta_tit returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _noprot = 0;
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If _noprot=0 */
        if (CPLib.eqr(_noprot,0)) {
          /* _continua := 0 */
          _continua = CPLib.Round(0,0);
          // * --- Select from qbe_famesiti_intestbo_minmax
          SPBridge.HMCaller _h0000000E;
          _h0000000E = new SPBridge.HMCaller();
          _h0000000E.Set("m_cVQRList",m_cVQRList);
          _h0000000E.Set("pRAPPORTO",Cursor_intestbo.GetString("RAPPORTO"));
          if (Cursor_qbe_famesiti_intestbo_minmax!=null)
            Cursor_qbe_famesiti_intestbo_minmax.Close();
          Cursor_qbe_famesiti_intestbo_minmax = new VQRHolder("qbe_famesiti_intestbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000000E,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_famesiti_intestbo_minmax.Eof())) {
            /* If Empty(gDataTito) or (qbe_famesiti_intestbo_minmax->DATAINI >= gDataTito) */
            if (CPLib.Empty(gDataTito) || (CPLib.ge(Cursor_qbe_famesiti_intestbo_minmax.GetDate("DATAINI"),gDataTito))) {
              /* _continua := 1 */
              _continua = CPLib.Round(1,0);
            } // End If
            Cursor_qbe_famesiti_intestbo_minmax.Next();
          }
          m_cConnectivityError = Cursor_qbe_famesiti_intestbo_minmax.ErrorMessage();
          Cursor_qbe_famesiti_intestbo_minmax.Close();
          // * --- End Select
          /* If _continua = 1 */
          if (CPLib.eqr(_continua,1)) {
            /* If Empty(intestbo->DATAFINE) */
            if (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) {
              // * --- Select from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              if (Cursor_aetesta!=null)
                Cursor_aetesta.Close();
              Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_aetesta.Eof())) {
                /* If Empty(aetesta->DATAMODI) and aetesta->INVIATO=1 and not(Empty(aetesta->DATAINVIO)) */
                if (CPLib.Empty(Cursor_aetesta.GetDate("DATAMODI")) && CPLib.eqr(Cursor_aetesta.GetDouble("INVIATO"),1) &&  ! (CPLib.Empty(Cursor_aetesta.GetDate("DATAINVIO")))) {
                  // * --- Write into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_ae_agg_aetesta_tit",18,"00000015")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_intestbo.GetString("RAPPORTO"))+"";
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
                Cursor_aetesta.Next();
              }
              m_cConnectivityError = Cursor_aetesta.ErrorMessage();
              Cursor_aetesta.Close();
              // * --- End Select
            } // End If
          } // End If
        } // End If
        Cursor_intestbo.Next();
      }
      m_cConnectivityError = Cursor_intestbo.ErrorMessage();
      Cursor_intestbo.Close();
      // * --- End Select
      // * --- Select from jntestbo
      m_cServer = m_Ctx.GetServer("jntestbo");
      m_cPhName = m_Ctx.GetPhName("jntestbo");
      if (Cursor_jntestbo!=null)
        Cursor_jntestbo.Close();
      Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSoggetto,"?",0,0,m_cServer, m_oParameters),m_cServer,pSoggetto)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jntestbo.Eof())) {
        /* _continua := 0 */
        _continua = CPLib.Round(0,0);
        // * --- Select from qbe_famesiti_jntestbo_minmax
        SPBridge.HMCaller _h00000018;
        _h00000018 = new SPBridge.HMCaller();
        _h00000018.Set("m_cVQRList",m_cVQRList);
        _h00000018.Set("pRAPPORTO",Cursor_jntestbo.GetString("RAPPORTO"));
        if (Cursor_qbe_famesiti_jntestbo_minmax!=null)
          Cursor_qbe_famesiti_jntestbo_minmax.Close();
        Cursor_qbe_famesiti_jntestbo_minmax = new VQRHolder("qbe_famesiti_jntestbo_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000018,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_famesiti_jntestbo_minmax.Eof())) {
          /* If Empty(gDataTito) or (qbe_famesiti_jntestbo_minmax->DATAINI >= gDataTito) */
          if (CPLib.Empty(gDataTito) || (CPLib.ge(Cursor_qbe_famesiti_jntestbo_minmax.GetDate("DATAINI"),gDataTito))) {
            /* _continua := 1 */
            _continua = CPLib.Round(1,0);
          } // End If
          Cursor_qbe_famesiti_jntestbo_minmax.Next();
        }
        m_cConnectivityError = Cursor_qbe_famesiti_jntestbo_minmax.ErrorMessage();
        Cursor_qbe_famesiti_jntestbo_minmax.Close();
        // * --- End Select
        /* If _continua=1 */
        if (CPLib.eqr(_continua,1)) {
          /* If Empty(jntestbo->DATAFINE) */
          if (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) {
            // * --- Select from aetesta
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            if (Cursor_aetesta!=null)
              Cursor_aetesta.Close();
            Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_jntestbo.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_aetesta.Eof())) {
              /* If Empty(aetesta->DATAMODI) and aetesta->INVIATO=1 and not(Empty(aetesta->DATAINVIO)) */
              if (CPLib.Empty(Cursor_aetesta.GetDate("DATAMODI")) && CPLib.eqr(Cursor_aetesta.GetDouble("INVIATO"),1) &&  ! (CPLib.Empty(Cursor_aetesta.GetDate("DATAINVIO")))) {
                // * --- Write into aetesta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_ae_agg_aetesta_tit",18,"0000001F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jntestbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_jntestbo.GetString("RAPPORTO"))+"";
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
              Cursor_aetesta.Next();
            }
            m_cConnectivityError = Cursor_aetesta.ErrorMessage();
            Cursor_aetesta.Close();
            // * --- End Select
          } // End If
        } // End If
        Cursor_jntestbo.Next();
      }
      m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
      Cursor_jntestbo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
      try {
        if (Cursor_qbe_famesiti_intestbo_minmax!=null)
          Cursor_qbe_famesiti_intestbo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famesiti_jntestbo_minmax!=null)
          Cursor_qbe_famesiti_jntestbo_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pSoggetto) {
    pSoggetto = p_pSoggetto;
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
  public Forward Run(String p_pSoggetto) {
    pSoggetto = p_pSoggetto;
    return Run();
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
  public static arrt_ae_agg_aetesta_titR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_ae_agg_aetesta_titR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pSoggetto = CPLib.Space(16);
    _noprot = 0;
    _continua = 0;
    gDataTito=m_Ctx.GetGlobalDate("gDataTito");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_famesiti_intestbo_minmax,qbe_famesiti_jntestbo_minmax,
  public static final String m_cVQRList = ",qbe_famesiti_intestbo_minmax,qbe_famesiti_jntestbo_minmax,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pSoggetto"};
}
