// * --- Area Manuale = BO - Header
// * --- fn_fileread
//import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.List;
// * --- Fine Area Manuale
public class fn_filereadR implements CallerWithObjs {
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
  public String dir;
  public double level;
  public String filtro;
  public String estenzione;
  public String fileName;
  // * --- Area Manuale = BO - Properties
  // * --- fn_fileread
  List<Path> result;
  // * --- Fine Area Manuale
  public fn_filereadR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("fn_fileread",m_Caller);
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("level",p_cVarName)) {
      return level;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "fn_fileread";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("dir",p_cVarName)) {
      return dir;
    }
    if (CPLib.eqr("filtro",p_cVarName)) {
      return filtro;
    }
    if (CPLib.eqr("estenzione",p_cVarName)) {
      return estenzione;
    }
    if (CPLib.eqr("fileName",p_cVarName)) {
      return fileName;
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
    if (CPLib.eqr("level",p_cVarName)) {
      level = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("dir",p_cVarName)) {
      dir = value;
      return;
    }
    if (CPLib.eqr("filtro",p_cVarName)) {
      filtro = value;
      return;
    }
    if (CPLib.eqr("estenzione",p_cVarName)) {
      estenzione = value;
      return;
    }
    if (CPLib.eqr("fileName",p_cVarName)) {
      fileName = value;
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
    /* dir Char(0) // Cartella dei file */
    /* level Numeric(0, 0) // livello delle cartelle da leggere (se -1 legge tutti i livelli) */
    /* filtro Char(0) // Tipo di dati ritornati (F lista dei file, D lista delle cartelle, A tutto) */
    /* estenzione Char(0) // estenzione dei file (.txt per i soli file txt, lasciare vuoto per tutte le tipologie) */
    /* fileName Char(0) // nome esatto del file da tornare */
    /* mcfileread MemoryCursor(mcElencoFile.MCRDef) // Mc dei file letti */
    MemoryCursor_mcelencofile_mcrdef mcfileread;
    mcfileread = new MemoryCursor_mcelencofile_mcrdef();
    /* fileletto Char(0) := '' // file letto */
    String fileletto;
    fileletto = "";
    /* pathletta Char(0) := '' // percorso letto */
    String pathletta;
    pathletta = "";
    /* isdirectory Bool := True // percorso letto */
    boolean isdirectory;
    isdirectory = true;
    try (Stream<Path> paths = level>-1?Files.walk(Paths.get(dir),(int) level):Files.walk(Paths.get(dir))) {
    /* If not(Empty(fileName)) */
    if ( ! (CPLib.Empty(fileName))) {
      /* Prende solo il file passato come parametro */
          result = paths.filter(Files::isReadable)      // read permission
                        .filter(Files::isRegularFile)   // is a file
                        .filter(p -> p.getFileName().toString().equalsIgnoreCase(fileName))
                        .collect(Collectors.toList());
    } else { // Else
      /* Case filtro='F' */
      if (CPLib.eqr(filtro,"F")) {
        /* Prende solo i file */
        result = paths.filter(Files::isRegularFile)
                 .collect(Collectors.toList());
        
        /* Case filtro='D' */
      } else if (CPLib.eqr(filtro,"D")) {
        /* Prende solo le cartelle */
            result = paths.filter(Files::isDirectory)
                 .collect(Collectors.toList());
        /* Case filtro='A' */
      } else if (CPLib.eqr(filtro,"A")) {
        /* Prende sia file che cartelle */
        result = paths.collect(Collectors.toList());
      } // End Case
    } // End If
    }
     for(Path elemento:result){
    //System.out.println(elemento);
    pathletta=elemento.toString();
    isdirectory=elemento.toFile().isDirectory();
    fileletto=isdirectory?"":elemento.getFileName().toString();
    /* In caso di filtro sull'estenzione verifica se il file a quell'estenzione prima di scriverlo ne mc */
    /* If Empty(estenzione) or (not(Empty(estenzione)) and elemento.getFileName().toString().endsWith(estenzione)) */
    if (CPLib.Empty(estenzione) || ( ! (CPLib.Empty(estenzione)) && elemento.getFileName().toString().endsWith(estenzione))) {
      /* mcfileread.AppendBlank() // Mc dei file letti */
      mcfileread.AppendBlank();
      /* mcfileread.Path := pathletta // Mc dei file letti */
      mcfileread.row.Path = pathletta;
      /* mcfileread.File := fileletto // Mc dei file letti */
      mcfileread.row.File = fileletto;
      /* mcfileread.Directory := isdirectory // Mc dei file letti */
      mcfileread.row.Directory = isdirectory;
      /* mcfileread.SaveRow() // Mc dei file letti */
      mcfileread.SaveRow();
    } // End If
    //fine lettura cartelle
           }
    /* Return mcfileread */
    throw new Stop(mcfileread);
  }
  void _init_() {
  }
  public String RunAsync(String p_dir,double p_level,String p_filtro,String p_estenzione,String p_fileName) {
    dir = p_dir;
    level = p_level;
    filtro = p_filtro;
    estenzione = p_estenzione;
    fileName = p_fileName;
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
  public MemoryCursor_mcelencofile_mcrdef Run(String p_dir,double p_level,String p_filtro,String p_estenzione,String p_fileName) {
    dir = p_dir;
    level = p_level;
    filtro = p_filtro;
    estenzione = p_estenzione;
    fileName = p_fileName;
    return Run();
  }
  public MemoryCursor_mcelencofile_mcrdef Run() {
    MemoryCursor_mcelencofile_mcrdef l_result;
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
        l_result = (MemoryCursor_mcelencofile_mcrdef)stop_value.GetObject();
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
  public static fn_filereadR Make(CPContext p_Ctx, Caller p_Caller) {
    return new fn_filereadR(p_Ctx, p_Caller);
  }
  public static fn_filereadR Make(CPContext p_Ctx) {
    return new fn_filereadR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    dir = CPLib.Space(0);
    level = 0;
    filtro = CPLib.Space(0);
    estenzione = CPLib.Space(0);
    fileName = CPLib.Space(0);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,fn_fileread,
  public static final String i_InvokedRoutines = ",fn_fileread,";
  public static String[] m_cRunParameterNames={"dir","level","filtro","estenzione","fileName"};
}
