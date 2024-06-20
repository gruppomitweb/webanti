// * --- Area Manuale = BO - Header
// * --- arfn_cgo_delete_ope
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
public class arfn_cgo_delete_opeR implements CallerWithObjs {
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
  public String m_cPhName_cgo_operazioni_dl;
  public String m_cServer_cgo_operazioni_dl;
  public String m_cPhName_cgo_operazioni_dl_multi_dt;
  public String m_cServer_cgo_operazioni_dl_multi_dt;
  public String m_cPhName_cgo_operazioni_dl_multi;
  public String m_cServer_cgo_operazioni_dl_multi;
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
  public String pOpe;
  public String pTipo;
  public String pIDDOC;
  public String pCodDip;
  public String gAzienda;
  public String gPathDoc;
  public String cRitorno;
  public String _pdest;
  public String _olddoc;
  public String host;
  public String user;
  public String password;
  public double _trovato;
  public String cOldUnico;
  public String cOldDoc1;
  public String cOldDoc2;
  public String cOldDoc3;
  public String cOldDoc4;
  public String cOldDoc5;
  public String cOldDoc6;
  public double _folder;
  public String _okm;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_cgo_delete_ope
  private static QName AuthServiceName = new QName("http://ws.openkm.com", "OKMAuth");
  private static QName DocumentServiceName = new QName("http://ws.openkm.com", "OKMDocument");
  private static QName FolderServiceName = new QName("http://ws.openkm.com", "OKMFolder");
  
