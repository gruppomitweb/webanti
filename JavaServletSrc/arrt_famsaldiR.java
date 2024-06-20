// * --- Area Manuale = BO - Header
// * --- arrt_famsaldi
import java.io.*;
import java.util.*;
// * --- Fine Area Manuale
public class arrt_famsaldiR implements CallerWithObjs {
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
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
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
  public String m_cPhName_sid_invio3;
  public String m_cServer_sid_invio3;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
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
  public String w_anno;
  public String w_flginvio;
  public String w_flgstp;
  public String w_anticipo;
  public double _conta;
  public String _errore;
  public MemoryCursor_mcsaldi_mcrdef mcTemp;
  public MemoryCursorRow_mcsaldi_mcrdef rowTemp;
  public MemoryCursor_sid_invio mcSID0;
  public MemoryCursorRow_sid_invio rowSID0;
  public MemoryCursor_sid_invio1 mcSID1;
  public MemoryCursorRow_sid_invio1 rowSID1;
  public MemoryCursor_sid_invio3 mcSID3;
  public MemoryCursorRow_sid_invio3 rowSID3;
  public MemoryCursor_sid_invio3 mcSID3r;
  public double _crea;
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
  public String _oldmsg;
  public double _errori;
  public String _newunq;
  public String cProg;
  public String fhand;
  public String _nomefile;
  public String cNomeFile;
  public String _mese;
  public String _riga;
  public double _tipo1;
  public double _tipo2;
  public double _tipo3;
  public double _tipo4;
  public String _unique;
  public String _cab;
  public String _cfinter;
  public double _inviati;
  public double _nosid;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gAzienda;
  public String gPathDoc;
  public String gPathApp;
  public java.sql.Date gScadSaldi ;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_famsaldi
  public int _r;
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  public byte[] buffer;
  // * --- Fine Area Manuale
  public arrt_famsaldiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_famsaldi",m_Caller);
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
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
    m_cPhName_sid_invio3 = p_ContextObject.GetPhName("sid_invio3");
    if (m_cPhName_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio3 = m_cPhName_sid_invio3+" "+m_Ctx.GetWritePhName("sid_invio3");
    }
    m_cServer_sid_invio3 = p_ContextObject.GetServer("sid_invio3");
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
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
    if (CPLib.eqr("_errori",p_cVarName)) {
      return _errori;
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
    if (CPLib.eqr("_inviati",p_cVarName)) {
      return _inviati;
    }
    if (CPLib.eqr("_nosid",p_cVarName)) {
      return _nosid;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_famsaldi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("flginvio",p_cVarName)) {
      return w_flginvio;
    }
    if (CPLib.eqr("flgstp",p_cVarName)) {
      return w_flgstp;
    }
    if (CPLib.eqr("anticipo",p_cVarName)) {
      return w_anticipo;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_invio",p_cVarName)) {
      return _invio;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_newunq",p_cVarName)) {
      return _newunq;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
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
    if (CPLib.eqr("_unique",p_cVarName)) {
      return _unique;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      return _cab;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      return _cfinter;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gScadSaldi ",p_cVarName)) {
      return gScadSaldi;
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
    if (CPLib.eqr("_errori",p_cVarName)) {
      _errori = value;
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
    if (CPLib.eqr("_inviati",p_cVarName)) {
      _inviati = value;
      return;
    }
    if (CPLib.eqr("_nosid",p_cVarName)) {
      _nosid = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("flginvio",p_cVarName)) {
      w_flginvio = value;
      return;
    }
    if (CPLib.eqr("flgstp",p_cVarName)) {
      w_flgstp = value;
      return;
    }
    if (CPLib.eqr("anticipo",p_cVarName)) {
      w_anticipo = value;
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
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_newunq",p_cVarName)) {
      _newunq = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
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
    if (CPLib.eqr("_unique",p_cVarName)) {
      _unique = value;
      return;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      _cab = value;
      return;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      _cfinter = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("gScadSaldi ",p_cVarName)) {
      gScadSaldi  = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      rowTemp = (MemoryCursorRow_mcsaldi_mcrdef)value;
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
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      rowSID3 = (MemoryCursorRow_sid_invio3)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      mcTemp = (MemoryCursor_mcsaldi_mcrdef)value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_famsaldi01_count=null;
    CPResultSet Cursor_qbe_famsaldi01=null;
    CPResultSet Cursor_tmp_list_imprich=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_anno Char(4) */
      /* w_flginvio Char(1) */
      /* w_flgstp Char(1) */
      /* w_anticipo Char(1) */
      /* _conta Numeric(10, 0) */
      /* _errore Memo */
      /* mcTemp MemoryCursor(mcSaldi.MCRDef) */
      /* rowTemp Row(mcSaldi.MCRDef) */
      /* mcSID0 MemoryCursor(sid_invio) */
      /* rowSID0 Row(sid_invio) */
      /* mcSID1 MemoryCursor(sid_invio1) */
      /* rowSID1 Row(sid_invio1) */
      /* mcSID3 MemoryCursor(sid_invio3) */
      /* rowSID3 Row(sid_invio3) */
      /* mcSID3r MemoryCursor(sid_invio3) */
      /* _crea Numeric(1, 0) */
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
      /* _oldmsg Memo */
      /* _errori Numeric(10, 0) */
      /* _newunq Char(1) */
      /* cProg Char(10) */
      /* fhand Char(10) */
      /* _nomefile Char(10) */
      /* cNomeFile Char(100) */
      /* _mese Char(2) */
      /* _riga Char(398) */
      /* _tipo1 Numeric(9, 0) */
      /* _tipo2 Numeric(9, 0) */
      /* _tipo3 Numeric(9, 0) */
      /* _tipo4 Numeric(9, 0) */
      /* _unique Char(50) */
      /* _cab Char(5) */
      /* _cfinter Char(16) */
      /* _inviati Numeric(1, 0) */
      /* _nosid Numeric(1, 0) */
      /* cOnlyNomeFile Char(100) */
      /* cNomeFileZip Char(100) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gPathApp Char(80) // Path Applicazione */
      /* gScadSaldi  Date // Scadenza Invio Saldi */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select FLGSIDAUTO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _nosid := intermbo->FLGSIDAUTO */
        _nosid = CPLib.Round(Cursor_intermbo.GetDouble("FLGSIDAUTO"),0);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
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
      /* gMsgProc := 'Ora Inizio  Elaborazione Saldi '+w_anno+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio  Elaborazione Saldi "+w_anno+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If Date() > gScadSaldi */
      if (CPLib.gt(CPLib.Date(),gScadSaldi)) {
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
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000004Astatus;
        nTry0000004Astatus = m_Sql.GetTransactionStatus();
        String cTry0000004Amsg;
        cTry0000004Amsg = m_Sql.TransactionErrorMessage();
        try {
          /* _inviati := iif(w_flginvio='S',1,0) */
          _inviati = CPLib.Round((CPLib.eqr(w_flginvio,"S")?1:0),0);
          /* _conta := 0 */
          _conta = CPLib.Round(0,0);
          /* gMsgProc := gMsgProc + "Estrazione dati per il periodo" + NL // Messaggio */
          gMsgProc = gMsgProc+"Estrazione dati per il periodo"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* _totrecord := 0 */
          _totrecord = CPLib.Round(0,0);
          // * --- Select from qbe_famsaldi01_count
          SPBridge.HMCaller _h0000004F;
          _h0000004F = new SPBridge.HMCaller();
          _h0000004F.Set("m_cVQRList",m_cVQRList);
          _h0000004F.Set("anno",w_anno);
          _h0000004F.Set("dainviare",0);
          _h0000004F.Set("inviati",_inviati);
          if (Cursor_qbe_famsaldi01_count!=null)
            Cursor_qbe_famsaldi01_count.Close();
          Cursor_qbe_famsaldi01_count = new VQRHolder("qbe_famsaldi01_count",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000004F,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_famsaldi01_count.Eof())) {
            /* _totrecord := _totrecord + qbe_famsaldi01_count->TOTPRG */
            _totrecord = CPLib.Round(_totrecord+Cursor_qbe_famsaldi01_count.GetDouble("TOTPRG"),0);
            Cursor_qbe_famsaldi01_count.Next();
          }
          m_cConnectivityError = Cursor_qbe_famsaldi01_count.ErrorMessage();
          Cursor_qbe_famsaldi01_count.Close();
          // * --- End Select
          /* If _totrecord > 0 */
          if (CPLib.gt(_totrecord,0)) {
            /* _invio := w_anno+"00_1_3" */
            _invio = w_anno+"00_1_3";
            /* If w_flginvio='S' */
            if (CPLib.eqr(w_flginvio,"S")) {
              // * --- Delete from sid_invio
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio");
              m_cPhName = m_Ctx.GetPhName("sid_invio");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"00000054")+"delete from "+m_oWrInfo.GetTableWriteName();
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
                throw new RoutineException();
              }
              // * --- Delete from sid_invio1
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio1");
              m_cPhName = m_Ctx.GetPhName("sid_invio1");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"00000055")+"delete from "+m_oWrInfo.GetTableWriteName();
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
                throw new RoutineException();
              }
              // * --- Delete from sid_invio3
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio3");
              m_cPhName = m_Ctx.GetPhName("sid_invio3");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"00000056")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODINVIO3 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
            } // End If
            /* _nomefile := LRTrim(gIntemediario)+"_"+_invio+"_"+DateTimeToChar(DateTime()) */
            _nomefile = CPLib.LRTrim(gIntemediario)+"_"+_invio+"_"+CPLib.DateTimeToChar(CPLib.DateTime());
            /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
            fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
            // * --- Insert into tmp_list_imprich from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_list_imprich");
            m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"0000005B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000005B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(_nosid,1)?_nomefile:""),"?",0,0,m_cServer)+", ";
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
              throw new RoutineException();
            }
            /* rowSID0.CODINVIO := _invio */
            rowSID0.CODINVIO = _invio;
            /* rowSID0.TIPINVIO := '1' */
            rowSID0.TIPINVIO = "1";
            /* rowSID0.TPCINVIO := '3' */
            rowSID0.TPCINVIO = "3";
            /* rowSID0.DATINVIO := Date() */
            rowSID0.DATINVIO = CPLib.Date();
            /* rowSID0.ANNINVIO := w_anno */
            rowSID0.ANNINVIO = w_anno;
            /* mcSID0.AppendRow(rowSID0) */
            mcSID0.AppendRow(rowSID0);
            /* rowSID0.FLEINVIO := _nomefile */
            rowSID0.FLEINVIO = _nomefile;
            /* rowSID0.MESINVIO := '00' */
            rowSID0.MESINVIO = "00";
            /* _riga := '0' */
            _riga = "0";
            /* _riga := _riga + 'ARU00' */
            _riga = _riga+"ARU00";
            /* _riga := _riga + '1' */
            _riga = _riga+"1";
            /* _riga := _riga + '3' */
            _riga = _riga+"3";
            /* _riga := _riga + w_anno */
            _riga = _riga+w_anno;
            /* _riga := _riga + '00' */
            _riga = _riga+"00";
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
            /* _riga := _riga +w_anticipo // Invio Ordinario */
            _riga = _riga+w_anticipo;
            /* _riga := _riga + Space(112) // Invio Ordinario */
            _riga = _riga+CPLib.Space(112);
            /* _riga := _riga + 'A' // Invio Ordinario */
            _riga = _riga+"A";
            /* FileLibMit.WriteLine(fhand,_riga) */
            FileLibMit.WriteLine(fhand,_riga);
            /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
            gMsgImp = "Attendere. Estrazione dati per il periodo ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Fill memory cursor mcTemp on qbe_famsaldi01
            mcTemp.Zap();
            SPBridge.HMCaller _h00000083;
            _h00000083 = new SPBridge.HMCaller();
            _h00000083.Set("m_cVQRList",m_cVQRList);
            _h00000083.Set("_anno",w_anno);
            _h00000083.Set("dainviare",0);
            _h00000083.Set("inviati",_inviati);
            if (Cursor_qbe_famsaldi01!=null)
              Cursor_qbe_famsaldi01.Close();
            Cursor_qbe_famsaldi01 = new VQRHolder("qbe_famsaldi01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000083,true).GetResultSet(m_Ctx);
            {
              final CPResultSet m_TheCursor = Cursor_qbe_famsaldi01;
              Cursor_qbe_famsaldi01.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,100000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_famsaldi: query on qbe_famsaldi01 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 100000");
                    }
                  }
                }
                });
            }
            while ( ! (Cursor_qbe_famsaldi01.Eof())) {
              mcTemp.AppendBlank();
              mcTemp.row.RAPPORTO = Cursor_qbe_famsaldi01.GetString("RAPPORTO");
              mcTemp.row.DATAINI = Cursor_qbe_famsaldi01.GetDate("DATAINI");
              mcTemp.row.DATAFINE = Cursor_qbe_famsaldi01.GetDate("DATAFINE");
              mcTemp.row.TIPOAG = Cursor_qbe_famsaldi01.GetString("TIPOAG");
              mcTemp.row.TIPORAP = Cursor_qbe_famsaldi01.GetString("TIPORAP");
              mcTemp.row.DESCRAP = Cursor_qbe_famsaldi01.GetString("DESCRAP");
              mcTemp.row.VALUTA = Cursor_qbe_famsaldi01.GetString("VALUTA");
              mcTemp.row.INVIATO = Cursor_qbe_famsaldi01.GetDouble("INVIATO");
              mcTemp.row.TIPO = Cursor_qbe_famsaldi01.GetString("TIPO");
              mcTemp.row.CAB = Cursor_qbe_famsaldi01.GetString("CAB");
              mcTemp.row.UNIQUECODE = Cursor_qbe_famsaldi01.GetString("UNIQUECODE");
              mcTemp.row.OLDINTER = Cursor_qbe_famsaldi01.GetString("OLDINTER");
              mcTemp.row.SALDO = Cursor_qbe_famsaldi01.GetDouble("SALDO");
              mcTemp.row.QUANTITA = Cursor_qbe_famsaldi01.GetDouble("QUANTITA");
              mcTemp.row.NATURA = Cursor_qbe_famsaldi01.GetString("NATURA");
              Cursor_qbe_famsaldi01.Next();
            }
            m_cConnectivityError = Cursor_qbe_famsaldi01.ErrorMessage();
            Cursor_qbe_famsaldi01.Close();
            mcTemp.GoTop();
            /* gMsgProc := gMsgProc + 'Ora Inizio controllo periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
            gMsgProc = gMsgProc+"Ora Inizio controllo periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _crea := 0 */
            _crea = CPLib.Round(0,0);
            for (MemoryCursorRow_mcsaldi_mcrdef rowTemp : mcTemp._iterable_()) {
              /* _unique := iif(not(Empty(rowTemp.UNIQUECODE)),rowTemp.UNIQUECODE,iif(Empty(rowTemp.OLDINTER),LRTrim(_cfinter),LRTrim(rowTemp.OLDINTER))+"_2015_"+LRTrim(rowTemp.RAPPORTO)) */
              _unique = ( ! (CPLib.Empty(rowTemp.UNIQUECODE))?rowTemp.UNIQUECODE:(CPLib.Empty(rowTemp.OLDINTER)?CPLib.LRTrim(_cfinter):CPLib.LRTrim(rowTemp.OLDINTER))+"_2015_"+CPLib.LRTrim(rowTemp.RAPPORTO));
              /* _unique := arfn_agechar(_unique,"_") */
              _unique = arfn_agecharR.Make(m_Ctx,this).Run(_unique,"_");
              /* _newunq := iif(not(Empty(rowTemp.UNIQUECODE)),'N','S') */
              _newunq = ( ! (CPLib.Empty(rowTemp.UNIQUECODE))?"N":"S");
              /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
              gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
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
              /* rowSID1.TIPINVIO1 := '1' */
              rowSID1.TIPINVIO1 = "1";
              /* rowSID1.TPCINVIO1 := '3' */
              rowSID1.TPCINVIO1 = "3";
              /* rowSID1.UNIQUE1 := _unique */
              rowSID1.UNIQUE1 = _unique;
              /* rowSID1.FLGUNQ1 := _newunq */
              rowSID1.FLGUNQ1 = _newunq;
              /* If w_flgstp='N' */
              if (CPLib.eqr(w_flgstp,"N")) {
                /* mcSID1.AppendRow(rowSID1) */
                mcSID1.AppendRow(rowSID1);
              } // End If
              /* mcSID3r := arfn_fam_mesefile03(rowSID1,Val(w_anno),rowTemp.TIPO,rowTemp.VALUTA) */
              mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,CPLib.Val(w_anno),rowTemp.TIPO,rowTemp.VALUTA);
              for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
                /* If w_flgstp='N' */
                if (CPLib.eqr(w_flgstp,"N")) {
                  /* mcSID3.AppendRow(rowSID3) */
                  mcSID3.AppendRow(rowSID3);
                } // End If
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
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowSID3.NATINVIO3),2) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowSID3.NATINVIO3),2);
                /* _riga := _riga + Space(227) */
                _riga = _riga+CPLib.Space(227);
                /* _riga := _riga + 'A' */
                _riga = _riga+"A";
                /* FileLibMit.WriteLine(fhand,_riga) */
                FileLibMit.WriteLine(fhand,_riga);
                /* If w_flgstp='S' */
                if (CPLib.eqr(w_flgstp,"S")) {
                  /* If rowSID3.FLGUNQ3='S' */
                  if (CPLib.eqr(rowSID3.FLGUNQ3,"S")) {
                    // * --- Write into aetesta from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aetesta");
                    m_cPhName = m_Ctx.GetPhName("aetesta");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000B2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(CPLib.LRTrim(rowSID3.UNIQUE3),"C",50,0,m_cServer)+", ";
                    m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(CPLib.LRTrim(rowSID3.UNIQUE3),"C",50,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer),m_cServer,rowSID3.RAPINVIO3)+"";
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
                  } // End If
                  // * --- Write into aeannora from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aeannora");
                  m_cPhName = m_Ctx.GetPhName("aeannora");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000B3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                  m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeannora",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer),m_cServer,rowSID3.RAPINVIO3)+"";
                  m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer),m_cServer,w_anno)+"";
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
                } // End If
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
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000B6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000B6(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("00","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
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
                throw new RoutineException();
              }
              /* gMsgImp := 'Sono stati create '+LRTrim(Str(_conta,10,0))+" registrazioni" // Messaggio Import */
              gMsgImp = "Sono stati create "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" registrazioni";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            }
            /* Exec "Operazioni Extraconto" Page 2:Page_2 */
            Page_2();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            /* gMsgProc := gMsgProc + "Sono stati create "+LRTrim(Str(_conta,10,0))+" registrazioni"+NL // Messaggio */
            gMsgProc = gMsgProc+"Sono stati create "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" registrazioni"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgProc := gMsgProc + 'Ora Fine controllo periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
            gMsgProc = gMsgProc+"Ora Fine controllo periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000C6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000C6(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,50),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("00","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
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
              throw new RoutineException();
            }
            /* If _nosid=0 */
            if (CPLib.eqr(_nosid,0)) {
              /* _sid := arfn_exec_sid(_nomefile,w_anno) */
              _sid = arfn_exec_sidR.Make(m_Ctx,this).Run(_nomefile,w_anno);
              /* If _sid.RecCount() > 0 */
              if (CPLib.gt(_sid.RecCount(),0)) {
                for (MemoryCursorRow_mcmessaggi_mcrdef rowErrore : _sid._iterable_()) {
                  /* gMsgProc := gMsgProc + LRTrim(rowErrore.testata) + NL // Messaggio */
                  gMsgProc = gMsgProc+CPLib.LRTrim(rowErrore.testata)+"\n";
                  m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                }
                // Transaction Error
                cTry0000004Amsg = CPLib.FormatMsg(m_Ctx,"'Rilevati errori durante il controllo da parte del SID'");
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'Rilevati errori durante il controllo da parte del SID'"));
              } // End If
            } // End If
            /* If _sid.IsEmpty() */
            if (_sid.IsEmpty()) {
              // * --- Delete from sid_invio
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio");
              m_cPhName = m_Ctx.GetPhName("sid_invio");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000CF")+"delete from "+m_oWrInfo.GetTableWriteName();
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
                throw new RoutineException();
              }
              // * --- Delete from sid_invio1
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio1");
              m_cPhName = m_Ctx.GetPhName("sid_invio1");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000D0")+"delete from "+m_oWrInfo.GetTableWriteName();
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
                throw new RoutineException();
              }
              // * --- Delete from sid_invio3
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio3");
              m_cPhName = m_Ctx.GetPhName("sid_invio3");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000D1")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODINVIO3 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000D4")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000D4(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.CODINVIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.TIPINVIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.TPCINVIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.ANNINVIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.MESINVIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.FLEINVIO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID0.DATINVIO,"?",0,0)+", ";
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
                  throw new RoutineException();
                }
              }
              /* If w_flgstp='N' */
              if (CPLib.eqr(w_flgstp,"N")) {
                for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
                  // * --- Insert into sid_invio1 from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("sid_invio1");
                  m_cPhName = m_Ctx.GetPhName("sid_invio1");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000D7")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000D7(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.CODINVIO1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPRINVIO1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.INIINVIO1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.FININVIO1,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.CABINVIO1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.ESIINVIO1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TIPINVIO1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPCINVIO1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.UNIQUE1,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.FLGUNQ1,"?",0,0,m_cServer)+", ";
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
                    throw new RoutineException();
                  }
                }
                /* _conta := 0 */
                _conta = CPLib.Round(0,0);
                /* _oldmsg := '' */
                _oldmsg = "";
                for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3._iterable_()) {
                  /* _conta := _conta + 1 */
                  _conta = CPLib.Round(_conta+1,0);
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
                  /* If rowSID3.TPRINVIO3='98' */
                  if (CPLib.eqr(rowSID3.TPRINVIO3,"98")) {
                    /* gMsgImp := "Sto aggiornando l'operazione con codice: "+rowSID1.RAPINVIO1 // Messaggio Import */
                    gMsgImp = "Sto aggiornando l'operazione con codice: "+rowSID1.RAPINVIO1;
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    // * --- Write into opextrbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("opextrbo");
                    m_cPhName = m_Ctx.GetPhName("opextrbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000E3")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"INVSALDO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                    m_cSql = m_cSql+"DTSALDO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                    m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(rowSID3.UNIQUE3,"C",50,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer),m_cServer,rowSID3.RAPINVIO3)+"";
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
                  } else { // Else
                    /* gMsgImp := "Sto aggiornando il rapporto: "+rowSID1.RAPINVIO1 // Messaggio Import */
                    gMsgImp = "Sto aggiornando il rapporto: "+rowSID1.RAPINVIO1;
                    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                    /* If rowSID3.FLGUNQ3='S' */
                    if (CPLib.eqr(rowSID3.FLGUNQ3,"S")) {
                      // * --- Write into aetesta from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("aetesta");
                      m_cPhName = m_Ctx.GetPhName("aetesta");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000E6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(CPLib.LRTrim(rowSID3.UNIQUE3),"C",50,0,m_cServer)+", ";
                      m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(CPLib.LRTrim(rowSID3.UNIQUE3),"C",50,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer),m_cServer,rowSID3.RAPINVIO3)+"";
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
                    } // End If
                    // * --- Write into aeannora from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("aeannora");
                    m_cPhName = m_Ctx.GetPhName("aeannora");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000E7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                    m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeannora",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer),m_cServer,rowSID3.RAPINVIO3)+"";
                    m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer),m_cServer,w_anno)+"";
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
                  } // End If
                  // * --- Insert into sid_invio3 from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("sid_invio3");
                  m_cPhName = m_Ctx.GetPhName("sid_invio3");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000E8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_000000E8(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.CODINVIO3,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.TPRINVIO3,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.ANNINVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.VALINVIO3,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM1INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI1INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM2INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI2INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM3INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI3INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM4INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI4INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM5INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI5INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM6INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI6INVIO3,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.UNIQUE3,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FLGUNQ3,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio3",true);
                  m_cSql = m_cSql+")";
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
                }
                /* gMsgImp := "Ho aggiornato l'operazione " + LRTrim(Str(_conta,10,0)) + " su " + LRTrim(Str(_totrecord,10,0)) // Messaggio Import */
                gMsgImp = "Ho aggiornato l'operazione "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_totrecord,10,0));
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
                /* _oldmsg := LRTrim(gMsgImp) */
                _oldmsg = CPLib.LRTrim(gMsgImp);
              } // End If
              /* gMsgProc := gMsgProc + NL + 'Ora Fine Aggiornamento Dati: '+arfn_fdatetime(DateTime())+NL // Messaggio */
              gMsgProc = gMsgProc+"\n"+"Ora Fine Aggiornamento Dati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
          } else { // Else
            /* gMsgProc := gMsgProc + "Non ci sono saldi da comunicare per l'anno: "+w_anno+NL // Messaggio */
            gMsgProc = gMsgProc+"Non ci sono saldi da comunicare per l'anno: "+w_anno+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* If _nosid=1 */
          if (CPLib.eqr(_nosid,1)) {
            // * --- Select from tmp_list_imprich
            m_cServer = m_Ctx.GetServer("tmp_list_imprich");
            m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
            if (Cursor_tmp_list_imprich!=null)
              Cursor_tmp_list_imprich.Close();
            Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_list_imprich.Eof())) {
              /* cNomeFile := LRTrim(gPathDoc)+'/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(tmp_list_imprich->hyperlynk) */
              cNomeFile = CPLib.LRTrim(gPathDoc)+"/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("hyperlynk"));
              /* cOnlyNomeFile := LRTrim(tmp_list_imprich->hyperlynk) */
              cOnlyNomeFile = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("hyperlynk"));
              // Aggiunge i file nei vettori
              filenames.add(CPLib.LRTrim(cNomeFile));
              fileonames.add(CPLib.LRTrim(cOnlyNomeFile));
              Cursor_tmp_list_imprich.Next();
            }
            m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
            Cursor_tmp_list_imprich.Close();
            // * --- End Select
            /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/File_SID_Saldi_"+w_anno+".zip" */
            cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/File_SID_Saldi_"+w_anno+".zip";
            /* Exec "Crea lo zip in caso di assenza SID" Page 3:Page_3 */
            Page_3();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            // * --- Insert into tmp_listafile from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_listafile");
            m_cPhName = m_Ctx.GetPhName("tmp_listafile");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_listafile",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"000000F9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000F9(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL("File_SID_Saldi_"+w_anno+".zip","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_listafile",true);
            m_cSql = m_cSql+")";
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
          } // End If
          /* gMsgImp := "Elaborazione Terminata. Premere il tasto con la nuvoletta per prelevare i file" // Messaggio Import */
          gMsgImp = "Elaborazione Terminata. Premere il tasto con la nuvoletta per prelevare i file";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
          gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000004Astatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000004Astatus,cTry0000004Amsg);
          }
        }
        /* gMsgProc := gMsgProc + 'Ora Fine  Elaborazione Saldi '+w_anno+": "+arfn_fdatetime(DateTime()) // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine  Elaborazione Saldi "+w_anno+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgImp := "Elaborazione Abortita." // Messaggio Import */
        gMsgImp = "Elaborazione Abortita.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + 'Scaduti i termini entro cui poter inviare il file dei saldi annuali!' + NL // Messaggio */
        gMsgProc = gMsgProc+"Scaduti i termini entro cui poter inviare il file dei saldi annuali!"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine  Elaborazione Saldi '+w_anno+": "+arfn_fdatetime(DateTime()) // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine  Elaborazione Saldi "+w_anno+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
        if (Cursor_qbe_famsaldi01_count!=null)
          Cursor_qbe_famsaldi01_count.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famsaldi01!=null)
          Cursor_qbe_famsaldi01.Close();
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
    CPResultSet Cursor_qbe_famsaldi_opx_minmax=null;
    CPResultSet Cursor_qbe_famsaldi03=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      // * --- Select from qbe_famsaldi_opx_minmax
      SPBridge.HMCaller _h00000106;
      _h00000106 = new SPBridge.HMCaller();
      _h00000106.Set("m_cVQRList",m_cVQRList);
      _h00000106.Set("anno",w_anno);
      _h00000106.Set("dainviare",0);
      _h00000106.Set("inviati",_inviati);
      if (Cursor_qbe_famsaldi_opx_minmax!=null)
        Cursor_qbe_famsaldi_opx_minmax.Close();
      Cursor_qbe_famsaldi_opx_minmax = new VQRHolder("qbe_famsaldi_opx_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000106,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_famsaldi_opx_minmax.Eof())) {
        /* _min := qbe_famsaldi_opx_minmax->MINPRG */
        _min = CPLib.Round(Cursor_qbe_famsaldi_opx_minmax.GetDouble("MINPRG"),0);
        /* _max := qbe_famsaldi_opx_minmax->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_famsaldi_opx_minmax.GetDouble("MAXPRG"),0);
        /* _tot := qbe_famsaldi_opx_minmax->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_famsaldi_opx_minmax.GetDouble("TOTPRG"),0);
        Cursor_qbe_famsaldi_opx_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_famsaldi_opx_minmax.ErrorMessage();
      Cursor_qbe_famsaldi_opx_minmax.Close();
      // * --- End Select
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
      /* _oldmsg := '' */
      _oldmsg = "";
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
          /* gMsgProc := gMsgProc + LRTrim(gMsgImp) // Messaggio */
          gMsgProc = gMsgProc+CPLib.LRTrim(gMsgImp);
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,LRTrim(_oldmsg),LRTrim(gMsgImp)) // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,CPLib.LRTrim(_oldmsg),CPLib.LRTrim(gMsgImp));
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := gMsgImp */
        _oldmsg = gMsgImp;
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Fill memory cursor mcTemp on qbe_famsaldi03
          mcTemp.Zap();
          SPBridge.HMCaller _h00000126;
          _h00000126 = new SPBridge.HMCaller();
          _h00000126.Set("m_cVQRList",m_cVQRList);
          _h00000126.Set("anno",w_anno);
          _h00000126.Set("_bottom",_bottom);
          _h00000126.Set("_top",_top);
          _h00000126.Set("dainviare",0);
          _h00000126.Set("inviati",_inviati);
          if (Cursor_qbe_famsaldi03!=null)
            Cursor_qbe_famsaldi03.Close();
          Cursor_qbe_famsaldi03 = new VQRHolder("qbe_famsaldi03",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000126,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_famsaldi03;
            Cursor_qbe_famsaldi03.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_famsaldi: query on qbe_famsaldi03 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_famsaldi03.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.RAPPORTO = Cursor_qbe_famsaldi03.GetString("RAPPORTO");
            mcTemp.row.DATAINI = Cursor_qbe_famsaldi03.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_famsaldi03.GetDate("DATAFINE");
            mcTemp.row.TIPOAG = Cursor_qbe_famsaldi03.GetString("TIPOAG");
            mcTemp.row.TIPORAP = Cursor_qbe_famsaldi03.GetString("TIPORAP");
            mcTemp.row.DESCRAP = Cursor_qbe_famsaldi03.GetString("DESCRAP");
            mcTemp.row.VALUTA = Cursor_qbe_famsaldi03.GetString("VALUTA");
            mcTemp.row.INVIATO = Cursor_qbe_famsaldi03.GetDouble("INVIATO");
            mcTemp.row.TIPO = Cursor_qbe_famsaldi03.GetString("TIPO");
            mcTemp.row.CAB = Cursor_qbe_famsaldi03.GetString("CAB");
            mcTemp.row.UNIQUECODE = Cursor_qbe_famsaldi03.GetString("UNIQUECODE");
            mcTemp.row.OLDINTER = Cursor_qbe_famsaldi03.GetString("OLDINTER");
            mcTemp.row.SALDO = Cursor_qbe_famsaldi03.GetDouble("SALDO");
            mcTemp.row.QUANTITA = Cursor_qbe_famsaldi03.GetDouble("QUANTITA");
            mcTemp.row.NATURA = Cursor_qbe_famsaldi03.GetString("NATURA");
            Cursor_qbe_famsaldi03.Next();
          }
          m_cConnectivityError = Cursor_qbe_famsaldi03.ErrorMessage();
          Cursor_qbe_famsaldi03.Close();
          mcTemp.GoTop();
          for (MemoryCursorRow_mcsaldi_mcrdef rowTemp : mcTemp._iterable_()) {
            /* _unique := iif(not(Empty(rowTemp.UNIQUECODE)),rowTemp.UNIQUECODE,iif(Empty(rowTemp.OLDINTER),LRTrim(_cfinter),LRTrim(rowTemp.OLDINTER))+"_"+LRTrim(rowTemp.RAPPORTO)) */
            _unique = ( ! (CPLib.Empty(rowTemp.UNIQUECODE))?rowTemp.UNIQUECODE:(CPLib.Empty(rowTemp.OLDINTER)?CPLib.LRTrim(_cfinter):CPLib.LRTrim(rowTemp.OLDINTER))+"_"+CPLib.LRTrim(rowTemp.RAPPORTO));
            /* _unique := arfn_agechar(_unique,"_") */
            _unique = arfn_agecharR.Make(m_Ctx,this).Run(_unique,"_");
            /* _newunq := iif(not(Empty(rowTemp.UNIQUECODE)),'N','S') */
            _newunq = ( ! (CPLib.Empty(rowTemp.UNIQUECODE))?"N":"S");
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
            /* rowSID1.TIPINVIO1 := '1' */
            rowSID1.TIPINVIO1 = "1";
            /* rowSID1.TPCINVIO1 := '3' */
            rowSID1.TPCINVIO1 = "3";
            /* rowSID1.TPCINVIO1 := '3' */
            rowSID1.TPCINVIO1 = "3";
            /* rowSID1.UNIQUE1 := _unique */
            rowSID1.UNIQUE1 = _unique;
            /* rowSID1.FLGUNQ1 := _newunq */
            rowSID1.FLGUNQ1 = _newunq;
            /* If w_flgstp='N' */
            if (CPLib.eqr(w_flgstp,"N")) {
              /* mcSID1.AppendRow(rowSID1) */
              mcSID1.AppendRow(rowSID1);
            } // End If
            /* If w_flgstp='N' */
            if (CPLib.eqr(w_flgstp,"N")) {
              /* mcSID3.AppendBlank() */
              mcSID3.AppendBlank();
              /* mcSID3.CODINVIO3 := rowSID1.CODINVIO1 */
              mcSID3.row.CODINVIO3 = rowSID1.CODINVIO1;
              /* mcSID3.RAPINVIO3 := rowSID1.RAPINVIO1 */
              mcSID3.row.RAPINVIO3 = rowSID1.RAPINVIO1;
              /* mcSID3.TPRINVIO3 := rowSID1.TPRINVIO1 */
              mcSID3.row.TPRINVIO3 = rowSID1.TPRINVIO1;
              /* mcSID3.ANNINVIO3 := Val(w_anno) */
              mcSID3.row.ANNINVIO3 = CPLib.Val(w_anno);
              /* mcSID3.VALINVIO3 := rowTemp.VALUTA */
              mcSID3.row.VALINVIO3 = rowTemp.VALUTA;
              /* If w_anno <= '2021' */
              if (CPLib.le(w_anno,"2021")) {
                /* mcSID3.NATINVIO3 := Space(2) */
                mcSID3.row.NATINVIO3 = CPLib.Space(2);
              } else { // Else
                /* mcSID3.NATINVIO3 := rowTemp.NATURA */
                mcSID3.row.NATINVIO3 = rowTemp.NATURA;
              } // End If
              /* mcSID3.IM1INVIO3 := 0 */
              mcSID3.row.IM1INVIO3 = 0;
              /* mcSID3.FI1INVIO3 := 0 */
              mcSID3.row.FI1INVIO3 = 0;
              /* mcSID3.IM2INVIO3 := 0 */
              mcSID3.row.IM2INVIO3 = 0;
              /* mcSID3.FI2INVIO3 := 0 */
              mcSID3.row.FI2INVIO3 = 0;
              /* mcSID3.IM3INVIO3 := rowTemp.SALDO */
              mcSID3.row.IM3INVIO3 = rowTemp.SALDO;
              /* mcSID3.FI3INVIO3 := iif(rowTemp.SALDO >1000000,1,0) */
              mcSID3.row.FI3INVIO3 = (CPLib.gt(rowTemp.SALDO,1000000)?1:0);
              /* mcSID3.IM4INVIO3 := 0 */
              mcSID3.row.IM4INVIO3 = 0;
              /* mcSID3.FI4INVIO3 := 0 */
              mcSID3.row.FI4INVIO3 = 0;
              /* mcSID3.IM5INVIO3 := rowTemp.QUANTITA */
              mcSID3.row.IM5INVIO3 = rowTemp.QUANTITA;
              /* mcSID3.FI5INVIO3 := iif(rowTemp.QUANTITA >1000000,1,0) */
              mcSID3.row.FI5INVIO3 = (CPLib.gt(rowTemp.QUANTITA,1000000)?1:0);
              /* mcSID3.IM6INVIO3 := 0 */
              mcSID3.row.IM6INVIO3 = 0;
              /* mcSID3.FI6INVIO3 := 0 */
              mcSID3.row.FI6INVIO3 = 0;
              /* mcSID3.UNIQUE3 := rowSID1.UNIQUE1 */
              mcSID3.row.UNIQUE3 = rowSID1.UNIQUE1;
              /* mcSID3.FLGUNQ3 := rowSID1.FLGUNQ1 */
              mcSID3.row.FLGUNQ3 = rowSID1.FLGUNQ1;
              /* mcSID3.SaveRow() */
              mcSID3.SaveRow();
            } // End If
            /* _tipo3 := _tipo3 + 1 */
            _tipo3 = CPLib.Round(_tipo3+1,0);
            /* _riga := '3' */
            _riga = "3";
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_unique),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_unique),50);
            /* _riga := _riga + rowTemp.TIPOAG */
            _riga = _riga+rowTemp.TIPOAG;
            /* _riga := _riga + w_anno */
            _riga = _riga+w_anno;
            /* _riga := _riga + '00000000000000000' */
            _riga = _riga+"00000000000000000";
            /* _riga := _riga + '0' */
            _riga = _riga+"0";
            /* _riga := _riga + '00000000000000000' */
            _riga = _riga+"00000000000000000";
            /* _riga := _riga + "0" */
            _riga = _riga+"0";
            /* _riga := _riga + Right('00000000000000000'+LRTrim(Str(rowTemp.SALDO,17,0)),17) */
            _riga = _riga+CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowTemp.SALDO,17,0)),17);
            /* _riga := _riga + iif(rowTemp.SALDO > 1000000,"1","0") */
            _riga = _riga+(CPLib.gt(rowTemp.SALDO,1000000)?"1":"0");
            /* _riga := _riga + '00000000000000000' */
            _riga = _riga+"00000000000000000";
            /* _riga := _riga + "0" */
            _riga = _riga+"0";
            /* _riga := _riga + Right('00000000000000000'+LRTrim(Str(rowTemp.QUANTITA,17,0)),17) */
            _riga = _riga+CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowTemp.QUANTITA,17,0)),17);
            /* _riga := _riga + iif(rowTemp.QUANTITA > 1000000,"1","0") */
            _riga = _riga+(CPLib.gt(rowTemp.QUANTITA,1000000)?"1":"0");
            /* _riga := _riga + '00000000000000000' */
            _riga = _riga+"00000000000000000";
            /* _riga := _riga + "0" */
            _riga = _riga+"0";
            /* _riga := _riga + rowTemp.VALUTA */
            _riga = _riga+rowTemp.VALUTA;
            /* _riga := _riga + LibreriaMit.SpacePad(iif(w_anno <= '2021',"",LRTrim(rowTemp.NATURA)),2) */
            _riga = _riga+LibreriaMit.SpacePad((CPLib.le(w_anno,"2021")?"":CPLib.LRTrim(rowTemp.NATURA)),2);
            /* _riga := _riga + Space(227) */
            _riga = _riga+CPLib.Space(227);
            /* _riga := _riga + 'A' */
            _riga = _riga+"A";
            /* FileLibMit.WriteLine(fhand,_riga) */
            FileLibMit.WriteLine(fhand,_riga);
            /* If w_flgstp='S' */
            if (CPLib.eqr(w_flgstp,"S")) {
              // * --- Write into opextrbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("opextrbo");
              m_cPhName = m_Ctx.GetPhName("opextrbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"00000167")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"INVSALDO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = m_cSql+"DTSALDO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(_unique,"C",50,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTemp.RAPPORTO,"?",0,0,m_cServer),m_cServer,rowTemp.RAPPORTO)+"";
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famsaldi",110,"0000016A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000016A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("00","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
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
            /* gMsgImp := 'Sono stati create '+LRTrim(Str(_conta,10,0))+" registrazioni" // Messaggio Import */
            gMsgImp = "Sono stati create "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" registrazioni";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          }
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
    } finally {
      try {
        if (Cursor_qbe_famsaldi_opx_minmax!=null)
          Cursor_qbe_famsaldi_opx_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famsaldi03!=null)
          Cursor_qbe_famsaldi03.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    // Qui vengono scritti i file da inserire nello zip
        String[] filenames = new String[]{cNomeFile};
        
        // Crea un buffer per la lettura dei file
        byte[] buf = new byte[1024];
        
        try {
            // Creail file ZIP
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Comprime i file
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Apre il file da aggiungere allo ZIP
                out.putNextEntry(new java.util.zip.ZipEntry(cOnlyNomeFile));
        
                // Trasferisce i dati da i file allo ZIP
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Chiude il file
                out.closeEntry();
                in.close();
            }
        
            // Chiude il file ZIP
            out.close();
        } catch (java.io.IOException e) {
        }
    
  }
  void _init_() {
  }
  public String RunAsync(String p_w_anno,String p_w_flginvio,String p_w_flgstp,String p_w_anticipo) {
    w_anno = p_w_anno;
    w_flginvio = p_w_flginvio;
    w_flgstp = p_w_flgstp;
    w_anticipo = p_w_anticipo;
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
  public String Run(String p_w_anno,String p_w_flginvio,String p_w_flgstp,String p_w_anticipo) {
    w_anno = p_w_anno;
    w_flginvio = p_w_flginvio;
    w_flgstp = p_w_flgstp;
    w_anticipo = p_w_anticipo;
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
  public static arrt_famsaldiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_famsaldiR(p_Ctx, p_Caller);
  }
  public static arrt_famsaldiR Make(CPContext p_Ctx) {
    return new arrt_famsaldiR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_anno = CPLib.Space(4);
    w_flginvio = CPLib.Space(1);
    w_flgstp = CPLib.Space(1);
    w_anticipo = CPLib.Space(1);
    _conta = 0;
    _errore = "";
    mcTemp = new MemoryCursor_mcsaldi_mcrdef();
    rowTemp = new MemoryCursorRow_mcsaldi_mcrdef();
    mcSID0 = new MemoryCursor_sid_invio();
    rowSID0 = new MemoryCursorRow_sid_invio();
    mcSID1 = new MemoryCursor_sid_invio1();
    rowSID1 = new MemoryCursorRow_sid_invio1();
    mcSID3 = new MemoryCursor_sid_invio3();
    rowSID3 = new MemoryCursorRow_sid_invio3();
    mcSID3r = new MemoryCursor_sid_invio3();
    _crea = 0;
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
    _oldmsg = "";
    _errori = 0;
    _newunq = CPLib.Space(1);
    cProg = CPLib.Space(10);
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(10);
    cNomeFile = CPLib.Space(100);
    _mese = CPLib.Space(2);
    _riga = CPLib.Space(398);
    _tipo1 = 0;
    _tipo2 = 0;
    _tipo3 = 0;
    _tipo4 = 0;
    _unique = CPLib.Space(50);
    _cab = CPLib.Space(5);
    _cfinter = CPLib.Space(16);
    _inviati = 0;
    _nosid = 0;
    cOnlyNomeFile = CPLib.Space(100);
    cNomeFileZip = CPLib.Space(100);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gScadSaldi =m_Ctx.GetGlobalDate("gScadSaldi ");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_famsaldi01_count,qbe_famsaldi01,qbe_famsaldi_opx_minmax,qbe_famsaldi03,
  public static final String m_cVQRList = ",qbe_famsaldi01_count,qbe_famsaldi01,qbe_famsaldi_opx_minmax,qbe_famsaldi03,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_exec_sid,arfn_fam_mesefile03,arfn_fdate_nd,arfn_fdatetime,arrt_famsaldi,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_exec_sid,arfn_fam_mesefile03,arfn_fdate_nd,arfn_fdatetime,arrt_famsaldi,";
  public static String[] m_cRunParameterNames={"w_anno","w_flginvio","w_flgstp","w_anticipo"};
  protected static String GetFieldsName_0000005B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000C6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000D4(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+"TIPINVIO,";
    p_cSql = p_cSql+"TPCINVIO,";
    p_cSql = p_cSql+"ANNINVIO,";
    p_cSql = p_cSql+"MESINVIO,";
    p_cSql = p_cSql+"FLEINVIO,";
    p_cSql = p_cSql+"DATINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D7(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO1,";
    p_cSql = p_cSql+"RAPINVIO1,";
    p_cSql = p_cSql+"TPRINVIO1,";
    p_cSql = p_cSql+"INIINVIO1,";
    p_cSql = p_cSql+"FININVIO1,";
    p_cSql = p_cSql+"CABINVIO1,";
    p_cSql = p_cSql+"ESIINVIO1,";
    p_cSql = p_cSql+"TIPINVIO1,";
    p_cSql = p_cSql+"TPCINVIO1,";
    p_cSql = p_cSql+"UNIQUE1,";
    p_cSql = p_cSql+"FLGUNQ1,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO3,";
    p_cSql = p_cSql+"RAPINVIO3,";
    p_cSql = p_cSql+"TPRINVIO3,";
    p_cSql = p_cSql+"ANNINVIO3,";
    p_cSql = p_cSql+"VALINVIO3,";
    p_cSql = p_cSql+"IM1INVIO3,";
    p_cSql = p_cSql+"FI1INVIO3,";
    p_cSql = p_cSql+"IM2INVIO3,";
    p_cSql = p_cSql+"FI2INVIO3,";
    p_cSql = p_cSql+"IM3INVIO3,";
    p_cSql = p_cSql+"FI3INVIO3,";
    p_cSql = p_cSql+"IM4INVIO3,";
    p_cSql = p_cSql+"FI4INVIO3,";
    p_cSql = p_cSql+"IM5INVIO3,";
    p_cSql = p_cSql+"FI5INVIO3,";
    p_cSql = p_cSql+"IM6INVIO3,";
    p_cSql = p_cSql+"FI6INVIO3,";
    p_cSql = p_cSql+"UNIQUE3,";
    p_cSql = p_cSql+"FLGUNQ3,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio3",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000F9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000016A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
