// * --- Area Manuale = BO - Header
// * --- arrt_famnoinvio
import java.io.*;
import java.util.Scanner;
// * --- Fine Area Manuale
public class arrt_famnoinvioR implements CallerWithObjs {
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
  public String m_cPhName_aefaminvio;
  public String m_cServer_aefaminvio;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_sid_invio;
  public String m_cServer_sid_invio;
  public String m_cPhName_sid_invio1;
  public String m_cServer_sid_invio1;
  public String m_cPhName_sid_invio2;
  public String m_cServer_sid_invio2;
  public String m_cPhName_sid_invio3;
  public String m_cServer_sid_invio3;
  public String m_cPhName_sid_invio4;
  public String m_cServer_sid_invio4;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
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
  public String w_flgexist;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gPathApp;
  public String gPathDoc;
  public double _conta;
  public double _contaopx;
  public String _errore;
  public MemoryCursor_tmp_stpperiodo mcTemp;
  public MemoryCursorRow_tmp_stpperiodo rowTemp;
  public MemoryCursor_sid_invio mcSID0;
  public MemoryCursorRow_sid_invio rowSID0;
  public MemoryCursor_sid_invio1 mcSID1;
  public MemoryCursorRow_sid_invio1 rowSID1;
  public MemoryCursor_sid_invio2 mcSID2;
  public MemoryCursorRow_sid_invio2 rowSID2;
  public MemoryCursor_sid_invio2 mcSID2r;
  public MemoryCursor_sid_invio3 mcSID3;
  public MemoryCursorRow_sid_invio3 rowSID3;
  public MemoryCursor_sid_invio3 mcSID3r;
  public double _crea;
  public java.sql.Date _dataini;
  public java.sql.Date _datafin;
  public String _invio;
  public MemoryCursor_mcmessaggi_mcrdef _sid;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public double _cicli;
  public double _totrecord;
  public double _reccount;
  public String _unique;
  public String _newuc;
  public String cProg;
  public java.sql.Date w_dataini;
  public java.sql.Date w_datafine;
  public String _anno;
  public String _oldrap;
  public String fhand;
  public String _nomefile;
  public String cNomeFile;
  public String _mese;
  public String _riga;
  public double _tipo1;
  public double _tipo2;
  public double _tipo3;
  public double _tipo4;
  public String _oldmsg;
  public String _cfinter;
  public String _intercod;
  public String _intercab;
  public double nProgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_famnoinvio
  public int _r;
  // * --- Fine Area Manuale
  public arrt_famnoinvioR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_famnoinvio",m_Caller);
    m_cPhName_aefaminvio = p_ContextObject.GetPhName("aefaminvio");
    if (m_cPhName_aefaminvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefaminvio = m_cPhName_aefaminvio+" "+m_Ctx.GetWritePhName("aefaminvio");
    }
    m_cServer_aefaminvio = p_ContextObject.GetServer("aefaminvio");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_sid_invio = p_ContextObject.GetPhName("sid_invio");
    if (m_cPhName_sid_invio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio = m_cPhName_sid_invio+" "+m_Ctx.GetWritePhName("sid_invio");
    }
    m_cServer_sid_invio = p_ContextObject.GetServer("sid_invio");
    m_cPhName_sid_invio1 = p_ContextObject.GetPhName("sid_invio1");
    if (m_cPhName_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio1 = m_cPhName_sid_invio1+" "+m_Ctx.GetWritePhName("sid_invio1");
    }
    m_cServer_sid_invio1 = p_ContextObject.GetServer("sid_invio1");
    m_cPhName_sid_invio2 = p_ContextObject.GetPhName("sid_invio2");
    if (m_cPhName_sid_invio2.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio2 = m_cPhName_sid_invio2+" "+m_Ctx.GetWritePhName("sid_invio2");
    }
    m_cServer_sid_invio2 = p_ContextObject.GetServer("sid_invio2");
    m_cPhName_sid_invio3 = p_ContextObject.GetPhName("sid_invio3");
    if (m_cPhName_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio3 = m_cPhName_sid_invio3+" "+m_Ctx.GetWritePhName("sid_invio3");
    }
    m_cServer_sid_invio3 = p_ContextObject.GetServer("sid_invio3");
    m_cPhName_sid_invio4 = p_ContextObject.GetPhName("sid_invio4");
    if (m_cPhName_sid_invio4.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio4 = m_cPhName_sid_invio4+" "+m_Ctx.GetWritePhName("sid_invio4");
    }
    m_cServer_sid_invio4 = p_ContextObject.GetServer("sid_invio4");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
      m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
      if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
      }
      m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
      m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
      if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
      }
      m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    }
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    if (m_cPhName_anarapbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anarapbo = m_cPhName_anarapbo+" "+m_Ctx.GetWritePhName("anarapbo");
    }
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_contaopx",p_cVarName)) {
      return _contaopx;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      return _crea;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_totrecord",p_cVarName)) {
      return _totrecord;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_tipo1",p_cVarName)) {
      return _tipo1;
    }
    if (CPLib.eqr("_tipo2",p_cVarName)) {
      return _tipo2;
    }
    if (CPLib.eqr("_tipo3",p_cVarName)) {
      return _tipo3;
    }
    if (CPLib.eqr("_tipo4",p_cVarName)) {
      return _tipo4;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_famnoinvio";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("flgexist",p_cVarName)) {
      return w_flgexist;
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
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_invio",p_cVarName)) {
      return _invio;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      return _unique;
    }
    if (CPLib.eqr("_newuc",p_cVarName)) {
      return _newuc;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      return _anno;
    }
    if (CPLib.eqr("_oldrap",p_cVarName)) {
      return _oldrap;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      return _mese;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      return _cfinter;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      return _intercod;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      return _intercab;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataini",p_cVarName)) {
      return _dataini;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      return _datafin;
    }
    if (CPLib.eqr("dataini",p_cVarName)) {
      return w_dataini;
    }
    if (CPLib.eqr("datafine",p_cVarName)) {
      return w_datafine;
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
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      return mcTemp;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      return mcSID0;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      return mcSID1;
    }
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      return mcSID2;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      return mcSID2r;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      return mcSID3;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      return mcSID3r;
    }
    if (CPLib.eqr("_sid",p_cVarName)) {
      return _sid;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      return rowTemp;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      return rowSID0;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      return rowSID1;
    }
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      return rowSID2;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      return rowSID3;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_contaopx",p_cVarName)) {
      _contaopx = value;
      return;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      _crea = value;
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
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_totrecord",p_cVarName)) {
      _totrecord = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_tipo1",p_cVarName)) {
      _tipo1 = value;
      return;
    }
    if (CPLib.eqr("_tipo2",p_cVarName)) {
      _tipo2 = value;
      return;
    }
    if (CPLib.eqr("_tipo3",p_cVarName)) {
      _tipo3 = value;
      return;
    }
    if (CPLib.eqr("_tipo4",p_cVarName)) {
      _tipo4 = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("flgexist",p_cVarName)) {
      w_flgexist = value;
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
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_invio",p_cVarName)) {
      _invio = value;
      return;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      _unique = value;
      return;
    }
    if (CPLib.eqr("_newuc",p_cVarName)) {
      _newuc = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_anno",p_cVarName)) {
      _anno = value;
      return;
    }
    if (CPLib.eqr("_oldrap",p_cVarName)) {
      _oldrap = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      _mese = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      _cfinter = value;
      return;
    }
    if (CPLib.eqr("_intercod",p_cVarName)) {
      _intercod = value;
      return;
    }
    if (CPLib.eqr("_intercab",p_cVarName)) {
      _intercab = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dataini",p_cVarName)) {
      _dataini = value;
      return;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      _datafin = value;
      return;
    }
    if (CPLib.eqr("dataini",p_cVarName)) {
      w_dataini = value;
      return;
    }
    if (CPLib.eqr("datafine",p_cVarName)) {
      w_datafine = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      rowTemp = (MemoryCursorRow_tmp_stpperiodo)value;
      return;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      rowSID0 = (MemoryCursorRow_sid_invio)value;
      return;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      rowSID1 = (MemoryCursorRow_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      rowSID2 = (MemoryCursorRow_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      rowSID3 = (MemoryCursorRow_sid_invio3)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      mcTemp = (MemoryCursor_tmp_stpperiodo)value;
      return;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      mcSID0 = (MemoryCursor_sid_invio)value;
      return;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      mcSID1 = (MemoryCursor_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      mcSID2 = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      mcSID2r = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      mcSID3 = (MemoryCursor_sid_invio3)value;
      return;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      mcSID3r = (MemoryCursor_sid_invio3)value;
      return;
    }
    if (CPLib.eqr("_sid",p_cVarName)) {
      _sid = (MemoryCursor_mcmessaggi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_fam_noinvio_01_2015=null;
    CPResultSet Cursor_tmp_listafile=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_flgexist Char(1) */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gIntemediario Char(11) // Intermediario */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* _conta Numeric(10, 0) */
      /* _contaopx Numeric(10, 0) */
      /* _errore Memo */
      /* mcTemp MemoryCursor(tmp_stpperiodo) */
      /* rowTemp Row(tmp_stpperiodo) */
      /* mcSID0 MemoryCursor(sid_invio) */
      /* rowSID0 Row(sid_invio) */
      /* mcSID1 MemoryCursor(sid_invio1) */
      /* rowSID1 Row(sid_invio1) */
      /* mcSID2 MemoryCursor(sid_invio2) */
      /* rowSID2 Row(sid_invio2) */
      /* mcSID2r MemoryCursor(sid_invio2) */
      /* mcSID3 MemoryCursor(sid_invio3) */
      /* rowSID3 Row(sid_invio3) */
      /* mcSID3r MemoryCursor(sid_invio3) */
      /* _crea Numeric(1, 0) */
      /* _dataini Date */
      /* _datafin Date */
      /* _invio Char(10) */
      /* _sid MemoryCursor(mcMessaggi.MCRDef) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _totrecord Numeric(10, 0) */
      /* _reccount Numeric(0, 0) */
      /* _unique Char(50) */
      /* _newuc Char(1) */
      /* cProg Char(10) */
      /* w_dataini Date */
      /* w_datafine Date */
      /* _anno Char(4) */
      /* _oldrap Char(25) */
      /* fhand Char(10) */
      /* _nomefile Char(10) */
      /* cNomeFile Char(100) */
      /* _mese Char(2) */
      /* _riga Char(398) */
      /* _tipo1 Numeric(9, 0) */
      /* _tipo2 Numeric(9, 0) */
      /* _tipo3 Numeric(9, 0) */
      /* _tipo4 Numeric(9, 0) */
      /* _oldmsg Char(100) */
      /* _cfinter Char(16) */
      /* _intercod Char(16) */
      /* _intercab Char(5) */
      /* nProgImp Numeric(15, 0) */
      /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Drop temporary table tmp_listafile
      if (m_Ctx.IsSharedTemp("tmp_listafile")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_listafile");
      }
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
      // * --- Create temporary table tmp_listafile
      if (m_Ctx.IsSharedTemp("tmp_listafile")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
          m_cServer = m_Ctx.GetServer("tmp_listafile");
          m_cPhName = m_Ctx.GetPhName("tmp_listafile");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_listafile");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_listafile");
      if ( ! (m_Ctx.IsSharedTemp("tmp_listafile"))) {
        m_cServer = m_Ctx.GetServer("tmp_listafile");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_listafile",m_cServer,"proto")),m_cPhName,"tmp_listafile",m_Ctx);
      }
      m_cPhName_tmp_listafile = m_cPhName;
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
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000046status;
      nTry00000046status = m_Sql.GetTransactionStatus();
      String cTry00000046msg;
      cTry00000046msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione Nuovi Rapporti: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione Nuovi Rapporti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* w_dataini := CharToDate('20141231') */
        w_dataini = CPLib.CharToDate("20141231");
        /* w_datafine := iif(w_flgexist='S',CharToDate('20110101'),NullDate()) */
        w_datafine = (CPLib.eqr(w_flgexist,"S")?CPLib.CharToDate("20110101"):CPLib.NullDate());
        // * --- Select from qbe_fam_noinvio_01_2015
        SPBridge.HMCaller _h0000004A;
        _h0000004A = new SPBridge.HMCaller();
        _h0000004A.Set("m_cVQRList",m_cVQRList);
        _h0000004A.Set("dataini",w_dataini);
        _h0000004A.Set("datafine",w_datafine);
        if (Cursor_qbe_fam_noinvio_01_2015!=null)
          Cursor_qbe_fam_noinvio_01_2015.Close();
        Cursor_qbe_fam_noinvio_01_2015 = new VQRHolder("qbe_fam_noinvio_01_2015",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000004A,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_fam_noinvio_01_2015.Eof())) {
          /* _tipo1 := 0 */
          _tipo1 = CPLib.Round(0,0);
          /* _tipo2 := 0 */
          _tipo2 = CPLib.Round(0,0);
          /* _tipo3 := 0 */
          _tipo3 = CPLib.Round(0,0);
          /* _tipo4 := 0 */
          _tipo4 = CPLib.Round(0,0);
          /* _anno := Str(qbe_fam_noinvio_01_2015->ANNO,4,0) */
          _anno = CPLib.Str(Cursor_qbe_fam_noinvio_01_2015.GetDouble("ANNO"),4,0);
          /* _mese := iif(qbe_fam_noinvio_01_2015->MESE<=9,'0'+Str(qbe_fam_noinvio_01_2015->MESE,1,0),Str(qbe_fam_noinvio_01_2015->MESE,2,0)) */
          _mese = (CPLib.le(Cursor_qbe_fam_noinvio_01_2015.GetDouble("MESE"),9)?"0"+CPLib.Str(Cursor_qbe_fam_noinvio_01_2015.GetDouble("MESE"),1,0):CPLib.Str(Cursor_qbe_fam_noinvio_01_2015.GetDouble("MESE"),2,0));
          /* _dataini := CharToDate(_anno+_mese+"01") */
          _dataini = CPLib.CharToDate(_anno+_mese+"01");
          /* _datafin := arfn_finemese(_dataini) */
          _datafin = arfn_finemeseR.Make(m_Ctx,this).Run(_dataini);
          /* Exec "Nuovi Rapporti" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          Cursor_qbe_fam_noinvio_01_2015.Next();
        }
        m_cConnectivityError = Cursor_qbe_fam_noinvio_01_2015.ErrorMessage();
        Cursor_qbe_fam_noinvio_01_2015.Close();
        // * --- End Select
        /* gMsgImp := 'Premere il tasto con la lente per prelevare i file' // Messaggio Import */
        gMsgImp = "Premere il tasto con la lente per prelevare i file";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // * --- Select from tmp_listafile
        m_cServer = m_Ctx.GetServer("tmp_listafile");
        m_cPhName = m_Ctx.GetPhName("tmp_listafile");
        if (Cursor_tmp_listafile!=null)
          Cursor_tmp_listafile.Close();
        Cursor_tmp_listafile = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_listafile")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_listafile.Eof())) {
          /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(tmp_listafile->nomefile)+".zip" */
          cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile"))+".zip";
          /* FileLibMit.DeleteFilePath(cNomeFile) */
          FileLibMit.DeleteFilePath(cNomeFile);
          Cursor_tmp_listafile.Next();
        }
        m_cConnectivityError = Cursor_tmp_listafile.ErrorMessage();
        Cursor_tmp_listafile.Close();
        // * --- End Select
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        // Legge i file degli esiti
        File di = new File(CPLib.LRTrim(gPathDoc)+"/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/");
        File fl[] = di.listFiles();
        int _i;
        int count=0;
        for (_i=0; _i < fl.length; _i++)  {
          fl[_i].delete();
        }
        di = new File(CPLib.LRTrim(gPathDoc)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda)+"/");
        File fl1[] = di.listFiles();
        count=0;
        for (_i=0; _i < fl1.length; _i++)  {
          fl1[_i].delete();
        }
        /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000046status,0)) {
          m_Sql.SetTransactionStatus(nTry00000046status,cTry00000046msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione Nuovi Rapporti: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione Nuovi Rapporti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_fam_noinvio_01_2015!=null)
          Cursor_qbe_fam_noinvio_01_2015.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_listafile!=null)
          Cursor_tmp_listafile.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_fam_periodo01_minmax=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_fam_periodo01=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_anarapbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione periodo '+_anno+'-'+_mese+" : "+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Inizio Elaborazione periodo "+_anno+"-"+_mese+" : "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
      gMsgImp = "Attendere. Estrazione dati per il periodo ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _totrecord := 0 */
      _totrecord = CPLib.Round(0,0);
      // * --- Select from qbe_fam_periodo01_minmax
      SPBridge.HMCaller _h00000065;
      _h00000065 = new SPBridge.HMCaller();
      _h00000065.Set("m_cVQRList",m_cVQRList);
      _h00000065.Set("_dadata",_dataini);
      _h00000065.Set("_adata",_datafin);
      _h00000065.Set("_inviato",0);
      if (Cursor_qbe_fam_periodo01_minmax!=null)
        Cursor_qbe_fam_periodo01_minmax.Close();
      Cursor_qbe_fam_periodo01_minmax = new VQRHolder("qbe_fam_periodo01_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000065,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_fam_periodo01_minmax.Eof())) {
        /* _totrecord := _totrecord + qbe_fam_periodo01_minmax->TOTPRG */
        _totrecord = CPLib.Round(_totrecord+Cursor_qbe_fam_periodo01_minmax.GetDouble("TOTPRG"),0);
        Cursor_qbe_fam_periodo01_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_fam_periodo01_minmax.ErrorMessage();
      Cursor_qbe_fam_periodo01_minmax.Close();
      // * --- End Select
      /* If _totrecord > 0 */
      if (CPLib.gt(_totrecord,0)) {
        /* mcSID0.Zap() */
        mcSID0.Zap();
        /* mcSID1.Zap() */
        mcSID1.Zap();
        /* mcSID2.Zap() */
        mcSID2.Zap();
        /* mcSID2r.Zap() */
        mcSID2r.Zap();
        /* _nomefile := LRTrim(gIntemediario)+"_"+_anno+_mese+"_"+DateTimeToChar(DateTime()) */
        _nomefile = CPLib.LRTrim(gIntemediario)+"_"+_anno+_mese+"_"+CPLib.DateTimeToChar(CPLib.DateTime());
        /* fhand := FileLibMit.OpenWrite('/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
        fhand = FileLibMit.OpenWrite("/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
        /* _invio := _anno+_mese+"_2_1" */
        _invio = _anno+_mese+"_2_1";
        // * --- Insert into tmp_list_imprich from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"00000071")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000071(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
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
        /* rowSID0.CODINVIO := _invio */
        rowSID0.CODINVIO = _invio;
        /* rowSID0.TIPINVIO := '2' */
        rowSID0.TIPINVIO = "2";
        /* rowSID0.TPCINVIO := '1' */
        rowSID0.TPCINVIO = "1";
        /* rowSID0.ANNINVIO := _anno */
        rowSID0.ANNINVIO = _anno;
        /* rowSID0.MESINVIO := _mese */
        rowSID0.MESINVIO = _mese;
        /* rowSID0.FLEINVIO := _nomefile */
        rowSID0.FLEINVIO = _nomefile;
        /* mcSID0.AppendRow(rowSID0) */
        mcSID0.AppendRow(rowSID0);
        /* _crea := 1 */
        _crea = CPLib.Round(1,0);
        /* _riga := '0' */
        _riga = "0";
        /* _riga := _riga + 'ARU00' */
        _riga = _riga+"ARU00";
        /* _riga := _riga + '2' */
        _riga = _riga+"2";
        /* _riga := _riga + '1' */
        _riga = _riga+"1";
        /* _riga := _riga + _anno */
        _riga = _riga+_anno;
        /* _riga := _riga + _mese */
        _riga = _riga+_mese;
        /* _riga := _riga + Space(24) */
        _riga = _riga+CPLib.Space(24);
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(intermbo->CODFISC),16) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC")),16);
          /* _cfinter := LRTrim(intermbo->CODFISC) */
          _cfinter = CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"));
          /* _intercab := intermbo->CODCAB */
          _intercab = Cursor_intermbo.GetString("CODCAB");
          /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
          if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
            /* _riga := _riga +LibreriaMit.SpacePad(intermbo->COGNOME,26) // Invio Ordinario */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("COGNOME"),26);
            /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NOME,25) // Invio Ordinario */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NOME"),25);
            /* _riga := _riga +LibreriaMit.SpacePad(intermbo->SESSO,1) // Invio Ordinario */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("SESSO"),1);
            /* _riga := _riga +arfn_fdate_nd(intermbo->DATANASC,'N') // Invio Ordinario */
            _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_intermbo.GetDate("DATANASC"),"N");
            /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NASCOMUN,40) // Invio Ordinario */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NASCOMUN"),40);
            /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVNA,2) // Invio Ordinario */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVNA"),2);
            /* _riga := _riga +Space(112) // Invio Ordinario */
            _riga = _riga+CPLib.Space(112);
          } else { // Else
            /* _riga := _riga +Space(102) // Invio Ordinario */
            _riga = _riga+CPLib.Space(102);
            /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->RAGSOC,' '),70) // Invio Ordinario */
            _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("RAGSOC")," "),70);
            /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->DESCCIT,' '),40) // Invio Ordinario */
            _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("DESCCIT")," "),40);
            /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVINCIA,2) // Invio Ordinario */
            _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
          } // End If
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        /* _riga := _riga +Space(16) // Invio Ordinario */
        _riga = _riga+CPLib.Space(16);
        /* _riga := _riga +'0' // Invio Ordinario */
        _riga = _riga+"0";
        /* _riga := _riga + Space(112) // Invio Ordinario */
        _riga = _riga+CPLib.Space(112);
        /* _riga := _riga + 'A' // Invio Ordinario */
        _riga = _riga+"A";
        /* FileLibMit.WriteLine(fhand,_riga) */
        FileLibMit.WriteLine(fhand,_riga);
        /* mcSID0.Zap() */
        mcSID0.Zap();
        /* mcSID1.Zap() */
        mcSID1.Zap();
        /* mcSID2.Zap() */
        mcSID2.Zap();
        /* mcSID2r.Zap() */
        mcSID2r.Zap();
        // * --- Fill memory cursor mcTemp on qbe_fam_periodo01
        mcTemp.Zap();
        SPBridge.HMCaller _h0000009E;
        _h0000009E = new SPBridge.HMCaller();
        _h0000009E.Set("m_cVQRList",m_cVQRList);
        _h0000009E.Set("_dadata",_dataini);
        _h0000009E.Set("_adata",_datafin);
        _h0000009E.Set("_inviato",0);
        if (Cursor_qbe_fam_periodo01!=null)
          Cursor_qbe_fam_periodo01.Close();
        Cursor_qbe_fam_periodo01 = new VQRHolder("qbe_fam_periodo01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000009E,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_fam_periodo01;
          Cursor_qbe_fam_periodo01.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,100000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_famnoinvio: query on qbe_fam_periodo01 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 100000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_fam_periodo01.Eof())) {
          mcTemp.AppendBlank();
          mcTemp.row.RAPPORTO = Cursor_qbe_fam_periodo01.GetString("RAPPORTO");
          mcTemp.row.DATAINI = Cursor_qbe_fam_periodo01.GetDate("DATAINI");
          mcTemp.row.DATAFINE = Cursor_qbe_fam_periodo01.GetDate("DATAFINE");
          mcTemp.row.TIPOAG = Cursor_qbe_fam_periodo01.GetString("TIPOAG");
          mcTemp.row.TIPORAP = Cursor_qbe_fam_periodo01.GetString("TIPORAP");
          mcTemp.row.DESCRAP = Cursor_qbe_fam_periodo01.GetString("DESCRAP");
          mcTemp.row.VALUTA = Cursor_qbe_fam_periodo01.GetString("VALUTA");
          mcTemp.row.INVIATO = Cursor_qbe_fam_periodo01.GetDouble("INVIATO");
          mcTemp.row.TIPO = Cursor_qbe_fam_periodo01.GetString("TIPO");
          mcTemp.row.CAB = Cursor_qbe_fam_periodo01.GetString("CAB");
          mcTemp.row.UNIQUECODE = Cursor_qbe_fam_periodo01.GetString("UNIQUECODE");
          mcTemp.row.OLDINTER = Cursor_qbe_fam_periodo01.GetString("OLDINTER");
          mcTemp.row.IDBASE = Cursor_qbe_fam_periodo01.GetString("IDBASE");
          mcTemp.row.DATAMODI = Cursor_qbe_fam_periodo01.GetDate("DATAMODI");
          mcTemp.row.IDESITO = Cursor_qbe_fam_periodo01.GetString("IDESITO");
          mcTemp.row.ISOAGE = Cursor_qbe_fam_periodo01.GetString("ISOAGE");
          Cursor_qbe_fam_periodo01.Next();
        }
        m_cConnectivityError = Cursor_qbe_fam_periodo01.ErrorMessage();
        Cursor_qbe_fam_periodo01.Close();
        mcTemp.GoTop();
        /* If mcTemp.RecCount() > 0 */
        if (CPLib.gt(mcTemp.RecCount(),0)) {
          for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
            /* _unique := iif(not(Empty(rowTemp.UNIQUECODE)),rowTemp.UNIQUECODE,iif(Empty(rowTemp.OLDINTER),LRTrim(_cfinter),LRTrim(rowTemp.OLDINTER))+"_2015_"+LRTrim(rowTemp.RAPPORTO)) */
            _unique = ( ! (CPLib.Empty(rowTemp.UNIQUECODE))?rowTemp.UNIQUECODE:(CPLib.Empty(rowTemp.OLDINTER)?CPLib.LRTrim(_cfinter):CPLib.LRTrim(rowTemp.OLDINTER))+"_2015_"+CPLib.LRTrim(rowTemp.RAPPORTO));
            /* _newuc := iif(not(Empty(rowTemp.UNIQUECODE)),'N','S') */
            _newuc = ( ! (CPLib.Empty(rowTemp.UNIQUECODE))?"N":"S");
            /* rowSID1.CODINVIO1 := _invio */
            rowSID1.CODINVIO1 = _invio;
            /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
            rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
            /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
            rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
            /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
            rowSID1.INIINVIO1 = rowTemp.DATAINI;
            /* rowSID1.FININVIO1 := iif(rowTemp.DATAFINE>= _dataini and rowTemp.DATAFINE<= _datafin,rowTemp.DATAFINE,NullDate()) */
            rowSID1.FININVIO1 = (CPLib.ge(rowTemp.DATAFINE,_dataini) && CPLib.le(rowTemp.DATAFINE,_datafin)?rowTemp.DATAFINE:CPLib.NullDate());
            /* rowSID1.TIPINVIO1 := '2' */
            rowSID1.TIPINVIO1 = "2";
            /* rowSID1.TPCINVIO1 := '1' */
            rowSID1.TPCINVIO1 = "1";
            /* If At(rowTemp.TIPOAG,'|01|02|03|12|13') <> 0 */
            if (CPLib.ne(CPLib.At(rowTemp.TIPOAG,"|01|02|03|12|13"),0)) {
              /* rowSID1.CABINVIO1 := iif(Empty(rowTemp.CAB),LibreriaMit.SpacePad(LRTrim(_intercab),5),LibreriaMit.SpacePad(LRTrim(rowTemp.CAB),5)) */
              rowSID1.CABINVIO1 = (CPLib.Empty(rowTemp.CAB)?LibreriaMit.SpacePad(CPLib.LRTrim(_intercab),5):LibreriaMit.SpacePad(CPLib.LRTrim(rowTemp.CAB),5));
            } else { // Else
              /* rowSID1.CABINVIO1 := '' */
              rowSID1.CABINVIO1 = "";
            } // End If
            /* rowSID1.UNIQUE1 := _unique */
            rowSID1.UNIQUE1 = _unique;
            /* rowSID1.FLGUNQ1 := _newuc */
            rowSID1.FLGUNQ1 = _newuc;
            /* mcSID1.AppendRow(rowSID1) */
            mcSID1.AppendRow(rowSID1);
            /* _tipo1 := _tipo1 + 1 */
            _tipo1 = CPLib.Round(_tipo1+1,0);
            /* _riga := '1' */
            _riga = "1";
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_unique),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_unique),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowTemp.TIPOAG),2) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowTemp.TIPOAG),2);
            /* _riga := _riga + iif(rowTemp.TIPOAG='99',LibreriaMit.SpacePad(LRTrim(Upper(arfn_agechar(rowTemp.DESCRAP,' '))),24),Space(24)) */
            _riga = _riga+(CPLib.eqr(rowTemp.TIPOAG,"99")?LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Upper(arfn_agecharR.Make(m_Ctx,this).Run(rowTemp.DESCRAP," "))),24):CPLib.Space(24));
            /* _riga := _riga + arfn_fdate_nd(rowTemp.DATAINI,'N') */
            _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowTemp.DATAINI,"N");
            /* _riga := _riga + iif(rowTemp.DATAFINE>= _dataini and rowTemp.DATAFINE<= _datafin,arfn_fdate_nd(rowTemp.DATAFINE,'N'),'01010001') */
            _riga = _riga+(CPLib.ge(rowTemp.DATAFINE,_dataini) && CPLib.le(rowTemp.DATAFINE,_datafin)?arfn_fdate_ndR.Make(m_Ctx,this).Run(rowTemp.DATAFINE,"N"):"01010001");
            /* If At(rowTemp.TIPOAG,'|01|02|03|12|13') <> 0 */
            if (CPLib.ne(CPLib.At(rowTemp.TIPOAG,"|01|02|03|12|13"),0)) {
              /* _riga := _riga + iif(Empty(rowTemp.CAB),LibreriaMit.SpacePad(LRTrim(_intercab),5),LibreriaMit.SpacePad(LRTrim(rowTemp.CAB),5)) */
              _riga = _riga+(CPLib.Empty(rowTemp.CAB)?LibreriaMit.SpacePad(CPLib.LRTrim(_intercab),5):LibreriaMit.SpacePad(CPLib.LRTrim(rowTemp.CAB),5));
            } else { // Else
              /* _riga := _riga + Space(5) */
              _riga = _riga+CPLib.Space(5);
            } // End If
            /* _riga := _riga + Space(13) */
            _riga = _riga+CPLib.Space(13);
            /* _riga := _riga + Space(286) */
            _riga = _riga+CPLib.Space(286);
            /* _riga := _riga + 'A' */
            _riga = _riga+"A";
            /* FileLibMit.WriteLine(fhand,_riga) */
            FileLibMit.WriteLine(fhand,_riga);
            /* mcSID2r := arfn_fam_mesefile02(rowSID1,_dataini,_datafin,rowTemp.TIPO) */
            mcSID2r = arfn_fam_mesefile02R.Make(m_Ctx,this).Run(rowSID1,_dataini,_datafin,rowTemp.TIPO);
            for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2r._iterable_()) {
              /* mcSID2.AppendRow(rowSID2) */
              mcSID2.AppendRow(rowSID2);
              /* _tipo2 := _tipo2 + 1 */
              _tipo2 = CPLib.Round(_tipo2+1,0);
              /* _riga := '2' */
              _riga = "2";
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_unique),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_unique),50);
              /* _riga := _riga + Right('000000000'+LRTrim(Str(rowSID2.APRINVIO2,9,0)),9) */
              _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(rowSID2.APRINVIO2,9,0)),9);
              /* _riga := _riga + arfn_fdate_nd(rowSID2.INIINVIO2,'N') */
              _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowSID2.INIINVIO2,"N");
              /* _riga := _riga + iif(rowSID2.FININVIO2 >= _dataini and rowSID2.FININVIO2<= _datafin,arfn_fdate_nd(rowSID2.FININVIO2,'N'),'01010001') */
              _riga = _riga+(CPLib.ge(rowSID2.FININVIO2,_dataini) && CPLib.le(rowSID2.FININVIO2,_datafin)?arfn_fdate_ndR.Make(m_Ctx,this).Run(rowSID2.FININVIO2,"N"):"01010001");
              /* _riga := _riga + Str(rowSID2.FCFINVIO2,1,0) */
              _riga = _riga+CPLib.Str(rowSID2.FCFINVIO2,1,0);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowSID2.CFSINVIO2),16) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowSID2.CFSINVIO2),16);
              /* _riga := _riga + rowSID2.RUOINVIO2 */
              _riga = _riga+rowSID2.RUOINVIO2;
              /* If not(Empty(rowSID2.SEXINVIO2)) */
              if ( ! (CPLib.Empty(rowSID2.SEXINVIO2))) {
                /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(rowSID2.COGINVIO2,' '),26) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.COGINVIO2," "),26);
                /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(rowSID2.NOMINVIO2,' '),25) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.NOMINVIO2," "),25);
                /* _riga := _riga +LibreriaMit.SpacePad(rowSID2.SEXINVIO2,1) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(rowSID2.SEXINVIO2,1);
                /* _riga := _riga +arfn_fdate_nd(rowSID2.DNSINVIO2,'N') // Invio Ordinario */
                _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowSID2.DNSINVIO2,"N");
                /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(arfn_agechar(rowSID2.CNSINVIO2,' ')),40) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.CNSINVIO2," ")),40);
                /* _riga := _riga +LibreriaMit.SpacePad(rowSID2.PNSINVIO2,2) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(rowSID2.PNSINVIO2,2);
                /* _riga := _riga +Space(102) // Invio Ordinario */
                _riga = _riga+CPLib.Space(102);
              } else { // Else
                /* _riga := _riga +Space(102) // Invio Ordinario */
                _riga = _riga+CPLib.Space(102);
                /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(arfn_agechar(rowSID2.RGSINVIO2,' ')),60) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.RGSINVIO2," ")),60);
                /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(arfn_agechar(rowSID2.CSLINVIO2,' ')),40) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.CSLINVIO2," ")),40);
                /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(rowSID2.PLSINVIO2),2) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowSID2.PLSINVIO2),2);
              } // End If
              /* _riga := _riga + Space(99) */
              _riga = _riga+CPLib.Space(99);
              /* _riga := _riga + 'A' */
              _riga = _riga+"A";
              /* FileLibMit.WriteLine(fhand,_riga) */
              FileLibMit.WriteLine(fhand,_riga);
            }
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* cProg := Utilities.GetAutonumber("PRGAGESID\'"+LRTrim(gAzienda)+"'",'',10) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAGESID\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aefaminvio from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aefaminvio");
            m_cPhName = m_Ctx.GetPhName("aefaminvio");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefaminvio",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"000000DF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000DF(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2015","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_mese,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefaminvio",true);
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
            /* gMsgImp := 'Sono stati generati '+LRTrim(Str(_conta,10,0))+" record" // Messaggio Import */
            gMsgImp = "Sono stati generati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" record";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          }
        } // End If
        /* Exec "Operazioni Extraconto" Page 3:Page_3 */
        Page_3();
        /* _riga := '9' */
        _riga = "9";
        /* _riga := _riga + Right('000000000'+LRTrim(Str(_tipo1,9,0)),9) */
        _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_tipo1,9,0)),9);
        /* _riga := _riga + Right('000000000'+LRTrim(Str(_tipo2,9,0)),9) */
        _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_tipo2,9,0)),9);
        /* _riga := _riga + Right('000000000'+LRTrim(Str(_tipo3,9,0)),9) */
        _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_tipo3,9,0)),9);
        /* _riga := _riga + Right('000000000'+LRTrim(Str(_tipo4,9,0)),9) */
        _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_tipo4,9,0)),9);
        /* _riga := _riga + Space(360) // Invio Ordinario */
        _riga = _riga+CPLib.Space(360);
        /* _riga := _riga + 'A' // Invio Ordinario */
        _riga = _riga+"A";
        /* FileLibMit.WriteLine(fhand,_riga) */
        FileLibMit.WriteLine(fhand,_riga);
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        // * --- Insert into aesaldi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aesaldi");
        m_cPhName = m_Ctx.GetPhName("aesaldi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"000000ED")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000ED(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("2015","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_mese,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aesaldi",true);
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
        /* _sid := arfn_exec_sid(_nomefile,'2015') */
        _sid = arfn_exec_sidR.Make(m_Ctx,this).Run(_nomefile,"2015");
        /* If _sid.RecCount() > 0 */
        if (CPLib.gt(_sid.RecCount(),0)) {
          for (MemoryCursorRow_mcmessaggi_mcrdef rowErrore : _sid._iterable_()) {
            /* gMsgProc := gMsgProc + LRTrim(rowErrore.testata) + NL // Messaggio */
            gMsgProc = gMsgProc+CPLib.LRTrim(rowErrore.testata)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          }
          // Transaction Error
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'Rilevati errori durante il controllo da parte del SID'"));
        } else { // Else
          // * --- Delete from sid_invio2
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sid_invio2");
          m_cPhName = m_Ctx.GetPhName("sid_invio2");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"000000F4")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODINVIO2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
          // * --- Delete from sid_invio1
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sid_invio1");
          m_cPhName = m_Ctx.GetPhName("sid_invio1");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"000000F5")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODINVIO1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
          // * --- Delete from sid_invio
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sid_invio");
          m_cPhName = m_Ctx.GetPhName("sid_invio");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"000000F6")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CODINVIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
          /* gMsgProc := gMsgProc + 'Ora Inizio Aggiornamento Dati: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Inizio Aggiornamento Dati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          for (MemoryCursorRow_sid_invio rowSID0 : mcSID0._iterable_()) {
            // * --- Insert into sid_invio from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sid_invio");
            m_cPhName = m_Ctx.GetPhName("sid_invio");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"000000F9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000F9(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.CODINVIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.TIPINVIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.TPCINVIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.ANNINVIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.MESINVIO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio",true);
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
          }
          /* _conta := 0 */
          _conta = CPLib.Round(0,0);
          /* _oldmsg := '' */
          _oldmsg = "";
          for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
            /* gMsgImp := "Sto aggiornando l'operazione " + LRTrim(Str(_conta,10,0)) + " su " + LRTrim(Str(_totrecord,10,0)) // Messaggio Import */
            gMsgImp = "Sto aggiornando l'operazione "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_totrecord,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + LRTrim(gMsgImp) // Messaggio */
              gMsgProc = gMsgProc+CPLib.LRTrim(gMsgImp);
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,LRTrim(_oldmsg),LRTrim(gMsgImp)) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,CPLib.LRTrim(_oldmsg),CPLib.LRTrim(gMsgImp));
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := "Sto aggiornando l'operazione " + LRTrim(Str(_conta,10,0)) + " su " + LRTrim(Str(_totrecord,10,0)) */
            _oldmsg = "Sto aggiornando l'operazione "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_totrecord,10,0));
            // * --- Insert into sid_invio1 from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sid_invio1");
            m_cPhName = m_Ctx.GetPhName("sid_invio1");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"00000102")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000102(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.CODINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPRINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.INIINVIO1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.FININVIO1,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TIPINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPCINVIO1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio1",true);
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
            /* If rowSID1.TPRINVIO1='98' */
            if (CPLib.eqr(rowSID1.TPRINVIO1,"98")) {
              /* gMsgImp := "Sto aggiornando l'operazione con codice: "+rowSID1.RAPINVIO1 // Messaggio Import */
              gMsgImp = "Sto aggiornando l'operazione con codice: "+rowSID1.RAPINVIO1;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"00000105")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(CPLib.LRTrim(_cfinter)+"_"+CPLib.LRTrim(rowSID1.RAPINVIO1),"C",50,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer),m_cServer,rowSID1.RAPINVIO1)+"";
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
              /* gMsgImp := "Sto aggiornando il rapporto: "+rowSID1.RAPINVIO1 // Messaggio Import */
              gMsgImp = "Sto aggiornando il rapporto: "+rowSID1.RAPINVIO1;
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _oldrap := '' */
              _oldrap = "";
              // * --- Read from aetesta
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID1.RAPINVIO1,"C",25,0,m_cServer),m_cServer,rowSID1.RAPINVIO1);
              if (m_Ctx.IsSharedTemp("aetesta")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _oldrap = Read_Cursor.GetString("RAPPORTO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aetesta into routine arrt_famnoinvio returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _oldrap = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_oldrap) */
              if (CPLib.Empty(_oldrap)) {
                // * --- Select from anarapbo
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                if (Cursor_anarapbo!=null)
                  Cursor_anarapbo.Close();
                Cursor_anarapbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer, m_oParameters),m_cServer,rowSID1.RAPINVIO1)+" "+")"+(m_Ctx.IsSharedTemp("anarapbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_anarapbo.Eof())) {
                  /* nProgImp := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
                  nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                  // * --- Insert into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"0000010C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000010C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_anarapbo.GetString("TIPORAP"),"1")?"1":"2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.CABINVIO1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_anarapbo.GetString("TIPOAG"),"99")?CPLib.Left(Cursor_anarapbo.GetString("DESCRAP"),24):""),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.UNIQUE1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_anarapbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_cfinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
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
                  Cursor_anarapbo.Next();
                }
                m_cConnectivityError = Cursor_anarapbo.ErrorMessage();
                Cursor_anarapbo.Close();
                // * --- End Select
              } else { // Else
                // * --- Write into aetesta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"0000010D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(CPLib.LRTrim(_cfinter)+"_2015_"+CPLib.LRTrim(rowSID1.RAPINVIO1),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(CPLib.LRTrim(_cfinter)+"_2015_"+CPLib.LRTrim(rowSID1.RAPINVIO1),"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer),m_cServer,rowSID1.RAPINVIO1)+"";
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
            /* If Empty(_oldmsg) */
            if (CPLib.Empty(_oldmsg)) {
              /* gMsgProc := gMsgProc + LRTrim(gMsgImp) // Messaggio */
              gMsgProc = gMsgProc+CPLib.LRTrim(gMsgImp);
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := Strtran(gMsgProc,LRTrim(_oldmsg),LRTrim(gMsgImp)) // Messaggio */
              gMsgProc = CPLib.Strtran(gMsgProc,CPLib.LRTrim(_oldmsg),CPLib.LRTrim(gMsgImp));
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* _oldmsg := LRTrim(gMsgImp) */
            _oldmsg = CPLib.LRTrim(gMsgImp);
          }
          for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2._iterable_()) {
            // * --- Insert into sid_invio2 from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sid_invio2");
            m_cPhName = m_Ctx.GetPhName("sid_invio2");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"00000113")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000113(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CODINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RAPINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.APRINVIO2,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.INIINVIO2,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FININVIO2,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FCFINVIO2,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CFSINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RUOINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.COGINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.NOMINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.SEXINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.DNSINVIO2,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CNSINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PNSINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RGSINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CSLINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PLSINVIO2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio2",true);
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
          }
          /* gMsgProc := gMsgProc + NL + 'Ora Fine Aggiornamento Dati: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"\n"+"Ora Fine Aggiornamento Dati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* gMsgProc := gMsgProc + 'Sono stati generati '+LRTrim(Str(_conta,10,0))+" record" +NL // Messaggio */
        gMsgProc = gMsgProc+"Sono stati generati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" record"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine controllo periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine controllo periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Non ci sono dati per il periodo considerato: '+arfn_fdate(_dataini)+" - " +arfn_fdate(_datafin)+NL // Messaggio */
        gMsgProc = gMsgProc+"Non ci sono dati per il periodo considerato: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataini)+" - "+arfn_fdateR.Make(m_Ctx,this).Run(_datafin)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione periodo '+_anno+'-'+_mese+" : "+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione periodo "+_anno+"-"+_mese+" : "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_fam_periodo01_minmax!=null)
          Cursor_qbe_fam_periodo01_minmax.Close();
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
        if (Cursor_qbe_fam_periodo01!=null)
          Cursor_qbe_fam_periodo01.Close();
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
        if (Cursor_anarapbo!=null)
          Cursor_anarapbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_famperiodo_opx_min_max=null;
    CPResultSet Cursor_qbe_famperiodo_opx01=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _contaopx := 0 */
      _contaopx = CPLib.Round(0,0);
      // * --- Select from qbe_famperiodo_opx_min_max
      SPBridge.HMCaller _h0000011E;
      _h0000011E = new SPBridge.HMCaller();
      _h0000011E.Set("m_cVQRList",m_cVQRList);
      _h0000011E.Set("_dadata",_dataini);
      _h0000011E.Set("_adata",_datafin);
      _h0000011E.Set("_inviato",1);
      if (Cursor_qbe_famperiodo_opx_min_max!=null)
        Cursor_qbe_famperiodo_opx_min_max.Close();
      Cursor_qbe_famperiodo_opx_min_max = new VQRHolder("qbe_famperiodo_opx_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000011E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_famperiodo_opx_min_max.Eof())) {
        /* _min := qbe_famperiodo_opx_min_max->MINPRG */
        _min = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max.GetDouble("MINPRG"),0);
        /* _max := qbe_famperiodo_opx_min_max->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max.GetDouble("MAXPRG"),0);
        /* _tot := qbe_famperiodo_opx_min_max->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max.GetDouble("TOTPRG"),0);
        Cursor_qbe_famperiodo_opx_min_max.Next();
      }
      m_cConnectivityError = Cursor_qbe_famperiodo_opx_min_max.ErrorMessage();
      Cursor_qbe_famperiodo_opx_min_max.Close();
      // * --- End Select
      /* If _tot > 0 */
      if (CPLib.gt(_tot,0)) {
        /* _mono := 0 */
        _mono = CPLib.Round(0,0);
        /* _oldmsg := '' */
        _oldmsg = "";
        /* _mono := iif(_tot > 15000,0,1) */
        _mono = CPLib.Round((CPLib.gt(_tot,15000)?0:1),0);
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* If _tot = 0 */
          if (CPLib.eqr(_tot,0)) {
            /* _cicli := 0 */
            _cicli = CPLib.Round(0,0);
          } else { // Else
            /* _cicli := 1 */
            _cicli = CPLib.Round(1,0);
          } // End If
        } else { // Else
          /* _reccount := _max - _min */
          _reccount = CPLib.Round(_max-_min,0);
          /* _cicli := iif(Mod(_reccount,5000) <> 0,Int(_reccount/5000) + 1,Int(_reccount/5000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,5000),0)?CPLib.Int(_reccount/5000)+1:CPLib.Int(_reccount/5000)),0);
        } // End If
        /* _contacicli := 1 */
        _contacicli = CPLib.Round(1,0);
        /* While _contacicli <= _cicli */
        while (CPLib.le(_contacicli,_cicli)) {
          /* If _mono = 1 */
          if (CPLib.eqr(_mono,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* If _contacicli=1 */
            if (CPLib.eqr(_contacicli,1)) {
              /* _bottom := _min */
              _bottom = CPLib.Round(_min,0);
              /* _top := _min + 4999 */
              _top = CPLib.Round(_min+4999,0);
              /* ElseIf _contacicli = _cicli */
            } else if (CPLib.eqr(_contacicli,_cicli)) {
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _bottom + 4999 */
              _top = CPLib.Round(_bottom+4999,0);
            } // End If
          } // End If
          /* gMsgImp := 'Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Periodo: '+_anno+'-'+_mese+' - Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio */
            gMsgProc = gMsgProc+"Periodo: "+_anno+"-"+_mese+" - Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Periodo: '+_anno+'-'+_mese+" - " + LRTrim(gMsgImp)) // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Periodo: "+_anno+"-"+_mese+" - "+CPLib.LRTrim(gMsgImp));
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Periodo: '+_anno+'-'+_mese+' - Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) */
          _oldmsg = "Periodo: "+_anno+"-"+_mese+" - Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            /* mcSID2r.Zap() */
            mcSID2r.Zap();
            /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
            gMsgImp = "Lettura operazioni extraconto in corso ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Fill memory cursor mcTemp on qbe_famperiodo_opx01
            mcTemp.Zap();
            SPBridge.HMCaller _h00000144;
            _h00000144 = new SPBridge.HMCaller();
            _h00000144.Set("m_cVQRList",m_cVQRList);
            _h00000144.Set("_dadata",_dataini);
            _h00000144.Set("_adata",_datafin);
            _h00000144.Set("_inviato",0);
            _h00000144.Set("_bottom",_bottom);
            _h00000144.Set("_top",_top);
            if (Cursor_qbe_famperiodo_opx01!=null)
              Cursor_qbe_famperiodo_opx01.Close();
            Cursor_qbe_famperiodo_opx01 = new VQRHolder("qbe_famperiodo_opx01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000144,true).GetResultSet(m_Ctx);
            {
              final CPResultSet m_TheCursor = Cursor_qbe_famperiodo_opx01;
              Cursor_qbe_famperiodo_opx01.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_famnoinvio: query on qbe_famperiodo_opx01 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_qbe_famperiodo_opx01.Eof())) {
              mcTemp.AppendBlank();
              mcTemp.row.RAPPORTO = Cursor_qbe_famperiodo_opx01.GetString("RAPPORTO");
              mcTemp.row.DATAINI = Cursor_qbe_famperiodo_opx01.GetDate("DATAINI");
              mcTemp.row.DATAFINE = Cursor_qbe_famperiodo_opx01.GetDate("DATAFINE");
              mcTemp.row.TIPOAG = Cursor_qbe_famperiodo_opx01.GetString("TIPOAG");
              mcTemp.row.TIPORAP = Cursor_qbe_famperiodo_opx01.GetString("TIPORAP");
              mcTemp.row.DESCRAP = Cursor_qbe_famperiodo_opx01.GetString("DESCRAP");
              mcTemp.row.VALUTA = Cursor_qbe_famperiodo_opx01.GetString("VALUTA");
              mcTemp.row.INVIATO = Cursor_qbe_famperiodo_opx01.GetDouble("INVIATO");
              mcTemp.row.TIPO = Cursor_qbe_famperiodo_opx01.GetString("TIPO");
              mcTemp.row.CAB = Cursor_qbe_famperiodo_opx01.GetString("CAB");
              mcTemp.row.UNIQUECODE = Cursor_qbe_famperiodo_opx01.GetString("UNIQUECODE");
              mcTemp.row.OLDINTER = Cursor_qbe_famperiodo_opx01.GetString("OLDINTER");
              mcTemp.row.IDBASE = Cursor_qbe_famperiodo_opx01.GetString("IDBASE");
              mcTemp.row.DATAMODI = Cursor_qbe_famperiodo_opx01.GetDate("DATAMODI");
              mcTemp.row.IDESITO = Cursor_qbe_famperiodo_opx01.GetString("IDESITO");
              mcTemp.row.ISOAGE = Cursor_qbe_famperiodo_opx01.GetString("ISOAGE");
              Cursor_qbe_famperiodo_opx01.Next();
            }
            m_cConnectivityError = Cursor_qbe_famperiodo_opx01.ErrorMessage();
            Cursor_qbe_famperiodo_opx01.Close();
            mcTemp.GoTop();
            /* If mcTemp.RecCount() > 0 */
            if (CPLib.gt(mcTemp.RecCount(),0)) {
              for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
                /* _unique := iif(not(Empty(rowTemp.UNIQUECODE)),rowTemp.UNIQUECODE,iif(Empty(rowTemp.OLDINTER),LRTrim(_cfinter),LRTrim(rowTemp.OLDINTER))+LRTrim(rowTemp.RAPPORTO)) */
                _unique = ( ! (CPLib.Empty(rowTemp.UNIQUECODE))?rowTemp.UNIQUECODE:(CPLib.Empty(rowTemp.OLDINTER)?CPLib.LRTrim(_cfinter):CPLib.LRTrim(rowTemp.OLDINTER))+CPLib.LRTrim(rowTemp.RAPPORTO));
                /* _newuc := iif(not(Empty(rowTemp.UNIQUECODE)),'N','S') */
                _newuc = ( ! (CPLib.Empty(rowTemp.UNIQUECODE))?"N":"S");
                /* rowSID1.CODINVIO1 := _invio */
                rowSID1.CODINVIO1 = _invio;
                /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
                rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
                /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
                rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
                /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
                rowSID1.INIINVIO1 = rowTemp.DATAINI;
                /* rowSID1.FININVIO1 := rowTemp.DATAFINE */
                rowSID1.FININVIO1 = rowTemp.DATAFINE;
                /* rowSID1.TIPINVIO1 := '2' */
                rowSID1.TIPINVIO1 = "2";
                /* rowSID1.TPCINVIO1 := '1' */
                rowSID1.TPCINVIO1 = "1";
                /* mcSID1.AppendRow(rowSID1) */
                mcSID1.AppendRow(rowSID1);
                /* rowSID1.UNIQUE1 := _unique */
                rowSID1.UNIQUE1 = _unique;
                /* rowSID1.FLGUNQ1 := _newuc */
                rowSID1.FLGUNQ1 = _newuc;
                /* _tipo1 := _tipo1 + 1 */
                _tipo1 = CPLib.Round(_tipo1+1,0);
                /* _riga := '1' */
                _riga = "1";
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_unique),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_unique),50);
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowTemp.TIPOAG),2) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowTemp.TIPOAG),2);
                /* _riga := _riga + iif(rowTemp.TIPOAG='99',LibreriaMit.SpacePad(LRTrim(Upper(arfn_agechar(rowTemp.DESCRAP,' '))),24),Space(24)) */
                _riga = _riga+(CPLib.eqr(rowTemp.TIPOAG,"99")?LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Upper(arfn_agecharR.Make(m_Ctx,this).Run(rowTemp.DESCRAP," "))),24):CPLib.Space(24));
                /* _riga := _riga + arfn_fdate_nd(rowTemp.DATAINI,'N') */
                _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowTemp.DATAINI,"N");
                /* _riga := _riga + '01010001' */
                _riga = _riga+"01010001";
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowTemp.CAB),5) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowTemp.CAB),5);
                /* _riga := _riga + Space(13) */
                _riga = _riga+CPLib.Space(13);
                /* _riga := _riga + Space(286) */
                _riga = _riga+CPLib.Space(286);
                /* _riga := _riga + 'A' */
                _riga = _riga+"A";
                /* FileLibMit.WriteLine(fhand,_riga) */
                FileLibMit.WriteLine(fhand,_riga);
                /* mcSID2r := arfn_fam_mesefile02(rowSID1,_dataini,_datafin,rowTemp.TIPO) */
                mcSID2r = arfn_fam_mesefile02R.Make(m_Ctx,this).Run(rowSID1,_dataini,_datafin,rowTemp.TIPO);
                for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2r._iterable_()) {
                  /* mcSID2.AppendRow(rowSID2) */
                  mcSID2.AppendRow(rowSID2);
                  /* _tipo2 := _tipo2 + 1 */
                  _tipo2 = CPLib.Round(_tipo2+1,0);
                  /* _riga := '2' */
                  _riga = "2";
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_unique),50) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_unique),50);
                  /* _riga := _riga + Right('000000000'+LRTrim(Str(rowSID2.APRINVIO2,9,0)),9) */
                  _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(rowSID2.APRINVIO2,9,0)),9);
                  /* _riga := _riga + arfn_fdate_nd(rowSID2.INIINVIO2,'N') */
                  _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowSID2.INIINVIO2,"N");
                  /* _riga := _riga + '01010001' */
                  _riga = _riga+"01010001";
                  /* _riga := _riga + Str(rowSID2.FCFINVIO2,1,0) */
                  _riga = _riga+CPLib.Str(rowSID2.FCFINVIO2,1,0);
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowSID2.CFSINVIO2),16) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowSID2.CFSINVIO2),16);
                  /* _riga := _riga + rowSID2.RUOINVIO2 */
                  _riga = _riga+rowSID2.RUOINVIO2;
                  /* If not(Empty(rowSID2.SEXINVIO2)) */
                  if ( ! (CPLib.Empty(rowSID2.SEXINVIO2))) {
                    /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(rowSID2.COGINVIO2,' '),26) // Invio Ordinario */
                    _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.COGINVIO2," "),26);
                    /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(rowSID2.NOMINVIO2,' '),25) // Invio Ordinario */
                    _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.NOMINVIO2," "),25);
                    /* _riga := _riga +LibreriaMit.SpacePad(rowSID2.SEXINVIO2,1) // Invio Ordinario */
                    _riga = _riga+LibreriaMit.SpacePad(rowSID2.SEXINVIO2,1);
                    /* _riga := _riga +arfn_fdate_nd(rowSID2.DNSINVIO2,'N') // Invio Ordinario */
                    _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowSID2.DNSINVIO2,"N");
                    /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(arfn_agechar(rowSID2.CNSINVIO2,' ')),40) // Invio Ordinario */
                    _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.CNSINVIO2," ")),40);
                    /* _riga := _riga +LibreriaMit.SpacePad(rowSID2.PNSINVIO2,2) // Invio Ordinario */
                    _riga = _riga+LibreriaMit.SpacePad(rowSID2.PNSINVIO2,2);
                    /* _riga := _riga +Space(102) // Invio Ordinario */
                    _riga = _riga+CPLib.Space(102);
                  } else { // Else
                    /* _riga := _riga +Space(102) // Invio Ordinario */
                    _riga = _riga+CPLib.Space(102);
                    /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(arfn_agechar(rowSID2.RGSINVIO2,' ')),60) // Invio Ordinario */
                    _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.RGSINVIO2," ")),60);
                    /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(arfn_agechar(rowSID2.CSLINVIO2,' ')),40) // Invio Ordinario */
                    _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.CSLINVIO2," ")),40);
                    /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(rowSID2.PLSINVIO2),2) // Invio Ordinario */
                    _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowSID2.PLSINVIO2),2);
                  } // End If
                  /* _riga := _riga + Space(99) */
                  _riga = _riga+CPLib.Space(99);
                  /* _riga := _riga + 'A' */
                  _riga = _riga+"A";
                  /* FileLibMit.WriteLine(fhand,_riga) */
                  FileLibMit.WriteLine(fhand,_riga);
                }
                /* mcSID3r := arfn_fam_mesefile03(rowSID1,Year(rowTemp.DATAINI),rowTemp.TIPO,rowTemp.VALUTA) */
                mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,CPLib.Year(rowTemp.DATAINI),rowTemp.TIPO,rowTemp.VALUTA);
                for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
                  /* If rowSID3.ANNINVIO3 <> 2015 */
                  if (CPLib.ne(rowSID3.ANNINVIO3,2015)) {
                    /* mcSID3.AppendRow(rowSID3) */
                    mcSID3.AppendRow(rowSID3);
                    /* _tipo3 := _tipo3 + 1 */
                    _tipo3 = CPLib.Round(_tipo3+1,0);
                    /* _riga := '3' */
                    _riga = "3";
                    /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_unique),50) */
                    _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_unique),50);
                    /* _riga := _riga + rowTemp.TIPOAG */
                    _riga = _riga+rowTemp.TIPOAG;
                    /* _riga := _riga + Str(rowSID3.ANNINVIO3,4,0) */
                    _riga = _riga+CPLib.Str(rowSID3.ANNINVIO3,4,0);
                    /* _riga := _riga + iif(rowSID3.IM1INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM1INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM1INVIO3,17,0)),17)) */
                    _riga = _riga+(CPLib.lt(rowSID3.IM1INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM1INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM1INVIO3,17,0)),17));
                    /* _riga := _riga + Str(rowSID3.FI1INVIO3,1,0) */
                    _riga = _riga+CPLib.Str(rowSID3.FI1INVIO3,1,0);
                    /* _riga := _riga + iif(rowSID3.IM2INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM2INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM2INVIO3,17,0)),17)) */
                    _riga = _riga+(CPLib.lt(rowSID3.IM2INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM2INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM2INVIO3,17,0)),17));
                    /* _riga := _riga + Str(rowSID3.FI2INVIO3,1,0) */
                    _riga = _riga+CPLib.Str(rowSID3.FI2INVIO3,1,0);
                    /* _riga := _riga + iif(rowSID3.IM3INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM3INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM3INVIO3,17,0)),17)) */
                    _riga = _riga+(CPLib.lt(rowSID3.IM3INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM3INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM3INVIO3,17,0)),17));
                    /* _riga := _riga + Str(rowSID3.FI3INVIO3,1,0) */
                    _riga = _riga+CPLib.Str(rowSID3.FI3INVIO3,1,0);
                    /* _riga := _riga + iif(rowSID3.IM4INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM4INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM4INVIO3,17,0)),17)) */
                    _riga = _riga+(CPLib.lt(rowSID3.IM4INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM4INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM4INVIO3,17,0)),17));
                    /* _riga := _riga + Str(rowSID3.FI4INVIO3,1,0) */
                    _riga = _riga+CPLib.Str(rowSID3.FI4INVIO3,1,0);
                    /* _riga := _riga + iif(rowSID3.IM5INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM5INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM5INVIO3,17,0)),17)) */
                    _riga = _riga+(CPLib.lt(rowSID3.IM5INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM5INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM5INVIO3,17,0)),17));
                    /* _riga := _riga + Str(rowSID3.FI5INVIO3,1,0) */
                    _riga = _riga+CPLib.Str(rowSID3.FI5INVIO3,1,0);
                    /* _riga := _riga + iif(rowSID3.IM6INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM6INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM6INVIO3,17,0)),17)) */
                    _riga = _riga+(CPLib.lt(rowSID3.IM6INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM6INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM6INVIO3,17,0)),17));
                    /* _riga := _riga + Str(rowSID3.FI6INVIO3,1,0) */
                    _riga = _riga+CPLib.Str(rowSID3.FI6INVIO3,1,0);
                    /* _riga := _riga + rowTemp.VALUTA */
                    _riga = _riga+rowTemp.VALUTA;
                    /* _riga := _riga + Space(229) */
                    _riga = _riga+CPLib.Space(229);
                    /* _riga := _riga + 'A' */
                    _riga = _riga+"A";
                    /* FileLibMit.WriteLine(fhand,_riga) */
                    FileLibMit.WriteLine(fhand,_riga);
                  } // End If
                }
                /* _contaopx := _contaopx + 1 */
                _contaopx = CPLib.Round(_contaopx+1,0);
                /* _conta := _conta + 1 */
                _conta = CPLib.Round(_conta+1,0);
                /* cProg := Utilities.GetAutonumber("PRGAGESID\'"+LRTrim(gAzienda)+"'",'',10) */
                cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAGESID\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
                // * --- Insert into aefaminvio from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aefaminvio");
                m_cPhName = m_Ctx.GetPhName("aefaminvio");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefaminvio",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famnoinvio",138,"0000019A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000019A(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("2015","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_mese,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_conta,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefaminvio",true);
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
                /* gMsgImp := 'Sono stati generati '+LRTrim(Str(_contaopx,10,0))+" record su un totale di "+LRTrim(Str(_tot,10,0)) // Messaggio Import */
                gMsgImp = "Sono stati generati "+CPLib.LRTrim(CPLib.Str(_contaopx,10,0))+" record su un totale di "+CPLib.LRTrim(CPLib.Str(_tot,10,0));
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              }
            } // End If
          } else { // Else
            /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
            gMsgImp = "Lettura operazioni extraconto in corso ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* _contacicli := _contacicli+1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End While
        /* gMsgProc := gMsgProc + NL // Messaggio */
        gMsgProc = gMsgProc+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_famperiodo_opx_min_max!=null)
          Cursor_qbe_famperiodo_opx_min_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famperiodo_opx01!=null)
          Cursor_qbe_famperiodo_opx01.Close();
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
      m_Caller.SetString("flgexist","C",1,0,w_flgexist);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_famnoinvioR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_famnoinvioR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_flgexist = m_Caller.GetString("flgexist","C",1,0);
    _conta = 0;
    _contaopx = 0;
    _errore = "";
    mcTemp = new MemoryCursor_tmp_stpperiodo();
    rowTemp = new MemoryCursorRow_tmp_stpperiodo();
    mcSID0 = new MemoryCursor_sid_invio();
    rowSID0 = new MemoryCursorRow_sid_invio();
    mcSID1 = new MemoryCursor_sid_invio1();
    rowSID1 = new MemoryCursorRow_sid_invio1();
    mcSID2 = new MemoryCursor_sid_invio2();
    rowSID2 = new MemoryCursorRow_sid_invio2();
    mcSID2r = new MemoryCursor_sid_invio2();
    mcSID3 = new MemoryCursor_sid_invio3();
    rowSID3 = new MemoryCursorRow_sid_invio3();
    mcSID3r = new MemoryCursor_sid_invio3();
    _crea = 0;
    _dataini = CPLib.NullDate();
    _datafin = CPLib.NullDate();
    _invio = CPLib.Space(10);
    _sid = new MemoryCursor_mcmessaggi_mcrdef();
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _cicli = 0;
    _totrecord = 0;
    _reccount = 0;
    _unique = CPLib.Space(50);
    _newuc = CPLib.Space(1);
    cProg = CPLib.Space(10);
    w_dataini = CPLib.NullDate();
    w_datafine = CPLib.NullDate();
    _anno = CPLib.Space(4);
    _oldrap = CPLib.Space(25);
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(10);
    cNomeFile = CPLib.Space(100);
    _mese = CPLib.Space(2);
    _riga = CPLib.Space(398);
    _tipo1 = 0;
    _tipo2 = 0;
    _tipo3 = 0;
    _tipo4 = 0;
    _oldmsg = CPLib.Space(100);
    _cfinter = CPLib.Space(16);
    _intercod = CPLib.Space(16);
    _intercab = CPLib.Space(5);
    nProgImp = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_fam_noinvio_01_2015,qbe_fam_periodo01_minmax,qbe_fam_periodo01,qbe_famperiodo_opx_min_max,qbe_famperiodo_opx01,
  public static final String m_cVQRList = ",qbe_fam_noinvio_01_2015,qbe_fam_periodo01_minmax,qbe_fam_periodo01,qbe_famperiodo_opx_min_max,qbe_famperiodo_opx01,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_exec_sid,arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdate,arfn_fdate_nd,arfn_fdatetime,arfn_finemese,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_exec_sid,arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdate,arfn_fdate_nd,arfn_fdatetime,arfn_finemese,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000071(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINVIO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"MESE,";
    p_cSql = p_cSql+"TIPOCOM,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"PROG,";
    p_cSql = p_cSql+"IDIDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefaminvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000ED(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"MESE,";
    p_cSql = p_cSql+"TIPOINVIO,";
    p_cSql = p_cSql+"TIPOCOMU,";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aesaldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+"TIPINVIO,";
    p_cSql = p_cSql+"TPCINVIO,";
    p_cSql = p_cSql+"ANNINVIO,";
    p_cSql = p_cSql+"MESINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000102(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO1,";
    p_cSql = p_cSql+"RAPINVIO1,";
    p_cSql = p_cSql+"TPRINVIO1,";
    p_cSql = p_cSql+"INIINVIO1,";
    p_cSql = p_cSql+"FININVIO1,";
    p_cSql = p_cSql+"TIPINVIO1,";
    p_cSql = p_cSql+"TPCINVIO1,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000010C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+"DESCRI,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"INVIATO,";
    p_cSql = p_cSql+"DATAINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000113(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO2,";
    p_cSql = p_cSql+"RAPINVIO2,";
    p_cSql = p_cSql+"APRINVIO2,";
    p_cSql = p_cSql+"INIINVIO2,";
    p_cSql = p_cSql+"FININVIO2,";
    p_cSql = p_cSql+"FCFINVIO2,";
    p_cSql = p_cSql+"CFSINVIO2,";
    p_cSql = p_cSql+"RUOINVIO2,";
    p_cSql = p_cSql+"COGINVIO2,";
    p_cSql = p_cSql+"NOMINVIO2,";
    p_cSql = p_cSql+"SEXINVIO2,";
    p_cSql = p_cSql+"DNSINVIO2,";
    p_cSql = p_cSql+"CNSINVIO2,";
    p_cSql = p_cSql+"PNSINVIO2,";
    p_cSql = p_cSql+"RGSINVIO2,";
    p_cSql = p_cSql+"CSLINVIO2,";
    p_cSql = p_cSql+"PLSINVIO2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio2",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000019A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINVIO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"MESE,";
    p_cSql = p_cSql+"TIPOCOM,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"PROG,";
    p_cSql = p_cSql+"IDIDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefaminvio",true);
    return p_cSql;
  }
}
