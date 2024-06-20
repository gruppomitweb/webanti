// * --- Area Manuale = BO - Header
// * --- arrt_famprimo
import java.io.*;
import java.util.Scanner;
// * --- Fine Area Manuale
public class arrt_famprimoR implements CallerWithObjs {
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
  public String w_flgnuovi;
  public double w_anno;
  public String w_mese;
  public String w_flgstp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gPathApp;
  public double _conta;
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
  // * --- Area Manuale = BO - Properties
  // * --- arrt_famprimo
  public int _r;
  // * --- Fine Area Manuale
  public arrt_famprimoR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_famprimo",m_Caller);
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
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
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_famprimo";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("flgnuovi",p_cVarName)) {
      return w_flgnuovi;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
    }
    if (CPLib.eqr("flgstp",p_cVarName)) {
      return w_flgstp;
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
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dataini",p_cVarName)) {
      return _dataini;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      return _datafin;
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
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("flgnuovi",p_cVarName)) {
      w_flgnuovi = value;
      return;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
      return;
    }
    if (CPLib.eqr("flgstp",p_cVarName)) {
      w_flgstp = value;
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
    CPResultSet Cursor_tmp_listafile=null;
    try {
      /* w_flgnuovi Char(1) */
      /* w_anno Numeric(4, 0) */
      /* w_mese Char(2) */
      /* w_flgstp Char(2) */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gIntemediario Char(11) // Intermediario */
      /* gPathApp Char(80) // Path Applicazione */
      /* _conta Numeric(10, 0) */
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
      double nTry00000040status;
      nTry00000040status = m_Sql.GetTransactionStatus();
      String cTry00000040msg;
      cTry00000040msg = m_Sql.TransactionErrorMessage();
      try {
        /* If w_flgnuovi='N' */
        if (CPLib.eqr(w_flgnuovi,"N")) {
          /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione Nuovi Rapporti: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Inizio Elaborazione Nuovi Rapporti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* If w_anno = 2015 and Empty(w_mese) */
          if (CPLib.eqr(w_anno,2015) && CPLib.Empty(w_mese)) {
            for (int i = 1; CPLib.ne(i,13); i = i + (1)) {
              /* mcSID0.Zap() */
              mcSID0.Zap();
              /* mcSID1.Zap() */
              mcSID1.Zap();
              /* mcSID2.Zap() */
              mcSID2.Zap();
              /* mcSID2r.Zap() */
              mcSID2r.Zap();
              /* _tipo1 := 0 */
              _tipo1 = CPLib.Round(0,0);
              /* _tipo2 := 0 */
              _tipo2 = CPLib.Round(0,0);
              /* _tipo3 := 0 */
              _tipo3 = CPLib.Round(0,0);
              /* _tipo4 := 0 */
              _tipo4 = CPLib.Round(0,0);
              /* _dataini := CharToDate('2015'+iif(i<=9,'0'+Str(i,1,0),Str(i,2,0))+"01") */
              _dataini = CPLib.CharToDate("2015"+(CPLib.le(i,9)?"0"+CPLib.Str(i,1,0):CPLib.Str(i,2,0))+"01");
              /* _datafin := arfn_finemese(_dataini) */
              _datafin = arfn_finemeseR.Make(m_Ctx,this).Run(_dataini);
              /* _mese := iif(i<=9,'0'+Str(i,1,0),Str(i,2,0)) */
              _mese = (CPLib.le(i,9)?"0"+CPLib.Str(i,1,0):CPLib.Str(i,2,0));
              /* Exec "Nuovi Rapporti" Page 2:Page_2 */
              Page_2();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
            }
          } else { // Else
            /* mcSID0.Zap() */
            mcSID0.Zap();
            /* mcSID1.Zap() */
            mcSID1.Zap();
            /* mcSID2.Zap() */
            mcSID2.Zap();
            /* mcSID2r.Zap() */
            mcSID2r.Zap();
            /* _tipo1 := 0 */
            _tipo1 = CPLib.Round(0,0);
            /* _tipo2 := 0 */
            _tipo2 = CPLib.Round(0,0);
            /* _tipo3 := 0 */
            _tipo3 = CPLib.Round(0,0);
            /* _tipo4 := 0 */
            _tipo4 = CPLib.Round(0,0);
            /* _dataini := CharToDate('2015'+w_mese+"01") */
            _dataini = CPLib.CharToDate("2015"+w_mese+"01");
            /* _datafin := arfn_finemese(_dataini) */
            _datafin = arfn_finemeseR.Make(m_Ctx,this).Run(_dataini);
            /* _mese := w_mese */
            _mese = w_mese;
            /* Exec "Nuovi Rapporti" Page 2:Page_2 */
            Page_2();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
          } // End If
        } else { // Else
          /* Exec "Modifiche" Page 3:Page_3 */
          Page_3();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
        } // End If
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
          /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(tmp_listafile->nomefile)+".zip" */
          cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(Cursor_tmp_listafile.GetString("nomefile"))+".zip";
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
        File di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/");
        File fl[] = di.listFiles();
        int _i;
        int count=0;
        for (_i=0; _i < fl.length; _i++)  {
          fl[_i].delete();
        }
        di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/PRE/"+CPLib.LRTrim(gAzienda)+"/");
        File fl1[] = di.listFiles();
        count=0;
        for (_i=0; _i < fl1.length; _i++)  {
          fl1[_i].delete();
        }
        /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
        gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000040status,0)) {
          m_Sql.SetTransactionStatus(nTry00000040status,cTry00000040msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione Nuovi Rapporti: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione Nuovi Rapporti: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
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
    VQRHolder l_VQRHolder = null;
    try {
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione periodo 2015-'+_mese+" : "+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Inizio Elaborazione periodo 2015-"+_mese+" : "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
      gMsgImp = "Attendere. Estrazione dati per il periodo ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _totrecord := 0 */
      _totrecord = CPLib.Round(0,0);
      // * --- Select from qbe_fam_periodo01_minmax
      SPBridge.HMCaller _h00000072;
      _h00000072 = new SPBridge.HMCaller();
      _h00000072.Set("m_cVQRList",m_cVQRList);
      _h00000072.Set("_dadata",_dataini);
      _h00000072.Set("_adata",_datafin);
      _h00000072.Set("_inviato",1);
      if (Cursor_qbe_fam_periodo01_minmax!=null)
        Cursor_qbe_fam_periodo01_minmax.Close();
      Cursor_qbe_fam_periodo01_minmax = new VQRHolder("qbe_fam_periodo01_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000072,true).GetResultSet(m_Ctx);
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
        /* _nomefile := LRTrim(gIntemediario)+"_2015"+_mese+"_"+DateTimeToChar(DateTime()) */
        _nomefile = CPLib.LRTrim(gIntemediario)+"_2015"+_mese+"_"+CPLib.DateTimeToChar(CPLib.DateTime());
        /* fhand := FileLibMit.OpenWrite('/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
        fhand = FileLibMit.OpenWrite("/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
        /* _invio := '2015'+_mese+"_2_1" */
        _invio = "2015"+_mese+"_2_1";
        // * --- Insert into tmp_list_imprich from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"0000007E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000007E(m_Ctx,m_oWrInfo);
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
        /* rowSID0.ANNINVIO := '2015' */
        rowSID0.ANNINVIO = "2015";
        /* rowSID0.MESINVIO := _mese */
        rowSID0.MESINVIO = _mese;
        /* rowSID0.FLEINVIO := _nomefile */
        rowSID0.FLEINVIO = _nomefile;
        /* mcSID0.AppendRow(rowSID0) */
        mcSID0.AppendRow(rowSID0);
        // * --- Delete from sid_invio
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sid_invio");
        m_cPhName = m_Ctx.GetPhName("sid_invio");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"00000087")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        // * --- Insert into sid_invio from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sid_invio");
        m_cPhName = m_Ctx.GetPhName("sid_invio");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"00000088")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000088(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("2015","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_mese,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
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
        /* _riga := _riga + '2015' */
        _riga = _riga+"2015";
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
        // * --- Fill memory cursor mcTemp on qbe_fam_periodo01
        mcTemp.Zap();
        SPBridge.HMCaller _h000000A7;
        _h000000A7 = new SPBridge.HMCaller();
        _h000000A7.Set("m_cVQRList",m_cVQRList);
        _h000000A7.Set("_dadata",_dataini);
        _h000000A7.Set("_adata",_datafin);
        _h000000A7.Set("_inviato",1);
        if (Cursor_qbe_fam_periodo01!=null)
          Cursor_qbe_fam_periodo01.Close();
        Cursor_qbe_fam_periodo01 = new VQRHolder("qbe_fam_periodo01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A7,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_fam_periodo01;
          Cursor_qbe_fam_periodo01.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,100000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_famprimo: query on qbe_fam_periodo01 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 100000");
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
            /* _unique := arfn_agechar(_unique,"_") */
            _unique = arfn_agecharR.Make(m_Ctx,this).Run(_unique,"_");
            /* _unique := Strtran(LRTrim(_unique)," ","_") */
            _unique = CPLib.Strtran(CPLib.LRTrim(_unique)," ","_");
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
            /* rowSID1.FININVIO1 := iif(rowTemp.DATAFINE>= CharToDate('20150101') and rowTemp.DATAFINE<= CharToDate('20151231'),rowTemp.DATAFINE,NullDate()) */
            rowSID1.FININVIO1 = (CPLib.ge(rowTemp.DATAFINE,CPLib.CharToDate("20150101")) && CPLib.le(rowTemp.DATAFINE,CPLib.CharToDate("20151231"))?rowTemp.DATAFINE:CPLib.NullDate());
            /* rowSID1.TIPINVIO1 := '2' */
            rowSID1.TIPINVIO1 = "2";
            /* rowSID1.TPCINVIO1 := '1' */
            rowSID1.TPCINVIO1 = "1";
            /* rowSID1.UNIQUE1 := _unique */
            rowSID1.UNIQUE1 = _unique;
            /* rowSID1.FLGUNQ1 := _newuc */
            rowSID1.FLGUNQ1 = _newuc;
            /* If w_flgstp='N' */
            if (CPLib.eqr(w_flgstp,"N")) {
              /* mcSID1.AppendRow(rowSID1) */
              mcSID1.AppendRow(rowSID1);
            } else { // Else
              // * --- Write into aetesta from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aetesta");
              m_cPhName = m_Ctx.GetPhName("aetesta");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000000BB")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(_unique,"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(_unique,"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
              m_cSql = m_cSql+"INVIATOC = "+CPLib.ToSQL(( ! (CPLib.Empty(rowSID1.FININVIO1))?1:0),"N",1,0)+", ";
              m_cSql = m_cSql+"DATAINVIOC = "+CPLib.ToSQL(( ! (CPLib.Empty(rowSID1.FININVIO1))?CPLib.Date():CPLib.NullDate()),"D",8,0)+", ";
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
            /* _riga := _riga + iif(rowTemp.DATAFINE>= CharToDate('20150101') and rowTemp.DATAFINE<= CharToDate('20151231'),arfn_fdate_nd(rowTemp.DATAFINE,'N'),'01010001') */
            _riga = _riga+(CPLib.ge(rowTemp.DATAFINE,CPLib.CharToDate("20150101")) && CPLib.le(rowTemp.DATAFINE,CPLib.CharToDate("20151231"))?arfn_fdate_ndR.Make(m_Ctx,this).Run(rowTemp.DATAFINE,"N"):"01010001");
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
              /* If w_flgstp='N' */
              if (CPLib.eqr(w_flgstp,"N")) {
                /* mcSID2.AppendRow(rowSID2) */
                mcSID2.AppendRow(rowSID2);
              } // End If
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
              /* _riga := _riga + iif(rowSID2.FININVIO2 >= CharToDate('20150101') and rowSID2.FININVIO2<= CharToDate('20151231'),arfn_fdate_nd(rowSID2.FININVIO2,'N'),'01010001') */
              _riga = _riga+(CPLib.ge(rowSID2.FININVIO2,CPLib.CharToDate("20150101")) && CPLib.le(rowSID2.FININVIO2,CPLib.CharToDate("20151231"))?arfn_fdate_ndR.Make(m_Ctx,this).Run(rowSID2.FININVIO2,"N"):"01010001");
              /* _riga := _riga + Str(rowSID2.FCFINVIO2,1,0) */
              _riga = _riga+CPLib.Str(rowSID2.FCFINVIO2,1,0);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Upper(rowSID2.CFSINVIO2)),16) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Upper(rowSID2.CFSINVIO2)),16);
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000000E8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000000E8(m_Ctx,m_oWrInfo);
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
        /* Exec "Operazioni Extraconto" Page 4:Page_4 */
        Page_4();
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
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000000F6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000F6(m_Ctx,m_oWrInfo);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000000FD")+"delete from "+m_oWrInfo.GetTableWriteName();
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000000FE")+"delete from "+m_oWrInfo.GetTableWriteName();
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
          /* gMsgProc := gMsgProc + 'Ora Inizio Aggiornamento Dati: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Inizio Aggiornamento Dati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* If w_flgstp='N' */
          if (CPLib.eqr(w_flgstp,"N")) {
            /* _conta := 0 */
            _conta = CPLib.Round(0,0);
            /* _oldmsg := '' */
            _oldmsg = "";
            for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
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
              // * --- Insert into sid_invio1 from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio1");
              m_cPhName = m_Ctx.GetPhName("sid_invio1");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"0000010A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000010A(m_Ctx,m_oWrInfo);
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"0000010D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(rowSID1.UNIQUE1,"C",50,0,m_cServer)+", ";
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
                // * --- Write into aetesta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"0000010F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(rowSID1.UNIQUE1,"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(rowSID1.UNIQUE1,"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = m_cSql+"INVIATOC = "+CPLib.ToSQL(( ! (CPLib.Empty(rowSID1.FININVIO1))?1:0),"N",1,0)+", ";
                m_cSql = m_cSql+"DATAINVIOC = "+CPLib.ToSQL(( ! (CPLib.Empty(rowSID1.FININVIO1))?CPLib.Date():CPLib.NullDate()),"D",8,0)+", ";
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
            }
            for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2._iterable_()) {
              // * --- Insert into sid_invio2 from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio2");
              m_cPhName = m_Ctx.GetPhName("sid_invio2");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"00000116")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000116(m_Ctx,m_oWrInfo);
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
          } // End If
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
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione periodo 2015-'+_mese+" : "+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione periodo 2015-"+_mese+" : "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
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
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_fam_modifiche_2015=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione Modifiche 2015: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Inizio Elaborazione Modifiche 2015: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
      gMsgImp = "Attendere. Estrazione dati per il periodo ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Fill memory cursor mcTemp on qbe_fam_modifiche_2015
      mcTemp.Zap();
      SPBridge.HMCaller _h00000121;
      _h00000121 = new SPBridge.HMCaller();
      _h00000121.Set("m_cVQRList",m_cVQRList);
      _h00000121.Set("_dadata",_dataini);
      _h00000121.Set("_adata",_datafin);
      if (Cursor_qbe_fam_modifiche_2015!=null)
        Cursor_qbe_fam_modifiche_2015.Close();
      Cursor_qbe_fam_modifiche_2015 = new VQRHolder("qbe_fam_modifiche_2015",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000121,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_fam_modifiche_2015;
        Cursor_qbe_fam_modifiche_2015.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arrt_famprimo: query on qbe_fam_modifiche_2015 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_fam_modifiche_2015.Eof())) {
        mcTemp.AppendBlank();
        mcTemp.row.RAPPORTO = Cursor_qbe_fam_modifiche_2015.GetString("RAPPORTO");
        mcTemp.row.DATAINI = Cursor_qbe_fam_modifiche_2015.GetDate("DATAINI");
        mcTemp.row.DATAFINE = Cursor_qbe_fam_modifiche_2015.GetDate("DATAFINE");
        mcTemp.row.TIPOAG = Cursor_qbe_fam_modifiche_2015.GetString("TIPOAG");
        mcTemp.row.TIPORAP = Cursor_qbe_fam_modifiche_2015.GetString("TIPORAP");
        mcTemp.row.DESCRAP = Cursor_qbe_fam_modifiche_2015.GetString("DESCRAP");
        mcTemp.row.VALUTA = Cursor_qbe_fam_modifiche_2015.GetString("VALUTA");
        mcTemp.row.INVIATO = Cursor_qbe_fam_modifiche_2015.GetDouble("INVIATO");
        mcTemp.row.TIPO = Cursor_qbe_fam_modifiche_2015.GetString("TIPO");
        mcTemp.row.CAB = Cursor_qbe_fam_modifiche_2015.GetString("CAB");
        mcTemp.row.UNIQUECODE = Cursor_qbe_fam_modifiche_2015.GetString("UNIQUECODE");
        mcTemp.row.OLDINTER = Cursor_qbe_fam_modifiche_2015.GetString("OLDINTER");
        mcTemp.row.IDBASE = Cursor_qbe_fam_modifiche_2015.GetString("IDBASE");
        mcTemp.row.DATAMODI = Cursor_qbe_fam_modifiche_2015.GetDate("DATAMODI");
        mcTemp.row.IDESITO = Cursor_qbe_fam_modifiche_2015.GetString("IDESITO");
        mcTemp.row.ISOAGE = Cursor_qbe_fam_modifiche_2015.GetString("ISOAGE");
        Cursor_qbe_fam_modifiche_2015.Next();
      }
      m_cConnectivityError = Cursor_qbe_fam_modifiche_2015.ErrorMessage();
      Cursor_qbe_fam_modifiche_2015.Close();
      mcTemp.GoTop();
      /* If mcTemp.RecCount() > 0 */
      if (CPLib.gt(mcTemp.RecCount(),0)) {
        /* mcSID0.Zap() */
        mcSID0.Zap();
        /* mcSID1.Zap() */
        mcSID1.Zap();
        /* mcSID2.Zap() */
        mcSID2.Zap();
        /* mcSID2r.Zap() */
        mcSID2r.Zap();
        /* mcSID3.Zap() */
        mcSID3.Zap();
        /* mcSID3r.Zap() */
        mcSID3r.Zap();
        /* _nomefile := LRTrim(gIntemediario)+"_2015"+_mese+"_"+DateTimeToChar(DateTime()) */
        _nomefile = CPLib.LRTrim(gIntemediario)+"_2015"+_mese+"_"+CPLib.DateTimeToChar(CPLib.DateTime());
        /* fhand := FileLibMit.OpenWrite('/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
        fhand = FileLibMit.OpenWrite("/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
        /* _invio := '201500_2_2' */
        _invio = "201500_2_2";
        /* rowSID0.CODINVIO := _invio */
        rowSID0.CODINVIO = _invio;
        /* rowSID0.TIPINVIO := '2' */
        rowSID0.TIPINVIO = "2";
        /* rowSID0.TPCINVIO := '2' */
        rowSID0.TPCINVIO = "2";
        /* rowSID0.ANNINVIO := '0000' */
        rowSID0.ANNINVIO = "0000";
        /* rowSID0.MESINVIO := '00' */
        rowSID0.MESINVIO = "00";
        /* rowSID0.FLEINVIO := _nomefile */
        rowSID0.FLEINVIO = _nomefile;
        /* mcSID0.AppendRow(rowSID0) */
        mcSID0.AppendRow(rowSID0);
        // * --- Delete from sid_invio
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sid_invio");
        m_cPhName = m_Ctx.GetPhName("sid_invio");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"00000136")+"delete from "+m_oWrInfo.GetTableWriteName();
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
        // * --- Insert into sid_invio from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("sid_invio");
        m_cPhName = m_Ctx.GetPhName("sid_invio");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"00000137")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_00000137(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0000","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("00","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
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
        /* _crea := 1 */
        _crea = CPLib.Round(1,0);
        /* _riga := '0' */
        _riga = "0";
        /* _riga := _riga + 'ARU00' */
        _riga = _riga+"ARU00";
        /* _riga := _riga + '2' */
        _riga = _riga+"2";
        /* _riga := _riga + '2' */
        _riga = _riga+"2";
        /* _riga := _riga + '0000' */
        _riga = _riga+"0000";
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
          /* _riga := _riga + LibreriaMit.SpacePad(Upper(LRTrim(intermbo->CODFISC)),16) */
          _riga = _riga+LibreriaMit.SpacePad(CPLib.Upper(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16);
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
        for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
          /* rowSID1.CODINVIO1 := _invio */
          rowSID1.CODINVIO1 = _invio;
          /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
          rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
          /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
          rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
          /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
          rowSID1.INIINVIO1 = rowTemp.DATAINI;
          /* rowSID1.FININVIO1 := iif(rowTemp.DATAFINE>= CharToDate('20150101') and rowTemp.DATAFINE<= CharToDate('20151231'),rowTemp.DATAFINE,NullDate()) */
          rowSID1.FININVIO1 = (CPLib.ge(rowTemp.DATAFINE,CPLib.CharToDate("20150101")) && CPLib.le(rowTemp.DATAFINE,CPLib.CharToDate("20151231"))?rowTemp.DATAFINE:CPLib.NullDate());
          /* rowSID1.TIPINVIO1 := '2' */
          rowSID1.TIPINVIO1 = "2";
          /* rowSID1.TPCINVIO1 := '2' */
          rowSID1.TPCINVIO1 = "2";
          /* mcSID1.AppendRow(rowSID1) */
          mcSID1.AppendRow(rowSID1);
          /* _tipo1 := _tipo1 + 1 */
          _tipo1 = CPLib.Round(_tipo1+1,0);
          /* _unique := '' */
          _unique = "";
          // * --- Read from aetesta
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rowTemp.RAPPORTO,"C",25,0,m_cServer),m_cServer,rowTemp.RAPPORTO);
          if (m_Ctx.IsSharedTemp("aetesta")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _unique = Read_Cursor.GetString("UNIQUECODE");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aetesta into routine arrt_famprimo returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _unique = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
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
          /* _riga := _riga + iif(rowTemp.DATAFINE>= CharToDate('20150101') and rowTemp.DATAFINE<= CharToDate('20151231'),arfn_fdate_nd(rowTemp.DATAFINE,'N'),'01010001') */
          _riga = _riga+(CPLib.ge(rowTemp.DATAFINE,CPLib.CharToDate("20150101")) && CPLib.le(rowTemp.DATAFINE,CPLib.CharToDate("20151231"))?arfn_fdate_ndR.Make(m_Ctx,this).Run(rowTemp.DATAFINE,"N"):"01010001");
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
            /* _riga := _riga + iif(rowTemp.TIPO='O','01010001',iif(rowTemp.DATAFINE>= CharToDate('20150101') and rowTemp.DATAFINE<= CharToDate('20151231'),arfn_fdate_nd(rowTemp.DATAFINE,'N'),'01010001')) */
            _riga = _riga+(CPLib.eqr(rowTemp.TIPO,"O")?"01010001":(CPLib.ge(rowTemp.DATAFINE,CPLib.CharToDate("20150101")) && CPLib.le(rowTemp.DATAFINE,CPLib.CharToDate("20151231"))?arfn_fdate_ndR.Make(m_Ctx,this).Run(rowTemp.DATAFINE,"N"):"01010001"));
            /* _riga := _riga + Str(rowSID2.FCFINVIO2,1,0) */
            _riga = _riga+CPLib.Str(rowSID2.FCFINVIO2,1,0);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowSID2.CFSINVIO2),16) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowSID2.CFSINVIO2),16);
            /* _riga := _riga + rowSID2.RUOINVIO2 */
            _riga = _riga+rowSID2.RUOINVIO2;
            /* If Len(LRTrim(rowSID2.CFSINVIO2)) = 16 */
            if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(rowSID2.CFSINVIO2)),16)) {
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
          /* If At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98") <> 0 */
          if (CPLib.ne(CPLib.At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98"),0)) {
            /* mcSID3r := arfn_fam_mesefile03(rowSID1,2015,rowTemp.TIPO,rowTemp.VALUTA) */
            mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,2015,rowTemp.TIPO,rowTemp.VALUTA);
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
                /* _riga := _riga + Right('00000000000000000'+LRTrim(Str(rowSID3.IM1INVIO3,17,0)),17) */
                _riga = _riga+CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM1INVIO3,17,0)),17);
                /* _riga := _riga + Str(rowSID3.FI1INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI1INVIO3,1,0);
                /* _riga := _riga + Right('00000000000000000'+LRTrim(Str(rowSID3.IM2INVIO3,17,0)),17) */
                _riga = _riga+CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM2INVIO3,17,0)),17);
                /* _riga := _riga + Str(rowSID3.FI2INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI2INVIO3,1,0);
                /* _riga := _riga + Right('00000000000000000'+LRTrim(Str(rowSID3.IM3INVIO3,17,0)),17) */
                _riga = _riga+CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM3INVIO3,17,0)),17);
                /* _riga := _riga + Str(rowSID3.FI3INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI3INVIO3,1,0);
                /* _riga := _riga + Right('00000000000000000'+LRTrim(Str(rowSID3.IM4INVIO3,17,0)),17) */
                _riga = _riga+CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM4INVIO3,17,0)),17);
                /* _riga := _riga + Str(rowSID3.FI4INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI4INVIO3,1,0);
                /* _riga := _riga + Right('00000000000000000'+LRTrim(Str(rowSID3.IM5INVIO3,17,0)),17) */
                _riga = _riga+CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM5INVIO3,17,0)),17);
                /* _riga := _riga + Str(rowSID3.FI5INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI5INVIO3,1,0);
                /* _riga := _riga + Right('00000000000000000'+LRTrim(Str(rowSID3.IM6INVIO3,17,0)),17) */
                _riga = _riga+CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM6INVIO3,17,0)),17);
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000001A5")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000001A5(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("0000","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("00","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
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
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000001B2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000001B2(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("0000","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("00","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
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
          // * --- Delete from sid_invio3
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sid_invio3");
          m_cPhName = m_Ctx.GetPhName("sid_invio3");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000001B9")+"delete from "+m_oWrInfo.GetTableWriteName();
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
          }
          // * --- Delete from sid_invio2
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("sid_invio2");
          m_cPhName = m_Ctx.GetPhName("sid_invio2");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000001BA")+"delete from "+m_oWrInfo.GetTableWriteName();
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
          m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000001BB")+"delete from "+m_oWrInfo.GetTableWriteName();
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
          for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
            // * --- Insert into sid_invio1 from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sid_invio1");
            m_cPhName = m_Ctx.GetPhName("sid_invio1");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000001BD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001BD(m_Ctx,m_oWrInfo);
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
          }
          for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2._iterable_()) {
            // * --- Insert into sid_invio2 from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sid_invio2");
            m_cPhName = m_Ctx.GetPhName("sid_invio2");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000001BF")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001BF(m_Ctx,m_oWrInfo);
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
          for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3._iterable_()) {
            // * --- Insert into sid_invio3 from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sid_invio3");
            m_cPhName = m_Ctx.GetPhName("sid_invio3");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"000001C1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_000001C1(m_Ctx,m_oWrInfo);
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
            }
          }
        } // End If
        /* gMsgProc := gMsgProc + 'Sono stati generati '+LRTrim(Str(_conta,10,0))+" record" +NL // Messaggio */
        gMsgProc = gMsgProc+"Sono stati generati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" record"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine controllo periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine controllo periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        /* gMsgProc := gMsgProc + 'Non ci sono modifiche per il periodo considerato: '+arfn_fdate(_dataini)+" - " +arfn_fdate(_datafin)+NL // Messaggio */
        gMsgProc = gMsgProc+"Non ci sono modifiche per il periodo considerato: "+arfn_fdateR.Make(m_Ctx,this).Run(_dataini)+" - "+arfn_fdateR.Make(m_Ctx,this).Run(_datafin)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione Modifiche 2015: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione Modifiche 2015: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_fam_modifiche_2015!=null)
          Cursor_qbe_fam_modifiche_2015.Close();
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
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
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
      // * --- Select from qbe_famperiodo_opx_min_max
      SPBridge.HMCaller _h000001CA;
      _h000001CA = new SPBridge.HMCaller();
      _h000001CA.Set("m_cVQRList",m_cVQRList);
      _h000001CA.Set("_dadata",_dataini);
      _h000001CA.Set("_adata",_datafin);
      _h000001CA.Set("_inviato",1);
      if (Cursor_qbe_famperiodo_opx_min_max!=null)
        Cursor_qbe_famperiodo_opx_min_max.Close();
      Cursor_qbe_famperiodo_opx_min_max = new VQRHolder("qbe_famperiodo_opx_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001CA,true).GetResultSet(m_Ctx);
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
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
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
          /* _cicli := iif(Mod(_reccount,1000) <> 0,Int(_reccount/1000) + 1,Int(_reccount/1000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,1000),0)?CPLib.Int(_reccount/1000)+1:CPLib.Int(_reccount/1000)),0);
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
              /* _top := _min + 999 */
              _top = CPLib.Round(_min+999,0);
              /* ElseIf _contacicli = _cicli */
            } else if (CPLib.eqr(_contacicli,_cicli)) {
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _max */
              _top = CPLib.Round(_max,0);
            } else { // Else
              /* _bottom := _top + 1 */
              _bottom = CPLib.Round(_top+1,0);
              /* _top := _bottom + 999 */
              _top = CPLib.Round(_bottom+999,0);
            } // End If
          } // End If
          /* gMsgImp := 'Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If Empty(_oldmsg) */
          if (CPLib.Empty(_oldmsg)) {
            /* gMsgProc := gMsgProc + 'Periodo: 2015-'+_mese+' - Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio */
            gMsgProc = gMsgProc+"Periodo: 2015-"+_mese+" - Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := Strtran(gMsgProc,_oldmsg,'Periodo: 2015-'+_mese+" - " + LRTrim(gMsgImp)) // Messaggio */
            gMsgProc = CPLib.Strtran(gMsgProc,_oldmsg,"Periodo: 2015-"+_mese+" - "+CPLib.LRTrim(gMsgImp));
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
          /* _oldmsg := 'Periodo: 2015-'+_mese+' - Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) */
          _oldmsg = "Periodo: 2015-"+_mese+" - Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
            gMsgImp = "Lettura operazioni extraconto in corso ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            // * --- Fill memory cursor mcTemp on qbe_famperiodo_opx01
            mcTemp.Zap();
            SPBridge.HMCaller _h000001EF;
            _h000001EF = new SPBridge.HMCaller();
            _h000001EF.Set("m_cVQRList",m_cVQRList);
            _h000001EF.Set("_dadata",_dataini);
            _h000001EF.Set("_adata",_datafin);
            _h000001EF.Set("_inviato",1);
            _h000001EF.Set("_bottom",_bottom);
            _h000001EF.Set("_top",_top);
            if (Cursor_qbe_famperiodo_opx01!=null)
              Cursor_qbe_famperiodo_opx01.Close();
            Cursor_qbe_famperiodo_opx01 = new VQRHolder("qbe_famperiodo_opx01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000001EF,true).GetResultSet(m_Ctx);
            {
              final CPResultSet m_TheCursor = Cursor_qbe_famperiodo_opx01;
              Cursor_qbe_famperiodo_opx01.ActionOnClose(new Runnable() {
                public void run() {
                  if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                    com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                    if ( ! (CPLib.IsNull(info))) {
                      info.log("Routine arrt_famprimo: query on qbe_famperiodo_opx01 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
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
                /* _unique := arfn_agechar(_unique,"_") */
                _unique = arfn_agecharR.Make(m_Ctx,this).Run(_unique,"_");
                /* _unique := Strtran(LRTrim(_unique)," ","_") */
                _unique = CPLib.Strtran(CPLib.LRTrim(_unique)," ","_");
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
                /* rowSID1.UNIQUE1 := _unique */
                rowSID1.UNIQUE1 = _unique;
                /* rowSID1.FLGUNQ1 := _newuc */
                rowSID1.FLGUNQ1 = _newuc;
                /* If w_flgstp='S' */
                if (CPLib.eqr(w_flgstp,"S")) {
                  // * --- Write into opextrbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"00000202")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                  m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(_unique,"C",50,0,m_cServer)+", ";
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
                  /* mcSID1.AppendRow(rowSID1) */
                  mcSID1.AppendRow(rowSID1);
                } // End If
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
                  /* If w_flgstp='N' */
                  if (CPLib.eqr(w_flgstp,"N")) {
                    /* mcSID2.AppendRow(rowSID2) */
                    mcSID2.AppendRow(rowSID2);
                  } // End If
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
                  /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(Upper(rowSID2.CFSINVIO2)),16) */
                  _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Upper(rowSID2.CFSINVIO2)),16);
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
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famprimo",142,"00000230")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000230(m_Ctx,m_oWrInfo);
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
                /* gMsgImp := 'Sono stati generati '+LRTrim(Str(_conta,10,0))+" record su un totale di "+LRTrim(Str(_tot,10,0)) // Messaggio Import */
                gMsgImp = "Sono stati generati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" record su un totale di "+CPLib.LRTrim(CPLib.Str(_tot,10,0));
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
      m_Caller.SetString("flgnuovi","C",1,0,w_flgnuovi);
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.SetString("mese","C",2,0,w_mese);
      m_Caller.SetString("flgstp","C",2,0,w_flgstp);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_famprimoR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_famprimoR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_flgnuovi = m_Caller.GetString("flgnuovi","C",1,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    w_mese = m_Caller.GetString("mese","C",2,0);
    w_flgstp = m_Caller.GetString("flgstp","C",2,0);
    _conta = 0;
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
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_fam_periodo01_minmax,qbe_fam_periodo01,qbe_fam_modifiche_2015,qbe_famperiodo_opx_min_max,qbe_famperiodo_opx01,
  public static final String m_cVQRList = ",qbe_fam_periodo01_minmax,qbe_fam_periodo01,qbe_fam_modifiche_2015,qbe_famperiodo_opx_min_max,qbe_famperiodo_opx01,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_exec_sid,arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdate,arfn_fdate_nd,arfn_fdatetime,arfn_finemese,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_exec_sid,arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdate,arfn_fdate_nd,arfn_fdatetime,arfn_finemese,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000007E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000088(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+"TIPINVIO,";
    p_cSql = p_cSql+"TPCINVIO,";
    p_cSql = p_cSql+"DATINVIO,";
    p_cSql = p_cSql+"ANNINVIO,";
    p_cSql = p_cSql+"MESINVIO,";
    p_cSql = p_cSql+"FLEINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000000F6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_0000010A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000116(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_00000137(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+"TIPINVIO,";
    p_cSql = p_cSql+"TPCINVIO,";
    p_cSql = p_cSql+"DATINVIO,";
    p_cSql = p_cSql+"ANNINVIO,";
    p_cSql = p_cSql+"MESINVIO,";
    p_cSql = p_cSql+"FLEINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001A5(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001B2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001BD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001BF(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
  protected static String GetFieldsName_000001C1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio3",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000230(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
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
