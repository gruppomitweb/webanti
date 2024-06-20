// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class allinea_iremitR implements CallerWithObjs {
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
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
  public String m_cPhName_f_opextrbo;
  public String m_cServer_f_opextrbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
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
  public String gAzienda;
  public String gMsgProc;
  public String gMsgImp;
  public String _cdataoggi;
  public java.sql.Date _dataoggi;
  public String w_cdatini;
  public String w_cdatfin;
  public String _oldmsg;
  public String cOpeProg1;
  public String _idb2;
  public String _idreg;
  public MemoryCursor_qbe_iremit_ope_vqr mcDatiOpe;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public allinea_iremitR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("allinea_iremit",m_Caller);
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    if (m_cPhName_cgo_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico = m_cPhName_cgo_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico");
    }
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
    m_cPhName_f_opextrbo = p_ContextObject.GetPhName("f_opextrbo");
    if (m_cPhName_f_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_f_opextrbo = m_cPhName_f_opextrbo+" "+m_Ctx.GetWritePhName("f_opextrbo");
    }
    m_cServer_f_opextrbo = p_ContextObject.GetServer("f_opextrbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
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
      return "allinea_iremit";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      return _cdataoggi;
    }
    if (CPLib.eqr("cdatini",p_cVarName)) {
      return w_cdatini;
    }
    if (CPLib.eqr("cdatfin",p_cVarName)) {
      return w_cdatfin;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      return cOpeProg1;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      return _idb2;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      return _dataoggi;
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
    if (CPLib.eqr("mcDatiOpe",p_cVarName)) {
      return mcDatiOpe;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("_cdataoggi",p_cVarName)) {
      _cdataoggi = value;
      return;
    }
    if (CPLib.eqr("cdatini",p_cVarName)) {
      w_cdatini = value;
      return;
    }
    if (CPLib.eqr("cdatfin",p_cVarName)) {
      w_cdatfin = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("cOpeProg1",p_cVarName)) {
      cOpeProg1 = value;
      return;
    }
    if (CPLib.eqr("_idb2",p_cVarName)) {
      _idb2 = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dataoggi",p_cVarName)) {
      _dataoggi = value;
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
    if (CPLib.eqr("mcDatiOpe",p_cVarName)) {
      mcDatiOpe = (MemoryCursor_qbe_iremit_ope_vqr)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_iremit_frz=null;
    CPResultSet Cursor_fraziobo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gAzienda Char(10) // Azienda */
      /* gMsgProc Memo // Messaggio */
      /* gMsgImp Char(120) // Messaggio Import */
      /* _cdataoggi Char(8) */
      /* _dataoggi Date */
      /* w_cdatini Char(8) */
      /* w_cdatfin Char(8) */
      /* _oldmsg Memo */
      /* cOpeProg1 Char(10) */
      /* _idb2 Char(10) */
      /* _idreg Char(10) */
      /* mcDatiOpe MemoryCursor(qbe_iremit_ope.vqr) */
      /* Verifica se esiste il nome file nella lista */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000000Fstatus;
      nTry0000000Fstatus = m_Sql.GetTransactionStatus();
      String cTry0000000Fmsg;
      cTry0000000Fmsg = m_Sql.TransactionErrorMessage();
      try {
        /* w_cdatini := '20210101' */
        w_cdatini = "20210101";
        /* w_cdatfin := DateToChar(Date()) */
        w_cdatfin = CPLib.DateToChar(CPLib.Date());
        /* _dataoggi := CharToDate('20210101') */
        _dataoggi = CPLib.CharToDate("20210101");
        /* _cdataoggi := '20210101' */
        _cdataoggi = "20210101";
        /* _oldmsg := '' */
        _oldmsg = "";
        /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* While _dataoggi <= Date() */
        while (CPLib.le(_dataoggi,CPLib.Date())) {
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni/frazionate" // Messaggio */
            gMsgProc = gMsgProc+"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni/frazionate";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni/frazionate") // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni/frazionate");
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Sto elaborando il giorno: '+arfn_fdate(_dataoggi) + " del file operazioni/frazionate" */
          _oldmsg = "Sto elaborando il giorno: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataoggi)+" del file operazioni/frazionate";
          /* mcDatiOpe.Zap() */
          mcDatiOpe.Zap();
          // * --- Fill memory cursor mcDatiOpe on qbe_iremit_frz
          mcDatiOpe.Zap();
          SPBridge.HMCaller _h0000001C;
          _h0000001C = new SPBridge.HMCaller();
          _h0000001C.Set("m_cVQRList",m_cVQRList);
          _h0000001C.Set("_cdataoggi",_cdataoggi);
          if (Cursor_qbe_iremit_frz!=null)
            Cursor_qbe_iremit_frz.Close();
          Cursor_qbe_iremit_frz = new VQRHolder("qbe_iremit_frz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001C,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_iremit_frz;
            Cursor_qbe_iremit_frz.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,60000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine allinea_iremit: query on qbe_iremit_frz returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 60000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_iremit_frz.Eof())) {
            mcDatiOpe.AppendBlank();
            mcDatiOpe.row.NUMPROG = Cursor_qbe_iremit_frz.GetString("NUMPROG");
            mcDatiOpe.row.IDBASE = Cursor_qbe_iremit_frz.GetString("IDBASE");
            Cursor_qbe_iremit_frz.Next();
          }
          m_cConnectivityError = Cursor_qbe_iremit_frz.ErrorMessage();
          Cursor_qbe_iremit_frz.Close();
          mcDatiOpe.GoTop();
          for (MemoryCursorRow_qbe_iremit_ope_vqr rowDatiOpe : mcDatiOpe._iterable_()) {
            /* gMsgImp := "Elaboro la frazionata con codice:" + rowDatiOpe.NUMPROG // Messaggio Import */
            gMsgImp = "Elaboro la frazionata con codice:"+rowDatiOpe.NUMPROG;
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Select from fraziobo
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            if (Cursor_fraziobo!=null)
              Cursor_fraziobo.Close();
            Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowDatiOpe.IDBASE,"?",0,0,m_cServer, m_oParameters),m_cServer,rowDatiOpe.IDBASE)+" "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_fraziobo.Eof())) {
              /* _idb2 := LibreriaMit.UniqueId() */
              _idb2 = LibreriaMit.UniqueId();
              /* _idreg := 'O'+Right(fraziobo->NUMPROG,9)+_idb2 */
              _idreg = "O"+CPLib.Right(Cursor_fraziobo.GetString("NUMPROG"),9)+_idb2;
              /* cOpeProg1 := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
              cOpeProg1 = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
              // * --- Insert into fraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("allinea_iremit",40,"00000023")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000023(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cOpeProg1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("I9","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1R","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDEREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGRAP2"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("0588","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RAREA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("ANNOOPE"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_idb2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("IMPIN"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("IMPOUT"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("MITIG"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MITGDOC"),"?",0,0,m_cServer, m_oParameters)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RISGLOB"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SV58550"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("PROQUOTA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOORO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DAC6"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("FLAGDAC6"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("IMPSARA"),"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SV58550MA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NOSARA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDateTime("NUMIMP"),"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
              m_cSql = m_cSql+")";
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              // * --- Write into fraziobo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("allinea_iremit",40,"00000024")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("3","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATARETT = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("IDBASE"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
              m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
              if (CPLib.lt(m_nUpdatedRows,0)) {
                m_Sql.AbortTransaction();
              }
              m_Sql.CompleteTransaction();
              m_cLastMsgError = m_Sql.TransactionErrorMessage();
              if (CPLib.ne(m_cLastMsgError,"")) {
                m_bError = true;
                throw new RoutineException();
              }
              Cursor_fraziobo.Next();
            }
            m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
            Cursor_fraziobo.Close();
            // * --- End Select
          }
          /* _dataoggi := arfn_datesum(_dataoggi,1) */
          _dataoggi = arfn_datesumR.Make(m_Ctx,this).Run(_dataoggi,1);
          /* _cdataoggi := DateToChar(_dataoggi) */
          _cdataoggi = CPLib.DateToChar(_dataoggi);
        } // End While
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000000Fstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000000Fstatus,cTry0000000Fmsg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_iremit_frz!=null)
          Cursor_qbe_iremit_frz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static allinea_iremitR Make(CPContext p_Ctx, Caller p_Caller) {
    return new allinea_iremitR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _cdataoggi = CPLib.Space(8);
    _dataoggi = CPLib.NullDate();
    w_cdatini = CPLib.Space(8);
    w_cdatfin = CPLib.Space(8);
    _oldmsg = "";
    cOpeProg1 = CPLib.Space(10);
    _idb2 = CPLib.Space(10);
    _idreg = CPLib.Space(10);
    mcDatiOpe = new MemoryCursor_qbe_iremit_ope_vqr();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_iremit_frz,
  public static final String m_cVQRList = ",qbe_iremit_frz,";
  // ENTITY_BATCHES: ,arfn_datesum,arfn_fdate,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_datesum,arfn_fdate,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000023(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"ANNOOPE,";
    p_cSql = p_cSql+"IDBASE2,";
    p_cSql = p_cSql+"IMPIN,";
    p_cSql = p_cSql+"IMPOUT,";
    p_cSql = p_cSql+"MITIG,";
    p_cSql = p_cSql+"MITGDOC,";
    p_cSql = p_cSql+"RISGLOB,";
    p_cSql = p_cSql+"SV58550,";
    p_cSql = p_cSql+"PROQUOTA,";
    p_cSql = p_cSql+"TIPOORO,";
    p_cSql = p_cSql+"DAC6,";
    p_cSql = p_cSql+"FLAGDAC6,";
    p_cSql = p_cSql+"IMPSARA,";
    p_cSql = p_cSql+"SV58550MA,";
    p_cSql = p_cSql+"NOSARA,";
    p_cSql = p_cSql+"NUMIMP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
}
