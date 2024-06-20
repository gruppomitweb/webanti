// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_imp_dati_storico_examR implements CallerWithObjs {
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
  public String m_cPhName_tbcauana;
  public String m_cServer_tbcauana;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_tmp_errimp;
  public String m_cServer_tmp_errimp;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_tbstgru;
  public String m_cServer_tbstgru;
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
  public String w_tipodest;
  public double w_impzip;
  public double w_errchk;
  public String fhand;
  public String riga;
  public String xConnes;
  public String _ucode;
  public double conta;
  public String cSetSin;
  public double _errori;
  public MemoryCursor_anadip mcanadip;
  public String _tipsot;
  public String czipfile;
  public String nomefileimport;
  public double _priorita;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathDoc;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_storico_exam
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_imp_dati_storico_examR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_storico_exam",m_Caller);
    m_cPhName_tbcauana = p_ContextObject.GetPhName("tbcauana");
    if (m_cPhName_tbcauana.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcauana = m_cPhName_tbcauana+" "+m_Ctx.GetWritePhName("tbcauana");
    }
    m_cServer_tbcauana = p_ContextObject.GetServer("tbcauana");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_errimp")) {
      m_cPhName_tmp_errimp = p_ContextObject.GetPhName("tmp_errimp");
      if (m_cPhName_tmp_errimp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_errimp = m_cPhName_tmp_errimp+" "+m_Ctx.GetWritePhName("tmp_errimp");
      }
      m_cServer_tmp_errimp = p_ContextObject.GetServer("tmp_errimp");
    }
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_tbstgru = p_ContextObject.GetPhName("tbstgru");
    if (m_cPhName_tbstgru.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstgru = m_cPhName_tbstgru+" "+m_Ctx.GetWritePhName("tbstgru");
    }
    m_cServer_tbstgru = p_ContextObject.GetServer("tbstgru");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
    if (CPLib.eqr("errchk",p_cVarName)) {
      return w_errchk;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_errori",p_cVarName)) {
      return _errori;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      return _priorita;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_storico_exam";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("tipodest",p_cVarName)) {
      return w_tipodest;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      return _ucode;
    }
    if (CPLib.eqr("cSetSin",p_cVarName)) {
      return cSetSin;
    }
    if (CPLib.eqr("_tipsot",p_cVarName)) {
      return _tipsot;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      return czipfile;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
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
    if (CPLib.eqr("mcanadip",p_cVarName)) {
      return mcanadip;
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
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
      return;
    }
    if (CPLib.eqr("errchk",p_cVarName)) {
      w_errchk = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_errori",p_cVarName)) {
      _errori = value;
      return;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipodest",p_cVarName)) {
      w_tipodest = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
      return;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      _ucode = value;
      return;
    }
    if (CPLib.eqr("cSetSin",p_cVarName)) {
      cSetSin = value;
      return;
    }
    if (CPLib.eqr("_tipsot",p_cVarName)) {
      _tipsot = value;
      return;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      czipfile = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
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
    if (CPLib.eqr("mcanadip",p_cVarName)) {
      mcanadip = (MemoryCursor_anadip)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tmp_list_imprich=null;
    CPResultSet Cursor_anadip=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_tipodest Char(1) */
      /* w_impzip Numeric(1, 0) */
      /* w_errchk Numeric(1, 0) */
      /* Definizione variabili locali */
      /* fhand Char(1) */
      /* riga Memo */
      /* xConnes Char(16) */
      /* _ucode Char(10) */
      /* conta Numeric(10, 0) */
      /* cSetSin Char(3) */
      /* _errori Numeric(10, 0) */
      /* _elaborato Bool := False */
      boolean _elaborato;
      _elaborato = false;
      /* mcanadip MemoryCursor(anadip) // mc anadip */
      /* _tipsot Char(1) // Richiesto Ateco */
      /* czipfile Char(100) */
      /* nomefileimport Char(100) */
      /* _priorita Numeric(3, 0) */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gPathDoc Char(128) // Path Documenti */
      /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
      /* Import Soggetti */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla sul file della lista e lancia la pagina appropriata */
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* If At('.zip',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        if (CPLib.ne(CPLib.At(".zip",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* czipfile := LRTrim(tmp_list_imprich->nomefile) */
          czipfile = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
          /* Exec "Estrae file da ZIP" Page 9:Page_9 */
          Page_9();
        } // End If
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* Exec "Inserisce priorità sui nomi file" Page 7:Page_7 */
      Page_7();
      // * --- Drop temporary table tmp_errimp
      if (m_Ctx.IsSharedTemp("tmp_errimp")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_errimp")) {
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_errimp");
      }
      // * --- Create temporary table tmp_errimp
      if (m_Ctx.IsSharedTemp("tmp_errimp")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_errimp")) {
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_errimp");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_errimp");
      if ( ! (m_Ctx.IsSharedTemp("tmp_errimp"))) {
        m_cServer = m_Ctx.GetServer("tmp_errimp");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_errimp",m_cServer,"proto")),m_cPhName,"tmp_errimp",m_Ctx);
      }
      m_cPhName_tmp_errimp = m_cPhName;
      // * --- Fill memory cursor mcanadip on anadip
      mcanadip.Zap();
      m_cServer = m_Ctx.GetServer("anadip");
      m_cPhName = m_Ctx.GetPhName("anadip");
      if (Cursor_anadip!=null)
        Cursor_anadip.Close();
      Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_anadip;
        Cursor_anadip.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_imp_dati_storico_exam: query on anadip returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_anadip.Eof())) {
        mcanadip.AppendWithTrimmedKey(Cursor_anadip.GetString("CODDIP"));
        mcanadip.row.CODDIP = Cursor_anadip.GetString("CODDIP");
        mcanadip.row.DESCRIZ = Cursor_anadip.GetString("DESCRIZ");
        mcanadip.row.IDCITTA = Cursor_anadip.GetString("IDCITTA");
        mcanadip.row.DESCCIT = Cursor_anadip.GetString("DESCCIT");
        mcanadip.row.PROVINCIA = Cursor_anadip.GetString("PROVINCIA");
        mcanadip.row.CAB = Cursor_anadip.GetString("CAB");
        mcanadip.row.IDBASE = Cursor_anadip.GetString("IDBASE");
        mcanadip.row.AGENTE = Cursor_anadip.GetString("AGENTE");
        mcanadip.row.MACROAGENTE = Cursor_anadip.GetString("MACROAGENTE");
        mcanadip.row.TERMINALID = Cursor_anadip.GetString("TERMINALID");
        mcanadip.row.DOMICILIO = Cursor_anadip.GetString("DOMICILIO");
        mcanadip.row.TELEFONO = Cursor_anadip.GetString("TELEFONO");
        mcanadip.row.CODLOC = Cursor_anadip.GetString("CODLOC");
        mcanadip.row.ABICABSARA = Cursor_anadip.GetString("ABICABSARA");
        mcanadip.row.NUOVO = Cursor_anadip.GetString("NUOVO");
        mcanadip.row.CAP = Cursor_anadip.GetString("CAP");
        mcanadip.row.AGACCODE = Cursor_anadip.GetString("AGACCODE");
        mcanadip.row.NAZAGENTE = Cursor_anadip.GetString("NAZAGENTE");
        mcanadip.row.OPXSOSCLI = Cursor_anadip.GetDouble("OPXSOSCLI");
        mcanadip.row.OPXSOSAGE = Cursor_anadip.GetDouble("OPXSOSAGE");
        mcanadip.row.VALCOMPL = Cursor_anadip.GetString("VALCOMPL");
        mcanadip.row.ANOMOPER = Cursor_anadip.GetString("ANOMOPER");
        mcanadip.row.AGEREGIO = Cursor_anadip.GetString("AGEREGIO");
        mcanadip.row.FLGATT = Cursor_anadip.GetString("FLGATT");
        mcanadip.row.CODAGE = Cursor_anadip.GetString("CODAGE");
        mcanadip.row.TIPOSV = Cursor_anadip.GetString("TIPOSV");
        mcanadip.row.FLGNOAUA = Cursor_anadip.GetString("FLGNOAUA");
        mcanadip.row.FLGWUPOS = Cursor_anadip.GetString("FLGWUPOS");
        mcanadip.row.CATEG01 = Cursor_anadip.GetString("CATEG01");
        mcanadip.row.CATEG02 = Cursor_anadip.GetString("CATEG02");
        mcanadip.row.CATEG03 = Cursor_anadip.GetString("CATEG03");
        mcanadip.row.CATEG04 = Cursor_anadip.GetString("CATEG04");
        mcanadip.row.CATEG05 = Cursor_anadip.GetString("CATEG05");
        mcanadip.row.CATEGORIA = Cursor_anadip.GetString("CATEGORIA");
        mcanadip.row.CAB2 = Cursor_anadip.GetString("CAB2");
        mcanadip.row.RISGLOB = Cursor_anadip.GetString("RISGLOB");
        mcanadip.row.DATAPROF = Cursor_anadip.GetDate("DATAPROF");
        mcanadip.row.CODICEAAMS = Cursor_anadip.GetString("CODICEAAMS");
        mcanadip.row.CONCESSIONE = Cursor_anadip.GetString("CONCESSIONE");
        mcanadip.row.CODFISC = Cursor_anadip.GetString("CODFISC");
        mcanadip.row.PARTIVA = Cursor_anadip.GetString("PARTIVA");
        mcanadip.row.TIPOAGENTE = Cursor_anadip.GetString("TIPOAGENTE");
        mcanadip.row.NUMCIVICO = Cursor_anadip.GetString("NUMCIVICO");
        mcanadip.row.DATAINI = Cursor_anadip.GetDate("DATAINI");
        mcanadip.row.DATAFINE = Cursor_anadip.GetDate("DATAFINE");
        mcanadip.row.SERRIMDEN = Cursor_anadip.GetString("SERRIMDEN");
        mcanadip.row.FLGCOMPL = Cursor_anadip.GetDouble("FLGCOMPL");
        Cursor_anadip.Next();
      }
      m_cConnectivityError = Cursor_anadip.ErrorMessage();
      Cursor_anadip.Close();
      mcanadip.GoTop();
      /* _errori := 0 */
      _errori = CPLib.Round(0,0);
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
        nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
        /* Case At('archpers.txt',Lower(LRTrim(nomefileimport))) <> 0 */
        if (CPLib.ne(CPLib.At("archpers.txt",CPLib.Lower(CPLib.LRTrim(nomefileimport))),0)) {
          /* Exec "Soggetti" Page 2:Page_2 */
          Page_2();
          /* _elaborato := True */
          _elaborato = true;
          /* Case At('persnew.txt',Lower(LRTrim(nomefileimport))) <> 0 */
        } else if (CPLib.ne(CPLib.At("persnew.txt",CPLib.Lower(CPLib.LRTrim(nomefileimport))),0)) {
          /* Exec "Soggetti PERSNEW" Page 8:Page_8 */
          Page_8();
          /* _elaborato := True */
          _elaborato = true;
          /* Case At('archdip.txt',Lower(LRTrim(nomefileimport))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archdip.txt",CPLib.Lower(CPLib.LRTrim(nomefileimport))),0)) {
          /* Exec "Dipendenze" Page 10:Page_10 */
          Page_10();
          /* _elaborato := True */
          _elaborato = true;
          /* Case At('archinf.txt',Lower(LRTrim(nomefileimport))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archinf.txt",CPLib.Lower(CPLib.LRTrim(nomefileimport))),0)) {
          /* Exec "Informazioni AUI" Page 3:Page_3 */
          Page_3();
          /* _elaborato := True */
          _elaborato = true;
          /* Case At('archope.txt',Lower(LRTrim(nomefileimport))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archope.txt",CPLib.Lower(CPLib.LRTrim(nomefileimport))),0)) {
          /* Exec "Operazioni" Page 4:Page_4 */
          Page_4();
          /* _elaborato := True */
          _elaborato = true;
          /* Case At('archfraz.txt',Lower(LRTrim(nomefileimport))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archfraz.txt",CPLib.Lower(CPLib.LRTrim(nomefileimport))),0)) {
          /* Exec "Frazionate" Page 5:Page_5 */
          Page_5();
          /* _elaborato := True */
          _elaborato = true;
          /* Case At('infage.txt',Lower(LRTrim(nomefileimport))) <> 0 */
        } else if (CPLib.ne(CPLib.At("infage.txt",CPLib.Lower(CPLib.LRTrim(nomefileimport))),0)) {
          /* Exec "Informazioni AGE" Page 6:Page_6 */
          Page_6();
          /* _elaborato := True */
          _elaborato = true;
        } // End Case
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + "Elaborazione Terminata" + NL */
      gMsgProc = gMsgProc+"Elaborazione Terminata"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If _elaborato */
      if (_elaborato) {
        /* If _errori = 0 */
        if (CPLib.eqr(_errori,0)) {
          /* gMsgProc := gMsgProc + "Non sono stati rilevati errori sui file elaborati" + NL */
          gMsgProc = gMsgProc+"Non sono stati rilevati errori sui file elaborati"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := gMsgProc + "Sono stati rilevati errori sui file elaborati" + NL */
          gMsgProc = gMsgProc+"Sono stati rilevati errori sui file elaborati"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + "Premere il bottone di stampa per visualizzare gli errori" + NL */
          gMsgProc = gMsgProc+"Premere il bottone di stampa per visualizzare gli errori"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
      } else { // Else
        /* gMsgProc := gMsgProc + "Il file non rientra tra quelli previsti per il controllo!" + NL */
        gMsgProc = gMsgProc+"Il file non rientra tra quelli previsti per il controllo!"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _errori := -1 */
        _errori = CPLib.Round(-1,0);
      } // End If
      /* Return _errori */
      throw new Stop(_errori);
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
      fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' nominativi del file '+nomefileimport // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" nominativi del file "+nomefileimport;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* xConnes := Substr(riga,488,16) */
          xConnes = CPLib.Substr(riga,488,16);
          /* cSetSin := '' */
          cSetSin = "";
          /* Controlla i Valori */
          /* If Empty(LRTrim(Substr(riga,7,77))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,7,77)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000051")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000051(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca la ragione sociale del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,77,35))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,77,35)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000054")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000054(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca indirizzo del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,112,16))) and LRTrim(Substr(riga,450,1))<>'S' */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,112,16))) && CPLib.ne(CPLib.LRTrim(CPLib.Substr(riga,450,1)),"S")) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000057")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000057(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Codice Fiscale del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,172,3))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,172,3)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000005A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000005A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Settore Sintetico del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,230,30))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,230,30)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000005D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000005D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Città Residenza del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,260,2))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,260,2)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000060")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000060(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca indirizzo del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,262,3))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,262,3)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000063")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000063(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Paese Residenza del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,265,9))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,265,9)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000066")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000066(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca CAP Residenza del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Len(LRTrim(Substr(riga,112,16))) = 16 or (LRTrim(Substr(riga,450,1))='S' and not(Empty(LRTrim(Substr(riga,288,1))))) or (Len(LRTrim(Substr(riga,112,16))) = 11 and not(Empty(LRTrim(Substr(riga,288,1))))) */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,112,16))),16) || (CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,450,1)),"S") &&  ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,288,1))))) || (CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,112,16))),11) &&  ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,288,1)))))) {
            /* If Empty(LRTrim(Substr(riga,128,8))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,128,8)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000006A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca la data di nascita del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,136,30))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,136,30)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000006D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Comune/Stato di nascita del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,175,2))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,175,2)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000070")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000070(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Tipo Documento del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,177,15))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,177,15)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000073")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000073(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Numero Documento del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,192,8))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,192,8)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000076")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000076(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Data Rilascio Documento del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,200,30))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,200,30)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000079")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000079(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Autorità Rilascio Documento del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,288,1))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,288,1)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000007C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000007C(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca il sesso del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,297,26))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,297,26)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000007F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000007F(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Cognome del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,323,25))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,323,25)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000082")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000082(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Nome del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,448,2))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,448,2)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000085")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000085(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Provincia di Nascita del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
          } else { // Else
            /* _tipsot := '' // Richiesto Ateco */
            _tipsot = "";
            // * --- Read from tbstgru
            m_cServer = m_Ctx.GetServer("tbstgru");
            m_cPhName = m_Ctx.GetPhName("tbstgru");
            m_cSql = "";
            m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,166,3));
            if (m_Ctx.IsSharedTemp("tbstgru")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOSOT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _tipsot = Read_Cursor.GetString("TIPOSOT");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_imp_dati_storico_exam returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _tipsot = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(Substr(riga,460,10))) and _tipsot='1' */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,460,10))) && CPLib.eqr(_tipsot,"1")) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000008A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000008A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Attività Economica (ATECO) del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
          } // End If
          /* cSetSin := arfn_calcolasett(Substr(riga,166,3),Substr(riga,169,3),Substr(riga,460,10)) */
          cSetSin = arfn_calcolasettR.Make(m_Ctx,this).Run(CPLib.Substr(riga,166,3),CPLib.Substr(riga,169,3),CPLib.Substr(riga,460,10));
          /* If not(Empty(LRTrim(Substr(riga,172,3)))) and Substr(riga,172,3) <> cSetSin */
          if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,172,3)))) && CPLib.ne(CPLib.Substr(riga,172,3),cSetSin)) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000008E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000008E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Settore Sintetico non congruo per il soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
        } // End If
      } // End While
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgImp := 'Fine controllo del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine controllo del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    /* _coddip Char(6) := NullString() // codice della dipendenza letta */
    String _coddip;
    _coddip = CPLib.NullString();
    /* Legge il file di testo e porta i dati nella tabella */
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
    fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    /* conta := 0 */
    conta = CPLib.Round(0,0);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If not(Empty(LRTrim(riga))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(riga)))) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* _ucode := LRTrim(Substr(riga,159,10)) */
        _ucode = CPLib.LRTrim(CPLib.Substr(riga,159,10));
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(LRTrim(Substr(riga,1,8))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,1,8)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000009F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000009F(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Data Operazione dell'informazione con codice "+_ucode,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,9,25))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,9,25)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000A2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000A2(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Rapporto dell'informazione con codice "+_ucode,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* _coddip := LRTrim(Substr(riga,115,6)) // codice della dipendenza letta */
        _coddip = CPLib.LRTrim(CPLib.Substr(riga,115,6));
        /* If not(Empty(_coddip)) */
        if ( ! (CPLib.Empty(_coddip))) {
          /* If not(mcanadip.HasKey(_coddip)) */
          if ( ! (mcanadip.HasKey(_coddip))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000A7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000A7(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Dipendenza indicata con codice "+_coddip+" non presente in anagrafica dipendenze dell'informazione con codice "+_ucode,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
        } // End If
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Fine Controllo del file '+nomefileimport // Messaggio Import */
    gMsgImp = "Fine Controllo del file "+nomefileimport;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_4() throws Exception {
    /* _coddip Char(6) := NullString() // codice della dipendenza letta */
    String _coddip;
    _coddip = CPLib.NullString();
    /* _inform Char(30) := NullString() // identificativo univoco dell'operazione */
    String _inform;
    _inform = CPLib.NullString();
    /* Legge il file di testo e porta i dati nella tabella */
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
    fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    /* conta := 0 */
    conta = CPLib.Round(0,0);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If not(Empty(LRTrim(riga))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(riga)))) {
        /* _ucode := Substr(riga,318,10) */
        _ucode = CPLib.Substr(riga,318,10);
        /* _inform := iif(Upper(Substr(riga,331,9))='XXXXXXXXX',Substr(riga,424,30),Substr(riga,331,9)) // identificativo univoco dell'operazione */
        _inform = (CPLib.eqr(CPLib.Upper(CPLib.Substr(riga,331,9)),"XXXXXXXXX")?CPLib.Substr(riga,424,30):CPLib.Substr(riga,331,9));
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' operazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" operazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(LRTrim(Substr(riga,9,1))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,9,1)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000BA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000BA(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Flag Contanti nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,10,4))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,10,4)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000BD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000BD(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Causale Analitica nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,14,2))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,14,2)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000C0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000C0(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Causale Sintetica nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If not(Empty(LRTrim(Substr(riga,14,2)))) and At(LRTrim(Substr(riga,14,2)),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,14,2)))) && CPLib.ne(CPLib.At(CPLib.LRTrim(CPLib.Substr(riga,14,2)),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
          /* If Empty(LRTrim(Substr(riga,29,3))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,29,3)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000C4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000C4(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Paese Intermediario Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,62,2))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,62,2)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000C7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000C7(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Provincia Intermediario Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If not(Empty(LRTrim(Substr(riga,29,3)))) and LRTrim(Substr(riga,29,3))='086' */
          if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,29,3)))) && CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,29,3)),"086")) {
            /* If Empty(LRTrim(Substr(riga,64,10))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,64,10)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000CB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000CB(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca CAB Intermediario Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
          } // End If
        } // End If
        /* If Empty(LRTrim(Substr(riga,156,3))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,156,3)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000CE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000CE(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Codice Valuta nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,159,1))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,159,1)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000D1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000D1(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Segno nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,160,15))) or Val(LRTrim(Substr(riga,160,15)))=0 */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,160,15))) || CPLib.eqr(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,160,15))),0)) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000D4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000D4(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Importo nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* _coddip := LRTrim(Substr(riga,257,6)) // codice della dipendenza letta */
        _coddip = CPLib.LRTrim(CPLib.Substr(riga,257,6));
        /* If not(Empty(_coddip)) */
        if ( ! (CPLib.Empty(_coddip))) {
          /* If not(mcanadip.HasKey(_coddip)) */
          if ( ! (mcanadip.HasKey(_coddip))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000D9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000D9(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Dipendenza indicata con codice "+_coddip+" non presente in anagrafica dipendenze dell'informazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
        } // End If
        /* If Empty(LRTrim(Substr(riga,302,16))) and not(Empty(LRTrim(Substr(riga,511,70)))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,302,16))) &&  ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,511,70))))) {
          /* If Empty(LRTrim(Substr(riga,581,3))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,581,3)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000DD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000DD(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Paese Residenza Soggetto Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If not(Empty(LRTrim(Substr(riga,581,3)))) and LRTrim(Substr(riga,581,3))='086' */
          if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,581,3)))) && CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,581,3)),"086")) {
            /* If Empty(LRTrim(Substr(riga,620,2))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,620,2)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000E1(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Provincia Residenza Soggetto Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,614,6))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,614,6)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000E4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000E4(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca CAB Residenza Soggetto Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
          } // End If
        } // End If
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Fine controllo del file '+nomefileimport // Messaggio Import */
    gMsgImp = "Fine controllo del file "+nomefileimport;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_5() throws Exception {
    /* _coddip Char(6) := NullString() // codice della dipendenza letta */
    String _coddip;
    _coddip = CPLib.NullString();
    /* _inform Char(30) := NullString() // identificativo univoco dell'operazione */
    String _inform;
    _inform = CPLib.NullString();
    /* Legge il file di testo e porta i dati nella tabella */
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
    fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    /* conta := 0 */
    conta = CPLib.Round(0,0);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If not(Empty(LRTrim(riga))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(riga)))) {
        /* _ucode := Substr(riga,318,10) */
        _ucode = CPLib.Substr(riga,318,10);
        /* _inform := iif(Upper(Substr(riga,331,9))='XXXXXXXXX',Substr(riga,424,30),Substr(riga,331,9)) // identificativo univoco dell'operazione */
        _inform = (CPLib.eqr(CPLib.Upper(CPLib.Substr(riga,331,9)),"XXXXXXXXX")?CPLib.Substr(riga,424,30):CPLib.Substr(riga,331,9));
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' operazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" operazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(LRTrim(Substr(riga,9,1))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,9,1)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000F7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000F7(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Flag Contanti nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,10,4))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,10,4)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000FA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000FA(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Causale Analitica nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,14,2))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,14,2)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000000FD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000FD(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Causale Sintetica nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If not(Empty(LRTrim(Substr(riga,14,2)))) and At(LRTrim(Substr(riga,14,2)),'|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R') <> 0 */
        if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,14,2)))) && CPLib.ne(CPLib.At(CPLib.LRTrim(CPLib.Substr(riga,14,2)),"|1B|2B|3B|4B|5B|6B|3M|4M|5M|6M|1R|2R"),0)) {
          /* If Empty(LRTrim(Substr(riga,29,3))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,29,3)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000101")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000101(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Paese Intermediario Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,62,2))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,62,2)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000104")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000104(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Provincia Intermediario Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If not(Empty(LRTrim(Substr(riga,29,3)))) and LRTrim(Substr(riga,29,3))='086' */
          if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,29,3)))) && CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,29,3)),"086")) {
            /* If Empty(LRTrim(Substr(riga,64,10))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,64,10)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000108")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000108(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca CAB Intermediario Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
          } // End If
        } // End If
        /* If Empty(LRTrim(Substr(riga,156,3))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,156,3)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000010B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000010B(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Codice Valuta nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,159,1))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,159,1)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000010E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000010E(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Segno nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,160,15))) or Val(LRTrim(Substr(riga,160,15)))=0 */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,160,15))) || CPLib.eqr(CPLib.Val(CPLib.LRTrim(CPLib.Substr(riga,160,15))),0)) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000111")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000111(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Importo nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* _coddip := LRTrim(Substr(riga,257,6)) // codice della dipendenza letta */
        _coddip = CPLib.LRTrim(CPLib.Substr(riga,257,6));
        /* If not(Empty(_coddip)) */
        if ( ! (CPLib.Empty(_coddip))) {
          /* If not(mcanadip.HasKey(_coddip)) */
          if ( ! (mcanadip.HasKey(_coddip))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000116")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000116(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Dipendenza indicata con codice "+_coddip+" non presente in anagrafica dipendenze dell'informazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
        } // End If
        /* If Empty(LRTrim(Substr(riga,302,16))) and not(Empty(LRTrim(Substr(riga,511,70)))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,302,16))) &&  ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,511,70))))) {
          /* If Empty(LRTrim(Substr(riga,581,3))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,581,3)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000011A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000011A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Paese Residenza Soggetto Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If not(Empty(LRTrim(Substr(riga,581,3)))) and LRTrim(Substr(riga,581,3))='086' */
          if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,581,3)))) && CPLib.eqr(CPLib.LRTrim(CPLib.Substr(riga,581,3)),"086")) {
            /* If Empty(LRTrim(Substr(riga,620,2))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,620,2)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000011E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000011E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Provincia Residenza Soggetto Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,614,6))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,614,6)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000121")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000121(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca CAB Residenza Soggetto Controparte nell'operazione con codice "+_ucode+" Riferimento univoco "+_inform,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
          } // End If
        } // End If
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Fine controllo del file '+nomefileimport // Messaggio Import */
    gMsgImp = "Fine controllo del file "+nomefileimport;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_6() throws Exception {
    /* Legge il file di testo e porta i dati nella tabella */
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
    fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
    /* conta := 0 */
    conta = CPLib.Round(0,0);
    /* While not(FileLibMit.Eof(fhand)) */
    while ( ! (FileLibMit.Eof(fhand))) {
      /* riga := FileLibMit.ReadLine(fhand) */
      riga = FileLibMit.ReadLine(fhand);
      /* If not(Empty(LRTrim(riga))) */
      if ( ! (CPLib.Empty(CPLib.LRTrim(riga)))) {
        /* conta := conta + 1 */
        conta = CPLib.Round(conta+1,0);
        /* _ucode := LRTrim(Substr(riga,159,10)) */
        _ucode = CPLib.LRTrim(CPLib.Substr(riga,159,10));
        /* gMsgImp := 'Sono stati elaborate '+LRTrim(Str(conta,10,0))+' informazioni del file '+nomefileimport // Messaggio Import */
        gMsgImp = "Sono stati elaborate "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" informazioni del file "+nomefileimport;
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(LRTrim(Substr(riga,1,8))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,1,8)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000131")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000131(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Data Operazione dell'informazione con codice "+_ucode,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
        /* If Empty(LRTrim(Substr(riga,9,25))) */
        if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,9,25)))) {
          // * --- Insert into tmp_errimp from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_errimp");
          m_cPhName = m_Ctx.GetPhName("tmp_errimp");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000134")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000134(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("Manca Rapporto dell'informazione con codice "+_ucode,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
          /* _errori := _errori + 1 */
          _errori = CPLib.Round(_errori+1,0);
        } // End If
      } // End If
    } // End While
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Fine Controllo del file '+nomefileimport // Messaggio Import */
    gMsgImp = "Fine Controllo del file "+nomefileimport;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_7() throws Exception {
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* Inserisce priorità sui nomi file */
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* Case At('archpers.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        if (CPLib.ne(CPLib.At("archpers.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 1 */
          _priorita = CPLib.Round(1,0);
          /* Case At('persnew.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("persnew.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 2 */
          _priorita = CPLib.Round(2,0);
          /* Case At('archdip.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archdip.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 3 */
          _priorita = CPLib.Round(3,0);
          /* Case At('archinf.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archinf.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 4 */
          _priorita = CPLib.Round(4,0);
          /* Case At('archope.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archope.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 5 */
          _priorita = CPLib.Round(5,0);
          /* Case At('archfraz.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("archfraz.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 6 */
          _priorita = CPLib.Round(6,0);
          /* Case At('infage.txt',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        } else if (CPLib.ne(CPLib.At("infage.txt",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* _priorita := 7 */
          _priorita = CPLib.Round(7,0);
        } // End Case
        // * --- Write into tmp_list_imprich from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000143")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"priorita = "+CPLib.ToSQL(_priorita,"N",3,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_list_imprich",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_list_imprich.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_list_imprich.GetString("nomefile"))+"";
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
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_8() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
      fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If Len(LRTrim(riga)) > 0 */
        if (CPLib.gt(CPLib.Len(CPLib.LRTrim(riga)),0)) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(conta,10,0))+' nominativi del file '+nomefileimport // Messaggio Import */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" nominativi del file "+nomefileimport;
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* xConnes := Substr(riga,496,16) */
          xConnes = CPLib.Substr(riga,496,16);
          /* cSetSin := '' */
          cSetSin = "";
          /* Controlla i Valori */
          /* If Empty(LRTrim(Substr(riga,7,77))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,7,77)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000152")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000152(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca la ragione sociale del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,77,35))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,77,35)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000155")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000155(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca indirizzo del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,112,16))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,112,16)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000158")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000158(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Codice Fiscale del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,172,3))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,172,3)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000015B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000015B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Settore Sintetico del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,230,30))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,230,30)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000015E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000015E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Città Residenza del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,260,2))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,260,2)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000161")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000161(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca indirizzo del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,262,3))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,262,3)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000164")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000164(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca Paese Residenza del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Empty(LRTrim(Substr(riga,265,9))) */
          if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,265,9)))) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000167")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000167(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Manca CAP Residenza del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
          /* If Len(LRTrim(Substr(riga,112,16))) = 16 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(CPLib.Substr(riga,112,16))),16)) {
            /* If Empty(LRTrim(Substr(riga,128,8))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,128,8)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000016B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000016B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca la data di nascita del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,136,30))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,136,30)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000016E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000016E(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Comune/Stato di nascita del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,175,2))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,175,2)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000171")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000171(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Tipo Documento del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,177,15))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,177,15)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000174")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000174(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Numero Documento del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,192,8))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,192,8)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000177")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000177(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Data Rilascio Documento del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,200,30))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,200,30)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000017A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000017A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Autorità Rilascio Documento del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,288,1))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,288,1)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000017D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000017D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca indirizzo del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,297,26))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,297,26)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000180")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000180(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Cognome del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,331,25))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,331,25)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000183")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000183(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Nome del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
            /* If Empty(LRTrim(Substr(riga,456,2))) */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,456,2)))) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"00000186")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000186(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Provincia di Nascita del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
          } else { // Else
            /* _tipsot := '' // Richiesto Ateco */
            _tipsot = "";
            // * --- Read from tbstgru
            m_cServer = m_Ctx.GetServer("tbstgru");
            m_cPhName = m_Ctx.GetPhName("tbstgru");
            m_cSql = "";
            m_cSql = m_cSql+"SOTGRU="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,166,3),"C",3,0,m_cServer),m_cServer,CPLib.Substr(riga,166,3));
            if (m_Ctx.IsSharedTemp("tbstgru")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPOSOT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _tipsot = Read_Cursor.GetString("TIPOSOT");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbstgru into routine arrt_imp_dati_storico_exam returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _tipsot = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(Substr(riga,468,10))) and _tipsot='1' */
            if (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,468,10))) && CPLib.eqr(_tipsot,"1")) {
              // * --- Insert into tmp_errimp from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_errimp");
              m_cPhName = m_Ctx.GetPhName("tmp_errimp");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000018B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000018B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("Manca Attività Economica (ATECO) del soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
              /* _errori := _errori + 1 */
              _errori = CPLib.Round(_errori+1,0);
            } // End If
          } // End If
          /* cSetSin := arfn_calcolasett(Substr(riga,166,3),Substr(riga,169,3),Substr(riga,468,10)) */
          cSetSin = arfn_calcolasettR.Make(m_Ctx,this).Run(CPLib.Substr(riga,166,3),CPLib.Substr(riga,169,3),CPLib.Substr(riga,468,10));
          /* If not(Empty(LRTrim(Substr(riga,172,3)))) and Substr(riga,172,3) <> cSetSin */
          if ( ! (CPLib.Empty(CPLib.LRTrim(CPLib.Substr(riga,172,3)))) && CPLib.ne(CPLib.Substr(riga,172,3),cSetSin)) {
            // * --- Insert into tmp_errimp from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_errimp");
            m_cPhName = m_Ctx.GetPhName("tmp_errimp");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_errimp",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000018F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000018F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nomefileimport,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("Settore Sintetico non congruo per il soggetto con codice "+xConnes,"?",0,0,m_cServer, m_oParameters)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_errimp",true);
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
            /* _errori := _errori + 1 */
            _errori = CPLib.Round(_errori+1,0);
          } // End If
        } // End If
      } // End While
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgImp := 'Fine controllo del file '+nomefileimport // Messaggio Import */
      gMsgImp = "Fine controllo del file "+nomefileimport;
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_9() throws Exception {
    /* cpercorsozip Char(200) := LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+"/"+czipfile */
    String cpercorsozip;
    cpercorsozip = CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+czipfile;
    /* cdirectoryfile Char(200) := LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+"/" */
    String cdirectoryfile;
    cdirectoryfile = CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/";
    /* buffernomefile Char(100) */
    String buffernomefile;
    buffernomefile = CPLib.Space(100);
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file zip ' + czipfile + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file zip "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Inizio estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Inizio estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* cdirectoryfile := LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+"/" */
    cdirectoryfile = CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/";
    try {
          // Apro il file zip
          java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
    
          //Conto il numero di file all interno del file zip e creo un array di stringhe per memorizzare i nomi file
          conteggio=zf.size();
          lista=new String[conteggio];
          
          // Enumerate each entry
          i=0;
          for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
              // Get the entry name
              lista[i] = ((java.util.zip.ZipEntry)entries.nextElement()).getName();
              i++;
          }
         zf.close();
         } catch (java.io.IOException e) {
         }
    try {
          // Apro il file zip
          java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
    
          byte[] buffer = new byte[1024]; 
          java.util.Enumeration entries = zf.entries();
          while(entries.hasMoreElements() ) {
            java.util.zip.ZipEntry entry = (java.util.zip.ZipEntry)entries.nextElement();
            java.io.InputStream in =zf.getInputStream(entry);
            java.io.OutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(cdirectoryfile+entry.getName()));
    
            int len;
    
            while((len = in.read(buffer)) >= 0){
              out.write(buffer, 0, len);
            }
    
              in.close();
              out.close();
          }
    
          zf.close();
    } catch (java.io.IOException ioe) {
          System.err.println("Unhandled exception:");
          ioe.printStackTrace();
          return;
    }
    // * --- Delete from tmp_list_imprich
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_list_imprich");
    m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"0000019B")+"delete from "+m_oWrInfo.GetTableWriteName();
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(czipfile,"?",0,0,m_cServer),m_cServer,czipfile)+"";
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
    /* contanome := 0 */
    contanome = 0;
    /* _priorita := 0 */
    _priorita = CPLib.Round(0,0);
    /* While contanome<conteggio */
    while (CPLib.lt(contanome,conteggio)) {
      buffernomefile=lista[contanome];
      // * --- Insert into tmp_list_imprich from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_storico_exam",598,"000001A0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000001A0(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(buffernomefile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_list_imprich",true);
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
      /* contanome := contanome+1 */
      contanome = contanome+1;
    } // End While
    /* FileLibMit.DeleteFilePath(LRTrim(gPathDoc)+"/appo/"+LRTrim(gAzienda)+"/"+czipfile) */
    FileLibMit.DeleteFilePath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+czipfile);
    /* gMsgImp := 'Fine estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Fine estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file zip ' +czipfile + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file zip "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void Page_10() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* fhand := FileLibMit.OpenReadPath(LRTrim(gPathDoc)+'/appo/'+LRTrim(gAzienda)+'/'+nomefileimport) */
      fhand = FileLibMit.OpenReadPath(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+nomefileimport);
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      /* xCodCab Char(6) */
      String xCodCab;
      xCodCab = CPLib.Space(6);
      /* xCitta Char(30) */
      String xCitta;
      xCitta = CPLib.Space(30);
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If not(Empty(LRTrim(riga))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(riga)))) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* If not(mcanadip.GoToKey(Substr(riga,1,6))) */
          if ( ! (mcanadip.GoToKey(CPLib.Substr(riga,1,6)))) {
            /* mcanadip.AppendWithKey(Substr(riga,1,6)) // mc anadip */
            mcanadip.AppendWithKey(CPLib.Substr(riga,1,6));
          } // End If
          /* mcanadip.DESCRIZ := Substr(riga,7,30) // mc anadip */
          mcanadip.row.DESCRIZ = CPLib.Substr(riga,7,30);
          /* mcanadip.DESCCIT := Substr(riga,37,30) // mc anadip */
          mcanadip.row.DESCCIT = CPLib.Substr(riga,37,30);
          /* mcanadip.PROVINCIA := Substr(riga,67,2) // mc anadip */
          mcanadip.row.PROVINCIA = CPLib.Substr(riga,67,2);
          /* xCodCab := Substr(riga,69,6) */
          xCodCab = CPLib.Substr(riga,69,6);
          /* If Empty(LRTrim(xCodCab)) */
          if (CPLib.Empty(CPLib.LRTrim(xCodCab))) {
            /* xCitta := Substr(riga,37,30) */
            xCitta = CPLib.Substr(riga,37,30);
            // * --- Read from tbcitta
            m_cServer = m_Ctx.GetServer("tbcitta");
            m_cPhName = m_Ctx.GetPhName("tbcitta");
            m_cSql = "";
            m_cSql = m_cSql+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(xCitta,"C",60,0,m_cServer),m_cServer,xCitta);
            m_cSql = m_cSql+" and PROV="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Substr(riga,67,2),"C",2,0,m_cServer),m_cServer,CPLib.Substr(riga,67,2));
            if (m_Ctx.IsSharedTemp("tbcitta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xCodCab = Read_Cursor.GetString("CAB");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on tbcitta into routine arrt_imp_dati_storico_exam returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xCodCab = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
          } // End If
          /* mcanadip.CAB := xCodCab // mc anadip */
          mcanadip.row.CAB = xCodCab;
          /* mcanadip.AGENTE := iif(Upper(Substr(riga,85,1))='S','S','N') // mc anadip */
          mcanadip.row.AGENTE = (CPLib.eqr(CPLib.Upper(CPLib.Substr(riga,85,1)),"S")?"S":"N");
          /* mcanadip.IDBASE := LibreriaMit.UniqueId() // mc anadip */
          mcanadip.row.IDBASE = LibreriaMit.UniqueId();
          /* mcanadip.CAP := Substr(riga,86,5) // mc anadip */
          mcanadip.row.CAP = CPLib.Substr(riga,86,5);
          /* mcanadip.TIPOSV := Substr(riga,91,3) // mc anadip */
          mcanadip.row.TIPOSV = CPLib.Substr(riga,91,3);
          /* mcanadip.CODFISC := Substr(riga,94,16) // mc anadip */
          mcanadip.row.CODFISC = CPLib.Substr(riga,94,16);
          /* mcanadip.PARTIVA := Substr(riga,110,11) // mc anadip */
          mcanadip.row.PARTIVA = CPLib.Substr(riga,110,11);
          /* mcanadip.TIPOAGENTE := Substr(riga,121,2) // mc anadip */
          mcanadip.row.TIPOAGENTE = CPLib.Substr(riga,121,2);
        } // End If
      } // End While
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
    } finally {
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
  public String RunAsync(String p_w_tipodest,double p_w_impzip,double p_w_errchk) {
    w_tipodest = p_w_tipodest;
    w_impzip = p_w_impzip;
    w_errchk = p_w_errchk;
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
  public double Run(String p_w_tipodest,double p_w_impzip,double p_w_errchk) {
    w_tipodest = p_w_tipodest;
    w_impzip = p_w_impzip;
    w_errchk = p_w_errchk;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arrt_imp_dati_storico_examR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_storico_examR(p_Ctx, p_Caller);
  }
  public static arrt_imp_dati_storico_examR Make(CPContext p_Ctx) {
    return new arrt_imp_dati_storico_examR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_tipodest = CPLib.Space(1);
    w_impzip = 0;
    w_errchk = 0;
    fhand = CPLib.Space(1);
    riga = "";
    xConnes = CPLib.Space(16);
    _ucode = CPLib.Space(10);
    conta = 0;
    cSetSin = CPLib.Space(3);
    _errori = 0;
    mcanadip = new MemoryCursor_anadip();
    _tipsot = CPLib.Space(1);
    czipfile = CPLib.Space(100);
    nomefileimport = CPLib.Space(100);
    _priorita = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_calcolasett,arfn_fdatetime,arrt_imp_dati_storico_exam,
  public static final String i_InvokedRoutines = ",arfn_calcolasett,arfn_fdatetime,arrt_imp_dati_storico_exam,";
  public static String[] m_cRunParameterNames={"w_tipodest","w_impzip","w_errchk"};
  protected static String GetFieldsName_00000051(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000054(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000057(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000005D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000060(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000063(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000066(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000070(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000073(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000076(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000079(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000082(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000085(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000BD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000C7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000FD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000101(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000104(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000108(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000010B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000010E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000111(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000116(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000011A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000011E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000121(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000131(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000134(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000152(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000155(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000158(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000015B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000015E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000161(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000164(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000167(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000016B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000016E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000171(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000174(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000177(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000017A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000017D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000180(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000183(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000186(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000018B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000018F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomearch,";
    p_cSql = p_cSql+"numriga,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_errimp",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
}
