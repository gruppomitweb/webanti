// * --- Area Manuale = BO - Header
// * --- Fine Area Manuale
public class arfn_estrai_sv_wuR implements CallerWithObjs {
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
  public double pAnno;
  public double pTri;
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
  public String gAzienda;
  public String gIntemediario;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  public String gPathDoc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public arfn_estrai_sv_wuR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_estrai_sv_wu",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      return pTri;
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
      return "arfn_estrai_sv_wu";
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
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
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
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pTri",p_cVarName)) {
      pTri = value;
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
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
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
    CPResultSet Cursor_qbe_estrai_sv_wu=null;
    CPResultSet Cursor_qbe_estrai_sv_wu_fraud=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* pAnno Numeric(4, 0) // Anno di riferimento */
      /* pTri Numeric(1, 0) // Trimestre */
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
      /* gAzienda Char(10) // Azienda */
      /* gIntemediario Char(11) // Intermediario */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Char(120) // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
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
      /* gMsgProc := 'Ora Inizio Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* nFile := LRTrim(gIntemediario)+"_"+Str(pAnno,4,0)+"_0"+Str(pTri,1,0) */
      nFile = CPLib.LRTrim(gIntemediario)+"_"+CPLib.Str(pAnno,4,0)+"_0"+CPLib.Str(pTri,1,0);
      /* fhand := FileLibMit.OpenWrite("export/"+LRTrim(gAzienda)+"/"+LRTrim(nFile)) // Per gestione file */
      fhand = FileLibMit.OpenWrite("export/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(nFile));
      /* conta := 0 */
      conta = CPLib.Round(0,0);
      double nTry00000026status;
      nTry00000026status = m_Sql.GetTransactionStatus();
      String cTry00000026msg;
      cTry00000026msg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from qbe_estrai_sv_wu
        SPBridge.HMCaller _h00000027;
        _h00000027 = new SPBridge.HMCaller();
        _h00000027.Set("m_cVQRList",m_cVQRList);
        _h00000027.Set("pDADATA",CPLib.CharToDate(_datini));
        _h00000027.Set("pA_DATA",CPLib.CharToDate(_datfin));
        if (Cursor_qbe_estrai_sv_wu!=null)
          Cursor_qbe_estrai_sv_wu.Close();
        Cursor_qbe_estrai_sv_wu = new VQRHolder("qbe_estrai_sv_wu",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h00000027,true).GetResultSet(m_Ctx);
        while ( ! (Cursor_qbe_estrai_sv_wu.Eof())) {
          /* conta := conta + 1 */
          conta = CPLib.Round(conta+1,0);
          /* gMsgImp := 'Elaborazione del record n. '+LRTrim(Str(conta,10,0)) // Messaggio Import */
          gMsgImp = "Elaborazione del record n. "+CPLib.LRTrim(CPLib.Str(conta,10,0));
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* riga := LibreriaMit.UniqueId() */
          riga = LibreriaMit.UniqueId();
          /* riga := riga + Str(pAnno,4,0) */
          riga = riga+CPLib.Str(pAnno,4,0);
          /* riga := riga + Str(pTri,1,0) */
          riga = riga+CPLib.Str(pTri,1,0);
          /* riga := riga + '58560' */
          riga = riga+"58560";
          /* riga := riga + iif(qbe_estrai_sv_wu->SEGNO='D','22','14') */
          riga = riga+(CPLib.eqr(Cursor_qbe_estrai_sv_wu.GetString("SEGNO"),"D")?"22":"14");
          /* _importo := qbe_estrai_sv_wu->IMPORTO/100 */
          _importo = CPLib.Round(Cursor_qbe_estrai_sv_wu.GetDouble("IMPORTO")/100,2);
          /* riga := riga + Str(qbe_estrai_sv_wu->IMPORTO*100,18,0) */
          riga = riga+CPLib.Str(Cursor_qbe_estrai_sv_wu.GetDouble("IMPORTO")*100,18,0);
          /* riga := riga + Str(qbe_estrai_sv_wu->NUMOPE,10,0) */
          riga = riga+CPLib.Str(Cursor_qbe_estrai_sv_wu.GetDouble("NUMOPE"),10,0);
          /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->SOTGRUP,4) */
          riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("SOTGRUP"),4);
          /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->PROVINCIA1,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("PROVINCIA1"),5);
          /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->PAESE,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("PAESE"),3);
          /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->PROVINCIA,5) */
          riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("PROVINCIA"),5);
          /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->TIPOSV,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("TIPOSV"),3);
          /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->TIPOCONT,3) */
          riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("TIPOCONT"),3);
          /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu->VALUTA,1) */
          riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu.GetString("VALUTA"),1);
          /* FileLibMit.WriteLine(fhand,riga) */
          FileLibMit.WriteLine(fhand,riga);
          Cursor_qbe_estrai_sv_wu.Next();
        }
        m_cConnectivityError = Cursor_qbe_estrai_sv_wu.ErrorMessage();
        Cursor_qbe_estrai_sv_wu.Close();
        // * --- End Select
        /* If pTri=2 or pTri=4 */
        if (CPLib.eqr(pTri,2) || CPLib.eqr(pTri,4)) {
          /* conta := 0 */
          conta = CPLib.Round(0,0);
          // * --- Select from qbe_estrai_sv_wu_fraud
          SPBridge.HMCaller _h0000003C;
          _h0000003C = new SPBridge.HMCaller();
          _h0000003C.Set("m_cVQRList",m_cVQRList);
          _h0000003C.Set("pFLAGFRAUD","S");
          if (Cursor_qbe_estrai_sv_wu_fraud!=null)
            Cursor_qbe_estrai_sv_wu_fraud.Close();
          Cursor_qbe_estrai_sv_wu_fraud = new VQRHolder("qbe_estrai_sv_wu_fraud",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000003C,true).GetResultSet(m_Ctx);
          while ( ! (Cursor_qbe_estrai_sv_wu_fraud.Eof())) {
            /* conta := conta + 1 */
            conta = CPLib.Round(conta+1,0);
            /* gMsgImp := 'Elaborazione del record n. '+LRTrim(Str(conta,10,0)) // Messaggio Import */
            gMsgImp = "Elaborazione del record n. "+CPLib.LRTrim(CPLib.Str(conta,10,0));
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* riga := LibreriaMit.UniqueId() */
            riga = LibreriaMit.UniqueId();
            /* riga := riga + Str(pAnno,4,0) */
            riga = riga+CPLib.Str(pAnno,4,0);
            /* riga := riga + Str(pTri,1,0) */
            riga = riga+CPLib.Str(pTri,1,0);
            /* riga := riga + '58785' */
            riga = riga+"58785";
            /* riga := riga + '04' */
            riga = riga+"04";
            /* _importo := Round(qbe_estrai_sv_wu_fraud->IMPORTO/100,0) */
            _importo = CPLib.Round(CPLib.Round(Cursor_qbe_estrai_sv_wu_fraud.GetDouble("IMPORTO")/100,0),2);
            /* riga := riga + Str(qbe_estrai_sv_wu_fraud->IMPORTO*100,18,0) */
            riga = riga+CPLib.Str(Cursor_qbe_estrai_sv_wu_fraud.GetDouble("IMPORTO")*100,18,0);
            /* riga := riga + Str(qbe_estrai_sv_wu_fraud->NUMOPE,10,0) */
            riga = riga+CPLib.Str(Cursor_qbe_estrai_sv_wu_fraud.GetDouble("NUMOPE"),10,0);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->SOTGRUP,4) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("SOTGRUP"),4);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->PROVINCIA1,5) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("PROVINCIA1"),5);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->PAESE,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("PAESE"),3);
            /* riga := riga + '1    ' */
            riga = riga+"1    ";
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->TIPOSV,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("TIPOSV"),3);
            /* riga := riga + LibreriaMit.SpacePad(qbe_estrai_sv_wu_fraud->TIPOCONT,3) */
            riga = riga+LibreriaMit.SpacePad(Cursor_qbe_estrai_sv_wu_fraud.GetString("TIPOCONT"),3);
            /* riga := riga + '1' */
            riga = riga+"1";
            /* FileLibMit.WriteLine(fhand,riga) */
            FileLibMit.WriteLine(fhand,riga);
            Cursor_qbe_estrai_sv_wu_fraud.Next();
          }
          m_cConnectivityError = Cursor_qbe_estrai_sv_wu_fraud.ErrorMessage();
          Cursor_qbe_estrai_sv_wu_fraud.Close();
          // * --- End Select
        } // End If
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
        /* gMsgProc := gMsgProc + 'Sono stati scritti: ' + LRTrim(Str(conta,10,0)) + ' record' + NL */
        gMsgProc = gMsgProc+"Sono stati scritti: "+CPLib.LRTrim(CPLib.Str(conta,10,0))+" record"+"\n";
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
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000026status,0)) {
          m_Sql.SetTransactionStatus(nTry00000026status,cTry00000026msg);
        }
      }
      /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = gMsgProc+"Ora Fine Elaborazione: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_qbe_estrai_sv_wu!=null)
          Cursor_qbe_estrai_sv_wu.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_estrai_sv_wu_fraud!=null)
          Cursor_qbe_estrai_sv_wu_fraud.Close();
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
  public static arfn_estrai_sv_wuR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_estrai_sv_wuR(p_Ctx, p_Caller);
  }
  public static arfn_estrai_sv_wuR Make(CPContext p_Ctx) {
    return new arfn_estrai_sv_wuR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
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
    conta = 0;
    cNomeFileZip = CPLib.Space(30);
    cNomeZip = CPLib.Space(128);
    fname = CPLib.Space(25);
    pfname = CPLib.Space(128);
    _importo = 0;
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_estrai_sv_wu,qbe_estrai_sv_wu_fraud,
  public static final String m_cVQRList = ",qbe_estrai_sv_wu,qbe_estrai_sv_wu_fraud,";
  // ENTITY_BATCHES: ,arfn_estrai_sv_wu,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_estrai_sv_wu,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pAnno","pTri"};
}
