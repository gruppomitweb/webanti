// * --- Area Manuale = BO - Header
// * --- arrt_cgo_alert_documenti
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
public class arrt_cgo_alert_documentiR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
  public String m_cPhName_cpazi;
  public String m_cServer_cpazi;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_cgo_tbtipgio;
  public String m_cServer_cgo_tbtipgio;
  public String m_cPhName_cgo_dest_alert;
  public String m_cServer_cgo_dest_alert;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public String _oldazi;
  public String _gAzienda;
  public String _gMsgProc;
  public String _gPathApp;
  public String _mail10;
  public String _mail20;
  public double _10start;
  public double _20start;
  public String _codloc;
  public String _nomloc;
  public String _indloc;
  public String _desgio;
  public String _srvmail;
  public String _prtmail;
  public String _emlmail;
  public String _usrmail;
  public String _pwdmail;
  public String _emaildoc;
  public String _testa;
  public String nomefile;
  public String _citloc;
  public String _col1;
  public String _col2;
  public double _col3;
  public String _col8;
  public String _col9;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_cgo_alert_documenti
  public int riga;
  public DateTime dt;
  // * --- Fine Area Manuale
  public arrt_cgo_alert_documentiR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_alert_documenti",m_Caller);
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    if (m_cPhName_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni = m_cPhName_cgo_operazioni+" "+m_Ctx.GetWritePhName("cgo_operazioni");
    }
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
    m_cPhName_cpazi = p_ContextObject.GetPhName("cpazi");
    if (m_cPhName_cpazi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cpazi = m_cPhName_cpazi+" "+m_Ctx.GetWritePhName("cpazi");
    }
    m_cServer_cpazi = p_ContextObject.GetServer("cpazi");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_cgo_tbtipgio = p_ContextObject.GetPhName("cgo_tbtipgio");
    if (m_cPhName_cgo_tbtipgio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tbtipgio = m_cPhName_cgo_tbtipgio+" "+m_Ctx.GetWritePhName("cgo_tbtipgio");
    }
    m_cServer_cgo_tbtipgio = p_ContextObject.GetServer("cgo_tbtipgio");
    m_cPhName_cgo_dest_alert = p_ContextObject.GetPhName("cgo_dest_alert");
    if (m_cPhName_cgo_dest_alert.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_dest_alert = m_cPhName_cgo_dest_alert+" "+m_Ctx.GetWritePhName("cgo_dest_alert");
    }
    m_cServer_cgo_dest_alert = p_ContextObject.GetServer("cgo_dest_alert");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_10start",p_cVarName)) {
      return _10start;
    }
    if (CPLib.eqr("_20start",p_cVarName)) {
      return _20start;
    }
    if (CPLib.eqr("_col3",p_cVarName)) {
      return _col3;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_alert_documenti";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      return _oldazi;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      return _gAzienda;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      return _gMsgProc;
    }
    if (CPLib.eqr("_gPathApp",p_cVarName)) {
      return _gPathApp;
    }
    if (CPLib.eqr("_mail10",p_cVarName)) {
      return _mail10;
    }
    if (CPLib.eqr("_mail20",p_cVarName)) {
      return _mail20;
    }
    if (CPLib.eqr("_codloc",p_cVarName)) {
      return _codloc;
    }
    if (CPLib.eqr("_nomloc",p_cVarName)) {
      return _nomloc;
    }
    if (CPLib.eqr("_indloc",p_cVarName)) {
      return _indloc;
    }
    if (CPLib.eqr("_desgio",p_cVarName)) {
      return _desgio;
    }
    if (CPLib.eqr("_srvmail",p_cVarName)) {
      return _srvmail;
    }
    if (CPLib.eqr("_prtmail",p_cVarName)) {
      return _prtmail;
    }
    if (CPLib.eqr("_emlmail",p_cVarName)) {
      return _emlmail;
    }
    if (CPLib.eqr("_usrmail",p_cVarName)) {
      return _usrmail;
    }
    if (CPLib.eqr("_pwdmail",p_cVarName)) {
      return _pwdmail;
    }
    if (CPLib.eqr("_emaildoc",p_cVarName)) {
      return _emaildoc;
    }
    if (CPLib.eqr("_testa",p_cVarName)) {
      return _testa;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
    }
    if (CPLib.eqr("_citloc",p_cVarName)) {
      return _citloc;
    }
    if (CPLib.eqr("_col1",p_cVarName)) {
      return _col1;
    }
    if (CPLib.eqr("_col2",p_cVarName)) {
      return _col2;
    }
    if (CPLib.eqr("_col8",p_cVarName)) {
      return _col8;
    }
    if (CPLib.eqr("_col9",p_cVarName)) {
      return _col9;
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
    if (CPLib.eqr("i_MessageSink",p_cVarName)) {
      return m_MessageSink.RowForCaller();
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_10start",p_cVarName)) {
      _10start = value;
      return;
    }
    if (CPLib.eqr("_20start",p_cVarName)) {
      _20start = value;
      return;
    }
    if (CPLib.eqr("_col3",p_cVarName)) {
      _col3 = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_oldazi",p_cVarName)) {
      _oldazi = value;
      return;
    }
    if (CPLib.eqr("_gAzienda",p_cVarName)) {
      _gAzienda = value;
      return;
    }
    if (CPLib.eqr("_gMsgProc",p_cVarName)) {
      _gMsgProc = value;
      return;
    }
    if (CPLib.eqr("_gPathApp",p_cVarName)) {
      _gPathApp = value;
      return;
    }
    if (CPLib.eqr("_mail10",p_cVarName)) {
      _mail10 = value;
      return;
    }
    if (CPLib.eqr("_mail20",p_cVarName)) {
      _mail20 = value;
      return;
    }
    if (CPLib.eqr("_codloc",p_cVarName)) {
      _codloc = value;
      return;
    }
    if (CPLib.eqr("_nomloc",p_cVarName)) {
      _nomloc = value;
      return;
    }
    if (CPLib.eqr("_indloc",p_cVarName)) {
      _indloc = value;
      return;
    }
    if (CPLib.eqr("_desgio",p_cVarName)) {
      _desgio = value;
      return;
    }
    if (CPLib.eqr("_srvmail",p_cVarName)) {
      _srvmail = value;
      return;
    }
    if (CPLib.eqr("_prtmail",p_cVarName)) {
      _prtmail = value;
      return;
    }
    if (CPLib.eqr("_emlmail",p_cVarName)) {
      _emlmail = value;
      return;
    }
    if (CPLib.eqr("_usrmail",p_cVarName)) {
      _usrmail = value;
      return;
    }
    if (CPLib.eqr("_pwdmail",p_cVarName)) {
      _pwdmail = value;
      return;
    }
    if (CPLib.eqr("_emaildoc",p_cVarName)) {
      _emaildoc = value;
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
    if (CPLib.eqr("_citloc",p_cVarName)) {
      _citloc = value;
      return;
    }
    if (CPLib.eqr("_col1",p_cVarName)) {
      _col1 = value;
      return;
    }
    if (CPLib.eqr("_col2",p_cVarName)) {
      _col2 = value;
      return;
    }
    if (CPLib.eqr("_col8",p_cVarName)) {
      _col8 = value;
      return;
    }
    if (CPLib.eqr("_col9",p_cVarName)) {
      _col9 = value;
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
    CPResultSet Cursor_cpazi=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_cgo_operazioni_agenzia_docs=null;
    CPResultSet Read_Cursor=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _oldazi Char(10) */
      /* _gAzienda Char(10) // Azienda */
      /* _gMsgProc Memo */
      /* _gPathApp Char(80) // Path Applicazione */
      /* _mail10 Memo */
      /* _mail20 Memo */
      /* _10start Numeric(1, 0) */
      /* _20start Numeric(1, 0) */
      /* _codloc Char(25) */
      /* _nomloc Char(30) */
      /* _indloc Char(40) */
      /* _desgio Char(50) */
      /* _srvmail Char(50) */
      /* _prtmail Char(5) */
      /* _emlmail Char(50) */
      /* _usrmail Char(50) */
      /* _pwdmail Char(30) */
      /* _emaildoc Char(80) */
      /* _testa Char(50) */
      /* nomefile Char(50) */
      /* _citloc Char(30) */
      /* _col1 Char(10) */
      /* _col2 Char(28) */
      /* _col3 Numeric(12, 2) */
      /* _col8 Char(60) */
      /* _col9 Char(60) */
      /* Debug Msg 'Invio dati alert operazioni' */
      if ( ! (CPLib.IsNull(m_Debug))) {
        m_Debug.log(CPLib.FormatMsg(m_Ctx,"Invio dati alert operazioni"));
      }
      /* Utilities.SetUserCode(1) */
      Utilities.Make(m_Ctx,m_Caller).SetUserCode(1);
      /* _oldazi := Utilities.GetCompany() */
      _oldazi = Utilities.Make(m_Ctx,m_Caller).GetCompany();
      /* _gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      /* _gPathApp := Strtran(FileLibMit.GetLocation(),'\','/') // Path Applicazione */
      _gPathApp = CPLib.Strtran(FileLibMit.GetLocation(),"\\","/");
      // * --- Select from cpazi
      m_cServer = m_Ctx.GetServer("cpazi");
      m_cPhName = m_Ctx.GetPhName("cpazi");
      if (Cursor_cpazi!=null)
        Cursor_cpazi.Close();
      Cursor_cpazi = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select codazi  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cpazi")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_cpazi.Eof())) {
        /* Utilities.SetCompany(LRTrim(cpazi->codazi)) */
        Utilities.Make(m_Ctx,m_Caller).SetCompany(CPLib.LRTrim(Cursor_cpazi.GetString("codazi")));
        /* _gAzienda := LRTrim(cpazi->codazi) // Azienda */
        _gAzienda = CPLib.LRTrim(Cursor_cpazi.GetString("codazi"));
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry00000026status;
        nTry00000026status = m_Sql.GetTransactionStatus();
        String cTry00000026msg;
        cTry00000026msg = m_Sql.TransactionErrorMessage();
        try {
          // * --- Select from intermbo
          m_cServer = m_Ctx.GetServer("intermbo");
          m_cPhName = m_Ctx.GetPhName("intermbo");
          if (Cursor_intermbo!=null)
            Cursor_intermbo.Close();
          Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select ALTSRVMAIL,ALTPRTMAIL,ALTEMLMAIL,ALTUSRMAIL,ALTPWDMAIL,EMAILDOC  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_intermbo.Eof())) {
            /* _srvmail := intermbo->ALTSRVMAIL */
            _srvmail = Cursor_intermbo.GetString("ALTSRVMAIL");
            /* _prtmail := iif(Empty(LRTrim(intermbo->ALTPRTMAIL)),'25',LRTrim(intermbo->ALTPRTMAIL)) */
            _prtmail = (CPLib.Empty(CPLib.LRTrim(Cursor_intermbo.GetString("ALTPRTMAIL")))?"25":CPLib.LRTrim(Cursor_intermbo.GetString("ALTPRTMAIL")));
            /* _emlmail := intermbo->ALTEMLMAIL */
            _emlmail = Cursor_intermbo.GetString("ALTEMLMAIL");
            /* _usrmail := intermbo->ALTUSRMAIL */
            _usrmail = Cursor_intermbo.GetString("ALTUSRMAIL");
            /* _pwdmail := intermbo->ALTPWDMAIL */
            _pwdmail = Cursor_intermbo.GetString("ALTPWDMAIL");
            /* _emaildoc := intermbo->EMAILDOC */
            _emaildoc = Cursor_intermbo.GetString("EMAILDOC");
            Cursor_intermbo.Next();
          }
          m_cConnectivityError = Cursor_intermbo.ErrorMessage();
          Cursor_intermbo.Close();
          // * --- End Select
          /* _testa := "Operazioni_Documentazione_Incompleta_"+DateToChar(Date())+".xls" */
          _testa = "Operazioni_Documentazione_Incompleta_"+CPLib.DateToChar(CPLib.Date())+".xls";
          /* nomefile := LRTrim(_gPathApp)+"/export/"+LRTrim(_gAzienda)+"/"+LRTrim(_testa) */
          nomefile = CPLib.LRTrim(_gPathApp)+"/export/"+CPLib.LRTrim(_gAzienda)+"/"+CPLib.LRTrim(_testa);
          // Crea il foglio e scrive la testata
          WorkbookSettings ws = new WorkbookSettings();
          WritableWorkbook prova = Workbook.createWorkbook(new File(nomefile), ws);
          WritableSheet foglio = prova.createSheet("Operazioni", 0);
          WritableFont arial11font = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, true);
          WritableCellFormat arial11format = new WritableCellFormat (arial11font);
          WritableCellFormat intNum = new WritableCellFormat(NumberFormats.INTEGER);
          WritableCellFormat dblNum = new WritableCellFormat(NumberFormats.FLOAT);
          DateFormat df = new DateFormat("dd-mm-yyyy");
          WritableCellFormat cf1 = new WritableCellFormat(df);
          Label stringa = new Label(0,0,"Data Operazione",arial11format);
          foglio.addCell(stringa); 
          stringa = new Label(1,0,"ID Ticket",arial11format);
          foglio.addCell(stringa);
          stringa = new Label(2,0,"Importo",arial11format);
          foglio.addCell(stringa);
          stringa = new Label(3,0,"Punto Vendita",arial11format);
          foglio.addCell(stringa);
          stringa = new Label(4,0,"Descrizione",arial11format);
          foglio.addCell(stringa);
          stringa = new Label(5,0,"Indirizzo",arial11format);
          foglio.addCell(stringa);
          stringa = new Label(6,0,"Comune",arial11format);
          foglio.addCell(stringa);
          stringa = new Label(7,0,"Tipo Gioco",arial11format);
          foglio.addCell(stringa);
          stringa = new Label(8,0,"Tipo Operazione",arial11format);
          foglio.addCell(stringa);
          riga=2;
          // * --- Select from qbe_cgo_operazioni_agenzia_docs
          SPBridge.HMCaller _h00000033;
          _h00000033 = new SPBridge.HMCaller();
          _h00000033.Set("m_cVQRList",m_cVQRList);
          _h00000033.Set("flgdoc","N");
          if (Cursor_qbe_cgo_operazioni_agenzia_docs!=null)
            Cursor_qbe_cgo_operazioni_agenzia_docs.Close();
          Cursor_qbe_cgo_operazioni_agenzia_docs = new VQRHolder("qbe_cgo_operazioni_agenzia_docs",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000033,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_cgo_operazioni_agenzia_docs.Eof())) {
            /* _col1 := arfn_fdate(qbe_cgo_operazioni_agenzia_docs->DATAOPE) */
            _col1 = arfn_fdateR.Make(m_Ctx,this).Run(Cursor_qbe_cgo_operazioni_agenzia_docs.GetDate("DATAOPE"));
            /* _col2 := LRTrim(qbe_cgo_operazioni_agenzia_docs->CAIDBIGLIETTO) */
            _col2 = CPLib.LRTrim(Cursor_qbe_cgo_operazioni_agenzia_docs.GetString("CAIDBIGLIETTO"));
            /* _col3 := qbe_cgo_operazioni_agenzia_docs->TOTLIRE */
            _col3 = CPLib.Round(Cursor_qbe_cgo_operazioni_agenzia_docs.GetDouble("TOTLIRE"),2);
            /* _codloc := '' */
            _codloc = "";
            /* _nomloc := '' */
            _nomloc = "";
            /* _indloc := '' */
            _indloc = "";
            /* _citloc := '' */
            _citloc = "";
            // * --- Read from anadip
            m_cServer = m_Ctx.GetServer("anadip");
            m_cPhName = m_Ctx.GetPhName("anadip");
            m_cSql = "";
            m_cSql = m_cSql+"CODDIP="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_cgo_operazioni_agenzia_docs.GetString("CODDIPE"),"C",6,0,m_cServer),m_cServer,Cursor_qbe_cgo_operazioni_agenzia_docs.GetString("CODDIPE"));
            if (m_Ctx.IsSharedTemp("anadip")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRIZ",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DOMICILIO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("CODLOC",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DESCCIT",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _nomloc = Read_Cursor.GetString("DESCRIZ");
              _indloc = Read_Cursor.GetString("DOMICILIO");
              _codloc = Read_Cursor.GetString("CODLOC");
              _citloc = Read_Cursor.GetString("DESCCIT");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on anadip into routine arrt_cgo_alert_documenti returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _nomloc = "";
              _indloc = "";
              _codloc = "";
              _citloc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _desgio := '' */
            _desgio = "";
            // * --- Read from cgo_tbtipgio
            m_cServer = m_Ctx.GetServer("cgo_tbtipgio");
            m_cPhName = m_Ctx.GetPhName("cgo_tbtipgio");
            m_cSql = "";
            m_cSql = m_cSql+"CODTPGIO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_cgo_operazioni_agenzia_docs.GetString("TIPOGIOCO"),"C",3,0,m_cServer),m_cServer,Cursor_qbe_cgo_operazioni_agenzia_docs.GetString("TIPOGIOCO"));
            if (m_Ctx.IsSharedTemp("cgo_tbtipgio")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESTPGIO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _desgio = Read_Cursor.GetString("DESTPGIO");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cgo_tbtipgio into routine arrt_cgo_alert_documenti returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _desgio = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _col8 := LRTrim(_desgio) */
            _col8 = CPLib.LRTrim(_desgio);
            /* _col9 :=  LRTrim(arfn_dectabs('TPO', LRTrim(qbe_cgo_operazioni_agenzia_docs->CAFLGOPE))) */
            _col9 = CPLib.LRTrim(arfn_dectabsR.Make(m_Ctx,this).Run("TPO",CPLib.LRTrim(Cursor_qbe_cgo_operazioni_agenzia_docs.GetString("CAFLGOPE"))));
            // Scrive i dati 
            stringa = new Label(0,riga,_col1);
            foglio.addCell(stringa); 
            stringa = new Label(1,riga,_col2);
            foglio.addCell(stringa);
            Number num1 = new Number(2,riga,_col3,dblNum);
            foglio.addCell(num1); 
            stringa = new Label(3,riga,_codloc);
            foglio.addCell(stringa);
            stringa = new Label(4,riga,_nomloc);
            foglio.addCell(stringa);
            stringa = new Label(5,riga,_indloc);
            foglio.addCell(stringa);
            stringa = new Label(6,riga,_citloc);
            foglio.addCell(stringa);
            stringa = new Label(7,riga,_col8);
            foglio.addCell(stringa);
            stringa = new Label(8,riga,_col9);
            foglio.addCell(stringa);
            riga = riga + 1;
            Cursor_qbe_cgo_operazioni_agenzia_docs.Next();
          }
          m_cConnectivityError = Cursor_qbe_cgo_operazioni_agenzia_docs.ErrorMessage();
          Cursor_qbe_cgo_operazioni_agenzia_docs.Close();
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
          // Scrive il foglio e lo chiude
          prova.write();
          prova.close();
          /* Sp_Lib_SendMail.sendMailPers(_mail10,'TXT','Segnalazione Documentazione non chiuse',LRTrim(_srvmail),LRTrim(_emaildoc),'','',LRTrim(_emlmail),LRTrim(nomefile),LRTrim(_usrmail),LRTrim(_pwdmail),'N',LRTrim(_prtmail),'','WEBANTI') */
          Sp_Lib_SendMail.sendMailPers(_mail10,"TXT","Segnalazione Documentazione non chiuse",CPLib.LRTrim(_srvmail),CPLib.LRTrim(_emaildoc),"","",CPLib.LRTrim(_emlmail),CPLib.LRTrim(nomefile),CPLib.LRTrim(_usrmail),CPLib.LRTrim(_pwdmail),"N",CPLib.LRTrim(_prtmail),"","WEBANTI");
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          /* _gMsgProc := _gMsgProc + "Rilevati errori nell'elaborazione delle email" + NL */
          _gMsgProc = _gMsgProc+"Rilevati errori nell'elaborazione delle email"+"\n";
          /* _gMsgProc := _gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
          _gMsgProc = _gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000026status,0)) {
            m_Sql.SetTransactionStatus(nTry00000026status,cTry00000026msg);
          }
        }
        Cursor_cpazi.Next();
      }
      m_cConnectivityError = Cursor_cpazi.ErrorMessage();
      Cursor_cpazi.Close();
      // * --- End Select
      /* Utilities.SetCompany(_oldazi) */
      Utilities.Make(m_Ctx,m_Caller).SetCompany(_oldazi);
      /* _gMsgProc := _gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
      _gMsgProc = _gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    } finally {
      try {
        if (Cursor_cpazi!=null)
          Cursor_cpazi.Close();
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
      try {
        if (Cursor_qbe_cgo_operazioni_agenzia_docs!=null)
          Cursor_qbe_cgo_operazioni_agenzia_docs.Close();
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
  public String RunAsync() {
    m_MessageSink = new CPAsyncRoutine.AsyncSink();
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
    ,m_MessageSink
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_cgo_alert_documentiR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_alert_documentiR(p_Ctx, p_Caller);
  }
  public void Blank() {
    _oldazi = CPLib.Space(10);
    _gAzienda = CPLib.Space(10);
    _gMsgProc = "";
    _gPathApp = CPLib.Space(80);
    _mail10 = "";
    _mail20 = "";
    _10start = 0;
    _20start = 0;
    _codloc = CPLib.Space(25);
    _nomloc = CPLib.Space(30);
    _indloc = CPLib.Space(40);
    _desgio = CPLib.Space(50);
    _srvmail = CPLib.Space(50);
    _prtmail = CPLib.Space(5);
    _emlmail = CPLib.Space(50);
    _usrmail = CPLib.Space(50);
    _pwdmail = CPLib.Space(30);
    _emaildoc = CPLib.Space(80);
    _testa = CPLib.Space(50);
    nomefile = CPLib.Space(50);
    _citloc = CPLib.Space(30);
    _col1 = CPLib.Space(10);
    _col2 = CPLib.Space(28);
    _col3 = 0;
    _col8 = CPLib.Space(60);
    _col9 = CPLib.Space(60);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_cgo_operazioni_agenzia_docs,
  public static final String m_cVQRList = ",qbe_cgo_operazioni_agenzia_docs,";
  // ENTITY_BATCHES: ,arfn_dectabs,arfn_fdate,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_dectabs,arfn_fdate,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
