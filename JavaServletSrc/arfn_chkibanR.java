// * --- Area Manuale = BO - Header
// * --- arfn_chkiban
import org.apache.commons.lang.StringUtils;
import java.text.*;
import java.math.BigDecimal;
// * --- Fine Area Manuale
public class arfn_chkibanR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String pIBAN;
  public String pTipo;
  public boolean bRitorno;
  public double _i;
  public String _c;
  public double _v;
  public String _cerr;
  public String _s;
  public String _cc;
  public double _r;
  public String _rs;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chkibanR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arfn_chkiban",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_v",p_cVarName)) {
      return _v;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      return _r;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_chkiban";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pIBAN",p_cVarName)) {
      return pIBAN;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("_c",p_cVarName)) {
      return _c;
    }
    if (CPLib.eqr("_cerr",p_cVarName)) {
      return _cerr;
    }
    if (CPLib.eqr("_s",p_cVarName)) {
      return _s;
    }
    if (CPLib.eqr("_cc",p_cVarName)) {
      return _cc;
    }
    if (CPLib.eqr("_rs",p_cVarName)) {
      return _rs;
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
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      return bRitorno;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_v",p_cVarName)) {
      _v = value;
      return;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      _r = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pIBAN",p_cVarName)) {
      pIBAN = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("_c",p_cVarName)) {
      _c = value;
      return;
    }
    if (CPLib.eqr("_cerr",p_cVarName)) {
      _cerr = value;
      return;
    }
    if (CPLib.eqr("_s",p_cVarName)) {
      _s = value;
      return;
    }
    if (CPLib.eqr("_cc",p_cVarName)) {
      _cc = value;
      return;
    }
    if (CPLib.eqr("_rs",p_cVarName)) {
      _rs = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bRitorno",p_cVarName)) {
      bRitorno = value;
      return;
    }
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
    /* Parametro */
    /* pIBAN Char(40) // IBAN (Solo per Italia o Postale) */
    /* pTipo Char(1) // Tipo Bonifico (I=Italia,E=Estero,P=Postale) */
    /* Definizioni variabili locali */
    /* bRitorno Bool */
    /* _i Numeric(2, 0) */
    /* _c Char(1) */
    /* _i Numeric(2, 0) */
    /* _c Char(1) */
    /* _v Numeric(2, 0) */
    /* _cerr Char(1) */
    /* _s Char(50) */
    /* _cc Char(8) */
    /* _r Numeric(10, 0) */
    /* _rs Char(8) */
    /* Presuppone che sia tutto a posto */
    /* bRitorno := True */
    bRitorno = true;
    /* Verifica la lunghezza */
    /* If pTipo='I' or pTipo='P' */
    if (CPLib.eqr(pTipo,"I") || CPLib.eqr(pTipo,"P")) {
      /* If Upper(Left(pIBAN,2))<>'IT' */
      if (CPLib.ne(CPLib.Upper(CPLib.Left(pIBAN,2)),"IT")) {
        /* bRitorno := False */
        bRitorno = false;
        /* Error Msg "Il codice IBAN deve iniziare con la stringa IT " */
        m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Il codice IBAN deve iniziare con la stringa IT ");
        new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
      } // End If
      /* If bRitorno */
      if (bRitorno) {
        /* If Len(LRTrim(pIBAN)) < 27 */
        if (CPLib.lt(CPLib.Len(CPLib.LRTrim(pIBAN)),27)) {
          /* bRitorno := False */
          bRitorno = false;
          /* Error Msg "La lunghezza dell'IBAN deve essere di 27 caratteri" */
          m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"La lunghezza dell'IBAN deve essere di 27 caratteri");
          new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
        } else { // Else
          /* _cerr := 'N' */
          _cerr = "N";
          for (int _i = 1; CPLib.ne(_i,27); _i = _i + (1)) {
            /* _c := Substr(pIBAN,_i,1) */
            _c = CPLib.Substr(pIBAN,_i,1);
            /* _v := Asc(_c) */
            _v = CPLib.Round(CPLib.Asc(_c),0);
            /* If _v < 48 or _v > 90 or _c = '<' or _c = '=' or _c = '>' or _c = '?' or _c = '@' or _c = ':' or _c = ';' */
            if (CPLib.lt(_v,48) || CPLib.gt(_v,90) || CPLib.eqr(_c,"<") || CPLib.eqr(_c,"=") || CPLib.eqr(_c,">") || CPLib.eqr(_c,"?") || CPLib.eqr(_c,"@") || CPLib.eqr(_c,":") || CPLib.eqr(_c,";")) {
              /* _cerr := 'S' */
              _cerr = "S";
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
            /* If _v < 65 */
            if (CPLib.lt(_v,65)) {
              /* _s := _s + _c */
              _s = _s+_c;
            } else { // Else
              /* _s := _s+ LRTrim(Str((_v - 55),2,0)) */
              _s = _s+CPLib.LRTrim(CPLib.Str((_v-55),2,0));
            } // End If
          }
          /* If _cerr='S' */
          if (CPLib.eqr(_cerr,"S")) {
            /* bRitorno := False */
            bRitorno = false;
            /* Error Msg "Presenza di caratteri non validi nell'IBAN" */
            m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"Presenza di caratteri non validi nell'IBAN");
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
          } else { // Else
            // Controllo validità
            String rearrangedIban = StringUtils.substring(pIBAN, 4).concat(StringUtils.substring(pIBAN, 0, 4));
            StringCharacterIterator iterator = new StringCharacterIterator(rearrangedIban);
            StringBuilder builder = new StringBuilder();
            for(char ch = iterator.first(); ch != CharacterIterator.DONE; ch = iterator.next()) {
              if(ch >= 'A' && ch <= 'Z') {
                int valorePerIban = ch - 55;
                builder.append(valorePerIban);
              } else {
                builder.append(ch);
              }
            }
            BigDecimal ibanConvertito = new BigDecimal(builder.toString());
            BigDecimal resto = ibanConvertito.remainder(BigDecimal.valueOf(97));
            if(resto.intValue() != 1) {
              bRitorno=false;
            /* Error Msg "IBAN non scritto correttamente. Verificare" */
            m_cLastMsgError = CPLib.FormatMsg(m_Ctx,"IBAN non scritto correttamente. Verificare");
            new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
            /* } */
            };
          } // End If
        } // End If
      } // End If
    } // End If
    /* Return bRitorno */
    throw new Stop(bRitorno);
  }
  void _init_() {
  }
  public String RunAsync(String p_pIBAN,String p_pTipo) {
    pIBAN = p_pIBAN;
    pTipo = p_pTipo;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public boolean Run(String p_pIBAN,String p_pTipo) {
    pIBAN = p_pIBAN;
    pTipo = p_pTipo;
    return Run();
  }
  public boolean Run() {
    boolean l_result;
    l_result = false;
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
        l_result = stop_value.GetLogic();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = false;
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
  public static arfn_chkibanR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chkibanR(p_Ctx, p_Caller);
  }
  public static arfn_chkibanR Make(CPContext p_Ctx) {
    return new arfn_chkibanR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pIBAN = CPLib.Space(40);
    pTipo = CPLib.Space(1);
    bRitorno = false;
    _i = 0;
    _c = CPLib.Space(1);
    _v = 0;
    _cerr = CPLib.Space(1);
    _s = CPLib.Space(50);
    _cc = CPLib.Space(8);
    _r = 0;
    _rs = CPLib.Space(8);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chkiban,
  public static final String i_InvokedRoutines = ",arfn_chkiban,";
  public static String[] m_cRunParameterNames={"pIBAN","pTipo"};
}
