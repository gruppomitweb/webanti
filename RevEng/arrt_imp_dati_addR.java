// * --- Area Manuale = BO - Header
// * --- arrt_imp_dati_add
import java.io.File; 
import java.lang.Double;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import com.opencsv.*;
import com.opencsv.CSVWriter;
// * --- Fine Area Manuale
public class arrt_imp_dati_addR implements CallerWithObjs {
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
  public String m_cPhName_anadip;
  public String m_cServer_anadip;
  public String m_cPhName_personbo_agg;
  public String m_cServer_personbo_agg;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_xntestbo;
  public String m_cServer_xntestbo;
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
  public double w_impzip;
  public String xConnes;
  public double cNumNew;
  public double conta;
  public double _esito;
  public String czipfile;
  public String cpercorsozip;
  public String cdirectoryfile;
  public String buffernomefile;
  public String nomefileimport;
  public double _priorita;
  public String filename;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  public String cActLog;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_imp_dati_add
  public String[] lista;
  public int conteggio;
  public int i;
  public int _i;
  public int _y;
  public int contanome;
  public int _righe;
  public int _conta;
  // These are the files to include in the ZIP file
  Vector filenames = new Vector();
  Vector fileonames = new Vector();
  // * --- Fine Area Manuale
  public arrt_imp_dati_addR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_imp_dati_add",m_Caller);
    m_cPhName_anadip = p_ContextObject.GetPhName("anadip");
    if (m_cPhName_anadip.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_anadip = m_cPhName_anadip+" "+m_Ctx.GetWritePhName("anadip");
    }
    m_cServer_anadip = p_ContextObject.GetServer("anadip");
    m_cPhName_personbo_agg = p_ContextObject.GetPhName("personbo_agg");
    if (m_cPhName_personbo_agg.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_personbo_agg = m_cPhName_personbo_agg+" "+m_Ctx.GetWritePhName("personbo_agg");
    }
    m_cServer_personbo_agg = p_ContextObject.GetServer("personbo_agg");
    m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
    if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
    }
    m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    m_cPhName_xntestbo = p_ContextObject.GetPhName("xntestbo");
    if (m_cPhName_xntestbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_xntestbo = m_cPhName_xntestbo+" "+m_Ctx.GetWritePhName("xntestbo");
    }
    m_cServer_xntestbo = p_ContextObject.GetServer("xntestbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("impzip",p_cVarName)) {
      return w_impzip;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      return cNumNew;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      return conta;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      return _priorita;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_imp_dati_add";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("xConnes",p_cVarName)) {
      return xConnes;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      return czipfile;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      return cpercorsozip;
    }
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      return cdirectoryfile;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      return buffernomefile;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      return nomefileimport;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      return filename;
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
    if (CPLib.eqr("cActLog",p_cVarName)) {
      return cActLog;
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
    if (CPLib.eqr("impzip",p_cVarName)) {
      w_impzip = value;
      return;
    }
    if (CPLib.eqr("cNumNew",p_cVarName)) {
      cNumNew = value;
      return;
    }
    if (CPLib.eqr("conta",p_cVarName)) {
      conta = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_priorita",p_cVarName)) {
      _priorita = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("xConnes",p_cVarName)) {
      xConnes = value;
      return;
    }
    if (CPLib.eqr("czipfile",p_cVarName)) {
      czipfile = value;
      return;
    }
    if (CPLib.eqr("cpercorsozip",p_cVarName)) {
      cpercorsozip = value;
      return;
    }
    if (CPLib.eqr("cdirectoryfile",p_cVarName)) {
      cdirectoryfile = value;
      return;
    }
    if (CPLib.eqr("buffernomefile",p_cVarName)) {
      buffernomefile = value;
      return;
    }
    if (CPLib.eqr("nomefileimport",p_cVarName)) {
      nomefileimport = value;
      return;
    }
    if (CPLib.eqr("filename",p_cVarName)) {
      filename = value;
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
    if (CPLib.eqr("cActLog",p_cVarName)) {
      cActLog = value;
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
    CPResultSet Cursor_tmp_list_imprich=null;
    try {
      /* w_impzip Numeric(1, 0) */
      /* xConnes Char(16) */
      /* cNumNew Numeric(10, 0) // Contatore record nuovi */
      /* conta Numeric(10, 0) */
      /* _esito Numeric(1, 0) */
      /* czipfile Char(100) */
      /* cpercorsozip Char(200) */
      /* cdirectoryfile Char(200) */
      /* buffernomefile Char(100) */
      /* nomefileimport Char(50) */
      /* _priorita Numeric(3, 0) */
      /* filename Char(80) */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
      /* cActLog Char(1) // Log Applicazione */
      /* gMsgProc := '' */
      gMsgProc = "";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Cicla sul file della lista e lancia la pagina appropriata */
      // * --- Select from tmp_list_imprich
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      if (Cursor_tmp_list_imprich!=null)
        Cursor_tmp_list_imprich.Close();
      Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_tmp_list_imprich.Eof())) {
        /* If At('.zip',Lower(LRTrim(tmp_list_imprich->nomefile))) <> 0 */
        if (CPLib.ne(CPLib.At(".zip",CPLib.Lower(CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile")))),0)) {
          /* czipfile := LRTrim(tmp_list_imprich->nomefile) */
          czipfile = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
          /* Exec "Estrazione da zip" Page 4:Page_4 */
          Page_4();
        } // End If
        Cursor_tmp_list_imprich.Next();
      }
      m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
      Cursor_tmp_list_imprich.Close();
      // * --- End Select
      /* _esito := 0 */
      _esito = CPLib.Round(0,0);
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000001Dstatus;
      nTry0000001Dstatus = m_Sql.GetTransactionStatus();
      String cTry0000001Dmsg;
      cTry0000001Dmsg = m_Sql.TransactionErrorMessage();
      try {
        // * --- Select from tmp_list_imprich
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
        Cursor_tmp_list_imprich = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("tmp_list_imprich")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1")+" order by "+"priorita,nomefile ",m_cServer,m_Ctx,true));
        while ( ! (Cursor_tmp_list_imprich.Eof())) {
          /* If _esito = 0 */
          if (CPLib.eqr(_esito,0)) {
            /* nomefileimport := LRTrim(tmp_list_imprich->nomefile) */
            nomefileimport = CPLib.LRTrim(Cursor_tmp_list_imprich.GetString("nomefile"));
            /* Case At('archpers_add.csv',Lower(nomefileimport)) <> 0 */
            if (CPLib.ne(CPLib.At("archpers_add.csv",CPLib.Lower(nomefileimport)),0)) {
              /* Exec "Dati Aggiuntivi Soggetti" Page 2:Page_2 */
              Page_2();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
              /* Case At('anadip_add.csv',Lower(nomefileimport)) <> 0 */
            } else if (CPLib.ne(CPLib.At("anadip_add.csv",CPLib.Lower(nomefileimport)),0)) {
              /* Exec "Dati Aggiuntivi Agenzie" Page 3:Page_3 */
              Page_3();
              if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
                throw new RoutineException();
              }
            } // End Case
          } // End If
          // * --- Delete from tmp_list_imprich
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("tmp_list_imprich");
          m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_add",836,"00000024")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(Cursor_tmp_list_imprich.GetString("nomefile"),"?",0,0,m_cServer),m_cServer,Cursor_tmp_list_imprich.GetString("nomefile"))+"";
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
          Cursor_tmp_list_imprich.Next();
        }
        m_cConnectivityError = Cursor_tmp_list_imprich.ErrorMessage();
        Cursor_tmp_list_imprich.Close();
        // * --- End Select
        /* gMsgImp := 'Fine importazione dati. Inizio fase di commit. Attendere prego...' // Messaggio Import */
        gMsgImp = "Fine importazione dati. Inizio fase di commit. Attendere prego...";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* gMsgImp := 'Importazione dati terminata.' // Messaggio Import */
        gMsgImp = "Importazione dati terminata.";
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* gMsgProc := gMsgProc + "Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione" + NL */
        gMsgProc = gMsgProc+"Rilevati errori nell'impotazione dei file! Ricreare il file segnalato e rieseguire l'import dei dati. La procedura annullera automaticamente l'importazione"+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* gMsgProc := gMsgProc + 'Errore SQL: ' + m_Sql.TransactionErrorMessage() + NL */
        gMsgProc = gMsgProc+"Errore SQL: "+m_Sql.TransactionErrorMessage()+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Dstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000001Dstatus,cTry0000001Dmsg);
        }
      }
    } finally {
      try {
        if (Cursor_tmp_list_imprich!=null)
          Cursor_tmp_list_imprich.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_2() throws Exception {
    /* Legge il file di testo e porta i dati nella tabella */
    /* conta := 1 */
    conta = CPLib.Round(1,0);
    /* cNumNew := 0 */
    cNumNew = CPLib.Round(0,0);
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _i = 0 */
    CPLib.eqr(_i,0);
    /* filename := LRTrim(gPathApp)+"/appo/"+LRTrim(nomefileimport) */
    filename = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(nomefileimport);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000032status;
    nTry00000032status = m_Sql.GetTransactionStatus();
    String cTry00000032msg;
    cTry00000032msg = m_Sql.TransactionErrorMessage();
    try {
      // Inizializza Lettore CSV
      FileReader freader=new FileReader(filename);
      CSVReader reader = new CSVReaderBuilder(freader).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
      String [] nextLine;
      while ((nextLine = reader.readNext()) != null) {
      /* If cNumNew > 0 and not(Empty(nextLine[0])) */
      if (CPLib.gt(cNumNew,0) &&  ! (CPLib.Empty(nextLine[0]))) {
        /* gMsgImp := 'Sto aggiornando il soggetto '+LRTrim(nextLine[0])+" - Riga:" + LRTrim(Str(conta,10,0)) // Messaggio Import */
        gMsgImp = "Sto aggiornando il soggetto "+CPLib.LRTrim(nextLine[0])+" - Riga:"+CPLib.LRTrim(CPLib.Str(conta,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        // * --- Write into personbo_agg from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("personbo_agg");
        m_cPhName = m_Ctx.GetPhName("personbo_agg");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_add",836,"00000036")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"REGRES = "+CPLib.ToSQL(CPLib.Right("00"+CPLib.LRTrim(nextLine[1]),2),"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"FLGBL = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[2]),1),"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"CLOCCUPA = "+CPLib.ToSQL(CPLib.Val(nextLine[3]),"N",3,0)+", ";
        m_cSql = m_cSql+"RDCODAUT = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[4]),2),"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"NAZIONE = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[5]),3),"C",3,0,m_cServer)+", ";
        m_cSql = m_cSql+"CODCLIEST = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[6]),10),"C",10,0,m_cServer)+", ";
        m_cSql = m_cSql+"CLPRVDOM = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[7]),2),"C",2,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"personbo_agg",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CONNES = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer),m_cServer,CPLib.LRTrim(nextLine[0]))+"";
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
        /* If m_nUpdatedRows=0 */
        if (CPLib.eqr(m_nUpdatedRows,0)) {
          // * --- Insert into personbo_agg from values
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("personbo_agg");
          m_cPhName = m_Ctx.GetPhName("personbo_agg");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"personbo_agg",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_add",836,"00000038")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
          m_cSql = m_cSql+GetFieldsName_00000038(m_Ctx,m_oWrInfo);
          m_cSql = m_cSql+") values (";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.LRTrim(nextLine[0]),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Right("00"+CPLib.LRTrim(nextLine[1]),2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[2]),1),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Val(nextLine[3]),"?",0,0)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[4]),2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[5]),3),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[6]),10),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[7]),2),"?",0,0,m_cServer)+", ";
          m_cSql = m_cSql+m_oWrInfo.InsertValues();
          m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"personbo_agg",true);
          m_cSql = m_cSql+")";
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
        } // End If
      } // End If
      /* conta := conta + 1 */
      conta = CPLib.Round(conta+1,0);
      /* cNumNew := cNumNew + 1 */
      cNumNew = CPLib.Round(cNumNew+1,0);
      }
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000032status,0)) {
        m_Sql.SetTransactionStatus(nTry00000032status,cTry00000032msg);
      }
    }
    /* gMsgProc := gMsgProc + 'Dati Aggiuntivi Soggetti: '+LRTrim(Str(cNumNew - 1,10,0)) + NL */
    gMsgProc = gMsgProc+"Dati Aggiuntivi Soggetti: "+CPLib.LRTrim(CPLib.Str(cNumNew-1,10,0))+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
    gMsgImp = "Fine importazione del file "+nomefileimport;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* Exec Routine arrt_writelog_imp('IMPORT','PERSONBO_ADD','Dati Aggiuntivi Soggetti: '+LRTrim(Str(cNumNew - 1,10,0))) */
    arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","PERSONBO_ADD","Dati Aggiuntivi Soggetti: "+CPLib.LRTrim(CPLib.Str(cNumNew-1,10,0)));
  }
  void Page_3() throws Exception {
    /* Legge il file di testo e porta i dati nella tabella */
    /* conta := 1 */
    conta = CPLib.Round(1,0);
    /* cNumNew := 0 */
    cNumNew = CPLib.Round(0,0);
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* _i = 0 */
    CPLib.eqr(_i,0);
    /* filename := LRTrim(gPathApp)+"/appo/"+LRTrim(nomefileimport) */
    filename = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(nomefileimport);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000049status;
    nTry00000049status = m_Sql.GetTransactionStatus();
    String cTry00000049msg;
    cTry00000049msg = m_Sql.TransactionErrorMessage();
    try {
      FileReader freader=new FileReader(filename);
      CSVReader reader = new CSVReaderBuilder(freader).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
      String [] nextLine;
      while ((nextLine = reader.readNext()) != null) {
      /* gMsgImp := "Aggiorno i dati dell'agenzia "+LRTrim(nextLine[0]) // Messaggio Import */
      gMsgImp = "Aggiorno i dati dell'agenzia "+CPLib.LRTrim(nextLine[0]);
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* If cNumNew > 0 */
      if (CPLib.gt(cNumNew,0)) {
        // * --- Write into anadip from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("anadip");
        m_cPhName = m_Ctx.GetPhName("anadip");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"anadip",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_add",836,"0000004D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
        m_cSql = m_cSql+"NAZAGENTE = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[1]),3),"C",3,0,m_cServer)+", ";
        m_cSql = m_cSql+"OPXSOSCLI = "+CPLib.ToSQL(CPLib.Val(nextLine[2]),"N",10,0)+", ";
        m_cSql = m_cSql+"OPXSOSAGE = "+CPLib.ToSQL(CPLib.Val(nextLine[3]),"N",10,0)+", ";
        m_cSql = m_cSql+"VALCOMPL = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[4]),2),"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"ANOMOPER = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[5]),2),"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"AGEREGIO = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[6]),2),"C",2,0,m_cServer)+", ";
        m_cSql = m_cSql+"FLGATT = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[7]),1),"C",1,0,m_cServer)+", ";
        m_cSql = m_cSql+"AGACCODE = "+CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[8]),10),"C",10,0,m_cServer)+", ";
        m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"anadip",false,true);
        m_cSql = m_cSql+" where ";
        m_cSql = m_cSql+"CODDIP = "+CPSql.SQLValueAdapter(CPLib.ToSQL(CPLib.Left(CPLib.LRTrim(nextLine[0]),6),"?",0,0,m_cServer),m_cServer,CPLib.Left(CPLib.LRTrim(nextLine[0]),6))+"";
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
      } // End If
      /* cNumNew := cNumNew + 1 */
      cNumNew = CPLib.Round(cNumNew+1,0);
      }
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000049status,0)) {
        m_Sql.SetTransactionStatus(nTry00000049status,cTry00000049msg);
      }
    }
    /* gMsgProc := gMsgProc + 'Agenzie Aggiornate: '+LRTrim(Str(cNumNew - 1,10,0)) + NL */
    gMsgProc = gMsgProc+"Agenzie Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumNew-1,10,0))+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +nomefileimport + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+nomefileimport+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Fine importazione del file '+nomefileimport // Messaggio Import */
    gMsgImp = "Fine importazione del file "+nomefileimport;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* Exec Routine arrt_writelog_imp('IMPORT','ANADIP', 'Agenzie Aggiornate: '+LRTrim(Str(cNumNew - 1,10,0))) */
    arrt_writelog_impR.Make(m_Ctx,this).Run("IMPORT","ANADIP","Agenzie Aggiornate: "+CPLib.LRTrim(CPLib.Str(cNumNew-1,10,0)));
  }
  void Page_4() throws Exception {
    /* gMsgProc := gMsgProc + 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' + czipfile + NL */
    gMsgProc = gMsgProc+"Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    /* gMsgImp := 'Inizio estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Inizio estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* cpercorsozip := LRTrim(gPathApp)+"/appo/"+czipfile */
    cpercorsozip = CPLib.LRTrim(gPathApp)+"/appo/"+czipfile;
    /* cdirectoryfile := LRTrim(gPathApp)+"/appo/" */
    cdirectoryfile = CPLib.LRTrim(gPathApp)+"/appo/";
    try {
          // Apro il file zip
          java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
    
          //Conto il numero di file all interno del file zip e creo un array di stringhe per memorizzare i nomi file
          conteggio=zf.size();
          lista=new String[conteggio];
          
          // Enumerate each entry
          i=0;
          for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
              // Get the entry name
              lista[i] = ((java.util.zip.ZipEntry)entries.nextElement()).getName();
              i++;
          }
         zf.close();
         } catch (java.io.IOException e) {
         }
    try {
          // Apro il file zip
          java.util.zip.ZipFile zf = new java.util.zip.ZipFile(cpercorsozip);
    
          byte[] buffer = new byte[1024]; 
          java.util.Enumeration entries = zf.entries();
          while(entries.hasMoreElements() ) {
            java.util.zip.ZipEntry entry = (java.util.zip.ZipEntry)entries.nextElement();
            java.io.InputStream in =zf.getInputStream(entry);
            java.io.OutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(cdirectoryfile+entry.getName()));
    
            int len;
    
            while((len = in.read(buffer)) >= 0){
              out.write(buffer, 0, len);
            }
    
              in.close();
              out.close();
          }
    
          zf.close();
    } catch (java.io.IOException ioe) {
          System.err.println("Unhandled exception:");
          ioe.printStackTrace();
          return;
    }
    // * --- Delete from tmp_list_imprich
    m_Sql.RequireTransaction();
    m_cServer = m_Ctx.GetServer("tmp_list_imprich");
    m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
    m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
    m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
    m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_add",836,"0000005B")+"delete from "+m_oWrInfo.GetTableWriteName();
    m_cSql = m_cSql+" where ";
    m_cSql = m_cSql+"nomefile = "+CPSql.SQLValueAdapter(CPLib.ToSQL(czipfile,"?",0,0,m_cServer),m_cServer,czipfile)+"";
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
    /* contanome := 0 */
    contanome = 0;
    /* _priorita := 0 */
    _priorita = CPLib.Round(0,0);
    /* While contanome<conteggio */
    while (CPLib.lt(contanome,conteggio)) {
      buffernomefile=lista[contanome];
      // * --- Insert into tmp_list_imprich from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_imp_dati_add",836,"00000060")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000060(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(buffernomefile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"tmp_list_imprich",true);
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
      /* contanome := contanome+1 */
      contanome = contanome+1;
    } // End While
    /* FileLibMit.DeleteFile('./appo/'+czipfile) */
    FileLibMit.DeleteFile("./appo/"+czipfile);
    /* gMsgImp := 'Fine estrazione del file '+ czipfile // Messaggio Import */
    gMsgImp = "Fine estrazione del file "+czipfile;
    m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) + ' del file ' +czipfile + NL */
    gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+" del file "+czipfile+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
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
      m_Caller.SetNumber("impzip","N",1,0,w_impzip);
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_imp_dati_addR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_imp_dati_addR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_impzip = m_Caller.GetNumber("impzip","N",1,0);
    xConnes = CPLib.Space(16);
    cNumNew = 0;
    conta = 0;
    _esito = 0;
    czipfile = CPLib.Space(100);
    cpercorsozip = CPLib.Space(200);
    cdirectoryfile = CPLib.Space(200);
    buffernomefile = CPLib.Space(100);
    nomefileimport = CPLib.Space(50);
    _priorita = 0;
    filename = CPLib.Space(80);
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    cActLog=m_Ctx.GetGlobalString("cActLog");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_fdatetime,arrt_writelog_imp,
  public static final String i_InvokedRoutines = ",arfn_fdatetime,arrt_writelog_imp,";
  public static String[] m_cRunParameterNames={};
  protected static String GetFieldsName_00000038(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CONNES,";
    p_cSql = p_cSql+"REGRES,";
    p_cSql = p_cSql+"FLGBL,";
    p_cSql = p_cSql+"CLOCCUPA,";
    p_cSql = p_cSql+"RDCODAUT,";
    p_cSql = p_cSql+"NAZIONE,";
    p_cSql = p_cSql+"CODCLIEST,";
    p_cSql = p_cSql+"CLPRVDOM,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"personbo_agg",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000060(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
}
