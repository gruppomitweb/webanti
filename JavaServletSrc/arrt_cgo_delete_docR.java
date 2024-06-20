// * --- Area Manuale = BO - Header
// * --- arrt_cgo_delete_doc
import com.openkm.sdk4j.OKMWebservices;
import com.openkm.sdk4j.OKMWebservicesFactory;
import com.openkm.sdk4j.bean.Folder;
import com.openkm.sdk4j.bean.Document;
import com.openkm.sdk4j.bean.*;
import com.openkm.sdk4j.exception.*;
import java.util.*;
import java.io.*;
import org.apache.commons.io.*;
import com.openkm.ws.client.auth.OKMAuth;
import com.openkm.ws.client.auth.OKMAuth_Service;
import com.openkm.ws.client.document.OKMDocument;
import com.openkm.ws.client.document.OKMDocument_Service;
import com.openkm.ws.client.folder.OKMFolder;
import com.openkm.ws.client.folder.OKMFolder_Service;
import javax.xml.namespace.QName;
import java.net.URL;
import java.nio.file.*;
import javax.activation.*;
// * --- Fine Area Manuale
public class arrt_cgo_delete_docR implements CallerWithObjs {
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
  public String m_cPhName_cgo_docope;
  public String m_cServer_cgo_docope;
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
  public String pIDDOC;
  public String pSaved;
  public String pStato;
  public String _pdest;
  public String _olddoc;
  public String host;
  public String user;
  public String password;
  public String xDoc0;
  public String xDoc1;
  public String xDoc2;
  public String xDoc3;
  public String xDoc4;
  public String xDoc5;
  public String xDoc6;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_cgo_delete_doc
  private static QName AuthServiceName = new QName("http://ws.openkm.com", "OKMAuth");
  private static QName DocumentServiceName = new QName("http://ws.openkm.com", "OKMDocument");
  private static QName FolderServiceName = new QName("http://ws.openkm.com", "OKMFolder");
  
