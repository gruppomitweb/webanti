// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_sd_comunega_delopeR implements CallerWithObjs {
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
  public String m_cPhName_aefiles_do;
  public String m_cServer_aefiles_do;
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
  public java.sql.Date w_datprf;
  public java.sql.Date w_datsecf;
  public java.sql.Date w_datseci;
  public String w_iniz;
  public String w_seco;
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
  public String gPathApp;
  public String gIntemediario;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_sd_comunega_delopeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sd_comunega_delope",m_Caller);
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
    m_cPhName_aefiles_do = p_ContextObject.GetPhName("aefiles_do");
    m_cServer_aefiles_do = p_ContextObject.GetServer("aefiles_do");
    m_cPhName_tmp_apenocod = p_ContextObject.GetPhName("tmp_apenocod");
    m_cServer_tmp_apenocod = p_ContextObject.GetServer("tmp_apenocod");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
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
      return "arrt_sd_comunega_delope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("iniz",p_cVarName)) {
      return w_iniz;
    }
    if (CPLib.eqr("seco",p_cVarName)) {
      return w_seco;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("datprf",p_cVarName)) {
      return w_datprf;
    }
    if (CPLib.eqr("datsecf",p_cVarName)) {
      return w_datsecf;
    }
    if (CPLib.eqr("datseci",p_cVarName)) {
      return w_datseci;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      gIntemediario = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("datprf",p_cVarName)) {
      w_datprf = value;
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
      /* w_datprf Date */
      /* w_datsecf Date */
      /* w_datseci Date */
      /* w_iniz Char(1) */
      /* w_seco Char(1) */
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
      /* gPathApp Char(80) // Path Applicazione */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* _nomefile := '99'+Right(DateTimeToChar(DateTime()),12)+'7' */
      _nomefile = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"7";
      /* _file := '0CCB00' + '34' */
      _file = "0CCB00"+"34";
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _r := intermbo->CONTATORE */
        _r = CPLib.Round(Cursor_intermbo.GetDouble("CONTATORE"),0);
        /* _file := _file + LRTrim(intermbo->CODFISC)+Space(16 - Len(LRTrim(intermbo->CODFISC))) */
        _file = _file+CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))));
        /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
        } else { // Else
          /* _file := _file + Space(102) */
          _file = _file+CPLib.Space(102);
          /* _file := _file + LRTrim(intermbo->RAGSOC)+Space(70 - Len(LRTrim(intermbo->RAGSOC))) */
          _file = _file+CPLib.LRTrim(Cursor_intermbo.GetString("RAGSOC"))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("RAGSOC"))));
          /* _file := _file + LRTrim(intermbo->DESCCIT)+Space(40 - Len(LRTrim(intermbo->DESCCIT))) */
          _file = _file+CPLib.LRTrim(Cursor_intermbo.GetString("DESCCIT"))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("DESCCIT"))));
          /* _file := _file + LRTrim(intermbo->PROVINCIA)+Space(2 - Len(LRTrim(intermbo->PROVINCIA))) */
          _file = _file+CPLib.LRTrim(Cursor_intermbo.GetString("PROVINCIA"))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("PROVINCIA"))));
        } // End If
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _r := intermbo->CONTATORE + 1 */
      _r = CPLib.Round(Cursor_intermbo.GetDouble("CONTATORE")+1,0);
      /* Case w_iniz = 'S' */
      if (CPLib.eqr(w_iniz,"S")) {
        /* _file := _file + '200500' */
        _file = _file+"200500";
        /* _file := _file + '7' */
        _file = _file+"7";
        /* _descfile := 'Comunicazione Negativa Primo Invio' */
        _descfile = "Comunicazione Negativa Primo Invio";
        /* Case w_seco = 'S' */
      } else if (CPLib.eqr(w_seco,"S")) {
        /* _file := _file + '200800' */
        _file = _file+"200800";
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
      /* _file := _file + _nomefile */
      _file = _file+_nomefile;
      /* _file := _file + Space(1537) */
      _file = _file+CPLib.Space(1537);
      /* _file := _file + 'A' */
      _file = _file+"A";
      /* _file := _file + NL */
      _file = _file+"\n";
      /* Cicla sul file per invii e prepara il file */
      /* _i := 1 */
      _i = CPLib.Round(1,0);
      /* _file := _file + '9CCB00' + '34' */
      _file = _file+"9CCB00"+"34";
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _r := intermbo->CONTATORE */
        _r = CPLib.Round(Cursor_intermbo.GetDouble("CONTATORE"),0);
        /* _file := _file + LRTrim(intermbo->CODFISC)+Space(16 - Len(LRTrim(intermbo->CODFISC))) */
        _file = _file+CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))+CPLib.Space(16-CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))));
        /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
        } else { // Else
          /* _file := _file + Space(102) */
          _file = _file+CPLib.Space(102);
          /* _file := _file + LRTrim(intermbo->RAGSOC)+Space(70 - Len(LRTrim(intermbo->RAGSOC))) */
          _file = _file+CPLib.LRTrim(Cursor_intermbo.GetString("RAGSOC"))+CPLib.Space(70-CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("RAGSOC"))));
          /* _file := _file + LRTrim(intermbo->DESCCIT)+Space(40 - Len(LRTrim(intermbo->DESCCIT))) */
          _file = _file+CPLib.LRTrim(Cursor_intermbo.GetString("DESCCIT"))+CPLib.Space(40-CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("DESCCIT"))));
          /* _file := _file + LRTrim(intermbo->PROVINCIA)+Space(2 - Len(LRTrim(intermbo->PROVINCIA))) */
          _file = _file+CPLib.LRTrim(Cursor_intermbo.GetString("PROVINCIA"))+CPLib.Space(2-CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("PROVINCIA"))));
        } // End If
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* Case w_iniz = 'S' */
      if (CPLib.eqr(w_iniz,"S")) {
        /* _file := _file + '200500' */
        _file = _file+"200500";
        /* _file := _file + '7' */
        _file = _file+"7";
        /* Case w_seco = 'S' */
      } else if (CPLib.eqr(w_seco,"S")) {
        /* _file := _file + '200800' */
        _file = _file+"200800";
        /* _file := _file + '7' */
        _file = _file+"7";
      } else { // Otherwise
        /* _file := _file + Right('0000'+LRTrim(Str(Year(w_a_data),4,0)),4) + Right('00'+LRTrim(Str(Month(w_a_data),2,0)),2) */
        _file = _file+CPLib.Right("0000"+CPLib.LRTrim(CPLib.Str(CPLib.Year(w_a_data),4,0)),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
        /* _file := _file + '7' */
        _file = _file+"7";
      } // End Case
      /* _file := _file + _nomefile */
      _file = _file+_nomefile;
      /* _file := _file + Space(1537) */
      _file = _file+CPLib.Space(1537);
      /* _file := _file + 'A' */
      _file = _file+"A";
      /* _file := _file + NL */
      _file = _file+"\n";
      /* cNomeFile := LRTrim(gPathApp)+'/flussi/'+LRTrim(_nomefile) */
      cNomeFile = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(_nomefile);
      /* cOnlyNomeFile := _nomefile */
      cOnlyNomeFile = _nomefile;
      /* cNomeFileZip := LRTrim(gPathApp)+'/flussi/'+LRTrim(_nomefile)+".zip" */
      cNomeFileZip = CPLib.LRTrim(gPathApp)+"/flussi/"+CPLib.LRTrim(_nomefile)+".zip";
      /* fhand := FileLibMit.OpenWrite('./flussi/'+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWrite("./flussi/"+CPLib.LRTrim(_nomefile));
      /* FileLibMit.Write(fhand,_file) */
      FileLibMit.Write(fhand,_file);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* cProg := Utilities.GetAutonumber("PRGFILES\'"+LRTrim(gAzienda)+"'",'',10) */
      cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGFILES\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
      // * --- Insert into aefiles_do from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("aefiles_do");
      m_cPhName = m_Ctx.GetPhName("aefiles_do");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.InsertIntoStatement(m_Ctx,"aefiles_do")+" (";
      m_cSql = m_cSql+GetFieldsName_069D3F08(m_Ctx);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile),"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_descfile,"?",0,0,m_cServer)+", ";
      if (m_Ctx.IsSharedTemp("aefiles_do")) {
        m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
      }
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefiles_do",true);
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
      /* FileLibMit.DeleteFile(cNomeFile) */
      FileLibMit.DeleteFile(cNomeFile);
      /* Stop arpg_filesage_do */
      Forward f;
      f=new Forward("arpg_filesage_do",false,this,Forward.Start,false);
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
      m_Caller.SetDate("datprf","D",8,0,w_datprf);
      m_Caller.SetDate("datsecf","D",8,0,w_datsecf);
      m_Caller.SetDate("datseci","D",8,0,w_datseci);
      m_Caller.SetString("iniz","C",1,0,w_iniz);
      m_Caller.SetString("seco","C",1,0,w_seco);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sd_comunega_delopeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sd_comunega_delopeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_datpri = m_Caller.GetDate("datpri","D",8,0);
    w_datprf = m_Caller.GetDate("datprf","D",8,0);
    w_datsecf = m_Caller.GetDate("datsecf","D",8,0);
    w_datseci = m_Caller.GetDate("datseci","D",8,0);
    w_iniz = m_Caller.GetString("iniz","C",1,0);
    w_seco = m_Caller.GetString("seco","C",1,0);
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
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_069D3F08(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"idfile,";
    p_cSql = p_cSql+"datafile,";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+"descfile,";
    if (p_Ctx.IsSharedTemp("aefiles_do")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefiles_do",true);
    return p_cSql;
  }
}
