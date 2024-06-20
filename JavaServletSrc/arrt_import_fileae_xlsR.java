// * --- Area Manuale = BO - Header
// * --- arrt_import_fileae_xls
import java.io.File; 
import java.lang.Double;

import jxl.*;
// * --- Fine Area Manuale
public class arrt_import_fileae_xlsR implements CallerWithObjs {
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
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_tmp_vegagest;
  public String m_cServer_tmp_vegagest;
  public String m_cPhName_jnarapbo;
  public String m_cServer_jnarapbo;
  public String m_cPhName_jntestbo;
  public String m_cServer_jntestbo;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_joginfo;
  public String m_cServer_joginfo;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_soginfo;
  public String m_cServer_soginfo;
  String m_cServer;
  String m_cPhName;
  String m_cQuery;
  String m_cQueryTable;
  String m_cSql;
  java.util.List<String> m_oParameters;
  String m_cWhere;
  int m_nUpdatedRows;
  // Contiene il messaggio di errore dell'ultima select terminata a causa della caduta della connessione
  String m_cConnectivityError;
  public String w_msgproc;
  public String w_prefrap;
  public String w_codval;
  public String w_f_ricaui;
  public String nomefile;
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
  public String cRapporto;
  public String xRapporto;
  public double _nrighe;
  public String _tiprap;
  public double nProgImp;
  public double nProgImp1;
  public double nProgImp2;
  public double nProgImp3;
  public double nProgImp4;
  public String cID;
  public double _numriga;
  public double xRiga;
  public String _desrap;
  public String _connes;
  public String _xconnes;
  public String gAzienda;
  public String gPathApp;
  public String gMsgImp;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_import_fileae_xls
  public int _i;
  public int _y;
  public int _righe;
  public int conta;
  // * --- Fine Area Manuale
  public arrt_import_fileae_xlsR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_import_fileae_xls",m_Caller);
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_vegagest")) {
      m_cPhName_tmp_vegagest = p_ContextObject.GetPhName("tmp_vegagest");
      m_cServer_tmp_vegagest = p_ContextObject.GetServer("tmp_vegagest");
    }
    m_cPhName_jnarapbo = p_ContextObject.GetPhName("jnarapbo");
    m_cServer_jnarapbo = p_ContextObject.GetServer("jnarapbo");
    m_cPhName_jntestbo = p_ContextObject.GetPhName("jntestbo");
    m_cServer_jntestbo = p_ContextObject.GetServer("jntestbo");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_joginfo = p_ContextObject.GetPhName("joginfo");
    m_cServer_joginfo = p_ContextObject.GetServer("joginfo");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_soginfo = p_ContextObject.GetPhName("soginfo");
    m_cServer_soginfo = p_ContextObject.GetServer("soginfo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_nrighe",p_cVarName)) {
      return _nrighe;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      return nProgImp;
    }
    if (CPLib.eqr("nProgImp1",p_cVarName)) {
      return nProgImp1;
    }
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      return nProgImp2;
    }
    if (CPLib.eqr("nProgImp3",p_cVarName)) {
      return nProgImp3;
    }
    if (CPLib.eqr("nProgImp4",p_cVarName)) {
      return nProgImp4;
    }
    if (CPLib.eqr("_numriga",p_cVarName)) {
      return _numriga;
    }
    if (CPLib.eqr("xRiga",p_cVarName)) {
      return xRiga;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_import_fileae_xls";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("msgproc",p_cVarName)) {
      return w_msgproc;
    }
    if (CPLib.eqr("prefrap",p_cVarName)) {
      return w_prefrap;
    }
    if (CPLib.eqr("codval",p_cVarName)) {
      return w_codval;
    }
    if (CPLib.eqr("f_ricaui",p_cVarName)) {
      return w_f_ricaui;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      return nomefile;
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
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      return cRapporto;
    }
    if (CPLib.eqr("xRapporto",p_cVarName)) {
      return xRapporto;
    }
    if (CPLib.eqr("_tiprap",p_cVarName)) {
      return _tiprap;
    }
    if (CPLib.eqr("cID",p_cVarName)) {
      return cID;
    }
    if (CPLib.eqr("_desrap",p_cVarName)) {
      return _desrap;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      return _connes;
    }
    if (CPLib.eqr("_xconnes",p_cVarName)) {
      return _xconnes;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
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
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_nrighe",p_cVarName)) {
      _nrighe = value;
      return;
    }
    if (CPLib.eqr("nProgImp",p_cVarName)) {
      nProgImp = value;
      return;
    }
    if (CPLib.eqr("nProgImp1",p_cVarName)) {
      nProgImp1 = value;
      return;
    }
    if (CPLib.eqr("nProgImp2",p_cVarName)) {
      nProgImp2 = value;
      return;
    }
    if (CPLib.eqr("nProgImp3",p_cVarName)) {
      nProgImp3 = value;
      return;
    }
    if (CPLib.eqr("nProgImp4",p_cVarName)) {
      nProgImp4 = value;
      return;
    }
    if (CPLib.eqr("_numriga",p_cVarName)) {
      _numriga = value;
      return;
    }
    if (CPLib.eqr("xRiga",p_cVarName)) {
      xRiga = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("msgproc",p_cVarName)) {
      w_msgproc = value;
      return;
    }
    if (CPLib.eqr("prefrap",p_cVarName)) {
      w_prefrap = value;
      return;
    }
    if (CPLib.eqr("codval",p_cVarName)) {
      w_codval = value;
      return;
    }
    if (CPLib.eqr("f_ricaui",p_cVarName)) {
      w_f_ricaui = value;
      return;
    }
    if (CPLib.eqr("nomefile",p_cVarName)) {
      nomefile = value;
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
    if (CPLib.eqr("cRapporto",p_cVarName)) {
      cRapporto = value;
      return;
    }
    if (CPLib.eqr("xRapporto",p_cVarName)) {
      xRapporto = value;
      return;
    }
    if (CPLib.eqr("_tiprap",p_cVarName)) {
      _tiprap = value;
      return;
    }
    if (CPLib.eqr("cID",p_cVarName)) {
      cID = value;
      return;
    }
    if (CPLib.eqr("_desrap",p_cVarName)) {
      _desrap = value;
      return;
    }
    if (CPLib.eqr("_connes",p_cVarName)) {
      _connes = value;
      return;
    }
    if (CPLib.eqr("_xconnes",p_cVarName)) {
      _xconnes = value;
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
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      gMsgImp = value;
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
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tmp_list_imprich=null;
    CPResultSet Read_Cursor=null;
    try {
      /* Dichiarazione variabili del caller */
      /* w_msgproc Memo */
      /* w_prefrap Char(5) */
      /* w_codval Char(3) */
      /* w_f_ricaui Char(1) */
      /* Definizione variabili locali */
      /* nomefile Char(30) */
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
      /* cRapporto Char(25) */
      /* xRapporto Char(25) */
      /* _nrighe Numeric(3, 0) */
      /* _tiprap Char(1) */
      /* nProgImp Numeric(15, 0) */
      /* nProgImp1 Numeric(15, 0) */
      /* nProgImp2 Numeric(15, 0) */
      /* nProgImp3 Numeric(15, 0) */
      /* nProgImp4 Numeric(15, 0) */
      /* cID Char(10) */
      /* _numriga Numeric(4, 0) */
      /* xRiga Numeric(10, 0) */
      /* _desrap Char(50) */
      /* _connes Char(16) */
      /* _xconnes Char(16) */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gMsgImp Memo // Messaggio Import */
      // * --- Drop temporary table tmp_vegagest
      if (m_Ctx.IsSharedTemp("tmp_vegagest")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_vegagest")) {
          m_cServer = m_Ctx.GetServer("tmp_vegagest");
          m_cPhName = m_Ctx.GetPhName("tmp_vegagest");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_vegagest");
      }
      // * --- Create temporary table tmp_vegagest
      if (m_Ctx.IsSharedTemp("tmp_vegagest")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_vegagest")) {
          m_cServer = m_Ctx.GetServer("tmp_vegagest");
          m_cPhName = m_Ctx.GetPhName("tmp_vegagest");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_vegagest");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_vegagest");
      if ( ! (m_Ctx.IsSharedTemp("tmp_vegagest"))) {
        m_cServer = m_Ctx.GetServer("tmp_vegagest");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_vegagest",m_cServer,"proto")),m_cPhName,"tmp_vegagest",m_Ctx,new String[]{"RAPPORTO","COGNOME","NOME","CODFISC","PIVA"});
      }
      m_cPhName_tmp_vegagest = m_cPhName;
      /* w_msgproc := '' */
      w_msgproc = "";
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* nomefile := LRTrim(tmp_list_imprich->nomefile) */
        nomefile = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
        /* w_msgproc := w_msgproc+'file ='+nomefile+ NL */
        w_msgproc = w_msgproc+"file ="+nomefile+"\n";
        //base
        Workbook workbook = Workbook.getWorkbook(new File(CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(nomefile)));
        conta = workbook.getNumberOfSheets();
        /* _i = 0 */
        CPLib.eqr(_i,0);
        /* While _i < conta */
        while (CPLib.lt(_i,conta)) {
          _righe = 0;
          Sheet sheet = workbook.getSheet(_i);
          _righe = sheet.getRows();
          _y = 1;
          /* While _y < _righe */
          while (CPLib.lt(_y,_righe)) {
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
            /* column01 := a01.getContents() */
            column01 = a01.getContents();
            /* column02 := a02.getContents() */
            column02 = a02.getContents();
            /* column03 := a03.getContents() */
            column03 = a03.getContents();
            /* column04 := a04.getContents() */
            column04 = a04.getContents();
            /* column05 := a05.getContents() */
            column05 = a05.getContents();
            /* column06 := a06.getContents() */
            column06 = a06.getContents();
            /* column07 := a07.getContents() */
            column07 = a07.getContents();
            /* column08 := a08.getContents() */
            column08 = a08.getContents();
            /* column09 := a09.getContents() */
            column09 = a09.getContents();
            /* column10 := a10.getContents() */
            column10 = a10.getContents();
            /* column11 := a11.getContents() */
            column11 = a11.getContents();
            /* column12 := a12.getContents() */
            column12 = a12.getContents();
            /* column13 := a13.getContents() */
            column13 = a13.getContents();
            /* column14 := a14.getContents() */
            column14 = a14.getContents();
            /* column15 := a15.getContents() */
            column15 = a15.getContents();
            /* column16 := a16.getContents() */
            column16 = a16.getContents();
            /* column17 := a17.getContents() */
            column17 = a17.getContents();
            /* column18 := a18.getContents() */
            column18 = a18.getContents();
            /* column19 := a19.getContents() */
            column19 = a19.getContents();
            /* column20 := a20.getContents() */
            column20 = a20.getContents();
            /* column21 := a21.getContents() */
            column21 = a21.getContents();
            /* column22 := a22.getContents() */
            column22 = a22.getContents();
            /* column23 := a23.getContents() */
            column23 = a23.getContents();
            /* column24 := a24.getContents() */
            column24 = a24.getContents();
            /* column25 := a25.getContents() */
            column25 = a25.getContents();
            /* column26 := a26.getContents() */
            column26 = a26.getContents();
            /* column27 := a27.getContents() */
            column27 = a27.getContents();
            /* If not(Empty(LRTrim(column27))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(column27)))) {
              // * --- Insert into tmp_vegagest from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_vegagest");
              m_cPhName = m_Ctx.GetPhName("tmp_vegagest");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_vegagest")+" (";
              m_cSql = m_cSql+GetFieldsName_0735D8F8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column01),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column02),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column05),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column06),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column27),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column17),"0")?"":CPLib.LRTrim(column17)),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_vegagest")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_vegagest",true);
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
              /* gMsgImp := 'Elaborazione Foglio N.'+LRTrim(Str(_i+1,2,0))+' - Riga N. '+LRTrim(Str(_y+1,7,0))+' - Rapporto N. : '+LRTrim(column01) // Messaggio Import */
              gMsgImp = "Elaborazione Foglio N."+CPLib.LRTrim(CPLib.Str(_i+1,2,0))+" - Riga N. "+CPLib.LRTrim(CPLib.Str(_y+1,7,0))+" - Rapporto N. : "+CPLib.LRTrim(column01);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            } else { // Else
              // * --- Insert into tmp_vegagest from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_vegagest");
              m_cPhName = m_Ctx.GetPhName("tmp_vegagest");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_vegagest")+" (";
              m_cSql = m_cSql+GetFieldsName_073D2380(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column01),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column02),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column05),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column06),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column16),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column17),"0")?"":CPLib.LRTrim(column17)),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_vegagest")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_vegagest",true);
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
              /* gMsgImp := 'Elaborazione Foglio N.'+LRTrim(Str(_i+1,2,0))+' - Riga N. '+LRTrim(Str(_y+1,7,0))+' - Rapporto N. : '+LRTrim(column01) // Messaggio Import */
              gMsgImp = "Elaborazione Foglio N."+CPLib.LRTrim(CPLib.Str(_i+1,2,0))+" - Riga N. "+CPLib.LRTrim(CPLib.Str(_y+1,7,0))+" - Rapporto N. : "+CPLib.LRTrim(column01);
              m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
              /* _connes := iif(Empty(LRTrim(column16)),LRTrim(column17),LRTrim(column16)) */
              _connes = (CPLib.Empty(CPLib.LRTrim(column16))?CPLib.LRTrim(column17):CPLib.LRTrim(column16));
              /* _xconnes := '' */
              _xconnes = "";
              // * --- Read from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_cSql = "";
              m_cSql = m_cSql+"CONNES="+CPSql.SQLValueAdapter(CPLib.ToSQL(_connes,"C",16,0,m_cServer),m_cServer,_connes);
              if (m_Ctx.IsSharedTemp("personbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CONNES",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _xconnes = Read_Cursor.GetString("CONNES");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on personbo into routine arrt_import_fileae_xls returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _xconnes = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If Empty(LRTrim(_xconnes)) */
              if (CPLib.Empty(CPLib.LRTrim(_xconnes))) {
                /* nProgImp := Utilities.GetAutonumber("PRGIMPOCLI\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPOCLI\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* If Empty(LRTrim(column16)) */
                if (CPLib.Empty(CPLib.LRTrim(column16))) {
                  // * --- Insert into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"personbo")+" (";
                  m_cSql = m_cSql+GetFieldsName_0750C6E8(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column17),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column17),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column17),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column05),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column23),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column11),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column24),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column25),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column26),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column12),30),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column13),2),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column14),5),"?",0,0,m_cServer)+", ";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                  }
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
                } else { // Else
                  // * --- Insert into personbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.InsertIntoStatement(m_Ctx,"personbo")+" (";
                  m_cSql = m_cSql+GetFieldsName_06305EC0(m_Ctx);
                  m_cSql = m_cSql+") values (";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column16),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column16),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column05)+" "+CPLib.LRTrim(column06),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp,"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(column05,26),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(column06,25),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column23),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column11),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(column08,7,4)+CPLib.Substr(column08,4,2)+CPLib.Substr(column08,1,2)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column24),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column25),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(column26),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL("0"+CPLib.Left(CPLib.LRTrim(column18),1),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column19),15),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column20),30),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.CharToDate(CPLib.Substr(column21,7,4)+CPLib.Substr(column21,4,2)+CPLib.Substr(column21,1,2)),"?",0,0)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column12),30),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column13),2),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column22),3),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column14),5),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column10),"EE")?"":CPLib.Left(CPLib.LRTrim(column09),30)),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column10),"EE")?CPLib.Left(CPLib.LRTrim(column09),30):""),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(CPLib.LRTrim(column15),"M")?"1":"2"),"?",0,0,m_cServer)+", ";
                  m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(column10),2),"?",0,0,m_cServer)+", ";
                  if (m_Ctx.IsSharedTemp("personbo")) {
                    m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                  }
                  m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo",true);
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
                } // End If
              } // End If
            } // End If
            _y++;
          } // End While
          _i++;
        } // End While
        /* workbook.close() */
        workbook.close();
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* Exec "Crea Rapporti in AGE" Page 2 */
      Page_2();
      /* gMsgImp := 'Elaborazione Terminata !' // Messaggio Import */
      gMsgImp = "Elaborazione Terminata !";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
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
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_listrapvgi=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_dettrapvgi=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Crea Rapporti in agenzia entrate */
      // * --- Select from qbe_listrapvgi
      if (Cursor_qbe_listrapvgi!=null)
        Cursor_qbe_listrapvgi.Close();
      Cursor_qbe_listrapvgi = new VQRHolder("qbe_listrapvgi",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_listrapvgi.Eof())) {
        /* xRapporto := '' */
        xRapporto = "";
        /* _desrap := '' */
        _desrap = "";
        /* _tiprap := '' */
        _tiprap = "";
        /* cRapporto := qbe_listrapvgi->RAPPORTO */
        cRapporto = Cursor_qbe_listrapvgi.GetString("RAPPORTO");
        /* _nrighe := qbe_listrapvgi->TOTALE */
        _nrighe = CPLib.Round(Cursor_qbe_listrapvgi.GetDouble("TOTALE"),0);
        /* If w_f_ricaui='G' */
        if (CPLib.eqr(w_f_ricaui,"G")) {
          // * --- Read from jnarapbo
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"C",25,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)));
          if (m_Ctx.IsSharedTemp("jnarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xRapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_import_fileae_xls returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xRapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(xRapporto)) */
          if (CPLib.Empty(CPLib.LRTrim(xRapporto))) {
            /* gMsgImp := 'Sto inserendo in archivio AGE il rapporto '+LRTrim(cRapporto) // Messaggio Import */
            gMsgImp = "Sto inserendo in archivio AGE il rapporto "+CPLib.LRTrim(cRapporto);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* nProgImp1 := Utilities.GetAutonumber("PRGIMPRAPAGE\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp1 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAPAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into jnarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jnarapbo");
            m_cPhName = m_Ctx.GetPhName("jnarapbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jnarapbo")+" (";
            m_cSql = m_cSql+GetFieldsName_05E17D10(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(_nrighe,1)?"1":""),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_codval,"242")?"E":"V"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_codval,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp1,"?",0,0)+", ";
            if (m_Ctx.IsSharedTemp("jnarapbo")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jnarapbo",true);
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
          } // End If
        } else { // Else
          // * --- Read from jnarapbo
          m_cServer = m_Ctx.GetServer("jnarapbo");
          m_cPhName = m_Ctx.GetPhName("jnarapbo");
          m_cSql = "";
          m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"C",25,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)));
          if (m_Ctx.IsSharedTemp("jnarapbo")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            xRapporto = Read_Cursor.GetString("RAPPORTO");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on jnarapbo into routine arrt_import_fileae_xls returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            xRapporto = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
          /* If Empty(LRTrim(xRapporto)) */
          if (CPLib.Empty(CPLib.LRTrim(xRapporto))) {
            /* gMsgImp := 'Sto inserendo in archivio AUI il rapporto '+LRTrim(cRapporto) // Messaggio Import */
            gMsgImp = "Sto inserendo in archivio AUI il rapporto "+CPLib.LRTrim(cRapporto);
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* nProgImp1 := Utilities.GetAutonumber("PRGIMPRAP\'"+LRTrim(gAzienda)+"'",0,15) */
            nProgImp1 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPRAP\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
            // * --- Insert into jnarapbo from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("jnarapbo");
            m_cPhName = m_Ctx.GetPhName("jnarapbo");
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jnarapbo")+" (";
            m_cSql = m_cSql+GetFieldsName_07C93610(m_Ctx);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(_nrighe,1)?"1":""),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(w_codval,"242")?"E":"V"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(w_codval,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp1,"?",0,0)+", ";
            if (m_Ctx.IsSharedTemp("jnarapbo")) {
              m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
            }
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jnarapbo",true);
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
          } // End If
        } // End If
        /* xRapporto := '' */
        xRapporto = "";
        // * --- Read from aetesta
        m_cServer = m_Ctx.GetServer("aetesta");
        m_cPhName = m_Ctx.GetPhName("aetesta");
        m_cSql = "";
        m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"C",25,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)));
        if (m_Ctx.IsSharedTemp("aetesta")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("RAPPORTO",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          xRapporto = Read_Cursor.GetString("RAPPORTO");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on aetesta into routine arrt_import_fileae_xls returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          xRapporto = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If Empty(LRTrim(xRapporto)) */
        if (CPLib.Empty(CPLib.LRTrim(xRapporto))) {
          /* nProgImp2 := Utilities.GetAutonumber("PROGAET\'"+LRTrim(gAzienda)+"'",0,15) */
          nProgImp2 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAET\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
          /* gMsgImp := 'Sto inserendo in anagrafe tributaria il rapporto '+LRTrim(cRapporto) // Messaggio Import */
          gMsgImp = "Sto inserendo in anagrafe tributaria il rapporto "+CPLib.LRTrim(cRapporto);
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Insert into aetesta from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aetesta");
          m_cPhName = m_Ctx.GetPhName("aetesta");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aetesta")+" (";
          m_cSql = m_cSql+GetFieldsName_061FA5F8(m_Ctx);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.gt(_righe,1)?"1":"0"),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("E","?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp2,"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL("S","?",0,0,m_cServer)+", ";
          if (m_Ctx.IsSharedTemp("aetesta")) {
            m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
          }
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aetesta",true);
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
        } // End If
        /* _numriga := 1 */
        _numriga = CPLib.Round(1,0);
        // * --- Select from qbe_dettrapvgi
        if (Cursor_qbe_dettrapvgi!=null)
          Cursor_qbe_dettrapvgi.Close();
        Cursor_qbe_dettrapvgi = new VQRHolder("qbe_dettrapvgi",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_dettrapvgi.Eof())) {
          /* If _nrighe=1 */
          if (CPLib.eqr(_nrighe,1)) {
            /* _tiprap := iif(Empty(LRTrim(qbe_dettrapvgi->CODFISC)),'2','0') */
            _tiprap = (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?"2":"0");
            /* _desrap := Left(LRTrim(qbe_dettrapvgi->COGNOME)+" "+LRTrim(qbe_dettrapvgi->NOME),50) */
            _desrap = CPLib.Left(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("NOME")),50);
          } else { // Else
            /* _tiprap := '1' */
            _tiprap = "1";
            /* If LRTrim(qbe_dettrapvgi->TIPO)='A' */
            if (CPLib.eqr(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("TIPO")),"A")) {
              /* _desrap := Left(LRTrim(qbe_dettrapvgi->COGNOME)+" "+LRTrim(qbe_dettrapvgi->NOME),50) */
              _desrap = CPLib.Left(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("COGNOME"))+" "+CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("NOME")),50);
            } // End If
          } // End If
          /* If LRTrim(qbe_dettrapvgi->TIPO)='A' or LRTrim(qbe_dettrapvgi->TIPO)='M' */
          if (CPLib.eqr(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("TIPO")),"A") || CPLib.eqr(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("TIPO")),"M")) {
            /* If w_f_ricaui='G' */
            if (CPLib.eqr(w_f_ricaui,"G")) {
              /* xRiga := 0 */
              xRiga = CPLib.Round(0,0);
              // * --- Read from jntestbo
              m_cServer = m_Ctx.GetServer("jntestbo");
              m_cPhName = m_Ctx.GetPhName("jntestbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"C",25,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)));
              m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"C",16,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))));
              if (m_Ctx.IsSharedTemp("jntestbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xRiga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on jntestbo into routine arrt_import_fileae_xls returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xRiga = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If xRiga = 0 */
              if (CPLib.eqr(xRiga,0)) {
                // * --- Write into jnarapbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jnarapbo");
                m_cPhName = m_Ctx.GetPhName("jnarapbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQL(_tiprap,"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(_desrap,"C",50,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"jnarapbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)))+"";
                if (m_Ctx.IsSharedTemp("jnarapbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
                /* nProgImp3 := Utilities.GetAutonumber("PRGIMPSOGAGE\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp3 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOGAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* cID := LibreriaMit.UniqueId() */
                cID = LibreriaMit.UniqueId();
                // * --- Insert into jntestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("jntestbo");
                m_cPhName = m_Ctx.GetPhName("jntestbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"jntestbo")+" (";
                m_cSql = m_cSql+GetFieldsName_0646D2B0(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cID,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_numriga,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("jntestbo")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"jntestbo",true);
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
              } // End If
            } else { // Else
              /* xRiga := 0 */
              xRiga = CPLib.Round(0,0);
              // * --- Read from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"C",25,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)));
              m_cSql = m_cSql+" and CODINTER="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"C",16,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))));
              if (m_Ctx.IsSharedTemp("intestbo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xRiga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on intestbo into routine arrt_import_fileae_xls returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xRiga = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If xRiga = 0 */
              if (CPLib.eqr(xRiga,0)) {
                // * --- Write into anarapbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("anarapbo");
                m_cPhName = m_Ctx.GetPhName("anarapbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = "Update "+m_cPhName+" set ";
                m_cSql = m_cSql+"TIPORAP = "+CPLib.ToSQLNull(_tiprap,"C",1,0,m_cServer)+", ";
                m_cSql = m_cSql+"DESCRAP = "+CPLib.ToSQL(_desrap,"C",50,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anarapbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)))+"";
                if (m_Ctx.IsSharedTemp("anarapbo")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
                if (CPLib.lt(m_nUpdatedRows,0)) {
                  m_Sql.AbortTransaction();
                }
                m_Sql.CompleteTransaction();
                m_cLastMsgError = m_Sql.TransactionErrorMessage();
                if (CPLib.ne(m_cLastMsgError,"")) {
                  m_bError = true;
                }
                /* nProgImp3 := Utilities.GetAutonumber("PRGIMPSOGAGE\'"+LRTrim(gAzienda)+"'",0,15) */
                nProgImp3 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGIMPSOGAGE\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
                /* cID := LibreriaMit.UniqueId() */
                cID = LibreriaMit.UniqueId();
                // * --- Insert into intestbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("intestbo");
                m_cPhName = m_Ctx.GetPhName("intestbo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"intestbo")+" (";
                m_cSql = m_cSql+GetFieldsName_05E690B8(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL("0","?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(cID,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_numriga,"?",0,0)+", ";
                if (m_Ctx.IsSharedTemp("intestbo")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"intestbo",true);
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
              } // End If
            } // End If
            /* xRiga := 0 */
            xRiga = CPLib.Round(0,0);
            // * --- Read from aerighe
            m_cServer = m_Ctx.GetServer("aerighe");
            m_cPhName = m_Ctx.GetPhName("aerighe");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"C",25,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)));
            m_cSql = m_cSql+" and CONNESINT="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"C",16,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))));
            if (m_Ctx.IsSharedTemp("aerighe")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xRiga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aerighe into routine arrt_import_fileae_xls returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xRiga = 0;
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If xRiga = 0 */
            if (CPLib.eqr(xRiga,0)) {
              /* nProgImp4 := Utilities.GetAutonumber("PROGAER\'"+LRTrim(gAzienda)+"'",0,15) */
              nProgImp4 = CPLib.Round(Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PROGAER\\'"+CPLib.LRTrim(gAzienda)+"'",0,15),0);
              /* cID := LibreriaMit.UniqueId() */
              cID = LibreriaMit.UniqueId();
              // * --- Insert into aerighe from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("aerighe");
              m_cPhName = m_Ctx.GetPhName("aerighe");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aerighe")+" (";
              m_cSql = m_cSql+GetFieldsName_05EAF200(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_numriga,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQLNull((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(nProgImp4,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(cID,"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("aerighe")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aerighe",true);
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
            } // End If
            /* ElseIf LRTrim(qbe_dettrapvgi->TIPO)='L' or LRTrim(qbe_dettrapvgi->TIPO)='P' */
          } else if (CPLib.eqr(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("TIPO")),"L") || CPLib.eqr(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("TIPO")),"P")) {
            /* If w_f_ricaui='G' */
            if (CPLib.eqr(w_f_ricaui,"G")) {
              /* xRiga := 0 */
              xRiga = CPLib.Round(0,0);
              // * --- Read from joginfo
              m_cServer = m_Ctx.GetServer("joginfo");
              m_cPhName = m_Ctx.GetPhName("joginfo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"C",25,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)));
              m_cSql = m_cSql+" and CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"C",16,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))));
              if (m_Ctx.IsSharedTemp("joginfo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xRiga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on joginfo into routine arrt_import_fileae_xls returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xRiga = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If xRiga = 0 */
              if (CPLib.eqr(xRiga,0)) {
                // * --- Insert into joginfo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("joginfo");
                m_cPhName = m_Ctx.GetPhName("joginfo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"joginfo")+" (";
                m_cSql = m_cSql+GetFieldsName_07CAD8E8(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_numriga,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_qbe_dettrapvgi.GetString("TIPO"),"L")?"01":"05"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("joginfo")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"joginfo",true);
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
              } // End If
            } else { // Else
              /* xRiga := 0 */
              xRiga = CPLib.Round(0,0);
              // * --- Read from soginfo
              m_cServer = m_Ctx.GetServer("soginfo");
              m_cPhName = m_Ctx.GetPhName("soginfo");
              m_cSql = "";
              m_cSql = m_cSql+"RAPCOL="+CPSql.SQLValueAdapter(CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"C",25,0,m_cServer),m_cServer,( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)));
              m_cSql = m_cSql+" and CODSOG="+CPSql.SQLValueAdapter(CPLib.ToSQL((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"C",16,0,m_cServer),m_cServer,(CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))));
              if (m_Ctx.IsSharedTemp("soginfo")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("CPROWNUM",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                xRiga = CPLib.Round(Read_Cursor.GetDouble("CPROWNUM"),0);
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on soginfo into routine arrt_import_fileae_xls returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                xRiga = 0;
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
              /* If xRiga = 0 */
              if (CPLib.eqr(xRiga,0)) {
                // * --- Insert into soginfo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("soginfo");
                m_cPhName = m_Ctx.GetPhName("soginfo");
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.InsertIntoStatement(m_Ctx,"soginfo")+" (";
                m_cSql = m_cSql+GetFieldsName_05F9F970(m_Ctx);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(_numriga,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull((CPLib.Empty(CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC")))?CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("PIVA")):CPLib.LRTrim(Cursor_qbe_dettrapvgi.GetString("CODFISC"))),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQLNull((CPLib.eqr(Cursor_qbe_dettrapvgi.GetString("TIPO"),"L")?"01":"05"),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(( ! (CPLib.Empty(w_prefrap))?CPLib.LRTrim(w_prefrap)+"-"+CPLib.LRTrim(cRapporto):CPLib.LRTrim(cRapporto)),"?",0,0,m_cServer)+", ";
                if (m_Ctx.IsSharedTemp("soginfo")) {
                  m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
                }
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"soginfo",true);
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
              } // End If
            } // End If
          } // End If
          /* _numriga := _numriga + 1 */
          _numriga = CPLib.Round(_numriga+1,0);
          Cursor_qbe_dettrapvgi.Next();
        }
        m_cConnectivityError = Cursor_qbe_dettrapvgi.ErrorMessage();
        Cursor_qbe_dettrapvgi.Close();
        // * --- End Select
        Cursor_qbe_listrapvgi.Next();
      }
      m_cConnectivityError = Cursor_qbe_listrapvgi.ErrorMessage();
      Cursor_qbe_listrapvgi.Close();
      // * --- End Select
    } finally {
      try {
        if (Cursor_qbe_listrapvgi!=null)
          Cursor_qbe_listrapvgi.Close();
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
        if (Cursor_qbe_dettrapvgi!=null)
          Cursor_qbe_dettrapvgi.Close();
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
      m_Caller.SetString("msgproc","M",10,0,w_msgproc);
      m_Caller.SetString("prefrap","C",5,0,w_prefrap);
      m_Caller.SetString("codval","C",3,0,w_codval);
      m_Caller.SetString("f_ricaui","C",1,0,w_f_ricaui);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_import_fileae_xlsR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_import_fileae_xlsR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_msgproc = m_Caller.GetString("msgproc","M",10,0);
    w_prefrap = m_Caller.GetString("prefrap","C",5,0);
    w_codval = m_Caller.GetString("codval","C",3,0);
    w_f_ricaui = m_Caller.GetString("f_ricaui","C",1,0);
    nomefile = CPLib.Space(30);
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
    cRapporto = CPLib.Space(25);
    xRapporto = CPLib.Space(25);
    _nrighe = 0;
    _tiprap = CPLib.Space(1);
    nProgImp = 0;
    nProgImp1 = 0;
    nProgImp2 = 0;
    nProgImp3 = 0;
    nProgImp4 = 0;
    cID = CPLib.Space(10);
    _numriga = 0;
    xRiga = 0;
    _desrap = CPLib.Space(50);
    _connes = CPLib.Space(16);
    _xconnes = CPLib.Space(16);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_listrapvgi,qbe_dettrapvgi,
  public static final String m_cVQRList = ",qbe_listrapvgi,qbe_dettrapvgi,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0735D8F8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"PIVA,";
    if (p_Ctx.IsSharedTemp("tmp_vegagest")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_vegagest",true);
    return p_cSql;
  }
  protected static String GetFieldsName_073D2380(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"PIVA,";
    if (p_Ctx.IsSharedTemp("tmp_vegagest")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_vegagest",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0750C6E8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"PARTIVA,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"CAP,";
    if (p_Ctx.IsSharedTemp("personbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_06305EC0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"PROGIMPORT,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"CODCAB,";
    p_cSql = p_cSql+"DOMICILIO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"SOTGRUP,";
    p_cSql = p_cSql+"RAMOGRUP,";
    p_cSql = p_cSql+"SETTSINT,";
    p_cSql = p_cSql+"TIPODOC,";
    p_cSql = p_cSql+"NUMDOCUM,";
    p_cSql = p_cSql+"AUTRILASC,";
    p_cSql = p_cSql+"DATARILASC,";
    p_cSql = p_cSql+"DESCCIT,";
    p_cSql = p_cSql+"PROVINCIA,";
    p_cSql = p_cSql+"PAESE,";
    p_cSql = p_cSql+"CAP,";
    p_cSql = p_cSql+"NASCOMUN,";
    p_cSql = p_cSql+"NASSTATO,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"TIPINTER,";
    if (p_Ctx.IsSharedTemp("personbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E17D10(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    if (p_Ctx.IsSharedTemp("jnarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07C93610(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"FLAGLIRE,";
    p_cSql = p_cSql+"VALUTA,";
    p_cSql = p_cSql+"PRGIMPRAP,";
    if (p_Ctx.IsSharedTemp("jnarapbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jnarapbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_061FA5F8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RIFANA,";
    p_cSql = p_cSql+"PROGAET,";
    p_cSql = p_cSql+"FLGIMP,";
    if (p_Ctx.IsSharedTemp("aetesta")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aetesta",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0646D2B0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    if (p_Ctx.IsSharedTemp("jntestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"jntestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05E690B8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CODINTER,";
    p_cSql = p_cSql+"STATOREG,";
    p_cSql = p_cSql+"PRGIMPSOG,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CPROWNUM,";
    if (p_Ctx.IsSharedTemp("intestbo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"intestbo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05EAF200(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CONNESINT,";
    p_cSql = p_cSql+"IDRIF,";
    p_cSql = p_cSql+"PROGAER,";
    p_cSql = p_cSql+"IDBASE,";
    if (p_Ctx.IsSharedTemp("aerighe")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aerighe",true);
    return p_cSql;
  }
  protected static String GetFieldsName_07CAD8E8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("joginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"joginfo",true);
    return p_cSql;
  }
  protected static String GetFieldsName_05F9F970(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDFILEBO,";
    p_cSql = p_cSql+"CPROWNUM,";
    p_cSql = p_cSql+"CODSOG,";
    p_cSql = p_cSql+"LEGAME,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"RAPCOL,";
    if (p_Ctx.IsSharedTemp("soginfo")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"soginfo",true);
    return p_cSql;
  }
}
