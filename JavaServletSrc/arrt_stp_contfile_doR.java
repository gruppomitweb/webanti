// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stp_contfile_doR implements CallerWithObjs {
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
  public String m_cPhName_aedecanc;
  public String m_cServer_aedecanc;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tmp_stpfileage;
  public String m_cServer_tmp_stpfileage;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
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
  public String w_nomefile;
  public String w_idfile;
  public String _nomefile;
  public String _tipofile;
  public String _ragsoc;
  public String _tipoag;
  public String _coint;
  public String _r;
  public String _cfinvio;
  public String _cafinvio;
  public String _codfisc;
  public String _adata;
  public String _cdata;
  public String gAzienda;
  public String gDescAzi;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_stp_contfile_doR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stp_contfile_do",m_Caller);
    m_cPhName_aedecanc = p_ContextObject.GetPhName("aedecanc");
    if (m_cPhName_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedecanc = m_cPhName_aedecanc+" "+m_Ctx.GetWritePhName("aedecanc");
    }
    m_cServer_aedecanc = p_ContextObject.GetServer("aedecanc");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_stpfileage")) {
      m_cPhName_tmp_stpfileage = p_ContextObject.GetPhName("tmp_stpfileage");
      if (m_cPhName_tmp_stpfileage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_stpfileage = m_cPhName_tmp_stpfileage+" "+m_Ctx.GetWritePhName("tmp_stpfileage");
      }
      m_cServer_tmp_stpfileage = p_ContextObject.GetServer("tmp_stpfileage");
    }
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
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
      return "arrt_stp_contfile_do";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("idfile",p_cVarName)) {
      return w_idfile;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("_tipofile",p_cVarName)) {
      return _tipofile;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      return _tipoag;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      return _coint;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      return _r;
    }
    if (CPLib.eqr("_cfinvio",p_cVarName)) {
      return _cfinvio;
    }
    if (CPLib.eqr("_cafinvio",p_cVarName)) {
      return _cafinvio;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_adata",p_cVarName)) {
      return _adata;
    }
    if (CPLib.eqr("_cdata",p_cVarName)) {
      return _cdata;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("idfile",p_cVarName)) {
      w_idfile = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("_tipofile",p_cVarName)) {
      _tipofile = value;
      return;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      _tipoag = value;
      return;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      _coint = value;
      return;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      _r = value;
      return;
    }
    if (CPLib.eqr("_cfinvio",p_cVarName)) {
      _cfinvio = value;
      return;
    }
    if (CPLib.eqr("_cafinvio",p_cVarName)) {
      _cafinvio = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_adata",p_cVarName)) {
      _adata = value;
      return;
    }
    if (CPLib.eqr("_cdata",p_cVarName)) {
      _cdata = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_aederig=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aedecanc=null;
    CPResultSet Cursor_aeoprig=null;
    CPResultSet Cursor_aeopcanc=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_nomefile Char(20) */
      /* w_idfile Char(10) */
      /* Definizione variabili locali */
      /* _nomefile Char(15) */
      /* _tipofile Char(1) */
      /* _ragsoc Char(70) */
      /* _tipoag Char(2) */
      /* _coint Char(1) */
      /* _r Char(25) */
      /* _cfinvio Char(16) */
      /* _cafinvio Char(5) */
      /* _codfisc Char(16) */
      /* _adata Char(8) */
      /* _cdata Char(8) */
      /* Dichiarazione variabili globali */
      /* gAzienda Char(10) // Azienda */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* Prima conta poi cancella */
      /* _nomefile := Left(w_nomefile,15) */
      _nomefile = CPLib.Left(w_nomefile,15);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CFINVIO,CAFINVIO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _cfinvio := intermbo->CFINVIO */
        _cfinvio = Cursor_intermbo.GetString("CFINVIO");
        /* _cafinvio := intermbo->CAFINVIO */
        _cafinvio = Cursor_intermbo.GetString("CAFINVIO");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Drop temporary table tmp_stpfileage
      if (m_Ctx.IsSharedTemp("tmp_stpfileage")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpfileage")) {
          m_cServer = m_Ctx.GetServer("tmp_stpfileage");
          m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpfileage");
      }
      // * --- Create temporary table tmp_stpfileage
      if (m_Ctx.IsSharedTemp("tmp_stpfileage")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_stpfileage")) {
          m_cServer = m_Ctx.GetServer("tmp_stpfileage");
          m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_stpfileage");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_stpfileage");
      if ( ! (m_Ctx.IsSharedTemp("tmp_stpfileage"))) {
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_stpfileage",m_cServer,"proto")),m_cPhName,"tmp_stpfileage",m_Ctx);
      }
      m_cPhName_tmp_stpfileage = m_cPhName;
      // * --- Select from aederig
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      if (Cursor_aederig!=null)
        Cursor_aederig.Close();
      Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  or  CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  or  COLDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aederig.Eof())) {
        /* gMsgImp := "Sto Elaborando il codice: "+aederig->CONNESINT // Messaggio Import */
        gMsgImp = "Sto Elaborando il codice: "+Cursor_aederig.GetString("CONNESINT");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If aederig->NOCODFISC='S' */
        if (CPLib.eqr(Cursor_aederig.GetString("NOCODFISC"),"S")) {
          /* Case aederig->AFILE=_nomefile */
          if (CPLib.eqr(Cursor_aederig.GetString("AFILE"),_nomefile)) {
            /* _tipofile := '4' */
            _tipofile = "4";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aederig->APROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aederig.GetString("APROG")),25);
            /* Case aederig->CFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aederig.GetString("CFILE"),_nomefile)) {
            /* _tipofile := '5' */
            _tipofile = "5";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aederig->CPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aederig.GetString("CPROG")),25);
            /* Case aederig->COLDFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aederig.GetString("COLDFILE"),_nomefile)) {
            /* _tipofile := '6' */
            _tipofile = "6";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aederig->COLDPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aederig.GetString("COLDPROG")),25);
          } // End Case
        } else { // Else
          /* Case aederig->AFILE=_nomefile */
          if (CPLib.eqr(Cursor_aederig.GetString("AFILE"),_nomefile)) {
            /* _tipofile := '1' */
            _tipofile = "1";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aederig->APROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aederig.GetString("APROG")),25);
            /* Case aederig->CFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aederig.GetString("CFILE"),_nomefile)) {
            /* _tipofile := '2' */
            _tipofile = "2";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aederig->CPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aederig.GetString("CPROG")),25);
            /* Case aederig->COLDFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aederig.GetString("COLDFILE"),_nomefile)) {
            /* _tipofile := '3' */
            _tipofile = "3";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aederig->COLDPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aederig.GetString("COLDPROG")),25);
          } // End Case
        } // End If
        /* _ragsoc := '' */
        _ragsoc = "";
        /* _codfisc := '' */
        _codfisc = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aederig.GetString("CONNESINT"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _ragsoc = Read_Cursor.GetString("RAGSOC");
          _codfisc = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stp_contfile_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _ragsoc = "";
          _codfisc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _tipoag := aederig->TIPOAG */
        _tipoag = Cursor_aederig.GetString("TIPOAG");
        /* _coint := aederig->COINT */
        _coint = Cursor_aederig.GetString("COINT");
        /* _adata := Right(DateToChar(aederig->ADATA),2)+Substr(DateToChar(aederig->ADATA),5,2)+Left(DateToChar(aederig->ADATA),4) */
        _adata = CPLib.Right(CPLib.DateToChar(Cursor_aederig.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aederig.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aederig.GetDate("ADATA")),4);
        /* _cdata := iif(not(Empty(aederig->CDATA)),Right(DateToChar(aederig->CDATA),2)+Substr(DateToChar(aederig->CDATA),5,2)+Left(DateToChar(aederig->CDATA),4),Space(8)) */
        _cdata = ( ! (CPLib.Empty(Cursor_aederig.GetDate("CDATA")))?CPLib.Right(CPLib.DateToChar(Cursor_aederig.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aederig.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aederig.GetDate("CDATA")),4):CPLib.Space(8));
        // * --- Insert into tmp_stpfileage from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpfileage",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_contfile_do",29,"00000034")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000034(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_r,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_ragsoc,60),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_adata,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cdata,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipoag,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpfileage",true);
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
        Cursor_aederig.Next();
      }
      m_cConnectivityError = Cursor_aederig.ErrorMessage();
      Cursor_aederig.Close();
      // * --- End Select
      // * --- Select from aedecanc
      m_cServer = m_Ctx.GetServer("aedecanc");
      m_cPhName = m_Ctx.GetPhName("aedecanc");
      if (Cursor_aedecanc!=null)
        Cursor_aedecanc.Close();
      Cursor_aedecanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aedecanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aedecanc.Eof())) {
        /* gMsgImp := "Sto Elaborando il codice: "+aedecanc->CONNESINT // Messaggio Import */
        gMsgImp = "Sto Elaborando il codice: "+Cursor_aedecanc.GetString("CONNESINT");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If aedecanc->NOCODFISC='S' */
        if (CPLib.eqr(Cursor_aedecanc.GetString("NOCODFISC"),"S")) {
          /* _tipofile := '6' */
          _tipofile = "6";
        } else { // Else
          /* _tipofile := '3' */
          _tipofile = "3";
        } // End If
        /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aedecanc->IDPROG),25) */
        _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aedecanc.GetString("IDPROG")),25);
        /* _ragsoc := '' */
        _ragsoc = "";
        /* _codfisc := '' */
        _codfisc = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aedecanc.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aedecanc.GetString("CONNESINT"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _ragsoc = Read_Cursor.GetString("RAGSOC");
          _codfisc = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stp_contfile_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _ragsoc = "";
          _codfisc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _tipoag := aedecanc->TIPOAG */
        _tipoag = Cursor_aedecanc.GetString("TIPOAG");
        /* _coint := aedecanc->COINT */
        _coint = Cursor_aedecanc.GetString("COINT");
        /* _adata := Right(DateToChar(aedecanc->ADATA),2)+Substr(DateToChar(aedecanc->ADATA),5,2)+Left(DateToChar(aedecanc->ADATA),4) */
        _adata = CPLib.Right(CPLib.DateToChar(Cursor_aedecanc.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aedecanc.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aedecanc.GetDate("ADATA")),4);
        /* _cdata := iif(not(Empty(aedecanc->CDATA)),Right(DateToChar(aedecanc->CDATA),2)+Substr(DateToChar(aedecanc->CDATA),5,2)+Left(DateToChar(aedecanc->CDATA),4),Space(8)) */
        _cdata = ( ! (CPLib.Empty(Cursor_aedecanc.GetDate("CDATA")))?CPLib.Right(CPLib.DateToChar(Cursor_aedecanc.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aedecanc.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aedecanc.GetDate("CDATA")),4):CPLib.Space(8));
        // * --- Insert into tmp_stpfileage from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpfileage",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_contfile_do",29,"00000042")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000042(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aedecanc.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_r,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_ragsoc,60),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_adata,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_cdata,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipoag,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpfileage",true);
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
        Cursor_aedecanc.Next();
      }
      m_cConnectivityError = Cursor_aedecanc.ErrorMessage();
      Cursor_aedecanc.Close();
      // * --- End Select
      // * --- Select from aeoprig
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      if (Cursor_aeoprig!=null)
        Cursor_aeoprig.Close();
      Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  or  CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  or  COLDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aeoprig.Eof())) {
        /* gMsgImp := "Sto Elaborando il codice: "+aeoprig->CONNESINT // Messaggio Import */
        gMsgImp = "Sto Elaborando il codice: "+Cursor_aeoprig.GetString("CONNESINT");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If aeoprig->NOCODFISC='S' */
        if (CPLib.eqr(Cursor_aeoprig.GetString("NOCODFISC"),"S")) {
          /* Case aeoprig->AFILE=_nomefile */
          if (CPLib.eqr(Cursor_aeoprig.GetString("AFILE"),_nomefile)) {
            /* _tipofile := '4' */
            _tipofile = "4";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aeoprig->APROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aeoprig.GetString("APROG")),25);
            /* Case aeoprig->COLDFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aeoprig.GetString("COLDFILE"),_nomefile)) {
            /* _tipofile := '6' */
            _tipofile = "6";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aeoprig->COLDPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aeoprig.GetString("COLDPROG")),25);
          } // End Case
        } else { // Else
          /* Case aeoprig->AFILE=_nomefile */
          if (CPLib.eqr(Cursor_aeoprig.GetString("AFILE"),_nomefile)) {
            /* _tipofile := '1' */
            _tipofile = "1";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aeoprig->APROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aeoprig.GetString("APROG")),25);
            /* Case aeoprig->COLDFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aeoprig.GetString("COLDFILE"),_nomefile)) {
            /* _tipofile := '3' */
            _tipofile = "3";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aeoprig->COLDPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aeoprig.GetString("COLDPROG")),25);
          } // End Case
        } // End If
        /* _ragsoc := '' */
        _ragsoc = "";
        /* _codfisc := '' */
        _codfisc = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("CONNESINT"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _ragsoc = Read_Cursor.GetString("RAGSOC");
          _codfisc = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stp_contfile_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _ragsoc = "";
          _codfisc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _tipoag := aeoprig->TIPOAG */
        _tipoag = Cursor_aeoprig.GetString("TIPOAG");
        /* _coint := aeoprig->COINT */
        _coint = Cursor_aeoprig.GetString("COINT");
        /* _adata := Right(DateToChar(aeoprig->ADATA),2)+Substr(DateToChar(aeoprig->ADATA),5,2)+Left(DateToChar(aeoprig->ADATA),4) */
        _adata = CPLib.Right(CPLib.DateToChar(Cursor_aeoprig.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aeoprig.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aeoprig.GetDate("ADATA")),4);
        // * --- Insert into tmp_stpfileage from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpfileage",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_contfile_do",29,"00000057")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000057(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_r,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_ragsoc,60),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_adata,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipoag,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpfileage",true);
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
        Cursor_aeoprig.Next();
      }
      m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
      Cursor_aeoprig.Close();
      // * --- End Select
      // * --- Select from aeopcanc
      m_cServer = m_Ctx.GetServer("aeopcanc");
      m_cPhName = m_Ctx.GetPhName("aeopcanc");
      if (Cursor_aeopcanc!=null)
        Cursor_aeopcanc.Close();
      Cursor_aeopcanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aeopcanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aeopcanc.Eof())) {
        /* gMsgImp := "Sto Elaborando il codice: "+aeopcanc->CONNESINT // Messaggio Import */
        gMsgImp = "Sto Elaborando il codice: "+Cursor_aeopcanc.GetString("CONNESINT");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If aeopcanc->NOCODFISC='S' */
        if (CPLib.eqr(Cursor_aeopcanc.GetString("NOCODFISC"),"S")) {
          /* _tipofile := '6' */
          _tipofile = "6";
        } else { // Else
          /* _tipofile := '3' */
          _tipofile = "3";
        } // End If
        /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aeopcanc->IDPROG),25) */
        _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aeopcanc.GetString("IDPROG")),25);
        /* _ragsoc := '' */
        _ragsoc = "";
        /* _codfisc := '' */
        _codfisc = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeopcanc.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aeopcanc.GetString("CONNESINT"));
        if (m_Ctx.IsSharedTemp("personbo")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAGSOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _ragsoc = Read_Cursor.GetString("RAGSOC");
          _codfisc = Read_Cursor.GetString("CODFISC");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stp_contfile_do returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _ragsoc = "";
          _codfisc = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _tipoag := aeopcanc->TIPOAG */
        _tipoag = Cursor_aeopcanc.GetString("TIPOAG");
        /* _coint := aeopcanc->COINT */
        _coint = Cursor_aeopcanc.GetString("COINT");
        /* _adata := Right(DateToChar(aeopcanc->ADATA),2)+Substr(DateToChar(aeopcanc->ADATA),5,2)+Left(DateToChar(aeopcanc->ADATA),4) */
        _adata = CPLib.Right(CPLib.DateToChar(Cursor_aeopcanc.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aeopcanc.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aeopcanc.GetDate("ADATA")),4);
        // * --- Insert into tmp_stpfileage from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpfileage",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_contfile_do",29,"00000064")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000064(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeopcanc.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_r,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_ragsoc,60),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_adata,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Space(8),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_coint,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipoag,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_codfisc,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_stpfileage",true);
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
        Cursor_aeopcanc.Next();
      }
      m_cConnectivityError = Cursor_aeopcanc.ErrorMessage();
      Cursor_aeopcanc.Close();
      // * --- End Select
      /* gMsgImp := "Elaborazione Terminata" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Stop Report */
      Forward f;
      f=new Forward("Report",false,this,Forward.Start,false);
      f.SetParameter("ReportName","arrp_stp_fileage");
      f.SetParameter("outputFormat","PDF");
      f.SetParameter("rotation","LANDSCAPE");
      f.SetParameter("DescAzi",gDescAzi);
      f.SetParameter("cfinvio",_cfinvio);
      f.SetParameter("cafinvio",_cafinvio);
      f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"rotation"+","+"DescAzi"+","+"cfinvio"+","+"cafinvio");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
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
        if (Cursor_aedecanc!=null)
          Cursor_aedecanc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeopcanc!=null)
          Cursor_aeopcanc.Close();
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
      m_Caller.SetString("nomefile","C",20,0,w_nomefile);
      m_Caller.SetString("idfile","C",10,0,w_idfile);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_stp_contfile_doR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stp_contfile_doR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_nomefile = m_Caller.GetString("nomefile","C",20,0);
    w_idfile = m_Caller.GetString("idfile","C",10,0);
    _nomefile = CPLib.Space(15);
    _tipofile = CPLib.Space(1);
    _ragsoc = CPLib.Space(70);
    _tipoag = CPLib.Space(2);
    _coint = CPLib.Space(1);
    _r = CPLib.Space(25);
    _cfinvio = CPLib.Space(16);
    _cafinvio = CPLib.Space(5);
    _codfisc = CPLib.Space(16);
    _adata = CPLib.Space(8);
    _cdata = CPLib.Space(8);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000034(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"tipofile,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"datini,";
    p_cSql = p_cSql+"datfin,";
    p_cSql = p_cSql+"tiporap,";
    p_cSql = p_cSql+"agerap,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpfileage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000042(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"tipofile,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"datini,";
    p_cSql = p_cSql+"datfin,";
    p_cSql = p_cSql+"tiporap,";
    p_cSql = p_cSql+"agerap,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpfileage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000057(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"tipofile,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"datini,";
    p_cSql = p_cSql+"datfin,";
    p_cSql = p_cSql+"tiporap,";
    p_cSql = p_cSql+"agerap,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpfileage",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000064(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"tipofile,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"nprog,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"datini,";
    p_cSql = p_cSql+"datfin,";
    p_cSql = p_cSql+"tiporap,";
    p_cSql = p_cSql+"agerap,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_stpfileage",true);
    return p_cSql;
  }
}
