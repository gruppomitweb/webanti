// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_fam_mesefile02R implements CallerWithObjs {
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
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
  public String m_cPhName_jarantbo;
  public String m_cServer_jarantbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_jntestit;
  public String m_cServer_jntestit;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_delegaop;
  public String m_cServer_delegaop;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
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
  public MemoryCursorRow_sid_invio1 pRow;
  public java.sql.Date pDaData;
  public java.sql.Date pAData;
  public String pTipo;
  public MemoryCursor_sid_invio2 mcRitorno;
  public MemoryCursor_mcfamiglia_mcrdef mcFamiglia;
  public MemoryCursorRow_sid_invio2 rowAnag;
  public double _conta;
  public double _notit;
  public double _presente;
  public java.sql.Date gDataTito;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_fam_mesefile02R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_fam_mesefile02",m_Caller);
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    if (m_cPhName_jntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestbo = m_cPhName_jntestbo+" "+m_Ctx.GetWritePhName("jntestbo");
    }
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_jelegabo = p_ContextObject.GetPhName("jelegabo");
    if (m_cPhName_jelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jelegabo = m_cPhName_jelegabo+" "+m_Ctx.GetWritePhName("jelegabo");
    }
    m_cServer_jelegabo = p_ContextObject.GetServer("jelegabo");
    m_cPhName_garantbo = p_ContextObject.GetPhName("garantbo");
    if (m_cPhName_garantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_garantbo = m_cPhName_garantbo+" "+m_Ctx.GetWritePhName("garantbo");
    }
    m_cServer_garantbo = p_ContextObject.GetServer("garantbo");
    m_cPhName_jarantbo = p_ContextObject.GetPhName("jarantbo");
    if (m_cPhName_jarantbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jarantbo = m_cPhName_jarantbo+" "+m_Ctx.GetWritePhName("jarantbo");
    }
    m_cServer_jarantbo = p_ContextObject.GetServer("jarantbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_jntestit = p_ContextObject.GetPhName("jntestit");
    if (m_cPhName_jntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestit = m_cPhName_jntestit+" "+m_Ctx.GetWritePhName("jntestit");
    }
    m_cServer_jntestit = p_ContextObject.GetServer("jntestit");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_delegaop = p_ContextObject.GetPhName("delegaop");
    if (m_cPhName_delegaop.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegaop = m_cPhName_delegaop+" "+m_Ctx.GetWritePhName("delegaop");
    }
    m_cServer_delegaop = p_ContextObject.GetServer("delegaop");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_notit",p_cVarName)) {
      return _notit;
    }
    if (CPLib.eqr("_presente",p_cVarName)) {
      return _presente;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_fam_mesefile02";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pDaData",p_cVarName)) {
      return pDaData;
    }
    if (CPLib.eqr("pAData",p_cVarName)) {
      return pAData;
    }
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      return gDataTito;
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
    if (CPLib.eqr("mcRitorno",p_cVarName)) {
      return mcRitorno;
    }
    if (CPLib.eqr("mcFamiglia",p_cVarName)) {
      return mcFamiglia;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pRow",p_cVarName)) {
      return pRow;
    }
    if (CPLib.eqr("rowAnag",p_cVarName)) {
      return rowAnag;
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
    if (CPLib.eqr("_notit",p_cVarName)) {
      _notit = value;
      return;
    }
    if (CPLib.eqr("_presente",p_cVarName)) {
      _presente = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("pDaData",p_cVarName)) {
      pDaData = value;
      return;
    }
    if (CPLib.eqr("pAData",p_cVarName)) {
      pAData = value;
      return;
    }
    if (CPLib.eqr("gDataTito",p_cVarName)) {
      gDataTito = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("pRow",p_cVarName)) {
      pRow = (MemoryCursorRow_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("rowAnag",p_cVarName)) {
      rowAnag = (MemoryCursorRow_sid_invio2)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcRitorno",p_cVarName)) {
      mcRitorno = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcFamiglia",p_cVarName)) {
      mcFamiglia = (MemoryCursor_mcfamiglia_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intestbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_garantbo=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_jarantbo=null;
    CPResultSet Cursor_opextrbo=null;
    CPResultSet Cursor_delegaop=null;
    try {
      /* pRow Row(sid_invio1) */
      /* pDaData Date // Data Inizio Periodo */
      /* pAData Date // Data Fine Periodo */
      /* pTipo Char(1) // Tipo */
      /* mcRitorno MemoryCursor(sid_invio2) */
      /* mcFamiglia MemoryCursor(mcFamiglia.MCRDef) */
      /* rowAnag Row(sid_invio2) */
      /* _conta Numeric(9, 0) */
      /* _notit Numeric(1, 0) */
      /* _presente Numeric(1, 0) */
      /* gDataTito Date // Data per Titolari Effettivi */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* If pTipo='A' or pTipo='M' */
      if (CPLib.eqr(pTipo,"A") || CPLib.eqr(pTipo,"M")) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* If intestbo->DATAINI >= pRow.INIINVIO1 and (Empty(intestbo->DATAFINE) or (not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE  >= pRow.INIINVIO1)) */
          if (CPLib.ge(Cursor_intestbo.GetDate("DATAINI"),pRow.INIINVIO1) && (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),pRow.INIINVIO1)))) {
            /* _notit := 0 */
            _notit = CPLib.Round(0,0);
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_intestbo.GetString("CODINTER"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOTIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _notit = CPLib.Round(Read_Cursor.GetDouble("NOTIT"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arfn_fam_mesefile02 returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _notit = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* rowAnag := arfn_famanag(intestbo->CODINTER,'I') */
            rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_intestbo.GetString("CODINTER"),"I");
            /* mcRitorno.AppendBlank() */
            mcRitorno.AppendBlank();
            /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
            mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
            /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
            mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
            /* mcRitorno.APRINVIO2 := _conta */
            mcRitorno.row.APRINVIO2 = _conta;
            /* mcRitorno.INIINVIO2 := intestbo->DATAINI */
            mcRitorno.row.INIINVIO2 = Cursor_intestbo.GetDate("DATAINI");
            /* If not(Empty(pRow.FININVIO1)) */
            if ( ! (CPLib.Empty(pRow.FININVIO1))) {
              /* If Empty(intestbo->DATAFINE) or intestbo->DATAFINE > pRow.FININVIO1 */
              if (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || CPLib.gt(Cursor_intestbo.GetDate("DATAFINE"),pRow.FININVIO1)) {
                /* mcRitorno.FININVIO2 := pRow.FININVIO1 */
                mcRitorno.row.FININVIO2 = pRow.FININVIO1;
              } else { // Else
                /* mcRitorno.FININVIO2 := intestbo->DATAFINE */
                mcRitorno.row.FININVIO2 = Cursor_intestbo.GetDate("DATAFINE");
              } // End If
            } else { // Else
              /* If Empty(intestbo->DATAFINE) */
              if (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) {
                /* mcRitorno.FININVIO2 := NullDate() */
                mcRitorno.row.FININVIO2 = CPLib.NullDate();
                /* ElseIf not(Empty(intestbo->DATAFINE)) and (intestbo->DATAFINE <= pAData or Empty(pAData)) */
              } else if ( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && (CPLib.le(Cursor_intestbo.GetDate("DATAFINE"),pAData) || CPLib.Empty(pAData))) {
                /* mcRitorno.FININVIO2 := intestbo->DATAFINE */
                mcRitorno.row.FININVIO2 = Cursor_intestbo.GetDate("DATAFINE");
              } // End If
            } // End If
            /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
            mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
            /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
            mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
            /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
            mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
            /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
            mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
            /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
            mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
            /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
            mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
            /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
            mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
            /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
            mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
            /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
            mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
            /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
            mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
            /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
            mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
            /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
            mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
            /* mcRitorno.SaveRow() */
            mcRitorno.SaveRow();
            /* If (intestbo->DATAINI >= gDataTito or Empty(gDataTito)) and _notit=0 and rowAnag.RUOINVIO2 <> '4' */
            if ((CPLib.ge(Cursor_intestbo.GetDate("DATAINI"),gDataTito) || CPLib.Empty(gDataTito)) && CPLib.eqr(_notit,0) && CPLib.ne(rowAnag.RUOINVIO2,"4")) {
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+"  and  NOAGE='N' "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* (intestit->DATAINI <= pAData and (intestit->DATAFINE >= pRow.INIINVIO1 or Empty(intestit->DATAFINE))) or (Empty(pDaData) and Empty(pAData)) */
                /* If ((intestit->DATAINI <= pAData and (intestit->DATAFINE >= pRow.INIINVIO1 or Empty(intestit->DATAFINE))) or (Empty(pDaData) and Empty(pAData))) and not((not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < intestit->DATAINI) or (not(Empty(intestit->DATAFINE)) and intestit->DATAFINE < intestbo->DATAINI)) */
                if (((CPLib.le(Cursor_intestit.GetDate("DATAINI"),pAData) && (CPLib.ge(Cursor_intestit.GetDate("DATAFINE"),pRow.INIINVIO1) || CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")))) || (CPLib.Empty(pDaData) && CPLib.Empty(pAData))) &&  ! (( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_intestit.GetDate("DATAINI"))) || ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestit.GetDate("DATAFINE"),Cursor_intestbo.GetDate("DATAINI"))))) {
                  /* _conta := _conta + 1 */
                  _conta = CPLib.Round(_conta+1,0);
                  /* rowAnag := arfn_famanag(intestit->CODINTER,'T') */
                  rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),"T");
                  /* mcRitorno.AppendBlank() */
                  mcRitorno.AppendBlank();
                  /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
                  mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
                  /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
                  mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
                  /* mcRitorno.APRINVIO2 := _conta */
                  mcRitorno.row.APRINVIO2 = _conta;
                  /* mcRitorno.INIINVIO2 := iif(intestit->DATAINI < pRow.INIINVIO1,pRow.INIINVIO1,intestit->DATAINI) */
                  mcRitorno.row.INIINVIO2 = (CPLib.lt(Cursor_intestit.GetDate("DATAINI"),pRow.INIINVIO1)?pRow.INIINVIO1:Cursor_intestit.GetDate("DATAINI"));
                  /* If not(Empty(pRow.FININVIO1)) */
                  if ( ! (CPLib.Empty(pRow.FININVIO1))) {
                    /* If Empty(intestit->DATAFINE) or intestit->DATAFINE > pRow.FININVIO1 */
                    if (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")) || CPLib.gt(Cursor_intestit.GetDate("DATAFINE"),pRow.FININVIO1)) {
                      /* mcRitorno.FININVIO2 := pRow.FININVIO1 */
                      mcRitorno.row.FININVIO2 = pRow.FININVIO1;
                    } else { // Else
                      /* mcRitorno.FININVIO2 := intestit->DATAFINE */
                      mcRitorno.row.FININVIO2 = Cursor_intestit.GetDate("DATAFINE");
                    } // End If
                  } else { // Else
                    /* If Empty(intestit->DATAFINE) */
                    if (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) {
                      /* mcRitorno.FININVIO2 := NullDate() */
                      mcRitorno.row.FININVIO2 = CPLib.NullDate();
                      /* ElseIf not(Empty(intestit->DATAFINE)) and (intestit->DATAFINE <= pAData or Empty(pAData)) */
                    } else if ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) && (CPLib.le(Cursor_intestit.GetDate("DATAFINE"),pAData) || CPLib.Empty(pAData))) {
                      /* mcRitorno.FININVIO2 := intestit->DATAFINE */
                      mcRitorno.row.FININVIO2 = Cursor_intestit.GetDate("DATAFINE");
                    } // End If
                  } // End If
                  /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
                  mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
                  /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
                  mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
                  /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
                  mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
                  /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
                  mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
                  /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
                  mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
                  /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
                  mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
                  /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
                  mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
                  /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
                  mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
                  /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
                  mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
                  /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
                  mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
                  /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
                  mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
                  /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
                  mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
                  /* mcRitorno.SaveRow() */
                  mcRitorno.SaveRow();
                } // End If
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
            } // End If
          } // End If
          Cursor_intestbo.Next();
        }
        m_cConnectivityError = Cursor_intestbo.ErrorMessage();
        Cursor_intestbo.Close();
        // * --- End Select
        // * --- Select from delegabo
        m_cServer = m_Ctx.GetServer("delegabo");
        m_cPhName = m_Ctx.GetPhName("delegabo");
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
        Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+"  and  NOAGE<>'S' "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_delegabo.Eof())) {
          /* If (delegabo->DATAINI <= pAData) or (Empty(pDaData) and Empty(pAData)) */
          if ((CPLib.le(Cursor_delegabo.GetDate("DATAINI"),pAData)) || (CPLib.Empty(pDaData) && CPLib.Empty(pAData))) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* rowAnag := arfn_famanag(delegabo->CODINTER,'D') */
            rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_delegabo.GetString("CODINTER"),"D");
            /* mcRitorno.AppendBlank() */
            mcRitorno.AppendBlank();
            /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
            mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
            /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
            mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
            /* mcRitorno.APRINVIO2 := _conta */
            mcRitorno.row.APRINVIO2 = _conta;
            /* mcRitorno.INIINVIO2 := iif(delegabo->DATAINI < pRow.INIINVIO1,pRow.INIINVIO1,delegabo->DATAINI) */
            mcRitorno.row.INIINVIO2 = (CPLib.lt(Cursor_delegabo.GetDate("DATAINI"),pRow.INIINVIO1)?pRow.INIINVIO1:Cursor_delegabo.GetDate("DATAINI"));
            /* If not(Empty(pRow.FININVIO1)) */
            if ( ! (CPLib.Empty(pRow.FININVIO1))) {
              /* If Empty(delegabo->DATAFINE) or delegabo->DATAFINE > pRow.FININVIO1 */
              if (CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE")) || CPLib.gt(Cursor_delegabo.GetDate("DATAFINE"),pRow.FININVIO1)) {
                /* mcRitorno.FININVIO2 := pRow.FININVIO1 */
                mcRitorno.row.FININVIO2 = pRow.FININVIO1;
              } else { // Else
                /* mcRitorno.FININVIO2 := delegabo->DATAFINE */
                mcRitorno.row.FININVIO2 = Cursor_delegabo.GetDate("DATAFINE");
              } // End If
            } else { // Else
              /* If Empty(delegabo->DATAFINE) */
              if (CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE"))) {
                /* mcRitorno.FININVIO2 := NullDate() */
                mcRitorno.row.FININVIO2 = CPLib.NullDate();
                /* ElseIf not(Empty(delegabo->DATAFINE)) and (delegabo->DATAFINE <= pAData or Empty(pAData)) */
              } else if ( ! (CPLib.Empty(Cursor_delegabo.GetDate("DATAFINE"))) && (CPLib.le(Cursor_delegabo.GetDate("DATAFINE"),pAData) || CPLib.Empty(pAData))) {
                /* mcRitorno.FININVIO2 := delegabo->DATAFINE */
                mcRitorno.row.FININVIO2 = Cursor_delegabo.GetDate("DATAFINE");
              } // End If
            } // End If
            /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
            mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
            /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
            mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
            /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
            mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
            /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
            mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
            /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
            mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
            /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
            mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
            /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
            mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
            /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
            mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
            /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
            mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
            /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
            mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
            /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
            mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
            /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
            mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
            /* mcRitorno.SaveRow() */
            mcRitorno.SaveRow();
          } // End If
          Cursor_delegabo.Next();
        }
        m_cConnectivityError = Cursor_delegabo.ErrorMessage();
        Cursor_delegabo.Close();
        // * --- End Select
        // * --- Select from garantbo
        m_cServer = m_Ctx.GetServer("garantbo");
        m_cPhName = m_Ctx.GetPhName("garantbo");
        if (Cursor_garantbo!=null)
          Cursor_garantbo.Close();
        Cursor_garantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+" "+")"+(m_Ctx.IsSharedTemp("garantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_garantbo.Eof())) {
          /* If pRow.TPRINVIO1='16' */
          if (CPLib.eqr(pRow.TPRINVIO1,"16")) {
            /* If (garantbo->DATAINI <= pAData) or (Empty(pDaData) and Empty(pAData)) */
            if ((CPLib.le(Cursor_garantbo.GetDate("DATAINI"),pAData)) || (CPLib.Empty(pDaData) && CPLib.Empty(pAData))) {
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              /* rowAnag := arfn_famanag(garantbo->CODINTER,'G') */
              rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_garantbo.GetString("CODINTER"),"G");
              /* mcRitorno.AppendBlank() */
              mcRitorno.AppendBlank();
              /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
              mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
              /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
              mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
              /* mcRitorno.APRINVIO2 := _conta */
              mcRitorno.row.APRINVIO2 = _conta;
              /* mcRitorno.INIINVIO2 := iif(garantbo->DATAINI < pRow.INIINVIO1,pRow.INIINVIO1,garantbo->DATAINI) */
              mcRitorno.row.INIINVIO2 = (CPLib.lt(Cursor_garantbo.GetDate("DATAINI"),pRow.INIINVIO1)?pRow.INIINVIO1:Cursor_garantbo.GetDate("DATAINI"));
              /* If not(Empty(pRow.FININVIO1)) */
              if ( ! (CPLib.Empty(pRow.FININVIO1))) {
                /* If Empty(garantbo->DATAFINE) or garantbo->DATAFINE > pRow.FININVIO1 */
                if (CPLib.Empty(Cursor_garantbo.GetDate("DATAFINE")) || CPLib.gt(Cursor_garantbo.GetDate("DATAFINE"),pRow.FININVIO1)) {
                  /* mcRitorno.FININVIO2 := pRow.FININVIO1 */
                  mcRitorno.row.FININVIO2 = pRow.FININVIO1;
                } else { // Else
                  /* mcRitorno.FININVIO2 := garantbo->DATAFINE */
                  mcRitorno.row.FININVIO2 = Cursor_garantbo.GetDate("DATAFINE");
                } // End If
              } else { // Else
                /* If Empty(garantbo->DATAFINE) */
                if (CPLib.Empty(Cursor_garantbo.GetDate("DATAFINE"))) {
                  /* mcRitorno.FININVIO2 := NullDate() */
                  mcRitorno.row.FININVIO2 = CPLib.NullDate();
                  /* ElseIf not(Empty(garantbo->DATAFINE)) and (garantbo->DATAFINE <= pAData or Empty(pAData)) */
                } else if ( ! (CPLib.Empty(Cursor_garantbo.GetDate("DATAFINE"))) && (CPLib.le(Cursor_garantbo.GetDate("DATAFINE"),pAData) || CPLib.Empty(pAData))) {
                  /* mcRitorno.FININVIO2 := garantbo->DATAFINE */
                  mcRitorno.row.FININVIO2 = Cursor_garantbo.GetDate("DATAFINE");
                } // End If
              } // End If
              /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
              mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
              /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
              mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
              /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
              mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
              /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
              mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
              /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
              mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
              /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
              mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
              /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
              mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
              /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
              mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
              /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
              mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
              /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
              mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
              /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
              mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
              /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
              mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
              /* mcRitorno.SaveRow() */
              mcRitorno.SaveRow();
            } // End If
          } // End If
          Cursor_garantbo.Next();
        }
        m_cConnectivityError = Cursor_garantbo.ErrorMessage();
        Cursor_garantbo.Close();
        // * --- End Select
      } // End If
      /* If pTipo='J' or pTipo='N' */
      if (CPLib.eqr(pTipo,"J") || CPLib.eqr(pTipo,"N")) {
        // * --- Select from jntestbo
        m_cServer = m_Ctx.GetServer("jntestbo");
        m_cPhName = m_Ctx.GetPhName("jntestbo");
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
        Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jntestbo.Eof())) {
          /* If jntestbo->DATAINI >= pRow.INIINVIO1 and (Empty(jntestbo->DATAFINE) or (not(Empty(jntestbo->DATAFINE)) and jntestbo->DATAFINE  >= pRow.INIINVIO1)) */
          if (CPLib.ge(Cursor_jntestbo.GetDate("DATAINI"),pRow.INIINVIO1) && (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE")) || ( ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) && CPLib.ge(Cursor_jntestbo.GetDate("DATAFINE"),pRow.INIINVIO1)))) {
            /* _notit := 0 */
            _notit = CPLib.Round(0,0);
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"C",16,0,m_cServer),m_cServer,Cursor_jntestbo.GetString("CODINTER"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOTIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _notit = CPLib.Round(Read_Cursor.GetDouble("NOTIT"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arfn_fam_mesefile02 returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _notit = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* rowAnag := arfn_famanag(jntestbo->CODINTER,'I') */
            rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_jntestbo.GetString("CODINTER"),"I");
            /* mcRitorno.AppendBlank() */
            mcRitorno.AppendBlank();
            /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
            mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
            /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
            mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
            /* mcRitorno.APRINVIO2 := _conta */
            mcRitorno.row.APRINVIO2 = _conta;
            /* mcRitorno.INIINVIO2 := jntestbo->DATAINI */
            mcRitorno.row.INIINVIO2 = Cursor_jntestbo.GetDate("DATAINI");
            /* If not(Empty(pRow.FININVIO1)) */
            if ( ! (CPLib.Empty(pRow.FININVIO1))) {
              /* If Empty(jntestbo->DATAFINE) or jntestbo->DATAFINE > pRow.FININVIO1 */
              if (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE")) || CPLib.gt(Cursor_jntestbo.GetDate("DATAFINE"),pRow.FININVIO1)) {
                /* mcRitorno.FININVIO2 := pRow.FININVIO1 */
                mcRitorno.row.FININVIO2 = pRow.FININVIO1;
              } else { // Else
                /* mcRitorno.FININVIO2 := jntestbo->DATAFINE */
                mcRitorno.row.FININVIO2 = Cursor_jntestbo.GetDate("DATAFINE");
              } // End If
            } else { // Else
              /* If Empty(jntestbo->DATAFINE) */
              if (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) {
                /* mcRitorno.FININVIO2 := NullDate() */
                mcRitorno.row.FININVIO2 = CPLib.NullDate();
                /* ElseIf not(Empty(jntestbo->DATAFINE)) and (jntestbo->DATAFINE <= pAData or Empty(pAData)) */
              } else if ( ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) && (CPLib.le(Cursor_jntestbo.GetDate("DATAFINE"),pAData) || CPLib.Empty(pAData))) {
                /* mcRitorno.FININVIO2 := jntestbo->DATAFINE */
                mcRitorno.row.FININVIO2 = Cursor_jntestbo.GetDate("DATAFINE");
              } // End If
            } // End If
            /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
            mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
            /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
            mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
            /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
            mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
            /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
            mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
            /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
            mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
            /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
            mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
            /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
            mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
            /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
            mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
            /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
            mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
            /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
            mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
            /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
            mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
            /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
            mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
            /* mcRitorno.SaveRow() */
            mcRitorno.SaveRow();
            /* If (jntestbo->DATAINI >= gDataTito or Empty(gDataTito)) and _notit=0 and rowAnag.RUOINVIO2 <> '4' */
            if ((CPLib.ge(Cursor_jntestbo.GetDate("DATAINI"),gDataTito) || CPLib.Empty(gDataTito)) && CPLib.eqr(_notit,0) && CPLib.ne(rowAnag.RUOINVIO2,"4")) {
              // * --- Select from jntestit
              m_cServer = m_Ctx.GetServer("jntestit");
              m_cPhName = m_Ctx.GetPhName("jntestit");
              if (Cursor_jntestit!=null)
                Cursor_jntestit.Close();
              Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_jntestit.Eof())) {
                /* (jntestit->DATAINI <= pAData and (jntestit->DATAFINE >= pRow.INIINVIO1 or Empty(jntestit->DATAFINE))) or (Empty(pDaData) and Empty(pAData)) and not(jntestbo->DATAFINE < jntestit->DATAINI or jntestit->DATAFINE < jntestbo->DATAINI) */
                /* If ((jntestit->DATAINI <= pAData and (jntestit->DATAFINE >= pRow.INIINVIO1 or Empty(jntestit->DATAFINE))) or (Empty(pDaData) and Empty(pAData))) and not((not(Empty(jntestbo->DATAFINE)) and jntestbo->DATAFINE < jntestit->DATAINI) or (not(Empty(jntestit->DATAFINE)) and jntestit->DATAFINE < jntestbo->DATAINI)) */
                if (((CPLib.le(Cursor_jntestit.GetDate("DATAINI"),pAData) && (CPLib.ge(Cursor_jntestit.GetDate("DATAFINE"),pRow.INIINVIO1) || CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE")))) || (CPLib.Empty(pDaData) && CPLib.Empty(pAData))) &&  ! (( ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_jntestbo.GetDate("DATAFINE"),Cursor_jntestit.GetDate("DATAINI"))) || ( ! (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE"))) && CPLib.lt(Cursor_jntestit.GetDate("DATAFINE"),Cursor_jntestbo.GetDate("DATAINI"))))) {
                  /* _conta := _conta + 1 */
                  _conta = CPLib.Round(_conta+1,0);
                  /* rowAnag := arfn_famanag(jntestit->CODINTER,'T') */
                  rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_jntestit.GetString("CODINTER"),"T");
                  /* mcRitorno.AppendBlank() */
                  mcRitorno.AppendBlank();
                  /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
                  mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
                  /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
                  mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
                  /* mcRitorno.APRINVIO2 := _conta */
                  mcRitorno.row.APRINVIO2 = _conta;
                  /* mcRitorno.INIINVIO2 := iif(jntestit->DATAINI < pRow.INIINVIO1,pRow.INIINVIO1,jntestit->DATAINI) */
                  mcRitorno.row.INIINVIO2 = (CPLib.lt(Cursor_jntestit.GetDate("DATAINI"),pRow.INIINVIO1)?pRow.INIINVIO1:Cursor_jntestit.GetDate("DATAINI"));
                  /* If not(Empty(pRow.FININVIO1)) */
                  if ( ! (CPLib.Empty(pRow.FININVIO1))) {
                    /* If Empty(jntestit->DATAFINE) or jntestit->DATAFINE > pRow.FININVIO1 */
                    if (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE")) || CPLib.gt(Cursor_jntestit.GetDate("DATAFINE"),pRow.FININVIO1)) {
                      /* mcRitorno.FININVIO2 := pRow.FININVIO1 */
                      mcRitorno.row.FININVIO2 = pRow.FININVIO1;
                    } else { // Else
                      /* mcRitorno.FININVIO2 := jntestit->DATAFINE */
                      mcRitorno.row.FININVIO2 = Cursor_jntestit.GetDate("DATAFINE");
                    } // End If
                  } else { // Else
                    /* If Empty(jntestit->DATAFINE) */
                    if (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE"))) {
                      /* mcRitorno.FININVIO2 := NullDate() */
                      mcRitorno.row.FININVIO2 = CPLib.NullDate();
                      /* ElseIf not(Empty(jntestit->DATAFINE)) and (jntestit->DATAFINE <= pAData or Empty(pAData)) */
                    } else if ( ! (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE"))) && (CPLib.le(Cursor_jntestit.GetDate("DATAFINE"),pAData) || CPLib.Empty(pAData))) {
                      /* mcRitorno.FININVIO2 := jntestit->DATAFINE */
                      mcRitorno.row.FININVIO2 = Cursor_jntestit.GetDate("DATAFINE");
                    } // End If
                  } // End If
                  /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
                  mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
                  /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
                  mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
                  /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
                  mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
                  /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
                  mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
                  /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
                  mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
                  /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
                  mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
                  /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
                  mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
                  /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
                  mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
                  /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
                  mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
                  /* mcRitorno.RGSINVIO2 := Left(rowAnag.RGSINVIO2,60) */
                  mcRitorno.row.RGSINVIO2 = CPLib.Left(rowAnag.RGSINVIO2,60);
                  /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
                  mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
                  /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
                  mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
                  /* mcRitorno.SaveRow() */
                  mcRitorno.SaveRow();
                  /* mcFamiglia.AppendBlank() */
                  mcFamiglia.AppendBlank();
                  /* mcFamiglia.TIPOSOG := '7-Titolare Effettivo' */
                  mcFamiglia.row.TIPOSOG = "7-Titolare Effettivo";
                  /* mcFamiglia.CODINTER := jntestit->CODINTER */
                  mcFamiglia.row.CODINTER = Cursor_jntestit.GetString("CODINTER");
                  /* mcFamiglia.SaveRow() */
                  mcFamiglia.SaveRow();
                } // End If
                Cursor_jntestit.Next();
              }
              m_cConnectivityError = Cursor_jntestit.ErrorMessage();
              Cursor_jntestit.Close();
              // * --- End Select
              // * --- Select from intestit
              m_cServer = m_Ctx.GetServer("intestit");
              m_cPhName = m_Ctx.GetPhName("intestit");
              if (Cursor_intestit!=null)
                Cursor_intestit.Close();
              Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+"  and  NOAGE='N' "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestit.Eof())) {
                /* _presente := 0 */
                _presente = CPLib.Round(0,0);
                for (MemoryCursorRow_mcfamiglia_mcrdef rwFamiglia : mcFamiglia._iterable_()) {
                  /* If rwFamiglia.CODINTER=intestit->CODINTER */
                  if (CPLib.eqr(rwFamiglia.CODINTER,Cursor_intestit.GetString("CODINTER"))) {
                    /* _presente := 1 */
                    _presente = CPLib.Round(1,0);
                  } // End If
                }
                /* If _presente=0 */
                if (CPLib.eqr(_presente,0)) {
                  /* If ((intestit->DATAINI <= pAData and (intestit->DATAFINE >= pRow.INIINVIO1 or Empty(intestit->DATAFINE))) or (Empty(pDaData) and Empty(pAData))) and not((not(Empty(jntestbo->DATAFINE)) and jntestbo->DATAFINE < intestit->DATAINI) or (not(Empty(intestit->DATAFINE)) and intestit->DATAFINE < jntestbo->DATAINI)) */
                  if (((CPLib.le(Cursor_intestit.GetDate("DATAINI"),pAData) && (CPLib.ge(Cursor_intestit.GetDate("DATAFINE"),pRow.INIINVIO1) || CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")))) || (CPLib.Empty(pDaData) && CPLib.Empty(pAData))) &&  ! (( ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_jntestbo.GetDate("DATAFINE"),Cursor_intestit.GetDate("DATAINI"))) || ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestit.GetDate("DATAFINE"),Cursor_jntestbo.GetDate("DATAINI"))))) {
                    /* _conta := _conta + 1 */
                    _conta = CPLib.Round(_conta+1,0);
                    /* rowAnag := arfn_famanag(intestit->CODINTER,'T') */
                    rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_intestit.GetString("CODINTER"),"T");
                    /* mcRitorno.AppendBlank() */
                    mcRitorno.AppendBlank();
                    /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
                    mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
                    /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
                    mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
                    /* mcRitorno.APRINVIO2 := _conta */
                    mcRitorno.row.APRINVIO2 = _conta;
                    /* mcRitorno.INIINVIO2 := iif(intestit->DATAINI < pRow.INIINVIO1,pRow.INIINVIO1,intestit->DATAINI) */
                    mcRitorno.row.INIINVIO2 = (CPLib.lt(Cursor_intestit.GetDate("DATAINI"),pRow.INIINVIO1)?pRow.INIINVIO1:Cursor_intestit.GetDate("DATAINI"));
                    /* If not(Empty(pRow.FININVIO1)) */
                    if ( ! (CPLib.Empty(pRow.FININVIO1))) {
                      /* If Empty(intestit->DATAFINE) or intestit->DATAFINE > pRow.FININVIO1 */
                      if (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")) || CPLib.gt(Cursor_intestit.GetDate("DATAFINE"),pRow.FININVIO1)) {
                        /* mcRitorno.FININVIO2 := pRow.FININVIO1 */
                        mcRitorno.row.FININVIO2 = pRow.FININVIO1;
                      } else { // Else
                        /* mcRitorno.FININVIO2 := intestit->DATAFINE */
                        mcRitorno.row.FININVIO2 = Cursor_intestit.GetDate("DATAFINE");
                      } // End If
                    } else { // Else
                      /* If Empty(intestit->DATAFINE) */
                      if (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) {
                        /* mcRitorno.FININVIO2 := NullDate() */
                        mcRitorno.row.FININVIO2 = CPLib.NullDate();
                        /* ElseIf not(Empty(intestit->DATAFINE)) and (intestit->DATAFINE <= pAData or Empty(pAData)) */
                      } else if ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) && (CPLib.le(Cursor_intestit.GetDate("DATAFINE"),pAData) || CPLib.Empty(pAData))) {
                        /* mcRitorno.FININVIO2 := intestit->DATAFINE */
                        mcRitorno.row.FININVIO2 = Cursor_intestit.GetDate("DATAFINE");
                      } // End If
                    } // End If
                    /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
                    mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
                    /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
                    mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
                    /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
                    mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
                    /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
                    mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
                    /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
                    mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
                    /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
                    mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
                    /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
                    mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
                    /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
                    mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
                    /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
                    mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
                    /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
                    mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
                    /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
                    mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
                    /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
                    mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
                    /* mcRitorno.SaveRow() */
                    mcRitorno.SaveRow();
                  } // End If
                } // End If
                Cursor_intestit.Next();
              }
              m_cConnectivityError = Cursor_intestit.ErrorMessage();
              Cursor_intestit.Close();
              // * --- End Select
            } // End If
          } // End If
          Cursor_jntestbo.Next();
        }
        m_cConnectivityError = Cursor_jntestbo.ErrorMessage();
        Cursor_jntestbo.Close();
        // * --- End Select
        // * --- Select from jelegabo
        m_cServer = m_Ctx.GetServer("jelegabo");
        m_cPhName = m_Ctx.GetPhName("jelegabo");
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
        Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jelegabo.Eof())) {
          /* If (jelegabo->DATAINI <= pAData) or (Empty(pDaData) and Empty(pAData)) */
          if ((CPLib.le(Cursor_jelegabo.GetDate("DATAINI"),pAData)) || (CPLib.Empty(pDaData) && CPLib.Empty(pAData))) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* rowAnag := arfn_famanag(jelegabo->CODINTER,'D') */
            rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_jelegabo.GetString("CODINTER"),"D");
            /* mcRitorno.AppendBlank() */
            mcRitorno.AppendBlank();
            /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
            mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
            /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
            mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
            /* mcRitorno.APRINVIO2 := _conta */
            mcRitorno.row.APRINVIO2 = _conta;
            /* mcRitorno.INIINVIO2 := iif(jelegabo->DATAINI < pRow.INIINVIO1,pRow.INIINVIO1,jelegabo->DATAINI) */
            mcRitorno.row.INIINVIO2 = (CPLib.lt(Cursor_jelegabo.GetDate("DATAINI"),pRow.INIINVIO1)?pRow.INIINVIO1:Cursor_jelegabo.GetDate("DATAINI"));
            /* If not(Empty(pRow.FININVIO1)) */
            if ( ! (CPLib.Empty(pRow.FININVIO1))) {
              /* If Empty(jelegabo->DATAFINE) or jelegabo->DATAFINE > pRow.FININVIO1 */
              if (CPLib.Empty(Cursor_jelegabo.GetDate("DATAFINE")) || CPLib.gt(Cursor_jelegabo.GetDate("DATAFINE"),pRow.FININVIO1)) {
                /* mcRitorno.FININVIO2 := pRow.FININVIO1 */
                mcRitorno.row.FININVIO2 = pRow.FININVIO1;
              } else { // Else
                /* mcRitorno.FININVIO2 := jelegabo->DATAFINE */
                mcRitorno.row.FININVIO2 = Cursor_jelegabo.GetDate("DATAFINE");
              } // End If
            } else { // Else
              /* If Empty(jelegabo->DATAFINE) */
              if (CPLib.Empty(Cursor_jelegabo.GetDate("DATAFINE"))) {
                /* mcRitorno.FININVIO2 := NullDate() */
                mcRitorno.row.FININVIO2 = CPLib.NullDate();
                /* ElseIf not(Empty(jelegabo->DATAFINE)) and (jelegabo->DATAFINE <= pAData or Empty(pAData)) */
              } else if ( ! (CPLib.Empty(Cursor_jelegabo.GetDate("DATAFINE"))) && (CPLib.le(Cursor_jelegabo.GetDate("DATAFINE"),pAData) || CPLib.Empty(pAData))) {
                /* mcRitorno.FININVIO2 := jelegabo->DATAFINE */
                mcRitorno.row.FININVIO2 = Cursor_jelegabo.GetDate("DATAFINE");
              } // End If
            } // End If
            /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
            mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
            /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
            mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
            /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
            mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
            /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
            mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
            /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
            mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
            /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
            mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
            /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
            mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
            /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
            mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
            /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
            mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
            /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
            mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
            /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
            mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
            /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
            mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
            /* mcRitorno.SaveRow() */
            mcRitorno.SaveRow();
          } // End If
          Cursor_jelegabo.Next();
        }
        m_cConnectivityError = Cursor_jelegabo.ErrorMessage();
        Cursor_jelegabo.Close();
        // * --- End Select
        // * --- Select from jarantbo
        m_cServer = m_Ctx.GetServer("jarantbo");
        m_cPhName = m_Ctx.GetPhName("jarantbo");
        if (Cursor_jarantbo!=null)
          Cursor_jarantbo.Close();
        Cursor_jarantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+" "+")"+(m_Ctx.IsSharedTemp("jarantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_jarantbo.Eof())) {
          /* If pRow.TPRINVIO1='16' */
          if (CPLib.eqr(pRow.TPRINVIO1,"16")) {
            /* If (jarantbo->DATAINI <= pAData) or (Empty(pDaData) and Empty(pAData)) */
            if ((CPLib.le(Cursor_jarantbo.GetDate("DATAINI"),pAData)) || (CPLib.Empty(pDaData) && CPLib.Empty(pAData))) {
              /* _conta := _conta + 1 */
              _conta = CPLib.Round(_conta+1,0);
              /* rowAnag := arfn_famanag(jarantbo->CODINTER,'G') */
              rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_jarantbo.GetString("CODINTER"),"G");
              /* mcRitorno.AppendBlank() */
              mcRitorno.AppendBlank();
              /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
              mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
              /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
              mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
              /* mcRitorno.APRINVIO2 := _conta */
              mcRitorno.row.APRINVIO2 = _conta;
              /* mcRitorno.INIINVIO2 := iif(jarantbo->DATAINI < pRow.INIINVIO1,pRow.INIINVIO1,jarantbo->DATAINI) */
              mcRitorno.row.INIINVIO2 = (CPLib.lt(Cursor_jarantbo.GetDate("DATAINI"),pRow.INIINVIO1)?pRow.INIINVIO1:Cursor_jarantbo.GetDate("DATAINI"));
              /* If not(Empty(pRow.FININVIO1)) */
              if ( ! (CPLib.Empty(pRow.FININVIO1))) {
                /* If Empty(jarantbo->DATAFINE) or jarantbo->DATAFINE > pRow.FININVIO1 */
                if (CPLib.Empty(Cursor_jarantbo.GetDate("DATAFINE")) || CPLib.gt(Cursor_jarantbo.GetDate("DATAFINE"),pRow.FININVIO1)) {
                  /* mcRitorno.FININVIO2 := pRow.FININVIO1 */
                  mcRitorno.row.FININVIO2 = pRow.FININVIO1;
                } else { // Else
                  /* mcRitorno.FININVIO2 := jarantbo->DATAFINE */
                  mcRitorno.row.FININVIO2 = Cursor_jarantbo.GetDate("DATAFINE");
                } // End If
              } else { // Else
                /* If Empty(jarantbo->DATAFINE) */
                if (CPLib.Empty(Cursor_jarantbo.GetDate("DATAFINE"))) {
                  /* mcRitorno.FININVIO2 := NullDate() */
                  mcRitorno.row.FININVIO2 = CPLib.NullDate();
                  /* ElseIf not(Empty(jarantbo->DATAFINE)) and (jarantbo->DATAFINE <= pAData or Empty(pAData)) */
                } else if ( ! (CPLib.Empty(Cursor_jarantbo.GetDate("DATAFINE"))) && (CPLib.le(Cursor_jarantbo.GetDate("DATAFINE"),pAData) || CPLib.Empty(pAData))) {
                  /* mcRitorno.FININVIO2 := jarantbo->DATAFINE */
                  mcRitorno.row.FININVIO2 = Cursor_jarantbo.GetDate("DATAFINE");
                } // End If
              } // End If
              /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
              mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
              /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
              mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
              /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
              mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
              /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
              mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
              /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
              mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
              /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
              mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
              /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
              mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
              /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
              mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
              /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
              mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
              /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
              mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
              /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
              mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
              /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
              mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
              /* mcRitorno.SaveRow() */
              mcRitorno.SaveRow();
            } // End If
          } // End If
          Cursor_jarantbo.Next();
        }
        m_cConnectivityError = Cursor_jarantbo.ErrorMessage();
        Cursor_jarantbo.Close();
        // * --- End Select
      } // End If
      /* If pTipo='O' or pTipo='Q' */
      if (CPLib.eqr(pTipo,"O") || CPLib.eqr(pTipo,"Q")) {
        // * --- Select from opextrbo
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
        Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRow.RAPINVIO1,"?",0,0,m_cServer, m_oParameters),m_cServer,pRow.RAPINVIO1)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_opextrbo.Eof())) {
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          /* rowAnag := arfn_famanag(opextrbo->COLLEG,'I') */
          rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_opextrbo.GetString("COLLEG"),"I");
          /* mcRitorno.AppendBlank() */
          mcRitorno.AppendBlank();
          /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
          mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
          /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
          mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
          /* mcRitorno.APRINVIO2 := _conta */
          mcRitorno.row.APRINVIO2 = _conta;
          /* mcRitorno.INIINVIO2 := opextrbo->DATAOPE */
          mcRitorno.row.INIINVIO2 = Cursor_opextrbo.GetDate("DATAOPE");
          /* mcRitorno.FININVIO2 := NullDate() */
          mcRitorno.row.FININVIO2 = CPLib.NullDate();
          /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
          mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
          /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
          mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
          /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
          mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
          /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
          mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
          /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
          mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
          /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
          mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
          /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
          mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
          /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
          mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
          /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
          mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
          /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
          mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
          /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
          mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
          /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
          mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
          /* mcRitorno.SaveRow() */
          mcRitorno.SaveRow();
          /* If not(Empty(opextrbo->CONNESOPER)) */
          if ( ! (CPLib.Empty(Cursor_opextrbo.GetString("CONNESOPER")))) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* rowAnag := arfn_famanag(opextrbo->CONNESOPER,'S') */
            rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_opextrbo.GetString("CONNESOPER"),"S");
            /* mcRitorno.AppendBlank() */
            mcRitorno.AppendBlank();
            /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
            mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
            /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
            mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
            /* mcRitorno.APRINVIO2 := _conta */
            mcRitorno.row.APRINVIO2 = _conta;
            /* mcRitorno.INIINVIO2 := opextrbo->DATAOPE */
            mcRitorno.row.INIINVIO2 = Cursor_opextrbo.GetDate("DATAOPE");
            /* mcRitorno.FININVIO2 := NullDate() */
            mcRitorno.row.FININVIO2 = CPLib.NullDate();
            /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
            mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
            /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
            mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
            /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
            mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
            /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
            mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
            /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
            mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
            /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
            mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
            /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
            mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
            /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
            mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
            /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
            mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
            /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
            mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
            /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
            mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
            /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
            mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
            /* mcRitorno.SaveRow() */
            mcRitorno.SaveRow();
          } // End If
          // * --- Select from delegaop
          m_cServer = m_Ctx.GetServer("delegaop");
          m_cPhName = m_Ctx.GetPhName("delegaop");
          if (Cursor_delegaop!=null)
            Cursor_delegaop.Close();
          Cursor_delegaop = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"COLLEG="+CPLib.ToSQL(Cursor_opextrbo.GetString("COLLEG"),"?",0,0)+"  and  ANNO="+CPLib.ToSQL(Cursor_opextrbo.GetString("ANNO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("delegaop")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_delegaop.Eof())) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* rowAnag := arfn_famanag(delegaop->CODINTER,'S') */
            rowAnag = arfn_famanagR.Make(m_Ctx,this).Run(Cursor_delegaop.GetString("CODINTER"),"S");
            /* mcRitorno.AppendBlank() */
            mcRitorno.AppendBlank();
            /* mcRitorno.CODINVIO2 := pRow.CODINVIO1 */
            mcRitorno.row.CODINVIO2 = pRow.CODINVIO1;
            /* mcRitorno.RAPINVIO2 := pRow.RAPINVIO1 */
            mcRitorno.row.RAPINVIO2 = pRow.RAPINVIO1;
            /* mcRitorno.APRINVIO2 := _conta */
            mcRitorno.row.APRINVIO2 = _conta;
            /* mcRitorno.INIINVIO2 := opextrbo->DATAOPE */
            mcRitorno.row.INIINVIO2 = Cursor_opextrbo.GetDate("DATAOPE");
            /* mcRitorno.FININVIO2 := NullDate() */
            mcRitorno.row.FININVIO2 = CPLib.NullDate();
            /* mcRitorno.FCFINVIO2 := rowAnag.FCFINVIO2 */
            mcRitorno.row.FCFINVIO2 = rowAnag.FCFINVIO2;
            /* mcRitorno.CFSINVIO2 := rowAnag.CFSINVIO2 */
            mcRitorno.row.CFSINVIO2 = rowAnag.CFSINVIO2;
            /* mcRitorno.RUOINVIO2 := rowAnag.RUOINVIO2 */
            mcRitorno.row.RUOINVIO2 = rowAnag.RUOINVIO2;
            /* mcRitorno.COGINVIO2 := rowAnag.COGINVIO2 */
            mcRitorno.row.COGINVIO2 = rowAnag.COGINVIO2;
            /* mcRitorno.NOMINVIO2 := rowAnag.NOMINVIO2 */
            mcRitorno.row.NOMINVIO2 = rowAnag.NOMINVIO2;
            /* mcRitorno.SEXINVIO2 := rowAnag.SEXINVIO2 */
            mcRitorno.row.SEXINVIO2 = rowAnag.SEXINVIO2;
            /* mcRitorno.DNSINVIO2 := rowAnag.DNSINVIO2 */
            mcRitorno.row.DNSINVIO2 = rowAnag.DNSINVIO2;
            /* mcRitorno.CNSINVIO2 := rowAnag.CNSINVIO2 */
            mcRitorno.row.CNSINVIO2 = rowAnag.CNSINVIO2;
            /* mcRitorno.PNSINVIO2 := rowAnag.PNSINVIO2 */
            mcRitorno.row.PNSINVIO2 = rowAnag.PNSINVIO2;
            /* mcRitorno.RGSINVIO2 := rowAnag.RGSINVIO2 */
            mcRitorno.row.RGSINVIO2 = rowAnag.RGSINVIO2;
            /* mcRitorno.CSLINVIO2 := rowAnag.CSLINVIO2 */
            mcRitorno.row.CSLINVIO2 = rowAnag.CSLINVIO2;
            /* mcRitorno.PLSINVIO2 := rowAnag.PLSINVIO2 */
            mcRitorno.row.PLSINVIO2 = rowAnag.PLSINVIO2;
            /* mcRitorno.SaveRow() */
            mcRitorno.SaveRow();
            Cursor_delegaop.Next();
          }
          m_cConnectivityError = Cursor_delegaop.ErrorMessage();
          Cursor_delegaop.Close();
          // * --- End Select
          Cursor_opextrbo.Next();
        }
        m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
        Cursor_opextrbo.Close();
        // * --- End Select
      } // End If
      /* Return mcRitorno */
      throw new Stop(mcRitorno);
    } finally {
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegabo!=null)
          Cursor_delegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_garantbo!=null)
          Cursor_garantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestbo!=null)
          Cursor_jntestbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jntestit!=null)
          Cursor_jntestit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jelegabo!=null)
          Cursor_jelegabo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_jarantbo!=null)
          Cursor_jarantbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_opextrbo!=null)
          Cursor_opextrbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_delegaop!=null)
          Cursor_delegaop.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(MemoryCursorRow_sid_invio1 p_pRow,java.sql.Date p_pDaData,java.sql.Date p_pAData,String p_pTipo) {
    pRow = p_pRow;
    pDaData = p_pDaData;
    pAData = p_pAData;
    pTipo = p_pTipo;
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
  public MemoryCursor_sid_invio2 Run(MemoryCursorRow_sid_invio1 p_pRow,java.sql.Date p_pDaData,java.sql.Date p_pAData,String p_pTipo) {
    pRow = p_pRow;
    pDaData = p_pDaData;
    pAData = p_pAData;
    pTipo = p_pTipo;
    return Run();
  }
  public MemoryCursor_sid_invio2 Run() {
    MemoryCursor_sid_invio2 l_result;
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
        l_result = (MemoryCursor_sid_invio2)stop_value.GetObject();
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
  public static arfn_fam_mesefile02R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_fam_mesefile02R(p_Ctx, p_Caller);
  }
  public static arfn_fam_mesefile02R Make(CPContext p_Ctx) {
    return new arfn_fam_mesefile02R(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRow = new MemoryCursorRow_sid_invio1();
    pDaData = CPLib.NullDate();
    pAData = CPLib.NullDate();
    pTipo = CPLib.Space(1);
    mcRitorno = new MemoryCursor_sid_invio2();
    mcFamiglia = new MemoryCursor_mcfamiglia_mcrdef();
    rowAnag = new MemoryCursorRow_sid_invio2();
    _conta = 0;
    _notit = 0;
    _presente = 0;
    gDataTito=m_Ctx.GetGlobalDate("gDataTito");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fam_mesefile02,arfn_famanag,
  public static final String i_InvokedRoutines = ",arfn_fam_mesefile02,arfn_famanag,";
  public static String[] m_cRunParameterNames={"pRow","pDaData","pAData","pTipo"};
}
