// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_snai_oper_loadR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
  public String m_cPhName_cgo_operazioni_dl;
  public String m_cServer_cgo_operazioni_dl;
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
  public String pNumOpe;
  public String pFlgT;
  public String pAgenzia;
  public String _comando;
  public double _importo;
  public java.sql.Date _dataope;
  public String _tipope;
  public String _dl;
  public String gCodDip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_snai_oper_loadR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_snai_oper_load",m_Caller);
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    if (m_cPhName_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni = m_cPhName_cgo_operazioni+" "+m_Ctx.GetWritePhName("cgo_operazioni");
    }
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
    m_cPhName_cgo_operazioni_dl = p_ContextObject.GetPhName("cgo_operazioni_dl");
    if (m_cPhName_cgo_operazioni_dl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl = m_cPhName_cgo_operazioni_dl+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl");
    }
    m_cServer_cgo_operazioni_dl = p_ContextObject.GetServer("cgo_operazioni_dl");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_importo",p_cVarName)) {
      return _importo;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_snai_oper_load";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pNumOpe",p_cVarName)) {
      return pNumOpe;
    }
    if (CPLib.eqr("pFlgT",p_cVarName)) {
      return pFlgT;
    }
    if (CPLib.eqr("pAgenzia",p_cVarName)) {
      return pAgenzia;
    }
    if (CPLib.eqr("_comando",p_cVarName)) {
      return _comando;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      return _tipope;
    }
    if (CPLib.eqr("_dl",p_cVarName)) {
      return _dl;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
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
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pNumOpe",p_cVarName)) {
      pNumOpe = value;
      return;
    }
    if (CPLib.eqr("pFlgT",p_cVarName)) {
      pFlgT = value;
      return;
    }
    if (CPLib.eqr("pAgenzia",p_cVarName)) {
      pAgenzia = value;
      return;
    }
    if (CPLib.eqr("_comando",p_cVarName)) {
      _comando = value;
      return;
    }
    if (CPLib.eqr("_tipope",p_cVarName)) {
      _tipope = value;
      return;
    }
    if (CPLib.eqr("_dl",p_cVarName)) {
      _dl = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
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
    CPResultSet Cursor_cgo_operazioni=null;
    CPResultSet Cursor_cgo_operazioni_dl=null;
    try {
      /* pNumOpe Char(15) */
      /* pFlgT Char(1) */
      /* pAgenzia Char(6) */
      /* _comando Memo */
      /* _importo Numeric(15, 2) */
      /* _dataope Date */
      /* _tipope Char(1) */
      /* _dl Char(1) */
      /* gCodDip Char(6) // Dipendenza */
      /* Prepara la stringa poi lancia */
      /* Case pFlgT='A' */
      if (CPLib.eqr(pFlgT,"A")) {
        /* _comando := 'edit SNAINUMOPE="' + pNumOpe + '"' + NL + "@" + NL + "@SAVE"+ NL +"arrt_snai_oper_save" + NL + 'pSNAINUMOPE="%SNAINUMOPE%"' + NL +'pTipo="X"' + NL + 'pPage="A"'+NL+ 'pAzi=""'+NL+"@DISCARD"+ NL + "arpg_cgo_operazioni_agenzie_admin"+NL+"agenzia='"+pAgenzia+"'" */
        _comando = "edit SNAINUMOPE=\""+pNumOpe+"\""+"\n"+"@"+"\n"+"@SAVE"+"\n"+"arrt_snai_oper_save"+"\n"+"pSNAINUMOPE=\"%SNAINUMOPE%\""+"\n"+"pTipo=\"X\""+"\n"+"pPage=\"A\""+"\n"+"pAzi=\"\""+"\n"+"@DISCARD"+"\n"+"arpg_cgo_operazioni_agenzie_admin"+"\n"+"agenzia='"+pAgenzia+"'";
        /* Stop armt_snai_oper */
        Forward f;
        f=new Forward("armt_snai_oper",false,this,Forward.EditStatus,false);
        f.SetParameter("m_cAction","workflow");
        f.SetParameter("WorkFlowScript",_comando);
        f.SetParameter("m_cParameterSequence","m_cAction"+","+"WorkFlowScript");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
        /* Case pFlgT='P' */
      } else if (CPLib.eqr(pFlgT,"P")) {
        // * --- Select from cgo_operazioni
        m_cServer = m_Ctx.GetServer("cgo_operazioni");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni");
        if (Cursor_cgo_operazioni!=null)
          Cursor_cgo_operazioni.Close();
        Cursor_cgo_operazioni = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"SNAINUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNumOpe,"?",0,0,m_cServer, m_oParameters),m_cServer,pNumOpe)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_operazioni.Eof())) {
          /* _importo := cgo_operazioni->TOTLIRE */
          _importo = CPLib.Round(Cursor_cgo_operazioni.GetDouble("TOTLIRE"),2);
          /* _dataope := cgo_operazioni->DATAOPE */
          _dataope = Cursor_cgo_operazioni.GetDate("DATAOPE");
          /* _tipope := cgo_operazioni->CGOTIPOPE */
          _tipope = Cursor_cgo_operazioni.GetString("CGOTIPOPE");
          Cursor_cgo_operazioni.Next();
        }
        m_cConnectivityError = Cursor_cgo_operazioni.ErrorMessage();
        Cursor_cgo_operazioni.Close();
        // * --- End Select
        /* _dl := 'N' */
        _dl = "N";
        // * --- Select from cgo_operazioni_dl
        m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
        m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
        if (Cursor_cgo_operazioni_dl!=null)
          Cursor_cgo_operazioni_dl.Close();
        Cursor_cgo_operazioni_dl = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(gCodDip,"?",0,0,m_cServer, m_oParameters),m_cServer,gCodDip)+"  and  DATAOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_dataope,"?",0,0,m_cServer, m_oParameters),m_cServer,_dataope)+"  and  TOTLIRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_importo,"?",0,0,m_cServer, m_oParameters),m_cServer,_importo)+"  and  CGOTIPOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_tipope,"?",0,0,m_cServer, m_oParameters),m_cServer,_tipope)+" "+")"+(m_Ctx.IsSharedTemp("cgo_operazioni_dl")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_cgo_operazioni_dl.Eof())) {
          /* _dl := 'S' */
          _dl = "S";
          Cursor_cgo_operazioni_dl.Next();
        }
        m_cConnectivityError = Cursor_cgo_operazioni_dl.ErrorMessage();
        Cursor_cgo_operazioni_dl.Close();
        // * --- End Select
        /* _comando := 'edit SNAINUMOPE="' + pNumOpe + '"' + NL +'verifica="' + _dl + '"'+ NL + "@" + NL + "@SAVE"+ NL +"arrt_snai_oper_save" + NL + "pSNAINUMOPE='%SNAINUMOPE%'" + NL + 'pTipo="X"' + NL + 'pPage="P"'+NL+'pAzi=""'+NL+"@DISCARD"+ NL + "arpg_cgo_operazioni_agenzie" */
        _comando = "edit SNAINUMOPE=\""+pNumOpe+"\""+"\n"+"verifica=\""+_dl+"\""+"\n"+"@"+"\n"+"@SAVE"+"\n"+"arrt_snai_oper_save"+"\n"+"pSNAINUMOPE='%SNAINUMOPE%'"+"\n"+"pTipo=\"X\""+"\n"+"pPage=\"P\""+"\n"+"pAzi=\"\""+"\n"+"@DISCARD"+"\n"+"arpg_cgo_operazioni_agenzie";
        /* Stop armt_snai_oper */
        Forward f;
        f=new Forward("armt_snai_oper",false,this,Forward.EditStatus,false);
        f.SetParameter("m_cAction","workflow");
        f.SetParameter("WorkFlowScript",_comando);
        f.SetParameter("m_cParameterSequence","m_cAction"+","+"WorkFlowScript");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
        /* Case pFlgT='V' */
      } else if (CPLib.eqr(pFlgT,"V")) {
        /* _comando := 'edit SNAINUMOPE="' + pNumOpe + '"' + NL + "@" + NL + "@SAVE"+ NL +"arrt_snai_oper_save" + NL + 'pSNAINUMOPE="%SNAINUMOPE%"' + NL + 'pTipo="%FLGSAVE%"' + NL + 'pPage="V"'+NL+ 'pAzi=""'+NL+"@DISCARD"+ NL + "arpg_cgo_operazioni_vlt" */
        _comando = "edit SNAINUMOPE=\""+pNumOpe+"\""+"\n"+"@"+"\n"+"@SAVE"+"\n"+"arrt_snai_oper_save"+"\n"+"pSNAINUMOPE=\"%SNAINUMOPE%\""+"\n"+"pTipo=\"%FLGSAVE%\""+"\n"+"pPage=\"V\""+"\n"+"pAzi=\"\""+"\n"+"@DISCARD"+"\n"+"arpg_cgo_operazioni_vlt";
        /* Stop armt_snai_oper_v */
        Forward f;
        f=new Forward("armt_snai_oper_v",false,this,Forward.EditStatus,false);
        f.SetParameter("m_cAction","workflow");
        f.SetParameter("WorkFlowScript",_comando);
        f.SetParameter("m_cParameterSequence","m_cAction"+","+"WorkFlowScript");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
        /* Case pFlgT='N' */
      } else if (CPLib.eqr(pFlgT,"N")) {
        /* _comando := 'edit SNAINUMOPE="' + pNumOpe + '"' + NL + "@" + NL + "@SAVE"+ NL +"arrt_snai_oper_save" + NL + 'pSNAINUMOPE="%SNAINUMOPE%"' + NL + 'pTipo="%FLGSAVE%"' + NL + 'pPage="N"'+NL+'pAzi=""'+NL+"@DISCARD"+ NL + "arpg_cgo_operazioni_vnp" */
        _comando = "edit SNAINUMOPE=\""+pNumOpe+"\""+"\n"+"@"+"\n"+"@SAVE"+"\n"+"arrt_snai_oper_save"+"\n"+"pSNAINUMOPE=\"%SNAINUMOPE%\""+"\n"+"pTipo=\"%FLGSAVE%\""+"\n"+"pPage=\"N\""+"\n"+"pAzi=\"\""+"\n"+"@DISCARD"+"\n"+"arpg_cgo_operazioni_vnp";
        /* Stop armt_snai_oper_v */
        Forward f;
        f=new Forward("armt_snai_oper_v",false,this,Forward.EditStatus,false);
        f.SetParameter("m_cAction","workflow");
        f.SetParameter("WorkFlowScript",_comando);
        f.SetParameter("m_cParameterSequence","m_cAction"+","+"WorkFlowScript");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
        /* Case pFlgT='Z' */
      } else if (CPLib.eqr(pFlgT,"Z")) {
        /* _comando := 'edit SNAINUMOPE="' + pNumOpe + '"' + NL + "@" + NL + "@SAVE"+ NL +"arrt_snai_oper_save" + NL + 'pSNAINUMOPE="%SNAINUMOPE%"' + NL +'pTipo="X"' + NL + 'pPage=""'+NL+ 'pAzi=""'+NL+"@DISCARD"+ NL + "arrt_void" */
        _comando = "edit SNAINUMOPE=\""+pNumOpe+"\""+"\n"+"@"+"\n"+"@SAVE"+"\n"+"arrt_snai_oper_save"+"\n"+"pSNAINUMOPE=\"%SNAINUMOPE%\""+"\n"+"pTipo=\"X\""+"\n"+"pPage=\"\""+"\n"+"pAzi=\"\""+"\n"+"@DISCARD"+"\n"+"arrt_void";
        /* Stop armt_snai_oper */
        Forward f;
        f=new Forward("armt_snai_oper",false,this,Forward.EditStatus,false);
        f.SetParameter("m_cAction","workflow");
        f.SetParameter("WorkFlowScript",_comando);
        f.SetParameter("m_cAtExit","close");
        f.SetParameter("m_cParameterSequence","m_cAction"+","+"WorkFlowScript"+","+"m_cAtExit");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End Case
    } finally {
      try {
        if (Cursor_cgo_operazioni!=null)
          Cursor_cgo_operazioni.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_operazioni_dl!=null)
          Cursor_cgo_operazioni_dl.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pNumOpe,String p_pFlgT,String p_pAgenzia) {
    pNumOpe = p_pNumOpe;
    pFlgT = p_pFlgT;
    pAgenzia = p_pAgenzia;
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
  public Forward Run(String p_pNumOpe,String p_pFlgT,String p_pAgenzia) {
    pNumOpe = p_pNumOpe;
    pFlgT = p_pFlgT;
    pAgenzia = p_pAgenzia;
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
  public static arrt_snai_oper_loadR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_snai_oper_loadR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pNumOpe = CPLib.Space(15);
    pFlgT = CPLib.Space(1);
    pAgenzia = CPLib.Space(6);
    _comando = "";
    _importo = 0;
    _dataope = CPLib.NullDate();
    _tipope = CPLib.Space(1);
    _dl = CPLib.Space(1);
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pNumOpe","pFlgT","pAgenzia"};
}
