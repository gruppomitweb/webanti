// * --- Area Manuale = BO - Header
// * --- arrt_esitixls
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
public class arrt_esitixlsR implements CallerWithObjs {
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
  public String m_cPhName_tmp_impesiti;
  public String m_cServer_tmp_impesiti;
  public String m_cPhName_tmp_prnesiti;
  public String m_cServer_tmp_prnesiti;
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
  public String gPathApp;
  public String gUrlApp;
  public String gMsgImp;
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
  public String tipinter;
  public String desccit;
  public String provincia;
  public String codfisc;
  public String codcab;
  public String nprog;
  public String esito;
  public String nomefile;
  public String idfile;
  public String idprog;
  public String file;
  public String foglio;
  public String nomeesito;
  public String nomefilexls;
  public String nomefoglio;
  public String stringa;
  public String _esito;
  public double Countesito;
  public double _contaEsito;
  public double _max;
  public double _min;
  public double _cicli;
  public double _contacilci;
  public double _bottom;
  public double _top;
  public double _nrep;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_esitixls
  public int riga;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_esitixlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_esitixls",m_Caller);
    m_cPhName_tmp_impesiti = p_ContextObject.GetPhName("tmp_impesiti");
    if (m_cPhName_tmp_impesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_impesiti = m_cPhName_tmp_impesiti+" "+m_Ctx.GetWritePhName("tmp_impesiti");
    }
    m_cServer_tmp_impesiti = p_ContextObject.GetServer("tmp_impesiti");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_prnesiti")) {
      m_cPhName_tmp_prnesiti = p_ContextObject.GetPhName("tmp_prnesiti");
      if (m_cPhName_tmp_prnesiti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_prnesiti = m_cPhName_tmp_prnesiti+" "+m_Ctx.GetWritePhName("tmp_prnesiti");
      }
      m_cServer_tmp_prnesiti = p_ContextObject.GetServer("tmp_prnesiti");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("Countesito",p_cVarName)) {
      return Countesito;
    }
    if (CPLib.eqr("_contaEsito",p_cVarName)) {
      return _contaEsito;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      return _contacilci;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_nrep",p_cVarName)) {
      return _nrep;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_esitixls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
    if (CPLib.eqr("nprog",p_cVarName)) {
      return nprog;
    }
    if (CPLib.eqr("esito",p_cVarName)) {
      return esito;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("idfile",p_cVarName)) {
      return idfile;
    }
    if (CPLib.eqr("idprog",p_cVarName)) {
      return idprog;
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
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
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
    if (CPLib.eqr("Countesito",p_cVarName)) {
      Countesito = value;
      return;
    }
    if (CPLib.eqr("_contaEsito",p_cVarName)) {
      _contaEsito = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_contacilci",p_cVarName)) {
      _contacilci = value;
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
    if (CPLib.eqr("_nrep",p_cVarName)) {
      _nrep = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
    if (CPLib.eqr("nprog",p_cVarName)) {
      nprog = value;
      return;
    }
    if (CPLib.eqr("esito",p_cVarName)) {
      esito = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
      return;
    }
    if (CPLib.eqr("idfile",p_cVarName)) {
      idfile = value;
      return;
    }
    if (CPLib.eqr("idprog",p_cVarName)) {
      idprog = value;
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
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
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
    CPResultSet Cursor_qbe_st_impesitis=null;
    CPResultSet Cursor_qbe_tmp_impesiti_max_min=null;
    CPResultSet Cursor_tmp_impesiti=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* gPathApp Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gMsgImp Memo // Messaggio Import */
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
      /* tipinter Char(2) */
      /* desccit Char(30) */
      /* provincia Char(2) */
      /* codfisc Char(16) */
      /* codcab Char(6) */
      /* nprog Char(25) */
      /* esito Char(200) */
      /* nomefile Char(30) */
      /* idfile Char(15) */
      /* idprog Char(25) */
      /* file Char(1) */
      /* foglio Char(1) */
      /* nomeesito Char(50) */
      /* nomefilexls Char(50) */
      /* nomefoglio Char(50) */
      /* stringa Char(1) */
      /* _esito Char(200) // Descrizione dell'esito */
      /* Countesito Numeric(6, 0) // Contatore d'esito */
      /* _contaEsito Numeric(6, 0) // conteggio per esito */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacilci Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _nrep Numeric(3, 0) */
      // * --- Drop temporary table tmp_prnesiti
      if (m_Ctx.IsSharedTemp("tmp_prnesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_prnesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_prnesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_prnesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_prnesiti");
      }
      // * --- Create temporary table tmp_prnesiti
      if (m_Ctx.IsSharedTemp("tmp_prnesiti")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_prnesiti")) {
          m_cServer = m_Ctx.GetServer("tmp_prnesiti");
          m_cPhName = m_Ctx.GetPhName("tmp_prnesiti");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_prnesiti");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_prnesiti");
      if ( ! (m_Ctx.IsSharedTemp("tmp_prnesiti"))) {
        m_cServer = m_Ctx.GetServer("tmp_prnesiti");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_prnesiti",m_cServer,"proto")),m_cPhName,"tmp_prnesiti",m_Ctx);
      }
      m_cPhName_tmp_prnesiti = m_cPhName;
      /* nomeesito := 'esiti'+DateTimeToChar(DateTime())+".xls" */
      nomeesito = "esiti"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
      /* nomefilexls := LRTrim(gPathApp)+"/output/"+nomeesito */
      nomefilexls = CPLib.LRTrim(gPathApp)+"/output/"+nomeesito;
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
      unlock.setLocked(false); 
      unlock.setBackground(jxl.format.Colour.LIGHT_TURQUOISE);
      unlock.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN,jxl.format.Colour.BLACK);
      
      foglio.getSettings().setPassword("123");
      foglio.setProtected(true);
      
      Label stringa = new Label(0,0,"Esito",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(1,0,"Numero progressivo",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(2,0,"Nome File",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(3,0,"Identificativo",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(4,0,"Codice rapporto",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(5,0,"Tipo informazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(6,0,"Connes intestatario",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(7,0,"Intestatario",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(8,0,"CF intestatario",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(9,0,"Persona",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(10,0,"Cognome",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(11,0,"Nome",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(12,0,"Sesso",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(13,0,"Data di nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(14,0,"Comune di nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(15,0,"Provincia di nascita",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(16,0,"Comune di residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(17,0,"Provincia di residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(18,0,"CAB di residenza",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(19,0,"IDFILE (Terna)",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(20,0,"IDPROG (Terna)",arial11format);
      foglio.addCell(stringa);
      /* leggo la tabella ordinata x esito */
      // * --- Select from qbe_st_impesitis
      if (Cursor_qbe_st_impesitis!=null)
        Cursor_qbe_st_impesitis.Close();
      Cursor_qbe_st_impesitis = new VQRHolder("qbe_st_impesitis",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_st_impesitis.Eof())) {
        /* _esito := qbe_st_impesitis->esito // Descrizione dell'esito */
        _esito = Cursor_qbe_st_impesitis.GetString("esito");
        /* Countesito := qbe_st_impesitis->tot // Contatore d'esito */
        Countesito = CPLib.Round(Cursor_qbe_st_impesitis.GetDouble("tot"),0);
        /* _contaEsito := 0 // conteggio per esito */
        _contaEsito = CPLib.Round(0,0);
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
        /* _contacilci := 1 */
        _contacilci = CPLib.Round(1,0);
        /* While _contacilci<= _cicli */
        while (CPLib.le(_contacilci,_cicli)) {
          /* _bottom := ((_contacilci -1 ) * 10000) + 1 */
          _bottom = CPLib.Round(((_contacilci-1)*10000)+1,0);
          /* _top := _contacilci * 10000 */
          _top = CPLib.Round(_contacilci*10000,0);
          /* If _top>=_min */
          if (CPLib.ge(_top,_min)) {
            // * --- Select from tmp_impesiti
            m_cServer = m_Ctx.GetServer("tmp_impesiti");
            m_cPhName = m_Ctx.GetPhName("tmp_impesiti");
            if (Cursor_tmp_impesiti!=null)
              Cursor_tmp_impesiti.Close();
            Cursor_tmp_impesiti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"PROGIMPESITI>="+CPSql.SQLValueAdapter(CPLib.ToSQL(_bottom,"?",0,0,m_cServer, m_oParameters),m_cServer,_bottom)+"  and  PROGIMPESITI<="+CPSql.SQLValueAdapter(CPLib.ToSQL(_top,"?",0,0,m_cServer, m_oParameters),m_cServer,_top)+"  and  esito="+CPSql.SQLValueAdapter(CPLib.ToSQL(_esito,"?",0,0,m_cServer, m_oParameters),m_cServer,_esito)+" "+")"+(m_Ctx.IsSharedTemp("tmp_impesiti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_tmp_impesiti.Eof())) {
              /* gMsgImp := 'Elaborazione esito: ' + _esito + '. Al ' + LRTrim(Str(((tmp_impesiti->PROGIMPESITI-(_min-1))/(_max-(_min-1)))*100,5,2)) + '%.' // Messaggio allineamento 1 */
              gMsgImp = "Elaborazione esito: "+_esito+". Al "+CPLib.LRTrim(CPLib.Str(((Cursor_tmp_impesiti.GetDouble("PROGIMPESITI")-(_min-1))/(_max-(_min-1)))*100,5,2))+"%.";
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* prima imposto le variabili */
              /* esito := tmp_impesiti->esito */
              esito = Cursor_tmp_impesiti.GetString("esito");
              /* nprog := tmp_impesiti->nprog */
              nprog = Cursor_tmp_impesiti.GetString("nprog");
              /* nomefile := tmp_impesiti->nomefile */
              nomefile = Cursor_tmp_impesiti.GetString("nomefile");
              /* ident := tmp_impesiti->trueident */
              ident = Cursor_tmp_impesiti.GetString("trueident");
              /* rapporto := tmp_impesiti->rapporto */
              rapporto = Cursor_tmp_impesiti.GetString("rapporto");
              /* If not(Empty(tmp_impesiti->tipoac)) */
              if ( ! (CPLib.Empty(Cursor_tmp_impesiti.GetString("tipoac")))) {
                /* tipoac := iif(tmp_impesiti->tipoac='A','Apertura rapporto',iif(tmp_impesiti->tipoac='C','Chiusura rapporto',iif(tmp_impesiti->tipoac='O','Operazione extraconto',iif(tmp_impesiti->tipoac='D','Apertura Delega','Chiusura delega')))) */
                tipoac = (CPLib.eqr(Cursor_tmp_impesiti.GetString("tipoac"),"A")?"Apertura rapporto":(CPLib.eqr(Cursor_tmp_impesiti.GetString("tipoac"),"C")?"Chiusura rapporto":(CPLib.eqr(Cursor_tmp_impesiti.GetString("tipoac"),"O")?"Operazione extraconto":(CPLib.eqr(Cursor_tmp_impesiti.GetString("tipoac"),"D")?"Apertura Delega":"Chiusura delega"))));
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
              /* persona := tmp_impesiti->persona */
              persona = Cursor_tmp_impesiti.GetString("persona");
              /* cognome := tmp_impesiti->cognome */
              cognome = Cursor_tmp_impesiti.GetString("cognome");
              /* nome := tmp_impesiti->nome */
              nome = Cursor_tmp_impesiti.GetString("nome");
              /* If not(Empty(tmp_impesiti->sesso)) */
              if ( ! (CPLib.Empty(Cursor_tmp_impesiti.GetString("sesso")))) {
                /* sesso := iif(tmp_impesiti->sesso='1' or tmp_impesiti->sesso='M','M','F') */
                sesso = (CPLib.eqr(Cursor_tmp_impesiti.GetString("sesso"),"1") || CPLib.eqr(Cursor_tmp_impesiti.GetString("sesso"),"M")?"M":"F");
              } else { // Else
                /* sesso := '' */
                sesso = "";
              } // End If
              /* datanasc := iif(Empty(tmp_impesiti->datanasc),'',DateToChar(tmp_impesiti->datanasc)) */
              datanasc = (CPLib.Empty(Cursor_tmp_impesiti.GetDate("datanasc"))?"":CPLib.DateToChar(Cursor_tmp_impesiti.GetDate("datanasc")));
              /* nascomun := tmp_impesiti->nascomun */
              nascomun = Cursor_tmp_impesiti.GetString("nascomun");
              /* tipinter := tmp_impesiti->tipinter */
              tipinter = Cursor_tmp_impesiti.GetString("tipinter");
              /* desccit := tmp_impesiti->desccit */
              desccit = Cursor_tmp_impesiti.GetString("desccit");
              /* provincia := tmp_impesiti->provincia */
              provincia = Cursor_tmp_impesiti.GetString("provincia");
              /* codcab := tmp_impesiti->codcab */
              codcab = Cursor_tmp_impesiti.GetString("codcab");
              /* idfile := tmp_impesiti->afile */
              idfile = Cursor_tmp_impesiti.GetString("afile");
              /* idprog := arfn_delzero(tmp_impesiti->aprog) */
              idprog = arfn_delzeroR.Make(m_Ctx,this).Run(Cursor_tmp_impesiti.GetString("aprog"));
              /* If riga=32000 */
              if (CPLib.eqr(riga,32000)) {
                //Aggiusta le colonne
                CellView cf = new CellView();
                cf.setAutosize(true);
                foglio.setColumnView(0, 110);
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
                //aggiungo foglio
                riga =1;
                conta = conta+1;
                nomefoglio="Foglio"+conta;
                foglio = file.createSheet(nomefoglio, conta);
                foglio.getSettings().setPassword("123");
                foglio.setProtected(true);
                stringa = new Label(0,0,"Esito",arial11format);
                foglio.addCell(stringa); 
                stringa = new Label(1,0,"Numero progressivo",arial11format);
                foglio.addCell(stringa); 
                stringa = new Label(2,0,"Nome File",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(3,0,"Identificativo",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(4,0,"Codice rapporto",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(5,0,"Tipo informazione",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(6,0,"Connes intestatario",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(7,0,"Intestatario",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(8,0,"CF intestatario",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(9,0,"Persona",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(10,0,"Cognome",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(11,0,"Nome",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(12,0,"Sesso",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(13,0,"Data di nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(14,0,"Comune di nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(15,0,"Provincia di nascita",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(16,0,"Comune di residenza",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(17,0,"Provincia di residenza",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(18,0,"CAB di residenza",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(19,0,"IDFILE (Terna)",arial11format);
                foglio.addCell(stringa);
                stringa = new Label(20,0,"IDPROG (Terna)",arial11format);
                foglio.addCell(stringa);
              } // End If
              /* imposto campi */
              stringa = new Label(0,riga,esito);
              foglio.addCell(stringa);
              stringa = new Label(1,riga,nprog);
              foglio.addCell(stringa); 
              stringa = new Label(2,riga,nomefile);
              foglio.addCell(stringa); 
              stringa = new Label(3,riga,ident);
              foglio.addCell(stringa); 
              stringa = new Label(4,riga,rapporto);
              foglio.addCell(stringa); 
              stringa = new Label(5,riga,tipoac);
              foglio.addCell(stringa); 
              stringa = new Label(6,riga,connes);
              foglio.addCell(stringa); 
              stringa = new Label(7,riga,ragsoc,unlock);
              foglio.addCell(stringa); 
              stringa = new Label(8,riga,codfisc,unlock);
              foglio.addCell(stringa);
              stringa = new Label(9,riga,persona);
              foglio.addCell(stringa);  
              stringa = new Label(10,riga,cognome);
              foglio.addCell(stringa); 
              stringa = new Label(11,riga,nome);
              foglio.addCell(stringa); 
              stringa = new Label(12,riga,sesso);
              foglio.addCell(stringa); 
              stringa = new Label(13,riga,datanasc);
              foglio.addCell(stringa); 
              stringa = new Label(14,riga,nascomun);
              foglio.addCell(stringa); 
              stringa = new Label(15,riga,tipinter);
              foglio.addCell(stringa); 
              stringa = new Label(16,riga,desccit);
              foglio.addCell(stringa); 
              stringa = new Label(17,riga,provincia);
              foglio.addCell(stringa); 
              stringa = new Label(18,riga,codcab,unlock);
              foglio.addCell(stringa); 
              stringa = new Label(19,riga,idfile,unlock);
              foglio.addCell(stringa); 
              stringa = new Label(20,riga,idprog,unlock);
              foglio.addCell(stringa); 
              riga = riga +1;
              /* _contaEsito := _contaEsito+1 // Conteggio per esito */
              _contaEsito = CPLib.Round(_contaEsito+1,0);
              Cursor_tmp_impesiti.Next();
            }
            m_cConnectivityError = Cursor_tmp_impesiti.ErrorMessage();
            Cursor_tmp_impesiti.Close();
            // * --- End Select
          } // End If
          /* Se ho già raggiunto il numero di presenze per l'esito controllato passo al successivo */
          /* If _contaEsito=Countesito */
          if (CPLib.eqr(_contaEsito,Countesito)) {
            // Exit Loop
            if (true) {
              break;
            }
          } else { // Else
            /* _contacilci := _contacilci+1 */
            _contacilci = CPLib.Round(_contacilci+1,0);
          } // End If
        } // End While
        Cursor_qbe_st_impesitis.Next();
      }
      m_cConnectivityError = Cursor_qbe_st_impesitis.ErrorMessage();
      Cursor_qbe_st_impesitis.Close();
      // * --- End Select
      //Aggiusta le colonne
      CellView cf = new CellView();
      cf.setAutosize(true);
      foglio.setColumnView(0, 110);
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
      file.write();
      file.close();
      /* gMsgImp := 'Fine Elaborazione.' // Messaggio allineamento 1 */
      gMsgImp = "Fine Elaborazione.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Insert into tmp_prnesiti from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_prnesiti");
      m_cPhName = m_Ctx.GetPhName("tmp_prnesiti");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_prnesiti",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_esitixls",102,"0000006A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_0000006A(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL("File excel di esito","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(nomeesito,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_prnesiti",true);
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
      /* _nrep := _nrep + 1 */
      _nrep = CPLib.Round(_nrep+1,0);
      /* If _nrep = 0 */
      if (CPLib.eqr(_nrep,0)) {
        /* Stop arpg_allinea_anagrafiche_noreport */
        Forward f;
        f=new Forward("arpg_allinea_anagrafiche_noreport",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* Stop arpg_import_esito_dettaglio_report */
        Forward f;
        f=new Forward("arpg_import_esito_dettaglio_report",false,this,Forward.Start,false);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_qbe_st_impesitis!=null)
          Cursor_qbe_st_impesitis.Close();
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_esitixlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_esitixlsR(p_Ctx, p_Caller);
  }
  public void Blank() {
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
    tipinter = CPLib.Space(2);
    desccit = CPLib.Space(30);
    provincia = CPLib.Space(2);
    codfisc = CPLib.Space(16);
    codcab = CPLib.Space(6);
    nprog = CPLib.Space(25);
    esito = CPLib.Space(200);
    nomefile = CPLib.Space(30);
    idfile = CPLib.Space(15);
    idprog = CPLib.Space(25);
    file = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomeesito = CPLib.Space(50);
    nomefilexls = CPLib.Space(50);
    nomefoglio = CPLib.Space(50);
    stringa = CPLib.Space(1);
    _esito = CPLib.Space(200);
    Countesito = 0;
    _contaEsito = 0;
    _max = 0;
    _min = 0;
    _cicli = 0;
    _contacilci = 0;
    _bottom = 0;
    _top = 0;
    _nrep = 0;
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_st_impesitis,qbe_tmp_impesiti_max_min,
  public static final String m_cVQRList = ",qbe_st_impesitis,qbe_tmp_impesiti_max_min,";
  // ENTITY_BATCHES: ,arfn_delzero,
  public static final String i_InvokedRoutines = ",arfn_delzero,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0000006A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"ESITO,";
    p_cSql = p_cSql+"NOMREP,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_prnesiti",true);
    return p_cSql;
  }
}
