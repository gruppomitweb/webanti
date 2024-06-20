// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_oam_invioR implements CallerWithObjs {
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
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_oam_files;
  public String m_cServer_oam_files;
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
  public java.sql.Date w_dadata;
  public java.sql.Date w_a_data;
  public double w_anno;
  public String w_mese;
  public double w_tipofile;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String gUrlApp;
  public String gMsgImp;
  public String gMsgProc;
  public MemoryCursor_mccorpo_oam_mcrdef mcCorpo;
  public MemoryCursorRow_mccorpo_oam_mcrdef rwCorpo;
  public double _conta;
  public String _numsto;
  public String _paeseres;
  public String fhand;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String _riga;
  public String cProg;
  public double _oamdoc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_oam_invioR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_oam_invio",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_oam_files = p_ContextObject.GetPhName("oam_files");
    if (m_cPhName_oam_files.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_oam_files = m_cPhName_oam_files+" "+m_Ctx.GetWritePhName("oam_files");
    }
    m_cServer_oam_files = p_ContextObject.GetServer("oam_files");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      return w_tipofile;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_oamdoc",p_cVarName)) {
      return _oamdoc;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_oam_invio";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      return _numsto;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      return _paeseres;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
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
    if (CPLib.eqr("mcCorpo",p_cVarName)) {
      return mcCorpo;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rwCorpo",p_cVarName)) {
      return rwCorpo;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("tipofile",p_cVarName)) {
      w_tipofile = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_oamdoc",p_cVarName)) {
      _oamdoc = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_numsto",p_cVarName)) {
      _numsto = value;
      return;
    }
    if (CPLib.eqr("_paeseres",p_cVarName)) {
      _paeseres = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rwCorpo",p_cVarName)) {
      rwCorpo = (MemoryCursorRow_mccorpo_oam_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcCorpo",p_cVarName)) {
      mcCorpo = (MemoryCursor_mccorpo_oam_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_oam_operazbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_dadata Date */
      /* w_a_data Date */
      /* w_anno Numeric(4, 0) */
      /* w_mese Char(2) */
      /* w_tipofile Numeric(1, 0) // Tipo Invio */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* mcCorpo MemoryCursor(mcCorpo_OAM.MCRDef) */
      /* rwCorpo Row(mcCorpo_OAM.MCRDef) */
      /* _conta Numeric(10, 0) */
      /* _numsto Char(15) */
      /* _paeseres Char(40) */
      /* fhand Char(10) */
      /* cNomeFile Char(30) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* _riga Memo */
      /* cProg Char(10) */
      /* _oamdoc Numeric(1, 0) */
      /* gMsgProc := 'Ora inizio creazione file: '+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = "Ora inizio creazione file: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _oamdoc := intermbo->OAMTPDOC */
        _oamdoc = CPLib.Round(Cursor_intermbo.GetDouble("OAMTPDOC"),0);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_oam_operazbo
      SPBridge.HMCaller _h00000020;
      _h00000020 = new SPBridge.HMCaller();
      _h00000020.Set("m_cVQRList",m_cVQRList);
      _h00000020.Set("dadata",w_dadata);
      _h00000020.Set("a_data",w_a_data);
      if (Cursor_qbe_oam_operazbo!=null)
        Cursor_qbe_oam_operazbo.Close();
      Cursor_qbe_oam_operazbo = new VQRHolder("qbe_oam_operazbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000020,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_oam_operazbo.Eof())) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* rwCorpo.B01 := 'B' */
        rwCorpo.B01 = "B";
        /* rwCorpo.B02 := _conta */
        rwCorpo.B02 = _conta;
        /* gMsgImp := "Sto elaborando la transazione con codice: " + qbe_oam_operazbo->TIPO + "-" + qbe_oam_operazbo->NUMPROG */
        gMsgImp = "Sto elaborando la transazione con codice: "+Cursor_qbe_oam_operazbo.GetString("TIPO")+"-"+Cursor_qbe_oam_operazbo.GetString("NUMPROG");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_oam_operazbo.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* rwCorpo.B03 := personbo->COGNOME */
          rwCorpo.B03 = Cursor_personbo.GetString("COGNOME");
          /* rwCorpo.B04 := personbo->NOME */
          rwCorpo.B04 = Cursor_personbo.GetString("NOME");
          /* rwCorpo.B05 := iif(personbo->SESSO='1','M',iif(personbo->SESSO='2','F',' ')) */
          rwCorpo.B05 = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"M":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":" "));
          /* rwCorpo.B06 := iif(personbo->CFESTERO=1,Space(16),personbo->CODFISC) */
          rwCorpo.B06 = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?CPLib.Space(16):Cursor_personbo.GetString("CODFISC"));
          /* rwCorpo.B07 := personbo->DATANASC */
          rwCorpo.B07 = Cursor_personbo.GetDate("DATANASC");
          /* rwCorpo.B08 := iif(personbo->TIPINTER='EE',personbo->NASSTATO,personbo->NASCOMUN) */
          rwCorpo.B08 = (CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?Cursor_personbo.GetString("NASSTATO"):Cursor_personbo.GetString("NASCOMUN"));
          /* rwCorpo.B09 := personbo->TIPINTER */
          rwCorpo.B09 = Cursor_personbo.GetString("TIPINTER");
          /* _paeseres := '' */
          _paeseres = "";
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
            _paeseres = Read_Cursor.GetString("DESCRI");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arrt_oam_invio returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _paeseres = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* rwCorpo.B10 := iif(Empty(LRTrim(personbo->PAESE)),'ITALIA',_paeseres) */
          rwCorpo.B10 = (CPLib.Empty(CPLib.LRTrim(Cursor_personbo.GetString("PAESE")))?"ITALIA":_paeseres);
          /* rwCorpo.B11 := personbo->PAESE */
          rwCorpo.B11 = Cursor_personbo.GetString("PAESE");
          /* If _oamdoc = 1 */
          if (CPLib.eqr(_oamdoc,1)) {
            /* If personbo->CFESTERO=1 */
            if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
              /* rwCorpo.B12 := iif(personbo->TIPODOC='03','03','06') */
              rwCorpo.B12 = (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"03")?"03":"06");
              /* rwCorpo.B15 := "AUTORITA' ESTERA" */
              rwCorpo.B15 = "AUTORITA' ESTERA";
            } else { // Else
              /* rwCorpo.B12 := personbo->TIPODOC */
              rwCorpo.B12 = Cursor_personbo.GetString("TIPODOC");
              /* If not(Empty(personbo->PAESE)) and personbo->PAESE<>'086' */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("PAESE"))) && CPLib.ne(Cursor_personbo.GetString("PAESE"),"086")) {
                /* rwCorpo.B15 := "AUTORITA' ESTERA" */
                rwCorpo.B15 = "AUTORITA' ESTERA";
              } else { // Else
                /* Case personbo->TIPODOC='01' */
                if (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"01")) {
                  /* rwCorpo.B15 := "COMUNE" */
                  rwCorpo.B15 = "COMUNE";
                  /* Case personbo->TIPODOC='02' */
                } else if (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"02")) {
                  /* rwCorpo.B15 := "MOTORIZZAZIONE" */
                  rwCorpo.B15 = "MOTORIZZAZIONE";
                  /* Case personbo->TIPODOC='03' or personbo->TIPODOC='04' */
                } else if (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"03") || CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"04")) {
                  /* rwCorpo.B15 := "QUESTURA" */
                  rwCorpo.B15 = "QUESTURA";
                  /* Case personbo->TIPODOC='05' */
                } else if (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"05")) {
                  /* rwCorpo.B15 := "POSTE ITALIANE" */
                  rwCorpo.B15 = "POSTE ITALIANE";
                } else { // Otherwise
                  /* rwCorpo.B15 := "ALTRO" */
                  rwCorpo.B15 = "ALTRO";
                } // End Case
              } // End If
            } // End If
          } else { // Else
            /* rwCorpo.B12 := personbo->TIPODOC */
            rwCorpo.B12 = Cursor_personbo.GetString("TIPODOC");
            /* If not(Empty(personbo->PAESE)) and personbo->PAESE<>'086' and personbo->CFESTERO=1 */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("PAESE"))) && CPLib.ne(Cursor_personbo.GetString("PAESE"),"086") && CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
              /* rwCorpo.B15 := "AUTORITA' ESTERA" */
              rwCorpo.B15 = "AUTORITA' ESTERA";
            } else { // Else
              /* Case personbo->TIPODOC='01' */
              if (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"01")) {
                /* rwCorpo.B15 := "COMUNE" */
                rwCorpo.B15 = "COMUNE";
                /* Case personbo->TIPODOC='02' */
              } else if (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"02")) {
                /* rwCorpo.B15 := "MOTORIZZAZIONE" */
                rwCorpo.B15 = "MOTORIZZAZIONE";
                /* Case personbo->TIPODOC='03' or personbo->TIPODOC='04' */
              } else if (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"03") || CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"04")) {
                /* rwCorpo.B15 := "QUESTURA" */
                rwCorpo.B15 = "QUESTURA";
                /* Case personbo->TIPODOC='05' */
              } else if (CPLib.eqr(Cursor_personbo.GetString("TIPODOC"),"05")) {
                /* rwCorpo.B15 := "POSTE ITALIANE" */
                rwCorpo.B15 = "POSTE ITALIANE";
              } else { // Otherwise
                /* rwCorpo.B15 := "ALTRO" */
                rwCorpo.B15 = "ALTRO";
              } // End Case
            } // End If
          } // End If
          /* rwCorpo.B13 := personbo->NUMDOCUM */
          rwCorpo.B13 = Cursor_personbo.GetString("NUMDOCUM");
          /* rwCorpo.B14 := personbo->DATAVALI */
          rwCorpo.B14 = Cursor_personbo.GetDate("DATAVALI");
          /* rwCorpo.B16 := personbo->AUTRILASC */
          rwCorpo.B16 = Cursor_personbo.GetString("AUTRILASC");
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        /* rwCorpo.B17 := qbe_oam_operazbo->DATAOPE */
        rwCorpo.B17 = Cursor_qbe_oam_operazbo.GetDate("DATAOPE");
        /* If Empty(LRTrim(qbe_oam_operazbo->CODDIPE)) */
        if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oam_operazbo.GetString("CODDIPE")))) {
          // * --- Select from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          if (Cursor_intermbo!=null)
            Cursor_intermbo.Close();
          Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CAP,DESCCIT  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intermbo.Eof())) {
            /* rwCorpo.B18 := LRTrim(intermbo->CAP)+LRTrim(intermbo->DESCCIT) */
            rwCorpo.B18 = CPLib.LRTrim(Cursor_intermbo.GetString("CAP"))+CPLib.LRTrim(Cursor_intermbo.GetString("DESCCIT"));
            Cursor_intermbo.Next();
          }
          m_cConnectivityError = Cursor_intermbo.ErrorMessage();
          Cursor_intermbo.Close();
          // * --- End Select
        } else { // Else
          /* rwCorpo.B18 := LRTrim(qbe_oam_operazbo->CAP)+LRTrim(qbe_oam_operazbo->DESCCIT) */
          rwCorpo.B18 = CPLib.LRTrim(Cursor_qbe_oam_operazbo.GetString("CAP"))+CPLib.LRTrim(Cursor_qbe_oam_operazbo.GetString("DESCCIT"));
        } // End If
        /* rwCorpo.B19 := iif(LRTrim(qbe_oam_operazbo->CODANA)='DB','1','0') */
        rwCorpo.B19 = (CPLib.eqr(CPLib.LRTrim(Cursor_qbe_oam_operazbo.GetString("CODANA")),"DB")?"1":"0");
        /* rwCorpo.B20 := qbe_oam_operazbo->VALUTA */
        rwCorpo.B20 = Cursor_qbe_oam_operazbo.GetString("VALUTA");
        /* rwCorpo.B21 := qbe_oam_operazbo->CAMBIO * 10000 */
        rwCorpo.B21 = Cursor_qbe_oam_operazbo.GetDouble("CAMBIO")*10000;
        /* rwCorpo.B22 := qbe_oam_operazbo->IMPIN * 100 */
        rwCorpo.B22 = Cursor_qbe_oam_operazbo.GetDouble("IMPIN")*100;
        /* rwCorpo.B23 := qbe_oam_operazbo->IMPOUT * 100 */
        rwCorpo.B23 = Cursor_qbe_oam_operazbo.GetDouble("IMPOUT")*100;
        /* rwCorpo.B24 := qbe_oam_operazbo->IDBASE2 */
        rwCorpo.B24 = Cursor_qbe_oam_operazbo.GetString("IDBASE2");
        /* mcCorpo.AppendRow(rwCorpo) */
        mcCorpo.AppendRow(rwCorpo);
        /* mcCorpo.SaveRow() */
        mcCorpo.SaveRow();
        Cursor_qbe_oam_operazbo.Next();
      }
      m_cConnectivityError = Cursor_qbe_oam_operazbo.ErrorMessage();
      Cursor_qbe_oam_operazbo.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono state lette '+LRTrim(Str(_conta,10,0)) + " transazioni" + NL // Messaggio */
      gMsgProc = gMsgProc+"Sono state lette "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" transazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* cOnlyNomeFile := 'OAM'+Str(w_anno,4,0)+w_mese+Str(w_tipofile,1,0)+".txt" */
      cOnlyNomeFile = "OAM"+CPLib.Str(w_anno,4,0)+w_mese+CPLib.Str(w_tipofile,1,0)+".txt";
      /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile) */
      cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile);
      /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile)+".zip" */
      cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile)+".zip";
      /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile)) */
      fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile));
      /* _riga := 'A' */
      _riga = "A";
      /* _riga := _riga + 'OPMEN' */
      _riga = _riga+"OPMEN";
      /* _riga := _riga + Str(w_anno,4,0) */
      _riga = _riga+CPLib.Str(w_anno,4,0);
      /* _riga := _riga + w_mese */
      _riga = _riga+w_mese;
      /* _riga := _riga + Str(w_tipofile,1,0) */
      _riga = _riga+CPLib.Str(w_tipofile,1,0);
      /* _riga := _riga + Space(70) */
      _riga = _riga+CPLib.Space(70);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _riga := _riga +  LibreriaMit.SpacePad(intermbo->CODFISC,16) */
        _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("CODFISC"),16);
        /* If Len(LRTrim(intermbo->CODFISC)) = 16 and not(Empty(LRTrim(intermbo->COGNOME))) */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16) &&  ! (CPLib.Empty(CPLib.LRTrim(Cursor_intermbo.GetString("COGNOME"))))) {
          /* _riga := _riga + LibreriaMit.SpacePad(intermbo->COGNOME,30) */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("COGNOME"),30);
          /* _riga := _riga + LibreriaMit.SpacePad(intermbo->NOME,30) */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NOME"),30);
          /* _riga := _riga + arfn_fdate_nd(intermbo->DNASC,'S') */
          _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_intermbo.GetDate("DNASC"),"S");
          /* _riga := _riga + LibreriaMit.SpacePad(iif(intermbo->PROVNA='EE',intermbo->NASSTATO,intermbo->NASCOMUN),40) */
          _riga = _riga+LibreriaMit.SpacePad((CPLib.eqr(Cursor_intermbo.GetString("PROVNA"),"EE")?Cursor_intermbo.GetString("NASSTATO"):Cursor_intermbo.GetString("NASCOMUN")),40);
          /* _riga := _riga + LibreriaMit.SpacePad(intermbo->PROVNA,2) */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVNA"),2);
          /* _riga := _riga + LibreriaMit.SpacePad(intermbo->CITTADINA,2) */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("CITTADINA"),2);
          /* _riga := _riga + LibreriaMit.SpacePad(intermbo->DESCCIT,40) */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("DESCCIT"),40);
          /* _riga := _riga + LibreriaMit.SpacePad(intermbo->PROVINCIA,2) */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
          /* _riga := _riga + Space(154) */
          _riga = _riga+CPLib.Space(154);
        } else { // Else
          /* _riga := _riga + Space(155) */
          _riga = _riga+CPLib.Space(155);
          /* _riga := _riga + LibreriaMit.SpacePad(intermbo->RAGSOC,70) */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("RAGSOC"),70);
          /* If intermbo->SOGCOM='1' */
          if (CPLib.eqr(Cursor_intermbo.GetString("SOGCOM"),"1")) {
            /* _riga := _riga + Space(40) */
            _riga = _riga+CPLib.Space(40);
            /* _riga := _riga + Space(2) */
            _riga = _riga+CPLib.Space(2);
            /* _riga := _riga + LibreriaMit.SpacePad(intermbo->DESCCIT,40) */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("DESCCIT"),40);
            /* _riga := _riga + LibreriaMit.SpacePad(intermbo->PROVINCIA,2) */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
          } else { // Else
            /* _riga := _riga + LibreriaMit.SpacePad(intermbo->DESCCIT,40) */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("DESCCIT"),40);
            /* _riga := _riga + LibreriaMit.SpacePad(intermbo->PROVINCIA,2) */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
            /* _riga := _riga + Space(40) */
            _riga = _riga+CPLib.Space(40);
            /* _riga := _riga + Space(2) */
            _riga = _riga+CPLib.Space(2);
          } // End If
        } // End If
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _riga := _riga + '1' */
      _riga = _riga+"1";
      /* _riga := _riga + Space(38) */
      _riga = _riga+CPLib.Space(38);
      /* _riga := _riga + 'A' */
      _riga = _riga+"A";
      /* _riga := _riga + NL */
      _riga = _riga+"\n";
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      for (MemoryCursorRow_mccorpo_oam_mcrdef rwCorpo : mcCorpo._iterable_()) {
        /* _conta := _conta + 1 */
        _conta = CPLib.Round(_conta+1,0);
        /* _riga := LibreriaMit.SpacePad(rwCorpo.B01,1) */
        _riga = LibreriaMit.SpacePad(rwCorpo.B01,1);
        /* _riga := _riga + Right('0000000000'+LRTrim(Str(rwCorpo.B02,10,0)),10) */
        _riga = _riga+CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(rwCorpo.B02,10,0)),10);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B03,30) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B03,30);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B04,30) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B04,30);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B05,1) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B05,1);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B06,16) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B06,16);
        /* _riga := _riga +arfn_fdate_nd(rwCorpo.B07,'S') */
        _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rwCorpo.B07,"S");
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B08,40) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B08,40);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B09,2) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B09,2);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B10,40) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B10,40);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B11,3) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B11,3);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B12,2) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B12,2);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B13,20) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B13,20);
        /* _riga := _riga +arfn_fdate_nd(rwCorpo.B14,'S') */
        _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rwCorpo.B14,"S");
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B15,40) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B15,40);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B16,40) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B16,40);
        /* _riga := _riga +arfn_fdate_nd(rwCorpo.B17,'S') */
        _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rwCorpo.B17,"S");
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B18,40) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B18,40);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B19,1) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B19,1);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B20,3) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B20,3);
        /* _riga := _riga + Right('00000000000000'+LRTrim(Str(rwCorpo.B21,14,0)),14) */
        _riga = _riga+CPLib.Right("00000000000000"+CPLib.LRTrim(CPLib.Str(rwCorpo.B21,14,0)),14);
        /* _riga := _riga + Right('00000000000000'+LRTrim(Str(rwCorpo.B22,14,0)),14) */
        _riga = _riga+CPLib.Right("00000000000000"+CPLib.LRTrim(CPLib.Str(rwCorpo.B22,14,0)),14);
        /* _riga := _riga + Right('00000000000000'+LRTrim(Str(rwCorpo.B23,14,0)),14) */
        _riga = _riga+CPLib.Right("00000000000000"+CPLib.LRTrim(CPLib.Str(rwCorpo.B23,14,0)),14);
        /* _riga := _riga + LibreriaMit.SpacePad(rwCorpo.B24,10) */
        _riga = _riga+LibreriaMit.SpacePad(rwCorpo.B24,10);
        /* _riga := _riga + Space(52) */
        _riga = _riga+CPLib.Space(52);
        /* _riga := _riga + '*' */
        _riga = _riga+"*";
        /* _riga := _riga + NL */
        _riga = _riga+"\n";
        /* FileLibMit.Write(fhand,_riga) */
        FileLibMit.Write(fhand,_riga);
      }
      /* _riga := 'Z' */
      _riga = "Z";
      /* _riga := _riga + Space(200) */
      _riga = _riga+CPLib.Space(200);
      /* _riga := _riga + Right('00000000000'+LRTrim(Str(_conta,11,0)),11) */
      _riga = _riga+CPLib.Right("00000000000"+CPLib.LRTrim(CPLib.Str(_conta,11,0)),11);
      /* _riga := _riga + Space(235) */
      _riga = _riga+CPLib.Space(235);
      /* _riga := _riga + 'Z' */
      _riga = _riga+"Z";
      /* _riga := _riga + NL */
      _riga = _riga+"\n";
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + 'Sono state scritte '+LRTrim(Str(_conta,10,0)) +" transazioni" + NL // Messaggio */
      gMsgProc = gMsgProc+"Sono state scritte "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" transazioni"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Exec "Crea il file zip" Page 2:Page_2 */
      Page_2();
      /* cProg := Utilities.GetAutonumber("OAMFILES\'"+LRTrim(gAzienda)+"'",'',10) */
      cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("OAMFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
      // * --- Insert into oam_files from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("oam_files");
      m_cPhName = m_Ctx.GetPhName("oam_files");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"oam_files",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_oam_invio",38,"000000AC")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000AC(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(cOnlyNomeFile)+".zip","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Movimenti OAM - Anno:"+CPLib.Str(w_anno,4,0)+" - Mese: "+w_mese,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(cOnlyNomeFile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(cNomeFileZip,"?",0,0,m_cServer, m_oParameters)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"oam_files",true);
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
      /* gMsgImp := "Elaborazione completata. Prelevere il file premendo il tasto di download" */
      gMsgImp = "Elaborazione completata. Prelevere il file premendo il tasto di download";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora termine creazione file: '+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = gMsgProc+"Ora termine creazione file: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return cProg */
      throw new Stop(cProg);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_oam_operazbo!=null)
          Cursor_qbe_oam_operazbo.Close();
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    // Qui vengono scritti i file da inserire nello zip
        String[] filenames = new String[]{cNomeFile};
        
        // Crea un buffer per la lettura dei file
        byte[] buf = new byte[1024];
        
        try {
            // Creail file ZIP
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Comprime i file
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Apre il file da aggiungere allo ZIP
                out.putNextEntry(new java.util.zip.ZipEntry(cOnlyNomeFile));
        
                // Trasferisce i dati da i file allo ZIP
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Chiude il file
                out.closeEntry();
                in.close();
            }
        
            // Chiude il file ZIP
            out.close();
        } catch (java.io.IOException e) {
        }
    
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_dadata,java.sql.Date p_w_a_data,double p_w_anno,String p_w_mese,double p_w_tipofile) {
    w_dadata = p_w_dadata;
    w_a_data = p_w_a_data;
    w_anno = p_w_anno;
    w_mese = p_w_mese;
    w_tipofile = p_w_tipofile;
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
  public String Run(java.sql.Date p_w_dadata,java.sql.Date p_w_a_data,double p_w_anno,String p_w_mese,double p_w_tipofile) {
    w_dadata = p_w_dadata;
    w_a_data = p_w_a_data;
    w_anno = p_w_anno;
    w_mese = p_w_mese;
    w_tipofile = p_w_tipofile;
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
  public static arrt_oam_invioR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_oam_invioR(p_Ctx, p_Caller);
  }
  public static arrt_oam_invioR Make(CPContext p_Ctx) {
    return new arrt_oam_invioR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_dadata = CPLib.NullDate();
    w_a_data = CPLib.NullDate();
    w_anno = 0;
    w_mese = CPLib.Space(2);
    w_tipofile = 0;
    mcCorpo = new MemoryCursor_mccorpo_oam_mcrdef();
    rwCorpo = new MemoryCursorRow_mccorpo_oam_mcrdef();
    _conta = 0;
    _numsto = CPLib.Space(15);
    _paeseres = CPLib.Space(40);
    fhand = CPLib.Space(10);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    _riga = "";
    cProg = CPLib.Space(10);
    _oamdoc = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_oam_operazbo,
  public static final String m_cVQRList = ",qbe_oam_operazbo,";
  // ENTITY_BATCHES: ,arfn_fdate_nd,arfn_fdatetime,arrt_oam_invio,
  public static final String i_InvokedRoutines = ",arfn_fdate_nd,arfn_fdatetime,arrt_oam_invio,";
  public static String[] m_cRunParameterNames={"w_dadata","w_a_data","w_anno","w_mese","w_tipofile"};
  protected static String GetFieldsName_000000AC(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    p_cSql = p_cSql+"filename,";
    p_cSql = p_cSql+"filepath,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"oam_files",true);
    return p_cSql;
  }
}
