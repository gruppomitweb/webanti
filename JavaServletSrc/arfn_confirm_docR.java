// * --- Area Manuale = BO - Header
// * --- arfn_confirm_doc
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
import javax.xml.namespace.QName;
import java.net.URL;
import java.nio.file.*;
import javax.activation.*;
import org.apache.commons.io.FilenameUtils;
// * --- Fine Area Manuale
public class arfn_confirm_docR implements CallerWithObjs {
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
  public String m_cPhName_cgo_docope;
  public String m_cServer_cgo_docope;
  public String m_cPhName_cgo_operazioni_dl;
  public String m_cServer_cgo_operazioni_dl;
  public String m_cPhName_cgo_operazioni_dl_multi;
  public String m_cServer_cgo_operazioni_dl_multi;
  public String m_cPhName_cgo_operazioni;
  public String m_cServer_cgo_operazioni;
  public String m_cPhName_cgo_operazioni_storico;
  public String m_cServer_cgo_operazioni_storico;
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
  public String pID;
  public String pTipo;
  public String pDocUnico;
  public String pDoc1;
  public String pDoc2;
  public String pDoc3;
  public String pDoc4;
  public String pDoc5;
  public String pDoc6;
  public String pOld0;
  public String pOld1;
  public String pOld2;
  public String pOld3;
  public String pOld4;
  public String pOld5;
  public String pOld6;
  public String pAttivi;
  public String pTicket;
  public String pCodDip;
  public String gPathApp;
  public String cActLog;
  public double gUserCode;
  public String gAzienda;
  public String gPathDoc;
  public String _porig;
  public String _pdest;
  public String _olddoc;
  public String _prgdoc;
  public double _found;
  public boolean _creata;
  public String _nomedoc;
  public String _nomeorg;
  public String host;
  public String user;
  public String password;
  public MemoryCursor_mcdocope_mcrdef mcDocumenti;
  public MemoryCursorRow_mcdocope_mcrdef rwDocumenti;
  public MemoryCursor_mcdocope_mcrdef mcOldDoc;
  public MemoryCursorRow_mcdocope_mcrdef rwOldDoc;
  public String cRitorno;
  public String _completo;
  public String cProg;
  public String _errore;
  public String cOldUnico;
  public String cOldDoc1;
  public String cOldDoc2;
  public String cOldDoc3;
  public String cOldDoc4;
  public String cOldDoc5;
  public String cOldDoc6;
  public double _contadoc;
  public double _richiesti;
  public boolean _exist;
  public String xOld0;
  public String xOld1;
  public String xOld2;
  public String xOld3;
  public String xOld4;
  public String xOld5;
  public String xOld6;
  public boolean _validfld;
  public String _onamedoc;
  public String _extfile;
  public String _okm;
  // * --- Area Manuale = BO - Properties
  // * --- arfn_confirm_doc
  private static QName AuthServiceName = new QName("http://ws.openkm.com", "OKMAuth");
  private static QName DocumentServiceName = new QName("http://ws.openkm.com", "OKMDocument");
  
  public OKMAuth_Service authService = null;
  public OKMDocument_Service documentService = null;
  public OKMAuth okmAuth = null;
  public OKMDocument okmDocument = null;
  
