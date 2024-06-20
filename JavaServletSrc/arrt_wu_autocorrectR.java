// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_wu_autocorrectR implements CallerWithObjs {
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
  public String m_cPhName_wuautocorrect;
  public String m_cServer_wuautocorrect;
  public String m_cPhName_wutrxchk;
  public String m_cServer_wutrxchk;
  public String m_cPhName_wutrxchk_cases;
  public String m_cServer_wutrxchk_cases;
  public String m_cPhName_dersonbo;
  public String m_cServer_dersonbo;
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
  public double w_TRXCODPRG;
  public String w_TRXCOGNOM;
  public String w_TRXNOME;
  public String w_TRXLUONAS;
  public java.sql.Date w_TRXDATNAS;
  public String w_TRXSESSO;
  public String w_TRXTIPDOC;
  public String w_TRXNUMDOC;
  public String w_TRXCODFIS;
  public String w_FLGDATIOLD;
  public String w_TRXFLGFOR;
  public java.sql.Date w_TRXDATOPE;
  public String w_TRXNASSTATO;
  public String w_TRXNASCOMUN;
  public java.sql.Date w_TRXDATRIL;
  public String w_finalized;
  public String gAzienda;
  public double nProg;
  public String _luonas;
  public MemoryCursor_qbe_rtra_aua_gen_vqr mcAUA;
  public MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA;
  public String _tipodoc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_wu_autocorrectR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_wu_autocorrect",m_Caller);
    m_cPhName_wuautocorrect = p_ContextObject.GetPhName("wuautocorrect");
    if (m_cPhName_wuautocorrect.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wuautocorrect = m_cPhName_wuautocorrect+" "+m_Ctx.GetWritePhName("wuautocorrect");
    }
    m_cServer_wuautocorrect = p_ContextObject.GetServer("wuautocorrect");
    m_cPhName_wutrxchk = p_ContextObject.GetPhName("wutrxchk");
    if (m_cPhName_wutrxchk.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk = m_cPhName_wutrxchk+" "+m_Ctx.GetWritePhName("wutrxchk");
    }
    m_cServer_wutrxchk = p_ContextObject.GetServer("wutrxchk");
    m_cPhName_wutrxchk_cases = p_ContextObject.GetPhName("wutrxchk_cases");
    if (m_cPhName_wutrxchk_cases.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wutrxchk_cases = m_cPhName_wutrxchk_cases+" "+m_Ctx.GetWritePhName("wutrxchk_cases");
    }
    m_cServer_wutrxchk_cases = p_ContextObject.GetServer("wutrxchk_cases");
    m_cPhName_dersonbo = p_ContextObject.GetPhName("dersonbo");
    if (m_cPhName_dersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dersonbo = m_cPhName_dersonbo+" "+m_Ctx.GetWritePhName("dersonbo");
    }
    m_cServer_dersonbo = p_ContextObject.GetServer("dersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("TRXCODPRG",p_cVarName)) {
      return w_TRXCODPRG;
    }
    if (CPLib.eqr("nProg",p_cVarName)) {
      return nProg;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_wu_autocorrect";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("TRXCOGNOM",p_cVarName)) {
      return w_TRXCOGNOM;
    }
    if (CPLib.eqr("TRXNOME",p_cVarName)) {
      return w_TRXNOME;
    }
    if (CPLib.eqr("TRXLUONAS",p_cVarName)) {
      return w_TRXLUONAS;
    }
    if (CPLib.eqr("TRXSESSO",p_cVarName)) {
      return w_TRXSESSO;
    }
    if (CPLib.eqr("TRXTIPDOC",p_cVarName)) {
      return w_TRXTIPDOC;
    }
    if (CPLib.eqr("TRXNUMDOC",p_cVarName)) {
      return w_TRXNUMDOC;
    }
    if (CPLib.eqr("TRXCODFIS",p_cVarName)) {
      return w_TRXCODFIS;
    }
    if (CPLib.eqr("FLGDATIOLD",p_cVarName)) {
      return w_FLGDATIOLD;
    }
    if (CPLib.eqr("TRXFLGFOR",p_cVarName)) {
      return w_TRXFLGFOR;
    }
    if (CPLib.eqr("TRXNASSTATO",p_cVarName)) {
      return w_TRXNASSTATO;
    }
    if (CPLib.eqr("TRXNASCOMUN",p_cVarName)) {
      return w_TRXNASCOMUN;
    }
    if (CPLib.eqr("finalized",p_cVarName)) {
      return w_finalized;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      return _tipodoc;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("TRXDATNAS",p_cVarName)) {
      return w_TRXDATNAS;
    }
    if (CPLib.eqr("TRXDATOPE",p_cVarName)) {
      return w_TRXDATOPE;
    }
    if (CPLib.eqr("TRXDATRIL",p_cVarName)) {
      return w_TRXDATRIL;
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
    if (CPLib.eqr("mcAUA",p_cVarName)) {
      return mcAUA;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowAUA",p_cVarName)) {
      return rowAUA;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("TRXCODPRG",p_cVarName)) {
      w_TRXCODPRG = value;
      return;
    }
    if (CPLib.eqr("nProg",p_cVarName)) {
      nProg = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("TRXCOGNOM",p_cVarName)) {
      w_TRXCOGNOM = value;
      return;
    }
    if (CPLib.eqr("TRXNOME",p_cVarName)) {
      w_TRXNOME = value;
      return;
    }
    if (CPLib.eqr("TRXLUONAS",p_cVarName)) {
      w_TRXLUONAS = value;
      return;
    }
    if (CPLib.eqr("TRXSESSO",p_cVarName)) {
      w_TRXSESSO = value;
      return;
    }
    if (CPLib.eqr("TRXTIPDOC",p_cVarName)) {
      w_TRXTIPDOC = value;
      return;
    }
    if (CPLib.eqr("TRXNUMDOC",p_cVarName)) {
      w_TRXNUMDOC = value;
      return;
    }
    if (CPLib.eqr("TRXCODFIS",p_cVarName)) {
      w_TRXCODFIS = value;
      return;
    }
    if (CPLib.eqr("FLGDATIOLD",p_cVarName)) {
      w_FLGDATIOLD = value;
      return;
    }
    if (CPLib.eqr("TRXFLGFOR",p_cVarName)) {
      w_TRXFLGFOR = value;
      return;
    }
    if (CPLib.eqr("TRXNASSTATO",p_cVarName)) {
      w_TRXNASSTATO = value;
      return;
    }
    if (CPLib.eqr("TRXNASCOMUN",p_cVarName)) {
      w_TRXNASCOMUN = value;
      return;
    }
    if (CPLib.eqr("finalized",p_cVarName)) {
      w_finalized = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      _tipodoc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("TRXDATNAS",p_cVarName)) {
      w_TRXDATNAS = value;
      return;
    }
    if (CPLib.eqr("TRXDATOPE",p_cVarName)) {
      w_TRXDATOPE = value;
      return;
    }
    if (CPLib.eqr("TRXDATRIL",p_cVarName)) {
      w_TRXDATRIL = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowAUA",p_cVarName)) {
      rowAUA = (MemoryCursorRow_qbe_rtra_aua_gen_vqr)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcAUA",p_cVarName)) {
      mcAUA = (MemoryCursor_qbe_rtra_aua_gen_vqr)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_wutrxchk=null;
    CPResultSet Cursor_wutrxchk_cases=null;
    CPResultSet Cursor_qbe_rtra_aua_1_id_a=null;
    CPResultSet Cursor_qbe_rtra_aua_2_id_a=null;
    CPResultSet Cursor_qbe_rtra_aua_3_id_a=null;
    CPResultSet Cursor_qbe_rtra_aua_4_id_a=null;
    CPResultSet Cursor_qbe_rtra_aua_5_id_a=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_TRXCODPRG Numeric(15, 0) // ID Transazione */
      /* w_TRXCOGNOM Char(50) // Cognome */
      /* w_TRXNOME Char(50) // Nome */
      /* w_TRXLUONAS Char(50) // Luogo di nascita */
      /* w_TRXDATNAS Date // Data Di Nascita */
      /* w_TRXSESSO Char(1) // Sesso */
      /* w_TRXTIPDOC Char(2) // Tipo Documento */
      /* w_TRXNUMDOC Char(30) // Numero Documento */
      /* w_TRXCODFIS Char(16) // Codice Fiscale */
      /* w_FLGDATIOLD Char(1) */
      /* w_TRXFLGFOR Char(1) */
      /* w_TRXDATOPE Date // Data Operazione */
      /* w_TRXNASSTATO Char(40) // Stato Nascita da Codice Fiscale */
      /* w_TRXNASCOMUN Char(40) // Comune Nascita da Codice Fiscale */
      /* w_TRXDATRIL Date // Comune Nascita da Codice Fiscale */
      /* w_finalized Char(1) */
      /* gAzienda Char(10) // Azienda */
      /* nProg Numeric(10, 0) */
      /* _luonas Char(50) */
      /* mcAUA MemoryCursor(qbe_rtra_aua_gen.vqr) */
      /* rowAUA Row(qbe_rtra_aua_gen.vqr) */
      /* _tipodoc Char(2) */
      /* _auisex Char(1) */
      String _auisex;
      _auisex = CPLib.Space(1);
      /* If w_finalized='S' */
      if (CPLib.eqr(w_finalized,"S")) {
        /* If w_FLGDATIOLD='S' and w_TRXFLGFOR <> 'S' */
        if (CPLib.eqr(w_FLGDATIOLD,"S") && CPLib.ne(w_TRXFLGFOR,"S")) {
          // * --- Select from wutrxchk
          m_cServer = m_Ctx.GetServer("wutrxchk");
          m_cPhName = m_Ctx.GetPhName("wutrxchk");
          if (Cursor_wutrxchk!=null)
            Cursor_wutrxchk.Close();
          Cursor_wutrxchk = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"TRXCODPRG="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXCODPRG,"?",0,0,m_cServer, m_oParameters),m_cServer,w_TRXCODPRG)+" "+")"+(m_Ctx.IsSharedTemp("wutrxchk")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_wutrxchk.Eof())) {
            /* nProg := Utilities.GetAutonumber("PRGWUAC\'"+LRTrim(gAzienda)+"'",0,10) */
            nProg = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGWUAC\\'"+CPLib.LRTrim(gAzienda)+"'",0,10),0);
            // * --- Insert into wuautocorrect from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("wuautocorrect");
            m_cPhName = m_Ctx.GetPhName("wuautocorrect");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wuautocorrect",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_autocorrect",30,"00000020")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000020(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProg,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXCOGNOM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXLUONAS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXDATNAS,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXSESSO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXTIPDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXNUMDOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_TRXCODFIS,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCOGNOM"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNOME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXLUONAS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetDate("TRXDATNAS"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXSESSO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXTIPDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXNUMDOC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_wutrxchk.GetString("TRXCODFIS"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateTime(),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wuautocorrect",true);
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
            Cursor_wutrxchk.Next();
          }
          m_cConnectivityError = Cursor_wutrxchk.ErrorMessage();
          Cursor_wutrxchk.Close();
          // * --- End Select
          /* ElseIf w_FLGDATIOLD='N' and w_TRXFLGFOR <> 'S' */
        } else if (CPLib.eqr(w_FLGDATIOLD,"N") && CPLib.ne(w_TRXFLGFOR,"S")) {
          /* _auisex := iif(w_TRXSESSO='M','1',iif(w_TRXSESSO='F','2','')) */
          _auisex = (CPLib.eqr(w_TRXSESSO,"M")?"1":(CPLib.eqr(w_TRXSESSO,"F")?"2":""));
          /* _tipodoc := arfn_wu_doctype(LRTrim(w_TRXTIPDOC)) */
          _tipodoc = arfn_wu_doctypeR.Make(m_Ctx,this).Run(CPLib.LRTrim(w_TRXTIPDOC));
          // * --- Select from wutrxchk_cases
          m_cServer = m_Ctx.GetServer("wutrxchk_cases");
          m_cPhName = m_Ctx.GetPhName("wutrxchk_cases");
          if (Cursor_wutrxchk_cases!=null)
            Cursor_wutrxchk_cases.Close();
          Cursor_wutrxchk_cases = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"TRXCODICE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_TRXCODPRG,"?",0,0,m_cServer, m_oParameters),m_cServer,w_TRXCODPRG)+" "+")"+(m_Ctx.IsSharedTemp("wutrxchk_cases")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_wutrxchk_cases.Eof())) {
            /* mcAUA.Zap() */
            mcAUA.Zap();
            /* Case wutrxchk_cases->TRXNQUERY='1' */
            if (CPLib.eqr(Cursor_wutrxchk_cases.GetString("TRXNQUERY"),"1")) {
              // * --- Fill memory cursor mcAUA on qbe_rtra_aua_1_id_a
              mcAUA.Zap();
              SPBridge.HMCaller _h00000027;
              _h00000027 = new SPBridge.HMCaller();
              _h00000027.Set("m_cVQRList",m_cVQRList);
              _h00000027.Set("pTIPODOC",_tipodoc);
              _h00000027.Set("pNUMDOCUM",w_TRXNUMDOC);
              _h00000027.Set("pDATAOPE",w_TRXDATOPE);
              if (Cursor_qbe_rtra_aua_1_id_a!=null)
                Cursor_qbe_rtra_aua_1_id_a.Close();
              Cursor_qbe_rtra_aua_1_id_a = new VQRHolder("qbe_rtra_aua_1_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000027,true).GetResultSet(m_Ctx);
              {
                final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_1_id_a;
                Cursor_qbe_rtra_aua_1_id_a.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_wu_autocorrect: query on qbe_rtra_aua_1_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_qbe_rtra_aua_1_id_a.Eof())) {
                mcAUA.AppendBlank();
                mcAUA.row.CONNES = Cursor_qbe_rtra_aua_1_id_a.GetString("CONNES");
                mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_1_id_a.GetString("COGNOME");
                mcAUA.row.NOME = Cursor_qbe_rtra_aua_1_id_a.GetString("NOME");
                mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_1_id_a.GetString("NASSTATO");
                mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_1_id_a.GetString("NASCOMUN");
                mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_1_id_a.GetDate("DATANASC");
                mcAUA.row.SESSO = Cursor_qbe_rtra_aua_1_id_a.GetString("SESSO");
                mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_1_id_a.GetString("TIPODOC");
                mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_1_id_a.GetString("NUMDOCUM");
                mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_1_id_a.GetDate("DATARILASC");
                mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_1_id_a.GetString("CODFISC");
                mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_1_id_a.GetString("RAGSOC");
                mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_1_id_a.GetString("FLGCFVALIDO");
                mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_1_id_a.GetString("FLGCGFORMAT");
                mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_1_id_a.GetString("LUOGONAS");
                Cursor_qbe_rtra_aua_1_id_a.Next();
              }
              m_cConnectivityError = Cursor_qbe_rtra_aua_1_id_a.ErrorMessage();
              Cursor_qbe_rtra_aua_1_id_a.Close();
              mcAUA.GoTop();
              /* If mcAUA.RecCount() > 0 */
              if (CPLib.gt(mcAUA.RecCount(),0)) {
                for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
                  /* If arfn_agechar(Upper(Strtran(LRTrim(rowAUA.RAGSOC),' ','')),"")+LRTrim(DateToChar(rowAUA.DATANASC))+LRTrim(rowAUA.SESSO)+arfn_agechar(LRTrim(rowAUA.LUOGONAS),"")<>arfn_agechar(Upper(Strtran(LRTrim(w_TRXCOGNOM),' ','')+Strtran(LRTrim(w_TRXNOME),' ','')),"")+LRTrim(DateToChar(w_TRXDATNAS))+LRTrim(_auisex)+arfn_agechar(LRTrim(w_TRXLUONAS),"") */
                  if (CPLib.ne(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(rowAUA.RAGSOC)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(rowAUA.DATANASC))+CPLib.LRTrim(rowAUA.SESSO)+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rowAUA.LUOGONAS),""),arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(w_TRXCOGNOM)," ","")+CPLib.Strtran(CPLib.LRTrim(w_TRXNOME)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(w_TRXDATNAS))+CPLib.LRTrim(_auisex)+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(w_TRXLUONAS),""))) {
                    // * --- Write into dersonbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("dersonbo");
                    m_cPhName = m_Ctx.GetPhName("dersonbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_autocorrect",30,"0000002B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXCOGNOM)+" "+CPLib.LRTrim(w_TRXNOME),"C",100,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(w_TRXCODFIS,"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(_auisex,"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(w_TRXDATNAS,"D",8,0)+", ";
                    m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNOME),"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXCOGNOM),"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNASSTATO),"C",60,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNASCOMUN),"C",60,0,m_cServer)+", ";
                    m_cSql = m_cSql+"LUOGONAS = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXLUONAS),"C",50,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.TIPODOC,"?",0,0,m_cServer),m_cServer,rowAUA.TIPODOC)+"";
                    m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.NUMDOCUM,"?",0,0,m_cServer),m_cServer,rowAUA.NUMDOCUM)+"";
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
                }
              } // End If
              /* Case wutrxchk_cases->TRXNQUERY='2' */
            } else if (CPLib.eqr(Cursor_wutrxchk_cases.GetString("TRXNQUERY"),"2")) {
              // * --- Fill memory cursor mcAUA on qbe_rtra_aua_2_id_a
              mcAUA.Zap();
              SPBridge.HMCaller _h0000002D;
              _h0000002D = new SPBridge.HMCaller();
              _h0000002D.Set("m_cVQRList",m_cVQRList);
              _h0000002D.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(w_TRXCOGNOM)," ","")+CPLib.Strtran(CPLib.LRTrim(w_TRXNOME)," ",""));
              _h0000002D.Set("pDATANASC",w_TRXDATNAS);
              _h0000002D.Set("pSESSO",_auisex);
              _h0000002D.Set("pTIPODOC",_tipodoc);
              _h0000002D.Set("pDATAOPE",w_TRXDATOPE);
              _h0000002D.Set("pLUOGONAS",CPLib.LRTrim(w_TRXLUONAS));
              if (Cursor_qbe_rtra_aua_2_id_a!=null)
                Cursor_qbe_rtra_aua_2_id_a.Close();
              Cursor_qbe_rtra_aua_2_id_a = new VQRHolder("qbe_rtra_aua_2_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002D,true).GetResultSet(m_Ctx);
              {
                final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_2_id_a;
                Cursor_qbe_rtra_aua_2_id_a.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_wu_autocorrect: query on qbe_rtra_aua_2_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_qbe_rtra_aua_2_id_a.Eof())) {
                mcAUA.AppendBlank();
                mcAUA.row.CONNES = Cursor_qbe_rtra_aua_2_id_a.GetString("CONNES");
                mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_2_id_a.GetString("COGNOME");
                mcAUA.row.NOME = Cursor_qbe_rtra_aua_2_id_a.GetString("NOME");
                mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_2_id_a.GetString("NASSTATO");
                mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_2_id_a.GetString("NASCOMUN");
                mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_2_id_a.GetDate("DATANASC");
                mcAUA.row.SESSO = Cursor_qbe_rtra_aua_2_id_a.GetString("SESSO");
                mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_2_id_a.GetString("TIPODOC");
                mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_2_id_a.GetString("NUMDOCUM");
                mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_2_id_a.GetDate("DATARILASC");
                mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_2_id_a.GetString("CODFISC");
                mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_2_id_a.GetString("RAGSOC");
                mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_2_id_a.GetString("FLGCFVALIDO");
                mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_2_id_a.GetString("FLGCGFORMAT");
                mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_2_id_a.GetString("LUOGONAS");
                Cursor_qbe_rtra_aua_2_id_a.Next();
              }
              m_cConnectivityError = Cursor_qbe_rtra_aua_2_id_a.ErrorMessage();
              Cursor_qbe_rtra_aua_2_id_a.Close();
              mcAUA.GoTop();
              /* If mcAUA.RecCount() > 0 */
              if (CPLib.gt(mcAUA.RecCount(),0)) {
                for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
                  /* If Upper(LRTrim(Strtran(rowAUA.NUMDOCUM,' ',''))) <>Upper(LRTrim(Strtran(w_TRXNUMDOC,' ',''))) and rowAUA.DATARILASC = w_TRXDATRIL */
                  if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(CPLib.Strtran(rowAUA.NUMDOCUM," ",""))),CPLib.Upper(CPLib.LRTrim(CPLib.Strtran(w_TRXNUMDOC," ","")))) && CPLib.eqr(rowAUA.DATARILASC,w_TRXDATRIL)) {
                    // * --- Write into dersonbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("dersonbo");
                    m_cPhName = m_Ctx.GetPhName("dersonbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_autocorrect",30,"00000031")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"FLGDISABLED = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.TIPODOC,"?",0,0,m_cServer),m_cServer,rowAUA.TIPODOC)+"";
                    m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.NUMDOCUM,"?",0,0,m_cServer),m_cServer,rowAUA.NUMDOCUM)+"";
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
                }
              } // End If
              /* Case wutrxchk_cases->TRXNQUERY='3' */
            } else if (CPLib.eqr(Cursor_wutrxchk_cases.GetString("TRXNQUERY"),"3")) {
              // * --- Fill memory cursor mcAUA on qbe_rtra_aua_3_id_a
              mcAUA.Zap();
              SPBridge.HMCaller _h00000033;
              _h00000033 = new SPBridge.HMCaller();
              _h00000033.Set("m_cVQRList",m_cVQRList);
              _h00000033.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(w_TRXCOGNOM)," ","")+CPLib.Strtran(CPLib.LRTrim(w_TRXNOME)," ",""));
              _h00000033.Set("pDATANASC",w_TRXDATNAS);
              _h00000033.Set("pSESSO",_auisex);
              _h00000033.Set("pLUOGONAS",CPLib.LRTrim(w_TRXLUONAS));
              if (Cursor_qbe_rtra_aua_3_id_a!=null)
                Cursor_qbe_rtra_aua_3_id_a.Close();
              Cursor_qbe_rtra_aua_3_id_a = new VQRHolder("qbe_rtra_aua_3_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000033,true).GetResultSet(m_Ctx);
              {
                final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_3_id_a;
                Cursor_qbe_rtra_aua_3_id_a.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_wu_autocorrect: query on qbe_rtra_aua_3_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_qbe_rtra_aua_3_id_a.Eof())) {
                mcAUA.AppendBlank();
                mcAUA.row.CONNES = Cursor_qbe_rtra_aua_3_id_a.GetString("CONNES");
                mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_3_id_a.GetString("COGNOME");
                mcAUA.row.NOME = Cursor_qbe_rtra_aua_3_id_a.GetString("NOME");
                mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_3_id_a.GetString("NASSTATO");
                mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_3_id_a.GetString("NASCOMUN");
                mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_3_id_a.GetDate("DATANASC");
                mcAUA.row.SESSO = Cursor_qbe_rtra_aua_3_id_a.GetString("SESSO");
                mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_3_id_a.GetString("TIPODOC");
                mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_3_id_a.GetString("NUMDOCUM");
                mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_3_id_a.GetDate("DATARILASC");
                mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_3_id_a.GetString("CODFISC");
                mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_3_id_a.GetString("RAGSOC");
                mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_3_id_a.GetString("FLGCFVALIDO");
                mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_3_id_a.GetString("FLGCGFORMAT");
                mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_3_id_a.GetString("LUOGONAS");
                Cursor_qbe_rtra_aua_3_id_a.Next();
              }
              m_cConnectivityError = Cursor_qbe_rtra_aua_3_id_a.ErrorMessage();
              Cursor_qbe_rtra_aua_3_id_a.Close();
              mcAUA.GoTop();
              /* If mcAUA.RecCount() > 0 */
              if (CPLib.gt(mcAUA.RecCount(),0)) {
                for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
                  /* If Upper(rowAUA.CODFISC) <> Upper(w_TRXCODFIS) */
                  if (CPLib.ne(CPLib.Upper(rowAUA.CODFISC),CPLib.Upper(w_TRXCODFIS))) {
                    // * --- Write into dersonbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("dersonbo");
                    m_cPhName = m_Ctx.GetPhName("dersonbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_autocorrect",30,"00000037")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXCOGNOM)+" "+CPLib.LRTrim(w_TRXNOME),"C",100,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(w_TRXCODFIS,"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(_auisex,"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(w_TRXDATNAS,"D",8,0)+", ";
                    m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNOME),"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXCOGNOM),"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNASSTATO),"C",60,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNASCOMUN),"C",60,0,m_cServer)+", ";
                    m_cSql = m_cSql+"LUOGONAS = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXLUONAS),"C",50,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.TIPODOC,"?",0,0,m_cServer),m_cServer,rowAUA.TIPODOC)+"";
                    m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.NUMDOCUM,"?",0,0,m_cServer),m_cServer,rowAUA.NUMDOCUM)+"";
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
                }
              } // End If
              /* Case wutrxchk_cases->TRXNQUERY='4' */
            } else if (CPLib.eqr(Cursor_wutrxchk_cases.GetString("TRXNQUERY"),"4")) {
              /* If not(Empty(w_TRXCODFIS)) */
              if ( ! (CPLib.Empty(w_TRXCODFIS))) {
                // * --- Fill memory cursor mcAUA on qbe_rtra_aua_4_id_a
                mcAUA.Zap();
                SPBridge.HMCaller _h0000003A;
                _h0000003A = new SPBridge.HMCaller();
                _h0000003A.Set("m_cVQRList",m_cVQRList);
                _h0000003A.Set("pCODFISC",w_TRXCODFIS);
                if (Cursor_qbe_rtra_aua_4_id_a!=null)
                  Cursor_qbe_rtra_aua_4_id_a.Close();
                Cursor_qbe_rtra_aua_4_id_a = new VQRHolder("qbe_rtra_aua_4_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000003A,true).GetResultSet(m_Ctx);
                {
                  final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_4_id_a;
                  Cursor_qbe_rtra_aua_4_id_a.ActionOnClose(new Runnable() {
                    public void run() {
                      if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                        com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                        if ( ! (CPLib.IsNull(info))) {
                          info.log("Routine arrt_wu_autocorrect: query on qbe_rtra_aua_4_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                        }
                      }
                    }
                    });
                }
                while ( ! (Cursor_qbe_rtra_aua_4_id_a.Eof())) {
                  mcAUA.AppendBlank();
                  mcAUA.row.CONNES = Cursor_qbe_rtra_aua_4_id_a.GetString("CONNES");
                  mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_4_id_a.GetString("COGNOME");
                  mcAUA.row.NOME = Cursor_qbe_rtra_aua_4_id_a.GetString("NOME");
                  mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_4_id_a.GetString("NASSTATO");
                  mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_4_id_a.GetString("NASCOMUN");
                  mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_4_id_a.GetDate("DATANASC");
                  mcAUA.row.SESSO = Cursor_qbe_rtra_aua_4_id_a.GetString("SESSO");
                  mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_4_id_a.GetString("TIPODOC");
                  mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_4_id_a.GetString("NUMDOCUM");
                  mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_4_id_a.GetDate("DATARILASC");
                  mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_4_id_a.GetString("CODFISC");
                  mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_4_id_a.GetString("RAGSOC");
                  mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_4_id_a.GetString("FLGCFVALIDO");
                  mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_4_id_a.GetString("FLGCGFORMAT");
                  mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_4_id_a.GetString("LUOGONAS");
                  Cursor_qbe_rtra_aua_4_id_a.Next();
                }
                m_cConnectivityError = Cursor_qbe_rtra_aua_4_id_a.ErrorMessage();
                Cursor_qbe_rtra_aua_4_id_a.Close();
                mcAUA.GoTop();
                /* If mcAUA.RecCount() > 0 */
                if (CPLib.gt(mcAUA.RecCount(),0)) {
                  for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
                    /* If arfn_agechar(Upper(Strtran(LRTrim(rowAUA.RAGSOC),' ','')),"")+LRTrim(DateToChar(rowAUA.DATANASC))+LRTrim(rowAUA.SESSO)+arfn_agechar(LRTrim(rowAUA.LUOGONAS),"")<>arfn_agechar(Upper(Strtran(LRTrim(w_TRXCOGNOM),' ','')+Strtran(LRTrim(w_TRXNOME),' ','')),"")+LRTrim(DateToChar(w_TRXDATNAS))+LRTrim(_auisex)+arfn_agechar(LRTrim(w_TRXLUONAS),"") */
                    if (CPLib.ne(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(rowAUA.RAGSOC)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(rowAUA.DATANASC))+CPLib.LRTrim(rowAUA.SESSO)+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rowAUA.LUOGONAS),""),arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(w_TRXCOGNOM)," ","")+CPLib.Strtran(CPLib.LRTrim(w_TRXNOME)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(w_TRXDATNAS))+CPLib.LRTrim(_auisex)+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.LRTrim(w_TRXLUONAS),""))) {
                      // * --- Write into dersonbo from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("dersonbo");
                      m_cPhName = m_Ctx.GetPhName("dersonbo");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_autocorrect",30,"0000003E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXCOGNOM)+" "+CPLib.LRTrim(w_TRXNOME),"C",100,0,m_cServer)+", ";
                      m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(w_TRXCODFIS,"C",16,0,m_cServer)+", ";
                      m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(_auisex,"C",1,0,m_cServer)+", ";
                      m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(w_TRXDATNAS,"D",8,0)+", ";
                      m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNOME),"C",50,0,m_cServer)+", ";
                      m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXCOGNOM),"C",50,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNASSTATO),"C",60,0,m_cServer)+", ";
                      m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNASCOMUN),"C",60,0,m_cServer)+", ";
                      m_cSql = m_cSql+"LUOGONAS = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXLUONAS),"C",50,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.TIPODOC,"?",0,0,m_cServer),m_cServer,rowAUA.TIPODOC)+"";
                      m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.NUMDOCUM,"?",0,0,m_cServer),m_cServer,rowAUA.NUMDOCUM)+"";
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
                  }
                } // End If
              } // End If
              /* Case wutrxchk_cases->TRXNQUERY='5' */
            } else if (CPLib.eqr(Cursor_wutrxchk_cases.GetString("TRXNQUERY"),"5")) {
              // * --- Fill memory cursor mcAUA on qbe_rtra_aua_5_id_a
              mcAUA.Zap();
              SPBridge.HMCaller _h00000040;
              _h00000040 = new SPBridge.HMCaller();
              _h00000040.Set("m_cVQRList",m_cVQRList);
              _h00000040.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(w_TRXCOGNOM)," ","")+CPLib.Strtran(CPLib.LRTrim(w_TRXNOME)," ",""));
              _h00000040.Set("pDATANASC",w_TRXDATNAS);
              _h00000040.Set("pSESSO",_auisex);
              _h00000040.Set("pTIPODOC",_tipodoc);
              _h00000040.Set("pNUMDOCUM",w_TRXNUMDOC);
              _h00000040.Set("pLUOGONAS",CPLib.LRTrim(w_TRXLUONAS));
              if (Cursor_qbe_rtra_aua_5_id_a!=null)
                Cursor_qbe_rtra_aua_5_id_a.Close();
              Cursor_qbe_rtra_aua_5_id_a = new VQRHolder("qbe_rtra_aua_5_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000040,true).GetResultSet(m_Ctx);
              {
                final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_5_id_a;
                Cursor_qbe_rtra_aua_5_id_a.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_wu_autocorrect: query on qbe_rtra_aua_5_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_qbe_rtra_aua_5_id_a.Eof())) {
                mcAUA.AppendBlank();
                mcAUA.row.CONNES = Cursor_qbe_rtra_aua_5_id_a.GetString("CONNES");
                mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_5_id_a.GetString("COGNOME");
                mcAUA.row.NOME = Cursor_qbe_rtra_aua_5_id_a.GetString("NOME");
                mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_5_id_a.GetString("NASSTATO");
                mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_5_id_a.GetString("NASCOMUN");
                mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_5_id_a.GetDate("DATANASC");
                mcAUA.row.SESSO = Cursor_qbe_rtra_aua_5_id_a.GetString("SESSO");
                mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_5_id_a.GetString("TIPODOC");
                mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_5_id_a.GetString("NUMDOCUM");
                mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_5_id_a.GetDate("DATARILASC");
                mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_5_id_a.GetString("CODFISC");
                mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_5_id_a.GetString("RAGSOC");
                mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_5_id_a.GetString("FLGCFVALIDO");
                mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_5_id_a.GetString("FLGCGFORMAT");
                mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_5_id_a.GetString("LUOGONAS");
                Cursor_qbe_rtra_aua_5_id_a.Next();
              }
              m_cConnectivityError = Cursor_qbe_rtra_aua_5_id_a.ErrorMessage();
              Cursor_qbe_rtra_aua_5_id_a.Close();
              mcAUA.GoTop();
              /* If mcAUA.RecCount() > 0 */
              if (CPLib.gt(mcAUA.RecCount(),0)) {
                for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
                  /* If not(Empty(rowAUA.CODFISC)) */
                  if ( ! (CPLib.Empty(rowAUA.CODFISC))) {
                    // * --- Write into dersonbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("dersonbo");
                    m_cPhName = m_Ctx.GetPhName("dersonbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_autocorrect",30,"00000044")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXCOGNOM)+" "+CPLib.LRTrim(w_TRXNOME),"C",100,0,m_cServer)+", ";
                    m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(w_TRXCODFIS,"C",16,0,m_cServer)+", ";
                    m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(_auisex,"C",1,0,m_cServer)+", ";
                    m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(w_TRXDATNAS,"D",8,0)+", ";
                    m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNOME),"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXCOGNOM),"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNASSTATO),"C",60,0,m_cServer)+", ";
                    m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXNASCOMUN),"C",60,0,m_cServer)+", ";
                    m_cSql = m_cSql+"LUOGONAS = "+CPLib.ToSQL(CPLib.LRTrim(w_TRXLUONAS),"C",50,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.TIPODOC,"?",0,0,m_cServer),m_cServer,rowAUA.TIPODOC)+"";
                    m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.NUMDOCUM,"?",0,0,m_cServer),m_cServer,rowAUA.NUMDOCUM)+"";
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
                }
              } // End If
              /* Case wutrxchk_cases->TRXNQUERY='6' */
            } else if (CPLib.eqr(Cursor_wutrxchk_cases.GetString("TRXNQUERY"),"6")) {
              // * --- Fill memory cursor mcAUA on qbe_rtra_aua_2_id_a
              mcAUA.Zap();
              SPBridge.HMCaller _h00000046;
              _h00000046 = new SPBridge.HMCaller();
              _h00000046.Set("m_cVQRList",m_cVQRList);
              _h00000046.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(w_TRXCOGNOM)," ","")+CPLib.Strtran(CPLib.LRTrim(w_TRXNOME)," ",""));
              _h00000046.Set("pDATANASC",w_TRXDATNAS);
              _h00000046.Set("pSESSO",_auisex);
              _h00000046.Set("pNUMDOCUM",w_TRXNUMDOC);
              _h00000046.Set("pDATAOPE",w_TRXDATOPE);
              _h00000046.Set("pLUOGONAS",CPLib.LRTrim(w_TRXLUONAS));
              if (Cursor_qbe_rtra_aua_2_id_a!=null)
                Cursor_qbe_rtra_aua_2_id_a.Close();
              Cursor_qbe_rtra_aua_2_id_a = new VQRHolder("qbe_rtra_aua_2_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000046,true).GetResultSet(m_Ctx);
              {
                final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_2_id_a;
                Cursor_qbe_rtra_aua_2_id_a.ActionOnClose(new Runnable() {
                  public void run() {
                    if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_wu_autocorrect: query on qbe_rtra_aua_2_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                      }
                    }
                  }
                  });
              }
              while ( ! (Cursor_qbe_rtra_aua_2_id_a.Eof())) {
                mcAUA.AppendBlank();
                mcAUA.row.CONNES = Cursor_qbe_rtra_aua_2_id_a.GetString("CONNES");
                mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_2_id_a.GetString("COGNOME");
                mcAUA.row.NOME = Cursor_qbe_rtra_aua_2_id_a.GetString("NOME");
                mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_2_id_a.GetString("NASSTATO");
                mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_2_id_a.GetString("NASCOMUN");
                mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_2_id_a.GetDate("DATANASC");
                mcAUA.row.SESSO = Cursor_qbe_rtra_aua_2_id_a.GetString("SESSO");
                mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_2_id_a.GetString("TIPODOC");
                mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_2_id_a.GetString("NUMDOCUM");
                mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_2_id_a.GetDate("DATARILASC");
                mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_2_id_a.GetString("CODFISC");
                mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_2_id_a.GetString("RAGSOC");
                mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_2_id_a.GetString("FLGCFVALIDO");
                mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_2_id_a.GetString("FLGCGFORMAT");
                mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_2_id_a.GetString("LUOGONAS");
                Cursor_qbe_rtra_aua_2_id_a.Next();
              }
              m_cConnectivityError = Cursor_qbe_rtra_aua_2_id_a.ErrorMessage();
              Cursor_qbe_rtra_aua_2_id_a.Close();
              mcAUA.GoTop();
              /* If mcAUA.RecCount() > 0 */
              if (CPLib.gt(mcAUA.RecCount(),0)) {
                for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
                  /* If rowAUA.TIPODOC <> _tipodoc and Upper(LRTrim(rowAUA.NUMDOCUM))=Upper(LRTrim(w_TRXNUMDOC)) and rowAUA.DATARILASC=w_TRXDATRIL */
                  if (CPLib.ne(rowAUA.TIPODOC,_tipodoc) && CPLib.eqr(CPLib.Upper(CPLib.LRTrim(rowAUA.NUMDOCUM)),CPLib.Upper(CPLib.LRTrim(w_TRXNUMDOC))) && CPLib.eqr(rowAUA.DATARILASC,w_TRXDATRIL)) {
                    // * --- Write into dersonbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("dersonbo");
                    m_cPhName = m_Ctx.GetPhName("dersonbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"dersonbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_wu_autocorrect",30,"0000004A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"FLGDISABLED = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"dersonbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"TIPODOC = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.TIPODOC,"?",0,0,m_cServer),m_cServer,rowAUA.TIPODOC)+"";
                    m_cSql = m_cSql+" and NUMDOCUM = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowAUA.NUMDOCUM,"?",0,0,m_cServer),m_cServer,rowAUA.NUMDOCUM)+"";
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
                }
              } // End If
            } // End Case
            Cursor_wutrxchk_cases.Next();
          }
          m_cConnectivityError = Cursor_wutrxchk_cases.ErrorMessage();
          Cursor_wutrxchk_cases.Close();
          // * --- End Select
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_wutrxchk!=null)
          Cursor_wutrxchk.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wutrxchk_cases!=null)
          Cursor_wutrxchk_cases.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_1_id_a!=null)
          Cursor_qbe_rtra_aua_1_id_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_2_id_a!=null)
          Cursor_qbe_rtra_aua_2_id_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_3_id_a!=null)
          Cursor_qbe_rtra_aua_3_id_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_4_id_a!=null)
          Cursor_qbe_rtra_aua_4_id_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_5_id_a!=null)
          Cursor_qbe_rtra_aua_5_id_a.Close();
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
      m_Caller.SetNumber("TRXCODPRG","N",15,0,w_TRXCODPRG);
      m_Caller.SetString("TRXCOGNOM","C",50,0,w_TRXCOGNOM);
      m_Caller.SetString("TRXNOME","C",50,0,w_TRXNOME);
      m_Caller.SetString("TRXLUONAS","C",50,0,w_TRXLUONAS);
      m_Caller.SetDate("TRXDATNAS","D",8,0,w_TRXDATNAS);
      m_Caller.SetString("TRXSESSO","C",1,0,w_TRXSESSO);
      m_Caller.SetString("TRXTIPDOC","C",2,0,w_TRXTIPDOC);
      m_Caller.SetString("TRXNUMDOC","C",30,0,w_TRXNUMDOC);
      m_Caller.SetString("TRXCODFIS","C",16,0,w_TRXCODFIS);
      m_Caller.SetString("FLGDATIOLD","C",1,0,w_FLGDATIOLD);
      m_Caller.SetString("TRXFLGFOR","C",1,0,w_TRXFLGFOR);
      m_Caller.SetDate("TRXDATOPE","D",8,0,w_TRXDATOPE);
      m_Caller.SetString("TRXNASSTATO","C",40,0,w_TRXNASSTATO);
      m_Caller.SetString("TRXNASCOMUN","C",40,0,w_TRXNASCOMUN);
      m_Caller.SetDate("TRXDATRIL","D",8,0,w_TRXDATRIL);
      m_Caller.SetString("finalized","C",1,0,w_finalized);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_wu_autocorrectR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_wu_autocorrectR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_TRXCODPRG = m_Caller.GetNumber("TRXCODPRG","N",15,0);
    w_TRXCOGNOM = m_Caller.GetString("TRXCOGNOM","C",50,0);
    w_TRXNOME = m_Caller.GetString("TRXNOME","C",50,0);
    w_TRXLUONAS = m_Caller.GetString("TRXLUONAS","C",50,0);
    w_TRXDATNAS = m_Caller.GetDate("TRXDATNAS","D",8,0);
    w_TRXSESSO = m_Caller.GetString("TRXSESSO","C",1,0);
    w_TRXTIPDOC = m_Caller.GetString("TRXTIPDOC","C",2,0);
    w_TRXNUMDOC = m_Caller.GetString("TRXNUMDOC","C",30,0);
    w_TRXCODFIS = m_Caller.GetString("TRXCODFIS","C",16,0);
    w_FLGDATIOLD = m_Caller.GetString("FLGDATIOLD","C",1,0);
    w_TRXFLGFOR = m_Caller.GetString("TRXFLGFOR","C",1,0);
    w_TRXDATOPE = m_Caller.GetDate("TRXDATOPE","D",8,0);
    w_TRXNASSTATO = m_Caller.GetString("TRXNASSTATO","C",40,0);
    w_TRXNASCOMUN = m_Caller.GetString("TRXNASCOMUN","C",40,0);
    w_TRXDATRIL = m_Caller.GetDate("TRXDATRIL","D",8,0);
    w_finalized = m_Caller.GetString("finalized","C",1,0);
    nProg = 0;
    _luonas = CPLib.Space(50);
    mcAUA = new MemoryCursor_qbe_rtra_aua_gen_vqr();
    rowAUA = new MemoryCursorRow_qbe_rtra_aua_gen_vqr();
    _tipodoc = CPLib.Space(2);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_rtra_aua_1_id_a,qbe_rtra_aua_2_id_a,qbe_rtra_aua_3_id_a,qbe_rtra_aua_4_id_a,qbe_rtra_aua_5_id_a,qbe_rtra_aua_2_id_a,
  public static final String m_cVQRList = ",qbe_rtra_aua_1_id_a,qbe_rtra_aua_2_id_a,qbe_rtra_aua_3_id_a,qbe_rtra_aua_4_id_a,qbe_rtra_aua_5_id_a,qbe_rtra_aua_2_id_a,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_wu_doctype,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_wu_doctype,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000020(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDPROG,";
    p_cSql = p_cSql+"AUCOGNOM,";
    p_cSql = p_cSql+"AUNOME,";
    p_cSql = p_cSql+"AULUONAS,";
    p_cSql = p_cSql+"AUDATNAS,";
    p_cSql = p_cSql+"AUSESSO,";
    p_cSql = p_cSql+"AUTIPDOC,";
    p_cSql = p_cSql+"AUNUMDOC,";
    p_cSql = p_cSql+"AUCODFISC,";
    p_cSql = p_cSql+"AUOCOGNOM,";
    p_cSql = p_cSql+"AUONOME,";
    p_cSql = p_cSql+"AUOLUONAS,";
    p_cSql = p_cSql+"AUODATNAS,";
    p_cSql = p_cSql+"AUOSESSO,";
    p_cSql = p_cSql+"AUOTIPDOC,";
    p_cSql = p_cSql+"AUONUMDOC,";
    p_cSql = p_cSql+"AUOCODFISC,";
    p_cSql = p_cSql+"AUDATACREA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wuautocorrect",true);
    return p_cSql;
  }
}
