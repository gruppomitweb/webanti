// * --- Area Manuale = BO - Header
// * --- arfn_estrai_sv_all
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
// * --- Fine Area Manuale
public class arfn_estrai_sv_allR implements CallerWithObjs {
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
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
  public String m_cPhName_cgo_stampeav;
  public String m_cServer_cgo_stampeav;
  public String m_cPhName_analisi_sv;
  public String m_cServer_analisi_sv;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_wersonbo_agg;
  public String m_cServer_wersonbo_agg;
  public String m_cPhName_tbstatisv;
  public String m_cServer_tbstatisv;
  public String m_cPhName_tbstatna;
  public String m_cServer_tbstatna;
  public String m_cPhName_rapopebo;
  public String m_cServer_rapopebo;
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
  public double pAnno;
  public double pTri;
  public String pSegno;
  public String pLCC;
  public String pTipoBase3;
  public String pFraudo;
  public String _datini;
  public String _datfin;
  public String _datinisem;
  public String _datfinsem;
  public String cRitorno;
  public String fhand;
  public String riga;
  public String nFile;
  public double conta;
  public String cNomeFileZip;
  public String cNomeZip;
  public String fname;
  public String pfname;
  public double _importo;
  public double _importodef;
  public MemoryCursor_qbe_estrai_sv_all_ip_1_vqr mcB3_SaldiTesoreria;
  public MemoryCursor_mcestraisv_clienti_mcrdef mcB3_Clienti;
  public MemoryCursorRow_mcestraisv_clienti_mcrdef rowB3_Clienti;
  public MemoryCursor_qbe_sv_idp_rapporti_vqr mcRapporti;
  public String provincia;
  public String str_appo;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public String cProg;
  public String gAzienda;
  public String gIntemediario;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  public String gPathDoc;
  public String gCodDip;
  public double _cntOpe;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_estrai_sv_all
  String[] filenames; //path+nomefile+estenzione
  String[] onlyfilenames; //nomefile
  public char delimitatore=';';
  // * --- Fine Area Manuale
  public arfn_estrai_sv_allR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_estrai_sv_all",m_Caller);
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
    m_cPhName_cgo_stampeav = p_ContextObject.GetPhName("cgo_stampeav");
    if (m_cPhName_cgo_stampeav.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_stampeav = m_cPhName_cgo_stampeav+" "+m_Ctx.GetWritePhName("cgo_stampeav");
    }
    m_cServer_cgo_stampeav = p_ContextObject.GetServer("cgo_stampeav");
    m_cPhName_analisi_sv = p_ContextObject.GetPhName("analisi_sv");
    if (m_cPhName_analisi_sv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_analisi_sv = m_cPhName_analisi_sv+" "+m_Ctx.GetWritePhName("analisi_sv");
    }
    m_cServer_analisi_sv = p_ContextObject.GetServer("analisi_sv");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_wersonbo_agg = p_ContextObject.GetPhName("wersonbo_agg");
    if (m_cPhName_wersonbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo_agg = m_cPhName_wersonbo_agg+" "+m_Ctx.GetWritePhName("wersonbo_agg");
    }
    m_cServer_wersonbo_agg = p_ContextObject.GetServer("wersonbo_agg");
    m_cPhName_tbstatisv = p_ContextObject.GetPhName("tbstatisv");
    if (m_cPhName_tbstatisv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstatisv = m_cPhName_tbstatisv+" "+m_Ctx.GetWritePhName("tbstatisv");
    }
    m_cServer_tbstatisv = p_ContextObject.GetServer("tbstatisv");
    m_cPhName_tbstatna = p_ContextObject.GetPhName("tbstatna");
    if (m_cPhName_tbstatna.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstatna = m_cPhName_tbstatna+" "+m_Ctx.GetWritePhName("tbstatna");
    }
    m_cServer_tbstatna = p_ContextObject.GetServer("tbstatna");
    m_cPhName_rapopebo = p_ContextObject.GetPhName("rapopebo");
    if (m_cPhName_rapopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_rapopebo = m_cPhName_rapopebo+" "+m_Ctx.GetWritePhName("rapopebo");
    }
    m_cServer_rapopebo = p_ContextObject.GetServer("rapopebo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      return pTri;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      return _importo;
    }
    if (CPLib.eqr("_importodef",p_cVarName)) {
      return _importodef;
    }
    if (CPLib.eqr("_cntOpe",p_cVarName)) {
      return _cntOpe;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_estrai_sv_all";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pSegno",p_cVarName)) {
      return pSegno;
    }
    if (CPLib.eqr("pLCC",p_cVarName)) {
      return pLCC;
    }
    if (CPLib.eqr("pTipoBase3",p_cVarName)) {
      return pTipoBase3;
    }
    if (CPLib.eqr("pFraudo",p_cVarName)) {
      return pFraudo;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("_datinisem",p_cVarName)) {
      return _datinisem;
    }
    if (CPLib.eqr("_datfinsem",p_cVarName)) {
      return _datfinsem;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("nFile",p_cVarName)) {
      return nFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("cNomeZip",p_cVarName)) {
      return cNomeZip;
    }
    if (CPLib.eqr("fname",p_cVarName)) {
      return fname;
    }
    if (CPLib.eqr("pfname",p_cVarName)) {
      return pfname;
    }
    if (CPLib.eqr("provincia",p_cVarName)) {
      return provincia;
    }
    if (CPLib.eqr("str_appo",p_cVarName)) {
      return str_appo;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      return _ddatini;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      return _ddatfin;
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
    if (CPLib.eqr("mcB3_SaldiTesoreria",p_cVarName)) {
      return mcB3_SaldiTesoreria;
    }
    if (CPLib.eqr("mcB3_Clienti",p_cVarName)) {
      return mcB3_Clienti;
    }
    if (CPLib.eqr("mcRapporti",p_cVarName)) {
      return mcRapporti;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowB3_Clienti",p_cVarName)) {
      return rowB3_Clienti;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      pTri = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
      return;
    }
    if (CPLib.eqr("_importodef",p_cVarName)) {
      _importodef = value;
      return;
    }
    if (CPLib.eqr("_cntOpe",p_cVarName)) {
      _cntOpe = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pSegno",p_cVarName)) {
      pSegno = value;
      return;
    }
    if (CPLib.eqr("pLCC",p_cVarName)) {
      pLCC = value;
      return;
    }
    if (CPLib.eqr("pTipoBase3",p_cVarName)) {
      pTipoBase3 = value;
      return;
    }
    if (CPLib.eqr("pFraudo",p_cVarName)) {
      pFraudo = value;
      return;
    }
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("_datinisem",p_cVarName)) {
      _datinisem = value;
      return;
    }
    if (CPLib.eqr("_datfinsem",p_cVarName)) {
      _datfinsem = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
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
    if (CPLib.eqr("nFile",p_cVarName)) {
      nFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("cNomeZip",p_cVarName)) {
      cNomeZip = value;
      return;
    }
    if (CPLib.eqr("fname",p_cVarName)) {
      fname = value;
      return;
    }
    if (CPLib.eqr("pfname",p_cVarName)) {
      pfname = value;
      return;
    }
    if (CPLib.eqr("provincia",p_cVarName)) {
      provincia = value;
      return;
    }
    if (CPLib.eqr("str_appo",p_cVarName)) {
      str_appo = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      _ddatini = value;
      return;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      _ddatfin = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowB3_Clienti",p_cVarName)) {
      rowB3_Clienti = (MemoryCursorRow_mcestraisv_clienti_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcB3_SaldiTesoreria",p_cVarName)) {
      mcB3_SaldiTesoreria = (MemoryCursor_qbe_estrai_sv_all_ip_1_vqr)value;
      return;
    }
    if (CPLib.eqr("mcB3_Clienti",p_cVarName)) {
      mcB3_Clienti = (MemoryCursor_mcestraisv_clienti_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcRapporti",p_cVarName)) {
      mcRapporti = (MemoryCursor_qbe_sv_idp_rapporti_vqr)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* pAnno Numeric(4, 0) // Anno di riferimento */
    /* pTri Numeric(1, 0) // Trimestre */
    /* pSegno Char(1) // Gestione Segno */
    /* pLCC Char(1) // Gestione LCC */
    /* pTipoBase3 Char(4) // Tipo di Base 3 (B3IP o B3MT) */
    /* pFraudo Char(1) // Estrai solo fraudolente */
    /* _datini Char(8) // Data Inizio Trimestre */
    /* _datfin Char(8) // Data Fine Trimestre */
    /* _datinisem Char(8) // Data Inizio Semestre */
    /* _datfinsem Char(8) // Data Fine Semestre */
    /* cRitorno Char(20) */
    /* fhand Char(1) // Per gestione file */
    /* riga Memo */
    /* nFile Char(20) */
    /* conta Numeric(10, 0) */
    /* cNomeFileZip Char(30) */
    /* cNomeZip Char(128) */
    /* fname Char(25) */
    /* pfname Char(128) */
    /* _importo Numeric(18, 2) // Importo da DB */
    /* _importodef Numeric(18, 0) // Importo arrotondato senza decimali */
    /* mcB3_SaldiTesoreria MemoryCursor(qbe_estrai_sv_all_ip_1.vqr) // File 1 delle SV per IP (SaldiTesoreria.txt) */
    /* mcB3_Clienti MemoryCursor(mcEstraiSV_clienti.MCRDef) // File 3 delle SV per IP (Clienti.txt) */
    /* rowB3_Clienti Row(mcEstraiSV_clienti.MCRDef) */
    /* mcRapporti MemoryCursor(qbe_sv_idp_rapporti.vqr) // File 1 delle SV per IP (SaldiTesoreria.txt) */
    /* provincia Char(2) */
    /* str_appo Char(0) */
    /* _ddatini Date */
    /* _ddatfin Date */
    /* cProg Char(10) */
    /* gAzienda Char(10) // Azienda */
    /* gIntemediario Char(11) // Intermediario */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Char(120) // Messaggio */
    /* gPathApp Char(80) // Path Applicazione */
    /* gPathDoc Char(80) // Path Applicazione */
    /* gCodDip Char(6) // Dipendenza */
    /* Case pTri=1 */
    if (CPLib.eqr(pTri,1)) {
      /* _datini := Str(pAnno,4,0)+'0101' // Data Inizio Trimestre */
      _datini = CPLib.Str(pAnno,4,0)+"0101";
      /* _datfin := Str(pAnno,4,0)+'0331' // Data Fine Trimestre */
      _datfin = CPLib.Str(pAnno,4,0)+"0331";
      /* Case pTri=2 */
    } else if (CPLib.eqr(pTri,2)) {
      /* _datini := Str(pAnno,4,0)+'0401' // Data Inizio Trimestre */
      _datini = CPLib.Str(pAnno,4,0)+"0401";
      /* _datfin := Str(pAnno,4,0)+'0630' // Data Fine Trimestre */
      _datfin = CPLib.Str(pAnno,4,0)+"0630";
      /* voce semestrale per IP */
      /* _datinisem := Str(pAnno,4,0)+'0101' // Data Inizio Semestre */
      _datinisem = CPLib.Str(pAnno,4,0)+"0101";
      /* _datfinsem := Str(pAnno,4,0)+'0630' // Data Fine Semestre */
      _datfinsem = CPLib.Str(pAnno,4,0)+"0630";
      /* Case pTri=3 */
    } else if (CPLib.eqr(pTri,3)) {
      /* _datini := Str(pAnno,4,0)+'0701' // Data Inizio Trimestre */
      _datini = CPLib.Str(pAnno,4,0)+"0701";
      /* _datfin := Str(pAnno,4,0)+'0930' // Data Fine Trimestre */
      _datfin = CPLib.Str(pAnno,4,0)+"0930";
      /* Case pTri=4 */
    } else if (CPLib.eqr(pTri,4)) {
      /* _datini := Str(pAnno,4,0)+'1001' // Data Inizio Trimestre */
      _datini = CPLib.Str(pAnno,4,0)+"1001";
      /* _datfin := Str(pAnno,4,0)+'1231' // Data Fine Trimestre */
      _datfin = CPLib.Str(pAnno,4,0)+"1231";
      /* voce semestrale per IP */
      /* _datinisem := Str(pAnno,4,0)+'0701' // Data Inizio Semestre */
      _datinisem = CPLib.Str(pAnno,4,0)+"0701";
      /* _datfinsem := Str(pAnno,4,0)+'1231' // Data Fine Semestre */
      _datfinsem = CPLib.Str(pAnno,4,0)+"1231";
    } // End Case
    /* _ddatini := CharToDate(_datini) */
    _ddatini = CPLib.CharToDate(_datini);
    /* _ddatfin := CharToDate(_datfin) */
    _ddatfin = CPLib.CharToDate(_datfin);
    /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* If pTipoBase3="B3MT" */
    if (CPLib.eqr(pTipoBase3,"B3MT")) {
      /* Exec "B3 MoneyTransfer" Page 2:b3_MT */
      b3_MT();
    } else { // Else
      /* Exec "B3 Istituto di Pagamento" Page 3:b3_IP */
      b3_IP();
    } // End If
    /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* Return cRitorno */
    throw new Stop(cRitorno);
  }
  void b3_MT() throws Exception {
    CPResultSet Cursor_qbe_estrai_sv_wu=null;
    CPResultSet Cursor_qbe_agg_flagfraud_ope=null;
    CPResultSet Cursor_qbe_estrai_sv_wu_fraud=null;
    CPResultSet Cursor_qbe_estrai_sv_only_fraud=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* nFile := LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_0"+Str(pTri,1,0) */
      nFile = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_0"+CPLib.Str(pTri,1,0);
      /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile)+".txt") // Per gestione file */
      fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile)+".txt");
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      double nTry0000004Astatus;
      nTry0000004Astatus = m_Sql.GetTransactionStatus();
      String cTry0000004Amsg;
      cTry0000004Amsg = m_Sql.TransactionErrorMessage();
      try {
        /* If pFraudo='N' */
        if (CPLib.eqr(pFraudo,"N")) {
          // * --- Select from qbe_estrai_sv_wu
          SPBridge.HMCaller _h0000004C;
          _h0000004C = new SPBridge.HMCaller();
          _h0000004C.Set("m_cVQRList",m_cVQRList);
          _h0000004C.Set("pDADATA",_ddatini);
          _h0000004C.Set("pA_DATA",_ddatfin);
          if (Cursor_qbe_estrai_sv_wu!=null)
            Cursor_qbe_estrai_sv_wu.Close();
          Cursor_qbe_estrai_sv_wu = new VQRHolder("qbe_estrai_sv_wu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000004C,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_estrai_sv_wu.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Elaborazione del record n. '+LRTrim(Str(conta,10,0)) // Messaggio Import */
            gMsgImp = "Elaborazione del record n. "+CPLib.LRTrim(CPLib.Str(conta,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* riga := LibreriaMit.UniqueId() */
            riga = LibreriaMit.UniqueId();
            /* riga := riga + Str(pAnno,4,0) */
            riga = riga+CPLib.Str(pAnno,4,0);
            /* riga := riga + Str(pTri,1,0) */
            riga = riga+CPLib.Str(pTri,1,0);
            /* riga := riga + '58560' */
            riga = riga+"58560";
            /* If pSegno='1' */
            if (CPLib.eqr(pSegno,"1")) {
              /* riga := riga + iif(qbe_estrai_sv_wu->SEGNO='A','22','14') */
              riga = riga+(CPLib.eqr(Cursor_qbe_estrai_sv_wu.GetString("SEGNO"),"A")?"22":"14");
              /* ElseIf pSegno='2' */
            } else if (CPLib.eqr(pSegno,"2")) {
              /* riga := riga + iif(qbe_estrai_sv_wu->SEGNO='D','22','14') */
              riga = riga+(CPLib.eqr(Cursor_qbe_estrai_sv_wu.GetString("SEGNO"),"D")?"22":"14");
            } // End If
            /* _importo := qbe_estrai_sv_wu->IMPORTO/100.0 */
            _importo = CPLib.Round(Cursor_qbe_estrai_sv_wu.GetDouble("IMPORTO")/100.0,2);
            /* _importodef := _importo */
            _importodef = CPLib.Round(_importo,0);
            /* riga := riga + Str(_importodef*100,18,0) */
            riga = riga+CPLib.Str(_importodef*100,18,0);
            /* riga := riga + Str(qbe_estrai_sv_wu->NUMOPE,10,0) */
            riga = riga+CPLib.Str(Cursor_qbe_estrai_sv_wu.GetDouble("NUMOPE"),10,0);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->SOTGRUP,4) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("SOTGRUP"),4);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->PROVINCIA1,5) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("PROVINCIA1"),5);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->PAESE,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("PAESE"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->PROVINCIA,5) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("PROVINCIA"),5);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->TIPOSV,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("TIPOSV"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->TIPOCONT,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("TIPOCONT"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->VALUTA,1) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("VALUTA"),1);
            /* FileLibMit.WriteLine(fhand,riga) */
            FileLibMit.WriteLine(fhand,riga);
            Cursor_qbe_estrai_sv_wu.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_sv_wu.ErrorMessage();
          Cursor_qbe_estrai_sv_wu.Close();
          // * --- End Select
          /* gMsgProc := gMsgProc + 'Sono stati scritti: ' + LRTrim(Str(conta,10,0)) + ' record per il trimestre' + NL */
          gMsgProc = gMsgProc+"Sono stati scritti: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record per il trimestre"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* If pTri=2 or pTri=4 */
          if (CPLib.eqr(pTri,2) || CPLib.eqr(pTri,4)) {
            /* conta := 0 */
            conta = CPLib.Round(0,0);
            // * --- Select from qbe_agg_flagfraud_ope
            SPBridge.HMCaller _h00000066;
            _h00000066 = new SPBridge.HMCaller();
            _h00000066.Set("m_cVQRList",m_cVQRList);
            _h00000066.Set("_dadata",_datinisem);
            _h00000066.Set("_adata",_datfinsem);
            if (Cursor_qbe_agg_flagfraud_ope!=null)
              Cursor_qbe_agg_flagfraud_ope.Close();
            Cursor_qbe_agg_flagfraud_ope = new VQRHolder("qbe_agg_flagfraud_ope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000066,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_agg_flagfraud_ope.Eof())) {
              // * --- Write into analisi_sv from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("analisi_sv");
              m_cPhName = m_Ctx.GetPhName("analisi_sv");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"analisi_sv",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_estrai_sv_all",241,"00000067")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"FLAGFRAUD = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"analisi_sv",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"TIPO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_agg_flagfraud_ope.GetString("TIPOOPER"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_agg_flagfraud_ope.GetString("TIPOOPER"))+"";
              m_cSql = m_cSql+" and NUMPROG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_agg_flagfraud_ope.GetString("NUMPROG"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_agg_flagfraud_ope.GetString("NUMPROG"))+"";
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
              Cursor_qbe_agg_flagfraud_ope.Next();
            }
            m_cConnectivityError = Cursor_qbe_agg_flagfraud_ope.ErrorMessage();
            Cursor_qbe_agg_flagfraud_ope.Close();
            // * --- End Select
            // * --- Select from qbe_estrai_sv_wu_fraud
            SPBridge.HMCaller _h00000068;
            _h00000068 = new SPBridge.HMCaller();
            _h00000068.Set("m_cVQRList",m_cVQRList);
            _h00000068.Set("pFLAGFRAUD","S");
            if (Cursor_qbe_estrai_sv_wu_fraud!=null)
              Cursor_qbe_estrai_sv_wu_fraud.Close();
            Cursor_qbe_estrai_sv_wu_fraud = new VQRHolder("qbe_estrai_sv_wu_fraud",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000068,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_estrai_sv_wu_fraud.Eof())) {
              /* conta := conta + 1 */
              conta = CPLib.Round(conta+1,0);
              /* gMsgImp := 'Elaborazione del record n. '+LRTrim(Str(conta,10,0)) // Messaggio Import */
              gMsgImp = "Elaborazione del record n. "+CPLib.LRTrim(CPLib.Str(conta,10,0));
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* riga := LibreriaMit.UniqueId() */
              riga = LibreriaMit.UniqueId();
              /* riga := riga + Str(pAnno,4,0) */
              riga = riga+CPLib.Str(pAnno,4,0);
              /* riga := riga + Str(pTri,1,0) */
              riga = riga+CPLib.Str(pTri,1,0);
              /* riga := riga + '58785' */
              riga = riga+"58785";
              /* riga := riga + '04' */
              riga = riga+"04";
              /* _importo := qbe_estrai_sv_wu_fraud->IMPORTO / 100.0 */
              _importo = CPLib.Round(Cursor_qbe_estrai_sv_wu_fraud.GetDouble("IMPORTO")/100.0,2);
              /* _importodef := _importo */
              _importodef = CPLib.Round(_importo,0);
              /* riga := riga + Str(_importodef*100,18,0) */
              riga = riga+CPLib.Str(_importodef*100,18,0);
              /* riga := riga + Str(qbe_estrai_sv_wu_fraud->NUMOPE,10,0) */
              riga = riga+CPLib.Str(Cursor_qbe_estrai_sv_wu_fraud.GetDouble("NUMOPE"),10,0);
              /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->SOTGRUP,4) */
              riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("SOTGRUP"),4);
              /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->PROVINCIA1,5) */
              riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("PROVINCIA1"),5);
              /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->PAESE,3) */
              riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("PAESE"),3);
              /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->PROVINCIA,5) */
              riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("PROVINCIA"),5);
              /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->TIPOSV,3) */
              riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("TIPOSV"),3);
              /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->TIPOCONT,3) */
              riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("TIPOCONT"),3);
              /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->VALUTA,1) */
              riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("VALUTA"),1);
              /* FileLibMit.WriteLine(fhand,riga) */
              FileLibMit.WriteLine(fhand,riga);
              Cursor_qbe_estrai_sv_wu_fraud.Next();
            }
            m_cConnectivityError = Cursor_qbe_estrai_sv_wu_fraud.ErrorMessage();
            Cursor_qbe_estrai_sv_wu_fraud.Close();
            // * --- End Select
            /* If conta > 0 */
            if (CPLib.gt(conta,0)) {
              /* gMsgProc := gMsgProc + 'Sono stati scritti: ' + LRTrim(Str(conta,10,0)) + ' record per il semestre (Operazioni Fraudolente)' + NL */
              gMsgProc = gMsgProc+"Sono stati scritti: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record per il semestre (Operazioni Fraudolente)"+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } else { // Else
              /* gMsgProc := gMsgProc + "Non ci sono operazioni fraudolente da segnalare" + NL */
              gMsgProc = gMsgProc+"Non ci sono operazioni fraudolente da segnalare"+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
          } // End If
        } else { // Else
          /* conta := 0 */
          conta = CPLib.Round(0,0);
          // * --- Select from qbe_estrai_sv_only_fraud
          if (Cursor_qbe_estrai_sv_only_fraud!=null)
            Cursor_qbe_estrai_sv_only_fraud.Close();
          Cursor_qbe_estrai_sv_only_fraud = new VQRHolder("qbe_estrai_sv_only_fraud",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_estrai_sv_only_fraud.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Elaborazione del record n. '+LRTrim(Str(conta,10,0)) // Messaggio Import */
            gMsgImp = "Elaborazione del record n. "+CPLib.LRTrim(CPLib.Str(conta,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* riga := LibreriaMit.UniqueId() */
            riga = LibreriaMit.UniqueId();
            /* riga := riga + Str(pAnno,4,0) */
            riga = riga+CPLib.Str(pAnno,4,0);
            /* riga := riga + Str(pTri,1,0) */
            riga = riga+CPLib.Str(pTri,1,0);
            /* riga := riga + '58785' */
            riga = riga+"58785";
            /* riga := riga + '04' */
            riga = riga+"04";
            /* _importo := qbe_estrai_sv_only_fraud->IMPORTO / 100.0 */
            _importo = CPLib.Round(Cursor_qbe_estrai_sv_only_fraud.GetDouble("IMPORTO")/100.0,2);
            /* _importodef := _importo */
            _importodef = CPLib.Round(_importo,0);
            /* riga := riga + Str(_importodef*100,18,0) */
            riga = riga+CPLib.Str(_importodef*100,18,0);
            /* riga := riga + Str(qbe_estrai_sv_only_fraud->NUMOPE,10,0) */
            riga = riga+CPLib.Str(Cursor_qbe_estrai_sv_only_fraud.GetDouble("NUMOPE"),10,0);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_only_fraud->SOTGRUP,4) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_only_fraud.GetString("SOTGRUP"),4);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_only_fraud->PROVINCIA1,5) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_only_fraud.GetString("PROVINCIA1"),5);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_only_fraud->PAESE,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_only_fraud.GetString("PAESE"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_only_fraud->PROVINCIA,5) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_only_fraud.GetString("PROVINCIA"),5);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_only_fraud->TIPOSV,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_only_fraud.GetString("TIPOSV"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_only_fraud->TIPOCONT,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_only_fraud.GetString("TIPOCONT"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_only_fraud->VALUTA,1) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_only_fraud.GetString("VALUTA"),1);
            /* FileLibMit.WriteLine(fhand,riga) */
            FileLibMit.WriteLine(fhand,riga);
            Cursor_qbe_estrai_sv_only_fraud.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_sv_only_fraud.ErrorMessage();
          Cursor_qbe_estrai_sv_only_fraud.Close();
          // * --- End Select
          /* If conta > 0 */
          if (CPLib.gt(conta,0)) {
            /* gMsgProc := gMsgProc + 'Sono stati scritti: ' + LRTrim(Str(conta,10,0)) + ' record per il semestre (Operazioni Fraudolente)' + NL */
            gMsgProc = gMsgProc+"Sono stati scritti: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record per il semestre (Operazioni Fraudolente)"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } else { // Else
            /* gMsgProc := gMsgProc + "Non ci sono operazioni fraudolente da segnalare" + NL */
            gMsgProc = gMsgProc+"Non ci sono operazioni fraudolente da segnalare"+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          } // End If
        } // End If
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* cNomeFileZip := LRTrim(nFile)+'.zip' */
        cNomeFileZip = CPLib.LRTrim(nFile)+".zip";
        /* cNomeZip := LRTrim(gPathDoc)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(cNomeFileZip) */
        cNomeZip = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cNomeFileZip);
        /* fname := nFile+".txt" */
        fname = nFile+".txt";
         onlyfilenames= new String[]{fname};
        /* pfname := LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(fname) */
        pfname = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(fname);
         filenames = new String[]{pfname};
        /* Exec "Creazione ZIP" Page 4:Page_ZIP */
        Page_ZIP();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* cProg := Utilities.GetAutonumber("PSTPMAV\'"+LRTrim(gAzienda)+"'","",10) */
        cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTPMAV\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
        // * --- Insert into cgo_stampeav from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("cgo_stampeav");
        m_cPhName = m_Ctx.GetPhName("cgo_stampeav");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_stampeav",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arfn_estrai_sv_all",241,"000000A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_000000A1(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(gCodDip,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(cNomeZip,"?",0,0,m_cServer, m_oParameters)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_stampeav",true);
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
        /* cRitorno := cProg */
        cRitorno = cProg;
        /* gMsgImp := 'Elaborazione completata con successo!' // Messaggio Import */
        gMsgImp = "Elaborazione completata con successo!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* gMsgProc := gMsgProc + "Elaborazione andata a buon fine! Prelevare il file attraverso l'apposito bottone" + NL */
        gMsgProc = gMsgProc+"Elaborazione andata a buon fine! Prelevare il file attraverso l'apposito bottone"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* cRitorno := 'KO' */
        cRitorno = "KO";
        /* gMsgProc := gMsgProc + 'Elaborazione non portata a termine' + NL */
        gMsgProc = gMsgProc+"Elaborazione non portata a termine"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione abortita!' // Messaggio Import */
        gMsgImp = "Elaborazione abortita!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000004Astatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000004Astatus,cTry0000004Amsg);
        }
      }
    } finally {
      try {
        if (Cursor_qbe_estrai_sv_wu!=null)
          Cursor_qbe_estrai_sv_wu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_agg_flagfraud_ope!=null)
          Cursor_qbe_agg_flagfraud_ope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_wu_fraud!=null)
          Cursor_qbe_estrai_sv_wu_fraud.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_only_fraud!=null)
          Cursor_qbe_estrai_sv_only_fraud.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void b3_IP() throws Exception {
    CPResultSet Cursor_tbstatisv=null;
    CPResultSet Cursor_qbe_sv_idp_rapporti=null;
    CPResultSet Cursor_qbe_estrai_sv_all_ip_1=null;
    CPResultSet Cursor_rapopebo=null;
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_tbstatna=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_qbe_estrai_sv_all_ip_2_a=null;
    CPResultSet Cursor_qbe_estrai_sv_all_ip_2_prov=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _numsto Char(15) */
      String _numsto;
      _numsto = CPLib.Space(15);
      /* _UniqueId Char(10) := NullString() // codice univoco dell'anagrafica */
      String _UniqueId;
      _UniqueId = CPLib.NullString();
      /* _dataFinePeriodo Date := CharToDate(_datfin) */
      java.sql.Date _dataFinePeriodo;
      _dataFinePeriodo = CPLib.CharToDate(_datfin);
      /* _cntOpe Numeric(0, 0) := 0 */
      _cntOpe = CPLib.Round(0,0);
      /* csvPrinter Object(CSVPrinter) */
      CSVPrinter csvPrinter;
      csvPrinter = null;
      /* writer Object(BufferedWriter) // Per scrivere il csv */
      BufferedWriter writer;
      writer = null;
      /* mctbstatisv MemoryCursor(tbstatisv) // mc tbstatisv ordinato per codice_BI (086...ecc) */
      MemoryCursor_tbstatisv mctbstatisv;
      mctbstatisv = new MemoryCursor_tbstatisv();
      /* mctbstatisv_nasc MemoryCursor(tbstatisv) // mc tbstatisv ordinato per descrizione */
      MemoryCursor_tbstatisv mctbstatisv_nasc;
      mctbstatisv_nasc = new MemoryCursor_tbstatisv();
      /* mctbstatisv_nasc2 MemoryCursor(tbstatisv) // mc tbstatisv ordinato per descrizione */
      MemoryCursor_tbstatisv mctbstatisv_nasc2;
      mctbstatisv_nasc2 = new MemoryCursor_tbstatisv();
      /* _data32 Date := NullDate() // Eventuale data massima della informazione di tipo 32 sul rapporto (variazione anagrafica) */
      java.sql.Date _data32;
      _data32 = CPLib.NullDate();
      // * --- Fill memory cursor mctbstatisv on tbstatisv
      mctbstatisv.Zap();
      m_cServer = m_Ctx.GetServer("tbstatisv");
      m_cPhName = m_Ctx.GetPhName("tbstatisv");
      if (Cursor_tbstatisv!=null)
        Cursor_tbstatisv.Close();
      Cursor_tbstatisv = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select * from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstatisv")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstatisv;
        Cursor_tbstatisv.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arfn_estrai_sv_all: query on tbstatisv returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstatisv.Eof())) {
        mctbstatisv.AppendWithTrimmedKey(Cursor_tbstatisv.GetString("COD_BI"));
        mctbstatisv.row.CODICENSV = Cursor_tbstatisv.GetString("CODICENSV");
        mctbstatisv.row.DENOMINAZIONE = Cursor_tbstatisv.GetString("DENOMINAZIONE");
        mctbstatisv.row.COD_BI = Cursor_tbstatisv.GetString("COD_BI");
        mctbstatisv.row.SIGLA = Cursor_tbstatisv.GetString("SIGLA");
        mctbstatisv.row.ISO = Cursor_tbstatisv.GetString("ISO");
        mctbstatisv.row.ISO2 = Cursor_tbstatisv.GetString("ISO2");
        mctbstatisv.row.INIZIO = Cursor_tbstatisv.GetDate("INIZIO");
        mctbstatisv.row.FINE = Cursor_tbstatisv.GetDate("FINE");
        Cursor_tbstatisv.Next();
      }
      m_cConnectivityError = Cursor_tbstatisv.ErrorMessage();
      Cursor_tbstatisv.Close();
      mctbstatisv.GoTop();
      for (MemoryCursorRow_tbstatisv rwtbstatisv : mctbstatisv._iterable_()) {
        /* mctbstatisv_nasc.AppendRowWithKey(rwtbstatisv.DENOMINAZIONE,rwtbstatisv) // mc tbstatisv ordinato per descrizione */
        mctbstatisv_nasc.AppendRowWithKey(rwtbstatisv.DENOMINAZIONE,rwtbstatisv);
        /* mctbstatisv_nasc2.AppendRowWithKey(rwtbstatisv.ISO,rwtbstatisv) // mc tbstatisv ordinato per descrizione */
        mctbstatisv_nasc2.AppendRowWithKey(rwtbstatisv.ISO,rwtbstatisv);
      }
      /* gMsgProc := gMsgProc+ 'Inizio Elaborazione Base3 per IP voce '+iif(pTri=1 or pTri=3," Trimestrale "+Str(pTri,1,0), "Trimeste "+Str(pTri,1,0)+" e Semestre "+ iif(pTri=2 ,"1","2"))+ NL */
      gMsgProc = gMsgProc+"Inizio Elaborazione Base3 per IP voce "+(CPLib.eqr(pTri,1) || CPLib.eqr(pTri,3)?" Trimestrale "+CPLib.Str(pTri,1,0):"Trimeste "+CPLib.Str(pTri,1,0)+" e Semestre "+(CPLib.eqr(pTri,2)?"1":"2"))+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc+ 'Periodo di estrazione trimestrale: dal '+CharToDate(_datini)+' al '+CharToDate(_datfin)+ NL */
      gMsgProc = gMsgProc+"Periodo di estrazione trimestrale: dal "+CPLib.CharToDate(_datini)+" al "+CPLib.CharToDate(_datfin)+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If pTri=2 or pTri=4 */
      if (CPLib.eqr(pTri,2) || CPLib.eqr(pTri,4)) {
        /* gMsgProc := gMsgProc+ 'Periodo di estrazione semestrale: dal '+CharToDate(_datinisem)+' al '+CharToDate(_datfinsem)+ NL */
        gMsgProc = gMsgProc+"Periodo di estrazione semestrale: dal "+CPLib.CharToDate(_datinisem)+" al "+CPLib.CharToDate(_datfinsem)+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
      /* gMsgProc := gMsgProc+ 'Verifica assenza di saldi per rapporti'+ NL */
      gMsgProc = gMsgProc+"Verifica assenza di saldi per rapporti"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Fill memory cursor mcRapporti on qbe_sv_idp_rapporti
      mcRapporti.Zap();
      SPBridge.HMCaller _h000000BD;
      _h000000BD = new SPBridge.HMCaller();
      _h000000BD.Set("m_cVQRList",m_cVQRList);
      _h000000BD.Set("pANNO",pAnno);
      _h000000BD.Set("pTRIMESTRE",pTri);
      _h000000BD.Set("pDATAF_INI",_datini);
      _h000000BD.Set("pDATAF_FINE",_datfin);
      if (Cursor_qbe_sv_idp_rapporti!=null)
        Cursor_qbe_sv_idp_rapporti.Close();
      Cursor_qbe_sv_idp_rapporti = new VQRHolder("qbe_sv_idp_rapporti",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000BD,true).GetResultSet(m_Ctx);
      {
        final CPResultSet m_TheCursor = Cursor_qbe_sv_idp_rapporti;
        Cursor_qbe_sv_idp_rapporti.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arfn_estrai_sv_all: query on qbe_sv_idp_rapporti returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_qbe_sv_idp_rapporti.Eof())) {
        mcRapporti.AppendBlank();
        mcRapporti.row.RAPPORTO = Cursor_qbe_sv_idp_rapporti.GetString("RAPPORTO");
        mcRapporti.row.DESCRAP = Cursor_qbe_sv_idp_rapporti.GetString("DESCRAP");
        Cursor_qbe_sv_idp_rapporti.Next();
      }
      m_cConnectivityError = Cursor_qbe_sv_idp_rapporti.ErrorMessage();
      Cursor_qbe_sv_idp_rapporti.Close();
      mcRapporti.GoTop();
      /* If mcRapporti.RecCount()=0 */
      if (CPLib.eqr(mcRapporti.RecCount(),0)) {
         filenames = new String[4];
         onlyfilenames = new String[4];
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        double nTry000000C2status;
        nTry000000C2status = m_Sql.GetTransactionStatus();
        String cTry000000C2msg;
        cTry000000C2msg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgProc := gMsgProc+ 'Inizio creazione file SaldiTesoreria.txt; '+ arfn_fdatetime(DateTime())+ NL */
          gMsgProc = gMsgProc+"Inizio creazione file SaldiTesoreria.txt; "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* nFile := LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_SaldiTesoreria.txt" */
          nFile = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_SaldiTesoreria.txt";
          onlyfilenames[0] = nFile;
          /* pfname := LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile) */
          pfname = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile);
          filenames[0] = pfname;
          /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile)) // Per gestione file */
          fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile));
          // * --- Fill memory cursor mcB3_SaldiTesoreria on qbe_estrai_sv_all_ip_1
          mcB3_SaldiTesoreria.Zap();
          SPBridge.HMCaller _h000000C9;
          _h000000C9 = new SPBridge.HMCaller();
          _h000000C9.Set("m_cVQRList",m_cVQRList);
          _h000000C9.Set("pANNO",pAnno);
          _h000000C9.Set("pTRIMESTRE",pTri);
          _h000000C9.Set("pDATAF_INI",(CPLib.eqr(pTri,2) || CPLib.eqr(pTri,4)?_datinisem:_datini));
          _h000000C9.Set("pDATAF_FIN",_datfin);
          if (Cursor_qbe_estrai_sv_all_ip_1!=null)
            Cursor_qbe_estrai_sv_all_ip_1.Close();
          Cursor_qbe_estrai_sv_all_ip_1 = new VQRHolder("qbe_estrai_sv_all_ip_1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000C9,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_estrai_sv_all_ip_1;
            Cursor_qbe_estrai_sv_all_ip_1.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arfn_estrai_sv_all: query on qbe_estrai_sv_all_ip_1 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_estrai_sv_all_ip_1.Eof())) {
            mcB3_SaldiTesoreria.AppendBlank();
            mcB3_SaldiTesoreria.row.RAPPORTO = Cursor_qbe_estrai_sv_all_ip_1.GetString("RAPPORTO");
            mcB3_SaldiTesoreria.row.DESCRAP = Cursor_qbe_estrai_sv_all_ip_1.GetString("DESCRAP");
            mcB3_SaldiTesoreria.row.ANNO = Cursor_qbe_estrai_sv_all_ip_1.GetString("ANNO");
            mcB3_SaldiTesoreria.row.TRIMESTRE = Cursor_qbe_estrai_sv_all_ip_1.GetString("TRIMESTRE");
            mcB3_SaldiTesoreria.row.IMPORTO = Cursor_qbe_estrai_sv_all_ip_1.GetDouble("IMPORTO");
            mcB3_SaldiTesoreria.row.CODINTER = Cursor_qbe_estrai_sv_all_ip_1.GetString("CODINTER");
            mcB3_SaldiTesoreria.row.DATA_INI = Cursor_qbe_estrai_sv_all_ip_1.GetDate("DATA_INI");
            mcB3_SaldiTesoreria.row.DATA_FIN = Cursor_qbe_estrai_sv_all_ip_1.GetDate("DATA_FIN");
            mcB3_SaldiTesoreria.row.TIPORAP = Cursor_qbe_estrai_sv_all_ip_1.GetString("TIPORAP");
            mcB3_SaldiTesoreria.row.DATARETT = Cursor_qbe_estrai_sv_all_ip_1.GetDate("DATARETT");
            Cursor_qbe_estrai_sv_all_ip_1.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_sv_all_ip_1.ErrorMessage();
          Cursor_qbe_estrai_sv_all_ip_1.Close();
          mcB3_SaldiTesoreria.GoTop();
          for (MemoryCursorRow_qbe_estrai_sv_all_ip_1_vqr rw_uno : mcB3_SaldiTesoreria._iterable_()) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* If rw_uno.TIPORAP='1' */
            if (CPLib.eqr(rw_uno.TIPORAP,"1")) {
              // Transaction Error
              cTry000000C2msg = CPLib.FormatMsg(m_Ctx,"Rapporto cointestato necessaria verifica da parte di mit");
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Rapporto cointestato necessaria verifica da parte di mit"));
              /* gMsgProc := gMsgProc+ 'Anomalia sul rapporto :'+rw_uno.RAPPORTO+' . Contattare mit '+ NL */
              gMsgProc = gMsgProc+"Anomalia sul rapporto :"+rw_uno.RAPPORTO+" . Contattare mit "+"\n";
              m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            } // End If
            /* gMsgImp := 'Elaborazione del record n. '+LRTrim(Str(conta,10,0)) // Messaggio Import */
            gMsgImp = "Elaborazione del record n. "+CPLib.LRTrim(CPLib.Str(conta,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* riga := Space(5) // 03.01 */
            riga = CPLib.Space(5);
            /* riga := riga + LibreriaMit.SpacePad(Upper(rw_uno.RAPPORTO),25) // 03.02 */
            riga = riga+LibreriaMit.SpacePad(CPLib.Upper(rw_uno.RAPPORTO),25);
            /* riga := riga + LibreriaMit.SpacePad(rw_uno.DESCRAP,30) // 03.03 */
            riga = riga+LibreriaMit.SpacePad(rw_uno.DESCRAP,30);
            /* _importo := rw_uno.IMPORTO*100 // da 9,25 a 925 */
            _importo = CPLib.Round(rw_uno.IMPORTO*100,2);
            /* If rw_uno.IMPORTO>=0 */
            if (CPLib.ge(rw_uno.IMPORTO,0)) {
              /* riga := riga + Str(_importo,12,0) // 03.04 */
              riga = riga+CPLib.Str(_importo,12,0);
              /* riga := riga + "A" // 03.05 */
              riga = riga+"A";
            } else { // Else
              /* riga := riga + Str((-_importo),12,0) // 03.04 */
              riga = riga+CPLib.Str((-_importo),12,0);
              /* riga := riga + "D" // 03.05 */
              riga = riga+"D";
            } // End If
            /* riga := riga + LibreriaMit.SpacePad(rw_uno.CODINTER,16) // 03.06 */
            riga = riga+LibreriaMit.SpacePad(rw_uno.CODINTER,16);
            /* riga := riga + Space(13) // 03.07 */
            riga = riga+CPLib.Space(13);
            /* riga := riga + DateToChar(rw_uno.DATA_INI) // 03.08 */
            riga = riga+CPLib.DateToChar(rw_uno.DATA_INI);
            /* Prendo la data fine se solamente se rientra nel periodo di competenza */
            /* riga := riga +iif((not(Empty(rw_uno.DATA_FIN)) and (rw_uno.DATA_FIN<=_dataFinePeriodo)),DateToChar(rw_uno.DATA_FIN),Space(8)) // 03.08 */
            riga = riga+(( ! (CPLib.Empty(rw_uno.DATA_FIN)) && (CPLib.le(rw_uno.DATA_FIN,_dataFinePeriodo)))?CPLib.DateToChar(rw_uno.DATA_FIN):CPLib.Space(8));
            /* FileLibMit.WriteLine(fhand,riga) */
            FileLibMit.WriteLine(fhand,riga);
            /* If not(mcB3_Clienti.GoToKey(rw_uno.CODINTER)) */
            if ( ! (mcB3_Clienti.GoToKey(rw_uno.CODINTER))) {
              /* rowB3_Clienti := new Row(mcEstraiSV_clienti.MCRDef) */
              rowB3_Clienti = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
              /* _data32 := NullDate() // Eventuale data massima della informazione di tipo 32 sul rapporto (variazione anagrafica) */
              _data32 = CPLib.NullDate();
              // * --- Select from rapopebo
              m_cServer = m_Ctx.GetServer("rapopebo");
              m_cPhName = m_Ctx.GetPhName("rapopebo");
              if (Cursor_rapopebo!=null)
                Cursor_rapopebo.Close();
              Cursor_rapopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select DATAOPE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.RAPPORTO,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_uno.RAPPORTO)+"  and  TIPOOPRAP='32' "+")"+(m_Ctx.IsSharedTemp("rapopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"DATAOPE desc ",m_cServer,m_Ctx,true));
              while ( ! (Cursor_rapopebo.Eof())) {
                /* _data32 := rapopebo->DATAOPE // Eventuale data massima della informazione di tipo 32 sul rapporto (variazione anagrafica) */
                _data32 = Cursor_rapopebo.GetDate("DATAOPE");
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_rapopebo.Next();
              }
              m_cConnectivityError = Cursor_rapopebo.ErrorMessage();
              Cursor_rapopebo.Close();
              // * --- End Select
              /* If not(Empty(_data32)) or not(Empty(rw_uno.DATARETT)) */
              if ( ! (CPLib.Empty(_data32)) ||  ! (CPLib.Empty(rw_uno.DATARETT))) {
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_uno.CODINTER)+"  and  datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.gt(_data32,rw_uno.DATARETT)?_data32:rw_uno.DATARETT),"?",0,0,m_cServer, m_oParameters),m_cServer,(CPLib.gt(_data32,rw_uno.DATARETT)?_data32:rw_uno.DATARETT))+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"datamodi desc,sanumpro ",m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* rowB3_Clienti.NDG := wersonbo->CONNES // 05.01 */
                  rowB3_Clienti.NDG = Cursor_wersonbo.GetString("CONNES");
                  /* rowB3_Clienti.RAGSOC := wersonbo->RAGSOC // 05.03 */
                  rowB3_Clienti.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                  /* rowB3_Clienti.PROV := wersonbo->PROVINCIA // 05.04 */
                  rowB3_Clienti.PROV = Cursor_wersonbo.GetString("PROVINCIA");
                  /* rowB3_Clienti.SAE := wersonbo->SOTGRUP // 05.05 */
                  rowB3_Clienti.SAE = Cursor_wersonbo.GetString("SOTGRUP");
                  /* rowB3_Clienti.SVT00011 := wersonbo->SOTGRUP // 05.05 */
                  rowB3_Clienti.SVT00011 = Cursor_wersonbo.GetString("SOTGRUP");
                  /* rowB3_Clienti.ATECO := wersonbo->ATTIV // 05.06 */
                  rowB3_Clienti.ATECO = Cursor_wersonbo.GetString("ATTIV");
                  /* rowB3_Clienti.SVT01118 := iif(Left(wersonbo->ATTIV,2)='P0','',Left(wersonbo->ATTIV,2)) // 05.06 */
                  rowB3_Clienti.SVT01118 = (CPLib.eqr(CPLib.Left(Cursor_wersonbo.GetString("ATTIV"),2),"P0")?"":CPLib.Left(Cursor_wersonbo.GetString("ATTIV"),2));
                  /* rowB3_Clienti.STATO := wersonbo->PAESE // 05.10 */
                  rowB3_Clienti.STATO = Cursor_wersonbo.GetString("PAESE");
                  // * --- Read from wersonbo_agg
                  m_cServer = m_Ctx.GetServer("wersonbo_agg");
                  m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
                  m_cSql = "";
                  m_cSql = m_cSql+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wersonbo.GetString("sanumpro"),"C",15,0,m_cServer),m_cServer,Cursor_wersonbo.GetString("sanumpro"));
                  if (m_Ctx.IsSharedTemp("wersonbo_agg")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCLIEST",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    rowB3_Clienti.CODCLI = Read_Cursor.GetString("CODCLIEST");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on wersonbo_agg into routine arfn_estrai_sv_all returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(rowB3_Clienti.CODCLI) */
                  if (CPLib.Empty(rowB3_Clienti.CODCLI)) {
                    // * --- Read from personbo_agg
                    m_cServer = m_Ctx.GetServer("personbo_agg");
                    m_cPhName = m_Ctx.GetPhName("personbo_agg");
                    m_cSql = "";
                    m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"C",16,0,m_cServer),m_cServer,rw_uno.CODINTER);
                    if (m_Ctx.IsSharedTemp("personbo_agg")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCLIEST",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      rowB3_Clienti.CODCLI = Read_Cursor.GetString("CODCLIEST");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on personbo_agg into routine arfn_estrai_sv_all returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(rowB3_Clienti.CODCLI) */
                    if (CPLib.Empty(rowB3_Clienti.CODCLI)) {
                      /* _UniqueId := LibreriaMit.UniqueId() // codice univoco dell'anagrafica */
                      _UniqueId = LibreriaMit.UniqueId();
                      // * --- Write into personbo_agg from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("personbo_agg");
                      m_cPhName = m_Ctx.GetPhName("personbo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arfn_estrai_sv_all",241,"000000F6")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CODCLIEST = "+CPLib.ToSQL(_UniqueId,"C",10,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"?",0,0,m_cServer),m_cServer,rw_uno.CODINTER)+"";
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
                      // * --- Write into wersonbo_agg from values
                      m_Sql.RequireTransaction();
                      m_cServer = m_Ctx.GetServer("wersonbo_agg");
                      m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
                      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
                      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                      m_cSql = CPLib.GetSQLPrefixComment("arfn_estrai_sv_all",241,"000000F7")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                      m_cSql = m_cSql+"CODCLIEST = "+CPLib.ToSQL(_UniqueId,"C",10,0,m_cServer)+", ";
                      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wersonbo_agg",false,true);
                      m_cSql = m_cSql+" where ";
                      m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"?",0,0,m_cServer),m_cServer,rw_uno.CODINTER)+"";
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
                      /* rowB3_Clienti.CODCLI := _UniqueId // 05.10 */
                      rowB3_Clienti.CODCLI = _UniqueId;
                    } // End If
                  } // End If
                  /* rowB3_Clienti.COGNOME := wersonbo->COGNOME // 05.10 */
                  rowB3_Clienti.COGNOME = Cursor_wersonbo.GetString("COGNOME");
                  /* rowB3_Clienti.NOME := wersonbo->NOME // 05.10 */
                  rowB3_Clienti.NOME = Cursor_wersonbo.GetString("NOME");
                  /* rowB3_Clienti.CODFISC := iif(wersonbo->CFESTERO=1,'',wersonbo->CODFISC) // 05.10 */
                  rowB3_Clienti.CODFISC = (CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?"":Cursor_wersonbo.GetString("CODFISC"));
                  /* rowB3_Clienti.CFESTERO := wersonbo->CFESTERO // 05.10 */
                  rowB3_Clienti.CFESTERO = Cursor_wersonbo.GetDouble("CFESTERO");
                  /* rowB3_Clienti.PARTIVA := wersonbo->PARTIVA // 05.10 */
                  rowB3_Clienti.PARTIVA = Cursor_wersonbo.GetString("PARTIVA");
                  /* rowB3_Clienti.DATANASC := wersonbo->DATANASC // 05.10 */
                  rowB3_Clienti.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                  /* rowB3_Clienti.COMUNASC := iif(Empty(wersonbo->SESSO),'',iif(wersonbo->TIPINTER='EE',wersonbo->NASSTATO,wersonbo->NASCOMUN)) // 05.10 */
                  rowB3_Clienti.COMUNASC = (CPLib.Empty(Cursor_wersonbo.GetString("SESSO"))?"":(CPLib.eqr(Cursor_wersonbo.GetString("TIPINTER"),"EE")?Cursor_wersonbo.GetString("NASSTATO"):Cursor_wersonbo.GetString("NASCOMUN")));
                  /* rowB3_Clienti.PROVNASC := wersonbo->TIPINTER // 05.10 */
                  rowB3_Clienti.PROVNASC = Cursor_wersonbo.GetString("TIPINTER");
                  /* If not(Empty(wersonbo->SESSO)) */
                  if ( ! (CPLib.Empty(Cursor_wersonbo.GetString("SESSO")))) {
                    /* If mctbstatisv_nasc.GoToKey(iif(wersonbo->TIPINTER<>'EE','ITALIA',wersonbo->NASSTATO)) */
                    if (mctbstatisv_nasc.GoToKey((CPLib.ne(Cursor_wersonbo.GetString("TIPINTER"),"EE")?"ITALIA":Cursor_wersonbo.GetString("NASSTATO")))) {
                      /* rowB3_Clienti.PAESENASC := mctbstatisv_nasc.CODICENSV // 05.10 */
                      rowB3_Clienti.PAESENASC = mctbstatisv_nasc.row.CODICENSV;
                    } else { // Else
                      // * --- Select from tbstatna
                      m_cServer = m_Ctx.GetServer("tbstatna");
                      m_cPhName = m_Ctx.GetPhName("tbstatna");
                      if (Cursor_tbstatna!=null)
                        Cursor_tbstatna.Close();
                      Cursor_tbstatna = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ISO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DESCRI="+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tbstatna")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_tbstatna.Eof())) {
                        /* If mctbstatisv_nasc2.GoToKey(iif(wersonbo->TIPINTER<>'EE','ITA',tbstatna->ISO)) */
                        if (mctbstatisv_nasc2.GoToKey((CPLib.ne(Cursor_wersonbo.GetString("TIPINTER"),"EE")?"ITA":Cursor_tbstatna.GetString("ISO")))) {
                          /* rowB3_Clienti.PAESENASC := mctbstatisv_nasc2.CODICENSV // 05.10 */
                          rowB3_Clienti.PAESENASC = mctbstatisv_nasc2.row.CODICENSV;
                        } else { // Else
                          // Transaction Error
                          cTry000000C2msg = CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato");
                          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                          throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                        } // End If
                        Cursor_tbstatna.Next();
                      }
                      m_cConnectivityError = Cursor_tbstatna.ErrorMessage();
                      Cursor_tbstatna.Close();
                      // * --- End Select
                    } // End If
                  } // End If
                  /* rowB3_Clienti.SESSO := iif(wersonbo->SESSO='1','M',iif(wersonbo->SESSO='2','F',wersonbo->SESSO)) // 05.10 */
                  rowB3_Clienti.SESSO = (CPLib.eqr(Cursor_wersonbo.GetString("SESSO"),"1")?"M":(CPLib.eqr(Cursor_wersonbo.GetString("SESSO"),"2")?"F":Cursor_wersonbo.GetString("SESSO")));
                  /* rowB3_Clienti.DESCCIT := wersonbo->DESCCIT // 05.10 */
                  rowB3_Clienti.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                  /* rowB3_Clienti.PROVINCIA := wersonbo->PROVINCIA // 05.10 */
                  rowB3_Clienti.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                  /* If mctbstatisv.GoToKey(wersonbo->PAESE) */
                  if (mctbstatisv.GoToKey(Cursor_wersonbo.GetString("PAESE"))) {
                    /* rowB3_Clienti.PAESE := mctbstatisv.CODICENSV // 05.10 */
                    rowB3_Clienti.PAESE = mctbstatisv.row.CODICENSV;
                    /* rowB3_Clienti.PAESEDOM := mctbstatisv.CODICENSV // 05.10 */
                    rowB3_Clienti.PAESEDOM = mctbstatisv.row.CODICENSV;
                  } else { // Else
                    // Transaction Error
                    cTry000000C2msg = CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato");
                    m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                    throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                  } // End If
                  /* rowB3_Clienti.SPECIE := iif(rw_uno.TIPORAP='1','COIN',iif(Empty(wersonbo->PKTBSPECIE),iif(Empty(wersonbo->SESSO),'','PF'),wersonbo->PKTBSPECIE)) // 05.10 */
                  rowB3_Clienti.SPECIE = (CPLib.eqr(rw_uno.TIPORAP,"1")?"COIN":(CPLib.Empty(Cursor_wersonbo.GetString("PKTBSPECIE"))?(CPLib.Empty(Cursor_wersonbo.GetString("SESSO"))?"":"PF"):Cursor_wersonbo.GetString("PKTBSPECIE")));
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* Prendo il dato storico (se c'è) */
              /* If Empty(rowB3_Clienti.NDG) */
              if (CPLib.Empty(rowB3_Clienti.NDG)) {
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_uno.CODINTER)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"datamodi desc,sanumpro ",m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* If wersonbo->datamodi > _dataFinePeriodo */
                  if (CPLib.gt(Cursor_wersonbo.GetDate("datamodi"),_dataFinePeriodo)) {
                    /* rowB3_Clienti.NDG := wersonbo->CONNES // 05.01 */
                    rowB3_Clienti.NDG = Cursor_wersonbo.GetString("CONNES");
                    /* rowB3_Clienti.RAGSOC := wersonbo->RAGSOC // 05.03 */
                    rowB3_Clienti.RAGSOC = Cursor_wersonbo.GetString("RAGSOC");
                    /* rowB3_Clienti.PROV := wersonbo->PROVINCIA // 05.04 */
                    rowB3_Clienti.PROV = Cursor_wersonbo.GetString("PROVINCIA");
                    /* rowB3_Clienti.SAE := wersonbo->SOTGRUP // 05.05 */
                    rowB3_Clienti.SAE = Cursor_wersonbo.GetString("SOTGRUP");
                    /* rowB3_Clienti.SVT00011 := wersonbo->SOTGRUP // 05.05 */
                    rowB3_Clienti.SVT00011 = Cursor_wersonbo.GetString("SOTGRUP");
                    /* rowB3_Clienti.ATECO := wersonbo->ATTIV // 05.06 */
                    rowB3_Clienti.ATECO = Cursor_wersonbo.GetString("ATTIV");
                    /* rowB3_Clienti.SVT01118 := iif(Left(wersonbo->ATTIV,2)='P0','',Left(wersonbo->ATTIV,2)) // 05.06 */
                    rowB3_Clienti.SVT01118 = (CPLib.eqr(CPLib.Left(Cursor_wersonbo.GetString("ATTIV"),2),"P0")?"":CPLib.Left(Cursor_wersonbo.GetString("ATTIV"),2));
                    /* rowB3_Clienti.STATO := wersonbo->PAESE // 05.10 */
                    rowB3_Clienti.STATO = Cursor_wersonbo.GetString("PAESE");
                    // * --- Read from wersonbo_agg
                    m_cServer = m_Ctx.GetServer("wersonbo_agg");
                    m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
                    m_cSql = "";
                    m_cSql = m_cSql+"sanumpro="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_wersonbo.GetString("sanumpro"),"C",15,0,m_cServer),m_cServer,Cursor_wersonbo.GetString("sanumpro"));
                    if (m_Ctx.IsSharedTemp("wersonbo_agg")) {
                      m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                    }
                    if (Read_Cursor!=null)
                      Read_Cursor.Close();
                    Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCLIEST",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                    if ( ! (Read_Cursor.Eof())) {
                      rowB3_Clienti.CODCLI = Read_Cursor.GetString("CODCLIEST");
                      Read_Cursor.Next();
                      if ( ! (Read_Cursor.Eof())) {
                        Error l_oErrorFault = new Error("Read on wersonbo_agg into routine arfn_estrai_sv_all returns two or more records. This item should return only a record.");
                        CPStdCounter.Error(l_oErrorFault);
                      }
                      Read_Cursor.Close();
                    } else {
                      // Error: no record found!
                      Read_Cursor.Close();
                      m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                    }
                    /* If Empty(rowB3_Clienti.CODCLI) */
                    if (CPLib.Empty(rowB3_Clienti.CODCLI)) {
                      // * --- Read from personbo_agg
                      m_cServer = m_Ctx.GetServer("personbo_agg");
                      m_cPhName = m_Ctx.GetPhName("personbo_agg");
                      m_cSql = "";
                      m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"C",16,0,m_cServer),m_cServer,rw_uno.CODINTER);
                      if (m_Ctx.IsSharedTemp("personbo_agg")) {
                        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                      }
                      if (Read_Cursor!=null)
                        Read_Cursor.Close();
                      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCLIEST",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                      if ( ! (Read_Cursor.Eof())) {
                        rowB3_Clienti.CODCLI = Read_Cursor.GetString("CODCLIEST");
                        Read_Cursor.Next();
                        if ( ! (Read_Cursor.Eof())) {
                          Error l_oErrorFault = new Error("Read on personbo_agg into routine arfn_estrai_sv_all returns two or more records. This item should return only a record.");
                          CPStdCounter.Error(l_oErrorFault);
                        }
                        Read_Cursor.Close();
                      } else {
                        // Error: no record found!
                        Read_Cursor.Close();
                        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                      }
                      /* If Empty(rowB3_Clienti.CODCLI) */
                      if (CPLib.Empty(rowB3_Clienti.CODCLI)) {
                        /* _UniqueId := LibreriaMit.UniqueId() // codice univoco dell'anagrafica */
                        _UniqueId = LibreriaMit.UniqueId();
                        // * --- Write into personbo_agg from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("personbo_agg");
                        m_cPhName = m_Ctx.GetPhName("personbo_agg");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arfn_estrai_sv_all",241,"00000123")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CODCLIEST = "+CPLib.ToSQL(_UniqueId,"C",10,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"?",0,0,m_cServer),m_cServer,rw_uno.CODINTER)+"";
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
                        // * --- Write into wersonbo_agg from values
                        m_Sql.RequireTransaction();
                        m_cServer = m_Ctx.GetServer("wersonbo_agg");
                        m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
                        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
                        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                        m_cSql = CPLib.GetSQLPrefixComment("arfn_estrai_sv_all",241,"00000124")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                        m_cSql = m_cSql+"CODCLIEST = "+CPLib.ToSQL(_UniqueId,"C",10,0,m_cServer)+", ";
                        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wersonbo_agg",false,true);
                        m_cSql = m_cSql+" where ";
                        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"?",0,0,m_cServer),m_cServer,rw_uno.CODINTER)+"";
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
                        /* rowB3_Clienti.CODCLI := _UniqueId // 05.10 */
                        rowB3_Clienti.CODCLI = _UniqueId;
                      } // End If
                    } // End If
                    /* rowB3_Clienti.COGNOME := wersonbo->COGNOME // 05.10 */
                    rowB3_Clienti.COGNOME = Cursor_wersonbo.GetString("COGNOME");
                    /* rowB3_Clienti.NOME := wersonbo->NOME // 05.10 */
                    rowB3_Clienti.NOME = Cursor_wersonbo.GetString("NOME");
                    /* rowB3_Clienti.CODFISC := iif(wersonbo->CFESTERO=1,'',wersonbo->CODFISC) // 05.10 */
                    rowB3_Clienti.CODFISC = (CPLib.eqr(Cursor_wersonbo.GetDouble("CFESTERO"),1)?"":Cursor_wersonbo.GetString("CODFISC"));
                    /* rowB3_Clienti.CFESTERO := wersonbo->CFESTERO // 05.10 */
                    rowB3_Clienti.CFESTERO = Cursor_wersonbo.GetDouble("CFESTERO");
                    /* rowB3_Clienti.PARTIVA := wersonbo->PARTIVA // 05.10 */
                    rowB3_Clienti.PARTIVA = Cursor_wersonbo.GetString("PARTIVA");
                    /* rowB3_Clienti.DATANASC := wersonbo->DATANASC // 05.10 */
                    rowB3_Clienti.DATANASC = Cursor_wersonbo.GetDate("DATANASC");
                    /* rowB3_Clienti.COMUNASC := iif(Empty(wersonbo->SESSO),'',iif(wersonbo->TIPINTER='EE',wersonbo->NASSTATO,wersonbo->NASCOMUN)) // 05.10 */
                    rowB3_Clienti.COMUNASC = (CPLib.Empty(Cursor_wersonbo.GetString("SESSO"))?"":(CPLib.eqr(Cursor_wersonbo.GetString("TIPINTER"),"EE")?Cursor_wersonbo.GetString("NASSTATO"):Cursor_wersonbo.GetString("NASCOMUN")));
                    /* rowB3_Clienti.PROVNASC := wersonbo->TIPINTER // 05.10 */
                    rowB3_Clienti.PROVNASC = Cursor_wersonbo.GetString("TIPINTER");
                    /* If not(Empty(wersonbo->SESSO)) */
                    if ( ! (CPLib.Empty(Cursor_wersonbo.GetString("SESSO")))) {
                      /* If mctbstatisv_nasc.GoToKey(iif(wersonbo->TIPINTER<>'EE','ITALIA',wersonbo->NASSTATO)) */
                      if (mctbstatisv_nasc.GoToKey((CPLib.ne(Cursor_wersonbo.GetString("TIPINTER"),"EE")?"ITALIA":Cursor_wersonbo.GetString("NASSTATO")))) {
                        /* rowB3_Clienti.PAESENASC := mctbstatisv_nasc.CODICENSV // 05.10 */
                        rowB3_Clienti.PAESENASC = mctbstatisv_nasc.row.CODICENSV;
                      } else { // Else
                        // * --- Select from tbstatna
                        m_cServer = m_Ctx.GetServer("tbstatna");
                        m_cPhName = m_Ctx.GetPhName("tbstatna");
                        if (Cursor_tbstatna!=null)
                          Cursor_tbstatna.Close();
                        Cursor_tbstatna = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ISO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DESCRI="+CPLib.ToSQL(Cursor_wersonbo.GetString("NASSTATO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tbstatna")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                        while ( ! (Cursor_tbstatna.Eof())) {
                          /* If mctbstatisv_nasc2.GoToKey(iif(wersonbo->TIPINTER<>'EE','ITA',tbstatna->ISO)) */
                          if (mctbstatisv_nasc2.GoToKey((CPLib.ne(Cursor_wersonbo.GetString("TIPINTER"),"EE")?"ITA":Cursor_tbstatna.GetString("ISO")))) {
                            /* rowB3_Clienti.PAESENASC := mctbstatisv_nasc2.CODICENSV // 05.10 */
                            rowB3_Clienti.PAESENASC = mctbstatisv_nasc2.row.CODICENSV;
                          } else { // Else
                            // Transaction Error
                            cTry000000C2msg = CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato");
                            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                            throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                          } // End If
                          Cursor_tbstatna.Next();
                        }
                        m_cConnectivityError = Cursor_tbstatna.ErrorMessage();
                        Cursor_tbstatna.Close();
                        // * --- End Select
                      } // End If
                    } // End If
                    /* rowB3_Clienti.SESSO := iif(wersonbo->SESSO='1','M',iif(wersonbo->SESSO='2','F',wersonbo->SESSO)) // 05.10 */
                    rowB3_Clienti.SESSO = (CPLib.eqr(Cursor_wersonbo.GetString("SESSO"),"1")?"M":(CPLib.eqr(Cursor_wersonbo.GetString("SESSO"),"2")?"F":Cursor_wersonbo.GetString("SESSO")));
                    /* rowB3_Clienti.DESCCIT := wersonbo->DESCCIT // 05.10 */
                    rowB3_Clienti.DESCCIT = Cursor_wersonbo.GetString("DESCCIT");
                    /* rowB3_Clienti.PROVINCIA := wersonbo->PROVINCIA // 05.10 */
                    rowB3_Clienti.PROVINCIA = Cursor_wersonbo.GetString("PROVINCIA");
                    /* If mctbstatisv.GoToKey(wersonbo->PAESE) */
                    if (mctbstatisv.GoToKey(Cursor_wersonbo.GetString("PAESE"))) {
                      /* rowB3_Clienti.PAESE := mctbstatisv.CODICENSV // 05.10 */
                      rowB3_Clienti.PAESE = mctbstatisv.row.CODICENSV;
                      /* rowB3_Clienti.PAESEDOM := mctbstatisv.CODICENSV // 05.10 */
                      rowB3_Clienti.PAESEDOM = mctbstatisv.row.CODICENSV;
                    } else { // Else
                      // Transaction Error
                      cTry000000C2msg = CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato");
                      m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                      throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                    } // End If
                    /* rowB3_Clienti.SPECIE := iif(rw_uno.TIPORAP='1','COIN',iif(Empty(wersonbo->PKTBSPECIE),iif(Empty(wersonbo->SESSO),'','PF'),wersonbo->PKTBSPECIE)) // 05.10 */
                    rowB3_Clienti.SPECIE = (CPLib.eqr(rw_uno.TIPORAP,"1")?"COIN":(CPLib.Empty(Cursor_wersonbo.GetString("PKTBSPECIE"))?(CPLib.Empty(Cursor_wersonbo.GetString("SESSO"))?"":"PF"):Cursor_wersonbo.GetString("PKTBSPECIE")));
                  } else { // Else
                    // Exit Loop
                    if (true) {
                      break;
                    }
                  } // End If
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
              } // End If
              /* Se non c'è nessun dato storico prendo quello attuale */
              /* If Empty(rowB3_Clienti.NDG) */
              if (CPLib.Empty(rowB3_Clienti.NDG)) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+""+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"?",0,0,m_cServer, m_oParameters),m_cServer,rw_uno.CODINTER)+"=CONNES "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* rowB3_Clienti.NDG := personbo->CONNES // 05.01 */
                  rowB3_Clienti.NDG = Cursor_personbo.GetString("CONNES");
                  /* rowB3_Clienti.RAGSOC := personbo->RAGSOC // 05.03 */
                  rowB3_Clienti.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  /* rowB3_Clienti.PROV := personbo->PROVINCIA // 05.04 */
                  rowB3_Clienti.PROV = Cursor_personbo.GetString("PROVINCIA");
                  /* rowB3_Clienti.SAE := personbo->SOTGRUP // 05.05 */
                  rowB3_Clienti.SAE = Cursor_personbo.GetString("SOTGRUP");
                  /* rowB3_Clienti.SVT00011 := personbo->SOTGRUP // 05.05 */
                  rowB3_Clienti.SVT00011 = Cursor_personbo.GetString("SOTGRUP");
                  /* rowB3_Clienti.ATECO := personbo->ATTIV // 05.06 */
                  rowB3_Clienti.ATECO = Cursor_personbo.GetString("ATTIV");
                  /* rowB3_Clienti.SVT01118 := iif(Left(personbo->ATTIV,2)='P0','',Left(personbo->ATTIV,2)) // 05.06 */
                  rowB3_Clienti.SVT01118 = (CPLib.eqr(CPLib.Left(Cursor_personbo.GetString("ATTIV"),2),"P0")?"":CPLib.Left(Cursor_personbo.GetString("ATTIV"),2));
                  /* rowB3_Clienti.STATO := personbo->PAESE // 05.10 */
                  rowB3_Clienti.STATO = Cursor_personbo.GetString("PAESE");
                  // * --- Read from personbo_agg
                  m_cServer = m_Ctx.GetServer("personbo_agg");
                  m_cPhName = m_Ctx.GetPhName("personbo_agg");
                  m_cSql = "";
                  m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"C",16,0,m_cServer),m_cServer,rw_uno.CODINTER);
                  if (m_Ctx.IsSharedTemp("personbo_agg")) {
                    m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                  }
                  if (Read_Cursor!=null)
                    Read_Cursor.Close();
                  Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CODCLIEST",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                  if ( ! (Read_Cursor.Eof())) {
                    rowB3_Clienti.CODCLI = Read_Cursor.GetString("CODCLIEST");
                    Read_Cursor.Next();
                    if ( ! (Read_Cursor.Eof())) {
                      Error l_oErrorFault = new Error("Read on personbo_agg into routine arfn_estrai_sv_all returns two or more records. This item should return only a record.");
                      CPStdCounter.Error(l_oErrorFault);
                    }
                    Read_Cursor.Close();
                  } else {
                    // Error: no record found!
                    Read_Cursor.Close();
                    m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                  }
                  /* If Empty(rowB3_Clienti.CODCLI) */
                  if (CPLib.Empty(rowB3_Clienti.CODCLI)) {
                    /* _UniqueId := LibreriaMit.UniqueId() // codice univoco dell'anagrafica */
                    _UniqueId = LibreriaMit.UniqueId();
                    // * --- Write into personbo_agg from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("personbo_agg");
                    m_cPhName = m_Ctx.GetPhName("personbo_agg");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arfn_estrai_sv_all",241,"0000014E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CODCLIEST = "+CPLib.ToSQL(_UniqueId,"C",10,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"?",0,0,m_cServer),m_cServer,rw_uno.CODINTER)+"";
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
                    // * --- Write into wersonbo_agg from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("wersonbo_agg");
                    m_cPhName = m_Ctx.GetPhName("wersonbo_agg");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo_agg",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arfn_estrai_sv_all",241,"0000014F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                    m_cSql = m_cSql+"CODCLIEST = "+CPLib.ToSQL(_UniqueId,"C",10,0,m_cServer)+", ";
                    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"wersonbo_agg",false,true);
                    m_cSql = m_cSql+" where ";
                    m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rw_uno.CODINTER,"?",0,0,m_cServer),m_cServer,rw_uno.CODINTER)+"";
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
                    /* rowB3_Clienti.CODCLI := _UniqueId // 05.10 */
                    rowB3_Clienti.CODCLI = _UniqueId;
                  } // End If
                  /* rowB3_Clienti.COGNOME := personbo->COGNOME // 05.10 */
                  rowB3_Clienti.COGNOME = Cursor_personbo.GetString("COGNOME");
                  /* rowB3_Clienti.NOME := personbo->NOME // 05.10 */
                  rowB3_Clienti.NOME = Cursor_personbo.GetString("NOME");
                  /* rowB3_Clienti.CODFISC := iif(personbo->CFESTERO=1,'',personbo->CODFISC) // 05.10 */
                  rowB3_Clienti.CODFISC = (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)?"":Cursor_personbo.GetString("CODFISC"));
                  /* rowB3_Clienti.CFESTERO := personbo->CFESTERO // 05.10 */
                  rowB3_Clienti.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                  /* rowB3_Clienti.PARTIVA := personbo->PARTIVA // 05.10 */
                  rowB3_Clienti.PARTIVA = Cursor_personbo.GetString("PARTIVA");
                  /* rowB3_Clienti.DATANASC := personbo->DATANASC // 05.10 */
                  rowB3_Clienti.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  /* rowB3_Clienti.COMUNASC := iif(Empty(personbo->SESSO),'',iif(personbo->TIPINTER='EE',personbo->NASSTATO,personbo->NASCOMUN)) // 05.10 */
                  rowB3_Clienti.COMUNASC = (CPLib.Empty(Cursor_personbo.GetString("SESSO"))?"":(CPLib.eqr(Cursor_personbo.GetString("TIPINTER"),"EE")?Cursor_personbo.GetString("NASSTATO"):Cursor_personbo.GetString("NASCOMUN")));
                  /* rowB3_Clienti.PROVNASC := personbo->TIPINTER // 05.10 */
                  rowB3_Clienti.PROVNASC = Cursor_personbo.GetString("TIPINTER");
                  /* If not(Empty(personbo->SESSO)) */
                  if ( ! (CPLib.Empty(Cursor_personbo.GetString("SESSO")))) {
                    /* If mctbstatisv_nasc.GoToKey(iif(personbo->TIPINTER<>'EE','ITALIA',personbo->NASSTATO)) */
                    if (mctbstatisv_nasc.GoToKey((CPLib.ne(Cursor_personbo.GetString("TIPINTER"),"EE")?"ITALIA":Cursor_personbo.GetString("NASSTATO")))) {
                      /* rowB3_Clienti.PAESENASC := mctbstatisv_nasc.CODICENSV // 05.10 */
                      rowB3_Clienti.PAESENASC = mctbstatisv_nasc.row.CODICENSV;
                    } else { // Else
                      // * --- Select from tbstatna
                      m_cServer = m_Ctx.GetServer("tbstatna");
                      m_cPhName = m_Ctx.GetPhName("tbstatna");
                      if (Cursor_tbstatna!=null)
                        Cursor_tbstatna.Close();
                      Cursor_tbstatna = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ISO  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DESCRI="+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tbstatna")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                      while ( ! (Cursor_tbstatna.Eof())) {
                        /* If mctbstatisv_nasc2.GoToKey(iif(personbo->TIPINTER<>'EE','ITA',tbstatna->ISO)) */
                        if (mctbstatisv_nasc2.GoToKey((CPLib.ne(Cursor_personbo.GetString("TIPINTER"),"EE")?"ITA":Cursor_tbstatna.GetString("ISO")))) {
                          /* rowB3_Clienti.PAESENASC := mctbstatisv_nasc2.CODICENSV // 05.10 */
                          rowB3_Clienti.PAESENASC = mctbstatisv_nasc2.row.CODICENSV;
                        } else { // Else
                          // Transaction Error
                          cTry000000C2msg = CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato");
                          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                          throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                        } // End If
                        Cursor_tbstatna.Next();
                      }
                      m_cConnectivityError = Cursor_tbstatna.ErrorMessage();
                      Cursor_tbstatna.Close();
                      // * --- End Select
                    } // End If
                  } // End If
                  /* rowB3_Clienti.SESSO := iif(personbo->SESSO='1','M',iif(personbo->SESSO='2','F',personbo->SESSO)) // 05.10 */
                  rowB3_Clienti.SESSO = (CPLib.eqr(Cursor_personbo.GetString("SESSO"),"1")?"M":(CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":Cursor_personbo.GetString("SESSO")));
                  /* rowB3_Clienti.DESCCIT := personbo->DESCCIT // 05.10 */
                  rowB3_Clienti.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  /* rowB3_Clienti.PROVINCIA := personbo->PROVINCIA // 05.10 */
                  rowB3_Clienti.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  /* If mctbstatisv.GoToKey(personbo->PAESE) */
                  if (mctbstatisv.GoToKey(Cursor_personbo.GetString("PAESE"))) {
                    /* rowB3_Clienti.PAESE := mctbstatisv.CODICENSV // 05.10 */
                    rowB3_Clienti.PAESE = mctbstatisv.row.CODICENSV;
                    /* rowB3_Clienti.PAESEDOM := mctbstatisv.CODICENSV // 05.10 */
                    rowB3_Clienti.PAESEDOM = mctbstatisv.row.CODICENSV;
                  } else { // Else
                    // Transaction Error
                    cTry000000C2msg = CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato");
                    m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                    throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore in ricerca stato"));
                  } // End If
                  /* rowB3_Clienti.SPECIE := iif(rw_uno.TIPORAP='1','COIN',iif(Empty(personbo->PKTBSPECIE),iif(Empty(personbo->SESSO),'','PF'),personbo->PKTBSPECIE)) // 05.10 */
                  rowB3_Clienti.SPECIE = (CPLib.eqr(rw_uno.TIPORAP,"1")?"COIN":(CPLib.Empty(Cursor_personbo.GetString("PKTBSPECIE"))?(CPLib.Empty(Cursor_personbo.GetString("SESSO"))?"":"PF"):Cursor_personbo.GetString("PKTBSPECIE")));
                  // Exit Loop
                  if (true) {
                    break;
                  }
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              /* mcB3_Clienti.AppendRowWithKey(rw_uno.CODINTER,rowB3_Clienti) // File 1 delle SV per IP (SaldiTesoreria.txt) */
              mcB3_Clienti.AppendRowWithKey(rw_uno.CODINTER,rowB3_Clienti);
            } // End If
          }
          /* Chiudo File 1 */
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc+ 'Fine creazione file SaldiTesoreria.txt; '+ arfn_fdatetime(DateTime())+ NL */
          gMsgProc = gMsgProc+"Fine creazione file SaldiTesoreria.txt; "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc+ 'Inizio creazione file MovimentiTesoreria.txt; '+ arfn_fdatetime(DateTime())+ NL */
          gMsgProc = gMsgProc+"Inizio creazione file MovimentiTesoreria.txt; "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* nFile := LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_MovimentiTesoreria.txt" */
          nFile = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_MovimentiTesoreria.txt";
          /* pfname := LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile) */
          pfname = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile);
          onlyfilenames[1] = nFile;
          filenames[1] = pfname;
          /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile)) // Per gestione file */
          fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile));
          // * --- Select from qbe_estrai_sv_all_ip_2_a
          SPBridge.HMCaller _h00000176;
          _h00000176 = new SPBridge.HMCaller();
          _h00000176.Set("m_cVQRList",m_cVQRList);
          _h00000176.Set("pDataINI",_datini);
          _h00000176.Set("pDataFIN",_datfin);
          _h00000176.Set("pSegno","D");
          if (Cursor_qbe_estrai_sv_all_ip_2_a!=null)
            Cursor_qbe_estrai_sv_all_ip_2_a.Close();
          Cursor_qbe_estrai_sv_all_ip_2_a = new VQRHolder("qbe_estrai_sv_all_ip_2_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000176,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_estrai_sv_all_ip_2_a.Eof())) {
            /* _cntOpe := _cntOpe+1 */
            _cntOpe = CPLib.Round(_cntOpe+1,0);
            /* provincia := qbe_estrai_sv_all_ip_2_a->PROVINCIA */
            provincia = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("PROVINCIA");
            /* riga := Space(5) // 04.01 */
            riga = CPLib.Space(5);
            /* riga := riga + LibreriaMit.SpacePad(Upper(qbe_estrai_sv_all_ip_2_a->RAPPORTO),25) // 04.02 */
            riga = riga+LibreriaMit.SpacePad(CPLib.Upper(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("RAPPORTO")),25);
            /* _importo := qbe_estrai_sv_all_ip_2_a->TOTLIRE // nudo e crudo */
            _importo = CPLib.Round(Cursor_qbe_estrai_sv_all_ip_2_a.GetDouble("TOTLIRE"),2);
            /* riga := riga + Str(_importo,12,0) // 04.04 */
            riga = riga+CPLib.Str(_importo,12,0);
            /* 58550 - BONIFICI DISPOSTI DALLA CLIENTELA */
            /* riga := riga + qbe_estrai_sv_all_ip_2_a->SEGNO // 04.04 */
            riga = riga+Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SEGNO");
            /* riga := riga + DateToChar(qbe_estrai_sv_all_ip_2_a->DATAOPE) // 04.05 */
            riga = riga+CPLib.DateToChar(Cursor_qbe_estrai_sv_all_ip_2_a.GetDate("DATAOPE"));
            /* Case qbe_estrai_sv_all_ip_2_a->SV58550='1' */
            if (CPLib.eqr(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550"),"1")) {
              /* -- Provincia della filiale dell’istituto di pagamento presso cui il cliente detiene il conto */
              /* riga := riga + "5855012   " // 04.06 CON MODALITA' TRADIZIONALI */
              riga = riga+"5855012   ";
              /* Case qbe_estrai_sv_all_ip_2_a->SV58550='2' */
            } else if (CPLib.eqr(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550"),"2")) {
              /* -- Provincia della filiale dell’istituto di pagamento presso cui il cliente detiene il conto */
              /* riga := riga + "5855036   " // 04.06 SUPPORTI MAGNETICI E A.T.M. */
              riga = riga+"5855036   ";
              /* Case qbe_estrai_sv_all_ip_2_a->SV58550='3' */
            } else if (CPLib.eqr(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550"),"3")) {
              /* -- Provincia della filiale dell’istituto di pagamento presso cui il cliente detiene il conto */
              /* riga := riga + "5855044   " // 04.06 COLLEGAMENTI TELEMATICI O TELEFONICI (DIVERSI DA INTERNET) */
              riga = riga+"5855044   ";
              /* Case qbe_estrai_sv_all_ip_2_a->SV58550='4' */
            } else if (CPLib.eqr(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550"),"4")) {
              /* -- Provincia di residenza del cliente */
              // * --- Select from qbe_estrai_sv_all_ip_2_prov
              SPBridge.HMCaller _h00000188;
              _h00000188 = new SPBridge.HMCaller();
              _h00000188.Set("m_cVQRList",m_cVQRList);
              _h00000188.Set("pRAPPORTO",Cursor_qbe_estrai_sv_all_ip_2_a.GetString("RAPPORTO"));
              if (Cursor_qbe_estrai_sv_all_ip_2_prov!=null)
                Cursor_qbe_estrai_sv_all_ip_2_prov.Close();
              Cursor_qbe_estrai_sv_all_ip_2_prov = new VQRHolder("qbe_estrai_sv_all_ip_2_prov",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000188,true).GetResultSet(m_Ctx);
              while ( ! (Cursor_qbe_estrai_sv_all_ip_2_prov.Eof())) {
                /* provincia := qbe_estrai_sv_all_ip_2_prov->PROVINCIA */
                provincia = Cursor_qbe_estrai_sv_all_ip_2_prov.GetString("PROVINCIA");
                // Exit Loop
                if (true) {
                  break;
                }
                Cursor_qbe_estrai_sv_all_ip_2_prov.Next();
              }
              m_cConnectivityError = Cursor_qbe_estrai_sv_all_ip_2_prov.ErrorMessage();
              Cursor_qbe_estrai_sv_all_ip_2_prov.Close();
              // * --- End Select
              /* riga := riga + "5855052   " // 04.06 INTERNET */
              riga = riga+"5855052   ";
            } else { // Otherwise
              /* -- In questo caso non ci dovrebbe mai cadere */
              /* riga := riga + Space(10) // 04.06 */
              riga = riga+CPLib.Space(10);
            } // End Case
            /* riga := riga +"0001" // 04.07 */
            riga = riga+"0001";
            /* riga := riga + qbe_estrai_sv_all_ip_2_a->PAESE // 04.08 */
            riga = riga+Cursor_qbe_estrai_sv_all_ip_2_a.GetString("PAESE");
            /* riga := riga +iif(qbe_estrai_sv_all_ip_2_a->SV58550MA<>'67' and qbe_estrai_sv_all_ip_2_a->SV58550MA<>'68', '  ',qbe_estrai_sv_all_ip_2_a->SV58550MA) // 04.09 - Modalità di Avvio (67 file batch - 68 disposizione singola) */
            riga = riga+(CPLib.ne(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550MA"),"67") && CPLib.ne(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550MA"),"68")?"  ":Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550MA"));
            /* riga := riga +provincia // 04.10 - Provincia di esecuzione (nel caso in cui l'operazione ha come causale INTERNET è la provicia di residenza del cliente) */
            riga = riga+provincia;
            /* riga := riga +iif(qbe_estrai_sv_all_ip_2_a->valuta='242', '1','2')+qbe_estrai_sv_all_ip_2_a->valuta // 04.11 - FLAG + Valuta */
            riga = riga+(CPLib.eqr(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("valuta"),"242")?"1":"2")+Cursor_qbe_estrai_sv_all_ip_2_a.GetString("valuta");
            /* riga := riga +qbe_estrai_sv_all_ip_2_a->SV58726SA // 04.13 - Schema di Addebito */
            riga = riga+Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58726SA");
            /* riga := riga +qbe_estrai_sv_all_ip_2_a->SV58726PISP // 04.14 - PISP */
            riga = riga+Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58726PISP");
            /* riga := riga +iif(qbe_estrai_sv_all_ip_2_a->SV58726SCA='S','F','N') // 04.15 - Autenticazione Forte */
            riga = riga+(CPLib.eqr(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58726SCA"),"S")?"F":"N");
            /* riga := riga +iif(qbe_estrai_sv_all_ip_2_a->SV58550='4','I','A') // 04.16 - Modalità Autenticazione */
            riga = riga+(CPLib.eqr(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550"),"4")?"I":"A");
            /* FileLibMit.WriteLine(fhand,riga) */
            FileLibMit.WriteLine(fhand,riga);
            Cursor_qbe_estrai_sv_all_ip_2_a.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_sv_all_ip_2_a.ErrorMessage();
          Cursor_qbe_estrai_sv_all_ip_2_a.Close();
          // * --- End Select
          /* If pTri=2 or pTri=4 */
          if (CPLib.eqr(pTri,2) || CPLib.eqr(pTri,4)) {
            // * --- Select from qbe_estrai_sv_all_ip_2_a
            SPBridge.HMCaller _h0000019A;
            _h0000019A = new SPBridge.HMCaller();
            _h0000019A.Set("m_cVQRList",m_cVQRList);
            _h0000019A.Set("pDataINI",_datinisem);
            _h0000019A.Set("pDataFIN",_datfinsem);
            _h0000019A.Set("pSegno","A");
            if (Cursor_qbe_estrai_sv_all_ip_2_a!=null)
              Cursor_qbe_estrai_sv_all_ip_2_a.Close();
            Cursor_qbe_estrai_sv_all_ip_2_a = new VQRHolder("qbe_estrai_sv_all_ip_2_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000019A,true).GetResultSet(m_Ctx);
            while ( ! (Cursor_qbe_estrai_sv_all_ip_2_a.Eof())) {
              /* _cntOpe := _cntOpe+1 */
              _cntOpe = CPLib.Round(_cntOpe+1,0);
              /* provincia := qbe_estrai_sv_all_ip_2_a->PROVINCIA */
              provincia = Cursor_qbe_estrai_sv_all_ip_2_a.GetString("PROVINCIA");
              /* riga := Space(5) // 04.01 */
              riga = CPLib.Space(5);
              /* riga := riga + LibreriaMit.SpacePad(Upper(qbe_estrai_sv_all_ip_2_a->RAPPORTO),25) // 04.02 */
              riga = riga+LibreriaMit.SpacePad(CPLib.Upper(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("RAPPORTO")),25);
              /* _importo := qbe_estrai_sv_all_ip_2_a->TOTLIRE // nudo e crudo */
              _importo = CPLib.Round(Cursor_qbe_estrai_sv_all_ip_2_a.GetDouble("TOTLIRE"),2);
              /* riga := riga + Str(_importo,12,0) // 04.04 */
              riga = riga+CPLib.Str(_importo,12,0);
              /* 58555 - BONIFICI RICEVUTI DALLA PROPRIA CLIENTELA */
              /* riga := riga + qbe_estrai_sv_all_ip_2_a->SEGNO // 04.04 */
              riga = riga+Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SEGNO");
              /* riga := riga + DateToChar(qbe_estrai_sv_all_ip_2_a->DATAOPE) // 04.05 */
              riga = riga+CPLib.DateToChar(Cursor_qbe_estrai_sv_all_ip_2_a.GetDate("DATAOPE"));
              /* riga := riga + "5855504   " // 04.06 CON MODALITA' TRADIZIONALI */
              riga = riga+"5855504   ";
              /* riga := riga +"0001" // 04.07 */
              riga = riga+"0001";
              /* riga := riga + qbe_estrai_sv_all_ip_2_a->PAESE // 04.08 */
              riga = riga+Cursor_qbe_estrai_sv_all_ip_2_a.GetString("PAESE");
              /* riga := riga +iif(qbe_estrai_sv_all_ip_2_a->SV58550MA<>'67' and qbe_estrai_sv_all_ip_2_a->SV58550MA<>'68', '  ',qbe_estrai_sv_all_ip_2_a->SV58550MA) // 04.09 - Modalità di Avvio (67 file batch - 68 disposizione singola) */
              riga = riga+(CPLib.ne(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550MA"),"67") && CPLib.ne(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550MA"),"68")?"  ":Cursor_qbe_estrai_sv_all_ip_2_a.GetString("SV58550MA"));
              /* riga := riga +provincia // 04.10 - Provincia di esecuzione (nel caso in cui l'operazione ha come causale INTERNET è la provicia di residenza del cliente) */
              riga = riga+provincia;
              /* riga := riga +iif(qbe_estrai_sv_all_ip_2_a->valuta='242', '1','2')+qbe_estrai_sv_all_ip_2_a->valuta // 04.11 - FLAG + Valuta */
              riga = riga+(CPLib.eqr(Cursor_qbe_estrai_sv_all_ip_2_a.GetString("valuta"),"242")?"1":"2")+Cursor_qbe_estrai_sv_all_ip_2_a.GetString("valuta");
              /* FileLibMit.WriteLine(fhand,riga) */
              FileLibMit.WriteLine(fhand,riga);
              Cursor_qbe_estrai_sv_all_ip_2_a.Next();
            }
            m_cConnectivityError = Cursor_qbe_estrai_sv_all_ip_2_a.ErrorMessage();
            Cursor_qbe_estrai_sv_all_ip_2_a.Close();
            // * --- End Select
          } // End If
          /* Chiudo File 2 */
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc+ 'Fine creazione file MovimentiTesoreria.txt; '+ arfn_fdatetime(DateTime())+ NL */
          gMsgProc = gMsgProc+"Fine creazione file MovimentiTesoreria.txt; "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc+ 'Inizio creazione file Clienti.txt; '+ arfn_fdatetime(DateTime())+ NL */
          gMsgProc = gMsgProc+"Inizio creazione file Clienti.txt; "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* nFile := LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_Clienti.txt" */
          nFile = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_Clienti.txt";
          onlyfilenames[2] = nFile;
          /* pfname := LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile) */
          pfname = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile);
          filenames[2] = pfname;
          /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile)) // Per gestione file */
          fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile));
          for (MemoryCursorRow_mcestraisv_clienti_mcrdef rw_cli : mcB3_Clienti._iterable_()) {
            /* riga :=  LibreriaMit.SpacePad(rw_cli.NDG,16) // 05.01 */
            riga = LibreriaMit.SpacePad(rw_cli.NDG,16);
            /* riga := riga + Space(13) // 05.02 */
            riga = riga+CPLib.Space(13);
            /* riga := riga + LibreriaMit.SpacePad(rw_cli.RAGSOC,50) // 05.03 */
            riga = riga+LibreriaMit.SpacePad(rw_cli.RAGSOC,50);
            /* riga := riga + LibreriaMit.SpacePad(rw_cli.PROV,2) // 05.04 */
            riga = riga+LibreriaMit.SpacePad(rw_cli.PROV,2);
            /* riga := riga + LibreriaMit.SpacePad(rw_cli.SAE,4) // 05.05 */
            riga = riga+LibreriaMit.SpacePad(rw_cli.SAE,4);
            /* riga := riga + LibreriaMit.SpacePad(Substr(rw_cli.ATECO,1,5),4) // 05.06 */
            riga = riga+LibreriaMit.SpacePad(CPLib.Substr(rw_cli.ATECO,1,5),4);
            /* riga := riga + Space(8) // 05.07 */
            riga = riga+CPLib.Space(8);
            /* riga := riga + Space(8) // 05.08 */
            riga = riga+CPLib.Space(8);
            /* riga := riga + Space(8) // 05.09 */
            riga = riga+CPLib.Space(8);
            /* riga := riga + LibreriaMit.SpacePad(rw_cli.STATO,3) // 05.05 */
            riga = riga+LibreriaMit.SpacePad(rw_cli.STATO,3);
            /* FileLibMit.WriteLine(fhand,riga) */
            FileLibMit.WriteLine(fhand,riga);
          }
          /* Chiudo File 3 */
          /* FileLibMit.Close(fhand) */
          FileLibMit.Close(fhand);
          /* gMsgProc := gMsgProc+ 'Fine creazione file Clienti.txt; '+ arfn_fdatetime(DateTime())+ NL */
          gMsgProc = gMsgProc+"Fine creazione file Clienti.txt; "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc+ 'Inizio creazione file Clienti.CSV; '+ arfn_fdatetime(DateTime())+ NL */
          gMsgProc = gMsgProc+"Inizio creazione file Clienti.CSV; "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* nFile := 'RANACLI.csv' */
          nFile = "RANACLI.csv";
          onlyfilenames[3] = nFile;
          /* pfname := LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile) */
          pfname = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile);
          filenames[3] = pfname;
          /* writer := new BufferedWriter(Files.newBufferedWriter(Paths.get(LRTrim(gPathDoc)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile)))) // Per scrivere il csv */
          writer = new BufferedWriter(Files.newBufferedWriter(Paths.get(CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile))));
          /* csvPrinter := new CSVPrinter(writer, CSVFormat.EXCEL.withHeader('CODCLI','RAGSOC','COGNOME','NOME','CODFISC','PARTIVA','DATANASC','CAPNASC','COMUNASC','PROVNASC','PAESENASC','SESSO','INDRESID','CAPRESID','DESCCIT','PROVINCIA','PAESE','INDDOMIC','CAPDOMIC','DESCDOM','PROVDOM','PAESEDOM','SPECIE','TELEF','FAX','EMAIL','SVGRUPPO','SVT01118','SVPMI','NUMCR','SVT00353','SVT00011','CLINVREN','SVTIPOSCAD','SVTIPOINAD','SVT00353GA','CCIAA','LEI','CONNES','CFESTERO').withDelimiter(delimitatore)) */
          csvPrinter = new CSVPrinter(writer,CSVFormat.EXCEL.withHeader("CODCLI","RAGSOC","COGNOME","NOME","CODFISC","PARTIVA","DATANASC","CAPNASC","COMUNASC","PROVNASC","PAESENASC","SESSO","INDRESID","CAPRESID","DESCCIT","PROVINCIA","PAESE","INDDOMIC","CAPDOMIC","DESCDOM","PROVDOM","PAESEDOM","SPECIE","TELEF","FAX","EMAIL","SVGRUPPO","SVT01118","SVPMI","NUMCR","SVT00353","SVT00011","CLINVREN","SVTIPOSCAD","SVTIPOINAD","SVT00353GA","CCIAA","LEI","CONNES","CFESTERO").withDelimiter(delimitatore));
          for (MemoryCursorRow_mcestraisv_clienti_mcrdef rw_cli : mcB3_Clienti._iterable_()) {
            /* csvPrinter.printRecord(rw_cli.CODCLI,rw_cli.RAGSOC,rw_cli.COGNOME,rw_cli.NOME,rw_cli.CODFISC,rw_cli.PARTIVA,iif(Empty(rw_cli.DATANASC),'',DateToChar(rw_cli.DATANASC)),rw_cli.CAPNASC,rw_cli.COMUNASC,rw_cli.PROVNASC,rw_cli.PAESENASC,rw_cli.SESSO,rw_cli.INDRESID,rw_cli.CAPRESID,rw_cli.DESCCIT,rw_cli.PROVINCIA,rw_cli.PAESE,rw_cli.INDDOMIC,rw_cli.CAPDOMIC,rw_cli.DESCDOM,rw_cli.PROVDOM,rw_cli.PAESEDOM,rw_cli.SPECIE,rw_cli.TELEF,rw_cli.FAX,rw_cli.EMAIL,rw_cli.SVGRUPPO,rw_cli.SVT01118,Str(rw_cli.SVPMI,1,0),rw_cli.NUMCR,rw_cli.SVT00353,rw_cli.SVT00011,rw_cli.CLINVREN,rw_cli.SVTIPOSCAD,rw_cli.SVTIPOINAD,rw_cli.SVT00353GA,rw_cli.CCIAA,rw_cli.LEI,rw_cli.NDG,Str(rw_cli.CFESTERO,1,0)) */
            csvPrinter.printRecord(rw_cli.CODCLI,rw_cli.RAGSOC,rw_cli.COGNOME,rw_cli.NOME,rw_cli.CODFISC,rw_cli.PARTIVA,(CPLib.Empty(rw_cli.DATANASC)?"":CPLib.DateToChar(rw_cli.DATANASC)),rw_cli.CAPNASC,rw_cli.COMUNASC,rw_cli.PROVNASC,rw_cli.PAESENASC,rw_cli.SESSO,rw_cli.INDRESID,rw_cli.CAPRESID,rw_cli.DESCCIT,rw_cli.PROVINCIA,rw_cli.PAESE,rw_cli.INDDOMIC,rw_cli.CAPDOMIC,rw_cli.DESCDOM,rw_cli.PROVDOM,rw_cli.PAESEDOM,rw_cli.SPECIE,rw_cli.TELEF,rw_cli.FAX,rw_cli.EMAIL,rw_cli.SVGRUPPO,rw_cli.SVT01118,CPLib.Str(rw_cli.SVPMI,1,0),rw_cli.NUMCR,rw_cli.SVT00353,rw_cli.SVT00011,rw_cli.CLINVREN,rw_cli.SVTIPOSCAD,rw_cli.SVTIPOINAD,rw_cli.SVT00353GA,rw_cli.CCIAA,rw_cli.LEI,rw_cli.NDG,CPLib.Str(rw_cli.CFESTERO,1,0));
          }
          /* csvPrinter.flush() */
          csvPrinter.flush();
          /* gMsgProc := gMsgProc+ 'Fine creazione file Clienti.CSV; '+ arfn_fdatetime(DateTime())+ NL */
          gMsgProc = gMsgProc+"Fine creazione file Clienti.CSV; "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc+ 'Fine Elaborazione Base3 per IP '+ NL */
          gMsgProc = gMsgProc+"Fine Elaborazione Base3 per IP "+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* nFile := LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_3B_SV_"+iif(pTri<5,"Q"+Str(pTri,1,0), iif(pTri=5,"S1","S2")) */
          nFile = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_3B_SV_"+(CPLib.lt(pTri,5)?"Q"+CPLib.Str(pTri,1,0):(CPLib.eqr(pTri,5)?"S1":"S2"));
          /* gMsgProc := gMsgProc+ 'Inizio creazione file ZIP'+ NL */
          gMsgProc = gMsgProc+"Inizio creazione file ZIP"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* cNomeFileZip := LRTrim(nFile)+'.zip' */
          cNomeFileZip = CPLib.LRTrim(nFile)+".zip";
          /* cNomeZip := LRTrim(gPathDoc)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(cNomeFileZip) */
          cNomeZip = CPLib.LRTrim(gPathDoc)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cNomeFileZip);
          /* Exec "Creazione ZIP" Page 4:Page_ZIP */
          Page_ZIP();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          /* gMsgProc := gMsgProc+ 'Fine creazione file ZIP'+ NL */
          gMsgProc = gMsgProc+"Fine creazione file ZIP"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* cProg := Utilities.GetAutonumber("PSTPMAV\'"+LRTrim(gAzienda)+"'","",10) */
          cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTPMAV\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
          // * --- Insert into cgo_stampeav from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_stampeav");
          m_cPhName = m_Ctx.GetPhName("cgo_stampeav");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_stampeav",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_estrai_sv_all",241,"000001D8")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000001D8(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(gCodDip,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(cNomeZip,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_stampeav",true);
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
          /* cRitorno := cProg */
          cRitorno = cProg;
          /* gMsgProc := gMsgProc + 'Sono stati scritti: ' + LRTrim(Str(conta,10,0)) + ' rapporti' + NL */
          gMsgProc = gMsgProc+"Sono stati scritti: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" rapporti"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Sono stati scritti: ' + mcB3_Clienti.RecCount() + ' soggetti' + NL */
          gMsgProc = gMsgProc+"Sono stati scritti: "+mcB3_Clienti.RecCount()+" soggetti"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Sono stati scritte: ' + LRTrim(Str(_cntOpe,10,0)) + ' operazioni' + NL */
          gMsgProc = gMsgProc+"Sono stati scritte: "+CPLib.LRTrim(CPLib.Str(_cntOpe,10,0))+" operazioni"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'Elaborazione completata con successo!' // Messaggio Import */
          gMsgImp = "Elaborazione completata con successo!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* cRitorno := 'KO' */
          cRitorno = "KO";
          /* gMsgProc := gMsgProc + 'Elaborazione non portata a termine' + NL */
          gMsgProc = gMsgProc+"Elaborazione non portata a termine"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := 'Elaborazione abortita!' // Messaggio Import */
          gMsgImp = "Elaborazione abortita!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000C2status,0)) {
            m_Sql.SetTransactionStatus(nTry000000C2status,cTry000000C2msg);
          }
        }
      } else { // Else
        /* gMsgProc := gMsgProc + 'Sono assenti i saldi per i seguenti rapporti:' + NL */
        gMsgProc = gMsgProc+"Sono assenti i saldi per i seguenti rapporti:"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        for (MemoryCursorRow_qbe_sv_idp_rapporti_vqr rwRapporti : mcRapporti._iterable_()) {
          /* gMsgProc := gMsgProc + LRTrim(rwRapporti.RAPPORTO) +" - "+ LRTrim(rwRapporti.DESCRAP) + NL */
          gMsgProc = gMsgProc+CPLib.LRTrim(rwRapporti.RAPPORTO)+" - "+CPLib.LRTrim(rwRapporti.DESCRAP)+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        }
        /* cRitorno := 'KO' */
        cRitorno = "KO";
        /* gMsgProc := gMsgProc + 'Elaborazione non portata a termine' + NL */
        gMsgProc = gMsgProc+"Elaborazione non portata a termine"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione abortita!' // Messaggio Import */
        gMsgImp = "Elaborazione abortita!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } // End If
    } finally {
      try {
        if (Cursor_tbstatisv!=null)
          Cursor_tbstatisv.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_sv_idp_rapporti!=null)
          Cursor_qbe_sv_idp_rapporti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_all_ip_1!=null)
          Cursor_qbe_estrai_sv_all_ip_1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_rapopebo!=null)
          Cursor_rapopebo.Close();
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
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbstatna!=null)
          Cursor_tbstatna.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_all_ip_2_a!=null)
          Cursor_qbe_estrai_sv_all_ip_2_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_all_ip_2_prov!=null)
          Cursor_qbe_estrai_sv_all_ip_2_prov.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_ZIP() throws Exception {
    // These are the files to include in the ZIP file
    //  String[] filenames = new String[]{pfname};
        
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(onlyfilenames[i]));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
            }
        
            // Complete the ZIP file
            out.close();
        } catch (java.io.IOException e) {
        }
    
  }
  void _init_() {
  }
  public String RunAsync(double p_pAnno,double p_pTri,String p_pSegno,String p_pLCC,String p_pTipoBase3,String p_pFraudo) {
    pAnno = p_pAnno;
    pTri = p_pTri;
    pSegno = p_pSegno;
    pLCC = p_pLCC;
    pTipoBase3 = p_pTipoBase3;
    pFraudo = p_pFraudo;
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
  public String Run(double p_pAnno,double p_pTri,String p_pSegno,String p_pLCC,String p_pTipoBase3,String p_pFraudo) {
    pAnno = p_pAnno;
    pTri = p_pTri;
    pSegno = p_pSegno;
    pLCC = p_pLCC;
    pTipoBase3 = p_pTipoBase3;
    pFraudo = p_pFraudo;
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
  public static arfn_estrai_sv_allR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_estrai_sv_allR(p_Ctx, p_Caller);
  }
  public static arfn_estrai_sv_allR Make(CPContext p_Ctx) {
    return new arfn_estrai_sv_allR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAnno = 0;
    pTri = 0;
    pSegno = CPLib.Space(1);
    pLCC = CPLib.Space(1);
    pTipoBase3 = CPLib.Space(4);
    pFraudo = CPLib.Space(1);
    _datini = CPLib.Space(8);
    _datfin = CPLib.Space(8);
    _datinisem = CPLib.Space(8);
    _datfinsem = CPLib.Space(8);
    cRitorno = CPLib.Space(20);
    fhand = CPLib.Space(1);
    riga = "";
    nFile = CPLib.Space(20);
    conta = 0;
    cNomeFileZip = CPLib.Space(30);
    cNomeZip = CPLib.Space(128);
    fname = CPLib.Space(25);
    pfname = CPLib.Space(128);
    _importo = 0;
    _importodef = 0;
    mcB3_SaldiTesoreria = new MemoryCursor_qbe_estrai_sv_all_ip_1_vqr();
    mcB3_Clienti = new MemoryCursor_mcestraisv_clienti_mcrdef();
    rowB3_Clienti = new MemoryCursorRow_mcestraisv_clienti_mcrdef();
    mcRapporti = new MemoryCursor_qbe_sv_idp_rapporti_vqr();
    provincia = CPLib.Space(2);
    str_appo = CPLib.Space(0);
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    cProg = CPLib.Space(10);
    _cntOpe = CPLib.Round(0,0);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_estrai_sv_wu,qbe_agg_flagfraud_ope,qbe_estrai_sv_wu_fraud,qbe_estrai_sv_only_fraud,qbe_sv_idp_rapporti,qbe_estrai_sv_all_ip_1,qbe_estrai_sv_all_ip_2_a,qbe_estrai_sv_all_ip_2_prov,qbe_estrai_sv_all_ip_2_a,
  public static final String m_cVQRList = ",qbe_estrai_sv_wu,qbe_agg_flagfraud_ope,qbe_estrai_sv_wu_fraud,qbe_estrai_sv_only_fraud,qbe_sv_idp_rapporti,qbe_estrai_sv_all_ip_1,qbe_estrai_sv_all_ip_2_a,qbe_estrai_sv_all_ip_2_prov,qbe_estrai_sv_all_ip_2_a,";
  // ENTITY_BATCHES: ,arfn_estrai_sv_all,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_estrai_sv_all,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pAnno","pTri","pSegno","pLCC","pTipoBase3","pFraudo"};
  protected static String GetFieldsName_000000A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ESCODICE,";
    p_cSql = p_cSql+"ESCODDIP,";
    p_cSql = p_cSql+"ESDATREP,";
    p_cSql = p_cSql+"ESNUMREP,";
    p_cSql = p_cSql+"ESNOMREP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_stampeav",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001D8(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ESCODICE,";
    p_cSql = p_cSql+"ESCODDIP,";
    p_cSql = p_cSql+"ESDATREP,";
    p_cSql = p_cSql+"ESNUMREP,";
    p_cSql = p_cSql+"ESNOMREP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_stampeav",true);
    return p_cSql;
  }
}
