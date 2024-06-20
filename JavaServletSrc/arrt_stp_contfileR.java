// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_stp_contfileR implements CallerWithObjs {
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
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tmp_stpfileage;
  public String m_cServer_tmp_stpfileage;
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
  public arrt_stp_contfileR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_stp_contfile",m_Caller);
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
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
      return "arrt_stp_contfile";
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
    CPResultSet Cursor_aerighe=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aecanc=null;
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
      // * --- Select from aerighe
      m_cServer = m_Ctx.GetServer("aerighe");
      m_cPhName = m_Ctx.GetPhName("aerighe");
      if (Cursor_aerighe!=null)
        Cursor_aerighe.Close();
      Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"AFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  or  CFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+"  or  COLDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aerighe.Eof())) {
        /* gMsgImp := "Sto Elaborando il codice: "+aerighe->CONNESINT // Messaggio Import */
        gMsgImp = "Sto Elaborando il codice: "+Cursor_aerighe.GetString("CONNESINT");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If aerighe->NOCODFISC='S' */
        if (CPLib.eqr(Cursor_aerighe.GetString("NOCODFISC"),"S")) {
          /* Case aerighe->AFILE=_nomefile */
          if (CPLib.eqr(Cursor_aerighe.GetString("AFILE"),_nomefile)) {
            /* _tipofile := '4' */
            _tipofile = "4";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aerighe->APROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aerighe.GetString("APROG")),25);
            /* Case aerighe->CFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aerighe.GetString("CFILE"),_nomefile)) {
            /* _tipofile := '5' */
            _tipofile = "5";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aerighe->CPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aerighe.GetString("CPROG")),25);
            /* Case aerighe->COLDFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aerighe.GetString("COLDFILE"),_nomefile)) {
            /* _tipofile := '6' */
            _tipofile = "6";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aerighe->COLDPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aerighe.GetString("COLDPROG")),25);
          } // End Case
        } else { // Else
          /* Case aerighe->AFILE=_nomefile */
          if (CPLib.eqr(Cursor_aerighe.GetString("AFILE"),_nomefile)) {
            /* _tipofile := '1' */
            _tipofile = "1";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aerighe->APROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aerighe.GetString("APROG")),25);
            /* Case aerighe->CFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aerighe.GetString("CFILE"),_nomefile)) {
            /* _tipofile := '2' */
            _tipofile = "2";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aerighe->CPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aerighe.GetString("CPROG")),25);
            /* Case aerighe->COLDFILE=_nomefile */
          } else if (CPLib.eqr(Cursor_aerighe.GetString("COLDFILE"),_nomefile)) {
            /* _tipofile := '3' */
            _tipofile = "3";
            /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aerighe->COLDPROG),25) */
            _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aerighe.GetString("COLDPROG")),25);
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
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aerighe.GetString("CONNESINT"));
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
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stp_contfile returns two or more records. This item should return only a record.");
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
        /* _tipoag := '' */
        _tipoag = "";
        /* _coint := '' */
        _coint = "";
        // * --- Read from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aerighe.GetString("RAPPORTO"));
        if (m_Ctx.IsSharedTemp("aetesta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tipoag = Read_Cursor.GetString("TIPOAG");
          _coint = Read_Cursor.GetString("COINT");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aetesta into routine arrt_stp_contfile returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tipoag = "";
          _coint = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _adata := Right(DateToChar(aerighe->ADATA),2)+Substr(DateToChar(aerighe->ADATA),5,2)+Left(DateToChar(aerighe->ADATA),4) */
        _adata = CPLib.Right(CPLib.DateToChar(Cursor_aerighe.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aerighe.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aerighe.GetDate("ADATA")),4);
        /* _cdata := iif(not(Empty(aerighe->CDATA)),Right(DateToChar(aerighe->CDATA),2)+Substr(DateToChar(aerighe->CDATA),5,2)+Left(DateToChar(aerighe->CDATA),4),Space(8)) */
        _cdata = ( ! (CPLib.Empty(Cursor_aerighe.GetDate("CDATA")))?CPLib.Right(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aerighe.GetDate("CDATA")),4):CPLib.Space(8));
        // * --- Insert into tmp_stpfileage from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpfileage",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_contfile",27,"00000034")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000034(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
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
        Cursor_aerighe.Next();
      }
      m_cConnectivityError = Cursor_aerighe.ErrorMessage();
      Cursor_aerighe.Close();
      // * --- End Select
      // * --- Select from aecanc
      m_cServer = m_Ctx.GetServer("aecanc");
      m_cPhName = m_Ctx.GetPhName("aecanc");
      if (Cursor_aecanc!=null)
        Cursor_aecanc.Close();
      Cursor_aecanc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILE="+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer, m_oParameters),m_cServer,_nomefile)+" "+")"+(m_Ctx.IsSharedTemp("aecanc")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aecanc.Eof())) {
        /* gMsgImp := "Sto Elaborando il codice: "+aecanc->CONNESINT // Messaggio Import */
        gMsgImp = "Sto Elaborando il codice: "+Cursor_aecanc.GetString("CONNESINT");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If aecanc->NOCODFISC='S' */
        if (CPLib.eqr(Cursor_aecanc.GetString("NOCODFISC"),"S")) {
          /* _tipofile := '6' */
          _tipofile = "6";
        } else { // Else
          /* _tipofile := '3' */
          _tipofile = "3";
        } // End If
        /* _r := Right("0000000000000000000000000000000000000000" + LRTrim(aecanc->IDPROG),25) */
        _r = CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_aecanc.GetString("IDPROG")),25);
        /* _ragsoc := '' */
        _ragsoc = "";
        /* _codfisc := '' */
        _codfisc = "";
        // * --- Read from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        m_cSql = "";
        m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aecanc.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_aecanc.GetString("CONNESINT"));
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
            Error l_oErrorFault = new Error("Read on personbo into routine arrt_stp_contfile returns two or more records. This item should return only a record.");
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
        /* _tipoag := '' */
        _tipoag = "";
        /* _coint := '' */
        _coint = "";
        // * --- Read from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aecanc.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_aecanc.GetString("RAPPORTO"));
        if (m_Ctx.IsSharedTemp("aetesta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COINT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _tipoag = Read_Cursor.GetString("TIPOAG");
          _coint = Read_Cursor.GetString("COINT");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aetesta into routine arrt_stp_contfile returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _tipoag = "";
          _coint = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* _adata := Right(DateToChar(aecanc->ADATA),2)+Substr(DateToChar(aecanc->ADATA),5,2)+Left(DateToChar(aecanc->ADATA),4) */
        _adata = CPLib.Right(CPLib.DateToChar(Cursor_aecanc.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aecanc.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aecanc.GetDate("ADATA")),4);
        /* _cdata := iif(not(Empty(aecanc->CDATA)),Right(DateToChar(aecanc->CDATA),2)+Substr(DateToChar(aecanc->CDATA),5,2)+Left(DateToChar(aecanc->CDATA),4),Space(8)) */
        _cdata = ( ! (CPLib.Empty(Cursor_aecanc.GetDate("CDATA")))?CPLib.Right(CPLib.DateToChar(Cursor_aecanc.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_aecanc.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_aecanc.GetDate("CDATA")),4):CPLib.Space(8));
        // * --- Insert into tmp_stpfileage from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_stpfileage");
        m_cPhName = m_Ctx.GetPhName("tmp_stpfileage");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_stpfileage",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_stp_contfile",27,"00000043")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000043(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipofile,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aecanc.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
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
        Cursor_aecanc.Next();
      }
      m_cConnectivityError = Cursor_aecanc.ErrorMessage();
      Cursor_aecanc.Close();
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
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
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
        if (Cursor_aecanc!=null)
          Cursor_aecanc.Close();
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
  public static arrt_stp_contfileR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_stp_contfileR(p_Ctx, p_Caller);
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
  protected static String GetFieldsName_00000043(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
