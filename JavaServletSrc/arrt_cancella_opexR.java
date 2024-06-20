// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cancella_opexR implements CallerWithObjs {
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
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopstor;
  public String m_cServer_aeopstor;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
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
  public java.sql.Date w_datarett;
  public String w_nomefile;
  public double w_anno;
  public String gAzienda;
  public String gPathApp;
  public String gUrlApp;
  public String gMsgProc;
  public String gMsgImp;
  public String fhand;
  public double _conta;
  public String _riga;
  public String _coint;
  public String _tipage;
  public String _rifana;
  public String cProg;
  public String cCanc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cancella_opexR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cancella_opex",m_Caller);
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
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeopstor = p_ContextObject.GetPhName("aeopstor");
    if (m_cPhName_aeopstor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopstor = m_cPhName_aeopstor+" "+m_Ctx.GetWritePhName("aeopstor");
    }
    m_cServer_aeopstor = p_ContextObject.GetServer("aeopstor");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
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
      return "arrt_cancella_opex";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
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
    if (CPLib.eqr("cCanc",p_cVarName)) {
      return cCanc;
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
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
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
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
    if (CPLib.eqr("cCanc",p_cVarName)) {
      cCanc = value;
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
    CPResultSet Cursor_qbe_cancella_opex=null;
    CPResultSet Cursor_aeoprig=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_datarett Date */
      /* w_nomefile Char(100) */
      /* w_anno Numeric(4, 0) */
      /* Definizione variabili locali */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gMsgProc Memo // Log Messaggi */
      /* gMsgImp Char(120) // Messaggio Import */
      /* fhand Char(1) // Handle File */
      /* _conta Numeric(10, 0) */
      /* _riga Memo */
      /* _coint Char(1) */
      /* _tipage Char(2) */
      /* _rifana Char(1) */
      /* cProg Char(10) */
      /* cCanc Char(10) */
      /* Verifica se deve modificare qualcosa */
      /* If not(Empty(w_datarett)) */
      if ( ! (CPLib.Empty(w_datarett))) {
        /* gMsgProc := 'Inizio Elaborazione File Cancellazioni '+ arfn_fdatetime(DateTime()) + NL // Log Messaggi */
        gMsgProc = "Inizio Elaborazione File Cancellazioni "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* fhand := FileLibMit.OpenRead("/appo/"+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile)) // Handle File */
        fhand = FileLibMit.OpenRead("/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile));
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        /* While not(FileLibMit.Eof(fhand)) */
        while ( ! (FileLibMit.Eof(fhand))) {
          /* _riga := FileLibMit.ReadLine(fhand) */
          _riga = FileLibMit.ReadLine(fhand);
          /* If Len(LRTrim(_riga)) > 0 */
          if (CPLib.gt(CPLib.Len(CPLib.LRTrim(_riga)),0)) {
            /* _coint := '' */
            _coint = "";
            /* _tipage := '' */
            _tipage = "";
            /* _rifana := '' */
            _rifana = "";
            /* gMsgImp := 'Elaboro i dati del soggetto: '+Left(_riga,16) // Messaggio Import */
            gMsgImp = "Elaboro i dati del soggetto: "+CPLib.Left(_riga,16);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            // * --- Select from qbe_cancella_opex
            SPBridge.HMCaller _h00000020;
            _h00000020 = new SPBridge.HMCaller();
            _h00000020.Set("m_cVQRList",m_cVQRList);
            _h00000020.Set("connes",CPLib.Left(_riga,16));
            _h00000020.Set("anno",w_anno);
            if (Cursor_qbe_cancella_opex!=null)
              Cursor_qbe_cancella_opex.Close();
            Cursor_qbe_cancella_opex = new VQRHolder("qbe_cancella_opex",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000020,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_cancella_opex.Eof())) {
              // * --- Select from aeoprig
              m_cServer = m_Ctx.GetServer("aeoprig");
              m_cPhName = m_Ctx.GetPhName("aeoprig");
              if (Cursor_aeoprig!=null)
                Cursor_aeoprig.Close();
              Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPLib.ToSQL(Cursor_qbe_cancella_opex.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_aeoprig.Eof())) {
                /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
                cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aeopstor from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeopstor");
                m_cPhName = m_Ctx.GetPhName("aeopstor");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopstor",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cancella_opex",43,"00000023")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000023(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopstor",true);
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
                /* cCanc := Utilities.GetAutonumber("PDELAGE\'"+LRTrim(gAzienda)+"'",'',10) */
                cCanc = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PDELAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aeopcanc from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeopcanc");
                m_cPhName = m_Ctx.GetPhName("aeopcanc");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopcanc",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cancella_opex",43,"00000025")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000025(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_datarett,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(w_datarett,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cCanc,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopcanc",true);
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
                // * --- Delete from opextrbo
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cancella_opex",43,"00000026")+"delete from "+m_oWrInfo.GetTableWriteName();
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(_riga,16),"?",0,0,m_cServer),m_cServer,CPLib.Left(_riga,16))+"";
                m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_anno,4,0))+"";
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
                Cursor_aeoprig.Next();
              }
              m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
              Cursor_aeoprig.Close();
              // * --- End Select
              Cursor_qbe_cancella_opex.Next();
            }
            m_cConnectivityError = Cursor_qbe_cancella_opex.ErrorMessage();
            Cursor_qbe_cancella_opex.Close();
            // * --- End Select
          } // End If
        } // End While
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* gMsgProc := gMsgProc + 'Sono stati elaborati N. '+LRTrim(Str(_conta,10,0))+' soggetti' + NL // Log Messaggi */
        gMsgProc = gMsgProc+"Sono stati elaborati N. "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" soggetti"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Fine Elaborazione File Cancellazioni '+ arfn_fdatetime(DateTime()) + NL // Log Messaggi */
        gMsgProc = gMsgProc+"Fine Elaborazione File Cancellazioni "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_cancella_opex!=null)
          Cursor_qbe_cancella_opex.Close();
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
      m_Caller.SetString("nomefile","C",100,0,w_nomefile);
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cancella_opexR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cancella_opexR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_datarett = m_Caller.GetDate("datarett","D",8,0);
    w_nomefile = m_Caller.GetString("nomefile","C",100,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    fhand = CPLib.Space(1);
    _conta = 0;
    _riga = "";
    _coint = CPLib.Space(1);
    _tipage = CPLib.Space(2);
    _rifana = CPLib.Space(1);
    cProg = CPLib.Space(10);
    cCanc = CPLib.Space(10);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cancella_opex,
  public static final String m_cVQRList = ",qbe_cancella_opex,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000023(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopstor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000025(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"DATARIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFSTOR,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPOCAN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopcanc",true);
    return p_cSql;
  }
}
