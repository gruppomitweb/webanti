// * --- Area Manuale = BO - Header
// * --- allinea_sigue
import java.io.File; 
import java.util.Date; 
import jxl.*; 
// * --- Fine Area Manuale
public class allinea_sigueR implements CallerWithObjs {
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
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_qbe_sigue1;
  public String m_cServer_qbe_sigue1;
  public String m_cPhName_inter2bo;
  public String m_cServer_inter2bo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String _idb;
  public java.sql.Date w_dadata;
  public java.sql.Date w_a_data;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- allinea_sigue
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  public int nfogli;
  // * --- Fine Area Manuale
  public allinea_sigueR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("allinea_sigue",m_Caller);
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_qbe_sigue1 = p_ContextObject.GetPhName("qbe_sigue1");
    if (m_cPhName_qbe_sigue1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_qbe_sigue1 = m_cPhName_qbe_sigue1+" "+m_Ctx.GetWritePhName("qbe_sigue1");
    }
    m_cServer_qbe_sigue1 = p_ContextObject.GetServer("qbe_sigue1");
    m_cPhName_inter2bo = p_ContextObject.GetPhName("inter2bo");
    if (m_cPhName_inter2bo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_inter2bo = m_cPhName_inter2bo+" "+m_Ctx.GetWritePhName("inter2bo");
    }
    m_cServer_inter2bo = p_ContextObject.GetServer("inter2bo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
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
      return "allinea_sigue";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_idb",p_cVarName)) {
      return _idb;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
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
    if (CPLib.eqr("_idb",p_cVarName)) {
      _idb = value;
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
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
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
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_sigue1=null;
    CPResultSet Cursor_tbcitta=null;
    CPResultSet Cursor_qbe_sigue2=null;
    CPResultSet Cursor_qbe_sigue3=null;
    CPResultSet Cursor_inter2bo=null;
    CPResultSet Cursor_qbe_sigue4=null;
    CPResultSet Cursor_anarapbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* _idb Char(10) */
      /* w_dadata Date */
      /* w_a_data Date */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* Legge dati intermediario per metteri su operazbo,fraziobo,rapopebo se mancanti */
      /* w_dadata := w_DaDatOpe */
      w_dadata = w_DaDatOpe;
      /* w_a_data := w_ADatOpe */
      w_a_data = w_ADatOpe;
      /* Cicla sul file della lista e lancia la pagina appropriata */
      // Begin Transaction
      m_Sql.RequireTransaction();
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      double nTry00000014status;
      nTry00000014status = m_Sql.GetTransactionStatus();
      String cTry00000014msg;
      cTry00000014msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from qbe_sigue1
        SPBridge.HMCaller _h00000015;
        _h00000015 = new SPBridge.HMCaller();
        _h00000015.Set("m_cVQRList",m_cVQRList);
        _h00000015.Set("dadata",w_dadata);
        _h00000015.Set("a_data",w_a_data);
        if (Cursor_qbe_sigue1!=null)
          Cursor_qbe_sigue1.Close();
        Cursor_qbe_sigue1 = new VQRHolder("qbe_sigue1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000015,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_sigue1.Eof())) {
          // * --- Select from tbcitta
          m_cServer = m_Ctx.GetServer("tbcitta");
          m_cPhName = m_Ctx.GetPhName("tbcitta");
          if (Cursor_tbcitta!=null)
            Cursor_tbcitta.Close();
          Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_qbe_sigue1.GetString("C_CTA")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Upper(Cursor_qbe_sigue1.GetString("C_CTA")))+" "+")"+(m_Ctx.IsSharedTemp("tbcitta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tbcitta.Eof())) {
            /* gMsgImp := 'Elaboro Operazione con IDBASE: ' + qbe_sigue1->IDBASE // Messaggio Import */
            gMsgImp = "Elaboro Operazione con IDBASE: "+Cursor_qbe_sigue1.GetString("IDBASE");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* gMsgProc := gMsgProc + 'IDBASE:' + qbe_sigue1->IDBASE + " - " // Messaggio */
            gMsgProc = gMsgProc+"IDBASE:"+Cursor_qbe_sigue1.GetString("IDBASE")+" - ";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("allinea_sigue",788,"00000019")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_tbcitta.GetString("CAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tbcitta.GetString("CAP")),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_tbcitta.GetString("PROV"),"C",2,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_sigue1.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_sigue1.GetString("IDBASE"))+"";
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
            Cursor_tbcitta.Next();
          }
          m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
          Cursor_tbcitta.Close();
          // * --- End Select
          Cursor_qbe_sigue1.Next();
        }
        m_cConnectivityError = Cursor_qbe_sigue1.ErrorMessage();
        Cursor_qbe_sigue1.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + NL // Messaggio */
        gMsgProc = gMsgProc+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from qbe_sigue2
        SPBridge.HMCaller _h0000001B;
        _h0000001B = new SPBridge.HMCaller();
        _h0000001B.Set("m_cVQRList",m_cVQRList);
        _h0000001B.Set("dadata",w_dadata);
        _h0000001B.Set("a_data",w_a_data);
        if (Cursor_qbe_sigue2!=null)
          Cursor_qbe_sigue2.Close();
        Cursor_qbe_sigue2 = new VQRHolder("qbe_sigue2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001B,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_sigue2.Eof())) {
          // * --- Select from tbcitta
          m_cServer = m_Ctx.GetServer("tbcitta");
          m_cPhName = m_Ctx.GetPhName("tbcitta");
          if (Cursor_tbcitta!=null)
            Cursor_tbcitta.Close();
          Cursor_tbcitta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CITTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Upper(Cursor_qbe_sigue2.GetString("C_CTA")),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Upper(Cursor_qbe_sigue2.GetString("C_CTA")))+" "+")"+(m_Ctx.IsSharedTemp("tbcitta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tbcitta.Eof())) {
            /* gMsgImp := 'Elaboro Frazionata con IDBASE: ' + qbe_sigue2->IDBASE // Messaggio Import */
            gMsgImp = "Elaboro Frazionata con IDBASE: "+Cursor_qbe_sigue2.GetString("IDBASE");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* gMsgProc := gMsgProc + 'IDBASE:' + qbe_sigue2->IDBASE + " - " // Messaggio */
            gMsgProc = gMsgProc+"IDBASE:"+Cursor_qbe_sigue2.GetString("IDBASE")+" - ";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // * --- Write into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("allinea_sigue",788,"0000001F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"C_CAB = "+CPLib.ToSQL(Cursor_tbcitta.GetString("CAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_CAP = "+CPLib.ToSQL(CPLib.LRTrim(Cursor_tbcitta.GetString("CAP")),"C",5,0,m_cServer)+", ";
            m_cSql = m_cSql+"C_PRV = "+CPLib.ToSQL(Cursor_tbcitta.GetString("PROV"),"C",2,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_sigue2.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_sigue2.GetString("IDBASE"))+"";
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
            Cursor_tbcitta.Next();
          }
          m_cConnectivityError = Cursor_tbcitta.ErrorMessage();
          Cursor_tbcitta.Close();
          // * --- End Select
          Cursor_qbe_sigue2.Next();
        }
        m_cConnectivityError = Cursor_qbe_sigue2.ErrorMessage();
        Cursor_qbe_sigue2.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + NL // Messaggio */
        gMsgProc = gMsgProc+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from qbe_sigue3
        SPBridge.HMCaller _h00000021;
        _h00000021 = new SPBridge.HMCaller();
        _h00000021.Set("m_cVQRList",m_cVQRList);
        _h00000021.Set("dadata",w_dadata);
        _h00000021.Set("a_data",w_a_data);
        if (Cursor_qbe_sigue3!=null)
          Cursor_qbe_sigue3.Close();
        Cursor_qbe_sigue3 = new VQRHolder("qbe_sigue3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000021,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_sigue3.Eof())) {
          // * --- Select from inter2bo
          m_cServer = m_Ctx.GetServer("inter2bo");
          m_cPhName = m_Ctx.GetPhName("inter2bo");
          if (Cursor_inter2bo!=null)
            Cursor_inter2bo.Close();
          Cursor_inter2bo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_qbe_sigue3.GetString("CODINT2"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("inter2bo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_inter2bo.Eof())) {
            /* gMsgImp := 'Elaboro Operazione con IDBASE: ' + qbe_sigue3->IDBASE // Messaggio Import */
            gMsgImp = "Elaboro Operazione con IDBASE: "+Cursor_qbe_sigue3.GetString("IDBASE");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* gMsgProc := gMsgProc + 'IDBASE:' + qbe_sigue3->IDBASE + " - " // Messaggio */
            gMsgProc = gMsgProc+"IDBASE:"+Cursor_qbe_sigue3.GetString("IDBASE")+" - ";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // * --- Write into operazbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("allinea_sigue",788,"00000025")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(CPLib.Left(Cursor_inter2bo.GetString("RAGSOC"),50),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_sigue3.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_sigue3.GetString("IDBASE"))+"";
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
            Cursor_inter2bo.Next();
          }
          m_cConnectivityError = Cursor_inter2bo.ErrorMessage();
          Cursor_inter2bo.Close();
          // * --- End Select
          Cursor_qbe_sigue3.Next();
        }
        m_cConnectivityError = Cursor_qbe_sigue3.ErrorMessage();
        Cursor_qbe_sigue3.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + NL // Messaggio */
        gMsgProc = gMsgProc+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from qbe_sigue4
        SPBridge.HMCaller _h00000027;
        _h00000027 = new SPBridge.HMCaller();
        _h00000027.Set("m_cVQRList",m_cVQRList);
        _h00000027.Set("dadata",w_dadata);
        _h00000027.Set("a_data",w_a_data);
        if (Cursor_qbe_sigue4!=null)
          Cursor_qbe_sigue4.Close();
        Cursor_qbe_sigue4 = new VQRHolder("qbe_sigue4",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000027,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_sigue4.Eof())) {
          // * --- Select from inter2bo
          m_cServer = m_Ctx.GetServer("inter2bo");
          m_cPhName = m_Ctx.GetPhName("inter2bo");
          if (Cursor_inter2bo!=null)
            Cursor_inter2bo.Close();
          Cursor_inter2bo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPLib.ToSQL(Cursor_qbe_sigue4.GetString("CODINT2"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("inter2bo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_inter2bo.Eof())) {
            /* gMsgImp := 'Elaboro Frazionata con IDBASE: ' + qbe_sigue4->IDBASE // Messaggio Import */
            gMsgImp = "Elaboro Frazionata con IDBASE: "+Cursor_qbe_sigue4.GetString("IDBASE");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* gMsgProc := gMsgProc + 'IDBASE:' + qbe_sigue4->IDBASE + " - " // Messaggio */
            gMsgProc = gMsgProc+"IDBASE:"+Cursor_qbe_sigue4.GetString("IDBASE")+" - ";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            // * --- Write into fraziobo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("fraziobo");
            m_cPhName = m_Ctx.GetPhName("fraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("allinea_sigue",788,"0000002B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"TIPOINT2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCINTER = "+CPLib.ToSQL(CPLib.Left(Cursor_inter2bo.GetString("RAGSOC"),50),"C",50,0,m_cServer)+", ";
            m_cSql = m_cSql+"CODCAB2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
            m_cSql = m_cSql+"PROV2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_inter2bo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESC2 = "+CPLib.ToSQL(Cursor_inter2bo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_sigue4.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_sigue4.GetString("IDBASE"))+"";
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
            Cursor_inter2bo.Next();
          }
          m_cConnectivityError = Cursor_inter2bo.ErrorMessage();
          Cursor_inter2bo.Close();
          // * --- End Select
          Cursor_qbe_sigue4.Next();
        }
        m_cConnectivityError = Cursor_qbe_sigue4.ErrorMessage();
        Cursor_qbe_sigue4.Close();
        // * --- End Select
        /* gMsgProc := gMsgProc + NL // Messaggio */
        gMsgProc = gMsgProc+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from anarapbo
        m_cServer = m_Ctx.GetServer("anarapbo");
        m_cPhName = m_Ctx.GetPhName("anarapbo");
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
        Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO,TIPORAP,FLAGLIRE,VALUTA  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("anarapbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_anarapbo.Eof())) {
          /* gMsgImp := 'Elaboro Rapporto: ' + anarapbo->RAPPORTO // Messaggio Import */
          gMsgImp = "Elaboro Rapporto: "+Cursor_anarapbo.GetString("RAPPORTO");
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("allinea_sigue",788,"0000002F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_anarapbo.GetString("RAPPORTO"))+"";
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
          // * --- Write into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("allinea_sigue",788,"00000030")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_anarapbo.GetString("RAPPORTO"))+"";
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
          // * --- Write into rapopebo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("rapopebo");
          m_cPhName = m_Ctx.GetPhName("rapopebo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"rapopebo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("allinea_sigue",788,"00000031")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"FLAGLIRE = "+CPLib.ToSQL(Cursor_anarapbo.GetString("FLAGLIRE"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(Cursor_anarapbo.GetString("VALUTA"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"FLAGRAP = "+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPORAP"),"C",1,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"rapopebo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQLNull(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_anarapbo.GetString("RAPPORTO"))+"";
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
          Cursor_anarapbo.Next();
        }
        m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
        Cursor_anarapbo.Close();
        // * --- End Select
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione terminata con successo!' // Messaggio Import */
        gMsgImp = "Elaborazione terminata con successo!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Elaborazione scartata per errori!' // Messaggio Import */
        gMsgImp = "Elaborazione scartata per errori!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000014status,0)) {
          m_Sql.SetTransactionStatus(nTry00000014status,cTry00000014msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_sigue1!=null)
          Cursor_qbe_sigue1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbcitta!=null)
          Cursor_tbcitta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_sigue2!=null)
          Cursor_qbe_sigue2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_sigue3!=null)
          Cursor_qbe_sigue3.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_inter2bo!=null)
          Cursor_inter2bo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_sigue4!=null)
          Cursor_qbe_sigue4.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
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
      m_Caller.SetDate("DaDatOpe","D",8,0,w_DaDatOpe);
      m_Caller.SetDate("ADatOpe","D",8,0,w_ADatOpe);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static allinea_sigueR Make(CPContext p_Ctx, Caller p_Caller) {
    return new allinea_sigueR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_DaDatOpe = m_Caller.GetDate("DaDatOpe","D",8,0);
    w_ADatOpe = m_Caller.GetDate("ADatOpe","D",8,0);
    _idb = CPLib.Space(10);
    w_dadata = CPLib.NullDate();
    w_a_data = CPLib.NullDate();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_sigue1,qbe_sigue2,qbe_sigue3,qbe_sigue4,
  public static final String m_cVQRList = ",qbe_sigue1,qbe_sigue2,qbe_sigue3,qbe_sigue4,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
