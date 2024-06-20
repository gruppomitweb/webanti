// * --- Area Manuale = BO - Header
// * --- arfn_activate_doc
import org.apache.commons.lang.StringUtils;
// * --- Fine Area Manuale
public class arfn_activate_docR implements CallerWithObjs {
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
  public String m_cPhName_cgo_tbtipgio;
  public String m_cServer_cgo_tbtipgio;
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
  public String pGioco;
  public double pTotale;
  public double pContanti;
  public String cRitorno;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_activate_doc
  public int nNumPag;
  // * --- Fine Area Manuale
  public arfn_activate_docR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_activate_doc",m_Caller);
    m_cPhName_cgo_tbtipgio = p_ContextObject.GetPhName("cgo_tbtipgio");
    if (m_cPhName_cgo_tbtipgio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tbtipgio = m_cPhName_cgo_tbtipgio+" "+m_Ctx.GetWritePhName("cgo_tbtipgio");
    }
    m_cServer_cgo_tbtipgio = p_ContextObject.GetServer("cgo_tbtipgio");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pTotale",p_cVarName)) {
      return pTotale;
    }
    if (CPLib.eqr("pContanti",p_cVarName)) {
      return pContanti;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_activate_doc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pGioco",p_cVarName)) {
      return pGioco;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
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
    if (CPLib.eqr("pTotale",p_cVarName)) {
      pTotale = value;
      return;
    }
    if (CPLib.eqr("pContanti",p_cVarName)) {
      pContanti = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pGioco",p_cVarName)) {
      pGioco = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
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
    CPResultSet Cursor_cgo_tbtipgio=null;
    try {
      /* pGioco Char(3) // Tipo Gioco */
      /* pTotale Numeric(15, 2) // Importo Operazione */
      /* pContanti Numeric(15, 2) // Parte Contanti */
      /* cRitorno Char(6) // Valore di ritorno */
      // * --- Select from cgo_tbtipgio
      m_cServer = m_Ctx.GetServer("cgo_tbtipgio");
      m_cPhName = m_Ctx.GetPhName("cgo_tbtipgio");
      if (Cursor_cgo_tbtipgio!=null)
        Cursor_cgo_tbtipgio.Close();
      Cursor_cgo_tbtipgio = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODTPGIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pGioco,"?",0,0,m_cServer, m_oParameters),m_cServer,pGioco)+" "+")"+(m_Ctx.IsSharedTemp("cgo_tbtipgio")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cgo_tbtipgio.Eof())) {
        /* cRitorno := 'SSSSSS6' // Valore di ritorno */
        cRitorno = "SSSSSS6";
        /* If pTotale >= cgo_tbtipgio->SOGTPGIO */
        if (CPLib.ge(pTotale,Cursor_cgo_tbtipgio.GetDouble("SOGTPGIO"))) {
          /* If pContanti = pTotale */
          if (CPLib.eqr(pContanti,pTotale)) {
            /* cRitorno := iif(cgo_tbtipgio->FDC1ACGIO='S',cgo_tbtipgio->FDC1OSGIO,'N') */
            cRitorno = (CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC1ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC1OSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC2ACGIO='S',cgo_tbtipgio->FDC2OSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC2ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC2OSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC3ACGIO='S',cgo_tbtipgio->FDC3OSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC3ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC3OSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC4ACGIO='S',cgo_tbtipgio->FDC4OSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC4ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC4OSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC5ACGIO='S',cgo_tbtipgio->FDC5OSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC5ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC5OSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC6ACGIO='S',cgo_tbtipgio->FDC6OSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC6ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC6OSGIO"):"N");
            /* cRitorno := cRitorno + LRTrim(Str(cgo_tbtipgio->MAGPAGGIO-1,2,0)) */
            cRitorno = cRitorno+CPLib.LRTrim(CPLib.Str(Cursor_cgo_tbtipgio.GetDouble("MAGPAGGIO")-1,2,0));
          } else { // Else
            /* cRitorno := cgo_tbtipgio->FDC1OSGIO+cgo_tbtipgio->FDC2OSGIO+cgo_tbtipgio->FDC3OSGIO+cgo_tbtipgio->FDC4OSGIO+cgo_tbtipgio->FDC5OSGIO+cgo_tbtipgio->FDC6OSGIO */
            cRitorno = Cursor_cgo_tbtipgio.GetString("FDC1OSGIO")+Cursor_cgo_tbtipgio.GetString("FDC2OSGIO")+Cursor_cgo_tbtipgio.GetString("FDC3OSGIO")+Cursor_cgo_tbtipgio.GetString("FDC4OSGIO")+Cursor_cgo_tbtipgio.GetString("FDC5OSGIO")+Cursor_cgo_tbtipgio.GetString("FDC6OSGIO");
            /* cRitorno := cRitorno + LRTrim(Str(cgo_tbtipgio->MAGPAGGIO,2,0)) */
            cRitorno = cRitorno+CPLib.LRTrim(CPLib.Str(Cursor_cgo_tbtipgio.GetDouble("MAGPAGGIO"),2,0));
          } // End If
        } else { // Else
          /* If pContanti = pTotale */
          if (CPLib.eqr(pContanti,pTotale)) {
            /* cRitorno := iif(cgo_tbtipgio->FDC1ACGIO='S',cgo_tbtipgio->FDC1SSGIO,'N') */
            cRitorno = (CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC1ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC1SSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC2ACGIO='S',cgo_tbtipgio->FDC2SSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC2ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC2SSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC3ACGIO='S',cgo_tbtipgio->FDC3SSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC3ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC3SSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC4ACGIO='S',cgo_tbtipgio->FDC4SSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC4ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC4SSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC5ACGIO='S',cgo_tbtipgio->FDC5SSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC5ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC5SSGIO"):"N");
            /* cRitorno := cRitorno + iif(cgo_tbtipgio->FDC6ACGIO='S',cgo_tbtipgio->FDC6SSGIO,'N') */
            cRitorno = cRitorno+(CPLib.eqr(Cursor_cgo_tbtipgio.GetString("FDC6ACGIO"),"S")?Cursor_cgo_tbtipgio.GetString("FDC6SSGIO"):"N");
            /* cRitorno := cRitorno + LRTrim(Str(cgo_tbtipgio->MINPAGGIO-1,2,0)) */
            cRitorno = cRitorno+CPLib.LRTrim(CPLib.Str(Cursor_cgo_tbtipgio.GetDouble("MINPAGGIO")-1,2,0));
          } else { // Else
            /* cRitorno := cgo_tbtipgio->FDC1SSGIO+cgo_tbtipgio->FDC2SSGIO+cgo_tbtipgio->FDC3SSGIO+cgo_tbtipgio->FDC4SSGIO+cgo_tbtipgio->FDC5SSGIO+cgo_tbtipgio->FDC6SSGIO */
            cRitorno = Cursor_cgo_tbtipgio.GetString("FDC1SSGIO")+Cursor_cgo_tbtipgio.GetString("FDC2SSGIO")+Cursor_cgo_tbtipgio.GetString("FDC3SSGIO")+Cursor_cgo_tbtipgio.GetString("FDC4SSGIO")+Cursor_cgo_tbtipgio.GetString("FDC5SSGIO")+Cursor_cgo_tbtipgio.GetString("FDC6SSGIO");
            /* cRitorno := cRitorno + LRTrim(Str(cgo_tbtipgio->MINPAGGIO,2,0)) */
            cRitorno = cRitorno+CPLib.LRTrim(CPLib.Str(Cursor_cgo_tbtipgio.GetDouble("MINPAGGIO"),2,0));
          } // End If
        } // End If
        Cursor_cgo_tbtipgio.Next();
      }
      m_cConnectivityError = Cursor_cgo_tbtipgio.ErrorMessage();
      Cursor_cgo_tbtipgio.Close();
      // * --- End Select
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_cgo_tbtipgio!=null)
          Cursor_cgo_tbtipgio.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pGioco,double p_pTotale,double p_pContanti) {
    pGioco = p_pGioco;
    pTotale = p_pTotale;
    pContanti = p_pContanti;
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
  public String Run(String p_pGioco,double p_pTotale,double p_pContanti) {
    pGioco = p_pGioco;
    pTotale = p_pTotale;
    pContanti = p_pContanti;
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
  public static arfn_activate_docR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_activate_docR(p_Ctx, p_Caller);
  }
  public static arfn_activate_docR Make(CPContext p_Ctx) {
    return new arfn_activate_docR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pGioco = CPLib.Space(3);
    pTotale = 0;
    pContanti = 0;
    cRitorno = CPLib.Space(6);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_activate_doc,
  public static final String i_InvokedRoutines = ",arfn_activate_doc,";
  public static String[] m_cRunParameterNames={"pGioco","pTotale","pContanti"};
}
