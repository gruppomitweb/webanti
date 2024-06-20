// * --- Area Manuale = BO - Header
// * --- arrt_cgo_operazioni_admin_xls
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
public class arrt_cgo_operazioni_admin_xlsR implements CallerWithObjs {
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
  public String pAgenzia;
  public String pTicket;
  public String pTipGio;
  public String file;
  public String foglio;
  public String nomeesito;
  public String nomefilexls;
  public String nomefoglio;
  public String stringa;
  public String codice;
  public String datope;
  public String datesi;
  public String desesi;
  public String notesi;
  public String coddip;
  public String desdip;
  public double giorni;
  public String codcau;
  public String descau;
  public double totope;
  public String _segno;
  public String _ticket;
  public String _teldip;
  public String _tipgio;
  public String _iddip;
  public String filexls;
  public String gUrlApp;
  public String gPathApp;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_cgo_operazioni_admin_xls
  public int riga;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_cgo_operazioni_admin_xlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_operazioni_admin_xls",m_Caller);
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
    if (CPLib.eqr("giorni",p_cVarName)) {
      return giorni;
    }
    if (CPLib.eqr("totope",p_cVarName)) {
      return totope;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_operazioni_admin_xls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pAgenzia",p_cVarName)) {
      return pAgenzia;
    }
    if (CPLib.eqr("pTicket",p_cVarName)) {
      return pTicket;
    }
    if (CPLib.eqr("pTipGio",p_cVarName)) {
      return pTipGio;
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
    if (CPLib.eqr("codice",p_cVarName)) {
      return codice;
    }
    if (CPLib.eqr("datope",p_cVarName)) {
      return datope;
    }
    if (CPLib.eqr("datesi",p_cVarName)) {
      return datesi;
    }
    if (CPLib.eqr("desesi",p_cVarName)) {
      return desesi;
    }
    if (CPLib.eqr("notesi",p_cVarName)) {
      return notesi;
    }
    if (CPLib.eqr("coddip",p_cVarName)) {
      return coddip;
    }
    if (CPLib.eqr("desdip",p_cVarName)) {
      return desdip;
    }
    if (CPLib.eqr("codcau",p_cVarName)) {
      return codcau;
    }
    if (CPLib.eqr("descau",p_cVarName)) {
      return descau;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      return _segno;
    }
    if (CPLib.eqr("_ticket",p_cVarName)) {
      return _ticket;
    }
    if (CPLib.eqr("_teldip",p_cVarName)) {
      return _teldip;
    }
    if (CPLib.eqr("_tipgio",p_cVarName)) {
      return _tipgio;
    }
    if (CPLib.eqr("_iddip",p_cVarName)) {
      return _iddip;
    }
    if (CPLib.eqr("filexls",p_cVarName)) {
      return filexls;
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
    if (CPLib.eqr("giorni",p_cVarName)) {
      giorni = value;
      return;
    }
    if (CPLib.eqr("totope",p_cVarName)) {
      totope = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pAgenzia",p_cVarName)) {
      pAgenzia = value;
      return;
    }
    if (CPLib.eqr("pTicket",p_cVarName)) {
      pTicket = value;
      return;
    }
    if (CPLib.eqr("pTipGio",p_cVarName)) {
      pTipGio = value;
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
    if (CPLib.eqr("codice",p_cVarName)) {
      codice = value;
      return;
    }
    if (CPLib.eqr("datope",p_cVarName)) {
      datope = value;
      return;
    }
    if (CPLib.eqr("datesi",p_cVarName)) {
      datesi = value;
      return;
    }
    if (CPLib.eqr("desesi",p_cVarName)) {
      desesi = value;
      return;
    }
    if (CPLib.eqr("notesi",p_cVarName)) {
      notesi = value;
      return;
    }
    if (CPLib.eqr("coddip",p_cVarName)) {
      coddip = value;
      return;
    }
    if (CPLib.eqr("desdip",p_cVarName)) {
      desdip = value;
      return;
    }
    if (CPLib.eqr("codcau",p_cVarName)) {
      codcau = value;
      return;
    }
    if (CPLib.eqr("descau",p_cVarName)) {
      descau = value;
      return;
    }
    if (CPLib.eqr("_segno",p_cVarName)) {
      _segno = value;
      return;
    }
    if (CPLib.eqr("_ticket",p_cVarName)) {
      _ticket = value;
      return;
    }
    if (CPLib.eqr("_teldip",p_cVarName)) {
      _teldip = value;
      return;
    }
    if (CPLib.eqr("_tipgio",p_cVarName)) {
      _tipgio = value;
      return;
    }
    if (CPLib.eqr("_iddip",p_cVarName)) {
      _iddip = value;
      return;
    }
    if (CPLib.eqr("filexls",p_cVarName)) {
      filexls = value;
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
    CPResultSet Cursor_qbe_cgo_operazioni_agenzia_admin=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pAgenzia Char(6) */
      /* pTicket Char(20) */
      /* pTipGio Char(3) */
      /* file Char(1) */
      /* foglio Char(1) */
      /* nomeesito Char(50) */
      /* nomefilexls Char(50) */
      /* nomefoglio Char(50) */
      /* stringa Char(1) */
      /* codice Char(15) */
      /* datope Char(10) */
      /* datesi Char(10) */
      /* desesi Char(20) */
      /* notesi Memo */
      /* coddip Char(6) */
      /* desdip Char(30) */
      /* giorni Numeric(4, 0) */
      /* codcau Char(5) */
      /* descau Char(90) */
      /* totope Numeric(12, 2) */
      /* _segno Char(1) */
      /* _ticket Char(20) */
      /* _teldip Char(15) */
      /* _tipgio Char(1) */
      /* _iddip Char(10) */
      /* filexls Char(128) */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* Seleziona igli agenti con criticità sulle registrazioni */
      /* nomeesito := 'dacompletare_'+DateTimeToChar(DateTime())+".xls" */
      nomeesito = "dacompletare_"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
      /* nomefilexls := LRTrim(gPathApp)+"/output/"+LRTrim(gAzienda)+"/"+nomeesito */
      nomefilexls = CPLib.LRTrim(gPathApp)+"/output/"+CPLib.LRTrim(gAzienda)+"/"+nomeesito;
      //base
      riga = 1;
      WorkbookSettings ws = new WorkbookSettings();
      WritableWorkbook file = Workbook.createWorkbook(new File(nomefilexls), ws);
      WritableSheet foglio = file.createSheet("Elenco",0);
      WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
      WritableCellFormat arial11format = new WritableCellFormat (arial11font);
      WritableCellFormat intNum = new WritableCellFormat(NumberFormats.INTEGER);
      WritableCellFormat dblNum = new WritableCellFormat(NumberFormats.FLOAT);
      Label stringa = new Label(0,0,"N° Operazione",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(1,0,"Data Operazione",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(2,0,"Agenzia",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(3,0,"Ragione Sociale",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(4,0,"Telefono",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(5,0,"Tipo Biglietto",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(6,0,"Descrizione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(7,0,"Totale Operazione",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(8,0,"Segno",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(9,0,"Giorni",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(10,0,"ID Biglietto",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(11,0,"Tipo Gioco",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(12,0,"Data Contatto",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(13,0,"Esito Contatto",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(14,0,"Note",arial11format);
      foglio.addCell(stringa); 
      
      // * --- Select from qbe_cgo_operazioni_agenzia_admin
      SPBridge.HMCaller _h00000026;
      _h00000026 = new SPBridge.HMCaller();
      _h00000026.Set("m_cVQRList",m_cVQRList);
      _h00000026.Set("agenzia",pAgenzia);
      _h00000026.Set("idticket",pTicket);
      _h00000026.Set("tipogio",pTipGio);
      if (Cursor_qbe_cgo_operazioni_agenzia_admin!=null)
        Cursor_qbe_cgo_operazioni_agenzia_admin.Close();
      Cursor_qbe_cgo_operazioni_agenzia_admin = new VQRHolder("qbe_cgo_operazioni_agenzia_admin",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000026,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_operazioni_agenzia_admin.Eof())) {
        /* codice := qbe_cgo_operazioni_agenzia_admin->SNAINUMOPE */
        codice = Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("SNAINUMOPE");
        /* datope := arfn_fdate(qbe_cgo_operazioni_agenzia_admin->DATAOPE) */
        datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_cgo_operazioni_agenzia_admin.GetDate("DATAOPE"));
        /* coddip := qbe_cgo_operazioni_agenzia_admin->CODDIPE */
        coddip = Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("CODDIPE");
        /* _teldip := '' */
        _teldip = "";
        /* desdip := '' */
        desdip = "";
        /* _iddip := '' */
        _iddip = "";
        // * --- Read from anadip
        m_cServer = m_Ctx.GetServer("anadip");
        m_cPhName = m_Ctx.GetPhName("anadip");
        m_cSql = "";
        m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("CODDIPE"));
        if (m_Ctx.IsSharedTemp("anadip")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRIZ",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("TELEFONO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("IDBASE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          desdip = Read_Cursor.GetString("DESCRIZ");
          _teldip = Read_Cursor.GetString("TELEFONO");
          _iddip = Read_Cursor.GetString("IDBASE");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on anadip into routine arrt_cgo_operazioni_admin_xls returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          desdip = "";
          _teldip = "";
          _iddip = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* codcau := qbe_cgo_operazioni_agenzia_admin->CACODICE */
        codcau = Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("CACODICE");
        /* descau := qbe_cgo_operazioni_agenzia_admin->TRDESREG */
        descau = Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("TRDESREG");
        /* totope := qbe_cgo_operazioni_agenzia_admin->TOTLIRE */
        totope = CPLib.Round(Cursor_qbe_cgo_operazioni_agenzia_admin.GetDouble("TOTLIRE"),2);
        /* _segno := qbe_cgo_operazioni_agenzia_admin->SEGNO */
        _segno = Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("SEGNO");
        /* giorni := qbe_cgo_operazioni_agenzia_admin->GIORNI */
        giorni = CPLib.Round(Cursor_qbe_cgo_operazioni_agenzia_admin.GetDouble("GIORNI"),0);
        /* _ticket := qbe_cgo_operazioni_agenzia_admin->CAIDBIGLIETTO */
        _ticket = Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("CAIDBIGLIETTO");
        /* _tipgio := qbe_cgo_operazioni_agenzia_admin->TIPOGIOCO */
        _tipgio = Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("TIPOGIOCO");
        /* datesi := arfn_fdate(qbe_cgo_operazioni_agenzia_admin->CGODATCON) */
        datesi = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_cgo_operazioni_agenzia_admin.GetDate("CGODATCON"));
        /* desesi := qbe_cgo_operazioni_agenzia_admin->ECDESCRI */
        desesi = Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("ECDESCRI");
        /* notesi := qbe_cgo_operazioni_agenzia_admin->CGONOTCON */
        notesi = Cursor_qbe_cgo_operazioni_agenzia_admin.GetString("CGONOTCON");
        // Scrive le righe sul foglio excel
        stringa = new Label(0,riga,codice);
        foglio.addCell(stringa);
        stringa = new Label(1,riga,datope);
        foglio.addCell(stringa); 
        stringa = new Label(2,riga,_iddip);
        foglio.addCell(stringa); 
        stringa = new Label(3,riga,desdip);
        foglio.addCell(stringa); 
        stringa = new Label(4,riga,_teldip);
        foglio.addCell(stringa); 
        stringa = new Label(5,riga,codcau);
        foglio.addCell(stringa); 
        stringa = new Label(6,riga,descau);
        foglio.addCell(stringa); 
        Number num1 = new Number(7,riga,totope,dblNum);
        foglio.addCell(num1);
        stringa = new Label(8,riga,_segno);
        foglio.addCell(stringa); 
        num1 = new Number(9,riga,giorni,intNum);
        foglio.addCell(num1);
        stringa = new Label(10,riga,_ticket);
        foglio.addCell(stringa); 
        stringa = new Label(11,riga,_tipgio);
        foglio.addCell(stringa); 
        stringa = new Label(12,riga,datesi);
        foglio.addCell(stringa); 
        stringa = new Label(13,riga,desesi);
        foglio.addCell(stringa); 
        stringa = new Label(14,riga,notesi);
        foglio.addCell(stringa); 
        riga = riga +1;
        Cursor_qbe_cgo_operazioni_agenzia_admin.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_operazioni_agenzia_admin.ErrorMessage();
      Cursor_qbe_cgo_operazioni_agenzia_admin.Close();
      // * --- End Select
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
      file.write();
      file.close();
      /* filexls := LRTrim(Strtran(gPathApp,'/','//'))+"//output//"+LRTrim(gAzienda)+"//"+LRTrim(nomeesito) */
      filexls = CPLib.LRTrim(CPLib.Strtran(gPathApp,"/","//"))+"//output//"+CPLib.LRTrim(gAzienda)+"//"+CPLib.LRTrim(nomeesito);
      /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(filexls)+"&delFile=S" */
      Forward f;
      f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(filexls)+"&delFile=S",false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_qbe_cgo_operazioni_agenzia_admin!=null)
          Cursor_qbe_cgo_operazioni_agenzia_admin.Close();
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
  public String RunAsync(String p_pAgenzia,String p_pTicket,String p_pTipGio) {
    pAgenzia = p_pAgenzia;
    pTicket = p_pTicket;
    pTipGio = p_pTipGio;
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
  public Forward Run(String p_pAgenzia,String p_pTicket,String p_pTipGio) {
    pAgenzia = p_pAgenzia;
    pTicket = p_pTicket;
    pTipGio = p_pTipGio;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_operazioni_admin_xlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_operazioni_admin_xlsR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pAgenzia = CPLib.Space(6);
    pTicket = CPLib.Space(20);
    pTipGio = CPLib.Space(3);
    file = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomeesito = CPLib.Space(50);
    nomefilexls = CPLib.Space(50);
    nomefoglio = CPLib.Space(50);
    stringa = CPLib.Space(1);
    codice = CPLib.Space(15);
    datope = CPLib.Space(10);
    datesi = CPLib.Space(10);
    desesi = CPLib.Space(20);
    notesi = "";
    coddip = CPLib.Space(6);
    desdip = CPLib.Space(30);
    giorni = 0;
    codcau = CPLib.Space(5);
    descau = CPLib.Space(90);
    totope = 0;
    _segno = CPLib.Space(1);
    _ticket = CPLib.Space(20);
    _teldip = CPLib.Space(15);
    _tipgio = CPLib.Space(1);
    _iddip = CPLib.Space(10);
    filexls = CPLib.Space(128);
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_operazioni_agenzia_admin,
  public static final String m_cVQRList = ",qbe_cgo_operazioni_agenzia_admin,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={"pAgenzia","pTicket","pTipGio"};
}
