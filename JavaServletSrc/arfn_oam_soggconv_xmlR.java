// * --- Area Manuale = BO - Header
// * --- arfn_oam_soggconv_xml
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
// * --- Fine Area Manuale
public class arfn_oam_soggconv_xmlR implements CallerWithObjs {
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
  public String m_cPhName_tbvasp;
  public String m_cServer_tbvasp;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_tbmacage;
  public String m_cServer_tbmacage;
  public String m_cPhName_ageresleg;
  public String m_cServer_ageresleg;
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_dippreposti;
  public String m_cServer_dippreposti;
  public String m_cPhName_tbcitta;
  public String m_cServer_tbcitta;
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
  public double pAnno;
  public double pSem;
  public String pPrimo;
  public String gAzienda;
  public String gIntemediario;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  public String gPathDoc;
  public String _datini;
  public String _datfin;
  public String cRitorno;
  public String fhand;
  public String riga;
  public String nFile;
  public String cNomeFileZip;
  public String cNomeZip;
  public String fname;
  public String pfname;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public double _totale;
  public String _ioamcode;
  public String _ioamcodeR;
  public double _totleg;
  public double _totvir;
  public String zipname;
  public String pzipname;
  public String _statonas;
  public MemoryCursor_tbmacage mcMACAGE;
  public String _numciv;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_oam_soggconv_xmlR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_oam_soggconv_xml",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_tbvasp = p_ContextObject.GetPhName("tbvasp");
    if (m_cPhName_tbvasp.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbvasp = m_cPhName_tbvasp+" "+m_Ctx.GetWritePhName("tbvasp");
    }
    m_cServer_tbvasp = p_ContextObject.GetServer("tbvasp");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    if (m_cPhName_tbstati.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbstati = m_cPhName_tbstati+" "+m_Ctx.GetWritePhName("tbstati");
    }
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_tbmacage = p_ContextObject.GetPhName("tbmacage");
    if (m_cPhName_tbmacage.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbmacage = m_cPhName_tbmacage+" "+m_Ctx.GetWritePhName("tbmacage");
    }
    m_cServer_tbmacage = p_ContextObject.GetServer("tbmacage");
    m_cPhName_ageresleg = p_ContextObject.GetPhName("ageresleg");
    if (m_cPhName_ageresleg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_ageresleg = m_cPhName_ageresleg+" "+m_Ctx.GetWritePhName("ageresleg");
    }
    m_cServer_ageresleg = p_ContextObject.GetServer("ageresleg");
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_dippreposti = p_ContextObject.GetPhName("dippreposti");
    if (m_cPhName_dippreposti.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_dippreposti = m_cPhName_dippreposti+" "+m_Ctx.GetWritePhName("dippreposti");
    }
    m_cServer_dippreposti = p_ContextObject.GetServer("dippreposti");
    m_cPhName_tbcitta = p_ContextObject.GetPhName("tbcitta");
    if (m_cPhName_tbcitta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbcitta = m_cPhName_tbcitta+" "+m_Ctx.GetWritePhName("tbcitta");
    }
    m_cServer_tbcitta = p_ContextObject.GetServer("tbcitta");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pSem",p_cVarName)) {
      return pSem;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("_totleg",p_cVarName)) {
      return _totleg;
    }
    if (CPLib.eqr("_totvir",p_cVarName)) {
      return _totvir;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_oam_soggconv_xml";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pPrimo",p_cVarName)) {
      return pPrimo;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
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
    if (CPLib.eqr("_datini",p_cVarName)) {
      return _datini;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      return _datfin;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("nFile",p_cVarName)) {
      return nFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("cNomeZip",p_cVarName)) {
      return cNomeZip;
    }
    if (CPLib.eqr("fname",p_cVarName)) {
      return fname;
    }
    if (CPLib.eqr("pfname",p_cVarName)) {
      return pfname;
    }
    if (CPLib.eqr("_ioamcode",p_cVarName)) {
      return _ioamcode;
    }
    if (CPLib.eqr("_ioamcodeR",p_cVarName)) {
      return _ioamcodeR;
    }
    if (CPLib.eqr("zipname",p_cVarName)) {
      return zipname;
    }
    if (CPLib.eqr("pzipname",p_cVarName)) {
      return pzipname;
    }
    if (CPLib.eqr("_statonas",p_cVarName)) {
      return _statonas;
    }
    if (CPLib.eqr("_numciv",p_cVarName)) {
      return _numciv;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      return _ddatini;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      return _ddatfin;
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
    if (CPLib.eqr("mcMACAGE",p_cVarName)) {
      return mcMACAGE;
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
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pSem",p_cVarName)) {
      pSem = value;
      return;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("_totleg",p_cVarName)) {
      _totleg = value;
      return;
    }
    if (CPLib.eqr("_totvir",p_cVarName)) {
      _totvir = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pPrimo",p_cVarName)) {
      pPrimo = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
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
    if (CPLib.eqr("_datini",p_cVarName)) {
      _datini = value;
      return;
    }
    if (CPLib.eqr("_datfin",p_cVarName)) {
      _datfin = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("nFile",p_cVarName)) {
      nFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("cNomeZip",p_cVarName)) {
      cNomeZip = value;
      return;
    }
    if (CPLib.eqr("fname",p_cVarName)) {
      fname = value;
      return;
    }
    if (CPLib.eqr("pfname",p_cVarName)) {
      pfname = value;
      return;
    }
    if (CPLib.eqr("_ioamcode",p_cVarName)) {
      _ioamcode = value;
      return;
    }
    if (CPLib.eqr("_ioamcodeR",p_cVarName)) {
      _ioamcodeR = value;
      return;
    }
    if (CPLib.eqr("zipname",p_cVarName)) {
      zipname = value;
      return;
    }
    if (CPLib.eqr("pzipname",p_cVarName)) {
      pzipname = value;
      return;
    }
    if (CPLib.eqr("_statonas",p_cVarName)) {
      _statonas = value;
      return;
    }
    if (CPLib.eqr("_numciv",p_cVarName)) {
      _numciv = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("_ddatini",p_cVarName)) {
      _ddatini = value;
      return;
    }
    if (CPLib.eqr("_ddatfin",p_cVarName)) {
      _ddatfin = value;
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
    if (CPLib.eqr("mcMACAGE",p_cVarName)) {
      mcMACAGE = (MemoryCursor_tbmacage)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tbmacage=null;
    CPResultSet Cursor_ageresleg=null;
    CPResultSet Cursor_anadip=null;
    CPResultSet Cursor_dippreposti=null;
    try {
      /* pAnno Numeric(4, 0) // Anno di riferimento */
      /* pSem Numeric(1, 0) // Trimestre */
      /* pPrimo Char(1) // Crea come primo invio */
      /* gAzienda Char(10) // Azienda */
      /* gIntemediario Char(11) // Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* _datini Char(8) // Data Inizio Trimestre */
      /* _datfin Char(8) // Data Fine Trimestre */
      /* cRitorno Char(20) */
      /* fhand Char(1) // Per gestione file */
      /* riga Memo */
      /* nFile Char(20) */
      /* cNomeFileZip Char(30) */
      /* cNomeZip Char(128) */
      /* fname Char(35) */
      /* pfname Char(128) */
      /* _ddatini Date */
      /* _ddatfin Date */
      /* _totale Numeric(10, 0) */
      /* _ioamcode Char(8) */
      /* _ioamcodeR Char(8) */
      /* _totleg Numeric(12, 2) */
      /* _totvir Numeric(12, 2) */
      /* zipname Char(0) */
      /* pzipname Char(0) */
      /* _statonas Char(4) */
      /* mcMACAGE MemoryCursor(tbmacage) */
      /* _numciv Char(20) */
      /* Case pSem=1 */
      if (CPLib.eqr(pSem,1)) {
        /* _datini := Str(pAnno-1,4,0)+'0701' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno-1,4,0)+"0701";
        /* _datfin := Str(pAnno-1,4,0)+'1231' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno-1,4,0)+"1231";
        /* Case pSem=2 */
      } else if (CPLib.eqr(pSem,2)) {
        /* _datini := Str(pAnno,4,0)+'0101' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"0101";
        /* _datfin := Str(pAnno,4,0)+'0630' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"0630";
      } // End Case
      /* _ddatini := iif(pPrimo='S',NullDate(),CharToDate(_datini)) */
      _ddatini = (CPLib.eqr(pPrimo,"S")?CPLib.NullDate():CPLib.CharToDate(_datini));
      /* _ddatfin := iif(pPrimo='S',NullDate(),CharToDate(_datfin)) */
      _ddatfin = (CPLib.eqr(pPrimo,"S")?CPLib.NullDate():CPLib.CharToDate(_datfin));
      /* gMsgProc := "Inizio Creazione file XML per Soggetti Convenzionati: "+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = "Inizio Creazione file XML per Soggetti Convenzionati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select IDOAM,IDOAMR  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _ioamcode := intermbo->IDOAM */
        _ioamcode = Cursor_intermbo.GetString("IDOAM");
        /* _ioamcodeR := intermbo->IDOAMR */
        _ioamcodeR = Cursor_intermbo.GetString("IDOAMR");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* If pPrimo='S' */
      if (CPLib.eqr(pPrimo,"S")) {
        // * --- Fill memory cursor mcMACAGE on tbmacage
        mcMACAGE.Zap();
        m_cServer = m_Ctx.GetServer("tbmacage");
        m_cPhName = m_Ctx.GetPhName("tbmacage");
        if (Cursor_tbmacage!=null)
          Cursor_tbmacage.Close();
        Cursor_tbmacage = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbmacage")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_tbmacage;
          Cursor_tbmacage.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,10000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_oam_soggconv_xml: query on tbmacage returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 10000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_tbmacage.Eof())) {
          mcMACAGE.AppendBlank();
          mcMACAGE.row.MACODICE = Cursor_tbmacage.GetString("MACODICE");
          mcMACAGE.row.MADESCRI = Cursor_tbmacage.GetString("MADESCRI");
          mcMACAGE.row.MAFLGRAP = Cursor_tbmacage.GetString("MAFLGRAP");
          mcMACAGE.row.MAFLGOPE = Cursor_tbmacage.GetString("MAFLGOPE");
          mcMACAGE.row.MAFLGBON = Cursor_tbmacage.GetString("MAFLGBON");
          mcMACAGE.row.MAFLGCKR = Cursor_tbmacage.GetString("MAFLGCKR");
          mcMACAGE.row.MAFLGASR = Cursor_tbmacage.GetString("MAFLGASR");
          mcMACAGE.row.MAFLGNOX = Cursor_tbmacage.GetString("MAFLGNOX");
          mcMACAGE.row.MADIPSTD = Cursor_tbmacage.GetString("MADIPSTD");
          mcMACAGE.row.MANAIDWU = Cursor_tbmacage.GetString("MANAIDWU");
          mcMACAGE.row.MAFLGCHKDAT = Cursor_tbmacage.GetString("MAFLGCHKDAT");
          mcMACAGE.row.MAFLGACT = Cursor_tbmacage.GetString("MAFLGACT");
          mcMACAGE.row.MARESSDEF = Cursor_tbmacage.GetString("MARESSDEF");
          mcMACAGE.row.MAFLGAUA = Cursor_tbmacage.GetString("MAFLGAUA");
          mcMACAGE.row.MADATINI = Cursor_tbmacage.GetDate("MADATINI");
          mcMACAGE.row.MADATFIN = Cursor_tbmacage.GetDate("MADATFIN");
          mcMACAGE.row.MAFISGIU = Cursor_tbmacage.GetString("MAFISGIU");
          mcMACAGE.row.MADATMOD = Cursor_tbmacage.GetDate("MADATMOD");
          mcMACAGE.row.MATIPAGE = Cursor_tbmacage.GetString("MATIPAGE");
          mcMACAGE.row.MACODFIS = Cursor_tbmacage.GetString("MACODFIS");
          mcMACAGE.row.MACOGNOME = Cursor_tbmacage.GetString("MACOGNOME");
          mcMACAGE.row.MANOME = Cursor_tbmacage.GetString("MANOME");
          mcMACAGE.row.MARESPAESE = Cursor_tbmacage.GetString("MARESPAESE");
          mcMACAGE.row.MARESIND = Cursor_tbmacage.GetString("MARESIND");
          mcMACAGE.row.MARESNCIV = Cursor_tbmacage.GetString("MARESNCIV");
          mcMACAGE.row.MARESCITTA = Cursor_tbmacage.GetString("MARESCITTA");
          mcMACAGE.row.MARESPRV = Cursor_tbmacage.GetString("MARESPRV");
          mcMACAGE.row.MARESCAP = Cursor_tbmacage.GetString("MARESCAP");
          mcMACAGE.row.MADOMPAESE = Cursor_tbmacage.GetString("MADOMPAESE");
          mcMACAGE.row.MADOMIND = Cursor_tbmacage.GetString("MADOMIND");
          mcMACAGE.row.MADOMNCIV = Cursor_tbmacage.GetString("MADOMNCIV");
          mcMACAGE.row.MADOMCITTA = Cursor_tbmacage.GetString("MADOMCITTA");
          mcMACAGE.row.MADOMPRV = Cursor_tbmacage.GetString("MADOMPRV");
          mcMACAGE.row.MADOMCAP = Cursor_tbmacage.GetString("MADOMCAP");
          mcMACAGE.row.MAFLGCOMPL = Cursor_tbmacage.GetDouble("MAFLGCOMPL");
          Cursor_tbmacage.Next();
        }
        m_cConnectivityError = Cursor_tbmacage.ErrorMessage();
        Cursor_tbmacage.Close();
        mcMACAGE.GoTop();
      } else { // Else
        // * --- Fill memory cursor mcMACAGE on tbmacage
        mcMACAGE.Zap();
        m_cServer = m_Ctx.GetServer("tbmacage");
        m_cPhName = m_Ctx.GetPhName("tbmacage");
        if (Cursor_tbmacage!=null)
          Cursor_tbmacage.Close();
        Cursor_tbmacage = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"([NOTEMPTYDATE(MADATFIN)] = 0  or  (MADATFIN >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"  and  MADATINI < "+CPSql.SQLValueAdapter(CPLib.ToSQL(_ddatini,"?",0,0,m_cServer, m_oParameters),m_cServer,_ddatini)+"))  and  MAFLGCOMPL=0 "+")"+(m_Ctx.IsSharedTemp("tbmacage")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_tbmacage;
          Cursor_tbmacage.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,10000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_oam_soggconv_xml: query on tbmacage returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 10000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_tbmacage.Eof())) {
          mcMACAGE.AppendBlank();
          mcMACAGE.row.MACODICE = Cursor_tbmacage.GetString("MACODICE");
          mcMACAGE.row.MADESCRI = Cursor_tbmacage.GetString("MADESCRI");
          mcMACAGE.row.MAFLGRAP = Cursor_tbmacage.GetString("MAFLGRAP");
          mcMACAGE.row.MAFLGOPE = Cursor_tbmacage.GetString("MAFLGOPE");
          mcMACAGE.row.MAFLGBON = Cursor_tbmacage.GetString("MAFLGBON");
          mcMACAGE.row.MAFLGCKR = Cursor_tbmacage.GetString("MAFLGCKR");
          mcMACAGE.row.MAFLGASR = Cursor_tbmacage.GetString("MAFLGASR");
          mcMACAGE.row.MAFLGNOX = Cursor_tbmacage.GetString("MAFLGNOX");
          mcMACAGE.row.MADIPSTD = Cursor_tbmacage.GetString("MADIPSTD");
          mcMACAGE.row.MANAIDWU = Cursor_tbmacage.GetString("MANAIDWU");
          mcMACAGE.row.MAFLGCHKDAT = Cursor_tbmacage.GetString("MAFLGCHKDAT");
          mcMACAGE.row.MAFLGACT = Cursor_tbmacage.GetString("MAFLGACT");
          mcMACAGE.row.MARESSDEF = Cursor_tbmacage.GetString("MARESSDEF");
          mcMACAGE.row.MAFLGAUA = Cursor_tbmacage.GetString("MAFLGAUA");
          mcMACAGE.row.MADATINI = Cursor_tbmacage.GetDate("MADATINI");
          mcMACAGE.row.MADATFIN = Cursor_tbmacage.GetDate("MADATFIN");
          mcMACAGE.row.MAFISGIU = Cursor_tbmacage.GetString("MAFISGIU");
          mcMACAGE.row.MADATMOD = Cursor_tbmacage.GetDate("MADATMOD");
          mcMACAGE.row.MATIPAGE = Cursor_tbmacage.GetString("MATIPAGE");
          mcMACAGE.row.MACODFIS = Cursor_tbmacage.GetString("MACODFIS");
          mcMACAGE.row.MACOGNOME = Cursor_tbmacage.GetString("MACOGNOME");
          mcMACAGE.row.MANOME = Cursor_tbmacage.GetString("MANOME");
          mcMACAGE.row.MARESPAESE = Cursor_tbmacage.GetString("MARESPAESE");
          mcMACAGE.row.MARESIND = Cursor_tbmacage.GetString("MARESIND");
          mcMACAGE.row.MARESNCIV = Cursor_tbmacage.GetString("MARESNCIV");
          mcMACAGE.row.MARESCITTA = Cursor_tbmacage.GetString("MARESCITTA");
          mcMACAGE.row.MARESPRV = Cursor_tbmacage.GetString("MARESPRV");
          mcMACAGE.row.MARESCAP = Cursor_tbmacage.GetString("MARESCAP");
          mcMACAGE.row.MADOMPAESE = Cursor_tbmacage.GetString("MADOMPAESE");
          mcMACAGE.row.MADOMIND = Cursor_tbmacage.GetString("MADOMIND");
          mcMACAGE.row.MADOMNCIV = Cursor_tbmacage.GetString("MADOMNCIV");
          mcMACAGE.row.MADOMCITTA = Cursor_tbmacage.GetString("MADOMCITTA");
          mcMACAGE.row.MADOMPRV = Cursor_tbmacage.GetString("MADOMPRV");
          mcMACAGE.row.MADOMCAP = Cursor_tbmacage.GetString("MADOMCAP");
          mcMACAGE.row.MAFLGCOMPL = Cursor_tbmacage.GetDouble("MAFLGCOMPL");
          Cursor_tbmacage.Next();
        }
        m_cConnectivityError = Cursor_tbmacage.ErrorMessage();
        Cursor_tbmacage.Close();
        mcMACAGE.GoTop();
      } // End If
      /* mcMACAGE.GoTop() */
      mcMACAGE.GoTop();
      /* While not(mcMACAGE.Eof()) */
      while ( ! (mcMACAGE.Eof())) {
        /* If pPrimo='S' */
        if (CPLib.eqr(pPrimo,"S")) {
          /* mcMACAGE.MAFLGAUA := 'N' */
          mcMACAGE.row.MAFLGAUA = "N";
          /* mcMACAGE.SaveRow() */
          mcMACAGE.SaveRow();
        } else { // Else
          /* If (mcMACAGE.MADATINI >= _ddatini and mcMACAGE.MADATINI <= _ddatfin and (Empty(mcMACAGE.MADATFIN) or mcMACAGE.MADATFIN > _ddatfin)) */
          if ((CPLib.ge(mcMACAGE.row.MADATINI,_ddatini) && CPLib.le(mcMACAGE.row.MADATINI,_ddatfin) && (CPLib.Empty(mcMACAGE.row.MADATFIN) || CPLib.gt(mcMACAGE.row.MADATFIN,_ddatfin)))) {
            /* mcMACAGE.MAFLGAUA := 'N' */
            mcMACAGE.row.MAFLGAUA = "N";
            /* mcMACAGE.SaveRow() */
            mcMACAGE.SaveRow();
          } // End If
          /* If mcMACAGE.MADATINI < _ddatini and mcMACAGE.MADATFIN >= _ddatini and mcMACAGE.MADATFIN <= _ddatfin */
          if (CPLib.lt(mcMACAGE.row.MADATINI,_ddatini) && CPLib.ge(mcMACAGE.row.MADATFIN,_ddatini) && CPLib.le(mcMACAGE.row.MADATFIN,_ddatfin)) {
            /* mcMACAGE.MAFLGAUA := 'D' */
            mcMACAGE.row.MAFLGAUA = "D";
            /* mcMACAGE.SaveRow() */
            mcMACAGE.SaveRow();
          } // End If
          /* If not(Empty(mcMACAGE.MADATMOD)) and mcMACAGE.MADATMOD >= _ddatini and mcMACAGE.MADATMOD <= _ddatfin and (Empty(mcMACAGE.MADATFIN) or mcMACAGE.MADATFIN > _ddatfin) */
          if ( ! (CPLib.Empty(mcMACAGE.row.MADATMOD)) && CPLib.ge(mcMACAGE.row.MADATMOD,_ddatini) && CPLib.le(mcMACAGE.row.MADATMOD,_ddatfin) && (CPLib.Empty(mcMACAGE.row.MADATFIN) || CPLib.gt(mcMACAGE.row.MADATFIN,_ddatfin))) {
            /* mcMACAGE.MAFLGAUA := 'U' */
            mcMACAGE.row.MAFLGAUA = "U";
            /* mcMACAGE.SaveRow() */
            mcMACAGE.SaveRow();
          } // End If
        } // End If
        /* mcMACAGE.Next() */
        mcMACAGE.Next();
      } // End While
      /* fname := "MACROAGENTE."+LRTrim(_ioamcode)+"."+Str(pAnno,4,0)+"."+Str(pSem,1,0)+"."+DateToChar(Date())+".xml" */
      fname = "MACROAGENTE."+CPLib.LRTrim(_ioamcode)+"."+CPLib.Str(pAnno,4,0)+"."+CPLib.Str(pSem,1,0)+"."+CPLib.DateToChar(CPLib.Date())+".xml";
      /* zipname := "MACROAGENTE."+LRTrim(_ioamcode)+"."+Str(pAnno,4,0)+"."+Str(pSem,1,0)+"."+DateToChar(Date())+".zip" */
      zipname = "MACROAGENTE."+CPLib.LRTrim(_ioamcode)+"."+CPLib.Str(pAnno,4,0)+"."+CPLib.Str(pSem,1,0)+"."+CPLib.DateToChar(CPLib.Date())+".zip";
      /* pfname := LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/"+LRTrim(fname) */
      pfname = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(fname);
      /* pzipname := LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/"+LRTrim(zipname) */
      pzipname = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(zipname);
      /* fhand := FileLibMit.OpenWritePath(pfname) // Per gestione file */
      fhand = FileLibMit.OpenWritePath(pfname);
      /* FileLibMit.WriteLine(fhand,'<?xml version="1.0" encoding="utf-8"?>') */
      FileLibMit.WriteLine(fhand,"<?xml version=\"1.0\" encoding=\"utf-8\"?>");
      /* FileLibMit.WriteLine(fhand,'<Trasmissione xmlns="http://tempuri.org/XMLSchema.xsd">') */
      FileLibMit.WriteLine(fhand,"<Trasmissione xmlns=\"http://tempuri.org/XMLSchema.xsd\">");
      /* FileLibMit.WriteLine(fhand,"<Intestazione>") */
      FileLibMit.WriteLine(fhand,"<Intestazione>");
      /* FileLibMit.WriteLine(fhand,"<IdUserOAM>"+LRTrim(_ioamcode)+"</IdUserOAM>") */
      FileLibMit.WriteLine(fhand,"<IdUserOAM>"+CPLib.LRTrim(_ioamcode)+"</IdUserOAM>");
      /* FileLibMit.WriteLine(fhand,"<IdSoggettoRappresentato>"+LRTrim(_ioamcodeR)+"</IdSoggettoRappresentato>") */
      FileLibMit.WriteLine(fhand,"<IdSoggettoRappresentato>"+CPLib.LRTrim(_ioamcodeR)+"</IdSoggettoRappresentato>");
      /* FileLibMit.WriteLine(fhand,"<DataOraGenerazione>"+arfn_fdatetime_bp(DateTime())+"</DataOraGenerazione>") */
      FileLibMit.WriteLine(fhand,"<DataOraGenerazione>"+arfn_fdatetime_bpR.Make(m_Ctx,this).Run(CPLib.DateTime())+"</DataOraGenerazione>");
      /* FileLibMit.WriteLine(fhand,"<DataEstrazione>"+arfn_fdate_bp(Date())+"</DataEstrazione>") */
      FileLibMit.WriteLine(fhand,"<DataEstrazione>"+arfn_fdate_bpR.Make(m_Ctx,this).Run(CPLib.Date())+"</DataEstrazione>");
      /* FileLibMit.WriteLine(fhand,"<AnnoRiferimento>"+Str(pAnno,4,0)+"</AnnoRiferimento>") */
      FileLibMit.WriteLine(fhand,"<AnnoRiferimento>"+CPLib.Str(pAnno,4,0)+"</AnnoRiferimento>");
      /* FileLibMit.WriteLine(fhand,"<PeriodoRiferimento>"+Str(pSem,1,0)+"</PeriodoRiferimento>") */
      FileLibMit.WriteLine(fhand,"<PeriodoRiferimento>"+CPLib.Str(pSem,1,0)+"</PeriodoRiferimento>");
      /* FileLibMit.WriteLine(fhand,"</Intestazione>") */
      FileLibMit.WriteLine(fhand,"</Intestazione>");
      /* _totale := 0 */
      _totale = CPLib.Round(0,0);
      for (MemoryCursorRow_tbmacage rwMACAGE : mcMACAGE._iterable_()) {
        /* gMsgImp := "Elaborazione del MacroAgente: "+iif(Empty(LRTrim(rwMACAGE.MADESCRI)),LRTrim(rwMACAGE.MACOGNOME)+" "+LRTrim(rwMACAGE.MANOME),LRTrim(rwMACAGE.MADESCRI)) // Messaggio Import */
        gMsgImp = "Elaborazione del MacroAgente: "+(CPLib.Empty(CPLib.LRTrim(rwMACAGE.MADESCRI))?CPLib.LRTrim(rwMACAGE.MACOGNOME)+" "+CPLib.LRTrim(rwMACAGE.MANOME):CPLib.LRTrim(rwMACAGE.MADESCRI));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _totale := _totale + 1 */
        _totale = CPLib.Round(_totale+1,0);
        /* FileLibMit.WriteLine(fhand,"<AgenteConvenzionato>") */
        FileLibMit.WriteLine(fhand,"<AgenteConvenzionato>");
        /* FileLibMit.WriteLine(fhand,"<Progressivo>"+LRTrim(Str(_totale,10,0))+"</Progressivo>") */
        FileLibMit.WriteLine(fhand,"<Progressivo>"+CPLib.LRTrim(CPLib.Str(_totale,10,0))+"</Progressivo>");
        /* FileLibMit.WriteLine(fhand,"<Operazione>"+rwMACAGE.MAFLGAUA+"</Operazione>") */
        FileLibMit.WriteLine(fhand,"<Operazione>"+rwMACAGE.MAFLGAUA+"</Operazione>");
        /* FileLibMit.WriteLine(fhand,"<Soggetto>") */
        FileLibMit.WriteLine(fhand,"<Soggetto>");
        /* FileLibMit.WriteLine(fhand,iif(rwMACAGE.MAFISGIU="P","<AGENTE-CONV-PF>","<AGENTE-CONV-PG>")) */
        FileLibMit.WriteLine(fhand,(CPLib.eqr(rwMACAGE.MAFISGIU,"P")?"<AGENTE-CONV-PF>":"<AGENTE-CONV-PG>"));
        /* If rwMACAGE.MAFISGIU='P' */
        if (CPLib.eqr(rwMACAGE.MAFISGIU,"P")) {
          /* FileLibMit.WriteLine(fhand,"<CodiceFiscale>"+LRTrim(rwMACAGE.MACODFIS)+"</CodiceFiscale>") */
          FileLibMit.WriteLine(fhand,"<CodiceFiscale>"+CPLib.LRTrim(rwMACAGE.MACODFIS)+"</CodiceFiscale>");
          /* FileLibMit.WriteLine(fhand,"<Nome>"+LRTrim(rwMACAGE.MANOME)+"</Nome>") */
          FileLibMit.WriteLine(fhand,"<Nome>"+CPLib.LRTrim(rwMACAGE.MANOME)+"</Nome>");
          /* FileLibMit.WriteLine(fhand,"<Cognome>"+LRTrim(rwMACAGE.MACOGNOME)+"</Cognome>") */
          FileLibMit.WriteLine(fhand,"<Cognome>"+CPLib.LRTrim(rwMACAGE.MACOGNOME)+"</Cognome>");
        } else { // Else
          /* FileLibMit.WriteLine(fhand,"<PIVA>"+LRTrim(rwMACAGE.MACODFIS)+"</PIVA>") */
          FileLibMit.WriteLine(fhand,"<PIVA>"+CPLib.LRTrim(rwMACAGE.MACODFIS)+"</PIVA>");
          /* FileLibMit.WriteLine(fhand,"<Denominazione>"+arfn_oamchar(LRTrim(rwMACAGE.MADESCRI),"")+"</Denominazione>") */
          FileLibMit.WriteLine(fhand,"<Denominazione>"+arfn_oamcharR.Make(m_Ctx,this).Run(CPLib.LRTrim(rwMACAGE.MADESCRI),"")+"</Denominazione>");
          // * --- Select from ageresleg
          m_cServer = m_Ctx.GetServer("ageresleg");
          m_cPhName = m_Ctx.GetPhName("ageresleg");
          if (Cursor_ageresleg!=null)
            Cursor_ageresleg.Close();
          Cursor_ageresleg = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODMAGE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwMACAGE.MACODICE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwMACAGE.MACODICE)+" "+")"+(m_Ctx.IsSharedTemp("ageresleg")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_ageresleg.Eof())) {
            /* If Empty(ageresleg->DATAFINE) or ageresleg->DATAFINE > _ddatfin or pPrimo='S' */
            if (CPLib.Empty(Cursor_ageresleg.GetDate("DATAFINE")) || CPLib.gt(Cursor_ageresleg.GetDate("DATAFINE"),_ddatfin) || CPLib.eqr(pPrimo,"S")) {
              /* FileLibMit.WriteLine(fhand,"<ResponsabileLegale>") */
              FileLibMit.WriteLine(fhand,"<ResponsabileLegale>");
              /* FileLibMit.WriteLine(fhand,"<Nome>"+LRTrim(ageresleg->NOME)+"</Nome>") */
              FileLibMit.WriteLine(fhand,"<Nome>"+CPLib.LRTrim(Cursor_ageresleg.GetString("NOME"))+"</Nome>");
              /* FileLibMit.WriteLine(fhand,"<Cognome>"+LRTrim(ageresleg->COGNOME)+"</Cognome>") */
              FileLibMit.WriteLine(fhand,"<Cognome>"+CPLib.LRTrim(Cursor_ageresleg.GetString("COGNOME"))+"</Cognome>");
              /* FileLibMit.WriteLine(fhand,"</ResponsabileLegale>") */
              FileLibMit.WriteLine(fhand,"</ResponsabileLegale>");
            } // End If
            Cursor_ageresleg.Next();
          }
          m_cConnectivityError = Cursor_ageresleg.ErrorMessage();
          Cursor_ageresleg.Close();
          // * --- End Select
        } // End If
        /* FileLibMit.WriteLine(fhand,iif(rwMACAGE.MAFISGIU="P","<Residenza>","<SedeLegale>")) */
        FileLibMit.WriteLine(fhand,(CPLib.eqr(rwMACAGE.MAFISGIU,"P")?"<Residenza>":"<SedeLegale>"));
        /* FileLibMit.WriteLine(fhand,iif(rwMACAGE.MARESPAESE="086","<IndirizzoItalia>","<IndirizzoEstero>")) */
        FileLibMit.WriteLine(fhand,(CPLib.eqr(rwMACAGE.MARESPAESE,"086")?"<IndirizzoItalia>":"<IndirizzoEstero>"));
        /* FileLibMit.WriteLine(fhand,"<Indirizzo>"+LRTrim(rwMACAGE.MARESIND)+"</Indirizzo>") */
        FileLibMit.WriteLine(fhand,"<Indirizzo>"+CPLib.LRTrim(rwMACAGE.MARESIND)+"</Indirizzo>");
        /* FileLibMit.WriteLine(fhand,"<NrCivico>"+LRTrim(rwMACAGE.MARESNCIV)+"</NrCivico>") */
        FileLibMit.WriteLine(fhand,"<NrCivico>"+CPLib.LRTrim(rwMACAGE.MARESNCIV)+"</NrCivico>");
        /* FileLibMit.WriteLine(fhand,"<Stato>"+statocomune(rwMACAGE.MARESPAESE,'S',rwMACAGE.MARESPRV)+"</Stato>") */
        FileLibMit.WriteLine(fhand,"<Stato>"+statocomune(rwMACAGE.MARESPAESE,"S",rwMACAGE.MARESPRV)+"</Stato>");
        /* FileLibMit.WriteLine(fhand,"<Citta>"+iif(rwMACAGE.MARESPAESE="086",statocomune(rwMACAGE.MARESCITTA,'C',rwMACAGE.MARESPRV),LRTrim(rwMACAGE.MARESCITTA))+"</Citta>") */
        FileLibMit.WriteLine(fhand,"<Citta>"+(CPLib.eqr(rwMACAGE.MARESPAESE,"086")?statocomune(rwMACAGE.MARESCITTA,"C",rwMACAGE.MARESPRV):CPLib.LRTrim(rwMACAGE.MARESCITTA))+"</Citta>");
        /* If rwMACAGE.MARESPAESE="086" */
        if (CPLib.eqr(rwMACAGE.MARESPAESE,"086")) {
          /* FileLibMit.WriteLine(fhand,"<Provincia>"+LRTrim(rwMACAGE.MARESPRV)+"</Provincia>") */
          FileLibMit.WriteLine(fhand,"<Provincia>"+CPLib.LRTrim(rwMACAGE.MARESPRV)+"</Provincia>");
        } // End If
        /* FileLibMit.WriteLine(fhand,"<CAP>"+LRTrim(rwMACAGE.MARESCAP)+"</CAP>") */
        FileLibMit.WriteLine(fhand,"<CAP>"+CPLib.LRTrim(rwMACAGE.MARESCAP)+"</CAP>");
        /* FileLibMit.WriteLine(fhand,iif(rwMACAGE.MARESPAESE="086","</IndirizzoItalia>","</IndirizzoEstero>")) */
        FileLibMit.WriteLine(fhand,(CPLib.eqr(rwMACAGE.MARESPAESE,"086")?"</IndirizzoItalia>":"</IndirizzoEstero>"));
        /* FileLibMit.WriteLine(fhand,iif(rwMACAGE.MAFISGIU="P","</Residenza>","</SedeLegale>")) */
        FileLibMit.WriteLine(fhand,(CPLib.eqr(rwMACAGE.MAFISGIU,"P")?"</Residenza>":"</SedeLegale>"));
        /* If rwMACAGE.MAFISGIU='P' */
        if (CPLib.eqr(rwMACAGE.MAFISGIU,"P")) {
          /* If not(Empty(rwMACAGE.MADOMPAESE)) or not(Empty(rwMACAGE.MADOMCITTA)) or not(Empty(rwMACAGE.MADOMPRV)) or not(Empty(rwMACAGE.MADOMIND)) or not(Empty(rwMACAGE.MADOMNCIV)) or not(Empty(rwMACAGE.MADOMCAP)) */
          if ( ! (CPLib.Empty(rwMACAGE.MADOMPAESE)) ||  ! (CPLib.Empty(rwMACAGE.MADOMCITTA)) ||  ! (CPLib.Empty(rwMACAGE.MADOMPRV)) ||  ! (CPLib.Empty(rwMACAGE.MADOMIND)) ||  ! (CPLib.Empty(rwMACAGE.MADOMNCIV)) ||  ! (CPLib.Empty(rwMACAGE.MADOMCAP))) {
            /* FileLibMit.WriteLine(fhand,"<Domicilio>") */
            FileLibMit.WriteLine(fhand,"<Domicilio>");
            /* FileLibMit.WriteLine(fhand,iif(rwMACAGE.MADOMPAESE="086","<IndirizzoItalia>","<IndirizzoEstero>")) */
            FileLibMit.WriteLine(fhand,(CPLib.eqr(rwMACAGE.MADOMPAESE,"086")?"<IndirizzoItalia>":"<IndirizzoEstero>"));
            /* FileLibMit.WriteLine(fhand,"<Indirizzo>"+LRTrim(rwMACAGE.MADOMIND)+"</Indirizzo>") */
            FileLibMit.WriteLine(fhand,"<Indirizzo>"+CPLib.LRTrim(rwMACAGE.MADOMIND)+"</Indirizzo>");
            /* FileLibMit.WriteLine(fhand,"<NrCivico>"+LRTrim(rwMACAGE.MADOMNCIV)+"</NrCivico>") */
            FileLibMit.WriteLine(fhand,"<NrCivico>"+CPLib.LRTrim(rwMACAGE.MADOMNCIV)+"</NrCivico>");
            /* FileLibMit.WriteLine(fhand,"<Stato>"+statocomune(rwMACAGE.MADOMPAESE,'S',rwMACAGE.MADOMPRV)+"</Stato>") */
            FileLibMit.WriteLine(fhand,"<Stato>"+statocomune(rwMACAGE.MADOMPAESE,"S",rwMACAGE.MADOMPRV)+"</Stato>");
            /* FileLibMit.WriteLine(fhand,"<Citta>"+iif(rwMACAGE.MADOMPAESE="086",statocomune(rwMACAGE.MADOMCITTA,'C',rwMACAGE.MADOMPRV),LRTrim(rwMACAGE.MADOMCITTA))+"</Citta>") */
            FileLibMit.WriteLine(fhand,"<Citta>"+(CPLib.eqr(rwMACAGE.MADOMPAESE,"086")?statocomune(rwMACAGE.MADOMCITTA,"C",rwMACAGE.MADOMPRV):CPLib.LRTrim(rwMACAGE.MADOMCITTA))+"</Citta>");
            /* If rwMACAGE.MADOMPAESE="086" */
            if (CPLib.eqr(rwMACAGE.MADOMPAESE,"086")) {
              /* FileLibMit.WriteLine(fhand,"<Provincia>"+LRTrim(rwMACAGE.MADOMPRV)+"</Provincia>") */
              FileLibMit.WriteLine(fhand,"<Provincia>"+CPLib.LRTrim(rwMACAGE.MADOMPRV)+"</Provincia>");
            } // End If
            /* FileLibMit.WriteLine(fhand,"<CAP>"+LRTrim(rwMACAGE.MADOMCAP)+"</CAP>") */
            FileLibMit.WriteLine(fhand,"<CAP>"+CPLib.LRTrim(rwMACAGE.MADOMCAP)+"</CAP>");
            /* FileLibMit.WriteLine(fhand,iif(rwMACAGE.MADOMPAESE="086","</IndirizzoItalia>","</IndirizzoEstero>")) */
            FileLibMit.WriteLine(fhand,(CPLib.eqr(rwMACAGE.MADOMPAESE,"086")?"</IndirizzoItalia>":"</IndirizzoEstero>"));
            /* FileLibMit.WriteLine(fhand,"</Domicilio>") */
            FileLibMit.WriteLine(fhand,"</Domicilio>");
          } // End If
        } // End If
        // * --- Select from anadip
        m_cServer = m_Ctx.GetServer("anadip");
        m_cPhName = m_Ctx.GetPhName("anadip");
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
        Cursor_anadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"MACROAGENTE="+CPSql.SQLValueAdapter(CPLib.ToSQL(rwMACAGE.MACODICE,"?",0,0,m_cServer, m_oParameters),m_cServer,rwMACAGE.MACODICE)+"  and  FLGCOMPL=0 "+")"+(m_Ctx.IsSharedTemp("anadip")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_anadip.Eof())) {
          /* If Empty(anadip->DATAFINE) or anadip->DATAFINE > _ddatfin or (anadip->DATAFINE >= _ddatini and rwMACAGE.MAFLGAUA='D') or pPrimo='S' */
          if (CPLib.Empty(Cursor_anadip.GetDate("DATAFINE")) || CPLib.gt(Cursor_anadip.GetDate("DATAFINE"),_ddatfin) || (CPLib.ge(Cursor_anadip.GetDate("DATAFINE"),_ddatini) && CPLib.eqr(rwMACAGE.MAFLGAUA,"D")) || CPLib.eqr(pPrimo,"S")) {
            /* FileLibMit.WriteLine(fhand,"<SedeOperativa>") */
            FileLibMit.WriteLine(fhand,"<SedeOperativa>");
            /* FileLibMit.WriteLine(fhand,"<IDSedeOperativa>"+LRTrim(anadip->CODDIP)+"</IDSedeOperativa>") */
            FileLibMit.WriteLine(fhand,"<IDSedeOperativa>"+CPLib.LRTrim(Cursor_anadip.GetString("CODDIP"))+"</IDSedeOperativa>");
            /* FileLibMit.WriteLine(fhand,"<Indirizzo>"+LRTrim(anadip->DOMICILIO)+"</Indirizzo>") */
            FileLibMit.WriteLine(fhand,"<Indirizzo>"+CPLib.LRTrim(Cursor_anadip.GetString("DOMICILIO"))+"</Indirizzo>");
            /* FileLibMit.WriteLine(fhand,"<NrCivico>"+LRTrim(anadip->NUMCIVICO)+"</NrCivico>") */
            FileLibMit.WriteLine(fhand,"<NrCivico>"+CPLib.LRTrim(Cursor_anadip.GetString("NUMCIVICO"))+"</NrCivico>");
            /* FileLibMit.WriteLine(fhand,"<Citta>"+statocomune(anadip->DESCCIT,'C',anadip->PROVINCIA)+"</Citta>") */
            FileLibMit.WriteLine(fhand,"<Citta>"+statocomune(Cursor_anadip.GetString("DESCCIT"),"C",Cursor_anadip.GetString("PROVINCIA"))+"</Citta>");
            /* FileLibMit.WriteLine(fhand,"<Provincia>"+LRTrim(anadip->PROVINCIA)+"</Provincia>") */
            FileLibMit.WriteLine(fhand,"<Provincia>"+CPLib.LRTrim(Cursor_anadip.GetString("PROVINCIA"))+"</Provincia>");
            /* FileLibMit.WriteLine(fhand,"<CAP>"+LRTrim(anadip->CAP)+"</CAP>") */
            FileLibMit.WriteLine(fhand,"<CAP>"+CPLib.LRTrim(Cursor_anadip.GetString("CAP"))+"</CAP>");
            /* FileLibMit.WriteLine(fhand,"<ServiziDiRimessaInDenaro>"+iif(anadip->SERRIMDEN="S","SI","NO")+"</ServiziDiRimessaInDenaro>") */
            FileLibMit.WriteLine(fhand,"<ServiziDiRimessaInDenaro>"+(CPLib.eqr(Cursor_anadip.GetString("SERRIMDEN"),"S")?"SI":"NO")+"</ServiziDiRimessaInDenaro>");
            // * --- Select from dippreposti
            m_cServer = m_Ctx.GetServer("dippreposti");
            m_cPhName = m_Ctx.GetPhName("dippreposti");
            if (Cursor_dippreposti!=null)
              Cursor_dippreposti.Close();
            Cursor_dippreposti = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CODDIP="+CPLib.ToSQL(Cursor_anadip.GetString("CODDIP"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("dippreposti")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
            while ( ! (Cursor_dippreposti.Eof())) {
              /* If Empty(dippreposti->DATAFINE) or dippreposti->DATAFINE > _ddatfin or pPrimo='S' */
              if (CPLib.Empty(Cursor_dippreposti.GetDate("DATAFINE")) || CPLib.gt(Cursor_dippreposti.GetDate("DATAFINE"),_ddatfin) || CPLib.eqr(pPrimo,"S")) {
                /* FileLibMit.WriteLine(fhand,"<Preposto>") */
                FileLibMit.WriteLine(fhand,"<Preposto>");
                /* FileLibMit.WriteLine(fhand,"<Nome>"+LRTrim(dippreposti->NOME)+"</Nome>") */
                FileLibMit.WriteLine(fhand,"<Nome>"+CPLib.LRTrim(Cursor_dippreposti.GetString("NOME"))+"</Nome>");
                /* FileLibMit.WriteLine(fhand,"<Cognome>"+LRTrim(dippreposti->COGNOME)+"</Cognome>") */
                FileLibMit.WriteLine(fhand,"<Cognome>"+CPLib.LRTrim(Cursor_dippreposti.GetString("COGNOME"))+"</Cognome>");
                /* FileLibMit.WriteLine(fhand,"</Preposto>") */
                FileLibMit.WriteLine(fhand,"</Preposto>");
              } // End If
              Cursor_dippreposti.Next();
            }
            m_cConnectivityError = Cursor_dippreposti.ErrorMessage();
            Cursor_dippreposti.Close();
            // * --- End Select
            /* FileLibMit.WriteLine(fhand,"</SedeOperativa>") */
            FileLibMit.WriteLine(fhand,"</SedeOperativa>");
          } // End If
          Cursor_anadip.Next();
        }
        m_cConnectivityError = Cursor_anadip.ErrorMessage();
        Cursor_anadip.Close();
        // * --- End Select
        /* FileLibMit.WriteLine(fhand,iif(rwMACAGE.MAFISGIU="P","</AGENTE-CONV-PF>","</AGENTE-CONV-PG>")) */
        FileLibMit.WriteLine(fhand,(CPLib.eqr(rwMACAGE.MAFISGIU,"P")?"</AGENTE-CONV-PF>":"</AGENTE-CONV-PG>"));
        /* FileLibMit.WriteLine(fhand,"</Soggetto>") */
        FileLibMit.WriteLine(fhand,"</Soggetto>");
        /* FileLibMit.WriteLine(fhand,"<DataInizioRapportoMandato>"+arfn_fdate_bp(rwMACAGE.MADATINI)+"</DataInizioRapportoMandato>") */
        FileLibMit.WriteLine(fhand,"<DataInizioRapportoMandato>"+arfn_fdate_bpR.Make(m_Ctx,this).Run(rwMACAGE.MADATINI)+"</DataInizioRapportoMandato>");
        /* If rwMACAGE.MAFLGAUA='D' */
        if (CPLib.eqr(rwMACAGE.MAFLGAUA,"D")) {
          /* FileLibMit.WriteLine(fhand,"<DataFineRapportoMandato>"+arfn_fdate_bp(rwMACAGE.MADATFIN)+"</DataFineRapportoMandato>") */
          FileLibMit.WriteLine(fhand,"<DataFineRapportoMandato>"+arfn_fdate_bpR.Make(m_Ctx,this).Run(rwMACAGE.MADATFIN)+"</DataFineRapportoMandato>");
        } // End If
        /* FileLibMit.WriteLine(fhand,"<TipologiaAgenteConvenzionato>"+rwMACAGE.MATIPAGE+"</TipologiaAgenteConvenzionato>") */
        FileLibMit.WriteLine(fhand,"<TipologiaAgenteConvenzionato>"+rwMACAGE.MATIPAGE+"</TipologiaAgenteConvenzionato>");
        /* FileLibMit.WriteLine(fhand,"</AgenteConvenzionato>") */
        FileLibMit.WriteLine(fhand,"</AgenteConvenzionato>");
      }
      /* If _totale=0 */
      if (CPLib.eqr(_totale,0)) {
        /* FileLibMit.WriteLine(fhand,"<NoRecord></NoRecord>") */
        FileLibMit.WriteLine(fhand,"<NoRecord></NoRecord>");
      } // End If
      /* FileLibMit.WriteLine(fhand,"</Trasmissione>") */
      FileLibMit.WriteLine(fhand,"</Trasmissione>");
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + "Fine Creazione file XML per Soggetti Convenzionati: "+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = gMsgProc+"Fine Creazione file XML per Soggetti Convenzionati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + "Inizio Creazione file ZIP per Soggeti Convenzionati: "+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = gMsgProc+"Inizio Creazione file ZIP per Soggeti Convenzionati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // Crea il file zip
      String fileName = fname;
      String pfileName = pfname;
      String zipFileName = pzipname;
      
      ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
      FileInputStream fileInputStream = new FileInputStream(pfileName);
      
      ZipEntry zipEntry = new ZipEntry(fileName);
      zipOutputStream.putNextEntry(zipEntry);
      
      byte[] buffer = new byte[1024];
      int length;
      while ((length = fileInputStream.read(buffer)) > 0) {
        zipOutputStream.write(buffer, 0, length);
      }
      zipOutputStream.closeEntry();
      zipOutputStream.close();
      fileInputStream.close();
      /* gMsgProc := gMsgProc + "Fine Creazione file ZIP per Soggetti Convenzionati: "+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = gMsgProc+"Fine Creazione file ZIP per Soggetti Convenzionati: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Elaborazione Terminata! Premere il tasto Download per prelevare il file" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata! Premere il tasto Download per prelevare il file";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Return zipname */
      throw new Stop(zipname);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbmacage!=null)
          Cursor_tbmacage.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_ageresleg!=null)
          Cursor_ageresleg.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_anadip!=null)
          Cursor_anadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_dippreposti!=null)
          Cursor_dippreposti.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  String statocomune(String pStatoCitta,String pTipo,String pProv) throws Exception {
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_tbcitta30=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pStatoCitta Char(60) */
      /* pTipo Char(1) */
      /* pProv Char(2) */
      /* _sigla Char(4) */
      String _sigla;
      _sigla = CPLib.Space(4);
      /* If pTipo='S' */
      if (CPLib.eqr(pTipo,"S")) {
        /* If LRTrim(pStatoCitta)='086' */
        if (CPLib.eqr(CPLib.LRTrim(pStatoCitta),"086")) {
          /* _sigla := 'Z086' */
          _sigla = "Z086";
        } else { // Else
          // * --- Read from tbstati
          m_cServer = m_Ctx.GetServer("tbstati");
          m_cPhName = m_Ctx.GetPhName("tbstati");
          m_cSql = "";
          m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(pStatoCitta),"C",3,0,m_cServer),m_cServer,CPLib.LRTrim(pStatoCitta));
          if (m_Ctx.IsSharedTemp("tbstati")) {
            m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
          }
          if (Read_Cursor!=null)
            Read_Cursor.Close();
          Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
          if ( ! (Read_Cursor.Eof())) {
            _sigla = Read_Cursor.GetString("SIGLA");
            Read_Cursor.Next();
            if ( ! (Read_Cursor.Eof())) {
              Error l_oErrorFault = new Error("Read on tbstati into routine arfn_oam_soggconv_xml returns two or more records. This item should return only a record.");
              CPStdCounter.Error(l_oErrorFault);
            }
            Read_Cursor.Close();
          } else {
            // Error: no record found!
            _sigla = "";
            Read_Cursor.Close();
            m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
          }
        } // End If
      } else { // Else
        // * --- Select from qbe_tbcitta30
        SPBridge.HMCaller _h000000B5;
        _h000000B5 = new SPBridge.HMCaller();
        _h000000B5.Set("m_cVQRList",m_cVQRList);
        _h000000B5.Set("pCITTA",CPLib.LRTrim(pStatoCitta));
        _h000000B5.Set("pPROV",pProv);
        if (Cursor_qbe_tbcitta30!=null)
          Cursor_qbe_tbcitta30.Close();
        Cursor_qbe_tbcitta30 = new VQRHolder("qbe_tbcitta30",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000B5,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_tbcitta30.Eof())) {
          /* _sigla := qbe_tbcitta30->SIGLA */
          _sigla = Cursor_qbe_tbcitta30.GetString("SIGLA");
          Cursor_qbe_tbcitta30.Next();
        }
        m_cConnectivityError = Cursor_qbe_tbcitta30.ErrorMessage();
        Cursor_qbe_tbcitta30.Close();
        // * --- End Select
      } // End If
      /* Page Return _sigla */
      return _sigla;
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_tbcitta30!=null)
          Cursor_qbe_tbcitta30.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_pAnno,double p_pSem,String p_pPrimo) {
    pAnno = p_pAnno;
    pSem = p_pSem;
    pPrimo = p_pPrimo;
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
  public String Run(double p_pAnno,double p_pSem,String p_pPrimo) {
    pAnno = p_pAnno;
    pSem = p_pSem;
    pPrimo = p_pPrimo;
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
  public static arfn_oam_soggconv_xmlR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_oam_soggconv_xmlR(p_Ctx, p_Caller);
  }
  public static arfn_oam_soggconv_xmlR Make(CPContext p_Ctx) {
    return new arfn_oam_soggconv_xmlR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAnno = 0;
    pSem = 0;
    pPrimo = CPLib.Space(1);
    _datini = CPLib.Space(8);
    _datfin = CPLib.Space(8);
    cRitorno = CPLib.Space(20);
    fhand = CPLib.Space(1);
    riga = "";
    nFile = CPLib.Space(20);
    cNomeFileZip = CPLib.Space(30);
    cNomeZip = CPLib.Space(128);
    fname = CPLib.Space(35);
    pfname = CPLib.Space(128);
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    _totale = 0;
    _ioamcode = CPLib.Space(8);
    _ioamcodeR = CPLib.Space(8);
    _totleg = 0;
    _totvir = 0;
    zipname = CPLib.Space(0);
    pzipname = CPLib.Space(0);
    _statonas = CPLib.Space(4);
    mcMACAGE = new MemoryCursor_tbmacage();
    _numciv = CPLib.Space(20);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_tbcitta30,
  public static final String m_cVQRList = ",qbe_tbcitta30,";
  // ENTITY_BATCHES: ,arfn_fdate_bp,arfn_fdatetime,arfn_fdatetime_bp,arfn_oam_soggconv_xml,arfn_oamchar,
  public static final String i_InvokedRoutines = ",arfn_fdate_bp,arfn_fdatetime,arfn_fdatetime_bp,arfn_oam_soggconv_xml,arfn_oamchar,";
  public static String[] m_cRunParameterNames={"pAnno","pSem","pPrimo"};
}
