// * --- Area Manuale = BO - Header
// * --- arrt_cgo_apitalk
import org.json.*;
import java.util.*;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
// * --- Fine Area Manuale
public class arrt_cgo_apitalkR implements CallerWithObjs {
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
  public com.zucchetti.sitepainter.api.FunctionApiResponse m_apiResponse;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_cpusers_add;
  public String m_cServer_cpusers_add;
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
  public String CODICE;
  public String operazione;
  public String anagrafica;
  public String tipogestione;
  public String sp_company;
  public String _method;
  public String _version;
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct _respons;
  public JSONObject _operazione;
  public JSONObject _anagrafica;
  public String _connescli;
  public String _ragsoc;
  public String _cognome;
  public String _nome;
  public armt_snai_operBO objDC;
  public armt_cgo_operBO objNO;
  public armt_cgo_oper_multi_dcBO objMC;
  public armt_cgo_oper_multiBO objMO;
  public List<String> lLista;
  public String _errmsg;
  public String _coddip;
  public String gCodDip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_apitalkR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_apitalk",m_Caller);
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_cpusers_add = p_ContextObject.GetPhName("cpusers_add");
    if (m_cPhName_cpusers_add.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpusers_add = m_cPhName_cpusers_add+" "+m_Ctx.GetWritePhName("cpusers_add");
    }
    m_cServer_cpusers_add = p_ContextObject.GetServer("cpusers_add");
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
      return "arrt_cgo_apitalk";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("CODICE",p_cVarName)) {
      return CODICE;
    }
    if (CPLib.eqr("operazione",p_cVarName)) {
      return operazione;
    }
    if (CPLib.eqr("anagrafica",p_cVarName)) {
      return anagrafica;
    }
    if (CPLib.eqr("tipogestione",p_cVarName)) {
      return tipogestione;
    }
    if (CPLib.eqr("sp_company",p_cVarName)) {
      return sp_company;
    }
    if (CPLib.eqr("_method",p_cVarName)) {
      return _method;
    }
    if (CPLib.eqr("_version",p_cVarName)) {
      return _version;
    }
    if (CPLib.eqr("_connescli",p_cVarName)) {
      return _connescli;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      return _cognome;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      return _nome;
    }
    if (CPLib.eqr("_errmsg",p_cVarName)) {
      return _errmsg;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
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
    if (CPLib.eqr("_respons",p_cVarName)) {
      return _respons;
    }
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("CODICE",p_cVarName)) {
      CODICE = value;
      return;
    }
    if (CPLib.eqr("operazione",p_cVarName)) {
      operazione = value;
      return;
    }
    if (CPLib.eqr("anagrafica",p_cVarName)) {
      anagrafica = value;
      return;
    }
    if (CPLib.eqr("tipogestione",p_cVarName)) {
      tipogestione = value;
      return;
    }
    if (CPLib.eqr("sp_company",p_cVarName)) {
      sp_company = value;
      return;
    }
    if (CPLib.eqr("_method",p_cVarName)) {
      _method = value;
      return;
    }
    if (CPLib.eqr("_version",p_cVarName)) {
      _version = value;
      return;
    }
    if (CPLib.eqr("_connescli",p_cVarName)) {
      _connescli = value;
      return;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      _cognome = value;
      return;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      _nome = value;
      return;
    }
    if (CPLib.eqr("_errmsg",p_cVarName)) {
      _errmsg = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
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
    if (CPLib.eqr("_respons",p_cVarName)) {
      _respons = value;
      return;
    }
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_personbo_agg=null;
    CPResultSet Read_Cursor=null;
    try {
      /* CODICE Char(0) // Codice */
      /* operazione Memo := "" // dati intervista */
      /* anagrafica Memo := "" // dati intervista */
      /* tipogestione Char(0) := "" // Tipo Gestione (DC - NO - MC - MO) */
      /* sp_company Char(0) := "" // Parametro */
      /* _method Char(0) // Metodo da esporre */
      /* _version Char(0) // Versione API */
      /* _respons JSON // Variabile di risposta */
      /* _operazione Object(JSONObject) */
      /* _anagrafica Object(JSONObject) */
      /* _connescli Char(0) */
      /* _ragsoc Char(0) */
      /* _cognome Char(0) */
      /* _nome Char(0) */
      /* objDC Object(armt_snai_operBO) */
      /* objNO Object(armt_cgo_operBO) */
      /* objMC Object(armt_cgo_oper_multi_dcBO) */
      /* objMO Object(armt_cgo_oper_multiBO) */
      /* lLista Object(List<String>) */
      /* _errmsg Char(0) */
      /* _coddip Char(6) */
      /* gCodDip Char(6) // Dipendenza */
      /* Case _method="GET" */
      if (CPLib.eqr(_method,"GET")) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(CODICE,"?",0,0,m_cServer, m_oParameters),m_cServer,CODICE)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        if ( ! (Cursor_personbo.Eof())) {
          while ( ! (Cursor_personbo.Eof())) {
            /* _respons.CONNESCLI := personbo->CONNES // NDG Soggetto */
            _respons.put("CONNESCLI",Cursor_personbo.GetString("CONNES"));
            /* _respons.RAGSOC := personbo->RAGSOC // Nominativo */
            _respons.put("RAGSOC",Cursor_personbo.GetString("RAGSOC"));
            /* _respons.COGNOME := personbo->COGNOME // Cognome */
            _respons.put("COGNOME",Cursor_personbo.GetString("COGNOME"));
            /* _respons.NOME := personbo->NOME */
            _respons.put("NOME",Cursor_personbo.GetString("NOME"));
            /* _respons.DESCCIT := personbo->DESCCIT */
            _respons.put("DESCCIT",Cursor_personbo.GetString("DESCCIT"));
            /* _respons.PROVINCIA := personbo->PROVINCIA */
            _respons.put("PROVINCIA",Cursor_personbo.GetString("PROVINCIA"));
            /* _respons.DOMICILIO := personbo->DOMICILIO */
            _respons.put("DOMICILIO",Cursor_personbo.GetString("DOMICILIO"));
            /* _respons.PAESE := personbo->PAESE */
            _respons.put("PAESE",Cursor_personbo.GetString("PAESE"));
            /* _respons.NASCOMUN := personbo->NASCOMUN */
            _respons.put("NASCOMUN",Cursor_personbo.GetString("NASCOMUN"));
            /* _respons.PROVNAS := personbo->TIPINTER */
            _respons.put("PROVNAS",Cursor_personbo.GetString("TIPINTER"));
            /* _respons.SESSO := personbo->SESSO */
            _respons.put("SESSO",Cursor_personbo.GetString("SESSO"));
            /* _respons.NASSTATO := personbo->NASSTATO */
            _respons.put("NASSTATO",Cursor_personbo.GetString("NASSTATO"));
            /* _respons.DATANASC := personbo->DATANASC */
            _respons.put("DATANASC",Cursor_personbo.GetDate("DATANASC"));
            /* _respons.TIPODOC := personbo->TIPODOC */
            _respons.put("TIPODOC",Cursor_personbo.GetString("TIPODOC"));
            /* _respons.NUMDOCUM := personbo->NUMDOCUM */
            _respons.put("NUMDOCUM",Cursor_personbo.GetString("NUMDOCUM"));
            /* _respons.DATARILASC := personbo->DATARILASC */
            _respons.put("DATARILASC",Cursor_personbo.GetDate("DATARILASC"));
            /* _respons.DATAVALI := personbo->DATAVALI */
            _respons.put("DATAVALI",Cursor_personbo.GetDate("DATAVALI"));
            /* _respons.PEP := 'N' */
            _respons.put("PEP","N");
            /* _respons.ATTIV := personbo->ATTIV */
            _respons.put("ATTIV",Cursor_personbo.GetString("ATTIV"));
            /* _respons.CODCAB := personbo->CODCAB */
            _respons.put("CODCAB",Cursor_personbo.GetString("CODCAB"));
            /* _respons.AUTRILASC := personbo->AUTRILASC */
            _respons.put("AUTRILASC",Cursor_personbo.GetString("AUTRILASC"));
            /* _respons.CAP := personbo->CAP */
            _respons.put("CAP",Cursor_personbo.GetString("CAP"));
            // * --- Select from personbo_agg
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            if (Cursor_personbo_agg!=null)
              Cursor_personbo_agg.Close();
            Cursor_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo_agg.Eof())) {
              /* _respons.RDCODAUT := personbo_agg->RDCODAUT */
              _respons.put("RDCODAUT",Cursor_personbo_agg.GetString("RDCODAUT"));
              /* _respons.RDLOCAUT := personbo_agg->RDLOCAUT */
              _respons.put("RDLOCAUT",Cursor_personbo_agg.GetString("RDLOCAUT"));
              /* _respons.NUMTEL := personbo_agg->NUMTEL */
              _respons.put("NUMTEL",Cursor_personbo_agg.GetString("NUMTEL"));
              Cursor_personbo_agg.Next();
            }
            m_cConnectivityError = Cursor_personbo_agg.ErrorMessage();
            Cursor_personbo_agg.Close();
            // * --- End Select
            Cursor_personbo.Next();
          }
          m_cConnectivityError = Cursor_personbo.ErrorMessage();
        } else {
          // No rows selected
          /* _respons.Esito := "Soggetto non presente in archivio con il codice fiscale " */
          _respons.put("Esito","Soggetto non presente in archivio con il codice fiscale ");
          /* Return _respons */
          throw new Stop(_respons).setHttpContentType("application/json").setHttpStatus(404);
        }
        Cursor_personbo.Close();
        // * --- End Select
        /* Return _respons */
        throw new Stop(_respons).setHttpContentType("application/json").setHttpStatus(200);
        /* Case _method="POST" */
      } else if (CPLib.eqr(_method,"POST")) {
        /* gCodDip := '' // Dipendenza */
        gCodDip = "";
        m_Ctx.SetGlobalString("gCodDip",gCodDip);
        // * --- Read from cpusers_add
        m_cServer = m_Ctx.GetServer("cpusers_add");
        m_cPhName = m_Ctx.GetPhName("cpusers_add");
        m_cSql = "";
        m_cSql = m_cSql+"CODE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Utilities.Make(m_Ctx,m_Caller).UserCode(),"N",10,0,m_cServer),m_cServer,Utilities.Make(m_Ctx,m_Caller).UserCode());
        if (m_Ctx.IsSharedTemp("cpusers_add")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          gCodDip = Read_Cursor.GetString("CODDIP");
          m_Ctx.SetGlobalString("gCodDip",gCodDip);
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cpusers_add into routine arrt_cgo_apitalk returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          gCodDip = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(LRTrim(operazione))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(operazione)))) {
          /* _operazione := new JSONObject(operazione) */
          _operazione = new JSONObject(operazione);
        } // End If
        /* _anagrafica := new JSONObject(anagrafica) */
        _anagrafica = new JSONObject(anagrafica);
        /* Case tipogestione='DC' */
        if (CPLib.eqr(tipogestione,"DC")) {
          /* Exec "Da Completare" Page 2:pagDC */
          pagDC();
          /* Case tipogestione='NO' */
        } else if (CPLib.eqr(tipogestione,"NO")) {
          /* Exec "Nuova Operazione" Page 3:pagNO */
          pagNO();
          /* Case tipogestione='MO' */
        } else if (CPLib.eqr(tipogestione,"MO")) {
          /* Exec "Nuova Operazione Multipla" Page 4:pagMO */
          pagMO();
          /* Case tipogestione='MC' */
        } else if (CPLib.eqr(tipogestione,"MC")) {
          /* Exec "Multipla da completare" Page 5:pagMC */
          pagMC();
        } // End Case
        /* If not(Empty(_errmsg)) */
        if ( ! (CPLib.Empty(_errmsg))) {
          /* _respons.Esito := _errmsg */
          _respons.put("Esito",_errmsg);
          /* Return _respons */
          throw new Stop(_respons).setHttpContentType("application/json").setHttpStatus(406);
        } // End If
        /* Return _respons */
        throw new Stop(_respons).setHttpContentType("application/json").setHttpStatus(202);
      } // End Case
    } finally {
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo_agg!=null)
          Cursor_personbo_agg.Close();
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
  void pagDC() throws Exception {
    /* objDC := new armt_snai_operBO() */
    objDC = new armt_snai_operBO(m_Ctx);
    /* objDC.Initialize() */
    objDC.Initialize();
    /* objDC.Load(CODICE) */
    objDC.Load(CODICE);
    /* objDC.Set_tipop('X') */
    objDC.Set_tipop("X");
    /* lLista := Stream.of("CFESTERO").collect(Collectors.toList()) */
    lLista = Stream.of("CFESTERO").collect(Collectors.toList());
    /* objDC.Set_CFESTERO(Val(fn_estraejson(_anagrafica,fn_creamc_json(lLista),""))) */
    objDC.Set_CFESTERO(CPLib.Val(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),"")));
    /* lLista := Stream.of("PEP").collect(Collectors.toList()) */
    lLista = Stream.of("PEP").collect(Collectors.toList());
    /* objDC.Set_PEP(fn_estraejson(_anagrafica,fn_creamc_json(lLista),"")) */
    objDC.Set_PEP(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* lLista := Stream.of("CODFISC").collect(Collectors.toList()) */
    lLista = Stream.of("CODFISC").collect(Collectors.toList());
    /* objDC.Set_CODFISC(fn_estraejson(_anagrafica,fn_creamc_json(lLista),"")) */
    objDC.Set_CODFISC(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* If objDC.w_CFESTERO=0 and not(Empty(objDC.w_CODFISC)) */
    if (CPLib.eqr(objDC.w_CFESTERO,0) &&  ! (CPLib.Empty(objDC.w_CODFISC))) {
      /* Exec Routine  arrt_cgo_read_codfisc(objDC,'I') */
       arrt_cgo_read_codfiscR.Make(m_Ctx,this).Run(objDC,"I");
    } // End If
    /* If objDC.w_ANA_FOUND='N' or objDC.w_CFESTERO=1 */
    if (CPLib.eqr(objDC.w_ANA_FOUND,"N") || CPLib.eqr(objDC.w_CFESTERO,1)) {
      /* lLista := Stream.of("COGNOME").collect(Collectors.toList()) */
      lLista = Stream.of("COGNOME").collect(Collectors.toList());
      /* objDC.Set_COGNOME(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_COGNOME)) */
      objDC.Set_COGNOME(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_COGNOME));
      /* lLista := Stream.of("NOME").collect(Collectors.toList()) */
      lLista = Stream.of("NOME").collect(Collectors.toList());
      /* objDC.Set_NOME(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_NOME)) */
      objDC.Set_NOME(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_NOME));
      /* lLista := Stream.of("NASCOMUN").collect(Collectors.toList()) */
      lLista = Stream.of("NASCOMUN").collect(Collectors.toList());
      /* objDC.Set_NASCOMUN(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_NASCOMUN)) */
      objDC.Set_NASCOMUN(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_NASCOMUN));
      /* lLista := Stream.of("NASSTATO").collect(Collectors.toList()) */
      lLista = Stream.of("NASSTATO").collect(Collectors.toList());
      /* objDC.Set_NASSTATO(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_NASSTATO)) */
      objDC.Set_NASSTATO(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_NASSTATO));
      /* lLista := Stream.of("SESSO").collect(Collectors.toList()) */
      lLista = Stream.of("SESSO").collect(Collectors.toList());
      /* objDC.Set_SESSO(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_SESSO)) */
      objDC.Set_SESSO(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_SESSO));
      /* lLista := Stream.of("DATANASC").collect(Collectors.toList()) */
      lLista = Stream.of("DATANASC").collect(Collectors.toList());
      /* objDC.Set_DATANASC(CharToDate(fn_estraejson(_anagrafica,fn_creamc_json(lLista),DateToChar(objDC.w_DATANASC)))) */
      objDC.Set_DATANASC(CPLib.CharToDate(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),CPLib.DateToChar(objDC.w_DATANASC))));
      /* If objDC.w_CFESTERO=1 */
      if (CPLib.eqr(objDC.w_CFESTERO,1)) {
        /* Exec Routine  arrt_cgo_read_codfisc(objDC,'E') */
         arrt_cgo_read_codfiscR.Make(m_Ctx,this).Run(objDC,"E");
      } // End If
    } // End If
    /* lLista := Stream.of("PAESE").collect(Collectors.toList()) */
    lLista = Stream.of("PAESE").collect(Collectors.toList());
    /* objDC.Set_PAESE(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_PAESE)) */
    objDC.Set_PAESE(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_PAESE));
    /* lLista := Stream.of("DESCCIT").collect(Collectors.toList()) */
    lLista = Stream.of("DESCCIT").collect(Collectors.toList());
    /* objDC.Set_DESCCIT(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_DESCCIT)) */
    objDC.Set_DESCCIT(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_DESCCIT));
    /* lLista := Stream.of("PROVINCIA").collect(Collectors.toList()) */
    lLista = Stream.of("PROVINCIA").collect(Collectors.toList());
    /* objDC.Set_PROVINCIA(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_PROVINCIA)) */
    objDC.Set_PROVINCIA(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_PROVINCIA));
    /* lLista := Stream.of("CAP").collect(Collectors.toList()) */
    lLista = Stream.of("CAP").collect(Collectors.toList());
    /* objDC.Set_CAP(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_CAP)) */
    objDC.Set_CAP(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_CAP));
    /* lLista := Stream.of("DOMICILIO").collect(Collectors.toList()) */
    lLista = Stream.of("DOMICILIO").collect(Collectors.toList());
    /* objDC.Set_DOMICILIO(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_DOMICILIO)) */
    objDC.Set_DOMICILIO(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_DOMICILIO));
    /* lLista := Stream.of("NUMTEL").collect(Collectors.toList()) */
    lLista = Stream.of("NUMTEL").collect(Collectors.toList());
    /* objDC.Set_NUMTEL(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_NUMTEL)) */
    objDC.Set_NUMTEL(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_NUMTEL));
    /* lLista := Stream.of("FLGDOM").collect(Collectors.toList()) */
    lLista = Stream.of("FLGDOM").collect(Collectors.toList());
    /* objDC.Set_FLGDOM(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_FLGDOM)) */
    objDC.Set_FLGDOM(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_FLGDOM));
    /* lLista := Stream.of("PAESE2").collect(Collectors.toList()) */
    lLista = Stream.of("PAESE2").collect(Collectors.toList());
    /* objDC.Set_PAESE2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_PAESE2)) */
    objDC.Set_PAESE2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_PAESE2));
    /* lLista := Stream.of("DESCCIT2").collect(Collectors.toList()) */
    lLista = Stream.of("DESCCIT2").collect(Collectors.toList());
    /* objDC.Set_DESCCIT2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_DESCCIT2)) */
    objDC.Set_DESCCIT2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_DESCCIT2));
    /* lLista := Stream.of("PROVINCIA2").collect(Collectors.toList()) */
    lLista = Stream.of("PROVINCIA2").collect(Collectors.toList());
    /* objDC.Set_PROVINCIA2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_PROVINCIA2)) */
    objDC.Set_PROVINCIA2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_PROVINCIA2));
    /* lLista := Stream.of("CAP2").collect(Collectors.toList()) */
    lLista = Stream.of("CAP2").collect(Collectors.toList());
    /* objDC.Set_CAP2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_CAP2)) */
    objDC.Set_CAP2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_CAP2));
    /* lLista := Stream.of("DOMICILIO2").collect(Collectors.toList()) */
    lLista = Stream.of("DOMICILIO2").collect(Collectors.toList());
    /* objDC.Set_DOMICILIO2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_DOMICILIO2)) */
    objDC.Set_DOMICILIO2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_DOMICILIO2));
    /* lLista := Stream.of("TIPODOC").collect(Collectors.toList()) */
    lLista = Stream.of("TIPODOC").collect(Collectors.toList());
    /* objDC.Set_TIPODOC(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_TIPODOC)) */
    objDC.Set_TIPODOC(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_TIPODOC));
    /* lLista := Stream.of("NUMDOCUM").collect(Collectors.toList()) */
    lLista = Stream.of("NUMDOCUM").collect(Collectors.toList());
    /* objDC.Set_NUMDOCUM(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_NUMDOCUM)) */
    objDC.Set_NUMDOCUM(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_NUMDOCUM));
    /* lLista := Stream.of("DATARILASC").collect(Collectors.toList()) */
    lLista = Stream.of("DATARILASC").collect(Collectors.toList());
    /* objDC.Set_DATARILASC(CharToDate(fn_estraejson(_anagrafica,fn_creamc_json(lLista),DateToChar(objDC.w_DATARILASC)))) */
    objDC.Set_DATARILASC(CPLib.CharToDate(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),CPLib.DateToChar(objDC.w_DATARILASC))));
    /* lLista := Stream.of("DATAVALI").collect(Collectors.toList()) */
    lLista = Stream.of("DATAVALI").collect(Collectors.toList());
    /* objDC.Set_DATAVALI(CharToDate(fn_estraejson(_anagrafica,fn_creamc_json(lLista),DateToChar(objDC.w_DATAVALI)))) */
    objDC.Set_DATAVALI(CPLib.CharToDate(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),CPLib.DateToChar(objDC.w_DATAVALI))));
    /* lLista := Stream.of("RDCODAUT").collect(Collectors.toList()) */
    lLista = Stream.of("RDCODAUT").collect(Collectors.toList());
    /* objDC.Set_RDCODAUT(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_RDCODAUT)) */
    objDC.Set_RDCODAUT(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_RDCODAUT));
    /* lLista := Stream.of("RDLOCAUT").collect(Collectors.toList()) */
    lLista = Stream.of("RDLOCAUT").collect(Collectors.toList());
    /* objDC.Set_RDLOCAUT(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_RDLOCAUT)) */
    objDC.Set_RDLOCAUT(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_RDLOCAUT));
    /* lLista := Stream.of("PEPDESCRI").collect(Collectors.toList()) */
    lLista = Stream.of("PEPDESCRI").collect(Collectors.toList());
    /* objDC.Set_PEPDESCRI(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_PEPDESCRI)) */
    objDC.Set_PEPDESCRI(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_PEPDESCRI));
    /* lLista := Stream.of("PROFESSIONE").collect(Collectors.toList()) */
    lLista = Stream.of("PROFESSIONE").collect(Collectors.toList());
    /* objDC.Set_PROFESSIONE(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objDC.w_PROFESSIONE)) */
    objDC.Set_PROFESSIONE(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objDC.w_PROFESSIONE));
    /* objDC.Calculate() */
    objDC.Calculate();
    /* objDC.Save() */
    objDC.Save();
    /* If not(Empty(objDC.m_cLastMsgError)) */
    if ( ! (CPLib.Empty(objDC.m_cLastMsgError))) {
      /* _errmsg := "Errore nell'elaborazione dell'operazione: "+ objDC.m_cLastMsgError */
      _errmsg = "Errore nell'elaborazione dell'operazione: "+objDC.m_cLastMsgError;
    } else { // Else
      /* Exec Routine arrt_snai_oper_save(objDC.w_SNAINUMOPE,'X','') */
      arrt_snai_oper_saveR.Make(m_Ctx,this).Run(objDC.w_SNAINUMOPE,"X","");
      /* Exec Routine arrt_writelog('VARIAZIONE','CGO_OPERAZIONI',objDC.w_SNAINUMOPE) */
      arrt_writelogR.Make(m_Ctx,this).Run("VARIAZIONE","CGO_OPERAZIONI",objDC.w_SNAINUMOPE);
      /* Exec Routine arrt_cgo_qadv_mail(objDC.w_SNAINUMOPE,objDC.w_TIPOGIOCO,'W') */
      arrt_cgo_qadv_mailR.Make(m_Ctx,this).Run(objDC.w_SNAINUMOPE,objDC.w_TIPOGIOCO,"W");
      /* _respons.Esito := "Operazione Inserita Correttamente" */
      _respons.put("Esito","Operazione Inserita Correttamente");
      /* _respons.Codice := objDC.w_SNAINUMOPE */
      _respons.put("Codice",objDC.w_SNAINUMOPE);
    } // End If
  }
  void pagNO() throws Exception {
    /* objNO := new armt_cgo_operBO() */
    objNO = new armt_cgo_operBO(m_Ctx);
    /* objNO.Initialize() */
    objNO.Initialize();
    /* lLista := Stream.of("DATAOPE").collect(Collectors.toList()) */
    lLista = Stream.of("DATAOPE").collect(Collectors.toList());
    /* objNO.Set_DATAOPE(CharToDate(fn_estraejson(_operazione,fn_creamc_json(lLista),""))) */
    objNO.Set_DATAOPE(CPLib.CharToDate(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),"")));
    /* lLista := Stream.of("CAIDBIGLIETTO").collect(Collectors.toList()) */
    lLista = Stream.of("CAIDBIGLIETTO").collect(Collectors.toList());
    /* objNO.Set_CAIDBIGLIETTO(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
    objNO.Set_CAIDBIGLIETTO(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* lLista := Stream.of("TIPOGIOCO").collect(Collectors.toList()) */
    lLista = Stream.of("TIPOGIOCO").collect(Collectors.toList());
    /* objNO.Set_TIPOGIOCO(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
    objNO.Set_TIPOGIOCO(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* lLista := Stream.of("FLAGCONT").collect(Collectors.toList()) */
    lLista = Stream.of("FLAGCONT").collect(Collectors.toList());
    /* objNO.Set_FLAGCONT(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
    objNO.Set_FLAGCONT(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* lLista := Stream.of("FLAGWALLET").collect(Collectors.toList()) */
    lLista = Stream.of("FLAGWALLET").collect(Collectors.toList());
    /* objNO.Set_FLAGWALLET(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
    objNO.Set_FLAGWALLET(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* lLista := Stream.of("CAFLGOPE").collect(Collectors.toList()) */
    lLista = Stream.of("CAFLGOPE").collect(Collectors.toList());
    /* objNO.Set_CAFLGOPE(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
    objNO.Set_CAFLGOPE(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* lLista := Stream.of("TOTLIRE").collect(Collectors.toList()) */
    lLista = Stream.of("TOTLIRE").collect(Collectors.toList());
    /* objNO.Set_TOTLIRE(Val(fn_estraejson(_operazione,fn_creamc_json(lLista),""))) */
    objNO.Set_TOTLIRE(CPLib.Val(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),"")));
    /* lLista := Stream.of("TOTCONT").collect(Collectors.toList()) */
    lLista = Stream.of("TOTCONT").collect(Collectors.toList());
    /* objNO.Set_TOTCONT(Val(fn_estraejson(_operazione,fn_creamc_json(lLista),""))) */
    objNO.Set_TOTCONT(CPLib.Val(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),"")));
    /* lLista := Stream.of("IMPWALLET").collect(Collectors.toList()) */
    lLista = Stream.of("IMPWALLET").collect(Collectors.toList());
    /* objNO.Set_IMPWALLET(Val(fn_estraejson(_operazione,fn_creamc_json(lLista),""))) */
    objNO.Set_IMPWALLET(CPLib.Val(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),"")));
    /* lLista := Stream.of("CODWALLET").collect(Collectors.toList()) */
    lLista = Stream.of("CODWALLET").collect(Collectors.toList());
    /* objNO.Set_CODWALLET(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
    objNO.Set_CODWALLET(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* lLista := Stream.of("CODTRANSZ").collect(Collectors.toList()) */
    lLista = Stream.of("CODTRANSZ").collect(Collectors.toList());
    /* objNO.Set_CODTRANSZ(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
    objNO.Set_CODTRANSZ(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* lLista := Stream.of("MEZPAGAM").collect(Collectors.toList()) */
    lLista = Stream.of("MEZPAGAM").collect(Collectors.toList());
    /* objNO.Set_MEZPAGAM(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
    objNO.Set_MEZPAGAM(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* If At(objNO.w_MEZPAGAM,'|I|E|P') <> 0 */
    if (CPLib.ne(CPLib.At(objNO.w_MEZPAGAM,"|I|E|P"),0)) {
      /* lLista := Stream.of("IBAN").collect(Collectors.toList()) */
      lLista = Stream.of("IBAN").collect(Collectors.toList());
      /* objNO.Set_IBAN(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
      objNO.Set_IBAN(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    } // End If
    /* If At(objNO.w_MEZPAGAM,'|C|B') <> 0 and objNO.w_CGOFLGVLT<>'S' */
    if (CPLib.ne(CPLib.At(objNO.w_MEZPAGAM,"|C|B"),0) && CPLib.ne(objNO.w_CGOFLGVLT,"S")) {
      /* lLista := Stream.of("ASSEGNO").collect(Collectors.toList()) */
      lLista = Stream.of("ASSEGNO").collect(Collectors.toList());
      /* objNO.Set_ASSEGNO(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
      objNO.Set_ASSEGNO(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    } // End If
    /* If objNO.w_MEZPAGAM='V' */
    if (CPLib.eqr(objNO.w_MEZPAGAM,"V")) {
      /* lLista := Stream.of("CC4CIFRE").collect(Collectors.toList()) */
      lLista = Stream.of("CC4CIFRE").collect(Collectors.toList());
      /* objNO.Set_CC4CIFRE(fn_estraejson(_operazione,fn_creamc_json(lLista),"")) */
      objNO.Set_CC4CIFRE(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
      /* lLista := Stream.of("CCMESSCA").collect(Collectors.toList()) */
      lLista = Stream.of("CCMESSCA").collect(Collectors.toList());
      /* objNO.Set_CCMESSCA(Val(fn_estraejson(_operazione,fn_creamc_json(lLista),""))) */
      objNO.Set_CCMESSCA(CPLib.Val(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),"")));
      /* lLista := Stream.of("CCANNSCA").collect(Collectors.toList()) */
      lLista = Stream.of("CCANNSCA").collect(Collectors.toList());
      /* objNO.Set_CCANNSCA(Val(fn_estraejson(_operazione,fn_creamc_json(lLista),""))) */
      objNO.Set_CCANNSCA(CPLib.Val(fn_estraejsonR.Make(m_Ctx,this).Run(_operazione,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),"")));
    } // End If
    /* lLista := Stream.of("CFESTERO").collect(Collectors.toList()) */
    lLista = Stream.of("CFESTERO").collect(Collectors.toList());
    /* objNO.Set_CFESTERO(Val(fn_estraejson(_anagrafica,fn_creamc_json(lLista),""))) */
    objNO.Set_CFESTERO(CPLib.Val(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),"")));
    /* lLista := Stream.of("PEP").collect(Collectors.toList()) */
    lLista = Stream.of("PEP").collect(Collectors.toList());
    /* objNO.Set_PEP(fn_estraejson(_anagrafica,fn_creamc_json(lLista),"")) */
    objNO.Set_PEP(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* lLista := Stream.of("CODFISC").collect(Collectors.toList()) */
    lLista = Stream.of("CODFISC").collect(Collectors.toList());
    /* objNO.Set_CODFISC(fn_estraejson(_anagrafica,fn_creamc_json(lLista),"")) */
    objNO.Set_CODFISC(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),""));
    /* If objNO.w_CFESTERO=0 and not(Empty(objNO.w_CODFISC)) */
    if (CPLib.eqr(objNO.w_CFESTERO,0) &&  ! (CPLib.Empty(objNO.w_CODFISC))) {
      /* Exec Routine arrt_cgo_read_codfisc_dl(objNO,'I') */
      arrt_cgo_read_codfisc_dlR.Make(m_Ctx,this).Run(objNO,"I");
    } // End If
    /* If objNO.w_ANA_FOUND='N' or objNO.w_CFESTERO=1 */
    if (CPLib.eqr(objNO.w_ANA_FOUND,"N") || CPLib.eqr(objNO.w_CFESTERO,1)) {
      /* lLista := Stream.of("COGNOME").collect(Collectors.toList()) */
      lLista = Stream.of("COGNOME").collect(Collectors.toList());
      /* objNO.Set_COGNOME(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_COGNOME)) */
      objNO.Set_COGNOME(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_COGNOME));
      /* lLista := Stream.of("NOME").collect(Collectors.toList()) */
      lLista = Stream.of("NOME").collect(Collectors.toList());
      /* objNO.Set_NOME(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_NOME)) */
      objNO.Set_NOME(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_NOME));
      /* lLista := Stream.of("NASCOMUN").collect(Collectors.toList()) */
      lLista = Stream.of("NASCOMUN").collect(Collectors.toList());
      /* objNO.Set_NASCOMUN(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_NASCOMUN)) */
      objNO.Set_NASCOMUN(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_NASCOMUN));
      /* lLista := Stream.of("NASSTATO").collect(Collectors.toList()) */
      lLista = Stream.of("NASSTATO").collect(Collectors.toList());
      /* objNO.Set_NASSTATO(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_NASSTATO)) */
      objNO.Set_NASSTATO(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_NASSTATO));
      /* lLista := Stream.of("SESSO").collect(Collectors.toList()) */
      lLista = Stream.of("SESSO").collect(Collectors.toList());
      /* objNO.Set_SESSO(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_SESSO)) */
      objNO.Set_SESSO(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_SESSO));
      /* lLista := Stream.of("DATANASC").collect(Collectors.toList()) */
      lLista = Stream.of("DATANASC").collect(Collectors.toList());
      /* objNO.Set_DATANASC(CharToDate(fn_estraejson(_anagrafica,fn_creamc_json(lLista),DateToChar(objNO.w_DATANASC)))) */
      objNO.Set_DATANASC(CPLib.CharToDate(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),CPLib.DateToChar(objNO.w_DATANASC))));
      /* If objNO.w_CFESTERO=1 */
      if (CPLib.eqr(objNO.w_CFESTERO,1)) {
        /* Exec Routine arrt_cgo_read_codfisc_dl(objNO,'E') */
        arrt_cgo_read_codfisc_dlR.Make(m_Ctx,this).Run(objNO,"E");
      } // End If
    } // End If
    /* lLista := Stream.of("PAESE").collect(Collectors.toList()) */
    lLista = Stream.of("PAESE").collect(Collectors.toList());
    /* objNO.Set_PAESE(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_PAESE)) */
    objNO.Set_PAESE(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_PAESE));
    /* lLista := Stream.of("DESCCIT").collect(Collectors.toList()) */
    lLista = Stream.of("DESCCIT").collect(Collectors.toList());
    /* objNO.Set_DESCCIT(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_DESCCIT)) */
    objNO.Set_DESCCIT(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_DESCCIT));
    /* lLista := Stream.of("PROVINCIA").collect(Collectors.toList()) */
    lLista = Stream.of("PROVINCIA").collect(Collectors.toList());
    /* objNO.Set_PROVINCIA(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_PROVINCIA)) */
    objNO.Set_PROVINCIA(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_PROVINCIA));
    /* lLista := Stream.of("CAP").collect(Collectors.toList()) */
    lLista = Stream.of("CAP").collect(Collectors.toList());
    /* objNO.Set_CAP(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_CAP)) */
    objNO.Set_CAP(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_CAP));
    /* lLista := Stream.of("DOMICILIO").collect(Collectors.toList()) */
    lLista = Stream.of("DOMICILIO").collect(Collectors.toList());
    /* objNO.Set_DOMICILIO(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_DOMICILIO)) */
    objNO.Set_DOMICILIO(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_DOMICILIO));
    /* lLista := Stream.of("NUMTEL").collect(Collectors.toList()) */
    lLista = Stream.of("NUMTEL").collect(Collectors.toList());
    /* objNO.Set_NUMTEL(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_NUMTEL)) */
    objNO.Set_NUMTEL(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_NUMTEL));
    /* lLista := Stream.of("FLGDOM").collect(Collectors.toList()) */
    lLista = Stream.of("FLGDOM").collect(Collectors.toList());
    /* objNO.Set_FLGDOM(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_FLGDOM)) */
    objNO.Set_FLGDOM(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_FLGDOM));
    /* lLista := Stream.of("PAESE2").collect(Collectors.toList()) */
    lLista = Stream.of("PAESE2").collect(Collectors.toList());
    /* objNO.Set_PAESE2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_PAESE2)) */
    objNO.Set_PAESE2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_PAESE2));
    /* lLista := Stream.of("DESCCIT2").collect(Collectors.toList()) */
    lLista = Stream.of("DESCCIT2").collect(Collectors.toList());
    /* objNO.Set_DESCCIT2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_DESCCIT2)) */
    objNO.Set_DESCCIT2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_DESCCIT2));
    /* lLista := Stream.of("PROVINCIA2").collect(Collectors.toList()) */
    lLista = Stream.of("PROVINCIA2").collect(Collectors.toList());
    /* objNO.Set_PROVINCIA2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_PROVINCIA2)) */
    objNO.Set_PROVINCIA2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_PROVINCIA2));
    /* lLista := Stream.of("CAP2").collect(Collectors.toList()) */
    lLista = Stream.of("CAP2").collect(Collectors.toList());
    /* objNO.Set_CAP2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_CAP2)) */
    objNO.Set_CAP2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_CAP2));
    /* lLista := Stream.of("DOMICILIO2").collect(Collectors.toList()) */
    lLista = Stream.of("DOMICILIO2").collect(Collectors.toList());
    /* objNO.Set_DOMICILIO2(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_DOMICILIO2)) */
    objNO.Set_DOMICILIO2(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_DOMICILIO2));
    /* lLista := Stream.of("TIPODOC").collect(Collectors.toList()) */
    lLista = Stream.of("TIPODOC").collect(Collectors.toList());
    /* objNO.Set_TIPODOC(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_TIPODOC)) */
    objNO.Set_TIPODOC(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_TIPODOC));
    /* lLista := Stream.of("NUMDOCUM").collect(Collectors.toList()) */
    lLista = Stream.of("NUMDOCUM").collect(Collectors.toList());
    /* objNO.Set_NUMDOCUM(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_NUMDOCUM)) */
    objNO.Set_NUMDOCUM(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_NUMDOCUM));
    /* lLista := Stream.of("DATARILASC").collect(Collectors.toList()) */
    lLista = Stream.of("DATARILASC").collect(Collectors.toList());
    /* objNO.Set_DATARILASC(CharToDate(fn_estraejson(_anagrafica,fn_creamc_json(lLista),DateToChar(objNO.w_DATARILASC)))) */
    objNO.Set_DATARILASC(CPLib.CharToDate(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),CPLib.DateToChar(objNO.w_DATARILASC))));
    /* lLista := Stream.of("DATAVALI").collect(Collectors.toList()) */
    lLista = Stream.of("DATAVALI").collect(Collectors.toList());
    /* objNO.Set_DATAVALI(CharToDate(fn_estraejson(_anagrafica,fn_creamc_json(lLista),DateToChar(objNO.w_DATAVALI)))) */
    objNO.Set_DATAVALI(CPLib.CharToDate(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),CPLib.DateToChar(objNO.w_DATAVALI))));
    /* lLista := Stream.of("RDCODAUT").collect(Collectors.toList()) */
    lLista = Stream.of("RDCODAUT").collect(Collectors.toList());
    /* objNO.Set_RDCODAUT(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_RDCODAUT)) */
    objNO.Set_RDCODAUT(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_RDCODAUT));
    /* lLista := Stream.of("RDLOCAUT").collect(Collectors.toList()) */
    lLista = Stream.of("RDLOCAUT").collect(Collectors.toList());
    /* objNO.Set_RDLOCAUT(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_RDLOCAUT)) */
    objNO.Set_RDLOCAUT(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_RDLOCAUT));
    /* lLista := Stream.of("PEPDESCRI").collect(Collectors.toList()) */
    lLista = Stream.of("PEPDESCRI").collect(Collectors.toList());
    /* objNO.Set_PEPDESCRI(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_PEPDESCRI)) */
    objNO.Set_PEPDESCRI(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_PEPDESCRI));
    /* lLista := Stream.of("PROFESSIONE").collect(Collectors.toList()) */
    lLista = Stream.of("PROFESSIONE").collect(Collectors.toList());
    /* objNO.Set_PROFESSIONE(fn_estraejson(_anagrafica,fn_creamc_json(lLista),objNO.w_PROFESSIONE)) */
    objNO.Set_PROFESSIONE(fn_estraejsonR.Make(m_Ctx,this).Run(_anagrafica,fn_creamc_jsonR.Make(m_Ctx,this).Run(lLista),objNO.w_PROFESSIONE));
    /* objNO.Calculate() */
    objNO.Calculate();
    /* objNO.Save() */
    objNO.Save();
    /* If not(Empty(objNO.m_cLastMsgError)) */
    if ( ! (CPLib.Empty(objNO.m_cLastMsgError))) {
      /* _errmsg := "Errore nell'elaborazione dell'operazione: "+ objNO.m_cLastMsgError */
      _errmsg = "Errore nell'elaborazione dell'operazione: "+objNO.m_cLastMsgError;
    } else { // Else
      /* _respons.Esito := "Operazione Inserita Correttamente" */
      _respons.put("Esito","Operazione Inserita Correttamente");
      /* _respons.Codice := objNO.w_SNAINUMOPE */
      _respons.put("Codice",objNO.w_SNAINUMOPE);
    } // End If
  }
  void pagMO() throws Exception {
    /* objMO := new armt_cgo_oper_multiBO() */
    objMO = new armt_cgo_oper_multiBO(m_Ctx);
    /* objMO.Initialize() */
    objMO.Initialize();
    /* objMO.Calculate() */
    objMO.Calculate();
    /* objMO.Save() */
    objMO.Save();
    /* If not(Empty(objMO.m_cLastMsgError)) */
    if ( ! (CPLib.Empty(objMO.m_cLastMsgError))) {
      /* _errmsg := "Errore nell'elaborazione dell'operazione: "+ CODICE */
      _errmsg = "Errore nell'elaborazione dell'operazione: "+CODICE;
    } // End If
  }
  void pagMC() throws Exception {
    /* objMC := new armt_cgo_oper_multi_dcBO() */
    objMC = new armt_cgo_oper_multi_dcBO(m_Ctx);
    /* objMC.Initialize() */
    objMC.Initialize();
    /* objMC.Calculate() */
    objMC.Calculate();
    /* objMC.Save() */
    objMC.Save();
    /* If not(Empty(objMC.m_cLastMsgError)) */
    if ( ! (CPLib.Empty(objMC.m_cLastMsgError))) {
      /* _errmsg := "Errore nell'elaborazione dell'operazione: "+ CODICE */
      _errmsg = "Errore nell'elaborazione dell'operazione: "+CODICE;
    } // End If
  }
  void _init_() {
  }
  public String RunAsync(String p_CODICE) {
    return RunAsync(p_CODICE,"");
  }
  public String RunAsync(String p_CODICE,String p_operazione) {
    return RunAsync(p_CODICE,p_operazione,"");
  }
  public String RunAsync(String p_CODICE,String p_operazione,String p_anagrafica) {
    return RunAsync(p_CODICE,p_operazione,p_anagrafica,"");
  }
  public String RunAsync(String p_CODICE,String p_operazione,String p_anagrafica,String p_tipogestione) {
    return RunAsync(p_CODICE,p_operazione,p_anagrafica,p_tipogestione,"");
  }
  public String RunAsync(String p_CODICE,String p_operazione,String p_anagrafica,String p_tipogestione,String p_sp_company) {
    CODICE = p_CODICE;
    operazione = p_operazione;
    anagrafica = p_anagrafica;
    tipogestione = p_tipogestione;
    sp_company = p_sp_company;
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
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct Run(String p_CODICE) {
    return Run(p_CODICE,"");
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct Run(String p_CODICE,String p_operazione) {
    return Run(p_CODICE,p_operazione,"");
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct Run(String p_CODICE,String p_operazione,String p_anagrafica) {
    return Run(p_CODICE,p_operazione,p_anagrafica,"");
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct Run(String p_CODICE,String p_operazione,String p_anagrafica,String p_tipogestione) {
    return Run(p_CODICE,p_operazione,p_anagrafica,p_tipogestione,"");
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct Run(String p_CODICE,String p_operazione,String p_anagrafica,String p_tipogestione,String p_sp_company) {
    CODICE = p_CODICE;
    operazione = p_operazione;
    anagrafica = p_anagrafica;
    tipogestione = p_tipogestione;
    sp_company = p_sp_company;
    return Run();
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct Run() {
    com.zucchetti.sitepainter.datatypes.CPJSONStruct l_result;
    l_result = com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
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
      } catch(Stop stop_value) {
        l_result = (com.zucchetti.sitepainter.datatypes.CPJSONStruct)stop_value.GetObject();
        if (stop_value.hasHttpResponse()) {
          m_apiResponse = stop_value.getFunctionApiResponse();
        }
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
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
  public static arrt_cgo_apitalkR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_apitalkR(p_Ctx, p_Caller);
  }
  public static arrt_cgo_apitalkR Make(CPContext p_Ctx) {
    return new arrt_cgo_apitalkR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    CODICE = CPLib.Space(0);
    operazione = "";
    anagrafica = "";
    tipogestione = CPLib.Space(0);
    sp_company = CPLib.Space(0);
    _method = CPLib.Space(0);
    _version = CPLib.Space(0);
    _respons = com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
    _operazione = null;
    _anagrafica = null;
    _connescli = CPLib.Space(0);
    _ragsoc = CPLib.Space(0);
    _cognome = CPLib.Space(0);
    _nome = CPLib.Space(0);
    objDC = null;
    objNO = null;
    objMC = null;
    objMO = null;
    lLista = null;
    _errmsg = CPLib.Space(0);
    _coddip = CPLib.Space(6);
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: , arrt_cgo_read_codfisc,arrt_cgo_apitalk,arrt_cgo_qadv_mail,arrt_cgo_read_codfisc_dl,arrt_snai_oper_save,arrt_writelog,fn_creamc_json,fn_estraejson,
  public static final String i_InvokedRoutines = ", arrt_cgo_read_codfisc,arrt_cgo_apitalk,arrt_cgo_qadv_mail,arrt_cgo_read_codfisc_dl,arrt_snai_oper_save,arrt_writelog,fn_creamc_json,fn_estraejson,";
  public static String[] m_cRunParameterNames={"CODICE","operazione","anagrafica","tipogestione","sp_company"};
}
