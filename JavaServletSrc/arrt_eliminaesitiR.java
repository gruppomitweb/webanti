// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_eliminaesitiR implements CallerWithObjs {
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
  // * --- arrt_eliminaesiti
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  // * --- Fine Area Manuale
  public arrt_eliminaesitiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_eliminaesiti",m_Caller);
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
    if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
      m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
      if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
      }
      m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    }
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
      return "arrt_eliminaesiti";
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
    CPResultSet Cursor_qbe_tmp_impesiti_max_min=null;
    CPResultSet Cursor_tmp_impesiti=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_listfilesae=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_scelta Numeric(1, 0) */
      /* w_msgproc Memo */
      /* gMsgProc Memo */
      /* _aperte Numeric(10, 0) */
      /* _chiuse Numeric(10, 0) */
      /* _cancellate Numeric(10, 0) */
      /* _nomefile Char(20) */
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
      // * --- Drop temporary table tmp_list_imprich
      if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_list_imprich");
      }
      // * --- Create temporary table tmp_list_imprich
      if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_list_imprich");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_list_imprich");
      if ( ! (m_Ctx.IsSharedTemp("tmp_list_imprich"))) {
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_list_imprich",m_cServer,"proto")),m_cPhName,"tmp_list_imprich",m_Ctx);
      }
      m_cPhName_tmp_list_imprich = m_cPhName;
      /* logoperaz := '' */
      logoperaz = "";
      /* gMsgProc := gMsgProc + 'Ora Inzio Cancellazione dati '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inzio Cancellazione dati "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from qbe_tmp_impesiti_max_min
      if (Cursor_qbe_tmp_impesiti_max_min!=null)
        Cursor_qbe_tmp_impesiti_max_min.Close();
      Cursor_qbe_tmp_impesiti_max_min = new VQRHolder("qbe_tmp_impesiti_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tmp_impesiti_max_min.Eof())) {
        /* _max := qbe_tmp_impesiti_max_min->MAXPROGIMPESITI */
        _max = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MAXPROGIMPESITI"),0);
        /* _min := qbe_tmp_impesiti_max_min->MINPROGIMPESITI */
        _min = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MINPROGIMPESITI"),0);
        Cursor_qbe_tmp_impesiti_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_tmp_impesiti_max_min.ErrorMessage();
      Cursor_qbe_tmp_impesiti_max_min.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
      /* _contacilci := 1 */
      _contacilci = CPLib.Round(1,0);
      /* While _contacilci<= _cicli */
      while (CPLib.le(_contacilci,_cicli)) {
        /* _bottom := ((_contacilci -1 ) * 10000) + 1 */
        _bottom = CPLib.Round(((_contacilci-1)*10000)+1,0);
        /* _top := _contacilci * 10000 */
        _top = CPLib.Round(_contacilci*10000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          /* If w_scelta=1 */
          if (CPLib.eqr(w_scelta,1)) {
            /* rapporti continuativi */
            // * --- Select from tmp_impesiti
            m_cServer = m_Ctx.GetServer("tmp_impesiti");
            m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
            if (Cursor_tmp_impesiti!=null)
              Cursor_tmp_impesiti.Close();
            Cursor_tmp_impesiti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPESITI>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGIMPESITI<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("tmp_impesiti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_impesiti.Eof())) {
              /* gMsgImp := 'Elaborazione al ' + LRTrim(Str(((tmp_impesiti->PROGIMPESITI-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%.' // Messaggio allineamento 1 */
              gMsgImp = "Elaborazione al "+CPLib.LRTrim(CPLib.Str(((Cursor_tmp_impesiti.GetDouble("PROGIMPESITI")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%.";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* If LRTrim(tmp_impesiti->trueident)<>'' */
              if (CPLib.ne(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("trueident")),"")) {
                /* nprog := LRTrim(tmp_impesiti->nprog) */
                nprog = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("nprog"));
                /* nomefile := LRTrim(tmp_impesiti->trueident)+'.zip' */
                nomefile = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("trueident"))+".zip";
                // * --- Read from aefiles
                m_cServer = m_Ctx.GetServer("aefiles");
                m_cPhName = m_Ctx.GetPhName("aefiles");
                m_cSql = "";
                m_cSql = m_cSql+"nomefile="+CPSql.SQLValueAdapter(CPLib.ToSQL(nomefile,"C",90,0,m_cServer),m_cServer,nomefile);
                if (m_Ctx.IsSharedTemp("aefiles")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idfile",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  idfile = Read_Cursor.GetString("idfile");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on aefiles into routine arrt_eliminaesiti returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  idfile = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* Exec "AnnullaR" Page 2 */
                Page_2();
              } // End If
              Cursor_tmp_impesiti.Next();
            }
            m_cConnectivityError = Cursor_tmp_impesiti.ErrorMessage();
            Cursor_tmp_impesiti.Close();
            // * --- End Select
          } else { // Else
            // * --- Select from tmp_impesiti
            m_cServer = m_Ctx.GetServer("tmp_impesiti");
            m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
            if (Cursor_tmp_impesiti!=null)
              Cursor_tmp_impesiti.Close();
            Cursor_tmp_impesiti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPESITI>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGIMPESITI<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("tmp_impesiti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_impesiti.Eof())) {
              /* gMsgImp := 'Elaborazione al ' + LRTrim(Str(((tmp_impesiti->PROGIMPESITI-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%.' // Messaggio allineamento 1 */
              gMsgImp = "Elaborazione al "+CPLib.LRTrim(CPLib.Str(((Cursor_tmp_impesiti.GetDouble("PROGIMPESITI")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%.";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* If tmp_impesiti->tipoac='O' */
              if (CPLib.eqr(Cursor_tmp_impesiti.GetString("tipoac"),"O")) {
                /* operazioni extraconto */
                /* If LRTrim(tmp_impesiti->trueident)<>'' */
                if (CPLib.ne(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("trueident")),"")) {
                  /* nprog := LRTrim(tmp_impesiti->nprog) */
                  nprog = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("nprog"));
                  /* nomefile := LRTrim(tmp_impesiti->trueident)+'.zip' */
                  nomefile = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("trueident"))+".zip";
                  // * --- Read from aefiles_do
                  m_cServer = m_Ctx.GetServer("aefiles_do");
                  m_cPhName = m_Ctx.GetPhName("aefiles_do");
                  m_cSql = "";
                  m_cSql = m_cSql+"nomefile="+CPSql.SQLValueAdapter(CPLib.ToSQL(nomefile,"C",90,0,m_cServer),m_cServer,nomefile);
                  if (m_Ctx.IsSharedTemp("aefiles_do")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idfile",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    idfile = Read_Cursor.GetString("idfile");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on aefiles_do into routine arrt_eliminaesiti returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    idfile = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* Exec "AnnullaO" Page 3 */
                  Page_3();
                } // End If
              } else { // Else
                /* deleghe e procure */
                /* If LRTrim(tmp_impesiti->trueident)<>'' */
                if (CPLib.ne(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("trueident")),"")) {
                  /* nprog := LRTrim(tmp_impesiti->nprog) */
                  nprog = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("nprog"));
                  /* nomefile := LRTrim(tmp_impesiti->trueident)+'.zip' */
                  nomefile = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("trueident"))+".zip";
                  // * --- Read from aefiles_do
                  m_cServer = m_Ctx.GetServer("aefiles_do");
                  m_cPhName = m_Ctx.GetPhName("aefiles_do");
                  m_cSql = "";
                  m_cSql = m_cSql+"nomefile="+CPSql.SQLValueAdapter(CPLib.ToSQL(nomefile,"C",90,0,m_cServer),m_cServer,nomefile);
                  if (m_Ctx.IsSharedTemp("aefiles_do")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("idfile",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    idfile = Read_Cursor.GetString("idfile");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on aefiles_do into routine arrt_eliminaesiti returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    idfile = "";
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* Exec "AnnullaD" Page 4 */
                  Page_4();
                } // End If
              } // End If
              Cursor_tmp_impesiti.Next();
            }
            m_cConnectivityError = Cursor_tmp_impesiti.ErrorMessage();
            Cursor_tmp_impesiti.Close();
            // * --- End Select
          } // End If
        } // End If
        /* _contacilci := _contacilci+1 */
        _contacilci = CPLib.Round(_contacilci+1,0);
      } // End While
      // * --- Select from qbe_listfilesae
      if (Cursor_qbe_listfilesae!=null)
        Cursor_qbe_listfilesae.Close();
      Cursor_qbe_listfilesae = new VQRHolder("qbe_listfilesae",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_listfilesae.Eof())) {
        /* Case Substr(qbe_listfilesae->nomefile,15,1) ='1' or Substr(qbe_listfilesae->nomefile,15,1) ='4' */
        if (CPLib.eqr(CPLib.Substr(Cursor_qbe_listfilesae.GetString("nomefile"),15,1),"1") || CPLib.eqr(CPLib.Substr(Cursor_qbe_listfilesae.GetString("nomefile"),15,1),"4")) {
          // * --- Write into aerighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000044")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_listfilesae.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_listfilesae.GetString("nomefile"))+"";
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
          /* Case Substr(qbe_listfilesae->nomefile,15,1) ='2' or Substr(qbe_listfilesae->nomefile,15,1) ='5' */
        } else if (CPLib.eqr(CPLib.Substr(Cursor_qbe_listfilesae.GetString("nomefile"),15,1),"2") || CPLib.eqr(CPLib.Substr(Cursor_qbe_listfilesae.GetString("nomefile"),15,1),"5")) {
          // * --- Write into aerighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000045")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_listfilesae.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_listfilesae.GetString("nomefile"))+"";
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
        } // End Case
        Cursor_qbe_listfilesae.Next();
      }
      m_cConnectivityError = Cursor_qbe_listfilesae.ErrorMessage();
      Cursor_qbe_listfilesae.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Ora Fine Cancellazione dati '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Cancellazione dati "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_tmp_impesiti_max_min!=null)
          Cursor_qbe_tmp_impesiti_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_impesiti!=null)
          Cursor_tmp_impesiti.Close();
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
        if (Cursor_qbe_listfilesae!=null)
          Cursor_qbe_listfilesae.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* rapporto := '' */
      rapporto = "";
      /* _nomefile := Left(nomefile,15) */
      _nomefile = CPLib.Left(nomefile,15);
      /* Case Right(_nomefile,1)='1' or Right(_nomefile,1)='4' */
      if (CPLib.eqr(CPLib.Right(_nomefile,1),"1") || CPLib.eqr(CPLib.Right(_nomefile,1),"4")) {
        /* leggo il codice rapporto basandomi sul progressivo della apertura per eliminarlo */
        // * --- Read from aerighe
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_cSql = "";
        m_cSql = m_cSql+"APROG="+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"C",25,0,m_cServer),m_cServer,nprog);
        if (m_Ctx.IsSharedTemp("aerighe")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          rapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aerighe into routine arrt_eliminaesiti returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          rapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        // * --- Delete from aerighe
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"0000004C")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"?",0,0,m_cServer),m_cServer,nprog)+"";
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
        /* If rapporto<>'' */
        if (CPLib.ne(rapporto,"")) {
          // * --- Delete from aetesta
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"0000004E")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        } // End If
        /* Case Right(_nomefile,1)='2' or Right(_nomefile,1)='5' */
      } else if (CPLib.eqr(CPLib.Right(_nomefile,1),"2") || CPLib.eqr(CPLib.Right(_nomefile,1),"5")) {
        // * --- Write into aerighe from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aerighe",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"0000004F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"?",0,0,m_cServer),m_cServer,nprog)+"";
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
        /* Case Right(_nomefile,1)='7' */
      } else if (CPLib.eqr(CPLib.Right(_nomefile,1),"7")) {
        // * --- Delete from aefiles
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aefiles");
        m_cPhName = m_Ctx.GetPhName("aefiles");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefiles",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000050")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"idfile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfile,"?",0,0,m_cServer),m_cServer,idfile)+"";
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
      } // End Case
      // * --- Insert into tmp_list_imprich from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000051")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000051(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
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
    /* _nomefile := Left(nomefile,15) */
    _nomefile = CPLib.Left(nomefile,15);
    /* If Right(_nomefile,1)='7' */
    if (CPLib.eqr(CPLib.Right(_nomefile,1),"7")) {
      // * --- Delete from aefiles_do
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aefiles_do");
      m_cPhName = m_Ctx.GetPhName("aefiles_do");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefiles_do",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000054")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"idfile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfile,"?",0,0,m_cServer),m_cServer,idfile)+"";
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
      // * --- Delete from aeoprig
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000055")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"?",0,0,m_cServer),m_cServer,nprog)+"";
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
      /* annullo file */
      // * --- Write into aeoprig from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aeoprig");
      m_cPhName = m_Ctx.GetPhName("aeoprig");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000057")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
      m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer),m_cServer,_nomefile)+"";
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
      // * --- Delete from aefiles_do
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aefiles_do");
      m_cPhName = m_Ctx.GetPhName("aefiles_do");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefiles_do",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000058")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"idfile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfile,"?",0,0,m_cServer),m_cServer,idfile)+"";
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
  void Page_4() throws Exception {
    /* _nomefile := Left(nomefile,15) */
    _nomefile = CPLib.Left(nomefile,15);
    /* If Right(_nomefile,1)='7' */
    if (CPLib.eqr(CPLib.Right(_nomefile,1),"7")) {
      // * --- Delete from aefiles_do
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aefiles_do");
      m_cPhName = m_Ctx.GetPhName("aefiles_do");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefiles_do",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"0000005B")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"idfile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfile,"?",0,0,m_cServer),m_cServer,idfile)+"";
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
      // * --- Delete from aederig
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"0000005C")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"APROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"?",0,0,m_cServer),m_cServer,nprog)+"";
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
      // * --- Write into aederig from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"0000005D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(nprog,"?",0,0,m_cServer),m_cServer,nprog)+"";
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
      /* ora annullo il file */
      // * --- Write into aederig from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"0000005F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"ASPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
      m_cSql = m_cSql+"AFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"AFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer),m_cServer,_nomefile)+"";
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
      // * --- Write into aederig from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aederig");
      m_cPhName = m_Ctx.GetPhName("aederig");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000060")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
      m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
      m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_nomefile,"?",0,0,m_cServer),m_cServer,_nomefile)+"";
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
      // * --- Delete from aefiles_do
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aefiles_do");
      m_cPhName = m_Ctx.GetPhName("aefiles_do");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefiles_do",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_eliminaesiti",46,"00000061")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"idfile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(idfile,"?",0,0,m_cServer),m_cServer,idfile)+"";
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
  void Page_5() throws Exception {
    CPResultSet Cursor_aefiles=null;
    try {
      // * --- Select from aefiles
      m_cServer = m_Ctx.GetServer("aefiles");
      m_cPhName = m_Ctx.GetPhName("aefiles");
      if (Cursor_aefiles!=null)
        Cursor_aefiles.Close();
      Cursor_aefiles = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("aefiles")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_aefiles.Eof())) {
        /* czipfile := aefiles->nomefile */
        czipfile = Cursor_aefiles.GetString("nomefile");
        /* cpercorsozip := LRTrim(gPathApp)+"\flussi\"+czipfile */
        cpercorsozip = CPLib.LRTrim(gPathApp)+"\\flussi\\"+czipfile;
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
        /* While contanome<conteggio */
        while (CPLib.lt(contanome,conteggio)) {
          buffernomefile=lista[contanome];
          /* contanome := contanome+1 */
          contanome = contanome+1;
        } // End While
        Cursor_aefiles.Next();
      }
      m_cConnectivityError = Cursor_aefiles.ErrorMessage();
      Cursor_aefiles.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_aefiles!=null)
          Cursor_aefiles.Close();
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
  public static arrt_eliminaesitiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_eliminaesitiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_scelta = m_Caller.GetNumber("scelta","N",1,0);
    w_msgproc = m_Caller.GetString("msgproc","M",10,0);
    gMsgProc = m_Caller.GetString("gMsgProc","M",10,0);
    _aperte = 0;
    _chiuse = 0;
    _cancellate = 0;
    _nomefile = CPLib.Space(20);
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
  // ENTITY_VQR: ,qbe_tmp_impesiti_max_min,qbe_listfilesae,
  public static final String m_cVQRList = ",qbe_tmp_impesiti_max_min,qbe_listfilesae,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000051(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
}
