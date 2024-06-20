// * --- Area Manuale = BO - Header
// * --- arfn_verify_doc
import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import org.apache.tika.Tika;
import org.apache.tika.io.TikaInputStream;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;
import com.sun.media.jai.codec.JPEGDecodeParam;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.ImageCodec;
// * --- Fine Area Manuale
public class arfn_verify_docR implements CallerWithObjs {
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
  public String m_cPhName_cgo_tipall;
  public String m_cServer_cgo_tipall;
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
  public double pTipo;
  public String pNomeDoc;
  public String pTipoGioco;
  public double pImpTick;
  public double pImpCont;
  public String pCodDip;
  public String gPathApp;
  public String cRitorno;
  public String cFile;
  public String cTipo;
  public String dbTipo;
  public double nDim;
  public double nDimDoc;
  public String cFind;
  public double nPagine;
  public String cStringa;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_verify_doc
  public int count;
  // * --- Fine Area Manuale
  public arfn_verify_docR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_verify_doc",m_Caller);
    m_cPhName_cgo_tipall = p_ContextObject.GetPhName("cgo_tipall");
    if (m_cPhName_cgo_tipall.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_tipall = m_cPhName_cgo_tipall+" "+m_Ctx.GetWritePhName("cgo_tipall");
    }
    m_cServer_cgo_tipall = p_ContextObject.GetServer("cgo_tipall");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pImpTick",p_cVarName)) {
      return pImpTick;
    }
    if (CPLib.eqr("pImpCont",p_cVarName)) {
      return pImpCont;
    }
    if (CPLib.eqr("nDim",p_cVarName)) {
      return nDim;
    }
    if (CPLib.eqr("nDimDoc",p_cVarName)) {
      return nDimDoc;
    }
    if (CPLib.eqr("nPagine",p_cVarName)) {
      return nPagine;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_verify_doc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pNomeDoc",p_cVarName)) {
      return pNomeDoc;
    }
    if (CPLib.eqr("pTipoGioco",p_cVarName)) {
      return pTipoGioco;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      return pCodDip;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("cFile",p_cVarName)) {
      return cFile;
    }
    if (CPLib.eqr("cTipo",p_cVarName)) {
      return cTipo;
    }
    if (CPLib.eqr("dbTipo",p_cVarName)) {
      return dbTipo;
    }
    if (CPLib.eqr("cFind",p_cVarName)) {
      return cFind;
    }
    if (CPLib.eqr("cStringa",p_cVarName)) {
      return cStringa;
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
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pImpTick",p_cVarName)) {
      pImpTick = value;
      return;
    }
    if (CPLib.eqr("pImpCont",p_cVarName)) {
      pImpCont = value;
      return;
    }
    if (CPLib.eqr("nDim",p_cVarName)) {
      nDim = value;
      return;
    }
    if (CPLib.eqr("nDimDoc",p_cVarName)) {
      nDimDoc = value;
      return;
    }
    if (CPLib.eqr("nPagine",p_cVarName)) {
      nPagine = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pNomeDoc",p_cVarName)) {
      pNomeDoc = value;
      return;
    }
    if (CPLib.eqr("pTipoGioco",p_cVarName)) {
      pTipoGioco = value;
      return;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      pCodDip = value;
      return;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("cFile",p_cVarName)) {
      cFile = value;
      return;
    }
    if (CPLib.eqr("cTipo",p_cVarName)) {
      cTipo = value;
      return;
    }
    if (CPLib.eqr("dbTipo",p_cVarName)) {
      dbTipo = value;
      return;
    }
    if (CPLib.eqr("cFind",p_cVarName)) {
      cFind = value;
      return;
    }
    if (CPLib.eqr("cStringa",p_cVarName)) {
      cStringa = value;
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
    CPResultSet Cursor_cgo_tipall=null;
    try {
      /* pTipo Numeric(1, 0) // Tipo (O=Unico,1=Singolo) */
      /* pNomeDoc Char(80) // Nome Documento */
      /* pTipoGioco Char(3) // Tipo Gioco */
      /* pImpTick Numeric(12, 2) // Importo Ticket */
      /* pImpCont Numeric(12, 2) // Importo Ticket */
      /* pCodDip Char(6) // Dipendenza */
      /* gPathApp Char(80) // Path Applicazione */
      /* cRitorno Char(100) // Ritorno Funzione */
      /* cFile Char(200) // Ritorno Funzione */
      /* cTipo Char(30) // Ritorno Funzione */
      /* dbTipo Char(4) // Ritorno Funzione */
      /* nDim Numeric(12, 4) // Ritorno Funzione */
      /* nDimDoc Numeric(12, 4) // Ritorno Funzione */
      /* cFind Char(1) */
      /* nPagine Numeric(1, 0) */
      /* cStringa Char(7) */
      /* cRitorno := 'OK' // Ritorno Funzione */
      cRitorno = "OK";
      /* cFile := LRTrim(gPathApp)+"/appo/"+LRTrim(pCodDip)+"/"+LRTrim(pNomeDoc) // Ritorno Funzione */
      cFile = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(pNomeDoc);
      double nTry00000017status;
      nTry00000017status = m_Sql.GetTransactionStatus();
      String cTry00000017msg;
      cTry00000017msg = m_Sql.TransactionErrorMessage();
      try {
        // Verifica contenuto file
        Tika tika=new Tika();
        File f = new File(cFile);
        TikaInputStream tikaInputStream = TikaInputStream.get(f);
        /* nDim := tikaInputStream.getLength() / 1048576 // Ritorno Funzione */
        nDim = CPLib.Round(tikaInputStream.getLength()/1048576,4);
        /* cTipo := tika.detect(f) // Ritorno Funzione */
        cTipo = tika.detect(f);
        /* cFind := 'N' */
        cFind = "N";
        /* If pTipo=0 */
        if (CPLib.eqr(pTipo,0)) {
          // * --- Select from cgo_tipall
          m_cServer = m_Ctx.GetServer("cgo_tipall");
          m_cPhName = m_Ctx.GetPhName("cgo_tipall");
          if (Cursor_cgo_tipall!=null)
            Cursor_cgo_tipall.Close();
          Cursor_cgo_tipall = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_tipall")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_tipall.Eof())) {
            /* If At(LRTrim(Upper(cgo_tipall->TATIPALL)),LRTrim(Upper(cTipo))) <> 0 */
            if (CPLib.ne(CPLib.At(CPLib.LRTrim(CPLib.Upper(Cursor_cgo_tipall.GetString("TATIPALL"))),CPLib.LRTrim(CPLib.Upper(cTipo))),0)) {
              /* dbTipo := cgo_tipall->TATIPALL // Ritorno Funzione */
              dbTipo = Cursor_cgo_tipall.GetString("TATIPALL");
              /* cFind := 'S' */
              cFind = "S";
              /* nDimDoc := cgo_tipall->TAPESUNI // Ritorno Funzione */
              nDimDoc = CPLib.Round(Cursor_cgo_tipall.GetDouble("TAPESUNI"),4);
            } // End If
            Cursor_cgo_tipall.Next();
          }
          m_cConnectivityError = Cursor_cgo_tipall.ErrorMessage();
          Cursor_cgo_tipall.Close();
          // * --- End Select
          /* cStringa := arfn_activate_doc(pTipoGioco,pImpTick,pImpCont) */
          cStringa = arfn_activate_docR.Make(m_Ctx,this).Run(pTipoGioco,pImpTick,pImpCont);
          /* nPagine := Val(Substr(cStringa,7,1)) */
          nPagine = CPLib.Round(CPLib.Val(CPLib.Substr(cStringa,7,1)),0);
        } else { // Else
          // * --- Select from cgo_tipall
          m_cServer = m_Ctx.GetServer("cgo_tipall");
          m_cPhName = m_Ctx.GetPhName("cgo_tipall");
          if (Cursor_cgo_tipall!=null)
            Cursor_cgo_tipall.Close();
          Cursor_cgo_tipall = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("cgo_tipall")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_tipall.Eof())) {
            /* If At(LRTrim(Upper(cgo_tipall->TATIPALL)),LRTrim(Upper(cTipo))) <> 0 */
            if (CPLib.ne(CPLib.At(CPLib.LRTrim(CPLib.Upper(Cursor_cgo_tipall.GetString("TATIPALL"))),CPLib.LRTrim(CPLib.Upper(cTipo))),0)) {
              /* dbTipo := cgo_tipall->TATIPALL // Ritorno Funzione */
              dbTipo = Cursor_cgo_tipall.GetString("TATIPALL");
              /* cFind := 'S' */
              cFind = "S";
              /* nDimDoc := cgo_tipall->TAPESSIN // Ritorno Funzione */
              nDimDoc = CPLib.Round(Cursor_cgo_tipall.GetDouble("TAPESSIN"),4);
            } // End If
            Cursor_cgo_tipall.Next();
          }
          m_cConnectivityError = Cursor_cgo_tipall.ErrorMessage();
          Cursor_cgo_tipall.Close();
          // * --- End Select
          /* nPagine := 1 */
          nPagine = CPLib.Round(1,0);
        } // End If
        /* If cFind='N' */
        if (CPLib.eqr(cFind,"N")) {
          /* cRitorno := 'Il file non è tra i tipi validi riconosciuti!' // Ritorno Funzione */
          cRitorno = "Il file non è tra i tipi validi riconosciuti!";
        } // End If
        /* If cRitorno='OK' */
        if (CPLib.eqr(cRitorno,"OK")) {
          /* If nDim > nDimDoc */
          if (CPLib.gt(nDim,nDimDoc)) {
            /* cRitorno := 'La dimensione del file è maggiore di quella consentita ('+LRTrim(Str(nDimDoc,5,2))+" Mb)!" // Ritorno Funzione */
            cRitorno = "La dimensione del file è maggiore di quella consentita ("+CPLib.LRTrim(CPLib.Str(nDimDoc,5,2))+" Mb)!";
          } // End If
          /* If At("'",pNomeDoc) > 0 */
          if (CPLib.gt(CPLib.At("'",pNomeDoc),0)) {
            /* cRitorno := "Impossibile utilizzare l'apostrofo nel nome del file!" // Ritorno Funzione */
            cRitorno = "Impossibile utilizzare l'apostrofo nel nome del file!";
          } // End If
          /* If pTipo=0 and dbTipo <> 'pdf' */
          if (CPLib.eqr(pTipo,0) && CPLib.ne(dbTipo,"pdf")) {
            /* cRitorno := "Per il documento unico è possibile utilizzare solo i PDF!" // Ritorno Funzione */
            cRitorno = "Per il documento unico è possibile utilizzare solo i PDF!";
          } // End If
          /* If cFind='S' and cRitorno='OK' */
          if (CPLib.eqr(cFind,"S") && CPLib.eqr(cRitorno,"OK")) {
            /* If dbTipo='pdf' */
            if (CPLib.eqr(dbTipo,"pdf")) {
              // Conta la pagine del PDF
              PDDocument doc = PDDocument.load(new File(cFile));
              count = doc.getNumberOfPages();
              /* If count < nPagine */
              if (CPLib.lt(count,nPagine)) {
                /* cRitorno := 'Il numero di pagine del documento ('+LRTrim(Str(count,3,0))+') è inferiore al numero minimo previsto ('+LRTrim(Str(nPagine,2,0))+")" // Ritorno Funzione */
                cRitorno = "Il numero di pagine del documento ("+CPLib.LRTrim(CPLib.Str(count,3,0))+") è inferiore al numero minimo previsto ("+CPLib.LRTrim(CPLib.Str(nPagine,2,0))+")";
              } // End If
            } // End If
            /* If dbTipo='tiff' */
            if (CPLib.eqr(dbTipo,"tiff")) {
              // Conta la pagine del PDF
              File file = new File(cFile);
              SeekableStream s = new FileSeekableStream(file);
              TIFFDecodeParam param = null;
              ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
              count=dec.getNumPages();
              /* If count < nPagine */
              if (CPLib.lt(count,nPagine)) {
                /* cRitorno := 'Il numero di pagine del documento ('+LRTrim(Str(count,3,0))+') è inferiore al numero minimo previsto ('+LRTrim(Str(nPagine,2,0))+")" // Ritorno Funzione */
                cRitorno = "Il numero di pagine del documento ("+CPLib.LRTrim(CPLib.Str(count,3,0))+") è inferiore al numero minimo previsto ("+CPLib.LRTrim(CPLib.Str(nPagine,2,0))+")";
              } // End If
            } // End If
            /* If dbTipo='jpeg' */
            if (CPLib.eqr(dbTipo,"jpeg")) {
              // Conta la pagine del PDF
              File file = new File(cFile);
              SeekableStream s = new FileSeekableStream(file);
              JPEGDecodeParam param = null;
              ImageDecoder dec = ImageCodec.createImageDecoder("jpeg", s, param);
              count=dec.getNumPages();
              /* If count < nPagine */
              if (CPLib.lt(count,nPagine)) {
                /* cRitorno := 'Il numero di pagine del documento ('+LRTrim(Str(count,3,0))+') è inferiore al numero minimo previsto ('+LRTrim(Str(nPagine,2,0))+")" // Ritorno Funzione */
                cRitorno = "Il numero di pagine del documento ("+CPLib.LRTrim(CPLib.Str(count,3,0))+") è inferiore al numero minimo previsto ("+CPLib.LRTrim(CPLib.Str(nPagine,2,0))+")";
              } // End If
            } // End If
          } // End If
        } // End If
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* FileLibMit.DeleteFile("appo/"+LRTrim(pCodDip)+"/"+LRTrim(pNomeDoc)) */
        FileLibMit.DeleteFile("appo/"+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(pNomeDoc));
        /* cRitorno := 'Documento non valido (formato non riconosciuto)' // Ritorno Funzione */
        cRitorno = "Documento non valido (formato non riconosciuto)";
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000017status,0)) {
          m_Sql.SetTransactionStatus(nTry00000017status,cTry00000017msg);
        }
      }
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_cgo_tipall!=null)
          Cursor_cgo_tipall.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void _init_() {
  }
  public String RunAsync(double p_pTipo,String p_pNomeDoc,String p_pTipoGioco,double p_pImpTick,double p_pImpCont,String p_pCodDip) {
    pTipo = p_pTipo;
    pNomeDoc = p_pNomeDoc;
    pTipoGioco = p_pTipoGioco;
    pImpTick = p_pImpTick;
    pImpCont = p_pImpCont;
    pCodDip = p_pCodDip;
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
  public String Run(double p_pTipo,String p_pNomeDoc,String p_pTipoGioco,double p_pImpTick,double p_pImpCont,String p_pCodDip) {
    pTipo = p_pTipo;
    pNomeDoc = p_pNomeDoc;
    pTipoGioco = p_pTipoGioco;
    pImpTick = p_pImpTick;
    pImpCont = p_pImpCont;
    pCodDip = p_pCodDip;
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return l_result;
  }
  public static arfn_verify_docR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_verify_docR(p_Ctx, p_Caller);
  }
  public static arfn_verify_docR Make(CPContext p_Ctx) {
    return new arfn_verify_docR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pTipo = 0;
    pNomeDoc = CPLib.Space(80);
    pTipoGioco = CPLib.Space(3);
    pImpTick = 0;
    pImpCont = 0;
    pCodDip = CPLib.Space(6);
    cRitorno = CPLib.Space(100);
    cFile = CPLib.Space(200);
    cTipo = CPLib.Space(30);
    dbTipo = CPLib.Space(4);
    nDim = 0;
    nDimDoc = 0;
    cFind = CPLib.Space(1);
    nPagine = 0;
    cStringa = CPLib.Space(7);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_activate_doc,arfn_verify_doc,
  public static final String i_InvokedRoutines = ",arfn_activate_doc,arfn_verify_doc,";
  public static String[] m_cRunParameterNames={"pTipo","pNomeDoc","pTipoGioco","pImpTick","pImpCont","pCodDip"};
}
