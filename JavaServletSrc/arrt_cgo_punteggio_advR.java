// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_punteggio_advR implements CallerWithObjs {
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
  public armt_cgo_qadv_operazioniBL pObj;
  public String _completa;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_punteggio_advR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_punteggio_adv",m_Caller);
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
      return "arrt_cgo_punteggio_adv";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_completa",p_cVarName)) {
      return _completa;
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
    if (CPLib.eqr("_completa",p_cVarName)) {
      _completa = value;
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
    /* pObj Object(armt_cgo_qadv_operazioniBL) // Numero Domanda */
    /* _completa Char(1) */
    /* pObj.w_QADV_TOTALE := 0 // Numero Domanda */
    pObj.w_QADV_TOTALE = 0;
    /* _completa := 'S' */
    _completa = "S";
    /* pObj.w_QADV_PUNTEGGIO01 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO01 = 0;
    /* If pObj.w_QADV_DOMANDA01=0 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA01,0)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* Case pObj.w_QADV_DOMANDA01=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA01,1)) {
      /* pObj.w_QADV_PUNTEGGIO01 := 15 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO01 = 15;
      /* Case pObj.w_QADV_DOMANDA01=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA01,2)) {
      /* pObj.w_QADV_PUNTEGGIO01 := 5 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO01 = 5;
      /* Case pObj.w_QADV_DOMANDA01=3 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA01,3)) {
      /* pObj.w_QADV_PUNTEGGIO01 := 1 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO01 = 1;
      /* Case pObj.w_QADV_DOMANDA01=4 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA01,4)) {
      /* pObj.w_QADV_PUNTEGGIO01 := 1 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO01 = 1;
    } // End Case
    /* If pObj.w_QADV_DOMANDA02=0 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA02,0)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO02 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO02 = 0;
    /* Case pObj.w_QADV_DOMANDA02=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA02,1)) {
      /* pObj.w_QADV_PUNTEGGIO02 := 15 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO02 = 15;
      /* Case pObj.w_QADV_DOMANDA02=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA02,2)) {
      /* pObj.w_QADV_PUNTEGGIO02 := 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO02 = 10;
      /* Case pObj.w_QADV_DOMANDA02=3 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA02,3)) {
      /* pObj.w_QADV_PUNTEGGIO02 := 3 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO02 = 3;
      /* Case pObj.w_QADV_DOMANDA02=4 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA02,4)) {
      /* pObj.w_QADV_PUNTEGGIO02 := 0 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO02 = 0;
    } // End Case
    /* If pObj.w_QADV_DOMANDA03=0 or (pObj.w_QADV_DOMANDA03=2 and pObj.w_QADV_DOMANDA03_1='N' and pObj.w_QADV_DOMANDA03_2='N' and pObj.w_QADV_DOMANDA03_3='N') */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA03,0) || (CPLib.eqr(pObj.w_QADV_DOMANDA03,2) && CPLib.eqr(pObj.w_QADV_DOMANDA03_1,"N") && CPLib.eqr(pObj.w_QADV_DOMANDA03_2,"N") && CPLib.eqr(pObj.w_QADV_DOMANDA03_3,"N"))) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO03 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO03 = 0;
    /* Case pObj.w_QADV_DOMANDA03=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA03,1)) {
      /* pObj.w_QADV_PUNTEGGIO03 := 1 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO03 = 1;
      /* Case pObj.w_QADV_DOMANDA03=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA03,2)) {
      /* pObj.w_QADV_PUNTEGGIO03 := 15 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO03 = 15;
    } // End Case
    /* If pObj.w_QADV_DOMANDA03_1='S' */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA03_1,"S")) {
      /* pObj.w_QADV_PUNTEGGIO03 := pObj.w_QADV_PUNTEGGIO03 + 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO03 = pObj.w_QADV_PUNTEGGIO03+10;
    } // End If
    /* If pObj.w_QADV_DOMANDA03_2='S' */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA03_2,"S")) {
      /* pObj.w_QADV_PUNTEGGIO03 := pObj.w_QADV_PUNTEGGIO03 + 15 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO03 = pObj.w_QADV_PUNTEGGIO03+15;
    } // End If
    /* If pObj.w_QADV_DOMANDA03_3='S' */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA03_3,"S")) {
      /* pObj.w_QADV_PUNTEGGIO03 := pObj.w_QADV_PUNTEGGIO03 + 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO03 = pObj.w_QADV_PUNTEGGIO03+10;
    } // End If
    /* If pObj.w_QADV_DOMANDA04=0 or (pObj.w_QADV_DOMANDA04=1 and pObj.w_QADV_DOMANDA04_1='N' and pObj.w_QADV_DOMANDA04_2='N' and pObj.w_QADV_DOMANDA04_3='N' and pObj.w_QADV_DOMANDA04_4='N') */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA04,0) || (CPLib.eqr(pObj.w_QADV_DOMANDA04,1) && CPLib.eqr(pObj.w_QADV_DOMANDA04_1,"N") && CPLib.eqr(pObj.w_QADV_DOMANDA04_2,"N") && CPLib.eqr(pObj.w_QADV_DOMANDA04_3,"N") && CPLib.eqr(pObj.w_QADV_DOMANDA04_4,"N"))) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO04 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO04 = 0;
    /* Case pObj.w_QADV_DOMANDA04=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA04,1)) {
      /* pObj.w_QADV_PUNTEGGIO04 := 0 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO04 = 0;
      /* Case pObj.w_QADV_DOMANDA04=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA04,2)) {
      /* pObj.w_QADV_PUNTEGGIO04 := 1 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO04 = 1;
    } // End Case
    /* If pObj.w_QADV_DOMANDA04_1='S' */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA04_1,"S")) {
      /* pObj.w_QADV_PUNTEGGIO04 := pObj.w_QADV_PUNTEGGIO04 + 20 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO04 = pObj.w_QADV_PUNTEGGIO04+20;
    } // End If
    /* If pObj.w_QADV_DOMANDA04_2='S' */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA04_2,"S")) {
      /* pObj.w_QADV_PUNTEGGIO04 := pObj.w_QADV_PUNTEGGIO04 + 15 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO04 = pObj.w_QADV_PUNTEGGIO04+15;
    } // End If
    /* If pObj.w_QADV_DOMANDA04_3='S' */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA04_3,"S")) {
      /* pObj.w_QADV_PUNTEGGIO04 := pObj.w_QADV_PUNTEGGIO04 + 15 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO04 = pObj.w_QADV_PUNTEGGIO04+15;
    } // End If
    /* If pObj.w_QADV_DOMANDA04_4='S' */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA04_4,"S")) {
      /* pObj.w_QADV_PUNTEGGIO04 := pObj.w_QADV_PUNTEGGIO04 + 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO04 = pObj.w_QADV_PUNTEGGIO04+10;
    } // End If
    /* If pObj.w_QADV_DOMANDA05=0 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA05,0)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO05 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO05 = 0;
    /* Case pObj.w_QADV_DOMANDA05=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA05,1)) {
      /* pObj.w_QADV_PUNTEGGIO05 := 30 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO05 = 30;
      /* Case pObj.w_QADV_DOMANDA05=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA05,2)) {
      /* pObj.w_QADV_PUNTEGGIO05 := 30 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO05 = 30;
      /* Case pObj.w_QADV_DOMANDA05=3 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA05,3)) {
      /* pObj.w_QADV_PUNTEGGIO05 := 30 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO05 = 30;
      /* Case pObj.w_QADV_DOMANDA05=4 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA05,4)) {
      /* pObj.w_QADV_PUNTEGGIO05 := 5 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO05 = 5;
      /* Case pObj.w_QADV_DOMANDA05=5 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA05,5)) {
      /* pObj.w_QADV_PUNTEGGIO05 := 15 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO05 = 15;
      /* Case pObj.w_QADV_DOMANDA05=6 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA05,6)) {
      /* pObj.w_QADV_PUNTEGGIO05 := 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO05 = 10;
    } // End Case
    /* If pObj.w_QADV_DOMANDA06=0 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA06,0)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO06 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO06 = 0;
    /* Case pObj.w_QADV_DOMANDA06=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA06,1)) {
      /* pObj.w_QADV_PUNTEGGIO06 := 0 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO06 = 0;
      /* Case pObj.w_QADV_DOMANDA06=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA06,2)) {
      /* pObj.w_QADV_PUNTEGGIO06 := 20 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO06 = 20;
    } // End Case
    /* If pObj.w_QADV_DOMANDA07=0 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA07,0)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO07 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO07 = 0;
    /* Case pObj.w_QADV_DOMANDA07=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA07,1)) {
      /* pObj.w_QADV_PUNTEGGIO07 := 1 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO07 = 1;
      /* Case pObj.w_QADV_DOMANDA07=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA07,2)) {
      /* pObj.w_QADV_PUNTEGGIO07 := 1 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO07 = 1;
      /* Case pObj.w_QADV_DOMANDA07=3 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA07,3)) {
      /* pObj.w_QADV_PUNTEGGIO07 := 1 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO07 = 1;
      /* Case pObj.w_QADV_DOMANDA07=4 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA07,4)) {
      /* pObj.w_QADV_PUNTEGGIO07 := 5 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO07 = 5;
      /* Case pObj.w_QADV_DOMANDA07=5 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA07,5)) {
      /* pObj.w_QADV_PUNTEGGIO07 := 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO07 = 10;
      /* Case pObj.w_QADV_DOMANDA07=6 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA07,6)) {
      /* pObj.w_QADV_PUNTEGGIO07 := 5 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO07 = 5;
    } // End Case
    /* If pObj.w_QADV_DOMANDA08=0 and pObj.w_QADV_DOMANDA07=6 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA08,0) && CPLib.eqr(pObj.w_QADV_DOMANDA07,6)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO08 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO08 = 0;
    /* Case pObj.w_QADV_DOMANDA08=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA08,1)) {
      /* pObj.w_QADV_PUNTEGGIO08 := 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO08 = 10;
      /* Case pObj.w_QADV_DOMANDA08=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA08,2)) {
      /* pObj.w_QADV_PUNTEGGIO08 := 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO08 = 10;
      /* Case pObj.w_QADV_DOMANDA08=3 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA08,3)) {
      /* pObj.w_QADV_PUNTEGGIO08 := 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO08 = 10;
    } // End Case
    /* If pObj.w_QADV_DOMANDA09=0 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA09,0)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO09 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO09 = 0;
    /* Case pObj.w_QADV_DOMANDA09=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA09,1)) {
      /* pObj.w_QADV_PUNTEGGIO09 := 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO09 = 10;
      /* Case pObj.w_QADV_DOMANDA09=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA09,2)) {
      /* pObj.w_QADV_PUNTEGGIO09 := 0 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO09 = 0;
    } // End Case
    /* If pObj.w_QADV_DOMANDA10=0 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA10,0)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO10 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO10 = 0;
    /* Case pObj.w_QADV_DOMANDA10=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA10,1)) {
      /* pObj.w_QADV_PUNTEGGIO10 := 5 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO10 = 5;
      /* Case pObj.w_QADV_DOMANDA10=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA10,2)) {
      /* pObj.w_QADV_PUNTEGGIO10 := 1 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO10 = 1;
    } // End Case
    /* If pObj.w_QADV_DOMANDA11=0 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA11,0)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO11 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO11 = 0;
    /* Case pObj.w_QADV_DOMANDA11=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA11,1)) {
      /* pObj.w_QADV_PUNTEGGIO11 := 10 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO11 = 10;
      /* Case pObj.w_QADV_DOMANDA11=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA11,2)) {
      /* pObj.w_QADV_PUNTEGGIO11 := 5 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO11 = 5;
    } // End Case
    /* If pObj.w_QADV_DOMANDA12=0 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA12,0)) {
      /* _completa := 'N' */
      _completa = "N";
    } // End If
    /* pObj.w_QADV_PUNTEGGIO12 := 0 // Numero Domanda */
    pObj.w_QADV_PUNTEGGIO12 = 0;
    /* Case pObj.w_QADV_DOMANDA12=1 */
    if (CPLib.eqr(pObj.w_QADV_DOMANDA12,1)) {
      /* pObj.w_QADV_PUNTEGGIO12 := 40 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO12 = 40;
      /* Case pObj.w_QADV_DOMANDA12=2 */
    } else if (CPLib.eqr(pObj.w_QADV_DOMANDA12,2)) {
      /* pObj.w_QADV_PUNTEGGIO12 := 5 // Numero Domanda */
      pObj.w_QADV_PUNTEGGIO12 = 5;
    } // End Case
    /* pObj.Set_QADV_FLGCOMPLETO(_completa) */
    pObj.Set_QADV_FLGCOMPLETO(_completa);
  }
  void _init_() {
  }
  public String RunAsync(armt_cgo_qadv_operazioniBL p_pObj) {
    pObj = p_pObj;
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
  public Forward Run(armt_cgo_qadv_operazioniBL p_pObj) {
    pObj = p_pObj;
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
  public static arrt_cgo_punteggio_advR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_punteggio_advR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pObj = null;
    _completa = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pObj"};
}
