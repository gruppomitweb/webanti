// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class aosfn_unifoniaR implements CallerWithObjs {
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
  public String pStr;
  public String pBlk;
  public String _stringa1;
  public String _stringa2;
  public String _stringaf;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public aosfn_unifoniaR (CPContext p_ContextObject, Caller caller) {
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
                                all'oggetto globale (unico per pi˘ istanze di una stessa applicazione)
                                per recuperare informazioni sul:
                                1) nome fisico della tabella di gestione;
                                2) nome fisico delle tabelle collegate nei link;
                                3) stringa di connessione.
                                L'azienda Ë contenuta nel global object.
                             */
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("aosfn_unifonia",m_Caller);
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
      return "aosfn_unifonia";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pStr",p_cVarName)) {
      return pStr;
    }
    if (CPLib.eqr("pBlk",p_cVarName)) {
      return pBlk;
    }
    if (CPLib.eqr("_stringa1",p_cVarName)) {
      return _stringa1;
    }
    if (CPLib.eqr("_stringa2",p_cVarName)) {
      return _stringa2;
    }
    if (CPLib.eqr("_stringaf",p_cVarName)) {
      return _stringaf;
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
    if (CPLib.eqr("pStr",p_cVarName)) {
      pStr = value;
      return;
    }
    if (CPLib.eqr("pBlk",p_cVarName)) {
      pBlk = value;
      return;
    }
    if (CPLib.eqr("_stringa1",p_cVarName)) {
      _stringa1 = value;
      return;
    }
    if (CPLib.eqr("_stringa2",p_cVarName)) {
      _stringa2 = value;
      return;
    }
    if (CPLib.eqr("_stringaf",p_cVarName)) {
      _stringaf = value;
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
    /* pStr Char(100) */
    /* pBlk Char(100) */
    /* Definizione variabili locali */
    /* _stringa1 Char(100) */
    /* _stringa2 Char(100) */
    /* _stringaf Char(100) */
    /* Lancia la prima parte del controllo */
    /* _stringa1 := LRTrim(Upper(pStr)) */
    _stringa1 = CPLib.LRTrim(CPLib.Upper(pStr));
    /* Exec "NoDoppiFonici" Page 2:Page_2 */
    Page_2();
    /* Exec "CambiaFonici" Page 3: */
    Page_3();
    /* Return _stringaf */
    throw new Stop(_stringaf);
  }
  void Page_2() throws Exception {
    /* _c Numeric(10, 0) */
    double _c;
    _c = 0;
    /* _l Numeric(10, 0) */
    double _l;
    _l = 0;
    /* _i Numeric(10, 0) */
    double _i;
    _i = 0;
    /* _xst Char(100) */
    String _xst;
    _xst = CPLib.Space(100);
    /* _wc Char(1) */
    String _wc;
    _wc = CPLib.Space(1);
    /* _vocali Char(100) */
    String _vocali;
    _vocali = CPLib.Space(100);
    /* _st1 Char(100) */
    String _st1;
    _st1 = CPLib.Space(100);
    /* _car Char(1) */
    String _car;
    _car = CPLib.Space(1);
    /* Assegna valori alle variabili */
    /* _st1 := _stringa1 */
    _st1 = _stringa1;
    /* _xst := "" */
    _xst = "";
    /* _wc := "?" */
    _wc = "?";
    /* _vocali := 'AEIOU' */
    _vocali = "AEIOU";
    /* _c := At("H",_st1) */
    _c = CPLib.Round(CPLib.At("H",_st1),0);
    /* Toglie le H dalla stringa */
    /* While _c <> 0 */
    while (CPLib.ne(_c,0)) {
      /* If _c > 1 */
      if (CPLib.gt(_c,1)) {
        /* If At(Substr(_stringa1,_c-1,1),_vocali) <> 0 and At(Substr(_stringa1,_c+1,1),_vocali) <> 0 */
        if (CPLib.ne(CPLib.At(CPLib.Substr(_stringa1,_c-1,1),_vocali),0) && CPLib.ne(CPLib.At(CPLib.Substr(_stringa1,_c+1,1),_vocali),0)) {
          /* _stringa1 := Left(_stringa1,_c-1)+Substr(_stringa1,_c+1) */
          _stringa1 = CPLib.Left(_stringa1,_c-1)+CPLib.Substr(_stringa1,_c+1);
        } // End If
      } // End If
      /* _st1 := Left(_st1,_c-1)+Substr(_st1,_c+1) */
      _st1 = CPLib.Left(_st1,_c-1)+CPLib.Substr(_st1,_c+1);
      /* _c := At("H",_st1) */
      _c = CPLib.Round(CPLib.At("H",_st1),0);
    } // End While
    /* _l := Len(LRTrim(_stringa1)) */
    _l = CPLib.Round(CPLib.Len(CPLib.LRTrim(_stringa1)),0);
    /* _i := 1 */
    _i = CPLib.Round(1,0);
    /* While _i <= _l */
    while (CPLib.le(_i,_l)) {
      /* _car := Substr(_stringa1,_i,1) */
      _car = CPLib.Substr(_stringa1,_i,1);
      /* If _car <> _wc or _car='O' or _car ='E' */
      if (CPLib.ne(_car,_wc) || CPLib.eqr(_car,"O") || CPLib.eqr(_car,"E")) {
        /* _xst := _xst + _car */
        _xst = _xst+_car;
        /* _wc := _car */
        _wc = _car;
      } // End If
      /* _i := _i + 1 */
      _i = CPLib.Round(_i+1,0);
    } // End While
    /* _stringa2 := _xst */
    _stringa2 = _xst;
  }
  void Page_3() throws Exception {
    /* _l Numeric(10, 0) */
    double _l;
    _l = 0;
    /* _i Numeric(10, 0) */
    double _i;
    _i = 0;
    /* _xst Char(100) */
    String _xst;
    _xst = CPLib.Space(100);
    /* _pc Char(1) */
    String _pc;
    _pc = CPLib.Space(1);
    /* _ppc Char(1) */
    String _ppc;
    _ppc = CPLib.Space(1);
    /* _car Char(3) */
    String _car;
    _car = CPLib.Space(3);
    /* _st1 Char(100) */
    String _st1;
    _st1 = CPLib.Space(100);
    /* Assegna valori alle variabili */
    /* _pc := "#" */
    _pc = "#";
    /* _ppc := "#" */
    _ppc = "#";
    /* _xst := "" */
    _xst = "";
    /* _car := "" */
    _car = "";
    /* _l := Len(LRTrim(_stringa2)) */
    _l = CPLib.Round(CPLib.Len(CPLib.LRTrim(_stringa2)),0);
    /* _i := 1 */
    _i = CPLib.Round(1,0);
    /* While _i <= _l */
    while (CPLib.le(_i,_l)) {
      /* _car := Substr(_stringa2,_i,1) */
      _car = CPLib.Substr(_stringa2,_i,1);
      /* Case At(LRTrim(_car),"«ﬂä") <> 0  */
      if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"«ﬂ\u0160"),0)) {
        /* _car := "S" */
        _car = "S";
        /* Case At(LRTrim(_car),"&Ä∆«»… À") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"&\u20ac∆«»… À"),0)) {
        /* _car := "E" */
        _car = "E";
        /* Case At(LRTrim(_car),"“”‘’÷") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"“”‘’÷"),0)) {
        /* _car := "O" */
        _car = "O";
        /* Case At(LRTrim(_car),"¿¡¬√ƒ≈") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"¿¡¬√ƒ≈"),0)) {
        /* _car := "A" */
        _car = "A";
        /* Case At(LRTrim(_car),"Ÿ⁄€‹") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"Ÿ⁄€‹"),0)) {
        /* _car := "U" */
        _car = "U";
        /* Case At(LRTrim(_car),"é") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"\u017d"),0)) {
        /* _car := "G" */
        _car = "G";
        /* Case At(LRTrim(_car),"—") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"—"),0)) {
        /* _car := "N" */
        _car = "N";
        /* Case At(LRTrim(_car),"ÿ") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"ÿ"),0)) {
        /* _car := "F" */
        _car = "F";
        /* Case At(_ppc+_pc+LRTrim(_car),"DZI|DZJ|DZH") <> 0 */
      } else if (CPLib.ne(CPLib.At(_ppc+_pc+CPLib.LRTrim(_car),"DZI|DZJ|DZH"),0)) {
        /* _car := "G" */
        _car = "G";
        /* _xst := Left(_xst,Len(_xst) - 2) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-2);
        /* Case At(_ppc+_pc+LRTrim(_car),"TIO|CIO|TIA|TIE|ZIO|ZIA|ZIE|") <> 0 */
      } else if (CPLib.ne(CPLib.At(_ppc+_pc+CPLib.LRTrim(_car),"TIO|CIO|TIA|TIE|ZIO|ZIA|ZIE|"),0)) {
        /* _car := "ZI"+ _car */
        _car = "ZI"+_car;
        /* _xst := Left(_xst,Len(_xst) - 2) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-2);
        /* Case At(_ppc+_pc+LRTrim(_car),"|SHI|TSH|TCH|SCI") <> 0 */
      } else if (CPLib.ne(CPLib.At(_ppc+_pc+CPLib.LRTrim(_car),"|SHI|TSH|TCH|SCI"),0)) {
        /* _car := "C" */
        _car = "C";
        /* _xst := Left(_xst,Len(_xst) - 2) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-2);
        /* Case At(_ppc+_pc+LRTrim(_car)," OO") <> 0 */
      } else if (CPLib.ne(CPLib.At(_ppc+_pc+CPLib.LRTrim(_car)," OO"),0)) {
        /* _car := "O" */
        _car = "O";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"EE|GI|JI|IJ|YI|IY|DJ") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"EE|GI|JI|IJ|YI|IY|DJ"),0)) {
        /* _car := "I" */
        _car = "I";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"CI|CE|SH|CH") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"CI|CE|SH|CH"),0)) {
        /* _car := "C" */
        _car = "C";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"PH") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"PH"),0)) {
        /* _car := "F" */
        _car = "F";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"GE") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"GE"),0)) {
        /* _car := "IE" */
        _car = "IE";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"WA") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"WA"),0)) {
        /* _car := "UA" */
        _car = "UA";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"WE") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"WE"),0)) {
        /* _car := "UE" */
        _car = "UE";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"WI") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"WI"),0)) {
        /* _car := "UI" */
        _car = "UI";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"WO") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"WO"),0)) {
        /* _car := "UO" */
        _car = "UO";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"BV") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"BV"),0)) {
        /* _car := "V" */
        _car = "V";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"BD|DB") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"BD|DB"),0)) {
        /* _car := "D" */
        _car = "D";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"OO|OU") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"OO|OU"),0)) {
        /* _car := "U" */
        _car = "U";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(_pc+LRTrim(_car),"UO|OE") <> 0 */
      } else if (CPLib.ne(CPLib.At(_pc+CPLib.LRTrim(_car),"UO|OE"),0)) {
        /* _car := "O" */
        _car = "O";
        /* _xst := Left(_xst,Len(_xst) - 1) */
        _xst = CPLib.Left(_xst,CPLib.Len(_xst)-1);
        /* Case At(LRTrim(_car)," |-") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car)," |-"),0)) {
        /* _car := LRTrim(pBlk) */
        _car = CPLib.LRTrim(pBlk);
        /* Case At(LRTrim(_car),"H'.,") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"H'.,"),0)) {
        /* _car := "" */
        _car = "";
        /* Case At(LRTrim(_car),'"') <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"\""),0)) {
        /* _car := "" */
        _car = "";
        /* Case At(LRTrim(_car),"KCQ") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"KCQ"),0)) {
        /* _car := "K" */
        _car = "K";
        /* Case At(LRTrim(_car),"IJYüÃÕŒœ›") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"IJY\u0178ÃÕŒœ›"),0)) {
        /* _car := "I" */
        _car = "I";
        /* Case At(LRTrim(_car),"ZS") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"ZS"),0)) {
        /* _car := "S" */
        _car = "S";
        /* Case At(LRTrim(_car),"&") <> 0 */
      } else if (CPLib.ne(CPLib.At(CPLib.LRTrim(_car),"&"),0)) {
        /* _car := "E" */
        _car = "E";
      } // End Case
      /* If _i > 1 */
      if (CPLib.gt(_i,1)) {
        /* _ppc := Substr(_stringa2,_i - 1,1) */
        _ppc = CPLib.Substr(_stringa2,_i-1,1);
      } else { // Else
        /* _ppc := "#" */
        _ppc = "#";
      } // End If
      /* _ppc := Substr(_stringa2,_i,1) */
      _ppc = CPLib.Substr(_stringa2,_i,1);
      /* _xst := _xst + LRTrim(_car) */
      _xst = _xst+CPLib.LRTrim(_car);
      /* _i := _i + 1 */
      _i = CPLib.Round(_i+1,0);
    } // End While
    /* _stringaf := _xst */
    _stringaf = _xst;
  }
  void _init_() {
  }
  public String RunAsync(String p_pStr,String p_pBlk) {
    pStr = p_pStr;
    pBlk = p_pBlk;
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
  public String Run(String p_pStr,String p_pBlk) {
    pStr = p_pStr;
    pBlk = p_pBlk;
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
  public static aosfn_unifoniaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new aosfn_unifoniaR(p_Ctx, p_Caller);
  }
  public static aosfn_unifoniaR Make(CPContext p_Ctx) {
    return new aosfn_unifoniaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pStr = CPLib.Space(100);
    pBlk = CPLib.Space(100);
    _stringa1 = CPLib.Space(100);
    _stringa2 = CPLib.Space(100);
    _stringaf = CPLib.Space(100);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,aosfn_unifonia,
  public static final String i_InvokedRoutines = ",aosfn_unifonia,";
  public static String[] m_cRunParameterNames={"pStr","pBlk"};
}
