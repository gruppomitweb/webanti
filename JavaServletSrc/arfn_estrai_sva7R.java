// * --- Area Manuale = BO - Header
// * --- arfn_estrai_sva7
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
// * --- Fine Area Manuale
public class arfn_estrai_sva7R implements CallerWithObjs {
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
  public String m_cPhName_sottovocea7;
  public String m_cServer_sottovocea7;
  public String m_cPhName_detta7;
  public String m_cServer_detta7;
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
  public String pAnno;
  public String pSem;
  public MemoryCursor_mca7_mcrdef mcA7;
  public double _contaatt;
  public String _attr;
  public String _dato;
  public String _attr0;
  public String _dato0;
  public String _attr1;
  public String _dato1;
  public String _attr2;
  public String _dato2;
  public String _attr3;
  public String _dato3;
  public String _attr4;
  public String _dato4;
  public String _attr5;
  public String _dato5;
  public String _attr6;
  public String _dato6;
  public String _filename;
  public String _filepath;
  public double _righe;
  public String gAzienda;
  public String gMsgImp;
  public String gMsgProc;
  public String gPathApp;
  public String gPathDoc;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_estrai_sva7
  public char delimiter=';';
  // * --- Fine Area Manuale
  public arfn_estrai_sva7R (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_estrai_sva7",m_Caller);
    m_cPhName_sottovocea7 = p_ContextObject.GetPhName("sottovocea7");
    if (m_cPhName_sottovocea7.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sottovocea7 = m_cPhName_sottovocea7+" "+m_Ctx.GetWritePhName("sottovocea7");
    }
    m_cServer_sottovocea7 = p_ContextObject.GetServer("sottovocea7");
    m_cPhName_detta7 = p_ContextObject.GetPhName("detta7");
    if (m_cPhName_detta7.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_detta7 = m_cPhName_detta7+" "+m_Ctx.GetWritePhName("detta7");
    }
    m_cServer_detta7 = p_ContextObject.GetServer("detta7");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_contaatt",p_cVarName)) {
      return _contaatt;
    }
    if (CPLib.eqr("_righe",p_cVarName)) {
      return _righe;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_estrai_sva7";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pAnno",p_cVarName)) {
      return pAnno;
    }
    if (CPLib.eqr("pSem",p_cVarName)) {
      return pSem;
    }
    if (CPLib.eqr("_attr",p_cVarName)) {
      return _attr;
    }
    if (CPLib.eqr("_dato",p_cVarName)) {
      return _dato;
    }
    if (CPLib.eqr("_attr0",p_cVarName)) {
      return _attr0;
    }
    if (CPLib.eqr("_dato0",p_cVarName)) {
      return _dato0;
    }
    if (CPLib.eqr("_attr1",p_cVarName)) {
      return _attr1;
    }
    if (CPLib.eqr("_dato1",p_cVarName)) {
      return _dato1;
    }
    if (CPLib.eqr("_attr2",p_cVarName)) {
      return _attr2;
    }
    if (CPLib.eqr("_dato2",p_cVarName)) {
      return _dato2;
    }
    if (CPLib.eqr("_attr3",p_cVarName)) {
      return _attr3;
    }
    if (CPLib.eqr("_dato3",p_cVarName)) {
      return _dato3;
    }
    if (CPLib.eqr("_attr4",p_cVarName)) {
      return _attr4;
    }
    if (CPLib.eqr("_dato4",p_cVarName)) {
      return _dato4;
    }
    if (CPLib.eqr("_attr5",p_cVarName)) {
      return _attr5;
    }
    if (CPLib.eqr("_dato5",p_cVarName)) {
      return _dato5;
    }
    if (CPLib.eqr("_attr6",p_cVarName)) {
      return _attr6;
    }
    if (CPLib.eqr("_dato6",p_cVarName)) {
      return _dato6;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      return _filename;
    }
    if (CPLib.eqr("_filepath",p_cVarName)) {
      return _filepath;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
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
    if (CPLib.eqr("mcA7",p_cVarName)) {
      return mcA7;
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
    if (CPLib.eqr("_contaatt",p_cVarName)) {
      _contaatt = value;
      return;
    }
    if (CPLib.eqr("_righe",p_cVarName)) {
      _righe = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pAnno",p_cVarName)) {
      pAnno = value;
      return;
    }
    if (CPLib.eqr("pSem",p_cVarName)) {
      pSem = value;
      return;
    }
    if (CPLib.eqr("_attr",p_cVarName)) {
      _attr = value;
      return;
    }
    if (CPLib.eqr("_dato",p_cVarName)) {
      _dato = value;
      return;
    }
    if (CPLib.eqr("_attr0",p_cVarName)) {
      _attr0 = value;
      return;
    }
    if (CPLib.eqr("_dato0",p_cVarName)) {
      _dato0 = value;
      return;
    }
    if (CPLib.eqr("_attr1",p_cVarName)) {
      _attr1 = value;
      return;
    }
    if (CPLib.eqr("_dato1",p_cVarName)) {
      _dato1 = value;
      return;
    }
    if (CPLib.eqr("_attr2",p_cVarName)) {
      _attr2 = value;
      return;
    }
    if (CPLib.eqr("_dato2",p_cVarName)) {
      _dato2 = value;
      return;
    }
    if (CPLib.eqr("_attr3",p_cVarName)) {
      _attr3 = value;
      return;
    }
    if (CPLib.eqr("_dato3",p_cVarName)) {
      _dato3 = value;
      return;
    }
    if (CPLib.eqr("_attr4",p_cVarName)) {
      _attr4 = value;
      return;
    }
    if (CPLib.eqr("_dato4",p_cVarName)) {
      _dato4 = value;
      return;
    }
    if (CPLib.eqr("_attr5",p_cVarName)) {
      _attr5 = value;
      return;
    }
    if (CPLib.eqr("_dato5",p_cVarName)) {
      _dato5 = value;
      return;
    }
    if (CPLib.eqr("_attr6",p_cVarName)) {
      _attr6 = value;
      return;
    }
    if (CPLib.eqr("_dato6",p_cVarName)) {
      _dato6 = value;
      return;
    }
    if (CPLib.eqr("_filename",p_cVarName)) {
      _filename = value;
      return;
    }
    if (CPLib.eqr("_filepath",p_cVarName)) {
      _filepath = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
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
    if (CPLib.eqr("mcA7",p_cVarName)) {
      mcA7 = (MemoryCursor_mca7_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_detta7=null;
    try {
      /* pAnno Char(4) // Anno */
      /* pSem Char(1) // Semestre */
      /* mcA7 MemoryCursor(mcA7.MCRDef) // MC per dati del semestre */
      /* _contaatt Numeric(10, 0) */
      /* _attr Char(0) // Attributo */
      /* _dato Char(0) // Dato */
      /* _attr0 Char(0) // Attributo 0 */
      /* _dato0 Char(0) // Dato 0 */
      /* _attr1 Char(0) // Attributo 1 */
      /* _dato1 Char(0) // Dato 1 */
      /* _attr2 Char(0) // Attributo 2 */
      /* _dato2 Char(0) // Dato 2 */
      /* _attr3 Char(0) // Attributo 3 */
      /* _dato3 Char(0) // Dato 3 */
      /* _attr4 Char(0) // Attributo 4 */
      /* _dato4 Char(0) // Dato 4 */
      /* _attr5 Char(0) // Attributo 5 */
      /* _dato5 Char(0) // Dato 5 */
      /* _attr6 Char(0) // Attributo 6 */
      /* _dato6 Char(0) // Dato 6 */
      /* _filename Char(0) */
      /* _filepath Char(0) */
      /* _writer Object(BufferedWriter) */
      BufferedWriter _writer;
      _writer = null;
      /* _printer Object(CSVPrinter) */
      CSVPrinter _printer;
      _printer = null;
      /* _righe Numeric(4, 0) := 0 */
      _righe = CPLib.Round(0,0);
      /* gAzienda Char(10) // Azienda */
      /* gMsgImp Char(120) // Messaggio Import */
      /* gMsgProc Memo // Messaggio */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(128) // Path Documenti */
      /* gMsgProc := 'Ora Inizio Processo: '+ arfn_fdatetime(DateTime()) + NL */
      gMsgProc = "Ora Inizio Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      // * --- Select from detta7
      m_cServer = m_Ctx.GetServer("detta7");
      m_cPhName = m_Ctx.GetPhName("detta7");
      if (Cursor_detta7!=null)
        Cursor_detta7.Close();
      Cursor_detta7 = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"ANNO="+CPSql.SQLValueAdapter(CPLib.ToSQL(pAnno,"?",0,0,m_cServer, m_oParameters),m_cServer,pAnno)+"  and  SEMESTRE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pSem,"?",0,0,m_cServer, m_oParameters),m_cServer,pSem)+" "+")"+(m_Ctx.IsSharedTemp("detta7")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_detta7.Eof())) {
        /* _righe := _righe + 1 */
        _righe = CPLib.Round(_righe+1,0);
        /* gMsgImp := 'Elaboro la voce: '+LRTrim(detta7->VOCE)+"-"+LRTrim(detta7->SOTTOVOCE) // Messaggio Import */
        gMsgImp = "Elaboro la voce: "+CPLib.LRTrim(Cursor_detta7.GetString("VOCE"))+"-"+CPLib.LRTrim(Cursor_detta7.GetString("SOTTOVOCE"));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* _contaatt := 0 */
        _contaatt = CPLib.Round(0,0);
        /* _attr := '' // Attributo */
        _attr = "";
        /* _dato := '' // Dato */
        _dato = "";
        /* _attr0 := '' // Attributo 0 */
        _attr0 = "";
        /* _dato0 := '' // Dato 0 */
        _dato0 = "";
        /* _attr1 := '' // Attributo 1 */
        _attr1 = "";
        /* _dato1 := '' // Dato 1 */
        _dato1 = "";
        /* _attr2 := '' // Attributo 2 */
        _attr2 = "";
        /* _dato2 := '' // Dato 2 */
        _dato2 = "";
        /* _attr3 := '' // Attributo 3 */
        _attr3 = "";
        /* _dato3 := '' // Dato 3 */
        _dato3 = "";
        /* _attr4 := '' // Attributo 4 */
        _attr4 = "";
        /* _dato4 := '' // Dato 4 */
        _dato4 = "";
        /* _attr5 := '' // Attributo 5 */
        _attr5 = "";
        /* _dato5 := '' // Dato 5 */
        _dato5 = "";
        /* _attr6 := '' // Attributo 6 */
        _attr6 = "";
        /* _dato6 := "" // Dato 6 */
        _dato6 = "";
        /* If not(Empty(detta7->PROVINCIA)) */
        if ( ! (CPLib.Empty(Cursor_detta7.GetString("PROVINCIA")))) {
          /* _attr := '00015' // Attributo */
          _attr = "00015";
          /* _dato := detta7->PROVINCIA // Dato */
          _dato = Cursor_detta7.GetString("PROVINCIA");
          /* Exec "Scrive Variabili per attributi e dati" Page 2:WriteVar */
          WriteVar();
          /* _contaatt := _contaatt + 1 */
          _contaatt = CPLib.Round(_contaatt+1,0);
        } // End If
        /* If not(Empty(detta7->STATO)) */
        if ( ! (CPLib.Empty(Cursor_detta7.GetString("STATO")))) {
          /* _attr := '00016' // Attributo */
          _attr = "00016";
          /* _dato := detta7->STATO // Dato */
          _dato = Cursor_detta7.GetString("STATO");
          /* Exec "Scrive Variabili per attributi e dati" Page 2:WriteVar */
          WriteVar();
          /* _contaatt := _contaatt + 1 */
          _contaatt = CPLib.Round(_contaatt+1,0);
        } // End If
        /* If not(Empty(detta7->VAL01217)) */
        if ( ! (CPLib.Empty(Cursor_detta7.GetString("VAL01217")))) {
          /* _attr := '01217' // Attributo */
          _attr = "01217";
          /* _dato := Right(LRTrim(detta7->VAL01217),3) // Dato */
          _dato = CPLib.Right(CPLib.LRTrim(Cursor_detta7.GetString("VAL01217")),3);
          /* Exec "Scrive Variabili per attributi e dati" Page 2:WriteVar */
          WriteVar();
          /* _contaatt := _contaatt + 1 */
          _contaatt = CPLib.Round(_contaatt+1,0);
        } // End If
        /* If not(Empty(detta7->VAL02147)) */
        if ( ! (CPLib.Empty(Cursor_detta7.GetString("VAL02147")))) {
          /* _attr := '02147' // Attributo */
          _attr = "02147";
          /* _dato := detta7->VAL02147 // Dato */
          _dato = Cursor_detta7.GetString("VAL02147");
          /* Exec "Scrive Variabili per attributi e dati" Page 2:WriteVar */
          WriteVar();
          /* _contaatt := _contaatt + 1 */
          _contaatt = CPLib.Round(_contaatt+1,0);
        } // End If
        /* If not(Empty(detta7->VAL02148)) */
        if ( ! (CPLib.Empty(Cursor_detta7.GetDate("VAL02148")))) {
          /* _attr := '02148' // Attributo */
          _attr = "02148";
          /* _dato := DateToChar(detta7->VAL02148) // Dato */
          _dato = CPLib.DateToChar(Cursor_detta7.GetDate("VAL02148"));
          /* Exec "Scrive Variabili per attributi e dati" Page 2:WriteVar */
          WriteVar();
          /* _contaatt := _contaatt + 1 */
          _contaatt = CPLib.Round(_contaatt+1,0);
        } // End If
        /* If not(Empty(detta7->VAL02149)) */
        if ( ! (CPLib.Empty(Cursor_detta7.GetString("VAL02149")))) {
          /* _attr := '02149' // Attributo */
          _attr = "02149";
          /* _dato := LRTrim(detta7->VAL02149) // Dato */
          _dato = CPLib.LRTrim(Cursor_detta7.GetString("VAL02149"));
          /* Exec "Scrive Variabili per attributi e dati" Page 2:WriteVar */
          WriteVar();
          /* _contaatt := _contaatt + 1 */
          _contaatt = CPLib.Round(_contaatt+1,0);
        } // End If
        /* mcA7.AppendBlank() */
        mcA7.AppendBlank();
        /* mcA7.IDFENOMENO := LRTrim(detta7->VOCE)+LRTrim(detta7->SOTTOVOCE) */
        mcA7.row.IDFENOMENO = CPLib.LRTrim(Cursor_detta7.GetString("VOCE"))+CPLib.LRTrim(Cursor_detta7.GetString("SOTTOVOCE"));
        /* mcA7.IMPORTO := detta7->IMPORTO * 100 */
        mcA7.row.IMPORTO = Cursor_detta7.GetDouble("IMPORTO")*100;
        /* mcA7.DURATA := '3' */
        mcA7.row.DURATA = "3";
        /* mcA7.DIVISA := '1' */
        mcA7.row.DIVISA = "1";
        /* mcA7.RESIDENZA := detta7->RESID */
        mcA7.row.RESIDENZA = Cursor_detta7.GetString("RESID");
        /* mcA7.ATTR0 := _attr0 */
        mcA7.row.ATTR0 = _attr0;
        /* mcA7.DATO0 := _dato0 */
        mcA7.row.DATO0 = _dato0;
        /* mcA7.ATTR1 := _attr1 */
        mcA7.row.ATTR1 = _attr1;
        /* mcA7.DATO1 := _dato1 */
        mcA7.row.DATO1 = _dato1;
        /* mcA7.ATTR2 := _attr2 */
        mcA7.row.ATTR2 = _attr2;
        /* mcA7.DATO2 := _dato2 */
        mcA7.row.DATO2 = _dato2;
        /* mcA7.ATTR3 := _attr3 */
        mcA7.row.ATTR3 = _attr3;
        /* mcA7.DATO3 := _dato3 */
        mcA7.row.DATO3 = _dato3;
        /* mcA7.ATTR4 := _attr4 */
        mcA7.row.ATTR4 = _attr4;
        /* mcA7.DATO4 := _dato4 */
        mcA7.row.DATO4 = _dato4;
        /* mcA7.ATTR5 := _attr5 */
        mcA7.row.ATTR5 = _attr5;
        /* mcA7.DATO5 := _dato5 */
        mcA7.row.DATO5 = _dato5;
        /* mcA7.ATTR6 := _attr6 */
        mcA7.row.ATTR6 = _attr6;
        /* mcA7.DATO6 := _dato6 */
        mcA7.row.DATO6 = _dato6;
        /* mcA7.SaveRow() */
        mcA7.SaveRow();
        Cursor_detta7.Next();
      }
      m_cConnectivityError = Cursor_detta7.ErrorMessage();
      Cursor_detta7.Close();
      // * --- End Select
      /* gMsgProc := gMsgProc + 'Sono state estratte: '+ Str(_righe,4,0) + NL */
      gMsgProc = gMsgProc+"Sono state estratte: "+CPLib.Str(_righe,4,0)+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* _filename := LRTrim(gAzienda)+"_"+LRTrim(pAnno)+"_"+pSem+".csv" */
      _filename = CPLib.LRTrim(gAzienda)+"_"+CPLib.LRTrim(pAnno)+"_"+pSem+".csv";
      /* _filepath := LRTrim(gPathDoc)+"/flussi/"+LRTrim(gAzienda)+"/"+LRTrim(_filename) */
      _filepath = CPLib.LRTrim(gPathDoc)+"/flussi/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_filename);
      /* _writer := Files.newBufferedWriter(Paths.get(_filepath)) */
      _writer = Files.newBufferedWriter(Paths.get(_filepath));
      /* _printer := new CSVPrinter(_writer,CSVFormat.EXCEL.withHeader("id_fenom","importo","durata","divisa","resid","attr0","dato0","attr1","dato1","attr2","dato2","attr3","dato4","attr4","dato4","attr5","dato5","attr6","dato6").withDelimiter(delimiter)) */
      _printer = new CSVPrinter(_writer,CSVFormat.EXCEL.withHeader("id_fenom","importo","durata","divisa","resid","attr0","dato0","attr1","dato1","attr2","dato2","attr3","dato4","attr4","dato4","attr5","dato5","attr6","dato6").withDelimiter(delimiter));
      for (MemoryCursorRow_mca7_mcrdef rwA7 : mcA7._iterable_()) {
        /* _printer.printRecord(rwA7.IDFENOMENO,LRTrim(Str(rwA7.IMPORTO,15,0)),rwA7.DURATA,rwA7.DIVISA,rwA7.RESIDENZA,rwA7.ATTR0,rwA7.DATO0,rwA7.ATTR1,rwA7.DATO1,rwA7.ATTR2,rwA7.DATO2,rwA7.ATTR3,rwA7.DATO3,rwA7.ATTR4,rwA7.DATO4,rwA7.ATTR5,rwA7.DATO5,rwA7.ATTR6,rwA7.DATO6) */
        _printer.printRecord(rwA7.IDFENOMENO,CPLib.LRTrim(CPLib.Str(rwA7.IMPORTO,15,0)),rwA7.DURATA,rwA7.DIVISA,rwA7.RESIDENZA,rwA7.ATTR0,rwA7.DATO0,rwA7.ATTR1,rwA7.DATO1,rwA7.ATTR2,rwA7.DATO2,rwA7.ATTR3,rwA7.DATO3,rwA7.ATTR4,rwA7.DATO4,rwA7.ATTR5,rwA7.DATO5,rwA7.ATTR6,rwA7.DATO6);
      }
      /* _printer.flush() */
      _printer.flush();
      /* gMsgImp := 'Elaborazione terminata!' // Messaggio Import */
      gMsgImp = "Elaborazione terminata!";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
      /* gMsgProc := gMsgProc + 'Ora Fine Processo: '+ arfn_fdatetime(DateTime()) */
      gMsgProc = gMsgProc+"Ora Fine Processo: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
      /* Return _filename */
      throw new Stop(_filename);
    } finally {
      try {
        if (Cursor_detta7!=null)
          Cursor_detta7.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void WriteVar() throws Exception {
    /* Case _contaatt=0 */
    if (CPLib.eqr(_contaatt,0)) {
      /* _attr0 := _attr // Attributo 0 */
      _attr0 = _attr;
      /* _dato0 := _dato // Dato 0 */
      _dato0 = _dato;
      /* Case _contaatt=1 */
    } else if (CPLib.eqr(_contaatt,1)) {
      /* _attr1 := _attr // Attributo 1 */
      _attr1 = _attr;
      /* _dato1 := _dato // Dato 1 */
      _dato1 = _dato;
      /* Case _contaatt=2 */
    } else if (CPLib.eqr(_contaatt,2)) {
      /* _attr2 := _attr // Attributo 2 */
      _attr2 = _attr;
      /* _dato2 := _dato // Dato 2 */
      _dato2 = _dato;
      /* Case _contaatt=3 */
    } else if (CPLib.eqr(_contaatt,3)) {
      /* _attr3 := _attr // Attributo 3 */
      _attr3 = _attr;
      /* _dato3 := _dato // Dato 3 */
      _dato3 = _dato;
      /* Case _contaatt=4 */
    } else if (CPLib.eqr(_contaatt,4)) {
      /* _attr4 := _attr // Attributo 4 */
      _attr4 = _attr;
      /* _dato4 := _dato // Dato 4 */
      _dato4 = _dato;
      /* Case _contaatt=5 */
    } else if (CPLib.eqr(_contaatt,5)) {
      /* _attr5 := _attr // Attributo 5 */
      _attr5 = _attr;
      /* _dato5 := _dato // Dato 5 */
      _dato5 = _dato;
      /* Case _contaatt=6 */
    } else if (CPLib.eqr(_contaatt,6)) {
      /* _attr6 := _attr // Attributo 6 */
      _attr6 = _attr;
      /* _dato6 := _dato // Dato 6 */
      _dato6 = _dato;
    } // End Case
  }
  void _init_() {
  }
  public String RunAsync(String p_pAnno,String p_pSem) {
    pAnno = p_pAnno;
    pSem = p_pSem;
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
  public String Run(String p_pAnno,String p_pSem) {
    pAnno = p_pAnno;
    pSem = p_pSem;
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
  public static arfn_estrai_sva7R Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_estrai_sva7R(p_Ctx, p_Caller);
  }
  public static arfn_estrai_sva7R Make(CPContext p_Ctx) {
    return new arfn_estrai_sva7R(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pAnno = CPLib.Space(4);
    pSem = CPLib.Space(1);
    mcA7 = new MemoryCursor_mca7_mcrdef();
    _contaatt = 0;
    _attr = CPLib.Space(0);
    _dato = CPLib.Space(0);
    _attr0 = CPLib.Space(0);
    _dato0 = CPLib.Space(0);
    _attr1 = CPLib.Space(0);
    _dato1 = CPLib.Space(0);
    _attr2 = CPLib.Space(0);
    _dato2 = CPLib.Space(0);
    _attr3 = CPLib.Space(0);
    _dato3 = CPLib.Space(0);
    _attr4 = CPLib.Space(0);
    _dato4 = CPLib.Space(0);
    _attr5 = CPLib.Space(0);
    _dato5 = CPLib.Space(0);
    _attr6 = CPLib.Space(0);
    _dato6 = CPLib.Space(0);
    _filename = CPLib.Space(0);
    _filepath = CPLib.Space(0);
    _righe = CPLib.Round(0,0);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_estrai_sva7,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_estrai_sva7,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"pAnno","pSem"};
}
