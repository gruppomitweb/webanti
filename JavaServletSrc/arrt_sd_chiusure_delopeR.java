// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_sd_chiusure_delopeR implements CallerWithObjs {
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
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
  public String m_cPhName_tbstati;
  public String m_cServer_tbstati;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_aefiles_do;
  public String m_cServer_aefiles_do;
  public String m_cPhName_tmp_chiucod;
  public String m_cServer_tmp_chiucod;
  public String m_cPhName_tmp_chiunocod;
  public String m_cServer_tmp_chiunocod;
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
  public String _errlog;
  public double imprec;
  public double _noprot;
  public String _rapold;
  public String _tipoco;
  public double _nriga;
  public double _newrow;
  public String _cdata1;
  public String _cdata2;
  public String _cdata3;
  public String _cdata4;
  public String _descit;
  public String _file;
  public String _nomefile;
  public double _r;
  public double _i;
  public String fhand;
  public String cNomeFile;
  public String cOnlyNomeFile;
  public String cNomeFileZip;
  public String cProg;
  public double _nocodrec;
  public double _sicodrec;
  public String _intefisc;
  public String gPathApp;
  public String gIntemediario;
  public String gAzienda;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_sd_chiusure_delopeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_sd_chiusure_delope",m_Caller);
    m_cPhName_anarapbo = p_ContextObject.GetPhName("anarapbo");
    m_cServer_anarapbo = p_ContextObject.GetServer("anarapbo");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_aerighe = p_ContextObject.GetPhName("aerighe");
    m_cServer_aerighe = p_ContextObject.GetServer("aerighe");
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    m_cPhName_tbstati = p_ContextObject.GetPhName("tbstati");
    m_cServer_tbstati = p_ContextObject.GetServer("tbstati");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_aefiles_do = p_ContextObject.GetPhName("aefiles_do");
    m_cServer_aefiles_do = p_ContextObject.GetServer("aefiles_do");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_chiucod")) {
      m_cPhName_tmp_chiucod = p_ContextObject.GetPhName("tmp_chiucod");
      m_cServer_tmp_chiucod = p_ContextObject.GetServer("tmp_chiucod");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_chiunocod")) {
      m_cPhName_tmp_chiunocod = p_ContextObject.GetPhName("tmp_chiunocod");
      m_cServer_tmp_chiunocod = p_ContextObject.GetServer("tmp_chiunocod");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("imprec",p_cVarName)) {
      return imprec;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      return _noprot;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      return _nriga;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      return _newrow;
    }
    if (CPLib.eqr("_r",p_cVarName)) {
      return _r;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_nocodrec",p_cVarName)) {
      return _nocodrec;
    }
    if (CPLib.eqr("_sicodrec",p_cVarName)) {
      return _sicodrec;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_sd_chiusure_delope";
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
    if (CPLib.eqr("_rapold",p_cVarName)) {
      return _rapold;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      return _tipoco;
    }
    if (CPLib.eqr("_cdata1",p_cVarName)) {
      return _cdata1;
    }
    if (CPLib.eqr("_cdata2",p_cVarName)) {
      return _cdata2;
    }
    if (CPLib.eqr("_cdata3",p_cVarName)) {
      return _cdata3;
    }
    if (CPLib.eqr("_cdata4",p_cVarName)) {
      return _cdata4;
    }
    if (CPLib.eqr("_descit",p_cVarName)) {
      return _descit;
    }
    if (CPLib.eqr("_file",p_cVarName)) {
      return _file;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
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
    if (CPLib.eqr("_intefisc",p_cVarName)) {
      return _intefisc;
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
    if (CPLib.eqr("imprec",p_cVarName)) {
      imprec = value;
      return;
    }
    if (CPLib.eqr("_noprot",p_cVarName)) {
      _noprot = value;
      return;
    }
    if (CPLib.eqr("_nriga",p_cVarName)) {
      _nriga = value;
      return;
    }
    if (CPLib.eqr("_newrow",p_cVarName)) {
      _newrow = value;
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
    if (CPLib.eqr("_nocodrec",p_cVarName)) {
      _nocodrec = value;
      return;
    }
    if (CPLib.eqr("_sicodrec",p_cVarName)) {
      _sicodrec = value;
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
    if (CPLib.eqr("_rapold",p_cVarName)) {
      _rapold = value;
      return;
    }
    if (CPLib.eqr("_tipoco",p_cVarName)) {
      _tipoco = value;
      return;
    }
    if (CPLib.eqr("_cdata1",p_cVarName)) {
      _cdata1 = value;
      return;
    }
    if (CPLib.eqr("_cdata2",p_cVarName)) {
      _cdata2 = value;
      return;
    }
    if (CPLib.eqr("_cdata3",p_cVarName)) {
      _cdata3 = value;
      return;
    }
    if (CPLib.eqr("_cdata4",p_cVarName)) {
      _cdata4 = value;
      return;
    }
    if (CPLib.eqr("_descit",p_cVarName)) {
      _descit = value;
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
    if (CPLib.eqr("_intefisc",p_cVarName)) {
      _intefisc = value;
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
    /* w_a_data Date */
    /* w_dadata Date */
    /* w_datpri Date */
    /* w_datsecf Date */
    /* w_datseci Date */
    /* w_iniz Char(1) */
    /* w_seco Char(1) */
    /* _errlog Memo */
    /* imprec Numeric(10, 0) */
    /* _noprot Numeric(1, 0) */
    /* _rapold Char(25) */
    /* _tipoco Char(1) */
    /* _nriga Numeric(4, 0) */
    /* _newrow Numeric(4, 0) */
    /* _cdata1 Char(8) */
    /* _cdata2 Char(8) */
    /* _cdata3 Char(8) */
    /* _cdata4 Char(8) */
    /* _descit Char(40) */
    /* _file Memo */
    /* _nomefile Char(15) */
    /* _r Numeric(15, 0) */
    /* _i Numeric(15, 0) */
    /* fhand Char(10) */
    /* cNomeFile Char(30) */
    /* cOnlyNomeFile Char(30) */
    /* cNomeFileZip Char(30) */
    /* cProg Char(10) */
    /* _nocodrec Numeric(10, 0) */
    /* _sicodrec Numeric(10, 0) */
    /* _intefisc Char(16) */
    /* gPathApp Char(80) // Path Applicazione */
    /* gIntemediario Char(11) // Intermediario */
    /* gAzienda Char(10) // Azienda */
    /* Verifica la casistica */
    // * --- Drop temporary table tmp_chiucod
    if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_chiucod")) {
        m_cServer = m_Ctx.GetServer("tmp_chiucod");
        m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_chiucod");
    }
    // * --- Create temporary table tmp_chiucod
    if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_chiucod")) {
        m_cServer = m_Ctx.GetServer("tmp_chiucod");
        m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_chiucod");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_chiucod");
    if ( ! (m_Ctx.IsSharedTemp("tmp_chiucod"))) {
      m_cServer = m_Ctx.GetServer("tmp_chiucod");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_chiucod",m_cServer,"proto")),m_cPhName,"tmp_chiucod",m_Ctx,new String[]{"RAPPORTO"});
    }
    m_cPhName_tmp_chiucod = m_cPhName;
    // * --- Drop temporary table tmp_chiunocod
    if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_chiunocod")) {
        m_cServer = m_Ctx.GetServer("tmp_chiunocod");
        m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_chiunocod");
    }
    // * --- Create temporary table tmp_chiunocod
    if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_chiunocod")) {
        m_cServer = m_Ctx.GetServer("tmp_chiunocod");
        m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_chiunocod");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_chiunocod");
    if ( ! (m_Ctx.IsSharedTemp("tmp_chiunocod"))) {
      m_cServer = m_Ctx.GetServer("tmp_chiunocod");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_chiunocod",m_cServer,"proto")),m_cPhName,"tmp_chiunocod",m_Ctx,new String[]{"RAPPORTO"});
    }
    m_cPhName_tmp_chiunocod = m_cPhName;
    /* Case w_seco='S' and w_iniz='N' and Empty(w_dadata) and Empty(w_a_data) */
    if (CPLib.eqr(w_seco,"S") && CPLib.eqr(w_iniz,"N") && CPLib.Empty(w_dadata) && CPLib.Empty(w_a_data)) {
      /* Exec "Secondo Invio" Page 2 */
      Page_2();
      /* Case w_iniz='N' and w_seco='N' and not(Empty(w_dadata)) and not(Empty(w_a_data)) */
    } else if (CPLib.eqr(w_iniz,"N") && CPLib.eqr(w_seco,"N") &&  ! (CPLib.Empty(w_dadata)) &&  ! (CPLib.Empty(w_a_data))) {
      /* Exec "Invii Periodici" Page 3 */
      Page_3();
    } else { // Otherwise
      /* _errlog := 'Impossibile effettuare operazione' + NL + 'Selezionare Secondo invio o Periodo' */
      _errlog = "Impossibile effettuare operazione"+"\n"+"Selezionare Secondo invio o Periodo";
    } // End Case
    /* If Empty(LRTrim(_errlog)) */
    if (CPLib.Empty(CPLib.LRTrim(_errlog))) {
      /* Return  */
      Forward f;
      f=new Forward("arpg_filesage_do",false,this,Forward.Start,false);
      f.SetParameter("m_cParameterSequence", "");
      f.SetParameter("m_cMode","hyperlink");
      throw f;
    } else { // Else
    } // End If
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_invio_delope_chi_1=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_chiucod=null;
    CPResultSet Cursor_tmp_chiunocod=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Secondo Invio */
      /* _nocodrec := 0 */
      _nocodrec = CPLib.Round(0,0);
      // * --- Select from qbe_invio_delope_chi_1
      if (Cursor_qbe_invio_delope_chi_1!=null)
        Cursor_qbe_invio_delope_chi_1.Close();
      Cursor_qbe_invio_delope_chi_1 = new VQRHolder("qbe_invio_delope_chi_1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_invio_delope_chi_1.Eof())) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* If personbo->CFESTERO=1 */
          if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
            /* _descit := '' */
            _descit = "";
            /* If not(Empty(personbo->COGNOME)) and not(Empty(personbo->NOME)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
              /* _cdata1 := Right(DateToChar(personbo->DATANASC),2)+Substr(DateToChar(personbo->DATANASC),5,2)+Left(DateToChar(personbo->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_1->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_1->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_1->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_1->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_1->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_1->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),4);
              // * --- Insert into tmp_chiunocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiunocod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiunocod")+" (";
              m_cSql = m_cSql+GetFieldsName_0B8F3DC0(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_personbo.GetString("SESSO"),"F") || CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("EE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiunocod",true);
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
              /* If not(Empty(personbo->PAESE)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("PAESE")))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _descit = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_sd_chiusure_delope returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _descit := iif(not(Empty(_descit)),_descit,personbo->DESCCIT) */
                _descit = ( ! (CPLib.Empty(_descit))?_descit:Cursor_personbo.GetString("DESCCIT"));
              } else { // Else
                /* _descit := personbo->DESCCIT */
                _descit = Cursor_personbo.GetString("DESCCIT");
              } // End If
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_1->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_1->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_1->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_1->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_1->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_1->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),4);
              // * --- Insert into tmp_chiunocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiunocod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiunocod")+" (";
              m_cSql = m_cSql+GetFieldsName_0ACF88D8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_personbo.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))?"EE":Cursor_personbo.GetString("PROVINCIA")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("APROG"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiunocod",true);
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
            /* _nocodrec := _nocodrec + 1 */
            _nocodrec = CPLib.Round(_nocodrec+1,0);
          } else { // Else
            /* If not(Empty(personbo->COGNOME)) and not(Empty(personbo->NOME)) and Len(LRTrim(personbo->CODFISC)) = 16 */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("NOME"))) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
              /* _cdata1 := Right(DateToChar(personbo->DATANASC),2)+Substr(DateToChar(personbo->DATANASC),5,2)+Left(DateToChar(personbo->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_1->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_1->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_1->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_1->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_1->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_1->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),4);
              /* If not(Empty(personbo->NASSTATO)) and Upper(LRTrim(personbo->NASSTATO)) <> 'ITALIA' */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALIA")) {
                /* _descit := personbo->NASSTATO */
                _descit = Cursor_personbo.GetString("NASSTATO");
              } else { // Else
                /* _descit := personbo->NASCOMUN */
                _descit = Cursor_personbo.GetString("NASCOMUN");
              } // End If
              // * --- Insert into tmp_chiucod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiucod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiucod")+" (";
              m_cSql = m_cSql+GetFieldsName_0B8456B8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_personbo.GetString("SESSO"),"F") || CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("APROG"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiucod",true);
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
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_1->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_1->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_1->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_1->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_1->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_1->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_1.GetDate("CDATA")),4);
              // * --- Insert into tmp_chiucod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiucod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiucod")+" (";
              m_cSql = m_cSql+GetFieldsName_0B96B670(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_personbo.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_1.GetString("APROG"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiucod",true);
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
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        Cursor_qbe_invio_delope_chi_1.Next();
      }
      m_cConnectivityError = Cursor_qbe_invio_delope_chi_1.ErrorMessage();
      Cursor_qbe_invio_delope_chi_1.Close();
      // * --- End Select
      /* _nomefile := '99'+Right(DateTimeToChar(DateTime()),12)+'2' */
      _nomefile = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"2";
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
        /* _intefisc := intermbo->CODFISC */
        _intefisc = Cursor_intermbo.GetString("CODFISC");
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
      /* Crea Record di testa */
      /* _file := _file + '200800' */
      _file = _file+"200800";
      /* _file := _file + '2' */
      _file = _file+"2";
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
      // * --- Select from tmp_chiucod
      m_cServer = m_Ctx.GetServer("tmp_chiucod");
      m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
      if (Cursor_tmp_chiucod!=null)
        Cursor_tmp_chiucod.Close();
      Cursor_tmp_chiucod = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_chiucod")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_chiucod.Eof())) {
        /* If _i = 1 */
        if (CPLib.eqr(_i,1)) {
          /* _file := _file + tmp_chiucod->TIPOREC */
          _file = _file+Cursor_tmp_chiucod.GetString("TIPOREC");
        } // End If
        /* _r := _r + 1 */
        _r = CPLib.Round(_r+1,0);
        /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
        _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
        /* _file := _file + Left(LRTrim(_intefisc)+Space(16),16) */
        _file = _file+CPLib.Left(CPLib.LRTrim(_intefisc)+CPLib.Space(16),16);
        /* _file := _file + Right("00000000000000000000000000" + LRTrim(tmp_chiucod->IDFILE),15) */
        _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiucod.GetString("IDFILE")),15);
        /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(tmp_chiucod->PROGRIF),25) */
        _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROGRIF")),25);
        /* _file := _file + Left(LRTrim(tmp_chiucod->CODFISC) + Space(16),16) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("CODFISC"))+CPLib.Space(16),16);
        /* _file := _file + Left(LRTrim(tmp_chiucod->COGNOME) + Space(26),26) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COGNOME"))+CPLib.Space(26),26);
        /* _file := _file + Left(LRTrim(tmp_chiucod->NOME) + Space(25),25) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("NOME"))+CPLib.Space(25),25);
        /* _file := _file + Left(LRTrim(tmp_chiucod->SESSO)+Space(1),1) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("SESSO"))+CPLib.Space(1),1);
        /* _file := _file + Left(LRTrim(tmp_chiucod->DATANASC) + Space(8),8) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATANASC"))+CPLib.Space(8),8);
        /* _file := _file + Left(LRTrim(tmp_chiucod->COMSTA) + Space(40),40) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COMSTA"))+CPLib.Space(40),40);
        /* _file := _file + Left(LRTrim(tmp_chiucod->PROVNA) + Space(2),2) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROVNA"))+CPLib.Space(2),2);
        /* _file := _file + Left(LRTrim(tmp_chiucod->DENOM) + Space(60),60) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DENOM"))+CPLib.Space(60),60);
        /* _file := _file + Left(LRTrim(tmp_chiucod->COMSEDE) + Space(40),40) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COMSEDE"))+CPLib.Space(40),40);
        /* _file := _file + Left(LRTrim(tmp_chiucod->PROVSED) + Space(2),2) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROVSED"))+CPLib.Space(2),2);
        /* _file := _file + Left(LRTrim(tmp_chiucod->TIPORAP) + Space(2),2) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("TIPORAP"))+CPLib.Space(2),2);
        /* _file := _file + Left(LRTrim(tmp_chiucod->COINT) + Space(1),1) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COINT"))+CPLib.Space(1),1);
        /* _file := _file + Left(LRTrim(tmp_chiucod->DATAINI) + Space(8),8) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATAINI"))+CPLib.Space(8),8);
        /* _file := _file + Left(LRTrim(tmp_chiucod->DATACHIU) + Space(8),8) */
        _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATACHIU"))+CPLib.Space(8),8);
        /* _file := _file + Space(9) */
        _file = _file+CPLib.Space(9);
        /* _file := _file + '*' */
        _file = _file+"*";
        /* _i := _i + 1 */
        _i = CPLib.Round(_i+1,0);
        /* If _i=6 */
        if (CPLib.eqr(_i,6)) {
          /* _i := 1 */
          _i = CPLib.Round(1,0);
          /* _file := _file + Space(146) */
          _file = _file+CPLib.Space(146);
          /* _file := _file + 'A' */
          _file = _file+"A";
          /* _file := _file + NL */
          _file = _file+"\n";
        } // End If
        // * --- Write into aerighe from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aerighe");
        m_cPhName = m_Ctx.GetPhName("aerighe");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = "Update "+m_cPhName+" set ";
        m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
        m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
        m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
        m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_datsecf,"D",8,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_chiucod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_chiucod.GetString("IDBASE"))+"";
        if (m_Ctx.IsSharedTemp("aerighe")) {
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
        Cursor_tmp_chiucod.Next();
      }
      m_cConnectivityError = Cursor_tmp_chiucod.ErrorMessage();
      Cursor_tmp_chiucod.Close();
      // * --- End Select
      /* If _i > 1 and _i < 6 */
      if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
        /* While _i < 6 */
        while (CPLib.lt(_i,6)) {
          /* _file := _file + Space(329) */
          _file = _file+CPLib.Space(329);
          /* _file := _file + '*' */
          _file = _file+"*";
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
        } // End While
        /* _file := _file + Space(146) */
        _file = _file+CPLib.Space(146);
        /* _file := _file + 'A' */
        _file = _file+"A";
        /* _file := _file + NL */
        _file = _file+"\n";
      } // End If
      /* _file := _file + '9CCB00' + '34' */
      _file = _file+"9CCB00"+"34";
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
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
      /* _file := _file + '200800' */
      _file = _file+"200800";
      /* _file := _file + '2' */
      _file = _file+"2";
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
      m_cSql = m_cSql+GetFieldsName_0B55B460(m_Ctx);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile)+".zip","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("Secondo Invio Chiusure Soggetti Italiani","?",0,0,m_cServer)+", ";
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
      /* Exec "Crea file zip" Page 4 */
      Page_4();
      /* FileLibMit.DeleteFile(cNomeFile) */
      FileLibMit.DeleteFile(cNomeFile);
      /* If _nocodrec > 0 */
      if (CPLib.gt(_nocodrec,0)) {
        // * --- Write into intermbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = "Update "+m_cPhName+" set ";
        m_cSql = m_cSql+"CONTATORE = "+CPLib.ToSQL(_r,"N",15,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gIntemediario,"?",0,0,m_cServer),m_cServer,gIntemediario)+"";
        if (m_Ctx.IsSharedTemp("intermbo")) {
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
        /* _nomefile := '99'+Right(DateTimeToChar(DateTime()),12)+'5' */
        _nomefile = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"5";
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
          /* _intefisc := intermbo->CODFISC */
          _intefisc = Cursor_intermbo.GetString("CODFISC");
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
        /* _file := _file + '200800' */
        _file = _file+"200800";
        /* _file := _file + '5' */
        _file = _file+"5";
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
        // * --- Select from tmp_chiunocod
        m_cServer = m_Ctx.GetServer("tmp_chiunocod");
        m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
        if (Cursor_tmp_chiunocod!=null)
          Cursor_tmp_chiunocod.Close();
        Cursor_tmp_chiunocod = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_chiunocod")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_chiunocod.Eof())) {
          /* If _i = 1 */
          if (CPLib.eqr(_i,1)) {
            /* _file := _file + tmp_chiunocod->TIPOREC */
            _file = _file+Cursor_tmp_chiunocod.GetString("TIPOREC");
          } // End If
          /* _r := _r + 1 */
          _r = CPLib.Round(_r+1,0);
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
          /* _file := _file + Left(LRTrim(_intefisc)+Space(16),16) */
          _file = _file+CPLib.Left(CPLib.LRTrim(_intefisc)+CPLib.Space(16),16);
          /* _file := _file + Right("00000000000000000000000000" + LRTrim(tmp_chiunocod->IDFILE),15) */
          _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("IDFILE")),15);
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(tmp_chiunocod->PROGRIF),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROGRIF")),25);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->COGNOME) + Space(26),26) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COGNOME"))+CPLib.Space(26),26);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->NOME) + Space(25),25) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("NOME"))+CPLib.Space(25),25);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->SESSO)+Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("SESSO"))+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->DATANASC) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATANASC"))+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->COMSTA) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COMSTA"))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->PROVNA) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROVNA"))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->DENOM) + Space(60),60) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DENOM"))+CPLib.Space(60),60);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->COMSEDE) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COMSEDE"))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->PROVSED) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROVSED"))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->TIPORAP) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("TIPORAP"))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->COINT) + Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COINT"))+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->DATAINI) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATAINI"))+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->DATACHIU) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATACHIU"))+CPLib.Space(8),8);
          /* _file := _file + Space(25) */
          _file = _file+CPLib.Space(25);
          /* _file := _file + '*' */
          _file = _file+"*";
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
          /* If _i=6 */
          if (CPLib.eqr(_i,6)) {
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* _file := _file + Space(146) */
            _file = _file+CPLib.Space(146);
            /* _file := _file + 'A' */
            _file = _file+"A";
            /* _file := _file + NL */
            _file = _file+"\n";
          } // End If
          // * --- Write into aerighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_datsecf,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_chiunocod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_chiunocod.GetString("IDBASE"))+"";
          if (m_Ctx.IsSharedTemp("aerighe")) {
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
          Cursor_tmp_chiunocod.Next();
        }
        m_cConnectivityError = Cursor_tmp_chiunocod.ErrorMessage();
        Cursor_tmp_chiunocod.Close();
        // * --- End Select
        /* If _i > 1 and _i < 6 */
        if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
          /* While _i < 6 */
          while (CPLib.lt(_i,6)) {
            /* _file := _file + Space(329) */
            _file = _file+CPLib.Space(329);
            /* _file := _file + '*' */
            _file = _file+"*";
            /* _i := _i + 1 */
            _i = CPLib.Round(_i+1,0);
          } // End While
          /* _file := _file + Space(146) */
          _file = _file+CPLib.Space(146);
          /* _file := _file + 'A' */
          _file = _file+"A";
          /* _file := _file + NL */
          _file = _file+"\n";
        } // End If
        /* _file := _file + '9CCB00' + '34' */
        _file = _file+"9CCB00"+"34";
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
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
        /* _file := _file + '200800' */
        _file = _file+"200800";
        /* _file := _file + '5' */
        _file = _file+"5";
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
        m_cSql = m_cSql+GetFieldsName_0B541CD0(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile)+".zip","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Secondo Invio Chiusure Soggetti Esteri","?",0,0,m_cServer)+", ";
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
        /* Exec "Crea file zip" Page 4 */
        Page_4();
        /* FileLibMit.DeleteFile(cNomeFile) */
        FileLibMit.DeleteFile(cNomeFile);
      } // End If
      // * --- Write into intermbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "Update "+m_cPhName+" set ";
      m_cSql = m_cSql+"CONTATORE = "+CPLib.ToSQL(_r,"N",15,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gIntemediario,"?",0,0,m_cServer),m_cServer,gIntemediario)+"";
      if (m_Ctx.IsSharedTemp("intermbo")) {
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
    } finally {
      try {
        if (Cursor_qbe_invio_delope_chi_1!=null)
          Cursor_qbe_invio_delope_chi_1.Close();
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
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_chiucod!=null)
          Cursor_tmp_chiucod.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_chiunocod!=null)
          Cursor_tmp_chiunocod.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    CPResultSet Cursor_qbe_invio_delope_chi_2=null;
    CPResultSet Cursor_personbo=null;
    CPResultSet Read_Cursor=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_tmp_chiucod=null;
    CPResultSet Cursor_tmp_chiunocod=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Invii Periodici */
      /* _nocodrec := 0 */
      _nocodrec = CPLib.Round(0,0);
      /* _sicodrec := 0 */
      _sicodrec = CPLib.Round(0,0);
      // * --- Select from qbe_invio_delope_chi_2
      if (Cursor_qbe_invio_delope_chi_2!=null)
        Cursor_qbe_invio_delope_chi_2.Close();
      Cursor_qbe_invio_delope_chi_2 = new VQRHolder("qbe_invio_delope_chi_2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_invio_delope_chi_2.Eof())) {
        // * --- Select from personbo
        m_cServer = m_Ctx.GetServer("personbo");
        m_cPhName = m_Ctx.GetPhName("personbo");
        if (Cursor_personbo!=null)
          Cursor_personbo.Close();
        Cursor_personbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"CONNES="+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("CONNESINT"),"?",0,0)+" "+")"+(m_Ctx.IsSharedTemp("personbo")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_personbo.Eof())) {
          /* If personbo->CFESTERO=1 */
          if (CPLib.eqr(Cursor_personbo.GetDouble("CFESTERO"),1)) {
            /* _descit := '' */
            _descit = "";
            /* If not(Empty(personbo->COGNOME)) and not(Empty(personbo->NOME)) */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("NOME")))) {
              /* _cdata1 := Right(DateToChar(personbo->DATANASC),2)+Substr(DateToChar(personbo->DATANASC),5,2)+Left(DateToChar(personbo->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_2->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_2->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),4);
              // * --- Insert into tmp_chiunocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiunocod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiunocod")+" (";
              m_cSql = m_cSql+GetFieldsName_0B512AB8(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_personbo.GetString("SESSO"),"F") || CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NASSTATO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL("EE","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiunocod",true);
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
              /* If not(Empty(personbo->PAESE)) */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("PAESE")))) {
                // * --- Read from tbstati
                m_cServer = m_Ctx.GetServer("tbstati");
                m_cPhName = m_Ctx.GetPhName("tbstati");
                m_cSql = "";
                m_cSql = m_cSql+"CODSTA="+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_personbo.GetString("PAESE"),"C",3,0,m_cServer),m_cServer,Cursor_personbo.GetString("PAESE"));
                if (m_Ctx.IsSharedTemp("tbstati")) {
                  m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
                }
                if (Read_Cursor!=null)
                  Read_Cursor.Close();
                Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DESCRI",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
                if ( ! (Read_Cursor.Eof())) {
                  _descit = Read_Cursor.GetString("DESCRI");
                  Read_Cursor.Next();
                  if ( ! (Read_Cursor.Eof())) {
                    Error l_oErrorFault = new Error("Read on tbstati into routine arrt_sd_chiusure_delope returns two or more records. This item should return only a record.");
                    CPStdCounter.Error(l_oErrorFault);
                  }
                  Read_Cursor.Close();
                } else {
                  // Error: no record found!
                  _descit = "";
                  Read_Cursor.Close();
                  m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
                }
                /* _descit := iif(not(Empty(_descit)),_descit,personbo->DESCCIT) */
                _descit = ( ! (CPLib.Empty(_descit))?_descit:Cursor_personbo.GetString("DESCCIT"));
              } else { // Else
                /* _descit := personbo->DESCCIT */
                _descit = Cursor_personbo.GetString("DESCCIT");
              } // End If
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_2->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_2->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),4);
              // * --- Insert into tmp_chiunocod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiunocod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiunocod")+" (";
              m_cSql = m_cSql+GetFieldsName_0AF94B30(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("5","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_personbo.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.Empty(Cursor_personbo.GetString("PROVINCIA"))?"EE":Cursor_personbo.GetString("PROVINCIA")),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiunocod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiunocod",true);
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
            /* _nocodrec := _nocodrec + 1 */
            _nocodrec = CPLib.Round(_nocodrec+1,0);
          } else { // Else
            /* If not(Empty(personbo->COGNOME)) and not(Empty(personbo->NOME)) and Len(LRTrim(personbo->CODFISC)) = 16 */
            if ( ! (CPLib.Empty(Cursor_personbo.GetString("COGNOME"))) &&  ! (CPLib.Empty(Cursor_personbo.GetString("NOME"))) && CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_personbo.GetString("CODFISC"))),16)) {
              /* _cdata1 := Right(DateToChar(personbo->DATANASC),2)+Substr(DateToChar(personbo->DATANASC),5,2)+Left(DateToChar(personbo->DATANASC),4) */
              _cdata1 = CPLib.Right(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_personbo.GetDate("DATANASC")),4);
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_2->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_2->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),4);
              /* If not(Empty(personbo->NASSTATO)) and Upper(LRTrim(personbo->NASSTATO)) <> 'ITALIA' */
              if ( ! (CPLib.Empty(Cursor_personbo.GetString("NASSTATO"))) && CPLib.ne(CPLib.Upper(CPLib.LRTrim(Cursor_personbo.GetString("NASSTATO"))),"ITALIA")) {
                /* _descit := personbo->NASSTATO */
                _descit = Cursor_personbo.GetString("NASSTATO");
              } else { // Else
                /* _descit := personbo->NASCOMUN */
                _descit = Cursor_personbo.GetString("NASCOMUN");
              } // End If
              // * --- Insert into tmp_chiucod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiucod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiucod")+" (";
              m_cSql = m_cSql+GetFieldsName_0ABD1728(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("COGNOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("NOME"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL((CPLib.eqr(Cursor_personbo.GetString("SESSO"),"F") || CPLib.eqr(Cursor_personbo.GetString("SESSO"),"2")?"F":"M"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_descit,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("TIPINTER"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiucod",true);
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
              /* _cdata2 := Right(DateToChar(qbe_invio_delope_chi_2->ADATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->ADATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->ADATA),4) */
              _cdata2 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("ADATA")),4);
              /* _cdata3 := Right(DateToChar(qbe_invio_delope_chi_2->CDATA),2)+Substr(DateToChar(qbe_invio_delope_chi_2->CDATA),5,2)+Left(DateToChar(qbe_invio_delope_chi_2->CDATA),4) */
              _cdata3 = CPLib.Right(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),2)+CPLib.Substr(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),5,2)+CPLib.Left(CPLib.DateToChar(Cursor_qbe_invio_delope_chi_2.GetDate("CDATA")),4);
              // * --- Insert into tmp_chiucod from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("tmp_chiucod");
              m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.InsertIntoStatement(m_Ctx,"tmp_chiucod")+" (";
              m_cSql = m_cSql+GetFieldsName_0B502450(m_Ctx);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("TIPOAG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("COINT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("RAPPORTO"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(_cdata3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("IDBASE"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(Cursor_personbo.GetString("RAGSOC"),60),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("DESCCIT"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_personbo.GetString("PROVINCIA"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("APROG"),"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_invio_delope_chi_2.GetString("AFILE"),"?",0,0,m_cServer)+", ";
              if (m_Ctx.IsSharedTemp("tmp_chiucod")) {
                m_cSql = m_cSql+"'"+m_Ctx.GetTempID()+"', ";
              }
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_chiucod",true);
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
            /* _sicodrec := _sicodrec + 1 */
            _sicodrec = CPLib.Round(_sicodrec+1,0);
          } // End If
          Cursor_personbo.Next();
        }
        m_cConnectivityError = Cursor_personbo.ErrorMessage();
        Cursor_personbo.Close();
        // * --- End Select
        Cursor_qbe_invio_delope_chi_2.Next();
      }
      m_cConnectivityError = Cursor_qbe_invio_delope_chi_2.ErrorMessage();
      Cursor_qbe_invio_delope_chi_2.Close();
      // * --- End Select
      /* If _sicodrec > 0 */
      if (CPLib.gt(_sicodrec,0)) {
        /* _nomefile := '99'+Right(DateTimeToChar(DateTime()),12)+'2' */
        _nomefile = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"2";
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
          /* _intefisc := intermbo->CODFISC */
          _intefisc = Cursor_intermbo.GetString("CODFISC");
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
        /* Crea Record di testa */
        /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
        _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
        /* _file := _file + '2' */
        _file = _file+"2";
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
        // * --- Select from tmp_chiucod
        m_cServer = m_Ctx.GetServer("tmp_chiucod");
        m_cPhName = m_Ctx.GetPhName("tmp_chiucod");
        if (Cursor_tmp_chiucod!=null)
          Cursor_tmp_chiucod.Close();
        Cursor_tmp_chiucod = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_chiucod")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_chiucod.Eof())) {
          /* If _i = 1 */
          if (CPLib.eqr(_i,1)) {
            /* _file := _file + tmp_chiucod->TIPOREC */
            _file = _file+Cursor_tmp_chiucod.GetString("TIPOREC");
          } // End If
          /* _r := _r + 1 */
          _r = CPLib.Round(_r+1,0);
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
          /* _file := _file + Left(LRTrim(_intefisc)+Space(16),16) */
          _file = _file+CPLib.Left(CPLib.LRTrim(_intefisc)+CPLib.Space(16),16);
          /* _file := _file + Right("00000000000000000000000000" + LRTrim(tmp_chiucod->IDFILE),15) */
          _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiucod.GetString("IDFILE")),15);
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(tmp_chiucod->PROGRIF),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROGRIF")),25);
          /* _file := _file + Left(LRTrim(tmp_chiucod->CODFISC) + Space(16),16) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("CODFISC"))+CPLib.Space(16),16);
          /* _file := _file + Left(LRTrim(tmp_chiucod->COGNOME) + Space(26),26) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COGNOME"))+CPLib.Space(26),26);
          /* _file := _file + Left(LRTrim(tmp_chiucod->NOME) + Space(25),25) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("NOME"))+CPLib.Space(25),25);
          /* _file := _file + Left(LRTrim(tmp_chiucod->SESSO)+Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("SESSO"))+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(tmp_chiucod->DATANASC) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATANASC"))+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(tmp_chiucod->COMSTA) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COMSTA"))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(tmp_chiucod->PROVNA) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROVNA"))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(tmp_chiucod->DENOM) + Space(60),60) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DENOM"))+CPLib.Space(60),60);
          /* _file := _file + Left(LRTrim(tmp_chiucod->COMSEDE) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COMSEDE"))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(tmp_chiucod->PROVSED) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("PROVSED"))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(tmp_chiucod->TIPORAP) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("TIPORAP"))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(tmp_chiucod->COINT) + Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("COINT"))+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(tmp_chiucod->DATAINI) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATAINI"))+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(tmp_chiucod->DATACHIU) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiucod.GetString("DATACHIU"))+CPLib.Space(8),8);
          /* _file := _file + Space(9) */
          _file = _file+CPLib.Space(9);
          /* _file := _file + '*' */
          _file = _file+"*";
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
          /* If _i=6 */
          if (CPLib.eqr(_i,6)) {
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* _file := _file + Space(146) */
            _file = _file+CPLib.Space(146);
            /* _file := _file + 'A' */
            _file = _file+"A";
            /* _file := _file + NL */
            _file = _file+"\n";
          } // End If
          // * --- Write into aerighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_chiucod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_chiucod.GetString("IDBASE"))+"";
          if (m_Ctx.IsSharedTemp("aerighe")) {
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
          Cursor_tmp_chiucod.Next();
        }
        m_cConnectivityError = Cursor_tmp_chiucod.ErrorMessage();
        Cursor_tmp_chiucod.Close();
        // * --- End Select
        /* If _i > 1 and _i < 6 */
        if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
          /* While _i < 6 */
          while (CPLib.lt(_i,6)) {
            /* _file := _file + Space(329) */
            _file = _file+CPLib.Space(329);
            /* _file := _file + '*' */
            _file = _file+"*";
            /* _i := _i + 1 */
            _i = CPLib.Round(_i+1,0);
          } // End While
          /* _file := _file + Space(146) */
          _file = _file+CPLib.Space(146);
          /* _file := _file + 'A' */
          _file = _file+"A";
          /* _file := _file + NL */
          _file = _file+"\n";
        } // End If
        /* _file := _file + '9CCB00' + '34' */
        _file = _file+"9CCB00"+"34";
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
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
        /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+LRTrim(Str(Month(w_a_data),2,0)),2) */
        _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.LRTrim(CPLib.Str(CPLib.Month(w_a_data),2,0)),2);
        /* _file := _file + '2' */
        _file = _file+"2";
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
        m_cSql = m_cSql+GetFieldsName_0AFB3B18(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile)+".zip","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.Str(CPLib.Month(w_a_data),2,0),2)+"Chiusure Soggetti Italiani","?",0,0,m_cServer)+", ";
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
        /* Exec "Crea file zip" Page 4 */
        Page_4();
        /* FileLibMit.DeleteFile(cNomeFile) */
        FileLibMit.DeleteFile(cNomeFile);
      } // End If
      /* If _nocodrec > 0 */
      if (CPLib.gt(_nocodrec,0)) {
        // * --- Write into intermbo from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = "Update "+m_cPhName+" set ";
        m_cSql = m_cSql+"CONTATORE = "+CPLib.ToSQL(_r,"N",15,0)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gIntemediario,"?",0,0,m_cServer),m_cServer,gIntemediario)+"";
        if (m_Ctx.IsSharedTemp("intermbo")) {
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
        /* _nomefile := '99'+Right(DateTimeToChar(DateTime()),12)+'5' */
        _nomefile = "99"+CPLib.Right(CPLib.DateTimeToChar(CPLib.DateTime()),12)+"5";
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
          /* _intefisc := intermbo->CODFISC */
          _intefisc = Cursor_intermbo.GetString("CODFISC");
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
        /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+Str(Month(w_a_data),2,0),2) */
        _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.Str(CPLib.Month(w_a_data),2,0),2);
        /* _file := _file + '5' */
        _file = _file+"5";
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
        // * --- Select from tmp_chiunocod
        m_cServer = m_Ctx.GetServer("tmp_chiunocod");
        m_cPhName = m_Ctx.GetPhName("tmp_chiunocod");
        if (Cursor_tmp_chiunocod!=null)
          Cursor_tmp_chiunocod.Close();
        Cursor_tmp_chiunocod = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_chiunocod")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_chiunocod.Eof())) {
          /* If _i = 1 */
          if (CPLib.eqr(_i,1)) {
            /* _file := _file + tmp_chiunocod->TIPOREC */
            _file = _file+Cursor_tmp_chiunocod.GetString("TIPOREC");
          } // End If
          /* _r := _r + 1 */
          _r = CPLib.Round(_r+1,0);
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(Str(_r)),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(CPLib.Str(_r)),25);
          /* _file := _file + Left(LRTrim(_intefisc)+Space(16),16) */
          _file = _file+CPLib.Left(CPLib.LRTrim(_intefisc)+CPLib.Space(16),16);
          /* _file := _file + Right("00000000000000000000000000" + LRTrim(tmp_chiunocod->IDFILE),15) */
          _file = _file+CPLib.Right("00000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("IDFILE")),15);
          /* _file := _file + Right("0000000000000000000000000000000000000000" + LRTrim(tmp_chiunocod->PROGRIF),25) */
          _file = _file+CPLib.Right("0000000000000000000000000000000000000000"+CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROGRIF")),25);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->COGNOME) + Space(26),26) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COGNOME"))+CPLib.Space(26),26);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->NOME) + Space(25),25) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("NOME"))+CPLib.Space(25),25);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->SESSO)+Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("SESSO"))+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->DATANASC) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATANASC"))+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->COMSTA) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COMSTA"))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->PROVNA) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROVNA"))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->DENOM) + Space(60),60) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DENOM"))+CPLib.Space(60),60);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->COMSEDE) + Space(40),40) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COMSEDE"))+CPLib.Space(40),40);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->PROVSED) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("PROVSED"))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->TIPORAP) + Space(2),2) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("TIPORAP"))+CPLib.Space(2),2);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->COINT) + Space(1),1) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("COINT"))+CPLib.Space(1),1);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->DATAINI) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATAINI"))+CPLib.Space(8),8);
          /* _file := _file + Left(LRTrim(tmp_chiunocod->DATACHIU) + Space(8),8) */
          _file = _file+CPLib.Left(CPLib.LRTrim(Cursor_tmp_chiunocod.GetString("DATACHIU"))+CPLib.Space(8),8);
          /* _file := _file + Space(25) */
          _file = _file+CPLib.Space(25);
          /* _file := _file + '*' */
          _file = _file+"*";
          /* _i := _i + 1 */
          _i = CPLib.Round(_i+1,0);
          /* If _i=6 */
          if (CPLib.eqr(_i,6)) {
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* _file := _file + Space(146) */
            _file = _file+CPLib.Space(146);
            /* _file := _file + 'A' */
            _file = _file+"A";
            /* _file := _file + NL */
            _file = _file+"\n";
          } // End If
          // * --- Write into aerighe from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aerighe");
          m_cPhName = m_Ctx.GetPhName("aerighe");
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = "Update "+m_cPhName+" set ";
          m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(1,"N",1,0)+", ";
          m_cSql = m_cSql+"CPROG = "+CPLib.ToSQL(_r,"C",25,0,m_cServer)+", ";
          m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL(_nomefile,"C",15,0,m_cServer)+", ";
          m_cSql = m_cSql+"NOCODFISC = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
          m_cSql = m_cSql+"CDTPRE = "+CPLib.ToSQL(w_a_data,"D",8,0)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aerighe",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"IDBASE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_chiunocod.GetString("IDBASE"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_chiunocod.GetString("IDBASE"))+"";
          if (m_Ctx.IsSharedTemp("aerighe")) {
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
          Cursor_tmp_chiunocod.Next();
        }
        m_cConnectivityError = Cursor_tmp_chiunocod.ErrorMessage();
        Cursor_tmp_chiunocod.Close();
        // * --- End Select
        /* If _i > 1 and _i < 6 */
        if (CPLib.gt(_i,1) && CPLib.lt(_i,6)) {
          /* While _i < 6 */
          while (CPLib.lt(_i,6)) {
            /* _file := _file + Space(329) */
            _file = _file+CPLib.Space(329);
            /* _file := _file + '*' */
            _file = _file+"*";
            /* _i := _i + 1 */
            _i = CPLib.Round(_i+1,0);
          } // End While
          /* _file := _file + Space(146) */
          _file = _file+CPLib.Space(146);
          /* _file := _file + 'A' */
          _file = _file+"A";
          /* _file := _file + NL */
          _file = _file+"\n";
        } // End If
        /* _file := _file + '9CCB00' + '34' */
        _file = _file+"9CCB00"+"34";
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
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
        /* _file := _file + Right("0000"+Str(Year(w_a_data),4,0),4)+Right("00"+Str(Month(w_a_data),2,0),2) */
        _file = _file+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.Str(CPLib.Month(w_a_data),2,0),2);
        /* _file := _file + '5' */
        _file = _file+"5";
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
        m_cSql = m_cSql+GetFieldsName_0B86FAF8(m_Ctx);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(_nomefile)+".zip","?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL("Invio "+CPLib.Right("0000"+CPLib.Str(CPLib.Year(w_a_data),4,0),4)+CPLib.Right("00"+CPLib.Str(CPLib.Month(w_a_data),2,0),2)+"Chiusure Soggetti Esteri","?",0,0,m_cServer)+", ";
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
        /* Exec "Crea file zip" Page 4 */
        Page_4();
        /* FileLibMit.DeleteFile(cNomeFile) */
        FileLibMit.DeleteFile(cNomeFile);
      } // End If
      // * --- Write into intermbo from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = "Update "+m_cPhName+" set ";
      m_cSql = m_cSql+"CONTATORE = "+CPLib.ToSQL(_r,"N",15,0)+", ";
      m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"intermbo",false,true);
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINTER = "+CPSql.SQLValueAdapter(CPLib.ToSQL(gIntemediario,"?",0,0,m_cServer),m_cServer,gIntemediario)+"";
      if (m_Ctx.IsSharedTemp("intermbo")) {
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
    } finally {
      try {
        if (Cursor_qbe_invio_delope_chi_2!=null)
          Cursor_qbe_invio_delope_chi_2.Close();
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
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_chiucod!=null)
          Cursor_tmp_chiucod.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_tmp_chiunocod!=null)
          Cursor_tmp_chiunocod.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_4() throws Exception {
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_sd_chiusure_delopeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_sd_chiusure_delopeR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_datpri = m_Caller.GetDate("datpri","D",8,0);
    w_datsecf = m_Caller.GetDate("datsecf","D",8,0);
    w_datseci = m_Caller.GetDate("datseci","D",8,0);
    w_iniz = m_Caller.GetString("iniz","C",1,0);
    w_seco = m_Caller.GetString("seco","C",1,0);
    _errlog = "";
    imprec = 0;
    _noprot = 0;
    _rapold = CPLib.Space(25);
    _tipoco = CPLib.Space(1);
    _nriga = 0;
    _newrow = 0;
    _cdata1 = CPLib.Space(8);
    _cdata2 = CPLib.Space(8);
    _cdata3 = CPLib.Space(8);
    _cdata4 = CPLib.Space(8);
    _descit = CPLib.Space(40);
    _file = "";
    _nomefile = CPLib.Space(15);
    _r = 0;
    _i = 0;
    fhand = CPLib.Space(10);
    cNomeFile = CPLib.Space(30);
    cOnlyNomeFile = CPLib.Space(30);
    cNomeFileZip = CPLib.Space(30);
    cProg = CPLib.Space(10);
    _nocodrec = 0;
    _sicodrec = 0;
    _intefisc = CPLib.Space(16);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_invio_delope_chi_1,qbe_invio_delope_chi_2,
  public static final String m_cVQRList = ",qbe_invio_delope_chi_1,qbe_invio_delope_chi_2,";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_0B8F3DC0(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"COMSTA,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"IDFILE,";
    if (p_Ctx.IsSharedTemp("tmp_chiunocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiunocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0ACF88D8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DENOM,";
    p_cSql = p_cSql+"COMSEDE,";
    p_cSql = p_cSql+"PROVSED,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGRIF,";
    if (p_Ctx.IsSharedTemp("tmp_chiunocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiunocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0B8456B8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"COMSTA,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGRIF,";
    if (p_Ctx.IsSharedTemp("tmp_chiucod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiucod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0B96B670(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DENOM,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"COMSEDE,";
    p_cSql = p_cSql+"PROVSED,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"PROGRIF,";
    if (p_Ctx.IsSharedTemp("tmp_chiucod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiucod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0B55B460(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0B541CD0(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0B512AB8(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"COMSTA,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"IDFILE,";
    if (p_Ctx.IsSharedTemp("tmp_chiunocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiunocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0AF94B30(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DENOM,";
    p_cSql = p_cSql+"COMSEDE,";
    p_cSql = p_cSql+"PROVSED,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"IDFILE,";
    if (p_Ctx.IsSharedTemp("tmp_chiunocod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiunocod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0ABD1728(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"IDFILE,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"SESSO,";
    p_cSql = p_cSql+"DATANASC,";
    p_cSql = p_cSql+"COMSTA,";
    p_cSql = p_cSql+"PROVNA,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CODFISC,";
    if (p_Ctx.IsSharedTemp("tmp_chiucod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiucod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0B502450(CPContext p_Ctx) {
    String p_cSql = "";
    p_cSql = p_cSql+"TIPOREC,";
    p_cSql = p_cSql+"TIPORAP,";
    p_cSql = p_cSql+"COINT,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"DATAINI,";
    p_cSql = p_cSql+"DATACHIU,";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"DENOM,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"COMSEDE,";
    p_cSql = p_cSql+"PROVSED,";
    p_cSql = p_cSql+"PROGRIF,";
    p_cSql = p_cSql+"IDFILE,";
    if (p_Ctx.IsSharedTemp("tmp_chiucod")) {
      p_cSql = p_cSql+"context_id,";
    }
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_chiucod",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0AFB3B18(CPContext p_Ctx) {
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
  protected static String GetFieldsName_0B86FAF8(CPContext p_Ctx) {
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
