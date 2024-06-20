// * --- Area Manuale = BO - Header
// * --- arrt_allinea_sog_ope_opex
import java.io.File; 
import java.util.Date; 
import jxl.*; 
// * --- Fine Area Manuale
public class arrt_allinea_sog_ope_opexR implements CallerWithObjs {
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
  public String m_cPhName_aeopcanc;
  public String m_cServer_aeopcanc;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aeopstor;
  public String m_cServer_aeopstor;
  public String m_cPhName_beneficfrz;
  public String m_cServer_beneficfrz;
  public String m_cPhName_beneficope;
  public String m_cServer_beneficope;
  public String m_cPhName_clientifrz;
  public String m_cServer_clientifrz;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_sogopefbo;
  public String m_cServer_sogopefbo;
  public String m_cPhName_terzistifrz;
  public String m_cServer_terzistifrz;
  public String m_cPhName_terzistiope;
  public String m_cServer_terzistiope;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
  public String m_cPhName_meneficfrz;
  public String m_cServer_meneficfrz;
  public String m_cPhName_meneficope;
  public String m_cServer_meneficope;
  public String m_cPhName_merzistifrz;
  public String m_cServer_merzistifrz;
  public String m_cPhName_merzistiope;
  public String m_cServer_merzistiope;
  public String m_cPhName_mlientifrz;
  public String m_cServer_mlientifrz;
  public String m_cPhName_mlientiope;
  public String m_cServer_mlientiope;
  public String m_cPhName_mogopebo;
  public String m_cServer_mogopebo;
  public String m_cPhName_mogopefbo;
  public String m_cServer_mogopefbo;
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
  public String w_nomefile;
  public String w_tipoall;
  public double w_anno;
  public double righe;
  public String filenome;
  public String cell01;
  public String cell02;
  public String cell03;
  public String cell04;
  public String cell05;
  public double _conta;
  public String cProg;
  public String cCanc;
  public String w_connes;
  public String _prgcanc;
  public String _flagrap2;
  public String _idreg;
  public String cNewProg;
  public String stringaflagrap2;
  public String _colleg;
  public String gPathApp;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_allinea_sog_ope_opex
  public String[] lista;
  public int conteggio;
  public int i;
  public int contanome;
  public int nfogli;
  // * --- Fine Area Manuale
  public arrt_allinea_sog_ope_opexR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_allinea_sog_ope_opex",m_Caller);
    m_cPhName_aeopcanc = p_ContextObject.GetPhName("aeopcanc");
    if (m_cPhName_aeopcanc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopcanc = m_cPhName_aeopcanc+" "+m_Ctx.GetWritePhName("aeopcanc");
    }
    m_cServer_aeopcanc = p_ContextObject.GetServer("aeopcanc");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aeopstor = p_ContextObject.GetPhName("aeopstor");
    if (m_cPhName_aeopstor.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeopstor = m_cPhName_aeopstor+" "+m_Ctx.GetWritePhName("aeopstor");
    }
    m_cServer_aeopstor = p_ContextObject.GetServer("aeopstor");
    m_cPhName_beneficfrz = p_ContextObject.GetPhName("beneficfrz");
    if (m_cPhName_beneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficfrz = m_cPhName_beneficfrz+" "+m_Ctx.GetWritePhName("beneficfrz");
    }
    m_cServer_beneficfrz = p_ContextObject.GetServer("beneficfrz");
    m_cPhName_beneficope = p_ContextObject.GetPhName("beneficope");
    if (m_cPhName_beneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_beneficope = m_cPhName_beneficope+" "+m_Ctx.GetWritePhName("beneficope");
    }
    m_cServer_beneficope = p_ContextObject.GetServer("beneficope");
    m_cPhName_clientifrz = p_ContextObject.GetPhName("clientifrz");
    if (m_cPhName_clientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientifrz = m_cPhName_clientifrz+" "+m_Ctx.GetWritePhName("clientifrz");
    }
    m_cServer_clientifrz = p_ContextObject.GetServer("clientifrz");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_sogopefbo = p_ContextObject.GetPhName("sogopefbo");
    if (m_cPhName_sogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopefbo = m_cPhName_sogopefbo+" "+m_Ctx.GetWritePhName("sogopefbo");
    }
    m_cServer_sogopefbo = p_ContextObject.GetServer("sogopefbo");
    m_cPhName_terzistifrz = p_ContextObject.GetPhName("terzistifrz");
    if (m_cPhName_terzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistifrz = m_cPhName_terzistifrz+" "+m_Ctx.GetWritePhName("terzistifrz");
    }
    m_cServer_terzistifrz = p_ContextObject.GetServer("terzistifrz");
    m_cPhName_terzistiope = p_ContextObject.GetPhName("terzistiope");
    if (m_cPhName_terzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_terzistiope = m_cPhName_terzistiope+" "+m_Ctx.GetWritePhName("terzistiope");
    }
    m_cServer_terzistiope = p_ContextObject.GetServer("terzistiope");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    m_cPhName_meneficfrz = p_ContextObject.GetPhName("meneficfrz");
    if (m_cPhName_meneficfrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficfrz = m_cPhName_meneficfrz+" "+m_Ctx.GetWritePhName("meneficfrz");
    }
    m_cServer_meneficfrz = p_ContextObject.GetServer("meneficfrz");
    m_cPhName_meneficope = p_ContextObject.GetPhName("meneficope");
    if (m_cPhName_meneficope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_meneficope = m_cPhName_meneficope+" "+m_Ctx.GetWritePhName("meneficope");
    }
    m_cServer_meneficope = p_ContextObject.GetServer("meneficope");
    m_cPhName_merzistifrz = p_ContextObject.GetPhName("merzistifrz");
    if (m_cPhName_merzistifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistifrz = m_cPhName_merzistifrz+" "+m_Ctx.GetWritePhName("merzistifrz");
    }
    m_cServer_merzistifrz = p_ContextObject.GetServer("merzistifrz");
    m_cPhName_merzistiope = p_ContextObject.GetPhName("merzistiope");
    if (m_cPhName_merzistiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_merzistiope = m_cPhName_merzistiope+" "+m_Ctx.GetWritePhName("merzistiope");
    }
    m_cServer_merzistiope = p_ContextObject.GetServer("merzistiope");
    m_cPhName_mlientifrz = p_ContextObject.GetPhName("mlientifrz");
    if (m_cPhName_mlientifrz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientifrz = m_cPhName_mlientifrz+" "+m_Ctx.GetWritePhName("mlientifrz");
    }
    m_cServer_mlientifrz = p_ContextObject.GetServer("mlientifrz");
    m_cPhName_mlientiope = p_ContextObject.GetPhName("mlientiope");
    if (m_cPhName_mlientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mlientiope = m_cPhName_mlientiope+" "+m_Ctx.GetWritePhName("mlientiope");
    }
    m_cServer_mlientiope = p_ContextObject.GetServer("mlientiope");
    m_cPhName_mogopebo = p_ContextObject.GetPhName("mogopebo");
    if (m_cPhName_mogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopebo = m_cPhName_mogopebo+" "+m_Ctx.GetWritePhName("mogopebo");
    }
    m_cServer_mogopebo = p_ContextObject.GetServer("mogopebo");
    m_cPhName_mogopefbo = p_ContextObject.GetPhName("mogopefbo");
    if (m_cPhName_mogopefbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_mogopefbo = m_cPhName_mogopefbo+" "+m_Ctx.GetWritePhName("mogopefbo");
    }
    m_cServer_mogopefbo = p_ContextObject.GetServer("mogopefbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("righe",p_cVarName)) {
      return righe;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_allinea_sog_ope_opex";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("tipoall",p_cVarName)) {
      return w_tipoall;
    }
    if (CPLib.eqr("filenome",p_cVarName)) {
      return filenome;
    }
    if (CPLib.eqr("cell01",p_cVarName)) {
      return cell01;
    }
    if (CPLib.eqr("cell02",p_cVarName)) {
      return cell02;
    }
    if (CPLib.eqr("cell03",p_cVarName)) {
      return cell03;
    }
    if (CPLib.eqr("cell04",p_cVarName)) {
      return cell04;
    }
    if (CPLib.eqr("cell05",p_cVarName)) {
      return cell05;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      return cCanc;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      return w_connes;
    }
    if (CPLib.eqr("_prgcanc",p_cVarName)) {
      return _prgcanc;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      return _flagrap2;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      return _idreg;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      return cNewProg;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      return stringaflagrap2;
    }
    if (CPLib.eqr("_colleg",p_cVarName)) {
      return _colleg;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
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
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("righe",p_cVarName)) {
      righe = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("tipoall",p_cVarName)) {
      w_tipoall = value;
      return;
    }
    if (CPLib.eqr("filenome",p_cVarName)) {
      filenome = value;
      return;
    }
    if (CPLib.eqr("cell01",p_cVarName)) {
      cell01 = value;
      return;
    }
    if (CPLib.eqr("cell02",p_cVarName)) {
      cell02 = value;
      return;
    }
    if (CPLib.eqr("cell03",p_cVarName)) {
      cell03 = value;
      return;
    }
    if (CPLib.eqr("cell04",p_cVarName)) {
      cell04 = value;
      return;
    }
    if (CPLib.eqr("cell05",p_cVarName)) {
      cell05 = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("cCanc",p_cVarName)) {
      cCanc = value;
      return;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      w_connes = value;
      return;
    }
    if (CPLib.eqr("_prgcanc",p_cVarName)) {
      _prgcanc = value;
      return;
    }
    if (CPLib.eqr("_flagrap2",p_cVarName)) {
      _flagrap2 = value;
      return;
    }
    if (CPLib.eqr("_idreg",p_cVarName)) {
      _idreg = value;
      return;
    }
    if (CPLib.eqr("cNewProg",p_cVarName)) {
      cNewProg = value;
      return;
    }
    if (CPLib.eqr("stringaflagrap2",p_cVarName)) {
      stringaflagrap2 = value;
      return;
    }
    if (CPLib.eqr("_colleg",p_cVarName)) {
      _colleg = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
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
  void Main() throws Exception {
    /* w_nomefile Char(100) // Nome File */
    /* w_tipoall Char(1) // Tipo */
    /* w_anno Numeric(4, 0) // Anno */
    /* righe Numeric(10, 0) */
    /* filenome Char(100) */
    /* cell01 Char(100) */
    /* cell02 Char(100) */
    /* cell03 Char(100) */
    /* cell04 Char(100) */
    /* cell05 Char(100) */
    /* _conta Numeric(10, 0) */
    /* cProg Char(10) */
    /* cCanc Char(10) */
    /* w_connes Char(16) */
    /* _prgcanc Char(10) */
    /* _flagrap2 Char(1) */
    /* _idreg Char(20) */
    /* cNewProg Char(10) */
    /* stringaflagrap2 Char(9) // stringa di valori di flagrap2 */
    /* _colleg Char(16) */
    /* gPathApp Char(80) // Path Applicazione */
    /* gAzienda Char(10) // Azienda */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry0000001Estatus;
    nTry0000001Estatus = m_Sql.GetTransactionStatus();
    String cTry0000001Emsg;
    cTry0000001Emsg = m_Sql.TransactionErrorMessage();
    try {
      /* Case w_tipoall='S' */
      if (CPLib.eqr(w_tipoall,"S")) {
        /* Exec "Cancella operazioni extraconto per soggetti senza operazioni" Page 2:Page_2 */
        Page_2();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case w_tipoall='D' */
      } else if (CPLib.eqr(w_tipoall,"D")) {
        /* Exec "Cancella Operazioni Extraconto senza soggetti" Page 3:Page_3 */
        Page_3();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case w_tipoall='X' */
      } else if (CPLib.eqr(w_tipoall,"X")) {
        /* Exec "Cambia Intestatario operazione" Page 4:Page_4 */
        Page_4();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
      } // End Case
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
      /* gMsgImp := 'Elaborazione Terminata con successo!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata con successo!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
      /* gMsgImp := 'Elaborazione Terminata con errori!' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata con errori!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Estatus,0)) {
        m_Sql.SetTransactionStatus(nTry0000001Estatus,cTry0000001Emsg);
      }
    }
    /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_allinea_s_ope=null;
    CPResultSet Cursor_aeoprig=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Setta il nome del file */
      /* filenome := LRTrim(gPathApp)+'/appo/'+LRTrim(w_nomefile) */
      filenome = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(w_nomefile);
      // Legge il worksheet
      Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(filenome))); 
      nfogli = workbook.getNumberOfSheets();
      Cell[] row = null;
      NumberCell nc = null;
      for (int foglio = 0 ; foglio < nfogli ; foglio++) {
        Sheet sheet = workbook.getSheet(foglio); 
        righe=0;
      /* gMsgProc := gMsgProc + 'Elaborazione File: '+LRTrim(w_nomefile)+ ' - Foglio N. :'+LRTrim(Str(foglio,5,0)) + NL */
      gMsgProc = gMsgProc+"Elaborazione File: "+CPLib.LRTrim(w_nomefile)+" - Foglio N. :"+CPLib.LRTrim(CPLib.Str(foglio,5,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Legge le righe del foglio
        for (int riga = 2 ; riga < sheet.getRows() ; riga++) {
          row = sheet.getRow(riga);          
          if (row.length > 0 && CPLib.LRTrim(row[0].getContents()) != "" ) {
            cell01=row[0].getContents();
            cell02=row[1].getContents();
            cell03=row[2].getContents();
            righe++;
      /* w_connes := LRTrim(Left(cell01,16)) */
      w_connes = CPLib.LRTrim(CPLib.Left(cell01,16));
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_allinea_s_ope
      SPBridge.HMCaller _h00000030;
      _h00000030 = new SPBridge.HMCaller();
      _h00000030.Set("m_cVQRList",m_cVQRList);
      _h00000030.Set("anno",w_anno);
      _h00000030.Set("connes",w_connes);
      if (Cursor_qbe_allinea_s_ope!=null)
        Cursor_qbe_allinea_s_ope.Close();
      Cursor_qbe_allinea_s_ope = new VQRHolder("qbe_allinea_s_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000030,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_allinea_s_ope.Eof())) {
        /* _conta := _conta + qbe_allinea_s_ope->TOTALE */
        _conta = CPLib.Round(_conta+Cursor_qbe_allinea_s_ope.GetDouble("TOTALE"),0);
        Cursor_qbe_allinea_s_ope.Next();
      }
      m_cConnectivityError = Cursor_qbe_allinea_s_ope.ErrorMessage();
      Cursor_qbe_allinea_s_ope.Close();
      // * --- End Select
      /* If _conta = 0 */
      if (CPLib.eqr(_conta,0)) {
        // * --- Delete from opextrbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"00000033")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_connes,"?",0,0,m_cServer),m_cServer,w_connes)+"";
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
        // * --- Select from aeoprig
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
        Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(cell01))+"  and  ANNOOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,w_anno)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aeoprig.Eof())) {
          /* _prgcanc := '' */
          _prgcanc = "";
          // * --- Read from aeopcanc
          m_cServer = m_Ctx.GetServer("aeopcanc");
          m_cPhName = m_Ctx.GetPhName("aeopcanc");
          m_cSql = "";
          m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("IDBASE"));
          if (m_Ctx.IsSharedTemp("aeopcanc")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _prgcanc = Read_Cursor.GetString("PROGRES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_allinea_sog_ope_opex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _prgcanc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_prgcanc)) */
          if (CPLib.Empty(CPLib.LRTrim(_prgcanc))) {
            /* gMsgProc := gMsgProc + 'Elaboro Soggetto con NDG. '+LRTrim(w_connes)+" - "+LRTrim(cell03) + NL */
            gMsgProc = gMsgProc+"Elaboro Soggetto con NDG. "+CPLib.LRTrim(w_connes)+" - "+CPLib.LRTrim(cell03)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* gMsgImp := 'Elaboro Soggetto con NDG. '+LRTrim(w_connes)+" - "+LRTrim(cell03) // Messaggio Import */
            gMsgImp = "Elaboro Soggetto con NDG. "+CPLib.LRTrim(w_connes)+" - "+CPLib.LRTrim(cell03);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aeopstor from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeopstor");
            m_cPhName = m_Ctx.GetPhName("aeopstor");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopstor",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"0000003B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000003B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopstor",true);
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
            /* cCanc := Utilities.GetAutonumber("PDELAGE\'"+LRTrim(gAzienda)+"'",'',10) */
            cCanc = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PDELAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aeopcanc from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeopcanc");
            m_cPhName = m_Ctx.GetPhName("aeopcanc");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopcanc",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"0000003D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000003D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCanc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("OLDINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopcanc",true);
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
          Cursor_aeoprig.Next();
        }
        m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
        Cursor_aeoprig.Close();
        // * --- End Select
      } // End If
      //
          }
        }
      /* gMsgProc := gMsgProc + 'Righe Elaborate: '+LRTrim(Str(righe,6,0)) + NL */
      gMsgProc = gMsgProc+"Righe Elaborate: "+CPLib.LRTrim(CPLib.Str(righe,6,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      //
      }
    } finally {
      try {
        if (Cursor_qbe_allinea_s_ope!=null)
          Cursor_qbe_allinea_s_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
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
  void Page_3() throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_aeoprig=null;
    try {
      /* Setta il nome del file */
      /* filenome := LRTrim(gPathApp)+'/appo/'+LRTrim(w_nomefile) */
      filenome = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(w_nomefile);
      // Legge il worksheet
      Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(filenome))); 
      nfogli = workbook.getNumberOfSheets();
      Cell[] row = null;
      NumberCell nc = null;
      for (int foglio = 0 ; foglio < nfogli ; foglio++) {
        Sheet sheet = workbook.getSheet(foglio); 
        righe=0;
      /* gMsgProc := gMsgProc + 'Elaborazione File: '+LRTrim(w_nomefile)+ ' - Foglio N. :'+LRTrim(Str(foglio,5,0)) + NL */
      gMsgProc = gMsgProc+"Elaborazione File: "+CPLib.LRTrim(w_nomefile)+" - Foglio N. :"+CPLib.LRTrim(CPLib.Str(foglio,5,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Legge le righe del foglio
        for (int riga = 2 ; riga < sheet.getRows() ; riga++) {
          row = sheet.getRow(riga);          
          if (row.length > 0 && CPLib.LRTrim(row[0].getContents()) != "" ) {
            cell01=row[0].getContents();
            cell02=row[1].getContents();
            cell03=row[2].getContents();
            righe++;
      /* w_connes := LRTrim(Left(cell01,16)) */
      w_connes = CPLib.LRTrim(CPLib.Left(cell01,16));
      /* _colleg := '' */
      _colleg = "";
      // * --- Read from personbo
      m_cServer = m_Ctx.GetServer("personbo");
      m_cPhName = m_Ctx.GetPhName("personbo");
      m_cSql = "";
      m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_connes,"C",16,0,m_cServer),m_cServer,w_connes);
      if (m_Ctx.IsSharedTemp("personbo")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _colleg = Read_Cursor.GetString("CONNES");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on personbo into routine arrt_allinea_sog_ope_opex returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _colleg = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      /* If Empty(LRTrim(_colleg)) */
      if (CPLib.Empty(CPLib.LRTrim(_colleg))) {
        /* gMsgProc := gMsgProc + 'Elaboro Soggetto con NDG. '+LRTrim(w_connes)+NL */
        gMsgProc = gMsgProc+"Elaboro Soggetto con NDG. "+CPLib.LRTrim(w_connes)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaboro Soggetto con NDG. '+LRTrim(w_connes) // Messaggio Import */
        gMsgImp = "Elaboro Soggetto con NDG. "+CPLib.LRTrim(w_connes);
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Delete from opextrbo
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("opextrbo");
        m_cPhName = m_Ctx.GetPhName("opextrbo");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"0000004D")+"delete from "+m_oWrInfo.GetTableWriteName();
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_connes,"?",0,0,m_cServer),m_cServer,w_connes)+"";
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
        // * --- Select from aeoprig
        m_cServer = m_Ctx.GetServer("aeoprig");
        m_cPhName = m_Ctx.GetPhName("aeoprig");
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
        Cursor_aeoprig = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(cell01),"?",0,0,m_cServer, m_oParameters),m_cServer,CPLib.LRTrim(cell01))+"  and  ANNOOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,w_anno)+" "+")"+(m_Ctx.IsSharedTemp("aeoprig")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_aeoprig.Eof())) {
          /* _prgcanc := '' */
          _prgcanc = "";
          // * --- Read from aeopcanc
          m_cServer = m_Ctx.GetServer("aeopcanc");
          m_cPhName = m_Ctx.GetPhName("aeopcanc");
          m_cSql = "";
          m_cSql = m_cSql+"IDBASE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"C",10,0,m_cServer),m_cServer,Cursor_aeoprig.GetString("IDBASE"));
          if (m_Ctx.IsSharedTemp("aeopcanc")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("PROGRES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _prgcanc = Read_Cursor.GetString("PROGRES");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on aeopcanc into routine arrt_allinea_sog_ope_opex returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _prgcanc = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(_prgcanc)) */
          if (CPLib.Empty(CPLib.LRTrim(_prgcanc))) {
            /* cProg := Utilities.GetAutonumber("PSTOAGE\'"+LRTrim(gAzienda)+"'",'',10) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aeopstor from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeopstor");
            m_cPhName = m_Ctx.GetPhName("aeopstor");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopstor",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"00000053")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000053(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopstor",true);
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
            /* cCanc := Utilities.GetAutonumber("PDELAGE\'"+LRTrim(gAzienda)+"'",'',10) */
            cCanc = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PDELAGE\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aeopcanc from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aeopcanc");
            m_cPhName = m_Ctx.GetPhName("aeopcanc");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeopcanc",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"00000055")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000055(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("ADATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("AFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("APROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("ASPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATA"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDate("CDATARET"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("COLDFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CONNESINT"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("CPROG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetDouble("CSPEDITO"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("IDRIF"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("NOCODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cCanc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("C","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_aeoprig.GetString("OLDINTER"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aeopcanc",true);
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
          Cursor_aeoprig.Next();
        }
        m_cConnectivityError = Cursor_aeoprig.ErrorMessage();
        Cursor_aeoprig.Close();
        // * --- End Select
      } // End If
      //
          }
        }
      /* gMsgProc := gMsgProc + 'Righe Elaborate: '+LRTrim(Str(righe,6,0)) + NL */
      gMsgProc = gMsgProc+"Righe Elaborate: "+CPLib.LRTrim(CPLib.Str(righe,6,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      //
      }
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_aeoprig!=null)
          Cursor_aeoprig.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_operazbo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_clientiope=null;
    CPResultSet Cursor_beneficope=null;
    CPResultSet Cursor_terzistiope=null;
    CPResultSet Cursor_fraziobo=null;
    CPResultSet Cursor_sogopefbo=null;
    CPResultSet Cursor_clientifrz=null;
    CPResultSet Cursor_beneficfrz=null;
    CPResultSet Cursor_terzistifrz=null;
    try {
      /* Setta il nome del file */
      /* filenome := LRTrim(gPathApp)+'/appo/'+LRTrim(w_nomefile) */
      filenome = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(w_nomefile);
      // Legge il worksheet
      Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(filenome))); 
      nfogli = workbook.getNumberOfSheets();
      Cell[] row = null;
      NumberCell nc = null;
      for (int foglio = 0 ; foglio < nfogli ; foglio++) {
        Sheet sheet = workbook.getSheet(foglio); 
        righe=0;
      /* gMsgProc := gMsgProc + 'Elaborazione File: '+LRTrim(w_nomefile)+ ' - Foglio N. :'+LRTrim(Str(foglio,5,0)) + NL */
      gMsgProc = gMsgProc+"Elaborazione File: "+CPLib.LRTrim(w_nomefile)+" - Foglio N. :"+CPLib.LRTrim(CPLib.Str(foglio,5,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Legge le righe del foglio
        for (int riga = 2 ; riga < sheet.getRows() ; riga++) {
          row = sheet.getRow(riga);          
          if (row.length > 0 && CPLib.LRTrim(row[0].getContents()) != "" ) {
            cell01=row[0].getContents();
            cell02=row[1].getContents();
            cell03=row[4].getContents();
            cell04=row[5].getContents();
            righe++;
      /* If (LRTrim(cell01) <> LRTrim(cell03)) and (LRTrim(cell02)=LRTrim(cell04)) */
      if ((CPLib.ne(CPLib.LRTrim(cell01),CPLib.LRTrim(cell03))) && (CPLib.eqr(CPLib.LRTrim(cell02),CPLib.LRTrim(cell04)))) {
        /* w_connes := LRTrim(Left(cell01,16)) */
        w_connes = CPLib.LRTrim(CPLib.Left(cell01,16));
        /* gMsgProc := gMsgProc + 'Elaboro Soggetto con NDG. '+LRTrim(w_connes)+NL */
        gMsgProc = gMsgProc+"Elaboro Soggetto con NDG. "+CPLib.LRTrim(w_connes)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* stringaflagrap2 := 'ABCDEFGHI' // stringa di valori di flagrap2 */
        stringaflagrap2 = "ABCDEFGHI";
        // * --- Select from operazbo
        m_cServer = m_Ctx.GetServer("operazbo");
        m_cPhName = m_Ctx.GetPhName("operazbo");
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
        Cursor_operazbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,w_connes)+"  and  ANNOOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,w_anno)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("operazbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_operazbo.Eof())) {
          /* cNewProg := Utilities.GetAutonumber("POPERAZ1\'"+LRTrim(gAzienda)+"'",Space(10),10) */
          cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("POPERAZ1\\'"+CPLib.LRTrim(gAzienda)+"'",CPLib.Space(10),10);
          /* gMsgImp := 'Elaboro Operazione con Codice. '+operazbo->NUMPROG // Messaggio Import */
          gMsgImp = "Elaboro Operazione con Codice. "+Cursor_operazbo.GetString("NUMPROG");
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _flagrap2 := iif(Empty(operazbo->FLAGRAP2) or operazbo->FLAGRAP2='S',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(operazbo->FLAGRAP2,stringaflagrap2)+1),1)) */
          _flagrap2 = (CPLib.Empty(Cursor_operazbo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_operazbo.GetString("FLAGRAP2"),"S")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_operazbo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
          /* _idreg := DateToChar(operazbo->DATAOPE)+operazbo->NUMPROG+_flagrap2 */
          _idreg = CPLib.DateToChar(Cursor_operazbo.GetDate("DATAOPE"))+Cursor_operazbo.GetString("NUMPROG")+_flagrap2;
          // * --- Insert into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"00000068")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000068(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AMMONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("DURAT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("PRGIMPOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_operazbo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"operazbo",true);
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
          // * --- Select from sogopebo
          m_cServer = m_Ctx.GetServer("sogopebo");
          m_cPhName = m_Ctx.GetPhName("sogopebo");
          if (Cursor_sogopebo!=null)
            Cursor_sogopebo.Close();
          Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopebo.Eof())) {
            // * --- Insert into mogopebo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("mogopebo");
            m_cPhName = m_Ctx.GetPhName("mogopebo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mogopebo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"0000006A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000006A(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopebo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mogopebo",true);
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
            Cursor_sogopebo.Next();
          }
          m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
          Cursor_sogopebo.Close();
          // * --- End Select
          // * --- Select from clientiope
          m_cServer = m_Ctx.GetServer("clientiope");
          m_cPhName = m_Ctx.GetPhName("clientiope");
          if (Cursor_clientiope!=null)
            Cursor_clientiope.Close();
          Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientiope.Eof())) {
            // * --- Insert into mlientiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("mlientiope");
            m_cPhName = m_Ctx.GetPhName("mlientiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mlientiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"0000006C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000006C(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mlientiope",true);
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
            Cursor_clientiope.Next();
          }
          m_cConnectivityError = Cursor_clientiope.ErrorMessage();
          Cursor_clientiope.Close();
          // * --- End Select
          // * --- Select from beneficope
          m_cServer = m_Ctx.GetServer("beneficope");
          m_cPhName = m_Ctx.GetPhName("beneficope");
          if (Cursor_beneficope!=null)
            Cursor_beneficope.Close();
          Cursor_beneficope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficope.Eof())) {
            // * --- Insert into meneficope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("meneficope");
            m_cPhName = m_Ctx.GetPhName("meneficope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"meneficope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"0000006E")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000006E(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficope.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"meneficope",true);
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
            Cursor_beneficope.Next();
          }
          m_cConnectivityError = Cursor_beneficope.ErrorMessage();
          Cursor_beneficope.Close();
          // * --- End Select
          // * --- Select from terzistiope
          m_cServer = m_Ctx.GetServer("terzistiope");
          m_cPhName = m_Ctx.GetPhName("terzistiope");
          if (Cursor_terzistiope!=null)
            Cursor_terzistiope.Close();
          Cursor_terzistiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistiope.Eof())) {
            // * --- Insert into merzistiope from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("merzistiope");
            m_cPhName = m_Ctx.GetPhName("merzistiope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"merzistiope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"00000070")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000070(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistiope.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"merzistiope",true);
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
            Cursor_terzistiope.Next();
          }
          m_cConnectivityError = Cursor_terzistiope.ErrorMessage();
          Cursor_terzistiope.Close();
          // * --- End Select
          // * --- Write into operazbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("operazbo");
          m_cPhName = m_Ctx.GetPhName("operazbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"operazbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"00000071")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(_idreg,"C",20,0,m_cServer)+", ";
          m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(CPLib.LRTrim(cell03),"C",16,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"operazbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_operazbo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_operazbo.GetString("IDBASE"))+"";
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
          Cursor_operazbo.Next();
        }
        m_cConnectivityError = Cursor_operazbo.ErrorMessage();
        Cursor_operazbo.Close();
        // * --- End Select
        /* stringaflagrap2 := 'JLMNOTUV?' // stringa di valori di flagrap2 */
        stringaflagrap2 = "JLMNOTUV?";
        // * --- Select from fraziobo
        m_cServer = m_Ctx.GetServer("fraziobo");
        m_cPhName = m_Ctx.GetPhName("fraziobo");
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
        Cursor_fraziobo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,w_connes)+"  and  ANNOOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_anno,"?",0,0,m_cServer, m_oParameters),m_cServer,w_anno)+"  and  (STATOREG='0'  or  STATOREG='1') "+")"+(m_Ctx.IsSharedTemp("fraziobo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_fraziobo.Eof())) {
          /* cNewProg := Utilities.GetAutonumber("PFRAZIO1\'"+LRTrim(gAzienda)+"'",'',10) */
          cNewProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PFRAZIO1\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          /* _flagrap2 := iif(Empty(fraziobo->FLAGRAP2) or fraziobo->FLAGRAP2='Z',Left(stringaflagrap2,1),Substr(stringaflagrap2,(At(fraziobo->FLAGRAP2,stringaflagrap2)+1),1)) */
          _flagrap2 = (CPLib.Empty(Cursor_fraziobo.GetString("FLAGRAP2")) || CPLib.eqr(Cursor_fraziobo.GetString("FLAGRAP2"),"Z")?CPLib.Left(stringaflagrap2,1):CPLib.Substr(stringaflagrap2,(CPLib.At(Cursor_fraziobo.GetString("FLAGRAP2"),stringaflagrap2)+1),1));
          /* _idreg := DateToChar(fraziobo->DATAOPE)+fraziobo->NUMPROG+_flagrap2 */
          _idreg = CPLib.DateToChar(Cursor_fraziobo.GetDate("DATAOPE"))+Cursor_fraziobo.GetString("NUMPROG")+_flagrap2;
          // * --- Insert into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"00000077")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000077(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("AUTOM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("CAMBIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATAOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATOPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODANA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODCAB2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CODVOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("COLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESCLI"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESOPER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAOPE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAREG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESC2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DESCINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGCONT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGFRAZ"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGLIRE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("FLAGRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_flagrap2,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("idcauana"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MODSVOL"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NATURA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("NOPROT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("NUMPROG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERATORE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPERAZMOD"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("OPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("PRGIMPFRZ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROV2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAGIO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTBEN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RAREA"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RCOMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RESPINS"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RFREQ"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RRAGIO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("RTIPO"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SCOPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("SEGNO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINF"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINT2"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("TIPOOPRAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTCONT"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("TOTLIRE"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("UNIQUECODE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("VALUTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("ZCPARTE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNALTRO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CONNESDOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_STA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_IND"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDate("DATAIMP"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("PAGASOGOP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("MTCN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("CDATREG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetString("IPCOLLEG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDateTime("ORACOLLEG"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_fraziobo.GetDouble("DUCOLLEG"),"?",0,0)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"fraziobo",true);
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
          // * --- Select from sogopefbo
          m_cServer = m_Ctx.GetServer("sogopefbo");
          m_cPhName = m_Ctx.GetPhName("sogopefbo");
          if (Cursor_sogopefbo!=null)
            Cursor_sogopefbo.Close();
          Cursor_sogopefbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopefbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_sogopefbo.Eof())) {
            // * --- Insert into mogopefbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("mogopefbo");
            m_cPhName = m_Ctx.GetPhName("mogopefbo");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mogopefbo",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"00000079")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000079(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_sogopefbo.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mogopefbo",true);
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
            Cursor_sogopefbo.Next();
          }
          m_cConnectivityError = Cursor_sogopefbo.ErrorMessage();
          Cursor_sogopefbo.Close();
          // * --- End Select
          // * --- Select from clientifrz
          m_cServer = m_Ctx.GetServer("clientifrz");
          m_cPhName = m_Ctx.GetPhName("clientifrz");
          if (Cursor_clientifrz!=null)
            Cursor_clientifrz.Close();
          Cursor_clientifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_clientifrz.Eof())) {
            // * --- Insert into mlientifrz from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("mlientifrz");
            m_cPhName = m_Ctx.GetPhName("mlientifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"mlientifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"0000007B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000007B(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_clientifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"mlientifrz",true);
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
            Cursor_clientifrz.Next();
          }
          m_cConnectivityError = Cursor_clientifrz.ErrorMessage();
          Cursor_clientifrz.Close();
          // * --- End Select
          // * --- Select from beneficfrz
          m_cServer = m_Ctx.GetServer("beneficfrz");
          m_cPhName = m_Ctx.GetPhName("beneficfrz");
          if (Cursor_beneficfrz!=null)
            Cursor_beneficfrz.Close();
          Cursor_beneficfrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("beneficfrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_beneficfrz.Eof())) {
            // * --- Insert into meneficfrz from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("meneficfrz");
            m_cPhName = m_Ctx.GetPhName("meneficfrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"meneficfrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"0000007D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000007D(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetDouble("CPROWNUM"),"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_STA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CTA"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAB"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_PRV"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_IND"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_CAP"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_beneficfrz.GetString("C_RAPPORTO"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"meneficfrz",true);
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
            Cursor_beneficfrz.Next();
          }
          m_cConnectivityError = Cursor_beneficfrz.ErrorMessage();
          Cursor_beneficfrz.Close();
          // * --- End Select
          // * --- Select from terzistifrz
          m_cServer = m_Ctx.GetServer("terzistifrz");
          m_cPhName = m_Ctx.GetPhName("terzistifrz");
          if (Cursor_terzistifrz!=null)
            Cursor_terzistifrz.Close();
          Cursor_terzistifrz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("terzistifrz")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_terzistifrz.Eof())) {
            // * --- Insert into merzistifrz from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("merzistifrz");
            m_cPhName = m_Ctx.GetPhName("merzistifrz");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"merzistifrz",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"0000007F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_0000007F(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cNewProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("CODSOG"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("TIPOFILE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("NUMCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("LEGAME"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("RAPCOL"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("UCODE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_terzistifrz.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_idreg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"merzistifrz",true);
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
            Cursor_terzistifrz.Next();
          }
          m_cConnectivityError = Cursor_terzistifrz.ErrorMessage();
          Cursor_terzistifrz.Close();
          // * --- End Select
          // * --- Write into fraziobo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("fraziobo");
          m_cPhName = m_Ctx.GetPhName("fraziobo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"fraziobo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_allinea_sog_ope_opex",16,"00000080")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"OPERAZMOD = "+CPLib.ToSQL(_idreg,"C",20,0,m_cServer)+", ";
          m_cSql = m_cSql+"FLAGRAP2 = "+CPLib.ToSQL(_flagrap2,"C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"STATOREG = "+CPLib.ToSQL("1","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CONNESCLI = "+CPLib.ToSQL(CPLib.LRTrim(cell03),"C",16,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"fraziobo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_fraziobo.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_fraziobo.GetString("IDBASE"))+"";
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
          Cursor_fraziobo.Next();
        }
        m_cConnectivityError = Cursor_fraziobo.ErrorMessage();
        Cursor_fraziobo.Close();
        // * --- End Select
      } // End If
      //
          }
        }
      /* gMsgProc := gMsgProc + 'Righe Elaborate: '+LRTrim(Str(righe,6,0)) + NL */
      gMsgProc = gMsgProc+"Righe Elaborate: "+CPLib.LRTrim(CPLib.Str(righe,6,0))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      //
      }
    } finally {
      try {
        if (Cursor_operazbo!=null)
          Cursor_operazbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficope!=null)
          Cursor_beneficope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistiope!=null)
          Cursor_terzistiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_fraziobo!=null)
          Cursor_fraziobo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_sogopefbo!=null)
          Cursor_sogopefbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientifrz!=null)
          Cursor_clientifrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_beneficfrz!=null)
          Cursor_beneficfrz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_terzistifrz!=null)
          Cursor_terzistifrz.Close();
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
          Main();
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
      m_Caller.SetString("nomefile","C",100,0,w_nomefile);
      m_Caller.SetString("tipoall","C",1,0,w_tipoall);
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_allinea_sog_ope_opexR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_allinea_sog_ope_opexR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_nomefile = m_Caller.GetString("nomefile","C",100,0);
    w_tipoall = m_Caller.GetString("tipoall","C",1,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    righe = 0;
    filenome = CPLib.Space(100);
    cell01 = CPLib.Space(100);
    cell02 = CPLib.Space(100);
    cell03 = CPLib.Space(100);
    cell04 = CPLib.Space(100);
    cell05 = CPLib.Space(100);
    _conta = 0;
    cProg = CPLib.Space(10);
    cCanc = CPLib.Space(10);
    w_connes = CPLib.Space(16);
    _prgcanc = CPLib.Space(10);
    _flagrap2 = CPLib.Space(1);
    _idreg = CPLib.Space(20);
    cNewProg = CPLib.Space(10);
    stringaflagrap2 = CPLib.Space(9);
    _colleg = CPLib.Space(16);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_allinea_s_ope,
  public static final String m_cVQRList = ",qbe_allinea_s_ope,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000003B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopstor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000003D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"DATARIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFSTOR,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPOCAN,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopcanc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000053(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopstor",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000055(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ADATA,";
    p_cSql = p_cSql+"ADATARET,";
    p_cSql = p_cSql+"AFILE,";
    p_cSql = p_cSql+"APROG,";
    p_cSql = p_cSql+"ASPEDITO,";
    p_cSql = p_cSql+"CDATA,";
    p_cSql = p_cSql+"CDATARET,";
    p_cSql = p_cSql+"CFILE,";
    p_cSql = p_cSql+"COLDPROG,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"COLDFILE,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"CPROG,";
    p_cSql = p_cSql+"CSPEDITO,";
    p_cSql = p_cSql+"DATARIF,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"NOCODFISC,";
    p_cSql = p_cSql+"PROGRES,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RIFSTOR,";
    p_cSql = p_cSql+"TIPOAG,";
    p_cSql = p_cSql+"TIPOCAN,";
    p_cSql = p_cSql+"OLDINTER,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aeopcanc",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000068(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AMMONT,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+"DURAT,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"PRGIMPOPE,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"operazbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mogopebo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mlientiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006E(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"meneficope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000070(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"merzistiope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000077(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"AUTOM,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CDATAOPE,";
    p_cSql = p_cSql+"CDATOPE,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCAB2,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODINT2,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"CONNESOPER,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARETT,";
    p_cSql = p_cSql+"DESC2,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCINTER,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"FLAGRAP,";
    p_cSql = p_cSql+"FLAGRAP2,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"idcauana,";
    p_cSql = p_cSql+"IDEREG,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+"MODSVOL,";
    p_cSql = p_cSql+"NATURA,";
    p_cSql = p_cSql+"NOPROT,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"OPERAG,";
    p_cSql = p_cSql+"OPERATORE,";
    p_cSql = p_cSql+"OPERAZMOD,";
    p_cSql = p_cSql+"OPRAP,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PRGIMPFRZ,";
    p_cSql = p_cSql+"PROV2,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"RAGIO,";
    p_cSql = p_cSql+"RAPPORTBEN,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RESPINS,";
    p_cSql = p_cSql+"RFREQ,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"RIMP,";
    p_cSql = p_cSql+"RRAGIO,";
    p_cSql = p_cSql+"RTIPO,";
    p_cSql = p_cSql+"SCOPO,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINF,";
    p_cSql = p_cSql+"TIPOINT2,";
    p_cSql = p_cSql+"TIPOINTER,";
    p_cSql = p_cSql+"TIPOLEG,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"UNIQUECODE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"ZCPARTE,";
    p_cSql = p_cSql+"CONNALTRO,";
    p_cSql = p_cSql+"CONNESDOC,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"DATAIMP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"PAGASOGOP,";
    p_cSql = p_cSql+"MTCN,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"CDATREG,";
    p_cSql = p_cSql+"IPCOLLEG,";
    p_cSql = p_cSql+"ORACOLLEG,";
    p_cSql = p_cSql+"DUCOLLEG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"fraziobo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000079(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mogopefbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"mlientifrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_RAPPORTO,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"meneficfrz",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"TIPOFILE,";
    p_cSql = p_cSql+"NUMCOL,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"RAPCOL,";
    p_cSql = p_cSql+"UCODE,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"IDREG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"merzistifrz",true);
    return p_cSql;
  }
}
