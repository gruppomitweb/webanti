// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_cgo_moduli_testR implements CallerWithObjs {
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
  public String m_cPhName_tmp_cgo_operazioni;
  public String m_cServer_tmp_cgo_operazioni;
  public String m_cPhName_cgo_stampeav;
  public String m_cServer_cgo_stampeav;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
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
  public String w_STATOREG;
  public String w_IDBASE;
  public String w_NUMPROG;
  public String w_DESCRI;
  public String w_CITINT;
  public String w_CITDIP;
  public String w_PROVDIP;
  public String w_CABDIP;
  public String w_PROVINT;
  public String w_CABINT;
  public String w_TIPOPERS;
  public String w_MEZPAGAM;
  public String w_IBAN;
  public double w_CFESTERO;
  public String w_CODFISC;
  public String w_COGNOME;
  public String w_NOME;
  public String w_RAGSOC;
  public String w_DESCCIT;
  public String w_PROVINCIA;
  public String w_CAP;
  public String w_CODCAB;
  public String w_DOMICILIO;
  public String w_PAESE;
  public String w_NASCOMUN;
  public String w_TIPINTER;
  public String w_SESSO;
  public String w_NASSTATO;
  public java.sql.Date w_DATANASC;
  public String w_TIPODOC;
  public String w_NUMDOCUM;
  public java.sql.Date w_DATARILASC;
  public java.sql.Date w_DATAVALI;
  public String w_AUTRILASC;
  public String w_SOTGRUP;
  public String w_RAMOGRUP;
  public String w_SETTSINT;
  public String w_PEP;
  public String w_SNAINUMOPE;
  public java.sql.Date w_DATAOPE;
  public java.sql.Date w_DATAREG;
  public String w_FLAGCONT;
  public String w_TIPOOPRAP;
  public String w_CODANA;
  public String w_CODVOC;
  public String w_VALUTA;
  public double w_CAMBIO;
  public String w_CONNESCLI;
  public String w_CONNESBEN;
  public String w_C_RAG;
  public String w_C_CTA;
  public String w_C_PRV;
  public String w_C_CAP;
  public String w_C_CAB;
  public String w_C_IND;
  public String w_C_STA;
  public String w_CODINTER;
  public String w_CODDIPE;
  public String w_DESCCITDIP;
  public String w_SEGNO;
  public String w_FLAGFRAZ;
  public String w_COLLEG;
  public String w_PROVINCIADIP;
  public String w_CODCABDIP;
  public double w_TOTLIRE;
  public double w_TOTCONT;
  public double w_CACODICE;
  public String w_CAIDBIGLIETTO;
  public String w_CAFLGOPE;
  public String w_ATTIV;
  public String w_MIDBIGLIETTO;
  public String w_CODTRANSZ;
  public String cProg;
  public ReportLibrary _report;
  public boolean bReport;
  public String _ra1;
  public String _ra2;
  public String filename;
  public String filepdf;
  public String stringa;
  public String _flgstpd;
  public String _urldef;
  public String _pagam;
  public String _mpagam;
  public String _modello;
  public String _concessione;
  public String gUrlApp;
  public String gPathApp;
  public String gAzienda;
  public String gIPC;
  public String gIPS;
  public String gIPSP;
  public String gCodDip;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_cgo_moduli_testR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_moduli_test",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_operazioni")) {
      m_cPhName_tmp_cgo_operazioni = p_ContextObject.GetPhName("tmp_cgo_operazioni");
      if (m_cPhName_tmp_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_cgo_operazioni = m_cPhName_tmp_cgo_operazioni+" "+m_Ctx.GetWritePhName("tmp_cgo_operazioni");
      }
      m_cServer_tmp_cgo_operazioni = p_ContextObject.GetServer("tmp_cgo_operazioni");
    }
    m_cPhName_cgo_stampeav = p_ContextObject.GetPhName("cgo_stampeav");
    if (m_cPhName_cgo_stampeav.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_stampeav = m_cPhName_cgo_stampeav+" "+m_Ctx.GetWritePhName("cgo_stampeav");
    }
    m_cServer_cgo_stampeav = p_ContextObject.GetServer("cgo_stampeav");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("CFESTERO",p_cVarName)) {
      return w_CFESTERO;
    }
    if (CPLib.eqr("CAMBIO",p_cVarName)) {
      return w_CAMBIO;
    }
    if (CPLib.eqr("TOTLIRE",p_cVarName)) {
      return w_TOTLIRE;
    }
    if (CPLib.eqr("TOTCONT",p_cVarName)) {
      return w_TOTCONT;
    }
    if (CPLib.eqr("CACODICE",p_cVarName)) {
      return w_CACODICE;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_moduli_test";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("STATOREG",p_cVarName)) {
      return w_STATOREG;
    }
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      return w_IDBASE;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      return w_NUMPROG;
    }
    if (CPLib.eqr("DESCRI",p_cVarName)) {
      return w_DESCRI;
    }
    if (CPLib.eqr("CITINT",p_cVarName)) {
      return w_CITINT;
    }
    if (CPLib.eqr("CITDIP",p_cVarName)) {
      return w_CITDIP;
    }
    if (CPLib.eqr("PROVDIP",p_cVarName)) {
      return w_PROVDIP;
    }
    if (CPLib.eqr("CABDIP",p_cVarName)) {
      return w_CABDIP;
    }
    if (CPLib.eqr("PROVINT",p_cVarName)) {
      return w_PROVINT;
    }
    if (CPLib.eqr("CABINT",p_cVarName)) {
      return w_CABINT;
    }
    if (CPLib.eqr("TIPOPERS",p_cVarName)) {
      return w_TIPOPERS;
    }
    if (CPLib.eqr("MEZPAGAM",p_cVarName)) {
      return w_MEZPAGAM;
    }
    if (CPLib.eqr("IBAN",p_cVarName)) {
      return w_IBAN;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      return w_CODFISC;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      return w_COGNOME;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      return w_NOME;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      return w_RAGSOC;
    }
    if (CPLib.eqr("DESCCIT",p_cVarName)) {
      return w_DESCCIT;
    }
    if (CPLib.eqr("PROVINCIA",p_cVarName)) {
      return w_PROVINCIA;
    }
    if (CPLib.eqr("CAP",p_cVarName)) {
      return w_CAP;
    }
    if (CPLib.eqr("CODCAB",p_cVarName)) {
      return w_CODCAB;
    }
    if (CPLib.eqr("DOMICILIO",p_cVarName)) {
      return w_DOMICILIO;
    }
    if (CPLib.eqr("PAESE",p_cVarName)) {
      return w_PAESE;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      return w_NASCOMUN;
    }
    if (CPLib.eqr("TIPINTER",p_cVarName)) {
      return w_TIPINTER;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      return w_SESSO;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      return w_NASSTATO;
    }
    if (CPLib.eqr("TIPODOC",p_cVarName)) {
      return w_TIPODOC;
    }
    if (CPLib.eqr("NUMDOCUM",p_cVarName)) {
      return w_NUMDOCUM;
    }
    if (CPLib.eqr("AUTRILASC",p_cVarName)) {
      return w_AUTRILASC;
    }
    if (CPLib.eqr("SOTGRUP",p_cVarName)) {
      return w_SOTGRUP;
    }
    if (CPLib.eqr("RAMOGRUP",p_cVarName)) {
      return w_RAMOGRUP;
    }
    if (CPLib.eqr("SETTSINT",p_cVarName)) {
      return w_SETTSINT;
    }
    if (CPLib.eqr("PEP",p_cVarName)) {
      return w_PEP;
    }
    if (CPLib.eqr("SNAINUMOPE",p_cVarName)) {
      return w_SNAINUMOPE;
    }
    if (CPLib.eqr("FLAGCONT",p_cVarName)) {
      return w_FLAGCONT;
    }
    if (CPLib.eqr("TIPOOPRAP",p_cVarName)) {
      return w_TIPOOPRAP;
    }
    if (CPLib.eqr("CODANA",p_cVarName)) {
      return w_CODANA;
    }
    if (CPLib.eqr("CODVOC",p_cVarName)) {
      return w_CODVOC;
    }
    if (CPLib.eqr("VALUTA",p_cVarName)) {
      return w_VALUTA;
    }
    if (CPLib.eqr("CONNESCLI",p_cVarName)) {
      return w_CONNESCLI;
    }
    if (CPLib.eqr("CONNESBEN",p_cVarName)) {
      return w_CONNESBEN;
    }
    if (CPLib.eqr("C_RAG",p_cVarName)) {
      return w_C_RAG;
    }
    if (CPLib.eqr("C_CTA",p_cVarName)) {
      return w_C_CTA;
    }
    if (CPLib.eqr("C_PRV",p_cVarName)) {
      return w_C_PRV;
    }
    if (CPLib.eqr("C_CAP",p_cVarName)) {
      return w_C_CAP;
    }
    if (CPLib.eqr("C_CAB",p_cVarName)) {
      return w_C_CAB;
    }
    if (CPLib.eqr("C_IND",p_cVarName)) {
      return w_C_IND;
    }
    if (CPLib.eqr("C_STA",p_cVarName)) {
      return w_C_STA;
    }
    if (CPLib.eqr("CODINTER",p_cVarName)) {
      return w_CODINTER;
    }
    if (CPLib.eqr("CODDIPE",p_cVarName)) {
      return w_CODDIPE;
    }
    if (CPLib.eqr("DESCCITDIP",p_cVarName)) {
      return w_DESCCITDIP;
    }
    if (CPLib.eqr("SEGNO",p_cVarName)) {
      return w_SEGNO;
    }
    if (CPLib.eqr("FLAGFRAZ",p_cVarName)) {
      return w_FLAGFRAZ;
    }
    if (CPLib.eqr("COLLEG",p_cVarName)) {
      return w_COLLEG;
    }
    if (CPLib.eqr("PROVINCIADIP",p_cVarName)) {
      return w_PROVINCIADIP;
    }
    if (CPLib.eqr("CODCABDIP",p_cVarName)) {
      return w_CODCABDIP;
    }
    if (CPLib.eqr("CAIDBIGLIETTO",p_cVarName)) {
      return w_CAIDBIGLIETTO;
    }
    if (CPLib.eqr("CAFLGOPE",p_cVarName)) {
      return w_CAFLGOPE;
    }
    if (CPLib.eqr("ATTIV",p_cVarName)) {
      return w_ATTIV;
    }
    if (CPLib.eqr("MIDBIGLIETTO",p_cVarName)) {
      return w_MIDBIGLIETTO;
    }
    if (CPLib.eqr("CODTRANSZ",p_cVarName)) {
      return w_CODTRANSZ;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_ra1",p_cVarName)) {
      return _ra1;
    }
    if (CPLib.eqr("_ra2",p_cVarName)) {
      return _ra2;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      return filename;
    }
    if (CPLib.eqr("filepdf",p_cVarName)) {
      return filepdf;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      return stringa;
    }
    if (CPLib.eqr("_flgstpd",p_cVarName)) {
      return _flgstpd;
    }
    if (CPLib.eqr("_urldef",p_cVarName)) {
      return _urldef;
    }
    if (CPLib.eqr("_pagam",p_cVarName)) {
      return _pagam;
    }
    if (CPLib.eqr("_mpagam",p_cVarName)) {
      return _mpagam;
    }
    if (CPLib.eqr("_modello",p_cVarName)) {
      return _modello;
    }
    if (CPLib.eqr("_concessione",p_cVarName)) {
      return _concessione;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIPC",p_cVarName)) {
      return gIPC;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      return gIPS;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      return gIPSP;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      return gCodDip;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      return w_DATANASC;
    }
    if (CPLib.eqr("DATARILASC",p_cVarName)) {
      return w_DATARILASC;
    }
    if (CPLib.eqr("DATAVALI",p_cVarName)) {
      return w_DATAVALI;
    }
    if (CPLib.eqr("DATAOPE",p_cVarName)) {
      return w_DATAOPE;
    }
    if (CPLib.eqr("DATAREG",p_cVarName)) {
      return w_DATAREG;
    }
    return CPLib.NullDate();
  }
  public java.sql.Timestamp GetDateTime(String p_cVarName,String p_cType,int len,int dec) {
    return CPLib.NullDateTime();
  }
  public boolean GetLogic(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      return bReport;
    }
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
    if (CPLib.eqr("CFESTERO",p_cVarName)) {
      w_CFESTERO = value;
      return;
    }
    if (CPLib.eqr("CAMBIO",p_cVarName)) {
      w_CAMBIO = value;
      return;
    }
    if (CPLib.eqr("TOTLIRE",p_cVarName)) {
      w_TOTLIRE = value;
      return;
    }
    if (CPLib.eqr("TOTCONT",p_cVarName)) {
      w_TOTCONT = value;
      return;
    }
    if (CPLib.eqr("CACODICE",p_cVarName)) {
      w_CACODICE = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("STATOREG",p_cVarName)) {
      w_STATOREG = value;
      return;
    }
    if (CPLib.eqr("IDBASE",p_cVarName)) {
      w_IDBASE = value;
      return;
    }
    if (CPLib.eqr("NUMPROG",p_cVarName)) {
      w_NUMPROG = value;
      return;
    }
    if (CPLib.eqr("DESCRI",p_cVarName)) {
      w_DESCRI = value;
      return;
    }
    if (CPLib.eqr("CITINT",p_cVarName)) {
      w_CITINT = value;
      return;
    }
    if (CPLib.eqr("CITDIP",p_cVarName)) {
      w_CITDIP = value;
      return;
    }
    if (CPLib.eqr("PROVDIP",p_cVarName)) {
      w_PROVDIP = value;
      return;
    }
    if (CPLib.eqr("CABDIP",p_cVarName)) {
      w_CABDIP = value;
      return;
    }
    if (CPLib.eqr("PROVINT",p_cVarName)) {
      w_PROVINT = value;
      return;
    }
    if (CPLib.eqr("CABINT",p_cVarName)) {
      w_CABINT = value;
      return;
    }
    if (CPLib.eqr("TIPOPERS",p_cVarName)) {
      w_TIPOPERS = value;
      return;
    }
    if (CPLib.eqr("MEZPAGAM",p_cVarName)) {
      w_MEZPAGAM = value;
      return;
    }
    if (CPLib.eqr("IBAN",p_cVarName)) {
      w_IBAN = value;
      return;
    }
    if (CPLib.eqr("CODFISC",p_cVarName)) {
      w_CODFISC = value;
      return;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      w_COGNOME = value;
      return;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      w_NOME = value;
      return;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      w_RAGSOC = value;
      return;
    }
    if (CPLib.eqr("DESCCIT",p_cVarName)) {
      w_DESCCIT = value;
      return;
    }
    if (CPLib.eqr("PROVINCIA",p_cVarName)) {
      w_PROVINCIA = value;
      return;
    }
    if (CPLib.eqr("CAP",p_cVarName)) {
      w_CAP = value;
      return;
    }
    if (CPLib.eqr("CODCAB",p_cVarName)) {
      w_CODCAB = value;
      return;
    }
    if (CPLib.eqr("DOMICILIO",p_cVarName)) {
      w_DOMICILIO = value;
      return;
    }
    if (CPLib.eqr("PAESE",p_cVarName)) {
      w_PAESE = value;
      return;
    }
    if (CPLib.eqr("NASCOMUN",p_cVarName)) {
      w_NASCOMUN = value;
      return;
    }
    if (CPLib.eqr("TIPINTER",p_cVarName)) {
      w_TIPINTER = value;
      return;
    }
    if (CPLib.eqr("SESSO",p_cVarName)) {
      w_SESSO = value;
      return;
    }
    if (CPLib.eqr("NASSTATO",p_cVarName)) {
      w_NASSTATO = value;
      return;
    }
    if (CPLib.eqr("TIPODOC",p_cVarName)) {
      w_TIPODOC = value;
      return;
    }
    if (CPLib.eqr("NUMDOCUM",p_cVarName)) {
      w_NUMDOCUM = value;
      return;
    }
    if (CPLib.eqr("AUTRILASC",p_cVarName)) {
      w_AUTRILASC = value;
      return;
    }
    if (CPLib.eqr("SOTGRUP",p_cVarName)) {
      w_SOTGRUP = value;
      return;
    }
    if (CPLib.eqr("RAMOGRUP",p_cVarName)) {
      w_RAMOGRUP = value;
      return;
    }
    if (CPLib.eqr("SETTSINT",p_cVarName)) {
      w_SETTSINT = value;
      return;
    }
    if (CPLib.eqr("PEP",p_cVarName)) {
      w_PEP = value;
      return;
    }
    if (CPLib.eqr("SNAINUMOPE",p_cVarName)) {
      w_SNAINUMOPE = value;
      return;
    }
    if (CPLib.eqr("FLAGCONT",p_cVarName)) {
      w_FLAGCONT = value;
      return;
    }
    if (CPLib.eqr("TIPOOPRAP",p_cVarName)) {
      w_TIPOOPRAP = value;
      return;
    }
    if (CPLib.eqr("CODANA",p_cVarName)) {
      w_CODANA = value;
      return;
    }
    if (CPLib.eqr("CODVOC",p_cVarName)) {
      w_CODVOC = value;
      return;
    }
    if (CPLib.eqr("VALUTA",p_cVarName)) {
      w_VALUTA = value;
      return;
    }
    if (CPLib.eqr("CONNESCLI",p_cVarName)) {
      w_CONNESCLI = value;
      return;
    }
    if (CPLib.eqr("CONNESBEN",p_cVarName)) {
      w_CONNESBEN = value;
      return;
    }
    if (CPLib.eqr("C_RAG",p_cVarName)) {
      w_C_RAG = value;
      return;
    }
    if (CPLib.eqr("C_CTA",p_cVarName)) {
      w_C_CTA = value;
      return;
    }
    if (CPLib.eqr("C_PRV",p_cVarName)) {
      w_C_PRV = value;
      return;
    }
    if (CPLib.eqr("C_CAP",p_cVarName)) {
      w_C_CAP = value;
      return;
    }
    if (CPLib.eqr("C_CAB",p_cVarName)) {
      w_C_CAB = value;
      return;
    }
    if (CPLib.eqr("C_IND",p_cVarName)) {
      w_C_IND = value;
      return;
    }
    if (CPLib.eqr("C_STA",p_cVarName)) {
      w_C_STA = value;
      return;
    }
    if (CPLib.eqr("CODINTER",p_cVarName)) {
      w_CODINTER = value;
      return;
    }
    if (CPLib.eqr("CODDIPE",p_cVarName)) {
      w_CODDIPE = value;
      return;
    }
    if (CPLib.eqr("DESCCITDIP",p_cVarName)) {
      w_DESCCITDIP = value;
      return;
    }
    if (CPLib.eqr("SEGNO",p_cVarName)) {
      w_SEGNO = value;
      return;
    }
    if (CPLib.eqr("FLAGFRAZ",p_cVarName)) {
      w_FLAGFRAZ = value;
      return;
    }
    if (CPLib.eqr("COLLEG",p_cVarName)) {
      w_COLLEG = value;
      return;
    }
    if (CPLib.eqr("PROVINCIADIP",p_cVarName)) {
      w_PROVINCIADIP = value;
      return;
    }
    if (CPLib.eqr("CODCABDIP",p_cVarName)) {
      w_CODCABDIP = value;
      return;
    }
    if (CPLib.eqr("CAIDBIGLIETTO",p_cVarName)) {
      w_CAIDBIGLIETTO = value;
      return;
    }
    if (CPLib.eqr("CAFLGOPE",p_cVarName)) {
      w_CAFLGOPE = value;
      return;
    }
    if (CPLib.eqr("ATTIV",p_cVarName)) {
      w_ATTIV = value;
      return;
    }
    if (CPLib.eqr("MIDBIGLIETTO",p_cVarName)) {
      w_MIDBIGLIETTO = value;
      return;
    }
    if (CPLib.eqr("CODTRANSZ",p_cVarName)) {
      w_CODTRANSZ = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_ra1",p_cVarName)) {
      _ra1 = value;
      return;
    }
    if (CPLib.eqr("_ra2",p_cVarName)) {
      _ra2 = value;
      return;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      filename = value;
      return;
    }
    if (CPLib.eqr("filepdf",p_cVarName)) {
      filepdf = value;
      return;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      stringa = value;
      return;
    }
    if (CPLib.eqr("_flgstpd",p_cVarName)) {
      _flgstpd = value;
      return;
    }
    if (CPLib.eqr("_urldef",p_cVarName)) {
      _urldef = value;
      return;
    }
    if (CPLib.eqr("_pagam",p_cVarName)) {
      _pagam = value;
      return;
    }
    if (CPLib.eqr("_mpagam",p_cVarName)) {
      _mpagam = value;
      return;
    }
    if (CPLib.eqr("_modello",p_cVarName)) {
      _modello = value;
      return;
    }
    if (CPLib.eqr("_concessione",p_cVarName)) {
      _concessione = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
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
    if (CPLib.eqr("gIPC",p_cVarName)) {
      gIPC = value;
      return;
    }
    if (CPLib.eqr("gIPS",p_cVarName)) {
      gIPS = value;
      return;
    }
    if (CPLib.eqr("gIPSP",p_cVarName)) {
      gIPSP = value;
      return;
    }
    if (CPLib.eqr("gCodDip",p_cVarName)) {
      gCodDip = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATANASC",p_cVarName)) {
      w_DATANASC = value;
      return;
    }
    if (CPLib.eqr("DATARILASC",p_cVarName)) {
      w_DATARILASC = value;
      return;
    }
    if (CPLib.eqr("DATAVALI",p_cVarName)) {
      w_DATAVALI = value;
      return;
    }
    if (CPLib.eqr("DATAOPE",p_cVarName)) {
      w_DATAOPE = value;
      return;
    }
    if (CPLib.eqr("DATAREG",p_cVarName)) {
      w_DATAREG = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("bReport",p_cVarName)) {
      bReport = value;
      return;
    }
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
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intermbo=null;
    try {
      /* w_STATOREG Char(1) */
      /* w_IDBASE Char(10) */
      /* w_NUMPROG Char(7) */
      /* w_DESCRI Char(30) // Descrizione */
      /* w_CITINT Char(30) // Città */
      /* w_CITDIP Char(30) // Città */
      /* w_PROVDIP Char(2) // Provincia */
      /* w_CABDIP Char(6) // CAB */
      /* w_PROVINT Char(2) // Provincia */
      /* w_CABINT Char(6) // CAB */
      /* w_TIPOPERS Char(1) */
      /* w_MEZPAGAM Char(1) // Mezzo Pagamento */
      /* w_IBAN Char(27) // IBAN per Bonifici */
      /* w_CFESTERO Numeric(1, 0) // Codice Fiscale Estero */
      /* w_CODFISC Char(16) // Codice Fiscale */
      /* w_COGNOME Char(26) // Cognome */
      /* w_NOME Char(25) // Nome */
      /* w_RAGSOC Char(70) // Ragione Sociale */
      /* w_DESCCIT Char(40) // Città */
      /* w_PROVINCIA Char(2) // Provincia */
      /* w_CAP Char(9) // CAP */
      /* w_CODCAB Char(6) // CAB */
      /* w_DOMICILIO Char(35) // Indirizzo */
      /* w_PAESE Char(3) // Stato */
      /* w_NASCOMUN Char(30) // Luogo di Nascita */
      /* w_TIPINTER Char(2) // Prov. */
      /* w_SESSO Char(1) // Sesso */
      /* w_NASSTATO Char(30) // Stato di nascita */
      /* w_DATANASC Date // Data Nascita */
      /* w_TIPODOC Char(2) // Tipo Documento */
      /* w_NUMDOCUM Char(15) // Numero Doc. */
      /* w_DATARILASC Date // Data Rilascio Doc. */
      /* w_DATAVALI Date // Scadenza Documento */
      /* w_AUTRILASC Char(30) // Autorità di rilascio */
      /* w_SOTGRUP Char(3) // Sottogruppo Att. Ec. */
      /* w_RAMOGRUP Char(3) // Ramo Gruppo Att. Ec. */
      /* w_SETTSINT Char(3) // Settorizzazione UIC */
      /* w_PEP Char(1) // Persona Politicamente Esposta */
      /* w_SNAINUMOPE Char(15) // N° Operazione */
      /* w_DATAOPE Date // Data Operazione */
      /* w_DATAREG Date // Data registrazione */
      /* w_FLAGCONT Char(1) // Contanti (S/N) */
      /* w_TIPOOPRAP Char(2) // Tipo Operazione Completa */
      /* w_CODANA Char(4) // Causale Analitica */
      /* w_CODVOC Char(2) // Causale Sintetica */
      /* w_VALUTA Char(3) // Divisa */
      /* w_CAMBIO Numeric(9, 4) // Cambio */
      /* w_CONNESCLI Char(16) // Codice Cliente Occasionale */
      /* w_CONNESBEN Char(16) // Codice Cliente Occasionale */
      /* w_C_RAG Char(70) */
      /* w_C_CTA Char(30) */
      /* w_C_PRV Char(2) */
      /* w_C_CAP Char(5) */
      /* w_C_CAB Char(6) */
      /* w_C_IND Char(35) */
      /* w_C_STA Char(3) */
      /* w_CODINTER Char(11) // Codice Intermediario */
      /* w_CODDIPE Char(6) // Codice Dipendenza */
      /* w_DESCCITDIP Char(30) // Città Dipendenza */
      /* w_SEGNO Char(1) // Segno */
      /* w_FLAGFRAZ Char(1) // Frazionata (S/N) */
      /* w_COLLEG Char(11) // Collegamento Operazione Multiple */
      /* w_PROVINCIADIP Char(2) // Provincia Dipendenza */
      /* w_CODCABDIP Char(6) // CAB Dipendenza */
      /* w_TOTLIRE Numeric(15, 2) // Totale Operazione */
      /* w_TOTCONT Numeric(15, 2) // di cui contanti */
      /* w_CACODICE Numeric(5, 0) // Causale */
      /* w_CAIDBIGLIETTO Char(28) // ID BIGLIETTO */
      /* w_CAFLGOPE Char(1) // Flag V/P/G/R */
      /* w_ATTIV Char(10) */
      /* w_MIDBIGLIETTO Memo */
      /* w_CODTRANSZ Char(50) */
      /* cProg Char(10) */
      /* _report Object(ReportLibrary) */
      /* bReport Bool */
      /* _ra1 Char(70) */
      /* _ra2 Char(70) */
      /* filename Char(128) */
      /* filepdf Char(128) */
      /* stringa Char(150) */
      /* _flgstpd Char(1) */
      /* _urldef Char(200) */
      /* _pagam Char(128) */
      /* _mpagam Char(30) */
      /* _modello Char(100) */
      /* _concessione Char(10) */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gIPC Char(20) // IPClient */
      /* gIPS Char(120) // IPServer */
      /* gIPSP Char(20) // Porta Server */
      /* gCodDip Char(6) // Dipendenza */
      /* Crea tabella d'appoggio per stampa */
      /* _concessione := '' */
      _concessione = "";
      // * --- Read from anadip
      m_cServer = m_Ctx.GetServer("anadip");
      m_cPhName = m_Ctx.GetPhName("anadip");
      m_cSql = "";
      m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(gCodDip,"C",6,0,m_cServer),m_cServer,gCodDip);
      if (m_Ctx.IsSharedTemp("anadip")) {
        m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
      }
      if (Read_Cursor!=null)
        Read_Cursor.Close();
      Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONCESSIONE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
      if ( ! (Read_Cursor.Eof())) {
        _concessione = Read_Cursor.GetString("CONCESSIONE");
        Read_Cursor.Next();
        if ( ! (Read_Cursor.Eof())) {
          Error l_oErrorFault = new Error("Read on anadip into routine arrt_cgo_moduli_test returns two or more records. This item should return only a record.");
          CPStdCounter.Error(l_oErrorFault);
        }
        Read_Cursor.Close();
      } else {
        // Error: no record found!
        _concessione = "";
        Read_Cursor.Close();
        m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
      }
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _ra1 := intermbo->RASPAUI */
        _ra1 = Cursor_intermbo.GetString("RASPAUI");
        /* _ra2 := intermbo->RESPAUI */
        _ra2 = Cursor_intermbo.GetString("RESPAUI");
        /* _flgstpd := intermbo->FLGSTPDIR */
        _flgstpd = Cursor_intermbo.GetString("FLGSTPDIR");
        /* _modello := intermbo->DBPROT */
        _modello = Cursor_intermbo.GetString("DBPROT");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // * --- Drop temporary table tmp_cgo_operazioni
      if (m_Ctx.IsSharedTemp("tmp_cgo_operazioni")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_operazioni")) {
          m_cServer = m_Ctx.GetServer("tmp_cgo_operazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_cgo_operazioni");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_cgo_operazioni");
      }
      // * --- Create temporary table tmp_cgo_operazioni
      if (m_Ctx.IsSharedTemp("tmp_cgo_operazioni")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_cgo_operazioni")) {
          m_cServer = m_Ctx.GetServer("tmp_cgo_operazioni");
          m_cPhName = m_Ctx.GetPhName("tmp_cgo_operazioni");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_cgo_operazioni");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_cgo_operazioni");
      if ( ! (m_Ctx.IsSharedTemp("tmp_cgo_operazioni"))) {
        m_cServer = m_Ctx.GetServer("tmp_cgo_operazioni");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_cgo_operazioni",m_cServer,"proto")),m_cPhName,"tmp_cgo_operazioni",m_Ctx);
      }
      m_cPhName_tmp_cgo_operazioni = m_cPhName;
      /* Case w_MEZPAGAM='A' */
      if (CPLib.eqr(w_MEZPAGAM,"A")) {
        /* _mpagam := 'Altro Mezzo di Pagamento' */
        _mpagam = "Altro Mezzo di Pagamento";
        /* Case w_MEZPAGAM='I' */
      } else if (CPLib.eqr(w_MEZPAGAM,"I")) {
        /* _mpagam := 'Bonifico Italia' */
        _mpagam = "Bonifico Italia";
        /* Case w_MEZPAGAM='E' */
      } else if (CPLib.eqr(w_MEZPAGAM,"E")) {
        /* _mpagam := 'Bonifico Estero' */
        _mpagam = "Bonifico Estero";
        /* Case w_MEZPAGAM='P' */
      } else if (CPLib.eqr(w_MEZPAGAM,"P")) {
        /* _mpagam := 'Bonifico Postale' */
        _mpagam = "Bonifico Postale";
        /* Case w_MEZPAGAM='C' */
      } else if (CPLib.eqr(w_MEZPAGAM,"C")) {
        /* _mpagam := 'Assegno Circolare' */
        _mpagam = "Assegno Circolare";
        /* Case w_MEZPAGAM='B' */
      } else if (CPLib.eqr(w_MEZPAGAM,"B")) {
        /* _mpagam := 'Assegno Bancario' */
        _mpagam = "Assegno Bancario";
      } // End Case
      /* _pagam := LRTrim(_mpagam) + ' € ' +LRTrim(Str((w_TOTLIRE - w_TOTCONT),15,2)) + iif(w_FLAGCONT='S',' - Contanti € '+LRTrim(Str(w_TOTCONT,15,2)),'') */
      _pagam = CPLib.LRTrim(_mpagam)+" \u20ac "+CPLib.LRTrim(CPLib.Str((w_TOTLIRE-w_TOTCONT),15,2))+(CPLib.eqr(w_FLAGCONT,"S")?" - Contanti \u20ac "+CPLib.LRTrim(CPLib.Str(w_TOTCONT,15,2)):"");
      // * --- Insert into tmp_cgo_operazioni from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_cgo_operazioni");
      m_cPhName = m_Ctx.GetPhName("tmp_cgo_operazioni");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_cgo_operazioni",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_moduli_test",40,"00000072")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000072(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_ATTIV,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_AUTRILASC,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_C_CAB,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_C_CAP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_C_CTA,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_C_IND,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_C_PRV,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_C_RAG,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_C_STA,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CACODICE,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CAIDBIGLIETTO,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CAMBIO,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CAP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CFESTERO,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODANA,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODCAB,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODCABDIP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODDIPE,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODFISC,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODINTER,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODVOC,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_COGNOME,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_COLLEG,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CONNESBEN,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CONNESCLI,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DATANASC,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DATAOPE,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DATAREG,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DATARILASC,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DATAVALI,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DESCCIT,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DESCCITDIP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_DOMICILIO,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_FLAGCONT,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_FLAGFRAZ,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_IBAN,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_MEZPAGAM,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_NASCOMUN,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_NASSTATO,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_NOME,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_NUMDOCUM,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_NUMPROG,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_PAESE,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_PEP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_PROVINCIA,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_PROVINCIADIP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_RAGSOC,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_RAMOGRUP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_SEGNO,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_SESSO,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_SETTSINT,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_SNAINUMOPE,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_SOTGRUP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_STATOREG,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_TIPINTER,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_TIPODOC,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_TIPOOPRAP,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_TIPOPERS,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_TOTCONT,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_TOTLIRE,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_VALUTA,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_CAFLGOPE,"V")?"X":""),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_CAFLGOPE,"G")?"X":""),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_CAFLGOPE,"P")?"X":""),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_CAFLGOPE,"R")?"X":""),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_MEZPAGAM,"I") || CPLib.eqr(w_MEZPAGAM,"E") || CPLib.eqr(w_MEZPAGAM,"P")?"X":""),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_MEZPAGAM,"B") || CPLib.eqr(w_MEZPAGAM,"C")?"X":""),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_ra1,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_ra2,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_pagam,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_concessione,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODTRANSZ,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_cgo_operazioni",true);
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
      /* cProg := Utilities.GetAutonumber("PSTPMAV\'"+LRTrim(gAzienda)+"'","",10) */
      cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTPMAV\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
      // * --- Insert into cgo_stampeav from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("cgo_stampeav");
      m_cPhName = m_Ctx.GetPhName("cgo_stampeav");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_stampeav",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_moduli_test",40,"00000074")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000074(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODFISC,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CODDIPE,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_CAIDBIGLIETTO,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(1,"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(w_CODDIPE)+"_"+CPLib.LRTrim(w_CODFISC)+"_"+CPLib.LRTrim(w_CAIDBIGLIETTO)+".pdf","?",0,0,m_cServer, m_oParameters)+", ";
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
      }
      /* Crea il primo report */
      /* _report := ReportLibrary.GetReportLibrary() */
      _report = ReportLibrary.Make(m_Ctx).GetReportLibrary();
      /* _report.setFileName(LRTrim(gPathApp)+'/stampe_off/'+LRTrim(gAzienda)+"/"+LRTrim(w_CODDIPE)+"_"+LRTrim(w_CODFISC)+"_"+LRTrim(w_CAIDBIGLIETTO)) */
      _report.setFileName(CPLib.LRTrim(gPathApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_CODDIPE)+"_"+CPLib.LRTrim(w_CODFISC)+"_"+CPLib.LRTrim(w_CAIDBIGLIETTO));
      /* _report.addReport('arrp_snai_stp_mod_identificazione_cliente',_modello,False) */
      _report.addReport("arrp_snai_stp_mod_identificazione_cliente",_modello,false);
      /* bReport := _report.makeXmlStrReport() */
      bReport = _report.makeXmlStrReport();
      /* If _flgstpd='S' */
      if (CPLib.eqr(_flgstpd,"S")) {
        /* filepdf := LRTrim(w_CODDIPE)+"_"+LRTrim(w_CODFISC)+"_"+LRTrim(w_CAIDBIGLIETTO)+".pdf" */
        filepdf = CPLib.LRTrim(w_CODDIPE)+"_"+CPLib.LRTrim(w_CODFISC)+"_"+CPLib.LRTrim(w_CAIDBIGLIETTO)+".pdf";
        /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(filepdf)+"&delFile=S" */
        Forward f;
        f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(filepdf)+"&delFile=S",false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* Stop LRTrim(gUrlApp)+"/stampe_off/"+LRTrim(gAzienda)+"/"+LRTrim(w_CODDIPE)+"_"+LRTrim(w_CODFISC)+"_"+LRTrim(w_CAIDBIGLIETTO)+".pdf" */
        Forward f;
        f=new Forward(CPLib.LRTrim(gUrlApp)+"/stampe_off/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_CODDIPE)+"_"+CPLib.LRTrim(w_CODFISC)+"_"+CPLib.LRTrim(w_CAIDBIGLIETTO)+".pdf",false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
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
      m_Caller.SetString("STATOREG","C",1,0,w_STATOREG);
      m_Caller.SetString("IDBASE","C",10,0,w_IDBASE);
      m_Caller.SetString("NUMPROG","C",7,0,w_NUMPROG);
      m_Caller.SetString("DESCRI","C",30,0,w_DESCRI);
      m_Caller.SetString("CITINT","C",30,0,w_CITINT);
      m_Caller.SetString("CITDIP","C",30,0,w_CITDIP);
      m_Caller.SetString("PROVDIP","C",2,0,w_PROVDIP);
      m_Caller.SetString("CABDIP","C",6,0,w_CABDIP);
      m_Caller.SetString("PROVINT","C",2,0,w_PROVINT);
      m_Caller.SetString("CABINT","C",6,0,w_CABINT);
      m_Caller.SetString("TIPOPERS","C",1,0,w_TIPOPERS);
      m_Caller.SetString("MEZPAGAM","C",1,0,w_MEZPAGAM);
      m_Caller.SetString("IBAN","C",27,0,w_IBAN);
      m_Caller.SetNumber("CFESTERO","N",1,0,w_CFESTERO);
      m_Caller.SetString("CODFISC","C",16,0,w_CODFISC);
      m_Caller.SetString("COGNOME","C",26,0,w_COGNOME);
      m_Caller.SetString("NOME","C",25,0,w_NOME);
      m_Caller.SetString("RAGSOC","C",70,0,w_RAGSOC);
      m_Caller.SetString("DESCCIT","C",40,0,w_DESCCIT);
      m_Caller.SetString("PROVINCIA","C",2,0,w_PROVINCIA);
      m_Caller.SetString("CAP","C",9,0,w_CAP);
      m_Caller.SetString("CODCAB","C",6,0,w_CODCAB);
      m_Caller.SetString("DOMICILIO","C",35,0,w_DOMICILIO);
      m_Caller.SetString("PAESE","C",3,0,w_PAESE);
      m_Caller.SetString("NASCOMUN","C",30,0,w_NASCOMUN);
      m_Caller.SetString("TIPINTER","C",2,0,w_TIPINTER);
      m_Caller.SetString("SESSO","C",1,0,w_SESSO);
      m_Caller.SetString("NASSTATO","C",30,0,w_NASSTATO);
      m_Caller.SetDate("DATANASC","D",8,0,w_DATANASC);
      m_Caller.SetString("TIPODOC","C",2,0,w_TIPODOC);
      m_Caller.SetString("NUMDOCUM","C",15,0,w_NUMDOCUM);
      m_Caller.SetDate("DATARILASC","D",8,0,w_DATARILASC);
      m_Caller.SetDate("DATAVALI","D",8,0,w_DATAVALI);
      m_Caller.SetString("AUTRILASC","C",30,0,w_AUTRILASC);
      m_Caller.SetString("SOTGRUP","C",3,0,w_SOTGRUP);
      m_Caller.SetString("RAMOGRUP","C",3,0,w_RAMOGRUP);
      m_Caller.SetString("SETTSINT","C",3,0,w_SETTSINT);
      m_Caller.SetString("PEP","C",1,0,w_PEP);
      m_Caller.SetString("SNAINUMOPE","C",15,0,w_SNAINUMOPE);
      m_Caller.SetDate("DATAOPE","D",8,0,w_DATAOPE);
      m_Caller.SetDate("DATAREG","D",8,0,w_DATAREG);
      m_Caller.SetString("FLAGCONT","C",1,0,w_FLAGCONT);
      m_Caller.SetString("TIPOOPRAP","C",2,0,w_TIPOOPRAP);
      m_Caller.SetString("CODANA","C",4,0,w_CODANA);
      m_Caller.SetString("CODVOC","C",2,0,w_CODVOC);
      m_Caller.SetString("VALUTA","C",3,0,w_VALUTA);
      m_Caller.SetNumber("CAMBIO","N",9,4,w_CAMBIO);
      m_Caller.SetString("CONNESCLI","C",16,0,w_CONNESCLI);
      m_Caller.SetString("CONNESBEN","C",16,0,w_CONNESBEN);
      m_Caller.SetString("C_RAG","C",70,0,w_C_RAG);
      m_Caller.SetString("C_CTA","C",30,0,w_C_CTA);
      m_Caller.SetString("C_PRV","C",2,0,w_C_PRV);
      m_Caller.SetString("C_CAP","C",5,0,w_C_CAP);
      m_Caller.SetString("C_CAB","C",6,0,w_C_CAB);
      m_Caller.SetString("C_IND","C",35,0,w_C_IND);
      m_Caller.SetString("C_STA","C",3,0,w_C_STA);
      m_Caller.SetString("CODINTER","C",11,0,w_CODINTER);
      m_Caller.SetString("CODDIPE","C",6,0,w_CODDIPE);
      m_Caller.SetString("DESCCITDIP","C",30,0,w_DESCCITDIP);
      m_Caller.SetString("SEGNO","C",1,0,w_SEGNO);
      m_Caller.SetString("FLAGFRAZ","C",1,0,w_FLAGFRAZ);
      m_Caller.SetString("COLLEG","C",11,0,w_COLLEG);
      m_Caller.SetString("PROVINCIADIP","C",2,0,w_PROVINCIADIP);
      m_Caller.SetString("CODCABDIP","C",6,0,w_CODCABDIP);
      m_Caller.SetNumber("TOTLIRE","N",15,2,w_TOTLIRE);
      m_Caller.SetNumber("TOTCONT","N",15,2,w_TOTCONT);
      m_Caller.SetNumber("CACODICE","N",5,0,w_CACODICE);
      m_Caller.SetString("CAIDBIGLIETTO","C",28,0,w_CAIDBIGLIETTO);
      m_Caller.SetString("CAFLGOPE","C",1,0,w_CAFLGOPE);
      m_Caller.SetString("ATTIV","C",10,0,w_ATTIV);
      m_Caller.SetString("MIDBIGLIETTO","M",10,0,w_MIDBIGLIETTO);
      m_Caller.SetString("CODTRANSZ","C",50,0,w_CODTRANSZ);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_moduli_testR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_moduli_testR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_STATOREG = m_Caller.GetString("STATOREG","C",1,0);
    w_IDBASE = m_Caller.GetString("IDBASE","C",10,0);
    w_NUMPROG = m_Caller.GetString("NUMPROG","C",7,0);
    w_DESCRI = m_Caller.GetString("DESCRI","C",30,0);
    w_CITINT = m_Caller.GetString("CITINT","C",30,0);
    w_CITDIP = m_Caller.GetString("CITDIP","C",30,0);
    w_PROVDIP = m_Caller.GetString("PROVDIP","C",2,0);
    w_CABDIP = m_Caller.GetString("CABDIP","C",6,0);
    w_PROVINT = m_Caller.GetString("PROVINT","C",2,0);
    w_CABINT = m_Caller.GetString("CABINT","C",6,0);
    w_TIPOPERS = m_Caller.GetString("TIPOPERS","C",1,0);
    w_MEZPAGAM = m_Caller.GetString("MEZPAGAM","C",1,0);
    w_IBAN = m_Caller.GetString("IBAN","C",27,0);
    w_CFESTERO = m_Caller.GetNumber("CFESTERO","N",1,0);
    w_CODFISC = m_Caller.GetString("CODFISC","C",16,0);
    w_COGNOME = m_Caller.GetString("COGNOME","C",26,0);
    w_NOME = m_Caller.GetString("NOME","C",25,0);
    w_RAGSOC = m_Caller.GetString("RAGSOC","C",70,0);
    w_DESCCIT = m_Caller.GetString("DESCCIT","C",40,0);
    w_PROVINCIA = m_Caller.GetString("PROVINCIA","C",2,0);
    w_CAP = m_Caller.GetString("CAP","C",9,0);
    w_CODCAB = m_Caller.GetString("CODCAB","C",6,0);
    w_DOMICILIO = m_Caller.GetString("DOMICILIO","C",35,0);
    w_PAESE = m_Caller.GetString("PAESE","C",3,0);
    w_NASCOMUN = m_Caller.GetString("NASCOMUN","C",30,0);
    w_TIPINTER = m_Caller.GetString("TIPINTER","C",2,0);
    w_SESSO = m_Caller.GetString("SESSO","C",1,0);
    w_NASSTATO = m_Caller.GetString("NASSTATO","C",30,0);
    w_DATANASC = m_Caller.GetDate("DATANASC","D",8,0);
    w_TIPODOC = m_Caller.GetString("TIPODOC","C",2,0);
    w_NUMDOCUM = m_Caller.GetString("NUMDOCUM","C",15,0);
    w_DATARILASC = m_Caller.GetDate("DATARILASC","D",8,0);
    w_DATAVALI = m_Caller.GetDate("DATAVALI","D",8,0);
    w_AUTRILASC = m_Caller.GetString("AUTRILASC","C",30,0);
    w_SOTGRUP = m_Caller.GetString("SOTGRUP","C",3,0);
    w_RAMOGRUP = m_Caller.GetString("RAMOGRUP","C",3,0);
    w_SETTSINT = m_Caller.GetString("SETTSINT","C",3,0);
    w_PEP = m_Caller.GetString("PEP","C",1,0);
    w_SNAINUMOPE = m_Caller.GetString("SNAINUMOPE","C",15,0);
    w_DATAOPE = m_Caller.GetDate("DATAOPE","D",8,0);
    w_DATAREG = m_Caller.GetDate("DATAREG","D",8,0);
    w_FLAGCONT = m_Caller.GetString("FLAGCONT","C",1,0);
    w_TIPOOPRAP = m_Caller.GetString("TIPOOPRAP","C",2,0);
    w_CODANA = m_Caller.GetString("CODANA","C",4,0);
    w_CODVOC = m_Caller.GetString("CODVOC","C",2,0);
    w_VALUTA = m_Caller.GetString("VALUTA","C",3,0);
    w_CAMBIO = m_Caller.GetNumber("CAMBIO","N",9,4);
    w_CONNESCLI = m_Caller.GetString("CONNESCLI","C",16,0);
    w_CONNESBEN = m_Caller.GetString("CONNESBEN","C",16,0);
    w_C_RAG = m_Caller.GetString("C_RAG","C",70,0);
    w_C_CTA = m_Caller.GetString("C_CTA","C",30,0);
    w_C_PRV = m_Caller.GetString("C_PRV","C",2,0);
    w_C_CAP = m_Caller.GetString("C_CAP","C",5,0);
    w_C_CAB = m_Caller.GetString("C_CAB","C",6,0);
    w_C_IND = m_Caller.GetString("C_IND","C",35,0);
    w_C_STA = m_Caller.GetString("C_STA","C",3,0);
    w_CODINTER = m_Caller.GetString("CODINTER","C",11,0);
    w_CODDIPE = m_Caller.GetString("CODDIPE","C",6,0);
    w_DESCCITDIP = m_Caller.GetString("DESCCITDIP","C",30,0);
    w_SEGNO = m_Caller.GetString("SEGNO","C",1,0);
    w_FLAGFRAZ = m_Caller.GetString("FLAGFRAZ","C",1,0);
    w_COLLEG = m_Caller.GetString("COLLEG","C",11,0);
    w_PROVINCIADIP = m_Caller.GetString("PROVINCIADIP","C",2,0);
    w_CODCABDIP = m_Caller.GetString("CODCABDIP","C",6,0);
    w_TOTLIRE = m_Caller.GetNumber("TOTLIRE","N",15,2);
    w_TOTCONT = m_Caller.GetNumber("TOTCONT","N",15,2);
    w_CACODICE = m_Caller.GetNumber("CACODICE","N",5,0);
    w_CAIDBIGLIETTO = m_Caller.GetString("CAIDBIGLIETTO","C",28,0);
    w_CAFLGOPE = m_Caller.GetString("CAFLGOPE","C",1,0);
    w_ATTIV = m_Caller.GetString("ATTIV","C",10,0);
    w_MIDBIGLIETTO = m_Caller.GetString("MIDBIGLIETTO","M",10,0);
    w_CODTRANSZ = m_Caller.GetString("CODTRANSZ","C",50,0);
    cProg = CPLib.Space(10);
    _report = null;
    bReport = false;
    _ra1 = CPLib.Space(70);
    _ra2 = CPLib.Space(70);
    filename = CPLib.Space(128);
    filepdf = CPLib.Space(128);
    stringa = CPLib.Space(150);
    _flgstpd = CPLib.Space(1);
    _urldef = CPLib.Space(200);
    _pagam = CPLib.Space(128);
    _mpagam = CPLib.Space(30);
    _modello = CPLib.Space(100);
    _concessione = CPLib.Space(10);
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIPC=m_Ctx.GetGlobalString("gIPC");
    gIPS=m_Ctx.GetGlobalString("gIPS");
    gIPSP=m_Ctx.GetGlobalString("gIPSP");
    gCodDip=m_Ctx.GetGlobalString("gCodDip");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000072(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"C_CAB,";
    p_cSql = p_cSql+"C_CAP,";
    p_cSql = p_cSql+"C_CTA,";
    p_cSql = p_cSql+"C_IND,";
    p_cSql = p_cSql+"C_PRV,";
    p_cSql = p_cSql+"C_RAG,";
    p_cSql = p_cSql+"C_STA,";
    p_cSql = p_cSql+"CACODICE,";
    p_cSql = p_cSql+"CAIDBIGLIETTO,";
    p_cSql = p_cSql+"CAMBIO,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"CODANA,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"CODCABDIP,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"CODVOC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"COLLEG,";
    p_cSql = p_cSql+"CONNESBEN,";
    p_cSql = p_cSql+"CONNESCLI,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"DATAOPE,";
    p_cSql = p_cSql+"DATAREG,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"DESCCITDIP,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"FLAGCONT,";
    p_cSql = p_cSql+"FLAGFRAZ,";
    p_cSql = p_cSql+"IBAN,";
    p_cSql = p_cSql+"MEZPAGAM,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"NUMPROG,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PROVINCIADIP,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SEGNO,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"SNAINUMOPE,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"TIPOOPRAP,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"TOTCONT,";
    p_cSql = p_cSql+"TOTLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"FLGVIN,";
    p_cSql = p_cSql+"FLGGIO,";
    p_cSql = p_cSql+"FLGPRE,";
    p_cSql = p_cSql+"FLGVER,";
    p_cSql = p_cSql+"FLGBON,";
    p_cSql = p_cSql+"FLGASS,";
    p_cSql = p_cSql+"RESPANTI1,";
    p_cSql = p_cSql+"RESPANTI2,";
    p_cSql = p_cSql+"PAGAMENTO,";
    p_cSql = p_cSql+"CONCESSIONE,";
    p_cSql = p_cSql+"CODTRANSZ,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_cgo_operazioni",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000074(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ESCODICE,";
    p_cSql = p_cSql+"ESCONNES,";
    p_cSql = p_cSql+"ESCODDIP,";
    p_cSql = p_cSql+"ESIDTICKET,";
    p_cSql = p_cSql+"ESDATREP,";
    p_cSql = p_cSql+"ESNUMREP,";
    p_cSql = p_cSql+"ESNOMREP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_stampeav",true);
    return p_cSql;
  }
}
