// * --- Area Manuale = BO - Header
// * --- arrt_cgo_criticita_xls
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
public class arrt_cgo_criticita_xlsR implements CallerWithObjs {
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
  public String file;
  public String foglio;
  public String nomeesito;
  public String nomefilexls;
  public String nomefoglio;
  public String stringa;
  public String codice;
  public String descri;
  public String datope;
  public String citta;
  public String flgcrtc;
  public double giorni;
  public double _ggyel;
  public double _ggred;
  public String gUrlApp;
  public String gPathApp;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_cgo_criticita_xls
  public int riga;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_cgo_criticita_xlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_criticita_xls",m_Caller);
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
    if (CPLib.eqr("giorni",p_cVarName)) {
      return giorni;
    }
    if (CPLib.eqr("_ggyel",p_cVarName)) {
      return _ggyel;
    }
    if (CPLib.eqr("_ggred",p_cVarName)) {
      return _ggred;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_criticita_xls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
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
    if (CPLib.eqr("stringa",p_cVarName)) {
      return stringa;
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
    if (CPLib.eqr("citta",p_cVarName)) {
      return citta;
    }
    if (CPLib.eqr("flgcrtc",p_cVarName)) {
      return flgcrtc;
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
    if (CPLib.eqr("_ggyel",p_cVarName)) {
      _ggyel = value;
      return;
    }
    if (CPLib.eqr("_ggred",p_cVarName)) {
      _ggred = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("stringa",p_cVarName)) {
      stringa = value;
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
    if (CPLib.eqr("citta",p_cVarName)) {
      citta = value;
      return;
    }
    if (CPLib.eqr("flgcrtc",p_cVarName)) {
      flgcrtc = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_cgo_criticita=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pTipo Char(1) */
      /* file Char(1) */
      /* foglio Char(1) */
      /* nomeesito Char(50) */
      /* nomefilexls Char(50) */
      /* nomefoglio Char(50) */
      /* stringa Char(1) */
      /* codice Char(10) */
      /* descri Char(30) */
      /* datope Char(10) */
      /* citta Char(30) */
      /* flgcrtc Char(5) */
      /* giorni Numeric(4, 0) */
      /* _ggyel Numeric(3, 0) */
      /* _ggred Numeric(3, 0) */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select GGYELWAR,GGREDWAR  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _ggyel := intermbo->GGYELWAR */
        _ggyel = CPLib.Round(Cursor_intermbo.GetDouble("GGYELWAR"),0);
        /* _ggred := intermbo->GGREDWAR */
        _ggred = CPLib.Round(Cursor_intermbo.GetDouble("GGREDWAR"),0);
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Seleziona igli agenti con criticità sulle registrazioni */
      /* nomeesito := 'criticita_'+DateTimeToChar(DateTime())+".xls" */
      nomeesito = "criticita_"+CPLib.DateTimeToChar(CPLib.DateTime())+".xls";
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
      Label stringa = new Label(0,0,"Agenzia",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(1,0,"Ragione Sociale",arial11format);
      foglio.addCell(stringa); 
      stringa = new Label(2,0,"Città",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(3,0,"Operazione Più vecchia",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(4,0,"Giorni",arial11format);
      foglio.addCell(stringa);
      stringa = new Label(5,0,"Criticità",arial11format);
      foglio.addCell(stringa);
      // * --- Select from qbe_cgo_criticita
      SPBridge.HMCaller _h0000001E;
      _h0000001E = new SPBridge.HMCaller();
      _h0000001E.Set("m_cVQRList",m_cVQRList);
      _h0000001E.Set("tipo",pTipo);
      if (Cursor_qbe_cgo_criticita!=null)
        Cursor_qbe_cgo_criticita.Close();
      Cursor_qbe_cgo_criticita = new VQRHolder("qbe_cgo_criticita",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000001E,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_cgo_criticita.Eof())) {
        /* giorni := DateDiff(qbe_cgo_criticita->DATAOPE,Date())  */
        giorni = CPLib.Round(CPLib.DateDiff(Cursor_qbe_cgo_criticita.GetDate("DATAOPE"),CPLib.Date()),0);
        /* Case giorni >= _ggred */
        if (CPLib.ge(giorni,_ggred)) {
          /* flgcrtc := 'ALTA' */
          flgcrtc = "ALTA";
          /* Case giorni >= _ggyel and giorni < _ggred */
        } else if (CPLib.ge(giorni,_ggyel) && CPLib.lt(giorni,_ggred)) {
          /* flgcrtc := 'MEDIA' */
          flgcrtc = "MEDIA";
        } // End Case
        /* codice := qbe_cgo_criticita->IDBASE */
        codice = Cursor_qbe_cgo_criticita.GetString("IDBASE");
        /* descri := qbe_cgo_criticita->DESCRIZ */
        descri = Cursor_qbe_cgo_criticita.GetString("DESCRIZ");
        /* datope := arfn_fdate(qbe_cgo_criticita->DATAOPE) */
        datope = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_cgo_criticita.GetDate("DATAOPE"));
        /* citta := qbe_cgo_criticita->DESCCIT */
        citta = Cursor_qbe_cgo_criticita.GetString("DESCCIT");
        stringa = new Label(0,riga,codice);
        foglio.addCell(stringa);
        stringa = new Label(1,riga,descri);
        foglio.addCell(stringa); 
        stringa = new Label(2,riga,citta);
        foglio.addCell(stringa); 
        stringa = new Label(3,riga,datope);
        foglio.addCell(stringa); 
        Number num1 = new Number(4,riga,giorni,intNum);
        foglio.addCell(num1);
        stringa = new Label(5,riga,flgcrtc);
        foglio.addCell(stringa); 
        riga = riga +1;
        Cursor_qbe_cgo_criticita.Next();
      }
      m_cConnectivityError = Cursor_qbe_cgo_criticita.ErrorMessage();
      Cursor_qbe_cgo_criticita.Close();
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
      file.write();
      file.close();
      /* nomefilexls := Strtran(nomefilexls,"/","//") */
      nomefilexls = CPLib.Strtran(nomefilexls,"/","//");
      /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(nomefilexls)+"&delFile=S" */
      Forward f;
      f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(nomefilexls)+"&delFile=S",false,this,Forward.NoStatus,true);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_cgo_criticita!=null)
          Cursor_qbe_cgo_criticita.Close();
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_criticita_xlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_criticita_xlsR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    file = CPLib.Space(1);
    foglio = CPLib.Space(1);
    nomeesito = CPLib.Space(50);
    nomefilexls = CPLib.Space(50);
    nomefoglio = CPLib.Space(50);
    stringa = CPLib.Space(1);
    codice = CPLib.Space(10);
    descri = CPLib.Space(30);
    datope = CPLib.Space(10);
    citta = CPLib.Space(30);
    flgcrtc = CPLib.Space(5);
    giorni = 0;
    _ggyel = 0;
    _ggred = 0;
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_criticita,
  public static final String m_cVQRList = ",qbe_cgo_criticita,";
  // ENTITY_BATCHES: ,arfn_fdate,
  public static final String i_InvokedRoutines = ",arfn_fdate,";
  public static String[] m_cRunParameterNames={"pTipo"};
}
