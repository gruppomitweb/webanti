// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_tit_auiR implements CallerWithObjs {
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
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tmp_tit_aui;
  public String m_cServer_tmp_tit_aui;
  public String m_cPhName_tmp_tit_aui_sel;
  public String m_cServer_tmp_tit_aui_sel;
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
  public String pTipo;
  public String pCliente;
  public String pMand;
  public String w_tito;
  public String w_mand;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_tit_auiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_tit_aui",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_tit_aui")) {
      m_cPhName_tmp_tit_aui = p_ContextObject.GetPhName("tmp_tit_aui");
      if (m_cPhName_tmp_tit_aui.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_tit_aui = m_cPhName_tmp_tit_aui+" "+m_Ctx.GetWritePhName("tmp_tit_aui");
      }
      m_cServer_tmp_tit_aui = p_ContextObject.GetServer("tmp_tit_aui");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_tit_aui_sel")) {
      m_cPhName_tmp_tit_aui_sel = p_ContextObject.GetPhName("tmp_tit_aui_sel");
      if (m_cPhName_tmp_tit_aui_sel.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_tit_aui_sel = m_cPhName_tmp_tit_aui_sel+" "+m_Ctx.GetWritePhName("tmp_tit_aui_sel");
      }
      m_cServer_tmp_tit_aui_sel = p_ContextObject.GetServer("tmp_tit_aui_sel");
    }
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
      return "arrt_tit_aui";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pCliente",p_cVarName)) {
      return pCliente;
    }
    if (CPLib.eqr("pMand",p_cVarName)) {
      return pMand;
    }
    if (CPLib.eqr("tito",p_cVarName)) {
      return w_tito;
    }
    if (CPLib.eqr("mand",p_cVarName)) {
      return w_mand;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pCliente",p_cVarName)) {
      pCliente = value;
      return;
    }
    if (CPLib.eqr("pMand",p_cVarName)) {
      pMand = value;
      return;
    }
    if (CPLib.eqr("tito",p_cVarName)) {
      w_tito = value;
      return;
    }
    if (CPLib.eqr("mand",p_cVarName)) {
      w_mand = value;
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
    CPResultSet Cursor_qbe_tit_aui=null;
    CPResultSet Cursor_qbe_tit_aui_sel=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pTipo Char(1) */
      /* pCliente Char(16) // Codice Cliente */
      /* pMand Char(25) // Mandato Fiduciario */
      /* w_tito Char(16) */
      /* w_mand Char(25) */
      /* Crea file appoggio */
      /* w_tito := pCliente */
      w_tito = pCliente;
      /* w_mand := pMand */
      w_mand = pMand;
      /* If pTipo='A' */
      if (CPLib.eqr(pTipo,"A")) {
        // * --- Drop temporary table tmp_tit_aui
        if (m_Ctx.IsSharedTemp("tmp_tit_aui")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_tit_aui")) {
            m_cServer = m_Ctx.GetServer("tmp_tit_aui");
            m_cPhName = m_Ctx.GetPhName("tmp_tit_aui");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_tit_aui");
        }
        // * --- Create temporary table tmp_tit_aui
        if (m_Ctx.IsSharedTemp("tmp_tit_aui")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_tit_aui")) {
            m_cServer = m_Ctx.GetServer("tmp_tit_aui");
            m_cPhName = m_Ctx.GetPhName("tmp_tit_aui");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_tit_aui");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_tit_aui");
        if ( ! (m_Ctx.IsSharedTemp("tmp_tit_aui"))) {
          m_cServer = m_Ctx.GetServer("tmp_tit_aui");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_tit_aui",m_cServer,"proto")),m_cPhName,"tmp_tit_aui",m_Ctx);
        }
        m_cPhName_tmp_tit_aui = m_cPhName;
        /* Cicla sulla query e crea il temporaneo */
        // * --- Select from qbe_tit_aui
        if (Cursor_qbe_tit_aui!=null)
          Cursor_qbe_tit_aui.Close();
        Cursor_qbe_tit_aui = new VQRHolder("qbe_tit_aui",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tit_aui.Eof())) {
          /* If qbe_tit_aui->TIPOOPRAP='50' or qbe_tit_aui->TIPOOPRAP='52' */
          if (CPLib.eqr(Cursor_qbe_tit_aui.GetString("TIPOOPRAP"),"50") || CPLib.eqr(Cursor_qbe_tit_aui.GetString("TIPOOPRAP"),"52")) {
            // * --- Insert into tmp_tit_aui from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_tit_aui");
            m_cPhName = m_Ctx.GetPhName("tmp_tit_aui");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_tit_aui",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_tit_aui",137,"00000011")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000011(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_tit_aui.GetString("RAGSOC"),70),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_tit_aui",true);
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
            /* ElseIf qbe_tit_aui->TIPOOPRAP='51' or qbe_tit_aui->TIPOOPRAP='53' */
          } else if (CPLib.eqr(Cursor_qbe_tit_aui.GetString("TIPOOPRAP"),"51") || CPLib.eqr(Cursor_qbe_tit_aui.GetString("TIPOOPRAP"),"53")) {
            // * --- Write into tmp_tit_aui from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_tit_aui");
            m_cPhName = m_Ctx.GetPhName("tmp_tit_aui");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_tit_aui",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_tit_aui",137,"00000012")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_qbe_tit_aui.GetDate("DATAOPE"),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_tit_aui",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_tit_aui.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_tit_aui.GetString("CONNESCLI"))+"";
            m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_tit_aui.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_tit_aui.GetString("CONNESOPER"))+"";
            m_cSql = m_cSql+" and RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_tit_aui.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_tit_aui.GetString("RAPPORTO"))+"";
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
          Cursor_qbe_tit_aui.Next();
        }
        m_cConnectivityError = Cursor_qbe_tit_aui.ErrorMessage();
        Cursor_qbe_tit_aui.Close();
        // * --- End Select
        /* Stop arpg_intestit */
        Forward f;
        f=new Forward("arpg_intestit",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
        /* ElseIf pTipo='S' */
      } else if (CPLib.eqr(pTipo,"S")) {
        // * --- Drop temporary table tmp_tit_aui_sel
        if (m_Ctx.IsSharedTemp("tmp_tit_aui_sel")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_tit_aui_sel")) {
            m_cServer = m_Ctx.GetServer("tmp_tit_aui_sel");
            m_cPhName = m_Ctx.GetPhName("tmp_tit_aui_sel");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_tit_aui_sel");
        }
        // * --- Create temporary table tmp_tit_aui_sel
        if (m_Ctx.IsSharedTemp("tmp_tit_aui_sel")) {
          if (m_Ctx.IsTmpAlreadyCreated("tmp_tit_aui_sel")) {
            m_cServer = m_Ctx.GetServer("tmp_tit_aui_sel");
            m_cPhName = m_Ctx.GetPhName("tmp_tit_aui_sel");
            m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
            m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
          }
        } else {
          m_Ctx.DropTmp("tmp_tit_aui_sel");
        }
        m_cPhName = m_Ctx.CreateTmpPhName("tmp_tit_aui_sel");
        if ( ! (m_Ctx.IsSharedTemp("tmp_tit_aui_sel"))) {
          m_cServer = m_Ctx.GetServer("tmp_tit_aui_sel");
          m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_tit_aui_sel",m_cServer,"proto")),m_cPhName,"tmp_tit_aui_sel",m_Ctx);
        }
        m_cPhName_tmp_tit_aui_sel = m_cPhName;
        /* Cicla sulla query e crea il temporaneo */
        // * --- Select from qbe_tit_aui_sel
        SPBridge.HMCaller _h00000017;
        _h00000017 = new SPBridge.HMCaller();
        _h00000017.Set("m_cVQRList",m_cVQRList);
        _h00000017.Set("tito",w_tito);
        _h00000017.Set("mand",w_mand);
        if (Cursor_qbe_tit_aui_sel!=null)
          Cursor_qbe_tit_aui_sel.Close();
        Cursor_qbe_tit_aui_sel = new VQRHolder("qbe_tit_aui_sel",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000017,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tit_aui_sel.Eof())) {
          /* If qbe_tit_aui_sel->TIPOOPRAP='50' or qbe_tit_aui_sel->TIPOOPRAP='52' */
          if (CPLib.eqr(Cursor_qbe_tit_aui_sel.GetString("TIPOOPRAP"),"50") || CPLib.eqr(Cursor_qbe_tit_aui_sel.GetString("TIPOOPRAP"),"52")) {
            // * --- Insert into tmp_tit_aui_sel from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_tit_aui_sel");
            m_cPhName = m_Ctx.GetPhName("tmp_tit_aui_sel");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_tit_aui_sel",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_tit_aui",137,"00000019")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000019(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui_sel.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui_sel.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_qbe_tit_aui_sel.GetString("RAGSOC"),70),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui_sel.GetDate("DATAOPE"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui_sel.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_tit_aui_sel.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_tit_aui_sel",true);
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
            /* ElseIf qbe_tit_aui_sel->TIPOOPRAP='51' or qbe_tit_aui_sel->TIPOOPRAP='53' */
          } else if (CPLib.eqr(Cursor_qbe_tit_aui_sel.GetString("TIPOOPRAP"),"51") || CPLib.eqr(Cursor_qbe_tit_aui_sel.GetString("TIPOOPRAP"),"53")) {
            // * --- Write into tmp_tit_aui_sel from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_tit_aui_sel");
            m_cPhName = m_Ctx.GetPhName("tmp_tit_aui_sel");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_tit_aui_sel",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_tit_aui",137,"0000001A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"DATAFINE = "+CPLib.ToSQL(Cursor_qbe_tit_aui_sel.GetDate("DATAOPE"),"D",8,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_tit_aui_sel",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODCLI = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_tit_aui_sel.GetString("CONNESCLI"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_tit_aui_sel.GetString("CONNESCLI"))+"";
            m_cSql = m_cSql+" and CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_tit_aui_sel.GetString("CONNESOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_tit_aui_sel.GetString("CONNESOPER"))+"";
            m_cSql = m_cSql+" and RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_tit_aui_sel.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_tit_aui_sel.GetString("RAPPORTO"))+"";
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
          Cursor_qbe_tit_aui_sel.Next();
        }
        m_cConnectivityError = Cursor_qbe_tit_aui_sel.ErrorMessage();
        Cursor_qbe_tit_aui_sel.Close();
        // * --- End Select
        /* Stop arpg_intestit_sel */
        Forward f;
        f=new Forward("arpg_intestit_sel",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_qbe_tit_aui!=null)
          Cursor_qbe_tit_aui.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tit_aui_sel!=null)
          Cursor_qbe_tit_aui_sel.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo,String p_pCliente,String p_pMand) {
    pTipo = p_pTipo;
    pCliente = p_pCliente;
    pMand = p_pMand;
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
  public Forward Run(String p_pTipo,String p_pCliente,String p_pMand) {
    pTipo = p_pTipo;
    pCliente = p_pCliente;
    pMand = p_pMand;
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
  public static arrt_tit_auiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_tit_auiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    pCliente = CPLib.Space(16);
    pMand = CPLib.Space(25);
    w_tito = CPLib.Space(16);
    w_mand = CPLib.Space(25);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tit_aui,qbe_tit_aui_sel,
  public static final String m_cVQRList = ",qbe_tit_aui,qbe_tit_aui_sel,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pTipo","pCliente","pMand"};
  protected static String GetFieldsName_00000011(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCLI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_tit_aui",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000019(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODCLI,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_tit_aui_sel",true);
    return p_cSql;
  }
}