  public OKMAuth_Service authService = null;
  public OKMDocument_Service documentService = null;
  public OKMAuth okmAuth = null;
  public OKMDocument okmDocument = null;
  public OKMFolder_Service folderService = null;
  public OKMFolder okmFolder = null;
  public String token;
  // * --- Fine Area Manuale
  public arfn_cgo_delete_opeR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_cgo_delete_ope",m_Caller);
    m_cPhName_cgo_operazioni_dl = p_ContextObject.GetPhName("cgo_operazioni_dl");
    if (m_cPhName_cgo_operazioni_dl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl = m_cPhName_cgo_operazioni_dl+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl");
    }
    m_cServer_cgo_operazioni_dl = p_ContextObject.GetServer("cgo_operazioni_dl");
    m_cPhName_cgo_operazioni_dl_multi_dt = p_ContextObject.GetPhName("cgo_operazioni_dl_multi_dt");
    if (m_cPhName_cgo_operazioni_dl_multi_dt.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi_dt = m_cPhName_cgo_operazioni_dl_multi_dt+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi_dt");
    }
    m_cServer_cgo_operazioni_dl_multi_dt = p_ContextObject.GetServer("cgo_operazioni_dl_multi_dt");
    m_cPhName_cgo_operazioni_dl_multi = p_ContextObject.GetPhName("cgo_operazioni_dl_multi");
    if (m_cPhName_cgo_operazioni_dl_multi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi = m_cPhName_cgo_operazioni_dl_multi+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi");
    }
    m_cServer_cgo_operazioni_dl_multi = p_ContextObject.GetServer("cgo_operazioni_dl_multi");
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
    if (CPLib.eqr("_trovato",p_cVarName)) {
      return _trovato;
    }
    if (CPLib.eqr("_folder",p_cVarName)) {
      return _folder;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_cgo_delete_ope";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pOpe",p_cVarName)) {
      return pOpe;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pIDDOC",p_cVarName)) {
      return pIDDOC;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      return pCodDip;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
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
    if (CPLib.eqr("cOldUnico",p_cVarName)) {
      return cOldUnico;
    }
    if (CPLib.eqr("cOldDoc1",p_cVarName)) {
      return cOldDoc1;
    }
    if (CPLib.eqr("cOldDoc2",p_cVarName)) {
      return cOldDoc2;
    }
    if (CPLib.eqr("cOldDoc3",p_cVarName)) {
      return cOldDoc3;
    }
    if (CPLib.eqr("cOldDoc4",p_cVarName)) {
      return cOldDoc4;
    }
    if (CPLib.eqr("cOldDoc5",p_cVarName)) {
      return cOldDoc5;
    }
    if (CPLib.eqr("cOldDoc6",p_cVarName)) {
      return cOldDoc6;
    }
    if (CPLib.eqr("_okm",p_cVarName)) {
      return _okm;
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
    if (CPLib.eqr("_trovato",p_cVarName)) {
      _trovato = value;
      return;
    }
    if (CPLib.eqr("_folder",p_cVarName)) {
      _folder = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pOpe",p_cVarName)) {
      pOpe = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pIDDOC",p_cVarName)) {
      pIDDOC = value;
      return;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      pCodDip = value;
      return;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      gAzienda = value;
      return;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      gPathDoc = value;
      return;
    }
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
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
    if (CPLib.eqr("cOldUnico",p_cVarName)) {
      cOldUnico = value;
      return;
    }
    if (CPLib.eqr("cOldDoc1",p_cVarName)) {
      cOldDoc1 = value;
      return;
    }
    if (CPLib.eqr("cOldDoc2",p_cVarName)) {
      cOldDoc2 = value;
      return;
    }
    if (CPLib.eqr("cOldDoc3",p_cVarName)) {
      cOldDoc3 = value;
      return;
    }
    if (CPLib.eqr("cOldDoc4",p_cVarName)) {
      cOldDoc4 = value;
      return;
    }
    if (CPLib.eqr("cOldDoc5",p_cVarName)) {
      cOldDoc5 = value;
      return;
    }
    if (CPLib.eqr("cOldDoc6",p_cVarName)) {
      cOldDoc6 = value;
      return;
    }
    if (CPLib.eqr("_okm",p_cVarName)) {
      _okm = value;
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
    CPResultSet Cursor_cgo_docope=null;
    CPResultSet Cursor_intermbo=null;
    try {
      /* pOpe Char(15) // Codice Operazione */
      /* pTipo Char(2) // Sorgente Dati */
      /* pIDDOC Char(36) // ID Documentazione */
      /* pCodDip Char(6) // Codice Dipendenza */
      /* gAzienda Char(10) // Azienda */
      /* gPathDoc Char(128) // Path Documenti */
      /* cRitorno Char(40) */
      /* _pdest Char(120) */
      /* _olddoc Char(120) */
      /* host Char(100) */
      /* user Char(100) */
      /* password Char(100) */
      /* _trovato Numeric(1, 0) */
      /* cOldUnico Char(80) // Documento Unico */
      /* cOldDoc1 Char(80) // Doc 1 */
      /* cOldDoc2 Char(80) // Doc 2 */
      /* cOldDoc3 Char(80) // Doc 3 */
      /* cOldDoc4 Char(80) // Doc 4 */
      /* cOldDoc5 Char(80) // Doc 5 */
      /* cOldDoc6 Char(80) // Doc 6 */
      /* _folder Numeric(1, 0) */
      /* _okm Char(1) */
      // Begin Transaction
      m_Sql.RequireTransaction();
      double nTry0000001Cstatus;
      nTry0000001Cstatus = m_Sql.GetTransactionStatus();
      String cTry0000001Cmsg;
      cTry0000001Cmsg = m_Sql.TransactionErrorMessage();
      try {
        /* If pTipo='NO' */
        if (CPLib.eqr(pTipo,"NO")) {
          // * --- Delete from cgo_operazioni_dl
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_cgo_delete_ope",6,"0000001E")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pOpe,"?",0,0,m_cServer),m_cServer,pOpe)+"";
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
        /* If pTipo='OM' */
        if (CPLib.eqr(pTipo,"OM")) {
          // * --- Delete from cgo_operazioni_dl_multi_dt
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi_dt");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi_dt");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi_dt",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_cgo_delete_ope",6,"00000020")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pOpe,"?",0,0,m_cServer),m_cServer,pOpe)+"";
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
          // * --- Delete from cgo_operazioni_dl_multi
          m_Sql.RequireTransaction();
          m_cServer = m_Ctx.GetServer("cgo_operazioni_dl_multi");
          m_cPhName = m_Ctx.GetPhName("cgo_operazioni_dl_multi");
          m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_dl_multi",m_Ctx.GetCompany());
          m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
          m_cSql = CPLib.GetSQLPrefixComment("arfn_cgo_delete_ope",6,"00000021")+"delete from "+m_oWrInfo.GetTableWriteName();
          m_cSql = m_cSql+" where ";
          m_cSql = m_cSql+"SNAINUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pOpe,"?",0,0,m_cServer),m_cServer,pOpe)+"";
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
        /* If not(Empty(pIDDOC)) */
        if ( ! (CPLib.Empty(pIDDOC))) {
          /* _trovato := 0 */
          _trovato = CPLib.Round(0,0);
          /* _folder := 0 */
          _folder = CPLib.Round(0,0);
          // * --- Select from cgo_docope
          m_cServer = m_Ctx.GetServer("cgo_docope");
          m_cPhName = m_Ctx.GetPhName("cgo_docope");
          if (Cursor_cgo_docope!=null)
            Cursor_cgo_docope.Close();
          Cursor_cgo_docope = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+"("+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pIDDOC,"?",0,0,m_cServer, m_oParameters),m_cServer,pIDDOC)+" "+")"+(m_Ctx.IsSharedTemp("cgo_docope")?" and context_id='"+m_Ctx.GetTempID()+"'":" and 1=1"),m_cServer,m_Ctx,true));
          while ( ! (Cursor_cgo_docope.Eof())) {
            /* _trovato := 1 */
            _trovato = CPLib.Round(1,0);
            /* cOldUnico := cgo_docope->DCDOCUNICO // Documento Unico */
            cOldUnico = Cursor_cgo_docope.GetString("DCDOCUNICO");
            /* cOldDoc1 := cgo_docope->DCDOCNOM1 // Doc 1 */
            cOldDoc1 = Cursor_cgo_docope.GetString("DCDOCNOM1");
            /* cOldDoc2 := cgo_docope->DCDOCNOM2 // Doc 2 */
            cOldDoc2 = Cursor_cgo_docope.GetString("DCDOCNOM2");
            /* cOldDoc3 := cgo_docope->DCDOCNOM3 // Doc 3 */
            cOldDoc3 = Cursor_cgo_docope.GetString("DCDOCNOM3");
            /* cOldDoc4 := cgo_docope->DCDOCNOM4 // Doc 4 */
            cOldDoc4 = Cursor_cgo_docope.GetString("DCDOCNOM4");
            /* cOldDoc5 := cgo_docope->DCDOCNOM5 // Doc 5 */
            cOldDoc5 = Cursor_cgo_docope.GetString("DCDOCNOM5");
            /* cOldDoc6 := cgo_docope->DCDOCNOM6 // Doc 6 */
            cOldDoc6 = Cursor_cgo_docope.GetString("DCDOCNOM6");
            Cursor_cgo_docope.Next();
          }
          m_cConnectivityError = Cursor_cgo_docope.ErrorMessage();
          Cursor_cgo_docope.Close();
          // * --- End Select
          /* If _trovato=1 */
          if (CPLib.eqr(_trovato,1)) {
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
              /* _okm := intermbo->FLGGESDOC */
              _okm = Cursor_intermbo.GetString("FLGGESDOC");
              Cursor_intermbo.Next();
            }
            m_cConnectivityError = Cursor_intermbo.ErrorMessage();
            Cursor_intermbo.Close();
            // * --- End Select
            /* If _okm='S' */
            if (CPLib.eqr(_okm,"S")) {
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
              token = okmAuth.login(user, password);
              //Collegamento a OpenKM
              OKMWebservices okm= OKMWebservicesFactory.newInstance(host, user, password);
              /* _pdest := "/okm:root/"+LRTrim(pIDDOC) */
              _pdest = "/okm:root/"+CPLib.LRTrim(pIDDOC);
              /* If not(Empty(cOldUnico)) */
              if ( ! (CPLib.Empty(cOldUnico))) {
                /* _folder := 1 */
                _folder = CPLib.Round(1,0);
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cOldUnico) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(cOldUnico);
                // Cancella la cartella
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cOldDoc1)) */
              if ( ! (CPLib.Empty(cOldDoc1))) {
                /* _folder := 1 */
                _folder = CPLib.Round(1,0);
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cOldDoc1) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(cOldDoc1);
                // Cancella la cartella
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cOldDoc2)) */
              if ( ! (CPLib.Empty(cOldDoc2))) {
                /* _folder := 1 */
                _folder = CPLib.Round(1,0);
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cOldDoc2) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(cOldDoc2);
                // Cancella la cartella
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cOldDoc3)) */
              if ( ! (CPLib.Empty(cOldDoc3))) {
                /* _folder := 1 */
                _folder = CPLib.Round(1,0);
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cOldDoc3) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(cOldDoc3);
                // Cancella la cartella
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cOldDoc4)) */
              if ( ! (CPLib.Empty(cOldDoc4))) {
                /* _folder := 1 */
                _folder = CPLib.Round(1,0);
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cOldDoc4) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(cOldDoc4);
                // Cancella la cartella
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cOldDoc5)) */
              if ( ! (CPLib.Empty(cOldDoc5))) {
                /* _folder := 1 */
                _folder = CPLib.Round(1,0);
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cOldDoc5) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(cOldDoc5);
                // Cancella la cartella
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If not(Empty(cOldDoc6)) */
              if ( ! (CPLib.Empty(cOldDoc6))) {
                /* _folder := 1 */
                _folder = CPLib.Round(1,0);
                /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(cOldDoc6) */
                _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(cOldDoc6);
                // Cancella la cartella
                okmDocument.delete(token,_olddoc);
              } // End If
              /* If _folder=1 */
              if (CPLib.eqr(_folder,1)) {
                // Cancella la cartella
                okmFolder.delete(token,_pdest);
              } // End If
            } else { // Else
              /* _pdest := LRTrim(gPathDoc)+"/DocCGO/"+LRTrim(gAzienda)+"/"+LRTrim(pCodDip)+"/"+LRTrim(pIDDOC) */
              _pdest = CPLib.LRTrim(gPathDoc)+"/DocCGO/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(pIDDOC);
              /* If not(FileLibMit.DeleteDirectory(_pdest)) */
              if ( ! (FileLibMit.DeleteDirectory(_pdest))) {
                // Transaction Error
                cTry0000001Cmsg = CPLib.FormatMsg(m_Ctx,"Errore nella cancellazione della cartella dei documenti!");
                m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore nella cancellazione della cartella dei documenti!"));
                throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore nella cancellazione della cartella dei documenti!"));
              } // End If
            } // End If
            // * --- Delete from cgo_docope
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("cgo_docope");
            m_cPhName = m_Ctx.GetPhName("cgo_docope");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arfn_cgo_delete_ope",6,"0000005A")+"delete from "+m_oWrInfo.GetTableWriteName();
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
              throw new RoutineException();
            }
          } // End If
        } // End If
        // Commit
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        if (CPLib.ne(m_cLastMsgError,"")) {
          m_bError = true;
        }
        m_Sql.CompleteTransaction();
        /* Exec Routine arrt_writelog('Cancellazione Operazione',iif(pTipo='NO','cgo_operazioni_dl','cgo_operazioni_dl_multi'),LRTrim(pOpe)) */
        arrt_writelogR.Make(m_Ctx,this).Run("Cancellazione Operazione",(CPLib.eqr(pTipo,"NO")?"cgo_operazioni_dl":"cgo_operazioni_dl_multi"),CPLib.LRTrim(pOpe));
        /* cRitorno := 'OK' */
        cRitorno = "OK";
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        // Rollback
        m_Sql.AbortTransaction();
        m_cLastMsgError = m_Sql.TransactionErrorMessage();
        m_bError = true;
        m_Sql.CompleteTransaction();
        /* cRitorno := l_exeption.toString() */
        cRitorno = l_exeption.toString();
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000001Cstatus,0)) {
          m_Sql.SetTransactionStatus(nTry0000001Cstatus,cTry0000001Cmsg);
        }
      }
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_cgo_docope!=null)
          Cursor_cgo_docope.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
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
  public String RunAsync(String p_pOpe,String p_pTipo,String p_pIDDOC,String p_pCodDip) {
    pOpe = p_pOpe;
    pTipo = p_pTipo;
    pIDDOC = p_pIDDOC;
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
  public String Run(String p_pOpe,String p_pTipo,String p_pIDDOC,String p_pCodDip) {
    pOpe = p_pOpe;
    pTipo = p_pTipo;
    pIDDOC = p_pIDDOC;
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
  public static arfn_cgo_delete_opeR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_cgo_delete_opeR(p_Ctx, p_Caller);
  }
  public static arfn_cgo_delete_opeR Make(CPContext p_Ctx) {
    return new arfn_cgo_delete_opeR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pOpe = CPLib.Space(15);
    pTipo = CPLib.Space(2);
    pIDDOC = CPLib.Space(36);
    pCodDip = CPLib.Space(6);
    cRitorno = CPLib.Space(40);
    _pdest = CPLib.Space(120);
    _olddoc = CPLib.Space(120);
    host = CPLib.Space(100);
    user = CPLib.Space(100);
    password = CPLib.Space(100);
    _trovato = 0;
    cOldUnico = CPLib.Space(80);
    cOldDoc1 = CPLib.Space(80);
    cOldDoc2 = CPLib.Space(80);
    cOldDoc3 = CPLib.Space(80);
    cOldDoc4 = CPLib.Space(80);
    cOldDoc5 = CPLib.Space(80);
    cOldDoc6 = CPLib.Space(80);
    _folder = 0;
    _okm = CPLib.Space(1);
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_cgo_delete_ope,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_cgo_delete_ope,arrt_writelog,";
  public static String[] m_cRunParameterNames={"pOpe","pTipo","pIDDOC","pCodDip"};
}
