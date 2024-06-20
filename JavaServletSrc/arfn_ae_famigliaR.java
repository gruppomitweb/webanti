// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_ae_famigliaR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_delegabo;
  public String m_cServer_delegabo;
  public String m_cPhName_intestit;
  public String m_cServer_intestit;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_jelegabo;
  public String m_cServer_jelegabo;
  public String m_cPhName_garantbo;
  public String m_cServer_garantbo;
  public String m_cPhName_jarantbo;
  public String m_cServer_jarantbo;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestit;
  public String m_cServer_jntestit;
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
  public String pRapporto;
  public String pTipo;
  public double _noage;
  public String _ragsoc;
  public String _piva;
  public String _tipopers;
  public MemoryCursor_mcfamiglia_mcrdef mcFamiglia;
  public double _notit;
  public String _despaese;
  public double _tipoint;
  public double _presente;
  public java.sql.Date gDataTito;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_ae_famigliaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_ae_famiglia",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_delegabo = p_ContextObject.GetPhName("delegabo");
    if (m_cPhName_delegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_delegabo = m_cPhName_delegabo+" "+m_Ctx.GetWritePhName("delegabo");
    }
    m_cServer_delegabo = p_ContextObject.GetServer("delegabo");
    m_cPhName_intestit = p_ContextObject.GetPhName("intestit");
    if (m_cPhName_intestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestit = m_cPhName_intestit+" "+m_Ctx.GetWritePhName("intestit");
    }
    m_cServer_intestit = p_ContextObject.GetServer("intestit");
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
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    if (m_cPhName_jnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jnarapbo = m_cPhName_jnarapbo+" "+m_Ctx.GetWritePhName("jnarapbo");
    }
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestit = p_ContextObject.GetPhName("jntestit");
    if (m_cPhName_jntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_jntestit = m_cPhName_jntestit+" "+m_Ctx.GetWritePhName("jntestit");
    }
    m_cServer_jntestit = p_ContextObject.GetServer("jntestit");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_noage",p_cVarName)) {
      return _noage;
    }
    if (CPLib.eqr("_notit",p_cVarName)) {
      return _notit;
    }
    if (CPLib.eqr("_tipoint",p_cVarName)) {
      return _tipoint;
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
      return "arfn_ae_famiglia";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pRapporto",p_cVarName)) {
      return pRapporto;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_piva",p_cVarName)) {
      return _piva;
    }
    if (CPLib.eqr("_tipopers",p_cVarName)) {
      return _tipopers;
    }
    if (CPLib.eqr("_despaese",p_cVarName)) {
      return _despaese;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
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
    if (CPLib.eqr("mcFamiglia",p_cVarName)) {
      return mcFamiglia;
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
    if (CPLib.eqr("_noage",p_cVarName)) {
      _noage = value;
      return;
    }
    if (CPLib.eqr("_notit",p_cVarName)) {
      _notit = value;
      return;
    }
    if (CPLib.eqr("_tipoint",p_cVarName)) {
      _tipoint = value;
      return;
    }
    if (CPLib.eqr("_presente",p_cVarName)) {
      _presente = value;
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
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("_piva",p_cVarName)) {
      _piva = value;
      return;
    }
    if (CPLib.eqr("_tipopers",p_cVarName)) {
      _tipopers = value;
      return;
    }
    if (CPLib.eqr("_despaese",p_cVarName)) {
      _despaese = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
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
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_intestit=null;
    CPResultSet Cursor_jntestit=null;
    CPResultSet Cursor_delegabo=null;
    CPResultSet Cursor_garantbo=null;
    CPResultSet Cursor_jntestbo=null;
    CPResultSet Cursor_jelegabo=null;
    CPResultSet Cursor_jarantbo=null;
    try {
      /* pRapporto Char(25) */
      /* pTipo Char(1) */
      /* _noage Numeric(1, 0) */
      /* _ragsoc Char(70) */
      /* _piva Char(14) */
      /* _tipopers Char(1) */
      /* mcFamiglia MemoryCursor(mcFamiglia.MCRDef) */
      /* _notit Numeric(1, 0) */
      /* _despaese Char(40) */
      /* _tipoint Numeric(1, 0) */
      /* _presente Numeric(1, 0) */
      /* gDataTito Date // Data per Titolari Effettivi */
      /* _noage := 0 */
      _noage = CPLib.Round(0,0);
      // * --- Read from anarapbo
      m_cServer = m_Ctx.GetServer("anarapbo");
      m_cPhName = m_Ctx.GetPhName("anarapbo");
      m_cSql = "";
      m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"C",25,0,m_cServer),m_cServer,pRapporto);
      if (m_Ctx.IsSharedTemp("anarapbo")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NOPROT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _noage = CPLib.Round(Read_Cursor.GetDouble("NOPROT"),0);
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on anarapbo into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _noage = 0;
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If _noage = 0 */
      if (CPLib.eqr(_noage,0)) {
        // * --- Select from intestbo
        m_cServer = m_Ctx.GetServer("intestbo");
        m_cPhName = m_Ctx.GetPhName("intestbo");
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
        Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+"  and  ([NOTEMPTYSTR(STATOREG)]=0  or  STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intestbo.Eof())) {
          /* _ragsoc := '' */
          _ragsoc = "";
          /* _piva := '' */
          _piva = "";
          /* _tipopers := '' */
          _tipopers = "";
          /* _notit := 0 */
          _notit = CPLib.Round(0,0);
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* _notit := personbo->NOTIT */
            _notit = CPLib.Round(Cursor_personbo.GetDouble("NOTIT"),0);
            /* mcFamiglia.AppendBlank() */
            mcFamiglia.AppendBlank();
            /* If not(Empty(personbo->CODFISC)) and not(Empty(personbo->PARTIVA)) and not(Empty(personbo->SESSO)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("CODFISC"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("PARTIVA"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("SESSO")))) {
              /* mcFamiglia.TIPOSOG := '4-Ditta Individuale' */
              mcFamiglia.row.TIPOSOG = "4-Ditta Individuale";
              /* _tipoint := 4 */
              _tipoint = CPLib.Round(4,0);
            } else { // Else
              /* mcFamiglia.TIPOSOG := '0-Titolare e contitolare' */
              mcFamiglia.row.TIPOSOG = "0-Titolare e contitolare";
              /* _tipoint := 0 */
              _tipoint = CPLib.Round(0,0);
            } // End If
            /* mcFamiglia.CODINTER := intestbo->CODINTER */
            mcFamiglia.row.CODINTER = Cursor_intestbo.GetString("CODINTER");
            /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
            mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
            /* mcFamiglia.DATAINI := intestbo->DATAINI */
            mcFamiglia.row.DATAINI = Cursor_intestbo.GetDate("DATAINI");
            /* mcFamiglia.DATAFINE := intestbo->DATAFINE */
            mcFamiglia.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
            /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
            mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
            /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
            mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
            /* mcFamiglia.NOME := Upper(personbo->NOME) */
            mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
            /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
            mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
            /* mcFamiglia.DATNAS := personbo->DATANASC */
            mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
            /* mcFamiglia.SESSO := personbo->SESSO */
            mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
            /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
            mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
            /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
            mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
            /* _despaese := '' */
            _despaese = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _despaese = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _despaese = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* mcFamiglia.PAESE := Upper(_despaese) */
            mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
            /* If Empty(Upper(personbo->PROVINCIA)) */
            if (CPLib.Empty(CPLib.Upper(Cursor_personbo.GetString("PROVINCIA")))) {
              /* mcFamiglia.SEDELEG := iif(personbo->PAESE='086' or Empty(personbo->PAESE),Upper(personbo->DESCCIT),_despaese) */
              mcFamiglia.row.SEDELEG = (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.Empty(Cursor_personbo.GetString("PAESE"))?CPLib.Upper(Cursor_personbo.GetString("DESCCIT")):_despaese);
              /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
              mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
            } else { // Else
              /* mcFamiglia.SEDELEG := iif(Upper(personbo->PROVINCIA)='EE',_despaese,Upper(personbo->DESCCIT)) */
              mcFamiglia.row.SEDELEG = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("PROVINCIA")),"EE")?_despaese:CPLib.Upper(Cursor_personbo.GetString("DESCCIT")));
              /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
              mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
            } // End If
            /* mcFamiglia.CFESTERO := personbo->CFESTERO */
            mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
            /* mcFamiglia.ORIGINE := 'U' */
            mcFamiglia.row.ORIGINE = "U";
            /* mcFamiglia.SaveRow() */
            mcFamiglia.SaveRow();
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          /* If (intestbo->DATAINI >= gDataTito or Empty(gDataTito)) and _notit=0 and _tipoint <> 4 */
          if ((CPLib.ge(Cursor_intestbo.GetDate("DATAINI"),gDataTito) || CPLib.Empty(gDataTito)) && CPLib.eqr(_notit,0) && CPLib.ne(_tipoint,4)) {
            // * --- Select from intestit
            m_cServer = m_Ctx.GetServer("intestit");
            m_cPhName = m_Ctx.GetPhName("intestit");
            if (Cursor_intestit!=null)
              Cursor_intestit.Close();
            Cursor_intestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+"  and  ([NOTEMPTYSTR(STATOREG)]=0  or  STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("intestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_intestit.Eof())) {
              /* not(Empty(intestbo->DATAFINE)) not(Empty(intestit->DATAFINE))
                 not(intestbo->DATAFINE < intestit->DATAINI or intestit->DATAFINE < intestbo->DATAINI) */
              /* If not((not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < intestit->DATAINI) or (not(Empty(intestit->DATAFINE)) and intestit->DATAFINE < intestbo->DATAINI)) */
              if ( ! (( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_intestit.GetDate("DATAINI"))) || ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestit.GetDate("DATAFINE"),Cursor_intestbo.GetDate("DATAINI"))))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* mcFamiglia.AppendBlank() */
                  mcFamiglia.AppendBlank();
                  /* mcFamiglia.TIPOSOG := '7-Titolare Effettivo' */
                  mcFamiglia.row.TIPOSOG = "7-Titolare Effettivo";
                  /* mcFamiglia.CODINTER := intestit->CODINTER */
                  mcFamiglia.row.CODINTER = Cursor_intestit.GetString("CODINTER");
                  /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
                  mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
                  /* If pTipo='V' */
                  if (CPLib.eqr(pTipo,"V")) {
                    /* mcFamiglia.DATAINI := intestit->DATAINI */
                    mcFamiglia.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
                    /* mcFamiglia.DATAFINE := intestit->DATAFINE */
                    mcFamiglia.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
                  } else { // Else
                    /* mcFamiglia.DATAINI := iif(intestit->DATAINI < intestbo->DATAINI,intestbo->DATAINI,intestit->DATAINI) */
                    mcFamiglia.row.DATAINI = (CPLib.lt(Cursor_intestit.GetDate("DATAINI"),Cursor_intestbo.GetDate("DATAINI"))?Cursor_intestbo.GetDate("DATAINI"):Cursor_intestit.GetDate("DATAINI"));
                    /* If (Empty(intestit->DATAFINE) and not(Empty(intestbo->DATAFINE))) or (not(Empty(intestit->DATAFINE)) and not(Empty(intestbo->DATAFINE)) and intestit->DATAFINE > intestbo->DATAFINE) */
                    if ((CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")) &&  ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) || ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) &&  ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_intestit.GetDate("DATAFINE"),Cursor_intestbo.GetDate("DATAFINE")))) {
                      /* mcFamiglia.DATAFINE := intestbo->DATAFINE */
                      mcFamiglia.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
                    } else { // Else
                      /* mcFamiglia.DATAFINE := intestit->DATAFINE */
                      mcFamiglia.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
                    } // End If
                  } // End If
                  /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
                  mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
                  /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
                  mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
                  /* mcFamiglia.NOME := Upper(personbo->NOME) */
                  mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
                  /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
                  mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
                  /* mcFamiglia.DATNAS := personbo->DATANASC */
                  mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
                  /* mcFamiglia.SESSO := personbo->SESSO */
                  mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _despaese = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _despaese = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* mcFamiglia.PAESE := Upper(_despaese) */
                  mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
                  /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
                  mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
                  /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
                  mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
                  /* mcFamiglia.CFESTERO := personbo->CFESTERO */
                  mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                  /* mcFamiglia.ORIGINE := 'U' */
                  mcFamiglia.row.ORIGINE = "U";
                  /* mcFamiglia.SaveRow() */
                  mcFamiglia.SaveRow();
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_intestit.Next();
            }
            m_cConnectivityError = Cursor_intestit.ErrorMessage();
            Cursor_intestit.Close();
            // * --- End Select
            // * --- Select from jntestit
            m_cServer = m_Ctx.GetServer("jntestit");
            m_cPhName = m_Ctx.GetPhName("jntestit");
            if (Cursor_jntestit!=null)
              Cursor_jntestit.Close();
            Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_jntestit.Eof())) {
              /* not(Empty(intestbo->DATAFINE)) not(Empty(intestit->DATAFINE))
                 not(intestbo->DATAFINE < intestit->DATAINI or intestit->DATAFINE < intestbo->DATAINI) */
              /* If not((not(Empty(intestbo->DATAFINE)) and intestbo->DATAFINE < jntestit->DATAINI) or (not(Empty(jntestit->DATAFINE)) and jntestit->DATAFINE < intestbo->DATAINI)) */
              if ( ! (( ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestbo.GetDate("DATAFINE"),Cursor_jntestit.GetDate("DATAINI"))) || ( ! (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE"))) && CPLib.lt(Cursor_jntestit.GetDate("DATAFINE"),Cursor_intestbo.GetDate("DATAINI"))))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_jntestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* mcFamiglia.AppendBlank() */
                  mcFamiglia.AppendBlank();
                  /* mcFamiglia.TIPOSOG := '7-Titolare Effettivo' */
                  mcFamiglia.row.TIPOSOG = "7-Titolare Effettivo";
                  /* mcFamiglia.CODINTER := jntestit->CODINTER */
                  mcFamiglia.row.CODINTER = Cursor_jntestit.GetString("CODINTER");
                  /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
                  mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
                  /* If pTipo='V' */
                  if (CPLib.eqr(pTipo,"V")) {
                    /* mcFamiglia.DATAINI := jntestit->DATAINI */
                    mcFamiglia.row.DATAINI = Cursor_jntestit.GetDate("DATAINI");
                    /* mcFamiglia.DATAFINE := jntestit->DATAFINE */
                    mcFamiglia.row.DATAFINE = Cursor_jntestit.GetDate("DATAFINE");
                  } else { // Else
                    /* mcFamiglia.DATAINI := iif(jntestit->DATAINI < intestbo->DATAINI,intestbo->DATAINI,jntestit->DATAINI) */
                    mcFamiglia.row.DATAINI = (CPLib.lt(Cursor_jntestit.GetDate("DATAINI"),Cursor_intestbo.GetDate("DATAINI"))?Cursor_intestbo.GetDate("DATAINI"):Cursor_jntestit.GetDate("DATAINI"));
                    /* If (Empty(jntestit->DATAFINE) and not(Empty(intestbo->DATAFINE))) or (not(Empty(jntestit->DATAFINE)) and not(Empty(intestbo->DATAFINE)) and jntestit->DATAFINE > intestbo->DATAFINE) */
                    if ((CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE")) &&  ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")))) || ( ! (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE"))) &&  ! (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_jntestit.GetDate("DATAFINE"),Cursor_intestbo.GetDate("DATAFINE")))) {
                      /* mcFamiglia.DATAFINE := intestbo->DATAFINE */
                      mcFamiglia.row.DATAFINE = Cursor_intestbo.GetDate("DATAFINE");
                    } else { // Else
                      /* mcFamiglia.DATAFINE := jntestit->DATAFINE */
                      mcFamiglia.row.DATAFINE = Cursor_jntestit.GetDate("DATAFINE");
                    } // End If
                  } // End If
                  /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
                  mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
                  /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
                  mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
                  /* mcFamiglia.NOME := Upper(personbo->NOME) */
                  mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
                  /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
                  mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
                  /* mcFamiglia.DATNAS := personbo->DATANASC */
                  mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
                  /* mcFamiglia.SESSO := personbo->SESSO */
                  mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _despaese = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _despaese = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* mcFamiglia.PAESE := Upper(_despaese) */
                  mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
                  /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
                  mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
                  /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
                  mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
                  /* mcFamiglia.CFESTERO := personbo->CFESTERO */
                  mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                  /* mcFamiglia.ORIGINE := 'U' */
                  mcFamiglia.row.ORIGINE = "U";
                  /* mcFamiglia.SaveRow() */
                  mcFamiglia.SaveRow();
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_jntestit.Next();
            }
            m_cConnectivityError = Cursor_jntestit.ErrorMessage();
            Cursor_jntestit.Close();
            // * --- End Select
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
        Cursor_delegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+"  and  NOAGE<>'S'  and  ([NOTEMPTYSTR(STATOREG)]=0  or  STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("delegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_delegabo.Eof())) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_delegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* mcFamiglia.AppendBlank() */
            mcFamiglia.AppendBlank();
            /* mcFamiglia.TIPOSOG := '5-Delegato' */
            mcFamiglia.row.TIPOSOG = "5-Delegato";
            /* mcFamiglia.CODINTER := delegabo->CODINTER */
            mcFamiglia.row.CODINTER = Cursor_delegabo.GetString("CODINTER");
            /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
            mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
            /* mcFamiglia.DATAINI := delegabo->DATAINI */
            mcFamiglia.row.DATAINI = Cursor_delegabo.GetDate("DATAINI");
            /* mcFamiglia.DATAFINE := delegabo->DATAFINE */
            mcFamiglia.row.DATAFINE = Cursor_delegabo.GetDate("DATAFINE");
            /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
            mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
            /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
            mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
            /* mcFamiglia.NOME := Upper(personbo->NOME) */
            mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
            /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
            mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
            /* mcFamiglia.DATNAS := personbo->DATANASC */
            mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
            /* mcFamiglia.SESSO := personbo->SESSO */
            mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _despaese = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _despaese = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* mcFamiglia.PAESE := Upper(_despaese) */
            mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
            /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
            mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
            /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
            mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
            /* mcFamiglia.CFESTERO := personbo->CFESTERO */
            mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
            /* mcFamiglia.ORIGINE := 'U' */
            mcFamiglia.row.ORIGINE = "U";
            /* mcFamiglia.SaveRow() */
            mcFamiglia.SaveRow();
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
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
        Cursor_garantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("garantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_garantbo.Eof())) {
          // * --- Select from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          if (Cursor_personbo!=null)
            Cursor_personbo.Close();
          Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_garantbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_personbo.Eof())) {
            /* mcFamiglia.AppendBlank() */
            mcFamiglia.AppendBlank();
            /* mcFamiglia.TIPOSOG := '8-Garantito' */
            mcFamiglia.row.TIPOSOG = "8-Garantito";
            /* mcFamiglia.CODINTER := garantbo->CODINTER */
            mcFamiglia.row.CODINTER = Cursor_garantbo.GetString("CODINTER");
            /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
            mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
            /* mcFamiglia.DATAINI := garantbo->DATAINI */
            mcFamiglia.row.DATAINI = Cursor_garantbo.GetDate("DATAINI");
            /* mcFamiglia.DATAFINE := garantbo->DATAFINE */
            mcFamiglia.row.DATAFINE = Cursor_garantbo.GetDate("DATAFINE");
            /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
            mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
            /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
            mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
            /* mcFamiglia.NOME := Upper(personbo->NOME) */
            mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
            /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
            mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
            /* mcFamiglia.DATNAS := personbo->DATANASC */
            mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
            /* mcFamiglia.SESSO := personbo->SESSO */
            mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
            /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
            mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
            /* _despaese := '' */
            _despaese = "";
            // * --- Read from tbstati
            m_cServer = m_Ctx.GetServer("tbstati");
            m_cPhName = m_Ctx.GetPhName("tbstati");
            m_cSql = "";
            m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
            if (m_Ctx.IsSharedTemp("tbstati")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _despaese = Read_Cursor.GetString("DESCRI");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _despaese = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* mcFamiglia.PAESE := Upper(_despaese) */
            mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
            /* If Empty(Upper(personbo->PROVINCIA)) */
            if (CPLib.Empty(CPLib.Upper(Cursor_personbo.GetString("PROVINCIA")))) {
              /* mcFamiglia.SEDELEG := iif(personbo->PAESE='086' or Empty(personbo->PAESE),Upper(personbo->DESCCIT),_despaese) */
              mcFamiglia.row.SEDELEG = (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.Empty(Cursor_personbo.GetString("PAESE"))?CPLib.Upper(Cursor_personbo.GetString("DESCCIT")):_despaese);
              /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
              mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
            } else { // Else
              /* mcFamiglia.SEDELEG := iif(Upper(personbo->PROVINCIA)='EE',_despaese,Upper(personbo->DESCCIT)) */
              mcFamiglia.row.SEDELEG = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("PROVINCIA")),"EE")?_despaese:CPLib.Upper(Cursor_personbo.GetString("DESCCIT")));
              /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
              mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
            } // End If
            /* mcFamiglia.CFESTERO := personbo->CFESTERO */
            mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
            /* mcFamiglia.ORIGINE := 'U' */
            mcFamiglia.row.ORIGINE = "U";
            /* mcFamiglia.SaveRow() */
            mcFamiglia.SaveRow();
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
          Cursor_personbo.Close();
          // * --- End Select
          Cursor_garantbo.Next();
        }
        m_cConnectivityError = Cursor_garantbo.ErrorMessage();
        Cursor_garantbo.Close();
        // * --- End Select
      } // End If
      // * --- Select from jntestbo
      m_cServer = m_Ctx.GetServer("jntestbo");
      m_cPhName = m_Ctx.GetPhName("jntestbo");
      if (Cursor_jntestbo!=null)
        Cursor_jntestbo.Close();
      Cursor_jntestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("jntestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jntestbo.Eof())) {
        /* _ragsoc := '' */
        _ragsoc = "";
        /* _piva := '' */
        _piva = "";
        /* _tipopers := '' */
        _tipopers = "";
        /* _notit := 0 */
        _notit = CPLib.Round(0,0);
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* _notit := personbo->NOTIT */
          _notit = CPLib.Round(Cursor_personbo.GetDouble("NOTIT"),0);
          /* mcFamiglia.AppendBlank() */
          mcFamiglia.AppendBlank();
          /* If personbo->TIPOPERS= 'I' or (personbo->TIPOPERS='P' and not(Empty(personbo->PARTIVA))) */
          if (CPLib.eqr(Cursor_personbo.GetString("TIPOPERS"),"I") || (CPLib.eqr(Cursor_personbo.GetString("TIPOPERS"),"P") &&  ! (CPLib.Empty(Cursor_personbo.GetString("PARTIVA"))))) {
            /* mcFamiglia.TIPOSOG := '4-Ditta Individuale' */
            mcFamiglia.row.TIPOSOG = "4-Ditta Individuale";
          } else { // Else
            /* mcFamiglia.TIPOSOG := '0-Titolare e contitolare' */
            mcFamiglia.row.TIPOSOG = "0-Titolare e contitolare";
          } // End If
          /* mcFamiglia.CODINTER := jntestbo->CODINTER */
          mcFamiglia.row.CODINTER = Cursor_jntestbo.GetString("CODINTER");
          /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
          mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
          /* mcFamiglia.DATAINI := jntestbo->DATAINI */
          mcFamiglia.row.DATAINI = Cursor_jntestbo.GetDate("DATAINI");
          /* mcFamiglia.DATAFINE := jntestbo->DATAFINE */
          mcFamiglia.row.DATAFINE = Cursor_jntestbo.GetDate("DATAFINE");
          /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
          mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
          /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
          mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
          /* mcFamiglia.NOME := Upper(personbo->NOME) */
          mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
          /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
          mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
          /* mcFamiglia.DATNAS := personbo->DATANASC */
          mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
          /* mcFamiglia.SESSO := personbo->SESSO */
          mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
          /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
          mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
          /* _despaese := '' */
          _despaese = "";
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _despaese = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _despaese = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* mcFamiglia.PAESE := Upper(_despaese) */
          mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
          /* If Empty(Upper(personbo->PROVINCIA)) */
          if (CPLib.Empty(CPLib.Upper(Cursor_personbo.GetString("PROVINCIA")))) {
            /* mcFamiglia.SEDELEG := iif(personbo->PAESE='086' or Empty(personbo->PAESE),Upper(personbo->DESCCIT),_despaese) */
            mcFamiglia.row.SEDELEG = (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.Empty(Cursor_personbo.GetString("PAESE"))?CPLib.Upper(Cursor_personbo.GetString("DESCCIT")):_despaese);
            /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
            mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
          } else { // Else
            /* mcFamiglia.SEDELEG := iif(Upper(personbo->PROVINCIA)='EE',_despaese,Upper(personbo->DESCCIT)) */
            mcFamiglia.row.SEDELEG = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("PROVINCIA")),"EE")?_despaese:CPLib.Upper(Cursor_personbo.GetString("DESCCIT")));
            /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
            mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
          } // End If
          /* mcFamiglia.CFESTERO := personbo->CFESTERO */
          mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
          /* mcFamiglia.ORIGINE := 'A' */
          mcFamiglia.row.ORIGINE = "A";
          /* mcFamiglia.SaveRow() */
          mcFamiglia.SaveRow();
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* If (jntestbo->DATAINI >= gDataTito or Empty(gDataTito)) and _notit=0 */
        if ((CPLib.ge(Cursor_jntestbo.GetDate("DATAINI"),gDataTito) || CPLib.Empty(gDataTito)) && CPLib.eqr(_notit,0)) {
          // * --- Select from jntestit
          m_cServer = m_Ctx.GetServer("jntestit");
          m_cPhName = m_Ctx.GetPhName("jntestit");
          if (Cursor_jntestit!=null)
            Cursor_jntestit.Close();
          Cursor_jntestit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODCLI="+CPLib.ToSQL(Cursor_jntestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("jntestit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_jntestit.Eof())) {
            /* not(jntestbo->DATAFINE < jntestit->DATAINI or jntestit->DATAFINE < jntestbo->DATAINI) */
            /* If not((not(Empty(jntestbo->DATAFINE)) and jntestbo->DATAFINE < jntestit->DATAINI) or (not(Empty(jntestit->DATAFINE)) and jntestit->DATAFINE < jntestbo->DATAINI)) */
            if ( ! (( ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_jntestbo.GetDate("DATAFINE"),Cursor_jntestit.GetDate("DATAINI"))) || ( ! (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE"))) && CPLib.lt(Cursor_jntestit.GetDate("DATAFINE"),Cursor_jntestbo.GetDate("DATAINI"))))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_jntestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* mcFamiglia.AppendBlank() */
                mcFamiglia.AppendBlank();
                /* mcFamiglia.TIPOSOG := '7-Titolare Effettivo' */
                mcFamiglia.row.TIPOSOG = "7-Titolare Effettivo";
                /* mcFamiglia.CODINTER := jntestit->CODINTER */
                mcFamiglia.row.CODINTER = Cursor_jntestit.GetString("CODINTER");
                /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
                mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
                /* If pTipo='V' */
                if (CPLib.eqr(pTipo,"V")) {
                  /* mcFamiglia.DATAINI := jntestit->DATAINI */
                  mcFamiglia.row.DATAINI = Cursor_jntestit.GetDate("DATAINI");
                  /* mcFamiglia.DATAFINE := jntestit->DATAFINE */
                  mcFamiglia.row.DATAFINE = Cursor_jntestit.GetDate("DATAFINE");
                } else { // Else
                  /* mcFamiglia.DATAINI := iif(jntestit->DATAINI < jntestbo->DATAINI,jntestbo->DATAINI,jntestit->DATAINI) */
                  mcFamiglia.row.DATAINI = (CPLib.lt(Cursor_jntestit.GetDate("DATAINI"),Cursor_jntestbo.GetDate("DATAINI"))?Cursor_jntestbo.GetDate("DATAINI"):Cursor_jntestit.GetDate("DATAINI"));
                  /* If (Empty(jntestit->DATAFINE) and not(Empty(jntestbo->DATAFINE))) or (not(Empty(jntestit->DATAFINE)) and not(Empty(jntestbo->DATAFINE)) and jntestit->DATAFINE > jntestbo->DATAFINE) */
                  if ((CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE")) &&  ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE")))) || ( ! (CPLib.Empty(Cursor_jntestit.GetDate("DATAFINE"))) &&  ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_jntestit.GetDate("DATAFINE"),Cursor_jntestbo.GetDate("DATAFINE")))) {
                    /* mcFamiglia.DATAFINE := jntestbo->DATAFINE */
                    mcFamiglia.row.DATAFINE = Cursor_jntestbo.GetDate("DATAFINE");
                  } else { // Else
                    /* mcFamiglia.DATAFINE := jntestit->DATAFINE */
                    mcFamiglia.row.DATAFINE = Cursor_jntestit.GetDate("DATAFINE");
                  } // End If
                } // End If
                /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
                mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
                /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
                mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
                /* mcFamiglia.NOME := Upper(personbo->NOME) */
                mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
                /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
                mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
                /* mcFamiglia.DATNAS := personbo->DATANASC */
                mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
                /* mcFamiglia.SESSO := personbo->SESSO */
                mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _despaese = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _despaese = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* mcFamiglia.PAESE := Upper(_despaese) */
                mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
                /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
                mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
                /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
                mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
                /* mcFamiglia.CFESTERO := personbo->CFESTERO */
                mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                /* mcFamiglia.ORIGINE := 'A' */
                mcFamiglia.row.ORIGINE = "A";
                /* mcFamiglia.SaveRow() */
                mcFamiglia.SaveRow();
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
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
              /* If At(rwFamiglia.TIPOSOG,'7')<>0 and rwFamiglia.CODINTER=intestit->CODINTER */
              if (CPLib.ne(CPLib.At(rwFamiglia.TIPOSOG,"7"),0) && CPLib.eqr(rwFamiglia.CODINTER,Cursor_intestit.GetString("CODINTER"))) {
                /* _presente := 1 */
                _presente = CPLib.Round(1,0);
              } // End If
            }
            /* If _presente=0 */
            if (CPLib.eqr(_presente,0)) {
              /* If not((not(Empty(jntestbo->DATAFINE)) and jntestbo->DATAFINE < intestit->DATAINI) or (not(Empty(intestit->DATAFINE)) and intestit->DATAFINE < jntestbo->DATAINI)) */
              if ( ! (( ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) && CPLib.lt(Cursor_jntestbo.GetDate("DATAFINE"),Cursor_intestit.GetDate("DATAINI"))) || ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) && CPLib.lt(Cursor_intestit.GetDate("DATAFINE"),Cursor_jntestbo.GetDate("DATAINI"))))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestit.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* mcFamiglia.AppendBlank() */
                  mcFamiglia.AppendBlank();
                  /* mcFamiglia.TIPOSOG := '7-Titolare Effettivo' */
                  mcFamiglia.row.TIPOSOG = "7-Titolare Effettivo";
                  /* mcFamiglia.CODINTER := intestit->CODINTER */
                  mcFamiglia.row.CODINTER = Cursor_intestit.GetString("CODINTER");
                  /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
                  mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
                  /* If pTipo='V' */
                  if (CPLib.eqr(pTipo,"V")) {
                    /* mcFamiglia.DATAINI := intestit->DATAINI */
                    mcFamiglia.row.DATAINI = Cursor_intestit.GetDate("DATAINI");
                    /* mcFamiglia.DATAFINE := intestit->DATAFINE */
                    mcFamiglia.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
                  } else { // Else
                    /* mcFamiglia.DATAINI := iif(intestit->DATAINI < jntestbo->DATAINI,jntestbo->DATAINI,intestit->DATAINI) */
                    mcFamiglia.row.DATAINI = (CPLib.lt(Cursor_intestit.GetDate("DATAINI"),Cursor_jntestbo.GetDate("DATAINI"))?Cursor_jntestbo.GetDate("DATAINI"):Cursor_intestit.GetDate("DATAINI"));
                    /* If (Empty(intestit->DATAFINE) and not(Empty(jntestbo->DATAFINE))) or (not(Empty(intestit->DATAFINE)) and not(Empty(jntestbo->DATAFINE)) and intestit->DATAFINE > jntestbo->DATAFINE) */
                    if ((CPLib.Empty(Cursor_intestit.GetDate("DATAFINE")) &&  ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE")))) || ( ! (CPLib.Empty(Cursor_intestit.GetDate("DATAFINE"))) &&  ! (CPLib.Empty(Cursor_jntestbo.GetDate("DATAFINE"))) && CPLib.gt(Cursor_intestit.GetDate("DATAFINE"),Cursor_jntestbo.GetDate("DATAFINE")))) {
                      /* mcFamiglia.DATAFINE := jntestbo->DATAFINE */
                      mcFamiglia.row.DATAFINE = Cursor_jntestbo.GetDate("DATAFINE");
                    } else { // Else
                      /* mcFamiglia.DATAFINE := intestit->DATAFINE */
                      mcFamiglia.row.DATAFINE = Cursor_intestit.GetDate("DATAFINE");
                    } // End If
                  } // End If
                  /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
                  mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
                  /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
                  mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
                  /* mcFamiglia.NOME := Upper(personbo->NOME) */
                  mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
                  /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
                  mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
                  /* mcFamiglia.DATNAS := personbo->DATANASC */
                  mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
                  /* mcFamiglia.SESSO := personbo->SESSO */
                  mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
                  // * --- Read from tbstati
                  m_cServer = m_Ctx.GetServer("tbstati");
                  m_cPhName = m_Ctx.GetPhName("tbstati");
                  m_cSql = "";
                  m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
                  if (m_Ctx.IsSharedTemp("tbstati")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    _despaese = Read_Cursor.GetString("DESCRI");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    _despaese = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* mcFamiglia.PAESE := Upper(_despaese) */
                  mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
                  /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
                  mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
                  /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
                  mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
                  /* mcFamiglia.CFESTERO := personbo->CFESTERO */
                  mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                  /* mcFamiglia.ORIGINE := 'A' */
                  mcFamiglia.row.ORIGINE = "A";
                  /* mcFamiglia.SaveRow() */
                  mcFamiglia.SaveRow();
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
            } // End If
            Cursor_intestit.Next();
          }
          m_cConnectivityError = Cursor_intestit.ErrorMessage();
          Cursor_intestit.Close();
          // * --- End Select
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
      Cursor_jelegabo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("jelegabo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jelegabo.Eof())) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_jelegabo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* mcFamiglia.AppendBlank() */
          mcFamiglia.AppendBlank();
          /* mcFamiglia.TIPOSOG := '5-Delegato' */
          mcFamiglia.row.TIPOSOG = "5-Delegato";
          /* mcFamiglia.CODINTER := jelegabo->CODINTER */
          mcFamiglia.row.CODINTER = Cursor_jelegabo.GetString("CODINTER");
          /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
          mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
          /* mcFamiglia.DATAINI := jelegabo->DATAINI */
          mcFamiglia.row.DATAINI = Cursor_jelegabo.GetDate("DATAINI");
          /* mcFamiglia.DATAFINE := jelegabo->DATAFINE */
          mcFamiglia.row.DATAFINE = Cursor_jelegabo.GetDate("DATAFINE");
          /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
          mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
          /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
          mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
          /* mcFamiglia.NOME := Upper(personbo->NOME) */
          mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
          /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
          mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
          /* mcFamiglia.DATNAS := personbo->DATANASC */
          mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
          /* mcFamiglia.SESSO := personbo->SESSO */
          mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _despaese = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _despaese = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* mcFamiglia.PAESE := Upper(_despaese) */
          mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
          /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
          mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
          /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
          mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
          /* mcFamiglia.CFESTERO := personbo->CFESTERO */
          mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
          /* mcFamiglia.ORIGINE := 'A' */
          mcFamiglia.row.ORIGINE = "A";
          /* mcFamiglia.SaveRow() */
          mcFamiglia.SaveRow();
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
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
      Cursor_jarantbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODINTER,DATAINI,DATAFINE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pRapporto,"?",0,0,m_cServer, m_oParameters),m_cServer,pRapporto)+" "+")"+(m_Ctx.IsSharedTemp("jarantbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_jarantbo.Eof())) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_jarantbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* mcFamiglia.AppendBlank() */
          mcFamiglia.AppendBlank();
          /* mcFamiglia.TIPOSOG := '8-Garantito' */
          mcFamiglia.row.TIPOSOG = "8-Garantito";
          /* mcFamiglia.CODINTER := jarantbo->CODINTER */
          mcFamiglia.row.CODINTER = Cursor_jarantbo.GetString("CODINTER");
          /* mcFamiglia.RAGSOC := Upper(personbo->RAGSOC) */
          mcFamiglia.row.RAGSOC = CPLib.Upper(Cursor_personbo.GetString("RAGSOC"));
          /* mcFamiglia.DATAINI := jarantbo->DATAINI */
          mcFamiglia.row.DATAINI = Cursor_jarantbo.GetDate("DATAINI");
          /* mcFamiglia.DATAFINE := jarantbo->DATAFINE */
          mcFamiglia.row.DATAFINE = Cursor_jarantbo.GetDate("DATAFINE");
          /* mcFamiglia.CODFISC := Upper(personbo->CODFISC) */
          mcFamiglia.row.CODFISC = CPLib.Upper(Cursor_personbo.GetString("CODFISC"));
          /* mcFamiglia.COGNOME := Upper(personbo->COGNOME) */
          mcFamiglia.row.COGNOME = CPLib.Upper(Cursor_personbo.GetString("COGNOME"));
          /* mcFamiglia.NOME := Upper(personbo->NOME) */
          mcFamiglia.row.NOME = CPLib.Upper(Cursor_personbo.GetString("NOME"));
          /* mcFamiglia.LUONAS := iif(Upper(personbo->TIPINTER)='EE',Upper(personbo->NASSTATO),Upper(personbo->NASCOMUN)) */
          mcFamiglia.row.LUONAS = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("TIPINTER")),"EE")?CPLib.Upper(Cursor_personbo.GetString("NASSTATO")):CPLib.Upper(Cursor_personbo.GetString("NASCOMUN")));
          /* mcFamiglia.DATNAS := personbo->DATANASC */
          mcFamiglia.row.DATNAS = Cursor_personbo.GetDate("DATANASC");
          /* mcFamiglia.SESSO := personbo->SESSO */
          mcFamiglia.row.SESSO = Cursor_personbo.GetString("SESSO");
          /* mcFamiglia.PROVNAS := Upper(personbo->TIPINTER) */
          mcFamiglia.row.PROVNAS = CPLib.Upper(Cursor_personbo.GetString("TIPINTER"));
          /* _despaese := '' */
          _despaese = "";
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _despaese = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arfn_ae_famiglia returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _despaese = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* mcFamiglia.PAESE := Upper(_despaese) */
          mcFamiglia.row.PAESE = CPLib.Upper(_despaese);
          /* If Empty(Upper(personbo->PROVINCIA)) */
          if (CPLib.Empty(CPLib.Upper(Cursor_personbo.GetString("PROVINCIA")))) {
            /* mcFamiglia.SEDELEG := iif(personbo->PAESE='086' or Empty(personbo->PAESE),Upper(personbo->DESCCIT),_despaese) */
            mcFamiglia.row.SEDELEG = (CPLib.eqr(Cursor_personbo.GetString("PAESE"),"086") || CPLib.Empty(Cursor_personbo.GetString("PAESE"))?CPLib.Upper(Cursor_personbo.GetString("DESCCIT")):_despaese);
            /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
            mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
          } else { // Else
            /* mcFamiglia.SEDELEG := iif(Upper(personbo->PROVINCIA)='EE',_despaese,Upper(personbo->DESCCIT)) */
            mcFamiglia.row.SEDELEG = (CPLib.eqr(CPLib.Upper(Cursor_personbo.GetString("PROVINCIA")),"EE")?_despaese:CPLib.Upper(Cursor_personbo.GetString("DESCCIT")));
            /* mcFamiglia.PROVLEG := Upper(personbo->PROVINCIA) */
            mcFamiglia.row.PROVLEG = CPLib.Upper(Cursor_personbo.GetString("PROVINCIA"));
          } // End If
          /* mcFamiglia.CFESTERO := personbo->CFESTERO */
          mcFamiglia.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
          /* mcFamiglia.ORIGINE := 'A' */
          mcFamiglia.row.ORIGINE = "A";
          /* mcFamiglia.SaveRow() */
          mcFamiglia.SaveRow();
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        Cursor_jarantbo.Next();
      }
      m_cConnectivityError = Cursor_jarantbo.ErrorMessage();
      Cursor_jarantbo.Close();
      // * --- End Select
      /* Return mcFamiglia */
      throw new Stop(mcFamiglia);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
      try {
        if (Cursor_intestit!=null)
          Cursor_intestit.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pRapporto,String p_pTipo) {
    pRapporto = p_pRapporto;
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
  public MemoryCursor_mcfamiglia_mcrdef Run(String p_pRapporto,String p_pTipo) {
    pRapporto = p_pRapporto;
    pTipo = p_pTipo;
    return Run();
  }
  public MemoryCursor_mcfamiglia_mcrdef Run() {
    MemoryCursor_mcfamiglia_mcrdef l_result;
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
        l_result = (MemoryCursor_mcfamiglia_mcrdef)stop_value.GetObject();
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
  public static arfn_ae_famigliaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_ae_famigliaR(p_Ctx, p_Caller);
  }
  public static arfn_ae_famigliaR Make(CPContext p_Ctx) {
    return new arfn_ae_famigliaR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pRapporto = CPLib.Space(25);
    pTipo = CPLib.Space(1);
    _noage = 0;
    _ragsoc = CPLib.Space(70);
    _piva = CPLib.Space(14);
    _tipopers = CPLib.Space(1);
    mcFamiglia = new MemoryCursor_mcfamiglia_mcrdef();
    _notit = 0;
    _despaese = CPLib.Space(40);
    _tipoint = 0;
    _presente = 0;
    gDataTito=m_Ctx.GetGlobalDate("gDataTito");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_ae_famiglia,
  public static final String i_InvokedRoutines = ",arfn_ae_famiglia,";
  public static String[] m_cRunParameterNames={"pRapporto","pTipo"};
}
