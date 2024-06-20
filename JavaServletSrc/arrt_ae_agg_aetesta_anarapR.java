// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_ae_agg_aetesta_anarapR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public String pRif;
  public String w_RAPPORTO;
  public String w_DESCRAP;
  public String w_TIPORAP;
  public String w_TIPOAG;
  public String w_VALUTA;
  public double w_NOPROT;
  public String gAzienda;
  public String gIntemediario;
  public double _noprot;
  public String _rapporto;
  public double nProgImp;
  public String _cab;
  public double _inviato;
  public double _inviatoc;
  public String _tipoag;
  public String _coint;
  public String _descri;
  public String _valuta;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_ae_agg_aetesta_anarapR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_ae_agg_aetesta_anarap",m_Caller);
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("NOPROT",p_cVarName)) {
      return w_NOPROT;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      return _noprot;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("_inviato",p_cVarName)) {
      return _inviato;
    }
    if (CPLib.eqr("_inviatoc",p_cVarName)) {
      return _inviatoc;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_ae_agg_aetesta_anarap";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pRif",p_cVarName)) {
      return pRif;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      return w_RAPPORTO;
    }
    if (CPLib.eqr("DESCRAP",p_cVarName)) {
      return w_DESCRAP;
    }
    if (CPLib.eqr("TIPORAP",p_cVarName)) {
      return w_TIPORAP;
    }
    if (CPLib.eqr("TIPOAG",p_cVarName)) {
      return w_TIPOAG;
    }
    if (CPLib.eqr("VALUTA",p_cVarName)) {
      return w_VALUTA;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      return _cab;
    }
    if (CPLib.eqr("_tipoag",p_cVarName)) {
      return _tipoag;
    }
    if (CPLib.eqr("_coint",p_cVarName)) {
      return _coint;
    }
    if (CPLib.eqr("_descri",p_cVarName)) {
      return _descri;
    }
    if (CPLib.eqr("_valuta",p_cVarName)) {
      return _valuta;
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
    if (CPLib.eqr("NOPROT",p_cVarName)) {
      w_NOPROT = value;
      return;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      _noprot = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("_inviato",p_cVarName)) {
      _inviato = value;
      return;
    }
    if (CPLib.eqr("_inviatoc",p_cVarName)) {
      _inviatoc = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pRif",p_cVarName)) {
      pRif = value;
      return;
    }
    if (CPLib.eqr("RAPPORTO",p_cVarName)) {
      w_RAPPORTO = value;
      return;
    }
    if (CPLib.eqr("DESCRAP",p_cVarName)) {
      w_DESCRAP = value;
      return;
    }
    if (CPLib.eqr("TIPORAP",p_cVarName)) {
      w_TIPORAP = value;
      return;
    }
    if (CPLib.eqr("TIPOAG",p_cVarName)) {
      w_TIPOAG = value;
      return;
    }
    if (CPLib.eqr("VALUTA",p_cVarName)) {
      w_VALUTA = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      _cab = value;
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
    if (CPLib.eqr("_descri",p_cVarName)) {
      _descri = value;
      return;
    }
    if (CPLib.eqr("_valuta",p_cVarName)) {
      _valuta = value;
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
    CPResultSet Read_Cursor=null;
    try {
      /* pRif Char(1) */
      /* w_RAPPORTO Char(25) */
      /* w_DESCRAP Char(50) // Descrizione */
      /* w_TIPORAP Char(1) // Tipo Rapporto */
      /* w_TIPOAG Char(2) */
      /* w_VALUTA Char(3) // Codice Divisa */
      /* w_NOPROT Numeric(1, 0) */
      /* gAzienda Char(10) // Azienda */
      /* gIntemediario Char(11) // Intermediario */
      /* _noprot Numeric(1, 0) */
      /* _rapporto Char(25) */
      /* nProgImp Numeric(15, 0) */
      /* _cab Char(5) */
      /* _inviato Numeric(1, 0) */
      /* _inviatoc Numeric(1, 0) */
      /* _tipoag Char(2) */
      /* _coint Char(1) */
      /* _descri Char(24) */
      /* _valuta Char(3) */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _cab := iif(At(w_TIPOAG,'|01|02|03|12|13|99')<>0,Left(intermbo->CODCAB,5),'') */
        _cab = (CPLib.ne(CPLib.At(w_TIPOAG,"|01|02|03|12|13|99"),0)?CPLib.Left(Cursor_intermbo.GetString("CODCAB"),5):"");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* If w_NOPROT=0 */
      if (CPLib.eqr(w_NOPROT,0)) {
        /* _rapporto := '' */
        _rapporto = "";
        /* _inviato := 0 */
        _inviato = CPLib.Round(0,0);
        /* _inviatoc := 0 */
        _inviatoc = CPLib.Round(0,0);
        /* _tipoag := '' */
        _tipoag = "";
        /* _coint := '' */
        _coint = "";
        /* _descri := '' */
        _descri = "";
        /* _valuta := '' */
        _valuta = "";
        // * --- Read from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"C",25,0,m_cServer),m_cServer,w_RAPPORTO);
        if (m_Ctx.IsSharedTemp("aetesta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("INVIATO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("INVIATOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPOAG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COINT",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CAB",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("VALUTA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _rapporto = Read_Cursor.GetString("RAPPORTO");
          _inviato = CPLib.Round(Read_Cursor.GetDouble("INVIATO"),0);
          _inviatoc = CPLib.Round(Read_Cursor.GetDouble("INVIATOC"),0);
          _tipoag = Read_Cursor.GetString("TIPOAG");
          _coint = Read_Cursor.GetString("COINT");
          _descri = Read_Cursor.GetString("DESCRI");
          _cab = Read_Cursor.GetString("CAB");
          _valuta = Read_Cursor.GetString("VALUTA");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aetesta into routine arrt_ae_agg_aetesta_anarap returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _rapporto = "";
          _inviato = 0;
          _inviatoc = 0;
          _tipoag = "";
          _coint = "";
          _descri = "";
          _cab = "";
          _valuta = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(_rapporto) */
        if (CPLib.Empty(_rapporto)) {
          /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          // * --- Insert into aetesta from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_ae_agg_aetesta_anarap",17,"00000026")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000026(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_TIPOAG,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_TIPORAP,"1")?"1":"2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(pRif,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_TIPOAG,"99")?CPLib.Upper(CPLib.Left(w_DESCRAP,24)):""),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(w_VALUTA,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(gIntemediario,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_cab,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aetesta",true);
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
        } else { // Else
          /* If _inviato=0 */
          if (CPLib.eqr(_inviato,0)) {
            // * --- Write into aetesta from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_ae_agg_aetesta_anarap",17,"00000028")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(w_TIPOAG,"C",2,0,m_cServer)+", ";
            m_cSql = m_cSql+"COINT = "+CPLib.ToSQL((CPLib.eqr(w_TIPORAP,"1")?"1":"2"),"C",1,0,m_cServer)+", ";
            m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL((CPLib.eqr(w_TIPOAG,"99")?CPLib.Upper(CPLib.Left(w_DESCRAP,24)):""),"C",24,0,m_cServer)+", ";
            m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_VALUTA,"C",3,0,m_cServer)+", ";
            m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(_cab,"C",5,0,m_cServer)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer),m_cServer,w_RAPPORTO)+"";
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
            /* ElseIf _inviato=1 and _inviatoc=0 */
          } else if (CPLib.eqr(_inviato,1) && CPLib.eqr(_inviatoc,0)) {
            /* If LRTrim(_tipoag)+LRTrim(_coint)+LRTrim(_descri)+LRTrim(_valuta) <> LRTrim(w_TIPOAG)+iif(w_TIPORAP='1','1','2')+iif(w_TIPOAG='99',LRTrim(Upper(Left(w_DESCRAP,24))),'')+LRTrim(w_VALUTA) */
            if (CPLib.ne(CPLib.LRTrim(_tipoag)+CPLib.LRTrim(_coint)+CPLib.LRTrim(_descri)+CPLib.LRTrim(_valuta),CPLib.LRTrim(w_TIPOAG)+(CPLib.eqr(w_TIPORAP,"1")?"1":"2")+(CPLib.eqr(w_TIPOAG,"99")?CPLib.LRTrim(CPLib.Upper(CPLib.Left(w_DESCRAP,24))):"")+CPLib.LRTrim(w_VALUTA))) {
              // * --- Write into aetesta from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_ae_agg_aetesta_anarap",17,"0000002A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"TIPOAG = "+CPLib.ToSQL(w_TIPOAG,"C",2,0,m_cServer)+", ";
              m_cSql = m_cSql+"COINT = "+CPLib.ToSQL((CPLib.eqr(w_TIPORAP,"1")?"1":"2"),"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DESCRI = "+CPLib.ToSQL((CPLib.eqr(w_TIPOAG,"99")?CPLib.Upper(CPLib.Left(w_DESCRAP,24)):""),"C",24,0,m_cServer)+", ";
              m_cSql = m_cSql+"VALUTA = "+CPLib.ToSQL(w_VALUTA,"C",3,0,m_cServer)+", ";
              m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"CAB = "+CPLib.ToSQL(_cab,"C",5,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_RAPPORTO,"?",0,0,m_cServer),m_cServer,w_RAPPORTO)+"";
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
          } // End If
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
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
  void _init_() {
  }
  public String RunAsync(String p_pRif,String p_w_RAPPORTO,String p_w_DESCRAP,String p_w_TIPORAP,String p_w_TIPOAG,String p_w_VALUTA,double p_w_NOPROT) {
    pRif = p_pRif;
    w_RAPPORTO = p_w_RAPPORTO;
    w_DESCRAP = p_w_DESCRAP;
    w_TIPORAP = p_w_TIPORAP;
    w_TIPOAG = p_w_TIPOAG;
    w_VALUTA = p_w_VALUTA;
    w_NOPROT = p_w_NOPROT;
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
  public Forward Run(String p_pRif,String p_w_RAPPORTO,String p_w_DESCRAP,String p_w_TIPORAP,String p_w_TIPOAG,String p_w_VALUTA,double p_w_NOPROT) {
    pRif = p_pRif;
    w_RAPPORTO = p_w_RAPPORTO;
    w_DESCRAP = p_w_DESCRAP;
    w_TIPORAP = p_w_TIPORAP;
    w_TIPOAG = p_w_TIPOAG;
    w_VALUTA = p_w_VALUTA;
    w_NOPROT = p_w_NOPROT;
    return Run();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_ae_agg_aetesta_anarapR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_ae_agg_aetesta_anarapR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pRif = CPLib.Space(1);
    w_RAPPORTO = CPLib.Space(25);
    w_DESCRAP = CPLib.Space(50);
    w_TIPORAP = CPLib.Space(1);
    w_TIPOAG = CPLib.Space(2);
    w_VALUTA = CPLib.Space(3);
    w_NOPROT = 0;
    _noprot = 0;
    _rapporto = CPLib.Space(25);
    nProgImp = 0;
    _cab = CPLib.Space(5);
    _inviato = 0;
    _inviatoc = 0;
    _tipoag = CPLib.Space(2);
    _coint = CPLib.Space(1);
    _descri = CPLib.Space(24);
    _valuta = CPLib.Space(3);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pRif","w_RAPPORTO","w_DESCRAP","w_TIPORAP","w_TIPOAG","w_VALUTA","w_NOPROT"};
  protected static String GetFieldsName_00000026(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
}
