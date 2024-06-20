// * --- Area Manuale = BO - Header
// * --- fn_app_new_version
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
// * --- Fine Area Manuale
public class fn_app_new_versionR implements CallerWithObjs {
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
  public String pAppl;
  public String pRelease;
  public String gTipInter;
  public String cRitorno;
  public String nomefile;
  public double _esito;
  public String _release;
  public String _suffisso;
  public String _messaggio;
  public String _risultato;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public fn_app_new_versionR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("fn_app_new_version",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "fn_app_new_version";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pAppl",p_cVarName)) {
      return pAppl;
    }
    if (CPLib.eqr("pRelease",p_cVarName)) {
      return pRelease;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("_release",p_cVarName)) {
      return _release;
    }
    if (CPLib.eqr("_suffisso",p_cVarName)) {
      return _suffisso;
    }
    if (CPLib.eqr("_messaggio",p_cVarName)) {
      return _messaggio;
    }
    if (CPLib.eqr("_risultato",p_cVarName)) {
      return _risultato;
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
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pAppl",p_cVarName)) {
      pAppl = value;
      return;
    }
    if (CPLib.eqr("pRelease",p_cVarName)) {
      pRelease = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("_release",p_cVarName)) {
      _release = value;
      return;
    }
    if (CPLib.eqr("_suffisso",p_cVarName)) {
      _suffisso = value;
      return;
    }
    if (CPLib.eqr("_messaggio",p_cVarName)) {
      _messaggio = value;
      return;
    }
    if (CPLib.eqr("_risultato",p_cVarName)) {
      _risultato = value;
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
    /* pAppl Char(4) */
    /* pRelease Char(20) */
    /* gTipInter Char(2) // Tipo Intermediario */
    /* cRitorno Char(80) := "" */
    cRitorno = "";
    /* _url Object(URL) */
    URL _url;
    _url = null;
    /* huc Object(HttpURLConnection) */
    HttpURLConnection huc;
    huc = null;
    /* nomefile Char(128) */
    /* _esito Numeric(5, 0) */
    /* _release Char(10) */
    /* _suffisso Char(10) */
    /* _messaggio Memo */
    /* instream Object(BufferedReader) */
    BufferedReader instream;
    instream = null;
    /* infile Object(InputStreamReader) */
    InputStreamReader infile;
    infile = null;
    /* response Object(StringBuffer) */
    StringBuffer response;
    response = null;
    /* _risultato Memo */
    /* If gTipInter<>'15' */
    if (CPLib.ne(gTipInter,"15")) {
      /* Case LRTrim(pAppl)='ANTI' */
      if (CPLib.eqr(CPLib.LRTrim(pAppl),"ANTI")) {
        /* _suffisso := 'ANTIWEB' */
        _suffisso = "ANTIWEB";
        /* Case LRTrim(pAppl)='AOS' */
      } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"AOS")) {
        /* _suffisso := 'AOSWEB' */
        _suffisso = "AOSWEB";
        /* Case LRTrim(pAppl)='PROT' */
      } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"PROT")) {
        /* _suffisso := 'PROTWEB' */
        _suffisso = "PROTWEB";
        /* Case LRTrim(pAppl)='UIC' */
      } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"UIC")) {
        /* _suffisso := 'UICWEB' */
        _suffisso = "UICWEB";
        /* Case LRTrim(pAppl)='OPE' */
      } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"OPE")) {
        /* _suffisso := 'OPEANWEB' */
        _suffisso = "OPEANWEB";
        /* Case LRTrim(pAppl)='CHK' */
      } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"CHK")) {
        /* _suffisso := 'CHECKWEB' */
        _suffisso = "CHECKWEB";
        /* Case LRTrim(pAppl)='FISC' */
      } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"FISC")) {
        /* _suffisso := 'FISCWEB' */
        _suffisso = "FISCWEB";
      } // End Case
      /* cRitorno := '' */
      cRitorno = "";
      /* nomefile := "https://softwareperfinanziarie.com/Aggiornamento_prog/verifica_aggiornamento.asp?id="+_suffisso+"&versione=last" */
      nomefile = "https://softwareperfinanziarie.com/Aggiornamento_prog/verifica_aggiornamento.asp?id="+_suffisso+"&versione=last";
      /* _url := new URL(nomefile) */
      _url = new URL(nomefile);
      huc=(HttpURLConnection)  _url.openConnection(); 
      /* huc.setRequestMethod("GET") */
      huc.setRequestMethod("GET");
      /* huc.setRequestProperty("User-Agent", "Mozilla/5.0") */
      huc.setRequestProperty("User-Agent","Mozilla/5.0");
      /* _esito := huc.getResponseCode() */
      _esito = CPLib.Round(huc.getResponseCode(),0);
      /* If _esito = HttpURLConnection.HTTP_OK */
      if (CPLib.eqr(_esito,HttpURLConnection.HTTP_OK)) {
        /* infile := new InputStreamReader(huc.getInputStream()) */
        infile = new InputStreamReader(huc.getInputStream());
        /* instream := new BufferedReader(infile) */
        instream = new BufferedReader(infile);
        /* response := new StringBuffer() */
        response = new StringBuffer();
        // Legge il responso
        while ((_messaggio = instream.readLine()) != null) {
          response.append(_messaggio);  
        }
        /* instream.close() */
        instream.close();
        /* _risultato := response.toString() */
        _risultato = response.toString();
        /* _release := Strtran(pRelease,'Versione ','') */
        _release = CPLib.Strtran(pRelease,"Versione ","");
        /* _release := Strtran(_release,'Release ','') */
        _release = CPLib.Strtran(_release,"Release ","");
        /* _suffisso := Right(LRTrim(_release),4)+Left(LRTrim(_release),At("/",LRTrim(_release)) -1) */
        _suffisso = CPLib.Right(CPLib.LRTrim(_release),4)+CPLib.Left(CPLib.LRTrim(_release),CPLib.At("/",CPLib.LRTrim(_release))-1);
        /* _risultato := Strtran(_risultato,'<head>','') */
        _risultato = CPLib.Strtran(_risultato,"<head>","");
        /* _risultato := Strtran(_risultato,'</head>','') */
        _risultato = CPLib.Strtran(_risultato,"</head>","");
        /* _risultato := Strtran(_risultato,'<body>','') */
        _risultato = CPLib.Strtran(_risultato,"<body>","");
        /* _risultato := Strtran(_risultato,'</body>','') */
        _risultato = CPLib.Strtran(_risultato,"</body>","");
        /* _risultato := LRTrim(_risultato) */
        _risultato = CPLib.LRTrim(_risultato);
        /* Case LRTrim(pAppl)='ANTI' */
        if (CPLib.eqr(CPLib.LRTrim(pAppl),"ANTI")) {
          /* _risultato := Strtran(_risultato,'Aggiorna_webanti_','') */
          _risultato = CPLib.Strtran(_risultato,"Aggiorna_webanti_","");
          /* _risultato := Strtran(_risultato,'.zip','') */
          _risultato = CPLib.Strtran(_risultato,".zip","");
          /* cRitorno := iif(_risultato >_suffisso,"E' disponibile la nuova versione di WEBANTI: "+Substr(_risultato,5,Len(_risultato)-4)+"/"+Left(_risultato,4),'') */
          cRitorno = (CPLib.gt(_risultato,_suffisso)?"E' disponibile la nuova versione di WEBANTI: "+CPLib.Substr(_risultato,5,CPLib.Len(_risultato)-4)+"/"+CPLib.Left(_risultato,4):"");
          /* Case LRTrim(pAppl)='AOS' */
        } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"AOS")) {
          /* _risultato := Strtran(_risultato,'Aggiorna_webaos_','') */
          _risultato = CPLib.Strtran(_risultato,"Aggiorna_webaos_","");
          /* _risultato := Strtran(_risultato,'.zip','') */
          _risultato = CPLib.Strtran(_risultato,".zip","");
          /* cRitorno := iif(_risultato > _suffisso,"E' disponibile la nuova versione di WEBAOS: "+Substr(_risultato,5,Len(_risultato)-4)+"/"+Left(_risultato,4),'') */
          cRitorno = (CPLib.gt(_risultato,_suffisso)?"E' disponibile la nuova versione di WEBAOS: "+CPLib.Substr(_risultato,5,CPLib.Len(_risultato)-4)+"/"+CPLib.Left(_risultato,4):"");
          /* Case LRTrim(pAppl)='PROT' */
        } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"PROT")) {
          /* _risultato := Strtran(_risultato,'Aggiorna_webprot_','') */
          _risultato = CPLib.Strtran(_risultato,"Aggiorna_webprot_","");
          /* _risultato := Strtran(_risultato,'.zip','') */
          _risultato = CPLib.Strtran(_risultato,".zip","");
          /* cRitorno := iif(_risultato > _suffisso,"E' disponibile la nuova versione di WEBPROT: "+Substr(_risultato,5,Len(_risultato)-4)+"/"+Left(_risultato,4),'') */
          cRitorno = (CPLib.gt(_risultato,_suffisso)?"E' disponibile la nuova versione di WEBPROT: "+CPLib.Substr(_risultato,5,CPLib.Len(_risultato)-4)+"/"+CPLib.Left(_risultato,4):"");
          /* Case LRTrim(pAppl)='UIC' */
        } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"UIC")) {
          /* _risultato := Strtran(_risultato,'Aggiorna_webuic_','') */
          _risultato = CPLib.Strtran(_risultato,"Aggiorna_webuic_","");
          /* _risultato := Strtran(_risultato,'.zip','') */
          _risultato = CPLib.Strtran(_risultato,".zip","");
          /* cRitorno := iif(_risultato > _suffisso,"E' disponibile la nuova versione di WEBUIC: "+Substr(_risultato,5,Len(_risultato)-4)+"/"+Left(_risultato,4),'') */
          cRitorno = (CPLib.gt(_risultato,_suffisso)?"E' disponibile la nuova versione di WEBUIC: "+CPLib.Substr(_risultato,5,CPLib.Len(_risultato)-4)+"/"+CPLib.Left(_risultato,4):"");
          /* Case LRTrim(pAppl)='OPE' */
        } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"OPE")) {
          /* _risultato := Strtran(_risultato,'Aggiorna_webope_','') */
          _risultato = CPLib.Strtran(_risultato,"Aggiorna_webope_","");
          /* _risultato := Strtran(_risultato,'.zip','') */
          _risultato = CPLib.Strtran(_risultato,".zip","");
          /* cRitorno := iif(_risultato > _suffisso,"E' disponibile la nuova versione di WEBOPE: "+Substr(_risultato,5,Len(_risultato)-4)+"/"+Left(_risultato,4),'') */
          cRitorno = (CPLib.gt(_risultato,_suffisso)?"E' disponibile la nuova versione di WEBOPE: "+CPLib.Substr(_risultato,5,CPLib.Len(_risultato)-4)+"/"+CPLib.Left(_risultato,4):"");
          /* Case LRTrim(pAppl)='CHK' */
        } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"CHK")) {
          /* _risultato := Strtran(_risultato,'Aggiorna_webchk_','') */
          _risultato = CPLib.Strtran(_risultato,"Aggiorna_webchk_","");
          /* _risultato := Strtran(_risultato,'.zip','') */
          _risultato = CPLib.Strtran(_risultato,".zip","");
          /* cRitorno := iif(_risultato > _suffisso,"E' disponibile la nuova versione di WEBCHK: "+Substr(_risultato,5,Len(_risultato)-4)+"/"+Left(_risultato,4),'') */
          cRitorno = (CPLib.gt(_risultato,_suffisso)?"E' disponibile la nuova versione di WEBCHK: "+CPLib.Substr(_risultato,5,CPLib.Len(_risultato)-4)+"/"+CPLib.Left(_risultato,4):"");
          /* Case LRTrim(pAppl)='FISC' */
        } else if (CPLib.eqr(CPLib.LRTrim(pAppl),"FISC")) {
          /* _risultato := Strtran(_risultato,'Aggiorna_webfisc_','') */
          _risultato = CPLib.Strtran(_risultato,"Aggiorna_webfisc_","");
          /* _risultato := Strtran(_risultato,'.zip','') */
          _risultato = CPLib.Strtran(_risultato,".zip","");
          /* cRitorno := iif(_risultato > _suffisso,"E' disponibile la nuova versione di WEBFISC: "+Substr(_risultato,5,Len(_risultato)-4)+"/"+Left(_risultato,4),'') */
          cRitorno = (CPLib.gt(_risultato,_suffisso)?"E' disponibile la nuova versione di WEBFISC: "+CPLib.Substr(_risultato,5,CPLib.Len(_risultato)-4)+"/"+CPLib.Left(_risultato,4):"");
        } // End Case
      } else { // Else
        /* cRitorno := "Impossibile verificare la presenza di una nuova versione" */
        cRitorno = "Impossibile verificare la presenza di una nuova versione";
      } // End If
    } // End If
    /* Return cRitorno */
    throw new Stop(cRitorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pAppl,String p_pRelease) {
    pAppl = p_pAppl;
    pRelease = p_pRelease;
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
  public String Run(String p_pAppl,String p_pRelease) {
    pAppl = p_pAppl;
    pRelease = p_pRelease;
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
  public static fn_app_new_versionR Make(CPContext p_Ctx, Caller p_Caller) {
    return new fn_app_new_versionR(p_Ctx, p_Caller);
  }
  public static fn_app_new_versionR Make(CPContext p_Ctx) {
    return new fn_app_new_versionR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAppl = CPLib.Space(4);
    pRelease = CPLib.Space(20);
    cRitorno = "";
    nomefile = CPLib.Space(128);
    _esito = 0;
    _release = CPLib.Space(10);
    _suffisso = CPLib.Space(10);
    _messaggio = "";
    _risultato = "";
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,fn_app_new_version,
  public static final String i_InvokedRoutines = ",fn_app_new_version,";
  public static String[] m_cRunParameterNames={"pAppl","pRelease"};
}
