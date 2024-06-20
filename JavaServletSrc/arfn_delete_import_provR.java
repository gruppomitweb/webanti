// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_delete_import_provR implements CallerWithObjs {
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
  public String m_cPhName_storico_import;
  public String m_cServer_storico_import;
  public String m_cPhName_xperazbo;
  public String m_cServer_xperazbo;
  public String m_cPhName_xraziobo;
  public String m_cServer_xraziobo;
  public String m_cPhName_xntestit;
  public String m_cServer_xntestit;
  public String m_cPhName_xerzistifrz;
  public String m_cServer_xerzistifrz;
  public String m_cPhName_xerzistiope;
  public String m_cServer_xerzistiope;
  public String m_cPhName_xiduciabo;
  public String m_cServer_xiduciabo;
  public String m_cPhName_xeneficfrz;
  public String m_cServer_xeneficfrz;
  public String m_cPhName_xeneficope;
  public String m_cServer_xeneficope;
  public String m_cPhName_xlientiope;
  public String m_cServer_xlientiope;
  public String m_cPhName_xlientifrz;
  public String m_cServer_xlientifrz;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_xogopebo;
  public String m_cServer_xogopebo;
  public String m_cPhName_xoginfo;
  public String m_cServer_xoginfo;
  public String m_cPhName_xelegabo;
  public String m_cServer_xelegabo;
  public String m_cPhName_xapotit;
  public String m_cServer_xapotit;
  public String m_cPhName_xapopebo;
  public String m_cServer_xapopebo;
  public String m_cPhName_xnarapbo;
  public String m_cServer_xnarapbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public java.sql.Timestamp w_numimp;
  public String gMsgProc;
  public java.sql.Timestamp dateTimeCancella;
  public String _result;
  public String _tabelle;
  public double _error;
  public MemoryCursor_mclistafile_mcrdef mcFile;
  public String tmp;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_delete_import_prov
  String[] str;
  // * --- Fine Area Manuale
  public arfn_delete_import_provR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_delete_import_prov",m_Caller);
    m_cPhName_storico_import = p_ContextObject.GetPhName("storico_import");
    if (m_cPhName_storico_import.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_storico_import = m_cPhName_storico_import+" "+m_Ctx.GetWritePhName("storico_import");
    }
    m_cServer_storico_import = p_ContextObject.GetServer("storico_import");
    m_cPhName_xperazbo = p_ContextObject.GetPhName("xperazbo");
    if (m_cPhName_xperazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xperazbo = m_cPhName_xperazbo+" "+m_Ctx.GetWritePhName("xperazbo");
    }
    m_cServer_xperazbo = p_ContextObject.GetServer("xperazbo");
    m_cPhName_xraziobo = p_ContextObject.GetPhName("xraziobo");
    if (m_cPhName_xraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xraziobo = m_cPhName_xraziobo+" "+m_Ctx.GetWritePhName("xraziobo");
    }
    m_cServer_xraziobo = p_ContextObject.GetServer("xraziobo");
    m_cPhName_xntestit = p_ContextObject.GetPhName("xntestit");
    if (m_cPhName_xntestit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestit = m_cPhName_xntestit+" "+m_Ctx.GetWritePhName("xntestit");
    }
    m_cServer_xntestit = p_ContextObject.GetServer("xntestit");
    m_cPhName_xerzistifrz = p_ContextObject.GetPhName("xerzistifrz");
    if (m_cPhName_xerzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistifrz = m_cPhName_xerzistifrz+" "+m_Ctx.GetWritePhName("xerzistifrz");
    }
    m_cServer_xerzistifrz = p_ContextObject.GetServer("xerzistifrz");
    m_cPhName_xerzistiope = p_ContextObject.GetPhName("xerzistiope");
    if (m_cPhName_xerzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xerzistiope = m_cPhName_xerzistiope+" "+m_Ctx.GetWritePhName("xerzistiope");
    }
    m_cServer_xerzistiope = p_ContextObject.GetServer("xerzistiope");
    m_cPhName_xiduciabo = p_ContextObject.GetPhName("xiduciabo");
    if (m_cPhName_xiduciabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xiduciabo = m_cPhName_xiduciabo+" "+m_Ctx.GetWritePhName("xiduciabo");
    }
    m_cServer_xiduciabo = p_ContextObject.GetServer("xiduciabo");
    m_cPhName_xeneficfrz = p_ContextObject.GetPhName("xeneficfrz");
    if (m_cPhName_xeneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficfrz = m_cPhName_xeneficfrz+" "+m_Ctx.GetWritePhName("xeneficfrz");
    }
    m_cServer_xeneficfrz = p_ContextObject.GetServer("xeneficfrz");
    m_cPhName_xeneficope = p_ContextObject.GetPhName("xeneficope");
    if (m_cPhName_xeneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xeneficope = m_cPhName_xeneficope+" "+m_Ctx.GetWritePhName("xeneficope");
    }
    m_cServer_xeneficope = p_ContextObject.GetServer("xeneficope");
    m_cPhName_xlientiope = p_ContextObject.GetPhName("xlientiope");
    if (m_cPhName_xlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientiope = m_cPhName_xlientiope+" "+m_Ctx.GetWritePhName("xlientiope");
    }
    m_cServer_xlientiope = p_ContextObject.GetServer("xlientiope");
    m_cPhName_xlientifrz = p_ContextObject.GetPhName("xlientifrz");
    if (m_cPhName_xlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xlientifrz = m_cPhName_xlientifrz+" "+m_Ctx.GetWritePhName("xlientifrz");
    }
    m_cServer_xlientifrz = p_ContextObject.GetServer("xlientifrz");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_xogopebo = p_ContextObject.GetPhName("xogopebo");
    if (m_cPhName_xogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xogopebo = m_cPhName_xogopebo+" "+m_Ctx.GetWritePhName("xogopebo");
    }
    m_cServer_xogopebo = p_ContextObject.GetServer("xogopebo");
    m_cPhName_xoginfo = p_ContextObject.GetPhName("xoginfo");
    if (m_cPhName_xoginfo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xoginfo = m_cPhName_xoginfo+" "+m_Ctx.GetWritePhName("xoginfo");
    }
    m_cServer_xoginfo = p_ContextObject.GetServer("xoginfo");
    m_cPhName_xelegabo = p_ContextObject.GetPhName("xelegabo");
    if (m_cPhName_xelegabo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xelegabo = m_cPhName_xelegabo+" "+m_Ctx.GetWritePhName("xelegabo");
    }
    m_cServer_xelegabo = p_ContextObject.GetServer("xelegabo");
    m_cPhName_xapotit = p_ContextObject.GetPhName("xapotit");
    if (m_cPhName_xapotit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapotit = m_cPhName_xapotit+" "+m_Ctx.GetWritePhName("xapotit");
    }
    m_cServer_xapotit = p_ContextObject.GetServer("xapotit");
    m_cPhName_xapopebo = p_ContextObject.GetPhName("xapopebo");
    if (m_cPhName_xapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xapopebo = m_cPhName_xapopebo+" "+m_Ctx.GetWritePhName("xapopebo");
    }
    m_cServer_xapopebo = p_ContextObject.GetServer("xapopebo");
    m_cPhName_xnarapbo = p_ContextObject.GetPhName("xnarapbo");
    if (m_cPhName_xnarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnarapbo = m_cPhName_xnarapbo+" "+m_Ctx.GetWritePhName("xnarapbo");
    }
    m_cServer_xnarapbo = p_ContextObject.GetServer("xnarapbo");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_error",p_cVarName)) {
      return _error;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_delete_import_prov";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("_result",p_cVarName)) {
      return _result;
    }
    if (CPLib.eqr("_tabelle",p_cVarName)) {
      return _tabelle;
    }
    if (CPLib.eqr("tmp",p_cVarName)) {
      return tmp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("numimp",p_cVarName)) {
      return w_numimp;
    }
    if (CPLib.eqr("dateTimeCancella",p_cVarName)) {
      return dateTimeCancella;
    }
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcFile",p_cVarName)) {
      return mcFile;
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
    if (CPLib.eqr("_error",p_cVarName)) {
      _error = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_result",p_cVarName)) {
      _result = value;
      return;
    }
    if (CPLib.eqr("_tabelle",p_cVarName)) {
      _tabelle = value;
      return;
    }
    if (CPLib.eqr("tmp",p_cVarName)) {
      tmp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
    if (CPLib.eqr("numimp",p_cVarName)) {
      w_numimp = value;
      return;
    }
    if (CPLib.eqr("dateTimeCancella",p_cVarName)) {
      dateTimeCancella = value;
      return;
    }
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcFile",p_cVarName)) {
      mcFile = (MemoryCursor_mclistafile_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void main() throws Exception {
    CPResultSet Cursor_storico_import=null;
    try {
      /* w_numimp DateTime // numimp dell'import da eliminare */
      /* gMsgProc Memo */
      /* dateTimeCancella DateTime // Timestamp che va nel DB */
      /* _result Char(0) := "OK" // Stringa di ritorno funzione */
      _result = "OK";
      /* _tabelle Char(0) // nomi dei file importati  */
      /* _error Numeric(0, 0) := -1 */
      _error = CPLib.Round(-1,0);
      /* mcFile MemoryCursor(mcListaFile.MCRDef) */
      /* gMsgProc := 'Inizio cancellazione import del ' + w_numimp + NL */
      gMsgProc = "Inizio cancellazione import del "+w_numimp+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* dateTimeCancella := DateTime() // Timestamp che va nel DB */
      dateTimeCancella = CPLib.DateTime();
      // * --- Select from storico_import
      m_cServer = m_Ctx.GetServer("storico_import");
      m_cPhName = m_Ctx.GetPhName("storico_import");
      if (Cursor_storico_import!=null)
        Cursor_storico_import.Close();
      Cursor_storico_import = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer, m_oParameters),m_cServer,w_numimp)+" "+")"+(m_Ctx.IsSharedTemp("storico_import")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_storico_import.Eof())) {
        /* _tabelle := storico_import->TABELLE // nomi dei file importati  */
        _tabelle = Cursor_storico_import.GetString("TABELLE");
        /* _error := iif(Empty(storico_import->ELIM_IMP),0,1) // Verifico che l'import sia vergine */
        _error = CPLib.Round((CPLib.Empty(Cursor_storico_import.GetDateTime("ELIM_IMP"))?0:1),0);
        Cursor_storico_import.Next();
      }
      m_cConnectivityError = Cursor_storico_import.ErrorMessage();
      Cursor_storico_import.Close();
      // * --- End Select
      /* If _error=0 */
      if (CPLib.eqr(_error,0)) {
        /* tmp Char(0) */
        _tabelle=_tabelle.substring(1);
        _tabelle=_tabelle.substring(0, _tabelle.length()-1);
        str=_tabelle.split(",", -1);
        for(int i =str.length-1; i>=0;i--){tmp=str[i];
        /* mcFile.AppendBlank() */
        mcFile.AppendBlank();
        /* mcFile.nomefile := tmp */
        mcFile.row.nomefile = tmp;
        /* mcFile.SaveRow() */
        mcFile.SaveRow();
        }
        for (MemoryCursorRow_mclistafile_mcrdef rw_file : mcFile._iterable_()) {
          /* gMsgProc := gMsgProc+'->' + rw_file.nomefile+ NL */
          gMsgProc = gMsgProc+"->"+rw_file.nomefile+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* Case At('archpers',rw_file.nomefile) <> 0 */
          if (CPLib.ne(CPLib.At("archpers",rw_file.nomefile),0)) {
            /* Exec "Gestione Soggetti" Page 2:pers */
            pers();
            /* gMsgProc := gMsgProc + 'Eliminati Soggetti Provvisori' + NL */
            gMsgProc = gMsgProc+"Eliminati Soggetti Provvisori"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('archtito',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("archtito",rw_file.nomefile),0)) {
            // * --- Delete from xapotit
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xapotit");
            m_cPhName = m_Ctx.GetPhName("xapotit");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapotit",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"0000001E")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            // * --- Delete from xntestit
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xntestit");
            m_cPhName = m_Ctx.GetPhName("xntestit");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestit",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"0000001F")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminate Titolari Effettivi' + NL */
            gMsgProc = gMsgProc+"Eliminate Titolari Effettivi"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('sogcli',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("sogcli",rw_file.nomefile),0)) {
            // * --- Delete from xlientifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xlientifrz");
            m_cPhName = m_Ctx.GetPhName("xlientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000021")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            // * --- Delete from xlientiope
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xlientiope");
            m_cPhName = m_Ctx.GetPhName("xlientiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xlientiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000022")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminati Altri Intestatari Operazioni' + NL */
            gMsgProc = gMsgProc+"Eliminati Altri Intestatari Operazioni"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('archrap',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("archrap",rw_file.nomefile),0)) {
            // * --- Delete from xnarapbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xnarapbo");
            m_cPhName = m_Ctx.GetPhName("xnarapbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xnarapbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000024")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminate Rapporti Provvisorio' + NL */
            gMsgProc = gMsgProc+"Eliminate Rapporti Provvisorio"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('archinf',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("archinf",rw_file.nomefile),0)) {
            // * --- Delete from xntestbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000026")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            // * --- Delete from xelegabo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xelegabo");
            m_cPhName = m_Ctx.GetPhName("xelegabo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xelegabo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000027")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            // * --- Delete from xiduciabo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xiduciabo");
            m_cPhName = m_Ctx.GetPhName("xiduciabo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xiduciabo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000028")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            // * --- Delete from xapopebo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xapopebo");
            m_cPhName = m_Ctx.GetPhName("xapopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xapopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000029")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminate le Operazioni' + NL */
            gMsgProc = gMsgProc+"Eliminate le Operazioni"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('archope',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("archope",rw_file.nomefile),0)) {
            // * --- Delete from xperazbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xperazbo");
            m_cPhName = m_Ctx.GetPhName("xperazbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xperazbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"0000002B")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminate le Operazioni' + NL */
            gMsgProc = gMsgProc+"Eliminate le Operazioni"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('archfraz',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("archfraz",rw_file.nomefile),0)) {
            // * --- Delete from xraziobo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xraziobo");
            m_cPhName = m_Ctx.GetPhName("xraziobo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xraziobo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"0000002D")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminate le Frazionate' + NL */
            gMsgProc = gMsgProc+"Eliminate le Frazionate"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('intest',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("intest",rw_file.nomefile),0)) {
            // * --- Delete from xntestbo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xntestbo");
            m_cPhName = m_Ctx.GetPhName("xntestbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"0000002F")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminate Intestatari Provvisorio' + NL */
            gMsgProc = gMsgProc+"Eliminate Intestatari Provvisorio"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('procdel',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("procdel",rw_file.nomefile),0)) {
            // * --- Delete from xelegabo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xelegabo");
            m_cPhName = m_Ctx.GetPhName("xelegabo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xelegabo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000031")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminate Procuratori/Delegati su Rapporto Provvisorio' + NL */
            gMsgProc = gMsgProc+"Eliminate Procuratori/Delegati su Rapporto Provvisorio"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('sogope',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("sogope",rw_file.nomefile),0)) {
            // * --- Delete from xogopebo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xogopebo");
            m_cPhName = m_Ctx.GetPhName("xogopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xogopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000033")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            // * --- Delete from xoginfo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xoginfo");
            m_cPhName = m_Ctx.GetPhName("xoginfo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xoginfo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000034")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminate Soggetti Operanti Provvisorio' + NL */
            gMsgProc = gMsgProc+"Eliminate Soggetti Operanti Provvisorio"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('sogben',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("sogben",rw_file.nomefile),0)) {
            // * --- Delete from xeneficfrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xeneficfrz");
            m_cPhName = m_Ctx.GetPhName("xeneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000036")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            // * --- Delete from xeneficope
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xeneficope");
            m_cPhName = m_Ctx.GetPhName("xeneficope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xeneficope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000037")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            // * --- Delete from xiduciabo
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xiduciabo");
            m_cPhName = m_Ctx.GetPhName("xiduciabo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xiduciabo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000038")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminati Altri Beneficiari Operazioni' + NL */
            gMsgProc = gMsgProc+"Eliminati Altri Beneficiari Operazioni"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('sogaltro',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("sogaltro",rw_file.nomefile),0)) {
            // * --- Delete from xerzistifrz
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xerzistifrz");
            m_cPhName = m_Ctx.GetPhName("xerzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"0000003A")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            // * --- Delete from xerzistiope
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xerzistiope");
            m_cPhName = m_Ctx.GetPhName("xerzistiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xerzistiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"0000003B")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminati Altri Soggetti Operanti Operazioni' + NL */
            gMsgProc = gMsgProc+"Eliminati Altri Soggetti Operanti Operazioni"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('persnew',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("persnew",rw_file.nomefile),0)) {
            /* Exec "Gestione Soggetti" Page 2:pers */
            pers();
            /* gMsgProc := gMsgProc + 'Eliminati Soggetti Provvisori' + NL */
            gMsgProc = gMsgProc+"Eliminati Soggetti Provvisori"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* Case At('titosupp',rw_file.nomefile) <> 0 */
          } else if (CPLib.ne(CPLib.At("titosupp",rw_file.nomefile),0)) {
            // * --- Delete from xntestit
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("xntestit");
            m_cPhName = m_Ctx.GetPhName("xntestit");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"xntestit",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"0000003F")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
            /* gMsgProc := gMsgProc + 'Eliminati Altri titolari Effettivi' + NL */
            gMsgProc = gMsgProc+"Eliminati Altri titolari Effettivi"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End Case
        }
        // * --- Write into storico_import from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("storico_import");
        m_cPhName = m_Ctx.GetPhName("storico_import");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"storico_import",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000041")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"ELIM_IMP = "+CPLib.ToSQL(dateTimeCancella,"T",14,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"storico_import",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"NUMIMP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer),m_cServer,w_numimp)+"";
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
        /* gMsgProc := gMsgProc + 'Riscontrato errore in fase di verifica dati. Cancellazione annullata!' + NL */
        gMsgProc = gMsgProc+"Riscontrato errore in fase di verifica dati. Cancellazione annullata!"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _result := "KO" */
        _result = "KO";
      } // End If
      /* gMsgProc := gMsgProc + 'Fine proceduta cancellazione import' + NL */
      gMsgProc = gMsgProc+"Fine proceduta cancellazione import"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return _result */
      throw new Stop(_result);
    } finally {
      try {
        if (Cursor_storico_import!=null)
          Cursor_storico_import.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void pers() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_wersonbo=null;
    try {
      /* trovato_in_wesonbo Bool := False  */
      boolean trovato_in_wesonbo;
      trovato_in_wesonbo = false;
      /* w_CONNES Char(16) */
      String w_CONNES;
      w_CONNES = CPLib.Space(16);
      /* CASO 1 e 2 */
      // * --- Select from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      if (Cursor_personbo!=null)
        Cursor_personbo.Close();
      Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer, m_oParameters),m_cServer,w_numimp)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_personbo.Eof())) {
        /* Vado a vedere in wersonbo in base al CONNES e NUMIMP */
        // * --- Select from wersonbo
        m_cServer = m_Ctx.GetServer("wersonbo");
        m_cPhName = m_Ctx.GetPhName("wersonbo");
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
        Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0)+"=CONNES  and  NUMIMP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer, m_oParameters),m_cServer,w_numimp)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_wersonbo.Eof())) {
          /* Se lo trovo lo ripristino in personbo e zappo in wersonbo */
          /* trovato_in_wesonbo := True */
          trovato_in_wesonbo = true;
          // * --- Write into personbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"0000004F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"ALLINEATO = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("ALLINEATO"),"N",1,0)+", ";
          m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("ALLINEATONOMECNOME"),"N",1,0)+", ";
          m_cSql = m_cSql+"AREAGEO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AREAGEO"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"ATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ATTIV"),"C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("AUTRILASC"),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"CAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CAP"),"C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("CFESTERO"),"N",1,0)+", ";
          m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODCAB"),"C",6,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODDIPE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODDIPE"),"C",6,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODFISC"),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODINTER = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODINTER"),"C",11,0,m_cServer)+", ";
          m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(Cursor_wersonbo.GetString("COGNOME"),"C",26,0,m_cServer)+", ";
          m_cSql = m_cSql+"COMPORT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("COMPORT"),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATANASC"),"D",8,0)+", ";
          m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATARILASC"),"D",8,0)+", ";
          m_cSql = m_cSql+"DATASEGN = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATASEGN"),"D",8,0)+", ";
          m_cSql = m_cSql+"DATAVALI = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAVALI"),"D",8,0)+", ";
          m_cSql = m_cSql+"DATEXTRA = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATEXTRA"),"D",8,0)+", ";
          m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DESCCIT"),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOCFILE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOCFILE"),"C",100,0,m_cServer)+", ";
          m_cSql = m_cSql+"DOMICILIO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DOMICILIO"),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"idcitta = "+CPLib.ToSQL(Cursor_wersonbo.GetString("idcitta"),"C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"IDFILE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("IDFILE"),"C",60,0,m_cServer)+", ";
          m_cSql = m_cSql+"MACROAGENTE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("MACROAGENTE"),"C",5,0,m_cServer)+", ";
          m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASCOMUN"),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"C",30,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NOME"),"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOTE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NOTE"),"M",10,0,m_cServer,m_oParameters)+", ";
          m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NUMDOCUM"),"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"OLDCODFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("OLDCODFISC"),"C",20,0,m_cServer)+", ";
          m_cSql = m_cSql+"OLDCONNES = "+CPLib.ToSQL(Cursor_wersonbo.GetString("OLDCONNES"),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"OLDSETSIN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("OLDSETSIN"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"PAESE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PAESE"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"PARTIVA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PARTIVA"),"C",14,0,m_cServer)+", ";
          m_cSql = m_cSql+"PEP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PEP"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"PKTBSPECIE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PKTBSPECIE"),"C",4,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROGIMP_C = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROGIMP_C"),"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"PROGIMPORT = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("PROGIMPORT"),"N",15,0)+", ";
          m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("PROVINCIA"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOC"),"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAGSOCOLD = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAGSOCOLD"),"C",70,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAMOGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RAMOGRUP"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"RAREA = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("RAREA"),"N",3,0)+", ";
          m_cSql = m_cSql+"RATTIV = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("RATTIV"),"N",3,0)+", ";
          m_cSql = m_cSql+"RCOMP = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("RCOMP"),"N",3,0)+", ";
          m_cSql = m_cSql+"RNATGIU = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("RNATGIU"),"N",3,0)+", ";
          m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SESSO"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"SETTSINT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"SOSPMAF = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOSPMAF"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"SOTGRUP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SOTGRUP"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"SPOTID = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SPOTID"),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPINTER"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPODOC"),"C",2,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOPERS"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"SETTSINT2 = "+CPLib.ToSQL(Cursor_wersonbo.GetString("SETTSINT2"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"FATCA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("FATCA"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"BANCABEN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("BANCABEN"),"C",11,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIN"),"C",16,0,m_cServer)+", ";
          m_cSql = m_cSql+"ODB = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("ODB"),"N",1,0)+", ";
          m_cSql = m_cSql+"TELEF = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TELEF"),"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"TIPOORO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("TIPOORO"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CODORO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CODORO"),"C",11,0,m_cServer)+", ";
          m_cSql = m_cSql+"IDNASCOMUN = "+CPLib.ToSQL(Cursor_wersonbo.GetString("IDNASCOMUN"),"C",40,0,m_cServer)+", ";
          m_cSql = m_cSql+"IDNASSTATO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("IDNASSTATO"),"C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOTIT = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("NOTIT"),"N",1,0)+", ";
          m_cSql = m_cSql+"IDBASE = "+CPLib.ToSQL(Cursor_wersonbo.GetString("IDBASE"),"C",10,0,m_cServer)+", ";
          m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL(Cursor_wersonbo.GetString("FLGVALIDO"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CITTADIN1 = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CITTADIN1"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"CITTADIN2 = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CITTADIN2"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"RESFISC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RESFISC"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"MITIG = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("MITIG"),"N",4,0)+", ";
          m_cSql = m_cSql+"MITIGDOC = "+CPLib.ToSQL(Cursor_wersonbo.GetString("MITGDOC"),"C",100,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOSARA = "+CPLib.ToSQL(Cursor_wersonbo.GetString("NOSARA"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"RISGLOB = "+CPLib.ToSQL(Cursor_wersonbo.GetString("RISGLOB"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"DATAPROF = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAPROF"),"D",8,0)+", ";
          m_cSql = m_cSql+"DATAREVPRO = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("DATAREVPROF"),"D",0,0)+", ";
          m_cSql = m_cSql+"IDENT = "+CPLib.ToSQL(Cursor_wersonbo.GetString("IDENT"),"C",3,0,m_cServer)+", ";
          m_cSql = m_cSql+"PEPDATE = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("PEPDATE"),"D",8,0)+", ";
          m_cSql = m_cSql+"DAC6 = "+CPLib.ToSQL(Cursor_wersonbo.GetString("DAC6"),"C",100,0,m_cServer)+", ";
          m_cSql = m_cSql+"FLAGDAC6 = "+CPLib.ToSQL(Cursor_wersonbo.GetDouble("FLAGDAC6"),"N",1,0)+", ";
          m_cSql = m_cSql+"CRIME = "+CPLib.ToSQL(Cursor_wersonbo.GetString("CRIME"),"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CRIMEDATE = "+CPLib.ToSQL(Cursor_wersonbo.GetDate("CRIMEDATE"),"D",8,0)+", ";
          m_cSql = m_cSql+"ALTRODOM = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ALTRODOM"),"C",35,0,m_cServer)+", ";
          m_cSql = m_cSql+"ALTROCAP = "+CPLib.ToSQL(Cursor_wersonbo.GetString("ALTROCAP"),"C",9,0,m_cServer)+", ";
          m_cSql = m_cSql+"NUMIMP = "+CPLib.ToSQL(Cursor_wersonbo.GetDateTime("NUMIMP"),"T",14,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_personbo.GetString("CONNES"))+"";
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
          // * --- Delete from wersonbo
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("wersonbo");
          m_cPhName = m_Ctx.GetPhName("wersonbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_delete_import_prov",34,"00000051")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"sanumpro = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wersonbo.GetString("sanumpro"),"?",0,0,m_cServer),m_cServer,Cursor_wersonbo.GetString("sanumpro"))+"";
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
          Cursor_wersonbo.Next();
        }
        m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
        Cursor_wersonbo.Close();
        // * --- End Select
        /* If not(trovato_in_wesonbo) */
        if ( ! (trovato_in_wesonbo)) {
          /* Se non lo trovo zappo in personbo */
          double nTry00000055status;
          nTry00000055status = m_Sql.GetTransactionStatus();
          String cTry00000055msg;
          cTry00000055msg = m_Sql.TransactionErrorMessage();
          try {
            /* w_CONNES := personbo->CONNES */
            w_CONNES = Cursor_personbo.GetString("CONNES");
            /* Exec Routine arrt_delpersonbo(w_CONNES) */
            arrt_delpersonboR.Make(m_Ctx,this).Run(w_CONNES);
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* gMsgProc := gMsgProc + 'Soggetto non eliminabile - Codice di collegamento: '+w_CONNES+ NL */
            gMsgProc = gMsgProc+"Soggetto non eliminabile - Codice di collegamento: "+w_CONNES+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000055status,0)) {
              m_Sql.SetTransactionStatus(nTry00000055status,cTry00000055msg);
            }
          }
          /* trovato_in_wesonbo := False */
          trovato_in_wesonbo = false;
        } // End If
        Cursor_personbo.Next();
      }
      m_cConnectivityError = Cursor_personbo.ErrorMessage();
      Cursor_personbo.Close();
      // * --- End Select
      /* CASO 3 */
      // * --- Select from wersonbo
      m_cServer = m_Ctx.GetServer("wersonbo");
      m_cPhName = m_Ctx.GetPhName("wersonbo");
      if (Cursor_wersonbo!=null)
        Cursor_wersonbo.Close();
      Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"NUMIMP="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_numimp,"?",0,0,m_cServer, m_oParameters),m_cServer,w_numimp)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_wersonbo.Eof())) {
        double nTry0000005Cstatus;
        nTry0000005Cstatus = m_Sql.GetTransactionStatus();
        String cTry0000005Cmsg;
        cTry0000005Cmsg = m_Sql.TransactionErrorMessage();
        try {
          /* w_CONNES := wersonbo->CONNES */
          w_CONNES = Cursor_wersonbo.GetString("CONNES");
          /* Exec Routine arrt_delpersonbo(w_CONNES) */
          arrt_delpersonboR.Make(m_Ctx,this).Run(w_CONNES);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* gMsgProc := gMsgProc + 'Soggetto non eliminabile - Codice di collegamento: '+w_CONNES+ NL */
          gMsgProc = gMsgProc+"Soggetto non eliminabile - Codice di collegamento: "+w_CONNES+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000005Cstatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000005Cstatus,cTry0000005Cmsg);
          }
        }
        Cursor_wersonbo.Next();
      }
      m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
      Cursor_wersonbo.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Timestamp p_w_numimp) {
    w_numimp = p_w_numimp;
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
  public String Run(java.sql.Timestamp p_w_numimp) {
    w_numimp = p_w_numimp;
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
          main();
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
  public static arfn_delete_import_provR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_delete_import_provR(p_Ctx, p_Caller);
  }
  public static arfn_delete_import_provR Make(CPContext p_Ctx) {
    return new arfn_delete_import_provR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_numimp = CPLib.NullDateTime();
    dateTimeCancella = CPLib.NullDateTime();
    _result = "OK";
    _tabelle = CPLib.Space(0);
    _error = CPLib.Round(-1,0);
    mcFile = new MemoryCursor_mclistafile_mcrdef();
    tmp = CPLib.Space(0);
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_delete_import_prov,arrt_delpersonbo,
  public static final String i_InvokedRoutines = ",arfn_delete_import_prov,arrt_delpersonbo,";
  public static String[] m_cRunParameterNames={"w_numimp"};
}
