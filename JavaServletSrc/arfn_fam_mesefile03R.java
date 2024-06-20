// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_fam_mesefile03R implements CallerWithObjs {
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
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
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
  public double pAnno;
  public String pTipo;
  public String pValuta;
  public MemoryCursor_sid_invio3 mcRitorno;
  public MemoryCursorRow_sid_invio3 rowSaldi;
  public double _conta;
  public String cAnno;
  public String _annomin;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_fam_mesefile03R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_fam_mesefile03",m_Caller);
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
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
      return "arfn_fam_mesefile03";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pValuta",p_cVarName)) {
      return pValuta;
    }
    if (CPLib.eqr("cAnno",p_cVarName)) {
      return cAnno;
    }
    if (CPLib.eqr("_annomin",p_cVarName)) {
      return _annomin;
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
    if (CPLib.eqr("mcRitorno",p_cVarName)) {
      return mcRitorno;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pRow",p_cVarName)) {
      return pRow;
    }
    if (CPLib.eqr("rowSaldi",p_cVarName)) {
      return rowSaldi;
    }
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pValuta",p_cVarName)) {
      pValuta = value;
      return;
    }
    if (CPLib.eqr("cAnno",p_cVarName)) {
      cAnno = value;
      return;
    }
    if (CPLib.eqr("_annomin",p_cVarName)) {
      _annomin = value;
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
    if (CPLib.eqr("pRow",p_cVarName)) {
      pRow = (MemoryCursorRow_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("rowSaldi",p_cVarName)) {
      rowSaldi = (MemoryCursorRow_sid_invio3)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcRitorno",p_cVarName)) {
      mcRitorno = (MemoryCursor_sid_invio3)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_aeannora=null;
    CPResultSet Cursor_opextrbo=null;
    try {
      /* pRow Row(sid_invio1) */
      /* pAnno Numeric(4, 0) // Anno di riferimento */
      /* pTipo Char(1) // Anno di riferimento */
      /* pValuta Char(1) // Anno di riferimento */
      /* mcRitorno MemoryCursor(sid_invio3) */
      /* rowSaldi Row(sid_invio3) */
      /* _conta Numeric(9, 0) */
      /* cAnno Char(4) */
      /* cAnno Char(4) */
      /* _annomin Char(4) */
      /* _annomin := Str(Year(Date()) - 10,4,0) */
      _annomin = CPLib.Str(CPLib.Year(CPLib.Date())-10,4,0);
      /* If At(pTipo,'|A|M|J|N') > 0 */
      if (CPLib.gt(CPLib.At(pTipo,"|A|M|J|N"),0)) {
        /* If pRow.TIPINVIO1='1' and pRow.TPCINVIO1='3' */
        if (CPLib.eqr(pRow.TIPINVIO1,"1") && CPLib.eqr(pRow.TPCINVIO1,"3")) {
          /* cAnno := Str(pAnno,4,0) */
          cAnno = CPLib.Str(pAnno,4,0);
          // * --- Select from aeannora
          m_cServer = m_Ctx.GetServer("aeannora");
          m_cPhName = m_Ctx.GetPhName("aeannora");
          if (Cursor_aeannora!=null)
            Cursor_aeannora.Close();
          Cursor_aeannora = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+"  and  ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cAnno,"?",0,0,m_cServer, m_oParameters),m_cServer,cAnno)+" "+")"+(m_Ctx.IsSharedTemp("aeannora")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aeannora.Eof())) {
            /* rowSaldi.CODINVIO3 := pRow.CODINVIO1 */
            rowSaldi.CODINVIO3 = pRow.CODINVIO1;
            /* rowSaldi.RAPINVIO3 := pRow.RAPINVIO1 */
            rowSaldi.RAPINVIO3 = pRow.RAPINVIO1;
            /* rowSaldi.TPRINVIO3 := pRow.TPRINVIO1 */
            rowSaldi.TPRINVIO3 = pRow.TPRINVIO1;
            /* rowSaldi.ANNINVIO3 := Val(aeannora->ANNO) */
            rowSaldi.ANNINVIO3 = CPLib.Val(Cursor_aeannora.GetString("ANNO"));
            /* rowSaldi.VALINVIO3 := pValuta */
            rowSaldi.VALINVIO3 = pValuta;
            /* If cAnno <= '2021' */
            if (CPLib.le(cAnno,"2021")) {
              /* rowSaldi.NATINVIO3 := Space(2) */
              rowSaldi.NATINVIO3 = CPLib.Space(2);
            } else { // Else
              /* rowSaldi.NATINVIO3 := aeannora->NATURA */
              rowSaldi.NATINVIO3 = Cursor_aeannora.GetString("NATURA");
            } // End If
            /* rowSaldi.IM1INVIO3 := aeannora->IMPORTO1 */
            rowSaldi.IM1INVIO3 = Cursor_aeannora.GetDouble("IMPORTO1");
            /* rowSaldi.FI1INVIO3 := iif(aeannora->IMPORTO1 >1000000,1,0) */
            rowSaldi.FI1INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO1"),1000000)?1:0);
            /* rowSaldi.IM2INVIO3 := aeannora->IMPORTO2 */
            rowSaldi.IM2INVIO3 = Cursor_aeannora.GetDouble("IMPORTO2");
            /* rowSaldi.FI2INVIO3 := iif(aeannora->IMPORTO2 >1000000,1,0) */
            rowSaldi.FI2INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO2"),1000000)?1:0);
            /* rowSaldi.IM3INVIO3 := aeannora->IMPORTO3 */
            rowSaldi.IM3INVIO3 = Cursor_aeannora.GetDouble("IMPORTO3");
            /* rowSaldi.FI3INVIO3 := iif(aeannora->IMPORTO3 >1000000,1,0) */
            rowSaldi.FI3INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO3"),1000000)?1:0);
            /* rowSaldi.IM4INVIO3 := aeannora->IMPORTO4 */
            rowSaldi.IM4INVIO3 = Cursor_aeannora.GetDouble("IMPORTO4");
            /* rowSaldi.FI4INVIO3 := iif(aeannora->IMPORTO4 >1000000,1,0) */
            rowSaldi.FI4INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO4"),1000000)?1:0);
            /* rowSaldi.IM5INVIO3 := aeannora->IMPORTO5 */
            rowSaldi.IM5INVIO3 = Cursor_aeannora.GetDouble("IMPORTO5");
            /* rowSaldi.FI5INVIO3 := iif(aeannora->IMPORTO5 >1000000,1,0) */
            rowSaldi.FI5INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO5"),1000000)?1:0);
            /* rowSaldi.IM6INVIO3 := aeannora->IMPORTO6 */
            rowSaldi.IM6INVIO3 = Cursor_aeannora.GetDouble("IMPORTO6");
            /* rowSaldi.FI6INVIO3 := iif(aeannora->IMPORTO6 >1000000,1,0) */
            rowSaldi.FI6INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO6"),1000000)?1:0);
            /* rowSaldi.UNIQUE3 := pRow.UNIQUE1 */
            rowSaldi.UNIQUE3 = pRow.UNIQUE1;
            /* rowSaldi.FLGUNQ3 := pRow.FLGUNQ1 */
            rowSaldi.FLGUNQ3 = pRow.FLGUNQ1;
            /* mcRitorno.AppendRow(rowSaldi) */
            mcRitorno.AppendRow(rowSaldi);
            Cursor_aeannora.Next();
          }
          m_cConnectivityError = Cursor_aeannora.ErrorMessage();
          Cursor_aeannora.Close();
          // * --- End Select
        } else { // Else
          /* cAnno := Str(pAnno,4,0) */
          cAnno = CPLib.Str(pAnno,4,0);
          // * --- Select from aeannora
          m_cServer = m_Ctx.GetServer("aeannora");
          m_cPhName = m_Ctx.GetPhName("aeannora");
          if (Cursor_aeannora!=null)
            Cursor_aeannora.Close();
          Cursor_aeannora = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+"  and  ANNO >="+CPSql.SQLValueAdapter(CPLib.ToSQL(_annomin,"?",0,0,m_cServer, m_oParameters),m_cServer,_annomin)+"  and  ANNO <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(cAnno,"?",0,0,m_cServer, m_oParameters),m_cServer,cAnno)+" "+")"+(m_Ctx.IsSharedTemp("aeannora")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"ANNO ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_aeannora.Eof())) {
            /* rowSaldi.CODINVIO3 := pRow.CODINVIO1 */
            rowSaldi.CODINVIO3 = pRow.CODINVIO1;
            /* rowSaldi.RAPINVIO3 := pRow.RAPINVIO1 */
            rowSaldi.RAPINVIO3 = pRow.RAPINVIO1;
            /* rowSaldi.TPRINVIO3 := pRow.TPRINVIO1 */
            rowSaldi.TPRINVIO3 = pRow.TPRINVIO1;
            /* rowSaldi.ANNINVIO3 := Val(aeannora->ANNO) */
            rowSaldi.ANNINVIO3 = CPLib.Val(Cursor_aeannora.GetString("ANNO"));
            /* rowSaldi.VALINVIO3 := pValuta */
            rowSaldi.VALINVIO3 = pValuta;
            /* If cAnno <= '2021' */
            if (CPLib.le(cAnno,"2021")) {
              /* rowSaldi.NATINVIO3 := Space(2) */
              rowSaldi.NATINVIO3 = CPLib.Space(2);
            } else { // Else
              /* rowSaldi.NATINVIO3 := aeannora->NATURA */
              rowSaldi.NATINVIO3 = Cursor_aeannora.GetString("NATURA");
            } // End If
            /* rowSaldi.IM1INVIO3 := aeannora->IMPORTO1 */
            rowSaldi.IM1INVIO3 = Cursor_aeannora.GetDouble("IMPORTO1");
            /* rowSaldi.FI1INVIO3 := iif(aeannora->IMPORTO1 >1000000,1,0) */
            rowSaldi.FI1INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO1"),1000000)?1:0);
            /* rowSaldi.IM2INVIO3 := aeannora->IMPORTO2 */
            rowSaldi.IM2INVIO3 = Cursor_aeannora.GetDouble("IMPORTO2");
            /* rowSaldi.FI2INVIO3 := iif(aeannora->IMPORTO2 >1000000,1,0) */
            rowSaldi.FI2INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO2"),1000000)?1:0);
            /* rowSaldi.IM3INVIO3 := aeannora->IMPORTO3 */
            rowSaldi.IM3INVIO3 = Cursor_aeannora.GetDouble("IMPORTO3");
            /* rowSaldi.FI3INVIO3 := iif(aeannora->IMPORTO3 >1000000,1,0) */
            rowSaldi.FI3INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO3"),1000000)?1:0);
            /* rowSaldi.IM4INVIO3 := aeannora->IMPORTO4 */
            rowSaldi.IM4INVIO3 = Cursor_aeannora.GetDouble("IMPORTO4");
            /* rowSaldi.FI4INVIO3 := iif(aeannora->IMPORTO4 >1000000,1,0) */
            rowSaldi.FI4INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO4"),1000000)?1:0);
            /* rowSaldi.IM5INVIO3 := aeannora->IMPORTO5 */
            rowSaldi.IM5INVIO3 = Cursor_aeannora.GetDouble("IMPORTO5");
            /* rowSaldi.FI5INVIO3 := iif(aeannora->IMPORTO5 >1000000,1,0) */
            rowSaldi.FI5INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO5"),1000000)?1:0);
            /* rowSaldi.IM6INVIO3 := aeannora->IMPORTO6 */
            rowSaldi.IM6INVIO3 = Cursor_aeannora.GetDouble("IMPORTO6");
            /* rowSaldi.FI6INVIO3 := iif(aeannora->IMPORTO6 >1000000,1,0) */
            rowSaldi.FI6INVIO3 = (CPLib.gt(Cursor_aeannora.GetDouble("IMPORTO6"),1000000)?1:0);
            /* rowSaldi.UNIQUE3 := pRow.UNIQUE1 */
            rowSaldi.UNIQUE3 = pRow.UNIQUE1;
            /* rowSaldi.FLGUNQ3 := pRow.FLGUNQ1 */
            rowSaldi.FLGUNQ3 = pRow.FLGUNQ1;
            /* mcRitorno.AppendRow(rowSaldi) */
            mcRitorno.AppendRow(rowSaldi);
            Cursor_aeannora.Next();
          }
          m_cConnectivityError = Cursor_aeannora.ErrorMessage();
          Cursor_aeannora.Close();
          // * --- End Select
        } // End If
      } else { // Else
        /* cAnno := Str(pAnno,4,0) */
        cAnno = CPLib.Str(pAnno,4,0);
        /* If pAnno > 0 */
        if (CPLib.gt(pAnno,0)) {
          /* If pRow.TIPINVIO1='1' and pRow.TPCINVIO1='3' */
          if (CPLib.eqr(pRow.TIPINVIO1,"1") && CPLib.eqr(pRow.TPCINVIO1,"3")) {
            // * --- Select from opextrbo
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            if (Cursor_opextrbo!=null)
              Cursor_opextrbo.Close();
            Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+"  and  ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(cAnno,"?",0,0,m_cServer, m_oParameters),m_cServer,cAnno)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_opextrbo.Eof())) {
              /* rowSaldi.CODINVIO3 := pRow.CODINVIO1 */
              rowSaldi.CODINVIO3 = pRow.CODINVIO1;
              /* rowSaldi.RAPINVIO3 := pRow.RAPINVIO1 */
              rowSaldi.RAPINVIO3 = pRow.RAPINVIO1;
              /* rowSaldi.TPRINVIO3 := pRow.TPRINVIO1 */
              rowSaldi.TPRINVIO3 = pRow.TPRINVIO1;
              /* rowSaldi.ANNINVIO3 := Val(opextrbo->ANNO) */
              rowSaldi.ANNINVIO3 = CPLib.Val(Cursor_opextrbo.GetString("ANNO"));
              /* rowSaldi.VALINVIO3 := pValuta */
              rowSaldi.VALINVIO3 = pValuta;
              /* If cAnno <= '2021' */
              if (CPLib.le(cAnno,"2021")) {
                /* rowSaldi.NATINVIO3 := Space(2) */
                rowSaldi.NATINVIO3 = CPLib.Space(2);
              } else { // Else
                /* rowSaldi.NATINVIO3 := opextrbo->NATURA */
                rowSaldi.NATINVIO3 = Cursor_opextrbo.GetString("NATURA");
              } // End If
              /* rowSaldi.IM1INVIO3 := 0 */
              rowSaldi.IM1INVIO3 = 0;
              /* rowSaldi.FI1INVIO3 := 0 */
              rowSaldi.FI1INVIO3 = 0;
              /* rowSaldi.IM2INVIO3 := 0 */
              rowSaldi.IM2INVIO3 = 0;
              /* rowSaldi.FI2INVIO3 := 0 */
              rowSaldi.FI2INVIO3 = 0;
              /* rowSaldi.IM3INVIO3 := opextrbo->SALDO */
              rowSaldi.IM3INVIO3 = Cursor_opextrbo.GetDouble("SALDO");
              /* rowSaldi.FI3INVIO3 := iif(opextrbo->SALDO >1000000,1,0) */
              rowSaldi.FI3INVIO3 = (CPLib.gt(Cursor_opextrbo.GetDouble("SALDO"),1000000)?1:0);
              /* rowSaldi.IM4INVIO3 := 0 */
              rowSaldi.IM4INVIO3 = 0;
              /* rowSaldi.FI4INVIO3 := 0 */
              rowSaldi.FI4INVIO3 = 0;
              /* rowSaldi.IM5INVIO3 := opextrbo->QUANTITA */
              rowSaldi.IM5INVIO3 = Cursor_opextrbo.GetDouble("QUANTITA");
              /* rowSaldi.FI5INVIO3 := iif(opextrbo->QUANTITA >1000000,1,0) */
              rowSaldi.FI5INVIO3 = (CPLib.gt(Cursor_opextrbo.GetDouble("QUANTITA"),1000000)?1:0);
              /* rowSaldi.IM6INVIO3 := 0 */
              rowSaldi.IM6INVIO3 = 0;
              /* rowSaldi.FI6INVIO3 := 0 */
              rowSaldi.FI6INVIO3 = 0;
              /* rowSaldi.UNIQUE3 := pRow.UNIQUE1 */
              rowSaldi.UNIQUE3 = pRow.UNIQUE1;
              /* rowSaldi.FLGUNQ3 := pRow.FLGUNQ1 */
              rowSaldi.FLGUNQ3 = pRow.FLGUNQ1;
              /* mcRitorno.AppendRow(rowSaldi) */
              mcRitorno.AppendRow(rowSaldi);
              Cursor_opextrbo.Next();
            }
            m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
            Cursor_opextrbo.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from opextrbo
            m_cServer = m_Ctx.GetServer("opextrbo");
            m_cPhName = m_Ctx.GetPhName("opextrbo");
            if (Cursor_opextrbo!=null)
              Cursor_opextrbo.Close();
            Cursor_opextrbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(pRow.RAPINVIO1,25),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Left(pRow.RAPINVIO1,25))+"  and  ANNO >="+CPSql.SQLValueAdapter(CPLib.ToSQL(_annomin,"?",0,0,m_cServer, m_oParameters),m_cServer,_annomin)+"  and  ANNO <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(cAnno,"?",0,0,m_cServer, m_oParameters),m_cServer,cAnno)+" "+")"+(m_Ctx.IsSharedTemp("opextrbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_opextrbo.Eof())) {
              /* rowSaldi.CODINVIO3 := pRow.CODINVIO1 */
              rowSaldi.CODINVIO3 = pRow.CODINVIO1;
              /* rowSaldi.RAPINVIO3 := pRow.RAPINVIO1 */
              rowSaldi.RAPINVIO3 = pRow.RAPINVIO1;
              /* rowSaldi.TPRINVIO3 := pRow.TPRINVIO1 */
              rowSaldi.TPRINVIO3 = pRow.TPRINVIO1;
              /* rowSaldi.ANNINVIO3 := Val(opextrbo->ANNO) */
              rowSaldi.ANNINVIO3 = CPLib.Val(Cursor_opextrbo.GetString("ANNO"));
              /* rowSaldi.VALINVIO3 := pValuta */
              rowSaldi.VALINVIO3 = pValuta;
              /* If cAnno <= '2021' */
              if (CPLib.le(cAnno,"2021")) {
                /* rowSaldi.NATINVIO3 := Space(2) */
                rowSaldi.NATINVIO3 = CPLib.Space(2);
              } else { // Else
                /* rowSaldi.NATINVIO3 := opextrbo->NATURA */
                rowSaldi.NATINVIO3 = Cursor_opextrbo.GetString("NATURA");
              } // End If
              /* rowSaldi.IM1INVIO3 := 0 */
              rowSaldi.IM1INVIO3 = 0;
              /* rowSaldi.FI1INVIO3 := 0 */
              rowSaldi.FI1INVIO3 = 0;
              /* rowSaldi.IM2INVIO3 := 0 */
              rowSaldi.IM2INVIO3 = 0;
              /* rowSaldi.FI2INVIO3 := 0 */
              rowSaldi.FI2INVIO3 = 0;
              /* rowSaldi.IM3INVIO3 := opextrbo->SALDO */
              rowSaldi.IM3INVIO3 = Cursor_opextrbo.GetDouble("SALDO");
              /* rowSaldi.FI3INVIO3 := iif(opextrbo->SALDO >1000000,1,0) */
              rowSaldi.FI3INVIO3 = (CPLib.gt(Cursor_opextrbo.GetDouble("SALDO"),1000000)?1:0);
              /* rowSaldi.IM4INVIO3 := 0 */
              rowSaldi.IM4INVIO3 = 0;
              /* rowSaldi.FI4INVIO3 := 0 */
              rowSaldi.FI4INVIO3 = 0;
              /* rowSaldi.IM5INVIO3 := opextrbo->QUANTITA */
              rowSaldi.IM5INVIO3 = Cursor_opextrbo.GetDouble("QUANTITA");
              /* rowSaldi.FI5INVIO3 := iif(opextrbo->QUANTITA >1000000,1,0) */
              rowSaldi.FI5INVIO3 = (CPLib.gt(Cursor_opextrbo.GetDouble("QUANTITA"),1000000)?1:0);
              /* rowSaldi.IM6INVIO3 := 0 */
              rowSaldi.IM6INVIO3 = 0;
              /* rowSaldi.FI6INVIO3 := 0 */
              rowSaldi.FI6INVIO3 = 0;
              /* rowSaldi.UNIQUE3 := pRow.UNIQUE1 */
              rowSaldi.UNIQUE3 = pRow.UNIQUE1;
              /* rowSaldi.FLGUNQ3 := pRow.FLGUNQ1 */
              rowSaldi.FLGUNQ3 = pRow.FLGUNQ1;
              /* mcRitorno.AppendRow(rowSaldi) */
              mcRitorno.AppendRow(rowSaldi);
              Cursor_opextrbo.Next();
            }
            m_cConnectivityError = Cursor_opextrbo.ErrorMessage();
            Cursor_opextrbo.Close();
            // * --- End Select
          } // End If
        } // End If
      } // End If
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* Return mcRitorno */
      throw new Stop(mcRitorno);
    } finally {
      try {
        if (Cursor_aeannora!=null)
          Cursor_aeannora.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(MemoryCursorRow_sid_invio1 p_pRow,double p_pAnno,String p_pTipo,String p_pValuta) {
    pRow = p_pRow;
    pAnno = p_pAnno;
    pTipo = p_pTipo;
    pValuta = p_pValuta;
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
  public MemoryCursor_sid_invio3 Run(MemoryCursorRow_sid_invio1 p_pRow,double p_pAnno,String p_pTipo,String p_pValuta) {
    pRow = p_pRow;
    pAnno = p_pAnno;
    pTipo = p_pTipo;
    pValuta = p_pValuta;
    return Run();
  }
  public MemoryCursor_sid_invio3 Run() {
    MemoryCursor_sid_invio3 l_result;
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
        l_result = (MemoryCursor_sid_invio3)stop_value.GetObject();
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
  public static arfn_fam_mesefile03R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_fam_mesefile03R(p_Ctx, p_Caller);
  }
  public static arfn_fam_mesefile03R Make(CPContext p_Ctx) {
    return new arfn_fam_mesefile03R(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRow = new MemoryCursorRow_sid_invio1();
    pAnno = 0;
    pTipo = CPLib.Space(1);
    pValuta = CPLib.Space(1);
    mcRitorno = new MemoryCursor_sid_invio3();
    rowSaldi = new MemoryCursorRow_sid_invio3();
    _conta = 0;
    cAnno = CPLib.Space(4);
    _annomin = CPLib.Space(4);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fam_mesefile03,
  public static final String i_InvokedRoutines = ",arfn_fam_mesefile03,";
  public static String[] m_cRunParameterNames={"pRow","pAnno","pTipo","pValuta"};
}
