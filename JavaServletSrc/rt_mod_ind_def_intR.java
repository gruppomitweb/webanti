// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class rt_mod_ind_def_intR implements CallerWithObjs {
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
  public String m_cPhName_mod_ind_def;
  public String m_cServer_mod_ind_def;
  public String m_cPhName_mod_ind_mit;
  public String m_cServer_mod_ind_mit;
  public String m_cPhName_ind_mit;
  public String m_cServer_ind_mit;
  public String m_cPhName_sub_ind_mit;
  public String m_cServer_sub_ind_mit;
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
  public String p_cEventName;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public rt_mod_ind_def_intR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("rt_mod_ind_def_int",m_Caller);
    m_cPhName_mod_ind_def = p_ContextObject.GetPhName("mod_ind_def");
    if (m_cPhName_mod_ind_def.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mod_ind_def = m_cPhName_mod_ind_def+" "+m_Ctx.GetWritePhName("mod_ind_def");
    }
    m_cServer_mod_ind_def = p_ContextObject.GetServer("mod_ind_def");
    m_cPhName_mod_ind_mit = p_ContextObject.GetPhName("mod_ind_mit");
    if (m_cPhName_mod_ind_mit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mod_ind_mit = m_cPhName_mod_ind_mit+" "+m_Ctx.GetWritePhName("mod_ind_mit");
    }
    m_cServer_mod_ind_mit = p_ContextObject.GetServer("mod_ind_mit");
    m_cPhName_ind_mit = p_ContextObject.GetPhName("ind_mit");
    if (m_cPhName_ind_mit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_ind_mit = m_cPhName_ind_mit+" "+m_Ctx.GetWritePhName("ind_mit");
    }
    m_cServer_ind_mit = p_ContextObject.GetServer("ind_mit");
    m_cPhName_sub_ind_mit = p_ContextObject.GetPhName("sub_ind_mit");
    if (m_cPhName_sub_ind_mit.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sub_ind_mit = m_cPhName_sub_ind_mit+" "+m_Ctx.GetWritePhName("sub_ind_mit");
    }
    m_cServer_sub_ind_mit = p_ContextObject.GetServer("sub_ind_mit");
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
      return "rt_mod_ind_def_int";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("p_cEventName",p_cVarName)) {
      return p_cEventName;
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
    if (CPLib.eqr("p_cEventName",p_cVarName)) {
      p_cEventName = value;
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
    CPResultSet Cursor_mod_ind_def=null;
    CPResultSet Cursor_mod_ind_mit=null;
    CPResultSet Cursor_ind_mit=null;
    CPResultSet Cursor_sub_ind_mit=null;
    try {
      /* p_cEventName Char(0) */
      /* obj2 Object(CallerBRImpl) */
      CallerBRImpl obj2;
      obj2 = null;
      /* obj2 := Utilities.GetCallerBO() */
      obj2 = Utilities.Make(m_Ctx,m_Caller).GetCallerBO();
      /* idmod_old Char(0) := '0000000001' // id del vecchio modello del cliente */
      String idmod_old;
      idmod_old = "0000000001";
      /* idmod_new Char(0) := '0000000001' // id del nuovo modello del cliente */
      String idmod_new;
      idmod_new = "0000000001";
      /* idmod_mit Char(0) := '0000000001' // id del modello mit */
      String idmod_mit;
      idmod_mit = "0000000001";
      /* _find Bool := False // Trovato il indicatore */
      boolean _find;
      _find = false;
      /* _findsub Bool := False // Trovato il subindicatore */
      boolean _findsub;
      _findsub = false;
      /* obj Object(aosmt_mod_ind_defBO) */
      aosmt_mod_ind_defBO obj;
      obj = null;
      /* obj := (aosmt_mod_ind_defBO) obj2 */
      obj = (aosmt_mod_ind_defBO) obj2;
      /* obj_old Object(aosmt_mod_ind_defBO) */
      aosmt_mod_ind_defBO obj_old;
      obj_old = null;
      /* obj_old := new aosmt_mod_ind_defBO() */
      obj_old = new aosmt_mod_ind_defBO(m_Ctx);
      // * --- Select from mod_ind_def
      m_cServer = m_Ctx.GetServer("mod_ind_def");
      m_cPhName = m_Ctx.GetPhName("mod_ind_def");
      if (Cursor_mod_ind_def!=null)
        Cursor_mod_ind_def.Close();
      Cursor_mod_ind_def = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDMOD  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("mod_ind_def")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"IDMOD DESC ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_mod_ind_def.Eof())) {
        /* idmod_old := mod_ind_def->IDMOD // id del vecchio modello del cliente */
        idmod_old = Cursor_mod_ind_def.GetString("IDMOD");
        /* idmod_new := Right('0000000000'+LRTrim(Str(Val(mod_ind_def->IDMOD)+1,10,0)),10) // id del nuovo modello del cliente */
        idmod_new = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(CPLib.Val(Cursor_mod_ind_def.GetString("IDMOD"))+1,10,0)),10);
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_mod_ind_def.Next();
      }
      m_cConnectivityError = Cursor_mod_ind_def.ErrorMessage();
      Cursor_mod_ind_def.Close();
      // * --- End Select
      // * --- Select from mod_ind_mit
      m_cServer = m_Ctx.GetServer("mod_ind_mit");
      m_cPhName = m_Ctx.GetPhName("mod_ind_mit");
      if (Cursor_mod_ind_mit!=null)
        Cursor_mod_ind_mit.Close();
      Cursor_mod_ind_mit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDMOD,DESCRI  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("mod_ind_mit")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"IDMOD DESC,DESCRI ",m_cServer,m_Ctx,true));
      while ( ! (Cursor_mod_ind_mit.Eof())) {
        /* idmod_mit := mod_ind_mit->IDMOD // id del modello mit */
        idmod_mit = Cursor_mod_ind_mit.GetString("IDMOD");
        /* obj.Initialize() */
        obj.Initialize();
        /* obj.Set_IDMOD(idmod_new) */
        obj.Set_IDMOD(idmod_new);
        /* obj.Set_IDMODMIT(idmod_mit) */
        obj.Set_IDMODMIT(idmod_mit);
        /* obj.Set_DESCRI(mod_ind_mit->DESCRI) */
        obj.Set_DESCRI(Cursor_mod_ind_mit.GetString("DESCRI"));
        /* obj.Calculate() */
        obj.Calculate();
        /* obj.Check() */
        obj.Check();
        // Exit Loop
        if (true) {
          break;
        }
        Cursor_mod_ind_mit.Next();
      }
      m_cConnectivityError = Cursor_mod_ind_mit.ErrorMessage();
      Cursor_mod_ind_mit.Close();
      // * --- End Select
      /* If IsNull(obj.LastErrorMessage()) */
      if (CPLib.IsNull(obj.LastErrorMessage())) {
        /* obj.CtxLoad_aosdt_ind_def() */
        obj.CtxLoad_aosdt_ind_def();
        // * --- Select from ind_mit
        m_cServer = m_Ctx.GetServer("ind_mit");
        m_cPhName = m_Ctx.GetPhName("ind_mit");
        if (Cursor_ind_mit!=null)
          Cursor_ind_mit.Close();
        Cursor_ind_mit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDMOD="+CPSql.SQLValueAdapter(CPLib.ToSQL(idmod_mit,"?",0,0,m_cServer, m_oParameters),m_cServer,idmod_mit)+" "+")"+(m_Ctx.IsSharedTemp("ind_mit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"PROGIND ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_ind_mit.Eof())) {
          /* obj.aosdt_ind_def.AddRow() */
          obj.aosdt_ind_def.AddRow();
          /* obj.aosdt_ind_def.Set_IDMOD(idmod_new) */
          obj.aosdt_ind_def.Set_IDMOD(idmod_new);
          /* obj.aosdt_ind_def.Set_IDIND(ind_mit->IDIND) */
          obj.aosdt_ind_def.Set_IDIND(Cursor_ind_mit.GetString("IDIND"));
          /* obj.aosdt_ind_def.Set_PROGIND(ind_mit->PROGIND) */
          obj.aosdt_ind_def.Set_PROGIND(Cursor_ind_mit.GetString("PROGIND"));
          /* obj.aosdt_ind_def.Set_DESCRI(ind_mit->DESCRI) */
          obj.aosdt_ind_def.Set_DESCRI(Cursor_ind_mit.GetString("DESCRI"));
          /* obj.aosdt_ind_def.Set_LOCKMIT(True) */
          obj.aosdt_ind_def.Set_LOCKMIT(true);
          /* obj.aosdt_ind_def.SaveRow() */
          obj.aosdt_ind_def.SaveRow();
          /* obj.aosdt_ind_def.CtxLoad_aosdt_sub_ind_def() */
          obj.aosdt_ind_def.CtxLoad_aosdt_sub_ind_def();
          // * --- Select from sub_ind_mit
          m_cServer = m_Ctx.GetServer("sub_ind_mit");
          m_cPhName = m_Ctx.GetPhName("sub_ind_mit");
          if (Cursor_sub_ind_mit!=null)
            Cursor_sub_ind_mit.Close();
          Cursor_sub_ind_mit = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDMOD="+CPSql.SQLValueAdapter(CPLib.ToSQL(idmod_mit,"?",0,0,m_cServer, m_oParameters),m_cServer,idmod_mit)+"  and  IDIND="+CPLib.ToSQL(Cursor_ind_mit.GetString("IDIND"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sub_ind_mit")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"PROGSUBIND ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_sub_ind_mit.Eof())) {
            /* obj.aosdt_ind_def.aosdt_sub_ind_def.AddRow() */
            obj.aosdt_ind_def.aosdt_sub_ind_def.AddRow();
            /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDMOD(idmod_new) */
            obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDMOD(idmod_new);
            /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDIND(sub_ind_mit->IDIND) */
            obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDIND(Cursor_sub_ind_mit.GetString("IDIND"));
            /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDSUBIND(sub_ind_mit->IDSUBIND) */
            obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDSUBIND(Cursor_sub_ind_mit.GetString("IDSUBIND"));
            /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PROGSUBIND(sub_ind_mit->PROGSUBIND) */
            obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PROGSUBIND(Cursor_sub_ind_mit.GetString("PROGSUBIND"));
            /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_DESCRI(sub_ind_mit->DESCRI) */
            obj.aosdt_ind_def.aosdt_sub_ind_def.Set_DESCRI(Cursor_sub_ind_mit.GetString("DESCRI"));
            /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_LOCKMIT(True) */
            obj.aosdt_ind_def.aosdt_sub_ind_def.Set_LOCKMIT(true);
            /* obj.aosdt_ind_def.aosdt_sub_ind_def.SaveRow() */
            obj.aosdt_ind_def.aosdt_sub_ind_def.SaveRow();
            Cursor_sub_ind_mit.Next();
          }
          m_cConnectivityError = Cursor_sub_ind_mit.ErrorMessage();
          Cursor_sub_ind_mit.Close();
          // * --- End Select
          Cursor_ind_mit.Next();
        }
        m_cConnectivityError = Cursor_ind_mit.ErrorMessage();
        Cursor_ind_mit.Close();
        // * --- End Select
      } // End If
      /* If obj_old.Load(idmod_old) */
      if (obj_old.Load(idmod_old)) {
        /* obj_old.CtxLoad_aosdt_ind_def() */
        obj_old.CtxLoad_aosdt_ind_def();
        /* obj_old.aosdt_ind_def.SetRow(0) */
        obj_old.aosdt_ind_def.SetRow(0);
        /* While obj_old.aosdt_ind_def.CurrentRow()<obj_old.aosdt_ind_def.Rows() */
        while (CPLib.lt(obj_old.aosdt_ind_def.CurrentRow(),obj_old.aosdt_ind_def.Rows())) {
          /* obj.CtxLoad_aosdt_ind_def() */
          obj.CtxLoad_aosdt_ind_def();
          /* obj.aosdt_ind_def.SetRow(0) */
          obj.aosdt_ind_def.SetRow(0);
          /* _find := False // Trovato il indicatore */
          _find = false;
          /* While obj.aosdt_ind_def.CurrentRow()<obj.aosdt_ind_def.Rows() */
          while (CPLib.lt(obj.aosdt_ind_def.CurrentRow(),obj.aosdt_ind_def.Rows())) {
            /* If obj.aosdt_ind_def.w_IDIND=obj_old.aosdt_ind_def.w_IDIND */
            if (CPLib.eqr(obj.aosdt_ind_def.w_IDIND,obj_old.aosdt_ind_def.w_IDIND)) {
              /* _find := True // Trovato il indicatore */
              _find = true;
              /* obj.aosdt_ind_def.Set_NOAPPLIC(obj_old.aosdt_ind_def.w_NOAPPLIC) */
              obj.aosdt_ind_def.Set_NOAPPLIC(obj_old.aosdt_ind_def.w_NOAPPLIC);
              /* obj.aosdt_ind_def.SaveRow() */
              obj.aosdt_ind_def.SaveRow();
              /* obj_old.aosdt_ind_def.CtxLoad_aosdt_sub_ind_def() */
              obj_old.aosdt_ind_def.CtxLoad_aosdt_sub_ind_def();
              /* obj_old.aosdt_ind_def.aosdt_sub_ind_def.SetRow(0) */
              obj_old.aosdt_ind_def.aosdt_sub_ind_def.SetRow(0);
              /* _findsub := False // Trovato il subindicatore */
              _findsub = false;
              /* While obj_old.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow()<obj_old.aosdt_ind_def.aosdt_sub_ind_def.Rows() */
              while (CPLib.lt(obj_old.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow(),obj_old.aosdt_ind_def.aosdt_sub_ind_def.Rows())) {
                /* obj.aosdt_ind_def.CtxLoad_aosdt_sub_ind_def() */
                obj.aosdt_ind_def.CtxLoad_aosdt_sub_ind_def();
                /* obj.aosdt_ind_def.aosdt_sub_ind_def.SetRow(0) */
                obj.aosdt_ind_def.aosdt_sub_ind_def.SetRow(0);
                /* While obj.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow()<obj.aosdt_ind_def.aosdt_sub_ind_def.Rows() */
                while (CPLib.lt(obj.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow(),obj.aosdt_ind_def.aosdt_sub_ind_def.Rows())) {
                  /* If obj_old.aosdt_ind_def.w_IDIND=obj.aosdt_ind_def.aosdt_sub_ind_def.w_IDIND and obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_IDSUBIND=obj.aosdt_ind_def.aosdt_sub_ind_def.w_IDSUBIND */
                  if (CPLib.eqr(obj_old.aosdt_ind_def.w_IDIND,obj.aosdt_ind_def.aosdt_sub_ind_def.w_IDIND) && CPLib.eqr(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_IDSUBIND,obj.aosdt_ind_def.aosdt_sub_ind_def.w_IDSUBIND)) {
                    /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_NOAPPLIC(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_NOAPPLIC) */
                    obj.aosdt_ind_def.aosdt_sub_ind_def.Set_NOAPPLIC(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_NOAPPLIC);
                    /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PESO(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PESO) */
                    obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PESO(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PESO);
                    /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_INDRISCH(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_INDRISCH) */
                    obj.aosdt_ind_def.aosdt_sub_ind_def.Set_INDRISCH(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_INDRISCH);
                    /* obj.aosdt_ind_def.aosdt_sub_ind_def.SaveRow() */
                    obj.aosdt_ind_def.aosdt_sub_ind_def.SaveRow();
                    /* _findsub := True // Trovato il subindicatore */
                    _findsub = true;
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                  /* If not(obj.aosdt_ind_def.aosdt_sub_ind_def.SetRow(obj.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow()+1)) */
                  if ( ! (obj.aosdt_ind_def.aosdt_sub_ind_def.SetRow(obj.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow()+1))) {
                    /* If not(_findsub) */
                    if ( ! (_findsub)) {
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.AddRow() */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.AddRow();
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDMOD(idmod_new) */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDMOD(idmod_new);
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDIND(obj_old.aosdt_ind_def.w_IDIND) */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDIND(obj_old.aosdt_ind_def.w_IDIND);
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDSUBIND(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_IDSUBIND) */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDSUBIND(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_IDSUBIND);
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PROGSUBIND(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PROGSUBIND) */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PROGSUBIND(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PROGSUBIND);
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_DESCRI(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_DESCRI) */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.Set_DESCRI(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_DESCRI);
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_LOCKMIT(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_LOCKMIT) */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.Set_LOCKMIT(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_LOCKMIT);
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_NOAPPLIC(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_NOAPPLIC) */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.Set_NOAPPLIC(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_NOAPPLIC);
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PESO(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PESO) */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PESO(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PESO);
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_INDRISCH(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_INDRISCH) */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.Set_INDRISCH(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_INDRISCH);
                      /* obj.aosdt_ind_def.aosdt_sub_ind_def.SaveRow() */
                      obj.aosdt_ind_def.aosdt_sub_ind_def.SaveRow();
                    } // End If
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                } // End While
                /* If not(obj_old.aosdt_ind_def.aosdt_sub_ind_def.SetRow(obj_old.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow()+1)) */
                if ( ! (obj_old.aosdt_ind_def.aosdt_sub_ind_def.SetRow(obj_old.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow()+1))) {
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } // End If
              } // End While
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
            /* If not(obj.aosdt_ind_def.SetRow(obj.aosdt_ind_def.CurrentRow()+1)) */
            if ( ! (obj.aosdt_ind_def.SetRow(obj.aosdt_ind_def.CurrentRow()+1))) {
              /* If not(_find) */
              if ( ! (_find)) {
                /* obj.aosdt_ind_def.AddRow() */
                obj.aosdt_ind_def.AddRow();
                /* obj.aosdt_ind_def.Set_IDMOD(obj_old.aosdt_ind_def.w_IDMOD) */
                obj.aosdt_ind_def.Set_IDMOD(obj_old.aosdt_ind_def.w_IDMOD);
                /* obj.aosdt_ind_def.Set_IDIND(obj_old.aosdt_ind_def.w_IDIND) */
                obj.aosdt_ind_def.Set_IDIND(obj_old.aosdt_ind_def.w_IDIND);
                /* obj.aosdt_ind_def.Set_PROGIND(obj_old.aosdt_ind_def.w_PROGIND) */
                obj.aosdt_ind_def.Set_PROGIND(obj_old.aosdt_ind_def.w_PROGIND);
                /* obj.aosdt_ind_def.Set_DESCRI(obj_old.aosdt_ind_def.w_DESCRI) */
                obj.aosdt_ind_def.Set_DESCRI(obj_old.aosdt_ind_def.w_DESCRI);
                /* obj.aosdt_ind_def.Set_LOCKMIT(obj_old.aosdt_ind_def.w_LOCKMIT) */
                obj.aosdt_ind_def.Set_LOCKMIT(obj_old.aosdt_ind_def.w_LOCKMIT);
                /* obj.aosdt_ind_def.SaveRow() */
                obj.aosdt_ind_def.SaveRow();
                /* obj_old.aosdt_ind_def.CtxLoad_aosdt_sub_ind_def() */
                obj_old.aosdt_ind_def.CtxLoad_aosdt_sub_ind_def();
                /* obj_old.aosdt_ind_def.aosdt_sub_ind_def.SetRow(0) */
                obj_old.aosdt_ind_def.aosdt_sub_ind_def.SetRow(0);
                /* While obj_old.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow()<obj_old.aosdt_ind_def.aosdt_sub_ind_def.Rows() */
                while (CPLib.lt(obj_old.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow(),obj_old.aosdt_ind_def.aosdt_sub_ind_def.Rows())) {
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.AddRow() */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.AddRow();
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDMOD(idmod_new) */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDMOD(idmod_new);
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDIND(obj_old.aosdt_ind_def.w_IDIND) */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDIND(obj_old.aosdt_ind_def.w_IDIND);
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDSUBIND(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_IDSUBIND) */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.Set_IDSUBIND(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_IDSUBIND);
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PROGSUBIND(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PROGSUBIND) */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PROGSUBIND(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PROGSUBIND);
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_DESCRI(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_DESCRI) */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.Set_DESCRI(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_DESCRI);
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_LOCKMIT(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_LOCKMIT) */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.Set_LOCKMIT(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_LOCKMIT);
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_NOAPPLIC(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_NOAPPLIC) */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.Set_NOAPPLIC(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_NOAPPLIC);
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PESO(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PESO) */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.Set_PESO(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_PESO);
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.Set_INDRISCH(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_INDRISCH) */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.Set_INDRISCH(obj_old.aosdt_ind_def.aosdt_sub_ind_def.w_INDRISCH);
                  /* obj.aosdt_ind_def.aosdt_sub_ind_def.SaveRow() */
                  obj.aosdt_ind_def.aosdt_sub_ind_def.SaveRow();
                  /* If not(obj_old.aosdt_ind_def.aosdt_sub_ind_def.SetRow(obj_old.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow()+1)) */
                  if ( ! (obj_old.aosdt_ind_def.aosdt_sub_ind_def.SetRow(obj_old.aosdt_ind_def.aosdt_sub_ind_def.CurrentRow()+1))) {
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                } // End While
              } // End If
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          } // End While
          /* If not(obj_old.aosdt_ind_def.SetRow(obj_old.aosdt_ind_def.CurrentRow()+1)) */
          if ( ! (obj_old.aosdt_ind_def.SetRow(obj_old.aosdt_ind_def.CurrentRow()+1))) {
            // Exit Loop
            if (true) {
              break;
            }
          } // End If
        } // End While
      } // End If
    } finally {
      try {
        if (Cursor_mod_ind_def!=null)
          Cursor_mod_ind_def.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_mod_ind_mit!=null)
          Cursor_mod_ind_mit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_ind_mit!=null)
          Cursor_ind_mit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sub_ind_mit!=null)
          Cursor_sub_ind_mit.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_p_cEventName) {
    p_cEventName = p_p_cEventName;
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
  public Forward Run(String p_p_cEventName) {
    p_cEventName = p_p_cEventName;
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
  public static rt_mod_ind_def_intR Make(CPContext p_Ctx, Caller p_Caller) {
    return new rt_mod_ind_def_intR(p_Ctx, p_Caller);
  }
  public void Blank() {
    p_cEventName = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"p_cEventName"};
}
