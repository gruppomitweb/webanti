// * --- Area Manuale = BO - Header
// * --- arrt_estrai_crs
import java.util.*;
// * --- Fine Area Manuale
public class arrt_estrai_crsR implements CallerWithObjs {
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
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
  public double w_annofisc;
  public double _max;
  public double _min;
  public double _tot;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public String _dataini;
  public String _datafin;
  public double _mono;
  public String _rapage;
  public String cOnlyNomeFile;
  public String cNomeFile;
  public String cNomeFileZip;
  public String fhand;
  public String _riga;
  public String _ucode;
  public String _file1;
  public String _file2;
  public double _nEse;
  public double _nCli;
  public double _annopaese;
  public String _idb;
  public MemoryCursor_tmp_persocse mcPersocse;
  public MemoryCursorRow_tmp_persocse rowPersocse;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  public String gPathDoc;
  public String gUrlApp;
  public String gIntemediario;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_estrai_crs
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_estrai_crsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_estrai_crs",m_Caller);
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("annofisc",p_cVarName)) {
      return w_annofisc;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_nEse",p_cVarName)) {
      return _nEse;
    }
    if (CPLib.eqr("_nCli",p_cVarName)) {
      return _nCli;
    }
    if (CPLib.eqr("_annopaese",p_cVarName)) {
      return _annopaese;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_estrai_crs";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("_dataini",p_cVarName)) {
      return _dataini;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      return _datafin;
    }
    if (CPLib.eqr("_rapage",p_cVarName)) {
      return _rapage;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      return _ucode;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      return _file1;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
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
    if (CPLib.eqr("mcPersocse",p_cVarName)) {
      return mcPersocse;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowPersocse",p_cVarName)) {
      return rowPersocse;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("annofisc",p_cVarName)) {
      w_annofisc = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_nEse",p_cVarName)) {
      _nEse = value;
      return;
    }
    if (CPLib.eqr("_nCli",p_cVarName)) {
      _nCli = value;
      return;
    }
    if (CPLib.eqr("_annopaese",p_cVarName)) {
      _annopaese = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_dataini",p_cVarName)) {
      _dataini = value;
      return;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      _datafin = value;
      return;
    }
    if (CPLib.eqr("_rapage",p_cVarName)) {
      _rapage = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      _ucode = value;
      return;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      _file1 = value;
      return;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      _file2 = value;
      return;
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    if (CPLib.eqr("rowPersocse",p_cVarName)) {
      rowPersocse = (MemoryCursorRow_tmp_persocse)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcPersocse",p_cVarName)) {
      mcPersocse = (MemoryCursor_tmp_persocse)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_personbo_crs=null;
    CPResultSet Cursor_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_annofisc Numeric(4, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _dataini Char(8) */
      /* _datafin Char(8) */
      /* _mono Numeric(1, 0) */
      /* _rapage Char(50) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* fhand Char(10) */
      /* _riga Memo */
      /* _ucode Char(10) */
      /* _file1 Char(30) */
      /* _file2 Char(30) */
      /* _nEse Numeric(10, 0) */
      /* _nCli Numeric(10, 0) */
      /* _annopaese Numeric(4, 0) */
      /* _idb Char(10) // IDBASE per export */
      /* mcPersocse MemoryCursor(tmp_persocse) */
      /* rowPersocse Row(tmp_persocse) */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gIntemediario Char(11) // Intermediario */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from qbe_personbo_crs
      SPBridge.HMCaller _h00000028;
      _h00000028 = new SPBridge.HMCaller();
      _h00000028.Set("m_cVQRList",m_cVQRList);
      _h00000028.Set("_annopaese",w_annofisc);
      if (Cursor_qbe_personbo_crs!=null)
        Cursor_qbe_personbo_crs.Close();
      Cursor_qbe_personbo_crs = new VQRHolder("qbe_personbo_crs",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000028,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_personbo_crs.Eof())) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_personbo_crs.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* mcPersocse.AppendBlank() */
          mcPersocse.AppendBlank();
          /* If Empty(LRTrim(personbo->IDBASE)) */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("IDBASE")))) {
            /* _idb := LibreriaMit.UniqueId() // IDBASE per export */
            _idb = LibreriaMit.UniqueId();
            /* mcPersocse.IDBASE := _idb */
            mcPersocse.row.IDBASE = _idb;
            // * --- Write into personbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_estrai_crs",72,"0000002E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(_idb,"C",10,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_personbo_crs.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_personbo_crs.GetString("CONNES"))+"";
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
            /* mcPersocse.IDBASE := personbo->IDBASE */
            mcPersocse.row.IDBASE = Cursor_personbo.GetString("IDBASE");
          } // End If
          /* mcPersocse.RAGSOC := personbo->RAGSOC */
          mcPersocse.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
          /* mcPersocse.DOMICILIO := personbo->DOMICILIO */
          mcPersocse.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
          /* mcPersocse.CODFISC := personbo->CODFISC */
          mcPersocse.row.CODFISC = Cursor_personbo.GetString("CODFISC");
          /* mcPersocse.DATANASC := personbo->DATANASC */
          mcPersocse.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
          /* mcPersocse.NASCOMUN := iif(personbo->TIPINTER='EE',personbo->NASSTATO,personbo->NASCOMUN) */
          mcPersocse.row.NASCOMUN = (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?Cursor_personbo.GetString("NASSTATO"):Cursor_personbo.GetString("NASCOMUN"));
          /* mcPersocse.TIPODOC := personbo->TIPODOC */
          mcPersocse.row.TIPODOC = Cursor_personbo.GetString("TIPODOC");
          /* mcPersocse.NUMDOCUM := personbo->NUMDOCUM */
          mcPersocse.row.NUMDOCUM = Cursor_personbo.GetString("NUMDOCUM");
          /* mcPersocse.DATARILASC := personbo->DATARILASC */
          mcPersocse.row.DATARILASC = Cursor_personbo.GetDate("DATARILASC");
          /* mcPersocse.AUTRILASC := personbo->AUTRILASC */
          mcPersocse.row.AUTRILASC = Cursor_personbo.GetString("AUTRILASC");
          /* mcPersocse.DESCCIT := personbo->DESCCIT */
          mcPersocse.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
          /* mcPersocse.PROVINCIA := personbo->PROVINCIA */
          mcPersocse.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
          /* mcPersocse.PAESE := personbo->PAESE */
          mcPersocse.row.PAESE = Cursor_personbo.GetString("PAESE");
          /* mcPersocse.CAP := personbo->CAP */
          mcPersocse.row.CAP = Cursor_personbo.GetString("CAP");
          /* mcPersocse.PARTIVA := personbo->PARTIVA */
          mcPersocse.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
          /* mcPersocse.SESSO := personbo->SESSO */
          mcPersocse.row.SESSO = Cursor_personbo.GetString("SESSO");
          /* mcPersocse.NOME := personbo->NOME */
          mcPersocse.row.NOME = Cursor_personbo.GetString("NOME");
          /* mcPersocse.COGNOME := personbo->COGNOME */
          mcPersocse.row.COGNOME = Cursor_personbo.GetString("COGNOME");
          /* mcPersocse.CFESTERO := personbo->CFESTERO */
          mcPersocse.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
          /* mcPersocse.OCSE := personbo->FATCA */
          mcPersocse.row.OCSE = Cursor_personbo.GetString("FATCA");
          /* mcPersocse.TIN := personbo->TIN */
          mcPersocse.row.TIN = Cursor_personbo.GetString("TIN");
          /* mcPersocse.CODCAB := personbo->CODCAB */
          mcPersocse.row.CODCAB = Cursor_personbo.GetString("CODCAB");
          /* mcPersocse.CONNES := personbo->IDBASE */
          mcPersocse.row.CONNES = Cursor_personbo.GetString("IDBASE");
          /* mcPersocse.RESFISC := personbo->RESFISC */
          mcPersocse.row.RESFISC = Cursor_personbo.GetString("RESFISC");
          /* mcPersocse.SaveRow() */
          mcPersocse.SaveRow();
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        Cursor_qbe_personbo_crs.Next();
      }
      m_cConnectivityError = Cursor_qbe_personbo_crs.ErrorMessage();
      Cursor_qbe_personbo_crs.Close();
      // * --- End Select
      /* Exec "Crea i file di testo" Page 3:Page_3 */
      Page_3();
      /* Return "mitcrs.zip" */
      throw new Stop("mitcrs.zip");
    } finally {
      try {
        if (Cursor_qbe_personbo_crs!=null)
          Cursor_qbe_personbo_crs.Close();
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
  void Page_2() throws Exception {
    // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.size(); i++) {
                _file1=(String)filenames.elementAt(i);
                _file2=(String)fileonames.elementAt(i);
                java.io.FileInputStream in = new java.io.FileInputStream(_file1);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(_file2));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
                FileLibMit.DeleteFile(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(_file2));
            }
        
            // Complete the ZIP file
            out.close();
            filenames.removeAllElements();
            fileonames.removeAllElements();
        } catch (java.io.IOException e) {
        }
    
  }
  void Page_3() throws Exception {
    /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/mitcrs.zip" */
    cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/mitcrs.zip";
    /* gMsgProc := gMsgProc + 'Scrittura File persocse.txt'+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Scrittura File persocse.txt"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _riga := '' */
    _riga = "";
    /* cOnlyNomeFile := "persocse.txt" */
    cOnlyNomeFile = "persocse.txt";
    /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/persocse.txt" */
    cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/persocse.txt";
    // These are the files to include in the ZIP file
    filenames.add(cNomeFile);
    fileonames.add(cOnlyNomeFile);
    /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile)) */
    fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile));
    for (MemoryCursorRow_tmp_persocse rowPersocse : mcPersocse._iterable_()) {
      /* _riga := LibreriaMit.SpacePad(rowPersocse.IDBASE,10) */
      _riga = LibreriaMit.SpacePad(rowPersocse.IDBASE,10);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.RAGSOC,70) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.RAGSOC,70);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.DOMICILIO,35) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.DOMICILIO,35);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.CODFISC,16) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.CODFISC,16);
      /* _riga := _riga + arfn_fdate(rowPersocse.DATANASC) */
      _riga = _riga+arfn_fdateR.Make(m_Ctx,this).Run(rowPersocse.DATANASC);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.NASCOMUN,30) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.NASCOMUN,30);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.TIPODOC,2) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.TIPODOC,2);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.NUMDOCUM,15) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.NUMDOCUM,15);
      /* _riga := _riga + arfn_fdate(rowPersocse.DATARILASC) */
      _riga = _riga+arfn_fdateR.Make(m_Ctx,this).Run(rowPersocse.DATARILASC);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.AUTRILASC,30) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.AUTRILASC,30);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.DESCCIT,30) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.DESCCIT,30);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.PROVINCIA,2) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.PROVINCIA,2);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.PAESE,3) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.PAESE,3);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.CAP,9) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.CAP,9);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.PARTIVA,14) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.PARTIVA,14);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.SESSO,1) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.SESSO,1);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.NOME,25) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.NOME,25);
      /* _riga := _riga + LibreriaMit.SpacePad(Str(rowPersocse.CFESTERO,1,0),1) */
      _riga = _riga+LibreriaMit.SpacePad(CPLib.Str(rowPersocse.CFESTERO,1,0),1);
      /* _riga := _riga + Space(4) */
      _riga = _riga+CPLib.Space(4);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.OCSE,3) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.OCSE,3);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.TIN,16) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.TIN,16);
      /* _riga := _riga + Space(13) */
      _riga = _riga+CPLib.Space(13);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.CODCAB,6) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.CODCAB,6);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.IDBASE,16) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.IDBASE,16);
      /* _riga := _riga + Space(18) */
      _riga = _riga+CPLib.Space(18);
      /* _riga := _riga + LibreriaMit.SpacePad(rowPersocse.RESFISC,3) */
      _riga = _riga+LibreriaMit.SpacePad(rowPersocse.RESFISC,3);
      /* _riga := _riga + Space(281) */
      _riga = _riga+CPLib.Space(281);
      /* FileLibMit.Write(fhand,Left(_riga+Space(669),669)+NL) */
      FileLibMit.Write(fhand,CPLib.Left(_riga+CPLib.Space(669),669)+"\n");
    }
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* Exec "Crea il file zip" Page 2:Page_2 */
    Page_2();
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Estrazione terminata!' // Messaggio Import */
    gMsgImp = "Estrazione terminata!";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_4() throws Exception {
    /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/mitfisc.zip" */
    cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/mitfisc.zip";
    /* gMsgProc := gMsgProc + 'Scrittura File archope.txt'+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Scrittura File archope.txt"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _riga := '' */
    _riga = "";
    /* gMsgProc := gMsgProc + 'Scrittura File archpers.txt'+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Scrittura File archpers.txt"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _riga := '' */
    _riga = "";
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Estrazione terminata!' // Messaggio Import */
    gMsgImp = "Estrazione terminata!";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void _init_() {
  }
  public String RunAsync(double p_w_annofisc) {
    w_annofisc = p_w_annofisc;
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
  public String Run(double p_w_annofisc) {
    w_annofisc = p_w_annofisc;
    return Run();
  }
  public String Run() {
    String l_result;
    l_result = "";
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
        l_result = stop_value.GetString();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = "";
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
  public static arrt_estrai_crsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_estrai_crsR(p_Ctx, p_Caller);
  }
  public static arrt_estrai_crsR Make(CPContext p_Ctx) {
    return new arrt_estrai_crsR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_annofisc = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _dataini = CPLib.Space(8);
    _datafin = CPLib.Space(8);
    _mono = 0;
    _rapage = CPLib.Space(50);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    fhand = CPLib.Space(10);
    _riga = "";
    _ucode = CPLib.Space(10);
    _file1 = CPLib.Space(30);
    _file2 = CPLib.Space(30);
    _nEse = 0;
    _nCli = 0;
    _annopaese = 0;
    _idb = CPLib.Space(10);
    mcPersocse = new MemoryCursor_tmp_persocse();
    rowPersocse = new MemoryCursorRow_tmp_persocse();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_personbo_crs,
  public static final String m_cVQRList = ",qbe_personbo_crs,";
  // ENTITY_BATCHES: ,arfn_fdate,arfn_fdatetime,arrt_estrai_crs,
  public static final String i_InvokedRoutines = ",arfn_fdate,arfn_fdatetime,arrt_estrai_crs,";
  public static String[] m_cRunParameterNames={"w_annofisc"};
}
