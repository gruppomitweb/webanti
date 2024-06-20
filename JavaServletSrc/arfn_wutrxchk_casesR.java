// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_wutrxchk_casesR implements CallerWithObjs {
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
  public String pCognome;
  public String pNome;
  public String pSesso;
  public String pTipoDoc;
  public String pNumDoc;
  public String pNasCom;
  public String pNasSta;
  public String pDatNas;
  public String pCodFis;
  public String pDatRil;
  public String pQuery;
  public String pDatOpe;
  public String pLuoNas;
  public String pFLGNCF;
  public MemoryCursor_qbe_rtra_aua_gen_vqr mcAUA;
  public MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA;
  public MemoryCursor_mcrtraaua_mcrdef mcResult;
  public double _nocf;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_wutrxchk_casesR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_wutrxchk_cases",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_nocf",p_cVarName)) {
      return _nocf;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_wutrxchk_cases";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pCognome",p_cVarName)) {
      return pCognome;
    }
    if (CPLib.eqr("pNome",p_cVarName)) {
      return pNome;
    }
    if (CPLib.eqr("pSesso",p_cVarName)) {
      return pSesso;
    }
    if (CPLib.eqr("pTipoDoc",p_cVarName)) {
      return pTipoDoc;
    }
    if (CPLib.eqr("pNumDoc",p_cVarName)) {
      return pNumDoc;
    }
    if (CPLib.eqr("pNasCom",p_cVarName)) {
      return pNasCom;
    }
    if (CPLib.eqr("pNasSta",p_cVarName)) {
      return pNasSta;
    }
    if (CPLib.eqr("pDatNas",p_cVarName)) {
      return pDatNas;
    }
    if (CPLib.eqr("pCodFis",p_cVarName)) {
      return pCodFis;
    }
    if (CPLib.eqr("pDatRil",p_cVarName)) {
      return pDatRil;
    }
    if (CPLib.eqr("pQuery",p_cVarName)) {
      return pQuery;
    }
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      return pDatOpe;
    }
    if (CPLib.eqr("pLuoNas",p_cVarName)) {
      return pLuoNas;
    }
    if (CPLib.eqr("pFLGNCF",p_cVarName)) {
      return pFLGNCF;
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
    if (CPLib.eqr("mcAUA",p_cVarName)) {
      return mcAUA;
    }
    if (CPLib.eqr("mcResult",p_cVarName)) {
      return mcResult;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowAUA",p_cVarName)) {
      return rowAUA;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_nocf",p_cVarName)) {
      _nocf = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pCognome",p_cVarName)) {
      pCognome = value;
      return;
    }
    if (CPLib.eqr("pNome",p_cVarName)) {
      pNome = value;
      return;
    }
    if (CPLib.eqr("pSesso",p_cVarName)) {
      pSesso = value;
      return;
    }
    if (CPLib.eqr("pTipoDoc",p_cVarName)) {
      pTipoDoc = value;
      return;
    }
    if (CPLib.eqr("pNumDoc",p_cVarName)) {
      pNumDoc = value;
      return;
    }
    if (CPLib.eqr("pNasCom",p_cVarName)) {
      pNasCom = value;
      return;
    }
    if (CPLib.eqr("pNasSta",p_cVarName)) {
      pNasSta = value;
      return;
    }
    if (CPLib.eqr("pDatNas",p_cVarName)) {
      pDatNas = value;
      return;
    }
    if (CPLib.eqr("pCodFis",p_cVarName)) {
      pCodFis = value;
      return;
    }
    if (CPLib.eqr("pDatRil",p_cVarName)) {
      pDatRil = value;
      return;
    }
    if (CPLib.eqr("pQuery",p_cVarName)) {
      pQuery = value;
      return;
    }
    if (CPLib.eqr("pDatOpe",p_cVarName)) {
      pDatOpe = value;
      return;
    }
    if (CPLib.eqr("pLuoNas",p_cVarName)) {
      pLuoNas = value;
      return;
    }
    if (CPLib.eqr("pFLGNCF",p_cVarName)) {
      pFLGNCF = value;
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
    if (CPLib.eqr("rowAUA",p_cVarName)) {
      rowAUA = (MemoryCursorRow_qbe_rtra_aua_gen_vqr)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcAUA",p_cVarName)) {
      mcAUA = (MemoryCursor_qbe_rtra_aua_gen_vqr)value;
      return;
    }
    if (CPLib.eqr("mcResult",p_cVarName)) {
      mcResult = (MemoryCursor_mcrtraaua_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_qbe_rtra_aua_1_id_a=null;
    CPResultSet Cursor_qbe_rtra_aua_2_id_a=null;
    CPResultSet Cursor_qbe_rtra_aua_3_id_a=null;
    CPResultSet Cursor_qbe_rtra_aua_4_id_a=null;
    CPResultSet Cursor_qbe_rtra_aua_5_id_a=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pCognome Char(50) // Cognome */
      /* pNome Char(50) // Nome */
      /* pSesso Char(1) // Sesso */
      /* pTipoDoc Char(2) // Tipo Documento */
      /* pNumDoc Char(30) // Numero Documento */
      /* pNasCom Char(40) // Comune Nascita */
      /* pNasSta Char(40) // Numero Documento */
      /* pDatNas Char(8) // Data di Nascita */
      /* pCodFis Char(16) // Codice Fiscale */
      /* pDatRil Char(8) // Data Rilascio Documento */
      /* pQuery Char(1) */
      /* pDatOpe Char(8) // Data Ricerca */
      /* pLuoNas Char(60) // Luogo di Nascita */
      /* pFLGNCF Char(1) // Luogo di Nascita */
      /* mcAUA MemoryCursor(qbe_rtra_aua_gen.vqr) */
      /* rowAUA Row(qbe_rtra_aua_gen.vqr) */
      /* mcResult MemoryCursor(mcRTRAAUA.MCRDef) */
      /* _nocf Numeric(1, 0) */
      /* mcAUA.Zap() */
      mcAUA.Zap();
      /* mcResult.Zap() */
      mcResult.Zap();
      /* mcResult.AppendBlank() */
      mcResult.AppendBlank();
      /* mcResult.CONNES := Replicate("*",16) */
      mcResult.row.CONNES = CPLib.Replicate("*",16);
      /* mcResult.COGNOME := pCognome */
      mcResult.row.COGNOME = pCognome;
      /* mcResult.NOME := pNome */
      mcResult.row.NOME = pNome;
      /* mcResult.NASSTATO := pNasSta */
      mcResult.row.NASSTATO = pNasSta;
      /* mcResult.NASCOMUN := pNasCom */
      mcResult.row.NASCOMUN = pNasCom;
      /* mcResult.DATANASC := CharToDate(LRTrim(pDatNas)) */
      mcResult.row.DATANASC = CPLib.CharToDate(CPLib.LRTrim(pDatNas));
      /* mcResult.SESSO := iif(pSesso='1','M',iif(pSesso='2','F','')) */
      mcResult.row.SESSO = (CPLib.eqr(pSesso,"1")?"M":(CPLib.eqr(pSesso,"2")?"F":""));
      /* mcResult.TIPODOC := arfn_dectabs('DOC',pTipoDoc) */
      mcResult.row.TIPODOC = arfn_dectabsR.Make(m_Ctx,this).Run("DOC",pTipoDoc);
      /* mcResult.NUMDOCUM := pNumDoc */
      mcResult.row.NUMDOCUM = pNumDoc;
      /* mcResult.DATARILASC := CharToDate(LRTrim(pDatRil)) */
      mcResult.row.DATARILASC = CPLib.CharToDate(CPLib.LRTrim(pDatRil));
      /* mcResult.CODFISC := pCodFis */
      mcResult.row.CODFISC = pCodFis;
      /* mcResult.RAGSOC := LRTrim(pCognome)+" "+LRTrim(pNome) */
      mcResult.row.RAGSOC = CPLib.LRTrim(pCognome)+" "+CPLib.LRTrim(pNome);
      /* mcResult.FLGCFVALIDO := "" */
      mcResult.row.FLGCFVALIDO = "";
      /* If Empty(LRTrim(pCodFis)) */
      if (CPLib.Empty(CPLib.LRTrim(pCodFis))) {
        /* mcResult.FLGCGFORMAT := "" */
        mcResult.row.FLGCGFORMAT = "";
      } else { // Else
        /* mcResult.FLGCGFORMAT := iif(arfn_chkcodfis(pCodFis,'086',0),"../images/GIF/047.gif","../images/GIF/048.gif") */
        mcResult.row.FLGCGFORMAT = (arfn_chkcodfisR.Make(m_Ctx,this).Run(pCodFis,"086",0)?"../images/GIF/047.gif":"../images/GIF/048.gif");
      } // End If
      /* mcResult.DOCTYPE := pTipoDoc */
      mcResult.row.DOCTYPE = pTipoDoc;
      /* mcResult.LUOGONAS := pLuoNas */
      mcResult.row.LUOGONAS = pLuoNas;
      /* mcResult.SaveRow() */
      mcResult.SaveRow();
      /* Case pQuery='1' */
      if (CPLib.eqr(pQuery,"1")) {
        // * --- Fill memory cursor mcAUA on qbe_rtra_aua_1_id_a
        mcAUA.Zap();
        SPBridge.HMCaller _h0000002F;
        _h0000002F = new SPBridge.HMCaller();
        _h0000002F.Set("m_cVQRList",m_cVQRList);
        _h0000002F.Set("pTIPODOC",pTipoDoc);
        _h0000002F.Set("pNUMDOCUM",pNumDoc);
        _h0000002F.Set("pDATAOPE",CPLib.CharToDate(pDatOpe));
        if (Cursor_qbe_rtra_aua_1_id_a!=null)
          Cursor_qbe_rtra_aua_1_id_a.Close();
        Cursor_qbe_rtra_aua_1_id_a = new VQRHolder("qbe_rtra_aua_1_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000002F,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_1_id_a;
          Cursor_qbe_rtra_aua_1_id_a.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_wutrxchk_cases: query on qbe_rtra_aua_1_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rtra_aua_1_id_a.Eof())) {
          mcAUA.AppendBlank();
          mcAUA.row.CONNES = Cursor_qbe_rtra_aua_1_id_a.GetString("CONNES");
          mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_1_id_a.GetString("COGNOME");
          mcAUA.row.NOME = Cursor_qbe_rtra_aua_1_id_a.GetString("NOME");
          mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_1_id_a.GetString("NASSTATO");
          mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_1_id_a.GetString("NASCOMUN");
          mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_1_id_a.GetDate("DATANASC");
          mcAUA.row.SESSO = Cursor_qbe_rtra_aua_1_id_a.GetString("SESSO");
          mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_1_id_a.GetString("TIPODOC");
          mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_1_id_a.GetString("NUMDOCUM");
          mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_1_id_a.GetDate("DATARILASC");
          mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_1_id_a.GetString("CODFISC");
          mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_1_id_a.GetString("RAGSOC");
          mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_1_id_a.GetString("FLGCFVALIDO");
          mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_1_id_a.GetString("FLGCGFORMAT");
          mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_1_id_a.GetString("LUOGONAS");
          Cursor_qbe_rtra_aua_1_id_a.Next();
        }
        m_cConnectivityError = Cursor_qbe_rtra_aua_1_id_a.ErrorMessage();
        Cursor_qbe_rtra_aua_1_id_a.Close();
        mcAUA.GoTop();
        /* If mcAUA.RecCount() > 0 */
        if (CPLib.gt(mcAUA.RecCount(),0)) {
          for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
            /* If arfn_agechar(Upper(Strtran(LRTrim(rowAUA.RAGSOC),' ','')),"")+LRTrim(DateToChar(rowAUA.DATANASC))+Upper(LRTrim(rowAUA.SESSO))+arfn_agechar(Upper(LRTrim(Left(rowAUA.LUOGONAS,30))),"")<>arfn_agechar(Upper(Strtran(LRTrim(pCognome),' ','')+Strtran(LRTrim(pNome),' ','')),"")+LRTrim(DateToChar(pDatNas))+Upper(LRTrim(pSesso))+arfn_agechar(Upper(LRTrim(Left(pLuoNas,30))),"") */
            if (CPLib.ne(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(rowAUA.RAGSOC)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(rowAUA.DATANASC))+CPLib.Upper(CPLib.LRTrim(rowAUA.SESSO))+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.LRTrim(CPLib.Left(rowAUA.LUOGONAS,30))),""),arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(pCognome)," ","")+CPLib.Strtran(CPLib.LRTrim(pNome)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(pDatNas))+CPLib.Upper(CPLib.LRTrim(pSesso))+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.LRTrim(CPLib.Left(pLuoNas,30))),""))) {
              /* mcResult.AppendBlank() */
              mcResult.AppendBlank();
              /* mcResult.CONNES := rowAUA.CONNES */
              mcResult.row.CONNES = rowAUA.CONNES;
              /* mcResult.COGNOME := rowAUA.COGNOME */
              mcResult.row.COGNOME = rowAUA.COGNOME;
              /* mcResult.NOME := rowAUA.NOME */
              mcResult.row.NOME = rowAUA.NOME;
              /* mcResult.NASSTATO := rowAUA.NASSTATO */
              mcResult.row.NASSTATO = rowAUA.NASSTATO;
              /* mcResult.NASCOMUN := rowAUA.NASCOMUN */
              mcResult.row.NASCOMUN = rowAUA.NASCOMUN;
              /* mcResult.DATANASC := rowAUA.DATANASC */
              mcResult.row.DATANASC = rowAUA.DATANASC;
              /* mcResult.SESSO := iif(rowAUA.SESSO='1','M',iif(rowAUA.SESSO='2','F','')) */
              mcResult.row.SESSO = (CPLib.eqr(rowAUA.SESSO,"1")?"M":(CPLib.eqr(rowAUA.SESSO,"2")?"F":""));
              /* mcResult.TIPODOC := arfn_dectabs('DOC',rowAUA.TIPODOC) */
              mcResult.row.TIPODOC = arfn_dectabsR.Make(m_Ctx,this).Run("DOC",rowAUA.TIPODOC);
              /* mcResult.NUMDOCUM := rowAUA.NUMDOCUM */
              mcResult.row.NUMDOCUM = rowAUA.NUMDOCUM;
              /* mcResult.DATARILASC := rowAUA.DATARILASC */
              mcResult.row.DATARILASC = rowAUA.DATARILASC;
              /* mcResult.CODFISC := rowAUA.CODFISC */
              mcResult.row.CODFISC = rowAUA.CODFISC;
              /* mcResult.RAGSOC := rowAUA.RAGSOC */
              mcResult.row.RAGSOC = rowAUA.RAGSOC;
              /* mcResult.FLGCFVALIDO := iif(rowAUA.FLGCFVALIDO='S',"../images/GIF/115.gif","../images/GIF/116.gif") */
              mcResult.row.FLGCFVALIDO = (CPLib.eqr(rowAUA.FLGCFVALIDO,"S")?"../images/GIF/115.gif":"../images/GIF/116.gif");
              /* mcResult.FLGCGFORMAT := iif(rowAUA.FLGCGFORMAT='S',"../images/GIF/047.gif","../images/GIF/048.gif") */
              mcResult.row.FLGCGFORMAT = (CPLib.eqr(rowAUA.FLGCGFORMAT,"S")?"../images/GIF/047.gif":"../images/GIF/048.gif");
              /* If Upper(LRTrim(rowAUA.COGNOME)) <> Upper(LRTrim(pCognome)) */
              if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(rowAUA.COGNOME)),CPLib.Upper(CPLib.LRTrim(pCognome)))) {
                /* mcResult.ERR01 := '*' */
                mcResult.row.ERR01 = "*";
              } // End If
              /* If Upper(LRTrim(rowAUA.NOME)) <> Upper(LRTrim(pNome)) */
              if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(rowAUA.NOME)),CPLib.Upper(CPLib.LRTrim(pNome)))) {
                /* mcResult.ERR02 := '*' */
                mcResult.row.ERR02 = "*";
              } // End If
              /* If Upper(LRTrim(rowAUA.RAGSOC)) <> Upper(LRTrim(pCognome))+" "+Upper(LRTrim(pNome)) */
              if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(rowAUA.RAGSOC)),CPLib.Upper(CPLib.LRTrim(pCognome))+" "+CPLib.Upper(CPLib.LRTrim(pNome)))) {
                /* mcResult.ERR03 := '*' */
                mcResult.row.ERR03 = "*";
              } // End If
              /* If Upper(LRTrim(rowAUA.LUOGONAS)) <> Upper(LRTrim(pLuoNas)) */
              if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(rowAUA.LUOGONAS)),CPLib.Upper(CPLib.LRTrim(pLuoNas)))) {
                /* mcResult.ERR04 := '*' */
                mcResult.row.ERR04 = "*";
              } // End If
              /* If rowAUA.DATANASC <> CharToDate(pDatNas) */
              if (CPLib.ne(rowAUA.DATANASC,CPLib.CharToDate(pDatNas))) {
                /* mcResult.ERR05 := '*' */
                mcResult.row.ERR05 = "*";
              } // End If
              /* If rowAUA.SESSO <> pSesso */
              if (CPLib.ne(rowAUA.SESSO,pSesso)) {
                /* mcResult.ERR06 := '*' */
                mcResult.row.ERR06 = "*";
              } // End If
              /* mcResult.DOCTYPE := rowAUA.TIPODOC */
              mcResult.row.DOCTYPE = rowAUA.TIPODOC;
              /* mcResult.LUOGONAS := rowAUA.LUOGONAS */
              mcResult.row.LUOGONAS = rowAUA.LUOGONAS;
              /* mcResult.SaveRow() */
              mcResult.SaveRow();
            } // End If
          }
        } // End If
        /* Case pQuery='2' */
      } else if (CPLib.eqr(pQuery,"2")) {
        // * --- Fill memory cursor mcAUA on qbe_rtra_aua_2_id_a
        mcAUA.Zap();
        SPBridge.HMCaller _h00000052;
        _h00000052 = new SPBridge.HMCaller();
        _h00000052.Set("m_cVQRList",m_cVQRList);
        _h00000052.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(pCognome)," ","")+CPLib.Strtran(CPLib.LRTrim(pNome)," ",""));
        _h00000052.Set("pDATANASC",CPLib.CharToDate(pDatNas));
        _h00000052.Set("pSESSO",pSesso);
        _h00000052.Set("pTIPODOC",pTipoDoc);
        _h00000052.Set("pDATAOPE",CPLib.CharToDate(pDatOpe));
        _h00000052.Set("pLUOGONAS",pLuoNas);
        if (Cursor_qbe_rtra_aua_2_id_a!=null)
          Cursor_qbe_rtra_aua_2_id_a.Close();
        Cursor_qbe_rtra_aua_2_id_a = new VQRHolder("qbe_rtra_aua_2_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000052,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_2_id_a;
          Cursor_qbe_rtra_aua_2_id_a.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_wutrxchk_cases: query on qbe_rtra_aua_2_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rtra_aua_2_id_a.Eof())) {
          mcAUA.AppendBlank();
          mcAUA.row.CONNES = Cursor_qbe_rtra_aua_2_id_a.GetString("CONNES");
          mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_2_id_a.GetString("COGNOME");
          mcAUA.row.NOME = Cursor_qbe_rtra_aua_2_id_a.GetString("NOME");
          mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_2_id_a.GetString("NASSTATO");
          mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_2_id_a.GetString("NASCOMUN");
          mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_2_id_a.GetDate("DATANASC");
          mcAUA.row.SESSO = Cursor_qbe_rtra_aua_2_id_a.GetString("SESSO");
          mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_2_id_a.GetString("TIPODOC");
          mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_2_id_a.GetString("NUMDOCUM");
          mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_2_id_a.GetDate("DATARILASC");
          mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_2_id_a.GetString("CODFISC");
          mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_2_id_a.GetString("RAGSOC");
          mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_2_id_a.GetString("FLGCFVALIDO");
          mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_2_id_a.GetString("FLGCGFORMAT");
          mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_2_id_a.GetString("LUOGONAS");
          Cursor_qbe_rtra_aua_2_id_a.Next();
        }
        m_cConnectivityError = Cursor_qbe_rtra_aua_2_id_a.ErrorMessage();
        Cursor_qbe_rtra_aua_2_id_a.Close();
        mcAUA.GoTop();
        /* If mcAUA.RecCount() > 0 */
        if (CPLib.gt(mcAUA.RecCount(),0)) {
          for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
            /* If Upper(LRTrim(Strtran(rowAUA.NUMDOCUM,' ',''))) <>Upper(LRTrim(Strtran(pNumDoc,' ',''))) and rowAUA.DATARILASC >= CharToDate(pDatRil) */
            if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(CPLib.Strtran(rowAUA.NUMDOCUM," ",""))),CPLib.Upper(CPLib.LRTrim(CPLib.Strtran(pNumDoc," ","")))) && CPLib.ge(rowAUA.DATARILASC,CPLib.CharToDate(pDatRil))) {
              /* mcResult.AppendBlank() */
              mcResult.AppendBlank();
              /* mcResult.CONNES := rowAUA.CONNES */
              mcResult.row.CONNES = rowAUA.CONNES;
              /* mcResult.COGNOME := rowAUA.COGNOME */
              mcResult.row.COGNOME = rowAUA.COGNOME;
              /* mcResult.NOME := rowAUA.NOME */
              mcResult.row.NOME = rowAUA.NOME;
              /* mcResult.NASSTATO := rowAUA.NASSTATO */
              mcResult.row.NASSTATO = rowAUA.NASSTATO;
              /* mcResult.NASCOMUN := rowAUA.NASCOMUN */
              mcResult.row.NASCOMUN = rowAUA.NASCOMUN;
              /* mcResult.DATANASC := rowAUA.DATANASC */
              mcResult.row.DATANASC = rowAUA.DATANASC;
              /* mcResult.SESSO := iif(rowAUA.SESSO='1','M',iif(rowAUA.SESSO='2','F','')) */
              mcResult.row.SESSO = (CPLib.eqr(rowAUA.SESSO,"1")?"M":(CPLib.eqr(rowAUA.SESSO,"2")?"F":""));
              /* mcResult.TIPODOC := arfn_dectabs('DOC',rowAUA.TIPODOC) */
              mcResult.row.TIPODOC = arfn_dectabsR.Make(m_Ctx,this).Run("DOC",rowAUA.TIPODOC);
              /* mcResult.NUMDOCUM := rowAUA.NUMDOCUM */
              mcResult.row.NUMDOCUM = rowAUA.NUMDOCUM;
              /* mcResult.DATARILASC := rowAUA.DATARILASC */
              mcResult.row.DATARILASC = rowAUA.DATARILASC;
              /* mcResult.CODFISC := rowAUA.CODFISC */
              mcResult.row.CODFISC = rowAUA.CODFISC;
              /* mcResult.RAGSOC := rowAUA.RAGSOC */
              mcResult.row.RAGSOC = rowAUA.RAGSOC;
              /* mcResult.FLGCFVALIDO := iif(rowAUA.FLGCFVALIDO='S',"../images/GIF/115.gif","../images/GIF/116.gif") */
              mcResult.row.FLGCFVALIDO = (CPLib.eqr(rowAUA.FLGCFVALIDO,"S")?"../images/GIF/115.gif":"../images/GIF/116.gif");
              /* mcResult.FLGCGFORMAT := iif(rowAUA.FLGCGFORMAT='S',"../images/GIF/047.gif","../images/GIF/048.gif") */
              mcResult.row.FLGCGFORMAT = (CPLib.eqr(rowAUA.FLGCGFORMAT,"S")?"../images/GIF/047.gif":"../images/GIF/048.gif");
              /* mcResult.ERR08 := '£' */
              mcResult.row.ERR08 = "£";
              /* mcResult.ERR09 := '*' */
              mcResult.row.ERR09 = "*";
              /* mcResult.DOCTYPE := rowAUA.TIPODOC */
              mcResult.row.DOCTYPE = rowAUA.TIPODOC;
              /* mcResult.LUOGONAS := rowAUA.LUOGONAS */
              mcResult.row.LUOGONAS = rowAUA.LUOGONAS;
              /* mcResult.SaveRow() */
              mcResult.SaveRow();
            } // End If
          }
        } // End If
        /* Case pQuery='3' */
      } else if (CPLib.eqr(pQuery,"3")) {
        /* _nocf := iif(Empty(pCodFis),1,iif(arfn_chkcodfis(pCodFis,'',iif(pFLGNCF='S',0,1)),0,1)) */
        _nocf = CPLib.Round((CPLib.Empty(pCodFis)?1:(arfn_chkcodfisR.Make(m_Ctx,this).Run(pCodFis,"",(CPLib.eqr(pFLGNCF,"S")?0:1))?0:1)),0);
        // * --- Fill memory cursor mcAUA on qbe_rtra_aua_3_id_a
        mcAUA.Zap();
        SPBridge.HMCaller _h0000006C;
        _h0000006C = new SPBridge.HMCaller();
        _h0000006C.Set("m_cVQRList",m_cVQRList);
        _h0000006C.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(pCognome)," ","")+CPLib.Strtran(CPLib.LRTrim(pNome)," ",""));
        _h0000006C.Set("pDATANASC",CPLib.CharToDate(pDatNas));
        _h0000006C.Set("pSESSO",pSesso);
        _h0000006C.Set("pLUOGONAS",pLuoNas);
        if (Cursor_qbe_rtra_aua_3_id_a!=null)
          Cursor_qbe_rtra_aua_3_id_a.Close();
        Cursor_qbe_rtra_aua_3_id_a = new VQRHolder("qbe_rtra_aua_3_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000006C,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_3_id_a;
          Cursor_qbe_rtra_aua_3_id_a.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_wutrxchk_cases: query on qbe_rtra_aua_3_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rtra_aua_3_id_a.Eof())) {
          mcAUA.AppendBlank();
          mcAUA.row.CONNES = Cursor_qbe_rtra_aua_3_id_a.GetString("CONNES");
          mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_3_id_a.GetString("COGNOME");
          mcAUA.row.NOME = Cursor_qbe_rtra_aua_3_id_a.GetString("NOME");
          mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_3_id_a.GetString("NASSTATO");
          mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_3_id_a.GetString("NASCOMUN");
          mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_3_id_a.GetDate("DATANASC");
          mcAUA.row.SESSO = Cursor_qbe_rtra_aua_3_id_a.GetString("SESSO");
          mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_3_id_a.GetString("TIPODOC");
          mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_3_id_a.GetString("NUMDOCUM");
          mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_3_id_a.GetDate("DATARILASC");
          mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_3_id_a.GetString("CODFISC");
          mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_3_id_a.GetString("RAGSOC");
          mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_3_id_a.GetString("FLGCFVALIDO");
          mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_3_id_a.GetString("FLGCGFORMAT");
          mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_3_id_a.GetString("LUOGONAS");
          Cursor_qbe_rtra_aua_3_id_a.Next();
        }
        m_cConnectivityError = Cursor_qbe_rtra_aua_3_id_a.ErrorMessage();
        Cursor_qbe_rtra_aua_3_id_a.Close();
        mcAUA.GoTop();
        /* If mcAUA.RecCount() > 0 */
        if (CPLib.gt(mcAUA.RecCount(),0)) {
          for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
            /* If _nocf=0 */
            if (CPLib.eqr(_nocf,0)) {
              /* If Upper(rowAUA.CODFISC) <> Upper(pCodFis) */
              if (CPLib.ne(CPLib.Upper(rowAUA.CODFISC),CPLib.Upper(pCodFis))) {
                /* mcResult.AppendBlank() */
                mcResult.AppendBlank();
                /* mcResult.CONNES := rowAUA.CONNES */
                mcResult.row.CONNES = rowAUA.CONNES;
                /* mcResult.COGNOME := rowAUA.COGNOME */
                mcResult.row.COGNOME = rowAUA.COGNOME;
                /* mcResult.NOME := rowAUA.NOME */
                mcResult.row.NOME = rowAUA.NOME;
                /* mcResult.NASSTATO := rowAUA.NASSTATO */
                mcResult.row.NASSTATO = rowAUA.NASSTATO;
                /* mcResult.NASCOMUN := rowAUA.NASCOMUN */
                mcResult.row.NASCOMUN = rowAUA.NASCOMUN;
                /* mcResult.DATANASC := rowAUA.DATANASC */
                mcResult.row.DATANASC = rowAUA.DATANASC;
                /* mcResult.SESSO := iif(rowAUA.SESSO='1','M',iif(rowAUA.SESSO='2','F','')) */
                mcResult.row.SESSO = (CPLib.eqr(rowAUA.SESSO,"1")?"M":(CPLib.eqr(rowAUA.SESSO,"2")?"F":""));
                /* mcResult.TIPODOC := arfn_dectabs('DOC',rowAUA.TIPODOC) */
                mcResult.row.TIPODOC = arfn_dectabsR.Make(m_Ctx,this).Run("DOC",rowAUA.TIPODOC);
                /* mcResult.NUMDOCUM := rowAUA.NUMDOCUM */
                mcResult.row.NUMDOCUM = rowAUA.NUMDOCUM;
                /* mcResult.DATARILASC := rowAUA.DATARILASC */
                mcResult.row.DATARILASC = rowAUA.DATARILASC;
                /* mcResult.CODFISC := rowAUA.CODFISC */
                mcResult.row.CODFISC = rowAUA.CODFISC;
                /* mcResult.RAGSOC := rowAUA.RAGSOC */
                mcResult.row.RAGSOC = rowAUA.RAGSOC;
                /* mcResult.FLGCFVALIDO := iif(rowAUA.FLGCFVALIDO='S',"../images/GIF/115.gif","../images/GIF/116.gif") */
                mcResult.row.FLGCFVALIDO = (CPLib.eqr(rowAUA.FLGCFVALIDO,"S")?"../images/GIF/115.gif":"../images/GIF/116.gif");
                /* mcResult.FLGCGFORMAT := iif(rowAUA.FLGCGFORMAT='S',"../images/GIF/047.gif","../images/GIF/048.gif") */
                mcResult.row.FLGCGFORMAT = (CPLib.eqr(rowAUA.FLGCGFORMAT,"S")?"../images/GIF/047.gif":"../images/GIF/048.gif");
                /* mcResult.ERR10 := '*' */
                mcResult.row.ERR10 = "*";
                /* mcResult.DOCTYPE := rowAUA.TIPODOC */
                mcResult.row.DOCTYPE = rowAUA.TIPODOC;
                /* mcResult.LUOGONAS := rowAUA.LUOGONAS */
                mcResult.row.LUOGONAS = rowAUA.LUOGONAS;
                /* mcResult.SaveRow() */
                mcResult.SaveRow();
              } // End If
            } else { // Else
              /* If not(Empty(rowAUA.CODFISC)) */
              if ( ! (CPLib.Empty(rowAUA.CODFISC))) {
                /* mcResult.AppendBlank() */
                mcResult.AppendBlank();
                /* mcResult.CONNES := rowAUA.CONNES */
                mcResult.row.CONNES = rowAUA.CONNES;
                /* mcResult.COGNOME := rowAUA.COGNOME */
                mcResult.row.COGNOME = rowAUA.COGNOME;
                /* mcResult.NOME := rowAUA.NOME */
                mcResult.row.NOME = rowAUA.NOME;
                /* mcResult.NASSTATO := rowAUA.NASSTATO */
                mcResult.row.NASSTATO = rowAUA.NASSTATO;
                /* mcResult.NASCOMUN := rowAUA.NASCOMUN */
                mcResult.row.NASCOMUN = rowAUA.NASCOMUN;
                /* mcResult.DATANASC := rowAUA.DATANASC */
                mcResult.row.DATANASC = rowAUA.DATANASC;
                /* mcResult.SESSO := iif(rowAUA.SESSO='1','M',iif(rowAUA.SESSO='2','F','')) */
                mcResult.row.SESSO = (CPLib.eqr(rowAUA.SESSO,"1")?"M":(CPLib.eqr(rowAUA.SESSO,"2")?"F":""));
                /* mcResult.TIPODOC := arfn_dectabs('DOC',rowAUA.TIPODOC) */
                mcResult.row.TIPODOC = arfn_dectabsR.Make(m_Ctx,this).Run("DOC",rowAUA.TIPODOC);
                /* mcResult.NUMDOCUM := rowAUA.NUMDOCUM */
                mcResult.row.NUMDOCUM = rowAUA.NUMDOCUM;
                /* mcResult.DATARILASC := rowAUA.DATARILASC */
                mcResult.row.DATARILASC = rowAUA.DATARILASC;
                /* mcResult.CODFISC := rowAUA.CODFISC */
                mcResult.row.CODFISC = rowAUA.CODFISC;
                /* mcResult.RAGSOC := rowAUA.RAGSOC */
                mcResult.row.RAGSOC = rowAUA.RAGSOC;
                /* mcResult.FLGCFVALIDO := iif(rowAUA.FLGCFVALIDO='S',"../images/GIF/115.gif","../images/GIF/116.gif") */
                mcResult.row.FLGCFVALIDO = (CPLib.eqr(rowAUA.FLGCFVALIDO,"S")?"../images/GIF/115.gif":"../images/GIF/116.gif");
                /* mcResult.FLGCGFORMAT := iif(rowAUA.FLGCGFORMAT='S',"../images/GIF/047.gif","../images/GIF/048.gif") */
                mcResult.row.FLGCGFORMAT = (CPLib.eqr(rowAUA.FLGCGFORMAT,"S")?"../images/GIF/047.gif":"../images/GIF/048.gif");
                /* mcResult.ERR10 := '*' */
                mcResult.row.ERR10 = "*";
                /* mcResult.DOCTYPE := rowAUA.TIPODOC */
                mcResult.row.DOCTYPE = rowAUA.TIPODOC;
                /* mcResult.LUOGONAS := rowAUA.LUOGONAS */
                mcResult.row.LUOGONAS = rowAUA.LUOGONAS;
                /* mcResult.SaveRow() */
                mcResult.SaveRow();
              } // End If
            } // End If
          }
        } // End If
        /* Case pQuery='4' */
      } else if (CPLib.eqr(pQuery,"4")) {
        // * --- Fill memory cursor mcAUA on qbe_rtra_aua_4_id_a
        mcAUA.Zap();
        SPBridge.HMCaller _h00000099;
        _h00000099 = new SPBridge.HMCaller();
        _h00000099.Set("m_cVQRList",m_cVQRList);
        _h00000099.Set("pCODFISC",pCodFis);
        if (Cursor_qbe_rtra_aua_4_id_a!=null)
          Cursor_qbe_rtra_aua_4_id_a.Close();
        Cursor_qbe_rtra_aua_4_id_a = new VQRHolder("qbe_rtra_aua_4_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000099,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_4_id_a;
          Cursor_qbe_rtra_aua_4_id_a.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_wutrxchk_cases: query on qbe_rtra_aua_4_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rtra_aua_4_id_a.Eof())) {
          mcAUA.AppendBlank();
          mcAUA.row.CONNES = Cursor_qbe_rtra_aua_4_id_a.GetString("CONNES");
          mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_4_id_a.GetString("COGNOME");
          mcAUA.row.NOME = Cursor_qbe_rtra_aua_4_id_a.GetString("NOME");
          mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_4_id_a.GetString("NASSTATO");
          mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_4_id_a.GetString("NASCOMUN");
          mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_4_id_a.GetDate("DATANASC");
          mcAUA.row.SESSO = Cursor_qbe_rtra_aua_4_id_a.GetString("SESSO");
          mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_4_id_a.GetString("TIPODOC");
          mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_4_id_a.GetString("NUMDOCUM");
          mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_4_id_a.GetDate("DATARILASC");
          mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_4_id_a.GetString("CODFISC");
          mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_4_id_a.GetString("RAGSOC");
          mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_4_id_a.GetString("FLGCFVALIDO");
          mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_4_id_a.GetString("FLGCGFORMAT");
          mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_4_id_a.GetString("LUOGONAS");
          Cursor_qbe_rtra_aua_4_id_a.Next();
        }
        m_cConnectivityError = Cursor_qbe_rtra_aua_4_id_a.ErrorMessage();
        Cursor_qbe_rtra_aua_4_id_a.Close();
        mcAUA.GoTop();
        /* If mcAUA.RecCount() > 0 */
        if (CPLib.gt(mcAUA.RecCount(),0)) {
          for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
            /* If arfn_agechar(Upper(Strtran(LRTrim(rowAUA.RAGSOC),' ','')),"")+LRTrim(DateToChar(rowAUA.DATANASC))+Upper(LRTrim(rowAUA.SESSO))+arfn_agechar(Upper(LRTrim(rowAUA.LUOGONAS)),"")<>arfn_agechar(Upper(Strtran(LRTrim(pCognome),' ','')+Strtran(LRTrim(pNome),' ','')),"")+LRTrim(DateToChar(pDatNas))+Upper(LRTrim(pSesso))+arfn_agechar(Upper(LRTrim(pLuoNas)),"") */
            if (CPLib.ne(arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(rowAUA.RAGSOC)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(rowAUA.DATANASC))+CPLib.Upper(CPLib.LRTrim(rowAUA.SESSO))+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.LRTrim(rowAUA.LUOGONAS)),""),arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.Strtran(CPLib.LRTrim(pCognome)," ","")+CPLib.Strtran(CPLib.LRTrim(pNome)," ","")),"")+CPLib.LRTrim(CPLib.DateToChar(pDatNas))+CPLib.Upper(CPLib.LRTrim(pSesso))+arfn_agecharR.Make(m_Ctx,this).Run(CPLib.Upper(CPLib.LRTrim(pLuoNas)),""))) {
              /* mcResult.AppendBlank() */
              mcResult.AppendBlank();
              /* mcResult.CONNES := rowAUA.CONNES */
              mcResult.row.CONNES = rowAUA.CONNES;
              /* mcResult.COGNOME := rowAUA.COGNOME */
              mcResult.row.COGNOME = rowAUA.COGNOME;
              /* mcResult.NOME := rowAUA.NOME */
              mcResult.row.NOME = rowAUA.NOME;
              /* mcResult.NASSTATO := rowAUA.NASSTATO */
              mcResult.row.NASSTATO = rowAUA.NASSTATO;
              /* mcResult.NASCOMUN := rowAUA.NASCOMUN */
              mcResult.row.NASCOMUN = rowAUA.NASCOMUN;
              /* mcResult.DATANASC := rowAUA.DATANASC */
              mcResult.row.DATANASC = rowAUA.DATANASC;
              /* mcResult.SESSO := iif(rowAUA.SESSO='1','M',iif(rowAUA.SESSO='2','F','')) */
              mcResult.row.SESSO = (CPLib.eqr(rowAUA.SESSO,"1")?"M":(CPLib.eqr(rowAUA.SESSO,"2")?"F":""));
              /* mcResult.TIPODOC := arfn_dectabs('DOC',rowAUA.TIPODOC) */
              mcResult.row.TIPODOC = arfn_dectabsR.Make(m_Ctx,this).Run("DOC",rowAUA.TIPODOC);
              /* mcResult.NUMDOCUM := rowAUA.NUMDOCUM */
              mcResult.row.NUMDOCUM = rowAUA.NUMDOCUM;
              /* mcResult.DATARILASC := rowAUA.DATARILASC */
              mcResult.row.DATARILASC = rowAUA.DATARILASC;
              /* mcResult.CODFISC := rowAUA.CODFISC */
              mcResult.row.CODFISC = rowAUA.CODFISC;
              /* mcResult.RAGSOC := rowAUA.RAGSOC */
              mcResult.row.RAGSOC = rowAUA.RAGSOC;
              /* mcResult.FLGCFVALIDO := iif(rowAUA.FLGCFVALIDO='S',"../images/GIF/115.gif","../images/GIF/116.gif") */
              mcResult.row.FLGCFVALIDO = (CPLib.eqr(rowAUA.FLGCFVALIDO,"S")?"../images/GIF/115.gif":"../images/GIF/116.gif");
              /* mcResult.FLGCGFORMAT := iif(rowAUA.FLGCGFORMAT='S',"../images/GIF/047.gif","../images/GIF/048.gif") */
              mcResult.row.FLGCGFORMAT = (CPLib.eqr(rowAUA.FLGCGFORMAT,"S")?"../images/GIF/047.gif":"../images/GIF/048.gif");
              /* If Upper(LRTrim(rowAUA.COGNOME)) <> Upper(LRTrim(pCognome)) */
              if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(rowAUA.COGNOME)),CPLib.Upper(CPLib.LRTrim(pCognome)))) {
                /* mcResult.ERR01 := '*' */
                mcResult.row.ERR01 = "*";
              } // End If
              /* If Upper(LRTrim(rowAUA.NOME)) <> Upper(LRTrim(pNome)) */
              if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(rowAUA.NOME)),CPLib.Upper(CPLib.LRTrim(pNome)))) {
                /* mcResult.ERR02 := '*' */
                mcResult.row.ERR02 = "*";
              } // End If
              /* If Upper(LRTrim(rowAUA.RAGSOC)) <> Upper(LRTrim(pCognome))+" "+Upper(LRTrim(pNome)) */
              if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(rowAUA.RAGSOC)),CPLib.Upper(CPLib.LRTrim(pCognome))+" "+CPLib.Upper(CPLib.LRTrim(pNome)))) {
                /* mcResult.ERR03 := '*' */
                mcResult.row.ERR03 = "*";
              } // End If
              /* If Upper(LRTrim(rowAUA.LUOGONAS)) <> Upper(LRTrim(pLuoNas)) */
              if (CPLib.ne(CPLib.Upper(CPLib.LRTrim(rowAUA.LUOGONAS)),CPLib.Upper(CPLib.LRTrim(pLuoNas)))) {
                /* mcResult.ERR04 := '*' */
                mcResult.row.ERR04 = "*";
              } // End If
              /* If rowAUA.DATANASC <> CharToDate(pDatNas) */
              if (CPLib.ne(rowAUA.DATANASC,CPLib.CharToDate(pDatNas))) {
                /* mcResult.ERR05 := '*' */
                mcResult.row.ERR05 = "*";
              } // End If
              /* If rowAUA.SESSO <> pSesso */
              if (CPLib.ne(rowAUA.SESSO,pSesso)) {
                /* mcResult.ERR06 := '*' */
                mcResult.row.ERR06 = "*";
              } // End If
              /* mcResult.DOCTYPE := rowAUA.TIPODOC */
              mcResult.row.DOCTYPE = rowAUA.TIPODOC;
              /* mcResult.LUOGONAS := rowAUA.LUOGONAS */
              mcResult.row.LUOGONAS = rowAUA.LUOGONAS;
              /* mcResult.SaveRow() */
              mcResult.SaveRow();
            } // End If
          }
        } // End If
        /* Case pQuery='5' */
      } else if (CPLib.eqr(pQuery,"5")) {
        // * --- Fill memory cursor mcAUA on qbe_rtra_aua_5_id_a
        mcAUA.Zap();
        SPBridge.HMCaller _h000000BC;
        _h000000BC = new SPBridge.HMCaller();
        _h000000BC.Set("m_cVQRList",m_cVQRList);
        _h000000BC.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(pCognome)," ","")+CPLib.Strtran(CPLib.LRTrim(pNome)," ",""));
        _h000000BC.Set("pDATANASC",CPLib.CharToDate(pDatNas));
        _h000000BC.Set("pSESSO",pSesso);
        _h000000BC.Set("pTIPODOC",pTipoDoc);
        _h000000BC.Set("pNUMDOCUM",pNumDoc);
        _h000000BC.Set("pLUOGONAS",pLuoNas);
        if (Cursor_qbe_rtra_aua_5_id_a!=null)
          Cursor_qbe_rtra_aua_5_id_a.Close();
        Cursor_qbe_rtra_aua_5_id_a = new VQRHolder("qbe_rtra_aua_5_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000BC,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_5_id_a;
          Cursor_qbe_rtra_aua_5_id_a.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_wutrxchk_cases: query on qbe_rtra_aua_5_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rtra_aua_5_id_a.Eof())) {
          mcAUA.AppendBlank();
          mcAUA.row.CONNES = Cursor_qbe_rtra_aua_5_id_a.GetString("CONNES");
          mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_5_id_a.GetString("COGNOME");
          mcAUA.row.NOME = Cursor_qbe_rtra_aua_5_id_a.GetString("NOME");
          mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_5_id_a.GetString("NASSTATO");
          mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_5_id_a.GetString("NASCOMUN");
          mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_5_id_a.GetDate("DATANASC");
          mcAUA.row.SESSO = Cursor_qbe_rtra_aua_5_id_a.GetString("SESSO");
          mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_5_id_a.GetString("TIPODOC");
          mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_5_id_a.GetString("NUMDOCUM");
          mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_5_id_a.GetDate("DATARILASC");
          mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_5_id_a.GetString("CODFISC");
          mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_5_id_a.GetString("RAGSOC");
          mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_5_id_a.GetString("FLGCFVALIDO");
          mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_5_id_a.GetString("FLGCGFORMAT");
          mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_5_id_a.GetString("LUOGONAS");
          Cursor_qbe_rtra_aua_5_id_a.Next();
        }
        m_cConnectivityError = Cursor_qbe_rtra_aua_5_id_a.ErrorMessage();
        Cursor_qbe_rtra_aua_5_id_a.Close();
        mcAUA.GoTop();
        /* If mcAUA.RecCount() > 0 */
        if (CPLib.gt(mcAUA.RecCount(),0)) {
          for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
            /* If not(Empty(rowAUA.CODFISC)) */
            if ( ! (CPLib.Empty(rowAUA.CODFISC))) {
              /* mcResult.AppendBlank() */
              mcResult.AppendBlank();
              /* mcResult.CONNES := rowAUA.CONNES */
              mcResult.row.CONNES = rowAUA.CONNES;
              /* mcResult.COGNOME := rowAUA.COGNOME */
              mcResult.row.COGNOME = rowAUA.COGNOME;
              /* mcResult.NOME := rowAUA.NOME */
              mcResult.row.NOME = rowAUA.NOME;
              /* mcResult.NASSTATO := rowAUA.NASSTATO */
              mcResult.row.NASSTATO = rowAUA.NASSTATO;
              /* mcResult.NASCOMUN := rowAUA.NASCOMUN */
              mcResult.row.NASCOMUN = rowAUA.NASCOMUN;
              /* mcResult.DATANASC := rowAUA.DATANASC */
              mcResult.row.DATANASC = rowAUA.DATANASC;
              /* mcResult.SESSO := iif(rowAUA.SESSO='1','M',iif(rowAUA.SESSO='2','F','')) */
              mcResult.row.SESSO = (CPLib.eqr(rowAUA.SESSO,"1")?"M":(CPLib.eqr(rowAUA.SESSO,"2")?"F":""));
              /* mcResult.TIPODOC := arfn_dectabs('DOC',rowAUA.TIPODOC) */
              mcResult.row.TIPODOC = arfn_dectabsR.Make(m_Ctx,this).Run("DOC",rowAUA.TIPODOC);
              /* mcResult.NUMDOCUM := rowAUA.NUMDOCUM */
              mcResult.row.NUMDOCUM = rowAUA.NUMDOCUM;
              /* mcResult.DATARILASC := rowAUA.DATARILASC */
              mcResult.row.DATARILASC = rowAUA.DATARILASC;
              /* mcResult.CODFISC := rowAUA.CODFISC */
              mcResult.row.CODFISC = rowAUA.CODFISC;
              /* mcResult.RAGSOC := rowAUA.RAGSOC */
              mcResult.row.RAGSOC = rowAUA.RAGSOC;
              /* mcResult.FLGCFVALIDO := iif(rowAUA.FLGCFVALIDO='S',"../images/GIF/115.gif","../images/GIF/116.gif") */
              mcResult.row.FLGCFVALIDO = (CPLib.eqr(rowAUA.FLGCFVALIDO,"S")?"../images/GIF/115.gif":"../images/GIF/116.gif");
              /* mcResult.FLGCGFORMAT := iif(rowAUA.FLGCGFORMAT='S',"../images/GIF/047.gif","../images/GIF/048.gif") */
              mcResult.row.FLGCGFORMAT = (CPLib.eqr(rowAUA.FLGCGFORMAT,"S")?"../images/GIF/047.gif":"../images/GIF/048.gif");
              /* mcResult.ERR10 := '*' */
              mcResult.row.ERR10 = "*";
              /* mcResult.DOCTYPE := rowAUA.TIPODOC */
              mcResult.row.DOCTYPE = rowAUA.TIPODOC;
              /* mcResult.LUOGONAS := rowAUA.LUOGONAS */
              mcResult.row.LUOGONAS = rowAUA.LUOGONAS;
              /* mcResult.SaveRow() */
              mcResult.SaveRow();
            } // End If
          }
        } // End If
        /* Case pQuery='6' */
      } else if (CPLib.eqr(pQuery,"6")) {
        // * --- Fill memory cursor mcAUA on qbe_rtra_aua_2_id_a
        mcAUA.Zap();
        SPBridge.HMCaller _h000000D4;
        _h000000D4 = new SPBridge.HMCaller();
        _h000000D4.Set("m_cVQRList",m_cVQRList);
        _h000000D4.Set("pRAGSOC",CPLib.Strtran(CPLib.LRTrim(pCognome)," ","")+CPLib.Strtran(CPLib.LRTrim(pNome)," ",""));
        _h000000D4.Set("pDATANASC",CPLib.CharToDate(pDatNas));
        _h000000D4.Set("pSESSO",pSesso);
        _h000000D4.Set("pNUMDOCUM",pNumDoc);
        _h000000D4.Set("pDATAOPE",CPLib.CharToDate(pDatOpe));
        _h000000D4.Set("pLUOGONAS",pLuoNas);
        if (Cursor_qbe_rtra_aua_2_id_a!=null)
          Cursor_qbe_rtra_aua_2_id_a.Close();
        Cursor_qbe_rtra_aua_2_id_a = new VQRHolder("qbe_rtra_aua_2_id_a",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000D4,true).GetResultSet(m_Ctx);
        {
          final CPResultSet m_TheCursor = Cursor_qbe_rtra_aua_2_id_a;
          Cursor_qbe_rtra_aua_2_id_a.ActionOnClose(new Runnable() {
            public void run() {
              if (CPLib.gt(m_TheCursor.CurrentRow()-1,1000*1.1)) {
                com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                if ( ! (CPLib.IsNull(info))) {
                  info.log("Routine arfn_wutrxchk_cases: query on qbe_rtra_aua_2_id_a returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 1000");
                }
              }
            }
            });
        }
        while ( ! (Cursor_qbe_rtra_aua_2_id_a.Eof())) {
          mcAUA.AppendBlank();
          mcAUA.row.CONNES = Cursor_qbe_rtra_aua_2_id_a.GetString("CONNES");
          mcAUA.row.COGNOME = Cursor_qbe_rtra_aua_2_id_a.GetString("COGNOME");
          mcAUA.row.NOME = Cursor_qbe_rtra_aua_2_id_a.GetString("NOME");
          mcAUA.row.NASSTATO = Cursor_qbe_rtra_aua_2_id_a.GetString("NASSTATO");
          mcAUA.row.NASCOMUN = Cursor_qbe_rtra_aua_2_id_a.GetString("NASCOMUN");
          mcAUA.row.DATANASC = Cursor_qbe_rtra_aua_2_id_a.GetDate("DATANASC");
          mcAUA.row.SESSO = Cursor_qbe_rtra_aua_2_id_a.GetString("SESSO");
          mcAUA.row.TIPODOC = Cursor_qbe_rtra_aua_2_id_a.GetString("TIPODOC");
          mcAUA.row.NUMDOCUM = Cursor_qbe_rtra_aua_2_id_a.GetString("NUMDOCUM");
          mcAUA.row.DATARILASC = Cursor_qbe_rtra_aua_2_id_a.GetDate("DATARILASC");
          mcAUA.row.CODFISC = Cursor_qbe_rtra_aua_2_id_a.GetString("CODFISC");
          mcAUA.row.RAGSOC = Cursor_qbe_rtra_aua_2_id_a.GetString("RAGSOC");
          mcAUA.row.FLGCFVALIDO = Cursor_qbe_rtra_aua_2_id_a.GetString("FLGCFVALIDO");
          mcAUA.row.FLGCGFORMAT = Cursor_qbe_rtra_aua_2_id_a.GetString("FLGCGFORMAT");
          mcAUA.row.LUOGONAS = Cursor_qbe_rtra_aua_2_id_a.GetString("LUOGONAS");
          Cursor_qbe_rtra_aua_2_id_a.Next();
        }
        m_cConnectivityError = Cursor_qbe_rtra_aua_2_id_a.ErrorMessage();
        Cursor_qbe_rtra_aua_2_id_a.Close();
        mcAUA.GoTop();
        /* If mcAUA.RecCount() > 0 */
        if (CPLib.gt(mcAUA.RecCount(),0)) {
          for (MemoryCursorRow_qbe_rtra_aua_gen_vqr rowAUA : mcAUA._iterable_()) {
            /* If rowAUA.TIPODOC <> pTipoDoc and Upper(LRTrim(rowAUA.NUMDOCUM))=Upper(LRTrim(pNumDoc)) */
            if (CPLib.ne(rowAUA.TIPODOC,pTipoDoc) && CPLib.eqr(CPLib.Upper(CPLib.LRTrim(rowAUA.NUMDOCUM)),CPLib.Upper(CPLib.LRTrim(pNumDoc)))) {
              /* mcResult.AppendBlank() */
              mcResult.AppendBlank();
              /* mcResult.CONNES := rowAUA.CONNES */
              mcResult.row.CONNES = rowAUA.CONNES;
              /* mcResult.COGNOME := rowAUA.COGNOME */
              mcResult.row.COGNOME = rowAUA.COGNOME;
              /* mcResult.NOME := rowAUA.NOME */
              mcResult.row.NOME = rowAUA.NOME;
              /* mcResult.NASSTATO := rowAUA.NASSTATO */
              mcResult.row.NASSTATO = rowAUA.NASSTATO;
              /* mcResult.NASCOMUN := rowAUA.NASCOMUN */
              mcResult.row.NASCOMUN = rowAUA.NASCOMUN;
              /* mcResult.DATANASC := rowAUA.DATANASC */
              mcResult.row.DATANASC = rowAUA.DATANASC;
              /* mcResult.SESSO := iif(rowAUA.SESSO='1','M',iif(rowAUA.SESSO='2','F','')) */
              mcResult.row.SESSO = (CPLib.eqr(rowAUA.SESSO,"1")?"M":(CPLib.eqr(rowAUA.SESSO,"2")?"F":""));
              /* mcResult.TIPODOC := arfn_dectabs('DOC',rowAUA.TIPODOC) */
              mcResult.row.TIPODOC = arfn_dectabsR.Make(m_Ctx,this).Run("DOC",rowAUA.TIPODOC);
              /* mcResult.NUMDOCUM := rowAUA.NUMDOCUM */
              mcResult.row.NUMDOCUM = rowAUA.NUMDOCUM;
              /* mcResult.DATARILASC := rowAUA.DATARILASC */
              mcResult.row.DATARILASC = rowAUA.DATARILASC;
              /* mcResult.CODFISC := rowAUA.CODFISC */
              mcResult.row.CODFISC = rowAUA.CODFISC;
              /* mcResult.RAGSOC := rowAUA.RAGSOC */
              mcResult.row.RAGSOC = rowAUA.RAGSOC;
              /* mcResult.FLGCFVALIDO := iif(rowAUA.FLGCFVALIDO='S',"../images/GIF/115.gif","../images/GIF/116.gif") */
              mcResult.row.FLGCFVALIDO = (CPLib.eqr(rowAUA.FLGCFVALIDO,"S")?"../images/GIF/115.gif":"../images/GIF/116.gif");
              /* mcResult.FLGCGFORMAT := iif(rowAUA.FLGCGFORMAT='S',"../images/GIF/047.gif","../images/GIF/048.gif") */
              mcResult.row.FLGCGFORMAT = (CPLib.eqr(rowAUA.FLGCGFORMAT,"S")?"../images/GIF/047.gif":"../images/GIF/048.gif");
              /* mcResult.ERR07 := '*' */
              mcResult.row.ERR07 = "*";
              /* mcResult.DOCTYPE := rowAUA.TIPODOC */
              mcResult.row.DOCTYPE = rowAUA.TIPODOC;
              /* mcResult.SaveRow() */
              mcResult.SaveRow();
              /* mcResult.LUOGONAS := rowAUA.LUOGONAS */
              mcResult.row.LUOGONAS = rowAUA.LUOGONAS;
            } // End If
          }
        } // End If
      } // End Case
      /* Return mcResult */
      throw new Stop(mcResult);
    } finally {
      try {
        if (Cursor_qbe_rtra_aua_1_id_a!=null)
          Cursor_qbe_rtra_aua_1_id_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_2_id_a!=null)
          Cursor_qbe_rtra_aua_2_id_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_3_id_a!=null)
          Cursor_qbe_rtra_aua_3_id_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_4_id_a!=null)
          Cursor_qbe_rtra_aua_4_id_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_rtra_aua_5_id_a!=null)
          Cursor_qbe_rtra_aua_5_id_a.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pCognome,String p_pNome,String p_pSesso,String p_pTipoDoc,String p_pNumDoc,String p_pNasCom,String p_pNasSta,String p_pDatNas,String p_pCodFis,String p_pDatRil,String p_pQuery,String p_pDatOpe,String p_pLuoNas,String p_pFLGNCF) {
    pCognome = p_pCognome;
    pNome = p_pNome;
    pSesso = p_pSesso;
    pTipoDoc = p_pTipoDoc;
    pNumDoc = p_pNumDoc;
    pNasCom = p_pNasCom;
    pNasSta = p_pNasSta;
    pDatNas = p_pDatNas;
    pCodFis = p_pCodFis;
    pDatRil = p_pDatRil;
    pQuery = p_pQuery;
    pDatOpe = p_pDatOpe;
    pLuoNas = p_pLuoNas;
    pFLGNCF = p_pFLGNCF;
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
  public MemoryCursor_mcrtraaua_mcrdef Run(String p_pCognome,String p_pNome,String p_pSesso,String p_pTipoDoc,String p_pNumDoc,String p_pNasCom,String p_pNasSta,String p_pDatNas,String p_pCodFis,String p_pDatRil,String p_pQuery,String p_pDatOpe,String p_pLuoNas,String p_pFLGNCF) {
    pCognome = p_pCognome;
    pNome = p_pNome;
    pSesso = p_pSesso;
    pTipoDoc = p_pTipoDoc;
    pNumDoc = p_pNumDoc;
    pNasCom = p_pNasCom;
    pNasSta = p_pNasSta;
    pDatNas = p_pDatNas;
    pCodFis = p_pCodFis;
    pDatRil = p_pDatRil;
    pQuery = p_pQuery;
    pDatOpe = p_pDatOpe;
    pLuoNas = p_pLuoNas;
    pFLGNCF = p_pFLGNCF;
    return Run();
  }
  public MemoryCursor_mcrtraaua_mcrdef Run() {
    MemoryCursor_mcrtraaua_mcrdef l_result;
    l_result = null;
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
        l_result = (MemoryCursor_mcrtraaua_mcrdef)stop_value.GetObject();
      } catch(RoutineException l_transactionRaise) {
        //non va segnalato come errore
      } catch(Exception fault) {
        l_result = null;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_wutrxchk_casesR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_wutrxchk_casesR(p_Ctx, p_Caller);
  }
  public static arfn_wutrxchk_casesR Make(CPContext p_Ctx) {
    return new arfn_wutrxchk_casesR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pCognome = CPLib.Space(50);
    pNome = CPLib.Space(50);
    pSesso = CPLib.Space(1);
    pTipoDoc = CPLib.Space(2);
    pNumDoc = CPLib.Space(30);
    pNasCom = CPLib.Space(40);
    pNasSta = CPLib.Space(40);
    pDatNas = CPLib.Space(8);
    pCodFis = CPLib.Space(16);
    pDatRil = CPLib.Space(8);
    pQuery = CPLib.Space(1);
    pDatOpe = CPLib.Space(8);
    pLuoNas = CPLib.Space(60);
    pFLGNCF = CPLib.Space(1);
    mcAUA = new MemoryCursor_qbe_rtra_aua_gen_vqr();
    rowAUA = new MemoryCursorRow_qbe_rtra_aua_gen_vqr();
    mcResult = new MemoryCursor_mcrtraaua_mcrdef();
    _nocf = 0;
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_rtra_aua_1_id_a,qbe_rtra_aua_2_id_a,qbe_rtra_aua_3_id_a,qbe_rtra_aua_4_id_a,qbe_rtra_aua_5_id_a,qbe_rtra_aua_2_id_a,
  public static final String m_cVQRList = ",qbe_rtra_aua_1_id_a,qbe_rtra_aua_2_id_a,qbe_rtra_aua_3_id_a,qbe_rtra_aua_4_id_a,qbe_rtra_aua_5_id_a,qbe_rtra_aua_2_id_a,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_chkcodfis,arfn_dectabs,arfn_wutrxchk_cases,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_chkcodfis,arfn_dectabs,arfn_wutrxchk_cases,";
  public static String[] m_cRunParameterNames={"pCognome","pNome","pSesso","pTipoDoc","pNumDoc","pNasCom","pNasSta","pDatNas","pCodFis","pDatRil","pQuery","pDatOpe","pLuoNas","pFLGNCF"};
}
