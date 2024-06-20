// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_modopen2R implements CallerWithObjs {
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
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aestor;
  public String m_cServer_aestor;
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
  public java.sql.Date w_datarett;
  public String w_newcoint;
  public String w_newtipoag;
  public String w_oldcoint;
  public String w_oldfile;
  public String w_oldidbase;
  public String w_oldprog;
  public String w_oldrappo;
  public double w_oldrnumrig;
  public String w_oldtipoag;
  public String w_ragione;
  public String gAzienda;
  public String _coint;
  public String _tipage;
  public String _rifana;
  public String cProg;
  public String cIDBase;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_modopen2R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_modopen2",m_Caller);
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aestor = p_ContextObject.GetPhName("aestor");
    if (m_cPhName_aestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aestor = m_cPhName_aestor+" "+m_Ctx.GetWritePhName("aestor");
    }
    m_cServer_aestor = p_ContextObject.GetServer("aestor");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("oldrnumrig",p_cVarName)) {
      return w_oldrnumrig;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_modopen2";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("newcoint",p_cVarName)) {
      return w_newcoint;
    }
    if (CPLib.eqr("newtipoag",p_cVarName)) {
      return w_newtipoag;
    }
    if (CPLib.eqr("oldcoint",p_cVarName)) {
      return w_oldcoint;
    }
    if (CPLib.eqr("oldfile",p_cVarName)) {
      return w_oldfile;
    }
    if (CPLib.eqr("oldidbase",p_cVarName)) {
      return w_oldidbase;
    }
    if (CPLib.eqr("oldprog",p_cVarName)) {
      return w_oldprog;
    }
    if (CPLib.eqr("oldrappo",p_cVarName)) {
      return w_oldrappo;
    }
    if (CPLib.eqr("oldtipoag",p_cVarName)) {
      return w_oldtipoag;
    }
    if (CPLib.eqr("ragione",p_cVarName)) {
      return w_ragione;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      return _coint;
    }
    if (CPLib.eqr("_tipage",p_cVarName)) {
      return _tipage;
    }
    if (CPLib.eqr("_rifana",p_cVarName)) {
      return _rifana;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cIDBase",p_cVarName)) {
      return cIDBase;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("datarett",p_cVarName)) {
      return w_datarett;
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
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("oldrnumrig",p_cVarName)) {
      w_oldrnumrig = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("newcoint",p_cVarName)) {
      w_newcoint = value;
      return;
    }
    if (CPLib.eqr("newtipoag",p_cVarName)) {
      w_newtipoag = value;
      return;
    }
    if (CPLib.eqr("oldcoint",p_cVarName)) {
      w_oldcoint = value;
      return;
    }
    if (CPLib.eqr("oldfile",p_cVarName)) {
      w_oldfile = value;
      return;
    }
    if (CPLib.eqr("oldidbase",p_cVarName)) {
      w_oldidbase = value;
      return;
    }
    if (CPLib.eqr("oldprog",p_cVarName)) {
      w_oldprog = value;
      return;
    }
    if (CPLib.eqr("oldrappo",p_cVarName)) {
      w_oldrappo = value;
      return;
    }
    if (CPLib.eqr("oldtipoag",p_cVarName)) {
      w_oldtipoag = value;
      return;
    }
    if (CPLib.eqr("ragione",p_cVarName)) {
      w_ragione = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      _coint = value;
      return;
    }
    if (CPLib.eqr("_tipage",p_cVarName)) {
      _tipage = value;
      return;
    }
    if (CPLib.eqr("_rifana",p_cVarName)) {
      _rifana = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("cIDBase",p_cVarName)) {
      cIDBase = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("datarett",p_cVarName)) {
      w_datarett = value;
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
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_aerighe=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_datarett Date */
      /* w_newcoint Char(1) */
      /* w_newtipoag Char(2) */
      /* w_oldcoint Char(1) */
      /* w_oldfile Char(15) */
      /* w_oldidbase Char(10) */
      /* w_oldprog Char(15) */
      /* w_oldrappo Char(25) */
      /* w_oldrnumrig Numeric(10, 0) */
      /* w_oldtipoag Char(2) */
      /* w_ragione Char(1) */
      /* Definizione variabili locali */
      /* gAzienda Char(10) // Azienda */
      /* Verifica se deve modificare qualcosa */
      /* _coint Char(1) */
      /* _tipage Char(2) */
      /* _rifana Char(1) */
      /* cProg Char(10) */
      /* cIDBase Char(10) */
      /* Se ci sono state modifiche legge */
      /* If (not(Empty(w_newcoint)) and w_newcoint <> w_oldcoint) or (not(Empty(w_newtipoag)) and w_newtipoag <> w_oldtipoag) */
      if (( ! (CPLib.Empty(w_newcoint)) && CPLib.ne(w_newcoint,w_oldcoint)) || ( ! (CPLib.Empty(w_newtipoag)) && CPLib.ne(w_newtipoag,w_oldtipoag))) {
        /* If not(Empty(w_oldprog)) */
        if ( ! (CPLib.Empty(w_oldprog))) {
          // * --- Select from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          if (Cursor_aerighe!=null)
            Cursor_aerighe.Close();
          Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldrappo,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldrappo)+"  and  IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldidbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldidbase)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aerighe.Eof())) {
            /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            /* cIDBase := LibreriaMit.UniqueId() */
            cIDBase = LibreriaMit.UniqueId();
            // * --- Insert into aestor from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aestor");
            m_cPhName = m_Ctx.GetPhName("aestor");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aestor",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_modopen2",18,"0000001B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000001B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cIDBase,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("ASPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("APROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CSPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipage,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("ADTPRE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetDate("CDTPRE"),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aestor",true);
            m_cSql = m_cSql+")";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
            if (CPLib.lt(m_nUpdatedRows,0)) {
              m_Sql.AbortTransaction();
            }
            m_Sql.CompleteTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            /* If w_ragione='N' */
            if (CPLib.eqr(w_ragione,"N")) {
              // * --- Write into aerighe from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_modopen2",18,"0000001D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"AOLDPROG = "+CPLib.ToSQL(Cursor_aerighe.GetString("APROG"),"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"AOLDFILE = "+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(w_datarett,"D",8,0)+", ";
              m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetDouble("CPROWNUM"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } else { // Else
              // * --- Write into aerighe from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_modopen2",18,"0000001E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
              m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
              m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"))+"";
              m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetDouble("CPROWNUM"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
              }
            } // End If
            /* If aerighe->APROG=aerighe->CPROG */
            if (CPLib.eqr(Cursor_aerighe.GetString("APROG"),Cursor_aerighe.GetString("CPROG"))) {
              /* If w_ragione='N' */
              if (CPLib.eqr(w_ragione,"N")) {
                // * --- Write into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_modopen2",18,"00000021")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"COLDPROG = "+CPLib.ToSQL(Cursor_aerighe.GetString("CPROG"),"C",25,0,m_cServer)+", ";
                m_cSql = m_cSql+"COLDFILE = "+CPLib.ToSQL(Cursor_aerighe.GetString("CFILE"),"C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"CDATARET = "+CPLib.ToSQL(w_datarett,"D",8,0)+", ";
                m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetDouble("CPROWNUM"))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } else { // Else
                // * --- Write into aerighe from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aerighe");
                m_cPhName = m_Ctx.GetPhName("aerighe");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_modopen2",18,"00000022")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"CDATARET = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
                m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"))+"";
                m_cSql = m_cSql+" and CPROWNUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetDouble("CPROWNUM"),"?",0,0,m_cServer),m_cServer,Cursor_aerighe.GetDouble("CPROWNUM"))+"";
                m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
              } // End If
            } // End If
            Cursor_aerighe.Next();
          }
          m_cConnectivityError = Cursor_aerighe.ErrorMessage();
          Cursor_aerighe.Close();
          // * --- End Select
          // * --- Write into aetesta from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_modopen2",18,"00000023")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(w_newtipoag,"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"COINT = "+CPLib.ToSQL(w_newcoint,"C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldrappo,"?",0,0,m_cServer),m_cServer,w_oldrappo)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync() {
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
      m_Caller.SetDate("datarett","D",8,0,w_datarett);
      m_Caller.SetString("newcoint","C",1,0,w_newcoint);
      m_Caller.SetString("newtipoag","C",2,0,w_newtipoag);
      m_Caller.SetString("oldcoint","C",1,0,w_oldcoint);
      m_Caller.SetString("oldfile","C",15,0,w_oldfile);
      m_Caller.SetString("oldidbase","C",10,0,w_oldidbase);
      m_Caller.SetString("oldprog","C",15,0,w_oldprog);
      m_Caller.SetString("oldrappo","C",25,0,w_oldrappo);
      m_Caller.SetNumber("oldrnumrig","N",10,0,w_oldrnumrig);
      m_Caller.SetString("oldtipoag","C",2,0,w_oldtipoag);
      m_Caller.SetString("ragione","C",1,0,w_ragione);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_modopen2R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_modopen2R(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_datarett = m_Caller.GetDate("datarett","D",8,0);
    w_newcoint = m_Caller.GetString("newcoint","C",1,0);
    w_newtipoag = m_Caller.GetString("newtipoag","C",2,0);
    w_oldcoint = m_Caller.GetString("oldcoint","C",1,0);
    w_oldfile = m_Caller.GetString("oldfile","C",15,0);
    w_oldidbase = m_Caller.GetString("oldidbase","C",10,0);
    w_oldprog = m_Caller.GetString("oldprog","C",15,0);
    w_oldrappo = m_Caller.GetString("oldrappo","C",25,0);
    w_oldrnumrig = m_Caller.GetNumber("oldrnumrig","N",10,0);
    w_oldtipoag = m_Caller.GetString("oldtipoag","C",2,0);
    w_ragione = m_Caller.GetString("ragione","C",1,0);
    _coint = CPLib.Space(1);
    _tipage = CPLib.Space(2);
    _rifana = CPLib.Space(1);
    cProg = CPLib.Space(10);
    cIDBase = CPLib.Space(10);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000001B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"RIFRIGA,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"CDTPRE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aestor",true);
    return p_cSql;
  }
}
