// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_sd_comunegaR implements CallerWithObjs {
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
  public String m_cPhName_anarapbo;
  public String m_cServer_anarapbo;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_aerighe;
  public String m_cServer_aerighe;
  public String m_cPhName_tmp_apecod;
  public String m_cServer_tmp_apecod;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_aefiles;
  public String m_cServer_aefiles;
  public String m_cPhName_tmp_apenocod;
  public String m_cServer_tmp_apenocod;
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
  public java.sql.Date w_a_data;
  public java.sql.Date w_dadata;
  public java.sql.Date w_datpri;
  public java.sql.Date w_datsecf;
  public java.sql.Date w_datseci;
  public String w_iniz;
  public String w_seco;
  public double w_anno;
  public String w_mese;
  public String w_FILEINVIO;
  public java.sql.Date w_DATAINVIO;
  public String w_CFINVIO;
  public String w_CAFINVIO;
  public String _errlog;
  public String _file;
  public String _nomefile;
  public String _descfile;
  public double _r;
  public double _i;
  public String fhand;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String cProg;
  public String _cfinvio;
  public String _cafinvio;
  public String _tipinvio;
  public String _impinvio;
  public String _cfint;
  public String _ragint;
  public String _citint;
  public String _prvint;
  public java.sql.Date _datinvio;
  public String gPathApp;
  public String gAzienda;
  public String gIntemediario;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_sd_comunegaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sd_comunega",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_tmp_apecod = p_ContextObject.GetPhName("tmp_apecod");
    m_cServer_tmp_apecod = p_ContextObject.GetServer("tmp_apecod");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_aefiles = p_ContextObject.GetPhName("aefiles");
    m_cServer_aefiles = p_ContextObject.GetServer("aefiles");
    m_cPhName_tmp_apenocod = p_ContextObject.GetPhName("tmp_apenocod");
    m_cServer_tmp_apenocod = p_ContextObject.GetServer("tmp_apenocod");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      return _r;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_sd_comunega";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("iniz",p_cVarName)) {
      return w_iniz;
    }
    if (CPLib.eqr("seco",p_cVarName)) {
      return w_seco;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
    }
    if (CPLib.eqr("FILEINVIO",p_cVarName)) {
      return w_FILEINVIO;
    }
    if (CPLib.eqr("CFINVIO",p_cVarName)) {
      return w_CFINVIO;
    }
    if (CPLib.eqr("CAFINVIO",p_cVarName)) {
      return w_CAFINVIO;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      return _errlog;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      return _file;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("_descfile",p_cVarName)) {
      return _descfile;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      return cOnlyNomeFile;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      return cNomeFileZip;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_cfinvio",p_cVarName)) {
      return _cfinvio;
    }
    if (CPLib.eqr("_cafinvio",p_cVarName)) {
      return _cafinvio;
    }
    if (CPLib.eqr("_tipinvio",p_cVarName)) {
      return _tipinvio;
    }
    if (CPLib.eqr("_impinvio",p_cVarName)) {
      return _impinvio;
    }
    if (CPLib.eqr("_cfint",p_cVarName)) {
      return _cfint;
    }
    if (CPLib.eqr("_ragint",p_cVarName)) {
      return _ragint;
    }
    if (CPLib.eqr("_citint",p_cVarName)) {
      return _citint;
    }
    if (CPLib.eqr("_prvint",p_cVarName)) {
      return _prvint;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      return w_a_data;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      return w_dadata;
    }
    if (CPLib.eqr("datpri",p_cVarName)) {
      return w_datpri;
    }
    if (CPLib.eqr("datsecf",p_cVarName)) {
      return w_datsecf;
    }
    if (CPLib.eqr("datseci",p_cVarName)) {
      return w_datseci;
    }
    if (CPLib.eqr("DATAINVIO",p_cVarName)) {
      return w_DATAINVIO;
    }
    if (CPLib.eqr("_datinvio",p_cVarName)) {
      return _datinvio;
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
    return null;
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      _r = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("iniz",p_cVarName)) {
      w_iniz = value;
      return;
    }
    if (CPLib.eqr("seco",p_cVarName)) {
      w_seco = value;
      return;
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
      return;
    }
    if (CPLib.eqr("FILEINVIO",p_cVarName)) {
      w_FILEINVIO = value;
      return;
    }
    if (CPLib.eqr("CFINVIO",p_cVarName)) {
      w_CFINVIO = value;
      return;
    }
    if (CPLib.eqr("CAFINVIO",p_cVarName)) {
      w_CAFINVIO = value;
      return;
    }
    if (CPLib.eqr("_errlog",p_cVarName)) {
      _errlog = value;
      return;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      _file = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("_descfile",p_cVarName)) {
      _descfile = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("cOnlyNomeFile",p_cVarName)) {
      cOnlyNomeFile = value;
      return;
    }
    if (CPLib.eqr("cNomeFileZip",p_cVarName)) {
      cNomeFileZip = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_cfinvio",p_cVarName)) {
      _cfinvio = value;
      return;
    }
    if (CPLib.eqr("_cafinvio",p_cVarName)) {
      _cafinvio = value;
      return;
    }
    if (CPLib.eqr("_tipinvio",p_cVarName)) {
      _tipinvio = value;
      return;
    }
    if (CPLib.eqr("_impinvio",p_cVarName)) {
      _impinvio = value;
      return;
    }
    if (CPLib.eqr("_cfint",p_cVarName)) {
      _cfint = value;
      return;
    }
    if (CPLib.eqr("_ragint",p_cVarName)) {
      _ragint = value;
      return;
    }
    if (CPLib.eqr("_citint",p_cVarName)) {
      _citint = value;
      return;
    }
    if (CPLib.eqr("_prvint",p_cVarName)) {
      _prvint = value;
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
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("a_data",p_cVarName)) {
      w_a_data = value;
      return;
    }
    if (CPLib.eqr("dadata",p_cVarName)) {
      w_dadata = value;
      return;
    }
    if (CPLib.eqr("datpri",p_cVarName)) {
      w_datpri = value;
      return;
    }
    if (CPLib.eqr("datsecf",p_cVarName)) {
      w_datsecf = value;
      return;
    }
    if (CPLib.eqr("datseci",p_cVarName)) {
      w_datseci = value;
      return;
    }
    if (CPLib.eqr("DATAINVIO",p_cVarName)) {
      w_DATAINVIO = value;
      return;
    }
    if (CPLib.eqr("_datinvio",p_cVarName)) {
      _datinvio = value;
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
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* w_a_data Date */
      /* w_dadata Date */
      /* w_datpri Date */
      /* w_datsecf Date */
      /* w_datseci Date */
      /* w_iniz Char(1) */
      /* w_seco Char(1) */
      /* w_anno Numeric(4, 0) */
      /* w_mese Char(2) */
      /* w_FILEINVIO Char(1) // Tipo Preparazione FIle */
      /* w_DATAINVIO Date // Data Impegno Organo Invio */
      /* w_CFINVIO Char(16) // Codice Fiscale Organo Invio File */
      /* w_CAFINVIO Char(5) // Codice CAF Organo Invio */
      /* _errlog Memo */
      /* _file Memo */
      /* _nomefile Char(15) */
      /* _descfile Char(65) */
      /* _r Numeric(15, 0) */
      /* _i Numeric(15, 0) */
      /* fhand Char(10) */
      /* cNomeFile Char(30) */
      /* cOnlyNomeFile Char(30) */
      /* cNomeFileZip Char(30) */
      /* cProg Char(10) */
      /* _cfinvio Char(16) */
      /* _cafinvio Char(5) */
      /* _tipinvio Char(1) */
      /* _impinvio Char(8) */
      /* _cfint Char(16) */
      /* _ragint Char(70) */
      /* _citint Char(40) */
      /* _prvint Char(2) */
      /* _datinvio Date */
      /* gPathApp Char(80) // Path Applicazione */
      /* gAzienda Char(10) // Azienda */
      /* gIntemediario Char(11) // Intermediario */
      /* _r := 0 */
      _r = CPLib.Round(0,0);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _r := intermbo->CONTATORE */
        _r = CPLib.Round(Cursor_intermbo.GetDouble("CONTATORE"),0);
        /* _cfint := intermbo->CODFISC */
        _cfint = Cursor_intermbo.GetString("CODFISC");
        /* _ragint := arfn_agechar(intermbo->RAGSOC,' ') */
        _ragint = arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("RAGSOC")," ");
        /* _citint := arfn_agechar(intermbo->DESCCIT,' ') */
        _citint = arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("DESCCIT")," ");
        /* _prvint := intermbo->PROVINCIA */
        _prvint = Cursor_intermbo.GetString("PROVINCIA");
        /* _cfinvio := intermbo->CFINVIO */
        _cfinvio = Cursor_intermbo.GetString("CFINVIO");
        /* _cafinvio := LRTrim(intermbo->CAFINVIO) */
        _cafinvio = CPLib.LRTrim(Cursor_intermbo.GetString("CAFINVIO"));
        /* _tipinvio := intermbo->FILEINVIO */
        _tipinvio = Cursor_intermbo.GetString("FILEINVIO");
        /* _datinvio := intermbo->DATAINVIO */
        _datinvio = Cursor_intermbo.GetDate("DATAINVIO");
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _cfinvio := iif(not(Empty(w_CFINVIO)) and LRTrim(w_CFINVIO) <> LRTrim(_cfinvio),w_CFINVIO,_cfinvio) */
      _cfinvio = ( ! (CPLib.Empty(w_CFINVIO)) && CPLib.ne(CPLib.LRTrim(w_CFINVIO),CPLib.LRTrim(_cfinvio))?w_CFINVIO:_cfinvio);
      /* _cafinvio := iif(not(Empty(w_CAFINVIO)) and LRTrim(w_CAFINVIO) <> LRTrim(_cafinvio),LRTrim(w_CAFINVIO),LRTrim(_cafinvio)) */
      _cafinvio = ( ! (CPLib.Empty(w_CAFINVIO)) && CPLib.ne(CPLib.LRTrim(w_CAFINVIO),CPLib.LRTrim(_cafinvio))?CPLib.LRTrim(w_CAFINVIO):CPLib.LRTrim(_cafinvio));
      /* _tipinvio := iif(not(Empty(w_FILEINVIO)) and LRTrim(w_FILEINVIO) <> LRTrim(_tipinvio),w_FILEINVIO,_tipinvio) */
      _tipinvio = ( ! (CPLib.Empty(w_FILEINVIO)) && CPLib.ne(CPLib.LRTrim(w_FILEINVIO),CPLib.LRTrim(_tipinvio))?w_FILEINVIO:_tipinvio);
      /* Case Empty(_datinvio) and Empty(w_DATAINVIO) */
      if (CPLib.Empty(_datinvio) && CPLib.Empty(w_DATAINVIO)) {
        /* If Empty(LRTrim(_cfinvio)) */
        if (CPLib.Empty(CPLib.LRTrim(_cfinvio))) {
          /* _impinvio := Space(8) */
          _impinvio = CPLib.Space(8);
        } else { // Else
          /* _impinvio := DateToChar(Date()) */
          _impinvio = CPLib.DateToChar(CPLib.Date());
        } // End If
        /* Case not(Empty(_datinvio)) and Empty(w_DATAINVIO) */
      } else if ( ! (CPLib.Empty(_datinvio)) && CPLib.Empty(w_DATAINVIO)) {
        /* _impinvio := DateToChar(_datinvio) */
        _impinvio = CPLib.DateToChar(_datinvio);
        /* Case Empty(_datinvio) and not(Empty(w_DATAINVIO)) */
      } else if (CPLib.Empty(_datinvio) &&  ! (CPLib.Empty(w_DATAINVIO))) {
        /* _impinvio := DateToChar(w_DATAINVIO) */
        _impinvio = CPLib.DateToChar(w_DATAINVIO);
        /* Case not(Empty(_datinvio)) and not(Empty(w_DATAINVIO)) */
      } else if ( ! (CPLib.Empty(_datinvio)) &&  ! (CPLib.Empty(w_DATAINVIO))) {
        /* If w_DATAINVIO <> _datinvio */
        if (CPLib.ne(w_DATAINVIO,_datinvio)) {
          /* _impinvio := DateToChar(w_DATAINVIO) */
          _impinvio = CPLib.DateToChar(w_DATAINVIO);
        } else { // Else
          /* _impinvio := DateToChar(_datinvio) */
          _impinvio = CPLib.DateToChar(_datinvio);
        } // End If
      } // End Case
      /* _impinvio := Substr(_impinvio,7,2)+Substr(_impinvio,5,2)+Left(_impinvio,4) */
      _impinvio = CPLib.Substr(_impinvio,7,2)+CPLib.Substr(_impinvio,5,2)+CPLib.Left(_impinvio,4);
      /* Crea file per stampa contenuto file */
      /* _cfinvio := arfn_agechar(_cfinvio,' ') */
      _cfinvio = arfn_agecharR.Make(m_Ctx,this).Run(_cfinvio," ");
      /* _cafinvio := arfn_agechar(_cafinvio,' ') */
      _cafinvio = arfn_agecharR.Make(m_Ctx,this).Run(_cafinvio," ");
      /* _tipinvio := arfn_agechar(_tipinvio,' ') */
      _tipinvio = arfn_agecharR.Make(m_Ctx,this).Run(_tipinvio," ");
      /* _r := _r + 1 */
      _r = CPLib.Round(_r+1,0);
      /* _nomefile := DateTimeToChar(DateTime())+'7' */
      _nomefile = CPLib.DateTimeToChar(CPLib.DateTime())+"7";
      /* _file := '0CCB00' + '34' */
      _file = "0CCB00"+"34";
      /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
      _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
      /* _file := _file + Space(102) */
      _file = _file+CPLib.Space(102);
      /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
      _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
      /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
      _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
      /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
      _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
      /* Case w_iniz = 'S' */
      if (CPLib.eqr(w_iniz,"S")) {
        /* _file := _file + '200600' */
        _file = _file+"200600";
        /* _file := _file + '7' */
        _file = _file+"7";
        /* _descfile := 'Comunicazione Negativa Primo Invio' */
        _descfile = "Comunicazione Negativa Primo Invio";
        /* Case w_seco = 'S' */
      } else if (CPLib.eqr(w_seco,"S")) {
        /* _file := _file + '200700' */
        _file = _file+"200700";
        /* _file := _file + '7' */
        _file = _file+"7";
        /* _descfile := 'Comunicazione Negativa Secondo Invio' */
        _descfile = "Comunicazione Negativa Secondo Invio";
      } else { // Otherwise
        /* _file := _file + Right('0000'+LRTrim(Str(Year(w_a_data),4,0)),4) + Right('00'+LRTrim(Str(Month(w_a_data),2,0)),2) */
        _file = _file+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(CPLib.Year(w_a_data),4,0)),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
        /* _file := _file + '7' */
        _file = _file+"7";
        /* _descfile := 'Comunicazione Negativa Invio Mensile' */
        _descfile = "Comunicazione Negativa Invio Mensile";
      } // End Case
      /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
      /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
      /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
      /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
      /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
      /* _file := _file + Space(1507) */
      _file = _file+CPLib.Space(1507);
      /* _file := _file + 'A' */
      _file = _file+"A";
      /* _file := _file + NL */
      _file = _file+"\n";
      /* Cicla sul file per invii e prepara il file */
      /* _i := 1 */
      _i = CPLib.Round(1,0);
      /* _file := _file + '9CCB00' + '34' */
      _file = _file+"9CCB00"+"34";
      /* _file := _file + LRTrim(_cfint)+Space(16 - Len(LRTrim(_cfint))) */
      _file = _file+CPLib.LRTrim(_cfint)+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(_cfint)));
      /* _file := _file + Space(102) */
      _file = _file+CPLib.Space(102);
      /* _file := _file + LRTrim(_ragint)+Space(70 - Len(LRTrim(_ragint))) */
      _file = _file+CPLib.LRTrim(_ragint)+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(_ragint)));
      /* _file := _file + LRTrim(_citint)+Space(40 - Len(LRTrim(_citint))) */
      _file = _file+CPLib.LRTrim(_citint)+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(_citint)));
      /* _file := _file + LRTrim(_prvint)+Space(2 - Len(LRTrim(_prvint))) */
      _file = _file+CPLib.LRTrim(_prvint)+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(_prvint)));
      /* Case w_iniz = 'S' */
      if (CPLib.eqr(w_iniz,"S")) {
        /* _file := _file + '200600' */
        _file = _file+"200600";
        /* _file := _file + '7' */
        _file = _file+"7";
        /* _descfile := 'Comunicazione Negativa Primo Invio' */
        _descfile = "Comunicazione Negativa Primo Invio";
        /* Case w_seco = 'S' */
      } else if (CPLib.eqr(w_seco,"S")) {
        /* _file := _file + '200700' */
        _file = _file+"200700";
        /* _file := _file + '7' */
        _file = _file+"7";
        /* _descfile := 'Comunicazione Negativa Secondo Invio' */
        _descfile = "Comunicazione Negativa Secondo Invio";
      } else { // Otherwise
        /* _file := _file + Right('0000'+LRTrim(Str(Year(w_a_data),4,0)),4) + Right('00'+LRTrim(Str(Month(w_a_data),2,0)),2) */
        _file = _file+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(CPLib.Year(w_a_data),4,0)),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
        /* _file := _file + '7' */
        _file = _file+"7";
        /* _descfile := 'Comunicazione Negativa Invio Mensile' */
        _descfile = "Comunicazione Negativa Invio Mensile";
      } // End Case
      /* _file := _file + Left(LRTrim(_nomefile)+Space(15),15) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_nomefile)+CPLib.Space(15),15);
      /* _file := _file + Left(LRTrim(_cfinvio)+Space(16),16) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_cfinvio)+CPLib.Space(16),16);
      /* _file := _file + Left(LRTrim(_cafinvio)+Space(5),5) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_cafinvio)+CPLib.Space(5),5);
      /* _file := _file + Left(LRTrim(_tipinvio)+Space(1),1) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_tipinvio)+CPLib.Space(1),1);
      /* _file := _file + Left(LRTrim(_impinvio)+Space(8),8) */
      _file = _file+CPLib.Left(CPLib.LRTrim(_impinvio)+CPLib.Space(8),8);
      /* _file := _file + Space(1507) */
      _file = _file+CPLib.Space(1507);
      /* _file := _file + 'A' */
      _file = _file+"A";
      /* _file := _file + NL */
      _file = _file+"\n";
      /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile) */
      cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile);
      /* cOnlyNomeFile := _nomefile */
      cOnlyNomeFile = _nomefile;
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)+".zip" */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile)+".zip";
      /* fhand := FileLibrary.OpenWrite('./flussi/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibrary.OpenWrite("./flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      /* FileLibrary.Write(fhand,_file) */
      FileLibrary.Write(fhand,_file);
      /* FileLibrary.Close(fhand) */
      FileLibrary.Close(fhand);
      /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
      cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
      // * --- Insert into aefiles from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aefiles");
      m_cPhName = m_Ctx.GetPhName("aefiles");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles")+" (";
      m_cSql = m_cSql+GetFieldsName_0724CE70(m_Ctx);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile)+".zip","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_descfile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_mese,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_anno,"?",0,0)+", ";
      if (m_Ctx.IsSharedTemp("aefiles")) {
        m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
      }
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles",true);
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
      /* Exec "Crea file zip" Page 2 */
      Page_2();
      /* FileLibrary.DeleteFile(cNomeFile) */
      FileLibrary.DeleteFile(cNomeFile);
      /* Stop arpg_filesage */
      Forward f;
      f=new Forward("arpg_filesage",false,this,Forward.Start,false);
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
    }
  }
  void Page_2() throws Exception {
    // These are the files to include in the ZIP file
        String[] filenames = new String[]{cNomeFile};
        
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
            // Create the ZIP file
            String outFilename = cNomeFileZip;
            java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(outFilename));
        
            // Compress the files
            for (int i=0; i<filenames.length; i++) {
                java.io.FileInputStream in = new java.io.FileInputStream(filenames[i]);
        
                // Add ZIP entry to output stream.
                out.putNextEntry(new java.util.zip.ZipEntry(cOnlyNomeFile));
        
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
      m_Caller.SetDate("a_data","D",8,0,w_a_data);
      m_Caller.SetDate("dadata","D",8,0,w_dadata);
      m_Caller.SetDate("datpri","D",8,0,w_datpri);
      m_Caller.SetDate("datsecf","D",8,0,w_datsecf);
      m_Caller.SetDate("datseci","D",8,0,w_datseci);
      m_Caller.SetString("iniz","C",1,0,w_iniz);
      m_Caller.SetString("seco","C",1,0,w_seco);
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.SetString("mese","C",2,0,w_mese);
      m_Caller.SetString("FILEINVIO","C",1,0,w_FILEINVIO);
      m_Caller.SetDate("DATAINVIO","D",8,0,w_DATAINVIO);
      m_Caller.SetString("CFINVIO","C",16,0,w_CFINVIO);
      m_Caller.SetString("CAFINVIO","C",5,0,w_CAFINVIO);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sd_comunegaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sd_comunegaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_datpri = m_Caller.GetDate("datpri","D",8,0);
    w_datsecf = m_Caller.GetDate("datsecf","D",8,0);
    w_datseci = m_Caller.GetDate("datseci","D",8,0);
    w_iniz = m_Caller.GetString("iniz","C",1,0);
    w_seco = m_Caller.GetString("seco","C",1,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    w_mese = m_Caller.GetString("mese","C",2,0);
    w_FILEINVIO = m_Caller.GetString("FILEINVIO","C",1,0);
    w_DATAINVIO = m_Caller.GetDate("DATAINVIO","D",8,0);
    w_CFINVIO = m_Caller.GetString("CFINVIO","C",16,0);
    w_CAFINVIO = m_Caller.GetString("CAFINVIO","C",5,0);
    _errlog = "";
    _file = "";
    _nomefile = CPLib.Space(15);
    _descfile = CPLib.Space(65);
    _r = 0;
    _i = 0;
    fhand = CPLib.Space(10);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    cProg = CPLib.Space(10);
    _cfinvio = CPLib.Space(16);
    _cafinvio = CPLib.Space(5);
    _tipinvio = CPLib.Space(1);
    _impinvio = CPLib.Space(8);
    _cfint = CPLib.Space(16);
    _ragint = CPLib.Space(70);
    _citint = CPLib.Space(40);
    _prvint = CPLib.Space(2);
    _datinvio = CPLib.NullDate();
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_agechar,
  public static final String i_InvokedRoutines = ",arfn_agechar,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0724CE70(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    p_cSql = p_cSql+"mese,";
    p_cSql = p_cSql+"anno,";
    if (p_Ctx.IsSharedTemp("aefiles")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles",true);
    return p_cSql;
  }
}
