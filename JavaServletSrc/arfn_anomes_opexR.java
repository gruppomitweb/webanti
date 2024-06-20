// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_anomes_opexR implements CallerWithObjs {
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
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
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
  public String pRapporto;
  public String pTipo;
  public String pNCF;
  public MemoryCursor_mcerrsaldi_mcrdef mcErrori;
  public MemoryCursor_mcerrsaldi_mcrdef mcErrPers;
  public MemoryCursorRow_mcerrsaldi_mcrdef rowErrore;
  public String cRitorno;
  public double _conta;
  public String _codfisc;
  public java.sql.Date gScadSaldi;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_anomes_opexR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_anomes_opex",m_Caller);
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_anomes_opex";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      return pRapporto;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pNCF",p_cVarName)) {
      return pNCF;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      return gScadSaldi;
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
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      return mcErrori;
    }
    if (CPLib.eqr("mcErrPers",p_cVarName)) {
      return mcErrPers;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowErrore",p_cVarName)) {
      return rowErrore;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      pRapporto = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pNCF",p_cVarName)) {
      pNCF = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      gScadSaldi = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowErrore",p_cVarName)) {
      rowErrore = (MemoryCursorRow_mcerrsaldi_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcErrori",p_cVarName)) {
      mcErrori = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcErrPers",p_cVarName)) {
      mcErrPers = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_opextrbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Read_Cursor=null;
    try {
      /* pRapporto Char(50) // Rapporto */
      /* pTipo Char(1) // Nuova o Modifica */
      /* pNCF Char(1) // Nuova o Modifica */
      /* mcErrori MemoryCursor(mcErrSaldi.MCRDef) */
      /* mcErrPers MemoryCursor(mcErrSaldi.MCRDef) */
      /* rowErrore Row(mcErrSaldi.MCRDef) */
      /* cRitorno Memo // Errori Rilevati */
      /* _conta Numeric(1, 0) */
      /* _codfisc Char(16) */
      /* gScadSaldi Date // Scadenza Invio Saldi */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* cRitorno := '' // Errori Rilevati */
      cRitorno = "";
      // * --- Select from opextrbo
      m_cServer = m_Ctx.GetServer("opextrbo");
      m_cPhName = m_Ctx.GetPhName("opextrbo");
      if (Cursor_opextrbo!=null)
        Cursor_opextrbo.Close();
      Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_opextrbo.Eof())) {
        /* _conta := 1 */
        _conta = CPLib.Round(1,0);
        /* If Empty(opextrbo->COLLEG) */
        if (CPLib.Empty(Cursor_opextrbo.GetString("COLLEG"))) {
          /* mcErrori.AppendBlank() */
          mcErrori.AppendBlank();
          /* mcErrori.TIPO := pTipo */
          mcErrori.row.TIPO = pTipo;
          /* mcErrori.RAPPORTO := pRapporto */
          mcErrori.row.RAPPORTO = pRapporto;
          /* mcErrori.TXTERR :=  'Operazione Extraconto non individuato intestatario' */
          mcErrori.row.TXTERR = "Operazione Extraconto non individuato intestatario";
          /* mcErrori.SaveRow() */
          mcErrori.SaveRow();
        } // End If
        /* If Empty(opextrbo->DATAOPE) */
        if (CPLib.Empty(Cursor_opextrbo.GetDate("DATAOPE"))) {
          /* mcErrori.AppendBlank() */
          mcErrori.AppendBlank();
          /* mcErrori.TIPO := pTipo */
          mcErrori.row.TIPO = pTipo;
          /* mcErrori.RAPPORTO := pRapporto */
          mcErrori.row.RAPPORTO = pRapporto;
          /* mcErrori.TXTERR := "Operazione Extraconto anomalia data operazione" */
          mcErrori.row.TXTERR = "Operazione Extraconto anomalia data operazione";
          /* mcErrori.SaveRow() */
          mcErrori.SaveRow();
        } // End If
        /* If Empty(opextrbo->ANNO) */
        if (CPLib.Empty(Cursor_opextrbo.GetString("ANNO"))) {
          /* mcErrori.AppendBlank() */
          mcErrori.AppendBlank();
          /* mcErrori.TIPO := pTipo */
          mcErrori.row.TIPO = pTipo;
          /* mcErrori.RAPPORTO := pRapporto */
          mcErrori.row.RAPPORTO = pRapporto;
          /* mcErrori.TXTERR := 'Operazione Extraconto anomalia anno operazione' */
          mcErrori.row.TXTERR = "Operazione Extraconto anomalia anno operazione";
          /* mcErrori.SaveRow() */
          mcErrori.SaveRow();
        } // End If
        /* If pTipo='Q' and not((Year(Date()) -Val(opextrbo->ANNO)=1 and Date() <= gScadSaldi) or (Year(Date()) -Val(opextrbo->ANNO)=0)) */
        if (CPLib.eqr(pTipo,"Q") &&  ! ((CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Val(Cursor_opextrbo.GetString("ANNO")),1) && CPLib.le(CPLib.Date(),gScadSaldi)) || (CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Val(Cursor_opextrbo.GetString("ANNO")),0)))) {
          /* If (opextrbo->SALDO > 0 and opextrbo->QUANTITA <= 0) or (opextrbo->SALDO<=0 and opextrbo->QUANTITA>0) */
          if ((CPLib.gt(Cursor_opextrbo.GetDouble("SALDO"),0) && CPLib.le(Cursor_opextrbo.GetDouble("QUANTITA"),0)) || (CPLib.le(Cursor_opextrbo.GetDouble("SALDO"),0) && CPLib.gt(Cursor_opextrbo.GetDouble("QUANTITA"),0))) {
            /* mcErrori.AppendBlank() */
            mcErrori.AppendBlank();
            /* mcErrori.TIPO := pTipo */
            mcErrori.row.TIPO = pTipo;
            /* mcErrori.RAPPORTO := pRapporto */
            mcErrori.row.RAPPORTO = pRapporto;
            /* mcErrori.TXTERR := 'Operazione Extraconto incongruenza tra saldo e quantita' */
            mcErrori.row.TXTERR = "Operazione Extraconto incongruenza tra saldo e quantita";
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          } // End If
          /* If (opextrbo->SALDO = 0 and opextrbo->QUANTITA = 0) */
          if ((CPLib.eqr(Cursor_opextrbo.GetDouble("SALDO"),0) && CPLib.eqr(Cursor_opextrbo.GetDouble("QUANTITA"),0))) {
            /* mcErrori.AppendBlank() */
            mcErrori.AppendBlank();
            /* mcErrori.TIPO := pTipo */
            mcErrori.row.TIPO = pTipo;
            /* mcErrori.RAPPORTO := pRapporto */
            mcErrori.row.RAPPORTO = pRapporto;
            /* mcErrori.TXTERR := 'Operazione Extraconto senza saldo e quantita' */
            mcErrori.row.TXTERR = "Operazione Extraconto senza saldo e quantita";
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          } // End If
          /* If Empty(opextrbo->VALUTA) */
          if (CPLib.Empty(Cursor_opextrbo.GetString("VALUTA"))) {
            /* mcErrori.AppendBlank() */
            mcErrori.AppendBlank();
            /* mcErrori.TIPO := pTipo */
            mcErrori.row.TIPO = pTipo;
            /* mcErrori.RAPPORTO := pRapporto */
            mcErrori.row.RAPPORTO = pRapporto;
            /* mcErrori.TXTERR := 'Operazione Extraconto valuta non valorizzata' */
            mcErrori.row.TXTERR = "Operazione Extraconto valuta non valorizzata";
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          } // End If
          /* If not(Empty(opextrbo->VALUTA)) and Len(LRTrim(opextrbo->VALUTA)) < 3 */
          if ( ! (CPLib.Empty(Cursor_opextrbo.GetString("VALUTA"))) && CPLib.lt(CPLib.Len(CPLib.LRTrim(Cursor_opextrbo.GetString("VALUTA"))),3)) {
            /* mcErrori.AppendBlank() */
            mcErrori.AppendBlank();
            /* mcErrori.TIPO := pTipo */
            mcErrori.row.TIPO = pTipo;
            /* mcErrori.RAPPORTO := pRapporto */
            mcErrori.row.RAPPORTO = pRapporto;
            /* mcErrori.TXTERR := 'Operazione Extraconto valuta anomala'  */
            mcErrori.row.TXTERR = "Operazione Extraconto valuta anomala";
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          } // End If
        } // End If
        /* If not(Empty(opextrbo->COLLEG)) */
        if ( ! (CPLib.Empty(Cursor_opextrbo.GetString("COLLEG")))) {
          /* mcErrPers := arfn_anompers(opextrbo->COLLEG,'1',opextrbo->RAPPORTO,'N',pTipo,'',pNCF) */
          mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_opextrbo.GetString("COLLEG"),"1",Cursor_opextrbo.GetString("RAPPORTO"),"N",pTipo,"",pNCF);
          for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
            /* mcErrori.AppendBlank() */
            mcErrori.AppendBlank();
            /* mcErrori.TIPO := pTipo */
            mcErrori.row.TIPO = pTipo;
            /* mcErrori.RAPPORTO := pRapporto */
            mcErrori.row.RAPPORTO = pRapporto;
            /* mcErrori.TXTERR := rowErrore.TXTERR */
            mcErrori.row.TXTERR = rowErrore.TXTERR;
            /* mcErrori.CONNESINT := rowErrore.CONNESINT */
            mcErrori.row.CONNESINT = rowErrore.CONNESINT;
            /* mcErrori.SaveRow() */
            mcErrori.SaveRow();
          }
          // * --- Select from intestit
          m_cServer = m_Ctx.GetServer("intestit");
          m_cPhName = m_Ctx.GetPhName("intestit");
          if (Cursor_intestit!=null)
            Cursor_intestit.Close();
          Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_opextrbo.GetString("COLLEG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intestit.Eof())) {
            /* If intestit->DATAINI <= opextrbo->DATAOPE and (Empty(intestit->DATAFINE) or (not(Empty(intestit->DATAFINE)) and intestit->DATAFINE >= opextrbo->DATAOPE)) */
            if (CPLib.le(Cursor_intestit.GetDate("DATAINI"),Cursor_opextrbo.GetDate("DATAOPE")) && (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")) || ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) && CPLib.ge(Cursor_intestit.GetDate("DATAFINE"),Cursor_opextrbo.GetDate("DATAOPE"))))) {
              /* _codfisc := '' */
              _codfisc = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestit.GetString("CODINTER"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _codfisc = Read_Cursor.GetString("CODFISC");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arfn_anomes_opex returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _codfisc = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Len(LRTrim(_codfisc)) < 16 */
              if (CPLib.lt(CPLib.Len(CPLib.LRTrim(_codfisc)),16)) {
                /* mcErrori.AppendBlank() */
                mcErrori.AppendBlank();
                /* mcErrori.TIPO := pTipo */
                mcErrori.row.TIPO = pTipo;
                /* mcErrori.RAPPORTO := pRapporto */
                mcErrori.row.RAPPORTO = pRapporto;
                /* mcErrori.TXTERR := 'Operazione Extraconto - Titolare Soggetto non persona fisica' */
                mcErrori.row.TXTERR = "Operazione Extraconto - Titolare Soggetto non persona fisica";
                /* mcErrori.CONNESINT := intestit->CODINTER */
                mcErrori.row.CONNESINT = Cursor_intestit.GetString("CODINTER");
                /* mcErrori.SaveRow() */
                mcErrori.SaveRow();
              } // End If
              /* mcErrPers := arfn_anompers(intestit->CODINTER,'1',opextrbo->RAPPORTO,'N',pTipo,'F',pNCF) */
              mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),"1",Cursor_opextrbo.GetString("RAPPORTO"),"N",pTipo,"F",pNCF);
              /* If mcErrPers.RecCount() > 0 */
              if (CPLib.gt(mcErrPers.RecCount(),0)) {
                for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
                  /* mcErrori.AppendBlank() */
                  mcErrori.AppendBlank();
                  /* mcErrori.TIPO := pTipo */
                  mcErrori.row.TIPO = pTipo;
                  /* mcErrori.RAPPORTO := pRapporto */
                  mcErrori.row.RAPPORTO = pRapporto;
                  /* mcErrori.TXTERR := rowErrore.TXTERR */
                  mcErrori.row.TXTERR = rowErrore.TXTERR;
                  /* mcErrori.CONNESINT := rowErrore.CONNESINT */
                  mcErrori.row.CONNESINT = rowErrore.CONNESINT;
                  /* mcErrori.SaveRow() */
                  mcErrori.SaveRow();
                }
              } // End If
            } // End If
            Cursor_intestit.Next();
          }
          m_cConnectivityError = Cursor_intestit.ErrorMessage();
          Cursor_intestit.Close();
          // * --- End Select
        } // End If
        /* If not(Empty(opextrbo->CONNESOPER)) */
        if ( ! (CPLib.Empty(Cursor_opextrbo.GetString("CONNESOPER")))) {
          /* mcErrPers := arfn_anompers(opextrbo->CONNESOPER,'1',opextrbo->RAPPORTO,'N',pTipo,'',pNCF) */
          mcErrPers = arfn_anompersR.Make(m_Ctx,this).Run(Cursor_opextrbo.GetString("CONNESOPER"),"1",Cursor_opextrbo.GetString("RAPPORTO"),"N",pTipo,"",pNCF);
          /* If mcErrPers.RecCount() > 0 */
          if (CPLib.gt(mcErrPers.RecCount(),0)) {
            for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrPers._iterable_()) {
              /* mcErrori.AppendBlank() */
              mcErrori.AppendBlank();
              /* mcErrori.TIPO := pTipo */
              mcErrori.row.TIPO = pTipo;
              /* mcErrori.RAPPORTO := pRapporto */
              mcErrori.row.RAPPORTO = pRapporto;
              /* mcErrori.TXTERR := rowErrore.TXTERR */
              mcErrori.row.TXTERR = rowErrore.TXTERR;
              /* mcErrori.CONNESINT := rowErrore.CONNESINT */
              mcErrori.row.CONNESINT = rowErrore.CONNESINT;
              /* mcErrori.SaveRow() */
              mcErrori.SaveRow();
            }
          } // End If
        } // End If
        Cursor_opextrbo.Next();
      }
      m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
      Cursor_opextrbo.Close();
      // * --- End Select
      /* If _conta=0 */
      if (CPLib.eqr(_conta,0)) {
        /* mcErrori.AppendBlank() */
        mcErrori.AppendBlank();
        /* mcErrori.TIPO := pTipo */
        mcErrori.row.TIPO = pTipo;
        /* mcErrori.RAPPORTO := pRapporto */
        mcErrori.row.RAPPORTO = pRapporto;
        /* mcErrori.TXTERR := 'Operazione Extraconto non individuata' */
        mcErrori.row.TXTERR = "Operazione Extraconto non individuata";
        /* mcErrori.SaveRow() */
        mcErrori.SaveRow();
      } // End If
      /* Return mcErrori */
      throw new Stop(mcErrori);
    } finally {
      try {
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
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
  public String RunAsync(String p_pRapporto,String p_pTipo,String p_pNCF) {
    pRapporto = p_pRapporto;
    pTipo = p_pTipo;
    pNCF = p_pNCF;
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
  public MemoryCursor_mcerrsaldi_mcrdef Run(String p_pRapporto,String p_pTipo,String p_pNCF) {
    pRapporto = p_pRapporto;
    pTipo = p_pTipo;
    pNCF = p_pNCF;
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
  public static arfn_anomes_opexR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_anomes_opexR(p_Ctx, p_Caller);
  }
  public static arfn_anomes_opexR Make(CPContext p_Ctx) {
    return new arfn_anomes_opexR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRapporto = CPLib.Space(50);
    pTipo = CPLib.Space(1);
    pNCF = CPLib.Space(1);
    mcErrori = new MemoryCursor_mcerrsaldi_mcrdef();
    mcErrPers = new MemoryCursor_mcerrsaldi_mcrdef();
    rowErrore = new MemoryCursorRow_mcerrsaldi_mcrdef();
    cRitorno = "";
    _conta = 0;
    _codfisc = CPLib.Space(16);
    gScadSaldi=m_Ctx.GetGlobalDate("gScadSaldi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_anomes_opex,arfn_anompers,
  public static final String i_InvokedRoutines = ",arfn_anomes_opex,arfn_anompers,";
  public static String[] m_cRunParameterNames={"pRapporto","pTipo","pNCF"};
}
