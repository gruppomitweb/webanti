// * --- Area Manuale = BO - Header
// * --- oprt_import_scheduled
// import java.nio.file.*;
import java.io.*;
import java.util.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.bouncycastle.jsse.util.CustomSSLSocketFactory;

// import javax.validation.constraints.NotNull;
import java.io.IOException;  
import java.net.MalformedURLException;  
import java.net.URL;
import org.apache.commons.mail.EmailAttachment;  
import org.apache.commons.mail.EmailException;  
import org.apache.commons.mail.HtmlEmail;
// * --- Fine Area Manuale
public class oprt_import_scheduledR implements CallerWithObjs {
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
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
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
  public MemoryCursor_tmp_list_imprich mcFile;
  public String _logmsg;
  public String _servermail;
  public String _usermail;
  public String _pwdmail;
  public String _origmail;
  public String _destmail;
  public boolean _sslmail;
  public String _csslmail;
  public double _portmail;
  public String _esito;
  public String _sendemail;
  public String _inviata;
  public String _pathimport;
  public String gIntemediario;
  public String gAzienda;
  public String gPathApp;
  public String gPathDoc;
  public String gMsgProc;
  // * --- Area Manuale = BO - Properties
  // * --- Fine Area Manuale
  public oprt_import_scheduledR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("oprt_import_scheduled",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_portmail",p_cVarName)) {
      return _portmail;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "oprt_import_scheduled";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("_logmsg",p_cVarName)) {
      return _logmsg;
    }
    if (CPLib.eqr("_servermail",p_cVarName)) {
      return _servermail;
    }
    if (CPLib.eqr("_usermail",p_cVarName)) {
      return _usermail;
    }
    if (CPLib.eqr("_pwdmail",p_cVarName)) {
      return _pwdmail;
    }
    if (CPLib.eqr("_origmail",p_cVarName)) {
      return _origmail;
    }
    if (CPLib.eqr("_destmail",p_cVarName)) {
      return _destmail;
    }
    if (CPLib.eqr("_csslmail",p_cVarName)) {
      return _csslmail;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      return _esito;
    }
    if (CPLib.eqr("_sendemail",p_cVarName)) {
      return _sendemail;
    }
    if (CPLib.eqr("_inviata",p_cVarName)) {
      return _inviata;
    }
    if (CPLib.eqr("_pathimport",p_cVarName)) {
      return _pathimport;
    }
    if (CPLib.eqr("gIntemediario",p_cVarName)) {
      return gIntemediario;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
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
    if (CPLib.eqr("_sslmail",p_cVarName)) {
      return _sslmail;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcFile",p_cVarName)) {
      return mcFile;
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
    if (CPLib.eqr("_portmail",p_cVarName)) {
      _portmail = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("_logmsg",p_cVarName)) {
      _logmsg = value;
      return;
    }
    if (CPLib.eqr("_servermail",p_cVarName)) {
      _servermail = value;
      return;
    }
    if (CPLib.eqr("_usermail",p_cVarName)) {
      _usermail = value;
      return;
    }
    if (CPLib.eqr("_pwdmail",p_cVarName)) {
      _pwdmail = value;
      return;
    }
    if (CPLib.eqr("_origmail",p_cVarName)) {
      _origmail = value;
      return;
    }
    if (CPLib.eqr("_destmail",p_cVarName)) {
      _destmail = value;
      return;
    }
    if (CPLib.eqr("_csslmail",p_cVarName)) {
      _csslmail = value;
      return;
    }
    if (CPLib.eqr("_esito",p_cVarName)) {
      _esito = value;
      return;
    }
    if (CPLib.eqr("_sendemail",p_cVarName)) {
      _sendemail = value;
      return;
    }
    if (CPLib.eqr("_inviata",p_cVarName)) {
      _inviata = value;
      return;
    }
    if (CPLib.eqr("_pathimport",p_cVarName)) {
      _pathimport = value;
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
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      gPathApp = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      gMsgProc = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
    if (CPLib.eqr("_sslmail",p_cVarName)) {
      _sslmail = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcFile",p_cVarName)) {
      mcFile = (MemoryCursor_tmp_list_imprich)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* mcFile MemoryCursor(tmp_list_imprich) */
      /* _logmsg Memo */
      /* _servermail Char(0) */
      /* _usermail Char(0) */
      /* _pwdmail Char(0) */
      /* _origmail Char(0) */
      /* _destmail Char(0) */
      /* _sslmail Bool */
      /* _csslmail Char(0) */
      /* _portmail Numeric(3, 0) */
      /* _esito Char(0) */
      /* _sendemail Char(0) */
      /* _inviata Char(1) */
      /* _pathimport Char(0) */
      /* gIntemediario Char(11) // Intermediario */
      /* gAzienda Char(10) // Azienda */
      /* gPathApp Char(80) // Path Applicazione */
      /* gPathDoc Char(80) // Path Applicazione */
      /* gMsgProc Char(80) // Path Applicazione */
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _servermail := LRTrim(intermbo->ALTSRVMAIL) */
        _servermail = CPLib.LRTrim(Cursor_intermbo.GetString("ALTSRVMAIL"));
        /* _usermail := LRTrim(intermbo->ALTUSRMAIL) */
        _usermail = CPLib.LRTrim(Cursor_intermbo.GetString("ALTUSRMAIL"));
        /* _pwdmail := LRTrim(intermbo->ALTPWDMAIL) */
        _pwdmail = CPLib.LRTrim(Cursor_intermbo.GetString("ALTPWDMAIL"));
        /* _origmail := LRTrim(intermbo->ALTEMLMAIL) */
        _origmail = CPLib.LRTrim(Cursor_intermbo.GetString("ALTEMLMAIL"));
        /* _destmail := LRTrim(intermbo->DESTEMAIL) */
        _destmail = CPLib.LRTrim(Cursor_intermbo.GetString("DESTEMAIL"));
        /* _sslmail := iif(intermbo->ALTSSLEMAIL='S',True,False) */
        _sslmail = (CPLib.eqr(Cursor_intermbo.GetString("ALTSSLEMAIL"),"S")?true:false);
        /* _csslmail := iif(intermbo->ALTSSLEMAIL='S',"true","false") */
        _csslmail = (CPLib.eqr(Cursor_intermbo.GetString("ALTSSLEMAIL"),"S")?"true":"false");
        /* _portmail := Val(intermbo->ALTPRTMAIL) */
        _portmail = CPLib.Round(CPLib.Val(Cursor_intermbo.GetString("ALTPRTMAIL")),0);
        /* _pathimport := LRTrim(intermbo->PATHIMPORT) */
        _pathimport = CPLib.LRTrim(Cursor_intermbo.GetString("PATHIMPORT"));
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      // Legge i file degli esiti
      File di = new File(CPLib.LRTrim(_pathimport));
      File f[] = di.listFiles();
      int _i;
      int count=0;
      for (_i=0; _i < f.length; _i++)  {
      /* If f[_i].getName().startsWith("Prestazioni") */
      if (f[_i].getName().startsWith("Prestazioni")) {
        /* mcFile.AppendBlank() */
        mcFile.AppendBlank();
        /* mcFile.nomefile := f[_i].getName().toString() */
        mcFile.row.nomefile = f[_i].getName().toString();
        /* mcFile.priorita := 1 */
        mcFile.row.priorita = 1;
        /* mcFile.SaveRow() */
        mcFile.SaveRow();
      } // End If
      /* If f[_i].getName().startsWith("Contanti") */
      if (f[_i].getName().startsWith("Contanti")) {
        /* mcFile.AppendBlank() */
        mcFile.AppendBlank();
        /* mcFile.nomefile := f[_i].getName().toString() */
        mcFile.row.nomefile = f[_i].getName().toString();
        /* mcFile.priorita := 2 */
        mcFile.row.priorita = 2;
        /* mcFile.SaveRow() */
        mcFile.SaveRow();
      } // End If
      // Chiude il ciclo
      }
      /* If mcFile.RecCount() > 0 */
      if (CPLib.gt(mcFile.RecCount(),0)) {
        MemoryCursor_tmp_list_imprich cpmc_00000030;
        cpmc_00000030 = new MemoryCursor_tmp_list_imprich();
        for (MemoryCursorRow_tmp_list_imprich rwFile : mcFile._iterable_()) {
          cpmc_00000030.Append(rwFile);
        }
        for (MemoryCursorRow_tmp_list_imprich rwFile : cpmc_00000030._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_tmp_list_imprich>(){  public int compare(MemoryCursorRow_tmp_list_imprich r1,MemoryCursorRow_tmp_list_imprich r2){    if (CPLib.gt(r1.priorita,r2.priorita)) return 1;    if (CPLib.lt(r1.priorita,r2.priorita)) return -1;    return 0;  }})) {
          /* FileLibMit.MoveFile(LRTrim(_pathimport)+"//"+LRTrim(rwFile.nomefile),LRTrim(gPathApp)+"/appo/"+LRTrim(gAzienda)+"/"+LRTrim(rwFile.nomefile)) */
          FileLibMit.MoveFile(CPLib.LRTrim(_pathimport)+"//"+CPLib.LRTrim(rwFile.nomefile),CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(rwFile.nomefile));
          /* If At("Prestazioni",rwFile.nomefile) <> 0 */
          if (CPLib.ne(CPLib.At("Prestazioni",rwFile.nomefile),0)) {
            /* _logmsg := _logmsg + opert_imp_dati(rwFile.nomefile,"P","O","C","","S") */
            _logmsg = _logmsg+opert_imp_datiR.Make(m_Ctx,this).Run(rwFile.nomefile,"P","O","C","","S");
          } else { // Else
            /* _logmsg := _logmsg + opert_imp_dati(rwFile.nomefile,"P","C","C","","S") */
            _logmsg = _logmsg+opert_imp_datiR.Make(m_Ctx,this).Run(rwFile.nomefile,"P","C","C","","S");
          } // End If
        }
      } else { // Else
        /* _logmsg := "Non sono stati trovati file da importare" */
        _logmsg = "Non sono stati trovati file da importare";
      } // End If
      try {
         // Inizializza le proprietà per la connessione 
         Properties props = System.getProperties();   
         props.setProperty("mail.smtp.ssl.enable", _csslmail);  
         props.setProperty("mail.smtp.ssl.socketFactory.class", CustomSSLSocketFactory.class.getName());  
         props.setProperty("mail.smtp.ssl.socketFactory.fallback", "false");
      
         // Prepara l'email
         HtmlEmail email = new HtmlEmail();
         email.setAuthentication(_usermail,_pwdmail);
         email.setHostName(_servermail);
         email.setSmtpPort((int)_portmail);
         email.setSSL(_sslmail); 
      
         email.setFrom(_origmail);
         email.setHtmlMsg(_logmsg);
         email.setSubject("Esito Import Schedulato");
         email.addTo(_destmail);
         email.send();
      
      //Chiude l'invio
      } catch (EmailException e) {
         _sendemail = e.getMessage() + " "+ e.getCause();
         _inviata = "N";
      }
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
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static oprt_import_scheduledR Make(CPContext p_Ctx, Caller p_Caller) {
    return new oprt_import_scheduledR(p_Ctx, p_Caller);
  }
  public void Blank() {
    mcFile = new MemoryCursor_tmp_list_imprich();
    _logmsg = "";
    _servermail = CPLib.Space(0);
    _usermail = CPLib.Space(0);
    _pwdmail = CPLib.Space(0);
    _origmail = CPLib.Space(0);
    _destmail = CPLib.Space(0);
    _sslmail = false;
    _csslmail = CPLib.Space(0);
    _portmail = 0;
    _esito = CPLib.Space(0);
    _sendemail = CPLib.Space(0);
    _inviata = CPLib.Space(1);
    _pathimport = CPLib.Space(0);
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,opert_imp_dati,
  public static final String i_InvokedRoutines = ",opert_imp_dati,";
  public static String[] m_cRunParameterNames={};
}
