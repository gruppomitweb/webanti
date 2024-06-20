// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_estrai_sv_checkR implements CallerWithObjs {
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
  public double pAnno;
  public double pTri;
  public String _datini;
  public String _datfin;
  public String cRitorno;
  public String fhand;
  public String riga;
  public String nFile;
  public double conta;
  public String outFileName;
  public String gAzienda;
  public String gIntemediario;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_estrai_sv_checkR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_estrai_sv_check",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      return pTri;
    }
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
      return "arrt_estrai_sv_check";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("nFile",p_cVarName)) {
      return nFile;
    }
    if (CPLib.eqr("outFileName",p_cVarName)) {
      return outFileName;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
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
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      pTri = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("nFile",p_cVarName)) {
      nFile = value;
      return;
    }
    if (CPLib.eqr("outFileName",p_cVarName)) {
      outFileName = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    /* pAnno Numeric(4, 0) // Anno di riferimento */
    /* pTri Numeric(1, 0) // Trimestre */
    /* _datini Char(8) // Data Inizio Trimestre */
    /* _datfin Char(8) // Data Fine Trimestre */
    /* cRitorno Char(20) */
    /* fhand Char(1) // Per gestione file */
    /* riga Memo */
    /* nFile Char(20) */
    /* conta Numeric(10, 0) */
    /* outFileName Char(30) */
    /* gAzienda Char(10) // Azienda */
    /* gIntemediario Char(11) // Intermediario */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Char(120) // Messaggio */
    /* Case pTri=1 */
    if (CPLib.eqr(pTri,1)) {
      /* _datini := Str(pAnno,4,0)+'0101' // Data Inizio Trimestre */
      _datini = CPLib.Str(pAnno,4,0)+"0101";
      /* _datfin := Str(pAnno,4,0)+'0331' // Data Fine Trimestre */
      _datfin = CPLib.Str(pAnno,4,0)+"0331";
      /* Case pTri=2 */
    } else if (CPLib.eqr(pTri,2)) {
      /* _datini := Str(pAnno,4,0)+'0401' // Data Inizio Trimestre */
      _datini = CPLib.Str(pAnno,4,0)+"0401";
      /* _datfin := Str(pAnno,4,0)+'0630' // Data Fine Trimestre */
      _datfin = CPLib.Str(pAnno,4,0)+"0630";
      /* Case pTri=3 */
    } else if (CPLib.eqr(pTri,3)) {
      /* _datini := Str(pAnno,4,0)+'0701' // Data Inizio Trimestre */
      _datini = CPLib.Str(pAnno,4,0)+"0701";
      /* _datfin := Str(pAnno,4,0)+'0930' // Data Fine Trimestre */
      _datfin = CPLib.Str(pAnno,4,0)+"0930";
      /* Case pTri=4 */
    } else if (CPLib.eqr(pTri,4)) {
      /* _datini := Str(pAnno,4,0)+'1001' // Data Inizio Trimestre */
      _datini = CPLib.Str(pAnno,4,0)+"1001";
      /* _datfin := Str(pAnno,4,0)+'1231' // Data Fine Trimestre */
      _datfin = CPLib.Str(pAnno,4,0)+"1231";
    } // End Case
    /* outFileName := "CheckSV_"+LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_"+Str(pTri,1,0) */
    outFileName = "CheckSV_"+CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_"+CPLib.Str(pTri,1,0);
    /* Stop arrp_estrai_sv_chk.vrp */
    Forward f;
    f=new Forward("Report",false,this,Forward.Start,false);
    f.SetParameter("pDADATA",_datini);
    f.SetParameter("pA_DATA",_datfin);
    f.SetParameter("hideCover",true);
    f.SetParameter("hideLanguage",true);
    f.SetParameter("hidePreview",true);
    f.SetParameter("hideParameterMask",true);
    f.SetParameter("hideSettings",true);
    f.SetParameter("FileName",CPLib.LRTrim(outFileName));
    f.SetParameter("ReportName","arrp_estrai_sv_chk.vrp");
    f.SetParameter("m_cParameterSequence","pDADATA"+","+"pA_DATA"+","+"hideCover"+","+"hideLanguage"+","+"hidePreview"+","+"hideParameterMask"+","+"hideSettings"+","+"FileName"+","+"ReportName");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
  }
  void _init_() {
  }
  public String RunAsync(double p_pAnno,double p_pTri) {
    pAnno = p_pAnno;
    pTri = p_pTri;
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
  public Forward Run(double p_pAnno,double p_pTri) {
    pAnno = p_pAnno;
    pTri = p_pTri;
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
  public static arrt_estrai_sv_checkR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_estrai_sv_checkR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pAnno = 0;
    pTri = 0;
    _datini = CPLib.Space(8);
    _datfin = CPLib.Space(8);
    cRitorno = CPLib.Space(20);
    fhand = CPLib.Space(1);
    riga = "";
    nFile = CPLib.Space(20);
    conta = 0;
    outFileName = CPLib.Space(30);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pAnno","pTri"};
}
