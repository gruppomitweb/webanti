// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_chksoggR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_dip;
  public String m_cServer_personbo_dip;
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
  public String pNDG;
  public String pTipo;
  public String gTipInter;
  public String gCodDip;
  public String gVerSim;
  public String gVerImp;
  public boolean bRitorno;
  public String cConnes;
  public String mError;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_chksoggR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_chksogg",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_personbo_dip = p_ContextObject.GetPhName("personbo_dip");
    if (m_cPhName_personbo_dip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_dip = m_cPhName_personbo_dip+" "+m_Ctx.GetWritePhName("personbo_dip");
    }
    m_cServer_personbo_dip = p_ContextObject.GetServer("personbo_dip");
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
      return "arfn_chksogg";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNDG",p_cVarName)) {
      return pNDG;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      return gTipInter;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    if (CPLib.eqr("gVerSim",p_cVarName)) {
      return gVerSim;
    }
    if (CPLib.eqr("gVerImp",p_cVarName)) {
      return gVerImp;
    }
    if (CPLib.eqr("cConnes",p_cVarName)) {
      return cConnes;
    }
    if (CPLib.eqr("mError",p_cVarName)) {
      return mError;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pNDG",p_cVarName)) {
      pNDG = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("gTipInter",p_cVarName)) {
      gTipInter = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
    if (CPLib.eqr("gVerSim",p_cVarName)) {
      gVerSim = value;
      return;
    }
    if (CPLib.eqr("gVerImp",p_cVarName)) {
      gVerImp = value;
      return;
    }
    if (CPLib.eqr("cConnes",p_cVarName)) {
      cConnes = value;
      return;
    }
    if (CPLib.eqr("mError",p_cVarName)) {
      mError = value;
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
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* pNDG Char(16) // NDG Soggetto */
      /* pTipo Char(1) // Tipo AUI (2,3,4,5,6,7,8,9) */
      /* gTipInter Char(2) // Tipo Intermediario */
      /* gCodDip Char(6) // Dipendenza */
      /* gVerSim Char(1) // Verifica Semplificata */
      /* gVerImp Char(1) // Verifica da import */
      /* bRitorno Bool */
      /* cConnes Char(16) */
      /* mError Memo */
      /* mError := '' */
      mError = "";
      /* bRitorno := True */
      bRitorno = true;
      /* If gTipInter <> '99' and gVerImp = 'N' */
      if (CPLib.ne(gTipInter,"99") && CPLib.eqr(gVerImp,"N")) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNDG,"?",0,0,m_cServer, m_oParameters),m_cServer,pNDG)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* If personbo->TIPOPERS='G' */
          if (CPLib.eqr(Cursor_personbo.GetString("TIPOPERS"),"G")) {
            /* Case pTipo='2' or pTipo='3' or pTipo='7' */
            if (CPLib.eqr(pTipo,"2") || CPLib.eqr(pTipo,"3") || CPLib.eqr(pTipo,"7")) {
              /* If gVerSim='N' */
              if (CPLib.eqr(gVerSim,"N")) {
                /* If personbo->PAESE='086' or personbo->PAESE='139' */
                if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.eqr(Cursor_personbo.GetString("PAESE"),"139")) {
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA='EE' or Empty(personbo->DESCCIT) or Empty(personbo->DOMICILIO) or Empty(personbo->CODCAB) or Empty(personbo->CAP) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.eqr(Cursor_personbo.GetString("PROVINCIA"),"EE") || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("DOMICILIO")) || CPLib.Empty(Cursor_personbo.GetString("CODCAB")) || CPLib.Empty(Cursor_personbo.GetString("CAP"))) {
                    /* mError := 'Dati Residenza Errati o non completi' + NL */
                    mError = "Dati Residenza Errati o non completi"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } else { // Else
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA<>'EE' */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),"EE")) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } // End If
              } // End If
              /* If Empty(personbo->SETTSINT) or Empty(personbo->SOTGRUP) */
              if (CPLib.Empty(Cursor_personbo.GetString("SETTSINT")) || CPLib.Empty(Cursor_personbo.GetString("SOTGRUP"))) {
                /* mError := mError + 'Mancano i dati della settorizzazione sintetica' + NL */
                mError = mError+"Mancano i dati della settorizzazione sintetica"+"\n";
                /* bRitorno := False */
                bRitorno = false;
              } // End If
              /* Case pTipo='5' */
            } else if (CPLib.eqr(pTipo,"5")) {
              /* If gVerSim='N' */
              if (CPLib.eqr(gVerSim,"N")) {
                /* If personbo->PAESE='086' or personbo->PAESE='139' */
                if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.eqr(Cursor_personbo.GetString("PAESE"),"139")) {
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA='EE' or Empty(personbo->DESCCIT) or Empty(personbo->DOMICILIO) or Empty(personbo->CODCAB) or Empty(personbo->CAP) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.eqr(Cursor_personbo.GetString("PROVINCIA"),"EE") || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("DOMICILIO")) || CPLib.Empty(Cursor_personbo.GetString("CODCAB")) || CPLib.Empty(Cursor_personbo.GetString("CAP"))) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } else { // Else
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA<>'EE' */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),"EE")) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } // End If
              } // End If
              /* Case pTipo='8' */
            } else if (CPLib.eqr(pTipo,"8")) {
              /* If gVerSim='N' */
              if (CPLib.eqr(gVerSim,"N")) {
                /* If personbo->PAESE='086' or personbo->PAESE='139' */
                if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.eqr(Cursor_personbo.GetString("PAESE"),"139")) {
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA='EE' or Empty(personbo->DESCCIT) or Empty(personbo->DOMICILIO) or Empty(personbo->CODCAB) or Empty(personbo->CAP) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.eqr(Cursor_personbo.GetString("PROVINCIA"),"EE") || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("DOMICILIO")) || CPLib.Empty(Cursor_personbo.GetString("CODCAB")) || CPLib.Empty(Cursor_personbo.GetString("CAP"))) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } else { // Else
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA<>'EE' */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),"EE")) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } // End If
              } // End If
              /* Case pTipo='9' */
            } else if (CPLib.eqr(pTipo,"9")) {
              /* If gVerSim='N' */
              if (CPLib.eqr(gVerSim,"N")) {
                /* If personbo->PAESE='086' or personbo->PAESE='139' */
                if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.eqr(Cursor_personbo.GetString("PAESE"),"139")) {
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA='EE' or Empty(personbo->DESCCIT) or Empty(personbo->DOMICILIO) or Empty(personbo->CODCAB) or Empty(personbo->CAP) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.eqr(Cursor_personbo.GetString("PROVINCIA"),"EE") || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("DOMICILIO")) || CPLib.Empty(Cursor_personbo.GetString("CODCAB")) || CPLib.Empty(Cursor_personbo.GetString("CAP"))) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } else { // Else
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA<>'EE' */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),"EE")) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } // End If
              } // End If
            } // End Case
          } else { // Else
            /* Case pTipo='2' or pTipo='3' or pTipo='7' */
            if (CPLib.eqr(pTipo,"2") || CPLib.eqr(pTipo,"3") || CPLib.eqr(pTipo,"7")) {
              /* If gVerSim='N' */
              if (CPLib.eqr(gVerSim,"N")) {
                /* If personbo->PAESE='086' or personbo->PAESE='139' */
                if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.eqr(Cursor_personbo.GetString("PAESE"),"139")) {
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA='EE' or Empty(personbo->DESCCIT) or Empty(personbo->DOMICILIO) or Empty(personbo->CODCAB) or Empty(personbo->CAP) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.eqr(Cursor_personbo.GetString("PROVINCIA"),"EE") || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("DOMICILIO")) || CPLib.Empty(Cursor_personbo.GetString("CODCAB")) || CPLib.Empty(Cursor_personbo.GetString("CAP"))) {
                    /* mError := 'Dati Residenza Errati' + NL */
                    mError = "Dati Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* mError := mError + 'Manca il codice fiscale' + NL */
                    mError = mError+"Manca il codice fiscale"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } else { // Else
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA<>'EE' */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),"EE")) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } // End If
                /* If Empty(personbo->TIPINTER) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->SESSO)  */
                if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                  /* mError := mError + 'Mancano i dati di nascita' + NL */
                  mError = mError+"Mancano i dati di nascita"+"\n";
                  /* bRitorno := False */
                  bRitorno = false;
                } // End If
                /* If Empty(personbo->DATARILASC) or Empty(personbo->TIPODOC) or Empty(personbo->AUTRILASC) or Empty(personbo->NUMDOCUM) */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.Empty(Cursor_personbo.GetString("TIPODOC")) || CPLib.Empty(Cursor_personbo.GetString("AUTRILASC")) || CPLib.Empty(Cursor_personbo.GetString("NUMDOCUM"))) {
                  /* mError := mError + 'Mancano gli estremi del documento' + NL */
                  mError = mError+"Mancano gli estremi del documento"+"\n";
                  /* bRitorno := False */
                  bRitorno = false;
                } // End If
              } // End If
              /* If Empty(personbo->SETTSINT) or Empty(personbo->SOTGRUP) */
              if (CPLib.Empty(Cursor_personbo.GetString("SETTSINT")) || CPLib.Empty(Cursor_personbo.GetString("SOTGRUP"))) {
                /* mError := mError + 'Mancano i dati della settorizzazione sintetica' + NL */
                mError = mError+"Mancano i dati della settorizzazione sintetica"+"\n";
                /* bRitorno := False */
                bRitorno = false;
              } // End If
              /* Case pTipo='5' */
            } else if (CPLib.eqr(pTipo,"5")) {
              /* If gVerSim='N' */
              if (CPLib.eqr(gVerSim,"N")) {
                /* If personbo->PAESE='086' or personbo->PAESE='139' */
                if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.eqr(Cursor_personbo.GetString("PAESE"),"139")) {
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA='EE' or Empty(personbo->DESCCIT) or Empty(personbo->DOMICILIO) or Empty(personbo->CODCAB) or Empty(personbo->CAP) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.eqr(Cursor_personbo.GetString("PROVINCIA"),"EE") || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("DOMICILIO")) || CPLib.Empty(Cursor_personbo.GetString("CODCAB")) || CPLib.Empty(Cursor_personbo.GetString("CAP"))) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* mError := mError + 'Manca il codice fiscale' + NL */
                    mError = mError+"Manca il codice fiscale"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } else { // Else
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA<>'EE' */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),"EE")) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } // End If
              } // End If
              /* Case pTipo='6' */
            } else if (CPLib.eqr(pTipo,"6")) {
              /* If gVerSim='N' */
              if (CPLib.eqr(gVerSim,"N")) {
                /* If personbo->PAESE='086' or personbo->PAESE='139' */
                if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.eqr(Cursor_personbo.GetString("PAESE"),"139")) {
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA='EE' or Empty(personbo->DESCCIT) or Empty(personbo->DOMICILIO) or Empty(personbo->CODCAB) or Empty(personbo->CAP) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.eqr(Cursor_personbo.GetString("PROVINCIA"),"EE") || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("DOMICILIO")) || CPLib.Empty(Cursor_personbo.GetString("CODCAB")) || CPLib.Empty(Cursor_personbo.GetString("CAP"))) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* mError := mError + 'Manca il codice fiscale' + NL */
                    mError = mError+"Manca il codice fiscale"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } else { // Else
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA<>'EE' */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),"EE")) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } // End If
                /* If Empty(personbo->TIPINTER) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO))  or Empty(personbo->SESSO)  */
                if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                  /* mError := mError + 'Mancano i dati di nascita' + NL */
                  mError = mError+"Mancano i dati di nascita"+"\n";
                  /* bRitorno := False */
                  bRitorno = false;
                } // End If
                /* If Empty(personbo->DATARILASC) or Empty(personbo->TIPODOC) or Empty(personbo->AUTRILASC) or Empty(personbo->NUMDOCUM) */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.Empty(Cursor_personbo.GetString("TIPODOC")) || CPLib.Empty(Cursor_personbo.GetString("AUTRILASC")) || CPLib.Empty(Cursor_personbo.GetString("NUMDOCUM"))) {
                  /* mError := mError + 'Mancano gli estremi del documento' + NL */
                  mError = mError+"Mancano gli estremi del documento"+"\n";
                  /* bRitorno := False */
                  bRitorno = false;
                } // End If
              } // End If
              /* Case pTipo='8' */
            } else if (CPLib.eqr(pTipo,"8")) {
              /* If gVerSim='N' */
              if (CPLib.eqr(gVerSim,"N")) {
                /* If personbo->PAESE='086' or personbo->PAESE='139' */
                if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.eqr(Cursor_personbo.GetString("PAESE"),"139")) {
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA='EE' or Empty(personbo->DESCCIT) or Empty(personbo->DOMICILIO) or Empty(personbo->CODCAB) or Empty(personbo->CAP) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.eqr(Cursor_personbo.GetString("PROVINCIA"),"EE") || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("DOMICILIO")) || CPLib.Empty(Cursor_personbo.GetString("CODCAB")) || CPLib.Empty(Cursor_personbo.GetString("CAP"))) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* mError := mError + 'Manca il codice fiscale' + NL */
                    mError = mError+"Manca il codice fiscale"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } else { // Else
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA<>'EE' */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),"EE")) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } // End If
                /* If Empty(personbo->TIPINTER) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->SESSO) */
                if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                  /* mError := mError + 'Mancano i dati di nascita' + NL */
                  mError = mError+"Mancano i dati di nascita"+"\n";
                  /* bRitorno := False */
                  bRitorno = false;
                } // End If
                /* If Empty(personbo->DATARILASC) or Empty(personbo->TIPODOC) or Empty(personbo->AUTRILASC) or Empty(personbo->NUMDOCUM) */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.Empty(Cursor_personbo.GetString("TIPODOC")) || CPLib.Empty(Cursor_personbo.GetString("AUTRILASC")) || CPLib.Empty(Cursor_personbo.GetString("NUMDOCUM"))) {
                  /* mError := mError + 'Mancano gli estremi del documento' + NL */
                  mError = mError+"Mancano gli estremi del documento"+"\n";
                  /* bRitorno := False */
                  bRitorno = false;
                } // End If
              } // End If
              /* Case pTipo='9' */
            } else if (CPLib.eqr(pTipo,"9")) {
              /* If gVerSim='N' */
              if (CPLib.eqr(gVerSim,"N")) {
                /* If personbo->PAESE='086' or personbo->PAESE='139' */
                if (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.eqr(Cursor_personbo.GetString("PAESE"),"139")) {
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA='EE' or Empty(personbo->DESCCIT) or Empty(personbo->DOMICILIO) or Empty(personbo->CODCAB) or Empty(personbo->CAP) */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.eqr(Cursor_personbo.GetString("PROVINCIA"),"EE") || CPLib.Empty(Cursor_personbo.GetString("DESCCIT")) || CPLib.Empty(Cursor_personbo.GetString("DOMICILIO")) || CPLib.Empty(Cursor_personbo.GetString("CODCAB")) || CPLib.Empty(Cursor_personbo.GetString("CAP"))) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                  /* If Empty(personbo->CODFISC) */
                  if (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) {
                    /* mError := mError + 'Manca il codice fiscale' + NL */
                    mError = mError+"Manca il codice fiscale"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } else { // Else
                  /* If Empty(personbo->PROVINCIA) or personbo->PROVINCIA<>'EE' */
                  if (CPLib.Empty(Cursor_personbo.GetString("PROVINCIA")) || CPLib.ne(Cursor_personbo.GetString("PROVINCIA"),"EE")) {
                    /* mError := 'Dati Provincia Residenza Errati' + NL */
                    mError = "Dati Provincia Residenza Errati"+"\n";
                    /* bRitorno := False */
                    bRitorno = false;
                  } // End If
                } // End If
                /* If Empty(personbo->TIPINTER) or Empty(personbo->DATANASC) or (Empty(personbo->NASCOMUN) and Empty(personbo->NASSTATO)) or Empty(personbo->SESSO)  */
                if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER")) || CPLib.Empty(Cursor_personbo.GetDate("DATANASC")) || (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN")) && CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) || CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
                  /* mError := mError + 'Mancano i dati di nascita' + NL */
                  mError = mError+"Mancano i dati di nascita"+"\n";
                  /* bRitorno := False */
                  bRitorno = false;
                } // End If
                /* If Empty(personbo->DATARILASC) or Empty(personbo->TIPODOC) or Empty(personbo->AUTRILASC) or Empty(personbo->NUMDOCUM) */
                if (CPLib.Empty(Cursor_personbo.GetDate("DATARILASC")) || CPLib.Empty(Cursor_personbo.GetString("TIPODOC")) || CPLib.Empty(Cursor_personbo.GetString("AUTRILASC")) || CPLib.Empty(Cursor_personbo.GetString("NUMDOCUM"))) {
                  /* mError := mError + 'Mancano gli estremi del documento' + NL */
                  mError = mError+"Mancano gli estremi del documento"+"\n";
                  /* bRitorno := False */
                  bRitorno = false;
                } // End If
              } // End If
            } // End Case
          } // End If
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
      } // End If
      /* If gTipInter='14' */
      if (CPLib.eqr(gTipInter,"14")) {
        /* cConnes := '' */
        cConnes = "";
        // * --- Read from personbo_dip
        m_cServer = m_Ctx.GetServer("personbo_dip");
        m_cPhName = m_Ctx.GetPhName("personbo_dip");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNDG,"C",16,0,m_cServer),m_cServer,pNDG);
        m_cSql = m_cSql+" and CODDIPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(gCodDip,"C",6,0,m_cServer),m_cServer,gCodDip);
        if (m_Ctx.IsSharedTemp("personbo_dip")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cConnes = Read_Cursor.GetString("CONNES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo_dip into routine arfn_chksogg returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cConnes = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(cConnes) */
        if (CPLib.Empty(cConnes)) {
          /* mError := mError + 'Soggetto non valido per la dipendenza' + NL */
          mError = mError+"Soggetto non valido per la dipendenza"+"\n";
          /* bRitorno := False */
          bRitorno = false;
        } // End If
      } // End If
      /* Error Msg mError */
      m_cLastMsgError = mError;
      new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
      /* Return bRitorno */
      throw new Stop(bRitorno);
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pNDG,String p_pTipo) {
    pNDG = p_pNDG;
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
  public boolean Run(String p_pNDG,String p_pTipo) {
    pNDG = p_pNDG;
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
  public static arfn_chksoggR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_chksoggR(p_Ctx, p_Caller);
  }
  public static arfn_chksoggR Make(CPContext p_Ctx) {
    return new arfn_chksoggR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pNDG = CPLib.Space(16);
    pTipo = CPLib.Space(1);
    bRitorno = false;
    cConnes = CPLib.Space(16);
    mError = "";
    gTipInter=m_Ctx.GetGlobalString("gTipInter");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
    gVerSim=m_Ctx.GetGlobalString("gVerSim");
    gVerImp=m_Ctx.GetGlobalString("gVerImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_chksogg,
  public static final String i_InvokedRoutines = ",arfn_chksogg,";
  public static String[] m_cRunParameterNames={"pNDG","pTipo"};
}
