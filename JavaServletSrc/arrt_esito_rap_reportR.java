// * --- Area Manuale = BO - Header
// * --- arrt_esito_rap_report
import java.io.File; 
import java.lang.Double;

import jxl.CellReferenceHelper;
import jxl.CellView;
import jxl.HeaderFooter;
import jxl.Range;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.PageOrder;
import jxl.format.PageOrientation;
import jxl.format.PaperSize;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Blank;
import jxl.write.Boolean;
import jxl.write.DateFormat;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableHyperlink;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
// * --- Fine Area Manuale
public class arrt_esito_rap_reportR implements CallerWithObjs {
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
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_esiti_age;
  public String m_cServer_tmp_esiti_age;
  public String m_cPhName_tbesitoae;
  public String m_cServer_tbesitoae;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aefiles_esiti;
  public String m_cServer_aefiles_esiti;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_operazbo;
  public String m_cServer_operazbo;
  public String m_cPhName_fraziobo;
  public String m_cServer_fraziobo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbtipdoc;
  public String m_cServer_tbtipdoc;
  public String m_cPhName_tmp_newpers;
  public String m_cServer_tmp_newpers;
  public String m_cPhName_tmp_apecod;
  public String m_cServer_tmp_apecod;
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
  public String pOut;
  public String w_tipoelab;
  public String _intercf;
  public String _intercg;
  public String _internm;
  public String _interrs;
  public String _interpr;
  public String _interid;
  public String _interinfo;
  public String _connes;
  public double _i;
  public double _totale;
  public String _numprog;
  public String _rapporto;
  public String _idfileimp;
  public java.sql.Date _datesito;
  public String _numope;
  public double _importo;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _contacicli;
  public double _cicli;
  public double _bottom;
  public double _top;
  public String stringa;
  public String numero;
  public String dataoggi;
  public String numprog;
  public String _testa;
  public String nomefile;
  public String _codfisc;
  public String _ragsoc;
  public String prvnas;
  public String _sex;
  public String _cognome;
  public String _nome;
  public String _nascomun;
  public String _nasstato;
  public String sesso;
  public java.sql.Date _datnas;
  public String datnas;
  public String _luonas;
  public String _autril;
  public String _numdoc;
  public String _coddip;
  public String _prot;
  public String _info;
  public String _nfile;
  public String _idfile;
  public String _progrec;
  public String _cod;
  public String _sottocod;
  public String _idesito;
  public String _descricod;
  public String _descriscod;
  public String _tipoesito;
  public double _impope;
  public String _dataope;
  public double _nprog;
  public String _tipodoc;
  public String nomefoglio;
  public MemoryCursor_tbtipdoc mcTipDoc;
  public String _tpdoc;
  public String gDescAzi;
  public String gMsgImp;
  public String gMsgProc;
  public String gAzienda;
  public String gPathApp;
  public String gUrlApp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_esito_rap_report
  public int riga;
  public DateTime dt;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_esito_rap_reportR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_esito_rap_report",m_Caller);
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_tmp_esiti_age = p_ContextObject.GetPhName("tmp_esiti_age");
    if (m_cPhName_tmp_esiti_age.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_esiti_age = m_cPhName_tmp_esiti_age+" "+m_Ctx.GetWritePhName("tmp_esiti_age");
    }
    m_cServer_tmp_esiti_age = p_ContextObject.GetServer("tmp_esiti_age");
    m_cPhName_tbesitoae = p_ContextObject.GetPhName("tbesitoae");
    if (m_cPhName_tbesitoae.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbesitoae = m_cPhName_tbesitoae+" "+m_Ctx.GetWritePhName("tbesitoae");
    }
    m_cServer_tbesitoae = p_ContextObject.GetServer("tbesitoae");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    if (m_cPhName_aerighe.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aerighe = m_cPhName_aerighe+" "+m_Ctx.GetWritePhName("aerighe");
    }
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aefiles_esiti = p_ContextObject.GetPhName("aefiles_esiti");
    if (m_cPhName_aefiles_esiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefiles_esiti = m_cPhName_aefiles_esiti+" "+m_Ctx.GetWritePhName("aefiles_esiti");
    }
    m_cServer_aefiles_esiti = p_ContextObject.GetServer("aefiles_esiti");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_operazbo = p_ContextObject.GetPhName("operazbo");
    if (m_cPhName_operazbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_operazbo = m_cPhName_operazbo+" "+m_Ctx.GetWritePhName("operazbo");
    }
    m_cServer_operazbo = p_ContextObject.GetServer("operazbo");
    m_cPhName_fraziobo = p_ContextObject.GetPhName("fraziobo");
    if (m_cPhName_fraziobo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_fraziobo = m_cPhName_fraziobo+" "+m_Ctx.GetWritePhName("fraziobo");
    }
    m_cServer_fraziobo = p_ContextObject.GetServer("fraziobo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbtipdoc = p_ContextObject.GetPhName("tbtipdoc");
    if (m_cPhName_tbtipdoc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbtipdoc = m_cPhName_tbtipdoc+" "+m_Ctx.GetWritePhName("tbtipdoc");
    }
    m_cServer_tbtipdoc = p_ContextObject.GetServer("tbtipdoc");
    m_cPhName_tmp_newpers = p_ContextObject.GetPhName("tmp_newpers");
    if (m_cPhName_tmp_newpers.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_newpers = m_cPhName_tmp_newpers+" "+m_Ctx.GetWritePhName("tmp_newpers");
    }
    m_cServer_tmp_newpers = p_ContextObject.GetServer("tmp_newpers");
    m_cPhName_tmp_apecod = p_ContextObject.GetPhName("tmp_apecod");
    if (m_cPhName_tmp_apecod.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_apecod = m_cPhName_tmp_apecod+" "+m_Ctx.GetWritePhName("tmp_apecod");
    }
    m_cServer_tmp_apecod = p_ContextObject.GetServer("tmp_apecod");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      return _importo;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_impope",p_cVarName)) {
      return _impope;
    }
    if (CPLib.eqr("_nprog",p_cVarName)) {
      return _nprog;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_esito_rap_report";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipoelab",p_cVarName)) {
      return w_tipoelab;
    }
    if (CPLib.eqr("pOut",p_cVarName)) {
      return pOut;
    }
    if (CPLib.eqr("_intercf",p_cVarName)) {
      return _intercf;
    }
    if (CPLib.eqr("_intercg",p_cVarName)) {
      return _intercg;
    }
    if (CPLib.eqr("_internm",p_cVarName)) {
      return _internm;
    }
    if (CPLib.eqr("_interrs",p_cVarName)) {
      return _interrs;
    }
    if (CPLib.eqr("_interpr",p_cVarName)) {
      return _interpr;
    }
    if (CPLib.eqr("_interid",p_cVarName)) {
      return _interid;
    }
    if (CPLib.eqr("_interinfo",p_cVarName)) {
      return _interinfo;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      return _numprog;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      return _rapporto;
    }
    if (CPLib.eqr("_idfileimp",p_cVarName)) {
      return _idfileimp;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      return _numope;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      return stringa;
    }
    if (CPLib.eqr("numero",p_cVarName)) {
      return numero;
    }
    if (CPLib.eqr("dataoggi",p_cVarName)) {
      return dataoggi;
    }
    if (CPLib.eqr("numprog",p_cVarName)) {
      return numprog;
    }
    if (CPLib.eqr("_testa",p_cVarName)) {
      return _testa;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      return _codfisc;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      return _ragsoc;
    }
    if (CPLib.eqr("prvnas",p_cVarName)) {
      return prvnas;
    }
    if (CPLib.eqr("_sex",p_cVarName)) {
      return _sex;
    }
    if (CPLib.eqr("_cognome",p_cVarName)) {
      return _cognome;
    }
    if (CPLib.eqr("_nome",p_cVarName)) {
      return _nome;
    }
    if (CPLib.eqr("_nascomun",p_cVarName)) {
      return _nascomun;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      return _nasstato;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      return sesso;
    }
    if (CPLib.eqr("datnas",p_cVarName)) {
      return datnas;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      return _luonas;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      return _autril;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      return _numdoc;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      return _coddip;
    }
    if (CPLib.eqr("_prot",p_cVarName)) {
      return _prot;
    }
    if (CPLib.eqr("_info",p_cVarName)) {
      return _info;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      return _nfile;
    }
    if (CPLib.eqr("_idfile",p_cVarName)) {
      return _idfile;
    }
    if (CPLib.eqr("_progrec",p_cVarName)) {
      return _progrec;
    }
    if (CPLib.eqr("_cod",p_cVarName)) {
      return _cod;
    }
    if (CPLib.eqr("_sottocod",p_cVarName)) {
      return _sottocod;
    }
    if (CPLib.eqr("_idesito",p_cVarName)) {
      return _idesito;
    }
    if (CPLib.eqr("_descricod",p_cVarName)) {
      return _descricod;
    }
    if (CPLib.eqr("_descriscod",p_cVarName)) {
      return _descriscod;
    }
    if (CPLib.eqr("_tipoesito",p_cVarName)) {
      return _tipoesito;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      return _dataope;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      return _tipodoc;
    }
    if (CPLib.eqr("nomefoglio",p_cVarName)) {
      return nomefoglio;
    }
    if (CPLib.eqr("_tpdoc",p_cVarName)) {
      return _tpdoc;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_datesito",p_cVarName)) {
      return _datesito;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      return _datnas;
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
    if (CPLib.eqr("mcTipDoc",p_cVarName)) {
      return mcTipDoc;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
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
    if (CPLib.eqr("_impope",p_cVarName)) {
      _impope = value;
      return;
    }
    if (CPLib.eqr("_nprog",p_cVarName)) {
      _nprog = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipoelab",p_cVarName)) {
      w_tipoelab = value;
      return;
    }
    if (CPLib.eqr("pOut",p_cVarName)) {
      pOut = value;
      return;
    }
    if (CPLib.eqr("_intercf",p_cVarName)) {
      _intercf = value;
      return;
    }
    if (CPLib.eqr("_intercg",p_cVarName)) {
      _intercg = value;
      return;
    }
    if (CPLib.eqr("_internm",p_cVarName)) {
      _internm = value;
      return;
    }
    if (CPLib.eqr("_interrs",p_cVarName)) {
      _interrs = value;
      return;
    }
    if (CPLib.eqr("_interpr",p_cVarName)) {
      _interpr = value;
      return;
    }
    if (CPLib.eqr("_interid",p_cVarName)) {
      _interid = value;
      return;
    }
    if (CPLib.eqr("_interinfo",p_cVarName)) {
      _interinfo = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_numprog",p_cVarName)) {
      _numprog = value;
      return;
    }
    if (CPLib.eqr("_rapporto",p_cVarName)) {
      _rapporto = value;
      return;
    }
    if (CPLib.eqr("_idfileimp",p_cVarName)) {
      _idfileimp = value;
      return;
    }
    if (CPLib.eqr("_numope",p_cVarName)) {
      _numope = value;
      return;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      stringa = value;
      return;
    }
    if (CPLib.eqr("numero",p_cVarName)) {
      numero = value;
      return;
    }
    if (CPLib.eqr("dataoggi",p_cVarName)) {
      dataoggi = value;
      return;
    }
    if (CPLib.eqr("numprog",p_cVarName)) {
      numprog = value;
      return;
    }
    if (CPLib.eqr("_testa",p_cVarName)) {
      _testa = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("_codfisc",p_cVarName)) {
      _codfisc = value;
      return;
    }
    if (CPLib.eqr("_ragsoc",p_cVarName)) {
      _ragsoc = value;
      return;
    }
    if (CPLib.eqr("prvnas",p_cVarName)) {
      prvnas = value;
      return;
    }
    if (CPLib.eqr("_sex",p_cVarName)) {
      _sex = value;
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
    if (CPLib.eqr("_nascomun",p_cVarName)) {
      _nascomun = value;
      return;
    }
    if (CPLib.eqr("_nasstato",p_cVarName)) {
      _nasstato = value;
      return;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      sesso = value;
      return;
    }
    if (CPLib.eqr("datnas",p_cVarName)) {
      datnas = value;
      return;
    }
    if (CPLib.eqr("_luonas",p_cVarName)) {
      _luonas = value;
      return;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      _autril = value;
      return;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      _numdoc = value;
      return;
    }
    if (CPLib.eqr("_coddip",p_cVarName)) {
      _coddip = value;
      return;
    }
    if (CPLib.eqr("_prot",p_cVarName)) {
      _prot = value;
      return;
    }
    if (CPLib.eqr("_info",p_cVarName)) {
      _info = value;
      return;
    }
    if (CPLib.eqr("_nfile",p_cVarName)) {
      _nfile = value;
      return;
    }
    if (CPLib.eqr("_idfile",p_cVarName)) {
      _idfile = value;
      return;
    }
    if (CPLib.eqr("_progrec",p_cVarName)) {
      _progrec = value;
      return;
    }
    if (CPLib.eqr("_cod",p_cVarName)) {
      _cod = value;
      return;
    }
    if (CPLib.eqr("_sottocod",p_cVarName)) {
      _sottocod = value;
      return;
    }
    if (CPLib.eqr("_idesito",p_cVarName)) {
      _idesito = value;
      return;
    }
    if (CPLib.eqr("_descricod",p_cVarName)) {
      _descricod = value;
      return;
    }
    if (CPLib.eqr("_descriscod",p_cVarName)) {
      _descriscod = value;
      return;
    }
    if (CPLib.eqr("_tipoesito",p_cVarName)) {
      _tipoesito = value;
      return;
    }
    if (CPLib.eqr("_dataope",p_cVarName)) {
      _dataope = value;
      return;
    }
    if (CPLib.eqr("_tipodoc",p_cVarName)) {
      _tipodoc = value;
      return;
    }
    if (CPLib.eqr("nomefoglio",p_cVarName)) {
      nomefoglio = value;
      return;
    }
    if (CPLib.eqr("_tpdoc",p_cVarName)) {
      _tpdoc = value;
      return;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_datesito",p_cVarName)) {
      _datesito = value;
      return;
    }
    if (CPLib.eqr("_datnas",p_cVarName)) {
      _datnas = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTipDoc",p_cVarName)) {
      mcTipDoc = (MemoryCursor_tbtipdoc)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbtipdoc=null;
    CPResultSet Cursor_qbe_esiage_limiti=null;
    CPResultSet Cursor_qbe_esiti_age_prn=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pOut Char(1) */
      /* w_tipoelab Char(1) */
      /* _intercf Char(16) */
      /* _intercg Char(26) */
      /* _internm Char(25) */
      /* _interrs Char(70) */
      /* _interpr Char(17) */
      /* _interid Char(15) */
      /* _interinfo Char(240) */
      /* _connes Char(16) */
      /* _i Numeric(2, 0) */
      /* _totale Numeric(10, 0) */
      /* _numprog Char(25) */
      /* _rapporto Char(25) */
      /* _idfileimp Char(10) */
      /* _datesito Date */
      /* _numope Char(11) */
      /* _importo Numeric(15, 0) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* stringa Char(1) */
      /* numero Char(1) */
      /* dataoggi Char(8) */
      /* numprog Char(11) */
      /* _testa Char(50) */
      /* nomefile Char(50) */
      /* _connes Char(16) */
      /* _codfisc Char(16) */
      /* _ragsoc Char(30) */
      /* prvnas Char(2) */
      /* _sex Char(1) */
      /* _cognome Char(30) */
      /* _nome Char(1) */
      /* _nascomun Char(30) */
      /* _nasstato Char(30) */
      /* sesso Char(40) */
      /* _datnas Date */
      /* datnas Char(8) */
      /* _luonas Char(40) */
      /* _autril Char(30) */
      /* _numdoc Char(20) */
      /* _coddip Char(6) */
      /* _prot Char(17) */
      /* _info Char(240) */
      /* _nfile Char(240) */
      /* _idfile Char(15) */
      /* _progrec Char(25) */
      /* _cod Char(3) */
      /* _sottocod Char(1) */
      /* _idesito Char(8) */
      /* _descricod Memo */
      /* _descriscod Memo */
      /* _tipoesito Char(1) */
      /* _impope Numeric(10, 2) */
      /* _dataope Char(10) */
      /* _nprog Numeric(15, 0) */
      /* _tipodoc Char(25) */
      /* nomefoglio Char(50) */
      /* mcTipDoc MemoryCursor(tbtipdoc) */
      /* _tpdoc Char(2) */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gMsgProc := 'Ora Inizio Creazione File Excel: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Creazione File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from tbtipdoc
      m_cServer = m_Ctx.GetServer("tbtipdoc");
      m_cPhName = m_Ctx.GetPhName("tbtipdoc");
      if (Cursor_tbtipdoc!=null)
        Cursor_tbtipdoc.Close();
      Cursor_tbtipdoc = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbtipdoc")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tbtipdoc.Eof())) {
        /* mcTipDoc.AppendWithKey(tbtipdoc->TIPDOC) */
        mcTipDoc.AppendWithKey(Cursor_tbtipdoc.GetString("TIPDOC"));
        /* mcTipDoc.TIPDOC := tbtipdoc->TIPDOC */
        mcTipDoc.row.TIPDOC = Cursor_tbtipdoc.GetString("TIPDOC");
        /* mcTipDoc.DESCRI := tbtipdoc->DESCRI */
        mcTipDoc.row.DESCRI = Cursor_tbtipdoc.GetString("DESCRI");
        /* mcTipDoc.SaveRow() */
        mcTipDoc.SaveRow();
        Cursor_tbtipdoc.Next();
      }
      m_cConnectivityError = Cursor_tbtipdoc.ErrorMessage();
      Cursor_tbtipdoc.Close();
      // * --- End Select
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      /* gMsgImp := 'Verifica operazioni da elaborare ...' // Messaggio Import */
      gMsgImp = "Verifica operazioni da elaborare ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Prima gli italiani */
      // * --- Select from qbe_esiage_limiti
      if (Cursor_qbe_esiage_limiti!=null)
        Cursor_qbe_esiage_limiti.Close();
      Cursor_qbe_esiage_limiti = new VQRHolder("qbe_esiage_limiti",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_esiage_limiti.Eof())) {
        /* _min := qbe_esiage_limiti->MINRIGA */
        _min = CPLib.Round(Cursor_qbe_esiage_limiti.GetDouble("MINRIGA"),0);
        /* _max := qbe_esiage_limiti->MAXRIGA */
        _max = CPLib.Round(Cursor_qbe_esiage_limiti.GetDouble("MAXRIGA"),0);
        Cursor_qbe_esiage_limiti.Next();
      }
      m_cConnectivityError = Cursor_qbe_esiage_limiti.ErrorMessage();
      Cursor_qbe_esiage_limiti.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry00000062status;
      nTry00000062status = m_Sql.GetTransactionStatus();
      String cTry00000062msg;
      cTry00000062msg = m_Sql.TransactionErrorMessage();
      try {
        /* Cicla sul file della lista e lancia la stampa appropriata */
        /* _testa := LRTrim(gAzienda)+"_Esiti_AGE_"+DateToChar(Date())+".xls" */
        _testa = CPLib.LRTrim(gAzienda)+"_Esiti_AGE_"+CPLib.DateToChar(CPLib.Date())+".xls";
        /* nomefile := LRTrim(gPathApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(_testa) */
        nomefile = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_testa);
        // Crea il foglio e scrive la testata
        WorkbookSettings ws = new WorkbookSettings();
        WritableWorkbook prova = Workbook.createWorkbook(new File(nomefile), ws);
        conta = 0;
        nomefoglio="Esiti Agenzia Entrate"+conta;
        WritableSheet foglio = prova.createSheet(nomefoglio, conta);
        WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
        WritableCellFormat arial11format = new WritableCellFormat (arial11font);
        WritableCellFormat intNum = new WritableCellFormat(NumberFormats.INTEGER);
        WritableCellFormat dblNum = new WritableCellFormat(NumberFormats.FLOAT);
        DateFormat df = new DateFormat("dd-mm-yyyy");
        WritableCellFormat cf1 = new WritableCellFormat(df);
        Label stringa = new Label(0,0,"Protocollo",arial11format);
        foglio.addCell(stringa); 
        stringa = new Label(1,0,"INFO",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(2,0,"NFILE",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(3,0,"IDFILE'",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(4,0,"PROGREC",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(5,0,"NUMPROG",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(6,0,"Tipo Errore",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(7,0,"Descrizione",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(8,0,"Specifica Errore",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(9,0,"Descrizione",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(10,0,"ID Esito",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(11,0,"Tipo Esito",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(12,0,"Codice Dipendenza",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(13,0,"Data Operazione",arial11format);
        foglio.addCell(stringa); 
        stringa = new Label(14,0,"Importo Operazione",arial11format);
        foglio.addCell(stringa); 
        stringa = new Label(15,0,"N° Operazione",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(16,0,"Codice Soggetto",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(17,0,"Codice Fiscale",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(18,0,"Ragione Sociale",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(19,0,"Luogo Di Nascita",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(20,0,"Prov. Nascita",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(21,0,"Sesso",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(22,0,"Data di Nascita",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(23,0,"Tipo Documento",arial11format);
        foglio.addCell(stringa);
        stringa = new Label(24,0,"Autorità Rilascio",arial11format);
        foglio.addCell(stringa);
        riga=2;
        /* While _contacicli<=_cicli */
        while (CPLib.le(_contacicli,_cicli)) {
          /* _bottom := ((_contacicli -1 ) * 1000) + 1 */
          _bottom = CPLib.Round(((_contacicli-1)*1000)+1,0);
          /* _top := _contacicli * 1000 */
          _top = CPLib.Round(_contacicli*1000,0);
          /* gMsgProc := gMsgProc + 'Elaboro ciclo operazioni N. '+ LRTrim(Str(_contacicli,15,0)) + " su " + LRTrim(Str(_cicli,15,0)) + NL */
          gMsgProc = gMsgProc+"Elaboro ciclo operazioni N. "+CPLib.LRTrim(CPLib.Str(_contacicli,15,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,15,0))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // * --- Select from qbe_esiti_age_prn
          SPBridge.HMCaller _h0000006C;
          _h0000006C = new SPBridge.HMCaller();
          _h0000006C.Set("m_cVQRList",m_cVQRList);
          _h0000006C.Set("_bottom",_bottom);
          _h0000006C.Set("_top",_top);
          if (Cursor_qbe_esiti_age_prn!=null)
            Cursor_qbe_esiti_age_prn.Close();
          Cursor_qbe_esiti_age_prn = new VQRHolder("qbe_esiti_age_prn",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000006C,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_esiti_age_prn.Eof())) {
            /* gMsgImp := 'Elaboro Operazione N.' + qbe_esiti_age_prn->PROGREC // Messaggio Import */
            gMsgImp = "Elaboro Operazione N."+Cursor_qbe_esiti_age_prn.GetString("PROGREC");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _connes := '' */
            _connes = "";
            /* _numope := '' */
            _numope = "";
            /* _importo := 0 */
            _importo = CPLib.Round(0,0);
            /* _coddip := '' */
            _coddip = "";
            /* _codfisc := '' */
            _codfisc = "";
            /* _ragsoc := '' */
            _ragsoc = "";
            /* prvnas := '' */
            prvnas = "";
            /* sesso := '' */
            sesso = "";
            /* _sex := '' */
            _sex = "";
            /* _datnas := NullDate() */
            _datnas = CPLib.NullDate();
            /* _luonas := '' */
            _luonas = "";
            /* _tpdoc := '' */
            _tpdoc = "";
            /* _tipodoc := '' */
            _tipodoc = "";
            /* _autril := '' */
            _autril = "";
            /* _nascomun := '' */
            _nascomun = "";
            /* _nasstato := '' */
            _nasstato = "";
            // * --- Read from personbo
            m_cServer = m_Ctx.GetServer("personbo");
            m_cPhName = m_Ctx.GetPhName("personbo");
            m_cSql = "";
            m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_esiti_age_prn.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_esiti_age_prn.GetString("CONNESINT"));
            if (m_Ctx.IsSharedTemp("personbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATANASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASCOMUN",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPODOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AUTRILASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPINTER",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASSTATO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COGNOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _connes = Read_Cursor.GetString("CONNES");
              _codfisc = Read_Cursor.GetString("CODFISC");
              _datnas = Read_Cursor.GetDate("DATANASC");
              _nascomun = Read_Cursor.GetString("NASCOMUN");
              _tpdoc = Read_Cursor.GetString("TIPODOC");
              _autril = Read_Cursor.GetString("AUTRILASC");
              prvnas = Read_Cursor.GetString("TIPINTER");
              _nasstato = Read_Cursor.GetString("NASSTATO");
              _nome = Read_Cursor.GetString("NOME");
              _cognome = Read_Cursor.GetString("COGNOME");
              _sex = Read_Cursor.GetString("SESSO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on personbo into routine arrt_esito_rap_report returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _connes = "";
              _codfisc = "";
              _datnas = CPLib.NullDate();
              _nascomun = "";
              _tpdoc = "";
              _autril = "";
              prvnas = "";
              _nasstato = "";
              _nome = "";
              _cognome = "";
              _sex = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_connes)) */
            if (CPLib.Empty(CPLib.LRTrim(_connes))) {
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CODFISC="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_esiti_age_prn.GetString("CONNESINT"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_esiti_age_prn.GetString("CONNESINT"));
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODFISC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATANASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASCOMUN",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPODOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AUTRILASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TIPINTER",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NASSTATO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("COGNOME",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("SESSO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _connes = Read_Cursor.GetString("CONNES");
                _codfisc = Read_Cursor.GetString("CODFISC");
                _datnas = Read_Cursor.GetDate("DATANASC");
                _nascomun = Read_Cursor.GetString("NASCOMUN");
                _tpdoc = Read_Cursor.GetString("TIPODOC");
                _autril = Read_Cursor.GetString("AUTRILASC");
                prvnas = Read_Cursor.GetString("TIPINTER");
                _nasstato = Read_Cursor.GetString("NASSTATO");
                _nome = Read_Cursor.GetString("NOME");
                _cognome = Read_Cursor.GetString("COGNOME");
                _sex = Read_Cursor.GetString("SESSO");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_esito_rap_report returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _connes = "";
                _codfisc = "";
                _datnas = CPLib.NullDate();
                _nascomun = "";
                _tpdoc = "";
                _autril = "";
                prvnas = "";
                _nasstato = "";
                _nome = "";
                _cognome = "";
                _sex = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            // * --- Read from operazbo
            m_cServer = m_Ctx.GetServer("operazbo");
            m_cPhName = m_Ctx.GetPhName("operazbo");
            m_cSql = "";
            m_cSql = m_cSql+"DATAOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_esiti_age_prn.GetDate("ADATA"),"D",8,0,m_cServer),m_cServer,Cursor_qbe_esiti_age_prn.GetDate("ADATA"));
            m_cSql = m_cSql+" and CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"C",16,0,m_cServer),m_cServer,_connes);
            if (m_Ctx.IsSharedTemp("operazbo")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TOTLIRE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _numope = Read_Cursor.GetString("NUMPROG");
              _importo = CPLib.Round(Read_Cursor.GetDouble("TOTLIRE"),0);
              _coddip = Read_Cursor.GetString("CODDIPE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on operazbo into routine arrt_esito_rap_report returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _numope = "";
              _importo = 0;
              _coddip = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(LRTrim(_numope)) */
            if (CPLib.Empty(CPLib.LRTrim(_numope))) {
              // * --- Read from fraziobo
              m_cServer = m_Ctx.GetServer("fraziobo");
              m_cPhName = m_Ctx.GetPhName("fraziobo");
              m_cSql = "";
              m_cSql = m_cSql+"DATAOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_esiti_age_prn.GetDate("ADATA"),"D",8,0,m_cServer),m_cServer,Cursor_qbe_esiti_age_prn.GetDate("ADATA"));
              m_cSql = m_cSql+" and CONNESCLI="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"C",16,0,m_cServer),m_cServer,_connes);
              if (m_Ctx.IsSharedTemp("fraziobo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("NUMPROG",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TOTLIRE",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODDIPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _numope = Read_Cursor.GetString("NUMPROG");
                _importo = CPLib.Round(Read_Cursor.GetDouble("TOTLIRE"),0);
                _coddip = Read_Cursor.GetString("CODDIPE");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on fraziobo into routine arrt_esito_rap_report returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _numope = "";
                _importo = 0;
                _coddip = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
            /* If pOut='X' */
            if (CPLib.eqr(pOut,"X")) {
              /* _prot := '' */
              _prot = "";
              /* _info := '' */
              _info = "";
              /* _nfile := '' */
              _nfile = "";
              /* _idfile := '' */
              _idfile = "";
              /* _progrec := '' */
              _progrec = "";
              /* _nprog := 0 */
              _nprog = CPLib.Round(0,0);
              /* _cod := '' */
              _cod = "";
              /* _sottocod := '' */
              _sottocod = "";
              /* _idesito := '' */
              _idesito = "";
              /* _descricod := '' */
              _descricod = "";
              /* _descriscod := '' */
              _descriscod = "";
              /* _tipoesito := '' */
              _tipoesito = "";
              /* _impope := 0 */
              _impope = CPLib.Round(0,2);
              /* _dataope := '' */
              _dataope = "";
              /* _nprog :=  */
              /* _prot := qbe_esiti_age_prn->PROT */
              _prot = Cursor_qbe_esiti_age_prn.GetString("PROT");
              /* _info := LRTrim(qbe_esiti_age_prn->INFO) */
              _info = CPLib.LRTrim(Cursor_qbe_esiti_age_prn.GetString("INFO"));
              /* _nfile := LRTrim(qbe_esiti_age_prn->NFILE) */
              _nfile = CPLib.LRTrim(Cursor_qbe_esiti_age_prn.GetString("NFILE"));
              /* _idfile := qbe_esiti_age_prn->IDFILE */
              _idfile = Cursor_qbe_esiti_age_prn.GetString("IDFILE");
              /* _progrec := qbe_esiti_age_prn->PROGREC */
              _progrec = Cursor_qbe_esiti_age_prn.GetString("PROGREC");
              /* _nprog := qbe_esiti_age_prn->NUMPROG */
              _nprog = CPLib.Round(Cursor_qbe_esiti_age_prn.GetDouble("NUMPROG"),0);
              /* _cod := qbe_esiti_age_prn->COD */
              _cod = Cursor_qbe_esiti_age_prn.GetString("COD");
              /* _sottocod := qbe_esiti_age_prn->SOTTCOD */
              _sottocod = Cursor_qbe_esiti_age_prn.GetString("SOTTCOD");
              /* _idesito := qbe_esiti_age_prn->IDESITO */
              _idesito = Cursor_qbe_esiti_age_prn.GetString("IDESITO");
              /* _descricod := LRTrim(qbe_esiti_age_prn->DESCRICOD) */
              _descricod = CPLib.LRTrim(Cursor_qbe_esiti_age_prn.GetString("DESCRICOD"));
              /* _descriscod := LRTrim(qbe_esiti_age_prn->DESCRISCOD) */
              _descriscod = CPLib.LRTrim(Cursor_qbe_esiti_age_prn.GetString("DESCRISCOD"));
              /* _tipoesito := qbe_esiti_age_prn->TIPOESITO */
              _tipoesito = Cursor_qbe_esiti_age_prn.GetString("TIPOESITO");
              /* _impope := _importo / 100 */
              _impope = CPLib.Round(_importo/100,2);
              /* _dataope := arfn_fdate(qbe_esiti_age_prn->ADATA) */
              _dataope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_esiti_age_prn.GetDate("ADATA"));
              /* _ragsoc := LRTrim(_cognome)+" "+LRTrim(_nome) */
              _ragsoc = CPLib.LRTrim(_cognome)+" "+CPLib.LRTrim(_nome);
              /* sesso := iif(_sex='1','Uomo',iif(_sex='2','Donna','')) */
              sesso = (CPLib.eqr(_sex,"1")?"Uomo":(CPLib.eqr(_sex,"2")?"Donna":""));
              /* datnas := arfn_fdate(_datnas) */
              datnas = arfn_fdateR.Make(m_Ctx,this).Run(_datnas);
              /* _luonas := iif(prvnas='EE' or prvnas='',_nasstato,_nascomun) */
              _luonas = (CPLib.eqr(prvnas,"EE") || CPLib.eqr(prvnas,"")?_nasstato:_nascomun);
              /* If mcTipDoc.GoToKey(_tpdoc) */
              if (mcTipDoc.GoToKey(_tpdoc)) {
                /* _tipodoc := mcTipDoc.DESCRI */
                _tipodoc = mcTipDoc.row.DESCRI;
              } // End If
              /* If riga=50000 */
              if (CPLib.eqr(riga,50000)) {
                //Aggiusta le colonne
                CellView cf = new CellView();
                cf.setAutosize(true);
                foglio.setColumnView(0, cf);
                foglio.setColumnView(1, cf);
                foglio.setColumnView(2, cf);
                foglio.setColumnView(3, cf);
                foglio.setColumnView(4, cf);
                foglio.setColumnView(5, cf);
                foglio.setColumnView(6, cf);
                foglio.setColumnView(7, cf);
                foglio.setColumnView(8, cf);
                foglio.setColumnView(9, cf);
                foglio.setColumnView(10, cf);
                foglio.setColumnView(11, cf);
                foglio.setColumnView(12, cf);
                foglio.setColumnView(13, cf);
                foglio.setColumnView(14, cf);
                foglio.setColumnView(15, cf);
                foglio.setColumnView(16, cf);
                foglio.setColumnView(17, cf);
                foglio.setColumnView(18, cf);
                foglio.setColumnView(19, cf);
                foglio.setColumnView(20, cf);
                foglio.setColumnView(21, cf);
                foglio.setColumnView(22, cf);
                foglio.setColumnView(23, cf);
                foglio.setColumnView(24, cf);
                // Crea il foglio nuovo e scrive la testata
                conta = conta+1;
                nomefoglio="Esiti Agenzia Entrate"+conta;
                foglio = prova.createSheet(nomefoglio, conta);
                arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
                arial11format = new WritableCellFormat (arial11font);
                intNum = new WritableCellFormat(NumberFormats.INTEGER);
                dblNum = new WritableCellFormat(NumberFormats.FLOAT);
                df = new DateFormat("dd-mm-yyyy");
                cf1 = new WritableCellFormat(df);
                stringa = new Label(0,0,"Protocollo",arial11format);
                foglio.addCell(stringa); 
                stringa = new Label(1,0,"INFO",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(2,0,"NFILE",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(3,0,"IDFILE'",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(4,0,"PROGREC",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(5,0,"NUMPROG",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(6,0,"Tipo Errore",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(7,0,"Descrizione",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(8,0,"Specifica Errore",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(9,0,"Descrizione",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(10,0,"ID Esito",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(11,0,"Tipo Esito",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(12,0,"Codice Dipendenza",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(13,0,"Data Operazione",arial11format);
                foglio.addCell(stringa); 
                stringa = new Label(14,0,"Importo Operazione",arial11format);
                foglio.addCell(stringa); 
                stringa = new Label(15,0,"N° Operazione",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(16,0,"Codice Soggetto",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(17,0,"Codice Fiscale",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(18,0,"Ragione Sociale",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(19,0,"Luogo Di Nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(20,0,"Prov. Nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(21,0,"Sesso",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(22,0,"Data di Nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(23,0,"Tipo Documento",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(24,0,"Autorità Rilascio",arial11format);
                foglio.addCell(stringa);
                riga=2;
              } // End If
              // Scrive i dati 
              stringa = new Label(0,riga,_prot);
              foglio.addCell(stringa); 
              stringa = new Label(1,riga,_info);
              foglio.addCell(stringa);
              stringa = new Label(2,riga,_nfile);
              foglio.addCell(stringa); 
              stringa = new Label(3,riga,_idfile);
              foglio.addCell(stringa);
              stringa = new Label(4,riga,_progrec);
              foglio.addCell(stringa);
              Number num1 = new Number(5,riga,_nprog,intNum);
              foglio.addCell(num1);
              stringa = new Label(6,riga,_cod);
              foglio.addCell(stringa);
              stringa = new Label(7,riga,_descricod);
              foglio.addCell(stringa);
              stringa = new Label(8,riga,_sottocod);
              foglio.addCell(stringa);
              stringa = new Label(9,riga,_descriscod);
              foglio.addCell(stringa);
              stringa = new Label(10,riga,_idesito);
              foglio.addCell(stringa);
              stringa = new Label(11,riga,_tipoesito);
              foglio.addCell(stringa);
              stringa = new Label(12,riga,_coddip);
              foglio.addCell(stringa);
              stringa = new Label(13,riga,_dataope);
              foglio.addCell(stringa);
              num1 = new Number(14,riga,_impope,dblNum);
              foglio.addCell(num1);
              stringa = new Label(15,riga,_numope);
              foglio.addCell(stringa); 
              stringa = new Label(16,riga,_connes);
              foglio.addCell(stringa); 
              stringa = new Label(17,riga,_codfisc);
              foglio.addCell(stringa); 
              stringa = new Label(18,riga,_ragsoc);
              foglio.addCell(stringa); 
              stringa = new Label(19,riga,_luonas);
              foglio.addCell(stringa); 
              stringa = new Label(20,riga,prvnas);
              foglio.addCell(stringa); 
              stringa = new Label(21,riga,sesso);
              foglio.addCell(stringa); 
              stringa = new Label(22,riga,datnas);
              foglio.addCell(stringa); 
              stringa = new Label(23,riga,_tipodoc);
              foglio.addCell(stringa); 
              stringa = new Label(24,riga,_autril);
              riga = riga + 1;
              /* ElseIf pOut='R' */
            } else if (CPLib.eqr(pOut,"R")) {
              // * --- Write into tmp_esiti_age from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_esiti_age");
              m_cPhName = m_Ctx.GetPhName("tmp_esiti_age");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_esiti_age",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_esito_rap_report",568,"000000B1")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DATAOPE = "+CPLib.ToSQL(Cursor_qbe_esiti_age_prn.GetDate("ADATA"),"D",8,0)+", ";
              m_cSql = m_cSql+"CONNES = "+CPLib.ToSQL(_connes,"C",16,0,m_cServer)+", ";
              m_cSql = m_cSql+"IMPOPE = "+CPLib.ToSQL(_importo/100,"N",10,2)+", ";
              m_cSql = m_cSql+"CODDIP = "+CPLib.ToSQL(_coddip,"C",6,0,m_cServer)+", ";
              m_cSql = m_cSql+"NUMOPE = "+CPLib.ToSQL(_numope,"C",11,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"tmp_esiti_age",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CRIGA = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_esiti_age_prn.GetDouble("CRIGA"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_esiti_age_prn.GetDouble("CRIGA"))+"";
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
            Cursor_qbe_esiti_age_prn.Next();
          }
          m_cConnectivityError = Cursor_qbe_esiti_age_prn.ErrorMessage();
          Cursor_qbe_esiti_age_prn.Close();
          // * --- End Select
          /* _contacicli := _contacicli + 1 */
          _contacicli = CPLib.Round(_contacicli+1,0);
        } // End While
        //Aggiusta le colonne
        CellView cf = new CellView();
        cf.setAutosize(true);
        foglio.setColumnView(0, cf);
        foglio.setColumnView(1, cf);
        foglio.setColumnView(2, cf);
        foglio.setColumnView(3, cf);
        foglio.setColumnView(4, cf);
        foglio.setColumnView(5, cf);
        foglio.setColumnView(6, cf);
        foglio.setColumnView(7, cf);
        foglio.setColumnView(8, cf);
        foglio.setColumnView(9, cf);
        foglio.setColumnView(10, cf);
        foglio.setColumnView(11, cf);
        foglio.setColumnView(12, cf);
        foglio.setColumnView(13, cf);
        foglio.setColumnView(14, cf);
        foglio.setColumnView(15, cf);
        foglio.setColumnView(16, cf);
        foglio.setColumnView(17, cf);
        foglio.setColumnView(18, cf);
        foglio.setColumnView(19, cf);
        foglio.setColumnView(20, cf);
        foglio.setColumnView(21, cf);
        foglio.setColumnView(22, cf);
        foglio.setColumnView(23, cf);
        foglio.setColumnView(24, cf);
        // Scrive il foglio e lo chiude
        prova.write();
        prova.close();
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000062status,0)) {
          m_Sql.SetTransactionStatus(nTry00000062status,cTry00000062msg);
        }
      }
      /* gMsgImp := 'Elaborazione Terminata !' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata !";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If pOut='R' */
      if (CPLib.eqr(pOut,"R")) {
        /* Stop Report */
        Forward f;
        f=new Forward("Report",false,this,Forward.Start,false);
        f.SetParameter("ReportName","arrp_esiti_rap_dip");
        f.SetParameter("outputFormat","PDF");
        f.SetParameter("w_DescAzi",gDescAzi);
        f.SetParameter("m_cParameterSequence","ReportName"+","+"outputFormat"+","+"w_DescAzi");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
        /* ElseIf pOut='X' */
      } else if (CPLib.eqr(pOut,"X")) {
        /* gMsgProc := gMsgProc + 'Ora Fine Creazione File Excel: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Creazione File Excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(nomefile) */
        Forward f;
        f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(nomefile),false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_tbtipdoc!=null)
          Cursor_tbtipdoc.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_esiage_limiti!=null)
          Cursor_qbe_esiage_limiti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_esiti_age_prn!=null)
          Cursor_qbe_esiti_age_prn.Close();
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
  void _init_() {
  }
  public String RunAsync(String p_pOut) {
    pOut = p_pOut;
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
  public Forward Run(String p_pOut) {
    pOut = p_pOut;
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
      m_Caller.SetString("tipoelab","C",1,0,w_tipoelab);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_esito_rap_reportR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_esito_rap_reportR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pOut = CPLib.Space(1);
    w_tipoelab = m_Caller.GetString("tipoelab","C",1,0);
    _intercf = CPLib.Space(16);
    _intercg = CPLib.Space(26);
    _internm = CPLib.Space(25);
    _interrs = CPLib.Space(70);
    _interpr = CPLib.Space(17);
    _interid = CPLib.Space(15);
    _interinfo = CPLib.Space(240);
    _connes = CPLib.Space(16);
    _i = 0;
    _totale = 0;
    _numprog = CPLib.Space(25);
    _rapporto = CPLib.Space(25);
    _idfileimp = CPLib.Space(10);
    _datesito = CPLib.NullDate();
    _numope = CPLib.Space(11);
    _importo = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _contacicli = 0;
    _cicli = 0;
    _bottom = 0;
    _top = 0;
    stringa = CPLib.Space(1);
    numero = CPLib.Space(1);
    dataoggi = CPLib.Space(8);
    numprog = CPLib.Space(11);
    _testa = CPLib.Space(50);
    nomefile = CPLib.Space(50);
    _codfisc = CPLib.Space(16);
    _ragsoc = CPLib.Space(30);
    prvnas = CPLib.Space(2);
    _sex = CPLib.Space(1);
    _cognome = CPLib.Space(30);
    _nome = CPLib.Space(1);
    _nascomun = CPLib.Space(30);
    _nasstato = CPLib.Space(30);
    sesso = CPLib.Space(40);
    _datnas = CPLib.NullDate();
    datnas = CPLib.Space(8);
    _luonas = CPLib.Space(40);
    _autril = CPLib.Space(30);
    _numdoc = CPLib.Space(20);
    _coddip = CPLib.Space(6);
    _prot = CPLib.Space(17);
    _info = CPLib.Space(240);
    _nfile = CPLib.Space(240);
    _idfile = CPLib.Space(15);
    _progrec = CPLib.Space(25);
    _cod = CPLib.Space(3);
    _sottocod = CPLib.Space(1);
    _idesito = CPLib.Space(8);
    _descricod = "";
    _descriscod = "";
    _tipoesito = CPLib.Space(1);
    _impope = 0;
    _dataope = CPLib.Space(10);
    _nprog = 0;
    _tipodoc = CPLib.Space(25);
    nomefoglio = CPLib.Space(50);
    mcTipDoc = new MemoryCursor_tbtipdoc();
    _tpdoc = CPLib.Space(2);
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_esiage_limiti,qbe_esiti_age_prn,
  public static final String m_cVQRList = ",qbe_esiage_limiti,qbe_esiti_age_prn,";
  // ENTITY_BATCHES: ,arfn_fdate,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdate,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pOut"};
}
