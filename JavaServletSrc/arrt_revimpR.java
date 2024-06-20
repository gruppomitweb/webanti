// * --- Area Manuale = BO - Header
// * --- arrt_revimp
import java.util.*;
// * --- Fine Area Manuale
public class arrt_revimpR implements CallerWithObjs {
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
  public String m_cPhName_xersonbo;
  public String m_cServer_xersonbo;
  public String m_cPhName_xnadip;
  public String m_cServer_xnadip;
  public String m_cPhName_xarchope;
  public String m_cServer_xarchope;
  public String m_cPhName_xarchfraz;
  public String m_cServer_xarchfraz;
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
  public String gPathApp;
  public String gPathDoc;
  public String gAzienda;
  public String gUrlApp;
  public String gMsgImp;
  public String gMsgProc;
  public String gFlgRet;
  public String fhand;
  public String _nomefile;
  public String riga;
  public double _conta;
  public String cNomeFileZip;
  public String _czip;
  public String _file1;
  public String _file2;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_revimp
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_revimpR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_revimp",m_Caller);
    m_cPhName_xersonbo = p_ContextObject.GetPhName("xersonbo");
    if (m_cPhName_xersonbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xersonbo = m_cPhName_xersonbo+" "+m_Ctx.GetWritePhName("xersonbo");
    }
    m_cServer_xersonbo = p_ContextObject.GetServer("xersonbo");
    m_cPhName_xnadip = p_ContextObject.GetPhName("xnadip");
    if (m_cPhName_xnadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xnadip = m_cPhName_xnadip+" "+m_Ctx.GetWritePhName("xnadip");
    }
    m_cServer_xnadip = p_ContextObject.GetServer("xnadip");
    m_cPhName_xarchope = p_ContextObject.GetPhName("xarchope");
    if (m_cPhName_xarchope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xarchope = m_cPhName_xarchope+" "+m_Ctx.GetWritePhName("xarchope");
    }
    m_cServer_xarchope = p_ContextObject.GetServer("xarchope");
    m_cPhName_xarchfraz = p_ContextObject.GetPhName("xarchfraz");
    if (m_cPhName_xarchfraz.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xarchfraz = m_cPhName_xarchfraz+" "+m_Ctx.GetWritePhName("xarchfraz");
    }
    m_cServer_xarchfraz = p_ContextObject.GetServer("xarchfraz");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_revimp";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gUrlApp",p_cVarName)) {
      return gUrlApp;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("gFlgRet",p_cVarName)) {
      return gFlgRet;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      return riga;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("_czip",p_cVarName)) {
      return _czip;
    }
    if (CPLib.eqr("_file1",p_cVarName)) {
      return _file1;
    }
    if (CPLib.eqr("_file2",p_cVarName)) {
      return _file2;
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
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
    if (CPLib.eqr("gFlgRet",p_cVarName)) {
      gFlgRet = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("riga",p_cVarName)) {
      riga = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("_czip",p_cVarName)) {
      _czip = value;
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
    /* gPathApp Char(80) // Path Applicazione */
    /* gPathDoc Char(80) // Path Applicazione */
    /* gAzienda Char(10) // Azienda */
    /* gUrlApp Char(80) // URL Applicazione */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    /* gFlgRet Char(1) // Flag Creazione File di Ritorno */
    /* fhand Char(10) */
    /* _nomefile Char(128) */
    /* riga Memo */
    /* _conta Numeric(10, 0) */
    /* cNomeFileZip Char(128) */
    /* _czip Char(128) */
    /* _file1 Char(30) */
    /* _file2 Char(30) */
    /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _czip := "revimp_"+DateToChar(Date())+".zip" */
    _czip = "revimp_"+CPLib.DateToChar(CPLib.Date())+".zip";
    /* cNomeFileZip := LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/"+_czip */
    cNomeFileZip = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+_czip;
    /* Exec "ArchDip" Page 5:Page_5 */
    Page_5();
    /* Exec "ArchPers" Page 2:Page_2 */
    Page_2();
    /* Exec "ArchOpe" Page 3:Page_3 */
    Page_3();
    /* Exec "ArchFraz" Page 4:Page_4 */
    Page_4();
    /* Exec "CreaZip" Page 6:Page_6 */
    Page_6();
    // * --- Write into intermbo from all
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("intermbo");
    m_cPhName = m_Ctx.GetPhName("intermbo");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"intermbo",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_revimp",36,"0000001B")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
    m_cSql = m_cSql+"SBLRITORNO = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
    m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+m_oWrInfo.WhereFilter("1=1");
    m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
    if (CPLib.lt(m_nUpdatedRows,0)) {
      m_Sql.AbortTransaction();
    }
    m_Sql.CompleteTransaction();
    m_cLastMsgError = m_Sql.TransactionErrorMessage();
    if (CPLib.ne(m_cLastMsgError,"")) {
      m_bError = true;
    }
    /* gMsgImp := 'Elaborazione Terminata' // Messaggio Import */
    gMsgImp = "Elaborazione Terminata";
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
    gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* cNomeFileZip := LRTrim(gPathDoc)+'//flussi//'+LRTrim(gAzienda)+"//"+_czip */
    cNomeFileZip = CPLib.LRTrim(gPathDoc)+"//flussi//"+CPLib.LRTrim(gAzienda)+"//"+_czip;
    /* Stop LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+LRTrim(cNomeFileZip) */
    Forward f;
    f=new Forward(CPLib.LRTrim(gUrlApp)+"servlet/DownloadFileDirect?fileName="+CPLib.LRTrim(cNomeFileZip),false,this,Forward.NoStatus,true);
    f.SetParameter("m_cParameterSequence", "");
    f.SetParameter("m_cMode","hyperlink");
    throw f;
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_ri_xersonbo=null;
    CPResultSet Cursor_xersonbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_ri_xersonbo
      if (Cursor_qbe_ri_xersonbo!=null)
        Cursor_qbe_ri_xersonbo.Close();
      Cursor_qbe_ri_xersonbo = new VQRHolder("qbe_ri_xersonbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_ri_xersonbo.Eof())) {
        /* _conta := qbe_ri_xersonbo->TOTALE */
        _conta = CPLib.Round(Cursor_qbe_ri_xersonbo.GetDouble("TOTALE"),0);
        Cursor_qbe_ri_xersonbo.Next();
      }
      m_cConnectivityError = Cursor_qbe_ri_xersonbo.ErrorMessage();
      Cursor_qbe_ri_xersonbo.Close();
      // * --- End Select
      /* If _conta > 0 */
      if (CPLib.gt(_conta,0)) {
        /* _nomefile := LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/archpers_rev.txt" */
        _nomefile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archpers_rev.txt";
        // These are the files to include in the ZIP file
        filenames.add(_nomefile);
        fileonames.add("archpers_rev.txt");
        /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/archpers_rev.txt") */
        fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archpers_rev.txt");
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File archpers_inv.txt: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione File archpers_inv.txt: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from xersonbo
        m_cServer = m_Ctx.GetServer("xersonbo");
        m_cPhName = m_Ctx.GetPhName("xersonbo");
        if (Cursor_xersonbo!=null)
          Cursor_xersonbo.Close();
        Cursor_xersonbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xersonbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"IDPROG ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_xersonbo.Eof())) {
          /* gMsgImp := 'Elaboro il soggetto: '+LRTrim(xersonbo->RAGSOC) // Messaggio Import */
          gMsgImp = "Elaboro il soggetto: "+CPLib.LRTrim(Cursor_xersonbo.GetString("RAGSOC"));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* riga := LibreriaMit.SpacePad(xersonbo->CODCAB,6) */
          riga = LibreriaMit.SpacePad(Cursor_xersonbo.GetString("CODCAB"),6);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->RAGSOC,70) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("RAGSOC"),70);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->DOMICILIO,35) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("DOMICILIO"),35);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->CODFISC,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("CODFISC"),16);
          /* riga := riga +LibreriaMit.SpacePad(xersonbo->DATANASC,8) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("DATANASC"),8);
          /* riga := riga + LibreriaMit.SpacePad(Left(xersonbo->NASCOMUN,30),30) */
          riga = riga+LibreriaMit.SpacePad(CPLib.Left(Cursor_xersonbo.GetString("NASCOMUN"),30),30);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->SOTGRUP,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("SOTGRUP"),3);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->RAMOGRUP,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("RAMOGRUP"),3);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->SETTSINT,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("SETTSINT"),3);
          /* riga := riga +LibreriaMit.SpacePad(xersonbo->TIPODOC,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("TIPODOC"),2);
          /* riga := riga +LibreriaMit.SpacePad(xersonbo->NUMDOCUM,15) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("NUMDOCUM"),15);
          /* riga := riga +LibreriaMit.SpacePad(xersonbo->DATARILASC,8) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("DATARILASC"),8);
          /* riga := riga +LibreriaMit.SpacePad(xersonbo->AUTRILASC,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("AUTRILASC"),30);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->DESCCIT,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("DESCCIT"),30);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->PROVINCIA,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("PROVINCIA"),2);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->PAESE,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("PAESE"),3);
          /* riga := riga + LibreriaMit.SpacePad(LRTrim(xersonbo->CAP),9) */
          riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_xersonbo.GetString("CAP")),9);
          /* riga := riga +LibreriaMit.SpacePad(xersonbo->PARTIVA,14) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("PARTIVA"),14);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->SESSO,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("SESSO"),1);
          /* riga := riga +LibreriaMit.SpacePad(xersonbo->DATAVALI,8) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("DATAVALI"),8);
          /* riga := riga + LibreriaMit.SpacePad(LRTrim(xersonbo->COGNOME),26) */
          riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_xersonbo.GetString("COGNOME")),26);
          /* riga := riga + LibreriaMit.SpacePad(LRTrim(xersonbo->NOME),25) */
          riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_xersonbo.GetString("NOME")),25);
          /* riga := riga + LibreriaMit.SpacePad(LRTrim(xersonbo->DOCFILE),100) */
          riga = riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_xersonbo.GetString("DOCFILE")),100);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->TIPINTER,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("TIPINTER"),2);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->CFESTERO,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("CFESTERO"),1);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->PKTBSPECIE,4) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("PKTBSPECIE"),4);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->COMPORT,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("COMPORT"),5);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->ATTIV,10) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("ATTIV"),10);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->AREAGEO,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("AREAGEO"),5);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->RNATGIU,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("RNATGIU"),3);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->RCOMP,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("RCOMP"),3);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->RATTIV,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("RATTIV"),3);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->RAREA,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("RAREA"),3);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->PEP,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("PEP"),1);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->CONNES,10) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("CONNES"),10);
          /* riga := riga +LibreriaMit.SpacePad(xersonbo->DATAVARAGE,8) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("DATAVARAGE"),8);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->FATCA,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("FATCA"),3);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->TIN,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("TIN"),16);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->ODB,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("ODB"),1);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->TELEF,15) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("TELEF"),15);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->TIPOORO,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("TIPOORO"),1);
          /* riga := riga + LibreriaMit.SpacePad(xersonbo->CODORO,11) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xersonbo.GetString("CODORO"),11);
          /* FileLibMit.WriteLine(fhand,Left(riga,559)) */
          FileLibMit.WriteLine(fhand,CPLib.Left(riga,559));
          Cursor_xersonbo.Next();
        }
        m_cConnectivityError = Cursor_xersonbo.ErrorMessage();
        Cursor_xersonbo.Close();
        // * --- End Select
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File archpers_inv.txt: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione File archpers_inv.txt: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_ri_xersonbo!=null)
          Cursor_qbe_ri_xersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xersonbo!=null)
          Cursor_xersonbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_ri_xarchope=null;
    CPResultSet Cursor_xarchope=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_ri_xarchope
      if (Cursor_qbe_ri_xarchope!=null)
        Cursor_qbe_ri_xarchope.Close();
      Cursor_qbe_ri_xarchope = new VQRHolder("qbe_ri_xarchope",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_ri_xarchope.Eof())) {
        /* _conta := qbe_ri_xarchope->TOTALE */
        _conta = CPLib.Round(Cursor_qbe_ri_xarchope.GetDouble("TOTALE"),0);
        Cursor_qbe_ri_xarchope.Next();
      }
      m_cConnectivityError = Cursor_qbe_ri_xarchope.ErrorMessage();
      Cursor_qbe_ri_xarchope.Close();
      // * --- End Select
      /* If _conta > 0 */
      if (CPLib.gt(_conta,0)) {
        /* _nomefile := LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/archope_rev.txt" */
        _nomefile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archope_rev.txt";
        // These are the files to include in the ZIP file
        filenames.add(_nomefile);
        fileonames.add("archope_rev.txt");
        /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/archope_rev.txt") */
        fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archope_rev.txt");
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File archope_inv.txt: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione File archope_inv.txt: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from xarchope
        m_cServer = m_Ctx.GetServer("xarchope");
        m_cPhName = m_Ctx.GetPhName("xarchope");
        if (Cursor_xarchope!=null)
          Cursor_xarchope.Close();
        Cursor_xarchope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xarchope")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"IDPROG ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_xarchope.Eof())) {
          /* gMsgImp := "Elaboro l'operazione: "+LRTrim(Str(xarchope->IDPROG,10,0)) // Messaggio Import */
          gMsgImp = "Elaboro l'operazione: "+CPLib.LRTrim(CPLib.Str(Cursor_xarchope.GetDouble("IDPROG"),10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* riga := LibreriaMit.SpacePad(xarchope->DATAOPE,8) */
          riga = LibreriaMit.SpacePad(Cursor_xarchope.GetString("DATAOPE"),8);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->FLAGCONT,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("FLAGCONT"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CODANA,4) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CODANA"),4);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CODVOC,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CODVOC"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->TIPOINT2,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("TIPOINT2"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CODINT2,11) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CODINT2"),11);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->PAESE,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("PAESE"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->DESC2,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("DESC2"),30);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->PROV2,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("PROV2"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CODCAB2,6) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CODCAB2"),6);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->DESCINTER,50) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("DESCINTER"),50);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RAPPORTO,25) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RAPPORTO"),25);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->FLAGRAP,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("FLAGRAP"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->TIPOLEG,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("TIPOLEG"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->DATAREG,8) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("DATAREG"),8);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->FLAGLIRE,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("FLAGLIRE"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->VALUTA,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("VALUTA"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->SEGNO,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("SEGNO"),1);
          /* riga := riga + Right(Space(15)+LRTrim(xarchope->TOTLIRE),15) */
          riga = riga+CPLib.Right(CPLib.Space(15)+CPLib.LRTrim(Cursor_xarchope.GetString("TOTLIRE")),15);
          /* riga := riga + Right(Space(15)+LRTrim(xarchope->TOTCONT),15) */
          riga = riga+CPLib.Right(CPLib.Space(15)+CPLib.LRTrim(Cursor_xarchope.GetString("TOTCONT")),15);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CONNESCLI,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CONNESCLI"),16);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CONNESOPER,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CONNESOPER"),16);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CAMBIO,9) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CAMBIO"),9);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->NUMPROG,11) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("NUMPROG"),11);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->TIPOOPRAP,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("TIPOOPRAP"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->TIPOINTER,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("TIPOINTER"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CODINTER,11) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CODINTER"),11);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CODDIPE,6) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CODDIPE"),6);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->DESCCIT,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("DESCCIT"),30);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->PROVINCIA,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("PROVINCIA"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CODCAB,6) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CODCAB"),6);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->FLAGFRAZ,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("FLAGFRAZ"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CONNESBEN,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CONNESBEN"),16);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->UNIQUECODE,10) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("UNIQUECODE"),10);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->AGOPER,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("AGOPER"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RIFIMP,9) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RIFIMP"),9);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->ZCPARTE,69) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("ZCPARTE"),69);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RAGIO,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RAGIO"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->MODSVOL,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("MODSVOL"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->AREAGEO,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("AREAGEO"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->INFORM,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("INFORM"),30);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->AMMONT,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("AMMONT"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->DURAT,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("DURAT"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->TIPO,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("TIPO"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RRAGIO,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RRAGIO"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RCOMP,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RCOMP"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RAREA,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RAREA"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RIMP,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RIMP"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RFREQ,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RFREQ"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->CONNALTRO,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("CONNALTRO"),16);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->DATAIMP,8) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("DATAIMP"),8);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RTIPO,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RTIPO"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->C_RAG,70) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("C_RAG"),70);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->C_STA,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("C_STA"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->C_CTA,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("C_CTA"),30);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->C_CAB,6) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("C_CAB"),6);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->C_PRV,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("C_PRV"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->C_IND,35) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("C_IND"),35);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->C_CAP,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("C_CAP"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->NATURA,50) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("NATURA"),50);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->SCOPO,50) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("SCOPO"),50);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->C_RAPPORTO,25) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("C_RAPPORTO"),25);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->RAPPORTBEN,25) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("RAPPORTBEN"),25);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->PAGASOGOP,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("PAGASOGOP"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->IPCOLLEG,15) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("IPCOLLEG"),15);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->ORACOLLEG,14) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("ORACOLLEG"),14);
          /* riga := riga + LibreriaMit.SpacePad(xarchope->DUCOLLEG,10) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchope.GetString("DUCOLLEG"),10);
          /* FileLibMit.WriteLine(fhand,Left(riga,851)) */
          FileLibMit.WriteLine(fhand,CPLib.Left(riga,851));
          Cursor_xarchope.Next();
        }
        m_cConnectivityError = Cursor_xarchope.ErrorMessage();
        Cursor_xarchope.Close();
        // * --- End Select
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File archope_inv.txt: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione File archope_inv.txt: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_ri_xarchope!=null)
          Cursor_qbe_ri_xarchope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xarchope!=null)
          Cursor_xarchope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_qbe_ri_xarchfraz=null;
    CPResultSet Cursor_xarchfraz=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_ri_xarchfraz
      if (Cursor_qbe_ri_xarchfraz!=null)
        Cursor_qbe_ri_xarchfraz.Close();
      Cursor_qbe_ri_xarchfraz = new VQRHolder("qbe_ri_xarchfraz",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_ri_xarchfraz.Eof())) {
        /* _conta := qbe_ri_xarchfraz->TOTALE */
        _conta = CPLib.Round(Cursor_qbe_ri_xarchfraz.GetDouble("TOTALE"),0);
        Cursor_qbe_ri_xarchfraz.Next();
      }
      m_cConnectivityError = Cursor_qbe_ri_xarchfraz.ErrorMessage();
      Cursor_qbe_ri_xarchfraz.Close();
      // * --- End Select
      /* If _conta > 0 */
      if (CPLib.gt(_conta,0)) {
        /* _nomefile := LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/archfraz_rev.txt" */
        _nomefile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archfraz_rev.txt";
        // These are the files to include in the ZIP file
        filenames.add(_nomefile);
        fileonames.add("archfraz_rev.txt");
        /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/archfraz_rev.txt") */
        fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archfraz_rev.txt");
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File archfraz_inv.txt: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione File archfraz_inv.txt: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from xarchfraz
        m_cServer = m_Ctx.GetServer("xarchfraz");
        m_cPhName = m_Ctx.GetPhName("xarchfraz");
        if (Cursor_xarchfraz!=null)
          Cursor_xarchfraz.Close();
        Cursor_xarchfraz = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xarchfraz")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"IDPROG ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_xarchfraz.Eof())) {
          /* gMsgImp := "Elaboro l'operazione: "+LRTrim(Str(xarchfraz->IDPROG,10,0)) // Messaggio Import */
          gMsgImp = "Elaboro l'operazione: "+CPLib.LRTrim(CPLib.Str(Cursor_xarchfraz.GetDouble("IDPROG"),10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* riga := LibreriaMit.SpacePad(xarchfraz->DATAOPE,8) */
          riga = LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("DATAOPE"),8);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->FLAGCONT,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("FLAGCONT"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CODANA,4) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CODANA"),4);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CODVOC,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CODVOC"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->TIPOINT2,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("TIPOINT2"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CODINT2,11) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CODINT2"),11);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->PAESE,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("PAESE"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->DESC2,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("DESC2"),30);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->PROV2,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("PROV2"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CODCAB2,6) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CODCAB2"),6);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->DESCINTER,50) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("DESCINTER"),50);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RAPPORTO,25) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RAPPORTO"),25);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->FLAGRAP,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("FLAGRAP"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->TIPOLEG,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("TIPOLEG"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->DATAREG,8) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("DATAREG"),8);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->FLAGLIRE,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("FLAGLIRE"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->VALUTA,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("VALUTA"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->SEGNO,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("SEGNO"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->TOTLIRE,15) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("TOTLIRE"),15);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->TOTCONT,15) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("TOTCONT"),15);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CONNESCLI,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CONNESCLI"),16);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CONNESOPER,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CONNESOPER"),16);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CAMBIO,9) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CAMBIO"),9);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->NUMPROG,11) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("NUMPROG"),11);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->TIPOOPRAP,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("TIPOOPRAP"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->TIPOINTER,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("TIPOINTER"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CODINTER,11) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CODINTER"),11);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CODDIPE,6) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CODDIPE"),6);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->DESCCIT,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("DESCCIT"),30);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->PROVINCIA,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("PROVINCIA"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CODCAB,6) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CODCAB"),6);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->FLAGFRAZ,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("FLAGFRAZ"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CONNESBEN,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CONNESBEN"),16);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->UNIQUECODE,10) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("UNIQUECODE"),10);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->AGOPER,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("AGOPER"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RIFIMP,9) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RIFIMP"),9);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->ZCPARTE,69) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("ZCPARTE"),69);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RAGIO,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RAGIO"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->MODSVOL,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("MODSVOL"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->AREAGEO,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("AREAGEO"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->INFORM,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("INFORM"),30);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->AMMONT,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("AMMONT"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->DURAT,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("DURAT"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->TIPO,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("TIPO"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RRAGIO,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RRAGIO"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RCOMP,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RCOMP"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RAREA,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RAREA"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RIMP,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RIMP"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RFREQ,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RFREQ"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->CONNALTRO,16) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("CONNALTRO"),16);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->DATAIMP,8) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("DATAIMP"),8);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RTIPO,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RTIPO"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->C_RAG,70) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("C_RAG"),70);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->C_STA,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("C_STA"),3);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->C_CTA,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("C_CTA"),30);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->C_CAB,6) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("C_CAB"),6);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->C_PRV,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("C_PRV"),2);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->C_IND,35) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("C_IND"),35);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->C_CAP,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("C_CAP"),5);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->NATURA,50) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("NATURA"),50);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->SCOPO,50) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("SCOPO"),50);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->C_RAPPORTO,25) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("C_RAPPORTO"),25);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->RAPPORTBEN,25) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("RAPPORTBEN"),25);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->PAGASOGOP,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("PAGASOGOP"),1);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->IPCOLLEG,15) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("IPCOLLEG"),15);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->ORACOLLEG,14) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("ORACOLLEG"),14);
          /* riga := riga + LibreriaMit.SpacePad(xarchfraz->DUCOLLEG,10) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xarchfraz.GetString("DUCOLLEG"),10);
          /* FileLibMit.WriteLine(fhand,Left(riga,851)) */
          FileLibMit.WriteLine(fhand,CPLib.Left(riga,851));
          Cursor_xarchfraz.Next();
        }
        m_cConnectivityError = Cursor_xarchfraz.ErrorMessage();
        Cursor_xarchfraz.Close();
        // * --- End Select
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File archfraz_inv.txt: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione File archfraz_inv.txt: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_ri_xarchfraz!=null)
          Cursor_qbe_ri_xarchfraz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xarchfraz!=null)
          Cursor_xarchfraz.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_5() throws Exception {
    CPResultSet Cursor_qbe_ri_xnadip=null;
    CPResultSet Cursor_xnadip=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _conta := 0 */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_ri_xnadip
      if (Cursor_qbe_ri_xnadip!=null)
        Cursor_qbe_ri_xnadip.Close();
      Cursor_qbe_ri_xnadip = new VQRHolder("qbe_ri_xnadip",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_ri_xnadip.Eof())) {
        /* _conta := qbe_ri_xnadip->TOTALE */
        _conta = CPLib.Round(Cursor_qbe_ri_xnadip.GetDouble("TOTALE"),0);
        Cursor_qbe_ri_xnadip.Next();
      }
      m_cConnectivityError = Cursor_qbe_ri_xnadip.ErrorMessage();
      Cursor_qbe_ri_xnadip.Close();
      // * --- End Select
      /* If _conta > 0 */
      if (CPLib.gt(_conta,0)) {
        /* _nomefile := LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/archdip_rev.txt" */
        _nomefile = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archdip_rev.txt";
        // These are the files to include in the ZIP file
        filenames.add(_nomefile);
        fileonames.add("archdip_rev.txt");
        /* fhand := FileLibMit.OpenWritePath(LRTrim(gPathDoc)+'/flussi/'+LRTrim(gAzienda)+"/archdip_rev.txt") */
        fhand = FileLibMit.OpenWritePath(CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/archdip_rev.txt");
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione File archdip_inv.txt: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione File archdip_inv.txt: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // * --- Select from xnadip
        m_cServer = m_Ctx.GetServer("xnadip");
        m_cPhName = m_Ctx.GetPhName("xnadip");
        if (Cursor_xnadip!=null)
          Cursor_xnadip.Close();
        Cursor_xnadip = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("xnadip")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"IDPROG ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_xnadip.Eof())) {
          /* gMsgImp := 'Elaboro la dipendenza '+LRTrim(xnadip->DESCRIZ) // Messaggio Import */
          gMsgImp = "Elaboro la dipendenza "+CPLib.LRTrim(Cursor_xnadip.GetString("DESCRIZ"));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* riga := LibreriaMit.SpacePad(xnadip->CODDIP,6) */
          riga = LibreriaMit.SpacePad(Cursor_xnadip.GetString("CODDIP"),6);
          /* riga := riga + LibreriaMit.SpacePad(xnadip->DESCRIZ,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xnadip.GetString("DESCRIZ"),30);
          /* riga := riga + LibreriaMit.SpacePad(xnadip->DESCCIT,30) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xnadip.GetString("DESCCIT"),30);
          /* riga := riga + LibreriaMit.SpacePad(xnadip->PROVINCIA,2) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xnadip.GetString("PROVINCIA"),2);
          /* riga := riga + LibreriaMit.SpacePad(xnadip->CAB,6) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xnadip.GetString("CAB"),6);
          /* riga := riga + LibreriaMit.SpacePad(xnadip->IDBASE,10) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xnadip.GetString("IDBASE"),10);
          /* riga := riga + LibreriaMit.SpacePad(xnadip->AGENTE,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_xnadip.GetString("AGENTE"),1);
          /* FileLibMit.WriteLine(fhand,Left(riga,85)) */
          FileLibMit.WriteLine(fhand,CPLib.Left(riga,85));
          Cursor_xnadip.Next();
        }
        m_cConnectivityError = Cursor_xnadip.ErrorMessage();
        Cursor_xnadip.Close();
        // * --- End Select
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione File archdip_inv.txt: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione File archdip_inv.txt: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } // End If
    } finally {
      try {
        if (Cursor_qbe_ri_xnadip!=null)
          Cursor_qbe_ri_xnadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_xnadip!=null)
          Cursor_xnadip.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_6() throws Exception {
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
                FileLibMit.DeleteFile("/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_file2));
            }
        
            // Complete the ZIP file
            out.close();
            filenames.removeAllElements();
            fileonames.removeAllElements();
        } catch (java.io.IOException e) {
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
  public static arrt_revimpR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_revimpR(p_Ctx, p_Caller);
  }
  public void Blank() {
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(128);
    riga = "";
    _conta = 0;
    cNomeFileZip = CPLib.Space(128);
    _czip = CPLib.Space(128);
    _file1 = CPLib.Space(30);
    _file2 = CPLib.Space(30);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gUrlApp=m_Ctx.GetGlobalString("gUrlApp");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gFlgRet=m_Ctx.GetGlobalString("gFlgRet");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_ri_xersonbo,qbe_ri_xarchope,qbe_ri_xarchfraz,qbe_ri_xnadip,
  public static final String m_cVQRList = ",qbe_ri_xersonbo,qbe_ri_xarchope,qbe_ri_xarchfraz,qbe_ri_xnadip,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
