// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arrt_start_aaR implements CallerWithObjs {
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
  public String m_cPhName_tmp_allin_anag;
  public String m_cServer_tmp_allin_anag;
  public String m_cPhName_personbo;
  public String m_cServer_personbo;
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
  public String gMsgImp;
  public String gMsgProc;
  public String w_tipoallin;
  public double w_showdata;
  public double _top;
  public double _bottom;
  public double w_Countot;
  public double w_Countok;
  public double w_Countpr;
  public double w_Countpr2;
  public double w_Countko;
  public String w_bloccaedit;
  public String RAGSOC;
  public String NOME;
  public String COGNOME;
  public String SubRag;
  public double NSpazzi;
  public double NSpazzi2;
  public String Controllo;
  public String Allineamento;
  public double _i;
  public double _max;
  public double _cicli;
  public double _conta;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arrt_start_aaR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_start_aa",m_Caller);
    if (m_Ctx.IsTmpAlreadyCreated("tmp_allin_anag")) {
      m_cPhName_tmp_allin_anag = p_ContextObject.GetPhName("tmp_allin_anag");
      if (m_cPhName_tmp_allin_anag.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_allin_anag = m_cPhName_tmp_allin_anag+" "+m_Ctx.GetWritePhName("tmp_allin_anag");
      }
      m_cServer_tmp_allin_anag = p_ContextObject.GetServer("tmp_allin_anag");
    }
    m_cPhName_personbo = p_ContextObject.GetPhName("personbo");
    if (m_cPhName_personbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo = m_cPhName_personbo+" "+m_Ctx.GetWritePhName("personbo");
    }
    m_cServer_personbo = p_ContextObject.GetServer("personbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("showdata",p_cVarName)) {
      return w_showdata;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("Countot",p_cVarName)) {
      return w_Countot;
    }
    if (CPLib.eqr("Countok",p_cVarName)) {
      return w_Countok;
    }
    if (CPLib.eqr("Countpr",p_cVarName)) {
      return w_Countpr;
    }
    if (CPLib.eqr("Countpr2",p_cVarName)) {
      return w_Countpr2;
    }
    if (CPLib.eqr("Countko",p_cVarName)) {
      return w_Countko;
    }
    if (CPLib.eqr("NSpazzi",p_cVarName)) {
      return NSpazzi;
    }
    if (CPLib.eqr("NSpazzi2",p_cVarName)) {
      return NSpazzi2;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      return _i;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
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
      return "arrt_start_aa";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipoallin",p_cVarName)) {
      return w_tipoallin;
    }
    if (CPLib.eqr("bloccaedit",p_cVarName)) {
      return w_bloccaedit;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
    }
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      return RAGSOC;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      return NOME;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      return COGNOME;
    }
    if (CPLib.eqr("SubRag",p_cVarName)) {
      return SubRag;
    }
    if (CPLib.eqr("Controllo",p_cVarName)) {
      return Controllo;
    }
    if (CPLib.eqr("Allineamento",p_cVarName)) {
      return Allineamento;
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
    if (CPLib.eqr("showdata",p_cVarName)) {
      w_showdata = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("Countot",p_cVarName)) {
      w_Countot = value;
      return;
    }
    if (CPLib.eqr("Countok",p_cVarName)) {
      w_Countok = value;
      return;
    }
    if (CPLib.eqr("Countpr",p_cVarName)) {
      w_Countpr = value;
      return;
    }
    if (CPLib.eqr("Countpr2",p_cVarName)) {
      w_Countpr2 = value;
      return;
    }
    if (CPLib.eqr("Countko",p_cVarName)) {
      w_Countko = value;
      return;
    }
    if (CPLib.eqr("NSpazzi",p_cVarName)) {
      NSpazzi = value;
      return;
    }
    if (CPLib.eqr("NSpazzi2",p_cVarName)) {
      NSpazzi2 = value;
      return;
    }
    if (CPLib.eqr("_i",p_cVarName)) {
      _i = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipoallin",p_cVarName)) {
      w_tipoallin = value;
      return;
    }
    if (CPLib.eqr("bloccaedit",p_cVarName)) {
      w_bloccaedit = value;
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
    if (CPLib.eqr("RAGSOC",p_cVarName)) {
      RAGSOC = value;
      return;
    }
    if (CPLib.eqr("NOME",p_cVarName)) {
      NOME = value;
      return;
    }
    if (CPLib.eqr("COGNOME",p_cVarName)) {
      COGNOME = value;
      return;
    }
    if (CPLib.eqr("SubRag",p_cVarName)) {
      SubRag = value;
      return;
    }
    if (CPLib.eqr("Controllo",p_cVarName)) {
      Controllo = value;
      return;
    }
    if (CPLib.eqr("Allineamento",p_cVarName)) {
      Allineamento = value;
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
    CPResultSet Cursor_qbe_max_personbo=null;
    CPResultSet Cursor_qbe_allinea_personbo=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* Creo il file temporaneo se esisteva già prima lo distruggo */
      // * --- Drop temporary table tmp_allin_anag
      if (m_Ctx.IsSharedTemp("tmp_allin_anag")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_allin_anag")) {
          m_cServer = m_Ctx.GetServer("tmp_allin_anag");
          m_cPhName = m_Ctx.GetPhName("tmp_allin_anag");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_allin_anag");
      }
      // * --- Create temporary table tmp_allin_anag
      if (m_Ctx.IsSharedTemp("tmp_allin_anag")) {
        if (m_Ctx.IsTmpAlreadyCreated("tmp_allin_anag")) {
          m_cServer = m_Ctx.GetServer("tmp_allin_anag");
          m_cPhName = m_Ctx.GetPhName("tmp_allin_anag");
          m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
        }
      } else {
        m_Ctx.DropTmp("tmp_allin_anag");
      }
      m_cPhName = m_Ctx.CreateTmpPhName("tmp_allin_anag");
      if ( ! (m_Ctx.IsSharedTemp("tmp_allin_anag"))) {
        m_cServer = m_Ctx.GetServer("tmp_allin_anag");
        m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_allin_anag",m_cServer,"proto")),m_cPhName,"tmp_allin_anag",m_Ctx);
      }
      m_cPhName_tmp_allin_anag = m_cPhName;
      /* gMsgImp Char(120) // Messaggio allineamento 1 */
      /* gMsgProc Memo // Messaggio */
      /* w_tipoallin Char(1) */
      /* w_showdata Numeric(1, 0) */
      /* _top Numeric(15, 0) */
      /* _bottom Numeric(15, 0) */
      /* w_Countot Numeric(20, 0) */
      /* w_Countok Numeric(20, 0) */
      /* w_Countpr Numeric(20, 0) */
      /* w_Countpr2 Numeric(20, 0) */
      /* w_Countko Numeric(20, 0) */
      /* w_bloccaedit Char(1) */
      /* RAGSOC Char(70) */
      /* NOME Char(25) */
      /* COGNOME Char(26) */
      /* SubRag Char(70) */
      /* NSpazzi Numeric(2, 0) */
      /* NSpazzi2 Numeric(2, 0) */
      /* Controllo Char(103) */
      /* Allineamento Char(2) */
      /* _i Numeric(10, 0) */
      /* _max Numeric(15, 0) */
      /* _cicli Numeric(15, 0) */
      /* _conta Numeric(15, 0) */
      /* gMsgImp := 'Inizio procedura.' // Messaggio allineamento 1 */
      gMsgImp = "Inizio procedura.";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* w_Countot := 0 */
      w_Countot = CPLib.Round(0,0);
      /* w_Countok := 0 */
      w_Countok = CPLib.Round(0,0);
      /* w_Countpr := 0 */
      w_Countpr = CPLib.Round(0,0);
      /* w_Countpr2 := 0 */
      w_Countpr2 = CPLib.Round(0,0);
      /* w_Countko := 0 */
      w_Countko = CPLib.Round(0,0);
      /* Controllo := "du/del/dell'/l'/d'/di/de/la/li/lu/lo/le/degli/degl'/il/della/dello/delle/dell'/de'/o'/mc/mac/o/von/van/" */
      Controllo = "du/del/dell'/l'/d'/di/de/la/li/lu/lo/le/degli/degl'/il/della/dello/delle/dell'/de'/o'/mc/mac/o/von/van/";
      /* gMsgProc := 'Ora Inizio Processo: '+DateTimeToChar(DateTime()) + NL */
      gMsgProc = "Ora Inizio Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Verifica il contatore massimo */
      // * --- Select from qbe_max_personbo
      if (Cursor_qbe_max_personbo!=null)
        Cursor_qbe_max_personbo.Close();
      Cursor_qbe_max_personbo = new VQRHolder("qbe_max_personbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_max_personbo.Eof())) {
        /* _max := qbe_max_personbo->MAXPROG */
        _max = CPLib.Round(Cursor_qbe_max_personbo.GetDouble("MAXPROG"),0);
        Cursor_qbe_max_personbo.Next();
      }
      m_cConnectivityError = Cursor_qbe_max_personbo.ErrorMessage();
      Cursor_qbe_max_personbo.Close();
      // * --- End Select
      /* _cicli := iif(Mod(_max,10000) <> 0,Int(_max/10000) + 1,Int(_max/10000)) */
      _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_max,10000),0)?CPLib.Int(_max/10000)+1:CPLib.Int(_max/10000)),0);
      /* _conta := 1 */
      _conta = CPLib.Round(1,0);
      /* While _conta <= _cicli */
      while (CPLib.le(_conta,_cicli)) {
        /* _bottom := ((_conta -1 ) * 10000) + 1 */
        _bottom = CPLib.Round(((_conta-1)*10000)+1,0);
        /* _top := _conta * 10000 */
        _top = CPLib.Round(_conta*10000,0);
        // * --- Select from qbe_allinea_personbo
        if (Cursor_qbe_allinea_personbo!=null)
          Cursor_qbe_allinea_personbo.Close();
        Cursor_qbe_allinea_personbo = new VQRHolder("qbe_allinea_personbo",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_allinea_personbo.Eof())) {
          /* gMsgImp := 'Sono stati elaborati '+LRTrim(Str(w_Countot,20,0))+' nominativi. '+LRTrim(Str((qbe_allinea_personbo->PROGIMPORT/_max)*100,5,2))+'%.' // Messaggio allineamento 1 */
          gMsgImp = "Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(w_Countot,20,0))+" nominativi. "+CPLib.LRTrim(CPLib.Str((Cursor_qbe_allinea_personbo.GetDouble("PROGIMPORT")/_max)*100,5,2))+"%.";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* w_Countot := w_Countot+1 */
          w_Countot = CPLib.Round(w_Countot+1,0);
          /* RAGSOC := Upper(LRTrim(qbe_allinea_personbo->RAGSOC)) */
          RAGSOC = CPLib.Upper(CPLib.LRTrim(Cursor_qbe_allinea_personbo.GetString("RAGSOC")));
          /* While True  */
          while (true) {
            /* NSpazzi := LibreriaMit.Occurs(RAGSOC,'  ') */
            NSpazzi = CPLib.Round(LibreriaMit.Occurs(RAGSOC,"  "),0);
            /* If NSpazzi>0 */
            if (CPLib.gt(NSpazzi,0)) {
              /* RAGSOC := Strtran(RAGSOC,'  ',' ') */
              RAGSOC = CPLib.Strtran(RAGSOC,"  "," ");
            } else { // Else
              // Exit Loop
              if (true) {
                break;
              }
            } // End If
          } // End While
          /* NSpazzi := LibreriaMit.Occurs(RAGSOC,' ') */
          NSpazzi = CPLib.Round(LibreriaMit.Occurs(RAGSOC," "),0);
          /* If NSpazzi=1 */
          if (CPLib.eqr(NSpazzi,1)) {
            /* NOME := Left(RAGSOC,At(" ",RAGSOC)-1) */
            NOME = CPLib.Left(RAGSOC,CPLib.At(" ",RAGSOC)-1);
            /* COGNOME := Substr(RAGSOC,At(" ",RAGSOC)+1) */
            COGNOME = CPLib.Substr(RAGSOC,CPLib.At(" ",RAGSOC)+1);
            /* If arfn_verifica_cf_nome_cognome(qbe_allinea_personbo->CODFISC,NOME,COGNOME) */
            if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(Cursor_qbe_allinea_personbo.GetString("CODFISC"),NOME,COGNOME)) {
              /* RAGSOC := Left(RAGSOC,At(" ",RAGSOC)-1)+'?'+Substr(RAGSOC,At(" ",RAGSOC)+1) */
              RAGSOC = CPLib.Left(RAGSOC,CPLib.At(" ",RAGSOC)-1)+"?"+CPLib.Substr(RAGSOC,CPLib.At(" ",RAGSOC)+1);
              /* Allineamento := 'OK' */
              Allineamento = "OK";
              /* w_Countok := w_Countok+1 */
              w_Countok = CPLib.Round(w_Countok+1,0);
            } else { // Else
              /* NOME := '' */
              NOME = "";
              /* COGNOME := '' */
              COGNOME = "";
              /* Allineamento := 'KO' */
              Allineamento = "KO";
            } // End If
          } else { // Else
            /* NSpazzi2 := NSpazzi-1 */
            NSpazzi2 = CPLib.Round(NSpazzi-1,0);
            /* While NSpazzi2>1 */
            while (CPLib.gt(NSpazzi2,1)) {
              /* SubRag := Substr(RAGSOC,At(' ',RAGSOC,NSpazzi2)+1,(At(' ',RAGSOC,NSpazzi2+1)-At(' ',RAGSOC,NSpazzi2))-1) */
              SubRag = CPLib.Substr(RAGSOC,CPLib.At(" ",RAGSOC,NSpazzi2)+1,(CPLib.At(" ",RAGSOC,NSpazzi2+1)-CPLib.At(" ",RAGSOC,NSpazzi2))-1);
              /* If At(Lower(SubRag)+'/',Controllo)>0 */
              if (CPLib.gt(CPLib.At(CPLib.Lower(SubRag)+"/",Controllo),0)) {
                /* NOME := Left(RAGSOC,At(" ",RAGSOC,NSpazzi2)-1) */
                NOME = CPLib.Left(RAGSOC,CPLib.At(" ",RAGSOC,NSpazzi2)-1);
                /* COGNOME := Substr(RAGSOC,At(" ",RAGSOC,NSpazzi2)+1) */
                COGNOME = CPLib.Substr(RAGSOC,CPLib.At(" ",RAGSOC,NSpazzi2)+1);
                /* If arfn_verifica_cf_nome_cognome(qbe_allinea_personbo->CODFISC,NOME,COGNOME) */
                if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(Cursor_qbe_allinea_personbo.GetString("CODFISC"),NOME,COGNOME)) {
                  /* RAGSOC := Left(RAGSOC,At(" ",RAGSOC)-1)+'?'+Substr(RAGSOC,At(" ",RAGSOC)+1) */
                  RAGSOC = CPLib.Left(RAGSOC,CPLib.At(" ",RAGSOC)-1)+"?"+CPLib.Substr(RAGSOC,CPLib.At(" ",RAGSOC)+1);
                  /* Allineamento := 'OK' */
                  Allineamento = "OK";
                  /* w_Countok := w_Countok+1 */
                  w_Countok = CPLib.Round(w_Countok+1,0);
                  // Exit Loop
                  if (true) {
                    break;
                  }
                } else { // Else
                  /* NOME := '' */
                  NOME = "";
                  /* COGNOME := '' */
                  COGNOME = "";
                  /* Allineamento := 'KO' */
                  Allineamento = "KO";
                } // End If
              } // End If
              /* NSpazzi2 := NSpazzi2-1 */
              NSpazzi2 = CPLib.Round(NSpazzi2-1,0);
            } // End While
          } // End If
          /* If LibreriaMit.Occurs(RAGSOC,'?')=0 */
          if (CPLib.eqr(LibreriaMit.Occurs(RAGSOC,"?"),0)) {
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* While _i<=NSpazzi */
            while (CPLib.le(_i,NSpazzi)) {
              /* NOME := Left(RAGSOC,At(' ',RAGSOC,_i)-1) */
              NOME = CPLib.Left(RAGSOC,CPLib.At(" ",RAGSOC,_i)-1);
              /* COGNOME := Substr(RAGSOC,At(' ',RAGSOC,_i)+1) */
              COGNOME = CPLib.Substr(RAGSOC,CPLib.At(" ",RAGSOC,_i)+1);
              /* If arfn_verifica_cf_nome_cognome(qbe_allinea_personbo->CODFISC,NOME,COGNOME) */
              if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(Cursor_qbe_allinea_personbo.GetString("CODFISC"),NOME,COGNOME)) {
                /* RAGSOC := Left(RAGSOC,At(' ',RAGSOC,_i)-1)+'?'+Substr(RAGSOC,At(' ',RAGSOC,_i)+1) */
                RAGSOC = CPLib.Left(RAGSOC,CPLib.At(" ",RAGSOC,_i)-1)+"?"+CPLib.Substr(RAGSOC,CPLib.At(" ",RAGSOC,_i)+1);
                /* Allineamento := 'K2' */
                Allineamento = "K2";
                /* w_Countpr := w_Countpr+1 */
                w_Countpr = CPLib.Round(w_Countpr+1,0);
                // Exit Loop
                if (true) {
                  break;
                }
              } else { // Else
                /* NOME := '' */
                NOME = "";
                /* COGNOME := '' */
                COGNOME = "";
                /* Allineamento := 'KO' */
                Allineamento = "KO";
              } // End If
              /* _i := _i+1 */
              _i = CPLib.Round(_i+1,0);
            } // End While
          } // End If
          /* If LibreriaMit.Occurs(RAGSOC,'?')=0 */
          if (CPLib.eqr(LibreriaMit.Occurs(RAGSOC,"?"),0)) {
            /* _i := 1 */
            _i = CPLib.Round(1,0);
            /* While _i<=NSpazzi */
            while (CPLib.le(_i,NSpazzi)) {
              /* NOME := Substr(RAGSOC,At(' ',RAGSOC,_i)+1) */
              NOME = CPLib.Substr(RAGSOC,CPLib.At(" ",RAGSOC,_i)+1);
              /* COGNOME := Left(RAGSOC,At(' ',RAGSOC,_i)-1) */
              COGNOME = CPLib.Left(RAGSOC,CPLib.At(" ",RAGSOC,_i)-1);
              /* If arfn_verifica_cf_nome_cognome(qbe_allinea_personbo->CODFISC,NOME,COGNOME) */
              if (arfn_verifica_cf_nome_cognomeR.Make(m_Ctx,this).Run(Cursor_qbe_allinea_personbo.GetString("CODFISC"),NOME,COGNOME)) {
                /* RAGSOC := Left(RAGSOC,At(' ',RAGSOC,_i)-1)+'?'+Substr(RAGSOC,At(' ',RAGSOC,_i)+1) */
                RAGSOC = CPLib.Left(RAGSOC,CPLib.At(" ",RAGSOC,_i)-1)+"?"+CPLib.Substr(RAGSOC,CPLib.At(" ",RAGSOC,_i)+1);
                /* Allineamento := 'K3' */
                Allineamento = "K3";
                /* w_Countpr2 := w_Countpr2+1 */
                w_Countpr2 = CPLib.Round(w_Countpr2+1,0);
                // Exit Loop
                if (true) {
                  break;
                }
              } else { // Else
                /* NOME := '' */
                NOME = "";
                /* COGNOME := '' */
                COGNOME = "";
                /* Allineamento := 'KO' */
                Allineamento = "KO";
              } // End If
              /* _i := _i+1 */
              _i = CPLib.Round(_i+1,0);
            } // End While
          } // End If
          /* If LibreriaMit.Occurs(RAGSOC,'?')<1 */
          if (CPLib.lt(LibreriaMit.Occurs(RAGSOC,"?"),1)) {
            /* NOME := '' */
            NOME = "";
            /* COGNOME := '' */
            COGNOME = "";
            /* Allineamento := 'KO' */
            Allineamento = "KO";
            /* w_Countko := w_Countko+1 */
            w_Countko = CPLib.Round(w_Countko+1,0);
          } // End If
          /* Scrive direttamente i dati in personbo senza visualizzare la gestionese con tipoallin = A */
          /* If w_tipoallin='A' */
          if (CPLib.eqr(w_tipoallin,"A")) {
            /* If not(Empty(NOME)) and not(Empty(COGNOME)) */
            if ( ! (CPLib.Empty(NOME)) &&  ! (CPLib.Empty(COGNOME))) {
              // * --- Write into personbo from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("personbo");
              m_cPhName = m_Ctx.GetPhName("personbo");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_start_aa",96,"00000078")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"COGNOME = "+CPLib.ToSQL(COGNOME,"C",26,0,m_cServer)+", ";
              m_cSql = m_cSql+"NOME = "+CPLib.ToSQL(NOME,"C",25,0,m_cServer)+", ";
              m_cSql = m_cSql+"RAGSOC = "+CPLib.ToSQL(CPLib.LRTrim(COGNOME)+" "+CPLib.LRTrim(NOME),"C",70,0,m_cServer)+", ";
              m_cSql = m_cSql+"ALLINEATONOMECNOME = "+CPLib.ToSQL(1,"N",1,0)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_qbe_allinea_personbo.GetString("CONNES"),"?",0,0,m_cServer),m_cServer,Cursor_qbe_allinea_personbo.GetString("CONNES"))+"";
              m_cSql = m_cSql+m_oWrInfo.WhereFilter();
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
            // * --- Insert into tmp_allin_anag from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("tmp_allin_anag");
            m_cPhName = m_Ctx.GetPhName("tmp_allin_anag");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_allin_anag",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_start_aa",96,"00000079")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000079(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allinea_personbo.GetString("CONNES"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(RAGSOC,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Cursor_qbe_allinea_personbo.GetString("CODFISC"),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(NOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(COGNOME,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(Allineamento,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_allin_anag",true);
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
          Cursor_qbe_allinea_personbo.Next();
        }
        m_cConnectivityError = Cursor_qbe_allinea_personbo.ErrorMessage();
        Cursor_qbe_allinea_personbo.Close();
        // * --- End Select
        /* _conta := _conta+1 */
        _conta = CPLib.Round(_conta+1,0);
      } // End While
      /* gMsgImp := 'Fine elaborazione. Sono stati elaborati '+LRTrim(Str(w_Countot,20,0))+' nominativi. 100%' // Messaggio allineamento 1 */
      gMsgImp = "Fine elaborazione. Sono stati elaborati "+CPLib.LRTrim(CPLib.Str(w_Countot,20,0))+" nominativi. 100%";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If w_tipoallin='A' */
      if (CPLib.eqr(w_tipoallin,"A")) {
        /* w_bloccaedit := 'N' */
        w_bloccaedit = "N";
        /* w_showdata := 0 */
        w_showdata = CPLib.Round(0,0);
      } else { // Else
        /* w_showdata := 1 */
        w_showdata = CPLib.Round(1,0);
      } // End If
      /* gMsgProc := gMsgProc+"Sono stati allineati automaticamente "+LRTrim(Str(w_Countok,20,0))+" soggetti."+ NL  */
      gMsgProc = gMsgProc+"Sono stati allineati automaticamente "+CPLib.LRTrim(CPLib.Str(w_Countok,20,0))+" soggetti."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc+"Sono stati allineati attraverso il codice fiscale "+LRTrim(Str(w_Countpr,20,0))+" soggetti."+ NL  */
      gMsgProc = gMsgProc+"Sono stati allineati attraverso il codice fiscale "+CPLib.LRTrim(CPLib.Str(w_Countpr,20,0))+" soggetti."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc+"Sono stati allineati invertendo la ragione sociale "+LRTrim(Str(w_Countpr2,20,0))+" soggetti."+ NL   */
      gMsgProc = gMsgProc+"Sono stati allineati invertendo la ragione sociale "+CPLib.LRTrim(CPLib.Str(w_Countpr2,20,0))+" soggetti."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc+"Non sono stati allineati automaticamente "+LRTrim(Str(w_Countko,20,0))+" soggetti."+ NL  */
      gMsgProc = gMsgProc+"Non sono stati allineati automaticamente "+CPLib.LRTrim(CPLib.Str(w_Countko,20,0))+" soggetti."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc+"Per un totale generale di "+LRTrim(Str(w_Countot,20,0))+" soggetti."+ NL */
      gMsgProc = gMsgProc+"Per un totale generale di "+CPLib.LRTrim(CPLib.Str(w_Countot,20,0))+" soggetti."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc+"Sono stati allineati il "+LRTrim(Str(((w_Countok+w_Countpr+w_Countpr2)/w_Countot)*100,20,0))+"% del totale delle anagrafiche disallineate."+ NL  */
      gMsgProc = gMsgProc+"Sono stati allineati il "+CPLib.LRTrim(CPLib.Str(((w_Countok+w_Countpr+w_Countpr2)/w_Countot)*100,20,0))+"% del totale delle anagrafiche disallineate."+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+DateTimeToChar(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+CPLib.DateTimeToChar(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_max_personbo!=null)
          Cursor_qbe_max_personbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_allinea_personbo!=null)
          Cursor_qbe_allinea_personbo.Close();
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
      m_Caller.SetString("tipoallin","C",1,0,w_tipoallin);
      m_Caller.SetNumber("showdata","N",1,0,w_showdata);
      m_Caller.SetNumber("_top","N",15,0,_top);
      m_Caller.SetNumber("_bottom","N",15,0,_bottom);
      m_Caller.SetNumber("Countot","N",20,0,w_Countot);
      m_Caller.SetNumber("Countok","N",20,0,w_Countok);
      m_Caller.SetNumber("Countpr","N",20,0,w_Countpr);
      m_Caller.SetNumber("Countpr2","N",20,0,w_Countpr2);
      m_Caller.SetNumber("Countko","N",20,0,w_Countko);
      m_Caller.SetString("bloccaedit","C",1,0,w_bloccaedit);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_start_aaR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_start_aaR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_tipoallin = m_Caller.GetString("tipoallin","C",1,0);
    w_showdata = m_Caller.GetNumber("showdata","N",1,0);
    _top = m_Caller.GetNumber("_top","N",15,0);
    _bottom = m_Caller.GetNumber("_bottom","N",15,0);
    w_Countot = m_Caller.GetNumber("Countot","N",20,0);
    w_Countok = m_Caller.GetNumber("Countok","N",20,0);
    w_Countpr = m_Caller.GetNumber("Countpr","N",20,0);
    w_Countpr2 = m_Caller.GetNumber("Countpr2","N",20,0);
    w_Countko = m_Caller.GetNumber("Countko","N",20,0);
    w_bloccaedit = m_Caller.GetString("bloccaedit","C",1,0);
    RAGSOC = CPLib.Space(70);
    NOME = CPLib.Space(25);
    COGNOME = CPLib.Space(26);
    SubRag = CPLib.Space(70);
    NSpazzi = 0;
    NSpazzi2 = 0;
    Controllo = CPLib.Space(103);
    Allineamento = CPLib.Space(2);
    _i = 0;
    _max = 0;
    _cicli = 0;
    _conta = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_max_personbo,qbe_allinea_personbo,
  public static final String m_cVQRList = ",qbe_max_personbo,qbe_allinea_personbo,";
  // ENTITY_BATCHES: ,arfn_verifica_cf_nome_cognome,
  public static final String i_InvokedRoutines = ",arfn_verifica_cf_nome_cognome,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000079(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"RAGSOC,";
    p_cSql = p_cSql+"CODFISC,";
    p_cSql = p_cSql+"NOME,";
    p_cSql = p_cSql+"COGNOME,";
    p_cSql = p_cSql+"ALLINEAMENTO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_allin_anag",true);
    return p_cSql;
  }
}
