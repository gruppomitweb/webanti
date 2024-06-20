// * --- Area Manuale = BO - Header
// * --- arrt_cgo_imp_dati
import java.io.File; 
import java.lang.Double;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
// * --- Fine Area Manuale
public class arrt_cgo_imp_datiR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_cgo_tbconvgio;
  public String m_cServer_cgo_tbconvgio;
  public String m_cPhName_cgo_telematico;
  public String m_cServer_cgo_telematico;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
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
  public String xConnes;
  public double cNumNew;
  public double conta;
  public double _esito;
  public String czipfile;
  public String cpercorsozip;
  public String cdirectoryfile;
  public String buffernomefile;
  public String nomefileimport;
  public double _priorita;
  public String filename;
  public String _gMsgProc;
  public String _oldazi;
  public String _chiave;
  public String _gAzienda;
  public String cProg;
  public String _pathftp;
  public double _cfiles;
  public String _tipgio;
  public String fhand;
  public String riga;
  public String _coddip;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_cgo_imp_dati
  public String[] lista;
  public int conteggio;
  public int i;
  public int _i;
  public int _y;
  public int contanome;
  public int _righe;
  public int _conta;
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_cgo_imp_datiR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_cgo_imp_dati",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_cgo_tbconvgio = p_ContextObject.GetPhName("cgo_tbconvgio");
    if (m_cPhName_cgo_tbconvgio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tbconvgio = m_cPhName_cgo_tbconvgio+" "+m_Ctx.GetWritePhName("cgo_tbconvgio");
    }
    m_cServer_cgo_tbconvgio = p_ContextObject.GetServer("cgo_tbconvgio");
    m_cPhName_cgo_telematico = p_ContextObject.GetPhName("cgo_telematico");
    if (m_cPhName_cgo_telematico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_telematico = m_cPhName_cgo_telematico+" "+m_Ctx.GetWritePhName("cgo_telematico");
    }
    m_cServer_cgo_telematico = p_ContextObject.GetServer("cgo_telematico");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
      m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
      if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
      }
      m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    }
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      return _priorita;
    }
    if (CPLib.eqr("_cfiles",p_cVarName)) {
      return _cfiles;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_imp_dati";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      return czipfile;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      return cpercorsozip;
    }
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      return cdirectoryfile;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      return buffernomefile;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      return filename;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      return _gMsgProc;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("_chiave",p_cVarName)) {
      return _chiave;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_pathftp",p_cVarName)) {
      return _pathftp;
    }
    if (CPLib.eqr("_tipgio",p_cVarName)) {
      return _tipgio;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
    if (CPLib.eqr("_cfiles",p_cVarName)) {
      _cfiles = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
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
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      cdirectoryfile = value;
      return;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      buffernomefile = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
      return;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      filename = value;
      return;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      _gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("_chiave",p_cVarName)) {
      _chiave = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_pathftp",p_cVarName)) {
      _pathftp = value;
      return;
    }
    if (CPLib.eqr("_tipgio",p_cVarName)) {
      _tipgio = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
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
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* xConnes Char(16) */
      /* cNumNew Numeric(10, 0) // Contatore record nuovi */
      /* conta Numeric(10, 0) */
      /* _esito Numeric(1, 0) */
      /* czipfile Char(100) */
      /* cpercorsozip Char(200) */
      /* cdirectoryfile Char(200) */
      /* buffernomefile Char(100) */
      /* nomefileimport Char(50) */
      /* _priorita Numeric(3, 0) */
      /* filename Char(80) */
      /* _gMsgProc Memo */
      /* _oldazi Char(10) */
      /* _chiave Char(20) */
      /* _gAzienda Char(10) // Azienda */
      /* cProg Char(20) */
      /* _pathftp Char(128) */
      /* _cfiles Numeric(2, 0) */
      /* _tipgio Char(3) */
      /* fhand Char(10) */
      /* riga Char(128) */
      /* _coddip Char(6) */
      /* Cicla sul file della lista e lancia la pagina appropriata */
      /* _gMsgProc := '' */
      _gMsgProc = "";
      /* Debug Msg 'Attivazione Import CSV SNAI' */
      if ( ! (CPLib.IsNull(m_Debug))) {
        m_Debug.log(CPLib.FormatMsg(m_Ctx,"Attivazione Import CSV SNAI"));
      }
      /* _gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      /* Utilities.SetUserCode(1) */
      Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
      /* _oldazi := Utilities.GetCompany() */
      _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
        /* _gAzienda := LRTrim(cpazi->codazi) // Azienda */
        _gAzienda = CPLib.LRTrim(Cursor_cpazi.GetString("codazi"));
        /* _chiave := '' */
        _chiave = "";
        /* _esito := 0 */
        _esito = CPLib.Round(0,0);
        /* _pathftp := '' */
        _pathftp = "";
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
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PATHFTP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _pathftp := intermbo->PATHFTP */
          _pathftp = Cursor_intermbo.GetString("PATHFTP");
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* _cfiles := 0 */
        _cfiles = CPLib.Round(0,0);
        // Legge i file presenti nella cartella
        File di = new File(CPLib.LRTrim(_pathftp)+"/");
        File fl[] = di.listFiles();
        int _i;
        int count=0;
        for (_i=0; _i < fl.length; _i++)  {
        //  System.out.println(""+fl[_i]);
        /* buffernomefile := fl[_i].getAbsolutePath() */
        buffernomefile = fl[_i].getAbsolutePath();
        /* If At(".csv",Lower(buffernomefile)) > 0 */
        if (CPLib.gt(CPLib.At(".csv",CPLib.Lower(buffernomefile)),0)) {
          // * --- Insert into tmp_list_imprich from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_imp_dati",869,"0000002D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_0000002D(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(buffernomefile,"?",0,0,m_cServer)+", ";
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
          /* _cfiles := _cfiles + 1 */
          _cfiles = CPLib.Round(_cfiles+1,0);
        } // End If
        /* } */
        };
        /* If _cfiles > 0 */
        if (CPLib.gt(_cfiles,0)) {
          // Begin Transaction
          m_Sql.RequireTransaction();
          double nTry00000032status;
          nTry00000032status = m_Sql.GetTransactionStatus();
          String cTry00000032msg;
          cTry00000032msg = m_Sql.TransactionErrorMessage();
          try {
            // * --- Select from tmp_list_imprich
            m_cServer = m_Ctx.GetServer("tmp_list_imprich");
            m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
            if (Cursor_tmp_list_imprich!=null)
              Cursor_tmp_list_imprich.Close();
            Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_list_imprich.Eof())) {
              /* If _esito = 0 */
              if (CPLib.eqr(_esito,0)) {
                /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
                nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
                /* Exec "Legge file csv" Page 2:Page_2 */
                Page_2();
                if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                  throw new RoutineException();
                }
              } // End If
              // * --- Delete from tmp_list_imprich
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_list_imprich");
              m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_imp_dati",869,"00000037")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_list_imprich.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_list_imprich.GetString("nomefile"))+"";
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
              Cursor_tmp_list_imprich.Next();
            }
            m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
            Cursor_tmp_list_imprich.Close();
            // * --- End Select
            /* _gMsgProc := _gMsgProc + 'N° Operazioni lette dal file CSV: '+LRTrim(Str(_conta - 1,10,0)) + NL */
            _gMsgProc = _gMsgProc+"N° Operazioni lette dal file CSV: "+CPLib.LRTrim(CPLib.Str(_conta-1,10,0))+"\n";
            /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime())  */
            _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
            // Commit
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            if (CPLib.ne(m_cLastMsgError,"")) {
              m_bError = true;
            }
            m_Sql.CompleteTransaction();
          } catch(Exception l_exeption) {
            Stop.ReactToException(l_exeption);
            /* _esito := 1 */
            _esito = CPLib.Round(1,0);
            /* _gMsgProc := _gMsgProc + "Rilevati errori nell'importazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
            _gMsgProc = _gMsgProc+"Rilevati errori nell'importazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
            /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
            _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
            /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime())  */
            _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
            // Rollback
            m_Sql.AbortTransaction();
            m_cLastMsgError = m_Sql.TransactionErrorMessage();
            m_bError = true;
            m_Sql.CompleteTransaction();
            /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
            Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
            /* Exec Routine arrt_writelog('IMPORT DATI','Scheduler','ERRORS',_gMsgProc,"S") */
            arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","Scheduler","ERRORS",_gMsgProc,"S");
          } finally {
            if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000032status,0)) {
              m_Sql.SetTransactionStatus(nTry00000032status,cTry00000032msg);
            }
          }
          /* If _esito=0 */
          if (CPLib.eqr(_esito,0)) {
            /* Exec Routine arrt_imp_dati_cgo_sched_tabs */
            arrt_imp_dati_cgo_sched_tabsR.Make(m_Ctx,this).Run();
          } // End If
        } else { // Else
          /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
          Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
          /* _gMsgProc := _gMsgProc + "Non sono stati trovati file da elaborare per l'import dei dati."+NL */
          _gMsgProc = _gMsgProc+"Non sono stati trovati file da elaborare per l'import dei dati."+"\n";
          /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime())  */
          _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
          /* Exec Routine arrt_writelog('IMPORT DATI','Scheduler','ERRORS',_gMsgProc,"S") */
          arrt_writelogR.Make(m_Ctx,this).Run("IMPORT DATI","Scheduler","ERRORS",_gMsgProc,"S");
        } // End If
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
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
  void Page_2() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* Legge il file di testo e porta i dati nella tabella */
      /* conta := 1 */
      conta = CPLib.Round(1,0);
      /* cNumNew := 0 */
      cNumNew = CPLib.Round(0,0);
      /* _gMsgProc := _gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      _gMsgProc = _gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
      m_Ctx.SetGlobalString("_gMsgProc",_gMsgProc);
      /* _i = 0 */
      CPLib.eqr(_i,0);
      /* filename := LRTrim(nomefileimport) */
      filename = CPLib.LRTrim(nomefileimport);
      /* fhand := FileLibMit.OpenReadPath(filename) */
      fhand = FileLibMit.OpenReadPath(filename);
      /* While not(FileLibMit.Eof(fhand)) */
      while ( ! (FileLibMit.Eof(fhand))) {
        /* riga := FileLibMit.ReadLine(fhand) */
        riga = FileLibMit.ReadLine(fhand);
        /* If not(Empty(LRTrim(riga))) */
        if ( ! (CPLib.Empty(CPLib.LRTrim(riga)))) {
          // Suddivide la riga
          String [] nextLine = riga.split(";");
          /* If not(Empty(nextLine[0])) */
          if ( ! (CPLib.Empty(nextLine[0]))) {
            /* _tipgio := '' */
            _tipgio = "";
            /* _coddip := '' */
            _coddip = "";
            // * --- Read from cgo_tbconvgio
            m_cServer = m_Ctx.GetServer("cgo_tbconvgio");
            m_cPhName = m_Ctx.GetPhName("cgo_tbconvgio");
            m_cSql = "";
            m_cSql = m_cSql+"CODGIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(nextLine[6])),"N",3,0,m_cServer),m_cServer,CPLib.Val(CPLib.LRTrim(nextLine[6])));
            if (m_Ctx.IsSharedTemp("cgo_tbconvgio")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPGIO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _tipgio = Read_Cursor.GetString("TIPGIO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cgo_tbconvgio into routine arrt_cgo_imp_dati returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _tipgio = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODLOC="+CPSql.SQLValueAdapter(CPLib.ToSQL("LOC-"+CPLib.LRTrim(nextLine[1]),"C",25,0,m_cServer),m_cServer,"LOC-"+CPLib.LRTrim(nextLine[1]));
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODDIP",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _coddip = Read_Cursor.GetString("CODDIP");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_cgo_imp_dati returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _coddip = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            // * --- Insert into cgo_telematico from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_telematico");
            m_cPhName = m_Ctx.GetPhName("cgo_telematico");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_telematico",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_imp_dati",869,"00000058")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000058(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("A","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_coddip,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(nextLine[2]))/100,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(CPLib.LRTrim(nextLine[3])),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(arfn_datetimefcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(nextLine[4])),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[5]),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipgio,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_telematico",true);
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
          } // End If
        } // End If
      } // End While
      // Chiude il file e lo cancella
      FileLibMit.Close(fhand);
      FileLibMit.DeleteFilePath(filename);
      /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
      _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
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
  void _init_() {
  }
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
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
  public static arrt_cgo_imp_datiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_imp_datiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    xConnes = CPLib.Space(16);
    cNumNew = 0;
    conta = 0;
    _esito = 0;
    czipfile = CPLib.Space(100);
    cpercorsozip = CPLib.Space(200);
    cdirectoryfile = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    nomefileimport = CPLib.Space(50);
    _priorita = 0;
    filename = CPLib.Space(80);
    _gMsgProc = "";
    _oldazi = CPLib.Space(10);
    _chiave = CPLib.Space(20);
    _gAzienda = CPLib.Space(10);
    cProg = CPLib.Space(20);
    _pathftp = CPLib.Space(128);
    _cfiles = 0;
    _tipgio = CPLib.Space(3);
    fhand = CPLib.Space(10);
    riga = CPLib.Space(128);
    _coddip = CPLib.Space(6);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_datetimefchar,arfn_fdatetime,arrt_imp_dati_cgo_sched_tabs,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_datetimefchar,arfn_fdatetime,arrt_imp_dati_cgo_sched_tabs,arrt_writelog,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000002D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000058(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"ENV,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CADATAORA,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"TIPOGIOCO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_telematico",true);
    return p_cSql;
  }
}
