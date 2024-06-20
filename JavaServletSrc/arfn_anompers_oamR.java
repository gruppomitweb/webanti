// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_anompers_oamR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public String pRapporto;
  public java.sql.Date pDatOpe;
  public String pNOCF;
  public MemoryCursor_mcerrsaldi_mcrdef mcErrAnag;
  public String rRitorno;
  public String _tipsog;
  public String _codfisc;
  public double _cferr;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_anompers_oamR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_anompers_oam",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_cferr",p_cVarName)) {
      return _cferr;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_anompers_oam";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNDG",p_cVarName)) {
      return pNDG;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      return pRapporto;
    }
    if (CPLib.eqr("pNOCF",p_cVarName)) {
      return pNOCF;
    }
    if (CPLib.eqr("rRitorno",p_cVarName)) {
      return rRitorno;
    }
    if (CPLib.eqr("_tipsog",p_cVarName)) {
      return _tipsog;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
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
    if (CPLib.eqr("mcErrAnag",p_cVarName)) {
      return mcErrAnag;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_cferr",p_cVarName)) {
      _cferr = value;
      return;
    }
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
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      pRapporto = value;
      return;
    }
    if (CPLib.eqr("pNOCF",p_cVarName)) {
      pNOCF = value;
      return;
    }
    if (CPLib.eqr("rRitorno",p_cVarName)) {
      rRitorno = value;
      return;
    }
    if (CPLib.eqr("_tipsog",p_cVarName)) {
      _tipsog = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
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
    if (CPLib.eqr("mcErrAnag",p_cVarName)) {
      mcErrAnag = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_personbo=null;
    try {
      /* pNDG Char(16) // Codice Soggetto */
      /* pTipo Char(1) // Tipo Operazione */
      /* pRapporto Char(50) // Codice Operazione */
      /* pDatOpe Date // Data dell'operazione */
      /* pNOCF Char(1) // Non controllare eventuali codici fiscali */
      /* mcErrAnag MemoryCursor(mcErrSaldi.MCRDef) */
      /* rRitorno Memo */
      /* _tipsog Char(1) // Tipo Soggetto */
      /* _codfisc Char(16) // Codice Fiscale calcolato */
      /* _cferr Numeric(1, 0) */
      /* _cferr := 0 */
      _cferr = CPLib.Round(0,0);
      /* rRitorno := '' */
      rRitorno = "";
      // * --- Select from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(pNDG,"?",0,0,m_cServer, m_oParameters),m_cServer,pNDG)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_personbo.Eof())) {
        /* If not(arfn_chkcodfis(personbo->CODFISC,'',personbo->CFESTERO)) */
        if ( ! (arfn_chkcodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("CODFISC"),"",Cursor_personbo.GetDouble("CFESTERO")))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Codice Fiscale Formalmente Errato" */
          mcErrAnag.row.TXTERR = "Codice Fiscale Formalmente Errato";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
          /* _cferr := 1 */
          _cferr = CPLib.Round(1,0);
        } // End If
        /* If Len(LRTrim(personbo->CODFISC)) < 16 and personbo->CFESTERO <> 1 */
        if (CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16) && CPLib.ne(Cursor_personbo.GetDouble("CFESTERO"),1)) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* If Len(LRTrim(personbo->CODFISC)) = 11 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),11)) {
            /* mcErrAnag.TXTERR := "Lunghezza Codice Fiscale potenzialmente non valida per Persona Fisica/Ditta Individuale" */
            mcErrAnag.row.TXTERR = "Lunghezza Codice Fiscale potenzialmente non valida per Persona Fisica/Ditta Individuale";
          } else { // Else
            /* mcErrAnag.TXTERR := "Lunghezza Codice Fiscale non valida per Persona Fisica/Ditta Individuale" */
            mcErrAnag.row.TXTERR = "Lunghezza Codice Fiscale non valida per Persona Fisica/Ditta Individuale";
          } // End If
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(arfn_agechar(personbo->COGNOME," ")) */
        if (CPLib.Empty(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("COGNOME")," "))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Cognome Mancante" */
          mcErrAnag.row.TXTERR = "Cognome Mancante";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(arfn_agechar(personbo->NOME," ")) */
        if (CPLib.Empty(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NOME")," "))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Nome Mancante" */
          mcErrAnag.row.TXTERR = "Nome Mancante";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(personbo->SESSO) */
        if (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Sesso Mancante" */
          mcErrAnag.row.TXTERR = "Sesso Mancante";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If not(Empty(personbo->SESSO)) and (personbo->SESSO <> '1' and personbo->SESSO <> '2') */
        if ( ! (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) && (CPLib.ne(Cursor_personbo.GetString("SESSO"),"1") && CPLib.ne(Cursor_personbo.GetString("SESSO"),"2"))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Sesso Valore Anomalo" */
          mcErrAnag.row.TXTERR = "Sesso Valore Anomalo";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(personbo->DATANASC) */
        if (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Data di Nascita Mancante" */
          mcErrAnag.row.TXTERR = "Data di Nascita Mancante";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If not(Empty(personbo->DATANASC)) and Year(personbo->DATANASC) < 1900 */
        if ( ! (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) && CPLib.lt(CPLib.Year(Cursor_personbo.GetDate("DATANASC")),1900)) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Data di Nascita Anomala" */
          mcErrAnag.row.TXTERR = "Data di Nascita Anomala";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(arfn_agechar(personbo->NASCOMUN,' ')) and Empty(arfn_agechar(personbo->NASSTATO,' ')) */
        if (CPLib.Empty(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASCOMUN")," ")) && CPLib.Empty(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASSTATO")," "))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Luogo di Nascita Mancante" */
          mcErrAnag.row.TXTERR = "Luogo di Nascita Mancante";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If not(Empty(personbo->TIPINTER)) and personbo->TIPINTER='EE' and Empty(arfn_agechar(personbo->NASSTATO,' ')) */
        if ( ! (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) && CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE") && CPLib.Empty(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASSTATO")," "))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Stato di Nascita Mancante o Provincia di Nascita Errata" */
          mcErrAnag.row.TXTERR = "Stato di Nascita Mancante o Provincia di Nascita Errata";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If not(Empty(personbo->TIPINTER)) and personbo->TIPINTER<>'EE' and not(Empty(arfn_agechar(personbo->NASSTATO,' '))) and LRTrim(Upper(personbo->NASSTATO)) <> 'ITALIA' */
        if ( ! (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) && CPLib.ne(Cursor_personbo.GetString("TIPINTER"),"EE") &&  ! (CPLib.Empty(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASSTATO")," "))) && CPLib.ne(CPLib.LRTrim(CPLib.Upper(Cursor_personbo.GetString("NASSTATO"))),"ITALIA")) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Incongruenza tra Stato di Nascita e Provincia di Nascita" */
          mcErrAnag.row.TXTERR = "Incongruenza tra Stato di Nascita e Provincia di Nascita";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If not(Empty(personbo->TIPINTER)) and personbo->TIPINTER<>'EE' and Empty(arfn_agechar(personbo->NASCOMUN,' ')) */
        if ( ! (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) && CPLib.ne(Cursor_personbo.GetString("TIPINTER"),"EE") && CPLib.Empty(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASCOMUN")," "))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Città di Nascita Mancante o Provincia di nascita Errata" */
          mcErrAnag.row.TXTERR = "Città di Nascita Mancante o Provincia di nascita Errata";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If not(Empty(personbo->TIPINTER)) and personbo->TIPINTER='EE' and not(Empty(arfn_agechar(personbo->NASCOMUN,' '))) */
        if ( ! (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) && CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE") &&  ! (CPLib.Empty(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("NASCOMUN")," ")))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Incongruenza tra Città di Nascita o Provincia di Nascita" */
          mcErrAnag.row.TXTERR = "Incongruenza tra Città di Nascita o Provincia di Nascita";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(personbo->TIPINTER) */
        if (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Provincia di Nascita Mancante" */
          mcErrAnag.row.TXTERR = "Provincia di Nascita Mancante";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If not(Empty(personbo->TIPINTER)) and not(LibreriaMit.isAlpha(LRTrim(personbo->TIPINTER))) */
        if ( ! (CPLib.Empty(Cursor_personbo.GetString("TIPINTER"))) &&  ! (LibreriaMit.isAlpha(CPLib.LRTrim(Cursor_personbo.GetString("TIPINTER"))))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Provincia di Nascita con caratteri non ammessi" */
          mcErrAnag.row.TXTERR = "Provincia di Nascita con caratteri non ammessi";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If _cferr=0 */
        if (CPLib.eqr(_cferr,0)) {
          /* If personbo->CFESTERO <> 1 and not(Empty(personbo->COGNOME)) and not(Empty(personbo->NOME)) and not(Empty(personbo->SESSO)) and not(Empty(personbo->DATANASC)) and (not(Empty(personbo->NASCOMUN)) or not(Empty(personbo->NASSTATO))) and not(Empty(personbo->TIPINTER)) */
          if (CPLib.ne(Cursor_personbo.GetDouble("CFESTERO"),1) &&  ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("NOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) &&  ! (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) && ( ! (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("TIPINTER")))) {
            /* _codfisc := arfn_calccodfis(personbo->COGNOME,personbo->NOME,personbo->DATANASC,personbo->NASCOMUN,personbo->NASSTATO,personbo->SESSO,personbo->TIPINTER) // Codice Fiscale calcolato */
            _codfisc = arfn_calccodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("COGNOME"),Cursor_personbo.GetString("NOME"),Cursor_personbo.GetDate("DATANASC"),Cursor_personbo.GetString("NASCOMUN"),Cursor_personbo.GetString("NASSTATO"),Cursor_personbo.GetString("SESSO"),Cursor_personbo.GetString("TIPINTER"));
            /* If Left(_codfisc,11) <> Left(personbo->CODFISC,11) */
            if (CPLib.ne(CPLib.Left(_codfisc,11),CPLib.Left(Cursor_personbo.GetString("CODFISC"),11))) {
              /* mcErrAnag.AppendBlank() */
              mcErrAnag.AppendBlank();
              /* mcErrAnag.TIPO := pTipo */
              mcErrAnag.row.TIPO = pTipo;
              /* mcErrAnag.RAPPORTO := pRapporto */
              mcErrAnag.row.RAPPORTO = pRapporto;
              /* mcErrAnag.TXTERR := "Codice fiscale errato (controllare dati anagrafici)" */
              mcErrAnag.row.TXTERR = "Codice fiscale errato (controllare dati anagrafici)";
              /* mcErrAnag.CONNESINT := personbo->CONNES */
              mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
              /* mcErrAnag.SaveRow() */
              mcErrAnag.SaveRow();
              /* _cferr := 1 */
              _cferr = CPLib.Round(1,0);
            } // End If
          } // End If
        } // End If
        /* If _cferr = 0 */
        if (CPLib.eqr(_cferr,0)) {
          /* If pNOCF='N' */
          if (CPLib.eqr(pNOCF,"N")) {
            /* If personbo->CFESTERO <> 1 and not(Empty(personbo->COGNOME)) and not(Empty(personbo->NOME)) and not(Empty(personbo->SESSO)) and not(Empty(personbo->DATANASC)) and (not(Empty(personbo->NASCOMUN)) or not(Empty(personbo->NASSTATO))) and not(Empty(personbo->TIPINTER)) */
            if (CPLib.ne(Cursor_personbo.GetDouble("CFESTERO"),1) &&  ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("NOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("SESSO"))) &&  ! (CPLib.Empty(Cursor_personbo.GetDate("DATANASC"))) && ( ! (CPLib.Empty(Cursor_personbo.GetString("NASCOMUN"))) ||  ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO")))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("TIPINTER")))) {
              /* _codfisc := arfn_calccodfis(personbo->COGNOME,personbo->NOME,personbo->DATANASC,personbo->NASCOMUN,personbo->NASSTATO,personbo->SESSO,personbo->TIPINTER) // Codice Fiscale calcolato */
              _codfisc = arfn_calccodfisR.Make(m_Ctx,this).Run(Cursor_personbo.GetString("COGNOME"),Cursor_personbo.GetString("NOME"),Cursor_personbo.GetDate("DATANASC"),Cursor_personbo.GetString("NASCOMUN"),Cursor_personbo.GetString("NASSTATO"),Cursor_personbo.GetString("SESSO"),Cursor_personbo.GetString("TIPINTER"));
              /* If Left(_codfisc,11)=Left(personbo->CODFISC,11) and Substr(_codfisc,12,4)<>Substr(personbo->CODFISC,12,4) */
              if (CPLib.eqr(CPLib.Left(_codfisc,11),CPLib.Left(Cursor_personbo.GetString("CODFISC"),11)) && CPLib.ne(CPLib.Substr(_codfisc,12,4),CPLib.Substr(Cursor_personbo.GetString("CODFISC"),12,4))) {
                /* mcErrAnag.AppendBlank() */
                mcErrAnag.AppendBlank();
                /* mcErrAnag.TIPO := pTipo */
                mcErrAnag.row.TIPO = pTipo;
                /* mcErrAnag.RAPPORTO := pRapporto */
                mcErrAnag.row.RAPPORTO = pRapporto;
                /* mcErrAnag.TXTERR := "Possibile codice fiscale errato  (controllare dati anagrafici)" */
                mcErrAnag.row.TXTERR = "Possibile codice fiscale errato  (controllare dati anagrafici)";
                /* mcErrAnag.CONNESINT := personbo->CONNES */
                mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
                /* mcErrAnag.SaveRow() */
                mcErrAnag.SaveRow();
              } // End If
            } // End If
          } // End If
        } // End If
        /* If Empty(personbo->PAESE) */
        if (CPLib.Empty(Cursor_personbo.GetString("PAESE"))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Manca il paese di residenza del soggetto" */
          mcErrAnag.row.TXTERR = "Manca il paese di residenza del soggetto";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(personbo->TIPODOC) */
        if (CPLib.Empty(Cursor_personbo.GetString("TIPODOC"))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Manca il tipo documento del soggetto" */
          mcErrAnag.row.TXTERR = "Manca il tipo documento del soggetto";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
          /* ElseIf At(personbo->TIPODOC,"|01|02|03|04|05|06") = 0 */
        } else if (CPLib.eqr(CPLib.At(Cursor_personbo.GetString("TIPODOC"),"|01|02|03|04|05|06"),0)) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Tipo Documento non valido" */
          mcErrAnag.row.TXTERR = "Tipo Documento non valido";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(personbo->NUMDOCUM) */
        if (CPLib.Empty(Cursor_personbo.GetString("NUMDOCUM"))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Manca il numero del documento" */
          mcErrAnag.row.TXTERR = "Manca il numero del documento";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(personbo->AUTRILASC) */
        if (CPLib.Empty(Cursor_personbo.GetString("AUTRILASC"))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Manca l'autorità di rilascio del documento" */
          mcErrAnag.row.TXTERR = "Manca l'autorità di rilascio del documento";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        /* If Empty(personbo->DATAVALI) */
        if (CPLib.Empty(Cursor_personbo.GetDate("DATAVALI"))) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Manca la data di scadenza del documento" */
          mcErrAnag.row.TXTERR = "Manca la data di scadenza del documento";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
          /* ElseIf personbo->DATAVALI < pDatOpe */
        } else if (CPLib.lt(Cursor_personbo.GetDate("DATAVALI"),pDatOpe)) {
          /* mcErrAnag.AppendBlank() */
          mcErrAnag.AppendBlank();
          /* mcErrAnag.TIPO := pTipo */
          mcErrAnag.row.TIPO = pTipo;
          /* mcErrAnag.RAPPORTO := pRapporto */
          mcErrAnag.row.RAPPORTO = pRapporto;
          /* mcErrAnag.TXTERR := "Documento scaduto all'epoca dell'operazione" */
          mcErrAnag.row.TXTERR = "Documento scaduto all'epoca dell'operazione";
          /* mcErrAnag.CONNESINT := personbo->CONNES */
          mcErrAnag.row.CONNESINT = Cursor_personbo.GetString("CONNES");
          /* mcErrAnag.SaveRow() */
          mcErrAnag.SaveRow();
        } // End If
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      // * --- End Select
      /* Return mcErrAnag */
      throw new Stop(mcErrAnag);
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pNDG,String p_pTipo,String p_pRapporto,java.sql.Date p_pDatOpe,String p_pNOCF) {
    pNDG = p_pNDG;
    pTipo = p_pTipo;
    pRapporto = p_pRapporto;
    pDatOpe = p_pDatOpe;
    pNOCF = p_pNOCF;
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
  public MemoryCursor_mcerrsaldi_mcrdef Run(String p_pNDG,String p_pTipo,String p_pRapporto,java.sql.Date p_pDatOpe,String p_pNOCF) {
    pNDG = p_pNDG;
    pTipo = p_pTipo;
    pRapporto = p_pRapporto;
    pDatOpe = p_pDatOpe;
    pNOCF = p_pNOCF;
    return Run();
  }
  public MemoryCursor_mcerrsaldi_mcrdef Run() {
    MemoryCursor_mcerrsaldi_mcrdef l_result;
    l_result = null;
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
        l_result = (MemoryCursor_mcerrsaldi_mcrdef)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
  public static arfn_anompers_oamR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_anompers_oamR(p_Ctx, p_Caller);
  }
  public static arfn_anompers_oamR Make(CPContext p_Ctx) {
    return new arfn_anompers_oamR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pNDG = CPLib.Space(16);
    pTipo = CPLib.Space(1);
    pRapporto = CPLib.Space(50);
    pDatOpe = CPLib.NullDate();
    pNOCF = CPLib.Space(1);
    mcErrAnag = new MemoryCursor_mcerrsaldi_mcrdef();
    rRitorno = "";
    _tipsog = CPLib.Space(1);
    _codfisc = CPLib.Space(16);
    _cferr = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_anompers_oam,arfn_calccodfis,arfn_chkcodfis,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_anompers_oam,arfn_calccodfis,arfn_chkcodfis,";
  public static String[] m_cRunParameterNames={"pNDG","pTipo","pRapporto","pDatOpe","pNOCF"};
}
