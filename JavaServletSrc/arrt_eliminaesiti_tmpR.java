// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_eliminaesiti_tmpR implements CallerWithObjs {
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
  public String m_cPhName_tmp_impesiti;
  public String m_cServer_tmp_impesiti;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aefiles_do;
  public String m_cServer_aefiles_do;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
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
  public double w_scelta;
  public String w_msgproc;
  public String gMsgProc;
  public double _aperte;
  public double _chiuse;
  public double _cancellate;
  public String _nomefile;
  public String _filedgn;
  public String idfile;
  public String logoperaz;
  public String nomefile;
  public String rapporto;
  public String nprog;
  public double _max;
  public double _min;
  public double _cicli;
  public double _contacilci;
  public double _bottom;
  public double _top;
  public String gMsgImp;
  public String czipfile;
  public String cpercorsozip;
  public String buffernomefile;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_eliminaesiti_tmp
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_eliminaesiti_tmpR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_eliminaesiti_tmp",m_Caller);
    m_cPhName_tmp_impesiti = p_ContextObject.GetPhName("tmp_impesiti");
    if (m_cPhName_tmp_impesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_impesiti = m_cPhName_tmp_impesiti+" "+m_Ctx.GetWritePhName("tmp_impesiti");
    }
    m_cServer_tmp_impesiti = p_ContextObject.GetServer("tmp_impesiti");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    if (m_cPhName_aefiles.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles = m_cPhName_aefiles+" "+m_Ctx.GetWritePhName("aefiles");
    }
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
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
    m_cPhName_aefiles_do = p_ContextObject.GetPhName("aefiles_do");
    if (m_cPhName_aefiles_do.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles_do = m_cPhName_aefiles_do+" "+m_Ctx.GetWritePhName("aefiles_do");
    }
    m_cServer_aefiles_do = p_ContextObject.GetServer("aefiles_do");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("scelta",p_cVarName)) {
      return w_scelta;
    }
    if (CPLib.eqr("_aperte",p_cVarName)) {
      return _aperte;
    }
    if (CPLib.eqr("_chiuse",p_cVarName)) {
      return _chiuse;
    }
    if (CPLib.eqr("_cancellate",p_cVarName)) {
      return _cancellate;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_eliminaesiti_tmp";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("msgproc",p_cVarName)) {
      return w_msgproc;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("_filedgn",p_cVarName)) {
      return _filedgn;
    }
    if (CPLib.eqr("idfile",p_cVarName)) {
      return idfile;
    }
    if (CPLib.eqr("logoperaz",p_cVarName)) {
      return logoperaz;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("rapporto",p_cVarName)) {
      return rapporto;
    }
    if (CPLib.eqr("nprog",p_cVarName)) {
      return nprog;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      return czipfile;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      return cpercorsozip;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      return buffernomefile;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("scelta",p_cVarName)) {
      w_scelta = value;
      return;
    }
    if (CPLib.eqr("_aperte",p_cVarName)) {
      _aperte = value;
      return;
    }
    if (CPLib.eqr("_chiuse",p_cVarName)) {
      _chiuse = value;
      return;
    }
    if (CPLib.eqr("_cancellate",p_cVarName)) {
      _cancellate = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      _contacilci = value;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("msgproc",p_cVarName)) {
      w_msgproc = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("_filedgn",p_cVarName)) {
      _filedgn = value;
      return;
    }
    if (CPLib.eqr("idfile",p_cVarName)) {
      idfile = value;
      return;
    }
    if (CPLib.eqr("logoperaz",p_cVarName)) {
      logoperaz = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("rapporto",p_cVarName)) {
      rapporto = value;
      return;
    }
    if (CPLib.eqr("nprog",p_cVarName)) {
      nprog = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
      return;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      czipfile = value;
      return;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      cpercorsozip = value;
      return;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      buffernomefile = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    CPResultSet Cursor_tmp_impesiti=null;
    CPResultSet Cursor_aerighe=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* w_scelta Numeric(1, 0) */
      /* w_msgproc Memo */
      /* gMsgProc Memo */
      /* _aperte Numeric(10, 0) */
      /* _chiuse Numeric(10, 0) */
      /* _cancellate Numeric(10, 0) */
      /* _nomefile Char(20) */
      /* _filedgn Char(15) */
      /* idfile Char(10) */
      /* logoperaz Memo */
      /* nomefile Char(20) */
      /* rapporto Char(25) */
      /* nprog Char(25) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* gMsgImp Memo // Messaggio Import */
      /* czipfile Char(20) */
      /* cpercorsozip Char(200) */
      /* buffernomefile Char(100) */
      /* gPathApp Char(80) // Path Applicazione */
      /* logoperaz := '' */
      logoperaz = "";
      /* gMsgProc := gMsgProc + 'Ora Inzio Cancellazione dati '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inzio Cancellazione dati "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from tmp_impesiti
      m_cServer = m_Ctx.GetServer("tmp_impesiti");
      m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
      if (Cursor_tmp_impesiti!=null)
        Cursor_tmp_impesiti.Close();
      Cursor_tmp_impesiti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_impesiti")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_impesiti.Eof())) {
        /* If w_scelta=1 */
        if (CPLib.eqr(w_scelta,1)) {
          /* gMsgImp := 'Eliminazione rapporti cliente ' + LRTrim(tmp_impesiti->connes)+" - "+LRTrim(tmp_impesiti->ragsoc) // Messaggio allineamento 1 */
          gMsgImp = "Eliminazione rapporti cliente "+CPLib.LRTrim(Cursor_tmp_impesiti.GetString("connes"))+" - "+CPLib.LRTrim(Cursor_tmp_impesiti.GetString("ragsoc"));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* rapporto := '' */
          rapporto = "";
          // * --- Select from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          if (Cursor_aerighe!=null)
            Cursor_aerighe.Close();
          Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select RAPPORTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPLib.ToSQL(Cursor_tmp_impesiti.GetString("connes"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aerighe.Eof())) {
            /* rapporto := aerighe->RAPPORTO */
            rapporto = Cursor_aerighe.GetString("RAPPORTO");
            // * --- Delete from aerighe
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aerighe");
            m_cPhName = m_Ctx.GetPhName("aerighe");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti_tmp",58,"00000025")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rapporto,"?",0,0,m_cServer),m_cServer,rapporto)+"";
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
            // * --- Delete from aetesta
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti_tmp",58,"00000026")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rapporto,"?",0,0,m_cServer),m_cServer,rapporto)+"";
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
            Cursor_aerighe.Next();
          }
          m_cConnectivityError = Cursor_aerighe.ErrorMessage();
          Cursor_aerighe.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Eliminazione operazioni extraconto/deleghe cliente ' + LRTrim(tmp_impesiti->connes)+" - "+LRTrim(tmp_impesiti->ragsoc) // Messaggio allineamento 1 */
          gMsgImp = "Eliminazione operazioni extraconto/deleghe cliente "+CPLib.LRTrim(Cursor_tmp_impesiti.GetString("connes"))+" - "+CPLib.LRTrim(Cursor_tmp_impesiti.GetString("ragsoc"));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Delete from aeoprig
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti_tmp",58,"00000028")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_impesiti.GetString("nprog"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_impesiti.GetString("nprog"))+"";
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
        Cursor_tmp_impesiti.Next();
      }
      m_cConnectivityError = Cursor_tmp_impesiti.ErrorMessage();
      Cursor_tmp_impesiti.Close();
      // * --- End Select
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* _filedgn := Left(tmp_list_imprich->nomefile,15) */
        _filedgn = CPLib.Left(Cursor_tmp_list_imprich.GetString("nomefile"),15);
        /* If Right(_filedgn,1)='1' or Right(_filedgn,1)='4' */
        if (CPLib.eqr(CPLib.Right(_filedgn,1),"1") || CPLib.eqr(CPLib.Right(_filedgn,1),"4")) {
          // * --- Write into aerighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti_tmp",58,"0000002C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_filedgn,"?",0,0,m_cServer),m_cServer,_filedgn)+"";
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
          /* ElseIf Right(_filedgn,1)='2' or Right(_filedgn,1)='5' */
        } else if (CPLib.eqr(CPLib.Right(_filedgn,1),"2") || CPLib.eqr(CPLib.Right(_filedgn,1),"5")) {
          // * --- Write into aerighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti_tmp",58,"0000002D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_filedgn,"?",0,0,m_cServer),m_cServer,_filedgn)+"";
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
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Ora Fine Cancellazione dati '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Cancellazione dati "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Eliminazione rapporti terminata' // Messaggio allineamento 1 */
      gMsgImp = "Eliminazione rapporti terminata";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_tmp_impesiti!=null)
          Cursor_tmp_impesiti.Close();
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
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
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
      m_Caller.SetNumber("scelta","N",1,0,w_scelta);
      m_Caller.SetString("msgproc","M",10,0,w_msgproc);
      m_Caller.SetString("gMsgProc","M",10,0,gMsgProc);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_eliminaesiti_tmpR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_eliminaesiti_tmpR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_scelta = m_Caller.GetNumber("scelta","N",1,0);
    w_msgproc = m_Caller.GetString("msgproc","M",10,0);
    gMsgProc = m_Caller.GetString("gMsgProc","M",10,0);
    _aperte = 0;
    _chiuse = 0;
    _cancellate = 0;
    _nomefile = CPLib.Space(20);
    _filedgn = CPLib.Space(15);
    idfile = CPLib.Space(10);
    logoperaz = "";
    nomefile = CPLib.Space(20);
    rapporto = CPLib.Space(25);
    nprog = CPLib.Space(25);
    _max = 0;
    _min = 0;
    _cicli = 0;
    _contacilci = 0;
    _bottom = 0;
    _top = 0;
    czipfile = CPLib.Space(20);
    cpercorsozip = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
