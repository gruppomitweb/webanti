// * --- Area Manuale = BO - Header
// * --- arrt_famextra
import java.io.*;
import java.util.Scanner;
// * --- Fine Area Manuale
public class arrt_famextraR implements CallerWithObjs {
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
  public String m_cPhName_aeannora;
  public String m_cServer_aeannora;
  public String m_cPhName_aefaminvio;
  public String m_cServer_aefaminvio;
  public String m_cPhName_aesaldi;
  public String m_cServer_aesaldi;
  public String m_cPhName_aetesta;
  public String m_cServer_aetesta;
  public String m_cPhName_intermbo;
  public String m_cServer_intermbo;
  public String m_cPhName_opextrbo;
  public String m_cServer_opextrbo;
  public String m_cPhName_sid_invio;
  public String m_cServer_sid_invio;
  public String m_cPhName_sid_invio1;
  public String m_cServer_sid_invio1;
  public String m_cPhName_sid_invio2;
  public String m_cServer_sid_invio2;
  public String m_cPhName_sid_invio3;
  public String m_cServer_sid_invio3;
  public String m_cPhName_tmp_list_imprich;
  public String m_cServer_tmp_list_imprich;
  public String m_cPhName_tmp_listafile;
  public String m_cServer_tmp_listafile;
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
  public java.sql.Date w_a_Data;
  public java.sql.Date w_daData;
  public String w_tipo;
  public String w_flgstp;
  public String w_flganni;
  public String w_protfile;
  public String w_oldinter;
  public java.sql.Date w_datachiu;
  public double _conta;
  public String _errore;
  public MemoryCursor_tmp_stpperiodo mcTemp;
  public MemoryCursorRow_tmp_stpperiodo rowTemp;
  public MemoryCursor_sid_invio mcSID0;
  public MemoryCursorRow_sid_invio rowSID0;
  public MemoryCursor_sid_invio1 mcSID1;
  public MemoryCursorRow_sid_invio1 rowSID1;
  public MemoryCursor_sid_invio2 mcSID2;
  public MemoryCursor_sid_invio2 mcSID2r;
  public MemoryCursorRow_sid_invio2 rowSID2;
  public MemoryCursor_sid_invio3 mcSID3;
  public MemoryCursorRow_sid_invio3 rowSID3;
  public MemoryCursor_sid_invio3 mcSID3r;
  public double _crea;
  public String _invio;
  public MemoryCursor_mcmessaggi_mcrdef _sid;
  public double _max;
  public double _min;
  public double _tot;
  public double _mono;
  public double _contacicli;
  public double _bottom;
  public double _top;
  public double _cicli;
  public double _totrecord;
  public double _reccount;
  public double _contarec;
  public String _oldmsg;
  public double _errori;
  public String _newunq;
  public String cProg;
  public String _annoelb;
  public double _annoini;
  public double _annofin;
  public java.sql.Date _dadata;
  public java.sql.Date _adata;
  public String fhand;
  public String _nomefile;
  public String cNomeFile;
  public String _mese;
  public String _riga;
  public double _tipo1;
  public double _tipo2;
  public double _tipo3;
  public double _tipo4;
  public String _unique;
  public String _cab;
  public String _cfinter;
  public String _cabinter;
  public String _tipoinv;
  public String _tipocom;
  public String _annoc;
  public double _contarighe;
  public String _newuc;
  public double _asaldi;
  public String gMsgImp;
  public String gMsgProc;
  public String gIntemediario;
  public String gAzienda;
  public String gPathApp;
  public java.sql.Date gScadSaldi;
  public String gDescAzi;
  // * --- Area Manuale = BO - Properties
  // * --- arrt_famextra
  public int _r,_aini,_afin;
  // * --- Fine Area Manuale
  public arrt_famextraR (CPContext p_ContextObject, Caller caller) {
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
    CPSecurity.RoutineCallableByProgram("arrt_famextra",m_Caller);
    m_cPhName_aeannora = p_ContextObject.GetPhName("aeannora");
    if (m_cPhName_aeannora.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aeannora = m_cPhName_aeannora+" "+m_Ctx.GetWritePhName("aeannora");
    }
    m_cServer_aeannora = p_ContextObject.GetServer("aeannora");
    m_cPhName_aefaminvio = p_ContextObject.GetPhName("aefaminvio");
    if (m_cPhName_aefaminvio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aefaminvio = m_cPhName_aefaminvio+" "+m_Ctx.GetWritePhName("aefaminvio");
    }
    m_cServer_aefaminvio = p_ContextObject.GetServer("aefaminvio");
    m_cPhName_aesaldi = p_ContextObject.GetPhName("aesaldi");
    if (m_cPhName_aesaldi.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aesaldi = m_cPhName_aesaldi+" "+m_Ctx.GetWritePhName("aesaldi");
    }
    m_cServer_aesaldi = p_ContextObject.GetServer("aesaldi");
    m_cPhName_aetesta = p_ContextObject.GetPhName("aetesta");
    if (m_cPhName_aetesta.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_aetesta = m_cPhName_aetesta+" "+m_Ctx.GetWritePhName("aetesta");
    }
    m_cServer_aetesta = p_ContextObject.GetServer("aetesta");
    m_cPhName_intermbo = p_ContextObject.GetPhName("intermbo");
    if (m_cPhName_intermbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_intermbo = m_cPhName_intermbo+" "+m_Ctx.GetWritePhName("intermbo");
    }
    m_cServer_intermbo = p_ContextObject.GetServer("intermbo");
    m_cPhName_opextrbo = p_ContextObject.GetPhName("opextrbo");
    if (m_cPhName_opextrbo.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_opextrbo = m_cPhName_opextrbo+" "+m_Ctx.GetWritePhName("opextrbo");
    }
    m_cServer_opextrbo = p_ContextObject.GetServer("opextrbo");
    m_cPhName_sid_invio = p_ContextObject.GetPhName("sid_invio");
    if (m_cPhName_sid_invio.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio = m_cPhName_sid_invio+" "+m_Ctx.GetWritePhName("sid_invio");
    }
    m_cServer_sid_invio = p_ContextObject.GetServer("sid_invio");
    m_cPhName_sid_invio1 = p_ContextObject.GetPhName("sid_invio1");
    if (m_cPhName_sid_invio1.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio1 = m_cPhName_sid_invio1+" "+m_Ctx.GetWritePhName("sid_invio1");
    }
    m_cServer_sid_invio1 = p_ContextObject.GetServer("sid_invio1");
    m_cPhName_sid_invio2 = p_ContextObject.GetPhName("sid_invio2");
    if (m_cPhName_sid_invio2.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio2 = m_cPhName_sid_invio2+" "+m_Ctx.GetWritePhName("sid_invio2");
    }
    m_cServer_sid_invio2 = p_ContextObject.GetServer("sid_invio2");
    m_cPhName_sid_invio3 = p_ContextObject.GetPhName("sid_invio3");
    if (m_cPhName_sid_invio3.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
      m_cPhName_sid_invio3 = m_cPhName_sid_invio3+" "+m_Ctx.GetWritePhName("sid_invio3");
    }
    m_cServer_sid_invio3 = p_ContextObject.GetServer("sid_invio3");
    if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
      m_cPhName_tmp_list_imprich = p_ContextObject.GetPhName("tmp_list_imprich");
      if (m_cPhName_tmp_list_imprich.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_list_imprich = m_cPhName_tmp_list_imprich+" "+m_Ctx.GetWritePhName("tmp_list_imprich");
      }
      m_cServer_tmp_list_imprich = p_ContextObject.GetServer("tmp_list_imprich");
    }
    if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
      m_cPhName_tmp_listafile = p_ContextObject.GetPhName("tmp_listafile");
      if (m_cPhName_tmp_listafile.endsWith(CPSecurity.FILTER_QUERY_POSTFIX)) {
        m_cPhName_tmp_listafile = m_cPhName_tmp_listafile+" "+m_Ctx.GetWritePhName("tmp_listafile");
      }
      m_cServer_tmp_listafile = p_ContextObject.GetServer("tmp_listafile");
    }
    Blank();
  }
  public double GetNumber(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      return _conta;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      return _crea;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      return _max;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      return _min;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      return _tot;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      return _mono;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      return _contacicli;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      return _bottom;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      return _top;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      return _cicli;
    }
    if (CPLib.eqr("_totrecord",p_cVarName)) {
      return _totrecord;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      return _reccount;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      return _contarec;
    }
    if (CPLib.eqr("_errori",p_cVarName)) {
      return _errori;
    }
    if (CPLib.eqr("_annoini",p_cVarName)) {
      return _annoini;
    }
    if (CPLib.eqr("_annofin",p_cVarName)) {
      return _annofin;
    }
    if (CPLib.eqr("_tipo1",p_cVarName)) {
      return _tipo1;
    }
    if (CPLib.eqr("_tipo2",p_cVarName)) {
      return _tipo2;
    }
    if (CPLib.eqr("_tipo3",p_cVarName)) {
      return _tipo3;
    }
    if (CPLib.eqr("_tipo4",p_cVarName)) {
      return _tipo4;
    }
    if (CPLib.eqr("_contarighe",p_cVarName)) {
      return _contarighe;
    }
    if (CPLib.eqr("_asaldi",p_cVarName)) {
      return _asaldi;
    }
    return 0;
  }
  public String GetString(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("m_cVQRList",p_cVarName)) {
      return m_cVQRList;
    } else if (CPLib.eqr("i_InvokedRoutines",p_cVarName)) {
      return i_InvokedRoutines;
    } else if (m_bEventRunning && CPLib.eqr("i_EntityName",p_cVarName)) {
      return "arrt_famextra";
    } else if (m_bEventRunning && CPLib.eqr("i_EntityType",p_cVarName)) {
      return "routine";
    }
    if (CPLib.eqr("tipo",p_cVarName)) {
      return w_tipo;
    }
    if (CPLib.eqr("flgstp",p_cVarName)) {
      return w_flgstp;
    }
    if (CPLib.eqr("flganni",p_cVarName)) {
      return w_flganni;
    }
    if (CPLib.eqr("protfile",p_cVarName)) {
      return w_protfile;
    }
    if (CPLib.eqr("oldinter",p_cVarName)) {
      return w_oldinter;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      return _errore;
    }
    if (CPLib.eqr("_invio",p_cVarName)) {
      return _invio;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      return _oldmsg;
    }
    if (CPLib.eqr("_newunq",p_cVarName)) {
      return _newunq;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      return cProg;
    }
    if (CPLib.eqr("_annoelb",p_cVarName)) {
      return _annoelb;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      return fhand;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      return _nomefile;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      return cNomeFile;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      return _mese;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      return _riga;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      return _unique;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      return _cab;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      return _cfinter;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      return _cabinter;
    }
    if (CPLib.eqr("_tipoinv",p_cVarName)) {
      return _tipoinv;
    }
    if (CPLib.eqr("_tipocom",p_cVarName)) {
      return _tipocom;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      return _annoc;
    }
    if (CPLib.eqr("_newuc",p_cVarName)) {
      return _newuc;
    }
    if (CPLib.eqr("gMsgImp",p_cVarName)) {
      return gMsgImp;
    }
    if (CPLib.eqr("gMsgProc",p_cVarName)) {
      return gMsgProc;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      return gDescAzi;
    }
    return "";
  }
  public java.sql.Date GetDate(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("a_Data",p_cVarName)) {
      return w_a_Data;
    }
    if (CPLib.eqr("daData",p_cVarName)) {
      return w_daData;
    }
    if (CPLib.eqr("datachiu",p_cVarName)) {
      return w_datachiu;
    }
    if (CPLib.eqr("_dadata",p_cVarName)) {
      return _dadata;
    }
    if (CPLib.eqr("_adata",p_cVarName)) {
      return _adata;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      return gScadSaldi;
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
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      return mcTemp;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      return mcSID0;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      return mcSID1;
    }
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      return mcSID2;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      return mcSID2r;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      return mcSID3;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      return mcSID3r;
    }
    if (CPLib.eqr("_sid",p_cVarName)) {
      return _sid;
    }
    return null;
  }
  public CPMemoryCursorRow GetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      return rowTemp;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      return rowSID0;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      return rowSID1;
    }
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      return rowSID2;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      return rowSID3;
    }
    return null;
  }
  public com.zucchetti.sitepainter.datatypes.CPJSONStruct GetJSON(String p_cVarName,String p_cType,int len,int dec) {
    return com.zucchetti.sitepainter.datatypes.CPJSONStruct.EmptyStruct();
  }
  public void SetNumber(String p_cVarName,String p_cType,int len,int dec,double value) {
    if (CPLib.eqr("_conta",p_cVarName)) {
      _conta = value;
      return;
    }
    if (CPLib.eqr("_crea",p_cVarName)) {
      _crea = value;
      return;
    }
    if (CPLib.eqr("_max",p_cVarName)) {
      _max = value;
      return;
    }
    if (CPLib.eqr("_min",p_cVarName)) {
      _min = value;
      return;
    }
    if (CPLib.eqr("_tot",p_cVarName)) {
      _tot = value;
      return;
    }
    if (CPLib.eqr("_mono",p_cVarName)) {
      _mono = value;
      return;
    }
    if (CPLib.eqr("_contacicli",p_cVarName)) {
      _contacicli = value;
      return;
    }
    if (CPLib.eqr("_bottom",p_cVarName)) {
      _bottom = value;
      return;
    }
    if (CPLib.eqr("_top",p_cVarName)) {
      _top = value;
      return;
    }
    if (CPLib.eqr("_cicli",p_cVarName)) {
      _cicli = value;
      return;
    }
    if (CPLib.eqr("_totrecord",p_cVarName)) {
      _totrecord = value;
      return;
    }
    if (CPLib.eqr("_reccount",p_cVarName)) {
      _reccount = value;
      return;
    }
    if (CPLib.eqr("_contarec",p_cVarName)) {
      _contarec = value;
      return;
    }
    if (CPLib.eqr("_errori",p_cVarName)) {
      _errori = value;
      return;
    }
    if (CPLib.eqr("_annoini",p_cVarName)) {
      _annoini = value;
      return;
    }
    if (CPLib.eqr("_annofin",p_cVarName)) {
      _annofin = value;
      return;
    }
    if (CPLib.eqr("_tipo1",p_cVarName)) {
      _tipo1 = value;
      return;
    }
    if (CPLib.eqr("_tipo2",p_cVarName)) {
      _tipo2 = value;
      return;
    }
    if (CPLib.eqr("_tipo3",p_cVarName)) {
      _tipo3 = value;
      return;
    }
    if (CPLib.eqr("_tipo4",p_cVarName)) {
      _tipo4 = value;
      return;
    }
    if (CPLib.eqr("_contarighe",p_cVarName)) {
      _contarighe = value;
      return;
    }
    if (CPLib.eqr("_asaldi",p_cVarName)) {
      _asaldi = value;
      return;
    }
  }
  public void SetString(String p_cVarName,String p_cType,int len,int dec,String value) {
    if (CPLib.eqr("tipo",p_cVarName)) {
      w_tipo = value;
      return;
    }
    if (CPLib.eqr("flgstp",p_cVarName)) {
      w_flgstp = value;
      return;
    }
    if (CPLib.eqr("flganni",p_cVarName)) {
      w_flganni = value;
      return;
    }
    if (CPLib.eqr("protfile",p_cVarName)) {
      w_protfile = value;
      return;
    }
    if (CPLib.eqr("oldinter",p_cVarName)) {
      w_oldinter = value;
      return;
    }
    if (CPLib.eqr("_errore",p_cVarName)) {
      _errore = value;
      return;
    }
    if (CPLib.eqr("_invio",p_cVarName)) {
      _invio = value;
      return;
    }
    if (CPLib.eqr("_oldmsg",p_cVarName)) {
      _oldmsg = value;
      return;
    }
    if (CPLib.eqr("_newunq",p_cVarName)) {
      _newunq = value;
      return;
    }
    if (CPLib.eqr("cProg",p_cVarName)) {
      cProg = value;
      return;
    }
    if (CPLib.eqr("_annoelb",p_cVarName)) {
      _annoelb = value;
      return;
    }
    if (CPLib.eqr("fhand",p_cVarName)) {
      fhand = value;
      return;
    }
    if (CPLib.eqr("_nomefile",p_cVarName)) {
      _nomefile = value;
      return;
    }
    if (CPLib.eqr("cNomeFile",p_cVarName)) {
      cNomeFile = value;
      return;
    }
    if (CPLib.eqr("_mese",p_cVarName)) {
      _mese = value;
      return;
    }
    if (CPLib.eqr("_riga",p_cVarName)) {
      _riga = value;
      return;
    }
    if (CPLib.eqr("_unique",p_cVarName)) {
      _unique = value;
      return;
    }
    if (CPLib.eqr("_cab",p_cVarName)) {
      _cab = value;
      return;
    }
    if (CPLib.eqr("_cfinter",p_cVarName)) {
      _cfinter = value;
      return;
    }
    if (CPLib.eqr("_cabinter",p_cVarName)) {
      _cabinter = value;
      return;
    }
    if (CPLib.eqr("_tipoinv",p_cVarName)) {
      _tipoinv = value;
      return;
    }
    if (CPLib.eqr("_tipocom",p_cVarName)) {
      _tipocom = value;
      return;
    }
    if (CPLib.eqr("_annoc",p_cVarName)) {
      _annoc = value;
      return;
    }
    if (CPLib.eqr("_newuc",p_cVarName)) {
      _newuc = value;
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
    if (CPLib.eqr("gDescAzi",p_cVarName)) {
      gDescAzi = value;
      return;
    }
  }
  public void SetDate(String p_cVarName,String p_cType,int len,int dec,java.sql.Date value) {
    if (CPLib.eqr("a_Data",p_cVarName)) {
      w_a_Data = value;
      return;
    }
    if (CPLib.eqr("daData",p_cVarName)) {
      w_daData = value;
      return;
    }
    if (CPLib.eqr("datachiu",p_cVarName)) {
      w_datachiu = value;
      return;
    }
    if (CPLib.eqr("_dadata",p_cVarName)) {
      _dadata = value;
      return;
    }
    if (CPLib.eqr("_adata",p_cVarName)) {
      _adata = value;
      return;
    }
    if (CPLib.eqr("gScadSaldi",p_cVarName)) {
      gScadSaldi = value;
      return;
    }
  }
  public void SetDateTime(String p_cVarName,String p_cType,int len,int dec,java.sql.Timestamp value) {
  }
  public void SetLogic(String p_cVarName,String p_cType,int len,int dec,boolean value) {
  }
  public void SetMemoryCursorRow(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursorRow value) {
    if (CPLib.eqr("rowTemp",p_cVarName)) {
      rowTemp = (MemoryCursorRow_tmp_stpperiodo)value;
      return;
    }
    if (CPLib.eqr("rowSID0",p_cVarName)) {
      rowSID0 = (MemoryCursorRow_sid_invio)value;
      return;
    }
    if (CPLib.eqr("rowSID1",p_cVarName)) {
      rowSID1 = (MemoryCursorRow_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("rowSID2",p_cVarName)) {
      rowSID2 = (MemoryCursorRow_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("rowSID3",p_cVarName)) {
      rowSID3 = (MemoryCursorRow_sid_invio3)value;
      return;
    }
  }
  public void SetMemoryCursor(String p_cVarName,String p_cType,int len,int dec,CPMemoryCursor value) {
    if (CPLib.eqr("mcTemp",p_cVarName)) {
      mcTemp = (MemoryCursor_tmp_stpperiodo)value;
      return;
    }
    if (CPLib.eqr("mcSID0",p_cVarName)) {
      mcSID0 = (MemoryCursor_sid_invio)value;
      return;
    }
    if (CPLib.eqr("mcSID1",p_cVarName)) {
      mcSID1 = (MemoryCursor_sid_invio1)value;
      return;
    }
    if (CPLib.eqr("mcSID2",p_cVarName)) {
      mcSID2 = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcSID2r",p_cVarName)) {
      mcSID2r = (MemoryCursor_sid_invio2)value;
      return;
    }
    if (CPLib.eqr("mcSID3",p_cVarName)) {
      mcSID3 = (MemoryCursor_sid_invio3)value;
      return;
    }
    if (CPLib.eqr("mcSID3r",p_cVarName)) {
      mcSID3r = (MemoryCursor_sid_invio3)value;
      return;
    }
    if (CPLib.eqr("_sid",p_cVarName)) {
      _sid = (MemoryCursor_mcmessaggi_mcrdef)value;
      return;
    }
  }
  public void SetJSON(String p_cVarName,String p_cType,int len,int dec,com.zucchetti.sitepainter.datatypes.CPJSONStruct value) {
  }
  public void CalledBatchEnd() {
  }
  void Page_1() throws Exception {
    /* w_a_Data Date // Inizio Periodo */
    /* w_daData Date // Fine Periodo */
    /* w_tipo Char(1) // Tipo Elaborazione */
    /* w_flgstp Char(1) // Non preparare stampa */
    /* w_flganni Char(1) // Spezza su più anni */
    /* w_protfile Char(24) // Protocollo */
    /* w_oldinter Char(16) // Vecchio Intermediario */
    /* w_datachiu Date // Chiusura Generalizzata Rapporti */
    /* _conta Numeric(10, 0) */
    /* _errore Memo */
    /* mcTemp MemoryCursor(tmp_stpperiodo) */
    /* rowTemp Row(tmp_stpperiodo) */
    /* mcSID0 MemoryCursor(sid_invio) */
    /* rowSID0 Row(sid_invio) */
    /* mcSID1 MemoryCursor(sid_invio1) */
    /* rowSID1 Row(sid_invio1) */
    /* mcSID2 MemoryCursor(sid_invio2) */
    /* mcSID2r MemoryCursor(sid_invio2) */
    /* rowSID2 Row(sid_invio2) */
    /* mcSID3 MemoryCursor(sid_invio3) */
    /* rowSID3 Row(sid_invio3) */
    /* mcSID3r MemoryCursor(sid_invio3) */
    /* _crea Numeric(1, 0) */
    /* _invio Char(10) */
    /* _sid MemoryCursor(mcMessaggi.MCRDef) */
    /* _max Numeric(15, 0) */
    /* _min Numeric(15, 0) */
    /* _tot Numeric(15, 0) */
    /* _mono Numeric(1, 0) */
    /* _contacicli Numeric(15, 0) */
    /* _bottom Numeric(15, 0) */
    /* _top Numeric(15, 0) */
    /* _cicli Numeric(15, 0) */
    /* _totrecord Numeric(10, 0) */
    /* _reccount Numeric(15, 0) */
    /* _contarec Numeric(15, 0) */
    /* _oldmsg Memo */
    /* _errori Numeric(10, 0) */
    /* _newunq Char(1) */
    /* cProg Char(10) */
    /* _annoelb Char(4) */
    /* _annoini Numeric(4, 0) */
    /* _annofin Numeric(4, 0) */
    /* _dadata Date */
    /* _adata Date */
    /* fhand Char(10) */
    /* _nomefile Char(10) */
    /* cNomeFile Char(100) */
    /* _mese Char(2) */
    /* _riga Char(398) */
    /* _tipo1 Numeric(9, 0) */
    /* _tipo2 Numeric(9, 0) */
    /* _tipo3 Numeric(9, 0) */
    /* _tipo4 Numeric(9, 0) */
    /* _unique Char(50) */
    /* _cab Char(5) */
    /* _cfinter Char(16) */
    /* _cabinter Char(5) */
    /* _tipoinv Char(1) */
    /* _tipocom Char(1) */
    /* _annoc Char(4) */
    /* _contarighe Numeric(10, 0) */
    /* _newuc Char(1) */
    /* _asaldi Numeric(4, 0) */
    /* gMsgImp Char(120) // Messaggio Import */
    /* gMsgProc Memo // Messaggio */
    /* gIntemediario Char(11) // Intermediario */
    /* gAzienda Char(10) // Azienda */
    /* gPathApp Char(80) // Path Applicazione */
    /* gScadSaldi Date // Scadenza Invio Saldi */
    /* gDescAzi Char(70) // Descrizione Intermediario */
    // * --- Drop temporary table tmp_listafile
    if (m_Ctx.IsSharedTemp("tmp_listafile")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
        m_cServer = m_Ctx.GetServer("tmp_listafile");
        m_cPhName = m_Ctx.GetPhName("tmp_listafile");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_listafile");
    }
    // * --- Drop temporary table tmp_list_imprich
    if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_list_imprich");
    }
    // * --- Create temporary table tmp_listafile
    if (m_Ctx.IsSharedTemp("tmp_listafile")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_listafile")) {
        m_cServer = m_Ctx.GetServer("tmp_listafile");
        m_cPhName = m_Ctx.GetPhName("tmp_listafile");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_listafile");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_listafile");
    if ( ! (m_Ctx.IsSharedTemp("tmp_listafile"))) {
      m_cServer = m_Ctx.GetServer("tmp_listafile");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_listafile",m_cServer,"proto")),m_cPhName,"tmp_listafile",m_Ctx);
    }
    m_cPhName_tmp_listafile = m_cPhName;
    // * --- Create temporary table tmp_list_imprich
    if (m_Ctx.IsSharedTemp("tmp_list_imprich")) {
      if (m_Ctx.IsTmpAlreadyCreated("tmp_list_imprich")) {
        m_cServer = m_Ctx.GetServer("tmp_list_imprich");
        m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
        m_cSql = "delete from "+m_cPhName+" where context_id='"+m_Ctx.GetTempID()+"'";
        m_nUpdatedRows = m_Sql.Update(m_cServer,m_cSql);
      }
    } else {
      m_Ctx.DropTmp("tmp_list_imprich");
    }
    m_cPhName = m_Ctx.CreateTmpPhName("tmp_list_imprich");
    if ( ! (m_Ctx.IsSharedTemp("tmp_list_imprich"))) {
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_Sql.SrvQuery(m_cServer,"* ","from "+m_Ctx.PhNameAdapter(m_Sql.ManipulateTablePhName("tmp_list_imprich",m_cServer,"proto")),m_cPhName,"tmp_list_imprich",m_Ctx);
    }
    m_cPhName_tmp_list_imprich = m_cPhName;
    /* gMsgProc := 'Ora Inizio Elaborazione Extra:'+arfn_fdatetime(DateTime()) + NL // Messaggio */
    gMsgProc = "Ora Inizio Elaborazione Extra:"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    // Begin Transaction
    m_Sql.RequireTransaction();
    double nTry00000054status;
    nTry00000054status = m_Sql.GetTransactionStatus();
    String cTry00000054msg;
    cTry00000054msg = m_Sql.TransactionErrorMessage();
    try {
      /* Case w_tipo='R' */
      if (CPLib.eqr(w_tipo,"R")) {
        /* _annoc := '0000' */
        _annoc = "0000";
        /* _mese := '00' */
        _mese = "00";
        /* gMsgProc := gMsgProc + 'Ora Inizio Generazione File Reimpianto: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio Generazione File Reimpianto: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If w_flganni = 'S' */
        if (CPLib.eqr(w_flganni,"S")) {
          /* _annoini := Year(w_daData) */
          _annoini = CPLib.Round(CPLib.Year(w_daData),0);
          /* _annofin := Year(w_a_Data) + 1 */
          _annofin = CPLib.Round(CPLib.Year(w_a_Data)+1,0);
          // Crea variabili intere per ciclo
          _aini = (int)_annoini;
          _afin = (int)_annofin;
          for (int _anno = _aini; CPLib.ne(_anno,_afin); _anno = _anno + (1)) {
            /* _annoelb := Str(_anno,4,0) */
            _annoelb = CPLib.Str(_anno,4,0);
            /* _dadata := CharToDate(Str(_anno,4,0)+"0101") */
            _dadata = CPLib.CharToDate(CPLib.Str(_anno,4,0)+"0101");
            /* _adata := iif(_anno<(_annofin - 1),CharToDate(Str(_anno,4,0)+"1231"),w_a_Data) */
            _adata = (CPLib.lt(_anno,(_annofin-1))?CPLib.CharToDate(CPLib.Str(_anno,4,0)+"1231"):w_a_Data);
            /* Exec "Reimpianto" Page 2:Page_2 */
            Page_2();
            if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
              throw new RoutineException();
            }
            // * --- Insert into aesaldi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aesaldi");
            m_cPhName = m_Ctx.GetPhName("aesaldi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000062")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000062(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,50),"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_annoc,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_mese,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipoinv,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_tipocom,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aesaldi",true);
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
            /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione SID File con protocollo '+w_protfile+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
            gMsgProc = gMsgProc+"Ora Inizio Elaborazione SID File con protocollo "+w_protfile+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* _sid := arfn_exec_sid(_nomefile,_annoc) */
            _sid = arfn_exec_sidR.Make(m_Ctx,this).Run(_nomefile,_annoc);
            /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione SID File con protocollo '+w_protfile+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
            gMsgProc = gMsgProc+"Ora Fine Elaborazione SID File con protocollo "+w_protfile+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
            /* If _sid.RecCount() > 0 */
            if (CPLib.gt(_sid.RecCount(),0)) {
              for (MemoryCursorRow_mcmessaggi_mcrdef rowErrore : _sid._iterable_()) {
                /* gMsgProc := gMsgProc + LRTrim(rowErrore.testata) + NL // Messaggio */
                gMsgProc = gMsgProc+CPLib.LRTrim(rowErrore.testata)+"\n";
                m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
              }
              // Transaction Error
              cTry00000054msg = CPLib.FormatMsg(m_Ctx,"'Rilevati errori durante il controllo da parte del SID'");
              m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'Rilevati errori durante il controllo da parte del SID'"));
              throw new RoutineException(CPLib.FormatMsg(m_Ctx,"'Rilevati errori durante il controllo da parte del SID'"));
            } else { // Else
              // * --- Delete from sid_invio3
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio3");
              m_cPhName = m_Ctx.GetPhName("sid_invio3");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000006B")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODINVIO3 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
              // * --- Delete from sid_invio2
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio2");
              m_cPhName = m_Ctx.GetPhName("sid_invio2");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000006C")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODINVIO2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
              // * --- Delete from sid_invio1
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio1");
              m_cPhName = m_Ctx.GetPhName("sid_invio1");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000006D")+"delete from "+m_oWrInfo.GetTableWriteName();
              m_cSql = m_cSql+" where ";
              m_cSql = m_cSql+"CODINVIO1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
              for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
                // * --- Insert into sid_invio1 from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("sid_invio1");
                m_cPhName = m_Ctx.GetPhName("sid_invio1");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000006F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_0000006F(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.CODINVIO1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPRINVIO1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.INIINVIO1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.FININVIO1,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TIPINVIO1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPCINVIO1,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.MODINVIO1,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio1",true);
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
                /* If rowSID1.TPRINVIO1='98' */
                if (CPLib.eqr(rowSID1.TPRINVIO1,"98")) {
                  /* gMsgImp := "Sto aggiornando l'operazione con codice: "+rowSID1.RAPINVIO1 // Messaggio Import */
                  gMsgImp = "Sto aggiornando l'operazione con codice: "+rowSID1.RAPINVIO1;
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  // * --- Write into opextrbo from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("opextrbo");
                  m_cPhName = m_Ctx.GetPhName("opextrbo");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000072")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                  m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                  m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(rowSID1.UNIQUE1,"C",50,0,m_cServer)+", ";
                  m_cSql = m_cSql+"OLDUNIQUE = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer),m_cServer,rowSID1.RAPINVIO1)+"";
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
                } else { // Else
                  /* gMsgImp := "Sto aggiornando il rapporto: "+rowSID1.RAPINVIO1 // Messaggio Import */
                  gMsgImp = "Sto aggiornando il rapporto: "+rowSID1.RAPINVIO1;
                  m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                  // * --- Write into aetesta from values
                  m_Sql.RequireTransaction();
                  m_cServer = m_Ctx.GetServer("aetesta");
                  m_cPhName = m_Ctx.GetPhName("aetesta");
                  m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                  m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                  m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000074")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                  m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                  m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                  m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                  m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(rowSID1.UNIQUE1,"C",50,0,m_cServer)+", ";
                  m_cSql = m_cSql+"OLDUNIQUE = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
                  m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(rowSID1.UNIQUE1,"C",50,0,m_cServer)+", ";
                  m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                  m_cSql = m_cSql+" where ";
                  m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer),m_cServer,rowSID1.RAPINVIO1)+"";
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
              }
              for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2._iterable_()) {
                // * --- Insert into sid_invio2 from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("sid_invio2");
                m_cPhName = m_Ctx.GetPhName("sid_invio2");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000076")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000076(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CODINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RAPINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.APRINVIO2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.INIINVIO2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FININVIO2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FCFINVIO2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CFSINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RUOINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.COGINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.NOMINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.DNSINVIO2,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CNSINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PNSINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RGSINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CSLINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PLSINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.SEXINVIO2,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio2",true);
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
              }
              for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3._iterable_()) {
                // * --- Insert into sid_invio3 from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("sid_invio3");
                m_cPhName = m_Ctx.GetPhName("sid_invio3");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000078")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
                m_cSql = m_cSql+GetFieldsName_00000078(m_Ctx,m_oWrInfo);
                m_cSql = m_cSql+") values (";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.CODINVIO3,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.TPRINVIO3,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.ANNINVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.VALINVIO3,"?",0,0,m_cServer)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM1INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI1INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM2INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI2INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM3INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI3INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM4INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI4INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM5INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI5INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM6INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI6INVIO3,"?",0,0)+", ";
                m_cSql = m_cSql+m_oWrInfo.InsertValues();
                m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio3",true);
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
              }
            } // End If
          }
        } else { // Else
          /* _dadata := w_daData */
          _dadata = w_daData;
          /* _adata := w_a_Data */
          _adata = w_a_Data;
          /* Exec "Reimpianto" Page 2:Page_2 */
          Page_2();
          if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
            throw new RoutineException();
          }
        } // End If
        /* gMsgProc := gMsgProc + 'Ora Fine Generazione File Reimpianto: '+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine Generazione File Reimpianto: "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Case w_tipo='C' */
      } else if (CPLib.eqr(w_tipo,"C")) {
        /* Exec "Cambio Identificativo" Page 3:Page_3 */
        Page_3();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* Case w_tipo='P' */
      } else if (CPLib.eqr(w_tipo,"P")) {
        /* _annoc := Str(Year(Date()),4,0) */
        _annoc = CPLib.Str(CPLib.Year(CPLib.Date()),4,0);
        /* _mese := Right('0'+LRTrim(Str(Month(Date()),2,0)),2) */
        _mese = CPLib.Right("0"+CPLib.LRTrim(CPLib.Str(CPLib.Month(CPLib.Date()),2,0)),2);
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione Presa in carico da '+LRTrim(w_oldinter)+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione Presa in carico da "+CPLib.LRTrim(w_oldinter)+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Exec "Presa in Carico" Page 4:Page_4 */
        Page_4();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione Presa in carico da '+LRTrim(w_oldinter)+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione Presa in carico da "+CPLib.LRTrim(w_oldinter)+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Case w_tipo='A' */
      } else if (CPLib.eqr(w_tipo,"A")) {
        /* _annoc := Str(Year(Date()),4,0) */
        _annoc = CPLib.Str(CPLib.Year(CPLib.Date()),4,0);
        /* _mese := Right('0'+LRTrim(Str(Month(Date()),2,0)),2) */
        _mese = CPLib.Right("0"+CPLib.LRTrim(CPLib.Str(CPLib.Month(CPLib.Date()),2,0)),2);
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione Annullamento File con protocollo '+w_protfile+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione Annullamento File con protocollo "+w_protfile+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Exec "Annullamento" Page 5:Page_5 */
        Page_5();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione Annullamento File con protocollo '+w_protfile+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione Annullamento File con protocollo "+w_protfile+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* Case w_tipo='G' */
      } else if (CPLib.eqr(w_tipo,"G")) {
        /* _annoc := '0000' */
        _annoc = "0000";
        /* _mese := '00' */
        _mese = "00";
        /* Exec "Chiusura Generalizzata Rapporti" Page 6:Page_6 */
        Page_6();
        if ( ! (CPLib.Empty(m_Sql.TransactionErrorMessage()))) {
          throw new RoutineException();
        }
      } // End Case
      /* If w_flganni <> 'S' */
      if (CPLib.ne(w_flganni,"S")) {
        // * --- Insert into aesaldi from values
        m_Sql.RequireTransaction();
        m_cServer = m_Ctx.GetServer("aesaldi");
        m_cPhName = m_Ctx.GetPhName("aesaldi");
        m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
        m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
        m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000008C")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
        m_cSql = m_cSql+GetFieldsName_0000008C(m_Ctx,m_oWrInfo);
        m_cSql = m_cSql+") values (";
        m_cSql = m_cSql+""+CPLib.ToSQL(LibreriaMit.UniqueId(),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Left(_nomefile,50),"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_annoc,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_mese,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipoinv,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_tipocom,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
        m_cSql = m_cSql+m_oWrInfo.InsertValues();
        m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aesaldi",true);
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
        /* gMsgProc := gMsgProc + 'Ora Inizio Elaborazione SID File con protocollo '+w_protfile+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Inizio Elaborazione SID File con protocollo "+w_protfile+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* _sid := arfn_exec_sid(_nomefile,_annoc) */
        _sid = arfn_exec_sidR.Make(m_Ctx,this).Run(_nomefile,_annoc);
        /* gMsgProc := gMsgProc + 'Ora Fine Elaborazione SID File con protocollo '+w_protfile+": "+arfn_fdatetime(DateTime())+NL // Messaggio */
        gMsgProc = gMsgProc+"Ora Fine Elaborazione SID File con protocollo "+w_protfile+": "+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime())+"\n";
        m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        /* If _sid.RecCount() > 0 */
        if (CPLib.gt(_sid.RecCount(),0)) {
          for (MemoryCursorRow_mcmessaggi_mcrdef rowErrore : _sid._iterable_()) {
            /* gMsgProc := gMsgProc + LRTrim(rowErrore.testata) + NL // Messaggio */
            gMsgProc = gMsgProc+CPLib.LRTrim(rowErrore.testata)+"\n";
            m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
          }
          // Transaction Error
          cTry00000054msg = CPLib.FormatMsg(m_Ctx,"'Rilevati errori durante il controllo da parte del SID'");
          m_Sql.AbortTransactionMarkExplicit(CPLib.FormatMsg(m_Ctx,"'Rilevati errori durante il controllo da parte del SID'"));
          throw new RoutineException(CPLib.FormatMsg(m_Ctx,"'Rilevati errori durante il controllo da parte del SID'"));
        } else { // Else
          /* Case w_tipo='R' */
          if (CPLib.eqr(w_tipo,"R")) {
            // * --- Delete from sid_invio3
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sid_invio3");
            m_cPhName = m_Ctx.GetPhName("sid_invio3");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000096")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODINVIO3 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
            // * --- Delete from sid_invio2
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sid_invio2");
            m_cPhName = m_Ctx.GetPhName("sid_invio2");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000097")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODINVIO2 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
            // * --- Delete from sid_invio1
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("sid_invio1");
            m_cPhName = m_Ctx.GetPhName("sid_invio1");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000098")+"delete from "+m_oWrInfo.GetTableWriteName();
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"CODINVIO1 = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
            for (MemoryCursorRow_sid_invio1 rowSID1 : mcSID1._iterable_()) {
              // * --- Insert into sid_invio1 from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio1");
              m_cPhName = m_Ctx.GetPhName("sid_invio1");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio1",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000009A")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_0000009A(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.CODINVIO1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPRINVIO1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.INIINVIO1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.FININVIO1,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TIPINVIO1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.TPCINVIO1,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID1.MODINVIO1,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio1",true);
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
              /* If rowSID1.TPRINVIO1='98' */
              if (CPLib.eqr(rowSID1.TPRINVIO1,"98")) {
                /* gMsgImp := "Sto aggiornando l'operazione con codice: "+rowSID1.RAPINVIO1 // Messaggio Import */
                gMsgImp = "Sto aggiornando l'operazione con codice: "+rowSID1.RAPINVIO1;
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                // * --- Write into opextrbo from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("opextrbo");
                m_cPhName = m_Ctx.GetPhName("opextrbo");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"opextrbo",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000009D")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(rowSID1.UNIQUE1,"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"OLDUNIQUE = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"opextrbo",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer),m_cServer,rowSID1.RAPINVIO1)+"";
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
              } else { // Else
                /* gMsgImp := "Sto aggiornando il rapporto: "+rowSID1.RAPINVIO1 // Messaggio Import */
                gMsgImp = "Sto aggiornando il rapporto: "+rowSID1.RAPINVIO1;
                m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
                // * --- Write into aetesta from values
                m_Sql.RequireTransaction();
                m_cServer = m_Ctx.GetServer("aetesta");
                m_cPhName = m_Ctx.GetPhName("aetesta");
                m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aetesta",m_Ctx.GetCompany());
                m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
                m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000009F")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
                m_cSql = m_cSql+"DATAMODI = "+CPLib.ToSQL(CPLib.NullDate(),"D",8,0)+", ";
                m_cSql = m_cSql+"INVIATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
                m_cSql = m_cSql+"DATAINVIO = "+CPLib.ToSQL(CPLib.Date(),"D",8,0)+", ";
                m_cSql = m_cSql+"UNIQUER = "+CPLib.ToSQL(rowSID1.UNIQUE1,"C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"OLDUNIQUE = "+CPLib.ToSQL("","C",50,0,m_cServer)+", ";
                m_cSql = m_cSql+"UNIQUECODE = "+CPLib.ToSQL(rowSID1.UNIQUE1,"C",50,0,m_cServer)+", ";
                m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aetesta",false,true);
                m_cSql = m_cSql+" where ";
                m_cSql = m_cSql+"RAPPORTO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(rowSID1.RAPINVIO1,"?",0,0,m_cServer),m_cServer,rowSID1.RAPINVIO1)+"";
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
            }
            for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2._iterable_()) {
              // * --- Insert into sid_invio2 from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio2");
              m_cPhName = m_Ctx.GetPhName("sid_invio2");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio2",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000000A1")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000A1(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CODINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RAPINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.APRINVIO2,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.INIINVIO2,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FININVIO2,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.FCFINVIO2,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CFSINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RUOINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.COGINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.NOMINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.DNSINVIO2,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CNSINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PNSINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.RGSINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.CSLINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.PLSINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID2.SEXINVIO2,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio2",true);
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
            }
            for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3._iterable_()) {
              // * --- Insert into sid_invio3 from values
              m_Sql.RequireTransaction();
              m_cServer = m_Ctx.GetServer("sid_invio3");
              m_cPhName = m_Ctx.GetPhName("sid_invio3");
              m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio3",m_Ctx.GetCompany());
              m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
              m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000000A3")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
              m_cSql = m_cSql+GetFieldsName_000000A3(m_Ctx,m_oWrInfo);
              m_cSql = m_cSql+") values (";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.CODINVIO3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.RAPINVIO3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.TPRINVIO3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.ANNINVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.VALINVIO3,"?",0,0,m_cServer)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM1INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI1INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM2INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI2INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM3INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI3INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM4INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI4INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM5INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI5INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.IM6INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+""+CPLib.ToSQL(rowSID3.FI6INVIO3,"?",0,0)+", ";
              m_cSql = m_cSql+m_oWrInfo.InsertValues();
              m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio3",true);
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
            }
            /* Case w_tipo='P' */
          } else if (CPLib.eqr(w_tipo,"P")) {
            /* Case w_tipo='A' */
          } else if (CPLib.eqr(w_tipo,"A")) {
            // * --- Write into aesaldi from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aesaldi");
            m_cPhName = m_Ctx.GetPhName("aesaldi");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aesaldi",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000000A4")+"Update "+m_oWrInfo.GetTableWriteName()+" set ";
            m_cSql = m_cSql+"ANNULLATO = "+CPLib.ToSQL(1,"N",1,0)+", ";
            m_cSql = CPLib.AddCPCCCHKUpdate(m_Ctx,m_cSql,"aesaldi",false,true);
            m_cSql = m_cSql+" where ";
            m_cSql = m_cSql+"PROTOCOLLO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(w_protfile,"?",0,0,m_cServer),m_cServer,w_protfile)+"";
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
          } // End Case
        } // End If
      } // End If
      // Commit
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      if (CPLib.ne(m_cLastMsgError,"")) {
        m_bError = true;
      }
      m_Sql.CompleteTransaction();
      /* gMsgImp := "Elaborazione Terminata. Premere il tasto con la lente per prelevare il file" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata. Premere il tasto con la lente per prelevare il file";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } catch(Exception l_exeption) {
      Stop.ReactToException(l_exeption);
      // Rollback
      m_Sql.AbortTransaction();
      m_cLastMsgError = m_Sql.TransactionErrorMessage();
      m_bError = true;
      m_Sql.CompleteTransaction();
      /* gMsgImp := "Elaborazione Terminata con errori. Consultare l'assistenza" // Messaggio Import */
      gMsgImp = "Elaborazione Terminata con errori. Consultare l'assistenza";
      m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
    } finally {
      if (CPLib.eqr(m_Sql.GetTransactionStatus(),0) || CPLib.ne(nTry00000054status,0)) {
        m_Sql.SetTransactionStatus(nTry00000054status,cTry00000054msg);
      }
    }
    /* gMsgProc := gMsgProc + 'Ora Fine  Elaborazione Extra:'+arfn_fdatetime(DateTime()) // Messaggio */
    gMsgProc = gMsgProc+"Ora Fine  Elaborazione Extra:"+arfn_fdatetimeR.Make(m_Ctx,this).Run(CPLib.DateTime());
    m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
  }
  void Page_2() throws Exception {
    CPResultSet Cursor_qbe_famreimp_opx_minmax=null;
    CPResultSet Cursor_intermbo=null;
    CPResultSet Cursor_qbe_fam_reimpianto_opx=null;
    VQRHolder l_VQRHolder = null;
    try {
      /* _tipoinv := '2' */
      _tipoinv = "2";
      /* _tipocom := '6' */
      _tipocom = "6";
      /* _max := 0 */
      _max = CPLib.Round(0,0);
      /* _min := 0 */
      _min = CPLib.Round(0,0);
      /* _tot := 0 */
      _tot = CPLib.Round(0,0);
      /* _mono := 0 */
      _mono = CPLib.Round(0,0);
      /* _contarighe := 1 */
      _contarighe = CPLib.Round(1,0);
      /* _conta := 0 // _conta */
      _conta = CPLib.Round(0,0);
      // * --- Select from qbe_famreimp_opx_minmax
      SPBridge.HMCaller _h000000B3;
      _h000000B3 = new SPBridge.HMCaller();
      _h000000B3.Set("m_cVQRList",m_cVQRList);
      _h000000B3.Set("_dadata",_dadata);
      _h000000B3.Set("_adata",_adata);
      if (Cursor_qbe_famreimp_opx_minmax!=null)
        Cursor_qbe_famreimp_opx_minmax.Close();
      Cursor_qbe_famreimp_opx_minmax = new VQRHolder("qbe_famreimp_opx_minmax",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h000000B3,true).GetResultSet(m_Ctx);
      while ( ! (Cursor_qbe_famreimp_opx_minmax.Eof())) {
        /* _min := qbe_famreimp_opx_minmax->MINPRG */
        _min = CPLib.Round(Cursor_qbe_famreimp_opx_minmax.GetDouble("MINPRG"),0);
        /* _max := qbe_famreimp_opx_minmax->MAXPRG */
        _max = CPLib.Round(Cursor_qbe_famreimp_opx_minmax.GetDouble("MAXPRG"),0);
        /* _tot := qbe_famreimp_opx_minmax->TOTPRG */
        _tot = CPLib.Round(Cursor_qbe_famreimp_opx_minmax.GetDouble("TOTPRG"),0);
        Cursor_qbe_famreimp_opx_minmax.Next();
      }
      m_cConnectivityError = Cursor_qbe_famreimp_opx_minmax.ErrorMessage();
      Cursor_qbe_famreimp_opx_minmax.Close();
      // * --- End Select
      /* _mono := iif(_tot > 15000,0,1) */
      _mono = CPLib.Round((CPLib.gt(_tot,15000)?0:1),0);
      /* If _mono = 1 */
      if (CPLib.eqr(_mono,1)) {
        /* If _tot = 0 */
        if (CPLib.eqr(_tot,0)) {
          /* _cicli := 0 */
          _cicli = CPLib.Round(0,0);
        } else { // Else
          /* _cicli := 1 */
          _cicli = CPLib.Round(1,0);
        } // End If
      } else { // Else
        /* _reccount := _max - _min */
        _reccount = CPLib.Round(_max-_min,0);
        /* _cicli := iif(Mod(_reccount,5000) <> 0,Int(_reccount/5000) + 1,Int(_reccount/5000)) */
        _cicli = CPLib.Round((CPLib.ne(CPLib.Mod(_reccount,5000),0)?CPLib.Int(_reccount/5000)+1:CPLib.Int(_reccount/5000)),0);
      } // End If
      /* _contacicli := 1 */
      _contacicli = CPLib.Round(1,0);
      /* _oldmsg := '' */
      _oldmsg = "";
      /* _contarec := _reccount */
      _contarec = CPLib.Round(_reccount,0);
      /* mcSID0.Zap() */
      mcSID0.Zap();
      /* mcSID1.Zap() */
      mcSID1.Zap();
      /* mcSID2.Zap() */
      mcSID2.Zap();
      /* mcSID2r.Zap() */
      mcSID2r.Zap();
      /* mcSID3.Zap() */
      mcSID3.Zap();
      /* mcSID3r.Zap() */
      mcSID3r.Zap();
      /* _tipo1 := 0 */
      _tipo1 = CPLib.Round(0,0);
      /* _tipo2 := 0 */
      _tipo2 = CPLib.Round(0,0);
      /* _tipo3 := 0 */
      _tipo3 = CPLib.Round(0,0);
      /* _tipo4 := 0 */
      _tipo4 = CPLib.Round(0,0);
      /* _invio := _annoc+_mese+'_2_6' */
      _invio = _annoc+_mese+"_2_6";
      /* _nomefile := LRTrim(gIntemediario)+"_"+_invio+"_"+iif(w_flganni='S',_annoelb+"_","")+DateTimeToChar(DateTime()) */
      _nomefile = CPLib.LRTrim(gIntemediario)+"_"+_invio+"_"+(CPLib.eqr(w_flganni,"S")?_annoelb+"_":"")+CPLib.DateTimeToChar(CPLib.DateTime());
      /* fhand := FileLibMit.OpenWrite('/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWrite("/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      // * --- Insert into tmp_list_imprich from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000000D0")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000D0(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
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
      /* rowSID0.CODINVIO := _invio */
      rowSID0.CODINVIO = _invio;
      /* rowSID0.TIPINVIO := '2' */
      rowSID0.TIPINVIO = "2";
      /* rowSID0.TPCINVIO := '6' */
      rowSID0.TPCINVIO = "6";
      /* rowSID0.ANNINVIO := _annoc */
      rowSID0.ANNINVIO = _annoc;
      /* rowSID0.MESINVIO := _mese */
      rowSID0.MESINVIO = _mese;
      /* rowSID0.FLEINVIO := _nomefile */
      rowSID0.FLEINVIO = _nomefile;
      /* mcSID0.AppendRow(rowSID0) */
      mcSID0.AppendRow(rowSID0);
      // * --- Delete from sid_invio
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sid_invio");
      m_cPhName = m_Ctx.GetPhName("sid_invio");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000000D9")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINVIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
      // * --- Insert into sid_invio from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sid_invio");
      m_cPhName = m_Ctx.GetPhName("sid_invio");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000000DA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000000DA(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("0000","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("00","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio",true);
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
      /* _crea := 1 */
      _crea = CPLib.Round(1,0);
      /* _riga := '0' */
      _riga = "0";
      /* _riga := _riga + 'ARU00' */
      _riga = _riga+"ARU00";
      /* _riga := _riga + '2' */
      _riga = _riga+"2";
      /* _riga := _riga + '6' */
      _riga = _riga+"6";
      /* _riga := _riga + '0000' */
      _riga = _riga+"0000";
      /* _riga := _riga + '00' */
      _riga = _riga+"00";
      /* _riga := _riga + Space(24) */
      _riga = _riga+CPLib.Space(24);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _riga := _riga + LibreriaMit.SpacePad(Upper(LRTrim(intermbo->CODFISC)),16) */
        _riga = _riga+LibreriaMit.SpacePad(CPLib.Upper(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16);
        /* _cfinter := LRTrim(intermbo->CODFISC) */
        _cfinter = CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"));
        /* _cabinter := Left(LRTrim(intermbo->CODCAB),5) */
        _cabinter = CPLib.Left(CPLib.LRTrim(Cursor_intermbo.GetString("CODCAB")),5);
        /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->COGNOME,26) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("COGNOME"),26);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NOME,25) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NOME"),25);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->SESSO,1) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("SESSO"),1);
          /* _riga := _riga +arfn_fdate_nd(intermbo->DATANASC,'N') // Invio Ordinario */
          _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_intermbo.GetDate("DATANASC"),"N");
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NASCOMUN,40) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NASCOMUN"),40);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVNA,2) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVNA"),2);
          /* _riga := _riga +Space(112) // Invio Ordinario */
          _riga = _riga+CPLib.Space(112);
        } else { // Else
          /* _riga := _riga +Space(102) // Invio Ordinario */
          _riga = _riga+CPLib.Space(102);
          /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->RAGSOC,' '),70) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("RAGSOC")," "),70);
          /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->DESCCIT,' '),40) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("DESCCIT")," "),40);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVINCIA,2) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
        } // End If
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _riga := _riga +Space(16) // Invio Ordinario */
      _riga = _riga+CPLib.Space(16);
      /* _riga := _riga +'0' // Invio Ordinario */
      _riga = _riga+"0";
      /* _riga := _riga + Space(112) // Invio Ordinario */
      _riga = _riga+CPLib.Space(112);
      /* _riga := _riga + 'A' + LibreriaMit.CloseLine() // Invio Ordinario */
      _riga = _riga+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* While _contacicli <= _cicli */
      while (CPLib.le(_contacicli,_cicli)) {
        /* If _mono = 1 */
        if (CPLib.eqr(_mono,1)) {
          /* _bottom := _min */
          _bottom = CPLib.Round(_min,0);
          /* _top := _max */
          _top = CPLib.Round(_max,0);
        } else { // Else
          /* If _contacicli=1 */
          if (CPLib.eqr(_contacicli,1)) {
            /* _bottom := _min */
            _bottom = CPLib.Round(_min,0);
            /* _top := _min + 4999 */
            _top = CPLib.Round(_min+4999,0);
            /* ElseIf _contacicli = _cicli */
          } else if (CPLib.eqr(_contacicli,_cicli)) {
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _max */
            _top = CPLib.Round(_max,0);
          } else { // Else
            /* _bottom := _top + 1 */
            _bottom = CPLib.Round(_top+1,0);
            /* _top := _bottom + 4999 */
            _top = CPLib.Round(_bottom+4999,0);
          } // End If
        } // End If
        /* gMsgImp := 'Lettura operazioni extraconto in corso ... Ciclo N. '+LRTrim(Str(_contacicli,10,0)) + " su " +LRTrim(Str(_cicli,10,0)) // Messaggio Import */
        gMsgImp = "Lettura operazioni extraconto in corso ... Ciclo N. "+CPLib.LRTrim(CPLib.Str(_contacicli,10,0))+" su "+CPLib.LRTrim(CPLib.Str(_cicli,10,0));
        m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        /* If Empty(_oldmsg) */
        if (CPLib.Empty(_oldmsg)) {
          /* gMsgProc := gMsgProc + LRTrim(gMsgImp) // Messaggio */
          gMsgProc = gMsgProc+CPLib.LRTrim(gMsgImp);
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } else { // Else
          /* gMsgProc := Strtran(gMsgProc,LRTrim(_oldmsg),LRTrim(gMsgImp)) // Messaggio */
          gMsgProc = CPLib.Strtran(gMsgProc,CPLib.LRTrim(_oldmsg),CPLib.LRTrim(gMsgImp));
          m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
        } // End If
        /* _oldmsg := gMsgImp */
        _oldmsg = gMsgImp;
        /* If _top>=_min */
        if (CPLib.ge(_top,_min)) {
          /* gMsgImp := "Attendere. Estrazione dati per il periodo ..." // Messaggio Import */
          gMsgImp = "Attendere. Estrazione dati per il periodo ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
          // * --- Fill memory cursor mcTemp on qbe_fam_reimpianto_opx
          mcTemp.Zap();
          SPBridge.HMCaller _h0000010B;
          _h0000010B = new SPBridge.HMCaller();
          _h0000010B.Set("m_cVQRList",m_cVQRList);
          _h0000010B.Set("_dadata",_dadata);
          _h0000010B.Set("_adata",_adata);
          _h0000010B.Set("_bottom",_bottom);
          _h0000010B.Set("_top",_top);
          if (Cursor_qbe_fam_reimpianto_opx!=null)
            Cursor_qbe_fam_reimpianto_opx.Close();
          Cursor_qbe_fam_reimpianto_opx = new VQRHolder("qbe_fam_reimpianto_opx",com.zucchetti.sitepainter.Library.getVQRReaderFactory(m_Ctx.GetInstance()),_h0000010B,true).GetResultSet(m_Ctx);
          {
            final CPResultSet m_TheCursor = Cursor_qbe_fam_reimpianto_opx;
            Cursor_qbe_fam_reimpianto_opx.ActionOnClose(new Runnable() {
              public void run() {
                if (CPLib.gt(m_TheCursor.CurrentRow()-1,5000*1.1)) {
                  com.zucchetti.sitepainter.Logger info = com.zucchetti.sitepainter.Logger.getWarningLogger();
                  if ( ! (CPLib.IsNull(info))) {
                    info.log("Routine arrt_famextra: query on qbe_fam_reimpianto_opx returns "+(m_TheCursor.CurrentRow()-1)+" rows larger then the expected 5000");
                  }
                }
              }
              });
          }
          while ( ! (Cursor_qbe_fam_reimpianto_opx.Eof())) {
            mcTemp.AppendBlank();
            mcTemp.row.RAPPORTO = Cursor_qbe_fam_reimpianto_opx.GetString("RAPPORTO");
            mcTemp.row.DATAINI = Cursor_qbe_fam_reimpianto_opx.GetDate("DATAINI");
            mcTemp.row.DATAFINE = Cursor_qbe_fam_reimpianto_opx.GetDate("DATAFINE");
            mcTemp.row.TIPOAG = Cursor_qbe_fam_reimpianto_opx.GetString("TIPOAG");
            mcTemp.row.TIPORAP = Cursor_qbe_fam_reimpianto_opx.GetString("TIPORAP");
            mcTemp.row.DESCRAP = Cursor_qbe_fam_reimpianto_opx.GetString("DESCRAP");
            mcTemp.row.VALUTA = Cursor_qbe_fam_reimpianto_opx.GetString("VALUTA");
            mcTemp.row.INVIATO = Cursor_qbe_fam_reimpianto_opx.GetDouble("INVIATO");
            mcTemp.row.TIPO = Cursor_qbe_fam_reimpianto_opx.GetString("TIPO");
            mcTemp.row.CAB = Cursor_qbe_fam_reimpianto_opx.GetString("CAB");
            mcTemp.row.UNIQUECODE = Cursor_qbe_fam_reimpianto_opx.GetString("UNIQUECODE");
            mcTemp.row.OLDINTER = Cursor_qbe_fam_reimpianto_opx.GetString("OLDINTER");
            mcTemp.row.IDBASE = Cursor_qbe_fam_reimpianto_opx.GetString("IDBASE");
            mcTemp.row.DATAMODI = Cursor_qbe_fam_reimpianto_opx.GetDate("DATAMODI");
            mcTemp.row.IDESITO = Cursor_qbe_fam_reimpianto_opx.GetString("IDESITO");
            mcTemp.row.ISOAGE = Cursor_qbe_fam_reimpianto_opx.GetString("ISOAGE");
            Cursor_qbe_fam_reimpianto_opx.Next();
          }
          m_cConnectivityError = Cursor_qbe_fam_reimpianto_opx.ErrorMessage();
          Cursor_qbe_fam_reimpianto_opx.Close();
          mcTemp.GoTop();
          for (MemoryCursorRow_tmp_stpperiodo rowTemp : mcTemp._iterable_()) {
            /* _unique := "R2017"+"_"+LRTrim(_cfinter)+"_"+LRTrim(rowTemp.RAPPORTO) */
            _unique = "R2017"+"_"+CPLib.LRTrim(_cfinter)+"_"+CPLib.LRTrim(rowTemp.RAPPORTO);
            /* _unique := arfn_agechar(_unique,"_") */
            _unique = arfn_agecharR.Make(m_Ctx,this).Run(_unique,"_");
            /* _unique := Strtran(LRTrim(_unique)," ","_") */
            _unique = CPLib.Strtran(CPLib.LRTrim(_unique)," ","_");
            /* _newuc := 'S' */
            _newuc = "S";
            /* rowSID1.CODINVIO1 := _invio */
            rowSID1.CODINVIO1 = _invio;
            /* rowSID1.RAPINVIO1 := rowTemp.RAPPORTO */
            rowSID1.RAPINVIO1 = rowTemp.RAPPORTO;
            /* rowSID1.TPRINVIO1 := rowTemp.TIPOAG */
            rowSID1.TPRINVIO1 = rowTemp.TIPOAG;
            /* rowSID1.INIINVIO1 := rowTemp.DATAINI */
            rowSID1.INIINVIO1 = rowTemp.DATAINI;
            /* rowSID1.FININVIO1 := rowTemp.DATAFINE */
            rowSID1.FININVIO1 = rowTemp.DATAFINE;
            /* rowSID1.TIPINVIO1 := '2' */
            rowSID1.TIPINVIO1 = "2";
            /* rowSID1.TPCINVIO1 := '6' */
            rowSID1.TPCINVIO1 = "6";
            /* rowSID1.UNIQUE1 := _unique */
            rowSID1.UNIQUE1 = _unique;
            /* rowSID1.FLGUNQ1 := _newuc */
            rowSID1.FLGUNQ1 = _newuc;
            /* rowSID1.MODINVIO1 := NullDate() */
            rowSID1.MODINVIO1 = CPLib.NullDate();
            /* mcSID1.AppendRow(rowSID1) */
            mcSID1.AppendRow(rowSID1);
            /* _tipo1 := _tipo1 + 1 */
            _tipo1 = CPLib.Round(_tipo1+1,0);
            /* _riga := '1' */
            _riga = "1";
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_unique),50) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_unique),50);
            /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowTemp.TIPOAG),2) */
            _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowTemp.TIPOAG),2);
            /* _riga := _riga + iif(rowTemp.TIPOAG='99',LibreriaMit.SpacePad(LRTrim(Upper(arfn_agechar(rowTemp.DESCRAP,' '))),24),Space(24)) */
            _riga = _riga+(CPLib.eqr(rowTemp.TIPOAG,"99")?LibreriaMit.SpacePad(CPLib.LRTrim(CPLib.Upper(arfn_agecharR.Make(m_Ctx,this).Run(rowTemp.DESCRAP," "))),24):CPLib.Space(24));
            /* _riga := _riga + arfn_fdate_nd(rowTemp.DATAINI,'N') */
            _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowTemp.DATAINI,"N");
            /* _riga := _riga + iif(rowTemp.TIPO='O','01010001',arfn_fdate_nd(rowTemp.DATAFINE,'N')) */
            _riga = _riga+(CPLib.eqr(rowTemp.TIPO,"O")?"01010001":arfn_fdate_ndR.Make(m_Ctx,this).Run(rowTemp.DATAFINE,"N"));
            /* If At(rowTemp.TIPOAG,"01;02;03;12;13") <> 0 */
            if (CPLib.ne(CPLib.At(rowTemp.TIPOAG,"01;02;03;12;13"),0)) {
              /* _riga := _riga + iif(Empty(LRTrim(rowTemp.CAB)),LibreriaMit.SpacePad(LRTrim(_cabinter),5),LibreriaMit.SpacePad(LRTrim(rowTemp.CAB),5)) */
              _riga = _riga+(CPLib.Empty(CPLib.LRTrim(rowTemp.CAB))?LibreriaMit.SpacePad(CPLib.LRTrim(_cabinter),5):LibreriaMit.SpacePad(CPLib.LRTrim(rowTemp.CAB),5));
            } else { // Else
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowTemp.CAB),5) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowTemp.CAB),5);
            } // End If
            /* _riga := _riga + Space(13) */
            _riga = _riga+CPLib.Space(13);
            /* _riga := _riga + Space(286) */
            _riga = _riga+CPLib.Space(286);
            /* _riga := _riga + 'A' + LibreriaMit.CloseLine() */
            _riga = _riga+"A"+LibreriaMit.CloseLine();
            /* FileLibMit.Write(fhand,_riga) */
            FileLibMit.Write(fhand,_riga);
            /* mcSID2r := arfn_fam_mesefile02(rowSID1,_dadata,_adata,rowTemp.TIPO) */
            mcSID2r = arfn_fam_mesefile02R.Make(m_Ctx,this).Run(rowSID1,_dadata,_adata,rowTemp.TIPO);
            for (MemoryCursorRow_sid_invio2 rowSID2 : mcSID2r._iterable_()) {
              /* mcSID2.AppendRow(rowSID2) */
              mcSID2.AppendRow(rowSID2);
              /* _tipo2 := _tipo2 + 1 */
              _tipo2 = CPLib.Round(_tipo2+1,0);
              /* _riga := '2' */
              _riga = "2";
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_unique),50) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_unique),50);
              /* _riga := _riga + Right('000000000'+LRTrim(Str(rowSID2.APRINVIO2,9,0)),9) */
              _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(rowSID2.APRINVIO2,9,0)),9);
              /* _riga := _riga + arfn_fdate_nd(rowSID2.INIINVIO2,'N') */
              _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowSID2.INIINVIO2,"N");
              /* _riga := _riga + iif(rowTemp.TIPO='O','01010001',arfn_fdate_nd(rowSID2.FININVIO2,'N')) */
              _riga = _riga+(CPLib.eqr(rowTemp.TIPO,"O")?"01010001":arfn_fdate_ndR.Make(m_Ctx,this).Run(rowSID2.FININVIO2,"N"));
              /* _riga := _riga + Str(rowSID2.FCFINVIO2,1,0) */
              _riga = _riga+CPLib.Str(rowSID2.FCFINVIO2,1,0);
              /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(rowSID2.CFSINVIO2),16) */
              _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowSID2.CFSINVIO2),16);
              /* _riga := _riga + rowSID2.RUOINVIO2 */
              _riga = _riga+rowSID2.RUOINVIO2;
              /* If not(Empty(rowSID2.SEXINVIO2)) */
              if ( ! (CPLib.Empty(rowSID2.SEXINVIO2))) {
                /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(rowSID2.COGINVIO2,' '),26) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.COGINVIO2," "),26);
                /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(rowSID2.NOMINVIO2,' '),25) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.NOMINVIO2," "),25);
                /* _riga := _riga +LibreriaMit.SpacePad(rowSID2.SEXINVIO2,1) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(rowSID2.SEXINVIO2,1);
                /* _riga := _riga +arfn_fdate_nd(rowSID2.DNSINVIO2,'N') // Invio Ordinario */
                _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(rowSID2.DNSINVIO2,"N");
                /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(arfn_agechar(rowSID2.CNSINVIO2,' ')),40) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.CNSINVIO2," ")),40);
                /* _riga := _riga +LibreriaMit.SpacePad(rowSID2.PNSINVIO2,2) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(rowSID2.PNSINVIO2,2);
                /* _riga := _riga +Space(102) // Invio Ordinario */
                _riga = _riga+CPLib.Space(102);
              } else { // Else
                /* _riga := _riga +Space(102) // Invio Ordinario */
                _riga = _riga+CPLib.Space(102);
                /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(arfn_agechar(rowSID2.RGSINVIO2,' ')),60) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.RGSINVIO2," ")),60);
                /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(arfn_agechar(rowSID2.CSLINVIO2,' ')),40) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(arfn_agecharR.Make(m_Ctx,this).Run(rowSID2.CSLINVIO2," ")),40);
                /* _riga := _riga +LibreriaMit.SpacePad(LRTrim(rowSID2.PLSINVIO2),2) // Invio Ordinario */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(rowSID2.PLSINVIO2),2);
              } // End If
              /* _riga := _riga + Space(99) */
              _riga = _riga+CPLib.Space(99);
              /* _riga := _riga + 'A' + LibreriaMit.CloseLine() */
              _riga = _riga+"A"+LibreriaMit.CloseLine();
              /* FileLibMit.Write(fhand,_riga) */
              FileLibMit.Write(fhand,_riga);
            }
            /* If At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98") <> 0 */
            if (CPLib.ne(CPLib.At(rowTemp.TIPOAG,"01;02;03;04;05;06;07;09;10;12;14;15;23;24;98"),0)) {
              /* If rowTemp.TIPOAG <> '98' */
              if (CPLib.ne(rowTemp.TIPOAG,"98")) {
                /* _asaldi := iif(DateDiff(gScadSaldi,Date()) <= 90,Year(Date())-2,Year(Date())-1) */
                _asaldi = CPLib.Round((CPLib.le(CPLib.DateDiff(gScadSaldi,CPLib.Date()),90)?CPLib.Year(CPLib.Date())-2:CPLib.Year(CPLib.Date())-1),0);
              } else { // Else
                /* If (Year(Date()) -Year(rowTemp.DATAINI)=1 and DateDiff(gScadSaldi,Date()) <= 90) or (Year(Date()) -Year(rowTemp.DATAINI)=0) */
                if ((CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Year(rowTemp.DATAINI),1) && CPLib.le(CPLib.DateDiff(gScadSaldi,CPLib.Date()),90)) || (CPLib.eqr(CPLib.Year(CPLib.Date())-CPLib.Year(rowTemp.DATAINI),0))) {
                  /* _asaldi := 0 */
                  _asaldi = CPLib.Round(0,0);
                } else { // Else
                  /* _asaldi := Year(rowTemp.DATAINI) */
                  _asaldi = CPLib.Round(CPLib.Year(rowTemp.DATAINI),0);
                } // End If
              } // End If
              /* mcSID3r := arfn_fam_mesefile03(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA) */
              mcSID3r = arfn_fam_mesefile03R.Make(m_Ctx,this).Run(rowSID1,_asaldi,rowTemp.TIPO,rowTemp.VALUTA);
              for (MemoryCursorRow_sid_invio3 rowSID3 : mcSID3r._iterable_()) {
                /* mcSID3.AppendRow(rowSID3) */
                mcSID3.AppendRow(rowSID3);
                /* _tipo3 := _tipo3 + 1 */
                _tipo3 = CPLib.Round(_tipo3+1,0);
                /* _riga := '3' */
                _riga = "3";
                /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(_unique),50) */
                _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(_unique),50);
                /* _riga := _riga + rowTemp.TIPOAG */
                _riga = _riga+rowTemp.TIPOAG;
                /* _riga := _riga + Str(rowSID3.ANNINVIO3,4,0) */
                _riga = _riga+CPLib.Str(rowSID3.ANNINVIO3,4,0);
                /* _riga := _riga + iif(rowSID3.IM1INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM1INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM1INVIO3,17,0)),17)) */
                _riga = _riga+(CPLib.lt(rowSID3.IM1INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM1INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM1INVIO3,17,0)),17));
                /* _riga := _riga + Str(rowSID3.FI1INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI1INVIO3,1,0);
                /* _riga := _riga + iif(rowSID3.IM2INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM2INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM2INVIO3,17,0)),17)) */
                _riga = _riga+(CPLib.lt(rowSID3.IM2INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM2INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM2INVIO3,17,0)),17));
                /* _riga := _riga + Str(rowSID3.FI2INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI2INVIO3,1,0);
                /* _riga := _riga + iif(rowSID3.IM3INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM3INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM3INVIO3,17,0)),17)) */
                _riga = _riga+(CPLib.lt(rowSID3.IM3INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM3INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM3INVIO3,17,0)),17));
                /* _riga := _riga + Str(rowSID3.FI3INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI3INVIO3,1,0);
                /* _riga := _riga + iif(rowSID3.IM4INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM4INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM4INVIO3,17,0)),17)) */
                _riga = _riga+(CPLib.lt(rowSID3.IM4INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM4INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM4INVIO3,17,0)),17));
                /* _riga := _riga + Str(rowSID3.FI4INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI4INVIO3,1,0);
                /* _riga := _riga + iif(rowSID3.IM5INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM5INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM5INVIO3,17,0)),17)) */
                _riga = _riga+(CPLib.lt(rowSID3.IM5INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM5INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM5INVIO3,17,0)),17));
                /* _riga := _riga + Str(rowSID3.FI5INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI5INVIO3,1,0);
                /* _riga := _riga + iif(rowSID3.IM6INVIO3 <0,'-'+Right('0000000000000000'+LRTrim(Str(rowSID3.IM6INVIO3*-1,16,0)),16),Right('00000000000000000'+LRTrim(Str(rowSID3.IM6INVIO3,17,0)),17)) */
                _riga = _riga+(CPLib.lt(rowSID3.IM6INVIO3,0)?"-"+CPLib.Right("0000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM6INVIO3*-1,16,0)),16):CPLib.Right("00000000000000000"+CPLib.LRTrim(CPLib.Str(rowSID3.IM6INVIO3,17,0)),17));
                /* _riga := _riga + Str(rowSID3.FI6INVIO3,1,0) */
                _riga = _riga+CPLib.Str(rowSID3.FI6INVIO3,1,0);
                /* _riga := _riga + rowTemp.VALUTA */
                _riga = _riga+rowTemp.VALUTA;
                /* _riga := _riga + Space(229) */
                _riga = _riga+CPLib.Space(229);
                /* _riga := _riga + 'A' + LibreriaMit.CloseLine() */
                _riga = _riga+"A"+LibreriaMit.CloseLine();
                /* FileLibMit.Write(fhand,_riga) */
                FileLibMit.Write(fhand,_riga);
              }
            } // End If
            /* _conta := _conta + 1 */
            _conta = CPLib.Round(_conta+1,0);
            /* cProg := Utilities.GetAutonumber("PRGAGESID\'"+LRTrim(gAzienda)+"'",'',10) */
            cProg = Utilities.Make(m_Ctx,m_Caller).GetAutonumber("PRGAGESID\\'"+CPLib.LRTrim(gAzienda)+"'","",10);
            // * --- Insert into aefaminvio from values
            m_Sql.RequireTransaction();
            m_cServer = m_Ctx.GetServer("aefaminvio");
            m_cPhName = m_Ctx.GetPhName("aefaminvio");
            m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"aefaminvio",m_Ctx.GetCompany());
            m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
            m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000169")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
            m_cSql = m_cSql+GetFieldsName_00000169(m_Ctx,m_oWrInfo);
            m_cSql = m_cSql+") values (";
            m_cSql = m_cSql+""+CPLib.ToSQL(cProg,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.TIPO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("2","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("0000","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("00","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL("6","?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(rowTemp.RAPPORTO,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_nomefile,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_conta,"?",0,0)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
            m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.NullDate(),"?",0,0)+", ";
            m_cSql = m_cSql+m_oWrInfo.InsertValues();
            m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"aefaminvio",true);
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
            /* gMsgImp := 'Sono stati generati '+LRTrim(Str(_conta,10,0))+" record" // Messaggio Import */
            gMsgImp = "Sono stati generati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" record";
            m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
            /* _contarighe := _contarighe + 1 */
            _contarighe = CPLib.Round(_contarighe+1,0);
          }
        } else { // Else
          /* gMsgImp := 'Lettura operazioni extraconto in corso ...' // Messaggio Import */
          gMsgImp = "Lettura operazioni extraconto in corso ...";
          m_Ctx.SetGlobalString("gMsgImp",gMsgImp);
        } // End If
        /* _contacicli := _contacicli+1 */
        _contacicli = CPLib.Round(_contacicli+1,0);
      } // End While
      /* _riga := '9' */
      _riga = "9";
      /* _riga := _riga + Right('000000000'+LRTrim(Str(_tipo1,9,0)),9) */
      _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_tipo1,9,0)),9);
      /* _riga := _riga + Right('000000000'+LRTrim(Str(_tipo2,9,0)),9) */
      _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_tipo2,9,0)),9);
      /* _riga := _riga + Right('000000000'+LRTrim(Str(_tipo3,9,0)),9) */
      _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_tipo3,9,0)),9);
      /* _riga := _riga + Right('000000000'+LRTrim(Str(_tipo4,9,0)),9) */
      _riga = _riga+CPLib.Right("000000000"+CPLib.LRTrim(CPLib.Str(_tipo4,9,0)),9);
      /* _riga := _riga + Space(360) // Invio Ordinario */
      _riga = _riga+CPLib.Space(360);
      /* _riga := _riga + 'A' + LibreriaMit.CloseLine() // Invio Ordinario */
      _riga = _riga+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
      /* gMsgProc := NL + gMsgProc + 'Sono stati generati '+LRTrim(Str(_conta,10,0))+" record" +NL // Messaggio */
      gMsgProc = "\n"+gMsgProc+"Sono stati generati "+CPLib.LRTrim(CPLib.Str(_conta,10,0))+" record"+"\n";
      m_Ctx.SetGlobalString("gMsgProc",gMsgProc);
    } finally {
      try {
        if (Cursor_qbe_famreimp_opx_minmax!=null)
          Cursor_qbe_famreimp_opx_minmax.Close();
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
      try {
        if (Cursor_qbe_fam_reimpianto_opx!=null)
          Cursor_qbe_fam_reimpianto_opx.Close();
      } catch(Throwable dontCare) {
        // Ogni chiusura del cursore viene racchiusa in una catch per evitare di perdere l'eccezione
        // originata all'interno della try-finally della pagina della routine
      }
    }
  }
  void Page_3() throws Exception {
    /* Cabio Identificativo */
  }
  void Page_4() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* Presa in carico */
      /* System.out.println('Vecchio intermediario:'+w_oldinter) */
      System.out.println("Vecchio intermediario:"+w_oldinter);
      /* _tipoinv := '2' */
      _tipoinv = "2";
      /* _tipocom := '8' */
      _tipocom = "8";
      /* _invio := _annoc+_mese+"_2_8" */
      _invio = _annoc+_mese+"_2_8";
      // * --- Insert into tmp_list_imprich from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000180")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000180(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
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
      /* _nomefile := LRTrim(gIntemediario)+"_"+_annoc+_mese+"_2_8_"+DateTimeToChar(DateTime()) */
      _nomefile = CPLib.LRTrim(gIntemediario)+"_"+_annoc+_mese+"_2_8_"+CPLib.DateTimeToChar(CPLib.DateTime());
      /* fhand := FileLibMit.OpenWrite('/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWrite("/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      /* rowSID0.CODINVIO := _invio */
      rowSID0.CODINVIO = _invio;
      /* rowSID0.TIPINVIO := '2' */
      rowSID0.TIPINVIO = "2";
      /* rowSID0.TPCINVIO := '8' */
      rowSID0.TPCINVIO = "8";
      /* rowSID0.ANNINVIO := _annoc */
      rowSID0.ANNINVIO = _annoc;
      /* rowSID0.MESINVIO := _mese */
      rowSID0.MESINVIO = _mese;
      /* rowSID0.FLEINVIO := _nomefile */
      rowSID0.FLEINVIO = _nomefile;
      /* rowSID0.PRTINVIO := w_protfile */
      rowSID0.PRTINVIO = w_protfile;
      /* mcSID0.AppendRow(rowSID0) */
      mcSID0.AppendRow(rowSID0);
      // * --- Delete from sid_invio
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sid_invio");
      m_cPhName = m_Ctx.GetPhName("sid_invio");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000018E")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINVIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
      // * --- Insert into sid_invio from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sid_invio");
      m_cPhName = m_Ctx.GetPhName("sid_invio");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"0000018F")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_0000018F(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_annoc,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_mese,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_protfile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio",true);
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
      /* _riga := '0' */
      _riga = "0";
      /* _riga := _riga + 'ARU00' */
      _riga = _riga+"ARU00";
      /* _riga := _riga + '2' */
      _riga = _riga+"2";
      /* _riga := _riga + '8' */
      _riga = _riga+"8";
      /* _riga := _riga + '0000' */
      _riga = _riga+"0000";
      /* _riga := _riga + '00' */
      _riga = _riga+"00";
      /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(w_protfile),24) */
      _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(w_protfile),24);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(intermbo->CODFISC),16) */
        _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC")),16);
        /* _cfinter := LRTrim(intermbo->CODFISC) */
        _cfinter = CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"));
        /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->COGNOME,26) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("COGNOME"),26);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NOME,25) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NOME"),25);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->SESSO,1) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("SESSO"),1);
          /* _riga := _riga +arfn_fdate_nd(intermbo->DATANASC,'N') // Invio Ordinario */
          _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_intermbo.GetDate("DATANASC"),"N");
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NASCOMUN,40) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NASCOMUN"),40);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVNA,2) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVNA"),2);
          /* _riga := _riga +Space(112) // Invio Ordinario */
          _riga = _riga+CPLib.Space(112);
        } else { // Else
          /* _riga := _riga +Space(102) // Invio Ordinario */
          _riga = _riga+CPLib.Space(102);
          /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->RAGSOC,' '),70) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("RAGSOC")," "),70);
          /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->DESCCIT,' '),40) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("DESCCIT")," "),40);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVINCIA,2) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
        } // End If
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _riga := _riga +LibreriaMit.SpacePad(w_oldinter,16) // Invio Ordinario */
      _riga = _riga+LibreriaMit.SpacePad(w_oldinter,16);
      /* _riga := _riga +'0' // Invio Ordinario */
      _riga = _riga+"0";
      /* _riga := _riga + Space(112) // Invio Ordinario */
      _riga = _riga+CPLib.Space(112);
      /* _riga := _riga + 'A' + LibreriaMit.CloseLine() // Invio Ordinario */
      _riga = _riga+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* _riga := '9' */
      _riga = "9";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + Space(360) // Invio Ordinario */
      _riga = _riga+CPLib.Space(360);
      /* _riga := _riga + 'A' + LibreriaMit.CloseLine() // Invio Ordinario */
      _riga = _riga+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
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
  void Page_5() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* Annullamento */
      /* _tipoinv := '3' */
      _tipoinv = "3";
      /* _tipocom := '9' */
      _tipocom = "9";
      /* _invio := _annoc+_mese+"_3_9" */
      _invio = _annoc+_mese+"_3_9";
      // * --- Insert into tmp_list_imprich from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000001BB")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000001BB(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
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
      /* _nomefile := LRTrim(gIntemediario)+"_"+_annoc+_mese+"_3_9_"+DateTimeToChar(DateTime()) */
      _nomefile = CPLib.LRTrim(gIntemediario)+"_"+_annoc+_mese+"_3_9_"+CPLib.DateTimeToChar(CPLib.DateTime());
      /* fhand := FileLibMit.OpenWrite('/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWrite("/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      /* rowSID0.CODINVIO := _invio */
      rowSID0.CODINVIO = _invio;
      /* rowSID0.TIPINVIO := '3' */
      rowSID0.TIPINVIO = "3";
      /* rowSID0.TPCINVIO := '9' */
      rowSID0.TPCINVIO = "9";
      /* rowSID0.ANNINVIO := _annoc */
      rowSID0.ANNINVIO = _annoc;
      /* rowSID0.MESINVIO := _mese */
      rowSID0.MESINVIO = _mese;
      /* rowSID0.FLEINVIO := _nomefile */
      rowSID0.FLEINVIO = _nomefile;
      /* rowSID0.PRTINVIO := w_protfile */
      rowSID0.PRTINVIO = w_protfile;
      /* mcSID0.AppendRow(rowSID0) */
      mcSID0.AppendRow(rowSID0);
      // * --- Delete from sid_invio
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sid_invio");
      m_cPhName = m_Ctx.GetPhName("sid_invio");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000001C9")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINVIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
      // * --- Insert into sid_invio from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sid_invio");
      m_cPhName = m_Ctx.GetPhName("sid_invio");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000001CA")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000001CA(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_annoc,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_mese,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_protfile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio",true);
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
      /* _riga := '0' */
      _riga = "0";
      /* _riga := _riga + 'ARU00' */
      _riga = _riga+"ARU00";
      /* _riga := _riga + '3' */
      _riga = _riga+"3";
      /* _riga := _riga + '9' */
      _riga = _riga+"9";
      /* _riga := _riga + '0000' */
      _riga = _riga+"0000";
      /* _riga := _riga + '00' */
      _riga = _riga+"00";
      /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(w_protfile),24) */
      _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(w_protfile),24);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(intermbo->CODFISC),16) */
        _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC")),16);
        /* _cfinter := LRTrim(intermbo->CODFISC) */
        _cfinter = CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"));
        /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->COGNOME,26) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("COGNOME"),26);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NOME,25) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NOME"),25);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->SESSO,1) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("SESSO"),1);
          /* _riga := _riga +arfn_fdate_nd(intermbo->DATANASC,'N') // Invio Ordinario */
          _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_intermbo.GetDate("DATANASC"),"N");
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NASCOMUN,40) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NASCOMUN"),40);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVNA,2) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVNA"),2);
          /* _riga := _riga +Space(112) // Invio Ordinario */
          _riga = _riga+CPLib.Space(112);
        } else { // Else
          /* _riga := _riga +Space(102) // Invio Ordinario */
          _riga = _riga+CPLib.Space(102);
          /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->RAGSOC,' '),70) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("RAGSOC")," "),70);
          /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->DESCCIT,' '),40) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("DESCCIT")," "),40);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVINCIA,2) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
        } // End If
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _riga := _riga +Space(16) // Invio Ordinario */
      _riga = _riga+CPLib.Space(16);
      /* _riga := _riga +'0' // Invio Ordinario */
      _riga = _riga+"0";
      /* _riga := _riga + Space(112) // Invio Ordinario */
      _riga = _riga+CPLib.Space(112);
      /* _riga := _riga + 'A' + LibreriaMit.CloseLine() // Invio Ordinario */
      _riga = _riga+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* _riga := '9' */
      _riga = "9";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + Space(360) // Invio Ordinario */
      _riga = _riga+CPLib.Space(360);
      /* _riga := _riga + 'A' + LibreriaMit.CloseLine() // Invio Ordinario */
      _riga = _riga+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
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
  void Page_6() throws Exception {
    CPResultSet Cursor_intermbo=null;
    try {
      /* Chiusura Generalizzata Rapporti */
      /* _tipoinv := '2' */
      _tipoinv = "2";
      /* _tipocom := 'C' */
      _tipocom = "C";
      /* _invio := _annoc+_mese+"_2_C" */
      _invio = _annoc+_mese+"_2_C";
      // * --- Insert into tmp_list_imprich from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("tmp_list_imprich");
      m_cPhName = m_Ctx.GetPhName("tmp_list_imprich");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"tmp_list_imprich",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"000001F6")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_000001F6(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
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
      /* _nomefile := LRTrim(gIntemediario)+"_"+_annoc+_mese+"_2_C_"+DateTimeToChar(DateTime()) */
      _nomefile = CPLib.LRTrim(gIntemediario)+"_"+_annoc+_mese+"_2_C_"+CPLib.DateTimeToChar(CPLib.DateTime());
      /* fhand := FileLibMit.OpenWrite('/SID/INVII/DAP/'+LRTrim(gAzienda)+"/"+LRTrim(_nomefile)) */
      fhand = FileLibMit.OpenWrite("/SID/INVII/DAP/"+CPLib.LRTrim(gAzienda)+"/"+CPLib.LRTrim(_nomefile));
      /* rowSID0.CODINVIO := _invio */
      rowSID0.CODINVIO = _invio;
      /* rowSID0.TIPINVIO := '2' */
      rowSID0.TIPINVIO = "2";
      /* rowSID0.TPCINVIO := 'C' */
      rowSID0.TPCINVIO = "C";
      /* rowSID0.ANNINVIO := _annoc */
      rowSID0.ANNINVIO = _annoc;
      /* rowSID0.MESINVIO := _mese */
      rowSID0.MESINVIO = _mese;
      /* rowSID0.FLEINVIO := _nomefile */
      rowSID0.FLEINVIO = _nomefile;
      /* rowSID0.PRTINVIO := w_protfile */
      rowSID0.PRTINVIO = w_protfile;
      /* mcSID0.AppendRow(rowSID0) */
      mcSID0.AppendRow(rowSID0);
      // * --- Delete from sid_invio
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sid_invio");
      m_cPhName = m_Ctx.GetPhName("sid_invio");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000204")+"delete from "+m_oWrInfo.GetTableWriteName();
      m_cSql = m_cSql+" where ";
      m_cSql = m_cSql+"CODINVIO = "+CPSql.SQLValueAdapter(CPLib.ToSQL(_invio,"?",0,0,m_cServer),m_cServer,_invio)+"";
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
      // * --- Insert into sid_invio from values
      m_Sql.RequireTransaction();
      m_cServer = m_Ctx.GetServer("sid_invio");
      m_cPhName = m_Ctx.GetPhName("sid_invio");
      m_oWrInfo = CPPhTableWrInfo.GetCPPhTableWrInfo(m_Ctx,"sid_invio",m_Ctx.GetCompany());
      m_oParameters = CPLib.GetParamsForSqlUpdate(m_cServer);
      m_cSql = CPLib.GetSQLPrefixComment("arrt_famextra",121,"00000205")+CPLib.InsertIntoStatement(m_Ctx,m_oWrInfo)+" (";
      m_cSql = m_cSql+GetFieldsName_00000205(m_Ctx,m_oWrInfo);
      m_cSql = m_cSql+") values (";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("3","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL("9","?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(CPLib.Date(),"?",0,0)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_annoc,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_mese,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(_invio,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+""+CPLib.ToSQL(w_protfile,"?",0,0,m_cServer)+", ";
      m_cSql = m_cSql+m_oWrInfo.InsertValues();
      m_cSql = CPLib.AddCPCCCHKValue(m_Ctx,m_cSql,"sid_invio",true);
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
      /* _riga := '0' */
      _riga = "0";
      /* _riga := _riga + 'ARU00' */
      _riga = _riga+"ARU00";
      /* _riga := _riga + '2' */
      _riga = _riga+"2";
      /* _riga := _riga + 'C' */
      _riga = _riga+"C";
      /* _riga := _riga + '0000' */
      _riga = _riga+"0000";
      /* _riga := _riga + '00' */
      _riga = _riga+"00";
      /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(w_protfile),24) */
      _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(w_protfile),24);
      // * --- Select from intermbo
      m_cServer = m_Ctx.GetServer("intermbo");
      m_cPhName = m_Ctx.GetPhName("intermbo");
      if (Cursor_intermbo!=null)
        Cursor_intermbo.Close();
      Cursor_intermbo = m_Sql.Query(m_cServer,QueryLoader.SetSqlFunctions("select *  from "+m_cPhName+((m_cPhName).endsWith(CPSecurity.FILTER_QUERY_POSTFIX)?CPLib.NewCPCCCHK():"")+" where "+(m_Ctx.IsSharedTemp("intermbo")?"context_id='"+m_Ctx.GetTempID()+"'":"1=1"),m_cServer,m_Ctx,true));
      while ( ! (Cursor_intermbo.Eof())) {
        /* _riga := _riga + LibreriaMit.SpacePad(LRTrim(intermbo->CODFISC),16) */
        _riga = _riga+LibreriaMit.SpacePad(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC")),16);
        /* _cfinter := LRTrim(intermbo->CODFISC) */
        _cfinter = CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"));
        /* If Len(LRTrim(intermbo->CODFISC)) = 16 */
        if (CPLib.eqr(CPLib.Len(CPLib.LRTrim(Cursor_intermbo.GetString("CODFISC"))),16)) {
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->COGNOME,26) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("COGNOME"),26);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NOME,25) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NOME"),25);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->SESSO,1) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("SESSO"),1);
          /* _riga := _riga +arfn_fdate_nd(intermbo->DATANASC,'N') // Invio Ordinario */
          _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(Cursor_intermbo.GetDate("DATANASC"),"N");
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->NASCOMUN,40) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("NASCOMUN"),40);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVNA,2) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVNA"),2);
          /* _riga := _riga +Space(112) // Invio Ordinario */
          _riga = _riga+CPLib.Space(112);
        } else { // Else
          /* _riga := _riga +Space(102) // Invio Ordinario */
          _riga = _riga+CPLib.Space(102);
          /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->RAGSOC,' '),70) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("RAGSOC")," "),70);
          /* _riga := _riga +LibreriaMit.SpacePad(arfn_agechar(intermbo->DESCCIT,' '),40) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(arfn_agecharR.Make(m_Ctx,this).Run(Cursor_intermbo.GetString("DESCCIT")," "),40);
          /* _riga := _riga +LibreriaMit.SpacePad(intermbo->PROVINCIA,2) // Invio Ordinario */
          _riga = _riga+LibreriaMit.SpacePad(Cursor_intermbo.GetString("PROVINCIA"),2);
        } // End If
        Cursor_intermbo.Next();
      }
      m_cConnectivityError = Cursor_intermbo.ErrorMessage();
      Cursor_intermbo.Close();
      // * --- End Select
      /* _riga := _riga +Space(16) // Invio Ordinario */
      _riga = _riga+CPLib.Space(16);
      /* _riga := _riga +'0' // Invio Ordinario */
      _riga = _riga+"0";
      /* _riga := _riga +arfn_fdate_nd(w_datachiu,'S') // Invio Ordinario */
      _riga = _riga+arfn_fdate_ndR.Make(m_Ctx,this).Run(w_datachiu,"S");
      /* _riga := _riga + Space(104) // Invio Ordinario */
      _riga = _riga+CPLib.Space(104);
      /* _riga := _riga + 'A' + LibreriaMit.CloseLine() // Invio Ordinario */
      _riga = _riga+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* _riga := '9' */
      _riga = "9";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + '000000000' */
      _riga = _riga+"000000000";
      /* _riga := _riga + Space(360) // Invio Ordinario */
      _riga = _riga+CPLib.Space(360);
      /* _riga := _riga + 'A' + LibreriaMit.CloseLine() // Invio Ordinario */
      _riga = _riga+"A"+LibreriaMit.CloseLine();
      /* FileLibMit.Write(fhand,_riga) */
      FileLibMit.Write(fhand,_riga);
      /* FileLibMit.Close(fhand) */
      FileLibMit.Close(fhand);
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
  public String RunAsync(java.sql.Date p_w_a_Data,java.sql.Date p_w_daData,String p_w_tipo,String p_w_flgstp,String p_w_flganni,String p_w_protfile,String p_w_oldinter,java.sql.Date p_w_datachiu) {
    w_a_Data = p_w_a_Data;
    w_daData = p_w_daData;
    w_tipo = p_w_tipo;
    w_flgstp = p_w_flgstp;
    w_flganni = p_w_flganni;
    w_protfile = p_w_protfile;
    w_oldinter = p_w_oldinter;
    w_datachiu = p_w_datachiu;
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
  public Forward Run(java.sql.Date p_w_a_Data,java.sql.Date p_w_daData,String p_w_tipo,String p_w_flgstp,String p_w_flganni,String p_w_protfile,String p_w_oldinter,java.sql.Date p_w_datachiu) {
    w_a_Data = p_w_a_Data;
    w_daData = p_w_daData;
    w_tipo = p_w_tipo;
    w_flgstp = p_w_flgstp;
    w_flganni = p_w_flganni;
    w_protfile = p_w_protfile;
    w_oldinter = p_w_oldinter;
    w_datachiu = p_w_datachiu;
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
      m_Caller.CalledBatchEnd();
    } finally {
      m_Ctx.EnableDataFiltering();
    }
    return f;
  }
  public static arrt_famextraR Make(CPContext p_Ctx, Caller p_Caller) {
    return new arrt_famextraR(p_Ctx, p_Caller);
  }
  public void Blank() {
    w_a_Data = CPLib.NullDate();
    w_daData = CPLib.NullDate();
    w_tipo = CPLib.Space(1);
    w_flgstp = CPLib.Space(1);
    w_flganni = CPLib.Space(1);
    w_protfile = CPLib.Space(24);
    w_oldinter = CPLib.Space(16);
    w_datachiu = CPLib.NullDate();
    _conta = 0;
    _errore = "";
    mcTemp = new MemoryCursor_tmp_stpperiodo();
    rowTemp = new MemoryCursorRow_tmp_stpperiodo();
    mcSID0 = new MemoryCursor_sid_invio();
    rowSID0 = new MemoryCursorRow_sid_invio();
    mcSID1 = new MemoryCursor_sid_invio1();
    rowSID1 = new MemoryCursorRow_sid_invio1();
    mcSID2 = new MemoryCursor_sid_invio2();
    mcSID2r = new MemoryCursor_sid_invio2();
    rowSID2 = new MemoryCursorRow_sid_invio2();
    mcSID3 = new MemoryCursor_sid_invio3();
    rowSID3 = new MemoryCursorRow_sid_invio3();
    mcSID3r = new MemoryCursor_sid_invio3();
    _crea = 0;
    _invio = CPLib.Space(10);
    _sid = new MemoryCursor_mcmessaggi_mcrdef();
    _max = 0;
    _min = 0;
    _tot = 0;
    _mono = 0;
    _contacicli = 0;
    _bottom = 0;
    _top = 0;
    _cicli = 0;
    _totrecord = 0;
    _reccount = 0;
    _contarec = 0;
    _oldmsg = "";
    _errori = 0;
    _newunq = CPLib.Space(1);
    cProg = CPLib.Space(10);
    _annoelb = CPLib.Space(4);
    _annoini = 0;
    _annofin = 0;
    _dadata = CPLib.NullDate();
    _adata = CPLib.NullDate();
    fhand = CPLib.Space(10);
    _nomefile = CPLib.Space(10);
    cNomeFile = CPLib.Space(100);
    _mese = CPLib.Space(2);
    _riga = CPLib.Space(398);
    _tipo1 = 0;
    _tipo2 = 0;
    _tipo3 = 0;
    _tipo4 = 0;
    _unique = CPLib.Space(50);
    _cab = CPLib.Space(5);
    _cfinter = CPLib.Space(16);
    _cabinter = CPLib.Space(5);
    _tipoinv = CPLib.Space(1);
    _tipocom = CPLib.Space(1);
    _annoc = CPLib.Space(4);
    _contarighe = 0;
    _newuc = CPLib.Space(1);
    _asaldi = 0;
    gMsgImp=m_Ctx.GetGlobalString("gMsgImp");
    gMsgProc=m_Ctx.GetGlobalString("gMsgProc");
    gIntemediario=m_Ctx.GetGlobalString("gIntemediario");
    gAzienda=m_Ctx.GetGlobalString("gAzienda");
    gPathApp=m_Ctx.GetGlobalString("gPathApp");
    gScadSaldi=m_Ctx.GetGlobalDate("gScadSaldi");
    gDescAzi=m_Ctx.GetGlobalString("gDescAzi");
  }
  // * --- Area Manuale = BO - Methods
  // * --- Fine Area Manuale
  // ENTITY_VQR: ,qbe_famreimp_opx_minmax,qbe_fam_reimpianto_opx,
  public static final String m_cVQRList = ",qbe_famreimp_opx_minmax,qbe_fam_reimpianto_opx,";
  // ENTITY_BATCHES: ,arfn_agechar,arfn_exec_sid,arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdate_nd,arfn_fdatetime,
  public static final String i_InvokedRoutines = ",arfn_agechar,arfn_exec_sid,arfn_fam_mesefile02,arfn_fam_mesefile03,arfn_fdate_nd,arfn_fdatetime,";
  public static String[] m_cRunParameterNames={"w_a_Data","w_daData","w_tipo","w_flgstp","w_flganni","w_protfile","w_oldinter","w_datachiu"};
  protected static String GetFieldsName_00000062(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"MESE,";
    p_cSql = p_cSql+"TIPOINVIO,";
    p_cSql = p_cSql+"TIPOCOMU,";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aesaldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000006F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO1,";
    p_cSql = p_cSql+"RAPINVIO1,";
    p_cSql = p_cSql+"TPRINVIO1,";
    p_cSql = p_cSql+"INIINVIO1,";
    p_cSql = p_cSql+"FININVIO1,";
    p_cSql = p_cSql+"TIPINVIO1,";
    p_cSql = p_cSql+"TPCINVIO1,";
    p_cSql = p_cSql+"MODINVIO1,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000076(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO2,";
    p_cSql = p_cSql+"RAPINVIO2,";
    p_cSql = p_cSql+"APRINVIO2,";
    p_cSql = p_cSql+"INIINVIO2,";
    p_cSql = p_cSql+"FININVIO2,";
    p_cSql = p_cSql+"FCFINVIO2,";
    p_cSql = p_cSql+"CFSINVIO2,";
    p_cSql = p_cSql+"RUOINVIO2,";
    p_cSql = p_cSql+"COGINVIO2,";
    p_cSql = p_cSql+"NOMINVIO2,";
    p_cSql = p_cSql+"DNSINVIO2,";
    p_cSql = p_cSql+"CNSINVIO2,";
    p_cSql = p_cSql+"PNSINVIO2,";
    p_cSql = p_cSql+"RGSINVIO2,";
    p_cSql = p_cSql+"CSLINVIO2,";
    p_cSql = p_cSql+"PLSINVIO2,";
    p_cSql = p_cSql+"SEXINVIO2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio2",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000078(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO3,";
    p_cSql = p_cSql+"RAPINVIO3,";
    p_cSql = p_cSql+"TPRINVIO3,";
    p_cSql = p_cSql+"ANNINVIO3,";
    p_cSql = p_cSql+"VALINVIO3,";
    p_cSql = p_cSql+"IM1INVIO3,";
    p_cSql = p_cSql+"FI1INVIO3,";
    p_cSql = p_cSql+"IM2INVIO3,";
    p_cSql = p_cSql+"FI2INVIO3,";
    p_cSql = p_cSql+"IM3INVIO3,";
    p_cSql = p_cSql+"FI3INVIO3,";
    p_cSql = p_cSql+"IM4INVIO3,";
    p_cSql = p_cSql+"FI4INVIO3,";
    p_cSql = p_cSql+"IM5INVIO3,";
    p_cSql = p_cSql+"FI5INVIO3,";
    p_cSql = p_cSql+"IM6INVIO3,";
    p_cSql = p_cSql+"FI6INVIO3,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio3",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000008C(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"MESE,";
    p_cSql = p_cSql+"TIPOINVIO,";
    p_cSql = p_cSql+"TIPOCOMU,";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aesaldi",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000009A(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO1,";
    p_cSql = p_cSql+"RAPINVIO1,";
    p_cSql = p_cSql+"TPRINVIO1,";
    p_cSql = p_cSql+"INIINVIO1,";
    p_cSql = p_cSql+"FININVIO1,";
    p_cSql = p_cSql+"TIPINVIO1,";
    p_cSql = p_cSql+"TPCINVIO1,";
    p_cSql = p_cSql+"MODINVIO1,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio1",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A1(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO2,";
    p_cSql = p_cSql+"RAPINVIO2,";
    p_cSql = p_cSql+"APRINVIO2,";
    p_cSql = p_cSql+"INIINVIO2,";
    p_cSql = p_cSql+"FININVIO2,";
    p_cSql = p_cSql+"FCFINVIO2,";
    p_cSql = p_cSql+"CFSINVIO2,";
    p_cSql = p_cSql+"RUOINVIO2,";
    p_cSql = p_cSql+"COGINVIO2,";
    p_cSql = p_cSql+"NOMINVIO2,";
    p_cSql = p_cSql+"DNSINVIO2,";
    p_cSql = p_cSql+"CNSINVIO2,";
    p_cSql = p_cSql+"PNSINVIO2,";
    p_cSql = p_cSql+"RGSINVIO2,";
    p_cSql = p_cSql+"CSLINVIO2,";
    p_cSql = p_cSql+"PLSINVIO2,";
    p_cSql = p_cSql+"SEXINVIO2,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio2",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000A3(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO3,";
    p_cSql = p_cSql+"RAPINVIO3,";
    p_cSql = p_cSql+"TPRINVIO3,";
    p_cSql = p_cSql+"ANNINVIO3,";
    p_cSql = p_cSql+"VALINVIO3,";
    p_cSql = p_cSql+"IM1INVIO3,";
    p_cSql = p_cSql+"FI1INVIO3,";
    p_cSql = p_cSql+"IM2INVIO3,";
    p_cSql = p_cSql+"FI2INVIO3,";
    p_cSql = p_cSql+"IM3INVIO3,";
    p_cSql = p_cSql+"FI3INVIO3,";
    p_cSql = p_cSql+"IM4INVIO3,";
    p_cSql = p_cSql+"FI4INVIO3,";
    p_cSql = p_cSql+"IM5INVIO3,";
    p_cSql = p_cSql+"FI5INVIO3,";
    p_cSql = p_cSql+"IM6INVIO3,";
    p_cSql = p_cSql+"FI6INVIO3,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio3",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000D0(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000000DA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+"TIPINVIO,";
    p_cSql = p_cSql+"TPCINVIO,";
    p_cSql = p_cSql+"DATINVIO,";
    p_cSql = p_cSql+"ANNINVIO,";
    p_cSql = p_cSql+"MESINVIO,";
    p_cSql = p_cSql+"FLEINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000169(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"IDBASE,";
    p_cSql = p_cSql+"TIPO,";
    p_cSql = p_cSql+"TIPOINVIO,";
    p_cSql = p_cSql+"ANNO,";
    p_cSql = p_cSql+"MESE,";
    p_cSql = p_cSql+"TIPOCOM,";
    p_cSql = p_cSql+"RAPPORTO,";
    p_cSql = p_cSql+"NOMEFILE,";
    p_cSql = p_cSql+"PROG,";
    p_cSql = p_cSql+"IDIDBASE,";
    p_cSql = p_cSql+"OLDDATA,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"aefaminvio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000180(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_0000018F(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+"TIPINVIO,";
    p_cSql = p_cSql+"TPCINVIO,";
    p_cSql = p_cSql+"DATINVIO,";
    p_cSql = p_cSql+"ANNINVIO,";
    p_cSql = p_cSql+"MESINVIO,";
    p_cSql = p_cSql+"FLEINVIO,";
    p_cSql = p_cSql+"PRTINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001BB(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001CA(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+"TIPINVIO,";
    p_cSql = p_cSql+"TPCINVIO,";
    p_cSql = p_cSql+"DATINVIO,";
    p_cSql = p_cSql+"ANNINVIO,";
    p_cSql = p_cSql+"MESINVIO,";
    p_cSql = p_cSql+"FLEINVIO,";
    p_cSql = p_cSql+"PRTINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio",true);
    return p_cSql;
  }
  protected static String GetFieldsName_000001F6(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"nomefile,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"tmp_list_imprich",true);
    return p_cSql;
  }
  protected static String GetFieldsName_00000205(CPContext p_Ctx,CPPhTableWrInfo p_oWrInfo) {
    String p_cSql = "";
    p_cSql = p_cSql+"CODINVIO,";
    p_cSql = p_cSql+"TIPINVIO,";
    p_cSql = p_cSql+"TPCINVIO,";
    p_cSql = p_cSql+"DATINVIO,";
    p_cSql = p_cSql+"ANNINVIO,";
    p_cSql = p_cSql+"MESINVIO,";
    p_cSql = p_cSql+"FLEINVIO,";
    p_cSql = p_cSql+"PRTINVIO,";
    p_cSql = p_cSql+p_oWrInfo.InsertFields();
    p_cSql = CPLib.AddCPCCCHKName(p_Ctx,p_cSql,"sid_invio",true);
    return p_cSql;
  }
}
