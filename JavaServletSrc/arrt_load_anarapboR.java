// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_load_anarapboR implements CallerWithObjs {
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
  public String m_cPhName_zperazbo;
  public String m_cServer_zperazbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String cRapporto;
  public String _tipo;
  public String _comando;
  public String _where;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_load_anarapboR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi� istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda � contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_load_anarapbo",m_Caller);
    m_cPhName_zperazbo = p_ContextObject.GetPhName("zperazbo");
    if (m_cPhName_zperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_zperazbo = m_cPhName_zperazbo+" "+m_Ctx.GetWritePhName("zperazbo");
    }
    m_cServer_zperazbo = p_ContextObject.GetServer("zperazbo");
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
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
      return "arrt_load_anarapbo";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      return cRapporto;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      return _tipo;
    }
    if (CPLib.eqr("_comando",p_cVarName)) {
      return _comando;
    }
    if (CPLib.eqr("_where",p_cVarName)) {
      return _where;
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
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      cRapporto = value;
      return;
    }
    if (CPLib.eqr("_tipo",p_cVarName)) {
      _tipo = value;
      return;
    }
    if (CPLib.eqr("_comando",p_cVarName)) {
      _comando = value;
      return;
    }
    if (CPLib.eqr("_where",p_cVarName)) {
      _where = value;
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
    /* Definizione variabili locali */
    /* cRapporto Char(25) */
    /* _tipo Char(1) */
    /* _comando Memo */
    /* _where Char(80) */
    /* Verifica l'esistenza */
    /* cRapporto := Left(cRapporto,25) */
    cRapporto = CPLib.Left(cRapporto,25);
    /* cRapporto := Strtran(cRapporto,'"','') */
    cRapporto = CPLib.Strtran(cRapporto,"\"","");
    /* If not(Empty(cRapporto)) */
    if ( ! (CPLib.Empty(cRapporto))) {
      /* _comando := 'query RAPPORTO="'+cRapporto+'"'+ NL + "@" + NL + "@SAVE"+ NL +"arrt_load_anarapbo" + NL +'cRapporto="%RAPPORTO%" '+NL+"@DISCARD"+ NL +"arrt_load_anarapbo" */
      _comando = "query RAPPORTO=\""+cRapporto+"\""+"\n"+"@"+"\n"+"@SAVE"+"\n"+"arrt_load_anarapbo"+"\n"+"cRapporto=\"%RAPPORTO%\" "+"\n"+"@DISCARD"+"\n"+"arrt_load_anarapbo";
      /* _where := "RAPPORTO='"+cRapporto+"'" */
      _where = "RAPPORTO='"+cRapporto+"'";
    } else { // Else
      /* _comando := 'query RAPPORTO=""'+ NL + "@" + NL + "@SAVE"+ NL +"arrt_load_anarapbo" + NL +'cRapporto="%RAPPORTO%" '+NL+"@DISCARD"+ NL +"arrt_load_anarapbo" */
      _comando = "query RAPPORTO=\"\""+"\n"+"@"+"\n"+"@SAVE"+"\n"+"arrt_load_anarapbo"+"\n"+"cRapporto=\"%RAPPORTO%\" "+"\n"+"@DISCARD"+"\n"+"arrt_load_anarapbo";
      /* _where := "RAPPORTO=''" */
      _where = "RAPPORTO=''";
    } // End If
    /* Return  */
    Forward f;
    f=new Forward("armt_anarap",false,this,Forward.Start,false);
    f.SetParameter("m_cAction","workflow");
    f.SetParameter("WorkFlowScript",_comando);
    f.SetParameter("m_cLastWhere",_where);
    f.SetParameter("m_cParameterSequence","m_cAction"+","+"WorkFlowScript"+","+"m_cLastWhere");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
  }
  void _init_() {
  }
  public String RunAsync(String p_cRapporto) {
    cRapporto = p_cRapporto;
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
  public Forward Run(String p_cRapporto) {
    cRapporto = p_cRapporto;
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
  public static arrt_load_anarapboR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_load_anarapboR(p_Ctx, p_Caller);
  }
  public void Blank() {
    cRapporto = CPLib.Space(25);
    _tipo = CPLib.Space(1);
    _comando = "";
    _where = CPLib.Space(80);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"cRapporto"};
}
