// * --- Area Manuale = BO - Header
// * --- arrt_fam_imperrori
import java.io.File; 
import java.lang.Double;
import jxl.*;
// * --- Fine Area Manuale
public class arrt_fam_imperroriR implements CallerWithObjs {
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
  // I messaggi vengono instradati su questo oggetto
  public CPMessageSink m_MessageSink;
  public com.zucchetti.sitepainter.Logger m_Debug;
  public com.zucchetti.sitepainter.Logger m_Info;
  public com.zucchetti.sitepainter.Logger m_Warning;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_wersonbo;
  public String m_cServer_wersonbo;
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
  public String cProgSto;
  public String _connes;
  public java.sql.Date w_DATARETT;
  public double _inviato;
  public double _annullato;
  public String _annoage;
  public String column01;
  public String column02;
  public String column03;
  public String column04;
  public String column05;
  public String column06;
  public String column07;
  public String column08;
  public String column09;
  public String column10;
  public String column11;
  public String column12;
  public String column13;
  public String column14;
  public String column15;
  public String column16;
  public String column17;
  public String column18;
  public String column19;
  public String column20;
  public String column21;
  public String column22;
  public String column23;
  public String column24;
  public String column25;
  public String column26;
  public String column27;
  public String column28;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String gMsgImp;
  public String gMsgProc;
  public String gFlgWU;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_fam_imperrori
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_fam_imperroriR (CPContext p_ContextObject, Caller caller) {
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
    // I messaggi vengono instradati su questo oggetto
    m_MessageSink = CPMessageSink.ConsoleSink;
    m_Debug = com.zucchetti.sitepainter.Logger.getDebugLogger();
    m_Info = com.zucchetti.sitepainter.Logger.getInfoLogger();
    m_Warning = com.zucchetti.sitepainter.Logger.getWarningLogger();
    p_ContextObject = p_ContextObject.DisabledDataFilteringVersion();
    CPSecurity.RoutineCallableByProgram("arrt_fam_imperrori",m_Caller);
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
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_wersonbo = p_ContextObject.GetPhName("wersonbo");
    if (m_cPhName_wersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_wersonbo = m_cPhName_wersonbo+" "+m_Ctx.GetWritePhName("wersonbo");
    }
    m_cServer_wersonbo = p_ContextObject.GetServer("wersonbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_inviato",p_cVarName)) {
      return _inviato;
    }
    if (CPLib.eqr("_annullato",p_cVarName)) {
      return _annullato;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_fam_imperrori";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return w_nomefile;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      return cProgSto;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_annoage",p_cVarName)) {
      return _annoage;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      return column01;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      return column02;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      return column03;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      return column04;
    }
    if (CPLib.eqr("column05",p_cVarName)) {
      return column05;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      return column06;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      return column07;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      return column08;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      return column09;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      return column10;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      return column11;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      return column12;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      return column13;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      return column14;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      return column15;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      return column16;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      return column17;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      return column18;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      return column19;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      return column20;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      return column21;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      return column22;
    }
    if (CPLib.eqr("column23",p_cVarName)) {
      return column23;
    }
    if (CPLib.eqr("column24",p_cVarName)) {
      return column24;
    }
    if (CPLib.eqr("column25",p_cVarName)) {
      return column25;
    }
    if (CPLib.eqr("column26",p_cVarName)) {
      return column26;
    }
    if (CPLib.eqr("column27",p_cVarName)) {
      return column27;
    }
    if (CPLib.eqr("column28",p_cVarName)) {
      return column28;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      return gFlgWU;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      return w_DATARETT;
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
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_inviato",p_cVarName)) {
      _inviato = value;
      return;
    }
    if (CPLib.eqr("_annullato",p_cVarName)) {
      _annullato = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("nomefile",p_cVarName)) {
      w_nomefile = value;
      return;
    }
    if (CPLib.eqr("cProgSto",p_cVarName)) {
      cProgSto = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_annoage",p_cVarName)) {
      _annoage = value;
      return;
    }
    if (CPLib.eqr("column01",p_cVarName)) {
      column01 = value;
      return;
    }
    if (CPLib.eqr("column02",p_cVarName)) {
      column02 = value;
      return;
    }
    if (CPLib.eqr("column03",p_cVarName)) {
      column03 = value;
      return;
    }
    if (CPLib.eqr("column04",p_cVarName)) {
      column04 = value;
      return;
    }
    if (CPLib.eqr("column05",p_cVarName)) {
      column05 = value;
      return;
    }
    if (CPLib.eqr("column06",p_cVarName)) {
      column06 = value;
      return;
    }
    if (CPLib.eqr("column07",p_cVarName)) {
      column07 = value;
      return;
    }
    if (CPLib.eqr("column08",p_cVarName)) {
      column08 = value;
      return;
    }
    if (CPLib.eqr("column09",p_cVarName)) {
      column09 = value;
      return;
    }
    if (CPLib.eqr("column10",p_cVarName)) {
      column10 = value;
      return;
    }
    if (CPLib.eqr("column11",p_cVarName)) {
      column11 = value;
      return;
    }
    if (CPLib.eqr("column12",p_cVarName)) {
      column12 = value;
      return;
    }
    if (CPLib.eqr("column13",p_cVarName)) {
      column13 = value;
      return;
    }
    if (CPLib.eqr("column14",p_cVarName)) {
      column14 = value;
      return;
    }
    if (CPLib.eqr("column15",p_cVarName)) {
      column15 = value;
      return;
    }
    if (CPLib.eqr("column16",p_cVarName)) {
      column16 = value;
      return;
    }
    if (CPLib.eqr("column17",p_cVarName)) {
      column17 = value;
      return;
    }
    if (CPLib.eqr("column18",p_cVarName)) {
      column18 = value;
      return;
    }
    if (CPLib.eqr("column19",p_cVarName)) {
      column19 = value;
      return;
    }
    if (CPLib.eqr("column20",p_cVarName)) {
      column20 = value;
      return;
    }
    if (CPLib.eqr("column21",p_cVarName)) {
      column21 = value;
      return;
    }
    if (CPLib.eqr("column22",p_cVarName)) {
      column22 = value;
      return;
    }
    if (CPLib.eqr("column23",p_cVarName)) {
      column23 = value;
      return;
    }
    if (CPLib.eqr("column24",p_cVarName)) {
      column24 = value;
      return;
    }
    if (CPLib.eqr("column25",p_cVarName)) {
      column25 = value;
      return;
    }
    if (CPLib.eqr("column26",p_cVarName)) {
      column26 = value;
      return;
    }
    if (CPLib.eqr("column27",p_cVarName)) {
      column27 = value;
      return;
    }
    if (CPLib.eqr("column28",p_cVarName)) {
      column28 = value;
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
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
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
    if (CPLib.eqr("gFlgWU",p_cVarName)) {
      gFlgWU = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("DATARETT",p_cVarName)) {
      w_DATARETT = value;
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
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_wersonbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* w_nomefile Char(80) // nome file da importare */
      /* cProgSto Char(15) */
      /* _connes Char(16) */
      /* w_DATARETT Date // data rettifica */
      /* _inviato Numeric(1, 0) */
      /* _annullato Numeric(1, 0) */
      /* _annoage Char(4) */
      /* column01 Char(25) */
      /* column02 Char(25) */
      /* column03 Char(25) */
      /* column04 Char(25) */
      /* column05 Char(25) */
      /* column06 Char(25) */
      /* column07 Char(25) */
      /* column08 Char(25) */
      /* column09 Char(25) */
      /* column10 Char(25) */
      /* column11 Char(25) */
      /* column12 Char(25) */
      /* column13 Char(25) */
      /* column14 Char(25) */
      /* column15 Char(25) */
      /* column16 Char(25) */
      /* column17 Char(25) */
      /* column18 Char(25) */
      /* column19 Char(25) */
      /* column20 Char(25) */
      /* column21 Char(25) */
      /* column22 Char(25) */
      /* column23 Char(25) */
      /* column24 Char(25) */
      /* column25 Char(25) */
      /* column26 Char(25) */
      /* column27 Char(25) */
      /* column28 Char(25) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gFlgWU Char(1) // Gestione WU */
      /* gMsgProc := 'Ora Inizio Import: '+ arfn_fdatetime(DateTime()) + ' del file ' + w_nomefile + NL */
      gMsgProc = "Ora Inizio Import: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+w_nomefile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* If FileLibMit.ExistFile(LRTrim(gPathDoc)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(w_nomefile)) */
      if (FileLibMit.ExistFile(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile))) {
        /* w_DATARETT := Date() // data rettifica */
        w_DATARETT = CPLib.Date();
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000032status;
        nTry00000032status = m_Sql.GetTransactionStatus();
        String cTry00000032msg;
        cTry00000032msg = m_Sql.TransactionErrorMessage();
        try {
          //base
          Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(gPathDoc)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile)));
          conta = workbook.getNumberOfSheets();
          /* _i = 0 */
          CPLib.eqr(_i,0);
          /* _annoage := Str(Year(Date()) - 10,4,0) */
          _annoage = CPLib.Str(CPLib.Year(CPLib.Date())-10,4,0);
          /* While _i < conta */
          while (CPLib.lt(_i,conta)) {
            _righe = 0;
            Sheet sheet = workbook.getSheet(_i);
            _righe = sheet.getRows();
            _y = 1;
            /* While _y <_righe */
            while (CPLib.lt(_y,_righe)) {
              // Leggo le celle
              Cell a01 = sheet.getCell(0,_y);
              Cell a02 = sheet.getCell(1,_y);
              Cell a03 = sheet.getCell(2,_y);
              Cell a04 = sheet.getCell(3,_y);
              Cell a05 = sheet.getCell(4,_y);
              Cell a06 = sheet.getCell(5,_y);
              Cell a07 = sheet.getCell(6,_y);
              Cell a08 = sheet.getCell(7,_y);
              Cell a09 = sheet.getCell(8,_y);
              Cell a10 = sheet.getCell(9,_y);
              Cell a11 = sheet.getCell(10,_y);
              Cell a12 = sheet.getCell(11,_y);
              Cell a13 = sheet.getCell(12,_y);
              Cell a14 = sheet.getCell(13,_y);
              Cell a15 = sheet.getCell(14,_y);
              Cell a16 = sheet.getCell(15,_y);
              Cell a17 = sheet.getCell(16,_y);
              Cell a18 = sheet.getCell(17,_y);
              Cell a19 = sheet.getCell(18,_y);
              Cell a20 = sheet.getCell(19,_y);
              Cell a21 = sheet.getCell(20,_y);
              Cell a22 = sheet.getCell(21,_y);
              Cell a23 = sheet.getCell(22,_y);
              Cell a24 = sheet.getCell(23,_y);
              Cell a25 = sheet.getCell(24,_y);
              Cell a26 = sheet.getCell(25,_y);
              Cell a27 = sheet.getCell(26,_y);
              Cell a28 = sheet.getCell(27,_y);
              /* column01 := Upper(a01.getContents()) */
              column01 = CPLib.Upper(a01.getContents());
              /* column02 := Upper(a02.getContents()) */
              column02 = CPLib.Upper(a02.getContents());
              /* column03 := Upper(a03.getContents()) */
              column03 = CPLib.Upper(a03.getContents());
              /* column04 := Upper(a04.getContents()) */
              column04 = CPLib.Upper(a04.getContents());
              /* column05 := Upper(a05.getContents()) */
              column05 = CPLib.Upper(a05.getContents());
              /* column06 := Upper(a06.getContents()) */
              column06 = CPLib.Upper(a06.getContents());
              /* column07 := Upper(a07.getContents()) */
              column07 = CPLib.Upper(a07.getContents());
              /* column08 := Upper(a08.getContents()) */
              column08 = CPLib.Upper(a08.getContents());
              /* column09 := Upper(a09.getContents()) */
              column09 = CPLib.Upper(a09.getContents());
              /* column10 := Upper(a10.getContents()) */
              column10 = CPLib.Upper(a10.getContents());
              /* column11 := Upper(a11.getContents()) */
              column11 = CPLib.Upper(a11.getContents());
              /* column12 := Upper(a12.getContents()) */
              column12 = CPLib.Upper(a12.getContents());
              /* column13 := Upper(a13.getContents()) */
              column13 = CPLib.Upper(a13.getContents());
              /* column14 := Upper(a14.getContents()) */
              column14 = CPLib.Upper(a14.getContents());
              /* column15 := Upper(a15.getContents()) */
              column15 = CPLib.Upper(a15.getContents());
              /* column16 := Upper(a16.getContents()) */
              column16 = CPLib.Upper(a16.getContents());
              /* column17 := Upper(a17.getContents()) */
              column17 = CPLib.Upper(a17.getContents());
              /* column18 := Upper(a18.getContents()) */
              column18 = CPLib.Upper(a18.getContents());
              /* column19 := Upper(a19.getContents()) */
              column19 = CPLib.Upper(a19.getContents());
              /* column20 := Upper(a20.getContents()) */
              column20 = CPLib.Upper(a20.getContents());
              /* column21 := Upper(a21.getContents()) */
              column21 = CPLib.Upper(a21.getContents());
              /* column22 := Upper(a22.getContents()) */
              column22 = CPLib.Upper(a22.getContents());
              /* column23 := Upper(a23.getContents()) */
              column23 = CPLib.Upper(a23.getContents());
              /* column24 := Upper(a24.getContents()) */
              column24 = CPLib.Upper(a24.getContents());
              /* column25 := Upper(a25.getContents()) */
              column25 = CPLib.Upper(a25.getContents());
              /* column26 := Upper(a26.getContents()) */
              column26 = CPLib.Upper(a26.getContents());
              /* column27 := Upper(a27.getContents()) */
              column27 = CPLib.Upper(a27.getContents());
              /* column28 := Upper(a28.getContents()) */
              column28 = CPLib.Upper(a28.getContents());
              /* If not(Empty(LRTrim(column23))) and column23='S' */
              if ( ! (CPLib.Empty(CPLib.LRTrim(column23))) && CPLib.eqr(column23,"S")) {
                /* _connes := Left(LRTrim(column04),16) */
                _connes = CPLib.Left(CPLib.LRTrim(column04),16);
                /* gMsgImp := 'Sto aggiornando i dati del soggetto con NDG: ' + LRTrim(_connes) // Messaggio Import */
                gMsgImp = "Sto aggiornando i dati del soggetto con NDG: "+CPLib.LRTrim(_connes);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* gMsgProc := gMsgProc + 'Sto aggiornando i dati del soggetto con NDG: ' + LRTrim(_connes) + NL // Messaggio */
                gMsgProc = gMsgProc+"Sto aggiornando i dati del soggetto con NDG: "+CPLib.LRTrim(_connes)+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* cProgSto := '' */
                cProgSto = "";
                // * --- Select from wersonbo
                m_cServer = m_Ctx.GetServer("wersonbo");
                m_cPhName = m_Ctx.GetPhName("wersonbo");
                if (Cursor_wersonbo!=null)
                  Cursor_wersonbo.Close();
                Cursor_wersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select sanumpro  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+"  and  datamodi="+CPSql.SQLValueAdapter(CPLib.ToSQL(w_DATARETT,"?",0,0,m_cServer, m_oParameters),m_cServer,w_DATARETT)+" "+")"+(m_Ctx.IsSharedTemp("wersonbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_wersonbo.Eof())) {
                  /* cProgSto := wersonbo->sanumpro */
                  cProgSto = Cursor_wersonbo.GetString("sanumpro");
                  Cursor_wersonbo.Next();
                }
                m_cConnectivityError = Cursor_wersonbo.ErrorMessage();
                Cursor_wersonbo.Close();
                // * --- End Select
                /* If Empty(LRTrim(cProgSto)) */
                if (CPLib.Empty(CPLib.LRTrim(cProgSto))) {
                  /* cProgSto := Utilities.GetAutonumber("PSTOPERS\'"+LRTrim(gAzienda)+"'","",15) */
                  cProgSto = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PSTOPERS\\'"+CPLib.LRTrim(gAzienda)+"'","",15);
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer, m_oParameters),m_cServer,_connes)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    // * --- Insert into wersonbo from values
                    m_Sql.RequireTransaction();
                    m_cServer = m_Ctx.GetServer("wersonbo");
                    m_cPhName = m_Ctx.GetPhName("wersonbo");
                    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"wersonbo",m_Ctx.GetCompany());
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000063")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000063(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(cProgSto,"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODCAB"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOMICILIO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATANASC"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASCOMUN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOTGRUP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAMOGRUP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SETTSINT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPODOC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NUMDOCUM"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATARILASC"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AUTRILASC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CAP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPOPERS"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODDIPE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PARTIVA"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOTE"),"?",0,0,m_cServer, m_oParameters)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SESSO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SOSPMAF"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("idcitta"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATAVALI"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DOCFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("CFESTERO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCONNES"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATEXTRA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PKTBSPECIE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COMPORT"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("ATTIV"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RNATGIU"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RATTIV"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RCOMP"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("RAREA"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATO"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("ALLINEATONOMECNOME"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("RAGSOCOLD"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDouble("PROGIMPORT"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROGIMP_C"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("AREAGEO"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PEP"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("IDFILE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDCODFISC"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("MACROAGENTE"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("SPOTID"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetDate("DATASEGN"),"?",0,0)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("OLDSETSIN"),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"wersonbo",true);
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
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } // End If
                /* If gFlgWU='S' */
                if (CPLib.eqr(gFlgWU,"S")) {
                  // * --- Write into opextrbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000065")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column18),1),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                  m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Right(CPLib.LRTrim(column03),4),"?",0,0,m_cServer),m_cServer,CPLib.Right(CPLib.LRTrim(column03),4))+"";
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
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000066")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column06),16),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column05),70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column08),26),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column09),25),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column10),"M")?"1":(CPLib.eqr(CPLib.LRTrim(column10),"F")?"2":"")),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.LRTrim(column11)),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column12),30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column13),30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column14),2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column15),30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column16),2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column17),6),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column19),2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column20),15),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(column21),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column22),6),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column07),1),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  {
                    if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_fam_imperrori: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                      }
                    }
                  }
                  if (CPLib.lt(m_nUpdatedRows,0)) {
                    m_Sql.AbortTransaction();
                  }
                  m_Sql.CompleteTransaction();
                  m_cLastMsgError = m_Sql.TransactionErrorMessage();
                  if (CPLib.ne(m_cLastMsgError,"")) {
                    m_bError = true;
                    throw new RoutineException();
                  }
                } else { // Else
                  // * --- Write into opextrbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000067")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column18),1),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                  m_cSql = m_cSql+" and ANNO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Right(CPLib.LRTrim(column03),4),"?",0,0,m_cServer),m_cServer,CPLib.Right(CPLib.LRTrim(column03),4))+"";
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
                  // * --- Write into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000068")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"CODFISC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column06),16),"C",16,0,m_cServer)+", ";
                  m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column05),70),"C",70,0,m_cServer)+", ";
                  m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column08),26),"C",26,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column09),25),"C",25,0,m_cServer)+", ";
                  m_cSql = m_cSql+"SESSO = "+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column10),"M")?"1":(CPLib.eqr(CPLib.LRTrim(column10),"F")?"2":"")),"C",1,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATANASC = "+CPLib.ToSQL(CPLib.CharToDate(CPLib.LRTrim(column11)),"D",8,0)+", ";
                  m_cSql = m_cSql+"NASCOMUN = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column12),30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NASSTATO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column13),30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPINTER = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column14),2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DESCCIT = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column15),30),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"PROVINCIA = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column16),2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CODCAB = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column17),6),"C",6,0,m_cServer)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL((CPLib.eqr(CPLib.Left(CPLib.LRTrim(column18),1),"S")?1:0),"N",1,0)+", ";
                  m_cSql = m_cSql+"TIPODOC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column19),2),"C",2,0,m_cServer)+", ";
                  m_cSql = m_cSql+"NUMDOCUM = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column20),15),"C",15,0,m_cServer)+", ";
                  m_cSql = m_cSql+"DATARILASC = "+CPLib.ToSQL(CPLib.CharToDate(column21),"D",8,0)+", ";
                  m_cSql = m_cSql+"AUTRILASC = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column22),6),"C",30,0,m_cServer)+", ";
                  m_cSql = m_cSql+"TIPOPERS = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column07),1),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"?",0,0,m_cServer),m_cServer,_connes)+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  {
                    if (CPLib.gt(m_nUpdatedRows,1*1.1)) {
                      com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                      if ( ! (CPLib.IsNull(info))) {
                        info.log("Routine arrt_fam_imperrori: Write on personbo updates "+(m_nUpdatedRows)+" rows larger then the expected 1");
                      }
                    }
                  }
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
              } // End If
              /* If not(Empty(LRTrim(column24))) and column24='S' */
              if ( ! (CPLib.Empty(CPLib.LRTrim(column24))) && CPLib.eqr(column24,"S")) {
                /* gMsgImp := "Sto aggiornando la data di modifica dell'operazione extraconto con codice: " + LRTrim(column01) // Messaggio Import */
                gMsgImp = "Sto aggiornando la data di modifica dell'operazione extraconto con codice: "+CPLib.LRTrim(column01);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* gMsgProc := gMsgProc + "Sto aggiornando la data di modifica dell'operazione extraconto con codice: " + LRTrim(column01) + NL // Messaggio */
                gMsgProc = gMsgProc+"Sto aggiornando la data di modifica dell'operazione extraconto con codice: "+CPLib.LRTrim(column01)+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                /* _inviato := 0 */
                _inviato = CPLib.Round(0,0);
                /* _annullato := 0 */
                _annullato = CPLib.Round(0,0);
                // * --- Read from opextrbo
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_cSql = "";
                m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(column01),"C",25,0,m_cServer),m_cServer,CPLib.LRTrim(column01));
                if (m_Ctx.IsSharedTemp("opextrbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("INVIATO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("ANNULLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _inviato = CPLib.Round(Read_Cursor.GetDouble("INVIATO"),0);
                  _annullato = CPLib.Round(Read_Cursor.GetDouble("ANNULLA"),0);
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on opextrbo into routine arrt_fam_imperrori returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _inviato = 0;
                  _annullato = 0;
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* If _inviato=1 and _annullato<> 1 */
                if (CPLib.eqr(_inviato,1) && CPLib.ne(_annullato,1)) {
                  // * --- Write into opextrbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000070")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column18),1),"C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(column01),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(column01))+"";
                  m_cSql = m_cSql+" and ANNO >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_annoage,"?",0,0,m_cServer),m_cServer,_annoage)+"";
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
              } // End If
              /* If not(Empty(LRTrim(column25))) and column25='S' */
              if ( ! (CPLib.Empty(CPLib.LRTrim(column25))) && CPLib.eqr(column25,"S")) {
                /* gMsgImp := "Sto aggiornando la data di modifica delle operazioni del soggetto con codice: " + LRTrim(column04) // Messaggio Import */
                gMsgImp = "Sto aggiornando la data di modifica delle operazioni del soggetto con codice: "+CPLib.LRTrim(column04);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* gMsgProc := gMsgProc + "Sto aggiornando la data di modifica delle operazioni del soggetto con codice: " + LRTrim(column04) + NL // Messaggio */
                gMsgProc = gMsgProc+"Sto aggiornando la data di modifica delle operazioni del soggetto con codice: "+CPLib.LRTrim(column04)+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                // * --- Write into opextrbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000074")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = m_cSql+"CFESTERO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column18),1),"C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"COLLEG = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(column04),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(column04))+"";
                m_cSql = m_cSql+" and INVIATO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
                m_cSql = m_cSql+" and ANNULLA <> "+CPSql.SQLValueAdapter(CPLib.ToSQL(1,"?",0,0,m_cServer),m_cServer,1)+"";
                m_cSql = m_cSql+" and ANNO >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_annoage,"?",0,0,m_cServer),m_cServer,_annoage)+"";
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
              /* If not(Empty(LRTrim(column26))) and column26='S' */
              if ( ! (CPLib.Empty(CPLib.LRTrim(column26))) && CPLib.eqr(column26,"S")) {
                /* gMsgImp := "Sto eseguendo il blocco del codice fiscale del soggetto con codice: " + LRTrim(column04) // Messaggio Import */
                gMsgImp = "Sto eseguendo il blocco del codice fiscale del soggetto con codice: "+CPLib.LRTrim(column04);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* gMsgProc := gMsgProc + "Sto eseguendo il blocco del codice fiscale del soggetto con codice: " + LRTrim(column04) + NL // Messaggio */
                gMsgProc = gMsgProc+"Sto eseguendo il blocco del codice fiscale del soggetto con codice: "+CPLib.LRTrim(column04)+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                // * --- Merge into personbo_agg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo_agg");
                m_cPhName = m_Ctx.GetPhName("personbo_agg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                m_cQuery = "select ";
                m_cQuery =  m_cQuery+""+CPLib.ToSQL(CPLib.LRTrim(column04),"?",0,0)+" as CONNES";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                  m_cQuery = m_cQuery+" from dual";
                }
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cWhere = "personbo_agg.CONNES = cptmp_1xab23.CONNES";
                m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000078")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" personbo_agg USING ";
                  m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                  m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                  m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",true,true);
                  m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                  m_cSql = m_cSql+GetFieldsName_00000078(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column04),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
                  m_cSql = m_cSql+")";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = m_cSql+";";
                  }
                } else {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000078")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"FLGVALIDO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(column04),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(column04))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.eqr(m_nUpdatedRows,0)) {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"00000078")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_00000078(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column04),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
                    m_cSql = m_cSql+")";
                  } else {
                    m_cSql = "";
                  }
                }
                if ( ! (CPLib.Empty(m_cSql))) {
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                }
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
              /* If not(Empty(LRTrim(column27))) and column27='S' */
              if ( ! (CPLib.Empty(CPLib.LRTrim(column27))) && CPLib.eqr(column27,"S")) {
                /* gMsgImp := "Sto eseguendo il blocco dei dati anagrafici del soggetto con codice: " + LRTrim(column04) // Messaggio Import */
                gMsgImp = "Sto eseguendo il blocco dei dati anagrafici del soggetto con codice: "+CPLib.LRTrim(column04);
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                /* gMsgProc := gMsgProc + "Sto eseguendo il blocco dei dati anagrafici del soggetto con codice: " + LRTrim(column04) + NL // Messaggio */
                gMsgProc = gMsgProc+"Sto eseguendo il blocco dei dati anagrafici del soggetto con codice: "+CPLib.LRTrim(column04)+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
                // * --- Merge into personbo_agg from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("personbo_agg");
                m_cPhName = m_Ctx.GetPhName("personbo_agg");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
                m_cQuery = "select ";
                m_cQuery =  m_cQuery+""+CPLib.ToSQL(CPLib.LRTrim(column04),"?",0,0)+" as CONNES";
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle)) {
                  m_cQuery = m_cQuery+" from dual";
                }
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cWhere = "personbo_agg.CONNES = cptmp_1xab23.CONNES";
                m_cWhere = m_cWhere+m_oWrInfo.WhereFilter(2);
                if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nOracle) || CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"0000007C")+"MERGE INTO "+m_oWrInfo.GetTableWriteName()+" personbo_agg USING ";
                  m_cSql = m_cSql+" ("+m_cQuery+") cptmp_1xab23 ON ("+m_cWhere+")";
                  m_cSql = m_cSql+" WHEN MATCHED THEN UPDATE SET ";
                  m_cSql = m_cSql+"FLGANAVAL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",true,true);
                  m_cSql = m_cSql+" WHEN NOT MATCHED THEN INSERT (";
                  m_cSql = m_cSql+GetFieldsName_0000007C(m_Ctx,m_oWrInfo);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column04),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+m_oWrInfo.InsertValues();
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
                  m_cSql = m_cSql+")";
                  if (CPLib.eqr(m_Sql.GetDataBaseType(m_cServer),CPSql.m_nSQLServer)) {
                    m_cSql = m_cSql+";";
                  }
                } else {
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"0000007C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"FLGANAVAL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(column04),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(column04))+"";
                  m_cSql = m_cSql+m_oWrInfo.WhereFilter();
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                  if (CPLib.eqr(m_nUpdatedRows,0)) {
                    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                    m_cSql = CPLib.GetSQLPrefixComment("arrt_fam_imperrori",304,"0000007C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                    m_cSql = m_cSql+GetFieldsName_0000007C(m_Ctx,m_oWrInfo);
                    m_cSql = m_cSql+") values (";
                    m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column04),"?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
                    m_cSql = m_cSql+m_oWrInfo.InsertValues();
                    m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
                    m_cSql = m_cSql+")";
                  } else {
                    m_cSql = "";
                  }
                }
                if ( ! (CPLib.Empty(m_cSql))) {
                  m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                }
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
              _y++;
            } // End While
            _i++;
          } // End While
          /* workbook.close() */
          workbook.close();
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
          /* Error Msg 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
          m_cLastMsgError = "Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
          new CallerImpl(m_Caller,"").SetString("m_cLastMsgError","C",0,0,m_cLastMsgError);
          /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL // Messaggio */
          gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* gMsgImp := 'Elaborazione Abortita per presenza di errori!' // Messaggio Import */
          gMsgImp = "Elaborazione Abortita per presenza di errori!";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000032status,0)) {
            m_Sql.SetTransactionStatus(nTry00000032status,cTry00000032msg);
          }
        }
        // Chiude il file excel e lo cancella
        //workbook.close();
        FileLibMit.DeleteFilePath(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(w_nomefile));
      } // End If
      /* gMsgProc := gMsgProc + 'Ora Fine Import: '+ arfn_fdatetime(DateTime()) + ' del file ' + w_nomefile + NL */
      gMsgProc = gMsgProc+"Ora Fine Import: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+w_nomefile+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_wersonbo!=null)
          Cursor_wersonbo.Close();
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
  public String RunAsync(String p_w_nomefile) {
    w_nomefile = p_w_nomefile;
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
    );
  }
  public String Run(String p_w_nomefile) {
    w_nomefile = p_w_nomefile;
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
  public static arrt_fam_imperroriR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_fam_imperroriR(p_Ctx, p_Caller);
  }
  public static arrt_fam_imperroriR Make(CPContext p_Ctx) {
    return new arrt_fam_imperroriR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    w_nomefile = CPLib.Space(80);
    cProgSto = CPLib.Space(15);
    _connes = CPLib.Space(16);
    w_DATARETT = CPLib.NullDate();
    _inviato = 0;
    _annullato = 0;
    _annoage = CPLib.Space(4);
    column01 = CPLib.Space(25);
    column02 = CPLib.Space(25);
    column03 = CPLib.Space(25);
    column04 = CPLib.Space(25);
    column05 = CPLib.Space(25);
    column06 = CPLib.Space(25);
    column07 = CPLib.Space(25);
    column08 = CPLib.Space(25);
    column09 = CPLib.Space(25);
    column10 = CPLib.Space(25);
    column11 = CPLib.Space(25);
    column12 = CPLib.Space(25);
    column13 = CPLib.Space(25);
    column14 = CPLib.Space(25);
    column15 = CPLib.Space(25);
    column16 = CPLib.Space(25);
    column17 = CPLib.Space(25);
    column18 = CPLib.Space(25);
    column19 = CPLib.Space(25);
    column20 = CPLib.Space(25);
    column21 = CPLib.Space(25);
    column22 = CPLib.Space(25);
    column23 = CPLib.Space(25);
    column24 = CPLib.Space(25);
    column25 = CPLib.Space(25);
    column26 = CPLib.Space(25);
    column27 = CPLib.Space(25);
    column28 = CPLib.Space(25);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gFlgWU=m_Ctx.GetGlobalString("gFlgWU");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_fam_imperrori,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_fam_imperrori,";
  public static String[] m_cRunParameterNames={"w_nomefile"};
  protected static String GetFieldsName_00000063(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"sanumpro,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"TIPINTER,";
    p_cSql = p_cSql+"TIPOPERS,";
    p_cSql = p_cSql+"CODDIPE,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"NOTE,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"SOSPMAF,";
    p_cSql = p_cSql+"idcitta,";
    p_cSql = p_cSql+"datamodi,";
    p_cSql = p_cSql+"DATAVALI,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"DOCFILE,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"CFESTERO,";
    p_cSql = p_cSql+"OLDCONNES,";
    p_cSql = p_cSql+"DATEXTRA,";
    p_cSql = p_cSql+"PKTBSPECIE,";
    p_cSql = p_cSql+"COMPORT,";
    p_cSql = p_cSql+"ATTIV,";
    p_cSql = p_cSql+"RNATGIU,";
    p_cSql = p_cSql+"RATTIV,";
    p_cSql = p_cSql+"RCOMP,";
    p_cSql = p_cSql+"RAREA,";
    p_cSql = p_cSql+"ALLINEATO,";
    p_cSql = p_cSql+"ALLINEATONOMECNOME,";
    p_cSql = p_cSql+"RAGSOCOLD,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"PROGIMP_C,";
    p_cSql = p_cSql+"AREAGEO,";
    p_cSql = p_cSql+"PEP,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"OLDCODFISC,";
    p_cSql = p_cSql+"MACROAGENTE,";
    p_cSql = p_cSql+"SPOTID,";
    p_cSql = p_cSql+"DATASEGN,";
    p_cSql = p_cSql+"OLDSETSIN,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"wersonbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000078(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGVALIDO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000007C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"FLGANAVAL,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
}
