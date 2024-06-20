// * --- Area Manuale = BO - Header
// * --- arrt_azzera_invii_opex
import java.util.*;
// * --- Fine Area Manuale
public class arrt_azzera_invii_opexR implements CallerWithObjs {
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
  public String m_cPhName_aeoprig;
  public String m_cServer_aeoprig;
  public String m_cPhName_aederig;
  public String m_cServer_aederig;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
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
  public java.sql.Date w_a_data;
  public java.sql.Date w_dadata;
  public double w_anno;
  public String w_mese;
  public String gMsgImp;
  public String gMsgProc;
  public double _copex;
  public double _cdel1;
  public double _cdel2;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_azzera_invii_opex
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_azzera_invii_opexR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_azzera_invii_opex",m_Caller);
    m_cPhName_aeoprig = p_ContextObject.GetPhName("aeoprig");
    if (m_cPhName_aeoprig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeoprig = m_cPhName_aeoprig+" "+m_Ctx.GetWritePhName("aeoprig");
    }
    m_cServer_aeoprig = p_ContextObject.GetServer("aeoprig");
    m_cPhName_aederig = p_ContextObject.GetPhName("aederig");
    if (m_cPhName_aederig.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aederig = m_cPhName_aederig+" "+m_Ctx.GetWritePhName("aederig");
    }
    m_cServer_aederig = p_ContextObject.GetServer("aederig");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("anno",p_cVarName)) {
      return w_anno;
    }
    if (CPLib.eqr("_copex",p_cVarName)) {
      return _copex;
    }
    if (CPLib.eqr("_cdel1",p_cVarName)) {
      return _cdel1;
    }
    if (CPLib.eqr("_cdel2",p_cVarName)) {
      return _cdel2;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_azzera_invii_opex";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("mese",p_cVarName)) {
      return w_mese;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
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
    if (CPLib.eqr("anno",p_cVarName)) {
      w_anno = value;
      return;
    }
    if (CPLib.eqr("_copex",p_cVarName)) {
      _copex = value;
      return;
    }
    if (CPLib.eqr("_cdel1",p_cVarName)) {
      _cdel1 = value;
      return;
    }
    if (CPLib.eqr("_cdel2",p_cVarName)) {
      _cdel2 = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("mese",p_cVarName)) {
      w_mese = value;
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
    CPResultSet Cursor_qbe_azzera_invii_opx_1=null;
    CPResultSet Cursor_qbe_azzera_invii_opx_2=null;
    CPResultSet Cursor_qbe_azzera_invii_opx_3=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* w_a_data Date */
      /* w_dadata Date */
      /* w_anno Numeric(4, 0) */
      /* w_mese Char(2) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* _copex Numeric(10, 0) */
      /* _cdel1 Numeric(10, 0) */
      /* _cdel2 Numeric(10, 0) */
      /* Verifica di poter cancellare */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _copex := 0 */
      _copex = CPLib.Round(0,0);
      /* _cdel1 := 0 */
      _cdel1 = CPLib.Round(0,0);
      /* _cdel2 := 0 */
      _cdel2 = CPLib.Round(0,0);
      /* gMsgImp := 'Controllo della possibilità di annullare gli import mensili' // Messaggio */
      gMsgImp = "Controllo della possibilità di annullare gli import mensili";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      // * --- Select from qbe_azzera_invii_opx_1
      if (Cursor_qbe_azzera_invii_opx_1!=null)
        Cursor_qbe_azzera_invii_opx_1.Close();
      Cursor_qbe_azzera_invii_opx_1 = new VQRHolder("qbe_azzera_invii_opx_1",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_azzera_invii_opx_1.Eof())) {
        /* _copex := qbe_azzera_invii_opx_1->TOTALE */
        _copex = CPLib.Round(Cursor_qbe_azzera_invii_opx_1.GetDouble("TOTALE"),0);
        Cursor_qbe_azzera_invii_opx_1.Next();
      }
      m_cConnectivityError = Cursor_qbe_azzera_invii_opx_1.ErrorMessage();
      Cursor_qbe_azzera_invii_opx_1.Close();
      // * --- End Select
      // * --- Select from qbe_azzera_invii_opx_2
      if (Cursor_qbe_azzera_invii_opx_2!=null)
        Cursor_qbe_azzera_invii_opx_2.Close();
      Cursor_qbe_azzera_invii_opx_2 = new VQRHolder("qbe_azzera_invii_opx_2",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_azzera_invii_opx_2.Eof())) {
        /* _cdel1 := qbe_azzera_invii_opx_2->TOTALE */
        _cdel1 = CPLib.Round(Cursor_qbe_azzera_invii_opx_2.GetDouble("TOTALE"),0);
        Cursor_qbe_azzera_invii_opx_2.Next();
      }
      m_cConnectivityError = Cursor_qbe_azzera_invii_opx_2.ErrorMessage();
      Cursor_qbe_azzera_invii_opx_2.Close();
      // * --- End Select
      // * --- Select from qbe_azzera_invii_opx_3
      if (Cursor_qbe_azzera_invii_opx_3!=null)
        Cursor_qbe_azzera_invii_opx_3.Close();
      Cursor_qbe_azzera_invii_opx_3 = new VQRHolder("qbe_azzera_invii_opx_3",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),this,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_azzera_invii_opx_3.Eof())) {
        /* _cdel2 := qbe_azzera_invii_opx_3->TOTALE */
        _cdel2 = CPLib.Round(Cursor_qbe_azzera_invii_opx_3.GetDouble("TOTALE"),0);
        Cursor_qbe_azzera_invii_opx_3.Next();
      }
      m_cConnectivityError = Cursor_qbe_azzera_invii_opx_3.ErrorMessage();
      Cursor_qbe_azzera_invii_opx_3.Close();
      // * --- End Select
      /* If (_copex + _cdel1 + _cdel2) > 0 */
      if (CPLib.gt((_copex+_cdel1+_cdel2),0)) {
        /* gMsgProc := gMsgProc + "Impossibile procedere con l'operazione di azzeramento dell'import" + NL */
        gMsgProc = gMsgProc+"Impossibile procedere con l'operazione di azzeramento dell'import"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + "E' necessario prima effetture la funzione di annullamento dei file inviati (7.6)" + NL */
        gMsgProc = gMsgProc+"E' necessario prima effetture la funzione di annullamento dei file inviati (7.6)"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
        gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      } else { // Else
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000001Estatus;
        nTry0000001Estatus = m_Sql.GetTransactionStatus();
        String cTry0000001Emsg;
        cTry0000001Emsg = m_Sql.TransactionErrorMessage();
        try {
          /* gMsgImp := 'Azzeramento import operazioni extraconto' // Messaggio */
          gMsgImp = "Azzeramento import operazioni extraconto";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Delete from aeoprig
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aeoprig");
          m_cPhName = m_Ctx.GetPhName("aeoprig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aeoprig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_azzera_invii_opex",195,"00000020")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"ADATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_dadata,"?",0,0,m_cServer),m_cServer,w_dadata)+"";
          m_cSql = m_cSql+" and ADATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_a_data,"?",0,0,m_cServer),m_cServer,w_a_data)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          // * --- Write into opextrbo from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("opextrbo");
          m_cPhName = m_Ctx.GetPhName("opextrbo");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_azzera_invii_opex",195,"00000021")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"NUMPROG1 = "+CPLib.ToSQL("","C",10,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"DATAOPE >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_dadata,"?",0,0,m_cServer),m_cServer,w_dadata)+"";
          m_cSql = m_cSql+" and DATAOPE <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_a_data,"?",0,0,m_cServer),m_cServer,w_a_data)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgImp := 'Azzeramento Aperture Deleghe' // Messaggio */
          gMsgImp = "Azzeramento Aperture Deleghe";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Delete from aederig
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_azzera_invii_opex",195,"00000023")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"ADATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_dadata,"?",0,0,m_cServer),m_cServer,w_dadata)+"";
          m_cSql = m_cSql+" and ADATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_a_data,"?",0,0,m_cServer),m_cServer,w_a_data)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          /* gMsgImp := 'Azzeramento import operazioni extraconto' // Messaggio */
          gMsgImp = "Azzeramento import operazioni extraconto";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Write into aederig from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("aederig");
          m_cPhName = m_Ctx.GetPhName("aederig");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aederig",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_azzera_invii_opex",195,"00000025")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
          m_cSql = m_cSql+"CDATA = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
          m_cSql = m_cSql+"CSPEDITO = "+CPLib.ToSQL(0,"N",1,0)+", ";
          m_cSql = m_cSql+"CFILE = "+CPLib.ToSQL("","C",15,0,m_cServer)+", ";
          m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aederig",false,true);
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"CDATA >= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_dadata,"?",0,0,m_cServer),m_cServer,w_dadata)+"";
          m_cSql = m_cSql+" and CDATA <= "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_a_data,"?",0,0,m_cServer),m_cServer,w_a_data)+"";
          m_cSql = m_cSql+m_oWrInfo.WhereFilter();
          m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql,m_oParameters);
          if (CPLib.lt(m_nUpdatedRows,0)) {
            m_Sql.AbortTransaction();
          }
          m_Sql.CompleteTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
            throw new RoutineException();
          }
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* gMsgImp := 'Elaborazione terminata con successo !' // Messaggio */
          gMsgImp = "Elaborazione terminata con successo !";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc + "Operazione completata con successo" + NL */
          gMsgProc = gMsgProc+"Operazione completata con successo"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* gMsgImp := 'Elaborazione annullata per errori !' // Messaggio */
          gMsgImp = "Elaborazione annullata per errori !";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          /* gMsgProc := gMsgProc + "Operazione annulata per errori durante il processo di cancellazione" + NL */
          gMsgProc = gMsgProc+"Operazione annulata per errori durante il processo di cancellazione"+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + NL */
          gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Estatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000001Estatus,cTry0000001Emsg);
          }
        }
      } // End If
    } finally {
      try {
        if (Cursor_qbe_azzera_invii_opx_1!=null)
          Cursor_qbe_azzera_invii_opx_1.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_azzera_invii_opx_2!=null)
          Cursor_qbe_azzera_invii_opx_2.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_qbe_azzera_invii_opx_3!=null)
          Cursor_qbe_azzera_invii_opx_3.Close();
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
      m_Caller.SetDate("a_data","D",8,0,w_a_data);
      m_Caller.SetDate("dadata","D",8,0,w_dadata);
      m_Caller.SetNumber("anno","N",4,0,w_anno);
      m_Caller.SetString("mese","C",2,0,w_mese);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_azzera_invii_opexR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_azzera_invii_opexR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_a_data = m_Caller.GetDate("a_data","D",8,0);
    w_dadata = m_Caller.GetDate("dadata","D",8,0);
    w_anno = m_Caller.GetNumber("anno","N",4,0);
    w_mese = m_Caller.GetString("mese","C",2,0);
    _copex = 0;
    _cdel1 = 0;
    _cdel2 = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_azzera_invii_opx_1,qbe_azzera_invii_opx_2,qbe_azzera_invii_opx_3,
  public static final String m_cVQRList = ",qbe_azzera_invii_opx_1,qbe_azzera_invii_opx_2,qbe_azzera_invii_opx_3,";
  // ENTITY_BATCHES: ,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,";
  public static String[] m_cRunParameterNames={};
}
