// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_estrai_bp_wuR implements CallerWithObjs {
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
  public String m_cPhName_tbprovsv;
  public String m_cServer_tbprovsv;
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
  public double pMese;
  public String _datini;
  public String _datfin;
  public String cRitorno;
  public String fhand;
  public String riga;
  public String nFile;
  public double conta;
  public String cNomeFileZip;
  public String cNomeZip;
  public String fname;
  public String pfname;
  public double _importo;
  public java.sql.Date _ddatini;
  public java.sql.Date _ddatfin;
  public MemoryCursor_qbe_estrai_bp_wu_vqr mcDati;
  public MemoryCursor_tbprovsv mcProvSV;
  public MemoryCursor_tbstati mcStati;
  public String gAzienda;
  public String gIntemediario;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_estrai_bp_wuR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_estrai_bp_wu",m_Caller);
    m_cPhName_tbprovsv = p_ContextObject.GetPhName("tbprovsv");
    if (m_cPhName_tbprovsv.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tbprovsv = m_cPhName_tbprovsv+" "+m_Ctx.GetWritePhName("tbprovsv");
    }
    m_cServer_tbprovsv = p_ContextObject.GetServer("tbprovsv");
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
    if (CPLib.eqr("pMese",p_cVarName)) {
      return pMese;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      return _importo;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_estrai_bp_wu";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
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
    if (CPLib.eqr("mcDati",p_cVarName)) {
      return mcDati;
    }
    if (CPLib.eqr("mcProvSV",p_cVarName)) {
      return mcProvSV;
    }
    if (CPLib.eqr("mcStati",p_cVarName)) {
      return mcStati;
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
    if (CPLib.eqr("pMese",p_cVarName)) {
      pMese = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_importo",p_cVarName)) {
      _importo = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
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
    if (CPLib.eqr("mcDati",p_cVarName)) {
      mcDati = (MemoryCursor_qbe_estrai_bp_wu_vqr)value;
      return;
    }
    if (CPLib.eqr("mcProvSV",p_cVarName)) {
      mcProvSV = (MemoryCursor_tbprovsv)value;
      return;
    }
    if (CPLib.eqr("mcStati",p_cVarName)) {
      mcStati = (MemoryCursor_tbstati)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_tbprovsv=null;
    CPResultSet Cursor_tbstati=null;
    CPResultSet Cursor_qbe_estrai_bp_wu=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pAnno Numeric(4, 0) // Anno di riferimento */
      /* pMese Numeric(2, 0) // Trimestre */
      /* _datini Char(8) // Data Inizio Trimestre */
      /* _datfin Char(8) // Data Fine Trimestre */
      /* cRitorno Char(20) */
      /* fhand Char(1) // Per gestione file */
      /* riga Memo */
      /* nFile Char(20) */
      /* conta Numeric(10, 0) */
      /* cNomeFileZip Char(30) */
      /* cNomeZip Char(128) */
      /* fname Char(25) */
      /* pfname Char(128) */
      /* _importo Numeric(18, 2) */
      /* _ddatini Date */
      /* _ddatfin Date */
      /* mcDati MemoryCursor(qbe_estrai_bp_wu.vqr) */
      /* mcProvSV MemoryCursor(tbprovsv) */
      /* mcStati MemoryCursor(tbstati) */
      /* gAzienda Char(10) // Azienda */
      /* gIntemediario Char(11) // Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
      /* _datini := Str(pAnno,4,0)+Right('00'+LRTrim(Str(pMese,2,0)),2)+'01' // Data Inizio Trimestre */
      _datini = CPLib.Str(pAnno,4,0)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(pMese,2,0)),2)+"01";
      /* _ddatini := CharToDate(_datini) */
      _ddatini = CPLib.CharToDate(_datini);
      /* _ddatfin := arfn_finemese(_ddatini) // Data Inizio Trimestre */
      _ddatfin = arfn_finemeseR.Make(m_Ctx,this).Run(_ddatini);
      /* _datfin := DateToChar(_ddatfin) */
      _datfin = CPLib.DateToChar(_ddatfin);
      // * --- Fill memory cursor mcProvSV on tbprovsv
      mcProvSV.Zap();
      m_cServer = m_Ctx.GetServer("tbprovsv");
      m_cPhName = m_Ctx.GetPhName("tbprovsv");
      if (Cursor_tbprovsv!=null)
        Cursor_tbprovsv.Close();
      Cursor_tbprovsv = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbprovsv")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbprovsv;
        Cursor_tbprovsv.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arfn_estrai_bp_wu: query on tbprovsv returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbprovsv.Eof())) {
        mcProvSV.AppendWithTrimmedKey(Cursor_tbprovsv.GetString("SIGLA"));
        mcProvSV.row.SIGLA = Cursor_tbprovsv.GetString("SIGLA");
        mcProvSV.row.PROVINCIA = Cursor_tbprovsv.GetString("PROVINCIA");
        mcProvSV.row.SIGLASV = Cursor_tbprovsv.GetString("SIGLASV");
        Cursor_tbprovsv.Next();
      }
      m_cConnectivityError = Cursor_tbprovsv.ErrorMessage();
      Cursor_tbprovsv.Close();
      mcProvSV.GoTop();
      // * --- Fill memory cursor mcStati on tbstati
      mcStati.Zap();
      m_cServer = m_Ctx.GetServer("tbstati");
      m_cPhName = m_Ctx.GetPhName("tbstati");
      if (Cursor_tbstati!=null)
        Cursor_tbstati.Close();
      Cursor_tbstati = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tbstati")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      {
        final CPResultSet m_TheCursor = Cursor_tbstati;
        Cursor_tbstati.ActionOnClose(new Runnable() {
          public void run() {
            if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
              com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
              if ( ! (CPLib.IsNull(info))) {
                info.log("Routine arfn_estrai_bp_wu: query on tbstati returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
              }
            }
          }
          });
      }
      while ( ! (Cursor_tbstati.Eof())) {
        mcStati.AppendWithTrimmedKey(Cursor_tbstati.GetString("CODSTA"));
        mcStati.row.CODSTA = Cursor_tbstati.GetString("CODSTA");
        mcStati.row.DESCRI = Cursor_tbstati.GetString("DESCRI");
        mcStati.row.SIGLA = Cursor_tbstati.GetString("SIGLA");
        mcStati.row.ISO = Cursor_tbstati.GetString("ISO");
        mcStati.row.ISO2 = Cursor_tbstati.GetString("ISO2");
        mcStati.row.IDTBLS = Cursor_tbstati.GetString("IDTBLS");
        mcStati.row.IDBASE = Cursor_tbstati.GetString("IDBASE");
        mcStati.row.FLGSAE = Cursor_tbstati.GetString("FLGSAE");
        mcStati.row.ISON = Cursor_tbstati.GetString("ISON");
        Cursor_tbstati.Next();
      }
      m_cConnectivityError = Cursor_tbstati.ErrorMessage();
      Cursor_tbstati.Close();
      mcStati.GoTop();
      /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* nFile := LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_"+Right('00'+LRTrim(Str(pMese,2,0)),2)+".xml" */
      nFile = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_"+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(pMese,2,0)),2)+".xml";
      /* fhand := FileLibMit.OpenWrite("export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile)) // Per gestione file */
      fhand = FileLibMit.OpenWrite("export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile));
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      double nTry00000028status;
      nTry00000028status = m_Sql.GetTransactionStatus();
      String cTry00000028msg;
      cTry00000028msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Fill memory cursor mcDati on qbe_estrai_bp_wu
        mcDati.Zap();
        SPBridge.HMCaller _h00000029;
        _h00000029 = new SPBridge.HMCaller();
        _h00000029.Set("m_cVQRList",m_cVQRList);
        _h00000029.Set("pDADATA",_ddatini);
        _h00000029.Set("pA_DATA",_ddatfin);
        if (Cursor_qbe_estrai_bp_wu!=null)
          Cursor_qbe_estrai_bp_wu.Close();
        Cursor_qbe_estrai_bp_wu = new VQRHolder("qbe_estrai_bp_wu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000029,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_estrai_bp_wu;
          Cursor_qbe_estrai_bp_wu.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_estrai_bp_wu: query on qbe_estrai_bp_wu returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_estrai_bp_wu.Eof())) {
          mcDati.AppendBlank();
          mcDati.row.SEGNO = Cursor_qbe_estrai_bp_wu.GetString("SEGNO");
          mcDati.row.PROVINCIA1 = Cursor_qbe_estrai_bp_wu.GetString("PROVINCIA1");
          mcDati.row.PAESE = Cursor_qbe_estrai_bp_wu.GetString("PAESE");
          mcDati.row.IMPORTO = Cursor_qbe_estrai_bp_wu.GetDouble("IMPORTO");
          mcDati.row.NUMOPE = Cursor_qbe_estrai_bp_wu.GetDouble("NUMOPE");
          Cursor_qbe_estrai_bp_wu.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_bp_wu.ErrorMessage();
        Cursor_qbe_estrai_bp_wu.Close();
        mcDati.GoTop();
        /* riga := '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>' + NL */
        riga = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"+"\n";
        /* riga := riga + '<message xmlns:ns2="http://www.bankitalia.it/bolina/common/vo/cube" xmlns="http://www.bankitalia.it/bolina/common/vo/message">' + NL */
        riga = riga+"<message xmlns:ns2=\"http://www.bankitalia.it/bolina/common/vo/cube\" xmlns=\"http://www.bankitalia.it/bolina/common/vo/message\">"+"\n";
        /* riga := riga + '<header>' */
        riga = riga+"<header>";
        /* riga := riga + '<survey>9</survey>' + NL */
        riga = riga+"<survey>9</survey>"+"\n";
        /* riga := riga + '<partner>121004</partner>' + NL */
        riga = riga+"<partner>121004</partner>"+"\n";
        /* riga := riga + '<initialDate>' + Left(_datfin,4) + '-' + Substr(_datfin,5,2) + '-' + Right(_datfin,2) + '</initialDate>' + NL */
        riga = riga+"<initialDate>"+CPLib.Left(_datfin,4)+"-"+CPLib.Substr(_datfin,5,2)+"-"+CPLib.Right(_datfin,2)+"</initialDate>"+"\n";
        /* riga := riga + '<timeProduction>'+arfn_fdatetime_bp(DateTime()) +'</timeProduction>' + NL */
        riga = riga+"<timeProduction>"+arfn_fdatetime_bpR.Make(m_Ctx,this).Run(CPLib.DateTime())+"</timeProduction>"+"\n";
        /* riga := riga + '<type>SUBSTITUTION</type>' + NL */
        riga = riga+"<type>SUBSTITUTION</type>"+"\n";
        /* riga := riga + '</header>' + NL */
        riga = riga+"</header>"+"\n";
        /* riga := riga + '<content>' + NL */
        riga = riga+"<content>"+"\n";
        /* riga := riga + '<dataSegment id="OBSERVATION">' + NL */
        riga = riga+"<dataSegment id=\"OBSERVATION\">"+"\n";
        /* riga := riga + '<cube lastObsId="'+LRTrim(Str(mcDati.RecCount() - 1,10,0))+'" id="9_1905510" xmlns="http://www.bankitalia.it/bolina/common/vo/cube">' */
        riga = riga+"<cube lastObsId=\""+CPLib.LRTrim(CPLib.Str(mcDati.RecCount()-1,10,0))+"\" id=\"9_1905510\" xmlns=\"http://www.bankitalia.it/bolina/common/vo/cube\">";
        /* FileLibMit.WriteLine(fhand,riga) */
        FileLibMit.WriteLine(fhand,riga);
        /* conta := 0 */
        conta = CPLib.Round(0,0);
        for (MemoryCursorRow_qbe_estrai_bp_wu_vqr rowDati : mcDati._iterable_()) {
          /* riga := '<obs id ="'+LRTrim(Str(conta,10,0))+'">' + NL */
          riga = "<obs id =\""+CPLib.LRTrim(CPLib.Str(conta,10,0))+"\">"+"\n";
          /* riga := riga + '<dim name="ENTE_SEGN" value="12100"/>' + NL */
          riga = riga+"<dim name=\"ENTE_SEGN\" value=\"12100\"/>"+"\n";
          /* riga := riga + '<dim name="DATA_CONTABILE" value="'+_datfin+'"/>' + NL */
          riga = riga+"<dim name=\"DATA_CONTABILE\" value=\""+_datfin+"\"/>"+"\n";
          /* riga := riga + '<dim name="TIPO_OPERAZIONE" value="'+iif(rowDati.SEGNO='D','191','190')+'"/>' + NL */
          riga = riga+"<dim name=\"TIPO_OPERAZIONE\" value=\""+(CPLib.eqr(rowDati.SEGNO,"D")?"191":"190")+"\"/>"+"\n";
          /* If mcProvSV.GoToKey(rowDati.PROVINCIA1) */
          if (mcProvSV.GoToKey(rowDati.PROVINCIA1)) {
            /* riga := riga + '<dim name="PROVINCIA" value="'+LRTrim(Str(Val(mcProvSV.SIGLASV),5,0))+'"/>' + NL */
            riga = riga+"<dim name=\"PROVINCIA\" value=\""+CPLib.LRTrim(CPLib.Str(CPLib.Val(mcProvSV.row.SIGLASV),5,0))+"\"/>"+"\n";
          } // End If
          /* If mcStati.GoToKey(rowDati.PAESE) */
          if (mcStati.GoToKey(rowDati.PAESE)) {
            /* riga := riga + '<dim name="STATO_CTP" value="'+mcStati.ISO2+'"/>' + NL */
            riga = riga+"<dim name=\"STATO_CTP\" value=\""+mcStati.row.ISO2+"\"/>"+"\n";
          } // End If
          /* _importo := Round(rowDati.IMPORTO/100,0) */
          _importo = CPLib.Round(CPLib.Round(rowDati.IMPORTO/100,0),2);
          /* riga := riga + '<dim name="IMPORTO_OPERAZIONE" value="'+LRTrim(Str(_importo,18,0))+'"/>' + NL */
          riga = riga+"<dim name=\"IMPORTO_OPERAZIONE\" value=\""+CPLib.LRTrim(CPLib.Str(_importo,18,0))+"\"/>"+"\n";
          /* riga := riga + '<dim name="NUM_SEGN" value="'+LRTrim(Str(rowDati.NUMOPE,10,0))+'"/>' + NL */
          riga = riga+"<dim name=\"NUM_SEGN\" value=\""+CPLib.LRTrim(CPLib.Str(rowDati.NUMOPE,10,0))+"\"/>"+"\n";
          /* riga := riga + '</obs>' */
          riga = riga+"</obs>";
          /* FileLibMit.WriteLine(fhand,riga) */
          FileLibMit.WriteLine(fhand,riga);
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
        }
        /* riga := '</cube>' + NL */
        riga = "</cube>"+"\n";
        /* riga := riga + '<cube lastObsId="0" id="9_1905512" xmlns="http://www.bankitalia.it/bolina/common/vo/cube">' + NL */
        riga = riga+"<cube lastObsId=\"0\" id=\"9_1905512\" xmlns=\"http://www.bankitalia.it/bolina/common/vo/cube\">"+"\n";
        /* riga := riga + '<obs id="0">' + NL */
        riga = riga+"<obs id=\"0\">"+"\n";
        /* riga := riga + '<dim name="ENTE_SEGN" value="12100"/>' + NL */
        riga = riga+"<dim name=\"ENTE_SEGN\" value=\"12100\"/>"+"\n";
        /* riga := riga + '<dim name="DATA_CONTABILE" value="'+_datfin+'"/>' + NL */
        riga = riga+"<dim name=\"DATA_CONTABILE\" value=\""+_datfin+"\"/>"+"\n";
        /* riga := riga + '<dim name="NOME" value="PAOLO"/>'+ NL */
        riga = riga+"<dim name=\"NOME\" value=\"PAOLO\"/>"+"\n";
        /* riga := riga + '<dim name="COGNOME" value="DE PETRIS"/>' + NL */
        riga = riga+"<dim name=\"COGNOME\" value=\"DE PETRIS\"/>"+"\n";
        /* riga := riga + '<dim name="TELEFONO" value="0687410614"/>' + NL */
        riga = riga+"<dim name=\"TELEFONO\" value=\"0687410614\"/>"+"\n";
        /* riga := riga + '<dim name="EMAIL" value="paolo.DePetris@westernunion.com"/>' + NL */
        riga = riga+"<dim name=\"EMAIL\" value=\"paolo.DePetris@westernunion.com\"/>"+"\n";
        /* riga := riga + '</obs>' + NL */
        riga = riga+"</obs>"+"\n";
        /* riga := riga + '</cube>' + NL */
        riga = riga+"</cube>"+"\n";
        /* riga := riga + '</dataSegment>' + NL */
        riga = riga+"</dataSegment>"+"\n";
        /* riga := riga + '</content>' + NL */
        riga = riga+"</content>"+"\n";
        /* riga := riga + '</message>' */
        riga = riga+"</message>";
        /* FileLibMit.WriteLine(fhand,riga) */
        FileLibMit.WriteLine(fhand,riga);
        /* FileLibMit.Close(fhand) */
        FileLibMit.Close(fhand);
        /* cNomeFileZip := LRTrim(nFile)+'.zip' */
        cNomeFileZip = CPLib.LRTrim(nFile)+".zip";
        /* cNomeZip := LRTrim(gPathApp)+'/export/'+LRTrim(gAzienda)+"/"+LRTrim(cNomeFileZip) */
        cNomeZip = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(cNomeFileZip);
        /* fname := nFile */
        fname = nFile;
        /* pfname := LRTrim(gPathApp)+"/export/"+LRTrim(gAzienda)+"/"+LRTrim(fname) */
        pfname = CPLib.LRTrim(gPathApp)+"/export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(fname);
        /* Exec "Creazione ZIP" Page 2:Page_ZIP */
        Page_ZIP();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* cRitorno := LRTrim(nFile)+'.zip' */
        cRitorno = CPLib.LRTrim(nFile)+".zip";
        /* gMsgProc := gMsgProc + 'Sono stati scritti: ' + LRTrim(Str(conta+1,10,0)) + ' record' + NL */
        gMsgProc = gMsgProc+"Sono stati scritti: "+CPLib.LRTrim(CPLib.Str(conta+1,10,0))+" record"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione completata con successo!' // Messaggio Import */
        gMsgImp = "Elaborazione completata con successo!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* cRitorno := 'KO' */
        cRitorno = "KO";
        /* gMsgProc := gMsgProc + 'Elaborazione non portata a termine' + NL */
        gMsgProc = gMsgProc+"Elaborazione non portata a termine"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgImp := 'Elaborazione abortita!' // Messaggio Import */
        gMsgImp = "Elaborazione abortita!";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000028status,0)) {
          m_Sql.SetTransactionStatus(nTry00000028status,cTry00000028msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_tbprovsv!=null)
          Cursor_tbprovsv.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tbstati!=null)
          Cursor_tbstati.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_bp_wu!=null)
          Cursor_qbe_estrai_bp_wu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_ZIP() throws Exception {
    // These are the files to include in the ZIP file
        String[] filenames = new String[]{pfname};
        
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(fname));
        
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
        
                // Complete the entry
                out.closeEntry();
                in.close();
            }
        
            // Complete the ZIP file
            out.close();
        } catch (java.io.IOException e) {
        }
    
  }
  void _init_() {
  }
  public String RunAsync(double p_pAnno,double p_pMese) {
    pAnno = p_pAnno;
    pMese = p_pMese;
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
  public String Run(double p_pAnno,double p_pMese) {
    pAnno = p_pAnno;
    pMese = p_pMese;
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
  public static arfn_estrai_bp_wuR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_estrai_bp_wuR(p_Ctx, p_Caller);
  }
  public static arfn_estrai_bp_wuR Make(CPContext p_Ctx) {
    return new arfn_estrai_bp_wuR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAnno = 0;
    pMese = 0;
    _datini = CPLib.Space(8);
    _datfin = CPLib.Space(8);
    cRitorno = CPLib.Space(20);
    fhand = CPLib.Space(1);
    riga = "";
    nFile = CPLib.Space(20);
    conta = 0;
    cNomeFileZip = CPLib.Space(30);
    cNomeZip = CPLib.Space(128);
    fname = CPLib.Space(25);
    pfname = CPLib.Space(128);
    _importo = 0;
    _ddatini = CPLib.NullDate();
    _ddatfin = CPLib.NullDate();
    mcDati = new MemoryCursor_qbe_estrai_bp_wu_vqr();
    mcProvSV = new MemoryCursor_tbprovsv();
    mcStati = new MemoryCursor_tbstati();
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_estrai_bp_wu,
  public static final String m_cVQRList = ",qbe_estrai_bp_wu,";
  // ENTITY_BATCHES: ,arfn_estrai_bp_wu,arfn_fdatetime,arfn_fdatetime_bp,arfn_finemese,
  public static final String i_InvokedRoutines = ",arfn_estrai_bp_wu,arfn_fdatetime,arfn_fdatetime_bp,arfn_finemese,";
  public static String[] m_cRunParameterNames={"pAnno","pMese"};
}