  public OKMAuth_Service authService = null;
  public OKMDocument_Service documentService = null;
  public OKMAuth okmAuth = null;
  public OKMDocument okmDocument = null;
  public OKMFolder_Service folderService = null;
  public OKMFolder okmFolder = null;
  // * --- Fine Area Manuale
  public arrt_cgo_delete_docR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_cgo_delete_doc",m_Caller);
    m_cPhName_cgo_docope = p_ContextObject.GetPhName("cgo_docope");
    if (m_cPhName_cgo_docope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_docope = m_cPhName_cgo_docope+" "+m_Ctx.GetWritePhName("cgo_docope");
    }
    m_cServer_cgo_docope = p_ContextObject.GetServer("cgo_docope");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_cgo_delete_doc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("pIDDOC",p_cVarName)) {
      return pIDDOC;
    }
    if (CPLib.eqr("pSaved",p_cVarName)) {
      return pSaved;
    }
    if (CPLib.eqr("pStato",p_cVarName)) {
      return pStato;
    }
    if (CPLib.eqr("_pdest",p_cVarName)) {
      return _pdest;
    }
    if (CPLib.eqr("_olddoc",p_cVarName)) {
      return _olddoc;
    }
    if (CPLib.eqr("host",p_cVarName)) {
      return host;
    }
    if (CPLib.eqr("user",p_cVarName)) {
      return user;
    }
    if (CPLib.eqr("password",p_cVarName)) {
      return password;
    }
    if (CPLib.eqr("xDoc0",p_cVarName)) {
      return xDoc0;
    }
    if (CPLib.eqr("xDoc1",p_cVarName)) {
      return xDoc1;
    }
    if (CPLib.eqr("xDoc2",p_cVarName)) {
      return xDoc2;
    }
    if (CPLib.eqr("xDoc3",p_cVarName)) {
      return xDoc3;
    }
    if (CPLib.eqr("xDoc4",p_cVarName)) {
      return xDoc4;
    }
    if (CPLib.eqr("xDoc5",p_cVarName)) {
      return xDoc5;
    }
    if (CPLib.eqr("xDoc6",p_cVarName)) {
      return xDoc6;
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
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pIDDOC",p_cVarName)) {
      pIDDOC = value;
      return;
    }
    if (CPLib.eqr("pSaved",p_cVarName)) {
      pSaved = value;
      return;
    }
    if (CPLib.eqr("pStato",p_cVarName)) {
      pStato = value;
      return;
    }
    if (CPLib.eqr("_pdest",p_cVarName)) {
      _pdest = value;
      return;
    }
    if (CPLib.eqr("_olddoc",p_cVarName)) {
      _olddoc = value;
      return;
    }
    if (CPLib.eqr("host",p_cVarName)) {
      host = value;
      return;
    }
    if (CPLib.eqr("user",p_cVarName)) {
      user = value;
      return;
    }
    if (CPLib.eqr("password",p_cVarName)) {
      password = value;
      return;
    }
    if (CPLib.eqr("xDoc0",p_cVarName)) {
      xDoc0 = value;
      return;
    }
    if (CPLib.eqr("xDoc1",p_cVarName)) {
      xDoc1 = value;
      return;
    }
    if (CPLib.eqr("xDoc2",p_cVarName)) {
      xDoc2 = value;
      return;
    }
    if (CPLib.eqr("xDoc3",p_cVarName)) {
      xDoc3 = value;
      return;
    }
    if (CPLib.eqr("xDoc4",p_cVarName)) {
      xDoc4 = value;
      return;
    }
    if (CPLib.eqr("xDoc5",p_cVarName)) {
      xDoc5 = value;
      return;
    }
    if (CPLib.eqr("xDoc6",p_cVarName)) {
      xDoc6 = value;
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
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_cgo_docope=null;
    CPResultSet Read_Cursor=null;
    try {
      /* pIDDOC Char(36) // ID Documentazione */
      /* pSaved Char(1) // Stato Salvataggio Documenti */
      /* pStato Char(1) // N=New, E=Edit */
      /* _pdest Char(120) */
      /* _olddoc Char(120) */
      /* host Char(100) */
      /* user Char(100) */
      /* password Char(100) */
      /* xDoc0 Char(1) */
      /* xDoc1 Char(1) */
      /* xDoc2 Char(1) */
      /* xDoc3 Char(1) */
      /* xDoc4 Char(1) */
      /* xDoc5 Char(1) */
      /* xDoc6 Char(1) */
      /* If pSaved='S' */
      if (CPLib.eqr(pSaved,"S")) {
        // * --- Select from intermbo
        m_cServer = m_Ctx.GetServer("intermbo");
        m_cPhName = m_Ctx.GetPhName("intermbo");
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
        Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
        while ( ! (Cursor_intermbo.Eof())) {
          /* host := LRTrim(intermbo->URLDESDOC) */
          host = CPLib.LRTrim(Cursor_intermbo.GetString("URLDESDOC"));
          /* user := LRTrim(intermbo->USRGESDOC) */
          user = CPLib.LRTrim(Cursor_intermbo.GetString("USRGESDOC"));
          /* password := LRTrim(intermbo->PWDGESDOC) */
          password = CPLib.LRTrim(Cursor_intermbo.GetString("PWDGESDOC"));
          Cursor_intermbo.Next();
        }
        m_cConnectivityError = Cursor_intermbo.ErrorMessage();
        Cursor_intermbo.Close();
        // * --- End Select
        //
        // Ripulisce directory utente
        //File _directory=new File(CPLib.LRTrim(_pathout));
        //FileUtils.cleanDirectory(_directory);
        // Autentica in OpenKM
        authService = new OKMAuth_Service(new URL(host + "/services/OKMAuth?wsdl"), AuthServiceName);
        documentService = new OKMDocument_Service(new URL(host + "/services/OKMDocument?wsdl"), DocumentServiceName);
        folderService = new OKMFolder_Service(new URL(host + "/services/OKMFolder?wsdl"), FolderServiceName);
        okmAuth = authService.getOKMAuthPort();
        okmDocument = documentService.getOKMDocumentPort();
        okmFolder = folderService.getOKMFolderPort();
        // Login
        String token = okmAuth.login(user, password);
        //Collegamento a OpenKM
        OKMWebservices okm= OKMWebservicesFactory.newInstance(host, user, password);
        /* _pdest := "/okm:root/"+LRTrim(pIDDOC) */
        _pdest = "/okm:root/"+CPLib.LRTrim(pIDDOC);
        /* If pStato='N' */
        if (CPLib.eqr(pStato,"N")) {
          // * --- Select from cgo_docope
          m_cServer = m_Ctx.GetServer("cgo_docope");
          m_cPhName = m_Ctx.GetPhName("cgo_docope");
          if (Cursor_cgo_docope!=null)
            Cursor_cgo_docope.Close();
          Cursor_cgo_docope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer, m_oParameters),m_cServer,pIDDOC)+" "+")"+(m_Ctx.IsSharedTemp("cgo_docope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_docope.Eof())) {
            /* If not(Empty(cgo_docope->DCDOCUNICO)) */
            if ( ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCUNICO")))) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCUNICO) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCUNICO"));
              // Cancella il vecchio file
              okmDocument.delete(token,_olddoc);
            } else { // Else
              /* If not(Empty(cgo_docope->DCDOCNOM1)) */
              if ( ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM1")))) {
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM1) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM1"));
                // Cancella il vecchio file
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cgo_docope->DCDOCNOM2)) */
              if ( ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM2")))) {
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM2) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM2"));
                // Cancella il vecchio file
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cgo_docope->DCDOCNOM3)) */
              if ( ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM3")))) {
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM3) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM3"));
                // Cancella il vecchio file
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cgo_docope->DCDOCNOM4)) */
              if ( ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM4")))) {
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM4) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM4"));
                // Cancella il vecchio file
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cgo_docope->DCDOCNOM5)) */
              if ( ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM5")))) {
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM5) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM5"));
                // Cancella il vecchio file
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cgo_docope->DCDOCNOM6)) */
              if ( ! (CPLib.Empty(Cursor_cgo_docope.GetString("DCDOCNOM6")))) {
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM6) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM6"));
                // Cancella il vecchio file
                okmDocument.delete(token,_olddoc);
              } // End If
            } // End If
            // Cancella la cartella
            okmFolder.delete(token,_pdest);
            // * --- Delete from cgo_docope
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_docope");
            m_cPhName = m_Ctx.GetPhName("cgo_docope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_delete_doc",12,"00000034")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
            Cursor_cgo_docope.Next();
          }
          m_cConnectivityError = Cursor_cgo_docope.ErrorMessage();
          Cursor_cgo_docope.Close();
          // * --- End Select
        } // End If
        /* If pStato='E' */
        if (CPLib.eqr(pStato,"E")) {
          // * --- Select from cgo_docope
          m_cServer = m_Ctx.GetServer("cgo_docope");
          m_cPhName = m_Ctx.GetPhName("cgo_docope");
          if (Cursor_cgo_docope!=null)
            Cursor_cgo_docope.Close();
          Cursor_cgo_docope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer, m_oParameters),m_cServer,pIDDOC)+" "+")"+(m_Ctx.IsSharedTemp("cgo_docope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_docope.Eof())) {
            /* If cgo_docope->DCDOCNEW0='X' */
            if (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW0"),"X")) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCUNICO) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCUNICO"));
              // Cancella il vecchio file
              okmDocument.delete(token,_olddoc);
              // * --- Write into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_delete_doc",12,"0000003A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DCDOCNEW0 = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCUNICO = "+CPLib.ToSQL("","C",80,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
            /* If cgo_docope->DCDOCNEW1='X' */
            if (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW1"),"X")) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM1) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM1"));
              // Cancella il vecchio file
              okmDocument.delete(token,_olddoc);
              // * --- Write into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_delete_doc",12,"0000003E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DCDOCNEW1 = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM1 = "+CPLib.ToSQL("","C",80,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
            /* If cgo_docope->DCDOCNEW2='X' */
            if (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW2"),"X")) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM2) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM2"));
              // Cancella il vecchio file
              okmDocument.delete(token,_olddoc);
              // * --- Write into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_delete_doc",12,"00000042")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DCDOCNEW2 = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM2 = "+CPLib.ToSQL("","C",80,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
            /* If cgo_docope->DCDOCNEW3='X' */
            if (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW3"),"X")) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM3) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM3"));
              // Cancella il vecchio file
              okmDocument.delete(token,_olddoc);
              // * --- Write into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_delete_doc",12,"00000046")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DCDOCNEW3 = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM3 = "+CPLib.ToSQL("","C",80,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
            /* If cgo_docope->DCDOCNEW4='X' */
            if (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW4"),"X")) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM4) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM4"));
              // Cancella il vecchio file
              okmDocument.delete(token,_olddoc);
              // * --- Write into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_delete_doc",12,"0000004A")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DCDOCNEW4 = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM4 = "+CPLib.ToSQL("","C",80,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
            /* If cgo_docope->DCDOCNEW5='X' */
            if (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW5"),"X")) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM5) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM5"));
              // Cancella il vecchio file
              okmDocument.delete(token,_olddoc);
              // * --- Write into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_delete_doc",12,"0000004E")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DCDOCNEW5 = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM5 = "+CPLib.ToSQL("","C",80,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
            /* If cgo_docope->DCDOCNEW6='X' */
            if (CPLib.eqr(Cursor_cgo_docope.GetString("DCDOCNEW6"),"X")) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cgo_docope->DCDOCNOM6) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(Cursor_cgo_docope.GetString("DCDOCNOM6"));
              // Cancella il vecchio file
              okmDocument.delete(token,_olddoc);
              // * --- Write into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_delete_doc",12,"00000052")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DCDOCNEW6 = "+CPLib.ToSQL("N","C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM6 = "+CPLib.ToSQL("","C",80,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
            /* xDoc0 := '' */
            xDoc0 = "";
            /* xDoc1 := '' */
            xDoc1 = "";
            /* xDoc2 := '' */
            xDoc2 = "";
            /* xDoc3 := '' */
            xDoc3 = "";
            /* xDoc4 := '' */
            xDoc4 = "";
            /* xDoc5 := '' */
            xDoc5 = "";
            /* xDoc6 := '' */
            xDoc6 = "";
            // * --- Read from cgo_docope
            m_cServer = m_Ctx.GetServer("cgo_docope");
            m_cPhName = m_Ctx.GetPhName("cgo_docope");
            m_cSql = "";
            m_cSql = m_cSql+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"C",36,0,m_cServer),m_cServer,pIDDOC);
            if (m_Ctx.IsSharedTemp("cgo_docope")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DCDOCNEW0",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNEW1",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNEW2",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNEW3",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNEW4",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNEW5",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNEW6",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              xDoc0 = Read_Cursor.GetString("DCDOCNEW0");
              xDoc1 = Read_Cursor.GetString("DCDOCNEW1");
              xDoc2 = Read_Cursor.GetString("DCDOCNEW2");
              xDoc3 = Read_Cursor.GetString("DCDOCNEW3");
              xDoc4 = Read_Cursor.GetString("DCDOCNEW4");
              xDoc5 = Read_Cursor.GetString("DCDOCNEW5");
              xDoc6 = Read_Cursor.GetString("DCDOCNEW6");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cgo_docope into routine arrt_cgo_delete_doc returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              xDoc0 = "";
              xDoc1 = "";
              xDoc2 = "";
              xDoc3 = "";
              xDoc4 = "";
              xDoc5 = "";
              xDoc6 = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If At('S',xDoc0+xDoc1+xDoc2+xDoc3+xDoc4+xDoc5+xDoc6)=0 */
            if (CPLib.eqr(CPLib.At("S",xDoc0+xDoc1+xDoc2+xDoc3+xDoc4+xDoc5+xDoc6),0)) {
              // Cancella la cartella
              okmFolder.delete(token,_pdest);
              // * --- Delete from cgo_docope
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_cgo_delete_doc",12,"0000005D")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer),m_cServer,pIDDOC)+"";
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
            Cursor_cgo_docope.Next();
          }
          m_cConnectivityError = Cursor_cgo_docope.ErrorMessage();
          Cursor_cgo_docope.Close();
          // * --- End Select
        } // End If
      } // End If
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
      try {
        if (Cursor_cgo_docope!=null)
          Cursor_cgo_docope.Close();
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
    }
  }
  void _init_() {
  }
  public String RunAsync(String p_pIDDOC,String p_pSaved,String p_pStato) {
    pIDDOC = p_pIDDOC;
    pSaved = p_pSaved;
    pStato = p_pStato;
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
  public Forward Run(String p_pIDDOC,String p_pSaved,String p_pStato) {
    pIDDOC = p_pIDDOC;
    pSaved = p_pSaved;
    pStato = p_pStato;
    return Run();
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
  public static arrt_cgo_delete_docR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_cgo_delete_docR(p_Ctx, p_Caller);
  }
  public void Blank() {
    pIDDOC = CPLib.Space(36);
    pSaved = CPLib.Space(1);
    pStato = CPLib.Space(1);
    _pdest = CPLib.Space(120);
    _olddoc = CPLib.Space(120);
    host = CPLib.Space(100);
    user = CPLib.Space(100);
    password = CPLib.Space(100);
    xDoc0 = CPLib.Space(1);
    xDoc1 = CPLib.Space(1);
    xDoc2 = CPLib.Space(1);
    xDoc3 = CPLib.Space(1);
    xDoc4 = CPLib.Space(1);
    xDoc5 = CPLib.Space(1);
    xDoc6 = CPLib.Space(1);
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,
  public static final String i_InvokedRoutines = ",";
  public static String[] m_cRunParameterNames={"pIDDOC","pSaved","pStato"};
}
