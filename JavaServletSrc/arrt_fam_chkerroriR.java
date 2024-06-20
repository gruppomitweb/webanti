// * --- Area Manuale = BO - Header
// * --- arrt_fam_chkerrori
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
public class arrt_fam_chkerroriR implements CallerWithObjs {
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
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_tmp_chkperiodo;
  public String m_cServer_tmp_chkperiodo;
  public String m_cPhName_tmp_impesiti;
  public String m_cServer_tmp_impesiti;
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
  public java.sql.Date w_DaDatOpe;
  public java.sql.Date w_ADatOpe;
  public String w_flgncf;
  public double _conta;
  public String _errore;
  public double _errori;
  public MemoryCursor_mcchkperiodo_mcrdef mcTemp;
  public MemoryCursorRow_mcchkperiodo_mcrdef rowTemp;
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
  public MemoryCursor_mcerrsaldi_mcrdef mcErrors;
  public double Countesito;
  public double _contaEsito;
  public String _blccf;
  public String _blcan;
  public String _rif1;
  public String _rif2;
  public String rapporto;
  public String tipoac;
  public String connes;
  public String ident;
  public String ragsoc;
  public String persona;
  public String cognome;
  public String nome;
  public String sesso;
  public String datanasc;
  public String nascomun;
  public String nasstato;
  public String tipinter;
  public String desccit;
  public String provincia;
  public String codfisc;
  public String codcab;
  public String cfestero;
  public String esito;
  public String _tipdoc;
  public String _numdoc;
  public java.sql.Date _datril;
  public String _cdatril;
  public String _autril;
  public String _datope;
  public String file;
  public String foglio;
  public String nomeesito;
  public String nomefilexls;
  public String nomefoglio;
  public String stringa;
  public String gMsgImp;
  public String gMsgProc;
  public String gDescAzi;
  public String gPathApp;
  public String gUrlApp;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_fam_chkerrori
  public int riga;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_fam_chkerroriR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_fam_chkerrori",m_Caller);
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
    if (m_Ctx.IsTmpAlreadyCreated("tmp_chkperiodo")) {
      m_cPhName_tmp_chkperiodo = p_ContextObject.GetPhName("tmp_chkperiodo");
      if (m_cPhName_tmp_chkperiodo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_chkperiodo = m_cPhName_tmp_chkperiodo+" "+m_Ctx.GetWritePhName("tmp_chkperiodo");
      }
      m_cServer_tmp_chkperiodo = p_ContextObject.GetServer("tmp_chkperiodo");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_impesiti")) {
      m_cPhName_tmp_impesiti = p_ContextObject.GetPhName("tmp_impesiti");
      if (m_cPhName_tmp_impesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_impesiti = m_cPhName_tmp_impesiti+" "+m_Ctx.GetWritePhName("tmp_impesiti");
      }
      m_cServer_tmp_impesiti = p_ContextObject.GetServer("tmp_impesiti");
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
    if (CPLib.eqr("_errori",p_cVarName)) {
      return _errori;
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
    if (CPLib.eqr("Countesito",p_cVarName)) {
      return Countesito;
    }
    if (CPLib.eqr("_contaEsito",p_cVarName)) {
      return _contaEsito;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_fam_chkerrori";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("flgncf",p_cVarName)) {
      return w_flgncf;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_blccf",p_cVarName)) {
      return _blccf;
    }
    if (CPLib.eqr("_blcan",p_cVarName)) {
      return _blcan;
    }
    if (CPLib.eqr("_rif1",p_cVarName)) {
      return _rif1;
    }
    if (CPLib.eqr("_rif2",p_cVarName)) {
      return _rif2;
    }
    if (CPLib.eqr("rapporto",p_cVarName)) {
      return rapporto;
    }
    if (CPLib.eqr("tipoac",p_cVarName)) {
      return tipoac;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      return connes;
    }
    if (CPLib.eqr("ident",p_cVarName)) {
      return ident;
    }
    if (CPLib.eqr("ragsoc",p_cVarName)) {
      return ragsoc;
    }
    if (CPLib.eqr("persona",p_cVarName)) {
      return persona;
    }
    if (CPLib.eqr("cognome",p_cVarName)) {
      return cognome;
    }
    if (CPLib.eqr("nome",p_cVarName)) {
      return nome;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      return sesso;
    }
    if (CPLib.eqr("datanasc",p_cVarName)) {
      return datanasc;
    }
    if (CPLib.eqr("nascomun",p_cVarName)) {
      return nascomun;
    }
    if (CPLib.eqr("nasstato",p_cVarName)) {
      return nasstato;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      return tipinter;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      return desccit;
    }
    if (CPLib.eqr("provincia",p_cVarName)) {
      return provincia;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      return codfisc;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      return codcab;
    }
    if (CPLib.eqr("cfestero",p_cVarName)) {
      return cfestero;
    }
    if (CPLib.eqr("esito",p_cVarName)) {
      return esito;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      return _tipdoc;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      return _numdoc;
    }
    if (CPLib.eqr("_cdatril",p_cVarName)) {
      return _cdatril;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      return _autril;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      return _datope;
    }
    if (CPLib.eqr("file",p_cVarName)) {
      return file;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      return foglio;
    }
    if (CPLib.eqr("nomeesito",p_cVarName)) {
      return nomeesito;
    }
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      return nomefilexls;
    }
    if (CPLib.eqr("nomefoglio",p_cVarName)) {
      return nomefoglio;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      return stringa;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      return w_DaDatOpe;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      return w_ADatOpe;
    }
    if (CPLib.eqr("_datril",p_cVarName)) {
      return _datril;
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
    if (CPLib.eqr("mcErrors",p_cVarName)) {
      return mcErrors;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      return rowTemp;
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
    if (CPLib.eqr("_errori",p_cVarName)) {
      _errori = value;
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
    if (CPLib.eqr("Countesito",p_cVarName)) {
      Countesito = value;
      return;
    }
    if (CPLib.eqr("_contaEsito",p_cVarName)) {
      _contaEsito = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("flgncf",p_cVarName)) {
      w_flgncf = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_blccf",p_cVarName)) {
      _blccf = value;
      return;
    }
    if (CPLib.eqr("_blcan",p_cVarName)) {
      _blcan = value;
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
    if (CPLib.eqr("rapporto",p_cVarName)) {
      rapporto = value;
      return;
    }
    if (CPLib.eqr("tipoac",p_cVarName)) {
      tipoac = value;
      return;
    }
    if (CPLib.eqr("connes",p_cVarName)) {
      connes = value;
      return;
    }
    if (CPLib.eqr("ident",p_cVarName)) {
      ident = value;
      return;
    }
    if (CPLib.eqr("ragsoc",p_cVarName)) {
      ragsoc = value;
      return;
    }
    if (CPLib.eqr("persona",p_cVarName)) {
      persona = value;
      return;
    }
    if (CPLib.eqr("cognome",p_cVarName)) {
      cognome = value;
      return;
    }
    if (CPLib.eqr("nome",p_cVarName)) {
      nome = value;
      return;
    }
    if (CPLib.eqr("sesso",p_cVarName)) {
      sesso = value;
      return;
    }
    if (CPLib.eqr("datanasc",p_cVarName)) {
      datanasc = value;
      return;
    }
    if (CPLib.eqr("nascomun",p_cVarName)) {
      nascomun = value;
      return;
    }
    if (CPLib.eqr("nasstato",p_cVarName)) {
      nasstato = value;
      return;
    }
    if (CPLib.eqr("tipinter",p_cVarName)) {
      tipinter = value;
      return;
    }
    if (CPLib.eqr("desccit",p_cVarName)) {
      desccit = value;
      return;
    }
    if (CPLib.eqr("provincia",p_cVarName)) {
      provincia = value;
      return;
    }
    if (CPLib.eqr("codfisc",p_cVarName)) {
      codfisc = value;
      return;
    }
    if (CPLib.eqr("codcab",p_cVarName)) {
      codcab = value;
      return;
    }
    if (CPLib.eqr("cfestero",p_cVarName)) {
      cfestero = value;
      return;
    }
    if (CPLib.eqr("esito",p_cVarName)) {
      esito = value;
      return;
    }
    if (CPLib.eqr("_tipdoc",p_cVarName)) {
      _tipdoc = value;
      return;
    }
    if (CPLib.eqr("_numdoc",p_cVarName)) {
      _numdoc = value;
      return;
    }
    if (CPLib.eqr("_cdatril",p_cVarName)) {
      _cdatril = value;
      return;
    }
    if (CPLib.eqr("_autril",p_cVarName)) {
      _autril = value;
      return;
    }
    if (CPLib.eqr("_datope",p_cVarName)) {
      _datope = value;
      return;
    }
    if (CPLib.eqr("file",p_cVarName)) {
      file = value;
      return;
    }
    if (CPLib.eqr("foglio",p_cVarName)) {
      foglio = value;
      return;
    }
    if (CPLib.eqr("nomeesito",p_cVarName)) {
      nomeesito = value;
      return;
    }
    if (CPLib.eqr("nomefilexls",p_cVarName)) {
      nomefilexls = value;
      return;
    }
    if (CPLib.eqr("nomefoglio",p_cVarName)) {
      nomefoglio = value;
      return;
    }
    if (CPLib.eqr("stringa",p_cVarName)) {
      stringa = value;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
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
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DaDatOpe",p_cVarName)) {
      w_DaDatOpe = value;
      return;
    }
    if (CPLib.eqr("ADatOpe",p_cVarName)) {
      w_ADatOpe = value;
      return;
    }
    if (CPLib.eqr("_datril",p_cVarName)) {
      _datril = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      rowTemp = (MemoryCursorRow_mcchkperiodo_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      mcTemp = (MemoryCursor_mcchkperiodo_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcErrors",p_cVarName)) {
      mcErrors = (MemoryCursor_mcerrsaldi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_fam_periodo01_minmax=null;
    CPResultSet Cursor_qbe_fam_periodo01_minmax_agg=null;
    CPResultSet Cursor_qbe_fam_chkperiodo_01_2015=null;
    CPResultSet Cursor_qbe_fam_chkperiodo_01_2015_agg=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_DaDatOpe Date */
      /* w_ADatOpe Date */
      /* w_flgncf Char(1) */
      /* _conta Numeric(10, 0) */
      /* _errore Memo */
      /* _errori Numeric(10, 0) */
      /* mcTemp MemoryCursor(mcChkPeriodo.MCRDef) */
      /* rowTemp Row(mcChkPeriodo.MCRDef) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _mono Numeric(1, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _totrecord Numeric(10, 0) */
      /* _reccount Numeric(10, 0) */
      /* _oldmsg Memo */
      /* mcErrors MemoryCursor(mcErrSaldi.MCRDef) */
      /* Countesito Numeric(6, 0) // Contatore d'esito */
      /* _contaEsito Numeric(6, 0) // conteggio per esito */
      /* _blccf Char(1) */
      /* _blcan Char(1) */
      /* _rif1 Char(9) */
      /* _rif2 Char(30) */
      /* rapporto Char(25) */
      /* tipoac Char(50) */
      /* connes Char(16) */
      /* ident Char(15) */
      /* ragsoc Char(30) */
      /* persona Char(10) */
      /* cognome Char(26) */
      /* nome Char(25) */
      /* sesso Char(1) */
      /* datanasc Char(10) */
      /* nascomun Char(30) */
      /* nasstato Char(30) */
      /* tipinter Char(2) */
      /* desccit Char(30) */
      /* provincia Char(2) */
      /* codfisc Char(16) */
      /* codcab Char(6) */
      /* cfestero Char(1) */
      /* esito Memo */
      /* _tipdoc Char(2) */
      /* _numdoc Char(15) */
      /* _datril Date */
      /* _cdatril Char(10) */
      /* _autril Char(30) */
      /* _datope Char(10) */
      /* file Char(1) */
      /* foglio Char(1) */
      /* nomeesito Char(50) */
      /* nomefilexls Char(50) */
      /* nomefoglio Char(50) */
      /* stringa Char(1) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gDescAzi Char(70) // Descrizione Intermediario */
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      /* gMsgProc := 'Ora Inizio  Elaborazione periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = "Ora Inizio  Elaborazione periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Drop temporary table tmp_chkperiodo
      if (m_Ctx.IsSharedTemp("tmp_chkperiodo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chkperiodo")) {
          m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
          m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chkperiodo");
      }
      // * --- Create temporary table tmp_chkperiodo
      if (m_Ctx.IsSharedTemp("tmp_chkperiodo")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_chkperiodo")) {
          m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
          m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_chkperiodo");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_chkperiodo");
      if ( ! (m_Ctx.IsSharedTemp("tmp_chkperiodo"))) {
        m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_chkperiodo",m_cServer,"proto")),m_cPhName,"tmp_chkperiodo",m_Ctx,new String[]{"RAPPORTO","NDG"});
      }
      m_cPhName_tmp_chkperiodo = m_cPhName;
      // * --- Drop temporary table tmp_impesiti
      if (m_Ctx.IsSharedTemp("tmp_impesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_impesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_impesiti");
      }
      // * --- Create temporary table tmp_impesiti
      if (m_Ctx.IsSharedTemp("tmp_impesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_impesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_impesiti");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_impesiti");
      if ( ! (m_Ctx.IsSharedTemp("tmp_impesiti"))) {
        m_cServer = m_Ctx.GetServer("tmp_impesiti");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_impesiti",m_cServer,"proto")),m_cPhName,"tmp_impesiti",m_Ctx);
      }
      m_cPhName_tmp_impesiti = m_cPhName;
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
      /* gMsgProc := gMsgProc + "Estrazione dati per il periodo" + NL // Messaggio */
      gMsgProc = gMsgProc+"Estrazione dati per il periodo"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
      gMsgImp = "Attendere. Estrazione dati per il periodo ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_fam_periodo01_minmax
      SPBridge.HMCaller _h00000050;
      _h00000050 = new SPBridge.HMCaller();
      _h00000050.Set("m_cVQRList",m_cVQRList);
      _h00000050.Set("_dadata",w_DaDatOpe);
      _h00000050.Set("_adata",w_ADatOpe);
      _h00000050.Set("_inviato",1);
      if (Cursor_qbe_fam_periodo01_minmax!=null)
        Cursor_qbe_fam_periodo01_minmax.Close();
      Cursor_qbe_fam_periodo01_minmax = new VQRHolder("qbe_fam_periodo01_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000050,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_fam_periodo01_minmax.Eof())) {
        /* _totrecord := _totrecord + qbe_fam_periodo01_minmax->TOTPRG */
        _totrecord = CPLib.Round(_totrecord+Cursor_qbe_fam_periodo01_minmax.GetDouble("TOTPRG"),0);
        Cursor_qbe_fam_periodo01_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_fam_periodo01_minmax.ErrorMessage();
      Cursor_qbe_fam_periodo01_minmax.Close();
      // * --- End Select
      // * --- Select from qbe_fam_periodo01_minmax_agg
      SPBridge.HMCaller _h00000052;
      _h00000052 = new SPBridge.HMCaller();
      _h00000052.Set("m_cVQRList",m_cVQRList);
      _h00000052.Set("_dadata",w_DaDatOpe);
      _h00000052.Set("_adata",w_ADatOpe);
      _h00000052.Set("_inviato",1);
      if (Cursor_qbe_fam_periodo01_minmax_agg!=null)
        Cursor_qbe_fam_periodo01_minmax_agg.Close();
      Cursor_qbe_fam_periodo01_minmax_agg = new VQRHolder("qbe_fam_periodo01_minmax_agg",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000052,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_fam_periodo01_minmax_agg.Eof())) {
        /* _totrecord := _totrecord + qbe_fam_periodo01_minmax_agg->TOTPRG */
        _totrecord = CPLib.Round(_totrecord+Cursor_qbe_fam_periodo01_minmax_agg.GetDouble("TOTPRG"),0);
        Cursor_qbe_fam_periodo01_minmax_agg.Next();
      }
      m_cConnectivityError = Cursor_qbe_fam_periodo01_minmax_agg.ErrorMessage();
      Cursor_qbe_fam_periodo01_minmax_agg.Close();
      // * --- End Select
      /* If _totrecord > 0 */
      if (CPLib.gt(_totrecord,0)) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000056status;
        nTry00000056status = m_Sql.GetTransactionStatus();
        String cTry00000056msg;
        cTry00000056msg = m_Sql.TransactionErrorMessage();
        try {
          /* _errori := 0 */
          _errori = CPLib.Round(0,0);
          // * --- Fill memory cursor mcTemp on qbe_fam_chkperiodo_01_2015
          mcTemp.Zap();
          SPBridge.HMCaller _h00000058;
          _h00000058 = new SPBridge.HMCaller();
          _h00000058.Set("m_cVQRList",m_cVQRList);
          _h00000058.Set("dadata",w_DaDatOpe);
          _h00000058.Set("a_data",w_ADatOpe);
          if (Cursor_qbe_fam_chkperiodo_01_2015!=null)
            Cursor_qbe_fam_chkperiodo_01_2015.Close();
          Cursor_qbe_fam_chkperiodo_01_2015 = new VQRHolder("qbe_fam_chkperiodo_01_2015",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000058,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_fam_chkperiodo_01_2015;
            Cursor_qbe_fam_chkperiodo_01_2015.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_chkerrori: query on qbe_fam_chkperiodo_01_2015 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_fam_chkperiodo_01_2015.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.IDBASE = Cursor_qbe_fam_chkperiodo_01_2015.GetString("IDBASE");
            mcTemp.row.RAPPORTO = Cursor_qbe_fam_chkperiodo_01_2015.GetString("RAPPORTO");
            mcTemp.row.CODINTER = "";
            mcTemp.row.DATAINI = Cursor_qbe_fam_chkperiodo_01_2015.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_fam_chkperiodo_01_2015.GetDate("DATAFINE");
            mcTemp.row.CODFISC = "";
            mcTemp.row.TIPO = Cursor_qbe_fam_chkperiodo_01_2015.GetString("TIPO");
            mcTemp.row.RIFIMP = Cursor_qbe_fam_chkperiodo_01_2015.GetString("RIFIMP");
            mcTemp.row.INFORM = Cursor_qbe_fam_chkperiodo_01_2015.GetString("INFORM");
            Cursor_qbe_fam_chkperiodo_01_2015.Next();
          }
          m_cConnectivityError = Cursor_qbe_fam_chkperiodo_01_2015.ErrorMessage();
          Cursor_qbe_fam_chkperiodo_01_2015.Close();
          mcTemp.GoTop();
          // * --- Fill memory cursor mcTemp on qbe_fam_chkperiodo_01_2015_agg
          mcTemp.GoBottom();
          SPBridge.HMCaller _h00000059;
          _h00000059 = new SPBridge.HMCaller();
          _h00000059.Set("m_cVQRList",m_cVQRList);
          _h00000059.Set("dadata",w_DaDatOpe);
          _h00000059.Set("a_data",w_ADatOpe);
          if (Cursor_qbe_fam_chkperiodo_01_2015_agg!=null)
            Cursor_qbe_fam_chkperiodo_01_2015_agg.Close();
          Cursor_qbe_fam_chkperiodo_01_2015_agg = new VQRHolder("qbe_fam_chkperiodo_01_2015_agg",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000059,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_fam_chkperiodo_01_2015_agg;
            Cursor_qbe_fam_chkperiodo_01_2015_agg.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_chkerrori: query on qbe_fam_chkperiodo_01_2015_agg returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_fam_chkperiodo_01_2015_agg.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.IDBASE = Cursor_qbe_fam_chkperiodo_01_2015_agg.GetString("IDBASE");
            mcTemp.row.RAPPORTO = Cursor_qbe_fam_chkperiodo_01_2015_agg.GetString("RAPPORTO");
            mcTemp.row.CODINTER = "";
            mcTemp.row.DATAINI = Cursor_qbe_fam_chkperiodo_01_2015_agg.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_fam_chkperiodo_01_2015_agg.GetDate("DATAFINE");
            mcTemp.row.CODFISC = "";
            mcTemp.row.TIPO = Cursor_qbe_fam_chkperiodo_01_2015_agg.GetString("TIPO");
            mcTemp.row.RIFIMP = Cursor_qbe_fam_chkperiodo_01_2015_agg.GetString("RIFIMP");
            mcTemp.row.INFORM = Cursor_qbe_fam_chkperiodo_01_2015_agg.GetString("INFORM");
            Cursor_qbe_fam_chkperiodo_01_2015_agg.Next();
          }
          m_cConnectivityError = Cursor_qbe_fam_chkperiodo_01_2015_agg.ErrorMessage();
          Cursor_qbe_fam_chkperiodo_01_2015_agg.Close();
          mcTemp.GoTop();
          /* gMsgProc := gMsgProc + 'Ora Inizio controllo periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
          gMsgProc = gMsgProc+"Ora Inizio controllo periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          for (MemoryCursorRow_mcchkperiodo_mcrdef rowTemp : mcTemp._iterable_()) {
            /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
            gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* mcErrors := arfn_anomes_rapp(rowTemp.RAPPORTO,rowTemp.TIPO,w_flgncf) */
            mcErrors = arfn_anomes_rappR.Make(m_Ctx,this).Run(rowTemp.RAPPORTO,rowTemp.TIPO,w_flgncf);
            /* If mcErrors.RecCount() > 0 */
            if (CPLib.gt(mcErrors.RecCount(),0)) {
              for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrors._iterable_()) {
                /* _errori := _errori + 1 */
                _errori = CPLib.Round(_errori+1,0);
                // * --- Insert into tmp_chkperiodo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
                m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_chkperiodo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_chkerrori",114,"00000062")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000062(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.IDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAINI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAFINE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.TXTERR,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.CONNESINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chkperiodo",true);
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
            } // End If
          }
          /* Exec "Operazioni Extraconto" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* If _errori > 0 */
          if (CPLib.gt(_errori,0)) {
            /* Exec "Creazione File Excel" Page 3:Page_3 */
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
            m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_chkerrori",114,"00000067")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000067(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nomeesito),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(gUrlApp)+"output/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nomeesito),"?",0,0,m_cServer)+", ";
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
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000056status,0)) {
            m_Sql.SetTransactionStatus(nTry00000056status,cTry00000056msg);
          }
        }
      } // End If
      /* gMsgProc := gMsgProc + 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" +NL // Messaggio */
      gMsgProc = gMsgProc+"Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine controllo periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine controllo periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione periodo: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione periodo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Elaborazione Terminata!" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Return _errori */
      throw new Stop(_errori);
    } finally {
      try {
        if (Cursor_qbe_fam_periodo01_minmax!=null)
          Cursor_qbe_fam_periodo01_minmax.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_periodo01_minmax_agg!=null)
          Cursor_qbe_fam_periodo01_minmax_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_chkperiodo_01_2015!=null)
          Cursor_qbe_fam_chkperiodo_01_2015.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_chkperiodo_01_2015_agg!=null)
          Cursor_qbe_fam_chkperiodo_01_2015_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_famperiodo_opx_min_max=null;
    CPResultSet Cursor_qbe_fam_chkperiodo_opx_2015=null;
    CPResultSet Cursor_qbe_famperiodo_opx_min_max_agg=null;
    CPResultSet Cursor_qbe_fam_chkperiodo_opx_2015_agg=null;
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
      // * --- Select from qbe_famperiodo_opx_min_max
      SPBridge.HMCaller _h00000074;
      _h00000074 = new SPBridge.HMCaller();
      _h00000074.Set("m_cVQRList",m_cVQRList);
      _h00000074.Set("_dadata",w_DaDatOpe);
      _h00000074.Set("_adata",w_ADatOpe);
      _h00000074.Set("_inviato",1);
      if (Cursor_qbe_famperiodo_opx_min_max!=null)
        Cursor_qbe_famperiodo_opx_min_max.Close();
      Cursor_qbe_famperiodo_opx_min_max = new VQRHolder("qbe_famperiodo_opx_min_max",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000074,true).GetResultSet(m_Ctx);
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
      /* _mono := iif(_tot > 5000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,5000)?0:1),0);
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
          /* gMsgProc := gMsgProc + LRTrim(gMsgImp) + NL // Messaggio */
          gMsgProc = gMsgProc+CPLib.LRTrim(gMsgImp)+"\n";
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
          // * --- Fill memory cursor mcTemp on qbe_fam_chkperiodo_opx_2015
          mcTemp.Zap();
          SPBridge.HMCaller _h00000094;
          _h00000094 = new SPBridge.HMCaller();
          _h00000094.Set("m_cVQRList",m_cVQRList);
          _h00000094.Set("dadata",w_DaDatOpe);
          _h00000094.Set("a_data",w_ADatOpe);
          _h00000094.Set("_bottom",_bottom);
          _h00000094.Set("_top",_top);
          if (Cursor_qbe_fam_chkperiodo_opx_2015!=null)
            Cursor_qbe_fam_chkperiodo_opx_2015.Close();
          Cursor_qbe_fam_chkperiodo_opx_2015 = new VQRHolder("qbe_fam_chkperiodo_opx_2015",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000094,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_fam_chkperiodo_opx_2015;
            Cursor_qbe_fam_chkperiodo_opx_2015.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_chkerrori: query on qbe_fam_chkperiodo_opx_2015 returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_fam_chkperiodo_opx_2015.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.IDBASE = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("IDBASE");
            mcTemp.row.RAPPORTO = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("RAPPORTO");
            mcTemp.row.CODINTER = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("CODINTER");
            mcTemp.row.DATAINI = Cursor_qbe_fam_chkperiodo_opx_2015.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_fam_chkperiodo_opx_2015.GetDate("DATAFINE");
            mcTemp.row.CODFISC = "";
            mcTemp.row.TIPO = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("TIPO");
            mcTemp.row.RIFIMP = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("RIFIMP");
            mcTemp.row.INFORM = Cursor_qbe_fam_chkperiodo_opx_2015.GetString("INFORM");
            Cursor_qbe_fam_chkperiodo_opx_2015.Next();
          }
          m_cConnectivityError = Cursor_qbe_fam_chkperiodo_opx_2015.ErrorMessage();
          Cursor_qbe_fam_chkperiodo_opx_2015.Close();
          mcTemp.GoTop();
          for (MemoryCursorRow_mcchkperiodo_mcrdef rowTemp : mcTemp._iterable_()) {
            /* mcErrors.Zap() */
            mcErrors.Zap();
            /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
            gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* mcErrors := arfn_anomes_opex(rowTemp.RAPPORTO,rowTemp.TIPO,w_flgncf) */
            mcErrors = arfn_anomes_opexR.Make(m_Ctx,this).Run(rowTemp.RAPPORTO,rowTemp.TIPO,w_flgncf);
            /* If mcErrors.RecCount() > 0 */
            if (CPLib.gt(mcErrors.RecCount(),0)) {
              for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrors._iterable_()) {
                /* _errori := _errori + 1 */
                _errori = CPLib.Round(_errori+1,0);
                // * --- Insert into tmp_chkperiodo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
                m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_chkperiodo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_chkerrori",114,"0000009D")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000009D(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.IDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAINI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAFINE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.TXTERR,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.CONNESINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RIFIMP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.INFORM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chkperiodo",true);
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
          }
        } else { // Else
          /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      // * --- Select from qbe_famperiodo_opx_min_max_agg
      SPBridge.HMCaller _h000000A5;
      _h000000A5 = new SPBridge.HMCaller();
      _h000000A5.Set("m_cVQRList",m_cVQRList);
      _h000000A5.Set("_dadata",w_DaDatOpe);
      _h000000A5.Set("_adata",w_ADatOpe);
      _h000000A5.Set("_inviato",1);
      if (Cursor_qbe_famperiodo_opx_min_max_agg!=null)
        Cursor_qbe_famperiodo_opx_min_max_agg.Close();
      Cursor_qbe_famperiodo_opx_min_max_agg = new VQRHolder("qbe_famperiodo_opx_min_max_agg",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000A5,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_famperiodo_opx_min_max_agg.Eof())) {
        /* _min := qbe_famperiodo_opx_min_max_agg->MINPRG */
        _min = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max_agg.GetDouble("MINPRG"),0);
        /* _max := qbe_famperiodo_opx_min_max_agg->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max_agg.GetDouble("MAXPRG"),0);
        /* _tot := qbe_famperiodo_opx_min_max_agg->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_famperiodo_opx_min_max_agg.GetDouble("TOTPRG"),0);
        Cursor_qbe_famperiodo_opx_min_max_agg.Next();
      }
      m_cConnectivityError = Cursor_qbe_famperiodo_opx_min_max_agg.ErrorMessage();
      Cursor_qbe_famperiodo_opx_min_max_agg.Close();
      // * --- End Select
      /* _mono := iif(_tot > 5000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,5000)?0:1),0);
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
        /* gMsgImp := 'Lettura operazioni extraconto per aggiornamenti in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni extraconto per aggiornamenti in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + LRTrim(gMsgImp) + NL // Messaggio */
          gMsgProc = gMsgProc+CPLib.LRTrim(gMsgImp)+"\n";
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
          /* gMsgImp := 'Lettura operazioni extraconto per aggiornamenti in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto per aggiornamenti in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Fill memory cursor mcTemp on qbe_fam_chkperiodo_opx_2015_agg
          mcTemp.Zap();
          SPBridge.HMCaller _h000000C5;
          _h000000C5 = new SPBridge.HMCaller();
          _h000000C5.Set("m_cVQRList",m_cVQRList);
          _h000000C5.Set("dadata",w_DaDatOpe);
          _h000000C5.Set("a_data",w_ADatOpe);
          _h000000C5.Set("_bottom",_bottom);
          _h000000C5.Set("_top",_top);
          if (Cursor_qbe_fam_chkperiodo_opx_2015_agg!=null)
            Cursor_qbe_fam_chkperiodo_opx_2015_agg.Close();
          Cursor_qbe_fam_chkperiodo_opx_2015_agg = new VQRHolder("qbe_fam_chkperiodo_opx_2015_agg",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000C5,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_fam_chkperiodo_opx_2015_agg;
            Cursor_qbe_fam_chkperiodo_opx_2015_agg.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_fam_chkerrori: query on qbe_fam_chkperiodo_opx_2015_agg returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_fam_chkperiodo_opx_2015_agg.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.IDBASE = Cursor_qbe_fam_chkperiodo_opx_2015_agg.GetString("IDBASE");
            mcTemp.row.RAPPORTO = Cursor_qbe_fam_chkperiodo_opx_2015_agg.GetString("RAPPORTO");
            mcTemp.row.CODINTER = "";
            mcTemp.row.DATAINI = Cursor_qbe_fam_chkperiodo_opx_2015_agg.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_fam_chkperiodo_opx_2015_agg.GetDate("DATAFINE");
            mcTemp.row.CODFISC = "";
            mcTemp.row.TIPO = Cursor_qbe_fam_chkperiodo_opx_2015_agg.GetString("TIPO");
            mcTemp.row.RIFIMP = Cursor_qbe_fam_chkperiodo_opx_2015_agg.GetString("RIFIMP");
            mcTemp.row.INFORM = Cursor_qbe_fam_chkperiodo_opx_2015_agg.GetString("INFORM");
            Cursor_qbe_fam_chkperiodo_opx_2015_agg.Next();
          }
          m_cConnectivityError = Cursor_qbe_fam_chkperiodo_opx_2015_agg.ErrorMessage();
          Cursor_qbe_fam_chkperiodo_opx_2015_agg.Close();
          mcTemp.GoTop();
          for (MemoryCursorRow_mcchkperiodo_mcrdef rowTemp : mcTemp._iterable_()) {
            /* gMsgImp := 'Sono stati effettuati '+LRTrim(Str(_conta,10,0))+" controlli" // Messaggio Import */
            gMsgImp = "Sono stati effettuati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" controlli";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* mcErrors := arfn_anomes_opex(rowTemp.RAPPORTO,rowTemp.TIPO,w_flgncf) */
            mcErrors = arfn_anomes_opexR.Make(m_Ctx,this).Run(rowTemp.RAPPORTO,rowTemp.TIPO,w_flgncf);
            /* If mcErrors.RecCount() > 0 */
            if (CPLib.gt(mcErrors.RecCount(),0)) {
              for (MemoryCursorRow_mcerrsaldi_mcrdef rowErrore : mcErrors._iterable_()) {
                /* _errori := _errori + 1 */
                _errori = CPLib.Round(_errori+1,0);
                // * --- Insert into tmp_chkperiodo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
                m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_chkperiodo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_chkerrori",114,"000000CD")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_000000CD(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.IDBASE,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RAPPORTO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAINI,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.DATAFINE,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.TXTERR,"?",0,0,m_cServer, m_oParameters)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowErrore.CONNESINT,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RIFIMP,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.INFORM,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chkperiodo",true);
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
          }
        } else { // Else
          /* gMsgImp := 'Lettura operazioni extraconto per aggiornamenti in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto per aggiornamenti in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
    } finally {
      try {
        if (Cursor_qbe_famperiodo_opx_min_max!=null)
          Cursor_qbe_famperiodo_opx_min_max.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_chkperiodo_opx_2015!=null)
          Cursor_qbe_fam_chkperiodo_opx_2015.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_famperiodo_opx_min_max_agg!=null)
          Cursor_qbe_famperiodo_opx_min_max_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_fam_chkperiodo_opx_2015_agg!=null)
          Cursor_qbe_fam_chkperiodo_opx_2015_agg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_fam_chkerrori_01=null;
    CPResultSet Cursor_tmp_chkperiodo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_tmp_impesiti_max_min=null;
    CPResultSet Cursor_tmp_impesiti=null;
    CPResultSet Cursor_personbo_agg=null;
    VQRHolder l_VQRHolder = null;
    try {
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry000000D2status;
      nTry000000D2status = m_Sql.GetTransactionStatus();
      String cTry000000D2msg;
      cTry000000D2msg = m_Sql.TransactionErrorMessage();
      try {
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione file excel: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione file excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _reccount := 0 */
        _reccount = CPLib.Round(0,0);
        // * --- Select from qbe_fam_chkerrori_01
        if (Cursor_qbe_fam_chkerrori_01!=null)
          Cursor_qbe_fam_chkerrori_01.Close();
        Cursor_qbe_fam_chkerrori_01 = new VQRHolder("qbe_fam_chkerrori_01",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_fam_chkerrori_01.Eof())) {
          /* _errore := '' */
          _errore = "";
          // * --- Select from tmp_chkperiodo
          m_cServer = m_Ctx.GetServer("tmp_chkperiodo");
          m_cPhName = m_Ctx.GetPhName("tmp_chkperiodo");
          if (Cursor_tmp_chkperiodo!=null)
            Cursor_tmp_chkperiodo.Close();
          Cursor_tmp_chkperiodo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select NDG,MSGTXT  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("tmp_chkperiodo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1")+" order by "+"NDG ",m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_chkperiodo.Eof())) {
            /* _errore := _errore + LRTrim(tmp_chkperiodo->MSGTXT) + " | " */
            _errore = _errore+CPLib.LRTrim(Cursor_tmp_chkperiodo.GetString("MSGTXT"))+" | ";
            Cursor_tmp_chkperiodo.Next();
          }
          m_cConnectivityError = Cursor_tmp_chkperiodo.ErrorMessage();
          Cursor_tmp_chkperiodo.Close();
          // * --- End Select
          /* _errore := Left(_errore,Len(LRTrim(_errore)) - 2) */
          _errore = CPLib.Left(_errore,CPLib.Len(CPLib.LRTrim(_errore))-2);
          /* _reccount := _reccount + 1 */
          _reccount = CPLib.Round(_reccount+1,0);
          /* gMsgImp := 'Lettura controllo n. '+LRTrim(Str(_reccount,10,0)) // Messaggio allineamento 1 */
          gMsgImp = "Lettura controllo n. "+CPLib.LRTrim(CPLib.Str(_reccount,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _tipdoc := '' */
          _tipdoc = "";
          /* _numdoc := '' */
          _numdoc = "";
          /* _datril := NullDate() */
          _datril = CPLib.NullDate();
          /* _autril := '' */
          _autril = "";
          // * --- Read from personbo
          m_cServer = m_Ctx.GetServer("personbo");
          m_cPhName = m_Ctx.GetPhName("personbo");
          m_cSql = "";
          m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NDG"),"C",16,0,m_cServer),m_cServer,Cursor_qbe_fam_chkerrori_01.GetString("NDG"));
          if (m_Ctx.IsSharedTemp("personbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("TIPODOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("NUMDOCUM",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DATARILASC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("AUTRILASC",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _tipdoc = Read_Cursor.GetString("TIPODOC");
            _numdoc = Read_Cursor.GetString("NUMDOCUM");
            _datril = Read_Cursor.GetDate("DATARILASC");
            _autril = Read_Cursor.GetString("AUTRILASC");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on personbo into routine arrt_fam_chkerrori returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _tipdoc = "";
            _numdoc = "";
            _datril = CPLib.NullDate();
            _autril = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          // * --- Insert into tmp_impesiti from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_impesiti",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_chkerrori",114,"000000E1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_000000E1(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_fam_chkerrori_01.GetDate("DATAINI")),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_fam_chkerrori_01.GetDouble("CFESTERO"),1)?"S":"N"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_tipdoc,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NDG"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.DateToChar(_datril),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetDate("DATANASC"),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_errore,"?",0,0,m_cServer, m_oParameters)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_autril,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NOME"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_reccount,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("SESSO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("TIPO"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(_numdoc,"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("RIFIMP"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_fam_chkerrori_01.GetString("INFORM"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_impesiti",true);
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
          Cursor_qbe_fam_chkerrori_01.Next();
        }
        m_cConnectivityError = Cursor_qbe_fam_chkerrori_01.ErrorMessage();
        Cursor_qbe_fam_chkerrori_01.Close();
        // * --- End Select
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000D2status,0)) {
          m_Sql.SetTransactionStatus(nTry000000D2status,cTry000000D2msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Inizio Scrittura file excel: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Inizio Scrittura file excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* nomeesito := 'Errori_OPX_'+DateTimeToChar(DateTime())+".xls" */
      nomeesito = "Errori_OPX_"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
      /* nomefilexls := LRTrim(gPathApp)+"/output/"+LRTrim(gAzienda)+"/"+nomeesito */
      nomefilexls = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
      //base
      riga = 1;
      conta = 0;
      nomefoglio="Foglio"+conta;
      WorkbookSettings ws = new WorkbookSettings();
      WritableWorkbook file = Workbook.createWorkbook(new File(nomefilexls), ws);
      WritableSheet foglio = file.createSheet(nomefoglio, conta);
      WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
      WritableCellFormat arial11format = new WritableCellFormat (arial11font);
      WritableCellFormat unlock = new WritableCellFormat();
      unlock.setBackground(jxl.format.Colour.LIGHT_TURQUOISE);
      unlock.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK);
      
      Label stringa = new Label(0,0,"Codice rapporto",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(1,0,"Tipo informazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(2,0,"Data Prima Oper.",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(3,0,"Connes intestatario",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(4,0,"Intestatario",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(5,0,"CF intestatario",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(6,0,"Persona",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(7,0,"Cognome",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(8,0,"Nome",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(9,0,"Sesso",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(10,0,"Data di nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(11,0,"Comune di nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(12,0,"Stato di nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(13,0,"Provincia di nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(14,0,"Comune di residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(15,0,"Provincia di residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(16,0,"CAB di residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(17,0,"CF non assegnato da AGE",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(18,0,"Tipo Documento",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(19,0,"N. Documento",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(20,0,"Data Rilascio Doc.",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(21,0,"Autorità Rilascio",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(22,0,"Soggetto da Aggiornare",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(23,0,"Modifica Operazione Corrente",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(24,0,"Modifica Tutte le Operazioni del Soggetto",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(25,0,"Blocco Codice Fiscale",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(26,0,"Blocco Dati Anagrafici",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(27,0,"Errori Rilevati",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(28,0,"Riferimento Import 1",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(29,0,"Riferimento Import 2",arial11format);
      foglio.addCell(stringa);
      /* leggo la tabella ordinata x esito */
      // * --- Select from qbe_tmp_impesiti_max_min
      if (Cursor_qbe_tmp_impesiti_max_min!=null)
        Cursor_qbe_tmp_impesiti_max_min.Close();
      Cursor_qbe_tmp_impesiti_max_min = new VQRHolder("qbe_tmp_impesiti_max_min",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_tmp_impesiti_max_min.Eof())) {
        /* _max := qbe_tmp_impesiti_max_min->MAXPROGIMPESITI */
        _max = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MAXPROGIMPESITI"),0);
        /* _min := qbe_tmp_impesiti_max_min->MINPROGIMPESITI */
        _min = CPLib.Round(Cursor_qbe_tmp_impesiti_max_min.GetDouble("MINPROGIMPESITI"),0);
        Cursor_qbe_tmp_impesiti_max_min.Next();
      }
      m_cConnectivityError = Cursor_qbe_tmp_impesiti_max_min.ErrorMessage();
      Cursor_qbe_tmp_impesiti_max_min.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* While _contacicli<= _cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* _bottom := ((_contacicli -1 ) * 10000) + 1 */
        _bottom = CPLib.Round(((_contacicli-1)*10000)+1,0);
        /* _top := _contacicli * 10000 */
        _top = CPLib.Round(_contacicli*10000,0);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from tmp_impesiti
          m_cServer = m_Ctx.GetServer("tmp_impesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
          if (Cursor_tmp_impesiti!=null)
            Cursor_tmp_impesiti.Close();
          Cursor_tmp_impesiti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPESITI>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGIMPESITI<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+" "+")"+(m_Ctx.IsSharedTemp("tmp_impesiti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_tmp_impesiti.Eof())) {
            /* _blccf := 'N' */
            _blccf = "N";
            /* _blcan := 'N' */
            _blcan = "N";
            // * --- Select from personbo_agg
            m_cServer = m_Ctx.GetServer("personbo_agg");
            m_cPhName = m_Ctx.GetPhName("personbo_agg");
            if (Cursor_personbo_agg!=null)
              Cursor_personbo_agg.Close();
            Cursor_personbo_agg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select FLGVALIDO,FLGANAVAL  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_tmp_impesiti.GetString("connes"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo_agg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_personbo_agg.Eof())) {
              /* _blccf := iif(Empty(personbo_agg->FLGVALIDO),'N',personbo_agg->FLGVALIDO) */
              _blccf = (CPLib.Empty(Cursor_personbo_agg.GetString("FLGVALIDO"))?"N":Cursor_personbo_agg.GetString("FLGVALIDO"));
              /* _blcan := iif(Empty(personbo_agg->FLGANAVAL),'N',personbo_agg->FLGANAVAL) */
              _blcan = (CPLib.Empty(Cursor_personbo_agg.GetString("FLGANAVAL"))?"N":Cursor_personbo_agg.GetString("FLGANAVAL"));
              Cursor_personbo_agg.Next();
            }
            m_cConnectivityError = Cursor_personbo_agg.ErrorMessage();
            Cursor_personbo_agg.Close();
            // * --- End Select
            /* gMsgImp := 'Elaborazione esiti al ' + LRTrim(Str(((tmp_impesiti->PROGIMPESITI-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%.' // Messaggio allineamento 1 */
            gMsgImp = "Elaborazione esiti al "+CPLib.LRTrim(CPLib.Str(((Cursor_tmp_impesiti.GetDouble("PROGIMPESITI")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%.";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* prima imposto le variabili */
            /* esito := tmp_impesiti->errore */
            esito = Cursor_tmp_impesiti.GetString("errore");
            /* rapporto := tmp_impesiti->rapporto */
            rapporto = Cursor_tmp_impesiti.GetString("rapporto");
            /* If not(Empty(tmp_impesiti->tipoac)) */
            if ( ! (CPLib.Empty(Cursor_tmp_impesiti.GetString("tipoac")))) {
              /* tipoac := iif(tmp_impesiti->tipoac='O','Operazione extraconto','Rapporto Continuativo') */
              tipoac = (CPLib.eqr(Cursor_tmp_impesiti.GetString("tipoac"),"O")?"Operazione extraconto":"Rapporto Continuativo");
            } else { // Else
              /* tipoac := '' */
              tipoac = "";
            } // End If
            /* connes := tmp_impesiti->connes */
            connes = Cursor_tmp_impesiti.GetString("connes");
            /* ragsoc := tmp_impesiti->ragsoc */
            ragsoc = Cursor_tmp_impesiti.GetString("ragsoc");
            /* codfisc := tmp_impesiti->codfisc */
            codfisc = Cursor_tmp_impesiti.GetString("codfisc");
            /* cognome := tmp_impesiti->cognome */
            cognome = Cursor_tmp_impesiti.GetString("cognome");
            /* nome := tmp_impesiti->nome */
            nome = Cursor_tmp_impesiti.GetString("nome");
            /* If not(Empty(tmp_impesiti->sesso)) */
            if ( ! (CPLib.Empty(Cursor_tmp_impesiti.GetString("sesso")))) {
              /* sesso := iif(tmp_impesiti->sesso='1' or tmp_impesiti->sesso='M','M','F') */
              sesso = (CPLib.eqr(Cursor_tmp_impesiti.GetString("sesso"),"1") || CPLib.eqr(Cursor_tmp_impesiti.GetString("sesso"),"M")?"M":"F");
              /* persona := 'F' */
              persona = "F";
            } else { // Else
              /* sesso := '' */
              sesso = "";
              /* persona := 'G' */
              persona = "G";
            } // End If
            /* datanasc := iif(Empty(tmp_impesiti->datanasc),'',DateToChar(tmp_impesiti->datanasc)) */
            datanasc = (CPLib.Empty(Cursor_tmp_impesiti.GetDate("datanasc"))?"":CPLib.DateToChar(Cursor_tmp_impesiti.GetDate("datanasc")));
            /* nascomun := tmp_impesiti->nascomun */
            nascomun = Cursor_tmp_impesiti.GetString("nascomun");
            /* nasstato := LRTrim(tmp_impesiti->nomefile) */
            nasstato = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("nomefile"));
            /* tipinter := tmp_impesiti->tipinter */
            tipinter = Cursor_tmp_impesiti.GetString("tipinter");
            /* desccit := tmp_impesiti->desccit */
            desccit = Cursor_tmp_impesiti.GetString("desccit");
            /* provincia := tmp_impesiti->provincia */
            provincia = Cursor_tmp_impesiti.GetString("provincia");
            /* codcab := tmp_impesiti->codcab */
            codcab = Cursor_tmp_impesiti.GetString("codcab");
            /* cfestero := Left(LRTrim(tmp_impesiti->aprog),1) */
            cfestero = CPLib.Left(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("aprog")),1);
            /* _tipdoc := Left(LRTrim(tmp_impesiti->cfile),2) */
            _tipdoc = CPLib.Left(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("cfile")),2);
            /* _numdoc := Left(LRTrim(tmp_impesiti->trueident),15) */
            _numdoc = CPLib.Left(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("trueident")),15);
            /* _cdatril := LRTrim(tmp_impesiti->cprog) */
            _cdatril = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("cprog"));
            /* _autril := Left(LRTrim(tmp_impesiti->esito),30) */
            _autril = CPLib.Left(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("esito")),30);
            /* _datope := LRTrim(tmp_impesiti->afile) */
            _datope = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("afile"));
            /* _rif1 := Left(LRTrim(tmp_impesiti->rifimp),9) */
            _rif1 = CPLib.Left(CPLib.LRTrim(Cursor_tmp_impesiti.GetString("rifimp")),9);
            /* _rif2 := LRTrim(tmp_impesiti->inform) */
            _rif2 = CPLib.LRTrim(Cursor_tmp_impesiti.GetString("inform"));
            /* If riga=32000 */
            if (CPLib.eqr(riga,32000)) {
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
              foglio.setColumnView(25, cf);
              foglio.setColumnView(26, cf);
              foglio.setColumnView(27, cf);
              foglio.setColumnView(28, cf);
              foglio.setColumnView(29, cf);
              //aggiungo foglio
              riga =1;
              conta = conta+1;
              nomefoglio="Foglio"+conta;
              foglio = file.createSheet(nomefoglio, conta);
              foglio.getSettings().setPassword("123");
              foglio.setProtected(true);
              stringa = new Label(0,0,"Codice rapporto",arial11format);
              foglio.addCell(stringa); 
              stringa = new Label(1,0,"Tipo informazione",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(2,0,"Data Prima Oper.",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(3,0,"Connes intestatario",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(4,0,"Intestatario",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(5,0,"CF intestatario",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(6,0,"Persona",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(7,0,"Cognome",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(8,0,"Nome",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(9,0,"Sesso",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(10,0,"Data di nascita",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(11,0,"Comune di nascita",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(12,0,"Stato di nascita",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(13,0,"Provincia di nascita",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(14,0,"Comune di residenza",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(15,0,"Provincia di residenza",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(16,0,"CAB di residenza",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(17,0,"CF non assegnato da AGE",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(18,0,"Tipo Documento",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(19,0,"N. Documento",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(20,0,"Data Rilascio Doc.",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(21,0,"Autorità Rilascio",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(22,0,"Soggetto da Aggiornare",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(23,0,"Modifica Operazioni Extraconto",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(24,0,"Modifica Rapporti Continuativi",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(25,0,"Blocco Codice Fiscale",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(26,0,"Blocco Dati Anagrafici",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(27,0,"Errori Rilevati",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(28,0,"Riferimento Import 1",arial11format);
              foglio.addCell(stringa);
              stringa = new Label(29,0,"Riferimento Import 2",arial11format);
              foglio.addCell(stringa);
            } // End If
            /* imposto campi */
            stringa = new Label(0,riga,rapporto);
            foglio.addCell(stringa); 
            stringa = new Label(1,riga,tipoac);
            foglio.addCell(stringa); 
            stringa = new Label(2,riga,_datope);
            foglio.addCell(stringa);
            stringa = new Label(3,riga,connes);
            foglio.addCell(stringa); 
            stringa = new Label(4,riga,ragsoc);
            foglio.addCell(stringa); 
            stringa = new Label(5,riga,codfisc);
            foglio.addCell(stringa);
            stringa = new Label(6,riga,persona);
            foglio.addCell(stringa);  
            stringa = new Label(7,riga,cognome);
            foglio.addCell(stringa); 
            stringa = new Label(8,riga,nome);
            foglio.addCell(stringa); 
            stringa = new Label(9,riga,sesso);
            foglio.addCell(stringa); 
            stringa = new Label(10,riga,datanasc);
            foglio.addCell(stringa); 
            stringa = new Label(11,riga,nascomun);
            foglio.addCell(stringa); 
            stringa = new Label(12,riga,nasstato);
            foglio.addCell(stringa); 
            stringa = new Label(13,riga,tipinter);
            foglio.addCell(stringa); 
            stringa = new Label(14,riga,desccit);
            foglio.addCell(stringa); 
            stringa = new Label(15,riga,provincia);
            foglio.addCell(stringa); 
            stringa = new Label(16,riga,codcab);
            foglio.addCell(stringa); 
            stringa = new Label(17,riga,cfestero);
            foglio.addCell(stringa); 
            stringa = new Label(18,riga,_tipdoc);
            foglio.addCell(stringa); 
            stringa = new Label(19,riga,_numdoc);
            foglio.addCell(stringa); 
            stringa = new Label(20,riga,_cdatril);
            foglio.addCell(stringa); 
            stringa = new Label(21,riga,_autril);
            foglio.addCell(stringa); 
            stringa = new Label(22,riga,"N");
            foglio.addCell(stringa); 
            stringa = new Label(23,riga,"N");
            foglio.addCell(stringa); 
            stringa = new Label(24,riga,"N");
            foglio.addCell(stringa); 
            stringa = new Label(25,riga,_blccf);
            foglio.addCell(stringa); 
            stringa = new Label(26,riga,_blcan);
            foglio.addCell(stringa); 
            stringa = new Label(27,riga,esito);
            foglio.addCell(stringa); 
            stringa = new Label(28,riga,_rif1);
            foglio.addCell(stringa); 
            stringa = new Label(29,riga,_rif2);
            foglio.addCell(stringa); 
            riga = riga +1;
            Cursor_tmp_impesiti.Next();
          }
          m_cConnectivityError = Cursor_tmp_impesiti.ErrorMessage();
          Cursor_tmp_impesiti.Close();
          // * --- End Select
        } // End If
        /* Se ho già raggiunto il numero di presenze per l'esito controllato passo al successivo */
        /* _contacicli := _contacicli+1 */
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
      foglio.setColumnView(25, cf);
      foglio.setColumnView(26, cf);
      foglio.setColumnView(27, cf);
      foglio.setColumnView(28, cf);
      foglio.setColumnView(29, cf);
      file.write();
      file.close();
      
      /* gMsgProc := gMsgProc + 'Ora Fine Scrittura file excel: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Scrittura file excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione file excel: '+arfn_fdatetime(DateTime())+NL // Messaggio */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione file excel: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_fam_chkerrori_01!=null)
          Cursor_qbe_fam_chkerrori_01.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_chkperiodo!=null)
          Cursor_tmp_chkperiodo.Close();
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
        if (Cursor_qbe_tmp_impesiti_max_min!=null)
          Cursor_qbe_tmp_impesiti_max_min.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_impesiti!=null)
          Cursor_tmp_impesiti.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,String p_w_flgncf) {
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_flgncf = p_w_flgncf;
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
  public double Run(java.sql.Date p_w_DaDatOpe,java.sql.Date p_w_ADatOpe,String p_w_flgncf) {
    w_DaDatOpe = p_w_DaDatOpe;
    w_ADatOpe = p_w_ADatOpe;
    w_flgncf = p_w_flgncf;
    return Run();
  }
  public double Run() {
    double l_result;
    l_result = 0;
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
        l_result = stop_value.GetNumber();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = 0;
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
  public static arrt_fam_chkerroriR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fam_chkerroriR(p_Ctx, p_Caller);
  }
  public static arrt_fam_chkerroriR Make(CPContext p_Ctx) {
    return new arrt_fam_chkerroriR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_DaDatOpe = CPLib.NullDate();
    w_ADatOpe = CPLib.NullDate();
    w_flgncf = CPLib.Space(1);
    _conta = 0;
    _errore = "";
    _errori = 0;
    mcTemp = new MemoryCursor_mcchkperiodo_mcrdef();
    rowTemp = new MemoryCursorRow_mcchkperiodo_mcrdef();
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
    mcErrors = new MemoryCursor_mcerrsaldi_mcrdef();
    Countesito = 0;
    _contaEsito = 0;
    _blccf = CPLib.Space(1);
    _blcan = CPLib.Space(1);
    _rif1 = CPLib.Space(9);
    _rif2 = CPLib.Space(30);
    rapporto = CPLib.Space(25);
    tipoac = CPLib.Space(50);
    connes = CPLib.Space(16);
    ident = CPLib.Space(15);
    ragsoc = CPLib.Space(30);
    persona = CPLib.Space(10);
    cognome = CPLib.Space(26);
    nome = CPLib.Space(25);
    sesso = CPLib.Space(1);
    datanasc = CPLib.Space(10);
    nascomun = CPLib.Space(30);
    nasstato = CPLib.Space(30);
    tipinter = CPLib.Space(2);
    desccit = CPLib.Space(30);
    provincia = CPLib.Space(2);
    codfisc = CPLib.Space(16);
    codcab = CPLib.Space(6);
    cfestero = CPLib.Space(1);
    esito = "";
    _tipdoc = CPLib.Space(2);
    _numdoc = CPLib.Space(15);
    _datril = CPLib.NullDate();
    _cdatril = CPLib.Space(10);
    _autril = CPLib.Space(30);
    _datope = CPLib.Space(10);
    file = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomeesito = CPLib.Space(50);
    nomefilexls = CPLib.Space(50);
    nomefoglio = CPLib.Space(50);
    stringa = CPLib.Space(1);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_fam_periodo01_minmax,qbe_fam_periodo01_minmax_agg,qbe_fam_chkperiodo_01_2015,qbe_fam_chkperiodo_01_2015_agg,qbe_famperiodo_opx_min_max,qbe_fam_chkperiodo_opx_2015,qbe_famperiodo_opx_min_max_agg,qbe_fam_chkperiodo_opx_2015_agg,qbe_fam_chkerrori_01,qbe_tmp_impesiti_max_min,
  public static final String m_cVQRList = ",qbe_fam_periodo01_minmax,qbe_fam_periodo01_minmax_agg,qbe_fam_chkperiodo_01_2015,qbe_fam_chkperiodo_01_2015_agg,qbe_famperiodo_opx_min_max,qbe_fam_chkperiodo_opx_2015,qbe_famperiodo_opx_min_max_agg,qbe_fam_chkperiodo_opx_2015_agg,qbe_fam_chkerrori_01,qbe_tmp_impesiti_max_min,";
  // ENTITY_BATCHES: ,arfn_anomes_opex,arfn_anomes_rapp,arfn_fdate,arfn_fdatetime,arrt_fam_chkerrori,
  public static final String i_InvokedRoutines = ",arfn_anomes_opex,arfn_anomes_rapp,arfn_fdate,arfn_fdatetime,arrt_fam_chkerrori,";
  public static String[] m_cRunParameterNames={"w_DaDatOpe","w_ADatOpe","w_flgncf"};
  protected static String GetFieldsName_00000062(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"MSGTXT,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chkperiodo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000067(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"hyperlynk,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_listafile",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009D(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"MSGTXT,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chkperiodo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000CD(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATAFINE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"MSGTXT,";
    p_cSql = p_cSql+"NDG,";
    p_cSql = p_cSql+"RIFIMP,";
    p_cSql = p_cSql+"INFORM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chkperiodo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000E1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"afile,";
    p_cSql = p_cSql+"aprog,";
    p_cSql = p_cSql+"cfile,";
    p_cSql = p_cSql+"codcab,";
    p_cSql = p_cSql+"codfisc,";
    p_cSql = p_cSql+"cognome,";
    p_cSql = p_cSql+"connes,";
    p_cSql = p_cSql+"cprog,";
    p_cSql = p_cSql+"datanasc,";
    p_cSql = p_cSql+"desccit,";
    p_cSql = p_cSql+"errore,";
    p_cSql = p_cSql+"esito,";
    p_cSql = p_cSql+"idbase,";
    p_cSql = p_cSql+"nascomun,";
    p_cSql = p_cSql+"nome,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"PROGIMPESITI,";
    p_cSql = p_cSql+"provincia,";
    p_cSql = p_cSql+"ragsoc,";
    p_cSql = p_cSql+"rapporto,";
    p_cSql = p_cSql+"sesso,";
    p_cSql = p_cSql+"tipinter,";
    p_cSql = p_cSql+"tipoac,";
    p_cSql = p_cSql+"trueident,";
    p_cSql = p_cSql+"rifimp,";
    p_cSql = p_cSql+"inform,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_impesiti",true);
    return p_cSql;
  }
}
