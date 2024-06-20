// * --- Area Manuale = BO - Header
// * --- arfn_oam_vasp_xml
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
// * --- Fine Area Manuale
public class arfn_oam_vasp_xmlR implements CallerWithObjs {
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
  public double pTri;
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
  public double _conta;
  public String _vaspcode;
  public MemoryCursor_mcopevasp_mcrdef mcVASP;
  public double _totleg;
  public double _totvir;
  public String zipname;
  public String pzipname;
  public String _statonas;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_oam_vasp_xmlR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_oam_vasp_xml",m_Caller);
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
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      return pTri;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      return _totale;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
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
      return "arfn_oam_vasp_xml";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("_vaspcode",p_cVarName)) {
      return _vaspcode;
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
    if (CPLib.eqr("mcVASP",p_cVarName)) {
      return mcVASP;
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
    if (CPLib.eqr("pTri",p_cVarName)) {
      pTri = value;
      return;
    }
    if (CPLib.eqr("_totale",p_cVarName)) {
      _totale = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
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
    if (CPLib.eqr("_vaspcode",p_cVarName)) {
      _vaspcode = value;
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
    if (CPLib.eqr("mcVASP",p_cVarName)) {
      mcVASP = (MemoryCursor_mcopevasp_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_oper_vasp_totale_trim=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tbvasp=null;
    CPResultSet Cursor_qbe_oper_vasp_soggetti=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_qbe_vasp_operazioni=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pAnno Numeric(4, 0) // Anno di riferimento */
      /* pTri Numeric(1, 0) // Trimestre */
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
      /* _conta Numeric(1, 0) */
      /* _vaspcode Char(10) */
      /* mcVASP MemoryCursor(mcOPEVASP.MCRDef) */
      /* _totleg Numeric(12, 2) */
      /* _totvir Numeric(12, 2) */
      /* zipname Char(0) */
      /* pzipname Char(0) */
      /* _statonas Char(4) */
      /* Case pTri=1 */
      if (CPLib.eqr(pTri,1)) {
        /* _datini := Str(pAnno,4,0)+'0101' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"0101";
        /* _datfin := Str(pAnno,4,0)+'0331' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"0331";
        /* Case pTri=2 */
      } else if (CPLib.eqr(pTri,2)) {
        /* _datini := Str(pAnno,4,0)+'0401' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"0401";
        /* _datfin := Str(pAnno,4,0)+'0630' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"0630";
        /* Case pTri=3 */
      } else if (CPLib.eqr(pTri,3)) {
        /* _datini := Str(pAnno,4,0)+'0701' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"0701";
        /* _datfin := Str(pAnno,4,0)+'0930' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"0930";
        /* Case pTri=4 */
      } else if (CPLib.eqr(pTri,4)) {
        /* _datini := Str(pAnno,4,0)+'1001' // Data Inizio Trimestre */
        _datini = CPLib.Str(pAnno,4,0)+"1001";
        /* _datfin := Str(pAnno,4,0)+'1231' // Data Fine Trimestre */
        _datfin = CPLib.Str(pAnno,4,0)+"1231";
      } // End Case
      /* _ddatini := CharToDate(_datini) */
      _ddatini = CPLib.CharToDate(_datini);
      /* _ddatfin := CharToDate(_datfin) */
      _ddatfin = CPLib.CharToDate(_datfin);
      /* gMsgProc := "Inizio Creazione file XML per VASP: "+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = "Inizio Creazione file XML per VASP: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from qbe_oper_vasp_totale_trim
      SPBridge.HMCaller _h00000033;
      _h00000033 = new SPBridge.HMCaller();
      _h00000033.Set("m_cVQRList",m_cVQRList);
      _h00000033.Set("pDaData",_datini);
      _h00000033.Set("pA_Data",_datfin);
      if (Cursor_qbe_oper_vasp_totale_trim!=null)
        Cursor_qbe_oper_vasp_totale_trim.Close();
      Cursor_qbe_oper_vasp_totale_trim = new VQRHolder("qbe_oper_vasp_totale_trim",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000033,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_oper_vasp_totale_trim.Eof())) {
        /* _totale := _totale + qbe_oper_vasp_totale_trim->TOTALE */
        _totale = CPLib.Round(_totale+Cursor_qbe_oper_vasp_totale_trim.GetDouble("TOTALE"),0);
        Cursor_qbe_oper_vasp_totale_trim.Next();
      }
      m_cConnectivityError = Cursor_qbe_oper_vasp_totale_trim.ErrorMessage();
      Cursor_qbe_oper_vasp_totale_trim.Close();
      // * --- End Select
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODVASP  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _vaspcode := intermbo->CODVASP */
        _vaspcode = Cursor_intermbo.GetString("CODVASP");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* fname := "VASP."+LRTrim(_vaspcode)+"."+Str(pAnno,4,0)+"."+Str(pTri,1,0)+"."+DateToChar(Date())+".xml" */
      fname = "VASP."+CPLib.LRTrim(_vaspcode)+"."+CPLib.Str(pAnno,4,0)+"."+CPLib.Str(pTri,1,0)+"."+CPLib.DateToChar(CPLib.Date())+".xml";
      /* zipname := "VASP."+LRTrim(_vaspcode)+"."+Str(pAnno,4,0)+"."+Str(pTri,1,0)+"."+DateToChar(Date())+".zip" */
      zipname = "VASP."+CPLib.LRTrim(_vaspcode)+"."+CPLib.Str(pAnno,4,0)+"."+CPLib.Str(pTri,1,0)+"."+CPLib.DateToChar(CPLib.Date())+".zip";
      /* pfname := LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/"+LRTrim(fname) */
      pfname = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(fname);
      /* pzipname := LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/"+LRTrim(zipname) */
      pzipname = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(zipname);
      /* fhand := FileLibMit.OpenWritePath(pfname) // Per gestione file */
      fhand = FileLibMit.OpenWritePath(pfname);
      /* FileLibMit.WriteLine(fhand,'<?xml version="1.0" encoding="utf-8"?>') */
      FileLibMit.WriteLine(fhand,"<?xml version=\"1.0\" encoding=\"utf-8\"?>");
      /* FileLibMit.WriteLine(fhand,"<Transmission>") */
      FileLibMit.WriteLine(fhand,"<Transmission>");
      /* FileLibMit.WriteLine(fhand,"<Header>") */
      FileLibMit.WriteLine(fhand,"<Header>");
      /* FileLibMit.WriteLine(fhand,"<ProductionTime>"+arfn_fdatetime(DateTime(),'3')+" +01:00</ProductionTime>") */
      FileLibMit.WriteLine(fhand,"<ProductionTime>"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime(),"3")+" +01:00</ProductionTime>");
      /* FileLibMit.WriteLine(fhand,"<VaspRegistrationNumber>"+LRTrim(_vaspcode)+"</VaspRegistrationNumber>") */
      FileLibMit.WriteLine(fhand,"<VaspRegistrationNumber>"+CPLib.LRTrim(_vaspcode)+"</VaspRegistrationNumber>");
      /* FileLibMit.WriteLine(fhand,"<ReferencePeriod>") */
      FileLibMit.WriteLine(fhand,"<ReferencePeriod>");
      /* FileLibMit.WriteLine(fhand,"<TrasmissionYear>"+Str(pAnno,4,0)+"</TrasmissionYear>") */
      FileLibMit.WriteLine(fhand,"<TrasmissionYear>"+CPLib.Str(pAnno,4,0)+"</TrasmissionYear>");
      /* FileLibMit.WriteLine(fhand,"<TrasmissionQuarter>"+Str(pTri,1,0)+"</TrasmissionQuarter>") */
      FileLibMit.WriteLine(fhand,"<TrasmissionQuarter>"+CPLib.Str(pTri,1,0)+"</TrasmissionQuarter>");
      /* FileLibMit.WriteLine(fhand,"</ReferencePeriod>") */
      FileLibMit.WriteLine(fhand,"</ReferencePeriod>");
      /* FileLibMit.WriteLine(fhand,"</Header>") */
      FileLibMit.WriteLine(fhand,"</Header>");
      /* FileLibMit.WriteLine(fhand,"<Content>") */
      FileLibMit.WriteLine(fhand,"<Content>");
      /* If _totale > 0 */
      if (CPLib.gt(_totale,0)) {
        // * --- Fill memory cursor mcVASP on tbvasp
        mcVASP.Zap();
        m_cServer = m_Ctx.GetServer("tbvasp");
        m_cPhName = m_Ctx.GetPhName("tbvasp");
        if (Cursor_tbvasp!=null)
          Cursor_tbvasp.Close();
        Cursor_tbvasp = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select CODICE  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbvasp")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        {
          final CPResultSet m_TheCursor = Cursor_tbvasp;
          Cursor_tbvasp.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_oam_vasp_xml: query on tbvasp returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_tbvasp.Eof())) {
          mcVASP.AppendWithTrimmedKey(Cursor_tbvasp.GetString("CODICE"));
          mcVASP.row.CODICE = Cursor_tbvasp.GetString("CODICE");
          mcVASP.row.OPERAZIONI = 0;
          mcVASP.row.IMPORTO = 0;
          mcVASP.row.TOTIMPIN = 0;
          mcVASP.row.TOTIMPOUT = 0;
          Cursor_tbvasp.Next();
        }
        m_cConnectivityError = Cursor_tbvasp.ErrorMessage();
        Cursor_tbvasp.Close();
        mcVASP.GoTop();
        // * --- Select from qbe_oper_vasp_soggetti
        SPBridge.HMCaller _h00000050;
        _h00000050 = new SPBridge.HMCaller();
        _h00000050.Set("m_cVQRList",m_cVQRList);
        _h00000050.Set("pDaData",_datini);
        _h00000050.Set("pA_Data",_datfin);
        if (Cursor_qbe_oper_vasp_soggetti!=null)
          Cursor_qbe_oper_vasp_soggetti.Close();
        Cursor_qbe_oper_vasp_soggetti = new VQRHolder("qbe_oper_vasp_soggetti",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000050,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_oper_vasp_soggetti.Eof())) {
          /* gMsgProc := gMsgProc + "Elaborazione dati per il soggetto: "+LRTrim(qbe_oper_vasp_soggetti->RAGSOC) + NL // Messaggio */
          gMsgProc = gMsgProc+"Elaborazione dati per il soggetto: "+CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("RAGSOC"))+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgImp := "Estrazione dati del soggetto: "+LRTrim(qbe_oper_vasp_soggetti->RAGSOC) // Messaggio Import */
          gMsgImp = "Estrazione dati del soggetto: "+CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("RAGSOC"));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* _conta := _conta + 1 */
          _conta = CPLib.Round(_conta+1,0);
          /* FileLibMit.WriteLine(fhand,'<Record RecordSequenceId="'+LRTrim(Str(_conta,10,0))+'">') */
          FileLibMit.WriteLine(fhand,"<Record RecordSequenceId=\""+CPLib.LRTrim(CPLib.Str(_conta,10,0))+"\">");
          /* FileLibMit.WriteLine(fhand,'<Client ClietType="'+iif(qbe_oper_vasp_soggetti->TIPOPERS='P','PF','PNF')+'">') */
          FileLibMit.WriteLine(fhand,"<Client ClietType=\""+(CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("TIPOPERS"),"P")?"PF":"PNF")+"\">");
          /* If Empty(LRTrim(qbe_oper_vasp_soggetti->CODFISC)) or qbe_oper_vasp_soggetti->CFESTERO=1 */
          if (CPLib.Empty(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("CODFISC"))) || CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetDouble("CFESTERO"),1)) {
            /* FileLibMit.WriteLine(fhand,'<Data Name="CF_PIVA" Value="ND" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"CF_PIVA\" Value=\"ND\" />");
            /* If qbe_oper_vasp_soggetti->TIPOPERS='P' */
            if (CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("TIPOPERS"),"P")) {
              // * --- Read from tbstati
              m_cServer = m_Ctx.GetServer("tbstati");
              m_cPhName = m_Ctx.GetPhName("tbstati");
              m_cSql = "";
              m_cSql = m_cSql+"DESCRI="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_oper_vasp_soggetti.GetString("NASSTATO"),"C",40,0,m_cServer),m_cServer,Cursor_qbe_oper_vasp_soggetti.GetString("NASSTATO"));
              if (m_Ctx.IsSharedTemp("tbstati")) {
                m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
              }
              if (Read_Cursor!=null)
                Read_Cursor.Close();
              Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("SIGLA",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
              if ( ! (Read_Cursor.Eof())) {
                _statonas = Read_Cursor.GetString("SIGLA");
                Read_Cursor.Next();
                if ( ! (Read_Cursor.Eof())) {
                  Error l_oErrorFault = new Error("Read on tbstati into routine arfn_oam_vasp_xml returns two or more records. This item should return only a record.");
                  CPStdCounter.Error(l_oErrorFault);
                }
                Read_Cursor.Close();
              } else {
                // Error: no record found!
                _statonas = "";
                Read_Cursor.Close();
                m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
              }
            } // End If
          } else { // Else
            /* FileLibMit.WriteLine(fhand,'<Data Name="CF_PIVA" Value="'+LRTrim(qbe_oper_vasp_soggetti->CODFISC)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"CF_PIVA\" Value=\""+CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("CODFISC"))+"\" />");
            /* _statonas := iif(Empty(qbe_oper_vasp_soggetti->NASSTATO) or qbe_oper_vasp_soggetti->NASSTATO='ITALIA','Z086',Substr(LRTrim(qbe_oper_vasp_soggetti->CODFISC),12,4)) */
            _statonas = (CPLib.Empty(Cursor_qbe_oper_vasp_soggetti.GetString("NASSTATO")) || CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("NASSTATO"),"ITALIA")?"Z086":CPLib.Substr(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("CODFISC")),12,4));
          } // End If
          /* If qbe_oper_vasp_soggetti->TIPOPERS='P' */
          if (CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("TIPOPERS"),"P")) {
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_NOME" Value="'+LRTrim(qbe_oper_vasp_soggetti->NOME)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_NOME\" Value=\""+CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("NOME"))+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_COGNOME" Value="'+LRTrim(qbe_oper_vasp_soggetti->COGNOME)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_COGNOME\" Value=\""+CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("COGNOME"))+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_SESSO" Value="'+iif(qbe_oper_vasp_soggetti->SESSO='1','M','F')+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_SESSO\" Value=\""+(CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("SESSO"),"1")?"M":"F")+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_STATONASCITA" Value="'+LRTrim(_statonas)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_STATONASCITA\" Value=\""+CPLib.LRTrim(_statonas)+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_COMUNENASCITA" Value="'+iif(Empty(qbe_oper_vasp_soggetti->NASSTATO) or qbe_oper_vasp_soggetti->NASSTATO='ITALIA',Substr(LRTrim(qbe_oper_vasp_soggetti->CODFISC),12,4),'ND')+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_COMUNENASCITA\" Value=\""+(CPLib.Empty(Cursor_qbe_oper_vasp_soggetti.GetString("NASSTATO")) || CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("NASSTATO"),"ITALIA")?CPLib.Substr(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("CODFISC")),12,4):"ND")+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_DATANASCITA" Value="'+DateToChar(qbe_oper_vasp_soggetti->DATANASC)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_DATANASCITA\" Value=\""+CPLib.DateToChar(Cursor_qbe_oper_vasp_soggetti.GetDate("DATANASC"))+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_STATORESID" Value="'+iif(Empty(qbe_oper_vasp_soggetti->PAESE) or qbe_oper_vasp_soggetti->PAESE='086','Z086','')+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_STATORESID\" Value=\""+(CPLib.Empty(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE")) || CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE"),"086")?"Z086":"")+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_PROVRESID" Value="'+iif(Empty(qbe_oper_vasp_soggetti->PAESE) or qbe_oper_vasp_soggetti->PAESE='086',qbe_oper_vasp_soggetti->PROVINCIA,'EE')+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_PROVRESID\" Value=\""+(CPLib.Empty(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE")) || CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE"),"086")?Cursor_qbe_oper_vasp_soggetti.GetString("PROVINCIA"):"EE")+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_COMUNERESID" Value="'+iif(Empty(qbe_oper_vasp_soggetti->PAESE) or qbe_oper_vasp_soggetti->PAESE='086',LRTrim(qbe_oper_vasp_soggetti->DESCCIT),'ND')+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_COMUNERESID\" Value=\""+(CPLib.Empty(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE")) || CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE"),"086")?CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("DESCCIT")):"ND")+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_IND_RESID" Value="'+LRTrim(qbe_oper_vasp_soggetti->DOMICILIO)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_IND_RESID\" Value=\""+CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("DOMICILIO"))+"\" />");
            /* If At(qbe_oper_vasp_soggetti->TIPODOC,"|01|02|03|04") > 0 */
            if (CPLib.gt(CPLib.At(Cursor_qbe_oper_vasp_soggetti.GetString("TIPODOC"),"|01|02|03|04"),0)) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="PF_TIPO_DOC" Value="'+qbe_oper_vasp_soggetti->TIPODOC+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PF_TIPO_DOC\" Value=\""+Cursor_qbe_oper_vasp_soggetti.GetString("TIPODOC")+"\" />");
            } else { // Else
              /* FileLibMit.WriteLine(fhand,'<Data Name="PF_TIPO_DOC" Value="99" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PF_TIPO_DOC\" Value=\"99\" />");
            } // End If
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_DATA_DOC" Value="'+DateToChar(qbe_oper_vasp_soggetti->DATARILASC)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_DATA_DOC\" Value=\""+CPLib.DateToChar(Cursor_qbe_oper_vasp_soggetti.GetDate("DATARILASC"))+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_NUM_DOC" Value="'+LRTrim(qbe_oper_vasp_soggetti->NUMDOCUM)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_NUM_DOC\" Value=\""+CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("NUMDOCUM"))+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_AUT_DOC" Value="ND" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_AUT_DOC\" Value=\"ND\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_STATO_DOC" Value="ND" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_STATO_DOC\" Value=\"ND\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PF_COMUNE_DOC" Value="ND" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PF_COMUNE_DOC\" Value=\"ND\" />");
          } else { // Else
            /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_RAG_DENOM_SOC" Value="'+LRTrim(qbe_oper_vasp_soggetti->RAGSOC)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_RAG_DENOM_SOC\" Value=\""+CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("RAGSOC"))+"\" />");
            /* Case Upper(LRTrim(qbe_oper_vasp_soggetti->PKTBSPECIE))='SS' */
            if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("PKTBSPECIE"))),"SS")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_NAT_GIU" Value="01" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_NAT_GIU\" Value=\"01\" />");
              /* Case Upper(LRTrim(qbe_oper_vasp_soggetti->PKTBSPECIE))='SNC' */
            } else if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("PKTBSPECIE"))),"SNC")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_NAT_GIU" Value="02" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_NAT_GIU\" Value=\"02\" />");
              /* Case Upper(LRTrim(qbe_oper_vasp_soggetti->PKTBSPECIE))='SAS' */
            } else if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("PKTBSPECIE"))),"SAS")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_NAT_GIU" Value="03" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_NAT_GIU\" Value=\"03\" />");
              /* Case Upper(LRTrim(qbe_oper_vasp_soggetti->PKTBSPECIE))='SPA' */
            } else if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("PKTBSPECIE"))),"SPA")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_NAT_GIU" Value="04" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_NAT_GIU\" Value=\"04\" />");
              /* Case Upper(LRTrim(qbe_oper_vasp_soggetti->PKTBSPECIE))='SAA' */
            } else if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("PKTBSPECIE"))),"SAA")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_NAT_GIU" Value="05" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_NAT_GIU\" Value=\"05\" />");
              /* Case Upper(LRTrim(qbe_oper_vasp_soggetti->PKTBSPECIE))='SRL' or Upper(LRTrim(qbe_oper_vasp_soggetti->PKTBSPECIE))='SRLC' */
            } else if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("PKTBSPECIE"))),"SRL") || CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("PKTBSPECIE"))),"SRLC")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_NAT_GIU" Value="06" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_NAT_GIU\" Value=\"06\" />");
              /* Case Upper(LRTrim(qbe_oper_vasp_soggetti->PKTBSPECIE))='SRLS' */
            } else if (CPLib.eqr(CPLib.Upper(CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("PKTBSPECIE"))),"SRLS")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_NAT_GIU" Value="07" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_NAT_GIU\" Value=\"07\" />");
            } else { // Otherwise
              /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_NAT_GIU" Value="99" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_NAT_GIU\" Value=\"99\" />");
            } // End Case
            /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_STATOSEDLEG" Value="'+iif(Empty(qbe_oper_vasp_soggetti->PAESE) or qbe_oper_vasp_soggetti->PAESE='086','Z086','')+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_STATOSEDLEG\" Value=\""+(CPLib.Empty(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE")) || CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE"),"086")?"Z086":"")+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_PROVSEDLEG" Value="'+iif(Empty(qbe_oper_vasp_soggetti->PAESE) or qbe_oper_vasp_soggetti->PAESE='086',qbe_oper_vasp_soggetti->PROVINCIA,'EE')+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_PROVSEDLEG\" Value=\""+(CPLib.Empty(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE")) || CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE"),"086")?Cursor_qbe_oper_vasp_soggetti.GetString("PROVINCIA"):"EE")+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_COMUNESEDLEG" Value="'+iif(Empty(qbe_oper_vasp_soggetti->PAESE) or qbe_oper_vasp_soggetti->PAESE='086',LRTrim(qbe_oper_vasp_soggetti->DESCCIT),'ND')+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_COMUNESEDLEG\" Value=\""+(CPLib.Empty(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE")) || CPLib.eqr(Cursor_qbe_oper_vasp_soggetti.GetString("PAESE"),"086")?CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("DESCCIT")):"ND")+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_IND_SEDLEG" Value="'+LRTrim(qbe_oper_vasp_soggetti->DOMICILIO)+'" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_IND_SEDLEG\" Value=\""+CPLib.LRTrim(Cursor_qbe_oper_vasp_soggetti.GetString("DOMICILIO"))+"\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_STATOSEDAM" Value="ND" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_STATOSEDAM\" Value=\"ND\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_PROVSEDAM" Value="ND" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_PROVSEDAM\" Value=\"ND\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_COMUNESEDAM" Value="ND" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_COMUNESEDAM\" Value=\"ND\" />");
            /* FileLibMit.WriteLine(fhand,'<Data Name="PNF_IND_SEDAM" Value="ND" />') */
            FileLibMit.WriteLine(fhand,"<Data Name=\"PNF_IND_SEDAM\" Value=\"ND\" />");
          } // End If
          /* FileLibMit.WriteLine(fhand,'</Client>') */
          FileLibMit.WriteLine(fhand,"</Client>");
          /* FileLibMit.WriteLine(fhand,'<Operativity>') */
          FileLibMit.WriteLine(fhand,"<Operativity>");
          /* mcVASP.GoTop() */
          mcVASP.GoTop();
          /* While not(mcVASP.Eof()) */
          while ( ! (mcVASP.Eof())) {
            /* mcVASP.OPERAZIONI := 0 */
            mcVASP.row.OPERAZIONI = 0;
            /* mcVASP.IMPORTO := 0 */
            mcVASP.row.IMPORTO = 0;
            /* mcVASP.TOTIMPIN := 0 */
            mcVASP.row.TOTIMPIN = 0;
            /* mcVASP.TOTIMPOUT := 0 */
            mcVASP.row.TOTIMPOUT = 0;
            /* mcVASP.SaveRow() */
            mcVASP.SaveRow();
            /* mcVASP.Next() */
            mcVASP.Next();
          } // End While
          // * --- Select from qbe_vasp_operazioni
          SPBridge.HMCaller _h0000008F;
          _h0000008F = new SPBridge.HMCaller();
          _h0000008F.Set("m_cVQRList",m_cVQRList);
          _h0000008F.Set("pDaData",_datini);
          _h0000008F.Set("pA_Data",_datfin);
          _h0000008F.Set("pCONNESCLI",Cursor_qbe_oper_vasp_soggetti.GetString("CONNESCLI"));
          if (Cursor_qbe_vasp_operazioni!=null)
            Cursor_qbe_vasp_operazioni.Close();
          Cursor_qbe_vasp_operazioni = new VQRHolder("qbe_vasp_operazioni",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000008F,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_vasp_operazioni.Eof())) {
            /* If mcVASP.GoToKey(qbe_vasp_operazioni->VASP) */
            if (mcVASP.GoToKey(Cursor_qbe_vasp_operazioni.GetString("VASP"))) {
              /* mcVASP.OPERAZIONI := qbe_vasp_operazioni->TOTOPE */
              mcVASP.row.OPERAZIONI = Cursor_qbe_vasp_operazioni.GetDouble("TOTOPE");
              /* mcVASP.IMPORTO := qbe_vasp_operazioni->TOTIMP */
              mcVASP.row.IMPORTO = Cursor_qbe_vasp_operazioni.GetDouble("TOTIMP");
              /* mcVASP.TOTIMPIN := qbe_vasp_operazioni->TOTIMPIN */
              mcVASP.row.TOTIMPIN = Cursor_qbe_vasp_operazioni.GetDouble("TOTIMPIN");
              /* mcVASP.TOTIMPOUT := qbe_vasp_operazioni->TOTIMPOUT */
              mcVASP.row.TOTIMPOUT = Cursor_qbe_vasp_operazioni.GetDouble("TOTIMPOUT");
            } // End If
            Cursor_qbe_vasp_operazioni.Next();
          }
          m_cConnectivityError = Cursor_qbe_vasp_operazioni.ErrorMessage();
          Cursor_qbe_vasp_operazioni.Close();
          // * --- End Select
          MemoryCursor_mcopevasp_mcrdef cpmc_00000095;
          cpmc_00000095 = new MemoryCursor_mcopevasp_mcrdef();
          for (MemoryCursorRow_mcopevasp_mcrdef rwVASP : mcVASP._iterable_()) {
            cpmc_00000095.Append(rwVASP);
          }
          for (MemoryCursorRow_mcopevasp_mcrdef rwVASP : cpmc_00000095._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_mcopevasp_mcrdef>(){  public int compare(MemoryCursorRow_mcopevasp_mcrdef r1,MemoryCursorRow_mcopevasp_mcrdef r2){    if (CPLib.gt(r1.CODICE,r2.CODICE)) return 1;    if (CPLib.lt(r1.CODICE,r2.CODICE)) return -1;    return 0;  }})) {
            /* Case rwVASP.CODICE='01' */
            if (CPLib.eqr(rwVASP.CODICE,"01")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="NUM_OP_LEGAL2VIRTUAL" Value="'+iif(rwVASP.OPERAZIONI=0,'ND',LRTrim(Str(rwVASP.OPERAZIONI,10,0)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"NUM_OP_LEGAL2VIRTUAL\" Value=\""+(CPLib.eqr(rwVASP.OPERAZIONI,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.OPERAZIONI,10,0)))+"\" />");
              /* FileLibMit.WriteLine(fhand,'<Data Name="VAL_OP_LEGAL2VIRTUAL" Value="'+iif(rwVASP.IMPORTO=0,'ND',LRTrim(Str(rwVASP.IMPORTO,12,2)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"VAL_OP_LEGAL2VIRTUAL\" Value=\""+(CPLib.eqr(rwVASP.IMPORTO,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.IMPORTO,12,2)))+"\" />");
              /* _totleg := _totleg + rwVASP.TOTIMPIN */
              _totleg = CPLib.Round(_totleg+rwVASP.TOTIMPIN,2);
              /* _totvir := _totvir - rwVASP.TOTIMPOUT */
              _totvir = CPLib.Round(_totvir-rwVASP.TOTIMPOUT,2);
              /* Case rwVASP.CODICE='02' */
            } else if (CPLib.eqr(rwVASP.CODICE,"02")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="NUM_OP_VIRTUAL2LEGAL" Value="'+iif(rwVASP.OPERAZIONI=0,'ND',LRTrim(Str(rwVASP.OPERAZIONI,10,0)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"NUM_OP_VIRTUAL2LEGAL\" Value=\""+(CPLib.eqr(rwVASP.OPERAZIONI,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.OPERAZIONI,10,0)))+"\" />");
              /* FileLibMit.WriteLine(fhand,'<Data Name="VAL_OP_LEGAL2VIRTUAL" Value="'+iif(rwVASP.IMPORTO=0,'ND',Strtran(LRTrim(Str(rwVASP.IMPORTO,12,2)),'.',','))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"VAL_OP_LEGAL2VIRTUAL\" Value=\""+(CPLib.eqr(rwVASP.IMPORTO,0)?"ND":CPLib.Strtran(CPLib.LRTrim(CPLib.Str(rwVASP.IMPORTO,12,2)),".",","))+"\" />");
              /* _totleg := _totleg - rwVASP.TOTIMPOUT */
              _totleg = CPLib.Round(_totleg-rwVASP.TOTIMPOUT,2);
              /* _totvir := _totvir + rwVASP.TOTIMPIN */
              _totvir = CPLib.Round(_totvir+rwVASP.TOTIMPIN,2);
              /* Case rwVASP.CODICE='03' */
            } else if (CPLib.eqr(rwVASP.CODICE,"03")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="NUM_OP_VIRTUAL2VIRTUAL" Value="'+iif(rwVASP.OPERAZIONI=0,'ND',LRTrim(Str(rwVASP.OPERAZIONI,10,0)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"NUM_OP_VIRTUAL2VIRTUAL\" Value=\""+(CPLib.eqr(rwVASP.OPERAZIONI,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.OPERAZIONI,10,0)))+"\" />");
              /* Case rwVASP.CODICE='04' */
            } else if (CPLib.eqr(rwVASP.CODICE,"04")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="NUM_OP_OUTPUT_VIRTUAL" Value="'+iif(rwVASP.OPERAZIONI=0,'ND',LRTrim(Str(rwVASP.OPERAZIONI,10,0)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"NUM_OP_OUTPUT_VIRTUAL\" Value=\""+(CPLib.eqr(rwVASP.OPERAZIONI,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.OPERAZIONI,10,0)))+"\" />");
              /* _totvir := _totvir - rwVASP.IMPORTO */
              _totvir = CPLib.Round(_totvir-rwVASP.IMPORTO,2);
              /* Case rwVASP.CODICE='05' */
            } else if (CPLib.eqr(rwVASP.CODICE,"05")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="NUM_OP_INPUT_VIRTUAL" Value="'+iif(rwVASP.OPERAZIONI=0,'ND',LRTrim(Str(rwVASP.OPERAZIONI,10,0)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"NUM_OP_INPUT_VIRTUAL\" Value=\""+(CPLib.eqr(rwVASP.OPERAZIONI,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.OPERAZIONI,10,0)))+"\" />");
              /* _totvir := _totvir + rwVASP.IMPORTO */
              _totvir = CPLib.Round(_totvir+rwVASP.IMPORTO,2);
              /* Case rwVASP.CODICE='06' */
            } else if (CPLib.eqr(rwVASP.CODICE,"06")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="NUM_OP_OUTPUT_FIATCASH" Value="'+iif(rwVASP.OPERAZIONI=0,'ND',LRTrim(Str(rwVASP.OPERAZIONI,10,0)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"NUM_OP_OUTPUT_FIATCASH\" Value=\""+(CPLib.eqr(rwVASP.OPERAZIONI,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.OPERAZIONI,10,0)))+"\" />");
              /* FileLibMit.WriteLine(fhand,'<Data Name="VAL_OP_OUTPUT_FIATCASH" Value="'+iif(rwVASP.IMPORTO=0,'ND',Strtran(LRTrim(Str(rwVASP.IMPORTO,12,2)),'.',','))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"VAL_OP_OUTPUT_FIATCASH\" Value=\""+(CPLib.eqr(rwVASP.IMPORTO,0)?"ND":CPLib.Strtran(CPLib.LRTrim(CPLib.Str(rwVASP.IMPORTO,12,2)),".",","))+"\" />");
              /* _totleg := _totleg - rwVASP.IMPORTO */
              _totleg = CPLib.Round(_totleg-rwVASP.IMPORTO,2);
              /* Case rwVASP.CODICE='07' */
            } else if (CPLib.eqr(rwVASP.CODICE,"07")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="NUM_OP_OUTPUT_TRACEABLE" Value="'+iif(rwVASP.OPERAZIONI=0,'ND',LRTrim(Str(rwVASP.OPERAZIONI,10,0)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"NUM_OP_OUTPUT_TRACEABLE\" Value=\""+(CPLib.eqr(rwVASP.OPERAZIONI,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.OPERAZIONI,10,0)))+"\" />");
              /* FileLibMit.WriteLine(fhand,'<Data Name="VAL_OP_OUTPUT_TRACEABLE" Value="'+iif(rwVASP.IMPORTO=0,'ND',Strtran(LRTrim(Str(rwVASP.IMPORTO,12,2)),'.',','))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"VAL_OP_OUTPUT_TRACEABLE\" Value=\""+(CPLib.eqr(rwVASP.IMPORTO,0)?"ND":CPLib.Strtran(CPLib.LRTrim(CPLib.Str(rwVASP.IMPORTO,12,2)),".",","))+"\" />");
              /* Case rwVASP.CODICE='08' */
            } else if (CPLib.eqr(rwVASP.CODICE,"08")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="NUM_OP_INPUT_FIATCASH" Value="'+iif(rwVASP.OPERAZIONI=0,'ND',LRTrim(Str(rwVASP.OPERAZIONI,10,0)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"NUM_OP_INPUT_FIATCASH\" Value=\""+(CPLib.eqr(rwVASP.OPERAZIONI,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.OPERAZIONI,10,0)))+"\" />");
              /* FileLibMit.WriteLine(fhand,'<Data Name="VAL_OP_INPUT_FIATCASH" Value="'+iif(rwVASP.IMPORTO=0,'ND',Strtran(LRTrim(Str(rwVASP.IMPORTO,12,2)),'.',','))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"VAL_OP_INPUT_FIATCASH\" Value=\""+(CPLib.eqr(rwVASP.IMPORTO,0)?"ND":CPLib.Strtran(CPLib.LRTrim(CPLib.Str(rwVASP.IMPORTO,12,2)),".",","))+"\" />");
              /* _totleg := _totleg + rwVASP.IMPORTO */
              _totleg = CPLib.Round(_totleg+rwVASP.IMPORTO,2);
              /* Case rwVASP.CODICE='09' */
            } else if (CPLib.eqr(rwVASP.CODICE,"09")) {
              /* FileLibMit.WriteLine(fhand,'<Data Name="NUM_OP_INPUT_TRACEABLE" Value="'+iif(rwVASP.OPERAZIONI=0,'ND',LRTrim(Str(rwVASP.OPERAZIONI,10,0)))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"NUM_OP_INPUT_TRACEABLE\" Value=\""+(CPLib.eqr(rwVASP.OPERAZIONI,0)?"ND":CPLib.LRTrim(CPLib.Str(rwVASP.OPERAZIONI,10,0)))+"\" />");
              /* FileLibMit.WriteLine(fhand,'<Data Name="VAL_OP_INPUT_TRACEABLE" Value="'+iif(rwVASP.IMPORTO=0,'ND',Strtran(LRTrim(Str(rwVASP.IMPORTO,12,2)),'.',','))+'" />') */
              FileLibMit.WriteLine(fhand,"<Data Name=\"VAL_OP_INPUT_TRACEABLE\" Value=\""+(CPLib.eqr(rwVASP.IMPORTO,0)?"ND":CPLib.Strtran(CPLib.LRTrim(CPLib.Str(rwVASP.IMPORTO,12,2)),".",","))+"\" />");
            } // End Case
          }
          /* FileLibMit.WriteLine(fhand,'<Data Name="VAL_LEGALVALUT" Value="'+iif(_totleg=0,'ND',Strtran(LRTrim(Str(_totleg,12,2)),'.',','))+'" />') */
          FileLibMit.WriteLine(fhand,"<Data Name=\"VAL_LEGALVALUT\" Value=\""+(CPLib.eqr(_totleg,0)?"ND":CPLib.Strtran(CPLib.LRTrim(CPLib.Str(_totleg,12,2)),".",","))+"\" />");
          /* FileLibMit.WriteLine(fhand,'<Data Name="VAL_VIRTUALVALUT" Value="'+iif(_totvir=0,'ND',Strtran(LRTrim(Str(_totvir,12,2)),'.',','))+'" />') */
          FileLibMit.WriteLine(fhand,"<Data Name=\"VAL_VIRTUALVALUT\" Value=\""+(CPLib.eqr(_totvir,0)?"ND":CPLib.Strtran(CPLib.LRTrim(CPLib.Str(_totvir,12,2)),".",","))+"\" />");
          /* FileLibMit.WriteLine(fhand,'</Operativity>') */
          FileLibMit.WriteLine(fhand,"</Operativity>");
          /* FileLibMit.WriteLine(fhand,'</Record>') */
          FileLibMit.WriteLine(fhand,"</Record>");
          Cursor_qbe_oper_vasp_soggetti.Next();
        }
        m_cConnectivityError = Cursor_qbe_oper_vasp_soggetti.ErrorMessage();
        Cursor_qbe_oper_vasp_soggetti.Close();
        // * --- End Select
      } else { // Else
        /* gMsgProc := gMsgProc + "Non ci sono operazioni da elaborare per il periodo selezionato!"+NL // Messaggio */
        gMsgProc = gMsgProc+"Non ci sono operazioni da elaborare per il periodo selezionato!"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + "Creazione della comunicazione negativa!"+NL // Messaggio */
        gMsgProc = gMsgProc+"Creazione della comunicazione negativa!"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* FileLibMit.WriteLine(fhand,"<NoRecord></NoRecord>") */
        FileLibMit.WriteLine(fhand,"<NoRecord></NoRecord>");
      } // End If
      /* FileLibMit.WriteLine(fhand,"</Content>") */
      FileLibMit.WriteLine(fhand,"</Content>");
      /* FileLibMit.WriteLine(fhand,"</Transmission>") */
      FileLibMit.WriteLine(fhand,"</Transmission>");
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := gMsgProc + "Fine Creazione file XML per VASP: "+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = gMsgProc+"Fine Creazione file XML per VASP: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + "Inizio Creazione file ZIP per VASP: "+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = gMsgProc+"Inizio Creazione file ZIP per VASP: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
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
      /* gMsgProc := gMsgProc + "Fine Creazione file ZIP per VASP: "+arfn_fdatetime(DateTime()) + NL // Messaggio */
      gMsgProc = gMsgProc+"Fine Creazione file ZIP per VASP: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgImp := "Elaborazione Terminata! Premere il tasto Download per prelevare il file" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata! Premere il tasto Download per prelevare il file";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* Return zipname */
      throw new Stop(zipname);
    } finally {
      try {
        if (Cursor_qbe_oper_vasp_totale_trim!=null)
          Cursor_qbe_oper_vasp_totale_trim.Close();
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
        if (Cursor_tbvasp!=null)
          Cursor_tbvasp.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_oper_vasp_soggetti!=null)
          Cursor_qbe_oper_vasp_soggetti.Close();
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
        if (Cursor_qbe_vasp_operazioni!=null)
          Cursor_qbe_vasp_operazioni.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_pAnno,double p_pTri) {
    pAnno = p_pAnno;
    pTri = p_pTri;
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
  public String Run(double p_pAnno,double p_pTri) {
    pAnno = p_pAnno;
    pTri = p_pTri;
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
  public static arfn_oam_vasp_xmlR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_oam_vasp_xmlR(p_Ctx, p_Caller);
  }
  public static arfn_oam_vasp_xmlR Make(CPContext p_Ctx) {
    return new arfn_oam_vasp_xmlR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAnno = 0;
    pTri = 0;
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
    _conta = 0;
    _vaspcode = CPLib.Space(10);
    mcVASP = new MemoryCursor_mcopevasp_mcrdef();
    _totleg = 0;
    _totvir = 0;
    zipname = CPLib.Space(0);
    pzipname = CPLib.Space(0);
    _statonas = CPLib.Space(4);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_oper_vasp_totale_trim,qbe_oper_vasp_soggetti,qbe_vasp_operazioni,
  public static final String m_cVQRList = ",qbe_oper_vasp_totale_trim,qbe_oper_vasp_soggetti,qbe_vasp_operazioni,";
  // ENTITY_BATCHES: ,arfn_fdatetime,arfn_oam_vasp_xml,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arfn_oam_vasp_xml,";
  public static String[] m_cRunParameterNames={"pAnno","pTri"};
}
