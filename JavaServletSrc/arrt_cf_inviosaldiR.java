// * --- Area Manuale = BO - Header
// * --- arrt_cf_inviosaldi
import java.io.*;
import java.util.Scanner;
// * --- Fine Area Manuale
public class arrt_cf_inviosaldiR implements CallerWithObjs {
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
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_tmp_saldi;
  public String m_cServer_tmp_saldi;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_tbvalute;
  public String m_cServer_tbvalute;
  public String m_cPhName_aeinvio;
  public String m_cServer_aeinvio;
  public String m_cPhName_aecanc;
  public String m_cServer_aecanc;
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
  public String m_cPhName_aedecanc;
  public String m_cServer_aedecanc;
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
  public double w_anno;
  public java.sql.Date w_a_data;
  public java.sql.Date w_dadata;
  public String w_fileprodotto;
  public String w_flgann;
  public String w_flgsos;
  public String w_flgope;
  public String w_nomefile;
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gAzienda;
  public String gPathApp;
  public double _min;
  public double _max;
  public double _tot;
  public double _mono;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public double _area1;
  public double _area2;
  public String fhand;
  public String _nomefile;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public double _contaglob;
  public double _rifprog;
  public String _rif1;
  public String _rif2;
  public String _cab;
  public String _desrap;
  public String _val;
  public String _file;
  public double _ContaB;
  public double _ContaC;
  public double _i;
  public double _ContaArea1;
  public double _ContaArea2;
  public String _entra;
  public String _cfinter;
  public String _uniquecode;
  public String _prap;
  public String _codinter;
  public double _conta;
  public MemoryCursor_tmp_saldi mcBase;
  public MemoryCursorRow_tmp_saldi rowBase;
  public double _contagen;
  public String _prgdel;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_cf_inviosaldi
  public int _r;
  // * --- Fine Area Manuale
  public arrt_cf_inviosaldiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cf_inviosaldi",m_Caller);
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_tmp_saldi = p_ContextObject.GetPhName("tmp_saldi");
    if (m_cPhName_tmp_saldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_saldi = m_cPhName_tmp_saldi+" "+m_Ctx.GetWritePhName("tmp_saldi");
    }
    m_cServer_tmp_saldi = p_ContextObject.GetServer("tmp_saldi");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_tbvalute = p_ContextObject.GetPhName("tbvalute");
    if (m_cPhName_tbvalute.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvalute = m_cPhName_tbvalute+" "+m_Ctx.GetWritePhName("tbvalute");
    }
    m_cServer_tbvalute = p_ContextObject.GetServer("tbvalute");
    m_cPhName_aeinvio = p_ContextObject.GetPhName("aeinvio");
    if (m_cPhName_aeinvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeinvio = m_cPhName_aeinvio+" "+m_Ctx.GetWritePhName("aeinvio");
    }
    m_cServer_aeinvio = p_ContextObject.GetServer("aeinvio");
    m_cPhName_aecanc = p_ContextObject.GetPhName("aecanc");
    if (m_cPhName_aecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aecanc = m_cPhName_aecanc+" "+m_Ctx.GetWritePhName("aecanc");
    }
    m_cServer_aecanc = p_ContextObject.GetServer("aecanc");
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    m_cPhName_aedecanc = p_ContextObject.GetPhName("aedecanc");
    if (m_cPhName_aedecanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aedecanc = m_cPhName_aedecanc+" "+m_Ctx.GetWritePhName("aedecanc");
    }
    m_cServer_aedecanc = p_ContextObject.GetServer("aedecanc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
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
    if (CPLib.eqr("_area1",p_cVarName)) {
      return _area1;
    }
    if (CPLib.eqr("_area2",p_cVarName)) {
      return _area2;
    }
    if (CPLib.eqr("_contaglob",p_cVarName)) {
      return _contaglob;
    }
    if (CPLib.eqr("_rifprog",p_cVarName)) {
      return _rifprog;
    }
    if (CPLib.eqr("_ContaB",p_cVarName)) {
      return _ContaB;
    }
    if (CPLib.eqr("_ContaC",p_cVarName)) {
      return _ContaC;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_ContaArea1",p_cVarName)) {
      return _ContaArea1;
    }
    if (CPLib.eqr("_ContaArea2",p_cVarName)) {
      return _ContaArea2;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_contagen",p_cVarName)) {
      return _contagen;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cf_inviosaldi";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("fileprodotto",p_cVarName)) {
      return w_fileprodotto;
    }
    if (CPLib.eqr("flgann",p_cVarName)) {
      return w_flgann;
    }
    if (CPLib.eqr("flgsos",p_cVarName)) {
      return w_flgsos;
    }
    if (CPLib.eqr("flgope",p_cVarName)) {
      return w_flgope;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("_rif1",p_cVarName)) {
      return _rif1;
    }
    if (CPLib.eqr("_rif2",p_cVarName)) {
      return _rif2;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      return _cab;
    }
    if (CPLib.eqr("_desrap",p_cVarName)) {
      return _desrap;
    }
    if (CPLib.eqr("_val",p_cVarName)) {
      return _val;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      return _file;
    }
    if (CPLib.eqr("_entra",p_cVarName)) {
      return _entra;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      return _cfinter;
    }
    if (CPLib.eqr("_uniquecode",p_cVarName)) {
      return _uniquecode;
    }
    if (CPLib.eqr("_prap",p_cVarName)) {
      return _prap;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      return _codinter;
    }
    if (CPLib.eqr("_prgdel",p_cVarName)) {
      return _prgdel;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
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
    if (CPLib.eqr("mcBase",p_cVarName)) {
      return mcBase;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowBase",p_cVarName)) {
      return rowBase;
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
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
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
    if (CPLib.eqr("_area1",p_cVarName)) {
      _area1 = value;
      return;
    }
    if (CPLib.eqr("_area2",p_cVarName)) {
      _area2 = value;
      return;
    }
    if (CPLib.eqr("_contaglob",p_cVarName)) {
      _contaglob = value;
      return;
    }
    if (CPLib.eqr("_rifprog",p_cVarName)) {
      _rifprog = value;
      return;
    }
    if (CPLib.eqr("_ContaB",p_cVarName)) {
      _ContaB = value;
      return;
    }
    if (CPLib.eqr("_ContaC",p_cVarName)) {
      _ContaC = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_ContaArea1",p_cVarName)) {
      _ContaArea1 = value;
      return;
    }
    if (CPLib.eqr("_ContaArea2",p_cVarName)) {
      _ContaArea2 = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_contagen",p_cVarName)) {
      _contagen = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("fileprodotto",p_cVarName)) {
      w_fileprodotto = value;
      return;
    }
    if (CPLib.eqr("flgann",p_cVarName)) {
      w_flgann = value;
      return;
    }
    if (CPLib.eqr("flgsos",p_cVarName)) {
      w_flgsos = value;
      return;
    }
    if (CPLib.eqr("flgope",p_cVarName)) {
      w_flgope = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("_rif1",p_cVarName)) {
      _rif1 = value;
      return;
    }
    if (CPLib.eqr("_rif2",p_cVarName)) {
      _rif2 = value;
      return;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      _cab = value;
      return;
    }
    if (CPLib.eqr("_desrap",p_cVarName)) {
      _desrap = value;
      return;
    }
    if (CPLib.eqr("_val",p_cVarName)) {
      _val = value;
      return;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      _file = value;
      return;
    }
    if (CPLib.eqr("_entra",p_cVarName)) {
      _entra = value;
      return;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      _cfinter = value;
      return;
    }
    if (CPLib.eqr("_uniquecode",p_cVarName)) {
      _uniquecode = value;
      return;
    }
    if (CPLib.eqr("_prap",p_cVarName)) {
      _prap = value;
      return;
    }
    if (CPLib.eqr("_codinter",p_cVarName)) {
      _codinter = value;
      return;
    }
    if (CPLib.eqr("_prgdel",p_cVarName)) {
      _prgdel = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowBase",p_cVarName)) {
      rowBase = (MemoryCursorRow_tmp_saldi)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcBase",p_cVarName)) {
      mcBase = (MemoryCursor_tmp_saldi)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* w_anno Numeric(4, 0) */
    /* w_a_data Date */
    /* w_dadata Date */
    /* w_fileprodotto Char(128) */
    /* w_flgann Char(1) */
    /* w_flgsos Char(1) */
    /* w_flgope Char(1) */
    /* w_nomefile Char(50) */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Char(120) // Messaggio */
    /* gIntemediario Char(11) // Intermediario */
    /* gAzienda Char(10) // Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* _min Numeric(15, 0) */
    /* _max Numeric(15, 0) */
    /* _tot Numeric(15, 0) */
    /* _mono Numeric(1, 0) */
    /* _cicli Numeric(15, 0) */
    /* _contacicli Numeric(15, 0) */
    /* _bottom Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _area1 Numeric(10, 0) */
    /* _area2 Numeric(10, 0) */
    /* fhand Char(10) */
    /* _nomefile Char(30) */
    /* cNomeFile Char(100) */
    /* cOnlyNomeFile Char(50) */
    /* cNomeFileZip Char(100) */
    /* _contaglob Numeric(10, 0) */
    /* _rifprog Numeric(10, 0) */
    /* _rif1 Char(9) */
    /* _rif2 Char(9) */
    /* _cab Char(5) */
    /* _desrap Char(24) */
    /* _val Char(3) */
    /* _file Memo */
    /* _ContaB Numeric(10, 0) */
    /* _ContaC Numeric(10, 0) */
    /* _i Numeric(10, 0) */
    /* _ContaArea1 Numeric(10, 0) */
    /* _ContaArea2 Numeric(10, 0) */
    /* _entra Char(1) */
    /* _cfinter Char(16) */
    /* _uniquecode Char(50) */
    /* _prap Char(10) */
    /* _codinter Char(16) */
    /* _conta Numeric(10, 0) */
    /* mcBase MemoryCursor(tmp_saldi) */
    /* rowBase Row(tmp_saldi) */
    /* _contagen Numeric(15, 0) */
    /* _prgdel Char(10) */
    /* _nomefile := LRTrim(gIntemediario)+"_"+Str(w_anno,4,0)+DateTimeToChar(DateTime()) */
    _nomefile = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(w_anno,4,0)+CPLib.DateTimeToChar(CPLib.DateTime());
    /* w_fileprodotto := _nomefile */
    w_fileprodotto = _nomefile;
    /* cNomeFile := LRTrim(gPathApp)+'/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile) */
    cNomeFile = CPLib.LRTrim(gPathApp)+"/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile);
    // * --- Delete from tmp_saldi
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_saldi");
    m_cPhName = m_Ctx.GetPhName("tmp_saldi");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_saldi",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"0000003C")+"delete from "+m_oWrInfo.GetTableWriteName();
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
    if (CPLib.lt(m_nUpdatedRows,0)) {
      m_Sql.AbortTransaction();
    }
    m_Sql.CompleteTransaction();
    m_cLastMsgError = m_Sql.TransactionErrorMessage();
    if (CPLib.ne(m_cLastMsgError,"")) {
      m_bError = true;
    }
    /* _contaglob := 0 */
    _contaglob = CPLib.Round(0,0);
    /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    // Legge i file degli esiti
    File di = new File(CPLib.LRTrim(gPathApp)+"/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/");
    File fl[] = di.listFiles();
    int _i;
    int count=0;
    for (_i=0; _i < fl.length; _i++)  {
      fl[_i].delete();
    }
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000042status;
    nTry00000042status = m_Sql.GetTransactionStatus();
    String cTry00000042msg;
    cTry00000042msg = m_Sql.TransactionErrorMessage();
    try {
      /* If w_flgann='N' */
      if (CPLib.eqr(w_flgann,"N")) {
        /* Exec "Rapporti Continuativi" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Operazioni Extraconto" Page 3:Page_3 */
        Page_3();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Exec "Crea il file di testo" Page 4:Page_4 */
        Page_4();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
      } else { // Else
        /* Exec "Crea il file di annullamento" Page 5:Page_5 */
        Page_5();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        // * --- Write into aesaldi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aesaldi");
        m_cPhName = m_Ctx.GetPhName("aesaldi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"00000048")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"ANNULLATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aesaldi",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer),m_cServer,CPLib.Str(w_anno,4,0))+"";
        m_cSql = m_cSql+" and NOMEFILE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_nomefile,"?",0,0,m_cServer),m_cServer,w_nomefile)+"";
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
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
      /* gMsgImp := "Estrazione Dati terminata. Premere il bottone con l'ingranaggio per l'elaborazione con SID" // Messaggio Import */
      gMsgImp = "Estrazione Dati terminata. Premere il bottone con l'ingranaggio per l'elaborazione con SID";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
      /* gMsgImp := "Estrazione Dati terminatacon errori. Consultare i contatori standard per gli errori" // Messaggio Import */
      gMsgImp = "Estrazione Dati terminatacon errori. Consultare i contatori standard per gli errori";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000042status,0)) {
        m_Sql.SetTransactionStatus(nTry00000042status,cTry00000042msg);
      }
    }
    /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_inviosaldi_rapd=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aetesta=null;
    CPResultSet Cursor_aeannora=null;
    CPResultSet Cursor_aerighe=null;
    CPResultSet Cursor_aederig=null;
    CPResultSet Cursor_tmp_saldi=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Estrae Saldi per Rapporti Continuativi */
      /* gMsgImp := 'Ricerca Rapporti Continuativi in corso ...' // Messaggio Import */
      gMsgImp = "Ricerca Rapporti Continuativi in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _area1 := 1 */
      _area1 = CPLib.Round(1,0);
      /* _contagen := 0 */
      _contagen = CPLib.Round(0,0);
      // * --- Select from qbe_inviosaldi_rapd
      if (Cursor_qbe_inviosaldi_rapd!=null)
        Cursor_qbe_inviosaldi_rapd.Close();
      Cursor_qbe_inviosaldi_rapd = new VQRHolder("qbe_inviosaldi_rapd",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviosaldi_rapd.Eof())) {
        /* gMsgImp := 'Lettura dati Rapporto -> '+qbe_inviosaldi_rapd->RAPPORTO // Messaggio Import */
        gMsgImp = "Lettura dati Rapporto -> "+Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO");
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _prap := '' */
        _prap = "";
        // * --- Read from aecanc
        m_cServer = m_Ctx.GetServer("aecanc");
        m_cPhName = m_Ctx.GetPhName("aecanc");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO"));
        if (m_Ctx.IsSharedTemp("aecanc")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          _prap = Read_Cursor.GetString("PROGRES");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aecanc into routine arrt_cf_inviosaldi returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          _prap = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(_prap)) */
        if (CPLib.Empty(CPLib.LRTrim(_prap))) {
          // * --- Select from aetesta
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          if (Cursor_aetesta!=null)
            Cursor_aetesta.Close();
          Cursor_aetesta = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aetesta")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aetesta.Eof())) {
            /* _cab := '' */
            _cab = "";
            /* _desrap := '' */
            _desrap = "";
            /* _val := '' */
            _val = "";
            /* _uniquecode := aetesta->UNIQUECODE */
            _uniquecode = Cursor_aetesta.GetString("UNIQUECODE");
            /* _codinter := aetesta->OLDINTER */
            _codinter = Cursor_aetesta.GetString("OLDINTER");
            /* _contaglob := _contaglob + 1 */
            _contaglob = CPLib.Round(_contaglob+1,0);
            /* _rifprog := iif(Mod(_contaglob,10)=1,_rifprog+1,_rifprog) */
            _rifprog = CPLib.Round((CPLib.eqr(CPLib.Mod(_contaglob,10),1)?_rifprog+1:_rifprog),0);
            /* _rif1 := Right('000000000'+LRTrim(Str(_rifprog,9,0)),9) */
            _rif1 = CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,9,0)),9);
            /* If aetesta->TIPOAG='99' */
            if (CPLib.eqr(Cursor_aetesta.GetString("TIPOAG"),"99")) {
              /* _desrap := Left(aetesta->DESCRI,24) */
              _desrap = CPLib.Left(Cursor_aetesta.GetString("DESCRI"),24);
            } // End If
            /* If At(aetesta->TIPOAG,'|01|02|03|12|13') <> 0 */
            if (CPLib.ne(CPLib.At(Cursor_aetesta.GetString("TIPOAG"),"|01|02|03|12|13"),0)) {
              /* _cab := aetesta->CAB */
              _cab = Cursor_aetesta.GetString("CAB");
            } // End If
            /* If At(aetesta->TIPOAG,'|01|02|03|04|05|06|07|09|10|14|15|23|24') <> 0 */
            if (CPLib.ne(CPLib.At(Cursor_aetesta.GetString("TIPOAG"),"|01|02|03|04|05|06|07|09|10|14|15|23|24"),0)) {
              // * --- Read from tbvalute
              m_cServer = m_Ctx.GetServer("tbvalute");
              m_cPhName = m_Ctx.GetPhName("tbvalute");
              m_cSql = "";
              m_cSql = m_cSql+"CODVAL="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aetesta.GetString("VALUTA"),"C",3,0,m_cServer),m_cServer,Cursor_aetesta.GetString("VALUTA"));
              if (m_Ctx.IsSharedTemp("tbvalute")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("ISO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _val = Read_Cursor.GetString("ISO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbvalute into routine arrt_cf_inviosaldi returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _val = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            // * --- Select from aeannora
            m_cServer = m_Ctx.GetServer("aeannora");
            m_cPhName = m_Ctx.GetPhName("aeannora");
            if (Cursor_aeannora!=null)
              Cursor_aeannora.Close();
            Cursor_aeannora = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0)+"  and  ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,w_anno)+" "+")"+(m_Ctx.IsSharedTemp("aeannora")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_aeannora.Eof())) {
              /* _contagen := _contagen + 1 */
              _contagen = CPLib.Round(_contagen+1,0);
              // * --- Insert into tmp_saldi from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_saldi");
              m_cPhName = m_Ctx.GetPhName("tmp_saldi");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_saldi",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"0000006A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_desrap,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_val,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cab,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.lt(Cursor_aeannora.GetDouble("IMPORTO1"),0)?CPLib.Right(CPLib.Space(17)+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO1"),17,0)),17):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO1"),17,0)),17)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.lt(Cursor_aeannora.GetDouble("IMPORTO2"),0)?CPLib.Right(CPLib.Space(17)+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO2"),17,0)),17):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO2"),17,0)),17)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.lt(Cursor_aeannora.GetDouble("IMPORTO3"),0)?CPLib.Right(CPLib.Space(17)+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO3"),17,0)),17):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO3"),17,0)),17)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.lt(Cursor_aeannora.GetDouble("IMPORTO4"),0)?CPLib.Right(CPLib.Space(17)+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO4"),17,0)),17):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO4"),17,0)),17)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.lt(Cursor_aeannora.GetDouble("IMPORTO5"),0)?CPLib.Right(CPLib.Space(6)+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO5"),6,0)),6):CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_aeannora.GetDouble("IMPORTO5"),6,0)),6)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeannora.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_rif1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_contagen,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("00000","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_saldi",true);
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
              // * --- Write into aeannora from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aeannora");
              m_cPhName = m_Ctx.GetPhName("aeannora");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeannora",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"0000006B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"PROG1 = "+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"FILEANNO = "+CPLib.ToSQL(_nomefile,"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROGREC = "+CPLib.ToSQL(_rif1,"C",9,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeannora",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer),m_cServer,Cursor_aetesta.GetString("RAPPORTO"))+"";
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
              }
              Cursor_aeannora.Next();
            }
            m_cConnectivityError = Cursor_aeannora.ErrorMessage();
            Cursor_aeannora.Close();
            // * --- End Select
            /* If w_flgope='S' */
            if (CPLib.eqr(w_flgope,"S")) {
              // * --- Insert into aeinvio from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aeinvio");
              m_cPhName = m_Ctx.GetPhName("aeinvio");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"0000006D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000006D(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_rif1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("R","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aetesta.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeinvio",true);
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
            Cursor_aetesta.Next();
          }
          m_cConnectivityError = Cursor_aetesta.ErrorMessage();
          Cursor_aetesta.Close();
          // * --- End Select
          /* _area2 := 1 */
          _area2 = CPLib.Round(1,0);
          // * --- Select from aerighe
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          if (Cursor_aerighe!=null)
            Cursor_aerighe.Close();
          Cursor_aerighe = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aerighe")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aerighe.Eof())) {
            /* If aerighe->ADATA <= w_a_data and (Empty(aerighe->CDATA) or aerighe->CDATA >= w_dadata) */
            if (CPLib.le(Cursor_aerighe.GetDate("ADATA"),w_a_data) && (CPLib.Empty(Cursor_aerighe.GetDate("CDATA")) || CPLib.ge(Cursor_aerighe.GetDate("CDATA"),w_dadata))) {
              /* _prgdel := '' */
              _prgdel = "";
              // * --- Read from aecanc
              m_cServer = m_Ctx.GetServer("aecanc");
              m_cPhName = m_Ctx.GetPhName("aecanc");
              m_cSql = "";
              m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_aerighe.GetString("IDBASE"));
              if (m_Ctx.IsSharedTemp("aecanc")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _prgdel = Read_Cursor.GetString("PROGRES");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aecanc into routine arrt_cf_inviosaldi returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _prgdel = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_prgdel) */
              if (CPLib.Empty(_prgdel)) {
                /* _contaglob := _contaglob + 1 */
                _contaglob = CPLib.Round(_contaglob+1,0);
                /* _rifprog := iif(Mod(_contaglob,10)=1,_rifprog+1,_rifprog) */
                _rifprog = CPLib.Round((CPLib.eqr(CPLib.Mod(_contaglob,10),1)?_rifprog+1:_rifprog),0);
                /* _rif2 := Right('000000000'+LRTrim(Str(_rifprog,9,0)),9) */
                _rif2 = CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,9,0)),9);
                /* _contagen := _contagen + 1 */
                _contagen = CPLib.Round(_contagen+1,0);
                // * --- Insert into tmp_saldi from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_saldi");
                m_cPhName = m_Ctx.GetPhName("tmp_saldi");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_saldi",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"00000078")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000078(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(_area2,5,0)),5),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000"+CPLib.LRTrim(Cursor_aerighe.GetString("APROG")),25),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rif2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_contagen,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_saldi",true);
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
                /* If w_flgope='S' */
                if (CPLib.eqr(w_flgope,"S")) {
                  // * --- Insert into aeinvio from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aeinvio");
                  m_cPhName = m_Ctx.GetPhName("aeinvio");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"0000007A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_0000007A(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(_area2,5,0)),5),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rif2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("I","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_aerighe.GetString("APROG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeinvio",true);
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
                /* _area2 := _area2 + 1 */
                _area2 = CPLib.Round(_area2+1,0);
              } // End If
            } // End If
            Cursor_aerighe.Next();
          }
          m_cConnectivityError = Cursor_aerighe.ErrorMessage();
          Cursor_aerighe.Close();
          // * --- End Select
          // * --- Select from aederig
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          if (Cursor_aederig!=null)
            Cursor_aederig.Close();
          Cursor_aederig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("aederig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_aederig.Eof())) {
            /* If aederig->ADATA <= w_a_data and (Empty(aederig->CDATA) or aederig->CDATA >= w_dadata) */
            if (CPLib.le(Cursor_aederig.GetDate("ADATA"),w_a_data) && (CPLib.Empty(Cursor_aederig.GetDate("CDATA")) || CPLib.ge(Cursor_aederig.GetDate("CDATA"),w_dadata))) {
              /* _prgdel := '' */
              _prgdel = "";
              // * --- Read from aedecanc
              m_cServer = m_Ctx.GetServer("aedecanc");
              m_cPhName = m_Ctx.GetPhName("aedecanc");
              m_cSql = "";
              m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_aederig.GetString("IDBASE"));
              if (m_Ctx.IsSharedTemp("aedecanc")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _prgdel = Read_Cursor.GetString("PROGRES");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on aedecanc into routine arrt_cf_inviosaldi returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _prgdel = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(_prgdel) */
              if (CPLib.Empty(_prgdel)) {
                /* _contaglob := _contaglob + 1 */
                _contaglob = CPLib.Round(_contaglob+1,0);
                /* _rifprog := iif(Mod(_contaglob,10)=1,_rifprog+1,_rifprog) */
                _rifprog = CPLib.Round((CPLib.eqr(CPLib.Mod(_contaglob,10),1)?_rifprog+1:_rifprog),0);
                /* _rif2 := Right('000000000'+LRTrim(Str(_rifprog,9,0)),9) */
                _rif2 = CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,9,0)),9);
                /* _contagen := _contagen + 1 */
                _contagen = CPLib.Round(_contagen+1,0);
                // * --- Insert into tmp_saldi from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_saldi");
                m_cPhName = m_Ctx.GetPhName("tmp_saldi");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_saldi",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"00000085")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000085(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(_area2,5,0)),5),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000"+CPLib.LRTrim(Cursor_aederig.GetString("APROG")),25),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rif2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_contagen,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_saldi",true);
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
                /* If w_flgope='S' */
                if (CPLib.eqr(w_flgope,"S")) {
                  // * --- Insert into aeinvio from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aeinvio");
                  m_cPhName = m_Ctx.GetPhName("aeinvio");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"00000087")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                  m_cSql = m_cSql+GetFieldsName_00000087(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_rapd.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(_area2,5,0)),5),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_rif2,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("D","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aerighe.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(_codinter,"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aederig.GetString("APROG"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_aederig.GetString("APROG")),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeinvio",true);
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
                /* _area2 := _area2 + 1 */
                _area2 = CPLib.Round(_area2+1,0);
              } // End If
            } // End If
            Cursor_aederig.Next();
          }
          m_cConnectivityError = Cursor_aederig.ErrorMessage();
          Cursor_aederig.Close();
          // * --- End Select
          /* _area1 := _area1 + 1 */
          _area1 = CPLib.Round(_area1+1,0);
        } // End If
        Cursor_qbe_inviosaldi_rapd.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviosaldi_rapd.ErrorMessage();
      Cursor_qbe_inviosaldi_rapd.Close();
      // * --- End Select
      /* If w_flgope='N' */
      if (CPLib.eqr(w_flgope,"N")) {
        // * --- Fill memory cursor mcBase on tmp_saldi
        mcBase.Zap();
        m_cServer = m_Ctx.GetServer("tmp_saldi");
        m_cPhName = m_Ctx.GetPhName("tmp_saldi");
        if (Cursor_tmp_saldi!=null)
          Cursor_tmp_saldi.Close();
        Cursor_tmp_saldi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_saldi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"NUMPROG,PROGR,TIPODAT,PROGR2 ",m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_tmp_saldi;
          Cursor_tmp_saldi.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arrt_cf_inviosaldi: query on tmp_saldi returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_tmp_saldi.Eof())) {
          mcBase.AppendBlank();
          mcBase.row.TIPODAT = Cursor_tmp_saldi.GetString("TIPODAT");
          mcBase.row.PROGR = Cursor_tmp_saldi.GetString("PROGR");
          mcBase.row.TIPORAP = Cursor_tmp_saldi.GetString("TIPORAP");
          mcBase.row.DESCRAP = Cursor_tmp_saldi.GetString("DESCRAP");
          mcBase.row.CODRAP = Cursor_tmp_saldi.GetString("CODRAP");
          mcBase.row.CAB = Cursor_tmp_saldi.GetString("CAB");
          mcBase.row.IMP1 = Cursor_tmp_saldi.GetString("IMP1");
          mcBase.row.IMP2 = Cursor_tmp_saldi.GetString("IMP2");
          mcBase.row.IMP3 = Cursor_tmp_saldi.GetString("IMP3");
          mcBase.row.IMP4 = Cursor_tmp_saldi.GetString("IMP4");
          mcBase.row.NUM = Cursor_tmp_saldi.GetString("NUM");
          mcBase.row.VALUTA = Cursor_tmp_saldi.GetString("VALUTA");
          mcBase.row.IDESITO = Cursor_tmp_saldi.GetString("IDESITO");
          mcBase.row.PROGR2 = Cursor_tmp_saldi.GetString("PROGR2");
          mcBase.row.IDFILE = Cursor_tmp_saldi.GetString("IDFILE");
          mcBase.row.IDPROG = Cursor_tmp_saldi.GetString("IDPROG");
          mcBase.row.IDBASE = Cursor_tmp_saldi.GetString("IDBASE");
          mcBase.row.NUMPROG = Cursor_tmp_saldi.GetString("NUMPROG");
          mcBase.row.TIPO = Cursor_tmp_saldi.GetString("TIPO");
          mcBase.row.OLDINTER = Cursor_tmp_saldi.GetString("OLDINTER");
          mcBase.row.RAPPORTO = Cursor_tmp_saldi.GetString("RAPPORTO");
          mcBase.row.TERNAFILE = Cursor_tmp_saldi.GetString("TERNAFILE");
          mcBase.row.TERNAPROG = Cursor_tmp_saldi.GetString("TERNAPROG");
          mcBase.row.CONNESINT = Cursor_tmp_saldi.GetString("CONNESINT");
          Cursor_tmp_saldi.Next();
        }
        m_cConnectivityError = Cursor_tmp_saldi.ErrorMessage();
        Cursor_tmp_saldi.Close();
        mcBase.GoTop();
        // * --- Delete from tmp_saldi
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("tmp_saldi");
        m_cPhName = m_Ctx.GetPhName("tmp_saldi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_saldi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"0000008C")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
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
    } finally {
      try {
        if (Cursor_qbe_inviosaldi_rapd!=null)
          Cursor_qbe_inviosaldi_rapd.Close();
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
        if (Cursor_aetesta!=null)
          Cursor_aetesta.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeannora!=null)
          Cursor_aeannora.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aerighe!=null)
          Cursor_aerighe.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aederig!=null)
          Cursor_aederig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_saldi!=null)
          Cursor_tmp_saldi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_inviosaldi_minmax_ope=null;
    CPResultSet Cursor_qbe_inviosaldi_ope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Estrae Saldi per Operazioni ExtraConto */
      /* gMsgProc := gMsgProc + 'Ora Inizio Lettura Operazioni Extraconto: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inizio Lettura Operazioni Extraconto: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Ricerca Operazioni ExtraConto in corso ...' // Messaggio Import */
      gMsgImp = "Ricerca Operazioni ExtraConto in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_inviosaldi_minmax_ope
      if (Cursor_qbe_inviosaldi_minmax_ope!=null)
        Cursor_qbe_inviosaldi_minmax_ope.Close();
      Cursor_qbe_inviosaldi_minmax_ope = new VQRHolder("qbe_inviosaldi_minmax_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_inviosaldi_minmax_ope.Eof())) {
        /* _min := qbe_inviosaldi_minmax_ope->MINPRG */
        _min = CPLib.Round(Cursor_qbe_inviosaldi_minmax_ope.GetDouble("MINPRG"),0);
        /* _max := qbe_inviosaldi_minmax_ope->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_inviosaldi_minmax_ope.GetDouble("MAXPRG"),0);
        /* _tot := qbe_inviosaldi_minmax_ope->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_inviosaldi_minmax_ope.GetDouble("TOTPRG"),0);
        Cursor_qbe_inviosaldi_minmax_ope.Next();
      }
      m_cConnectivityError = Cursor_qbe_inviosaldi_minmax_ope.ErrorMessage();
      Cursor_qbe_inviosaldi_minmax_ope.Close();
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
        /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
      } // End If
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* _area2 := 1 */
      _area2 = CPLib.Round(1,0);
      /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
      gMsgImp = "Lettura operazioni extraconto in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* While _contacicli <= _cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* _bottom := ((_contacicli -1 ) * 5000) + 1 */
          _bottom = CPLib.Round(((_contacicli-1)*5000)+1,0);
          /* _top := _contacicli * 5000 */
          _top = CPLib.Round(_contacicli*5000,0);
        } // End If
        /* gMsgImp := 'Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_inviosaldi_ope
          if (Cursor_qbe_inviosaldi_ope!=null)
            Cursor_qbe_inviosaldi_ope.Close();
          Cursor_qbe_inviosaldi_ope = new VQRHolder("qbe_inviosaldi_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_inviosaldi_ope.Eof())) {
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* _prap := '' */
            _prap = "";
            /* If Empty(LRTrim(qbe_inviosaldi_ope->PROGRES)) */
            if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_inviosaldi_ope.GetString("PROGRES")))) {
              /* _area2 := 1 */
              _area2 = CPLib.Round(1,0);
              /* _contaglob := _contaglob + 1 */
              _contaglob = CPLib.Round(_contaglob+1,0);
              /* _rifprog := iif(Mod(_contaglob,10)=1,_rifprog+1,_rifprog) */
              _rifprog = CPLib.Round((CPLib.eqr(CPLib.Mod(_contaglob,10),1)?_rifprog+1:_rifprog),0);
              /* _rif1 := Right('000000000'+LRTrim(Str(_rifprog,9,0)),9) */
              _rif1 = CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,9,0)),9);
              /* If w_flgope='S' */
              if (CPLib.eqr(w_flgope,"S")) {
                /* _contagen := _contagen + 1 */
                _contagen = CPLib.Round(_contagen+1,0);
                // * --- Insert into tmp_saldi from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_saldi");
                m_cPhName = m_Ctx.GetPhName("tmp_saldi");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_saldi",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"000000B8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000B8(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL("1","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("0",17),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("0",17),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_inviosaldi_ope.GetDouble("SALDO"),17,0)),17),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Replicate("0",17),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_inviosaldi_ope.GetDouble("QUANTITA"),6,0)),6),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("X","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rif1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_contagen,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("00000","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_saldi",true);
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
                // * --- Insert into aeinvio from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeinvio");
                m_cPhName = m_Ctx.GetPhName("aeinvio");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"000000B9")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000B9(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rif1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("X","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeinvio",true);
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
                /* mcBase.AppendBlank() */
                mcBase.AppendBlank();
                /* mcBase.TIPODAT := '1' */
                mcBase.row.TIPODAT = "1";
                /* mcBase.PROGR := Right('0000000000'+LRTrim(Str(_area1,10,0)),10) */
                mcBase.row.PROGR = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10);
                /* mcBase.PROGR2 := '00000' */
                mcBase.row.PROGR2 = "00000";
                /* mcBase.TIPORAP := qbe_inviosaldi_ope->TIPOAG */
                mcBase.row.TIPORAP = Cursor_qbe_inviosaldi_ope.GetString("TIPOAG");
                /* mcBase.CODRAP := qbe_inviosaldi_ope->UNIQUECODE */
                mcBase.row.CODRAP = Cursor_qbe_inviosaldi_ope.GetString("UNIQUECODE");
                /* mcBase.VALUTA := qbe_inviosaldi_ope->VALUTA */
                mcBase.row.VALUTA = Cursor_qbe_inviosaldi_ope.GetString("VALUTA");
                /* mcBase.IMP1 := Replicate('0',17) */
                mcBase.row.IMP1 = CPLib.Replicate("0",17);
                /* mcBase.IMP2 := Replicate('0',17) */
                mcBase.row.IMP2 = CPLib.Replicate("0",17);
                /* mcBase.IMP3 := Right('00000000000000000'+LRTrim(Str(qbe_inviosaldi_ope->SALDO,17,0)),17) */
                mcBase.row.IMP3 = CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_inviosaldi_ope.GetDouble("SALDO"),17,0)),17);
                /* mcBase.IMP4 := Replicate('0',17) */
                mcBase.row.IMP4 = CPLib.Replicate("0",17);
                /* mcBase.NUM := Right('000000'+LRTrim(Str(qbe_inviosaldi_ope->QUANTITA,6,0)),6) */
                mcBase.row.NUM = CPLib.Right("000000"+CPLib.LRTrim(CPLib.Str(Cursor_qbe_inviosaldi_ope.GetDouble("QUANTITA"),6,0)),6);
                /* mcBase.IDBASE := qbe_inviosaldi_ope->IDBASE */
                mcBase.row.IDBASE = Cursor_qbe_inviosaldi_ope.GetString("IDBASE");
                /* mcBase.TIPO := 'X' */
                mcBase.row.TIPO = "X";
                /* mcBase.NUMPROG := _rif1 */
                mcBase.row.NUMPROG = _rif1;
                /* mcBase.RAPPORTO := qbe_inviosaldi_ope->RAPPORTO */
                mcBase.row.RAPPORTO = Cursor_qbe_inviosaldi_ope.GetString("RAPPORTO");
                /* mcBase.SaveRow() */
                mcBase.SaveRow();
              } // End If
              /* _contaglob := _contaglob + 1 */
              _contaglob = CPLib.Round(_contaglob+1,0);
              /* _rifprog := iif(Mod(_contaglob,10)=1,_rifprog+1,_rifprog) */
              _rifprog = CPLib.Round((CPLib.eqr(CPLib.Mod(_contaglob,10),1)?_rifprog+1:_rifprog),0);
              /* _rif2 := Right('000000000'+LRTrim(Str(_rifprog,9,0)),9) */
              _rif2 = CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_rifprog,9,0)),9);
              /* If w_flgope='S' */
              if (CPLib.eqr(w_flgope,"S")) {
                /* _contagen := _contagen + 1 */
                _contagen = CPLib.Round(_contagen+1,0);
                // * --- Insert into tmp_saldi from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_saldi");
                m_cPhName = m_Ctx.GetPhName("tmp_saldi");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_saldi",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"000000D1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000D1(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(_area2,5,0)),5),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000000000000000000"+CPLib.LRTrim(Cursor_qbe_inviosaldi_ope.GetString("APROG")),25),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rif2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_contagen,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_saldi",true);
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
                // * --- Insert into aeinvio from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aeinvio");
                m_cPhName = m_Ctx.GetPhName("aeinvio");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"000000D2")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000D2(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(_area2,5,0)),5),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_rif2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("X","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_uniquecode,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("AFILE"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(Cursor_qbe_inviosaldi_ope.GetString("APROG")),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeinvio",true);
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
                /* mcBase.AppendBlank() */
                mcBase.AppendBlank();
                /* mcBase.TIPODAT := '2' */
                mcBase.row.TIPODAT = "2";
                /* mcBase.PROGR := Right('0000000000'+LRTrim(Str(_area1,10,0)),10) */
                mcBase.row.PROGR = CPLib.Right("0000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10);
                /* mcBase.PROGR2 := Right('00000'+LRTrim(Str(_area2,5,0)),5) */
                mcBase.row.PROGR2 = CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(_area2,5,0)),5);
                /* mcBase.CODRAP := qbe_inviosaldi_ope->UNIQUECODE */
                mcBase.row.CODRAP = Cursor_qbe_inviosaldi_ope.GetString("UNIQUECODE");
                /* mcBase.TIPO := '0' */
                mcBase.row.TIPO = "0";
                /* mcBase.IDFILE := qbe_inviosaldi_ope->AFILE */
                mcBase.row.IDFILE = Cursor_qbe_inviosaldi_ope.GetString("AFILE");
                /* mcBase.IDPROG := Right('0000000000000000000000000'+LRTrim(qbe_inviosaldi_ope->APROG),25) */
                mcBase.row.IDPROG = CPLib.Right("0000000000000000000000000"+CPLib.LRTrim(Cursor_qbe_inviosaldi_ope.GetString("APROG")),25);
                /* mcBase.IDBASE := qbe_inviosaldi_ope->IDBASE */
                mcBase.row.IDBASE = Cursor_qbe_inviosaldi_ope.GetString("IDBASE");
                /* mcBase.NUMPROG := _rif2 */
                mcBase.row.NUMPROG = _rif2;
                /* mcBase.RAPPORTO := qbe_inviosaldi_ope->RAPPORTO */
                mcBase.row.RAPPORTO = Cursor_qbe_inviosaldi_ope.GetString("RAPPORTO");
                /* mcBase.TERNAFILE := qbe_inviosaldi_ope->AFILE */
                mcBase.row.TERNAFILE = Cursor_qbe_inviosaldi_ope.GetString("AFILE");
                /* mcBase.TERNAPROG := LRTrim(qbe_inviosaldi_ope->APROG) */
                mcBase.row.TERNAPROG = CPLib.LRTrim(Cursor_qbe_inviosaldi_ope.GetString("APROG"));
                /* mcBase.CONNESINT := qbe_inviosaldi_ope->CONNESINT */
                mcBase.row.CONNESINT = Cursor_qbe_inviosaldi_ope.GetString("CONNESINT");
                /* mcBase.SaveRow() */
                mcBase.SaveRow();
              } // End If
              // * --- Write into aeoprig from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aeoprig");
              m_cPhName = m_Ctx.GetPhName("aeoprig");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"000000E2")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"FILEANNO = "+CPLib.ToSQL(_nomefile,"C",50,0,m_cServer)+", ";
              m_cSql = m_cSql+"ANNO = "+CPLib.ToSQL(w_anno,"C",4,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROG1 = "+CPLib.ToSQL(CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_area1,10,0)),10),"C",10,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROG2 = "+CPLib.ToSQL(CPLib.Right("00000"+CPLib.LRTrim(CPLib.Str(_area2,5,0)),5),"C",5,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROGBASE = "+CPLib.ToSQL(_rif1,"C",9,0,m_cServer)+", ";
              m_cSql = m_cSql+"PROGREC = "+CPLib.ToSQL(_rif2,"C",9,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aeoprig",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_inviosaldi_ope.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_inviosaldi_ope.GetString("IDBASE"))+"";
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
              /* gMsgImp := 'Lettura dati soggetto con NDG -> '+LRTrim(qbe_inviosaldi_ope->CONNESINT)+' - Operazione '+LRTrim(Str(_conta,10,0))+" su "+ LRTrim(Str(_tot,10,0)) // Messaggio Import */
              gMsgImp = "Lettura dati soggetto con NDG -> "+CPLib.LRTrim(Cursor_qbe_inviosaldi_ope.GetString("CONNESINT"))+" - Operazione "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_tot,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _area1 := _area1 + 1 */
              _area1 = CPLib.Round(_area1+1,0);
            } // End If
            Cursor_qbe_inviosaldi_ope.Next();
          }
          m_cConnectivityError = Cursor_qbe_inviosaldi_ope.ErrorMessage();
          Cursor_qbe_inviosaldi_ope.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
      /* gMsgProc := gMsgProc + 'Ora Fine Lettura Operazioni Extraconto: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Lettura Operazioni Extraconto: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_inviosaldi_minmax_ope!=null)
          Cursor_qbe_inviosaldi_minmax_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_inviosaldi_ope!=null)
          Cursor_qbe_inviosaldi_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_tab_mmc=null;
    CPResultSet Cursor_qbe_tmp_saldi=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Crea il file di testo */
      /* gMsgProc := gMsgProc + 'Ora Inizio Scrittura File: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Inizio Scrittura File: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := 'Inizio scrittura file per agenzia entrate ...' // Messaggio Import */
      gMsgImp = "Inizio scrittura file per agenzia entrate ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _file := '' */
      _file = "";
      /* fhand := FileLibMit.OpenWrite('/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWrite("/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(gIntemediario,"?",0,0,m_cServer, m_oParameters),m_cServer,gIntemediario)+" "+")"+(m_Ctx.IsSharedTemp("intermbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _cfinter := LibreriaMit.SpacePad(intermbo->CODFISC,16) */
        _cfinter = LibreriaMit.SpacePad(Cursor_intermbo.GetString("CODFISC"),16);
        /* _file := 'A' */
        _file = "A";
        /* _file := _file + Space(14) */
        _file = _file+CPLib.Space(14);
        /* _file := _file + 'DCR00' */
        _file = _file+"DCR00";
        /* _file := _file + Space(2) */
        _file = _file+CPLib.Space(2);
        /* _file := _file + LibreriaMit.SpacePad(LRTrim(intermbo->CODFISC),16) */
        _file = _file+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC")),16);
        /* _file := _file + Space(1859) */
        _file = _file+CPLib.Space(1859);
        /* _file := _file + 'A' + NL */
        _file = _file+"A"+"\n";
        /* FileLibMit.Write(fhand,_file) */
        FileLibMit.Write(fhand,_file);
        /* _file := 'B' */
        _file = "B";
        /* _file := _file + 'DCR00' */
        _file = _file+"DCR00";
        /* _file := _file + '55' */
        _file = _file+"55";
        /* _file := _file +'0' // Invio Ordinario */
        _file = _file+"0";
        /* _file := _file + Replicate('0',24) // Invio Ordinario */
        _file = _file+CPLib.Replicate("0",24);
        /* _file := _file + LibreriaMit.SpacePad(LRTrim(intermbo->CODFISC),16) */
        _file = _file+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC")),16);
        /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
          /* _file := _file +LibreriaMit.SpacePad(intermbo->COGNOME,26) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("COGNOME"),26);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->NOME,25) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NOME"),25);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->SESSO,1) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("SESSO"),1);
          /* _file := _file +arfn_fdate_nd(intermbo->DATANASC," ") // Invio Ordinario */
          _file = _file+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_intermbo.GetDate("DATANASC")," ");
          /* _file := _file +LibreriaMit.SpacePad(intermbo->NASCOMUN,40) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NASCOMUN"),40);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->PROVNA,2) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVNA"),2);
          /* _file := _file +Space(112) // Invio Ordinario */
          _file = _file+CPLib.Space(112);
        } else { // Else
          /* _file := _file +Space(102) // Invio Ordinario */
          _file = _file+CPLib.Space(102);
          /* _file := _file +LibreriaMit.SpacePad(arfn_agechar(intermbo->RAGSOC,' '),70) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("RAGSOC")," "),70);
          /* _file := _file +LibreriaMit.SpacePad(arfn_agechar(intermbo->DESCCIT,' '),40) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("DESCCIT")," "),40);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->PROVINCIA,2) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
        } // End If
        /* _file := _file + iif(w_flgsos='N','1','2') */
        _file = _file+(CPLib.eqr(w_flgsos,"N")?"1":"2");
        /* _file := _file + Str(w_anno,4,0) */
        _file = _file+CPLib.Str(w_anno,4,0);
        /* _file := _file + Space(1629) */
        _file = _file+CPLib.Space(1629);
        /* _file := _file + 'A' + NL */
        _file = _file+"A"+"\n";
        /* FileLibMit.Write(fhand,_file) */
        FileLibMit.Write(fhand,_file);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _i := 1 */
      _i = CPLib.Round(1,0);
      /* _ContaB := 1 */
      _ContaB = CPLib.Round(1,0);
      /* _ContaC := 0 */
      _ContaC = CPLib.Round(0,0);
      /* _ContaArea1 := 0 */
      _ContaArea1 = CPLib.Round(0,0);
      /* _ContaArea2 := 0 */
      _ContaArea2 = CPLib.Round(0,0);
      /* _entra := 'N' */
      _entra = "N";
      /* If w_flgope='S' */
      if (CPLib.eqr(w_flgope,"S")) {
        /* _max := 0 */
        _max = CPLib.Round(0,0);
        /* _min := 0 */
        _min = CPLib.Round(0,0);
        /* _tot := 0 */
        _tot = CPLib.Round(0,0);
        /* _mono := 0 */
        _mono = CPLib.Round(0,0);
        /* _conta := 0 */
        _conta = CPLib.Round(0,0);
        // * --- Select from qbe_tab_mmc
        SPBridge.HMCaller _h0000011F;
        _h0000011F = new SPBridge.HMCaller();
        _h0000011F.Set("m_cVQRList",m_cVQRList);
        _h0000011F.Set("tbname","tmp_saldi");
        _h0000011F.Set("fldname","PROGGEN");
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
        Cursor_qbe_tab_mmc = new VQRHolder("qbe_tab_mmc",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000011F,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tab_mmc.Eof())) {
          /* _min := qbe_tab_mmc->min */
          _min = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("min"),0);
          /* _max := qbe_tab_mmc->max */
          _max = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("max"),0);
          /* _tot := qbe_tab_mmc->tot */
          _tot = CPLib.Round(Cursor_qbe_tab_mmc.GetDouble("tot"),0);
          Cursor_qbe_tab_mmc.Next();
        }
        m_cConnectivityError = Cursor_qbe_tab_mmc.ErrorMessage();
        Cursor_qbe_tab_mmc.Close();
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
          /* _cicli := iif(Mod(_max,5000) <> 0,Int(_max/5000) + 1,Int(_max/5000)) */
          _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,5000),0)?CPLib.Int(_max/5000)+1:CPLib.Int(_max/5000)),0);
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
            /* _bottom := ((_contacicli -1 ) * 5000) + 1 */
            _bottom = CPLib.Round(((_contacicli-1)*5000)+1,0);
            /* _top := _contacicli * 5000 */
            _top = CPLib.Round(_contacicli*5000,0);
          } // End If
          /* gMsgImp := 'Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            // * --- Select from qbe_tmp_saldi
            SPBridge.HMCaller _h00000132;
            _h00000132 = new SPBridge.HMCaller();
            _h00000132.Set("m_cVQRList",m_cVQRList);
            _h00000132.Set("_bottom",_bottom);
            _h00000132.Set("_top",_top);
            if (Cursor_qbe_tmp_saldi!=null)
              Cursor_qbe_tmp_saldi.Close();
            Cursor_qbe_tmp_saldi = new VQRHolder("qbe_tmp_saldi",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000132,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_tmp_saldi.Eof())) {
              /* _entra := 'S' */
              _entra = "S";
              /* If _i=1 */
              if (CPLib.eqr(_i,1)) {
                /* gMsgImp := 'Scrittura record: '+LRTrim(Str(_ContaC,10,0)) // Messaggio Import */
                gMsgImp = "Scrittura record: "+CPLib.LRTrim(CPLib.Str(_ContaC,10,0));
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* _ContaC := _ContaC + 1 */
                _ContaC = CPLib.Round(_ContaC+1,0);
                /* _file := 'C' */
                _file = "C";
                /* If Val(qbe_tmp_saldi->NUMPROG) <> _ContaC */
                if (CPLib.ne(CPLib.Val(Cursor_qbe_tmp_saldi.GetString("NUMPROG")),_ContaC)) {
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } else { // Else
                  /* _file := _file + qbe_tmp_saldi->NUMPROG */
                  _file = _file+Cursor_qbe_tmp_saldi.GetString("NUMPROG");
                } // End If
              } // End If
              /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->TIPODAT,1) */
              _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("TIPODAT"),1);
              /* If qbe_tmp_saldi->TIPODAT='1' */
              if (CPLib.eqr(Cursor_qbe_tmp_saldi.GetString("TIPODAT"),"1")) {
                /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->PROGR,10) */
                _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("PROGR"),10);
                /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->TIPORAP,2) */
                _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("TIPORAP"),2);
                /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->DESCRAP,24) */
                _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("DESCRAP"),24);
                /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->CODRAP,50) */
                _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("CODRAP"),50);
                /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->CAB,5) */
                _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("CAB"),5);
                /* _file := _file + qbe_tmp_saldi->IMP1 */
                _file = _file+Cursor_qbe_tmp_saldi.GetString("IMP1");
                /* _file := _file + qbe_tmp_saldi->IMP2 */
                _file = _file+Cursor_qbe_tmp_saldi.GetString("IMP2");
                /* _file := _file + qbe_tmp_saldi->IMP3 */
                _file = _file+Cursor_qbe_tmp_saldi.GetString("IMP3");
                /* _file := _file + qbe_tmp_saldi->IMP4 */
                _file = _file+Cursor_qbe_tmp_saldi.GetString("IMP4");
                /* _file := _file + qbe_tmp_saldi->NUM */
                _file = _file+Cursor_qbe_tmp_saldi.GetString("NUM");
                /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->VALUTA,3) */
                _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("VALUTA"),3);
                /* _file := _file + Space(10) */
                _file = _file+CPLib.Space(10);
                /* _file := _file + '*' */
                _file = _file+"*";
                /* _ContaArea1 := _ContaArea1 + 1 */
                _ContaArea1 = CPLib.Round(_ContaArea1+1,0);
                /* ElseIf qbe_tmp_saldi->TIPODAT='2' */
              } else if (CPLib.eqr(Cursor_qbe_tmp_saldi.GetString("TIPODAT"),"2")) {
                /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->PROGR2,5) */
                _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("PROGR2"),5);
                /* _file := _file + LibreriaMit.SpacePad(iif(Empty(qbe_tmp_saldi->OLDINTER),_cfinter,qbe_tmp_saldi->OLDINTER),16) */
                _file = _file+LibreriaMit.SpacePad((CPLib.Empty(Cursor_qbe_tmp_saldi.GetString("OLDINTER"))?_cfinter:Cursor_qbe_tmp_saldi.GetString("OLDINTER")),16);
                /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->IDFILE,15) */
                _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("IDFILE"),15);
                /* _file := _file + LibreriaMit.SpacePad(qbe_tmp_saldi->IDPROG,25) */
                _file = _file+LibreriaMit.SpacePad(Cursor_qbe_tmp_saldi.GetString("IDPROG"),25);
                /* _file := _file + Space(10) */
                _file = _file+CPLib.Space(10);
                /* _file := _file + Space(107) */
                _file = _file+CPLib.Space(107);
                /* _file := _file + '*' */
                _file = _file+"*";
                /* _ContaArea2 := _ContaArea2 + 1 */
                _ContaArea2 = CPLib.Round(_ContaArea2+1,0);
              } // End If
              /* _i := _i + 1 */
              _i = CPLib.Round(_i+1,0);
              /* If _i = 11 */
              if (CPLib.eqr(_i,11)) {
                /* _i := 1 */
                _i = CPLib.Round(1,0);
                /* _file := _file + Space(87) */
                _file = _file+CPLib.Space(87);
                /* _file := _file + 'A' + NL */
                _file = _file+"A"+"\n";
                /* FileLibMit.Write(fhand,_file) */
                FileLibMit.Write(fhand,_file);
              } // End If
              Cursor_qbe_tmp_saldi.Next();
            }
            m_cConnectivityError = Cursor_qbe_tmp_saldi.ErrorMessage();
            Cursor_qbe_tmp_saldi.Close();
            // * --- End Select
          } else { // Else
            /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
            gMsgImp = "Lettura operazioni extraconto in corso ...";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          } // End If
          /* _contacicli := _contacicli+1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End While
      } else { // Else
        MemoryCursor_tmp_saldi cpmc_0000015B;
        cpmc_0000015B = new MemoryCursor_tmp_saldi();
        for (MemoryCursorRow_tmp_saldi rowBase : mcBase._iterable_()) {
          cpmc_0000015B.Append(rowBase);
        }
        for (MemoryCursorRow_tmp_saldi rowBase : cpmc_0000015B._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tmp_saldi>(){  public int compare(MemoryCursorRow_tmp_saldi r1,MemoryCursorRow_tmp_saldi r2){    if (CPLib.gt(r1.NUMPROG,r2.NUMPROG)) return 1;    if (CPLib.lt(r1.NUMPROG,r2.NUMPROG)) return -1;    if (CPLib.gt(r1.PROGR,r2.PROGR)) return 1;    if (CPLib.lt(r1.PROGR,r2.PROGR)) return -1;    if (CPLib.gt(r1.TIPODAT,r2.TIPODAT)) return 1;    if (CPLib.lt(r1.TIPODAT,r2.TIPODAT)) return -1;    if (CPLib.gt(r1.PROGR2,r2.PROGR2)) return 1;    if (CPLib.lt(r1.PROGR2,r2.PROGR2)) return -1;    return 0;  }})) {
          /* _entra := 'S' */
          _entra = "S";
          /* If _i=1 */
          if (CPLib.eqr(_i,1)) {
            /* gMsgImp := 'Scrittura record: '+LRTrim(Str(_ContaC,10,0)) // Messaggio Import */
            gMsgImp = "Scrittura record: "+CPLib.LRTrim(CPLib.Str(_ContaC,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _ContaC := _ContaC + 1 */
            _ContaC = CPLib.Round(_ContaC+1,0);
            /* _file := 'C' */
            _file = "C";
            /* If Val(rowBase.NUMPROG) <> _ContaC */
            if (CPLib.ne(CPLib.Val(rowBase.NUMPROG),_ContaC)) {
              // Exit Loop
              if (true) {
                break;
              }
            } else { // Else
              /* _file := _file + rowBase.NUMPROG */
              _file = _file+rowBase.NUMPROG;
            } // End If
          } // End If
          /* _file := _file + LibreriaMit.SpacePad(rowBase.TIPODAT,1) */
          _file = _file+LibreriaMit.SpacePad(rowBase.TIPODAT,1);
          /* If rowBase.TIPODAT='1' */
          if (CPLib.eqr(rowBase.TIPODAT,"1")) {
            /* _file := _file + LibreriaMit.SpacePad(rowBase.PROGR,10) */
            _file = _file+LibreriaMit.SpacePad(rowBase.PROGR,10);
            /* _file := _file + LibreriaMit.SpacePad(rowBase.TIPORAP,2) */
            _file = _file+LibreriaMit.SpacePad(rowBase.TIPORAP,2);
            /* _file := _file + LibreriaMit.SpacePad(rowBase.DESCRAP,24) */
            _file = _file+LibreriaMit.SpacePad(rowBase.DESCRAP,24);
            /* _file := _file + LibreriaMit.SpacePad(rowBase.CODRAP,50) */
            _file = _file+LibreriaMit.SpacePad(rowBase.CODRAP,50);
            /* _file := _file + LibreriaMit.SpacePad(rowBase.CAB,5) */
            _file = _file+LibreriaMit.SpacePad(rowBase.CAB,5);
            /* _file := _file + rowBase.IMP1 */
            _file = _file+rowBase.IMP1;
            /* _file := _file + rowBase.IMP2 */
            _file = _file+rowBase.IMP2;
            /* _file := _file + rowBase.IMP3 */
            _file = _file+rowBase.IMP3;
            /* _file := _file + rowBase.IMP4 */
            _file = _file+rowBase.IMP4;
            /* _file := _file + rowBase.NUM */
            _file = _file+rowBase.NUM;
            /* _file := _file + LibreriaMit.SpacePad(rowBase.VALUTA,3) */
            _file = _file+LibreriaMit.SpacePad(rowBase.VALUTA,3);
            /* _file := _file + Space(10) */
            _file = _file+CPLib.Space(10);
            /* _file := _file + '*' */
            _file = _file+"*";
            /* _ContaArea1 := _ContaArea1 + 1 */
            _ContaArea1 = CPLib.Round(_ContaArea1+1,0);
            // * --- Insert into tmp_saldi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_saldi");
            m_cPhName = m_Ctx.GetPhName("tmp_saldi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_saldi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"00000174")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000174(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.TIPODAT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.PROGR,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.PROGR2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.TIPORAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.CODRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.VALUTA,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.IMP1,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.IMP2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.IMP3,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.IMP4,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.NUM,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_saldi",true);
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
            // * --- Insert into aeinvio from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeinvio");
            m_cPhName = m_Ctx.GetPhName("aeinvio");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"00000175")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000175(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.PROGR,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.CODRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeinvio",true);
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
            /* ElseIf rowBase.TIPODAT='2' */
          } else if (CPLib.eqr(rowBase.TIPODAT,"2")) {
            /* _file := _file + LibreriaMit.SpacePad(rowBase.PROGR2,5) */
            _file = _file+LibreriaMit.SpacePad(rowBase.PROGR2,5);
            /* _file := _file + LibreriaMit.SpacePad(iif(Empty(rowBase.OLDINTER),_cfinter,rowBase.OLDINTER),16) */
            _file = _file+LibreriaMit.SpacePad((CPLib.Empty(rowBase.OLDINTER)?_cfinter:rowBase.OLDINTER),16);
            /* _file := _file + LibreriaMit.SpacePad(rowBase.IDFILE,15) */
            _file = _file+LibreriaMit.SpacePad(rowBase.IDFILE,15);
            /* _file := _file + LibreriaMit.SpacePad(rowBase.IDPROG,25) */
            _file = _file+LibreriaMit.SpacePad(rowBase.IDPROG,25);
            /* _file := _file + Space(10) */
            _file = _file+CPLib.Space(10);
            /* _file := _file + Space(107) */
            _file = _file+CPLib.Space(107);
            /* _file := _file + '*' */
            _file = _file+"*";
            /* _ContaArea2 := _ContaArea2 + 1 */
            _ContaArea2 = CPLib.Round(_ContaArea2+1,0);
            // * --- Insert into tmp_saldi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_saldi");
            m_cPhName = m_Ctx.GetPhName("tmp_saldi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_saldi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"0000017E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000017E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.TIPODAT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.PROGR,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.PROGR2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.CODRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.IDFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.IDPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.IDBASE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.CONNESINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_saldi",true);
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
            // * --- Insert into aeinvio from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeinvio");
            m_cPhName = m_Ctx.GetPhName("aeinvio");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeinvio",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"0000017F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000017F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.PROGR,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.PROGR2,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.NUMPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.CONNESINT,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.TERNAFILE,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.TERNAPROG,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowBase.CODRAP,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeinvio",true);
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
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
          /* If _i = 11 */
          if (CPLib.eqr(_i,11)) {
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* _file := _file + Space(87) */
            _file = _file+CPLib.Space(87);
            /* _file := _file + 'A' + NL */
            _file = _file+"A"+"\n";
            /* FileLibMit.Write(fhand,_file) */
            FileLibMit.Write(fhand,_file);
          } // End If
        }
      } // End If
      /* If _i > 1 and _i < 11 */
      if (CPLib.gt(_i,1) && CPLib.lt(_i,11)) {
        /* While _i < 11 */
        while (CPLib.lt(_i,11)) {
          /* _file := _file + Space(180) */
          _file = _file+CPLib.Space(180);
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
        } // End While
        /* _file := _file + Space(87) */
        _file = _file+CPLib.Space(87);
        /* _file := _file + 'A' + NL */
        _file = _file+"A"+"\n";
        /* FileLibMit.Write(fhand,_file) */
        FileLibMit.Write(fhand,_file);
      } // End If
      /* _file := 'Z' */
      _file = "Z";
      /* _file := _file + Space(2) */
      _file = _file+CPLib.Space(2);
      /* _file := _file + Right('000000000'+LRTrim(Str(_ContaB,9,0)),9) */
      _file = _file+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_ContaB,9,0)),9);
      /* _file := _file + Right('000000000'+LRTrim(Str(_ContaC,9,0)),9) */
      _file = _file+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_ContaC,9,0)),9);
      /* _file := _file + Right('000000000'+LRTrim(Str(_ContaArea1,9,0)),9) */
      _file = _file+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_ContaArea1,9,0)),9);
      /* _file := _file + Right('000000000'+LRTrim(Str(_ContaArea2,9,0)),9) */
      _file = _file+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_ContaArea2,9,0)),9);
      /* _file := _file + Space(1858) */
      _file = _file+CPLib.Space(1858);
      /* _file := _file + 'A' + NL */
      _file = _file+"A"+"\n";
      /* FileLibMit.Write(fhand,_file) */
      FileLibMit.Write(fhand,_file);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      // * --- Insert into aesaldi from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aesaldi");
      m_cPhName = m_Ctx.GetPhName("aesaldi");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"00000199")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000199(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,50),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("4","?",0,0,m_cServer)+", ";
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
      /* gMsgProc := gMsgProc + 'Ora Fine Scrittura File: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Scrittura File: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tab_mmc!=null)
          Cursor_qbe_tab_mmc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tmp_saldi!=null)
          Cursor_qbe_tmp_saldi.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_aesaldi=null;
    try {
      /* Crea il file di testo */
      /* _file := '' */
      _file = "";
      /* fhand := FileLibMit.OpenWrite('/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWrite("/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL(gIntemediario,"?",0,0,m_cServer, m_oParameters),m_cServer,gIntemediario)+" "+")"+(m_Ctx.IsSharedTemp("intermbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _cfinter := LibreriaMit.SpacePad(intermbo->CODFISC,16) */
        _cfinter = LibreriaMit.SpacePad(Cursor_intermbo.GetString("CODFISC"),16);
        /* _file := 'A' */
        _file = "A";
        /* _file := _file + Space(14) */
        _file = _file+CPLib.Space(14);
        /* _file := _file + 'DCR00' */
        _file = _file+"DCR00";
        /* _file := _file + Space(2) */
        _file = _file+CPLib.Space(2);
        /* _file := _file + LibreriaMit.SpacePad(LRTrim(intermbo->CODFISC),16) */
        _file = _file+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC")),16);
        /* _file := _file + Space(1859) */
        _file = _file+CPLib.Space(1859);
        /* _file := _file + 'A' + NL */
        _file = _file+"A"+"\n";
        /* FileLibMit.Write(fhand,_file) */
        FileLibMit.Write(fhand,_file);
        /* _file := 'B' */
        _file = "B";
        /* _file := _file + 'DCR00' */
        _file = _file+"DCR00";
        /* _file := _file + '55' */
        _file = _file+"55";
        /* _file := _file +'1' // Annullamento */
        _file = _file+"1";
        // * --- Select from aesaldi
        m_cServer = m_Ctx.GetServer("aesaldi");
        m_cPhName = m_Ctx.GetPhName("aesaldi");
        if (Cursor_aesaldi!=null)
          Cursor_aesaldi.Close();
        Cursor_aesaldi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select PROTOCOLLO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.Str(w_anno,4,0))+"  and  TIPO='4' "+")"+(m_Ctx.IsSharedTemp("aesaldi")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aesaldi.Eof())) {
          /* _file := _file + aesaldi->PROTOCOLLO // Invio Ordinario */
          _file = _file+Cursor_aesaldi.GetString("PROTOCOLLO");
          Cursor_aesaldi.Next();
        }
        m_cConnectivityError = Cursor_aesaldi.ErrorMessage();
        Cursor_aesaldi.Close();
        // * --- End Select
        /* _file := _file + LibreriaMit.SpacePad(LRTrim(intermbo->CODFISC),16) */
        _file = _file+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC")),16);
        /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
          /* _file := _file +LibreriaMit.SpacePad(intermbo->COGNOME,26) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("COGNOME"),26);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->NOME,25) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NOME"),25);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->SESSO,1) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("SESSO"),1);
          /* _file := _file +arfn_fdate_nd(intermbo->DATANASC," ") // Invio Ordinario */
          _file = _file+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_intermbo.GetDate("DATANASC")," ");
          /* _file := _file +LibreriaMit.SpacePad(intermbo->NASCOMUN,40) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NASCOMUN"),40);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->PROVNA,2) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVNA"),2);
          /* _file := _file +Space(112) // Invio Ordinario */
          _file = _file+CPLib.Space(112);
        } else { // Else
          /* _file := _file +Space(102) // Invio Ordinario */
          _file = _file+CPLib.Space(102);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->RAGSOC,70) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("RAGSOC"),70);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->DESCCIT,40) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("DESCCIT"),40);
          /* _file := _file +LibreriaMit.SpacePad(intermbo->PROVINCIA,2) // Invio Ordinario */
          _file = _file+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
        } // End If
        /* _file := _file + '1' */
        _file = _file+"1";
        /* _file := _file + Str(w_anno,4,0) */
        _file = _file+CPLib.Str(w_anno,4,0);
        /* _file := _file + Space(1629) */
        _file = _file+CPLib.Space(1629);
        /* _file := _file + 'A' + NL */
        _file = _file+"A"+"\n";
        /* FileLibMit.Write(fhand,_file) */
        FileLibMit.Write(fhand,_file);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _file := 'Z' */
      _file = "Z";
      /* _file := _file + Space(2) */
      _file = _file+CPLib.Space(2);
      /* _file := _file + '000000001' */
      _file = _file+"000000001";
      /* _file := _file + Right('000000000'+LRTrim(Str(_ContaC,9,0)),9) */
      _file = _file+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_ContaC,9,0)),9);
      /* _file := _file + Right('000000000'+LRTrim(Str(_ContaArea1,9,0)),9) */
      _file = _file+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_ContaArea1,9,0)),9);
      /* _file := _file + Right('000000000'+LRTrim(Str(_ContaArea2,9,0)),9) */
      _file = _file+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_ContaArea2,9,0)),9);
      /* _file := _file + Space(1858) */
      _file = _file+CPLib.Space(1858);
      /* _file := _file + 'A' + NL */
      _file = _file+"A"+"\n";
      /* FileLibMit.Write(fhand,_file) */
      FileLibMit.Write(fhand,_file);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      // * --- Insert into aesaldi from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aesaldi");
      m_cPhName = m_Ctx.GetPhName("aesaldi");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_cf_inviosaldi",271,"000001CE")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000001CE(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,50),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Str(w_anno,4,0),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
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
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aesaldi!=null)
          Cursor_aesaldi.Close();
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
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.SetDate("a_data","D",8,0,w_a_data);
      m_Caller.SetDate("dadata","D",8,0,w_dadata);
      m_Caller.SetString("fileprodotto","C",128,0,w_fileprodotto);
      m_Caller.SetString("flgann","C",1,0,w_flgann);
      m_Caller.SetString("flgsos","C",1,0,w_flgsos);
      m_Caller.SetString("flgope","C",1,0,w_flgope);
      m_Caller.SetString("nomefile","C",50,0,w_nomefile);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cf_inviosaldiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cf_inviosaldiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_fileprodotto = m_Caller.GetString("fileprodotto","C",128,0);
    w_flgann = m_Caller.GetString("flgann","C",1,0);
    w_flgsos = m_Caller.GetString("flgsos","C",1,0);
    w_flgope = m_Caller.GetString("flgope","C",1,0);
    w_nomefile = m_Caller.GetString("nomefile","C",50,0);
    _min = 0;
    _max = 0;
    _tot = 0;
    _mono = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _area1 = 0;
    _area2 = 0;
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(30);
    cNomeFile = CPLib.Space(100);
    cOnlyNomeFile = CPLib.Space(50);
    cNomeFileZip = CPLib.Space(100);
    _contaglob = 0;
    _rifprog = 0;
    _rif1 = CPLib.Space(9);
    _rif2 = CPLib.Space(9);
    _cab = CPLib.Space(5);
    _desrap = CPLib.Space(24);
    _val = CPLib.Space(3);
    _file = "";
    _ContaB = 0;
    _ContaC = 0;
    _i = 0;
    _ContaArea1 = 0;
    _ContaArea2 = 0;
    _entra = CPLib.Space(1);
    _cfinter = CPLib.Space(16);
    _uniquecode = CPLib.Space(50);
    _prap = CPLib.Space(10);
    _codinter = CPLib.Space(16);
    _conta = 0;
    mcBase = new MemoryCursor_tmp_saldi();
    rowBase = new MemoryCursorRow_tmp_saldi();
    _contagen = 0;
    _prgdel = CPLib.Space(10);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_inviosaldi_rapd,qbe_inviosaldi_minmax_ope,qbe_inviosaldi_ope,qbe_tab_mmc,qbe_tmp_saldi,
  public static final String m_cVQRList = ",qbe_inviosaldi_rapd,qbe_inviosaldi_minmax_ope,qbe_inviosaldi_ope,qbe_tab_mmc,qbe_tmp_saldi,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_fdate_nd,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_fdate_nd,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000006A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPODAT,";
    p_cSql = p_cSql+"PROGR,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"CODRAP,";
    p_cSql = p_cSql+"DESCRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"CAB,";
    p_cSql = p_cSql+"IMP1,";
    p_cSql = p_cSql+"IMP2,";
    p_cSql = p_cSql+"IMP3,";
    p_cSql = p_cSql+"IMP4,";
    p_cSql = p_cSql+"NUM,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROGGEN,";
    p_cSql = p_cSql+"PROGR2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_saldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeinvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000078(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPODAT,";
    p_cSql = p_cSql+"PROGR,";
    p_cSql = p_cSql+"PROGR2,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IDPROG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODRAP,";
    p_cSql = p_cSql+"PROGGEN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_saldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROG2,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+"TERNAFILE,";
    p_cSql = p_cSql+"TERNAPROG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeinvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000085(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPODAT,";
    p_cSql = p_cSql+"PROGR,";
    p_cSql = p_cSql+"PROGR2,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IDPROG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODRAP,";
    p_cSql = p_cSql+"PROGGEN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_saldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000087(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROG2,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+"TERNAFILE,";
    p_cSql = p_cSql+"TERNAPROG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeinvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPODAT,";
    p_cSql = p_cSql+"PROGR,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"CODRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"IMP1,";
    p_cSql = p_cSql+"IMP2,";
    p_cSql = p_cSql+"IMP3,";
    p_cSql = p_cSql+"IMP4,";
    p_cSql = p_cSql+"NUM,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PROGGEN,";
    p_cSql = p_cSql+"PROGR2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_saldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000B9(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeinvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPODAT,";
    p_cSql = p_cSql+"PROGR,";
    p_cSql = p_cSql+"PROGR2,";
    p_cSql = p_cSql+"CODRAP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IDPROG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PROGGEN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_saldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D2(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROG2,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"TERNAFILE,";
    p_cSql = p_cSql+"TERNAPROG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeinvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000174(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPODAT,";
    p_cSql = p_cSql+"PROGR,";
    p_cSql = p_cSql+"PROGR2,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"CODRAP,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"IMP1,";
    p_cSql = p_cSql+"IMP2,";
    p_cSql = p_cSql+"IMP3,";
    p_cSql = p_cSql+"IMP4,";
    p_cSql = p_cSql+"NUM,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_saldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000175(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeinvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000017E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPODAT,";
    p_cSql = p_cSql+"PROGR,";
    p_cSql = p_cSql+"PROGR2,";
    p_cSql = p_cSql+"CODRAP,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"IDPROG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_saldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000017F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"PROG1,";
    p_cSql = p_cSql+"PROG2,";
    p_cSql = p_cSql+"PROGREC,";
    p_cSql = p_cSql+"FILEANNO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"TERNAFILE,";
    p_cSql = p_cSql+"TERNAPROG,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeinvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000199(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aesaldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001CE(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aesaldi",true);
    return p_cSql;
  }
}
