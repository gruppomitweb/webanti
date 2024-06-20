// * --- Area Manuale = BO - Header
// * --- arrt_cgo_operazioni_xls
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
public class arrt_cgo_operazioni_xlsR implements CallerWithObjs {
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
  public String m_cPhName_tmp_cgo_crtc;
  public String m_cServer_tmp_cgo_crtc;
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
  public String pTipo;
  public String w_agenzia;
  public String w_xagenzia;
  public String file;
  public String foglio;
  public String nomeesito;
  public String nomefilexls;
  public String nomefoglio;
  public String codice;
  public String descri;
  public String datope;
  public String numticket;
  public String codcau;
  public String descau;
  public String ragsoc;
  public double importo;
  public String segno;
  public String filexls;
  public String gUrlApp;
  public String gPathApp;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_cgo_operazioni_xls
  public int riga;
  public int conta;
  public Number num1;
  public Label stringa;
  // * --- Fine Area Manuale
  public arrt_cgo_operazioni_xlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_operazioni_xls",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_tmp_cgo_crtc = p_ContextObject.GetPhName("tmp_cgo_crtc");
    if (m_cPhName_tmp_cgo_crtc.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_cgo_crtc = m_cPhName_tmp_cgo_crtc+" "+m_Ctx.GetWritePhName("tmp_cgo_crtc");
    }
    m_cServer_tmp_cgo_crtc = p_ContextObject.GetServer("tmp_cgo_crtc");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("importo",p_cVarName)) {
      return importo;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_operazioni_xls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("agenzia",p_cVarName)) {
      return w_agenzia;
    }
    if (CPLib.eqr("xagenzia",p_cVarName)) {
      return w_xagenzia;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
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
    if (CPLib.eqr("codice",p_cVarName)) {
      return codice;
    }
    if (CPLib.eqr("descri",p_cVarName)) {
      return descri;
    }
    if (CPLib.eqr("datope",p_cVarName)) {
      return datope;
    }
    if (CPLib.eqr("numticket",p_cVarName)) {
      return numticket;
    }
    if (CPLib.eqr("codcau",p_cVarName)) {
      return codcau;
    }
    if (CPLib.eqr("descau",p_cVarName)) {
      return descau;
    }
    if (CPLib.eqr("ragsoc",p_cVarName)) {
      return ragsoc;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      return segno;
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
    if (CPLib.eqr("importo",p_cVarName)) {
      importo = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("agenzia",p_cVarName)) {
      w_agenzia = value;
      return;
    }
    if (CPLib.eqr("xagenzia",p_cVarName)) {
      w_xagenzia = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
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
    if (CPLib.eqr("codice",p_cVarName)) {
      codice = value;
      return;
    }
    if (CPLib.eqr("descri",p_cVarName)) {
      descri = value;
      return;
    }
    if (CPLib.eqr("datope",p_cVarName)) {
      datope = value;
      return;
    }
    if (CPLib.eqr("numticket",p_cVarName)) {
      numticket = value;
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
    if (CPLib.eqr("ragsoc",p_cVarName)) {
      ragsoc = value;
      return;
    }
    if (CPLib.eqr("segno",p_cVarName)) {
      segno = value;
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
    CPResultSet Cursor_qbe_cgo_operazioni_vlt=null;
    CPResultSet Cursor_qbe_cgo_operazioni_vnp=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pTipo Char(1) // V=VLT - P=VNP */
      /* w_agenzia Char(6) */
      /* w_xagenzia Char(10) */
      /* file Char(1) */
      /* foglio Char(1) */
      /* nomeesito Char(50) */
      /* nomefilexls Char(50) */
      /* nomefoglio Char(50) */
      /* codice Char(10) */
      /* descri Char(30) */
      /* datope Char(10) */
      /* numticket Char(28) */
      /* codcau Char(12) */
      /* descau Char(90) */
      /* ragsoc Char(70) */
      /* importo Numeric(12, 2) */
      /* segno Char(1) */
      /* filexls Char(128) */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* Seleziona igli agenti con criticità sulle registrazioni */
      /* If pTipo='V' */
      if (CPLib.eqr(pTipo,"V")) {
        /* nomeesito := 'operazioni_vlt_'+DateTimeToChar(DateTime())+".xls" */
        nomeesito = "operazioni_vlt_"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
      } else { // Else
        /* nomeesito := 'operazioni_vnp_'+DateTimeToChar(DateTime())+".xls" */
        nomeesito = "operazioni_vnp_"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
      } // End If
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
      stringa = new Label(0,0,"Agenzia",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(1,0,"Ragione Sociale",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(2,0,"Data operazione",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(3,0,"N° Ticket",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(4,0,"Causale",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(5,0,"Nominativo",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(6,0,"Importo",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(7,0,"Segno",arial11format);
      foglio.addCell(stringa);
      /* If pTipo='V' */
      if (CPLib.eqr(pTipo,"V")) {
        // * --- Select from qbe_cgo_operazioni_vlt
        if (Cursor_qbe_cgo_operazioni_vlt!=null)
          Cursor_qbe_cgo_operazioni_vlt.Close();
        Cursor_qbe_cgo_operazioni_vlt = new VQRHolder("qbe_cgo_operazioni_vlt",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_cgo_operazioni_vlt.Eof())) {
          /* codice := qbe_cgo_operazioni_vlt->IDBASE */
          codice = Cursor_qbe_cgo_operazioni_vlt.GetString("IDBASE");
          /* descri := qbe_cgo_operazioni_vlt->DESCRIZ */
          descri = Cursor_qbe_cgo_operazioni_vlt.GetString("DESCRIZ");
          /* datope := arfn_fdate(qbe_cgo_operazioni_vlt->DATAOPE) */
          datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_cgo_operazioni_vlt.GetDate("DATAOPE"));
          /* numticket := qbe_cgo_operazioni_vlt->CAIDBIGLIETTO */
          numticket = Cursor_qbe_cgo_operazioni_vlt.GetString("CAIDBIGLIETTO");
          /* codcau := qbe_cgo_operazioni_vlt->CAFLGOPE */
          codcau = Cursor_qbe_cgo_operazioni_vlt.GetString("CAFLGOPE");
          /* ragsoc := qbe_cgo_operazioni_vlt->RAGSOC */
          ragsoc = Cursor_qbe_cgo_operazioni_vlt.GetString("RAGSOC");
          /* importo := qbe_cgo_operazioni_vlt->TOTLIRE */
          importo = CPLib.Round(Cursor_qbe_cgo_operazioni_vlt.GetDouble("TOTLIRE"),2);
          /* segno := qbe_cgo_operazioni_vlt->SEGNO */
          segno = Cursor_qbe_cgo_operazioni_vlt.GetString("SEGNO");
          stringa = new Label(0,riga,codice);
          foglio.addCell(stringa);
          stringa = new Label(1,riga,descri);
          foglio.addCell(stringa); 
          stringa = new Label(2,riga,datope);
          foglio.addCell(stringa); 
          stringa = new Label(3,riga,numticket);
          foglio.addCell(stringa);
          stringa = new Label(4,riga,codcau);
          foglio.addCell(stringa);
          stringa = new Label(5,riga,ragsoc);
          foglio.addCell(stringa); 
          num1 = new Number(6,riga,importo,dblNum);
          foglio.addCell(num1);
          stringa = new Label(7,riga,segno);
          foglio.addCell(stringa); 
          riga = riga +1;
          Cursor_qbe_cgo_operazioni_vlt.Next();
        }
        m_cConnectivityError = Cursor_qbe_cgo_operazioni_vlt.ErrorMessage();
        Cursor_qbe_cgo_operazioni_vlt.Close();
        // * --- End Select
      } else { // Else
        // * --- Select from qbe_cgo_operazioni_vnp
        if (Cursor_qbe_cgo_operazioni_vnp!=null)
          Cursor_qbe_cgo_operazioni_vnp.Close();
        Cursor_qbe_cgo_operazioni_vnp = new VQRHolder("qbe_cgo_operazioni_vnp",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_cgo_operazioni_vnp.Eof())) {
          /* codice := qbe_cgo_operazioni_vnp->IDBASE */
          codice = Cursor_qbe_cgo_operazioni_vnp.GetString("IDBASE");
          /* descri := qbe_cgo_operazioni_vnp->DESCRIZ */
          descri = Cursor_qbe_cgo_operazioni_vnp.GetString("DESCRIZ");
          /* datope := arfn_fdate(qbe_cgo_operazioni_vnp->DATAOPE) */
          datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_cgo_operazioni_vnp.GetDate("DATAOPE"));
          /* numticket := qbe_cgo_operazioni_vnp->CAIDBIGLIETTO */
          numticket = Cursor_qbe_cgo_operazioni_vnp.GetString("CAIDBIGLIETTO");
          /* codcau := qbe_cgo_operazioni_vlt->CAFLGOPE */
          codcau = Cursor_qbe_cgo_operazioni_vlt.GetString("CAFLGOPE");
          /* ragsoc := qbe_cgo_operazioni_vnp->RAGSOC */
          ragsoc = Cursor_qbe_cgo_operazioni_vnp.GetString("RAGSOC");
          /* importo := qbe_cgo_operazioni_vnp->TOTLIRE */
          importo = CPLib.Round(Cursor_qbe_cgo_operazioni_vnp.GetDouble("TOTLIRE"),2);
          /* segno := qbe_cgo_operazioni_vnp->SEGNO */
          segno = Cursor_qbe_cgo_operazioni_vnp.GetString("SEGNO");
          stringa = new Label(0,riga,codice);
          foglio.addCell(stringa);
          stringa = new Label(1,riga,descri);
          foglio.addCell(stringa); 
          stringa = new Label(2,riga,datope);
          foglio.addCell(stringa); 
          stringa = new Label(3,riga,numticket);
          foglio.addCell(stringa);
          stringa = new Label(4,riga,codcau);
          foglio.addCell(stringa);
          stringa = new Label(5,riga,ragsoc);
          foglio.addCell(stringa); 
          num1 = new Number(6,riga,importo,dblNum);
          foglio.addCell(num1);
          stringa = new Label(7,riga,segno);
          foglio.addCell(stringa); 
          riga = riga +1;
          Cursor_qbe_cgo_operazioni_vnp.Next();
        }
        m_cConnectivityError = Cursor_qbe_cgo_operazioni_vnp.ErrorMessage();
        Cursor_qbe_cgo_operazioni_vnp.Close();
        // * --- End Select
      } // End If
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
        if (Cursor_qbe_cgo_operazioni_vlt!=null)
          Cursor_qbe_cgo_operazioni_vlt.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cgo_operazioni_vnp!=null)
          Cursor_qbe_cgo_operazioni_vnp.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo) {
    pTipo = p_pTipo;
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
  public Forward Run(String p_pTipo) {
    pTipo = p_pTipo;
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
      m_Caller.SetString("agenzia","C",6,0,w_agenzia);
      m_Caller.SetString("xagenzia","C",10,0,w_xagenzia);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_operazioni_xlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_operazioni_xlsR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_agenzia = m_Caller.GetString("agenzia","C",6,0);
    w_xagenzia = m_Caller.GetString("xagenzia","C",10,0);
    file = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomeesito = CPLib.Space(50);
    nomefilexls = CPLib.Space(50);
    nomefoglio = CPLib.Space(50);
    codice = CPLib.Space(10);
    descri = CPLib.Space(30);
    datope = CPLib.Space(10);
    numticket = CPLib.Space(28);
    codcau = CPLib.Space(12);
    descau = CPLib.Space(90);
    ragsoc = CPLib.Space(70);
    importo = 0;
    segno = CPLib.Space(1);
    filexls = CPLib.Space(128);
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_operazioni_vlt,qbe_cgo_operazioni_vnp,
  public static final String m_cVQRList = ",qbe_cgo_operazioni_vlt,qbe_cgo_operazioni_vnp,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={"pTipo"};
}
