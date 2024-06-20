// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_delopen1R implements CallerWithObjs {
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
  public String m_cPhName_tmp_pers82;
  public String m_cServer_tmp_pers82;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aedestor;
  public String m_cServer_aedestor;
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
  public String w_ragione;
  public java.sql.Date w_datarett;
  public java.sql.Date w_newdate;
  public java.sql.Date w_newdatec;
  public String w_newintest;
  public java.sql.Date w_olddata;
  public java.sql.Date w_olddatac;
  public String w_oldfile;
  public String w_oldidbase;
  public String w_oldintest;
  public String w_oldprog;
  public String w_oldrappo;
  public double w_oldnumrig;
  public String w_tipochg;
  public String w_xcap;
  public double w_xcfestero;
  public String w_xcodfisc;
  public String w_xcognome;
  public java.sql.Date w_xdatnasc;
  public String w_xdesccit;
  public String w_xdessta;
  public String w_xnascomun;
  public String w_xnasstato;
  public String w_xnome;
  public String w_xpaese;
  public String w_xprovincia;
  public String w_xragnew;
  public String w_xragold;
  public String w_xsesso;
  public String w_xtipinter;
  public String w_xtipopers;
  public String _coint;
  public String _tipage;
  public String _rifana;
  public String _salva;
  public String _aprog;
  public String _cprog;
  public double _all;
  public String cProg;
  public String cIDBase;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_delopen1R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_delopen1",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_pers82")) {
      m_cPhName_tmp_pers82 = p_ContextObject.GetPhName("tmp_pers82");
      if (m_cPhName_tmp_pers82.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_pers82 = m_cPhName_tmp_pers82+" "+m_Ctx.GetWritePhName("tmp_pers82");
      }
      m_cServer_tmp_pers82 = p_ContextObject.GetServer("tmp_pers82");
    }
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aedestor = p_ContextObject.GetPhName("aedestor");
    if (m_cPhName_aedestor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedestor = m_cPhName_aedestor+" "+m_Ctx.GetWritePhName("aedestor");
    }
    m_cServer_aedestor = p_ContextObject.GetServer("aedestor");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("oldnumrig",p_cVarName)) {
      return w_oldnumrig;
    }
    if (CPLib.eqr("xcfestero",p_cVarName)) {
      return w_xcfestero;
    }
    if (CPLib.eqr("_all",p_cVarName)) {
      return _all;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_delopen1";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("ragione",p_cVarName)) {
      return w_ragione;
    }
    if (CPLib.eqr("newintest",p_cVarName)) {
      return w_newintest;
    }
    if (CPLib.eqr("oldfile",p_cVarName)) {
      return w_oldfile;
    }
    if (CPLib.eqr("oldidbase",p_cVarName)) {
      return w_oldidbase;
    }
    if (CPLib.eqr("oldintest",p_cVarName)) {
      return w_oldintest;
    }
    if (CPLib.eqr("oldprog",p_cVarName)) {
      return w_oldprog;
    }
    if (CPLib.eqr("oldrappo",p_cVarName)) {
      return w_oldrappo;
    }
    if (CPLib.eqr("tipochg",p_cVarName)) {
      return w_tipochg;
    }
    if (CPLib.eqr("xcap",p_cVarName)) {
      return w_xcap;
    }
    if (CPLib.eqr("xcodfisc",p_cVarName)) {
      return w_xcodfisc;
    }
    if (CPLib.eqr("xcognome",p_cVarName)) {
      return w_xcognome;
    }
    if (CPLib.eqr("xdesccit",p_cVarName)) {
      return w_xdesccit;
    }
    if (CPLib.eqr("xdessta",p_cVarName)) {
      return w_xdessta;
    }
    if (CPLib.eqr("xnascomun",p_cVarName)) {
      return w_xnascomun;
    }
    if (CPLib.eqr("xnasstato",p_cVarName)) {
      return w_xnasstato;
    }
    if (CPLib.eqr("xnome",p_cVarName)) {
      return w_xnome;
    }
    if (CPLib.eqr("xpaese",p_cVarName)) {
      return w_xpaese;
    }
    if (CPLib.eqr("xprovincia",p_cVarName)) {
      return w_xprovincia;
    }
    if (CPLib.eqr("xragnew",p_cVarName)) {
      return w_xragnew;
    }
    if (CPLib.eqr("xragold",p_cVarName)) {
      return w_xragold;
    }
    if (CPLib.eqr("xsesso",p_cVarName)) {
      return w_xsesso;
    }
    if (CPLib.eqr("xtipinter",p_cVarName)) {
      return w_xtipinter;
    }
    if (CPLib.eqr("xtipopers",p_cVarName)) {
      return w_xtipopers;
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
    if (CPLib.eqr("_salva",p_cVarName)) {
      return _salva;
    }
    if (CPLib.eqr("_aprog",p_cVarName)) {
      return _aprog;
    }
    if (CPLib.eqr("_cprog",p_cVarName)) {
      return _cprog;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cIDBase",p_cVarName)) {
      return cIDBase;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("datarett",p_cVarName)) {
      return w_datarett;
    }
    if (CPLib.eqr("newdate",p_cVarName)) {
      return w_newdate;
    }
    if (CPLib.eqr("newdatec",p_cVarName)) {
      return w_newdatec;
    }
    if (CPLib.eqr("olddata",p_cVarName)) {
      return w_olddata;
    }
    if (CPLib.eqr("olddatac",p_cVarName)) {
      return w_olddatac;
    }
    if (CPLib.eqr("xdatnasc",p_cVarName)) {
      return w_xdatnasc;
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
    if (CPLib.eqr("oldnumrig",p_cVarName)) {
      w_oldnumrig = value;
      return;
    }
    if (CPLib.eqr("xcfestero",p_cVarName)) {
      w_xcfestero = value;
      return;
    }
    if (CPLib.eqr("_all",p_cVarName)) {
      _all = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("ragione",p_cVarName)) {
      w_ragione = value;
      return;
    }
    if (CPLib.eqr("newintest",p_cVarName)) {
      w_newintest = value;
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
    if (CPLib.eqr("oldintest",p_cVarName)) {
      w_oldintest = value;
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
    if (CPLib.eqr("tipochg",p_cVarName)) {
      w_tipochg = value;
      return;
    }
    if (CPLib.eqr("xcap",p_cVarName)) {
      w_xcap = value;
      return;
    }
    if (CPLib.eqr("xcodfisc",p_cVarName)) {
      w_xcodfisc = value;
      return;
    }
    if (CPLib.eqr("xcognome",p_cVarName)) {
      w_xcognome = value;
      return;
    }
    if (CPLib.eqr("xdesccit",p_cVarName)) {
      w_xdesccit = value;
      return;
    }
    if (CPLib.eqr("xdessta",p_cVarName)) {
      w_xdessta = value;
      return;
    }
    if (CPLib.eqr("xnascomun",p_cVarName)) {
      w_xnascomun = value;
      return;
    }
    if (CPLib.eqr("xnasstato",p_cVarName)) {
      w_xnasstato = value;
      return;
    }
    if (CPLib.eqr("xnome",p_cVarName)) {
      w_xnome = value;
      return;
    }
    if (CPLib.eqr("xpaese",p_cVarName)) {
      w_xpaese = value;
      return;
    }
    if (CPLib.eqr("xprovincia",p_cVarName)) {
      w_xprovincia = value;
      return;
    }
    if (CPLib.eqr("xragnew",p_cVarName)) {
      w_xragnew = value;
      return;
    }
    if (CPLib.eqr("xragold",p_cVarName)) {
      w_xragold = value;
      return;
    }
    if (CPLib.eqr("xsesso",p_cVarName)) {
      w_xsesso = value;
      return;
    }
    if (CPLib.eqr("xtipinter",p_cVarName)) {
      w_xtipinter = value;
      return;
    }
    if (CPLib.eqr("xtipopers",p_cVarName)) {
      w_xtipopers = value;
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
    if (CPLib.eqr("_salva",p_cVarName)) {
      _salva = value;
      return;
    }
    if (CPLib.eqr("_aprog",p_cVarName)) {
      _aprog = value;
      return;
    }
    if (CPLib.eqr("_cprog",p_cVarName)) {
      _cprog = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("datarett",p_cVarName)) {
      w_datarett = value;
      return;
    }
    if (CPLib.eqr("newdate",p_cVarName)) {
      w_newdate = value;
      return;
    }
    if (CPLib.eqr("newdatec",p_cVarName)) {
      w_newdatec = value;
      return;
    }
    if (CPLib.eqr("olddata",p_cVarName)) {
      w_olddata = value;
      return;
    }
    if (CPLib.eqr("olddatac",p_cVarName)) {
      w_olddatac = value;
      return;
    }
    if (CPLib.eqr("xdatnasc",p_cVarName)) {
      w_xdatnasc = value;
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
    CPResultSet Cursor_aederig=null;
    CPResultSet Cursor_personbo=null;
    try {
      /* w_ragione Char(1) */
      /* w_datarett Date */
      /* w_newdate Date */
      /* w_newdatec Date */
      /* w_newintest Char(16) */
      /* w_olddata Date */
      /* w_olddatac Date */
      /* w_oldfile Char(15) */
      /* w_oldidbase Char(10) */
      /* w_oldintest Char(16) */
      /* w_oldprog Char(15) */
      /* w_oldrappo Char(25) */
      /* w_oldnumrig Numeric(10, 0) */
      /* w_tipochg Char(1) */
      /* w_xcap Char(9) // CAP Comune Sede Legale  */
      /* w_xcfestero Numeric(1, 0) // Codice Fiscale Estero */
      /* w_xcodfisc Char(16) // Codice Fiscale */
      /* w_xcognome Char(26) // Cognome */
      /* w_xdatnasc Date // Data Nascita */
      /* w_xdesccit Char(40) // Città */
      /* w_xdessta Char(40) // Descrizione */
      /* w_xnascomun Char(40) // Luogo di Nascita */
      /* w_xnasstato Char(40) // Stato di nascita */
      /* w_xnome Char(25) // Nome */
      /* w_xpaese Char(3) // Stato */
      /* w_xprovincia Char(2) // Provincia */
      /* w_xragnew Char(70) // Ragione Sociale */
      /* w_xragold Char(70) // Ragione Sociale */
      /* w_xsesso Char(1) // Sesso */
      /* w_xtipinter Char(2) // Provincia */
      /* w_xtipopers Char(1) */
      /* Definizione variabili locali */
      /* _coint Char(1) */
      /* _tipage Char(2) */
      /* _rifana Char(1) */
      /* _salva Char(16) */
      /* _aprog Char(25) */
      /* _cprog Char(25) */
      /* _all Numeric(1, 0) */
      /* cProg Char(10) */
      /* cIDBase Char(10) */
      /* gAzienda Char(10) // Azienda */
      /* Salva i dati della riga e della scheda anagrafica */
      // * --- Drop temporary table tmp_pers82
      if (m_Ctx.IsSharedTemp("tmp_pers82")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_pers82")) {
          m_cServer = m_Ctx.GetServer("tmp_pers82");
          m_cPhName = m_Ctx.GetPhName("tmp_pers82");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_pers82");
      }
      // * --- Create temporary table tmp_pers82
      if (m_Ctx.IsSharedTemp("tmp_pers82")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_pers82")) {
          m_cServer = m_Ctx.GetServer("tmp_pers82");
          m_cPhName = m_Ctx.GetPhName("tmp_pers82");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_pers82");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_pers82");
      if ( ! (m_Ctx.IsSharedTemp("tmp_pers82"))) {
        m_cServer = m_Ctx.GetServer("tmp_pers82");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_pers82",m_cServer,"proto")),m_cPhName,"tmp_pers82",m_Ctx);
      }
      m_cPhName_tmp_pers82 = m_cPhName;
      /* _all := 0 */
      _all = CPLib.Round(0,0);
      // * --- Select from aederig
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      if (Cursor_aederig!=null)
        Cursor_aederig.Close();
      Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldrappo,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldrappo)+"  and  IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldidbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldidbase)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aederig.Eof())) {
        // * --- Insert into tmp_pers82 from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_pers82");
        m_cPhName = m_Ctx.GetPhName("tmp_pers82");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_pers82",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"00000032")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000032(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("COINT"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_pers82",true);
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
        /* _coint := aederig->COINT */
        _coint = Cursor_aederig.GetString("COINT");
        /* _tipage := aederig->TIPOAG */
        _tipage = Cursor_aederig.GetString("TIPOAG");
        // * --- Write into tmp_pers82 from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_pers82");
        m_cPhName = m_Ctx.GetPhName("tmp_pers82");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_pers82",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"00000035")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"DATARET = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
        m_cSql = m_cSql+"DATARIF = "+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"D",8,0)+", ";
        m_cSql = m_cSql+"DATACHIU = "+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"D",8,0)+", ";
        m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"C",16,0,m_cServer)+", ";
        m_cSql = m_cSql+"APROG = "+CPLib.ToSQL(Cursor_aederig.GetString("APROG"),"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"MODIFICA = "+CPLib.ToSQL(1,"N",1,0)+", ";
        m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
        m_cSql = m_cSql+"INTEST = "+CPLib.ToSQL(w_xragold,"C",70,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_pers82",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
        /* _salva := aederig->CONNESINT */
        _salva = Cursor_aederig.GetString("CONNESINT");
        /* _aprog := aederig->APROG */
        _aprog = Cursor_aederig.GetString("APROG");
        /* _cprog := aederig->CPROG */
        _cprog = Cursor_aederig.GetString("CPROG");
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldintest,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldintest)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          // * --- Write into tmp_pers82 from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_pers82");
          m_cPhName = m_Ctx.GetPhName("tmp_pers82");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_pers82",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"0000003A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"D",8,0)+", ";
          m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"C",26,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"N",1,0)+", ";
          m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_pers82",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
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
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        Cursor_aederig.Next();
      }
      m_cConnectivityError = Cursor_aederig.ErrorMessage();
      Cursor_aederig.Close();
      // * --- End Select
      /* Se ci sono state modifiche legge */
      /* If w_tipochg='M' */
      if (CPLib.eqr(w_tipochg,"M")) {
        // * --- Write into personbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"0000003D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(w_xcodfisc,"C",16,0,m_cServer)+", ";
        m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(w_xdatnasc,"D",8,0)+", ";
        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(w_xnascomun,"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(w_xtipinter,"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(w_xsesso,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(w_xnasstato,"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(w_xnome,"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(w_xcognome,"C",26,0,m_cServer)+", ";
        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(w_xragold,"C",70,0,m_cServer)+", ";
        m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(w_xdesccit,"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(w_xprovincia,"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(w_xpaese,"C",3,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldintest,"?",0,0,m_cServer),m_cServer,w_oldintest)+"";
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
      /* Non è cambiato intestatario */
      /* If w_newintest=w_oldintest */
      if (CPLib.eqr(w_newintest,w_oldintest)) {
        // * --- Write into personbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"00000040")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(w_xragold,"C",70,0,m_cServer)+", ";
        m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(w_xcodfisc,"C",16,0,m_cServer)+", ";
        m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(w_xdatnasc,"D",8,0)+", ";
        m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(w_xnascomun,"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(w_xdesccit,"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(w_xprovincia,"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(w_xpaese,"C",3,0,m_cServer)+", ";
        m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(w_xcap,"C",9,0,m_cServer)+", ";
        m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(w_xtipinter,"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(w_xsesso,"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(w_xnasstato,"C",30,0,m_cServer)+", ";
        m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(w_xnome,"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(w_xcognome,"C",26,0,m_cServer)+", ";
        m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(w_xcfestero,"N",1,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldintest,"?",0,0,m_cServer),m_cServer,w_oldintest)+"";
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
      /* Aggiorna le righe */
      // * --- Select from aederig
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      if (Cursor_aederig!=null)
        Cursor_aederig.Close();
      Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldrappo,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldrappo)+"  and  IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_oldidbase,"?",0,0,m_cServer, m_oParameters),m_cServer,w_oldidbase)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aederig.Eof())) {
        /* If not(Empty(aederig->APROG)) */
        if ( ! (CPLib.Empty(Cursor_aederig.GetString("APROG")))) {
          /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* cIDBase := LibreriaMit.UniqueId() */
          cIDBase = LibreriaMit.UniqueId();
          // * --- Insert into aedestor from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aedestor");
          m_cPhName = m_Ctx.GetPhName("aedestor");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aedestor",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"00000046")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000046(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cIDBase,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDouble("ASPEDITO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("APROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADATARET"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDouble("CSPEDITO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDATARET"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipage,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("ADTPRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetDate("CDTPRE"),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aedestor",true);
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
        } // End If
        /* If w_tipochg='M' */
        if (CPLib.eqr(w_tipochg,"M")) {
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"00000048")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(w_newdate,"D",8,0)+", ";
          m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(w_newdatec,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"))+"";
          m_cSql = m_cSql+" and IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"00000049")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ADATA = "+CPLib.ToSQL(w_newdate,"D",8,0)+", ";
          m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(w_newdatec,"D",8,0)+", ";
          m_cSql = m_cSql+"CONNESINT = "+CPLib.ToSQL(w_newintest,"C",16,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"))+"";
          m_cSql = m_cSql+" and IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
        /* If w_ragione='N' */
        if (CPLib.eqr(w_ragione,"N")) {
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"0000004B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(w_datarett,"D",8,0)+", ";
          m_cSql = m_cSql+"RSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"))+"";
          m_cSql = m_cSql+" and IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_delopen1",37,"0000004C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ADATARET = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("RAPPORTO"))+"";
          m_cSql = m_cSql+" and IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"))+"";
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
        Cursor_aederig.Next();
      }
      m_cConnectivityError = Cursor_aederig.ErrorMessage();
      Cursor_aederig.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
      m_Caller.SetString("ragione","C",1,0,w_ragione);
      m_Caller.SetDate("datarett","D",8,0,w_datarett);
      m_Caller.SetDate("newdate","D",8,0,w_newdate);
      m_Caller.SetDate("newdatec","D",8,0,w_newdatec);
      m_Caller.SetString("newintest","C",16,0,w_newintest);
      m_Caller.SetDate("olddata","D",8,0,w_olddata);
      m_Caller.SetDate("olddatac","D",8,0,w_olddatac);
      m_Caller.SetString("oldfile","C",15,0,w_oldfile);
      m_Caller.SetString("oldidbase","C",10,0,w_oldidbase);
      m_Caller.SetString("oldintest","C",16,0,w_oldintest);
      m_Caller.SetString("oldprog","C",15,0,w_oldprog);
      m_Caller.SetString("oldrappo","C",25,0,w_oldrappo);
      m_Caller.SetNumber("oldnumrig","N",10,0,w_oldnumrig);
      m_Caller.SetString("tipochg","C",1,0,w_tipochg);
      m_Caller.SetString("xcap","C",9,0,w_xcap);
      m_Caller.SetNumber("xcfestero","N",1,0,w_xcfestero);
      m_Caller.SetString("xcodfisc","C",16,0,w_xcodfisc);
      m_Caller.SetString("xcognome","C",26,0,w_xcognome);
      m_Caller.SetDate("xdatnasc","D",8,0,w_xdatnasc);
      m_Caller.SetString("xdesccit","C",40,0,w_xdesccit);
      m_Caller.SetString("xdessta","C",40,0,w_xdessta);
      m_Caller.SetString("xnascomun","C",40,0,w_xnascomun);
      m_Caller.SetString("xnasstato","C",40,0,w_xnasstato);
      m_Caller.SetString("xnome","C",25,0,w_xnome);
      m_Caller.SetString("xpaese","C",3,0,w_xpaese);
      m_Caller.SetString("xprovincia","C",2,0,w_xprovincia);
      m_Caller.SetString("xragnew","C",70,0,w_xragnew);
      m_Caller.SetString("xragold","C",70,0,w_xragold);
      m_Caller.SetString("xsesso","C",1,0,w_xsesso);
      m_Caller.SetString("xtipinter","C",2,0,w_xtipinter);
      m_Caller.SetString("xtipopers","C",1,0,w_xtipopers);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_delopen1R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_delopen1R(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_ragione = m_Caller.GetString("ragione","C",1,0);
    w_datarett = m_Caller.GetDate("datarett","D",8,0);
    w_newdate = m_Caller.GetDate("newdate","D",8,0);
    w_newdatec = m_Caller.GetDate("newdatec","D",8,0);
    w_newintest = m_Caller.GetString("newintest","C",16,0);
    w_olddata = m_Caller.GetDate("olddata","D",8,0);
    w_olddatac = m_Caller.GetDate("olddatac","D",8,0);
    w_oldfile = m_Caller.GetString("oldfile","C",15,0);
    w_oldidbase = m_Caller.GetString("oldidbase","C",10,0);
    w_oldintest = m_Caller.GetString("oldintest","C",16,0);
    w_oldprog = m_Caller.GetString("oldprog","C",15,0);
    w_oldrappo = m_Caller.GetString("oldrappo","C",25,0);
    w_oldnumrig = m_Caller.GetNumber("oldnumrig","N",10,0);
    w_tipochg = m_Caller.GetString("tipochg","C",1,0);
    w_xcap = m_Caller.GetString("xcap","C",9,0);
    w_xcfestero = m_Caller.GetNumber("xcfestero","N",1,0);
    w_xcodfisc = m_Caller.GetString("xcodfisc","C",16,0);
    w_xcognome = m_Caller.GetString("xcognome","C",26,0);
    w_xdatnasc = m_Caller.GetDate("xdatnasc","D",8,0);
    w_xdesccit = m_Caller.GetString("xdesccit","C",40,0);
    w_xdessta = m_Caller.GetString("xdessta","C",40,0);
    w_xnascomun = m_Caller.GetString("xnascomun","C",40,0);
    w_xnasstato = m_Caller.GetString("xnasstato","C",40,0);
    w_xnome = m_Caller.GetString("xnome","C",25,0);
    w_xpaese = m_Caller.GetString("xpaese","C",3,0);
    w_xprovincia = m_Caller.GetString("xprovincia","C",2,0);
    w_xragnew = m_Caller.GetString("xragnew","C",70,0);
    w_xragold = m_Caller.GetString("xragold","C",70,0);
    w_xsesso = m_Caller.GetString("xsesso","C",1,0);
    w_xtipinter = m_Caller.GetString("xtipinter","C",2,0);
    w_xtipopers = m_Caller.GetString("xtipopers","C",1,0);
    _coint = CPLib.Space(1);
    _tipage = CPLib.Space(2);
    _rifana = CPLib.Space(1);
    _salva = CPLib.Space(16);
    _aprog = CPLib.Space(25);
    _cprog = CPLib.Space(25);
    _all = 0;
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
  protected static String GetFieldsName_00000032(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_pers82",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000046(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"ADTPRE,";
    p_cSql = p_cSql+"CDTPRE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aedestor",true);
    return p_cSql;
  }
}
