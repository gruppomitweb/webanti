// * --- Area Manuale = BO - Header
// * --- arrt_estrai_mitfisc
import java.util.*;
// * --- Fine Area Manuale
public class arrt_estrai_mitfiscR implements CallerWithObjs {
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
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_sogopebo;
  public String m_cServer_sogopebo;
  public String m_cPhName_clientiope;
  public String m_cServer_clientiope;
  public String m_cPhName_intestbo;
  public String m_cServer_intestbo;
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
  public double w_annofisc;
  public double pImporto;
  public double _max;
  public double _min;
  public double _tot;
  public double _cicli;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public String _dataini;
  public String _datafin;
  public double _mono;
  public String _rapage;
  public String cOnlyNomeFile;
  public String cNomeFile;
  public String cNomeFileZip;
  public String fhand;
  public String _riga;
  public String _ucode;
  public String _file1;
  public String _file2;
  public double _nEse;
  public double _nCli;
  public java.sql.Date _dini;
  public MemoryCursor_personbo mcArchpers;
  public MemoryCursorRow_personbo rowArchpers;
  public MemoryCursor_operazbo mcArchope;
  public MemoryCursorRow_operazbo rowArchope;
  public MemoryCursor_sogopebo mcSogopebo;
  public MemoryCursorRow_sogopebo rowSogopebo;
  public MemoryCursor_clientiope mcClienti;
  public MemoryCursorRow_clientiope rowClienti;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  public String gPathDoc;
  public String gUrlApp;
  public String gIntemediario;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_estrai_mitfisc
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_estrai_mitfiscR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_estrai_mitfisc",m_Caller);
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_sogopebo = p_ContextObject.GetPhName("sogopebo");
    if (m_cPhName_sogopebo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sogopebo = m_cPhName_sogopebo+" "+m_Ctx.GetWritePhName("sogopebo");
    }
    m_cServer_sogopebo = p_ContextObject.GetServer("sogopebo");
    m_cPhName_clientiope = p_ContextObject.GetPhName("clientiope");
    if (m_cPhName_clientiope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_clientiope = m_cPhName_clientiope+" "+m_Ctx.GetWritePhName("clientiope");
    }
    m_cServer_clientiope = p_ContextObject.GetServer("clientiope");
    m_cPhName_intestbo = p_ContextObject.GetPhName("intestbo");
    if (m_cPhName_intestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intestbo = m_cPhName_intestbo+" "+m_Ctx.GetWritePhName("intestbo");
    }
    m_cServer_intestbo = p_ContextObject.GetServer("intestbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("annofisc",p_cVarName)) {
      return w_annofisc;
    }
    if (CPLib.eqr("pImporto",p_cVarName)) {
      return pImporto;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
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
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_nEse",p_cVarName)) {
      return _nEse;
    }
    if (CPLib.eqr("_nCli",p_cVarName)) {
      return _nCli;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_estrai_mitfisc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("_dataini",p_cVarName)) {
      return _dataini;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      return _datafin;
    }
    if (CPLib.eqr("_rapage",p_cVarName)) {
      return _rapage;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      return _ucode;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      return _file1;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_dini",p_cVarName)) {
      return _dini;
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
    if (CPLib.eqr("mcArchpers",p_cVarName)) {
      return mcArchpers;
    }
    if (CPLib.eqr("mcArchope",p_cVarName)) {
      return mcArchope;
    }
    if (CPLib.eqr("mcSogopebo",p_cVarName)) {
      return mcSogopebo;
    }
    if (CPLib.eqr("mcClienti",p_cVarName)) {
      return mcClienti;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowArchpers",p_cVarName)) {
      return rowArchpers;
    }
    if (CPLib.eqr("rowArchope",p_cVarName)) {
      return rowArchope;
    }
    if (CPLib.eqr("rowSogopebo",p_cVarName)) {
      return rowSogopebo;
    }
    if (CPLib.eqr("rowClienti",p_cVarName)) {
      return rowClienti;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("annofisc",p_cVarName)) {
      w_annofisc = value;
      return;
    }
    if (CPLib.eqr("pImporto",p_cVarName)) {
      pImporto = value;
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
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
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
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_nEse",p_cVarName)) {
      _nEse = value;
      return;
    }
    if (CPLib.eqr("_nCli",p_cVarName)) {
      _nCli = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("_dataini",p_cVarName)) {
      _dataini = value;
      return;
    }
    if (CPLib.eqr("_datafin",p_cVarName)) {
      _datafin = value;
      return;
    }
    if (CPLib.eqr("_rapage",p_cVarName)) {
      _rapage = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_ucode",p_cVarName)) {
      _ucode = value;
      return;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      _file1 = value;
      return;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      _file2 = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      gUrlApp = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_dini",p_cVarName)) {
      _dini = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowArchpers",p_cVarName)) {
      rowArchpers = (MemoryCursorRow_personbo)value;
      return;
    }
    if (CPLib.eqr("rowArchope",p_cVarName)) {
      rowArchope = (MemoryCursorRow_operazbo)value;
      return;
    }
    if (CPLib.eqr("rowSogopebo",p_cVarName)) {
      rowSogopebo = (MemoryCursorRow_sogopebo)value;
      return;
    }
    if (CPLib.eqr("rowClienti",p_cVarName)) {
      rowClienti = (MemoryCursorRow_clientiope)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcArchpers",p_cVarName)) {
      mcArchpers = (MemoryCursor_personbo)value;
      return;
    }
    if (CPLib.eqr("mcArchope",p_cVarName)) {
      mcArchope = (MemoryCursor_operazbo)value;
      return;
    }
    if (CPLib.eqr("mcSogopebo",p_cVarName)) {
      mcSogopebo = (MemoryCursor_sogopebo)value;
      return;
    }
    if (CPLib.eqr("mcClienti",p_cVarName)) {
      mcClienti = (MemoryCursor_clientiope)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_mitfisc_ope_glob=null;
    CPResultSet Cursor_qbe_mitfisc_ope_dett=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intestbo=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Cursor_sogopebo=null;
    CPResultSet Cursor_clientiope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pTipo Char(1) */
      /* w_annofisc Numeric(4, 0) */
      /* pImporto Numeric(12, 2) */
      /* _max Numeric(15, 0) */
      /* _min Numeric(15, 0) */
      /* _tot Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _contacicli Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* _top Numeric(15, 0) */
      /* _dataini Char(8) */
      /* _datafin Char(8) */
      /* _mono Numeric(1, 0) */
      /* _rapage Char(50) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* fhand Char(10) */
      /* _riga Memo */
      /* _ucode Char(10) */
      /* _file1 Char(30) */
      /* _file2 Char(30) */
      /* _nEse Numeric(10, 0) */
      /* _nCli Numeric(10, 0) */
      /* _dini Date */
      /* mcArchpers MemoryCursor(personbo) */
      /* rowArchpers Row(personbo) */
      /* mcArchope MemoryCursor(operazbo) */
      /* rowArchope Row(operazbo) */
      /* mcSogopebo MemoryCursor(sogopebo) */
      /* rowSogopebo Row(sogopebo) */
      /* mcClienti MemoryCursor(clientiope) */
      /* rowClienti Row(clientiope) */
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gUrlApp Char(80) // URL Applicazione */
      /* gIntemediario Char(11) // Intermediario */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _dataini := Str(w_annofisc,4,0)+"0101" */
      _dataini = CPLib.Str(w_annofisc,4,0)+"0101";
      /* _datafin := Str(w_annofisc,4,0)+"1231" */
      _datafin = CPLib.Str(w_annofisc,4,0)+"1231";
      /* _dini := CharToDate(_dataini) */
      _dini = CPLib.CharToDate(_dataini);
      // * --- Select from qbe_mitfisc_ope_glob
      SPBridge.HMCaller _h00000032;
      _h00000032 = new SPBridge.HMCaller();
      _h00000032.Set("m_cVQRList",m_cVQRList);
      _h00000032.Set("_datini",_dataini);
      _h00000032.Set("_datfin",_datafin);
      _h00000032.Set("pImporto",pImporto);
      if (Cursor_qbe_mitfisc_ope_glob!=null)
        Cursor_qbe_mitfisc_ope_glob.Close();
      Cursor_qbe_mitfisc_ope_glob = new VQRHolder("qbe_mitfisc_ope_glob",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000032,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_mitfisc_ope_glob.Eof())) {
        /* _min := qbe_mitfisc_ope_glob->MINPROGOPX */
        _min = CPLib.Round(Cursor_qbe_mitfisc_ope_glob.GetDouble("MINPROGOPX"),0);
        /* _max := qbe_mitfisc_ope_glob->MAXPROGOPX */
        _max = CPLib.Round(Cursor_qbe_mitfisc_ope_glob.GetDouble("MAXPROGOPX"),0);
        /* _tot := qbe_mitfisc_ope_glob->TOTPROGOPX */
        _tot = CPLib.Round(Cursor_qbe_mitfisc_ope_glob.GetDouble("TOTPROGOPX"),0);
        Cursor_qbe_mitfisc_ope_glob.Next();
      }
      m_cConnectivityError = Cursor_qbe_mitfisc_ope_glob.ErrorMessage();
      Cursor_qbe_mitfisc_ope_glob.Close();
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
        /* _cicli := iif(Mod(_max,1000) <> 0,Int(_max/1000) + 1,Int(_max/1000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,1000),0)?CPLib.Int(_max/1000)+1:CPLib.Int(_max/1000)),0);
      } // End If
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
      gMsgImp = "Lettura informazioni in corso ...";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* _nEse := 0 */
      _nEse = CPLib.Round(0,0);
      /* _nCli := 0 */
      _nCli = CPLib.Round(0,0);
      /* While _contacicli<=_cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* _bottom := ((_contacicli -1 ) * 5000) + 1 */
          _bottom = CPLib.Round(((_contacicli-1)*5000)+1,0);
          /* _top := _contacicli * 5000 */
          _top = CPLib.Round(_contacicli*5000,0);
        } // End If
        /* gMsgImp := 'Lettura informazioni in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura informazioni in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          // * --- Select from qbe_mitfisc_ope_dett
          SPBridge.HMCaller _h00000048;
          _h00000048 = new SPBridge.HMCaller();
          _h00000048.Set("m_cVQRList",m_cVQRList);
          _h00000048.Set("_datini",_dataini);
          _h00000048.Set("_datfin",_datafin);
          _h00000048.Set("_top",_top);
          _h00000048.Set("_bottom",_bottom);
          _h00000048.Set("pImporto",pImporto);
          if (Cursor_qbe_mitfisc_ope_dett!=null)
            Cursor_qbe_mitfisc_ope_dett.Close();
          Cursor_qbe_mitfisc_ope_dett = new VQRHolder("qbe_mitfisc_ope_dett",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000048,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_mitfisc_ope_dett.Eof())) {
            /* gMsgImp := 'Lettura operazione ' + qbe_mitfisc_ope_dett->NUMPROG // Messaggio Import */
            gMsgImp = "Lettura operazione "+Cursor_qbe_mitfisc_ope_dett.GetString("NUMPROG");
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _rapage := '' */
            _rapage = "";
            // * --- Read from aetesta
            m_cServer = m_Ctx.GetServer("aetesta");
            m_cPhName = m_Ctx.GetPhName("aetesta");
            m_cSql = "";
            m_cSql = m_cSql+"RAPPORTO="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_mitfisc_ope_dett.GetString("RAPPORTO"),"C",25,0,m_cServer),m_cServer,Cursor_qbe_mitfisc_ope_dett.GetString("RAPPORTO"));
            if (m_Ctx.IsSharedTemp("aetesta")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("UNIQUECODE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _rapage = Read_Cursor.GetString("UNIQUECODE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on aetesta into routine arrt_estrai_mitfisc returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _rapage = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* _ucode := LibreriaMit.UniqueId() */
            _ucode = LibreriaMit.UniqueId();
            /* mcArchope.AppendBlank() */
            mcArchope.AppendBlank();
            /* mcArchope.DATAOPE := qbe_mitfisc_ope_dett->DATAOPE */
            mcArchope.row.DATAOPE = Cursor_qbe_mitfisc_ope_dett.GetDate("DATAOPE");
            /* mcArchope.FLAGCONT := qbe_mitfisc_ope_dett->FLAGCONT */
            mcArchope.row.FLAGCONT = Cursor_qbe_mitfisc_ope_dett.GetString("FLAGCONT");
            /* mcArchope.CODANA := qbe_mitfisc_ope_dett->CODANA */
            mcArchope.row.CODANA = Cursor_qbe_mitfisc_ope_dett.GetString("CODANA");
            /* mcArchope.CODVOC := qbe_mitfisc_ope_dett->CODVOC */
            mcArchope.row.CODVOC = Cursor_qbe_mitfisc_ope_dett.GetString("CODVOC");
            /* mcArchope.TIPOINT2 := qbe_mitfisc_ope_dett->TIPOINT2 */
            mcArchope.row.TIPOINT2 = Cursor_qbe_mitfisc_ope_dett.GetString("TIPOINT2");
            /* mcArchope.CODINT2 := qbe_mitfisc_ope_dett->CODINT2 */
            mcArchope.row.CODINT2 = Cursor_qbe_mitfisc_ope_dett.GetString("CODINT2");
            /* mcArchope.PAESE := qbe_mitfisc_ope_dett->PAESE */
            mcArchope.row.PAESE = Cursor_qbe_mitfisc_ope_dett.GetString("PAESE");
            /* mcArchope.RAPPORTO := iif(Empty(_rapage),qbe_mitfisc_ope_dett->RAPPORTO,_rapage) */
            mcArchope.row.RAPPORTO = (CPLib.Empty(_rapage)?Cursor_qbe_mitfisc_ope_dett.GetString("RAPPORTO"):_rapage);
            /* mcArchope.FLAGRAP := qbe_mitfisc_ope_dett->FLAGRAP */
            mcArchope.row.FLAGRAP = Cursor_qbe_mitfisc_ope_dett.GetString("FLAGRAP");
            /* mcArchope.TIPOLEG := qbe_mitfisc_ope_dett->TIPOLEG */
            mcArchope.row.TIPOLEG = Cursor_qbe_mitfisc_ope_dett.GetString("TIPOLEG");
            /* mcArchope.DATAREG := qbe_mitfisc_ope_dett->DATAREG */
            mcArchope.row.DATAREG = Cursor_qbe_mitfisc_ope_dett.GetDate("DATAREG");
            /* mcArchope.FLAGLIRE := qbe_mitfisc_ope_dett->FLAGLIRE */
            mcArchope.row.FLAGLIRE = Cursor_qbe_mitfisc_ope_dett.GetString("FLAGLIRE");
            /* mcArchope.VALUTA := qbe_mitfisc_ope_dett->VALUTA */
            mcArchope.row.VALUTA = Cursor_qbe_mitfisc_ope_dett.GetString("VALUTA");
            /* mcArchope.SEGNO := qbe_mitfisc_ope_dett->SEGNO */
            mcArchope.row.SEGNO = Cursor_qbe_mitfisc_ope_dett.GetString("SEGNO");
            /* mcArchope.TOTLIRE := qbe_mitfisc_ope_dett->TOTLIRE */
            mcArchope.row.TOTLIRE = Cursor_qbe_mitfisc_ope_dett.GetDouble("TOTLIRE");
            /* mcArchope.TOTCONT := qbe_mitfisc_ope_dett->TOTCONT */
            mcArchope.row.TOTCONT = Cursor_qbe_mitfisc_ope_dett.GetDouble("TOTCONT");
            /* mcArchope.CONNESCLI := qbe_mitfisc_ope_dett->CONNESCLI */
            mcArchope.row.CONNESCLI = Cursor_qbe_mitfisc_ope_dett.GetString("CONNESCLI");
            /* mcArchope.CONNESOPER := qbe_mitfisc_ope_dett->CONNESOPER */
            mcArchope.row.CONNESOPER = Cursor_qbe_mitfisc_ope_dett.GetString("CONNESOPER");
            /* mcArchope.CAMBIO := qbe_mitfisc_ope_dett->CAMBIO */
            mcArchope.row.CAMBIO = Cursor_qbe_mitfisc_ope_dett.GetDouble("CAMBIO");
            /* mcArchope.NUMPROG := qbe_mitfisc_ope_dett->NUMPROG */
            mcArchope.row.NUMPROG = Cursor_qbe_mitfisc_ope_dett.GetString("NUMPROG");
            /* mcArchope.TIPOOPRAP := qbe_mitfisc_ope_dett->TIPOOPRAP */
            mcArchope.row.TIPOOPRAP = Cursor_qbe_mitfisc_ope_dett.GetString("TIPOOPRAP");
            /* mcArchope.CODINTER := qbe_mitfisc_ope_dett->CODINTER */
            mcArchope.row.CODINTER = Cursor_qbe_mitfisc_ope_dett.GetString("CODINTER");
            /* mcArchope.FLAGFRAZ := qbe_mitfisc_ope_dett->FLAGFRAZ */
            mcArchope.row.FLAGFRAZ = Cursor_qbe_mitfisc_ope_dett.GetString("FLAGFRAZ");
            /* mcArchope.UNIQUECODE := _ucode */
            mcArchope.row.UNIQUECODE = _ucode;
            /* mcArchope.RIFIMP := Right(qbe_mitfisc_ope_dett->RIFIMP,9) */
            mcArchope.row.RIFIMP = CPLib.Right(Cursor_qbe_mitfisc_ope_dett.GetString("RIFIMP"),9);
            /* mcArchope.ZCPARTE := iif(Empty(qbe_mitfisc_ope_dett->CODINT2),LRTrim(qbe_mitfisc_ope_dett->DESCINTER)+" "+LRTrim(qbe_mitfisc_ope_dett->DESC2),qbe_mitfisc_ope_dett->ZCPARTE) */
            mcArchope.row.ZCPARTE = (CPLib.Empty(Cursor_qbe_mitfisc_ope_dett.GetString("CODINT2"))?CPLib.LRTrim(Cursor_qbe_mitfisc_ope_dett.GetString("DESCINTER"))+" "+CPLib.LRTrim(Cursor_qbe_mitfisc_ope_dett.GetString("DESC2")):Cursor_qbe_mitfisc_ope_dett.GetString("ZCPARTE"));
            /* mcArchope.DATAIMP := Date() */
            mcArchope.row.DATAIMP = CPLib.Date();
            /* mcArchope.IDEREG := Left(qbe_mitfisc_ope_dett->IDEREG,8)+"O"+Substr(qbe_mitfisc_ope_dett->IDEREG,10,11) */
            mcArchope.row.IDEREG = CPLib.Left(Cursor_qbe_mitfisc_ope_dett.GetString("IDEREG"),8)+"O"+CPLib.Substr(Cursor_qbe_mitfisc_ope_dett.GetString("IDEREG"),10,11);
            /* mcArchope.SaveRow() */
            mcArchope.SaveRow();
            /* If not(Empty(LRTrim(qbe_mitfisc_ope_dett->RAPPORTO))) and Empty(LRTrim(qbe_mitfisc_ope_dett->CONNESCLI)) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_mitfisc_ope_dett.GetString("RAPPORTO")))) && CPLib.Empty(CPLib.LRTrim(Cursor_qbe_mitfisc_ope_dett.GetString("CONNESCLI")))) {
              // * --- Select from intestbo
              m_cServer = m_Ctx.GetServer("intestbo");
              m_cPhName = m_Ctx.GetPhName("intestbo");
              if (Cursor_intestbo!=null)
                Cursor_intestbo.Close();
              Cursor_intestbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"RAPPORTO="+CPLib.ToSQL(Cursor_qbe_mitfisc_ope_dett.GetString("RAPPORTO"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("intestbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_intestbo.Eof())) {
                /* If Empty(intestbo->DATAFINE) or intestbo->DATAFINE >= _dini */
                if (CPLib.Empty(Cursor_intestbo.GetDate("DATAFINE")) || CPLib.ge(Cursor_intestbo.GetDate("DATAFINE"),_dini)) {
                  // * --- Select from personbo
                  m_cServer = m_Ctx.GetServer("personbo");
                  m_cPhName = m_Ctx.GetPhName("personbo");
                  if (Cursor_personbo!=null)
                    Cursor_personbo.Close();
                  Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_intestbo.GetString("CODINTER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                  while ( ! (Cursor_personbo.Eof())) {
                    /* If not(mcArchpers.GoToKey(personbo->CONNES)) */
                    if ( ! (mcArchpers.GoToKey(Cursor_personbo.GetString("CONNES")))) {
                      /* mcArchpers.AppendWithKey(personbo->CONNES) */
                      mcArchpers.AppendWithKey(Cursor_personbo.GetString("CONNES"));
                      /* mcArchpers.CODCAB := iif(Empty(personbo->CODCAB),Space(6),personbo->CODCAB) */
                      mcArchpers.row.CODCAB = (CPLib.Empty(Cursor_personbo.GetString("CODCAB"))?CPLib.Space(6):Cursor_personbo.GetString("CODCAB"));
                      /* mcArchpers.RAGSOC := personbo->RAGSOC */
                      mcArchpers.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                      /* mcArchpers.DOMICILIO := personbo->DOMICILIO */
                      mcArchpers.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                      /* mcArchpers.CODFISC := personbo->CODFISC */
                      mcArchpers.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                      /* mcArchpers.DATANASC := personbo->DATANASC */
                      mcArchpers.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                      /* mcArchpers.NASCOMUN := personbo->NASCOMUN */
                      mcArchpers.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                      /* mcArchpers.NASSTATO := personbo->NASSTATO */
                      mcArchpers.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                      /* mcArchpers.DESCCIT := personbo->DESCCIT */
                      mcArchpers.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                      /* mcArchpers.PROVINCIA := personbo->PROVINCIA */
                      mcArchpers.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                      /* mcArchpers.PAESE := personbo->PAESE */
                      mcArchpers.row.PAESE = Cursor_personbo.GetString("PAESE");
                      /* mcArchpers.CAP := personbo->CAP */
                      mcArchpers.row.CAP = Cursor_personbo.GetString("CAP");
                      /* mcArchpers.PARTIVA := personbo->PARTIVA */
                      mcArchpers.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
                      /* mcArchpers.SESSO := personbo->SESSO */
                      mcArchpers.row.SESSO = Cursor_personbo.GetString("SESSO");
                      /* mcArchpers.COGNOME := personbo->COGNOME */
                      mcArchpers.row.COGNOME = Cursor_personbo.GetString("COGNOME");
                      /* mcArchpers.NOME := personbo->NOME */
                      mcArchpers.row.NOME = Cursor_personbo.GetString("NOME");
                      /* mcArchpers.TIPINTER := personbo->TIPINTER */
                      mcArchpers.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                      /* mcArchpers.CFESTERO := personbo->CFESTERO */
                      mcArchpers.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                      /* mcArchpers.CONNES := personbo->CONNES */
                      mcArchpers.row.CONNES = Cursor_personbo.GetString("CONNES");
                      /* mcArchpers.SaveRow() */
                      mcArchpers.SaveRow();
                    } // End If
                    Cursor_personbo.Next();
                  }
                  m_cConnectivityError = Cursor_personbo.ErrorMessage();
                  Cursor_personbo.Close();
                  // * --- End Select
                } // End If
                Cursor_intestbo.Next();
              }
              m_cConnectivityError = Cursor_intestbo.ErrorMessage();
              Cursor_intestbo.Close();
              // * --- End Select
            } // End If
            /* If not(Empty(LRTrim(qbe_mitfisc_ope_dett->CONNESCLI))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_mitfisc_ope_dett.GetString("CONNESCLI"))))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_mitfisc_ope_dett.GetString("CONNESCLI"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* If not(mcArchpers.GoToKey(personbo->CONNES)) */
                if ( ! (mcArchpers.GoToKey(Cursor_personbo.GetString("CONNES")))) {
                  /* mcArchpers.AppendWithKey(personbo->CONNES) */
                  mcArchpers.AppendWithKey(Cursor_personbo.GetString("CONNES"));
                  /* mcArchpers.CODCAB := iif(Empty(personbo->CODCAB),Space(6),personbo->CODCAB) */
                  mcArchpers.row.CODCAB = (CPLib.Empty(Cursor_personbo.GetString("CODCAB"))?CPLib.Space(6):Cursor_personbo.GetString("CODCAB"));
                  /* mcArchpers.RAGSOC := personbo->RAGSOC */
                  mcArchpers.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  /* mcArchpers.DOMICILIO := personbo->DOMICILIO */
                  mcArchpers.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  /* mcArchpers.CODFISC := personbo->CODFISC */
                  mcArchpers.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  /* mcArchpers.DATANASC := personbo->DATANASC */
                  mcArchpers.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  /* mcArchpers.NASCOMUN := personbo->NASCOMUN */
                  mcArchpers.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  /* mcArchpers.NASSTATO := personbo->NASSTATO */
                  mcArchpers.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  /* mcArchpers.DESCCIT := personbo->DESCCIT */
                  mcArchpers.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  /* mcArchpers.PROVINCIA := personbo->PROVINCIA */
                  mcArchpers.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  /* mcArchpers.PAESE := personbo->PAESE */
                  mcArchpers.row.PAESE = Cursor_personbo.GetString("PAESE");
                  /* mcArchpers.CAP := personbo->CAP */
                  mcArchpers.row.CAP = Cursor_personbo.GetString("CAP");
                  /* mcArchpers.PARTIVA := personbo->PARTIVA */
                  mcArchpers.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
                  /* mcArchpers.SESSO := personbo->SESSO */
                  mcArchpers.row.SESSO = Cursor_personbo.GetString("SESSO");
                  /* mcArchpers.COGNOME := personbo->COGNOME */
                  mcArchpers.row.COGNOME = Cursor_personbo.GetString("COGNOME");
                  /* mcArchpers.NOME := personbo->NOME */
                  mcArchpers.row.NOME = Cursor_personbo.GetString("NOME");
                  /* mcArchpers.TIPINTER := personbo->TIPINTER */
                  mcArchpers.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  /* mcArchpers.CFESTERO := personbo->CFESTERO */
                  mcArchpers.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                  /* mcArchpers.CONNES := personbo->CONNES */
                  mcArchpers.row.CONNES = Cursor_personbo.GetString("CONNES");
                  /* mcArchpers.SaveRow() */
                  mcArchpers.SaveRow();
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            /* If not(Empty(LRTrim(qbe_mitfisc_ope_dett->CONNESOPER))) */
            if ( ! (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_mitfisc_ope_dett.GetString("CONNESOPER"))))) {
              // * --- Select from personbo
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              if (Cursor_personbo!=null)
                Cursor_personbo.Close();
              Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_mitfisc_ope_dett.GetString("CONNESOPER"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
              while ( ! (Cursor_personbo.Eof())) {
                /* If not(mcArchpers.GoToKey(personbo->CONNES)) */
                if ( ! (mcArchpers.GoToKey(Cursor_personbo.GetString("CONNES")))) {
                  /* mcArchpers.AppendWithKey(personbo->CONNES) */
                  mcArchpers.AppendWithKey(Cursor_personbo.GetString("CONNES"));
                  /* mcArchpers.CODCAB := iif(Empty(personbo->CODCAB),Space(6),personbo->CODCAB) */
                  mcArchpers.row.CODCAB = (CPLib.Empty(Cursor_personbo.GetString("CODCAB"))?CPLib.Space(6):Cursor_personbo.GetString("CODCAB"));
                  /* mcArchpers.RAGSOC := personbo->RAGSOC */
                  mcArchpers.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  /* mcArchpers.DOMICILIO := personbo->DOMICILIO */
                  mcArchpers.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  /* mcArchpers.CODFISC := personbo->CODFISC */
                  mcArchpers.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  /* mcArchpers.DATANASC := personbo->DATANASC */
                  mcArchpers.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  /* mcArchpers.NASCOMUN := personbo->NASCOMUN */
                  mcArchpers.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  /* mcArchpers.NASSTATO := personbo->NASSTATO */
                  mcArchpers.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  /* mcArchpers.DESCCIT := personbo->DESCCIT */
                  mcArchpers.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  /* mcArchpers.PROVINCIA := personbo->PROVINCIA */
                  mcArchpers.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  /* mcArchpers.PAESE := personbo->PAESE */
                  mcArchpers.row.PAESE = Cursor_personbo.GetString("PAESE");
                  /* mcArchpers.CAP := personbo->CAP */
                  mcArchpers.row.CAP = Cursor_personbo.GetString("CAP");
                  /* mcArchpers.PARTIVA := personbo->PARTIVA */
                  mcArchpers.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
                  /* mcArchpers.SESSO := personbo->SESSO */
                  mcArchpers.row.SESSO = Cursor_personbo.GetString("SESSO");
                  /* mcArchpers.COGNOME := personbo->COGNOME */
                  mcArchpers.row.COGNOME = Cursor_personbo.GetString("COGNOME");
                  /* mcArchpers.NOME := personbo->NOME */
                  mcArchpers.row.NOME = Cursor_personbo.GetString("NOME");
                  /* mcArchpers.TIPINTER := personbo->TIPINTER */
                  mcArchpers.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  /* mcArchpers.CFESTERO := personbo->CFESTERO */
                  mcArchpers.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                  /* mcArchpers.CONNES := personbo->CONNES */
                  mcArchpers.row.CONNES = Cursor_personbo.GetString("CONNES");
                  /* mcArchpers.SaveRow() */
                  mcArchpers.SaveRow();
                } // End If
                Cursor_personbo.Next();
              }
              m_cConnectivityError = Cursor_personbo.ErrorMessage();
              Cursor_personbo.Close();
              // * --- End Select
            } // End If
            // * --- Select from sogopebo
            m_cServer = m_Ctx.GetServer("sogopebo");
            m_cPhName = m_Ctx.GetPhName("sogopebo");
            if (Cursor_sogopebo!=null)
              Cursor_sogopebo.Close();
            Cursor_sogopebo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_mitfisc_ope_dett.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("sogopebo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_sogopebo.Eof())) {
              /* _nEse := _nEse + 1 */
              _nEse = CPLib.Round(_nEse+1,0);
              /* mcSogopebo.AppendBlank() */
              mcSogopebo.AppendBlank();
              /* mcSogopebo.IDFILEBO := _ucode */
              mcSogopebo.row.IDFILEBO = _ucode;
              /* mcSogopebo.CODSOG := sogopebo->CODSOG */
              mcSogopebo.row.CODSOG = Cursor_sogopebo.GetString("CODSOG");
              /* mcSogopebo.LEGAME := sogopebo->LEGAME */
              mcSogopebo.row.LEGAME = Cursor_sogopebo.GetString("LEGAME");
              /* mcSogopebo.SaveRow() */
              mcSogopebo.SaveRow();
              /* If not(mcArchpers.GoToKey(sogopebo->CODSOG)) */
              if ( ! (mcArchpers.GoToKey(Cursor_sogopebo.GetString("CODSOG")))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_sogopebo.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* mcArchpers.AppendWithKey(personbo->CONNES) */
                  mcArchpers.AppendWithKey(Cursor_personbo.GetString("CONNES"));
                  /* mcArchpers.CODCAB := iif(Empty(personbo->CODCAB),Space(6),personbo->CODCAB) */
                  mcArchpers.row.CODCAB = (CPLib.Empty(Cursor_personbo.GetString("CODCAB"))?CPLib.Space(6):Cursor_personbo.GetString("CODCAB"));
                  /* mcArchpers.RAGSOC := personbo->RAGSOC */
                  mcArchpers.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  /* mcArchpers.DOMICILIO := personbo->DOMICILIO */
                  mcArchpers.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  /* mcArchpers.CODFISC := personbo->CODFISC */
                  mcArchpers.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  /* mcArchpers.DATANASC := personbo->DATANASC */
                  mcArchpers.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  /* mcArchpers.NASCOMUN := personbo->NASCOMUN */
                  mcArchpers.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  /* mcArchpers.NASSTATO := personbo->NASSTATO */
                  mcArchpers.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  /* mcArchpers.DESCCIT := personbo->DESCCIT */
                  mcArchpers.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  /* mcArchpers.PROVINCIA := personbo->PROVINCIA */
                  mcArchpers.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  /* mcArchpers.PAESE := personbo->PAESE */
                  mcArchpers.row.PAESE = Cursor_personbo.GetString("PAESE");
                  /* mcArchpers.CAP := personbo->CAP */
                  mcArchpers.row.CAP = Cursor_personbo.GetString("CAP");
                  /* mcArchpers.PARTIVA := personbo->PARTIVA */
                  mcArchpers.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
                  /* mcArchpers.SESSO := personbo->SESSO */
                  mcArchpers.row.SESSO = Cursor_personbo.GetString("SESSO");
                  /* mcArchpers.COGNOME := personbo->COGNOME */
                  mcArchpers.row.COGNOME = Cursor_personbo.GetString("COGNOME");
                  /* mcArchpers.NOME := personbo->NOME */
                  mcArchpers.row.NOME = Cursor_personbo.GetString("NOME");
                  /* mcArchpers.TIPINTER := personbo->TIPINTER */
                  mcArchpers.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  /* mcArchpers.CFESTERO := personbo->CFESTERO */
                  mcArchpers.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                  /* mcArchpers.CONNES := personbo->CONNES */
                  mcArchpers.row.CONNES = Cursor_personbo.GetString("CONNES");
                  /* mcArchpers.SaveRow() */
                  mcArchpers.SaveRow();
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_sogopebo.Next();
            }
            m_cConnectivityError = Cursor_sogopebo.ErrorMessage();
            Cursor_sogopebo.Close();
            // * --- End Select
            // * --- Select from clientiope
            m_cServer = m_Ctx.GetServer("clientiope");
            m_cPhName = m_Ctx.GetPhName("clientiope");
            if (Cursor_clientiope!=null)
              Cursor_clientiope.Close();
            Cursor_clientiope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"IDFILEBO="+CPLib.ToSQL(Cursor_qbe_mitfisc_ope_dett.GetString("IDBASE"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("clientiope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_clientiope.Eof())) {
              /* _nCli := _nCli + 1 */
              _nCli = CPLib.Round(_nCli+1,0);
              /* mcClienti.AppendBlank() */
              mcClienti.AppendBlank();
              /* mcClienti.IDFILEBO := _ucode */
              mcClienti.row.IDFILEBO = _ucode;
              /* mcClienti.CODSOG := clientiope->CODSOG */
              mcClienti.row.CODSOG = Cursor_clientiope.GetString("CODSOG");
              /* mcClienti.SaveRow() */
              mcClienti.SaveRow();
              /* If not(mcArchpers.GoToKey(clientiope->CODSOG)) */
              if ( ! (mcArchpers.GoToKey(Cursor_clientiope.GetString("CODSOG")))) {
                // * --- Select from personbo
                m_cServer = m_Ctx.GetServer("personbo");
                m_cPhName = m_Ctx.GetPhName("personbo");
                if (Cursor_personbo!=null)
                  Cursor_personbo.Close();
                Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_clientiope.GetString("CODSOG"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
                while ( ! (Cursor_personbo.Eof())) {
                  /* mcArchpers.AppendWithKey(personbo->CONNES) */
                  mcArchpers.AppendWithKey(Cursor_personbo.GetString("CONNES"));
                  /* mcArchpers.CODCAB := iif(Empty(personbo->CODCAB),Space(6),personbo->CODCAB) */
                  mcArchpers.row.CODCAB = (CPLib.Empty(Cursor_personbo.GetString("CODCAB"))?CPLib.Space(6):Cursor_personbo.GetString("CODCAB"));
                  /* mcArchpers.RAGSOC := personbo->RAGSOC */
                  mcArchpers.row.RAGSOC = Cursor_personbo.GetString("RAGSOC");
                  /* mcArchpers.DOMICILIO := personbo->DOMICILIO */
                  mcArchpers.row.DOMICILIO = Cursor_personbo.GetString("DOMICILIO");
                  /* mcArchpers.CODFISC := personbo->CODFISC */
                  mcArchpers.row.CODFISC = Cursor_personbo.GetString("CODFISC");
                  /* mcArchpers.DATANASC := personbo->DATANASC */
                  mcArchpers.row.DATANASC = Cursor_personbo.GetDate("DATANASC");
                  /* mcArchpers.NASCOMUN := personbo->NASCOMUN */
                  mcArchpers.row.NASCOMUN = Cursor_personbo.GetString("NASCOMUN");
                  /* mcArchpers.NASSTATO := personbo->NASSTATO */
                  mcArchpers.row.NASSTATO = Cursor_personbo.GetString("NASSTATO");
                  /* mcArchpers.DESCCIT := personbo->DESCCIT */
                  mcArchpers.row.DESCCIT = Cursor_personbo.GetString("DESCCIT");
                  /* mcArchpers.PROVINCIA := personbo->PROVINCIA */
                  mcArchpers.row.PROVINCIA = Cursor_personbo.GetString("PROVINCIA");
                  /* mcArchpers.PAESE := personbo->PAESE */
                  mcArchpers.row.PAESE = Cursor_personbo.GetString("PAESE");
                  /* mcArchpers.CAP := personbo->CAP */
                  mcArchpers.row.CAP = Cursor_personbo.GetString("CAP");
                  /* mcArchpers.PARTIVA := personbo->PARTIVA */
                  mcArchpers.row.PARTIVA = Cursor_personbo.GetString("PARTIVA");
                  /* mcArchpers.SESSO := personbo->SESSO */
                  mcArchpers.row.SESSO = Cursor_personbo.GetString("SESSO");
                  /* mcArchpers.COGNOME := personbo->COGNOME */
                  mcArchpers.row.COGNOME = Cursor_personbo.GetString("COGNOME");
                  /* mcArchpers.NOME := personbo->NOME */
                  mcArchpers.row.NOME = Cursor_personbo.GetString("NOME");
                  /* mcArchpers.TIPINTER := personbo->TIPINTER */
                  mcArchpers.row.TIPINTER = Cursor_personbo.GetString("TIPINTER");
                  /* mcArchpers.CFESTERO := personbo->CFESTERO */
                  mcArchpers.row.CFESTERO = Cursor_personbo.GetDouble("CFESTERO");
                  /* mcArchpers.CONNES := personbo->CONNES */
                  mcArchpers.row.CONNES = Cursor_personbo.GetString("CONNES");
                  /* mcArchpers.SaveRow() */
                  mcArchpers.SaveRow();
                  Cursor_personbo.Next();
                }
                m_cConnectivityError = Cursor_personbo.ErrorMessage();
                Cursor_personbo.Close();
                // * --- End Select
              } // End If
              Cursor_clientiope.Next();
            }
            m_cConnectivityError = Cursor_clientiope.ErrorMessage();
            Cursor_clientiope.Close();
            // * --- End Select
            Cursor_qbe_mitfisc_ope_dett.Next();
          }
          m_cConnectivityError = Cursor_qbe_mitfisc_ope_dett.ErrorMessage();
          Cursor_qbe_mitfisc_ope_dett.Close();
          // * --- End Select
        } else { // Else
          /* gMsgImp := 'Lettura informazioni in corso ...' // Messaggio Import */
          gMsgImp = "Lettura informazioni in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
      /* If pTipo='S' */
      if (CPLib.eqr(pTipo,"S")) {
        /* Exec "Prepara appoggio per stampa errori" Page 4:Page_4 */
        Page_4();
        /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(cNomeFileZip) */
        Forward f;
        f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(cNomeFileZip),false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } else { // Else
        /* Exec "Crea i file di testo" Page 3:Page_3 */
        Page_3();
        /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(cNomeFileZip) */
        Forward f;
        f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(cNomeFileZip),false,this,Forward.NoStatus,true);
        f.SetParameter("m_cParameterSequence", "");
        f.SetParameter("m_cMode","hyperlink");
        throw f;
      } // End If
    } finally {
      try {
        if (Cursor_qbe_mitfisc_ope_glob!=null)
          Cursor_qbe_mitfisc_ope_glob.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_mitfisc_ope_dett!=null)
          Cursor_qbe_mitfisc_ope_dett.Close();
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
        if (Cursor_intestbo!=null)
          Cursor_intestbo.Close();
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
        if (Cursor_sogopebo!=null)
          Cursor_sogopebo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_clientiope!=null)
          Cursor_clientiope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.size(); i++) {
                _file1=(String)filenames.elementAt(i);
                _file2=(String)fileonames.elementAt(i);
                java.io.FileInputStream in = new java.io.FileInputStream(_file1);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(_file2));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
                FileLibMit.DeleteFile(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(_file2));
            }
        
            // Complete the ZIP file
            out.close();
            filenames.removeAllElements();
            fileonames.removeAllElements();
        } catch (java.io.IOException e) {
        }
    
  }
  void Page_3() throws Exception {
    /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/mitfisc.zip" */
    cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/mitfisc.zip";
    /* gMsgProc := gMsgProc + 'Scrittura File archope.txt'+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Scrittura File archope.txt"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _riga := '' */
    _riga = "";
    /* cOnlyNomeFile := "archope.txt" */
    cOnlyNomeFile = "archope.txt";
    /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/archope.txt" */
    cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archope.txt";
    // These are the files to include in the ZIP file
    filenames.add(cNomeFile);
    fileonames.add(cOnlyNomeFile);
    /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile)) */
    fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile));
    for (MemoryCursorRow_operazbo rowArchope : mcArchope._iterable_()) {
      /* _riga := arfn_fdate_nd(rowArchope.DATAOPE,'S') */
      _riga = arfn_fdate_ndR.Make(m_Ctx,this).Run(rowArchope.DATAOPE,"S");
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.FLAGCONT,1) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.FLAGCONT,1);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.CODANA,4) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.CODANA,4);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.CODVOC,2) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.CODVOC,2);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.TIPOINT2,2) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.TIPOINT2,2);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.CODINT2,11) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.CODINT2,11);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.PAESE,3) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.PAESE,3);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.RAPPORTO,50) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.RAPPORTO,50);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.FLAGRAP,1) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.FLAGRAP,1);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.TIPOLEG,1) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.TIPOLEG,1);
      /* _riga := _riga + arfn_fdate_nd(rowArchope.DATAREG,'S') */
      _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowArchope.DATAREG,"S");
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.FLAGLIRE,1) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.FLAGLIRE,1);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.VALUTA,3) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.VALUTA,3);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.SEGNO,1) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.SEGNO,1);
      /* _riga := _riga+ Right(Space(15)+LRTrim(Str(rowArchope.TOTLIRE,15,0)),15) */
      _riga = _riga+CPLib.Right(CPLib.Space(15)+CPLib.LRTrim(CPLib.Str(rowArchope.TOTLIRE,15,0)),15);
      /* _riga := _riga+ Right(Space(15)+LRTrim(Str(rowArchope.TOTCONT,15,0)),15) */
      _riga = _riga+CPLib.Right(CPLib.Space(15)+CPLib.LRTrim(CPLib.Str(rowArchope.TOTCONT,15,0)),15);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.CONNESCLI,16) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.CONNESCLI,16);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.CONNESOPER,16) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.CONNESOPER,16);
      /* _riga := _riga+ Right(Space(9)+LRTrim(Str(rowArchope.CAMBIO,9,0)),9) */
      _riga = _riga+CPLib.Right(CPLib.Space(9)+CPLib.LRTrim(CPLib.Str(rowArchope.CAMBIO,9,0)),9);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.NUMPROG,11) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.NUMPROG,11);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.TIPOOPRAP,2) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.TIPOOPRAP,2);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.CODINTER,11) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.CODINTER,11);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.FLAGFRAZ,1) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.FLAGFRAZ,1);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.UNIQUECODE,10) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.UNIQUECODE,10);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.RIFIMP,9) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.RIFIMP,9);
      /* _riga := _riga+ LibreriaMit.SpacePad(arfn_agechar(rowArchope.ZCPARTE,' '),69) */
      _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowArchope.ZCPARTE," "),69);
      /* _riga := _riga + arfn_fdate_nd(rowArchope.DATAIMP,'S') */
      _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowArchope.DATAIMP,"S");
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchope.IDEREG,20) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchope.IDEREG,20);
      /* FileLibMit.Write(fhand,Left(_riga+Space(309),309)+NL) */
      FileLibMit.Write(fhand,CPLib.Left(_riga+CPLib.Space(309),309)+"\n");
    }
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Scrittura File archpers.txt'+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Scrittura File archpers.txt"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _riga := '' */
    _riga = "";
    /* cOnlyNomeFile := "archpers.txt" */
    cOnlyNomeFile = "archpers.txt";
    /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/archpers.txt" */
    cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archpers.txt";
    // These are the files to include in the ZIP file
    filenames.add(cNomeFile);
    fileonames.add(cOnlyNomeFile);
    /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile)) */
    fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile));
    for (MemoryCursorRow_personbo rowArchpers : mcArchpers._iterable_()) {
      /* _riga := LibreriaMit.SpacePad(rowArchpers.CODCAB,6) */
      _riga = LibreriaMit.SpacePad(rowArchpers.CODCAB,6);
      /* _riga := _riga+ LibreriaMit.SpacePad(arfn_agechar(rowArchpers.RAGSOC,' '),70) */
      _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowArchpers.RAGSOC," "),70);
      /* _riga := _riga+ LibreriaMit.SpacePad(arfn_agechar(rowArchpers.DOMICILIO,' '),35) */
      _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowArchpers.DOMICILIO," "),35);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchpers.CODFISC,16) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchpers.CODFISC,16);
      /* _riga := _riga + arfn_fdate_nd(rowArchpers.DATANASC,'S') */
      _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowArchpers.DATANASC,"S");
      /* If Empty(LRTrim(rowArchpers.NASSTATO)) or LRTrim(rowArchpers.NASSTATO)='ITALIA' */
      if (CPLib.Empty(CPLib.LRTrim(rowArchpers.NASSTATO)) || CPLib.eqr(CPLib.LRTrim(rowArchpers.NASSTATO),"ITALIA")) {
        /* _riga := _riga+ LibreriaMit.SpacePad(Left(rowArchpers.NASCOMUN,30),30) */
        _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(rowArchpers.NASCOMUN,30),30);
      } else { // Else
        /* _riga := _riga+ LibreriaMit.SpacePad(Left(rowArchpers.NASSTATO,30),30) */
        _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(rowArchpers.NASSTATO,30),30);
      } // End If
      /* _riga := _riga+ LibreriaMit.SpacePad(Left(rowArchpers.DESCCIT,30),30) */
      _riga = _riga+LibreriaMit.SpacePad(CPLib.Left(rowArchpers.DESCCIT,30),30);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchpers.PROVINCIA,2) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchpers.PROVINCIA,2);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchpers.PAESE,3) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchpers.PAESE,3);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchpers.CAP,9) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchpers.CAP,9);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchpers.PARTIVA,14) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchpers.PARTIVA,14);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchpers.SESSO,1) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchpers.SESSO,1);
      /* _riga := _riga+ LibreriaMit.SpacePad(arfn_agechar(rowArchpers.COGNOME,' '),26) */
      _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowArchpers.COGNOME," "),26);
      /* _riga := _riga+ LibreriaMit.SpacePad(arfn_agechar(rowArchpers.NOME,' '),25) */
      _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowArchpers.NOME," "),25);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchpers.TIPINTER,2) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchpers.TIPINTER,2);
      /* _riga := _riga+ Str(rowArchpers.CFESTERO,1,0) */
      _riga = _riga+CPLib.Str(rowArchpers.CFESTERO,1,0);
      /* _riga := _riga+ LibreriaMit.SpacePad(rowArchpers.CONNES,16) */
      _riga = _riga+LibreriaMit.SpacePad(rowArchpers.CONNES,16);
      /* FileLibMit.Write(fhand,Left(_riga+Space(294),294)+NL) */
      FileLibMit.Write(fhand,CPLib.Left(_riga+CPLib.Space(294),294)+"\n");
    }
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* If _nCli > 0 */
    if (CPLib.gt(_nCli,0)) {
      /* gMsgProc := gMsgProc + 'Scrittura File sogcli.txt'+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Scrittura File sogcli.txt"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _riga := '' */
      _riga = "";
      /* cOnlyNomeFile := "sogcli.txt" */
      cOnlyNomeFile = "sogcli.txt";
      /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/sogcli.txt" */
      cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/sogcli.txt";
      // These are the files to include in the ZIP file
      filenames.add(cNomeFile);
      fileonames.add(cOnlyNomeFile);
      /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile)) */
      fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile));
      for (MemoryCursorRow_clientiope rowClienti : mcClienti._iterable_()) {
        /* _riga := Space(10) */
        _riga = CPLib.Space(10);
        /* _riga := _riga+ LibreriaMit.SpacePad(rowClienti.IDFILEBO,10) */
        _riga = _riga+LibreriaMit.SpacePad(rowClienti.IDFILEBO,10);
        /* _riga := _riga+ LibreriaMit.SpacePad(rowClienti.CODSOG,16) */
        _riga = _riga+LibreriaMit.SpacePad(rowClienti.CODSOG,16);
        /* FileLibMit.Write(fhand,Left(_riga+Space(36),36)+NL) */
        FileLibMit.Write(fhand,CPLib.Left(_riga+CPLib.Space(36),36)+"\n");
      }
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
    } // End If
    /* If _nEse > 0 */
    if (CPLib.gt(_nEse,0)) {
      /* gMsgProc := gMsgProc + 'Scrittura File sogope.txt - '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Scrittura File sogope.txt - "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _riga := '' */
      _riga = "";
      /* cOnlyNomeFile := "sogope.txt" */
      cOnlyNomeFile = "sogope.txt";
      /* cNomeFile := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/sogope.txt" */
      cNomeFile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/sogope.txt";
      // These are the files to include in the ZIP file
      filenames.add(cNomeFile);
      fileonames.add(cOnlyNomeFile);
      /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(cOnlyNomeFile)) */
      fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cOnlyNomeFile));
      for (MemoryCursorRow_sogopebo rowSogopebo : mcSogopebo._iterable_()) {
        /* _riga := Space(10) */
        _riga = CPLib.Space(10);
        /* _riga := _riga+ LibreriaMit.SpacePad(rowSogopebo.IDFILEBO,10) */
        _riga = _riga+LibreriaMit.SpacePad(rowSogopebo.IDFILEBO,10);
        /* _riga := _riga+ LibreriaMit.SpacePad(rowSogopebo.CODSOG,16) */
        _riga = _riga+LibreriaMit.SpacePad(rowSogopebo.CODSOG,16);
        /* _riga := _riga+ LibreriaMit.SpacePad(rowSogopebo.LEGAME,1) */
        _riga = _riga+LibreriaMit.SpacePad(rowSogopebo.LEGAME,1);
        /* FileLibMit.Write(fhand,Left(_riga+Space(37),37)+NL) */
        FileLibMit.Write(fhand,CPLib.Left(_riga+CPLib.Space(37),37)+"\n");
      }
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
    } // End If
    /* Exec "Crea il file zip" Page 2:Page_2 */
    Page_2();
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Estrazione terminata!' // Messaggio Import */
    gMsgImp = "Estrazione terminata!";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void Page_4() throws Exception {
    /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/mitfisc.zip" */
    cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/mitfisc.zip";
    /* gMsgProc := gMsgProc + 'Scrittura File archope.txt'+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Scrittura File archope.txt"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _riga := '' */
    _riga = "";
    for (MemoryCursorRow_operazbo rowArchope : mcArchope._iterable_()) {
    }
    /* gMsgProc := gMsgProc + 'Scrittura File archpers.txt'+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Scrittura File archpers.txt"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _riga := '' */
    _riga = "";
    for (MemoryCursorRow_personbo rowArchpers : mcArchpers._iterable_()) {
    }
    /* FileLibMit.Close(fhand) */
    FileLibMit.Close(fhand);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Estrazione terminata!' // Messaggio Import */
    gMsgImp = "Estrazione terminata!";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
  }
  void _init_() {
  }
  public String RunAsync(String p_pTipo,double p_w_annofisc,double p_pImporto) {
    pTipo = p_pTipo;
    w_annofisc = p_w_annofisc;
    pImporto = p_pImporto;
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
  public Forward Run(String p_pTipo,double p_w_annofisc,double p_pImporto) {
    pTipo = p_pTipo;
    w_annofisc = p_w_annofisc;
    pImporto = p_pImporto;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_estrai_mitfiscR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_estrai_mitfiscR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pTipo = CPLib.Space(1);
    w_annofisc = 0;
    pImporto = 0;
    _max = 0;
    _min = 0;
    _tot = 0;
    _cicli = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _dataini = CPLib.Space(8);
    _datafin = CPLib.Space(8);
    _mono = 0;
    _rapage = CPLib.Space(50);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    fhand = CPLib.Space(10);
    _riga = "";
    _ucode = CPLib.Space(10);
    _file1 = CPLib.Space(30);
    _file2 = CPLib.Space(30);
    _nEse = 0;
    _nCli = 0;
    _dini = CPLib.NullDate();
    mcArchpers = new MemoryCursor_personbo();
    rowArchpers = new MemoryCursorRow_personbo();
    mcArchope = new MemoryCursor_operazbo();
    rowArchope = new MemoryCursorRow_operazbo();
    mcSogopebo = new MemoryCursor_sogopebo();
    rowSogopebo = new MemoryCursorRow_sogopebo();
    mcClienti = new MemoryCursor_clientiope();
    rowClienti = new MemoryCursorRow_clientiope();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_mitfisc_ope_glob,qbe_mitfisc_ope_dett,
  public static final String m_cVQRList = ",qbe_mitfisc_ope_glob,qbe_mitfisc_ope_dett,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_fdate_nd,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_fdate_nd,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pTipo","w_annofisc","pImporto"};
}