  public String token;
  // * --- Fine Area Manuale
  public arfn_confirm_docR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arfn_confirm_doc",m_Caller);
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_cgo_docope = p_ContextObject.GetPhName("cgo_docope");
    if (m_cPhName_cgo_docope.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_docope = m_cPhName_cgo_docope+" "+m_Ctx.GetWritePhName("cgo_docope");
    }
    m_cServer_cgo_docope = p_ContextObject.GetServer("cgo_docope");
    m_cPhName_cgo_operazioni_dl = p_ContextObject.GetPhName("cgo_operazioni_dl");
    if (m_cPhName_cgo_operazioni_dl.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl = m_cPhName_cgo_operazioni_dl+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl");
    }
    m_cServer_cgo_operazioni_dl = p_ContextObject.GetServer("cgo_operazioni_dl");
    m_cPhName_cgo_operazioni_dl_multi = p_ContextObject.GetPhName("cgo_operazioni_dl_multi");
    if (m_cPhName_cgo_operazioni_dl_multi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_dl_multi = m_cPhName_cgo_operazioni_dl_multi+" "+m_Ctx.GetWritePhName("cgo_operazioni_dl_multi");
    }
    m_cServer_cgo_operazioni_dl_multi = p_ContextObject.GetServer("cgo_operazioni_dl_multi");
    m_cPhName_cgo_operazioni = p_ContextObject.GetPhName("cgo_operazioni");
    if (m_cPhName_cgo_operazioni.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni = m_cPhName_cgo_operazioni+" "+m_Ctx.GetWritePhName("cgo_operazioni");
    }
    m_cServer_cgo_operazioni = p_ContextObject.GetServer("cgo_operazioni");
    m_cPhName_cgo_operazioni_storico = p_ContextObject.GetPhName("cgo_operazioni_storico");
    if (m_cPhName_cgo_operazioni_storico.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_cgo_operazioni_storico = m_cPhName_cgo_operazioni_storico+" "+m_Ctx.GetWritePhName("cgo_operazioni_storico");
    }
    m_cServer_cgo_operazioni_storico = p_ContextObject.GetServer("cgo_operazioni_storico");
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      return gUserCode;
    }
    if (CPLib.eqr("_found",p_cVarName)) {
      return _found;
    }
    if (CPLib.eqr("_contadoc",p_cVarName)) {
      return _contadoc;
    }
    if (CPLib.eqr("_richiesti",p_cVarName)) {
      return _richiesti;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arfn_confirm_doc";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "function";
    }
    if (CPLib.eqr("pID",p_cVarName)) {
      return pID;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      return pTipo;
    }
    if (CPLib.eqr("pDocUnico",p_cVarName)) {
      return pDocUnico;
    }
    if (CPLib.eqr("pDoc1",p_cVarName)) {
      return pDoc1;
    }
    if (CPLib.eqr("pDoc2",p_cVarName)) {
      return pDoc2;
    }
    if (CPLib.eqr("pDoc3",p_cVarName)) {
      return pDoc3;
    }
    if (CPLib.eqr("pDoc4",p_cVarName)) {
      return pDoc4;
    }
    if (CPLib.eqr("pDoc5",p_cVarName)) {
      return pDoc5;
    }
    if (CPLib.eqr("pDoc6",p_cVarName)) {
      return pDoc6;
    }
    if (CPLib.eqr("pOld0",p_cVarName)) {
      return pOld0;
    }
    if (CPLib.eqr("pOld1",p_cVarName)) {
      return pOld1;
    }
    if (CPLib.eqr("pOld2",p_cVarName)) {
      return pOld2;
    }
    if (CPLib.eqr("pOld3",p_cVarName)) {
      return pOld3;
    }
    if (CPLib.eqr("pOld4",p_cVarName)) {
      return pOld4;
    }
    if (CPLib.eqr("pOld5",p_cVarName)) {
      return pOld5;
    }
    if (CPLib.eqr("pOld6",p_cVarName)) {
      return pOld6;
    }
    if (CPLib.eqr("pAttivi",p_cVarName)) {
      return pAttivi;
    }
    if (CPLib.eqr("pTicket",p_cVarName)) {
      return pTicket;
    }
    if (CPLib.eqr("pCodDip",p_cVarName)) {
      return pCodDip;
    }
    if (CPLib.eqr("gPathApp",p_cVarName)) {
      return gPathApp;
    }
    if (CPLib.eqr("cActLog",p_cVarName)) {
      return cActLog;
    }
    if (CPLib.eqr("gAzienda",p_cVarName)) {
      return gAzienda;
    }
    if (CPLib.eqr("gPathDoc",p_cVarName)) {
      return gPathDoc;
    }
    if (CPLib.eqr("_porig",p_cVarName)) {
      return _porig;
    }
    if (CPLib.eqr("_pdest",p_cVarName)) {
      return _pdest;
    }
    if (CPLib.eqr("_olddoc",p_cVarName)) {
      return _olddoc;
    }
    if (CPLib.eqr("_prgdoc",p_cVarName)) {
      return _prgdoc;
    }
    if (CPLib.eqr("_nomedoc",p_cVarName)) {
      return _nomedoc;
    }
    if (CPLib.eqr("_nomeorg",p_cVarName)) {
      return _nomeorg;
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
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      return cRitorno;
    }
    if (CPLib.eqr("_completo",p_cVarName)) {
      return _completo;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
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
    if (CPLib.eqr("xOld0",p_cVarName)) {
      return xOld0;
    }
    if (CPLib.eqr("xOld1",p_cVarName)) {
      return xOld1;
    }
    if (CPLib.eqr("xOld2",p_cVarName)) {
      return xOld2;
    }
    if (CPLib.eqr("xOld3",p_cVarName)) {
      return xOld3;
    }
    if (CPLib.eqr("xOld4",p_cVarName)) {
      return xOld4;
    }
    if (CPLib.eqr("xOld5",p_cVarName)) {
      return xOld5;
    }
    if (CPLib.eqr("xOld6",p_cVarName)) {
      return xOld6;
    }
    if (CPLib.eqr("_onamedoc",p_cVarName)) {
      return _onamedoc;
    }
    if (CPLib.eqr("_extfile",p_cVarName)) {
      return _extfile;
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
    if (CPLib.eqr("_creata",p_cVarName)) {
      return _creata;
    }
    if (CPLib.eqr("_exist",p_cVarName)) {
      return _exist;
    }
    if (CPLib.eqr("_validfld",p_cVarName)) {
      return _validfld;
    }
    return false;
  }
  public CPMemoryCursor GetMemoryCursor(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("mcDocumenti",p_cVarName)) {
      return mcDocumenti;
    }
    if (CPLib.eqr("mcOldDoc",p_cVarName)) {
      return mcOldDoc;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rwDocumenti",p_cVarName)) {
      return rwDocumenti;
    }
    if (CPLib.eqr("rwOldDoc",p_cVarName)) {
      return rwOldDoc;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("gUserCode",p_cVarName)) {
      gUserCode = value;
      return;
    }
    if (CPLib.eqr("_found",p_cVarName)) {
      _found = value;
      return;
    }
    if (CPLib.eqr("_contadoc",p_cVarName)) {
      _contadoc = value;
      return;
    }
    if (CPLib.eqr("_richiesti",p_cVarName)) {
      _richiesti = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("pID",p_cVarName)) {
      pID = value;
      return;
    }
    if (CPLib.eqr("pTipo",p_cVarName)) {
      pTipo = value;
      return;
    }
    if (CPLib.eqr("pDocUnico",p_cVarName)) {
      pDocUnico = value;
      return;
    }
    if (CPLib.eqr("pDoc1",p_cVarName)) {
      pDoc1 = value;
      return;
    }
    if (CPLib.eqr("pDoc2",p_cVarName)) {
      pDoc2 = value;
      return;
    }
    if (CPLib.eqr("pDoc3",p_cVarName)) {
      pDoc3 = value;
      return;
    }
    if (CPLib.eqr("pDoc4",p_cVarName)) {
      pDoc4 = value;
      return;
    }
    if (CPLib.eqr("pDoc5",p_cVarName)) {
      pDoc5 = value;
      return;
    }
    if (CPLib.eqr("pDoc6",p_cVarName)) {
      pDoc6 = value;
      return;
    }
    if (CPLib.eqr("pOld0",p_cVarName)) {
      pOld0 = value;
      return;
    }
    if (CPLib.eqr("pOld1",p_cVarName)) {
      pOld1 = value;
      return;
    }
    if (CPLib.eqr("pOld2",p_cVarName)) {
      pOld2 = value;
      return;
    }
    if (CPLib.eqr("pOld3",p_cVarName)) {
      pOld3 = value;
      return;
    }
    if (CPLib.eqr("pOld4",p_cVarName)) {
      pOld4 = value;
      return;
    }
    if (CPLib.eqr("pOld5",p_cVarName)) {
      pOld5 = value;
      return;
    }
    if (CPLib.eqr("pOld6",p_cVarName)) {
      pOld6 = value;
      return;
    }
    if (CPLib.eqr("pAttivi",p_cVarName)) {
      pAttivi = value;
      return;
    }
    if (CPLib.eqr("pTicket",p_cVarName)) {
      pTicket = value;
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
    if (CPLib.eqr("cActLog",p_cVarName)) {
      cActLog = value;
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
    if (CPLib.eqr("_porig",p_cVarName)) {
      _porig = value;
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
    if (CPLib.eqr("_prgdoc",p_cVarName)) {
      _prgdoc = value;
      return;
    }
    if (CPLib.eqr("_nomedoc",p_cVarName)) {
      _nomedoc = value;
      return;
    }
    if (CPLib.eqr("_nomeorg",p_cVarName)) {
      _nomeorg = value;
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
    if (CPLib.eqr("cRitorno",p_cVarName)) {
      cRitorno = value;
      return;
    }
    if (CPLib.eqr("_completo",p_cVarName)) {
      _completo = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
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
    if (CPLib.eqr("xOld0",p_cVarName)) {
      xOld0 = value;
      return;
    }
    if (CPLib.eqr("xOld1",p_cVarName)) {
      xOld1 = value;
      return;
    }
    if (CPLib.eqr("xOld2",p_cVarName)) {
      xOld2 = value;
      return;
    }
    if (CPLib.eqr("xOld3",p_cVarName)) {
      xOld3 = value;
      return;
    }
    if (CPLib.eqr("xOld4",p_cVarName)) {
      xOld4 = value;
      return;
    }
    if (CPLib.eqr("xOld5",p_cVarName)) {
      xOld5 = value;
      return;
    }
    if (CPLib.eqr("xOld6",p_cVarName)) {
      xOld6 = value;
      return;
    }
    if (CPLib.eqr("_onamedoc",p_cVarName)) {
      _onamedoc = value;
      return;
    }
    if (CPLib.eqr("_extfile",p_cVarName)) {
      _extfile = value;
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
    if (CPLib.eqr("_creata",p_cVarName)) {
      _creata = value;
      return;
    }
    if (CPLib.eqr("_exist",p_cVarName)) {
      _exist = value;
      return;
    }
    if (CPLib.eqr("_validfld",p_cVarName)) {
      _validfld = value;
      return;
    }
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rwDocumenti",p_cVarName)) {
      rwDocumenti = (MemoryCursorRow_mcdocope_mcrdef)value;
      return;
    }
    if (CPLib.eqr("rwOldDoc",p_cVarName)) {
      rwOldDoc = (MemoryCursorRow_mcdocope_mcrdef)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcDocumenti",p_cVarName)) {
      mcDocumenti = (MemoryCursor_mcdocope_mcrdef)value;
      return;
    }
    if (CPLib.eqr("mcOldDoc",p_cVarName)) {
      mcOldDoc = (MemoryCursor_mcdocope_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    CPResultSet Cursor_intermbo=null;
    CPResultSet Read_Cursor=null;
    try {
      /* pID Char(36) */
      /* pTipo Char(1) */
      /* pDocUnico Char(80) // Documento Unico */
      /* pDoc1 Char(80) // Documento 1 */
      /* pDoc2 Char(80) // Documento 2 */
      /* pDoc3 Char(80) // Documento 3 */
      /* pDoc4 Char(80) // Documento 4 */
      /* pDoc5 Char(80) // Documento 5 */
      /* pDoc6 Char(80) // Documento 6 */
      /* pOld0 Char(1) // Documento Unico */
      /* pOld1 Char(1) // Documento 1 */
      /* pOld2 Char(1) // Documento 2 */
      /* pOld3 Char(1) // Documento 3 */
      /* pOld4 Char(1) // Documento 4 */
      /* pOld5 Char(1) // Documento 5 */
      /* pOld6 Char(1) // Documento 6 */
      /* pAttivi Char(7) */
      /* pTicket Char(30) // ID Biglietto */
      /* pCodDip Char(6) // Dipendenza */
      /* gPathApp Char(80) // Path Applicazione */
      /* cActLog Char(1) // Log Applicazione */
      /* gUserCode Numeric(4, 0) // Codice Utente CP */
      /* gAzienda Char(10) // Azienda */
      /* gPathDoc Char(128) // Path Documenti */
      /* _porig Char(120) */
      /* _pdest Char(120) */
      /* _olddoc Char(120) */
      /* _prgdoc Char(15) */
      /* _found Numeric(1, 0) */
      /* _creata Bool */
      /* _nomedoc Char(100) */
      /* _nomeorg Char(100) */
      /* host Char(100) */
      /* user Char(100) */
      /* password Char(100) */
      /* mcDocumenti MemoryCursor(mcDocOpe.MCRDef) */
      /* rwDocumenti Row(mcDocOpe.MCRDef) */
      /* mcOldDoc MemoryCursor(mcDocOpe.MCRDef) */
      /* rwOldDoc Row(mcDocOpe.MCRDef) */
      /* cRitorno Char(1) */
      /* _completo Char(1) */
      /* cProg Char(20) */
      /* _errore Memo */
      /* cOldUnico Char(80) */
      /* cOldDoc1 Char(80) */
      /* cOldDoc2 Char(80) */
      /* cOldDoc3 Char(80) */
      /* cOldDoc4 Char(80) */
      /* cOldDoc5 Char(80) */
      /* cOldDoc6 Char(80) */
      /* _contadoc Numeric(2, 0) */
      /* _richiesti Numeric(2, 0) */
      /* _exist Bool */
      /* xOld0 Char(1) // Documento Unico */
      /* xOld1 Char(1) // Documento 1 */
      /* xOld2 Char(1) // Documento 2 */
      /* xOld3 Char(1) // Documento 3 */
      /* xOld4 Char(1) // Documento 4 */
      /* xOld5 Char(1) // Documento 5 */
      /* xOld6 Char(1) // Documento 6 */
      /* _validfld Bool */
      /* _onamedoc Char(0) */
      /* _extfile Char(3) */
      /* _okm Char(1) */
      /* _completo := 'N' */
      _completo = "N";
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
      /* If Empty(pID) */
      if (CPLib.Empty(pID)) {
        /* cRitorno := 'NN' */
        cRitorno = "NN";
        /* If cActLog='S' */
        if (CPLib.eqr(cActLog,"S")) {
          /* Exec Routine arrt_writelog('Inserimento Nuovi Documenti','CGO_DOCOPE','Errore','Impossibile inserire un documento con operazione non collegabile a gestione documentale',"D") */
          arrt_writelogR.Make(m_Ctx,this).Run("Inserimento Nuovi Documenti","CGO_DOCOPE","Errore","Impossibile inserire un documento con operazione non collegabile a gestione documentale","D");
        } // End If
      } else { // Else
        /* _contadoc := 0 */
        _contadoc = CPLib.Round(0,0);
        /* cOldUnico := '' */
        cOldUnico = "";
        /* cOldDoc1 := '' */
        cOldDoc1 = "";
        /* cOldDoc2 := '' */
        cOldDoc2 = "";
        /* cOldDoc3 := '' */
        cOldDoc3 = "";
        /* cOldDoc4 := '' */
        cOldDoc4 = "";
        /* cOldDoc5 := '' */
        cOldDoc5 = "";
        /* cOldDoc6 := '' */
        cOldDoc6 = "";
        /* xOld0 := pOld0 // Documento Unico */
        xOld0 = pOld0;
        /* xOld1 := pOld1 // Documento 1 */
        xOld1 = pOld1;
        /* xOld2 := pOld2 // Documento 2 */
        xOld2 = pOld2;
        /* xOld3 := pOld3 // Documento 3 */
        xOld3 = pOld3;
        /* xOld4 := pOld4 // Documento 4 */
        xOld4 = pOld4;
        /* xOld5 := pOld5 // Documento 5 */
        xOld5 = pOld5;
        /* xOld6 := pOld6 // Documento 6 */
        xOld6 = pOld6;
        // * --- Read from cgo_docope
        m_cServer = m_Ctx.GetServer("cgo_docope");
        m_cPhName = m_Ctx.GetPhName("cgo_docope");
        m_cSql = "";
        m_cSql = m_cSql+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"C",36,0,m_cServer),m_cServer,pID);
        if (m_Ctx.IsSharedTemp("cgo_docope")) {
          m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
        }
        if (Read_Cursor!=null)
          Read_Cursor.Close();
        Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DCDOCUNICO",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNOM1",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNOM2",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNOM3",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNOM4",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNOM5",m_Ctx,m_cServer)+","+CPLib.GetMultilanguageField("DCDOCNOM6",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
        if ( ! (Read_Cursor.Eof())) {
          cOldUnico = Read_Cursor.GetString("DCDOCUNICO");
          cOldDoc1 = Read_Cursor.GetString("DCDOCNOM1");
          cOldDoc2 = Read_Cursor.GetString("DCDOCNOM2");
          cOldDoc3 = Read_Cursor.GetString("DCDOCNOM3");
          cOldDoc4 = Read_Cursor.GetString("DCDOCNOM4");
          cOldDoc5 = Read_Cursor.GetString("DCDOCNOM5");
          cOldDoc6 = Read_Cursor.GetString("DCDOCNOM6");
          Read_Cursor.Next();
          if ( ! (Read_Cursor.Eof())) {
            Error l_oErrorFault = new Error("Read on cgo_docope into routine arfn_confirm_doc returns two or more records. This item should return only a record.");
            CPStdCounter.Error(l_oErrorFault);
          }
          Read_Cursor.Close();
        } else {
          // Error: no record found!
          cOldUnico = "";
          cOldDoc1 = "";
          cOldDoc2 = "";
          cOldDoc3 = "";
          cOldDoc4 = "";
          cOldDoc5 = "";
          cOldDoc6 = "";
          Read_Cursor.Close();
          m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
        }
        /* If not(Empty(pDocUnico)) */
        if ( ! (CPLib.Empty(pDocUnico))) {
          /* _onamedoc := pDocUnico */
          _onamedoc = pDocUnico;
          /* _extfile := FilenameUtils.getExtension(_onamedoc) */
          _extfile = FilenameUtils.getExtension(_onamedoc);
          /* If pOld0='N' */
          if (CPLib.eqr(pOld0,"N")) {
            /* pDocUnico := LibreriaMit.nextUID()+"."+_extfile */
            pDocUnico = LibreriaMit.nextUID()+"."+_extfile;
            /* _contadoc := _contadoc + 1 */
            _contadoc = CPLib.Round(_contadoc+1,0);
            /* mcDocumenti.AppendBlank() */
            mcDocumenti.AppendBlank();
            /* mcDocumenti.numdoc := 1 */
            mcDocumenti.row.numdoc = 1;
            /* mcDocumenti.nomdoc := pDocUnico */
            mcDocumenti.row.nomdoc = pDocUnico;
            /* mcDocumenti.orgdoc := _onamedoc */
            mcDocumenti.row.orgdoc = _onamedoc;
            /* mcDocumenti.olddoc := cOldUnico */
            mcDocumenti.row.olddoc = cOldUnico;
            /* mcDocumenti.SaveRow() */
            mcDocumenti.SaveRow();
            /* xOld0 := 'X' // Documento Unico */
            xOld0 = "X";
          } else { // Else
            /* mcOldDoc.AppendBlank() */
            mcOldDoc.AppendBlank();
            /* mcOldDoc.numdoc := 1 */
            mcOldDoc.row.numdoc = 1;
            /* mcOldDoc.nomdoc := pDocUnico */
            mcOldDoc.row.nomdoc = pDocUnico;
            /* mcOldDoc.orgdoc := _onamedoc */
            mcOldDoc.row.orgdoc = _onamedoc;
            /* mcOldDoc.olddoc := cOldUnico */
            mcOldDoc.row.olddoc = cOldUnico;
            /* mcOldDoc.SaveRow() */
            mcOldDoc.SaveRow();
          } // End If
        } else { // Else
          /* xOld0 := 'N' // Documento Unico */
          xOld0 = "N";
          /* If not(Empty(pDoc1)) */
          if ( ! (CPLib.Empty(pDoc1))) {
            /* _onamedoc := pDoc1 */
            _onamedoc = pDoc1;
            /* _extfile := FilenameUtils.getExtension(_onamedoc) */
            _extfile = FilenameUtils.getExtension(_onamedoc);
            /* If pOld1='N' */
            if (CPLib.eqr(pOld1,"N")) {
              /* pDoc1 := LibreriaMit.nextUID()+"."+_extfile */
              pDoc1 = LibreriaMit.nextUID()+"."+_extfile;
              /* _contadoc := _contadoc + 1 */
              _contadoc = CPLib.Round(_contadoc+1,0);
              /* mcDocumenti.AppendBlank() */
              mcDocumenti.AppendBlank();
              /* mcDocumenti.numdoc := 1 */
              mcDocumenti.row.numdoc = 1;
              /* mcDocumenti.nomdoc := pDoc1 */
              mcDocumenti.row.nomdoc = pDoc1;
              /* mcDocumenti.orgdoc := _onamedoc */
              mcDocumenti.row.orgdoc = _onamedoc;
              /* mcDocumenti.olddoc := cOldDoc1 */
              mcDocumenti.row.olddoc = cOldDoc1;
              /* mcDocumenti.SaveRow() */
              mcDocumenti.SaveRow();
              /* xOld1 := 'X' // Documento Unico */
              xOld1 = "X";
            } else { // Else
              /* mcOldDoc.AppendBlank() */
              mcOldDoc.AppendBlank();
              /* mcOldDoc.numdoc := 1 */
              mcOldDoc.row.numdoc = 1;
              /* mcOldDoc.nomdoc := pDoc1 */
              mcOldDoc.row.nomdoc = pDoc1;
              /* mcOldDoc.orgdoc := _onamedoc */
              mcOldDoc.row.orgdoc = _onamedoc;
              /* mcOldDoc.olddoc := cOldDoc1 */
              mcOldDoc.row.olddoc = cOldDoc1;
              /* mcOldDoc.SaveRow() */
              mcOldDoc.SaveRow();
            } // End If
          } else { // Else
            /* xOld1 := 'N' // Documento Unico */
            xOld1 = "N";
          } // End If
          /* If not(Empty(pDoc2)) */
          if ( ! (CPLib.Empty(pDoc2))) {
            /* _onamedoc := pDoc2 */
            _onamedoc = pDoc2;
            /* _extfile := FilenameUtils.getExtension(_onamedoc) */
            _extfile = FilenameUtils.getExtension(_onamedoc);
            /* If pOld2='N' */
            if (CPLib.eqr(pOld2,"N")) {
              /* pDoc2 := LibreriaMit.nextUID()+"."+_extfile */
              pDoc2 = LibreriaMit.nextUID()+"."+_extfile;
              /* _contadoc := _contadoc + 1 */
              _contadoc = CPLib.Round(_contadoc+1,0);
              /* mcDocumenti.AppendBlank() */
              mcDocumenti.AppendBlank();
              /* mcDocumenti.numdoc := 2 */
              mcDocumenti.row.numdoc = 2;
              /* mcDocumenti.nomdoc := pDoc2 */
              mcDocumenti.row.nomdoc = pDoc2;
              /* mcDocumenti.orgdoc := _onamedoc */
              mcDocumenti.row.orgdoc = _onamedoc;
              /* mcDocumenti.olddoc := cOldDoc2 */
              mcDocumenti.row.olddoc = cOldDoc2;
              /* mcDocumenti.SaveRow() */
              mcDocumenti.SaveRow();
              /* xOld2 := 'X' // Documento Unico */
              xOld2 = "X";
            } else { // Else
              /* mcOldDoc.AppendBlank() */
              mcOldDoc.AppendBlank();
              /* mcOldDoc.numdoc := 2 */
              mcOldDoc.row.numdoc = 2;
              /* mcOldDoc.nomdoc := pDoc2 */
              mcOldDoc.row.nomdoc = pDoc2;
              /* mcOldDoc.orgdoc := _onamedoc */
              mcOldDoc.row.orgdoc = _onamedoc;
              /* mcOldDoc.olddoc := cOldDoc2 */
              mcOldDoc.row.olddoc = cOldDoc2;
              /* mcOldDoc.SaveRow() */
              mcOldDoc.SaveRow();
            } // End If
          } else { // Else
            /* xOld2 := 'N' // Documento Unico */
            xOld2 = "N";
          } // End If
          /* If not(Empty(pDoc3)) */
          if ( ! (CPLib.Empty(pDoc3))) {
            /* _onamedoc := pDoc3 */
            _onamedoc = pDoc3;
            /* _extfile := FilenameUtils.getExtension(_onamedoc) */
            _extfile = FilenameUtils.getExtension(_onamedoc);
            /* If pOld3='N' */
            if (CPLib.eqr(pOld3,"N")) {
              /* pDoc3 := LibreriaMit.nextUID()+"."+_extfile */
              pDoc3 = LibreriaMit.nextUID()+"."+_extfile;
              /* _contadoc := _contadoc + 1 */
              _contadoc = CPLib.Round(_contadoc+1,0);
              /* mcDocumenti.AppendBlank() */
              mcDocumenti.AppendBlank();
              /* mcDocumenti.numdoc := 3 */
              mcDocumenti.row.numdoc = 3;
              /* mcDocumenti.nomdoc := pDoc3 */
              mcDocumenti.row.nomdoc = pDoc3;
              /* mcDocumenti.orgdoc := _onamedoc */
              mcDocumenti.row.orgdoc = _onamedoc;
              /* mcDocumenti.olddoc := cOldDoc3 */
              mcDocumenti.row.olddoc = cOldDoc3;
              /* mcDocumenti.SaveRow() */
              mcDocumenti.SaveRow();
              /* xOld3 := 'X' // Documento Unico */
              xOld3 = "X";
            } else { // Else
              /* mcOldDoc.AppendBlank() */
              mcOldDoc.AppendBlank();
              /* mcOldDoc.numdoc := 3 */
              mcOldDoc.row.numdoc = 3;
              /* mcOldDoc.nomdoc := pDoc3 */
              mcOldDoc.row.nomdoc = pDoc3;
              /* mcOldDoc.orgdoc := _onamedoc */
              mcOldDoc.row.orgdoc = _onamedoc;
              /* mcOldDoc.olddoc := cOldDoc3 */
              mcOldDoc.row.olddoc = cOldDoc3;
              /* mcOldDoc.SaveRow() */
              mcOldDoc.SaveRow();
            } // End If
          } else { // Else
            /* xOld3 := 'N' // Documento Unico */
            xOld3 = "N";
          } // End If
          /* If not(Empty(pDoc4)) */
          if ( ! (CPLib.Empty(pDoc4))) {
            /* _onamedoc := pDoc4 */
            _onamedoc = pDoc4;
            /* _extfile := FilenameUtils.getExtension(_onamedoc) */
            _extfile = FilenameUtils.getExtension(_onamedoc);
            /* If pOld4='N' */
            if (CPLib.eqr(pOld4,"N")) {
              /* pDoc4 := LibreriaMit.nextUID()+"."+_extfile */
              pDoc4 = LibreriaMit.nextUID()+"."+_extfile;
              /* _contadoc := _contadoc + 1 */
              _contadoc = CPLib.Round(_contadoc+1,0);
              /* mcDocumenti.AppendBlank() */
              mcDocumenti.AppendBlank();
              /* mcDocumenti.numdoc := 4 */
              mcDocumenti.row.numdoc = 4;
              /* mcDocumenti.nomdoc := pDoc4 */
              mcDocumenti.row.nomdoc = pDoc4;
              /* mcDocumenti.orgdoc := _onamedoc */
              mcDocumenti.row.orgdoc = _onamedoc;
              /* mcDocumenti.olddoc := cOldDoc4 */
              mcDocumenti.row.olddoc = cOldDoc4;
              /* mcDocumenti.SaveRow() */
              mcDocumenti.SaveRow();
              /* xOld4 := 'X' // Documento Unico */
              xOld4 = "X";
            } else { // Else
              /* mcOldDoc.AppendBlank() */
              mcOldDoc.AppendBlank();
              /* mcOldDoc.numdoc := 4 */
              mcOldDoc.row.numdoc = 4;
              /* mcOldDoc.nomdoc := pDoc4 */
              mcOldDoc.row.nomdoc = pDoc4;
              /* mcOldDoc.orgdoc := pDoc4 */
              mcOldDoc.row.orgdoc = pDoc4;
              /* mcOldDoc.olddoc := cOldDoc4 */
              mcOldDoc.row.olddoc = cOldDoc4;
              /* mcOldDoc.SaveRow() */
              mcOldDoc.SaveRow();
            } // End If
          } else { // Else
            /* xOld4 := 'N' // Documento Unico */
            xOld4 = "N";
          } // End If
          /* If not(Empty(pDoc5)) */
          if ( ! (CPLib.Empty(pDoc5))) {
            /* _onamedoc := pDoc5 */
            _onamedoc = pDoc5;
            /* _extfile := FilenameUtils.getExtension(_onamedoc) */
            _extfile = FilenameUtils.getExtension(_onamedoc);
            /* If pOld5='N' */
            if (CPLib.eqr(pOld5,"N")) {
              /* pDoc5 := LibreriaMit.nextUID()+"."+_extfile */
              pDoc5 = LibreriaMit.nextUID()+"."+_extfile;
              /* _contadoc := _contadoc + 1 */
              _contadoc = CPLib.Round(_contadoc+1,0);
              /* mcDocumenti.AppendBlank() */
              mcDocumenti.AppendBlank();
              /* mcDocumenti.numdoc := 5 */
              mcDocumenti.row.numdoc = 5;
              /* mcDocumenti.nomdoc := pDoc5 */
              mcDocumenti.row.nomdoc = pDoc5;
              /* mcDocumenti.orgdoc := _onamedoc */
              mcDocumenti.row.orgdoc = _onamedoc;
              /* mcDocumenti.olddoc := cOldDoc5 */
              mcDocumenti.row.olddoc = cOldDoc5;
              /* mcDocumenti.SaveRow() */
              mcDocumenti.SaveRow();
              /* xOld5 := 'X' // Documento Unico */
              xOld5 = "X";
            } else { // Else
              /* mcOldDoc.AppendBlank() */
              mcOldDoc.AppendBlank();
              /* mcOldDoc.numdoc := 5 */
              mcOldDoc.row.numdoc = 5;
              /* mcOldDoc.nomdoc := pDoc5 */
              mcOldDoc.row.nomdoc = pDoc5;
              /* mcOldDoc.orgdoc := pDoc5 */
              mcOldDoc.row.orgdoc = pDoc5;
              /* mcOldDoc.olddoc := cOldDoc5 */
              mcOldDoc.row.olddoc = cOldDoc5;
              /* mcOldDoc.SaveRow() */
              mcOldDoc.SaveRow();
            } // End If
          } else { // Else
            /* xOld5 := 'N' // Documento Unico */
            xOld5 = "N";
          } // End If
          /* If not(Empty(pDoc6)) */
          if ( ! (CPLib.Empty(pDoc6))) {
            /* _onamedoc := pDoc6 */
            _onamedoc = pDoc6;
            /* _extfile := FilenameUtils.getExtension(_onamedoc) */
            _extfile = FilenameUtils.getExtension(_onamedoc);
            /* If pOld6='N' */
            if (CPLib.eqr(pOld6,"N")) {
              /* pDoc6 := LibreriaMit.nextUID()+"."+_extfile */
              pDoc6 = LibreriaMit.nextUID()+"."+_extfile;
              /* _contadoc := _contadoc + 1 */
              _contadoc = CPLib.Round(_contadoc+1,0);
              /* mcDocumenti.AppendBlank() */
              mcDocumenti.AppendBlank();
              /* mcDocumenti.numdoc := 6 */
              mcDocumenti.row.numdoc = 6;
              /* mcDocumenti.nomdoc := pDoc6 */
              mcDocumenti.row.nomdoc = pDoc6;
              /* mcDocumenti.orgdoc := _onamedoc */
              mcDocumenti.row.orgdoc = _onamedoc;
              /* mcDocumenti.olddoc := cOldDoc6 */
              mcDocumenti.row.olddoc = cOldDoc6;
              /* mcDocumenti.SaveRow() */
              mcDocumenti.SaveRow();
              /* xOld6 := 'X' // Documento Unico */
              xOld6 = "X";
            } else { // Else
              /* mcOldDoc.AppendBlank() */
              mcOldDoc.AppendBlank();
              /* mcOldDoc.numdoc := 6 */
              mcOldDoc.row.numdoc = 6;
              /* mcOldDoc.nomdoc := pDoc6 */
              mcOldDoc.row.nomdoc = pDoc6;
              /* mcOldDoc.orgdoc := _onamedoc */
              mcOldDoc.row.orgdoc = _onamedoc;
              /* mcOldDoc.olddoc := cOldDoc6 */
              mcOldDoc.row.olddoc = cOldDoc6;
              /* mcOldDoc.SaveRow() */
              mcOldDoc.SaveRow();
            } // End If
          } else { // Else
            /* xOld6 := 'N' // Documento Unico */
            xOld6 = "N";
          } // End If
        } // End If
        /* _porig := LRTrim(gPathApp)+'/appo/'+LRTrim(pCodDip)+"/" */
        _porig = CPLib.LRTrim(gPathApp)+"/appo/"+CPLib.LRTrim(pCodDip)+"/";
        /* If _okm='S' */
        if (CPLib.eqr(_okm,"S")) {
          /* Exec "OKM" Page 2:FileOKM */
          FileOKM();
        } else { // Else
          /* Exec "File System" Page 3:FileSystem */
          FileSystem();
        } // End If
      } // End If
      /* Return cRitorno */
      throw new Stop(cRitorno);
    } finally {
      try {
        if (Cursor_intermbo!=null)
          Cursor_intermbo.Close();
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
  void FileOKM() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* _pdest := "/okm:root/"+LRTrim(pID) */
      _pdest = "/okm:root/"+CPLib.LRTrim(pID);
      double nTry000000F3status;
      nTry000000F3status = m_Sql.GetTransactionStatus();
      String cTry000000F3msg;
      cTry000000F3msg = m_Sql.TransactionErrorMessage();
      try {
        //
        // Ripulisce directory utente
        //File _directory=new File(CPLib.LRTrim(_pathout));
        //FileUtils.cleanDirectory(_directory);
        // Autentica in OpenKM
        authService = new OKMAuth_Service(new URL(host + "/services/OKMAuth?wsdl"), AuthServiceName);
        documentService = new OKMDocument_Service(new URL(host + "/services/OKMDocument?wsdl"), DocumentServiceName);
        okmAuth = authService.getOKMAuthPort();
        okmDocument = documentService.getOKMDocumentPort();
        // Login
        token = okmAuth.login(user, password);
      } catch(Exception l_exeption) {
        Stop.ReactToException(l_exeption);
        /* cRitorno := 'NC' */
        cRitorno = "NC";
        /* _contadoc := -1 */
        _contadoc = CPLib.Round(-1,0);
      } finally {
        if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000F3status,0)) {
          m_Sql.SetTransactionStatus(nTry000000F3status,cTry000000F3msg);
        }
      }
      //Collegamento a OpenKM
      OKMWebservices okm= OKMWebservicesFactory.newInstance(host, user, password);
      // Verifica se esiste cartella
      try {
        Folder fld = new Folder();
        fld.setPath(_pdest);
        // _validfld=okm.isValidFolder(_pdest);
        // System.out.println(_validfld);
        okm.createFolder(fld);
      } catch (Exception e) {
      }
      /* If _contadoc > 0 */
      if (CPLib.gt(_contadoc,0)) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry000000FCstatus;
        nTry000000FCstatus = m_Sql.GetTransactionStatus();
        String cTry000000FCmsg;
        cTry000000FCmsg = m_Sql.TransactionErrorMessage();
        try {
          /* _contadoc := 0 */
          _contadoc = CPLib.Round(0,0);
          MemoryCursor_mcdocope_mcrdef cpmc_000000FE;
          cpmc_000000FE = new MemoryCursor_mcdocope_mcrdef();
          for (MemoryCursorRow_mcdocope_mcrdef rwDocumenti : mcDocumenti._iterable_()) {
            cpmc_000000FE.Append(rwDocumenti);
          }
          for (MemoryCursorRow_mcdocope_mcrdef rwDocumenti : cpmc_000000FE._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_mcdocope_mcrdef>(){  public int compare(MemoryCursorRow_mcdocope_mcrdef r1,MemoryCursorRow_mcdocope_mcrdef r2){    if (CPLib.gt(r1.numdoc,r2.numdoc)) return 1;    if (CPLib.lt(r1.numdoc,r2.numdoc)) return -1;    return 0;  }})) {
            /* _nomedoc := LRTrim(_pdest)+"/"+LRTrim(rwDocumenti.nomdoc) */
            _nomedoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(rwDocumenti.nomdoc);
            /* _nomeorg := LRTrim(_porig)+LRTrim(rwDocumenti.orgdoc) */
            _nomeorg = CPLib.LRTrim(_porig)+CPLib.LRTrim(rwDocumenti.orgdoc);
            /* If FileLibMit.ExistFile(_nomeorg) */
            if (FileLibMit.ExistFile(_nomeorg)) {
              /* _contadoc := _contadoc + 1 */
              _contadoc = CPLib.Round(_contadoc+1,0);
              // Scrive file in repository
              DataSource fds = new FileDataSource(CPLib.LRTrim(_nomeorg));
              DataHandler dhandler = new DataHandler(fds);
              okmDocument.createSimple(token,_nomedoc,dhandler);
            } else { // Else
              System.out.println("Nome File Origine:"+_nomeorg);
              System.out.println("Nome File Destinazione:"+_nomedoc);
              // Transaction Error
              cTry000000FCmsg = CPLib.FormatMsg(m_Ctx,"File origine non trovato");
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"File origine non trovato"));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"File origine non trovato"));
            } // End If
            /* FileLibMit.DeleteFilePath(_nomeorg) */
            FileLibMit.DeleteFilePath(_nomeorg);
          }
          /* If _contadoc > 0 */
          if (CPLib.gt(_contadoc,0)) {
            /* _prgdoc := '' */
            _prgdoc = "";
            // * --- Read from cgo_docope
            m_cServer = m_Ctx.GetServer("cgo_docope");
            m_cPhName = m_Ctx.GetPhName("cgo_docope");
            m_cSql = "";
            m_cSql = m_cSql+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"C",36,0,m_cServer),m_cServer,pID);
            if (m_Ctx.IsSharedTemp("cgo_docope")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DCNUMOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _prgdoc = Read_Cursor.GetString("DCNUMOPE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cgo_docope into routine arfn_confirm_doc returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _prgdoc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_prgdoc) */
            if (CPLib.Empty(_prgdoc)) {
              // * --- Insert into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"0000010B")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000010B(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(pID,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDocUnico,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc4,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc5,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc6,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld0,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld4,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld5,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld6,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_docope",true);
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
            } else { // Else
              // * --- Write into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"0000010C")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DCDOCUNICO = "+CPLib.ToSQL(pDocUnico,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM1 = "+CPLib.ToSQL(pDoc1,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM2 = "+CPLib.ToSQL(pDoc2,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM3 = "+CPLib.ToSQL(pDoc3,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM4 = "+CPLib.ToSQL(pDoc4,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM5 = "+CPLib.ToSQL(pDoc5,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM6 = "+CPLib.ToSQL(pDoc6,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW0 = "+CPLib.ToSQL(xOld0,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW1 = "+CPLib.ToSQL(xOld1,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW2 = "+CPLib.ToSQL(xOld2,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW3 = "+CPLib.ToSQL(xOld3,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW4 = "+CPLib.ToSQL(xOld4,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW5 = "+CPLib.ToSQL(xOld5,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW6 = "+CPLib.ToSQL(xOld6,"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"?",0,0,m_cServer),m_cServer,pID)+"";
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
            /* If not(Empty(pDocUnico)) */
            if ( ! (CPLib.Empty(pDocUnico))) {
              /* _completo := 'S' */
              _completo = "S";
            } // End If
            /* If not(Empty(pDoc1)) and not(Empty(pDoc2)) and not(Empty(pDoc3)) and not(Empty(pDoc4)) and iif(Val(Substr(pAttivi,7,1)) >= 5,iif(not(Empty(pDoc5)),True,False),True) and iif(Val(Substr(pAttivi,7,1)) = 6,iif(not(Empty(pDoc6)),True,False),True) */
            if ( ! (CPLib.Empty(pDoc1)) &&  ! (CPLib.Empty(pDoc2)) &&  ! (CPLib.Empty(pDoc3)) &&  ! (CPLib.Empty(pDoc4)) && (CPLib.ge(CPLib.Val(CPLib.Substr(pAttivi,7,1)),5)?( ! (CPLib.Empty(pDoc5))?true:false):true) && (CPLib.eqr(CPLib.Val(CPLib.Substr(pAttivi,7,1)),6)?( ! (CPLib.Empty(pDoc6))?true:false):true)) {
              /* _completo := 'S' */
              _completo = "S";
            } // End If
            /* If _completo='S' and pTipo='S' */
            if (CPLib.eqr(_completo,"S") && CPLib.eqr(pTipo,"S")) {
              // * --- Write into cgo_operazioni_storico from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"00000113")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"FLGDOCALL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_storico",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDDOCALL = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"?",0,0,m_cServer),m_cServer,pID)+"";
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
            /* If cActLog='S' */
            if (CPLib.eqr(cActLog,"S")) {
              /* Exec Routine arrt_writelog('Inserimento Nuovi Documenti','CGO_DOCOPE',LRTrim(pID),'',"D") */
              arrt_writelogR.Make(m_Ctx,this).Run("Inserimento Nuovi Documenti","CGO_DOCOPE",CPLib.LRTrim(pID),"","D");
            } // End If
          } else { // Else
            // Transaction Error
            cTry000000FCmsg = CPLib.FormatMsg(m_Ctx,"Errore nel salvataggio dei documenti (Non ci sono documenti da salvare)");
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore nel salvataggio dei documenti (Non ci sono documenti da salvare)"));
            throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore nel salvataggio dei documenti (Non ci sono documenti da salvare)"));
          } // End If
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* cRitorno := 'S'+_completo */
          cRitorno = "S"+_completo;
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* cRitorno := 'N'+_completo */
          cRitorno = "N"+_completo;
          /* If cActLog='S' */
          if (CPLib.eqr(cActLog,"S")) {
            /* _errore := l_exeption.toString() */
            _errore = l_exeption.toString();
            /* Exec Routine arrt_writelog('Inserimento Nuovi Documenti','CGO_DOCOPE',LRTrim(pTicket),_errore,"D") */
            arrt_writelogR.Make(m_Ctx,this).Run("Inserimento Nuovi Documenti","CGO_DOCOPE",CPLib.LRTrim(pTicket),_errore,"D");
          } // End If
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry000000FCstatus,0)) {
            m_Sql.SetTransactionStatus(nTry000000FCstatus,cTry000000FCmsg);
          }
        }
      } else { // Else
        /* If _contadoc=0 */
        if (CPLib.eqr(_contadoc,0)) {
          /* cRitorno := 'NX' */
          cRitorno = "NX";
          /* If not(Empty(pDocUnico)) */
          if ( ! (CPLib.Empty(pDocUnico))) {
            /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(mcOldDoc.nomdoc) */
            _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(mcOldDoc.row.nomdoc);
            /* _exist := okmDocument.isValid(token,_olddoc) */
            _exist = okmDocument.isValid(token,_olddoc);
            /* If _exist */
            if (_exist) {
              /* cRitorno := 'XS' */
              cRitorno = "XS";
              /* If pTipo='S' */
              if (CPLib.eqr(pTipo,"S")) {
                // * --- Write into cgo_operazioni_storico from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"00000126")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"FLGDOCALL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_storico",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDDOCALL = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"?",0,0,m_cServer),m_cServer,pID)+"";
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
            } // End If
          } else { // Else
            /* _contadoc := 0 */
            _contadoc = CPLib.Round(0,0);
            /* _richiesti := Val(Right(pAttivi,1)) */
            _richiesti = CPLib.Round(CPLib.Val(CPLib.Right(pAttivi,1)),0);
            for (MemoryCursorRow_mcdocope_mcrdef rwOldDoc : mcOldDoc._iterable_()) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(rwOldDoc.nomdoc) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(rwOldDoc.nomdoc);
              double nTry0000012Bstatus;
              nTry0000012Bstatus = m_Sql.GetTransactionStatus();
              String cTry0000012Bmsg;
              cTry0000012Bmsg = m_Sql.TransactionErrorMessage();
              try {
                /* _exist := okmDocument.isValid(token,_olddoc) */
                _exist = okmDocument.isValid(token,_olddoc);
                /* _contadoc := iif(_exist,_contadoc + 1,_contadoc) */
                _contadoc = CPLib.Round((_exist?_contadoc+1:_contadoc),0);
              } catch(Exception l_exeption) {
                Stop.ReactToException(l_exeption);
                /* If cActLog='S' */
                if (CPLib.eqr(cActLog,"S")) {
                  /* Exec Routine arrt_writelog('Inserimento Nuovi Documenti','CGO_DOCOPE',LRTrim(pTicket),'Documento: '+LRTrim(rwOldDoc.nomdoc)+" non presente in archivio.","D") */
                  arrt_writelogR.Make(m_Ctx,this).Run("Inserimento Nuovi Documenti","CGO_DOCOPE",CPLib.LRTrim(pTicket),"Documento: "+CPLib.LRTrim(rwOldDoc.nomdoc)+" non presente in archivio.","D");
                } // End If
              } finally {
                if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000012Bstatus,0)) {
                  m_Sql.SetTransactionStatus(nTry0000012Bstatus,cTry0000012Bmsg);
                }
              }
            }
            /* If _richiesti=_contadoc and (_richiesti + _contadoc) > 0 */
            if (CPLib.eqr(_richiesti,_contadoc) && CPLib.gt((_richiesti+_contadoc),0)) {
              /* cRitorno := 'XS' */
              cRitorno = "XS";
              /* If pTipo='S' */
              if (CPLib.eqr(pTipo,"S")) {
                // * --- Write into cgo_operazioni_storico from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"00000133")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"FLGDOCALL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_storico",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDDOCALL = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"?",0,0,m_cServer),m_cServer,pID)+"";
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
            } else { // Else
              /* cRitorno := 'XZ' */
              cRitorno = "XZ";
            } // End If
          } // End If
        } // End If
      } // End If
    } finally {
      try {
        if (Read_Cursor!=null)
          Read_Cursor.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void FileSystem() throws Exception {
    CPResultSet Read_Cursor=null;
    try {
      /* _pdest := LRTrim(gPathDoc)+"/DocCGO/"+LRTrim(gAzienda)+"/"+LRTrim(pCodDip)+"/"+LRTrim(pID) */
      _pdest = CPLib.LRTrim(gPathDoc)+"/DocCGO/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(pCodDip)+"/"+CPLib.LRTrim(pID);
      /* FileLibMit.CreateDirPath(_pdest) */
      FileLibMit.CreateDirPath(_pdest);
      /* If _contadoc > 0 */
      if (CPLib.gt(_contadoc,0)) {
        // Begin Transaction
        m_Sql.RequireTransaction();
        double nTry0000013Astatus;
        nTry0000013Astatus = m_Sql.GetTransactionStatus();
        String cTry0000013Amsg;
        cTry0000013Amsg = m_Sql.TransactionErrorMessage();
        try {
          /* _contadoc := 0 */
          _contadoc = CPLib.Round(0,0);
          MemoryCursor_mcdocope_mcrdef cpmc_0000013C;
          cpmc_0000013C = new MemoryCursor_mcdocope_mcrdef();
          for (MemoryCursorRow_mcdocope_mcrdef rwDocumenti : mcDocumenti._iterable_()) {
            cpmc_0000013C.Append(rwDocumenti);
          }
          for (MemoryCursorRow_mcdocope_mcrdef rwDocumenti : cpmc_0000013C._iterable_(new CPMemoryCursorRow.Comparator<MemoryCursorRow_mcdocope_mcrdef>(){  public int compare(MemoryCursorRow_mcdocope_mcrdef r1,MemoryCursorRow_mcdocope_mcrdef r2){    if (CPLib.gt(r1.numdoc,r2.numdoc)) return 1;    if (CPLib.lt(r1.numdoc,r2.numdoc)) return -1;    return 0;  }})) {
            /* _nomedoc := LRTrim(_pdest)+"/"+LRTrim(rwDocumenti.nomdoc) */
            _nomedoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(rwDocumenti.nomdoc);
            /* _nomeorg := LRTrim(_porig)+LRTrim(rwDocumenti.orgdoc) */
            _nomeorg = CPLib.LRTrim(_porig)+CPLib.LRTrim(rwDocumenti.orgdoc);
            /* If FileLibMit.ExistFile(_nomeorg) */
            if (FileLibMit.ExistFile(_nomeorg)) {
              /* _contadoc := _contadoc + 1 */
              _contadoc = CPLib.Round(_contadoc+1,0);
              /* FileLibMit.FileCopyPath(_nomeorg,_nomedoc) */
              FileLibMit.FileCopyPath(_nomeorg,_nomedoc);
            } else { // Else
              // Transaction Error
              cTry0000013Amsg = CPLib.FormatMsg(m_Ctx,"File origine non trovato");
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"File origine non trovato"));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"File origine non trovato"));
            } // End If
            /* FileLibMit.DeleteFilePath(_nomeorg) */
            FileLibMit.DeleteFilePath(_nomeorg);
          }
          /* If _contadoc > 0 */
          if (CPLib.gt(_contadoc,0)) {
            /* _prgdoc := '' */
            _prgdoc = "";
            // * --- Read from cgo_docope
            m_cServer = m_Ctx.GetServer("cgo_docope");
            m_cPhName = m_Ctx.GetPhName("cgo_docope");
            m_cSql = "";
            m_cSql = m_cSql+"DCNUMOPE="+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"C",36,0,m_cServer),m_cServer,pID);
            if (m_Ctx.IsSharedTemp("cgo_docope")) {
              m_cSql = m_cSql+" and context_id='"+m_Ctx.GetTempID()+"'";
            }
            if (Read_Cursor!=null)
              Read_Cursor.Close();
            Read_Cursor = m_Sql.Query(m_cServer,"select "+CPLib.GetMultilanguageField("DCNUMOPE",m_Ctx,m_cServer)+" from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+m_cSql);
            if ( ! (Read_Cursor.Eof())) {
              _prgdoc = Read_Cursor.GetString("DCNUMOPE");
              Read_Cursor.Next();
              if ( ! (Read_Cursor.Eof())) {
                Error l_oErrorFault = new Error("Read on cgo_docope into routine arfn_confirm_doc returns two or more records. This item should return only a record.");
                CPStdCounter.Error(l_oErrorFault);
              }
              Read_Cursor.Close();
            } else {
              // Error: no record found!
              _prgdoc = "";
              Read_Cursor.Close();
              m_cLastMsgError = "MSG_RECORD_NOT_FOUND";
            }
            /* If Empty(_prgdoc) */
            if (CPLib.Empty(_prgdoc)) {
              // * --- Insert into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"00000148")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_00000148(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(pID,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDocUnico,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc4,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc5,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(pDoc6,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld0,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld4,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld5,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(xOld6,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"cgo_docope",true);
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
            } else { // Else
              // * --- Write into cgo_docope from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_docope");
              m_cPhName = m_Ctx.GetPhName("cgo_docope");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_docope",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"00000149")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"DCDOCUNICO = "+CPLib.ToSQL(pDocUnico,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM1 = "+CPLib.ToSQL(pDoc1,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM2 = "+CPLib.ToSQL(pDoc2,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM3 = "+CPLib.ToSQL(pDoc3,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM4 = "+CPLib.ToSQL(pDoc4,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM5 = "+CPLib.ToSQL(pDoc5,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNOM6 = "+CPLib.ToSQL(pDoc6,"C",80,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW0 = "+CPLib.ToSQL(xOld0,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW1 = "+CPLib.ToSQL(xOld1,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW2 = "+CPLib.ToSQL(xOld2,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW3 = "+CPLib.ToSQL(xOld3,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW4 = "+CPLib.ToSQL(xOld4,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW5 = "+CPLib.ToSQL(xOld5,"C",1,0,m_cServer)+", ";
              m_cSql = m_cSql+"DCDOCNEW6 = "+CPLib.ToSQL(xOld6,"C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_docope",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"DCNUMOPE = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"?",0,0,m_cServer),m_cServer,pID)+"";
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
            /* If not(Empty(pDocUnico)) */
            if ( ! (CPLib.Empty(pDocUnico))) {
              /* _completo := 'S' */
              _completo = "S";
            } // End If
            /* If not(Empty(pDoc1)) and not(Empty(pDoc2)) and not(Empty(pDoc3)) and not(Empty(pDoc4)) and iif(Val(Substr(pAttivi,7,1)) >= 5,iif(not(Empty(pDoc5)),True,False),True) and iif(Val(Substr(pAttivi,7,1)) = 6,iif(not(Empty(pDoc6)),True,False),True) */
            if ( ! (CPLib.Empty(pDoc1)) &&  ! (CPLib.Empty(pDoc2)) &&  ! (CPLib.Empty(pDoc3)) &&  ! (CPLib.Empty(pDoc4)) && (CPLib.ge(CPLib.Val(CPLib.Substr(pAttivi,7,1)),5)?( ! (CPLib.Empty(pDoc5))?true:false):true) && (CPLib.eqr(CPLib.Val(CPLib.Substr(pAttivi,7,1)),6)?( ! (CPLib.Empty(pDoc6))?true:false):true)) {
              /* _completo := 'S' */
              _completo = "S";
            } // End If
            /* If _completo='S' and pTipo='S' */
            if (CPLib.eqr(_completo,"S") && CPLib.eqr(pTipo,"S")) {
              // * --- Write into cgo_operazioni_storico from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
              m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"00000150")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
              m_cSql = m_cSql+"FLGDOCALL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
              m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_storico",false,true);
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"IDDOCALL = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"?",0,0,m_cServer),m_cServer,pID)+"";
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
            /* If cActLog='S' */
            if (CPLib.eqr(cActLog,"S")) {
              /* Exec Routine arrt_writelog('Inserimento Nuovi Documenti','CGO_DOCOPE',LRTrim(pID),"","D") */
              arrt_writelogR.Make(m_Ctx,this).Run("Inserimento Nuovi Documenti","CGO_DOCOPE",CPLib.LRTrim(pID),"","D");
            } // End If
          } else { // Else
            // Transaction Error
            cTry0000013Amsg = CPLib.FormatMsg(m_Ctx,"Errore nel salvataggio dei documenti (Non ci sono documenti da salvare)");
            m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"Errore nel salvataggio dei documenti (Non ci sono documenti da salvare)"));
            throw new RoutineException(CPLib.FormatMsg(m_Ctx,"Errore nel salvataggio dei documenti (Non ci sono documenti da salvare)"));
          } // End If
          // Commit
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          if (CPLib.ne(m_cLastMsgError,"")) {
            m_bError = true;
          }
          m_Sql.CompleteTransaction();
          /* cRitorno := 'S'+_completo */
          cRitorno = "S"+_completo;
        } catch(Exception l_exeption) {
          Stop.ReactToException(l_exeption);
          // Rollback
          m_Sql.AbortTransaction();
          m_cLastMsgError = m_Sql.TransactionErrorMessage();
          m_bError = true;
          m_Sql.CompleteTransaction();
          /* cRitorno := 'N'+_completo */
          cRitorno = "N"+_completo;
          /* If cActLog='S' */
          if (CPLib.eqr(cActLog,"S")) {
            /* _errore := l_exeption.toString() */
            _errore = l_exeption.toString();
            /* Exec Routine arrt_writelog('Inserimento Nuovi Documenti','CGO_DOCOPE',LRTrim(pTicket),_errore,"D") */
            arrt_writelogR.Make(m_Ctx,this).Run("Inserimento Nuovi Documenti","CGO_DOCOPE",CPLib.LRTrim(pTicket),_errore,"D");
          } // End If
        } finally {
          if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry0000013Astatus,0)) {
            m_Sql.SetTransactionStatus(nTry0000013Astatus,cTry0000013Amsg);
          }
        }
      } else { // Else
        /* If _contadoc=0 */
        if (CPLib.eqr(_contadoc,0)) {
          /* cRitorno := 'NX' */
          cRitorno = "NX";
          /* If not(Empty(pDocUnico)) */
          if ( ! (CPLib.Empty(pDocUnico))) {
            /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(mcOldDoc.nomdoc) */
            _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(mcOldDoc.row.nomdoc);
            /* _exist := FileLibMit.ExistFile(_olddoc) */
            _exist = FileLibMit.ExistFile(_olddoc);
            /* If _exist */
            if (_exist) {
              /* cRitorno := 'XS' */
              cRitorno = "XS";
              /* If pTipo='S' */
              if (CPLib.eqr(pTipo,"S")) {
                // * --- Write into cgo_operazioni_storico from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"00000163")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"FLGDOCALL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_storico",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDDOCALL = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"?",0,0,m_cServer),m_cServer,pID)+"";
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
            } // End If
          } else { // Else
            /* _contadoc := 0 */
            _contadoc = CPLib.Round(0,0);
            /* _richiesti := Val(Right(pAttivi,1)) */
            _richiesti = CPLib.Round(CPLib.Val(CPLib.Right(pAttivi,1)),0);
            for (MemoryCursorRow_mcdocope_mcrdef rwOldDoc : mcOldDoc._iterable_()) {
              /* _olddoc := LRTrim(_pdest)+"/"+LRTrim(rwOldDoc.nomdoc) */
              _olddoc = CPLib.LRTrim(_pdest)+"/"+CPLib.LRTrim(rwOldDoc.nomdoc);
              double nTry00000168status;
              nTry00000168status = m_Sql.GetTransactionStatus();
              String cTry00000168msg;
              cTry00000168msg = m_Sql.TransactionErrorMessage();
              try {
                /* _exist := FileLibMit.ExistFile(_olddoc) */
                _exist = FileLibMit.ExistFile(_olddoc);
                /* _contadoc := iif(_exist,_contadoc + 1,_contadoc) */
                _contadoc = CPLib.Round((_exist?_contadoc+1:_contadoc),0);
              } catch(Exception l_exeption) {
                Stop.ReactToException(l_exeption);
                /* If cActLog='S' */
                if (CPLib.eqr(cActLog,"S")) {
                  /* Exec Routine arrt_writelog('Inserimento Nuovi Documenti','CGO_DOCOPE',LRTrim(pTicket),'Documento: '+LRTrim(rwOldDoc.nomdoc)+" non presente in archivio.","D") */
                  arrt_writelogR.Make(m_Ctx,this).Run("Inserimento Nuovi Documenti","CGO_DOCOPE",CPLib.LRTrim(pTicket),"Documento: "+CPLib.LRTrim(rwOldDoc.nomdoc)+" non presente in archivio.","D");
                } // End If
              } finally {
                if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000168status,0)) {
                  m_Sql.SetTransactionStatus(nTry00000168status,cTry00000168msg);
                }
              }
            }
            /* If _richiesti=_contadoc and (_richiesti + _contadoc) > 0  */
            if (CPLib.eqr(_richiesti,_contadoc) && CPLib.gt((_richiesti+_contadoc),0)) {
              /* cRitorno := 'XS' */
              cRitorno = "XS";
              /* If pTipo='S' */
              if (CPLib.eqr(pTipo,"S")) {
                // * --- Write into cgo_operazioni_storico from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("cgo_operazioni_storico");
                m_cPhName = m_Ctx.GetPhName("cgo_operazioni_storico");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"cgo_operazioni_storico",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arfn_confirm_doc",130,"00000170")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"FLGDOCALL = "+CPLib.ToSQL("S","C",1,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"cgo_operazioni_storico",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"IDDOCALL = "+CPSql.SQLValueAdapter(CPLib.ToSQL(pID,"?",0,0,m_cServer),m_cServer,pID)+"";
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
            } else { // Else
              /* cRitorno := 'XZ' */
              cRitorno = "XZ";
            } // End If
          } // End If
        } // End If
      } // End If
    } finally {
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
  public String RunAsync(String p_pID,String p_pTipo,String p_pDocUnico,String p_pDoc1,String p_pDoc2,String p_pDoc3,String p_pDoc4,String p_pDoc5,String p_pDoc6,String p_pOld0,String p_pOld1,String p_pOld2,String p_pOld3,String p_pOld4,String p_pOld5,String p_pOld6,String p_pAttivi,String p_pTicket,String p_pCodDip) {
    pID = p_pID;
    pTipo = p_pTipo;
    pDocUnico = p_pDocUnico;
    pDoc1 = p_pDoc1;
    pDoc2 = p_pDoc2;
    pDoc3 = p_pDoc3;
    pDoc4 = p_pDoc4;
    pDoc5 = p_pDoc5;
    pDoc6 = p_pDoc6;
    pOld0 = p_pOld0;
    pOld1 = p_pOld1;
    pOld2 = p_pOld2;
    pOld3 = p_pOld3;
    pOld4 = p_pOld4;
    pOld5 = p_pOld5;
    pOld6 = p_pOld6;
    pAttivi = p_pAttivi;
    pTicket = p_pTicket;
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
  public String Run(String p_pID,String p_pTipo,String p_pDocUnico,String p_pDoc1,String p_pDoc2,String p_pDoc3,String p_pDoc4,String p_pDoc5,String p_pDoc6,String p_pOld0,String p_pOld1,String p_pOld2,String p_pOld3,String p_pOld4,String p_pOld5,String p_pOld6,String p_pAttivi,String p_pTicket,String p_pCodDip) {
    pID = p_pID;
    pTipo = p_pTipo;
    pDocUnico = p_pDocUnico;
    pDoc1 = p_pDoc1;
    pDoc2 = p_pDoc2;
    pDoc3 = p_pDoc3;
    pDoc4 = p_pDoc4;
    pDoc5 = p_pDoc5;
    pDoc6 = p_pDoc6;
    pOld0 = p_pOld0;
    pOld1 = p_pOld1;
    pOld2 = p_pOld2;
    pOld3 = p_pOld3;
    pOld4 = p_pOld4;
    pOld5 = p_pOld5;
    pOld6 = p_pOld6;
    pAttivi = p_pAttivi;
    pTicket = p_pTicket;
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
  public static arfn_confirm_docR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arfn_confirm_docR(p_Ctx, p_Caller);
  }
  public static arfn_confirm_docR Make(CPContext p_Ctx) {
    return new arfn_confirm_docR(p_Ctx, CPSecurity.EXECUTE_ALL_ROUTINES);
  }
  public void Blank() {
    pID = CPLib.Space(36);
    pTipo = CPLib.Space(1);
    pDocUnico = CPLib.Space(80);
    pDoc1 = CPLib.Space(80);
    pDoc2 = CPLib.Space(80);
    pDoc3 = CPLib.Space(80);
    pDoc4 = CPLib.Space(80);
    pDoc5 = CPLib.Space(80);
    pDoc6 = CPLib.Space(80);
    pOld0 = CPLib.Space(1);
    pOld1 = CPLib.Space(1);
    pOld2 = CPLib.Space(1);
    pOld3 = CPLib.Space(1);
    pOld4 = CPLib.Space(1);
    pOld5 = CPLib.Space(1);
    pOld6 = CPLib.Space(1);
    pAttivi = CPLib.Space(7);
    pTicket = CPLib.Space(30);
    pCodDip = CPLib.Space(6);
    _porig = CPLib.Space(120);
    _pdest = CPLib.Space(120);
    _olddoc = CPLib.Space(120);
    _prgdoc = CPLib.Space(15);
    _found = 0;
    _creata = false;
    _nomedoc = CPLib.Space(100);
    _nomeorg = CPLib.Space(100);
    host = CPLib.Space(100);
    user = CPLib.Space(100);
    password = CPLib.Space(100);
    mcDocumenti = new MemoryCursor_mcdocope_mcrdef();
    rwDocumenti = new MemoryCursorRow_mcdocope_mcrdef();
    mcOldDoc = new MemoryCursor_mcdocope_mcrdef();
    rwOldDoc = new MemoryCursorRow_mcdocope_mcrdef();
    cRitorno = CPLib.Space(1);
    _completo = CPLib.Space(1);
    cProg = CPLib.Space(20);
    _errore = "";
    cOldUnico = CPLib.Space(80);
    cOldDoc1 = CPLib.Space(80);
    cOldDoc2 = CPLib.Space(80);
    cOldDoc3 = CPLib.Space(80);
    cOldDoc4 = CPLib.Space(80);
    cOldDoc5 = CPLib.Space(80);
    cOldDoc6 = CPLib.Space(80);
    _contadoc = 0;
    _richiesti = 0;
    _exist = false;
    xOld0 = CPLib.Space(1);
    xOld1 = CPLib.Space(1);
    xOld2 = CPLib.Space(1);
    xOld3 = CPLib.Space(1);
    xOld4 = CPLib.Space(1);
    xOld5 = CPLib.Space(1);
    xOld6 = CPLib.Space(1);
    _validfld = false;
    _onamedoc = CPLib.Space(0);
    _extfile = CPLib.Space(3);
    _okm = CPLib.Space(1);
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    cActLog=m_Ctx.GetGlobalString("cActLog");
    gUserCode=m_Ctx.GetGlobalNumber("gUserCode");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathDoc=m_Ctx.GetGlobalString("gPathDoc");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: 
  public static final String m_cVQRList = "";
  // ENTITY_BATCHES: ,arfn_confirm_doc,arrt_writelog,
  public static final String i_InvokedRoutines = ",arfn_confirm_doc,arrt_writelog,";
  public static String[] m_cRunParameterNames={"pID","pTipo","pDocUnico","pDoc1","pDoc2","pDoc3","pDoc4","pDoc5","pDoc6","pOld0","pOld1","pOld2","pOld3","pOld4","pOld5","pOld6","pAttivi","pTicket","pCodDip"};
  protected static String GetFieldsName_0000010B(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"DCNUMOPE,";
    p_cSql = p_cSql+"DCDOCUNICO,";
    p_cSql = p_cSql+"DCDOCNOM1,";
    p_cSql = p_cSql+"DCDOCNOM2,";
    p_cSql = p_cSql+"DCDOCNOM3,";
    p_cSql = p_cSql+"DCDOCNOM4,";
    p_cSql = p_cSql+"DCDOCNOM5,";
    p_cSql = p_cSql+"DCDOCNOM6,";
    p_cSql = p_cSql+"DCDOCNEW0,";
    p_cSql = p_cSql+"DCDOCNEW1,";
    p_cSql = p_cSql+"DCDOCNEW2,";
    p_cSql = p_cSql+"DCDOCNEW3,";
    p_cSql = p_cSql+"DCDOCNEW4,";
    p_cSql = p_cSql+"DCDOCNEW5,";
    p_cSql = p_cSql+"DCDOCNEW6,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_docope",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000148(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"DCNUMOPE,";
    p_cSql = p_cSql+"DCDOCUNICO,";
    p_cSql = p_cSql+"DCDOCNOM1,";
    p_cSql = p_cSql+"DCDOCNOM2,";
    p_cSql = p_cSql+"DCDOCNOM3,";
    p_cSql = p_cSql+"DCDOCNOM4,";
    p_cSql = p_cSql+"DCDOCNOM5,";
    p_cSql = p_cSql+"DCDOCNOM6,";
    p_cSql = p_cSql+"DCDOCNEW0,";
    p_cSql = p_cSql+"DCDOCNEW1,";
    p_cSql = p_cSql+"DCDOCNEW2,";
    p_cSql = p_cSql+"DCDOCNEW3,";
    p_cSql = p_cSql+"DCDOCNEW4,";
    p_cSql = p_cSql+"DCDOCNEW5,";
    p_cSql = p_cSql+"DCDOCNEW6,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"cgo_docope",true);
    return p_cSql;
  }
}
