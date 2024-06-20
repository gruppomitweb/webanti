// * --- Area Manuale = BO - Header
// * --- arfn_cgo_chkdocs
import org.apache.commons.lang.StringUtils;
// * --- Fine Area Manuale
public class arfn_cgo_chkdocsR implements CallerWithObjs {
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
  public String m_cPhName_cgo_docope;
  public String m_cServer_cgo_docope;
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
  public String pIDDOC;
  public String pGioco;
  public double pTotale;
  public double pContanti;
  public String pFlgDoc;
  public String gGesDoc;
  public String _flgdocall;
  public String _docver;
  public double _doctot;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_cgo_chkdocs
  public int nNumPag;
  // * --- Fine Area Manuale
  public arfn_cgo_chkdocsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_cgo_chkdocs",m_Caller);
    m_cPhName_cgo_tbtipgio = p_ContextObject.GetPhName("cgo_tbtipgio");
    if (m_cPhName_cgo_tbtipgio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tbtipgio = m_cPhName_cgo_tbtipgio+" "+m_Ctx.GetWritePhName("cgo_tbtipgio");
    }
    m_cServer_cgo_tbtipgio = p_ContextObject.GetServer("cgo_tbtipgio");
    m_cPhName_cgo_docope = p_ContextObject.GetPhName("cgo_docope");
    if (m_cPhName_cgo_docope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_docope = m_cPhName_cgo_docope+" "+m_Ctx.GetWritePhName("cgo_docope");
    }
    m_cServer_cgo_docope = p_ContextObject.GetServer("cgo_docope");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pTotale",p_cVarName)) {
      return pTotale;
    }
    if (CPLib.eqr("pContanti",p_cVarName)) {
      return pContanti;
    }
    if (CPLib.eqr("_doctot",p_cVarName)) {
      return _doctot;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cgo_chkdocs";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pIDDOC",p_cVarName)) {
      return pIDDOC;
    }
    if (CPLib.eqr("pGioco",p_cVarName)) {
      return pGioco;
    }
    if (CPLib.eqr("pFlgDoc",p_cVarName)) {
      return pFlgDoc;
    }
    if (CPLib.eqr("gGesDoc",p_cVarName)) {
      return gGesDoc;
    }
    if (CPLib.eqr("_flgdocall",p_cVarName)) {
      return _flgdocall;
    }
    if (CPLib.eqr("_docver",p_cVarName)) {
      return _docver;
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
    if (CPLib.eqr("_doctot",p_cVarName)) {
      _doctot = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pIDDOC",p_cVarName)) {
      pIDDOC = value;
      return;
    }
    if (CPLib.eqr("pGioco",p_cVarName)) {
      pGioco = value;
      return;
    }
    if (CPLib.eqr("pFlgDoc",p_cVarName)) {
      pFlgDoc = value;
      return;
    }
    if (CPLib.eqr("gGesDoc",p_cVarName)) {
      gGesDoc = value;
      return;
    }
    if (CPLib.eqr("_flgdocall",p_cVarName)) {
      _flgdocall = value;
      return;
    }
    if (CPLib.eqr("_docver",p_cVarName)) {
      _docver = value;
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
    CPResultSet Cursor_cgo_docope=null;
    try {
      /* pIDDOC Char(36) // ID Documenti */
      /* pGioco Char(3) // Tipo Gioco */
      /* pTotale Numeric(15, 2) // Importo Operazione */
      /* pContanti Numeric(15, 2) // Parte Contanti */
      /* pFlgDoc Char(1) // Flag Documentazione COmpleta */
      /* gGesDoc Char(1) // Gestione Documentale */
      /* _flgdocall Char(1) */
      /* _docver Char(7) */
      /* _doctot Numeric(2, 0) */
      /* _flgdocall := 'X' */
      _flgdocall = "X";
      /* If not(Empty(pIDDOC))  and pFlgDoc <> 'X' */
      if ( ! (CPLib.Empty(pIDDOC)) && CPLib.ne(pFlgDoc,"X")) {
        /* _flgdocall := 'N' */
        _flgdocall = "N";
        // * --- Select from cgo_docope
        m_cServer = m_Ctx.GetServer("cgo_docope");
        m_cPhName = m_Ctx.GetPhName("cgo_docope");
        if (Cursor_cgo_docope!=null)
          Cursor_cgo_docope.Close();
        Cursor_cgo_docope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer, m_oParameters),m_cServer,pIDDOC)+" "+")"+(m_Ctx.IsSharedTemp("cgo_docope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_docope.Eof())) {
          /* If not(Empty(cgo_docope->DCDOCUNICO)) */
          if ( ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCUNICO")))) {
            /* _flgdocall := 'S' */
            _flgdocall = "S";
          } else { // Else
            /* _docver := arfn_activate_doc(pGioco,pTotale,pContanti) */
            _docver = arfn_activate_docR.Make(m_Ctx,this).Run(pGioco,pTotale,pContanti);
            /* _doctot := 0 */
            _doctot = CPLib.Round(0,0);
            /* If Substr(_docver,1,1)='S' and not(Empty(cgo_docope->DCDOCNOM1)) */
            if (CPLib.eqr(CPLib.Substr(_docver,1,1),"S") &&  ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM1")))) {
              /* _doctot := _doctot + 1 */
              _doctot = CPLib.Round(_doctot+1,0);
            } // End If
            /* If Substr(_docver,2,1)='S' and not(Empty(cgo_docope->DCDOCNOM2)) */
            if (CPLib.eqr(CPLib.Substr(_docver,2,1),"S") &&  ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM2")))) {
              /* _doctot := _doctot + 1 */
              _doctot = CPLib.Round(_doctot+1,0);
            } // End If
            /* If Substr(_docver,3,1)='S' and not(Empty(cgo_docope->DCDOCNOM3)) */
            if (CPLib.eqr(CPLib.Substr(_docver,3,1),"S") &&  ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM3")))) {
              /* _doctot := _doctot + 1 */
              _doctot = CPLib.Round(_doctot+1,0);
            } // End If
            /* If Substr(_docver,4,1)='S' and not(Empty(cgo_docope->DCDOCNOM4)) */
            if (CPLib.eqr(CPLib.Substr(_docver,4,1),"S") &&  ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM4")))) {
              /* _doctot := _doctot + 1 */
              _doctot = CPLib.Round(_doctot+1,0);
            } // End If
            /* If Substr(_docver,5,1)='S' and not(Empty(cgo_docope->DCDOCNOM5)) */
            if (CPLib.eqr(CPLib.Substr(_docver,5,1),"S") &&  ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM5")))) {
              /* _doctot := _doctot + 1 */
              _doctot = CPLib.Round(_doctot+1,0);
            } // End If
            /* If Substr(_docver,6,1)='S' and not(Empty(cgo_docope->DCDOCNOM6)) */
            if (CPLib.eqr(CPLib.Substr(_docver,6,1),"S") &&  ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM6")))) {
              /* _doctot := _doctot + 1 */
              _doctot = CPLib.Round(_doctot+1,0);
            } // End If
            /* If _doctot = Val(Substr(_docver,7,1)) */
            if (CPLib.eqr(_doctot,CPLib.Val(CPLib.Substr(_docver,7,1)))) {
              /* _flgdocall := 'S' */
              _flgdocall = "S";
            } // End If
          } // End If
          Cursor_cgo_docope.Next();
        }
        m_cConnectivityError = Cursor_cgo_docope.ErrorMessage();
        Cursor_cgo_docope.Close();
        // * --- End Select
      } // End If
      /* Return _flgdocall */
      throw new Stop(_flgdocall);
    } finally {
      try {
        if (Cursor_cgo_docope!=null)
          Cursor_cgo_docope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pIDDOC,String p_pGioco,double p_pTotale,double p_pContanti,String p_pFlgDoc) {
    pIDDOC = p_pIDDOC;
    pGioco = p_pGioco;
    pTotale = p_pTotale;
    pContanti = p_pContanti;
    pFlgDoc = p_pFlgDoc;
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
  public String Run(String p_pIDDOC,String p_pGioco,double p_pTotale,double p_pContanti,String p_pFlgDoc) {
    pIDDOC = p_pIDDOC;
    pGioco = p_pGioco;
    pTotale = p_pTotale;
    pContanti = p_pContanti;
    pFlgDoc = p_pFlgDoc;
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
  public static arfn_cgo_chkdocsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cgo_chkdocsR(p_Ctx, p_Caller);
  }
  public static arfn_cgo_chkdocsR Make(CPContext p_Ctx) {
    return new arfn_cgo_chkdocsR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pIDDOC = CPLib.Space(36);
    pGioco = CPLib.Space(3);
    pTotale = 0;
    pContanti = 0;
    pFlgDoc = CPLib.Space(1);
    _flgdocall = CPLib.Space(1);
    _docver = CPLib.Space(7);
    _doctot = 0;
    gGesDoc=m_Ctx.GetGlobalString("gGesDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_activate_doc,arfn_cgo_chkdocs,
  public static final String i_InvokedRoutines = ",arfn_activate_doc,arfn_cgo_chkdocs,";
  public static String[] m_cRunParameterNames={"pIDDOC","pGioco","pTotale","pContanti","pFlgDoc"};
}
